<!DOCTYPE html>
<%@ page import="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCP.PatientAssessmentResult.label" bundle="${cp_labels}"/></title>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>		
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>
	<%
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");	
		
	%>
	<body onmousedown = 'CodeArrest();' onscroll='scrollTable();'>
		<script>
			document.body.style.scrollbarBaseColor='#E2E3F0';
			document.body.style.scrollbarArrowColor='#000080';
		</script>
		<form name='patAssessmentResultForm' id='patAssessmentResultForm' action='' >
			<div id="tableStaticId" style='position:relative'>
				<table width='100%' align='center' border=0 cellpadding='0' cellspacing=0>
					<tr>
						<td><a href='javascript:' onclick='clearValues()' align='center' id="newAssessTable" style='display:inline'><font size='1'><fmt:message key="eCP.NewAssessment.label" bundle="${cp_labels}"/> </font></a></td>
					</tr>
				</table>
			</div>
			<table width='100%' height='100%' align='center' border=1 cellpadding='0' cellspacing=0 style='display:none' id='recordsTable'>
				<tr>
					<td style="color:red;font-weight:800;font-size=15;font-family:verdana;background-color:#FFE4E1">
						P<br>A<br>T<br><br>A<br>S<br>S<br>E<br>S<br>S<br>M<br>E<br>N<br>T<br>
					</td>
				</tr>
			</table>
			<table width='100%' align='center' border=1 cellpadding='0' cellspacing=0 style='display:inline' id='valuesTable'>
		<%
			String facility_id = (String) session.getAttribute("facility_id");

			String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");			
			String location_code = request.getParameter("location_code") == null ? "" : request.getParameter("location_code");			
			String location_type = request.getParameter("location_type") == null ? "" : request.getParameter("location_type");			
			String sex = request.getParameter("Sex") == null ? "" : request.getParameter("Sex");			
			String age = request.getParameter("Age") == null ? "" : request.getParameter("Age");			
			String dob = request.getParameter("Dob") == null ? "" : request.getParameter("Dob");			
			String relationship_id = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id");			

			String accession_num = "";
			String assess_ref_no = "";
			String assess_date = "";
			String ua_dependency_desc = "";
			String ss_dependency_desc = "";
			String note_type = "";
			String status = "";
			String status_flag = "";
			String classValue = "";
			String sqlresult = "";	
			String note_desc = "";
			String ua_dependency_code = "";
			String ss_dependency_code = "";
			String prev_assess_date = "";
			String assess_time = "";
			int count = 0;
			
			Connection con = null;
			PreparedStatement psResult = null;
			ResultSet resResult = null;
			PreparedStatement psNote = null;
			ResultSet resNote = null;
			PreparedStatement psNoteDesc = null;
			ResultSet resNoteDesc = null;
					

			try
			{
				con = ConnectionManager.getConnection(request);

//				sqlresult = "SELECT A.ASSESS_REF_NO, A.ACCESSION_NO, A.ASSESS_PRACT_ID, B.PRACTITIONER_NAME, TO_CHAR(A.ASSESS_DATE,'DD/MM/YYYY') ASSESS_DATE_STR, TO_CHAR(A.ASSESS_DATE,'HH24:MI') ASSESS_TIME_STR,A.SS_DEPENDENCY_CODE, (SELECT SHORT_DESC FROM CP_DEPENDENCY WHERE DEPENDENCY_CODE=A.SS_DEPENDENCY_CODE) SS_DEPENDENCY_DESC, A.UA_DEPENDENCY_CODE, (SELECT SHORT_DESC FROM CP_DEPENDENCY WHERE DEPENDENCY_CODE=A.UA_DEPENDENCY_CODE) UA_DEPENDENCY_DESC FROM CP_PAT_ASSESS A, AM_PRACTITIONER B WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND B.PRACTITIONER_ID=A.ASSESS_PRACT_ID order by a.ASSESS_DATE desc";
				sqlresult = "SELECT A.ASSESS_REF_NO, A.ACCESSION_NO, A.ASSESS_PRACT_ID, B.PRACTITIONER_NAME, TO_CHAR(A.ASSESS_DATE,'DD/MM/YYYY') ASSESS_DATE_STR, TO_CHAR(A.ASSESS_DATE,'HH24:MI') ASSESS_TIME_STR,A.SS_DEPENDENCY_CODE, (SELECT SHORT_DESC FROM CP_DEPENDENCY_LANG_VW WHERE DEPENDENCY_CODE=A.SS_DEPENDENCY_CODE AND LANGUAGE_ID = ?) SS_DEPENDENCY_DESC, A.UA_DEPENDENCY_CODE, (SELECT SHORT_DESC FROM CP_DEPENDENCY_LANG_VW WHERE DEPENDENCY_CODE=A.UA_DEPENDENCY_CODE AND LANGUAGE_ID = ?) UA_DEPENDENCY_DESC FROM CP_PAT_ASSESS A, AM_PRACTITIONER_LANG_VW B WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND B.PRACTITIONER_ID=A.ASSESS_PRACT_ID AND B.LANGUAGE_ID = ? order by a.ASSESS_DATE desc";

				String sql_note_id = "select note_type,  decode(event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified'),event_status from ca_encntr_note where accession_num = ?";

	//			String sql_note_desc = "select ASSESS_NOTE_DESC FROM cp_assess_note where ASSESS_NOTE_ID = ?";
				String sql_note_desc = "select ASSESS_NOTE_DESC FROM cp_assess_note_lang_vw where ASSESS_NOTE_ID = ? and LANGUAGE_ID = ?";

			
				psResult = con.prepareStatement(sqlresult);
				psResult.setString(1,locale);
				psResult.setString(2,locale);
				psResult.setString(3,facility_id);
				psResult.setString(4,encounter_id);
				psResult.setString(5,locale);

				psNote = con.prepareStatement(sql_note_id);				
				psNoteDesc = con.prepareStatement(sql_note_desc);
				

				resResult = psResult.executeQuery();

				while(resResult.next())
				{
					assess_ref_no = resResult.getString(1);
					accession_num = resResult.getString(2);
					ua_dependency_desc = resResult.getString("UA_DEPENDENCY_DESC");
						if(ua_dependency_desc ==null) ua_dependency_desc="&nbsp;";
					ua_dependency_code = resResult.getString("UA_DEPENDENCY_CODE");
					//out.println("ua_dependency_code = "+ua_dependency_code);
					ss_dependency_desc = resResult.getString("SS_DEPENDENCY_DESC");
						if(ss_dependency_desc ==null) ss_dependency_desc="&nbsp;";
					ss_dependency_code = resResult.getString(6);
					assess_date = resResult.getString("ASSESS_DATE_STR");
					assess_time = resResult.getString("ASSESS_TIME_STR");
					
					psNote.setString(1,accession_num);
					resNote = psNote.executeQuery();
					while(resNote.next())
					{
						note_type = resNote.getString(1);
						String status1 = resNote.getString(2);
						if(status1.equals("In Progress")) status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
						if(status1.equals("Transcribed")) status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
						if(status1.equals("Unauthorized")) status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
						if(status1.equals("Authorized")) status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
						if(status1.equals("Modified")) status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");						
						status_flag = resNote.getString(3);
					}
					resNote.close();


					psNoteDesc.setString(1,note_type);
					psNoteDesc.setString(2,locale);
					resNoteDesc = psNoteDesc.executeQuery();
					while(resNoteDesc.next())
					{
						note_desc = resNoteDesc.getString(1);
					}	
					resNoteDesc.close();


					if(count%2 == 0)
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";
					
					if(!prev_assess_date.equals(assess_date))
					{
						out.println("<tr>");
						out.println("<td><font size='1' style='font-family: verdana ;BACKGROUND-COLOR: #B2B6D7;COLOR:black'><b> "+com.ehis.util.DateUtils.convertDate(assess_date,"DMY","en",locale)+" </b></font>");
						out.println("</tr>");						
					}
					//out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.println("<tr>");
					out.println("<td class="+classValue+" id='tdid"+count+"'><A HREF='javascript:' onclick='loadAddModifyFrame(\""+status+"\",\""+note_desc+"\",\""+note_type+"\",\""+accession_num+"\",\""+assess_time+"\",\""+assess_date+"\",\""+ua_dependency_desc+"\",\""+assess_ref_no+"\",\""+patient_id+"\",\""+patient_class+"\",\""+encounter_id+"\",\""+location_code+"\",\""+location_type+"\",\""+sex+"\",\""+age+"\",\""+dob+"\",\""+ua_dependency_code+"\",\""+ss_dependency_code+"\",this,\""+relationship_id+"\",\""+ss_dependency_desc+"\",\""+status_flag+"\")' >");
					//out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.println("&nbsp;<font size='1'>-"+com.ehis.util.DateUtils.convertDate(assess_time,"HM","en",locale)+"</font></a> </td>");
					out.println("<tr>");
					//out.println("<br>");					
					count++;
					prev_assess_date = assess_date;
				}//end of while
				resResult.close();
				psNoteDesc.close();
    			psNote.close();
				psResult.close();


			}//end of try
			catch(Exception e)
			{
				e.printStackTrace(System.err);
				System.out.println("Exception in try of PatientAssessmentResult.jsp "+ e.toString());
			}//end of catch
			finally
			{
				if(resResult != null) resResult = null;
				if(resNote != null) resNote = null;
				if(resNoteDesc != null) resNoteDesc = null;

				if(psResult != null) psResult = null;
				if(psNote != null) psNote = null;
				if(psNoteDesc != null) psNoteDesc = null;

				if(con != null) ConnectionManager.returnConnection(con);
			}//end of finally			
		%>		
			<input type='hidden' name='qry_string' id='qry_string' value='<%=request.getQueryString()%>'>
		</form>
	</body>
</html>

