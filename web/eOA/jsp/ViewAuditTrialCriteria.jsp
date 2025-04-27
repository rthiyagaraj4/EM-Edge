<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>
      
<html>  
<title><fmt:message key="eOA.Viewaudittrial.label" bundle="${common_labels}"/></title>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eOA/js/AppointmentDetails.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");	
%>
<%
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
String p_sql = "";
String patientid="";
String pname="";
//String dob="";
String gender="";
//String modifiedbyid="";
//String modifieddate="";
String resource="";
String res_class_desc="";
String genderdesc="";
String resource_name="";
String apptrefno=request.getParameter("apptrefno1");
//String date=request.getParameter("date");
//String loc=request.getParameter("loc");
//String res=request.getParameter("res");
String locale			= (String)session.getAttribute("LOCALE");
//String facility_id = (String)session.getValue("facility_id");  
try
{
	con	= ConnectionManager.getConnection(request);
//	p_sql	= "SELECT PATIENT_ID,decode('"+locale+"', 'en', PATIENT_NAME, nvl(PATIENT_NAME_LOC_LANG, PATIENT_NAME)) PATIENT_NAME   FROM OA_APPT  WHERE APPT_REF_NO='"+apptrefno+"'";
	p_sql	= "SELECT PATIENT_ID,decode(?, 'en', PATIENT_NAME, nvl(PATIENT_NAME_LOC_LANG, PATIENT_NAME)) PATIENT_NAME   FROM OA_APPT  WHERE APPT_REF_NO=?";
	stmt	= con.createStatement();
	//rs		= stmt.executeQuery(p_sql);
	pstmt = con.prepareStatement(p_sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,apptrefno);
	rs = pstmt.executeQuery();
	while (rs!=null && rs.next())
	{
	patientid	= (rs.getString("PATIENT_ID")==null?"&nbsp;":rs.getString("PATIENT_ID"));
	pname = (rs.getString("PATIENT_NAME")==null?"&nbsp;":rs.getString("PATIENT_NAME"));
	if(resource_name==null)resource_name="";
	}
	if(rs!=null )rs.close();
	if(stmt!=null )stmt.close();

if(gender.equals("M")) 
				{
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}
				else if(gender.equals("F")) {
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				else if(gender.equals("U")) {
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}
if(resource.equals("P")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
}else if(resource.equals("E")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(resource.equals("R")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(resource.equals("O")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
}else if(resource.equals("B")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
}

%>

<body onKeyDown = 'lockKey()'>
<form name='view_audittrail' id='view_audittrail'  method='post'>
 <table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' >

	<tr>
			<td  class='label'  nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' nowrap><%=apptrefno%></td>
   <td class='label'  nowrap> <fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' nowrap><%=patientid%></td>
			<td class='label'  nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' nowrap><%=pname%></td>
	</tr>
	</table>
	 
</body>
<%}catch(Exception e){
	//out.println("Exception at Patient ID level :" + e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
} finally{
		if(rs!=null) rs.close();
	if (stmt!=null )stmt.close();
    	if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }
%>
</html>

