
function reset() {
	f_query_add_mod.document.VisitByStatus_form.reset() ;
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

function run() 
{
	var fields = new Array( f_query_add_mod.document.VisitByStatus_form.p_fm_visit_date,
			f_query_add_mod.document.VisitByStatus_form.p_to_visit_date );

	var names = new Array(getLabel("Common.VisitDateFrom.label","Common"), getLabel("Common.VisitDateTo.label","Common"));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
			if(chkGrtr(f_query_add_mod.document.VisitByStatus_form.p_fm_visit_date,
					f_query_add_mod.document.VisitByStatus_form.p_to_visit_date)==true)
			{
			  if(f_query_add_mod.CheckString(getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.VisitByStatus_form.p_fm_service_code, f_query_add_mod.document.VisitByStatus_form.p_to_service_code, messageFrame ) )          
			  if(f_query_add_mod.CheckString(getLabel("Common.SpecialityCode.label","Common"),f_query_add_mod.document.VisitByStatus_form.P_FM_SPECIALTY_CODE, f_query_add_mod.document.VisitByStatus_form.P_TO_SPECIALTY_CODE, messageFrame ) )          
			  if(f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.VisitByStatus_form.p_fm_locn_code, f_query_add_mod.document.VisitByStatus_form.p_to_locn_code, messageFrame ) )          
			  if(f_query_add_mod.CheckString(getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.VisitByStatus_form.p_fm_pract_id, f_query_add_mod.document.VisitByStatus_form.p_to_pract_id, messageFrame ) )                
			  f_query_add_mod.document.VisitByStatus_form.submit() ;
			}
	}
}

/*function run() 
{
	var fields = new Array( f_query_add_mod.document.VisitByStatus_form.p_fm_visit_date,
			f_query_add_mod.document.VisitByStatus_form.p_to_visit_date );
	var names = new Array(getLabel("Common.VisitDateFrom.label","Common"), getLabel("Common.VisitDateTo.label","Common"));
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
    if( f_query_add_mod.doDateCheck( f_query_add_mod.document.VisitByStatus_form.p_fm_visit_date, f_query_add_mod.document.VisitByStatus_form.p_to_visit_date, messageFrame ))
    {
      if(f_query_add_mod.CheckString(getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.VisitByStatus_form.p_fm_service_code, f_query_add_mod.document.VisitByStatus_form.p_to_service_code, messageFrame ) )          
      if(f_query_add_mod.CheckString(getLabel("eOP.SubServiceCode.label","Op"),f_query_add_mod.document.VisitByStatus_form.p_fm_subservice_code, f_query_add_mod.document.VisitByStatus_form.p_to_subservice_code, messageFrame ) )          
      if(f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.VisitByStatus_form.p_fm_locn_code, f_query_add_mod.document.VisitByStatus_form.p_to_locn_code, messageFrame ) )          
      if(f_query_add_mod.CheckString(getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.VisitByStatus_form.p_fm_pract_id, f_query_add_mod.document.VisitByStatus_form.p_to_pract_id, messageFrame ) )                
      f_query_add_mod.document.VisitByStatus_form.submit() ;
    }
}
 }*/
