  //saved on 27/10/2005

/**********************************************************************************/
var function_id = "" ;
var result1 = false ;
var message = "" ;
var flag = "" ;
globalform_code="";
globalroute_code="";
var invalidCode	=  "";

/**********************************************************************************/
function RouteForFormCheck(obj){
	if(!CheckChars(obj))
	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}
/**********************************************************************************/
function create(){

f_query_add_mod.location.href="../../ePH/jsp/RouteForFormAddModify.jsp?mode="+MODE_INSERT;
}
/**********************************************************************************/
function query() {

f_query_add_mod.location.href="../../ePH/jsp/RouteForFormQueryCriteria.jsp" ;
}

/**********************************************************************************/
function deleterecord()
{

var url = f_query_add_mod.location.href;
url = url.toLowerCase();

if ( (url.indexOf("routeforformaddmodify")==-1) ) {
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	return false;
}
else {
	if (f_query_add_mod.document.formRouteForForm.mode.value == MODE_MODIFY) {
	//alert(" in js deleterecord()");
		if (confirm(getMessage("DELETE_RECORD","Common"))){
			f_query_add_mod.document.formRouteForForm.mode.value = MODE_DELETE;
			apply();
		}else {
			f_query_add_mod.document.formRouteForForm.mode.value = MODE_MODIFY;
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else {
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
	}
}
/**********************************************************************************/
function apply()
{
	var mode = f_query_add_mod.document.formRouteForForm.mode.value;	

	 if( mode == "0" ) {

		eval( formApply( f_query_add_mod.document.formRouteForForm,PH_CONTROLLER ) ) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result1 ) {
			onSuccessD();
		}
	}
	else
	{
		f_query_add_mod.document.forms[0].submit();
	}
}

function apply_1()
{
 	formObj	=	parent.f_query_add_mod.document.formRouteForForm;
	var param_yn=	parent.f_query_add_mod.document.formRouteForForm.PARAM_YN.value;
	
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();

	arrFieldName[0]			=	"form_desc";
	arrFieldName[1]			=	"route_desc";
	arrFieldName[2]			=	"action_text_label";
	if(param_yn=='Y')
	arrFieldName[3]			=	"action_text_label_loc_lang";


	arrLegends[0]			=	getLabel("ePH.Form.label","PH")
	arrLegends[1]			=	getLabel("Common.Route.label","Common")
	arrLegends[2]			=	getLabel("ePH.ActionTextLabelinEnglish.label","PH")
	if(param_yn=='Y')
	arrLegends[3]			=	getLabel("ePH.ActionTextLabelInLocalLanguage.label","PH");


	var arrPKFieldNames		=	new Array();
	arrPKFieldNames[0]		=	"form_desc";
	arrPKFieldNames[1]		=	"route_desc";

	if(!proceedOnApply())
	{
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}


	var mode = parent.f_query_add_mod.document.formRouteForForm.mode.value;
 
if( mode == "1" )
    {
	
        resetDuplicateClass(formObj,arrPKFieldNames);		
	
       var result  =   validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,0,parent.messageFrame);
    
		if (result){
			
			//alert(formApply(formObj,PH_CONTROLLER));
            eval(formApply(formObj,PH_CONTROLLER));
            if( result1 ) {
                parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
                onSuccess();
            }
            if( invalidCode != "null" && invalidCode != "" ){
			//	alert(invalidCode);
                parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message+":-"+invalidCode;
                showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',parent.messageFrame);
                }
        }
        else
        {
            return false;
        }
    }

 
if( mode == "2" )
{
var frmobj = parent.f_query_add_mod.document.formRouteForForm;
var fields = new Array (frmobj.form_desc,frmobj.route_desc,frmobj.action_text_label);
var names = new Array ( getLabel("ePH.FormDescription.label","PH"),getLabel("ePH.RouteDescription.label","PH"),getLabel("ePH.ActionTextLabelinEnglish.label","PH"));
 
//if(parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame)) {
if(checkFieldsofMst( fields, names, parent.messageFrame)) {
//f_query_add_mod.checkFieldsofMst

	globalform_code= frmobj.form_code.value;
	globalroute_code=frmobj.route_code.value;;
	eval( formApply( parent.f_query_add_mod.document.formRouteForForm,PH_CONTROLLER ) ) ;

		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result1 ) {				
					onSuccess();
			}
	}

}
/*modify ends*/
if( mode == "0" ) {

		eval( formApply( parent.f_query_add_mod.document.formRouteForForm,PH_CONTROLLER ) ) ;
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result1 ) {
			onSuccess();
		}
	}

}

/**********************************************************************************/
function onSuccess()
{

	var mode = parent.f_query_add_mod.document.formRouteForForm.mode.value;

	if( mode == MODE_INSERT )
	{
		parent.f_query_add_mod.document.formRouteForForm.reset();

		//formReset();
	}
	else if(mode == MODE_MODIFY )
		{
		//alert("inside onsuccess()");
		parent.f_query_add_mod.location.href="../../ePH/jsp/RouteForFormAddModify.jsp?mode="+MODE_MODIFY+"&form_code="+globalform_code+"&route_code="+globalroute_code;
		}
	else if(mode == MODE_DELETE )
		{
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
			//f_query_add_mod.document.formRouteForForm.reset();
			//create();
		}

}

function onSuccessD()
{

	var mode = f_query_add_mod.document.formRouteForForm.mode.value;

	
	 if(mode == MODE_DELETE )
		{
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
			//f_query_add_mod.document.formRouteForForm.reset();
			//create();
		}

}
/**********************************************************************************/

function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("routeforformquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}

	else if ( (url.indexOf("routeforformaddmodify")!=-1) ) {
		if(f_query_add_mod.document.formRouteForForm.mode.value == MODE_INSERT){

			formObj =   f_query_add_mod.document.formRouteForForm;

			var arrPKFieldNames     =   new Array();
            arrPKFieldNames[0]      =   "form_desc";
			arrPKFieldNames[1]      =   "route_desc";

			resetDuplicateClass(formObj,arrPKFieldNames);

			f_query_add_mod.document.formRouteForForm.reset();
			//create();
			//formReset() ;
		}
		else {
			f_query_add_mod.document.formRouteForForm.reset();
		}
	}
}
/**********************************************************************************/
function Modify(obj, route_color) {
	var form_code = obj.cells[0].innerText;
	var route_code = obj.cells[2].innerText;
	document.location.href="../../ePH/jsp/RouteForFormAddModify.jsp?mode="+MODE_MODIFY+"&form_code="+form_code+"&route_code="+route_code+"&route_color="+route_color;
}

/**********************************************************************************/
function assignResult( _result, _message, _flag, _invalidCode ) {
	result1 = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode ;

}

/**********************************************************************************/
function setEnabled(objname) {
	objname = "EQVL_VALUE_" + objname.substring(objname.length-1);;
	objname = eval("document.formUomForEqvl."+objname);
	objname.disabled = false;
}

/**********************************************************************************/
function validNumber(obj) {
	if ( CheckNum(obj) ) putDecimal(obj, 12, 6);
	if (obj.value != "")
		if (obj.value.indexOf(".") == -1 || obj.value.indexOf(".") > 6)
			alert("Invalid Number Format");
}



/**********************************************************************************/
function proceedOnApply()
{

	var url = parent.f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("routeforformquery")==-1) )
		return true;
	else
		return false;

}

/******************************************************************************/
function resetColorCode(obj)
{
	var arrPKFieldNames	=	new Array();
	var formObj			=	parent.f_query_add_mod.document.formRouteForForm;
	/**
	  * specify the primary key columns
	  */
	//arrPKFieldNames[0]	=	"form_desc";

	/**
	  * if more than one columns exists in
	  * the primary key, then the next columns
	  * can be given like this
	  */
	//arrPKFieldNames[1]	=	"route_desc";
	arrPKFieldNames[0]	=	"action_text_label";
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}
