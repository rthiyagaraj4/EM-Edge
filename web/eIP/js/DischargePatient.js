function bodyrelease(obj)
{
	if(obj.checked)
	{
		obj.value ="Y";
	}
	else
	{
		obj.value ="N";
	}
}

// The Entire layout was changed . Two Tabs were introduced For Discharge & Referral
// function tab_click - Will Scroll the view betwen Two Tabs ...
function tab_click(objName)
{
	if (objName == 'discharge_details' || objName == 'discharge_details1' )
	{
		document.getElementById('tab1').scrollIntoView({
			  behavior: "smooth",
			  block: "nearest",
			  inline: "start"
			});
		document.forms[0].auth_pract_desc.focus();
	}
    else if (objName == 'Addl_Discharge_Details' || objName == 'Addl_Discharge_Details1' )
	{
		document.getElementById('tab2').scrollIntoView({
			  block: "nearest",
			  inline: "start"
		  });
		document.forms[0].bed_blocking_period.disabled = false;
		document.forms[0].bed_blocking_period.readonly = true;
		document.forms[0].bed_blocking_period.focus();

	}
}

function validateBodyReleasedDate(releasedDate)
{
	var admission_date_time = document.forms[0].admission_date_time;
	var DECEASED_DATE_TIME  = document.forms[0].DECEASED_DATE_TIME;
	var server_date			= document.forms[0].server_date;
	var flag = "Y";
	var result = "Y";
	var greg_release_date = "";
	DECEASED_DATE_TIME = convertDate(DECEASED_DATE_TIME.value,"DMYHM",localeName,"en");
	
	if(releasedDate.value != "")
	{
		if(!validDate(releasedDate.value,"DMYHM",localeName))
			result = "N";		
		else
			result = "Y";
		greg_release_date = convertDate(releasedDate.value,"DMYHM",localeName,"en");
	}

	if((result == "Y") && (greg_release_date != "") && (server_date.value != ""))
	{	
		//if ((greg_release_date  != server_date.value) && (!isBefore(greg_release_date , server_date.value,"DMYHM",localeName))){
			if ((greg_release_date  != server_date.value) && (!isBefore(greg_release_date , server_date.value,"DMYHM","en"))){//Modified By Dharma on 30th Sep 2015 against Leap Year Issue
			
			var error = getMessage("DATE1_GT_DATE2","IP");
			
			error = error.replace("$", getLabel("eIP.BodyReleasedtoMortuaryDate.label","IP")); 
			error = error.replace("#", getLabel("Common.CurrentDateTime.label","Common"));
			alert(error); 
			document.forms[0].body_released_date.select();
			flag = "N";
		}
	}
	
	if((result == "Y") && (greg_release_date  != "") && (DECEASED_DATE_TIME.value != "") && (flag == "Y"))
	{
		//if ((greg_release_date  != DECEASED_DATE_TIME) && (!isAfter(greg_release_date,DECEASED_DATE_TIME,"DMYHM",localeName))) {
			if ((greg_release_date  != DECEASED_DATE_TIME) && (!isAfter(greg_release_date,DECEASED_DATE_TIME,"DMYHM","en"))) {//Modified By Dharma on 30th Sep 2015 against Leap Year Issue
	
			
			var error = getMessage("DATE1_LT_DATE2","IP");
			error = error.replace("$", getLabel("eIP.BodyReleasedtoMortuaryDate.label","IP")); 
			error = error.replace("#", getLabel("Common.deathdatetime.label","Common"));
			alert(error); 
			document.forms[0].body_released_date.select();
			flag = "N";
		}
	}
	
	if ((result == "Y") && (releasedDate.value != "") && (DECEASED_DATE_TIME != "") && (flag == "Y"))
	{
		greg_dis_date = convertDate(self.document.DischargePatient_form.discharge_date_time.value,"DMYHM",localeName,"en");
		greg_rel_date = convertDate(self.document.DischargePatient_form.body_released_date.value,"DMYHM",localeName,"en");
		
		//if(!self.isBefore(greg_dis_date, greg_rel_date,"DMYHM",localeName)) {
			if(!self.isBefore(greg_dis_date, greg_rel_date,"DMYHM","en")) {//Modified By Dharma on 30th Sep 2015 against Leap Year Issue
			var error = getMessage("DATE1_LT_DATE2","IP");  
			error = error.replace("$", getLabel("eIP.BodyReleasedtoMortuaryDate.label","IP"));
			error = error.replace("#", getLabel("Common.dischargedatetime.label","Common"));
			alert(error);
			document.forms[0].body_released_date.value="";
		}
	}
}

function validateDeathDate(deathDate)
{
	var proceed = true;
	var admission_date_time = document.forms[0].admission_date_time;
	if ((deathDate.value != ""))
	{
		if ((admission_date_time.value != "") && (deathDate.value != admission_date_time.value) && (!isAfter(deathDate.value, admission_date_time,"DMYHM", localeName)))
		{
			var error = getMessage("DATE1_LT_DATE2","IP");
			error = error.replace("$", getLabel("Common.deathdatetime.label","Common"));
			error = error.replace("#", getLabel("Common.AdmissionDateTime.label","Common"));
			alert(error);
			document.forms[0].DECEASED_DATE_TIME.select();
			proceed = false;
		}
		
		var discharge_date_time = document.forms[0].discharge_date_time;
		if((deathDate.value != "") && (discharge_date_time.value != "") && proceed == true)
		{
			if ((discharge_date_time.value != "") && (deathDate.value != discharge_date_time.value) && (!isAfter(discharge_date_time.value, deathDate.value,"DMYHM", localeName )))
			{
				var error = getMessage("DATE1_GT_DATE2","IP");
				error = error.replace("$", getLabel("Common.deathdatetime.label","Common"));
				error = error.replace("#", getLabel("Common.dischargedatetime.label","Common"));
				alert(error);
				document.forms[0].DECEASED_DATE_TIME.select(); 
				return;
			}
		}	
	}
}

function checkMaxlen(obj)
{
	if (obj.value.length > 200)
	{
		//alert(getMessage('EXCEED_MAX_LENGTH','SM'));
		var msg = getMessage('REMARKS_CANNOT_EXCEED',"Common");
		msg		= msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg		= msg.replace("#",200);
		alert(msg);
		obj.select();
		obj.focus();
	}
}
//Added for the CRF - Bru-HIMS-CRF-157
function checkOtherReasonMaxlen(obj)
{
	if (obj.value.length > 200)
	{
		//alert(getMessage('EXCEED_MAX_LENGTH','SM'));
		var msg = getMessage('REMARKS_CANNOT_EXCEED',"Common");
		msg		= msg.replace("$",getLabel("eIP.otherReason.label","Common"));
		msg		= msg.replace("#",200);
		alert(msg);
		obj.select();
		obj.focus();
	}
}

function validateDateTimes(obj,val)
{
	if(obj.value != '')
	{
		if(validDateObj(obj,"DMYHM",localeName))
		{
			if(val == 'D')
			{
				fr = self.document.DischargePatient_form.sysdatetime;
				to = self.document.DischargePatient_form.discharge_date_time;
				if(ValidateDischargeDate(fr.value,to.value,'D'))
				{
					alert(self.getMessage('DIS_DATE_LT_EXCEEDED','IP'));
					obj.select();
				}
				if (isAfter(self.document.DischargePatient_form.discharge_date_time.value, self.document.DischargePatient_form.admission_date_time.value,"DMYHM",localeName))
				{
					obj.select();
				}
				if (!isAfter(self.document.DischargePatient_form.discharge_date_time.value, self.document.DischargePatient_form.admission_date_time.value,"DMYHM", localeName))
				{
					alert(self.getMessage('DIS_DATE_NOT_LESS_ADM_DATE','IP'));
					obj.select();
				}
			}
			else if(val == 'DE')
			{
				fr = self.document.DischargePatient_form.sysdatetime;
				to = self.document.DischargePatient_form.DECEASED_DATE_TIME;
				if(ValidateDischargeDate(to.value,fr.value,'DE'))
				{
					alert(self.getMessage('DECEASED_DT_NOT_GR_TODAY','MP'))
					obj.select();
				}else
				{
					validateDeathDate(obj);
				}
			}
			else if(val == 'B')
			{
				fr = self.document.DischargePatient_form.discharge_date_time;
				to = self.document.DischargePatient_form.block_until_date;
				if ((to.value != '') && (fr.value != ""))
				{
					if(ValidateBlockDate(fr.value,to.value,'O'))
					{
						alert(self.getMessage('BLK_DT_GREATER_DIS_DT','IP'))
						obj.focus();
					}
				}
			}
		}
	}
}

function compareServerDate1(sysDate)
{
	

	if ((sysDate.value != "") && (document.forms[0].patient_class_value.value != "DC"))
	{
		var greg_serverdate= convertDate(document.forms[0].server_date.value,"DMYHM","en",localeName);
		var greg_sysdate = convertDate(sysDate.value,"DMYHM",localeName,"en");
		if(isAfter(greg_sysdate,greg_serverdate,"DMYHM",localeName))
		{
		  document.forms[0].discharge_date_time.value=greg_serverdate;//document.forms[0].server_date.value;
		  
		}
	}
}


// For Day Care Issues. starts.
function dayCareDateCheck(dateVal)
{
	if(dateVal.value != "")
	{
		if(validDateObj(dateVal,"DMYHM", localeName))
		{
			if(document.forms[0].proceed.value == "Y")
			{
				if(document.forms[0].patient_class_value.value == "DC") 
				{
					var valid = document.forms[0].valid.value;
					//var discharge_date_time =document.forms[0].discharge_date_time.value;
					var discharge_date_time = convertDate(document.forms[0].discharge_date_time.value,"DMYHM",localeName,"en");/*Added by Rameswar on 16-OCT-2015 for Leap Year Issue*/
					var from_time = document.forms[0].from_time.value;
					var max_param_date = document.forms[0].max_param_date.value;
					var valid_date = document.forms[0].valid_date.value;
					
					if(valid == "N")
					{
						
						if(isAfter(from_time, discharge_date_time,"DMYHM", localeName))
						{
							
							var trn_error = getMessage("DATE1_LT_DATE2","IP"); 
							trn_error = trn_error.replace("$", getLabel("Common.dischargedatetime.label","Common")); 
							trn_error = trn_error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP")); 
							alert(trn_error); 
							dateVal.select(); 
							return false;
						}						
						if(isAfter(discharge_date_time, valid_date,"DMYHM", localeName))
						{
							var max_error = getMessage("GENERAL_CANNOT_EXCEED","IP");
							max_error = max_error.replace("$",getLabel("Common.dischargedatetime.label","Common"));
							max_error = max_error.replace("#",valid_date);
							alert(max_error);
							dateVal.select(); 
							return false;
						}
					}
					else if(valid == "Y")
					{
						if(isAfter(from_time, discharge_date_time,"DMYHM", localeName))
						{
							var trn_error = getMessage("DATE1_LT_DATE2","IP");
							trn_error = trn_error.replace("$",getLabel("Common.dischargedatetime.label","Common"));
							trn_error = trn_error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP"));
							alert(trn_error);
							dateVal.select();
							return false;
						}

						if(isAfter(discharge_date_time, max_param_date,"DMYHM", localeName))
						{
							var param_error = getMessage("DATE1_GT_DATE2","IP");
							param_error = param_error.replace("$",getLabel("Common.dischargedatetime.label","Common"));
							param_error = param_error.replace("#",getLabel("eIP.MaximumParameterValue.label","IP"));
							alert(param_error);
							dateVal.select(); 
							return false;
						}
					}
				}
			}
		}
	}
}
// - For Day Care Issues. Ends.




function checkBabyBed()
{
	var mother_status = document.forms[0].mother_status.value;
	if (mother_status != '0')
	{
		if(confirm(getMessage('DELINK_BABY_YN','IP'))) 
		{
			document.forms[0].mother_bed_status.value='Y';
			return true; 
		}
		else 
		{
			 document.forms[0].mother_bed_status.value='N';
			 window.close(); 
		}
	}
}

function submitForm()
{
	var fields	= new Array();
	var names	= new Array();
	fields[0]	=	parent.frames[2].document.DischargePatient_form.practid;
	fields[1]	=	parent.frames[2].document.DischargePatient_form.discharge_date_time;
	if(parent.frames[2].document.DischargePatient_form.isModifyDiscTypeStatusAppl.value=="true" && parent.frames[2].document.DischargePatient_form.allow_modify_disc_yn.value=="Y") // added by mujafar for ML-MMOH-CRF-0659
		fields[2]	=	parent.frames[2].document.DischargePatient_form.discharge_stat;
	else
		fields[2]	=	parent.frames[2].document.DischargePatient_form.discharge_type;
	
	
	
	names[0]	=	getLabel("eIP.AuthorizedPractitioner.label","IP");
	names[1]	=	getLabel("Common.dischargedatetime.label","Common");
	if(parent.frames[2].document.DischargePatient_form.isModifyDiscTypeStatusAppl.value=="true" && parent.frames[2].document.DischargePatient_form.allow_modify_disc_yn.value=="Y") // added by mujafar for ML-MMOH-CRF-0659
	names[2]	=	getLabel("eIP.DischargeStatus.label","IP");
	else
	names[2]	=	getLabel("Common.dischargetype.label","Common"); 
		
	
	/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
	var is_validate_weight_on_admission		= parent.frames[1].document.DischargePatient_form_display.is_validate_weight_on_admission.value;
	var is_value_already_captured			= parent.frames[1].document.DischargePatient_form_display.is_value_already_captured.value;
	
	var weight_on_admission					= parent.frames[1].document.DischargePatient_form_display.weight_on_admission.value;
	var weight_on_admission_unit			= parent.frames[1].document.DischargePatient_form_display.weight_on_admission_unit.value;
	if(is_validate_weight_on_admission=="Y"){
		if(weight_on_admission==""){
			fields.unshift(parent.frames[1].document.DischargePatient_form_display.weight_on_admission);
			names.unshift(getLabel('eIP.WeightOnAdmission.label','IP'));
		}
	}
	/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
	
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	var isHeightAndBmiEnable =parent.frames[2].document.DischargePatient_form.isHeightAndBmiEnable.value;
	var enable_height_bmi_pat_cls           = parent.frames[1].document.DischargePatient_form_display.enable_height_bmi_pat_cls.value;
	var patient_class						= parent.frames[2].document.DischargePatient_form.patient_class_value.value;
	if(isHeightAndBmiEnable=="true")
	{
		if(enable_height_bmi_pat_cls==patient_class|| enable_height_bmi_pat_cls==("ID")) 
		{
			var height_on_admission					= parent.frames[1].document.DischargePatient_form_display.height_on_admission.value;
			var is_value_already_captured_height	= parent.frames[1].document.DischargePatient_form_display.is_value_already_captured_height.value;
			var height_on_admission_unit			= parent.frames[1].document.DischargePatient_form_display.height_on_admission_unit.value;
			var is_validate_height_on_admission		= parent.frames[1].document.DischargePatient_form_display.is_validate_height_on_admission.value;
		}
		
		if(is_validate_height_on_admission=="Y"){
			if(height_on_admission==""){
				if(enable_height_bmi_pat_cls==patient_class  || enable_height_bmi_pat_cls=="ID")
				{
					fields.unshift(parent.frames[1].document.DischargePatient_form_display.height_on_admission);
					names.unshift(getLabel('eIP.HeightOnAdmission.label','IP'));
				}
			}
			
		}
	}
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
	

	if (parent.frames[2].document.DischargePatient_form.dead_yn.value == "Y")
	{
		fields[3]	=	 parent.frames[2].document.DischargePatient_form.DECEASED_DATE_TIME;
		names[3]	=	getLabel("Common.deathdatetime.label","Common");
		if (parent.frames[2].document.DischargePatient_form.inform_to.value != "")
		{
			fields[4]	=	 parent.frames[2].document.DischargePatient_form.informed_date;
			names[4]	=	getLabel("Common.InformedDate/Time.label","Common");
		}
	}
 
	if ((parent.frames[2].document.DischargePatient_form.dead_yn.value != "Y") && (parent.frames[2].document.DischargePatient_form.inform_to.value != ""))
	{
		fields[3]	=	 parent.frames[2].document.DischargePatient_form.informed_date;
		names[3]	=	getLabel("Common.InformedDate/Time.label","Common");
	}

	fields[fields.length]	=	 parent.frames[2].document.DischargePatient_form.dischg_pract_desc;
	names[names.length]		=	getLabel("eIP.DischargingPractitioner.label","IP");

	if(parent.frames[2].document.DischargePatient_form.isModifyDiscTypeStatusAppl.value=="true" && parent.frames[2].document.DischargePatient_form.allow_modify_disc_yn.value=="Y") // added by mujafar for ML-MMOH-CRF-0659
	{

	if(parent.frames[2].document.getElementById('AbsImg').style.Visibility=='visible'){ // added by mujafar for ML-MMOH-CRF-0659
		fields[fields.length]	=	 parent.frames[2].document.DischargePatient_form.absconding_date;
		names[names.length]	    =	getLabel("eIP.AbscondingDateTime.label","IP");
	}
	}
	
	if (parent.frames[2].document.forms[0].dead_yn.value == 'Y')
	{
		parent.frames[2].document.getElementById('bodyreleasedImg').style.visibility = 'visible';
		fields[fields.length]	=	 parent.frames[2].document.DischargePatient_form.body_released_date;
		names[names.length]		=	getLabel("eIP.BodyReleasedtoMortuary.label","IP");
	}
	
	//Added for the CRF - Bru-HIMS-CRF-157
	if(parent.frames[2].document.DischargePatient_form.allow_late_disch_reason.value == 'Y')
	{
		if (parent.frames[2].document.DischargePatient_form.disch_reason_mand_yn.value == 'Y')
		{
			if (parent.frames[2].document.DischargePatient_form.hid_late_dis_reason.value == "others")
			{			
				fields[fields.length]	=	 parent.frames[2].document.DischargePatient_form.other_late_discharge_reason;
				names[names.length]		=	getLabel("eIP.ReasonForLateDischarge.label","IP");
			}
			else
			{				
				if(parent.frames[2].document.DischargePatient_form.late_discharge_reason) // Saanthaakumar  Against Incident Number 34283 Dated on 26/07/2012
				{
					fields[fields.length]	=	 parent.frames[2].document.DischargePatient_form.late_discharge_reason;
					names[names.length]		=	getLabel("eIP.ReasonForLateDischarge.label","IP");
				}
			}
		}
	}

	if(checkFields1( fields, names))
	{
		
		/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
		
		if(is_value_already_captured=="Y" && weight_on_admission==""){
			var err = getMessage("VALUE_ALREADY_CAPTURED","IP");
			alert(err);
			parent.frames[1].document.DischargePatient_form_display.weight_on_admission.focus();
			return false;
		}
		
		
		
		if(weight_on_admission!=""){
			var chk_weight_on_admission	= parseFloat(weight_on_admission);
			if(chk_weight_on_admission <= 0){
				var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO","Common");
				msg = msg.replace('Value',getLabel("eIP.WeightOnAdmission.label","IP") );
				alert(msg);
				parent.frames[1].document.DischargePatient_form_display.weight_on_admission.focus();
				return false;
			}
			
			if(!(/^\d{1,8}(?:\.\d{1,3})?$/).test(weight_on_admission)){//Decimal validation
				var msg = getMessage("INVALID_WEIGHT_ON_ADMISSION","IP");
				alert(msg);
				 parent.frames[1].document.DischargePatient_form_display.weight_on_admission.focus();
				
				return false;
			}
		}
		
		if(weight_on_admission==""){
			weight_on_admission_unit	= "";
		}
		parent.frames[2].document.DischargePatient_form.weight_on_admission.value	 = weight_on_admission;
		parent.frames[2].document.DischargePatient_form.weight_on_admission_unit.value = weight_on_admission_unit;
		/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/

		if(isHeightAndBmiEnable=="true")
		{

			if((enable_height_bmi_pat_cls==patient_class|| enable_height_bmi_pat_cls=="ID"))
			{
				if(is_value_already_captured_height=="Y" && height_on_admission==""){
					var err = getMessage("VALUE_ALREADY_CAPTURED_HEIGHT","IP");
					alert(err);
					parent.frames[1].document.DischargePatient_form_display.height_on_admission.focus();
					return false;
				}
				if(height_on_admission!=""){
					var chk_height_on_admission	= parseFloat(height_on_admission);
					if(chk_height_on_admission <= 0){
						var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO","Common");
						msg = msg.replace('Value',getLabel("eIP.HeightOnAdmission.label","IP") );
						alert(msg);
						parent.frames[1].document.DischargePatient_form_display.height_on_admission.focus();
						return false;
					}
					if(!(/^\d{1,8}(?:\.\d{1,3})?$/).test(height_on_admission)){//Decimal validation
						var msg = getMessage("INVALID_HEIGHT_ON_ADMISSION","IP");
						alert(msg);
						 parent.frames[1].document.DischargePatient_form_display.height_on_admission.focus();
						
						return false;
					}
				}
				if(height_on_admission==""){
					height_on_admission_unit	= "";
				}
				parent.frames[2].document.DischargePatient_form.height_on_admission.value	 = height_on_admission;
				parent.frames[2].document.DischargePatient_form.height_on_admission_unit.value = height_on_admission_unit;
			}
		}
		
		if(isHeightAndBmiEnable=="true")
		{
			if(parent.frames[2].document.DischargePatient_form.Type_indicator.value=='ED')
			{
				if(trimString(parent.frames[2].document.DischargePatient_form.discharge_to.value)=="")  //Added trimString Against INC:32495
				{
					var err = getMessage("CAN_NOT_BE_BLANK","Common");
					err = err.replace('$',getLabel("eIP.DischargeTo.label","IP"));
					alert(err);
					parent.frames[2].document.DischargePatient_form.discharge_to.focus();
					return;
				}
			}
		}
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/
		
		
		var fr	= parent.frames[2].document.DischargePatient_form.discharge_date_time;
		var to = parent.frames[2].document.DischargePatient_form.bed_block_until;
		var curr = parent.frames[2].document.DischargePatient_form.sysdatetime;
		var to_submit="T";
		var greg_fr = parent.frames[2].convertDate(fr.value,"DMYHM",localeName,"en");

		/*IN012727  SRR20056-SCF-3347*/
		//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		/*if(parent.frames[2].document.DischargePatient_form.mr_mds_recorded.value!='Y')
		{
			alert(parent.frames[2].getMessage("MDS_NOT_ENTERED","Common"));
			to_submit="F";
		}
		else 
		*/
		if(!ValidateDischargeDate(curr.value,greg_fr,'N'))
		{
			alert(parent.frames[2].getMessage("INVALID_DISCHARGE_DATE","IP"));
			to_submit="F";
		}
		else if (to.value != '')
		{
			if(!ValidateBlockDate(greg_fr,to.value,'B'))
			{	
				alert(parent.frames[2].getMessage("INVALID_BLOCK_UNTIL_DATE","IP"));
				to_submit="F";
			}
		}
		
		var dateObj		= parent.frames[2].document.DischargePatient_form.discharge_date_time;
		var localName	= parent.frames[2].document.DischargePatient_form.locale1.value
		if(!validatePatient(dateObj,localName)){
			to_submit	= "F";
		}		
		if (to_submit!="F")
		{			
			parent.frames[2].document.DischargePatient_form.deceased_yn.disabled = false;
			parent.frames[2].document.DischargePatient_form.post_mortem_request.disabled = false;
		
			//added on 01-10-2003 by dhanasekaran 
			parent.frames[2].document.DischargePatient_form.SickLeaveDetails.value = escape(parent.frames[2].document.forms[0].SickLeaveDetails.value);
			//end addition				
			
				parent.frames[3].document.getElementById('confirm').disabled = true;
			if (parent.frames[2].document.forms[0].deceased_yn.checked)
				parent.frames[2].document.forms[0].deceased_yn.value = "Y";
			else parent.frames[2].document.forms[0].deceased_yn.value = "N";
			/*modified on 4/18/2009 since post_mortem_request is going as N*/
			if(parent.frames[2].document.DischargePatient_form.post_mortem_request.checked)
				parent.frames[2].document.DischargePatient_form.post_mortem_request.value = 'Y'
			else
				parent.frames[2].document.DischargePatient_form.post_mortem_request.value = 'N'
			/**/

			if (parent.frames[2].document.forms[0].countValue.value != "0")
				getAccompanyingPerson(); 
			var vals = "";
			//vals = "<html><body onKeyDown='lockKey()'><form name='inter_form' id='inter_form' method='post' action='../../servlet/eIP.DischargePatientServlet?accomp_person='"+parent.frames[2].document.forms[0].accomp_person.value+"' >";
			/*Wednesday, September 08, 2010 , SRR20056-SCF-5183 [IN:023731]*/
			var abs_yn	= "N"; // added by mujafar for ML-MMOH-CRF-0659 START
			if(parent.frames[2].document.DischargePatient_form.isModifyDiscTypeStatusAppl.value=="true" && parent.frames[2].document.DischargePatient_form.allow_modify_disc_yn.value=="Y") // added by mujafar for ML-MMOH-CRF-0659
			{
				if(parent.frames[2].document.getElementById('absconding_yn')){
					if(parent.frames[2].document.getElementById('absconding_yn').checked){
						abs_yn	= "Y";
					}
					else
					{
					 parent.frames[2].document.getElementById('absconding_date').value="";
						parent.frames[2].document.getElementById('absconding_rep_to').value="";
						 
					}

				}
			}
			//  added by mujafar for ML-MMOH-CRF-0659 END

			vals = "<html><body onKeyDown='lockKey()'><form name='inter_form' id='inter_form' method='post' action='../../servlet/eIP.DischargePatientServlet' target='messageFrame'>";
			
			for(var i=0;i<parent.frames[2].document.forms[0].elements.length;i++)
			{
				vals += "<input type='hidden' name='"+parent.frames[2].document.forms[0].elements[i].name+"' id='"+parent.frames[2].document.forms[0].elements[i].name+"'value='"+parent.frames[2].document.forms[0].elements[i].value+"'>"
			}
			vals += "<input type='hidden' name='abscon_yn' id='abscon_yn' value='"+abs_yn+"'> </form></body><html>"; // added by mujafar for ML-MMOH-CRF-0659
			
			parent.frames[5].document.write(vals);
			parent.frames[5].document.inter_form.submit();
		}
	}
}

async function callBedAvailChart()
{
	var retVal = 	new String();
	var dialogHeight= "500px" ;
	var dialogWidth	= "800px" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp",arguments,features);
}

function checkUntilDate(object)
{
	var grace_type  = parent.frames[2].document.DischargePatient_form.disdatechkdaysunit.value;
	var system_date = parent.frames[2].document.DischargePatient_form.sysdatetime.value;
	var grace		= parent.frames[2].document.DischargePatient_form.disdatechkdays.value;

	if(object.value != "")
	{
		if(validDateObj(object,"DMYHM",localeName))
		{	
		  	if(grace_type == 'H')
				var graceval = grace ; 
			else if(grace_type == 'D')
				var graceval = grace * 24 ; 

			var greg_date = convertDate(object.value,"DMYHM",localeName,"en");					
			var date_until = system_date;
			var date_from = minusDate(system_date,"DMYHM",'en',graceval,'h')
			var dischrg_date_time = greg_date;
			var DECEASED_DATE_TIME = convertDate(parent.frames[2].document.DischargePatient_form.DECEASED_DATE_TIME.value,"DMYHM",localeName,"en");
			var ip_Trn_Date = parent.frames[2].document.DischargePatient_form.ip_Trn_Date.value;
			var admission_date_time = parent.frames[2].document.DischargePatient_form.admission_date_time.value;
		
			if(isAfter(DECEASED_DATE_TIME,dischrg_date_time,"DMYHM",'en'))
 			{
				/*alert(self.getMessage('DIS_DATE_GT_EXCEEDED','IP'));
				object.focus();
				object.select();
				*/

				var trn_error = self.getMessage("DATE1_LT_DATE2","IP");
				trn_error = trn_error.replace("$",getLabel("Common.dischargedatetime.label","Common"));
				trn_error = trn_error.replace("#",getLabel("Common.deathdatetime.label","Common"));
				alert(trn_error);
				object.focus();
				object.select();

			}else if(!isAfter(dischrg_date_time, date_from,"DMYHM",'en'))
			{
				alert(self.getMessage('DIS_DATE_LT_EXCEEDED','IP'));
				object.focus();
				object.select();
			}else if(isBefore(dischrg_date_time,DECEASED_DATE_TIME,"DMYHM",'en'))
			{
				var trn_error = self.getMessage("DATE1_LT_DATE2","IP");
				trn_error = trn_error.replace("$",getLabel("Common.dischargedatetime.label","Common"));
				trn_error = trn_error.replace("#",getLabel("eIP.DeathTransactionTime.label","IP"));
				alert(trn_error);
				object.select(); 
				object.focus(); 
			}
			else if(!isAfter(dischrg_date_time,admission_date_time,'DMYHM','en')){
			
			var error = getMessage('DIS_DATE_NOT_LESS_ADM_DATE','IP');
			alert(error);
			object.select(); 
			object.focus(); 
			
			}
			else if(!isAfter(dischrg_date_time,ip_Trn_Date,"DMYHM",'en'))
			{
				var trn_error = self.getMessage("DATE1_LT_DATE2","IP");
				trn_error = trn_error.replace("$",getLabel("Common.dischargedatetime.label","Common"));
				trn_error = trn_error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP"));
				alert(trn_error);
				object.select();
				object.focus();
			}
			return true
		}
	}
}

function cancel()
{
	window.parent.close();
}

function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {}
		else{
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
            errors = errors.replace('$',names[i]);
            errors = errors + "\n" ;

		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}


function trimCheck1(inString)
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}


function callValidate(obj)
{
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/DischargeValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value='"+obj+"'><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='Discharge_form'><input type='hidden' name='field5' id='field5' value=''></form></body></html>";
	parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[4].document.forms[0].submit();
}


// added by mujafar for ML-MMOH-CRF-0659 START
function callValidate1(obj)
{
	
	retVal = document.forms[0].dischargetype.value;
	
	var arr = retVal.split("=");
	document.forms[0].discharge_code.value=arr[0];
	document.forms[0].dischage_indicator.value=arr[1]; // discharge_stat
	 
	document.forms[0].discharge_stat.value="";
	document.forms[0].discharge_type.value = document.forms[0].discharge_code.value;
	
	

	if(document.getElementById('ab_details'))
	{	document.getElementById('absconding_date').value="";
		document.getElementById('absconding_yn').checked=false;
		document.getElementById('absconding_rep_to').value="";
		

		document.getElementById('ab_details').style.visibility = "hidden";
	}

	
	if(document.forms[0].medico_legal.value == 'N'){
		document.forms[0].medico_legal.checked			= false ;
		document.forms[0].pol_rep_no.value				= "";
		document.forms[0].pol_stn_id.value				= "";
		document.forms[0].pol_id.value					= "";
	}
	if(document.forms[0].dischage_indicator.value=='DS')
	{
		
		var ds_msg = confirm(getMessage("PATIENT_MARKED_DESEASED","IP"));
		if(parent.frames[2].document.getElementById('ab_details'))
		{
			parent.frames[2].document.getElementById('absconding_yn').value='N';
		
		}
		
		if(ds_msg)
		{
			validateStatus(obj);
		}
		else
		{		
			validateStatus(obj);
		}
	}
	else
	{
		if(document.forms[0].dischage_indicator.value=='AB')
		{ 
			
			
			if(document.getElementById('ab_details'))
			{  
				parent.frames[2].document.DischargePatient_form.absconding_date.value="";
				parent.frames[2].document.DischargePatient_form.AbsImg.style.visibility="hidden";
				document.getElementById('ab_details').style.visibility = "visible";
				parent.frames[2].document.DischargePatient_form.absconding_yn.disabled= false;
				parent.frames[2].document.DischargePatient_form.absconding_yn.checked = false;
				parent.frames[2].document.DischargePatient_form.absconding_date.disabled=true;
				parent.frames[2].document.DischargePatient_form.absconding_yn.value="N";
				parent.frames[2].document.DischargePatient_form.calImage.disabled=true;
			}
			
			parent.frames[2].document.getElementById('deceased_yn').disabled=true;
			parent.frames[2].document.getElementById('deceased_yn').checked=false; 
			parent.frames[2].document.getElementById('deceasedimg').style.visibility="hidden";
			parent.frames[2].document.getElementById("DECEASED_DATE_TIME").disabled=true;
			parent.frames[2].document.getElementById("DECEASED_DATE_TIME").value="";
			parent.frames[2].document.getElementById('calcomp').disabled=true;
			parent.frames[2].document.getElementById('post_mortem_request').disabled=true; 
			parent.frames[2].document.getElementById('body_released_date').disabled=true;
			parent.frames[2].document.getElementById('body_released_date').value="";
			
			if(parent.frames[2].document.getElementById('ab_details'))
			{
			parent.frames[2].document.getElementById('absconding_yn').value='Y';
		
			}
			
			
			
		}
		else 
		if(document.forms[0].dischage_indicator.value=='AO')
		{
			parent.frames[2].document.DischargePatient_form.AbsImg.style.visibility="hidden";
			parent.frames[2].document.getElementById('deceased_yn').disabled=true;
			parent.frames[2].document.getElementById('deceased_yn').checked=false; 
			parent.frames[2].document.getElementById('deceasedimg').style.visibility="hidden";
			parent.frames[2].document.getElementById("DECEASED_DATE_TIME").disabled=true;
			parent.frames[2].document.getElementById("DECEASED_DATE_TIME").value="";
			parent.frames[2].document.getElementById('calcomp').disabled=true;
			parent.frames[2].document.getElementById('post_mortem_request').disabled=true; 
			parent.frames[2].document.getElementById('body_released_date').disabled=true;
			parent.frames[2].document.getElementById('body_released_date').value="";
			
			if(parent.frames[2].document.getElementById('ab_details'))
		{
			parent.frames[2].document.getElementById('absconding_yn').value='N';
		
		}
			
		}
		else
		{  
			parent.frames[2].document.DischargePatient_form.AbsImg.style.visibility="hidden";
			parent.frames[2].document.getElementById('deceased_yn').disabled=true;
			parent.frames[2].document.getElementById('deceased_yn').checked=false; 
			parent.frames[2].document.getElementById('deceasedimg').style.visibility="hidden";
			parent.frames[2].document.getElementById("DECEASED_DATE_TIME").disabled=true;
			parent.frames[2].document.getElementById("DECEASED_DATE_TIME").value="";
			parent.frames[2].document.getElementById('calcomp').disabled=true;
			parent.frames[2].document.getElementById('post_mortem_request').disabled=true; 
			parent.frames[2].document.getElementById('body_released_date').disabled=true;
			parent.frames[2].document.getElementById('body_released_date').value="";
			
			if(parent.frames[2].document.getElementById('ab_details'))
		{
			parent.frames[2].document.getElementById('absconding_yn').value='N';
		
		}
		}
		
		validateStatus(obj);
	}
	
}

function capt_value(obj)
{
	
		parent.frames[2].document.forms[0].discharge_stat.value=obj.value;
	
}

function validateStatus(obj)
{ 
	var HTMLVal = new String();
	
	var indicator = document.forms[0].dischage_indicator.value
	var discharge_type = document.forms[0].dischargetype.value
	
	if((obj.value != null || obj.value != ""))
	{
		HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form_status' id='form_status' method='post' action='../../eIP/jsp/DischargeValidation.jsp'><input type='hidden' name='indicator' id='indicator' value='"+indicator+"'><input type='hidden' name='discharge_type' id='discharge_type' value='"+discharge_type+"'><input type='hidden' name='field4' id='field4' value='Prepare_Discharge_advice'></form></BODY></HTML>";
		parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[4].document.form_status.submit();
	}
}

// added by mujafar for ML-MMOH-CRF-0659 END









//Added by kishore on 8/26/2004
function getBedBlkData()
{
	var discharge_type = parent.frames[2].document.DischargePatient_form.discharge_type.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/DischargeValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value='"+discharge_type+"'><input type='hidden' name='field4' id='field4' value='Discharge_form'><input type='hidden' name='field5' id='field5' value=''></form></body></html>";
	parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[4].document.forms[0].submit();
}

function getBlockBedData1()
{
	var blocking_hrs = parent.frames[2].document.DischargePatient_form.bed_blocking_period.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/DischargeValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='Discharge_form'><input type='hidden' name='field5' id='field5' value='"+blocking_hrs+"'></form></body></html>";
	parent.frames[4].document.write(HTMLVal);
	parent.frames[4].document.forms[0].submit();
}

function ValidateDischargeDate(from,to,val)
{
	var maxhrs = 0;
	var maxdays	= 0;
	var mon = 0;
	var	dayHours = parent.frames[2].document.DischargePatient_form.disdatechkdaysunit.value;
	if(val == 'D')
		maxdays = parent.frames[2].document.DischargePatient_form.disdatechkdays.value;
	else if(val == 'B')
		maxhrs = parent.frames[2].document.DischargePatient_form.dischargeafterhrs.value;
	
	if ((dayHours=="H") && (val=="D"))
	{
		maxhrs	= maxdays;	
		maxdays	= 0;	
	}

	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var hrs =eval(splittime1[0])-eval(maxhrs);
	mon = splitdate1[1]; 

	 //var from_date  =new Date(splitdate1[2], mon, splitdate1[0]-1, hrs,splittime1[1])
	 var from_date  =new Date(splitdate1[2], splitdate1[1]-1,splitdate1[0], splittime1[0], splittime1[1])
	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 var days = eval(maxdays)+eval(splitdate1[0]);
	 mon = splitdate1[1];

	 //var to_date  =new Date(splitdate1[2], mon,days, splittime1[0]-1, splittime1[1])
	 var to_date  =new Date(splitdate1[2], splitdate1[1]-1,splitdate1[0], splittime1[0], splittime1[1])

	 if(val == 'N' || val == 'B') {
		 if(Date.parse(to_date) <= Date.parse(from_date))
			return true;
		 else
			 return false;
	 }//else if(Date.parse(to_date) >= Date.parse(from_date))
		else if(isBefore(to_date,from_date,"DMYHM",localeName))
			return false;
	
		else
			return true;

		
}

function ValidateBlockDate(from,to,val)
{
	var maxhrs = 0;
	var maxdays	= 0;
	var mon = 0;
	var	dayHours = parent.frames[2].document.DischargePatient_form.diag_update_period_max_unit.value;
	if(val == 'D')
		maxdays = parent.frames[2].document.DischargePatient_form.disdatechkdays.value;
	else if(val == 'B')
		maxhrs = parent.frames[2].document.DischargePatient_form.dischargeafterhrs.value;
	
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var hrs =eval(splittime1[0])+eval(maxhrs);
	mon = eval(splitdate1[1]) - 1; // because in the date constructor, months must be specified in the range  0 - 11

	 var from_date  =new Date(splitdate1[2], mon, splitdate1[0], hrs,splittime1[1])
	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 var days = eval(maxdays)+eval(splitdate1[0]);
	mon = eval(splitdate1[1]) - 1;

	 var to_date  =new Date(splitdate1[2], mon,days, splittime1[0], splittime1[1])
	 if(val == 'N' || val == 'B'){
		 if(Date.parse(to_date) <= Date.parse(from_date))
			return true;
		 else
			 return false;
	 }
	 else if(Date.parse(to_date) >= Date.parse(from_date))
		return false;
	 else
		return true;
}

async function callFunctions(val)
{
	var jsp_name = "../../eCommon/blank.html";
	if(val == 'SD')
	{
		jsp_name = "../../eIP/jsp/CurrentEncounterMain.jsp?p_fr_function=IP&encounterId="+parent.frames[2].document.forms[0].encounter_id.value+"&patientId="+parent.frames[2].document.forms[0].patient_id.value;
	}
	else if(val == 'DA')
	{
		jsp_name = "../../eIP/jsp/CancelDischargeAdviceMain.jsp?p_fr_function=IP&encounterId="+parent.frames[2].document.forms[0].encounter_id.value+"&patientId="+parent.frames[2].document.forms[0].patient_id.value+"&enable_height_bmi_pat_cls="+parent.frames[1].document.DischargePatient_form_display.enable_height_bmi_pat_cls.value+"&callfrom=IP&from_function=PD";//Modified by Kamatchi S for ML-MMOH-SCF-1643
	}
	else if(val == 'DD')
	{
		jsp_name = "../../eCA/jsp/PatProblemMain.jsp?Context=IP_Q&stage_desc=Discharge&stage_code=D&Clinic_Code="+parent.frames[2].document.forms[0].nursing_unit_code.value+"&patient_id="+parent.frames[2].document.forms[0].patient_id.value+"&episode_id="+parent.frames[2].document.forms[0].encounter_id.value+"&Practitioner_Id="+parent.frames[2].document.forms[0].practitioner_id.value+"&ip_practitioner_id="+parent.frames[2].document.forms[0].practitioner_id.value+"&IP_YN=Y&location_code="+parent.frames[2].document.forms[0].nursing_unit_code.value+"&locn_type="+parent.frames[2].document.forms[0].locn_type.value+"&patient_class=IP";
	}
	
	var retVal = 	new String();
	if(val == 'DD')
	{	
		dialogHeight="1200px";
		dialogWidth="1200px";
		dialogTop="10px";
	}
	else
	{

	var dialogHeight= "1200px" ;
	var dialogWidth	= "1200px" ;
	var dialogTop = "10px"
	}
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog(jsp_name,arguments,features);
}


function specialChar(obj,val)
{
	if(obj.value!='')
	{
		var fields1 = new Array(obj);
		var names1 = new Array(obj.name.toUpperCase());
		var messageFrame = ""; var error_page = "";
		if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
		{
			if(val=="Num")
			{
				if(CheckNum(obj))
				{
					 return true;
				}
				else 
				{
					 obj.focus();
					 obj.value='';
					 return false;
				}
			}
			else if(val=="Char")
			{
				return true;
			}


			return true;
		}
		else
		{
		   obj.focus()
		   obj.value='';
		   return false;
		}
	}
}

async function getAccompanyingPerson()
{
	var	dialogHeight="60vh";
	var	dialogWidth="49vw";
	var	dialogTop="300";
	var status = "no";
	var arguments	= "" ;
	var  patient = parent.frames[2].document.forms[0].patient_id.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	var jsp_name;

	jsp_name = "../jsp/AccompanyingPersonDetailsFrames.jsp?encounterId="+parent.frames[2].document.forms[0].encounter_id.value;

	retVal = await window.showModalDialog(jsp_name,arguments,features);
	parent.frames[2].document.forms[0].accomp_person.value = retVal;
}



function enablePolice(checkVal)
{
	if (checkVal.checked==true)
	{
		document.forms[0].pol_rep_no.disabled	=	false;
		document.forms[0].pol_stn_id.disabled	=	false;
		document.forms[0].pol_id.disabled		=	false;
	}
	else
	{
		document.forms[0].pol_rep_no.disabled	=	true;
		document.forms[0].pol_stn_id.disabled	=	true;
		document.forms[0].pol_id.disabled		=	true;
		document.forms[0].pol_rep_no.value		=	"";
		document.forms[0].pol_stn_id.value		=	"";
		document.forms[0].pol_id.value			=	"";
	}
}


function getMedicoValues(checkVal)
{
	if (checkVal.checked ==	true)
		document.forms[0].medico_legal.value	=	"Y";
	else if (checkVal.checked == false)
		document.forms[0].medico_legal.value	=	"N";

}

function getPractitionerId(obj,target, aFacilityID)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;

	var nursing_unit_code	= document.forms[0].nursing_unit_code.value;
	var spl_code			= document.forms[0].specialty_code.value;
	if(nursing_unit_code != "")
	{
		if(spl_code != "")
		{
			var facility_id = aFacilityID;
			locale=document.forms[0].locale1.value;

			getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");
			/*
			var sql = " SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)  practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type,  a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND (   UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.sex LIKE (?) AND (a.POSITION_CODE LIKE (?) OR a.POSITION_CODE IS NULL) AND 1 = 1 ";

			var sql2 = "SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)  practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type,  a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND (   UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) and UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.sex LIKE (?) AND (a.POSITION_CODE LIKE (?) OR a.POSITION_CODE IS NULL) AND 1 = 1 ";

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	= "<root><SEARCH " ;
			xmlStr += " practName_FName=\"" +practName_FName + "\"";
			xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
			xmlStr += " sql=\"" +escape(sql)+ "\"";
			xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" + spl_code+ "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";

			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);	

			*/

		}
		else
		{
			var error = getMessage('CAN_NOT_BE_BLANK','Common');
			//error = error.replace('$',getLabel("Common.speciality.label","Common"));
			error = error.replace('$',getLabel("Common.speciality.label","Common"));
			alert(error);	 
		}
	}
	else
	{
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		//error = error.replace('$',getLabel("Common.nursingUnit.label","Common"));
		error = error.replace('$',getLabel("Common.nursingUnit.label","Common"));
		alert(error);	
	}
}


// To set the values to Attending Practitioner when using  
// GeneralPratitionerLookup. It'll be called by the GeneralPratitionerLookup.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (objName=="pract_name")
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practitioner.value=arr[0];
			document.forms[0].pract_name.value=arr[1];			
		}
		else
		{
			document.forms[0].practitioner.value="";
			document.forms[0].pract_name.value="";			
			document.forms[0].pract_name.focus();
		}
	}
	else if (objName=="auth_pract_desc")
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practid.value=arr[0];
			document.forms[0].auth_pract_desc.value=arr[1];			
		}
		else
		{
			document.forms[0].practid.value="";
			document.forms[0].auth_pract_desc.value="";			
			document.forms[0].auth_pract_desc.focus();
		}
	}
	else if (objName=="dischg_pract_desc")
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].dischg_practid.value=arr[0];
			document.forms[0].dischg_pract_desc.value=arr[1];			
		}
		else
		{
			document.forms[0].dischg_practid.value="";
			document.forms[0].dischg_pract_desc.value="";			
			document.forms[0].dischg_pract_desc.focus();
		}
	}
} // End of PractLookupRetVal().


/**********************************************************************
	By Annadurai starts.. to compare discharge date with server date.
	if discharge date is greater than server date, assign server date as
	discharge date. 
***********************************************************************/
function compareServerDate(sysDate)
{
	if ((sysDate.value != "") && (document.forms[0].patient_class_value.value != "DC"))
	{
		if(isAfter(sysDate.value,document.forms[0].server_date.value,"DMYHM", localeName))
		{
		  document.forms[0].discharge_date_time.value=document.forms[0].server_date.value;
		  document.forms[0].discharge_date_time.focus();
		}
	}
}
// By Annadurai End.

function ChkNumberInput1(fld, e, deci)
{
	if (parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';
	
   var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}


function getPractitionerToDELETE(obj,target, aFacilityID)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;

	var ref_to      = '';
	var locn_type 	= '';
	var locn_code	= '';
	var locationArray = new Array();
	locationArray = locn_code.split(":::");
	locn_code = locationArray[0];
	var splty_code	= document.forms[0].speciality.value;
	var sql="";
	var sql2="";
	if (locn_code!="")
	{
		if(locn_type == "C")
		{
			sql = " SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, d.desc_sysdef practitioner_type, e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, f.position_desc job_title  FROM am_practitioner b, am_pract_type d,am_speciality e, am_position f WHERE b.practitioner_id IN (SELECT practitioner_id FROM am_pract_for_facility WHERE facility_id ='"+ref_to+"' AND eff_status = 'E' ) AND b.eff_status = 'E' AND 'Y' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '" +ref_to+ "' AND clinic_code='"+locn_code+"') AND b.primary_speciality_code = e.speciality_code AND b.pract_type = d.pract_type and b.position_code = f.position_code(+) AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(? ,b.practitioner_name)) ) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL) UNION SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,d.desc_sysdef practitioner_type, e.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, f.position_desc job_title  FROM am_practitioner a, am_pract_type d,am_speciality e, am_position f WHERE a.pract_type = d.pract_type and a.position_code = f.position_code(+) and a.primary_speciality_code = e.speciality_code and a.practitioner_id IN ( SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id ='"+ref_to+"' AND clinic_code = '"+locn_code+"' AND eff_status = 'E' ) AND 'N' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code='"+locn_code+"') AND a.eff_status = 'E' ";
			
			sql2 = " SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, d.desc_sysdef practitioner_type, e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, f.position_desc job_title  FROM am_practitioner b, am_pract_type d,am_speciality e, am_position f WHERE b.practitioner_id IN (SELECT practitioner_id FROM am_pract_for_facility WHERE facility_id ='"+ref_to+"' AND eff_status = 'E' ) AND b.eff_status = 'E' AND 'Y' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '" +ref_to+ "' AND clinic_code='"+locn_code+"') AND b.primary_speciality_code = e.speciality_code AND b.pract_type = d.pract_type and b.position_code = f.position_code(+) AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name)) ) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL) UNION SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,d.desc_sysdef practitioner_type, e.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, f.position_desc job_title  FROM am_practitioner a, am_pract_type d, am_speciality e, am_position f WHERE a.pract_type = d.pract_type and a.position_code = f.position_code(+) and a.primary_speciality_code = e.speciality_code and a.practitioner_id IN ( SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id ='"+ref_to+"' AND clinic_code = '"+locn_code+"' AND eff_status = 'E' ) AND 'N' = (SELECT open_to_all_pract_yn FROM op_clinic WHERE facility_id = '"+ref_to+"' AND clinic_code='"+locn_code+"') AND a.eff_status = 'E' ";
		}
		else if(locn_type == "N")
		{
			sql = " SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, f.position_desc job_title FROM am_practitioner b, am_pract_type d,am_speciality e, am_position f WHERE b.practitioner_id IN (SELECT a.practitioner_id FROM ip_nursing_unit_for_pract a WHERE a.facility_id = '"+ref_to+"' AND a.nursing_unit_code = '"+locn_code+"' AND b.eff_status = 'E' )AND b.primary_speciality_code = e.speciality_code AND b.pract_type = d.pract_type and b.position_code = f.position_code(+) AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name)) ) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL) ";	
			
			sql2 = " SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, f.position_desc job_title FROM am_practitioner b, am_pract_type d,am_speciality e, am_position f WHERE b.practitioner_id IN (SELECT a.practitioner_id FROM ip_nursing_unit_for_pract a WHERE a.facility_id = '"+ref_to+"' AND a.nursing_unit_code = '"+locn_code+"' AND b.eff_status = 'E' )AND b.primary_speciality_code = e.speciality_code AND b.pract_type = d.pract_type and b.position_code = f.position_code(+) AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name)) ) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL) ";	
		}
	}
	else
	{
			sql = " SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, f.position_desc job_title FROM ( SELECT practitioner_id, practitioner_name FROM am_pract_for_facility_vw WHERE operating_facility_id = '"+ref_to+"' AND  eff_status='E' AND primary_speciality_code = '"+splty_code+"'  UNION  SELECT practitioner_id,practitioner_name FROM  AM_PRACT_FOR_SPECIALITY_VW  WHERE facility_id ='"+ref_to+"' AND speciality_code ='"+splty_code+"') a, am_practitioner b, am_pract_type d,am_speciality e, am_position f WHERE a.practitioner_id = b.practitioner_id AND b.primary_speciality_code = e.speciality_code AND b.pract_type = d.pract_type and b.position_code = f.position_code(+) AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name)) ) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL) AND (1 = 1) ";

			sql2 = " SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, f.position_desc job_title FROM ( SELECT practitioner_id, practitioner_name FROM am_pract_for_facility_vw WHERE operating_facility_id = '"+ref_to+"' AND  eff_status='E' AND primary_speciality_code = '"+splty_code+"' UNION SELECT practitioner_id,practitioner_name FROM  AM_PRACT_FOR_SPECIALITY_VW  WHERE facility_id ='"+ref_to+"' AND speciality_code ='"+splty_code+"') a, am_practitioner b, am_pract_type d, am_speciality e, am_position f WHERE a.practitioner_id = b.practitioner_id AND b.primary_speciality_code = e.speciality_code AND b.pract_type = d.pract_type and b.position_code = f.position_code(+) AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL) AND (1 = 1) ";
	}

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= "<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + splty_code+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	
} // End of getPractitioner();


async function showValuables()
{
	var retVal =    new String();
	var dialogTop   = "0";
	var dialogHeight    = "80vh" ;
	var dialogWidth = "50vw" ;
	var features    ="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments ="";

	var nursing_unit_code	= parent.frames[2].document.forms[0].nursing_unit_code.value;
	var spl_code			= parent.frames[2].document.forms[0].specialty_code.value;
	var valubl = parent.frames[2].document.forms[0].valubles.value ;

	valubl += parent.frames[2].document.forms[0].recorded_by.value;
	valubl += "||"+parent.frames[2].document.forms[0].recorded_date.value;
	valubl += "||"+parent.frames[2].document.forms[0].valuble_remakrs.value;
	valubl += "||"+parent.frames[2].document.forms[0].witness_desc.value;
	valubl += "||"+parent.frames[2].document.forms[0].witness_id.value;
		
	var url   = "../../eOP/jsp/PatientValuablesMain.jsp?encounter_id="+parent.frames[2].document.forms[0].encounter_id.value+"&patientId="+parent.frames[2].document.forms[0].patient_id.value +"&valuble="+escape(valubl)+"&param=discharge_patient"+"&nursing_unit_code="+nursing_unit_code+"&spl_code="+spl_code;
	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal != null)
	{
		if(retVal != "")
		{
			var contact_vals = new Array();
			contact_vals = retVal;
			var contacts = contact_vals.split("||");
			parent.frames[2].document.forms[0].recorded_by.value = contacts[0];
			parent.frames[2].document.forms[0].recorded_date.value = contacts[1];
			parent.frames[2].document.forms[0].valuble_remakrs.value = contacts[2];
			parent.frames[2].document.forms[0].witness_desc.value = contacts[3];
			parent.frames[2].document.forms[0].witness_id.value = contacts[4];
			
		}
	}
}

function callme(obj)
{
	var sStyle = document.forms[0].sStyle.value;
	var len1=document.forms[0].practitioner.length;
	var j=1;
	while(j<len1)
	{
		len1=document.forms[0].practitioner.length;
		document.forms[0].practitioner.remove(i);
	}

	var ref_to=document.forms[0].referred_to.value;
	var loc_type=document.forms[0].location0.value;
	var location1=document.forms[0].location1.value;
	var open_to_all_pract_yn=document.forms[0].open_to_all_pract_yn.value;

	document.forms[0].practitioner.value="";
	document.forms[0].practitioner1.value="";
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='GetReferralVals.jsp?src1=3&jsp_val=discharge&loc_type="+loc_type+"&ref_to="+ref_to+"&location1="+location1+"&open_to_all_pract_yn="+open_to_all_pract_yn+"'></form></BODY></HTML>";
	parent.frames[4].document.write(HTMLVal);
	parent.frames[4].document.forms[0].submit();
}

function checkForMaximum1(val)
{
	if (val.length>200)
	{
		//alert(getMessage('EXCEED_MAX_LENGTH','SM'));
		var msg = getMessage('REMARKS_CANNOT_EXCEED',"Common");
		msg		= msg.replace("$",getLabel("eIP.InformedOthers.label","IP"));
		msg		= msg.replace("#",200);
		alert(msg);
		document.forms[0].absconding_rep_to.select();
	}
}

function disableAllFields()
{
	if (document.forms[0].inform_to.value == "")
	{
		document.forms[0].inform_to.disabled = false;
		document.forms[0].informed_name.disabled	= true;
		document.forms[0].informed_date.disabled	= true;
		//document.getElementById("calImage").disabled				= true;

		
	}

	if (document.forms[0].inform_to.value != "")
	{
		document.forms[0].inform_to.disabled = true;
		document.forms[0].informed_name.disabled	= true;
		document.forms[0].informed_date.disabled	= true;
		//document.getElementById("calImage").disabled				= true;
	}

	/*if (document.forms[0].inform_to.value == "03")
	{
		document.forms[0].informed_name.disabled	= false;
	}*/

	document.getElementById('im').style.visibility	=	'hidden';

//	if (document.forms[0].dead_yn.value != 'Y')
//	{
		document.getElementById("DECEASED_DATE_TIME").disabled		= true;
		document.getElementById("calcomp").disabled					= true;
//	}

	if(!document.forms[0].medico_legal.checked)
		document.forms[0].medico_legal.value = 'N';
}

//Added for calling Schedule appointments from IP 
async function appointment() //New function for Book Appointment from Checkout
{																	
	var P_patient_id		= document.forms[0].patient_Id.value;	
	var P_locn_code			= document.forms[0].location_code.value;		
	var P_practitioner_id	= document.forms[0].i_practitioner_id.value;	
	var ref_code			= document.forms[0].ref_code.value;	
	var to_specialty_code	= document.forms[0].to_specialty_code.value;	
	var server_date			= document.forms[0].server_date.value;	
	var P_locn_type			= document.forms[0].location_type.value;		

	var retVal = 	new String();
	var dialogHeight= "60vh" ;
	var dialogWidth = "50vw" ;
	var dialogTop 	= "60";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

	var h="i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+P_patient_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&location_code="+P_locn_code+"&referral_id="+ref_code+"&specialty_code="+to_specialty_code+"&recall_date="+server_date+"&locn_type="+P_locn_type+"&callingMode=IP&title=Book Appointment";
	retVal = await window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+P_patient_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&location_code="+P_locn_code+"&referral_id="+ref_code+"&specialty_code="+to_specialty_code+"&recall_date="+server_date+"&locn_type="+P_locn_type+"&callingMode=IP&title=Book Appointment",arguments,features);

	if (retVal != null)
	{
		
		var returnVal = retVal.split("^");
		var mode = returnVal[0];
		h = returnVal[1];
		
		
		if (mode=="1")
		{
			retVal = await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h+"&title=Book Appointment",arguments,features);
			if (retVal=="OP")
				appointment();
		}
		else if (mode=="2")
		{
			retVal = await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h+"&title=Book Appointment",arguments,features);
			if (retVal=="OP")
				appointment();
		}
		else if (mode=="3")
		{
			retVal = await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h+"&title=Book Appointment",arguments,features);
			if (retVal=="OP")
				appointment();
		}
	}
}

// This function will enable all the Referral Details.
function enableReferralDetails()
{
	parent.frames[2].document.forms[0].referral_type.disabled		= false;
	parent.frames[2].document.forms[0].hcare_setting_type.disabled	= false;
	parent.frames[2].document.forms[0].referred_to.disabled			= false;
	parent.frames[2].document.forms[0].priority.disabled			= false;
	parent.frames[2].document.forms[0].preferred_date.disabled		= false;
	parent.frames[2].document.getElementById('preferred_date_cal').disabled		= false;
	parent.frames[2].document.forms[0].speciality.disabled			= false;
	parent.frames[2].document.forms[0].service.disabled				= false;
	parent.frames[2].document.forms[0].location0.disabled			= false;
	parent.frames[2].document.forms[0].location1.disabled			= false;
	parent.frames[2].document.forms[0].location2.disabled			= false;
	parent.frames[2].document.forms[0].pract_name.disabled			= false;
	parent.frames[2].document.forms[0].pract_butt.disabled			= false;
	parent.frames[2].document.forms[0].practitioner1.disabled		= false;
	parent.frames[2].document.forms[0].ref_for_ip.disabled			= false;
}

function checkForMaxPeriod()
{
	//setTimeout('',500);
	
	if(parent.frames[2].document.forms[0].bed_blocking_period.value=='' ||parent.frames[2].document.forms[0].bed_blocking_period.value =='0')
	{
		parent.frames[2].document.forms[0].bed_blocking_period.disabled = false;
		parent.frames[2].document.forms[0].bed_blocking_period.readonly = true;
		parent.frames[2].document.forms[0].bed_block_until.value='';
	}
	var default_param=eval(parent.frames[2].document.forms[0].dischargeafterhrs.value);
	var period_no=eval(parent.frames[2].document.forms[0].bed_blocking_period.value);
	
	if(period_no>0)
	{
		/*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
		if(parent.frames[2].document.forms[0].pseudo_bed_yn.value == "Y" && parent.frames[2].document.forms[0].deactivate_pseudo_bed_yn.value == "Y")
		{
			var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
			error = error.replace('$',getLabel("Common.blocked.label","Common"));	
			alert(error);
			parent.frames[2].document.getElementById('tab2').scrollIntoView({
				  behavior: "smooth",
				    block: "nearest",
					  inline: "start"});
			parent.frames[2].document.forms[0].bed_blocking_period.focus();
			return false;

		}
		else if (eval(parent.frames[2].document.forms[0].bed_blocking_period.value) > eval(parent.frames[2].document.forms[0].dischargeafterhrs.value))
		{
			var error = getMessage('BED_BLK_PRD_CANT_EXCEED','IP');
			error = error.replace('$',getLabel("eIP.BlockPeriod.label","IP"));
			alert(error);
			parent.frames[2].document.getElementById('tab2').scrollIntoView({
				behavior: "smooth",
				  block: "nearest",
					inline: "start"});
			parent.frames[2].document.forms[0].bed_blocking_period.focus();
			return false;
		}
		else 
		{  
			 getBlockBedData1();
			 return true;
		}
	}
}

function validSpecialChars(obj)
{	
	var val = obj.value.toUpperCase();
	obj.value = val;
	if(obj.value == 0)
		obj.value = '';
	var fields=new Array();
	var names=new Array();
	fields[0]=obj; 
	names[0]=getLabel("eIP.BedBlockingPeriod.label","IP");
	if(SpecialCharCheck( fields, names,'',"A",''))
	{
		if(checkForMaxPeriod())
			return true;
		else
			return false;
	}
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

function confirm1(obj)
{
	//Added for AAKH-SCF-0093	
	if(parent.frames[2].document.forms[0].patient_class_value.value == 'DC')
	{
		var nResult = parent.frames[2].dayCareDateCheck(parent.frames[2].document.forms[0].discharge_date_time);
		if(nResult == false)
		{
			return false;
		}
	}
	if(obj.value == '')
	{		
		submitForm();
	}
	else if(validSpecialChars(obj))
	{	
		submitForm();
	}
  //parent.parent.document.getElementById("dialog_tag").close();
}

function enablePolice(obj)
{
	
	if(document.forms[0].medico_legal.checked==true)
	{
		document.forms[0].pol_rep_no.disabled=false;
		document.forms[0].pol_rep_no.value = document.forms[0].pol_rep_no_db.value
		document.forms[0].pol_stn_id.disabled=false;
		document.forms[0].pol_stn_id.value = document.forms[0].pol_stn_id_db.value
		document.forms[0].pol_id.disabled=false;
		document.forms[0].pol_id.value = document.forms[0].pol_id_db.value
		document.forms[0].auth_pract_desc.focus();
	}
	else
	{
			
		document.forms[0].pol_rep_no.value='';
		document.forms[0].pol_rep_no.disabled=true;
		document.forms[0].pol_stn_id.value='';
		document.forms[0].pol_stn_id.disabled=true;
		document.forms[0].pol_id.value='';
		document.forms[0].pol_id.disabled=true;
	
	}
}


function allowOnlyNumbers(event)
{
	if (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 46))
		return true;
	else return false;
}


function checkForMaximum(val)
{
	if (val.length>60)
	{
		var error = getMessage('CANNOT_EXCEED_N_CHARS','IP');
		error = error.replace('$','60');
		alert(error);	
		document.forms[0].bed_block_remarks.select();
	}
}

//Added for the CRF - Bru-HIMS-CRF-157
function getOtherReason()
{
	var div1=document.getElementById("name_div");
	if(document.forms[0].late_discharge_reason.value == "others")
	{
		document.forms[0].hid_late_dis_reason.value ="others";
		div1.style.display="block";
	}
	else
	{
		div1.style.display="none";
		document.forms[0].hid_late_dis_reason.value=document.forms[0].late_discharge_reason.value;
	}

}

function validateLateDischarge()
{
	var div1=document.getElementById("late_reason_div");
	var div2=document.getElementById("name_div");
	var dis_date=document.forms[0].discharge_date_time.value;
	var expected_dis_date=document.forms[0].expected_discharge_date_time.value;
	if (div1 != null )
	{	
		if (isBefore(dis_date,expected_dis_date,"DMYHM",localeName) ){
			document.forms[0].late_discharge_reason.value="";
			div1.style.display="none";
			if (div2 != null)
			{
				div2.style.display="none";
			}			
		}else{
			div1.style.display="block";
		}
	}
}


/*Added By Dharma on 21st Oct 2015 Start*/
function validatePatient(obj,localeName){
	var dateTime	= obj.value;
	var dateTime	= convertDate(dateTime,'DMYHM',localeName,'en');
	var patientId = parent.frames[2].document.forms[0].patient_id.value;
	var encounter_id	= parent.frames[2].document.forms[0].encounter_id.value
	if(patientId!="" && dateTime!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH dateTime=\""+dateTime+"\"  patientId=\""+patientId+"\" encounter_id=\""+encounter_id+"\" action='validate_admision_discharge_date_time' flag='D' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		if(responseText!=""){
			var msg = getMessage("DATE_OVERLAPPING","IP");
			msg		= msg.replace("$",getLabel("Common.dischargedatetime.label","common"));
			msg		= msg.replace("#",responseText);
			alert(msg);
			return false;
			//obj.value	= "";
		}else{
			return true;
		}
	}
}
/*Added By Dharma on 21st Oct 2015 End*/ 

/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/

function calculateBmi() {
	
	var weight = parent.frames[1].document.DischargePatient_form_display.weight_on_admission.value;
	var height = parent.frames[1].document.DischargePatient_form_display.height_on_admission.value;
	var unit = parent.frames[1].document.DischargePatient_form_display.weight_on_admission_unit.value;
	var finalBmi=0;
	var weight_in_grams=0;

	if(weight=='')
	{
	weight=0;
	}
	if(height=='')
	{
	height=0;
	}
	if(unit=="G")
		{
		weight_in_grams=weight/1000;
		}
	if(Number(weight_in_grams > 0) && Number(height > 0))
		{	
	finalBmi = weight_in_grams/(height/100*height/100);
	
	}
	else if(Number(weight > 0) && Number(height > 0))
	{
		finalBmi = weight/(height/100*height/100);
	}

	bmi=finalBmi.toFixed(2);
	parent.frames[1].document.DischargePatient_form_display.bmi.value=bmi;
	parent.frames[2].document.DischargePatient_form.bmi.value= bmi;
	
}

function searchCode(obj,target)
{
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	var sql="";	

    tit=encodeURIComponent(getLabel('eIP.OtherHospital.label','IP'));
    sql="select LONG_DESC description,REFERRAL_CODE code from am_referral where eff_status = 'E' and upper(REFERRAL_CODE) like upper(nvl(?,REFERRAL_CODE)) and upper(LONG_DESC) like upper(nvl(?,LONG_DESC)) order by 2 ";
				
    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal=CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=retVal[1];
}

		
/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/

