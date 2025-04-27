<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
------------------------------------------------------------------------------------------------------------------------------
1			 V210503			 8707			PMG-IRB-BL-00039			Mohana Priya K
2			 V210510			 8710			PMG-IRB-BL-00042			Mohana Priya K
3			 V210610			 20035			BL-Bill Generation-3T		Mohana Priya K
-->

<%@page import="java.net.URLDecoder"%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="eBL.billreceipt.model.BillReceiptCustomerDetails"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.response.BillReceiptResponse"%>
<%@page import="eBL.billreceipt.model.BillReceiptServiceDetails"%>
<%@page import="eBL.billreceipt.model.BillReceiptExclusionDiscount"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@page import="eBL.placeorder.request.PlaceNewOrderRequest"%>
<%@ 
page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.* " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<style>
	.approved{
		width: 12.5px;
		height: 12.5px;
		background: #52BD15;
	}
	.onHold{
		width: 12.5px;
		height: 12.5px;
		background: #5EF7ED;
	}
	.pending{
		width: 12.5px;
		height: 12.5px;
		background: #F2FA52;
	}
	.sent{
		width: 12.5px;
		height: 12.5px;
		background: #0C1EE8;
	}
	.rejected{
		width: 12.5px;
		height: 12.5px;
		background: #9F9FA1;
	}
	.clarification{
		width: 12.5px;
		height: 12.5px;
		background: #FC9DFC;
	}
	.whiteClass{
		width: 12.5px;
		height: 12.5px;
		background: #FFFFFF;
	}
</style>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="JavaScript" src="../../eBL/js/json2.js"></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script language='javascript' src='../../eBL/js/BLChargePatientServiceLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
var excludedUnChecked = '';
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
	
	$('#nextSpan').click(function(){		
		nextPrevExcludeServices();
		var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
		var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
		
		$(parent.closeWinsow.document).find('#orderDetails').hide();		
		//parent.document.getElementById('parentFrame').rows = '5%,80%,15%';
		parent.document.getElementById('progressFrame').style.hight='5vh';
		parent.document.getElementById('serviceList').style.hight='85vh';
		parent.document.getElementById('closeWinsow').style.hight='15vh';
		
		var url="../../eBL/jsp/BillReceiptExistOrderService.jsp?entServGroup="+$('#servGroupKey').val()+
		"&entGrpLine="+$('#servLineKey').val()+
		"&serviceLocation="+$('#serviceLocation').val()+
		"&groupLineService=D"+
		"&episodeType="+$('#episodeType').val()+
		"&patientId="+$('#patientId').val()+
		"&episodeId="+$('#episodeId').val()+
		"&visitId="+$('#visitId').val()+
		"&ipBill="+$('#ipBill').val()+
		"&billCashBlngServSeparately="+$('#billCashBlngServSeparately').val()+
		"&billGenOpt="+$('#billGenOpt').val()+
		"&billGenType="+$('#billGenType').val()+
		"&fromRcrd="+startFrom+
		"&toRcrd="+endWith+
		"&fromNextOrPrev=Y";

		var pDoc = parent.serviceList.document;
		parent.progressFrame.location.href = "../../eCommon/jsp/process.jsp";
		pDoc.location.href = url;

	});
	$('#previousSpan').click(function(){	
		nextPrevExcludeServices();
		var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
		var endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
		
		$(parent.closeWinsow.document).find('#orderDetails').hide();
		//parent.document.getElementById('parentFrame').rows = '5%,80%,15%';
		parent.document.getElementById('progressFrame').style.hight='5vh';
		parent.document.getElementById('serviceList').style.hight='85vh';
		parent.document.getElementById('closeWinsow').style.hight='15vh';
		
		var url="../../eBL/jsp/BillReceiptExistOrderService.jsp?entServGroup="+$('#servGroupKey').val()+
		"&entGrpLine="+$('#servLineKey').val()+
		"&groupLineService=D"+
		"&serviceLocation="+$('#serviceLocation').val()+
		"&episodeType="+$('#episodeType').val()+
		"&patientId="+$('#patientId').val()+
		"&episodeId="+$('#episodeId').val()+
		"&visitId="+$('#visitId').val()+
		"&ipBill="+$('#ipBill').val()+
		"&billCashBlngServSeparately="+$('#billCashBlngServSeparately').val()+
		"&billGenOpt="+$('#billGenOpt').val()+
		"&billGenType="+$('#billGenType').val()+
		"&fromRcrd="+startFrom+
		"&toRcrd="+endWith+
		"&fromNextOrPrev=Y";
		var pDoc = parent.serviceList.document;
		parent.progressFrame.location.href = "../../eCommon/jsp/process.jsp";
		pDoc.location.href = url;

	});
	
	var allow_service_selection_yn = $(parent.closeWinsow.document).find('#allow_service_selection_yn').val();	
	if(allow_service_selection_yn == 'Y'){		
		$('[id^=serv_grp_chk]').each(function(){
			$(this).attr('disabled',false); 
		});		
	}else{
		$('[id^=serv_grp_chk]').each(function(){
			$(this).attr('disabled',true); 
		});		
	}
	var adhoc_discount_allowed_yn = $(parent.closeWinsow.document).find('#adhoc_discount_allowed_yn').val();
	
	if($(parent.closeWinsow.document).find('#adhoc_discount_allowed_yn').val() == 'N'){

		$('[id^=discType1]').each(function(){
			$(this).attr('disabled',true); 
			$(this).prop('onclick','');
		});		
	}
	if($(parent.closeWinsow.document).find('#adhoc_discount_allowed_yn').val() == 'N'){
		
		var i = 1;
		for( i=1; i<=7;i++ ) {
			$('[id^=payer'+i+'DiscTypes]').each(function(){
				$(this).attr('disabled',true); 
				$(this).prop('onclick','');
			});
		}	
	}
		
	payerHide('D');
	$('#serv').val($('#service_code').val());
	$('td[id^=serv_grp_desc]').each(function(){
		var grpDesc = $(this).text();
		if(grpDesc.length>100){
			$(this).text(grpDesc.substring(0,40) + " (...) ");
			$(this).attr('title',grpDesc);
		}
	});
	
	$('td[id^=serv_line_desc]').each(function(){
		var grpDesc = $(this).text();
		if(grpDesc.length>100){
			$(this).text(grpDesc.substring(0,40) + " (...) ");
			$(this).attr('title',grpDesc);
		}
	});
	
	$('[id^=servColor]').each(function(){
		var color = $(this).val();
		var indx = $(this).attr('data-id');
		if(color == 'GR'){
			$('#spanColor'+indx).addClass('approved');
		}
		else if(color == 'DC'){
			$('#spanColor'+indx).addClass('onHold');
		}
		else if(color == 'YW'){
			$('#spanColor'+indx).addClass('pending');		
		}
		else if(color == 'BL'){
			$('#spanColor'+indx).addClass('sent');
		}
		else if(color == 'GY'){
			$('#spanColor'+indx).addClass('rejected');
		}
		else if(color == 'PK'){
			$('#spanColor'+indx).addClass('clarification');
		}
		else if(color == 'WH'){
			$('#spanColor'+indx).addClass('whiteClass');
		}
	});
	
	var noOfDecimal = $(parent.closeWinsow.document).find('#noOfDecimal').val();
	//groupChangeDecimal('D',$('#maxPayer').val(),noOfDecimal);
	
	calculateDiscNet($('#hdnIndex').val(),$('#maxPayer').val(),noOfDecimal);
	//parent.document.getElementById('parentFrame').rows = '0%,85%,15%';
	parent.document.getElementById('progressFrame').style.hight='0vh';
		parent.document.getElementById('serviceList').style.hight='85vh';
		parent.document.getElementById('closeWinsow').style.hight='15vh';
	parent.progressFrame.location.href = '../../eCommon/html/blank.html';	
});

var headTop = -1;
var FloatHead1;
function processScroll()
	{/*
		if (headTop < 0)
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
		TD.COLUMNHEADER {
 
	background-position:right;
	COLOR: white ;
	background-color:#83AAB4;
	border:0px;
/*	padding-left:3px;*/
	font-family: Verdana;
	font-size: 8pt;
	font-weight:bold;
	border-collapse:collapse; 
}
		</style>
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

	String facilityId	=	"";
	LinkedHashMap	recordServiceDetailsDataMap		=	null;

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

	int cnt = 0; //V210503
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
	String billCashBlngServSeparately = "";
	String serviceLocation="";
	String acctSeqNo="";
	Connection conn = null;
	List<BillReceiptServiceDetails> serviceDetails = new ArrayList<BillReceiptServiceDetails>();
	List<BillReceiptCustomerDetails> custDetails = null;

	String beanId = "BillReceiptExistOrderExclusion" ;
	String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
	BillReceiptExistOrderExclusion exclusionBean = null;

	int maxPayer = 0;
	String loginUser = (String) session.getValue("login_user");
	Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address = p.getProperty("client_ip_address");
	String fromnextOrPrev = request.getParameter("fromNextOrPrev");
try  
{
	sStyle 	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 								= 	(String)session.getAttribute("LOCALE");
	facilityId							=   (String) session.getValue( "facility_id" ) ;
	service_code						=	checkForNull(request.getParameter("serviceCode"));
	service_class						=	checkForNull(request.getParameter("serviceClass"));
	billing_service						=	checkForNull(request.getParameter("billingService"));
	item								=	checkForNull(request.getParameter("item"));
	ent_servGroup						=	checkForNull(request.getParameter("entServGroup"));	
	serviceLocation						=	checkForNull(request.getParameter("serviceLocation"));
	acctSeqNo						=	checkForNull(request.getParameter("acctSeqNo"));
	
	ent_GrpLine							=	checkForNull(request.getParameter("entGrpLine"));
	from_date							=	checkForNull(request.getParameter("fromDate"));
	to_date								=	checkForNull(request.getParameter("toDate"));
	groupLineService					=	checkForNull(request.getParameter("groupLineService"));
	episodeType							=	checkForNull(request.getParameter("episodeType"));
	patientId							=	checkForNull(request.getParameter("patientId"));
	episodeId							=	checkForNull(request.getParameter("episodeId"));
	visitId								=	checkForNull(request.getParameter("visitId"));
	locale								=	(String) session.getValue("LOCALE");
	billCashBlngServSeparately			=   checkForNull(request.getParameter("billCashBlngServSeparately"));
	String ipBill = checkForNull(request.getParameter("ipBill"));
	String billGenOpt = checkForNull(request.getParameter("billGenOpt"));
	String billGenType = checkForNull(request.getParameter("billGenType"));
	
	//Retrieving Exclusion for the Service Group
	exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
	Set<String> serviceSet = null;
	HashMap<String,BillReceiptExclusionDiscount> discMap = null;
	if("Y".equals(fromnextOrPrev)){
		discMap = exclusionBean.getInterDiscount();
		serviceSet = exclusionBean.getInterExclusion();
	}
	else{
		discMap = exclusionBean.getDiscountMap();
		serviceSet = exclusionBean.getServiceExclusion();
	}
	

	if(serviceSet == null){
		serviceSet = new HashSet<String>();
	}
	
	if(discMap == null){
		discMap = new HashMap<String,BillReceiptExclusionDiscount>();
	}
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
	requestBean.setServOrPanel(serviceLocation);
	requestBean.setAcctSeqNo(acctSeqNo);
	requestBean.setFromDate(from_date);
	requestBean.setToDate(to_date);
	requestBean.setGroupLineService(groupLineService);
	requestBean.setEpisodeType(episodeType);
	requestBean.setPatientId(patientId);
	requestBean.setEpisodeId(episodeId);
	requestBean.setVisitId(visitId);
	requestBean.setLocale(locale);
	requestBean.setIpBill(ipBill);
	requestBean.setLoginUser(loginUser);
	requestBean.setClientIpAddress(client_ip_address);
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
	System.err.println("Before Calling DAO");
	responseBean =	billreceiptBC.getServiceDetailsData(requestBean,conn);		
	serviceDetails = responseBean.getServiceList();
	custDetails = responseBean.getCustList();
	System.err.println("After Calling DAO");
	cnt = serviceDetails.size();  //V210503
	
	if(custDetails != null){
		maxPayer = custDetails.size();
	}
	
	totalRecord = responseBean.getTotalRecordCount();
	//Getting Service Group
	/*HashMap<String,String> serviceLocn = new HashMap<String,String>();
	BillReceiptRequest brRequest = new BillReceiptRequest();
	brRequest.setLocale(locale);
	brRequest.setFacilityId(facilityId);
	serviceLocn = billreceiptBC.getServiceLocation(brRequest);
	request.setAttribute("serviceLocn", serviceLocn);*/
	//Getting Service Group
	
	HashMap<String,String> blngServGroup = new HashMap<String,String>();
	PlaceOrderBC placeOrderBC = new PlaceOrderBC();
	blngServGroup = placeOrderBC.getBlngServGroup(locale);
	request.setAttribute("blngServGroup", blngServGroup);
	
%>
<body onScroll="processScroll();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" >
	<form id="billReceiptServiceList" name="bLChargePatientServicePriceDetails">	

			<% if(!(startRcrd<=1)){
					prevYn = "Y";
					traversal = "Y";
				}
		
				if ( !( (startRcrd+constCount) > totalRecord ) ){
					nextYn = "Y";
					traversal = "Y";
				}
				%>
	
	<table style="width: 99%"  border="0" cellspacing="0" cellpadding="0"   id="panel_categories_header_table" name="panel_categories_header_table" >	 
	<div id="tableContainer">
		<thead>
		<tr style="background-color: white; border: none;" id='trProgress'>
			<td >
				<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer; cursor:pointer ">
					<span id='previousSpan'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></span>
				</span>
				&nbsp;	
				<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer; cursor:pointer ">
					<span id='nextSpan' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></span>
				</span>
			</td>		
			<td>
			</td>			
		</tr>	
		<tr >	
			<td id='firstMainColHdr' width="13%">
				<div id='fixedColsHdr1' style="z-index: 100; margin-top: 0px; left:0px; position: relative;">
				<table style="max-height: 75px; min-height: 75px; height: 75px; width: 100%"  border="1" cellspacing="0" cellpadding="0" >
					<tr style="height: 20px;">
						<td class='COLUMNHEADER'  colspan='3'>&nbsp;</td>
					</tr>
					<tr>
						<td class='COLUMNHEADER'  style="padding-left:0px;width: 60px;" align="left"	><fmt:message key="Common.Exclude.label" 					bundle="${common_labels}"	/>/ Select All<input type='checkbox' name="selectall" id="selectall" onclick="selectallexclude(<%=cnt%>);" ></td> <!-- V210503-->
						<td class='COLUMNHEADER'  style="padding-left:0px;width: 110px;"	align="left"	><fmt:message key="eBL.ServiceHeading.label" 	bundle="${bl_labels}"	/></td> <!--V210610-->
						<td class='COLUMNHEADER'  style="padding-left:0px;width: 150px;"		align="left"	><fmt:message key="eBL.ServiceDescription.label" 	bundle="${bl_labels}"	/></td>	<!--V210610-->			
					</tr>
				</table>
				</div>
			</td>
			<td id='secondMainColHdr' width="87%">
				<div id='fixedHeaderTop' >
				<table border="1" cellspacing="0" cellpadding="0" style="width:100%; max-height: 75px; min-height: 75px; height: 75px;">
					<tr style="height: 20px;">
						<td class='COLUMNHEADER' style='padding-left:0px; ' colspan='4' >&nbsp;</td>
						<td class='COLUMNHEADER' style='padding-left:0px; ' colspan='4'	align="center"	id='tdCashHdr'><fmt:message key="eBL.CASH.label" 	bundle="${bl_labels}"	/></td>
						<%for(int py=1;py<=7;py++){ %>
							<td class='COLUMNHEADER' style='padding-left:0px; ' colspan='4'	align="center" id='payer<%=py %>Hdr' >
							<img src='../../eCommon/images/abt_product_btn.gif' onmousedown="resizeWindow(payer<%=py %>Hdr,<%=py %>);" class = 'img' >
							<span id='payerSpan<%=py %>Hdr'><fmt:message key="eBL.PayerOne.label" 	bundle="${bl_labels}"	/></span>
							</td>
						<%} %>														
					</tr>
					<tr  style="height: 20px;">
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:4.45%"	align="left"	><fmt:message bundle="${common_labels }" key="Common.Date/Time.label"></fmt:message></td>
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%" align="left"	><fmt:message key="eBL.GROSS_AMT.label" 					bundle="${bl_labels}"	/></td>
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%" align="left"	><fmt:message key="eBL.Discount.label" 				bundle="${bl_labels}"	/></td>						
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	><fmt:message key="Common.NetAmount.label" 			bundle="${common_labels }"	/></td>
						  
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	id='tdCashTotalHdr'><fmt:message key="eBL.GROSS_AMT.label"	bundle="${bl_labels}"	/></td>						
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	id='tdCashDiscValHdr'><fmt:message key="eBL.Discount.label"	bundle="${bl_labels}"	/></td>
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	id='tdCashDiscLink'>&nbsp;</td>
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	id='tdCashNetHdr'><fmt:message key="Common.NetAmount.label" 			bundle="${common_labels}"	/></td>
						<%for(int py=1;py<=7;py++){ %>
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	id='payer<%=py %>TotalHdr' ><fmt:message key="eBL.GROSS_AMT.label"	bundle="${bl_labels}"	/></td>						
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	id='payer<%=py %>DiscValHdr' ><fmt:message key="eBL.Discount.label"	bundle="${bl_labels}"	/></td>
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	id='payer<%=py %>DscTypeHdr'>&nbsp;</td>
						<td class='COLUMNHEADER' 	style="padding-left:0px;width:2.73%"	align="left"	id='payer<%=py %>DiscNetHdr' ><fmt:message key="Common.NetAmount.label" 			bundle="${common_labels}"	/></td>
						<%}%>							
					</tr>
				</table>
				</div>
			</td>			
		</tr>
	</thead>	
	<tbody>		
<%	
	String excludeKey = "";
	String serviceIndKey = "";
	String serviceIndValue = "";
	String priceIndKey = "";
	String priceIndValue = "";
	String combo = "";
	BillReceiptExclusionDiscount discBean = null;
	int sNo = 0;
	int index = 0;
	System.err.println("serviceDetails"+serviceDetails.size());
	for(BillReceiptServiceDetails serviceBean: serviceDetails)
	{			
		 sNo	  =		index+1;

		excludeKey = 	serviceBean.getBlngServCode() + ":::"+serviceBean.getTrxDocRef()+":::"+serviceBean.getTrxDoceRefLineNo()+":::"+serviceBean.getTrxDocRefSeqNo();
		combo = serviceBean.getBlngServCode() + ":::"+serviceBean.getTrxDocRef()+":::"+serviceBean.getTrxDoceRefLineNo()+":::";
		//Cash
		discBean = discMap.get(combo+serviceBean.getTrxDocRefSeqNo());
		if(discBean != null){
			System.err.println(discBean.getNetAmt());
			serviceBean.setNetAmt(discBean.getNetAmt());
			serviceBean.setDiscAmt(discBean.getDiscAmt());
		}
		//Payer 1
		discBean = discMap.get(combo+serviceBean.getTrxDocRefSeqNoP1());
		if(discBean != null){
			serviceBean.setNetAmtPayer1(discBean.getNetAmt());
			serviceBean.setDiscAmtPayer1(discBean.getDiscAmt());
		}
		//Payer 2
		discBean = discMap.get(combo+serviceBean.getTrxDocRefSeqNoP2());
		if(discBean != null){
			serviceBean.setNetAmtPayer2(discBean.getNetAmt());
			serviceBean.setDiscAmtPayer2(discBean.getDiscAmt());
		}
		
		//Payer 3
		discBean = discMap.get(combo+serviceBean.getTrxDocRefSeqNoP3());
		if(discBean != null){
			serviceBean.setNetAmtPayer3(discBean.getNetAmt());
			serviceBean.setDiscAmtPayer3(discBean.getDiscAmt());
		}
		
		//Payer 4
		discBean = discMap.get(combo+serviceBean.getTrxDocRefSeqNoP4());
		if(discBean != null){
			serviceBean.setNetAmtPayer4(discBean.getNetAmt());
			serviceBean.setDiscAmtPayer4(discBean.getDiscAmt());
		}
		
		//Payer 5
		discBean = discMap.get(combo+serviceBean.getTrxDocRefSeqNoP5());
		if(discBean != null){
			serviceBean.setNetAmtPayer5(discBean.getNetAmt());
			serviceBean.setDiscAmtPayer5(discBean.getDiscAmt());
		}
		
		//Payer 6
		discBean = discMap.get(combo+serviceBean.getTrxDocRefSeqNoP6());
		if(discBean != null){
			serviceBean.setNetAmtPayer6(discBean.getNetAmt());
			serviceBean.setDiscAmtPayer6(discBean.getDiscAmt());
		}
		
		//Payer 7
		discBean = discMap.get(combo+serviceBean.getTrxDocRefSeqNoP7());
		if(discBean != null){
			serviceBean.setNetAmtPayer7(discBean.getNetAmt());
			serviceBean.setDiscAmtPayer7(discBean.getDiscAmt());
		}
%>
	
			<tr id='resultTr_<%=index%>'>
				<td id='firstMainCol<%=index %>' width="13%">
				<!-- <div id='fixedCols<%=index %>' style="z-index: 100; margin-top: 0px; position: relative;">
					<table border="1" style="width: 100%;"> --><!-- Commented V210510 -->
					<table style="width: 100%; z-index: 100;" border="1"> <!-- V210510 -->
						<tr>
							<td class='label'   >
							<div style="width: 50px;">							
							<input type='checkbox' id='serv_grp_chk<%=index%>' name='serv_grp_chk<%=index%>' onclick="chkExcludeServValidate(<%=index%>);" <%=serviceSet.contains(excludeKey)?"checked":"" %>>
							<span id='spanColor<%=index%>'>&nbsp;</span>
							<input type='hidden' name='servColor<%=index%>' id='servColor<%=index%>' data-id='<%=index%>' value='<%=serviceBean.getColorIndicator()%>'>
							</div>
							</td>
							<td     id="serv_grp_code<%=index%>"	class='label' 	name="serv_grp_code<%=index%>"	style='cursor:pointer' onmouseover="showOrderDetails(this,'<%=index%>');" onmouseout="hideOrderToolTip('<%=index%>');">
							<div style="width: 100px;">
								 <%=serviceBean.getBlngServCode()					!=null ? 	serviceBean.getBlngServCode()		: 	"" %> 	
								 <img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=index%>'>	
								 	<input type='hidden' name='trxDocRef<%=index%>' id='trxDocRef<%=index%>'	value='<%=serviceBean.getTrxDocRef() %>'>
								 	<input type='hidden' name='trxDocRefLineNum<%=index%>' id='trxDocRefLineNum<%=index%>'	value='<%=serviceBean.getTrxDoceRefLineNo() %>'>
								 	<input type='hidden' name='trxDocRefSeqNumC<%=index%>' id='trxDocRefSeqNumC<%=index%>'	value='<%=serviceBean.getTrxDocRefSeqNo() %>'>					 	
								 	<input type='hidden' name='serviceItemCode<%=index%>' id='serviceItemCode<%=index%>'	value='<%=serviceBean.getServItemCode() %>'>
								 	<input type='hidden' name='serviceItemDesc<%=index%>' id='serviceItemDesc<%=index%>'	value='<%=serviceBean.getServItemDesc() %>'>
								 	<input type='hidden' name='moduleId<%=index%>' id='moduleId<%=index%>'	value='<%=serviceBean.getModuleId() %>'>
								 	<input type='hidden' name='trxDocRefSeqNumP1<%=index %>' id='trxDocRefSeqNumP1<%=index %>' value='<%=serviceBean.getTrxDocRefSeqNoP1() %>'>
								 	<input type='hidden' name='trxDocRefSeqNumP2<%=index %>' id='trxDocRefSeqNumP2<%=index %>' value='<%=serviceBean.getTrxDocRefSeqNoP2() %>'>
								 	<input type='hidden' name='trxDocRefSeqNumP3<%=index %>' id='trxDocRefSeqNumP3<%=index %>' value='<%=serviceBean.getTrxDocRefSeqNoP3() %>'>
								 	<input type='hidden' name='trxDocRefSeqNumP4<%=index %>' id='trxDocRefSeqNumP4<%=index %>' value='<%=serviceBean.getTrxDocRefSeqNoP4() %>'>
								 	<input type='hidden' name='trxDocRefSeqNumP5<%=index %>' id='trxDocRefSeqNumP5<%=index %>' value='<%=serviceBean.getTrxDocRefSeqNoP5() %>'>								 	
								 	<input type='hidden' name='trxDocRefSeqNumP6<%=index %>' id='trxDocRefSeqNumP6<%=index %>' value='<%=serviceBean.getTrxDocRefSeqNoP6() %>'>
								 	<input type='hidden' name='trxDocRefSeqNumP7<%=index %>' id='trxDocRefSeqNumP7<%=index %>' value='<%=serviceBean.getTrxDocRefSeqNoP7() %>'>
								 	<input type='hidden' name='orderQty<%=index %>' id='orderQty<%=index %>' value='<%=serviceBean.getQuantity() %>'>
								 	<input type='hidden' name='orderNo<%=index %>' id='orderNo<%=index %>' value='<%=serviceBean.getOrderNo() %>'>
								 	<input type='hidden' name='physicianId<%=index %>' id='physicianId<%=index %>' value='<%=serviceBean.getPhysician() %>'>
								 	<input type='hidden' name='servDept<%=index %>' id='servDept<%=index %>' value='<%=serviceBean.getServiceDept() %>'>
							</div>
							</td>	
							<td class="label"   id="serv_grp_desc<%=index%>"			name="serv_grp_desc<%=index%>">	
							<div style="width: 150px; overflow: hidden;" >
								<%= checkForNull(serviceBean.getPrintGrpLineDesc()) %>&nbsp;
							</div>
							</td>
						</tr>   
					</table>
					<!-- </div> --><!-- Commented V210510 -->
					
			</td>
			<td id='secondMainCol<%=index %>' width="87%">
				<table style="width: 99%; " border="1">
					<tr>
						<td class="label"  style="width: 1.4%"   id="chargeDateTime<%=index%>"	nowrap="nowrap"		name="chargeDateTime<%=index%>">				
							<div style="overflow: hidden;">
							<%=checkForNull(serviceBean.getServiceDate()) %>
							</div>
						</td>				 
						
						<td class="label" 	style="width: 3%;text-align: right;"  id="gross_amt<%=index%>"			name="gross_amt<%=index%>">	<%=serviceBean.getGrossTotal()%> </td>
						<td class="label"  style="width: 3.5%;text-align: right;"  id="disc_amt<%=index%>"			name="disc_amt<%=index%>"><%=serviceBean.getDiscTotal() %> </td>						
						<td class="label"  style="width: 3%;text-align: right;" id="net_amt<%=index%>"			name="net_amt<%=index%>">				<%=serviceBean.getNetTotal()%>&nbsp; </td>						
						
						<!-- Cash Columns -->
						<td   style="width: 3%;text-align: right;" nowrap="nowrap" class='label' id='cashTotal<%=index %>' name='cashTotal<%=index %>'><%=serviceBean.getGrossAmt() %></td>					
						<td   style="width: 3.4%;text-align: right;" nowrap="nowrap" class='label' id='cashDisc<%=index %>'>
							<%=serviceBean.getDiscAmt() %> 							</td>
						<td   style="width: 2%;text-align: right;" nowrap="nowrap" class='label' id='discType<%=index%>'>
						<span  id='discType1<%=index%>' style="color: blue;" onclick="javascript:captureDiscount('C','<%=index%>')">Discount</span>
						</td>	
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='cashNet<%=index %>' name='cashNet<%=index %>'><%=serviceBean.getNetAmt() %></td>
						<!-- Cash Columns -->
						
						<!-- payer1 Columns -->
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer1Total<%=index %>' name='payer1Total<%=index %>'><%=serviceBean.getGrossAmtPayer1()%></td>					
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer1Disc<%=index %>'>
							<%=serviceBean.getDiscAmtPayer1() %> 							</td>
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer1DiscType<%=index%>'>
						<span  id='payer1DiscTypes<%=index%> 'style="color: blue;" onclick="javascript:captureDiscount('P1','<%=index%>')">Discount</span>
						</td>	
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer1Net<%=index %>' name='payer1Net<%=index %>'><%=serviceBean.getNetAmtPayer1()%></td>
						<!-- payer1 Columns -->
						
						<!-- payer2 Columns -->
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer2Total<%=index %>' name='payer2Total<%=index %>'><%=serviceBean.getGrossAmtPayer2() %></td>					
						<td   roundVal='Y' style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer2Disc<%=index %>'>
							<%=serviceBean.getDiscAmtPayer2() %>						</td>
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer2DiscType<%=index%>'>
						<span  id='payer2DiscTypes<%=index%> 'style="color: blue;" onclick="javascript:captureDiscount('P2','<%=index%>')">Discount</span>
						</td>	
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer2Net<%=index %>' name='payer2Net<%=index %>'><%=serviceBean.getNetAmtPayer2() %></td>
						<!-- payer2 Columns -->									
						
						<!-- payer3 Columns -->
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer3Total<%=index %>' name='payer3Total<%=index %>'><%=serviceBean.getGrossAmtPayer3() %></td>					
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer3Disc<%=index %>'>
							<%=serviceBean.getDiscAmtPayer3() %> 							</td>
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer3DiscType<%=index%>'>
						<span id='payer3DiscTypes<%=index%> ' style="color: blue;" onclick="javascript:captureDiscount('P3','<%=index%>')">Discount</span>
						</td>	
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer3Net<%=index %>' name='payer3Net<%=index %>'><%=serviceBean.getNetAmtPayer3() %></td>
						<!-- payer3 Columns -->		
						
						<!-- payer4 Columns -->
						<td   roundVal='Y' style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer4Total<%=index %>' name='payer4Total<%=index %>'><%=serviceBean.getGrossAmtPayer4() %></td>					
						<td   roundVal='Y' style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer4Disc<%=index %>'>
							<%=serviceBean.getDiscAmtPayer4() %>							</td>
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer4DiscType<%=index%>'>
						<span id='payer4DiscTypes<%=index%> ' style="color: blue;" onclick="javascript:captureDiscount('P4','<%=index%>')">Discount</span>
						</td>	
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer4Net<%=index %>' name='payer4Net<%=index %>'><%=serviceBean.getNetAmtPayer4() %></td>
						<!-- payer4 Columns -->		
						
						<!-- payer5 Columns -->
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer5Total<%=index %>' name='payer5Total<%=index %>'><%=serviceBean.getGrossAmtPayer5() %></td>					
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer5Disc<%=index %>'>
							<%=serviceBean.getDiscAmtPayer5() %>								
						</td>
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer5DiscType<%=index%>'>
						<span  id='payer5DiscTypes<%=index%>' style="color: blue;" onclick="javascript:captureDiscount('P5','<%=index%>')">Discount</span>
						</td>	
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer5Net<%=index %>' name='payer5Net<%=index %>'><%=serviceBean.getNetAmtPayer5() %></td>
						<!-- payer5 Columns -->	
						
						<!-- payer6 Columns -->
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer6Total<%=index %>' name='payer6Total<%=index %>'><%=serviceBean.getGrossAmtPayer6() %></td>					
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer6Disc<%=index %>'>
							<%=serviceBean.getDiscAmtPayer6() %>								
						</td>
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer6DiscType<%=index%>'>
						<span  id='payer6DiscTypes<%=index%>' style="color: blue;" onclick="javascript:captureDiscount('P6','<%=index%>')">Discount</span>
						</td>	
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer6Net<%=index %>' name='payer6Net<%=index %>'><%=serviceBean.getNetAmtPayer6() %></td>
						<!-- payer6 Columns -->	
						
						<!-- payer7 Columns -->
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer7Total<%=index %>' name='payer7Total<%=index %>'><%=serviceBean.getGrossAmtPayer7() %></td>					
						<td  roundVal='Y'  style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer7Disc<%=index %>'>
							<%=serviceBean.getDiscAmtPayer7() %>								
						</td>
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer7DiscType<%=index%>'>
						<span id='payer7DiscTypes<%=index%>' style="color: blue;" onclick="javascript:captureDiscount('P7','<%=index%>')">Discount</span>
						</td>	
						<td   style="width: 2.73%;text-align: right;" nowrap="nowrap" class='label' id='payer7Net<%=index %>' name='payer7Net<%=index %>'><%=serviceBean.getNetAmtPayer7() %></td>
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
	
	<input type='hidden' name='prevClicked' id='prevClicked' id='prevClicked' value="" />
	<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale%>" >
	<input type= hidden name="facility_id" id="facility_id" id='facility_id'  value="<%=facilityId %>">
	<input type='hidden' name='totalService' id='totalService' id='totalService' value="<%=sNo %>" >		
	<input type='hidden' name='servGroupKey' id='servGroupKey' id='servGroupKey' value="<%=ent_servGroup %>" >
	<input type='hidden' name='serviceLocation' id='serviceLocation' id='serviceLocation' value="<%=serviceLocation %>" >				
	<input type='hidden' name='acctSeqNo' id='acctSeqNo' id='acctSeqNo' value="<%=acctSeqNo %>" >
	<input type='hidden' name='servLineKey' id='servLineKey' id='servLineKey' value="<%=ent_GrpLine %>" >
	<input type='hidden' name='ipBill' id='ipBill' id='ipBill' value="<%=ipBill %>" >
	<input type='hidden' name='maxPayer' id='maxPayer' id='maxPayer' value='<%=maxPayer%>'>
	<input type='hidden' name='hdnIndex' id='hdnIndex' id='hdnIndex' value='<%=index%>'>		
	
	<input type= 'hidden' name="episodeType" id="episodeType" id='episodeType'  value="<%=episodeType %>">
	<input type= 'hidden' name="patientId" id="patientId" id='patientId'  value="<%=patientId %>">
	<input type= 'hidden' name="episodeId" id="episodeId" id='episodeId'  value="<%=episodeId %>">
	<input type= 'hidden' name="visitId" id="visitId" id='visitId'  value="<%=visitId %>">		
	<input type='hidden' name='service_code' id='service_code' id='service_code' value='<%=service_code %>'>
	<input type='hidden' name='prevReasonCode' id='prevReasonCode' id='prevReasonCode' value='<%=service_code %>'>
	<input type='hidden' name='prevReasonDesc' id='prevReasonDesc' id='prevReasonDesc' value='<%=service_code %>'>
	<input type='hidden' name = 'billCashBlngServSeparately' id = 'billCashBlngServSeparately' value='<%=billCashBlngServSeparately %>'>
	<input type='hidden' name='billGenOpt' id='billGenOpt' id='billGenOpt' value='<%=billGenOpt%>'>
	<input type='hidden' name='billGenType' id='billGenType' id='billGenType' value='<%=billGenType%>'>
	
	<input type='hidden' name='hdnNextSpan' id='hdnNextSpan' id='hdnNextSpan' value='<%=nextYn %>'>
	<input type='hidden' name='prevSpan' id='prevSpan' id='prevSpan' value='<%=prevYn %>'>
	<input type='hidden' name='traverse' id='traverse' id='traverse' value='<%=traversal%>'>
	<input type='hidden' name='fromRcrd' id='fromRcrd' id='fromRcrd' value='<%=startRcrd %>'>
	<input type='hidden' name='toRcrd' id='toRcrd' id='toRcrd' value='<%=endRcrd %>'>
	<input type='hidden' name='constCount' id='constCount' id='constCount' value='<%=constCount %>'>
	<%
		int custInd = 1;
		for(BillReceiptCustomerDetails cust:custDetails){
		%>
			<input type='hidden' name='payerCode<%=custInd %>' id='payerCode<%=custInd %>' value='<%=cust.getCustCode() %>'>			
		<%	
			custInd++;
		}
	%>	
</form>	
<%
	int prtIndex = 1;
	for(BillReceiptCustomerDetails custPrt: custDetails){ %>
	<div name='tooltiplayer<%=prtIndex %>' id='tooltiplayer<%=prtIndex %>' style='position:absolute; width:35%;  z-index: 150; visibility: hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center' style="background-color: #d9d9d9">
				<tr>
					<td width='100%' id='t'>
					<table id='tooltiptable<%=prtIndex %>' class='contextMenu' width='100%' height='100%' align='center' style="background-color: #d9d9d9"> 
					<tr style="width: 100%">
						<td colspan="2"  class='LABEL'>
							<span onclick="javascript:hideToolTip(<%=prtIndex %>)">Hide</span>
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Payer
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=checkForNull(custPrt.getCustCode()) %>
						</td> 
					</tr>
					<tr style="width: 100%"> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							Blng Group
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							<%=checkForNull(custPrt.getBlngGrpId()) %>
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							Priority
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							<%=checkForNull(custPrt.getPriority()) %>
						</td> 
					</tr> 
					
					<tr> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Policy Type
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=checkForNull(custPrt.getPolicyTypeCode()) %>
						</td> 

						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Policy No
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=checkForNull(custPrt.getPolicyNo()) %>
						</td> 
					</tr> 
					<tr> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Effective From
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=checkForNull(custPrt.getEffectiveFrom()) %>
						</td> 

						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Effective To
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=checkForNull(custPrt.getEffectiveTo()) %>
						</td> 
					</tr> 
					<tr> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Credit Auth Ref
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=checkForNull(custPrt.getCreditAuthRef()) %>
						</td> 

						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						Credit Auth Date
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<%=checkForNull(custPrt.getCreditAuthDate()) %>
						</td> 
					</tr> 
					</table>
					</td>
					<!-- </td> -->
				</tr>
			</table>
		</div>
	<input type='hidden' name='payerPolDesc<%=prtIndex %>' id='payerPolDesc<%=prtIndex %>' value="<%=custPrt.getCustCode()%>/<%=custPrt.getPolicyTypeCode() %>" >
	<%
	prtIndex++;
	}
	%>
	
	<!-- <div name='divtooltipServ' id='divtooltipServ' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div> -->
	<div name='divtooltipServ1' id='divtooltipServ1' style='position:absolute; width:35%;  z-index: 150; visibility: hidden;' bgcolor='blue'>
			<table id='tooltipServ' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='tServ'>
					<table id='tooltiptable' class='contextMenu' width='100%' height='100%' align='center' style="background-color: #d9d9d9"> 
					<tr style="width: 100%">
						<td width="25%;"  class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							<strong>Order No</strong>
						</td> 
						<td width="25%;" id='tdOrderNo' class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						<strong>Quantity</strong>
						</td> 
						<td width="25%;" id='tdQty' class = 'contextMenuItem' style='cursor:pointer'  nowrap >
						
						</td> 
					</tr>
					<tr style="width: 100%"> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							<strong>Ordering Physician</strong>
						</td> 
						<td width="25%;" id='tdPhysician' class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							
						</td> 
						<td width="25%;" class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							<strong>Service Dept</strong>
						</td> 
						<td width="25%;" id='tdServDept' class = 'contextMenuItem' style='cursor:pointer'  nowrap >
							
						</td> 
					</tr> 
					
					</table>
					</td>
					<!-- </td> -->
				</tr>
			</table>
		</div>
	</body>
</tbody>	
	</div>
	
<%
	}
	catch(Exception e)
	{
		System.out.println("<<<<<<<<<<<<<<Exception in BillReceiptExistOrderService.jsp::"+e);
		e.printStackTrace();
	}
	finally{
		if(conn!=null){
			ConnectionManager.returnConnection(conn);
		}
	}
%>
<%!	
	private String checkForNull(String input)
	{
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	private String decodeParam(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		else{
			input = URLDecoder.decode(input);
		}
		return input;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</html>

