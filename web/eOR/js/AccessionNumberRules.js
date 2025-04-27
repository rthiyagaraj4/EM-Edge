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
var flag = "" ;      
var qry_string = "";

function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/AccessionNumberRulesAddModify.jsp?mode=1&function_id="+function_id ;
}

function query() {
	f_query_add_mod.location.href='../../eOR/jsp/AccessionNumberRulesQueryCriteria.jsp?function_id='+function_id ;
}


function apply() {
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj = f_query_add_mod.document.accession_numer_rule ;
	var fields = new Array ( formObj.order_category   
							 ,formObj.order_type  
							 ,formObj.prefix  
							 ,formObj.frmat  
							 ,formObj.srl_num  
						);

	var names = new Array ( getLabel("Common.OrderCategory.label","Common")
							,getLabel("Common.OrderType.label","Common")
							,getLabel("eMP.prefix.label","MP")
							,getLabel("Common.Format.label","Common")
							,getLabel("eOR.InitialSerialNumber.label","OR")
				);	

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		eval(formApply(formObj,OR_CONTROLLER)) ;
		//alert(formApply(formObj,OR_CONTROLLER));
		 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		// alert("message value:"+message);
		if( result ) {
			onSuccess();
		}
	}

}


function onSuccess() {
	var mode = f_query_add_mod.document.accession_numer_rule.mode.value;
	if( mode == "1" ) {
		formReset();
	}
	if(mode == "2"){
		
		f_query_add_mod.location.href='../../eOR/jsp/AccessionNumberRulesAddModify.jsp?'+qry_string ;
	}
}


function formReset () {
	var formObj = f_query_add_mod.document.accession_numer_rule;
	formObj.order_category.value = ""   
	formObj.order_type.value = ""
	formObj.prefix.value = ""
	formObj.frmat.value = ""
	formObj.srl_num.value = ""
    clearList("f_query_add_mod.document");
}

function assignResult(_result, _message, _flag){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;

}

function reset(){
	if(f_query_add_mod.document.forms[0] != null){

		if(f_query_add_mod.document.forms[0].name == "accession_numer_rule"){
			f_query_add_mod.document.accession_numer_rule.reset();
			clearList("f_query_add_mod.document")
		}else{
			f_query_add_mod.document.forms[0].reset();
		}
	}
}

function populateOrderTyoes(ord_cat){

	if( ord_cat.value == "" ) {
		clearList("document")
	}
	var bean_id = document.accession_numer_rule.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AccessionNumberRulesValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
}

function addOrderTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.accession_numer_rule.order_type.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".accession_numer_rule.order_type.options.length") ; 
	for(var i=0;i<len;i++)
	{
		eval(docObj+".accession_numer_rule.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".accession_numer_rule.order_type.add(opt)") ;
}



function clearL2List( docObj ) {
	var len = eval(docObj+".accession_numer_rule.order_type.options.length") ; 
	for(var i=0;i<len;i++)
	{
		eval(docObj+".accession_numer_rule.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".accession_numer_rule.order_type.add(opt)") ;
	
	tp = getLabel("Common.all.label","Common") ;
	opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".accession_numer_rule.order_type.add(opt)") ;
}


function allowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}



function checkPositiveNumber(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;
   if(((obj_value.charAt(0) == "0") && (obj_length == "1")) || ((obj_value.charAt(0) == "0") && (obj_value.charAt(1) == "0") &&  (obj_length == "2"))){
	   alert(getMessage("NUM_CANT_BLANK","OR"));
	   return false
   }
   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(getMessage("ONLY_POSITIVE_INTEGERS","OR"));
			return false;
		}
   }
}
function changeSize(){
	var formObj = document.accession_numer_rule
		formObj.srl_num.value = "";
		if (formObj.frmat.value == "YJ"){
			formObj.srl_num.size = 8
			formObj.srl_num.maxLength= 8
		}else{
			formObj.srl_num.size = 11
			formObj.srl_num.maxLength= 11
		}
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
