 function create() { 
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyBuildinginfacility.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/BuildinginfacilityQueryCriteria.jsp" ;
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
function apply() {
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array (    f_query_add_mod.document.building_form.facility,
						f_query_add_mod.document.building_form.bldng_code,
						f_query_add_mod.document.building_form.long_desc,
						f_query_add_mod.document.building_form.short_desc
			       );

	var names = new Array (getLabel("Common.facility.label",'Common'),
				getLabel("Common.code.label",'Common'),
				getLabel("Common.longdescription.label",'Common'),
				getLabel("Common.shortdescription.label",'Common'));
//////////Added by Manish Anand on 01-07-2002////////////////////
	var spFields = new Array (f_query_add_mod.document.building_form.bldng_code);
	var spNames = new Array ("Building Code");
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		f_query_add_mod.document.building_form.submit();
			var fn_status = f_query_add_mod.document.building_form.function_name.value ;
			if(fn_status == "insert")  {}

	}
}

var facID="";
function onSuccess() {

if(f_query_add_mod.document.forms[0].function_name.value == 'insert')
	{
/////////////////Added by Manish Anand on 01-07-2002///////////////
	//f_query_add_mod.location.reload();
	facID = f_query_add_mod.document.building_form.facility.value;
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyBuildinginfacility.jsp?facilityId="+facID ;
///////////////////////////////////////////////////////////////////

/*	f_query_add_mod.document.building_form.bldng_code.value	= "" ;
	f_query_add_mod.document.building_form.short_desc.value	= "" ;
	f_query_add_mod.document.building_form.long_desc.value		= "" ;
	f_query_add_mod.document.building_form.eff_status.checked=true;*/
	}
	else
	f_query_add_mod.location.reload();
}

function reset() {

			if(f_query_add_mod.document.forms[0])
				//f_query_add_mod.document.forms[0].reset();
				f_query_add_mod.document.location.reload();

}
