//This file is saved on 18/10/2005


var result = false;
var message = "" ;
var flag = true ;
var invalidCode ="";
var function_id = "";

function create(){
	f_query_add_mod.location.href="../../eCP/jsp/InterventionTypeAddModify.jsp?mode=1";
}
/*************************************************/
function apply(){	

	if (! checkIsValidForProceed() ) {
		message  =getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	

	//var messageFrame = parent.frames[1].frames[1]; 
	var frmobj=f_query_add_mod.document.form_add_mod ;
	var mode=frmobj.mode.value;
	if(mode=="2"){
		var efstatus=frmobj.eff_status.value;
		qry_str="&intervention_type="+frmobj.intervention_type.value+"&long_desc="+frmobj.intervention_long_desc.value+"&short_desc="+frmobj.intervention_short_desc.value+"&eff_status="+frmobj.eff_status.value;
	}

	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fields = new Array (frmobj.intervention_type,frmobj.intervention_long_desc,frmobj.intervention_short_desc);			    
	var names = new Array (getLabel("Common.code.label","common"),getLabel("Common.longdescription.label","common"),getLabel("Common.shortdescription.label","common"));		
	
	var fields1 = new Array (frmobj.intervention_type);			    
	var names1 = new Array (getLabel("Common.code.label","common"));
	var disp_type="M";
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";
	if(mode!="2")
	{
		if(f_query_add_mod.SpecialCharCheck( fields1, names1, messageFrame,disp_type,error_jsp))
		{
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				frmobj.submit();
		}
	}
	else
	{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				frmobj.submit();
	}
}
/************************************************/
/************************************************/


/*************************************************/
function onSuccess(){	 
	var frmobj=f_query_add_mod.document.form_add_mod ;
	var mode=frmobj.mode.value;
	if(( mode == "1" ))
		frmobj.reset();
	else if(mode=="2")
		f_query_add_mod.location.href='../../eCP/jsp/InterventionTypeAddModify.jsp?mode=2'+qry_str;
}
/*************************************************/

function checkIsValidForProceed(){

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/*********************************************/

function reset(){

	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
}
/*************************************************/
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/InterventionTypeQueryCriteria.jsp";
}
/********************************************/

function onenable(target){
	if(target.checked==false)
	{
		target.value="D";
		target.checked=false;
	}
	else
	{
		target.value="E";
		target.checked=true;
	}

	
}





