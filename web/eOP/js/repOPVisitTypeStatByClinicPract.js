
function run() 
{

	f_query_add_mod.document.forms[0].p_visit_type_from.value = f_query_add_mod.document.forms[0].p_fm_visit_type.value;
	f_query_add_mod.document.forms[0].p_visit_type_to.value = f_query_add_mod.document.forms[0].p_to_visit_type.value;	
	f_query_add_mod.document.forms[0].p_clinic_from.value = f_query_add_mod.document.forms[0].p_fm_locn_code.value;
	f_query_add_mod.document.forms[0].p_clinic_to.value = f_query_add_mod.document.forms[0].p_to_locn_code.value;	
	f_query_add_mod.document.forms[0].p_pract_from.value = f_query_add_mod.document.forms[0].p_fm_pract_id.value;	
	f_query_add_mod.document.forms[0].p_pract_to.value=	f_query_add_mod.document.forms[0].p_to_pract_id.value;	
	f_query_add_mod.document.forms[0].p_visit_status.value = f_query_add_mod.document.forms[0].visit_status.value;
	f_query_add_mod.document.forms[0].p_date_from.value = f_query_add_mod.document.forms[0].p_fm_date.value;	
	f_query_add_mod.document.forms[0].p_date_to.value = f_query_add_mod.document.forms[0].p_to_date.value;	

	f_query_add_mod.document.forms[0].p_specialty_from_code.value = f_query_add_mod.document.forms[0].p_fm_specialty_code.value;	
	f_query_add_mod.document.forms[0].p_specialty_to_code.value = f_query_add_mod.document.forms[0].p_to_specialty_code.value;	

	f_query_add_mod.document.forms[0].p_service_from_code.value = f_query_add_mod.document.forms[0].p_fm_service_code.value;	
	f_query_add_mod.document.forms[0].p_service_to_code.value = f_query_add_mod.document.forms[0].p_to_service_code.value;
	
	var fields = new Array( f_query_add_mod.document.forms[0].p_date_from,
							 f_query_add_mod.document.forms[0].p_date_to );
	var names = new Array(getLabel("eOP.StatisticsDateFrom.label","Op"), getLabel("eOP.StatisticsDateTo.label","Op"));
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
	if(chkGrtr(f_query_add_mod.document.forms[0].p_date_from,
       f_query_add_mod.document.forms[0].p_date_to)==true)
	if(f_query_add_mod.CheckString( getLabel("Common.VisitTypeCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_visit_type,f_query_add_mod.document.forms[0].p_to_visit_type,messageFrame))
	if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))

	if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
	if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_service_code,f_query_add_mod.document.forms[0].p_to_service_code,messageFrame))

	if(f_query_add_mod.CheckString( getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))
	{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.forms[0].submit();
	}
}
	
}
function chkGrtr(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}
/*function validateDate(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}*/


function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}



