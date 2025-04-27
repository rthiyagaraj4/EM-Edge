<!DOCTYPE html>

<%@page import="eBL.billreceipt.model.BillReceiptSummaryBean"%>
<%@page import="eBL.billreceipt.model.BillReceiptCustomerDetails"%>
<%@page import="eBL.billreceipt.response.BillReceiptResponse"%>
<%@page import="eBL.billreceipt.model.BillReceiptServiceDetails"%>
<%@page import="eBL.billreceipt.model.BillReceiptExclusionDiscount"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.placeorder.model.BLChargePatientServiceDetailsBean"%>
<%@page import="eBL.placeorder.response.PlaceNewOrderResponse"%>
<%@page import="eBL.placeorder.request.PlaceNewOrderRequest"%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@ 
page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.* " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String queryString = request.getQueryString();
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
$(document).ready(function(){
	
	if($('#traverse').val() == 'Y'){
		$('#trProgress').show();
	}else{
		$('#trProgress').hide();
	}
	
	if($('#hdnNextSpan').val() == 'Y'){
		$('#nextSpan').show();
	}else{
		$('#nextSpan').hide();
	}
	
	if($('#prevSpan').val() == 'Y'){
		$('#previousSpan').show();
	}else{
		$('#previousSpan').hide();
	}
	
	payerHide('G');
	
	var total = $('#totalGroup').val();
	if(parseInt(total)<1){
		var pDoc = parent.BillReceiptInfo.document;
		$(pDoc).find('#depAdjChk').attr('disabled','disabled');
		$(pDoc).find('#prePayChk').attr('disabled','disabled');
	}
	else{
		$(pDoc).find('#depAdjChk').attr('disabled','');
		$(pDoc).find('#prePayChk').attr('disabled','');
	}
	
	$('td[id^=serv_grp_desc]').each(function(){
		var grpDesc = $(this).text();
		var openDiv = '<div  style="min-width: 220px; max-width: 220px; width: 220px; overflow: hidden;">';
		var closeDiv = '</div>'
		if(grpDesc.length>100){
			var divAppnd = openDiv+grpDesc.substring(0,40) + ' (...) '+closeDiv;
			$(this).text('');
			$(this).append(divAppnd);
			
			$(this).attr('title',grpDesc);
		}
	});
	
	$('td[id^=serv_line_desc]').each(function(){
		var grpDesc = $(this).text();
		var openDiv = '<div  style="min-width: 220px; max-width: 220px; width: 220px; overflow: hidden;">';
		var closeDiv = '</div>'
		if(grpDesc.length>100){
			var divAppnd = openDiv+grpDesc.substring(0,40) + ' (...) '+closeDiv;
			$(this).text('');
			$(this).append(divAppnd);
			
			$(this).attr('title',grpDesc);
		}
	});
	
	$('#nextSpan').click(function(){		
		var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
		var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
		showServiceDetails(startFrom,endWith);
	});
	$('#previousSpan').click(function(){		
		var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
		var endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
		showServiceDetails(startFrom,endWith);
	});
	//putDecimal_Text($('#gross_amt1'),17,3);
	//$(parent.BillReceiptExisOrderSummary.document).find('#summaryDiv').show();
	var noOfDecimal = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	//groupChangeDecimal('G',$('#maxPayer').val(),noOfDecimal);
	parent.BillReceiptExisOrderSummary.document.location.href = 'BillReceiptExisOrderSummary.jsp';
	//findTotal();

	if($('#error').val() != '' && $('#errorCheck').val() == 'Y'){
		if($('#error').val() != undefined && $('#error').val() != 'undefined' ){
			alert($('#error').val());
		}		
	}
	/* Added By Gayathri- For MMS- For Inpatient and the BillType Interim, The Package Closure window will not be displayed*/
if( $(parent.BillReceiptInfo.document).find('#episode_type').val()== 'I' && $(parent.BillReceiptInfo.document).find('#ipBillType').val()=='I'){
		$('#pkgCount').val('0');
	
		}
if(parseInt($('#pkgCount').val()) > 0 && $(parent.BillReceiptTab.document).find('#pkgAlrdPop').val() == 'N' && $(parent.BillReceiptInfo.document).find('#interfaceYn').val() == 'N'){
		
		packageClosure();
		if($(parent.BillReceiptTab.document).find('#pkgClosedYn').val() == 'Y'){
			$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
		}
	}
	
});

var headTop = -1;
var FloatHead1;
function processScroll()
	{
	/*if (headTop < 0)
	{
		saveHeadPos();
		
	}
	if (headTop>0)
	{
		if (document.documentElement && document.documentElement.scrollTop)
			theTop = document.documentElement.scrollTop;
		else if (document.body)
			theTop = document.body.scrollTop;

		if (theTop>headTop)
			FloatHead1.style.top = (theTop-headTop) + 'px';
		else
			FloatHead1.style.top = '0px';
	}*/
	var tab3=document.getElementById("divTitleTable23");
	var widthValue=400;
	var x = document.body.scrollLeft;
	var y = document.body.scrollTop;
	var px = '';
	if(x > 0)
	{
		px = x+"px";
		$('div[id^=fixedCols]').each(function(){
			$(this).css('left',px);
			$(this).css('position','relative');
		})
		
		//tab3.style.left=
	}
	else
	{
		//tab1.style.left="0px";
		$('div[id^=fixedCols]').each(function(){
			$(this).css('left','0px');
			$(this).css('position','relative');
		})
		//tab3.style.left="0px";
		x=0;
	}
	if(y > 0)
	{
	
		px = y+"px";
		$('#fixedColsHdr1').css('top',px);
		$('#fixedColsHdr1').css('position','relative');
		//tab2.style.top=(y-4)+"px";
		$('#fixedHeaderTop').css('top',px);
		$('#fixedHeaderTop').css('position','relative');
	}
	else
	{
		$('#fixedColsHdr1').css('top','0px');
		$('#fixedColsHdr1').css('position','relative');
		$('#fixedHeaderTop').css('top','0px');
		$('#fixedHeaderTop').css('position','relative');
	}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead1 = document.getElementById("heading");
			FloatHead1.style.position = "relative";
		}
	}
	
	function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }

	  function lockbackSpace()
	  {
		// alert(document.order_type_form.mode.value);
		   var mode = document.mode.value;
      // alert(window.event.keyCode);
		 if(mode=='modify' && window.event.keyCode==8)
		  {
           //return false;
		  }
	  }
	 
	
	
</script>
</head>
<style>

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
		
		TD.greyedData
		{
			BACKGROUND-COLOR: #A3A3A3 ;
			FONT-SIZE: 8pt ;
			color : #FFFFFF;
		}
		</style>
<%
System.out.println("=======================came========================");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String facilityId																			=	"";


int constCount = 50;
String nextYn = "N";
String prevYn = "N";
String traversal = "N";
String fromRcrd = "";
String toRcrd = "";
int startIndex = 0;
int startRcrd = 0;
int endRcrd = 0;
int totalRecord=0;
//Added By Rajesh V


String service_code																			=	"";
String service_class																			=	"";
String billing_service																			=	"";
String item																			=	"";
String ent_servGroup																			=	"";
String ent_GrpLine																			=	"";
String from_date																			=	"";
String to_date																			=	"";

String groupLineService="";
String episodeType="";
String patientId="";
String episodeId="";
String visitId="";
String locale="";
Connection conn = null;
List<BillReceiptServiceDetails> serviceDetails = new ArrayList<BillReceiptServiceDetails>();
List<BillReceiptCustomerDetails> custDetails = null;
String beanId = "BillReceiptExistOrderExclusion" ;
String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
int maxPayer = 0;
String loginUser = (String) session.getValue("login_user");
Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String client_ip_address = p.getProperty("client_ip_address");
try  
{
	sStyle 																				=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																				= 	(String)session.getAttribute("LOCALE");
	facilityId																			=   (String) session.getValue( "facility_id" ) ;
	service_code																		=	checkForNull(request.getParameter("serviceCode"));
	service_class																		=	checkForNull(request.getParameter("serviceClass"));
	billing_service																		=	checkForNull(request.getParameter("billingService"));
	item																				=	checkForNull(request.getParameter("item"));
	ent_servGroup																		=	checkForNull(request.getParameter("entServGroup"));
	ent_GrpLine																			=	checkForNull(request.getParameter("entGrpLine"));
	from_date																			=	checkForNull(request.getParameter("fromDate"));
	to_date																				=	checkForNull(request.getParameter("toDate"));
	groupLineService																	=	checkForNull(request.getParameter("groupLineService"));
	episodeType																			=	checkForNull(request.getParameter("episodeType"));
	patientId																			=	checkForNull(request.getParameter("patientId"));
	episodeId																			=	checkForNull(request.getParameter("episodeId"));
	visitId																				=	checkForNull(request.getParameter("visitId"));
	locale																				=	checkForNull(request.getParameter("locale"));
	String serviceLocation = checkForNull(request.getParameter("serviceLocation"));
	String acctSeqNo = checkForNull(request.getParameter("acctSeqNo"));

	String depChkYn = checkForNull(request.getParameter("depChkYn"));
	String prePayChkYn = checkForNull(request.getParameter("prePayChkYn"));
	String splDepChkYn = checkForNull(request.getParameter("splDepChkYn"));
	String ipBill = checkForNull(request.getParameter("ipBill"));
	String billGenOpt = checkForNull(request.getParameter("billGenOpt"));
	String billGenType = checkForNull(request.getParameter("billGenType"));

	if("".equals(depChkYn)){
		depChkYn = "Y";
	}
	if("".equals(prePayChkYn)){
		prePayChkYn = "Y";	
	}
	if("".equals(splDepChkYn)){
		splDepChkYn = "Y";
	}
	System.err.println(depChkYn+prePayChkYn+splDepChkYn+ipBill+acctSeqNo);
	PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
	BillReceiptResponse responseBean = null;
	BillReceiptBC billreceiptBC = new BillReceiptBC();
	requestBean.setFacilityId(facilityId);
	requestBean.setServGroupCode(service_code);
	requestBean.setServClass(service_class);
	requestBean.setServCode(billing_service);
	requestBean.setItemCode(item);
	requestBean.setEntServGroup(ent_servGroup);
	requestBean.setEntGrpLine(ent_GrpLine);
	requestBean.setFromDate(from_date);
	requestBean.setToDate(to_date);
	requestBean.setGroupLineService(groupLineService);
	requestBean.setEpisodeType(episodeType);
	requestBean.setPatientId(patientId);
	requestBean.setEpisodeId(episodeId);
	requestBean.setVisitId(visitId);
	requestBean.setLocale(locale);
	requestBean.setProcessed("P");	
	requestBean.setServOrPanel(serviceLocation); //It Contains Service Location
	requestBean.setLoginUser(loginUser);
	requestBean.setClientIpAddress(client_ip_address);
	requestBean.setDepChkYn(depChkYn);
	requestBean.setPrePayChkYn(prePayChkYn);
	requestBean.setSplDepChkYn(splDepChkYn);
	requestBean.setIpBill(ipBill);
	requestBean.setBillGenOpt(billGenOpt);
	requestBean.setBillgenType(billGenType);

	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	
	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	}
	else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
	
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	}
	else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;

	requestBean.setStartFrom(startRcrd);
	requestBean.setEndWith(endRcrd);
	
	conn = ConnectionManager.getConnection();
	conn.setAutoCommit(false);
	exclusionBean.setFacilityId(facilityId);
	Set<String> exclusionSet = exclusionBean.getServiceExclusion();
	HashMap<String,BillReceiptExclusionDiscount> discMap = exclusionBean.getDiscountMap();
	List<BillReceiptExclusionDiscount> exclDiscList = exclusionBean.getExclDiscList();
	
	Set<String> groupExclusion = exclusionBean.getGroupExclusion();
	Set<String> lineExclusion = exclusionBean.getLineExclusion();
	if(discMap == null){
		discMap = new HashMap<String,BillReceiptExclusionDiscount>();
	}
	System.err.println("Before insert excl starts");
	billreceiptBC.insertExcludedServices(requestBean,exclusionBean, conn);
	System.err.println("Before insert excl ends");
	
	System.err.println("Before fetch folio starts");
	responseBean =	billreceiptBC.getServiceDetailsData(requestBean,conn);
	System.err.println("Before fetch folio ends");
	conn.rollback();
	serviceDetails = responseBean.getServiceList();
	custDetails = responseBean.getCustList();
	System.err.println("custDetails Size->"+custDetails.size());
	if(custDetails != null){
		maxPayer = custDetails.size();
	}
	totalRecord = responseBean.getTotalRecordCount();

%>
<body onScroll="processScroll();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" >
	<form id="bLChargePatientServicePriceDetails" name="bLChargePatientServicePriceDetails" >	


	
		

				<% if(!(startRcrd<=1)){
					prevYn = "Y";
					traversal = "Y";
				}
		
				if ( !( (startRcrd+constCount) > totalRecord ) ){
					nextYn = "Y";
					traversal = "Y";
				}
				%>
	<table border="0" cellspacing="0" cellpadding="0"   style="width: 200%; " name="panel_categories_header_table" id="panel_categories_header_table" border="1"  >	 
		<tr style="background-color: white; border: none;" id='trProgress'>
			<td >
				<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer;">
					<span id='previousSpan'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></span>
				</span>
				&nbsp;	
				<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer;">
					<span id='nextSpan' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></span>
				</span>
			</td>		
			<td>
			</td>			
		</tr>	
		<%if("G".equals(groupLineService)){ %>
		<TR >	
			<td id='firstMainColHdr' style='width: 15%; ' >
				<div id='fixedColsHdr1' style="z-index: 100; margin-top: 0px; left:0px; position: relative;">
				<table  border="1" cellspacing="0" cellpadding="0"  style="max-height: 60px; min-height: 60px; height: 60px; width: 100%;  "  >
					<tr style="height: 20px;">
						<td class='COLUMNHEADER'  colspan='2'>&nbsp;</td>
					</tr>
					<tr>						
						<td class='COLUMNHEADER'  style="padding-left:0px; width: 146px; "		align="left"	><fmt:message key="eBL.EnterpriseServiceGroup.Label" 	bundle="${bl_labels}"	/></td>
						<td class='COLUMNHEADER'  style="padding-left:0px; width: 220px;"		align="left"	><fmt:message key="eBL.Description.label" 	bundle="${bl_labels}"	/></td>						
					</tr>
				</table>
				</div>
			</td>
			<td id='secondMainColHdr' style='width: 85%; ' class='COLUMNHEADER'>
				<div id='fixedHeaderTop' >
				<table  border="1" cellspacing="0" cellpadding="0"  style="width: 100%; max-height: 60px; min-height: 60px; height: 60px;">
					<tr>
						<td class='COLUMNHEADER' style='padding-left:0px; ' colspan='3'></td>
						<td class='COLUMNHEADER' style='padding-left:0px; ' colspan='3'	align="center"	id="tdCashHdr"><fmt:message key="eBL.CASH.label" 	bundle="${bl_labels}"	/></td>
						<%for(int py=1;py<=7;py++){ %>
						<td class='COLUMNHEADER' style='padding-left:0px; ' colspan='3'	align="center" id='payer<%=py %>Hdr' >
							<img src='../../eCommon/images/abt_product_btn.gif' onmousedown="resizeWindow(payer<%=py %>Hdr,<%=py %>);" class = 'img' >
							<span id='payerSpan<%=py %>Hdr'><fmt:message key="eBL.PayerOne.label" 	bundle="${bl_labels}"	/></span>
						</td>
						<%} %>						
					</tr>
					<tr>
						<td class='COLUMNHEADER' 	style="overflow:hidden; padding-left:0px;width: 3.5%; max-width:45px; "	align="left"	><fmt:message key="eBL.GROSS_AMT.label" 					bundle="${bl_labels}"	/></td>
						<td class='COLUMNHEADER' 	style="overflow:hidden; padding-left:0px;width: 3.5%; max-width:45px; "	align="left"	><fmt:message key="eBL.Discount.label" 					bundle="${bl_labels}"	/></td>						
						<td class='COLUMNHEADER' 	style="overflow:hidden; padding-left:0px;width: 3.5%; max-width:46px; "	align="left"	><fmt:message key="Common.NetAmount.label" 			bundle="${common_labels}"	/></td>
						


		
		<%}%>
		
			<td class='COLUMNHEADER' 	style="width: 3.5%;"	align="left"	id='tdCashTotalHdr'><fmt:message key="eBL.GROSS_AMT.label"	bundle="${bl_labels}"	/></td>
			
			<td class='COLUMNHEADER' 	style="width: 3.5%;"	align="left"	id='tdCashDiscValHdr'><fmt:message key="eBL.Discount.label"	bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	style="width: 3.5%;"	align="left"	id='tdCashNetHdr'><fmt:message key="Common.NetAmount.label" 			bundle="${common_labels}"	/></td>
			
			<%for(int py=1;py<=7;py++){ %>
			<td class='COLUMNHEADER' 	style="width: 3.5%;"	align="left"	id='payer<%=py %>TotalHdr' ><fmt:message key="eBL.GROSS_AMT.label"	bundle="${bl_labels}"	/></td>			
			<td class='COLUMNHEADER' 	style="width: 3.5%;"	align="left"	id='payer<%=py %>DiscValHdr' ><fmt:message key="eBL.Discount.label"	bundle="${bl_labels}"	/></td>
			<td class='COLUMNHEADER' 	style="width: 3.5%;"	align="left"	id='payer<%=py %>DiscNetHdr' ><fmt:message key="Common.NetAmount.label" 			bundle="${common_labels}"	/></td>
			<%} %>			
			</tr>
			</table>
			</div>
			</td>
			</tr>


	<%
	
		String serviceIndKey = "";
		String serviceIndValue = "";
		String priceIndKey = "";
		String priceIndValue = "";
		BillReceiptExclusionDiscount discBean = null;
		int index = 0;
		int sNo = 0;
		System.err.println("Length ->"+serviceDetails);
		for(BillReceiptServiceDetails serviceBean: serviceDetails)
		{
						
			 sNo	  =		index+1;

			//System.out.println("<<<<<<<<<<<<IN getScreenServiceCriteria index>>>>>>>"+index);
			System.out.println("getActGrossAmt="+serviceBean.getActGrossAmt());
			System.out.println("getUpdDiscAmt="+serviceBean.getUpdDiscAmt());
			System.out.println("getAdhocDiscAmt="+serviceBean.getAdhocDiscAmt());
			System.out.println("getGrossAmt="+serviceBean.getGrossAmt());
			System.out.println("getGrossAmtPayer1="+serviceBean.getGrossAmtPayer1());
			System.out.println("getGrossAmtPayer2="+serviceBean.getGrossAmtPayer2());
			System.out.println("getDiscAmt="+serviceBean.getDiscAmt());
			System.out.println("getDiscAmtPayer1="+serviceBean.getDiscAmtPayer1());
			System.out.println("getDiscAmtPayer2="+serviceBean.getDiscAmtPayer2());
			System.out.println("getNetAmt="+serviceBean.getNetAmt());
			System.out.println("getNetAmtPayer1="+serviceBean.getNetAmtPayer1());
			System.out.println("getNetAmtPayer2="+serviceBean.getNetAmtPayer2());
			System.out.println("getTotalGross="+serviceBean.getNetAmt());
			System.out.println("getTotalDisc="+serviceBean.getNetAmtPayer1());
			System.out.println("getTotalNet="+serviceBean.getNetAmtPayer2());
			System.out.println("getAcctSeqNo="+serviceBean.getAcctSeqNo());
			
			
	
	%>
	
			<tr id='resultTr_<%=index%>'>
				<%if("G".equals(groupLineService)){ 
					discBean = discMap.get(serviceBean.getBlngServCode());
					if(discBean == null){
						discBean = new BillReceiptExclusionDiscount();
					}						
				%>		
				<td id='firstMainCol<%=index %>' style='width: 15%; '>
					<div id='fixedCols<%=index %>' >
					<table border="1" cellspacing="0" cellpadding="0" style="width: 100%;">
						<tr id='resultTROfFirst<%=index%>'>														
							<td class="label"      id="serv_grp_code<%=index%>"	class='' style='  cursor:pointer' onclick="tooltip(this,<%=index %>,'entGroup');"	onmouseover="hideToolTip();"	name="serv_grp_code<%=index%>"	>
					 		<div style="width: 140px;">
					 			<%=serviceBean.getPrtGrpHdr()				!=null ? 	serviceBean.getPrtGrpHdr()		: 	"" %> 		
					 			<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=index%>'>		 		
					 		</div>					 				
					 		</td>	
					 		<td  class="label" id="serv_grp_desc<%=index%>"			name="serv_grp_desc<%=index%>">
					 		<div  style="width: 220px;overflow: hidden;">
					 			<%=serviceBean.getPrintGrpHdrDesc()			!=null ? 	serviceBean.getPrintGrpHdrDesc()		: 	"" %>&nbsp;
					 			
					 		</div>
					 		<input type='hidden' name='hdnServGrpDesc<%=index%>' id = 'hdnServGrpDesc<%=index%>' value='<%=serviceBean.getPrintGrpHdrDesc() %>'>
					 			<input type='hidden' name='acctSeqNo<%=index%>' id='acctSeqNo<%=index%>' value='<%=serviceBean.getAcctSeqNo() %>'>
					 		
					 		</td>
						</tr>
					</table>
					</div>
				</td>
				<td id='secondMainCol<%=index %>' style='width: 85%; '>
					<table border="1" cellspacing="0" cellpadding="0"  style="width: 100%;" overflow: auto;" border="1">
						<tr id='resultTROfSecond<%=index%>'>
							<td class="label" 	style="width: 3.5%;text-align: right;  "  id="gross_amt<%=index%>"			name="gross_amt<%=index%>">				<%=serviceBean.getGrossTotal()	 			!=null 	? 	serviceBean.getGrossTotal()		: 	"" %>&nbsp; </td>
							<td class="label"  style="width: 3.5%;text-align: right;"  id="disc_amt<%=index%>"			name="disc_amt<%=index%>">				<%=serviceBean.getDiscTotal() 			!=null 	? 	serviceBean.getDiscTotal()		: 	"" %>&nbsp; </td>							
							<td class="label"  style="width: 3.5%;text-align: right;"  id="net_amt<%=index%>"			name="net_amt<%=index%>">				<%=serviceBean.getNetTotal()	 			!=null 	? 	serviceBean.getNetTotal()		: 	"" %>&nbsp; </td>
															
				<%} %>
				<!-- Cash Columns -->
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='cashTotal<%=index %>' name='cashTotal<%=index %>'><%=serviceBean.getGrossAmt() %></td>					
					<td   style="width: 3.5%;text-align: right; display: none;" nowrap="nowrap" class='label' >
									
					</td>
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='cashAdhocAmount<%=index %>' name='cashAdhocAmount<%=index %>'>
						<%=serviceBean.getDiscAmt() %>
					</td>	
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='cashNet<%=index %>' name='cashNet<%=index %>'><%=serviceBean.getNetAmt() %></td>
					<!-- Cash Columns -->
					
					<!-- payer1 Columns -->
					<td  roundVal='Y' style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer1Total<%=index %>' name='payer1Total<%=index %>'><%=serviceBean.getGrossAmtPayer1()%></td>					
					<td   style="width: 3.5%;text-align: right; display: none;" nowrap="nowrap" class='label' id='payer1DiscType<%=index%>'>
									
					</td>
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer1AdhocAmount<%=index%>' name='payer1AdhocAmount<%=index%>'>
					<%=serviceBean.getDiscAmtPayer1() %>	
					</td>	
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer1Net<%=index %>' name='payer1Net<%=index %>'><%=serviceBean.getNetAmtPayer1()%></td>
					<!-- payer1 Columns -->
					
					<!-- payer2 Columns -->
					<td roundVal='Y'  style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer2Total<%=index %>' name='payer2Total<%=index %>'><%=serviceBean.getGrossAmtPayer2() %></td>					
					<td   style="width: 3.5%;text-align: right; display: none;" nowrap="nowrap" class='label' id='payer2DiscType<%=index%>'>
								
					</td>
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer2AdhocAmount<%=index%>' name='payer2AdhocAmount<%=index%>'>
						<%=serviceBean.getDiscAmtPayer2() %>
					</td>	
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer2Net<%=index %>' name='payer2Net<%=index %>'><%=serviceBean.getNetAmtPayer2() %></td>
					<!-- payer2 Columns -->									
					
					<!-- payer3 Columns -->
					<td roundVal='Y'  style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer3Total<%=index %>' name='payer3Total<%=index %>'><%=serviceBean.getGrossAmtPayer3() %></td>					
					<td   style="width: 3.5%;text-align: right; display: none;" nowrap="nowrap" class='label' id='payer3DiscType<%=index%>'>
									
					</td>
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer3AdhocAmount<%=index%>' name='payer3AdhocAmount<%=index%>'>
					<%=serviceBean.getDiscAmtPayer3() %>
					</td>	
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer3Net<%=index %>' name='payer3Net<%=index %>'><%=serviceBean.getNetAmtPayer3() %></td>
					<!-- payer3 Columns -->		
					
					<!-- payer4 Columns -->
					<td roundVal='Y'  style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer4Total<%=index %>' name='payer4Total<%=index %>'><%=serviceBean.getGrossAmtPayer4() %></td>					
					<td   style="width: 3.5%;text-align: right; display: none;" nowrap="nowrap" class='label' id='payer4DiscType<%=index%>'>
									
					</td>
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer4AdhocAmount<%=index%>'>
					<%=serviceBean.getDiscAmtPayer4() %>
					</td>	
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer4Net<%=index %>' name='payer4Net<%=index %>'><%=serviceBean.getNetAmtPayer4() %></td>
					<!-- payer4 Columns -->		
					
					<!-- payer5 Columns -->
					<td  roundVal='Y' style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer5Total<%=index %>' name='payer5Total<%=index %>'><%=serviceBean.getGrossAmtPayer5() %></td>					
					<td   style="width: 3.5%;text-align: right; display: none;" nowrap="nowrap" class='label' id='payer5DiscType<%=index%>'>
									
					</td>
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer5AdhocAmount<%=index%>'>
					<%=serviceBean.getDiscAmtPayer5() %>
					</td>	
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer5Net<%=index %>' name='payer5Net<%=index %>'><%=serviceBean.getNetAmtPayer5() %></td>
					<!-- payer5 Columns -->	
					
					<!-- payer6 Columns -->
					<td  roundVal='Y' style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer6Total<%=index %>' name='payer6Total<%=index %>'><%=serviceBean.getGrossAmtPayer6() %></td>					
					<td   style="width: 3.5%;text-align: right; display: none;" nowrap="nowrap" class='label' id='payer6DiscType<%=index%>'>
									
					</td>
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer6AdhocAmount<%=index%>'>
					<%=serviceBean.getDiscAmtPayer6() %>
					</td>	
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer6Net<%=index %>' name='payer6Net<%=index %>'><%=serviceBean.getNetAmtPayer6() %></td>
					<!-- payer6 Columns -->	
					
					<!-- payer7 Columns -->
					<td  roundVal='Y' style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer7Total<%=index %>' name='payer7Total<%=index %>'><%=serviceBean.getGrossAmtPayer7() %></td>					
					<td   style="width: 3.5%;text-align: right; display: none;" nowrap="nowrap" class='label' id='payer7DiscType<%=index%>'>
									
					</td>
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer7AdhocAmount<%=index%>'>
					<%=serviceBean.getDiscAmtPayer7() %>
					</td>	
					<td   style="width: 3.5%;text-align: right;" nowrap="nowrap" class='label' id='payer7Net<%=index %>' name='payer7Net<%=index %>'><%=serviceBean.getNetAmtPayer7() %></td>
					<!-- payer7 Columns -->	
								
						</tr>
					</table>
				</td>
					
					
			</tr>
			
			<%
			startIndex++;
			index++;
		}		
			%>
			
	</table>
	

	
<% if((exclDiscList != null) && (index == 0)) {
%>
	<tr>
		<td class = 'button' id='excludeservice'  style="text-align: right;"><a  href="javascript: tooltipforexcludeservice(this,<%=index %>);">Click here to view the excluded services</a>
		</td></tr>
	<%} %>
	
		<input type='hidden' name='totalGroup' id='totalGroup' value='<%=index %>'>
		<input type='hidden' name='prevClicked' id='prevClicked' value="" />
		<input type='hidden' name='queryString' id='queryString' value="<%=queryString %>" />
		<input type='hidden' name='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' value="<%=facilityId%>" >	
		<input type='hidden' name='groupLineService' id='groupLineService' value="<%=groupLineService%>" >	
		<input type='hidden' name='maxPayer' id='maxPayer' value='<%=maxPayer%>'>
		<input type='hidden' name='pkgCount' id='pkgCount' value='<%=responseBean.getGetPackageCount()%>'>
		<input type='hidden' name='serviceLocation' id='serviceLocation' value='<%=serviceLocation%>'>
	<input type='hidden' name='acctSeqNo' id='acctSeqNo' value='<%=acctSeqNo%>'>

		<input type='hidden' name='visitTypeCode' id='visitTypeCode' value='<%=responseBean.getServiceTypeCode()%>'>
		<%BillReceiptSummaryBean summ = responseBean.getSummBean(); %>
		<!-- Summary Related Data -->
		<input type='hidden' name='approx_pyr_amt' id='approx_pyr_amt' value='<%=summ.getApproxPayerAmt() %>'>
		<input type='hidden' name='approx_pat_amt' id='approx_pat_amt' value='<%=summ.getApproxPatAmt() %>'>
		<input type='hidden' name='patient_amt' id='patient_amt' value='<%=summ.getPatAmt() %>'>
		<input type='hidden' name='exemption_amt' id='exemption_amt' value='<%=summ.getExemptionAmt() %>'>
		<input type='hidden' name='deposit_amt' id='deposit_amt' value='<%=summ.getDepositAmt() %>'>
		<input type='hidden' name='summ_net_amt' id='summ_net_amt' value='<%=summ.getNetAmt() %>'>
		<input type='hidden' name='spl_dep_adj_amt' id='spl_dep_adj_amt' value='<%=summ.getSplDepAdjAmt() %>'>
		<input type='hidden' name='slmt_amt' id='slmt_amt' value='<%=summ.getSlmtAmt() %>'>
		<input type='hidden' name='spl_dep_amt' id='spl_dep_amt' value='<%=summ.getSplDepAmt() %>'>
		<input type='hidden' name='available_spl_dep_amt' id='available_spl_dep_amt' value='<%=summ.getAvlSplDepAmt() %>'>
		<input type='hidden' name='adjustable_spl_dep_amt' id='adjustable_spl_dep_amt' value='<%=summ.getAdjSplDepAmt() %>'>
		<input type='hidden' name='balance_spl_dep_amt' id='balance_spl_dep_amt' value='<%=summ.getBalSplDepAmt() %>'>
		<input type='hidden' name='patDepAdj' id='patDepAdj' value='<%=summ.getRefDepAdj() %>'>
		<input type='hidden' name='patDepBal' id='patDepBal' value='<%=summ.getRefDepBal() %>'>
		<input type='hidden' name='patPrepayAdj' id='patPrepayAdj' value='<%=summ.getRefprePayAdj() %>'>
		<input type='hidden' name='patPrepayBal' id='patPrepayBal' value='<%=summ.getRefprePaybal() %>'>
		<input type='hidden' name='depAdjustedYn' id='depAdjustedYn'  value='<%=summ.getDepAjustedYn() %>'>
		<input type='hidden' name='preAdjustedYn' id='preAdjustedYn' value='<%=summ.getPreAjustedYn() %>'>				
		<input type='hidden' name='prevUnBilledAmt' id='prevUnBilledAmt' value='<%=summ.getPrevUnBilledAmt() %>'>
		<input type='hidden' name='prevDepAdjAmt' id='prevDepAdjAmt' value='<%=summ.getPrevDepAdjAmt() %>'>
		<input type='hidden' name='prevPreAdjAmt' id='prevPreAdjAmt' value='<%=summ.getPrevPreAdjAmt() %>'>
		
		<!-- Summary Related Data -->		
		<input type='hidden' name='errorCheck' id='errorCheck' value='<%=responseBean.getErrorCheck()%>'>
		<input type='hidden' name='error' id='error' value='<%=responseBean.getError()%>'>
		<input type='hidden' name='warning' id='warning' value='<%=responseBean.getWarning()%>'>
		<input type='hidden' name='slmtErrorCheck' id='slmtErrorCheck' value=''>
		<input type='hidden' name='slmtError' id='slmtError' value=''>
		<input type='hidden' name='slmtWarning' id='slmtWarning'  value=''>
		<input type='hidden' name='splDepYN' id='splDepYN' value='<%=responseBean.getSplDepYN()%>'>
		<input type='hidden' name='ipBill' id='ipBill' value='<%=ipBill%>'>
		<input type='hidden' name='billGenOpt' id='billGenOpt' value='<%=billGenOpt%>'>
		<input type='hidden' name='billGenType' id='billGenType' value='<%=billGenType%>'>

		<input type='hidden' name='hdnNextSpan' id='hdnNextSpan' value='<%=nextYn %>'>
		<input type='hidden' name='prevSpan' id='prevSpan'  value='<%=prevYn %>'>
		<input type='hidden' name='traverse' id='traverse' value='<%=traversal%>'>
		<input type='hidden' name='fromRcrd' id='fromRcrd' value='<%=startRcrd %>'>
		<input type='hidden' name='toRcrd' id='toRcrd' value='<%=endRcrd %>'>
		<input type='hidden' name='constCount' id='constCount' value='<%=constCount %>'>
		<%
		int hdnIndex = 1;
		for(BillReceiptCustomerDetails custHdn: custDetails){ %>
		<input type='hidden' name='payerPolDesc<%=hdnIndex %>' id='payerPolDesc<%=hdnIndex %>' value="<%=custHdn.getCustCode()%>/<%=custHdn.getPolicyTypeCode() %>" >	
		<%
		hdnIndex++;
		}
		%>
</form>	
	
	<%
	int prtIndex = 1;
	for(BillReceiptCustomerDetails custPrt: custDetails){ %>
	<div name='tooltiplayer<%=prtIndex %>' id='tooltiplayer<%=prtIndex %>' style='position:absolute; width:35%; visibility:hidden; z-index: 150;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'>
					<table id='tooltiptable<%=prtIndex %>' class='contextMenu' width='100%' height='100%' align='center'> 
					<tr style="width: 100%">
						<td colspan="2"  class='LABEL'>
							<span onclick="javascript:hideToolTip(<%=prtIndex %>)">Hide</span>
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Payer
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=replaceNull(custPrt.getCustCode()) %>
						</td> 
					</tr>
					<tr style="width: 100%"> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							Blng Group
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							<%=replaceNull(custPrt.getBlngGrpId()) %>
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							Priority
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							<%=replaceNull(custPrt.getPriority()) %>
						</td> 
					</tr> 
					
					<tr> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Policy Type
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=replaceNull(custPrt.getPolicyTypeCode()) %>
						</td> 

						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Policy No
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=replaceNull(custPrt.getPolicyNo()) %>
						</td> 
					</tr> 
					<tr> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Effective From
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=replaceNull(custPrt.getEffectiveFrom()) %>
						</td> 

						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Effective To
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=replaceNull(custPrt.getEffectiveTo()) %>
						</td> 
					</tr> 
					<tr> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Credit Auth Ref
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=replaceNull(custPrt.getCreditAuthRef()) %>
						</td> 

						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Credit Auth Date
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=replaceNull(custPrt.getCreditAuthDate()) %>
						</td> 
					</tr> 
					</table>
					</td>
					<!-- </td> -->
				</tr>
			</table>
		</div>
	<%
	prtIndex++;
	}
	%>
</body>

<%
//beanId = "BillReceiptResponseBean";
/*String beanName = "eBL.billreceipt.response.BillReceiptResponse";
BillReceiptResponse responseBeanPersist = (BillReceiptResponse) getObjectFromBean(beanId, beanName, session);
if(responseBeanPersist != null){
	responseBeanPersist.setCustList(custList);
}*/
//putObjectInBean(beanId, responseBean, session);
}
catch(Exception e)
{
	System.out.println("<<<<<<<<<<<<<<Exception in AdditionalServicePriceDetails>>>>>>>>>>.jsp::"+e);
}
finally{
	if(conn!=null){
		ConnectionManager.returnConnection(conn);
	}
}
%>
<%!	
private String checkForNull(String inputString)
{
	if (inputString == null) return "";
	if(inputString.equals("null")) return "";
	
	return  inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</html>

