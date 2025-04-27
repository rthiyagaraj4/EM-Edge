<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></title>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()'>
<form name='PatEncounterDetailsForm' id='PatEncounterDetailsForm' >
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String Patient_Id = request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");
	String srl_no = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String diag_code = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");	
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;

	
	
	String Patient_class_desc = "";
	String facility_name = "";
	String visit_adm_datetime = "";
	String locn_desc = "";
	String pract_name = "";
	
	String sql = "";
//	String classValue = "";
	int i = 0;
	try
	{
		con = ConnectionManager.getConnection(request);

		//sql = "select (select short_desc from am_patient_class where patient_class=c.patient_class) Patient_class_desc,(select facility_name from sm_facility_param where facility_id=c.facility_id) facility_name      ,to_char(c.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_datetime      ,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN (SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=C.FACILITY_ID  AND NURSING_UNIT_CODE=c.ASSIGN_CARE_LOCN_CODE ) ELSE (SELECT SHORT_DESC FROM OP_CLINIC WHERE FACILITY_ID=C.FACILITY_ID  AND CLINIC_CODE=c.ASSIGN_CARE_LOCN_CODE )	END LOCN_DESC ,(select short_name from am_practitioner where practitioner_id=c.ATTEND_PRACTITIONER_ID) pract_name from pr_problem a    ,pr_problem_enc_dtl b  ,pr_encounter c where a.patient_id= ? and a.srl_no= ? and b.patient_id=a.patient_id and b.SRL_NO = a.SRL_NO and c.facility_id=b.facility_id and c.encounter_id=b.encounter_id  order by visit_adm_datetime ";

		//sql="select AM_GET_DESC.AM_PATIENT_CLASS(c.patient_class,?,'2') Patient_class_desc,SM_GET_DESC.SM_FACILITY_PARAM(c.facility_id,?,'1') facility_name      ,to_char(c.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_datetime ,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(c.facility_id,c.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(C.FACILITY_ID,c.ASSIGN_CARE_LOCN_CODE,?,'1') 	END LOCN_DESC ,AM_GET_DESC.AM_PRACTITIONER(C.ATTEND_PRACTITIONER_ID,?,'2')  pract_name from pr_problem a    ,pr_problem_enc_dtl b  ,pr_encounter c where a.patient_id= ? and a.srl_no= ? and b.patient_id=a.patient_id and b.SRL_NO = a.SRL_NO and c.facility_id=b.facility_id and c.encounter_id=b.encounter_id  order by visit_adm_datetime";


		
	/*sql = "SELECT  A.ENCOUNTER_ID,TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME,A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE,A.ASSIGN_CARE_LOCN_TYPE,A.ASSIGN_CARE_LOCN_CODE,DECODE (A.ASSIGN_CARE_LOCN_TYPE,'C', OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'),'N', IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'))||'/'||AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,?,'2') ASSIGN_CARE_LOCN_DESC,A.ASSIGN_ROOM_NUM ,A.ASSIGN_BED_NUM , A.ATTEND_PRACTITIONER_ID ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,'1') PRACTITIONER_NAME ,a.patient_class PATIENT_CLASS_DESC ,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1') SERVICE_DESC  FROM PR_ENCOUNTER A  WHERE  A.FACILITY_ID = ?  AND A.ENCOUNTER_ID = NVL (NULL, A.ENCOUNTER_ID)  AND A.PATIENT_ID = ?  ORDER BY ENCOUNTER_DATE DESC";
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(7,p_facility_id);
		pstmt.setString(6,Patient_Id); */

		//sql = "SELECT  A.ENCOUNTER_ID,(select facility_name from sm_facility_param where facility_id=A.facility_id) facility_name,TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE,A.ASSIGN_CARE_LOCN_TYPE,A.ASSIGN_CARE_LOCN_CODE,DECODE (A.ASSIGN_CARE_LOCN_TYPE,'C', OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'),'N', IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'))||'/'||AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,?,'2') ASSIGN_CARE_LOCN_DESC,A.ASSIGN_ROOM_NUM ,A.ASSIGN_BED_NUM , A.ATTEND_PRACTITIONER_ID ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,'1') PRACTITIONER_NAME ,a.patient_class PATIENT_CLASS_DESC ,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1') SERVICE_DESC  FROM PR_ENCOUNTER A  WHERE  A.FACILITY_ID = ?  AND A.ENCOUNTER_ID = NVL (NULL, A.ENCOUNTER_ID)  AND A.PATIENT_ID = ?  ORDER BY ENCOUNTER_DATE DESC";
		sql = "SELECT distinct A.ENCOUNTER_ID,(select facility_name from sm_facility_param where facility_id=A.facility_id) facility_name, TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE, A.ASSIGN_CARE_LOCN_TYPE,A.ASSIGN_CARE_LOCN_CODE, DECODE (A.ASSIGN_CARE_LOCN_TYPE,'C', OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'2'), 'N', IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'))||'/'|| AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,?,'2') ASSIGN_CARE_LOCN_DESC, A.ASSIGN_ROOM_NUM ,A.ASSIGN_BED_NUM , A.ATTEND_PRACTITIONER_ID , AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,'2') PRACTITIONER_NAME , a.patient_class PATIENT_CLASS_DESC ,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1') SERVICE_DESC   FROM PR_ENCOUNTER A , PR_DIAGNOSIS_ENC_DTL B  WHERE  A.FACILITY_ID = ?   AND A.PATIENT_ID = ?  AND A.ENCOUNTER_ID = B.ENCOUNTER_ID  AND A.FACILITY_ID = B.FACILITY_ID  AND A.PATIENT_ID = B.PATIENT_ID AND  B.TERM_SET_ID = ? and TERM_CODE=? and OCCUR_SRL_NO=? ORDER BY ENCOUNTER_DATE DESC";
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,p_facility_id);
		pstmt.setString(7,Patient_Id);		
		pstmt.setString(8,term_set_id);		
		pstmt.setString(9,diag_code);		
		pstmt.setString(10,srl_no);		
		rs = pstmt.executeQuery();
%>
	<table border=1 cellpadding='3' cellspacing='0' width="100%">
		<tr>
			<td class='columnheader'  ><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></td>
			<td class='columnheader' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td class='columnheader' ><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
			<td class='columnheader' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='columnheader' ><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
		</tr>

<%

		/*while(rs.next())
		{
			Patient_class_desc = rs.getString("Patient_class_desc");
			
			facility_name = rs.getString("facility_name");
			visit_adm_datetime = rs.getString("visit_adm_datetime");
			locn_desc = rs.getString("locn_desc");
			pract_name = rs.getString("pract_name");
			if(i%2 == 0)
				classValue = "QRYODD";
			else
				classValue = "QRYEVEN";
			
			out.println("<tr><td class='label'  font='2'>"+visit_adm_datetime+"</td>");	
			out.println("<td class='label'  class="+classValue+" font='2'>"+Patient_class_desc+"</td>");	
			out.println("<td class='label'  class="+classValue+" font='2'>"+facility_name+"</td>");
			out.println("<td class='label'  class="+classValue+" font='2'>"+locn_desc+"</td>");		
			out.println("<td class='label'  class="+classValue+" font='2'>"+pract_name+"</td></tr");		
			
			i++;
			*/
			while(rs.next())
		{
			//Patient_class_desc = rs.getString("service_desc");
			Patient_class_desc = rs.getString("PATIENT_CLASS_DESC") == null ? "&nbsp;" : rs.getString("PATIENT_CLASS_DESC");
			
			facility_name = rs.getString("facility_name") == null ? "&nbsp;" : rs.getString("facility_name");
			visit_adm_datetime = rs.getString("VISIT_ADM_DATE_TIME") == null ? "&nbsp;" : rs.getString("VISIT_ADM_DATE_TIME");
			locn_desc = rs.getString("ASSIGN_CARE_LOCN_DESC") == null ? "&nbsp;" : rs.getString("ASSIGN_CARE_LOCN_DESC");
			pract_name = rs.getString("practitioner_name") == null ? "&nbsp;" : rs.getString("practitioner_name");			
			
			out.println("<tr><td  font='2' class='gridData'>"+visit_adm_datetime+"</td>");	
			out.println("<td   font='2' class='gridData'>"+Patient_class_desc+"</td>");	
			out.println("<td   font='2' class='gridData'>"+facility_name+"</td>");
			out.println("<td   font='2' class='gridData'>"+locn_desc+"</td>");		
			out.println("<td  font='2' class='gridData'>"+pract_name+"</td></tr");		
			
			i++;
	}
	if(i == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));top.window.close()</script>");
	}
	
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();

%>	
</body>
</html>
<%
}
catch(Exception e)
{
	//out.println("Exception @ PatEncounterDetails.jsp "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

