/*
	@ MODULE		:	InPatient Management..(IP)
	@ Function Name	:	InPatientLookupQuery Criteria & Result
	@ Developer		:	Ranjani
	@ Created on	:	2/23/2005
*/

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// The Foll Functions will be called from InpatientLookupCriteria.jsp
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function checkForMPRequest()
{
	if (document.forms[0].targetURL.value != "" || document.forms[0].call_function.value=='BabyLinktoMother')
	{
		document.forms[0].gender.value = "F";
		document.forms[0].gender.disabled = "true";
	}
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Added by Sridhar on 2 FEB 2004
// These Function's will check for empty values before calling up the common lookup func..
function BeforeGetNursingUnit(obj1,obj2,obj3)
{
	if(obj3 == 'from')
	{
		if(document.forms[0].from_nursing_unit_desc.value != "")
			getNursingUnitValue(obj1,obj2,obj3);
		else
			document.forms[0].from_nursing_unit.value = "";
	}
	else
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			getNursingUnitValue(obj1,obj2,obj3);
		else
			document.forms[0].nursing_unit.value = "";
	}
}


function BeforeGetSpecialtyValue(obj1,obj2,obj3)
{
	if(obj3 == 'from')
	{
		if(document.forms[0].from_specialty_desc.value != "")
			getSpecialtyValue(obj1,obj2,obj3);
		else
			document.forms[0].from_Splcode.value = "";
	}
	else
	{
		if(document.forms[0].specialty_desc.value != "")
			getSpecialtyValue(obj1,obj2,obj3);
		else
			document.forms[0].Splcode.value = "";
	}
}
	
function BeforeGetServiceValue(obj1,obj2)
{
	if(document.forms[0].Service_desc.value != "")
		getDescriptions(obj1,obj2,'S');
	else
		document.forms[0].ServiceCode.value = "";
}

	function BeforeGetSubServiceValue(obj1,obj2)
{
	if(document.forms[0].SubService_desc.value != "")
		getDescriptions(obj1,obj2,'SS');
	else
		document.forms[0].SubServiceCode.value = "";
}


async function getDescriptions(aCode, getFacilitID, details)
{	
	var facility_id		= getFacilitID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var locale			= document.forms[0].locale.value;
	var sql				= "";
	var tit				= "";
	if(details == 'S')
	{
		sql = " Select SERVICE_CODE code,short_desc description from AM_SERVICE_LANG_VW where eff_status like 'E' and upper(SERVICE_CODE) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";
		tit = getLabel("Common.service.label","Common");

	}
	else if(details == 'SS')
	{
		sql = " Select SUBSERVICE_CODE code,short_desc description from AM_SUBSERVICE_LANG_VW where eff_status like 'E' and upper(SUBSERVICE_CODE) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";
		tit = getLabel("Common.subservice.label","Common");
	}
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = aCode.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");

		if(details == 'S')
		{
			document.forms[0].ServiceCode.value=arr[0];
			document.forms[0].Service_desc.value=arr[1];

		}
		else if(details == 'SS')
		{
			document.forms[0].SubServiceCode.value=arr[0];
			document.forms[0].SubService_desc.value=arr[1];
		}

	}
	else
	{
		if(details == 'S')
		{
			document.forms[0].ServiceCode.value = "";
			document.forms[0].Service_desc.value = "";
		}
		else if(details == 'SS')
		{
			document.forms[0].SubServiceCode.value = "";
			document.forms[0].SubService_desc.value = "";
		}
	}
} 
 
function compareDates()
{
	var from = document.forms[0].from_date;
	var to = document.forms[0].to_date;
	
	if(from.value !='' && to.value !='')// DateUtils.js
	{
		if(validDate(from.value,"DMY",localeName) && validDate(to.value,"DMY",localeName))
		{
			var fromDt	= convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
			var toDt	= convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");
			
          
			if(!isBefore(fromDt,toDt,'DMY',"en"))// DateUtils.js
			{   
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.value="";
				document.forms[0].to_date.select();
				document.forms[0].to_date.focus();
			}
		}
	}
}


function DateCompare(from,to) 
{
	if(validDateObj(from,"DMY", localeName)) // DateUtils.js
	{
		if(validDateObj(to,"DMY", localeName)) // DateUtils.js
		{
			var fromDt	= convertDate(from.value,"DMY",localeName,"en");
			var toDt	= convertDate(to.value,"DMY",localeName,"en");

			if(isAfter(fromDt,toDt,'DMY',localeName))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.select();
				return false;
			}
		}
	}
}


function focusto_date()
{
	document.forms[0].to_date.focus();
}

function focusfrom_date()
{
	document.forms[0].from_date.focus();
}


function enableDisableDays(Obj)
{
	if(Obj.checked)
	{
		document.forms[0].no_of_days.readOnly = false;
		document.forms[0].include_yn.value = "Y";
		document.getElementById("daysImg").style.visibility = "visible";
	}
	else
	{
		document.forms[0].no_of_days.value = "";
		document.forms[0].include_yn.value = "N";
		document.forms[0].no_of_days.readOnly = true;
		document.getElementById("daysImg").style.visibility = "hidden";
	}
}


function LodgerDateCompare(curr,messageFrame)
{
	var curr_date = curr.value ;
	var check_in_date = document.forms[0].chk_in_lodger_min_date.value;
	
	
	if(curr_date.length > 0 && check_in_date.length > 0) 
	{
		if(validDate(curr_date,"DMY",localeName))
		{
			var greg_curr_date	= convertDate(curr_date,"DMY",localeName,"en");
			if(!isBeforeNow(greg_curr_date,'DMY','en'))
			{
				// 17879 Wednesday, January 06, 2010 VenkatS (to and from date validation)
				var msg = getMessage("FRM_DT_LESS_CURRT_DT","IP");
				msg = msg.replace('$',getLabel("eIP.DischargeDateFrom.label","IP") );
				msg = msg.replace('#',getLabel("Common.SystemDate.label","Common") );
				alert(msg);				
				curr.value ="";
				return false;
			}
			else if(!isAfter(greg_curr_date,check_in_date,"DMY","en"))
			{
				var msg = getMessage("CANNOT_BE_LT_P_VALUE","IP");
				msg = msg.replace('$',getLabel("eIP.DischargeDateFrom.label","IP") );
				alert(msg);				
				curr.value="";
				return false;
			}

		}	
	}
}



function validSplchars1(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Encounter ID";
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

// By Annadurai 2/5/2004., starts.....
// To get the nursing unit using common lookup.
async function getNursingUnitValue(aNursingUnit, getFacilitID, details)
{	
	var msg					= "";
	var nursingUnitCode		= aNursingUnit.value;
	var facility_id			= getFacilitID;
	var loginUser			= document.forms[0].loginUser.value;
	var operstn				= document.forms[0].operstn.value;
	var retVal				= new String();
	var sql					= "";
	var tit					= "";
	var wherecondn			= document.forms[0].wherecondn.value;
	var retVal				= new String();
	var call_function		= document.forms[0].call_function.value;
	var tit					= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight        = "600px" ;
    var dialogWidth         = "950px"; 
	/*var dialogHeight		= "28" ;
	var dialogWidth			= "43" ;*/
	var status				= "no";
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();

	var jsp_name = "";
	if(call_function == 'TransferPatientOut'  || call_function == 'CancelTransferPatientOut')
	{
		if(details == 'from')
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode);
		}
		else
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&open_location_yn=Y";
		}
	}
	else
	{
		if(details == 'from')
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&open_location_yn=Y";
		}
		else
		{
			
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode);
		}

	}


	var retVal =  await  window.showModalDialog(jsp_name,arguments,features);
	var arr=new Array();
	
	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");

		if(details == "from")
		{
			document.forms[0].from_nursing_unit.value=arr[0];
			document.forms[0].from_nursing_unit_desc.value=arr[1];
		}
		else
		{
			document.forms[0].nursing_unit.value=arr[0];
			document.forms[0].nursing_unit_desc.value=arr[1];
		}
	}
	else
	{
		if(details == "from")
		{
			document.forms[0].from_nursing_unit.value		="";
			document.forms[0].from_nursing_unit_desc.value	="";
		}
		else
		{
			document.forms[0].nursing_unit.value		="";
			document.forms[0].nursing_unit_desc.value	="";
		}
	}
} // End of getNursingUnitValue().

// To get the Specialty using common lookup.
async function getSpecialtyValue(aSpecialty, getFacilitID, details)
{

	var facility_id	   = getFacilitID;
	var target		   = document.forms[0].specialty_desc;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale = document.forms[0].locale.value;

	sql=" Select speciality_code code,short_desc description from AM_SPECIALITY_LANG_VW where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";
	//sql=" Select speciality_code code,am_get_desc.am_speciality(speciality_code,'"+locale+"',2)description from AM_SPECIALITY where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) ";
	tit=getLabel("Common.speciality.label","Common");
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = aSpecialty.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		
		if(details == "from")
		{
			document.forms[0].from_Splcode.value=arr[0];
			document.forms[0].from_specialty_desc.value=arr[1];
		}
		else
		{
			document.forms[0].Splcode.value=arr[0];
			document.forms[0].specialty_desc.value=arr[1];
		}
	}
	else
	{
		if(details == "from")
		{
			document.forms[0].from_specialty_desc.value = "";
			document.forms[0].from_Splcode.value = "";
		}
		else
		{
			document.forms[0].specialty_desc.value = "";
			document.forms[0].Splcode.value = "";
		}
	}
} // End of getSpecialtyValue.
 

function dateFromTo(Obj)
{
	var dateTo=Obj;
	var dateFrom=document.Inpatientlookup_Form.from_date;
	
	if(!doDateCheckAlert(dateFrom,dateTo))
	alert(getMessage('TO_DT_GR_EQ_FM_DT',"SM"));

}
			
  
function DisReset()
{
	if(document.forms[0].call_function.value != 'rep')
	{
		if(parent.frames[0].document.getElementById("reset") != null)
			parent.frames[0].document.getElementById("reset").disabled=true; 
	}
}

function popDynamicValues(obj)
{}


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// The Foll Functions will be called from InpatientLookupQueryResult.jsp
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


// By Annadurai 16/4/2004  - For MP Module New Born Registration function validation. End
async function getStatusDetails(encounter, patient, refno)
{
	var retValue = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "85";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;				
	var routine_tfr_yn = document.forms[0].routine_tfr_yn.value;
	retValue = await  window.showModalDialog("PaintAmendTransfer.jsp?encounterId="+encounter+"&patientId="+patient+"&booking_ref_no="+refno+"&routine_tfr_yn="+routine_tfr_yn+"&function_id=CancelRequest&fromFunction=RequestDetail",arguments,features);
}

function closeWin(enc,patid,changefunc)
{
	showModalCurEnc(enc,patid,changefunc);
}
var locn;

async function showModalBabyDetails(encounterid,facilityid,mother_patient_id,pract_id,nursing_code,sex,bed_no,patient_class)
{
	var retVal1;
	var call_function = document.forms[0].call_function.value;
	var arguments="";
	var dialogHeight= "700px";
	var dialogWidth = "900px";
	var dialogTop	= "10";

/*	var dialogTop	= "230";
	var dialogHeight= "18" ; 
	var dialogWidth	= "49.8" ;	
*/
	var dialogLeft	= "65";

	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	retVal1 = await window.showModalDialog("../jsp/LinkBabytoMotherFrames.jsp?encounterid="+encounterid+"&facilityid="+facilityid+"&call_function="+call_function+"&nursing_code="+nursing_code+"&sex="+sex+"&bed_no="+bed_no+"&patient_class="+patient_class+"&mother_patient_id="+mother_patient_id,arguments,features);
	parent.frames[2].document.location.reload();
}

async function showModalCurEnc(enc,patid,changefunc)
{
	
	
	var bl_install_yn=document.forms[0].bl_install;
	var call_function = document.forms[0].call_function.value;
	var jsp_name="CurrentEncounterMain.jsp";
/*
	var win_height=document.forms[0].win_height.value;
	if(win_height == "") win_height="33.4";
	var win_width=document.forms[0].win_width.value;
	if(win_width == "") win_width="49.8";
	*/
	if(changefunc == "Y")
		call_function = "QueryDischarge";

	var retVal = 	new String();

	var dialogHeight= "650px";
	var dialogWidth = "900px";
	var dialogTop	= "10";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn.value+"&call_function="+call_function+"&patientId="+patid,arguments,features);
	if(retVal!=null && retVal!='')
	parent.frames[2].document.location.reload();
}

// By Annadurai 16/4/2004  - For MP Module New Born Registration function validation. starts
function checkExpiry(pat_id,jsp_name,flag,func_id, sflag, target,nursing_unit_code,bed_no)
{
	 var sStyle = document.forms[0].sStyle.value; 
	 var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'>";
	 HTMLVal = HTMLVal +"<form name='validate_form' id='validate_form' method='post' action='../../eMP/jsp/PatSearchCheckAltIDExpiryDate.jsp' target='messageFrame'>";
	 HTMLVal = HTMLVal +"<input name='pat_id' id='pat_id' type='hidden' value= \""+escape(pat_id) + "\">";
	 HTMLVal = HTMLVal +"<input name='jsp_name' id='jsp_name' type='hidden' value= '"+jsp_name+"'>";
	 HTMLVal = HTMLVal +"<input name='flag' id='flag' type='hidden' value= '"+flag+"'>";
	 HTMLVal = HTMLVal +"<input name='func_id' id='func_id' type='hidden' value= '"+func_id+"'>";
	 HTMLVal = HTMLVal +"<input name='sflag' id='sflag' type='hidden' value= '"+sflag+"'>";
	 HTMLVal = HTMLVal +"<input name='nursing_unit_code' id='nursing_unit_code' type='hidden' value= '"+nursing_unit_code+"'>";
	 HTMLVal = HTMLVal +"<input name='bed_no' id='bed_no' type='hidden' value= '"+bed_no+"'>";
	 HTMLVal = HTMLVal +"<input name='IPValue' id='IPValue' type='hidden' value= '"+target+"'>";
	 HTMLVal = HTMLVal +"<input name='win_width' id='win_width' type='hidden' value= '61'>";
	 HTMLVal = HTMLVal +"<input name='win_top' id='win_top' type='hidden' value= '34'>";
	 HTMLVal = HTMLVal +"<input name='win_height' id='win_height' type='hidden' value= '50'>";
	 HTMLVal = HTMLVal +"<input name='calling_module_id' id='calling_module_id' type='hidden' value= 'IP'>";
	 HTMLVal = HTMLVal +"</form></BODY></HTML>";
	 parent.frames[3].document.write(HTMLVal);
	 parent.frames[3].document.validate_form.submit(); 
	
}


function isBlAllowed(enc, patid, practid, IPval, sex, bed_no, patientclass, colorCode, status_value, tfr_req_status, leave_exp_dt_flag,cutt_of_time,max_disch_period_for_predc){
	var change_adm_dtls_duration	=	document.forms[0].change_adm_dtls_duration.value
	var bl_install_yn						=	document.forms[0].bl_install_yn.value
	var HTMLVal ="<html><body class='MESSAGE' onKeyDown='lockKey()'> "+
							"<form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/ChangeAdmissionValidation.jsp'>"+
							"<input type='hidden' name='forBllingProc' id='forBllingProc' value='Y'>"+
							"<input type='hidden' name='encounter_id' id='encounter_id' value='"+enc+"'>"+
							"<input type='hidden' name='patient_id' id='patient_id' value='"+patid+"'>"+
							/*"<input type='hidden' name='pract_id' id='pract_id'	value='"+practid+"'>"+
							"<input type='hidden' name='location_code' id='location_code' value='"+IPval+"'>"+
							"<input type='hidden' name='sex' id='sex' value='"+sex+"'>"+
							"<input type='hidden' name='bed_no' id='bed_no' value='"+bed_no+"'>"+
							"<input type='hidden' name='patient_class' id='patient_class' value='"+patientclass+"'>"+
							"<input type='hidden' name='colorCode' id='colorCode' value='"+colorCode+"'>"+
							"<input type='hidden' name='status_value' id='status_value' value='"+status_value+"'>"+
							"<input type='hidden' name='tfr_req_status' id='tfr_req_status' value='"+tfr_req_status+"'>"+
							"<input type='hidden' name='leave_exp_dt_flag' id='leave_exp_dt_flag' value='"+leave_exp_dt_flag+"'>"+*/
							"<input type='hidden' name='change_adm_dtls_duration' id='change_adm_dtls_duration' value='"+change_adm_dtls_duration+"'>"+
							"<input type='hidden' name='cutt_of_time' id='cutt_of_time' value='"+cutt_of_time+"'>"+
							"<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'>"+
							"<input type='hidden' name='max_disch_period_for_dc' id='max_disch_period_for_dc' value='"+max_disch_period_for_predc+"'>"+
							"</form> </body> </html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();
}
async function proceedAdmission(enc,patid,practid,IPval,sex,bed_no,patientclass,colorCode,status_value,tfr_req_status,leave_exp_dt_flag,cutt_off_time,change_adm_dtls_duration){

		
		var module	= document.forms[0].module.value
		if (module=="")module="eIP";
		var instl_yn				         = document.forms[0].bl_install.value;
		var confirmIP			             = document.forms[0].confirmIP.value;
		var p_service_type	                 = document.forms[0].p_service_type.value;
		var call_function		             = document.forms[0].call_function.value;
		var function_name	                 = document.forms[0].function_name.value;
		var oper_stn_id		                 = document.forms[0].oper_stn_id.value;
		var priotity_status	                 = document.forms[0].priotity_status.value;
		var setup_bl_dtls_in_ip_yn	         = document.forms[0].setup_bl_dtls_in_ip_yn.value;
		var bl_interfaced_yn				 = document.forms[0].bl_interfaced_yn.value;
		var deactivate_pseudo_bed_yn	     = document.forms[0].deactivate_pseudo_bed_yn.value;
		var bed_class_allowed				 = document.forms[0].change_bed_class_yn.value;
		var chg_nurs_unit_in_assign_bed_yn	 = document.forms[0].chg_nurs_unit_in_assign_bed_yn.value;
		var dflt_blk_prd_for_tfr_out		 = document.forms[0].dflt_blk_prd_for_tfr_out.value;
		var pat_check_in_allowed_yn			 = document.forms[0].pat_check_in_allowed_yn.value;
		var bed_block_period_normal			 = document.forms[0].bed_block_period_normal.value;
		var tot_count						 = document.forms[0].total_count.value;
		var max_disch_period_for_dc			 = document.forms[0].max_disch_period_for_dc.value;
		var dialogHeight	= "90vh";
		var dialogWidth	= "70vw";
		var dialogTop		= "10";
		var center = "1" ;
		var status="no";
		var condition="";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

			retVal =   await top.window.showModalDialog("../../"+module+"/jsp/ChangeAdmissionDetailsMain.jsp?location_code="+IPval+"&encounterId="+enc+"&function_name="+function_name+"&patientId="+patid+"&Practitioner_Id="+escape(practid)+"&callfrom=IP&call_function="+call_function+"&Sex="+sex+"&mode=modal&bl_instal="+instl_yn+"&status_value="+status_value+"&confirmIP="+confirmIP+"&p_service_type="+p_service_type+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&oper_stn_id="+oper_stn_id+"&pat_check_in_allowed_yn="+pat_check_in_allowed_yn+"&setup_bl_dtls_in_ip_yn="+setup_bl_dtls_in_ip_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&priotity_status="+priotity_status+"&change_bed_class_yn="+bed_class_allowed+"&deactivate_pseudo_bed_yn="+deactivate_pseudo_bed_yn+"&dflt_blk_prd_for_tfr_out="+dflt_blk_prd_for_tfr_out+"&bed_block_period_normal="+bed_block_period_normal+"&cutt_off_time="+cutt_off_time+"&change_adm_dtls_duration="+change_adm_dtls_duration+"&max_disch_period_for_dc="+max_disch_period_for_dc+""+condition,arguments,features);
		if(tot_count >= 1)
		{
		parent.frames[2].document.location.reload();
		parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp";
		}
		else
		parent.frames[2].document.location.href="../../eCommon/html/blank.html";


}



//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// The Foll Functions will be called from InpatientLookupQueryResult.jsp
//on click of patients whose bed class is pending in transfer patient out it displays a message and will not open TransferpatientOut modal window.
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function ONLY_ONE_BKG()
{
	error = getMessage('ONLY_ONE_REQ_BKG','IP');
	alert(error);	
}

async function beforeGetCancelledBy(func_name)
{
	if(document.forms[0].user.value != document.forms[0].user_name.value)
	{
		if(document.forms[0].user_name.value != "")
			await showLookUpCancel(func_name);
		else{
			document.forms[0].user_hid.value="";
			document.forms[0].user.value = "";
		}
	}
}
/*
	Function Added 
	On:10/28/2010,For:FD-PMG20089-CRF-0862,By:Chiranjeevi.C
*/
function excludeNDAPatient(obj){
	if (obj.checked==true){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}

/*Added by Arthi on 31-Jan-2022 for GHL-CRF-0643*/
function makePatientIdMandatory(obj){

	var no_of_days = obj.value;
	var patient_id = document.forms[0].patient_id.value;
	
	if(no_of_days != "" && no_of_days.length > 2)
	{
		if(patient_id == "")
		{
			document.getElementById("PatIdMand").style.visibility = "visible";
			alert(getMessage('PAT_ID_MAND','Common'));
			document.forms[0].patient_id.focus();
		}else
		{
			document.getElementById("PatIdMand").style.visibility = "visible";
		}

	}else
	{
		document.getElementById("PatIdMand").style.visibility = "hidden";
	}

}

function reloadMandFields()
{
	var isPatIdMandAppl = f_query_add_mod.document.forms[0].isPatIdMandAppl.value;
	var call_function = f_query_add_mod.document.forms[0].call_function.value;
	
	if(call_function == "IPList" || call_function == "IpInternalReportReprint")
	{
		if(f_query_add_mod.document.forms[0].include_yn)
		{
			if(isPatIdMandAppl == "true"){
				f_query_add_mod.document.forms[0].PatIdMand.style.visibility = "hidden";
			}
			f_query_add_mod.document.forms[0].no_of_days.value = "";
			f_query_add_mod.document.forms[0].include_yn.value = "N";
			f_query_add_mod.document.forms[0].no_of_days.readOnly = true;
			f_query_add_mod.document.forms[0].daysImg.style.visibility = "hidden";
		}
	}
}
/*End GHL-CRF-0643*/

//Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613
function insertDataInvokeBLReport(facility_id,episode_id,locale,session_id,pgm_date){
	//var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlDoc ="";
	var xmlHttp = new XMLHttpRequest()
	xmlStr="<root><SEARCH facility_id=\""+facility_id+"\" episode_id=\""+episode_id+"\" session_id=\""+session_id+"\" pgm_date=\""+pgm_date+"\" action='insertSyProgParam' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var returnval = trimString(responseText);

	url = returnval+"+p_language_id="+locale+"+DESTYPE=CACHE+PARAMFORM=NO+P_FACILITY_ID="+facility_id+"+DESFORMAT=PDF+RECURSIVE_LOAD=NO+MAXIMIZE=YES+P_PGM_ID=BLR00018+P_SESSION_ID="+session_id+"+P_PGM_DATE="+pgm_date;

	if ( returnval != "" ){
		var reportURL = "../../eCommon/jsp/report_process.jsp?" + url ;
		var myBars = 'directories=no,location=no,menubar=no' ;
		var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
		var myFeatures = myBars + ', ' + myOptions ;
		var reportWindow = open(reportURL, '_blank', myFeatures);
	
		reportWindow.title= "Medicom Report Viewer";
		reportWindow.resizeTo(screen.availWidth, screen.availHeight);
		reportWindow.moveTo( 0,0 );
		reportWindow.focus();
	}
}

