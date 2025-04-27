function create()
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyEqpOthResourceTypes.jsp" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eAM/jsp/EqpOthResourceTypesQueryCriteria.jsp?function=EquipmentOtherResourceTypes";
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

	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	var fields = new Array ( 					f_query_add_mod.document.EquipmentOtherResourceTypes_form.resource_class,
	f_query_add_mod.document.EquipmentOtherResourceTypes_form.resource_type,
	f_query_add_mod.document.EquipmentOtherResourceTypes_form.long_desc,
	f_query_add_mod.document.EquipmentOtherResourceTypes_form.short_desc );

	var names = new Array ( getLabel("Common.resourceclass.label","Common")
,getLabel("Common.resourcetype.label","Common")
,getLabel("Common.longdescription.label","Common")
,getLabel("Common.shortdescription.label","Common")
);

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{
		f_query_add_mod.document.EquipmentOtherResourceTypes_form.submit();
	}
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	 f_query_add_mod.document.location.reload();
	/*
	if(f_query_add_mod.document.forms[0].resource_class.readOnly == true)
			f_query_add_mod.document.forms[0].long_desc.focus();			
	else
			f_query_add_mod.document.forms[0].resource_class.focus();
			*/
	
}
function change() 
{ 
	if (EquipmentOtherResourceTypes_form.eff_status.checked == true)
		EquipmentOtherResourceTypes_form.eff_status.value="E";
    else
    	EquipmentOtherResourceTypes_form.eff_status.value="D";
}
