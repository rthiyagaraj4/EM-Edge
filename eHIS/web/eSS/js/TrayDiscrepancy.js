
function create(){
	f_query_add_mod.location.href="../../eSS/jsp/TrayDiscrepancyFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function reset() {
	f_query_add_mod.location.reload();
}

function apply() {

	if( f_query_add_mod.frameTrayDiscrepancyList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}

	totalCBox=parseInt(f_query_add_mod.frameTrayDiscrepancyList.document.formTrayDiscrepancyList.total_checkboxes.value)
	var checkBoxObj=null;
	var forDeletion=""
	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameTrayDiscrepancyList.document.formTrayDiscrepancyList.checkbox"+i);
		if(checkBoxObj.checked)
			forDeletion+=("Y,");
		else
			forDeletion+=("N,");
	}
	forDeletion=forDeletion.substring(0,forDeletion.length-1);

	var formObj		=	f_query_add_mod.frameTrayDiscrepancyHeader.document.formTrayDiscrepancyHeader ;
	formObj.records_to_delete.value=forDeletion;
	var blankObject	=	null;
	var fields		=	new Array(formObj.store_code, formObj.group_desc, formObj.tray_no);
	var fieldNames	=	new Array(getLabel("Common.Store.label","Common"), getLabel("Common.Group.label","Common"), getLabel("eSS.TrayNo.label","SS"));

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField1( fields, fieldNames, messageFrame);
	if(blankObject==null) {
		
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
           errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(legends[i])))+"<br>";
		
        }
    }
    if ( errors.length != 0 ) {
        messageFrame.location.href=errorPage+"?err_num="+errors;
    }
        return obj ;
}

function disableHeader(){
	document.formTrayDiscrepancyHeader.store_code.disabled=true;
	document.formTrayDiscrepancyHeader.tray_no.disabled=true;
	document.formTrayDiscrepancyHeader.tray_search.disabled=true;
	document.formTrayDiscrepancyHeader.group_desc.disabled=true;
	document.formTrayDiscrepancyHeader.group_search.disabled=true;
	document.formTrayDiscrepancyHeader.group_type.disabled=true;
}

async function checkTrayNo(obj){
	if(checkIntegerFormat(obj)){
		await populateDiscrepancyDetail();
	}
}

function populateDiscrepancyDetail(){
	var formObj		=	document.formTrayDiscrepancyHeader ;
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	if(formObj.tray_no.value=="")return;

	if((!formObj.group_desc.readOnly)&&(!formObj.group_desc.disabled)&&(formObj.group_desc.value!="")){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/TrayDiscrepancyValidate.jsp?group_code=" + formObj.group_desc.value + "&group_type="+formObj.group_type.value+"&validate=GROUP_DESC", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(! result ) {
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag,"SS");
			return;
		}
	}

	var fields		=	new Array(formObj.store_code, formObj.group_desc, formObj.tray_no);
	var fieldNames	=	new Array(getLabel("Common.Store.label","Common"), getLabel("Common.Group.label","Common"), getLabel("eSS.TrayNo.label","SS"));
	
	var group_code	=	formObj.group_code.value;
	if(checkFieldsofMst( fields, fieldNames, parent.parent.messageFrame,errorPage)) {
	
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		clearListItems("parent.frameTrayDiscrepancyDetail.document.formTrayDiscrepancyDetail.item_code");
		var xmlString = getXMLString(null);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
 		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/TrayDiscrepancyValidate.jsp?validate=POPULATE_DISCREPANCY&group_code=" + formObj.group_code.value+"&store_code=" + formObj.store_code.value+"&tray_no=" + formObj.tray_no.value, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(!result){
			alert(getMessage(message,"SS"));
			formObj.tray_no.focus();
		}
	}
}

function onSuccess(){
	f_query_add_mod.document.location.reload();
}


/*function searchGroupCode( objCode, objDesc ) {
	var prev_value	=	objCode.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	
	dataNameArray[0] = "group_type";

	dataValueArray[0]= escape(document.formTrayDiscrepancyHeader.group_type.value);
	dataTypeArray[0] = STRING;

	dataNameArray[1] = "locale";
	dataValueArray[1]= escape(document.formTrayDiscrepancyHeader.locale.value);
	dataTypeArray[1] = STRING;

	argumentArray[0] = document.forms[0].SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE.value;

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

	returnedValues = CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );

	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly= true;
		  document.formTrayDiscrepancyHeader.all.details.disabled = false;
		  document.formTrayDiscrepancyHeader.all.details.style.cursor = "hand";
	} 
}*/

//Added by Sakti against SCF inc#42391
async function searchGroupCode( objCode, objDesc ) {
	
	var formObj		=	document.formTrayDiscrepancyHeader ;
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var index=0;
	
	fields[index]		=	formObj.store_code;
	fieldNames[index++]	=	getLabel("Common.Store.label","Common");
	

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);

	if(blankObject==null) {
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();

		dataNameArray[0] = "group_type";
		dataValueArray[0]= document.formTrayDiscrepancyHeader.group_type.value;
		dataTypeArray[0] = STRING;
		
		dataNameArray[1] = "language_id";
		dataValueArray[1]= document.formTrayDiscrepancyHeader.locale.value;
		dataTypeArray[1] = STRING;

		dataNameArray[2] = "store_code";
		dataValueArray[2]= document.formTrayDiscrepancyHeader.store_code.value;
		dataTypeArray[2] = STRING;
		
		
		argumentArray[0] = document.formTrayDiscrepancyHeader.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_TRAYDISCREPENCY.value;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "4,5";
		/*if (objDesc.readOnly) commented for KDAH-SCF-0329 [IN:057314];
		argumentArray[5] = "";
		 else*/
			argumentArray[5] = objDesc.value;
			
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
		
		returnedValues = await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
		var str =unescape(returnedValues);
		var arr = str.split(",");
		if((returnedValues != null) && (returnedValues != "") )  {
			objCode.value = arr[0];
			objDesc.value = arr[1];

			objDesc.readOnly=true;
			document.formTrayDiscrepancyHeader.store_code.disabled = true;
			document.getElementById('details').disabled = false;
			document.getElementById('details').style.cursor = "hand";
			params = document.formTrayDiscrepancyHeader.params.value; //Added for KDAH-SCF-0329 [IN:057314]
			parent.frameTrayDiscrepancyDetail.location.href="../../eSS/jsp/TrayDiscrepancyDetail.jsp?"+params+"&group_code="+objCode.value ; //Added for KDAH-SCF-0329 [IN:057314]
		} 
	}
	else{
		blankObject.focus();
	}
}//Added ends

async function searchTrayNo(){
	var formObj = document.formTrayDiscrepancyHeader;
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	if((!formObj.group_desc.readOnly)&&(!formObj.group_desc.disabled)&&(formObj.group_desc.value!="")){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/TrayDiscrepancyValidate.jsp?group_code=" + formObj.group_desc.value +"&group_type="+formObj.group_type.value+ "&validate=GROUP_DESC", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(! result ) {
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag,"SS");
			return;
		}
	}
	var group_code	=	formObj.group_code.value;
	var group_desc	=	formObj.group_desc.value;
	var store_code	=	formObj.store_code.value;

	var fields		=	new Array(formObj.store_code, formObj.group_desc);
	var fieldNames	=	new Array(getLabel("Common.Store.label","Common"), getLabel("Common.Group.label","Common"));
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);

	if((group_code=="")||(store_code==""))return;
	if(formObj.tray_no.value!="")return;

	var dialogHeight= "70vh" ;
    var dialogWidth = "50vw" ;
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/TrayDiscrepancyTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+formObj.tray_no.value+"&group_code="+group_code+"&group_desc="+group_desc+"&store_code="+store_code+"&tray_no="+formObj.tray_no.value;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		formObj.tray_no.value=returnVal;
		formObj.tray_no.focus();
	}
}
function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    top.window.returnValue = tray_no;
	top.close();
	/*let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = tray_no;
    
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();   */
}

async function addToList(){
	var formObj=  document.formTrayDiscrepancyDetail;
	var formObj1=parent.frameTrayDiscrepancyHeader.document.formTrayDiscrepancyHeader;//Added for KDAH-SCF-0329 [IN:057314]
	var fields = new Array ( formObj.item_code, formObj.write_off_reason_code, formObj.discrepancy_qty, formObj1.tray_no);
	var names  =  new Array ( getLabel("eSS.Instrument.label","SS"),getLabel("Common.reason.label","Common"), getLabel("Common.Quantity.label","Common") , getLabel("eSS.TrayNo.label","SS"));
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp";
	obj=getBlankField( fields, names, messageFrame,errorPage);
	if(obj==null) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_desc	=	formObj.item_code.options[formObj.item_code.selectedIndex].text;
		var write_off_reason_desc =	formObj.write_off_reason_code.options[formObj.write_off_reason_code.selectedIndex].text;
		var xmlString = getXMLString(null);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		//xmlDoc.loadXML(getXMLString(null));
		//xmlHttp.open("POST", "../../eSS/jsp/TrayDiscrepancyValidate.jsp?item_code=" + formObj.item_code.value + "&write_off_reason_code=" + formObj.write_off_reason_code.value+ "&write_off_reason_desc=" + write_off_reason_desc+"&item_desc=" + item_desc+ "&discrepancy_qty=" + formObj.discrepancy_qty.value + "&discrepancy_type=" + formObj.discrepancy_type.value+ "&group_code=" + parent.frameTrayDiscrepancyHeader.document.formTrayDiscrepancyHeader.group_code.value + "&tray_no=" + parent.frameTrayDiscrepancyHeader.document.formTrayDiscrepancyHeader.tray_no.value + "&charge_amt=" + formObj.charge_amt.value +"&remarks=" + escape(formObj.remarks.value) +"&index="+formObj.index.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.open("POST", "../../eSS/jsp/TrayDiscrepancyValidate.jsp?" +
			    "item_code=" + encodeURIComponent(formObj.item_code.value) +
			    "&write_off_reason_code=" + encodeURIComponent(formObj.write_off_reason_code.value) +
			    "&write_off_reason_desc=" + encodeURIComponent(write_off_reason_desc) +
			    "&item_desc=" + encodeURIComponent(item_desc) +
			    "&discrepancy_qty=" + encodeURIComponent(formObj.discrepancy_qty.value) +
			    "&discrepancy_type=" + encodeURIComponent(formObj.discrepancy_type.value) +
			    "&group_code=" + encodeURIComponent(parent.frameTrayDiscrepancyHeader.document.formTrayDiscrepancyHeader.group_code.value) +
			    "&tray_no=" + encodeURIComponent(parent.frameTrayDiscrepancyHeader.document.formTrayDiscrepancyHeader.tray_no.value) +
			    "&charge_amt=" + encodeURIComponent(formObj.charge_amt.value) +
			    "&remarks=" + encodeURIComponent(formObj.remarks.value) +
			    "&index=" + encodeURIComponent(formObj.index.value) +
			    "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if( result ) {
			await refreshDetails();
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
	else
		obj.focus();
}

function listModify(index){
	parent.frameTrayDiscrepancyDetail.location.href="../../eSS/jsp/TrayDiscrepancyDetail.jsp?index="+index+"&function_id="+parent.parent.function_id+"&group_code="+parent.frameTrayDiscrepancyHeader.document.formTrayDiscrepancyHeader.group_code.value;
}

async function refreshDetails(){
	displayMessage(top.content.messageFrame,"");
	await resetTrayDiscrepancyDetail();
	await refreshList();
}

function resetTrayDiscrepancyDetail(){
	var formObj=top.content.f_query_add_mod.frameTrayDiscrepancyDetail.document.formTrayDiscrepancyDetail;
	formObj.item_code.value="";
	formObj.write_off_reason_code.value="";
	formObj.item_code.disabled=false;
	formObj.write_off_reason_code.disabled=false;
	formObj.remarks.value="";
	formObj.remarks.readOnly=false;
	formObj.discrepancy_qty.value="";
	formObj.discrepancy_qty.disabled=false;
	formObj.discrepancy_type.value="N";
	formObj.discrepancy_type.disabled=false;
	formObj.charge_amt.value="";
	formObj.index.value="-1";
	formObj.apply.value="  Add  ";
	formObj.apply.disabled=false;
	displayMessage(top.content.messageFrame,"");
}

function refreshList(){
	top.content.f_query_add_mod.frameTrayDiscrepancyList.document.location.reload();
}

function setGroupDetails(_group_code, _description){
	var formObj=  document.formTrayDiscrepancyHeader;
	formObj.group_code.value	=	_group_code;
	formObj.group_desc.value	=	_description;
	formObj.group_desc.readOnly	=	true;
}

function populateCost(item_code,desc_qty){
	if(desc_qty!="" && item_code!=""){
		var formObj		=	top.content.f_query_add_mod.frameTrayDiscrepancyHeader.formTrayDiscrepancyHeader ;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();	
 		//xmlDoc.loadXML(getXMLString(null));
		
		xmlHttp.open("POST", "../../eSS/jsp/TrayDiscrepancyValidate.jsp?validate=POPULATE_COST&group_code=" + formObj.group_code.value+"&store_code=" + formObj.store_code.value+"&desc_qty=" + desc_qty+"&item_code="+item_code, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(!result){
			alert(getMessage(message,"SS"));
			formObj.tray_no.focus();
		}
	}
}

async function details(){
    var group_code		=	document.formTrayDiscrepancyHeader.group_code.value;
	var group_desc		=	document.formTrayDiscrepancyHeader.group_desc.value;
    if(group_code!=""){
		var dialogHeight = "50vh" ;
		//var dialogWidth	= "24" ;
		var dialogWidth	= "50vw" ;
		var dialogTop = "10" ;
		var center = "1" ;
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
		var arguments = "" ;
		var title="Request Detail";
		var params = "group_code="+group_code+"&group_desc="+group_desc;
		retVal = await window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}
}
