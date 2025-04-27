

function callfocus()
{
	document.forms[0].speciality_desc.focus();
}
function clearFn()
{
	//parent.frames[1].document.forms[0].reset(); Monday, January 11, 2010 18105
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.frames[3].location.href="../../eCommon/jsp/error.jsp" ;
}
function searchCancelChkout(cancelperiod_from,cancelperiod_to,messageFrame)
{
	if(cancelperiod_from.value != "" && cancelperiod_to.value != "")
	{
		
		if(!isBefore(cancelperiod_from.value,cancelperiod_to.value,"DMY",localeName))
		{	
	
		var error=error=getMessage('TO_DT_GR_EQ_FM_DT','SM');
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
		parent.frames[2].location.href="../../eCommon/html/blank.html";  // 18330 Wednesday, January 20, 2010
		return false;
		}
	}
		
			var facility_id=document.forms[0].facility_id.value;
			var speciality_code=document.forms[0].speciality_code.value;
			var location_id =document.forms[0].location_id.value;
			var pract=document.forms[0].pract.value;
			var patient_id=document.forms[0].patient_id.value;
			var gender=document.forms[0].gender.value;
			//var encounter_id=document.forms[0].encounter_id.value;
			var patfrom=convertDate(document.forms[0].patfrom.value,'DMY',localeName,'en');
			var patto=convertDate(document.forms[0].patto.value,'DMY',localeName,'en');
			var cancelled_by=document.forms[0].cancelled_by.value;
			var disaster=document.forms[0].disaster.value;
			var caseoftrauma=document.forms[0].caseoftrauma.value;
			var user=document.forms[0].user.value;
			
			parent.frames[2].location.href="../../eAE/jsp/AECancelledChecoutSearchResult.jsp?facility_id="+facility_id+"&speciality_code="+speciality_code+"&location_id="+location_id+"&pract="+pract+"&patient_id="+patient_id+"&gender="+gender+"&patfrom="+patfrom+"&patto="+patto+"&cancelled_by="+cancelled_by+"&disaster="+disaster+"&caseoftrauma="+caseoftrauma+"&user="+user;
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp"; // 18330 Wednesday, January 20, 2010
	}
	

function changeCase(obj)
{
  obj.value=obj.value.toUpperCase();
}

  async function callPatientSearch()
{
	var patient_id	=	document.forms[0].patient_id;
	var retun_value =	"";

	return_value	=await	PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}


function GetLookupBlur(target)
{
	if(target.value != "")
	{
		GetLookup(target);
	}
}

async function GetLookup(target){

	var sql="";
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;			
	var tit				= getLabel("Common.cancelledby.label",'Common');
	sql="select appl_user_id code,appl_user_name description from sm_appl_user where eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate)  and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by upper(appl_user_name)";
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=document.forms[0].cancelled_by.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= CODE_DESC;
	retVal =await CommonLookup( tit, argumentArray );
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].cancelled_by.value=arr[1];
		document.forms[0].user.value=arr[0];
	}
	else
	{
		document.forms[0].cancelled_by.value="";
		document.forms[0].user.value="";
	}

}

function disReset()
{
	parent.frames[0].document.getElementById("reset").disabled= true;
	
}

function reset()
{
	parent.frames[2].document.location.reload();
  
}


async function getValues(obj,target,targetId)
{
		
	var locale=document.forms[0].locale.value
	var tit="";
	var facilityid =document.forms[0].facility_id.value;
	var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
	var argumentArray=new Array(8);
	var sql="";
	var sqlSecond="";
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
	{
		targetId.value="";
		return;
	}
	if(obj.name=="locn_button")
	{
		tit=getLabel("Common.Location.label","Common");;
		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+facilityid+"' and language_id='"+locale+"' and eff_status ='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and level_of_care_ind = 'E' and care_locn_type_ind = 'C' order by 2";
		
				
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4]="1,2";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}
	else 
	if(obj.name=="speciality_button")
	{
		tit=getLabel("Common.speciality.label","Common");							
		argumentArray[0]="select SPECIALITY_CODE code, am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2) description from AM_SPECIALITY where EFF_STATUS = 'E' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)) like upper(nvl(?,am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)))"; 

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4]="1,2";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}
	else
	if(obj.name=="pract_button")
	{
		getPractitioner(obj,target,facilityid,'','','','','','','',"Q2");			
		return;
	}
	var retVal= await CommonLookup(tit,argumentArray);
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal ==null || retVal=="" || !retVal)
	{
		target.value="";
		targetId.value="";
	}
	else
	{
		targetId.value=arr[0];
		target.value=arr[1];
	}
	}


function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null && trimString(retVal) != "")
	{
		arr=retVal.split("~");
		
		document.forms[0].pract.value=arr[0];
		document.forms[0].pract_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].pract.value="";	
		document.forms[0].pract_desc.value="";			
	}
}
async function patvisit() {
	var retVal;
	var dialogHeight= "55vh" ;
	var dialogWidth	= "55vw" ;
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var p_mode = "TRIAGEQUERY";
	retVal =await window.showModalDialog("../../eAE/jsp/AEPaintSearchVisit.jsp?p_mode="+p_mode,arguments,features);
	if(retVal != null){
		if(retVal == "close")
		retVal="|";
		returnarray=retVal.split("|");
		var j1=returnarray[1];
		var j2=returnarray[0];
		document.forms[0].encounter_id.value=j2;
	}
}

function ChkNumber(encval)
{
	var alphabet = false;
	var encvalue	=	encval.value;
	for(i=0; i<encvalue.length; i++)
	{
	if( !(encvalue.charCodeAt(i) >=48 && encvalue.charCodeAt(i) <=57))
		alphabet =true;
	}
		if(alphabet)
		{
			alert(getMessage("AE_INVALID_ENCOUNTER_ID",'AE'));
			encval.focus();
			return true;

		}
		else
			return false;
}


function doDate(obj)
{
	if(obj.value!='')
	{
		if(!validDateObj(obj,'DMY',localeName))
		{
			obj.select();
		}
		else
		{
		if(isBeforeNow(obj.value,"DMY",localeName))
		return true;
	else {
		alert(getMessage("START_DATE_GREATER_SYSDATE",'Common'));
					obj.select();
					return false ;
	 }
	}
	}
}
