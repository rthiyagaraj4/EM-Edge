<!DOCTYPE html>
<%@  page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="com.google.gson.JsonObject"%>

<%	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id = (String)httpSession.getValue("facility_id");
	String login_user =  p.getProperty("login_user");
	String called_frm = request.getParameter("called_frm");
	if(called_frm == null) called_frm="";
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	Boolean SiteSpec=true;
	String site_id="";
	String outst="";
	String billcount_KDAH=" ";
	String billcount_MC=" ";
	String strCashCounterCode = " ";
	String strLogoutTime  = " ";
	String strLoginTime=" ";

	con=ConnectionManager.getConnection(request);

	//sarathkumar added code to make as siteSpecific GDOH-CRF-0117...
	String ssv=session.getAttribute("ssv").toString();
	Boolean ss=Boolean.parseBoolean(ssv);	
	
	//System.out.println("strLoginTime"+request.getParameter("login_time"));
%>
<html>
<head>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script>
function funSubmit()
{
	//alert("close");
	var locale=document.forms[0].locale.value;		
	var dat1=getCurrentDate('DMYHMS',locale);
	parent.top_frame.document.forms[0].logout_time.value=dat1;
	var cashcounter = parent.top_frame.document.forms[0].cashcounter.value;
	
	var login_time=$(parent.top_frame.document).find('#login_time').val();
	var logout_time=$(parent.top_frame.document).find('#logout_time').val();
	var cashcounter1=$(parent.top_frame.document).find('#cashcounter').val();
	var facility_id=$('#facility_id').val();
	var site_id = '';
	var outst = '';
	var billcount_KDAH = '';
	var billcount_MC = '';
	
//alert("close1");
	$.ajax({
		type : 'POST',
		url : "../jsp/BLLogoutSettlementAjax.jsp?cashcounter1="+cashcounter1+"&login_time="+login_time+"&logout_time="+logout_time+"&facility_id="+facility_id,
		async	: false,
		dataType: "json",
		success : function(data) {
		//	alert("inside the ajas call");
		  site_id = data.site_id;
		  //alert("site_id: "+site_id);
		 outst =  data.outst;	
		//	alert("outst: "+outst);		 
		 billcount_KDAH = data.billcount_KDAH;
		// alert("billcount_KDAH: "+billcount_KDAH);
		 billcount_MC = data.billcount_MC;
		// alert("billcount_MC: "+billcount_MC);
		}
	}); 
	
	//alert("close2");
	//alert("3");
	 if( site_id =='KDAH'){
		 
		 alert("close3");
		if( outst =='Y'){
			if(billcount_KDAH != '0'){
				alert(getMessage("BL9099","BL"));
				return;
			}
		}
	}
	if(site_id == 'MC'){
		//alert("4");
		if(outst == 'Y'){
			if(billcount_MC != '0'){	
				alert(getMessage("BL9099","BL"));
				return;
			}
		} 
	}
	
	if ( (cashcounter == '') || (cashcounter == null) ||(cashcounter == ' ') )	
	{	
//alert("5");
		alert(getMessage('BL9538','BL'));
		return(false);
	}
	//document.forms[0].close_button.disabled = true;
	if (parent.detail_frame.funValidate()== true)
	{	
//alert("6");
		parent.detail_frame.document.forms[0].submit();	
		//setTimeout('call_frames()',1000);
//		parent.parent.frames[1].location.href ='../../eBL/jsp/BLLogoutCashCounterMain.jsp';	
//		parent.frames.top_frame.location.href='../../eBL/jsp/BLLogoutCashCounter.jsp';
		//Added for MMS-ME-SCF-0014 
		document.getElementById("close_button").disabled=true;
		//Added for MMS-ME-SCF-0014 
	}
}
function call_frames()
{
	parent.parent.frames[1].location.href ='../../eBL/jsp/BLLogoutCashCounterMain.jsp';	
//	parent.top_frame.location.href='../../eBL/jsp/BLLogoutCashCounter.jsp';
}
/*function totDesAmt()
{
	var tot_des_amt = parent.detail_frame.document.forms[0].tot_dis.value;
	if(tot_des_amt != 0)
	{
	 alert(getMessage('BL1288','BL'));
	 
	return ;
	}
	}*/


function funClose()
{
	
	var called_frm = document.forms[0].called_frm.value;
	//parent.window.close();
	parent.parent.frames[1].location.href ='../../eCommon/html/blank.html' ;
	if(called_frm == "DISC_FUN")
	{
		window.close();
	}
	
}
async function funQry()
{
	
	var retVal = 	new String();
	var cashcounter = parent.top_frame.document.forms[0].cashcounter.value;
	var login_time =  parent.top_frame.document.forms[0].login_time.value;
	
	var dialogTop			= "195";
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			="dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			="";
	var facility_id = document.forms[0].facility_id.value;
//	var title="Cashier Settlements";

	var title=getLabel("eBL.CASHIER_SETTLEMENTS.label","BL");

	var column_sizes = escape("15%,10%,5%,10%,10%,10%,5%,5%,5%,5%");               
	
//	var column_descriptions = escape("Receipt Time,Cash Counter,Shift,Doc. Type ,Doc. No,Doc. Amount,Type ,Nature,Slmt,Status");
	var receipttimelb=getLabel("eBL.RECEIPT_TIME.label","BL");
	var cashcounterlb=getLabel("eBL.CASH_COUNTER.label","BL");
	var shiftlb=getLabel("Common.SHIFT.label","common");
	var doctypelb=getLabel("Common.documenttype.label","common");
	var docnolb=getLabel("Common.DocumentNumber.label","common");
	var docamtlb=getLabel("eBL.DOC_AMT.label","BL");
	var typelb=getLabel("Common.type.label","common");
	var naturelb=getLabel("Common.Nature.label","common");
	var slmtlb=getLabel("eBL.SLMT.label","BL");
	var statuslb=getLabel("Common.cancelled.label","common");
	
	
	var column_descriptions =receipttimelb+","+cashcounterlb+","+shiftlb+","+doctypelb +","+docnolb+","+docamtlb+","+typelb+","+naturelb+","+slmtlb+","+statuslb;
	
	var sql = escape(" select to_char(TRX_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') TRX_DATE_TIME,CASH_COUNTER_CODE,SHIFT_ID,DOC_TYPE_CODE,DOC_NUMBER||'/'||DOC_SRNO,DOC_AMT DOC_AMT_$$ , "+
	" nvl(RECPT_TYPE_CODE,' ') RECPT_TYPE_CODE,nvl(RECPT_NATURE_CODE,' ') RECPT_NATURE_CODE,SLMT_TYPE_CODE SLMT_TYPE_CODE,nvl(CANCELLED_IND,' ') CANCELLED_IND  from bl_receipt_refund_hdrdtl_vw "+
	" where operating_facility_id = '"+facility_id+"' AND "+
	" DOC_DATE BETWEEN to_date('"+login_time+"','dd/mm/yyyy hh24:mi:ss')	 "+
	" AND  sysdate	 "+
	" AND  CASH_COUNTER_CODE = '"+cashcounter+"' "+ 
	" ORDER BY TRX_DATE_TIME ");
	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;

	retVal=await window.showModalDialog("../../eBL/jsp/BLGeneralQuery.jsp?"+param,arguments,features);
}
</script>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String cash_bill_cnt = request.getParameter("cash_bill_cnt");
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	
	
	
	<body>
		<form name='menu_form' id='menu_form' action='../../servlet/eBL.BLLogInCashCounterServlet' method='post' target='messageFrame'>			
		<form name='menu_form' id='menu_form' action='' method='post' target='messageFrame'>	
		<!-- sarathkumar added code to make as siteSpecific GDOH-CRF-0117 -->
		<table border="0" width="100%" cellspacing='0' cellpadding='3' <% if(ss){%><div style="display: none;"> <%}%> >       
		<td class='COLUMNHEADER'><fmt:message key="eBL.SLMT_CLOSING_DTL.label" bundle="${bl_labels}"/></td>
		</table>
		<!-- sarathkumar added code to make as siteSpecific GDOH-CRF-0117 -->
		<table border="0" width="100%" cellspacing='0' cellpadding='3' <% if(ss){%><div style="display: none;"> <%}%> >
		<tr >
			<td width="25%" class='label' ><b> <fmt:message key="eBL.SELF_PAY_BILL_AMT.label" bundle="${bl_labels}"/> </b></td>
			<td width="25%" class='fields' ><input type='text'  readonly style='text-align:right; font-weight:bold'  name='tot_cash_bills_amt' id='tot_cash_bills_amt' size='15' maxlength='20' value='' >
			&nbsp;&nbsp;<b  class='fields' id='cash_bill_cnt1' ></b>
			<fmt:message key="eBL.NOS.label" bundle="${bl_labels}"/>
			</td>
			
			<td width="25%" class='label' ><b> <fmt:message key="eBL.CUSTOMER_PAYABLE_AMT.label" bundle="${bl_labels}"/></b></td>
			<td width="25%" class='fields' ><input type='text'  readonly style='text-align:right; font-weight:bold' name='tot_credit_bills_amt' id='tot_credit_bills_amt' size='15' maxlength='20' value=''>
			&nbsp;&nbsp;<b  class='fields' id='credit_bill_cnt1'></b>
			<fmt:message key="eBL.NOS.label" bundle="${bl_labels}"/>
			
			</td>
		</tr>
		<tr>
			<td width="25%" class='label' nowrap><b> <fmt:message key="eBL.CASH_OPENING_BALANCE.label" bundle="${bl_labels}"/></b></td>
			<td width="25%" class='fields' ><input type='text'  readonly style='text-align:right; font-weight:bold' name='tot_opening_bal' id='tot_opening_bal' size='15' maxlength='20' value=''></td>
			<td width="25%" class='label' ><b> <fmt:message key="eBL.CASH_CLOSING_BALANCE.label" bundle="${bl_labels}"/></b></td>
			<td width="25%" class='fields' ><input type='text'  readonly style='text-align:right; font-weight:bold' name='tot_closing_bal' id='tot_closing_bal' size='15' maxlength='20' value=''></td>
		</tr>
<!--
			<tr>
				<td align='left' class='label' colspan='4'>&nbsp;</td>
			</tr>
-->
		
		
		<tr>
			<td width="25%" class='label'></td>
			<td width="25%" align='left'><input type='button' class='button'   	 	value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_CASHIER_JOURNAL.label","bl_labels")%>" onClick='funQry()'></td>
			<td width="25%" align='left'><input type='button' class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='funClose()'></td>
			<td width="25%" align='left'><input type='button' class='button' name='close_button' id='close_button' id='close_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CLOSE_CASH_COUNTER.label","bl_labels")%>" onClick='funSubmit()'  ></td>
			
			

		</tr>
<!--
		<tr>
				<td align='left' class='label' colspan='4'>&nbsp;</td>
			</tr>
			<tr>
				<td align='left' class='label' colspan='4'>&nbsp;</td>
			</tr>
			<tr>
				<td align='left' class='label' colspan='4'></td>
</tr>-->	
		</table>
		<!-- sarathkumar added code to make as siteSpecific GDOH-CRF-0117 -->
		<table  border="0" width="100%" cellspacing='0' cellpadding='3' <% if(!ss){%><div style="display: none;"> <%}%> 
		<tr>
			<td  width="25%" class='label'></td>
			<td  width="25%" class='label'></td>
			<td width="25%" align='left'><input type='button' class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='funClose()'></td>
			<td width="25%" align='left'><input type='button' class='button' name='close_button' id='close_button'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CLOSE_CASH_COUNTER.label","bl_labels")%>" onClick='funSubmit()'  ></td>
		</tr>
		</table>
		<input type='hidden' name='cashcounter_array' id='cashcounter_array' value=''>
		<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='cash_bill_cnt' id='cash_bill_cnt' value='<%=cash_bill_cnt%>'>
		<input type='hidden' name="locale" id="locale"  value='<%=locale%>'>	
		<input type='hidden' name='called_frm' id='called_frm' value='<%=called_frm%>'>			

	</form>
</body>

</html>

