  var function_id =   "" ;
var result1     =   false ;
var message     =   "" ;
var flag        =   "" ;
var invalidCode =  "";
var globalCode  =   "";
var formObj     =   null;

/******************************************************************************/
function query() {
	
	
    f_query_add_mod.location.href="../../ePH/jsp/TransTypeQueryResult.jsp";
}

/******************************************************************************/
function reset() {

    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();

    if ( (url.indexOf("drugcategoryquerycriteria")!=-1) ) {
        f_query_add_mod.document.frmTransTypeQueryResult.reset();
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
            //formReset() ;
        }
        else {
            f_query_add_mod.document.formDrugCategory.reset();
        }
    }
}
/******************************************************************************/
function SubmitLink(from,to){
<!--alert('On click'+document.frames.name)-->;
	var obj=document.frames.frmTransTypeQueryResult;	
	obj.from.value=from;
	obj.to.value=to;	
	obj.submit();
}