function create()
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyEqpOthResource.jsp" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eAM/jsp/EqpOthResourceQueryCriteria.jsp?function=EquipmentOtherResource";
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

	var fields = new Array ( 
		f_query_add_mod.document.EquipmentOtherResource_form.facId,
		f_query_add_mod.document.EquipmentOtherResource_form.resource_class,
		f_query_add_mod.document.EquipmentOtherResource_form.resource_type,
		f_query_add_mod.document.EquipmentOtherResource_form.resource_id,
		f_query_add_mod.document.EquipmentOtherResource_form.long_desc,
		f_query_add_mod.document.EquipmentOtherResource_form.short_desc );

	var names = new Array (getLabel("Common.facility.label","Common")
,getLabel("Common.resourceclass.label","Common")
,getLabel("Common.resourcetype.label","Common")
,getLabel("Common.resourceid.label","Common")
,getLabel("Common.longdescription.label","Common")
,getLabel("Common.shortdescription.label","Common")
);

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{
		if(f_query_add_mod.document.EquipmentOtherResource_form.rd_appl_yn.disabled==true)
			f_query_add_mod.document.EquipmentOtherResource_form.rd_appl_yn.disabled = false;

		f_query_add_mod.document.EquipmentOtherResource_form.submit();
	}
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.location.reload();

}
