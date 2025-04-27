function reset()
{
	f_query_add_mod.document.UnmarriedList.reset() ;
} 				   

function run()
{	
	var fields = new Array( f_query_add_mod.document.UnmarriedList.p_from_birth_date,
                            f_query_add_mod.document.UnmarriedList.p_to_birth_date );
	var locale=f_query_add_mod.document.UnmarriedList.locale.value;
   // var names = new Array("Birth Date From", "Birth Date To");
    var names = new Array(getLabel('eMP.BirthDateFrom.label','MP'), getLabel('Common.birthDate.label','common')+ " "+ getLabel('Common.to.label','common'));

    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
			if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.UnmarriedList.p_from_birth_date, f_query_add_mod.document.UnmarriedList.p_to_birth_date, messageFrame,'DMY' ) )
			{				
				if (locale!="en")
				{
					f_query_add_mod.document.UnmarriedList.p_from_birth_date.value= convertDate(f_query_add_mod.document.UnmarriedList.p_from_birth_date.value,"DMY",locale,"en");
					f_query_add_mod.document.UnmarriedList.p_to_birth_date.value=convertDate(f_query_add_mod.document.UnmarriedList.p_to_birth_date.value,"DMY",locale,"en");;
				}
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		    f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.UnmarriedList.submit() ;
			}
		}
}


function onChangeFacilityId()
{
    var facltyid = document.repRegnAgeRelgnStat.P_facilityid.value;
	var optlength = document.repRegnAgeRelgnStat.p_age_range_code.options.length;
	if(facltyid=='All')
	{
		document.repRegnAgeRelgnStat.p_age_range_code.disabled=true;
	}
	else
	{
				document.repRegnAgeRelgnStat.p_age_range_code.disabled=false;
	for (var i=0; i<optlength; i++)
	{
		document.repRegnAgeRelgnStat.p_age_range_code.options.remove("p_age_range_code");
	}
		var HTMLVal="<html><body onKeyDown='lockKey()'><form name='GetAgeRangeForm' id='GetAgeRangeForm' method='get' action='../../eMP/jsp/GetAgeRange.jsp'>"+
				"<input type='hidden' name='facility' id='facility' value='"+facltyid+"'>"+
		"</form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.messageFrame.document.GetAgeRangeForm.submit();
	}
}


