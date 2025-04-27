//This file is saved on 18/10/2005


var outcome_code="";
var outcome_type="";
var short_desc="";
var long_desc="";
var eff_status="";
var operation_func="";

function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/OutcomeAddModify.jsp?mode=1";
}
/********************************************/

function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/OutcomeQueryCriteria.jsp";
}
/********************************************/

function apply()
{
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	//var messageFrame = parent.frames[1].frames[2]; 
	if (! checkIsValidForProceed() ) {
	    var  message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	var frmobj=f_query_add_mod.document.form_Outcome ;
	var operation=frmobj.operation_type.value;
if(operation=="insert")
	{

	operation_func="insert";
	var error_jsp = "../../eCommon/jsp/MstCodeError.jsp";
			var field = new Array (frmobj.outcome_code,
				                frmobj.short_desc,frmobj.long_desc);
			 
			var name = new Array (getLabel("Common.code.label","common"),getLabel("Common.description.label","common"),getLabel("Common.ExplanatoryText.label","common"));
		var fields = new Array (frmobj.outcome_code);			    
	var names = new Array (getLabel("Common.code.label","common"));
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
		outcome_code=frmobj.outcome_code.value;
		outcome_type=frmobj.outcome_type1.value;
		short_desc=frmobj.short_desc.value;
		long_desc=frmobj.long_desc.value;
		eff_status=frmobj.eff_status.value;

		var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			var fields = new Array (frmobj.outcome_code,
				                frmobj.short_desc,frmobj.long_desc);
			    
			var names = new Array (getLabel("Common.code.label","common"),getLabel("Common.description.label","common"),getLabel("Common.ExplanatoryText.label","common"));
				 
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				//frmobj.outcome_type1.disabled=false;
				frmobj.submit();
			}
	}
	
	
}
/********************************************/
function checkActive(target)
{
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
function onSuccess()
{
		var chk =	false;
	//	alert("outcome_code "+outcome_code);
		var frmobj=f_query_add_mod.document.form_Outcome ;
		if(operation_func=="insert")
			outcome_code=frmobj.outcome_code.value;
		//alert("outcome_code "+outcome_code);
		chk=confirm(getLabel("eCP.DoYouWantAssociateOutcomeEvaluationMeasures.label","CP"));
		if(chk){
			var dialogHeight= "600px" ;
			var dialogWidth	= "900px" ;
			var dialogTop = "" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var retVal = window.showModalDialog("../../eCP/jsp/OutcomeMeasuresFrame.jsp?mode=1&outcome_code="+outcome_code,arguments,features);
		}
	if(operation_func=="insert")
		f_query_add_mod.location.href="../../eCP/jsp/OutcomeAddModify.jsp?mode=1";
	
	else
		f_query_add_mod.location.href="../../eCP/jsp/OutcomeAddModify.jsp?mode=2&outcome_type="+outcome_type+"&outcome_code="+outcome_code+"&short_desc="+short_desc+"&long_desc="+long_desc+"&eff_status="+eff_status;

	
}
/******************************************************/
function reset()

	{
		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.location.reload();
	}	
/*************************************************/
function radioselect(obj){
var frmObj=document.forms[0];
		
	if(obj.checked==true){
		frmObj.outcome_type1.value=obj.value;
	}
	
	}

/********************************************/
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

/******************************************************************/
function checkForMax(obj){
	var expltext=obj.value;
	if(expltext.length > 400){
		message=getMessage("CAN_NOT_BE_EXEED","CP");
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ message;
		obj.select();
		obj.focus();
	}
}
/*****************************************************************/
function CheckForAlphabets(event)
	{
	    var strCheck	=	'0123456789-';
	    var whichCode	=	(window.Event) ? event.which : event.keyCode;
	    key				=	String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	    return true ;
	}
