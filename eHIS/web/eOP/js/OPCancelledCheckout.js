
 function changeCase(Obj)
{
			Obj.value=Obj.value.toUpperCase();
}
function clearFn()
{
	parent.frames[1].document.forms[0].reset();
	parent.frames[2].location.href="../../eCommon/html/blank.html";

}
function clearList()
{
parent.frames[1].document.OPCancelChkoutSearchForm.oplocation_desc.value="";    
parent.frames[1].document.OPCancelChkoutSearchForm.oplocation.value="";     


}

async function patqry() {
	var pat_id=await PatientSearch();
	if(pat_id == null) pat_id = "";
	parent.frames[1].document.OPCancelChkoutSearchForm.txtpatid.value=pat_id;
}
function reset() {
  
   parent.frames[2].document.location.reload();
	
}
async function getValues(obj,target,targetId,objval)
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

			if(obj.name=="service_button")
			{
				tit=getLabel("Common.service.label","Common");

				argumentArray[0]="SELECT distinct service_code code, am_get_desc.AM_SERVICE(service_code,'"+locale+"',2) description FROM   am_facility_service WHERE operating_facility_id = '"+facilityid+"' AND   eff_status =  'E' AND   UPPER(service_code) LIKE UPPER(NVL(?,service_code)) AND   UPPER(am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)) LIKE UPPER(NVL(?,am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)))";	
				
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else
			if(obj.name=="locn_button")
			{
				tit=getLabel("Common.Location.label","Common");;
				
				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+facilityid+"' and clinic_type = '"+objval+"' and  language_id='"+locale+"' and eff_status ='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";
				
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
				await getPractitioner(obj,target,facilityid,'','','','','','','',"Q2");			

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
			if(retVal ==null || retVal=="")
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
		
		document.forms[0].oppract.value=arr[0];
		document.forms[0].oppract_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].oppract.value="";	
		document.forms[0].oppract_desc.value="";			
	}
}

/*function patvisit() {
	var retVal;
	var dialogHeight= "38" ;
	var dialogWidth	= "50" ;
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var p_mode = "TRIAGEQUERY";
	retVal = window.showModalDialog("../../eAE/jsp/AEPaintSearchVisit.jsp?p_mode="+p_mode,arguments,features);
	if(retVal != null){
		if(retVal == "close")
		retVal="|";
		returnarray=retVal.split("|");
		var j1=returnarray[1];
		var j2=returnarray[0];
		document.forms[0].encounter_id.value=j2;
	}
}*/
async function GetCancellLookupBlur(target)
{
	if(target.value != "")
	{
		await GetCancellLookup(target);
	}
}
async function GetCancellLookup(target){

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
	retVal = await CommonLookup( tit, argumentArray );

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
function searchCancelChkout()
{

	var patfrom=parent.frames[1].document.OPCancelChkoutSearchForm.txtdtfrm.value;
	var patto=parent.frames[1].document.OPCancelChkoutSearchForm.txtdtto.value;
	
		if(patfrom!="" && patto!="")	 
		{
			if(isBefore(patfrom,patto,'DMY',localeName)==false)
			{
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'))
				parent.frames[1].document.forms[0].txtdtto.select();				
				return false;
			}
		} 

 	    if(patfrom!="")
		patfrom=convertDate(patfrom,"DMY",localeName,"en");
		if(patto!="")
		patto=convertDate(patto,"DMY",localeName,"en");	

    var facility_id=document.forms[0].facility_id.value;
	var speciality_desc=document.forms[0].speciality_code.value;
	var location_desc=document.forms[0].oplocation.value;
	var pract_desc=document.forms[0].oppract.value;
	var patient_id=document.forms[0].txtpatid.value;
	var gender=document.forms[0].gender.value;
	var locationtype=document.forms[0].Qloctype.value;
	var patfrom=convertDate(document.forms[0].txtdtfrm.value,'DMY',localeName,'en');
	var patto=convertDate(document.forms[0].txtdtto.value,'DMY',localeName,'en');
	var cancelled_by=document.forms[0].user.value;
	var sysdate1=document.forms[0].sysdate1.value;
	
	/*if(patfrom!=""){
 
		document.forms[0].txtdtto.value=sysdate1;
	}*/

parent.frames[2].location.href="../../eOP/jsp/OPCancelledCheckoutQuerySearchResult.jsp?facility_id="+facility_id+"&speciality_desc="+speciality_desc+"&location_desc="+location_desc+"&pract_desc="+pract_desc+"&patient_id="+patient_id+"&gender="+gender+"&patfrom="+patfrom+"&patto="+patto+"&cancelled_by="+cancelled_by+"&locationtype="+locationtype


}
function doDate(obj)
{
	if(obj.value!='')
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

