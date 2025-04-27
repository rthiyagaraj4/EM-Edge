
function run() {
	//var fields = new Array ( f_query_add_mod.document.forms[0].stat_date);
	//var names = new Array ( "Statistics Date");

	/*var fields = new Array ( f_query_add_mod.document.forms[0].p_p_month,
		f_query_add_mod.document.forms[0].p_p_year);
	var names = new Array (getLabel("Common.month.label","Common"),getLabel("Common.year.label","Common"));*/
	var fields = new Array ( f_query_add_mod.document.forms[0].p_fm_mon_yr);
	var names = new Array (getLabel("eOP.ForMonthYear.label","OP"));

	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		f_query_add_mod.document.forms[0].p_stat_date.value =f_query_add_mod.document.forms[0].p_fm_mon_yr.value; //f_query_add_mod.document.forms[0].p_p_month.value+'/'+f_query_add_mod.document.forms[0].p_p_year.value;	
		f_query_add_mod.document.forms[0].p_clinic_from.value = f_query_add_mod.document.forms[0].p_fm_locn_code.value;
		f_query_add_mod.document.forms[0].p_clinic_to.value = f_query_add_mod.document.forms[0].p_to_locn_code.value;	
		f_query_add_mod.document.forms[0].p_pract_from.value = f_query_add_mod.document.forms[0].p_fm_pract_id.value;	
		f_query_add_mod.document.forms[0].p_pract_to.value=	f_query_add_mod.document.forms[0].p_to_pract_id.value;	
		f_query_add_mod.document.forms[0].p_visit_status.value =	f_query_add_mod.document.forms[0].visit_status.value;
         
		if(f_query_add_mod.CheckString(getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
		if(f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
		if(f_query_add_mod.CheckString(getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))
			f_query_add_mod.document.forms[0].submit();
	}
}

function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}

/*function CheckMonth(Object2) {
	var datefield = Object2;
	if (ChkMonth(Object2) == false) {		
		var msg=getMessage("INVALID_MONTH_YEAR","OP");
		alert(msg);		
		datefield.select();
		datefield.focus();		
		return false;
	}
	else {
		return true;
   	}
}

function ChkMonth(Object3) {
	var strDay;	
	var strMonth;
	var strYear;	
	var datefield = Object3;
	var strDateArray = new Array();

	strDate = datefield.value;
	if (strDate.length == 0) return true; 

	strDateArray = strDate.split("/");
	if (strDateArray.length != 2) {
		return false;
	}
	else {
		strMonth = strDateArray[0];
		strYear = strDateArray[1];
	}

	if (strYear.length < 4) return false;

	if (isNaN(strMonth)==true) return false;

	if (isNaN(strYear)==true) return false;

	if (strYear < 1800) return false;

    	if (strMonth>12 || strMonth<1) 	return false;

	return true;
}*/
