//This file is saved on 18/10/2005



var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;


//Function to create a value in insert mode...
function create()
{
    f_query_add_mod.location.href="../../eCP/jsp/DependencyAddModify.jsp?mode=1";
}
//*******************************************************************

//Function to create a value in update mode...
function query() 
{
	f_query_add_mod.location.href="../../eCP/jsp/DependencyQueryCriteria.jsp";
}
//*******************************************************************
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
//*******************************************************************

//function to submit the form.......
function apply()
{
    //var messageFrame = parent.frames[1].frames[2];
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if (! checkIsValidForProceed()) 
	{
        message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
    var formObj = f_query_add_mod.document.DependencyAddModify_Form;
	
    var reassess_interval=formObj.Reassessment_Interval.value;
	
	

      
	var fields = new Array ( formObj.Dependency_code,formObj.Dependency_Longdesc,formObj.Dependency_Shortdesc,formObj.Dependency_Level	,formObj.Reassessment_Interval,formObj.Reassessment_Unit);

	var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("eCP.ReassessmentInterval.label","CP"),getLabel("eCP.ReassessmentUnit.label","CP"));		
     			
	if(formObj.eff_status_yn.checked == true)
	{
		formObj.eff_status_yn.value = "E";
	}
	else
	{
		formObj.eff_status_yn.value = "D";
    }

        var disp_type="M";
	var specfield=new Array(formObj.Dependency_code);
	var specname=new Array(getLabel("Common.code.label ","Common"));
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";

	if(reassess_interval=='0' || reassess_interval=='00' || reassess_interval=='000')
    {
	  message  = getMessage("REASSESS_INTVL_NOT_ZERO","CP");
      messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	  return false ;
   	}

	if(f_query_add_mod.SpecialCharCheck( specfield, specname, messageFrame,disp_type,error_jsp))
	{
        if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
           formObj.submit();
	    }
	}
}

//*******************************************************************
function onSuccess()
{
	var frmobj=f_query_add_mod.document.DependencyAddModify_Form;
	if(frmobj.mode.value == "1" )
	{
		frmobj.reset();
	}
	else if(frmobj.mode.value=="2")
	{
        var qry_str="&dependency_code="+frmobj.Dependency_code.value+"&long_desc="+frmobj.Dependency_Longdesc.value+"&short_desc="+frmobj.Dependency_Shortdesc.value+"&dependency_level="+frmobj.Dependency_Level1.value+"&reassessment="+frmobj.Reassessment_Interval.value+"&durn_type="+frmobj.Reassessment_Unit.value+"&guideline="+frmobj.guideline.value+"&eff_status="+frmobj.eff_status_yn.value;
        f_query_add_mod.location.href='../../eCP/jsp/DependencyAddModify.jsp?mode=2'+qry_str;
	}
}

//*******************************************************************
function reset()
{
     if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
}

//*******************************************************************
function ReassessmentUnit()
{
  var formObj=document.DependencyAddModify_Form;
  var len=formObj.Reassessment_Unit.length;
  for(var i=0;i<len;i++)
  {
    if(formObj.Reassessment_Unit.options[i].selected==true)
    {
        formObj.Reassessment_Unit1.value=formObj.Reassessment_Unit.options[i].value;
    }
   }
}

//*******************************************************************
function DependencyLevel(obj)
{
  var formObj=document.DependencyAddModify_Form;
  formObj.Dependency_Level1.value=obj.value;
}
//*******************************************************************

function checkForMax(obj){
	var expltext=obj.value;
	if(expltext.length > 4000){
		message=getMessage("LENGTH_CANT_EXCEED","CP");
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ message;
		obj.select();
		obj.focus();
	}
}
//********************************************************************



