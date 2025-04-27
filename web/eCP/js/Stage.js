//This file is saved on 18/10/2005.


function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/StageAddModify.jsp?mode=1";
}
//*******************************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/StageQueryCriteria.jsp";
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
				return false;
}
//***********************************************************************************************************
function apply()
{
        var message="";
        //var messageFrame = parent.frames[1].frames[2]; 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
        if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var formObj	= f_query_add_mod.document.Stage_form;
	var mode = formObj.mode.value;

	if(formObj.eff_status.checked==true)
		formObj.eff_status.value="E";
	else
		formObj.eff_status.value="D";
	if(mode=="2")
	{
		paramValues="&stage_code="+formObj.stage_code.value+"&long_desc="+formObj.long_desc.value+
		"&short_desc="+formObj.short_desc.value+"&stage_indicator="+formObj.stage_indicator.value+
		"&eff_status="+formObj.eff_status.value;
	}

    var	fields = new Array ( formObj.stage_code,formObj.long_desc,formObj.short_desc,formObj.stage_indicator);
    var	names =	new	Array (getLabel("Common.code.label","common"),getLabel("Common.longdescription.label","common"),getLabel("Common.shortdescription.label","common"),getLabel("eCP.StageIndicator.label","CP"));
	  if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame)) 
	  {
		  var flds=new Array(formObj.stage_code);
		  var nam=new Array(getLabel("Common.code.label","common"));
	    if(SpecialCharCheck(flds,nam,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{
			formObj.submit();
	     }
       }
}

//*******************************************************************************************************
 function onSuccess()
   {
	   var frmObj=f_query_add_mod.document.Stage_form;
	    var mode =frmObj.mode.value;
		    if(mode=="1")
		   		frmObj.reset();
		    else if(mode=="2")
			   f_query_add_mod.location.href='../../eCP/jsp/StageAddModify.jsp?mode=2'+paramValues;
  }
//*******************************************************************************************************
function oneffStatusCheck()
{
	var frmObj=	document.Stage_form;
	if(frmObj.eff_status.checked==true){
		frmObj.eff_status.value="E";
	}else
		frmObj.eff_status.value="D";
}
//*******************************************************************************************************
function onChangeIndicator(obj)
{
	document.Stage_form.stage_indicator1.value=obj.value;
}
//*******************************************************************************************************

