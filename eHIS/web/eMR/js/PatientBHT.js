// CRF Reference No     :  ML-MMOH-CRF-1959
// Detected Release  No      :  SEPTEMBER 2023 Release 
// File prepared by          :  SANTHOSH KUMAR N
// File prepared date        :  1-07-2023
// Purpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.
// Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    
function getSysDate(){
	var currentTime = new Date();
	var month = currentTime.getMonth() + 1
	var day = currentTime.getDate()
	var year = currentTime.getFullYear()
	if(month < 10)
		month="0"+month;
	if(day < 10)
		day="0"+day;

	var currentDate = day+"/"+month+"/"+year;
	return currentDate;
}

function reset() {
	top.content.frames[2].location.href = '../../eCommon/html/blank.html';
	//BHT_query.BHTQuery.document.forms[0].reset();
	BHT_query.document.forms[0].reset();
	var currentDate = getSysDate();
	BHT_query.document.getElementById("periodFrom").value=currentDate;
	BHT_query.document.getElementById("periodTo").value=currentDate;
}

function clearResult() {
	parent.BHT_result.location.href = '../../eCommon/html/blank.html';
}

function clearPage() {
	if (document.forms[0].call_function.value == "RECORD_DIAGNOSIS") {
		parent.frames[2].document.location.href = '../../eCommon/html/blank.html';
		if (parent.messageFrame)
			parent.messageFrame.document.location.href = '../../eCommon/jsp/error.jsp';
	}
}

async function callSearchScreen() {
	var patientid = await PatientSearch('', '', '', '', '', '', 'Y', '', '', 'VIEW');

	if (patientid != null)
		document.forms[0].PatientId.value = patientid;
	document.forms[0].PatientId.focus();
}

function clearLocation(obj) {
	if (obj.value == null || obj.value == "") {
		parent.BHT_query.document.forms[0].b_loc_val.value = "";
		parent.BHT_query.document.forms[0].blocation.value = "";
	} else {
		parent.BHT_query.document.forms[0].b_loc_val.value = "";
		parent.BHT_query.document.forms[0].blocation.value = "";
	}
}

function ena_loc_lookup(obj) {
	if (obj.value == null || obj.value == '') {
		parent.BHT_query.document.forms[0].b_loc_val.value = "";
		parent.BHT_query.document.forms[0].blocation.value = "";
	} else {
		getValues();
	}
}

async function getValues() {
	var locale = parent.BHT_query.document.getElementById("locale").value;
	var target =parent.BHT_query.document.getElementById("b_loc_val").value;
	var tit = "";
	var facilityid = parent.BHT_query.document.getElementById("facility_id").value;
	var module_id = parent.BHT_query.document.getElementById("module_id").value;
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var argumentArray = new Array(8);
	var sql = "";
	var sqlSecond = "";
	var locType = parent.BHT_query.document.getElementById("locationType").value;
	var loginUser = parent.BHT_query.document.getElementById("loginUser").value;
//	var oper_stn_id = parent.BHT_query.document.getElementById("oper_stn_id").value;
	var encType = parent.BHT_query.document.getElementById("lstPatientClass").value;
	var retVal="";
	
	if(locType == "N"){
		retVal = getNursingUnitValue("", facilityid);
	} else {
		tit = getLabel("Common.Location.label", "Common");
		var enc_type_criteria="";
		if(encType == "EM"){//Emergency type
			enc_type_criteria="LEVEL_OF_CARE_IND='E'";
		}else {
			enc_type_criteria="LEVEL_OF_CARE_IND='A'"
		}
		if(locType == "D"){
			argumentArray[0] = "select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"
					+ locale + "' and a.facility_id='" + facilityid
					+ "' and a.patient_class='DC' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.appl_user_id='"
					+ loginUser + "'  and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?) ORDER BY  2";
		} else {
			argumentArray[0] = "select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"
				+ facilityid + "'  and  language_id='" + locale
				+ "' and eff_status ='E' AND upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and "+enc_type_criteria+" AND CLINIC_TYPE='" + locType + "'";
		}
		
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "1,2";
		argumentArray[5] = target;
		argumentArray[6] = CODE_DESC_LINK;
		argumentArray[7] = CODE_DESC;
		
		retVal = await CommonLookup(tit, argumentArray);
	}
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
	if(retVal != null && retVal != "" )
	{
		parent.BHT_query.document.forms[0].blocation.value=arr[0];
		parent.BHT_query.document.forms[0].b_loc_val.value=arr[1];
	}
	else
	{
		parent.BHT_query.document.forms[0].b_loc_val.value	= "";
		parent.BHT_query.document.forms[0].blocation.value	= "";
	}

}

function BeforeGetNursingUnit(obj1,obj2) {
	if(document.forms[0].nursing_unit_desc.value != "")
		getNursingUnitValue(obj1,obj2);
	else
		document.forms[0].nursing_unit.value = "";
}

async function getNursingUnitValue(aNursingUnit, getFacilitID) {
	var locale = document.forms[0].locale.value;
	var msg					= "";
	var facility_id			= getFacilitID;
	var loginUser = parent.BHT_query.document.getElementById("loginUser").value;
	var operstn = parent.BHT_query.document.getElementById("oper_stn_id").value;
	var target				= parent.BHT_query.document.getElementById("b_loc_val").value;
	var retVal				= new String();
	var sql					= "";
	var tit					= "";
	var retVal				= new String();
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	var encType = parent.BHT_query.document.getElementById("lstPatientClass").value;
	
		sql = " Select nursing_unit_code code,short_desc description from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and facility_id like ? and eff_status='E' and locn_type = 'N' and upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?) and PATIENT_CLASS='"+encType+"'";
		
		

		dataNameArray[0]	= "facility_id" ;
		dataValueArray[0]	= facility_id;
		dataTypeArray[0]	= STRING ;

		argumentArray[4] = "2, 3";
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[5] = "";
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	search_code="nursing_unit_code";
	search_desc="short_desc";
	tit=getLabel("Common.nursingUnit.label","Common");
	
	retVal = await CommonLookup( tit, argumentArray );
	return retVal;

}

function validateFromDate(obj) {
	var localeName = document.forms[0].locale.value;
	var sys = getCurrentDate('DMY', 'en');
	var from = obj.value;	
	
	if (from.value != "") {
		if (!validDateObj(obj, 'DMY', localeName)) {
			from.value = "";
			return;
		}
		var obj1 = convertDate(from, "DMY", localeName, "en");
		if (isBefore(obj1, sys, 'DMY', 'en') == false) {
			alert(getMessage("FROM_DT_NGE_CURR_DATE", "SM"));
			from.value = "";
			from.select();
			return false;
		}
	}
	
		
	var todt=parent.BHT_query.document.getElementById("periodTo").value;
	if(obj.value!=''){
		if(!isBeforeNow(obj.value,"DMY",localeName)) {
			alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
			obj.select();
			obj.focus();
			return false ;
		}
	}
		var dateAftWeek=plusDate(from, 'DMY', 'en', 2, 'w');
		if (todt!='') {
		if (isBetween(from, dateAftWeek, todt, 'DMY', 'en') == false) {
				var census_date_from=getLabel("Common.DateRange.label","Common");
				var invaldt = getMessage("FOURTEEN_DAYS_VALIDATION", "MR") ;
				invaldt=invaldt.replace('$',census_date_from);
				alert(invaldt);
				obj.value='';
				obj.focus();
			}
		}
	}

function validateToDate(obj) {
	var to = obj.value;	  
	var fromdt=parent.BHT_query.document.getElementById("periodFrom").value;
	var localeName = document.forms[0].locale.value;
	
	if (to != "") {
		if (!validDateObj(obj, "DMY", localeName)) {
			to = "";
			return;
		}
		var sys = getCurrentDate('DMY', 'en');
		var obj1 = convertDate(to, "DMY", localeName, "en");
		if (isBefore(obj1, sys, 'DMY', 'en') == false) {
			alert(getMessage("TO_DATE_NOT_GREATER_SYSDATE", "SM"));
			to = "";
			obj.select();
			return false;
		}

		if (fromdt != "" && to != "") {
			if (isBefore(fromdt, to, 'DMY', localeName) == false) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT", "SM"));
				to = "";
				obj.select();
				return false;
			}
		}
	}
	
	var dateAftWeek=plusDate(fromdt, 'DMY', 'en', 2, 'w');	
	if(obj.value!=''){
		if(!isBeforeNow(obj.value,"DMY",localeName)) {
			alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
			obj.select();
			obj.focus();
			return false ;
		}
	}
		if (fromdt!='') {
		if (isBetween(fromdt, dateAftWeek, to, 'DMY', 'en') == false) {
				var census_date_from=getLabel("Common.DateRange.label","Common");
				var invaldt = getMessage("FOURTEEN_DAYS_VALIDATION", "MR");
				invaldt=invaldt.replace('$',census_date_from);
				alert(invaldt);
				obj.value='';
				obj.focus();
			}
		}
	}

	
function validate_date_to(to, from) {
	var localeName = document.forms[0].locale.value;
	if (to.value != "") {
		if (!validDateObj(to, "DMY", localeName)) {
			to.value = "";
			return;
		}
		var sys = getCurrentDate('DMY', 'en');
		var obj1 = convertDate(to.value, "DMY", localeName, "en");
		if (isBefore(obj1, sys, 'DMY', 'en') == false) {
			alert(getMessage("TO_DATE_NOT_GREATER_SYSDATE", "SM"));
			to.value = "";
			to.select();
			return false;
		}

		if (from.value != "" && to.value != "") {
			if (isBefore(from.value, to.value, 'DMY', localeName) == false) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT", "SM"));
				to.value = "";
				to.select();
				return false;
			}
		}
	}
}

function getResult(){
	var lstPatientClass = parent.BHT_query.document.getElementById("lstPatientClass").value;
	var encounter_id = parent.BHT_query.document.getElementById("p_encounter_id").value;
	var locationType = parent.BHT_query.document.getElementById("locationType").value;
	var loc_val = parent.BHT_query.document.getElementById("blocation").value;
	var periodFrom = parent.BHT_query.document.getElementById("periodFrom").value;
	var periodTo = parent.BHT_query.document.getElementById("periodTo").value;
	var patientId = parent.BHT_query.document.getElementById("PatientId").value;
	var BHTStatus = parent.BHT_query.document.getElementById("BHTStatus").value;
	var pageName = parent.BHT_query.document.getElementById("pageName").value;
	var maxDaysBHTSubmission = parent.BHT_query.document.getElementById("maxDaysBHTSubmission").value;
	var currentDate = getSysDate();
	
	if(lstPatientClass == null ||lstPatientClass==""){
		alert(getMessage("ENCOUNTER_TYPE_NOT_BLANK","MR"));
		return false;
	}
	if( periodFrom.length<1 || periodTo.length<1){
		alert(getMessage("DISCHARGE_DATE_NOT_BLANK","MR"));
		return false;
	}
	if(isBefore(periodFrom,periodTo,"DMY",'en')) {
		parent.BHT_result.location.href="../../eMR/jsp/PatBHTResult.jsp?lstPatientClass="+lstPatientClass+"&encounter_id="+encounter_id+"&locationType="+locationType+"&loc_val="+loc_val+"&periodFrom="+periodFrom+"&periodTo="+periodTo+"&patientId="+patientId+"&BHTStatus="+BHTStatus+"&pageName="+pageName+"&maxDaysBHTSubmission="+maxDaysBHTSubmission+"&currentDate="+currentDate;
	} else { 
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));			
		document.forms[0].startdate1.focus();
		document.forms[0].search.disabled=false;
		parent.messageFrame.document.location.href='../../eCommon/html/blank.html' ;  
	}
}

function getViewResult(){
	var lstPatientClass = parent.BHT_query.document.getElementById("lstPatientClass").value;
	var encounter_id = parent.BHT_query.document.getElementById("p_encounter_id").value;
	var locationType = parent.BHT_query.document.getElementById("locationType").value;
	var loc_val = parent.BHT_query.document.getElementById("blocation").value;
	var periodFrom = parent.BHT_query.document.getElementById("periodFrom").value;
	var periodTo = parent.BHT_query.document.getElementById("periodTo").value;
	var patientId = parent.BHT_query.document.getElementById("PatientId").value;
	var BHTStatus = parent.BHT_query.document.getElementById("BHTStatus").value;
	var maxDaysBHTSubmission = parent.BHT_query.document.getElementById("maxDaysBHTSubmission").value;
	var currentDate = getSysDate();
	
	if(lstPatientClass == null ||lstPatientClass==""){
		alert(getMessage("ENCOUNTER_TYPE_NOT_BLANK","MR"));
		return false;
	}
	if( periodFrom.length<1 || periodTo.length<1){
		alert(getMessage("DISCHARGE_DATE_NOT_BLANK","MR"));
		return false;
	}
	if(isBefore(periodFrom,periodTo,"DMY",'en')) {
		parent.BHT_result.location.href="../../eMR/jsp/PatBHTViewResult.jsp?lstPatientClass="+lstPatientClass+"&encounter_id="+encounter_id+"&locationType="+locationType+"&loc_val="+loc_val+"&periodFrom="+periodFrom+"&periodTo="+periodTo+"&patientId="+patientId+"&BHTStatus="+BHTStatus+"&maxDaysBHTSubmission="+maxDaysBHTSubmission+"&currentDate="+currentDate;
	} else { 
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));			
		document.forms[0].startdate1.focus();
		document.forms[0].search.disabled=false;
		parent.messageFrame.document.location.href='../../eCommon/html/blank.html' ;  
	}
}

async function showEncounter(enc, patid, Patient_Class, res_facility_id) {

	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name = "CurrentEncounterMain.jsp";
	var win_height = "40vh";
	var win_width = "65vw";
	var retVal = new String();
	var dialogHeight = win_height;
	var dialogWidth = win_width;
	var dialogTop = "61";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:"
			+ dialogWidth + "; center: " + center + "; status: " + status
			+ "; dialogTop :" + dialogTop;
	var arguments = "";

	retVal = await window.showModalDialog("../../eMR/jsp/" + jsp_name
			+ "?encounterId=" + enc + "&call_function=" + call_function
			+ "&patientId=" + patid + "&Patient_Class=" + Patient_Class
			+ "&facilityId=" + res_facility_id, arguments, features);

}

async function viewDiagnosis(encID, PatID, res_facility_id) {
	var retVal = new String();
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var FacilityId = res_facility_id;// added forBru-HIMS-CRF-380
	var dialogHeight = "30vh";
	var dialogWidth = "64vw";
	var dialogTop = "232";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:"
			+ dialogWidth + "; center: " + center + "; status: " + status
			+ "; dialogTop :" + dialogTop;
	var arguments = "";
	retVal = await window.showModalDialog(
			"../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id=" + encID
					+ "&FacilityId=" + FacilityId + "&PatientId=" + PatID
					+ "&call_function=" + call_function, arguments, features);
}

async function viewRemarks(encID) {
	var retVal = new String();
	var dialogHeight = "12vh";
	var dialogWidth = "45vw";
	var dialogTop = "400";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:"
			+ dialogWidth + "; center: " + center + "; status: " + status
			+ "; dialogTop :" + dialogTop;
	var arguments = "";
	var remarks = parent.BHT_result.document.getElementById("remarks_"+encID).value;
	retVal = await window.showModalDialog("../../eMR/jsp/PatBHTRemarks.jsp?&remarks="+remarks, arguments, features);
	if(retVal != undefined){
		parent.BHT_result.document.getElementById("remarks_"+encID).value = retVal;
	}
}
function CheckMaxLimit(obj,lab,max) {
	var errors = '';
	if (obj.value.length > max) {
		errors = errors + getMessage("REMARKS_CANNOT_EXCEED", "Common");
		errors = errors.replace('$', lab);
		errors = errors.replace('#', max);
		errors = errors + "\n";
		alert(errors);
		return false;
		obj.focus();
	} else
		return true;
}

function updateRemarks(obj) {
	if(CheckMaxLimit(obj,"Remarks",100)){
		formObject = document.BHTRemarks;
		window.returnValue = formObject.remarks.value;
		window.close();
	}
	
}

function submitBHT(btnType) {
	parent.BHT_result.document.getElementById("buttonType").value = btnType;
	var EncounterID_param = parent.BHT_result.document.getElementById("EncounterID_param").value;
	if(EncounterID_param!=null && EncounterID_param!=""){
		document.forms[0].submit();		
	}
}

function callDemographics(patient_id) {
	var dialogHeight= "39vh" ;
	var dialogWidth	= "100vw" ;
	var dialogTop	= "76";
	var status = "no";
	var arguments	= "" ;
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=yes;  status:" + status;
	window.showModalDialog("../../eCA/jsp/DemographicsView.jsp?patient_id="+patient_id,arguments,features);
	return false;	
}

function getLocation(obj) {
	var locationType = parent.BHT_query.document.getElementById("locationType");
	while(locationType.options.length > 1)
		locationType.remove(1);
	
	parent.BHT_query.document.forms[0].b_loc_val.value = "";
	parent.BHT_query.document.forms[0].blocation.value = "";
	
	var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eMR/jsp/EncTypeLocationList.jsp'><input type='hidden' name='encounterType' id='encounterType' value='" +obj.value + "'></form></BODY></HTML>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();
			
}


