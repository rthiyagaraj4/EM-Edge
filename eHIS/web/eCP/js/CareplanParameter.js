	//This file is saved on 18/10/2005



//*********************************************************************************************************
function reset(){
//	var url=f_query_add_mod.location.href;
//	if(url.indexOf("blank")==-1) 
		f_query_add_mod.location.reload();
}
//***********************************************************************************************************
function apply()
{
	var	formObj	= f_query_add_mod.document.CareplanParameterAddModify_form;
	var	fields = new Array ();
	var	names =	new	Array ();
	
	fields[0] = formObj.discr_measure_desc;
	fields[1] = formObj.goal_dfn_lvl;
	fields[2] = formObj.cp_scope;
	fields[3] = formObj.cp_acc;
	
	names[0] = getLabel("eCP.DiscreteMeasureforDependency.label","CP");
	names[1] = getLabel("eCP.GoalDefinitionLevel.label","CP"); 
	names[2] = getLabel("eCP.CarePlanScope.label","CP");
	names[3] = getLabel("eCP.AccuracyforCarePlan.label","CP");

	var disp_type="M";
	var error_jsp = "../../eCommon/jsp/MstCodeError.jsp";
	
	if(checkFieldsofMst( fields, names, messageFrame))
	{
		formObj.submit();
	}
}
//**********************************************************************************************
function checkIsValidForProceed(){

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
//*******************************************************************************************************
 function onSuccess()
   {
		//f_query_add_mod.location.href='../../eCommon/html/blank.html'
		return false;	//f_query_add_mod.location.href='../../eCP/jsp/FactorAddModify.jsp?mode=2'+paramValues;
  }
//*****************************************************************************************************
  function onChangeType(obj)
  {
	  	document.factor_form.factor_type1.value=obj.value;
  }
 
//*************************************************************************************************
function oneffStatusCheck()
{
	var frmObj=	document.factor_form;
	if(frmObj.eff_status.checked==true){
		frmObj.eff_status.value="E";
	}else
		frmObj.eff_status.value="D";
}
//*************************************************************************************************
async function comm_search(targetCode,targetDesc)
{
	var formobj=document.CareplanParameterAddModify_form;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	if (!(targetCode.value == ""))
	{
		targetCode.value = '';		
		targetDesc.value = '';
	}
	dataNameArray[0] = "locale";
	dataValueArray[0]= formobj.locale.value;
	dataTypeArray[0] = STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = targetDesc.value;
	argumentArray[6] = CODE_LINK;//CODE_LINK
	argumentArray[7] = CODE_DESC;//CODE_DESC
	
	if (targetCode.name == "discr_measr_code")
	{
		argumentArray[0] = "select discr_msr_id code,long_desc description from am_discr_msr_lang_vw where result_type = 'L' and eff_status = 'E' and language_id like ? and upper(discr_msr_id) like upper(?) and upper(long_desc) like upper(?) order by long_desc";
		retVal = await CommonLookup(getLabel("eCP.DiscreteMeasures.label","CP"), argumentArray);
	}
	/*else if(targetCode.name == "reassess_code" )
	{
		argumentArray[0] = "Select intervention_code code, short_desc description from ca_intervention where eff_status = 'E' and intervention_code like upper(?) and short_desc like upper(?) order by short_desc";
		retVal = CommonLookup("Reassessment Tasks", argumentArray);
	}*/
	else if(targetCode.name == "med_adm_code")
	{
		argumentArray[0] = "Select intervention_code code, short_desc description from ca_intervention_lang_vw where eff_status = 'E' and language_id like ? and upper(intervention_code) like upper(?) and upper(short_desc) like upper(?) order by short_desc";
		retVal =await CommonLookup(getLabel("eCP.MedicationAdministrationTasks.label","CP"), argumentArray);
	}
	
	
	if (retVal != null && retVal != "")
	{
		var ret1=unescape(retVal);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		targetCode.value = arr[0];
		targetDesc.value = arr[1];
	}
}