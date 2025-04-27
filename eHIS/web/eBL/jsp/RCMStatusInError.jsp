<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,eBL.BLReportIdMapper,webbeans.op.CurrencyFormat,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eBL/js/RCMClaims.js' language='javascript'></script>
<script src='../../eBL/js/RCMClaimsStatusChange.js' language='javascript'></script>
<HTML>
<HEAD>
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
SPAN.LABEL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.LABEL1
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  /*TEXT-ALIGN: LEFT;*/
  TEXT-ALIGN: RIGHT;
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
	</style>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onLoad="loadButtonPage();">
<form name="BLDischClearQueryResult" id="BLDischClearQueryResult">

<table cellpadding=3 cellspacing=0  width="100%" border="1">
<div id="tableContainer">

<%			
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	
	try
	{
		System.err.println("Query String in inerror.jsp:"+request.getQueryString());
		String params = request.getQueryString() ;
		if(params==null || params.equals("")) params="";
		String sql = "";
		int count = 0;
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = (String) p.getProperty("login_user");
		String claim_status = checkForNull(request.getParameter("claim_status"));
		
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
		boolean amountRoundOff = true;
		int noofdecimal=2;
		CurrencyFormat cf1 = new CurrencyFormat();	
		
		con=ConnectionManager.getConnection(request);
		
		pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
		rst = pstmt.executeQuery();	
		if ( rst != null && rst.next()) {
			if(rst.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
				amountRoundOff = false;
			}
		}

		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rst = pstmt.executeQuery();	
		while(rst.next())
		{
			noofdecimal  =  rst.getInt(1);		
		}
			
		sql = "select (select long_desc from ar_cust_group_lang_vw where cust_group_code = a.CUST_GROUP_CODE and language_id = ?) payer_grp_desc, a.CUST_GROUP_CODE payer_grp_code, (select long_name from ar_customer_lang_vw where cust_code = a.cust_code and language_id = ?) payer_desc, a.cust_code payer_code,a.nursing_unit, (select long_desc from bl_ins_policy_types_lang_vw where policy_type_code = a.policy_type_code and language_id = ? and OPERATING_FACILITY_ID = ?) policy_type_desc, a.policy_type_code policy_type_code, a.civil_id civil_id,a.patient_id patient_id, (select short_name from mp_patient_mast where patient_id = a.patient_id) patient_name, decode(a.episode_type,'O','OP','I','IP','E','EM','D','DC') episode_type, a.encounter_id encounter_id, to_char(a.visit_adm_date,'dd/mm/yyyy') visit_adm_date, to_char(a.checkout_disch_date,'dd/mm/yyyy') checkout_disch_date, a.net_bill_amount net_bill_amount, 'In Error' claim_status, to_char(a.claim_status_date,'dd/mm/yyyy') status_date, a.in_error_remarks remarks, a.rcm_id rcm_id from bl_rcm_data_enc_dtl a, ar_customer b where a.cust_code = b.cust_code and claim_status = 'E' and a.patient_id = nvl(?,a.patient_id) and a.episode_type = nvl(?,a.episode_type) and a.encounter_id = nvl(?,a.encounter_id) and a.cust_group_code = nvl(?,a.cust_group_code) and a.cust_code = nvl(?,a.cust_code) and a.policy_type_code = nvl(?,a.policy_type_code) and trunc(a.visit_adm_date) between to_date(nvl(?,trunc(a.visit_adm_date)),'dd/mm/yyyy')-NVL(?,0) and to_date(nvl(?,trunc(a.visit_adm_date)),'dd/mm/yyyy')";
		
		if (!"".equals(qry_spec_nursing_unit_code)){
			sql = sql + "And a.nursing_unit = NVL(?,a.nursing_unit)";
		}

		sql = sql + " ORDER BY a.visit_adm_date desc";
						
		System.err.println("sql in RCMStatusInError.jsp:"+sql);
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
		rst = pstmt.executeQuery();

		while ( rst.next() )
		{	
			String payer_grp_desc = checkForNull(rst.getString("payer_grp_desc"));	
			String payer_desc = checkForNull(rst.getString("payer_desc"));
			String policy_type_code = checkForNull(rst.getString("policy_type_desc"));
			String civil_id = checkForNull(rst.getString("civil_id"));
			String patient_name = checkForNull(rst.getString("patient_name"));
			String patient_id = checkForNull(rst.getString("patient_id"));
			String episode_type = checkForNull(rst.getString("episode_type"));
			String encounter_id = checkForNull(rst.getString("encounter_id"));
			String visit_adm_date = checkForNull(rst.getString("visit_adm_date"));
			String checkout_disch_date = checkForNull(rst.getString("checkout_disch_date"));
			String net_bill_amount = checkForNull(rst.getString("net_bill_amount"));
			if(amountRoundOff) {
			net_bill_amount = cf1.formatCurrency(net_bill_amount, noofdecimal);
			} else {
			net_bill_amount = BLReportIdMapper.truncateUptoTwoDecimal(net_bill_amount, noofdecimal);	
			}
			String claim_status_txt = checkForNull(rst.getString("claim_status"));
			String status_date = checkForNull(rst.getString("status_date"));
			String remarks = checkForNull(rst.getString("remarks"));
			String rcm_id = checkForNull(rst.getString("rcm_id"));
			count++;
%>

<%
			if(count == 1){
%>
<thead>
	<tr>
		<td class='COLUMNHEADER' nowrap width = "2%"><input type='checkbox' name='selectAll' id='selectAll' id='selectAll' onClick="selectAllRecs();"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.CIVIL_ID.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.VISIT_ADMN_DATE.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="eBL.CHKOUT_DISCH_DATE.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.NET_BILL_AMT.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.CLAIM_STATUS.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' nowrap width = "5%"><fmt:message key="eBL.STATUS_DATE.label" bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' width = "5%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>	
	</tr>
</thead>

<%
			}
%>
<tbody>
	<tr id='row<%=count%>' >
		<td class="fields">
			<input type = "checkbox" name='chkbox_<%=count%>' id='chkbox_<%=count%>'  value="N" onClick="updateSelection(this,chkbox_<%=count%>);">
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=payer_grp_desc%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=payer_desc%>
		</td>
		<td class="fields"nowrap>
			&nbsp;<%=policy_type_code%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=civil_id%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=patient_id%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=patient_name%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=episode_type%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=encounter_id%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=visit_adm_date%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=checkout_disch_date%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=net_bill_amount%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=claim_status_txt%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=status_date%>
		</td>
		<td class="fields" nowrap>
			&nbsp;<%=remarks%>
		</td>
		<input type="hidden" name="rcm_id_<%=count%>" id="rcm_id_<%=count%>"  value="<%=rcm_id%>"/>
	</tr>	
<%					
		}
		
		if(count == 0){
%>	
<Script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
<%
		}
%>
	</tbody>
	<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId%>"/>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>"/>
	<input type="hidden" name="login_user" id="login_user" id="login_user" value="<%=login_user%>"/>
	<input type="hidden" name="claim_status" id="claim_status" id="claim_status" value="<%=claim_status%>"/>
	<input type="hidden" name="queryString" id="queryString" id="queryString" value="<%=request.getQueryString()%>"/>
	<input type="hidden" name="total_records" id="total_records" id="total_records" value="<%=count%>"/>
	
</table>	
</div>	
<%
	}catch(Exception e){
		out.println("Exception in RCMStatusInError.jsp: "+e);
		System.err.println("Exception in RCMStatusInError.jsp: "+e);
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	}
%>
</form>
</BODY>
</HTML>

