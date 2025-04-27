/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href="../../eSS/jsp/AlternateGroupFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}
function query(){
	f_query_add_mod.location.href="../../eSS/jsp/AlternateGroupQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}
function onSuccess(){
	f_query_add_mod.location.href="../../eSS/jsp/AlternateGroupFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}
function apply() {
	if(!proceedOnApply())
    {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }

	var frmObj	=f_query_add_mod.location.href.indexOf(".jsp");

	if(frmObj!=-1){
		var formObj		=	f_query_add_mod.frameAlternateGroupDetail.document.formAlternateGroupDetail;
if((f_query_add_mod.frameAlternateGroup.document.formAlternateGroup.total_select.value=="0") && (f_query_add_mod.frameAlternateGroup.document.formAlternateGroup.total_delete.value=="0")){
messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('ATLEAST_ONE_SELECTED','SS');	 
			return;
}
		var formarray = new Array (f_query_add_mod.frameAlternateGroupDetail.document.formAlternateGroupDetail );

		var blankObject	=	null;
		var errorPage	=	"../../eCommon/jsp/error.jsp";
	
			if(blankObject==null) {
				if(f_query_add_mod.frameAlternateGroupDetail.document.formAlternateGroupDetail.choosen_link.value=="select"){
					
								eval( formApply( formarray,SS_CONTROLLER) ) ;
								
								messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
					
						if( result ) {
							onSuccess();
						}
				}
			}
			else
			blankObject.focus();
	}
	else{
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}


function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("alternategroupquery")==-1) )
        return true;
    else
        return false;
}

function reset(){
	
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();

	if(f_query_add_mod.frameAlternateGroup!=null){
		f_query_add_mod.location.reload();
	}
}


function clearGroup(){
	parent.frameAlternateGroup.document.formAlternateGroup.reset();
	parent.frameAlternateGroupDetail.document.location.href="../../eCommon/html/blank.html";
}

function Modify(obj){
	var group_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/AlternateGroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&group_code="+group_code;
}

async function searchGroupCode( objCode, objDesc ) {
	var prevValue	   = objDesc.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formAlternateGroup.group_type.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.formAlternateGroup.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE.value;

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

	returnedValues =await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readOnly= true;
		parent.frameAlternateGroup.document.formAlternateGroup.group_code.value=arr[0];
		if(document.formAlternateGroup.group_desc.value.readOnly)
		if(prevValue != objDesc.value)
			clearList();
		document.formAlternateGroup.Alternategroup_search.disabled=false;
		parent.frameAlternateGroupDetail.document.location.href="../../eCommon/html/blank.html";	
	} 
}

function searchAlternateGroupCode(  objCode, objDesc  ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= parent.frameAlternateGroup.document.formAlternateGroup.group_type.value;
	dataTypeArray[0] = STRING;

	dataNameArray[1] = "group_code";
	dataValueArray[1]= parent.frameAlternateGroup.document.formAlternateGroup.group_code.value;
	dataTypeArray[1] = STRING;

	argumentArray[0] = document.formAlternateGroupDetail.SQL_SS_GROUP_LOOKUP_FOR_ALTERNATE.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = "";//objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.disabled=true;
		document.formAlternateGroupDetail.group_search.disabled=true;
	} 
}



function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}


function clearGroup(){
	var formObjAlternateGroup		=	parent.frameAlternateGroup.document.formAlternateGroup ;
	formObjAlternateGroup.group_desc.value="";
	parent.frameAlternateGroupDetail.location.href="../../eCommon/html/blank.html";
}



	

	

function popAlternateGroups(functionmode){
	
	var formObjAlternateGroup		=	parent.frameAlternateGroup.document.formAlternateGroup ;
	
	if(formObjAlternateGroup.group_desc.value==""){
		alert(getMessage("ALTERNATE_GROUP_CANT_BLANK","SS"));
		return false;
	}
	parent.frameAlternateGroupDetail.location.href="../../eSS/jsp/AlternateGroupDetail.jsp?group_code="+formObjAlternateGroup.group_code.value+"&mode="+formObjAlternateGroup.mode.value+"&group_type="+formObjAlternateGroup.group_type.value+"&surgery_type="+formObjAlternateGroup.surgery_type.value+"&usage_desc="+formObjAlternateGroup.usage_desc.value+"&search=new&from=0&to=19";
	
}

function submitPrevNext(from, to){
	parent.frameAlternateGroupDetail.formAlternateGroupDetail.from.value = from;
	parent.frameAlternateGroupDetail.formAlternateGroupDetail.to.value = to; 
	parent.frameAlternateGroupDetail.formAlternateGroupDetail.submit();
}


function dispTypeCheck(obj, alternative_group_code,s_mode){
	if(s_mode=='select'){
	if(obj.checked == true){
	obj.value="Y";
	parent.frameAlternateGroup.document.formAlternateGroup.total_select.value=parseInt(parent.frameAlternateGroup.document.formAlternateGroup.total_select.value)+1;
	}else{
		obj.value="N";
			parent.frameAlternateGroup.document.formAlternateGroup.total_select.value=parseInt(parent.frameAlternateGroup.document.formAlternateGroup.total_select.value)-1;
	}
	}else{
	if(obj.checked == true){
	obj.value="Y";
	parent.frameAlternateGroup.document.formAlternateGroup.total_delete.value=parseInt(parent.frameAlternateGroup.document.formAlternateGroup.total_delete.value)+1;
	}else{
		obj.value="N";
			parent.frameAlternateGroup.document.formAlternateGroup.total_delete.value=parseInt(parent.frameAlternateGroup.document.formAlternateGroup.total_delete.value)-1;
	}
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AlternateGroupValidate.jsp?alternative_group_code="+alternative_group_code+"&function=ALTERNATIVEGROUPCODE"+"&selected="+ obj.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
} 
