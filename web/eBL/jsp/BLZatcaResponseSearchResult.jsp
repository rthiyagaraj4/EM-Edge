<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eBL/js/BLZatcaResponse.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eBL/js/json2.js'></script>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<%
	System.err.println("Inside BLZatcaResponseSearchResult.jsp");
	Connection con = null; 
	PreparedStatement pstmt = null;
	int maxRecord = 0;
	ResultSet rset = null;	

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	
 	int totalRecord =0;
	String facility_id = (String) session.getValue("facility_id");
	if(facility_id == null) facility_id = "";
	
	String locale = (String)session.getAttribute("LOCALE");
	if(locale == null) locale = "en";
	
	String params = request.getParameter("params");
	if(params == null) params = "";
	
	String patient_id = request.getParameter("patientId");
	if(patient_id == null) patient_id = "";
	
	String patient_name = request.getParameter("patient_name");
	if(patient_name == null) patient_name = "";
	
	String gender = request.getParameter("gender");
	if(gender == null) gender = "";
	
	String dob = request.getParameter("dob");
	if(dob == null) dob = "";	
	
	String visit_date = request.getParameter("visit_date");
	if(visit_date == null) visit_date = "";
	
	String encounter_id = request.getParameter("encounterId");	
	if(encounter_id == null) encounter_id = "";
	
	String payer_group = request.getParameter("payerGroup");
	if(payer_group == null) payer_group = "";
	
	String payer = request.getParameter("payer");
	if(payer == null) payer = "";
	
	String encounter_from_date_str = request.getParameter("encounterFromDate");
	if(encounter_from_date_str == null) encounter_from_date_str = "";
	
	String encounter_to_date_str = request.getParameter("encounterToDate");
	if(encounter_to_date_str == null) encounter_to_date_str = "";
	
	String zatcaStatus = request.getParameter("zatcaStatus");
	if(zatcaStatus == null) zatcaStatus = "";
	
	String episode_type = request.getParameter("episodeType");
	if(episode_type == null) episode_type = "";
	
	if("A".equals(episode_type)){
		episode_type = "";
	}
	
	String active_bill_YN = request.getParameter("active_bill_YN");
	if(active_bill_YN == null) active_bill_YN = "Y";	

	String sql_zatca_resp = "", sql_zatca_addl_cond = "";

	try
	{
 		con = ConnectionManager.getConnection(request);
	
		sql_zatca_resp = "SELECT  a.operating_facility_id operating_facility_id,a.doc_type_code doc_type_code,a.doc_num doc_num,"+
						 " to_char(b.doc_date,'DD/MM/YYYY HH:MI:SS') bill_date, b.patient_id patient_id,b.episode_id,b.visit_id, d.encounter_id encounter_id,"+ 
						 " c.patient_name patient_name, DECODE(c.sex,'M','Male','F','Female','Unknown') gender, "+
						 " to_char(c.date_of_birth,'DD/MM/YYYY') DOB,b.org_bill_ref_num  org_bill_doc_ref, "+
						 " a.error_mesg zatca_remarks, a.ERROR_CODE ERROR_CODE, to_char(trunc(D.VISIT_ADM_DATE_TIME),'DD/MM/YYYY') visit_date, "+
						 " (a.DOC_TYPE_CODE||'/'||a.DOC_NUM) bill_number, DECODE(NVL(ACTIVE_FLAG_YN,'Y'),'Y','Yes','N','No','Yes') ACTIVE_FLAG_YN_DESC, NVL(ACTIVE_FLAG_YN,'Y') ACTIVE_FLAG_YN "+
						 " FROM BL_BILL_XML_QR_INFO a, BL_BILL_HDR b, MP_PATIENT C, PR_ENCOUNTER D "+
						 " WHERE a.operating_facility_id = b.operating_Facility_id "+
						 " AND a.doc_type_code = b.doc_type_code "+
						 " AND a.doc_num = b.doc_num  "+
						 " AND b.patient_id = c.patient_id  "+
						 " AND a.operating_Facility_id = d.facility_id  "+
						 " and b.EPISODE_ID = D.EPISODE_ID "+
						 " AND trunc(D.VISIT_ADM_DATE_TIME) between to_date('"+encounter_from_date_str+"','DD/MM/YYYY') and to_date('"+encounter_to_date_str+"','DD/MM/YYYY')" +
						 " AND a.ACTIVE_FLAG_YN = '"+active_bill_YN+"'";
						 
		if(!"".equals(zatcaStatus)){
			sql_zatca_resp = sql_zatca_resp + " AND a.error_code = '"+ zatcaStatus +"'";
		}
		
		if("O".equals(episode_type) || "E".equals(episode_type))
			sql_zatca_resp = sql_zatca_resp + " and b.visit_id = d.OP_EPISODE_VISIT_NUM ";
		if(!"".equals(patient_id))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND b.patient_id = '" + patient_id+"'";
		
		if(!"".equals(episode_type))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND b.EPISODE_TYPE = '" + episode_type+"'";
		
		if(!"".equals(encounter_id))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND d.encounter_id = '" + encounter_id+"'";
		
		if(!"".equals(payer_group))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND B.CUST_GROUP_CODE = DECODE('" + payer_group+"', '**', B.CUST_GROUP_CODE, '" + payer_group+"')";	

		if(!"".equals(payer))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND B.CUST_CODE = DECODE('" + payer +"', '**', B.CUST_CODE, '" + payer +"')";	

		if(!"".equals(sql_zatca_resp))
			sql_zatca_resp = sql_zatca_resp + sql_zatca_addl_cond;
						 
		System.err.println("sql_zatca_resp final:"+sql_zatca_resp);
		
		pstmt = con.prepareStatement(sql_zatca_resp);
		rset = pstmt.executeQuery();

%>
<form name='searchresult' id='searchresult' id='searchresult' method='post'>
<%	
	int totalRecords = 0;
	if(rset != null){
		
%>		
	<table border="2" width="100%" cellspacing='0' cellpadding='0' class="grid">
	<tr>
		<th class='columnheadercenter' width='2%'><input type='checkbox' id='selectAll' name='selectAll' id='selectAll' value = 'N' onClick="selectAllRec(this);"></th>
		<td class='columnheadercenter' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' width='10%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' width='20%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' width='5%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' width='10%'><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td>		
		<th class='columnheadercenter' width='10%'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></th>
		<td class='columnheadercenter' width='8%'>EM <fmt:message key="eBL.BillNumber.label" bundle="${bl_labels}"/></td>
		<td class='columnheadercenter' width='10%'>Bill Date and time</td>		
		<td class='columnheadercenter' width='8%'>Active Bill</td>
		<td class='columnheadercenter' width='8%'>Original Bill Reference Number</td>
		<td class='columnheadercenter' width='15%'>Comments / ZATCA Response</td>
	</tr>
	<%
			while(rset.next()){

				totalRecords++;
				String rec_oper_fac_id = rset.getString("operating_facility_id");
				String rec_patient_id = rset.getString("patient_id");
				String rec_encounter_id = rset.getString("encounter_id");
				String rec_patient_name = rset.getString("patient_name");
				String rec_gender = rset.getString("gender");
				String rec_DOB = rset.getString("DOB");
				String rec_visit_date = rset.getString("visit_date");
				String rec_bill_number = rset.getString("bill_number");
				String rec_bill_date = rset.getString("bill_date");
				String rec_doc_type_code = rset.getString("doc_type_code");
				String rec_doc_num = rset.getString("doc_num");
				String rec_org_bill_doc_ref = rset.getString("org_bill_doc_ref");
				if(rec_org_bill_doc_ref == null) rec_org_bill_doc_ref = "";
				String rec_zatca_remarks = rset.getString("zatca_remarks");
				String ACTIVE_FLAG_YN = rset.getString("ACTIVE_FLAG_YN");
				String ACTIVE_FLAG_YN_DESC = rset.getString("ACTIVE_FLAG_YN_DESC");
				if(rec_zatca_remarks == null) rec_zatca_remarks = "";
				String rec_ERROR_CODE = rset.getString("ERROR_CODE");
				
	%>
	<tr>
	<td nowrap class="QRYODD"><input type='checkbox' id='selectedIndex_<%=totalRecords%>' name='selectedIndex_<%=totalRecords%>' value = 'N' onClick="setValue(this);"></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_patient_id%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_encounter_id%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_patient_name%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_gender%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_DOB%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_visit_date%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_bill_number%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_bill_date%></td>
	<td nowrap class="QRYODD">&nbsp;<%=ACTIVE_FLAG_YN_DESC%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_org_bill_doc_ref%></td>
	<td nowrap class="QRYODD">&nbsp;<%=rec_zatca_remarks%></td>
	
	<input type='hidden' name='rowIndex_<%=totalRecords%>' id='rowIndex_<%=totalRecords%>' value="<%=totalRecords%>">
	<input type='hidden' name='doc_type_code_<%=totalRecords%>' id='doc_type_code_<%=totalRecords%>' value="<%=rec_doc_type_code%>">
	<input type='hidden' name='doc_num_<%=totalRecords%>' id='doc_num_<%=totalRecords%>' value="<%=rec_doc_num%>">
	<input type='hidden' name='oper_fac_id_<%=totalRecords%>' id='oper_fac_id_<%=totalRecords%>' value="<%=rec_oper_fac_id%>">
	<input type='hidden' name='ACTIVE_FLAG_YN_<%=totalRecords%>' id='ACTIVE_FLAG_YN_<%=totalRecords%>' value="<%=ACTIVE_FLAG_YN%>">	

	</tr>
<%
			}
		}
%>
	<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value="<%=facility_id%>">
	<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale%>">		
	<input type='hidden' name='patient_id' id='patient_id' id='patient_id' value="<%=patient_id%>">
	<input type='hidden' name='episode_type' id='episode_type' id='episode_type' value="<%=episode_type%>">
	<input type='hidden' name='encounter_id' id='encounter_id' id='encounter_id' value="<%=encounter_id%>">
	<input type='hidden' name='payer_group' id='payer_group' id='payer_group' value="<%=payer_group%>">
	<input type='hidden' name='payer' id='payer' id='payer' value="<%=payer%>">
	<input type='hidden' name='encounter_from_date_str' id='encounter_from_date_str' id='encounter_from_date_str' value="<%=encounter_from_date_str%>">
	<input type='hidden' name='encounter_to_date_str' id='encounter_to_date_str' id='encounter_to_date_str' value="<%=encounter_to_date_str%>">
	<input type='hidden' name='zatcaStatus' id='zatcaStatus' id='zatcaStatus' value="<%=zatcaStatus%>">
	<input type='hidden' name='totalRecords' id='totalRecords' id='totalRecords' value="<%=totalRecords%>">
	<input type='hidden' name='params' id='params' id='params' value='<%=params%>'>	
<%		
		if(totalRecords==0){
%>
	<script>	
		setTimeout(function(){alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"))}, 100);
	</script>
<%		}
		else
		{
			if("E".equals(zatcaStatus)){
%>
	<script>	
		parent.frames[1].document.getElementById('resendToZatca').disabled = false;
	</script>
</form>
</table>
<%		
			}else{
%>
	<script>	
		parent.frames[1].document.getElementById('resendToZatca').disabled = true;
	</script>
<%				
			}
		}
	}
	catch(Exception e){
		System.err.println("Exception in BLChargePatientSearchResult.jsp is ->"+e);
		e.printStackTrace();
	}
	finally{
		ConnectionManager.returnConnection(con);
	}
%>

