<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
05/03/2013	IN038302, IN038306, IN038354  	System is displaying the linked encounter two times in which the diagnosis is modified.
											System is displaying the non-associated  encounter ID in the linked encounter 
											System is not displaying the linked encounter list for the recorded diagnosis in descending order.
12/03/2013			IN038463		Karthi	Chart Summary->Encounter  2 is not listed in the ?Active Problems Linked Encounter details? dialog box. 						
19/03/2013	 IN038718     		Karthi L	System is displaying the non-associated Encounter ID 1 and Encounter ID 2 in the linked encounter list for the Diagnosis which was recorded in Encounter ID 3
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
	String title = "Active Problems Linked Encounter Details";
%>
<title><%=title%></title>
  	<script src='../../eCommon/js/common.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		String facility_id= (String) session.getValue("facility_id");
		java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) property.getProperty("LOCALE");
	%>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
		Connection conn= null;
		PreparedStatement stmt =null;
		ResultSet rs	 =null;
		String classValue="";
		String patientid = request.getParameter("patient_id") == null?"":request.getParameter("patient_id");
		String term_set_id = request.getParameter("term_set_id") == null?"":request.getParameter("term_set_id");
		String diag_code = request.getParameter("diag_code") == null?"":request.getParameter("diag_code");
		String contentId = request.getParameter("content_id") == null?"":request.getParameter("content_id"); 
		String encounter_id = "";
		String visitdate = ""; 
		String patient_class = ""; 
		String curr_status = "A"; // added for IN038306
		try
		{
			conn = ConnectionManager.getConnection(request);
			
			//String Sql= "select distinct a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class, to_char(e.visit_adm_date_time,'DD/MM/YYYY') visit_date from PR_DIAGNOSIS_STATUS A , pr_encounter e where A.patient_id = ? and A.patient_id=E.patient_id and a.ENCOUNTER_ID=e.ENCOUNTER_ID and a.term_set_id = ? and a.term_code = ? and a.facility_id = ?"; commented for IN038302, IN038306, IN038354	
			//String Sql= "SELECT   distinct a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class,TO_CHAR (e.visit_adm_date_time, 'DD/MM/YYYY') visit_date 	FROM   PR_DIAGNOSIS_STATUS A, pr_encounter e,PR_DIAGNOSIS b WHERE   A.patient_id = ? AND A.patient_id = E.patient_id AND A.patient_id = b.patient_id AND a.ENCOUNTER_ID = e.ENCOUNTER_ID AND a.ENCOUNTER_ID = b.ONSET_ENCOUNTER_ID AND a.term_set_id = ? AND a.term_code = ? AND a.facility_id= ? and b.curr_status = ?  order by visit_date desc" ;// modified for IN038302, IN038306, IN038354(for IN038354 reopened we removed order by encounder_id
			//String Sql = "SELECT DISTINCT a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class, TO_CHAR (e.visit_adm_date_time, 'DD/MM/YYYY') visit_date FROM PR_DIAGNOSIS_STATUS A, pr_encounter e WHERE A.patient_id = ? AND A.patient_id = E.patient_id AND a.ENCOUNTER_ID = e.ENCOUNTER_ID AND a.term_set_id = ? AND a.term_code = ? AND a.facility_id =? AND A.status = ? ORDER BY to_date(visit_date,'DD/MM/YYYY') desc "; // IN038463 //IN038354
			String Sql = " SELECT DISTINCT a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class, TO_CHAR (e.visit_adm_date_time, 'DD/MM/YYYY hh24:mi') visit_date FROM PR_DIAGNOSIS_STATUS A, pr_encounter e, PR_DIAGNOSIS b WHERE A.patient_id = ? AND a.patient_id = e.patient_id AND a.patient_id = b.patient_id AND a.ENCOUNTER_ID = e.ENCOUNTER_ID and a.term_set_id = b.term_set_id and a.term_code = b.term_code AND a.OCCUR_SRL_NO=b.OCCUR_SRL_NO AND a.term_set_id = ? AND a.term_code = ? AND a.facility_id =?      AND B.CURR_STATUS =? ORDER BY to_date(visit_date,'DD/MM/YYYY hh24:mi') desc"; // IN038718                                 
      
			stmt = conn.prepareStatement(Sql);
			stmt.setString(1,patientid);
			stmt.setString(2,term_set_id);
			stmt.setString(3,diag_code);
			stmt.setString(4,facility_id);
			stmt.setString(5,curr_status); //IN038302, IN038306, IN038354	 
			rs = stmt.executeQuery();
	%>

			<table class='grid' align='center' width='100%'>
			<tr>
				<td align='center'  nowrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></font></td> 	
				<td align='center'  nowrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></font></td>
				<td align='center'  nowrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></font></td>
			</tr>
			<% 
			while(rs.next())
			{	
				classValue="gridData";
				encounter_id =rs.getString("encounter_id") == null?"":rs.getString("encounter_id");
				patient_class =rs.getString("patient_class") == null?"":rs.getString("patient_class");
				visitdate = rs.getString("visit_date") == null?"":rs.getString("visit_date");
				visitdate = com.ehis.util.DateUtils.convertDate(visitdate,"DMYHM","en",locale);	
				visitdate = visitdate.substring(0,10); //IN038718
				
				if(patient_class.equals("OP"))
					patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(patient_class.equals("IP"))
					patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(patient_class.equals("EM"))
					patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(patient_class.equals("DC"))
					patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				
			%>
				<tr>	
					<td  class='<%=classValue%>'><%=visitdate%> </td> 
					<td  class='<%=classValue%>'><%=patient_class%> </td> 
					<td class='<%=classValue%>'>  <a class='gridLink' href="javascript:showEncounterDialogList('<%=encounter_id%>','','','<%=facility_id%>','<%=patientid%>')"><%=encounter_id%></a></td>
				</tr>	
		
		<%
			}
		%>
		</table>		
		<%
		}	
		catch (Exception e){
			//	out.println("Errors have occured"+e);//COMMON-ICN-0181
				e.printStackTrace();
		}

		finally
		{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if (conn != null) ConnectionManager.returnConnection(conn,request);
		}
	%>	
</body>
</html>

