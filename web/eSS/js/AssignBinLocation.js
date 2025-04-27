/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function create() {
	f_query_add_mod.location.href="../../eSS/jsp/AssignBinLocationHeader.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function reset() {
	if (f_query_add_mod.qryCriteriaAssignBinLocation != null)	{
		query();
	}
	else
		f_query_add_mod.location.reload();
	
}

function query(){
	
	f_query_add_mod.location.href="../../eSS/jsp/AssignBinLocationQueryMain.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}


function onSuccess(){

	f_query_add_mod.location.reload();
}

function apply(){
	
	if(f_query_add_mod.frames[0].document.forms[0].name!="formAssignBinLocationHeader"){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";	 
		return;
	}
		
	var formObject = f_query_add_mod.AssignBinLocationListFrame.document.formAssignBinLocationList;
	var canProcess = false;
	var cnt=0;
	if (formObject.mode.value==MODE_MODIFY)	{
		var total_checkboxes = formObject.total_checkboxes.value;
			
		for (i=0;i<total_checkboxes;i++ ){
			if ((!eval ("formObject.tray_id_"+i+".disabled")) && eval ("formObject.tray_id_"+i+".checked")) {
			
			
				canProcess = true;
				
				break;
			}
			
		}
		for (i=0;i<total_checkboxes;i++ ){
			if ((!eval ("formObject.tray_id_"+i+".disabled")) && eval ("formObject.tray_id_"+i+".checked")) {
				cnt=cnt+1;
			}
	}
		if (!canProcess) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("ATLEAST_ONE_SELECTED","SS");	 
			return;
		}
		eval(formApply(f_query_add_mod.AssignBinLocationListFrame.document.formAssignBinLocationList,SS_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;	 
	}
	
	if(parseInt(total_checkboxes)>cnt){
	onSuccess();}
	
	if(cnt==parseInt(total_checkboxes)){
	
		
			f_query_add_mod.location.href="../../eSS/jsp/AssignBinLocationQueryMain.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
	
	}
	return;
}
function validateDocTypeCode(doc_type_code)
{
	alert(doc_type_code);
	var formObj=f_query_add_mod.AssignBinLocationHeaderFrame.document.formAssignBinLocationHeader;

		formObj.doc_type_code.options[formObj.doc_type_code.options.selectedIndex].text=doc_type_code;
}
	

function Modify(obj){
	var doc_ref=obj.cells[10].innerText;
	var doc_type_code =obj.cells[5].innerText;
	var doc_no =obj.cells[1].innerText;
	var store_desc =obj.cells[3].innerText;
	var doc_type_desc =obj.cells[0].innerText;
	var store_code =obj.cells[6].innerText;
	var group_code=obj.cells[7].innerText;
	var doc_date=obj.cells[2].innerText;
	var quantity=obj.cells[8].innerText;
	var total_cost=obj.cells[9].innerText;

	
	parent.document.location.href="../../eSS/jsp/AssignBinLocationFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&store_desc="+store_desc+"&doc_type_desc="+doc_type_desc+"&group_code="+group_code+"&doc_date="+doc_date+"&quantity="+quantity+"&total_cost="+total_cost+"&store_code="+store_code+"&doc_ref="+doc_ref;
}

function setTrayNo(cellData,index,store_code) {
	parent.AssignBinLocationDetailFrame.document.location.href= "../../eSS/jsp/AssignBinLocationDetail.jsp?function_id="+parent.parent.function_id+"&table_index="+index+"&tray_no="+cellData.innerText+"&selected_bin_location_code="+document.getElementById("tblTrayList").rows[parseFloat(index)].cells[2].innerText+"&store_code="+store_code;
	return;
}

function updateTrayNo() {
	var formTrayList = parent.AssignBinLocationListFrame.document.formAssignBinLocationList;
	var formTrayDetail = parent.AssignBinLocationDetailFrame.document.formAssignBinLocationDetail;
	
	var idx = formTrayDetail.table_index.value;
	
	var fields =	new Array(getLabel("eSS.BinLocation.label","SS"));
	var fieldNames =new Array(formTrayDetail.bin_location_code);
	
	var obj = getBlankField( fieldNames,fields, parent.parent.messageFrame) ;

	if(obj != null){
		obj.focus();
	}
	else{
		eval("formTrayList.tray_id_"+idx+".disabled=false");
		eval("formTrayList.tray_id_"+idx+".checked=true");
		eval("formTrayList.bin_location_"+idx).value=formTrayDetail.bin_location_code.value;
		
		formTrayList.all.tblTrayList.rows[idx].cells[2].innerText = formTrayDetail.bin_location_code.value;
		
		valueIndex = formTrayDetail.bin_location_code.selectedIndex;
		
		valueDesc = formTrayDetail.bin_location_code.options[parseFloat(valueIndex)].text;
		formTrayList.all.tblTrayList.rows[idx].cells[3].innerText = valueDesc;
		
		updateTrayStatus();
		formTrayDetail.modify.disabled = 	formTrayDetail.bin_location_code.disabled=formTrayDetail.cancel.disabled = true;
		formTrayDetail.tray_no.value="";
		formTrayDetail.bin_location_code.value="";
		formTrayDetail.table_index.value = "-1";
		return;
	}
}

function assignBean() {
	bean_id = document.formAssignBinLocationDetail.bean_id.value;
	bean_name = document.formAssignBinLocationDetail.bean_name.value;
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
}

function updateTrayStatus() {
	var formTrayDetail = parent.AssignBinLocationDetailFrame.document.formAssignBinLocationDetail;
	var arrayObjects = new Array();
	arrayObjects[0] = formTrayDetail.table_index;
	arrayObjects[1] = formTrayDetail.bin_location_code;
	arrayObjects[2] = formTrayDetail.tray_no;
	assignBean();
	table_index=formTrayDetail.table_index.value;
	bin_location_code=formTrayDetail.bin_location_code.value;
	tray_no= formTrayDetail.tray_no.value;
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	
	xmlHttp.open("POST", "AssignBinLocationValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1"+"&table_index="+table_index+"&bin_location_code="+bin_location_code+"&tray_no="+tray_no, false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	
}

function disableAll() {
	var formTrayDetail = parent.AssignBinLocationDetailFrame.document.formAssignBinLocationDetail;
	formTrayDetail.tray_no.value=formTrayDetail.bin_location_code.value="";
	formTrayDetail.tray_no.disabled = formTrayDetail.modify.disabled = 	formTrayDetail.bin_location_code.disabled=formTrayDetail.cancel.disabled = true;
	return;
}

async function searchCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "locale";
	dataValueArray[0]= document.formAssignBinLocation.locale.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.formAssignBinLocation.SQL_SS_GROUP_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;

	argumentArray[4] = "2,3";
	if(objDesc.readOnly )
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
		objDesc.readOnly  = true;
	} 
}

function submitCriteria() {
	if (!validateGroupCodeSearch(document.formAssignBinLocation.group_code,document.formAssignBinLocation.group_desc)) {
		return;
	}
	document.formAssignBinLocation.submit();
}
