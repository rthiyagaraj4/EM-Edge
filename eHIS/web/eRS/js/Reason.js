function create() {
	f_query_add_mod.location.href = "../../eRS/jsp/ReasonAddModify.jsp?mode=1";
}

/*****************************************************************************/
function query() {
	//alert("in query");
f_query_add_mod.location.href="../../eRS/jsp/ReasonQueryCriteria.jsp";
}
/*****************************************************************************/
function reset(){
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
}

/*****************************************************************************/

function apply(){
	var message="";
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if (! checkIsValidForProceed() ) {
	     //message  = getMessage("NOT_VALID","Common");
	     message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	var frmobj=f_query_add_mod.document.form_ReasonAddModify ;
	var operation=frmobj.operation_type.value;
if(operation=="insert")
	{

	operation_func="insert";
	var error_jsp = "../../eCommon/jsp/MstCodeError.jsp";
			var field = new Array (frmobj.reason_code,
				                frmobj.reason_desc,frmobj.activity_type_code);
			 
			var name = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"),getLabel("Common.ApplicableTo.label","common"));
		var fields = new Array (frmobj.reason_code);			    
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
		reason_code=frmobj.reason_code.value;
		reason_desc=frmobj.reason_desc.value;
		frmobj.activity_type_code1.value	 =	 frmobj.activity_type_code.value
		activity_type_code=frmobj.activity_type_code1.value;
		eff_status=frmobj.eff_status.value;
		var error_page = "../../eCommon/jsp/MstCodeError.jsp";
		var fields = new Array (frmobj.reason_code, frmobj.reason_desc,frmobj.activity_type_code);
			    
			var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"),getLabel("Common.ApplicableTo.label","common"));
				 
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				frmobj.submit();
			}
	}
	

}



/****************************************************************************/

function onSuccess() {
	
if(operation_func=="insert")
			f_query_add_mod.location.href="../../eRS/jsp/ReasonAddModify.jsp?mode=1";
	
	else
		f_query_add_mod.location.href="../../eRS/jsp/ReasonAddModify.jsp?mode=2&reason_code="+reason_code+"&reason_desc="+reason_desc+"&activity_type_code="+activity_type_code+"&eff_status="+eff_status;
}

/*****************************************************************************/
/*-----------to assign value of the enabled chk box------------------------*/
/****************************************************************************/

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

/******************************************************************************/
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
