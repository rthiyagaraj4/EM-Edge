<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/01/2016	  	IN057193			Karthi L											Flag For Discharge Summary Not Done								
29/01/2016		IN059021			Karthi L											Record does not display when the Discharge Summary Note is marked as Error
17/03/2016		IN059603			Karthi L											When Discharge Summary is captured, system removes both records though discharge summary recorded for only one discharged encounter
12/07/2017		IN061885			Raja S				13/07/2017		Ramesh G		ML-MMOH-CRF-0537
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1
----------------------------------------------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.ReviewNotes.label" bundle="${ca_labels}"/></title>

	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/PendDiscSummNotes.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>
<%
	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try
	{
		con = ConnectionManager.getConnection(request);

		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");		
		String 	clinicianId	=	(String)	session.getValue("ca_practitioner_id");
		//String	respId		=	(String)	session.getValue("responsibility_id");
		String	facilityId	=	(String)	session.getValue("facility_id");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String toDate =request.getParameter("toDate")==null?"":request.getParameter("toDate");
		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
		toDate = com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
		String viewBy =request.getParameter("viewBy")==null?"":request.getParameter("viewBy");//Added for IN061885

		
		StringBuffer sql = new StringBuffer(); 
		String classValue = "";
		int i = 0;
		//IN061885 Starts
		String pendDisSumGracPrd ="";
		try{
			String dateSql ="SELECT PEND_DISCHRG_SUMM_DAYS FROM CA_PARAM";

		
			pstmt = con.prepareStatement( dateSql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
					pendDisSumGracPrd	=	rs.getString("PEND_DISCHRG_SUMM_DAYS");
			}
		}
		catch(Exception d){
			d.printStackTrace();
		}
		finally
		{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
		}
		//IN061885 Ends
%>
<form name="PendDiscSummDtl_form" id="PendDiscSummDtl_form" method="post" target=messageFrame>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'>Discharge Practitioner</td>
	<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	<%if(!"NURSE".equals(viewBy)){%> <!-- Added If Condition for IN061885 -->
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
	<%}%>
	<%		if(sql.length() > 0) sql.delete(0,sql.length());
			//IN061885 Changes Starts
			//sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - 2 AND PATIENT_CLASS IN ('IP', 'DC') AND (ATTEND_PRACTITIONER_ID = ? OR DISCH_PRACTITIONER_ID = ?) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS != '9') ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603 //Commented for IN061885

			if(!"NURSE".equals(viewBy)){
			//sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - 2 AND PATIENT_CLASS IN ('IP', 'DC') AND (ATTEND_PRACTITIONER_ID = ? OR DISCH_PRACTITIONER_ID = ?) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS != '9') ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603//IN67872
			sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - 2 AND PATIENT_CLASS IN ('IP', 'DC') AND (ATTEND_PRACTITIONER_ID = ? OR DISCH_PRACTITIONER_ID = ?) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS not in ('9','8')) ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603//IN67872
			}
			else{
			//sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - "+pendDisSumGracPrd+" AND PATIENT_CLASS IN ('IP', 'DC') AND 'Y'=ca_pract_by_locn_yn(A.FACILITY_ID,?,A.PAT_CURR_LOCN_CODE) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS != '9') ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603//IN67872
			sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - "+pendDisSumGracPrd+" AND PATIENT_CLASS IN ('IP', 'DC') AND 'Y'=ca_pract_by_locn_yn(A.FACILITY_ID,?,A.PAT_CURR_LOCN_CODE) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS not in ('9','8')) ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603//IN67872
			}
			//IN061885 Changes Ends
		
			if(!fromDate.equals("")&&(!toDate.equals("")))
			{
				sql.append( " and a.DISCHARGE_DATE_TIME between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
			}
			else if(!fromDate.equals("") && (toDate.equals("")))
			{
				sql.append(" 	and a.DISCHARGE_DATE_TIME >= to_date( ?, 'DD/MM/YYYY' ) ");
			}
			else if(fromDate.equals("") && !toDate.equals(""))
			{
				sql.append(" 	and a.DISCHARGE_DATE_TIME <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
			}
			if(!patientId.equals(""))
				sql.append( " and a.patient_id =? ");
				
			
			sql.append("  order by discharge_date_time desc  ");
			
						
			System.out.println("Line No:173 ReviewNotesDetails.jsp sql>"+sql);
			pstmt=con.prepareStatement(sql.toString());

			//*********parameter binding
			int count=0;
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,clinicianId);
			if(!"NURSE".equals(viewBy)){ //Added if condition for IN061885
			pstmt.setString(++count,clinicianId);
			}
			pstmt.setString(++count,facilityId);
			
			if(!fromDate.equals("")&&(!toDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				
				pstmt.setString(++count,toDate);
				
			}
			else if(!fromDate.equals("") && (toDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				
			}
			else if(fromDate.equals("") && !toDate.equals(""))
			{
				pstmt.setString(++count,toDate);
				
			}
			if(!patientId.equals(""))
				pstmt.setString(++count,patientId);	
			
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{	
				if(i%2 == 0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";
				String patdetails = rs.getString("patient_detail");
				if (patdetails== null) patdetails="";
				patdetails = patdetails.replace('|',',');
				String attend_pract_name 	= rs.getString("attend_pract_name")==null?"":rs.getString("attend_pract_name");
				String disch_pract_name 	= rs.getString("disch_pract_name")==null?"":rs.getString("disch_pract_name");
				//String disch_date_time 		= rs.getString("disch_date_time")==null?"":rs.getString("disch_date_time");
				String encounter_id 		= rs.getString("encounter_id")==null?"":rs.getString("encounter_id"); 
				String patient_class		= rs.getString("patient_class")==null?"":rs.getString("patient_class");	
				String patient_id			= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				
				out.println("<tr><td class='gridData'>"+ attend_pract_name 	+"</td>");
				out.println("<td class='gridData'>"+ disch_pract_name 	+"</td>");
				out.println("<td class='gridData' > "+com.ehis.util.DateUtils.convertDate(rs.getString("disch_date_time"),"DMYHM","en",locale)+"</td>");
				out.println("<td class='gridData'>"+patdetails+"</td>");
				if(!"NURSE".equals(viewBy)){// Added If condition for IN061885
				out.println("<td class='gridData'><a class='gridLink'  href=\"javascript:callDiscSummNotes('"+patient_id+"','"+encounter_id+"','"+patient_class+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.recordsign.label","ca_labels")+"</a></td></tr>");
				}
				i++;
				
				
			}%>
				
			<%

			 if(i==0){ %>
		<Script language=javascript>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		  <%}
	%>
</table>
</body>
<input type="hidden" name="noofrec" id="noofrec" value="<%=i%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
<input type="hidden" name="tempAccession_Num" id="tempAccession_Num" value="">




</form>
<%	 if(rs != null) rs.close();
         if(pstmt != null) pstmt.close();
        
	}
	catch (Exception e)	
	{
		
        e.printStackTrace() ;
		//out.println(e);
	}
	finally    {
	
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }
%>
</html>

