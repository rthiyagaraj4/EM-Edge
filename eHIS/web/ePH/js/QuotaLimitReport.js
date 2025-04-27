/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2023        40016               HARIHARAN     21/04/2023       ramesh goli          ML-MMOH-CRF-1823.V1.0
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function reset() {
	f_query_add_mod.formQuoLimitReportCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function run() {
	var frmObject	   = f_query_add_mod.document.formQuoLimitReportCriteria;
	var toProceed	   = false;
       // formObj.submit();

		if(frmObject) { 

					var fields= new Array (frmObject.p_ord_fm_date,frmObject.p_ord_to_date,frmObject.p_speciality); //, formObj.p_patient_id);
					var names= new Array (getLabel("Common.DateFrom.label","ePH"),getLabel("Common.to.label","Common"),getLabel("Common.speciality.label","Common")); //,getLabel("Common.patientId.label","Common"));
					
					if(checkFields(fields,names,messageFrame)) {
					 	
					 	 if(!isBefore(frmObject.p_ord_to_date.value,frmObject.sys_date.value,"DMY",frmObject.p_language_id.value)) {
					 	
								var	errors=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH") ;
								alert(errors);
								return false;
							}
						
					  	
						 if(!isBefore(frmObject.p_ord_fm_date.value,frmObject.p_ord_to_date.value,"DMY",frmObject.p_language_id.value)) {
						
								var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
								alert(errors);
								return false;			
						 	}
					
						 
					 	
					 	 var max_days=daysBetween(frmObject.p_ord_fm_date.value,frmObject.p_ord_to_date.value,"DMY",frmObject.p_language_id.value);
							if(max_days>6){//40016
								
								var errors=getMessage('PH_DRUG_DATE_DIFFERENCE','PH');
								alert(errors);
								return false;
							}
					frmObject.P_FRDATE.value =	frmObject.p_ord_fm_date.value;	
					frmObject.P_TODATE.value =	frmObject.p_ord_to_date.value;	
					f_query_add_mod.document.formQuoLimitReportCriteria.action="../../eCommon/jsp/report_options.jsp";
					f_query_add_mod.document.formQuoLimitReportCriteria.submit();
					 
				}
		}
}


function CheckDateLeap1(obj){
	var locale=f_query_add_mod.document.formQuoLimitReportCriteria.p_language_id.value;
	if(obj.value!=""){
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
	
	

				
async function callPatientSearch(){
	var formObj=document.formQuoLimitReportCriteria;
	var patient_id =await PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		formObj.p_patient_id.value = patient_id;
		//formObj.btnPatientID.disabled = true;
	}
}

function getpractCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].p_prescribed_by.value='';
	}else{	
		PrescribeSearchCode()
	}	 
}

async function PrescribeSearchCode()
{  
	var target			= document.forms[0].p_prescribed_by;
	var retVal			=  new String();
	var title			= getLabel("Common.PrescribedBy.label","common");
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_PH_DISP_LOCN_SELECT10_LOOKUP";
	argArray[13]  = "ePH.Common.PhRepository";
	argArray[14]  = parNameArray ;
	argArray[15]  = parValueArray ;
	retVal      =await CommonLookup( title, argArray );
	var str =unescape(retVal);
	var arr = str.split('"');		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].p_prescribed_by.value = arr[1];
		document.forms[0].p_prescribed_id.value = arr[0];
	}
    else
	{
		document.forms[0].p_prescribed_by.value = "";
		document.forms[0].p_prescribed_id.value = "";
	} 
	document.forms[0].flag.value='true';
}


function getSplCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].p_speciality.value='';
	}else{	
		populateSpl()
	}	 
}


async function populateSpl()
{  
	var target			= document.forms[0].p_speciality;
	var retVal			=  new String();
	var title			= getLabel("Common.speciality.label","common");
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_SPECIALITY_LOOKUP_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      = await CommonLookup( title, argArray );
	var str =unescape(retVal);
	var arr = str.split('"');
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].p_speciality.value = arr[1];
		document.forms[0].p_speciality_code.value = arr[0]
	}
    else
	{
		document.forms[0].p_speciality.value = "";
		document.forms[0].p_speciality_code.value = "";
	} 
	document.forms[0].flag.value='true';
}


function getdrugname(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].p_drug_name.value='';
	}else{	
		searchDrugName1()
	}	 
}

async function searchDrugName1(obj){
	
	var formObj = document.forms.formQuoLimitReportCriteria;
	var formObj = document.forms[0];
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	argumentArray[0]   = formObj.sql_ph_drug_query_select2.value+"'"+formObj.p_language_id.value+"'";
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.p_drug_name.value ;
	
	
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 

	retVal = await CommonLookup( getLabel("Common.DrugName.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split('"');
	if(retVal != null && retVal != "" )  {
		formObj.p_drug_name.value			= arr[1];
			formObj.p_drug_code.value			= arr[0];
	}
}


function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}


