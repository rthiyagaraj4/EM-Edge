function callPatientSearch()
{
	var pat_id =  PatientSearch();
	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}
function chkDateTime(obj,format,locale,called_from)
{
	var isDaterange ="";
	if(obj.value != '') 
	{		
		var from_date = document.getElementById("dt_from");
		var to_date = document.getElementById("dt_to");
		
		if(validDateObj(obj,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				ftDateCheck(from_date,to_date,format,locale);
			}
		}	
	}
}
function chkDateTime1(obj,format,locale,called_from)
{
	var isDaterange ="";
	if(obj.value != '') 
	{		
		var et_from = document.getElementById("et_from");
		var et_to = document.getElementById("et_to");
		
		if(validDateObj(obj,format,locale))
		{			
			if(et_from.value != "" || et_to.value != "")
			{
				ftDateCheck(et_from,et_to,format,locale);
			}
		}		
	}
}
function ftDateCheck(from,to,format,locale)
{
	
		if(from.value=="" && to.value=="")
		{
			alert("Period can't be empty");
			return;
		}
		if(!(from.value == "" ))
		{
			if(!isBeforeNow(from.value,format,locale))
			{
			
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				from.select();
				from.focus();
				return false;
				
			}
			else
			{ 
				if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				   {
					   if(isAfter(to.value,from.value, format, locale))
					   {
						   return true;
					   }
					   else
					   {
							alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
							to.select();
							to.focus();
							return false;
					   }
				   }
				   else
				   {
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
						to.select();
						to.focus();
						return false;
				   }
				}
			}
			if(!to.value=="")
			{
			 			 
			}
				
		}
		else
		{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					to.select();
					to.focus();
					return false;
				}
			}
		}
}
function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	//document.getElementById(str).focus();
	document.getElementById(str+".focus();
	return flg;
}

function getCoders(target){
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.RequestedBy.label","COMMON");
	var locale			= document.CoderReviewResult.locale.value;
	

	var sql="select PRACTITIONER_ID code, PRACTITIONER_NAME description from AM_PRACTITIONER  where upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?) and PRACT_TYPE='MA' order by 2";

	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
								
		retArray = CommonLookup( title, argArray );	
				
		if(retArray != null && retArray !="")
		{

			document.CoderReviewResult.coder_id.value = retArray[0];
			document.CoderReviewResult.coder_Desc.value = retArray[1];
				//document.forms[0].performed_by_code.value = retArray[0];
								
		}
		

}
function getCodersByLine(target,i){

var search_string ="";
if(target.value =="?")
	search_string ="";
else
	search_string =target.value;


	/*eval("document.CoderReviewResult.select_"+i).checked =false;  
	eval("document.CoderReviewResult.select_"+i).value ="N";
	eval("document.CoderReviewResult.rl_coder_Desc_"+i).value ="";*/
	
	/*var target1=   eval("document.CoderReviewResult.rl_coder_Desc_"+i).value;
	if(target1.value == undefined)
		target1 ="";*/
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.RequestedBy.label","COMMON");
	var locale			= document.CoderReviewResult.locale.value;
	

	var sql="select PRACTITIONER_ID code, PRACTITIONER_NAME description from AM_PRACTITIONER  where upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?) and PRACT_TYPE='MA' order by 2";

	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = search_string;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
								
		retArray = CommonLookup( title, argArray );	
		if(retArray != null && retArray !="")
		{
			eval("document.CoderReviewResult.rl_coder_id_"+i).value = retArray[0];
			eval("document.CoderReviewResult.rl_coder_Desc_"+i).value = retArray[1];
			eval("document.CoderReviewResult.select_"+i).checked =true;
		    eval("document.CoderReviewResult.select_"+i).value ="Y";
								
		}else{
			
			if(eval("document.CoderReviewResult.rl_coder_Desc_"+i).value ==""){
				eval("document.CoderReviewResult.rl_coder_id_"+i).value = "";
			    eval("document.CoderReviewResult.rl_coder_Desc_"+i).value = "";
			    eval("document.CoderReviewResult.select_"+i).checked =false;
		        eval("document.CoderReviewResult.select_"+i).value ="N";
			}
		}
		
}
function clearCoder(i){
	  if(eval("document.CoderReviewResult.rl_coder_Desc_"+i).value ==""){
		  eval("document.CoderReviewResult.select_"+i).checked =false;
		  eval("document.CoderReviewResult.select_"+i).value ="N";
		  eval("document.CoderReviewResult.rl_coder_Desc_"+i).value ="";
	      eval("document.CoderReviewResult.rl_coder_id_"+i).value   ="";
	  }
}

function searchForDetails(){
	var patient_id  =document.CodersReviewCriteriaForm.patientId.value;
	var encounterCode =document.CodersReviewCriteriaForm.encounterCode.value;
	var clinicCode =document.CodersReviewCriteriaForm.clinicCode.value;
	var splCode =document.CodersReviewCriteriaForm.splCode.value;
	var dtFrom   =document.CodersReviewCriteriaForm.dt_from.value;
	var dtTo     =document.CodersReviewCriteriaForm.dt_to.value;
	var etFrom =document.CodersReviewCriteriaForm.et_from.value;
	var etTo =document.CodersReviewCriteriaForm.et_to.value;
	var attendingPractCode =document.CodersReviewCriteriaForm.attendingPractCode.value;
	var episode_type =document.CodersReviewCriteriaForm.episode_type.value;
	var encodingstatusCode =document.CodersReviewCriteriaForm.encodingstatusCode.value;
	var billingGroupCode =document.CodersReviewCriteriaForm.billingGroupCode.value;
	var customergroupCode =document.CodersReviewCriteriaForm.CustomergroupCode.value;
	var customerCode =document.CodersReviewCriteriaForm.CustomerCode.value;
	var policycode =document.CodersReviewCriteriaForm.Policycode.value;
	var locale     =document.CodersReviewCriteriaForm.locale.value;//Added for AAKH-SCF-0448
	var isDaterange = true;//Added for AAKH-SCF-0448
	var isEncounterrange= true;
	var dtEmpty = "N";
	var etEmpty = "N";

	if(dtFrom == "" && dtTo == ""){
		dtEmpty="Y";
	}

	if(etFrom == "" && etTo == ""){
		etEmpty="Y";
	}


	if(dtEmpty=="Y" && etEmpty=="Y"){
		alert(getMessage("ENC_DISCH_NOT_SELECTED","CA"));
		return;
	}
	if(dtEmpty=="N"){
		if(dtFrom == ""){
			alert(getMessage("DISCH_FROM_DATE_NOT_BLANK","CA"));
			return;
		}else if(dtTo == ""){
			alert(getMessage("DISCH_TO_DATE_NOT_BLANK","CA"));
			return;
		}
		//Adding start for AAKH-SCF-0448
		isDaterange = dateRangeValidation(document.getElementById("dt_from"), document.getElementById("dt_to"), locale, '7', 'DMY');
	
		if(!isDaterange){
					msgref =getMessage("INVALID_FROM_DISCHARGE_DATE_DAYS","CA");
			msgref = msgref.replace('$',7);
			alert(msgref);
			parent.coderReviewResultFrame.location.href = "../../eCA/jsp/blank.jsp"; 
			return false;
		}
		//Adding end for AAKH-SCF-0448
	}

	if(etEmpty=="N"){
		if(etFrom == ""){
				alert(getMessage("ENC_FROM_DATE_NOT_BLANK","CA"));
				return;
		}else if(etTo == ""){
				alert(getMessage("ENC_FROM_DATE_NOT_BLANK","CA"));
				return;
		}
		//Adding start for AAKH-SCF-0448
		isEncounterrange = dateRangeValidation(document.getElementById("et_from"), document.getElementById("et_to"), locale, '7', 'DMY');
	
		if(!isEncounterrange){
			msgref =getMessage("INVALID_FROM_ENC_DATE_DAYS","CA");
			msgref = msgref.replace('$',7);
			alert(msgref);
			parent.coderReviewResultFrame.location.href = "../../eCA/jsp/blank.jsp"; 
			return false;
		}
		//Adding end for AAKH-SCF-0448

	}

	parent.coderReviewResultFrame.location.href = "../../eCA/jsp/CACoderReviewResult.jsp?patient_id="+patient_id+"&encounterCode="+encounterCode+"&clinicCode="+clinicCode+"&dtFrom="+dtFrom+"&dtTo="+dtTo+"&etFrom="+etFrom+"&etTo="+etTo+"&attendingPractCode="+attendingPractCode+"&episode_type="+episode_type+"&encodingstatusCode="+encodingstatusCode+"&billingGroupCode="+billingGroupCode+"&customergroupCode="+customergroupCode+"&customerCode="+customerCode+"&policycode="+policycode+"&dtEmpty="+dtEmpty+"&etEmpty="+etEmpty; 
}
async function showRemarks(patient_id,encounter_id){
	
	
	
	var dialogHeight	= "10" ;
	var dialogWidth	    = "40";
	var dialogTop	    = "270" ;
	
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	retVal          =await  window.showModalDialog("../../eCA/jsp/CACoderPendingDocRemarks.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id,arguments,features);
	


}
function getExcelSheet(msg)
{
		
		
		
		//parent.coderReviewResultFrame.document.CoderReviewResult.action='../../servlet/eCA.CoderReviewDataExcelBookServlet?';
		//parent.coderReviewResultFrame.document.CoderReviewResult.target='messageFrame';
		//parent.coderReviewResultFrame.document.CoderReviewResult.method='post';
		parent.coderReviewButtonsFrame.document.PendingOrdersBottom.submit();
	
}
function assignCoder(){
	var fr_srl_no =document.CoderReviewResult.from_srl_no.value;
	var to_srl_no =document.CoderReviewResult.to_srl_no.value;
	var rec_count = document.CoderReviewResult.row_count.value;
	var coder_id   =document.CoderReviewResult.coder_id.value;
	var coder_desc =document.CoderReviewResult.coder_Desc.value;
	var start_no ="";
	var end_no   ="";
	var row_count  =parseInt(rec_count)+1;
   
    if(fr_srl_no ==""  && to_srl_no !=""){
		alert("From S.No Can Not be blank");
		return false;
    }
	else if(to_srl_no ==""  && fr_srl_no !=""){
		alert("To S.No Can Not be blank");
		return false;
    }
    else if(parseInt(fr_srl_no) > parseInt(to_srl_no)){
		alert("To S.no should be Greater than or equal to from S.no");
		return false;
    }else if(parseInt(fr_srl_no) > row_count){
		alert("From S.No cannot be greater than No.of Records")
			return false;
	}else if(parseInt(to_srl_no) > row_count){
		alert("To S.No cannot be greater than No.of Records")
			return false;
	}else if(fr_srl_no !=""  && to_srl_no !=""){
		if(coder_id ==""){
			alert("Coder must be selected to assign")
			return false;
		}
	}else if(fr_srl_no ==""  && to_srl_no =="" && coder_id ==""){
			alert("Coder must be selected to assign")
				return false;
	}
   
    if(fr_srl_no ==""  && to_srl_no =="" ){
		start_no =0;
		end_no =rec_count;
	}else {
		start_no =parseInt(fr_srl_no)-1;
		end_no   =parseInt(to_srl_no)-1;
	}

	   for (var i = start_no; i<=end_no ;i++ )
	   {

          eval("document.CoderReviewResult.rl_coder_Desc_"+i).value =coder_desc;
		  eval("document.CoderReviewResult.rl_coder_id_"+i).value =coder_id;
		  eval("document.CoderReviewResult.select_"+i).checked =true;
		  eval("document.CoderReviewResult.select_"+i).value ="Y";
	   }

}

function clearData(){
	parent.coderREviewCriteriaFrame.location.reload();
	parent.coderReviewResultFrame.location.href = "../../eCA/jsp/blank.jsp"; 
}
function record(){
	var rec_count = parent.coderReviewResultFrame.document.CoderReviewResult.row_count.value;
	var flag ="";
for (var i = 0; i<=rec_count ;i++ ){
	if(eval("parent.coderReviewResultFrame.document.CoderReviewResult.select_"+i).checked ==true){
		flag =true;
		break;
	}else 
		falg =false
}
	if(flag){
	   parent.coderReviewResultFrame.document.CoderReviewResult.action='../../servlet/eCA.CACoderFunctionServlet';
       parent.coderReviewResultFrame.document.CoderReviewResult.target='messageFrame'; 
	   parent.coderReviewResultFrame.document.CoderReviewResult.method='post';
	   parent.coderReviewResultFrame.document.CoderReviewResult.submit();
	}else
		alert(getMessage("ATLEAST_ONE_SELECTED","Common"));
}

function chkSelect(obj,i){
	var coder_id ="";
	if(obj.checked ==true){
       coder_id =eval("document.CoderReviewResult.rl_coder_id_"+i).value;
	   if(coder_id =="" ){
		   alert("Please select Coder to assign");
	     obj.checked= false;
	   }
	}else{
		
		eval("document.CoderReviewResult.rl_coder_id_"+i).value ="";
		eval("document.CoderReviewResult.rl_coder_Desc_"+i).value="";
	}

}

function callCoderFunction(pat_id,enc_id,pat_calss){

    document.CoderReviewResult.patient_id.value =pat_id;
	document.CoderReviewResult.encounter_id.value =enc_id;
	document.CoderReviewResult.patient_class.value =pat_calss;
	document.CoderReviewResult.action='../../eCA/jsp/OpenChartWrapper.jsp?';
    document.CoderReviewResult.target='messageFrame'; 
	document.CoderReviewResult.method='post';
    
	
	document.CoderReviewResult.submit();
								
}

//-----------------------------------------------------------------
//Speciality
function getSplCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].splCode.value='';
	}else{	
		populateSpl()
	}	 
}
async function populateSpl()
{  
	var target			= document.forms[0].splName;
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
	retVal      =await  CommonLookup( title, argArray );
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].splName.value = retVal[1];
		document.forms[0].splCode.value = retVal[0]
	}
    else
	{
		document.forms[0].splName.value = "";
		document.forms[0].splCode.value = "";
	} 
	document.forms[0].flag.value='true';
} 
//Clinic
function getClinicCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].clinicCode.value='';
	}else{	
		populateClinic()
	}	 
}
async function populateClinic()
{  
	var target			= document.forms[0].clinicName;
	var locale			= document.CodersReviewCriteriaForm.locale.value;
	
	var retVal			=  new String();
	var title			= getLabel("Common.clinic.label","common");
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	
	parNameArray[0] ="~LANGUAGE_ID`";
	parNameArray[1] ="~LANGUAGE_ID`";
	
	parValueArray[0]=locale;
	parValueArray[1]=locale;	
	
	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_CODER_CLINIC_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      = await CommonLookup( title, argArray );
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].clinicName.value = retVal[1];
		document.forms[0].clinicCode.value = retVal[0]
	}
    else
	{
		document.forms[0].clinicName.value = "";
		document.forms[0].clinicCode.value = "";
	} 
	
} 
//----------------------------------------------------------------

//
//Attending Practitioner
function getAttendingPractitionerCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].attendingPractCode.value='';
	}else{	
		attendingPractioner()
	}	 
}
async function attendingPractioner()
{  
	var target			= document.forms[0].attendingPractName;
	var locale			= document.CodersReviewCriteriaForm.locale.value;
	var facilityId			= document.CodersReviewCriteriaForm.facilityId.value;
	
	var retVal			=  new String();
	var title			= getLabel("Common.AttendingPractitioner.label","common");
	//var sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	
	parNameArray[0] ="~FACILITY_ID`";
	parNameArray[1] ="~LANGUAGE_ID`";
	
	parValueArray[0]=facilityId;
	parValueArray[1]=locale;	
	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_CODER_ATTENDING_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      =await CommonLookup( title, argArray );
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].attendingPractName.value = retVal[1];
		document.forms[0].attendingPractCode.value = retVal[0]
	}
    else
	{
		document.forms[0].attendingPractName.value = "";
		document.forms[0].attendingPractCode.value = "";
	} 
	
} 
//----------------------------------------------------------------
//
//Encounter Coding status 
function getEncounterCodingStatus(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].encodingstatusCode.value='';
	}else{	
		populateEncounterCodingStatus()
	}	 
}
async function populateEncounterCodingStatus()
{  
	var target			= document.forms[0].encodingstatusName;
	var retVal			= new String();
	var title			= getLabel("eCA.EncounterCodingstatus.label","eCA");
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
	retVal      =await CommonLookup( title, argArray );
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].encodingstatusName.value = retVal[1];
		document.forms[0].encodingstatusCode.value = retVal[0]
	}
    else
	{
		document.forms[0].encodingstatusName.value = "";
		document.forms[0].encodingstatusCode.value = "";
	} 
	
} 
//----------------------------------------------------------------
//
//Billing Group
function getBillingGroup(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].billingGroupCode.value='';
	}else{	
		populateBillingGroup()
	}	 
}
function populateBillingGroup()
{  
	var target			= document.forms[0].billingGroupName;
	var retVal			= new String();
	var title			= getLabel("Common.BillingGroup.label","common");
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	var locale			= document.CodersReviewCriteriaForm.locale.value;
	
	parNameArray[0] ="~LANGUAGE_ID`";
	parValueArray[0]=locale;
	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_CODER_BILLING_GROUP_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      =await CommonLookup( title, argArray );
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].billingGroupName.value = retVal[1];
		document.forms[0].billingGroupCode.value = retVal[0]
	}
    else
	{
		document.forms[0].billingGroupName.value = "";
		document.forms[0].billingGroupCode.value = "";
	} 
	
} 
//----------------------------------------------------------------
//
//Customer Group
function getCustomerGroupCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].CustomergroupCode.value='';
	}else{	
		populateCustomerGroup()
	}	 
}
async function populateCustomerGroup()
{  
	var target			= document.forms[0].CustomergroupName;
	var retVal			=  new String();
	var title			= getLabel("Common.CustomerGroup.label","common");
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	var locale			= document.CodersReviewCriteriaForm.locale.value;
	
	parNameArray[0] ="~LANGUAGE_ID`";
	parValueArray[0]=locale;
	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_CODER_CUSTOMERORPAYER_GROUP_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      =await CommonLookup( title, argArray );
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].CustomergroupName.value = retVal[1];
		document.forms[0].CustomergroupCode.value = retVal[0];		
	}
    else
	{
		document.forms[0].CustomergroupName.value = "";
		document.forms[0].CustomergroupCode.value = "";		
	} 
	
} 
//----------------------------------------------------------------
//
//Customer
function getCustomerCode(objectCode)
{
	if(objCode.value=='')
	{
		document.forms[0].CustomerCode.value='';
	}else{	
		populateCustomer()
	}	 
}
async function populateCustomer()
{  
	var locale			= document.CodersReviewCriteriaForm.locale.value;
	var customerGroupId			= document.forms[0].CustomergroupCode.value;	
	var target			= document.forms[0].Customername;
	var retVal			=  new String();
	var title			= getLabel("Common.Customer.label","common");
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	
	
	
	parNameArray[0] ="~LANGUAGE_ID`";
	parNameArray[1] ="~CUSTOMER_GROUP_ID`";
	parValueArray[0]=locale;
	parValueArray[1]=customerGroupId;	
	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_CODER_CUSTOMERORPAYER_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      =await CommonLookup( title, argArray );
		
	if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].Customername.value = retVal[1];
		document.forms[0].CustomerCode.value = retVal[0];
		
	}
	else
	{
		document.forms[0].Customername.value = "";
		document.forms[0].CustomerCode.value = "";
	} 
	
	
} 
//----------------------------------------------------------------
//
//Policy
function getPolicyCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].Policycode.value='';
	}else{	
		populatePolicy()
	}	 
}
async function populatePolicy()
{  
	var facilityId			= document.CodersReviewCriteriaForm.facilityId.value;
	var customerGroupId			= document.forms[0].CustomergroupCode.value;
	var customerId			= document.forms[0].CustomerCode.value;
	
	var target			= document.forms[0].Policyname;
	var retVal			=  new String();
	var title			= getLabel("eCA.Policy.label","eCA");
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	
	parNameArray[0] ="~FACILITY_ID`";
	parNameArray[1] ="~CUSTOMER_GROUP_ID`";
	parNameArray[2] ="~CUSTOMER_ID`";
	parValueArray[0]=facilityId;
	parValueArray[1]=customerGroupId;	
	parValueArray[2]=customerId;
	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	
	argArray[12]  = "SQL_CODER_POLICY_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      =await CommonLookup( title, argArray );
		
	if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].Policyname.value = retVal[1];
		document.forms[0].Policycode.value = retVal[0]
	}
	else
	{
		document.forms[0].Policyname.value = "";
		document.forms[0].Policycode.value = "";
	}
	
	
} 
//----------------------------------------------------------------
//
