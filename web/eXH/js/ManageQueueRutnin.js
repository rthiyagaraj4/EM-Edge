function initFunc()
{
	$("#patientID").focus();
}

function searchQueue()
{
	var siteID = $("#siteID ").val();
	var url = "../../eXH/jsp/QueueCriteriaResults.jsp";
	if(siteID == "RT") url = "../../eXH/jsp/QueueCriteriaResultsRutnin.jsp";	
	document.getElementById("queueCriteria").target = "queueResultFrame";
	document.getElementById("queueCriteria").action = url;
	document.getElementById("queueCriteria").submit();
}

function saveData()
{	
//	var submitForm = checkMandatoryFields();
	var submitForm = true;
	if(submitForm)
	{
		document.getElementById("actionType").value = "SAVE";
		document.getElementById("queueCriteria").target = "messageFrame";
		document.getElementById("queueCriteria").action = "../../servlet/eXH.ManagePatientQueue";
		document.getElementById("queueCriteria").submit();
	}
}

function checkMandatoryFields()
{
	var fieldRef = new Array(document.getElementById("patientID"),document.getElementById("encounterID"));
	var filedNames = new Array("Patient ID","Encounter ID");
	return parent.queueQueryFrame.checkFields(fieldRef,filedNames,parent.messageFrame);
}

function clearFrames(eventObj)
{	
	parent.queueResultFrame.location.href = "../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";

	var buttonName = $(eventObj).attr("VALUE");
	if(buttonName == "Save") saveData();
	else if(buttonName == "Call Next Patient") processRequest("","","SI","","","","","CALLNEXT");
	else searchQueue();
}

function buildMenu(patientID,ticketNo,workStation,workflow,userName,scheduledTime,locStatus,nextStation)
{			
	var dataElements = "'"+patientID+"','"+ticketNo+"','"+workStation+"','"+workflow+"','"+userName+"','"+scheduledTime+"','"+nextStation+"'";
	var registerTicket = '<a href="#" onClick='+'\"'+'processRequest('+dataElements+','+'\''+'REGISTER'+'\');'+'\"'+'>Register Ticket</a>';
	var callPatient = '<a href="#" onClick='+'\"'+'processRequest('+dataElements+','+'\''+'CALL'+'\');'+'\"'+'>Call Patient</a>';
	var pending = '<a href="#" onClick='+'\"'+'processRequest('+dataElements+','+'\''+'PENDING'+'\');'+'\"'+'>Pending</a>';
	var transfer = '<a href="#" onClick='+'\"'+'processRequest('+dataElements+','+'\''+'TRANSFER'+'\');'+'\"'+'>Transfer</a>';
	var linkset	= new Array();
	var exists = false;
	
//	if(locStatus == "RE")
//	{
//		linkset[0] = cancelTicket;
//		linkset[0] += callPatient;
//	}
//	else if(locStatus == "CA")
//	{
//		linkset[0] = registerTicket;		
//	}
//	else if(locStatus == "CL" || locStatus == "RC")
//	{
//		linkset[0] = recallPatient;
//		linkset[0] += finishCall;
//	}
//	else if(locStatus == "" || locStatus == "null" || locStatus == "FN")
//	{
//		linkset[0] = registerTicket;		
//	}

	linkset[0] = registerTicket;
	linkset[0] += pending;
	linkset[0] += callPatient;
	linkset[0] += transfer;
		
	dispMenu(linkset);
}

function processRequest(patientID,ticketNo,workStation,workflow,userName,scheduledTime,nextStation,actionType)
{	
	var siteID = "RT";
	var dataElements = "patientID="+patientID
						+"&workStation="+workStation
						+"&workflow="+workflow
						+"&ticketNo="+ticketNo
						+"&actionType="+actionType
						+"&userName="+userName
						+"&scheduledTime="+scheduledTime
						+"&nextStation="+nextStation
						+"&siteID="+siteID;

	$.post('../../servlet/eXH.ManagePatientQueue',
			dataElements,
			function(data) {			
				alert(data);
				parent.queueResultFrame.location.reload();
			},
			'text');	
}

function callNext()
{
	var workStation = $("#workStation :selected").text();
	var loginID = $("#loginID ").val();	

	processRequest("", "", workStation, "", loginID, "", "", "CALLNEXT");
}

function reset()
{
	var queryCriteriaForm = window.queueQueryFrame.document.forms[0];
	queryCriteriaForm.reset();
}
