function reset()
{
	f_query_add_mod.document.UnderAge.reset() ;
} 				   

function run()
{
	var fields = new Array( f_query_add_mod.document.UnderAge.p_from_birth_date,
                            f_query_add_mod.document.UnderAge.p_to_birth_date );

    //var names = new Array("Birth Date From", "Birth Date To");
    var names = new Array(getLabel('Common.birthDate_fs.label','common')+"("+getLabel('eMP.Baby.label','mp')+")"+" "+getLabel('Common.from.label','common'),getLabel('Common.birthDate.label','common')+"("+getLabel('eMP.Baby.label','mp')+")"+" "+ getLabel('Common.to.label','common'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
	if( doDateChkWithLabel( 
		f_query_add_mod.document.UnderAge.p_from_birth_date, f_query_add_mod.document.UnderAge.p_to_birth_date, messageFrame,'DMY',getLabel('Common.birthDate_fs.label','common')+"("+getLabel('eMP.Baby.label','mp')+")" ) ) 
	{		
		f_query_add_mod.document.UnderAge.submit() ;
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

function doDateChkWithLabel(from,to,messageFrame,format,stringLabel) 
{
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}

	if ( to=='' || from=='' )
	{
		return true;
	}
	 if(!f_query_add_mod.isBefore(from,to,format,f_query_add_mod.document.forms[0].locale.value)){
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;		
		error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +stringLabel);
		error=error.replace("#",stringLabel);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
		else  
			return true;
}

