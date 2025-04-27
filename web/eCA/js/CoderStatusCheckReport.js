/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------------------------------------------------------
17/01/2023      40627    			SREENADH.M							 Ramesh G    	TH-KW-CRF-0142
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

function delete_values(field)
{	
	document.coderstatuscheckreport.loca.value="";
	document.coderstatuscheckreport.locn_code.value="";	
}

function resetValues()
{
   parent.messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}

function reset(){

  var formObj = parent.content.f_query_add_mod.coderstatuscheckreport;
  parent.content.f_query_cdrstschkreportresult.location.href = '../../eCommon/html/blank.html';
  formObj.reset();
 
}

function callPatientSearch(){
	var pat_id =  PatientSearch();
	if(pat_id != null)
	{
			document.getElementById("patientId").value = pat_id;
			var frmObj=document.coderstatuscheckreport;
			resetValues();
	}
}	
	
async function patientEncounterDetailNew()
{
	var dialogHeight= "30" ;
	var dialogWidth	= "45" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var patId = document.coderstatuscheckreport.patientId.value;
	
	if(patId !="")
	{
		var retVal =await  window.showModalDialog("../../eOR/jsp/RefusalOrderEncounterFrameSet.jsp?called_from=generic_atc&mode="+MODE_INSERT+"&patientId="+document.coderstatuscheckreport.patientId.value,arguments,features);
				
		if(retVal != undefined && retVal != null)
		{
			var temp = retVal.split('$');
			
			var frmObj		= document.coderstatuscheckreport;
			frmObj.encounterId.value=temp[0];
			
		}
		resetValues();
	}
	else{
		var msg = getMessage("PATIENT_ID_CANNOT_BE_BLANK","CA");
		
		parent.messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		
		return false;
	}
	
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
	var locale			= document.coderstatuscheckreport.locale.value;
	
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
	retVal      =await CommonLookup( title, argArray );
		
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

//Speciality
function chekcSplTxt(txtSpl)
{
	if(txtSpl.value == '')
	{
		parent.frames[0].document.forms[0].splCode.value='';
	}
}
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
	//var sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
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
	var locale			= document.coderstatuscheckreport.locale.value;
	var facilityId		= document.coderstatuscheckreport.p_facility_id.value;
	
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
async function populateBillingGroup()
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
	var locale			= document.coderstatuscheckreport.locale.value;
	
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
	var locale			= document.coderstatuscheckreport.locale.value;
	
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
	var locale			= document.coderstatuscheckreport.locale.value;
	var customerGroupId	= document.forms[0].CustomergroupCode.value;	
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
	retVal      = await CommonLookup( title, argArray );
		
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

//Policy
function getPolicyCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].policyCode.value='';
	}else{	
		populatePolicy()
	}	
}
function populatePolicy()
{  
	var facilityId			= document.coderstatuscheckreport.p_facility_id.value;
	var customerGroupId		= document.forms[0].CustomergroupCode.value;
	var customerId			= document.forms[0].CustomerCode.value;
	
	var target			= document.forms[0].policyName;
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
	retVal      = CommonLookup( title, argArray );
		
	if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].policyName.value = retVal[1];
		document.forms[0].policyCode.value = retVal[0]
	}
	else
	{
		document.forms[0].policyName.value = "";
		document.forms[0].policyCode.value = "";
	}	
} 
//----------------------------------------------------------------
function getPractCode(obj)
 {
 	if(obj.value != ''){
		getPractitionerId13();
	}else{
		document.coderstatuscheckreport.practitioner_id.value = "";
 		document.coderstatuscheckreport.pctr.value = "";
	}		
 } 
 
function getPractitionerId13(){
 	
	var patientId	=	document.coderstatuscheckreport.patientId.value;
	var encounterId		=	document.coderstatuscheckreport.encounterId.value;
	var messageFrameReference = parent.messageFrame;
	var	fields		=	new Array ( document.coderstatuscheckreport.patientId, document.coderstatuscheckreport.encounterId) ;
	var names		=	new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","COMMON"));
	
	if(!(checkFields(fields,names,messageFrameReference))){
		return false;
	}
	
 	
 	var search_code="";
 	var search_desc="";
 	var sql="";
 	search_code="practitioner_id";
 	search_desc= "practitioner_name";
	
	var target = document.coderstatuscheckreport.pctr;
	
 	sql ="select distinct b.practitioner_id code, b.practitioner_name description from CA_ENCNTR_NOTE a, am_practitioner b where b.practitioner_id = a.performed_by_id and b.eff_status='E' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?)  and  a.patient_id = '"+patientId+"'  AND a.encounter_id = '"+encounterId+"' order by 2";
 
 	
 	var title="Practitioner";
 	var serviceVal   ="";
 	var search_desc	= "";
 	var argArray = new Array();
 	var namesArray = new Array();
 	var valuesArray = new Array();
 	var datatypesArray = new Array();
 	argArray[0] = sql;
 	argArray[1] = namesArray;
 	argArray[2] = valuesArray;
 	argArray[3] = datatypesArray;
 	argArray[4] = "1,2";
 	argArray[5] = target.value;
 	argArray[6] = DESC_LINK;
 	argArray[7] = CODE_DESC;
 	retArray = CommonLookup( title, argArray );

 	if (retArray != null && retArray != '' && retArray != "null")
 	{
 		document.coderstatuscheckreport.practitioner_id.value = retArray[0];
 		document.coderstatuscheckreport.pctr.value = retArray[1];
 	}else{
		document.coderstatuscheckreport.practitioner_id.value = "";
 		document.coderstatuscheckreport.pctr.value = "";
	}
	resetValues();
 }
 
function checkingDate(obj,format,locale)
{
	var from =document.forms[0].p_fm_Date;
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{
		if(!doDateCheckAlert(from,obj))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			obj.select();
			obj.focus();
		}
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
			msg = msg.replace('$$',label);
			alert(msg);
			obj.select();
			obj.focus();
			return false;
		}
	}
	
	}

}

function Check_Date(obj,format,locale)
{
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{	
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
			msg = msg.replace('$$',label);
			alert(msg);
			obj.select();
			obj.focus();
			return false;
		}
	}	
	}
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
	document.getElementById(str).focus();
	return flg;
}

function getResults(){
	 
		var patientId		=	document.coderstatuscheckreport.patientId.value;
		var encounterId		=	document.coderstatuscheckreport.encounterId.value;
		var note_group		=	document.coderstatuscheckreport.note_group_id.value;
		var note_type		=	document.coderstatuscheckreport.note_type.value;
		var practitioner_id	=	document.coderstatuscheckreport.practitioner_id.value;
		var p_fm_Date		=	document.coderstatuscheckreport.p_fm_Date.value;
		var p_to_Date		=	document.coderstatuscheckreport.p_to_Date.value
		var messageFrameReference = parent.messageFrame;
		var	fields		=	new Array ( parent.f_query_add_mod.document.coderstatuscheckreport.patientId, parent.f_query_add_mod.document.coderstatuscheckreport.encounterId) ;
		var names		=	new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","COMMON"));
		
		if(!(checkFields(fields,names,messageFrameReference))){
			return false;
		}	
		
		var query_string		=	"&p_fm_Date="+p_fm_Date+"&p_to_Date="+p_to_Date+"&note_type="+note_type +"&note_group="+note_group+"&patientId="+patientId+"&encounterId="+encounterId+"&authorised_by="+practitioner_id;
		parent.f_query_cdrstschkreportresult.location.href = "../../eCA/jsp/CoderStatusCheckReportResults.jsp?"+query_string;
		
 }
 async function showpreview(calledFromOption){	 
	
	var selectedRowValue  = "";	
	var selectedRow = parent.f_query_cdrstschkreportresult.document.getElementsByName('selectedRow'); 	
	for(i = 0; i < selectedRow.length; i++) { 
		if(selectedRow[i].checked) 
			selectedRowValue= selectedRow[i].value; 
	} 
	if(selectedRowValue ==""){
		alert("Atleast one Report Result to be selected");
	}else{
		var accessionNum = parent.f_query_cdrstschkreportresult.document.getElementById("accessionNum"+selectedRowValue).value;
		var noteType = parent.f_query_cdrstschkreportresult.document.getElementById("noteType"+selectedRowValue).value;
		var recordedFacility = parent.f_query_cdrstschkreportresult.document.getElementById("recordedFacility"+selectedRowValue).value;
		
		var patient_id	=	document.coderstatuscheckreport.patientId.value;
		var encounter_id		=	document.coderstatuscheckreport.encounterId.value;
		var dialogTop	= "80";
		var dialogHeight= "40" ;
		var dialogWidth	= "60" ;
		var arguments = "";
		var features	= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scrollbars=yes;	resizable=yes; fullscreen=no;" ;
		
		var retVal =await window.showModalDialog("../../eCA/jsp/ClinicalNoteAuditTrialPrintPreview.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_from=&accessionNum="+accessionNum+"&noteType="+noteType+"&recordedFacility="+recordedFacility+"&calledFromOption="+calledFromOption,arguments,features);
	}
	
 }
 
