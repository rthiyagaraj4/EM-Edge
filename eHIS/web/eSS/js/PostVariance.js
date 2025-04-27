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
var xmlDom;
var xmlHttp;
var finalizeType;

function onSuccess(){
	f_query_add_mod.document.location.reload();
	return;
}

function reset() {
	f_query_add_mod.document.formPostVariance.reset();
}

function apply() {
	var fields =	new Array();
	var fieldNames =new Array();
	var	index =	0;
	var queryString = "";
	fields[index] = f_query_add_mod.document.formPostVariance.phy_inv_id;
	fieldNames[index++]	=	getLabel("eSS.PhysicalInvId.label","SS");
	fields[index] = f_query_add_mod.document.formPostVariance.doc_type_code;
	fieldNames[index++]	=	getLabel("Common.DocType.label","Common");
	if(!f_query_add_mod.document.formPostVariance.doc_no.disabled){
		fields[index] =		 f_query_add_mod.document.formPostVariance.doc_no;
		fieldNames[index++]	=	getLabel("eSS.DocNo.label","SS");
	}
	fields[index] = f_query_add_mod.document.formPostVariance.doc_date;
	fieldNames[index++]	=	getLabel("eSS.DocDate.label","SS");
	fields[index] = f_query_add_mod.document.formPostVariance.write_off_reason_code;
	fieldNames[index++]	=	getLabel("eSS.WriteoffReason.label","SS");
	obj = getBlankField(fields, fieldNames, messageFrame) 
	if(obj != null){
		obj.focus();
		return;
	}
	else{
		validateDocDate(f_query_add_mod.document.formPostVariance.doc_date);
		if (!result) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
			return;
		}
		eval(formApply(f_query_add_mod.document.formPostVariance,SS_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		if(result) {
			onSuccess();
			reset();
		}
		f_query_add_mod.FocusFirstElement();
	}
}

function assignBean() {
	bean_id = document.formPostVariance.bean_id.value;
	bean_name = document.formPostVariance.bean_name.value;
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
}

// Added by Martin
function validateDocNo(doc_type_code) {
	if(document.formPostVariance.mode.value== MODE_INSERT){
		if(doc_type_code.value == "") 
			return;
		var arrayObject = new Array();
		arrayObject[0] = doc_type_code;
		assignBean();
		xmlStr = getXMLString(arrayObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../eSS/jsp/PostVarianceValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
}

function validateStoreCode(store_code, bin_location_code) {
		if( store_code.value == "" ) 
			return;
		assignBean();
		var arrayObject = new Array();
		arrayObject[0] = store_code;
		xmlStr = getXMLString(arrayObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../eSS/jsp/PostVarianceValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&bin_location_code=" + bin_location_code + "&validate=store_code&function_type=2", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
}

function validateDocDate(doc_date) {

	var locale				=	f_query_add_mod.document.formPostVariance.locale.value;
	doc_date.value			=	convertDate(f_query_add_mod.document.formPostVariance.doc_date.value,'DMY',locale,"en"); 
	
	var arrayObjects		=	new Array();
	arrayObjects[0]			=	doc_date;
	if(!(f_query_add_mod.document.formPostVariance.mode.value==MODE_DELETE)) {
		bean_id = f_query_add_mod.document.formPostVariance.bean_id.value;
		bean_name = f_query_add_mod.document.formPostVariance.bean_name.value;
		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		xmlStr = getXMLString (arrayObjects);
		xmlDom.loadXML( xmlStr );
		xmlHttp.open("POST", "../../eSS/jsp/PostVarianceValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=doc_date&function_type=4", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
		
	}
}


function enableDocNo() {
	postVarianceForm = document.formPostVariance;
	postVarianceForm.doc_no.disabled = false;
	postVarianceForm.doc_no.readonly = false;
	postVarianceForm.doc_no.focus();
	postVarianceForm.autono_yn.value = NO;
}

function disableDocNo() {
	postVarianceForm = document.formPostVariance;
	postVarianceForm.doc_no.disabled = true;
	postVarianceForm.doc_no.readonly = true;
	postVarianceForm.doc_no.value="";
	postVarianceForm.doc_date.focus();
	postVarianceForm.autono_yn.value = YES;
}

function requestDocDateFocus(doc_date_value) {
	f_query_add_mod.document.formPostVariance.doc_date.focus();
}
