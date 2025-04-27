function reset(){	
	frames[0].location.reload();
	frames[1].location.reload();
	frames[2].location.href = "../../eCommon/jsp/error.jsp";
}

async function patientIdLookup()
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
	var patient_id = document.getElementById('patient_id').value;
	var facility_id = document.forms[0].facility_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var target = document.forms[0].encounter_id;
	var qryParam = '&patient_id='+patient_id+'&episode_type='+episode_type+'&facility_id='+facility_id+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "15" ;
	var dialogWidth			= "50" ;
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
async function payerGrpLkup(called_from){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var target = document.forms[0].payer_group;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&target='+target.value;	
	
	if(target.value == "" && called_from == 'D'){
		 document.forms[0].payer_grp_code.value = "";
		 return false;
	}		
	
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

async function payerLkup(called_from){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var payer_grp_code = document.forms[0].payer_grp_code.value;
	var target = document.forms[0].payer;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&payer_grp_code='+payer_grp_code+'&target='+target.value;	
	
	if(target.value == "" && called_from == 'D'){
		 document.forms[0].payer_code.value = "";
		 return false;
	}	
	
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

async function policyLookup(called_from){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var payer_grp_code = document.forms[0].payer_grp_code.value;
	var payer_code = document.forms[0].payer_code.value;
	var target = document.forms[0].policy;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&payer_grp_code='+payer_grp_code+'&payer_code='+payer_code+'&target='+target.value;	
	
	if(target.value == "" && called_from == 'D'){
		 document.forms[0].policy_type_code.value = "";
		 return false;
	}	
		
	
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
            alert(getMessage('BL4115', 'BL'));
            endDate.value = '';
			return false;
        }
    }
	return true;
}

function compareCurrent_endDates(endDate){
	var starr = endDate.value.split("/");
	var currdt = new Date();
    var startdt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
	if(currdt < startdt){
		alert(getMessage('BL0966', 'BLEXT')); 
		endDate.value = '';
		return false;
	}
}

function encFromDateValidation(obj, startDt, endDt){
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);
		
		if(!isBeforeNow(obj.value,'DMY',locale)){
			alert(getMessage("FROM_DT_NGE_CURR_DATE","SM"));
			obj.value='';
			valid_status =  false;
		}else{
			valid_status = true;
		}
		
		if(valid_status == true || valid_status == "true"){
			valid_status = compareDates(startDt, endDt);
		}
	}
}

function encToDateValidation(obj, startDt, endDt ){
	var locale = document.forms[0].locale.value;
	if(obj.value != "") {	
		var valid_status = validDateObj(obj,"DMY",locale);
		if(valid_status == true){
			valid_status = compareDates(startDt, endDt)
		}	
		
		if(valid_status == true || valid_status == "true"){
			var dateDif = dateDiff(startDt.value, endDt.value);
			//alert(dateDif);
			var actualDays = 30;
			if(dateDif > actualDays){
				alert(getMessage("BL0939",'BLEXT'));
				endDt.value = '';
				return false;
			}
		}
	}
}

function showCalendarLocal(fromTo, obj) {
    if (fromTo == 1) {
        return showCalendar('effFrom_' + obj)
    } else if (fromTo == 2) {
        return showCalendar('effTo_' + obj)
    }
}
function dateDiff(fromDate, toDate){
	var starr = fromDate.split("/");
	var enarr = toDate.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	var timeDiff;
	var daysDiff;

	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
			
	return daysDiff;
}

async function claimIdLookup(){
	
	var frm = document.forms[0];
	var patient_id = document.getElementById('patient_id').value;
	var facility_id = document.forms[0].facility_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var target = document.forms[0].claim_id;
	var qryParam = '&patient_id='+patient_id+'&episode_type='+episode_type+'&facility_id='+facility_id+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "15" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("eBL.claim_id.label", 'eBL');

	var column_sizes = escape("100%");
		
	var column_descriptions = getLabel("eBL.claim_id.label", 'eBL');
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=Y"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=CLAIM_ID_LKUP&"+param,arguments,features);
	
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

async function approvalDocRefNoLookup(txt,obj,code)
{
	var frm = document.forms[0];
	var patient_id = document.getElementById('patient_id').value;
	var facility_id = document.forms[0].facility_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var target = parent.frames[0].search.document.getElementById('approval_doc_ref_text');
	
	var qryParam = '&patient_id='+patient_id+'&episode_type='+episode_type+'&facility_id='+facility_id+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "15" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("eBL.approval_doc_ref_no.label", 'eBL');

	var column_sizes = escape("50%,50%");
		
	var appr_doc_ref_no = getLabel("eBL.approval_doc_ref_no.label", 'eBL');
	var appr_doc_type_code =  getLabel("eBL.Approval_ref_doc_type_code.label", 'eBL');
	var column_descriptions = appr_doc_ref_no+','+appr_doc_type_code;
	
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=APPROVAL_DOC_REF_NO_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		txt.value = arr[1]+'/'+arr[0];
		obj.value = arr[0];
        	code.value = arr[1];
		
	}
    else
	{
		 target.value = '';
	}

}


function validateFormAndQuery(){
	var patient_id = parent.frames[0].search.document.getElementById('patient_id').value;
	var payerGroup	= parent.frames[0].search.document.getElementById('payer_group').value;
	var State_dur_from =  parent.frames[0].search.document.getElementById('State_dur_from').value;
	var State_dur_to =  parent.frames[0].search.document.getElementById('State_dur_to').value;
	var approval_doc_ref_text = parent.frames[0].search.document.getElementById('approval_doc_ref_text').value;
	var claim_id = parent.frames[0].search.document.getElementById('claim_id').value;
	var fun_id = parent.frames[0].search.document.getElementById('function_id').value;
	var flag = false;
	var appr_arr;
	if(patient_id != ""){
		flag = true;
	}else if(approval_doc_ref_text != ""){
		flag = true;
		appr_arr = approval_doc_ref_text.split('/');
		
		parent.frames[0].search.document.getElementById('approval_doc_ref_type_code').value = appr_arr[0];
		parent.frames[0].search.document.getElementById('approval_doc_ref_no').value = appr_arr[1];
		
	}else if(claim_id != ""){
		flag = true;
	}else {
		if(payerGroup == ""){
			alert(getMessage("BL6277","BL"));
			return false;
		}
	
		if(State_dur_from == ""){
			alert(getMessage("BL00949","BL"));		
			return false;
		}
		
		if(State_dur_to == ""){
			alert(getMessage("BL00950","BL"));		
			return false;
		}
		flag = true;
	}
	if($('#saveSearchCriteria').is(':checked')){
    	$('input:text').each(function(){
    		$(this).attr('dflt_srch_value','Y');
    	});
    	$('select').each(function(){
    		$(this).attr('dflt_srch_value','Y');
    	});

    	$('#payer_grp_code').attr('dflt_srch_value','Y');
		$('#payer_code').attr('dflt_srch_value','Y');
		$('#policy_type_code').attr('dflt_srch_value','Y');
    	
		fnAutoFillSaveCriteria(fun_id);
    }
	
	if(flag == true)
		callResultFrame(fun_id);
}
function callResultFrame(fun_id){	

	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].location.href='../../eCommon/html/blank.html';
	
	//alert("In callResultFrame ------------");
	var patient_id = document.forms[0].patient_id.value;
	var episode_type = document.forms[0].episode_type.value;			
	var encounter_id = document.forms[0].encounter_id.value;		
	var State_dur_from = document.forms[0].State_dur_from.value;		
	var State_dur_from_date = convertDate(State_dur_from,"DMY",locale,"en");			
	var State_dur_to = document.forms[0].State_dur_to.value;		
	var State_dur_to_date = convertDate(State_dur_to,"DMY",locale,"en");
	var payer_grp_code = document.forms[0].payer_grp_code.value;	
	var payer_code = document.forms[0].payer_code.value;	
	var policy_type_code = document.forms[0].policy_type_code.value;	
	var approval_doc_ref_no = document.forms[0].approval_doc_ref_no.value;
	var approval_doc_ref_type_code = document.forms[0].approval_doc_ref_type_code.value;
	
	var claim_id = document.forms[0].claim_id.value;
	var claims_services_level = document.forms[0].claims_services_level.value;		
	var insurance_Status = document.forms[0].insurance_Status.value;
	var locale = document.forms[0].locale.value;		
	var facility_id = document.forms[0].facility_id.value;	
	//alert("Query parameters : Patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&State_dur_from_date="+State_dur_from_date+"&State_dur_to_date="+State_dur_to_date+"&insurance_Status="+insurance_Status+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&approval_doc_ref_no="+approval_doc_ref_no+"&claim_id="+claim_id+"&claims_services_level="+claims_services_level+"&locale="+locale+"&facility_id="+facility_id);
	
	//document.getElementById('search_button').disabled=true; 
	if(fun_id == "EBL_RCM_TRX"){
		parent.frames[1].location.href = "../../eBL/jsp/BLRCMTransGenerateBillResult.jsp?facility_id="+facility_id+"&locale="+locale+"&visitId="+encounter_id+"&patientId="+patient_id+"&episodeType="+episode_type+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&apprDocRefNum="+approval_doc_ref_no+"&claimId="+claim_id+"&State_dur_from="+State_dur_from_date+"&State_dur_to="+State_dur_to_date+"&insurance_Status="+insurance_Status+"&claims_services_level="+claims_services_level+"&approval_doc_ref_type_code="+approval_doc_ref_type_code;
				
	}else{
		parent.frames[1].location.href="../../eBL/jsp/BLEClaimsPayerWiseDashboard.jsp?patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&State_dur_from_date="+State_dur_from_date+"&State_dur_to_date="+State_dur_to_date+"&insurance_Status="+insurance_Status+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&approval_doc_ref_no="+approval_doc_ref_no+"&claim_id="+claim_id+"&claims_services_level="+claims_services_level+"&locale="+locale+"&facility_id="+facility_id;
	}
}
function onClickPayer(cusName,cusCode)
{
	
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.frames[2].location.href='../../eCommon/html/blank.html';
	
	//alert("In onClickPayer ------------");
	var patient_id = parent.frames[1].payerWiseDashboard.document.getElementById('p_patient_id').value;
	var episode_type	= parent.frames[1].payerWiseDashboard.document.getElementById('p_episode_type').value;
	var encounter_id =  parent.frames[1].payerWiseDashboard.document.getElementById('p_encounter_id').value;
	var payer_grp_code =  parent.frames[1].payerWiseDashboard.document.getElementById('p_payer_grp_code').value;
	var payer_code = parent.frames[1].payerWiseDashboard.document.getElementById('p_payer_code').value;
	var policy_type_code = parent.frames[1].payerWiseDashboard.document.getElementById('p_policy_type_code').value;
	var approval_doc_ref_no = parent.frames[1].payerWiseDashboard.document.getElementById('p_approval_doc_ref_no').value;
	var claim_id	= parent.frames[1].payerWiseDashboard.document.getElementById('p_claim_id').value;
	var insurance_Status =  parent.frames[1].payerWiseDashboard.document.getElementById('p_insurance_Status').value;
	var claims_services_level =  parent.frames[1].payerWiseDashboard.document.getElementById('p_claims_services_level').value;
	var State_dur_from_date	= parent.frames[1].payerWiseDashboard.document.getElementById('p_State_dur_from_date').value;
	var State_dur_to_date	= parent.frames[1].payerWiseDashboard.document.getElementById('p_State_dur_to_date').value;
	var locale = parent.frames[1].payerWiseDashboard.document.getElementById('locale').value;		
	var facility_id = parent.frames[1].payerWiseDashboard.document.getElementById('p_facility_id').value;
	//alert("Query parameters : Patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&State_dur_from_date="+State_dur_from_date+"&State_dur_to_date="+State_dur_to_date+"&insurance_Status="+insurance_Status+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&approval_doc_ref_no="+approval_doc_ref_no+"&claim_id="+claim_id+"&claims_services_level="+claims_services_level+"&locale="+locale+"&facility_id="+facility_id);

	parent.frames[2].location.href = "../../eBL/jsp/BLEClaimsStatusWiseDashboard.jsp?cusName="+encodeURIComponent(cusName)+"&patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&State_dur_from_date="+State_dur_from_date+"&State_dur_to_date="+State_dur_to_date+"&insurance_Status="+insurance_Status+"&payer_grp_code="+payer_grp_code+"&payer_code="+cusCode+"&policy_type_code="+policy_type_code+"&approval_doc_ref_no="+approval_doc_ref_no+"&claim_id="+claim_id+"&claims_services_level="+claims_services_level+"&locale="+locale+"&facility_id="+facility_id;
		
}

async function onClickStatus(insStatus, payerCode){
    //alert("Calling RCM Dashboard---- "+payerCode+", "+insStatus);
	var patient_id = parent.frames[2].statusWiseDashboard.document.getElementById('p_patient_id').value;
	var episode_type	= parent.frames[2].statusWiseDashboard.document.getElementById('p_episode_type').value;
	var encounter_id =  parent.frames[2].statusWiseDashboard.document.getElementById('p_encounter_id').value;
	var payer_grp_code =  parent.frames[2].statusWiseDashboard.document.getElementById('p_payer_grp_code').value;
	var payer_code = parent.frames[2].statusWiseDashboard.document.getElementById('p_payer_code').value;
	var policy_type_code = parent.frames[2].statusWiseDashboard.document.getElementById('p_policy_type_code').value;
	var approval_doc_ref_no = parent.frames[2].statusWiseDashboard.document.getElementById('p_approval_doc_ref_no').value;
	var claim_id	= parent.frames[2].statusWiseDashboard.document.getElementById('p_claim_id').value;
	var insurance_Status =  insStatus;
	var claims_services_level =  parent.frames[2].statusWiseDashboard.document.getElementById('p_claims_services_level').value;
	var State_dur_from_date	= parent.frames[2].statusWiseDashboard.document.getElementById('p_State_dur_from_date').value;
	var State_dur_to_date	= parent.frames[2].statusWiseDashboard.document.getElementById('p_State_dur_to_date').value;
	var locale = parent.frames[2].statusWiseDashboard.document.getElementById('locale').value;		
	var facility_id = parent.frames[2].statusWiseDashboard.document.getElementById('p_facility_id').value;
	var retVal             =     new String();
	var dialogHeight     = "38" ;
	var dialogWidth      = "100" ;
	var dialogTop        = "100";
	var status             = "no";
	var features        = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	var arguments			= "" ;
	
	retVal = await window.showModalDialog("../../eBL/jsp/BLRCMTransFrameset.jsp?patientId="+patient_id+"&episodeType="+episode_type+"&visitId="+encounter_id+"&State_dur_from="+State_dur_from_date+"&State_dur_to="+State_dur_to_date+"&insurance_Status="+insurance_Status+"&payer_grp_code="+payer_grp_code+"&payer_code="+payerCode+"&policy_type_code="+policy_type_code+"&apprDocRefNum="+approval_doc_ref_no+"&claimId="+claim_id+"&claims_services_level="+claims_services_level+"&locale="+locale+"&facility_id="+facility_id+"&function_id=EBL_RCM_TRX&called_from_dashboard_YN=Y","RCM Transactions",features);
	parent.frames[0].document.getElementById('search_button').click();
}
