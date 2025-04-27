<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523         MOHE-CRF-0060       		  Shikha Seth
2	     V210824 			22431		  MOHE-SCF-0136				  Nandhini M
3	     V221023					TH-KW-CRF-0020.7		Mohanapriya
4						TH-KW-CRF-0143                    Kamatchi S
5				V221129				37915			TH-KW-CRF-0084.1			Mohanapriya
6				V221230							NMC-JD-CRF-0191.1 			Mohanapriya
--------------------------------------------------------------------------------------------------------
-->

<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Properties"%>
<%@page import="eBL.billreceipt.model.BillReceiptInfoDetails"%>
<%@page import="eBL.billreceipt.response.BillReceiptResponse"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="eBL.placeorder.model.BLChargePatientServiceDetailsBean"%>
<%@page import="eBL.placeorder.response.PlaceNewOrderResponse"%>
<%@page import="eBL.placeorder.request.PlaceNewOrderRequest"%>
<%@page import="eBL.billreceipt.model.BillReceiptSummaryBean"%>
<%@page import="eBL.billreceipt.response.BillReceiptResponse"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*" %> 
<%@ page   import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*,org.apache.commons.codec.binary.Base64,eCA.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
<!--meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<title>Bill Receipt Info</title>
<%!
	private String replaceNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}
%>
<%
	request.setCharacterEncoding("UTF-8");//added by Nandhini
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
			
	String queryString = request.getQueryString();
	Connection conn	= null;//Added by Kamatchi S for TH-KW-CRF-0143
	conn = ConnectionManager.getConnection(request);//Added by Kamatchi S for TH-KW-CRF-0143
	Boolean siteSpecServiceCode = false;//Added by Kamatchi S for TH-KW-CRF-0143
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_SERVICE_CODE_REQD");//Added by Kamatchi S for TH-KW-CRF-0143
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ;
	
	boolean enableInsClear=false;//V221129
	String enableInsClearance="";
	try {
		enableInsClear = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL", "BL_INS_CLEARANCE_APPL");
		System.err.println("enableInsClear--" + enableInsClear);
		if (enableInsClear) {
			enableInsClearance = "Y";
		} else {
			enableInsClearance = "N";
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
		//V221129
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="javascript" src="../../eBL/js/BillReceipt.js"></script>
<script language="javascript" src='../../eBL/js/PkgUtilization.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<script>
function reclacSlmtDeposit(){
	var depChkYn;
	var prePayChkYn;
	var pDoc = parent.BillReceiptExisOrderSummary.document;
	if($('#depAdjChk').prop('checked')){
		depAdjChk = 'Y';
	}
	else{
		depAdjChk = 'N';
	}
	
	if($('#prePayChk').prop('checked')){
		prePayChk = 'Y';
	}
	else{
		prePayChk = 'N';
	}
	var params = 'calledFrom=recalcDepositSlmt'+
				'&patientId='+$('#patient_id').val()+
				'&episodeType='+$('#episode_type').val()+
				'&episodeId='+$('#episode_id').val()+
				'&visitId='+$('#visit_id').val()+
				'&depChkYn='+depAdjChk+
				'&prePayChkYn='+prePayChk+
				'&approxPatAmt='+$.trim($(pDoc).find('#approxPatAmt').text())+
				'&slmtAmt='+$(pDoc).find('#slmtAmt').val()+
				'&deposits='+$.trim($(pDoc).find('#deposits').text())+
				'&patAmt='+$.trim($(pDoc).find('#patAmt').text())+
				'&depAdjustedYn='+$.trim($(pDoc).find('#depAdjustedYn').val())+
				'&preAdjustedYn='+$.trim($(pDoc).find('#preAdjustedYn').val())+
				'&refDepAdj='+$.trim($('#patDepAdj').text())+
				'&refDepBal='+$.trim($('#patDepBal').text())+
				'&refprePayAdj='+$.trim($('#patPrepayAdj').text())+
				'&refprePaybal='+$.trim($('#patPrepayBal').text())+
				'&prevDepAdjAmt='+$(pDoc).find('#prevDepAdjAmt').val()+
				'&prevPreAdjAmt='+$(pDoc).find('#prevPreAdjAmt').val();				
				
	$.ajax({
		type:"GET",
		url:"../jsp/BillReceiptAjax.jsp",
		data:params,
		dataType:"json",
		async:false,
		success: function(data){
			var noOfDecimal = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
			$(pDoc).find('#approxPatAmt').text($.trim(data.approxPatAmt));
			$(pDoc).find('#slmtAmt').val($.trim(data.slmtAmt));
			$(pDoc).find('#docAmt').val($.trim(data.slmtAmt));
			$(pDoc).find('#docAmt1').val($.trim(data.slmtAmt));
			$(pDoc).find('#deposits').text($.trim(data.deposits));
			$(pDoc).find('#depAdjustedYn').val($.trim(data.depAjustedYn));
			$(pDoc).find('#preAdjustedYn').val($.trim(data.preAjustedYn));
			$(pDoc).find('#prevDepAdjAmt').val($.trim(data.prevDepAdjAmt));
			$(pDoc).find('#prevPreAdjAmt').val($.trim(data.prevPreAdjAmt));
			
			var refDepAdj=$.trim(data.refDepAdj);
			var refDepBal=$.trim(data.refDepBal);
			var refprePayAdj=$.trim(data.refprePayAdj);
			var refprePaybal=$.trim(data.refprePaybal);
			$('#patDepAdj').text(refDepAdj);
			$('#patDepBal').text(refDepBal);
			$('#patPrepayAdj').text(refprePayAdj);
			$('#patPrepayBal').text(refprePaybal);			

			if($('#patDepAdj').text() != ''){
				
				putDecimal_Text($('#patDepAdj'),17,noOfDecimal);	
				}
			else{
				$('#patDepAdj').text('0');
				putDecimal_Text($('#patDepAdj'),17,noOfDecimal);
			}
			
			if($('#patDepBal').text() != ''){
				putDecimal_Text($('#patDepBal'),17,noOfDecimal);				
			}
			else{
				$('#patDepBal').text('0');
				putDecimal_Text($('#patDepBal'),17,noOfDecimal);
			}
			
			if($('#patPrepayAdj').text() != ''){
				putDecimal_Text($('#patPrepayAdj'),17,noOfDecimal);				
			}
			else{
				$('#patPrepayAdj').text('0');
				putDecimal_Text($('#patPrepayAdj'),17,noOfDecimal);
			}
			
			if($('#patPrepayBal').text() != ''){
				putDecimal_Text($('#patPrepayBal'),17,noOfDecimal);				
			}
			else{
				$('#patPrepayBal').text('0');
				putDecimal_Text($('#patPrepayBal'),17,noOfDecimal);
			}
			
			if($(pDoc).find('#approxPatAmt').text() != ''){
				putDecimal_Text($(pDoc).find('#approxPatAmt'),17,noOfDecimal);				
			}
			else{
				$(pDoc).find('#approxPatAmt').text('0');
				putDecimal_Text($(pDoc).find('#approxPatAmt'),17,noOfDecimal);
			}
			
			if($(pDoc).find('#slmtAmt').val() != ''){
				putDecimal($(pDoc).find('#slmtAmt').get(0),17,noOfDecimal);
				putDecimal($(pDoc).find('#docAmt').get(0),17,noOfDecimal);		
			}
			else{
				$(pDoc).find('#slmtAmt').val('0');
				putDecimal($(pDoc).find('#slmtAmt').get(0),17,noOfDecimal);
				$(pDoc).find('#docAmt').val('0');
				putDecimal($(pDoc).find('#docAmt').get(0),17,noOfDecimal);
			}
			
			if($(pDoc).find('#deposits').text() != ''){
				putDecimal_Text($(pDoc).find('#deposits'),17,noOfDecimal);				
			}
			else{
				$(pDoc).find('#deposits').text('0');
				putDecimal_Text($(pDoc).find('#deposits'),17,noOfDecimal);
			}
		},
		 error: function(data){
			 alert(data)
	      }
	});
}
	$(document).ready(function(){
		$('#trProgress').hide();
		var noOfDecimal = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
		var billCashBlngServSeparately=$(parent.BillReceiptTab.document).find('#billCashBlngServSeparately').val();
		if(billCashBlngServSeparately == 'N'){
		$('#billGenOpt').attr('disabled','disabled');
		}else{
			$('#billGenOpt').removeAttr('disabled');
		}
		
		$('#billGenType').attr('disabled','disabled');
		$('#pkgDtls').click(   function(){
			 //alert("inside 228");
			var dialogHeight= "95vh" ;
			var dialogWidth	= "95vw" ;													   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	
			var params = "../jsp/BillReceiptpkgUtilization.jsp?patient_id="+$('#patient_id').val()+
						"&noOfDecimal="+noOfDecimal+
						"&episodeType="+$('#episode_type').val()+
						"&visitId="+$('#visit_id').val()+
						"&episodeId="+$('#episode_id').val();
						
			var retVal =  window.showModalDialog(params,null,features);	
		});		
		
		var tabDoc = parent.BillReceiptTab.document;		
		$(tabDoc).find('#interfaceYn').val($('#interfaceYn').val());
		$(tabDoc).find('#futureOrderYn').val($('#futureOrderYn').val());
		
		var default_disc_bill_ind = $(parent.BillReceiptTab.document).find('#default_disc_bill_ind').val();				
		
		if($('#episode_type').val() == 'I' && $('#displayLastBedDate').val() == 'Y'){
				$('#trLastBedChargeDt').show();
				$('#trComputeUptoDt').show();
		}
		else{
			$('#trLastBedChargeDt').hide();
			$('#trComputeUptoDt').hide();
		}
		//Added by Nandhini against V210824 
		if($('#episode_type').val() == 'I' || $('#episode_type').val() == 'D'){
			if($('#expDischOrDischLabel').val() == 'Y'){
				//$('#expDisDate').text('Exp Discharge Date');
				var ExpectedDischargeDate = getLabel("eBL.ExpectedDischargeDate.label","bl_labels");
				$('#expDisDate').text(ExpectedDischargeDate);
			}
			else{
				var Discharge = getLabel("eBL.Discharge.label","bl_labels");
				//$('#expDisDate').text('Discharge Date');
				$('#expDisDate').text(Discharge);
			}
			
			var Admission = getLabel("eBL.Admission.label","bl_labels");
			//$('#admVisitDate').text('Admission Date/Time');
			$('#admVisitDate').text(Admission);
		}
		else{
			//$('#expDisDate').text('Checkout Date/Time');
			var checkOut = getLabel("eBL.checkOut.label","bl_labels");
			//alert("one");
			$('#expDisDate').text(checkOut);
			var Visit = getLabel("eBL.Visit.label","bl_labels");
			//$('#admVisitDate').text('Visit Date/Time');
			$('#admVisitDate').text(Visit);
		}
		//Added by Nandhini against V210824 ends
		
		if($(tabDoc).find('#depChk').val() == 'Y'){
			$('#depAdjChk').attr('checked','checked');
		}
		
		if($(tabDoc).find('#prePayChk').val() == 'Y'){
			$('#prePayChk').attr('checked','checked');
		}
					
		if($('#futureOrderYn').val() == 'Y'){
			alert(getMessage('BL9859','BL'));
		}

		if($('#futureOrderYn').val() == 'N'){
			parent.BillReceiptTab.document.getElementById('futureOrder').disabled = true;
		}

		if($('#interfaceYn').val() == 'Y'){
			/*Added by Gayathri- For MMS- For IP and DC ,interface button should be disabled*/
				if( ($('#episode_type').val() == 'I' || $('#episode_type').val() == 'D')){
					document.getElementById("interfaceBtn").disabled = true;
				}
				else{
					alert(getMessage('BL5202','BL'));
					document.getElementById("interfaceBtn").disabled = false;
				}
		}

		if($('#interfaceYn').val() == 'N' || ($('#episode_type').val() == 'I' || $('#episode_type').val() == 'D')){
			parent.BillReceiptTab.document.getElementById('interface').disabled = true;
		}
		
		if($('#interfaceYn').val() == 'N' || ($('#episode_type').val() == 'I' || $('#episode_type').val() == 'D')){
			document.getElementById("interfaceBtn").disabled = true;
		}

		
		
		$('#clearBtn').click(function(){
			//parent.window.close();
			parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
			
		
		});
		
		$('span').each(function(){
			if($(this).attr('roundToVal') == 'Y'){
				
				if($.trim($(this).text()) != ''){
					putDecimal_Text($(this),17,noOfDecimal);			
				}
				else{
					$(this).text('0');
					putDecimal_Text($(this),17,noOfDecimal);
				}
			}
		});
		
		var unBilled = $.trim($('#unBillAmt').text());
		var outStCash = $.trim($('#outstCash').text());
		var outStCredit = $.trim($('#outstCredit').text());
		var totOutSt = parseFloat(outStCash)+parseFloat(outStCredit);
		$(tabDoc).find('#unBilled').val(unBilled);
		$(tabDoc).find('#totOutSt').val(totOutSt);
		
		if(outStCash > 0){
			$('#outstCash').css('background','red');
			$('#outstCash').css('color','white');
		}
		
		$('#interfaceBtn').click(function(){
			$(parent.BillReceiptTab.document).find('#interface').click();
			$(parent.BillReceiptTab.document).find('#interface').addClass('CASECONDSELECTHORZ');
			/*var patient_id=$('#patient_id').val();
			var episode_id=$('#episode_id').val();
			var visit_id=$('#visit_id').val();
			var episode_type=$('#episode_type').val();
			var patient_name=$('#patient_name').val();
			//alert("patient_name"+patient_name);
			//alert('epi type '+episode_type);
			// alert('patient_id'+patient_id+'episode id '+episode_id+'visit id  '+visit_id);

				
			var url="../../eBL/jsp/BLBillGenInterfaceMainFrame.jsp?patient_id="+patient_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&patient_name="+patient_name;
			//alert('url '+url);
			
			var dialogHeight= "50" ;
			var dialogWidth	= "84" ;													   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
				var retVal =window.showModalDialog(url,null,features);  */
		});

		$('#depAdjChk').change(function(){
			/*if($(this).prop('checked')){
				$('#patDepAdj').text($.trim($('#availPatDep').text()));
				$('#patDepBal').text('0');
				putDecimal_Text($('#patDepBal'),17,noOfDecimal);
			}
			else{
				$('#patDepBal').text($.trim($('#availPatDep').text()));
				$('#patDepAdj').text('0');
				putDecimal_Text($('#patDepAdj'),17,noOfDecimal);
			}*/
			
			//$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
			reclacSlmtDeposit();
		});
		
		$('#prePayChk').change(function(){
			/*if($(this).prop('checked')){
				$('#patPrepayAdj').text($.trim($('#availPatPrepay').text()));
				$('#patPrepayBal').text('0');
				putDecimal_Text($('#patPrepayBal'),17,noOfDecimal);
			}
			else{
				$('#patPrepayBal').text($.trim($('#availPatPrepay').text()));
				$('#patPrepayAdj').text('0');
				putDecimal_Text($('#patPrepayAdj'),17,noOfDecimal);
			}*/
			
			//$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
			reclacSlmtDeposit();
		});
		
		$('#inPatBillType').change(function(){			
			var dt1 = $.trim($('#lastBedChargeDt').text());
			var dt2 = $.trim($('#computeUptoDt').text());
			var diffInSec = 0;
			if(dt1 != '' && dt2 != ''){
				var dtObj1 = returnDateObj(dt1);
				var dtObj2 = returnDateObj(dt2);				
				diffInSec = (dtObj2.getTime() - dtObj1.getTime())/1000;
			}
						
			if($(this).val() == 'I' 
					&& $('#episode_type').val() == 'I' 
					&& $.trim($('#lastBedChargeDt').text()) != ''
					&& diffInSec >= 86400){
				$('#trLastBedChargeDt').show();
				$('#trComputeUptoDt').show();
			}
			else{
				$('#trLastBedChargeDt').hide();
				$('#trComputeUptoDt').hide();
			}
			
			if($(this).val() == 'D'){
				$(parent.BillReceiptExisOrderSearch.document).find('#reset').click();
				disableExistingOrder();
			}
			else{
				enableExistingOrder();
			}
			$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
		});
		
		$('#draftBtn').click(function(){
			var detailYnVal = '';
			if($('#detailChk').prop('checked')){
				detailYnVal = 'Y';
			}
			else{
				detailYnVal = 'N';
			}
			
			var params = "func_mode=interimChargeValidation"+
						"&patientId="+$('#patient_id').val()+
						"&episodeType="+$('#episode_type').val()+
						"&episodeId="+$('#episode_id').val()+
						"&detailRepYn="+detailYnVal;
						
			$.ajax({
				type:"GET",
				url:"../jsp/BLCommonReportValidation.jsp",
				data:params,
				dataType:"text",
				async:false,
				success: function(data){
					var retValArr = $.trim(data).split("::##");
					if(retValArr.length == 4){	//Array Length 4-> No Errors Else, Procedure Has throws some Exception
						
					var htmlVal = "<html><body>";
					htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
					htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+$('#facilityId').val()+"'>";
					htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+$('#locale').val()+"'>";
					htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+retValArr[2]+"'>";
					htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+retValArr[2]+"'>";
					htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+retValArr[1]+"'>";
					htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+retValArr[3]+"'>";
					htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";	
					
					htmlVal += "</form></body></html>";

					parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlVal);
					parent.messageFrame.document.dummy_frm.submit();		
					//interim_main_report.frames[0].document.forms[0].submit();				
					}
				},
				 error: function(data){
					 alert(data)
			      }
			});
		});		
		
		var infoDoc = parent.BillReceiptInfo.document;		
		if($(infoDoc).find('#depAdjChkYn').val() == 'Y'){		
			$('#depAdjChk').prop('checked',true);
		}else{		
			$('#depAdjChk').prop('checked',false);
		}
		if($(infoDoc).find('#preAdjChkYn').val() == 'Y'){		
			$('#prePayChk').attr('checked',true);
		}else{
			$('#prePayChk').attr('checked',false);
		}
		$('#billGenOpt').change(function(){
			if($(this).val() != 'C'){
				$('#billGenType').val('');
				$('#billGenType').attr('disabled','disabled');
				$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
			}
			else{
				$('#billGenType').val('');
				$('#billGenType').removeAttr('disabled');
				$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
			}
		});

		$('#billGenType').change(function(){
			$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
		});
		/*if($(tabDoc).find('#dflt_adj_dep_dur_bill_yn').val() == 'Y'){
		alert("inside here also");
			$('#depAdjChk').attr('checked',true);
		}else{
			$('#depAdjChk').attr('checked',false);
		}
		if(($(tabDoc).find('#dflt_adj_prepay_dur_bill_yn').val() == 'Y') || ($(tabDoc).find('#adj_pat_prepay_in_enc_pre_yn').val() == 'Y')) {
			$('#prePayChk').attr('checked',true);
		}else{
			$('#prePayChk').attr('checked',false);
		}
		*/
		if($('#episode_type').val() == 'I' || $('#episode_type').val() == 'D'){
			$('#inPatBillType').val($('#ipBillType').val());
		}
		else{
			$('#inPatBillType').val('');
			$('#inPatBillType').attr('disabled',true);
		}
		/*if($(tabDoc).find('#default_disc_bill_ind').val() == 'D'){
			//alert("in if"+default_disc_bill_ind);
			$('#inPatBillType').val('D');
		}else{
			//alert("in else"+default_disc_bill_ind)
			$('#inPatBillType').val('U');
		}*/		
		parent.BillReceiptExisOrderSearch.document.location.href = 'BillReceiptExistingOrderSearch.jsp?'+'<%=queryString%>';
	});
	
	async function generateBill(){

			var exisOrderDoc = parent.BillReceiptExisOrderDetails.document;
			var summDoc = parent.BillReceiptExisOrderSummary.document;
			var tabDoc = parent.BillReceiptTab.document;
			//Added by Kamatchi S for for TH-KW-CRF-0143
			if($('#siteSpecServiceCode').val() == true || $('#siteSpecServiceCode').val() == 'true')
			{
				if(($('#episode_type').val() == 'D' || $('#episode_type').val() == 'I') && $('#inPatBillType').val() == 'D' && ($('#coderClearanceStatus').val() == 'N' || $('#coderClearanceStatus').val() == "null")){
				alert(getMessage('BL0954','BLEXT'));
				return false;
				}
			} 
			
			//V221129 Starts
			var enableInsClearance=document.getElementById("enableInsClearance").value;
			if(enableInsClearance=='Y' && ( $('#episode_type').val() == 'I' ||  $('#episode_type').val() == 'D') ){ //O E R I D
				var ind='';
				$.ajax({
				type:"POST", 
				url:"../jsp/BLCommonAjax.jsp?functionMode=settlement_ind",
				data:"patientId="+$('#patient_id').val()+
						"&episodeType="+$('#episode_type').val()+
						"&visitId="+$('#visit_id').val()+
						"&episodeId="+$('#episode_id').val(),
				dataType:"text",
				async:false,
				success: function(data){
					ind = $.trim(data);
				},
				 error: function(data){
					 alert(error)
				  }
				});
				
				if(ind=='X'){
					if($('#inPatBillType').val() == 'D'){
						var status='';
						
						$.ajax({
						type:"POST", 
						url:"../jsp/InsuranceClearanceAjax.jsp?functionMode=insuranceClearanceSts",
						data:"patientId="+$('#patient_id').val()+
								"&episodeType="+$('#episode_type').val()+
								"&visitId="+$('#visit_id').val()+
								"&episodeId="+$('#episode_id').val(),
						dataType:"text",
						async:false,
						success: function(data){
							status = $.trim(data);
						},
						 error: function(data){
							 alert(error)
						  }
						});
						
						if(status=="N"){
							alert(getMessage("BL0960","BLEXT"));
							return false;
						}
					}
				}
			}
			//V221129 ends
			//V221023 Starts
			var enableQueuePKID=document.getElementById('enableQueuePKID').value;
			if(enableQueuePKID=='Y' && ( $('#episode_type').val() == 'O') ){ //O E R I D
				
				var servLoc= parent.BillReceiptExisOrderSearch.BLChargePatientEncounterExistingOrder.document.getElementById("serviceLocation").value;
				if(servLoc==''){
					alert(getMessage('BL0951','BLEXT'));
					return false;
				}else if(document.getElementById('queue_id').value==''){
					var msg=getMessage('BL0953','BLEXT');
				
					var dialogHeight= "6" ;
					var dialogWidth	= "20" ;
					var dialogTop = "225" ;
					var center = "1" ;	   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
				
					var params = "../jsp/AlertYesNo.jsp?message="+msg;
					var retVal = await window.showModalDialog(params,null,features);  
					if(retVal == "0"){			
						document.getElementById('queue_id').focus();				
						return false;
					}else{
						 validatePKID(document.getElementById('queue_id').value,'D');
					}
				}
			}
			//V221023 Ends
			var total = $(exisOrderDoc).find('#totalGroup').val();
			var maxPayer=$(exisOrderDoc).find('#maxPayer').val();
			
			/*
			* Stop Bill generation, if the Episode type is Inpatient or Day Care and the Bill Type
			* is not Chosen
			*/
			if($('#episode_type').val() == 'I' || $('#episode_type').val() == 'D'){
				if($('#inPatBillType').val() == ''){
					alert(getMessage("BL00963","BL"));
					return false;
				}
			}
			
			/*
			* If no services exists during bill generation screen stop bill generation
			*/
			if(parseInt(total)<1){
				alert(getMessage('BL9110','BL'));
				return false;
			}
			var infoDoc = parent.BillReceiptInfo.document;
			
			/*
			* While loading the Info Page, if any error found then during bill generation show the error
			* and stop the process
			*/
			if($(infoDoc).find('#MessageText').val() != ''){				
				alert(getMessage($(infoDoc).find('#MessageText').val(),'BL'));
				return false;				
			}
						
			$('#serviceLocation').val($(exisOrderDoc).find('#serviceLocation').val());
			$('#pkgSeqNo').val($(tabDoc).find('#pkgSeqNo').val());
			$('#pkgClosedYn').val($(tabDoc).find('#pkgClosedYn').val());	
			$('#visitTypeCode').val($(exisOrderDoc).find('#visitTypeCode').val());
			if($(summDoc).find('#splDepChk').prop('checked')){
				$('#splDepChk').val('Y');
			}
			else{
				$('#splDepChk').val('N');
			}
			$('#docAmt').val($(summDoc).find('#docAmt').val());
			$('#docAmt1').val($(summDoc).find('#docAmt1').val());
			$('#slmtAmt').val($(summDoc).find('#slmtAmt').val());
			$('#blngGrpId').val($(tabDoc).find('#blngGrpId').val());	
			$('#exemptAmt').val($(summDoc).find('#exemptReq').val());
			$(exisOrderDoc).find('#slmtErrorCheck').val('');
			$(exisOrderDoc).find('#slmtError').val('');
			$(exisOrderDoc).find('#slmtWarning').val('');
			/*if(($.trim($(exisOrderDoc).find('#error').val()) == getMessage('BL1068','BL')) ||
				($.trim($(exisOrderDoc).find('#error').val()) == getMessage('BL1072','BL')) ||
				($.trim($(exisOrderDoc).find('#warning').val()) == getMessage('BL9079','BL')) ||
				($.trim($(exisOrderDoc).find('#warning').val()) == getMessage('BL9080','BL'))){	*/				
			var status = chkSlmtValidationBillGen();
			if(!status){
				return false;
			}
			//}
			
			if($(exisOrderDoc).find('#errorCheck').val() == 'Y' && $.trim($(exisOrderDoc).find('#error').val()) != ''){
				if(parseFloat($('#slmtAmt').val()) == parseFloat(0)){
					if(($.trim($(exisOrderDoc).find('#error').val()) == getMessage('BL1068','BL')) ||
						($.trim($(exisOrderDoc).find('#error').val()) == getMessage('BL1072','BL'))){						
					}
					else{
						alert($(exisOrderDoc).find('#error').val());
						return false;
					}
				}
				else{
					if(($.trim($(exisOrderDoc).find('#error').val()) == getMessage('BL1068','BL')) ||
						($.trim($(exisOrderDoc).find('#error').val()) == getMessage('BL1072','BL'))){			
						
						/*if($.trim($(exisOrderDoc).find('#slmtError').val()) != ''){
							alert($(exisOrderDoc).find('#slmtError').val());
							return false;
						}*/
					}
					else{
						alert($(exisOrderDoc).find('#error').val());
						return false;
					}
				}				
			}
			else if($.trim($(exisOrderDoc).find('#warning').val()) != ''){
				if(parseFloat($('#slmtAmt').val()) == parseFloat(0)){
					if(($.trim($(exisOrderDoc).find('#warning').val()) == getMessage('BL9079','BL')) ||
							($.trim($(exisOrderDoc).find('#warning').val()) == getMessage('BL9080','BL'))){						
					}
					else{
						alert($(exisOrderDoc).find('#warning').val());	
					}
				}
				else{
					if(($.trim($(exisOrderDoc).find('#warning').val()) == getMessage('BL9079','BL')) ||
							($.trim($(exisOrderDoc).find('#warning').val()) == getMessage('BL9080','BL'))){		
							
						/*if($.trim($(exisOrderDoc).find('#slmtWarning').val()) != ''){
							alert($(exisOrderDoc).find('#slmtWarning').val());							
						}*/
					}
					else{
						alert($(exisOrderDoc).find('#warning').val());
					}
				}				
			}

			var capt_addl_id_proof_for_bill_yn=$(parent.BillReceiptTab.document).find('#capt_addl_id_proof_for_bill_yn').val();
			var addl_id_mand_for_payer_bill_yn=$(parent.BillReceiptTab.document).find('#addl_id_mand_for_payer_bill_yn').val();
			var dflt_addl_id_type=$(parent.BillReceiptTab.document).find('#dflt_addl_id_type').val();
			var dflt_addl_id_desc=" ";
			var name="";var id="";var code="";var remarks="";
			
			var param="&dflt_addl_id_type="+dflt_addl_id_type+"&addl_id_mand_for_payer_bill_yn="+addl_id_mand_for_payer_bill_yn;
		
		
			if(capt_addl_id_proof_for_bill_yn=='Y' && maxPayer>0 )
			{		
				var dialogHeight= "150px" ;
				var dialogWidth	= "620px" ;
				var dialogTop = "225" ;
				var center = "1" ;														   
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;		
				var retVal = await window.showModalDialog("../../eBL/jsp/BillReceiptIdProofValidation.jsp?"+param,null,features);
			
				if(retVal !=null && retVal != undefined){			
					patientName=retVal[0];
					altIdNo=retVal[1];
					altIdType=retVal[2];
					 remarks=retVal[3];
						$('#altIdType').val(altIdType);
						$('#patientName').val(patientName);
						$('#altIdNo').val(altIdNo);
						$('#remarks').val(remarks);
				}
				else{
					return false;
				}		
			}
			if($(exisOrderDoc).find('#pkgCount').val()>0){
				var pkgSeqNo=$(tabDoc).find('#pkgSeqNo').val();
				var totalCount=$(tabDoc).find('#totalCount').val();
				var packageCode=$(tabDoc).find('#packageCode').val();
				
				$('#pkgSeqNo').val(pkgSeqNo);
				$('#totalCount').val(totalCount);
				$('#packageCode').val(packageCode);				
			}

			var unprocessedparams = 'calledFrom=UnprocessedCheck'+
			'&patientId='+$('#patient_id').val()+
			'&facilityId='+$('#facilityId').val()+
			'&episodeType='+$('#episode_type').val()+
			'&episodeId='+$('#episode_id').val()+
			'&visitId='+$('#visit_id').val();
			var continueUnProcessed = true;
			$.ajax({
				type:"GET",
				url:"../jsp/BillReceiptAjax.jsp",
				data:unprocessedparams,
				dataType:"json",
				async:false,
				success: function(data){
					if(data.Success == 'Y'){
						if(data.unprocessed_yn == 'Y'){
							/**Added By Gayathri- For MMS-For Package Patient, 
							*For IP and DC and the Bill type Interim and Undercharge, The Bill should not get generated if any unprocessed records are present
							*/
							if( (($('#episode_type').val() == 'O' || $('#episode_type').val() == 'E') ||
							(($('#episode_type').val() == 'I' || $('#episode_type').val() == 'D') && 
							($('#ipBillType').val() == 'U' || $('#ipBillType').val() == 'D'))) &&
							($(exisOrderDoc).find('#pkgCount').val()>0 && $(tabDoc).find('#pkgClosedYn').val() != 'Y'))
							{
								alert(getMessage('BL00959','BL'));							
								continueUnProcessed = false;						
							}
							else{							
								var con1 = confirm(data.unprocessedMessage);
								continueUnProcessed = con1;
							}												
						}
					}
					else{
						alert(data.errorText);
					}				
				},

			 	error: function(data){			
				 	alert(data)
			  	}
			});
			
			if(!continueUnProcessed){								
				return false;
			}
			
			$('#hdnCntrUserName').val($.trim($('#cntrUserName').text()));
			$('#hdnCntrUserShift').val($.trim($('#cntrUserShift').text()));
			//$('#hdnUnBillAmt').val($.trim($('#unBillAmt').text()));
			$('#hdnUnBillAmt').val($(exisOrderDoc).find('#prevUnBilledAmt').val());
			
			/*Show Progress*/
			$('#tdBtnGenerate').hide();
			$('#trProgress').show();
			$('#tdProgress').text('Generating Bill. . Please Wait. .');
			/*Show Progress*/

			$('#frmBillInfo').attr('target','messageFrame1');
			$('#frmBillInfo').attr('method','post');
			$('#frmBillInfo').submit();

	}
</script>
</head>
<%
//V221023 starts
String enableQueuePKID="N";
boolean isEnablePkid=false;   
Connection con = null;	
String ZatcaYN="N";
Boolean Zatca=false;   	
//V221230 
try{
	con = ConnectionManager.getConnection();
	Zatca= eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ZATCA");
		if (Zatca) {
			ZatcaYN = "Y";
		}else {
			ZatcaYN = "N";
		}
		System.err.println("ZatcaYN blreceiptinfo "+ZatcaYN);
	} catch(Exception ex) {
		System.err.println("Error in blreceiptinfo.jsp for getting ZatcaYN Connection: "+ex);
		ex.printStackTrace();
	}finally{
		if(con!=null) {
			ConnectionManager.returnConnection(con, request);
		}
	}
//V221230 ends

try{
	con = ConnectionManager.getConnection();
	isEnablePkid = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_QMS_IN_BILL_GEN");
		if (isEnablePkid) {
			enableQueuePKID = "Y";
		}else {
			enableQueuePKID = "N";
		}
		System.err.println("enableQueuePKID blreceiptinfo "+enableQueuePKID);
	} catch(Exception ex) {
		System.err.println("Error in blreceiptinfo.jsp for getting isEnablePkid Connection: "+ex);
		ex.printStackTrace();
	}finally{
		if(con!=null) {
			ConnectionManager.returnConnection(con, request);
		}
	}
//V221023 ends


	//String patientId = replaceNull(request.getParameter("patient_id"));//V220512
	String encounterFacilityId = replaceNull(request.getParameter("encounterFacilityId")); //V210129 
	
	//V220512
String patientId	="";
String encounterId	="";

if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	encounterId	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
}else{
	patientId	= replaceNull(request.getParameter("patient_id"));
	encounterId	= replaceNull(request.getParameter("encounter_id"));
}
//V220512
	String episodeType = replaceNull(request.getParameter("episode_type"));
	String episodeId = replaceNull(request.getParameter("episode_id"));
	String visitId = replaceNull(request.getParameter("visit_id"));
	String facilityId = (String) session.getValue("facility_id");
	String coderClearanceStatus = "";//Added by Kamatchi S for TH-KW-CRF-0143
	coderClearanceStatus = bean.getCoderClearanceStatus(facilityId,patientId,episodeType,episodeId,visitId);//Added by Kamatchi S for TH-KW-CRF-0143
	String locale = (String) session.getValue("LOCALE");
	Properties p = (Properties) session.getValue("jdbc");
	String loginUser = (String) p.getProperty("login_user");
	String clientIpAddress = (String) p.getProperty("client_ip_address");
	//String encounterId = replaceNull(request.getParameter("encounter_id"));//V220512
	String patientName=request.getParameter("patientName");
	String name="",id="",code="",remarks="";

	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setEpisodeType(episodeType);
	billRequest.setEpisodeId(episodeId);
	billRequest.setVisitId(visitId);
	billRequest.setFacilityId(facilityId);
	billRequest.setLoginUser(loginUser);
	billRequest.setClientIpAddress(clientIpAddress);
	billRequest.setLocale(locale);

	BillReceiptBC billReceiptBC = new BillReceiptBC();
	BillReceiptInfoDetails billInfo = billReceiptBC.getHeaderDetails(billRequest);
	LinkedHashMap<String,String> custDtls = billInfo.getCustMap();
	request.setAttribute("custDtls", billInfo.getCustMap());
	System.err.println("getIpBillType() ===>>781 :: "+billInfo.getIpBillType());
%>

<body >
<form name='frmBillInfo' id='frmBillInfo' action="../../servlet/eBL.BillReceiptGenerationServlet" method="post" target="messageFrame">
<table  style="width: 100%;">
	<tr style="width: 100%" id='tdBtnGenerate' name='tdBtnGenerate'>
	<td style="width: 68%">
		<input type='button'  name='compute' id='compute' value='<fmt:message key="eBL.GenerateBill.label" bundle="${bl_labels}"/>'class='button' onClick="generateBill()">
		&nbsp;
		<input type='button' class='button' name='pkgDtls' id='pkgDtls'  value='<fmt:message key="eBL.PACKAGE_DTL.label" bundle="${bl_labels}"/>'>
		&nbsp;
		<input type='button'  name='interfaceBtn' id='interfaceBtn' value='<fmt:message key="Common.Interface.label" bundle="${common_labels}"/>' class='button'>
		&nbsp;
		<input type='button'  name='clearBtn' id='clearBtn' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button'>
		&nbsp;
		<%if("I".equals(episodeType)){ %>
				<fmt:message key="Common.Detail.label" bundle="${common_labels}"/> &nbsp;<input type='checkbox' name='detailChk' id='detailChk' id='detailChk'>
		<%}else{ %>
				&nbsp;
		<%} %>
		<%if("I".equals(episodeType)){ %>
				<input type='button' name='draftBtn' id='draftBtn' value='<fmt:message key="eBL.draft.label" bundle="${bl_labels}"/>' class='button'>
			<%}else{ %>
				&nbsp;
			<%} %>
	</td>
	<td style="width: 32%;">
	</td>
	</tr>
	<tr  id='trProgress' name='trProgress'>
		<td  colspan='2'>
			<h3 id='tdProgress' name='tdProgress'>
			</h3>
		</td>
	</tr>
	<tr>
		<td width="68%"  valign="top">
			<table style="width: 100%" class="grid">			
			<tr style="width: 100%">
			<td style="width: 100%; border: 1px solid #666666;">
			<table style="width: 100%" cellpadding='3' cellspacing='1.5' >

				<tr style="width: 100%">
					<td class='LABEL'colspan='2'><fmt:message key="eBL.OutstandAmount.label" bundle="${bl_labels}"/></td>
					<td class='LABEL' width="10%"><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='outstCash' id='outstCash'><%=replaceNull(billInfo.getOutstCash())%></span></td>
					<td class='LABEL' width="10%"><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='outstCredit' id='outstCredit'><%=replaceNull(billInfo.getOutstCredit())%></span></td>
					
					
					
				</tr>
				<tr style="width: 100%">
					<td class='LABEL' width="10%"><fmt:message key="eBL.Availablepatdeposit.label" bundle="${bl_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='availPatDep' id='availPatDep'><%=replaceNull(billInfo.getPatDepAvail())%></span></td>
					<td class='LABEL' width="10%"><fmt:message key="eBL.Adjust.label" bundle="${bl_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='patDepAdj' id='patDepAdj'></span></td>
					<td class='LABEL' width="10%"><fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='patDepBal' id='patDepBal'></span></td>
					
					
					
				</tr>
				<tr style="width: 100%">
					<td class='LABEL' width="10%"><fmt:message key="eBL.Availablepatprepay.label" bundle="${bl_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='availPatPrepay' id='availPatPrepay'><%=replaceNull(billInfo.getPrePayAvail())%></span></td>
					<td class='LABEL' width="10%"><fmt:message key="eBL.Adjust.label" bundle="${bl_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='patPrepayAdj' id='patPrepayAdj'></span></td>
					<td class='LABEL' width="10%"><fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='patPrepayBal' id='patPrepayBal'></span></td>				
					
				</tr>
					<tr style="width: 100%">
					<td class='LABEL' width="10%"><fmt:message key="eBL.UNBILLED_NEW.label" bundle="${bl_labels}"/></td>
					<td width="10%" class='LABEL' style="text-align: right"><Span roundToVal='Y' name='unBillAmt' id='unBillAmt'><%=replaceNull(billInfo.getUnBilled())%></span></td>
					<td class='LABEL' width="10%"><fmt:message key="eBL.DEPOSIT.label" bundle="${bl_labels}"/>&nbsp;<input type='checkbox' name='depAdjChk' id='depAdjChk' id='depAdjChk'>
					</td>
					
					<td width="10%" class='LABEL' style="text-align: right">
					<Span roundToVal='Y' name='depAdjAmt' id='depAdjAmt'><%=replaceNull(billInfo.getPatDepUnAdj())%></span></td>
					<td class='LABEL' width="10%"><fmt:message key="eBL.PrepayAmount.label" bundle="${bl_labels}"/>&nbsp;<input type='checkbox' name='prePayChk' id='prePayChk' id='prePayChk'></td>
					<td width="10%" class='LABEL' style="text-align: right">					
					<Span roundToVal='Y' name='prePayAmt' id='prePayAmt'><%=replaceNull(billInfo.getPrePayUnAdj())%></span></td>				
					
				</tr>
				<tr>
					<td class='LABEL' width="10%"><fmt:message key="eBL.InpatientBillType.label" bundle="${bl_labels}"/></td>
					<td width="10%" class='fields'>
						<Select name='inPatBillType' id='inPatBillType' >
							<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
							<option value='I'><fmt:message key="eBL.PendingInterimBill.label" bundle="${bl_labels}"/></option>
							<option value='D'><fmt:message key="eBL.PendingDischargeBill.label" bundle="${bl_labels}"/></option>
							<option value='U'><fmt:message key="eBL.PendingUnderchargeBill.label" bundle="${bl_labels}"/></option>
						</Select>
						
					</td>

					<td  class='LABEL' width="10%">
					<fmt:message key="eBL.BillGenOption.label" bundle="${bl_labels}"/>
					</td>
					<td width="10%" class='fields' style="text-align: right">
					<Select name='billGenOpt' id='billGenOpt'>							
						<option value='B'><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>
						<option value='P'><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
						<option value='C'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></option>
					</Select>
					&nbsp;
					
					</td>					
					<td class='LABEL' width="10%">					
						<fmt:message key="Common.Payer.label" bundle="${common_labels}"/>					
					</td>
					<td width="10%" class='fields' style="text-align: right">
						<select name='billGenType' id='billGenType' style="width: 150px;">
						<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%for(Iterator iter=custDtls.keySet().iterator(); iter.hasNext();){ 
							String key = (String) iter.next();
						%>
							<option value='<%=key%>'><%=custDtls.get(key) %></option>
						<%} %>
					</select>
					</td>						
				</tr>
				<tr>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			
		</td>
		<td width="32%" valign="top">
			<table style="width: 100%">
			<tr style="width: 100%">
			<td style="width: 100%; border: 1px solid #666666;" >
			<table style="width: 100%; " cellpadding='3' cellspacing='1.5' >
				<tr>
					<td class='LABEL' width="25%">
						<fmt:message key="Common.user.label" bundle="${common_labels}"/> 
					</td>
					<td colspan='3' class='LABEL' >
						<Span name='cntrUserId' id='cntrUserId'><%=loginUser%></span>
					</td>	
					
				</tr>
				<tr>
					
					<td class='LABEL' width="25%">
						<fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/> 
					</td>	
					
					<td width="25%"  class='LABEL'  >
						<Span name='cntrUserName' id='cntrUserName' value='<%=replaceNull(billInfo.getCashCntrId())%>'><%=replaceNull(billInfo.getCashCntrId())%>
						</span><!--V230127-->
					</td>
					<td class='LABEL' width="25%">
						<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>
					</td>	
					<td width="25%"  class='LABEL'  >
						<Span name='cntrUserShift' id='cntrUserShift' value='<%=replaceNull(billInfo.getCashCntrShiftId())%>'><%=replaceNull(billInfo.getCashCntrShiftId())%> 
						</span> <!--V230127-->
					</td>
				</tr>
				</table>
				</td>
				</tr>
				</table>
				
			<table style="width: 100%">
			<tr style="width: 100%">
			<td style="width: 100%; border: 1px solid #666666;" >
			<table style="width: 100%; " cellpadding='3' cellspacing='1.5' >
				<tr>
					
					<td colspan='2' class='LABEL' id='admVisitDate'>
					</td>
					<td colspan='2'  class='LABEL' >
						<span name='admDate' id='admDate' ><%=replaceNull(billInfo.getAdmDate())%></span>
					</td>
					
				</tr>
				<tr>					
					<td colspan='2' class='LABEL' id='expDisDate'>
						<fmt:message key="eBL.ExpectedDischargeDate.label" bundle="${bl_labels}"/>
					</td>
					<td colspan='2'   class='LABEL' >
						<span id='expDischDt' name='expDischDt' class='fields'><%=replaceNull(billInfo.getDischDate())%></span>
					</td>
					
				</tr>
				<%if("I".equals(episodeType)){ %>
				<tr id='trLastBedChargeDt' name='trLastBedChargeDt'>
					<td class='LABEL' colspan='2'>
					<fmt:message key="eBL.LastBedChargeDate.label" bundle="${bl_labels}"/>
					</td>
					<td colspan='2' class='LABEL'>
					<Span name='lastBedChargeDt' id='lastBedChargeDt'><%=replaceNull(billInfo.getLastBedChargeDt())%></span>
					</td>
				</tr>
				<tr id='trComputeUptoDt' name='trComputeUptoDt'>
					<td class='LABEL' colspan='2'>
					Compute Upto					
					</td>
					<td colspan='2'  class='LABEL'>
					<span name='computeUptoDt' id='computeUptoDt'><%=replaceNull(billInfo.getComputeUpto())%></span>
					</td>
				</tr>
				<%}
				else if("D".equals(episodeType)){%>
				<tr id='trLastBedChargeDt' name='trLastBedChargeDt' style="visibility: hidden">
					<td class='LABEL' colspan='2'>
					Last Bed Charge Date
					</td>
					<td colspan='2' class='LABEL'>
					<Span name='lastBedChargeDt' id='lastBedChargeDt'><%=replaceNull(billInfo.getLastBedChargeDt())%></span>
					</td>
				</tr>
				<tr id='trComputeUptoDt' name='trComputeUptoDt' style="visibility: hidden">
					<td class='LABEL' colspan='2'>
					Compute Upto					
					</td>
					<td colspan='2'  class='LABEL'>
					<span name='computeUptoDt' id='computeUptoDt'><%=replaceNull(billInfo.getComputeUpto())%></span>
					</td>
				</tr>
				<%} %>
			</table>
			</td>
			</tr>
			<%
			
			System.err.println("episodeType "+episodeType);
			if(enableQueuePKID.equals("Y") && episodeType.equals("O")){
			%>
			<tr>					
					<td colspan='2' class='LABEL' id='queuepkid'>
						<fmt:message key="eBL.queuePKID.label" bundle="${bl_labels}"/>
					</td>
					<td colspan='2'   class='fields' >
						<input type="text" name="queue_id" id="queue_id"   onBlur="validatePKID(this,'O');"   onKeyPress="" >	
				
					</td>
					
				</tr>
			<% } %>
			</table>
		</td>
	</tr>
</table>
<%
	//V221230
	System.err.println("episodeType "+episodeType);
	if(ZatcaYN.equals("Y")){
	%>
	<tr>					
		<td colspan='2' class='LABEL' id='refnum'>
			<fmt:message key="eBL.OrgBillRefNo.label" bundle="${bl_labels}"/>
		</td>
		<td colspan='2'   class='fields' >
			<input type='text' name="orgBillRefNum" id="orgBillRefNum" readOnly size='10'  value='' onblur="if(this.value!=''){ refNumLookup(this.value); }">
			<input type='button' id='Ref_Num' name='Ref_Num' value='?'  onclick='refNumLookup(this.value)' >					
		</td>
	</tr>
	<% } 
	//V221230
	%>
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patientId %>'>
	<input type='hidden' name='episode_type' id='episode_type' value='<%=episodeType %>'>
	<input type='hidden' name='episode_id' id='episode_id' value='<%=episodeId %>'>
	<input type='hidden' name='visit_id' id='visit_id' value='<%=visitId %>'>
	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounterId %>'>
	<input type='hidden' name='serviceLocation' id='serviceLocation' value=''>
	<input type='hidden' name='pkgSeqNo' id='pkgSeqNo' value=''>
	<input type='hidden' name='pkgClosedYn' id='pkgClosedYn' value=''>
	<input type='hidden' name='visitTypeCode' id='visitTypeCode' value=''>
	<input type='hidden' name='splDepChk' id='splDepChk' value=''>
	<input type='hidden' name='docAmt' id='docAmt' value=''>
	<input type='hidden' name='blngGrpId' id='blngGrpId' value=''>
	<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId %>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
	<input type='hidden' name='slmtAmt' id='slmtAmt' value=''>
	<input type='hidden' name='exemptAmt' id='exemptAmt' value=''>
	<input type='hidden' name='depAdjustedYn' id='depAdjustedYn' value=''>
	<input type='hidden' name='preAdjustedYn' id='preAdjustedYn' value=''>
	<input type='hidden' name='pkgSeqNo' id='pkgSeqNo' value=''>
	<input type='hidden' name='totalCount' id='totalCount' value=''>
	<input type='hidden' name='packageCode' id='packageCode' value=''>

	<input type='hidden' name='MessageText' id='MessageText' value='<%=replaceNull(billInfo.getMessageText())%>'>

	<input type='hidden' name='depAdjChkYn' id='depAdjChkYn' value='<%=replaceNull(billInfo.getDefDepYn())%>'>
	<input type='hidden' name='preAdjChkYn' id='preAdjChkYn' value='<%=replaceNull(billInfo.getDefPreYn())%>'>
	<input type='hidden' name='interfaceYn' id='interfaceYn' value='<%=replaceNull(billInfo.getInterfaceYn())%>'>
	<input type='hidden' name='futureOrderYn' id='futureOrderYn' value='<%=replaceNull(billInfo.getFutureOrderYn())%>'>
	<input type='hidden' name='ipBillType' id='ipBillType' value='<%=replaceNull(billInfo.getIpBillType())%>'>
	<input type='hidden' name='hdnCntrUserName' id='hdnCntrUserName' value=''>
	<input type='hidden' name='hdnCntrUserShift' id='hdnCntrUserShift' value=''>
	<input type='hidden' name='hdnUnBillAmt' id='hdnUnBillAmt' value=''>
	<input type= 'hidden' name='altIdType' id='altIdType' value=''>
	<input type= 'hidden' name='altIdNo' id='altIdNo' value=''>
	<input type= 'hidden' name='patientName' id='patientName' value=''>
	<input type= 'hidden' name='enableQueuePKID' id='enableQueuePKID' value='<%=enableQueuePKID%>'>
	<input type= 'hidden' name='remarks' id='remarks' value=''>
	<input type= 'hidden' name='exemptType' id='exemptType' value=''>
	<input type= 'hidden' name='assignTo' id='assignTo' value=''>
	<input type='hidden' name='displayLastBedDate' id='displayLastBedDate' value='<%=replaceNull(billInfo.getDisplayLastBedDate())%>'>
	<input type='hidden' name='expDischOrDischLabel' id='expDischOrDischLabel' value='<%=replaceNull(billInfo.getExpDischOrDischLabel())%>'>
	<input type='hidden' name='encounterFacilityId' id='encounterFacilityId' value='<%=encounterFacilityId%>'>
	<input type='hidden' name='siteSpecServiceCode' id='siteSpecServiceCode' value='<%=siteSpecServiceCode%>'><!--Added by Kamatchi S for TH-KW-CRF-0143-->
	<input type='hidden' name='coderClearanceStatus' id='coderClearanceStatus' value='<%=coderClearanceStatus%>'><!--Added by Kamatchi S for TH-KW-CRF-0143-->
	<input type='hidden' name='ZatcaYN' id='ZatcaYN' value="<%=ZatcaYN%>" ><!-- V221230 -->
	<input type='hidden' name='enableInsClearance' id='enableInsClearance' value="<%=enableInsClearance%>" ><!-- V221129 -->
</form>
</body>
</html>

