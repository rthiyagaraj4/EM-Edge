
function create() {
	f_query_add_mod.location.href = "../../eRS/jsp/SkillAddModify.jsp?mode=1";
}

/***************************************************************/

function apply(){
if (! checkIsValidForProceed() ) {
	     //message  = getMessage("NOT_VALID","Common");
	     message  = "";
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		return false ;
	}

	
	var frmobj=f_query_add_mod.document.form_add_mod ;
	var mode=frmobj.mode.value;
	if(mode=="2"){
		var efstatus=frmobj.eff_status.value;
		qry_str="&skill_code="+frmobj.skill_code.value+"&skill_desc="+frmobj.skill_desc.value+"&skill_expl_text="+frmobj.skill_expl_text.value+"&eff_status="+frmobj.eff_status.value;
	}
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fields = new Array (frmobj.skill_code,frmobj.skill_desc);			    
	var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","common"));		

	var fields1 = new Array (frmobj.skill_code);			    
	var names1 = new Array (getLabel("Common.code.label","Common"));
	var disp_type="M";
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.SpecialCharCheck( fields1, names1, messageFrame,disp_type,error_jsp))
	{
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		frmobj.submit();
	}
}

function checkIsValidForProceed(){
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

/***************************************************************/

function checkIsValidForProceed(){
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

/***************************************************************/
function onSuccess(){	 
	var frmobj=f_query_add_mod.document.form_add_mod ;
	var mode=frmobj.mode.value;
	if(mode == "1")
	{
		frmobj.reset();
	}
	else if(mode=="2")
		f_query_add_mod.location.href='../../eRS/jsp/SkillAddModify.jsp?mode=2'+qry_str;
}

/***************************************************************/
function query() {
		f_query_add_mod.location.href = "../../eRS/jsp/SkillQueryCriteria.jsp";
}
/***************************************************************/
	function reset(){
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
}

/***************************************************************/

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

/***************************************************************/
/****************************************************************/
function checkForMax(obj){
	var expltext=obj.value;
	if(expltext.length > 4000){
		message=getMessage("EXPLTEXT_MAX_4000","RS");
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ message;
		obj.select();
		obj.focus();
	}
}
/****************************************************************/
