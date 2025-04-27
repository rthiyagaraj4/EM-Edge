<!DOCTYPE html>
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
}

function changeOrientation(orient,height)
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
%>

<%	
	final int BUCKET_SIZE = 4;
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
%>
<form name = "previousResultData">
<%
	for(int curr = 1;curr<=bucketNo;curr++){
		/* if(curr == bucketNo){
			bucketSize = totalResults - ((bucketNo -1)* BUCKET_SIZE);
		} */	
		// always set the bucket size to the constant value 4
		bucketSize = BUCKET_SIZE;
%>

	  <section id="section<%=curr%>" data-role = "page" style ="padding:0px;background:#ffffff">

	  <div id="datadiv" style="width:100%;background:#ffffff;">
	  	<table style="width:100%;border: 1px solid #48d1d8;" cellpadding = "0" cellspacing = "0" border=0>
	  		<tr style="border-bottom: 2 px solid #cccccc">
			<%	
				for(int count=1;count<=bucketSize;count++){
					try{
						prevResults = prevResultsList.get((((curr -1) * 4)+(count-1)));	
					}catch(Exception ex){
						// nothing much can be done
					}
					
					if(prevResults != null){
						String resultNum = prevResults.getResultNum();
						if(resultNum != null && !resultNum.trim().equals("")){
							showEnabledLegend = true;
						}
					}
		  %>
				<td style="border-right: 2px solid #cccccc;border-bottom: 2px solid #cccccc;" valign="top">
	  				<table  style = "width:100%" cellpadding = "0" cellspacing = "0" border = "0">
				 		<tr style = "height:15%;width:100%" >
		 				<%
			 				if(count ==1){
			 					if(curr != 1){
			 			%>
			 				<td style = "width:10%" align="top">
			 					<table style = "width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			 						<tr class="dvApp">
			 						<td align="top">
					    	 			<img src="../images/Column Left Navigation.png" onclick="moveRecordsLeft()"/>
					    	 		</td>
					    	 		</tr>
					    	 	</table>	
					    	 	<table style="width:100%;" border=0>
					    	 	<%
					    	 		for(int temp=0;temp<rowsForUI;temp++){
					    	 	%>
		  						<tr>
		  							<td>&nbsp;</td>
		  						</tr>
		  						<% } %>
		  						
		  						</table>
					    	 </td>
			 				<%
			 					}
			 					else{
			 						// here the disabled icon will be shown
			 				%>
			 				<td style = "width:10%" align="top">
			 					<table style = "width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			 						<tr class="dvApp">
			 						<td>
					    	 		<img src="../images/Column Left Navigation-Disabled.png"/>
					    	 		</td>
					    	 		</tr>
					    	 	</table>
					    	 	<table style="width:100%;" border=0>
		  						<%
					    	 		for(int temp=0;temp<rowsForUI;temp++){
					    	 	%>
		  						<tr>
		  							<td>&nbsp;</td>
		  						</tr>
		  						<% } %>
		  						</table>
					    	 </td>
			 				<%		
			 						}
			 					}
			 				%>
				 			<td valign = "top">
				 				<table style = "width:100%" cellpadding = "0" cellspacing = "0" border = "0">
					 				<tr class="dvApp">
							   		 <td style = "width:80%" align="center">
							        	 <span class = "spanTextSmallHeader">
							        	 <%
							        	 if(prevResults != null){
							        		out.println(prevResults.getEventDummyDate());	 
							        	 }
							        	  %></span>
							    	 </td>
							    	
							    	</tr>
						    	</table>
							      
						    	<table style="width:100%;" border=0>
						    	<%
					    	 		for(int temp=0;temp<(rowsForUI-1);temp++){
					    	 	%>
		  						<tr>
		  							<td>&nbsp;</td>
		  						</tr>
		  						<% } %>
		  						
		  						<tr>
		  							<td align="center" valign="bottom">
		  								<span class="spanTextSmallBold">
		  								<%
		  								if(prevResults != null){
		  									out.println(prevResults.getResultStr());	
		  								}
		  								%>
		  								</span>
		  							</td>
		  						</tr>
		  						</table>
						    </td>
					    	 <%
						    	 if(count == bucketSize){
						    		 if(curr != bucketNo){
						      %>
					    	<td style = "width:10%" align="center">
					    		<table style = "width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			 						<tr class="dvApp">
			 						<td>
					    	 			<img src="../images/Column Right Navigation.png" onclick="moveRecordsRight()"/>
					    	 		</td>
					    	 		</tr>
					    	 	</table>
					    	 	<table style="width:100%;" border=0>
						    	 	<%
						    	 		for(int temp=0;temp<rowsForUI;temp++){
						    	 	%>
			  						<tr>
			  							<td>&nbsp;</td>
			  						</tr>
			  						<% } %>
		  						</table>
					    	</td>
						    <% 		}else{
						    %>
					    	<td style = "width:10%" align="center">
					    		<table style = "width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			 						<tr class="dvApp">
			 						<td>
					    	 			<img src="../images/Column Right Navigation-Disabled.png"/>
					    	 		</td>
					    	 		</tr>
					    	 	</table>
					    	 	<table style="width:100%;" border=0>
			  						<%
					    	 		for(int temp=0;temp<rowsForUI;temp++){
						    	 	%>
			  						<tr>
			  							<td>&nbsp;</td>
			  						</tr>
			  						<% } %>
		  						</table>
					    	</td>	
						    <%	
						    		}
						    	 } 
						     %>
						    	
				    	</tr>
			    	</table>
	  					 
	  			</td>
			<%
				}
			%>
			</tr>
	 		
	 		
	 		
	 		<%
	 			for(int cnt=0;cnt<5;cnt++){
	 				if((cnt % 2) == 0){
	 		%>
	 		<tr style="height:60px;background:#e6e6e6">
	 		<%
	 				}else{
	 		%>
	 		<tr style="height:60px;">
	 		
	 		<% } %>
	 		
	 		<%
	 			for(int ind=0;ind<bucketSize;ind++){
	 		%>
			<td style="border-right: 2px solid #cccccc;border-bottom: 2px solid #cccccc" align="top">&nbsp;</td>	 		
	 		<% 
	 				}
	 			}
	 		%>
	 		</tr>
	 		
	 		</table>
	 		
	  </div>
	  
	  <div id="icondiv" style="width:100%;height:15%;background:#ffffff">
	  <table width="80%" border=0>
	  	<tr>
	  		<td width="8%" align="center">
	  			<%
	  			if(showEnabledLegend){
	  			%>
	  				<img src="../images/NI_High.gif"/>
	  			<%
	  			}
	  			else{
	  			%>
	  				<img src="../images/High-Disabled.PNG"/>
	  			<%	
	  			}
	  			%>
	  			<span>High</span>
	  		</td>
	  		<td width="8%" align="center">
	  			<%
	  			if(showEnabledLegend){
	  			%>
	  				<img src="../images/NI_Low.gif"/>
	  			<%
	  			}
	  			else{
	  			%>
	  				<img src="../images/Low-Disabled.PNG"/>
	  			<%	
	  			}
	  			%>
	  			<span>Low</span>
	  		</td>
	  		<td width="12%" align="center">
	  			<%
	  			if(showEnabledLegend){
	  			%>
	  				<img src="../images/NI_Abnormal.gif"/>
	  			<%
	  			}
	  			else{
	  			%>
	  				<img src="../images/Abnormal-Disabled.png"/>
	  			<%	
	  			}
	  			%>
	  			<span>Abnormal</span>
	  		</td>
	  		<td width="10%" align="center">
	  			<%
	  			if(showEnabledLegend){
	  			%>
	  				<img src="../images/NI_Critical.gif"/>
	  			<%
	  			}
	  			else{
	  			%>
	  				<img src="../images/Critical-Disabled.png"/>
	  			<%	
	  			}
	  			%>
	  			<span>Critical</span>
	  		</td>
	  		<td width="15%" align="center">
	  			<%
	  			if(showEnabledLegend){
	  			%>
	  				<img src="../images/NI_CriticallyHigh.gif"/>
	  			<%
	  			}
	  			else{
	  			%>
	  				<img src="../images/Critical High-Disabled.png"/>
	  			<%	
	  			}
	  			%>
	  			<span>Critical High</span>
	  		</td>
	  		<td width="15%" align="center">
	  			<%
	  			if(showEnabledLegend){
	  			%>
	  				<img src="../images/NI_CriticallyLow.gif"/>
	  			<%
	  			}
	  			else{
	  			%>
	  				<img src="../images/Critical low-Disabled.png"/>
	  			<%	
	  			}
	  			%>
	  			<span>Critical Low</span>
	  		</td>
	  		<td width="10%" align="center">
	  			<%
	  			if(showEnabledLegend){
	  			%>
	  				<img src="../images/NI_Normal.gif"/>
	  			<%
	  			}
	  			else{
	  			%>
	  				<img src="../images/Normal-Disabled.png"/>
	  			<%	
	  			}
	  			%>
	  			<span>Normal</span>
	  		</td>
	  	</tr>
	  </table>
	  </div>
	 
	  
	 </section>	
	 		<%
			}
	  		%>
	 			
	 
	 <input type="hidden" id="hdnRequestParam" name="hdnRequestParam" id="hdnRequestParam" value="<%=param%>"/>
	  <input type="hidden" id="hdnResultCount" name="hdnResultCount" id="hdnResultCount" value="<%=totalResults %>"/> 
	  <input type="hidden" id="hdnPresentCounter" name="hdnPresentCounter" id="hdnPresentCounter" value="4"/>
	  <input type="hidden" id="hdnTotalBuckets" name="hdnTotalBuckets" id="hdnTotalBuckets" value="<%=bucketNo%>"/>
	  <input type="hidden" id="hdnCurrentSection" name="hdnCurrentSection" id="hdnCurrentSection" value="1"/>
</form>	 
	 		
</body>
</html>

