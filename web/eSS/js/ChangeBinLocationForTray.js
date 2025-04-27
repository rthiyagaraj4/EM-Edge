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
var xmlDoc;
var xmlHttp;

function reset() {
	if (f_query_add_mod.frameChangeBinLocationForTrayQueryCriteria != null) {
		//f_query_add_mod.frameChangeBinLocationForTrayQueryCriteria.document.formChangeBinLocationForTrayQueryCriteria.reset();
		//f_query_add_mod.frameChangeBinLocationForTrayQueryCriteria.document.formChangeBinLocationForTrayQueryCriteria.group_desc.readOnly = false;
		//return;
	
	f_query_add_mod.frameChangeBinLocationForTrayQueryCriteria.document.formChangeBinLocationForTrayQueryCriteria.reset();
	f_query_add_mod.frameChangeBinLocationForTrayQueryResult.location.reload();
	}
}

function query(){
	//alert("entering into querymode");
	f_query_add_mod.location.href="../../eSS/jsp/ChangeBinLocationForTrayQueryFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

function onSuccess(){
	f_query_add_mod.location.reload();
}

function apply(){
	errorPage="../../eCommon/jsp/error.jsp";
	if (f_query_add_mod.location.href.indexOf(".jsp")!=-1){
		if (f_query_add_mod.frameChangeBinLocationForTrayQueryResult.location.href.indexOf(".jsp")!=-1)
		{
		
		var formObj		=	f_query_add_mod.frameChangeBinLocationForTrayQueryResult.formChangeBinLocationForTrayQueryResult;
		var responseText=formApply(formObj,SS_CONTROLLER);
		//alert(responseText);
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
					
					messageFrame.location.href = errorPage+"?err_num="+ message;
					if( result ) {
							onSuccess();
					}	
		}
		else
			messageFrame.location.href = errorPage+"?err_num=";
	}
	else
		messageFrame.location.href = errorPage+"?err_num=";
}

async function Modify(obj,group_code,owner_store_code,new_bin_location_code,bin_location_code,index){
	var formObj=document.formChangeBinLocationForTrayQueryResult;
	
	var store_desc =obj.cells[0].innerText;
	var group_desc =obj.cells[1].innerText;
	var tray_no =obj.cells[2].innerText;
	var bin_desc =obj.cells[3].innerText;
	
	var dialogHeight	= "250px";
	var dialogWidth	= "450px" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no; scrolling=no;" ;
	var arguments	= "" ;
	//var params = "&group_code="+group_code+"&tray_no="+tray_no+"&owner_store_code="+owner_store_code+"&new_bin_location_code="+new_bin_location_code+"&mode="+formObj.mode.value+"&store_desc="+encodeURIComponent(store_desc)+"&group_desc="+group_desc+"&bin_desc="+bin_desc+"&bin_location_code="+bin_location_code;
	//Added by Rabbani #Inc no:42469 on 28-AUG-13 
	var params = "&group_code="+group_code+"&tray_no="+tray_no+"&owner_store_code="+owner_store_code+"&new_bin_location_code="+new_bin_location_code+"&mode="+formObj.mode.value+"&store_desc="+encodeURIComponent(store_desc)+"&group_desc="+encodeURIComponent(group_desc)+"&bin_desc="+bin_desc+"&bin_location_code="+bin_location_code;
	

	retVal = await window.showModalDialog("../../eSS/jsp/ChangeBinLocationModifynewBinLoc.jsp?"+params,arguments,features);
		if(retVal!="" && retVal!=undefined){
			arrayVal=retVal.split("`");
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../eSS/jsp/ChangeBinLocationForTrayValidate.jsp?&function_type=3&index="+index+"&new_bin_location_code="+arrayVal[0]+"&new_bin_location_code_desc="+arrayVal[1], false);
			xmlHttp.send(xmlDoc);
			
			window.location.reload();
		}
}

function addBinLocationData(objOwner_store_code) {
	//alert("ENTERING INTO FUNCTION");
	
		if(objOwner_store_code.value != "") {
			
		var arrayObject = new Array();
		arrayObject[0] = objOwner_store_code;
		assignBean();
		
		xmlStr = getXMLString(arrayObject);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		//xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../eSS/jsp/ChangeBinLocationForTrayValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		//alert(responseText);
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		}
		else{
		clearListItems('formChangeBinLocationForTrayQueryCriteria.bin_location_code'); 
		clearListItems('formChangeBinLocationForTrayQueryCriteria.new_bin_location_code'); 
		
		}
		//parent.frames[1].document.location.href="../../eCommon/html/blank.html";
}

function assignBean() {
	bean_id = document.formChangeBinLocationForTrayQueryCriteria.bean_id.value;
	bean_name = document.formChangeBinLocationForTrayQueryCriteria.bean_name.value;
	
	
	xmlDoc = "";
	//xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	xmlHttp = new XMLHttpRequest();
	
}


async function searchCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "locale";
	dataValueArray[0]= document.formChangeBinLocationForTrayQueryCriteria.locale.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.formChangeBinLocationForTrayQueryCriteria.SQL_SS_GROUP_LOOKUP.value;
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

	returnedValues = await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly = true;
	} 
}

function submitCriteria() {
	formObj=parent.frames[0].formChangeBinLocationForTrayQueryCriteria;
	
	if(formObj.new_bin_location_code.value!=""){
	var new_bin_location_desc=formObj.new_bin_location_code.options[formObj.new_bin_location_code.options.selectedIndex].text;
	formObj.new_bin_location_desc.value=new_bin_location_desc;
	}
	else
		formObj.new_bin_location_desc.value="";
	if (!validateGroupCodeSearch(document.formChangeBinLocationForTrayQueryCriteria.group_code,document.formChangeBinLocationForTrayQueryCriteria.group_desc)) {
		return;
	}

	var params = "group_code="+formObj.group_code.value+"&tray_no="+formObj.tray_no.value+"&owner_store_code="+formObj.owner_store_code.value+"&new_bin_location_code="+formObj.new_bin_location_code.value+"&bin_location_code="+formObj.bin_location_code.value+"&doc_type_code=" + formObj.doc_type_code.value + "&doc_no=" + formObj.doc_no.value+ "&function_type=2&new_bin_location_desc="+formObj.new_bin_location_desc.value+"&mode="+formObj.mode.value+"&locale="+formObj.locale.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/ChangeBinLocationForTrayValidate.jsp?"+params, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "") ;
   //alert(responseText);
	parent.frames[1].document.location.href="../../eSS/jsp/ChangeBinLocationForTrayQueryResult.jsp?"+params;
}

function closeWindow(){
	window.parent.parent.returnValue="";
//window.parent.window.close();
	parent.document.getElementById("dialog_tag").close(); 
}
   
function validateBinLocBean(){
formObj=document.formChangeBinLocationForTrayModifyBinLoc;
var new_bin_location_desc;
	
	if(formObj.new_bin_location_code.value!=""){
		new_bin_location_desc=formObj.new_bin_location_code.options[formObj.new_bin_location_code.options.selectedIndex].text;
		formObj.new_bin_location_desc.value=new_bin_location_desc;
	}
	else
		formObj.new_bin_location_desc.value="";


		
	//window.parent.parent.returnValue=formObj.new_bin_location_code.value+"`"+formObj.new_bin_location_desc.value;
	parent.document.getElementById('dialog-body').contentWindow.returnValue=formObj.new_bin_location_code.value+"`"+formObj.new_bin_location_desc.value;
	parent.document.getElementById("dialog_tag").close(); 
//	window.parent.close();
}

function checkBinLoc(){
	formObj=document.formChangeBinLocationForTrayModifyBinLoc;
	
	if(formObj.bin_location_code.value!="" && formObj.new_bin_location_code.value!=""){
		if(formObj.bin_location_code.value==formObj.new_bin_location_code.value){
			alert(getMessage("BOTH_BIN_ARE_SAME","SS"));
			//formObj.new_bin_location_code.select();
			return;
		}
		else{
			validateBinLocBean();	
		}
	}
}

function goNext() {
	formObj=parent.frameChangeBinLocationForTrayQueryResult.formChangeBinLocationForTrayQueryResult;
	
	start = parseInt( formObj.start.value) +parseInt( formObj.displaySize.value ) ;
	end = parseInt( formObj.end.value )+ parseInt(formObj.displaySize.value ) ;
	
	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;

	parent.frameChangeBinLocationForTrayQueryResult.location.href="../../eSS/jsp/ChangeBinLocationForTrayQueryResult.jsp?&mode="+modeVal+"&from="+start+"&to="+end;
}	

function goPrev() {
	formObj=parent.frameChangeBinLocationForTrayQueryResult.formChangeBinLocationForTrayQueryResult;
	start = parseInt( formObj.start.value  )-parseInt(  formObj.displaySize.value)  ;
	end = parseInt( formObj.end.value )- parseInt(formObj.displaySize.value ) ;

	if(formObj.mode.value==MODE_INSERT)
			modeVal=MODE_INSERT;
		else
			modeVal=MODE_MODIFY;
		
		parent.frameChangeBinLocationForTrayQueryResult.location.href="../../eSS/jsp/ChangeBinLocationForTrayQueryResult.jsp?&mode="+modeVal+"&from="+start+"&to="+end;
}	

function activeLink() {
	formObj=parent.frameChangeBinLocationForTrayQueryResult.formChangeBinLocationForTrayQueryResult;
	formObjDisplay=parent.frameChangeBinLocationForTrayQueryCriteria.formChangeBinLocationForTrayQueryCriteria;

	if(formObj.start.value != 0 ){
			formObjDisplay.previous.disabled=false;
	}
	else{
			formObjDisplay.previous.disabled=true;
	}

	if(  !((parseInt(formObj.start.value) +parseInt(formObj.displaySize.value))>= formObj.totalRecords.value ))
		formObjDisplay.next.disabled=false;
	else
		formObjDisplay.next.disabled=true;
	}


var prevObj=null;
var prevColor=null;

function changeRowColor(obj,n)
{
	if(prevObj!=null){
		for( k=0;k<n;k++)
			prevObj.cells[k].className=prevColor;
	}
	prevObj=obj;
	prevColor=obj.cells[0].className;
	for( k=0;k<n;k++)
		obj.cells[k].className="ANBOR";
}

function loadBlank(){
	//parent.frames[1].document.location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function validateChangeBinLocBean(obj){
//	alert("entering into Binlocation bean");
formObj=document.formChangeBinLocationForTrayQueryCriteria;
var new_bin_location_desc;
	
	if(formObj.bin_location_code.value!="" && formObj.new_bin_location_code.value!=""){
		
		if(formObj.bin_location_code.value==formObj.new_bin_location_code.value){
			alert(getMessage("BOTH_BIN_ARE_SAME","SS"));
			//formObj.new_bin_location_code.select();
			formObj.new_bin_location_code.focus();
		}
		else
			loadBlank();
	}
	
		
	//window.parent.parent.returnValue=formObj.new_bin_location_code.value+"`"+formObj.new_bin_location_desc.value;
	//window.parent.close();
}
