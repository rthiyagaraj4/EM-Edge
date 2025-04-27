/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var message1 = "" ;
var flag = "" ;
var qry_string = "";

function intialiseGlobal(){
function_id = "" ;
result = false;
message = "" ;
flag = true;
//flagChk          = false
}
function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/ImageHotSpotLinkAddModify.jsp?mode=1&function_id="+function_id ;
}

function query() {
	f_query_add_mod.location.href='../../eOR/jsp/ImageHotSpotLinkQueryCriteria.jsp?function_id='+function_id ;
}

function apply(){
	
	if (! checkIsValidForProceed() || f_query_add_mod.document.image_hot_spot.mode.value=='2') {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var formObj = f_query_add_mod.document.image_hot_spot;

	var fields = new Array ( formObj.image,formObj.hot_spot,formObj.image_link);
	var names = new Array ( getLabel("eOR.Image.label","OR"),getLabel("eOR.HotSpot.label","OR"),getLabel("eOR.ImageLink.label","OR"));
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		eval(formApply( f_query_add_mod.document.image_hot_spot,OR_CONTROLLER)) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	}
}

function onSuccess() {
	var mode = f_query_add_mod.document.image_hot_spot.mode.value;
	if( mode == "1" ) {
		formReset();
	}
}


function formReset () {
	var formObj = f_query_add_mod.document.image_hot_spot;
	formObj.image.value = ""
	formObj.hot_spot.value = ""
	formObj.image_link.value = ""
    clearList("f_query_add_mod.document");
}

function assignResult(_result, _message, _flag){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	message1  = _message ;
	flag = _flag ;

}


function deleterecord(){
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj = f_query_add_mod.document.image_hot_spot ;
	var mode = formObj.mode.value ;
	if(mode == '1'){//no action
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		
	}
	//if(formObj.mode.value != MODE_INSERT){
		//formObj.mode.value = MODE_DELETE;

		var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
		if(confirm_val){
			formObj.mode.value = "0";
			eval(	formApply( f_query_add_mod.document.image_hot_spot,OR_CONTROLLER) );
			//f_query_add_mod.location.href = "../../eOR/jsp/ImageHotSpotLinkAddModify.jsp?mode="+MODE_INSERT;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message1;
			if( result ) {
			onSuccess();
				create();
		intialiseGlobal();
			}
		}else
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	//}else{
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}
//}



function reset(){
	if(f_query_add_mod.document.forms[0] != null){

		if(f_query_add_mod.document.forms[0].name == "image_hot_spot"){
			f_query_add_mod.document.image_hot_spot.reset();
			clearList("f_query_add_mod.document")
		}else{
			f_query_add_mod.document.forms[0].reset();
		}
	}
}


function populateHotSpots(image){

	var formObj = document.image_hot_spot

	if( image.value == "" ) {
		clearList("document")
	}
	clearL2List("document");
	var bean_id = formObj.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += image.name+"=\""+ image.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ImageHotSpotLinkValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )

}

function addOrderTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.image_hot_spot.hot_spot.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".image_hot_spot.hot_spot.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".image_hot_spot.hot_spot.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".image_hot_spot.hot_spot.add(opt)") ;
}


function clearL2List( docObj ) {
	var len = eval(docObj+".image_hot_spot.hot_spot.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".image_hot_spot.hot_spot.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".image_hot_spot.hot_spot.add(opt)") ;

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

//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}*/
