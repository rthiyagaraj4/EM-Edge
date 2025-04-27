//This file is saved on 18/10/2005

var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;

//Function to create a value in insert mode...
function create()
{
    f_query_add_mod.location.href="../../eCP/jsp/ReasonAddModify.jsp?mode=1";
}

//Function to create a value in update mode...
function query() 
{	
	f_query_add_mod.location.href="../../eCP/jsp/ReasonQueryCriteria.jsp";		
}

//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

//function to submit the form.......
function apply()
{
	   var formObj = f_query_add_mod.document.ReasonAddModify_Form;
      //  var messageFrame = parent.frames[1].frames[2]; 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

	if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	if (formObj.eff_status.checked==true)
	{
		formObj.eff_status.value = "E";
	}
	else
	{
		formObj.eff_status.value = "D";
	}
	var fields = new Array();
	var names = new Array();
	//alert("eff_status: "+formObj.eff_status.value);
        
	fields[0] = formObj.reason_code;
	fields[1] = formObj.reason;
	fields[2] = formObj.activity_code;

	names[0] = getLabel("Common.ReasonCode.label","Common");
	names[1] = getLabel("Common.ReasonDescription.label","Common"); 
	names[2] = getLabel("Common.ApplicableTo.label","common"); 
	

	var disp_type="M";
	var specfield=new Array(formObj.reason_code);
	var specname=new Array(getLabel("Common.ReasonCode.label","Common"));
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.SpecialCharCheck( specfield, specname, messageFrame,disp_type,error_jsp))
	{
		 if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{	
			formObj.submit();
        }
	}
}
//************************************************
function reset(){

	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) 
		f_query_add_mod.document.forms[0].reset();

}

function onSuccess()
{
	var frmobj=f_query_add_mod.document.ReasonAddModify_Form ;
	var mode=frmobj.mode.value;
	if(mode == "1" )
	{
		frmobj.reset();
	}
	else if(mode=="2")
	{
        var qry_str="&reason_code="+frmobj.reason_code.value+"&reason="+frmobj.reason.value+"&activity_code="+frmobj.activity_code.value+"&activity_desc="+frmobj.activity_desc.value+"&eff_status="+frmobj.eff_status.value;
	f_query_add_mod.location.href='../../eCP/jsp/ReasonAddModify.jsp?mode=2'+qry_str;
	}
}


function indicatorcheck(obj)
{
  var formObj=document.ReasonAddModify_Form;
  if(obj.checked==true)
  {
    formObj.Indicator1.value=obj.value;
    }
}
