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


/*************Handle to the Frame's and the form Object ****************/


function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/ResultTemplateAddModify.jsp?mode=1&function_id="+function_id ;
}
function query() {
	f_query_add_mod.location.href='../../eOR/jsp/ResultTemplateQueryCriteria.jsp?function_id='+function_id ;
}

function deleterecord(){
	//alert();
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj = f_query_add_mod.f_query_add_mod_header.document.ResultTemplate_header ;

	if(formObj.mode.value != MODE_INSERT){
		formObj.mode.value = MODE_DELETE;

		var confirm_val= window.confirm(getMessage("DELETE_RECORD","common"));
		if(confirm_val){
			eval(	formApply(formObj,OR_CONTROLLER) );
			//f_query_add_mod.location.href = "../../eOR/jsp/ResultTemplateAddModify.jsp?mode=2&result_temp_id="+formObj.result_temp_id.value;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				formReset();
				f_query_add_mod.location.href = "../../eOR/jsp/ResultTemplateAddModify.jsp?mode=1"

			}else
				f_query_add_mod.location.href = "../../eOR/jsp/ResultTemplateAddModify.jsp?mode=2&result_temp_id="+formObj.result_temp_id.value;

		}else
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}
}

function apply() {
	//alert("in apply");
	if (! checkIsValidForProceed() ) {
		//alert("111");
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var formObj = f_query_add_mod.f_query_add_mod_header.document.ResultTemplate_header ;
	var fields = new Array ( 
							formObj.result_temp_id
							,formObj.result_temp_desc
						);

	var names = new Array ( getLabel("Common.TemplateID.label","COMMON")
							,getLabel("Common.description.label","Common")
				);


	if(f_query_add_mod.checkFieldsSpecific( fields, names, messageFrame)) {

		var flds=new Array(formObj.result_temp_id);
		var name=new Array(getLabel("Common.TemplateID.label","COMMON"));
		if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){

			qry_string =  "mode=2&result_temp_id="+formObj.result_temp_id.value
			/*****************************/
		var formObjBtm			= f_query_add_mod.f_query_add_mod_bottom.document.ResultTemplate_bottom;
	   var formObj			= f_query_add_mod.f_query_add_mod_header.document.ResultTemplate_header;

  	   var bean_id			= formObj.bean_id.value;
	   var bean_name		= formObj.bean_name.value;
			
		//var xmlDoc 			= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 		= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr					= "<root><SEARCH " ;
		xmlStr					+= "bean_id=\"" +bean_id +"\" ";
		xmlStr					+= "bean_name=\"" +bean_name +"\" ";
		xmlStr					+= "result_template=\""+checkSpl(f_query_add_mod.editor.RTEditor0.document.body.innerHTML) +"\" ";
		xmlStr 					+=" /></root>" ; 
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert("xmlStr="+xmlStr);
		xmlHttp.open( "POST", "ResultTemplateValidate.jsp?",false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;

		/*******************************/
  			eval(formApply(  formObj,OR_CONTROLLER)) ;

			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
		}

	}
}

function checkFieldsSpecific( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
        	if (i == 0) //ID
            	fields[i].value = trimString(fields[i].value);
        }
        else{    //errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
		errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";}
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
 		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")) && (url.indexOf("ResultTemplate"))==-1 )
				return true;
		else
				return false;
}

function reset(){
	//alert("in ser");

	if(f_query_add_mod.frames[0].document.forms[0] != null){

		if(f_query_add_mod.frames[0].document.forms[0].name == "ResultTemplate_header"){
			//alert();
			f_query_add_mod.f_query_add_mod_header.document.ResultTemplate_header.reset();
			//f_query_add_mod.editor.document.RTEditorForm.reset();
			//f_query_add_mod.f_query_add_mod_bottom.document.ResultTemplate_bottom.reset();
		}else{
			f_query_add_mod.document.forms[0].reset();
		}
	}

}

function onSuccess() {
	//alert("on success");
	var mode = f_query_add_mod.f_query_add_mod_header.document.ResultTemplate_header.mode.value;
	if( mode == "1" ) {
		formReset();
		f_query_add_mod.location.href = "../../eOR/jsp/ResultTemplateAddModify.jsp?mode=1"
	}
	if(mode == "2"){
		f_query_add_mod.location.href='../../eOR/jsp/ResultTemplateAddModify.jsp?'+qry_string ;
	}
}

function formReset () {
	var formObj = f_query_add_mod.f_query_add_mod_header.document.ResultTemplate_header;
	formObj.result_temp_id.value = "";
	//f_query_add_mod.f_query_add_mod_header.document.ResultTemplate_header.result_template.value = "";
	formObj.result_temp_desc.value = "";

}

function assignResult(_result, _message, _flag , _dummy){

	result = _result ;
	message  = _message ;
	flag = _flag ;
	//alert("###result="+result);
	//alert("###message="+message);
	//alert("###flag="+flag);



}



function show_discrete_measure_window(){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0]   = ResultTemplate_header.all.discrete_measure_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,1";
	argumentArray[5]   = "" ;
	argumentArray[6]   =CODE_LINK ;
	argumentArray[7]   =CODE_DESC ;

	retVal =CommonLookup( getLabel("Common.DiscreteMeasure.label","Common"), argumentArray );
	if(retVal != null && retVal != ""){
       var code=retVal[0];
	   var description=retVal[1];
    }
	setPreviewDescTemplate(code, description); 
}
/***************************show_service_window***************************/
function before_show_service_window(target,code)
{

	if(ResultTemplate_header.all.temp_service_desc.value != ResultTemplate_header.all.service_desc.value)
	{
		if(ResultTemplate_header.all.service_desc.value != "")
		 Lookup(target,code);
	}
}

function show_service_window(target,code){

		if(ResultTemplate_header.all.service_desc.value == "")
		Lookup(target,code);

}
function Lookup(target,code){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0]   = ResultTemplate_header.all.service_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,1";
	argumentArray[5]   = target.value ;
	argumentArray[6]   =CODE_LINK ;
	argumentArray[7]   =CODE_DESC ;

	retVal =CommonLookup( getLabel("Common.service.label","Common"), argumentArray );
	if(retVal != null && retVal != ""){
	  code.value=retVal[0];
	  target.value=retVal[1];
	  ResultTemplate_header.all.temp_service_desc.value=retVal[1];

    }
}
function storeEditor(){

 	   var formObjBtm			= parent.f_query_add_mod_bottom.document.ResultTemplate_bottom;
	   var formObjHrd			= parent.f_query_add_mod_header.document.ResultTemplate_header;

  	   var bean_id			= formObj.bean_id.value;
	   var bean_name		= formObj.bean_name.value;
			
		//var xmlDoc 			= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 		= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr					= "<root><SEARCH " ;
		xmlStr					+= "bean_id=\"" +bean_id +"\" ";
		xmlStr					+= "bean_name=\"" +bean_name +"\" ";
		xmlStr					+= "result_template=\""+checkSpl(parent.editor.RTEditor0.document.body.innerHTML) +"\" ";
		xmlStr 					+=" /></root>" ; 
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ResultTemplateValidate.jsp?", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;

		var htmlText		= "<html><body><form action='../../eOR/jsp/ResultTemplateAddModify.jsp' method='post' name='editor_form' id='editor_form'>";
		htmlText +="<input type='hidden' name='mode' id='mode' value=\""+formObj.mode.value+"\">";
		htmlText +="<input type='hidden' name='function_id' id='function_id' value=\""+formObj.function_id.value+"\">";
		htmlText +="<input type='hidden' name='result_temp_id' id='result_temp_id' value=\""+formObjHrd.result_temp_id.value+"\">";
		htmlText +="<input type='hidden' name='result_temp_desc' id='result_temp_desc' value=\""+formObjHrd.result_temp_desc.value+"\">";
		htmlText +="</form></body></html>";
   		parent.parent.parent.f_query_add_mod.document.body.insertAdjacentHTML('afterbegin',htmlText);
		parent.parent.parent.f_query_add_mod.document.editor_form.submit();
}

function previewEditor(){


 	var bean_id				= ResultTemplate_bottom.all.bean_id.value;
 	var bean_name			= ResultTemplate_bottom.all.bean_name.value;
	RTEText					= parent.editor.RTEditor0.document.body.innerHTML
	//alert("##RTEText="+RTEText);

   	//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "bean_id=\"" +bean_id +"\" ";
	xmlStr					+= "bean_name=\"" +bean_name +"\" ";
	xmlStr					+= "result_template=\""+checkSpl(parent.editor.RTEditor0.document.body.innerHTML) +"\" ";
	xmlStr 					+=" /></root>" ; 
	//alert("###xmlStr="+xmlStr);
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ResultTemplateValidate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	if(RTEText!=""){
	var dialogHeight	= '37.5' ;
	var dialogWidth		= '50' ;
	var dialogTop		= '30';
	var dialogLeft		= '100' ;
	var title			= ''
	var features		= 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; dialogTitle:'+title+';scroll=yes; status=no';
	//alert("bean_id="+bean_id);
	//alert("bean_name="+bean_name);
	var retVals			=  window.showModalDialog("../../eOR/jsp/ResultTemplatePreview.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name),arguments,features);
}
}



