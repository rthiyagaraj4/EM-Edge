function searchChkout()
{
	var facility_id = document.forms[0].facility_id.value;
	var module_id =  document.forms[0].module_id.value;
	var speciality =  document.forms[0].speciality.value;
	var patient_id =  document.forms[0].patient_id.value;
	var loc_type=document.forms[0].loc_type.value;
	var oplocation =  document.forms[0].oplocation.value;
	var pract =  document.forms[0].pract.value;
	var gender =  document.forms[0].gender.value;
	var function_id =  document.forms[0].function_id.value;

	var disaster =  document.forms[0].disaster.value;
	var caseoftrauma =  document.forms[0].caseoftrauma.value;
	var oper_stn_id =  document.forms[0].oper_stn_id.value; // Monday, April 19, 2010 venkts 
parent.frames[2].location.href="../../eOP/jsp/OPCancelCheckoutSearchResult.jsp?function_id="+function_id+"&facility_id="+facility_id+"&module_id="+module_id+"&speciality="+speciality+"&patient_id="+patient_id+"&loc_type="+loc_type+"&oplocation="+oplocation+"&oper_stn_id="+oper_stn_id+"&pract="+pract+"&gender="+gender+"&disaster="+disaster+"&caseoftrauma="+caseoftrauma;
	


}

function clearFn()
{
	//parent.frames[1].document.forms[0].reset(); Monday, January 11, 2010 18105:
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.frames[3].location.href="../../eCommon/jsp/error.jsp" ;
}

function reset() {
  
   parent.frames[2].document.location.reload();
}


async function callPatientSearch()
{
	var patient_id	=	document.forms[0].patient_id;
	var retun_value =	"";

	return_value	= await	PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	= return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}

function clearList()
{
	
	if(document.forms[0].module_id.value == 'AE')
		parent.frames[1].document.OPCancelChkoutSearch.loc_type.value="C"; 
		//parent.frames[1].document.OPCancelChkoutSearch.locdesc.value="";
	else if(document.forms[0].module_id.value == 'OP')
	{
		parent.frames[1].document.OPCancelChkoutSearch.locdesc.value="";    
		parent.frames[1].document.OPCancelChkoutSearch.loc_type.value="";     
	}
}



async function getValues(obj,target,targetId,objval,loginUser,oper_stn_id)
		{
			
			var locale=document.forms[0].locale.value
			var tit="";
			var facilityid =document.forms[0].facility_id.value;
			var module_id =document.forms[0].module_id.value;
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

			if(obj.name=="service_button"){
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
			if(obj.name=="locn_button"){
				tit=getLabel("Common.Location.label","Common");
				if(module_id=="AE"){
					argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+facilityid+"' and clinic_type = '"+objval+"' and  language_id='"+locale+"' and eff_status ='E' AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+facilityid+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+loginUser+"' and CANCEL_CHECKOUT_YN = 'Y') and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and LEVEL_OF_CARE_IND='E' ";
				}else if(module_id=="OP"){
					var clinic_type_criteria="";
					if(objval=="C"){//Clinic
						clinic_type_criteria="AND CLINIC_TYPE='"+objval+"'";
					}else if(objval=="E"){//Procedure Unit
						clinic_type_criteria="AND CLINIC_TYPE='"+objval+"'";
					}
					argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+facilityid+"'  and  language_id='"+locale+"' and eff_status ='E' AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+facilityid+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+loginUser+"' and CANCEL_CHECKOUT_YN = 'Y') and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and LEVEL_OF_CARE_IND='A' "+clinic_type_criteria+" ";
				}
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
				// Newly added  by Name :Selvin M  Date :22 sep 2011 INCIDENT NO: 25177 added Starts 
				var specialty=document.forms[0].speciality.value;
				var cliniccode =document.forms[0].oplocation.value;
				if(module_id == "AE"){	
					if(specialty != "" && cliniccode !="" )
					{	
						getPractitioner(obj,target,facilityid,specialty,'',cliniccode,'','','','',"Q7");
						return;
					}	
					else if(specialty != "" && cliniccode =="" )
					{	
						getPractitioner(obj,target,facilityid,specialty,'',cliniccode,'','','','',"Q9");
						return;
					}
					else if(specialty == "" && cliniccode !="" )
					{
						
						getPractitioner(obj,target,facilityid,specialty,'',cliniccode,'','','','',"Q7");
						return;
					}
					
					else 
					{       							
							getPractitioner(obj,target,facilityid,'','','','','','','',"Q2");
							return;
					}
					
				}
				if(module_id == "OP") 				 
				{	
					getPractitioner(obj,target,facilityid,specialty,'',cliniccode,'','','','',"Q2");
					return;
				} 
					//End			
			}
			
			var retVal=await CommonLookup(tit,argumentArray);
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
		
		document.forms[0].pract.value=arr[0];
		document.forms[0].pract_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].pract.value="";	
		document.forms[0].pract_desc.value="";			
	}
}

function changeCase(Obj)
{
			Obj.value=Obj.value.toUpperCase();
}

async function loadCancelChkout(module_id,encounter_id,pat_id,clinic_type,location_id,pract_id,queue_date,service_code,oper_stn_id,registered_in_mo_yn,  visit_type,disposition,medical_yn,surgical_yn,mlc_yn,deceased_time,discharge_date_time,visit_type_ind,p_visit_id,		   p_episode_id,treatment_area_code,locn_code,priority_zone,deceased_yn,ae_bed_no,high_risk_yn,pm_yn,ae_bed_charge,cdate,traumaYn,osccYn,OandGYn,nonEmergYn,mechInjCode,mechInjSubCode,priority_zone_status)//Modified by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646
{		
//Added By Shanmukh for MMS-DM-CRF-0147 start
var isPriorityZoneAppl =OPCancelChkoutResult.isPriorityZoneAppl.value;
if(isPriorityZoneAppl=="true" && priority_zone_status=="D"){
	var error = getMessage("PRIO_ZONE_DIS_CANNOT_PROCEED","AE");
	alert(error);
	parent.frames[2].document.location.reload();
	return false;
}
//End


	var retVal =    new String();
    var dialogHeight= "78vh" ;
    var dialogWidth = "82vw" ;
	var status = "no";
    var scroll = "no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
    var arguments   = "" ;
	var function_id=OPCancelChkoutResult.function_id.value;

	var h="module_id="+module_id+"&pat_id="+pat_id+"&clinic_type="+clinic_type+"&location_id="+location_id+"&encounter_id="+encounter_id+"&pract_id="+pract_id+"&function_id="+function_id+"&queue_date="+queue_date+"&service_code="+service_code+"&oper_stn_id="+oper_stn_id+"&registered_in_mo_yn="+registered_in_mo_yn+"&visit_type="+encodeURIComponent(visit_type)+"&disposition="+encodeURIComponent(disposition)+"&medical_yn="+medical_yn+"&surgical_yn="+surgical_yn+"&traumaYn="+traumaYn+"&osccYn="+osccYn+"&OandGYn="+OandGYn+"&nonEmergYn="+nonEmergYn+"&mechInjCode="+mechInjCode+"&mechInjSubCode="+mechInjSubCode+"&mlc_yn="+mlc_yn+"&deceased_time="+deceased_time+"&discharge_date_time="+discharge_date_time+"&visit_type_ind="+visit_type_ind+"&p_visit_id="+p_visit_id+"&p_episode_id="+p_episode_id+"&treatment_area_code="+treatment_area_code+"&locn_code="+locn_code+"&priority_zone="+priority_zone+"&deceased_yn="+deceased_yn+"&ae_bed_no="+ae_bed_no+"&high_risk_yn="+high_risk_yn+"&pm_yn="+pm_yn+"&ae_bed_charge="+ae_bed_charge+"&cdate="+cdate;//Modified by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646			  
	
    retVal = await top.window.showModalDialog("../../eOP/jsp/OPCancellCheckoutFrameset.jsp?"+h,arguments,features);
	
	if(retVal != null)
		{
			if(retVal == "success")	
				parent.frames[2].document.location.reload();
		}
   
}

function callSamepage()
{ 
	parent.frames[0].document.forms[0].refresh.click();  
}

/*
function loadCancelChkoutYes(alertFlag)
{
	//alert(getMessage("MANAGE_QUEUE_NOT_ALL_CHECKOUT","OP"));
	if(alertFlag == "M")
		alert(getMessage("REGISTERED_IN_MORTUARY","COMMON"));
	if(alertFlag == "I")
		alert(getMessage("CURRENTLY_IN_PATIENT1","COMMON"));
	if(alertFlag == "O")
		alert(getMessage("ALREADY_VISITED_SAME_LOCN","COMMON"));
}
*/

function GetCancellLookupBlur(target)
{
	if(target.value != "")
	{
		GetCancellLookup(target);
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
		document.forms[0].userId.value=arr[0];
		
	
	}
	else
	{
		document.forms[0].cancelled_by.value="";
		document.forms[0].userId.value="";
	}

}

function checkMaxLen(obj)
{
	if (obj.name == "reason")
	{
		if (obj.value.length>500)
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED","COMMON");
			error = error.replace("$",getLabel('Common.reason.label','Common'));
			error = error.replace("#","500");
			alert(error)
			obj.focus();
		}
	}
	else
	{
		if (obj.value.length>200)
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED","COMMON");
			error = error.replace("$",getLabel('Common.Instructions.label','Common'));
			error = error.replace("#","200");
			alert(error)
			obj.focus();
		}
	}
}

function Apply(module_id){
	
	var reasonCode=parent.frames[1].document.forms[0].reasonCode.value;
	var userId=parent.frames[1].document.forms[0].userId.value;
	var remarks=parent.frames[1].document.forms[0].remarks.value;
	var encounter_id=parent.frames[1].document.forms[0].encounter_id.value;
	var facility_id=parent.frames[1].document.forms[0].facility_id.value;
	var function_name=parent.frames[1].document.forms[0].function_name.value;

	var patient_id=parent.frames[1].document.forms[0].patient_id.value;
	var p_episode_type=parent.frames[1].document.forms[0].p_episode_type.value;
	var p_visit_id=parent.frames[1].document.forms[0].p_visit_id.value;
	var p_episode_id=parent.frames[1].document.forms[0].p_episode_id.value;
	var bed_no=parent.frames[1].document.forms[0].bed_no.value;
	var flag_chk=parent.frames[1].document.forms[0].flag_chk.value;

	var final_alert_message = "";
	var cnt1 = "Y";
	if(parent.frames[1].document.forms[0].reasonCode.value == ""){
		cnt1 = "N";
		var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error = error.replace('$',getLabel("Common.ReasonforCancellation.label","Common"));
		parent.frames[1].document.forms[0].reasonCode.focus();
		final_alert_message=error+"\n";
	}
	if(parent.frames[1].document.forms[0].cancelled_by.value == ""){
		cnt1 = "N";
		var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error = error.replace('$',getLabel("Common.cancelledby.label","Common"));
		parent.frames[1].document.forms[0].cancelled_by.focus();
		final_alert_message=final_alert_message+error+"\n";
	}
	if(parent.frames[1].document.forms[0].remarks.value == ""){
		cnt1 = "N";
		var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error = error.replace('$',getLabel("Common.remarks.label","Common"));
		parent.frames[1].document.forms[0].remarks.focus();
		final_alert_message=final_alert_message+error+"\n";		
	}
	if(module_id == 'AE'){
		// If ae_bed_charge_appl_yn is set N in BL  param this block execute other wise .Contrl goes to Else block
		if(document.getElementById('ae_bed_charge_appl_yn').value=='N'){
			if(bed_no != ""){

				if(cnt1 == "N"){
						alert(final_alert_message);
					}else{
						checkForValidBed(bed_no);					
					}
			}
			else{
					parent.frames[1].document.forms[0].flag_chk.value="N";
					if(cnt1 == "N"){
						alert(final_alert_message);
					}else if(parent.frames[1].document.forms[0].flag_chk.value != ""){
						parent.frames[1].document.forms[0].submit();
					}
				}
		}else{
			//CRF_362 logic for cancel bd charges
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="callfunc=cancelAEChkOut&encounterId="+document.getElementById('encounter_id').value+"&episode_type="+document.getElementById('p_episode_type').value+"&episode_id="+document.getElementById('p_episode_id').value+"&visit_id="+document.getElementById('p_visit_id').value+"&patient_id="+document.getElementById('patient_id').value;
			var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);
			var retVal = responseText.split("&^&");
			if(retVal[0]!=''){
				var err_message=retVal[0];
				alert(err_message);
			}else{
				if(bed_no != ""){
					
					if(cnt1 == "N"){
						alert(final_alert_message);
					}else{
						checkForValidBed(bed_no);					
					}
				}else{
					parent.frames[1].document.forms[0].flag_chk.value="N";
					if(cnt1 == "N"){
						alert(final_alert_message);
					}else if(parent.frames[1].document.forms[0].flag_chk.value != ""){
						parent.frames[1].document.forms[0].submit();
					}
				}
			}
		}
	}	
	if(module_id == 'OP'){
		if(cnt1 == "N")
			alert(final_alert_message);
		else
			parent.frames[1].document.forms[0].submit();
	}
}
function submitForm(){
}

/*function searchBed(obj,dt,sysdate)
	{
		
				
		if(obj.value == 'A' || obj.value == '' )
		{
			var retVal = 	new String();
			var dialogHeight= "44" ;
			var dialogWidth	= "49.8" ;
			var dialogTop	= "66" ;	
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			var treatment_area_code = document.OPCancelChkoutResult.treatment_area_code.value;
			var clinic_code = document.OPCancelChkoutResult.locn_code.value;
			var priority_value=document.OPCancelChkoutResult.priority_zone.value;
			var oper_stn=document.OPCancelChkoutResult.oper_stn_id.value;
			var url   = "../../eAE/jsp/AEBedAvailabilityChart.jsp?clinic_code="+clinic_code+"&treatment_area="+treatment_area_code+"&call_function=ReserveBed&select_check=X&bed_classification=N&bed_status=V&priority_zone="+priority_value+"&oper_stn_id="+oper_stn;
			retVal = window.showModalDialog( url,arguments,features);
			
			if(retVal!=null)
			{
				Val = retVal.split("^");
				document.OPCancelChkoutResult.bed_no.value = Val[0];
				document.OPCancelChkoutResult.locn_code.value = Val[1];
				//getTreatmentArea(Val[3]);				
				
				document.OPCancelChkoutResult.bed_no.focus();
			}
		}else if(obj.value == 'O')
		{
			alert(getMessage("BED_OCCUPIED","AE"));
			document.OPCancelChkoutResult.bed_no.value = "";
			document.OPCancelChkoutResult.current_status.value = "A";
		}else if(obj.value == 'R') 
		{
			//alert("here");
			if(!isBefore(dt.value,sysdate.value,"DMY",localeName))
			{	
				alert(getMessage("BED_RESERVED","AE"));
				document.OPCancelChkoutResult.bed_no.value = "";
				document.OPCancelChkoutResult.current_status.value = "A";
		
			}
			
			
		}
	}*/

async	function searchBed()
	{
		var retVal = 	new String();
		var dialogHeight= "88vh" ;
		var dialogWidth	= "50vw" ;
		var dialogTop	= "66" ;	
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var treatment_area_code = document.OPCancelChkoutResult.treatment_area_code.value;
		var clinic_code = document.OPCancelChkoutResult.locn_code.value;
		var priority_value=document.OPCancelChkoutResult.priority_zone.value;
		//var oper_stn=document.OPCancelChkoutResult.oper_stn_id.value;
		var bed_no=document.OPCancelChkoutResult.bed_no.value;
		var url   = "../../eAE/jsp/AEBedAvailabilityChart.jsp?clinic_code="+clinic_code+"&treatment_area="+treatment_area_code+"&bed_no="+bed_no+"&call_function=AssignTrmtArea&bed_status=V&priority_zone="+priority_value;
		retVal =await top.window.showModalDialog( url,arguments,features);
		
		if(retVal!=null)
		{
			Val = retVal.split("^");
			document.OPCancelChkoutResult.bed_no.value = Val[0];
			document.OPCancelChkoutResult.locn_code.value = Val[1];
			//getTreatmentArea(Val[3]);				
			
			document.OPCancelChkoutResult.bed_no.focus();
		}
	}
function checkForValidBed(bed)
{
			
		var treatment_area_code = document.OPCancelChkoutResult.treatment_area_code.value;
		var clinic_code = document.OPCancelChkoutResult.locn_code.value;
		var facility_id=document.OPCancelChkoutResult.facility_id.value;
		var priority_value=document.OPCancelChkoutResult.priority_zone.value;
		var flag_chk=document.OPCancelChkoutResult.flag_chk.value;

				if (bed != "" && clinic_code != "" && treatment_area_code != "")
		{
			
			var HTMLValue	= "<html><head></head><body onKeyDown='lockKey();'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEReserveBedPopulateValue.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='RevertAEChkout'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='ValidBed'><input type='Hidden' name='field1' id='field1' value='"+treatment_area_code+"'><input type='Hidden' name='field2' id='field2' value='"+bed+"'><input type='Hidden' name='field3' id='field3' value='"+facility_id+"'><input type='Hidden' name='field4' id='field4' value='"+clinic_code+"'><input type='Hidden' name='field5' id='field5' value='"+priority_value+"'><input type='Hidden' name='flag_chk' id='flag_chk' value='"+flag_chk+"'></form></body></html>"
			parent.frames[2].document.write(HTMLValue);
			parent.frames[2].document.dummy_form.submit();

		
			//alert("flag_chk "+parent.frames[1].document.forms[0].flag_chk.value);
		}
		return ;
}


