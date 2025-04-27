/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";
//**var chk_Valflag = false;

function apply(){
	var message;
	if (! checkIsValidForProceed() )
    {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	//var result=true;
	var formObj = f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr;
	//formObj.linkStr.value="";
	var fields = new Array (formObj.service_code);
	var names = new Array (getLabel("Common.service.label","Common"));
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		var flag = onApplyUpdate();
	//**	if(flag && chk_Valflag){
		if(flag ){
			//alert( formApply(f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr));
			eval( formApply(f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr, OR_CONTROLLER) ) ;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
			if(resultGlobal){
				onSuccess();
			}
		}
		/**else{
			var msg = getOrMessage('CLICK_ONE_ORDERABLE');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			return false;
		}**/
	}
}

function query(){
	f_query_add_mod.location.href="../../eOR/jsp/IndexOrderCatalogQueryCriteria.jsp?function_id="+function_id;
}
function create(){
	f_query_add_mod.location.href="../../eOR/jsp/IndexOrderCatalogMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}


function callOnAlphaLink(obj, obj2){
	changeAlphaColor(obj2);
	var fldObj = document.forms[0].service_code;
	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
	}
	var service_code = fldObj.value;
	if(service_code !=""){
		parent.detailFrame.location.href="../../eOR/jsp/IndexOrderCatalogDtl.jsp?service_code="+service_code+"&index="+obj+"&tabVal=S";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		//fldObj.disabled=true;
		document.forms[0].service_desc.disabled=true;
		document.forms[0].service_butoon.disabled=true;
	}
	else{
		parent.detailFrame.location.href="../../eCommon/html/blank.html";
		var msg = getMessage("SERVICE_BLANK","OR");
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;

	}
}



function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function onApplyUpdate(){
	//var refForm = document.frames[1].frames[1].document.forms[0];
	var refForm =f_query_add_mod.headerFrame;
    //console.log(refForm);
	//if(document.frames[1].frames[1].location.href.indexOf(".jsp") != -1){
    if(parent.parent.frames[1].document.location.href.indexOf(".jsp")!= -1){
		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		//var fm_disp		= refForm.fm_disp.value;
		var fm_disp		= f_query_add_mod.detailFrame.document.getElementById("fm_disp").value;
		var to_disp		= f_query_add_mod.detailFrame.document.getElementById("to_disp").value
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++){
			var value = document.f_query_add_mod.detailFrame.document.getElementById('select_yn'+i);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
					//**chk_Valflag=true;
				}else
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"IndexOrderCatalogBean\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","IndexOrderCatalogValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
		return true;
	}
	else
	{
		return true;
	}

}

function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
	if(messageGlobal=="CLICK_ONE_ORDERABLE" && resultGlobal==false){
		messageGlobal=getMessage('CLICK_ONE_ORDERABLE',"OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		return false;
	}
}


function dispLink(obj){

	
	var service_code	= document.getElementById('service_code').value;
	if(service_code != ""){
		var buttonVal = obj;
		if(buttonVal == "S"){
			
			document.getElementById('SelectTab').className="clicked";
			
			document.getElementById('AssociateTab').className="normal";
		}else if(buttonVal == "A"){
			
			document.getElementById('SelectTab').className = "normal";
			
			document.getElementById('AssociateTab').className = "clicked";
		}
		var formObjAddMod = document.forms[0];
		
		formObjAddMod.service_desc.disabled=true;
		formObjAddMod.service_butoon.disabled=true;
		
		document.getElementById('tabVal').value = buttonVal;


		if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
		}

		/***/
		if(linkContent=="")
			linkContent	=	document.getElementById('linkId').innerHTML;
//alert(linkContent);
		if(buttonVal=="A"){
		//document.forms[0].all.linkId.className ="";
		document.getElementById("linkId").className = "";
		//document.forms[0].all.linkId.innerHTML = "&nbsp;";
		document.getElementById("linkId").innerHTML = "&nbsp;";
		parent.frames[1].location.href="../../eOR/jsp/IndexOrderCatalogDtl.jsp?tabVal="+buttonVal+"&service_code="+service_code;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}else{
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			//document.forms[0].all.linkId.innerHTML = linkContent;
			document.getElementById("linkId").innerHTML = linkContent;
			//document.forms[0].all.linkId.className ="linkStyle";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else{
		var msg = getMessage("SERVICE_BLANK","OR");
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}

}


function reset()
{
	if (f_query_add_mod.document.forms[0])
	{
		f_query_add_mod.document.forms[0].reset();
	}
	else if(f_query_add_mod.frames[1].location.href.indexOf(".jsp") != -1)
	{
		f_query_add_mod.frames[0].document.forms[0].reset();
		f_query_add_mod.frames[0].document.forms[0].service_code.disabled=false;
		f_query_add_mod.frames[0].document.forms[0].service_butoon.disabled=false;
		f_query_add_mod.frames[0].document.forms[0].service_desc.disabled=false;
		f_query_add_mod.frames[0].document.forms[0].service_desc.focus();	
		f_query_add_mod.frames[1].location.href = '../../eCommon/html/blank.html';
		//create();
	}
	else
	{
		f_query_add_mod.frames[0].document.forms[0].service_code.disabled=false;
		frames[0].location.reload();
		return false;
	}
/*

	alert(parent.frames[1].frames[1].frames[1].location.href);
	if(parent.frames[1].frames[1].frames[1].location.href.indexOf(".jsp") != -1)
		parent.frames[1].frames[1].frames[1].location.href="../../eCommon/html/blank.html";
*/
}

function onSuccess(){
	f_query_add_mod.frames[0].location.href="../../eOR/jsp/IndexOrderCatalogHdr.jsp?mode="+MODE_INSERT;
	f_query_add_mod.frames[1].location.href="../../eCommon/html/blank.html";
}

function latestUpdate(){

	//alert(parent.detailFrame.document.formIndexOrderCatalogDtl.name);

	var bean_id		= parent.detailFrame.document.formIndexOrderCatalogDtl.bean_id.value;
	var bean_name	= parent.detailFrame.document.formIndexOrderCatalogDtl.bean_name.value;
	var fm_disp		= parent.detailFrame.document.formIndexOrderCatalogDtl.fm_disp.value;
	var to_disp		= parent.detailFrame.document.formIndexOrderCatalogDtl.to_disp.value;
	var tabVal		= parent.detailFrame.document.formIndexOrderCatalogDtl.tabVal.value;
	var value_str	= "";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('parent.detailFrame.document.formIndexOrderCatalogDtl.select_yn'+i);
		//alert("value="+value.value);
		//alert("value.disabled="+value.disabled);
		//alert("value.checked="+value.checked);
			if(!value.disabled){

				if(value.checked)
					val = "Y";
				else
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";
		}
		//alert("value_str="+value_str);
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"IndexOrderCatalogBean\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","IndexOrderCatalogValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
		return true;
	}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
function before_show_service_lookup(target,code){

	if(target.value != parent.parent.f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr.temp_service_desc.value) {
		if(target.value!="")
			show_service_lookup(target,code);
		else{
			target.value="";
			code.value="";		parent.parent.f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr.temp_service_desc.value="";
		}
	}
}

async function show_service_lookup(target,code){
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();

	argumentArray[0]=parent.parent.f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr.service_sql.value;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=await CommonLookup(getLabel("Common.service.label","Common"),argumentArray);
	var ret1=unescape(retval);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}

	if(retval !=null && retval != ""){
		code.value=arr[0];
		target.value=arr[1];
		parent.parent.f_query_add_mod.headerFrame.document.formIndexOrCatalogHdr.temp_service_desc.value=arr[1];
		}
}
