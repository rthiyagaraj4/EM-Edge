<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.result.viewresult.TestResultCacheManager"%>
<%@page import="java.util.Calendar"%>
<%@page import="portalrefimpl.result.ResultConstants"%>
<%@page import="portalrefimpl.common.model.Facility"%>
<%@page import="portalrefimpl.result.detailedresult.response.ResultStatus"%>
<%@page import="portalrefimpl.result.detailedresult.response.DetailedResult"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.facility.facilityforpatient.response.FacilityListResponse"%>
<%@page import="portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.facility.facilityforpatient.request.FacilityListRequest"%>
<%@page import="portalrefimpl.result.detailedresult.response.DetailedResultsResponse"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.result.detailedresult.request.DetailedResultsRequest"%>
<%@page import="portalrefimpl.result.detailedresult.svc.DetailedResultsServiceInvoker"%>
<%@page import="portalrefimpl.common.serviceinvoker.ServiceInvoker"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Result</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>

<link href="../../css/examples-offline.css" rel="stylesheet">
<link href="../../css/kendo.common.min.css" rel="stylesheet">
<link href="../../css/kendo.default.min.css" rel="stylesheet">

<script src="../../js/jquery.min.js"></script>
<script src="../../js/kendo.web.min.js"></script>
<script src="../../js/console.js"></script>
<script src="../../js/date.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function searchResults(){
	var formElement = document.getElementById("searchForm");
	// TODO need to perform validation for date fields
	  if(formElement){
		  
		  var categoryCombo = document.getElementById('orderCategory');
		  if(categoryCombo){
			  var categoryValue = categoryCombo.options[categoryCombo.selectedIndex].value;
			  if(categoryValue == ''){
				  alert('Either Lab Order or Radiology should be selected for search operation');
				  return false;
			  }
		  }
		  
		  
		  var fromDateEle = document.getElementById("fromDatePicker");
		  var fromDateHiddenElem = document.getElementById("fromDate");
		  var fromdatepicker = $("#fromDatePicker").data("kendoDatePicker");
		  var fromDateObj;
		  var dateValue = "";
		  if(fromDateEle && fromDateHiddenElem){
			 //alert(fromDateEle.value);
			 if(fromdatepicker){
				 fromDateObj = new Date(fromdatepicker.value());
				 dateValue = fromDateObj.toString("MM/dd/yyyy");
			 }else{
				 dateValue = fromDateEle.value;
			 }
			 
			 fromDateHiddenElem.value = dateValue;
		  }
		  
		  dateValue = "";
		  
		  var toDateEle = document.getElementById("toDatePicker");
		  var toDateHiddenElem = document.getElementById("toDate");
		  var todatepicker = $("#toDatePicker").data("kendoDatePicker");
		  var toDateObj;
		  if(toDateEle && toDateHiddenElem){
			  if(todatepicker){
				  toDateObj = new Date(todatepicker.value());
				  dateValue = toDateObj.toString("MM/dd/yyyy");
			  }else{
				  dateValue = toDateEle.value;
			  }
			  
			  toDateHiddenElem.value = dateValue;
		  }
		  
		  var initialResultElem = document.getElementById("initialReset");
		  if(initialResultElem){
			  initialResultElem.value = "N";
		  }
		  
		  formElement.submit();
	  }
}

function showMoreResults(){
	// get the component which stores the current number
	// of records shown in the page
	var currentResultCounterComp = document.getElementById("resultCounter");
	var currentResultCounter;
	if(currentResultCounterComp){
		currentResultCounter = currentResultCounterComp.value;
	}
	// get the int value
	var currentResultCounterInt = parseInt(currentResultCounter);
	// get the component which stores the overall number
	// of records shown in the page
	var resultCountComp = document.getElementById("resultCount");
	var resultCount;
	if(resultCountComp){
		resultCount = resultCountComp.value;
	}
	var resultCountInt = parseInt(resultCount);
	
	// get the component which stores the number of records to be shown
	// every time user clicks on "click more" button
	var recordViewCountComp = document.getElementById("DetailedTestResultsRowCount")
	var recordViewCount;
	if(recordViewCountComp){
		recordViewCount = recordViewCountComp.value;
	}
	var recordViewCountInt = parseInt(recordViewCount);
	
	// the logic now is to show records further from the current
	// number of records shown till the next set of records	
	var iterationEndValue = resultCountInt;
	if((currentResultCounterInt + recordViewCountInt) < resultCountInt){
		iterationEndValue = currentResultCounterInt + recordViewCountInt;
	}
	
	var resultElement;
	for(var itrCnt=(currentResultCounterInt + 1);itrCnt<=iterationEndValue;itrCnt++){
		resultElement = document.getElementById("result"+itrCnt);
		if(resultElement){
			resultElement.style.display = 'block';
		}
	}
	
	// this code will disable the "click more" button since there are
	// no more records to be shown
	if(iterationEndValue == resultCountInt){
		var moreResultDivComp = document.getElementById("moreResultDiv");
		if(moreResultDivComp){
			moreResultDivComp.style.display = "none";
		}
	}
	
	currentResultCounterComp.value = ""+iterationEndValue;
}

function showResult(orderCatalogue,orderId,resultType,orderDate){
	var newOrderCatalogue = escape(orderCatalogue);
	//alert(orderId+' '+newOrderCatalogue+' '+resultType+' '+orderDate);
	var url = './ViewResult.jsp?orderId='+orderId+'&order='+newOrderCatalogue+'&resultType='+resultType+'&orderDate='+orderDate;
	var winLeft = (screen.width - 795)/2;
	var winTop = (screen.height - 495)/2;
	var popupWindow = window.open(url,'TestResult','height=495,width=795,top='+winTop+',left='+winLeft+',resizable=no,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no,addressbar=no,status=no,titlebar=no');
	return false;
}

function showTestResult(orderId,orderCatalogue,orderCategory,orderDate,counter,viewResultAnchorId){
	//alert($('#testresult'+counter));
	var newOrderCatalogue = escape(orderCatalogue);
	var newResultType = escape(orderCategory);
	var newOrderDate = escape(orderDate);
	//alert(orderId+' '+newOrderCatalogue+' '+newResultType+' '+newOrderDate+ ' '+orderDate+' '+orderCategory);
	var btnText = $('#'+viewResultAnchorId).html();
	if(btnText == 'Hide&nbsp;Results'){
		$('#testresult'+counter).css('display','none');
		$('#'+viewResultAnchorId).html("View&nbsp;Results");
	}else{
		//$('#testresult'+counter).load('./GetTestResult.jsp?orderId='+orderId+'&order='+newOrderCatalogue+'&resultType='+newResultType+'&orderDate='+newOrderDate+'&counter='+counter);
		
		var xmlHttp = getHttpObject();
     	xmlHttp.onreadystatechange=function(){
     		if(xmlHttp.readyState==4 && xmlHttp.status==200){
     			var responseText = xmlHttp.responseText;
     			$('#testresult'+counter).html(responseText);
     			
     			$('#testresult'+counter).css('display','block');
     			$('#'+viewResultAnchorId).html("Hide&nbsp;Results");
     		}
     	 };
     	xmlHttp.open("POST", "./GetTestResult.jsp", true);
     	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
     	var parameters = 'orderId='+orderId+'&order='+newOrderCatalogue+'&resultType='+newResultType+'&orderDate='+newOrderDate+'&counter='+counter;
     	xmlHttp.send(parameters);
     	
     	
		/* $('#testresult'+counter).load('./TestResultWrapper.jsp?orderId='+orderId+'&order='+newOrderCatalogue+'&resultType='+newResultType+'&orderDate='+newOrderDate+'&counter='+counter); */
		//$('#testresult'+counter).load('./GetTestResult.jsp?orderId='+orderId);
		
		//$('#testresult'+counter).css('display','block');
		
		// now change the inner html of the "view result" button
		// to "hide result"
		//alert($('#viewresultbtn'+counter).html());
		//alert(viewResultAnchorId);
		
		$('#'+viewResultAnchorId).html("Hide&nbsp;Results");
	}
	
}

function getHttpObject(){
	var xmlHttp;
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttp;
}


$(document).ready(function() {
    // create DatePicker from input HTML element
    $("#fromDatePicker").kendoDatePicker();
    $("#toDatePicker").kendoDatePicker();
});

function showResultPopup(orderCatalogue,orderId,resultType,orderDate,counter){
	//alert('in function');
	//alert('in function, input values are:'+orderCatalogue+' ; '+orderId+' ; '+resultType+' ; '+orderDate+' ; '+counter );
	var newOrderCatalogue = escape(orderCatalogue);
	var newResultType = escape(resultType);
	var newOrderDate = escape(orderDate);
	var newOrderId = escape(orderId);
	
	 $('#popupdiv'+counter).load('./ViewResult.jsp?orderId='+newOrderId+'&order='+newOrderCatalogue+'&resultType='+newResultType+'&orderDate='+newOrderDate+'&counter='+counter);
	 //alert('in show result popup - after loading');
	 
	 /* document.getElementById('popupcontainerdiv'+counter).style.visibility = '';
	 document.getElementById('popupdiv'+counter).style.visibility = '';
	 if(!($('#popupdiv'+counter).data("kendoWindow"))){
		 $('#popupdiv'+counter).kendoWindow({
			 actions : ["Close"],
			 draggable : false,
			 modal : true,
			 resizable : false,
			 close : function() {
				 closeResultPopup(counter);
			 }
		 });
		 $('#popupdiv'+counter).data("kendoWindow").open();
		 $('#popupdiv'+counter).data("kendoWindow").center();
	 } */
	 
	 
	if (document.getElementById('popupcontainerdiv'+counter).style.visibility == 'hidden') {
       document.getElementById('popupcontainerdiv'+counter).style.visibility = '';
       $("#popupcontainerdiv"+counter).hide();
    }
    if (document.getElementById('popupdiv'+counter).style.visibility == 'hidden') {
       document.getElementById('popupdiv'+counter).style.visibility = '';
       $("#popupdiv"+counter).hide();
    }
	
	$("#popupcontainerdiv"+counter).fadeIn(500, "linear", function () { $("#popupdiv"+counter).show(800, "swing"); }); 	
}

function closeResultPopup(popupDivCounter){
	$("#popupdiv"+popupDivCounter).hide('800', "swing", function () { $("#popupcontainerdiv"+popupDivCounter).fadeOut("500"); });
	/* document.getElementById('popupcontainerdiv'+popupDivCounter).style.visibility = 'hidden';
	document.getElementById('popupdiv'+popupDivCounter).style.visibility = 'hidden';  */
	
	
	//alert('in close');
	/* document.getElementById('popupcontainerdiv'+popupDivCounter).style.visibility = 'hidden';
	document.getElementById('popupdiv'+popupDivCounter).style.visibility = 'hidden'; */
	
	//$('#popupdiv'+popupDivCounter).data("kendoWindow").close();
}

</script>

<style>

.menu li a:before {
	content:url(../../images/patch.PNG);
	height:80px;
	width:auto;
	top:63px;
	left:-13px;
	position:relative;
}
.menu li a:after {content:url(../../images/patch.PNG);
	height:80px;
	width:auto;
	top:35px;
	right:-13px;
	position:relative;

}
.menu li a:hover:before {content:url(../../images/LeftMenubg.PNG);
	height:80px;
	width:auto;
	top:63px;
	left:-13px;
	position:relative;
}

.menu li a:hover:after{
	content:url(../../images/RightMenubg.PNG);
	height:80px;
	width:auto;
	top:35px;
	right:-13px;
	position:relative;
}

.menuselect:after{
	content:url(../../images/RightMenubg.PNG);
	height:80px;
	width:auto;
	top:35px;
	right:-13px;
	position:relative;

}
.menuselect:before {content:url(../../images/LeftMenubg.PNG);
	height:80px;
	width:auto;
	top:65px;
	left:-13px;
	position:relative;

}

.popupContainerStyle {
      /* background-color: white;
      color: black;
      display:block;
      position: absolute;
      top: 50%;
      left: 50%;
      width: 795px;
      height: 495px; */
      
      background-color: black;
      opacity: 90%;
      filter:alpha(opacity=90);
      background-color: rgba(255,255,255,0.90); 
      width: 100%;
      min-height: 100%;
      overflow: hidden;
      float: absolute;
      position: fixed;
      top: 0;
      left: 0;
      color: white;
}

.popupResultContentStyle{
	  background-color: white;
      color: black;
      border: 1px solid gray;
      padding: 2px;
      display:block;
      position: absolute;
      top: 20%;
      left: 20%; 
      width: 775px;
      height: 475px;
}

</style>




</head>
<body>

<%
	String patientId = "";
	patientId = (String) session
			.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
	//patientId = request.getParameter("patientId");
	if (patientId == null) {
		patientId = (String) getServletConfig().getServletContext()
				.getAttribute("patientId");
		if (patientId == null) {
			patientId = "";
		}
	}

	String patientName = "";
	patientName = (String) session
			.getAttribute(PortalConstants.PATIENTNAME_SESSION_KEY);
	//patientName = request.getParameter("patientName");
	if (patientName == null) {
		patientName = "";
	}

	String orderNumber = request
			.getParameter(ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY);
	if (orderNumber == null) {
		orderNumber = "";
	}

	String orderCategory = request
			.getParameter(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY);
	if (orderCategory == null) {
		/* orderCategory = ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY; */
		orderCategory = "";
	}

	String orderCatalogue = request
			.getParameter(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY);
	if (orderCatalogue == null) {
		orderCatalogue = "";
	}

	String kendoFromDateString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY);
	String fromDateString = kendoFromDateString;
	Date fromDateObj = new Date();
	Calendar fromCalendar = Calendar.getInstance();
	fromCalendar.setTime(fromDateObj);
	fromCalendar.add(Calendar.YEAR, -1);
	if (kendoFromDateString == null) {
		fromDateString = PortalHelper.getDateAsString(
				fromCalendar.getTime(),
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);
		kendoFromDateString = PortalHelper.getDateAsString(
				fromCalendar.getTime(),
				ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		//fromDateString = "28/11/2012";
	} else {
		fromDateObj = PortalHelper.getDateFromString(
				kendoFromDateString,
				ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		if (fromDateObj == null) {
			fromDateObj = fromCalendar.getTime();
			kendoFromDateString = PortalHelper
					.getDateAsString(
							fromDateObj,
							ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		} else {
			fromCalendar.setTime(fromDateObj);
		}
		fromDateString = PortalHelper.getDateAsString(fromDateObj,
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);
	}

	String kendoToDateString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY);
	String toDateString = kendoToDateString;
	Date toDateObj = new Date();
	if (kendoToDateString == null) {
		kendoToDateString = PortalHelper.getDateAsString(toDateObj,
				ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		/* toDateString = PortalHelper.getDateAsString(toDateObj,
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT); */
		//toDateString = "27/12/2012";
	}
	toDateString = PortalHelper.getDateAsString(toDateObj,
			ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);

	// code added to get the initial reset value from request
	// if this value is "Y" then we should not apply the date filter
	// we should simply get the first N records
	String initialResetValue = request
			.getParameter(ResultConstants.DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY);
	if (initialResetValue == null) {
		initialResetValue = ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE;
	}
	// just reset the date string values
	// as when user traverses to this page then only some N number of records
	// should be shown - user can then apply filter
	if (ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
			.equalsIgnoreCase(initialResetValue)) {
		kendoFromDateString = "";
		kendoToDateString = "";
		fromDateString = "";
		toDateString = "";
	}

	String resultCountString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY);
	if (resultCountString == null) {
		resultCountString = "0";
	}
	int resultCount = 0;
	try {
		resultCount = Integer.parseInt(resultCountString);
	} catch (Exception ex) {
		resultCount = 0;
	}
	// constant to store the number of records to be shown at one instance
	final int TOTALRECORD_COUNT = 4;
	// read the result counter
	String resultCounterString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY);
	String tempResultCountString = PortalHelper.getConfigPropertyValue(
			ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY, true);
	if (resultCounterString == null) {
		resultCounterString = tempResultCountString;
	}
	int currentResultCounter = PortalHelper.getIntegerValue(
			tempResultCountString, TOTALRECORD_COUNT);
	int resultCounter = PortalHelper.getIntegerValue(
			tempResultCountString, TOTALRECORD_COUNT);
%>

<div id="wrapper" style="background-color: #ffffff;">
<div class="fixedheader">	
<header id="header">
    	<div id="headerinfo">
        	<div class="row">
        		<div id="headervisitinfo">
                	Welcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM 
                </div>    
               <div id="headerloginas">
                	 Welcome, <%=patientName%>, ID:<%=patientId %>
               </div>
               <div id="headerlogout">
					<div><a href="../../servlet/LogoutServlet"  class="logout">
                    Logout</a></div>
              </div>
          </div>
    </div>
</header>
   
<%
   	DetailedResultsRequest resultsRequest = new DetailedResultsRequest();
   	//resultsRequest.setPatientId("MC00000345");
   	resultsRequest.setPatientId(patientId);
   	resultsRequest.setOrderNumber(orderNumber);
   	resultsRequest.setOrderCategory(orderCategory);
   	resultsRequest.setLocation(orderCatalogue);
   	/* Date fromDate = PortalHelper.getDateFromString(fromDateString,
   			"dd/MM/yyyy"); */
   	resultsRequest.setFromDate(fromCalendar.getTime());
   	resultsRequest.setFromDateString(fromDateString);

   	/* Date toDate = new Date(); */
   	resultsRequest.setToDate(toDateObj);
   	resultsRequest.setToDateString(toDateString);

   	resultsRequest.setInitialResetValue(initialResetValue);
	resultsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
   /* 	DetailedResultsSvcImpl detailedSvc = new DetailedResultsSvcImpl();
   	detailedSvc.registerService(resultsRequest); */

   	ServiceInvoker detailedResultsServiceInvoker = new DetailedResultsServiceInvoker();
   	detailedResultsServiceInvoker.registerService(resultsRequest);
   	DetailedResultsResponse detailedResultsResponse = (DetailedResultsResponse) detailedResultsServiceInvoker
   			.getDataThroughWebService(resultsRequest);

   	FacilityListRequest facilityListRequest = new FacilityListRequest();
   	facilityListRequest
   			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
   	
   	FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
   	FacilityListResponse facilityListResponse = facilityListServiceInvoker.getDataThroughService(facilityListRequest);
   	
   	/* FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl(); */
   	//facilityListSvcImpl.registerService(facilityListRequest);
   	/* FacilityListResponse facilityListResponse = (FacilityListResponse) facilityListServiceInvoker
   			.getDataThroughWebService(facilityListRequest);  */
   	/* FacilityListResponse facilityListResponse = facilityListSvcImpl.getFacilityList(facilityListRequest); */
	   	
   	
   %>   
    <!-- #header-->
   
    <!-- #logo And Menu -->

<div id="logomenu">
	<div class="row">	
    	<div id="logo">
        <img src="../../images/logo.png"> 
        </div>
        
        <div id="Menubox">
			<ul class="menu">
				<li><a href="../Contact.jsp"><div class="menuicons"><img src="../../images/Contact.png"/></div>Contact</a></li>
                <li class="menuselect"><div class="menuicons"><img src="../../images/Results.png"/></div>My Results</a></li>
                <li><a href="../schedule/UpcomingAppointments.jsp"><div class="menuicons"><img src="../../images/Appointment.png"/></div>My Appointments</a></li>
                <li><a href="../PortalHome.jsp" ><div class="menuicons"><img src="../../images/Home.png"/></div>Home</a></li>
                 <!--   <li><a href="#">Contact</a></li>
                  <li><a href="#">Faq's</a></li>
                  <li><a href="#">Settings</a></li>
                  <li><a href="#">About Us</a></li>
                  <li  class="menuselect">My Results</li>
                  <li><a href="#">My Appointments</a></li>
                  <li><a href="../PortalHome.jsp">Home</a></li>-->
            </ul>
        </div>
        
    </div>
</div>
</div>

<div class="line"></div>
   <!-- #logo And Menu -->
   

<form id="searchForm" name="searchForm" id="searchForm" method="POST" action="">

 <!-- #Content Area       **********************************************        -->
 <div id="detailedresultcontent">
 <div id="contentbg">
		</div>
 <div id="contentArea">
 <div id="contentArearow">
 <div>
 
 <div id="innercontentExpanded">
	<div class="row">
		<div class="cell">
			<div class="resulttableExpanded">
 			<div class="innerrow">
				<span class="AppointmentNewDoctor">Search Results</span>
			</div>
			<br/>
			<div class="innerrow">
				<div id="searcharea">
 				<span><a onclick="searchResults()"  class="btn">Search</a></span>
					<input name="<%=ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY%>" id="<%=ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY%>"
					id="<%=ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY%>" 
					type="text" class="textboxresult" placeholder="OrderNo" title="OrderNo" value="<%=orderNumber%>">
				<select class="Comboboxresult" id="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY%>">
					<%
						if ("".equalsIgnoreCase(orderCatalogue.trim())) {
					%>
					   <option value="" selected="selected">----Select Facility----</option>	
					  <%
						  	} else {
						  %>
					  <option value="">----Select Facility----</option>
					  <%
					  	}
					  	/* ErrorInfo facilityListErrorInfo = facilityListResponse
					  			.getErrorInfo(); */
					  	List<Facility> facilityList = null;
					  	// if facilities are obtained successfully, show them		
					  	/* if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) { */
					  	if (facilityListResponse.isSuccessful()) {	
					  		facilityList = facilityListResponse.getFacilityList();
					  		for (Facility facility : facilityList) {
					  			if (orderCatalogue.equalsIgnoreCase(facility
					  					.getFacilityId())) {
					  %>
	                  <option value="<%=facility.getFacilityId()%>" selected="selected"><%=facility.getFacilityName()%></option>
	                  <%
	                  	} else {
	                  %>
	                  <option value="<%=facility.getFacilityId()%>"><%=facility.getFacilityName()%></option>
					  <%
					  	}
					  		}
					  	}
					  %>			
                </select>
				
				<select class="Comboboxresult" id="<%=ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY%>">
					<%
						if (ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY
								.equalsIgnoreCase(orderCategory)) {
					%> 	
					  <option value="">---Select Category---</option>						
	                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY%>" selected="selected">Lab Order</option>
	                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY%>">Radiology</option>
	                  <%
	                  	} else if(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY.equalsIgnoreCase(orderCategory)){
	                  %>
	                  <option value="">---Select Category---</option>
	                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY%>">Lab Order</option>
	                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY%>" selected="selected">Radiology</option>
	                  <%
	                  	}else{
	                  %>
	                  <option value="" selected="selected">---Select Category---</option>
	                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY%>">Lab Order</option>
	                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY%>">Radiology</option>
	                  <%
	                  	}
	                  %>
	             </select>  	
	            
	            <span>From</span>     
				<input id="fromDatePicker" value="<%=kendoFromDateString%>" style="width:180px;" />
				<span>To</span>
         		<input id="toDatePicker" value="<%=kendoToDateString%>" style="width:180px;"/>
				
			</div>
		</div>
		<br/>
		
		
		<%
			ErrorInfo resultsErrorInfo = detailedResultsResponse.getErrorInfo();
			List<DetailedResult> detailedResultList = detailedResultsResponse
					.getTestResultList();
			// set the list size to the resultCount var
			resultCount = 0;//detailedResultList.size();
			// get the size of the test results - there is no need to check for
			resultCount = detailedResultList != null?detailedResultList.size():0;
			if ((ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
					.equalsIgnoreCase(initialResetValue))
					&& (detailedResultsResponse.isSuccessful())){
				StringBuffer displayInitialMesgBuffer = new StringBuffer();
				displayInitialMesgBuffer.append("Showing ");
				displayInitialMesgBuffer.append(""+resultCount+" records for display. Please select appropriate filters and perform search.");
				//detailedResultsResponse.getTestResultList()
				//String displayInitialMessage = "Showing 4 records for display. Please select appropriate filters and perform search.";
		%>
		<div class="innerrow">
		 <div id="initialMessageDiv" style="margin-left:30px; width:99%;height:20px;border:1px #cccccc solid;display:table-cell;">
			<!-- <table style="width:95%;border:1px #cccccc solid;">
			 <tr>
			 	<td width="100%"> -->
				<span style="color:#333333;font-size:12px;font-weight:bold;">
			 <%=displayInitialMesgBuffer.toString()%>	
				</span>
				<!-- </td>
			  </tr>
			</table>  --> 	
		</div>
		</div>
			<%
				}
			%>
		
		<div class="innerrow" style="overflow: auto;">
   			<div id="DetailedResultarea">	
   			
   			 <%
	   			   	String errorMessage = null;//resultsErrorInfo.getErrorMessage();
	   			   	/* if (ErrorInfo.SUCCESS_CODE != resultsErrorInfo.getErrorCode()) { */
	   			   	if(!detailedResultsResponse.isSuccessful()){
	   			   		errorMessage = detailedResultsResponse.getErrorMessage();	
	   		  %>
	   		   <p>   
			   <span class="loginerror" style="padding-left: 10px;">
		       <%
		       	out.println(errorMessage);
		       %>
		        </span>
		        </p>
	   			<%
	   				} else {
	   					ResultStatus resultStatus = null;

	   					int counter = 1;
	   					String ordCategory = null;
	   					String imageId = null;
	   					// these vars are used for manipulating the style
	   					// needed for showing GUI elements
	   					String divDisableStyle = "display:block";
	   					String orderCatalogueStyle = "AppointmentNewDoctor";
	   					String practitionerStyle = "AppointmentNewDoctor";
	   					String orderNumberStyle = "contenbold";
	   					String orderNumberLabelStyle = "contenbold";
	   					String resultTypeStyle = "contenbold";
	   					String resultTypeLabelStyle = "contenbold";
	   					String locationStyle = "contenbold";
	   					String locationLabelStyle = "contenbold";
	   					String orderDateStyle = "contenbold";
	   					String orderDateLabelStyle = "contenbold";
	   					// this var will store the style class
	   					// used for showing the result
	   					String stripBoxStyle = "detailedresultstripbox";
	   					final String TESTRESULTID = "testresult";
		   				String resultStripBoxId = null;
		   				final String VIEWRESULTBUTTONID = "viewresultbtn";
		   				String viewResultBtnId = null;
		   				final String POPUPRESULTDIVID = "popupdiv";
		   				String popupResultDivId = null;
		   				final String POPUPRESULTCONTAINERDIVID = "popupcontainerdiv";
		   				String popupContainerDivId = null;
		   				
						// iterate through the results and show them
	   					for (DetailedResult detailedResult : detailedResultList) {
	   						stripBoxStyle = "detailedresultstripbox";
	   						resultStripBoxId = TESTRESULTID;
	   						viewResultBtnId = VIEWRESULTBUTTONID;
	   						popupResultDivId = POPUPRESULTDIVID;
	   						popupContainerDivId = POPUPRESULTCONTAINERDIVID;
	   						if (counter > currentResultCounter) {
	   							divDisableStyle = "display:none";
	   						}

	   						resultStatus = detailedResult.getResultStatus();
	   						if (ResultStatus.COMPLETED == resultStatus) {
	   							stripBoxStyle = "detailedresultstripboxwithresultselected";
	   						}
	   						
	   						resultStripBoxId += counter;
	   			%>  
   				
				<div class="<%=stripBoxStyle %>" id="result<%=counter%>"  style="<%=divDisableStyle%>">
					<div class="row" width="100%">
					<!-- Stripicon-->
				        <div id="StripSpaceA">
				        	<%
				        		ordCategory = detailedResult.getOrderCategory();
				        				imageId = "radiology.png";
				        				if ((ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY
				        						.equalsIgnoreCase(ordCategory))
				        						|| (ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_ALT_MEDIUM_KEY
				        								.equalsIgnoreCase(ordCategory))) {
				        					imageId = "lab.png";
				        				}
				        	%>
				           <div id="Resulticon">
								<img src="../../images/<%=imageId%>"/>
							</div>
				        </div>
				         <!-- Stripcontent-->
				        <div id="StripSpaceB">
				            <p><span class="<%=orderCatalogueStyle%>"><%=detailedResult.getOrderCatalogue()%></span><span class="<%=practitionerStyle%>"> by <%=detailedResult.getOrderPractitioner()%></span></p>
				            <p> 
				                    <div class="floatleft resultdetail"><span class="<%=orderNumberLabelStyle%>">Order No : </span><span class="<%=orderNumberStyle%>"><%=detailedResult.getOrderNumber()%> </span></div>
				                    <div class="floatleft resultdetail"><span class="<%=resultTypeLabelStyle%>">Result Type : </span><span class="<%=resultTypeStyle%>"><%=detailedResult.getOrderCategory()%> </span></div>
									<div class="floatleft resultLocdetail"><span class="<%=locationLabelStyle%>">Location : </span><span class="<%=locationStyle%>"><%=detailedResult.getLocation()%> </span></div>
				                    
				            </p>
				            <p> <span class="<%=orderDateStyle%>"><%=detailedResult.getDisplayOrderDateValue()%> at <%=detailedResult.getDisplayOrderTimeValue()%></span><img class="printPDF" src="../../images/PDF.png"> <img class="printPDF" src="../../images/print.png"></p>
				        </div>
				        
				        <div id="StripSpaceD">
						    <%
						    	if (ResultStatus.COMPLETED == resultStatus) {
						    		viewResultBtnId += counter;
						    		popupResultDivId += counter;
						    		popupContainerDivId += counter;
						    %>
				           <%-- <span><a href="#" onclick="showResult('<%=detailedResult.getOrderCatalogue()%>','<%=detailedResult.getOrderNumber()%>','<%=detailedResult.getOrderCategory()%>','<%=detailedResult.getOrderDate()%>')" class="btn">View&nbsp;Results</a></span> --%>
				           <span><a id="<%=viewResultBtnId %>" onclick="showTestResult('<%=detailedResult.getOrderNumber()%>','<%=detailedResult.getOrderCatalogue()%>','<%=detailedResult.getOrderCategory()%>','<%=detailedResult.getOrderDate()%>','<%=counter %>','<%=viewResultBtnId %>')" class="btn">View&nbsp;Results</a></span>
				           	<%
				           		} else {
				           	%>
				           	<span><a href="#"  class="disabled">In&nbsp;Progress</a></span>
				           	<%
				           		}
				           	%>
				        
				           <!--  <span><a href="Resultpopup.html" target="_blank"  class="UpcomingAppbtn">View&nbsp;Results</a></span>-->
				        </div>
				
					</div>
				</div>	
				
				 <%
					   if (ResultStatus.COMPLETED == resultStatus) {
						   //resultStripBoxId +=  counter;
						   TestResultCacheManager cacheMgr = TestResultCacheManager.getInstance();
						   cacheMgr.addOrderToPatient(patientId, detailedResult.getOrderNumber());
						   String orderDateString = detailedResult.getOrderDate() + "";
						   //String pageSrc = "./GetTestResult.jsp?orderId="+detailedResult.getOrderNumber()+"&order="+detailedResult.getOrderCatalogue()+"&resultType="+detailedResult.getOrderCategory()+"&orderDate="+order+"&counter="+counter+"&popup=N";
				  %>
				  <!--INLINE POP UP RESULT ---->
				<div class="detailedresultstripboxwithresult" id="<%=resultStripBoxId%>" style="display:none;min-height: 330px;">
					
				</div>
				<!--INLINE POP UP RESULT ---- >
				
				<!-- popup result -->
				<div id="<%=popupContainerDivId %>" class="popupContainerStyle"  style="visibility: hidden;">
					<div id="<%=popupResultDivId %>" class="popupResultContentStyle"  style="visibility: hidden;">
					</div>
				</div>
				
				
				<!--  Result Box01 -->
				<%
					   }
					counter++;
						if (counter > 0) {
							orderCatalogueStyle = "AppointmentNewDoctorNormal";
							practitionerStyle = "AppointmentNewDoctorNormal";
							orderNumberStyle = "contentnormal";
							orderNumberLabelStyle = "contentnormal";
							resultTypeStyle = "contentnormal";
							resultTypeLabelStyle = "contentnormal";
							locationStyle = "contentnormal";
							locationLabelStyle = "contentnormal";
							orderDateStyle = "contentnormal";
							orderDateLabelStyle = "contentnormal";
						}

						}// end of for loop
					}
				%>
				
			</div>
  		</div>
  		<br>
  		<%
  			if (resultCount > resultCounter) {
  		%>	
		 <div class="innerrow" id="moreResultDiv">
   		 	<div id="MoreResult">
   		 		<span><a onclick="showMoreResults()" class="moreresultsbtn" >Click for more 
   		 		</a></span>
   		 	</div>
		</div>		
		
		<%
			}
		%>
		
		</div>
		</div>
	</div>
	</div>
	</div>
	</div> 
</div>
       <!-- #Content Area-->
        
	</div>
    <!-- #content-->		
				
				

  
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY%>" value="<%=currentResultCounter%>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY%>" value="<%=resultCount%>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY%>" value="<%=resultCounter%>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY%>" value="<%=kendoFromDateString%>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY%>" value="<%=kendoToDateString%>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY%>" value="<%=initialResetValue%>"/>
</form>  
  
  <!-- <div id="testdivstyle"> Test div </div> -->
  <%
  	String footerMarginStyle = "margin-top: 10px;";
  	if (ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
  			.equalsIgnoreCase(initialResetValue)) {
  		footerMarginStyle = "margin-top: 20px;";
  	}
  %>
    <!-- #content-->
	<div class="Footerbg"  style="<%=footerMarginStyle%>">
        <div id="poweredby">
       	 <p class="poweredby">Powered by <img src="../../images/csc.png" width="25" height="14"></p>
        </div>
	</div>
</div> <!--  wrapper -->

</body>
</html>

