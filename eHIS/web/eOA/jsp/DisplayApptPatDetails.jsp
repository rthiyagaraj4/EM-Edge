<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<html>
<head>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOA/js/AppointmentDetails.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
ResultSet rs=null;
//Statement stmt=null;
//Statement stmt1=null;
PreparedStatement pstmt =null;

String practitioner_id=(String)request.getParameter("i_practitioner_id");
if( practitioner_id == null || practitioner_id.equals("null") ) practitioner_id="";
String clinic_code=(String)request.getParameter("i_clinic_code");
if( clinic_code == null || clinic_code.equals("null") ) clinic_code="";
String i_appt_date=request.getParameter("i_appt_date");
if(i_appt_date ==null ) i_appt_date="";
String facilityid=(String)session.getValue("facility_id");
String old_date=(String)request.getParameter("i_appt_date");
if(old_date  == null || old_date.equals("null")) old_date="";
String old_from_time=(String)request.getParameter("i_from_time");
if(old_from_time  == null || old_from_time.equals("null")) old_from_time="";
String old_to_time=(String)request.getParameter("i_to_time");
if(old_to_time  == null || old_to_time.equals("null")) old_to_time="";
String appt_ref_no=(String)request.getParameter("i_appt_ref_no");
if(appt_ref_no  == null || appt_ref_no.equals("null")) appt_ref_no="";

String clinic_type=request.getParameter("clinic_type");
String res_type=request.getParameter("res_type");

if (clinic_type==null) clinic_type = "C";
if (res_type==null) res_type = "P";

String res_class_desc="";
String alcn="";



if(res_type.equals("P")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
}else if(res_type.equals("E")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(res_type.equals("R")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(res_type.equals("O")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
}


String locale=(String)session.getAttribute("LOCALE");

String practitioner_full_name="";
String patient_id="";
String patient_name="";
String gender="";
String age="";
StringBuffer pline=new StringBuffer("");
String visit_type_short_desc="";
try {
	con = ConnectionManager.getConnection(request);

	
	String sql_pat_details	= "select patient_id, patient_name, get_age(date_of_birth) age, gender, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,?,'2') visit_type_short_desc, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_full_name from oa_appt where facility_id = ? and appt_ref_no=? ";
	pstmt=con.prepareStatement(sql_pat_details);
	pstmt.setString(1,locale);
	pstmt.setString(2,locale);
	pstmt.setString(3,locale);
	pstmt.setString(4,locale);
	pstmt.setString(5,facilityid);
	pstmt.setString(6,appt_ref_no);
	
	rs = pstmt.executeQuery();
	if(rs !=null && rs.next()){
		patient_id		=rs.getString("patient_id");
		patient_name	=rs.getString("patient_name");
		age				=rs.getString("age");
		gender			=rs.getString("gender");
	   

		if(gender.equals("M"))
		{
		gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		} else if(gender.equals("F"))
		{
		gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		} else if(gender.equals("F"))
		{
		gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		practitioner_full_name=rs.getString("practitioner_full_name");
		visit_type_short_desc=rs.getString("visit_type_short_desc");
		if (visit_type_short_desc==null)visit_type_short_desc="";
	}
	if(practitioner_full_name==null)practitioner_full_name="";
	if(patient_id!=null){
		pline.append(patient_id +",");
	}
	if(patient_name!=null){
		pline.append(patient_name +",");
	}
	if(age!=null){
		pline.append(age +",");
	}
	if(gender!=null){
		pline.append(gender);
	}

	if(rs!=null)			rs.close();
	if(pstmt!=null)		pstmt.close();

	String sql1="";
	if(!practitioner_id.equals("")){
		sql1="select alcn_criteria from oa_clinic_schedule where CLINIC_CODE=? and clinic_date=to_date(?,'dd/mm/yyyy') AND practitioner_id = ?";
	}else{
		sql1="select alcn_criteria from oa_clinic_schedule where CLINIC_CODE=? and clinic_date=to_date(?,'dd/mm/yyyy') AND practitioner_id is null";
	}
	pstmt=con.prepareStatement(sql1);
	pstmt.setString(1,clinic_code);
	pstmt.setString(2,i_appt_date);
	if(!practitioner_id.equals("")){
		pstmt.setString(3,practitioner_id);
	}
	rs=pstmt.executeQuery();
	if(rs!=null && rs.next()){
		alcn=rs.getString("alcn_criteria") ;
		if(alcn==null) alcn="";
	}
	if(rs!=null)			rs.close();
	if(pstmt!=null)			pstmt.close();
}catch(Exception e){
	//out.println("ERROR@1"+e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	ConnectionManager.returnConnection(con,request);
}
String old_date_display=DateUtils.convertDate(old_date,"DMY","en",locale);
%>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload="checkPatCnclReason();">
<form name="single_pract" id="single_pract">

<input type='hidden' name='help_function_id' id='help_function_id' value='RESCHEDULE_APPOINTMENT'>
	<table cellspacing='0' width='100%' cellpadding='0' border='0'>
	<tr>
		<td colspan='4' align='left' class='PATIENTLINECOLOR'><b><%=pline.toString()%></b></td>
		<%pline.setLength(0);%>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
		<td  class='fields'><b><%=appt_ref_no%></b></td>
		
		<td class='label'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/>/<fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>
		<td  class='fields'><b><%=old_date_display%>  <%=old_from_time%> - <%=old_to_time%></b></td>
	
	</tr>

	<tr>
		<td  class='label' ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>

		<td  class='fields'><b><%=res_class_desc%></b></td>

		<td  class='label' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

		<td  class='fields'><b><%=practitioner_full_name%></b></td>
	</tr>

		<tr>
		
		<td  class='label' ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
		<td  class='fields' colspan='4'><b><%=visit_type_short_desc%></b></td>
		<%if((alcn!=null)&&(alcn!="")){%>
					   <td class='label' width='30%'><a href="javascript:allocationDetails('<%=clinic_code%>','<%=i_appt_date%>','<%=practitioner_id%>')"><b><fmt:message key="eOA.Allocation.label" bundle="${oa_labels}"/></b></a></td>
			<%}%>
	</tr>
	<!--Bru-HIMS-CRF 169 changes start -->
	<input type='hidden' name='pat_cncl_count' id='pat_cncl_count' value=''>
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<!--Bru-HIMS-CRF 169 changes end -->
</table>
</form>
</body>
</html>

