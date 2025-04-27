function checkActive(target){
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
function create() {
	f_query_add_mod.location.href = "../../eRS/jsp/LicensureAddModify.jsp?mode=1";
}
/***************************************************************/
function query() {
		f_query_add_mod.location.href = "../../eRS/jsp/LicensureQueryCriteria.jsp";
}
/***************************************************************/
function reset(){
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) 
		f_query_add_mod.document.forms[0].reset();
}
/***************************************************************/
function apply()
{
	var message="";
	//var messageFrame = parent.frames[1].frames[2]; 
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if (! checkIsValidForProceed() ) {
	     //message  = getMessage("NOT_VALID","Common");
	     message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	var frmobj=f_query_add_mod.document.form_LicensureAddModify ;
	var operation=frmobj.operation_type.value;
if(operation=="insert")
	{

	operation_func="insert";
	var error_jsp = "../../eCommon/jsp/MstCodeError.jsp";
			var field = new Array (frmobj.license_code,
				                frmobj.license_desc);
			 
			var name = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));
		var fields = new Array (frmobj.license_code);			    
	var names = new Array (getLabel("Common.code.label","Common"));
	var disp_type="M";
	if(f_query_add_mod.SpecialCharCheck( fields, names, messageFrame,disp_type,error_jsp))
	{
		if(f_query_add_mod.checkFieldsofMst( field, name, messageFrame))
			{
				frmobj.submit();
			}
	}

	}
	else
	{

		operation_func="modify";
		license_code=frmobj.license_code.value;
		license_desc=frmobj.license_desc.value;
		license_expl_text=frmobj.license_expl_text.value;
		eff_status=frmobj.eff_status.value;
		var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			var fields = new Array (frmobj.license_code,
				                frmobj.license_desc);
			    
			var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));
				 
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				frmobj.submit();
			}
	}
	
	
}
/***************************************************************/
function onSuccess()
{
	if(operation_func=="insert")
			f_query_add_mod.location.href="../../eRS/jsp/LicensureAddModify.jsp?mode=1";
	
	else
		f_query_add_mod.location.href="../../eRS/jsp/LicensureAddModify.jsp?mode=2&license_code="+license_code+"&license_desc="+license_desc+"&license_expl_text="+license_expl_text+"&eff_status="+eff_status;
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
/****************************************************************/
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/****************************************************************/
