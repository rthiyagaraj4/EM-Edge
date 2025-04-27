function reset(){
	frames[0].location.reload();
	frames[1].location.reload();
	frames[2].location.href = "../../eCommon/jsp/error.jsp";
}

function onSuccess()
{	
	frames[0].location.reload();
	frames[1].location.reload();	
}

async function PatientIdLookup()
{	
	var pat_id=await PatientSearch();		
	if( pat_id != null )						
	document.getElementById('patient_id').value = pat_id ;
	if(pat_id!=undefined && pat_id!='')
	{
		LoadPatientName(pat_id);
		ChangeUpperCase(document.getElementById('patient_name'));
	}
}

function primaryPatValidation(obj)
{
	var patient_id=obj.value;	
	if(patient_id!=""){
		var function_id = "PAT_CHK";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="+function_id;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.select();
		}else if(responseText=="Y"){
			LoadPatientName(patient_id);
		}
	}
}

function LoadPatientName(pat_id)
{
	var out;
	var response;
	var xmlhttp;    
	if (window.XMLHttpRequest) 
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		 xmlHttp = new XMLHttpRequest();
	}
		xmlhttp.onreadystatechange=function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		out = xmlhttp.responseText;
		var showdata = out.substring(out.indexOf("!")+1,out.length);
		response=showdata.split(":");
		var actual;
		//alert(response);
	for(var i=0;i<response.length;i++)
	{
		document.getElementById("patient_name").value = response[i];
	}
		ChangeUpperCase(document.getElementById('patient_name'));
	}
	}
		xmlhttp.open("POST","../../eBL/jsp/BillingRecordApprovalGetPatienName.jsp?patientId="+pat_id,true);
		xmlhttp.send(null);
}

async function encounterIDLkup(){
	
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var facility_id = document.forms[0].facility_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var target = document.forms[0].encounter_id;
	var qryParam = '&patient_id='+patient_id+'&episode_type='+episode_type+'&facility_id='+facility_id+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("Common.encounterid.label", 'common');

	var column_sizes = escape("100%");
		
	var column_descriptions = getLabel("Common.encounterid.label", 'common');
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=Y"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=ENC_ID_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
	}
    else
	{
		 target.value = '';
	}
	
}

function checkForValue(obj){
	var episode_type = obj.value;
	
	if(episode_type == "A"){
		document.forms[0].spec_nur_unit_desc.value = "";
		document.forms[0].spec_nursing_unit_code.value = "";
		document.forms[0].spec_nur_unit_desc.disabled = true;
		document.forms[0].spec_nursing_unit_btn.disabled = true;
	}else{
		document.forms[0].spec_nur_unit_desc.value = "";
		document.forms[0].spec_nursing_unit_code.value = "";
		document.forms[0].spec_nur_unit_desc.disabled = false;
		document.forms[0].spec_nursing_unit_btn.disabled = false;
	}
}

async function SpecNursingUnitLkup(){
	
	var frm = document.forms[0];
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var episode_type = document.forms[0].episode_type.value;
	var target = document.forms[0].spec_nur_unit_desc;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = "";
	if(episode_type == 'O' || episode_type == 'E')
		title = getLabel("Common.speciality.label", 'common');
	if(episode_type == 'I' || episode_type == 'D')
		title = getLabel("Common.nursingUnit.label", 'common');
	if(episode_type == 'A')
		title = getLabel("Common.speciality.label", 'common') + "/" + getLabel("Common.nursingUnit.label", 'common');
	
	title = encodeURIComponent(title);
	
	var column_sizes = escape("70%,30%"); 
	
	var code_lbl = getLabel("Common.code.label","common");

	var desc_lbl=getLabel("Common.description.label","common");
	desc_lbl=encodeURIComponent(desc_lbl);
	
	var column_descriptions = desc_lbl+","+code_lbl;
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=NURSING_UNIT_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
		document.forms[0].spec_nursing_unit_code.value = arr[1];
	}
    else
	{
		 target.value = "";
		 document.forms[0].spec_nursing_unit_code.value = "";
	}	
}

async function payerGrpLkup(){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var target = document.forms[0].payer_group;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("eBL.PAYER_GROUP.label","BL");
	
	title = encodeURIComponent(title);
	
	var column_sizes = escape("70%,30%"); 
	
	var code_lbl = getLabel("Common.code.label","common");

	var desc_lbl=getLabel("Common.description.label","common");
	desc_lbl=encodeURIComponent(desc_lbl);
	
	var column_descriptions = desc_lbl+","+code_lbl;
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=PAYER_GROUP_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
		document.forms[0].payer_grp_code.value = arr[1];
	}
    else
	{
		 target.value = "";
		 document.forms[0].payer_grp_code.value = "";
	}
}

async function payerLkup(){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var payer_grp_code = document.forms[0].payer_grp_code.value;
	var target = document.forms[0].payer;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&payer_grp_code='+payer_grp_code+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("eBL.PAYER.label","BL");
	
	title = encodeURIComponent(title);
	
	var column_sizes = escape("70%,30%"); 
	
	var code_lbl = getLabel("Common.code.label","common");

	var desc_lbl=getLabel("Common.description.label","common");
	desc_lbl=encodeURIComponent(desc_lbl);
	
	var column_descriptions = desc_lbl+","+code_lbl;
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=PAYER_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
		document.forms[0].payer_code.value = arr[1];
	}
    else
	{
		 target.value = "";
		 document.forms[0].payer_code.value = "";
	}
}

async function policyLookup(){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var payer_grp_code = document.forms[0].payer_grp_code.value;
	var payer_code = document.forms[0].payer_code.value;
	var target = document.forms[0].policy;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&payer_grp_code='+payer_grp_code+'&payer_code='+payer_code+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("eBL.POLICY_TYPE.label","BL");
	
	title = encodeURIComponent(title);
	
	var column_sizes = escape("70%,30%"); 
	
	var code_lbl = getLabel("Common.code.label","common");

	var desc_lbl=getLabel("Common.description.label","common");
	desc_lbl=encodeURIComponent(desc_lbl);
	
	var column_descriptions = desc_lbl+","+code_lbl;
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=POLICY_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
		document.forms[0].policy_type_code.value = arr[1];
	}
    else
	{
		 target.value = "";
		 document.forms[0].policy_type_code.value = "";
	}
}

function clearCode(obj){
	obj.value='';
}

function enablePastRecDays(obj){
	if(obj.checked)
		document.forms[0].past_recs_days.disabled = false;
	else{
		document.forms[0].past_recs_days.value = '';
		document.forms[0].past_recs_days.disabled = true;
	}
}

function checkAlpha(event) {
    var strCheck = '1234567890';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
    if (strCheck.indexOf(key) == -1)
        return false;
    return true;
}

function checkForNumber(obj) {
    if (trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		if(obj.value == 0){
			alert(getMessage("CANNOT_BE_ZERO", "common"));
			obj.value = "";
			obj.focus();
			return false;
		}
        return true;
    } else {
        if (obj.value.length > 0) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function compareDates(startDate, endDate) {
    var starr = startDate.value.split("/");
    var enarr = endDate.value.split("/");
	
	var startdt = new Date();
    var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
    enddt.setFullYear(enarr[2], enarr[1] - 1, enarr[0]);
	
	if(startDate.value == ""){
		alert(getMessage('BL8504', 'BL'));
        endDate.value = '';
		return false;
	}
	
	if (startDate.value.length > 0 && endDate.value.length > 0) {
        if(startdt > enddt) {
            alert(getMessage('BL1344', 'BL'));
            endDate.value = '';
			return false;
        }
    }
	return true;
}

/*
function compareCurrent_StartDates(startDate){
	
	var starr = startDate.value.split("/");
	var currdt = new Date();
    var startdt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
	if(currdt > startdt){
		alert(getMessage('PH_FROM_DATE_GREATER_EQUAL_CURRENT_DATE', 'PH')); 
        startDate.value = '';
		return false;
	}
}
*/

function encFromDateValidation(obj, startDt, endDt){
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);
		
		if(valid_status == true || valid_status == "true"){
			//valid_status = compareCurrent_StartDates(startDt);
			if(valid_status == true || valid_status == "true"){
				valid_status = compareDates(startDt, endDt);
			}
		}	
	}
}

function encToDateValidation(obj, startDt, endDt ){
	var locale = document.forms[0].locale.value;
	if(obj.value != "") {	
		var valid_status = validDateObj(obj,"DMY",locale);
		return true;
	}
	return false;
}

function showCalendarLocal(fromTo, obj) {
    if (fromTo == 1) {
        return showCalendar('effFrom_' + obj)
    } else if (fromTo == 2) {
        return showCalendar('effTo_' + obj)
    }
}

function searchForData(){
	
	parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	
	var patient_id = document.forms[0].patient_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var enc_from_date = document.forms[0].enc_from_date.value;
	var enc_to_date = document.forms[0].enc_to_date.value;
	var patient_name = document.forms[0].patient_name.value;
	patient_name = encodeURIComponent(patient_name);
	var title = getLabel("Common.encounterdetails.label",'common');
	if(patient_id == null || patient_id == ""){
		alert(getMessage("BL6103","BL"));
		document.forms[0].patient_id.focus();
		return false;
	}	
	
	parent.frames[1].location.href = "../../eBL/jsp/BLRecordPaymentConsentEncounterDtls.jsp?title="+title+"&patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&enc_from_date="+enc_from_date+"&enc_to_date="+enc_to_date+"&patient_name="+patient_name;
}

async function callESign(ind){
	var frmobj = parent.frames[1].document;
	var signOf = frmobj.getElementById('consent_'+ind).value;
	var relName = '';
	var relNationality = '';
	var relCivilId = '';
	var relTelNum = '';
	var esignVal = '';
	var patientId = frmobj.getElementById('patientId_'+ind).value;
	var episodeType = frmobj.getElementById('episodeType_'+ind).value;
	var episodeId = frmobj.getElementById('episodeId_'+ind).value;
	var consentAmt = frmobj.getElementById('consentAmt_'+ind).value;
	var consentDate = frmobj.getElementById('consentDate_'+ind).value;
//	var signedYN = frmobj.getElementById('signedYN_'+ind).value;
	var pmntUser = frmobj.getElementById('pmntUser_'+ind).value;
	var signedYN = "Y";
	if(consentAmt <= 0 ){
		alert(getMessage('BL0976', 'BLEXT'));
		document.getElementById("consent_flag_"+ind).checked = false;
		return false;
	}
	if(consentDate == null || consentDate == ""){
		alert(getMessage('BL0977', 'BLEXT'));
		document.getElementById("consent_flag_"+ind).checked = false;
		return false;
	}
	
	if(signOf == "R")
	{
		var retVal = new String();
		var dialogHeight= "20" ;
		var dialogWidth    = "40" ;
		var dialogTop = "250" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop :" + dialogTop +"; status=no";
		var arguments            = "" ;
		var message                = "" ;
		var title = getLabel("eBL.RelativeDetails.label","BL"); 
		var param = "title="+title;
		var retVal=await window.showModalDialog("../../eBL/jsp/BLRecordPaymentConsentRelativeDtls.jsp?"+param,arguments,features);
		
		document.getElementById("consent_flag_"+ind).checked = false;
		retVal=unescape(retVal);
		var arr=new Array();
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("~");
			relName = arr[0];
			relNationality = arr[1];
			relCivilId = arr[2];
			relTelNum = arr[3];
			esignVal = arr[4];
		}		
	}else{
		esignVal = captureESignature();
		if(esignVal==null || esignVal==undefined || esignVal=='' || esignVal=="null" || esignVal=="undefined"){
			document.getElementById("consent_flag_"+ind).checked = false;
			return false;
		}			
	}
	
	var frm = document.forms[0];
	frm.patient_Id.value = patientId;
	frm.episodeId.value = episodeId;
	frm.episodeType.value = episodeType;
	frm.consentAmt.value = consentAmt;
	frm.consentDate.value = consentDate;
	frm.relName.value = relName;
	frm.relNationality.value = relNationality;
	frm.relCivilId.value = relCivilId;
	frm.relTelNum.value = relTelNum;
	frm.pmntUser.value = signOf;
	frm.signed_YN.value = signedYN;
	frm.esign.value = esignVal;
	
	frm.target = 'messageFrame';
	frm.method = "post";
	frm.action = "../../servlet/eBL.BLRecordPaymentConsentMasterServlet";
	frm.submit();
		
}


async function search_country(obj1,obj2){
	
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
	var sql=''; 
	var title = '';
	
	title = getLabel("Common.nationality.label",'common'); 
	
	sql = "Select long_desc description, country_code code from Mp_Country_lang_vw where language_id='"+locale+"' and eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
	
	argumentArray[0] =sql;
    argumentArray[1] = dataNameArray ;
    argumentArray[2] = dataValueArray ;
    argumentArray[3] = dataTypeArray ;
	if(obj1.value != "" || obj1.value != null){
    	argumentArray[4] = "2,1";
	    argumentArray[5] = obj1.value;
	}else{
		argumentArray[4] = "1,2";
	    argumentArray[5] = obj2.value;
	}
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;
    retVal = await CommonLookup( title, argumentArray );
   
	if ((retVal != null) && (retVal != "")) {
        obj1.value = retVal[1];
        obj2.value = retVal[0];
    } else {
        obj1.value = '';
        obj2.value = '';
    }
}

function clearFields(obj){
	obj.value = '';
}



function saveRelativeDtls(){
	
	var frmObj = document.forms[0];
	var relName = frmObj.name.value;
	var relNationality = frmObj.nationality_code.value;
	var relCivilId = frmObj.civilId.value;
	var relTelNum = frmObj.telephoneNumber.value;
	
	if(relName == null || relName == "" || relNationality == null || relNationality == "" || relCivilId == null || relCivilId == "" || relTelNum == null || relTelNum == ""){
		alert(getMessage("ALL_MANDATORY_FIELDS", 'Common'));
		return false;
	}	
	
	var esignVal = captureESignature();
	var qryparam = relName+"~"+relNationality+"~"+relCivilId+"~"+relTelNum+"~"+esignVal;
	//window.returnValue = qryparam;
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = qryparam;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
}

async function saveConsentForm(ind){
	var retVal = new String();
    var dialogHeight= "10" ;
    var dialogWidth    = "15" ;
    var dialogTop = "250" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop :" + dialogTop +"; status=no";
    var arguments            = "" ;
    var message                = "" ;

    var title = getLabel("eBL.ConsentFormOption.label","BL");
    var param = "title="+title;

    var retVal=await window.showModalDialog("../../eBL/jsp/BLRecordPaymentConsentFormDtls.jsp?"+param,arguments,features);
	if(retVal==null || retVal==undefined || retVal==""){
		window.close();
		//return false;
	}else
		reprintConsentForm(ind,retVal);
	
}	


function fnclear(ind){
	document.getElementById("consent_flag_"+ind).checked = false;
}

async function captureESignature(){
	
	var center='1';
	var dialogTop = "200";
	var dialogHeight = "30" ;
	var dialogWidth = "50" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var arguments = "" ;

	retVal=await window.showModalDialog("../../eXH/jsp/CaptureSignature.jsp",arguments,features);
	
	return retVal;    
}


function callPrintViewSaveConsentForm(){
	
	var consentFormOpt = document.forms[0].consentFormOption.value;
	window.returnValue = consentFormOpt;
	window.close();
}


function reprintConsentForm(ind, reportOpt){
	
	var frmObj = document;
	var patientId = frmObj.getElementById('patientId_'+ind).value;
	var episodeId = frmObj.getElementById('episodeId_'+ind).value;
	var consentAmt = frmObj.getElementById('consentAmt_'+ind).value;
	var consentDate = frmObj.getElementById('consentDate_'+ind).value;
	var pmnt_user = frmObj.getElementById('consent_'+ind).value;
	
	var p_facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var reportId = "BLRRPTCT";
	var module_id = "BL";
	var detailed_yn = "Y";
	var report_option = "P";
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintConsentForm&p_report_id="+reportId+"&param1="+patientId+"&param2="+episodeId+
				"&param3="+consentAmt+"&param4="+consentDate+"&param5="+"&param6="+"&param7="+"&param8="+
				"&param9="+
				"&param10="+				
				"&param11="+
				"&param12="+
				"&param13="+
				"&param14=";
		
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);
	
	var arr=new Array();
	arr = retVal.split(":::");
	session_id = trimString(arr[0]);
	pgm_date = trimString(arr[1]);
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintConsentFormReportRouting&p_report_id="+reportId+"&reportOption="+report_option+"&module_id="+module_id;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);	

	var arr=new Array();
	arr = retVal.split(":::");
	report = trimString(arr[0]);
	server = trimString(arr[1]);
	copies = trimString(arr[2]);
	app_server_ip = trimString(arr[3]);
    rep_server_key = trimString(arr[4]);
    reportserver = trimString(arr[5]);
    login_user = trimString(arr[6]);
    message = trimString(arr[7]);
    
    if(message != ""){
    	alert(message);
    	return false;
    }
    userid = "userid"+"="+login_user;
    login_user = encodeURIComponent(userid); 
	
	var params		= "&P_PGM_ID="+reportId+"&P_PGM_DATE="+pgm_date+"&P_FACILITY_ID="+p_facility_id+"&P_SESSION_ID="+session_id+"&P_PATIENT_ID="+patientId+"&P_EPISODE_ID="+episodeId+"&P_CONSENT_AMT="+consentAmt+"&P_CONSENT_DATE="+consentDate+"&P_PMNT_USER="+pmnt_user;
	var regExp = /&/g ;
	params = params.replace( regExp, "+" ) ; 
			
	var myRegExp = /\\/g ;
	var desformat = "PDF";
	var destype	= '';
	var desname = '';
	var ext = ".pdf";
	if(reportOpt == 'V'){
		destype = "CACHE";
		desname = "dummy";
	}else if(reportOpt == 'P'){
		destype = "PRINTER";
	}else{
		destype = "FILE";
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintConsentFormReportDir";
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var retVal = trimString(xmlHttp.responseText);
		desname = retVal+patientId+"_"+episodeId+ext;	
		params+= "+background=yes";
	}
	params=params.toUpperCase();
	var report = reportId;
	url = reportserver+"?server="+server+"+report="+reportId+"+"+ login_user+"+p_language_id="+locale+"+DESTYPE="+destype+"+desname="+desname+"+PARAMFORM=NO"+"+P_FACILITY_ID="+p_facility_id+"+DESFORMAT="+desformat+"+RECURSIVE_LOAD=NO"+"+MAXIMIZE=YES"	;
	

	url=url+params;
	var myBars 		= 'directories=no,location=no,menubar=no' ;
	var myOptions 	= 'width=1500px !important, height=750px !important, resizable=yes' ; 
	var myFeatures 	= myBars + ', ' + myOptions ;
	var reportWindow 	= open( url, '_blank', myFeatures ) ;
		
}



function validateConsentDate(obj, consentDt, ind){
	
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);
		if(valid_status == true || valid_status == "true"){
			valid_status = compareCurrent_StartConsentDates(consentDt);
		}	
	}
}

function compareCurrent_StartConsentDates(startDate){
	
	var starr = startDate.value.split("/");
	var currdt = new Date();
    var startdt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
	if(currdt > startdt){
		alert(getMessage('BL0978', 'BLEXT')); 
        startDate.value = '';
		return false;
	}
}

function checkForNumberDecimal(obj,ind) {
	
	var consentAmt = document.getElementById("consentAmt_"+ind).name;
	var decArr = obj.value.split('.');
	if(isNaN(decArr[0]))
	{
		alert(getMessage('BL8532', 'BL'));
		obj.value = ''; 
		return false;
	}
    if (decArr.length > 2) {
        alert(getMessage("NUM_ALLOWED", "SM"));
        obj.value = '';
        return false;
    }

    if (decArr.length == 2) {
        if (decArr[0].length < 1 && decArr[1].length < 1) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
        if (decArr[1].length > 2) {
            alert('Only Two Numbers are allowed beyond Decimal');
            obj.value = '';
            return false;
        }
    }
}

function makeValidString(txtObj)
{
	
    var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }
    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
}

function isValidCharacter(elementRef) {

	var regExp ="0123456789";
    var checkValue = new String(elementRef.value);  
	
     for (var i=0; i<=checkValue.length; i++)
     {    
        if (regExp.indexOf(checkValue.charAt(i)) == -1) {   

                var msg = getMessage("RESTRICT_ALPHBET_SPLCHAR",'MP');
                elementRef.value = "";
                alert(msg);
                elementRef.focus();
				elementRef.value = "";
                return false;          
        }
    }  
}


function CheckForAlphaCharsNatID(elementRef){  

	var regExp ='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var checkValue = new String(elementRef.value);  
	   
    for (var i=0; i<=checkValue.length; i++)
    {    
       if (regExp.indexOf(checkValue.charAt(i)) == -1) {   

            var msg = getMessage("SPL_CHAR_NOT_ALLOWED",'MP');
			elementRef.value = "";
            alert(msg);
            elementRef.focus();
			elementRef.value = "";
            return false;          
        }
    }  
	
}


function resetRelativeDtls(){
	document.getElementById("name").value = "";
	document.getElementById("nationality_desc").value = "";
	document.getElementById("civilId").value = "";
	document.getElementById("telephoneNumber").value = "";
}
