/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001
15/7/2021	TFS:20815			Shazana									ML-MMOH-SCF-1852 			
--------------------------------------------------------------------------------------------------------------------------------
 */ 


var xmlDom;
var xmlHttp;
var finalizeType;

function create(){
	f_query_add_mod.location.href="../../eSS/jsp/InstrUsageDiscrepancyUnitsFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function reset() {	
	f_query_add_mod.location.reload();
}

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}


function apply() {
	
	var totalCBox=parseInt(top.content.f_query_add_mod.frameInstrUsageDiscrepancyUnitsList.document.formInstrUsageDiscrepancyUnitsList.total_checkboxes.value);
	var checkBoxObj=null;
		var errorPage	=	"../../eCommon/jsp/error.jsp";
		var noDetailExists=true;
	var forDeletion=""
	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameInstrUsageDiscrepancyUnitsList.document.formInstrUsageDiscrepancyUnitsList.total_checkboxes"+i);
		if(f_query_add_mod.frameInstrUsageDiscrepancyUnitsList.document.formInstrUsageDiscrepancyUnitsList.total_checkboxes+i.checked)
			forDeletion+=("Y,");
		else
			forDeletion+=("N,");
			if(!eval("f_query_add_mod.frameInstrUsageDiscrepancyUnitsList.document.formInstrUsageDiscrepancyUnitsList.total_checkboxes"+i.checked)){
			noDetailExists=false;
		}
		
	}
	
	forDeletion=forDeletion.substring(0,forDeletion.length-1);
	var formObj		=	top.content.f_query_add_mod.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader ;
	formObj.records_to_delete.value=forDeletion;
	var blankObject	=	null;
	var fields		=	new Array(formObj.store_code, formObj.group_desc, formObj.tray_no);
	var fieldNames	=	new Array(getLabel("eSS.Store.label","SS"), getLabel("Common.Group.label","Common"), getLabel("eSS.TrayNo.label","SS"));

	blankObject		=	getBlankField( fields, fieldNames, messageFrame);
	if(blankObject==null) {
		if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}
		responseText=formApply(formObj,SS_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	}
	else{
		blankObject.focus();
	}
}

function onSuccess() {
	f_query_add_mod.document.location.reload();
	
}
function showSelectTray() {
	var headerForm = document.formGenerateROFHeader;
	var fields =	new Array();
	var fieldNames =new Array();
	var index = 0;
	var queryString = "";
	
	fields[index] = headerForm.store_code;
	fieldNames[index++]	=	getLabel("eSS.Store.label","SS");
	obj = getBlankField(fields, fieldNames, parent.parent.messageFrame) 
	
	if(obj != null){
		obj.focus();
	}
	else {
		headerForm.submit();
	}
	return;
}

function closeActionPerformed(frmObj) {
	var selectedIndices = "";
	var index = 0;
	var total_trays = document.formGenerateROFSelectTrayResult.total_trays.value;
	var arrayObject = new Array();
	for (count = 0;count<total_trays;count++) {
			if(eval("document.formGenerateROFSelectTrayResult.tray_"+count+".checked")) {
				arrayObject[index] = eval("document.formGenerateROFSelectTrayResult.table_index_"+count);
				arrayObject[index+1] = eval("document.formGenerateROFSelectTrayResult.group_code_"+count);
				arrayObject[index+2] = eval("document.formGenerateROFSelectTrayResult.tray_no_"+count);
				arrayObject[index+3] = eval("document.formGenerateROFSelectTrayResult.group_desc_"+count);
				arrayObject[index+4] = eval("document.formGenerateROFSelectTrayResult.bin_location_code_"+count);
				arrayObject[index+5] = eval("document.formGenerateROFSelectTrayResult.expiry_date_"+count);
				arrayObject[index+6] = eval("document.formGenerateROFSelectTrayResult.non_returnable_yn_"+count);
				selectedIndices += (count+ ",");
				index += 7
			}
	}
	document.formGenerateROFSelectTrayResult.chkdIndices.value = selectedIndices;
	arrayObject[arrayObject.length] = document.formGenerateROFSelectTrayResult.chkdIndices;
	assignBean(document.formGenerateROFSelectTrayResult);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "GenerateROFValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	//window.close();
	let dialogBody = parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = formObject.remarks.value;
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

// To be considered for maintaing the state of the check boxes
function SubmitLink(from, to) {
	var listForm = document.formGenerateROFQueryResult;
	var total_trays = listForm.total_trays.value;

	var selectedIndices = "";
	var index = 0;
	var xmlString = "";
	assignBean(listForm);

	for (count = 0;count<parseInt(total_trays);count++) {
			if(eval("document.formGenerateROFQueryResult.tray_"+count+".checked")) {
				checkedValue = eval("document.formGenerateROFQueryResult.tray_key_"+count+".value");
				checkedType = eval("document.formGenerateROFQueryResult.tray_"+count+".value");
				checkedKey = eval("document.formGenerateROFQueryResult.total_key_"+count+".value");
				xmlString += " selected_tray_"+ index +"=\""+checkedValue+"\"";
				xmlString += " selected_type_"+ index +"=\""+checkedType+"\"";
				xmlString += " total_key_"+ index +"=\""+checkedKey	+"\"";
				index+=1;
			}
			xmlString += " ";
	}
	xmlString ="<root><SEARCH "+xmlString+"/></root>";
	xmlDom.loadXML(xmlString);
	xmlHttp.open("POST", "../../eSS/jsp/GenerateROFValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);

    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}
async function searchGroupCode( objCode, objDesc ) {
	var formObj = parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader;//added for mmoh-crf-1661
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
//	var formobj=document.formInstrUsageDiscrepancyUnitsHeader;
	var formobj=document.querySelector('#formInstrUsageDiscrepancyUnitsHeader')
    
	dataNameArray[0] = "store_code";
	dataValueArray[0]=formobj.store_code.value;
	dataTypeArray[0] = STRING;
	
	dataNameArray[1] = "locale";
	dataValueArray[1]= document.formInstrUsageDiscrepancyUnitsHeader.locale.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = "SELECT DISTINCT a.group_code code,a.short_desc description FROM ss_group_lang_vw a,ss_group_for_store b WHERE a.eff_status = 'E' AND a.group_code=b.group_code AND  STORE_CODE LIKE UPPER(?) AND a.language_id like ?  AND a.group_code LIKE UPPER(?) AND UPPER(a.short_desc) LIKE UPPER(?) AND GROUP_TYPE= '"+formObj.group_type.value+"'";//added for ML-MMOH-CRF-1661       
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	/*if(objDesc.readOnly )commented against KDAH-SCF-0329 [IN:057314]
	argumentArray[5] = "";
	else*/
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await  CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	var ret1 = unescape(returnedValues);
	var arr = ret1.split(",");
	if (arr[1] == undefined) {
		arr[0] = "";
		arr[1] = "";
	}
	
	
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		formobj.group_code.value=arr[0];
		formobj.groupDesValue.value=arr[1];
		objDesc.value = arr[1];
		objDesc.readOnly  = true;
		
		console.log(document.formInstrUsageDiscrepancyUnitsHeader);
		console.log(document.formInstrUsageDiscrepancyUnitsHeader.store_code);
		document.formInstrUsageDiscrepancyUnitsHeader.store_code.disabled = true;//added for KDAH-SCF-0329 [IN:057314]
		console.log(document.formInstrUsageDiscrepancyUnitsHeader.elements);
		document.formInstrUsageDiscrepancyUnitsHeader.elements.disabled=false;
		//document.formInstrUsageDiscrepancyUnitsHeader.all.details.disabled = false;
//		document.formInstrUsageDiscrepancyUnitsHeader.all.details.style.cursor = "hand";
		//document.formInstrUsageDiscrepancyUnitsHeader.elements.style.cursor="hand";
		for (var i = 0; i < document.formInstrUsageDiscrepancyUnitsHeader.elements.length; i++) {
		    document.formInstrUsageDiscrepancyUnitsHeader.elements[i].style.cursor = "hand";
		}

		
		
		params = document.formInstrUsageDiscrepancyUnitsHeader.params.value; //Added for KDAH-SCF-0329 [IN:057314]
		parent.frameInstrUsageDiscrepancyUnitsDetail.location.href="../../eSS/jsp/InstrUsageDiscrepancyUnitsDetail.jsp?"+params+"&group_code="+objCode.value ; //Added for KDAH-SCF-0329 [IN:057314];
		return;
	} 
}
async function searchTrayNo(){
	var formObj = document.formInstrUsageDiscrepancyUnitsHeader;
	var group_code="";
	var groupDesValue="";
	var default_store="";
	group_code	=	parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.group_code.value;
	groupDesValue	=	parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.groupDesValue.value;
	default_store	=	parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.default_store.value;
	var function_id =   parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.function_id.value;
	var store_code =   parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.store_code.value;
	
	if(group_code=="")	return;
	if(formObj.tray_no.value!="")return;
	var dialogHeight= "70vh" ;
    	var dialogWidth = "57vw" ;
    	var status = "no";
	var dialogUrl       = "../../eSS/jsp/TrayDiscrepancyTrayQueryFrame.jsp?function_id="+function_id+"&tray_no="+formObj.tray_no.value+"&group_code="+group_code+"&store_code="+store_code+"&group_desc="+groupDesValue;
	var dialogArguments = "";
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal =await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
	if( returnVal == null )
		return;
	else{
		formObj.tray_no.value=returnVal;
		parent.frameInstrUsageDiscrepancyUnitsHeader.formInstrUsageDiscrepancyUnitsHeader.store_code.disabled=true;
		parent.frameInstrUsageDiscrepancyUnitsHeader.formInstrUsageDiscrepancyUnitsHeader.group_type.disabled=true;
		
		parent.frameInstrUsageDiscrepancyUnitsHeader.formInstrUsageDiscrepancyUnitsHeader.group_desc.disabled=true;
		formObj.tray_no.focus();
	}
}

function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/AssignBinLocationValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
}
	

async function searchPatient() {
	
	var formObj = document.formInstrUsageDiscrepancyUnitsDetail;
	var patient_id	=await  PatientSearch();
	if ((patient_id == null) || (patient_id =="")) {
		formObj.patient_name.value = "";
		return;
	}
	
	if(document.formInstrUsageDiscrepancyUnitsDetail!=null)
		
	

	if (!((patient_id == null) || (patient_id =="")))	{
		formObj.patient_id.value = patient_id;
		
	}
	formObj.patient_id.focus();
	

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	var parser = new DOMParser();
	var xmlStr = getXMLString (null);
    xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	var bean_id=formObj.bean_id.value;
	var bean_name=formObj.bean_name.value;
	xmlHttp.open("POST", "../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?validate=PATIENT_NAME"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+formObj.patient_id.value, false);
//	xmlHttp.send(xmlDoc);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
	responseText=xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	
}


function callPatientSearch(patientID,patientName,formObject) {
	
	if (patientID.value == null  || patientID.value == "")	{
		return;
	}
	var pat_id= PatientSearch();
	if ((pat_id == null) || (pat_id =="")) {
		patientName.value = "";
		return;
	}
	patientID.value = pat_id;
	getPatientName(patientID,patientName,formObject);
}

function getPatientName(patientID,patientName,formObject) {
	patientName.value = "";
	if (patientID.value == "")	{
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = patientID;
	var bean_id=formObject.bean_id.value;
	var bean_name=formObject.bean_name.value;
	var patient_id=formObject.patient_id.value;
	var patient_name=formObject.patient_name.value;
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=SEARCH_PATIENT"+"&patient_name="+patient_name+"&patient_id="+patient_id, false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	
}

function populateEncounterId(patientID) {

	var formObject= document.formInstrUsageDiscrepancyUnitsDetail;
	var bean_id=formObject.bean_id.value;
	var bean_name=formObject.bean_name.value;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlStr = getXMLString(null);
	xmlDoc.loadXML(getXMLString(null));
 mlHttp.open("POST","../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=POPULATE_ENCOUNTER_ID"+"&patient_id="+patientID, false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function setPatientName(patientName) {
	
	document.formInstrUsageDiscrepancyUnitsDetail.patient_name.value = patientName;
}
function setEncounterId(encounter_id) {

	if((document.formInstrUsageDiscrepancyUnitsDetail.index.value=="0")&&(document.formInstrUsageDiscrepancyUnitsDetail.item_code.value==""))encounter_id="";
	document.formInstrUsageDiscrepancyUnitsDetail.encounter_id.value = encounter_id;
}
function validateGroup(group_code,group_desc)
{

	var formObj = parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader;
	var arrayObjects = new Array();
	arrayObjects[0] = formObj.group_desc;
	bean_id = document.formInstrUsageDiscrepancyUnitsHeader.bean_id.value;
	bean_name = document.formInstrUsageDiscrepancyUnitsHeader.bean_name.value;
//	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
//	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
//	xmlStr = getXMLString (arrayObjects);
//	xmlDom.loadXML( xmlStr );
	
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (arrayObjects);
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	
	xmlHttp.open("POST", "../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&validate=GROUP_DESC"+"&group_desc="+formObj.group_desc.value+"&group_code="+formObj.group_code.value+"&store_code="+formObj.store_code.value, false);
//	xmlHttp.send( xmlDom );
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;

}
function invalidPatientName() {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('INVALID_PATIENT',"SS");
	document.formInstrUsageDiscrepancyUnitsDetail.patient_id.focus();
	return;
}

function addToList(){
	
	var formObj=  document.formInstrUsageDiscrepancyUnitsDetail;
	var formObj1		=parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader;//added for KDAH-SCF-0329 [IN:057314]
	var fields = new Array ( formObj.item_code, formObj.write_off_reason_code, formObj.discrepancy_qty, formObj1.tray_no);
	var names  =  new Array ( getLabel("eSS.Instrument.label","SS"), getLabel("eSS.DiscrepancyReason.label","SS"),getLabel("Common.Quantity.label","Common") , getLabel("eSS.TrayNo.label","SS"));
	var obj    =null;
	var bean_id = document.formInstrUsageDiscrepancyUnitsDetail.bean_id.value;
	var bean_name = document.formInstrUsageDiscrepancyUnitsDetail.bean_name.value;
	
	var errorPage	 = "../../eCommon/jsp/error.jsp";
	
	
	obj=getBlankField( fields, names, parent.parent.messageFrame,errorPage);
	
	if(obj==null) {
		
		var item_code		=	formObj.item_code.value;
		var item_desc		=	formObj.item_code.options[formObj.item_code.selectedIndex].text;
		var patient_id		=	formObj.patient_id.value;
		var patient_name	=	formObj.patient_name.value;
		var encounter_id	=	"";
		if(patient_name==""||patient_id==""){
			encounter_id_val =	"";
			encounter_id	 =	"";
		}
		else{
		var encounter_id_val =	formObj.encounter_id.options[formObj.encounter_id.selectedIndex].text;
	//	if(formObj.encounter_id.options[formObj.encounter_id.selectedIndex].text=="Select")//commented for ML-MMOH-SCF-1852
/*		{
			
			encounter_id_val =	"";
		}
			encounter_id	 =	encounter_id_val;
		}*/
		var checkString = "--- Select ---";//ML-MMOH-SCF-1852
		if(encounter_id_val.indexOf(checkString) !== -1) {
			encounter_id=""; 
		} else {
			encounter_id = encounter_id_val; 
		}	//END
		}
		var write_off_reason_code	=	formObj.write_off_reason_code.value;
		var write_off_reason_desc	=	formObj.write_off_reason_code.options[formObj.write_off_reason_code.selectedIndex].text;
		var discrepancy_qty			=	formObj.discrepancy_qty.value;		
		var remarks					=	escape(formObj.remarks.value);
		var discrepancy_type		=	formObj.discrepancy_type.value;
		var mode					=	formObj.mode.value;
		var index					=	formObj.index.value;
	
		var group_code				=	parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.group_code.value;
		var group_desc				=	parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.groupDesValue.value;
		var tray_no					=	parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.tray_no.value;
		var store_code				=	parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.store_code.value;
	
//		var xmlHttp					=	new ActiveXObject( "Microsoft.XMLHTTP" );
//		var xmlDoc					=	new ActiveXObject("Microsoft.XMLDom");
//		xmlDoc.loadXML(getXMLString(null));
		
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString (null);
	    var parser = new DOMParser();
	    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	
		xmlHttp.open("POST", "../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?item_code="+item_code +"&write_off_reason_code=" +write_off_reason_code+ "&write_off_reason_desc=" + write_off_reason_desc+"&item_desc=" + item_desc+ "&discrepancy_qty=" + discrepancy_qty + "&discrepancy_type="+discrepancy_type+"&patient_id="+patient_id+"&patient_name="+patient_name+"&encounter_id="+encounter_id+"&group_code="+group_code+ "&group_desc="+group_desc+"&tray_no=" + tray_no+"&remarks="+remarks+"&store_code="+store_code+"&index="+index+ "&validate=ADD_TO_LIST"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&mode="+mode,false);	

		//xmlHttp.send(xmlDoc);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(result)
		{
			resetInstrUsageDiscrepancyDetail();
		}
		else
		{
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
		
	}
	else{
		obj.focus();
		
	}
}

function disableHeader(){//added for KDAH-SCF-0329 [IN:057314]
	document.formInstrUsageDiscrepancyUnitsHeader.store_code.disabled=true;
	document.formInstrUsageDiscrepancyUnitsHeader.tray_no.disabled=true;
	document.formInstrUsageDiscrepancyUnitsHeader.tray_search.disabled=true;
	document.formInstrUsageDiscrepancyUnitsHeader.group_desc.disabled=true;
	document.formInstrUsageDiscrepancyUnitsHeader.group_search.disabled=true;
	document.formInstrUsageDiscrepancyUnitsHeader.group_type.disabled=true;
}

function refreshList(result){

	top.content.f_query_add_mod.frameInstrUsageDiscrepancyUnitsList.document.location.reload();	
	
	
}

function refreshDetails(){
	
	displayMessage(top.content.messageFrame,"");
	
	resetInstrUsageDiscrepancyDetail();
	
	}
function resetInstrUsageDiscrepancyDetail(){

	var formObj=document.formInstrUsageDiscrepancyUnitsDetail;

	formObj.item_code.value="";
	formObj.write_off_reason_code.value="";
	formObj.item_code.disabled=false;
	formObj.write_off_reason_code.disabled=false;
	
	formObj.remarks.value="";
	formObj.patient_id.value="";
	formObj.patient_name.value="";
	formObj.encounter_id.value="";
	formObj.remarks.readOnly=false;
	formObj.discrepancy_qty.value="";
	formObj.encounter_id.value="";
	formObj.discrepancy_qty.disabled=false;
	formObj.discrepancy_type.value="N";
	formObj.discrepancy_type.disabled=false;
	formObj.remarks.disabled=false;
	
	formObj.index.value="-1";
	formObj.apply.value="  Add  ";
	formObj.apply.disabled=false;
}


function checkMaxQty(discrepancyQuantity) {
	assignBean(document.formInstrUsageDiscrepancyUnitsDetail);
	var headerForm = parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader;
	var param = " group_code=\""+headerForm.group_code.value+"\" ";
	param = param +" tray_no=\""+headerForm.tray_no.value+"\" ";
	param = param +" item_code=\""+headerForm.item_code.value+"\" ";
	var xmlStr ="<root><SEARCH "+param+"/></root>";
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	return true;
}

function displayDetail(index) {
	
	
	var bean_id=document.formInstrUsageDiscrepancyUnitsList.bean_id.value;
	var bean_name=document.formInstrUsageDiscrepancyUnitsList.bean_name.value;
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	parent.frameInstrUsageDiscrepancyUnitsDetail.document.formInstrUsageDiscrepancyUnitsDetail;
	var param = "selected_key=\""+eval("document.formInstrUsageDiscrepancyUnitsList.selected_tray_"+index+".value")+"\"";
	var xmlStr ="<root><SEARCH "+param+"/></root>";
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST","../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=EDIT_DETAIL", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	
	
}

function editDetail(arrayObject) {
	var formDetail = parent.frameInstrUsageDiscrepancyUnitsDetail.document.formInstrUsageDiscrepancyUnitsDetail;
	formDetail.item_code.disabled = true;
	formDetail.write_off_reason_code.disabled = true;
	formDetail.item_code.value =  arrayObject[0];
	formDetail.write_off_reason_code.value =  arrayObject[1];
	formDetail.remarks.value =arrayObject[2]; 
	formDetail.discrepancy_qty.value =arrayObject[3]; 
	formDetail.patient_id.value =arrayObject[4]; 
	formDetail.patient_name.value =arrayObject[5]; 
	formDetail.encounter_id.value =arrayObject[6]; 
	formDetail.editing_key.value = arrayObject[0]+"-"+arrayObject[1];
	formDetail.modify.value =getLabel("Common.Modify.label","Common");
}


function listModify(index,write_off_reason_code,encounter_id,patient_name,patient_id){
	
	
parent.frameInstrUsageDiscrepancyUnitsDetail.location.href="../../eSS/jsp/InstrUsageDiscrepancyUnitsDetail.jsp?index="+index+"&function_id="+parent.parent.function_id+"&group_code="+parent.frameInstrUsageDiscrepancyUnitsHeader.document.formInstrUsageDiscrepancyUnitsHeader.group_code.value+"&write_off_reason_code="+write_off_reason_code+"&encounter_id="+encounter_id+"&patient_name="+patient_name+"&patient_id="+patient_id;

	

}
function setEncounterId(encounter_id)
{
	
	var obj=document.formInstrUsageDiscrepancyUnitsDetail.encounter_id;
	obj[obj.selectedIndex].text=encounter_id;
}
function clearDetailForm() {
	var formDetail = document.formInstrUsageDiscrepancyUnitsDetail;
	formDetail.item_code.value = "";
	formDetail.item_desc.value = "";
	formDetail.write_off_reason_code.value = "";
	formDetail.write_off_reason_desc.value = "";
	formDetail.remarks.value = ""; 
	formDetail.discrepancy_qty.value ="";
	formDetail.editing_key.value = "";
	formDetail.patient_id.value = "";
	formDetail.patient_name.value = "";
	formDetail.encounter_id.disabled = true;
	
	formDetail.item_code.disabled = false;
	formDetail.write_off_reason_code.disabled = false;
	formDetail.modify.value = getLabel("Common.Add.label","Common");
}



function validateTrayNo() {
	var formHeader =  document.formInstrUsageDiscrepancyUnitsHeader;
	if (formHeader.tray_no.value != "") {
		if (!validateGroupCodeSearch(formHeader.group_code,formHeader.group_desc,"2",formHeader.group_type_code)) {
			return;
		}
		var arrayObjects = new Array (formHeader.store_code, formHeader.group_desc);
		var names  =  new Array("Store", "Group");
		var obj =null;
		var messageFrame = parent.parent.messageFrame; 
		var errorPage	 = "../../eCommon/jsp/error.jsp";
		var xmlString ="";
		obj=getBlankField( arrayObjects, names, messageFrame,errorPage);
		if (obj != null) {
			obj.focus();
			return;
		}
		if (formHeader.tray_no.value != "" && !checkIntegerFormat(formHeader.tray_no)) {
			formHeader.tray_no.focus();
			return;
		}
		arrayObjects = new Array (formHeader.store_code,formHeader.group_code,formHeader.tray_no);
		for (index=0;index<arrayObjects.length;index++)	{
				xmlString += arrayObjects[index].name+"=\""+ checkSpl(arrayObjects[index].value) +"\" ";
		}
		xmlString ="<root><SEARCH "+xmlString+"/></root>";
		assignBean(formHeader);
		xmlDom.loadXML(xmlString);
		xmlHttp.open("POST", "../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		
		if (!result) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('INVALID_TRAY_NO',"SS");
			formHeader.tray_no.focus();
			return;
		}
		formHeader.group_desc.disabled=true;
		formHeader.group_search.disabled=true;
		formHeader.group_type_code.disabled=true;
		formHeader.store_code.disabled=true;
	}
}

function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
//    top.window.returnValue = tray_no;
//    top.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = tray_no;
    
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();   
	
}

function isValidGroupCode() {
	var formHeader =  document.formInstrUsageDiscrepancyUnitsHeader;
	if (!validateGroupCodeSearch(formHeader.group_code,formHeader.group_desc,"2",formHeader.group_type_code)) {
		return;
	}
}

function validateEncounterID() {
	var detailForm = document.formInstrUsageDiscrepancyUnitsDetail;
	if (!checkIntegerFormat(detailForm.encounter_id)) {
			detailForm.encounter_id.focus();
			return;
	}
}

function checkTrayNo(obj){
	
	if(checkIntegerFormat(obj)){ 
		populateDiscrepancyDetail();
	}
}

function populateDiscrepancyDetail(){

	var formObj		=	document.formInstrUsageDiscrepancyUnitsHeader ;
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	if(formObj.tray_no.value=="")return;
	
	var group_code=formObj.group_code.value;
	var group_desc=formObj.group_desc.value;
	var group_type=formObj.group_type.value;
	var tray_no=formObj.tray_no.value;
	var store_code=formObj.store_code.value;
	var blankObject	=	null;
	var fields		=	new Array(formObj.store_code, formObj.group_desc, formObj.tray_no);
	var fieldNames	=	new Array(getLabel("eSS.Store.label","SS"), getLabel("Common.Group.label","Common"), getLabel("eSS.TrayNo.label","SS"));//modified getLabel("Common.Store.label","Common") for KDAH-SCF-0329 [IN:057314]
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);
	
	var bean_id=formObj.bean_id.value;
	var bean_name=formObj.bean_name.value;
	
	if(blankObject==null) {
		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var parser = new DOMParser();
	    
	    
		var group_code=formObj.group_code.value;
		var group_desc=formObj.group_desc.value;
		var group_type=formObj.group_type.value;
		var tray_no=formObj.tray_no.value;
		var store_code=formObj.store_code.value;
		
		clearListItems("parent.frameInstrUsageDiscrepancyUnitsDetail.document.forms[0].item_code");
 		//xmlDoc.loadXML(getXMLString(null));
		var xmlStr = getXMLString (null);
		var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		
		xmlHttp.open("POST", "../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?validate=POPULATE_DISCREPANCY"+"&group_code=" + group_code+"&store_code=" +store_code+"&tray_no=" +tray_no+"&bean_id="+bean_id+"&bean_name="+bean_name, false);
		
		//xmlHttp.send(xmlDoc);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		
		eval(responseText);
		
		if(!result){
			alert(getMessage(message,"SS"));//modified for KDAH-SCF-0329 [IN:057314]
			formObj.tray_no.focus();
		}
	}
	else{
		blankObject.focus();
	}
}

function searchTrayDetail( objCode, objDesc ) {
	
	var formObj	= document.forms[0];

	if(formObj.tray_no.value==""){
		clearTrayDetails();
		return;
	}
	
} 
function clearTrayDetails(){
	document.formInstrUsageDiscrepancyUnitsHeader.tray_no.value="";

}

function validateStore(store_code) {
	var	frmObject=document.formInstrUsageDiscrepancyUnitsHeader;
	var store_code=document.formInstrUsageDiscrepancyUnitsHeader.store_code.value;
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
//	xmlDom = new ActiveXObject("Microsoft.XMLDom");
//	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var arrayObject = new Array();
	arrayObject[0] = store_code;
//	xmlStr = getXMLString(arrayObject);
//	xmlDom.loadXML(xmlStr);
	
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (arrayObject);
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	
	xmlHttp.open("POST", "../../eSS/jsp/InstrUsageDiscrepancyUnitsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&validate=STORE_CODE"+"&store_code="+store_code, false);
//	xmlHttp.send( xmlDom );
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval( responseText );
}

async function details(){
    var group_code		=	document.formInstrUsageDiscrepancyUnitsHeader.group_code.value;
	var group_desc		=	document.formInstrUsageDiscrepancyUnitsHeader.group_desc.value;

	if(group_code!=""){
	var dialogHeight = "70vh" ;
		//var dialogWidth	= "24" ;
		var dialogWidth	= "60vw" ;
		var dialogTop = "265" ;
		var center = "1" ;
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
		var arguments = "" ;
		var title="Request Detail";
		var params = "group_code="+group_code+"&group_desc="+group_desc;
		retVal = await window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}
}

