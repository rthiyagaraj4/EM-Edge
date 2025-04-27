function reset() {
	f_query_add_mod.document.repYrRegnAgeStat.reset() ;
}

function run() 
{
	var fields = new Array ( f_query_add_mod.document.repYrRegnAgeStat.p_age_range_code );
    var names = new Array (getLabel('Common.AgeRange.label','common') );

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		var from	=f_query_add_mod.document.repYrRegnAgeStat.p_fm_date;
		var to	=f_query_add_mod.document.repYrRegnAgeStat.p_to_date;
		var fields = new Array( f_query_add_mod.document.repYrRegnAgeStat.p_fm_date,
                            f_query_add_mod.document.repYrRegnAgeStat.p_to_date );

		var names = new Array( getLabel('eMP.RegnYearFrom.label','MP'), getLabel('eMP.RegnYearTo.label','MP'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		//if( f_query_add_mod.CheckString( getLabel('Common.Registration.label','common')+" "+ getLabel('Common.year.label','common'), from,to, messageFrame ) ) 
		if( f_query_add_mod.doDateChkWithLabel( from,to, messageFrame, 'YY', getLabel('Common.Registration.label','common')+" "+ getLabel('Common.year.label','common'))) 
		{
			if ( from.value.length > 0 ) 
			{
				//f_query_add_mod.document.repYrRegnAgeStat.p_fm_regndate.value = '01/01/' + from.value;
				f_query_add_mod.document.repYrRegnAgeStat.p_fm_regndate.value =  from.value;
			}
			if (to.value.length > 0 )
			{
				//f_query_add_mod.document.repYrRegnAgeStat.p_to_regndate.value = '31/12/' + to.value;	
				f_query_add_mod.document.repYrRegnAgeStat.p_to_regndate.value =  to.value;
			}
			f_query_add_mod.document.repYrRegnAgeStat.submit() ;
		}	
	}
}
}
function onChangeFacilityId()
{
    var facltyid = document.repYrRegnAgeStat.P_facilityid.value;
	var optlength = document.repYrRegnAgeStat.p_age_range_code.options.length;
	if(facltyid=='All')
	{
		document.repYrRegnAgeStat.p_age_range_code.disabled=true;
	}
	else
	{
				document.repYrRegnAgeStat.p_age_range_code.disabled=false;
	for (var i=0; i<optlength; i++)
	{
		document.repYrRegnAgeStat.p_age_range_code.options.remove("p_age_range_code");
	}
		var HTMLVal="<html><body onKeyDown='lockKey()'><form name='GetAgeRangeForm' id='GetAgeRangeForm' method='get' action='../../eMP/jsp/GetAgeRange.jsp'>"+
				"<input type='hidden' name='facility' id='facility' value='"+facltyid+"'>"+
		"</form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.messageFrame.document.GetAgeRangeForm.submit();
	}
}

