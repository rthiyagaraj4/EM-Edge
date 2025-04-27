<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.result.viewresult.TestResultCache"%>
<%@page import="portalrefimpl.result.viewresult.TestResultCacheManager"%>
<%@page import="portalrefimpl.result.viewresult.response.TestResult"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.result.viewresult.response.TestResultResponse"%>
<%@page import="portalrefimpl.result.viewresult.svc.TestResultServiceInvoker"%>
<%@page import="portalrefimpl.common.serviceinvoker.ServiceInvoker"%>
<%@page import="portalrefimpl.result.viewresult.request.TestResultRequest"%>
<%@page import="portalrefimpl.result.ResultConstants"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="keywords" content="" />
<meta name="description" content="" />
<title>::: Patient Portal</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>
<script src="../../js/jquery.min.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
$(document).ready(function() {
	loadResult();
});
function loadResult(){
	var hdnOrderId = document.getElementById("hdnOrderId");
	var orderId = "";
	var escapedOrderId = "";
	if(hdnOrderId){
		orderId = hdnOrderId.value;
		escapedOrderId = escape(orderId);
	}
	var hdnOrder = document.getElementById("hdnOrder");
	var order = "";
	var escapedOrder = "";
	if(hdnOrder){
		order = hdnOrder.value;
		escapedOrder = escape(order);
	}
	var hdnOrderDate = document.getElementById("hdnOrderDate");
	var orderDate = "";
	var escapedOrderDate = "";
	if(hdnOrderDate){
		orderDate = hdnOrderDate.value;
		escapedOrderDate = escape(orderDate);
	}
	var hdnResultType = document.getElementById("hdnResultType");
	var resultType = "";
	var escapedResultType = "";
	if(hdnResultType){
		resultType = hdnResultType.value;
		escapedResultType = escape(resultType);
	}
	var hdnCounter = document.getElementById("hdnCounter");
	var counter = "";
	var counterInt;
	if(hdnCounter){
		counter = hdnCounter.value;
		counterInt = getIntValue(counter,0);
		counterInt += 1000;
	}
	
	var xmlHttp = getHttpObject();
 	xmlHttp.onreadystatechange=function(){
 		if(xmlHttp.readyState==4 && xmlHttp.status==200){
 			var responseText = xmlHttp.responseText;
 			$('#resultContainer').html(responseText);
 			
 			//$('#testresult'+counter).css('display','block');
 			//$('#'+viewResultAnchorId).html("Hide&nbsp;Results");
 		}
 	 };
 	xmlHttp.open("POST", "./GetTestResult.jsp", true);
 	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
 	var parameters = 'orderId='+escapedOrderId+'&order='+escapedOrder+'&resultType='+escapedResultType+'&orderDate='+escapedOrderDate+'&counter='+counterInt+'&popup=Y';
 	xmlHttp.send(parameters);
	
	//alert(escapedOrderId+' || '+escapedOrder+' || '+escapedResultType+' || '+escapedOrderDate+' || '+counter);
	/* var divElement = document.getElementById("resultContainer");
	if(divElement){
		divElement.load('./GetTestResult.jsp?orderId='+escapedOrderId+'&order='+escapedOrder+'&resultType='+escapedResultType+'&orderDate='+escapedOrderDate+'&counter='+counter+'&popup=Y');
	} */
	
	//$('#resultContainer').html('test');
	//$('#resultContainer').load('./GetTestResult.jsp?orderId='+escapedOrderId+'&order='+escapedOrder+'&resultType='+escapedResultType+'&orderDate='+escapedOrderDate+'&counter='+counter+'&popup=Y');
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

function getIntValue(stringValue,defaultValue){
	// this function converts the string value to an integer value
	var intVal = defaultValue;
	try{
		intVal = parseInt(stringValue);	
	}catch(e){
		intVal = defaultValue;
	}
	return intVal;
}

</script>

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

	String orderId = "";
	orderId = request
			.getParameter(ResultConstants.TESTRESULT_ORDERID_REQUEST_PARAM_KEY);
	if (orderId == null) {
		orderId = "";
	}

	String order = "";
	order = request
			.getParameter(ResultConstants.TESTRESULT_ORDER_REQUEST_PARAM_KEY);
	if (order == null) {
		order = "";
	}

	String resultType = "";
	resultType = request
			.getParameter(ResultConstants.TESTRESULT_RESULTTYPE_REQUEST_PARAM_KEY);
	if (resultType == null) {
		resultType = "";
	}
	
	String orderDate = request
			.getParameter(ResultConstants.TESTRESULT_ORDERDATE_REQUEST_PARAM_KEY);
	if(orderDate == null){
		orderDate = "";
	}
	
	String counterStr = request.getParameter("counter");
	int counterVal = PortalHelper.getIntegerValue(counterStr, 0);
	
%>

<div id="popwrapper">
	
<div id="popheader">
<div class="row">
		<div id="poptitle">View Results
        </div>
         
		<div id="close" onclick="closeResultPopup('<%=counterVal%>')">x
        </div>
    
</div>
</div>
<%
/* 	TestResultRequest testResultRequest = new TestResultRequest();
	testResultRequest.setPatientId(patientId);
	testResultRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	testResultRequest.setOrder(order);
	testResultRequest.setOrderNumber(orderId);
	testResultRequest.setResultType(resultType);

	TestResultSvcImpl testResultSvcImpl = new TestResultSvcImpl();
	testResultSvcImpl.registerService(testResultRequest);

	ServiceInvoker testResultServiceInvoker = new TestResultServiceInvoker();
	TestResultResponse testResultResponse = (TestResultResponse) testResultServiceInvoker
			.getDataThroughWebService(testResultRequest); */
	
	TestResultCacheManager cacheMgr = TestResultCacheManager.getInstance();
	TestResultCache testResultCache = cacheMgr.getTestResultsForPatient(patientId, orderId);		
			

	String responseOrder = "";
	String responseOrderId = "";
	String responseResultType = "";
	String responsePublishedDateString = "";
	Date responsePublishDate = null;

	String errorMessage = "";
	// creating a local var just for efficiency sake
	boolean testResultObtained = testResultCache.isSuccessful();
	//ErrorInfo errorInfo = testResultResponse.getErrorInfo();
	//int errorCode = errorInfo.getErrorCode();
	// check if the response has errors - in this case we have to high light the same
	/* if (ErrorInfo.SUCCESS_CODE != errorCode) { */
		
	// this is the common data about order which we can obtain
	// from the request values itself
	responseOrder = order;
	responseOrderId = orderId;
	responseResultType = resultType;
	responsePublishedDateString = orderDate;
	// now check if the test results are obtained
	// if so, get the published date
	if (!testResultObtained) {
		//errorMessage = errorInfo.getErrorMessage();
		// get the error messae
		errorMessage = testResultCache.getErrorMessage();
		
		responsePublishDate = PortalHelper.getDateFromString(
				responsePublishedDateString,
				ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
		if (responsePublishDate != null) {
			responsePublishedDateString = PortalHelper
					.getDateAsString(
							responsePublishDate,
							ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
			if (responsePublishedDateString == null) {
				responsePublishedDateString = "";
			}
		}
	}else{
		// success scenario - get the overall publish
		// date from the test result cache
		
		/* responseOrder = testResultResponse.getOrder();
		responseOrderId = testResultResponse.getOrderNumber();
		responseResultType = testResultResponse.getResultType(); */
		/* responsePublishDate = testResultResponse.getPublishDate(); */
		responsePublishDate = testResultCache.getOverallPublishDate();
		if (responsePublishDate != null) {
			responsePublishedDateString = PortalHelper
					.getDateAsString(
							responsePublishDate,
							ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
			if (responsePublishedDateString == null) {
				responsePublishedDateString = "";
			}
		}
	}
	
	
%>

<!--  <div style="width:99%;height:430px;border: 1px solid #92b82d;background-color:#ffffff;display:table;margin: 2px;"><!--  id="popmsgbox"> 
-->
<div id="resulthearder" style="width:99%;border: 1px solid #92b82d;margin: 2px;">
	<div class="row">
    	
        <div id="resultcell">
        	<span class="contentfontbold">Order No</span><br />
        	<span class="contentfont"><%=responseOrderId%></span>
        </div>
        <div id="resultcell">
	        <span class="contentfontbold">Result Type</span><br />
    	   	<span class="contentfont"><%=responseResultType%></span>
        </div>
        <div id="resultcell">
           <span class="contentfontbold">Order</span><br />
    	   	<span class="contentfont"><%=responseOrder%> </span>
          
        </div>
        <div id="resultcell">
          
           <span class="contentfontbold">Reported Date & Time</span><br />
    	   	<span class="contentfont"><%=responsePublishedDateString%></span>
        </div>
        
    </div>
    

</div>

<%
	if (!testResultObtained) {
%>
<div>
 <span class="loginerror">
 <%
 	out.println(errorMessage);
 %>
 </span>
</div>
<%
	} else {
		String pageSrc = "./GetTestResult.jsp?orderId="+orderId+"&order="+order+"&resultType="+resultType+"&orderDate="+orderDate+"&counter="+(counterVal+1000)+"&popup=Y";
%>

<div id="resultContainer" style="overflow: auto;overflow-x : hidden;height:90%;width:99%;margin: 1px;">
<%-- <iframe src="<%=pageSrc %>" frameborder="0" scrolling="yes" width="100%" height="360px"></iframe> --%>
</div>
<%
	}
%>

<input type="hidden" id="hdnOrderId" name="hdnOrderId" id="hdnOrderId" value="<%=orderId %>">
<input type="hidden" id="hdnOrder" name="hdnOrder" id="hdnOrder" value="<%=order %>">
<input type="hidden" id="hdnResultType" name="hdnResultType" id="hdnResultType" value="<%=resultType %>">
<input type="hidden" id="hdnOrderDate" name="hdnOrderDate" id="hdnOrderDate" value="<%=orderDate %>">
<input type="hidden" id="hdnCounter" name="hdnCounter" id="hdnCounter" value="<%=counterVal %>">

</div>

</body>
</html>

