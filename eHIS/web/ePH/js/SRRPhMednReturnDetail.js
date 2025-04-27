
  //saved on 02.11.2005
//Patient Search from common.js
function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var P_PAT_ID = PatientSearch();
	if(P_PAT_ID != null && P_PAT_ID != "" )  {
		formObj.P_PAT_ID1.value = P_PAT_ID;
		formObj.P_PAT_ID.value = P_PAT_ID;
		//formObj.P_PATIENT_ID.value = P_PAT_ID;
		//formObj.patient_id.focus();
		formObj.P_PAT_ID1.disabled  = true;
		//formObj.patient_search.disabled = true;
     }
}

// lookup for Drug Name
function callDrugSearch(obj,mode) {

	var arrCodeDesc = DrugSearch("D",obj);
	
	

	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)
		{  document.formPhMedicationReturnDetail.p_drug_code.value	=	arrCodeDesc[0];
		   document.formPhMedicationReturnDetail.P_RET_DRUG.value	    =	arrCodeDesc[0];
		   
		}
		if (mode == 2)
		{		document.formPhMedicationReturnDetail.p_drug_code.value	=	arrCodeDesc[0];
		}
//		document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];


	}else{
		if (mode == 1)
		{  document.formPhMedicationReturnDetail.p_drug_code.value	=	"";
		   document.formPhMedicationReturnDetail.P_RET_DRUG.value	    =	"";
		   
		}

	}
}


function searchDrugName(){

	var formObj = document.frames.formPhMedicationReturnDetail;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select2").value)+"'"+formObj.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	
	argumentArray[5]   = formObj.p_drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );

	if(retVal != null && retVal != "" )  {
		formObj.p_drug_name.value = retVal[1] ;
		formObj.p_drug_code.value = retVal[0];
		
		formObj.p_drug_name.disabled  = true;
		formObj.p_drug_name_search.disabled = true;	
	}
}


/*function locationLookup(target){
	var formObj = document.frames.formPhMedicationReturnDetail;
	var locn_type=formObj.p_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}
	else{
		formObj.p_locn_type.focus()
	}
}*/


/*function validateDate(){

	var formObj = document.frames.formOrderDispDrugs;
	if (formObj.P_FROM_DATE.value!="" && formObj.P_TO_DATE.value!=""){

	}
}*/

function reset()
{ //alert("reset");
	var formObj=f_query_add_mod.document.formPhMedicationReturnDetail;
	f_query_add_mod.document.formPhMedicationReturnDetail.reset();
	formObj.drug_search_btn.disabled=false;
}


function run() {
	
	//alert(f_query_add_mod.document.formPhMedicationReturnDetail.p_locn_code.value);
	
	var frmObject = f_query_add_mod.document.formPhMedicationReturnDetail;
	if(f_query_add_mod.document.formPhMedicationReturnDetail) {
	 //alert("P_PATIENT_ID--->"+frmObject.P_PAT_ID.value);
	var fields= new Array (frmObject.p_from_dt1,frmObject.p_to_dt1);
	var names = new Array (getLabel("ePH.ReturnDateFrom.label","PH"),getLabel("Common.to.label","Common"));
      if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if(f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhMedicationReturnDetail.p_from_dt, f_query_add_mod.document.formPhMedicationReturnDetail.p_to_dt, messageFrame ) )  {
			 frmObject.p_from_dt.value=convertDate( frmObject.p_from_dt1.value,'DMY', frmObject.p_language_id.value,'en');
			 frmObject.p_to_dt.value=convertDate( frmObject.p_to_dt1.value,'DMY', frmObject.p_language_id.value,'en');
			 if(frmObject.P_PAT_ID.value==''){
			 frmObject.P_PAT_ID.value=frmObject.P_PAT_ID1.value;
			 }
				f_query_add_mod.document.formPhMedicationReturnDetail.P_DRUG_NONDRUG.value=f_query_add_mod.document.formPhMedicationReturnDetail.drug_med_supply.value;
				f_query_add_mod.document.formPhMedicationReturnDetail.P_RET_DRUG.value=f_query_add_mod.document.formPhMedicationReturnDetail.drug_code.value;
				
					//alert(f_query_add_mod.document.formPhMedicationReturnDetail.P_DRUG_NONDRUG.value);
			 f_query_add_mod.document.formPhMedicationReturnDetail.submit();
			}
		}
	}
}	
	

/*function clear1(obj)
{
	
if(document.formPhMedicationReturnDetail.p_locn_type.value==""){
	document.formPhMedicationReturnDetail.p_locn_name.disabled=false;
	document.formPhMedicationReturnDetail.p_locn_name.value='';	
	document.formPhMedicationReturnDetail.p_locn_code.value='';	
			}
else
	{
	document.formPhMedicationReturnDetail.p_locn_name.value='';
		document.formPhMedicationReturnDetail.p_locn_code.value='';	
	}
}*/

function clearvalues(){
           document.formPhMedicationReturnDetail.p_drug_code.value	=	"";
		   document.formPhMedicationReturnDetail.P_RET_DRUG.value	    =	"";
}

//Function Location Lookup:
function callLocationLookup(p_locn_code) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	dataNameArray[1]	= "FACILITY_ID" ;
	//dataValueArray[1]	= formPhDispDrugSummary.p_facility_id.value;
	dataValueArray[1]	= formPhMedicationReturnDetail.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	//dataValueArray[2]	= formPhDispDrugSummary.p_facility_id.value;
	dataValueArray[2]	= formPhMedicationReturnDetail.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = p_locn_code.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	//if (formPhDispDrugSummary.locn_type.value == "N")
	if (formPhMedicationReturnDetail.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+formPhMedicationReturnDetail.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+formPhMedicationReturnDetail.p_user_name.value+"' order by 2";			
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {		
			formPhMedicationReturnDetail.p_locn_code.value=retVal[0];
			formPhMedicationReturnDetail.locn_text.value = retVal[1];	
		}
	}
	else //if (formUnutilizedDrugs.locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formPhMedicationReturnDetail.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formPhMedicationReturnDetail.p_user_name.value+"' order by 2";	
		//alert("argumentArray[0]====>" +argumentArray[0]);
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formPhMedicationReturnDetail.p_locn_code.value=retVal[0];
			formPhMedicationReturnDetail.locn_text.value = retVal[1];	
		}
	}

}
function clearLocation(){
	

  formPhMedicationReturnDetail.p_locn_code.value = '';
  formPhMedicationReturnDetail.locn_text.value = '';
}
//SEarch srugmname
function searchDrugName()
{
	
	var formObj = document.frames.formPhMedicationReturnDetail;
	var search_criteria = formObj.drug_med_supply.value
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var lookup_name = getLabel("Common.ItemName.label","Common");
	if (search_criteria == 'D')
	{
	  argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.p_language_id.value+"' and DRUG_YN = 'Y'";
	  lookup_name = getLabel("Common.DrugName.label","Common");
	}else if (search_criteria == 'M' )
	{
	   argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.p_language_id.value+"' and DRUG_YN = 'N'";	  
	}else
	{
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.p_language_id.value+"'";
	}
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = CommonLookup(lookup_name, argumentArray );

	if(retVal != null && retVal != "" )  
	{
		formObj.drug_name.value = retVal[1] ;
		formObj.drug_code.value = retVal[0];
		
		formObj.drug_name.disabled  = true;
		formObj.drug_search_btn.disabled = true;
		
	}
}

function callCriteriaChange(){
	
	var formObj = document.frames.formPhMedicationReturnDetail;

	//formObj.generic_name_txt.value ='' ;
	//formObj.generic_id.value = '';	
	formObj.drug_name.value = '';	
	formObj.drug_code.value = '';	
	
	if (formObj.drug_med_supply.value != '')
	{
		formObj.drug_search_btn.disabled = false;
	}
	else{
		formObj.drug_search_btn.disabled = true;
		
	}
	
}
