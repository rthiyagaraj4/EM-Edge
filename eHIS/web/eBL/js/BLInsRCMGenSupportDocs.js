
function reset(){
	BLInsRCMGenSupportDocsFrame.location.reload();
}



function reloadPage(){
	document.frames[1].frames[0].location.reload();
	document.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
	document.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
}

function onSuccess() {
    reloadPage();
}

function validateFormAndQuery(){
	
	var patient_id = document.getElementById('patient_id').value;
	var episode_type = document.getElementById('episode_type').value;
	
	var payer_grp_code = document.getElementById('payer_grp_code').value;
	var payer_code = document.getElementById('payer_code').value;
	var policy_type_code= document.getElementById('policy_type_code').value;
	
	var encounter_id= document.getElementById('encounter_id').value;
	var encounter_status= document.getElementById('encounter_status').value;
	
	
	
	var enc_frm_date = document.getElementById('enc_frm_date').value;
	var enc_to_date = document.getElementById('enc_to_date').value;
	
	var fun_id = parent.frames[0].search.document.getElementById('function_id').value;
	
	if(payer_grp_code == ""){
		alert(getMessage("BL6277","BL"));
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
	searchResult();
}

function changeStatus(obj){
	if(obj.value===""){obj.value='N'}
	if(obj.value==='N'){obj.value='Y'}
	else{obj.value='N'}
	var total_records = document.getElementById('total_records').value;
	var dsbl_cnt=0;
	var cnt=0;
	var boolFlag=false;
	for(var i=1;i<=total_records;i++){
		if(!document.getElementById('chkbox_'+i).checked){
			boolFlag=true;
		
		}
		if(document.getElementById('chkbox_'+i).disabled){
			dsbl_cnt++;
				
		}
		if(document.getElementById('chkbox_'+i).checked){
			cnt++;
		
		}
	}
	if(boolFlag){
		document.getElementById('selectAll').checked = false;
		document.getElementById('selectAll').value = "N";
	}
	if(cnt==(total_records-dsbl_cnt)){
		document.getElementById('selectAll').checked = true;
		document.getElementById('selectAll').value = "Y";
	}
	
	
}

function selectAllRecs(){
	var total_records = document.getElementById('total_records').value;
	var selectAll = document.getElementById('selectAll').checked;

	for(var i=1;i<=total_records;i++){
		if(selectAll && !document.getElementById('chkbox_'+i).disabled){
			document.getElementById('chkbox_'+i).checked = true;
			document.getElementById('chkbox_'+i).value = "Y";
		}
		else{
			document.getElementById('chkbox_'+i).checked = false;
			document.getElementById('chkbox_'+i).value = "N";
		}
	}
}


function getParameterList(){
	
	var facility_id = document.getElementById('facility_id').value;
	if(facility_id == null) facility_id = "";
	var patient_id = document.getElementById('patient_id').value;
	if(patient_id == null) patient_id = "";
	var episode_type = document.getElementById('episode_type').value;
	if(episode_type == null) episode_type = "A";
	
	var encounter_id = document.getElementById('encounter_id').value;
	if(encounter_id == null) encounter_id = "";
	
	var payer_grp_code = document.getElementById('payer_grp_code').value;
	if(payer_grp_code == null) payer_grp_code = "";
	var payer_code = document.getElementById('payer_code').value;
	if(payer_code == null) payer_code = "";
	var policy_type_code = document.getElementById('policy_type_code').value;
	if(policy_type_code == null) policy_type_code = "";
	
	var encounter_status = document.getElementById('encounter_status').value;
	if(encounter_status == null) encounter_status = "";
	
	var enc_frm_date = document.getElementById('enc_frm_date').value;
	if(enc_frm_date == null) enc_frm_date = "";
	var enc_to_date = document.getElementById('enc_to_date').value;
	if(enc_to_date == null) enc_to_date = "";
	
	
	var query_string = "&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&encounter_status="+encounter_status+"&enc_frm_date="+enc_frm_date+"&enc_to_date="+enc_to_date;
	//alert(query_string);
	return query_string;	
}

function searchResult(){
		var queryString = getParameterList();
		parent.frames[1].location.href = "../../eBL/jsp/BLInsRCMGenSupportDocsQueryResult.jsp?"+queryString;
		parent.frames[2].location.href = "../../eBL/jsp/BLInsRCMGenSupportDocsQueryBtn.jsp";
}


function highlightRow(obj) {
	
	var frm = document.payerresult;
	var rowClicked = frm.rowClicked.value;

	if (rowClicked != obj) {

		if (rowClicked.length > 0) {
			$('#row' + rowClicked + ' td').each(function() {
				$(this).attr('class', 'label');
			});

			$('#row' + rowClicked + ' td span').each(function() {
				$(this).attr('class', 'LABEL');
			});
		}

		$('#row' + obj + ' td').each(function() {
			$(this).attr('class', 'LocalYellow');
		});

		$('#row' + obj + ' td span').each(function() {
			$(this).attr('class', 'SpanYellow');
		});
	}
	frm.rowClicked.value = obj;
	
}


function generateDocs() {
	var frm =  parent.frames[1].document.forms[0];
	var frmObj = parent.frames[1].document;
	var total_records= frm.total_records.value;

	
	
	var checkStatus = "";
	
	for(var i = 1; i <= total_records; i++ ){
		if(frmObj.getElementById("chkbox_"+i).checked){
			frmObj.getElementById("chkbox_"+i).value = "Y";
			checkStatus = "Y";
		}
	}
	
	if(checkStatus != "Y"){
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));

		return;
	}	
	
	var xmlString = formXMLStringMain(frm);
	
	
	var updation = formValidation(xmlString);
	
	if(updation == true)
	{
		
	frm.target = 'messageFrame';
	frm.method = "post";
	frm.action = "../../servlet/eBL.BLInsRCMGenSupportDocsServlet";
	frm.submit();  
		
	}
	
}




function formXMLStringMain(frmObj) {
    if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
        var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"Y" + "\" ";
				} else {
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + "N" + "\" ";
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
						"\" ";
				}
			} else if (arrObj[i].type == "select-multiple") {
				for (var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			}
		}
        }
        xmlStr += " /></root>";
		
		
    }
    return xmlStr;
}

function formValidation(xmlStr) {
	
	var temp_jsp = "../../eBL/jsp/BLInsRCMGenSupportDocsPersistance.jsp";


    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
   
    var responseText = xmlHttp.responseText;
	eval(responseText);
    return true;
}

function PatientIdLookup()
{	
	var pat_id=PatientSearch();		
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


async function showRemarks(obj)
{
	var dialogWidth = "40";
	var dialogHeight = "20";
	var features		="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title="Order Entry";
	
	var index = obj.name.charAt(obj.name.length - 1);
	
	
	var patient_id = document.getElementById('patient_id'+index).value;
	if(patient_id == null) patient_id = "";
	
	var encounter_type_id = document.getElementById('encounter_type_id'+index).value;
	var parts= encounter_type_id.split("/");
	var encounter_id =parts[1];
	
	var param = "title="+title+"&encounter_id="+encounter_id+"&patient_id="+patient_id;
	
	
	dialog =await window.showModalDialog("../../eBL/jsp/BLInsRCMGenSupportDocsOrderEntry.jsp?"+param,arguments,features);
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

function encounterIDLkup(){
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
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=ENC_ID_LKUP&"+param,arguments,features);
	
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





function payerGrpLkup(){
	
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
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=PAYER_GROUP_LKUP&"+param,arguments,features);
	
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

function payerLkup(){
	
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
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=PAYER_LKUP&"+param,arguments,features);
	
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

function policyLookup(){
	
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
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=POLICY_LKUP&"+param,arguments,features);
	
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


function encFromDateValidation(obj, startDt, endDt){
	
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var	valid_status = compareDates(startDt, endDt);
	}
}



function encToDateValidation(obj, startDt, endDt ){
	var locale = document.forms[0].locale.value;
	if(obj.value != "") {	
		var	valid_status = compareDates(startDt, endDt)	
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

function generateExcel(ev){

	var frm =  parent.frames[1].document.forms[0];


	frm.p_action_id.value = ev;
	frm.target = 'messageFrame';
	frm.method = 'post';
	frm.action = "../../servlet/eBL.BLInsRCMGenSupportDocsServlet";
	frm.submit();
}
