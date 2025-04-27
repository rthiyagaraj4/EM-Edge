function reset(){
	RCMWorkAreaFrame.location.reload();
}

function reloadPage(){
	parent.RCMQueryCriteriaFrame.location.reload();
	parent.RCMQueryResultFrame.location.href="../../eCommon/html/blank.html";
	parent.RCMQueryResultBtnFrame.location.href="../../eCommon/html/blank.html";
}

function validateFormAndQuery(){
	var enc_frm_date = document.getElementById('enc_frm_date').value;
	var enc_to_date = document.getElementById('enc_to_date').value;
	var payer_grp_code = document.getElementById('payer_grp_code').value;
	var payer_code = document.getElementById('payer_code').value;
	var claim_number = document.getElementById('claim_number').value;
	var claim_status = document.getElementById('claim_status').value;

	if(claim_number == ""){
		if(payer_grp_code == ""){
			alert(getMessage("BL6277","BL"));
			return false;
		}

		if(payer_code == ""){
			alert(getMessage("BL9102","BL"));
			return false;
		}
		
		if(enc_frm_date == ""){
			alert(getMessage("BL00916","BL"));		
			return false;
		}
		
		if(enc_to_date == ""){
			alert(getMessage("BL00917","BL"));		
			return false;
		}
	}
	if(claim_status == ""){
		alert("Claim Status cannot be blank");		
		return false;
	}
	statusChange();
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
	
	var  retVal= "";
	
	if(episode_type == 'I' || episode_type == 'D')
		retVal = await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=NURSING_UNIT_LKUP&"+param,arguments,features);
	if(episode_type == 'O' || episode_type == 'E')
	retVal = await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=SPECIALTY_LKUP&"+param,arguments,features);	
	
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
	if(obj.checked){
		document.forms[0].past_recs_days.disabled = false;
		document.forms[0].past_recs_days.focus();
	}
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
            alert(getMessage('BL4115', 'BL'));
            endDate.value = '';
			return false;
        }
    }
	return true;
}

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

function encFromDateValidation(obj, startDt, endDt){
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);
		
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
			var actualDays = 30;
			if(dateDif > actualDays){
				alert(getMessage("BL00918",'BL'));
				return false;
			}
		}	
	}
}

function docFromDateValidation(obj, startDt, endDt){
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);
		
		if(valid_status == true || valid_status == "true"){
			valid_status = compareDates(startDt, endDt);
		}
	}
}

function docToDateValidation(obj, startDt, endDt ){
	var locale = document.forms[0].locale.value;
	if(obj.value != "") {	
		var valid_status = validDateObj(obj,"DMY",locale);
		if(valid_status == true){
			valid_status = compareDates(startDt, endDt)
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

function generateExcel(){
	
	var claim_status = document.getElementById('claim_status').value;
	
	if(claim_status == "E"){
		var totalRecords = parent.frames[1].document.getElementById('total_records').value;
		if(totalRecords == 0){
			alert("No records to Export");
			return false;
		}
	}
	
	document.forms[0].target = 'messageFrame';
	document.forms[0].method = 'post';
	document.forms[0].action = "../../servlet/eBL.RCMExportExcelServlet";
	document.forms[0].submit();		
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

function claimStatusChange(claim_status){

	if(claim_status.value == "E" || claim_status.value == "D" || claim_status.value == "R"){
		document.getElementById('claim_number').value = "";
		document.getElementById('claim_number').disabled = true;
		document.getElementById('claim_num_but').disabled = true;
		
		document.getElementById('ins_status').value = "";
		document.getElementById('ins_status').disabled = true;
		document.getElementById('doc_gen_from').value = "";
		document.getElementById('doc_gen_from').disabled = true;
		document.getElementById('doc_gen_from_cal').disabled = true;
		document.getElementById('doc_gen_to').value = "";
		document.getElementById('doc_gen_to').disabled = true;
		document.getElementById('doc_gen_to_cal').disabled = true;
	}
	
	if(claim_status.value != "E"){
		document.getElementById('doc_gen_from').value = "";
		document.getElementById('doc_gen_from').disabled = false;
		document.getElementById('doc_gen_from_cal').disabled = false;
		document.getElementById('doc_gen_to').value = "";
		document.getElementById('doc_gen_to').disabled = false;
		document.getElementById('doc_gen_to_cal').disabled = false;				
	}
	
	if(claim_status.value == "G" || claim_status.value == "I" || claim_status.value == "F" || claim_status.value == "P"){
		document.getElementById('claim_number').value = "";
		document.getElementById('claim_number').disabled = false;
		document.getElementById('claim_num_but').disabled = false;	
	}
	
	if(claim_status.value == "F" || claim_status.value == "P"){
		document.getElementById('ins_status').disabled = false;	
	}else{
		document.getElementById('ins_status').value = "";
		document.getElementById('ins_status').disabled = true;	
	}
}
