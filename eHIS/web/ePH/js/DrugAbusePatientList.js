var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function reset() {

	var formObj=searchFrame.document.formDrugAbusePatientList;
	formObj.reset();
	
	formObj.p_patient_id_val.disabled=false;
	formObj.btnPatientID.disabled=false;
	var p_restriction_type=formObj.p_restriction_type.value;
	
	
	if(p_restriction_type=="DC"){
		formObj.drug_name.style.visibility		= "hidden";
		formObj.drug_search.style.visibility		= "hidden";
        // formObj.drug_name_label.style.visibility		= "hidden";		
		searchFrame.document.getElementById("drug_name_label").style.visibility	= "hidden";
		
		formObj.drug_search.style.visibility		= "hidden";
		
		//formObj.drug_class_dtl.style.visibility		= "visible";
		
	}
	
	messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function run() {
	var formObj		   = searchFrame.document.formDrugAbusePatientList;
	var toProceed	   = false;

		if(formObj) { 

				//  AAKH-CRF-0140 - condition based started
					var fields= new Array (formObj.drug_abuse_reported_from_date,formObj.drug_abuse_reported_to_date1); //, formObj.p_patient_id);
					var names= new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common")); //,getLabel("Common.patientId.label","Common"));
					
					formObj.p_patient_id.value=formObj.p_patient_id_val.value;
					if(checkFields(fields,names,messageFrame) ) {
						formObj.p_drug_abuse_fm_date.value = convertDate(formObj.drug_abuse_reported_from_date.value,'DMY',formObj.p_language_id.value,'en');//p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to for Inc : 48027
						formObj.p_drug_abuse_to_date.value = convertDate(formObj.drug_abuse_reported_to_date1.value,'DMY',formObj.p_language_id.value,'en');//p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to for Inc : 48027
			
						
						if( (formObj.p_patient_id_val.value==null || formObj.p_patient_id_val.value=="")) { //AAKH-CRF-0140 // Condition based date should not be blank and within 1 week validation

							// From and To date is having dates...then that date should be within 7 days 
							var days_between  = daysBetween(formObj.p_drug_abuse_fm_date.value, formObj.p_drug_abuse_to_date.value, 'DMY', formObj.locale.value);
							if(days_between<=6) //more than a week then proceed
								toProceed = true; 
							else 
								alert(getMessage("PH_DRUG_DATE_DIFFERENCE","PH"));
						} else 
							toProceed = true; 
						if(toProceed) 
						{
							searchFrame.formDrugAbusePatientList.action="../../eCommon/jsp/report_options.jsp";
							searchFrame.formDrugAbusePatientList.target="messageFrame";
							
							searchFrame.formDrugAbusePatientList.submit();
						}
						//Condition based ends - AAKH-CRF-0140
				}
		}
}

// This will call common patient search
async function callPatientSearch(){

//	var formObj=document.frames.formDrugAbusePatientList;
	var formObj=document.getElementById("formDrugAbusePatientList");
	//var formObj = document.frames['formDrugAbusePatientList'];
	var patient_id = await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		formObj.p_patient_id_val.value = patient_id;
		formObj.p_patient_id.value = patient_id;
		
		formObj.p_patient_id_val.disabled = true;
		formObj.btnPatientID.disabled = true;
	}
}

//AAKH-CRF-0140 - STARTS
function restrictionType(obj){ 

	if(obj!=null && obj.value=='DC') {
		
		document.getElementById("drug_class").style.visibility		= "visible";
		document.getElementById("p_drug_class").style.visibility	= "visible";
		document.getElementById("drug_name").style.visibility		= "hidden";
		document.getElementById("p_drug_code").value					= "";
		document.getElementById("drug_name").value					= "";
		//document.getElementById("drug_name_id").style.visibility		= "hidden";
		document.getElementById("drug_search").style.visibility	= "hidden";
		document.getElementById("drug_name_label").style.visibility	= "hidden";
		
	} else {
		document.getElementById("p_drug_class").value					= "";
		document.getElementById("drug_class").style.visibility		= "hidden";
		document.getElementById("p_drug_class").style.visibility	= "hidden";
		document.getElementById("drug_name").style.visibility		= "visible";
		document.getElementById("drug_search").style.visibility	= "visible";
		document.getElementById("drug_name_label").style.visibility	= "visible";
	}
}  

function callDrugSearch(obj) {
		var arrCodeDesc = DrugSearch("D",obj);
		if(arrCodeDesc != null && arrCodeDesc != "" ) {
			document.formDrugAbusePatientList.p_drug_code.value	=	arrCodeDesc[0];
			obj.value =	arrCodeDesc[1];
		}
	}

function checkingDate(obj,format,locale)
{
 
	var from =document.formDrugAbusePatientList.drug_abuse_reported_from_date;
 
	if(obj.value !="")
	{
		if(CheckDate(obj))
		{
			if(!doDateCheckAlert(from,obj))
			{
				alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE","PH"));

				setTimeout(function() {
					 
					//obj.select();
					obj.focus();
					
				}, 0);
				return false;
			}
			//if(isBeforeNow(obj.value,format,locale))
			//{
			//	return true;
			//}
			/*else
			{
				var label=getLabel("Common.DateRange.label","COMMON");
				var msg = getMessage("DATE_NOT_GREATER_SYSDATE","COMMON");
				msg = msg.replace('$$',label);
				alert(msg);
				obj.select();
				obj.focus();
				return false;
			}*/
		}
	}
}



function CheckValidDate(obj,format,locale)
{
	if(obj.value !="")
	{
		if(CheckDate(obj))
		{
			/*if(isBeforeNow(obj.value,format,locale))
			{
				return true;
			}
			else
			{
				var label=getLabel("Common.DateRange.label","COMMON");
				var msg = getMessage("DATE_NOT_GREATER_SYSDATE","COMMON");
				msg = msg.replace('$$',label);
				alert(msg);
				obj.select();
				obj.focus();
				return false;
			}*/
		}
	}
}

//AAKH-CRF-0140 - ENDS

async function searchDrug(obj){
	var locale=document.formDrugAbusePatientList.locale.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql_order_type ="SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID = #"; 
      sql_order_type=sql_order_type.replace("#","'"+locale+"'");
	argumentArray[0]   = sql_order_type;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2,3";
	argumentArray[5]   = document.formDrugAbusePatientList.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal 	= await CommonLookup( getLabel("ePH.DrugSearch.label","PH"), argumentArray );
	var str = unescape(retVal);
	var arr = str.split(",");
	
	if(retVal != '' && retVal != undefined){
			document.formDrugAbusePatientList.p_drug_code.value	=	arr[0];
			document.formDrugAbusePatientList.drug_name.value	=	arr[1];
			 
		
		}
}
