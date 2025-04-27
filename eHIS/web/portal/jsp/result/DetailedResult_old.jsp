<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.Calendar"%>
<%@page import="portalrefimpl.result.ResultConstants"%>
<%@page import="portalrefimpl.common.model.Facility"%>
<%@page import="portalrefimpl.result.detailedresult.response.ResultStatus"%>
<%@page import="portalrefimpl.result.detailedresult.response.DetailedResult"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.facility.facilityforpatient.response.FacilityListResponse"%>
<%@page import="portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker"%>
<%@page import="portalrefimpl.facility.facilityforpatient.svc.FacilityListSvcImpl"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.facility.facilityforpatient.request.FacilityListRequest"%>
<%@page import="portalrefimpl.result.detailedresult.response.DetailedResultsResponse"%>
<%@page import="portalrefimpl.result.detailedresult.svc.DetailedResultsSvcImpl"%>
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
		  var fromDateEle = document.getElementById("fromDatePicker");
		  var fromDateHiddenElem = document.getElementById("fromDate");
		  var fromdatepicker = $("#fromDatePicker").data("kendoDatePicker");
		  var fromDateObj;
		  if(fromDateEle && fromDateHiddenElem){
			 // alert('both from date elements are valid ');
			 fromDateObj = new Date(fromdatepicker.value());
			 fromDateHiddenElem.value = fromDateObj.toString("MM/dd/yyyy");
			 //alert(fromDateObj+' '+fromDateObj.toString("MM/dd/yyyy"));
			 //alert(fromdatepicker.value());
		  }
		  
		  var toDateEle = document.getElementById("toDatePicker");
		  var toDateHiddenElem = document.getElementById("toDate");
		  var todatepicker = $("#toDatePicker").data("kendoDatePicker");
		  var toDateObj;
		  if(toDateEle && toDateHiddenElem){
			  //alert('both to date elements are valid');
			  toDateObj = new Date(todatepicker.value());
			  toDateHiddenElem.value = toDateObj.toString("MM/dd/yyyy");
			  //alert(toDateObj+' '+toDateObj.toString("MM/dd/yyyy"));
			  //alert(todatepicker.value());
		  }
		  //var userName = document.getElementById("name").value;
		  //formElement.action = "../jsp/PatientPortalHome.jsp?patientId="+userName+"&useWebService=Y";
		  //formElement.action = "../servlet/LoginServlet?patientId="+userName+"&useWebService=Y";
		  formElement.submit();
	  }
}

function showMoreResults(){
	var currentResultCounterComp = document.getElementById("resultCounter");
	var currentResultCounter;
	if(currentResultCounterComp){
		currentResultCounter = currentResultCounterComp.value;
	}
	var currentResultCounterInt = parseInt(currentResultCounter);
	var resultCountComp = document.getElementById("resultCount");
	var resultCount;
	if(resultCountComp){
		resultCount = resultCountComp.value;
	}
	var resultCountInt = parseInt(resultCount);
	
	var recordViewCountComp = document.getElementById("DetailedTestResultsRowCount")
	var recordViewCount;
	if(recordViewCountComp){
		recordViewCount = recordViewCountComp.value;
	}
	var recordViewCountInt = parseInt(recordViewCount);
	
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
	
	currentResultCounterComp.value = ""+iterationEndValue;
	
}

function showResult(orderCatalogue,orderId,resultType){
	var url = './ViewResult.jsp?orderId='+orderId+'&order='+orderCatalogue+'&resultType='+resultType;
	var winLeft = (screen.width - 795)/2;
	var winTop = (screen.height - 495)/2;
	var popupWindow = window.open(url,'Test Result','height=495,width=795,top='+winTop+',left='+winLeft+',resizable=no,scrollbars=no,toolbar=no,menubar=no,location=no,directories=no,addressbar=no,status=no,titlebar=no');
}

$(document).ready(function() {
    // create DatePicker from input HTML element
    $("#fromDatePicker").kendoDatePicker();
    $("#toDatePicker").kendoDatePicker();
});

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
		orderCategory = ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY;
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
	fromCalendar.set(Calendar.MONTH, -1);
	if (kendoFromDateString == null) {
		fromDateString = PortalHelper.getDateAsString(
				fromCalendar.getTime(),
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);
		kendoFromDateString = PortalHelper.getDateAsString(
				fromCalendar.getTime(),ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		//fromDateString = "28/11/2012";
	}else{
		fromDateObj = PortalHelper.getDateFromString(kendoFromDateString, ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		if(fromDateObj == null){
			fromDateObj = fromCalendar.getTime();
			kendoFromDateString = PortalHelper.getDateAsString(
					fromDateObj,ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		}else{
			fromCalendar.setTime(fromDateObj);
		}
		fromDateString = PortalHelper.getDateAsString(
				fromDateObj,
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);
	}

	String kendoToDateString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY); 
	String toDateString = kendoToDateString;
	Date toDateObj = new Date();
	if (kendoToDateString == null) {
		kendoToDateString =  PortalHelper.getDateAsString(
				toDateObj,ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		/* toDateString = PortalHelper.getDateAsString(toDateObj,
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT); */
		//toDateString = "27/12/2012";
	}
	toDateString = PortalHelper.getDateAsString(toDateObj,
			ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);

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

	final int TOTALRECORD_COUNT = 7;
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

<div id="wrapper">
	
<header id="header">
    	<div id="headerinfo">
        	<div class="row">
        		<div id="headervisitinfo">
                	Welcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM 
                </div>    
               <div id="headerloginas">
                	 Welcome, <%=patientName%>,
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

   	DetailedResultsSvcImpl detailedSvc = new DetailedResultsSvcImpl();
   	detailedSvc.registerService(resultsRequest);

   	ServiceInvoker detailedResultsServiceInvoker = new DetailedResultsServiceInvoker();
   	DetailedResultsResponse detailedResultsResponse = (DetailedResultsResponse) detailedResultsServiceInvoker
   			.getDataThroughWebService(resultsRequest);

   	FacilityListRequest facilityListRequest = new FacilityListRequest();
   	facilityListRequest
   			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

   	FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl();
   	facilityListSvcImpl.registerService(facilityListRequest);

   	ServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
   	FacilityListResponse facilityListResponse = (FacilityListResponse) facilityListServiceInvoker
   			.getDataThroughWebService(facilityListRequest);
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
                  <li><a href="#">Contact</a></li>
                  <li><a href="#">Faq's</a></li>
                  <li><a href="#">Settings</a></li>
                  <li><a href="#">About Us</a></li>
                  <li  class="menuselect">My Results</li>
                  <li><a href="#">My Appointments</a></li>
                  <li><a href="../PortalHome.jsp">Home</a></li>
            </ul>
        </div>
        
    </div>
</div>
<div class="line"></div>
   <!-- #logo And Menu -->
   

<form id="searchForm" name="searchForm" id="searchForm" method="POST" action="">

 <!-- #Content Area       **********************************************        -->
<div id="innercontent">
	<div class="row">
    	<div class="cell">
        	<div	 class="resulttable">
<!-- SEARCH ------->
    <div class="innerrow">
    <span class="AppointmentNewDoctor">Search Results</span>
	</div>
<br>

  
  <div class="innerrow">
  
            <div id="searcharea">
              <span><a href="#" onclick="searchResults()" class="btn">Search</a></span> 
              <input name="<%=ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY%>" id="<%=ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY%>"
										id="<%=ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY%>"
										type="text" class="textboxsearch" placeholder="Order No" value="<%=orderNumber%>">
				<select id="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY%>" class="textboxsearch" >
				<%
					if ("".equalsIgnoreCase(orderCatalogue.trim())) {
				%>
				   <option value="">----Select----</option>	
				  <%
					  	} else {
					  %>
				  <option value="" selected="selected">----Select----</option>
				  <%
				  	}
				  	ErrorInfo facilityListErrorInfo = facilityListResponse
				  			.getErrorInfo();
				  	List<Facility> facilityList = null;
				  	if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) {
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
                <select id="<%=ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY%>" class="textboxsearch" >
                  <%
                  	if (ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY
                  			.equalsIgnoreCase(orderCategory)) {
                  %> 	
                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY%>" selected="selected">Lab Order</option>
                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY%>">Radiology</option>
                  <%
                  	} else {
                  %>
                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY%>">Lab Order</option>
                  <option value="<%=ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY%>" selected="selected">Radiology</option>
                  <%
                  	}
                  %> 
                </select>
                
         		<input id="fromDatePicker" value="<%=kendoFromDateString %>" style="width:180px;" />
         		<input id="toDatePicker" value="<%=kendoToDateString %>" style="width:180px;"/>
            </div>
    </div>
    
    
    
	
<br>
     <div class="innerrow">
     
   <div id="Resultarea">
      
   <%
         	ErrorInfo resultsErrorInfo = detailedResultsResponse.getErrorInfo();
         	String errorMessage = resultsErrorInfo.getErrorMessage();
         	if (ErrorInfo.SUCCESS_CODE != resultsErrorInfo.getErrorCode()) {
         %>   
	   <span class="loginerror">
       <%
       	out.println(errorMessage);
       %>
        </span>
        <%
        	} else {
        		List<DetailedResult> detailedResultList = detailedResultsResponse
        				.getTestResultList();
        		// set the list size to the resultCount var
        		resultCount = detailedResultList.size();

        		ResultStatus resultStatus = null;

        		int counter = 1;
        		String ordCategory = null;
        		String imageId = null;
        		String divDisableStyle = "display:block";
        		for (DetailedResult detailedResult : detailedResultList) {
        			if (counter > currentResultCounter) {
        				divDisableStyle = "display:none";
        			}

        			resultStatus = detailedResult.getResultStatus();
        %>  
      
<!--  Result Box01 -->
<div id="result<%=counter%>" class="stripbox" style="<%=divDisableStyle%>">
	<div class="row">
	<!-- Stripicon-->
        <div id="StripSpaceA">
        	<%
        		ordCategory = detailedResult.getOrderCategory();
        				imageId = "Resultrio";
        				if (ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY
        						.equalsIgnoreCase(ordCategory)) {
        					imageId = "Resultlab";
        				}
        	%>
            <div id='<%=imageId%>'>
            </div>
        </div>
                             <!-- Stripcontent-->
        <div id="StripSpaceB">
            <p><span class="AppointmentNewDoctor"><%=detailedResult.getOrderCatalogue()%></span><span class="contenbold"> by <%=detailedResult.getOrderPractitioner()%></span></p>
            <p> 
                    <span class="contentfontbold">Order No :</span><span class="contentfont"><%=detailedResult.getOrderNumber()%> |</span>
                    <span class="contentfontbold">Location : </span><span class="contentfont"><%=detailedResult.getLocation()%>  |</span>
                    <span class="contentfontbold">Result Type : </span><span class="contentfont"><%=detailedResult.getOrderCategory()%> </span>
            </p>
            <p> <span class="ResultDate"><%=detailedResult.getOrderDate() %> at 11:26pm</span><img src="../../images/PDF.png"> <img src="../../images/print.png"></p>
        </div>
        
        <div id="StripSpaceD">
        	<%
        		if (ResultStatus.COMPLETED == resultStatus) {
        	%>
           <span><a href="#" onclick="showResult('<%=detailedResult.getOrderCatalogue()%>','<%=detailedResult.getOrderNumber()%>','<%=detailedResult.getOrderCategory()%>')" class="btn">View&nbsp;Results</a></span>
           	<%
           		} else {
           	%>
           	<span><a href="#"  class="disabled">In&nbsp;Progress</a></span>
           	<%
           		}
           	%>
        </div>

	</div>
</div>
<!--  Result Box01 -->
<%
	counter++;
		}
	}
%>

</div>	
  </div><!--  end of result area div -->
<br>
    <div class="innerrow">
   		 <div id="MoreResult">
         	<span><a href="#" onclick="showMoreResults()">Click For More Results</a></span>
            </div>
	</div>

</div>
</div>
</div>


 <!-- #Content Area       **********************************************        -->
        
  </div>
  
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY%>" value="<%=currentResultCounter%>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY%>" value="<%=resultCount%>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY%>" name="<%=ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY%>" value="<%=resultCounter%>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY %>" name="<%=ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY %>" value="<%=kendoFromDateString %>"/>
  <input type="hidden" id="<%=ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY %>" name="<%=ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY %>" value="<%=kendoToDateString %>"/>
</form>  
  
    <!-- #content-->
<div class="PageFooterbg">
<div class="row">
	

        <div id="poweredby">
        <p class="poweredby">Powered by <img src="../../images/csc.png" width="25" height="14"></p>
        </div>
</div>
</div>
</div>

</body>
</html>

