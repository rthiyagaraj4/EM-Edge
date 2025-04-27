//This file is saved on 18/10/2005


function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/InterventionAddModify.jsp?mode=1";
}
//*******************************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/InterventionQueryCriteria.jsp";
}
//*********************************************************************************************************
function reset(){

	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) 
		if(f_query_add_mod.document.forms[0])
		{
			f_query_add_mod.document.forms[0].reset();
			if(f_query_add_mod.document.forms[0].dependency1!=null)
				f_query_add_mod.document.forms[0].dependency.value=f_query_add_mod.document.forms[0].dependency1.value;
		}
}
//***********************************************************************************************************
function apply()
{
	if (! checkIsValidForProceed() ) {
		message  =getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var	formObj	= f_query_add_mod.document.Intervention_form;
	var mode = f_query_add_mod.document.Intervention_form.mode.value;
	var system_defined_yn="N";
        var i=0;
	if(formObj.eff_status.checked==true)
		formObj.eff_status.value="E";
	else
		formObj.eff_status.value="D";
	if(mode==2)
	{
        if(formObj.adhoc_intervention.checked==true)
              formObj.adhoc_intervention1.value="Y";
        else
              formObj.adhoc_intervention1.value="N";

		//system_defined_yn=formObj.system_defined_yn.value
		//paramValues="&intervention_code="+formObj.intervention_code.value+"&long_desc="+formObj.long_desc.value+"&short_desc="+formObj.short_desc.value+"&eff_status="+formObj.eff_status.value+"&intervention_type="+formObj.intervention_type.value+"&dependency="+formObj.dependency.value+"&durn="+formObj.durn.value+"&durn_unit="+formObj.durn_unit.value+"&durnBeforeStart="+formObj.durnBeforeStart.value+"&durnBeforeStart_unit="+formObj.durnBeforeStart_unit.value+"&durnAfterStart="+formObj.durnAfterStart.value+"&durnAfterStart_unit="+formObj.durnAfterStart_unit.value+"&durnAfterEnd="+formObj.durnAfterEnd.value+"&durnAfterEnd_unit="+formObj.durnAfterEnd_unit.value+"&durnBackDate="+formObj.durnBackDate.value+"&durnBackDate_unit="+formObj.durnBackDate_unit.value+"&result_type="+formObj.result_type.value+"&result_id="+formObj.result_id.value+"&result_measure="+formObj.result_measure.value+"&adhoc_intervention="+formObj.adhoc_intervention.value+"&guidelines="+formObj.guidelines.value; //IN036452
		paramValues="&intervention_code="+formObj.intervention_code.value+"&long_desc="+formObj.long_desc.value+"&short_desc="+formObj.short_desc.value+"&eff_status="+formObj.eff_status.value+"&intervention_type="+formObj.intervention_type.value+"&dependency="+formObj.dependency.value+"&durn="+formObj.durn.value+"&durn_unit="+formObj.durn_unit.value+"&durnBeforeStart="+formObj.durnBeforeStart.value+"&durnBeforeStart_unit="+formObj.durnBeforeStart_unit.value+"&durnAfterStart="+formObj.durnAfterStart.value+"&durnAfterStart_unit="+formObj.durnAfterStart_unit.value+"&durnAfterEnd="+formObj.durnAfterEnd.value+"&durnAfterEnd_unit="+formObj.durnAfterEnd_unit.value+"&durnBackDate="+formObj.durnBackDate.value+"&durnBackDate_unit="+formObj.durnBackDate_unit.value+"&result_type="+formObj.result_type.value+"&result_id="+formObj.result_id.value+"&result_measure="+formObj.result_measure.value+"&adhoc_intervention="+formObj.adhoc_intervention.value+"&guidelines="+formObj.guidelines.value+"&patient_instructions_id="+formObj.patient_instructions_id.value; //IN036452
  	}

    var fields = new Array (formObj.intervention_code,formObj.short_desc,formObj.long_desc,formObj.intervention_type,formObj.durn,formObj.durn_unit,formObj.durnBeforeStart,formObj.durnBeforeStart_unit,formObj.durnAfterStart,formObj.durnAfterStart_unit,formObj.durnAfterEnd,formObj.durnAfterEnd_unit,formObj.durnBackDate,formObj.durnBackDate_unit);
    var	names =	new	Array (getLabel("Common.code.label","common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.longdescription.label","common"),getLabel("Common.InterventionType.label","Common"),getLabel("Common.duration.label","common"),getLabel("Common.duration.label","common")+" "+getLabel("Common.Unit.label","common"),getLabel("eCP.DurationBeforeStartTime.label","CP"),getLabel("eCP.DurationBeforeStartTime.label","CP")+" "+getLabel("Common.Unit.label","common"),getLabel("eCP.DurationAfterStartTime.label","CP"),getLabel("eCP.DurationAfterStartTime.label","CP") +" "+getLabel("Common.Unit.label","common"),getLabel("eCP.DurationAfterEndTime.label","CP"),getLabel("eCP.DurationAfterEndTime.label","CP")+" "+getLabel("Common.Unit.label","common"),getLabel("eCP.BackdatingLimit.label","CP"),getLabel("eCP.BackdatingLimit.label","CP")+" "+getLabel("Common.Unit.label","common"));
     i=14;
	if(formObj.result_type.value!="" && system_defined_yn=="N")
	{																
		fields[i]=formObj.result_id;
		names[i]=getLabel("eCP.ResultMeasure.label","CP");
		i++;
	}
	  if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame)) 
	  {
		  var flds=new Array(formObj.intervention_code);
		  var name=new Array(getLabel("Common.code.label","common"));
		  if(mode!=2)
		  {			 
			if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
			{
				formObj.submit();
			}
		  }
		  else
		  {
				formObj.submit();
		  }
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
	   var frmObj=f_query_add_mod.document.Intervention_form;
	    var mode =frmObj.mode.value;
		 	if(mode=="1")
		   		 frmObj.reset()
		   
		   else if(mode=="2")
f_query_add_mod.location.href='../../eCP/jsp/InterventionAddModify.jsp?mode=2'+paramValues;
  }
//*****************************************************************************************************
  function onChangeType(obj)
  {
	  	document.Intervention_form.intervention_type1.value=obj.value;
  }
 
//*************************************************************************************************
function oneffStatusCheck()
{
	var frmObj=	document.Intervention_form;
	if(frmObj.eff_status.checked==true)
	{
		frmObj.eff_status.value="E";
	}else
		frmObj.eff_status.value="D";
}
//*************************************************************************************************
function ChangeAdhoc()
{
	var frmObj=	document.Intervention_form;
	if(frmObj.adhoc_intervention.checked==true){
		frmObj.adhoc_intervention.value="Y";
	}else
		frmObj.adhoc_intervention.value="N";
}
//*************************************************************************************************
function checkMandatory(obj)
{
	var frmObj=	document.Intervention_form;
	
	if(frmObj.result_type.value=="")
		
		document.getElementById('result_measure_img').style.visibility="hidden";
	else
		document.getElementById('result_measure_img').style.visibility="visible";
}

//***************************************************************************************************
function CheckMandatoryResult()
{
	var frmObj=	document.Intervention_form;
	var mode= frmObj.mode.value;

	if(mode=="1")
	{
           document.getElementById('result_measure_img').style.visibility="hidden";
	   frmObj.result_measure_lookup.disabled=true;
	}

/*(frmObj.result_type.value=="")
	{
		
		frmObj.all.result_measure_img.style.visibility="hidden";
		frmObj.result_measure_lookup.disabled=true;
	}
	else
	{
		frmObj.all.result_measure_img.style.visibility="visible";
		frmObj.result_measure_lookup.disabled=false;
	}*/
}

//***************************************************************************************************
function callCheckMaxLength(obj,max) {
        if(obj.value.length > max) {
           alert(getMessage('EXCEED_MAX_LENGTH',"CP"));
		    obj.focus();
			obj.select();
        } else return true;
}
//***************************************************************************************************

function callCheckForNumber(event){
    var numCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (numCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
//**************************************************************************************************
function CheckZero(obj)
{
	if(obj.value == "0" || obj.value == "00")
	{
		alert(getMessage("DURATION_CANNOT_ZERO","CP"));
		obj.focus();
		obj.select();
	 return false;
	}
	else
		return true;
}
//*************************************************************************************************
function ChangeList(obj)
{	
	var frmObj=	document.Intervention_form;
	var mode= document.Intervention_form.mode.value;

	if(mode=='1')
	{
        	if(frmObj.intervention_type.value==obj.value)
			frmObj.intervention_type.value==obj.value;
		if(frmObj.dependency.value==obj.value)
			frmObj.dependency.value=obj.value;

		if(frmObj.result_type.value==obj.value)
		{
			frmObj.result_type.value=obj.value;
			frmObj.result_measure.value="";
			frmObj.result_id.value="";
		}

		if(frmObj.result_type.value=='')
        	      frmObj.result_measure_lookup.disabled=true;
		else
		      frmObj.result_measure_lookup.disabled=false;

	}
	if(mode=='2')
	{
		if(frmObj.intervention_type.value==obj.value)
		{
			frmObj.intervention_type1.value=obj.value;
		}

		if(frmObj.dependency.value==obj.value)
			frmObj.dependency1.value=obj.value;

		if(frmObj.result_type.value==obj.value)
		{
			frmObj.result_type1.value=obj.value;
			frmObj.result_measure.value="";
			frmObj.result_id.value="";
			frmObj.result_measure_lookup.disabled=false;
		}
		if(frmObj.result_type.value=='')
        	      frmObj.result_measure_lookup.disabled=true;
		else
		      frmObj.result_measure_lookup.disabled=false;

	}

}
//************************************************************************************************

function ChangeDurnUnit(obj)
{
	var frmObj=	document.Intervention_form;
	if(frmObj.durn_unit.value==obj.value)
		frmObj.durn_unit1.value=obj.value;
}
function ChangeDurnBeforeStartUnit(obj)
{
	var frmObj=	document.Intervention_form;
	if(frmObj.durnBeforeStart_unit.value==obj.value)
		frmObj.durnBeforeStart_unit1.value=obj.value;
}
function ChangeDurnAfterStartUnit(obj)
{
	var frmObj=	document.Intervention_form;
	if(frmObj.durnAfterStart_unit.value==obj.value)
		frmObj.durnAfterStart_unit1.value=obj.value;
}
function ChangeDurnAfterEndUnit(obj)
{
	var frmObj=	document.Intervention_form;
	if(frmObj.durnAfterEnd_unit.value==obj.value)
		frmObj.durnAfterEnd_unit1.value=obj.value;
}
function ChangeDunBackDateUnit(obj)
{
	var frmObj=	document.Intervention_form;
	if(frmObj.durnBackDate_unit.value==obj.value)
		frmObj.durnBackDate_unit1.value=obj.value;
}
//**************************************************************************************************
async function ViewResultMeasure(target)
{ 
	var frmObj=document.Intervention_form;
	frmObj.result_measure.value="";
	var selected_result_type=frmObj.result_type[frmObj.result_type.selectedIndex].value;
	var title;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "locale";
	dataValueArray[0]= frmObj.locale.value;
	dataTypeArray[0] = STRING;
//	if(selected_result_type=='CH')
//	{
// 		argumentArray[0] ="Select assess_note_id code, assess_note_desc description from cp_assess_note where eff_status ='E' AND UPPER(assess_note_id) LIKE UPPER(?) AND UPPER(assess_note_desc) LIKE UPPER(?) ORDER BY assess_note_desc";
//		title="ResultMatrix";
//	}
	if(selected_result_type=='DP')
	{
// 		argumentArray[0] ="select discr_msr_id code, long_desc description from am_discr_msr where result_type in ('V','Z') and eff_status = 'E' and upper(discr_msr_id) like upper(?) and upper(long_desc) like upper(?) order by long_desc";
 		argumentArray[0] ="SELECT discr_msr_id code, long_desc description FROM am_discr_msr_lang_vw WHERE result_type IN ('V','Z') AND eff_status = 'E' and language_id like ? AND UPPER(discr_msr_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY long_desc";
		title="Discrete Measure Panel";
	}
	else if(selected_result_type=='DA')
	{
// 		argumentArray[0] ="select discr_msr_id code, long_desc description from am_discr_msr where result_type not in ('G','V','Z') and eff_status = 'E' and upper(discr_msr_id) like upper(?) and upper(long_desc) like upper(?) order by long_desc";
 		argumentArray[0] ="SELECT discr_msr_id code, long_desc description FROM am_discr_msr_lang_vw WHERE result_type NOT IN ('G','V','Z') AND eff_status = 'E' and language_id like ? AND UPPER(discr_msr_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY long_desc";
		title="Discreate Measure Atomic";
	}
	else if(selected_result_type=='RM')
	{
// 		argumentArray[0] ="select chart_result_type code, chart_result_type_desc description from or_chart_result_type where eff_status = 'E' and upper(chart_result_type) like upper(?) and upper(chart_result_type_desc) like upper(?) order by chart_result_type_desc";
 		argumentArray[0] ="SELECT chart_result_type code, chart_result_type_desc description FROM or_chart_result_type_lang_Vw WHERE eff_status = 'E' and language_id like ? AND UPPER(chart_result_type) LIKE UPPER(?) AND UPPER(chart_result_type_desc) LIKE UPPER(?) ORDER BY chart_result_type_desc";
		title="Result Matrix";
	}
	else if(selected_result_type=='NT')
	{
// 		argumentArray[0] ="Select assess_note_id code, assess_note_desc description from cp_assess_note where eff_status ='E' AND UPPER(assess_note_id) LIKE UPPER(?) AND UPPER(assess_note_desc) LIKE UPPER(?) ORDER BY assess_note_desc";
 		argumentArray[0] ="SELECT assess_note_id code, assess_note_desc description FROM cp_assess_note_lang_vw WHERE eff_status ='E' and language_id like ? AND UPPER(assess_note_id) LIKE UPPER(?) AND UPPER(assess_note_desc) LIKE UPPER(?) ORDER BY assess_note_desc";
		title="Note Type";
	}
	else if(selected_result_type=='OR')
	{
// 		argumentArray[0] ="select order_catalog_code code,long_desc description from or_order_catalog where eff_status ='E' AND UPPER(order_catalog_code) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY long_desc";
 		argumentArray[0] ="SELECT order_catalog_code code,long_desc description FROM or_order_catalog_lang_vw WHERE eff_status ='E' and language_id like ? AND UPPER(order_catalog_code) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY long_desc";
		title="Orderable";
	}
	else if(selected_result_type=='CH')
	{
// 		argumentArray[0] ="select chart_id code,long_desc description from ca_chart where eff_status ='E' AND UPPER(chart_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY long_desc";
 		argumentArray[0] ="SELECT chart_id code,long_desc description FROM ca_chart_lang_vw WHERE eff_status ='E' and language_id like ? AND UPPER(chart_id) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY long_desc";
		title="Chart";
	}
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(title, argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "") {
			target.value = arr[1] ;
			frmObj.result_id.value = arr[0];
		}else{
			target.value ="";
			frmObj.result_id.value = ""; //IN036454
		}	
}
//IN030473 Start.
async function ViewPatientInstructions(target)
{ 
	var frmObj=document.Intervention_form;
	var title;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataTypeArray[0] = STRING;

		argumentArray[0] ="SELECT CONSENT_FORM_ID code, CONSENT_FORM_LABEL description FROM OR_CONSENT_FORM WHERE EFF_STATUS='E' AND CONSENT_TYPE='I' AND UPPER(CONSENT_FORM_ID) LIKE UPPER(?) AND UPPER(CONSENT_FORM_LABEL) LIKE UPPER(?) ORDER BY CONSENT_FORM_LABEL";
		title="Patient Instructions for Interventions";
	
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(title, argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "") {
			target.value = arr[1] ;
			frmObj.patient_instructions_id.value = arr[0];
		}else{ //36566
			target.value ="";
			frmObj.patient_instructions_id.value = ""; //IN036454
		}//36566
}

//IN030473 End.
//*****************************************************************************

/*function callOrderCatalog()
{

	var dialogHeight= "29" ;
	var dialogTop = "125" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

	var or_catalogue_desc=document.forms[0].order_catalog_desc.value;

	var url="../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+"&called_from=CP&mode="+MODE_INSERT+"&order_category=&order_type="

	var retVal = new String();
	retVal = window.showModalDialog(url,arguments,features);

	if(retVal)
	{
		var secArr=retVal.split("&");
		document.forms[0].order_catalog_code.value=secArr[0];
		document.forms[0].order_catalog_desc.value=secArr[1];
	}else
	{
		document.forms[0].order_catalog_code.value='';
		document.forms[0].order_catalog_desc.value='';
	}
}*/
//**************************************************************************************
/*function result_disable()
{
  var formObj=document.forms[0];
  var order_desc=formObj.order_catalog_desc.value;
  if(order_desc!="")
  {
    formObj.result_type.disabled=true;
    formObj.result_measure.disabled=true;
    formObj.result_measure_lookup.disabled=true;
  }
  else
  {
    formObj.result_type.disabled=false;
    formObj.result_measure.disabled=false;
    formObj.result_measure_lookup.disabled=false;
  }
}
//********************************************************
function order_disable()
{
  var formObj=document.forms[0];
  var result_type=formObj.result_type.value;
  if(result_type!="")
  {
    formObj.order_catalog_desc.disabled=true;
    formObj.order_catalog_lookup.disabled=true;
  }
  else
  {
    formObj.order_catalog_desc.disabled=false;
    formObj.order_catalog_lookup.disabled=false;
  }
}
//*********************************************************
function result_enable(obj)
{
  var formObj=document.forms[0];
  if(obj.value=="")
  {
    formObj.result_type.disabled=false;
    formObj.result_measure.disabled=false;
    formObj.result_measure_lookup.disabled=false;
  }
  else
  {
    formObj.result_type.disabled=true;
    formObj.result_measure.disabled=true;
    formObj.result_measure_lookup.disabled=true;
  }
}*/
//*********************************************************
