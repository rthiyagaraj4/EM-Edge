function reset()
{
  	//parent.frames[1].frames[1].document.forms[0].reset();
  window.frames[1].document.forms[0].reset();
  
  window.frames[1].document.forms[0].search.disabled = false;
	window.frames[2].document.location.href = "../../eCommon/html/blank.html";
}

/*function DateCheck(obj)
{
	var valid=true;

	var sysdate=parent.frames[1].document.forms[0].sys_date;
	 if(obj.value!="")
	{
		if(!CheckDate(obj)){
						obj.focus();									
						valid = false;
					}
         if(valid)
		{
			 if(!doDateCheckAlert(obj,sysdate)){
							var error = getMessage("VISIT_LESS_DATE","COMMON");
							alert(error);
							valid = false;
						    obj.select();
							obj.focus();
						}
		}
	}
}*/


function onBlurgetLoc(loginuser,locale,fac_id,target)
{		 	
		if(target.value == "")
		{
			target.value="";
			document.forms[0].location.value="";
			return;
		}
 getLocn(loginuser,locale,fac_id,target)
}

async function getLocn(loginuser,locale,fac_id,target)
{  
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";	   
   
   tit=getLabel("Common.Location.label",'Common');
 
   sql ="select b.locn_code code, a.long_desc description from op_clinic_lang_vw a, am_os_user_locn_access_vw b where a.facility_id='"+fac_id+"' and a.language_id='"+locale+"'  AND a.facility_id=b.facility_id and a.level_of_care_ind='A' and a.eff_status='E'   and a.clinic_type='C' and a.clinic_type=b.locn_type and a.clinic_code=b.locn_code and b.oper_stn_id= (SELECT OPER_STN_ID FROM AM_USER_FOR_OPER_STN WHERE FACILITY_ID = '"+fac_id+"' AND language_id='"+locale+"'  AND appl_user_id= '"+loginuser+"' AND TRUNC(SYSDATE) BETWEEN eff_date_from AND NVL(eff_date_to,TRUNC(SYSDATE))) and b.appl_user_id='"+loginuser+"' AND b.checkout_pat_yn='Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";  
   
  				
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;

				retVal = await CommonLookup( tit, argumentArray );
				if(retVal != null && retVal != "" ) {
	                var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
				    document.forms[0].location.value=arr[0];
				} else {
					document.forms[0].location.value = "";
					document.forms[0].Location1.value = "";
				}
}

	function callPractSearch(obj,target)
	{
		var practName_FName="";
		var practName_FValue="";

		var locale = parent.frames[1].document.forms[0].locale.value;			
		var facilityid = parent.frames[1].document.forms[0].facility_id.value;			
		
		target.value=trimString(target.value);
		if(target.value=="" && window.event.target == target)
		{
			parent.frames[1].document.forms[0].practitioner.value="";
			return;
		}

		practName_FName=target.name;
		practName_FValue=target.value;
		
		var sql="";
		var sqlsec="";

		getPractitioner(obj,target,facilityid,'','','','','','','',"Q2");
		
		/*
		
		//sql =  "SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,am_pract_for_facility d WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.eff_status='E' and d.facility_id='"+facilityid+"' ";

		sql = " SELECT a.practitioner_id practitioner_id ,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name , am_get_desc.am_pract_type(PRACT_TYPE,'"+locale+"',2 ) practitioner_type ,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty ,a.gender gender ,a.position_code job_title FROM am_practitioner a,  am_pract_for_facility d WHERE a.pract_type LIKE (?)   AND a.primary_speciality_code LIKE UPPER(?) AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)))  AND a.gender LIKE (?)  AND ( a.position_code LIKE (?) OR a.position_code IS NULL)  AND a.practitioner_id=d.practitioner_id AND d.eff_status='E' AND d.facility_id='"+facilityid+"' ";
			
		//sqlsec =" SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,am_pract_for_facility d WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.eff_status='E' and d.facility_id='"+facilityid+"' ";

		sqlsec =" SELECT a.practitioner_id practitioner_id ,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name , am_get_desc.am_pract_type(PRACT_TYPE,'"+locale+"',2 ) practitioner_type ,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty ,a.gender gender ,a.position_code job_title FROM am_practitioner a,  am_pract_for_facility d WHERE a.pract_type LIKE (?)   AND a.primary_speciality_code LIKE UPPER(?) AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)))  AND a.gender LIKE (?)  and ( a.position_code LIKE (?) or a.position_code IS NULL)  AND a.practitioner_id=d.practitioner_id AND d.eff_status='E' AND d.facility_id='"+facilityid+"'  ";
			
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practName_FName + "\"";
		xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " sql=\"" +escape(sql)+"\"";
		xmlStr += " sqlSec=\"" +escape(sqlsec)+"\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + "" + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);	*/
	}
		
	function PractLookupRetVal(retVal,objName)
	{							
		var arr;
		if (retVal != null && trimString(retVal) != "")
		{
			arr=retVal.split("~");
			parent.frames[1].document.forms[0].practitioner.value=arr[0];
			parent.frames[1].document.forms[0].practitioner_name.value=arr[1];
		}else
		{
			parent.frames[1].document.forms[0].practitioner.value="";
			parent.frames[1].document.forms[0].practitioner_name.value="";			
		}
	}
		
	function clearValues()
	{
		parent.frames[2].location.href="../../eCommon/html/blank.html";
		parent.frames[1].document.getElementById("search").disabled=false;
	}	
	
	function chkWithSysDt(obj)
	{
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("VISIT_LESS_DATE","COMMON"));
				obj.select();
				obj.value = "";
				//obj.focus();
				return false ;
			}
		}
	}

	/*function validateDate(obj)
	{
	if(obj.value!="")
		{
			//alert(validDate(obj.value,'DMY',localeName));
			if(validDate(obj.value,'DMY',localeName)==false)
				{
					alert(getMessage("INVALID_DATE_FMT","SM"));
					obj.select();	
					return false;
			}
			else
				return true;
		}
	}*/

	function displayResult()
	{
		
		var visitDate=parent.frames[1].document.forms[0].visit_date.value;	
		var vis_date = "";

		if(visitDate!="")
		{
			vis_date = convertDate(visitDate,"DMY",localeName,"en");	 
		}		
		else {
				var msg= getMessage('CAN_NOT_BE_BLANK','COMMON');
				msg = msg.replace('$',getLabel("Common.VisitDate.label","COMMON"));
				alert(msg);
				parent.frames[1].document.forms[0].visit_date.focus();
				return false;
		}

		//var serv=parent.frames[1].document.forms[0].service.value;
		//Commented  and added the code for SS-Regression-OP-Conclude Episode [IN:025659] on 24.12.2010 by Suresh M
		var serv=parent.frames[1].document.forms[0].service1.value;
		if(serv == "")
		{
			var msg= getMessage('CAN_NOT_BE_BLANK','COMMON');
			msg = msg.replace('$',getLabel("Common.service.label","COMMON"));
			alert(msg);
			parent.frames[1].document.forms[0].service.value="";
			return false;
		}

		var facility_id= parent.frames[1].document.forms[0].facility_id.value;
		
		var criteria = "    and  OPERATING_FACILITY_ID = '"+facility_id+"' ";

		if(parent.frames[1].document.forms[0].visit_date.value != "")
		{
			//alert(parent.frames[1].document.forms[0].visit_date1.value);
			criteria += " and trunc(LAST_VISIT_DATE) = to_date('"+vis_date+"','dd/mm/yyyy') "; 
		}
		if(parent.frames[1].document.forms[0].location.value != "")
			criteria += " and a.CLINIC_CODE = '"+parent.frames[1].document.forms[0].location.value+"' "; 
		if(parent.frames[1].document.forms[0].service.value != "")
			criteria += " and a.SERVICE_CODE = '"+parent.frames[1].document.forms[0].service.value+"' "; 
		if(parent.frames[1].document.forms[0].practitioner.value != "")
			criteria += " and e.PRACTITIONER_ID = '"+parent.frames[1].document.forms[0].practitioner.value+"' "; 
		if(conclude_episode_criteria.patient_id.value != "")
			criteria += " and a.PATIENT_ID = '"+parent.frames[1].document.forms[0].patient_id.value+"' "; 
		
		parent.frames[1].document.forms[0].search.disabled = true ;
	
		parent.frames[2].location.href = "../../eOP/jsp/ConcludeEpisodeResult.jsp?where_clause="+escape(criteria);
	
	}

 
 	async function getPatient()
	{
		var patid = await PatientSearch();
		if (patid == null) patid="";
		if (patid != "") parent.frames[1].document.forms[0].patient_id.value = patid;
	}

// JS functions  in conclude episode result..

async function conclude(episodeid,patientid,patient_menu,practname,clinic_desc,service_desc,startDtTm,endDtTm)
	{		
		var retVal =    new String();
		var dialogTop= "100" ;
		var dialogHeight= "250px" ;
		var dialogWidth = "900px" ;
		var status = "no";
		var scroll = "no";
		var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
		var arguments   = "" ;
		retVal = await window.showModalDialog("../../eOP/jsp/ConcludeEpisodeMain.jsp?step=1&Patient="+patientid+"&Episode="+episodeid+"&practname="+encodeURIComponent(practname)+"&clinic_desc="+encodeURIComponent(clinic_desc)+"&service_desc="+service_desc+"&startDtTm="+startDtTm+"&endDtTm="+endDtTm+"&Pat_Details="+encodeURIComponent(patient_menu),arguments,features);
		
		if(retVal != null)
		{
			if(retVal == "success")	
				parent.frames[2].document.location.reload();
		}
	}

async function showpPrevEncounters(episode)
	{
		var retVal =    new String();
		var dialogTop= "180" ;
		var dialogHeight= "350px" ;
		var dialogWidth = "950px" ;
		var status = "no";
		var scroll = "auto";
		var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
		var arguments   = "" ;
		retVal = await window.showModalDialog("../../eOP/jsp/ConcludeEpisodePrevEpisodes.jsp?Episode="+episode,arguments,features);
	}

//JS function used in conclude episode main.

function Okay()
	{

		if(document.forms[0].enddate.value == "")
		{
			document.forms[0].enddate.focus();
			var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
			error = error.replace('$',getLabel('Common.enddatetime.label','Common'));
			alert(error);
		}else if(trimString(document.forms[0].conclude_episode_notes.value)=='') // Monday, April 26, 2010 20930
		 {
				document.forms[0].conclude_episode_notes.focus();
				var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
				error = error.replace('$',getLabel('Common.notes.label','Common'));
				alert(error);
			  }else
			   {
						enddate = document.forms[0].enddate.value;
						//if(enddate!="")
							//enddate=convertDate(enddate,"DMYHM",localeName,"en");

						/*var sysval =  enddate.split(" ")
						var splitdt = sysval[0].split("/")
						var splittm =  sysval[1].split(":")
						var endingdate = 
						splitdt[2]+"-"+splitdt[1]+"-"+splitdt[0]+" "+splittm[0]+":"+splittm[1]+":00.00";
						alert(endingdate);*/
						document.forms[0].end_date.value = enddate;
						
						document.forms[0].submit();
					}
}

function Close_win()
	{
		//parent.window.returnValue="";
		//parent.window.close();
		// Set the return value if necessary
    let dialogBody = parent.parent.document.getElementById('dialog-body');
    if (dialogBody && dialogBody.contentWindow) {
        dialogBody.contentWindow.returnValue = "";
    }

    // Retrieve dialog tags
    const dialogTags = parent.parent.document.querySelectorAll("#dialog_tag");

    // Close each dialog tag if they exist
    dialogTags.forEach(dialogTag => {
        if (typeof dialogTag.close === 'function') {
            dialogTag.close();
        }
    });
	}

	function Clear_vals()
	{
		document.forms[0].reset();
	}

	/*function checkDateTime(obj,sydate)
	{
		if(obj.value !="")
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus()
				alert(getMessage("INVALID_DATE_TIME","SM"));
			}else
			{
				startdate = document.forms[0].start_date.value;
				 var flag=true;             
				
				if(!checkGreaterSysDate(obj.value,sydate))
				{
					flag=false;
					obj.focus()
					alert(getMessage("END_DATTIME_EQ_CURR_DATTIME","OP"));
                    
				}

				if(!checkGreaterSysDate(startdate,obj.value)&&flag==true)
				{
					obj.focus()
					alert(getMessage("END_DATTIME_EQ_START_DATTIME","OP"));
				}
			}
		}
	}*/

	function validateDateTime(obj,sysdate)
	{
		if(obj.value !="")
		{
			/*if(validDate(obj.value,'DMYHM',localeName)==false)
			{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
			{ */
				endDt=convertDate(obj.value,"DMYHM",localeName,"en")
				startdate = document.forms[0].start_date.value;
				var flag=true;
				if(isBeforeNow(obj.value,"DMYHM", localeName)==false)
				{
					flag=false;
					obj.focus()
					alert(getMessage("END_DATTIME_EQ_CURR_DATTIME","OP"));
				} /*Below line localName is changed to en by Rameswar on 01-Oct-15 for Leap Year Issue*/	
				if((isBefore(startdate,endDt,"DMYHM",'en')==false)&&flag==true)
				{
					obj.focus()
					alert(getMessage("END_DATTIME_EQ_START_DATTIME","OP"));
				}
			//}

		}
	}

	function checkMaxSize(Obj)
	{
		if(Obj.value.length > 500)
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED","COMMON");
			error = error.replace("$",getLabel('Common.notes.label','Common'));
			error = error.replace("#","500");
			alert(error)
			Obj.focus();
		}
	}

	/*function checkGreaterSysDate(from, to)
	{
		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =a[0].split("/")
		var splittime1= a[1].split(":")
        
		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
          
		a = to.split(" ")
		splitdate=a[0];
		splittime=a[1]

		splitdate1 =a[0].split("/")
		splittime1= a[1].split(":")

		var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
        if(splitdate1[1] != 0)
		{
			if(Date.parse(to_date) < Date.parse(from_date))
			{ 
				  return false
			}else
				 return true;
		}
		else
			return false;
	}*/

	async function callservice(obj,target){
		var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";	   

   tit=getLabel("Common.service.label",'Common');

   sql ="Select service_code code,short_desc description from am_service_lang_vw where language_id='"+localeName+"' and eff_status='E' and upper(service_code) like upper(?) and upper(short_desc) like upper(?) Order by 2";   
  				
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK;
				argumentArray[7] = DESC_CODE;

				retVal = await CommonLookup( tit, argumentArray );	
				
				if(retVal != null && retVal != "" ) {
	                var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
				    document.forms[0].service.value=arr[0];				
                } else {
					document.forms[0].service.value = "";
					document.forms[0].service1.value = "";					
			    }
	}
