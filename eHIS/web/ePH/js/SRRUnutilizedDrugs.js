  //saved on 02.11.2005
// lookup for Drug Name

function searchDrugName()
{
	var formObj = document.frames.formUnutilizedDrugs;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select2").value)+"'"+document.getElementById("language_id").value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );

	if(retVal != null && retVal != "" )  
	{
		formObj.drug_name.value = retVal[1] ;
		formObj.drug_code.value = retVal[0];
		
		formObj.drug_name.disabled  = true;
		formObj.drug_name_search.disabled = true;
		
	}
}
function run()
{

	
	if(f_query_criteria.document.formUnutilizedDrugs) 
	{
		
		if(f_query_criteria.document.formUnutilizedDrugs.p_order_status.value == 'DC')
		{
		 var fields = new Array(f_query_criteria.document.formUnutilizedDrugs.locn_type,f_query_criteria.document.formUnutilizedDrugs.or_date,f_query_criteria.document.formUnutilizedDrugs.p_disc_date_time,f_query_criteria.document.formUnutilizedDrugs.p_order_status);
		 var names = new Array (getLabel("Common.locationtype.label","Common"),getLabel("ePH.OrderDateTimeFrom.label","PH"),getLabel("ePH.DiscontinuedDateTimeFrom.label","PH"),getLabel("Common.status.label","Common"));
		}
		else
		{
		 var fields = new Array(f_query_criteria.document.formUnutilizedDrugs.locn_type,f_query_criteria.document.formUnutilizedDrugs.or_date,f_query_criteria.document.formUnutilizedDrugs.p_order_status);
		 var names = new Array (getLabel("Common.locationtype.label","Common"),getLabel("ePH.OrderDateTimeFrom.label","PH"),getLabel("Common.status.label","Common"));
		}
		
		 if(f_query_criteria.checkFields( fields, names, messageFrame))
		{
			f_query_criteria.document.formUnutilizedDrugs.p_order_locn_type.value = f_query_criteria.document.formUnutilizedDrugs.locn_type.value;

			f_query_criteria.document.formUnutilizedDrugs.p_locn_code.value = f_query_criteria.document.formUnutilizedDrugs.locn_id.value;

			f_query_criteria.document.formUnutilizedDrugs.p_date.value=convertDate(f_query_criteria.document.formUnutilizedDrugs.or_date.value,'DMY',f_query_criteria.document.formUnutilizedDrugs.language_id.value,'en');
			
			f_query_criteria.document.formUnutilizedDrugs.submit();
		}
	}

}
function reset()
{
	f_query_criteria.location.reload();
	
}
function callPatientSearch(target)
{

	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  
	 {		
		target.value = patient_id;
	 }
}

function assignValue()
{
	if(document.formUnutilizedDrugs.P_Discontinue_yn_cb.checked)
	{
		document.formUnutilizedDrugs.p_discontinue_yn.value="Y";
	}else{
		document.formUnutilizedDrugs.p_discontinue_yn.value="N";

		}
}

function assignValueForEx()
{
	if(document.formUnutilizedDrugs.P_expiry_order_yn_cb.checked)
	{
		document.formUnutilizedDrugs.p_expiry_order_yn.value="Y";
	}else{
		document.formUnutilizedDrugs.p_expiry_order_yn.value="N";
		}
}



function callLocationLookup(locn_txt) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= formUnutilizedDrugs.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formUnutilizedDrugs.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	if (formUnutilizedDrugs.locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+formUnutilizedDrugs.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+formUnutilizedDrugs.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {		
			formUnutilizedDrugs.locn_id.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
	}
	else if (formUnutilizedDrugs.locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formUnutilizedDrugs.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formUnutilizedDrugs.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formUnutilizedDrugs.locn_id.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
	}
	else{
	alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));//PH_LOCATION_TYPE_CANNOT_BE_BLANK
	}
}

//Added NewFunction  By SureshKumar T for the ICN NO :31194
function ChkDate(obj){
	var locale=formUnutilizedDrugs.p_language_id.value;
	if(obj.value){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}
