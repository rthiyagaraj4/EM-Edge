  //saved on 30.12.2009

// lookup for Drug Name

function searchDrugName(){
	var formObj = document.frames.formDispDrugsDtl;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]=
	escape(document.getElementById("sql_ph_drug_search_select2").value)+"'"+formObj.language_id.value+"'";
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
		formObj.drug_code.value = retVal[0];
		/* Commented for the incident num:24043 on 29/Sept/2010--By Sandhya
		formObj.p_drug_name.disabled  = true;
		formObj.drug_name_search.disabled = true;*/

		}
}

//reset
function reset()
{
		var formObj=f_query_criteria.document.formDispDrugsDtl;
		//alert(formObj);
		formObj.drug_name_search.disabled = false;
		f_query_criteria.document.formDispDrugsDtl.reset();
}


//From time and to time validation...

function validateDate(){
	var formObj = document.frames.formDispDrugsDtl;
	if (formObj.p_from_date1.value!="" && formObj.p_to_date1.value!=""){
		if(!doDateCheck(formObj.p_from_date1,formObj.p_to_date1,parent.messageFrame)){
			formObj.p_to_date1.select();
		}else{
			//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}
/*function initialize_date(obj){
	var mode=obj.value;
	var formObj = document.formDispDrugsDtl;
	if(formObj == undefined){
		formObj = f_query_criteria.document.formDispDrugsDtl;;  
	}
	var from_date=formObj.p_from_date; 
	var to_date=formObj.p_to_date;
	if(mode == 'M'){
		assigndate(from_date,'M');
		assigndate(to_date,'M');
	}else if(mode == 'Y'){
		assigndate(from_date,'Y');
		assigndate(to_date,'Y');
	}
}
function assigndate(obj,flag){
	var strDate=obj.value;
	var strDateArray=new Array() ; 
	if(strDate != ''){
	strDateArray = strDate.split("/");
		var	strday   = strDateArray[0];
		var strMonth = strDateArray[1];
		var StrYear  = strDateArray[2];
		if(flag == 'Y'){
			obj.value='01/01/'+StrYear;
		}else if(flag == 'M'){
			obj.value='01/'+strMonth+'/'+StrYear; 
		}
	}
}*/

//orderlocation lookup
function locationLookup(target,onblur){
	var formObj = document.frames.formDispDrugsDtl;
	if(formObj.p_locn_name.value=="" && onblur=="yes")
	{
		formObj.p_locn_code.value = "";
		return;
	}
	
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
			else
			{
				formObj.p_locn_code.value = "";
				formObj.p_locn_name.focus();
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
				formObj.p_locn_code.value = "";
				formObj.p_locn_name.focus();
			}
		}
	}
	else{
		alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));
		formObj.p_locn_type.focus()
	}
	
}

function clear1(obj)
{
	
if(document.formDispDrugsDtl.p_locn_type.value==""){
	document.formDispDrugsDtl.p_locn_name.disabled=false;
	document.formDispDrugsDtl.p_locn_name.value='';	
	document.formDispDrugsDtl.p_locn_code.value='';	
			}
else
	{
	document.formDispDrugsDtl.p_locn_name.value='';
		document.formDispDrugsDtl.p_locn_code.value='';	
	}
}


function run(){
	
	var frmObject = f_query_criteria.document.formDispDrugsDtl;
//	var obj=frmObject.p_report_by; 
	if(f_query_criteria.document.formDispDrugsDtl) {
	//	initialize_date(obj);
		var fields= new Array (frmObject.p_from_date1,frmObject.p_to_date1); 
		var names= new Array ('From Date', 'To Date');
		if(checkFields(fields,names,messageFrame) ) {
			frmObject.p_from_date.value = convertDate(frmObject.p_from_date1.value,'DMY',frmObject.p_language_id.value,"en");
			frmObject.p_to_date.value = convertDate(frmObject.p_to_date1.value,'DMY',frmObject.p_language_id.value,"en"); 
			f_query_criteria.document.formDispDrugsDtl.submit();
		}
	}
	
}
function initialize_clase(obj){
	var formObj = document.formDispDrugsDtl;
	var order_by=obj.value;
	if(order_by == 'Drug'){
      formObj.CLAUSE.value="ORDER BY E.DRUG_DESC";
	}else{
		formObj.CLAUSE.value="ORDER BY B.SOURCE_CODE"; 
	}
}

function callPatientSearch(target){

	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
 }
}

/*function clearOrderLocation() {
  var formObj = document.formDispDrugsDtl;
   formObj.p_order_locn_name.value  = "" ;
   
}*/
