// added from CreatePatientFile.jsp

function run()
{
	
	var pat_id=frames[1].frames[1].document.forms[0].patient_id.value;
	f_query_add_mod.blank.document.location.href='../../servlet/eMR.PatientFileServlet?Patient_Id='+pat_id+'&operation=create_file_no';
}

// added from MajorMedicalEventsAddModify.jsp

function apply()
{

		
	if (parent.frames[2].document.forms[0].event_confirmed_flag.checked== true)
		parent.frames[2].document.forms[0].confirmed.value='Y';
	else
		parent.frames[2].document.forms[0].confirmed.value='N';

	var fields = new Array (
							parent.frames[2].document.forms[0].med_event_type_code,
							parent.frames[2].document.forms[0].event_sdate,
							parent.frames[2].document.forms[0].event_details
							);

	var names = new Array ( 
						   getLabel("Common.EventType.label","Common"),
						   getLabel("Common.EventStartDate.label","Common"),
						   getLabel("Common.EventDetails.label","Common")
						   );
				
	if(parent.frames[2].checkFields( fields, names, parent.parent.messageFrame)) 
	{
		if(doDateChecknew(parent.frames[2].document.forms[0].event_sdate,parent.frames[2].document.forms[0].event_edate,parent.parent.messageFrame))
		{
			parent.frames[2].document.forms[0].submit();
        	parent.frames[2].location.href='../../eMR/jsp/MajorMedicalEventsAddModify.jsp';
			parent.parent.frames[1].location.reload();					
		}
	}
				
}

function aa()
{

}

function doDateChecknew(from,to,messageFrame) 
{
	//var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		/*fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
		*/
		//if(Date.parse(todt) < Date.parse(fromdt))
		var greg_FromDate = convertDate(fromdate,'DMY',localeName,'en');
		var greg_ToDate = convertDate(todate,'DMY',localeName,'en');
		
		var error=getMessage("MRDATE1_GTR_DATE2",'MR');
		error= error.replace('#',getLabel("Common.StartDate.label","Common"));
		error= error.replace('$',getLabel("Common.enddate.label","Common"));

		if(isAfter(greg_FromDate,greg_ToDate,'DMY','en'))
		{
			//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage('TO_DT_GR_EQ_FM_DT','SM');		
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
			return false;
		}
		//else if(Date.parse(todt) >= Date.parse(fromdt)) 
		else if(isBefore(greg_FromDate,greg_ToDate,'DMY','en')) 
			return true;
	}	
	
	return true;
}

function clearme()
{
	var pat=parent.frames[2].document.forms[0].patient_id.value;
	parent.frames[2].location.href='../../eMR/jsp/MajorMedicalEventsAddModify.jsp?Patient_Id='+pat;
}

function DateValidation(obj)
{
	curdate = document.forms[0].cur_date;
	var msg = getMessage("FROM_DATE_LESS_SYSDATE",'SM');
	if(doDateCheckAlert(curdate,obj) == false	 ) 
	{
		obj.focus();
		obj.select();
		alert(msg);
	}
}

function chkMaxLen(Obj)
{
	if(Obj.value.length > 2000)
	{
		alert(getMessage('CANT_XCEED_2000_CHARS','MR'));
		Obj.focus();
	}
}

function defaultValuePop(valueToDflt)
{
	if(valueToDflt=='start')
	{
		document.forms[0].start_select.value='';
		document.forms[0].event_sdate.value='';
	}
	else
	{
		document.forms[0].end_select.value='';
		document.forms[0].event_edate.value='';
	}
}

// added from MajorMedicalEventsQueryResult.jsp

async function displayDetails(val)
{
	var url		= "GetComments.jsp";
	var dialogTop	= "140";
	var dialogHeight= "110px" ; 
	var dialogWidth	= "400px" ;	
	var dialogLeft	= "300" ;
	var arguments	= val.value ;
	if(arguments == null) arguments="";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no; dialogLeft: "+dialogLeft ;
	var returnval = await window.showModalDialog( url, arguments, features ) ;	
}

// added from RecordPatMedEvents.jsp
function query() 
{
	f_query_add_mod.location.href ="../../eMR/jsp/mrblank.jsp?step_1=7";
}

// added from OtherMedicalInfoAddModify.jsp
function apply1()
{
	var fields = new Array (
							parent.frames[2].document.forms[0].ref_no,
							parent.frames[2].document.forms[0].ref_date,
							parent.frames[2].document.forms[0].category,
							parent.frames[2].document.forms[0].remarks
							);

	var names = new Array (
							getLabel("Common.referenceno.label","Common"),
							getLabel("Common.date.label","Common"),
							getLabel("Common.category1.label","Common"),
							getLabel("Common.remarks.label","Common")
							);
	if(parent.frames[2].checkFields( fields, names, parent.parent.messageFrame))
	{
		
		parent.frames[2].document.forms[0].action="../../servlet/eMR.OtherMedicalInfoServlet";
		parent.frames[2].document.forms[0].submit();
	
		setTimeout('aa1()',1000)
		
	}

}
function aa1()
{
	parent.frames[1].location.reload()
	parent.frames[2].location.reload()
}

function clearme1()
{
		var pat=parent.frames[2].document.forms[0].patient_id.value;
		parent.frames[2].location.href='../../eMR/jsp/OtherMedicalInfoAddModify.jsp?Patient_Id='+pat;
	}

function CheckRefDate(obj)
{
	
	//if(obj.value.length>0)
	//{
		if(!validDateObj(obj,'DMY',localeName))
		{
			return false;
		}
		else
		//if(CheckDate(obj))
		{
			var greg_RefDate = convertDate(obj.value,'DMY',localeName,'en');
			var Dob_Date = convertDate(document.forms[0].dob.value,'DMY',localeName,'en');
			/*if(!doDateCheck1(document.forms[0].dob,obj))
			{
				var msg = getMessage("REF_DATE_GREATER_DOB",'MR');
				alert(msg);
				obj.select();
				obj.focus();
			}*/
			if(isBefore(greg_RefDate,document.forms[0].dob.value,'DMY','en'))  
			{
				if(greg_RefDate != Dob_Date)
				{
					var msg = getMessage("REF_DATE_GREATER_DOB",'MR');
					alert(msg);
					//obj.select();
					//obj.focus();
					obj.value="";
					return false;
				}
			}
			/*if(!doDateCheck1(obj,document.forms[0].cur_date))
			{
					var msg = getMessage("REF_DATE_LESS_SYSDATE",'MR');
					alert(msg);
					obj.select();
					obj.focus();
			}*/

			else if(!isBeforeNow(greg_RefDate,'DMY','en'))
			{
				var msg = getMessage("REF_DATE_LESS_SYSDATE",'MR');
				alert(msg);
				//obj.select();
				//obj.focus();
				obj.value="";
				return false;
			}
			else
				return true;
		}

}
		
function doDateCheck1(from,to,messageFrame,val)
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 )
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt))
		{
			if(val=="1")
			{
				alert( getMessage("INVALID_FROM_DT",'SM' ));
				to.select();
				to.focus();
			}
			else if(val=="2")
			{
				alert( getMessage('INVALID_TO_DT','SM') );
				from.select();
				from.focus();
			}
			else if(val=="3")
			{
				alert( getMessage('TO_DT_GR_EQ_FM_DT','SM') );
				to.select();
				to.focus();
			}
			else if(val=="4")
			{
				alert( getMessage("FROM_DATE_LESS_SYSDATE",'SM' ));
				to.select();
				to.focus();
			}

			return false;
		}
	}
	else if(Date.parse(todt) >= Date.parse(fromdt))
	{
		return true;
	}
	return true;
}

function chkMax(Obj)
{
	if(Obj.value.length >2000)
	{
		alert(getMessage('REMARKS_XCEED_2000_CHARS','MR'));
		Obj.focus();
	}
}


// added from OtherMedicalInfoQueryResult.jsp
async function displayDetails1(val)
{
	var url		= "GetComments.jsp";
	var dialogTop	= "140";
	var dialogHeight= "150px" ; 
	var dialogWidth	= "400px" ;	
	var dialogLeft	= "300" ;
	var arguments	= val.value ;
	
	if(arguments == null) 
		arguments="";
	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no; dialogLeft: "+dialogLeft ;
	var returnval = await window.showModalDialog( url, arguments, features ) ;	
}

// added from MaintainDeathRegister.jsp


function reset()
{
	parent.content.f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[1].document.forms[0].search.disabled = false;
	parent.frames[2].location.reload();
	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[3].location.href = "../../eCommon/html/blank.html";
}

function check_date_to_from(obj)
{
	var t1 = CheckDate(obj);		
	if(!t1){obj.value=""; obj.focus();return;}
}
	
function compareDates(obj,sysdate)
{
	if(obj != "")
	{
		if(validDateObj(obj,"DMY",localeName))
		{
			var objDt	= convertDate(obj.value,"DMY",localeName,"en");
			//if(!isAfter(sysdate.value,objDt,'DMY',localeName))
			if(!isBeforeNow(objDt,'DMY','en'))
			{
				
				error=getMessage("MRDATE1_GT_DATE2","MR");
				if(obj.name=='p_adm_from_date' || obj.name=='p_adm_to_date' )
					error= error.replace('$',getLabel("Common.admissiondate.label","Common"));
				else if(obj.name=='p_deceased_from_date' || obj.name=='p_deceased_to_date' )
					error= error.replace('$',getLabel("Common.DeceasedDate.label","Common"));
				else
					error= error.replace('$',getLabel("Common.dischargedate.label","Common"));
				error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
				alert(error);
				obj.value=''; 	
				obj.select();
				obj.focus();
			}
		}
		else
			obj.value='';

	}
}

function compareDates1(admdate,dischargeDate)
{
	
	//if(admdate.value != "" && validDateObj(obj,"DMY",localeName))
	if(admdate.value != "" &&dischargeDate.value!="")
	{
		greg_admdate = convertDate(admdate.value,"DMY",localeName,"en");
		greg_dischargedat	 = convertDate(dischargeDate.value,"DMY",localeName,"en");

		//if(!isAfter(greg_admdate,greg_dat,'DMY',localeName))
		if(!isAfter(greg_dischargedat,greg_admdate,'DMY','en'))
		//if(isBefore(greg_dischargedat,greg_admdate,'DMY','en'))
		{		
			var error=getMessage("MRDATE1_LT_DATE2",'MR');
			error= error.replace('$',getLabel("Common.dischargedate.label","Common"));
			error= error.replace('#',getLabel("Common.admissiondate.label","Common"));
			alert(error);
			dischargeDate.select();
			dischargeDate.focus();
		}
	}
}

function compareDates2(fromdate, todate)
{
	if(fromdate.value != "" && todate.value!="")
	{
		var greg_fromdate		= convertDate(fromdate.value,"DMY",localeName,"en");
		var greg_todate			= convertDate(todate.value,"DMY",localeName,"en");

		if(!isAfter(greg_todate,greg_fromdate,'DMY','en'))
		//if(isBefore(greg_todate,greg_fromdate,'DMY','en'))
		{		
			var error=getMessage("MRDATE1_LT_DATE2",'MR');
			error= error.replace('$',getLabel("Common.todate.label","Common"));
			error= error.replace('#',getLabel("Common.fromdate.label","Common"));
			alert(error);
			todate.select();
			todate.focus();
		}
	}
}

// added from  DeathRegisterCriteria.jsp

function clearAll1()
{
	document.forms[0].search.disabled = false;
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';				
	parent.frames[3].document.location.href ='../../eCommon/html/blank.html';				
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}

async function callSearchScreen()
{
	var patientid= await PatientSearch('','','','','','','Y','','','VIEW');
	
	if(patientid !=null)
		document.forms[0].p_patient_id.value = patientid;

	document.forms[0].p_patient_id.focus();
}

function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

async function submitPage()
{
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	parent.f_query_add_mod1.location.href = "../../eCommon/html/blank.html";

	var adm_from_date		= document.forms[0].p_adm_from_date.value;
	var adm_to_date			= document.forms[0].p_adm_to_date.value;
	var discharge_from_date = document.forms[0].p_discharge_from_date.value;
	var discharge_to_date	= document.forms[0].p_discharge_to_date.value; 
	var deceased_from_date	= document.forms[0].p_deceased_from_date.value; 
	var deceased_to_date	= document.forms[0].p_deceased_to_date.value; 
	var status	= document.forms[0].status.value; 
	
	var continue_yn = "Y";

	if(adm_from_date=='' && adm_to_date=='' && discharge_from_date=='' && discharge_to_date=='')
	{
		continue_yn = "N";
		var msg = getMessage("ADM_OR_DEATH_PERIOD","MR");
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;		
		return;
	}

	if(discharge_from_date != '' && discharge_to_date == "" )
	{
		continue_yn = "N";
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("eMR.DischPeriod.label","MR") + " " +getLabel("Common.to.label","Common"));
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
		return;
	}
	else if(discharge_from_date == '' && discharge_to_date != "" )
	{
		continue_yn = "N";
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("eMR.DischPeriod.label","MR") + " " +getLabel("Common.from.label","Common"));
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
		return;
	}

	if(adm_from_date != '' && adm_to_date == "")
	{
		
		continue_yn = "N";
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("eIP.Admissions.label","IP") + " " +getLabel("Common.Period.label","Common")+ " "+getLabel("Common.to.label","Common"));
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;	

		return;
	}
	else if(adm_from_date == '' && adm_to_date != "")
	{
		
		continue_yn = "N";
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("eIP.Admissions.label","IP") + " " +getLabel("Common.Period.label","Common")+ " "+getLabel("Common.from.label","Common"));
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
		return;
	}

	
	if(continue_yn == "Y")
	{
	
		document.forms[0].search.disabled = true;
		//parent.frames[2].location.href= '../../eMR/jsp/DeathRegisterResult.jsp?PatientId='+document.forms[0].p_patient_id.value+'&EncounterId='+document.forms[0].p_encounter_id.value+'&AdmissionDate='+document.forms[0].p_adm_date.value+'&DischargeDate='+document.forms[0].p_discharge_date.value;
		//parent.frames[2].location.href= '../../eMR/jsp/DeathRegisterResult.jsp?PatientId='+document.forms[0].p_patient_id.value+'&EncounterId='+document.forms[0].p_encounter_id.value+'&AdmissionDate='+convertDate(document.forms[0].p_adm_date.value,"DMY",localeName,"en")+'&DischargeDate='+convertDate(document.forms[0].p_discharge_date.value,"DMY",localeName,"en");
		
		var greg_adm_from_date			= "";
		var greg_adm_to_date			= "";
		var greg_discharge_from_date	= "";
		var greg_discharge_to_date		= "";
		var greg_deceased_from_date		= "";
		var greg_deceased_to_date		= "";


		if(adm_from_date!='')
		 greg_adm_from_date			= convertDate(document.forms[0].p_adm_from_date.value,"DMY",localeName,"en") ;
		if(adm_to_date!='')
		 greg_adm_to_date			= convertDate(document.forms[0].p_adm_to_date.value,"DMY",localeName,"en") ;
		if(discharge_from_date!='')
		 greg_discharge_from_date	= convertDate(document.forms[0].p_discharge_from_date.value,"DMY",localeName,"en") ;
		if(discharge_to_date!='')
		 greg_discharge_to_date		= convertDate(document.forms[0].p_discharge_to_date.value,"DMY",localeName,"en") ;

		if(deceased_from_date!='')
		 greg_deceased_from_date		= convertDate(document.forms[0].p_deceased_from_date.value,"DMY",localeName,"en") ;
		if(deceased_to_date!='')
		 greg_deceased_to_date		= convertDate(document.forms[0].p_deceased_to_date.value,"DMY",localeName,"en") ;



		
		parent.frames[2].location.href= '../../eMR/jsp/DeathRegisterResult.jsp?PatientId='+document.forms[0].p_patient_id.value+'&EncounterId='+document.forms[0].p_encounter_id.value+'&admission_from_date='+greg_adm_from_date+'&admission_to_date='+greg_adm_to_date+'&discharge_from_date='+greg_discharge_from_date+'&discharge_to_date='+greg_discharge_to_date+'&deceased_from_date='+greg_deceased_from_date+'&deceased_to_date='+greg_deceased_to_date+'&status='+status;

		parent.frames[3].location.href= '../../eMR/jsp/DeathRegisterColourInd.jsp';
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}

}

// added from  addModifyDeathRegistration.jsp
function chkDateTime(obj) 
{
	if (!ValidateDateTime(obj, document.forms[0].sysdatetime))
	{
		var error=getMessage("MRDATE1_GT_DATE2",'MR');
		error= error.replace('$',getLabel("Common.DeceasedDate.label","Common"));
		error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
		obj.select();obj.focus()
		return false;
	}
	if (!ValidateDateTime(obj, document.forms[0].actualdeathdatetime))
	{
		var error=getMessage("MRDATE1_GT_DATE2",'MR');
		error= error.replace('$',getLabel("Common.DeceasedDate.label","Common"));
		error= error.replace('#',getLabel("Common.dischargedate.label","Common"));
		obj.select();obj.focus()
		return false;
	}
	if (ValidateDateTime(obj, document.forms[0].AdmDatetime)) 
	{
		var error=getMessage("MRDATE1_LT_DATE2",'MR');
		error= error.replace('$',getLabel("Common.DeceasedDate.label","Common"));
		error= error.replace('#',getLabel("Common.admissiondate.label","Common"));
		obj.select();obj.focus()
		return false;
	}
	return true;
}

function getPractIDblur(target,target_id)
{
	if(document.forms[0].practid_desc.value !='')
		getPractID(target,target_id);
	else
		document.forms[0].practid.value='';
}

async function getPractID(target,target_id)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//	dataNameArray[0] = "eff_status" ;
	//	dataValueArray[0] = "E";
	//	dataTypeArray[0] = STRING ;
		
	var facility_id="";
	var spl_code			= document.forms[0].specialty_code.value;
	var msg="";
	facility_id				=document.forms[0].facilityId.value;
	var practid_desc = document.forms[0].practid_desc.value;
	if(spl_code != "")
	{
		sql="select practitioner_id code , practitioner_name description from am_pract_all_splty_vw where facility_id ='"+facility_id+"' and primary_speciality_code ='"+spl_code+"' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?)"; 
		argumentArray[0] =sql;
		argumentArray[1] =dataNameArray ;
		argumentArray[2] =dataValueArray ;
		argumentArray[3] =dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] =target.value;
		argumentArray[6] =DESC_LINK ;
		argumentArray[7] =DESC_CODE  ;

		var retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );
	
		if(retVal != null && retVal != "" )  
		{
 			target_id.value = retVal[0] ; /* if code need to be returned */
	 		target.value = retVal[1] ; /* if desc need to be returned */
			target.focus();
		}
		else
		{
			target_id.value ='';
			target.value='';
			target.focus();
		}
	}

}			

// added from recordDiag.jsp

function apply2()
{		
	var death_date_time = parent.frames[0].document.forms[0].death_date_time.value;
	if(death_date_time=="")
	{
		var err = getMessage("CAN_NOT_BE_BLANK",'Common');
		err= err.replace("$",getLabel("Common.deathdatetime.label","Common"));
		alert(err);
	}
	else
	{
		var list_row_count = parent.frames[1].frames[1].document.forms[0].row_count.value;
		if(list_row_count=="") 
			list_row_count="1";
		if(parseInt(list_row_count) - 1<=0)
		{
			alert(getMessage("ATLEAST_ONE_SELECTED",'Common'));
			return;
		}
		var practid = parent.frames[0].document.forms[0].practid.value;
		var remarks = parent.frames[0].document.forms[0].remarks.value;
		var death_by_pregnancy_yn = "";
		var medical_legal_case_yn = "";
		var autopsy_yn = "";
		var cur_death_date_time = parent.frames[1].frames[1].document.forms[0].death_date_time;
		var cur_practid = parent.frames[1].frames[1].document.forms[0].practid;
		var cur_remarks = parent.frames[1].frames[1].document.forms[0].remarks;
		
		cur_death_date_time.value = death_date_time;
		cur_practid.value = practid;
		cur_remarks.value = remarks;
		
		var modeInList = parent.frames[1].frames[1].document.forms[0].mode;
		modeInList.value = "Add";
		
		var ret;
		
		
		if (window.confirm(getLabel("Common.Finalize.label","Common")+"?")==true) 
			ret="Yes";
		else 
			ret="No";
		
		if (ret == "Yes") 
		{
			var list_cur_obj = parent.frames[1].frames[1].document.forms[0].finalize_yn;
			list_cur_obj.value = "Y";	
		}
		else
		{
			var list_cur_obj = parent.frames[1].frames[1].document.forms[0].finalize_yn;
			list_cur_obj.value = "N";		
		}
			
		parent.frames[1].frames[1].document.forms[0].action = '../../servlet/eMR.DeathRegistrationServlet';
		parent.frames[1].frames[1].document.forms[0].method = 'post';
		parent.frames[1].frames[1].document.forms[0].target = parent.frames[3].name;
		parent.frames[1].frames[1].document.forms[0].submit();
		
	}
	
}

function cancelPage()
{
	window.parent.close();
}


// added from addDiagnosis.jsp


async function show_window()
{
   var s = document.forms[0].diag_code_scheme.value;
   scheme_desc= document.forms[0].diag_scheme.value 
   var practitioner_id= document.forms[0].practitioner_id.value 
   var  p_auth_yn="N";
	
   if(document.forms[0].authorize!=null)
	{
	     
	   if(document.forms[0].Normal_Mode!=null)
			p_auth_yn='Y';
	}
	if (s == 1 || s == 2)
	{
		var retVal		= new String();
		var dialogHeight= "27.22vh" ;
		var dialogWidth = "44vw" ;
		var status		= "no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;		
		var cause_ind='';
		
		if(scheme=="2")
			 cause_ind=document.forms[0].cause_indicator.value;		
		retVal = await window.showModalDialog("../../eMR/jsp/PaintConsultationFrame.jsp?p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&p_auth_yn="+p_auth_yn+"&practitioner_id="+practitioner_id+"&cause_indicator="+cause_ind,arguments,features);
		
		if (!(retVal == null))
		{
			var retdata;
			if(scheme=="2")
			{
				retdata=retVal.split("/") ;
				retVal=retdata[0];
				if(retdata[1]==document.forms[0].cause_indicator.options[1].value)
					document.forms[0].cause_indicator.options[1].selected=true;
			}
			document.forms[0].diag_code.value=retVal;
		}
		document.forms[0].diag_code.focus();
		document.forms[0].diag_code.select();
	}
}

function submitPage1()
{		
		
		var diag_code = document.forms[0].diag_code;
		var diag_type = document.forms[0].diag_type;
		var diag_desc = document.forms[0].diag_desc;
		var record_type = document.forms[0].record_type;
		var cause_indicator = document.forms[0].cause_indicator;
		var remarks	= document.forms[0].pr_remarks;

		if(trimCheck(diag_code.value)=="") 
		{
			error = getMessage("CAN_NOT_BE_BLANK",'Common');
			error= error.replace("$",getLabel("Common.DiagnosisCode.label","Common"));
			alert(error);
			diag_code.select();
			diag_code.focus();
			return false;
		}
		else if(trimCheck(diag_desc.value)=="") 
		{
			error = getMessage("CAN_NOT_BE_BLANK",'Common');
			error= error.replace("$",getLabel("Common.DiagnosisDescription.label","Common"));
			alert(error);
			diag_code.select();
			diag_code.focus();
			return false;
		}
		else
		{
			var modeInDetail = document.forms[0].mode.value;
			var modeInList = parent.frames[1].document.forms[0].mode;
			var rowCount = parent.frames[1].document.forms[0].row_count;
			var list_row_count = parent.frames[1].document.forms[0].row_count.value;
			if(list_row_count=="") list_row_count="1";
			var row_count = "";

		
			if(modeInDetail=="Add")
			{
				modeInList.value = "Add";
				row_count = parseInt(list_row_count) - 1;
			}
			else if(modeInDetail=="Modify")
			{
				modeInList.value =  "Modify";
				var row_id = document.forms[0].row_id.value;
				
				if(row_id=="") 
					row_id ="0";
				
				row_count = parseInt(row_id);
				rowCount.value = parseInt(list_row_count) - 1;
			}

		
			var list_diag_code = parent.frames[1].document.forms[0]['diag_code' + row_count];
			var list_diag_type = parent.frames[1].document.forms[0]['diag_type' + row_count].value;
				var list_diag_desc = parent.frames[1].document.forms[0]['diag_desc' + row_count].value;
				var list_record_type = parent.frames[1].document.forms[0]['record_type' + row_count].value;
				var list_cause_indicator = parent.frames[1].document.forms[0]['cause_indicator' + row_count].value;
				var list_remarks = parent.frames[1].document.forms[0]['remarks' + row_count].value;
				var list_update_problem = parent.frames[1].document.forms[0]['update_problem' + row_count].value;
		
			list_diag_code.value = diag_code.value;
			list_diag_type.value = diag_type.value;
			list_diag_desc.value = diag_desc.value;
			list_record_type.value	= record_type.value;
			list_cause_indicator.value = cause_indicator.value;
			list_remarks.value = remarks.value;
			
			if(modeInDetail=="Add")
				list_update_problem.value = "N";

			parent.frames[1].document.forms[0].action = '../../eMR/jsp/addModifyDiag.jsp';
			parent.frames[1].document.forms[0].method = 'post';
			parent.frames[1].document.forms[0].target = parent.frames[1].name;
			parent.frames[1].document.forms[0].submit();
			
			parent.frames[1].document.forms[0].mode.value = "Add";			
			document.forms[0].diag_code.readOnly = false;

			if (document.forms[0].diag_code_scheme.value=="2")
				document.forms[0].cause_indicator.disabled = false;

			document.forms[0].search_button.disabled = false;
			document.forms[0].Add.value = getLabel("Common.Add.label","Common");
			document.forms[0].reset();
			document.forms[0].diag_type.focus();
		}
}



function cancelPage1()
{
	
	var modeInDetail = document.forms[0].mode.value;
	var modeInList = parent.frames[1].document.forms[0].mode;
	
	if(modeInDetail=="Modify")
	{
		
		document.forms[0].Add.value = getLabel("Common.Add.label","Common");
		parent.frames[1].document.forms[0].mode.value = "Add";
		document.forms[0].diag_code.readOnly = false;
		
		if (document.forms[0].diag_code_scheme.value=="2")
			  document.forms[0].cause_indicator.disabled = false;
		
		document.forms[0].search_button.disabled = false;
	}
	/*if (document.forms[0].Add.value == getLabel("Common.Modify.label","Common"))
	{    
		document.forms[0].Add.value = getLabel("Common.Add.label","Common");
		parent.frames[1].document.forms[0].mode.value = "Add";
		document.forms[0].diag_code.readOnly = false;
		
		if (document.forms[0].diag_code_scheme.value=="2")
			  document.forms[0].cause_indicator.disabled = false;
		
		document.forms[0].search_button.disabled = false;
	}*/
	document.forms[0].reset();
	document.forms[0].diag_type.focus();
}


async function chkAuthorize(Obj)
{
	
	
	
	if (Obj.id == 'Authorize_Mode')
	{
		
		var retVal = 	new String();
		var dialogHeight= "9vh" ;
		var dialogWidth	= "25vw" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments	= "" ;
		retVal =await  window.showModalDialog("../../eMR/jsp/Authorize.jsp",arguments,features);
		
		if (retVal!=null &&retVal=="T")
			this.location.href="../../eMR/jsp/addDiagnosis.jsp?f_authorize_yn=Y";
	
	}
	else if (Obj.id == 'Normal_Mode')
		parent.frames[0].location.href="../../eMR/jsp/addDiagnosis.jsp?f_authorize_yn=N";
}

//added on 23/08/2004 for facilitating input of '.' in Code text field the existing function was CheckForSpecChars(event)
function valid_ch(event)
{
	var strCheck = '0123456789.+-*abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

// added from addModifyDiag.jsp
  
function showDetail(row_id)
{	
	
	var list_diag_type = eval("document.forms[0].diag_type"+row_id);
	var list_diag_code = eval("document.forms[0].diag_code"+row_id);
	var list_record_type = eval("document.forms[0].record_type"+row_id);
	var list_cause_indicator =  eval("document.forms[0].cause_indicator"+row_id);
	var list_diag_desc = eval("document.forms[0].diag_desc"+row_id);
	var list_remarks = eval("document.forms[0].remarks"+row_id);

	if (list_diag_type.value!=null&&list_diag_type.value!="") 
	{
		parent.frames[0].document.forms[0].diag_type.value = list_diag_type.value
	}
	
	parent.frames[0].document.forms[0].diag_code.value = list_diag_code.value
	parent.frames[0].document.forms[0].record_type.value = list_record_type.value
	
	if (list_cause_indicator.value!=null&&list_cause_indicator.value!="") 
	{
		parent.frames[0].document.forms[0].cause_indicator.value = list_cause_indicator.value
	}
	
	parent.frames[0].document.forms[0].diag_desc.value = list_diag_desc.value
	parent.frames[0].document.forms[0].pr_remarks.value = list_remarks.value
	parent.frames[0].document.forms[0].diag_code.readOnly = true;
	
	if (parent.frames[1].document.forms[0].diag_code_scheme.value=="2") 
	{
		parent.frames[0].document.forms[0].cause_indicator.disabled = true;
	}
	
	parent.frames[0].document.forms[0].search_button.disabled=true;
	parent.frames[0].document.forms[0].Add.value =  getLabel("Common.Modify.label","Common");	
	parent.frames[0].document.forms[0].mode.value =  "Modify";
	parent.frames[0].document.forms[0].row_id.value = row_id;
}


//  added from Authorize.jsp


function chkpasswd() 
{
	var p1 = document.forms[0].sen_diag.value;
	var p2 = document.forms[0].screen_passwd.value;

	if (p1 != p2)
		alert(getMessage("PWD_MISMATCH",'SM'));
	else
	{
		top.window.returnValue = "T" ;
		top.window.close();
	}
}


function closeAuthorization()
{
	top.window.returnValue = "F";
	top.window.close();
}

function checkDeceasedDate(obj)
{
	if(validDateObj(obj,"DMYHM",localeName))
	{
		var adm_date		= document.forms[0].adm_date.value;
		var discharge_date	= document.forms[0].discharge_date.value;
		
		if(isAfterNow(obj.value,'DMYHM',localeName))
		{
			var msg = getMessage("MRDATE1_GT_DATE2","MR");
			msg		= msg.replace("$",getLabel("Common.deceaseddatetime.label","Common"));
			msg		= msg.replace("#",getLabel("Common.CurrentDateTime.label","Common"));
			alert(msg);
			obj.select();
			return false;
		}
		if(isBefore(obj.value,adm_date,'DMYHM',localeName))
		{
			var msg = getMessage("MRDATE1_LT_DATE2","MR");
			msg		= msg.replace("$",getLabel("Common.deceaseddatetime.label","Common"));
			msg		= msg.replace("#",getLabel("Common.AdmissionDateTime.label","Common"));
			alert(msg);
			obj.select();
			return false;
		}
		if(isAfter(obj.value,discharge_date,'DMYHM',localeName))
		{
			var msg = getMessage("MRDATE1_GT_DATE2","MR");
			msg		= msg.replace("$",getLabel("Common.deceaseddatetime.label","Common"));
			msg		= msg.replace("#",getLabel("Common.dischargedatetime.label","Common"));
			alert(msg);
			obj.select();
			return false;
		}
		return true;
	}
	else
		return false;
}

function apply3()
{		
	

	var fields = new Array (
							parent.frames[0].document.forms[0].deceased_date_time,
							parent.frames[0].document.forms[0].auth_pract
							);

	var names = new Array ( 
						   getLabel("Common.deathdatetime.label","Common"),
						   getLabel("Common.AuthorizingPractitioner.label","Common")
						   );
				
	if(parent.frames[2].checkFields( fields, names, parent.parent.messageFrame)) 
	{
		parent.frames[0].document.forms[0].action = '../../servlet/eMR.MaintainDeathRegisterServlet';
		parent.frames[0].document.forms[0].method = 'post';
		parent.frames[0].document.forms[0].target = parent.frames[2].name;
		parent.frames[0].document.forms[0].submit();
		
    }	
}

function checkMaxLimitOfRemark(obj)
{
	if ( obj.value.length > 200 )
	{
		var msg = getMessage("REMARKS_XCEED_2000_CHARS","MR");
		msg = msg.replace('2000','200');
		alert(msg);
		obj.select();
		return false;
	}
	else
		return true;
	
}


function PractLookupRetVal(retVal,objName)
{
	var arr;
	
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName=='auth_pract')
		{
			document.forms[0].auth_pract_id.value=arr[0];
			document.forms[0].auth_pract.value=arr[1];

		}		

	}
	else
	{
		if(objName=='auth_pract'){
		
			document.forms[0].auth_pract_id.value="";
			document.forms[0].auth_pract.value="";
		}
	}
	
}

function BeforeGetPractID1(obj1,obj2)
{
	if(document.forms[0].auth_pract.value!="")
		getPractitioner(obj1,obj2,'','Q6');	
}

function onSuccess()
{
}



