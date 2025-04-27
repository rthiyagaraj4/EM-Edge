/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/WriteOffGroupFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&menu_id="+menu_id+"&module_id="+module_id ;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/WriteOffGroupQueryFrame.jsp?function_id="+function_id ;
}

function onSuccess(){
	var mode = f_query_add_mod.frameWriteOffGroupHeader.document.formWriteOffGroupHeader.mode.value;
	if( mode == MODE_INSERT ) {
		reset();
	}
	else if( (mode == MODE_DELETE)||(f_query_add_mod.frameWriteOffGroupHeader.document.formWriteOffGroupHeader.finalized.value=="Y")) 
		f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
	else
		f_query_add_mod.document.location.reload();
}

function reset() {
	if(f_query_add_mod.frameWriteOffGroupQueryCriteria!=null){
		f_query_add_mod.frameWriteOffGroupQueryCriteria.document.formWriteOffGroupQueryCriteria.reset();
		f_query_add_mod.frameWriteOffGroupQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameWriteOffGroupHeader!=null){
		f_query_add_mod.location.reload();
	}
}


async function deleterecord(){
	
	var formObj	=	f_query_add_mod.frameWriteOffGroupHeader.document.formWriteOffGroupHeader;
	if(formObj.mode.value==MODE_MODIFY){
		
		var confirmation = await confirmDelete();
		if(confirmation=="Yes"){
			formObj.mode.value=MODE_DELETE;
			eval(formApply(formObj,SS_CONTROLLER));
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

async function apply(){

totalCBox=parseInt(f_query_add_mod.frameWriteOffGroupList.document.formWriteOffGroupList.total_checkboxes.value)

	var checkBoxObj=null;
	var forDeletion=""
	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameWriteOffGroupList.document.formWriteOffGroupList.checkbox"+i);
		if(checkBoxObj.checked)
			forDeletion+=("Y,");
		else
			forDeletion+=("N,");
	}
	forDeletion=forDeletion.substring(0,forDeletion.length-1);

	var formObj		=	f_query_add_mod.frameWriteOffGroupHeader.document.formWriteOffGroupHeader ;
	formObj.records_to_delete.value=forDeletion;
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var	index		=	0;
	var queryString =	"";
	fields[index]		=	formObj.doc_type_code;
	fieldNames[index++]	=	getLabel("Common.DocType.label","Common");
	if(!formObj.doc_no.disabled){
		fields[index]		=	formObj.doc_no;
		fieldNames[index++]	=	getLabel("eSS.DocNo.label","SS");
	}
	fields[index]		=	formObj.doc_date;
	fieldNames[index++]	=	getLabel("eSS.DocDate.label","SS");
	fields[index]		=	formObj.store_code;
	fieldNames[index++]	=	getLabel("eSS.StoreCode.label","SS");


	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField1( fields, fieldNames, messageFrame);

	if(blankObject==null) {
		if(formObj.entry_completed_yn.checked){
		/*if (formObj.SS_WRITE_OFF_GROUP_FINALIZE!=null)
		if(formObj.entry_completed_yn.checked && (formObj.SS_WRITE_OFF_GROUP_FINALIZE.value=="Y")){
			
			var confirmation = confirmFinalize(); Commented by Sakti  since we have finalize in function level AAKH_SCF_158
		}*/
		var confirmation = await confirmFinalize();
			if(confirmation=="Yes"){
				formObj.finalized.value="Y";
			}
			else if(formObj.entry_completed_yn.disabled){
				messageFrame.location.href = errorPage+"?err_num="+ getMessage("OPERATION_CANCELLED","SS");
				return;
			}
		}

		eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		
		messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ flag;
		if( result ) {
			onSuccess();
		}
	}
	else{
		blankObject.focus();
	}

}
function getBlankField1( fields, legends, messageFrame, errorPage) {
    var obj=null;
    var errors = "" ;
    if (errorPage==null) {
        errorPage = "../../eCommon/jsp/error.jsp"
    }
    for( var i=0;i<fields.length; i++ )
    {
        if(trimCheck(fields[i].value))
            fields[i].value = trimString(fields[i].value);
        else
        {
            if(obj==null)
                obj=fields[i];
			//Following line should be replaced in common.js. otherwise local methods only can be used.===>added by sukkur.
           errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(legends[i])))+"<br>"
        }
    }
    if ( errors.length != 0 ) {
        messageFrame.location.href=errorPage+"?err_num="+errors;
    }
        return obj ;
}
function checkDoc_type_code(){
	if(document.formWriteOffGroupHeader.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/WriteOffGroupValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formWriteOffGroupHeader.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
}

function quantityAlert(_total_quantity, _sterilized_quantity, _unsterilized_quantity){
	alert("WARNING! Available Quantity is "+_total_quantity+" (Sterilized = "+_sterilized_quantity+", Unsterilized = "+_unsterilized_quantity+")");
}

function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/WriteOffGroupValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	refreshList();
}

function enableDocNo(bValue){
	if(!bValue){
		parent.frameWriteOffGroupHeader.document.formWriteOffGroupHeader.doc_no.value="";	
	}
	parent.frameWriteOffGroupHeader.document.formWriteOffGroupHeader.doc_no.disabled=!bValue;
}

function addToList(){
	var formObj=  document.formWriteOffGroupDetail;
	var fields = new Array ( formObj.description, formObj.tray_no, formObj.writeoff_reason);
	var names  =  new Array ( getLabel("Common.Group.label","Common"),getLabel("eSS.TrayNo.label","SS"),getLabel("eSS.WriteoffReason.label","SS") );
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	obj=getBlankField( fields, names, messageFrame,errorPage);

	var desc=formObj.writeoff_reason.options[document.forms[0].writeoff_reason.selectedIndex].text;

	if(obj==null) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/WriteOffGroupValidate.jsp?group_code=" + formObj.group_code.value + "&group_type=" + formObj.group_type.value +"&tray_no=" + formObj.tray_no.value +"&write_off_reason_code=" + formObj.writeoff_reason.value +"&index="+formObj.index.value+ "&description="+formObj.description.value+ "&remarks="+formObj.remarks.value+"&write_off_cost="+formObj.write_off_cost.value+ "&write_off_reason_desc="+desc+ "&store_code="+parent.frameWriteOffGroupHeader.document.formWriteOffGroupHeader.store_code.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText=responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
		eval(responseText);
		if( result ) {
			refreshDetails();
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
	else
		obj.focus();
}

async function searchGroupCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formWriteOffGroupDetail.group_type.value;
	dataTypeArray[0] = STRING;

	dataNameArray[1] = "locale";
	dataValueArray[1]= escape(document.formWriteOffGroupDetail.locale.value);
	dataTypeArray[1] = STRING;

	argumentArray[0] = document.formWriteOffGroupDetail.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE.value;

	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	if (objDesc.readOnly) 
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
		objDesc.readOnly=true; 
		document.formWriteOffGroupDetail.group_type.disabled=true;
		
	} 
}

function clearGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameWriteOffGroupDetail.document.formWriteOffGroupDetail;
	
	formObj.description.readOnly=false;
	formObj.description.disabled=false;
	formObj.group_code.value="";

}

function resetGroupDetail(){

	var formObj = top.content.f_query_add_mod.frameWriteOffGroupDetail.document.formWriteOffGroupDetail;

    formObj.group_type.disabled=false ;
	formObj.group_type.value="E";
	formObj.description.value="";
	formObj.description.disabled=false;
	formObj.description.readonly=false;
	formObj.description.disabled=false;
	formObj.group_search.disabled=false;
	formObj.group_code.value="";
	formObj.tray_no.disabled=false;
	formObj.tray_no.value="";
	formObj.tray_no.readonly=false ;
	formObj.tray_search.disabled=false ;
	formObj.writeoff_reason.value="";
	formObj.write_off_cost.value="";
	formObj.remarks.value="";
    formObj.write_off_cost.value="";
    formObj.write_off_cost.readonly=false;
	formObj.index.value="-1";
	formObj.apply.value="  Add  ";
}

function refreshDetails(){
	displayMessage(top.content.messageFrame,"");
	resetGroupDetail();
	refreshList();
}

function refreshList(){
	top.content.f_query_add_mod.frameWriteOffGroupList.document.location.reload();
}

function listModify(index){
	parent.frameWriteOffGroupDetail.location.href="../../eSS/jsp/WriteOffGroupDetail.jsp?index="+index;
}

function Modify(obj){
	var doc_type_code=obj.cells[5].innerText;
	var doc_no=obj.cells[1].innerText;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/WriteOffGroupFrame.jsp?mode="+MODE_MODIFY+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no;
}


async function searchTrayNo(){
	
	var formObj = document.formWriteOffGroupDetail;
	var group_code	=	formObj.group_code.value;
	formObj.description.disabled=true;
	formObj.group_search.disabled=true;
    var store_code	=	parent.frameWriteOffGroupHeader.document.formWriteOffGroupHeader.store_code.value ;

	var group_desc	=	formObj.description.value;//options[formObj.description.options.selectedIndex].text;
	if(group_code=="")	return;

	var dialogHeight= "450px;" ;
	
    var dialogWidth = "700px;" ;
   
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/WriteOffGroupTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+formObj.tray_no.value+"&group_code="+group_code+"&group_desc="+group_desc+"&store_code="+store_code ;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		formObj.tray_no.value=returnVal;
		parent.frameWriteOffGroupHeader.formWriteOffGroupHeader.store_code.disabled=true;
		formObj.tray_no.focus();
	}
}

function searchTrayDetail( objCode, objDesc ) {
	
var formObj	= document.forms[0];
	if(formObj.tray_no.value==""){
		clearTrayDetails();
		return;
	}

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/WriteOffGroupValidate.jsp?validate=TRAY_DETAIL&tray_no="+formObj.tray_no.value+"&group_code="+formObj.group_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText=responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
	eval(responseText);
	
	if(!result){
		alert(getMessage(flag));
		formObj.tray_no.select();
		formObj.tray_no.focus();
	}
	} 

	function clearTrayDetails(){
	document.formWriteOffGroupDetail.tray_no.value="";

}

function setTrayDetail(tray_no, bin_location_code, expiry_date){
	var formObj = top.content.f_query_add_mod.frameWriteOffGroupDetail.document.formWriteOffGroupDetail;
	formObj.tray_no.value=tray_no;

}

function setWriteOffCost(write_off_value) {
	var formObj = top.content.f_query_add_mod.frameWriteOffGroupDetail.document.formWriteOffGroupDetail;
	formObj.write_off_cost.value=write_off_value;
}

async function searchWriteOffReason(objCode, objDesc){

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formWriteOffGroupDetail.SS_WRITE_OFF_REASON_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( "WriteOff", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}
function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    top.window.returnValue = tray_no;
    top.close();
}

function listModify1(index)
{
	parent.frameWriteOffGroupHeader.formWriteOffGroupHeader.store_code.disabled=true;
    listModify(index);
}

function clickModify()
{

  addToList();
 
}

function clickAdd()
{
  parent.frameWriteOffGroupHeader.formWriteOffGroupHeader.store_code.disabled=true;
  addToList();
}
