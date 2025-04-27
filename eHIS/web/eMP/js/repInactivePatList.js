function reset() {
	f_query_add_mod.document.repInactivePatList.reset() ;
}

function run() 
{
	var fields = new Array( f_query_add_mod.document.repInactivePatList.p_fm_date,
                            f_query_add_mod.document.repInactivePatList.p_to_date );

    var names = new Array(getLabel('Common.fromdate.label','common'), getLabel('Common.todate.label','common'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
	if( f_query_add_mod.CheckString(getLabel('Common.PatientSeriesGroup.label','common'), f_query_add_mod.document.repInactivePatList.p_from_pat_ser_grp_code, f_query_add_mod.document.repInactivePatList.p_to_pat_ser_grp_code, messageFrame ) )
	{
		if( f_query_add_mod.CheckString(getLabel('Common.Citizenship.label','common'), f_query_add_mod.document.repInactivePatList.p_from_nat_code, f_query_add_mod.document.repInactivePatList.p_to_nat_code, messageFrame ) )
		{
			if( f_query_add_mod.CheckString(getLabel('Common.category.label','common'), f_query_add_mod.document.repInactivePatList.p_from_pat_cat_code, f_query_add_mod.document.repInactivePatList.p_to_pat_cat_code, messageFrame ) )
			{
				if (f_query_add_mod.document.repInactivePatList.p_from_blng_grp_id, f_query_add_mod.document.repInactivePatList.p_to_blng_grp_id != null)
				{
					if( f_query_add_mod.CheckString(getLabel('Common.BillingGroup.label','common'), f_query_add_mod.document.repInactivePatList.p_from_blng_grp_id, f_query_add_mod.document.repInactivePatList.p_to_blng_grp_id, messageFrame ) )  
					{
						if( f_query_add_mod.CheckString( getLabel('Common.CustomerCode.label','common') , f_query_add_mod.document.repInactivePatList.p_from_cust_code, f_query_add_mod.document.repInactivePatList.p_to_cust_code, messageFrame ) )  
						{
							if( f_query_add_mod.CheckString( getLabel('Common.SettlementType.label','common') , f_query_add_mod.document.repInactivePatList.p_from_stlmt_type, f_query_add_mod.document.repInactivePatList.p_to_stlmt_type, messageFrame ) )  
							{
								 if( f_query_add_mod.doDateCheckMsg(f_query_add_mod.document.forms[0].p_fm_date, f_query_add_mod.document.forms[0].p_to_date, messageFrame,'DMY' ) )
								{
								 if( f_query_add_mod.document.repInactivePatList.p_group_by.value == 'N')
									f_query_add_mod.document.repInactivePatList.p_report_id.value = 'MPBINFCY';
								else if (f_query_add_mod.document.repInactivePatList.p_group_by.value == 'S')
									f_query_add_mod.document.repInactivePatList.p_report_id.value = 'MPBINPSG';	
								else if (f_query_add_mod.document.repInactivePatList.p_group_by.value == 'Z')
									f_query_add_mod.document.repInactivePatList.p_report_id.value = 'MPBINCTZ';	
								else if (f_query_add_mod.document.repInactivePatList.p_group_by.value == 'C')
									f_query_add_mod.document.repInactivePatList.p_report_id.value = 'MPBINPCT';
								    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					    		    f_query_add_mod.document.forms[0].target="messageFrame";
									f_query_add_mod.document.repInactivePatList.submit();
							}
							}

						}
					}
				}
				else
				{
					if( f_query_add_mod.document.repInactivePatList.p_group_by.value == 'N')
						f_query_add_mod.document.repInactivePatList.p_report_id.value = 'MPBINFCY';
					else if (f_query_add_mod.document.repInactivePatList.p_group_by.value == 'S')
						f_query_add_mod.document.repInactivePatList.p_report_id.value = 'MPBINPSG';	
					else if (f_query_add_mod.document.repInactivePatList.p_group_by.value == 'Z')
						f_query_add_mod.document.repInactivePatList.p_report_id.value = 'MPBINCTZ';	
					else if (f_query_add_mod.document.repInactivePatList.p_group_by.value == 'C')
						f_query_add_mod.document.repInactivePatList.p_report_id.value = 'MPBINPCT';
					   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	    		       f_query_add_mod.document.forms[0].target="messageFrame";				
					    f_query_add_mod.document.repInactivePatList.submit();
				}
			}
		}
	}
}
}
