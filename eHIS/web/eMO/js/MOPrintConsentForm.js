function reset() f
{
   if(f_query_add_mod.document.repConsent)
   {
	  f_query_add_mod.location.href = '../../eMO/jsp/MOrepConsentForm.jsp?param=';
	}
}
function run() 
{ 	
	setTimeout('run1();',2000);	
}

function run1() 
{ 	
	var consentfield = new Array (f_query_add_mod.document.repConsent.patient_id);
	var consentname= new Array("Patient ID");
	if(f_query_add_mod.document.repConsent)
	{ 
		if(f_query_add_mod.checkFields(consentfield, consentname, messageFrame))
		   f_query_add_mod.document.repConsent.submit() ;
	}
}

/*function searchCode(obj,target)
{ 
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var retVal =    new String();
	var argumentArray=new Array(8);       
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var facilityId = "";
	facilityId = document.forms[0].facilityId.value;

    parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	if(obj.name=="patient_search")
	{
		tit="Deceased Patients"
		sql="select patient_id code, patient_name Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and consent_form_code is not null and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) order by 2";
	}
	else
	{
		tit="Deceased Patients"
		sql="select patient_id code, patient_name Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and consent_form_code is not null and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) order by 2";
	
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		if(target.name == 'patient_id')
			document.forms[0].patient_id.value= arr[0];
		parent.f_query_add_mod.location.href = '../../eMO/jsp/MOrepConsentForm.jsp?param='+arr[0];
	}
	else
	{	
		document.forms[0].patient_id.value= "";
	}
	}*/
function firstfocus()
{
	if(document.forms[0].first.value=='')
	  document.forms[0].patient_id.focus();
}
function calljsp(obj)
{	
	var az;
	az = obj.value;
	if(az!='')
	{
		parent.f_query_add_mod.location.href = '../../eMO/jsp/MOrepConsentForm.jsp?param='+az+'&first=N';
	}
}

