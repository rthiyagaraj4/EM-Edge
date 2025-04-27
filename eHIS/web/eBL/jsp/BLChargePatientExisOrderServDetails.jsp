<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eBL.placeorder.model.BLChargePatientServiceDetailsBean"%>
<%@page import="eBL.placeorder.response.PlaceNewOrderResponse"%>
<%@page import="eBL.placeorder.request.PlaceNewOrderRequest"%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@page import="webbeans.op.CurrencyFormat"%> 
<%@page import="org.apache.commons.codec.binary.Base64"%>
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

	private String qtydecimal(String input)
	{
		CurrencyFormat cf1 = new CurrencyFormat();		
		input = cf1.formatCurrency(input,2);  
		return input;
	}
%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facilityId	= (String) session.getValue( "facility_id" ) ;
	
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
<script language="JavaScript" src="../../eBL/js/BLChargePatient.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="JavaScript" src="../../eBL/js/json2.js"></script>
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
	
	$('#nextSpan').click(function(){
		var lastIndex = $('#panel_categories_header_table tr:last').attr('data-id');
		var totSelected = 0;
		for(i=0;i<=lastIndex;i++){
			if($('#chk_blng_serv'+i).prop("checked")){
				totSelected = parseInt(totSelected) + 1; 
			}
		}
		if(totSelected > 0){
			var con = confirm('Do you want to continue. Selections will be lost?');
			if(!con){
				return false;
			}
		}
		var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
		var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
		loadNextPrev(startFrom,endWith);
	});
	
	$('#previousSpan').click(function(){
		var lastIndex = $('#panel_categories_header_table tr:last').attr('data-id');
		var totSelected = 0;
		for(i=0;i<=lastIndex;i++){
			if($('#chk_blng_serv'+i).prop("checked")){
				totSelected = parseInt(totSelected) + 1; 
			}
		}
		if(totSelected > 0){
			var con = confirm('Do you want to continue. Selections will be lost?');
			if(!con){
				return false;
			}
		}
		var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
		var endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
		loadNextPrev(startFrom,endWith);
	});
	
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
	
	$('[id^=adhoc_disc]').each(function(){
		$(this).hide();
	});
	
	var chargeLogicYn = '';
	var noOfDecimals = '';
	if($('#hdnReSize').val() == 'UP' || $('#hdnReSize').val() == 'UC'){
		chargeLogicYn = $(parent.BillReceiptTab.document).find('#chargeLogicYN').val();
		noOfDecimals = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	}
	else{
		chargeLogicYn = $(parent.BLChargePatientEncounterTabPage.document).find('#chargeLogicYN').val();
		noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val();
	}
	
	$('[id^=labelTrDoc_]').each(function(){
		var indx = $(this).attr('data-id');
		if(chargeLogicYn == 'Y'){
			$(this).text($('#primKeyMain'+indx).val());
		}
		else{
			$(this).text($('#trxDocRef'+indx).val());
		}
	})
	
	
	if($('#hdnType').val() == 'D'){
		var pVal = $('#processed').val();
		if(pVal == 'P'){
			$('#spanCancel').show();
			$('#spanProcess').hide();	
			$('#spanConfirm').show();
		}
		else if(pVal == 'UP'){
			if($('#hdnReSize').val() == 'UP'){
				$('#spanCancel').hide();
			}
			else{
				$('#spanCancel').show();
			}			
			$('#spanProcess').show();	
			$('#spanConfirm').hide();
		}
		else if(pVal == 'UC'){
			$('#spanCancel').show();
			$('#spanProcess').hide();	
			$('#spanConfirm').show();
		}
	}
	
	/*Newlu Added for Bill Generation*/
	if($('#hdnReSize').val() == 'UC'){
		$('#selAllChk').hide();
		$('[id^=chk_blng_serv]').each(function(){
			$(this).hide();
		});
		$('#selectAllSpan').text('');
	}
	//alert("noOfDecimals "+noOfDecimals);
	$('[id^=gross_amt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	$('[id^=disc_amt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	$('[id^=adhoc_disc_amt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	$('[id^=net_amt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	$('[id^=txtRate]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	
	$('[id^=spTotalAmt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
});
async function captureRemarks(indx){
//alert("inside 1 247");
	var dialogHeight= "30vh" ;
    var dialogWidth      = "30vw" ;
    var dialogTop = "200" ;
    var center = "1" ;                                                                                              
    var status="no";
    var features  = "overflow:auto; scrollbars:no; dialogHeight:"+dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments = "" ;    
	var remarks = $('#remarks'+indx).val();
    var retVal = await window.showModalDialog("../../eBL/jsp/BLCaptureRemarks.jsp?remarks="+encodeURIComponent(remarks),arguments,features);   
    if(retVal != undefined){
    	$('#remarks'+indx).val(retVal);
    }

}
function loadNextPrev(startFrom,endWith){
	document.location.href = 'BLChargePatientExisOrderServDetails.jsp?serviceCode='+$('#serviceCode').val()+	
	'&serviceClass='+$('#serviceClass').val()+
	'&billingService='+$('#billingService').val()+
	'&item='+$('#item').val()+
	'&entServGroup='+$('#entServGroup').val()+
	'&entGrpLine='+$('#entGrpLine').val()+
	'&fromDate='+$('#fromDate').val()+
	'&toDate='+$('#toDate').val()+
	'&billedYN='+$('#billedYN').val()+
	'&direct_indirectchgs='+$('#direct_indirectchgs').val()+
	'&episodeType='+$('#episodeType').val()+
	'&patientId='+$('#patientId').val()+
	'&episodeId='+$('#episodeId').val()+
	'&visitId='+$('#visitId').val()+
	
	'&locale='+$('#locale').val()+
	'&groupLineService='+$('#hdnType').val()+
	'&processed='+$('#processed').val()+
	'&reSize='+$('#hdnReSize').val()+
	'&underChrgOnly='+$('#underChrgOnly').val()+
	'&fromRcrd='+startFrom+
	'&toRcrd='+endWith;
}

var headTop = -1;
var FloatHead1;
function processScroll()
	{
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
String applyMode																			=	new String();
//String locale																				=	"";

String loggedInUser																			=	"";
String mode																					=	"";
mode																						=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
String modifyStatus     																	=	"";
String service_ind																			=	"";
String price_code																			=	"";
String service_description																	=	"";
String price_ind																			=	"";
String price_description																	=	"";
String billing_class																		=	"";
String Effective_from																			=	"";
String Effective_to																			=	"";
String charge_type																			=	"";
String disc_applicability																	=	"";
String Desc																					=	"";
StringBuffer sql																			=	null;
ArrayList<String[]>		serviceDataList														=	null;
LinkedHashMap			recordServiceDetailsDataMap											=	null;
String disable																				=	"READONLY";

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
String billedYN ="";
String direct_indirectchgs="";
String groupLineService="";
String episodeType="";
String patientId="";
String episodeId="";
String visitId="";
String locale="";
String reSize = "";
String processed= "";
String underChrgOnly="";
String loginUser = (String) session.getAttribute("login_user");

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

try  
{
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	System.out.println("searched >>>>>>>>>>>>>>>>>>" +searched);	
	
	sStyle 																				=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																				= 	(String)session.getAttribute("LOCALE");
	service_code																		=	checkForNull(request.getParameter("serviceCode"));
	service_class																		=	checkForNull(request.getParameter("serviceClass"));
	billing_service																		=	checkForNull(request.getParameter("billingService"));
	item																				=	checkForNull(request.getParameter("item"));
	ent_servGroup																		=	checkForNull(request.getParameter("entServGroup"));
	ent_GrpLine																			=	checkForNull(request.getParameter("entGrpLine"));
	from_date																			=	checkForNull(request.getParameter("fromDate"));
	to_date																				=	checkForNull(request.getParameter("toDate"));
	billedYN																			=	checkForNull(request.getParameter("billedYN"));
	direct_indirectchgs																	=	checkForNull(request.getParameter("direct_indirectchgs"));
	groupLineService																	=	checkForNull(request.getParameter("groupLineService"));
	episodeType																			=	checkForNull(request.getParameter("episodeType"));
	//patientId																			=	checkForNull(request.getParameter("patientId"));
	if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
		patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patientId")).getBytes()));
	}else{
		patientId	= checkForNull(request.getParameter("patientId"));
	}
	//V230131 vulnerablity 
	System.out.println("485 patient,BLChargePatientExisOrderServDetails.jsp "+patientId);
	episodeId																			=	checkForNull(request.getParameter("episodeId"));
	visitId																				=	checkForNull(request.getParameter("visitId"));
	locale																				=	checkForNull(request.getParameter("locale"));
	reSize 																				=   checkForNull(request.getParameter("reSize"));
	processed 																			=   checkForNull(request.getParameter("processed"));
	underChrgOnly																		=   checkForNull(request.getParameter("underChrgOnly"));

	PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
	PlaceNewOrderResponse responseBean = null;
	PlaceOrderBC placeOrderBC = new PlaceOrderBC();
	requestBean.setFacilityId(facilityId);
	requestBean.setServGroupCode(service_code);
	requestBean.setServClass(service_class);
	requestBean.setServCode(billing_service);
	requestBean.setItemCode(item);
	requestBean.setEntServGroup(ent_servGroup);
	requestBean.setEntGrpLine(ent_GrpLine);
	requestBean.setFromDate(from_date);
	requestBean.setToDate(to_date);
	requestBean.setBilled_unbilled(billedYN);
	requestBean.setDirect_indirectchgs(direct_indirectchgs);
	requestBean.setGroupLineService(groupLineService);
	requestBean.setEpisodeType(episodeType);
	requestBean.setPatientId(patientId);
	requestBean.setEpisodeId(episodeId);
	requestBean.setVisitId(visitId);
	requestBean.setLocale(locale);
	requestBean.setProcessed(processed);
	requestBean.setUnderChrgOnly(underChrgOnly);
	requestBean.setLoginUser(loginUser);
	
	
	System.out.println("locale/facilityId/service_code/service_class/billing_service/item/ent_servGroup/ent_GrpLine/from_date/to_date/billedYN/direct_indirectchgs/groupLineService/episodeType/patientId/visitId >>>>>>>>>"+locale+"/"+facilityId+"/"+service_code+"/"+service_class+"/"+billing_service+"/"+item+"/"+ent_servGroup+"/"+ent_GrpLine+"/"+from_date+"/"+to_date+"/"+billedYN+"/"+direct_indirectchgs+"/"+groupLineService+"/"+episodeType+"/"+patientId+"/"+visitId);

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
	sql																						=	new StringBuffer();
	//System.out.println("<<<<<<serviceIndicator IN AdditionalServicePriceDetails.jsp::::>> "+service_ind);
	
	
	//recordServiceDetailsDataMap																=   new LinkedHashMap();
	bean_id																					= 	"BLChargePatientServiceDetailsBean" ;
	bean_name																				= 	"eBL.BLChargePatientServiceDetailsBean";
	BLChargePatientServiceDetailsBean bLChargePatientServiceDetailsBean						= 	null;
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));

	responseBean																=	placeOrderBC.getServiceDetailsData(requestBean);		
	recordServiceDetailsDataMap = responseBean.getExistingServiceDetails();		
	totalRecord = responseBean.getTotalRecordCount();
	System.err.println("totalRecord->"+totalRecord);
	
%>
<body onScroll="processScroll();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" >
	<form id="bLChargePatientServicePriceDetails" name="bLChargePatientServicePriceDetails" id="bLChargePatientServicePriceDetails">	


	
		

				<% if(!(startRcrd<=1)){
					prevYn = "Y";
					traversal = "Y";
				}
		
				if ( !( (startRcrd+constCount) > totalRecord ) ){
					nextYn = "Y";
					traversal = "Y";
				}
				%>

<script>
 loadTraverseFrame("<%=service_code %>","<%=service_class %>","<%=billing_service %>","<%=item %>","<%=ent_servGroup %>",
		"<%=ent_GrpLine %>","<%=from_date %>","<%=to_date %>","<%=billedYN %>","<%=direct_indirectchgs %>",
		"<%=groupLineService %>","<%=episodeType %>","<%=patientId %>","<%=episodeId %>","<%=visitId %>",
		"<%=underChrgOnly%>","<%=startRcrd %>","<%=endRcrd %>","<%=constCount %>","<%=prevYn %>","<%=nextYn %>");	
</script>

	<table cellpadding=3 cellspacing=0  width='60%' id="panel_categories_header_table" name="panel_categories_header_table" id="panel_categories_header_table" border="1"  >	 
	<div id="tableContainer">
		<thead style="position: sticky;z-index: 1;top: 0;">
		<%String colspan = "";
		if("G".equals(groupLineService)){
			colspan = "3";
		}
		else if("L".equals(groupLineService)){
			colspan = "5";
		}
		else{
			colspan = "18";
		}
		%>
		<tr style="background-color: white; border: none;" id='trProgress'>
			<td colspan="<%=colspan%>">
			&nbsp;
			</td>
					<td >
						<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer; cursor:pointer ">
							<span id='previousSpan'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></span>
						</span>
					</td>
					<td>	
						<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer; cursor:pointer ">
							<span id='nextSpan' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></span>
						</span>
					</td>					
			</tr>	
		<%if("G".equals(groupLineService) || "D".equals(groupLineService)){ %>
		<TR >	
			<%if("D".equals(groupLineService)){ %>
				<th class='columnheader' nowrap="nowrap"	width='5%'	align="left"	><span id='selectAllSpan' namew='selectAllSpan'<fmt:message key="Common.selectall.label" bundle="${common_labels}"	/></span>
				<input type='checkbox' name='selAllChk' id='selAllChk'  onclick='fnSelectAll();'></th>
				<th class='columnheader' nowrap="nowrap"	width='11%'	align="left"	>Trx-Doc-Ref-No</th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	>Line No</th>
				<th class='columnheader' nowrap="nowrap"	width='11%'	align="left"	><fmt:message key="eBL.ServiceHeading.label" 					bundle="${bl_labels}"	/></th>
				<th class='columnheader' nowrap="nowrap"	width='17%'	align="left"	><fmt:message key="eBL.Description.label" 				bundle="${bl_labels}"	/></th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	><fmt:message bundle="${common_labels }" key="Common.Date/Time.label"></fmt:message></th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	><fmt:message key="eBL.BILLING_SERVICE_PANEL.label" bundle="${bl_labels}"/></th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	><fmt:message key="eBL.PANEL_CODE.label" bundle="${bl_labels}"/></th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	><fmt:message key="Common.PanelDescription.label" bundle="${common_labels}"/></th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	><fmt:message key="eBL.BL_RATE_CHARGE_TYPE.label" bundle="${bl_labels}"/></th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	>UOM</th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	><fmt:message bundle="${bl_labels }" key="eBL.RATE.label"></fmt:message></th>
				<th class='columnheader' nowrap="nowrap"	width='7%'	align="left"	><fmt:message bundle="${bl_labels }" key="eBL.QTY.label"></fmt:message></th>								
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	>Pract / Staff Ind</th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	>Doctor</th>
				<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	>Doctor Name</th>
	
			<%} else{ %>
				<th class='columnheader' nowrap="nowrap"	width='20%'	align="left"	><fmt:message key="eBL.EntGrpCode.label" 					bundle="${bl_labels}"	/></th>
				<th class='columnheader' nowrap="nowrap"	width='36%'	align="left"	><fmt:message key="eBL.Description.label" 				bundle="${bl_labels}"	/></th>
								
			<%} %>		
			<th class='columnheader' nowrap="nowrap"	width='11%'	align="left"	><fmt:message key="eBL.ServiceAmount.label" 					bundle="${bl_labels}"	/></th>
			<th class='columnheader' nowrap="nowrap"	width='11%'	align="left"	><fmt:message key="eBL.SERVICE_DISC_AMT.label" 				bundle="${bl_labels}"	/></th>
			<th id='adhoc_disc_label' class='columnheader' nowrap="nowrap"	width='11%'	align="left"	><fmt:message key="eBL.AdhocDisc.label" 				bundle="${bl_labels}"	/></th>
			<th class='columnheader' nowrap="nowrap"	width='11%'	align="left"	><fmt:message key="eBL.NET_CHARGE.label" 			bundle="${bl_labels}"	/></th>
			<%if("D".equals(groupLineService)){ %>
			<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	>Remarks</th>
			<th class='columnheader' nowrap="nowrap"	width='8%'	align="left"	>Entered By</th>
			<%} %>
					</TR>
		<%}else if("L".equals(groupLineService)){ %>
		<TR >	
			<th class='columnheader' nowrap="nowrap"	width='13%'	align="left"	><fmt:message key="eBL.EntGrpCode.label" 					bundle="${bl_labels}"	/></th>
			<th class='columnheader' nowrap="nowrap"	width='19%'	align="left"	><fmt:message key="eBL.Description.label" 				bundle="${bl_labels}"	/></th>
			<th class='columnheader' nowrap="nowrap"	width='13%'	align="left"	><fmt:message key="eBL.EntLineCode.label" 					bundle="${bl_labels}"	/></th>
			<th class='columnheader' nowrap="nowrap"	width='19%'	align="left"	><fmt:message key="eBL.Description.label" 				bundle="${bl_labels}"	/></th>			
			<th class='columnheader' nowrap="nowrap"	width='9%'	align="left"	><fmt:message key="eBL.ServiceAmount.label" 					bundle="${bl_labels}"	/></th>
			<th class='columnheader' nowrap="nowrap"	width='9%'	align="left"	><fmt:message key="eBL.SERVICE_DISC_AMT.label" 				bundle="${bl_labels}"	/></th>
			<th id='adhoc_disc_label' class='columnheader' nowrap="nowrap"	width='9%'	align="left"	><fmt:message key="eBL.AdhocDisc.label" 				bundle="${bl_labels}"	/></th>
			<th class='columnheader' nowrap="nowrap"	width='9%'	align="left"	><fmt:message key="eBL.NET_CHARGE.label" 			bundle="${bl_labels}"	/></th>
		</TR>
		<%} %>
</thead>

	
	<TBODY>

	<%
	
		//System.out.println("<<<<<<<<<IN AdditionalServicePriceDetails.jsp recordPriceDetailsDataMap::::::::>>>>>>"+recordPriceDetailsDataMap);
		System.out.println("<<<<<<<<<IN BLChargePatientServicePriceDetails.jsp recordServiceDetailsDataMap:size:::::::>>>>>>"+recordServiceDetailsDataMap.size()); 

		Iterator iterator= recordServiceDetailsDataMap.keySet().iterator();

		String serviceIndKey = "";
		String serviceIndValue = "";
		String priceIndKey = "";
		String priceIndValue = "";
		String formattedDate = "";
		int sNo = 0;
		while(iterator.hasNext())
		{
			
			int index =    (Integer)iterator.next();
			sNo	  =		index+1;

			//System.out.println("<<<<<<<<<<<<IN getScreenServiceCriteria index>>>>>>>"+index);
			bLChargePatientServiceDetailsBean = (BLChargePatientServiceDetailsBean) recordServiceDetailsDataMap.get(index);
			if(!"UC".equals(reSize)){
				bLChargePatientServiceDetailsBean.setRemarks("");
			}

			if(bLChargePatientServiceDetailsBean.getChargeDateTime() !=null && !"".equals(bLChargePatientServiceDetailsBean.getChargeDateTime())){
				formattedDate = sdf.format(bLChargePatientServiceDetailsBean.getChargeDateTime());
			}
			else{
				formattedDate = "";
			}
	
	%>
	
			<tr id='resultTr_<%=index%>' data-id='<%=index%>'>
				<%if("G".equals(groupLineService)  || "D".equals(groupLineService)){ %>		
					<%if("D".equals(groupLineService)){ %>
						<td class="fields"  width='5%' nowrap="nowrap"  >				
							<input type='checkbox' id="chk_blng_serv<%=index%>" name="chk_blng_serv<%=index%>" onclick="calculateTotal(<%=index%>);">
						</td>
						<td  class="fields"  width='11%' nowrap="nowrap"  >
							<span id='labelTrDoc_<%=index %>' data-id='<%=index%>'><%=checkForNull(bLChargePatientServiceDetailsBean.getTrxDocRef()) %></span>
							<input type='hidden' name='trxDocRef<%=index%>' id='trxDocRef<%=index%>'	value='<%=checkForNull(bLChargePatientServiceDetailsBean.getTrxDocRef()) %>'>
						</td>
						
					 <td class="fields" style="text-align: right;" width='7%' nowrap="nowrap"  id="linenum<%=index%>"			name="linenum<%=index%>"><%=bLChargePatientServiceDetailsBean.getSecKeyLineNo() %></td>
						
						<%if(("UC".equals(reSize)) || ("UP".equals(reSize))){ %>
						<td class="fields"  width='11%' nowrap="nowrap"  id="serv_grp_code<%=index%>"		name="serv_grp_code<%=index%>"	>
					 			<%=bLChargePatientServiceDetailsBean.getBlngServCode()					!=null ? 	bLChargePatientServiceDetailsBean.getBlngServCode()		: 	"" %> 							 			
						<%}
						else{ %>
						<td class="gridDataBlue"  width='11%' nowrap="nowrap"  id="serv_grp_code<%=index%>"	class='gridDataBlue' style='cursor:pointer' onclick="tooltip(this,<%=index %>,'service');"	onmouseover="hideToolTip();"	name="serv_grp_code<%=index%>"	>
					 			<%=bLChargePatientServiceDetailsBean.getBlngServCode()					!=null ? 	bLChargePatientServiceDetailsBean.getBlngServCode()		: 	"" %> 		
					 			<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=index%>'>
						<%} %>
						
						
					 	
					 	<input type='hidden' name='trxDocRefLineNum<%=index%>' id='trxDocRefLineNum<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getTrxDocRefLineNum() %>'>
					 	<input type='hidden' name='trxDocRefSeqNum<%=index%>' id='trxDocRefSeqNum<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getTrxDocRefSeqNum() %>'>
					 	<input type='hidden' name='primKeyLineNo<%=index%>' id='primKeyLineNo<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getPrimKeyLineNum() %>'>
					 	<input type='hidden' name='primKeyMain<%=index%>' id='primKeyMain<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getPrimKeyMain() %>'>
					 	<input type='hidden' name='primKeyModId<%=index%>' id='primKeyModId<%=index%>'	value='<%=replaceNull(bLChargePatientServiceDetailsBean.getPrimKeyModId()) %>'>
					 	<input type='hidden' name='confirmedYn<%=index%>' id='confirmedYn<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getConfirmedYn() %>'>
					 	<input type='hidden' name='servedPanelQty<%=index%>' id='servedPanelQty<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getServedpanelQty() %>'>
					 	<input type='hidden' name='servQty<%=index%>' id='servQty<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getServQty() %>'>
					 	<input type='hidden' name='physicianId<%=index%>' id='physicianId<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getPhysicianId() %>'>
					 	<input type='hidden' name='physicianName<%=index%>' id='physicianName<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getPhysicianName() %>'>
					 	<input type='hidden' name='uomCode<%=index%>' id='uomCode<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getUomCode() %>'>
					 	<input type='hidden' name='practStaffInd<%=index%>' id='practStaffInd<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getPractStaffInd() %>'>
					 	
					 	<input type='hidden' name='inclExclInd<%=index%>' id='inclExclInd<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getInclExclInd() %>'>
					 	<input type='hidden' name='reason<%=index%>' id='reason<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getReason() %>'>
					 	<input type='hidden' name='remarks<%=index%>' id='remarks<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getRemarks() %>'>
					 	<input type='hidden' name='dailyProcessInd<%=index%>' id='dailyProcessInd<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getDailyProcessInd() %>'>					 	
					 	<input type='hidden' name='bedType<%=index%>' id='bedType<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getBedTypeCode() %>'>
					 	
					 	<input type='hidden' name='tokenSeriesCode<%=index%>' id='tokenSeriesCode<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getTokenSeriesCode() %>'>
					 	<input type='hidden' name='tokenSeriesNo<%=index%>' id='tokenSeriesNo<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getTokenSeriesNo() %>'>
					 	<input type='hidden' name='dispLocn<%=index%>' id='dispLocn<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getDispLocn() %>'>
					 	<input type='hidden' name='secKeyMain<%=index%>' id='secKeyMain<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getSecKeyMain() %>'>
					 	<input type='hidden' name='secKeyLineNo<%=index%>' id='secKeyLineNo<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getSecKeyLineNo() %>'> 			
					 	<input type='hidden' name='servOrPanel<%=index%>' id='servOrPanel<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getServOrPanel() %>'>
					 	<input type='hidden' name='baseRate<%=index%>' id='baseRate<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getBaseRate() %>'>
					 	<input type='hidden' name='rateIndicator<%=index%>' id='rateIndicator<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getRateIndicator() %>'>
					 	<input type='hidden' name='itemCode<%=index%>' id='itemCode<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getItemCode() %>'>					 	
					 	<input type='hidden' name='module_id<%=index%>' id='module_id<%=index%>'	value='<%=bLChargePatientServiceDetailsBean.getModuleId() %>'>
					 	
					 	<input type='hidden' name='errorCode<%=index%>' id='errorCode<%=index%>'	value='<%=replaceNull(bLChargePatientServiceDetailsBean.getErrorCode()) %>'>					 	
					 	<input type='hidden' name='warningMess<%=index%>' id='warningMess<%=index%>'	value='<%=replaceNull(bLChargePatientServiceDetailsBean.getWarningMessage()) %>'>
					 </td>	
					 <td class="fields"  width='17%' nowrap="nowrap"  id="serv_grp_desc<%=index%>"			name="serv_grp_desc<%=index%>">				<%=bLChargePatientServiceDetailsBean.getBlngServDesc()				!=null ? 	bLChargePatientServiceDetailsBean.getBlngServDesc()		: 	"" %>&nbsp;</td>
					 <td class="fields"  width='8%' nowrap="nowrap"  id="chargeDateTime<%=index%>"			name="chargeDateTime<%=index%>">	<%=formattedDate %>			&nbsp;</td>
					 <td class='label' nowrap="nowrap">
						<%if("S".equals(bLChargePatientServiceDetailsBean.getServOrPanel())){ 
							out.print("Service");
						}
						else{
							out.print("Panel");
						}
						%>						
					</td>
					
					 <td class="fields"  width='5%' nowrap="nowrap"  name='panelCode<%=index%>' id='panelCode<%=index%>'> <%=bLChargePatientServiceDetailsBean.getPanelCode()!=null ?bLChargePatientServiceDetailsBean.getPanelCode()		: 	"" %>&nbsp;</td>
					 <td class="fields"  width='5%' nowrap="nowrap"  name='panelDesc<%=index%>' id='panelDesc<%=index%>'> <%=bLChargePatientServiceDetailsBean.getPanelDesc()!=null ?bLChargePatientServiceDetailsBean.getPanelDesc()		: 	"" %>&nbsp;</td>

					<td class='label' nowrap="nowrap">
						<%if("R".equals(bLChargePatientServiceDetailsBean.getRateIndicator())){ 
							out.print("Rate");
						}
						else{
							out.print("Charge");
						}
						%>						
					</td>
					 <td class="fields"  width='8%' nowrap="nowrap">
					 	<%=checkForNull(bLChargePatientServiceDetailsBean.getUomCode()) %>
					 </td>
					
					 <td class="fields"  style='text-align:right' width='8%' nowrap="nowrap"  id="txtRate<%=index%>"	name="txtRate<%=index%>">				<%=bLChargePatientServiceDetailsBean.getBaseRate()				!=null ? 	bLChargePatientServiceDetailsBean.getBaseRate()		: 	"" %>&nbsp;</td>
					 <td class="fields"  width='7%' nowrap="nowrap"  id="txtQty<%=index%>"			name="ss">				<%=bLChargePatientServiceDetailsBean.getServQty()!=null ? qtydecimal(""+bLChargePatientServiceDetailsBean.getServQty()	)	: 	"" %>&nbsp;</td>
					  <td class="fields"  width='8%' nowrap="nowrap">
					  	<% if("P".equalsIgnoreCase(bLChargePatientServiceDetailsBean.getPractStaffInd())){ 
					  		out.print("Practitioner");
					  	}
					  	else if("O".equalsIgnoreCase(bLChargePatientServiceDetailsBean.getPractStaffInd())){
					  		out.print("Other Staff");
					  	}
					  	%>
					 </td>
					  <td class="fields"  width='8%' nowrap="nowrap">
					  	<%=checkForNull(bLChargePatientServiceDetailsBean.getPhysicianId()) %>
					 </td>
					   <td class="fields"  width='8%'  nowrap="nowrap">
					  	<%=checkForNull(bLChargePatientServiceDetailsBean.getPhysicianName()) %>
					 </td>
					 
					
					 
					<%}else{ %>								
					<td class="gridDataBlue"  width='20%' nowrap="nowrap"  id="serv_grp_code<%=index%>"	class='gridDataBlue' style='cursor:pointer' onclick="tooltip(this,<%=index %>,'entGroup');"	onmouseover="hideToolTip();"	name="serv_grp_code<%=index%>"	>
					 			<%=bLChargePatientServiceDetailsBean.getServGrpCode()					!=null ? 	bLChargePatientServiceDetailsBean.getServGrpCode()		: 	"" %> 		
					 			<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=index%>'>		 			
					 </td>	
					 <td class="fields"  width='36%' nowrap="nowrap"  id="serv_grp_desc<%=index%>"			name="serv_grp_desc<%=index%>">				<%=bLChargePatientServiceDetailsBean.getServGrpDesc()				!=null ? 	bLChargePatientServiceDetailsBean.getServGrpDesc()		: 	"" %>&nbsp;</td>
					<%} %>			 
					 
					<td class="fields" 	style='text-align:right' width='11%' nowrap="nowrap" id="gross_amt<%=index%>"			name="gross_amt<%=index%>">				<%=bLChargePatientServiceDetailsBean.getGrossAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getGrossAmt()		: 	"" %>&nbsp; </td>
					<td class="fields"  style='text-align:right' width='11%' nowrap="nowrap" id="disc_amt<%=index%>"			name="disc_amt<%=index%>">				<%=bLChargePatientServiceDetailsBean.getDiscAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getDiscAmt()		: 	"" %>&nbsp; </td>
					<td class="fields"  style='text-align:right' width='11%' nowrap="nowrap" id="adhoc_disc_amt<%=index%>"			name="adhoc_disc_amt<%=index%>">				<%=bLChargePatientServiceDetailsBean.getAdhocDiscount()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getAdhocDiscount()		: 	"" %>&nbsp; </td>
					<td class="fields"  style='text-align:right' width='11%' nowrap="nowrap" id="net_amt<%=index%>"			name="net_amt<%=index%>">				<%=bLChargePatientServiceDetailsBean.getNetAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getNetAmt()		: 	"" %>&nbsp; </td>
					<%if("D".equals(groupLineService )){ %>
						<%if("UC".equals(reSize)){ %>
						
					<td class="fields"  width='8%' nowrap="nowrap">
					  	<span style="color: blue;" onclick="javascript:showRemarks('<%=index%>')">Remarks</span>
					 </td>
					 <%}
					 	else{ %>
					<td class="fields"  width='8%' nowrap="nowrap">
					  	<span style="color: blue;" onclick="javascript:captureRemarks('<%=index%>')">Remarks</span>
					 </td>
					 <%}%>
					 
					 <td class="fields"  width='8%' nowrap="nowrap">
					  		<%=checkForNull(bLChargePatientServiceDetailsBean.getaddedBy()) %>
					 </td>		
					 <%} %>				
				<%} else if("L".equals(groupLineService)) { %>
					<td class="gridDataBlue"  width='13%' nowrap="nowrap"  id="serv_grp_code<%=index%>"	class='gridDataBlue' style='cursor:pointer' onclick="tooltip(this,<%=index %>,'entLine');"	onmouseover="hideToolTip();"	name="serv_grp_code<%=index%>"	>
					 			<%=bLChargePatientServiceDetailsBean.getServGrpCode()					!=null ? 	bLChargePatientServiceDetailsBean.getServGrpCode()		: 	"" %> 		
					 			<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=index%>'>		 			
					 </td>				 
					<td class="fields"  width='19%' nowrap="nowrap"  id="serv_grp_desc<%=index%>"			name="serv_grp_desc<%=index%>">				<%=bLChargePatientServiceDetailsBean.getServGrpDesc()				!=null ? 	bLChargePatientServiceDetailsBean.getServGrpDesc()		: 	"" %>&nbsp;</td>
					<td class="fields"  width='13%' nowrap="nowrap"  id="serv_line_code<%=index%>"			name="serv_line_code<%=index%>">				<%=bLChargePatientServiceDetailsBean.getLineCode()				!=null ? 	bLChargePatientServiceDetailsBean.getLineCode()		: 	"" %>&nbsp;</td>
					<td class="fields"  width='29%' nowrap="nowrap"  id="serv_line_desc<%=index%>"			name="serv_line_desc<%=index%>">				<%=bLChargePatientServiceDetailsBean.getLineDesc()				!=null ? 	bLChargePatientServiceDetailsBean.getLineDesc()		: 	"" %>&nbsp;</td> 
					<td class="fields"  style='text-align:right' width='9%' nowrap="nowrap" id="gross_amt<%=index%>"			name="gross_amt<%=index%>">				<%=bLChargePatientServiceDetailsBean.getGrossAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getGrossAmt()		: 	"" %>&nbsp; </td>
					<td class="fields"  style='text-align:right' width='9%' nowrap="nowrap" id="disc_amt<%=index%>"			name="disc_amt<%=index%>">				<%=bLChargePatientServiceDetailsBean.getDiscAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getDiscAmt()		: 	"" %>&nbsp; </td>
					<td class="fields"  style='text-align:right' width='9%' nowrap="nowrap" id="adhoc_disc_amt<%=index%>"			name="adhoc_disc_amt<%=index%>">				<%=bLChargePatientServiceDetailsBean.getAdhocDiscount()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getAdhocDiscount()		: 	"" %>&nbsp; </td>
					<td class="fields"  style='text-align:right' width='9%' nowrap="nowrap" id="net_amt<%=index%>"			name="net_amt<%=index%>">			152.00058&nbsp; </td>						
					
				<%} %>
				 
			</tr>
			
			<%
			startIndex++;
		}	
		
		if(sNo==0){%>
		<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		</script>
		<%}
	%>
			
	</table>
	
	
	
		<input type='hidden' name='prevClicked' id='prevClicked' id='prevClicked' value="" />
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
	
	<!--  To Hide Progress Bar -->
	<script>
	fnHideProgress('<%=groupLineService%>','<%=reSize%>');
	</script>
	<!-- To Hide Progress Bar -->	
	<%if("D".equals(groupLineService) && !"UC".equals(reSize)){ %>
	<br/>
		<span id='spanCancel'style="padding-right: 10px;"><input type='button' class='button' id='cancelAll' name='cancelAll' id='cancelAll' value='Cancel' onclick='processBulk("cancelAll");'></span>
		<span id='spanProcess'style="padding-right: 10px;"><input type='button' class='button' id='processAll' name='processAll' id='processAll' value='Process' onclick='processBulk("processAll");'></span>
		<span id='spanConfirm'style="padding-right: 10px;"><input type='button' class='button' id='confirmAll' name='confirmAll' id='confirmAll' value='Confirm' onclick='processBulk("confirmAll");'></span>
		<span style="padding-right: 30px;padding-left: 10px;">Total (NET)</span>
		<span id='spTotalAmt'></span>
	<%} %>
	<!-- Hidden Fields for Next and Previous -->
	<input type='hidden' name='hdnType' id='hdnType' id='hdnType' value='<%=groupLineService%>'>
	<input type='hidden' name='processed' id='processed' id='processed' value='<%=processed%>'>
	<input type='hidden' name='hdnReSize' id='hdnReSize' id='hdnReSize' value='<%=reSize %>'>
	<input type='hidden' name='underChrgOnly' id='underChrgOnly' id='underChrgOnly' value='<%=underChrgOnly%>'>
	
	<input type='hidden' name='serviceCode' id='serviceCode' id='serviceCode' value='<%=service_code%>'>
	<input type='hidden' name='serviceClass' id='serviceClass' id='serviceClass' value='<%=service_class%>'>
	<input type='hidden' name='billingService' id='billingService' id='billingService' value='<%=billing_service%>'>
	<input type='hidden' name='item' id='item' id='item' value='<%=item%>'>
	<input type='hidden' name='entServGroup' id='entServGroup' id='entServGroup' value='<%=ent_servGroup%>'>
	<input type='hidden' name='entGrpLine' id='entGrpLine' id='entGrpLine' value='<%=ent_GrpLine%>'>
	<input type='hidden' name='fromDate' id='fromDate' id='fromDate' value='<%=from_date%>'>
	<input type='hidden' name='toDate' id='toDate' id='toDate' value='<%=to_date%>'>
	<input type='hidden' name='billedYN' id='billedYN' id='billedYN' value='<%=billedYN%>'>
	<input type='hidden' name='direct_indirectchgs' id='direct_indirectchgs' id='direct_indirectchgs' value='<%=direct_indirectchgs%>'>
	<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value='<%=episodeType%>'>
	<input type='hidden' name='patientId' id='patientId' id='patientId' value='<%=patientId%>'>
	<input type='hidden' name='episodeId' id='episodeId' id='episodeId' value='<%=episodeId%>'>
	<input type='hidden' name='visitId' id='visitId' id='visitId' value='<%=visitId%>'>
	<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale%>'>
	<!-- Hidden Fields for Next and Previous -->
	<input type='hidden' name='hdnNextSpan' id='hdnNextSpan' id='hdnNextSpan' value='<%=nextYn %>'>
	<input type='hidden' name='prevSpan' id='prevSpan' id='prevSpan' value='<%=prevYn %>'>
	<input type='hidden' name='traverse' id='traverse' id='traverse' value='<%=traversal%>'>
	<input type='hidden' name='fromRcrd' id='fromRcrd' id='fromRcrd' value='<%=startRcrd %>'>
	<input type='hidden' name='toRcrd' id='toRcrd' id='toRcrd' value='<%=endRcrd %>'>
	<input type='hidden' name='constCount' id='constCount' id='constCount' value='<%=constCount %>'>
</form>	
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
	
	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:8%; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
					<!-- </td> -->
				</tr>
			</table>
		</div>
	
</body>
</TBODY>	
	</div>
<%
	}
	catch(Exception e)
	{
		System.out.println("<<<<<<<Exception in BLChargePatientExisOrderServDetails.jsp::"+e);
		e.printStackTrace();
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

