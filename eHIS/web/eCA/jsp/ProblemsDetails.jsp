<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/08/2013	  IN041797		Chowminya G	 SKR-CRF-0020.1 - In Error legend included
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src='../../eCA/js/PatProblem.js' language='javascript'></SCRIPT>
		<script src='../../eCA/js/ProblemList.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	Connection conn= null;
	PreparedStatement stmt		=null;
	PreparedStatement stmt_1		=null;
	ResultSet rs		=null;
	ResultSet rs_1		=null;
	PreparedStatement pstmt = null;
	ResultSet rs1 	= null;
	HashMap hmap = new HashMap();
	int remarksCount = 0;
	try
	{
		conn= ConnectionManager.getConnection(request);
		StringBuffer strBuff_pr_problem_assessment = new StringBuffer();
		String srl_no       = request.getParameter("srl_no");
		String onset_date="";
		String onset_practitioner_name="";
		String onset_facility_name="";
		String onset_locn_desc="";
		String onset_recorded_date="";
		String close_date="";
		String close_practitioner_name="";
		String close_facility_name="";
		String close_locn_desc="";
		String close_recorded_date="";
		String pr_problem_assessment_remarks="";
		String onset_facility_id = "";
		String onset_encounter_id = "";
		String close_facility_id = "";
		String close_encounter_id = "";
		String onset_service = "";
		String close_service = "";
		String recorded_by  = "";
		String closed_by   = "";
		String curr_status   = "";
		String patientid=request.getParameter("Patient_Id");
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
    	String locale = (String) p.getProperty("LOCALE");
		String term_set_id=request.getParameter("term_set_id");
		String term_code=request.getParameter("term_code");
		String other_facility = "";
		String visit_adm_date = "";
		String other_location = "";
		String other_service = "";
		String other_patient_class = "";
		String other_encntr_id = "";
		String linked_date = "";
		String enc_practitioner = "";
		String error = "";//IN041797
		if(term_set_id==null) term_set_id="";
		if(term_code==null) term_code="";
				
		if (!(srl_no ==null))
		{
			try
			{
				StringBuffer strBuff_sql = new StringBuffer();
				//strBuff_sql.append("Select to_char(onset_date,'dd/mm/yyyy') onset_date,onset_practitioner_name,onset_facility_name, onset_locn_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date,to_char(close_date,'dd/mm/yyyy') close_date,close_practitioner_name,close_facility_name,close_locn_desc,to_char(close_recorded_date ,'dd/mm/yyyy') close_recorded_date,onset_facility_id, onset_encounter_id,close_facility_id, close_encounter_id,recorded_by,closed_by from pr_problem_vw where patient_id=? and srl_no=?");
					
				//strBuff_sql.append("Select to_char(onset_date,'dd/mm/yyyy') onset_date,AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,?,'1') onset_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(ONSET_FACILITY_ID,?,'1') onset_facility_name,decode(ONSET_LOCN_TYPE,'C',OP_GET_DESC.OP_CLINIC(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1') ) onset_locn_desc, to_char(ADDED_DATE,'dd/mm/yyyy') onset_recorded_date,to_char(ONSET_STATUS_DATE,'dd/mm/yyyy') close_date,AM_GET_DESC.AM_PRACTITIONER(CURR_PRACTITIONER_ID,?,'1')close_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(CURR_FACILITY_ID,?,'1') close_facility_name,decode(CURR_LOCN_TYPE,'C',OP_GET_DESC.OP_CLINIC(CURR_FACILITY_ID,CURR_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(CURR_FACILITY_ID,CURR_LOCN_CODE,?,'1') )close_locn_desc,to_char(CURR_STATUS_DATE ,'dd/mm/yyyy') close_recorded_date,onset_facility_id,onset_encounter_id,CURR_FACILITY_ID close_facility_id, CURR_ENCOUNTER_ID close_encounter_id, AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,?,1) recorded_by,  AM_GET_DESC.AM_PRACTITIONER(CURR_PRACTITIONER_ID,?,1) closed_By, CURR_STATUS from PR_DIAGNOSIS where patient_id=? and occur_srl_no=? and term_set_id=? and term_code=?");//IN041797
				strBuff_sql.append("Select to_char(onset_date,'dd/mm/yyyy hh24:mi') onset_date,AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,?,'1') onset_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(ONSET_FACILITY_ID,?,'1') onset_facility_name,decode(ONSET_LOCN_TYPE,'C',OP_GET_DESC.OP_CLINIC(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1') ) onset_locn_desc, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi') onset_recorded_date,to_char(ONSET_STATUS_DATE,'dd/mm/yyyy hh24:mi') close_date,AM_GET_DESC.AM_PRACTITIONER(CURR_PRACTITIONER_ID,?,'1')close_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(CURR_FACILITY_ID,?,'1') close_facility_name,decode(CURR_LOCN_TYPE,'C',OP_GET_DESC.OP_CLINIC(CURR_FACILITY_ID,CURR_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(CURR_FACILITY_ID,CURR_LOCN_CODE,?,'1') )close_locn_desc,to_char(CURR_STATUS_DATE ,'dd/mm/yyyy hh24:mi') close_recorded_date,onset_facility_id,onset_encounter_id,CURR_FACILITY_ID close_facility_id, CURR_ENCOUNTER_ID close_encounter_id, AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,?,1) recorded_by,  AM_GET_DESC.AM_PRACTITIONER(CURR_PRACTITIONER_ID,?,1) closed_By, CURR_STATUS from PR_DIAGNOSIS where patient_id=? and occur_srl_no=? and term_set_id=? and term_code=?");//IN041797 time format from DMY to DMYHM
				

				//String StrSql1="Select log_text, problem_remarks from pr_problem_assessment where patient_id=? and srl_no=?";
				String StrSql1="Select STATUS log_text, Remarks problem_remarks from pr_diagnosis_status where patient_id=? and occur_srl_no=? and term_set_id=? and term_code=?";
			

				stmt = conn.prepareStatement(strBuff_sql.toString());
				//stmt = conn.prepareStatement(StrSql);
				stmt.setString(1,locale);
				stmt.setString(2,locale);
				stmt.setString(3,locale);
				stmt.setString(4,locale);
				stmt.setString(5,locale);
				stmt.setString(6,locale);
				stmt.setString(7,locale);
				stmt.setString(8,locale);
				stmt.setString(9,locale);
				stmt.setString(10,locale);
				stmt.setString(11,patientid);
				stmt.setString(12,srl_no);
				stmt.setString(13,term_set_id);
				stmt.setString(14,term_code);
				rs = stmt.executeQuery();

				while(rs.next())
				{
					onset_date=rs.getString("onset_date");
					onset_practitioner_name= rs.getString("onset_practitioner_name");
					onset_facility_name=rs.getString("onset_facility_name");
					onset_locn_desc=rs.getString("onset_locn_desc");
					onset_recorded_date=rs.getString("onset_recorded_date");
					close_date=rs.getString("close_date");
					close_practitioner_name=rs.getString("close_practitioner_name");
					close_facility_name=rs.getString("close_facility_name");
					close_locn_desc=rs.getString("close_locn_desc");
					close_recorded_date=rs.getString("close_recorded_date");
					onset_facility_id = rs.getString("onset_facility_id");
					onset_encounter_id = rs.getString("onset_encounter_id");
					close_facility_id = rs.getString("close_facility_id");
					close_encounter_id = rs.getString("close_encounter_id");
					recorded_by = rs.getString("recorded_by");
					closed_by = rs.getString("closed_By") ;
					curr_status = rs.getString("CURR_STATUS") ;
					//IN041797 DMY to DMYHM
					/*onset_date			= com.ehis.util.DateUtils.convertDate(onset_date,"DMY","en",locale);
					onset_recorded_date	= com.ehis.util.DateUtils.convertDate(onset_recorded_date,"DMY","en",locale);
					close_date			= com.ehis.util.DateUtils.convertDate(close_date,"DMY","en",locale);
					close_recorded_date	= com.ehis.util.DateUtils.convertDate(close_recorded_date,"DMY","en",locale);*/
					onset_date			= com.ehis.util.DateUtils.convertDate(onset_date,"DMYHM","en",locale);
					onset_recorded_date	= com.ehis.util.DateUtils.convertDate(onset_recorded_date,"DMYHM","en",locale);
					close_date			= com.ehis.util.DateUtils.convertDate(close_date,"DMYHM","en",locale);
					close_recorded_date	= com.ehis.util.DateUtils.convertDate(close_recorded_date,"DMYHM","en",locale);
				}
					
					if(rs!=null) rs.close();
					//out.println(onset_date);
				stmt_1 = conn.prepareStatement(StrSql1);
				stmt_1.setString(1,patientid);
				stmt_1.setString(2,srl_no);
				stmt_1.setString(3,term_set_id);
				stmt_1.setString(4,term_code);
				rs_1 = stmt_1.executeQuery();
				
				while(rs_1.next())
				{
					error = rs_1.getString("log_text"); //IN041797
					strBuff_pr_problem_assessment.append(rs_1.getString("log_text"));
					strBuff_pr_problem_assessment.append("<br>");					
					pr_problem_assessment_remarks   = rs_1.getString("problem_remarks");

					if(pr_problem_assessment_remarks == null)pr_problem_assessment_remarks ="";
					if(!pr_problem_assessment_remarks.equals("")){

						hmap.put("rmk"+remarksCount++, pr_problem_assessment_remarks);
					}
				}
					if(rs_1!=null) rs_1.close();
					if(stmt_1!=null) stmt_1.close();
				//Added newly
				//pstmt = conn.prepareStatement("select b.short_desc from pr_encounter a, am_service b where a.facility_id = ? and a.encounter_id = ? and b.service_code = a.service_code");

				pstmt = conn.prepareStatement("select AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') short_desc from pr_encounter a where a.facility_id = ? and a.encounter_id = ?");
				pstmt.setString(1,locale);
				pstmt.setString(2,onset_facility_id);
				pstmt.setString(3,onset_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  onset_service = rs1.getString(1);
				}

				if(rs1!=null) rs1.close();
				pstmt.setString(1,locale);
				pstmt.setString(2,close_facility_id);
				pstmt.setString(3,close_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  close_service = rs1.getString(1);
				}
				if(rs1!=null) rs1.close();
				if(pstmt!=null) pstmt.close();
			}
			catch (Exception e)
			{
				//out.println("HERE AFTER :"+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			if	(onset_date== null)
					onset_date="&nbsp";
			if	(onset_practitioner_name== null)
					onset_practitioner_name ="&nbsp";
			if 	(onset_facility_name== null)
					onset_facility_name="&nbsp";
			if 	(onset_locn_desc== null)
					onset_locn_desc="&nbsp";
			if 	(onset_recorded_date== null)
					onset_recorded_date="&nbsp";
			if 	(close_date== null)
					close_date="&nbsp";
			if 	(close_practitioner_name== null)
					close_practitioner_name="&nbsp";
			if 	(close_facility_name== null)
					close_facility_name="&nbsp";
			if	(close_locn_desc== null)
					close_locn_desc="&nbsp";
			if 	(close_recorded_date== null)
					close_recorded_date="&nbsp";
			/*if 	(pr_problem_assessment== null)
					pr_problem_assessment="&nbsp";*/
			if(strBuff_pr_problem_assessment.length() == 0)
			{
				strBuff_pr_problem_assessment.append("&nbsp");
			}

			if(pr_problem_assessment_remarks == null)
				pr_problem_assessment_remarks = "&nbsp";

			if(onset_service ==null)
				   onset_service="&nbsp;";
			if(close_service ==null)
				   close_service="&nbsp;";
			if(recorded_by ==null)
				   recorded_by="&nbsp;";
			if(closed_by ==null)
				   closed_by="&nbsp;";
		}%>
	<!--<table width=100% cellpadding='3' cellspacing='0' border=0>
		<tr>
			<td class='columnHeader' height='7%' width="40%">
				<fmt:message key="Common.details.label" bundle="${common_labels}"/>
			</td>
			
			<td class='columnHeader' height='7%' width="30%">
				<fmt:message key="eCA.Onset.label" bundle="${ca_labels}"/>
			</td>

			<td class='columnHeader' height='7%' width="30%">
			<%if(curr_status.equals("R")){%><fmt:message key="Common.close.label" bundle="${common_labels}"/><%}else{%>&nbsp;<%}%></td>
			
		</tr>
		<tr>
			<td colspan="3">
				<table width=100% height="100%" cellpadding='3' cellspacing='0' border=0>
					<tr>
					<td class="label"  width=40%>
						<fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp&nbsp
					</td>

					<td width=30%><font size='1' color="BLACK"><%=onset_date%></font></td>
					<td width=30%><font size='1' color="BLACK"><%if(curr_status.equals("R")){%><%=close_date%><%}else{%>&nbsp;<%}%></font></td>
					</tr>
					<tr>
					<td class="label"  width=40%>
						<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp&nbsp
					</td>
					<td width=30%><font size='1' color="BLACK"><%=onset_practitioner_name%></font></td>
					<td width=30%><font size='1' color="BLACK"><%if(curr_status.equals("R")){%><%=close_practitioner_name%>
					<%}else{%>&nbsp;<%}%></font></td>	</tr>
					<tr>
						<td class="label"  width=40%>
							<fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp&nbsp
						</td>
						<td width=30%><font size='1' color="BLACK"><%=onset_facility_name%></font></td>
						<td width=30%><font size='1' color="BLACK"><%if(curr_status.equals("R")){%><%=close_facility_name%><%}else{%>&nbsp;<%}%></font></td>
					</tr>
					<tr>
						<td class="label"  width=40%>
							<fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp&nbsp
						</td>
						<td width=30%><font size='1' color="BLACK"><%=onset_locn_desc%></font></td>
						<td width=30%><font size='1' color="BLACK"><%if(curr_status.equals("R")){%><%=close_locn_desc%><%}else{%>&nbsp;<%}%></font></td>	
					</tr>
					<tr>
						<td class="label"  width=40%>
							<fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp&nbsp
						</td>
						<td width=30%><font size='1' color="BLACK"><%=onset_service%></font></td>
						<td width=30%><font size='1' color="BLACK"><%if(curr_status.equals("R")){%><%=close_service%><%}else		{%>&nbsp;<%}%></font></td>	
					</tr>
					<tr>
						<td class="label"  width=40%>
							<fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/>&nbsp&nbsp
						</td>
						<td width=30%><font size='1' color="BLACK"><%=onset_recorded_date%></font></td>
						<td width=30%><font size='1'color="BLACK"><%if(curr_status.equals("R")){%><%=close_recorded_date%><%}else{%>&nbsp;<%}%></font></td>
					</tr>
 					<tr>
						<td class="label"  width=40% nowrap>
							<fmt:message key="eCA.RecordedClosedBy.label" bundle="${ca_labels}"/>&nbsp&nbsp
						</td>
						<td width=30%><font size='1' color="BLACK"><%=recorded_by%></font></td>
						 <td width=30%><font size='1'color="BLACK">
				<%
						if(curr_status.equals("R"))
						{
				%>
							<%=closed_by%>
				<%					
						}
						else
						{
				%>
							&nbsp;
				<%
						}
				%>
						</font></td> 		
					</tr>					
				</table>
			</td>				
		</tr>
	</table>-->
	<!--<DIV  STYLE="overflow-x:hidden;overflow-y:auto;width:100%;height:15%  border-left: 1px gray solid; border-bottom: 1px gray solid; 
            padding:0px; margin: 0px" onscroll='scrollTitleForLinkEnc()' id='mainDiv'>-->


	<DIV  STYLE="overflow: auto; width:100%; height:51%;  border-left: 1px gray solid; border-bottom: 1px gray solid; 
            padding:0px; margin: 0px" onscroll='scrollTitleForLinkEnc()' id='mainDiv'>		
	<table width=100% cellpadding='3' cellspacing='0' border=0>
		<!--<tr id='EncDetails'>
			<td class='columnHeader' height='7%' colspan='7'>
				<fmt:message key="eCA.LinkedEncounters.label" bundle="${ca_labels}"/>
			</td>
		</tr>
		<tr id='EncDetails1'>
			<td class='columnHeader' height='7%'>
				<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/>
			</td>
			<td class='columnHeader' height='7%'>
				<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
			</td>
			<td class='columnHeader' height='7%'>
				<fmt:message key="Common.facility.label" bundle="${common_labels}"/>
			</td>
			<td class='columnHeader' height='7%'>
				<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
			</td>
			<td class='columnHeader' height='7%'>
				<fmt:message key="Common.service.label" bundle="${common_labels}"/>
			</td>
			<td class='columnHeader' height='7%'>
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
			</td>
			<td class='columnHeader' height='7%'>
				<fmt:message key="eCA.LinkedDate.label" bundle="${ca_labels}"/>
			</td>
		</tr>-->
		<tr id='EncDetails'>
		<th class='columnHeader' height='7%'>&nbsp;</th>
		<th class='columnHeader' height='7%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' height='7%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' height='7%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' height='7%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' height='7%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' height='7%'><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' height='7%'><fmt:message key="eCA.RecordedClosedBy.label" bundle="${ca_labels}"/></th>

		</tr>
	<%
			String str1 = "Select to_char(b.RECORDED_DATE_TIME,'dd/mm/yyyy hh24:mi') recorded_date, to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_date, SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1') facility_name,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') service, DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?)) location, (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END) practitioner, a.PATIENT_CLASS,a.encounter_id from pr_encounter a,PR_Diagnosis_enc_dtl b where a.facility_id = b.facility_id and a.encounter_id = b.encounter_id and b.TERM_SET_ID = ? and b.TERM_CODE = ? and b.patient_id = ? and b.occur_srl_no =? order by recorded_date desc";
			
			pstmt = conn.prepareStatement(str1);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,term_set_id);
			pstmt.setString(7,term_code);
			pstmt.setString(8,patientid);
			pstmt.setString(9,srl_no);
			rs1 = pstmt.executeQuery();
			while(rs1!=null && rs1.next())
			{
				other_facility = rs1.getString("facility_name") == null ? "" : rs1.getString("facility_name");
				visit_adm_date = rs1.getString("visit_date") == null ? "" : rs1.getString("visit_date");
				other_location = rs1.getString("location") == null ? "" : rs1.getString("location");
				other_service = rs1.getString("service") == null ? "" : rs1.getString("service");
				other_patient_class = rs1.getString("PATIENT_CLASS") == null ? "" : rs1.getString("PATIENT_CLASS");
				other_encntr_id = rs1.getString("encounter_id") == null ? "" : rs1.getString("encounter_id");
				linked_date = rs1.getString("recorded_date") == null ? "" : rs1.getString("recorded_date");
				enc_practitioner = rs1.getString("practitioner") == null ? "" : rs1.getString("practitioner");
				//Date Conversion is done by Archana Dhal on 10/7/2010 related to IN024213.
                linked_date = com.ehis.util.DateUtils.convertDate(linked_date,"DMYHM","en",locale);

                visit_adm_date = com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);

				if(other_patient_class.equals("OP"))
					other_patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(other_patient_class.equals("IP"))
					other_patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(other_patient_class.equals("EM"))
					other_patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(other_patient_class.equals("DC"))
					other_patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				out.print("<tr>");
				%>
				<td class='gridData'><fmt:message key="eCA.Onset.label" bundle="${ca_labels}"/></td>
				<%
				out.println("<td class='gridData'>"+onset_date+"</td>");
				out.println("<td class='gridData'>"+onset_practitioner_name+"</td>");
				out.println("<td class='gridData'>"+onset_facility_name+"</td>");
				out.println("<td class='gridData'>"+onset_locn_desc+"</td>");
				out.println("<td class='gridData'>"+onset_service+"</td>");
				out.println("<td class='gridData'>"+onset_recorded_date+"</td>");
				out.println("<td class='gridData'>"+recorded_by+"</td>");
				out.print("</tr>");
				out.print("<tr>");
				%>
				<td class='gridData'><fmt:message key="Common.close.label" bundle="${common_labels}"/></td>
				<%
				out.println("<td class='gridData'>");
				
				if(curr_status.equals("R")){
					out.println(close_date);
					}else{
					out.println("&nbsp;");}
					out.print("</td>");
				
				out.println("<td class='gridData'>");
				
				if(curr_status.equals("R")){
					out.println(close_practitioner_name);
					}else{
					out.println("&nbsp;");}
					out.print("</td>");

				out.println("<td class='gridData'>");
				
				if(curr_status.equals("R")){
					out.println(close_facility_name);
					}else{
					out.println("&nbsp;");}
					out.print("</td>");

				out.println("<td class='gridData'>");
				
				if(curr_status.equals("R")){
					out.println(close_locn_desc);
					}else{
					out.println("&nbsp;");}
					out.print("</td>");
				
				out.println("<td class='gridData'>");
				
				if(curr_status.equals("R")){
					out.println(close_service);
					}else{
					out.println("&nbsp;");}
					out.print("</td>");
				
				out.println("<td class='gridData'>");
				
				if(curr_status.equals("R")){
					out.println(close_recorded_date);
					}else{
					out.println("&nbsp;");}
					out.print("</td>");

					out.println("<td class='gridData'>");
				
				if(curr_status.equals("R")){
					out.println(closed_by);
					}else{
					out.println("&nbsp;");}
					out.print("</td>");

				out.print("</tr>");
				//IN041797 Start
				if("E".equals(error))
				{	
					out.print("<tr>");
					%>
					<td class='gridData'><fmt:message key="Common.InError.label" bundle="${common_labels}"/></td>
					<%
					out.println("<td class='gridData'>"+visit_adm_date+"</td>");
					out.println("<td class='gridData'>"+enc_practitioner+"</td>");
					out.println("<td class='gridData'>"+other_facility+"</td>");
					out.println("<td class='gridData'>"+other_location+"</td>");
					out.println("<td class='gridData'>"+other_service+"</td>");
					out.println("<td class='gridData'>"+linked_date+"</td>");
					out.println("<td class='gridData'>"+recorded_by+"</td>");
					out.print("</tr>");
				}	
				//IN041797 End
				out.print("<tr>");
				%>
				<td class='gridData'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>
				<%
				out.println("<td class='gridData'>"+visit_adm_date+"</td>");
				out.println("<td class='gridData'>"+enc_practitioner+"</td>");
				out.println("<td class='gridData'>"+other_facility+"</td>");
				out.println("<td class='gridData'>"+other_location+"</td>");
				out.println("<td class='gridData'>"+other_service+"</td>");
				out.println("<td class='gridData'>"+linked_date+"</td>");
				out.println("<td class='gridData'>&nbsp;</td>");
				out.print("</tr>");

			//	out.println("<td class='gridData'>"+visit_adm_date+"</td>");
			//	out.println("<td class='gridData'>"+other_patient_class+"</td>");
			//	out.println("<td class='gridData'>"+other_facility+"</td>");
			//	out.println("<td class='gridData'>"+other_location+"</td>");
			//	out.println("<td class='gridData'>"+other_service+"</td>");
			//	out.println("<td class='gridData'>"+other_encntr_id+"</td>");
			//	out.println("<td class='gridData'>"+linked_date+"</td>");
			//	out.print("</tr>");
			}
	%>
	</table>
	</div>
	</body>
	</html>
	<%
		
		if(stmt!=null) stmt.close();
		if(rs1!=null) rs1.close();
		if(pstmt!=null) pstmt.close();					
		}
	catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally 
	{
		hmap.clear();
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}%>

