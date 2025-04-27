function onReportTypeChange()
{
	if(document.forms[0].p_report_type.value == 'W')
	{
		document.forms[0].p_report_id.value = 'MRDRBHTRW';
		document.getElementById('p_report_by').value = 'M';
		document.getElementById('p_report_by').onchange();
		document.forms[0].mand_locn.style.visibility = "visible";
		document.forms[0].mand_spec.style.visibility = "hidden";
		document.forms[0].from_speciality.disabled = false;
		document.forms[0].fromSpecialty.disabled = false;
		document.forms[0].from_speciality.value = "";
		document.forms[0].p_fr_specialty_code.value = "";
		document.forms[0].from_locn.disabled = false;
		document.forms[0].locn.disabled = false;
		document.forms[0].from_locn.value = "";
		document.forms[0].p_fm_loc_code.value = "";
	}
	else if(document.forms[0].p_report_type.value == 'S')
	{
		document.forms[0].p_report_id.value = 'MRDRBHTRS';
		document.getElementById('p_report_by').value = 'M';
		document.getElementById('p_report_by').onchange();
		document.forms[0].mand_spec.style.visibility = "visible";
		document.forms[0].mand_locn.style.visibility = "hidden";
		document.forms[0].from_speciality.disabled = false;
		document.forms[0].fromSpecialty.disabled = false;
		document.forms[0].from_speciality.value = "";
		document.forms[0].p_fr_specialty_code.value = "";
		document.forms[0].from_locn.disabled = false;
		document.forms[0].locn.disabled = false;
		document.forms[0].from_locn.value = "";
		document.forms[0].p_fm_loc_code.value = "";
	}
	else if(document.forms[0].p_report_type.value == 'H')
	{
		document.forms[0].p_report_id.value = 'MRDRBHTRH';
		document.getElementById('p_report_by').value = 'Y';
		document.getElementById('p_report_by').onchange();
		document.forms[0].mand_locn.style.visibility = "hidden";
		document.forms[0].mand_spec.style.visibility = "hidden";
		document.forms[0].from_speciality.disabled = true;
		document.forms[0].fromSpecialty.disabled = true;
		document.forms[0].from_speciality.value = "";
		document.forms[0].p_fr_specialty_code.value = "";
		document.forms[0].from_locn.disabled = true;
		document.forms[0].locn.disabled = true;
		document.forms[0].from_locn.value = "";
		document.forms[0].p_fm_loc_code.value = "";
	}
	else
	{
		document.forms[0].p_report_id.value = '';
		document.getElementById('p_report_by').value = 'M';
		document.getElementById('p_report_by').onchange();
		document.forms[0].mand_locn.style.visibility = "hidden";
		document.forms[0].mand_spec.style.visibility = "hidden";
		document.forms[0].from_speciality.disabled = false;
		document.forms[0].fromSpecialty.disabled = false;
		document.forms[0].from_speciality.value = "";
		document.forms[0].p_fr_specialty_code.value = "";
		document.forms[0].from_locn.disabled = false;
		document.forms[0].locn.disabled = false;
		document.forms[0].from_locn.value = "";
		document.forms[0].p_fm_loc_code.value = "";
	}
}

function BeforesearchCodeSpec(obj1,obj2)
{
	if(document.forms[0].from_speciality.value != "")
		searchCodeSpec(obj1,obj2);
	else
		document.forms[0].p_fr_specialty_code.value = "";
}

async function searchCodeSpec(obj,target)
{
	var sql = "";
	var tit = "";
	var facilityid = document.forms[0].p_facility_id.value;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var argumentArray  = new Array(8);
	
	tit = getLabel("Common.speciality.label","Common");

	argumentArray[0] = "SELECT distinct specialty_code code, specialty_short_desc description FROM ip_nurs_unit_for_specialty_vw WHERE facility_id = '"+facilityid+"' AND UPPER (specialty_code) LIKE UPPER (?) AND UPPER (specialty_short_desc) LIKE UPPER (?)";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	var retVal=await CommonLookup(tit,argumentArray);

	if(retVal==null || retVal==""){
		target.value="";
		if(target.name == 'from_speciality'){
			document.forms[0].from_speciality.value="";
			document.forms[0].p_fr_specialty_code.value="";
		}
	}else{
		target.value=retVal[1];
		if(target.name == 'from_speciality')
			document.forms[0].p_fr_specialty_code.value=retVal[0];
	}
}

function BeforesearchCodeLocn(obj1,obj2)
{
	if(document.forms[0].from_locn.value != "")
		searchCodeLocn(obj1,obj2);
	else
		document.forms[0].p_fm_loc_code.value = "";
}

async function searchCodeLocn(obj,target)
{
	var sql = "";
	var tit = "";
	var locale = document.forms[0].p_language_id.value;
	var facilityid = document.forms[0].p_facility_id.value;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var argumentArray  = new Array(8);
	
	tit = getLabel("Common.Location.label","Common");

	argumentArray[0] = "SELECT nursing_unit_code code, short_desc description FROM ip_nursing_unit_lang_vw WHERE language_id = '"+locale+"' AND facility_id = '"+facilityid+"' AND eff_status = 'E' AND locn_type = 'N' AND UPPER (nursing_unit_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) AND patient_class = 'IP'";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	var retVal=await CommonLookup(tit,argumentArray);

	if(retVal==null || retVal==""){
		target.value="";
		if(target.name == 'from_locn'){
			document.forms[0].from_locn.value="";
			document.forms[0].p_fm_loc_code.value="";
		}
	}else{
		target.value=retVal[1];
		if(target.name == 'from_locn')
			document.forms[0].p_fm_loc_code.value=retVal[0];
	}
}

function datechange()
{
	if (document.getElementById('p_report_by').value=='M')
	{
		var currentmonth = document.forms[0].p_current_month.value;

		document.getElementById('MY_label').innerHTML= getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.date.label","Common");
		document.getElementById('MY_frm').innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_mth' maxlength='7' size='7' value = '"+currentmonth+"' onblur='validatefromToWithCurrentDtAlert(this,document.getElementById('p_report_by').value);' readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_mth','mm/y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;

	}else  if (document.getElementById('p_report_by').value=='Y')
	{
		var currentyear = document.forms[0].p_current_year.value;

		document.getElementById('MY_label').innerHTML= getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.date.label","Common");
		document.getElementById('MY_frm').innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='4' size='4' value = '"+currentyear+"' onblur='validatefromToWithCurrentDtAlert(this,document.getElementById('p_report_by').value);' readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
	}
}

function validatefromToWithCurrentDtAlert(obj,type)
{ 
	var from = obj.value;
	var to   = document.forms[0].p_current_date.value;
	var fromarray = from.split("/");
	var toarray	  = to.split("/");
	var invaldt	  = getMessage("NO_FUTURE_DATE",'MR') ;

	if (type=='M'){
		
		var fromdt = new Date(fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[1]-1,toarray[0]);

		if (!isBeforeNow(obj.value,"MY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
				alert(invaldt);
				obj.value='';
				obj.focus();
			}
		}
	}

	if (type=='Y'){

		if(parseInt(toarray[2]) < fromarray) {
			alert(invaldt);
			obj.value='';
			obj.focus();
		}
	}
}

