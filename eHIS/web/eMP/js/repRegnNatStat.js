function reset() {
	f_query_add_mod.document.repRegnNatStat.reset() ;
}

function run() 
{
	var fields = new Array( f_query_add_mod.document.repRegnNatStat.p_fm_regndate,
                            f_query_add_mod.document.repRegnNatStat.p_to_regndate );

    var names = new Array(getLabel('eMP.RegnDateFrom.label','MP'), getLabel('eMP.RegnDateTo.label','MP'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.repRegnNatStat.p_fm_regndate, f_query_add_mod.document.repRegnNatStat.p_to_regndate, messageFrame ,'DMY') )
		if( f_query_add_mod.CheckString(getLabel('Common.NationalityCode.label','common'), f_query_add_mod.document.repRegnNatStat.p_fm_nation_code, f_query_add_mod.document.repRegnNatStat.p_to_nation_code, messageFrame ) ) {
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.repRegnNatStat.submit() ; }
}
}

async function searchCode(obj,target)
	{
			var retVal = 	new String();
			//var dialogHeight= "28" ;
			//var dialogWidth	= "43" ;
			var dialogHeight= "400px" ;
			var dialogTop = "10px" ;
			var dialogWidth	= "700px" ;
			
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			

			if(obj.name=="nationality")
			{
				tit=getLabel('Common.nationality.label','common');
				sql="select country_code, long_desc from mp_country_lang_vw where language_id=`"+localeName+"`";
				search_code="country_code";
				search_desc= "long_desc"
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
