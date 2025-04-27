 //saved on 07/11/2005
var function_id		= "PH_PRES_REMARK" ;
var result1			= false ;
var message			= "" ;
var flag			= "" ;
var invalidCode		= "";

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/PresRemarkAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

/*
function create() {
	var dialogHeight	= "33";
	var dialogWidth		= "50";
	var dialogTop		= "92";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var order_id		= "PHOP00000002461";
	var locn_code		= "NARAY2";
	var patient_id		= "00000478";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal=window.showModalDialog("../../ePH/jsp/TPNWorkSheet.jsp?patient_id="+patient_id+"&order_id="+order_id+"&locn_code="+locn_code,arguments,features);
}
*/

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/PresRemarkQueryCriteria.jsp?function_id="+function_id;
}

function deleterecord() {
	if ( !checkIsValidForProceed( "presremarkaddmodify" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	else {
		if (f_query_add_mod.document.formPresRemark.mode.value == MODE_MODIFY) {
			f_query_add_mod.document.formPresRemark.mode.value = MODE_DELETE;
			if (confirm(getMessage("DELETE_RECORD","Common")))
				apply();
			else {
				f_query_add_mod.document.formPresRemark.mode.value = MODE_MODIFY;
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
	}
}
function apply() {
	
	if ( !checkIsValidForProceed( "presremarkaddmodify" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	formObj = f_query_add_mod.document.formPresRemark;
	
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();

	arrFieldName[0]			=	"REMARK_CODE_";
	arrFieldName[1]			=	"REMARK_DESC_";

	arrLegends[0]			=	getLabel("Common.code.label","Common");
	arrLegends[1]			=	getLabel("Common.description.label","Common");

	var arrPKFieldNames		=	new Array();
	arrPKFieldNames[0]		=	"REMARK_CODE_";

	var mode = formObj.mode.value;

	if( mode == MODE_INSERT ) {
		
		resetDuplicateClass(formObj,arrPKFieldNames);
		var	result	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
		if (result) {
        
			eval( formApply(formObj, PH_CONTROLLER) );
			if( result1 ) {
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				create();
			}
			if( invalidCode != "null" && invalidCode != "" ) {
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message+":-"+invalidCode;
				showDuplicates(formObj, arrPKFieldNames, invalidCode,0,messageFrame);
			}
		}
	}

	if( mode == MODE_MODIFY ) {
		var fields = new Array ( formObj.REMARK_CODE,formObj.REMARK_DESC );
		var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			eval(formApply( formObj, PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		}
	}

	if( mode == MODE_DELETE ) {
		eval( formApply( formObj, PH_CONTROLLER ) ) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result1 ) {
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
		}
	}
}

function formReset() {
	if (f_query_add_mod.document.formPresRemark.mode.value==MODE_INSERT) {
		var frmobj	= "f_query_add_mod.document.formPresRemark";
		var obj		= ".FORM_CODE_";
		var obj1	= ".ROUTE_CODE_";
		var obj2	= ".APPL_SLIDING_SCALE_YN_";

		for (var i=0; i<=9; i++) {
			clearList(frmobj + obj1, i);
			eval(frmobj+obj+i).disabled		= true;
			eval(frmobj+obj1+i).disabled	= true;
			eval(frmobj+obj2+i).disabled	= true;
		}
		f_query_add_mod.document.formPresRemark.reset();
	}
	if (f_query_add_mod.document.formPresRemark.mode.value==MODE_MODIFY) {
		f_query_add_mod.document.formPresRemark.reset();
	}
}

function reset() {
	if ( checkIsValidForProceed( "presremarkquerycriteria" ) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( checkIsValidForProceed( "presremarkaddmodify" ) ) {
		if(f_query_add_mod.document.formPresRemark.mode.value == MODE_INSERT) {
			formObj =   f_query_add_mod.document.formPresRemark;
			var arrPKFieldNames     =   new Array();
            arrPKFieldNames[0]      =   "REMARK_CODE_";
			resetDuplicateClass(formObj,arrPKFieldNames);
			formReset() ;
		}
		else {
			f_query_add_mod.document.formPresRemark.reset();
			getRouteOfDrug(f_query_add_mod.document.formPresRemark.FORM_CODEANDDESC, 1);
			f_query_add_mod.document.formPresRemark.ROUTE_CODEANDDESC.value=f_query_add_mod.document.formPresRemark.AVL_ROUTE_CODE.value;
		}
	}
}


function assignResult( _result, _message, _flag, _invalidCode ) {
	result1 	= _result ;
	message		= _message ;
	flag		= _flag ;
	invalidCode = _invalidCode ;
}

function Modify(obj) {	
	var formobj = document.formPresRemarkQueryResult
	var remark_code = obj.cells[0].innerText;
	var remark_desc = obj.cells[1].innerText;
	var form_code = escape(obj.cells[2].innerText);
	var form_desc = escape(obj.cells[3].innerText);
	var route_code = escape(obj.cells[4].innerText);
	var route_desc = escape(obj.cells[5].innerText);	
	document.location.href="../../ePH/jsp/PresRemarkAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&REMARK_CODE="+remark_code+"&REMARK_DESC="+escape(remark_desc)+"&FORM_CODE="+form_code+"&FORM_DESC="+escape(form_desc)+"&ROUTE_CODE="+route_code+"&ROUTE_DESC="+escape(route_desc);
}

function getRouteOfDrug ( FormCodeObj, calledFrom ) {
		var objname = FormCodeObj.name ;
		var formObject = "";

		if (calledFrom == "1") {
			formObject = f_query_add_mod.document.formPresRemark;
		}
		else if (calledFrom == "2") {
			formObject = document.formPresRemark;
		}

		var bean_id = formObject.bean_id.value ;
		var bean_name = formObject.bean_name.value ;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlStr ="<root><SEARCH " ;
		xmlStr += FormCodeObj.name+"=\""+ checkSpl(FormCodeObj.value) +"\" " ;
		xmlStr +=" /></root>" ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		if(formObject.mode.value == MODE_INSERT)
			xmlHttp.open( "POST", "PresRemarkValidate.jsp?function_id="+function_id+"&bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=Formcode" + "&object=" + objname + "&calledFrom=" + calledFrom, false ) ;
		else if(formObject.mode.value == MODE_MODIFY)
			xmlHttp.open( "POST", "PresRemarkValidate.jsp?function_id="+function_id+"&bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=FormCodeforMod" + "&object=" + objname + "&calledFrom=" + calledFrom, false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
}

function clearList( docObj, objnum ) {
	var len = eval(docObj+objnum+".options.length") ;
	for( var i=0; i<len; i++ ) {
		eval(docObj+objnum+".remove(\"ROUTE_CODE\")") ;
	}
	var tp = "         --"+getLabel("Common.defaultSelect.label","Common") +"--         " ;
	
	var opt = eval(document.createElement("OPTION")) ;
	
	opt.text = tp ;
	opt.value = "" ;
	//alert(docObj+objnum+".add(opt)") ;
	eval(docObj+objnum+".add(opt)") ;
}

function addList( code, value, docObj, objnum, fntColor, backgrndColor ) {
	var opt = eval(document.createElement("OPTION")) ;
	opt.value = code ;
	opt.text = value ;
	opt.style.color=fntColor;// added for CRF RUT-CRF-0034.1[IN:037389]
	opt.style.backgroundColor=backgrndColor;// added for CRF RUT-CRF-0034.1[IN:037389]
	eval(docObj+objnum+".add(opt)") ;
}

function enableFormList(objVal, objnum) {
	var obj = eval("document.formPresRemark.FORM_CODE_"+objnum);
	var obj1 = eval("document.formPresRemark.ROUTE_CODE_"+objnum);
	var obj2 = eval("document.formPresRemark.APPL_SLIDING_SCALE_YN_"+objnum);
	if (trimCheck(objVal) != "") {
		obj.disabled	= false;
		obj.focus();
		obj1.disabled	= false;
		obj2.disabled	= false;
	}
	else {
		obj.disabled	= true;
		obj1.disabled	= true;
		obj2.disabled	= false;
	}
}

/*function lockKey() {
	if(event.keyCode == 93)
		alert("Welcome to eHIS");
} commented onDt:14/9/09*/

function checkIsValidForProceed( urlName ) {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}

function resetColorCode(obj) {
	var arrPKFieldNames	=	new Array();
	arrPKFieldNames[0]	=	"REMARK_CODE_";
	resetDuplicateClass( parent.f_query_add_mod.document.formPresRemark, arrPKFieldNames, 0, obj );
}

function remarksCodeCheck(obj){
	if(!CheckChars(obj)){
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
        obj.select();
        return false;
    }
}
