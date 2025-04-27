function create()
{
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyNursingUnitType.jsp" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eIP/jsp/NursingUnitTypeQueryCriteria.jsp" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) && (url.indexOf("reset")==-1))
        return true;
    else
        return false;
  }
function apply()
{var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 


	var fields = new Array (f_query_add_mod.document.NursingUnitType_form.Type);
	var names  =  new Array ( getLabel('Common.type.label','common') );

	//var messageFrame = parent.frames[1].frames[2]; 
	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  

		var fields = new Array(
								f_query_add_mod.document.NursingUnitType_form.Type,
		   				        f_query_add_mod.document.NursingUnitType_form.long_desc,
								f_query_add_mod.document.NursingUnitType_form.short_desc
							  );

		var names = new Array (	getLabel('Common.type.label','common'),
								getLabel('Common.longdescription.label','common'),
								getLabel('Common.shortdescription.label','common')
							   )

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		f_query_add_mod.document.NursingUnitType_form.submit();
	}
  }
}


function onSuccess()
{
	f_query_add_mod.location.reload() ;
}


function reset()
{
	if (! (checkIsValidForProceed()) )
    {
        
		parent.frames[2].messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } else
	{
		if(  f_query_add_mod.document.forms[0].name == "NursingUnitType_form")
		{
		 f_query_add_mod.document.location.reload() ;
         f_query_add_mod.document.forms[0].Type.focus();
		}     
    else{
         f_query_add_mod.document.query_form.reset() ;

		}
	}
}


function page_ref(obj)
{
	var function_name=parent.frames[1].document.forms[0].function_name.value;
	if(function_name=='modify')
	{
		if(obj.checked==true)
		{
			var nursing_unit_code=parent.frames[1].document.forms[0].nursing_unit_code.value;
			parent.frames[1].location.href = "../../eIP/jsp/addModifyNursingUnit.jsp?allow_alter=Y&nursing_unit_code="+nursing_unit_code ;
		}
	}
}

//pasted from addModifyNursingUnitType.jsp

// This Function is called onclick of Enabled Chk Box...
// IF the Effective Status is enabled then the value for the chk box is set to 'E' & 'D' for Disabled.

function Change1()
{
	if ( NursingUnitType_form.eff_status.checked == true)
		NursingUnitType_form.eff_status.value="E";
	else
		NursingUnitType_form.eff_status.value="D";
}

/// This Function is called onclick of Deposit Applicable  & Additional Deposit Required Chk Box...

function change()
{
	if(NursingUnitType_form.deposit_appl_yn1.checked == true)
		NursingUnitType_form.deposit_appl_yn.value="Y";
	else
	{
		NursingUnitType_form.deposit_appl_yn1.checked = false;
		NursingUnitType_form.deposit_appl_yn.value="N";
	}

	 if(NursingUnitType_form.addl_dep_yn1.checked == true)
		NursingUnitType_form.addl_dep_yn.value="Y";
	 else
		NursingUnitType_form.addl_dep_yn.value="N";
}

function focusTxt()
{
	NursingUnitType_form.Type.focus();
}
