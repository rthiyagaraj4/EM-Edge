<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="portalrefimpl.result.ResultConstants"%>
<%@page import="portalrefimpl.common.CommonConstants"%>
<%@page import="portalrefimpl.common.message.MessageContainer"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.result.viewresult.TestResultCache"%>
<%@page import="portalrefimpl.result.viewresult.response.TestResult"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.result.viewresult.TestResultCacheManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="keywords" content="" />
<meta name="description" content="" />
<script src="../../js/kendo.all.min.js"  type="text/javascript"></script>
<script src="../../js/ES_Kendo.js"  type="text/javascript"></script>
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>
<style type="text/css">
#StripSpaceresultpopupdialog
{
	width:100%;
	display:table-cell;
}

#popupwrapperrspage
{
	width:100%;
	height:358px;
	background-color:#ffffff;
	
}

#popupmsgboxresultpage
{
	width:100%;
	height:331px;
	background-color:#ffffff;
	display:table;
	position:relative;
}

#resultpopupdisplaypage
{
	height:299px;
	position:relative;
	overflow:auto;
}

</style>
</head>
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
	
	String orderId = request.getParameter("orderId");
	if(orderId == null){
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
	
	String popup = request.getParameter("popup");
	if(popup == null || popup.trim().equals("")){
		popup = "N";
	}
	
	TestResultCacheManager cacheMgr = TestResultCacheManager.getInstance();
	TestResultCache testResultCache = cacheMgr.getTestResultsForPatient(patientId, orderId);
	List<TestResult> testResultList = null;
	
	String errorMessage = "";
	
	String kendoDivId = ""+ counterVal;
%>

<div style="height:100%;width:100%;">

<%
if(testResultCache == null ){
	errorMessage = MessageContainer.getInstance().getDisplayMessage(CommonConstants.VIEWTESTRESULTS_MODULE_NAME, ResultConstants.TESTRESULT_DATA_NOTOBTAINED_ERRORCODE);
	errorMessage = MessageFormat.format(errorMessage, new Object[]{orderId});
%>
<span class="loginerror">
  <%
  	out.println(errorMessage);
  %>
</span>	
<%
}else{

	testResultList = testResultCache.getTestResultList();
	// no need to check for null
	/* ErrorInfo cacheErrorInfo = testResultCache.getErrorInfo(); */
	if(!testResultCache.hasExecuted()){
		errorMessage = MessageContainer.getInstance().getDisplayMessage(CommonConstants.VIEWTESTRESULTS_MODULE_NAME, ResultConstants.TESTRESULT_DATA_NOTOBTAINED_ERRORCODE);
		errorMessage = MessageFormat.format(errorMessage, new Object[]{orderId});
	%>
	<span class="loginerror">
	  <%
	  	out.println(errorMessage);
	  %>
	</span>

	<%
	}else{
		if(!testResultCache.isSuccessful()){
			// TODO need to get the error message
			/* errorMessage = "Could not obtain test result."; */	
			errorMessage = testResultCache.getErrorMessage();
	%>
	<span class="loginerror">
	  <%
	  	out.println(errorMessage);
	  %>
	</span>
			
	<%
		}else{
		
	
		String stripSpaceStyleId = "StripSpaceresultpop";
		String popupWrapperStyleId = "popwrapperrspage";
		String popupmsgboxStyleId = "popmsgboxresultpage";
		String resultpopupStyleId = "resultdisplaypage";
		if("Y".equalsIgnoreCase(popup)){
			stripSpaceStyleId = "StripSpaceresultpopupdialog";
			popupWrapperStyleId = "popupwrapperrspage";
			popupmsgboxStyleId = "popupmsgboxresultpage";
			resultpopupStyleId = "resultpopupdisplaypage";
			
			kendoDivId += "Popup";
		}
	%>
			<!-- Stripicon-->
		<div id="stripboxwithresult">
			<div class="row">
		        <div id="<%=stripSpaceStyleId%>">
		           <div id="<%=popupWrapperStyleId%>">
					<div id="resultpageheader">
					<div class="row">
		
						<div class="cell alignmiddle datacellresult"> 
							<span class="contenboldwhite">Results</span>
						</div>
						<%
						if(!("Y".equalsIgnoreCase(popup))){
						
						%>
						<div class="cell alignright datacellresults" > 
							<a onclick="showResultPopup('<%=order%>','<%=orderId%>','<%=resultType%>','<%=orderDate%>','<%=counterVal%>')"><img src="../../images/maxi.png"/></a>
							<!-- <a href="#" onclick="showResultPopup()"><img src="../../images/maxi.png"/></a> -->
						</div>
						<%
						}
						%>
					</div>
					</div>
					<div id="<%=popupmsgboxStyleId%>">
						<div id="<%=resultpopupStyleId%>">
						
						<!--  from here the results are to be shown -->
						<%
						String testResultDesc = "";
						//Date testResultPublishedDate = null;
						String testResultPublishedDateStr = "";
						String testResultPublishedTimeStr = "";
						String notesContent = "";
						String resultNumStr = "";
						String resultNumUOM = "";
						String normalLowStr = "";
						String normalHighStr = "";
						String criticalLowStr = "";
						String criticalHighStr = "";
						String resultStr = "";
						
						int resultNum = 0;
						int normalLow = 0;
						int normalHigh = 0;
						int criticalLow = 0;
						int criticalHigh = 0;
						
						String displayImage = null;
						
						final String DISPLAY_DATE_FORMAT = "MMM dd,yyyy";
						final String DISPLAY_TIME_FORMAT = "HH:mm";
						boolean resultBools[] = null;
						
						int counter = 1;
						
						for(TestResult testResult : testResultList){
							testResultDesc = testResult.getOrder();
							testResultPublishedDateStr = testResult.getDisplayPublishDate(DISPLAY_DATE_FORMAT);
							testResultPublishedTimeStr = testResult.getDisplayPublishTime(DISPLAY_TIME_FORMAT);
							/* testResultPublishedDate = testResult.getResultPublishDate();
							if (testResultPublishedDate != null) {
								testResultPublishedDateStr = PortalHelper
										.getDateAsString(
												testResultPublishedDate,
												ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
							} */
							notesContent = testResult.getNotesContent();
							
							// reset the image str
							displayImage = null;
						%>
							
							<div id="resultheaderpoppage">
								<div class="row">
									<div class="cell alignmiddle datacell" > 
										<span class="contenboldsetmargin"><%=testResultDesc %></span>
									</div>
									<div class="cell alignmiddle datecell">
										<span class="contenbold"><%=testResultPublishedDateStr %> at <%=testResultPublishedTimeStr %></span> 
									</div>
								</div>
							</div>
							<div class="row" style="width:100%;">
								<div class="cell alignmiddle" style="width:100%;"> 
									<%
										if(notesContent != null && !notesContent.trim().equals("")){
									%>
									<div  class="contennormalsetmargin">
									<%=notesContent %>
									</div>
									
									<%} %>
									
									
									
									<%
									resultNumStr = testResult.getResultValue();
									resultNum = PortalHelper.getIntegerValue(resultNumStr, 0);
									resultNumUOM = testResult.getResultUOM();
									
									normalLowStr = testResult.getNormalLowValue();
									normalLow = PortalHelper.getIntegerValue(normalLowStr, 0);
									
									normalHighStr = testResult.getNormalHighValue();
									normalHigh = PortalHelper.getIntegerValue(normalHighStr, 0);
									
									criticalLowStr = testResult.getCriticalLowValue();
									criticalLow = PortalHelper.getIntegerValue(criticalLowStr, 0);
									
									criticalHighStr = testResult.getCriticalHighValue();
									criticalHigh = PortalHelper.getIntegerValue(criticalHighStr, 0);
									
									if(criticalHigh < normalHigh){
										criticalHigh = normalHigh + new Double(Math.ceil((double)normalHigh/10)).intValue();//(normalHigh / 10);
										// just for safety sake
										if(criticalHigh == normalHigh){
											criticalHigh = criticalHigh + 1;
										}
									}
									
									if(normalLow < criticalLow){
										//normalLow = criticalLow;
										criticalLow = normalLow;
									}
									
									resultStr = testResult.getResultStrValue();
									
									resultBools = testResult.getResultBoolean();
									
									if(resultNumStr != null && !resultNumStr.trim().equals("")){
									%>
									<!--  need to put horizontal line -->
									<div style="width:98%;height:1px;margin-top:5px;margin-left:5px;margin-right: 5px;margin-bottom:5px;background-color: #333333;">
									</div>
									<div  class="contennormalsetmargin">
										<div class="cellindex alignmiddle resultcellicon" >
									<%
										if(resultBools[TestResult.CRITICAL_LOW_INDEX]){
											displayImage = "criticalLow.png";
										}
										if(resultBools[TestResult.LOW_INDEX]){
											displayImage = "lowval.png";
										}
										if(resultBools[TestResult.NORMAL_INDEX]){
											displayImage = "normal.png";
										}
										if(resultBools[TestResult.HIGH_INDEX]){
											displayImage = "highval.png";
										}
										if(resultBools[TestResult.CRITICAL_HIGH_INDEX]){
											displayImage = "criticalhigh.png";
										}
										if(resultBools[TestResult.CRITICAL_INDEX]){
											displayImage = "critical.png";
										}
										
										// show the display image										
										if(displayImage != null && !displayImage.trim().equals("")){
									%>
									<img class="imageresult" src="../../images/<%=displayImage%>"/>
									<%
										}
									%>
										<!-- display the result num -->
										<%=resultNumStr %>
										<%
										if(resultNumUOM != null && !resultNumUOM.trim().equals("")){
										%>
										&nbsp;<%=resultNumUOM %>
										
										<%
										}
										// now display the range
										if((normalLowStr != null && !normalLowStr.trim().equals("")) && (normalHighStr != null && !normalHighStr.trim().equals(""))){
										%>
										(<%=normalLowStr %> - <%=normalHighStr %>)									
									<%
										}
									%>
										</div>
									</div>
									<%	
									}
									%>
									
									<%
									// show result str now
									if(resultStr != null && !resultStr.trim().equals("")){
									%>
									<!--  horizontal line -->
									<div style="width:98%;height:1px;margin-top:5px;margin-left:5px;margin-right: 5px;margin-bottom:5px;background-color: #333333;">
									</div>
									<div class="resultpanel">
										<p><span class="resultnote">
										<%=resultStr %>
										</span></p>
									</div>
									
									<%
									}
									%>
									
									<!-- now the chart -->
									<%
										if(resultNumStr != null && !resultNumStr.trim().equals("")){							
											if(normalLow >= criticalLow && 
												normalHigh != 0 && criticalHigh != 0 
												&& criticalHigh > normalHigh){
										
							   			String divId = "kendodiv"+counter;
							   			
							   			kendoDivId = "kendodiv"+kendoDivId+counter;
							   			
							   			String lowColor = "8BBA00";
							   			String normalColor = "F6BD0F";
							   			String highColor = "FF654F";
							   			
							   			int maxUnit = new Double(Math.ceil((double)criticalHigh/5)).intValue();
							   			int minorUnit = new Double(Math.ceil((double)maxUnit/5)).intValue();
							   			
							   			String pageSrc = "./ES_Kendo_Linear.jsp?divID="+kendoDivId+"&xAxisMin="+criticalLow+"&xAxisMax="+criticalHigh+"&rCriticalLow="+criticalLow+"&rNormalLow="+normalLow+"&rLowColor="+lowColor+"&rNormalHigh="+normalHigh+"&rNormalColor="+normalColor+"&rCriticalHigh="+criticalHigh+"&rHighColor="+highColor+"&pValue="+resultNum+"&majorUnit="+maxUnit+"&minorUnit="+minorUnit;
						   			%>
						   			<!--  horizontal line -->
									<div style="width:98%;height:1px;margin-top:5px;margin-left:5px;margin-right: 5px;margin-bottom:5px;background-color: #333333;">
									</div>
	   								<jsp:include page="<%=pageSrc%>" />
									<%
											}
										}
									%>
									
								</div>
							</div>
							
						<%
							counter++;
						} // end of for loop
						%>
					</div>
					
					
					<div class="resultindicatorpage" >
						<div class="row" >
							<div class="cellindex alignmiddle resultcellicon"  >
								<img class="imageresult" src="../../images/highval.png"/>
							</div>
							<div class="cellindex alignmiddle" >
								<span class="contentnormal">High value</span>
							</div>
							<div class="cellindex alignmiddle resultcellicon" >
								<img class="imageresult"  src="../../images/lowval.png"/>
							</div>
							<div class="cellindex alignmiddle" >
								<span class="contentnormal">Low value</span>
							</div>
							<div class="cellindex alignmiddle resultcellicon" >
								<img class="imageresult" src="../../images/abnormal.png"/>
							</div>
							<div class="cellindex alignmiddle" >
								<span class="contentnormal">Abnormal value</span>
							</div>
							<div class="cellindex alignmiddle resultcellicon" >
								<img class="imageresult" src="../../images/critical.png"/>
							</div>
							<div class="cellindex alignmiddle " >
								<span class="contentnormal">Critical value</span>
							</div>
							<div class="cellindex alignmiddle resultcellicon" >
								<img class="imageresult"src="../../images/criticalhigh.png"/>
							</div>
							<div class="cellindex alignmiddle" >
								<span class="contentnormal">Critical high value</span>
							</div>
							<div class="cellindex alignmiddle resultcellicon" >
								<img class="imageresult" src="../../images/criticallow.png"/>
							</div>
							<div class="cellindex alignmiddle" >
								<span class="contentnormal">Critical low value</span>
							</div>
							<div class="cellindex alignmiddle resultcellicon" >
								<img class="imageresult" src="../../images/normal.png"/>
							</div>
							<div class="cellindex alignmiddle" >
								<span class="contentnormal">Normal</span>
							</div>
						</div>
					</div>

				</div>
			</div>
      	</div>
      </div>
    </div>  	
   <%
			}
		}
	}
      
   %>	
      	
	</div>

