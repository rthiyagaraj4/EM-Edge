function create()
{
	f_query_add_mod.location.href="../../eMR/jsp/AccuracyAddModify.jsp?mode=1";
}
//*******************************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eMR/jsp/AccuracyQueryCriteria.jsp";
}
//*********************************************************************************************************
function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
}
//***********************************************************************************************************
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		{
		  return true;
		}
		else
		{
		  return false;
		}
}
//***********************************************************************************************************
function apply()
{
        var message="";
        var messageFrame = parent.frames[2].frames[2]; 
        if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var formObj	= f_query_add_mod.document.forms[0];
	var mode = formObj.mode.value;

	if(formObj.eff_status_yn.checked==true)
		formObj.eff_status_yn.value="E";
	else
		formObj.eff_status_yn.value="D";

    var	fields = new Array (formObj.Accuracy_code,formObj.Accuracy_Longdesc,formObj.Accuracy_Shortdesc);
    var	names =	new Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));

      var disp_type="M";
      var specfield=new Array(formObj.Accuracy_code);
      var specname=new Array(getLabel("Common.code.label","Common"));
      var error_jsp="../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck( specfield, specname, messageFrame,disp_type,error_jsp))
	{
        if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
           formObj.submit();
        }
	}
}
//*******************************************************************************************************
function onSuccess()
 {
  	   var formObj=f_query_add_mod.document.forms[0];
	    var mode =formObj.mode.value;
		    if(mode=="1")
		    {
		   	formObj.reset();
                    }
		    else if(mode=="2")
		    {
		         var qry_str="&accuracy_code="+formObj.Accuracy_code.value+"&long_desc="+formObj.Accuracy_Longdesc.value+"&short_desc="+formObj.Accuracy_Shortdesc.value+"&indicator="+formObj.Indicator.value+"&eff_status="+formObj.eff_status_yn.value;
                         f_query_add_mod.location.href='../../eMR/jsp/AccuracyAddModify.jsp?mode=2'+qry_str;
		    }
  }
//*******************************************************************************************************
function indicatorcheck(obj)
{
  var formObj=document.forms[0];
  if(obj.checked==true)
  {
    formObj.Indicator1.value=obj.value;
  }
}
