/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
 12/05/2024  50627    Twinkle Shah    12/05/2024		Ramesh Goli        ML-MMOH-CRF-2106
---------------------------------------------------------------------------------------------------------------
*/
function reset() 
{
	if(f_query_add_mod.document.ConsulationTagReportForm)
	{
	f_query_add_mod.location.reload();
	}
}

function run()
{
	var frmObject	   = f_query_add_mod.document.ConsulationTagReportForm;
	var p_patient_id	   = frmObject.p_patient_id.value;
	var p_fm_Date	   = frmObject.p_fm_Date.value;
	var p_to_Date	   = frmObject.p_to_Date.value;
	var toProceed	   = false;
	
    if(p_fm_Date == '')
     {
			var msg = getMessage("CAN_NOT_BE_BLANK", "common");
			msg = msg.replace("$", "Period From");
			alert(msg);
			return;
     }

    if(p_to_Date == '')
     {
			var msg = getMessage("CAN_NOT_BE_BLANK", "common");
			msg = msg.replace("$", "Period To");
			alert(msg);
			return;
      }
		if(frmObject){
		f_query_add_mod.document.ConsulationTagReportForm.action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.ConsulationTagReportForm.submit();
		}
}
function resetValues()
{
   parent.messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function populateEncounter()
{
var frmObject = document.ConsulationTagReportForm
var p_patient_id	   = frmObject.p_patient_id.value;
var p_facility_id	   = frmObject.p_facility_id.value;
var encounterType	   = frmObject.p_patient_class.value;
var p_category_type	   = frmObject.p_pat_cate_type.value;	
var xmlHttp		= new XMLHttpRequest() ;
xmlStr	="<root><SEARCH " ;
xmlStr += " p_action=\"POPUP_ENCOUNTER\"";
xmlStr += " p_patient_id=\"" +p_patient_id + "\"";
xmlStr += " encounterType=\"" +encounterType + "\"";
xmlStr += " p_category_type=\"" +p_category_type + "\"";
xmlStr += " p_facility_id=\"" + p_facility_id + "\"";
xmlStr +=" /></root>" ;
//xmlDoc.loadXML( xmlStr ) ;
var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
xmlHttp.open( "POST","../../eCA/jsp/CAConsultationTagReportIntermediate.jsp", false ) ;
xmlHttp.send(xmlDoc);
responseText    = xmlHttp.responseText;
responseText	= trimString(responseText);
eval(responseText);
}

function addEncounterList(code,desc)
{
var element = document.createElement('OPTION') ;
element.value =  code ;
element.text = desc ;	
eval("document.forms.ConsulationTagReportForm.p_encounter_id.add(element)");		
}

function clearEncounterList() 
{
eval("document.forms.ConsulationTagReportForm.p_encounter_id.length=0");
var tp = getLabel("eCA.All.label","ca");
var element = document.createElement('OPTION') ;
element.value = '' ;
element.text = tp;	
eval("document.forms.ConsulationTagReportForm.p_encounter_id.add(element)");		
} 

function callPatientSearch()
{
var pat_id =  PatientSearch();
if(pat_id != null)
document.forms[0].p_patient_id.value = pat_id;							
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function CheckForNumsAndColon(event) {
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode); // Get key value from key code
	if (strCheck.indexOf(key) == -1)
		return false; // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122))
		return (event.keyCode -= 32);
	return true;
}

function Check_Date(obj,format,locale)
{
	var toDate =document.forms[0].p_to_Date;
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{	
		if(!isBeforeNow(obj.value,format,locale))
		{
			var label=getLabel("Common.periodfrom.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
			msg = msg.replace('$$',label);
			alert(msg);
			obj.select();
			obj.focus();
			obj.value='';
			return false;
		}
	if(toDate.value !=''){
		if (!(isBefore(obj.value, toDate.value, "DMY", locale))){
			alert("Period From Should be Equal To or Less Than Period To");
			obj.select();
			obj.focus();
			obj.value='';
			return false;
		}
    }
}
}
}

function checkingDate(obj,format,locale)
{
	var from =document.forms[0].p_fm_Date;
	var todate =document.forms[0].p_to_Date;
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{
		if(!isBeforeNow(obj.value,format,locale))
		{
			var label=getLabel("Common.periodto.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
			msg = msg.replace('$$',label);
			alert(msg);
			obj.select();
			obj.focus();
			obj.value='';
			return false;
		}
		if(from.value !=''){
		if (!(isBefore(from.value, obj.value, "DMY", locale))){
			alert("Period To Should be Equal To or Greater Than Period From");
			obj.select();
			obj.focus();
			obj.value='';

			return false;
		}
		}
		return true;
	}
	}
}

