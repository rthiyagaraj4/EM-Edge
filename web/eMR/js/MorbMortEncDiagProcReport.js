function getLocationType(obj)
{
	var locationType = document.forms[0].locationType;
	while(locationType.options.length > 1)
		locationType.remove(1);
	
	document.forms[0].b_loc_val.value = "";
	document.forms[0].p_location_code.value = "";
	
	var HTMLVal = "<HTML><head><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eMR/jsp/EncTypeLocationList.jsp'><input type='hidden' name='encounterType' id='encounterType' value='" +obj.value + "'></form></BODY></HTML>";

	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();		
}

function clearLocation(obj)
{
	if (obj.value == null || obj.value == "") {
		document.forms[0].b_loc_val.value = "";
		document.forms[0].p_location_code.value = "";
	} else {
		document.forms[0].b_loc_val.value = "";
		document.forms[0].p_location_code.value = "";
	}
}

function ena_loc_lookup(obj) 
{
	if (obj.value == null || obj.value == '') {
		document.forms[0].b_loc_val.value = "";
		document.forms[0].p_location_code.value = "";
	} else {
		getValues();
	}
}

async function getValues()
{
	var tit = "";
	var sql = "";
	var sqlSecond = "";
	var retVal="";
	var locale = document.forms[0].p_language_id.value;
	var target =document.forms[0].b_loc_val.value;
	var facilityid = document.forms[0].p_facility_id.value;
	var module_id = document.forms[0].p_module_id.value;
	var locType = document.forms[0].locationType.value;
	var loginUser = document.forms[0].p_user_id.value;
	var encType = document.forms[0].p_patient_class.value;
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var argumentArray = new Array(8);
	
	if(locType == "N"){
		retVal = getNursingUnitValue("", facilityid);
	} else {
		tit = getLabel("Common.Location.label", "Common");

		var enc_type_criteria="";

		if(encType == "EM"){
			enc_type_criteria="level_of_care_ind='E'";
		}else {
			enc_type_criteria="level_of_care_ind='A'"
		}

		if(locType == "D"){
			argumentArray[0] = "SELECT a.nursing_unit_code code, a.short_desc description FROM ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b WHERE a.language_id = '" + locale + "' AND a.facility_id = '" + facilityid + "' AND a.patient_class = 'DC' AND a.facility_id = b.facility_id AND a.eff_status = 'E' AND a.nursing_unit_code = b.locn_code AND a.locn_type = b.locn_type AND b.locn_type = 'N' AND b.appl_user_id = '" + loginUser + "' AND UPPER (a.nursing_unit_code) LIKE UPPER (?) AND UPPER (a.short_desc) LIKE UPPER (?) ORDER BY 2";
		} else {
			argumentArray[0] = "SELECT clinic_code code, long_desc description FROM op_clinic_lang_vw WHERE facility_id = '" + facilityid + "' AND language_id = '" + locale + "' AND eff_status = 'E' AND UPPER (clinic_code) LIKE UPPER (NVL (?, clinic_code)) AND UPPER (long_desc) LIKE UPPER (NVL (?, long_desc)) AND "+enc_type_criteria+" AND clinic_type = '" + locType + "'";
		}
		
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "1,2";
		argumentArray[5] = target;
		argumentArray[6] = CODE_DESC_LINK;
		argumentArray[7] = CODE_DESC;
		
		retVal = await CommonLookup(tit, argumentArray);
	}

	if(retVal != null && retVal != "" )
	{
		document.forms[0].p_location_code.value=retVal[0];
		document.forms[0].b_loc_val.value=retVal[1];
	}
	else
	{
		document.forms[0].b_loc_val.value		= "";
		document.forms[0].p_location_code.value	= "";
	}
}

async function getNursingUnitValue(aNursingUnit, getFacilitID)
{
	var msg					= "";
	var facility_id			= getFacilitID;
	var retVal				= new String();
	var sql					= "";
	var tit					= "";
	var retVal				= new String();
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;

	var loginUser = document.forms[0].p_user_id.value;
	var target = document.forms[0].b_loc_val.value;
	var locale = document.forms[0].p_language_id.value;
	var encType = document.forms[0].p_patient_class.value;	

	sql = "SELECT nursing_unit_code code, short_desc description FROM ip_nursing_unit_lang_vw WHERE language_id = '"+locale+"' AND facility_id LIKE ? AND eff_status = 'E' AND locn_type = 'N' AND UPPER (nursing_unit_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) AND patient_class = '"+encType+"'";
		
	dataNameArray[0]	= "facility_id" ;
	dataValueArray[0]	= facility_id;
	dataTypeArray[0]	= STRING ;

	argumentArray[4] = "2, 3";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[5] = "";
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	search_code="nursing_unit_code";
	search_desc="short_desc";
	tit=getLabel("Common.nursingUnit.label","Common");
	
	retVal = await CommonLookup( tit, argumentArray );
	return retVal;
}

function validateDischargeCheckoutFromDate(obj)
{
	var from = obj.value;	
	var to   = document.forms[0].p_current_date.value; 
	var fromarray;
	var toarray;
	fromarray  = from.split("/");
	toarray    = to.split("/");
	var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
	var todt = new Date(toarray[2],toarray[1],toarray[0]);
	
	if (!isBeforeNow(obj.value,"DMY",localeName)){
		if(Date.parse(todt) < Date.parse(fromdt)) {
			var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
			var census_date_from=getLabel("Common.Discharge.label","Common")+"/"+getLabel("Common.CheckoutDate.label","Common")+" "+getLabel("Common.from.label","Common");
			var sys_date=getLabel("Common.CurrentDate.label","Common");
			invaldt=invaldt.replace('$',census_date_from);
			invaldt=invaldt.replace('#',sys_date);
			alert(invaldt);
			obj.value='';
			obj.focus();
		}
	}
}

function validateDischargeCheckoutToDate(obj)
{
	var from = obj.value;	
	var to   = document.forms[0].p_current_date.value; 
	var fromarray;
	var toarray;
	fromarray  = from.split("/");
	toarray    = to.split("/");
	var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
	var todt = new Date(toarray[2],toarray[1],toarray[0]);
	
	if (!isBeforeNow(obj.value,"DMY",localeName)){
		if(Date.parse(todt) < Date.parse(fromdt)) {
			var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
			var census_date_from=getLabel("Common.Discharge.label","Common")+"/"+getLabel("Common.CheckoutDate.label","Common")+" "+getLabel("Common.to.label","Common");
			var sys_date=getLabel("Common.CurrentDate.label","Common");
			invaldt=invaldt.replace('$',census_date_from);
			invaldt=invaldt.replace('#',sys_date);
			alert(invaldt);
			obj.value='';
			obj.focus();
		}
	}
}

function termCodeMand(obj) 
{
	if (obj.value == null || obj.value == '') {
		document.forms[0].frm_term_mand.style.visibility = "hidden";
		document.forms[0].to_term_mand.style.visibility = "hidden";
		document.forms[0].main_all_mand.style.visibility = "hidden";
		document.forms[0].p_fr_term_code.value="";
		document.forms[0].p_to_term_code.value="";
		document.forms[0].p_diag_class_type.value="PD";
		document.forms[0].p_diag_class_type.options[0].selected=true;
		document.forms[0].p_fr_term_code.disabled=true;
		document.forms[0].p_to_term_code.disabled=true;
		document.forms[0].from_term_code.disabled=true;
		document.forms[0].to_term_code.disabled=true;
	} else {
		document.forms[0].frm_term_mand.style.visibility = "visible";
		document.forms[0].to_term_mand.style.visibility = "visible";
		document.forms[0].main_all_mand.style.visibility = "visible";
		document.forms[0].p_fr_term_code.value="";
		document.forms[0].p_to_term_code.value="";
		document.forms[0].p_diag_class_type.value="PD";
		document.forms[0].p_diag_class_type.options[0].selected=true;
		document.forms[0].p_fr_term_code.disabled=false;
		document.forms[0].p_to_term_code.disabled=false;
		document.forms[0].from_term_code.disabled=false;
		document.forms[0].to_term_code.disabled=false;
	}
}

function procCodeMand(obj)
{
	if (obj.value == null || obj.value == '') {
		document.forms[0].frm_proc_mand.style.visibility = "hidden";
		document.forms[0].to_proc_mand.style.visibility = "hidden";
		document.forms[0].p_fr_proc_code.value="";
		document.forms[0].p_to_proc_code.value="";
		document.forms[0].p_fr_proc_code.disabled=true;
		document.forms[0].p_to_proc_code.disabled=true;
		document.forms[0].from_proc_code.disabled=true;
		document.forms[0].to_proc_code.disabled=true;
	} else {
		document.forms[0].frm_proc_mand.style.visibility = "visible";
		document.forms[0].to_proc_mand.style.visibility = "visible";
		document.forms[0].p_fr_proc_code.value="";
		document.forms[0].p_to_proc_code.value="";
		document.forms[0].p_fr_proc_code.disabled=false;
		document.forms[0].p_to_proc_code.disabled=false;
		document.forms[0].from_proc_code.disabled=false;
		document.forms[0].to_proc_code.disabled=false;
	}
}

async function diagprocTermCodeLookup(obj,target)
{
	var retVal = new String();
	var dialogHeight= "28vh";
	var dialogWidth = "43vw";
	var status = "no";
	var arguments = "";
	var sql = "";
	var search_code = "";
	var search_desc = "";
	var tit = "";
	var term_set_id = "";

	 if(obj.name == 'from_term_code' || obj.name == 'to_term_code'){
		 term_set_id = document.forms[0].p_diag_set.value;
	 }else if(obj.name == 'from_proc_code' || obj.name == 'to_proc_code'){
		 term_set_id = document.forms[0].p_proc_set.value;
	 }else{
		 term_set_id = "";
	 }
	var p_language_id = document.forms[0].p_language_id.value;
	
	tit = getLabel("Common.TermCode.label","Common");

	sql = "select TERM_CODE, short_desc FROM MR_TERM_CODE_LANG_VW where term_set_id=`"+term_set_id+"` and language_id = `"+p_language_id+"` ";

	search_code = "TERM_CODE"; 
	search_desc = "short_desc";
 
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null)){
		target.value = retVal;
	}else{
		target.focus();
	}
}

