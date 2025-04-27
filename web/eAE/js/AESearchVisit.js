/****
	Created on 		: 22/02/2005 By Metilda. For Search Visit Function .
****/
function CheckSplChars()
	 {
		var fields1 = new Array (document.forms[0].encounter_id,document.forms[0].patient_id);	
		var names1 = new Array (getLabel("Common.encounterid.label","Common"),getLabel("Common.patientId.label","Common"));
		var error_page = "../../eCommon/jsp/error.jsp";
		var messageFrame = "";
			if (SpecialCharCheck(fields1,names1,messageFrame,"A",error_page))
			{
				
				CallDescFrame();
			}
			else

			{return false;
			}
		}

function CallDescFrame()
{
	var p_mode = document.forms[0].p_mode.value;
	var max_days_allow_update = document.forms[0].max_days_allow_update.value;
	var oper_stn_id = document.forms[0].oper_stn_id.value;
	var sdtime=document.forms[0].visitadmdatetime.value;
	var function_name=document.forms[0].function_name.value;
	var fun_id=document.forms[0].function_id.value;
	var function_id=fun_id;
	
	var five_level_triage_appl_yn	= document.forms[0].five_level_triage_appl_yn.value;
	

	var start_date=document.forms[0].start_date.value;
		if(sdtime == "")
		{
			var startdate=getMessage('CAN_NOT_BE_BLANK','Common')
			startdate=startdate.replace("$",getLabel("Common.StartDate.label","Common"))
			alert(startdate)
			parent.frames[1].document.forms[0].visitadmdatetime.focus();
			parent.frames[2].location.href='../../eCommon/html/blank.html';
			parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
			return false;
		}
	if(!chkFromToTime2(document.forms[0].visitadmdatetime))
	{	
		 parent.frames[2].location.href='../../eCommon/html/blank.html';
	}
	else 
	{
		if (p_mode=='REVISEVISIT')
		{
		   param_list="";
		   construct_where_clause();
		   parent.frames[1].document.forms[0].Search.disabled = true;		   
			//parent.frames[3].location.href="../../eAE/jsp/AESearchVisitQueryResult.jsp?pmode="+p_mode+"&fun_id="+fun_id+"&function_id="+fun_id+"&max_days_allow_update="+max_days_allow_update+"&oper_stn_id="+oper_stn_id+"&start_date="+start_date+"&where_criteria="+document.forms[0].where_criteria1.value+param_list+"&function_name="+encodeURIComponent(function_name);
		  //five_level_triage_appl_yn  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		   parent.frames[3].location.href="../../eAE/jsp/AESearchVisitQueryResult.jsp?pmode="+p_mode+"&fun_id="+fun_id+"&function_id="+fun_id+"&max_days_allow_update="+max_days_allow_update+"&oper_stn_id="+oper_stn_id+"&start_date="+start_date+"&where_criteria="+document.forms[0].where_criteria1.value+param_list+"&function_name="+encodeURIComponent(function_name)+"&five_level_triage_appl_yn="+five_level_triage_appl_yn;
		   
		}
		else if (p_mode=='CANCELVISIT')
		{
		   param_list="";
		   construct_where_clause();
		   parent.frames[1].document.forms[0].Search.disabled = true;

		     if(parent.frames[1].document.forms[0].inc_arrive_cons_start_pats.checked == true)
				Include_Arrive_startCons_yn = "Y";
			else
				Include_Arrive_startCons_yn = "N";	
		 	//parent.frames[3].location.href="../../eAE/jsp/AESearchVisitQueryResult.jsp?pmode="+p_mode+"&fun_id="+fun_id+"&function_id="+fun_id+"&max_days_allow_update="+max_days_allow_update+"&Include_Arrive_startCons_yn="+Include_Arrive_startCons_yn+"&oper_stn_id="+oper_stn_id+"&start_date="+start_date+"&where_criteria="+document.forms[0].where_criteria1.value+param_list+"&function_name="+encodeURIComponent(function_name);
		   //five_level_triage_appl_yn  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		     parent.frames[3].location.href="../../eAE/jsp/AESearchVisitQueryResult.jsp?pmode="+p_mode+"&fun_id="+fun_id+"&function_id="+fun_id+"&max_days_allow_update="+max_days_allow_update+"&Include_Arrive_startCons_yn="+Include_Arrive_startCons_yn+"&oper_stn_id="+oper_stn_id+"&start_date="+start_date+"&where_criteria="+document.forms[0].where_criteria1.value+param_list+"&function_name="+encodeURIComponent(function_name)+"&five_level_triage_appl_yn="+five_level_triage_appl_yn;
	   	}
		else if (p_mode=='TRIAGEQUERY' )
		{
           param_list="";
		   construct_where_clause();
		   parent.frames[1].document.forms[0].Search.disabled = true;
		   // parent.frames[2].location.href="../../eAE/jsp/AESearchVisitQueryResult.jsp?pmode="+p_mode+"&fun_id="+fun_id+"&function_id="+fun_id+"&max_days_allow_update="+max_days_allow_update+"&oper_stn_id="+oper_stn_id+"&where_criteria="+document.forms[0].where_criteria1.value+param_list;
		 //five_level_triage_appl_yn  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		   parent.frames[2].location.href="../../eAE/jsp/AESearchVisitQueryResult.jsp?pmode="+p_mode+"&fun_id="+fun_id+"&function_id="+fun_id+"&max_days_allow_update="+max_days_allow_update+"&oper_stn_id="+oper_stn_id+"&where_criteria="+document.forms[0].where_criteria1.value+param_list+"&five_level_triage_appl_yn="+five_level_triage_appl_yn;
        }
		else 
		{
           param_list="";
		   construct_where_clause();
		   parent.frames[1].document.forms[0].Search.disabled = true;
		  // parent.frames[3].location.href="../../eAE/jsp/AESearchVisitQueryResult.jsp?pmode="+p_mode+"&fun_id="+fun_id+"&function_id="+fun_id+"&max_days_allow_update="+max_days_allow_update+"&oper_stn_id="+oper_stn_id+"&where_criteria="+document.forms[0].where_criteria1.value+param_list;
		 //five_level_triage_appl_yn  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		   parent.frames[3].location.href="../../eAE/jsp/AESearchVisitQueryResult.jsp?pmode="+p_mode+"&fun_id="+fun_id+"&function_id="+fun_id+"&max_days_allow_update="+max_days_allow_update+"&oper_stn_id="+oper_stn_id+"&where_criteria="+document.forms[0].where_criteria1.value+param_list+"&five_level_triage_appl_yn="+five_level_triage_appl_yn;
		}
	}
 }


//Without checking commented
/*function doDate(obj)
	{
	 if(obj.value != '')
	 {
		if (!doDateTimeChk(obj))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'))
			obj.select();
			return;
		}
      }
	}*/

function chkFromToTime2(Obj)
{
	if(Obj.value != '') 
	{
		var p_mode = document.forms[0].p_mode.value;
		if(!validDateObj(Obj,'DMY',localeName))
		{
			Obj.select();
		}
		else
		{

			if(p_mode=='REVISEVISIT' || p_mode=='CANCELVISIT')
			{
			  var fromFormDate = convertDate(Obj.value,"DMY",localeName,"en");
              //if((!isBefore(document.forms[0].system_date1.value,fromFormDate,'DMY',localeName))) {    
              if((!isBefore(document.forms[0].system_date1.value,fromFormDate,'DMY',"en"))) {  ////Modified By Dharma on Oct 1st 2015 against Leap Year Issue  
					  if(p_mode=='REVISEVISIT' )
						alert(getMessage("REV_DATE_LESS_AE_PARAM",'AE'))
					  else if (p_mode=='CANCELVISIT')
						  alert(getMessage("CANNOT_CANCEL_VISIT_LESSER",'AE'))
						  Obj.value = "";
						  Obj.select();
						return false;
				}
			  if((!isBeforeNow(Obj.value,'DMY',localeName)))
				{
						alert(getMessage("START_DT_LE_CURR_DT","AE"))
						Obj.value = "" ;
						Obj.select();
						return false;
				}
			}
		}
	}
	return true;
}
/*
function beforeGetPractitioner2(obj,target_name)
{
	target_name.value = trimString(target_name.value);
		 if(target_name.value == "")
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].practitioner_id.value="";
			 
			
			 return;
			}

			getPractitioner2(obj,target_name);
}
*/
function getPractitioner2(obj,target)
	{

  var open_to_all_pract_yn= "";
  var practName_FName="";
  var practName_FValue=""; 
  var practitioner_type="";
 
  practName_FName=target.name;
  practName_FValue=target.value;
	var locale=document.forms[0].locale.value;
   var clinic_code=document.forms[0].assign_care_locn_code.value;
   var specialty_code=specialtyForClinc[document.forms[0].assign_care_locn_code.selectedIndex];
	var facility_id=document.forms[0].facility_id.value;
	var treatment_area_code="";
	var open_to_all_prac_for_clinic_yn="";

if(document.forms[0].assign_care_locn_code.value.length>0)
	open_to_all_pract_yn=openToAllPractYN[document.forms[0].assign_care_locn_code.selectedIndex];
  else
    open_to_all_pract_yn='Y';

	var practitioner_id		=	document.forms[0].practitioner_id.value;

	var p_desc	=	document.forms[0].practitioner_desc.value;
	if (p_desc==null) p_desc = "";

/*if(cliniccode!="") 
{
	if(open_to_all_pract_yn=="Y")
	{
		FirstSql="select a.practitioner_id, am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,decode(a.POSITION_CODE , 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.POSITION_CODE ) job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW A 	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2 ";

		SecondSql="select a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,decode(a.POSITION_CODE , 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.POSITION_CODE ) job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a   	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2 ";
	}
	else
	{

		FirstSql="select a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,decode(a.POSITION_CODE , 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.POSITION_CODE ) job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E' and a.facility_id= '"+facility_id+"' and a.facility_id= b.facility_id and b.clinic_code = '"+cliniccode+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2 ";

		SecondSql="select a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,decode(a.POSITION_CODE , 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.POSITION_CODE ) job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a ,op_pract_for_clinic_vw b  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and b.practitioner_id = a.practitioner_id and b.eff_status = 'E' and a.facility_id= b.facility_id and a.facility_id= '"+facility_id+"' and b.clinic_code = '"+cliniccode+"' and  (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2 ";
	}		
}
else
{
	FirstSql="select a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,decode(a.POSITION_CODE , 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.POSITION_CODE ) job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2 ";

	SecondSql="select a.practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,'"+locale+"',2) practitioner_type,decode(a.POSITION_CODE , 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.POSITION_CODE ) job_title,a.gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a 	where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code))	and a.facility_id= '"+facility_id+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,'"+locale+"',1)))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) ORDER BY 2 ";
}
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= "<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue)+ "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +specialty_code+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	*/
	getPractitioner(obj,target,facility_id,specialty_code,practitioner_type,"Q2",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn)
	
	return;
	
	}

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practitioner_id.value=arr[0];
		document.forms[0].practitioner_desc.value=arr[1];			
		
	}
	else
	{
		
		document.forms[0].practitioner_id.value="";
		document.forms[0].practitioner_desc.value="";			
		
	}

}

function clearPractitioner(obj)
	{
	   document.forms[0].practitioner_id.value="";
	   document.forms[0].practitioner_desc.value="";
	}

function FileNoVisible()
{
	var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
    if (file_type_appl_yn =='Y')
	 {
	document.getElementById("FileNo").innerHTML="&nbsp;";
	document.getElementById("FileNoValue").innerHTML="&nbsp;";
	 }
}

function ClearFrame()
{
	parent.frames[1].document.forms[0].Search.disabled = false;
    parent.frames[2].location.href='../../eCommon/html/blank.html';
    parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}

function construct_where_clause()
{    
	var param_list="";
    var where_criteria  = "";
    var and_yn      = " and ";
	var visitdate   = "";
    var soundex_function    ="";
	var visit_gr_date=convertDate(document.forms[0].visit_adm_date_time.value,"DMY",localeName,"en");
    //Start Date
    if (!(document.forms[0].visit_adm_date_time.value==null || document.forms[0].visit_adm_date_time.value==""))
    {
	 where_criteria  = " and a.queue_date >= to_date('"+visit_gr_date+"','dd/mm/rrrr')";
        and_yn      = "  and ";
    }
    //Clinic
    if (!(document.forms[0].assign_care_locn_code.value==null || document.forms[0].assign_care_locn_code.value==""))
    {
        where_criteria  += and_yn+ "    locn_code    ='"+document.forms[0].assign_care_locn_code.value+    "'";
        and_yn      = " and ";
    }
 /*   //Practitioner
    if ( !(document.forms[0].practitioner_id.value==null || document.forms[0].practitioner_id.value==""))
    {
        where_criteria  += and_yn+ "    practitioner_id='"+document.forms[0].practitioner_id.value+  "'";
        and_yn      = " and";
    } */
    //Encounter ID
    if (!(document.forms[0].encounter_id.value==null || document.forms[0].encounter_id.value==""))
    {
        where_criteria  += and_yn+ "   encounter_id='"+document.forms[0].encounter_id.value+   "'";
        and_yn      = "  and";
    }
   /* uncommented */   document.forms[0].where_criteria2.value  = where_criteria;
    //Patient ID
    if (!(document.forms[0].patient_id.value==null || document.forms[0].patient_id.value==""))
    {
        where_criteria  += and_yn+ "   a.patient_id='"+document.forms[0].patient_id.value+   "'";
        and_yn      = " and  ";
    }
    document.forms[0].where_criteria1.value  = where_criteria;
}



function call_result2(patientid,pmode)
  {
		var  max_days=document.forms[0].max_days.value;
  }
function closew(encounter_id,Ddate,patient_id,queueStatus,facility_id,practDesc,count)
  {	  
   var module_id ='AE';
   var start_date = parent.frames[1].document.forms[0].start_date.value;
   var function_name = parent.frames[1].document.forms[0].function_name.value;
   var five_level_triage_appl_yn	= parent.frames[1].document.forms[0].five_level_triage_appl_yn.value;
   
   if(parent.frames[1].document.forms[0].p_mode.value=="REVISEVISIT")
	  { 
         //parent.frameSetId.rows='42,0,52,*,50';  
		 parent.frames[2].location.href='../../eCommon/jsp/pline.jsp?P_MODULE_ID=AE&P_FUNCTION_ID=AE_REVISE_VISIT&EncounterId='+encounter_id+'&Facility_Id='+facility_id;
		// parent.frames[3].location.href='../../eAE/jsp/ReviseVisitMain.jsp?start_date='+start_date+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&patient_id='+patient_id+"&function_name="+encodeURIComponent(function_name);
		 //five_level_triage_appl_yn  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		 parent.frames[3].location.href='../../eAE/jsp/ReviseVisitMain.jsp?start_date='+start_date+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&patient_id='+patient_id+"&function_name="+encodeURIComponent(function_name)+"&five_level_triage_appl_yn="+five_level_triage_appl_yn;
	  }
	  else if (parent.frames[1].document.forms[0].p_mode.value=="CANCELVISIT")
	  {			
		  /*		Modified for CRF - PMG20089-CRF-0541 (IN08081)
					Modified by Suresh M Date : 11/12/2009
		  */
		  if(practDesc != "") {
			  alert(getMessage("PRACT_ASSIGNED_CANNOT_CANCEL","AE"));			 
				submitPrevNext(document.forms[0].from.value,document.forms[0].to.value)		
		  } else if(parseInt(queueStatus) >="04") {
			  alert(getMessage("CONSULT_INPROGRESS_CANNOT_CANCEL","AE"));
			   submitPrevNext(document.forms[0].from.value,document.forms[0].to.value)
		  }else if(parseInt(count) >1) {
			 alert(getMessage("SECONDARY_TRIAGE_CANNOT_CANCEL","AE"));
			  submitPrevNext(document.forms[0].from.value,document.forms[0].to.value)
		  } else {       
			  parent.frameSetId.rows='42,0,42,*,50'; 
			  parent.frames[2].location.href='../../eCommon/jsp/pline.jsp?P_MODULE_ID=AE&P_FUNCTION_ID=AE_REVISE_VISIT&EncounterId='+encounter_id+'&Facility_Id='+facility_id;
			  parent.frames[3].location.href='../../eOP/jsp/CancelVisitFrame2.jsp?encounter_id='+encounter_id+'&queue_date='+Ddate+'&module_id='+module_id+"&function_name="+encodeURIComponent(function_name);
		  }

	  }
	  else if (parent.frames[1].document.forms[0].p_mode.value=="TRIAGEQUERY")
	  {
	      /*parent.window.returnValue=encounter_id+"|"+patient_id ;
          parent.window.close();*/
		  top.window.document.getElementById('dialog-body').contentWindow.returnValue = encounter_id+"|"+patient_id;
		  top.window.document.getElementById('dialog_tag').close();   
	  }
	  else
	  {
			// File path is modified against the incident IN016924 by Muthu on 07/12/2009
			parent.frames[4].location.href="../../eAE/jsp/AeinternlReportReprintModal.jsp?encounterid="+encounter_id+"&file_created_at_regn_yn=N";
	  }
  }
function submitPrevNext(from, to)
{
    document.forms[0].from.value = from;
    document.forms[0].to.value = to; 
    document.forms[0].submit();
}

async function getPatID()
{					  
	var pat_id= await PatientSearch();
	if( pat_id != null )						
		parent.frames[1].document.forms[0].patient_id.value = pat_id ;					
}

function PractEnableDisable(Obj)
		{
			if(Obj.value != "")
			{
				parent.frames[1].document.forms[0].practitioner_id.value = "";
				parent.frames[1].document.forms[0].practitioner_desc.value = "";
				parent.frames[1].document.forms[0].practitioner_desc.readOnly = false;
				parent.frames[1].document.forms[0].Practitioner_lookup_button.disabled = false;
			}
			else
			{
				parent.frames[1].document.forms[0].practitioner_id.value = "";
				parent.frames[1].document.forms[0].practitioner_desc.value = "";
				parent.frames[1].document.forms[0].practitioner_desc.readOnly = true;
				parent.frames[1].document.forms[0].Practitioner_lookup_button.disabled = true;			
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
			encval.select();
			return true;

		}
		else
			return false;
}
