<!DOCTYPE html>

<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,java.io.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//out.println("sStyle==>" +sStyle);%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src="../../eOA/js/ChangeDate.js" language="JavaScript"></Script>
 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
 <script language="javascript" src="../../eCommon/js/DateUtils.js"></script> 
  <script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
 <style type="text/css">
		table.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}
		table.mt th {border-width: 1px;padding: 1px;white-space: normal; text-align:left;word-wrap:normal;}
		table.mt td {white-space:normal;word-wrap: break-word; word-break: break-all;}
</style>
<% 
		request.setCharacterEncoding("UTF-8");	
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		Connection con = null;
		PreparedStatement pstmt_label		= null;
				
		ResultSet rs32= null;
		String wrap_reqd="";
		wrap_reqd="nowrap";
		String facilityid=(String)session.getValue("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
		StringBuffer  sql_label =new StringBuffer();
		String show_vip="N";
		
try
{
		String clinic_code=(String)request.getParameter("clinic_code");
		if( clinic_code == null|| clinic_code.equals("null")) clinic_code="";
		String practitioner_id=(String)request.getParameter("practitioner_id");
		if( practitioner_id == null|| practitioner_id.equals("null")) practitioner_id="";
		String Date=(String)request.getParameter("Date");
		String res_type=request.getParameter("res_type");
			
		String clinic_type=request.getParameter("clinic_type");
		String from_page=request.getParameter("from_page");
	
		String oper_stn_id=request.getParameter("oper_stn_id");
			if(oper_stn_id == null) oper_stn_id="";
			if(oper_stn_id!=null && !oper_stn_id.equals("")){
				show_vip="Y";
			}
		String rd_appt_yn=request.getParameter("rd_appt_yn");
		String colour_indicator="";
		String care_locn_type_ind="";
		String res_ind="";
		String nowarp1 ="";
		String res_class_desc				="";
		
	con=ConnectionManager.getConnection(request);

	Boolean isRemarksFieldAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "REMARKS_FOR_OTHERS"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		
	
	if(res_type.equals("P"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R"))
	{
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O"))
	{
res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}
		String care_locn_ind_desc	  		="";
		
		String P_O_CLINIC             		="";       
		String P_O_FROM_TIME          		="";
		String P_O_TO_TIME            		="";
		String P_O_APPT_REF_NO        		="";
		String P_O_PATIENT_NAME       		="";
		String P_O_PATIENT_ID         		="";
		String P_O_VISIT_TYPE_DESC       	="";
		String P_O_CONTACT_REASON_CODE      ="";
		String P_O_PATIENT_GENDER       	="";
		String P_O_PATIENT_AGE      		="";
		String P_O_VISIT_TYPE_IND     		="";
		String date1 						="";
		String sql							="";
		String P_O_practitioner_id			="";
		String oth_contact_no				=""; 
		String res_tel_no					="";
		String P_O_PRACTITIONER_NAME       	="";
		String PATIENT_CAT_CODE       		="";
		String APPT_REMARKS		      		=""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		String practName ="";
		String findme ="";
		int i = 0;	
		int cnt = 0;
		String classValue="";
		
	sql_label.append("SELECT NVL (TO_CHAR (appt_slab_from_time, 'hh24:mi'),' ') appt_slab_from_time,NVL (TO_CHAR (appt_slab_to_time, 'hh24:mi'), ' ') appt_slab_to_time,appt_ref_no,patient_id,DECODE ('"+locale+"','"+locale+"', patient_name,NVL (patient_name_loc_lang, patient_name))patient_name,gender,mp_get_age_ymdh (date_of_birth)age,    op_get_desc.op_visit_type(facility_id,appt_type_code,'"+locale+"','2') visit_type_short_desc,(select contact_reason from am_contact_reason_lang_vw where  contact_reason_code=oa_appt_patient_vw.TRANS_EXCEED_REASON_CODE and nvl(trans_exceed_reason_yn,'N') = 'Y' and  language_id='"+locale+"')translator_override_reason,(SELECT OTH_CONTACT_NO FROM oa_appt WHERE appt_ref_no = oa_appt_patient_vw.appt_ref_no)oth_contact_no,(SELECT RES_TEL_NO FROM oa_appt WHERE appt_ref_no = oa_appt_patient_vw.appt_ref_no)RES_TEL_NO,op_get_desc.op_clinic(facility_id,clinic_code,'"+locale+"','1')clinic_name,DECODE(resource_class,'P',am_get_desc.am_practitioner(practitioner_id,'"+locale+"','1'),'R',am_get_desc.am_facility_room(facility_id,practitioner_id,'"+locale+"','2'),'E',am_get_desc.am_resource(facility_id,practitioner_id,'"+locale+"','2'),'O',am_get_desc.am_resource(facility_id,practitioner_id,'"+locale+"','2'))practitioner_full_name,sm_get_desc.sm_appl_user(modified_by_id, '"+locale+"', '1') modified_by,sm_get_desc.sm_appl_user(added_by_id, '"+locale+"', '1')added_by,TO_CHAR (added_date, 'dd/mm/yyyy hh24:mi') added_date, facility_id,TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi')modified_date,am_get_desc.am_speciality (speciality_code,'"+locale+"','2') speciality_desc,         sm_get_desc.sm_facility_param (facility_id,'"+locale+"',1)facility_name,(SELECT deceased_yn FROM mp_patient WHERE patient_id = oa_appt_patient_vw.patient_id) deceased_yn,(SELECT color_indicator FROM op_visit_type     WHERE facility_id = oa_appt_patient_vw.facility_id AND visit_type_code = oa_appt_patient_vw.appt_type_code)color_indicator,(SELECT am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1)FROM oa_appt WHERE facility_id = oa_appt_patient_vw.facility_id AND appt_ref_no = oa_appt_patient_vw.appt_ref_no)contact_reason,care_locn_type_ind,resource_class,PATIENT_CAT_CODE,appt_remarks FROM oa_appt_patient_vw WHERE facility_id = '"+facilityid+"'AND appt_date = TO_DATE (NVL ('"+Date+"','01/01/1400'),'dd/mm/yyyy')AND UPPER (patient_name) LIKE UPPER ('%%')"); ////Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	
	
	if(!clinic_code.equals("")){
		sql_label.append("AND CLINIC_CODE = '"+clinic_code+"'");
			
	if(!res_type.equals("")){
			sql_label.append("AND resource_class = '"+res_type+"'");
	} 
		sql_label.append("AND care_locn_type_ind = '"+clinic_type+"'");
		sql_label.append("ORDER BY resource_class,practitioner_full_name,appt_slab_from_time");
		
	}else{
	
	if(!practitioner_id.equals("")){
		sql_label.append("AND practitioner_id = '"+practitioner_id+"'");
	}
		sql_label.append("AND resource_class = '"+res_type+"'");
	if(!clinic_type.equals("")){
			sql_label.append("AND care_locn_type_ind = '"+clinic_type+"'");
	} 
		sql_label.append("ORDER BY care_locn_type_ind,clinic_name,appt_slab_from_time asc");
	}	
		pstmt_label = con.prepareStatement(sql_label.toString());
		rs32 = pstmt_label.executeQuery();
		sql_label=null;
%>
		<html>
		<head>	

	</head>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


				<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<body onLoad='visiblelity()' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onscroll="scrollheader();">

<form name="single_pract" id="single_pract">
	<input type='hidden' name='help_function_id' id='help_function_id' value='SCHEDULE_APPOINTMENT'>	
<% while(rs32.next() ){
	if( cnt == 0 ){
%>
	<table border='1' width='99%' style='border-spacing:0px ;border-collapse: collapse;' id='dataTable' class='mt'>
	<tr>
	<th align='left' width='4%'><div  id='head1'  class='myClass' nowrap ><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='4%'><div  id='head2'  class='myClass' nowrap ><fmt:message key="Common.totime.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='4%'><div  id='head3'  class='myClass' nowrap ><fmt:message key="Common.isinpatient.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='21%'><div  id='head4'  class='myClass' nowrap ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='5%'><div  id='head5'  class='myClass' nowrap ><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='12%' ><div  id='head6'  class='myClass' nowrap ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='15%' ><div  id='head7'  class='myClass' nowrap ><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></div></th>
	<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
	<%if(isRemarksFieldAppl){%>
	<th align='left' width='15%' ><div  id='head10'  class='myClass' nowrap ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></div></th> 
	<%}%>
	<th align='left' width='12%'><div  id='head8'  class='myClass' nowrap ><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='15%' ><div  id='head9'  class='myClass' nowrap ><fmt:message key="eOA.ApptGivenBy.label" bundle="${oa_labels}"/></div></th>
</tr>	
<%
	 }

if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
		        classValue = "QRYODD" ;

					
					P_O_FROM_TIME                  =rs32.getString("appt_slab_from_time" );	
					if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
					P_O_TO_TIME = rs32.getString("appt_slab_to_time"); 
					if( P_O_TO_TIME == null) P_O_TO_TIME="";	
					
					P_O_APPT_REF_NO = rs32.getString("APPT_REF_NO"); 
					
					P_O_PATIENT_NAME = rs32.getString("patient_name"); 
					if( P_O_PATIENT_NAME == null) P_O_PATIENT_NAME="";	
					P_O_PATIENT_ID = checkForNull(rs32.getString("patient_id")); 
					P_O_PATIENT_GENDER = checkForNull(rs32.getString("gender")); 
					P_O_PATIENT_AGE= checkForNull(rs32.getString("age"));
					
					P_O_VISIT_TYPE_DESC = rs32.getString("visit_type_short_desc"); 
					P_O_CONTACT_REASON_CODE = checkForNull(rs32.getString("contact_reason")); 
					APPT_REMARKS = checkForNull(rs32.getString("appt_remarks")); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
					care_locn_type_ind  = rs32.getString("care_locn_type_ind");
					res_ind  = rs32.getString("resource_class");
					res_tel_no = checkForNull(rs32.getString("RES_TEL_NO"));
					oth_contact_no = checkForNull(rs32.getString("oth_contact_no"));
					colour_indicator=checkForNull(rs32.getString("COLOR_INDICATOR"));	
					PATIENT_CAT_CODE=checkForNull(rs32.getString("PATIENT_CAT_CODE"));
					practName = rs32.getString("practitioner_full_name")==null?"":rs32.getString("practitioner_full_name");
						
	if(care_locn_type_ind.equals("C")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(care_locn_type_ind.equals("E")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(care_locn_type_ind.equals("D")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}
	if(res_ind.equals("P"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_ind.equals("E"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_ind.equals("R"))
	{
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_ind.equals("O"))
	{
res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}	

		if(clinic_code.equals("")){
		if(!P_O_CLINIC.equals(rs32.getString("clinic_name"))){
		%>
			<tr>
			
<td class='<%=classValue%>' <%=wrap_reqd%> width='50%' colspan='9'><b><%=care_locn_ind_desc%>/<%=rs32.getString("clinic_name") %></td>
			</tr>
			<%}
			P_O_CLINIC			= rs32.getString("clinic_name");
			}
			else{
			if(!P_O_PRACTITIONER_NAME.equals(practName)){
			
			%>
			<tr>
<td class='<%=classValue%>' <%=wrap_reqd%> width='50%' colspan='9'><b><%=res_class_desc%>/<%=practName%></td>
			</tr>
			<%
			}
			P_O_PRACTITIONER_NAME			= practName;	}%>
			<tr> 
				<td <%=wrap_reqd%> class='<%=classValue%>'  ><%=P_O_FROM_TIME%></td>
				<td <%=wrap_reqd%> class='<%=classValue%>'  ><%=P_O_TO_TIME%></td>
				<%
webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
patdata.setFacility_id(facilityid);			
				String isInpatient = patdata.CheckInPatient(con,P_O_PATIENT_ID,facilityid);
if(!isInpatient.equals("CURRENTLY_IN_PATIENT")) {
	%><td <%=wrap_reqd%> class='<%=classValue%>' >&nbsp;</td><%
}else{%>
<td <%=wrap_reqd%> class='<%=classValue%>'><center><img src='../../eCommon/images/inpatient.gif'><center></td>
<%} if(!PATIENT_CAT_CODE.equals("")){findme=PATIENT_CAT_CODE.substring(0,1);} else findme="";%>

			<td <%=wrap_reqd%> class='<%=classValue%>'><%if(!P_O_PATIENT_ID.equals("")){%><%=P_O_PATIENT_ID%>,<%=P_O_PATIENT_NAME%>,<%=P_O_PATIENT_AGE%>,<%=P_O_PATIENT_GENDER%><%}else{%><%=P_O_PATIENT_NAME%>,<%=P_O_PATIENT_AGE%>,<%=P_O_PATIENT_GENDER%><%}if(findme.equals("V")){%><img src='../../eCommon/images/PI_VIP.gif' ><%}%></td>
				<td <%=wrap_reqd%> class='<%=classValue%>' ><%=P_O_APPT_REF_NO%></td>
				<td <%=wrap_reqd%> class='<%=classValue%>'  style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%=P_O_VISIT_TYPE_DESC%></td> <%/*modified for this CRF [Bru-HIMS-CRF-177]*/%>
				<%if(!P_O_CONTACT_REASON_CODE.equals("")){%>
				<td <%=wrap_reqd%> class='<%=classValue%>' ><%=P_O_CONTACT_REASON_CODE%></td>
				<%}else{%>
				<td <%=wrap_reqd%> class='<%=classValue%>' >&nbsp;</td>
				<%}%>
				<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
				<%if(isRemarksFieldAppl){%>
					<%if(!APPT_REMARKS.equals("")){%>
					<td <%=wrap_reqd%> class='<%=classValue%>' ><%=APPT_REMARKS%></td>
					<%}else{%>
					<td <%=wrap_reqd%> class='<%=classValue%>' >&nbsp;</td>
					<%}%>
				<%}%>
				<!--End ML-MMOH-CRF-1114-->
				<%if((!res_tel_no.equals(""))&&(!oth_contact_no.equals(""))){%>
				<td <%=wrap_reqd%> class='<%=classValue%>' ><%=res_tel_no%></br><%=oth_contact_no%></td>
				<%}else if(!res_tel_no.equals("")){%>
				<td <%=wrap_reqd%> class='<%=classValue%>' ><%=res_tel_no%></td>
				<%}else if(!oth_contact_no.equals("")) {%>
				<td <%=wrap_reqd%> class='<%=classValue%>' ><%=oth_contact_no%></td>
				<%}else{%>
				<td <%=wrap_reqd%> class='<%=classValue%>' >&nbsp;</td>
				<%}%>
				<td <%=wrap_reqd%> class='<%=classValue%>' ><%=rs32.getString("added_by")%></td>	
				
			</tr>
		
	<%	
	i++;
	cnt++;

}
if(rs32 !=null) rs32.close();


%>
</table>
<%if(cnt == 0){%>
<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));
</script>

<%}else{%>
<script> fxheaderInit('dataTable',420);	</script>
<%
}

if(pstmt_label !=null)pstmt_label.close();
}catch(Exception e) { 
	e.printStackTrace(); 
}finally{
	ConnectionManager.returnConnection(con,request);
}
%>
      
</form>
</body>
		
</html>

<%!

public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
%>

