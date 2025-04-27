function create()
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyLevelofCare.jsp" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eAM/jsp/LevelofCareQueryCriteria.jsp" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply()
{
		var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array (f_query_add_mod.document.LevelOfCare_form.level_of_care_code);

	var names  =  new Array ("level_of_care_code");

	//var messageFrame = parent.frames[1].frames[2]; 


	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields, names, messageFrame, "M", error_page))
	{  
		var fields = new Array (
			f_query_add_mod.document.LevelOfCare_form.level_of_care_code,
			f_query_add_mod.document.LevelOfCare_form.level_of_care_desc,
			f_query_add_mod.document.LevelOfCare_form.level_of_care_indicator );

		var names = new Array (	getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),  getLabel("Common.INDICATOR.label","Common"));

		if(f_query_add_mod.checkFieldsofMst(fields, names, messageFrame))
		{
			f_query_add_mod.document.LevelOfCare_form.level_of_care_indicator.disabled = false;
			f_query_add_mod.document.LevelOfCare_form.submit();
		}
	}
}

function onSuccess()
{
	f_query_add_mod.location.reload() ;
}

function reset()
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	if(f_query_add_mod.document.forms[0].name == "query_form")
	{	
			f_query_add_mod.document.query_form.reset() ;	
	}
	else if(f_query_add_mod.document.forms[0].function_name.value == "modify")
	{
		
		f_query_add_mod.document.forms[0].reset() ;
		f_query_add_mod.document.forms[0].level_of_care_indicator.value = f_query_add_mod.document.forms[0].hddLOC.value ;
        f_query_add_mod.document.forms[0].eff_status.value=f_query_add_mod.document.forms[0].status.value;
	}
	else
	{
		if(f_query_add_mod.document.forms[0].name == "LevelOfCare_form")
		{
			
			f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.forms[0].level_of_care_code.focus();
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
			parent.frames[1].location.href = "../../eAM/jsp/addModifyNursingUnit.jsp?allow_alter=Y&nursing_unit_code="+nursing_unit_code ;
		}
	}
}
