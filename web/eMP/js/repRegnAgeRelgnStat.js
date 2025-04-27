function reset() {
	f_query_add_mod.document.repRegnAgeRelgnStat.reset() ;
}

function run() 
{
	var fields = new Array ( f_query_add_mod.document.repRegnAgeRelgnStat.p_age_range_code );
    var names = new Array ( getLabel('Common.AgeRange.label','common') );

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		var fields = new Array( f_query_add_mod.document.repRegnAgeRelgnStat.p_fm_regndate,
                            f_query_add_mod.document.repRegnAgeRelgnStat.p_to_regndate );

		var names = new Array(getLabel('eMP.RegnDateFrom.label','MP'), getLabel('eMP.RegnDateTo.label','MP'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
	
		if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.repRegnAgeRelgnStat.p_fm_regndate, f_query_add_mod.document.repRegnAgeRelgnStat.p_to_regndate, messageFrame,'DMY' ) )
		{
			if( f_query_add_mod.CheckString( getLabel('Common.ReligionCode.label','common') , f_query_add_mod.document.repRegnAgeRelgnStat.p_fm_relgn_code, f_query_add_mod.document.repRegnAgeRelgnStat.p_to_relgn_code, messageFrame ) ) 
			{
				 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.repRegnAgeRelgnStat.submit() ;
			}
		}
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



async function searchCode(obj,target)
	{
			var retVal = 	new String();
			//var dialogHeight= "28" ;
			//var dialogWidth	= "43" ;
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			

			if(obj.name=="religion")
			{
				tit=getLabel('Common.religion.label','common');
				sql="select relgn_code, short_desc from mp_religion_lang_vw where language_id=`"+localeName+"`";
				search_code="relgn_code";
				search_desc= "short_desc"
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

