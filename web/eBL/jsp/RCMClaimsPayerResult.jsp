<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,eBL.BLReportIdMapper,webbeans.op.CurrencyFormat,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
<script src='../../eBL/js/RCMClaims.js' language='javascript'></script>
<script src='../../eBL/js/RCMClaimsStatusChange.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../js/json2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
div.tableContainer {
	width: 100%;		/* table width will be 99% of this*/
	height: 160px; 	/* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}	
		TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
/*SPAN.LABEL
{
  COLOR:#444444;
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}*/
SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
	

</style>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	String classval = "";
	int total_records=0;
	boolean amountRoundOff = true;
	int noofdecimal=2;
	CurrencyFormat cf1 = new CurrencyFormat();
%>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();">
<form name='payerresult' id='payerresult' id='payerresult' method='post'>
<div id="tableContainer">
	<table border='' cellpadding='3' cellspacing='0'  id='tbl' >	
		<thead>
		  <tr>
			<th class='COLUMNHEADER' width='3%'><input type="checkbox" id="selectAll" name="selectAll" id="selectAll" onclick="selectAllRecs()" value=""/></th>
            <th class='COLUMNHEADER' width="8%"><fmt:message key="eBL.PAYER_GROUP.label" bundle="${common_labels}"/></th>
            <th class='COLUMNHEADER' width="8%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></th>
            <th class='COLUMNHEADER' width="8%"><fmt:message key="eBL.POLICY.label" bundle="${common_labels}"/></th>
            <th class='COLUMNHEADER' width="8%"><fmt:message key="eBL.CIVIL_ID.label" bundle="${common_labels}"/></th>
            <th class='COLUMNHEADER' width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
            <th class='COLUMNHEADER' width="15%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
            <th class='COLUMNHEADER' width="8%"><fmt:message key="Common.encountertype.label" bundle="${bl_labels}"/></th>
            <th class='COLUMNHEADER' width="10%"><fmt:message key="Common.encounterid.label" bundle="${bl_labels}"/></th>
            <th class='COLUMNHEADER' width="10%"><fmt:message key="eBL.VISIT_ADMN_DATE.label" bundle="${bl_labels}"/></th>
            <th class='COLUMNHEADER' width="10%"><fmt:message key="eBL.CHKOUT_DISCH_DATE.label" bundle="${bl_labels}"/></th>
            <th class='COLUMNHEADER' width="8%"><fmt:message key="eBL.NET_BILL_AMT.label" bundle="${bl_labels}"/></th>
            <th class='COLUMNHEADER' width="20%"><fmt:message key="eBL.CLAIM_STATUS.label" bundle="${bl_labels}"/></th>
            <th class='COLUMNHEADER'width="10%"><fmt:message key="eBL.STATUS_DATE.label" bundle="${bl_labels}"/></th>
			<th class='COLUMNHEADER' width="10%"></th>
          </tr>
	</thead>
<tbody>	
<% 
try
{
	con =  ConnectionManager.getConnection(request);
	String sql = "";
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_user = (String) p.getProperty("login_user");
	String qclaim_status = checkForNull(request.getParameter("claim_status"));
		
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	String qry_patient_id = checkForNull(request.getParameter("patient_id"));
	String qry_episode_type = checkForNull(request.getParameter("episode_type"));
	String qry_payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String qry_payer_code = checkForNull(request.getParameter("payer_code"));
	String qry_policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String qry_encounter_id = checkForNull(request.getParameter("encounter_id"));
	String qry_enc_frm_date = checkForNull(request.getParameter("enc_frm_date"));
	String qry_enc_to_date = checkForNull(request.getParameter("enc_to_date"));
	String qry_spec_nursing_unit_code = checkForNull(request.getParameter("spec_nursing_unit_code"));
	String qry_past_recs_days = checkForNull(request.getParameter("past_recs_days"));
	String claimNum = "";
	String status = "";
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
	if(qclaim_status.equals("D"))
	status = "Doc Generated/ To be Reviewed";
	if(qclaim_status.equals("R"))
	status = "Review & Approve";
	if(qclaim_status.equals("G"))
	status = "Generate Claim";

	sql = "select (select long_desc from ar_cust_group_lang_vw where cust_group_code = a.CUST_GROUP_CODE and language_id = ?) payer_grp_desc, a.CUST_GROUP_CODE payer_grp_code, (select long_name from ar_customer_lang_vw where cust_code = a.cust_code and language_id = ?) payer_desc, a.cust_code payer_code,a.nursing_unit, (select long_desc from bl_ins_policy_types_lang_vw where policy_type_code = a.policy_type_code and language_id = ? and OPERATING_FACILITY_ID = ?) policy_type_desc, a.policy_type_code policy_type_code, a.civil_id civil_id,a.patient_id patient_id, (select short_name from mp_patient_mast where patient_id = a.patient_id) patient_name, decode(a.episode_type,'O','OP','I','IP','E','EM','D','DC') episode_type, a.encounter_id encounter_id, to_char(a.visit_adm_date,'dd/mm/yyyy') visit_adm_date, to_char(a.checkout_disch_date,'dd/mm/yyyy') checkout_disch_date, a.net_bill_amount net_bill_amount, '"+status+"' claim_status, to_char(a.claim_status_date,'dd/mm/yyyy') status_date, a.claim_no claim_no, a.rcm_id rcm_id from bl_rcm_data_enc_dtl a, ar_customer b where a.cust_code = b.cust_code and claim_status = '"+qclaim_status+"' and a.patient_id = nvl(?,a.patient_id) and a.episode_type = nvl(?,a.episode_type) and a.encounter_id = nvl(?,a.encounter_id) and a.cust_group_code = nvl(?,a.cust_group_code) and a.cust_code = nvl(?,a.cust_code) and a.policy_type_code = nvl(?,a.policy_type_code) and trunc(a.visit_adm_date) between to_date(nvl(?,trunc(a.visit_adm_date)),'dd/mm/yyyy')-NVL(?,0) and to_date(nvl(?,trunc(a.visit_adm_date)),'dd/mm/yyyy')";
		
		if (!"".equals(qry_spec_nursing_unit_code)){
			sql = sql + "And a.nursing_unit = NVL(?,a.nursing_unit)";
		}

		sql = sql + " ORDER BY a.visit_adm_date desc";
	System.err.println("sql in RCMClaimsPayerResult.jsp:"+sql);
		System.err.println("locale:"+locale);
		System.err.println("facilityId:"+facilityId);
		System.err.println("qry_patient_id:"+qry_patient_id);
		System.err.println("qry_episode_type:"+qry_episode_type);
		System.err.println("qry_encounter_id:"+qry_encounter_id);
		System.err.println("qry_payer_grp_code:"+qry_payer_grp_code);
		System.err.println("qry_payer_code:"+qry_payer_code);
		System.err.println("qry_policy_type_code:"+qry_policy_type_code);
		System.err.println("qry_enc_frm_date:"+qry_enc_frm_date);
		System.err.println("qry_enc_to_date:"+qry_enc_to_date);
		System.err.println("qry_spec_nursing_unit_code:"+qry_spec_nursing_unit_code);	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,facilityId);
		pstmt.setString(5,qry_patient_id);
		pstmt.setString(6,qry_episode_type);
		pstmt.setString(7,qry_encounter_id);
		pstmt.setString(8,qry_payer_grp_code);
		pstmt.setString(9,qry_payer_code);
		pstmt.setString(10,qry_policy_type_code);
		pstmt.setString(11,qry_enc_frm_date);
		pstmt.setString(12,qry_past_recs_days);
		pstmt.setString(13,qry_enc_to_date);
		if (!"".equals(qry_spec_nursing_unit_code)){
			pstmt.setString(14,qry_spec_nursing_unit_code);
		}
		rs = pstmt.executeQuery();

	int i=1;	
	if(rs != null)
	{
		while(rs.next()){
			classval = "fields";
			String payer_grp_desc = checkForNull(rs.getString("payer_grp_desc"));	
			String payer_desc = checkForNull(rs.getString("payer_desc"));
			String policy_type_code = checkForNull(rs.getString("policy_type_desc"));
			String civil_id = checkForNull(rs.getString("civil_id"));
			String patient_name = checkForNull(rs.getString("patient_name"));
			String patient_id = checkForNull(rs.getString("patient_id"));
			String episode_type = checkForNull(rs.getString("episode_type"));
			String episode_id = checkForNull(rs.getString("encounter_id"));
			String visit_adm_date = checkForNull(rs.getString("visit_adm_date"));
			String checkout_disch_date = checkForNull(rs.getString("checkout_disch_date"));
			String net_bill_amount = checkForNull(rs.getString("net_bill_amount"));
			String claim_status = checkForNull(rs.getString("claim_status"));
			String claim_status_date = checkForNull(rs.getString("status_date"));
			String claimNo = checkForNull(rs.getString("claim_no"));
			String rcm_id = checkForNull(rs.getString("rcm_id"));
			
			if(amountRoundOff) {
			net_bill_amount = cf1.formatCurrency(net_bill_amount, noofdecimal);
			} else {
			net_bill_amount = BLReportIdMapper.truncateUptoTwoDecimal(net_bill_amount, noofdecimal);	
			}
			if(qclaim_status.equals("G")){
				System.err.println("claimNo "+claimNo);
				if(!claimNo.equals("") && claimNum.equals(""))
				{ 
					claimNum = claimNo;%>
					<tr>
						<td colspan = '15'>claim Number : <%=claimNum%></td>
					</tr>
				<%}
				else if(!claimNo.equals("") && !claimNum.equals("")){
					if(!claimNo.equals(claimNum)){
					 claimNum = claimNo;%>
					<tr>
						<td colspan = '15'>claim Number : <%=claimNum%></td>
					</tr>
				<%}
				}
			}%>
	<tr id=row<%=i%> onclick='highlightRow(<%=i%>,"<%=classval%>");loadServDtls("<%=i%>");'>
				<td id='row<%=i%>_col0' class=<%=classval%> width="3%" nowrap><input type="checkbox" id="chkbox_<%=i%>" name="chkbox_<%=i%>" onClick="updateSelection(this,chkbox_<%=i%>);" value=""></td>
				<td id='row<%=i%>_col1' class=<%=classval%> width="8%"  style="white-space: nowrap">
					<span class="LABEL" name='payer_grp_desc<%=i%>' id='payer_grp_desc<%=i%>' value = '<%=payer_grp_desc%>' ><%=payer_grp_desc%></span>
				</td>

				<td id='row<%=i%>_col2' class=<%=classval%> width="8%" style="white-space: nowrap">
					<span class="LABEL" name='payer_desc<%=i%>' id='payer_desc<%=i%>' value = '<%=payer_desc%>'><%=payer_desc%></span> 
				</td>

				<td id='row<%=i%>_col3' class=<%=classval%> width="8%" style="white-space: nowrap">
					<span class="LABEL" name='policy_type_code<%=i%>' id='policy_type_code<%=i%>' value = '<%=policy_type_code%>'><%=policy_type_code%></span> 
				</td>

				<td id='row<%=i%>_col4' class=<%=classval%> width="8%" style="white-space: nowrap">
					<span class="LABEL" name='civil_id<%=i%>' id='civil_id<%=i%>' value = '<%=civil_id%>'><%=civil_id%></span>
				</td>

				<td id='row<%=i%>_col5' class=<%=classval%> width="10%" style="white-space: nowrap">
					<span class="LABEL" name='patient_id<%=i%>' id='patient_id<%=i%>' value = '<%=patient_id%>'><%=patient_id%></span> 
				</td>
				
				<td id='row<%=i%>_col6' class=<%=classval%> width="15%" style="white-space: nowrap">
					<span class="LABEL" name='patient_name<%=i%>' id='patient_name<%=i%>' value = '<%=patient_name%>'><%=patient_name%></span> 
				</td>

				<td id='row<%=i%>_col7' class=<%=classval%> width="8%" style="white-space: nowrap">
					<span class="LABEL" name='episode_type<%=i%>' id='episode_type<%=i%>' value = '<%=episode_type%>'><%=episode_type%></span> 
				</td>

				<td id='row<%=i%>_col8' class=<%=classval%> width="10%" style="white-space: nowrap">
					<span class="LABEL" name='episode_id<%=i%>' id='episode_id<%=i%>' value = '<%=episode_id%>'><%=episode_id%></span> 
				</td>

				<td id='row<%=i%>_col9' class=<%=classval%> width="10%" style="white-space: nowrap">
					<span class="LABEL" name='visit_adm_date<%=i%>' id='visit_adm_date<%=i%>' value = '<%=visit_adm_date%>'><%=visit_adm_date%></span> 
				</td>

				<td id='row<%=i%>_col10' class=<%=classval%> width="10%" style="white-space: nowrap">
					<span class="LABEL" name='checkout_disch_date<%=i%>' id='checkout_disch_date<%=i%>' value = '<%=checkout_disch_date%>'><%=checkout_disch_date%></span> 
				</td>

				<td id='row<%=i%>_col11' class=<%=classval%> width="8%" style="white-space: nowrap">
					<span class="LABEL" name='net_bill_amount<%=i%>' id='net_bill_amount<%=i%>' value = '<%=net_bill_amount%>'><%=net_bill_amount%></span> 
				</td>

				<td id='row<%=i%>_col12' class=<%=classval%> width="20%" style="white-space: nowrap">
					<span class="LABEL" name='claim_status_<%=i%>' id='claim_status_<%=i%>' ><%=claim_status%></span> 
				</td>

				<td id='row<%=i%>_col13' class=<%=classval%> width="10%" style="white-space: nowrap">
					<span class="LABEL" name='claim_status_date<%=i%>' id='claim_status_date<%=i%>' value = '<%=claim_status_date%>'><%=claim_status_date%></span> 
				</td>
				
				<td id='row<%=i%>_col14' class=<%=classval%> width="10%" style="white-space: nowrap">
					<span class="mandHide" name='folder<%=i%>' id='folder<%=i%>' onclick ="folderClick('<%=i%>')" value = ''><img  src='../../eCommon/images/folder.gif'></span> 
					<!--<span class='mandHide'><img src='../../eCommon/images/mandatory.gif'></span>-->
				</td>
				
			</tr>
			<input type='hidden' name='rcm_id<%=i%>' id='rcm_id<%=i%>'  value = '<%=rcm_id%>'>
			<input type="hidden" name="claimNo<%=i%>" id="claimNo<%=i%>"  value="<%=claimNo%>"/>
 <%
		i++;
		total_records++;
		}
	}
%>
	</tbody>
	<br>	
		<input type='hidden' name='total_records' id='total_records' id='total_records' value='<%=total_records%>'>
		<input type='hidden' name='total' id='total' id='total' value='<%=total_records%>'>
        <input type='hidden' name='rowClicked' id='rowClicked' id='rowClicked' value = ''>	
		<input type='hidden' name='checkpayer' id='checkpayer' id='checkpayer' value = ''>	
		<input type='hidden' name='payergrpdesc' id='payergrpdesc' id='payergrpdesc' value = ''>	
		<input type='hidden' name='payerdesc' id='payerdesc' id='payerdesc' value = ''>	
		<input type='hidden' name='policytypecode' id='policytypecode' id='policytypecode' value = ''>	
		<input type='hidden' name='civilid' id='civilid' id='civilid' value = ''>	
		<input type='hidden' name='patientid' id='patientid' id='patientid' value = ''>	
		<input type='hidden' name='patientname' id='patientname' id='patientname' value = ''>	
		<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value = ''>	
		<input type='hidden' name='episodeId' id='episodeId' id='episodeId' value = ''>	
		<input type='hidden' name='visitadmdate' id='visitadmdate' id='visitadmdate' value = ''>	
		<input type='hidden' name='checkoutdischdate' id='checkoutdischdate' id='checkoutdischdate' value = ''>	
		<input type='hidden' name='netbillamount' id='netbillamount' id='netbillamount' value = ''>	
		<input type='hidden' name='claimstatus' id='claimstatus' id='claimstatus' value = ''>	
		<input type='hidden' name='claimstatusdate' id='claimstatusdate' id='claimstatusdate' value = ''>	
		<input type='hidden' name='folder' id='folder' id='folder' value = ''>	
		<input type="hidden" name="claim_status" id="claim_status" id="claim_status" value="<%=qclaim_status%>"/>
		<input type="hidden" name="queryString" id="queryString" id="queryString" value="<%=request.getQueryString()%>"/>		
<%			
	if(total_records>0){
		out.println("<script>");
		out.println("highlightRow(1,'"+classval+"');loadServDtls(1);");
		out.println("</script>");
	}		
 %>
		</table>
	</div>
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

