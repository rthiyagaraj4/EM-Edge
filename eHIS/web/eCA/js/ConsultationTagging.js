/*
 --------------------------------------------------------------------------------------------------------------
 Date		Edit History	Name		Rev.Date		Rev.Name			Description
 --------------------------------------------------------------------------------------------------------------
21/04/2024  50627    Twinkle Shah    21/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
 ---------------------------------------------------------------------------------------------------------------
 */
function callPatientSearch() {
	var pat_id = PatientSearch();
	if (pat_id != null)
		document.getElementById('patient_id').value = pat_id;
}

function submitPage() {
	var patient_id = ConsultationTagFrom.patient_id.value;
	var patient_id = ConsultationTagFrom.patient_id.value;
	var facility_id = ConsultationTagFrom.facility_id.value;
	var language_id = ConsultationTagFrom.language_id.value;
	var clinicianId = ConsultationTagFrom.clinicianId.value;
	var option_id = ConsultationTagFrom.option_id.value;
		if (patient_id == "") {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Patient ID");
		alert(msg);
		ConsultationTagFrom.patient_id.focus();
		return;
	} else {
		var xmlStr = "<root><SEARCH ";
		xmlStr += " p_action=\"CHK_PAT_VALID_YN\"";
		xmlStr += " patient_id=\"" + patient_id + "\" ";
		xmlStr += " /></root>";
		var temp_jsp = "../../eCA/jsp/ConsultationTagIntermediate.jsp";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		var checkValidPat = trimString(xmlHttp.responseText);
		if (checkValidPat == "0") {
			alert(getMessage('NOT_VALID_PATID','CA'));
			ConsultationTagFrom.patient_id.focus();
			ConsultationTagFrom.patient_id.value='';
		    parent.ConsultationTagResult.location.href = "../../eCommon/html/blank.html";
			parent.ConsultationTagQuery2.location.href = "../../eCommon/html/blank.html";
			parent.messageFrame.location.href = "../../eCommon/html/blank.html";
			return;
		}
		
		var xmlStr = "<root><SEARCH ";
		xmlStr += " p_action=\"CHK_PAT_APPLI_CONSUL_TAG\"";  
		xmlStr += " patient_id=\"" + patient_id + "\" ";
		xmlStr += " facility_id=\"" + facility_id + "\" ";
		xmlStr += " /></root>";
		var temp_jsp = "../../eCA/jsp/ConsultationTagIntermediate.jsp";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		var applPatConsulTag = trimString(xmlHttp.responseText);
		
		if (applPatConsulTag == "N") {
			alert(getMessage('APPL_PAT_CONSUL_TAG','CA'));
			ConsultationTagFrom.patient_id.focus();
			ConsultationTagFrom.patient_id.value='';
			document.getElementById('patient_id').disabled = false;    
			document.getElementById('patient_search').disabled = false; 
			parent.ConsultationTagResult.location.href = "../../eCommon/html/blank.html";
			parent.ConsultationTagQuery2.location.href = "../../eCommon/html/blank.html";
			parent.messageFrame.location.href = "../../eCommon/html/blank.html";
			return;
		}
		
		var xmlStr = "<root><SEARCH ";
		xmlStr += " p_action=\"CHK_PAT_ACTIVE_ENCOUNT_YN\"";  
		xmlStr += " patient_id=\"" + patient_id + "\" ";
		xmlStr += " facility_id=\"" + facility_id + "\" ";
		xmlStr += " language_id=\"" + language_id + "\" ";
		xmlStr += " /></root>";
		var temp_jsp = "../../eCA/jsp/ConsultationTagIntermediate.jsp";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		var isEncounterExist = trimString(xmlHttp.responseText);
		
		if (isEncounterExist > 0) {
			document.getElementById('patient_id').disabled = true;    
			document.getElementById('patient_search').disabled = true; 
		}
		var params = '?patientId=' +patient_id+'&facility_id='+facility_id+'&language_id='+language_id+'&checkValidPat='+checkValidPat+'&option_id='+ option_id ;
		parent.ConsultationTagResult.location.href = '../../eCA/jsp/ConsultationTaggingResult.jsp'+ params;
		parent.ConsultationTagQuery2.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame.location.href = "../../eCommon/html/blank.html";
	}
}

function chkRadiobutton(obj, visit_adm_date){
	var patient_id = obj.name;
	var encounter_id = obj.value;
	var option_id = document.ConsultationTagResult.option_id.value;
	var params = '?patient_id=' + patient_id + '&encounter_id=' + encounter_id+ '&visit_adm_date=' + visit_adm_date+ '&option_id=' + option_id;
	parent.ConsultationTagQuery2.location.href = '../../eCA/jsp/ConsultationTagging2.jsp'+params;
}

function apply() {
	var mode1 = document.consultationTagQuery2Frm.mode1.value;
	if(mode1=='modify'){
	var splCode = document.consultationTagQuery2Frm.splCode.value;
	var practitionerId = document.consultationTagQuery2Frm.tag_practitioner_id.value;
	}
	else
	{
	var splCode = document.consultationTagQuery2Frm.splCode.value;
	var practitionerId = document.consultationTagQuery2Frm.practitionerId.value;
	var practitioner_desc = document.consultationTagQuery2Frm.practitioner_desc.value;
	}
	var start_Date = document.consultationTagQuery2Frm.start_Date.value;
	var end_Date = document.consultationTagQuery2Frm.end_Date.value;

	if(mode1=='modify')
		{
		if(start_Date == "" && end_Date !== ""){
			var msg = getMessage("CAN_NOT_BE_BLANK", "common");
			msg = msg.replace("$", "Start Date/Time");
			alert(msg);
			document.getElementById("start_Date").focus();
			return;
		}
		if(end_Date == "" && start_Date !== ""){
			var msg = getMessage("CAN_NOT_BE_BLANK", "common");
			msg = msg.replace("$", "End Date/Time");
			alert(msg);
			document.getElementById("end_Date").focus();
			return;
		}
		 if((start_Date=="" || start_Date==undefined || start_Date==null) && (end_Date=="" || end_Date==undefined || end_Date==null))
		    {
				var msg = getMessage("CAN_NOT_BE_BLANK", "common");
				msg = msg.replace("$", "Mandatory fields");
				alert(msg);
				return;
			}
		}
	
    if((splCode=="" || splCode==undefined || splCode==null) && (practitionerId=="" || practitionerId==undefined || practitionerId==null) && (start_Date=="" || start_Date==undefined || start_Date==null) && (end_Date=="" || end_Date==undefined || end_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		document.getElementById("splCode").focus();
		document.getElementById("practitionerId").focus();
		document.getElementById("start_Date").focus();
		document.getElementById("end_Date").focus();
		return;
	}
    if((practitionerId=="" || practitionerId==undefined || practitionerId==null) && (start_Date=="" || start_Date==undefined || start_Date==null) && (end_Date=="" || end_Date==undefined || end_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    if((splCode=="" || splCode==undefined || splCode==null) && (practitionerId=="" || practitionerId==undefined || practitionerId==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    
    if((practitionerId=="" || practitionerId==undefined || practitionerId==null) && (start_Date=="" || start_Date==undefined || start_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    if((practitioner_desc=="" || practitioner_desc==undefined || practitioner_desc==null) && (start_Date=="" || start_Date==undefined || start_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    
    if((practitioner_desc=="" || practitioner_desc==undefined || practitioner_desc==null) && (end_Date=="" || end_Date==undefined || end_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    
    if((practitionerId=="" || practitionerId==undefined || practitionerId==null) && (end_Date=="" || end_Date==undefined || end_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    
    if((splCode=="" || splCode==undefined || splCode==null) && (end_Date=="" || end_Date==undefined || end_Date==null))
    {
    	
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    
    if((splCode=="" || splCode==undefined || splCode==null) && (start_Date=="" || start_Date==undefined || start_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    
    if((practitionerId=="" || practitionerId==undefined || practitionerId==null) && (end_Date=="" || end_Date==undefined || end_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
    
    if( (start_Date=="" || start_Date==undefined || start_Date==null) && (end_Date=="" || end_Date==undefined || end_Date==null))
    {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Mandatory fields");
		alert(msg);
		return;
	}
	if(splCode == ""){
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Specialty");
		alert(msg);
		document.getElementById("splCode").focus();
		return;
	}
	if(practitionerId == "" || practitioner_desc == ""){
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Tagged Practitioner");
		alert(msg);
		document.getElementById("practitionerId").focus();
		return;
	}
	if(start_Date == ""){
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Start Date/Time");
		alert(msg);
		document.getElementById("start_Date").focus();
		return;
	}
	if(end_Date == ""){
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "End Date/Time");
		alert(msg);
		document.getElementById("end_Date").focus();
		return;
	}

	document.forms[0].action="../../servlet/eCA.ConsultationTaggingServlet";
	document.consultationTagQuery2Frm.target="messageFrame";
	document.consultationTagQuery2Frm.method="post";
	document.consultationTagQuery2Frm.submit();
	
}

function CheckDateTimefrom(objText,locale,visit_date) {
	var startDate = document.getElementById("startDate");
	var enddate = document.getElementById("enddate");

	if (objText.value != '') {
		if(validDate(objText.value,"DMYHM",locale)==false)
		{	
			alert(getMessage("INVALID_DATE_TIME","CA"));
			objText.select();
			objText.focus();
			objText.value='';
			return false;
		}
		if (!(isBeforeNow(objText.value, "DMYHM", locale))) {
			alert(getMessage("STRT_DT_NOT_SYS_DT", "CA"));
			objText.select();
			objText.focus();
			objText.value='';
			return false;
		}
		if(isBefore(objText.value,visit_date,"DMYHM",locale) )
		{
			alert(getMessage("STRT_DT_NOT_LESS_VIS","CA"));
			objText.select();
			objText.focus();
			objText.value='';
			return false;
	    }
		
		if(enddate.value !=''){
		if (!(isBefore(startDate.value, enddate.value, "DMYHM", locale))){
			alert(getMessage("STRT_DT_NOT_GRT_END_DT", "CA"));
			objText.select();
			objText.focus();
			objText.value='';
			return false;
		}
		}
		else
			return true;
	}
	
}

function CheckDateTimeTo(objText,Obj2,locale,visit_date) {
	if (objText.value != '') {
		if(validDate(objText.value,"DMYHM",locale)==false)
		{	
			alert(getMessage("INVALID_DATE_TIME","CA"));
			objText.select();
			objText.focus();
			objText.value='';

			return false;
		}
		if (!(isBeforeNow(objText.value, "DMYHM", locale))) {  
			alert(getMessage("END_DT_NOT_GR_SYS_DT", "CA"));
			objText.select();
			objText.focus();
			objText.value='';

			return false;
		}
		if(isBefore(objText.value,visit_date,"DMYHM",locale) )
		{
			alert(getMessage("END_DT_NOT_LES_VIS","CA"));
			objText.select();
			objText.focus();
			objText.value='';

			return false;
	    }
		if(Obj2.value !=''){
		if (!(isBefore(Obj2.value, objText.value, "DMYHM", locale))) {
			alert(getMessage("END_DT_EQ_GR_STRT_DT", "CA"));
			objText.select();
			objText.focus();
			objText.value='';

			return false;
		}
		}
		else
			return true;
	}
}

function showCalendarValidate(str){
	var flg = showCalendar(str, null, 'hh:mm');
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

function resetValues(){
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
}

function getSpecialty1()
{
	var target			= document.forms[0].splName;
	var stdval          = document.forms[0].splCode.value;
	var pract			= document.forms[0].loginPract.value;
	var facilityid      = document.forms[0].facility_id.value;
	var locale			= document.forms[0].language_id.value;
	var title			= getLabel("Common.speciality.label","common");
	var repositoryKey="";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	
	repositoryKey="SQL_GET_PRACT_PRIMARY_SECONDARY_SPECIALITY";
	parNameArray[0] ="~LANGUAGE_ID`";
	parNameArray[1] ="~PRACTITIONER_ID`";
	parNameArray[2] ="~FACILITY_ID`";
	parNameArray[3] ="~PRACTITIONER_ID2`";
	parValueArray[0]=locale;
	parValueArray[1]=pract;
	parValueArray[2]=facilityid;
	parValueArray[3]=pract;

	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = repositoryKey;
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	
	retArray = CommonLookup( title, argArray );
	if (retArray != null && retArray != '' && retArray != "null")
	{
		document.forms[0].splCode.value = retArray[0];
		document.forms[0].splName.value = retArray[1];
	}
	else
	{
		document.forms[0].splCode.value = "";
		document.forms[0].splName.value = "";
	} 
}

function show_practtioner_window(target){
	
	var splCode = document.consultationTagQuery2Frm.splCode.value;
	if(splCode == "") {
	var msg = getMessage("CAN_NOT_BE_BLANK", "common");
	msg = msg.replace("$", "Specialty");
	alert(msg);
	document.getElementById("splCode").focus();
	return;
	}
	    var practName_FName	= "";
		var practName_FValue= "";
		var practId_FName	= "";
		practName_FName		= target.name;	
		practName_FValue	= target.value;
		var speciality      = document.forms[0].splCode.value;
		practId_FName		= document.consultationTagQuery2Frm.practitionerId.value;
		var sql				= consultationTagQuery2Frm.prac_sql.value;
		var sql2			= consultationTagQuery2Frm.prac_sql1.value;
		var patient_id		= document.consultationTagQuery2Frm.patient_id.value;
		var encounter_id	= document.consultationTagQuery2Frm.encounter_id.value;
		var facility_id		= consultationTagQuery2Frm.facility_id.value;
		var splty			= "";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" +practName_FName + "\"";
		xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " facility_id=\"" + facility_id + "\"";
		xmlStr += " specialty_code=\"" + splty+ "\"";
		xmlStr += " specialty_code1=\"" + speciality+ "\""; 
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText	= xmlHttp.responseText;
		responseText	= trimString(responseText);
		eval(responseText);
	}

function PractLookupRetVal(retVal,target,facility_id,patient_id,encounter_id)
{
    	if(retVal != null && retVal != "")
		{
			arr=retVal.split("~");
			var xmlStr = "<root><SEARCH ";
			xmlStr += " p_action=\"CHK_PRACT_ALRDY_TAG_YN\"";  
			xmlStr += " tagPractitonerId=\"" + arr[0] + "\" ";
			xmlStr += " facility_id=\"" + facility_id + "\" ";
			xmlStr += " patient_id=\"" + patient_id + "\" ";
			xmlStr += " encounter_id=\"" + encounter_id + "\" ";
			xmlStr += " /></root>";
			var temp_jsp = "../../eCA/jsp/ConsultationTagIntermediate.jsp";
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", temp_jsp, false);
			xmlHttp.send(xmlDoc);
			var responseText = xmlHttp.responseText;
			var tagPractitonerYN = trimString(xmlHttp.responseText);
			if (tagPractitonerYN == "N") {
			    document.consultationTagQuery2Frm.practitioner_desc.value = arr[1]
				alert(getMessage('PRACT_ALRD_TAG_PAT','CA'));
				document.consultationTagQuery2Frm.practitioner_desc.select();
			    document.consultationTagQuery2Frm.practitioner_desc.focus();
			    document.consultationTagQuery2Frm.practitioner_desc.value='';
				return false;
			}	
			document.consultationTagQuery2Frm.practitionerId.value=arr[0];
			document.consultationTagQuery2Frm.practitioner_desc.value = arr[1]
 		}
		else
		{
			document.consultationTagQuery2Frm.practitionerId.value="";
			document.consultationTagQuery2Frm.practitioner_desc.value ="";
		}
 }
function modifyTaggedRecord(patient_id,speciality_code,encounter_id,tag_practitioner_id,start_date,end_date,visit_adm_date)
{
var option_id = document.ConsultationTagResultfrm.option_id.value;
parent.ConsultationTagQuery2Frame.location.href="ConsultationTaggingQuery2.jsp?mode1=modify&patient_id="+patient_id+"&speciality_code="+speciality_code+"&tag_practitioner_id="+tag_practitioner_id+"&start_date="+start_date+"&end_date="+end_date+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&option_id="+option_id; 
}

function deleteRecord()
{		
	    var mode1 = document.consultationTagQuery2Frm.mode1.value;
	
		var mode1="delete";
		document.consultationTagQuery2Frm.mode1.value = mode1;
		var confirmDelete = window.confirm(getMessage("DELETE_RECORD","Common"));	
		if(confirmDelete==true)
		{
		document.forms[0].action="../../servlet/eCA.ConsultationTaggingServlet";
	    document.consultationTagQuery2Frm.target="messageFrame";
	    document.consultationTagQuery2Frm.method="post";
	    document.consultationTagQuery2Frm.submit();
	
		}
		else if(confirmDelete==false)
		{
			parent.ConsultationTagQuery2Frame.location.reload();
		}
}
	
function showConsultationTagHist(){
	var patient_id = document.ConsultationTagAuditTrialBtn.patient_id.value;
	var encounter_id = document.ConsultationTagAuditTrialBtn.encounter_id.value;
	var facility_id = document.ConsultationTagAuditTrialBtn.facility_id.value;	
	var dialogHeight= "17";
	var dialogWidth = "55";
	var dialogTop	= "45";
	var status = "no";
	var arguments	= "" ;			
	var patient = document.forms[0].patient_id.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var jsp_name;
	 window.showModalDialog("../../eCA/jsp/ConsultationTaggingRecordedHist.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id,arguments,features);
}

function clearAll()
{
	    mode =  parent.ConsultationTagQuery2Frame.document.consultationTagQuery2Frm.mode1.value;	
		if(mode =="modify")
		  {
		  var qstr="";
		  parent.ConsultationTagQuery2Frame.location.href="ConsultationTaggingQuery2.jsp?"+qstr;
		  }else
		  { 
		   parent.ConsultationTagResultFrame.location.reload();
		   parent.ConsultationTagQuery2Frame.location.reload(); 
		  }
}

function reset1(){
	parent.location.reload();
}

function onSuccess()
{
parent.frames[3].ConsultationTagQuery2.location.reload(); 
}

function getSpecialtyCall(obj)
{
   if (obj.value != "")
	{
		getSpecialty1();
	}
	else
	{
		document.forms[0].splCode.value = "";
	}
}

function setTagPractitioner(){	
	var practitionerId = document.consultationTagQuery2Frm.practitionerId.value="";
	var practitioner_desc = document.consultationTagQuery2Frm.practitioner_desc.value="";
}
