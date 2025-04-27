//This file is saved on 18/10/2005


var case_type_code="";
var case_type_nature="";
var short_desc="";
var long_desc="";
var eff_status=""
var operation_func="";
/*********************************************************/
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/CaseTypeAddModify.jsp?mode=1";
}

/*********************************************************/
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/CaseTypeQueryCriteria.jsp";
}

var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;
/*********************************************************/
function apply()
{

		if (! checkIsValidForProceed() ) {
			//alert("HERE111111111");
		   message  = getMessage("APPLY_NOT_VALID","CP");
		   //alert(message);
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		}

	//var messageFrame = parent.frames[1].frames[2]; 
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	var frmobj=f_query_add_mod.document.form_casetype ;
	var operation=frmobj.operation_type.value;
	
	if(operation=="insert")
	{
				

	operation_func="insert";


	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fields = new Array (frmobj.case_type_code,
				                frmobj.short_desc,frmobj.long_desc);
			    
	var names = new Array (getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"), getLabel("Common.ExplanatoryText.label","Common"));
	var fields1 = new Array (frmobj.case_type_code);			    
	var names1 = new Array (getLabel("Common.code.label","Common"));
	var disp_type="M";
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.SpecialCharCheck( fields1, names1, messageFrame,disp_type,error_jsp))
	{
				 
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				frmobj.submit();
			}
	}	
}	


else
	{
		operation_func="modify";
		case_type_code=frmobj.case_type_code.value;
		case_type_nature=frmobj.case_type_nature1.value;
		short_desc=frmobj.short_desc.value;
		long_desc=frmobj.long_desc.value;
		eff_status=frmobj.eff_status.value;

		var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			var fields = new Array (frmobj.case_type_code,
				                frmobj.short_desc,frmobj.long_desc);
			    
			var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"),getLabel("Common.ExplanatoryText.label","Common"));
				 
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
			frmobj.case_type_nature1.disabled=false;
				frmobj.submit();
			}
	}
	
	
}

/*************************************************/

function checkIsValidForProceed(){

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) ){
		//alert("true");
		return true;
	}
	else{
		//alert("false");
		return false;
	}
}
/*********************************************/
function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/*********************************************************/
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}

/*********************************************************/
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


/*********************************************************/
function onSuccess()
{
	if(operation_func=="insert")
	{
					
		f_query_add_mod.location.href="../../eCP/jsp/CaseTypeAddModify.jsp?mode=1";
	}
	else
	{
		f_query_add_mod.location.href="../../eCP/jsp/CaseTypeAddModify.jsp?mode=2&case_type_nature="+case_type_nature+"&case_type_code="+case_type_code+"&eff_status="+eff_status;
	}
}
/*********************************************************/
function reset()

	{
		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.location.reload();
	}	


/*********************************************************/
function radioselect(obj){
	
var frmObj=document.forms[0];
		
	if(obj.checked==true){
		frmObj.case_type_nature1.value=obj.value;
	}
	
	}
/******************************************************************/
function checkForMax(obj){
	var expltext=obj.value;
	if(expltext.length>400){
		message=getMessage("CAN_NOT_BE_EXEED","CP");
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ message;
		obj.select();
		obj.focus();
	}
}
/*****************************************************************/
