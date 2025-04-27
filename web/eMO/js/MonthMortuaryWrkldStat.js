/*Created by Ashwini on 27-Oct-2017 for ML-MMOH-CRF-0790*/
function reset() 
{
	if(monthMortuaryWrkldStatFrame.document.monthMortuaryWrkldStatForm)
	{ 
	   monthMortuaryWrkldStatFrame.location.reload();
	}
}

function run()
{
	var fields = new Array( monthMortuaryWrkldStatFrame.document.monthMortuaryWrkldStatForm.frm_date );
	
	var names = new Array(getLabel('Common.month.label','Common')+"/"+getLabel('Common.year.label','Common'));

	if(monthMortuaryWrkldStatFrame.checkFields( fields, names, messageFrame))
	 {
		monthMortuaryWrkldStatFrame.document.forms[0].from_date.value=monthMortuaryWrkldStatFrame.document.forms[0].frm_date.value;
		monthMortuaryWrkldStatFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
	monthMortuaryWrkldStatFrame.document.forms[0].target="messageFrame"
		monthMortuaryWrkldStatFrame.document.forms[0].submit() ;
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
			else
			if(format=='DMY'){
			if(top.header != null)
				alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
			else
				alert(getMessage("INVALID_DATE_FMT", "SM"));
			}
			else
			{
				if(top.header != null)
				alert(top.header.getMessage("MONTH_YEAR_INVALID", "SM"));
			else
				alert(getMessage("MONTH_YEAR_INVALID", "SM"));
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

function validate_date_mon_year(obj) 
{ 		
	var from = obj.value;
	var to   = document.forms[0].CurrentDate.value;
    var fromarray;
	var toarray;
	fromarray  = from.split("/");
	toarray    = to.split("/");

	var fromdt = new Date(fromarray[1],fromarray[0]);
	var todt = new Date(toarray[1],toarray[0]);

		if (!isBeforeNow(obj.value,"MY",localeName))
			{
			if(Date.parse(todt) < Date.parse(fromdt)) 
				{
					var invaldt		 = getMessage("REMARKS_SHOULD_LS_EQUAL",'common') ;
					var mnthyr		 = "Month/Year";
					var CurrentYear  = "Current Month/Year";
					invaldt=invaldt.replace('$',mnthyr);
					invaldt=invaldt.replace(' #',CurrentYear);
					alert(invaldt);
					obj.value='';
					obj.focus();
				}
			}
}
/*End ML-MMOH-CRF-0790*/
