function reset(){
	FutOrdInsApprTrackMainFrame.location.reload();
}

function reloadPage(){
	parent.FutOrdInsApprTrackCriteriaFrame.location.reload();
	parent.FutOrdInsApprTrackResultFrame.location.href="../../eCommon/html/blank.html";
	parent.FutOrdInsApprTrackBtnFrame.location.href="../../eCommon/html/blank.html";
}

function validateFormAndQuery(){
	var enc_frm_date = document.getElementById('enc_frm_date').value;
	var enc_to_date = document.getElementById('enc_to_date').value;

	if(enc_frm_date == ""){
		alert(getMessage("BL00916","BL"));		
		return false;
	}
	
	if(enc_to_date == ""){
		alert(getMessage("BL00917","BL"));		
		return false;
	}
	callResultFrame();
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
		xmlhttp="";
	}
		xmlhttp.onreadystatechange=function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		out = xmlhttp.responseText;
		var showdata = out.substring(out.indexOf("!")+1,out.length).split("!")[1];
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
	var dialogTop			= "40px" ;
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
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
	var dialogTop			= "40px" ;
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
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
		retVal =await  window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=NURSING_UNIT_LKUP&"+param,arguments,features);
	if(episode_type == 'O' || episode_type == 'E')
	retVal =await  window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=SPECIALTY_LKUP&"+param,arguments,features);	
	
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
	var dialogTop			= "40px" ;
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
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
	var dialogTop			= "40px" ;
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
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
	var dialogTop			= "40px" ;
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
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
			var actualDays = 30;
			if(dateDif >= actualDays){
				alert(getMessage("BL0981",'BLEXT'));
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

function generateExcel(ev){
	var totalRecords = parent.frames[2].document.getElementById('rowCount').value;
	if(totalRecords == 0){
		alert("No records to Export");
		return false;
	}
	parent.FutOrdInsApprTrackResultFrame.document.getElementById('p_action_id').value = ev;
	parent.FutOrdInsApprTrackResultFrame.document.forms[0].target = 'messageFrame';
	parent.FutOrdInsApprTrackResultFrame.document.forms[0].method = 'post';
	parent.FutOrdInsApprTrackResultFrame.document.forms[0].action = "../../servlet/eBL.BLFutOrdInsApprTrackServlet";
	parent.FutOrdInsApprTrackResultFrame.document.forms[0].submit();		
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

async function billingGrpLookUp(){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';

		sql = "Select description, code from (SELECT short_desc DESCRIPTION, blng_grp_id CODE  FROM bl_blng_grp_lang_vw WHERE LANGUAGE_ID='"+locale+"'   Union Select 'All Price Code','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'BillingGroup';

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].billing_group.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].billing_group.value = returnedValues[1];
		document.forms[0].billingGrpCode.value = returnedValues[0];
	}
else
	{
	document.forms[0].billing_group.value = '';
	document.forms[0].billingGrpCode.value = '';
	}

}
async function billGrpLkup(billGrp_desc,billGrp_id,empty_chk)
{		
	if(empty_chk=='Y' && billGrp_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;			
	var facility_id  = document.forms[0].facility_id.value;			
	var target			= document.forms[0].billing_group;		
	var retVal			=  new String();
	var dialogTop			= "40px" ;
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("eBL.BillingGroup.label","BL");
	//46197 - Karthik added condition as Cash and Credit Billing Group should not be displayed in Setup Payer by Billing Group function 
	var sql1="SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE status is null and settlement_ind = 'X' and LANGUAGE_ID = '"+locale+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 1 ";
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
   	argArray[5] = target.value;	    
	argArray[6] = DESC_LINK;	
	argArray[7] = DESC_CODE;
	
	
	retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(retArray);
	var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					retArray[0]="";	
					retArray[1]="";	
				}	
	
	if(retArray != null && retArray !="")
	{					
		
		//billGrp_id.value=retArray[0];
		//billGrp_desc.value=retArray[1];	
		//alert(""+billGrp_id.value+"/"+billGrp_desc.value);
		billGrp_id.value = arr[0]; 
		billGrp_desc.value = arr[1];
		
	}
	else
	{
		//billGrp_id.value="";
		//billGrp_desc.value="";	
		billGrp_id.value = arr[0]; 
		billGrp_desc.value = arr[1]; 
	}
	
}
async function serviceGrpLookUp(){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';

	sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //Removed Union Select 'All Billing Services','**' From Dual against V211224
	title = 'Service Group';
		
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].service_group.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		document.forms[0].service_group.value = arr[1];
		document.forms[0].serviceGroupCode.value = arr[0];
	}
	else
	{
		document.forms[0].service_group.value = '';
		document.forms[0].serviceGroupCode.value = '';
	}


}

async function serviceClassificationLookUp(){

	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';

	sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //Removed Union Select 'All Billing Services','**' From Dual against V211224
	title = 'Billing Classification';
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].service_classification.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		arr=ret1.split(",");
		document.forms[0].service_classification.value = arr[1];
		document.forms[0].serviceClassificationCode.value = arr[0];
	}
	else
	{
		document.forms[0].service_classification.value = '';
		document.forms[0].serviceClassificationCode.value = '';
	}

}

function callResultFrame(){	

	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].location.href='../../eCommon/html/blank.html';

	var patient_id = document.forms[0].patient_id.value;
	var episode_type = document.forms[0].episode_type.value;			
	var encounter_id = document.forms[0].encounter_id.value;
	var spec_nursing_unit_code = document.forms[0].spec_nursing_unit_code.value;		
	var encounter_from = document.forms[0].enc_frm_date.value;		
	var encounter_from_date = convertDate(encounter_from,"DMY",locale,"en");			
	var encounter_to = document.forms[0].enc_to_date.value;		
	var encounter_to_date = convertDate(encounter_to,"DMY",locale,"en");	
	var insurance_Status = document.forms[0].insurance_Status.value;	
	var payer_grp_code = document.forms[0].payer_grp_code.value;	
	var payer_code = document.forms[0].payer_code.value;	
	var policy_type_code = document.forms[0].policy_type_code.value;	
	var order_status = document.forms[0].order_status.value;	
	var serviceGroupCode = document.forms[0].serviceGroupCode.value;	
	var serviceClassificationCode = document.forms[0].serviceClassificationCode.value;	
	var coding_status = document.forms[0].coding_status.value;	
	var billingGrpCode = document.forms[0].billingGrpCode.value;	
	var locale = document.forms[0].locale.value;		
	var facility_id = document.forms[0].facility_id.value;	
	var prevActionID = document.forms[0].prevActionID.value;
	if(prevActionID == "B") document.forms[0].prevActionID.value = "";
	var prevEncounterId = document.forms[0].prevEncounterId.value;
	if(prevEncounterId != "") document.forms[0].prevEncounterId.value = "";
	
	parent.frames[1].location.href="../../eBL/jsp/BLFutOrdInsApprTrackEncounterFrame.jsp?patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&enc_frm_date="+encounter_from_date+"&enc_to_date="+encounter_to_date+"&spec_nursing_unit_code="+spec_nursing_unit_code+"&insurance_Status="+insurance_Status+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&order_status="+order_status+"&serviceGroupCode="+serviceGroupCode+"&serviceClassificationCode="+serviceClassificationCode+"&coding_status="+coding_status+"&billingGrpCode="+billingGrpCode+"&locale="+locale+"&facility_id="+facility_id+"&prevActionID="+prevActionID+"&prevEncounterId="+prevEncounterId;
}

