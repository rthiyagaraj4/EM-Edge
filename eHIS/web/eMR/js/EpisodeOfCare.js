var result = false;
var message = "" ;
var flag = true ;
var invalidCode ="";
var function_id = "";
var modes = "";
function create(){
	f_query_add_mod.location.href="../../eMR/jsp/EpisodeOfCareAddModify.jsp?mode=1";
}
/*************************************************/
function apply(){	
 
	if (! checkIsValidForProceed() ) {
		message  =getMessage("APPLY_NOT_VALID",'MR');
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var messageFrame = parent.frames[1].frames[2]; 
	var frmobj=f_query_add_mod.document.form_add_mod ;
	var mode=frmobj.mode.value;
	
	if(mode=="2")
	{
		var efstatus=frmobj.eff_status.value;
		qry_str="&eoc_code="+frmobj.eoc_code.value+"&long_desc="+frmobj.episode_long_desc.value+"&short_desc="+frmobj.episode_short_desc.value+"&eff_status="+frmobj.eff_status.value;
		modes = "2";
	}
	else
	{
		modes = "1";
	}
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fields = new Array (frmobj.eoc_code,frmobj.episode_long_desc,frmobj.episode_short_desc);			    
	var names = new Array(getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"), getLabel("Common.shortdescription.label","Common"));		

	var fields1 = new Array (frmobj.eoc_code);			    
	var names1 = new Array (getLabel("Common.code.label","Common"));
	var disp_type="M";
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.SpecialCharCheck( fields1, names1, messageFrame,disp_type,error_jsp))
	{
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		frmobj.submit();
	onSuccess()
	}
}
function onSuccess()
{	 
	if(modes == "1")
		f_query_add_mod.document.form_add_mod.reset();
	else if(modes=="2")
		f_query_add_mod.document.location.reload()
}
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
	f_query_add_mod.location.href="../../eMR/jsp/EpisodeOfCareQueryCriteria.jsp";
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
/*************************************************/
