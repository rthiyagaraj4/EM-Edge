/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
06/02/2017		IN0061112		Badmavathi B							GHL-CRF-0413 - Barcode search
06/11/2017		IN064968			Shazana Hasan							MMS-DM-CRF-0112 - Barcode Item Desc Decoding
15/11/2017		INC065695			Shazana Hasan							MMS-DM-CRF-0112 - Barcode search
10/08/2018		INC068298			Shazana Hasan							GHL-SCF-1369 - Practitioner Name
26/08/2019      IN071167        B Haribabu                                  GHL-ICN-0050 
19/2/2019               IN:072096               B Haribabu                                                    MMS-JU-SCF-0141 
---------------------------------------------------------------------------------------------------------
*/ 
var mode = "";
var prevObj = null;
var prevColor = null;
var store_code = "";
var doc_type_code = ""; 
var patient_id = "";
var patient_name = "";
var encounter = "";
var grosschargeamt_val = "";
var grosschargeamt = "";
var doc_no = "";
var l_bill_doc_num = "";
var Finilize = "";
var l_bill_doc_type = "";
var l_slmt_reqd_yn = "";
var doc_no_mod = "";
var chargeable_yn = "";
var v_blng_group_id = "";
var message_bill = "";
var prevIndex = "";
var encounterchk = "";
var toolBarString = "";//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
var chk_req_flag = "flase";

function create() {
	//callOTSalesWindow();
	mode = MODE_INSERT;
	f_query_add_mod.location.href = "../../eST/jsp/SalesFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id+"&module_id="+module_id ; //03/02/12
}
function query() {
	mode = MODE_MODIFY;
	f_query_add_mod.location.href = "../../eST/jsp/SalesQueryFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id+"&module_id="+module_id ;
}
function reset() {
	if(mode == MODE_INSERT){
		create();
	}
	if(mode == MODE_MODIFY){
		if(f_query_add_mod.frameSalesHeader!=undefined){
		var doc_type_code = f_query_add_mod.frameSalesHeader.document.formSalesHeader.doc_type_code.value;
		var doc_no = f_query_add_mod.frameSalesHeader.document.formSalesHeader.doc_no.value;
		f_query_add_mod.document.location.href = "../../eST/jsp/SalesFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no;
		}else{
			f_query_add_mod.location.href = "../../eST/jsp/SalesQueryFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id+"&module_id="+module_id ;
		}
	}
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}
function checkTRNType(obj) {
	document.formSalesHeader.encounter_id.disabled = false;
	document.formSalesHeader.patient_id.value="";
	document.formSalesHeader.patient_name.value="";

	document.getElementById('pat_class').innerText="";
	document.getElementById('room_no').innerText="";
	document.getElementById('bed_no').innerText="";
	document.getElementById('NU_Clinic').innerText="";
	document.getElementById('NU_Clinic_code').value="";
	var site=document.formSalesHeader.site.value;//Added for KDAH-SCF-0432.1
	
	if (obj.value == "R" || obj.value == "X") {
		document.formSalesHeader.encounter_id.disabled = true;
		document.formSalesHeader.encounter_id.value = "";
		document.getElementById('id_encounter_id_gif').style.visibility = "hidden";
		
		if (obj.value == "X") {
			document.getElementById('id_patient_name_gif').style.visibility = "visible";
			document.formSalesHeader.patient_name.disabled = false;			
			document.getElementById('pat_additional_dtl_label_1').style.visibility = "visible";
			document.getElementById('pat_additional_dtl_label_2').style.visibility = "visible";
			if(site=="true")//Added for KDAH-SCF-0432.1
			{
			document.getElementById('ModifyFin_Details').style.visibility = "hidden";// Added By Narasimhulu for KDAH-CRF-0432.1  
			}
		}
		else{
			document.getElementById('pat_additional_dtl_label_1').style.visibility = "hidden";
			document.getElementById('pat_additional_dtl_label_2').style.visibility = "hidden";
			document.formSalesHeader.Patient_age.value ="";
			if(site=="true")//Added for KDAH-SCF-0432.1
			{
				document.getElementById('ModifyFin_Details').style.visibility = "visible";
				document.getElementById('ModifyFin_Details').disabled=true;
				document.getElementById('ModifyFin_Details').removeAttribute('href');
			}//Adding end for KDAH-CRF-0432.1
		}
	} else {
		document.getElementById('id_encounter_id_gif').style.visibility = "visible";
		document.getElementById('pat_additional_dtl_label_1').style.visibility = "hidden";
		document.getElementById('pat_additional_dtl_label_2').style.visibility = "hidden";
		document.formSalesHeader.Patient_age.value ="";
		if(site=="true")//Added for KDAH-SCF-0432.1
			{
		document.getElementById('ModifyFin_Details').style.visibility = "hidden";//Added By Narasimhulu for KDAH-CRF-0432.1 
			}
			
	}
	if (obj.value != "I") {
		document.formSalesHeader.discharge_yn.disabled = true;
		document.formSalesHeader.discharge_yn.checked = false;
	} else {
		document.formSalesHeader.discharge_yn.disabled = false;
	}
	if (obj.value != "") {
		document.formSalesHeader.store_code_disabled.value = "disabled";
	}
	
	if(document.formSalesHeader.site_id.value=="MC"){
	if( obj.value == "X"){
		document.getElementById('id_practitioner_name_gif').style.visibility = "hidden";
		if(site=="true")//Added for KDAH-SCF-0432.1
		document.getElementById('ModifyFin_Details').style.visibility = "hidden";//Added By Narasimhulu for KDAH-CRF-0432.1 
		document.formSalesHeader.practitioner_name.value ="";
		document.formSalesHeader.practitioner_id.value ="";	
	}else{
		document.getElementById('id_practitioner_name_gif').style.visibility = "visible";
		document.formSalesHeader.practitioner_name.value ="";
		document.formSalesHeader.practitioner_id.value ="";
	}
	}
	else if (document.formSalesHeader.site_id.value=="SRR"  || document.formSalesHeader.site_id.value=="SKR"){
	if( obj.value == "X" ){
	document.getElementById('practitioner_name').style.visibility			= "visible";
	if(site=="true")//Added for KDAH-SCF-0432.1
	document.getElementById('ModifyFin_Details').style.visibility = "hidden";//Added By Narasimhulu for KDAH-CRF-0432.1 
	document.getElementById('practitioner_name_label').style.visibility	= "visible";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "visible";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "hidden";
	}
	else if (obj.value == "R")
	{
	document.getElementById('practitioner_name').style.visibility			= "visible";
	
	document.getElementById('practitioner_name_label').style.visibility	= "visible";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "visible";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "visible";
	if(site=="true") //Added for KDAH-SCF-0432.1
        { //added curlybrase
	 document.getElementById('ModifyFin_Details').style.visibility = "visible";
		  document.getElementById('ModifyFin_Details').disabled=true;
			document.getElementById('ModifyFin_Details').removeAttribute('href');
	}//end
	}
	else{	
	document.getElementById('practitioner_name').style.visibility			= "hidden";
	document.getElementById('practitioner_name_label').style.visibility	= "hidden";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "hidden";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "hidden";	
	if(site=="true")//Added for KDAH-SCF-0432.1
	document.getElementById('ModifyFin_Details').style.visibility = "hidden";//Added By Narasimhulu for KDAH-CRF-0432.1 
	}
	}
	else{
	if( obj.value == "X" ){
	document.getElementById('practitioner_name').style.visibility			= "visible";
	document.getElementById('practitioner_name_label').style.visibility	= "visible";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "visible";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "hidden";
	if(site=="true")//Added for KDAH-SCF-0432.1
	document.getElementById('ModifyFin_Details').style.visibility = "hidden";//Added By Narasimhulu for KDAH-CRF-0432.1 
	}
	else if (obj.value == "R")	{
	document.getElementById('practitioner_name').style.visibility			= "visible";
	document.getElementById('practitioner_name_label').style.visibility	= "visible";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "visible";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "visible";
	if(site=="true")//Added for KDAH-SCF-0432.1
	{// added clurly barse 
	document.getElementById('ModifyFin_Details').style.visibility = "visible";//Added By Narasimhulu for KDAH-CRF-0432.1 
	document.getElementById('ModifyFin_Details').disabled=true;
			document.getElementById('ModifyFin_Details').removeAttribute('href');
	}// end 
	}
	else{	
	document.getElementById('practitioner_name').style.visibility			= "hidden";
	document.getElementById('practitioner_name_label').style.visibility	= "hidden";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "hidden";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "hidden";	
	if(site=="true")//Added for KDAH-SCF-0432.1
	document.getElementById('ModifyFin_Details').style.visibility = "hidden";//Added By Narasimhulu for KDAH-CRF-0432.1 
	}
	}

}
// Added by Padmapriya
function checkSaleTRNType(obj) {
if(document.formSalesHeader.patient_id.disabled == false){
	document.formSalesHeader.encounter_id.disabled = false;
	document.formSalesHeader.patient_id.value="";
	document.formSalesHeader.patient_name.value="";

	document.getElementById('pat_class').innerText="";
	document.getElementById('room_no').innerText="";
	document.getElementById('bed_no').innerText="";
	document.getElementById('NU_Clinic').innerText="";
	document.getElementById('NU_Clinic_code').value="";
	var site=document.formSalesHeader.site.value;//Added By Narasimhulu for KDAH-CRF-0432.1 
	
	if (obj.value == "R" || obj.value == "X") {
		document.formSalesHeader.encounter_id.disabled = true;
		document.formSalesHeader.encounter_id.value = "";
		document.getElementById('id_encounter_id_gif').style.visibility = "hidden";
		if (obj.value == "X") {
			document.getElementById('id_patient_name_gif').style.visibility = "visible";
			document.formSalesHeader.patient_name.disabled = false;			
			document.getElementById('pat_additional_dtl_label_1').style.visibility = "visible";
			document.getElementById('pat_additional_dtl_label_2').style.visibility = "visible";
			if(site=="true")//Added By Narasimhulu for KDAH-CRF-0432.1 
			document.getElementById('ModifyFin_Details').style.visibility = "hidden";//Added By Narasimhulu for KDAH-CRF-0432.1 
		}
		else{
			document.getElementById('pat_additional_dtl_label_1').style.visibility = "hidden";
			document.getElementById('pat_additional_dtl_label_2').style.visibility = "hidden";
			document.formSalesHeader.Patient_age.value ="";
			if(site=="true")//Added By Narasimhulu for KDAH-CRF-0432.1 
			document.getElementById('ModifyFin_Details').style.visibility = "visible";//Added By Narasimhulu for KDAH-CRF-0432.1 
		}
	} else {
		document.getElementById('id_encounter_id_gif').style.visibility = "visible";
		document.getElementById('pat_additional_dtl_label_1').style.visibility = "hidden";
		document.getElementById('pat_additional_dtl_label_2').style.visibility = "hidden";
		document.formSalesHeader.Patient_age.value ="";
			
	}
	if (obj.value != "I") {
		document.formSalesHeader.discharge_yn.disabled = true;
		document.formSalesHeader.discharge_yn.checked = false;
	} else {
		document.formSalesHeader.discharge_yn.disabled = false;
	}
	if(document.formSalesHeader.site_id.value=="MC"){
	if( obj.value == "X"){
		document.getElementById('id_practitioner_name_gif').style.visibility = "hidden";
		document.formSalesHeader.practitioner_name.value ="";
		document.formSalesHeader.practitioner_id.value ="";	
	}else{
		document.getElementById('id_practitioner_name_gif').style.visibility = "visible";
		document.formSalesHeader.practitioner_name.value ="";
		document.formSalesHeader.practitioner_id.value ="";
	}
	}
	else if (document.formSalesHeader.site_id.value=="SRR"  || document.formSalesHeader.site_id.value=="SKR"){
	if( obj.value == "X" ){
	document.getElementById('practitioner_name').style.visibility			= "visible";
	document.getElementById('practitioner_name_label').style.visibility	= "visible";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "visible";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "hidden";
	}
	else if (obj.value == "R")
	{
	document.getElementById('practitioner_name').style.visibility			= "visible";
	document.getElementById('practitioner_name_label').style.visibility	= "visible";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "visible";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "visible";
	}
	else{	
	document.getElementById('practitioner_name').style.visibility			= "hidden";
	document.getElementById('practitioner_name_label').style.visibility	= "hidden";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "hidden";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "hidden";	
	}
	}
	else{
	if( obj.value == "X" ){
	document.getElementById('practitioner_name').style.visibility			= "visible";
	document.getElementById('practitioner_name_label').style.visibility	= "visible";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "visible";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "hidden";
	}
	else if (obj.value == "R")	{
	document.getElementById('practitioner_name').style.visibility			= "visible";
	document.getElementById('practitioner_name_label').style.visibility	= "visible";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "visible";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "visible";
	}
	else{	
	document.getElementById('practitioner_name').style.visibility			= "hidden";
	document.getElementById('practitioner_name_label').style.visibility	= "hidden";	
	document.getElementById('id_practitioner_name_gif').style.visibility	= "hidden";
	document.getElementById('prac_name_mandatory_label').style.visibility	= "hidden";	
	}
	}
/*	if(document.formSalesHeader.sal_trn_type.value == null || document.formSalesHeader.sal_trn_type.value == ""){
		document.formSalesHeader.sal_trn_type.focus();
	}else{
		document.formSalesHeader.patient_id.focus();
	}
*/	
}
}


async function deleterecord() {
	if(  f_query_add_mod.frameSalesHeader==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameSalesHeader.document.formSalesHeader;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
	formObj.mode.value = MODE_DELETE;

	if(formObj.sal_delete_yn.value=="N"){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
	formObj.mode.value = MODE_MODIFY;
		return false;
}
	if (await confirmDelete() != YES) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST") + "<BR>" + flag;
		formObj.mode.value = MODE_MODIFY;
		return;
	}
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag;
	if (result) {
		onSuccess();
	} else {
		formObj.mode.value = prevMode;
	}
}
async function searchPatient() {
	var formObj = document.forms[0];

	//console.log(formObj);
	/*if(formObj.patient_id.value!=undefined){ //added for TBMC-SCF-0014
		var direct_sale_patient_flag = formObj.direct_sale_patient_flag.value;
		if (formObj.sal_trn_type.value == "X" && direct_sale_patient_flag=="true") {

			var ret_val= searchPatientId(formObj.patient_id);
		 //added for TBMC-SCF-0014
			if(ret_val==true){
				getPatientName(formObj.patient_id.value);
			}

			if(ret_val==false)//added for TBMC-SCF-0014
				return false;
			else 
				return true;
		}
	}
	*/
	var patient_id =await PatientSearch();
	//alert(patient_id);
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}
function getPatientName(_patient_id) {
	if(_patient_id=="") // added for  KDAH-CRF-0432.1  start
		{//added curlybarce
			setPatientName('');	//added for  KDAH-CRF-0432.1 END
			callitem();// ICN ICN7125
		}//added curlybarce End
var formObj = document.formSalesHeader; //added for TBMC-SCF-0014
	if (_patient_id != ""){
//added for TBMC-SCF-0014 - start
	var direct_sale_patient_flag = formObj.direct_sale_patient_flag.value;

	if(formObj.patient_id.value!=undefined && direct_sale_patient_flag=="true"){

		if (formObj.sal_trn_type.value == "X") {

			var ret_val = searchPatientId(formObj.patient_id);
			if(ret_val==false)
				return false;
			setPatientName(patient_id);
		}
	}
	}
//added for TBMC-SCF-0014 - end
	if (_patient_id != "") {
		var xmlString = getXMLString(null);
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		//document.formSalesHeader.sal_trn_type.disabled = false;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?patient_id=" + _patient_id + "&validate=PATIENT_NAME&trn_type=" + formObj.sal_trn_type.value+"&siteId="+formObj.site_id.value, false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		if (!result) {
			alert(getMessage(flag, "ST"));
			formObj.patient_id.focus();
		}
	}
}
//function setPatientName(_patient_name,p_sex,p_age,p_dob,p_age_type) {
//GHL-CRF-0419.2 STARTS//
var countt=0;//GHL-CRF-0419.2 
function setflagcount(count)
{

	countt=count;//GHL-CRF-0419.2 
	if(count=="1")
	{
		alert( getMessage("ST_RESTRICT_OP_EM_ENCTR", "ST"));
		document.formSalesHeader.patient_id.value="";
		document.formSalesHeader.patient_name.value="";
	
		document.getElementById('pat_class').value="";
		document.getElementById('NU_Clinic').value="";
	}	
}
//GHL-CRF-0419.2 ENDS//
async function setPatientName(_patient_name) {


	if(_patient_name==null || _patient_name.toLowerCase() =='null'){
		_patient_name='';
	}
	document.formSalesHeader.patient_name.innerText = _patient_name;
	document.formSalesHeader.patient_name.value=_patient_name;
	//document.formSalesHeader.Patient_sex.value = p_sex;
	//document.formSalesHeader.Patient_age.value = p_age;
	//document.formSalesHeader.Patient_dob.value = p_dob;
	//document.formSalesHeader.Patient_age_DMY.value = p_age_type;
	/*GHL-CRF-0419.2 STARTS*/
	var restrictChecked=document.formSalesHeader.restrictChecked.value;
	var site1=document.formSalesHeader.site1.value;
	/*GHL-CRF-0419.2 ENDS*/
	
	var saltype=document.formSalesHeader.sal_trn_type.value;
	
	/*GHL-CRF-0419.1 STARTS*/
	if((saltype =="O" ||saltype =="E") && restrictChecked=="Y" && site1=="true")
	{
		//alert("true");
		var patient_id1 = document.formSalesHeader.patient_id.value;
		var xmlString = getXMLString(null);
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?patient_id=" + patient_id1 + "&validate=RESTRICT_EM_OP", false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
//alert(responseText);
		eval(responseText);
		
		//alert("restrict count-"+document.formSalesHeader.flagcount.value);
	}	
	/*GHL-CRF-0419.1 ENDS*/
	
		
	//document.formSalesHeader.sal_trn_type.disabled = true;
	if (document.formSalesHeader.chargeable_yn.value == "Y") {
		if (document.formSalesHeader.sal_trn_type.value == "R" && (document.formSalesHeader.patient_name.value.length > 0) && (document.formSalesHeader.patient_id.value.length > 0)) {
			var formObj = document.formSalesHeader;
	//document.formSalesHeader.sal_trn_type.disabled = false;
			var patient_id = document.formSalesHeader.patient_id.value;
			var sal_trn_type = document.formSalesHeader.sal_trn_type.value;
			var xmlString = getXMLString(null);
			var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			var xmlHttp = new XMLHttpRequest();
			//var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&validate=HEADER_PROCEDURE", false);
			xmlHttp.send(xmlDoc);
			var responseText = xmlHttp.responseText;
			responseText = trimString(responseText);
	//alert(responseText);
			eval(responseText);
			if (result == true && message.length > 0) {
		//window.showModalDialog("../jsp/SalesBillingHdrWarning.jsp?warning="+message+"&call=P",'','dialogHeight:4; dialogWidth:30; center:0; status: no; dialogLeft :75; dialogTop :250;' );
				/** @user - ST_PREPARE_HDR */
				var retVal = "";
				var dialogHeight = "8vh";
				var dialogWidth = "15vw";
				var dialogTop = "250";
				var center = "1";
				var status = "no";
				var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments = "";
				var url = "../../eST/jsp/SalesBillingAuthorize.jsp";
				retVal =await window.showModalDialog(url, arguments, features);
				if (retVal == YES) {
				//formObj.finalized_yn.value="Y";
				} else {
					document.formSalesHeader.patient_id.value = "";
					document.formSalesHeader.patient_name.value = "";
				}
			} else {
				if (!result) {
					document.formSalesHeader.patient_id.value = "";
					document.formSalesHeader.patient_name.value = "";
					document.formSalesHeader.patient_id.focus();
					parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
				}
			}
		}
	}
	
}
function callitem()// KDAH-CRF-432.1 against--added for ICN7125  Start 
{
var site_flag=document.formSalesHeader.site.value;
/*GHL-CRF-0419.2 Starts*/
if(countt=="1")
{
	document.formSalesHeader.encounter_id.length=0;
	var select=document.formSalesHeader.encounter_id;
	var option = document.createElement('option');
	option.text = option.value = "---Select---";
	select.add(option, 0);
	document.formSalesHeader.encounter_id.disabled=true;
	countt=0;
}	
/*GHL-CRF-0419.2 Ends*/
	if(site_flag=="true"){//Modified site_flag to  site_flag==true for script error
	
	if(document.getElementById('ModifyFin_Details')!=undefined)
	{
		if(document.getElementById('patient_name').value!="" && document.getElementById('patient_name').value.length!=0){//  added if cont for  KDAH-CRF-0432.1 
		document.getElementById('ModifyFin_Details').disabled=false;
		document.getElementById('ModifyFin_Details').setAttribute('href','javascript:findtl()');}
	}}
	if(document.getElementById('patient_name').value.length==0)//  added if cont for  KDAH-CRF-0432.1 
	{
		if(site_flag=="true"){//Modified site_flag to  site_flag==true for script error
		document.getElementById('ModifyFin_Details').disabled=true;
		document.getElementById('ModifyFin_Details').removeAttribute('href');
		}
	}
}// End INC7125

async function callBillingHdrProcedure() {
	//alert("encounter_id" + document.formSalesHeader.encounter_id.value);
	if (document.formSalesHeader.chargeable_yn.value == "Y") {
		if (document.formSalesHeader.sal_trn_type.value != "R" && (document.formSalesHeader.patient_name.value.length > 0) && (document.formSalesHeader.patient_id.value.length > 0) && document.formSalesHeader.encounter_id.value > 0) {
			var formObj = document.formSalesHeader;
	//document.formSalesHeader.sal_trn_type.disabled = false;
			var patient_id = document.formSalesHeader.patient_id.value;
			var sal_trn_type = document.formSalesHeader.sal_trn_type.value;
			var encounter_id = document.formSalesHeader.encounter_id.value;
			var xmlString = getXMLString(null);
			var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			var xmlHttp = new XMLHttpRequest();
			//var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&validate=HEADER_PROCEDURE", false);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(xmlDoc);
			var responseText = xmlHttp.responseText;
			responseText = trimString(responseText);
	//alert(responseText);
			eval(responseText); 
	//alert(message);
			if (result && message.length > 0) {
				var retVal = "";
				var dialogHeight = "8vh";
				var dialogWidth = "15vw";
				var dialogTop = "250";
				var center = "1";
				var status = "no";
				var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments = "";
				var url = "../../eST/html/SalesBillingAuthorize.html";
				retVal =await window.showModalDialog(url, arguments, features);
				if (retVal == YES) {
				//formObj.finalized_yn.value="Y";
				} else {
					document.formSalesHeader.encounter_id.value = "";
				}
			} else {
				if (!result) {
					document.formSalesHeader.encounter_id.value = "";
					document.formSalesHeader.encounter_id.focus();
					parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
				}
			}
		}
	}
}
async function callItemSearchScreen() {
	//alert("a12");
	var search_string = "";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if (!parent.frameSalesListHeader.formSalesListHeader.item_desc.readOnly) {
		search_string = parent.frameSalesListHeader.formSalesListHeader.item_desc.value;
	}
	var formObj = parent.parent.frameSalesHeader.document.formSalesHeader;
	if (formObj.patient_id.value == "" || formObj.patient_id.value == null) {
		formObj.patient_id.value = formObj.patient_id_ot.value;
	}
	if (formObj.encounter_id.value == "" || formObj.encounter_id.value == null) {
		formObj.encounter_id.value = formObj.encounter_ot.value;
	}
	
	var arrayObject = new Array(formObj.patient_id);
	var names = new Array(getLabel("Common.patientId.label", "Common"));
	var x = 0;
	if ((formObj.sal_trn_type.value != "R") && (formObj.encounter_ot.value == "") && (formObj.sal_trn_type.value != "X")) {
		arrayObject[++x] = formObj.encounter_id;
		names[x] = getLabel("Common.encounterid.label", "Common");
	}
	if (formObj.sal_trn_type.value == "X") {
		arrayObject[++x] = formObj.patient_name;
		names[x] = getLabel("Common.PatientName.label", "Common");
	}
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject != true) {
   	  //blankObject.focus();
	} else {
		var store_code = parent.parent.frameSalesHeader.formSalesHeader.store_code.value;
		var category = "A";
		var sole_source = "A";
		var ps_item = "A";
		var mfg_item = "A";
		var expiry = "A";
		var consignment = "A";
		var kit = "Y";
		var direct_sale = "N";
		if (formObj.sal_trn_type.value == "X") {
			direct_sale = "X";
		}
		var item_class = parent.parent.frameSalesHeader.formSalesHeader.item_class_code.value;
		var item_class_check = parent.parent.frameSalesHeader.formSalesHeader.item_class_check.value;
		if (item_class_check == "Y") {
			if ((item_class == "") || (item_class == "null")) {
				alert(getMessage("ITEM_CLASS_CANNOT_BLANK", "ST"));
			}
			if ((item_class_check == "Y") && ((item_class != "") && (item_class != "null"))) {
				sub1();
			}
		} else {
			sub1();
		}
		async function sub1() {
			//Modified by Sakti against AMS-CRF-0011 trn_type passing
			var retVal =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"SAL", "N", "", "", "", kit, direct_sale);
		//var retVal=callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment,chkitemstorecmb,"","","",kit);
			if (retVal != null) {
				if (retVal[0] == "kit") {
					parent.parent.frameSalesHeader.document.formSalesHeader.store_code_disabled.value = "disabled";
					var patient_id = parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.value;
					var encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.value;
					var sal_trn_type = parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;

					parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.disabled = true;
					parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.disabled = true;
					parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.disabled = true;
					var xmlString = getXMLString(null);
			        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
					var xmlHttp = new XMLHttpRequest();
					//var xmlDoc="";
					//xmlDoc.loadXML(getXMLString(null));
					xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?kit_template_code=" + retVal[1] + "&validate=KIT_TEMPLATE&store_code=" + store_code+"&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id, false);
					xmlHttp.setRequestHeader("Content-Type", "text/xml");
					xmlHttp.send(xmlDoc);
					var responseText = xmlHttp.responseText;
					responseText = trimString(responseText); 
					eval(responseText);
					return;
				}
				
				parent.parent.frameSalesHeader.document.formSalesHeader.store_code_disabled.value = "disabled";
			//parent.parent.frameSalesHeader.document.formSalesHeader.store_code="disabled";
				document.formSalesListHeader.item_code.value = retVal[0];
				document.formSalesListHeader.item_desc.value = retVal[1];
				document.formSalesListHeader.item_desc.readOnly = true;
				document.formSalesListHeader.expiry_yn.value = retVal[2];
				document.formSalesListHeader.uom_code.value = retVal[13];
				document.getElementById('id_store_item_unit_cost').innerHTML = retVal[14];
				document.getElementById('id_uom').innerHTML =retVal[15];
				document.getElementById('id_uom1').innerHTML = retVal[15];
				document.formSalesListHeader.dec_allowed_yn.value = retVal[27];
				document.formSalesListHeader.no_of_decimals.value = retVal[28];
				
			
				var formObj = document.formSalesListHeader;
				var xmlString = getXMLString(null);
		        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
				var xmlHttp = new XMLHttpRequest();
				//var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&item_qty=" + formObj.item_qty.value + "&validate=GET_STATUS", false);
				xmlHttp.setRequestHeader("Content-Type", "text/xml");
				xmlHttp.send(xmlDoc);
				var responseText = xmlHttp.responseText;
				responseText = trimString(responseText); 
				eval(responseText);
				//alert(responseText);
				/*if( !result ) {
				if(message=="Multiple"){
				alert("Mutilpe uom");
				cancel_me();
				return;
					}
				}*/	
				if (result && parent.parent.frameSalesHeader.document.formSalesHeader.chargeable_yn.value == "Y" ) {
					parent.parent.parent.messageFrame.location.href = "../../eCommon/html/blank.html";
					var formObj = document.formSalesListHeader;
					var xmlString = getXMLString(null);
			        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
					var xmlHttp = new XMLHttpRequest();
					//var xmlDoc="";
					var patient_id = parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.value;
					var encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.value;
					if (encounter_id == "" || encounter_id == null) {
						encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_ot.value;
					}
					var sal_trn_type = parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;
					//xmlDoc.loadXML(getXMLString(null));
					xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?item_code=" + formObj.item_code.value + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&validate=ITEMVAD_PROCEDURE", false);
					xmlHttp.setRequestHeader("Content-Type", "text/xml");
					xmlHttp.send(xmlDoc);
					var responseText = xmlHttp.responseText;
					responseText = trimString(responseText);
						//alert(responseText);
					eval(responseText);
					if (!result) {
						parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + (message);
	//						refreshDetails("0");
					}
					
					parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.disabled = true;
					parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.disabled = true;
					parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.disabled = true;
					parent.parent.frameSalesHeader.document.formSalesHeader.search_id.disabled = true;
					document.formSalesListHeader.item_qty.value="";
					document.formSalesListHeader.tot_item_qty.value="";
					document.getElementById('id_charge_amt').innerText="";
					document.getElementById('id_payable_amt').innerText="";
					parent.parent.frameSalesList.frameSalesListDetail.location.href = "../../eCommon/html/blank.html";
					
					document.formSalesListHeader.item_qty.focus();
					if (result) {
						if (result && message.length > 1) {
							var retVal = "";
							var dialogHeight = "65vh";
							var dialogWidth = "75vw";
							var dialogTop = "250";
							var center = "1";
							var status = "no";
							var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
							var arguments = "";
							var url = "../../eST/html/SalesBillingAuthorize.html";
							retVal =await window.showModalDialog(url, arguments, features);
							if (retVal == YES) {
							} else {
								document.formSalesHeader.item_code.value = "";
								document.formSalesHeader.item_desc.value = "";
							}
						}
					} else {
						parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
					}
				} else {
					parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
					if (result == false) {
						parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";//err_num="+ escape(getMessage(message)) ;
						if (message == "PHY_INV_PROCESS_INITIATED") {
							alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.formSalesListHeader.phy_inv_id.value);
						} else {
							alert(getMessage(message, "ST"));
						}
						  //refreshDetails();
						parent.frameSalesListHeader.location.href = "../../eST/jsp/SalesListHeader.jsp";
						parent.frameSalesListDetail.location.href = "../../eCommon/html/blank.html";
					}
				}
			}
		}
	}
	//added for KDAH-CRF-0432.1 start
			if(parent.parent.frameSalesHeader.document.formSalesHeader.ModifyFin_Details!=undefined ){
				parent.parent.frameSalesHeader.document.formSalesHeader.ModifyFin_Details.disabled="true";
				parent.parent.frameSalesHeader.document.formSalesHeader.ModifyFin_Details.removeAttribute('href');
			}
//			if((document.getElementsByTagName("ModifyFin_Details"))!=undefined ){
//				document.getElementsByTagName("ModifyFin_Details").disabled="true";
//				document.getElementsByTagName("ModifyFin_Details").removeAttribute('href');
//			}	//added for KDAH-CRF-0432.1 END
}
function setStockDetails(_stock_item_yn, _store_item_unit_cost, _available_stock ) {

	document.formSalesListHeader.stock_item_yn.value = _stock_item_yn;
	if (_stock_item_yn == "Y") {
		
		//document.formSalesListHeader.billable_item_yn.value = _billable_item_yn ;  //added for barcode

		document.getElementById('id_store_item_unit_cost').innerText = _store_item_unit_cost;
		if(document.formSalesListHeader.dec_allowed_yn.value=="Y"){
			document.getElementById('id_stock_available').innerText =parseFloat(_available_stock). toFixed(document.formSalesListHeader.no_of_decimals.value);
		}else{
			document.getElementById('id_stock_available').innerText = parseFloat(_available_stock).toFixed(0);
		}
		if (_available_stock == "0") {
			//alert(getMessage("STOCK_NOT_AVAILABLE","ST"));
			//parent.location.reload();
		}
	} else {
		//document.formSalesListHeader.batchsearch.disabled=true;
		//document.formSalesListHeader.edit.disabled=true;
	}
}
function ComputeCost() {
	var quantity = document.formSalesListHeader.item_qty.value;
	var cost = document.getElementById('id_store_item_unit_cost').innerText;
	if (isNaN(quantity) || isNaN(cost)) {
		document.getElementById('id_item_sal_value').innerText = "";
		return;
	}
	/**
	 * @Name - Priya
	 * @Date - 18/05/2010
	 * @Inc# - 
	 * @Desc -  To round up item cost value based on the no_of_decimals_for_cost column in st_acc_entity_param table
	 */
	var no_of_decimals_for_cost = eval(document.formSalesListHeader.no_of_decimals_for_cost.value);
	var value = setNumber(quantity * cost, no_of_decimals_for_cost);
	document.getElementById('id_item_sal_value').innerText = value;
}
	/**
	* @Name - Mahesh
	* @Date - 19/01/2010
	* @Inc# - IN015496
	* @Desc - Decimal Allowed yn is set to y, then allow decimal else dont.
	*/


function CheckQuantity(obj) {
	if(document.formSalesListHeader.decimal_allowedYN.value=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}
	ComputeCost();
	if (document.formSalesListHeader.stock_item_yn.value == "N") {
		return true;
	}
	if (parseFloat(document.formSalesListHeader.item_qty.value) > parseFloat(document.getElementById('id_stock_available').innerText)) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
		//document.formSalesListHeader.item_qty.focus();
		//alert("1");
		document.formSalesListHeader.apply.disabled=true; //check
		return false;

	} else{
		document.formSalesListHeader.apply.disabled=false;
	}
	/*		if(parent.parent.frameSalesHeader.formSalesHeader.chargeable_yn.checked==true){
			document.formSalesListHeader.view.disabled=false;
		}
*/
	viewCharges();
}
function CheckValue() {
	if (document.formSalesListHeader.item_cost_value.value != null) {
		if (document.formSalesListHeader.item_cost_value.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	if (isValidDouble(document.formSalesListHeader.quantity)) {
	}
	ComputeCost();
}
function addToList() { 
//////////////////
/*Code added for Walk-thru on 3/3/2010*/
	var formObjDtl = parent.parent.frameSalesDetail.document.formSalesDetail;
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	for (i = 0; i < parseInt(formObjDtl.total_checkboxes.value); i++) {
		checkBoxObj = eval("formObjDtl.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	var formObjHdr = parent.parent.frameSalesHeader.document.formSalesHeader;
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObjHdr.records_to_delete.value = forDeletion;
/*Code Ended 3/3/2010*/
	var formObj = parent.frameSalesListHeader.document.formSalesListHeader;
	/*
	if (!formObj.item_desc.readOnly) {
		if(!validateCommonCodeSearch(formObj.item_code, formObj.item_desc)){
			alert(message);
			return;
		}
	}
*/
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	//var names = new Array("Item", "Quantity");
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		//alert("2");
		//formObj.apply.disabled = true; //Commented By Dinesh T on 2/18/2011, as the issue of add button is disbabled, which is not simulatable
		if (parent.frameSalesListDetail.document.formSalesListDetail == null && formObj.stock_item_yn.value == "Y") {
			var formObj = document.formSalesListHeader;
			var store_code = parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
			var _item_code = formObj.item_code.value;
			var item_qty = formObj.tot_item_qty.value;
			parent.frameSalesListDetail.location.href = "../../eST/jsp/SalesListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id+ "&kit=kit" + "&addToList=true";
			return;
		}
	//////////////////
		if (formObj.stock_item_yn.value == "Y") {
//var formObj=  parent.frameSalesListHeader.document.formSalesListHeader;
			var formObjDtl = parent.parent.frameSalesList.frameSalesListDetail.document.formSalesListDetail;
			var proceed = false;
			var messageFrame = parent.parent.messageFrame;
			var errorPage = "../../eCommon/jsp/error.jsp";
			//var item_qty=formObj.item_qty.value;
			var item_qty = formObj.tot_item_qty.value;
			_total_checkboxes = formObjDtl.total_checkboxes.value;
	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc -calculate the sum of batch qty and item qty.
	*/
			var no_of_decimals=formObjDtl.no_of_decimals.value;
			
			var sum = 0;
			for (i = 0; i < _total_checkboxes; i++) {
				var qty = eval("formObjDtl.item_qty_" + i).value;
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {
					
					sum += parseFloat(qty);
				}
			}
		if(formObjDtl.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
		
			if (sum != item_qty) {
				alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
				formObj.apply.disabled = false;
				return;
			}
		}
		/**
					 * @Name - krishna
					 * @Date - 24/12/2009
					 * @Inc# - IN017635
					 * @Desc - batch detail null handling begin
				 */
		if (formObjDtl.batchsearch.value == "newbatch") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=setnewbatch&index=" + formObj.index.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + (message);
				return;
			}
		}
		/**
					 * @Name - krishna
					 * @Date - 24/12/2009
					 * @Inc# - IN017635
					 * @Desc - batch detail null handling end
				 */
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		if (formObj.stock_item_yn.value == "Y") {
			//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		} else {
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		}
	//alert(formObjDtl.total_checkboxes.value);
	//	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&item_code="+formObj.item_code.value+"&item_desc="+formObj.item_desc.value+"&item_qty="+formObj.item_qty.value+"&item_unit_cost="+formObj.item_unit_cost.value +"&item_cost_value="+formObj.item_cost_value.value+"&remarks="+formObj.remarks.value+"&expiry_yn="+formObjDtl.expiry_yn.value+"&batch_id_applicable_yn="+formObjDtl.batch_id_applicable_yn.value+"&trade_id_applicable_yn="+formObjDtl.trade_id_applicable_yn.value+"&stock_uom_code="+ formObj.uom_code.value+"&uom="+ formObjDtl.uom.value+"&validate=ADD_TO_LIST", false);
		parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" ;
	
		if (parent.parent.frameSalesHeader.document.formSalesHeader.chargeable_yn.value == "Y" && formObj.billable_item_yn.value=="Y") {
			if(formObj.bl_override_excl_incl_ind.value!="" ){
			if(formObj.bl_override_excl_incl_ind.value!="S" && formObj.bl_incl_excl_override_reason_code.value==""){
				//parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("ST_REASON_CODE_NOT_BLANK", "ST");
				formObj.apply.disabled = false;
				return;
			}
			}
			/**
			* @Name - Priya 
			* @Date - 22/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/

				xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value) + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('id_store_item_unit_cost').innerText + "&item_cost_value=" + parent.frameSalesListHeader.document.getElementById('id_item_sal_value').innerText+"&pat_net_amt=" + parent.frameSalesListHeader.document.getElementById('id_payable_amt').innerText+"&gross_charge_amt=" + parent.frameSalesListHeader.document.getElementById('id_charge_amt').innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + encodeURIComponent(formObj.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&batch_records=" + formObjDtl.total_checkboxes.value +"&remarks_code="+formObj.remarks_code.value+"&bl_override_excl_incl_ind="+formObj.bl_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_code="+formObj.bl_incl_excl_override_reason_code.value+"&bl_def_override_excl_incl_ind="+formObj.bl_def_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(formObj.bl_incl_excl_override_reason_desc.value,"UTF-8")+"&approval_reqd_yn="+formObj.approval_reqd_yn.value+"&bl_override_allowed_yn="+formObj.bl_override_allowed_yn.value+ "&pat_paid_amt=" + parent.frameSalesListHeader.document.getElementById('id_paid_amt').innerText+"&decimal_allowedYN="+formObj.decimal_allowedYN.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&records_to_delete="+formObjHdr.records_to_delete.value+"&billable_item_yn="+formObj.billable_item_yn.value+"&sale_req_qty="+formObj.sale_req_qty.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);
				/*records_to_delete is added for SRR walk-thru on 3/3/2010*/
		} else {
			/**
			* @Name - Priya 
			* @Date - 22/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value) + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('id_store_item_unit_cost').innerText + "&item_cost_value=" + parent.frameSalesListHeader.document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value) + "&uom_desc=" +encodeURIComponent( document.getElementById('id_uom').innerText,"UTF-8" )+ "&batch_records=" + formObjDtl.total_checkboxes.value + "&stock_available=" + document.getElementById('id_stock_available').innerText+"&remarks_code="+formObj.remarks_code.value +"&decimal_allowedYN="+formObj.decimal_allowedYN.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&records_to_delete="+formObjHdr.records_to_delete.value+ "&billable_item_yn="+formObj.billable_item_yn.value+"&sale_req_qty="+formObj.sale_req_qty.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);
			/*records_to_delete is added for SRR walk-thru on 3/3/2010*/
		}
		//xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&item_code="+formObj.item_code.value+"&item_desc="+escape(formObj.item_desc.value)+"&item_qty="+formObj.item_qty.value+"&item_unit_cost="+document.getElementById("id_store_item_unit_cost").innerText +"&item_cost_value="+parent.frameSalesListHeader.document.getElementById("id_item_sal_value").innerText+"&expiry_yn="+formObj.expiry_yn.value+"&uom_code="+formObj.uom_code.value+"&stock_item_yn="+formObj.stock_item_yn.value+"&remarks="+escape(formObj.remarks.value)+"&uom_desc="+ document.getElementById("id_uom").innerText+"&stock_available="+document.getElementById("id_stock_available").innerText+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
//		alert(responseText);
		eval(responseText);
		if (result) {
			parent.parent.frameSalesHeader.formSalesHeader.preview.disabled = false;
			refreshDetails(formObj.index.value);
		} else {
			formObj.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + (message);
			parent.frameSalesListDetail.location.href = "../../eCommon/html/blank.html";
		}
	} else {
		//blankObject.focus();
	}
	restoreToolbar();//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
} 

// To refresh detail frame on click of Add
function refreshDetails(index) {
	//doc_type_code, doc_no
//	parent.parent.frameSalesDetail.location.reload();
	parent.parent.frameSalesDetail.location.href = "../../eST/jsp/SalesDetail.jsp?index=" + index;
	parent.frameSalesListHeader.location.href = "../../eST/jsp/SalesListHeader.jsp";
	parent.frameSalesListDetail.location.href = "../../eCommon/html/blank.html";
//	parent.frameSalesListDetail.location.href='../../eST/jsp/SalesListDetail.jsp';
//	parent.frameSalesListDetail.location.reload();
}
function refreshDetail() {
	//doc_type_code, doc_no
//	parent.parent.frameSalesDetail.location.reload();
	//parent.parent.frameSalesDetail.location.href="../../eST/jsp/SalesDetail.jsp?index="+index ;
	parent.frameSalesListHeader.location.href = "../../eST/jsp/SalesListHeader.jsp";
	parent.frameSalesListDetail.location.href = "../../eCommon/html/blank.html";
//	parent.frameSalesListDetail.location.href='../../eST/jsp/SalesListDetail.jsp';
//	parent.frameSalesListDetail.location.reload();
}
async function apply() {
	//alert(parent.parent.frameSalesHeader.document.formSalesHeader.item_class_code.value);

	if(  f_query_add_mod.frameSalesDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}  
	var _encounter_id = f_query_add_mod.frameSalesHeader.document.formSalesHeader.encounter_id.value;
	var _trn_type = f_query_add_mod.frameSalesHeader.document.formSalesHeader.sal_trn_type.value; 
	var _patient_id = f_query_add_mod.frameSalesHeader.document.formSalesHeader.patient_id.value;
	var _site_id = f_query_add_mod.frameSalesHeader.document.formSalesHeader.site_id.value;
	var module_id = f_query_add_mod.frameSalesHeader.document.formSalesHeader.module_id.value; //Added by Rabbani #Inc NO : 38106 on 28-03-2013
	encounterchk = true;
	
	if (f_query_add_mod.frameSalesHeader.document.formSalesHeader.sal_trn_type.value != "X")
	{
		if (f_query_add_mod.frameSalesHeader.document.formSalesHeader.sal_trn_type.value != "R")
		{
			Encounterchkmethod(_patient_id,_trn_type,_site_id,_encounter_id);
		}
	}
	if(encounterchk)
	{
	var formObj = f_query_add_mod.frameSalesDetail.document.formSalesDetail;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	for (i = 0; i < totalCBox; i++) {
		checkBoxObj = eval("formObj.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	if (noDetailExists) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	for (i = 0; i < f_query_add_mod.frameSalesDetail.document.formSalesDetail.total_checkboxes.value; i++) {
		if ((eval("f_query_add_mod.frameSalesDetail.document.formSalesDetail.checkbox" + i).checked)) {
		} else {
			var xmlString = getXMLString(null);
	         var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			var xmlHttp = new XMLHttpRequest();
			//var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=ZERO_QUANTITY&index=" + i, false);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(xmlDoc);
			var responseText = xmlHttp.responseText;
			responseText = trimString(responseText); 
			//alert("responseText1 = > "+responseText);
			
			eval(responseText);
			if (!result) {
				//alert("Cannot Issue Zero Quantity----->");
				eval("var item_desc_00 = f_query_add_mod.frameSalesDetail.document.formSalesDetail.item_desc_"+(i+1)+".value;			messageFrame.location.href = errorPage + \"?err_num=\" + getMessage(\"SALE_QTY_CANNOT_BE_ZERO\", \"ST\")+\" for \"+item_desc_00;");			
				return;
			}
		}
	}
	//alert("after alert");
	var formObj = f_query_add_mod.frameSalesHeader.document.formSalesHeader;
	if (formObj.discharge_yn.checked == true) {
		formObj.discharge_yn.value = "Y";
	} else {
		formObj.discharge_yn.value = "N";
	}
	if (formObj.chargeable_yn.checked == true) {
		formObj.chargeable_yn.value = "Y";
	} else {
		formObj.chargeable_yn.value = "N";
	}

	var arrayObject = new Array(formObj.patient_id);
	
	var names = new Array(getLabel("Common.patientId.label", "Common"));
	if (formObj.sal_trn_type.value != "R" && formObj.sal_trn_type.value != "X") {
		arrayObject[arrayObject.length] = formObj.encounter_id;
		names[names.length] = getLabel("Common.encounterid.label", "Common");
	}
		//if (formObj.site_id.value == "MC" ) {
		if (module_id != "OT" && formObj.site_id.value == "MC" ) {//Added by Rabbani #Inc NO : 38106 on 28-03-2013
		arrayObject[arrayObject.length] = formObj.practitioner_name;
		names[names.length] = getLabel("Common.practitionername.label", "Common");
	}

	if (formObj.sal_trn_type.value == "X") {
		//if (formObj.site_id.value != "MC" ) {
		if (module_id != "OT" && formObj.site_id.value != "MC"){ //Added by Rabbani #Inc NO : 38106 on 28-03-2013
		arrayObject[arrayObject.length] = formObj.practitioner_name;
		names[names.length] = getLabel("Common.practitionername.label", "Common");
		}
		arrayObject[arrayObject.length] = formObj.Patient_age;
		names[names.length] = getLabel("Common.age.label", "Common");
		arrayObject[arrayObject.length] = formObj.Patient_sex;
		names[names.length] = getLabel("Common.Sex.label", "Common");
	 }
	//Added By Sakti Sankar against Inc#33234 on 04/10/2012
	//if (formObj.sal_trn_type.value == "R" && formObj.site_id.value != "MC") {
	//Added by Rabbani #Inc NO : 38106 on 28-03-2013
	 if (module_id != "OT" && formObj.sal_trn_type.value == "R" && formObj.site_id.value != "MC"){
		arrayObject[arrayObject.length] = formObj.practitioner_name;
		names[names.length] = getLabel("Common.practitionername.label", "Common");
	}
	//Added ends
//	if (formObj.site_id == "MC" && formObj.practitioner_name.value==" " ) {
	//	alert("APP-ST0180 Practitioner Name cannot be blank");
	//	return false;
	
	//}
	
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if (blankObject == true) {
	
///
		forDeletion = forDeletion.substring(0, forDeletion.length - 1);
		formObj.records_to_delete.value = forDeletion;
////call 
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=CHECK_AUTHORIZE_ALLOWED&store_code=" + formObj.store_code.value, false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	
	if (formObj.authorize_allowed_yn.value == "Y") {
		
		//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlStr	="<root><SEARCH " ;
		xmlStr+=" function_type=\"2\" ";		
		xmlStr +=" /></root>" ; 
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + formObj.trn_type.value + "&store_code="+formObj.store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);		
		
		var response = "";
		//var response = confirmFinalize(); commented
		if(result){
			response = await confirmFinalize();	
		}else{
			response = YES;
		}
		//Added ends
			
		if(response=="")
		{
			messageFrame.location.href = errorPage + "?err_num=";
			return false;
		}
		
		if (response == YES) {
			formObj.finalized_yn.value = "Y";
			Finilize = "Y";
		}else{
			formObj.finalized_yn.value = "N";
			Finilize = "N";
		 }
		}
		/*
		
		if (formObj.stock_item_yn.value=='Y') {
			xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		}
		else{
		}

	//	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&item_code="+formObj.item_code.value+"&item_desc="+formObj.item_desc.value+"&item_qty="+formObj.item_qty.value+"&item_unit_cost="+formObj.item_unit_cost.value +"&item_cost_value="+formObj.item_cost_value.value+"&remarks="+formObj.remarks.value+"&expiry_yn="+formObjDtl.expiry_yn.value+"&batch_id_applicable_yn="+formObjDtl.batch_id_applicable_yn.value+"&trade_id_applicable_yn="+formObjDtl.trade_id_applicable_yn.value+"&stock_uom_code="+ formObj.uom_code.value+"&uom="+ formObjDtl.uom.value+"&validate=ADD_TO_LIST", false);
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&item_code="+formObj.item_code.value+"&item_desc="+formObj.item_desc.value+"&item_qty="+formObj.item_qty.value+"&item_unit_cost="+document.getElementById('id_store_item_unit_cost').innerText +"&item_cost_value="+parent.frameSalesListHeader.document.getElementById('id_item_sal_value').innerText+"&expiry_yn="+formObj.expiry_yn.value+"&uom_code="+formObj.uom_code.value+"&stock_item_yn="+formObj.stock_item_yn.value+"&remarks="+escape(formObj.remarks.value)+"&uom_desc="+ document.getElementById('id_uom').innerText+"&stock_available="+document.getElementById('id_stock_available').innerText+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
//		alert(responseText);
		eval(responseText);
*/
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		l_slmt_reqd_yn = "";

		if (result && Finilize == "Y" && formObj.chargeable_yn.value == "Y" && formObj.item_class_doc_yn.value == "N" && formObj.no_of_records.value == "999999") {
			
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=Bill_data", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (result && message.length > 0) {
				results = message.split(",");
				l_slmt_reqd_yn = results[0];
				l_bill_doc_num = results[1];
				l_bill_doc_type = results[2];
				doc_no = (formObj.doc_type_code.value)+"-"+results[3];
				//doc_no = results[3];
				v_blng_group_id = results[4];
				message_bill = results[5];
				//alert("message_bill = > "+message_bill);
				var call_disc_function_yn = results[6];
				var episode_id = "";
				var visit_id = "";
				var encounter_id = formObj.encounter_id.value;
				if(formObj.sal_trn_type.value=="E"||formObj.sal_trn_type.value=="O"){
					episode_id = (formObj.encounter_id.value).substring(0,encounter_id.length-4);
					visit_id = (formObj.encounter_id.value).substring(encounter_id.length-4,encounter_id.length);
				}else if(formObj.sal_trn_type.value=="I"||formObj.sal_trn_type.value=="D"){
					episode_id = formObj.encounter_id.value;
					visit_id   = "1";
				}
				var sal_trn_type = formObj.sal_trn_type.value;
				if(sal_trn_type=="X"){
					sal_trn_type = "R";
				}

				//if (l_slmt_reqd_yn == "Y") {
				if (!(formObj.sal_trn_type.value=="I"||formObj.sal_trn_type.value=="D")) {
					var retVal = "";
					var dialogHeight = "65vh";
					var dialogWidth = "70vw";
					var dialogTop = "100";
					var center = "1";
					var status = "no";
					var column_sizes = escape("");
					var column_descriptions = "";
					var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments = "";
					var store_code = f_query_add_mod.frameSalesHeader.document.formSalesHeader.store_code.value;
					var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=" + l_bill_doc_type + "&bill_doc_num=" + l_bill_doc_num + "&store_code=" + store_code + "&blng_grp=" + v_blng_group_id + "&module_id=ST&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions+"&patient_id="+formObj.patient_id.value+"&encounter_id="+formObj.encounter_id.value+"&call_disc_function_yn="+call_disc_function_yn+"&doc_no="+doc_no+"&episode_id="+episode_id+"&visit_id="+visit_id+"&slmt_reqd_yn="+l_slmt_reqd_yn+"&episode_type="+sal_trn_type;
					retVal =await window.showModalDialog(url, arguments, features);
					while(retVal==undefined){
						retVal = await window.showModalDialog(url, arguments, features);
					}
				}
			}
		
			flag1 = (flag.split("~"))[0];
			flag2 = (flag.split("~"))[1];
			flag1 = (flag1 == "null" ? "" : flag1);
			//if (result && l_slmt_reqd_yn == "Y") {//commented by Mahesh as print alert is not coming for inpatients or daycare only..

			if (result) {
				if (flag2 == "PY") {
					if (formObj.authorize_allowed_yn.value == "Y") {
						var PConfirm = await confirmPrinting();
						if (PConfirm == "Yes") {
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc="";
							xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
							xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=printOnlineDoc&msg=" + message, true);
							xmlHttp.send(xmlDoc);
							//responseText = xmlHttp.responseText;commented by Ganga
							//eval(responseText);
						}
					}
				} 
				else if (flag2 == "PN") {
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc="";
							xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
							xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=printOnlineDoc&msg=" + message, true);
							xmlHttp.send(xmlDoc);
							//responseText = xmlHttp.responseText;
							//eval(responseText);
				}
				
			}
			if (result && l_slmt_reqd_yn == "Y" && retVal != undefined) {
				if (doc_no == "") {
					doc_no = doc_no_mod;
				}
				messageFrame.location.href = errorPage + "?err_num=" + "<B>"+getMessage("ST_SALE_TRANSACTION_01", "ST")+" </B>" + l_bill_doc_type + "-" + l_bill_doc_num + "<B> "+getMessage("ST_SALE_TRANSACTION_02", "ST")+" ::</B>" + doc_no;
				//onSuccess();
			} else {
				
				//messageFrame.location.href = errorPage + "?err_num=" + message_bill + "<BR>" + "DOC NO:: " + doc_no;
				//alert("else part, errorPage = > "+errorPage+" message_bill = > "+message_bill+" flag1 = > "+flag1);
					messageFrame.location.href = errorPage + "?err_num=" + message_bill + "<BR>"+flag1;//+ getMessage("DOC_NO", "ST") +": "+ doc_no;
			}
			//onSuccess();
		}else{
			//if (result && l_slmt_reqd_yn != "Y" && l_slmt_reqd_yn != "null" && l_slmt_reqd_yn != null) {commented by ganga for finalize no and print alert no and for ip and daycare . so moved to down billing part
			if (result) {				
				flag1 = (flag.split("~"))[0];
				flag2 = (flag.split("~"))[1];
				flag1 = (flag1 == "null" ? "" : flag1);
				if (result) {
					if (flag2 == "PY") {
						if (formObj.authorize_allowed_yn.value == "Y") {					
							var PConfirm = await confirmPrinting();
							if (PConfirm == "Yes") {
								var xmlHttp = new XMLHttpRequest();
								var xmlDoc="";
								xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
								xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=printOnlineDoc&msg=" + message, true);
								xmlHttp.send(xmlDoc);
								//responseText = xmlHttp.responseText;
								//eval(responseText);
							}
						}
					}
					else if (flag2 == "PN") {
								var xmlHttp = new XMLHttpRequest();
								var xmlDoc="";
								xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
								xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=printOnlineDoc&msg=" + message, true);
								xmlHttp.send(xmlDoc);
								//responseText = xmlHttp.responseText;
								//eval(responseText);
					}			
				}
			//if (message_bill != "") {
			if (message_bill != "" && l_slmt_reqd_yn != "Y" && l_slmt_reqd_yn != "null" && l_slmt_reqd_yn != null ) {
				messageFrame.location.href = errorPage + "?err_num=" + message_bill + "<BR>" + flag1;
			} else {
				messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
			}
			//onSuccess();
		} else {
			if (!result) {
				messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>";
				if (!result && flag != "") {
					messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>";
					//f_query_add_mod.frameSalesDetail.location.href = "../../eST/jsp/SalesDetail.jsp?function_id=" + function_id;
				}
			}
		}
	}
	} else {
		//blankObject.focus();
	}
	Finilize = "";
	l_slmt_reqd_yn == "";
}
else
	{
	messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	return;
    }
}

function Encounterchkmethod(_patient_id,_trn_type,_site_id,_encounter_id)
{		
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");    
	var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?patient_id=" + _patient_id + "&validate=ENCOUNTER_NEW_LIST&trn_type=" + _trn_type +"&site_id="+ _site_id + "&encounter_id="+ _encounter_id , false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText); 
		eval(responseText);

	           if (!result) {
   		       alert("Cannot process the Sale as the Discharge Advice is Already Prepared for this Patient");
		       encounterchk =false;
			   return encounterchk;
	           }
}

function setAuthorize_allowed(_authorize_allowed_yn) {
	f_query_add_mod.frameSalesHeader.document.formSalesHeader.authorize_allowed_yn.value = _authorize_allowed_yn;
}
function cancel_me(index) {
      // commented for kit template avoiding enable the checkbox #Inc no:35290 on 24/09/12
	//eval("parent.parent.frameSalesDetail.document.formSalesDetail.checkbox"+index).disabled = false;
	parent.frameSalesListHeader.location.href = "../../eST/jsp/SalesListHeader.jsp";
	parent.parent.frameSalesList.frameSalesListDetail.location.href = "../../eCommon/html/blank.html";
	//Added for GHL-CRF-0413 starts
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=clearTmpBean", false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText); 
	eval(responseText);
	//Added for GHL-CRF-0413 ends
}
function editViewBatch() {
	var formObj = document.formSalesListHeader;//parent.frameSalesListHeader.formSalesListHeader;
	var store_code = parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	if (parent.frameSalesListDetail.document.formSalesListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	/*
			var formObj=document.formSalesListHeader;
			var store_code=parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
			var _item_code=formObj.item_code.value;
			var item_qty=formObj.item_qty.value;
			parent.frameSalesListDetail.location.href="../../eST/jsp/SalesListDetail.jsp?function=edit&store_code="+store_code+"&item_code="+_item_code+"&item_qty="+item_qty+"&function_id="+parent.parent.function_id+"&-=true";
			return;
		}
if (!formObj.item_desc.readOnly) {
		if(!validateCommonCodeSearch(formObj.item_code, formObj.item_desc)){
			alert(message);
			return;
		}
	}
*/
	//var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var arrayObject = new Array(formObj.item_code, formObj.tot_item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.tot_item_qty.value;
		parent.frameSalesListDetail.location.href = "../../eST/jsp/SalesListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&expiry_yn=" + formObj.expiry_yn.value + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id;
	} else {
		//blankObject.focus();
	}
}
async function callBatchSearch() {
	var formObj = document.formSalesListHeader;
	var store_code = parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	var formObj1 = parent.parent.frameSalesHeader.document.formSalesHeader;
	if (parent.frameSalesListDetail.document.formSalesListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	/*
	if (!formObj.item_desc.readOnly) {
		if(!validateCommonCodeSearch(formObj.item_code, formObj.item_desc)){
			alert(message);
			return;
		}
	}
*/
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.item_qty.value;
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "Y";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "Y";
		var retval =await callBatchSearchWindow(_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, "", formObj1.doc_type_code.value, formObj1.doc_no.value, formObj1.trn_type.value);
		if (retval != null && retval!="" && retval!=undefined) {
			parent.frameSalesListDetail.location.href = "../../eST/jsp/SalesListDetail.jsp?function=search&batchsearch=newbatch&store_code=" + store_code + "&item_code=" + _item_code + "&expiry_yn=" + formObj.expiry_yn.value + "&index=" + formObj.index.value + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id;
	//		parent.frameUrgentIssueListDetail.location.href="../../eST/jsp/GeneralBatchList.jsp?Param=BATCH";
		}
	} else {
		//blankObject.focus();
	}
}
function checkBatchQty(obj, available_qty) {
if(document.formSalesListDetail.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(eval(obj))) {  //false is already there now changed that-- by ganga against INC27453  (!checkDoubleFormat(obj,false))
			return false;
		}
	}else{
		if (!checkIntegerFormat(eval(obj))) {  //false is already there now changed that-- by ganga against INC27453  (!checkDoubleFormat(obj,false))
			return false;
		}
	}
		if (parseFloat(available_qty) < parseFloat(obj.value)) {
			alert(getMessage("BATCH_QTY_NOT_GRT_AVLQTY", "ST"));//Modified for IN071167
			obj.value="";
			obj.focus();
		}
	
}
function checkRemarksLength(obj) {
	if (!setTextAreaMaxLength(obj, 200)) {
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		obj.focus();
	}
}
function modifyData(index) {
	if(parent.frameSalesHeader.document.formSalesHeader.prevIndex.value!=""){
		prevIndex = parent.frameSalesHeader.document.formSalesHeader.prevIndex.value;
		//eval("document.formSalesDetail.checkbox" + prevIndex).checked = false;
		//eval("document.formSalesDetail.checkbox" + prevIndex).disabled = false; //commented by Rabbani #Inc no:35290 on 20/09/12  It is not working for Kit Template
	
	}
	parent.frameSalesHeader.document.formSalesHeader.prevIndex.value = index;
	var trObject = eval(document.getElementById('tr_' + index));
	
	//commented by Rabbani #Inc no:35290 on 20/09/12  It is not working for Kit Template
	//eval("document.forms[0].checkbox" + index).checked = false;
	//eval("document.forms[0].checkbox" + index).disabled = true;
	//ends
	changeRowColor(trObject);
	parent.frameSalesList.location.href = "../../eST/jsp/SalesListFrame.jsp?function=modify&index=" + index + "&function_id=" + parent.parent.function_id + "&BARCODE_YN=" + document.getElementById('BARCODE_YN').value;
}
function Modify(obj) {
	/**
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById('readOnlyDiv').style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");
	var doc_no = obj.cells[1].innerText;
	var doc_type_code = obj.cells[4].innerText;
	var module_id = parent.SalesQueryHeader.formSalesQueryCriteria.module_id.value;
	parent.document.location.href = "../../eST/jsp/SalesFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no+ "&module_id=" + module_id;
}
function setChargeable() {
	if (document.formSalesHeader.chargeable_yn.checked == true) {
		document.formSalesHeader.chargeable_yn.value = "Y";
	} else {
		document.formSalesHeader.chargeable_yn.value = "N";
	}
}
function setDischarge() {
	if (document.formSalesHeader.discharge_yn.checked == true) {
		document.formSalesHeader.discharge_yn.value = "Y";
	} else {
		document.formSalesHeader.discharge_yn.value = "N";
	}
}
function viewCharges() {
	//alert("viewCharges");
			//alert(parent.parent.frameSalesHeader.document.formSalesHeader.chargeable_yn.value);
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		var patient_id = parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.value;
		var encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.value;
		var sal_trn_type = parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;
	if (parent.parent.frameSalesHeader.document.formSalesHeader.chargeable_yn.value == "Y" && document.formSalesListHeader.billable_item_yn.value=="Y") {
	chargeDetails();
		var formObj = document.formSalesListHeader;
	}		

		/*if ((formObj.item_qty.value) != "") {
			calTotalQty();
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?item_code=" + formObj.item_code.value + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&tot_item_qty="+ formObj.tot_item_qty.value + "&validate=ITEMCHARGE_DTLS", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
		
			eval(responseText);
			
			if (result && message.length > 0) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
				document.getElementById('apply').disabled = false;
				results = message.split(",");
				for (var i = 0; i < 23; i++) {
					insind = results[0];
					baseqty = results[1];
					baserate = results[2];
					basechargeamt = results[3];
					grosschargeamt = results[4];
					discountper = results[5];
					discountamt = results[6];
					daytypecode = results[7];
					daytypedesc = results[8];
					timetypecode = results[9];
					timetypedesc = results[10];
					addlfactor = results[11];
					ordercatalogcode = results[12];
					ordercatalogdesc = results[13];
					blngservcode = results[14];
					blngservdesc = results[15];
					netchargeamt = results[16];
					patgrosschargeamt = results[17];
					patdiscamt = results[18];
					patnetamt = results[19];
					custgrosschargeamt = results[20];
					custdiscamt = results[21];
					custnewamt = results[22];
				}
				if (document.getElementById('id_payable_amt')) {
					//document.getElementById("id_payable_amt").innerText=grosschargeamt;
					//document.getElementById("id_payable_amt").innerText = netchargeamt;
					grosschargeamt_val = grosschargeamt;
					//document.getElementById("id_charge_amt").innerText=netchargeamt;//grosschargeamt
					//document.getElementById("id_charge_amt").innerText = grosschargeamt;
				}
				
			} else {
				if (!result) {
					if (parent.parent.frameSalesHeader.document.formSalesHeader.chargeable_yn.value == "Y") {
						document.getElementById('apply').disabled = true;
					}
					parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
				}
			}
		}
	}*/
}
function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 0; k < 2; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 0; k < 2; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}


// Addded on Tuesday, August 03, 2004
async function previewDetails() {
	var store_code = document.formSalesHeader.store_code.value;
	var doc_type_code = document.formSalesHeader.doc_type_code.value;
	var patient_id = document.formSalesHeader.patient_id.value;
	var patient_name = document.formSalesHeader.patient_name.value;
	var encounter = document.formSalesHeader.encounter_id.value;
	if (encounter == "" || encounter == null) {
		encounter == "";
	} else {
		encounter = document.formSalesHeader.encounter_id.options[document.formSalesHeader.encounter_id.options.selectedIndex].value;
	}
	
	var formObj = parent.parent.f_query_add_mod.frameSalesDetail.document.formSalesDetail;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkedbox = "";
	for (i = 0; i <= totalCBox - 1; i++) {
		if (eval("formObj.checkbox" + i + ".checked")) {
			checkedbox = checkedbox + "@" + i;
		}
	}

	var retVal = "";
	var dialogHeight = "90vh";
	var dialogWidth = "79vw";
	var dialogTop = "200";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/SalesPreviewDetails.jsp?store_code=" + encodeURIComponent(store_code) + "&doc_type_code=" + encodeURIComponent(doc_type_code) + "&patient_id=" + patient_id + "&patient_name=" + encodeURIComponent(patient_name) + "&encounter=" + encounter+"&checkedbox="+checkedbox;
	retVal =await top.window.showModalDialog(url, arguments, features);
}
// Ends of Tuesday, August 03, 2004
async function callOTSalesWindow() {
/*function callOTSalesWindow(pat_id, encounter, store_code, patient_class) {
	if (pat_id == undefined || pat_id == null || pat_id == "" || pat_id == "null") {
		return;
	}
	if (encounter == undefined || encounter == null || encounter == "" || encounter == "null") {
		return;
	}
	if (store_code == undefined || store_code == null || store_code == "" || store_code == "null") {
		return;
	}
	if (patient_class == undefined || patient_class == null || patient_class == "" || patient_class == "null") {
		return;
	}
	var sal_trn_type = "I";
	if (patient_class == "IP") {
		sal_trn_type = "I";
	}
	if (patient_class == "OP") {
		sal_trn_type = "O";
	}
	if (patient_class == "EM") {
		sal_trn_type = "E";
	}
	if (patient_class == "DC") {
		sal_trn_type = "D";
	}
	var pat_id = pat_id;
	var encounter = encounter;
	var store_code = store_code;
	/*var pat_id = "CS00000010";
	var encounter = "10003864";
	var store_code = "PHINPS";
	var patient_class = "IP";
	var sal_trn_type = "I";*/

	/*var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlStr = "<root><SEARCH ";
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?store_code=" + store_code + "&patient_class=" + patient_class + "&sal_trn_type=" + sal_trn_type + "&validate=STORE_STATUS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		return;
	}*/
	var retVal = "";
	var dialogHeight = "40vh";
	var dialogWidth = "65vw";
	var dialogTop = "200";
	var center = "1";
	var status = "no";
	var tit = "Mahesh Sales";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ "; title :" + tit;
	var arguments = "";
	var url = "../../eST/jsp/Sales.jsp?mode=" + MODE_INSERT + "&function_id=ST_SALES&module_id=OT&tit="+tit;//&patient_id=" + pat_id + "&encounter=" + encounter + "&store_code=" + store_code + "&sal_trn_type=" + sal_trn_type;
//CS00000010 10003864	
	retVal =await window.showModalDialog(url, arguments, features);
}
function clseWindow() {
	window.close();
}
function applyforot() {
	var formObj = parent.frameSalesForOT.frameSalesDetail.document.formSalesDetail;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	for (i = 0; i < totalCBox; i++) {
		checkBoxObj = eval("formObj.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	if (noDetailExists) {
		parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	for (i = 0; i < parent.frameSalesForOT.frameSalesDetail.document.formSalesDetail.total_checkboxes.value; i++) {
		if ((eval("parent.frameSalesForOT.frameSalesDetail.document.formSalesDetail.checkbox" + i).checked)) {
		} else {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=ZERO_QUANTITY&index=" + i, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (!result) {
				parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("ISS_QTY_CANNOT_BE_ZERO", "ST");
				return;
			}
		}
	}
	var formObj = parent.frameSalesForOT.frameSalesHeader.document.formSalesHeader;
	if (formObj.discharge_yn.checked == true) {
		formObj.discharge_yn.value = "Y";
	} else {
		formObj.discharge_yn.value = "N";
	}
	if (formObj.chargeable_yn.checked == true) {
		formObj.chargeable_yn.value = "Y";
	} else {
		formObj.chargeable_yn.value = "N";
	}
	if (formObj.patient_id.value == "" || formObj.patient_id.value == null) {
		formObj.patient_id.value = formObj.patient_id_ot.value;
	}
	if (formObj.encounter_id.value == "" || formObj.patient_id.value == null) {
		formObj.encounter_id.value = formObj.encounter_ot.value;
	}
///
	var arrayObject = new Array(formObj.patient_id);
	var names = new Array(getLabel("Common.patientId.label", "Common"));
	if (formObj.sal_trn_type.value != "R" && formObj.encounter_ot.value == "") {
		arrayObject[1] = formObj.encounter_id;
		names[1] = getLabel("Common.encounterid.label", "Common");
	}
	var blankObject = checkSTFields(arrayObject, names, parent.messageFrame);
	if (blankObject == true) {
	
///
		forDeletion = forDeletion.substring(0, forDeletion.length - 1);
		formObj.records_to_delete.value = forDeletion;
		formObj.finalized_yn.value = "Y";
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		flag1 = (flag.split("~"))[0];
		flag2 = (flag.split("~"))[1];
		flag1 = (flag1 == "null" ? "" : flag1);
		if (result) {
			message = message.substring(0, message.indexOf("<"));
			alert(message + "\n" + flag1);
			clseWindow();
			//parent.messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ flag1;
		} else {
			parent.messageFrame.location.href = errorPage + "?err_num=" + message;
		}
		if (result) {
			parent.frameSalesForOT.frameSalesDetail.location.href = "../../eST/jsp/SalesDetail.jsp?function_id=" + function_id;
			//onSuccess();
		} else {
			if (flag != "") {
				parent.messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>";
				parent.frameSalesForOT.frameSalesDetail.location.href = "../../eST/jsp/SalesDetail.jsp?function_id=" + function_id + "&index=" + flag;
			}
		}
	} else {
		//blankObject.focus();
	}
}
function kitGetStatus() {
	var store_code = parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	var formObj = document.formSalesListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&item_qty=" + formObj.item_qty.value + "&validate=GET_STATUS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (!result) {
		if (message == "RECORD_ALREADY_EXISTS") {
			alert(getMessage(message, "ST"));
				//refreshDetails();
				//added for 28565 by Ganga Monday, February 11, 2013
				parent.frameSalesListHeader.location.href = "../../eST/jsp/SalesListHeader.jsp";
				parent.frameSalesListDetail.location.href = "../../eCommon/html/blank.html";
				//added ended 28565
			return;
		}
		//addToList1();
		if(parent.parent.frameSalesHeader.document.formSalesHeader.barcode_applicable1.value=="Y")
		addToListforBarCode1('salesBean','eST.SalesBean','SalesListHeader','SalesListDetail','SalesDetail');
		else
		addToList1();
	}
	if (result) {
		/*			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?item_code="+formObj.item_code.value+"&store_code="+store_code+"&validate=MIN_MAX_STATUS", false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			eval(responseText);*/


		//addToList();//COMMENTED BY GANGA

		if(parent.parent.frameSalesHeader.document.formSalesHeader.barcode_applicable1.value=="Y")
		addToListforBarCode('salesBean','eST.SalesBean',parent.parent.frameSalesHeader.document.formSalesHeader.barcode_applicable1,'SalesListHeader','SalesListDetail','SalesDetail');
		else
		addToList();

	}
}
function kitNextItem() {
	parent.frameSalesList.frameSalesListHeader.kitNextItemValidate();
}
function kitNextItemValidate() {
	var store_code = parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	var patient_id = parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=KIT_TEMPLATE&store_code=" + store_code+"&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function addToList1() {
/*Code added for walk-thru on 3/3/2010*/
	var formObjDtl = parent.parent.frameSalesDetail.document.formSalesDetail;
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	for (i = 0; i < parseInt(formObjDtl.total_checkboxes.value); i++) {
		checkBoxObj = eval("formObjDtl.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	var formObjHdr = parent.parent.frameSalesHeader.document.formSalesHeader;
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObjHdr.records_to_delete.value = forDeletion;
/*Code ended*/
	var formObj = parent.frameSalesListHeader.document.formSalesListHeader;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	var store_code = parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	if (blankObject == true) {
		//alert("3");
		//formObj.apply.disabled = true;	//Commented By Dinesh T on 2/18/2011, as the issue of add button is disbabled, which is not simulatable
		if (parent.frameSalesListDetail.document.formSalesListDetail == null) {
			var formObj = document.formSalesListHeader;
			var _item_code = formObj.item_code.value;
			var item_qty = formObj.item_qty.value;
			parent.frameSalesListDetail.location.href = "../../eST/jsp/SalesListDetail.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&function_id=" + parent.parent.function_id + "&addToList=true&kit=kit";
			return;
		}
		
		//if (formObj.stock_item_yn.value=='Y') {
		var formObjDtl = parent.parent.frameSalesList.frameSalesListDetail.document.formSalesListDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = formObj.item_qty.value;
		/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc -calculate the sum of batch qty and item qty.
	*/
	var no_of_decimals=formObjDtl.no_of_decimals.value;
	
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		var sum = 0;
		for (i = 0; i < _total_checkboxes; i++) {
			var qty = eval("formObjDtl.item_qty_" + i).value;
			if (qty == "") {
				qty = 0;
			}
			if (!isNaN(qty)) {
				sum += parseFloat(qty);
			}
		}
		if(formObjDtl.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		if (formObj.stock_item_yn.value == "Y") {
			//xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		} else {
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		}
		parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" ;
		if (parent.parent.frameSalesHeader.document.formSalesHeader.chargeable_yn.value == "Y" && document.formSalesListHeader.billable_item_yn.value=="Y") {
			if(formObj.bl_override_excl_incl_ind.value!="" ){
			if(formObj.bl_override_excl_incl_ind.value!="S" && formObj.bl_incl_excl_override_reason_code.value==""){
				//parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
				parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("ST_REASON_CODE_NOT_BLANK", "ST");
				formObj.apply.disabled = false;
				return;
			}
			}
			/**
			* @Name - Priya 
			* @Date - 22/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('id_store_item_unit_cost').innerText + "&item_cost_value=" + parent.frameSalesListHeader.document.getElementById('id_item_sal_value').innerText+"&pat_net_amt=" + parent.frameSalesListHeader.document.getElementById('id_payable_amt').innerText+"&gross_charge_amt=" + parent.frameSalesListHeader.document.getElementById('id_charge_amt').innerText  + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8") + "&stock_available=" + document.getElementById('id_stock_available').innerText + "&batch_records=" + formObjDtl.total_checkboxes.value+"&remarks_code="+formObj.remarks_code.value+"&bl_override_excl_incl_ind="+formObj.bl_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_code="+formObj.bl_incl_excl_override_reason_code.value+"&bl_def_override_excl_incl_ind="+formObj.bl_def_override_excl_incl_ind.value+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(formObj.bl_incl_excl_override_reason_desc.value,"UTF-8")+"&bl_override_allowed_yn="+formObj.bl_override_allowed_yn.value+ "&pat_paid_amt=" + parent.frameSalesListHeader.document.getElementById('id_paid_amt').innerText+"&approval_reqd_yn="+formObj.approval_reqd_yn.value+"&decimal_allowedYN="+formObj.decimal_allowedYN.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&records_to_delete="+formObjHdr.records_to_delete.value+ "&billable_item_yn="+document.formSalesListHeader.billable_item_yn.value+"&sale_req_qty="+formObj.sale_req_qty.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);
			/*records_to_delete is added for SRR walk-thru on 3/3/2010*/
		} else {
			/**
			* @Name - Priya 
			* @Date - 22/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?index=" + formObj.index.value + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById('id_store_item_unit_cost').innerText + "&item_cost_value=" + parent.frameSalesListHeader.document.getElementById('id_item_sal_value').innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById('id_uom').innerText,"UTF-8") + "&batch_records=" + formObjDtl.total_checkboxes.value + "&stock_available=" + document.getElementById('id_stock_available').innerText+"&remarks_code="+formObj.remarks_code.value  +"&decimal_allowedYN="+formObj.decimal_allowedYN.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&records_to_delete="+formObjHdr.records_to_delete.value+ "&billable_item_yn="+document.formSalesListHeader.billable_item_yn.value+"&sale_req_qty="+formObj.sale_req_qty.value+"&kit_temp_code="+formObj.kit_temp_code.value+"&usage_type="+formObj.usage_type.value+"&validate=ADD_TO_LIST", false);
			/*records_to_delete is added for SRR walk-thru on 3/3/2010*/
		}
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);

		if (result) {
			parent.parent.frameSalesHeader.formSalesHeader.preview.disabled = false;
			parent.parent.frameSalesDetail.location.href = "../../eST/jsp/SalesDetail.jsp?function_id=" + parent.parent.function_id + "&index=" + formObj.index.value + "&kit12=kit";
			refreshDetail();
		} else {
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + (message);
		}
	} else {
//alert(blankObject);
	}
}
function statusOfItem() {
	var store_code = parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	var patient_id = parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=ERROR_MESSAGE&store_code=" + store_code+"&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
		//alert(responseText);
}
function displayMessage(errorList) {
	var item_store = "";
	var phy_inv = "";
	var non_stock = "";
	var no_stock = "";
	var bl_err = "";
	var insuff_stock = "";
	errorList = errorList.substring(1, errorList.length - 1);
	errorList = errorList.split(",");
	for (var i = 0; i < errorList.length; i++) {
		if (trimString(errorList[i]) == "ITEM_STORE_NOT_FOUND") {
			if (item_store == "") {
				item_store = item_store + " " + trimString(errorList[i + 1]);
			} else {
				item_store = item_store + ", " + trimString(errorList[i + 1]);
			}
		} else {
			if (trimString(errorList[i]) == "PHY_INV_PROCESS_INITIATED") {
				if (phy_inv == "") {
					phy_inv = phy_inv + " " + trimString(errorList[i + 1]);
				} else {
					phy_inv = phy_inv + "," + trimString(errorList[i + 1]);
				}
			} else {
				if (trimString(errorList[i]) == "NOT_STOCK_ITEM") {
					if (non_stock == "") {
						non_stock = non_stock + " " + trimString(errorList[i + 1]);
					} else {
						non_stock = non_stock + "," + trimString(errorList[i + 1]);
					}
				} else {
					if (trimString(errorList[i]) == "STOCK_NOT_AVAILABLE") {
						if (no_stock == "") {
							no_stock = no_stock + " " + trimString(errorList[i + 1]);
						} else {
							no_stock = no_stock + "," + trimString(errorList[i + 1]);
						}
					}
					else {
						if (trimString(errorList[i]) == "BILLING_ERROR") {
							if (bl_err == "") {
								bl_err = bl_err + " " + trimString(errorList[i + 1]);
							} else {
								bl_err = bl_err + "," + trimString(errorList[i + 1]);
							}
						}
					}
				}
				if(trimString(errorList[i]) == "INSUFFICIENT_BATCH_QTY") {
					if (trimString(errorList[i]) == "INSUFFICIENT_BATCH_QTY") {
						if (insuff_stock == "") {
							insuff_stock = insuff_stock + " " + trimString(errorList[i + 1]);
						} else {
							insuff_stock = insuff_stock + "," + trimString(errorList[i + 1]);
						}
					}
				}
			}
		}
	}
	var err_text = "";
	if (item_store != "") {
		err_text = err_text + getMessage("ITEM_STORE_NOT_FOUND", "ST") + " for " + item_store + "\n";
	}
	if (phy_inv != "") {
		err_text = err_text + getMessage("PHY_INV_PROCESS_INITIATED", "ST") + " for " + phy_inv + "\n";
	}
	if (non_stock != "") {
		err_text = err_text + getMessage("NOT_STOCK_ITEM", "ST") + " " + non_stock + "\n";
	}
	if (no_stock != "") {
		err_text = err_text + getMessage("STOCK_NOT_AVAILABLE", "ST") + " " + no_stock + "\n";
	}
	if (bl_err != "") {
		err_text = err_text + "Billing Details Not Setup Properly for " + bl_err + "\n";
	}
	if (insuff_stock != "") {
		err_text = err_text + getMessage("INSUFFICIENT_BATCH_QTY", "ST") + " " + insuff_stock + "\n";
	}
	if (err_text != "") {
		alert(err_text);
	}
}
function checkIntegerFormat(obj, zeroNotAllowed) {
	if (zeroNotAllowed == null) {
		zeroNotAllowed = true;
	}
	//alert("checkIntegerFormat");
	if (obj.value == "") {
		return;
	}
	if (!isValidIntegerFormat(obj)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "PH"));
		obj.focus();
		return false;
	} else {
		if ((parseFloat(obj.value) == 0) && zeroNotAllowed) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
			obj.value = "";
        //obj.focus();
			return false;
		}
	}
	return true;
}
function addList(listObject) {

	var index = document.getElementById('sal_trn_type').selectedIndex;	
	if(document.formSalesHeader.sal_trn_type.value == null || document.formSalesHeader.sal_trn_type.value == "" && index != 0 ){	
	var store_code = document.formSalesHeader.store_code.value;
	//var referral_yn				=		document.formSalesHeader.referral_yn.value;
	//var outpatient_yn			=		document.formSalesHeader.outpatient_yn.value;
	//var Inpatient_yn			=		document.formSalesHeader.Inpatient_yn.value;
	var arrayObject = new Array();
	var bean_id = "SalesBean";
	var bean_name = "eST.SalesBean";
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlStr = getXMLString(arrayObject);
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//xmlDoc.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=SALES_TYPE" + "&store_code=" + store_code, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	}
}
async function searchPatientId(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = document.formSalesHeader.ST_SQL_DIR_SAL_PAT_LOOKUP.value;
	//var sql= "SELECT A.PATIENT_ID CODE, B.PATIENT_NAME DESCRIPTION FROM ST_DIR_SALE_PATIENT_PARAM A, MP_PATIENT B WHERE A.PATIENT_ID LIKE UPPER(?) AND UPPER(B.PATIENT_NAME) LIKE UPPER(?) AND A.EFF_STATUS = 'E' AND A.PATIENT_ID = B.PATIENT_ID";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	var remarks = getLabel("Common.PatientName.label", "Common");
	returnedValues =await CommonLookup(remarks, argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		return true; //added for TBMC-SCF-0014 
		//obj.focus();
		//objDesc.value = returnedValues[1];
	}else{//added for TBMC-SCF-0014

		return false;
	}
}
function CheckStoreSalesType() {
	var store_code = document.formSalesHeader.store_code.value;
	var sal_trn_type = document.formSalesHeader.sal_trn_type.value;
	if (sal_trn_type == "") {
		alert("Sales Type Cannot Be Blank");
		document.formSalesHeader.sal_trn_type.focus();
		return;
	}
	var arrayObject = new Array();
	var bean_id = "SalesBean";
	var bean_name = "eST.SalesBean";
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString(arrayObject);
	//xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CHECK_STORE_SALESTYPE" + "&store_code=" + store_code + "&sal_trn_type=" + sal_trn_type, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
/*function getXMLString(arrayObject) {
	xmlStr ="<root><SEARCH ";
	if (arrayObject!=null)
		for (index=0;index<arrayObject.length;index++)	{
			xmlStr += arrayObject[index].name+"=""+ arrayObject[index].value +"" ";
		}
	xmlStr +=" /></root>";
	return xmlStr;
}
*/
function assignResult(_result, _message, _flag, _invalidCode) 
{
	result = _result;
	message = _message;
	flag = _flag;
	if (_invalidCode == null) {
		_invalidCode = "";
	}
	invalidCode = _invalidCode;
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formSalesListHeader.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formSalesListHeader.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formSalesListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal =await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}

	if ((retVal != null) && (retVal != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}
function calTotalQty() {

	var store_code = document.formSalesListHeader.store_code.value;
	var item_code = document.formSalesListHeader.item_code.value;
	var item_qty = document.formSalesListHeader.item_qty.value;
	if(item_qty!=""){
		var arrayObject = new Array();
		var bean_id = "SalesBean";
		var bean_name = "eST.SalesBean";
		//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString(arrayObject);
		xmlStr = getXMLString(arrayObject);
		var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=TOTAL_QTY" + "&store_code=" + parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value + "&item_code=" + item_code + "&item_qty=" + item_qty+ "&bar_or_item_code=" + document.formSalesListHeader.bar_or_item_code.value, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		/*if( !result ) {
		if(message=="Multiple"){
		alert("Mutilpe uom");
			cancel_me();
			return;
		}
		}	*/
		//alert(responseText);
		eval(responseText);
	}else{
		document.formSalesListHeader.tot_item_qty.value = "";
	}
}
function displayDetails(){
	var formObj = document.formSalesHeader;
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlStr = getXMLString(null);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=DISP_DETAILS&patient_id="+formObj.patient_id.value+"&encounter_id="+formObj.encounter_id.value, false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlDom);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
}
function diss(desc){

var va=decodeURIComponent(desc,"UTF-8");
		var strCheck = new Array("+");
	var lenValue  = strCheck.length;
	for(var i=0;i<lenValue;i++){
		while(va.indexOf(strCheck[i]) != -1 ){
			while(va.indexOf(strCheck[i]) != -1){
				va = va.replace(strCheck[i]," ");
			}
			i++;
		}
	}
	
	document.getElementById('NU_Clinic').innerText =va;
}
//Override Reason Billing Related BY Mahesh on 9/9/2009 Based on Prescription Page.
function assignChargeDetails(bl_total_charge_amt, bl_patient_payable_amt, bl_def_excl_incl_ind, bl_approval_reqd_yn, bl_override_allowed_yn, bl_error_code, bl_sys_message_id, bl_error_text,bl_patient_paid_amt){
	//bl_override_allowed_yn = 'Y';
	
	if(bl_error_code=='' && bl_sys_message_id=='' && bl_error_text ==''){
		var bl_override_excl_incl_ind = bl_def_excl_incl_ind;
		document.getElementById('BL_HEADER').style.display='inline';
		document.getElementById('BL_VALUES').style.display='inline';
		document.formSalesListHeader.bl_override_excl_incl_ind.value = bl_override_excl_incl_ind;
		document.formSalesListHeader.approval_reqd_yn.value = bl_approval_reqd_yn;

		document.getElementById('id_charge_amt').innerHTML = bl_total_charge_amt;
		document.getElementById('id_payable_amt').innerHTML = bl_patient_payable_amt;
		document.getElementById('id_paid_amt').innerHTML = bl_patient_paid_amt;

		document.formSalesListHeader.bl_override_excl_incl_ind.style.display="inline";
		if(bl_approval_reqd_yn=='Y')
			document.getElementById('bl_approval_reqd_yn').innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
		else if(bl_approval_reqd_yn=='N')
			document.getElementById('bl_approval_reqd_yn').innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
		else
			document.getElementById('bl_approval_reqd_yn').innerHTML = "&nbsp" ;

document.formSalesListHeader.bl_override_allowed_yn.value=bl_override_allowed_yn;
		if(document.formSalesListHeader.bl_def_override_excl_incl_ind.value==''){
			document.formSalesListHeader.bl_def_override_excl_incl_ind.value =bl_def_excl_incl_ind;
			//OVERRIDE_EXCL_INCL_YN 
		if(bl_def_excl_incl_ind=='I'){
				document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
			}else{
				document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>";
			}
			if(bl_override_allowed_yn=='I'){
			document.formSalesListHeader.bl_override_excl_incl_ind.options.length = 2;
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].value = 'S';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].text = '-- '+getLabel("Common.defaultSelect.label", "Common")+' --';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[1].value = 'I';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Include.label", "Common");
			document.formSalesListHeader.bl_override_excl_incl_ind.disabled = false;
			document.formSalesListHeader.bl_incl_excl_override_reason_code.value = "";
			document.formSalesListHeader.bl_incl_excl_override_reason_desc.value = "" ;
			document.formSalesListHeader.bl_incl_excl_override_reason_desc.readonly = true ;
					
			}else if(bl_override_allowed_yn=='E'){
			/*	document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
				document.getElementById('bl_override_excl_incl_ind_lbl').innerText = getLabel("Common.Include.label","Common")+"?";
				document.getElementById('bl_overriden_action_reason_img').style.visibility='hidden';
				document.formSalesListHeader.bl_overriden_action_reason_lkp.disabled=true;
				document.formSalesListHeader.bl_override_excl_incl_ind.disabled=true;*/
			document.formSalesListHeader.bl_override_excl_incl_ind.options.length = 2;
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].value = 'S';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].text = '-- '+getLabel("Common.defaultSelect.label", "Common")+' --';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[1].value = 'E';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Exclude.label", "Common");
			document.formSalesListHeader.bl_override_excl_incl_ind.disabled = false;
			document.formSalesListHeader.bl_incl_excl_override_reason_code.value = "";
			document.formSalesListHeader.bl_incl_excl_override_reason_desc.value = "" ;
			document.formSalesListHeader.bl_incl_excl_override_reason_desc.readonly = true ;
			
			}else if(bl_override_allowed_yn=='B'){
			/*	document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
				document.getElementById('bl_override_excl_incl_ind_lbl').innerText = getLabel("Common.Include.label","Common")+"?";
				document.getElementById('bl_overriden_action_reason_img').style.visibility='hidden';
				document.formSalesListHeader.bl_overriden_action_reason_lkp.disabled=true;
				document.formSalesListHeader.bl_override_excl_incl_ind.disabled=true;*/
			document.formSalesListHeader.bl_override_excl_incl_ind.options.length =3;
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].value = 'S';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].text = '-- '+getLabel("Common.defaultSelect.label", "Common")+' --';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[1].value = 'I';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Include.label", "Common");
			document.formSalesListHeader.bl_override_excl_incl_ind.options[2].value = 'E';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[2].text = getLabel("Common.Exclude.label", "Common");
			document.formSalesListHeader.bl_override_excl_incl_ind.disabled = false;
			document.formSalesListHeader.bl_incl_excl_override_reason_code.value = "";
			document.formSalesListHeader.bl_incl_excl_override_reason_desc.value = "" ;
			document.formSalesListHeader.bl_incl_excl_override_reason_desc.readonly = true ;
			
			}else{

			document.formSalesListHeader.bl_override_excl_incl_ind.options.length =1;
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].value = 'S';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].text = '-- '+getLabel("Common.defaultSelect.label", "Common")+' --';
			document.formSalesListHeader.bl_override_excl_incl_ind.options[0].selected =  true;
			document.formSalesListHeader.bl_override_excl_incl_ind.disabled = true;
			document.formSalesListHeader.bl_incl_excl_override_reason_code.value = "";
			document.formSalesListHeader.bl_incl_excl_override_reason_desc.value = "" ;
			document.formSalesListHeader.bl_incl_excl_override_reason_desc.readonly = true ;
			
			}
			/*else{
				document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "--" ;
				document.getElementById('bl_override_excl_incl_ind_lbl').innerText = getLabel("Common.Exclude.label","Common")+"?";
				document.getElementById('td_bl_override_excl_incl_ind').innerHTML ="<input type='checkbox' name='bl_override_excl_incl_ind' id='bl_override_excl_incl_ind' value='' onclick='assignOverrideExclInclInd(this)' style='display:none;'>--" ;
			}*/
		}
	//	if(bl_override_allowed_yn =='Y'){
		//	document.formSalesListHeader.bl_override_excl_incl_ind.disabled=false;
		//	document.formSalesListHeader.bl_override_allowed_yn.value=bl_override_allowed_yn;
		//}

		/*if(bl_override_allowed_yn !='Y'){
		//	document.formSalesListHeader.bl_override_excl_incl_ind.disabled=true;
			document.formSalesListHeader.bl_override_allowed_yn.value=bl_override_allowed_yn;
		}
		else{
			if(document.formSalesListHeader.bl_override_excl_incl_ind.value == ''){
				document.formSalesListHeader.bl_override_excl_incl_ind.value = bl_def_excl_incl_ind;
			}
			bl_override_excl_incl_ind = document.formSalesListHeader.bl_override_excl_incl_ind.value;
		}*/
		// Added for IN:071972 START
		var approval_no_appl_yn=(document.formSalesListHeader.approval_no_appl_yn.value =="Y");// Added for IN:071972
		if((bl_total_charge_amt!=bl_patient_payable_amt)&&approval_no_appl_yn){
			document.getElementById("approvalTd").style.display='inline';
		}else{
			document.getElementById("approvalTd").style.display='none';
		}
		// Added for IN:071972 END
		document.formSalesListHeader.apply.disabled=false;
	}else{
		//alert("5")
		//document.formSalesListHeader.apply.disabled=true;	//Commented By Dinesh T on 2/18/2011, as the issue of add button is disbabled, which is not simulatable
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage(""+bl_sys_message_id,"BL");
		return;
	}
}
function assignChargeDetailsExp(bl_total_charge_amt, bl_patient_payable_amt){
		parent.frameSalesListHeader.document.getElementById('id_charge_amt').innerHTML = bl_total_charge_amt;
		parent.frameSalesListHeader.document.getElementById('id_payable_amt').innerHTML = bl_patient_payable_amt;
}
function assignOverrideExclInclInd(obj){
	var bl_def_override_excl_incl_ind = obj.value;
	document.formSalesListHeader.bl_override_excl_incl_ind.value = bl_def_override_excl_incl_ind;

	if(bl_def_override_excl_incl_ind=='I' ){
	document.getElementById('bl_overriden_action_reason_img').style.visibility='visible';
	document.formSalesListHeader.bl_overriden_action_reason_lkp.disabled=false;
	}else if(bl_def_override_excl_incl_ind=='E' ){
	document.getElementById('bl_overriden_action_reason_img').style.visibility='visible';
	document.formSalesListHeader.bl_overriden_action_reason_lkp.disabled=false;
	}else{
	document.formSalesListHeader.bl_incl_excl_override_reason_code.value = "";
	document.formSalesListHeader.bl_incl_excl_override_reason_desc.value = "" ;
	document.formSalesListHeader.bl_incl_excl_override_reason_desc.readonly = true ;
	document.getElementById('bl_overriden_action_reason_img').style.visibility='hidden';
	document.formSalesListHeader.bl_overriden_action_reason_lkp.disabled=true;
	}
	//else obj.value ="";
	//if(obj.checked == true){
	//	document.getElementById("bl_overriden_action_reason_img").style.visibility='visible';
	//	document.formSalesListHeader.bl_overriden_action_reason_lkp.disabled=false;
	//}
	//else{
	//	document.getElementById("bl_overriden_action_reason_img").style.visibility='hidden';
	//	document.formSalesListHeader.bl_overriden_action_reason_lkp.disabled=true;
	//	document.formSalesListHeader.bl_incl_excl_override_reason_code.value = "";
	//	document.formSalesListHeader.bl_incl_excl_override_reason_desc.value = "" ;
//	}
	//if(obj.value!="I" ){
	chargeDetails();
	//}
}

async function searchBLOverrideReason(){

	var formObj=document.formSalesListHeader;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var sql1 = formObj.sql_ph_prescription_bl_action_select_lookup.value;
	var sql1 = "SELECT  ACTION_REASON_CODE CODE,ACTION_REASON_DESC DESCRIPTION FROM BL_ACTION_REASON_LANG A WHERE NVL(STATUS,'!') != 'S'  AND EXISTS (SELECT B.ACTION_TYPE FROM BL_ACTION_TYPE B, BL_ACTION_REASON_BY_TYPE C WHERE B.ACTION_TYPE = C.ACTION_TYPE AND B.ACTION_TYPE = 'OV' AND C.ACTION_REASON_CODE = A.ACTION_REASON_CODE AND C.ACTIVE_YN = 'Y') AND UPPER(A.LANGUAGE_ID) LIKE UPPER(?) AND UPPER(A.ACTION_REASON_CODE) LIKE UPPER(?) AND UPPER(A.ACTION_REASON_DESC) LIKE UPPER(?)";

	dataNameArray[0]	="a.language_id";
	dataValueArray[0]	=formObj.lang_id.value;
	dataTypeArray[0]	=STRING;

	argumentArray[0]	= sql1;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = formObj.bl_incl_excl_override_reason_desc.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal =await CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
	if(retVal != null && retVal != "") {
		document.formSalesListHeader.bl_incl_excl_override_reason_code.value = retVal[0];
		document.formSalesListHeader.bl_incl_excl_override_reason_desc.value =retVal[1] ;
		chargeDetails();
	}
}

function chargeDetails(){
	//alert("chargeDetails");
	//var xmlDoc="";
	var patient_id = parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;
	
	var formObj = document.formSalesListHeader;

	if(document.formSalesListHeader.bl_def_override_excl_incl_ind.value=="")
	formObj.bl_override_excl_incl_ind.value="";
	if ((formObj.item_qty.value) != "") {
		calTotalQty();
/*	var formObj = document.formSalesListDetail;
	//var formObjHdr = parent.frameSalesListHeader.document.formSalesListHeader;
	//var batch_string = "";
	//var tot_item_qty = 0;
	//for(var i=0;i<formObj.total_checkboxes.value;i++){
	//	if ((eval("formObj.item_qty_"+i).value) != ""){
			batch_string = batch_string + eval("formObj.trade_id_"+i).value;
			batch_string = batch_string + ";";
			batch_string = batch_string + eval("formObj.batch_id_"+i).value;
			batch_string = batch_string + ";";
			batch_string = batch_string + eval("formObj.expiry_date_or_receipt_date_"+i).value;
			batch_string = batch_string + ";";
			batch_string = batch_string + eval("formObj.bin_location_code_"+i).value;
			batch_string = batch_string + ";";
			batch_string = batch_string + eval("formObj.item_qty_"+i).value;
			batch_string = batch_string + ";";
			tot_item_qty = tot_item_qty + eval(eval("formObj.item_qty_"+i).value);
		}
	}*/
	//alert(batch_string);	


//alert("====2049==="+formObj.tot_item_qty.value);
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
	    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?item_code=" + formObj.item_code.value+ "&tot_item_qty="+ formObj.tot_item_qty.value + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id+"&bl_override_excl_incl_ind="+formObj.bl_override_excl_incl_ind.value+ "&validate=ASSIGN_OVERRIDE&bl_overriden_action_reason="+formObj.bl_incl_excl_override_reason_code.value, false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
	//	alert(responseText);
		eval(responseText);
	}
	chargeDetailsExp(formObj.item_code.value,formObj.tot_item_qty.value);   
	//commented for the inci 27295 on 6/24/2011 by ganga
	//uncommented for KDAH Batch price
	
}
function chargeDetailsExp(item_code,qty){
	//alert("chargeDetailsExp");
	var patient_id = parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;
	var formObj = document.formSalesListDetail;
	if(formObj==undefined)
	formObj=parent.frameSalesListDetail.document.formSalesListDetail;
	var formObjHdr = parent.frameSalesListHeader.document.formSalesListHeader;
	var batch_string = "";
	var tot_item_qty = 0;
	if(formObj){
	for(var i=0;i<formObj.total_checkboxes.value;i++){
		if ((eval("formObj.item_qty_"+i).value) != ""){
			batch_string = batch_string + eval("formObj.trade_id_"+i).value;
			batch_string = batch_string + ";";
			batch_string = batch_string + eval("formObj.batch_id_"+i).value;
			batch_string = batch_string + ";";
			batch_string = batch_string + eval("formObj.expiry_date_or_receipt_date_"+i).value;
			batch_string = batch_string + ";";
			batch_string = batch_string + eval("formObj.bin_location_code_"+i).value;
			batch_string = batch_string + ";";
			batch_string = batch_string + eval("formObj.item_qty_"+i).value;
			batch_string = batch_string + ";";
			tot_item_qty = tot_item_qty + eval(eval("formObj.item_qty_"+i).value);
		}
	}
	
}else{
tot_item_qty=qty;
}
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
    //xmlDoc.loadXML(getXMLString(null));
    xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?item_code=" + item_code+ "&tot_item_qty="+ tot_item_qty + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id+"&bl_override_excl_incl_ind="+formObjHdr.bl_override_excl_incl_ind.value+ "&validate=ASSIGN_OVERRIDE&bl_overriden_action_reason="+formObjHdr.bl_incl_excl_override_reason_code.value+"&batch_string="+batch_string, false);
	xmlHttp.send(xmlDoc);
	var	responseText = xmlHttp.responseText;
	responseText = trimString(responseText); 
	eval(responseText);
}
//Mahesh Code Ends


function callCashCounterProcedure(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var sal_trn_type = parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;
	var chargeable_yn = parent.frameSalesHeader.document.formSalesHeader.chargeable_yn.value;
	if (sal_trn_type != "" && (sal_trn_type == "O" || sal_trn_type == "E") && chargeable_yn =="Y") {
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?sal_trn_type="+sal_trn_type+ "&validate=BILLING_CASH_COUNTER", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//alert(responseText);
		eval(responseText);
		if(result==false){
		  alert(getMessage('BL1023','BL'));
		  parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value="";
		  //parent.location.href ='../../eCommon/jsp/dmenu.jsp';
		  return;
		}
	}

}
/**
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
function clearMessageFrame(){
var errorPage = "../../eCommon/jsp/error.jsp";
parent.messageFrame.location.href = errorPage + "?err_num=";
}
/**
 * @Name - krishna
 * @Date - 23/01/2010
 * @Inc# - 
 * @Desc - Sales  Preview Details - web page showing wrongly   
			 
 */
function disabledPreviwButton(obj,i){
	/*Coded added for SRR walk-thru on 3/4/2010*/
	if(obj!=undefined){
		if(obj!=null && obj.checked){
		//commented by Rabbani #Inc no: 35383 on 25/09/12
			/*eval("document.getElementById("font_")"+i).style.color='black';
			eval("document.getElementById("font_")"+i).onclick='';
			eval("document.getElementById("td_")"+i).style.cursor='';
			eval("document.getElementById("td_")"+i).onmouseover='';*/
		}else{
			eval(document.getElementById('font_'+i)).style.color='blue';
			eval(document.getElementById('td_'+i)).style.cursor='hand';
			eval(document.getElementById('font_'+i)).onclick=new Function("modifyData('"+i+"');disabledPreviwButton()");//"modifyData('"+i+"');disabledPreviwButton();";
		}
	}
	/*Code ended*/
	var count = 0;
	var totalCBox=document.formSalesDetail.total_checkboxes.value;
	for (i = 0; i <= totalCBox - 1; i++) {
		if (eval("document.formSalesDetail.checkbox" + i + ".checked")) {
			count=count+1;
		}
	}
	if(eval(count)==eval(totalCBox)){
	parent.frameSalesHeader.document.formSalesHeader.preview.disabled=true;
	}else{
		parent.frameSalesHeader.document.formSalesHeader.preview.disabled=false;
	}

}

function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.'()";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
	return false;
	}  
	return true;
}
function CheckForSpecialCharsBlur(obj) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.'() ";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
	alert( getMessage("CANNOT_BE_SPECIAL_CHAR", "COMMON"));
	return false;
	}  
	return true;
}
/*added for KDAH-CRF-0432.1 removed
function enablefin()
{
	if(document.getElementById('ModifyFin_Details').style!=undefined)
	{
		//alert(document.getElementById('patient_id').value);
		if(document.getElementById('patient_id').value!=""){
		document.getElementById('ModifyFin_Details').disabled=false;
		document.getElementById('ModifyFin_Details').setAttribute('href','javascript:findtl()');}
	}
}//end KDAH-CRF-0432 */

function CheckForSpecialCharsPatient(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.'() ";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
	return false;
	}  
	return true;
}

async function searchPractitioner(objCode,objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formSalesHeader.language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = "SELECT practitioner_id code, PRACTITIONER_NAME description FROM  am_practitioner_lang_vw WHERE eff_status = 'E' AND language_id LIKE ? AND UPPER (PRACTITIONER_NAME) LIKE UPPER (?) AND UPPER (practitioner_id) LIKE UPPER (?) and pract_type IN('MD','SG','DN','PL','AN','PS','TH','RD','PT') ORDER BY 2 ";//MODIFIED FOR GHL-SCF-1369
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,2";
	//argumentArray[5] = "";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(getLabel("Common.practitionername.label", "Common"), argumentArray);
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(arr[1]==undefined) 
	{
		arr[0]="";	
		arr[1]="";	
	}				
	if ((retVal != null) && (retVal != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
	else
	{
		objCode.value = arr[0];
		objDesc.value = arr[1];

	}
}

function searchPractitioner1(objCode,objDesc)
{
   if(document.formSalesHeader.sal_trn_type.value!='X')
	{
		if(objCode.value!=""||objDesc.value!="")
		{
			searchPractitioner(objCode,objDesc)
		}
			else
		{
			objCode.value = "";
			objDesc.value = "";
		}
	}
}

function defaultEncounter()
{
	//if(document.formSalesHeader.all.encounter_id.length > 1)
	if(document.getElementById('encounter_id').length > 1)
	{
		//document.formSalesHeader.all.encounter_id.selectedIndex =1;
		document.getElementById('encounter_id').selectedIndex =1;
		callBillingHdrProcedure();
		displayDetails();
	}
}

function frmdate(){
   var from_date    =  document.formSalesQueryCriteria.doc_date.value ;
   var to_doc_date =  document.formSalesQueryCriteria.to_doc_date.value ;
   if(from_date==""){
   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
   document.formSalesQueryCriteria.doc_date.focus();
   return ;
   }
   else{
	   if (to_doc_date=="")
	   {
	   document.formSalesQueryCriteria.submit();
	   }
	   else if(!isBefore(from_date,to_doc_date,"DMY",document.forms[0].language_id.value)) {
        alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
		document.formSalesQueryCriteria.doc_date.focus();
		return ;
	   }
	   else
	   {
       document.formSalesQueryCriteria.submit();
	   }
   }
}





//barcode
async function callItemValProcedure(item_code,store_code,batch_id,expiry_date,jsp_page){

		if (parent.parent.frameSalesHeader.document.formSalesHeader.chargeable_yn.value == "Y" ) {
					parent.parent.parent.messageFrame.location.href = "../../eCommon/html/blank.html";
					var formObj = document.formSalesListHeader;
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					var patient_id = parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.value;
					var encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.value;
					if (encounter_id == "" || encounter_id == null) {
						encounter_id = parent.parent.frameSalesHeader.document.formSalesHeader.encounter_ot.value;
					}
					var sal_trn_type = parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.value;
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?item_code=" + item_code + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&jsp_page=" + jsp_page + "&validate=ITEMVAD_PROCEDURE", false);
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					eval(responseText);
					if (!result) {
						//parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + (message);
						parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
						return false;
					}
					
					
					parent.parent.frameSalesHeader.document.formSalesHeader.encounter_id.disabled = true;
					parent.parent.frameSalesHeader.document.formSalesHeader.sal_trn_type.disabled = true;
					parent.parent.frameSalesHeader.document.formSalesHeader.patient_id.disabled = true;
					parent.parent.frameSalesHeader.document.formSalesHeader.search_id.disabled = true;
					document.formSalesListHeader.item_qty.value="";
					document.formSalesListHeader.tot_item_qty.value="";
					document.getElementById('id_charge_amt').innerText="";
					document.getElementById('id_payable_amt').innerText="";
					parent.parent.frameSalesList.frameSalesListDetail.location.href = "../../eCommon/html/blank.html";					
					document.formSalesListHeader.item_qty.focus();
					if (result) {
						if (result && message.length > 1) {
							var retVal = "";
							var dialogHeight = "75vh";
							var dialogWidth = "75vw";
							var dialogTop = "250";
							var center = "1";
							var status = "no";
							var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
							var arguments = "";
							var url = "../../eST/html/SalesBillingAuthorize.html";
							retVal =await window.showModalDialog(url, arguments, features);
							if (retVal == YES) {
							} else {
								document.formSalesHeader.item_code.value = "";
								document.formSalesHeader.item_desc.value = "";
							}
						}
					} else {
						parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
					}
				} 
		return result;
}

/*function editViewBatchForBarCode(bar_code,selected_batch_id,selected_expiry_date) {

	var formObj = document.formSalesListHeader;
	var store_code = parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	if (parent.frameSalesListDetail.document.formSalesListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}	
		//formObj.bar_code.value = bar_code;
		var _item_code = formObj.item_code.value;
		var item_qty = "";

		//parent.frameSalesListDetail.location.href = "../../eST/jsp/SalesListDetail.jsp?function=barcode&store_code=" + store_code + "&item_code=" + _item_code + "&expiry_yn=" + formObj.expiry_yn.value + "&item_qty=" + item_qty+ "&bar_code=" + bar_code + "&index=" + formObj.index.value + "&batch_id=" + selected_batch_id + "&expiry_date=" + selected_expiry_date;

		parent.frameSalesListDetail.location.href = "../../eST/jsp/SalesListDetail.jsp?function=barcode&store_code=" + store_code + "&item_code=" + _item_code + "&expiry_yn=" + formObj.expiry_yn.value + "&item_qty=" + item_qty+ "&index=" + formObj.index.value + "&batch_id=" + selected_batch_id + "&expiry_date=" + selected_expiry_date;
}*/

function setStockDetailsforBarCode(_stock_item_yn, _store_item_unit_cost, _available_stock , _billable_item_yn) {
	document.formSalesListHeader.stock_item_yn.value = _stock_item_yn;
	if (_stock_item_yn == "Y") {
		
		document.formSalesListHeader.billable_item_yn.value = _billable_item_yn ;  //added for barcode
		document.getElementById('id_store_item_unit_cost').innerText      = _store_item_unit_cost;

		if(document.formSalesListHeader.dec_allowed_yn.value=="Y"){
			document.getElementById('id_stock_available').innerText =parseFloat(_available_stock). toFixed(document.formSalesListHeader.no_of_decimals.value);
		}else{
			document.getElementById('id_stock_available').innerText = parseFloat(_available_stock).toFixed(0);
		}
	} 
}

async function searchNursingUnit(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "language_id";
	dataValueArray[0]= localeName;
	dataTypeArray[0] = STRING;

	argumentArray[0] = "SELECT  code , description FROM (SELECT nursing_unit_code code, short_desc description,language_id  FROM ip_nursing_unit_lang_vw UNION SELECT clinic_code code, short_desc description,language_id   FROM op_clinic_lang_vw ) WHERE language_id LIKE (?) AND  upper(code) LIKE  upper(?) AND upper(description)  LIKE  upper(?)";

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.formSalesQueryCriteria.nursing_unit_desc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("eST.nursingunit/clinic.label", "eST"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.formSalesQueryCriteria.nursing_unit_code.value = returnedValues[0];
	}
	else{
		obj.value ="";
		document.formSalesQueryCriteria.nursing_unit_code.value ="";
	}
}

function NursingUnitList(){
	var formObj = document.formSalesQueryCriteria;
	var fromdate = formObj.doc_date.value;
	var todate = formObj.to_doc_date.value;
	if (formObj.nursing_unit_code != undefined) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=NURSING_UNIT_LIST&fromdate=" + fromdate +"&todate=" + todate, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}
function chkstatus(obj){
        var usage_type = "";
		if ((eval("document.formSalesDetail.checkbox" + obj).checked)){
			usage_type = "P";
		}else{
			usage_type = "O";
		}
		    var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
            //var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		    var xmlHttp = new XMLHttpRequest();
	        //var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?usage_type="+usage_type+"&index_="+obj+"&BARCODE_YN="+document.getElementById("BARCODE_YN").value+"&validate=USAGE_TYPE_STATUS", false);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(xmlDoc);
			var responseText = xmlHttp.responseText;
			responseText = trimString(responseText); 
			eval(responseText);	
}
//Added by suresh r  14-11-2013 against JD-CRF-156 beg
function callDispCurrEncFinDtlVal(){
	var formObj = document.formSalesHeader;
	var patient_id=formObj.patient_id.value;
	var encounter_id=formObj.encounter_id.value;
	var store_code=formObj.store_code.value;
	var pat_class=formObj.patient_classcode.value;
	var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
    //var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?patient_id=" + patient_id + "&validate=VAL_DISPFINDTL&encounter_id=" +encounter_id+"&pat_class="+pat_class+"&store_code=" + store_code+"&val_flag=1" , false); 
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText); 
	eval(responseText);
}
//Added by suresh r  14-11-2013 against JD-CRF-156 end

//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014  Starts
async function request(){
	
						    var dialogHeight= "50vh" ;
							var dialogWidth	= "80vw" ;
							var dialogTop = "50" ;
							//var dialogLeft = "200"; 
							var center = "1" ;
							var status="no";
							var function_id="ST_REQUEST";
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
							var arguments	= "" ;
							var function_name = "Create/Review Request";	 
							
					var retVal = await window.showModalDialog("../../eST/jsp/Request.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&function_name="+function_name+"&function_type=F"+"&home_required_yn=N"+"&access=NYNNN"+"&store_code="+parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value+"&sales_req_yn=Y",arguments,features);
					chk_req_flag = "true";
					restoreToolbar();
	}

function restoreToolbar(){

    if(chk_req_flag == "true"){
	var bean_id = "SalesBean";
	var bean_name = "eST.SalesBean";
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
    xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=toolBar&"+toolBarString,false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	//alert(xmlHttp.responseText);
	return true;
	}
}
//Added for GHL-CRF-0413 starts
function toConvFactor(){
	var formObj	=	document.formSalesHeader;
	var item_code="";
	if(formObj==null){
		formObj=parent.parent.frames[2].frames[0].document.formSalesHeader;
		var store_code=parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	}else{
		var store_code=parent.parent.frameSalesHeader.document.formSalesHeader.store_code.value;
	}
	if(parent.frameSalesListHeader!=null){
		var formObj1	=	parent.frameSalesListHeader.document.formSalesListHeader;
		item_code		=	formObj1.item_code.value;
	}
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
    //xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=setToConv"+"&store_code="+store_code+"&item_code="+item_code, false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	responseText = trimString(responseText); 
	eval(responseText);
}
function setTempConvFactor(tmp){
	var tmp_conv=1.0;
	if(document.formSalesListHeader==null){
		parent.parent.frameSalesListHeader.document.formSalesListHeader.tmp_conv.value = tmp;
	}
	else{
		document.formSalesListHeader.tmp_conv.value = tmp;	
	}
}
function callItemQtyUpdate(){
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1;
	var barcode = document.forms[0].barcode;
	/*Added by Shazana for INC065695 */
	if(parent.frames[1].document.forms[0]!=null || parent.frames[1].document.forms[0]!=undefined)/*added for Script error*/
	var tmp_conv= parent.frames[1].document.forms[0].tmp_conv.value;
	/*//Added by Shazana for INC065695*/
	if(bar_appl.value=='Y' && document.forms[0].item_code.value!=null){
	if(Obj.value==1 && parent.parent.frames[0].document.forms[0].editqty_appl1.value != 'Y' &&  document.forms[0].bar_or_item_code.value == 'B' ){
		if (parent.frames[1].document.forms[0] != undefined) {
			var index = parent.frames[1].document.forms[0].total_checkboxes.value ;	
				if(parent.frames[0].document.forms[0].noofbatchesforbarcode.value=="1"){
					if(parent.frames[0].document.forms[0].iss_uom_qty!=undefined){
						parent.frames[0].document.forms[0].iss_uom_qty.value = Obj.value;
					}
					if(parent.frames[0].document.forms[0].item_qty.value >Obj.value){
						if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
							parent.frames[0].document.forms[0].tot_item_qty.value = parent.frames[0].document.forms[0].item_qty.value*tmp_conv;//added tmp_conv by Shazana for INC065695
							//alert("parent.frames[0].document.forms[0].tot_item_qty.value: "+parent.frames[0].document.forms[0].tot_item_qty.value*tmp_conv);
							}else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								parent.frames[0].document.forms[0].ret_qty.value= parent.frames[0].document.forms[0].item_qty.value;
							}
						if (parseInt(index)==1){
							parent.frames[1].document.forms[0].item_qty_0.value = parent.frames[0].document.forms[0].tot_item_qty.value;//Modified for IN073577
							//Added for IN071167 START
							if (parseFloat(parent.frames[1].document.forms[0].available_qty_0.value) < parseFloat(parent.frames[0].document.forms[0].item_qty.value*tmp_conv)) {//Modified for IN073577
								alert(getMessage("BATCH_QTY_NOT_GRT_AVLQTY", "ST"));
								parent.frames[0].document.forms[0].item_qty.value="";
								parent.frames[1].document.forms[0].item_qty_0.value="";
								parent.frames[0].document.forms[0].item_qty.focus();
							}
							//Added for IN071167 END
						}else{
						}
					}
					else{
						parent.frames[0].document.forms[0].item_qty.value = Obj.value;
						if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
							parent.frames[0].document.forms[0].tot_item_qty.value = Obj.value*tmp_conv;//Modified for IN073577
							}else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
								parent.frames[0].document.forms[0].ret_qty.value= Obj.value;
							}
						if (parseInt(index)==1){
							parent.frames[1].document.forms[0].item_qty_0.value = Obj.value*tmp_conv;//added by Shazana for INC065695
						}else{
						}
					}
					var tot_item_qty = document.forms[0].tot_item_qty.value ;
					chargeDetailsExp(document.forms[0].item_code.value,tot_item_qty); 
				}
		}
	}
	else if(document.forms[0].item_qty.value>0){
		if (parent.frames[1].document.forms[0] != undefined) {
		var index = parent.frames[1].document.forms[0].total_checkboxes.value ;		
		if (parseInt(index)==1 ){			
			var item_qty_new = document.forms[0].item_qty;
			var tot_item_qty_new = document.forms[0].tot_item_qty;//Added for IN073577
			parent.frames[1].document.forms[0].item_qty_0.value = document.forms[0].tot_item_qty.value;//Modified for IN073577
			var avail_qty = parent.frames[1].document.forms[0].available_qty_0.value ;
			var dec_allowed_yn = parent.frames[1].document.forms[0].dec_allowed_yn.value ;			
			var qty_val = checkBatchQtyforBarcode(item_qty_new,tot_item_qty_new,avail_qty,dec_allowed_yn);//Modified for IN073577
			var tot_item_qty;
			if(document.forms[0].tot_item_qty!=undefined)
			var tot_item_qty = document.forms[0].tot_item_qty.value ;
			else
			var tot_item_qty = document.forms[0].ret_qty.value;
			if(qty_val)
			chargeDetailsExp(document.forms[0].item_code.value,tot_item_qty); 
		}
		}else{
		}
	}
	}
}
function callBarCodeBatchSearchforBarcode(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0){
		//Added against IN:062328 starts
		var search_string = "";
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		if (!parent.frameSalesListHeader.formSalesListHeader.item_desc.readOnly) {
			search_string = parent.frameSalesListHeader.formSalesListHeader.item_desc.value;
		}
		var formObjHeader = parent.parent.frameSalesHeader.document.formSalesHeader;
		if (formObjHeader.patient_id.value == "" || formObjHeader.patient_id.value == null) {
			formObjHeader.patient_id.value = formObjHeader.patient_id_ot.value;
		}
		if (formObjHeader.encounter_id.value == "" || formObjHeader.encounter_id.value == null) {
			formObjHeader.encounter_id.value = formObjHeader.encounter_ot.value;
		}
		var arrayObject = new Array(formObjHeader.patient_id);
		var names = new Array(getLabel("Common.patientId.label", "Common"));
		var x = 0;
		if ((formObjHeader.sal_trn_type.value != "R") && (formObjHeader.encounter_ot.value == "") && (formObjHeader.sal_trn_type.value != "X")) {
			arrayObject[++x] = formObjHeader.encounter_id;
			names[x] = getLabel("Common.encounterid.label", "Common");
		}
		if (formObjHeader.sal_trn_type.value == "X") {
			arrayObject[++x] = formObjHeader.patient_name;
			names[x] = getLabel("Common.PatientName.label", "Common");
		}
		var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject != true) {
	}
	else{
		//Added against IN:062328  ends
	parent.frames[0].document.forms[0].barcode.disabled = true;
	var bar_code	= barcode.value;
	var trn_type	= trntype.value;
	var fromStore   = fromStore.value;
	var toStore		= toStore.value;
	var formObj		= formObj.name; 
	var barcode_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var site = parent.frames[0].document.forms[0].site.value;
	var resultArray	;	
	if (barcode_appl=="Y" && bar_code!=""){
	if (toStore==undefined)
		toStore="";
	var frombarcode ="";
	if( parent.frames[0].document.forms[0].barcode != undefined){
		if(parent.frames[0].document.forms[0].barcode.value != "" )
		 frombarcode = "Y";
	}
	//var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
	//var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail + "&site=" + site +"&frombarcode="+frombarcode+ "&validate=BARCODE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(result){
		if (document.forms[0].bar_or_item_code.value == 'B'){
		 resultArray = message.split(";");
		 var  item_code   = 	resultArray[0];
		 var  batch_id    = 	resultArray[1];
		 var  expiry_date = 	resultArray[2];	
		 var  BarcodeWithMultipleBatches = resultArray[3];	
		 var bill_linked = callItemValProcedure(item_code,fromStore,batch_id,expiry_date,ListDetail,bean_id,bean_name);
		 if (bill_linked)
		 {
			 var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=BarcodeWithMultipleBatches_yn"+"&store_code="+store_code+"&item_code="+item_code+"&BarcodeWithMultipleBatches_yn=" + BarcodeWithMultipleBatches + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
				xmlHttp.send(xmlDoc);
				var responseText=xmlHttp.responseText;
				eval(responseText);
				var qtyList=[] ;
				if(result)
						editViewBatchForBarCode1(ListDetail,fromStore,bar_code,BarcodeWithMultipleBatches,qtyList,trn_type);
				else
						callBatchSearchforBarcodeMultiBatch1(fromStore,bar_code,ListDetail,BarcodeWithMultipleBatches,qtyList);
					if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
						setTimeout('CheckQuantity(document.forms[0].item_qty)',200);
						setTimeout('calTotalQty();',200);
						setTimeout('chargeDetailsExp(document.forms[0].item_code.value);',200);
						 parent.frames[0].document.forms[0].barcode.disabled = false;
						 parent.frames[0].document.forms[0].barcode.value = "";
						 parent.frames[0].document.forms[0].barcode.focus();
					}
		}
		else{
		 		alert(getMessage("EFFECTIVE_RATE_NOT_AVAILABLE", "ST"));
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
		}
		}	
		else{
	 		alert(getMessage("PH_INVALID_BAR_CODE", "PH"));
			refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
	}
		}
	else
		{
		if(getMessage(message, "ST") != ""){
			alert(getMessage(message, "ST"));
			refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
		}else
			{
			alert(message);
			refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
	}
		}
	}
	else
	 {	
	    parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	
		if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
				return;
		} else {
			if(getMessage(message, "ST") != ""){
				alert(getMessage(message, "ST"));
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
			else{
				alert(message);
				refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			}
			}
		}
	 }
	}
}

//Added for GHL-CRF-0413 ends

//Added by Shazana For BARCODE decoding MMS-DM-CRF-0112
function setItemDescription(formname,item_desc){
	document.formSalesListHeader.item_desc.value=decodeURIComponent(item_desc,"UTF-8");
	
} 

//Added for IN:071972 start
function KeyPressSpecCharsAprovalno(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#%^*()';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	return true ;
  
}
function CheckForSpecCharAprovalno(Obj){
		
        var str = Obj.value;
       
        //alert(str.value);
        var strvalidate = "";
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==33)||(str.charCodeAt(u)==64)||(str.charCodeAt(u)==35)||(str.charCodeAt(u)==37)||(str.charCodeAt(u)==94)||(str.charCodeAt(u)==42)||(str.charCodeAt(u)==40)||(str.charCodeAt(u)==41)){//To allow only !,@,#,%,^,*,(,) special characters
            	//alert(str.charAt(u));
            	strvalidate=strvalidate+str.charAt(u);
            }
		}
       
        document.formSalesListHeader.approval_number.value = strvalidate;
    }
function dissableApprovalNo(){
	document.getElementById("approvalTd").style.display='none';
}
//Added for IN:071972 end
//Added for IN:072096 start
function batchUonMultiples(obj, uom,mode) {
	
	var tmp_conv=Math.floor(parent.frameSalesListHeader.document.formSalesListHeader.tmp_conv.value);
	var index=parent.frameSalesListHeader.document.formSalesListHeader.index.value;
	if(index=="-1"){
		var factor=uom;
	}
	else{
		var factor=tmp_conv;
	}
	if(obj.value!=0 && obj.value!=null && obj.value!=undefined ){
	var remin=parseFloat(obj.value)%parseFloat(factor)
			if (!(remin==0)) {
				alert(getMessage("BATCH_QTY_MULTIPLE_STORE_UOM", "ST")+" "+ factor);
				obj.value="";
				obj.focus();
			}
	}
}
//Added for IN:072096 end
//Added for IN073577 start
function checkBatchQtyforBarcode(obj1,obj, available_qty,dec_allowed_yn) {
	var ret = true;
	if(dec_allowed_yn=="Y"){
		if (!checkDoubleFormat(eval(obj))) {  
			ret = false;
			return false;
		}
	}else{
		if (!checkIntegerFormat(eval(obj))) {  
			ret = false;
			return false;
		}
	}
		if (parseFloat(available_qty) < parseFloat(obj.value)) {
			alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
			ret = false;
			obj1.value="";
			obj1.focus();
		}
	return ret;
}
//Added for IN073577 start

