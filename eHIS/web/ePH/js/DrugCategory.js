  //saved on 27/10/2005
var function_id =   "PH_DRUG_CATG" ;
var result1     =   false ;
var message     =   "" ;
var flag        =   "" ;
var invalidCode =  "";
var globalCode  =   "";
var formObj     =   null;

function create() {
	    f_query_add_mod.location.href="../../ePH/jsp/DrugCategoryAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {
    f_query_add_mod.location.href="../../ePH/jsp/DrugCategoryQueryCriteria.jsp?function_id="+function_id ;
}

function apply() {
	//alert("apply");

    formObj =   f_query_add_mod.document.formDrugCategory;

    var arrFieldName        =   new Array();
    var arrLegends          =   new Array();

    arrFieldName[0]         =   "drug_catg_code";
    arrFieldName[1]         =   "long_desc";
    arrFieldName[2]         =   "short_desc";

    arrLegends[0]           =   getLabel("Common.code.label","Common");
    arrLegends[1]           =   getLabel("Common.longdescription.label","Common");
    arrLegends[2]           =   getLabel("Common.shortdescription.label","Common");

    var arrPKFieldNames     =   new Array();
    arrPKFieldNames[0]      =   "drug_catg_code";

	if(!proceedOnApply())
    {
		//alert("proceed apply");
        messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
        return false;
    }

    var mode = formObj.mode.value;

    if( mode == MODE_INSERT )
    {
		//alert("apply while inserting");
        resetDuplicateClass(formObj,arrPKFieldNames);
        var result  =   validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
        if (result){
			//alert("if result condition");
            eval(formApply(formObj,PH_CONTROLLER));
	//		formApply(formObj,PH_CONTROLLER);
            if( result1 ) {
				//alert("if result condition");

                messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
                onSuccess();
            }
            if( invalidCode != "null" && invalidCode != "" ){
                messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message+":-"+invalidCode;
                showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame);
                }
        }
        else
        {
            return false;
        }
    }

   if( mode == MODE_MODIFY )
    {
	   //alert("Mode=Modify");
		if (formObj.pin_auth_reqd_yn.checked) {
        formObj.pin_auth_reqd_yn.value = "Y";  // Ensure it's checked
		} else {
        formObj.pin_auth_reqd_yn.value = "N";  // Ensure it's unchecked
		}
        globalCode= f_query_add_mod.document.formDrugCategory.drug_catg_code.value;
        var obj=f_query_add_mod.document.formDrugCategory;

        var fields = new Array ( obj.drug_catg_code,obj.long_desc,obj.short_desc);
        var names = new Array ( getLabel("Common.code.label","Common"), getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));
        if (f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){

        eval( formApply( f_query_add_mod.document.formDrugCategory,PH_CONTROLLER ) ) ;
        messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

            if( result1 ) {
                onSuccess();
            }
        }
    }

}

function onSuccess() {
	//alert("onsuccess");
    var mode = f_query_add_mod.document.formDrugCategory.mode.value;
    if( mode == MODE_INSERT ) {
        f_query_add_mod.document.formDrugCategory.reset();

    }
    else if(mode == MODE_MODIFY ){

        f_query_add_mod.location.href="../../ePH/jsp/DrugCategoryAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&drug_catg_code="+globalCode;
    }
}

function assignResult( _result, _message, _flag, _invalidCode ) {
    result1 = _result ;
    message  = _message ;
    flag = _flag ;
    invalidCode = _invalidCode ;
}

function reset() {

    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();

    if ( (url.indexOf("drugcategoryquerycriteria")!=-1) ) {
        f_query_add_mod.document.query_form.reset();
    }
    else if ( (url.indexOf("drugcategoryaddmodify")!=-1) )
    {
        if(f_query_add_mod.document.formDrugCategory.mode.value == MODE_INSERT)
        {
            formObj =   f_query_add_mod.document.formDrugCategory;

            var arrPKFieldNames     =   new Array();
            arrPKFieldNames[0]      =   "drug_catg_code";
			
			resetDuplicateClass(formObj,arrPKFieldNames);
            f_query_add_mod.document.formDrugCategory.reset();
        }
        else {
            f_query_add_mod.document.formDrugCategory.reset();
        }
    }
}

function toUpper(obj) {
    obj.value=obj.value.toUpperCase();
}

function Modify(obj){
	var drug_catg_code=obj.cells[0].innerText;
	document.location.href="../../ePH/jsp/DrugCategoryAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&drug_catg_code="+drug_catg_code;
}

function DrugCatgCheck(obj){
    if(!CheckChars(obj)){
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
        obj.focus();
        return false;
    }
}

function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("drugcategoryquery")==-1) )
        return true;
    else
        return false;
}

function resetColorCode(obj)
{
    var arrPKFieldNames =   new Array();
    var formObj         =   parent.f_query_add_mod.document.formDrugCategory;
    /**
      * specify the primary key columns
      */
    arrPKFieldNames[0]  =   "drug_catg_code";

    /**
      * if more than one columns exists in
      * the primary key, then the next columns
      * can be given like this
      */
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}

function setValue(obj){
	if(obj.checked)
        obj.value = "Y";
	else
		obj.value = "N";
}