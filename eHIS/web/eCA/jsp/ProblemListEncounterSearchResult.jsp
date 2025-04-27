<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title></title>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script>
  function close_window(encounter_id)
  {
	//window.parent.returnValue = encounter_id;
	//window.parent.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = encounter_id;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
  }
</script>
</head>

 <%
Connection con = null;
PreparedStatement stmt=null;
ResultSet rs = null;
		java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
		String locale = (String) p.getProperty("LOCALE");

String p_facility_id		= (String) session.getValue( "facility_id" ) ;
//String EncounterID = "";
//request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String sql = "";
String encounter_id = "";
String encounter_date = "";
String assign_care_locn_type_desc = "";
String assign_bed_num = "";
String assign_room_num = "";
String practitioner_name = "";
String patient_class_desc = "";
String service_desc = "";

String ClassValue = "";
int cnt = 0;

try
{
	con = ConnectionManager.getConnection(request);

//	sql = "SELECT  A.ENCOUNTER_ID,TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME,A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE,A.ASSIGN_CARE_LOCN_TYPE,A.ASSIGN_CARE_LOCN_CODE,DECODE (B.CARE_LOCN_TYPE_IND,'C', C.SHORT_DESC,'N', D.SHORT_DESC)||'/'||B.SHORT_DESC ASSIGN_CARE_LOCN_DESC,A.ASSIGN_ROOM_NUM ,A.ASSIGN_BED_NUM , A.ATTEND_PRACTITIONER_ID ,E.PRACTITIONER_NAME ,a.patient_class PATIENT_CLASS_DESC ,(SELECT SHORT_DESC FROM AM_SERVICE WHERE SERVICE_CODE=A.SERVICE_CODE) SERVICE_DESC  FROM PR_ENCOUNTER A , AM_CARE_LOCN_TYPE B , OP_CLINIC C ,  IP_NURSING_UNIT D , AM_PRACTITIONER E  WHERE  A.FACILITY_ID = ?  AND A.ENCOUNTER_ID = NVL (NULL, A.ENCOUNTER_ID)  AND A.PATIENT_ID = ?  AND A.ASSIGN_CARE_LOCN_TYPE = B.LOCN_TYPE  AND A.FACILITY_ID = C.FACILITY_ID(+)   AND  A.ASSIGN_CARE_LOCN_CODE = C.CLINIC_CODE(+) AND A.FACILITY_ID = D.FACILITY_ID(+)  AND  A.ASSIGN_CARE_LOCN_CODE = D.NURSING_UNIT_CODE(+)  AND  A.ATTEND_PRACTITIONER_ID = E.PRACTITIONER_ID(+)  ORDER BY ENCOUNTER_DATE DESC ";


	sql = "SELECT  A.ENCOUNTER_ID,TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME,A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE,A.ASSIGN_CARE_LOCN_TYPE,A.ASSIGN_CARE_LOCN_CODE,DECODE (A.ASSIGN_CARE_LOCN_TYPE,'C', OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'),'N', IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'))||'/'||AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,?,'2') ASSIGN_CARE_LOCN_DESC,A.ASSIGN_ROOM_NUM ,A.ASSIGN_BED_NUM , A.ATTEND_PRACTITIONER_ID ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,'1') PRACTITIONER_NAME ,a.patient_class PATIENT_CLASS_DESC ,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1') SERVICE_DESC  FROM PR_ENCOUNTER A  WHERE  A.FACILITY_ID = ?  AND A.ENCOUNTER_ID = NVL (NULL, A.ENCOUNTER_ID)  AND A.PATIENT_ID = ?  ORDER BY ENCOUNTER_DATE DESC";

	stmt = con.prepareStatement(sql);
	stmt.setString(1,locale);
	stmt.setString(2,locale);
	stmt.setString(3,locale);
	stmt.setString(4,locale);
	stmt.setString(5,locale);
	stmt.setString(6,p_facility_id);
	stmt.setString(7,patient_id);

	rs = stmt.executeQuery();
%>
<table class='grid' border="1" cellpadding="3" cellspacing="0" align='center' width="100%">
	<tr>
		<th class='columnHeadercenter'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="Common.Location.label" bundle="${common_labels}"/> </th>
		<th class='columnHeadercenter'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
	</tr>
<%
	while(rs.next())
	{
		encounter_id				= rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
		encounter_date				= rs.getString("VISIT_ADM_DATE_TIME")==null?"":rs.getString("VISIT_ADM_DATE_TIME");
		assign_care_locn_type_desc	= rs.getString("ASSIGN_CARE_LOCN_DESC")==null?"":rs.getString("ASSIGN_CARE_LOCN_DESC");
		assign_bed_num				= rs.getString("assign_bed_num")==null?"":rs.getString("assign_bed_num");
		assign_room_num				= rs.getString("ASSIGN_ROOM_NUM")==null?"":rs.getString("ASSIGN_ROOM_NUM");
		practitioner_name			= rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
		patient_class_desc			= rs.getString("patient_class_desc")==null?"":rs.getString("patient_class_desc");
		service_desc				= rs.getString("service_desc")==null?"":rs.getString("service_desc");
	
		if(cnt % 2 == 0)
			ClassValue = "gridData";
		else
			ClassValue = "gridData";

		out.println("<tr><td class='"+ClassValue+"'><a class='gridLink' href=\"javascript:close_window('"+encounter_id+"')\">"+encounter_id+"<a class='gridLink'></td>");
		out.println("<td class='"+ClassValue+"'>"+encounter_date+"</td>");
		out.println("<td class='"+ClassValue+"'>"+patient_class_desc+"</td>");
		out.println("<td class='"+ClassValue+"'>"+service_desc+"</td>");
		out.println("<td class='"+ClassValue+"'>"+assign_care_locn_type_desc+"</td>");
		out.println("<td class='"+ClassValue+"'>"+assign_room_num+"</td>");
		out.println("<td class='"+ClassValue+"'>"+assign_bed_num+"</td>");
		out.println("<td class='"+ClassValue+"'>"+practitioner_name+"</td></tr>");

cnt++;
	}
%>
</table>
</html>
<%
}
catch(Exception e)
{
	//out.println("Exception @ try block"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(stmt!=null)
		stmt.close();
	if(rs!=null)
		rs.close();

	ConnectionManager.returnConnection(con,request);
}
%>
