/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var xmlDom;
var xmlHttp;
var finalizeType;

function create() {
	
	f_query_add_mod.location.href="../../eSS/jsp/ROFEntryFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&menu_id="+menu_id+"&module_id="+module_id;
}

function reset() {
	if (f_query_add_mod.frameROFEntryHeader != null)	{
		var headerForm = f_query_add_mod.frameROFEntryHeader.document.formROFEntryHeader;
		headerForm.reset();
		if (headerForm.mode.value == MODE_INSERT) {
			headerForm.sterilize_yn.disabled = false;
			headerForm.wash_yn.disabled = false;
			headerForm.pack_yn.disabled = false;
		}
		var detailForm = f_query_add_mod.frameROFEntryDetail.document.formROFEntryDetail;
		detailForm.reset();
		detailForm.group_type_code.disabled = false;
		detailForm.group_desc.readOnly = detailForm.group_search.disabled = false;
		detailForm.tray_no.disabled = detailForm.tray_no_search.disabled = false;
		detailForm.sterile_type.disabled=false;
		detailForm.wash_type.disabled=false;
        f_query_add_mod.frameROFEntryHeader.formROFEntryHeader.store_code.disabled=false;

		var doc_type_code =headerForm.doc_type_code.value;
		var doc_no =headerForm.doc_no.value;
		f_query_add_mod.document.location.href="../../eSS/jsp/ROFEntryFrame.jsp?mode="+MODE_MODIFY+"&doc_type_code="+doc_type_code+"&module_id="+parent.parent.module_id+"&doc_no="+doc_no;

		return;
	}
	f_query_add_mod.frameROFEntryQueryCriteria.document.formROFEntryQueryCriteria.reset();
}

function query(){
		var formHeader = f_query_add_mod.location.href = "../../eSS/jsp/ROFEntryQueryFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function Modify(queryResultObject){
	var doc_type_code =queryResultObject.cells[6].innerText;
	var doc_no =queryResultObject.cells[1].innerText;

	parent.document.location.href="../../eSS/jsp/ROFEntryFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id;
}

async function deleterecord(){

	var formObj	=	f_query_add_mod.frameROFEntryHeader.document.formROFEntryHeader;
	if(formObj.mode.value==MODE_MODIFY){
		var confirmation = await confirmDelete();//window.confirm("Current record will be deleted!!");
		if(confirmation=="Yes"){
			formObj.mode.value=MODE_DELETE;
			eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
			else{
				formObj.mode.value=MODE_MODIFY;
			}
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
		}
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}

}

function onSuccess(){
	var formHeader = f_query_add_mod.frameROFEntryHeader.document.formROFEntryHeader;
	if(formHeader.mode.value==MODE_DELETE) {
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	}
	else if(formHeader.mode.value==MODE_MODIFY) {
		create();
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	}
	else 
	{
		formHeader.reset();

		f_query_add_mod.location.reload();

	}
	return;
}

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
//	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlDom = "" ;
//	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlHttp = new XMLHttpRequest();
}

async function searchGroupCode( objCode, objDesc ) {
	var detailForm = document.formROFEntryDetail;
	var headerForm = parent.frameROFEntryHeader.document.formROFEntryHeader;
	var prev_value	=	objCode.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataTypeArray[0] = STRING;
	dataNameArray[0] = "group_type";
	dataValueArray[0]= escape(detailForm.group_type_code.value);
	
	dataTypeArray[1] = STRING;
	dataNameArray[1] = "sterilize_reqd_yn";
	if (headerForm.sterilize_yn.checked) 	{
		dataValueArray[1]= headerForm.sterilize_yn.value;
	}
	else {
		
		dataValueArray[1] = "N";
	}
	
	dataTypeArray[2] = STRING;
	dataNameArray[2] = "wash_reqd_yn";
	if (headerForm.wash_yn.checked) 	{
		dataValueArray[2]= headerForm.wash_yn.value;
	}
	else {
		dataValueArray[2] = "N";
	}
	
	dataTypeArray[3] = STRING;
	dataNameArray[3] = "pack_reqd_yn";
	if (headerForm.pack_yn.checked) 	{
		dataValueArray[3]= headerForm.pack_yn.value;
	}
	else {
		dataValueArray[3] = "N";
	}
		
	dataTypeArray[4] = STRING;
	dataNameArray[4] = "store_code";
	dataValueArray[4]= escape(headerForm.store_code.value);

    dataTypeArray[5] = STRING;
	dataNameArray[5] = "language_id";
	dataValueArray[5]= detailForm.locale.value;
   
	//comented against inc#42469
	/*dataTypeArray[6] = STRING;
	dataNameArray[6] = "group_code";
	dataValueArray[6]= objCode.value

	dataTypeArray[7] = STRING;
	dataNameArray[7] = "short_desc";
	dataValueArray[7]= objDesc.value;*/

    




	argumentArray[0] = detailForm.SQL_SS_GROUP_LOOKUP_ROF_ENTRY_TYPE.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//comented against inc#42469
	//argumentArray[4] = "6,7";
	argumentArray[4] = "7,8";
	if(objDesc.readOnly)
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;

	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup( "Group", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		detailForm.group_desc.readOnly=true;
		detailForm.group_search.disabled=true;
		detailForm.group_type_code.disabled=true;
		parent.frameROFEntryHeader.formROFEntryHeader.store_code.disabled=true;
		parent.frameROFEntryHeader.formROFEntryHeader.sterilize_yn.disabled=true;
		parent.frameROFEntryHeader.formROFEntryHeader.wash_yn.disabled=true;
		parent.frameROFEntryHeader.formROFEntryHeader.pack_yn.disabled=true;

		setSterilizeWashDefaultValues();
		objDesc.readOnly=true;
	} 
}

function setSterilizeWashDefaultValues() {
	var detailForm = document.formROFEntryDetail;
	if (detailForm.group_code.value  != "") {
		assignBean(detailForm);
		var xmlStr ="<root><SEARCH "+detailForm.group_code.name+"=\""+detailForm.group_code.value+"\"/></root>";
		// xmlDom.loadXML(xmlStr);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/ROFEntryValidate.jsp?bean_id="+detailForm.bean_id.value+"&bean_name="+detailForm.bean_name.value+"&function_type=3", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;

		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));

	}
	return;
}

function detailErrorMessage(errorMessage) {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ errorMessage;
}

async function searchTrayNo(trayNo){
	var headerForm = parent.frameROFEntryHeader.document.formROFEntryHeader;
	var detailForm = document.formROFEntryDetail;
	
	if (headerForm.store_code.value == "")	{
		detailErrorMessage("Store Cannot be blank");
		return;
	}
	if (formROFEntryDetail.group_desc.value == "")	{
		detailErrorMessage(getMessage('ALTERNATE_GROUP_CANT_BLANK',"SS"));
		return;
	}
	if (!(headerForm.wash_yn.checked || headerForm.pack_yn.checked ||  headerForm.sterilize_yn.checked))	{
		detailErrorMessage(getMessage('ID_WASH_PACK_STERILIZE',"SS"));
		return;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	var group_code	=	detailForm.group_code.value;
	var group_desc	=	detailForm.group_desc.value;
	var dialogHeight= "450px" ;
    var dialogWidth = "700px" ;
    var status = "no";
	//var dialogUrl = "../../eSS/jsp/ROFEntryTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+trayNo.value+"&store_code="+headerForm.store_code.value+"&group_code="+group_code+"&group_desc="+group_desc;
	//added by Rabbani #Inc no:42469 on 28-AUG-13 
	var dialogUrl = "../../eSS/jsp/ROFEntryTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+trayNo.value+"&store_code="+headerForm.store_code.value+"&group_code="+group_code+"&group_desc="+encodeURIComponent(group_desc);
	if (headerForm.wash_yn.checked) 
		dialogUrl = dialogUrl+"&wash_yn="+headerForm.wash_yn.value;
	if (headerForm.pack_yn.checked) 
		dialogUrl = dialogUrl+"&pack_yn="+headerForm.pack_yn.value;
	if (headerForm.sterilize_yn.checked) 
		dialogUrl = dialogUrl+"&sterilize_yn="+headerForm.sterilize_yn.value;

	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		detailForm.tray_no.value=returnVal;
		detailForm.contaminated_yn.focus();
	}
}

function addToTable() {
	
	var headerForm = parent.frameROFEntryHeader.document.formROFEntryHeader;
	var detailForm = document.formROFEntryDetail;
	var fields = new Array ( detailForm.group_desc,detailForm.tray_no);
	var names =  new Array ( getLabel("Common.Group.label","Common"),getLabel("eSS.TrayNo.label","SS"));
	

	if (headerForm.wash_yn.checked) {
		
		fields[fields.length] = detailForm.wash_type;
		names[names.length] = getLabel("eSS.WashingType.label","SS")
	}
	if (headerForm.sterilize_yn.checked) {
		fields[fields.length] = detailForm.sterile_type;
		names[names.length] = getLabel("eSS.SterilizationType.label","SS")
	}
	var obj=null;
	obj = getBlankField(fields, names, parent.parent.messageFrame) 
		if(obj != null){
		obj.focus();
		return
	}

	
	if(detailForm.pack_item_code.value=="null")
	{   detailForm.pack_item_code.value="";
	}
	if(detailForm.pack_item_qty.value=="null")
		detailForm.pack_item_qty.value="";

	var errors ="";
	var valueIndex = detailForm.group_type_code.selectedIndex;
	detailForm.group_type_name.value = detailForm.group_type_code.options[parseFloat(valueIndex)].text;
	assignBean(detailForm);
	var xmlString = getEnhancedXMLString(detailForm);

//	xmlDom.loadXML(xmlString);	
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/ROFEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+ bean_name +"&function_type=6", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;

	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage(message,"SS");
			return;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	parent.frameROFEntryList.document.location.reload();
	headerForm.sterilize_yn.disabled = true;
	headerForm.wash_yn.disabled = true;
	headerForm.pack_yn.disabled = true;
	detailForm.editing_key.value = "";

	if(detailForm.multi_group_type_yn.value=="N")
		detailForm.group_type_code.disabled = true; //ML-MMOH-CRF-1821
	detailForm.modify.value = getLabel("Common.Add.label","Common");
	clearDetailForm();
}

function clearDetailForm() {
	var detailForm = document.formROFEntryDetail;
	if(detailForm.multi_group_type_yn.value=="N") //ML-MMOH-CRF-1821
		detailForm.group_type_code.disabled = true; 
    else 
		detailForm.group_type_code.disabled = false; //ML-MMOH-CRF-1821
	detailForm.group_search.disabled = false;
	//detailForm.group_type_code.value = 'E'; //ML-MMOH-CRF-1821
	detailForm.group_desc.readOnly = false;
	detailForm.group_desc.value = "";
	detailForm.group_code.value = "";
	detailForm.tray_no.value = "";
	detailForm.tray_no.disabled = false;
	detailForm.tray_no_search.disabled = false;
	detailForm.contaminated_yn.checked = false;
	detailForm.sterile_type.value = "";
	detailForm.wash_type.value = "";
	detailForm.modify.value = getLabel("Common.Add.label","Common");
	detailForm.editing_key.value = "";
}

function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    top.window.returnValue = tray_no;
    top.close();
}

function displayDetail(index) {

	parent.frameROFEntryDetail.document.location.href="../../eSS/jsp/ROFEntryDetail.jsp?mode="+MODE_MODIFY+"&selected_key="+eval("document.formROFEntryList.selected_tray_"+index+".value")+"&index="+index;
}

function editDetail(arrayObject) {
	var isChecked = false;
	var detailForm = parent.frameROFEntryDetail.document.formROFEntryDetail;
	detailForm.group_type_code.disabled = true;
	detailForm.group_search.disabled = true;
	detailForm.group_type_code.value = arrayObject[6];
	detailForm.group_desc.readOnly = false;
	detailForm.group_code.value = arrayObject[0];
	detailForm.group_desc.value = arrayObject[1];
	detailForm.tray_no.value = arrayObject[2];
	if (arrayObject[3] == "Y")	{
		isChecked = true;
	}
	detailForm.contaminated_yn.checked = isChecked;
	detailForm.sterile_type.value = arrayObject[4];
	detailForm.wash_type.value = arrayObject[5];
	detailForm.editing_key.value = arrayObject[0]+"-"+arrayObject[2];
	detailForm.modify.value = getLabel("Common.Modify.label","Common");
	if (detailForm.mode.value == MODE_MODIFY) {
		detailForm.group_type_code.disabled = true;
		detailForm.group_search.disabled = true;
		detailForm.group_desc.readOnly = true;
		detailForm.tray_no.disabled = true;
		detailForm.tray_no_search.disabled = true;
	}
}

async function apply() {
	var listForm = f_query_add_mod.frameROFEntryList.document.formROFEntryList;
			totalCBox	=	parseInt(listForm.total_trays.value);
			var checkBoxObj=null;
		var noDetailExists	=	true;
		var errorPage	=	"../../eCommon/jsp/error.jsp";


	for(i=0;i<totalCBox;i++)
	{	checkBoxObj=eval("listForm.tray_id_"+i);
			if(!checkBoxObj.checked){
			noDetailExists=false;
	         }
	}
	if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","SS"); 		
		return;
	}

	var fields =	new Array();
	var fieldNames =new Array();
	var index = 0;
	
	var headerForm = f_query_add_mod.frameROFEntryHeader.document.formROFEntryHeader;
	fields[index] = headerForm.doc_type_code;
	fieldNames[index++]	=	getLabel("Common.DocType.label","Common");
	if(!headerForm.doc_no.disabled){
		fields[index] = headerForm.doc_no;
		fieldNames[index++]	=	getLabel("eSS.DocNo.label","SS");
	}
	fields[index] = headerForm.doc_date;
	fieldNames[index++]	=	getLabel("eSS.DocDate.label","SS");
	fields[index] = headerForm.store_code;
	fieldNames[index++]	=	getLabel("eSS.StoreCode.label","SS");
	fields[index] = headerForm.service_location_code;
	fieldNames[index++]	=	getLabel("eSS.ServiceLocation.label","SS");
	obj = getBlankField(fields, fieldNames, messageFrame) 
	if(obj != null){
		obj.focus();
		return;
	}
 
	var total_trays = listForm.total_trays.value;
	if (parseFloat(total_trays)<=0) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED',"SS");
		return;
	}
	var locale =		headerForm.locale.value;
	var doc_date				=	convertDocDate(headerForm.doc_date.value,'DMY',headerForm.locale.value,"en");

	
	var arrayObjects = new Array();
	var xmlString = "";
	var index = 0;
	var checkedValue = "";
	
	arrayObjects[0] = f_query_add_mod.frameROFEntryHeader.document.formROFEntryHeader.doc_date;
	arrayObjects[1] = listForm.total_trays;
	for (index=0;index<arrayObjects.length;index++)	{
		xmlString += arrayObjects[index].name+"=\""+ arrayObjects[index].value +"\" ";
	}
	assignBean(listForm);
	index = 0;
	for (count = 0;count<parseFloat(total_trays);count++) {
			if(!eval("f_query_add_mod.frameROFEntryList.document.formROFEntryList.tray_id_"+count+".checked")) {
				checkedValue = eval("f_query_add_mod.frameROFEntryList.document.formROFEntryList.selected_tray_"+count+".value");
				xmlString += " selected_tray_"+ index +"=\""+checkedValue+"\"";
				index+=1;
			}
			xmlString += " ";
	}
	
	xmlString ="<root><SEARCH "+xmlString+"/></root>";
	
//	xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/ROFEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=8", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	

	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	if (!result) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
		return;
	}
	//Submit thru form
	if (headerForm.mode.value == MODE_DELETE) {
		finalizeType = YES;
	}
	else {
		//if (headerForm.SS_ROF_ENTRY_FINALIZE!=null){ Commented by Sakti  since we have finalize in function level AAKH_SCF_158
		/*if(headerForm.SS_ROF_ENTRY_FINALIZE.value=="Y"){
		finalizeType = confirmFinalize();
		}
		else
			{
			finalizeType = NO;
			}*/
		finalizeType = await confirmFinalize();
		if (finalizeType == YES) {
			headerForm.finalized_yn.value = YES;
		}
		else {
			headerForm.finalized_yn.value = NO;
		}
		
	//}

	if (finalizeType !=	"No") {

		eval(formApply(headerForm,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+ flag;
		if( result ) {
			onSuccess();
		}
	}
	else
	{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");

	}

}
}
function convertDocDate(date,format,from,to){
	
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText =  trimString(xhr.responseText);

	f_query_add_mod.frameROFEntryHeader.document.formROFEntryHeader.doc_date.value=xmlText;
	return(xmlText);
}
function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();	
		}catch (trymicrosoft) {		
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
							request = false;
				
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}
function validateTrayNo() {
	var formDetail =  document.formROFEntryDetail;
	if (!formDetail.group_desc.readOnly && formDetail.group_desc.value == ""){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("ALTERNATE_GROUP_CANT_BLANK","SS");
		formDetail.group_desc.focus();
		return;
	}
	else if (!formDetail.group_desc.readOnly){
		if (!validateGroupCodeSearch(formDetail.group_code,formDetail.group_desc,"2",formDetail.group_type_code)) {
			return;
		}
		setSterilizeWashDefaultValues();
	}
	if (formDetail.tray_no.value != "") {
		var headerForm = parent.frameROFEntryHeader.document.formROFEntryHeader;
		var arrayObjects = new Array (formDetail.group_code);
		var names  =  new Array(getLabel("Common.Group.label","Common"));
		var obj =null;
		var messageFrame = parent.parent.messageFrame; 
		var errorPage	 = "../../eCommon/jsp/error.jsp"
		var 	xmlString ="";
		obj=getBlankField( arrayObjects, names, messageFrame,errorPage);
		if(obj != null){
			obj.focus();
			return
		}
		arrayObjects = new Array (formDetail.group_code,formDetail.tray_no,headerForm.sterilize_yn,headerForm.wash_yn,headerForm.pack_yn);
		for (index=0;index<arrayObjects.length;index++)	{
            if(arrayObjects[index].type == "checkbox") {
                if(arrayObjects[index].checked)
                    val = "Y";
				else 
					val = "N";
                if(arrayObjects[index].name != null && arrayObjects[index].value != "")
				xmlString+= arrayObjects[index].name+"=\"" + checkSpl(val) + "\" " ;
            }
			else {
				xmlString += arrayObjects[index].name+"=\""+ checkSpl(arrayObjects[index].value) +"\" ";
			}
		}
		xmlString ="<root><SEARCH "+xmlString+"/></root>";
		assignBean(headerForm);

//		xmlDom.loadXML(xmlString);
		xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/ROFEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		if (!result) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('INVALID_TRAY_NO',"SS");
			formDetail.tray_no.focus();
			return;
		}
		headerForm.sterilize_yn.disabled = true;
		headerForm.wash_yn.disabled = true;
		headerForm.pack_yn.disabled = true;
	 }
}

function requestDocDateFocus() {

	f_query_add_mod.frameROFEntryHeader.document.formROFEntryHeader.doc_date.focus();
	return;
}

function isValidGroupCode() {
	var formDetail =  document.formROFEntryDetail;
	if (!formDetail.group_desc.readOnly){
		if (!validateGroupCodeSearch(formDetail.group_code,formDetail.group_desc,"2",formDetail.group_type_code)) {
			return;
		}
	}
}

function disableStrType()
{
	if(document.formROFEntryHeader.sterilize_yn.checked==false)
	  parent.frameROFEntryDetail.formROFEntryDetail.sterile_type.disabled=true;
	else
	  parent.frameROFEntryDetail.formROFEntryDetail.sterile_type.disabled=false;
}

function disableWashType(){
	if(document.formROFEntryHeader.wash_yn.checked==false)
	  parent.frameROFEntryDetail.formROFEntryDetail.wash_type.disabled=true;
	else
      parent.frameROFEntryDetail.formROFEntryDetail.wash_type.disabled=false;
}


function setSterilizationType()
{

  if(parent.frameROFEntryHeader.formROFEntryHeader.sterilize_yn.checked==true)
    document.formROFEntryDetail.sterile_type.disabled=false ;
  else
   document.formROFEntryDetail.sterile_type.disabled=true ;
}

function setWashingType()
{
   if(parent.frameROFEntryHeader.formROFEntryHeader.wash_yn.checked==true)
    document.formROFEntryDetail.wash_type.disabled=false ;
   else
    document.formROFEntryDetail.wash_type.disabled=true ;

}  

function defaultGroupType(group_type){
			var formObj 							= parent.frameROFEntryDetail.document.formROFEntryDetail;
		if(formObj){	
			//formObj.group_type_code.options[formObj.group_type_code.selectedIndex].value=group_type;
			//formObj.group_type_code.value=group_type;

			var selLength = formObj.group_type_code.options.length;
			var selObj = formObj.group_type_code;
			for(var t=0;t<parseInt(selLength);t++){
				if(selObj.options[t].value == group_type)	{
					selObj.options[t].selected=true;
					break;
				}
			}
			formObj.group_type_code.disabled = true;
		}
//	formObj.document.getElementById("group_type_code").selectedIndex.text=getLabel("eSS.Pass.label","SS");
//		var selText 							= listbox.options[selIndex].text;//Store descreption
}