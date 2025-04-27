  //saved on 30.12.2009

//Patient Search from common.js
/*function callPatientLookup(){
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
} */

// lookup for Drug Name
function callDrugSearch(obj,mode) {

	var arrCodeDesc = DrugSearch("D",obj);
	
	

	if(arrCodeDesc != null && arrCodeDesc != "" ) {
	/*	if (mode == 1)
		{  document.formSRROrderDispDrugs.p_drug_code.value	=	arrCodeDesc[0];
		//   document.formSRROrderDispDrugs.P_RET_DRUG.value	    =	arrCodeDesc[0];
		   
		}
		if (mode == 2)
		{		document.formSRROrderDispDrugs.p_drug_code.value	=	arrCodeDesc[0];
		} */
		//	 document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		document.formSRROrderDispDrugs.p_drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];


	}else{
		if (mode == 1)
		{  document.formSRROrderDispDrugs.p_drug_code.value	=	"";
		//   document.formSRROrderDispDrugs.P_RET_DRUG.value	    =	"";
		   
		}

	}
}


function searchDrugName(called_from){

	var formObj = document.frames.formSRROrderDispDrugs;
	if((formObj.p_drug_name.value!="" && called_from=="T") || called_from=="L")
	{
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
		
		//formObj.p_drug_name.disabled  = true;  commented for the incident num:23287-reopen
		//formObj.p_drug_name_search.disabled = true;	
		}
		else
		{
			formObj.p_drug_name.value = "" ;
			formObj.p_drug_code.value = "";
		}
	}
	else
	{
		formObj.p_drug_name.value = "" ;
		formObj.p_drug_code.value = "";
	}

}


function locationLookup(target){
	var formObj = document.frames.formSRROrderDispDrugs;
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
			else
			{
				formObj.p_locn_code.value="";
				target.value = "" ;
			}
		}
	}
	else{
		alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));
		formObj.p_locn_type.focus()
	}
}


/*function validateDate(){

	var formObj = document.frames.formSRROrderDispDrugs;
	if (formObj.P_FROM_DATE.value!="" && formObj.P_TO_DATE.value!=""){

	}
}*/

function reset()
{
	var formObj=f_query_add_mod.document.formSRROrderDispDrugs;
	f_query_add_mod.document.formSRROrderDispDrugs.reset();
	formObj.p_drug_name_search.disabled=false;
}


function run() {
	
	var frmObject = f_query_add_mod.document.formSRROrderDispDrugs;
	if(frmObject.p_drug_name.value=="")
		frmObject.p_drug_code.value = "";
	
	if(frmObject.p_locn_name.value=="")
		frmObject.p_locn_code.value = "";
	if(f_query_add_mod.document.formSRROrderDispDrugs) {
	
	var fields= new Array (frmObject.p_from_dt1,frmObject.p_to_dt1);
	var names = new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"));

      if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if(f_query_add_mod.doDateCheck( f_query_add_mod.document.formSRROrderDispDrugs.p_from_dt1, f_query_add_mod.document.formSRROrderDispDrugs.p_to_dt1, messageFrame ) )  {
			 frmObject.p_from_dt.value=convertDate( frmObject.p_from_dt1.value,'DMY', frmObject.p_language_id.value,'en');
			 frmObject.p_to_dt.value=convertDate( frmObject.p_to_dt1.value,'DMY', frmObject.p_language_id.value,'en');
			
			 f_query_add_mod.document.formSRROrderDispDrugs.submit();
			}
		}
	}
}	
	

function clear1(obj)
{
	
if(document.formSRROrderDispDrugs.p_locn_type.value==""){
	document.formSRROrderDispDrugs.p_locn_name.disabled=false;
	document.formSRROrderDispDrugs.p_locn_name.value='';	
	document.formSRROrderDispDrugs.p_locn_code.value='';	
			}
else
	{
	document.formSRROrderDispDrugs.p_locn_name.value='';
		document.formSRROrderDispDrugs.p_locn_code.value='';	
	}
}

function clearvalues(){
           document.formSRROrderDispDrugs.p_drug_code.value	=	"";
		 //  document.formSRROrderDispDrugs.P_RET_DRUG.value	    =	"";
}
