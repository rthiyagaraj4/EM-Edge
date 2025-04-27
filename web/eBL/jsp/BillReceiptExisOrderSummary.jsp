<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	$(document).ready(function(){
		$('#exclRefresh').click(function(){
			var detDoc = parent.BillReceiptExisOrderDetails.document;
			var queryString = $(detDoc).find("#queryString").val();
			detDoc.location.href = '../jsp/BillReceiptExistOrderGroup.jsp?'+queryString;
			
		});
		
		$('#colorStatus').click(async function(){
			var dialogHeight= "12" ;
			var dialogWidth	= "13" ;													   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
			var pDoc = parent.BillReceiptExisOrderSearch.document;
			var params = "../jsp/BillReceiptColourIndicator.jsp";
			var popupWindow =await window.showModalDialog(params,null,features);  
		});
		
		$('#summaryDiv').show();
		var pDoc = parent.BillReceiptExisOrderDetails.document;
		var infoDoc = parent.BillReceiptInfo.document;
		var noOfDecimal = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
		$('#approxPayerAmt').text($(pDoc).find('#approx_pyr_amt').val());
		$('#approxPatAmt').text($(pDoc).find('#approx_pat_amt').val());
		$('#patAmt').text($(pDoc).find('#patient_amt').val());
		$('#exemptReq').val($(pDoc).find('#exemption_amt').val());
		$('#deposits').text($(pDoc).find('#deposit_amt').val());
		$('#totNetAmt').text($(pDoc).find('#net_amt').val());
		$('#splDepAdj').text($(pDoc).find('#spl_dep_adj_amt').val());
		$('#slmtAmt').val($(pDoc).find('#slmt_amt').val());
		$('#totSplDep').text($(pDoc).find('#spl_dep_amt').val());
		$('#availSplDep').text($(pDoc).find('#available_spl_dep_amt').val());
		$('#adjSplDep').text($(pDoc).find('#adjustable_spl_dep_amt').val());
		$('#balSplDep').text($(pDoc).find('#balance_spl_dep_amt').val());
		$('#docAmt').val($(pDoc).find('#slmt_amt').val());
		$('#docAmt1').val($(pDoc).find('#slmt_amt').val());
		$('#patDepAdj').val($(pDoc).find('#patDepAdj').val());
		$('#patDepBal').val($(pDoc).find('#patDepBal').val());
		$('#patPrepayAdj').val($(pDoc).find('#patPrepayAdj').val());
		$('#patPrepayBal').val($(pDoc).find('#patPrepayBal').val());
		$('#depAdjustedYn').val($(pDoc).find('#depAdjustedYn').val());
		$('#preAdjustedYn').val($(pDoc).find('#preAdjustedYn').val());	
		
		$('#prevDepAdjAmt').val($(pDoc).find('#prevDepAdjAmt').val());
		$('#prevPreAdjAmt').val($(pDoc).find('#prevPreAdjAmt').val());	

		$(parent.BillReceiptInfo.document).find('#depAdjustedYn').val($('#depAdjustedYn').val());
		$(parent.BillReceiptInfo.document).find('#preAdjustedYn').val($('#preAdjustedYn').val());	

	
		$(parent.BillReceiptInfo.document).find('#patDepAdj').text($('#patDepAdj').val());
		$(parent.BillReceiptInfo.document).find('#patDepBal').text($('#patDepBal').val());
		$(parent.BillReceiptInfo.document).find('#patPrepayAdj').text($('#patPrepayAdj').val());
		$(parent.BillReceiptInfo.document).find('#patPrepayBal').text($('#patPrepayBal').val());
		var total = $(pDoc).find('#totalGroup').val();
		if(parseInt(total)<1){
			$(infoDoc).find('#patDepBal').text($.trim($(infoDoc).find('#availPatDep').text()));
			$(infoDoc).find('#patPrepayBal').text($.trim($(infoDoc).find('#availPatPrepay').text()));
			
			$(infoDoc).find('#depAdjChk').prop('checked',false);
			$(infoDoc).find('#prePayChk').prop('checked',false);
		}
			
			if($(parent.BillReceiptInfo.document).find('#patDepAdj').text() != ''){
				
				putDecimal_Text($(parent.BillReceiptInfo.document).find('#patDepAdj'),17,noOfDecimal);	
				}
			else{
				$(parent.BillReceiptInfo.document).find('#patDepAdj').text('0');
				putDecimal_Text($(parent.BillReceiptInfo.document).find('#patDepAdj'),17,noOfDecimal);
			}
			
			if($(parent.BillReceiptInfo.document).find('#patDepBal').text() != ''){
				putDecimal_Text($(parent.BillReceiptInfo.document).find('#patDepBal'),17,noOfDecimal);				
			}
			else{
				$(parent.BillReceiptInfo.document).find('#patDepBal').text('0');
				putDecimal_Text($(parent.BillReceiptInfo.document).find('#patDepBal'),17,noOfDecimal);
			}
			if($(parent.BillReceiptInfo.document).find('#patPrepayAdj').text() != ''){
				putDecimal_Text($(parent.BillReceiptInfo.document).find('#patPrepayAdj'),17,noOfDecimal);				
			}
			else{
				$(parent.BillReceiptInfo.document).find('#patPrepayAdj').text('0');
				putDecimal_Text($(parent.BillReceiptInfo.document).find('#patPrepayAdj'),17,noOfDecimal);
			}
			if($(parent.BillReceiptInfo.document).find('#patPrepayBal').text() != ''){
				putDecimal_Text($(parent.BillReceiptInfo.document).find('#patPrepayBal'),17,noOfDecimal);				
			}
			else{
			
				$(parent.BillReceiptInfo.document).find('#patPrepayBal').text('0');
				putDecimal_Text($(parent.BillReceiptInfo.document).find('#patPrepayBal'),17,noOfDecimal);
			}
		
		
		if($(pDoc).find('#splDepYN').val() != 'Y'){
			$('#splDepTr').hide();
		}
		
		var noOfDecimals = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
		$('input:text').each(function(){
			if($(this).val() != ''){
				putDecimal_field($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal_field($(this).get(0),17,noOfDecimals);
			}				

		});

		$('span').each(function(){
			if($(this).attr('roundToVal') == 'Y'){
				
				if($.trim($(this).text()) != ''){
					putDecimal_Text($(this),17,noOfDecimals);			
				}
				else{
					$(this).text('0');
					putDecimal_Text($(this),17,noOfDecimals);
				}
			}
		});
		
		if($('#docAmt').val() != ''){
			putDecimal_field($('#docAmt').get(0),17,noOfDecimal);				
		}
		else{
		
			$('#docAmt').val('0');
			putDecimal_field($('#docAmt').get(0),17,noOfDecimal);
		}
		
	});
</script>
</head>
<body>
	<div id='summaryDiv' style="display: none;">
		<table style="width: 100%;">
			<tr>
				<td class="grid" border="1px;">
				<table style="width: 100%;" align="center" >
			<tr>
				<td class='LABEL' width='12%'>
					Approx Payer Amt
				</td>
				<td  width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='approxPayerAmt' id='approxPayerAmt'></span>		
				</td>
				<td class='LABEL' width='12%'>
					Patient Amt
				</td>
				<td   width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='patAmt' id='patAmt'></span>	
				</td>
				<td class='LABEL' width='12%'>
					Total Net Amt
				</td>
				<td   width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='totNetAmt' id='totNetAmt'></span>		
				</td>
				<td class='LABEL' width='12%'>
					Total Special Dep
				</td>
				<td   width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='totSplDep' id='totSplDep'></span>		
				</td>
				<td id='remarksByCashier' class='label' width='15%'>
					<span style="color: blue; cursor: pointer;" onclick="javascript:captureRemarks()">Remarks</span>
					<input type='hidden' name='remarksDtl' id='remarksDtl'  value="">
				</td>
			</tr>
			<tr>
				<td class='LABEL' width='12%'>
					Approx Patient Amt
				</td>
				<td  width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='approxPatAmt' id='approxPatAmt'></span>	
				</td>
				<td class='LABEL' width='12%'>
					Exempt Req
				</td>
				<td   width='8%' class='fields' align="right">
					<input type='text' size='17' style="text-align: right;" name='exemptReq'  id='exemptReq' value='' onblur="if(this.value>0){exemptReqValidate(this);}" onchange=""></td>		
				</td>
				
				<td class='LABEL' width='12%'>
					Deposits
				</td>
				<td   width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='deposits' id='deposits'></span>		
				</td>
				<td class='LABEL' width='12%'>
					Settlement Amount
				</td>
				<td   width='8%' class='fields'>
					<input type='text' size='17' style="text-align: right;" name='slmtAmt'  id='slmtAmt' value='' onblur="slmtAmtValidate(this);"></td>		
				</td>
				<td  width='15%' class='fields'>
					<!-- <input type='button' class='button' name='colorStatus' id='colorStatus' id='colorStatus' value='Color Status'></td> -->		
				</td>
			</tr>
			<tr id='splDepTr'>
				<td class='LABEL' width='12%'>
					Spl Dep Adjusts&nbsp;<input type='checkbox'  name='splDepChk' id='splDepChk'  value=''>
				</td>
				<td   width='18%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='splDepAdj' id='splDepAdj'></span>		
					</td>		
				</td>
				
				
				<td class='LABEL' width='12%'>
					Avail Spl Dep
				</td>
				<td   width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='availSplDep' id='availSplDep'></span>		
				</td>
				
				<td class='LABEL' width='12%'>
					Adjust
				</td>
				<td   width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y'  name='adjSplDep' id='adjSplDep'></span>		
				</td>
				<td class='LABEL' width='12%'>
					Balance
				</td>
				<td   width='8%' class='LABEL' style="text-align: right">
					<Span roundToVal='Y' name='balSplDep' id='balSplDep'></span>		
				</td>
				<input type='hidden' name='docAmt1' id='docAmt1'  value=''>
				<input type='hidden' name='docAmt' id='docAmt'  value=''>
				<input type='hidden' name='patDepAdj' id='patDepAdj'  value=''>
				<input type='hidden' name='patDepBal' id='patDepBal'  value=''>
				<input type='hidden' name='patPrepayAdj' id='patPrepayAdj'  value=''>
				<input type='hidden' name='patPrepayBal' id='patPrepayBal'  value=''>
				<input type='hidden' name='depAdjustedYn' id='depAdjustedYn'  value=''>
				<input type='hidden' name='preAdjustedYn' id='preAdjustedYn'  value=''>	
				<input type='hidden' name='prevDepAdjAmt' id='prevDepAdjAmt'  value=''>
				<input type='hidden' name='prevPreAdjAmt' id='prevPreAdjAmt'  value=''>				
			</tr>			
		</table>
				</td>
			</tr>
		</table>
		
	</div>
</body>
</html>

