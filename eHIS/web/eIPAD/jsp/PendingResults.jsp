<%@page import="eOR.ORReviewResult.ORReviewResultHome"%>
<%@page import="eOR.Common.OrRepository"%>
<%@page import="com.ehis.eslp.ServiceLocator"%>
<%@page import="eIPAD.pendingresults.PrevResultDateContainer"%>
<%@page import="eIPAD.pendingresults.PrevResultCountResponse"%>
<%@page import="eIPAD.pendingresults.PreviousResultsResponse"%>
<%@page import="eIPAD.pendingresults.PreviousResultsRequest"%>
<%@page import="eIPAD.pendingresults.ResultDetail"%>
<%@page import="eIPAD.pendingresults.ResultCategory"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="eIPAD.pendingresults.PendingResultForPatient"%>
<%@page import="eIPAD.pendingresults.PatientDetail"%>
<%@page import="eIPAD.pendingresults.PendingResultsResponse"%>
<%@page import="eIPAD.pendingresults.PendingResults"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIPAD.pendingresults.PendingResultsRequest"%>
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
	// from and to period is not useful as of now but having such
	// properties in the request helps when the from and to time period
	// components are introduced
	String fromPeriod = request.getParameter("hdnFromPeriod");
	fromPeriod = CommonBean.checkForNull(fromPeriod,
			IPADConstants.LAST_ONE_WEEK);
	if (fromPeriod.trim().equals("")) {
		fromPeriod = IPADConstants.LAST_ONE_WEEK;
	}

	String toPeriod = request.getParameter("hdnTPeriod");
	toPeriod = CommonBean.checkForNull(toPeriod);

	String selectedPeriod = request.getParameter("hdnSelectedPeriod");//hdnSelectedPeriod
	selectedPeriod = CommonBean.checkForNull(selectedPeriod,
			IPADConstants.LAST_ONE_WEEK);

	String searchClicked = request.getParameter("hdnSearchClicked");
	if (searchClicked == null || searchClicked.trim().equals("")) {
		searchClicked = "Y";
	}

	String normalcy = "";
	String patientId = "";
	// if search button is clicked then this page is reloaded
	// hence the need to set the patient id and the normalcy
	// comes in this case only
	if ("Y".equalsIgnoreCase(searchClicked)) {
		// changed to get the patient id from the patient text
		patientId = request.getParameter("hdnPatientId");
		patientId = CommonBean.checkForNull(patientId);
		normalcy = request.getParameter("hdnNormalcyVal");
		normalcy = CommonBean.checkForNull(normalcy, "Z");
	} else {
		normalcy = request.getParameter("hdnNormalcyVal");
		normalcy = CommonBean.checkForNull(normalcy, "Z");
	}

	String groupby = request.getParameter("hdnGroupby");
	groupby = CommonBean.checkForNull(groupby);
	//String caNormalcyInd = request.getParameter("normalcy_ind");
	//caNormalcyInd = CommonBean.checkForNull(caNormalcyInd,"Z");
	String getTaskApplicability = request
			.getParameter("hdnGetTaskApplicability");
	getTaskApplicability = CommonBean
			.checkForNull(getTaskApplicability);

	// this will store the complete review clicked status
	String completeReviewClicked = request
			.getParameter("hdnCompleteReviewClicked");
	completeReviewClicked = CommonBean.checkForNull(
			completeReviewClicked, "N");

	// this will store the forward review clicked status
	String forwardReviewClicked = request
			.getParameter("hdnForwardReviewClicked");
	forwardReviewClicked = CommonBean.checkForNull(
			forwardReviewClicked, "N");

	String selectedRows = request.getParameter("hdnSelectedRows");
	selectedRows = CommonBean.checkForNull(selectedRows);
%>
<!DOCTYPE html>
<html>
<head>

<title>Pending Results Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
 <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> 

<link rel="stylesheet" href="../css/iPadPendingResultCriteria.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script> 
<script type="text/javascript">
var bShCriteria = true;
	function showCriteria() {
		$('#searchCriteriaDiv').slideToggle('fast');
		if (bShCriteria) {
			bShCriteria = false;
			document.getElementById("imgCriteria").src = "../images/Heading-Panel-Up-Arrow.png";
		} else {
			bShCriteria = true;
			document.getElementById("imgCriteria").src = "../images/Heading-Panel-down-Arrow.png";
		}
	}
	
	function clearValues(){
		document.getElementById("PatientIdText").value = "";
		var periodComp = document.getElementById("PeriodComp");
		if(periodComp){
			// sets the selection to "LOW"
			periodComp.selectedIndex = 2;
		}
		
		var normalcyComp = document.getElementById("NormalcyComp");
		if(normalcyComp){
			// sets the select to "--- Select ---"
			normalcyComp.selectedIndex = 0;
		}
	}
	
	function searchPendingResults(){
		// get the selected period and set it to the hidden component
		var periodComp = document.getElementById("PeriodComp");
		var selectedFromPeriod;
		if(periodComp){
			selectedFromPeriod = periodComp.options[periodComp.selectedIndex].value;
		}
		// set the selected from period in the hidden text field also
		var hdnFromPeriod = document.getElementById("hdnFromPeriod");
		if(hdnFromPeriod){
			hdnFromPeriod.value = selectedFromPeriod;
		}
		// the below code to also consider to period is only
		// to maintain uniformity - to period is not of use
		// presently
		var hdnToPeriod = document.getElementById("hdnToPeriod");
		var toPeriod;
		if(hdnToPeriod){
			toPeriod = hdnToPeriod.value;
		}
		
		// set the flag that search button is clicked
		var hdnSearchClicked = document.getElementById("hdnSearchClicked");
		if(hdnSearchClicked){
			hdnSearchClicked.value = "Y";
		}
		
		// get the selected normalcy and set it to the hidden component
		var normalcyComp = document.getElementById("NormalcyComp");
		var hdnNormalcyComp = document.getElementById("hdnNormalcyVal");
		if(normalcyComp){
			var selectedNormalcy = normalcyComp.options[normalcyComp.selectedIndex].value;
			if(hdnNormalcyComp){
				hdnNormalcyComp.value = selectedNormalcy;
			}
		}
		
		// get the patient id from the text and set it to the hidden component
		var patientIdComp = document.getElementById("PatientIdText");
		var hdnPatientComp = document.getElementById("hdnPatientId");
		if(patientIdComp){
			var patientId = patientIdComp.value;
			if(hdnPatientComp){
				hdnPatientComp.value = patientId;
			}
		}
		
		// need to get groupby, and task applicability now
		var hdnGroupbyComp = document.getElementById("hdnGroupby");
		var groupbyVal;
		if(hdnGroupbyComp){
			groupbyVal = hdnGroupbyComp.value;
		}
		
		var hdnTaskApplicability = document.getElementById("hdnGetTaskApplicability");
		var taskApplicabilityVal;
		if(hdnTaskApplicability){
			taskApplicabilityVal = hdnTaskApplicability.value;
		}
		
		var hdnCompleteReviewClicked = document.getElementById("hdnForwardReviewClicked");
		if(hdnCompleteReviewClicked){
			hdnCompleteReviewClicked.value = "";
		}
		
		// get the form and set the source url
		var pendingResultsForm = document.getElementById("PendingResultsForm");
		if(pendingResultsForm){
			parent.removeSpinner();
			pendingResultsForm.action = "PendingResults.jsp?hdnFromPeriod="+selectedFromPeriod+"&hdnToPeriod="+toPeriod+"&hdnNormalcyVal="+selectedNormalcy+"&hdnGetTaskApplicability="+taskApplicabilityVal+"&hdnGroupby="+groupbyVal;
			pendingResultsForm.submit();	
			parent.removeSpinner();
		}
	}
	
	function Practitioner(strCode,strDesc)
	 {
		 //alert("code ="+strCode+" pracid="+strDesc);
		 document.getElementById("hdnPractCode").value = strCode; 
		 document.getElementById("hdnPractDesc").value  = strDesc;
		 
		  $("#PendingResultsForm").toggle("fast");
		  $("#Dialog").toggle("fast");
		  scrolTop();
		  document.getElementById("srchFrame").src = "";
		  
		  forwardResult();
	 }
	
	 function showPractitioner()
	  {  parent.removeSpinner();
		 document.getElementById("srchFrame").src = "Practitioner.jsp";
		  $("#PendingResultsForm").toggle("fast");
		  $("#Dialog").toggle("fast");
	 }
	 
	 function scrolTop()
	 {
		  //alert("helloj");
		 window.parent.scrolTop();
	 }
	 
	 function showPreviousResults(rowCounter){
		//alert("row counter ="+rowCounter); 
		var url="PreviousResults.jsp";
		var parameters ="";
		var periodComp = document.getElementById("PeriodComp");
		var selectedFromPeriod;
		if(periodComp){
			selectedFromPeriod = periodComp.options[periodComp.selectedIndex].value;
			parameters += "hdnSelectedPeriod="+selectedFromPeriod;
		}
		
		// set the selected from period in the hidden text field also
		var hdnFromPeriod = document.getElementById("hdnFromPeriod");
		if(hdnFromPeriod){
			hdnFromPeriod.value = selectedFromPeriod;
			parameters += "&hdnFromPeriod="+selectedFromPeriod;
		}
		
		// the below code to also consider to period is only
		// to maintain uniformity - to period is not of use
		// presently
		var hdnToPeriod = document.getElementById("hdnToPeriod");
		var toPeriod;
		if(hdnToPeriod){
			toPeriod = hdnToPeriod.value;
			parameters += "&hdnToPeriod="+toPeriod;
		}
		
		// set the flag that search button is clicked
		var hdnSearchClicked = document.getElementById("hdnSearchClicked");
		if(hdnSearchClicked){
			parameters += "&hdnSearchClicked="+hdnSearchClicked.value;
		}
		
		// get the selected normalcy and set it to the hidden component
		var normalcyComp = document.getElementById("NormalcyComp");
		var hdnNormalcyComp = document.getElementById("hdnNormalcyVal");
		if(normalcyComp){
			var selectedNormalcy = normalcyComp.options[normalcyComp.selectedIndex].value;
			parameters += "&hdnCANormalcyInd="+selectedNormalcy;
			parameters += "&hdnNormalcyVal="+selectedNormalcy;
		}
		
		// get the patient id from the text and set it to the hidden component
		var patientIdComp = document.getElementById("PatientIdText");
		if(patientIdComp){
			var patientId = patientIdComp.value;
			parameters += "&hdnPatient_Id="+patientId;
		}
		
		// need to get groupby, and task applicability now
		var hdnGroupbyComp = document.getElementById("hdnGroupby");
		if(hdnGroupbyComp){
			parameters += "&hdnGroupby="+hdnGroupbyComp.value;
		}
		
		var hdnTaskApplicability = document.getElementById("hdnGetTaskApplicability");
		if(hdnTaskApplicability){
			parameters += "&hdnGetTaskApplicability="+hdnTaskApplicability.value;
		}
		
		var practDescComp = document.getElementById("hdnPractDesc");
		if(practDescComp){
			parameters += "&hdnPractDesc="+practDescComp.value;
		}
		
		var practCode = document.getElementById("hdnPractCode")	
		if(practCode){
			parameters += "&hdnPractCode="+practCode.value;
		}
		
		//alert('parameters before patientid ='+parameters);
		var patient_IdComp = document.getElementById("hdnPatientId"+rowCounter);
		if(patient_IdComp){
			parameters += "&hdnPatientid="+patient_IdComp.value;
		}
		
		var eventClassComp = document.getElementById("hdnEventClass"+rowCounter);
		if(eventClassComp){
			parameters += "&hdnEventClass="+eventClassComp.value;
		}
		
		var eventCodeComp = document.getElementById("hdnEventCode"+rowCounter);
		if(eventCodeComp){
			parameters += "&hdnEventCode="+eventCodeComp.value;
		}
		
		var eventGroupComp = document.getElementById("hdnEventGroup"+rowCounter);
		if(eventGroupComp){
			parameters += "&hdnEventGroup="+eventGroupComp.value;
		}
		
		var histRectTypeComp = document.getElementById("hdnHistRectType"+rowCounter);
		if(histRectTypeComp){
			parameters += "&hdnHistRectType="+histRectTypeComp.value;
		}
		
		var normalcyIndComp = document.getElementById("hdnNormalcyIndicator"+rowCounter);
		if(normalcyIndComp){
			parameters +="&hdnNormalcyIndicator="+normalcyIndComp.value;
		}
		
		var encounterIdComp = document.getElementById("hdnEncounterId"+rowCounter);
		if(encounterIdComp){
			parameters += "&hdnEpisodeId="+encounterIdComp.value;
		}
		
		// passing the patient class as "IP" as of now as this
		// is not present in the previous results
		parameters += "&hdnPatClass=IP";
		
		// finally also pass the row counter
		//parameters += "&hdnRowCounter="+rowCounter;
		window.parent.showPreviousResults(url,parameters);
	 }
	
	  function CloseSearchCriteria(){
		  $("#PendingResultsForm").toggle("fast");
		  $("#Dialog").toggle("fast");
		  document.getElementById("srchFrame").src = "";
	  }
	
	  function completeReview(){
		  var totalRecordComp = document.getElementById("hdnTotalRecords");
		  var totalRecords;
		  var totalRecordsInt;
		  if(totalRecordComp){
			  totalRecords = totalRecordComp.value;
			  totalRecordsInt = parseInt(totalRecords);
		  }
		  //alert('total records='+totalRecordsInt);
		  
		  var checkComp;
		  var checkedCompCount = 0;
		  var selectedRows = "";
		  for(count=1;count<=totalRecordsInt;count++){
			  checkComp = document.getElementById("check"+count);
			  if(checkComp){
				  if(checkComp.checked){
					  if(checkedCompCount > 0){
						  selectedRows += ","+count;  
					  }else{
						  selectedRows += ""+count;
					  }
					  checkedCompCount++;
				  }
			  }
		  }
		  
		  if(checkedCompCount == 0){
			  alert('Check Atleast One Event');
			  return false;
		  }
		  
		  var selectedRowsComp = document.getElementById("hdnSelectedRows");
		  if(selectedRowsComp){
			  selectedRowsComp.value = selectedRows;
		  }
		  
		  // this should be deleted after the entire code for complete review
		  // is done
		  //return false;
		  
		  var completeReviewComp = document.getElementById("hdnCompleteReviewClicked");
		  if(completeReviewComp){
			  completeReviewComp.value = "Y";
		  }
		  
		  var confirmFlag = confirm("Do you want to complete the review of Selected Pending Results");
		  if(confirmFlag){
			  var pendingResultsForm = document.getElementById("PendingResultsForm");
			  if(pendingResultsForm){
				  pendingResultsForm.submit();
			  }  
		  }else{
			  return false;
		  }
		  
	  }
	  
	  function forwardResult(){
		  var totalRecordComp = document.getElementById("hdnTotalRecords");
		  var totalRecords;
		  var totalRecordsInt;
		  if(totalRecordComp){
			  totalRecords = totalRecordComp.value;
			  totalRecordsInt = parseInt(totalRecords);
		  }
		  //alert('total records='+totalRecordsInt);
		  
		  var checkComp;
		  var checkedCompCount = 0;
		  var selectedRows = "";
		  for(count=1;count<=totalRecordsInt;count++){
			  checkComp = document.getElementById("check"+count);
			  if(checkComp){
				  if(checkComp.checked){
					  if(checkedCompCount > 0){
						  selectedRows += ","+count;  
					  }else{
						  selectedRows += ""+count;
					  }
					  checkedCompCount++;
				  }
			  }
		  }
		  
		  if(checkedCompCount == 0){
			  alert('Check Atleast One Event');
			  return false;
		  }
		  
		  var selectedRowsComp = document.getElementById("hdnSelectedRows");
		  if(selectedRowsComp){
			  selectedRowsComp.value = selectedRows;
		  }
		  
		  // this should be deleted after the entire code for complete review
		  // is done
		  //return false;
		  
		  var completeReviewComp = document.getElementById("hdnCompleteReviewClicked");
		  if(completeReviewComp){
			  completeReviewComp.value = "N";
		  }
		  
		  var forwardReviewComp = document.getElementById("hdnForwardReviewClicked");
		  if(forwardReviewComp){
			  forwardReviewComp.value = "Y";
		  }
		  
		  var confirmFlag = confirm("Do you want to Forward the selected Results");
		  if(confirmFlag){
			  var pendingResultsForm = document.getElementById("PendingResultsForm");
			  if(pendingResultsForm){
				  pendingResultsForm.submit();
			  }  
		  }else{
			  return false;
		  }
		  
	  }
	  
	  function selectAllRecords(){
		  var totalRecordComp = document.getElementById("hdnTotalRecords");
		  var totalRecords;
		  var totalRecordsInt;
		  if(totalRecordComp){
			  totalRecords = totalRecordComp.value;
			  totalRecordsInt = parseInt(totalRecords);
		  }
		  
		  var checkComp;
		  var checkedCompCount = 0;
		  var selectedRows = "";
		  for(count=1;count<=totalRecordsInt;count++){
			  checkComp = document.getElementById("check"+count);
			  if(checkComp){
				  checkComp.checked = true;
			  }
		  }
		  
		  // now check the check box shown at patient level
		  var totalPatientCountComp = document.getElementById("hdnPatientCounter");
		  var totalPatientCountStr;
		  var totalPatientCount = 0;
		  if(totalPatientCountComp){
			  totalPatientCountStr = totalPatientCountComp.value;
			  totalPatientCount = parseInt(totalPatientCountStr);
		  }
		  
		  for(cnt=1;cnt<=totalPatientCount;cnt++){
			  patientChkbox = document.getElementById("checkb"+cnt);
			  if(patientChkbox){
				  patientChkbox.checked = true;
			  }
		  }
		  
	  }
	  
	  function selectPatientCategories(){
		  var totalPatientCountComp = document.getElementById("hdnPatientCounter");
		  var totalPatientCountStr;
		  var totalPatientCount = 0;
		  if(totalPatientCountComp){
			  totalPatientCountStr = totalPatientCountComp.value;
			  totalPatientCount = parseInt(totalPatientCountStr);
		  }
		  // iterate through the patients
		  var patientChkbox;
		  var recordRunningStr;
		  var recordRunningTemp = 0;
		  var recordRunningCounter = 0;
		  var checkStatus;
		  for(cnt=1;cnt<=totalPatientCount;cnt++){
			  patientChkbox = document.getElementById("checkb"+cnt);
			  if(patientChkbox){
				  recordRunningStr = patientChkbox.value;
				  recordRunningTemp = parseInt(recordRunningStr);
				  checkStatus = patientChkbox.checked;
				 
				  var chkbox;
				  for(ind = (recordRunningCounter + 1); ind <= (recordRunningCounter + recordRunningTemp);ind++){
					  chkbox = document.getElementById("check"+ind);
					  if(chkbox){
						  chkbox.checked = checkStatus;
					  }
				  }
				  recordRunningCounter += recordRunningTemp;
			  }
			  
		  }
		  
	  }
	  
	  function DisplayOrHideDetails(HeaderName,objImg)
	  {
	  	
	  	 var imgPath = objImg.src; 
	  	 if( imgPath.indexOf("Expanded") != -1 )
	  		 {
	  		 objImg.src = "../images/More group icon main.png";
	  			$("[data-class = '" + HeaderName + "']").css('display','none');
	  		 }
	  	 else
	  		 {
	  		 objImg.src = "../images/Expanded Group Icon Main.png";
	  			$("[data-class = '" + HeaderName + "']").css('display','block');
	  		 }
	  	 var src = "../images/Expanded group Icon.png";
	  	// $("[data-image = '" + HeaderName + "']").css('background', 'url(' + src + ')'); 
	  	$("[data-image = '" + HeaderName + "']").attr("src" , src);
	  	
	  }
	  
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>

<section id="page1" data-role="page"  style="padding:0px;width:100%;background:#ffffff"> 
<form name='PendingResultsForm' id='PendingResultsForm' method='post' id="PendingResultsForm" style = "width:100%">
<!--  <div style="width:100%;height:auto"></div> -->
	  <div id = "divSrch"  data-role ="none" class="searchStyle" onclick = "showCriteria()">
		  <!--  <span class = "spanDvsrch">Search</span> -->
		 <!--    <img src = "Heading-Panel-down-Arrow.png" class = "imgg"></img>  -->
		 <table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  <tr style = "height:100%;width:100%">
			    <td style = "width:95%">
			         <span class = "searchTextStyle">Search</span>
			    </td>
			    <td style = "width:5%" align = "center" valign = "center">
			        <img src = "../images/Heading-Panel-down-Arrow.png" id = "imgCriteria"></img> 	
			    </td>
			  </tr>
		    </table>	  
	  </div>
	  <div style="width : 100%;height : 1px;background : #333333;" data-role ="none"></div>
	  <div id="searchCriteriaDiv" data-role ="none"  style = "height:auto;padding:0px;background:#ffffff;" >
			<table style="width: 100%;">
				<tr style="height: 30px; width: 100%">
					<td align="left" width="33%"><span class="labelStyle">Patient
							Id</span></td>
					<td align="left" width="33%"><span class="labelStyle">Select
							Period</span></td>
					<td align="left" width="33%"><span class="labelStyle">Normalcy
							Indicator</span></td>
				</tr>
				<tr style="height: 35px; width: 100%">
					<td align="left" width="33%"><input type="Text"
						id="PatientIdText" data-role = "none" class="textBoxStyle" value="<%=patientId%>"/></td>
					<td width="33%"><select id="PeriodComp" data-role="none"
						class="cmbFilterBy" onchange="">
							<%
								if (IPADConstants.LAST_ONE_DAY.equals(fromPeriod)) {
							%>
							<option value="LOD" selected="selected">Last One Day</option>
							<%
								} else {
							%>
							<option value="LOD">Last One Day</option>
							<%
								}
								if (IPADConstants.LAST_THREE_DAYS.equals(fromPeriod)) {
							%>
							<option value="LTD" selected="selected">Last Three Days</option>
							<%
								} else {
							%>
							<option value="LTD">Last Three Days</option>
							<%
								}
								if (IPADConstants.LAST_ONE_WEEK.equals(fromPeriod)) {
							%>
							<option value="LOW" selected="selected">Last One Week</option>
							<%
								} else {
							%>
							<option value="LOW">Last One Week</option>
							<%
								}

								if (IPADConstants.LAST_ONE_MONTH.equals(fromPeriod)) {
							%>
							<option value="LOM" selected="selected">Last One Month</option>
							<%
								} else {
							%>
							<option value="LOM">Last One Month</option>
							<%
								}

								if (IPADConstants.LAST_ONE_YEAR.equals(fromPeriod)) {
							%>
							<option value="LOY" selected="selected">Last One Year</option>
							<%
								} else {
							%>
							<option value="LOY">Last One Year</option>
							<%
								}
							%>

					</select></td>
					<td width="33%"><select id="NormalcyComp" data-role="none"
						class="cmbFilterBy" onchange="">
							<%
								if ("".equals(normalcy.trim()) || "S".equals(normalcy.trim())
										|| "Z".equals(normalcy.trim())) {
							%>
							<option value="S">All</option>
							<option value="A">Abnormal</option>
							<option value="C">Critical</option>
							<option value="N">Normal</option>
							<%
								} else if ("A".equals(normalcy.trim())) {
							%>
							<option value="S">All</option>
							<option value="A" selected="selected">Abnormal</option>
							<option value="C">Critical</option>
							<option value="N">Normal</option>
							<%
								} else if ("C".equals(normalcy.trim())) {
							%>
							<option value="S">All</option>
							<option value="A" >Abnormal</option>
							<option value="C" selected="selected">Critical</option>
							<option value="N">Normal</option>
							<%
								} else if ("N".equals(normalcy.trim())) {
							%>
							<option value="S">All</option>
							<option value="A" >Abnormal</option>
							<option value="C">Critical</option>
							<option value="N" selected="selected">Normal</option>
							<%
								}
							%>
					</select></td>

				</tr>
				<tr style="height: 5px;">
					<td width="33%">&nbsp;</td>
					<td width="33%">&nbsp;</td>
					<td width="33%">&nbsp;</td>
				</tr>
				<tr style="height: 35px;">
					<td width="33%">&nbsp;</td>
					<td width="33%">&nbsp;</td>
					<td width="33%">
						<table width="100%" border="0">
							<tr>
								<td width="9%">&nbsp;</td>
								<td width="45%"><input type="button" value="Search"
									id="Search" data-role = "none" class="searchbuttonStyle" onclick="searchPendingResults()" /></td>
								<td width="46%"><input type="button" value="Clear"
									id="Clear" data-role = "none" class="searchbuttonStyle" onclick="clearValues()"/></td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</div>		
	  	<input type="hidden" name="hdnFromPeriod" id="hdnFromPeriod" id="hdnFromPeriod" value="<%=fromPeriod%>" />
		<input type="hidden" name="hdnToPeriod" id="hdnToPeriod" id="hdnToPeriod" value="<%=toPeriod%>" />
		<input type="hidden" name="hdnNormalcyVal" id="hdnNormalcyVal" id="hdnNormalcyVal" value=""/>
		<input type="hidden" name="hdnPatientId" id="hdnPatientId" id="hdnPatientId" value="<%=patientId%>"/>
		<input type="hidden" name="hdnSearchClicked" id="hdnSearchClicked" id="hdnSearchClicked" value="<%=searchClicked%>"/>
		<input type="hidden" name="hdnGroupby" id="hdnGroupby" id="hdnGroupby" value="<%=groupby%>"/>
		<input type="hidden" name="hdnCANormalcyInd" id="hdnCANormalcyInd" id="hdnCANormalcyInd" value="<%=normalcy%>"/>
		<input type="hidden" name="hdnGetTaskApplicability" id="hdnGetTaskApplicability" id="hdnGetTaskApplicability" value="<%=getTaskApplicability%>"/>
		<input type="hidden" name="hdnSelectedPeriod" id="hdnSelectedPeriod" id="hdnSelectedPeriod" value="<%=selectedPeriod%>"/>
		<input type="hidden" name="hdnPractDesc" id="hdnPractDesc" id="hdnPractDesc" value=""/>
		<input type="hidden" name="hdnPractCode" id="hdnPractCode" id="hdnPractCode" value=""/>
		<input type="hidden" name="hdnCompleteReviewClicked" id="hdnCompleteReviewClicked" id="hdnCompleteReviewClicked" value="<%=completeReviewClicked%>"/>
		<input type="hidden" name="hdnForwardReviewClicked" id="hdnForwardReviewClicked" id="hdnForwardReviewClicked" value="<%=forwardReviewClicked%>"/>
		<input type="hidden" name="hdnSelectedRows" id="hdnSelectedRows" id="hdnSelectedRows" value=""/>
	
	<div id="resultPageHeader" style="width: 100%" class="resultPageHeader">
		<table style="height: 100%; width: 100%" cellpadding="0"
			cellspacing="0" border="0">
			<tr style="height: 100%; width: 100%">
				<td style="width: 55%"><span class="resultTextStyle">
				Pending	Results Review</span></td>
				<td style="width: 12%" align="right" valign="center"><input
					type="button" value="Select All" data-role = "none" class="buttonStyle" onclick="selectAllRecords()"/></td>
				<td style="width: 12%" align="right" valign="center"><input
					type="button" value="Forward" data-role = "none" class="buttonStyle" onclick="showPractitioner()"/></td>
				<td style="width: 18%" align="right" valign="center"><input
					type="button" value="Complete Review" data-role = "none" class="buttonStyle" onclick="completeReview()"/></td>
				<td style="width: 2%">&nbsp;</td>

			</tr>
		</table>
	</div>
	
	<div id="mainResults" style="width: 100%; height:100%;background:#ffffff;" >
	<%
		PendingResultsResponse pendingResultsResponse = null;
		Map<PatientDetail, PendingResultForPatient> pendingResultMap = null;
		int recordCounter = 1;
		// this will contain the total records obtained
		int totalRecords = 0;
		// code should be put here to complete the review if
		// user has clicked on complete review button
		// same way handle the forward to practitioner request
		if ("Y".equalsIgnoreCase(completeReviewClicked)) {
			String hist_rec_type = "";
			String contr_sys_id = "";
			String contr_sys_event_code = "";
			String accession_num = "";
			String review_type = "";
			String create_date_time = "";
			String review_remarks = "";

			String practitionerId = (String) session
					.getValue("ca_practitioner_id");
			StringTokenizer stTokenizer = new StringTokenizer(selectedRows,
					",");
			String token = null;
			String record[] = null;
			int selectionCounter = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			int commaIndex = selectedRows.indexOf(",");
			if(commaIndex < 0 && !selectedRows.trim().equals("")){
				token = selectedRows;
				hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
				contr_sys_id = request.getParameter("hdnControlSysId"
						+ token);
				contr_sys_event_code = request
						.getParameter("hdnControlSysEventCode" + token);
				accession_num = request.getParameter("hdnAccessionNum"
						+ token);
				review_type = request.getParameter("hdnReviewType"
						+ token);
				create_date_time = request
						.getParameter("hdnCreationDateTime" + token);
				review_remarks = request
						.getParameter("hdnReviewRemarks" + token);

				record = new String[7];
				record[0] = hist_rec_type;
				record[1] = contr_sys_id;
				record[2] = contr_sys_event_code;
				record[3] = accession_num;
				record[4] = review_type;
				record[5] = create_date_time;
				record[6] = review_remarks;

				// this is the key used in the desktop application
				// and only this key is understood by the ejb
				dataMap.put("review_data" + selectionCounter, record);
				selectionCounter++;
			}
			else{
				if (stTokenizer != null) {
					while (stTokenizer.hasMoreTokens()) {
						token = stTokenizer.nextToken();
						token = token.trim();
	
						// now get the individual fields
						hist_rec_type = request.getParameter("hdnHistRectType"
								+ token);
						contr_sys_id = request.getParameter("hdnControlSysId"
								+ token);
						contr_sys_event_code = request
								.getParameter("hdnControlSysEventCode" + token);
						accession_num = request.getParameter("hdnAccessionNum"
								+ token);
						review_type = request.getParameter("hdnReviewType"
								+ token);
						create_date_time = request
								.getParameter("hdnCreationDateTime" + token);
						review_remarks = request
								.getParameter("hdnReviewRemarks" + token);
	
						record = new String[7];
						record[0] = hist_rec_type;
						record[1] = contr_sys_id;
						record[2] = contr_sys_event_code;
						record[3] = accession_num;
						record[4] = review_type;
						record[5] = create_date_time;
						record[6] = review_remarks;
	
						// this is the key used in the desktop application
						// and only this key is understood by the ejb
						dataMap.put("review_data" + selectionCounter, record);
	
						selectionCounter++;
					}
				}
			}

			// now set the practitioner id, login id and the total count
			// in this case, login id and practitioner id are the same
			dataMap.put("pract_id", practitionerId);
			dataMap.put("login_by_id", practitionerId);
			dataMap.put("totalCount", "" + selectionCounter);

			Map<String, String> sqlMap = new HashMap<String, String>();
			try {
				sqlMap.put("SQL_OR_RESULT_REVIEW_DELETE", OrRepository
						.getOrKeyValue("SQL_OR_RESULT_REVIEW_DELETE"));
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT", OrRepository
						.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT"));
				sqlMap.put(
						"SQL_OR_RESULT_REVIEW_REVIEWED_PRACT",
						OrRepository
								.getOrKeyValue("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT"));
			} catch (Exception e) {
				e.printStackTrace();
				// nothing much can be done here
			}
			// get the properties to be passed to EJB from session
			Properties jdbc_props = (Properties) session.getValue("jdbc");
			dataMap.put("properties", jdbc_props);

			Object home = null;
			Object busObj = null;
			Object argArray[] = null;
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				home = ServiceLocator.getInstance().getHome(
						OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"),
						ORReviewResultHome.class, true);
				busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				argArray = new Object[2];
				argArray[0] = dataMap;
				argArray[1] = sqlMap;
				Class[] paramArray = new Class[2];
				paramArray[0] = dataMap.getClass();
				paramArray[1] = sqlMap.getClass();
				map = (HashMap) (busObj
						.getClass().getMethod("insert", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				
				Object result = map.get("result");
				if(result instanceof Boolean){
					if(!((Boolean)result).booleanValue()){
				%>
				<script>
				alert("Could not complete the review.");
				</script>
				<%		
					}
				}else{
				%>
				<script>
				alert("Could not complete the review. Error in getting result from EJB layer ");
				</script>
				<%
				}
				
				// set the search clicked so that new set of pending results
				// are fetched from db
				if("Y".equalsIgnoreCase(searchClicked)){
					searchClicked = "Y";
				}
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
		}

		// this code is for forward functionality
		if ("Y".equalsIgnoreCase(forwardReviewClicked)) {

			String hist_rec_type = "";
			String contr_sys_id = "";
			String event_code = "";
			String accession_num = "";
			String review_type = "";
			String create_date_time = "";
			String review_remarks = "";
			String normalcy_ind = "";

			String practitionerId = (String) session
					.getValue("ca_practitioner_id");
			StringTokenizer stTokenizer = new StringTokenizer(selectedRows,
					",");
			String token = null;
			String record[] = null;
			int selectionCounter = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			// this list will have the details of all the records
			// being forwarded
			List<Map<String,String>> forwardPractDetailsList = new ArrayList<Map<String,String>>();
			// Map will have the details about one record being forwarded
			Map<String,String> forwardPractDetailsMap = new HashMap<String,String>();
			
			int commaIndex = selectedRows.indexOf(",");
			if(commaIndex < 0 && !selectedRows.trim().equals("")){
				token = selectedRows;
				hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
				contr_sys_id = request.getParameter("hdnControlSysId"
						+ token);
				event_code = request
						.getParameter("hdnEventCode" + token);
				accession_num = request.getParameter("hdnAccessionNum"
						+ token);
				review_type = request.getParameter("hdnReviewType"
						+ token);
				normalcy_ind = request.getParameter("hdnNormalcyIndicator"+token);
				
				forwardPractDetailsMap.put("hist_rec_type", hist_rec_type);
				forwardPractDetailsMap.put("contr_sys_id", contr_sys_id);
				forwardPractDetailsMap.put("accession_num", accession_num);
				forwardPractDetailsMap.put("review_type", review_type);
				forwardPractDetailsMap.put("event_code", event_code);
				forwardPractDetailsMap.put("normalcy_ind", normalcy_ind);
				
				forwardPractDetailsList.add(forwardPractDetailsMap);
				selectionCounter++;
			}
			else{
				if (stTokenizer != null) {
					while (stTokenizer.hasMoreTokens()) {
						token = stTokenizer.nextToken();
						token = token.trim();
	
						// now get the individual fields
						hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
						contr_sys_id = request.getParameter("hdnControlSysId"
								+ token);
						event_code = request
								.getParameter("hdnEventCode" + token);
						accession_num = request.getParameter("hdnAccessionNum"
								+ token);
						review_type = request.getParameter("hdnReviewType"
								+ token);
						normalcy_ind = request.getParameter("hdnNormalcyIndicator"+token);
						
						selectionCounter++;
					}
				}
			}

			// now form the forward practitioner id list
			List<String> forwardPractIdList = new ArrayList<String>();
			// get the practitioner id to forward the result
			// from the request parameter
			// presently the assumption is that this parameter will contain
			// only one practitioner id - in future, multiple practitioner
			// id selection can be also be supported by setting
			// a comma separated string in the parameter
			String forwardPractId = request.getParameter("hdnPractCode");
			forwardPractIdList.add(forwardPractId);
			dataMap.put("forwardPract_id",forwardPractIdList);
			
			// this is the key used in the desktop application
			// and only this key is understood by the ejb
			dataMap.put("forwardPractHash", forwardPractDetailsList);
			// now set the practitioner id, login id and the total count
			// in this case, login id and practitioner id are the same
			dataMap.put("pract_id", practitionerId);
			dataMap.put("login_by_id", practitionerId);
			// no need to send the total count as it is not needed
			//dataMap.put("totalCount", "" + selectionCounter);

			Map<String, String> sqlMap = new HashMap<String, String>();
			try {
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT",
						OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT") );
	            sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK",
	            		OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK") );
			} catch (Exception e) {
				e.printStackTrace();
				// nothing much can be done here
				%>
				<script>
				alert("Could not forward the result.");
				</script>
				<%
			}
			// get the properties to be passed to EJB from session
			Properties jdbc_props = (Properties) session.getValue("jdbc");
			dataMap.put("properties", jdbc_props);

			Object home = null;
			Object busObj = null;
			Object argArray[] = null;
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				home = ServiceLocator.getInstance().getHome(
						OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"),
						ORReviewResultHome.class, true);
				busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				argArray = new Object[2];
				argArray[0] = dataMap;
				argArray[1] = sqlMap;
				Class[] paramArray = new Class[2];
				paramArray[0] = dataMap.getClass();
				paramArray[1] = sqlMap.getClass();
				map = (HashMap) (busObj
						.getClass().getMethod("modify", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				
				Object result = map.get("result");
				if(result instanceof Boolean){
					if(!((Boolean)result).booleanValue()){
				%>
				<script>
				alert("Could not forward the result.");
				</script>
				<%		
					}else{
				%>
				<script>
				alert("Successfully forwarded the result.");
				</script>
				<%		
					}
				}else{
				%>
				<script>
				alert("Could not forward the result. Error in getting result from EJB layer ");
				</script>
				<%
				}
				
				// set the search clicked so that new set of pending results
				// are fetched from db
				if("Y".equalsIgnoreCase(searchClicked)){
					searchClicked = "Y";
				}
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
		}

		int patientCounter = 0;
		
		if ("Y".equalsIgnoreCase(searchClicked)) {
			PendingResultsRequest pendingResultsRequest = new PendingResultsRequest();
			pendingResultsRequest.setRequest(request);
			pendingResultsRequest.setSession(session);
			pendingResultsRequest.setNormalcyIndicator(normalcy);
			pendingResultsRequest.setLocale(IPADConstants.LOCALE);

			PendingResults beanInst = new PendingResults();
			pendingResultsResponse = beanInst
					.getPendingResults(pendingResultsRequest);
			pendingResultMap = pendingResultsResponse
					.getPendingResultsMap();
			totalRecords = pendingResultsResponse.getTotalRecords();

			if (pendingResultMap == null || pendingResultMap.isEmpty()) {
	%>
			
			
			<%= IPADConstants.NORECORDS_HTML%>
			<%
					} else {
							Set<Entry<PatientDetail, PendingResultForPatient>> entrySet = pendingResultMap
									.entrySet();
							Iterator<Entry<PatientDetail, PendingResultForPatient>> iterator = entrySet
									.iterator();
							Entry<PatientDetail, PendingResultForPatient> entry = null;
							PatientDetail patientDetail = null;
							String patientDetailString = null;
							// this var is used as the parameter
							// passed to the expand or hide js function parameter
							// basically this var will contain the patient name
							// without single quote
							String patDtlStrForDisplay = null;
							int pendingResultCount = 0;

							
							
							PendingResultForPatient pendingResultForPatient = null;
							Map<ResultCategory, List<ResultDetail>> pendingResultMapForPatient = null;
							ResultCategory resultCategory = null;
							Entry<ResultCategory, List<ResultDetail>> resultCatEntry = null;
							while (iterator.hasNext()) {
								
								// increment the patient counter
								patientCounter++;
								
								entry = iterator.next();
								patientDetail = entry.getKey();
								patientDetailString = patientDetail.getPatientName();
								
								// code added to fix the bug where if the patient name
								// itself contains a single quote then the 
								// javascript function called to expand or hide does not
								// work - in fact the js function itself is not being called
								patDtlStrForDisplay = "";
								int charIndex = 0;
								int oldIndex = 0;
								while(true){
									charIndex = patientDetailString.indexOf("'",charIndex);
									if(charIndex < 0){
										break;
									}
									if(oldIndex < charIndex){
										oldIndex++;
									}
									patDtlStrForDisplay += patientDetailString.substring(oldIndex, charIndex);
									oldIndex = charIndex;
									charIndex++;
								}
								if(oldIndex > 0){
									patDtlStrForDisplay += patientDetailString.substring(oldIndex+1);	
								}else{
									patDtlStrForDisplay += patientDetailString;
								}
								
								
								patientDetailString += " ";
								patientDetailString += patientDetail.getAge();
								patientDetailString += ",";
								patientDetailString += patientDetail.getSex();
								patientDetailString += "    ";
								//patientDetailString += patientDetail.getPatientId();

								pendingResultForPatient = entry.getValue();
								pendingResultCount = pendingResultForPatient
										.getPendingRecordCountForPatient();
				%>
			
			<input type="hidden" id="hdnTotalRecords" name="hdnTotalRecords" id="hdnTotalRecords" value="<%=totalRecords%>"/>
			
				<table style="width: 100%; border: 1px solid #afb0b0" border="0"
				cellspacing="0" cellpadding="0">
				<tr class='trResultsHeader'>
					<td style='width: 4%' align="center" valign="middle"><img
						src="../images/More group icon main.png"
						onclick="DisplayOrHideDetails('<%=patDtlStrForDisplay%>' , this)"></img></td>
					<td style='width: 96%' align='left'>
						<table style="width: 100%;" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td style='width: 25%' align='left'>
								<span
									class="spWidHeaderAllergies"><b><%=patientDetailString%></b></span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<span
									class="spWidHeaderAllergies"><b><%=patientDetail.getPatientId()%></b></span>	
								</td>
								
								<td style="width:6%" align="center">
									<span><%=pendingResultCount%>
									</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<%
					pendingResultMapForPatient = pendingResultForPatient
										.getPendingResultMapForPatient();
								Set<Entry<ResultCategory, List<ResultDetail>>> resultCatSet = pendingResultMapForPatient
										.entrySet();
								Iterator<Entry<ResultCategory, List<ResultDetail>>> resultCatItr = resultCatSet
										.iterator();
								List<ResultDetail> resultDetailList = null;
								while (resultCatItr.hasNext()) {
									resultCatEntry = resultCatItr.next();
									resultCategory = resultCatEntry.getKey();
									//pendingResultCount = pendingResultForPatient.getPatientRecordCountForCategory(resultCategory);

									resultDetailList = resultCatEntry.getValue();
									if (resultDetailList != null
											&& !resultDetailList.isEmpty()) {
				%>
				
				<div data-role="none" data-class="<%=patDtlStrForDisplay%>" style="display:none">
					<table style="width: 100%; border: 1px solid #afb0b0" border="0"
					cellspacing="0" cellpadding="0">

						<tr class="trAllergySummary">
							<td style='width: 4%; height:100%' align="center" valign="middle">
								<input type="checkbox" id="checkb<%=patientCounter%>" name="checkb<%=patientCounter%>" onclick="selectPatientCategories()" value="<%=resultDetailList.size()%>"/>
							</td>
							
							<td style='width: 96%' align='left'>
								<table style="width: 100%;border: 1px solid #48d1d8;" border="0" cellspacing="0"
									cellpadding="0">
									<tr>
									<td>
										<table style="width: 100%;" border="0" cellspacing="0"
									cellpadding="0">
										<tr style="width: 100%;" class="resultCategoryHeader">
										<td style="width: 2%" align="center">
										&nbsp;	
										</td>
										<td style='width: 35%' align='left'>
											<span class="resultCategoryStyle"><%=resultCategory.getCategory()%>
											</span>
										</td>
										</tr>
										</table>
									</td>	
									</tr>
								
						<%
								
									String eventName = null;
									final String REPORTEDBY = "Reported by";
									final String AT = "at";
									String practitioner = null;
									String reportedTime = null;
									StringBuffer resultBuff = new StringBuffer();
									String resultNum = "";
									String resultNumUom = "";
									String completeResult = "";
									String notesType = null;
									String normalLow = "";
									String normalHigh = "";
									String resultStr = "";
									int recordIndex = 0;

									String patient_Id = null;
									String eventClass = null;
									String eventGroup = null;
									String eventCode = null;
									String histRecType = null;
									String normalcyInd = null;
									// extra parameters needed for processing
									String sysId = null;
									String accessionNum = null;
									String createDateTime = null;
									String reviewType = null;
									String controlSysEventCode = null;
									String encounterId = null;

									// iterate through the records and show the results
									for (ResultDetail resultDetail : resultDetailList) {

										patient_Id = resultDetail.getPatientId();
										patient_Id = CommonBean.checkForNull(patient_Id);
										eventClass = resultDetail.getEventClass();
										eventClass = CommonBean.checkForNull(eventClass);
										eventGroup = resultDetail.getEventGroup();
										eventGroup = CommonBean.checkForNull(eventGroup);
										eventCode = resultDetail.getEventCode();
										eventCode = CommonBean.checkForNull(eventCode);
										histRecType = resultDetail
												.getHistoryRecType();
										normalcyInd = resultDetail.getNormalcyInd();
										normalcyInd = CommonBean
												.checkForNull(normalcyInd);

										sysId = resultDetail.getSysId();
										sysId = CommonBean.checkForNull(sysId);

										accessionNum = resultDetail
												.getAccessionNum();
										accessionNum = CommonBean
												.checkForNull(accessionNum);

										createDateTime = resultDetail
												.getCreateDateTime();
										createDateTime = CommonBean
												.checkForNull(createDateTime);
										createDateTime = DateUtils
												.convertDate(createDateTime,
														"DMYHM", "en", "en");

										reviewType = resultDetail.getReviewType();
										reviewType = CommonBean
												.checkForNull(reviewType);

										controlSysEventCode = resultDetail
												.getContrSysEventCode();
										controlSysEventCode = CommonBean
												.checkForNull(controlSysEventCode);
										
										encounterId = resultDetail.getEncounterId();
										encounterId = CommonBean.checkForNull(encounterId);

										// this code will form the result string 
										// which needs to be shown in the GUI
										resultBuff.delete(0, resultBuff.length());
										eventName = resultDetail.getEventName();
										practitioner = resultDetail.getReportedBy();
										reportedTime = resultDetail.getReportedAt();
										resultBuff.append(eventName).append("- ");
										resultBuff.append(REPORTEDBY).append(" ");
										resultBuff.append(practitioner).append(" ");
										resultBuff.append(AT).append(" ");
										resultBuff.append(reportedTime);

										notesType = resultDetail.getNotesType();
										resultStr = resultDetail.getResultStr();
										resultNum = resultDetail.getResultNum();
										resultNumUom = resultDetail
												.getResultNumUom();
										normalLow = resultDetail.getNormalLow();
										normalHigh = resultDetail.getNormalHigh();
										if ("NUM".equalsIgnoreCase(notesType)) {
											completeResult = resultNum
													+ "&nbsp;&nbsp;" + resultNumUom
													+ "&nbsp;&nbsp;" + "("
													+ normalLow + "-" + normalHigh
													+ ")";
										} else if ("STR"
												.equalsIgnoreCase(notesType)) {

										}
							%>
				<input type="hidden" name="hdnPatientId<%=recordCounter%>" id="hdnPatientId<%=recordCounter%>" id="hdnPatientId<%=recordCounter%>" value="<%=patient_Id%>"/>
				<input type="hidden" name="hdnEventClass<%=recordCounter%>" id="hdnEventClass<%=recordCounter%>" id="hdnEventClass<%=recordCounter%>" value="<%=eventClass%>"/>
				<input type="hidden" name="hdnEventCode<%=recordCounter%>" id="hdnEventCode<%=recordCounter%>" id="hdnEventCode<%=recordCounter%>" value="<%=eventCode%>"/>
				<input type="hidden" name="hdnEventGroup<%=recordCounter%>" id="hdnEventGroup<%=recordCounter%>" id="hdnEventGroup<%=recordCounter%>" value="<%=eventGroup%>"/>
				<input type="hidden" name="hdnHistRectType<%=recordCounter%>" id="hdnHistRectType<%=recordCounter%>" id="hdnHistRectType<%=recordCounter%>" value="<%=histRecType%>"/>
				<input type="hidden" name="hdnNormalcyIndicator<%=recordCounter%>" id="hdnNormalcyIndicator<%=recordCounter%>" id="hdnNormalcyIndicator<%=recordCounter%>" value="<%=normalcyInd%>"/>
				<input type="hidden" name="hdnControlSysId<%=recordCounter%>" id="hdnControlSysId<%=recordCounter%>" id="hdnControlSysId<%=recordCounter%>" value="<%=sysId%>"/>
				<input type="hidden" name="hdnAccessionNum<%=recordCounter%>" id="hdnAccessionNum<%=recordCounter%>" id="hdnAccessionNum<%=recordCounter%>" value="<%=accessionNum%>" />
				<input type="hidden" name="hdnReviewRemarks<%=recordCounter%>" id="hdnReviewRemarks<%=recordCounter%>" id="hdnReviewRemarks<%=recordCounter%>" value=""/>
				<input type="hidden" name="hdnReviewType<%=recordCounter%>" id="hdnReviewType<%=recordCounter%>" id="hdnReviewType<%=recordCounter%>" value="<%=reviewType%>"/>
				<input type="hidden" name="hdnCreationDateTime<%=recordCounter%>" id="hdnCreationDateTime<%=recordCounter%>" id="hdnCreationDateTime<%=recordCounter%>" value="<%=createDateTime%>"/>
				<input type="hidden" name="hdnControlSysEventCode<%=recordCounter%>" id="hdnControlSysEventCode<%=recordCounter%>" id="hdnControlSysEventCode<%=recordCounter%>" value="<%=controlSysEventCode%>"/>
				<input type="hidden" name="hdnEncounterId<%=recordCounter%>" id="hdnEncounterId<%=recordCounter%>" id="hdnEncounterId<%=recordCounter%>" value="<%=encounterId%>"/>
				
				<tr>
				<td>	
				 <div data-role = "none" data-class = "<%=resultCategory.getCategory()%>" style = "display:block" data-childrows = "<%=resultCategory.getCategory()%>">
     				 <table style = "width:100%" border = "0" cellspacing = "0" cellpadding = "0">
     					<tr class = "trResultDetails" >
       						 
        					<td style = 'width:100%'>
          
          					 <table style= 'width:100%;height:100%' border = "0" cellspacing = '0' cellpadding = '0' class = "tbResultDetails">
             					 <tr style = 'width:100%;height:100%'>
                				
               					 <td style = 'width:100%;<%if ((recordIndex % 2) == 0) {%>background:#cccccc;<%} else {%>background:#ffffff;<%}%>' valign = "center">
								 	<table style = 'width:100%;height:100%' border = '0' cellspacing = '0' cellpadding = '0'>
                      				<tr style = 'width:100%;height:100%'>
                      					<td style = 'width:5%'>
                      						<input type="checkbox" id='check<%=recordCounter%>' name='check<%=recordCounter%>' value=""/>
                      					</td>
                      					<td style ="width:50%" align="left">
                      						<table style = 'width:100%;height:100%' border = '0' cellspacing = '0' cellpadding = '0'>
                      							<tr>
                      								<td width="100%">
                      								<span class="resultStyle"><%=resultBuff.toString()%></span>
                      								</td>                      								
                      							</tr>
                      							<tr>
                      								<td width="100%">
                      								<span class="resultStyle">
                      								<%=completeResult%>
                      								</span>
                      								</td>
                      							</tr>
                      						</table>	
                      					</td>
                      					<td style="width:6%" align="center">
                      					<%
                      						// TODO
       												// need to get the count of previous results
       												PreviousResultsRequest previousResultsRequest = new PreviousResultsRequest();
       												previousResultsRequest.setRequest(request);
       												previousResultsRequest.setSession(session);
       												previousResultsRequest
       														.setPatientId(patient_Id);
       												previousResultsRequest
       														.setLocale(IPADConstants.LOCALE);
       												previousResultsRequest
       														.setEventClass(eventClass);
       												previousResultsRequest
       														.setEventCode(eventCode);
       												previousResultsRequest
       														.setEventGroup(eventGroup);
       												previousResultsRequest
       														.setHistRectType(histRecType);
       												previousResultsRequest.setMaskDates(true);

       												PrevResultCountResponse prevResultCountResponse = beanInst
       														.getPreviousResultsCount(previousResultsRequest);
       												List<PrevResultDateContainer> previousResultsCountList = prevResultCountResponse
       														.getPrevResultDateContainerList();
       												if (previousResultsCountList != null
       														&& !previousResultsCountList
       																.isEmpty()) {
                      					%>
                      						<a href="" onclick="showPreviousResults('<%=recordCounter%>')" ><img src="../images/More.png"  ></img></a>
                      					<%
                      						}
                      					%>	
                      					</td>
                      				</tr>
                      				</table>
                      			</td>
                      			</tr>
                      			</table>	
                      			
                      		</td>
                      		</tr>
                      	</table>			 
                       </div>
                       
                     </td>  
                     </tr>   
        			
				<%
           								recordIndex++;
           														// this is a global counter
           								recordCounter++;
           						}
           				%>
				</table>               
                   </td>			
				</tr>				
			</table>
		</div>
				<%
							}
						}
					}

				}
			}
				%>
	
	</div>
	
	<input type="hidden" id="hdnPatientCounter" name="hdnPatientCounter" id="hdnPatientCounter" value="<%=patientCounter %>"/>
	
	</form>
	
	 <div data-role="none" id='Dialog' style="width:100%; height:auto;display:none;background:#ffffff;">
    	 <iframe src = "" width = "100%" height = "1000px" scrolling = "yes" id="srchFrame" frameborder="0"></iframe>  
	 </div>
	
	</section>
	
<script>
window.onload = initializefunction();
function initializefunction(){
	//searchPendingResults();
}

function changeOrientation(orient)
{
}

</script>	
	
</body>
</html>

