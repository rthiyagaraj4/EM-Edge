function reset() {
	f_query_add_mod.document.repRegnDistStat.reset() ;
}

function run() 
{
	var fields = new Array( f_query_add_mod.document.repRegnDistStat.p_fm_regndate,
                            f_query_add_mod.document.repRegnDistStat.p_to_regndate );

    var names = new Array(getLabel('Common.RegistrationDate.label','common')+" "+getLabel('Common.from.label','common'), getLabel('Common.RegistrationDate.label','common')+" "+getLabel('Common.to.label','common'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if( doDateChkWithLabel( f_query_add_mod.document.repRegnDistStat.p_fm_regndate, f_query_add_mod.document.repRegnDistStat.p_to_regndate, messageFrame,'DMY',getLabel('Common.RegistrationDate.label','common') ) ) 
		//if( f_query_add_mod.CheckString( getLabel('eMP.StateCode.label','MP'), f_query_add_mod.document.repRegnDistStat.P_fm_region_code, f_query_add_mod.document.repRegnDistStat.P_to_region_code, messageFrame ) )

		if( f_query_add_mod.CheckString( getLabel('eMP.Province.label','MP')+" "+getLabel('Common.code.label','common'), f_query_add_mod.document.repRegnDistStat.P_fm_region_code, f_query_add_mod.document.repRegnDistStat.P_to_region_code, messageFrame ) )

		if( f_query_add_mod.CheckString( getLabel('eMP.DistrictCode.label','MP'), f_query_add_mod.document.repRegnDistStat.P_fm_area_code, f_query_add_mod.document.repRegnDistStat.P_to_area_code, messageFrame ) )
		if( f_query_add_mod.CheckString( getLabel('Common.TownCode.label','common'), f_query_add_mod.document.repRegnDistStat.P_fm_town_code, f_query_add_mod.document.repRegnDistStat.P_to_town_code, messageFrame ) )
			f_query_add_mod.document.forms[0].submit();
		
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
