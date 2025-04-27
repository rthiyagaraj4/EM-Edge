/*function CheckForSpecCharsLocal(event){*/
//var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/';
/*var whichCode = (window.Event) ? event.which : event.keyCode;
key = String.fromCharCode(whichCode);  // Get key value from key code
if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
return true ;
}*/

/*function validatedate(obj)
{  



if(obj.value!="")
	{
val1=obj.value.length	

if(val1<16)
		{
	alert("APP-SM0004 Invalid Date Format");
	obj.focus();
	return false;
		}
	if(doDateTimeChk(obj)==false)
	{
	alert("APP-SM0004 Invalid Date Format");
	obj.focus();
	return false;
	}
	}
}
*/
function reset() 
{
	if(f_query_add_mod.document.repBurialPermit)
	{
		f_query_add_mod.location.href = '../../eMO/jsp/MOrepBurialPermit.jsp?param=';
	}
}

/*function run() 
{ 	
	setTimeout('run1();',2000);	
}*/

function run() 
{
	/*if(f_query_add_mod.document.forms[0].P_FM_REGN_DATE_TIME.value!=""&&f_query_add_mod.document.forms[0].P_TO_REGN_DATE_TIME.value!="")
	{
	if(	doDateCheck(f_query_add_mod.document.forms[0].P_FM_REGN_DATE_TIME,f_query_add_mod.document.forms[0].P_TO_REGN_DATE_TIME,messageFrame)==false) 
{
var errors=getMessage('FROM_DATE_GREATER_TO_DATE'); 
messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
return false;
}}*/

//alert("f_query_add_mod.CheckString(getLabel('Common.registrationno.label','Common'),f_query_add_mod.document.forms[0].P_FM_REGISTRATION_NO,f_query_add_mod.document.forms[0].P_TO_REGISTRATION_NO, messageFrame)=========>"+f_query_add_mod.CheckString(getLabel('Common.registrationno.label','Common'),f_query_add_mod.document.forms[0].P_FM_REGISTRATION_NO,f_query_add_mod.document.forms[0].P_TO_REGISTRATION_NO, messageFrame))
if(f_query_add_mod.CheckString(getLabel('Common.registrationno.label','Common'),f_query_add_mod.document.forms[0].P_FM_REGISTRATION_NO,f_query_add_mod.document.forms[0].P_TO_REGISTRATION_NO, messageFrame))
{
	if (f_query_add_mod.CheckString(getLabel("Common.date.label","Common"), f_query_add_mod.document.forms[0].P_FM_REGN_DATE_TIME,f_query_add_mod.document.forms[0].P_TO_REGN_DATE_TIME, messageFrame))
	{
		if (f_query_add_mod.CheckString(getLabel('Common.patientId.label','Common'),f_query_add_mod.document.forms[0].P_FM_PATIENT_ID,f_query_add_mod.document.forms[0].P_TO_PATIENT_ID, messageFrame))
		{
			if (f_query_add_mod.CheckString(getLabel('eMO.BurialPermitNo.label','MO'),f_query_add_mod.document.forms[0].P_FM_BURIAL_PERMIT_NO,f_query_add_mod.document.forms[0].P_TO_BURIAL_PERMIT_NO,messageFrame))
			{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit() ;
			}	
		}
	}
}	
	/*calljsp1(f_query_add_mod.document.forms[0].patient_id);
	if(f_query_add_mod.document.forms[0].patient_id.value=='' && f_query_add_mod.document.forms[0].valid.value=='Y')
		{
			var errors='APP-000001 Registration No Cannot be Blank'; 
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		}
	var  valid =f_query_add_mod.document.forms[0].valid.value;
	if (valid=='Y')
	{
		if(f_query_add_mod.document.forms[0].patient_id.value=='')
		{
			var errors='APP-000001 Registration No Cannot be Blank'; 
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		}
		else
		{*/
			
		/*}
	}*/
}

/*function calljsp1(obj)
{
	var az;
	az = obj.value;

	if(az!='')
		{
		f_query_add_mod.location.href = '../../eMO/jsp/MOrepBurialPermit.jsp?param='+az+'&first=N';
		}
}*/
async function searchCode(obj,target)
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
		var fieldLegend = new Array() ;
	var tit="";				
	var facilityId = "";
	facilityId = document.forms[0].facilityId.value;
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	if(obj.name=="patient_search"||obj.name=="patient_search1")
	{
	fieldLegend["CODE_LEGEND"] = getLabel("Common.registrationno.label","Common");
    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
	tit= getLabel("eMO.DeceasedPatients.label","MO") + "/" + getLabel("Common.BodyParts.label","Common");
	sql="select REGISTRATION_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and BURIAL_PERMIT_NO is not null and upper(REGISTRATION_NO) like upper(?) and upper(patient_name) like upper(?) order by 2";
	}
	else if(obj.name=="patient_search2"||obj.name=="patient_search3")
	{
	tit= getLabel("eMO.DeceasedPatients.label","MO") + "/" + getLabel("Common.BodyParts.label","Common");
	fieldLegend["CODE_LEGEND"] = getLabel("Common.patientId.label","Common");
    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
	
	sql="select patient_id code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and BURIAL_PERMIT_NO is not null and upper(patient_id) like upper(?) and upper(patient_name) like upper(?) order by 2";
	
	}
	else
	{
	tit= getLabel("eMO.DeceasedPatients.label","MO") + "/" + getLabel("Common.BodyParts.label","Common");
    fieldLegend["CODE_LEGEND"] = getLabel("eMO.BurialPermitNumber.label","MO"); 
    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");

	sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and BURIAL_PERMIT_NO is not null and upper(BURIAL_PERMIT_NO) like upper(?) and upper(patient_name) like upper(?) order by 2";
	
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	argumentArray[8] = fieldLegend ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		//if(target.name == 'patient_id')
			target.value= arr[0];
			//parent.f_query_add_mod.location.href = '../../eMO/jsp/MOrepBurialPermit.jsp?param='+arr[0];
	}
	
}

function firstfocus()
{
	if(document.forms[0].first.value=='')
		document.forms[0].patient_id.focus();
}

/*function calljsp(obj)
{
	var az;
	az = obj.value;

	if(az!='')
		{
		parent.f_query_add_mod.location.href = '../../eMO/jsp/MOrepBurialPermit.jsp?param='+az+'&first=N';
		}
}*/
