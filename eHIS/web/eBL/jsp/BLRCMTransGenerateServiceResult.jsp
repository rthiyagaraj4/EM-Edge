<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,java.util.*,com.ehis.util.*,webbeans.op.CurrencyFormat,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/RCMTransactions.js"></script>
<HTML>
<HEAD>
<style>

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
<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;

		try{
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			System.err.println("params is: "+params);
			
			String facility_id = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");
			
			con=ConnectionManager.getConnection(request);
			String sql = "";
			
			String appr_doc_ref_num = checkForNull(request.getParameter("appr_doc_ref_num"));
			String billDocTypeCode = checkForNull(request.getParameter("billDocTypeCode"));
			String billNum =checkForNull(request.getParameter("billNum"));
			String claimId =checkForNull(request.getParameter("claimId"));
			String insuranceStatus =checkForNull(request.getParameter("insuranceStatus"));
			String claims_services_level = checkForNull(request.getParameter("claims_services_level"));			
			
			String blngServCode = "", blngServDesc = "", servAmt = "",apprAmt = "",servQty = "",apprQty = "",remarks ="",claimStatus = "", claimStatusDesc = "",dt_time = ""; 
			int serv_tot_rec = 0;
			CurrencyFormat cf1 = new CurrencyFormat();	
			boolean amountRoundOff = true;
			int noofdecimal=2;
			
			try{
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
					
				}
				catch(Exception e)
				{
					System.out.println("Exception in try of BLRCMTransGenerateBillResult.jsp for currency setup --"+e.toString());
					e.printStackTrace();
				}
%>

<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();">
<form name="BLRCMTransGenerateBillRes" id="BLRCMTransGenerateBillRes">


<%	

			try
			{
				
		
				sql = "SELECT a.BLNG_SERV_CODE,a.serv_item_desc blng_serv_desc,  a.SERV_AMT,a.APPROVED_AMT,a.SERV_QTY,a.APPROVED_QTY, "+
						"a.REMARKS,a.CLAIM_STATUS CLAIM_STATUS, to_char(SERVICE_DATE,'dd/MM/yyyy HH24:mi:ss') as SERVICE_DATE, "+
						"c.LIST_ELMT_LABEL as claim_status_desc "+
						"FROM bl_claim_service_dtl a, sm_list_item c  "+
						"WHERE (operating_facility_id, bill_doc_type_code, bill_doc_num) IN ( "+
						"SELECT b.operating_facility_id, b.bill_doc_type_code,b.bill_doc_num "+
						"FROM bl_claim_bill_dtl b WHERE b.operating_facility_id = ? and b.bill_doc_type_code = ? and b.bill_doc_num = ?  )"+
						"AND a.claim_status = c.LIST_ELMT_VALUE "+
						"AND c.MODULE_ID = 'BL' "+
						"AND c.LIST_REF = 'L_INS_CLAIM_STATUS' " ;
						
						if("S".equals(claims_services_level)){
							if(!"**".equals(insuranceStatus))
								sql = sql + " order by decode(claim_status,?,1,999) ";
						}
					
									
					pstmt = con.prepareStatement(sql);
										
					pstmt.setString(1,facility_id);
					pstmt.setString(2,billDocTypeCode);
					pstmt.setString(3,billNum);
					if("S".equals(claims_services_level)){
						if(!"**".equals(insuranceStatus))
							pstmt.setString(4,insuranceStatus);
					}
					System.err.println("Sql is: "+sql);
					
					rst = pstmt.executeQuery();		

					while ( rst.next() )
					{
						System.err.println(rst.toString());
						blngServCode = checkForNull(rst.getString("BLNG_SERV_CODE"));
						blngServDesc = checkForNull(rst.getString("blng_serv_desc"));
						servAmt = checkForNull(rst.getString("SERV_AMT"));
						if(amountRoundOff) 
						{
							servAmt = cf1.formatCurrency(servAmt, noofdecimal);
						} else {
							servAmt = BLReportIdMapper.truncateUptoTwoDecimal(servAmt, noofdecimal);	
						}
						apprAmt = checkForNull(rst.getString("APPROVED_AMT"));
						if(amountRoundOff) 
						{
							apprAmt = cf1.formatCurrency(apprAmt, noofdecimal);
						} else {
							apprAmt = BLReportIdMapper.truncateUptoTwoDecimal(apprAmt, noofdecimal);	
						}
						servQty = checkForNull(rst.getString("SERV_QTY"));
						apprQty = checkForNull(rst.getString("APPROVED_QTY"));
						dt_time = checkForNull(rst.getString("SERVICE_DATE"));
						remarks = checkForNull(rst.getString("REMARKS"));
						claimStatus = checkForNull(rst.getString("CLAIM_STATUS"));
						claimStatusDesc = checkForNull(rst.getString("claim_status_desc"));

						serv_tot_rec++;
						if(serv_tot_rec == 1)
						{
%>
<table cellpadding='3' cellspacing=0 width="100%" align="center" border=1>
	<TD class=COLUMNHEADER colSpan=26 align=left style="font-size:20px;"><fmt:message key="eBL.BLDetails.label" bundle="${bl_labels}"/></TD>

		<tr>
			<td class='columnheadercenter' nowrap width="10%"><fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels}"/>/<fmt:message key="Common.description.label" bundle="${common_labels}" /></td>
			<td class='columnheadercenter' nowrap width="10%"><fmt:message key="eBL.ServiceAmount.label" bundle="${bl_labels}"/></td>
			<td class='columnheadercenter' nowrap width="10%"><fmt:message key="eBL.Approval_Amount.label" bundle="${bl_labels}"/></td>
			<td class='columnheadercenter' nowrap width="10%"><fmt:message key="eBL.QTY.label" bundle="${bl_labels}"/></td>
			<td class='columnheadercenter' nowrap width="10%"><fmt:message key="eBL.APPROVED_QTY.label" bundle="${bl_labels}"/></td>
			<td class='columnheadercenter' nowrap width="10%"><fmt:message key="Common.Order.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' nowrap width="30%"><fmt:message key="eBL.Remarks.label" bundle="${bl_labels}" /></td>
			<td class='columnheadercenter' nowrap width="10%"><fmt:message key="eBL.Service_Status.label" bundle="${bl_labels}"/></td>	
		</tr>
<%
						}
%>
		<tr>
			<td	 class='label' id='td_<%=serv_tot_rec%>_0' width="10%">	<%=blngServCode%>/<%=blngServDesc%> &nbsp;</td> 
			<td  class='label'	id='td_<%=serv_tot_rec%>_2' width="10%"> <%=servAmt%> &nbsp;</td> 
			<td  class='label'	id='td_<%=serv_tot_rec%>_3' width="10%"> <%=apprAmt%> &nbsp;</td>
			<td  class='label'	id='td_<%=serv_tot_rec%>_1' width="10%"> <%=servQty%> &nbsp;</td> 
			<td  class='label'	id='td_<%=serv_tot_rec%>_4' width="10%"> <%=apprQty%> &nbsp;</td> 
			<td  class='label'	id='td_<%=serv_tot_rec%>_5' width="10%"> <%=dt_time%> &nbsp;</td>
			<td  class='label'	id='td_<%=serv_tot_rec%>_5' width="30%"> <a href="#" onclick="callRemarkPopup('<%=billDocTypeCode%>', '<%=billNum%>', '<%=appr_doc_ref_num%>','S','<%=blngServCode%>');"><%=(remarks!= null && !remarks.equals(""))?remarks:"..."%></a> &nbsp;</td> 
			<td  class='label'	id='td_<%=serv_tot_rec%>_6' width="10%"> <%=claimStatusDesc%></td> 
		<tr>

<%
					}
			}catch(Exception e){
				System.err.println("Query Result Exception= "+e.toString());
			}							
		
%>	

<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">	
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
	</table>
</form>
</body>
<%
					
		}catch(Exception e){
			out.println("Exception in BLDischClearGenerateResult.jsp: "+e);
			System.err.println("Exception in BLDischClearGenerateResult.jsp: "+e);
		}finally{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(con,request);		
		}
%>
</HTML>

