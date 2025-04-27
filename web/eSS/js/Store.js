/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href="../../eSS/jsp/StoreAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/StoreQueryCriteria.jsp?function_id="+function_id;
}

function apply() {
if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
	var formObj		=	f_query_add_mod.document.formStore ;
    if(formObj.disable_store.value=="")
	{


			var fields		=	new Array ( formObj.store_code);
			var names		=	new Array ( getLabel("eSS.Store.label","SS"));
			var blankObject	=	null;
			var errorPage="../../eCommon/jsp/error.jsp";
			if (checkSSFields( fields, names, messageFrame))
			{
					eval(formApply(formObj,SS_CONTROLLER));
					messageFrame.location.href = errorPage+"?err_num="+ message;
					if( result ) {
						onSuccess();
					   }
			}
		
	}
	else
   {
    		var errorPage="../../eCommon/jsp/error.jsp";
			message=getMessage("DISABLED_MM_STORE_CODE","SS");
            messageFrame.location.href = errorPage+"?err_num="+ message;
   }
   
}
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("storequery")==-1) )
        return true;
    else
        return false;
}
function reset() {
	if(f_query_add_mod.document.formStore!=null)
		f_query_add_mod.document.formStore.reset();
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function onSuccess() {
	var mode = f_query_add_mod.document.formStore.mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else 
		f_query_add_mod.document.location.reload();
}

function doCheckUnCheck(){

	if(document.formStore.owner_yn.checked==true)
    {
		document.formStore.pre_allowed_yn.disabled=false;         
		document.formStore.iss_allowed_yn.disabled=false;
		document.formStore.adj_allowed_yn.disabled=false;
		document.formStore.var_allowed_yn.disabled=false;
		document.formStore.rof_allowed_yn.disabled=false;
	//Added on 11/04/2013  for CRF#Bru-HIMS-CRF-225 and inc#32071
		document.formStore.rql_allowed_yn.disabled=true;
		document.formStore.isl_allowed_yn.disabled=true;
		document.formStore.rtl_allowed_yn.disabled=true;
		document.formStore.pre_allowed_yn.checked=true;         
		document.formStore.iss_allowed_yn.checked=true;
		document.formStore.adj_allowed_yn.checked=true;
		document.formStore.var_allowed_yn.checked=true;
		document.formStore.rof_allowed_yn.checked=true;
		document.formStore.rql_allowed_yn.checked=false;
		document.formStore.isl_allowed_yn.checked=false;
		document.formStore.rtl_allowed_yn.checked=false;
	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		document.formStore.rqv_allowed_yn.disabled=false;
		document.formStore.rqv_allowed_yn.checked=false;
		document.formStore.rtv_allowed_yn.disabled=false;
		document.formStore.rtv_allowed_yn.checked=false;
	}
	else{
		document.formStore.pre_allowed_yn.disabled=true;         
		document.formStore.iss_allowed_yn.disabled=true;
		document.formStore.adj_allowed_yn.disabled=true;
		document.formStore.var_allowed_yn.disabled=true;
		document.formStore.rof_allowed_yn.disabled=true;
	//Added  on 11/04/2013 CRF#Bru-HIMS-CRF-225 and inc#32071
		document.formStore.rql_allowed_yn.disabled	=false;
		document.formStore.isl_allowed_yn.disabled	=false;
		document.formStore.rtl_allowed_yn.disabled	=false;
		document.formStore.pre_allowed_yn.checked=false;         
		document.formStore.iss_allowed_yn.checked=false;
		document.formStore.adj_allowed_yn.checked=false;
		document.formStore.var_allowed_yn.checked=false;
		document.formStore.rof_allowed_yn.checked=false;
		document.formStore.rql_allowed_yn.checked=false;
		document.formStore.isl_allowed_yn.checked=false;
		document.formStore.rtl_allowed_yn.checked=false;
	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		document.formStore.rqv_allowed_yn.disabled=true;
		document.formStore.rtv_allowed_yn.disabled=true;
		document.formStore.rqv_allowed_yn.checked=false;
		document.formStore.rtv_allowed_yn.checked=false;
	}
}

function isOwner_YNChecked(){
	return document.formStore.owner_yn.checked  
}

function Modify(obj){
	var store_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/StoreAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&store_code="+store_code;
}
