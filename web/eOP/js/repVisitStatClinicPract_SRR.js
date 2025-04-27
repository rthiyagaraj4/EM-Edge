
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
 	f_query_add_mod.document.forms[0].p_visit_type_from.value = f_query_add_mod.document.forms[0].p_fm_visit_type.value;
	f_query_add_mod.document.forms[0].p_visit_type_to.value = f_query_add_mod.document.forms[0].p_to_visit_type.value;
		
	f_query_add_mod.document.forms[0].p_clinic_from.value = f_query_add_mod.document.forms[0].p_fm_locn_code.value;
	f_query_add_mod.document.forms[0].p_clinic_to.value = f_query_add_mod.document.forms[0].p_to_locn_code.value;	
    f_query_add_mod.document.forms[0].p_specialty_code_from.value =f_query_add_mod.document.forms[0].p_fm_specialty_code.value;
	f_query_add_mod.document.forms[0].p_specialty_code_to.value	=f_query_add_mod.document.forms[0].p_to_specialty_code.value;
    f_query_add_mod.document.forms[0].p_service_code_from.value= f_query_add_mod.document.forms[0].p_fm_service_code.value;
	 f_query_add_mod.document.forms[0].p_service_code_to.value=f_query_add_mod.document.forms[0].p_to_service_code.value;

	  f_query_add_mod.document.forms[0].p_pract_id_from.value= f_query_add_mod.document.forms[0].p_fm_pract_id.value;
	 f_query_add_mod.document.forms[0].p_pract_id_to.value=f_query_add_mod.document.forms[0].p_to_pract_id.value;
	
	
	var fields = new Array(f_query_add_mod.document.forms[0].p_fm_date,
		f_query_add_mod.document.forms[0].p_to_date);
	//var names = new Array(getLabel("eOP.StatisticsDateFrom.label","Op"),getLabel("eOP.StatisticsDateTo.label","Op"));
	var names = new Array((getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common")), (getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common")));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
		if(chkGrtr(f_query_add_mod.document.forms[0].p_fm_date,
	        f_query_add_mod.document.forms[0].p_to_date) == true)
				if(f_query_add_mod.CheckString( getLabel("Common.VisitTypeCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_visit_type,f_query_add_mod.document.forms[0].p_to_visit_type,messageFrame))
                 if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
	              if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label",'Common'),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))	       
	                if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_service_code,f_query_add_mod.document.forms[0].p_to_service_code,messageFrame))
	                  if(f_query_add_mod.CheckString( getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))     
	                     f_query_add_mod.document.forms[0].submit();
	}

function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}



