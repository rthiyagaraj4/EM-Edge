<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	//System.out.println("....... BL....ChequeDtls.jsp.......");
	String facility_id = "";
	String loginUser = "";
	//String strCashCounterCode = "";
	//String strCashCounterArray = "";
//	String strLogoutTime  = "",strsysdate="";
	String strLoginTime="",strReqsysdate="";
	Connection con = null;
	String locale	= (String)session.getAttribute("LOCALE");
	CurrencyFormat cf = new CurrencyFormat();
	String cq_amount="",cheque_number="",cheque_date="",bank_detail="",cust_code,patient_id="";
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");		
		loginUser =  p.getProperty("login_user");		
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//int totalRecordsChq=8;
		String cashCounterCode = request.getParameter("cashCounterCode") == null ? "" :request.getParameter("cashCounterCode") ;
		strLoginTime = request.getParameter("strLoginTime") == null ? "" :request.getParameter("strLoginTime") ;
		strReqsysdate = request.getParameter("strsysdate") == null ? "" :request.getParameter("strsysdate") ;
		String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
		//System.out.println("mode cheq dtls:"+mode);
		String chkd_value="",select_value="",str_tot_check_amt_modify="";
		double tot_check_amt_modify=0.00;int noofdecimal=2;
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);		
			}		
			rs.close();
			pstmt.close();
		}catch(Exception e)
		{
			System.out.println("noofdecimal="+e.toString());
		}
%>
<html>
<head>
	<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		</style>
<script>  
</script>	
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src='../../eBL/js/BLCashChequeHandover.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src='../../eBL/js/BLCashChequeHandover.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 <body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" >
 <form name='chqCollectionForm' id='chqCollectionForm' action='' target='' method=''>			
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' id="">				
			<tr>
			<td width="25%"  class='labels'>
			<td width="25%"  class='labels'>
			<td width="25%"  class='labels'>
			<td width="25%"  class='labels'>
			<td width="25%"  class='labels'>
<%
	if(mode.equals("modify")){
%>			<td width="25%"  class='labels'>
			<td width="25%"  class='labels'><INPUT type="button" class='button' value="CANCEL" onclick="cancelRecord('delete');" /></td>				
<%   } else{%><td width="25%"  class='labels'>&nbsp;</td><%}%>
			</tr>	
	</table>
		<div id="tbl-container" STYLE="overflow: auto; width: 660px; height: 300px;   padding:3px; margin: 0px">
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' id="chqDtl_tabId">
		<thead>
			<!--<td class="COLUMNHEADER" colspan="15"><fmt:message key="eBL.CHEQ_DTLS.label" bundle="${bl_labels}"/></td>-->	
			<tr>
				<td class='columnheader' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				<td class='columnheader' ><fmt:message key="eBL.CHEQ_NUM.label" bundle="${bl_labels}"/></td> 
				<td class='columnheader' ><fmt:message key="eBL.CHEQ_DATE.label" bundle="${bl_labels}"/></td> 
				<td class='columnheader' ><fmt:message key="eBL.BANK_NAME.label" bundle="${bl_labels}"/></td> 
				<td class='columnheader' ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td> 
				<td class='columnheader' ><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td> 
				<td class='columnheader' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td> 
			</tr>	
		</thead>
<%		int i=0;
		try{
			if(!(locale.equals("en"))){
						strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS",locale,"en");
						strReqsysdate = com.ehis.util.DateUtils.convertDate(strReqsysdate,"DMYHMS",locale,"en");
					}
			String sql1="";			
			if(mode.equals("modify"))
			{
				chkd_value="CHECKED";
				select_value="Y";
				 sql1="SELECT CQ_AMOUNT,CHEQUE_NUMBER,TO_CHAR(CHEQUE_DATE,'dd/mm/yyyy'),BANK_DETAIL,CUST_CODE,PATIENT_ID FROM bl_handed_cheque_amt WHERE requested_date_time = TO_DATE('"+strReqsysdate+"','dd/mm/yyyy HH24:MI:SS') AND loggedin_user_id = '"+loginUser+"'";
			}else{
				chkd_value="";
				select_value="";
				sql1="SELECT x.receipt_amt cq_amount,   x.slmt_doc_ref_desc cheque_number,TO_CHAR(x.slmt_doc_ref_date,'dd/mm/yyyy') cheque_date,x.bank_code bank_detail, x.payer_name cust_code, x.patient_id patient_id,NULL requested_date_time,NULL login_date_time,NULL loggedin_user_id, NULL added_by_id,      NULL modified_by_id,       NULL added_date,       NULL modified_date,       NULL added_at_ws_no,       NULL modified_at_ws_no,       NULL added_facility_id,       NULL operating_facility_id,       NULL modified_facility_id,       doc_date,       cancelled_date,       cash_counter_facility_id,       cash_counter_code,       z.acc_entity_id acc_entity_id,    doc_type_code,       doc_number  FROM (SELECT nvl(a.doc_amt, 0) receipt_amt,               0 cancel_amt,               a.slmt_type_code slmt_type_code,               1 tot_cnt,               0 can_cnt,0 bou_cnt,               a.slmt_doc_ref_desc slmt_doc_ref_desc,               a.slmt_doc_ref_date slmt_doc_ref_date,               a.bank_code bank_code,               a.payer_name,               b.patient_id,               a.doc_date,               NULL cancelled_date,               cash_counter_facility_id,               cash_counter_code,               a.doc_type_code doc_type_code,               a.doc_number doc_number          FROM bl_receipt_refund_dtl a, bl_receipt_refund_hdr b         WHERE a.doc_type_code = b.doc_type_code           AND a.doc_number = b.doc_number           AND b.recpt_refund_ind IS NOT NULL           AND a.cash_ctrl_doc_type_code IS NULL        UNION ALL        SELECT nvl(-a.doc_amt, 0) receipt_amt,               nvl(a.doc_amt, 0) cancel_amt,      a.slmt_type_code slmt_type_code,               1 tot_cnt,               decode(b.cancelled_ind, 'Y', 1, 0) can_cnt,              decode(b.bounced_yn, 'Y', 1, 0) bou_cnt,               a.slmt_doc_ref_desc slmt_doc_ref_desc,               a.slmt_doc_ref_date slmt_doc_ref_date,               a.bank_code bank_code,               a.payer_name,               a.patient_id  patient_id,               NULL doc_date,               b.cancelled_date,               cash_counter_facility_id,               cash_counter_code,          a.doc_type_code doc_type_code,               a.doc_number doc_number          FROM bl_receipt_refund_dtl a, bl_cancelled_bounced_trx b         WHERE b.recpt_refund_ind IS NOT NULL           AND a.doc_type_code = b.doc_type_code          AND a.doc_number = b.doc_number           AND a.doc_srno = b.doc_srno           AND b.cash_ctrl_doc_type_code IS NULL) x,       bl_slmt_type y,       sy_acc_entity z WHERE x.slmt_type_code = y.slmt_type_code   AND y.acc_entity_code = z.acc_entity_code   AND (y.cash_slmt_flag = 'B' OR       (y.cash_slmt_flag = 'Y' AND nvl(y.cashier_cheque_yn, 'N') = 'Y'))   AND (doc_number, doc_type_code, x.slmt_doc_ref_desc) NOT IN       (SELECT doc_number, doc_type_code, cheque_number          FROM bl_handed_cheque_amt         WHERE (cash_counter_code, requested_date_time) NOT IN               (SELECT cash_counter_code, requested_date_time                  FROM bl_handed_reqt                 WHERE status IN ('X', 'C', 'R')))   AND acc_entity_id = '"+facility_id+"'   AND cash_counter_facility_id = '"+facility_id+"'  AND cash_counter_code = '"+cashCounterCode+"' AND nvl(doc_date, to_date('"+strLoginTime+"', 'dd/mm/yyyy HH24:MI:SS')) BETWEEN      nvl(to_date('"+strLoginTime+"', 'dd/mm/yyyy HH24:MI:SS'), trunc(SYSDATE)) AND       nvl(to_date('"+strReqsysdate+"', 'dd/mm/yyyy HH24:MI:SS'), trunc(SYSDATE))   AND nvl(cancelled_date,to_date('"+strLoginTime+"', 'dd/mm/yyyy HH24:MI:SS')) BETWEEN       nvl( to_date('"+strLoginTime+"', 'dd/mm/yyyy HH24:MI:SS'), trunc(SYSDATE)) AND      nvl(to_date('"+strReqsysdate+"', 'dd/mm/yyyy HH24:MI:SS'), trunc(SYSDATE))";
			}
			 // System.out.println("sql1 c chq det"+sql1);
				pstmt = con.prepareStatement(sql1);	
				rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						cq_amount = rs.getString(1);						
						cheque_number = rs.getString(2);	
						cheque_date = rs.getString(3);	
						bank_detail = rs.getString(4);	
						cust_code = rs.getString(5);	
						patient_id = rs.getString(6);	
						
						if(cust_code==null) cust_code="";
						if(bank_detail==null) bank_detail="";
						if(patient_id==null) patient_id="";
						if(cq_amount==null) cq_amount="0.00";
						cq_amount = cf.formatCurrency(cq_amount, noofdecimal);
						// System.out.println("chkd_value c chq det"+chkd_value);
						 if(mode.equals("modify"))
							{
								tot_check_amt_modify = tot_check_amt_modify + Double.parseDouble(cq_amount);
								str_tot_check_amt_modify = cf.formatCurrency(String.valueOf(tot_check_amt_modify),noofdecimal);
							}
					if(!(locale.equals("en"))){
						cheque_date = com.ehis.util.DateUtils.convertDate(cheque_date,"DMY","en",locale);
					}						
%>		<tbody>			
			<tr>
				<td align="left" nowrap><input type='checkbox'  name='chkSelect_<%=i%>' id='chkSelect_<%=i%>' onClick='selectChk(<%=i%>);' value="<%=select_value%>" <%=chkd_value%>/></td>				
				<td align="left" nowrap><input type='text' name='chqNum_<%=i%>' id='chqNum_<%=i%>' size='10'  onBlur='' onkeypress='' value="<%=cheque_number%>" readOnly/></td>			
				<td align="left" nowrap><input type='text' name='chqDate_<%=i%>' id='chqDate_<%=i%>' size='20'  onBlur='' onkeypress='' value="<%=cheque_date%>" readOnly /></td>
				<td align="left" nowrap><input type='text' name='bank_<%=i%>' id='bank_<%=i%>' size='12'  onBlur='' onkeypress='' value="<%=bank_detail%>"  readOnly/></td>
				<td align="left" nowrap><input type='text' name='payer_<%=i%>' id='payer_<%=i%>' size='12'  onBlur='' onkeypress='' value="<%=cust_code%>" readOnly /></td>
				<td align="left" nowrap><input type='text' name='patientId_<%=i%>' id='patientId_<%=i%>' size='10'  onBlur='' onkeypress='' value="<%=patient_id%>" readOnly /></td>					
				<td align="left" nowrap><input type='text' name='chqAmount_<%=i%>' id='chqAmount_<%=i%>' size='10'  style='text-align:right' onBlur='' onkeypress='' value="<%=cq_amount%>" readOnly/></td>				
			</tr>
<%			i++;
				}
				//System.out.println("i cheq records :" +i);
			rs.close();
			pstmt.close();
   }catch(Exception e)
	{
			out.println("Handover chq qry collection "+e);
	}
	//System.out.println("tot_rec i:" +i);
%>
	</tbody>
	 </table>
</div>
	<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			<tr>
			<td width="25%"  class='labels'>	</td>
			<td width="25%"  class='labels'>	</td>
			<td width="25%"  class='labels'>	</td>
			<td width="25%"  class='labels'>	</td>		
<%
	if(mode.equals("modify"))
		{
%>  		<td width="25%"  class='labels'>
			<INPUT type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('chqDtl_tabId','CHQ_DTL','<%=mode%>')" /> </td>
<%      }%>			
			<td width="25%"  class='labels'><fmt:message key="Common.total.label" bundle="${bl_labels}"/></td>			
			<td width="25%" class="fields"><input type='text' name='cheque_total' id='cheque_total' size='15' style='text-align:right' onBlur='putdeci_temp(this,"<%=noofdecimal%>")'  value="<%=str_tot_check_amt_modify%>" readonly/></td>
			</tr>
	</table>
				
	<input type='hidden' name="totalRecordsChq" id="totalRecordsChq" value="<%=i%>">
	<input type='hidden' name="mode" id="mode" value="<%=mode%>">
	<input type='hidden' name="noofdecimal" id="noofdecimal" value="<%=noofdecimal%>">
	<input type='hidden' name="cashCounterCode" id="cashCounterCode" value="<%=cashCounterCode%>">	
	<input type='hidden' name="logigDateTime" id="logigDateTime" value='<%=strLoginTime%>'>
	<input type='hidden' name="reqDateTime" id="reqDateTime" value='<%=strReqsysdate%>'>
	<input type='hidden' name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type='hidden' name="locale" id="locale" value="<%=locale%>">
</form>
</body>
<%
}catch(Exception eX)
	{
			out.println("Handover Cash collection "+eX);
	}
	finally
		{
		ConnectionManager.returnConnection(con, request);
		}
%>
</html>

