/*Created by Ashwini on 04-Jan-2019 for ML-MMOH-CRF-1094*/
function run()
{
	var report_id = f_query_add_mod.document.monthlyBodyPartCasesForm.p_report_id.value;

	var fields = new Array( f_query_add_mod.document.monthlyBodyPartCasesForm.from_date);
	
	var names = new Array(getLabel('Common.year.label','Common'));
	
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	 {
		f_query_add_mod.document.forms[0].p_from_date.value=f_query_add_mod.document.forms[0].from_date.value;
		f_query_add_mod.document.forms[0].submit() ;
	 }
}

function reset() 
{
	if(f_query_add_mod.document.monthlyBodyPartCasesForm)
	{ 
	   f_query_add_mod.location.reload();
	}
}

function validDateObj(date, format, locale)
{
	if (date.value != '')
	{
		if ( !validDate(date.value, format, locale) )
		{	
			if(format=='YY')
			{
				if(top.header != null)
				alert(top.header.getMessage("INVALID_YEAR_FMT", "SM"));
				else
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
			}
			
			date.value="";
			date.select();
			date.focus();
			return false;
		}
		else
			return true;
	}
}

function validate_date(obj) 
{
	var from = convertDate(obj.value,'YY',localeName,'en');
	var to   = convertDate(document.forms[0].CurrentYear.value,'YY',localeName,'en');
		if(to < from) 
			{
				var invaldt = getMessage("CAN_NOT_GREAT_CURR_YR","IP") ;
				var stat_year=getLabel("Common.year.label","Common");
				invaldt = invaldt.replace('$',stat_year);
				alert(invaldt);
				obj.value="";
				obj.focus();
				obj.select();
			}	
}
