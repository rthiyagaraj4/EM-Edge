<%@page import="eIPAD.pendingresults.PreviousResultEventDescriptor"%>
<%@page import="eIPAD.IPADConstants"%>
<%@page import="eIPAD.pendingresults.PreviousResults"%>
<%@page import="eIPAD.pendingresults.PreviousResultsResponse"%>
<%@page import="eIPAD.pendingresults.PrevResultDateContainer"%>
<%@page import="java.util.List"%>
<%@page import="eIPAD.pendingresults.PrevResultCountResponse"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIPAD.pendingresults.PreviousResultsRequest"%>
<%@page import="eIPAD.pendingresults.PendingResults"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<title>Previous results</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no" />
<!-- <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  -->
<!--  <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> -->
<!--    -->

<link rel="stylesheet" href="../css/iPADThemeA.css" />
<link rel="stylesheet" href="../css/iPADNew.css" />  

<link rel="stylesheet" href="../css/iPadPreviousResults.css"/>
<script>
/* $(document).ready(function() {
	
	
	$("[data-scrolldef = 'first']").bind("swipeleft", function() {
	moveRecordsRight();
	});
 	 $("[data-scrolldef = 'middle']").bind("swipeleft", function() {
	moveRecordsRight();
	});
	 $("[data-scrolldef = 'middle']").bind("swiperight", function() {
	moveRecordsLeft();
	});
	$("[data-scrolldef = 'last']").bind("swiperight", function() {
	moveRecordsLeft();
	});
	
});

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
	$.mobile.changePage(sectionName,"slide" , true,false);
	hdnCurrentSection.value = currentSectionNum;
} */

/* function changeOrientation(orient,height)
{
	//	alert(orient);
	if(orient == "landscape")
	   {
	     document.getElementById("datadiv").style.height = "auto";
	     //document.getElementById("txtnotes").style.height = height;
	   }
     else
	   {
	   document.getElementById("datadiv").style.height = "auto";
	  // document.getElementById("txtnotes").style.height = height;
	   }

} */
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
</script>
</head>
<body style="width: 100%; height: 100%;">

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
	
	int rowsForUI = 0;
	if(eventDescriptor != null){
		String eventCategory = eventDescriptor.getEventCategory();
		if(eventCategory != null && !eventCategory.trim().equals("")){
			rowsForUI++;	
		}
		String desc = eventDescriptor.getDescription();
		if(desc != null && !desc.trim().equals("")){
			rowsForUI++;
		}
		String eventGrpDesc = eventDescriptor.getEventGroupDescription();
		if(eventGrpDesc != null && !eventGrpDesc.trim().equals("")){
			rowsForUI++;
		}
		String resultDesc = eventDescriptor.getResultDescriptor();
		if(resultDesc != null && !resultDesc.trim().equals("")){
			rowsForUI++;
		}
	}
	
	
	List<PreviousResults> prevResultsList = previousResultsResponse.getPreviousResultsList();
	int colCounter = 1;
	if(!prevResultsList.isEmpty()){
		totalResults = prevResultsList.size();
	}
	PreviousResults prevResults = null;
%>

<%-- <%	
	final int BUCKET_SIZE = 3;
	int bucketNo = 1;
	int tempResultSize = totalResults;
	while(tempResultSize > BUCKET_SIZE){
		bucketNo ++;
		tempResultSize = tempResultSize - BUCKET_SIZE;	
	}
	
	PreviousResults prevResults = null;
	
	int bucketSize = BUCKET_SIZE;
	int recordCounter = 0;
	
	boolean showEnabledLegend = false;
%> --%>

<%-- <%
	for(int curr = 1;curr<=bucketNo;curr++){
		/* if(curr == bucketNo){
			bucketSize = totalResults - ((bucketNo -1)* BUCKET_SIZE);
		} */	
		// always set the bucket size to the constant value 3
		bucketSize = BUCKET_SIZE;
	//logic for adding data-scrolldef markers for scrolling left and right 
	String scrolldef="";
	if(curr == 1){
		scrolldef="first";
	}else if(curr == bucketNo){
		scrolldef="last";
	}else{
		scrolldef="middle";
	}
%> --%>

<%-- 	<section id="section<%=curr%>" data-role = "page" style ="padding:0px;" data-scrolldef="<%=scrolldef%>"> --%>

<form name = "previousResultData" id="previousResultData">
		<div class="drRowContainerTheme" style="width:100%; height:63px;">
			<table style="height:100%" cellpadding = "0" cellspacing = "0" border=0>
				<tr style = "height:15%;width:100%" >
		<%	
				for(int count=0;count<=totalResults;count++){
					try{
						prevResults = prevResultsList.get(count);	
					}catch(Exception ex){
						// nothing much can be done
					}%>
					

		  			<td align="center" style="width: 100px;">
		  			<div class="drColumnContainerTheme">
			        	 <div class = "drColumnDateText">
			        	 <%
			        	 if(prevResults != null){
			        		out.println(prevResults.getEventDummyDate());	 
			        	 }
			        	  %></div>
			        	 <div class="drColumnResultNum">
						<%
						if(prevResults != null){
							out.println(prevResults.getResultNum());	
						}
						%>
						</div>
     	  		  		<div class="drColumnResultText">
						<%
						if(prevResults != null){
							out.println(prevResults.getResultStr());	
						}
						%>
						</div>
						<div class="drColumnNormalcyInd">

							<%	
							String normalcyInd = "";
							normalcyInd=prevResults.getNormIndicator();
      						if(normalcyInd==null||normalcyInd.equals("")||normalcyInd.equals("Z")||normalcyInd.equals("S"))
      						{
      						%>
      						<div></div>
      						<%
      						}
      						else if(normalcyInd.equals("A"))
      						{%>
      						<div class="prNormalcyAbnormalTheme"></div>
      						<%
      						}
      						else if(normalcyInd.equals("C"))
      						{%>
      						<div class="prNormalcyCriticalTheme"></div>
      						<%
      						}
      						else if(normalcyInd.equals("N"))
      						{%>
      						<div class="prNormalcyNormalTheme"></div>
      						<%} %>
						</div>
						</div>
					</td>
					

					    		 
					    		<% }%>
				</tr>						  
			</table>
	  	</div>

	  
<!-- 	 </section>	 -->
<%-- 	 		<%
			}
	  		%> --%>
	 			
	 
	 <input type="hidden" id="hdnRequestParam" name="hdnRequestParam" id="hdnRequestParam" value="<%=param%>"/>
	  <input type="hidden" id="hdnResultCount" name="hdnResultCount" id="hdnResultCount" value="<%=totalResults %>"/> 
<!-- 	  <input type="hidden" id="hdnPresentCounter" name="hdnPresentCounter" id="hdnPresentCounter" value="3"/> -->
<!-- 	  <input type="hidden" id="hdnTotalBuckets" name="hdnTotalBuckets" id="hdnTotalBuckets" value=""/> -->
<!-- 	  <input type="hidden" id="hdnCurrentSection" name="hdnCurrentSection" id="hdnCurrentSection" value="1"/> -->
</form> 
	 		
</body>
</html>

