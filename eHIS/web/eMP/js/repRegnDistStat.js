function reset() {
	f_query_add_mod.document.repRegnDistStat.reset() ;
}

function run() 
{
	var fields = new Array( f_query_add_mod.document.repRegnDistStat.p_fm_regndate,
                            f_query_add_mod.document.repRegnDistStat.p_to_regndate );

    var names = new Array(getLabel('eMP.RegnDateFrom.label','MP'), getLabel('eMP.RegnDateTo.label','MP'));

	var repBasedOnGovernorate = f_query_add_mod.document.repRegnDistStat.repBasedOnGovernorate.value;
	var p_reg_prompt = f_query_add_mod.document.repRegnDistStat.p_reg_prompt.value;
	var reg="";

if(repBasedOnGovernorate=="true"){
		  reg = p_reg_prompt;
	}else{
		  reg = getLabel('eMP.StateCode.label','MP');
	}
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.repRegnDistStat.p_fm_regndate, f_query_add_mod.document.repRegnDistStat.p_to_regndate, messageFrame,'DMY' ) ) 
		if( f_query_add_mod.CheckString( reg, f_query_add_mod.document.repRegnDistStat.P_fm_region_code, f_query_add_mod.document.repRegnDistStat.P_to_region_code, messageFrame ) )
		if( f_query_add_mod.CheckString( getLabel('eMP.DistrictCode.label','MP'), f_query_add_mod.document.repRegnDistStat.P_fm_area_code, f_query_add_mod.document.repRegnDistStat.P_to_area_code, messageFrame ) )
		if( f_query_add_mod.CheckString( getLabel('Common.TownCode.label','common'), f_query_add_mod.document.repRegnDistStat.P_fm_town_code, f_query_add_mod.document.repRegnDistStat.P_to_town_code, messageFrame ) )
		{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.forms[0].submit();
		}
}
}
//Below added by Suji Keerthi for MOHE-CRF-0098 US001

  function basedonoption(obj)
	{
      var report=obj.value;
	  if(report=='F')
      document.forms[0].p_report_id.value="MPFRSSDT";
	  else
	  document.forms[0].p_report_id.value="MPBARRGS";
   }
//Ended by Suji Keerthi for MOHE-CRF-0098 US001
