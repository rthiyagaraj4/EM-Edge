<!DOCTYPE html>
<%@page import="eIPAD.IPADConstants"%>
<%@page import="java.util.List"%>
<%@page import="eIPAD.pendingresults.PrevResultCountResponse"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIPAD.pendingresults.PreviousResultsRequest"%>
<%@page import="eIPAD.pendingresults.PendingResults"%>
<%@page import="eIPAD.pendingresults.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> 
<script src="../jquery-1.5.2.min.js"></script> 
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

<link rel="stylesheet" href="../css/iPadPreviousResults.css"/>
<script>
function closePreviousResults(){
	var hdnParamComp = document.getElementById("hdnRequestParam");
	var paramVal;
	if(hdnParamComp){
		paramVal = hdnParamComp.value;
	}
	//window.location = "IpadBasePage.jsp?"+paramVal;
	window.parent.openMainWindow(paramVal);
}

function moveRecordsRight(){
	var hdnCurrentSection = document.getElementById("hdnCurrentSection");
	var currentSectionStr;
	var currentSectionNum;
	if(hdnCurrentSection){
		currentSectionStr = hdnCurrentSection.value;
		currentSectionNum = parseInt(currentSectionStr);
	}
	//alert(currentSectionNum);
	currentSectionNum = currentSectionNum + 1;
	var sectionName = "#section"+currentSectionNum;
	//$.mobile.changePage("#section2","slide" , false,false);
	$.mobile.changePage(sectionName,"slide" , false,false);
	
	hdnCurrentSection.value = currentSectionNum;
}

function moveRecordsLeft(){
	var hdnCurrentSection = document.getElementById("hdnCurrentSection");
	var currentSectionStr;
	var currentSectionNum;
	if(hdnCurrentSection){
		currentSectionStr = hdnCurrentSection.value;
		currentSectionNum = parseInt(currentSectionStr);
	}
	currentSectionNum = currentSectionNum - 1;
	var sectionName = "#section"+currentSectionNum;
	$.mobile.changePage(sectionName,"slide" , false,false);
	hdnCurrentSection.value = currentSectionNum;
}

function changeOrientation(orient)
{
	//	alert(orient);
	if(orient == "landscape")
	   {
	     //document.getElementById("dvmain").style.height = "auto";
	    // $("#dvmain").css('min-height','381px');
		 $("#maindiv").css('min-height','481px');
		    
		    var dvheight = $("#maindiv").height() + "px";
			//document.getElementById("notesContentFrame").style.height = $("#dvNotesMenu").height() ;
			//alert(document.getElementById("notesContentFrame").style.height);
			//alert($("#dvNotesMenu").height());
		    $("#prevResultFrame").css('height', dvheight);
		    document.getElementById("prevResultFrame").contentWindow.changeOrientation(orient,dvheight);
	    
	   }
     else
	   {
	   //  document.getElementById("dvmain").style.height = "auto";
	    // $("#dvmain").css('min-height','765px');
    	 $("#maindiv").css('min-height','760px');
    	 var dvheight = $("#dvNotesMenu").height() + "px";
    	 $("#prevResultFrame").css('height', dvheight);
    	 document.getElementById("prevResultFrame").contentWindow.changeOrientation(orient,dvheight);
	   }
 
}


</script>
</head>
<body>

<%
	String param = request.getQueryString();
	int rowIndex = 1;
	int totalResults = 0;
	
	//Here comes the logic of getting the previous results and showing
	// them in a tabular format
	PendingResults pendingResultsBean = new PendingResults();
	PreviousResultsRequest prevResultsRequest = new PreviousResultsRequest();
	prevResultsRequest.setRequest(request);
	prevResultsRequest.setSession(session);
	prevResultsRequest.setLocale(IPADConstants.LOCALE);
	//String rowCounter = request.getParameter("hdnRowCounter");

	String patient_Id = request.getParameter("hdnPatientid");
	patient_Id = CommonBean.checkForNull(patient_Id);
	prevResultsRequest.setPatientId(patient_Id);

	String histRecType = request.getParameter("hdnHistRectType");
	histRecType = CommonBean.checkForNull(histRecType);
	prevResultsRequest.setHistRectType(histRecType);

	String eventClass = request.getParameter("hdnEventClass");
	eventClass = CommonBean.checkForNull(eventClass);
	prevResultsRequest.setEventClass(eventClass);

	String eventCode = request.getParameter("hdnEventCode");
	eventCode = CommonBean.checkForNull(eventCode);
	prevResultsRequest.setEventCode(eventCode);

	String eventGroup = request.getParameter("hdnEventGroup");
	eventGroup = CommonBean.checkForNull(eventGroup);
	prevResultsRequest.setEventGroup(eventGroup);

	String normalcyIndicator = request
			.getParameter("hdnNormalcyIndicator");
	normalcyIndicator = CommonBean.checkForNull(normalcyIndicator);
	if(normalcyIndicator.trim().equals("")){
		normalcyIndicator = "N";
	}
	prevResultsRequest.setNormalcyIndicator(normalcyIndicator);
	
	prevResultsRequest.setMaskDates(true);
// get the list of previous result dates by executing
// the method in the pending results bean
	PrevResultCountResponse prevResultCountResponse = pendingResultsBean
			.getPreviousResultsCount(prevResultsRequest);
	
	List<PrevResultDateContainer> prevResultDateContainerList = prevResultCountResponse.getPrevResultDateContainerList();
	// calculate the earliest date and latest date from the list of previous dates
	// the list already contains the dates in ascending order of date
	// hence the earliest date is in the first index and latest date is the last in the list
	PrevResultDateContainer earliestDate = prevResultDateContainerList.get(0);
	PrevResultDateContainer latestDate = prevResultDateContainerList.get(prevResultDateContainerList.size()-1);
	
	String fromDate = "";
	if(earliestDate != null){
		fromDate = earliestDate.getDateString();
	}
	
	String toDate = "";
	if(latestDate != null){
		toDate = latestDate.getDateString();
	}
	// now unmask the dates in the request
	prevResultsRequest.setMaskDates(false);
	// set the dates
	prevResultsRequest.setFromDate(fromDate);
	prevResultsRequest.setToDate(toDate);

	// now execute to get the previous results
	PreviousResultsResponse previousResultsResponse = 
		pendingResultsBean.getPreviousResults(prevResultsRequest, prevResultCountResponse);
	
	PreviousResultEventDescriptor eventDescriptor =  
			previousResultsResponse.getEventDescriptor();
	
%>

<form name = "previousResult">
	  
 <div data-role = "page" style="background:#ffffff">
	  
	  <div  data-role ="none" class ="dvApp">
			<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  <tr style = "height:100%;width:100%">
			    <td style = "width:80%">
			         <span class = "spanTextBigHeader"> Pending Results Review >> </span>
			         <span class="spanTextMediumHeader" >Previous results</span>
			    </td>
			    <td style = "width:10%" align = "right" valign = "center">
			        <img src = "../images/Close.png" class="imgLogoutt" onclick="closePreviousResults()"></img>
			    </td>
			 
			    
			  </tr>
		    </table>	  
	  </div>
	  
	  <div id="maindiv" class="dvevent">
	  	<table style="width:100%;height:100%;" cellpadding = "0" cellspacing = "0" border=0>
	  		<tr style="border-bottom: 2 px solid #cccccc">
	  			<td style="width:100%;height:100%;border-right: 2px solid #cccccc;border-bottom: 2px solid #cccccc">
	  				<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
				 		<tr style = "height:100%;width:100%" class="dvApp">
				 		 <td width="5%">&nbsp;</td>
				   		
				          <td style = "width:65%" align="left">
				        	 <span class = "spanTextSmallHeader">Event</span>
				         </td>
				       
				    	</tr>
	  			<%
		  				// just a safe check
		  				if(eventDescriptor != null){
		  				%>
		  				<tr style = "height:100%;width:100%">
		  					<td style="width:5%">&nbsp;</td>
		  					<td style = "height:100%;width:100%">
		  					<table style="width:100%" border=0>
		  						<tr>
		  							<td style="width:100%" align="left">
		  								<span class="spanTextSmallBold"><%=eventDescriptor.getEventCategory() %></span>
		  							</td>
		  						</tr>
		  						<tr>
		  							<td style="width:100%" align="left">
		  								<span class="spanTextSmallNormal"><%=eventDescriptor.getDescription() %></span>
		  							</td>
		  						</tr>
		  						<tr>
		  							<td style="width:100%" align="left">
		  								<span class="spanTextSmallNormal"><%=eventDescriptor.getEventGroupDescription() %></span>
		  							</td>
		  						</tr>
		  						<tr>
		  							<td style="width:100%" align="left">
		  								<span class="spanTextSmallNormal">
		  								<%
		  								String resultDesc = eventDescriptor.getResultDescriptor();
		  								if(resultDesc != null && !resultDesc.trim().equals("")){
		  									out.println(resultDesc);
		  								}%>
		  								</span>
		  							</td>
		  						</tr>
		  					</table>
		  					</td>
		  					<td></td>
		  				  </tr>
		  				  <% } %>
		  				  
		  				  
		  				</table>
	  				</td>
		  				
	 		</tr>
	 		
	 		<%
	 			for(int count=0;count<5;count++){
	 				if((count % 2) == 0){
	 		%>
	 		<tr style="height:60px;background:#e6e6e6">
	 		<%
	 				}else{
	 		%>
	 		<tr style="height:60px;">
	 		
	 		<% } %>
	 		<td style="border-right: 2px solid #cccccc;border-bottom: 2px solid #cccccc">&nbsp;</td>
	 		</tr>
	 			 		
	 		<% 
	 			}
	 		%>
	 		
	 		
	  	</table>
	  </div>
	  
	   <div id="prevResultData" class="prevResultData" style="position:relative;">
	  	<iframe id="prevResultFrame" name="prevResultFrame" class="prevResultFrame" frameborder="0" src="" width="100%"  scrolling ="no" style = "display:block">
	  	</iframe>
	  </div>
	  	  
	</div>
	
	<input type="hidden" id="hdnRequestParam" name="hdnRequestParam" id="hdnRequestParam" value="<%=param%>"/>
	  <input type="hidden" id="hdnPresentCounter" name="hdnPresentCounter" id="hdnPresentCounter" value="4"/>
	  <input type="hidden" id="hdnCurrentSection" name="hdnCurrentSection" id="hdnCurrentSection" value="1"/>
	
</form>

<script>
	window.onload = initializeFunction;
	
	function initializeFunction(){
		window.parent.hideLoading();
		var requestParamComp = document.getElementById("hdnRequestParam");
		var requestParam;
		if(requestParamComp){
			requestParam = requestParamComp.value;
		}
		var prevResultFrame = document.getElementById("prevResultFrame");
		if(prevResultFrame){
			prevResultFrame.src = "PreviousResultsData.jsp?"+requestParam;
		}
		
		var dvheight = $("#maindiv").height() + "px";
		$("#prevResultFrame").css('height', dvheight);
		
	}
</script>

</body>
</html>

