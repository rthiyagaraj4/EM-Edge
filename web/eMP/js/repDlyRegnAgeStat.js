function reset() {
	f_query_add_mod.document.repDlyRegnAgeStat.reset() ;
}

function run() 
{
	var fields = new Array ( f_query_add_mod.document.repDlyRegnAgeStat.p_age_range_code );
    var names = new Array ( getLabel('Common.AgeRange.label','common') );

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		var fields = new Array( f_query_add_mod.document.repDlyRegnAgeStat.p_fm_regndate,
                            f_query_add_mod.document.repDlyRegnAgeStat.p_to_regndate );

    var names = new Array(getLabel('eMP.RegnDateFrom.label','MP'), getLabel('Common.RegistrationDate.label','common')+" " + getLabel('Common.to.label','common'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
	
		if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.repDlyRegnAgeStat.p_fm_regndate, f_query_add_mod.document.repDlyRegnAgeStat.p_to_regndate, messageFrame ,'DMY') )
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.repDlyRegnAgeStat.submit() ;
	}

}
}

function onChangeFacilityId()
{
    var facltyid = document.repDlyRegnAgeStat.P_facilityid.value;
	var optlength = document.repDlyRegnAgeStat.p_age_range_code.options.length;
	if(facltyid=='All')
	{
		document.repDlyRegnAgeStat.p_age_range_code.disabled=true;
	}
	else
	{
				document.repDlyRegnAgeStat.p_age_range_code.disabled=false;
	for (var i=0; i<optlength; i++)
	{
		document.repDlyRegnAgeStat.p_age_range_code.options.remove("p_age_range_code");
	}
		var HTMLVal="<html><body onKeyDown='lockKey()'><form name='GetAgeRangeForm' id='GetAgeRangeForm' method='get' action='../../eMP/jsp/GetAgeRange.jsp'>"+
				"<input type='hidden' name='facility' id='facility' value='"+facltyid+"'>"+
		"</form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.messageFrame.document.GetAgeRangeForm.submit();
	}
}

