function reset() {
	f_query_add_mod.document.repPatListDistrict.reset() ;
}

function run() {

    var fields = new Array( f_query_add_mod.document.repPatListDistrict.p_from_regn_date,
                            f_query_add_mod.document.repPatListDistrict.p_to_regn_date );

    var names = new Array(getLabel('eMP.RegnDateFrom.label','MP'), getLabel('eMP.RegnDateTo.label','MP'));

    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if( f_query_add_mod.doDateChkWithLabel( f_query_add_mod.document.repPatListDistrict.p_from_regn_date, f_query_add_mod.document.repPatListDistrict.p_to_regn_date, messageFrame,'DMY',getLabel('Common.Registration.label','common')+ " " + getLabel('Common.date.label','common') ) ) 
		{
			if( f_query_add_mod.doDateChkWithLabel( f_query_add_mod.document.repPatListDistrict.p_from_birth_date, f_query_add_mod.document.repPatListDistrict.p_to_birth_date, messageFrame,'DMY',getLabel('Common.birthDate.label','common') ) ) 
			{
				if( f_query_add_mod.CheckString( getLabel('Common.PatientSeriesGroup.label','common'), f_query_add_mod.document.repPatListDistrict.p_series_from, f_query_add_mod.document.repPatListDistrict.p_series_to, messageFrame ) )  
				{
					if( f_query_add_mod.CheckString( getLabel('eMP.region.label','MP'), f_query_add_mod.document.repPatListDistrict.p_from_res_area_code, f_query_add_mod.document.repPatListDistrict.p_to_res_area_code, messageFrame ) )  
					{
						if (f_query_add_mod.document.repPatListDistrict.p_from_blng_grp_id, f_query_add_mod.document.repPatListDistrict.p_to_blng_grp_id != null)
						{
							if( f_query_add_mod.CheckString( getLabel('Common.BillingGroup.label','common'), f_query_add_mod.document.repPatListDistrict.p_from_blng_grp_id, f_query_add_mod.document.repPatListDistrict.p_to_blng_grp_id, messageFrame ) )  
							if( f_query_add_mod.CheckString( getLabel('Common.CustomerCode.label','common') , f_query_add_mod.document.repPatListDistrict.p_from_cust_code, f_query_add_mod.document.repPatListDistrict.p_to_cust_code, messageFrame ) )  
							if( f_query_add_mod.CheckString( getLabel('Common.SettlementType.label','common') , f_query_add_mod.document.repPatListDistrict.p_from_stlmt_type, f_query_add_mod.document.repPatListDistrict.p_to_stlmt_type, messageFrame ) )  
							f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
							f_query_add_mod.document.forms[0].target="messageFrame";	
							f_query_add_mod.document.repPatListDistrict.submit() ;
						}
						else
						{
							f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
							f_query_add_mod.document.forms[0].target="messageFrame";
							f_query_add_mod.document.repPatListDistrict.submit() ;
						}
					}					
				}				
			}		
		}	
	}
}

//From repPatListDi
async function searchCode(obj,target,Ar_installed)
{
		var retVal = 	new String();
		//var dialogHeight= "28" ;
		//var dialogWidth	= "43" ;
		
		var dialogHeight= "400px" ; ///added by vijayan
	    var dialogTop = "10px" ;
	    var dialogWidth	= "700px" ;
		
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
		

		if(obj.name=="district")
		{
			tit=getLabel('eMP.region.label','MP');
			sql="select region_code, short_desc from mp_region_lang_vw where language_id=`"+localeName+"`";
			search_code="region_code";
			search_desc= "short_desc";
		}
		//added by Devang on 27/0/2002 to include Patient Series
		else if(obj.name=="patsergrp")
		{
			tit=getLabel('Common.PatientSeriesGroup.label','common');
			sql="select pat_ser_grp_code, short_desc from mp_pat_ser_grp_lang_vw where language_id=`"+localeName+"`";
			search_code="pat_ser_grp_code";
			search_desc= "short_desc";
		}
		// added end
		else if(obj.name=="patcat")
		{
			tit=getLabel('Common.category.label','common');
			sql="select pat_cat_code, short_desc from mp_pat_category_lang_vw where language_id=`"+localeName+"`";
			search_code="pat_cat_code";
			search_desc= "short_desc";
		}
		// added end
		else if(obj.name=="blnggrp")
		{
			tit=getLabel('Common.BillingGroup.label','common');
			sql="select blng_grp_id, short_desc from bl_blng_grp_lang_vw where language_id=`"+localeName+"`";
			search_code="blng_grp_id";
			search_desc= "short_desc";
		}
		else if(obj.name=="custcode" && Ar_installed == "Y")
		{
			tit= getLabel('Common.Customer.label','common');
			sql="select cust_code, short_name from ar_customer_lang_vw where language_id=`"+localeName+"`";
			search_code="cust_code";
			search_desc= "short_name";
		}
		else if(obj.name=="custcode" && Ar_installed == "N")
		{
			tit= getLabel('Common.Customer.label','common');
			sql="select cust_code, short_name from bl_emp_ins_mst_lang_vw where language_id=`"+localeName+"`";
			search_code="cust_code";
			search_desc= "short_name";
		}
		else if(obj.name=="stlmttype")
		{
			tit= getLabel('Common.SettlementType.label','common');
			sql="select slmt_type_code, short_desc from bl_slmt_type_lang_vw where language_id=`"+localeName+"`";
			search_code="slmt_type_code";
			search_desc= "short_desc";
		}

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();
}

function change_report(obj)
{
	if(obj.value=="S")
		document.repPatListDistrict.p_report_id.value="MPBPLARE";
	if(obj.value=="C")
	{
		document.repPatListDistrict.p_report_id.value="MPBPLARC";
	}
}

