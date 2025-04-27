<!DOCTYPE html>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="java.sql.*,java.io.*,eIPAD.clinicaleventhistory.*,eIPAD.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />
<link rel="stylesheet" href="../css/iPadViewClinicalEventHistory.css" />
<script src="../jquery-1.5.2.min.js"></script>
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script>
function loadWidgets()
{
	window.parent.showLoadingMsg();
}

function collapseExpand(obj,index)
{
	var tableObject = document.getElementById("tableId"+index);
	if(obj.value == ' - ')
	{
		tableObject.style.display = 'none';
		tableObject.width='100%';
		obj.value = ' + ';
	}
	else if(obj.value == ' + ')
	{
		tableObject.style.display = 'inline';
		tableObject.width='100%';
		obj.value = ' - ';
	}
}

function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)
{
	var patient_id = "";//document.forms[0].patient_id.value;
	var hiddenPatientId = document.getElementById("hiddenPatientId");
	if(hiddenPatientId){
		//alert(hiddenPatientId.value);
		patient_id = hiddenPatientId.value;
	}
	
	var enc_id = "";//document.forms[0].enc_id.value;
	var encounterIdCombo = document.getElementById("EncounterIDComp");
	if(encounterIdCombo){
		//alert('selected index ='+encounterIdCombo.selectedIndex+';options length='+encounterIdCombo.length);
		var selectedEncounterIndex = encounterIdCombo.selectedIndex;
		if(selectedEncounterIndex >=0){
			enc_id = encounterIdCombo.options[selectedEncounterIndex].value;
			//alert(enc_id);
		}
	}
	
	var win_height		= "37.5";
	var win_width		= "50";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "37.5";
		win_width		= "50";
		//win_top			= "200";
		//win_scroll_yn	= "no";
	}

	var retVal = new String();
	//var dialogHeight = "28" ;
	//var dialogWidth = "50" ;
	
	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = "122";
	var status = "no";
	var scroll = win_scroll_yn;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
	var arguments	= Accessionnum ;
	
	Accessionnum	=	escape(Accessionnum);
	
	document.getElementById("notesContentFrame1").src = "NotesDetail.jsp?"+"Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id;
	$.mobile.changePage("#notesContentFrame", "pop", false,false);
	//var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id;//INO30714
	//retVal = window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?"+finalString,arguments,features);
}

function closenotes()
{
	 $.mobile.changePage("mainpage","pop", true,false);
}
</script>
</head>
<body>
<%
	String patientid = request.getParameter("patient_id");
	if (patientid == null) {
		patientid = "";
	}
	String facilityid = request.getParameter("facility_id");
	if (facilityid == null) {
		facilityid = "";
	}
	String patientList = request.getParameter("patientlist");
	if (patientList == null || patientList.trim().equals("")) {
		patientList = request.getParameter("hiddenPatientClass");
		patientList = CommonBean.checkForNull(patientList,IPADConstants.INPATIENT_KEYWORD);
	}
	
	String selectedTimePeriod = request.getParameter("selectedperiod");
	if(selectedTimePeriod == null || selectedTimePeriod.trim().equals("")){
		selectedTimePeriod = IPADConstants.LAST_ONE_DAY;
	}

	// get the patient class data
	PatientClassRequest patientClassRequest = new PatientClassRequest();
	patientClassRequest.setPatientId(patientid);
	patientClassRequest.setFacilityId(facilityid);
	patientClassRequest.setRequest(request);
	patientClassRequest.setSession(session);

	ClinicalEventHistory beanInst = new ClinicalEventHistory();
	String patientClass = "";
	/* PatientClassResponse patientClassResponse = beanInst.getPatientClass(patientClassRequest);
	if(patientClassResponse != null){
		patientClass = patientClassResponse.getPatientClass();
	}
	// just a safe check and reinitialization
	if(patientClass == null){
		patientClass = "";
	} */

	PatientClassAndEncounterIdRequest patClassEncounterIdRequest = new PatientClassAndEncounterIdRequest();
	patClassEncounterIdRequest.setPatientId(patientid);
	patClassEncounterIdRequest.setFacilityId(facilityid);
	patClassEncounterIdRequest.setRequest(request);
	patClassEncounterIdRequest.setSession(session);
	// for the first time when this page is loaded, the selected time period is Last one day
	patClassEncounterIdRequest.setSelectedTimePeriod("LOD");

	PatientClassAndEncounterIdResponse patClassEncounterIdResponse = beanInst
			.getPatientClassAndEncounterIdList(patClassEncounterIdRequest);
	Map<PatientClassResponse, List<EncounterIdContainer>> dataMap = patClassEncounterIdResponse
			.getDataMap();
	Set<PatientClassResponse> patientClassSet = null;
	if (dataMap != null) {
		patientClassSet = dataMap.keySet();
	}
	// this is for storing the last patient class which
	// is obtained from the patient iterator
	String lastPatientClass = null;
	Iterator<PatientClassResponse> patientClassItr = null;
	List<EncounterIdContainer> ipEncounterIdList = new ArrayList<EncounterIdContainer>();
	if (patientClassSet != null && !patientClassSet.isEmpty()) {
		patientClassItr = patientClassSet.iterator();
	}
	
	if (patientClassItr != null) {
		PatientClassResponse patClassResponse = null;
		while (patientClassItr.hasNext()) {
			patClassResponse = patientClassItr.next();
			lastPatientClass = patClassResponse.getPatientClass();
			ipEncounterIdList = dataMap.get(patClassResponse);
		}
	}
%>
<script type="text/javascript">
var periodCombo = document.getElementById("PeriodComp");
var onchangehandler = function(){
	var resultsDivComp = document.getElementById("resultsdiv");
	if(resultsDivComp){
		resultsDivComp.innerHTML = "";	
	}
	
	calculateTimePeriod();
	calculateToPeriod();
	getEncounterId();
	setTimeout("getEventHistoryRecords()",300);
	collapseAllTables();
}

var encounterIdChangeHandler = function(){
	var resultsDivComp = document.getElementById("resultsdiv");
	if(resultsDivComp){
		resultsDivComp.innerHTML = "";	
	}
	setTimeout("getEventHistoryRecords()",300);
	collapseAllTables();
}

var patientClassChangeHandler = function(){
	var resultsDivComp = document.getElementById("resultsdiv");
	if(resultsDivComp){
		resultsDivComp.innerHTML = "";	
	}
	getEncounterId();
	setTimeout("getEventHistoryRecords()",300);
	collapseAllTables();
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<section id = "mainpage" data-role="page" style="padding:0px;background:#ffffff">
	<form name="viewClinicalEventHist" id="viewClinicalEventHist" id="viewClinicalEventHist">
		<div data-role="none" id='dvmain' class='divmain' style="padding: 0px">
			<div data-role="none" class="divHeader">
				<table style="width: 100%; height: 100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr style="width: 100%; height: 100%">
						<td style="width: 95%" align="left" valign="center"><span
							class="spanHeader">Clinical Event History</span></td>
						<td style="width: 5%" align="center" valign="middle"
							onclick="loadWidgets()"><img
							src="../images/Close.png"></img></td>
					</tr>
				</table>
			</div>
			<div id="dvCriteria" data-role="none" style = "height:65px;overflow :none">
				<table style="height:65px;width: 100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr style="height:30px; width: 100%">
						<td align="left" valign = "bottom" style="width: 20%"><span
							class="spanFilterCriteria">Period</span></td>
						<td align="left" style="width: 20%" valign = "bottom"><span
							class="spanFilterCriteria" valign = "bottom">Encounter Type</span></td>
						<td align="left" style="width: 20%" valign = "bottom"><span
							class="spanFilterCriteria">Encounter ID</span></td>
						<td align="left" style="width: 4%"></td>
						<td align="left" style="width: 36%" valign = "bottom">
						   <span id="EncounterPeriodFullText" class="spanEncounterPeriod1">Encounter Period: </span>
						</td>
					</tr>
					<tr style="height:35px; width: 100%">
						<td align="left" style="width: 20%" valign = "top">
						<select id="PeriodComp" data-role="none" class="cmbFilterBy" onchange="">
								<%
								if(IPADConstants.LAST_ONE_DAY.equals(selectedTimePeriod)){
								%>
								<option value="LOD" selected="selected">Last One Day</option>
								<%
								} else{
								%>	
								<option value="LOD">Last One Day</option>
								
								<%
								}
								if(IPADConstants.LAST_THREE_DAYS.equals(selectedTimePeriod)){
								%>
									<option value="LTD" selected="selected">Last Three Days</option>
								<%
								} else{
									%>	
									<option value="LTD">Last Three Days</option>
								<%
								}
								if(IPADConstants.LAST_ONE_WEEK.equals(selectedTimePeriod)){
								%>
								<option value="LOW" selected="selected">Last One Week</option>
								<%
								} else{
								%>	
								<option value="LOW">Last One Week</option>
								
								<%
								}
								if(IPADConstants.LAST_ONE_MONTH.equals(selectedTimePeriod)){
								%>
								<option value="LOM" selected="selected">Last One Month</option>
								<%
								} else{
								%>	
								<option value="LOM">Last One Month</option>
								
								<%
								}
								if(IPADConstants.LAST_ONE_YEAR.equals(selectedTimePeriod)){
								%>
								<option value="LOY" selected="selected">Last One Year</option>
								<%
								} else{
								%>	
								<option value="LOY">Last One Year</option>
								
								<%
								}
								%>
						</select>
						
						</td>
						<td align="left" style="width: 20%" valign = "top">
						<select
							id="encounterTypeComp" data-role="none" class="cmbFilterBy">
							<option value="OP">Outpatient</option>
							<option selected="selected" value="IP">Inpatient</option>
							<option value="DC">Daycare</option>
							<option value="EM">Emergency</option>	
						</select>
						</td>
						<td align="left" style="width: 20%" valign = "top">
						<select
							id="EncounterIDComp" data-role="none" class="cmbFilterBy">
						<%
							if (ipEncounterIdList != null && !ipEncounterIdList.isEmpty()) {
								for (EncounterIdContainer encounterId : ipEncounterIdList) {
						%>
								<option><%=encounterId.getEncounterId()%></option>
							<%
								}
							}
							%>
								
						</select></td>
						<td align="right" style="width: 4%;padding-right:5px;" valign = "top">
						&nbsp;
						
						</td>
						<td align="left" style="width : 36%" valign = "top">
						
						<table border="0" style="width : 100%">
						  <!-- 
						    <tr>
							     <td align="left" valign = "top">
							        <span id="EncounterPeriodFullText" class="spanEncounterPeriod1">Encounter Period: </span>
							     </td>
							     <td>
							       &nbsp;
							     </td>
							        <td>
							       &nbsp;
							     </td>
							        <td>
							       &nbsp;
							     </td>
						    </tr>
						     -->
							<tr style = "width:100%">
							  <td style = "width:100%">
							    <table border="0" style="width:100%" cellspacing = "0" cellpadding = "0">
							       <tr>
										<td align="left" style = "width:5%">
										<span id="EncounterPeriodFromText" class="spanEncounterPeriod1">From</span>
										</td>
										<td align="center" style = "width:45%">
										<span id="EncounterPeriodFromValue" class="spanEncounterPeriod1"></span>
										</td>
										<td align="center" style = "width:5%">
										<span id="EncounterPeriodToText" class="spanEncounterPeriod1">To</span>
										</td>
										<td align="center" style = "width:45%">
										<span id="EncounterPeriodToValue" class="spanEncounterPeriod1"></span>
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
			
			<input type="hidden" id="hiddenPatientId" value="<%=patientid %>"/>
			<input type="hidden" id="hiddenFacilityId" value="<%=facilityid %>"/>
			<input type="hidden" id="hiddenPatientClass" value="<%=patientList %>"/>
			<input type="hidden" id="hiddenLastPatientClass" value="<%=lastPatientClass%>"/>
			
	</form>
	<div id="resultsdiv" style="min-height: 381px;">
	<%
		/* ClinicalEventHistory eventHistory = new ClinicalEventHistory();
		EventHistoryRequest eventHistoryRequest = new EventHistoryRequest();
		eventHistoryRequest.setRequest(request);
		eventHistoryRequest.setSession(session);
		eventHistoryRequest.setPatientId(patientid);
		eventHistoryRequest.setFacilityId(facilityid);
		eventHistoryRequest.setPatientClass(patientList);
		eventHistoryRequest.setLocale("en");
		// need to find out how encounter id from the html component
		// can be passed here
		eventHistoryRequest.setEncounterId("");
		eventHistoryRequest.setSelectedTimePeriod("");
		
		EventHistoryResponse eventHistoryResponse = eventHistory
				.getEventHistory(eventHistoryRequest); */
		
	%>
	
	
	</div>
	
	<div id="icondiv" style="width:100%;height:15%;background:#ffffff">
	  <table width="80%" border=0>
	  	<tr>
	  		<td width="8%" align="center">
	  			<img src="../images/NI_High.gif"/>
	  			<span>High</span>
	  		</td>
	  		<td width="8%" align="center">
	  			<img src="../images/NI_Low.gif"/>
	  			<span>Low</span>
	  		</td>
	  		<td width="12%" align="center">
	  			<img src="../images/NI_Abnormal.gif"/>
	  			<span>Abnormal</span>
	  		</td>
	  		<td width="10%" align="center">
	  			<img src="../images/NI_Critical.gif"/>
	  			<span>Critical</span>
	  		</td>
	  		<td width="15%" align="center">
	  			<img src="../images/NI_CriticallyHigh.gif"/>
	  			<span>Critical High</span>
	  		</td>
	  		<td width="15%" align="center">
	  			<img src="../images/NI_CriticallyLow.gif"/>
	  			<span>Critical Low</span>
	  		</td>
	  		<td width="10%" align="center">
	  			<img src="../images/NI_Normal.gif"/>
	  			<span>Normal</span>
	  		</td>
	  	</tr>
	  </table>
	  </div>
	
	
	</section>
	
	<section id="notesContentFrame" data-role = "page" style = "background-color: #ffffff;padding:0px">
	  <div  style = "height:auto;overflow:auto;padding:0px;background-color: #ffffff" data-role = "none">
     	<iframe frameborder="0" id="notesContentFrame1" src="" scrolling ="yes" style="padding:0px;display:block" width = "100%"  ></iframe>
     </div>
	</section>
	
	<script>
	window.onload = initializeFunction;
	
		function initializeFunction(){
			bindFunction();
			calculateTimePeriod();
			calculateToPeriod();
			setPatientClass();
			//getEventHistoryRecords();
			setTimeout("getEventHistoryRecords()",300);
			collapseAllTables();
		}
	
		function bindFunction(){
			var periodCombo = document.getElementById("PeriodComp");
			if(periodCombo){
				periodCombo.onchange=onchangehandler;	
			}
			var encounterIdCombo = document.getElementById("EncounterIDComp");
			if(encounterIdCombo){
				encounterIdCombo.onchange = encounterIdChangeHandler;
			}
			var patientClassCombo = document.getElementById("encounterTypeComp");
			var selectedPatientClass;
			if (patientClassCombo) {
				patientClassCombo.onchange = patientClassChangeHandler;
			}
		}
	
		function calculateTimePeriod() {
			var periodCombo = document.getElementById("PeriodComp");
			
			var selectedValue;
			if (periodCombo) {
				selectedValue = periodCombo.options[periodCombo.selectedIndex].value;
			}

			var xmlHttp = getHttpObject();
			xmlHttp.onreadystatechange=function(){
				//alert(xmlHttp.readyState+' '+xmlHttp.status);
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					//alert(xmlHttp.responseText);
					document.getElementById("EncounterPeriodFromValue").innerHTML=xmlHttp.responseText;
					
				}
			}
			
			xmlHttp.open("POST", "../../servlet/eIPAD.clinicaleventhistory.servlet.EncounterPeriodServlet", true);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			var sendString = "timeperiod="+selectedValue+"&datetype=From";
			xmlHttp.send(sendString);

		}
		
		function calculateToPeriod(){
			//alert('in second function');
			var xmlHttp2 = getHttpObject();
			xmlHttp2.onreadystatechange=function(){
				//alert(xmlHttp2.readyState+' '+xmlHttp2.status);
				if(xmlHttp2.readyState==4 && xmlHttp2.status==200){
					document.getElementById("EncounterPeriodToValue").innerHTML=xmlHttp2.responseText;
				}
			}
			
			xmlHttp2.open("POST", "../../servlet/eIPAD.clinicaleventhistory.servlet.EncounterPeriodServlet", true);
			xmlHttp2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			var sendString = "datetype=To";
			xmlHttp2.send(sendString);
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
		
		function getEventHistoryRecords(){
			var periodCombo = document.getElementById("PeriodComp");
			var selectedPeriod;
			if (periodCombo) {
				selectedPeriod = periodCombo.options[periodCombo.selectedIndex].value;
				//selectedPeriod = "LTY";
			}
			
			var encounterIdCombo = document.getElementById("EncounterIDComp");
			var selectedEncounterId="";
			if(encounterIdCombo){
				//alert('selected index ='+encounterIdCombo.selectedIndex+';options length='+encounterIdCombo.length);
				var selectedEncounterIndex = encounterIdCombo.selectedIndex;
				if(selectedEncounterIndex >=0){
					selectedEncounterId = encounterIdCombo.options[selectedEncounterIndex].value;	
				}else{
					var resultsDivComp = document.getElementById("resultsdiv");
					resultsDivComp.innerHTML = "<table style = 'height:100px;width:100%'><tr style = 'height:100%;width:100%'><td style = 'height:100%;width:100%' align = 'center' valign = 'top'><span style = 'font-name:Arial;font-size:12pt'>No Records Found</span></td></tr> </table>";//"<span>No records found for the selected values</span>";
					return false;
				}
			}
			
			var patientClassCombo = document.getElementById("encounterTypeComp");
			var selectedPatientClass;
			if (patientClassCombo) {
				selectedPatientClass = patientClassCombo.options[patientClassCombo.selectedIndex].value;
			}
			
			var hiddenPatientIdComp = document.getElementById("hiddenPatientId");
			var patientId;
			if(hiddenPatientIdComp){
				patientId = hiddenPatientIdComp.value;
			}
			var hiddenFacilityIdComp = document.getElementById("hiddenFacilityId");
			var facilityId;
			if(hiddenFacilityIdComp){
				facilityId = hiddenFacilityIdComp.value;
			}
			
			var xmlHttp = getHttpObject();
			xmlHttp.onreadystatechange=function(){
				//alert(xmlHttp.readyState+' '+xmlHttp.status);
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					//alert(xmlHttp.responseText);
					document.getElementById("resultsdiv").innerHTML=xmlHttp.responseText;
				}
			}
			
			xmlHttp.open("POST", "../../servlet/eIPAD.clinicaleventhistory.servlet.ClinicalEventHistoryServlet", true);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			var sendString = "selectedperiod="+selectedPeriod+"&patientclass="+selectedPatientClass+"&encounter_id="+selectedEncounterId+"&patientid="+patientId+"&facility_id="+facilityId;
			sendString += "&episode_type=B"+"&hist_type=&event_class=&event_group=&event_item=&event_date=&abnormal=N&normalcy=I&viewconfres=E&performed_by=&errorEvent=&episode_wise=N&viewby=E&graphorder=desc&show_mode=C&relationship_id=";
			xmlHttp.send(sendString);
		}
		
		function getEncounterId(){
			var periodCombo = document.getElementById("PeriodComp");
			var selectedPeriod;
			if (periodCombo) {
				selectedPeriod = periodCombo.options[periodCombo.selectedIndex].value;
			}
			
			var patientClassCombo = document.getElementById("encounterTypeComp");
			var selectedPatientClass;
			if (patientClassCombo) {
				selectedPatientClass = patientClassCombo.options[patientClassCombo.selectedIndex].value;
			}
		
			var hiddenPatientIdComp = document.getElementById("hiddenPatientId");
			var patientId;
			if(hiddenPatientIdComp){
				patientId = hiddenPatientIdComp.value;
			}
			var hiddenFacilityIdComp = document.getElementById("hiddenFacilityId");
			var facilityId;
			if(hiddenFacilityIdComp){
				facilityId = hiddenFacilityIdComp.value;
			}
			
			var xmlHttp = getHttpObject();
			xmlHttp.onreadystatechange=function(){
				//alert(xmlHttp.readyState+' '+xmlHttp.status);
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					var encounterIdComp = document.getElementById("EncounterIDComp");
					if(encounterIdComp){
						encounterIdComp.options.length = 0;
					}
					//alert('response for getencounterid='+xmlHttp.responseText);
					if(encounterIdComp){
						encounterIdComp.innerHTML = xmlHttp.responseText;
					}
					//document.getElementById("EncounterIDComp").innerHTML=xmlHttp.responseText;
				}
			}
			
			xmlHttp.open("POST", "../../servlet/eIPAD.clinicaleventhistory.servlet.EncounterIdServlet", true);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			var sendString = "selectedperiod="+selectedPeriod+"&patientclass="+selectedPatientClass+"&patientid="+patientId+"&facility_id="+facilityId;
			//sendString += "&episode_type=B"+"&hist_type=&event_class=&event_group=&event_item=&event_date=&abnormal=&normalcy=&viewconfres=E&performed_by=&errorEvent=&episode_wise=N&view_by=E&graphorder=desc&show_mode=C&relationship_id=";
			xmlHttp.send(sendString);
			
		}
		
		function setPatientClass(){
			var hiddenLastPatientClassComp = document.getElementById("hiddenLastPatientClass");
			var hiddenLastPatientClass="";
			if(hiddenLastPatientClassComp){
				hiddenLastPatientClass = hiddenLastPatientClassComp.value;
			}
			
			var encounterTypeComp = document.getElementById("encounterTypeComp");
			if(encounterTypeComp){
				//alert('inside comparison');
				if(hiddenLastPatientClass == "IP"){
					encounterTypeComp.selectedIndex = 1;	
				}else if(hiddenLastPatientClass == "OP"){
					encounterTypeComp.selectedIndex = 0;
				}else if(hiddenLastPatientClass == "DC"){
					encounterTypeComp.selectedIndex = 2;
				}else if(hiddenLastPatientClass == "EM"){
					encounterTypeComp.selectedIndex = 3;
				}	
			}
			
			
		}
		
		function collapseAllTables(){
			var index = 1;
			var tableObj;
			//alert('in collapse function');
			while(true){
				tableObj = document.getElementById("tableId"+index);
				//alert(tableObj);
				if(tableObj){
					//tableObj.style.display = 'none';
					index++;
				}else{
					break;
				}
			}
			
		}
		
		function changeOrientation(orient)
		{
			if(orient == "landscape")
			   {
				
			    $("#notesContentFrame1").css('min-height','491px');
			
			    document.getElementById("notesContentFrame1").contentWindow.changeOrientation(orient);
			   
				   
			   }
		     else
			   {
		    	
		    	$("#notesContentFrame1").css('min-height','747px');
		 
		    	 document.getElementById("notesContentFrame1").contentWindow.changeOrientation(orient);
		    
		  	   
			   }
		}
	</script>
	
</body>
</html>

