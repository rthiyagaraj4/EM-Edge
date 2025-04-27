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
var latest_flag= false;

function apply(){
	
	if (! checkIsValidForProceed() ) {
		var message  = getOrMessage("NOT_VALID");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var result=true;
	var formObj = f_query_add_mod.OrTypeOrderableHdr.document.formOrderTypesForOrderHdr;
	var fields = new Array (formObj.order_type_code);
	var names = new Array ("Order Type");
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		var flag = onApplyUpdate();
		if(flag && latest_flag){
			eval( formApply(f_query_add_mod.OrTypeOrderableHdr.document.formOrderTypesForOrderHdr,OR_CONTROLLER) ) ;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
			if(result){
				onSuccess();
			}
		}else{
			var msg = getOrMessage('CLICK_ONE_ORDERABLE');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			return false;
		}
	}
}

function create(){
	f_query_add_mod.location.href="../../eOR/jsp/OrderTypesForOrderableMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function query(){
	f_query_add_mod.location.href="../../eOR/jsp/OrderTypesForOrderableQueryCriteria.jsp?function_id="+function_id;
}


function callOnAlphaLink(obj1,obj2){

	changeAlphaColor(obj2);

	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
	}
	var order_code = document.forms[0].order_type_code;
	var msg ="";
	if(order_code.value != ""){
		var arr = order_code.value.split('~');
		var order_type_code		 = arr[0];
		var order_category_code  = arr[1];
		parent.parent.f_query_add_mod.OrTypeOrderableDtl.location.href="../../eOR/jsp/OrderTypesForOrderableDtl.jsp?index="+obj1+"&order_type_code="+order_type_code+"&order_category_code="+order_category_code+"&tabVal=S";
		order_code.disabled=true;
	}else{
		msg = "APP-000001 Order Type cannot be blank..."
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
}


function dispLink(obj){
//alert("8890,obj="+obj);
	var order_code	= document.forms[0].order_type_code.value;

	if(order_code != ""){

		var arr = order_code.split('~');
		var order_type_code		 = arr[0];
		var order_category_code  = arr[1];

		var buttonVal = obj;
		if(buttonVal == "S"){
			document.forms[0].SelectTab.className="clicked";
			document.forms[0].AssociateTab.className="normal";
		}else if(buttonVal == "A"){
			document.forms[0].SelectTab.className="normal";
			document.forms[0].AssociateTab.className="clicked";
		}
		var formObjAddMod = document.forms[0];
		formObjAddMod.order_type_code.disabled=true;
		document.forms[0].tabVal.value = buttonVal;

		if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
		}

		/***/

		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
		if(buttonVal=="A"){
		document.forms[0].linkId.className ="";
		document.forms[0].linkId.innerHTML = "&nbsp;";
		parent.frames[1].location.href="../../eOR/jsp/OrderTypesForOrderableDtl.jsp?tabVal="+buttonVal+"&order_type_code="+order_type_code+"&order_category_code="+order_category_code;
		}else{
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			document.forms[0].linkId.innerHTML = linkContent;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else{
		var msg = "APP-000001 Order Type cannot be blank..."
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}

}

function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function latestUpdate(){


	var bean_id		= parent.OrTypeOrderableDtl.document.formOrTypeOrderableDtl.bean_id.value;
	var bean_name	= parent.OrTypeOrderableDtl.document.formOrTypeOrderableDtl.bean_name.value;
	var fm_disp		= parent.OrTypeOrderableDtl.document.formOrTypeOrderableDtl.fm_disp.value;
	var to_disp		= parent.OrTypeOrderableDtl.document.formOrTypeOrderableDtl.to_disp.value;
	var tabVal		= parent.OrTypeOrderableDtl.document.formOrTypeOrderableDtl.tabVal.value;
	var value_str	= "";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('parent.OrTypeOrderableDtl.document.formOrTypeOrderableDtl.select_yn'+i);
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
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"OrderTypesForOrderable\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OrderTypesForOrderableValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return true;

	}


function onApplyUpdate(){
	var refForm = parent.frames[1].frames[1].frames[1].document.formOrTypeOrderableDtl;

	if(parent.frames[1].frames[1].frames[1].location.href.indexOf(".jsp") != -1){

		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++){
			var value = eval('parent.frames[1].frames[1].frames[1].document.forms[0].select_yn'+i);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
					latest_flag=true;
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
		xmlStr += " CLASS_NAME=\"OrderTypesForOrderable\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OrderTypesForOrderableValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
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
}



function reset(){

	if(f_query_add_mod.OrTypeOrderableHdr){
		create();
	}
	else if(f_query_add_mod.document.forms[0]!=null)
		f_query_add_mod.document.forms[0].reset();
	else{
			frames[0].location.reload();
			return false;
		}
}

function onSuccess(){
	parent.frames[1].frames[1].frames[0].location.href="../../eOR/jsp/OrderTypesForOrderableHdr.jsp?mode="+MODE_INSERT;
	parent.frames[1].frames[1].frames[1].location.href="../../eCommon/html/blank.html";
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
