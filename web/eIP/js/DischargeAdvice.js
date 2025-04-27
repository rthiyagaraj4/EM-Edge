
async function getPatientFamily()
{
	var	dialogHeight="90vh";
	var	dialogWidth="95vw";
	var	dialogTop="0vh";
	var status = "no";
	var arguments	= "" ;
	var patient = parent.frames[2].document.forms[0].patient_id.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	var jsp_name;
	jsp_name = "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID=" + patient;
	retVal = await window.showModalDialog(jsp_name,arguments,features);
}

async function callFunctions(val)
{	

	var jsp_name = "";
	var function_id=parent.frames[2].document.forms[0].function_id.value; //Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
	if(val == 'DD')
	{
//		jsp_name = "../../eCA/jsp/PatProblemMain.jsp?Context=IP_Q&stage_desc=Discharge&stage_code=D&Clinic_Code="+parent.frames[2].document.forms[0].nursingunitcode.value+"&Dob="+parent.frames[2].document.forms[0].DOB.value+"&Sex="+parent.frames[2].document.forms[0].gender.value+"&patient_id="+parent.frames[2].document.forms[0].patient_id.value+"&episode_id="+parent.frames[2].document.forms[0].encounter_id.value+"&ip_practitioner_id="+parent.frames[2].document.forms[0].practitioner_id.value+"&IP_YN=Y&location_code="+parent.frames[2].document.forms[0].nursingunitcode.value+"&locn_type=";
		
		jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?IP_YN=Y&modal_yn=Y&speciality_code="+parent.frames[2].document.forms[0].SplCode.value+"&practitioner_type="+parent.frames[2].document.forms[0].practitioner_type.value+"&practitioner_id="+parent.frames[2].document.forms[0].practitioner_id.value+"&Dob="+parent.frames[2].document.forms[0].DOB.value+"&Sex="+parent.frames[2].document.forms[0].gender.value+"&bed_num="+parent.frames[2].document.forms[0].bedno.value+"&encounter_id="+parent.frames[2].document.forms[0].encounter_id.value+"&episode_id="+parent.frames[2].document.forms[0].encounter_id.value+"&episode_type=I&Locn_Code="+parent.frames[2].document.forms[0].nursingunitcode.value+"&location_type=W&patient_class="+parent.frames[2].document.forms[0].patient_class_value.value+"&patient_id="+parent.frames[2].document.forms[0].patient_id.value+"&room_num="+parent.frames[2].document.forms[0].roomno.value+"&visit_adm_date="+parent.frames[2].document.forms[0].admissiondatetime.value+"&function_id="+parent.frames[2].document.forms[0].function_id.value; //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
	}

	var retVal = 	new String();
	if(val == 'DD')
	{	
		var dialogHeight="95vh";
		var dialogWidth="95vw"; //Modified for GDOH-CRF-0082
		var dialogTop="0vh";
	}
	var status = "no";
	var arguments	="";
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	if(parent.frames[2].document.forms[0].is_ca_yn.value=='Y'){
		var bodwidth  = window.screen.width+window.screen.width;
		var	bodheight = window.screen.height+window.screen.height;
		//Modified for the Incident No : 46813
		var features_ca	= "dialogHeight:" + bodheight + "; dialogTop:" + dialogTop + "; dialogWidth:" + bodwidth +" ; scroll=no; status:" + status;
		retVal = await top.window.showModalDialog(jsp_name,arguments,features_ca);
		//retVal = window.open(jsp_name,arguments,"height="+bodheight+",width="+bodwidth+",top=0,status=0,toolbar=no,menubar=no,location=no,left=0,right=0,bottom=0,this.minimise=no");
	}else{
		retVal = await top.window.showModalDialog(jsp_name,arguments,features);
		}
	//Added for the Incident No : 46813
	if(parent.frames[1].document.forms[0].mds_chk.value>0)
		{
		var jsp_url=parent.frames[1].document.location.href;
    //added for ML-MMOH-SCF-1643 by kamatchi S
		parent.frames[2].document.forms[0].weight_on_admission_load.value=parent.frames[1].document.forms[0].weight_on_admission.value;
		if(parent.frames[1].document.forms[0].height_on_admission)
		parent.frames[2].document.forms[0].height_on_admission_load.value=parent.frames[1].document.forms[0].height_on_admission.value;
		if(parent.frames[1].document.forms[0].bmi)
		parent.frames[2].document.forms[0].bmi_load.value=parent.frames[1].document.forms[0].bmi.value;
		parent.frames[1].document.location.href=jsp_url+"&reload_yn=Y";
		}
    }

function CloseWin()
{
	 if(parent.frames[2].document.forms[0].is_ca_yn.value=='Y') 
	 { 
		document.location.href = "../../eCommon/html/blank.html" 
		parent.frames[2].document.location.href = '../../eCommon/html/blank.html'
		parent.frames[1].document.location.href = '../../eCommon/html/blank.html'
		parent.frames[3].document.location.href = '../../eCommon/html/blank.html'
	 }
	else{    
		//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		//dialogTag.close();
window.close();
	}
}


function resetVals()
{
	parent.frames[2].document.dischargeadvice_form.reset();
	parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled = true;
}

async function Record(obj)
{
	
	/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
	var is_validate_weight_on_admission		= parent.frames[1].document.Display_Form.is_validate_weight_on_admission.value;
	var is_value_already_captured			= parent.frames[1].document.Display_Form.is_value_already_captured.value;
	var weight_on_admission					= parent.frames[1].document.Display_Form.weight_on_admission.value;
	var weight_on_admission_unit			= parent.frames[1].document.Display_Form.weight_on_admission_unit.value;

	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 */
	var isHeightAndBmiEnable = parent.frames[2].document.dischargeadvice_form.isHeightAndBmiEnable.value;
	var enable_height_bmi_pat_cls           =parent.frames[1].document.Display_Form.enable_height_bmi_pat_cls.value;
	var is_value_already_captured_height = parent.frames[1].document.Display_Form.is_value_already_captured_height.value;
	var patient_class						=parent.frames[2].document.dischargeadvice_form.patient_class_value.value;
	if(isHeightAndBmiEnable=="true")
	{
	if(enable_height_bmi_pat_cls==patient_class|| enable_height_bmi_pat_cls==("ID")) 
	{
	var is_validate_height_on_admission		= parent.frames[1].document.Display_Form.is_validate_height_on_admission.value;
	var height_on_admission					= parent.frames[1].document.Display_Form.height_on_admission.value;
	var height_on_admission_unit			= parent.frames[1].document.Display_Form.height_on_admission_unit.value;
	}
	}
	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	var isAadharCardAndRelAppl = parent.frames[2].document.dischargeadvice_form.isAadharCardAndRelAppl.value;
	var citizen_yn			   = parent.frames[2].document.dischargeadvice_form.citizen_yn.value;
	var alt_id4_type_desc	   = parent.frames[2].document.dischargeadvice_form.alt_id4_type_desc.value;
	var alt_id4_type		   = parent.frames[2].document.dischargeadvice_form.alt_id4_type.value;
	/*End GHL-CRF-0505*/

	if(is_validate_weight_on_admission=="Y"){
		if(weight_on_admission==""){
			var err = getMessage("CAN_NOT_BE_BLANK","Common");
			err = err.replace('$',getLabel('eIP.WeightOnAdmission.label','IP'));
			alert(err);
			parent.frames[1].document.Display_Form.weight_on_admission.focus();
			return false;
		}
	}
	if(is_value_already_captured=="Y" && weight_on_admission==""){
		var err = getMessage("VALUE_ALREADY_CAPTURED","IP");
			alert(err);
		parent.frames[1].document.Display_Form.weight_on_admission.focus();
		return false;
	}
	
	if(weight_on_admission!=""){
		var chk_weight_on_admission	= parseFloat(weight_on_admission);
		if(chk_weight_on_admission <= 0){
			var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO","Common");
			msg = msg.replace('Value',getLabel("eIP.WeightOnAdmission.label","IP") );
			alert(msg);
			parent.frames[1].document.Display_Form.weight_on_admission.focus();
			return false;
		}
		
		if(!(/^\d{1,8}(?:\.\d{1,3})?$/).test(weight_on_admission)){//Decimal validation
			var msg = getMessage("INVALID_WEIGHT_ON_ADMISSION","IP");
			alert(msg);
			 parent.frames[1].document.Display_Form.weight_on_admission.focus();
			
			return false;
		}
	}
	if(weight_on_admission==""){
		weight_on_admission_unit	= "";
	}
	parent.frames[2].document.dischargeadvice_form.weight_on_admission.value	 = weight_on_admission;
	parent.frames[2].document.dischargeadvice_form.weight_on_admission_unit.value = weight_on_admission_unit;
	/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 */
	if(isHeightAndBmiEnable=="true")
	{	
		if((enable_height_bmi_pat_cls==patient_class|| enable_height_bmi_pat_cls=="ID") )
		{
			
			if(height_on_admission=="" && is_validate_height_on_admission=="Y")
			{
				
				var err = getMessage("CAN_NOT_BE_BLANK","Common");
				err = err.replace('$',getLabel('eIP.HeightOnAdmission.label','IP'));
				alert(err);
				parent.frames[1].document.Display_Form.height_on_admission.focus();
				return false;
			}
		
			if(is_value_already_captured_height=="Y" && height_on_admission=="")
			{
			
				var err = getMessage("VALUE_ALREADY_CAPTURED_HEIGHT","IP");
					alert(err);
				parent.frames[1].document.Display_Form.height_on_admission.focus();
				return false;
			}
			if(height_on_admission!="")
			{
			
				var chk_height_on_admission	= parseFloat(height_on_admission);
				if(chk_height_on_admission <= 0)
				{
					
					var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO","Common");
					msg = msg.replace('Value',getLabel("eIP.HeightOnAdmission.label","IP") );
					alert(msg);
					parent.frames[1].document.Display_Form.height_on_admission.focus();
					return false;
				}
				if(!(/^\d{1,8}(?:\.\d{1,3})?$/).test(height_on_admission))
				{//Decimal validation
					
					var msg = getMessage("INVALID_HEIGHT_ON_ADMISSION","IP");
					alert(msg);
					parent.frames[1].document.Display_Form.height_on_admission.focus();
					
					return false;
				}
			}
			if(height_on_admission=="")
			{
				height_on_admission_unit	= "";
			}
			parent.frames[2].document.dischargeadvice_form.height_on_admission.value	 = height_on_admission;
			parent.frames[2].document.dischargeadvice_form.height_on_admission_unit.value = height_on_admission_unit;
		}
	}
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
	var status = "Y";
	if(parent.frames[2].document.dischargeadvice_form.expecteddischargedate.value.length <= 0 )
	{
		status = "N";
		var err = getMessage("CAN_NOT_BE_BLANK","Common");
		err = err.replace('$',getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
		alert(err);
		//parent.frames[2].document.getElementById("tab1").scrollIntoView();
		/*Monday, January 25, 2010 18542*/
		parent.frames[2].expandCollapse('Discharge_Details_tab');
		parent.frames[2].document.dischargeadvice_form.expecteddischargedate.focus();
		return;
	}

	if(parent.frames[2].document.dischargeadvice_form.dischargetype.value.length <= 0 )
	{
		status = "N";
		var err = getMessage("CAN_NOT_BE_BLANK","Common");
		err = err.replace('$',getLabel('Common.dischargetype.label','Common'))
		alert(err);
		//parent.frames[2].document.getElementById("tab1").scrollIntoView();
		/*Monday, January 25, 2010 18542*/
		parent.frames[2].expandCollapse('Discharge_Details_tab');
		parent.frames[2].document.dischargeadvice_form.dischargetype.focus();
		return;
	}
	/*modified on 3/07/2008 for SCR 3228*/
	if(parent.frames[2].document.dischargeadvice_form.dischargestatus.value.length <= 0 )
	{
		status = "N";
		var err = getMessage("CAN_NOT_BE_BLANK","Common");
		err = err.replace('$',getLabel('eIP.DischargeStatus.label','IP'))
		alert(err);
		//parent.frames[2].document.getElementById("tab1").scrollIntoView();
		/*Monday, January 25, 2010 18542*/
		parent.frames[2].expandCollapse('Discharge_Details_tab');
		parent.frames[2].document.dischargeadvice_form.dischargestatus.focus();
		return;
	}
	/**/
	/*Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-jun-2020*/
	if(isHeightAndBmiEnable=="true")
	{
		if(parent.frames[2].document.dischargeadvice_form.dischage_indicator.value=='ED')
		{
			if(parent.frames[2].document.dischargeadvice_form.discharge_to.value=='')
			{
				
				status = "N";
				var err = getMessage("CAN_NOT_BE_BLANK","Common");
				err = err.replace('$',getLabel("eIP.DischargeTo.label","IP"));
				alert(err);
				parent.frames[2].expandCollapse('Discharge_Details_tab');
				parent.frames[2].document.dischargeadvice_form.discharge_to.focus();
				return;
			}
		}
	}
    /*Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-jun-2020*/

	if(parent.frames[2].document.dischargeadvice_form.inform_to.value != "")
	{
		if(parent.frames[2].document.dischargeadvice_form.informed_date.value <= 0)
		{
			status = "N";
			var err = getMessage("CAN_NOT_BE_BLANK","Common");
			err = err.replace('$',getLabel('Common.InformedDate/Time.label','Common'))
			alert(err);
			//parent.frames[2].document.getElementById("tab1").scrollIntoView();
			/*Monday, January 25, 2010 18542*/
			parent.frames[2].expandCollapse('Discharge_Details_tab');
			parent.frames[2].document.dischargeadvice_form.informed_date.focus();
			return;
		}
	}
	
	if(parent.frames[2].document.dischargeadvice_form.dischargetype.value != "")
	{
		if( (parent.frames[2].document.dischargeadvice_form.dischage_indicator.value=="AB") && (parent.frames[2].document.dischargeadvice_form.absconding_yn.checked==true) && (parent.frames[2].document.dischargeadvice_form.absconding_date.value <= 0 ) )
		{
			status = "N";
			var err = getMessage("CAN_NOT_BE_BLANK","Common");
			err = err.replace('$',getLabel("eIP.AbscondingDateTime.label","IP"))
			alert(err);
			//parent.frames[2].document.getElementById("tab1").scrollIntoView();
			/*Monday, January 25, 2010 18542*/
			parent.frames[2].expandCollapse('Discharge_Details_tab');
			parent.frames[2].document.dischargeadvice_form.absconding_date.focus();
			return;
		}

		if(parent.frames[2].document.dischargeadvice_form.dischage_indicator.value=="DS")
		{
			if(parent.frames[2].document.dischargeadvice_form.death_date.value=='')
			{
				status = "N";
				var err = getMessage("CAN_NOT_BE_BLANK","Common");
				err = err.replace('$',getLabel("Common.deathdatetime.label","Common"));
				alert(err);
				//parent.frames[2].document.getElementById("tab1").scrollIntoView();
				/*Monday, January 25, 2010 18542*/
				parent.frames[2].expandCollapse('Discharge_Details_tab');
				parent.frames[2].document.dischargeadvice_form.death_date.focus();
				return;
			}

			/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
			if(isAadharCardAndRelAppl == "true" && citizen_yn == "Y" && alt_id4_type != "")
			{
				if(parent.frames[2].document.dischargeadvice_form.aadhar_card.value=='')
				{
					status = "N";
					var err = getMessage("CAN_NOT_BE_BLANK","Common");
					err = err.replace('$',alt_id4_type_desc);
					alert(err);
					parent.frames[2].expandCollapse('Discharge_Details_tab');
					parent.frames[2].document.dischargeadvice_form.aadhar_card.focus();
					return;
				}

				if(parent.frames[2].document.dischargeadvice_form.relationship.value=='')
				{
					status = "N";
					var err = getMessage("CAN_NOT_BE_BLANK","Common");
					err = err.replace('$',getLabel("Common.relationship.label","Common"));
					alert(err);
					parent.frames[2].expandCollapse('Discharge_Details_tab');
					parent.frames[2].document.dischargeadvice_form.relationship.focus();
					return;
				}
			}
			/*End GHL-CRF-0505*/
			/*Added by Ajay Hatwate for AAKH-CRF-0179*/
			var enable_death_reg_form=parent.frames[2].document.dischargeadvice_form.enable_death_reg_form.value;
			var isDeathRegisterFormAppl=parent.frames[2].document.dischargeadvice_form.isDeathRegisterFormAppl.value;
			var death_reg_form_accession_num=parent.frames[2].document.dischargeadvice_form.death_reg_form_accession_num.value;
		    if(enable_death_reg_form=='Y' && isDeathRegisterFormAppl == 'true'){
		    	if(death_reg_form_accession_num!=''){
		    	var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH death_reg_form_accession_num=\""+death_reg_form_accession_num+"\" action=\"CheckAccNumbSigned\" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eMP/jsp/MPIntermediate.jsp",false);
				xmlHttp.send(xmlDoc);
				var isSigned=trimString(xmlHttp.responseText);
				if(isSigned=='N'){
					status='N';
					var error = getMessage('DEATH_REG_FORM_HAS_TO_BE_SIGNED','COMMON');
			    	alert(error);
					parent.frames[2].document.dischargeadvice_form.callback_mode.value = 'Add';
			    	return;
				}
		    	}else{
		    		status = "N";
			    	var error = getMessage('DEATH_REG_FORM_HAS_TO_BE_SIGNED','COMMON');
			    	alert(error);	
					parent.frames[2].document.dischargeadvice_form.callback_mode.value = 'Add';
			    	return;
		    	}	
		    }
		    /* End of AAKH-CRF-0179 */			
		}
	}
	if(parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked == true)
	{
		if(parent.frames[2].document.dischargeadvice_form.death_date.value=='')
		{
			status = "N";
			var err = getMessage("CAN_NOT_BE_BLANK","Common");
			err = err.replace('$',getLabel("Common.deathdatetime.label","Common"));
			alert(err);
			//parent.frames[2].document.getElementById("tab1").scrollIntoView();
			/*Monday, January 25, 2010 18542*/
			parent.frames[2].expandCollapse('Discharge_Details_tab');
			parent.frames[2].document.dischargeadvice_form.death_date.focus();
			return;
		}
	}
	

	if(parent.frames[2].document.dischargeadvice_form.dischargetype.value =='D' || parent.frames[2].document.dischargeadvice_form.dischargetype.value =='A')
	{	
		if(parent.frames[2].document.dischargeadvice_form.inform_to.value.length <= 0 )
		{
			status = "N";
			var err = getMessage("CAN_NOT_BE_BLANK","Common");
			err = err.replace('$',getLabel('eIP.InformedTo.label','IP'));
			alert(err);
			//parent.frames[2].document.getElementById("tab1").scrollIntoView();
			/*Monday, January 25, 2010 18542*/
			parent.frames[2].expandCollapse('Discharge_Details_tab');
			parent.frames[2].document.dischargeadvice_form.inform_to.focus();
		}
		return;
	}

	if(parent.frames[2].document.dischargeadvice_form.auth_pract_desc.value.length <= 0 )
	{

		status = "N";
		var err = getMessage("CAN_NOT_BE_BLANK","Common");
		err = err.replace('$',getLabel('eIP.AuthorizedPractitioner.label','IP'));
		alert(err);
		//parent.frames[2].document.getElementById("tab1").scrollIntoView();
		/*Monday, January 25, 2010 18542*/
		parent.frames[2].expandCollapse('Discharge_Details_tab');
		parent.frames[2].document.dischargeadvice_form.auth_pract_desc.focus();
		return;
	}	
	if(parent.frames[2].document.dischargeadvice_form.dischargetype.value != "")
	{
		var locale = parent.frames[2].document.dischargeadvice_form.locale1.value;
		if((parent.frames[2].document.dischargeadvice_form.absconding_yn.checked==true) && (parent.frames[2].document.dischargeadvice_form.dischage_indicator.value=="AB") && (parent.frames[2].document.dischargeadvice_form.absconding_date.value != "") && (parent.frames[2].document.dischargeadvice_form.patient_class_value.value == "IP") && (parent.frames[2].document.dischargeadvice_form.absconding_date.disabled == false))
		{
			var abs_date = parent.frames[2].document.dischargeadvice_form.absconding_date.value;
			var trn_date = parent.frames[2].document.dischargeadvice_form.ip_Trn_Date.value;
			var greg_abs_date = parent.frames[2].convertDate(abs_date,"DMYHM",locale,"en")
				
			//if(parent.frames[2].isAfter(trn_date,greg_abs_date,"DMYHM",locale))
			if(!parent.frames[2].isBefore(trn_date,greg_abs_date,"DMYHM",locale))
			{			
				var error = parent.frames[2].getMessage("DATE1_LT_DATE2","IP");

				error = error.replace("$",getLabel("eIP.AbscondingDateTime.label","IP"));
				error = error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP"));
				alert(error);
				status = "N";
				//parent.frames[2].document.getElementById("tab1").scrollIntoView();
				/*Monday, January 25, 2010 18542*/
				parent.frames[2].expandCollapse('Discharge_Details_tab');
				if(parent.frames[2].document.dischargeadvice_form.absconding_date.disabled == false)
					parent.frames[2].document.dischargeadvice_form.absconding_date.focus();
				return;
			}
			
			if (status=="Y")
			{	
				var abs_date = parent.frames[2].document.dischargeadvice_form.absconding_date.value;
				var sys_date = parent.frames[2].document.dischargeadvice_form.system_date_time.value;
				var greg_abs_date = parent.frames[2].convertDate(abs_date,"DMYHM",locale,"en")
				//if(parent.frames[2].isAfter(greg_abs_date,sys_date,"DMYHM",locale))
				if(!parent.frames[2].isBefore(greg_abs_date,sys_date,"DMYHM",locale))
				{
					var error = parent.frames[2].getMessage("DATE1_GT_DATE2","IP");
					error = error.replace("$",getLabel("eIP.AbscondingDateTime.label","IP"));
					error = error.replace("#",getLabel("Common.SystemDateTime.label","Common"));
					alert(error);
					status = "N";
					//parent.frames[2].document.getElementById("tab1").scrollIntoView();
					/*Monday, January 25, 2010 18542*/
					parent.frames[2].expandCollapse('Discharge_Details_tab');
					if(parent.frames[2].document.dischargeadvice_form.absconding_date.disabled == false)
						parent.frames[2].document.dischargeadvice_form.absconding_date.focus();
					return;
				}
			}

		}
	}
	
	/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
	var isDeceasedDiagClassDeathRegAppl = document.Discahrge_button_form.isDeceasedDiagClassDeathRegAppl.value;
	var facility_id = document.Discahrge_button_form.facility_id.value;
	var patient_id = parent.frames[2].document.dischargeadvice_form.patient_id.value;
	var encounter_id = parent.frames[2].document.dischargeadvice_form.encounter_id.value;

	if(isDeceasedDiagClassDeathRegAppl == "true"){

		if(parent.frames[2].document.dischargeadvice_form.dischage_indicator.value == "DS"){

			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" encounter_id=\""+encounter_id+"\" facility_id=\""+facility_id+"\" action='getDiagClassCDUDCount' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			var DiagClassCDUDCount = trimString(responseText);

			var arr = DiagClassCDUDCount.split("~");
			var both_pri_sec_count = arr[0];
			var pri_count = arr[1];
			var sec_count = arr[2];

			var display_message_yn = "N";
			var display_message = "";

			if(parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked == true){

				if(parent.frames[2].document.dischargeadvice_form.patient_class_value.value == "IP"){

					if(document.Discahrge_button_form.pri_mand_postmortem_ip_yn.value == "Y" && document.Discahrge_button_form.sec_mand_postmortem_ip_yn.value == "Y"){
						if(both_pri_sec_count == ""){
							display_message_yn = "Y";
							display_message = "PRISECNR";
						}
					}

					else if(document.Discahrge_button_form.pri_mand_postmortem_ip_yn.value == "Y" && document.Discahrge_button_form.sec_mand_postmortem_ip_yn.value == "N"){
						if(pri_count == ""){
							display_message_yn = "Y";
							display_message = "PRINR";
						}
					}

					else if(document.Discahrge_button_form.pri_mand_postmortem_ip_yn.value == "N" && document.Discahrge_button_form.sec_mand_postmortem_ip_yn.value == "Y"){
						if(sec_count == ""){
							display_message_yn = "Y";
							display_message = "SECNR";
						}
					}
				}

				else if(parent.frames[2].document.dischargeadvice_form.patient_class_value.value == "DC"){
					
					if(document.Discahrge_button_form.pri_mand_postmortem_dc_yn.value == "Y" && document.Discahrge_button_form.sec_mand_postmortem_dc_yn.value == "Y"){
						if(both_pri_sec_count == ""){
							display_message_yn = "Y";
							display_message = "PRISECNR";
						}
					}

					else if(document.Discahrge_button_form.pri_mand_postmortem_dc_yn.value == "Y" && document.Discahrge_button_form.sec_mand_postmortem_dc_yn.value == "N"){
						if(pri_count == ""){
							display_message_yn = "Y";
							display_message = "PRINR";
						}
					}

					else if(document.Discahrge_button_form.pri_mand_postmortem_dc_yn.value == "N" && document.Discahrge_button_form.sec_mand_postmortem_dc_yn.value == "Y"){
						if(sec_count == ""){
							display_message_yn = "Y";
							display_message = "SECNR";
						}
					}
				}
			}

			else if(parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked == false){

				if(parent.frames[2].document.dischargeadvice_form.patient_class_value.value == "IP"){

					if(document.Discahrge_button_form.pri_mand_non_postmortem_ip_yn.value == "Y" && document.Discahrge_button_form.sec_mand_non_postmortem_ip_yn.value == "Y"){
						if(both_pri_sec_count == ""){
							display_message_yn = "Y";
							display_message = "PRISECNR";
						}
					}

					else if(document.Discahrge_button_form.pri_mand_non_postmortem_ip_yn.value == "Y" && document.Discahrge_button_form.sec_mand_non_postmortem_ip_yn.value == "N"){
						if(pri_count == ""){
							display_message_yn = "Y";
							display_message = "PRINR";
						}
					}

					else if(document.Discahrge_button_form.pri_mand_non_postmortem_ip_yn.value == "N" && document.Discahrge_button_form.sec_mand_non_postmortem_ip_yn.value == "Y"){
						if(sec_count == ""){
							display_message_yn = "Y";
							display_message = "SECNR";
						}
					}
				}

				else if(parent.frames[2].document.dischargeadvice_form.patient_class_value.value == "DC"){

					if(document.Discahrge_button_form.pri_mand_non_postmortem_dc_yn.value == "Y" && document.Discahrge_button_form.sec_mand_non_postmortem_dc_yn.value == "Y"){
						if(both_pri_sec_count == ""){
							display_message_yn = "Y";
							display_message = "PRISECNR";
						}
					}

					else if(document.Discahrge_button_form.pri_mand_non_postmortem_dc_yn.value == "Y" && document.Discahrge_button_form.sec_mand_non_postmortem_dc_yn.value == "N"){
						if(pri_count == ""){
							display_message_yn = "Y";
							display_message = "PRINR";
						}
					}

					else if(document.Discahrge_button_form.pri_mand_non_postmortem_dc_yn.value == "N" && document.Discahrge_button_form.sec_mand_non_postmortem_dc_yn.value == "Y"){
						if(sec_count == ""){
							display_message_yn = "Y";
							display_message = "SECNR";
						}
					}
				}
			}

			if(display_message_yn == "Y"){
				var xmlDoc=""
				var xmlHttp = new XMLHttpRequest()
				xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" encounter_id=\""+encounter_id+"\" facility_id=\""+facility_id+"\" action='getLinkedYn' /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText = xmlHttp.responseText
				var linked_yn = trimString(responseText);

				if(linked_yn == "Y"){
					display_message_yn = 'N';
				}
			}
			
			if(display_message_yn == "Y"){

				status = "N";

				var location_code = parent.frames[2].document.dischargeadvice_form.nursingunitcode.value;
				var speciality_code = parent.frames[2].document.dischargeadvice_form.SplCode.value;				
				var practitioner_id = parent.frames[2].document.dischargeadvice_form.practitioner_id.value;
				var practitioner_type = parent.frames[2].document.dischargeadvice_form.practitioner_type.value;
				var gender = parent.frames[2].document.dischargeadvice_form.gender.value;
				var date_of_birth = parent.frames[2].document.dischargeadvice_form.DOB.value;	
				var visit_adm_date_time = parent.frames[2].document.forms[0].admissiondatetime.value;
				var bed_num = parent.frames[2].document.forms[0].bedno.value;
				var room_num = parent.frames[2].document.forms[0].roomno.value;
				var patient_class = parent.frames[2].document.dischargeadvice_form.patient_class_value.value;

				var	dialogHeight = "10";
				var	dialogWidth = "25";
				var	dialogTop = "350";
				var status = "no";
				var arguments= "";
				var features = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +"; scroll=yes; status:" + status;
				var jsp_name;
				jsp_name = "../../eIP/jsp/DisplayDiagValidationMsg.jsp?display_message="+display_message+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_code="+location_code+"&location_type=W&speciality_code="+speciality_code+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&gender="+gender+"&date_of_birth="+date_of_birth+"&visit_adm_date_time="+visit_adm_date_time+"&bed_num="+bed_num+"&room_num="+room_num+"&patient_class="+patient_class+"&facility_id="+facility_id;
				retVal = window.showModalDialog(jsp_name,arguments,features);
			}
		}
	}
	/*End ML-MMOH-CRF-1742*/

	if (status == "Y")
	{
		
		parent.frames[2].document.dischargeadvice_form.action="../../servlet/eIP.DischargeAdviceServlet";

		if(parent.frames[2].document.dischargeadvice_form.absconding_yn.disabled)
		parent.frames[2].document.dischargeadvice_form.absconding_yn.disabled = false

		if(parent.frames[2].document.dischargeadvice_form.absconding_rep_to.disabled)
		parent.frames[2].document.dischargeadvice_form.absconding_rep_to.disabled = false

		if(parent.frames[2].document.dischargeadvice_form.informed_name.disabled)
		parent.frames[2].document.dischargeadvice_form.informed_name.disabled = false

		if(parent.frames[2].document.dischargeadvice_form.informed_date.disabled)
		parent.frames[2].document.dischargeadvice_form.informed_date.disabled = false

		if(parent.frames[2].document.dischargeadvice_form.absconding_date.disabled)
		parent.frames[2].document.dischargeadvice_form.absconding_date.disabled = false

		parent.frames[2].document.forms[0].medico_legal.disabled=false;
		parent.frames[2].document.forms[0].pol_rep_no.disabled=false;
		parent.frames[2].document.forms[0].pol_stn_id.disabled=false;
	    parent.frames[2].document.forms[0].pol_id.disabled=false;

		/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
		if(isAadharCardAndRelAppl == "true" && citizen_yn == "Y" && alt_id4_type != "")
		{
			if(parent.frames[2].document.dischargeadvice_form.aadhar_card.disabled)
			parent.frames[2].document.dischargeadvice_form.aadhar_card.disabled = false
		}
		/*End GHL-CRF-0505*/

		/*
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST","../../eMR/jsp/AdverseEventType.jsp?validate=MULT_USER_BLOCK&encounter_id="+parent.frames[2].document.forms[0].encounter_id.value,false);
		xmlHttp.send(null);
		responseText=xmlHttp.responseText;  
		responseText = trimString(responseText);
		var proceed = responseText.split(",");
		var proceed1 = proceed[0].split("");
		if (proceed1[0]=="Y"){*/
		obj.disabled = "true";
		parent.frames[2].document.dischargeadvice_form.target='messageFrame1';
		parent.frames[2].document.dischargeadvice_form.submit();
		/*}
		else if (proceed1[0]=='N'){
			var msg=getMessage("ENC_ALREADY_MODIFIED","IP");
			alert(msg);
			parent.window.close();
		}*/
	}					
}

function focusNext()
{	}

async function OpenMedCert()
{
	var dialogHeight= "40vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop 	= "72" ;
	var center 	= "1" ;														   
	var status	= "no";
	var scroll	= "no";
	var EncounterId   = parent.frames[2].document.forms[0].encounter_id.value;	
	var SickLeaveDetails=parent.frames[2].document.forms[0].SickLeaveDetails.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
	var arguments	= "" ;
	var url = "../../eMR/jsp/SickLeaveMain.jsp?EncounterId="+EncounterId+"&SickLeaveDetails="+escape(SickLeaveDetails);

	retVal = await window.showModalDialog(url,arguments,features);

		
	if (retVal ==""||retVal ==null)
	{
		parent.frames[2].document.forms[0].SickLeaveRecordFlag.value="N";
		parent.frames[2].document.forms[0].SickLeaveDetails.value="";
		parent.frames[2].document.forms[0].SickLeaveDetails1.value="";
	}
	else
	{
	/*	while(retVal.indexOf('¤') != -1)
		{
			retVal = retVal.replace('¤','~');
		}
	*/	
		parent.frames[2].document.forms[0].SickLeaveRecordFlag.value="Y";
		parent.frames[2].document.forms[0].SickLeaveDetails1.value=retVal;
		parent.frames[2].document.forms[0].SickLeaveDetails.value=retVal;
	}
}	


/// Added by Sridhar R on 13 JULY 2004
/// function ViewChange() will scroll into tab1 if the next field is disabled...
	function ViewChange(obj)
	{
		if(obj.name == 'inform_to' && document.forms[0].informed_name.disabled)
		{
			//document.getElementById("tab1").scrollIntoView();
			/*Monday, January 25, 2010 18542*/
			parent.frames[2].expandCollapse('Discharge_Details_tab');
			document.forms[0].auth_pract_desc.focus();
		}
		else if(obj.name == 'informed_date' && document.forms[0].absconding_yn.disabled)
		{
			//document.getElementById("tab1").scrollIntoView();
			/*Monday, January 25, 2010 18542*/
			parent.frames[2].expandCollapse('Discharge_Details_tab');
			document.forms[0].auth_pract_desc.focus();
		}
	}



function disReferred(chk)
{
	if(chk.checked)
	{
		document.forms[0].absconding_date.value	= '';
		document.forms[0].absconding_date.disabled= false;
		document.getElementById('calImage').disabled		= false;
		document.forms[0].absconding_rep_to.value		= '';
		document.forms[0].absconding_rep_to.disabled	= false;
		document.getElementById('AbsImg').style.visibility = "Visible";
	}
	else
	{
		document.forms[0].absconding_date.value	= '';
		document.forms[0].absconding_date.disabled= true;
		document.getElementById('calImage').disabled		= true;
		document.forms[0].absconding_rep_to.value		= '';
		document.forms[0].absconding_rep_to.disabled	= true;
		document.getElementById('AbsImg').style.visibility	= "hidden";
	}
}

function validateFromDateTime(obj,val)
{
	if(obj.value != '')
	{
		var locale = dischargeadvice_form.locale.value;
		var greg_date = convertDate(obj.value,"DMYHM",locale,"en");

		if(validDateObj(obj.value,"DMYHM",locale))
		{
				var currdate = self.document.dischargeadvice_form.currdate.value;
				var continue_yn = "Y"
				if(isAfter(document.dischargeadvice_form.admissiondatetime.value, greg_date, "DMYHM", locale))
				{
					alert(self.getMessage("DIS_DATE_NOT_LESS_ADM_DATE","IP"));
					obj.focus();
					obj.select();
				}
				
				if (continue_yn=="Y")
				{	
					if(isAfter(currdate, greg_date, "DMYHM", locale))
					{
						alert(self.getMessage("DIS_DATE_LT_EXCEEDED","IP"));
						continue_yn = "N";
						obj.focus();
						obj.select();
					}
				}
		}
	}
}


function validateDateTimes(obj,val)//expecteddischargedate//absconding_date
{


	var currdate = self.document.dischargeadvice_form.currdate;
	if(obj.value != '')
	{
		var locale = self.document.dischargeadvice_form.locale1.value;
		if(obj.name == 'expecteddischargedate')
		{ 
			if(validDateObj(obj,"DMYHM",locale))
			{
				var greg_date = convertDate(obj.value,"DMYHM",locale,"en");		
				var continue_yn = "Y"
				if(isAfter(currdate.value,greg_date, "DMYHM", locale))
				{
					document.forms[0].proceed.value = "N";
					alert(self.getMessage("DIS_DATE_LT_EXCEEDED","IP"));
					continue_yn = "N";
					obj.value='';
					
				}
				if (continue_yn	== "Y")
				{	
					if(isBefore(greg_date,document.dischargeadvice_form.admissiondatetime.value, "DMYHM", 'en'))
					{	
						document.forms[0].proceed.value = "N";
					//	alert(self.getMessage("DIS_DATE_NOT_LESS_ADM_DATE","IP"));
					//	obj.value='';
		
						var error = getMessage('DATE1_SHD_GT_DATE2','IP');
						var last_encounter = getLabel("Common.AdmissionDateTime.label",'Common');
						error = error.replace('$',getLabel("eIP.ExpectedDischargeDateTime.label",'IP'));
						error = error.replace('#',last_encounter);
						alert(error);
						obj.value='';
						obj.select();
	
					}
					
					else if(!isBefore(document.dischargeadvice_form.ip_Trn_Date.value,greg_date, "DMYHM", 'en'))
					{
						document.forms[0].proceed.value = "N";
						//alert(self.getMessage("DISC_LESS_LAST_TRANS","IP"));
						//obj.value='';
						
					var error = getMessage('DATE1_LT_DATE2','IP');
					var last_encounter = getLabel("eIP.LastTransactionDateTime.label","IP");
					error = error.replace('$',getLabel("eIP.ExpectedDischargeDateTime.label",'IP'));
					error = error.replace('#',last_encounter);
					alert(error);
					obj.value='';
					}
					
					
					
				}
				
			}
		}
		else if(obj.name == 'death_date')
		{	
		
			var system_date_time = self.document.dischargeadvice_form.system_date_time.value;
		
		
			var continue_yn = "Y"
		
			if(validDateObj(obj,"DMYHM",locale))
			{	 
				
				var greg_date = convertDate(obj.value,"DMYHM",locale,"en");	
				if(!isBefore(document.dischargeadvice_form.admissiondatetime.value,greg_date,"DMYHM",'en'))
				{	 
					
					document.forms[0].proceed.value = "N";
					var error = getMessage("DATE1_LT_DATE2","IP");
					error = error.replace("$",getLabel("Common.deathdatetime.label","Common"));
					error = error.replace("#",getLabel('Common.AdmissionDateTime.label','Common'));
					alert(error);
					continue_yn = "N"
					obj.value='';
					obj.focus();
				}
				
				else if(!isBefore(document.dischargeadvice_form.ip_Trn_Date.value,greg_date, "DMYHM", 'en'))
				{ 
				 					    
					document.forms[0].proceed.value = "N";
					var error = getMessage("DATE1_LT_DATE2","IP");
					error = error.replace("$",getLabel("Common.deathdatetime.label","Common"));
					//error = error.replace("#",getLabel("Common.Last.label","Common")+" "+getLabel("Common.encounterdate.label","Common"));
					/*Monday, December 06, 2010 , SRR20056-SCF-6173 [IN:025371]*/
					var error = error.replace("#",getLabel("eIP.LastTransactionDateTime.label","ip_labels"));
					alert(error);
					continue_yn = "N"
					obj.value='';
					obj.focus();
				}
				if(continue_yn == "Y")
				{	
				
					//if(!isBefore(greg_date,system_date_time,"DMYHM",locale)) {	
					if(!isBefore(greg_date,system_date_time,"DMYHM","en")) {	//Modified By Dharma on 30th Sep 2015 against Leap Year Issue
						
					   	document.forms[0].proceed.value = "N";
						var error = getMessage("DATE1_GT_DATE2","IP");
						error = error.replace("$",getLabel('Common.deathdatetime.label','Common'));
						error = error.replace("#",getLabel("Common.SystemDateTime.label","Common"));
						alert(error);
						obj.focus();
						obj.value='';
					}
				}
			}
		}
	}
}
/*below method added by venkatesh.s on 09-Aug-2012 against SS-SCF-0674 [IN:034278] */
function calender()
{
 showCalendar('death_id',null,'hh:mm')
 
var death_date=self.document.dischargeadvice_form.death_date.value;
var server_date_time=convertDate(self.document.dischargeadvice_form.system_date_time.value,"DMYHM","en", localeName);

   if (!(server_date_time==null))
		{
			var date1=death_date.split(' ');
			
			var time=server_date_time.split(' ');
			self.document.dischargeadvice_form.death_date.value=date1[0]+" "+time[1];
			//document.forms[0].released_date_time.value=date1[0]+" "+time[1];
		}

}

function compare_death_exptDisch()
{
	
	var locale = self.document.dischargeadvice_form.locale1.value;
		 
	if(document.dischargeadvice_form.dischage_indicator.value=="DS")
	{
	  if(document.dischargeadvice_form.death_date.value!="" && document.dischargeadvice_form.expecteddischargedate.value!="" /*&& validDateObj(document.dischargeadvice_form.death_date,"DMYHM",locale)*/ )
		 {

			var greg_death_date = convertDate(document.dischargeadvice_form.death_date.value,"DMYHM",locale,"en");
			var greg_expected_discharge = convertDate(document.dischargeadvice_form.expecteddischargedate.value,"DMYHM",locale,"en");
			 //if(isAfter(greg_death_date,greg_expected_discharge,"DMYHM",locale))
			if(!isBefore(greg_death_date,greg_expected_discharge,"DMYHM","en"))
			  {
				 document.forms[0].proceed.value = "N";
				 var error = getMessage("DATE1_GT_DATE2","IP");
				 error = error.replace("$",getLabel("Common.deathdatetime.label","Common"));
				 error = error.replace("#",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
				 alert(error);
				 document.dischargeadvice_form.death_date.value="";
				 document.dischargeadvice_form.death_date.focus();
				 return false;
			  }
		 }
	}
	
}

function checkForMaximum(val)
{
	if (val.length>200)
	{
		var msg = getMessage('REMARKS_CANNOT_EXCEED',"Common");
		msg		= msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg		= msg.replace("#",200);
		alert(msg);
		document.forms[0].remarks.select();
	}
	else
	{
		if(document.forms[0].medico_legal.disabled == false)
			document.forms[0].medico_legal.focus();
	}
}

function abs_focus(obj)
{
	/*if (!obj.checked)
	{
		tab_click('other_details');		
	}*/
}

function dis_adv_focus(obj)
{
	if (obj.value==""&& (!document.forms[0].absconding_yn.checked))
	{
		//tab_click('other_details');		
	}
}

function checkForMaximum1(val)
{
	if (val.length>200)
	{
		//tab_click('other_details');
		//alert(getMessage('EXCEED_MAX_LENGTH',"SM"));
		var msg = getMessage('REMARKS_CANNOT_EXCEED',"Common");
		msg		= msg.replace("$",getLabel("eIP.InformedOthers.label","IP"));
		msg		= msg.replace("#",200);
		alert(msg);
		document.forms[0].absconding_rep_to.select();
	}
	//else
	 //tab_click('other_details');
}


// Added by SRIDHAR R on 27 MAY 2004 for Tabs
// The Entire layout was changed Two Tabs were introduced For Discharge & Referral
// function tab_click - Will Scroll the view betwen Two Tabs ...
function tab_click(objName)
{	
	if (objName == 'other_details' || objName == 'other_details1')
	{
		document.getElementById('tab1').scrollIntoView();
		document.forms[0].auth_pract_desc.focus();
	}else if (objName == 'others_details' || objName == 'others_details1' )
	{
		document.getElementById('tab3').scrollIntoView();
		if(document.forms[0].newmedicine.disabled)
			parent.frames[3].focus();
		else
			document.forms[0].newmedicine.focus();
	}
}

// Added by SRIDHAR R on 14 MAY 2004 for Date Validation
function InformDateValidate(dateValue)
{
	ViewChange(dateValue);
	var locale = dischargeadvice_form.locale.value;
	if(dateValue.value != '')
	{	
		if(validDateObj(dateValue,"DMYHM",locale))
		{
			validateInformedDate(dateValue);
		}
	}
}


// By Annadurai 2/9/2004 starts.
function validateInformedDate(dateValue)
{
	if (dateValue.value != '')
	{
		var locale = dischargeadvice_form.locale.value;
		var greg_date = convertDate(dateValue.value,"DMYHM",locale,"en");
		var system_date			= document.forms[0].system_date_time;
		var admissiondatetime	= document.forms[0].admissiondatetime;
		if(isAfter(greg_date,system_date.value,'DMYHM',locale))
		{
			var error = getMessage("DATE1_GT_DATE2","IP");
			error = error.replace("$", getLabel('Common.InformedDate/Time.label','Common'));
			error = error.replace("#", getLabel("Common.CurrentDateTime.label","Common"));
			alert(error);
			document.forms[0].informed_date.focus();
			document.forms[0].informed_date.value =	'';
			return false
		}
		else if (!isAfter(greg_date,admissiondatetime.value,'DMYHM',locale))
		{
			var error = getMessage("DATE1_LT_DATE2","IP");
			error = error.replace("$", getLabel('Common.InformedDate/Time.label','Common'));
			error = error.replace("#", getLabel('Common.encounterdatetime.label','Common'));
			alert(error);
			document.forms[0].informed_date.select();
			document.forms[0].informed_date.value =	'';
			return
		}
	}
}

/// Added by Sridhar R  on Aug 10 2005..
/// The function will be called only for DayCare Patients.
/// Expected Discharge Date should be b/w the [Last Transaction date] & [Expexted time+Parameter] value...
function dayCareDateCheck(dateVal)
{  
	if(document.getElementById('patient_class_value').value == "DC")
	{
		var locale					= document.forms[0].locale1.value;
		var valid					= document.forms[0].valid.value;
		var expecteddischargedate	= document.forms[0].expecteddischargedate.value;
		var system_date_time		= document.forms[0].system_date_time.value;
		var from_time				= document.forms[0].from_time.value;
		var max_param_date			= document.forms[0].max_param_date.value;

		var valid_date				= document.forms[0].valid_date.value;
		var greg_valid_date			= convertDate(valid_date,"DMYHM",locale,"en");
		var admissiondatetime		= document.forms[0].admissiondatetime.value
		var greg_date = convertDate(expecteddischargedate,"DMYHM",locale,"en");

		if(expecteddischargedate != '')
		{
			if(valid == "N")
			{
				/* 17956 Thursday, January 07, 2010 , to check EDD should greater than admission date*/
				if(isBefore(greg_date,admissiondatetime,'DMYHM','en'))
				{
					var error = getMessage('DATE1_SHD_GT_DATE2','IP');
					error = error.replace('$',getLabel("eIP.ExpectedDischargeDateTime.label",'IP'));
					error = error.replace('#',getLabel("Common.AdmissionDateTime.label",'Common'));
					alert(error);
					dateVal.value='';
					dateVal.select();
					return false;
				}
				
				if(!isBefore(from_time, greg_date,"DMYHM","en"))/*locale is changed to en by Rameswar on 16-OCT-2015 for Leap Year Issue*/
				{ 
					var trn_error = getMessage("DATE1_LT_DATE2","IP");
					trn_error = trn_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
					trn_error = trn_error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP"));
					alert(trn_error);
					dateVal.value='';
					dateVal.select();
					return false;
				}
				//if(isAfter(greg_date, valid_date,"DMYHM","en")) 5/22/2009 SRR20056-SCF-3027  IN010821
				//if(!isBefore(greg_date, greg_valid_date,"DMYHM",locale))
				if(isAfter(greg_date, greg_valid_date,"DMYHM",locale)) //Modified for AAKH-SCF-0093
				{	
					var max_error = getMessage("GENERAL_CANNOT_EXCEED","IP");
					max_error = max_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
					max_error = max_error.replace("#",valid_date);
					//max_error = max_error.replace("#",getLabel("eIP.MaximumParameterValue.label","IP"));
					alert(max_error);
					dateVal.value='';
					dateVal.select();
					return false;
				}
			}
			else if(valid == "Y")
			{
				
				/* 17956 Thursday, January 07, 2010 , to check EDD should greater than admission date*/
				if(isBefore(greg_date,admissiondatetime,'DMYHM','en'))
				{
					var error = getMessage('DATE1_SHD_GT_DATE2','IP');
					error = error.replace('$',getLabel("eIP.ExpectedDischargeDateTime.label",'IP'));
					error = error.replace('#',getLabel("Common.AdmissionDateTime.label",'Common'));
					alert(error);
					dateVal.value='';
					dateVal.select();
					return false;
				}
				
				if(!isBefore(from_time, greg_date,"DMYHM",locale))
				{
					var trn_error = getMessage("DATE1_LT_DATE2","IP");
					trn_error = trn_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
					trn_error = trn_error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP"));
					alert(trn_error);
					dateVal.value='';
					dateVal.select();
					return false;
				}

		
				if(isAfter(greg_date, max_param_date,"DMYHM",locale))
				{
					var param_error = getMessage("DATE1_GT_DATE2","IP");
					param_error = param_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
					param_error = param_error.replace("#",getLabel("eIP.MaximumParameterValue.label","IP"));
					alert(param_error);
					dateVal.value='';
					dateVal.select();
					return false;
				}
			}
		}
	}
}


function trimCheck(inString) 
{
    var startPos;
    var ch;
    startPos = 0;
    strlength = inString.length;
	for(var i=0;i<=strlength;i++) 
	{
        ch = inString.charAt(startPos);
        if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n"))         startPos++;
    }
    if(startPos == inString.length) return false;
    else return true;
}

function getMedicoValues(checkVal)
{
	if (checkVal.checked ==	true)
		document.forms[0].medico_legal.value	=	"Y";
	else if (checkVal.checked == false)
		document.forms[0].medico_legal.value	=	"N";
}

function disableFields()
{
	document.getElementById('im').style.visibility		=	'hidden';
	document.getElementById('Ttype').style.visibility		=	'hidden';
	document.getElementById('deathimg').style.visibility	=	'hidden';
	document.getElementById('AbsImg').style.visibility	=	'hidden';
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
			document.forms[0].pol_rep_no.value='';
			document.forms[0].pol_rep_no.disabled	=	true;
			document.forms[0].pol_stn_id.value='';
			document.forms[0].pol_stn_id.disabled	=	true;
			document.forms[0].pol_id.value='';
			document.forms[0].pol_id.disabled		=	true;
	}
}


function enableInformName()
{
	if (document.forms[0].inform_to.value!="")
	{
		document.getElementById('im').style.visibility			= 'visible';
		//document.getElementById("im2").style.visibility			= 'visible';
		document.forms[0].informed_date.disabled	= false;
		document.getElementById('infocalimg').style.pointerEvents			= "auto";
		document.forms[0].informed_name.disabled  	= false;
	}
	if (document.forms[0].inform_to.value=="")
	{
		document.getElementById('im').style.visibility			= 'hidden';
		document.forms[0].informed_date.disabled	= true;
		document.forms[0].informed_date.value		= '';
		document.getElementById('infocalimg').style.pointerEvents			= "none";
		document.forms[0].informed_name.disabled		= true;
	}

	if (document.forms[0].inform_to.value=="03" || document.forms[0].inform_to.value=="") 
		// Tuesday, February 02, 2010  18774. (Venkat S)
	{
		if(document.forms[0].help_function_id.value =='PREP_DISCH_ADVICE')
			parent.frames[3].document.forms[0].family.disabled	=	true;
		//document.forms[0].informed_name.disabled		= false;
	}
	else
	{
		if(document.forms[0].help_function_id.value =='PREP_DISCH_ADVICE')
		parent.frames[3].document.forms[0].family.disabled	=	false;
	}

	if ((document.forms[0].inform_to.value == "01") || (document.forms[0].inform_to.value == "02"))
	{
		var informTo	= document.forms[0].inform_to.value;
		var patientid	= document.forms[0].patient_id.value;

		var disp_pat_name='';
		if (document.forms[0].inform_to.value == "01"){
			disp_pat_name=document.forms[0].contact1_name.value;
		}else {
			disp_pat_name=document.forms[0].contact2_name.value;
		}
		
		document.forms[0].informed_name.value = disp_pat_name;
   		//document.forms[0].informed_name.disabled=false;
		if(disp_pat_name!='')
			document.forms[0].informed_name.focus();

		/*
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eIP/jsp/DischargeValidation.jsp' ><input type='hidden' name='field1' id='field1' value='TransferOutForm'><input type='hidden' name='field2' id='field2' value='"+patientid+"'><input type='hidden' name='field3' id='field3' value='"+informTo+"'><input type='hidden' name='field4' id='field4' value='TransferOutForm'><input type='hidden' name='field5' id='field5' value='Discharge'></form></body></html>";
		parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		
		parent.frames[4].document.dummy_form.submit();
		document.forms[0].informed_name.disabled =  false;
		*/
	}
	else 
	{
		document.forms[0].informed_name.value =  "";
	}
}

// To get the Pratitioner using GeneralPratitionerSearch.
function getPractitionerLocal(obj,target, aFacilityID)
{
	var practName_FName		="";
	var practName_FValue	="";	
	var practId_FName		="";
	
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;

	var nursing_unit_code	= document.forms[0].nursingunitcode.value;
	var spl_code			= document.forms[0].SplCode.value;
	if(nursing_unit_code != "")
	{
		if(spl_code != "")
		{
			var facility_id = aFacilityID;
            locale=document.forms[0].locale1.value;  

			getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");

			/*
			var sql = " SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, a.gender gender, am_get_desc.AM_POSITION(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name)) ) AND a.SEX LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) ";

			var sql2 = "SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, a.gender gender, am_get_desc.AM_POSITION(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) and  UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name)) ) AND a.SEX LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL)";

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	= "<root><SEARCH " ;
			xmlStr += " practName_FName=\"" +practName_FName + "\"";
			xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
			xmlStr += " practId_FName=\"" + practId_FName + "\"";
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
			var error = getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel('Common.speciality.label','Common'));
			alert(error);	
		}
	}
	else
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel('Common.nursingUnit.label','Common'));
		alert(error);	
	}
} // End of getPractitioner(); 


// To set the values to Attending Practitioner when using  
// GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (objName=="pract_name")
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practitioner.value	=	arr[0];
			document.forms[0].pract_name.value		=	arr[1];			
		}
		else
		{
			document.forms[0].practitioner.value	=	"";
			document.forms[0].pract_name.value		=	"";			
			document.forms[0].pract_name.focus();
		}
	}
	else 
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practid.value			=	arr[0];
			document.forms[0].auth_pract_desc.value	=	arr[1];			
		}
		else
		{
			document.forms[0].practid.value			=	"";
			document.forms[0].auth_pract_desc.value	=	"";			
			document.forms[0].auth_pract_desc.focus();
		}
	}
} // End of PractLookupRetVal().
// By Annadurai 2/9/2004 ends..

function Clear()
{
	document.dischargeadvice_form.dischgsumsigned.checked=false;
	document.dischargeadvice_form.newmedicine.checked=false;
	document.dischargeadvice_form.stockmedicine.checked=false;
	document.dischargeadvice_form.lab.checked=false;
	document.dischargeadvice_form.xray.checked=false;
	document.dischargeadvice_form.scan.checked=false;
	document.dischargeadvice_form.ultrasound.checked=false;
	document.dischargeadvice_form.mri.checked=false;
	document.dischargeadvice_form.rt.checked=false;
	document.dischargeadvice_form.physio.checked=false;
	document.dischargeadvice_form.ecg.checked=false;
	document.dischargeadvice_form.diet.checked=false;
	document.dischargeadvice_form.pharmacy.checked=false;
	document.dischargeadvice_form.pmrequested.checked=false;
}

function Record1()
{
	document.forms[0].submit();
}


function changeVal(obj)
{
	var val = obj.name;

	if(val == "pmrequested")
	{
	   document.dischargeadvice_form.pmrequested.value="Y";
	}
	 if(val == "dischgsumsigned")
	{
	   document.dischargeadvice_form.dischgsumsigned.value="Y";
	}
	 if(val == "newmedicine")
	{
	   document.dischargeadvice_form.newmedicine.value="Y";
	}
	 if(val == "stockmedicine")
	{
	   document.dischargeadvice_form.stockmedicine.value="Y";
	}
	 if(val == "lab")
	{
	   document.dischargeadvice_form.lab.value="Y";
	}
	 if(val == "xray")
	{
	   document.dischargeadvice_form.xray.value="Y";
	}
	 if(val == "scan")
	{
	   document.dischargeadvice_form.scan.value="Y";
	}

	 if(val == "ultrasound")
	{
	   document.dischargeadvice_form.ultrasound.value="Y";
	}
	 if(val == "mri")
	{
	   document.dischargeadvice_form.mri.value="Y";
	}
	 if(val == "rt")
	{
	   document.dischargeadvice_form.rt.value="Y";
	}
	 if(val == "physio")
	{
	   document.dischargeadvice_form.physio.value="Y";
	}
	 if(val == "ecg")
	{
	   document.dischargeadvice_form.ecg.value="Y";
	}
	 if(val == "diet")
	{
	   document.dischargeadvice_form.diet.value="Y";
	}
	if(val == "pharmacy")
	{
	   document.dischargeadvice_form.pharmacy.value="Y";
	}

}

function valDate(obj,val)
{
	var dateVal = obj.value;
	if(dateVal != '')
	{
		var greg_date = convertDate(obj.value,"DMYHM",locale,"en");
		  var locale = dischargeadvice_form.locale.value; 
		  if(validDateObj(obj.value,"DMYHM",locale))
		   {
			if(val == 'A')
			{
				var currdate = self.document.dischargeadvice_form.Sdate.value;
				if(!isAfter(greg_date,currdate,"DMYHM",locale))
				{		 						
				   alert(getMessage("FUTURE_DATE_NOT_ALLOWED","IP"));
				   obj.focus();
				   obj.select();
				}
			}
		}
	}
}

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
 
  
function callValidate(obj)
{
	retVal = document.forms[0].dischargetype.value;
	var arr = retVal.split("=");
	document.forms[0].discharge_code.value=arr[0];
	document.forms[0].dischage_indicator.value=arr[1];

	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	var isAadharCardAndRelAppl = parent.frames[2].document.dischargeadvice_form.isAadharCardAndRelAppl.value;
	var citizen_yn			   = parent.frames[2].document.dischargeadvice_form.citizen_yn.value;
	var alt_id4_type		   = parent.frames[2].document.dischargeadvice_form.alt_id4_type.value;
	/*End GHL-CRF-0505*/
	
	/* Added by Ajay Hatwate for AAKH-CRF-0179 */
	var enable_death_reg_form=parent.frames[2].document.dischargeadvice_form.enable_death_reg_form.value;
	var isDeathRegisterFormAppl=parent.frames[2].document.dischargeadvice_form.isDeathRegisterFormAppl.value;
	/* End AAKH-CRF-0179 */
	/*Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020 */
	var isHeightAndBmiEnable=document.forms[0].isHeightAndBmiEnable.value;
	var dischage_indicator=document.forms[0].dischage_indicator.value;
	if(isHeightAndBmiEnable=="true")
	{
	if(dischage_indicator=='ED')
	{
		
	parent.frames[2].document.getElementById('dislabel').innerText	=	getLabel("eIP.DischargeTo.label","ip");
	parent.frames[2].document.getElementById('distext').style="display"
	parent.frames[2].document.getElementById('disbtn').style="display"
	parent.frames[2].document.dischargeadvice_form.discharge_to.disabled	=	false;
	}
	else
		{
		parent.frames[2].document.getElementById('dislabel').innerText	=	'';
		parent.frames[2].document.getElementById('distext').style.display = 'none';
		parent.frames[2].document.getElementById('disbtn').style.display = 'none';
		parent.frames[2].document.dischargeadvice_form.discharge_to.value='';
		}
	}
	/*Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020 */

	/*Wednesday, January 12, 2011 , if(document.forms[0].medico_legal.value == 'N') condition added SRR20056-SCF-6415 [IN:025852]*/
	if(document.forms[0].medico_legal.value == 'N'){
		document.forms[0].medico_legal.checked			= false ;
		document.forms[0].pol_rep_no.value				= "";
		document.forms[0].pol_stn_id.value				= "";
		document.forms[0].pol_id.value					= "";
	}
	if(document.forms[0].dischage_indicator.value=='DS')
	{
		//var ds_msg = myMessageBox("Microsoft Internet Explorer",getMessage("PATIENT_MARKED_DESEASED","IP") , 1 + 256 + 4096 );
		var ds_msg = confirm(getMessage("PATIENT_MARKED_DESEASED","IP"));

		//isDeathRegFormAppl = document.forms[0].isDeathRegisterFormAppl.value;
		if(isDeathRegisterFormAppl == 'true' && enable_death_reg_form == 'Y'){
			document.getElementById('deathRegFormLink').style.visibility = 'visible';
		}
		if(ds_msg)
		{
			parent.frames[2].document.forms[0].dischargestatus.focus();
			parent.frames[2].document.getElementById('deathlable').innerText	    =	getLabel("Common.deathdatetime.label","Common");
			parent.frames[2].document.getElementById('death_id').style.visibility	=	"Visible";
			parent.frames[2].document.getElementById('selcalimg').style.visibility=	"Visible";
			parent.frames[2].document.getElementById('postmortlable').innerText	= getLabel("eMR.Postmortemrequested.label","MR");
			parent.frames[2].document.getElementById('post_check').style.visibility =	"Visible";
			parent.frames[2].document.getElementById('deathimg').style.visibility	  =	"Visible";
			parent.frames[2].document.dischargeadvice_form.death_date.disabled	=	false;
			parent.frames[2].document.dischargeadvice_form.deathimg.style.visibility='visible'; 
			parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled=false;
			parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;
			parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;
			parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=true;
			parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;
			parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=true;
			parent.frames[2].document.dischargeadvice_form.lab.checked=false;
			parent.frames[2].document.dischargeadvice_form.lab.disabled=true;
			parent.frames[2].document.dischargeadvice_form.xray.checked=false;
			parent.frames[2].document.dischargeadvice_form.xray.disabled=true;
			parent.frames[2].document.dischargeadvice_form.scan.checked=false;
			parent.frames[2].document.dischargeadvice_form.scan.disabled=true;
			parent.frames[2].document.dischargeadvice_form.ultrasound.checked=false;
			parent.frames[2].document.dischargeadvice_form.ultrasound.disabled=true;
			parent.frames[2].document.dischargeadvice_form.mri.checked=false;
			parent.frames[2].document.dischargeadvice_form.mri.disabled=true;
			parent.frames[2].document.dischargeadvice_form.rt.checked=false;
			parent.frames[2].document.dischargeadvice_form.rt.disabled=true;
			parent.frames[2].document.dischargeadvice_form.physio.checked=false;
			parent.frames[2].document.dischargeadvice_form.physio.disabled=true;
			parent.frames[2].document.dischargeadvice_form.ecg.checked=false;
			parent.frames[2].document.dischargeadvice_form.ecg.disabled=true;
			parent.frames[2].document.dischargeadvice_form.diet.checked=false;
			parent.frames[2].document.dischargeadvice_form.diet.disabled=true;
			parent.frames[2].document.dischargeadvice_form.pharmacy.checked=false;
			parent.frames[2].document.dischargeadvice_form.pharmacy.disabled=true;
			//parent.frames[3].document.forms[0].Display.style.visibility='hidden';
			
			/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
			if(isAadharCardAndRelAppl == "true" && citizen_yn == "Y" && alt_id4_type != "")
			{
				parent.frames[2].document.getElementById('AadharCardAndRel').style.display = 'inline';
			}
			/*End GHL-CRF-0505*/

			document.getElementById('ab_details').style.visibility		= "hidden";
			if(parent.frames[2].document.dischargeadvice_form.absdate.value == null || parent.frames[2].document.dischargeadvice_form.absdate.value == "" )
			{
				document.forms[0].absconding_yn.checked		= false;
				document.forms[0].absconding_yn.disabled	= true;
				document.forms[0].absconding_yn.value		= '';
				document.forms[0].absconding_date.disabled	= true;
				document.forms[0].absconding_date.value		= '';
				document.getElementById('AbsImg').style.visibility		= "hidden";
				document.getElementById('calImage').disabled				= true;
				document.forms[0].absconding_rep_to.disabled		= true;
				document.forms[0].absconding_rep_to.value			= '';
			}
			validateStatus(obj)
		}
		else
		{
			document.forms[0].dischargetype.value="";
			document.forms[0].dischargetype.focus();
			document.getElementById('AbsImg').style.visibility="hidden";
			document.getElementById('ab_details').style.visibility		= "hidden";
			if(parent.frames[2].document.dischargeadvice_form.absdate.value == null || parent.frames[2].document.dischargeadvice_form.absdate.value == "" )
				document.forms[0].absconding_yn.checked = false;
			validateStatus(obj)
		}
	}
	else
	{
		parent.frames[2].document.getElementById('deathlable').innerText	    =	'';
		parent.frames[2].document.dischargeadvice_form.death_date.value='';
		parent.frames[2].document.getElementById('death_id').style.visibility	    =	"Hidden";
		parent.frames[2].document.getElementById('selcalimg').style.visibility	    =	"Hidden";
	
		parent.frames[2].document.getElementById('postmortlable').innerText	    =	'';
		parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;
		parent.frames[2].document.getElementById('post_check').style.visibility	    =	"Hidden";
		parent.frames[2].document.getElementById('deathimg').style.visibility	    =	"Hidden";
		parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;
		parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;
		parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;
		parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false;
		parent.frames[2].document.dischargeadvice_form.lab.checked=false;
		parent.frames[2].document.dischargeadvice_form.lab.disabled=false;
		parent.frames[2].document.dischargeadvice_form.xray.checked=false;
		parent.frames[2].document.dischargeadvice_form.xray.disabled=false;
		parent.frames[2].document.dischargeadvice_form.scan.checked=false;
		parent.frames[2].document.dischargeadvice_form.scan.disabled=false;
		parent.frames[2].document.dischargeadvice_form.ultrasound.checked=false;
		parent.frames[2].document.dischargeadvice_form.ultrasound.disabled=false;
		parent.frames[2].document.dischargeadvice_form.mri.checked=false;
		parent.frames[2].document.dischargeadvice_form.mri.disabled=false;
		parent.frames[2].document.dischargeadvice_form.rt.checked=false;
		parent.frames[2].document.dischargeadvice_form.rt.disabled=false;
		parent.frames[2].document.dischargeadvice_form.physio.checked=false;
		parent.frames[2].document.dischargeadvice_form.physio.disabled=false;
		parent.frames[2].document.dischargeadvice_form.ecg.checked=false;
		parent.frames[2].document.dischargeadvice_form.ecg.disabled=false;
		parent.frames[2].document.dischargeadvice_form.diet.checked=false;
		parent.frames[2].document.dischargeadvice_form.diet.disabled=false;
		parent.frames[2].document.dischargeadvice_form.pharmacy.checked=false;
		parent.frames[2].document.dischargeadvice_form.pharmacy.disabled=false;

		/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
		if(isAadharCardAndRelAppl == "true" && citizen_yn == "Y" && alt_id4_type != "")
		{
			parent.frames[2].document.getElementById('AadharCardAndRel').style.display = 'none';
		}
		/*End GHL-CRF-0505*/
		/* Added by Ajay Hatwate for AAKH-CRF-0179 on 30-08-2023 */
		if(isDeathRegisterFormAppl == 'true' && enable_death_reg_form == 'Y'){
			if(document.getElementById('deathRegFormLink')){
				document.getElementById('deathRegFormLink').style.visibility = 'hidden';
			}
		}
		/* End AAKH-CRF-0179 */

		document.getElementById('ab_details').style.visibility		= "hidden";
		if(document.forms[0].dischage_indicator.value=='AB')
		{
			document.getElementById('ab_details').style.visibility		= "visible";
			if(document.forms[0].pol_rep_no_db.value != "" || document.forms[0].pol_stn_id_db.value != "" ||
				document.forms[0].pol_id_db.value != "" )
				document.forms[0].medico_legal.checked      = true ;
			document.forms[0].pol_rep_no.value				= document.forms[0].pol_rep_no_db.value;
			if(document.forms[0].pol_rep_no.value != "")
			document.forms[0].pol_rep_no.disabled			= true ;
			document.forms[0].pol_stn_id.value				= document.forms[0].pol_stn_id_db.value;
			if(document.forms[0].pol_stn_id.value != "")
			document.forms[0].pol_stn_id.disabled			= true ;
			document.forms[0].pol_id.value					= document.forms[0].pol_id_db.value;
			if(document.forms[0].pol_id.value != "")
			document.forms[0].pol_id.disabled				= true ;
			if(parent.frames[2].document.dischargeadvice_form.absdate.value == null || parent.frames[2].document.dischargeadvice_form.absdate.value == "" )
				document.forms[0].absconding_yn.disabled	= false;
		}
		else 
		if(document.forms[0].dischage_indicator.value=='AO')
		{
			//alert(document.forms[0].dischage_indicator.value);
			if(parent.frames[2].document.dischargeadvice_form.absdate.value == null || parent.frames[2].document.dischargeadvice_form.absdate.value == "" )
			{
				document.forms[0].absconding_yn.checked = false;
				document.getElementById('AbsImg').style.visibility="hidden";
				document.getElementById('ab_details').style.visibility		= "hidden";
				document.forms[0].absconding_yn.disabled	= false;
			}
			
		}
		else
		{
			if(parent.frames[2].document.dischargeadvice_form.absdate.value == null || parent.frames[2].document.dischargeadvice_form.absdate.value == "" )
			{
				document.forms[0].absconding_yn.checked		= false;
				document.forms[0].absconding_yn.disabled	= true;
				document.forms[0].absconding_yn.value		= '';
				document.forms[0].absconding_date.disabled	= true;
				document.forms[0].absconding_date.value		= '';
				document.getElementById('AbsImg').style.visibility		= "hidden";
				document.getElementById('calImage').disabled				= true;
				document.forms[0].absconding_rep_to.disabled		= true;
				document.forms[0].absconding_rep_to.value			= '';
			}
			
		}
		validateStatus(obj)
	}
	
}

function changeAbsStatus(obj)
{ 
	if(obj.checked  == true)
		obj.value ="Y";
	else
		obj.value ="N";
}

function absChecked(obj)
{
	if(obj.checked  == true)
	{
		document.forms[0].absconding_date.disabled	= false;
		document.getElementById('AbsImg').style.visibility		= "visible";
		document.getElementById('calImage').disabled				= false;
		document.getElementById('absconding_rep_to').readOnly = false;
		document.getElementById('absconding_rep_to').disabled = false;
	}
	else
	{
		document.forms[0].absconding_date.disabled	= true;
		if(parent.frames[2].document.forms[0].name == 'dischargeadvice_form') // if-else added by mujafar for ML-MMOH-CRF-0659 start
		{if(parent.frames[2].document.dischargeadvice_form.absdate.value == null || parent.frames[2].document.dischargeadvice_form.absdate.value == "" )
		document.forms[0].absconding_date.value		= "";
		}
		else
		if(parent.frames[2].document.forms[0].name == 'DischargePatient_form')
		{if(parent.frames[2].document.DischargePatient_form.absconded_date.value == null || parent.frames[2].document.DischargePatient_form.absconded_date.value == "" )
		document.forms[0].absconding_date.value		= "";
		}
		// if-else added by mujafar for ML-MMOH-CRF-0659 end
	
		document.getElementById('AbsImg').style.visibility		= "hidden";
		document.getElementById('calImage').disabled				= true;
		document.getElementById('absconding_rep_to').readOnly = true;
		document.getElementById('absconding_rep_to').disabled = true;
		document.getElementById('absconding_rep_to').value = "";	
	}
}
/*added on 3-07-08 fro SCR 3228*/
function validateStatus(obj)
{
	var HTMLVal = new String();
	//var indicator = obj.substring(3,obj.length)
	/*var dis_length = document.getElementById("dischargestatus").length;
	//alert(dis_length)
	for(int i=0;i<dis_length;i++)
	{
		document.getElementById("dischargestatus").remove(1);
	}*/
	var indicator = document.forms[0].dischage_indicator.value
	var discharge_type = document.forms[0].dischargetype.value
	if((obj.value != null || obj.value != ""))
	{
		HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form_status' id='form_status' method='post' action='../../eIP/jsp/DischargeValidation.jsp'><input type='hidden' name='indicator' id='indicator' value='"+indicator+"'><input type='hidden' name='discharge_type' id='discharge_type' value='"+discharge_type+"'><input type='hidden' name='field4' id='field4' value='Prepare_Discharge_advice'></form></BODY></HTML>";
		parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[4].document.form_status.submit();
	}
}

function capt_value(obj)
{
	
		parent.frames[2].document.forms[0].discharge_status.value=obj.value;
	
}
/**/
function FreezePage(){
	//if(parent.f_query_add_mod.document.getElementById("dischargetype").value.indexOf("DS") ==-1 && parent.f_query_add_mod.document.getElementById("record_exists").value=='true'){	

	if(parent.f_query_add_mod.document.getElementById('dischage_indicator').value.indexOf("DS") ==-1 && parent.f_query_add_mod.document.getElementById('record_exists').value=='true'){	
	for (var i=0;i<parent.f_query_add_mod.document.forms[0].elements.length;i++){
		if(parent.f_query_add_mod.document.forms[0].elements[i]!=null){
			parent.f_query_add_mod.document.forms[0].elements[i].disabled=true;
		}
	}
viewMenu();
	}else{
		if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y'){
			document.location.href ='../eCommon/html/blank.html';
			parent.frames[2].document.location.href = '../eCommon/html/blank.html';
			parent.frames[1].document.location.href = '../eCommon/html/blank.html';
			parent.frames[3].document.location.href = '../eCommon/html/blank.html';
		}
					//if(!(parent.f_query_add_mod.document.getElementById("dischargetype").value.indexOf("DS") ==-1)){  
					if(!(parent.f_query_add_mod.document.getElementById('dischage_indicator').value.indexOf("DS") ==-1)){  
						invokeMaintainDeathRegister();
					}
					else{
						parent.window.close();
					}
//				}
		 }
}
function viewMenu(){		
        var size = parent.f_query_add_mod.document.forms[0].size.value
		tab_click2('other_details');  		
		parent.f_query_add_mod_display.document.getElementById('readOnlyDiv').style.visibility='visible';
		parent.f_query_add_mod.document.getElementById('TestDiv').style.visibility='visible';
		parent.f_query_add_mod.document.getElementById('TestDiv1').style.visibility='visible';
		for(var j = 0 ; j < size ; j++)
		{
			//parent.f_query_add_mod.document.getElementById("linkID")"+j+".focus();
			eval(parent.f_query_add_mod.document.getElementById('linkID'+j)).focus();
		}
		for (var i=0;i<parent.f_query_add_mod.document.forms[0].elements.length;i++){
		if(parent.f_query_add_mod.document.forms[0].elements[i]!=null){
			parent.f_query_add_mod.document.forms[0].elements[i].disabled=true;
		}
	}	
	parent.frames[3].document.forms[0].record.disabled=true
	parent.frames[3].document.forms[0].clear.disabled=true
	//parent.frames[3].document.forms[0].close.disabled=true
	parent.frames[3].document.forms[0].diagnosis.disabled=true	
} 
function NextItem(i){	
	var size=document.getElementById("max_record").value;
	var keyCode	=	window.event.keyCode;
	if(keyCode == 40){	
		   if(parseInt(i)+1==size)
		   return;			   	
		   i = parseInt(i)+1;
		   eval(document.getElementById('linkID'+i)).focus();
		   eval(document.getElementById('TD'+i)).style.backgroundColor="#595959";
	   }
	   else if(keyCode == 38){
		   if(parseInt(i)-1<0)
	       return;		  
		   i=parseInt(i)-1;		   
		   eval(document.getElementById('linkID'+i)).focus();
	       eval(document.getElementById('TD'+i)).style.backgroundColor="#595959";
	  }	 	  
	   for(var j = 0;j< size;j++)	{
		   if(j == i){}
		   else
              eval(document.getElementById('TD'+j)).style.backgroundColor="";
		}	
}
function PrevItem(obj){
	var keyCode	=	window.event.keyCode;
	 if(keyCode==38){
		if(obj.name=="RcrdDiag"){
		document.getElementById('Td1').style.backgroundColor="";
		document.getElementById('Td3').style.backgroundColor="";
		document.getElementById('Td2').style.backgroundColor="#595959";
		document.getElementById('linkID1').focus();
	}
	}
}
function MouseClick(i){
	var size=document.getElementById('max_record').value;
	if(parseInt(i)==size)
	  return;
	eval(document.getElementById('linkID'+i)).focus();

	//Modified by Ashwini on 02-Jul-2018 for ML-MMOH-CRF-1047
	//eval("document.getElementById("TD")"+i).style.backgroundColor="#595959";
	eval(document.getElementById('TD'+i)).style.backgroundColor="#ebebeb";

   	   for(var j = 0;j< size;j++)	{		   
		   if(j == i){}
		   else
              eval(document.getElementById('TD'+j)).style.backgroundColor="";
		}
}
async function PopRefDetails(){
	var retVal;
	var dialogHeight  = "42" ;
	var dialogTop	  = "65" ;
	var dialogWidth = "70" ;
	var center  = "1" ;
	var status  = "no";
	var scroll  = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
	var arguments   = "" ;
	var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?calledFrom=IP&p_select=YES&p_reg_patient=YES&p_calling_function=IP_ADMIT";
	retVal = await window.showModalDialog(url,arguments,features);
//	parent.parent.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?'+parent.parent.f_query_add_mod.frames[0].document.forms[0].queryString.value;

      /*if(retVal!=null){
			document.forms[0].referral_id.value=retVal;
			validatePat(document.forms[0].referral_id,'Referral ID');
			parent.frames[3].document.getElementById("referal_details").disabled = false;
			if(parent.frames[2].document.forms[0].isBlInstalled.value=="Y")
				parent.frames[2].document.forms[0].financial_detail_ref_id.value=retVal;
		}else{
			if(parent.frames[2].document.forms[0].isBlInstalled.value=="Y")
				parent.frames[2].document.forms[0].financial_detail_ref_id.value="";
		}*/
}
/*function RegisterMoreReferral(encounter_id,patient_id,fun_name){
	alert(fun_name)
		if(fun_name==
		var discharge_indicator	= "";
//		var dischage_indicator	= document.forms[0].dischage_indicator.value; uncomment at record Time
		var Transaction_type = "DA" ;
		var dialogHeight	= '40';  
		var dialogWidth	= '65';
		var dialogTop		= '100';
		var arguments		= ''  ; 
		var getUrl = "../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounter_id+"&Module="+Transaction_type+"&patient_id="+patient_id+"&Transaction_type="+Transaction_type+"&discharge_indicator="+discharge_indicator+" "; 
		var features = 'dialogHeight:'+dialogHeight+';dialogWidth:'+dialogWidth+';status=no;dialogTop:'+dialogTop ;
		retVal = window.showModalDialog(getUrl,arguments,features);
}*/

/*Below line Modified for this CRF Bru-HIMS-CRF-261*/
async function ShowWindow(encounter_id,patient_id,fun_name,fun_path )
{ 	
	  
		var dischage_indicator = parent.frames[2].document.forms[0].dischage_indicator.value
		var patient_class      = parent.frames[2].document.forms[0].patient_class_value.value
		var nursingunitcode    = parent.frames[2].document.forms[0].nursingunitcode.value
		var query_string    = parent.frames[2].document.forms[0].query_string.value

		var practitioner_id    = parent.frames[2].document.forms[0].practitioner_id.value
		var practitionername    = parent.frames[2].document.forms[0].practitionername.value
		var bedno    = parent.frames[2].document.forms[0].bedno.value
		var roomno    = parent.frames[2].document.forms[0].roomno.value
		
		var function_id=parent.frames[2].document.forms[0].function_id.value //this line Added for this CRF Bru-HIMS-CRF-261
		
		
		var dialogHeight	= '90vh';  
		var dialogWidth	= '95vw';
		var dialogTop		= '1';
		var arguments		= ''  ; 
		var getUrl;
        if(fun_name=="MP_REG_PAT_REF")		 
		 getUrl =fun_path+"?EncounterId="+encounter_id+"&Transaction_type=DA&patient_id="+patient_id+"&Module=DA&discharge_indicator="+dischage_indicator+"&function_id="+function_id+""; //this line modified for this CRF Bru-HIMS-CRF-261
	    else if(fun_name=="OR_GEN_PLACE_ORDER"){
		 // getUrl = fun_path+"?menu_id=ORDERENTRYRESULTREPORTING&module_id=OR&function_id=GEN_PLACE_ORDER&function_name=Place Order&function_type=F&access=NNNNN&home_required_yn=N&patient_id"+patient_id;	option_id=NEW_ORDER	
		  
		/* Modified by Muthu on 06/03/2010 to pass new parameter 'called_from' 
		Issue - After placing the order from discharge advice internal server error is coming
		*/

		getUrl = "../../eOR/jsp/EnterOrder.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_id="+encounter_id+"&function_from=EXTERNAL_ORDER&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&location_code="+nursingunitcode+"&location_type=N&bed_num="+bedno+"&room_num="+roomno+"&episode_type="+patient_class+"&practitioner_name="+practitionername+"&called_from=DIS_ADVICE";
				
		// End of modification
		}
       else
		   getUrl=fun_path;

		var features = 'dialogHeight:'+dialogHeight+';dialogWidth:'+dialogWidth+';status=no;dialogTop:'+dialogTop ;     		
		retVal = await top.window.showModalDialog(getUrl,arguments,features);
		
		
			if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y')
			{
					
				parent.frames[2].document.location.href = '../../eCommon/html/blank.html';

				parent.frames[1].document.location.href = '../../eCommon/html/blank.html';
				parent.frames[3].document.location.href = '../../eCommon/html/blank.html';
				//document.location.href="../../eCA/jsp/CAMainTitle.jsp?query_string="+query_string+" ";

			}
			else
			
				parent.window.close();
		
}
	   /* if(fun_name=="OR_GEN_PLACE_ORDER")
	   {			
		//var discharge_indicator	= "";
       //var dischage_indicator	= document.forms[0].dischage_indicator.value; uncomment at record Time
		var Transaction_type = "DA" ;
		var dialogHeight	= '43';  
		var dialogWidth	= '65';
		var dialogTop		= '100';
		var arguments		= ''  ; 
		var getUrl = fun_path+"?function_id=GEN_PLACE_ORDER";
		//&Module="+Transaction_type+"&patient_id="+patient_id+"&Transaction_type="+Transaction_type+"&discharge_indicator="+discharge_indicator+" "; 
		var features = 'dialogHeight:'+dialogHeight+';dialogWidth:'+dialogWidth+';status=no;dialogTop:'+dialogTop ;  
		retVal = window.showModalDialog(getUrl,arguments,features);
	   }*/
	 
//}

function tab_click2(objName){	
	if (objName == 'other_details' || objName == 'other_details1'){
		//parent.f_query_add_mod.document.getElementById('tab1').scrollIntoView();
		parent.f_query_add_mod.document.getElementById('Discharge_Details').style.display = 'inline';
		parent.f_query_add_mod.document.forms[0].auth_pract_desc.disabled = false ;
		parent.f_query_add_mod.document.forms[0].auth_pract_desc.focus();
	}
}

async function RegisterMoreReferral(encounterId,patientid,discharge_indicator)
{
	 var dialogHeight	= '40vh';
	 var dialogWidth	= '65vw';
	 var dialogTop		= '72';
	 var arguments		= ''  ;
	
	  var getUrl ="../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounterId+"&Transaction_type=DA&patient_id="+patientid+"&Module=DA&discharge_indicator="+discharge_indicator+" "; 

	 var features = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+"; status=no;" ;
	  retVal = await window.showModalDialog(getUrl,arguments,features);
}
var isShift = false;
function setShift(){
		var keyCode=window.event.keyCode;
		if(keyCode == 16) isShift=true;
	}

function shift_tab(){
		var keyCode=window.event.keyCode;
		//alert(isShift);
		if(keyCode == 9 && isShift == true){
			
			parent.frames[3].document.getElementById('close').focus();
	
		}
		
	}

function invokeMaintainDeathRegister() {

	var invoke_yn;	
		
	//if(!(parent.f_query_add_mod.document.getElementById("dischargetype").value.indexOf("DS") ==-1) &&			    parent.frames[3].document.forms[0].invoke_death_reg_yn.value == "Y") {			
	if(!(parent.f_query_add_mod.document.getElementById('dischage_indicator').value.indexOf("DS") ==-1) &&			    parent.frames[3].document.forms[0].invoke_death_reg_yn.value == "Y") {			
			if(parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked == true) {
					if(parent.frames[3].document.forms[0].mo_install_yn.value == "Y")
						parent.window.close();
					else{	
                           							
						   //Below line added for this CRF ML-MMOH-CRF-0688
						   if((parent.frames[3].document.forms[0].invoke_death_reg_yn && parent.frames[3].document.forms[0].invoke_death_reg_yn.value == "Y") && (parent.frames[3].document.forms[0].death_reg_mandatory_yn && parent.frames[3].document.forms[0].death_reg_mandatory_yn.value == "N")){
								invoke_yn = confirm(getMessage("INVOKE_MAINTAIN_DEATH_REGISTER","MR"));	
							}else if((parent.frames[3].document.forms[0].invoke_death_reg_yn && parent.frames[3].document.forms[0].invoke_death_reg_yn.value == "Y") && (parent.frames[3].document.forms[0].death_reg_mandatory_yn && parent.frames[3].document.forms[0].death_reg_mandatory_yn.value == "Y")){
							invoke_yn = new Boolean(true);	
							}								
							//End this CRF ML-MMOH-CRF-0688										
							if(parent.frames[3].document.forms[0].access_yn.value == "Y") {
								if(invoke_yn) 
								{
									showDeathRegWindow();
								}
								else
								{
									if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y')
									{
										parent.frames[2].document.location.href = '../eCommon/html/blank.html';
										parent.frames[1].document.location.href = '../eCommon/html/blank.html';
										parent.frames[3].document.location.href = '../eCommon/html/blank.html';
									}
									else
										parent.window.close();
								}
							}
						    else {
									alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));
									if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y')
									{
										parent.frames[2].document.location.href = '../eCommon/html/blank.html';
										parent.frames[1].document.location.href = '../eCommon/html/blank.html';
										parent.frames[3].document.location.href = '../eCommon/html/blank.html';
									}
									else
										parent.window.close();
								  }
						}
			}
			else if(parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked == false) {	
					//Below line added for this CRF ML-MMOH-CRF-0688
					if((parent.frames[3].document.forms[0].invoke_death_reg_yn && parent.frames[3].document.forms[0].invoke_death_reg_yn.value == "Y") && (parent.frames[3].document.forms[0].death_reg_mandatory_yn && parent.frames[3].document.forms[0].death_reg_mandatory_yn.value == "N")){
							invoke_yn = confirm(getMessage("INVOKE_MAINTAIN_DEATH_REGISTER","MR"));	
					}else if((parent.frames[3].document.forms[0].invoke_death_reg_yn && parent.frames[3].document.forms[0].invoke_death_reg_yn.value == "Y") && (parent.frames[3].document.forms[0].death_reg_mandatory_yn && parent.frames[3].document.forms[0].death_reg_mandatory_yn.value == "Y")){
							invoke_yn = new Boolean(true);	
					}                   		
					//End this CRF ML-MMOH-CRF-0688					
					if(parent.frames[3].document.forms[0].access_yn.value == "Y"){
						if(invoke_yn)
						{
							showDeathRegWindow();
						}
						else
						{
							if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y')
							{
								parent.frames[2].document.location.href = '../eCommon/html/blank.html';
								parent.frames[1].document.location.href = '../eCommon/html/blank.html';
								parent.frames[3].document.location.href = '../eCommon/html/blank.html';
							}
							else
								parent.window.close();
						}
			    	}
					else{
						 alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));
						 if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y')
							{
								parent.frames[2].document.location.href = '../eCommon/html/blank.html';
								parent.frames[1].document.location.href = '../eCommon/html/blank.html';
								parent.frames[3].document.location.href = '../eCommon/html/blank.html';
							}
							else
							parent.window.close();
					    }
		    }
			else
			{
				if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y')
				{
					parent.frames[2].document.location.href = '../eCommon/html/blank.html';
					parent.frames[1].document.location.href = '../eCommon/html/blank.html';
					parent.frames[3].document.location.href = '../eCommon/html/blank.html';
				}
				else
					parent.window.close();	
			}
	  }		
	  else
	  {
	 	if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y')
		{
			parent.frames[2].document.location.href = '../eCommon/html/blank.html';
			parent.frames[1].document.location.href = '../eCommon/html/blank.html';
			parent.frames[3].document.location.href = '../eCommon/html/blank.html';
		}
		else
			parent.window.close();
	  }
  }

			
	async function showDeathRegWindow() {

		var patient_id = parent.frames[2].document.dischargeadvice_form.patient_id.value
		var encounter_id = parent.frames[2].document.dischargeadvice_form.encounter_id.value
		var locn_code = parent.frames[2].document.dischargeadvice_form.nursingunitcode.value
		var Sex = parent.frames[2].document.dischargeadvice_form.gender.value
		var DOB = parent.frames[2].document.dischargeadvice_form.DOB.value
		var speciality_code = parent.frames[2].document.dischargeadvice_form.SplCode.value					
		var practitioner_id = parent.frames[2].document.dischargeadvice_form.practitioner_id.value
		var practitioner_type = parent.frames[2].document.dischargeadvice_form.practitioner_type.value
		var Decease_date_time   = parent.frames[2].document.dischargeadvice_form.death_date.value		
		var visit_adm_date   = parent.frames[2].document.forms[0].admissiondatetime.value		
		
			   var retVal =  new String();
			   var dialogHeight= "70vh";
			   var dialogWidth = "85vw";
			   var dialogTop	= "0vh";
			   var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
			   var arguments = "" ;			  
			   var url = "../../eMR/jsp/DeathRegisterFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&locn_code="+locn_code+"&Sex="+Sex+"&Dob="+DOB+"&speciality_code="+speciality_code+"episode_id="+encounter_id+"&practitioner_id="+practitioner_id+"&visit_adm_date="+visit_adm_date+"&practitioner_type="+practitioner_type+"&Decease_date_time="+Decease_date_time+"&patient_class=IP&call_from=IP_Discharge_Advice&episode_type=I&mode=insert";
			  			  
			   retVal = await window.showModalDialog(url,arguments,features);
			   if(retVal==undefined) {
					var xmlStr ="";
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					var url = "../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals";
					xmlHttp.open("POST", url, false);
					xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					/*
					var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" );
					xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals",false);
					xmlHttp.send(null);		
					responseText=xmlHttp.responseText;
					*/
			  }
				if(parent.frames[2].document.forms[0].is_ca_yn.value == 'Y')
				{
				
					document.location.href ='../eCommon/html/blank.html';
					parent.frames[2].document.location.href = '../eCommon/html/blank.html';
					parent.frames[1].document.location.href = '../eCommon/html/blank.html';
					parent.frames[3].document.location.href = '../eCommon/html/blank.html';
				
				}
				else
				parent.window.close();		
	}	
	
/*Added by Ashwini on 18-Apr-2018 for GHL-CRF-0505*/
function fnChkAlphaNumericForAadharCard(Object,accept_alphanumeric) 
{
    var objectfield = Object ;
	var fieldVal = 	objectfield.value;
	var isAcceeptAlphaNumeric = accept_alphanumeric;

    var strCheck = '';
	var msg = getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP');
	if (isAcceeptAlphaNumeric=='Y')
	{
		strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		msg = msg.replace("in National ID"," ");
	}
	else
	{
		strCheck = '0123456789';
		msg = msg.replace("in National ID"," ");
		msg = msg.replace("Special Characters"," Alphabets and Special Characters");
	}
	var n = fieldVal.length;
	for (var i=0;i<n ;++i )
	{
		if (strCheck.indexOf(fieldVal.charAt(i)) == -1)
		{
			objectfield.value = "";
			alert(msg);
			objectfield.focus();
			return false;  
		}
	}
	objectfield.value = objectfield.value.toUpperCase();
}

function checkUniqueForAadharCard(aadhar_card_no)
{
	var aadhar_card_no	= 	aadhar_card_no.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH aadhar_card_no=\""+aadhar_card_no+"\" action='validateAadharCardNo' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var AadharCardNo = responseText;

	if(AadharCardNo > 0 )
	{
		var alt_id4_type_desc = parent.frames[2].document.dischargeadvice_form.alt_id4_type_desc.value;
		var err = getMessage("DUP_NAT_ID","MP");
		err = err.replace('#',alt_id4_type_desc);
		alert(err);
		parent.frames[2].document.dischargeadvice_form.aadhar_card.value = "";
		parent.frames[2].document.dischargeadvice_form.aadhar_card.focus();
		return false;
	}
}
/*End GHL-CRF-0505*/
/* ADDED BY KAMATCHI S FOR ML-MMOH-CRF-1527 ON 23-JUN-2020 */

function calculateBmi() {
	
	var weight = parent.frames[1].document.Display_Form.weight_on_admission.value;
	var height = parent.frames[1].document.Display_Form.height_on_admission.value;
	var unit = parent.frames[1].document.Display_Form.weight_on_admission_unit.value;
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
	parent.frames[1].document.Display_Form.bmi.value=bmi;
	parent.frames[2].document.dischargeadvice_form.bmi.value= bmi;
		
}

async function searchCode(obj,target)
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

	retVal=await CommonLookup(tit,argumentArray);
	var ret1=unescape(retVal);
 	var arr=ret1.split(",");
	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=arr[1];
}
	
/* ADDED BY KAMATCHI S FOR ML-MMOH-CRF-1527 ON 23-JUN-2020 */

//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
async function callCAMainProcedure(){

	var dialogHeight	= "90vh";
	var dialogWidth		= "80vw";
	var status			= "no";
	var arguments		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll = auto; status:" + status;
	var title			= getLabel("Common.main.label","common")+" "+getLabel("Common.Procedure.label","common");
	var callingFrom		= "TRANSCTION_BUTTON";

	var action_url		= "../../eOR/jsp/ORMainProcedure.jsp?callingFrom="+callingFrom+"&title="+title+"&patient_id="+parent.frames[2].document.forms[0].patient_id.value+"&episode_id="+parent.frames[2].document.forms[0].encounter_id.value+"&encounter_id="+parent.frames[2].document.forms[0].encounter_id.value;
	
	var retVal = await window.showModalDialog(action_url,arguments,features);

	if(parent.frames[1].document.forms[0].mds_chk.value > 0)
	{
		var jsp_url = parent.frames[1].document.location.href;
		
		if(parent.frames[1].document.forms[0].weight_on_admission)
		parent.frames[2].document.forms[0].weight_on_admission_load.value = parent.frames[1].document.forms[0].weight_on_admission.value;

		if(parent.frames[1].document.forms[0].height_on_admission)
		parent.frames[2].document.forms[0].height_on_admission_load.value = parent.frames[1].document.forms[0].height_on_admission.value;

		if(parent.frames[1].document.forms[0].bmi)
		parent.frames[2].document.forms[0].bmi_load.value = parent.frames[1].document.forms[0].bmi.value;

		parent.frames[1].document.location.href = jsp_url+"&reload_yn=Y";
	}
}

