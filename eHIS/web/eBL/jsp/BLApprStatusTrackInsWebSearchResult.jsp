<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eBL.*, eBL.Common.*, eCommon.Common.*,webbeans.eCommon.*,com.ehis.util.*,eBL.BLReportIdMapper,webbeans.op.CurrencyFormat" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eBL/js/BLApprStatusTrackSearch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	int i=1;
	String classval = "label";
	String user = checkForNull(request.getParameter("user"));
	String strclientip = checkForNull(request.getParameter("strclientip"));
	String customerCode = checkForNull(request.getParameter("customerCode"));
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String view = checkForNull(request.getParameter("view"));
	String encounterFromDate = checkForNull(request.getParameter("encounterFromDate"));
	String encounterToDate = checkForNull(request.getParameter("encounterToDate"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String val = checkForNull(request.getParameter("val"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String service_code = checkForNull(request.getParameter("service_code"));
	String apprvSts_AAKHYN = checkForNull(request.getParameter("apprvSts_AAKHYN"));//V230425
	String PreAuthEclaimYN = checkForNull(request.getParameter("PreAuthEclaimYN"));//V230822
	boolean amountRoundOff = true;
	int noofdecimal=2;
	CurrencyFormat cf1 = new CurrencyFormat();
	System.err.println(PreAuthEclaimYN);
	System.err.println("val "+val);
%>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();">
<form name='websearchresult' id='websearchresult' id='web_result' method='post'>
<div>
	<table width='100%' align="center" border = "1" style = "border-collapse: collapse;" cellspacing="0">
        <thead>
		  <tr>
			<% if(apprvSts_AAKHYN.equals("Y") || PreAuthEclaimYN.equals("Y")){
				if(view.equals("F")){%>
				<th class='columnheadercenter'></th>
				 <%}%>
				<th class='columnheadercenter'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
				
				<th class='columnheadercenter'><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
				<% if(view.equals("F")){%>
				<th class='columnheadercenter'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.ServicesName.label" bundle="${bl_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.ServiceAmount.label" bundle="${bl_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.ServiceQnty.label" bundle="${bl_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.ApprovedAmt.label" bundle="${bl_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.APPROVED_QTY.label" bundle="${bl_labels}"/></th>
			<%}
				if(!PreAuthEclaimYN.equals("Y")){%>
				<th class='columnheadercenter'><fmt:message key="eBL.ViewDocument.label" bundle="${bl_labels}"/></th>
				<%}
			}else{ 
				if(view.equals("F")){%>
				<th class='columnheadercenter'></th>
				 <%}%>
				<th class='columnheadercenter'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
				<% if(view.equals("F")){%>
				<th class='columnheadercenter'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.ServicesName.label" bundle="${bl_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.ServiceAmount.label" bundle="${bl_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.ServiceQnty.label" bundle="${bl_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.ApprovedAmt.label" bundle="${bl_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="eBL.APPROVED_QTY.label" bundle="${bl_labels}"/></th>
			<%}
			}%>
          </tr>
		</thead>
<tbody>	
<% 
try
{
	con =  ConnectionManager.getConnection(request);
	String patientId = "";
	String patientName = "";
	String mobileNo = "";
	String encounterId = "";
	String epiType = "";
	String servName = "";
	String servAmt = "";
	String servQty = "";
	String appAmt = "";
	String appQty = "";
	String query_interface = "";
	String payer_group = "";
	String payer = "";
	String policy = "";
	String visitDate="";//V230425
	String Practitioner="";//V230425
	String Speciality="";//V230425
	String specialty_code="";
	String viewDocEnable="";//V230425
	
	pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
	rs = pstmt.executeQuery();	
	if ( rs != null && rs.next()) {
	if(rs.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
					amountRoundOff = false;
	}
	}

	pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
	rs = pstmt.executeQuery();	
	while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);		
			}	

	if(view.equals("F")){
	 if(apprvSts_AAKHYN.equals("Y")){//V230425
		query_interface = "SELECT a.patient_id, DECODE ('"+locale+"', 'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name) ) patient_name, NVL (contact2_no, contact1_no ) mobile_no, DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) ) encounter_id, a.episode_type, a.blng_serv_name, service_amt, service_qty, approved_amt, approved_qty,c.visit_adm_date_time,c.admit_practitioner_id, c.attend_practitioner_id,am_get_desc.am_practitioner(c.attend_practitioner_id,'en',1) attend_practitioner_name,c.specialty_code,am_get_desc.am_speciality (c.specialty_code, 'en', 2) specialty_desc,a.cust_code cust_code FROM bl_ins_dash_serv_data_temp a, mp_patient b,pr_encounter c WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id AND a.patient_id = c.patient_id  and DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) )= c.encounter_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND ins_status = '"+val+"' AND a.blng_serv_name = NVL ('"+service_code+"', a.blng_serv_name) AND a.patient_id = NVL('"+patient_id+"',a.patient_id) AND a.episode_id = NVL('"+encounter_id+"',a.episode_id)";
	
	}else{
	query_interface = "SELECT DISTINCT a.patient_id, DECODE ('"+locale+"', 'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name) ) patient_name, NVL (contact2_no, contact1_no ) mobile_no, DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) ) encounter_id, a.episode_type, a.blng_serv_name, service_amt, service_qty, approved_amt, approved_qty, a.cust_code cust_code FROM bl_ins_dash_serv_data_temp a, mp_patient b WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND ins_status = '"+val+"' AND a.blng_serv_name = NVL ('"+service_code+"', a.blng_serv_name) AND a.patient_id = NVL('"+patient_id+"',a.patient_id) AND a.episode_id = NVL('"+encounter_id+"',a.episode_id)";
	}
	pstmt = con.prepareStatement(query_interface);		
	rs = pstmt.executeQuery();		
	if(rs != null)
	{
		while(rs.next()){
			patientId = rs.getString("patient_id");
			patientName = rs.getString("patient_name");
			mobileNo = rs.getString("mobile_no");
			encounterId = rs.getString("encounter_id");
			epiType = rs.getString("episode_type");
			servName = rs.getString("blng_serv_name");
			servAmt = rs.getString("service_amt");
			servQty = rs.getString("service_qty");
			appAmt = rs.getString("approved_amt");
			appQty = rs.getString("approved_qty");
			if(apprvSts_AAKHYN.equals("Y")){//V230425
				visitDate= rs.getString("visit_adm_date_time");
				//Practitioner= rs.getString("admit_practitioner_name");
				Practitioner= rs.getString("attend_practitioner_name");//44758
				Speciality= rs.getString("specialty_desc");
				payer= rs.getString("cust_code");
				viewDocEnable="disabled";
				if(Practitioner == null)
				{
				Practitioner = "";
				}
				if(Speciality == null)
				{
				Speciality = "";
				}
			
			}
			if(mobileNo == null)
			{
			mobileNo = "";
			}
			if(appAmt == null)
			{
			appAmt = "";
			}
			if(appQty == null)
			{
			appQty = "";
			}
			
			if(amountRoundOff) {
			servAmt = cf1.formatCurrency(servAmt, noofdecimal);
			} else {
			servAmt = BLReportIdMapper.truncateUptoTwoDecimal(servAmt, noofdecimal);	
			}

			if(amountRoundOff) {
			appAmt = cf1.formatCurrency(appAmt, noofdecimal);
			} else {
			appAmt = BLReportIdMapper.truncateUptoTwoDecimal(appAmt, noofdecimal);	
			}

%>
			
	<tr id=row<%=i%>>
				<td id='row<%=i%>_col0' class=<%=classval%> nowrap><input type="radio" id="bl_patient_demo_<%=i%>" name="bl_patient_demo" onclick="changeFieldColor('<%=i%>')" value=""></td>
				<td id='row<%=i%>_col1' class=<%=classval%> width="10%" class="fields" style="white-space: nowrap">
					<span class="LABEL" name='patientId<%=i%>' id='patientId<%=i%>' value = '<%=patientId%>' ><%=patientId%></span>
					<!--<a class="LABEL" name='patientId<%=i%>' id='patientId<%=i%>' href="javascript:changeFieldColor('<%=i%>');" value = '<%=patientId%>'><%=patientId%></a>--> 
				</td>

				<td id='row<%=i%>_col2' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='patientName<%=i%>' id='patientName<%=i%>' value = '<%=patientName%>'><%=patientName%></span> 
				</td>
				<% if(apprvSts_AAKHYN.equals("Y")){//V230425 %>
					<td id='row<%=i%>_col' class=<%=classval%> width="10%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='visitDate<%=i%>' id='visitDate<%=i%>' value = '<%=visitDate%>'><%=visitDate%></span> 
					</td>
					<td id='row<%=i%>_col' class=<%=classval%> width="15%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='payer<%=i%>' id='payer<%=i%>' value = '<%=payer%>'><%=payer%></span> 
					</td>
					<td id='row<%=i%>_col' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='Practitioner<%=i%>' id='Practitioner<%=i%>' value = '<%=Practitioner%>'><%=Practitioner%></span> 
					</td>
					<td id='row<%=i%>_col' class=<%=classval%> width="10%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='Speciality<%=i%>' id='Speciality<%=i%>' value = '<%=Speciality%>'><%=Speciality%></span> 
					</td>

				 <% } %>
				<td id='row<%=i%>_col3' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='mobileNo<%=i%>' id='mobileNo<%=i%>' value = '<%=mobileNo%>'><%=mobileNo%></span> 
				</td>

				<td id='row<%=i%>_col4' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='encounterId<%=i%>' id='encounterId<%=i%>' value = '<%=encounterId%>'><%=encounterId%></span>
				</td>

				<td id='row<%=i%>_col5' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='epiType<%=i%>' id='epiType<%=i%>' value = '<%=epiType%>'><%=epiType%></span> 
				</td>
				
				<td id='row<%=i%>_col6' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='servName<%=i%>' id='servName<%=i%>' value = '<%=servName%>'><%=servName%></span> 
				</td>

				<td id='row<%=i%>_col7' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='servAmt<%=i%>' id='servAmt<%=i%>' value = '<%=servAmt%>'><%=servAmt%></span> 
				</td>

				<td id='row<%=i%>_col8' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='servQty<%=i%>' id='servQty<%=i%>' value = '<%=servQty%>'><%=servQty%></span> 
				</td>

				<td id='row<%=i%>_col9' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='appAmt<%=i%>' id='appAmt<%=i%>' value = '<%=appAmt%>'><%=appAmt%></span> 
				</td>

				<td id='row<%=i%>_col10' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='appQty<%=i%>' id='appQty<%=i%>' value = '<%=appAmt%>'><%=appQty%></span> 
				</td>
				<% if(apprvSts_AAKHYN.equals("Y")){//V230425 %>
					<td id='row<%=i%>_col3' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
						<a class="LABEL" name='viewDoc<%=i%>' id='viewDoc<%=i%>' href="javascript:viewDocument('<%=i%>');" value = '' <%=viewDocEnable%>>view Document</a> 
					</td>
				<% } %>
			</tr>
 <%
		i++;
		}
	}
	if(i == 1)
		{%>
		<script>
		alert("Query caused no records to be retrieved");
		parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
		parent.lookup_cancel.location.href = "../../eCommon/html/blank.html";
		</script>
		<%}
	}
	else if(view.equals("R") || (PreAuthEclaimYN.equals("Y") && view.equals(""))){
	/*	if(apprvSts_AAKHYN.equals("Y") || PreAuthEclaimYN.equals("Y")){ //V230425
			query_interface = "SELECT patient_id,patient_name,mobile_no, encounter_id,episode_type, cust_group_code, cust_code, policy_type_code,specialty_desc,visit_adm_date_time,attend_practitioner_name FROM (SELECT a.patient_id patient_id, DECODE ('"+locale+"', 'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name) ) patient_name, NVL (contact2_no, contact1_no ) mobile_no, DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) ) encounter_id, a.episode_type episode_type, a.cust_group_code cust_group_code, a.cust_code cust_code, a.policy_type_code policy_type_code,c.visit_adm_date_time visit_adm_date_time,c.admit_practitioner_id admit_practitioner_id, c.attend_practitioner_id attend_practitioner_id,am_get_desc.am_practitioner(c.attend_practitioner_id,'en',1) attend_practitioner_name ,c.specialty_code specialty_code,am_get_desc.am_speciality (c.specialty_code, 'en', 2) specialty_desc FROM bl_ins_dash_serv_data_temp a, mp_patient b,pr_encounter c WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id and a.patient_id = c.patient_id and DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) ) = c.encounter_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND a.patient_id = NVL('"+patient_id+"',a.patient_id) AND a.episode_id = NVL('"+encounter_id+"',a.episode_id) and a.INS_STATUS = '"+val+"') group by patient_name,patient_id, mobile_no, encounter_id,EPISODE_TYPE, CUST_GROUP_CODE, CUST_CODE,POLICY_TYPE_CODE,specialty_desc,visit_adm_date_time,attend_practitioner_name";
			
			
		}else{
		query_interface = "SELECT patient_id, patient_name, mobile_no, encounter_id, episode_type, cust_group_code, cust_code, policy_type_code FROM (SELECT a.patient_id patient_id, DECODE ('"+locale+"', 'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name) ) patient_name, NVL (contact2_no, contact1_no ) mobile_no, DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) ) encounter_id, a.episode_type episode_type, a.cust_group_code cust_group_code, a.cust_code cust_code, a.policy_type_code policy_type_code FROM bl_ins_dash_serv_data_temp a, mp_patient b WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND a.patient_id = NVL('"+patient_id+"',a.patient_id) AND a.episode_id = NVL('"+encounter_id+"',a.episode_id) and a.INS_STATUS = '"+val+"') group by patient_name,patient_id, mobile_no, encounter_id,EPISODE_TYPE, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE";
		}
		*/
		
	if(apprvSts_AAKHYN.equals("Y") || PreAuthEclaimYN.equals("Y")){ //V230425
		query_interface = "SELECT patient_id,patient_name,mobile_no, encounter_id,episode_type, cust_group_code, cust_code, policy_type_code,specialty_desc,specialty_code,visit_adm_date_time,attend_practitioner_name FROM (SELECT a.patient_id patient_id, DECODE ('"+locale+"', 'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name) ) patient_name, NVL (SUBSTR (contact2_no, 1, 16), SUBSTR (contact1_no, 1, 16) ) mobile_no, DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) ) encounter_id, a.episode_type episode_type, a.cust_group_code cust_group_code, a.cust_code cust_code, a.policy_type_code policy_type_code,c.visit_adm_date_time visit_adm_date_time,c.admit_practitioner_id admit_practitioner_id, c.attend_practitioner_id attend_practitioner_id,am_get_desc.am_practitioner(c.attend_practitioner_id,'en',1) attend_practitioner_name ,c.specialty_code specialty_code,am_get_desc.am_speciality (c.specialty_code, 'en', 2) specialty_desc FROM bl_ins_dash_serv_data_temp a, mp_patient b,pr_encounter c WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id and a.patient_id = c.patient_id and DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) ) = c.encounter_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND a.patient_id = NVL('"+patient_id+"',a.patient_id) AND a.episode_id = NVL('"+encounter_id+"',a.episode_id) and a.INS_STATUS = '"+val+"') group by patient_name,patient_id, mobile_no, encounter_id,EPISODE_TYPE, CUST_GROUP_CODE, CUST_CODE,POLICY_TYPE_CODE,specialty_code,specialty_desc,visit_adm_date_time,attend_practitioner_name";
	}else{
		query_interface = "SELECT patient_id, patient_name, mobile_no, encounter_id, episode_type, cust_group_code, cust_code, policy_type_code FROM (SELECT a.patient_id patient_id, DECODE ('"+locale+"', 'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name) ) patient_name, NVL (SUBSTR (contact2_no, 1, 16), SUBSTR (contact1_no, 1, 16) ) mobile_no, DECODE (a.episode_type, 'I', a.episode_id, 'D', a.episode_id, 'O', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')), 'E', a.episode_id || LTRIM (TO_CHAR (a.visit_id, '0000')) ) encounter_id, a.episode_type episode_type, a.cust_group_code cust_group_code, a.cust_code cust_code, a.policy_type_code policy_type_code FROM bl_ins_dash_serv_data_temp a, mp_patient b WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND a.patient_id = NVL('"+patient_id+"',a.patient_id) AND a.episode_id = NVL('"+encounter_id+"',a.episode_id) and a.INS_STATUS = '"+val+"') group by patient_name,patient_id, mobile_no, encounter_id,EPISODE_TYPE, CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE";
	}
	System.err.println("query_interface "+query_interface);
	pstmt = con.prepareStatement(query_interface);	
	rs = pstmt.executeQuery();		
	if(rs != null)
	{
		while(rs.next()){
			patientId = rs.getString("patient_id");
			patientName = rs.getString("patient_name");
			mobileNo = rs.getString("mobile_no");
			encounterId = rs.getString("encounter_id");
			epiType = rs.getString("episode_type");
			payer_group = rs.getString("cust_group_code");
			payer = rs.getString("cust_code");
			policy = rs.getString("policy_type_code");
			if(apprvSts_AAKHYN.equals("Y") || PreAuthEclaimYN.equals("Y") ){//V230425 V230822
				visitDate= rs.getString("visit_adm_date_time");
				specialty_code= rs.getString("specialty_code");
				Practitioner= rs.getString("attend_practitioner_name");//44758
				Speciality= rs.getString("specialty_desc");
				viewDocEnable="disabled";
				if(Practitioner == null)
				{
				Practitioner = "";
				}
				if(Speciality == null)
				{
				Speciality = "";
				}
			}
			
			
			if(mobileNo == null)
			{
			mobileNo = "";
			}
%>
			
	<tr id=row<%=i%>>
				
				<td id='row<%=i%>_col0' class=<%=classval%> width="10%" class="fields" style="white-space: nowrap">
					<span class="LABEL" name='patientId<%=i%>' id='patientId<%=i%>' value = '<%=patientId%>'><%=patientId%></span> 
				</td>

				<td id='row<%=i%>_col1' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='patientName<%=i%>' id='patientName<%=i%>' value = '<%=patientName%>'><%=patientName%></span> 
				</td>
				<% if(apprvSts_AAKHYN.equals("Y") || PreAuthEclaimYN.equals("Y") ){//V230425 %>
					<td id='row<%=i%>_col' class=<%=classval%> width="10%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='visitDate<%=i%>' id='visitDate<%=i%>' value = '<%=visitDate%>'><%=visitDate%></span> 
					</td>
					<td id='row<%=i%>_col' class=<%=classval%> width="15%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='payer<%=i%>' id='payer<%=i%>' value = '<%=payer%>'><%=payer%></span> 
					</td>
					<td id='row<%=i%>_col' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='Practitioner<%=i%>' id='Practitioner<%=i%>' value = '<%=Practitioner%>'><%=Practitioner%></span> 
					</td>
					<td id='row<%=i%>_col' class=<%=classval%> width="10%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='Speciality<%=i%>' id='Speciality<%=i%>' value = '<%=Speciality%>'><%=Speciality%></span> 
					</td> 
					<input type='hidden' name='specialty_code<%=i%>' id='specialty_code<%=i%>' value='<%=specialty_code%>'>
				 <% } %>
				<td id='row<%=i%>_col2' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='mobileNo<%=i%>' id='mobileNo<%=i%>' value = '<%=mobileNo%>' ><%=mobileNo%></span> 
				</td>

				<td id='row<%=i%>_col3' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<!--<span class="LABEL" name='encounterId<%=i%>' id='encounterId<%=i%>'><%=encounterId%></span>-->
					<a class="LABEL" name='encounterId<%=i%>' id='encounterId<%=i%>' href="javascript:recApprvlData('<%=i%>');" value = '<%=encounterId%>'><%=encounterId%></a> 
				</td>
				<% if(apprvSts_AAKHYN.equals("Y")){//V230425 %>
					<td id='row<%=i%>_col3' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
						<a class="LABEL" name='viewDoc<%=i%>' id='viewDoc<%=i%>' href="javascript:viewDocument('<%=i%>');" value = '' <%=viewDocEnable%>>view Document</a> 
					</td>
				<% } %>
			</tr>
			<input type='hidden' name='payer_group<%=i%>' id='payer_group<%=i%>' value='<%=payer_group%>'>
			<input type='hidden' name='payer<%=i%>' id='payer<%=i%>' value='<%=payer%>'>
			<input type='hidden' name='policy<%=i%>' id='policy<%=i%>' value='<%=policy%>'>
			<input type='hidden' name='epiType<%=i%>' id='epiType<%=i%>' value='<%=epiType%>'>
 <%
		i++;
		}
	}
	}
%>
	<input type='hidden' name='Effective_from' id='Effective_from' id='Effective_from' value='<%=encounterFromDate%>'>
	<input type='hidden' name='Effective_to' id='Effective_to' id='Effective_to' value='<%=encounterToDate%>'>
	<input type='hidden' name='PreAuthEclaimYN' id='PreAuthEclaimYN' id='PreAuthEclaimYN' value='<%=PreAuthEclaimYN%>'>  
	<input type='hidden' name='val' id='val' id='val' value='<%=val%>'><!--V230927 / NMC-JD-CRF-0102.2 -->
	
	<input type='hidden' name='prevClicked' id='prevClicked' value="" />
	<input type='hidden' name='patient_Id' id='patient_Id' value="" />
	</tbody>
<%				
		}
		catch(Exception eX)
		{		
			out.println("Error= "+eX);		
		}
		finally
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
%>	
         
		</table>
	</div>
	</form>
  </body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

