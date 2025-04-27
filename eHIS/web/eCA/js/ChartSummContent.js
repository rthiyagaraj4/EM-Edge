/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
25/02/2013	IN035924	  Karthi L	 	CA View chart summary “RESULT WIDGET” should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018)
18/02/2021	14773			 Nijitha S		PMG2021-COMN-CRF-0003
---------------------------------------------------------------------------------------------------------
*/


function apply()
{	
	Chart_Create.document.formChartSummContent.action="../../servlet/eCA.ChartSummContentServlet";
	Chart_Create.document.formChartSummContent.target="messageFrame";
	Chart_Create.document.formChartSummContent.method="post";
	Chart_Create.document.formChartSummContent.submit();
}
function reset()
{
	Chart_Create.location.reload();
}

function onSuccess()
{
	Chart_Create.location.reload();
}

var spaceCount = 0;
function Checkspclchars(event,obj)
{	
	if(event.keyCode == 32)
		spaceCount += 1;
	else
	{
		spaceCount=0;
	}
	
	if(spaceCount > 1)
		return false;
			
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if((event.keyCode >= 97) && (event.keyCode <= 122))
	{	
		return (event.keyCode);
		spaceCount = 1;
	}
	return true ;
}

function CheckOnlynums(event,obj)
{
	if(event.keyCode == 32)
		spaceCount += 1;
	else
	{
		spaceCount=0;
	}
	
	if(spaceCount > 1)
		return false;
		
	var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if((event.keyCode >= 97) && (event.keyCode <= 122))
	{
		return (event.keyCode);
		spaceCount = 1;
	}
	return true ;
}
function SpaceCountIncr()
{
	spaceCount = 0
}
//created for IN035924 CHL-CRF-018 - START
function displayData(columNo)
{ 	
	if((document.getElementById("scope_to_choose"+columNo).value == "C") || (document.getElementById("scope_to_choose"+columNo).value == "P"))
	{	
		document.getElementById("label_data"+columNo).innerHTML= "";
		document.getElementById("label_data"+columNo).style.display="none";
		document.getElementById("unit_for_scope"+columNo).innerHTML= "";
		document.getElementById("scope_of_data"+columNo).style.display="inline";
		document.getElementById("unit_for_scope"+columNo).value = "";
	}
	else
	{
		document.getElementById("label_data"+columNo).innerHTML= "";
		document.getElementById("label_data"+columNo).style.display="none";
		document.getElementById("unit_for_scope"+columNo).innerHTML= "";
		document.getElementById("scope_of_data"+columNo).style.display="none";
		document.getElementById("scope_of_data"+columNo).value = "";
	}
	
	if(document.getElementById("scope_to_choose"+columNo).value == "C") {
		document.getElementById("unit_for_scope"+columNo).style.display="inline";
		document.getElementById("unit_for_scope"+columNo).innerHTML= "";
		document.getElementById("unit_for_scope"+columNo).innerHTML= getLabel("Common.days.label",'COMMON');
		document.getElementById("scope_of_data"+columNo).value = "";
	}
	else if(document.getElementById("scope_to_choose"+columNo).value == "P") { 
		document.getElementById("unit_for_scope"+columNo).style.display="inline";
		document.getElementById("unit_for_scope"+columNo).innerHTML= "";
		document.getElementById("unit_for_scope"+columNo).innerHTML= getLabel("eCA.Encounters.label","ca_labels");
		document.getElementById("scope_of_data"+columNo).value = "";
	}
	else {
		document.getElementById("scope_of_data"+columNo).value = "";
		document.getElementById("unit_for_scope"+columNo).innerHTML= "";
		document.getElementById("unit_for_scope"+columNo).style.display="none";
	}	
}

function checkMaxNoOfEncounters(columNo)
{
	if(document.getElementById("scope_to_choose"+columNo).value == "P")
	{
		var maxOfEncs = document.getElementById("scope_of_data"+columNo).value;
		if(maxOfEncs > 99)
		{
			alert(getMessage("CA_MAX_ENCOUNTER_WARNING",'CA'));
			document.getElementById("scope_of_data"+columNo).select();
			document.getElementById("scope_of_data"+columNo).focus();
			return false;
		}	
	}
	
}
//created for IN035924 CHL-CRF-018 - END
//14773 Starts
function CheckOnlynumsnew(event,obj)
{
	if(event.keyCode == 32)
		spaceCount += 1;
	else
	{
		spaceCount=0;
	}
	
	if(spaceCount > 1)
		return false;
		
	var strCheck = '123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if((event.keyCode >= 97) && (event.keyCode <= 122))
	{
		return (event.keyCode);
		spaceCount = 1;
	}
	return true ;
}
//14773 Ends