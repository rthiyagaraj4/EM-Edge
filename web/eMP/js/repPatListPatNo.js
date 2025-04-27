function reset() {
	f_query_add_mod.document.repPatListPatNo.reset() ;
}

function run() 
{ 
	var fields = new Array( f_query_add_mod.document.repPatListPatNo.p_from_regn_date,
                            f_query_add_mod.document.repPatListPatNo.p_to_regn_date );
    var names = new Array(getLabel('eMP.RegnDateFrom.label','MP'), getLabel('eMP.RegnDateTo.label','MP'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		//if( f_query_add_mod.doDateCheck( f_query_add_mod.document.repPatListPatNo.p_from_regn_date, f_query_add_mod.document.repPatListPatNo.p_to_regn_date, messageFrame ) ) 
		if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.repPatListPatNo.p_from_regn_date, f_query_add_mod.document.repPatListPatNo.p_to_regn_date, messageFrame,'DMY' ) ) 
		{
			if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.repPatListPatNo.p_from_birth_date, f_query_add_mod.document.repPatListPatNo.p_to_birth_date, messageFrame,'DMY' ) ) 
			{
				if( f_query_add_mod.CheckString( getLabel('Common.PatientSeriesGroup.label','common'), f_query_add_mod.document.repPatListPatNo.p_series_from, f_query_add_mod.document.repPatListPatNo.p_series_to, messageFrame ) )  
				{
					if( f_query_add_mod.CheckString( getLabel('Common.patientId.label','common'), f_query_add_mod.document.repPatListPatNo.p_from_patient_id, f_query_add_mod.document.repPatListPatNo.p_to_patient_id, messageFrame ) )  
					{
						if( f_query_add_mod.document.repPatListPatNo.p_from_blng_grp_id, f_query_add_mod.document.repPatListPatNo.p_to_blng_grp_id != null) 						
						{
							if( f_query_add_mod.CheckString( getLabel('Common.BillingGroup.label','common'), f_query_add_mod.document.repPatListPatNo.p_from_blng_grp_id, f_query_add_mod.document.repPatListPatNo.p_to_blng_grp_id, messageFrame ) )  
							if( f_query_add_mod.CheckString( getLabel('Common.CustomerCode.label','common'), f_query_add_mod.document.repPatListPatNo.p_from_cust_code, f_query_add_mod.document.repPatListPatNo.p_to_cust_code, messageFrame ) )  
							if( f_query_add_mod.CheckString( getLabel('Common.SettlementType.label','common'), f_query_add_mod.document.repPatListPatNo.p_from_stlmt_type, f_query_add_mod.document.repPatListPatNo.p_to_stlmt_type, messageFrame ) )
							{	
								f_query_add_mod.document.repPatListPatNo.action="../../eCommon/jsp/report_options.jsp";
								f_query_add_mod.document.repPatListPatNo.target="messageFrame";
								f_query_add_mod.document.repPatListPatNo.submit() ;	
							}
						}
						else
						{
							 
							f_query_add_mod.document.repPatListPatNo.action="../../eCommon/jsp/report_options.jsp";
							f_query_add_mod.document.repPatListPatNo.target="messageFrame";
							f_query_add_mod.document.repPatListPatNo.submit() ;
						}
					}
				}
			}
		}	
}
}

function change_report(obj)
{
	if(obj.value=="S")
		document.repPatListPatNo.p_report_id.value="MPBPTNUM";
	if(obj.value=="C")
	{
		document.repPatListPatNo.p_report_id.value="MPBPTNUC";
	}
}


//function added by Devang on 27/06/2002 for Patient Series 

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
		var retVal =    new String();
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();

		if(obj.name=="patsergrp")
		{
			tit=getLabel('Common.PatientSeriesGroup.label','common') ;
			sql="select pat_ser_grp_code code, short_desc description from mp_pat_ser_grp_lang_vw where language_id='"+localeName+"' and upper(pat_ser_grp_code) like upper(?) and upper(short_desc) like upper(?)";
			search_code="pat_ser_grp_code";
			search_desc= "short_desc";
		}
		else if(obj.name=="patcat")
		{
			tit=getLabel('Common.category.label','common');
			sql="select pat_cat_code code, short_desc description from mp_pat_category_lang_vw where language_id='"+localeName+"' and upper(pat_cat_code) like upper(?) and upper(short_desc) like upper(?)";
			search_code="pat_cat_code";
			search_desc= "short_desc";
		}
		else if(obj.name=="blnggrp")
		{
			tit=getLabel('Common.BillingGroup.label','common');
			sql="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where  language_id='"+localeName+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?)";
			search_code="blng_grp_id";
			search_desc= "short_desc";
		}
		else if(obj.name=="custcode" && Ar_installed == "Y")
		{
			tit=getLabel('Common.Customer.label','common');
			sql="select cust_code code, short_name description from ar_customer_lang_vw  where  language_id='"+localeName+"' and upper(cust_code) like upper(?) and upper(short_name) like upper(?)";
			search_code="cust_code";
			search_desc= "short_name";
		}
		else if(obj.name=="custcode" && Ar_installed == "N")
		{
			tit=getLabel('Common.Customer.label','common');
			sql="select cust_code code, short_name description from bl_emp_ins_mst_lang_vw  where language_id='"+localeName+"' and upper(cust_code) like upper(?) and upper(short_name) like upper(?)";
			search_code="cust_code";
			search_desc= "short_name";
		}
		else if(obj.name=="stlmttype")
		{
			tit= getLabel('Common.SettlementType.label','common');
			sql="select slmt_type_code code, short_desc description from bl_slmt_type_lang_vw where language_id='"+localeName+"' and upper(slmt_type_code) like upper(?) and upper(short_desc) like upper(?)";
			search_code="slmt_type_code";
			search_desc= "short_desc";
		}

		/*var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
alert(retVal);
		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();*/

			argumentArray[0] =sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;

			retVal = await CommonLookup( tit, argumentArray );
			
			if(retVal != null && retVal != "" )
			{
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				target.value=arr[0];
			}
			else
			{
				let dialogBody = parent.parent.document.getElementById('dialog-body');
                dialogBody.contentWindow.returnValue = target.value;
    
                const dialogTag = parent.parent.document.getElementById("dialog_tag");    
                dialogTag.close();   
				//target.value='';
			}
}

