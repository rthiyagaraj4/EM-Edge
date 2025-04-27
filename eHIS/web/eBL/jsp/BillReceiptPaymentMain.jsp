<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%!
private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String billAmount = checkForNull((String) request.getParameter("billAmount"));
	String calledFrom = checkForNull((String) request.getParameter("calledFrom"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eBL/js/dchk.js'></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script language='javascript' src='../../eBL/js/BillReceiptPayment.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var rowCount = 1;
	$(document).ready(function(){
		if($('#calledFrom').val()=='BillMaintain'){
			alert('BillMaintain')
			$('#resizeBtnPayment').hide();
			var billAmount = $('#billAmount').val();
			$('#overAllOutStanding').val(billAmount);
			$('#hdnOverAllOutStanding').val(billAmount);
			$('#hdnPrevTotal').val(billAmount);
			$('#paymentMainDiv').show();
		}
	})
</script>
<style>
.myButton {
	
	background-color: #83AAB4;
	border-radius:8px;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:arial;
	font-size:10px;
	font-weight:bold;
	padding:5px 12px;
	text-decoration:none;
	text-shadow:0px 1px 0px #3d768a;
	BORDER-STYLE: outset;
	BORDER-LEFT-COLOR: #83AAB4;
	BORDER-RIGHT-COLOR: #83AAB4;
	BORDER-TOP-COLOR: #83AAB4;
	BORDER-BOTTOM-COLOR: #83AAB4 
}
.myButton:hover {
	background-color:#44919E;
	BORDER-STYLE: inset;
}
.myButton:active {
	position:relative;
	top:1px;
}
</style>
</head>
<body>
	<table width="100%" CELLSPACING=0 cellpadding=3 align='center'>
      		<tr>
      			<td class='COLUMNHEADER' nowrap >
      				  <fmt:message key="eBL.Payment.label"	bundle="${bl_labels}"	/>
      				&nbsp;&nbsp;<img id="resizeBtnPayment" alt="" defValue="expand" src="../../eOT/images/ShowMore.gif" style="cursor: pointer;" > 
      			</td>
      		</tr>
     </table>
     <div id='paymentMainDiv' style='display: none;'>
     	<table  width="100%" CELLSPACING=0 cellpadding=3 align='center'>
     		<tr>
     			<td width="16%" class='LABEL'>
     			   	<fmt:message key="eBL.PaymentMode.label"	bundle="${bl_labels}"	/>
     			</td>
				<td  width="16%"  class='fields'>
					<select name='paymentMode' id='paymentMode' id='paymentMode' style="width: 100px;">
						<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='CA'><fmt:message key="eBL.CASH.label"	bundle="${bl_labels}"	/></option>
						<option value='CC'><fmt:message key="eBL.Card.label"	bundle="${bl_labels}"	/></option>
						<option value='DD'><fmt:message key="eBL.DD.label"	bundle="${bl_labels}"	/></option>
						<option value='CQ'><fmt:message key="eBL.CHEQUE.label"	bundle="${bl_labels}"	/></option>
					</select>
				</td>
				<td  width="17%"  class='LABEL'>
					<fmt:message key="eBL.ForeignCurrency.label"	bundle="${bl_labels}"	/>
				</td>
				<td  width="17%" class='fields'>
					<select name='foreignCurency' id='foreignCurency' id='foreignCurency' style="width: 100px;">
						<option value=''>
							--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--
						</option>
					</select>
				</td>
				<td  width="17%"  class='LABEL'>
					<fmt:message key="eBL.OutstandAmount.label"	bundle="${bl_labels}"	/>
				</td>
				<td  width="17%" class='fields'>
					<input type='text' name='overAllOutStanding' id='overAllOutStanding' id='overAllOutStanding' size='15' maxlength="15" value='' readonly>
					<input type='hidden' name='hdnOverAllOutStanding' id='hdnOverAllOutStanding' id='hdnOverAllOutStanding' value=''>					
					<input type='hidden' name='hdnPrevTotal' id='hdnPrevTotal' id='hdnPrevTotal' value=''>
				</td>
     		</tr>
     		<tr>
     			<td colspan='6'>
     				<img src='../../eCommon/images/searchBoxBG.jpg' width='100%' height='10' />
     			</td>
     		</tr>
     	</table>
     </div>

     <div  id='cashTemplate' style="display: none;">
     	<table width='100%'>
     		<tr>
     			<td width="22%" class="label">
     				<fmt:message key="eBL.CASH_GIVEN.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="22%" class="fields">
     				<input type='text' name='cash_given' id='cash_given' id='cash_given' size='14' maxlength='10' value="" style='text-align:right' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this);computeCashreturn();">
     			</td>
     			<td width="22%" class="label">
     				<fmt:message key="eBL.CASH_RETURNED.label" bundle="${bl_labels}"/>
     			</td>	
				<td width="22%" class="fields">
					<input type='text' name='cash_return' id='cash_return' id='cash_return' size='14' maxlength='10' value="" style='text-align:right' readonly > 
				</td>
				<td  width="12%">
					
				</td>
			</tr>
			<tr>
				<td width="22%" class="label" >
					<fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/>
				</td>	
				<td width="22%" class="fields">
					<input type='text' name='payername' id='payername' id='payername' size='20' maxlength='40' value="" onKeyPress='return CheckForSpecChars_local(event)'>
				</td>

				<td width="22%" class="label">
					<fmt:message key="eBL.PAYER_DEP_REF_NO.label" bundle="${bl_labels}"/>
				</td>	
				<td width="22%" class="fields">
					<input type='text' name='recrefidno' id='recrefidno' id='recrefidno' size='20' maxlength='30' value="" onKeyPress='return CheckForSpecChars(event)'> 
				</td>
				<td  width="12%">
					<input type='button' class='button' id='cashAddBtn' name='cashAddBtn' id='cashAddBtn' value='Add' >
				</td>
			</tr>
			<tr>
				<td colspan='5'>
     				<img src='../../eCommon/images/searchBoxBG.jpg' width='100%' height='10' />
     			</td>
     		</tr>
     	</table>
     </div>
     <div  id='cardTemplate' style='display: none;'>
     	<table width='100%'>
     		<tr>
     			<td  width="15%" class="label">
     				<fmt:message key="eBL.CARD_TYPE.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<select name='cardType' id='cardType' id='cardType' style="width: 100px;"> 
						<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value="C"><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option>
						<option value="D"><fmt:message key="eBL.Debit.label" bundle="${bl_labels}"/></option>
					</select>
				</td>
     			<td  width="15%" class="label">
     				<fmt:message key="eBL.CardNumber.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<input type='text' name='cardNo' id='cardNo' id='cardNo' size='20' maxlength='30' value="" onKeyPress='return CheckForSpecChars(event)'> 
				</td>
     			<td  width="15%" class="label">
     				<fmt:message key="eBL.CardHoldersName.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<input type='text' name='cardHolderName' id='cardHolderName' id='cardHolderName' size='20' maxlength='30' value="" onKeyPress='return CheckForSpecChars(event)'> 
				</td>
				<td width='10%'>
				</td>
     		</tr>
     		<tr>
     			<td  width="15%" class="label">
     				<fmt:message key="eBL.IssuingAuthority.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<input type='text' name='issuingAuthority' id='issuingAuthority' id='issuingAuthority' size='20' maxlength='30' value="" onKeyPress='return CheckForSpecChars(event)'> 
				</td>
     			<td  width="15%" class="label">
     				<fmt:message key="eBL.IssuingBranch.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<input type='text' name='issuingBranch' id='issuingBranch' id='issuingBranch' size='20' maxlength='30' value="" onKeyPress='return CheckForSpecChars(event)'> 
				</td>
     			<td  width="15%" class="label">
     				<fmt:message key="eBL.ApprAuthCode.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<input type='text' name='apprAuthCode' id='apprAuthCode' id='apprAuthCode' size='20' maxlength='30' value="" onKeyPress='return CheckForSpecChars(event)'> 
				</td>
				<td width='10%'>
				</td>
     		</tr>
     		<tr>
     			<td  width="15%" class="label">
     				<fmt:message key="eBL.ValidFromMMYY.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<input type='text' name='validityFromMonth' id='validityFromMonth' id='validityFromMonth' size='2' maxlength='2' value="" onKeyPress='return CheckForSpecChars(event)'>
					/ <input type='text' name='validityFromYear' id='validityFromYear' id='validityFromYear' size='2' maxlength='2' value="" onKeyPress='return CheckForSpecChars(event)'>
				</td>
     			<td  width="17%" class="label">
     				<fmt:message key="eBL.ValidToMMYY.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<input type='text' name='validityToMonth' id='validityToMonth' id='validityToMonth' size='2' maxlength='2' value="" onKeyPress='return CheckForSpecChars(event)'>
					/ <input type='text' name='validityToYear' id='validityToYear' id='validityToYear' size='2' maxlength='2' value="" onKeyPress='return CheckForSpecChars(event)'>
 
				</td>
     			<td  width="15%" class="label">
     				<fmt:message key="eBL.CardAmount.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="15%" class="fields">
					<input type='text' name='cardAmount' id='cardAmount' id='cardAmount' size='20' maxlength='30' value="" onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)"> 
				</td>
				<td width='10%'>
					<input type='button' class='button' id='cardAddBtn' name='cardAddBtn' id='cardAddBtn' value='Add' >
				</td>
     		</tr>
     		<tr>
				<td colspan='7'>
     				<img src='../../eCommon/images/searchBoxBG.jpg' width='100%' height='10' />
     			</td>
     		</tr>
     	</table>
     </div>
     <div  id='ddTemplate' style="display: none;">
     	<table width='100%'>
     		<tr>
     			<td width="22%" class="label">
     				<fmt:message key="eBL.DDNo.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="22%" class="fields">
     				<input type='text' name='ddNo' id='ddNo' id='ddNo' size='14' maxlength='10' value="" style='text-align:right' >
     			</td>
     			<td width="22%" class="label">
     				<fmt:message key="eBL.DDAmount.label" bundle="${bl_labels}"/>
     			</td>	
				<td width="22%" class="fields">
					<input type='text' name='ddAmount' id='ddAmount' id='ddAmount' size='14' maxlength='10' value="" style='text-align:right'  onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)"> 
				</td>
				<td  width="12%">
				
				</td>
			</tr>
			<tr>
				<td width="22%" class="label" >
					<fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/>
				</td>	
				<td width="22%" class="fields">
					<input type='text' name='ddPayername' id='ddPayername' id='ddPayername' size='20' maxlength='40' value="" onKeyPress='return CheckForSpecChars_local(event)'>
				</td>

				<td width="22%" class="label">
					<fmt:message key="eBL.DDDate.label" bundle="${bl_labels}"/>
				</td>	
				<td width="22%" class="fields">
					<input type='text' name='ddDate' id='ddDate' id='ddDate' size='10' maxlength='10' value="" onBlur='return checkDt(this)'>
					&nbsp;
					<img src='../../eCommon/images/CommonCalendar.gif'  id='endDate_ctrl' onClick="return showCalendar('ddDate');" /> 
				</td>
				<td  width="12%">
					<input type='button' class='button' id='ddAddBtn' name='ddAddBtn' id='ddAddBtn' value='Add' >
				</td>
			</tr>
			<tr>
				<td colspan='5'>
     				<img src='../../eCommon/images/searchBoxBG.jpg' width='100%' height='10' />
     			</td>
     		</tr>
     	</table>
     	
     </div>
     
     <div  id='chequeTemplate' style="display: none;">
     	<table width='100%'>
     		<tr>
     			<td width="22%" class="label">
     				<fmt:message key="eBL.ChequeNo.label" bundle="${bl_labels}"/>
     			</td>
     			<td width="22%" class="fields">
     				<input type='text' name='chequeNo' id='chequeNo' id='chequeNo' size='14' maxlength='10' value="" style='text-align:right' >
     			</td>
     			<td width="22%" class="label">
     				<fmt:message key="eBL.ChequeAmount.label" bundle="${bl_labels}"/>
     			</td>	
				<td width="22%" class="fields">
					<input type='text' name='chequeAmount' id='chequeAmount' id='chequeAmount' size='14' maxlength='10' value="" style='text-align:right'  onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)"> 
				</td>
				<td  width="12%">
				
				</td>
			</tr>
			<tr>
				<td width="22%" class="label" >
					<fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/>
				</td>	
				<td width="22%" class="fields">
					<input type='text' name='chequePayername' id='chequePayername' id='chequePayername' size='20' maxlength='40' value="" onKeyPress='return CheckForSpecChars_local(event)'>
				</td>

				<td width="22%" class="label">
					<fmt:message key="eBL.ChequeDate.label" bundle="${bl_labels}"/>
				</td>	
				<td width="22%" class="fields">
					<input type='text' name='chequeDate' id='chequeDate' id='chequeDate' size='10' maxlength='10' value="" onBlur='return checkDt(this)'>
					&nbsp;
					<img src='../../eCommon/images/CommonCalendar.gif'  id='endDate_ctrl' onClick="return showCalendar('ddDate');" /> 
				</td>
				<td  width="12%">
					<input type='button' class='button' id='chequeAddBtn' name='chequeAddBtn' id='chequeAddBtn' value='Add' >
				</td>
			</tr>
			<tr>
				<td colspan='5'>
     				<img src='../../eCommon/images/searchBoxBG.jpg' width='100%' height='10' />
     			</td>
     		</tr>
     	</table>
     	
     </div>
     <input type='hidden' id='checkedData' name='checkedData' id='checkedData' value=''>
     <div id='paymentSummary' style='display: none;'>
     	<table border='1' cellpadding='3' cellspacing='0' align = 'center' id='paymentSummaryTable' width='100%' border='1' style="empty-cells: show;">	
				<tr>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.AMT_COLL.label" bundle="${bl_labels}"/></td>
					<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width="5%" style='display:none;'><fmt:message key="eBL.CASH_GIVEN.label" bundle="${bl_labels}"/></td>	
					<td class='COLUMNHEADER' width="5%" style='display:none;'><fmt:message key="eBL.OutstandingAmount.label" bundle="${bl_labels}"/></td>
					<td class='COLUMNHEADER' width="5%" style='display:none;'><fmt:message key="eBL.CASH_RETURNED.label" bundle="${bl_labels}"/></td>	
					<td class='COLUMNHEADER' width='6%' ><fmt:message key="eBL.CHQ_CARD_BANK_NO.label" bundle="${bl_labels}"/></td>
					<td class='COLUMNHEADER' width='6%' style='display:none;'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='10%' style='display:none;'>Card Type</td>
					<td class='COLUMNHEADER' width='10%' style='display:none;'><fmt:message key="eBL.CREDIT_CARD_CO.label" bundle="${bl_labels}"/></td>	
					<td class='COLUMNHEADER' width='10%' style='display:none;'>Card Validity</td>
					<td class='COLUMNHEADER' width='10%' style='display:none;'>Issuing Authority</td>
					<td class='COLUMNHEADER' width='6%' style='display:none;'>Issuing Branch</td>					
					<td class='COLUMNHEADER' width='6%' style='display:none;'>Appr / Auth Code</td>					
					<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.PAYER_NAME.label" bundle="${bl_labels}"/></td>
					<td class='COLUMNHEADER' width='6%'>Remove</td>
				</tr>
		</table>
		<br/>
		<span style="padding-left: 50px;">
			<input type='button' class='button' id='backFromPreview' name='backFromPreview' id='backFromPreview' value='Back'>
		</span>
		
     </div>
     <div id='paymentButton' style='display: none;'>
     	<table width='100%'>
     		<tr>
     			<td width=52%'>
     				
     			</td>
     			<td  width=12%'>
     				<input type='button' class='button' id='reCalculateBtn' name='reCalculateBtn' id='reCalculateBtn' value='Re Calculate'>
     			</td>
     			<td  width=12%'>
     				<input type='button' class='button' id='previewBtn' name='previewBtn' id='previewBtn' value='Preview'>
     			</td>
     			<td  width=12%'>
     				<input type='button' class='button' id='saveBtn' name='saveBtn' id='saveBtn' value='Save'>
     			</td>
     			<td  width=12%'>
     				<input type='button' class='button' id='clearBtn' name='clearBtn' id='clearBtn' value='Clear'>
     			</td>
     		</tr>
     	</table>
     </div>
     <input type='hidden' name='billAmount' id='billAmount' id='billAmount' value='<%=billAmount%>'>
     <input type='hidden' name='calledFrom' id='calledFrom' id='calledFrom' value='<%=calledFrom%>'>
</body>
</html>

