/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.document.location.href="../../eSS/jsp/GroupFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query(){
	f_query_add_mod.document.location.href="../../eSS/jsp/GroupQueryCriteria.jsp?function_id="+function_id; 
}

function onSuccess(){
	var mode = f_query_add_mod.frameGroup.document.formGroup.mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else 
		f_query_add_mod.document.location.reload();
}

function apply(){
	var errorPage = "../../eCommon/jsp/error.jsp";
		if (f_query_add_mod.frameGroupList == null)	{
			messageFrame.location.href = errorPage+"?err_num=";
		return;
		
	}

	totalCBox=parseInt(f_query_add_mod.frameGroupList.document.formGroupList.total_checkboxes.value)

	var checkBoxObj=null;
	var item_qty=null;
	var forDeletion=""
	var checklist = f_query_add_mod.frameGroupList.document.formGroupList.checklist.value;
	
	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameGroupList.document.formGroupList.checkbox"+i);
		if(checklist=="Y")
		item_qty = eval("f_query_add_mod.frameGroupList.document.formGroupList.item_qty_"+i).value;
		
		if(checkBoxObj.checked)
			forDeletion+=("Y,");
		else{
			forDeletion+=("N,");
		if(checklist=="Y")
			{
		if(item_qty==0)
				{
				messageFrame.location.href = errorPage+"?err_num="+"  APP-ST0176 Quantity should be greater than zero for the Items selected";
				return;
				}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		// xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/GroupValidate.jsp?item_qty=" +item_qty+"&index="+i+ "&validate=MODIFY_QTY", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;

			}
		}
	}
	forDeletion=forDeletion.substring(0,forDeletion.length-1);
	var formObj		=	f_query_add_mod.frameGroup.document.formGroup ;
	if((!formObj.pack_item_desc.readOnly)&&(!formObj.pack_item_desc.disabled)&&(formObj.pack_item_desc.value!="")){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
//		xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/GroupValidate.jsp?item_code=" + formObj.pack_item_desc.value + "&validate=PACK_ITEM_DESC", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		if(! result ) {
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag);
			return;
		}
	}

	var formObj	=  f_query_add_mod.frameGroup.document.formGroup ;

    if(!SPCheckMaxLen1('Remarks',formObj.remarks,200))
	  { 
  		   message= "REMARKS_CHAR_EXCEEDS_LIMIT" ;
           messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS"); 
           return;
		   
	  }	 
   
     
	formObj.records_to_delete.value=forDeletion;

	var fields		=	new Array ( formObj.group_code,formObj.alpha_code,formObj.long_desc,formObj.short_desc);

	var names		=	new Array ( getLabel("Common.Group.label","Common"),getLabel("eSS.AlphaCode.label","SS"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));
	var index		=	4;
	if(formObj.sterilize_reqd_yn.checked){
		names[index]=getLabel("eSS.SterilizationType.label","SS");
		fields[index++]=formObj.def_sterile_type;
	}
	if(formObj.wash_reqd_yn.checked){
		names[index]=getLabel("eSS.WashingType.label","SS");
		fields[index++]=formObj.def_washing_type;
	}
	
	var blankObject	=	null;
	
	blankObject		=	getBlankField( fields, names, messageFrame,errorPage);
	if(blankObject==null) {
		responseText=formApply(formObj,SS_CONTROLLER)
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	}
	else{
	}
	
	
}
function reset(){
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
	else //if(f_query_add_mod.frameGroupListHeader!=null) Commented by Mahesh on 12/01/2010
		f_query_add_mod.location.reload();
}

function addToList(){
	var formObj=document.formGroupDetail;
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	if((!formObj.item_desc.readOnly)&&(!formObj.item_desc.disabled)&&(formObj.item_desc.value!="")){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/GroupValidate.jsp?item_code=" + formObj.item_desc.value + "&validate=ITEM_DESC", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(! result ) {
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag,"SS");
			return;
		}
	}

	var fields = new Array ( document.formGroupDetail.item_desc, document.formGroupDetail.item_qty );
	var names  =  new Array (getLabel("Common.item.label","Common"),getLabel("eSS.ItemQty.label","Common") );
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	obj=getBlankField( fields, names, messageFrame,errorPage);
	if(obj==null) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlStr ="<root><SEARCH  /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/GroupValidate.jsp?item_code=" + document.formGroupDetail.item_code.value + "&item_qty=" + fields[1].value +"&index="+document.formGroupDetail.index.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);

		responseText=xmlHttp.responseText;

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

function refreshDetails(){

	/*top.content.master_pages.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";

	top.content.master_pages.f_query_add_mod.frameGroupDetail.document.location.href="../../eSS/jsp/GroupDetail.jsp";

	refreshList();*/
	displayMessage(top.content.messageFrame,"");
	resetGroupDetail();
	refreshList();

}

function resetGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameGroupDetail.document.formGroupDetail;
	formObj.item_desc.value="";
	formObj.item_code.value="";
	formObj.item_qty.value="";
	formObj.item_desc.disabled=false;
	formObj.item_qty.disabled=false;
	formObj.item_search_button.disabled=false;
	formObj.apply.value=getLabel("Common.Add.label","Common");
}


function refreshList(){
	//top.content.master_pages.f_query_add_mod.frameGroupList.document.location.reload();
	//top.content.f_query_add_mod.frameGroupList.document.location.reload();
	top.content.f_query_add_mod.frameGroupList.location.href="../../eSS/jsp/GroupList.jsp";
}

function listModify(index){
	parent.frameGroupDetail.location.href="../../eSS/jsp/GroupDetail.jsp?index="+index;
}

function Modify(obj){
	var group_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/GroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&group_code="+group_code;
}
async function searchPackItem(objCode,objDesc) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

   	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formGroup.locale.value;
	dataTypeArray  [0]=STRING;

	argumentArray[0] = document.formGroup.SQL_SS_ITEM_LOOKUP.value;
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
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
	} 
}
async function searchItem(objCode,objDesc) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
     
	 dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formGroupDetail.locale.value;
	dataTypeArray  [0]=STRING;

	argumentArray[0] = document.formGroupDetail.SQL_SS_ITEM_LOOKUP.value;
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

	returnedValues =await CommonLookup( getLabel("Common.item.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readOnly=true;
	} 
}

function enableSterilizationDetails(bChecked){
	if(!bChecked)
		document.formGroup.def_sterile_type.value="";
	document.formGroup.def_sterile_type.disabled=!bChecked;
}

function enableWashingDetails(bChecked){
	if(!bChecked)
		document.formGroup.def_washing_type.value="";
	document.formGroup.def_washing_type.disabled=!bChecked;
}

function enablePackingDetails(bChecked){
	if(!bChecked){
		document.formGroup.pack_item_code.value="";
		document.formGroup.pack_item_desc.value="";
		document.formGroup.pack_item_qty.value="";
		document.formGroup.pack_addl_cost.value="";
		document.formGroup.pack_item_desc.readOnly=bChecked;
	}
		document.formGroup.pack_item_code.disabled=!bChecked;
		document.formGroup.pack_item_desc.disabled=!bChecked;
		document.formGroup.pack_item_qty.disabled=!bChecked;
		document.formGroup.pack_addl_cost.disabled=!bChecked;
		document.formGroup.pack_item_search.disabled=!bChecked;
		document.formGroup.pack_item_search.disabled=!bChecked;
}

function setPackItemDetails(_item_code, _item_desc){
	var formObj=  f_query_add_mod.frameGroup.document.formGroup;
	formObj.pack_item_code.value	=	_item_code;
	formObj.pack_item_desc.value	=	_item_desc;
	formObj.pack_item_desc.readOnly	=	true;
}

function setItemDetails(_item_code, _item_desc){
	var formObj=  document.formGroupDetail;
	formObj.item_code.value		=	_item_code;
	formObj.item_desc.value		=	_item_desc;
	formObj.item_desc.readOnly	=	true;
}


async function callTextBox()
{
	
	remarks = document.formGroup.remarks.value;
	if(remarks==null) remarks="";
	retVal= await window.showModalDialog("../jsp/ItemGetRemarkPopup.jsp?remarks="+remarks,'','dialogHeight:10; dialogWidth: 19; center: 1; status: no; dialogTop :200;');
	if (!(retVal==null||retVal==""))
	{
		if(trimCheck(retVal))
			{
				document.formGroup.remarks.value=retVal;
			}
	}

}

function ChangeSubClass(obj)
{
	if (obj.value=="P")
	{
		formGroup.sub_classification_code.disabled=false;
	}
	else
	{
		formGroup.sub_classification_code.options[0].selected=true;
		formGroup.sub_classification_code.disabled=true;
	}

}

function makeVisibleWash(){
	if(formGroup.wash_reqd_yn.checked){
		document.getElementById("span1").style.visibility="visible";
	}
	else{
		document.getElementById("span1").style.visibility="hidden";
	}

}
function makeVisibleSter(){
	if(formGroup.sterilize_reqd_yn.checked){
		document.getElementById("span2").style.visibility="visible";
	}
	else{
		document.getElementById("span2").style.visibility="hidden";
	}

}

function fnCancel()
{
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	document.location.href='../../eSS/jsp/GroupDetail.jsp' ;
	parent.parent.messageFrame.location.href =errorPage ;

    
}


function SPCheckMaxLen1(lab,obj,max) {
        if(obj.value.length > max) {
           
            obj.focus();
            return false;
        }
        else
            return true;

}
function enableCheckList(obj)
{
	var flag = ""
if(obj.checked==true)
	{
if(top.content.f_query_add_mod.frameGroupList.document.formGroupList.total_checkboxes.value > 0)
		{
if(confirm("Manually added items exist. Do you want to reset the items?" ))
{
			flag = "chk";
	}else return false;
	
}
}else
	
  {
    top.content.f_query_add_mod.frameGroup.document.formGroup.checklist_code.value = ""; //Added by Rabbani #INC no:32068 on 06/12/2012
	if(top.content.f_query_add_mod.frameGroupList.document.formGroupList.total_checkboxes.value > 0)
		  {
	if(confirm("Items added through checklist exist. Do you want to reset the items?"))
	
	              {
	
		            flag = "man";
	
	             } else return false;
	
		  }
	
	}
if(obj.checked==true){
if(top.content.f_query_add_mod.frameGroupList.document.formGroupList.total_checkboxes.value == 0)
flag = "chk";
}
if(obj.checked==false){
if(top.content.f_query_add_mod.frameGroupList.document.formGroupList.total_checkboxes.value == 0)
flag = "man";
}
//document.formGroup.pack_addl_cost.value
change_jsp(flag);
}
function change_jsp(flag)
{
	
	if(flag=='chk')
	{
document.formGroup.checklist_search_button.disabled=false;
document.formGroup.checklist_desc.readOnly=false;
document.formGroup.mandtory_gif.style.visibility='visible';
top.content.f_query_add_mod.document.getElementById("check").rows = "*,55%,0%";
top.content.f_query_add_mod.frameGroupDetail.location.href="../../eCommon/html/blank.html";
top.content.f_query_add_mod.frameGroupList.location.href="../../eSS/jsp/GroupList.jsp?checklist=Y"+"&checklist_desc="+document.formGroup.checklist_desc.value;
	}

	if(flag=='man')
	{
     document.formGroup.checklist_search_button.disabled=true;
     document.formGroup.checklist_desc.readOnly=true;
     document.formGroup.checklist_desc.value="";
	 document.formGroup.mandtory_gif.style.visibility='hidden';
	 top.content.f_query_add_mod.document.getElementById("check").rows = "*,40%,15%";
	 top.content.f_query_add_mod.frameGroupDetail.location.href="../../eSS/jsp/GroupDetail.jsp";
if(top.content.f_query_add_mod.frameGroupList.document.formGroupList.total_checkboxes.value > 0)
			{
top.content.f_query_add_mod.frameGroupList.location.href="../../eSS/jsp/GroupList.jsp?checklist=N"+"&checklist_desc="+document.formGroup.checklist_desc.value;
			}else 
        	top.content.f_query_add_mod.frameGroupList.location.href="../../eSS/jsp/GroupList.jsp";
			}
}
async function searchCheckList(objCode,objDesc)
{
var search_string = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

   	/*dataNameArray  [0]="CHECKLIST_DESC"
	dataValueArray [0]=document.KitTemplateAddModifyform.locale.value;
	dataTypeArray  [0]=STRING;*/
	argumentArray[0] = "SELECT CHECKLIST_CODE code, CHECKLIST_DESC description FROM  SS_CHECKLIST  WHERE  eff_status ='E'  AND CHECKLIST_CODE  LIKE UPPER(?)  AND UPPER(CHECKLIST_DESC) LIKE UPPER(?)  ORDER BY 2";
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

	returnedValues = await CommonLookup("CheckList", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
    	var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		// xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/GroupValidate.jsp?&checklist_code=" + returnedValues[0] + "&validate=CHECKLIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		//alert(responseText);
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		if(result)
		{
		top.content.f_query_add_mod.frameGroupList.location.href="../../eSS/jsp/GroupList.jsp?checklist=Y"+"&checklist_desc="+document.formGroup.checklist_desc.value;
		}
		if(! result ) {
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(flag,"SS");
			return;
		}
	}

	}
