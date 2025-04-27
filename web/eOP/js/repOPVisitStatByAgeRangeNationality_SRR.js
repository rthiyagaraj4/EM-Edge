function run() 
{
	f_query_add_mod.document.forms[0].p_visit_status.value = f_query_add_mod.document.forms[0].visit_status.value;
	f_query_add_mod.document.forms[0].p_fm_visit_date.value = f_query_add_mod.document.forms[0].p_fm_date.value;	
	f_query_add_mod.document.forms[0].p_to_visit_date.value = f_query_add_mod.document.forms[0].p_to_date.value;	
	f_query_add_mod.document.forms[0].p_facilityid.value = f_query_add_mod.document.forms[0].P_facilityid.value;
    
	f_query_add_mod.document.forms[0].p_fm_nation_code1.value = f_query_add_mod.document.forms[0].p_fm_nation_code.value;	
	f_query_add_mod.document.forms[0].p_to_nation_code1.value = f_query_add_mod.document.forms[0].p_to_nation_code.value;

	f_query_add_mod.document.forms[0].p_fm_race_code1.value = f_query_add_mod.document.forms[0].p_fm_race_code.value;	
	f_query_add_mod.document.forms[0].p_to_race_code1.value = f_query_add_mod.document.forms[0].p_to_race_code.value;

	
	var fields = new Array( f_query_add_mod.document.forms[0].p_age_range_code,f_query_add_mod.document.forms[0].p_fm_visit_date,
			f_query_add_mod.document.forms[0].p_to_visit_date );
	var names = new Array(getLabel("Common.AgeRange.label","Common"),(getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common")),(getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common")));
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{		if(chkGrtr(f_query_add_mod.document.forms[0].p_fm_visit_date,f_query_add_mod.document.forms[0].p_to_visit_date)==true)
	       {
		       if(f_query_add_mod.CheckString( getLabel("Common.NationalityCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_nation_code,f_query_add_mod.document.forms[0].p_to_nation_code,messageFrame))    
		         if(f_query_add_mod.CheckString( getLabel("Common.race.label","Common")+getLabel("Common.Group.label","Common"),f_query_add_mod.document.forms[0].p_fm_race_code,f_query_add_mod.document.forms[0].p_to_race_code,messageFrame)) 
					if(f_query_add_mod.CheckString(getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code, messageFrame )  )
						if(f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
				    
			          f_query_add_mod.document.forms[0].submit();
			}
	}
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

 function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}

function setDate(Object){ 

//var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
	}

function changerepId(obj)
{
	if(obj.checked)
		document.forms[0].p_report_id.value='OPVSAGNL';
	else
		document.forms[0].p_report_id.value='OPVSAGNT';
}



