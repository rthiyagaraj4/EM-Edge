<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64,eBL.BLReportIdMapper,webbeans.op.CurrencyFormat"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eBL/js/BLDischClear.js"></script>
<script src='../../eBL/js/RCMClaimsStatusChange.js' language='javascript'></script>
<HTML>
<HEAD>
</HEAD>
<style>
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
table {
   border-collapse: collapse;
}

</style>
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

<table border='' width="100%" cellspacing='0' cellpadding='3' align='center'>  
	<thead>
		<th class='COLUMNHEADER' nowrap></th>
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.Bill.label" bundle="${bl_labels}"/>#</th>
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.BILLING_SERVICE_CODE.label" bundle="${bl_labels}"/></th>
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.Description.label" bundle="${bl_labels}"/></th>
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.IRBServiceDate.label" bundle="${bl_labels}"/></th>
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.MCNno.label" bundle="${common_labels}"/></th>
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.INVOICE_AMT.label" bundle="${bl_labels}"/></th>
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.CLAIM_AMT.label" bundle="${bl_labels}"/>
		(<fmt:message key="eBL.Net.label" bundle="${bl_labels}"/>)</th>
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAT_SHARE.label" bundle="${bl_labels}"/>(<fmt:message key="eBL.Net.label" bundle="${bl_labels}"/>)</th>	
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.INS_STATUS.label" bundle="${bl_labels}"/></th>	
		<th class='COLUMNHEADER' nowrap><fmt:message key="eBL.Remarks.label" bundle="${bl_labels}"/></th>	
	</thead>
<tbody>
<%			
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		int total_records=0;
		boolean amountRoundOff = true;
		int noofdecimal=2;
		CurrencyFormat cf1 = new CurrencyFormat();
		
		try
		{
			
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String sql = "";
			int i=0;
			String classval="LABEL";
			java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_user = (String) p.getProperty("login_user");
			String facilityId = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");
			String rcm_id=checkForNull(request.getParameter("rcm_id"));
			String claim_status=checkForNull(request.getParameter("claim_status"));
			String qpatient_id = checkForNull(request.getParameter("patient_id"));
			String qencounter_id = checkForNull(request.getParameter("encounter_id"));
			String qpayer_group = checkForNull(request.getParameter("payer_grp_code"));
			String qpayer = checkForNull(request.getParameter("payer_code"));
			String qpolicy = checkForNull(request.getParameter("policy_type_code"));
			String qeffective_from = checkForNull(request.getParameter("enc_frm_date"));
			String qeffective_to = checkForNull(request.getParameter("enc_to_date"));
			String qclaim_number = checkForNull(request.getParameter("claim_number"));
			String qclaim_status = checkForNull(request.getParameter("claim_status"));
			String qepisode_type = checkForNull(request.getParameter("episode_type"));
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
			
			sql="SELECT (dtl.bill_doc_type_code || '/' || dtl.bill_doc_num) bill_number, dtl.blng_serv_code service_code, dtl.blng_serv_desc service_desc, TO_CHAR (dtl.service_date, 'dd/mm/yyyy HH:MI:SS') service_date, dtl.mcn_number mcn_number, dtl.invoice_amt invoice_amt, dtl.claim_amt claim_amt, dtl.patient_share_amt patient_share_amt,dtl.ins_feedback_status ins_feedback_status,dtl.remarks FROM bl_rcm_data_serv_dtls dtl, bl_rcm_data_enc_dtl hdr WHERE hdr.rcm_id = dtl.rcm_id and hdr.rcm_id = '"+rcm_id+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			if(rst != null)
	{
			while ( rst.next() )
			{	
				String bill = checkForNull(rst.getString("bill_number"));	
				String BLNG_SERV_CODE = checkForNull(rst.getString("service_code"));	
				String BLNG_SERV_DESC = checkForNull(rst.getString("service_desc"));	
				String SERVICE_DATE = checkForNull(rst.getString("service_date"));	
				String MCN_NUMBER = checkForNull(rst.getString("mcn_number"));	
				String INVOICE_AMT = checkForNull(rst.getString("invoice_amt"));
				String CLAIM_AMT = checkForNull(rst.getString("claim_amt"));	
				String PATIENT_SHARE_AMT = checkForNull(rst.getString("patient_share_amt"));	
				String INS_FEEDBACK_STATUS = checkForNull(rst.getString("ins_feedback_status"));
				String REMARKS = checkForNull(rst.getString("remarks"));
				if(amountRoundOff) {
						INVOICE_AMT = cf1.formatCurrency(INVOICE_AMT, noofdecimal);
				} else {
						INVOICE_AMT = BLReportIdMapper.truncateUptoTwoDecimal(INVOICE_AMT, noofdecimal);	
				}
				
				if(amountRoundOff) {
						CLAIM_AMT = cf1.formatCurrency(CLAIM_AMT, noofdecimal);
				} else {
						CLAIM_AMT = BLReportIdMapper.truncateUptoTwoDecimal(CLAIM_AMT, noofdecimal);	
				}

				if(amountRoundOff) {
						PATIENT_SHARE_AMT = cf1.formatCurrency(PATIENT_SHARE_AMT, noofdecimal);
				} else {
						PATIENT_SHARE_AMT = BLReportIdMapper.truncateUptoTwoDecimal(PATIENT_SHARE_AMT, noofdecimal);	
				}
%>
	<tr>
		<td class="fields" nowrap></td>
		<td class="fields" nowrap><%=bill%></td>
		<td class="fields" nowrap><%=BLNG_SERV_CODE%></td>
		<td class="fields" nowrap><%=BLNG_SERV_DESC%></td>
		<td class="fields" nowrap><%=SERVICE_DATE%></td>
		<td class="fields" nowrap><%=MCN_NUMBER%></td>
		<td class="fields" nowrap><%=INVOICE_AMT%></td>
		<td class="fields" nowrap><%=CLAIM_AMT%></td>
		<td class="fields" nowrap><%=PATIENT_SHARE_AMT%></td>
		<td class="fields" nowrap><%=INS_FEEDBACK_STATUS%></td>
		<td class="fields" nowrap><%=REMARKS%></td>
	</tr>	
<%		
	i++;
	}
}
%>	
</tbody>
	<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId%>"/>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>"/>
	<input type="hidden" name="login_user" id="login_user" id="login_user" value="<%=login_user%>"/>
	<input type="hidden" name="total_rec" id="total_rec" id="total_rec" value="<%=i%>"/>
	<input type="hidden" name="claim_status" id="claim_status" id="claim_status" value="<%=claim_status%>"/>
	<input type="hidden" name="queryString" id="queryString" id="queryString" value="<%=request.getQueryString()%>"/>	
</table>		
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

