function reset() {
	f_query_add_mod.document.repMonRegnAgeStat.reset() ;
}

function run() 
{
	var fields = new Array ( f_query_add_mod.document.repMonRegnAgeStat.p_age_range_code );
    var names = new Array ( getLabel('Common.AgeRange.label','common') );

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		
		var from = f_query_add_mod.document.repMonRegnAgeStat.p_fm_date;
		var to     = f_query_add_mod.document.repMonRegnAgeStat.p_to_date ;  
		var fields = new Array( f_query_add_mod.document.repMonRegnAgeStat.p_fm_date,
                            f_query_add_mod.document.repMonRegnAgeStat.p_to_date );

		var names = new Array(getLabel('eMP.RegnMonthFrom.label','MP'), getLabel('eMP.RegnMonthTo.label','MP'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		//if( f_query_add_mod.checkmonths(getLabel('Common.Registration.label','common')+ " " + getLabel('Common.month.label','common'), from , to, messageFrame ) ) 
		if( f_query_add_mod.doDateChkWithLabel(from , to, messageFrame, 'MY', getLabel('Common.Registration.label','common')+ " " + getLabel('Common.month.label','common'))) 
		{
			if (f_query_add_mod.trimCheck(from.value)) 
			{
				//f_query_add_mod.document.repMonRegnAgeStat.p_fm_regndate.value = '01/' + from.value;
				f_query_add_mod.document.repMonRegnAgeStat.p_fm_regndate.value = from.value;
			}
			if (f_query_add_mod.trimCheck(to.value)) 
			{
				//f_query_add_mod.document.repMonRegnAgeStat.p_to_regndate.value = f_query_add_mod.LastDate(to)+'/' + to.value;
				f_query_add_mod.document.repMonRegnAgeStat.p_to_regndate.value = to.value;
			}
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.repMonRegnAgeStat.submit() ;
		}		
	}
}
}

function onChangeFacilityId()
{
    var facltyid = document.repMonRegnAgeStat.P_facilityid.value;
	var optlength = document.repMonRegnAgeStat.p_age_range_code.options.length;
	if(facltyid=='All')
	{
		document.repMonRegnAgeStat.p_age_range_code.disabled=true;
	}
	else
	{
				document.repMonRegnAgeStat.p_age_range_code.disabled=false;
	for (var i=0; i<optlength; i++)
	{
		document.repMonRegnAgeStat.p_age_range_code.options.remove("p_age_range_code");
	}
		var HTMLVal="<html><body onKeyDown='lockKey()'><form name='GetAgeRangeForm' id='GetAgeRangeForm' method='get' action='../../eMP/jsp/GetAgeRange.jsp'>"+
				"<input type='hidden' name='facility' id='facility' value='"+facltyid+"'>"+
		"</form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.messageFrame.document.GetAgeRangeForm.submit();
	}
}

