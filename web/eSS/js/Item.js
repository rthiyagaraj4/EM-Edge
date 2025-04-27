/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href="../../eSS/jsp/ItemAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/ItemQueryCriteria.jsp?function_id="+function_id;
}

function apply() 
{
	if(!proceedOnApply())
    {
	
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
	var formObj		=	f_query_add_mod.document.formItem ;
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	if((!formObj.item_desc.readOnly)&&(!formObj.item_desc.disabled)&&(formObj.item_desc.value!=""))
	{
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/ItemValidate.jsp?item_code=" + formObj.item_desc.value + "&validate=ITEM_DESC", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(! result ) 
		{
			
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag,"ss");
			return;
		}
	}
	var fields		=	new Array ( formObj.item_desc);
	var names		=	new Array (getLabel("Common.item.label","Common") );
	var blankObject	=	null;
	if (f_query_add_mod.checkSSFields( fields, names, messageFrame))
	{
		eval(formApply(formObj,SS_CONTROLLER));
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result )
		{
			onSuccess();
		}
	}
	else
	{
		formObj.item_search.focus();
	}
}
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("itemquery")==-1) )
        return true;
    else
        return false;
}
function formFocus(){
	
	if(document.formItem.mode.value==MODE_INSERT){
		document.formItem.item_search.focus();
	}
	else{
        if(document.formItem.item_image_file_name.disabled==false)
		  document.formItem.item_image_file_name.focus();
	}
}

function reset() {
	if(f_query_add_mod.document.formItem!=null){
		f_query_add_mod.document.formItem.reset();
		f_query_add_mod.document.formItem.item_desc.readOnly=false;
	}
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function onSuccess() {
	var mode = f_query_add_mod.document.formItem.mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else 
		f_query_add_mod.document.location.reload();
}

function Modify(obj){
	var item_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/ItemAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&item_code="+item_code;
}

async function searchItem(objCode,objDesc) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formItem.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[0] = document.forms[0].SQL_SS_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	if(objDesc.readOnly)
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.item.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readOnly=true;
	} 
}

function setItemDetails(_item_code, _item_desc){
	var formObj=  f_query_add_mod.document.formItem;
	formObj.item_code.value		=	_item_code;
	formObj.item_desc.value		=	_item_desc;
	formObj.item_desc.readOnly	=	true;
}
