/*Thursday, March 18, 2010 , diag_class_code & curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
//Maheshwaran K modified for SKR-SCF-0839 [IN:044168] as on 11/10/2013
function callsubmit(term_code,term_set_id,accur_code_ind,curr_accuracy_code,sex,occur_srl_no,eid,isCurrentEncounter,old_encounter_id,short_desc,diag_class_code,status,priority,nature,severity,encounter_stage,onset_type,notification_code,accession_num_work_related,accession_num_notifiable, diag_catg, diagClassMandYn)
{
	getDrugIntrValidation(term_code,term_set_id,short_desc,old_encounter_id,isCurrentEncounter);
	/*Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645*/
	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH term_code=\""+term_code+"\" term_set_id=\""+term_set_id+"\" action='getTermCodeEffStatus'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var eff_status = trimString(responseText)

	var termCodeEffStatus = parent.RecDiagnosisAddModify.document.RecDaignosis_form.termCodeEffStatus.value;
	var isPrepDisDefaultDischargeAppl = parent.RecDiagnosisAddModify.document.RecDaignosis_form.isPrepDisDefaultDischargeAppl.value;
	var function_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.function_id.value;
	if(eff_status == 'D' && termCodeEffStatus == 'true')
	{
		var error = getMessage("TERM_CODE_NOT_ACTIVE","MR");
		alert(error);
	}else
	{
	//var curr_enc = window.confirm('Do You Want update Previous encounter diagnosis to Currrent Encounter..');
	//Added by Ajay Hatwate for ML-MMOH-CRF-1741
	var crsChkMadFlds = parent.RecDiagnosisCurrentDiag.document.query_result_form.crs_chk_mand_flds.value;
	var enblLinktoCurrEnc = 						parent.RecDiagnosisCurrentDiag.document.query_result_form.enbl_link_to_curr_enc.value;
	
	var curr_enc = window.confirm(getMessage('PREV_ENC_TO_CURR_ENC','MR'));
	if(curr_enc)
	{
		//Added by Ajay Hatwate for ML-MMOH-CRF-1741
		if(diagClassMandYn == 'Y' && crsChkMadFlds == 'Y' && diag_class_code == ''){
			var Patient_Id  = parent.RecDiagnosisCurrentDiag.document.query_result_form.Patient_Id.value;
			var patient_class  = parent.RecDiagnosisCurrentDiag.document.query_result_form.patient_class.value;
			var term_set_desc  = parent.RecDiagnosisCurrentDiag.document.query_result_form.term_set_desc.value;
			var onset_date  = parent.RecDiagnosisCurrentDiag.document.query_result_form.onset_date.value;
			var notifiable_yn  = parent.RecDiagnosisCurrentDiag.document.query_result_form.notifiable_yn.value;
			var dob  = parent.RecDiagnosisCurrentDiag.document.query_result_form.dob.value;
			var age  = parent.RecDiagnosisCurrentDiag.document.query_result_form.age.value;
			var cause_of_death  = parent.RecDiagnosisCurrentDiag.document.query_result_form.cause_of_death.value;
			var Locn_Code  = parent.RecDiagnosisCurrentDiag.document.query_result_form.Locn_Code.value;
			//var isCurrentEncounter  = parent.RecDiagnosisCurrentDiag.document.query_result_form.isCurrentEncounter.value; Modified against ML-MMOH-SCF-2928
			callDetailsModal(Patient_Id, term_code, term_set_id,term_set_desc, patient_class, onset_date, notifiable_yn, dob, age, sex, occur_srl_no, '', eid,cause_of_death, Locn_Code,isCurrentEncounter,old_encounter_id,'',accession_num_notifiable,'',diag_class_code,status,notification_code,'','','', '');	
			//Patient_Id, term_code, term_set_id,term_set_desc, patient_class, onset_date, notifiable_yn, dob, age, sex, occur_srl_no, associate_codes, Encr_id,cause_of_death, Locn_Code,isCurrentEncounter,old_encounter_id,option_id,accession_no,oh_chart_num,diag_classification,status,notifiable_code,diagcode,p_called_from_widget,called_from_ot, diag_catg
		
		}else{
		//Maheshwaran K added for SKR-SCF-0839 [IN:044168] as on 11/10/2013
		//Start
		//Added Bru-HIMS-CRF-024.2
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form.value=accession_num_work_related;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value=accession_num_notifiable;
		//End Bru-HIMS-CRF-024.2
		
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.type.value=onset_type;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_code.value=notification_code;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.priority.value=priority;
		//Below condition added by Suji Keerthi for PAS-IP-ML-MMOH-CRF-1605/01-Discharge-Prepare Discharge Advice
		if(isPrepDisDefaultDischargeAppl=="true" && (function_id=="PRE_DIS_ADVICE" || function_id=="RECORD_DIAGNOSIS_FROM_POPUP") && encounter_stage=="")
		{
		encounter_stage = 'D';
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_stage.value=encounter_stage;
		}
		else
		{
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_stage.value=encounter_stage;
		}
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.nature.value=nature;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.severity.value=severity;
		//End
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.accry_code_ind.value=accur_code_ind;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.accry_code.value=curr_accuracy_code;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value=term_set_id;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=term_code;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.occur_srl_no_hid.value=occur_srl_no;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.Encounter_Id.value=eid;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.old_encounter_id.value=old_encounter_id;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value='modify_curr_enc';
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.disabled=false;
		/*Monday, March 15, 2010 ,since PR_DIAGNOSIS_ENC_DTL->TERM_CODE_SHORT_DESC value updating is null for free text diagnosis */
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=short_desc;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=false;
		/**/
		/*Thursday, March 18, 2010 , diag_class_code & curr_status added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
		var obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;
		opt=parent.RecDiagnosisAddModify.document.createElement('OPTION');
		opt.value=diag_class_code;
		obj.add(opt);
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication.value=diag_class_code;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value=status;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.disabled=false;
		/**/
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.inc_encounter!=null)
		{
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.inc_encounter.checked==true)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.curr_encr_flag.value='Y';
			else
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.curr_encr_flag.value='N';
		}

		//Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.slink_flag.value='Y';

		parent.RecDiagnosisAddModify.document.RecDaignosis_form.action="../../servlet/eMR.RecDiagnosisServlet";
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.submit();
	    }
	  }
   }
}


function callDetailsModal(Patient_Id, term_code, term_set_id,term_set_desc, patient_class, onset_date, notifiable_yn, dob, age, sex, occur_srl_no, associate_codes, Encr_id,cause_of_death, Locn_Code,isCurrentEncounter,old_encounter_id,option_id,accession_no,oh_chart_num,diag_classification,status,notifiable_code,diagcode,p_called_from_widget,called_from_ot, diag_catg){ //CHL-CRF- 0008 - IN:001472
	modal_yn=parent.RecDiagnosisCurrentDiag.document.query_result_form.modal_yn.value;	
	called_from_ip=parent.RecDiagnosisCurrentDiag.document.query_result_form.called_from_ip.value
	function_id=parent.RecDiagnosisCurrentDiag.document.query_result_form.function_id.value
	var locn_type = parent.RecDiagnosisCurrentDiag.document.query_result_form.Locn_Type.value;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='13'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		parent.RecDiagnosisAddModify.document.location.href="../../eMR/jsp/RecDiagnosisAddModify.jsp?Locn_Code="+Locn_Code+"&cause_of_death="+cause_of_death+"&Patient_Id="+Patient_Id+"&called_from_ip="+called_from_ip+"&term_code="+encodeURIComponent(term_code)+"&term_set_id="+term_set_id+"&term_set_desc="+term_set_desc+"&patient_class="+patient_class+"&onset_date="+encodeURIComponent(onset_date)+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&occur_srl_no="+occur_srl_no+"&mode=modify_curr_enc&associate_codes="+associate_codes+"&modal_yn="+modal_yn+"&Encounter_Id="+Encr_id+"&notifiable_yn="+notifiable_yn+"&practitioner_type="+parent.RecDiagnosisCurrentDiag.document.query_result_form.practitioner_type.value+"&Practitioner_Id="+parent.RecDiagnosisCurrentDiag.document.query_result_form.Practitioner_Id.value+"&isCalledFromCA="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value+"&isCurrentEncounter="+isCurrentEncounter+"&old_encounter_id="+old_encounter_id+"&option_id="+option_id+"&accession_num="+accession_no+"&oh_chart_num="+oh_chart_num+"&status="+status+"&Locn_Type="+locn_type+"&diag_classification="+diag_classification+"&diagnosis_category="+diag_catg+"&notifiable_code="+notifiable_code+"&diagcode="+diagcode+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot+"&function_id="+function_id+"";
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' ){
		
			parent.parent.frames[1].document.getElementById('RecDiagMain').rows="3%,15%,3%,*,4%,0%,7%";
			parent.blankframe1.location.href="../../eCommon/jsp/error.jsp";
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}
		else{
			parent.parent.frames[1].document.getElementById('RecDiagMain').rows="7%,2%,15%,3%,*,4%,0%,7%";
			parent.blankframe1.location.href="../../eCommon/jsp/error.jsp";
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}
	}
	else
	{
		if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById('isCalledFromCA').value=='Y')
			top.content.workAreaFrame.RecDiagnosisMain.document.getElementById('RecDiagMain').rows="7%,15%,3%,*,4%,0%,7%";
		else
			top.content.workAreaFrame.RecDiagnosisMain.document.getElementById('RecDiagMain').rows="7%,7%,15%,3%,*,4%,0%,7%";		
	}
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';
	parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.record.disabled=false;
}


function Record()
{
	var status = parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value;
	var isCalledFromCA = parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value;
	var patient_id		= parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
	var Encounter_Id	= parent.RecDiagnosisAddModify.document.RecDaignosis_form.Encounter_Id.value;
	var diagcode = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var diagset = parent.RecDiagnosisAddModify.document.forms[0].code_set.value;
	var restrictVal  = "N";
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH patient_id=\""+patient_id+"\" Encounter_Id=\""+Encounter_Id+"\" diagcode=\""+diagcode+"\" diagset=\""+diagset+"\" action='getRestrictDrugYN' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	if(responseText!=""){
					var retVal_arr = responseText.split("@#");
					for(var i=0;i<retVal_arr.length-1;i++){
						var code_desc_arr = retVal_arr[i].split("|~|");
						restrictVal 	= trimString(code_desc_arr[0]);
					}
				}

	/*Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645*/
	var term_code_set = parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
	var diag_term_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.inc_encounter)
	{
		var inc_encounter_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.inc_encounter.checked;
	}
	var termCodeEffStatus = parent.RecDiagnosisAddModify.document.RecDaignosis_form.termCodeEffStatus.value;

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH term_code=\""+diag_term_code+"\" term_set_id=\""+term_code_set+"\" action='getTermCodeEffStatus'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var eff_status = trimString(responseText)

	if(eff_status == 'D' && inc_encounter_yn == true && termCodeEffStatus == 'true')
	{
		var error = getMessage("TERM_CODE_NOT_ACTIVE","MR");
		alert(error);
	}else
	{
		var  retVal=parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.as_evidenced_by.value;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.as_evidenced_by_hid.value = retVal;
		if((restrictVal != 'Y' || restrictVal != "Y" ) && (status == 'A' || status == 'R' || status == 'X'  || status == 'E') ){
		checkrecord();
		}
	}
}

/* Valdiating for Mandatory field...by Ashok Raja modified date on 1/28/2005*/
function checkrecord()
{

	indx=parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication.selectedIndex;
	if(indx>0 && eval("parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_class_type_"+indx)){
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_class_type.value=eval("parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_class_type_"+indx).value;
	}
	var code_indicator = parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value;
	var diag_set = parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
	var associate_codes = parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes.value;
	var AddAssociateCodes = parent.RecDiagnosisAddModify.document.getElementById("AddAssociateCodes").disabled;
	var ext_mand_for_consq =  parent.RecDiagnosisAddModify.document.RecDaignosis_form.ext_mand_for_consq.value;
	var astk_mand_for_dagg =  parent.RecDiagnosisAddModify.document.RecDaignosis_form.astk_mand_for_dagg.value;
	var SiteSpecific_NotiForm = parent.RecDiagnosisAddModify.document.RecDaignosis_form.legendChangeAsTypesOfNotiForm.value; //Added by Sangeetha for ML-MMOH-CRF-0547
	var notifiableLegndChgApplYn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiableLegndChgApplYn.value;
	var renameAsteriskToDagger_yn = parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.renameAsteriskToDagger_yn.value; //Added by Sangeetha for ML-MMOH-SCF-0714 on 15/may/17

	if(diag_set = "ICD10")
	{
		if(AddAssociateCodes == false)
		{
			
			if(code_indicator == "C" && ext_mand_for_consq == "Y")
			{
				if((associate_codes == "" || associate_codes == undefined || associate_codes==null))
				{
					var error = getMessage("CAN_NOT_BE_BLANK","Common");
					error = error.replace("$",getLabel("eMR.SupportingDiagnosisCode.label","MR"));
					alert(error);
					return false;
				}
			}
		}

		if(code_indicator == "D" && astk_mand_for_dagg == "Y" && (associate_codes == "" || associate_codes == undefined || associate_codes == null))
		{
			//Added by Sangeetha for ML-MMOH-SCF-0714 on 15/may/17
			if(renameAsteriskToDagger_yn == "Y"){
				var error = getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace("$",getLabel("eMR.DaggerCode.label","MR"));
				alert(error);
			}
			else{
				var error = getMessage("ASTERIX_CODE_NOT_EXISTS","MR");
				alert(error);
			}
			return false;
		}
	}



	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value =='modify')
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.disabled==true)
		{
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.disabled=false;
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value !='A')
			{
				alert(getMessage("MR_DIAG_CURR_ACTIVE",'MR'));
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.disabled=true;
				return false;
			}
		}
		
	}
/*
	if(parent.frames[3].document.RecDaignosis_form.onset_date.value!='' && parent.frames[3].document.RecDaignosis_form.status_date.value!='' && parent.frames[3].document.getElementById("DiagTable.style.visibility=='visible')
	{
		
		if(!(parent.RecDiagnosisAddModify.document.RecDaignosis_form.status_date.onblur() && parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_date.onblur()) )
		{
			return false;
		}
			
	}
*/
	/*if(parent.frames[3].document.RecDaignosis_form.code_indicator.value=="C" && (parent.frames[3].document.RecDaignosis_form.associate_codes.value==null || parent.frames[3].document.RecDaignosis_form.associate_codes.value==""))
	{
		
		var msg = getMessage('CAN_NOT_BE_BLANK','Common');
		msg	=	msg.replace("$",getLabel("Common.SupportingDiagnosis.label","Common"));
		alert(msg);
		return false;
	}*/

	var p = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=p;

	var fields=new Array();
	var names = new Array();
	var p = 0;

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_stage.style.visibility=='visible')
	{
		fields[p] = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_stage;
		//names[p] = getLabel("eMR.DiagnosisStage.label","MR");
		names[p] = getLabel("eMR.EncounterStage.label","MR");
		p++;
	}
	
		fields[p] = parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set;
		names[p] = getLabel("eMR.DiagnosisSet.label","MR");
		p++;
	
	
	if(parent.RecDiagnosisAddModify.document.getElementById("DiagTable").style.visibility=='visible')
	{
	fields[p] = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc;
	//names[p] = getLabel("eMR.DiagnosisProblemCode.label","MR");
	names[p] = getLabel("Common.diagnosis.label","Common");
	p++;
	}

	if(parent.RecDiagnosisAddModify.document.getElementById("isMultiDescAppl").value=="true" && parent.RecDiagnosisAddModify.document.getElementById("other_disp1"))
	{ // Added by mujafar for ML-MMOH-CRF-1281 US3
		if(parent.RecDiagnosisAddModify.document.getElementById("other_disp1").style.visibility=='visible')
		{
		 fields[p]=parent.RecDiagnosisAddModify.document.getElementById("term_oth_desc");
	     names[p] = getLabel("Common.other.label","Common")+" "+getLabel("Common.description.label","Common")+"s" ; 
		 p++;
		}
	}
	




	if(parent.RecDiagnosisAddModify.document.getElementById("DiagTable").style.visibility=='visible')
	{
		fields[p] = parent.RecDiagnosisAddModify.document.RecDaignosis_form.accuracy;
		names[p] = getLabel("Common.Accuracy.label","Common");
		p++;
	}


	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.nature_appl_yn.value=='Y' && parent.RecDiagnosisAddModify.document.getElementById("DiagTable").style.visibility=='visible')
	{
		fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.nature;
		names[p] = getLabel("Common.Nature.label","Common");
		p++;
	}
	else
	{
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.nature.value="";
	}

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.priority_appl_yn.value=='Y' && parent.RecDiagnosisAddModify.document.getElementById("DiagTable").style.visibility=='visible')
	{
		fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.priority;
		names[p] = getLabel("Common.priority.label","Common");
		p++;
	}
	else
	{
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.priority.value="";
	}

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.severity_appl_yn.value=='Y' && parent.RecDiagnosisAddModify.document.getElementById("DiagTable").style.visibility=='visible')
	{
		fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.severity;
		names[p] = getLabel("Common.Severity.label","Common");
		p++;
	}
	else
	{
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.severity.value="";
	}

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_type_appl_yn.value!='Y')
	{
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.type.value="";
	}
/*Added For Incident:IN025813*/
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.enc_stage_appl_yn.value!='Y')
	{
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_stage.value="";
	}

/*
	if(parent.frames[3].document.RecDaignosis_form.type.value=='' && parent.frames[3].document.RecDaignosis_form.onset_type_appl_yn.value=='Y' && parent.frames[3].document.getElementById("DiagTable.style.visibility=='visible')
	{
		fields[p]= parent.frames[3].document.RecDaignosis_form.type;
		names[p] = getLabel("eMR.OnsetType.label","MR");
		p++;
	}
*/
	
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value=='E' && parent.RecDiagnosisAddModify.document.getElementById("DiagTable").style.visibility=='visible')
	{
		fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.remarks;
		names[p] = getLabel("Common.remarks.label","Common");
		p++;
	}

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_date.value=='' &&  parent.RecDiagnosisAddModify.document.getElementById("DiagTable").style.visibility=='visible')
	{
		fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_date;
		names[p] = getLabel("Common.onsetdate.label","Common");
		p++;
	}
	

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.status_date.value=='' &&  parent.RecDiagnosisAddModify.document.getElementById("DiagTable").style.visibility=='visible')
	{
		fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.status_date;
		names[p] = getLabel("Common.Ason.label","Common");
		p++;
	}

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication.value=='' &&  parent.RecDiagnosisAddModify.document.getElementById("diag_class_img").style.visibility=='visible')
	{ 
		fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication;
		names[p] = getLabel("Common.diagnosis.label","Common")+" "+getLabel("Common.Classification.label","Common") ;
		p++;
	}
	//Maheshwaran K added for TH-KW-CRF-165.1
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_category) {
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_category.value=='' &&  parent.RecDiagnosisAddModify.document.getElementById("diag_catg_img").style.visibility=='visible')
	{ 
		fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_category;
		names[p] = getLabel("Common.diagnosis.label","Common")+" "+getLabel("Common.category1.label","Common") ;
		p++;
	}
	}
	//Added for Bru-HIMS-CRF-024.2	
	//if((parent.RecDiagnosisAddModify.document.getElementById("notifi_frm_mand_gif.style.visibility=='visible' && parent.RecDiagnosisAddModify.document.RecDaignosis_form.notification_setup.value=='') || (parent.RecDiagnosisAddModify.document.getElementById("notifi_frm_mand_gif.style.visibility=='visible' && parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form.value==''))
	if((parent.RecDiagnosisAddModify.document.getElementById("notifi_frm_mand_gif").style.visibility=='visible' && parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form.value==''))
	{  
	   // if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.notification_setup=="")
		 //   fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.notification_setup;
			
		    fields[p]= parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form;
			
			//Added by Sangeetha for ML-MMOH-CRF-0547
			if(SiteSpecific_NotiForm == "true"){
			names[p] = getLabel("eMR.TypesofNotificationFormNotRecorded.label","MR");
			}else if(notifiableLegndChgApplYn=="true"){
				names[p] = getLabel("eMR.Notifiable.label","MR");
			}else {
		    names[p] = getLabel("eMR.WorkRelatedFormNotRecorded.label","MR");
			}
		p++;
		
	}
	
	
	//if(parent.RecDiagnosisAddModify.checkFieldsofMst( fields, names, parent.messageFrame)) 
    if(checkFieldsofMandatory(fields, names, parent.messageFrame)) 
	{  
		var errors="";
		for (var i=0 ; i<fields.length ; i++)
		{    
			if (trimCheck(fields[i].value))
			{
				fields[i].value=trimString(fields[i].value);
			}
			else
				errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(names[i]))+"\n";
		}
		
		if (errors.length !=0)
		{
			top.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
			return false ;
		}
		/*
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value.indexOf("'")!=-1)
			{
				
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value.replace("'","");
		}
		*/
	
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.disabled=false;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=false;
		//
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.anatomical_site!=null)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.anatomical_site.disabled=false;
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.applicable_side!=null)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.applicable_side.disabled=false;
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.anatomical_oral_sites!=null) //Changes Done by Saanthaakumar
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.anatomical_oral_sites.disabled=false; //Changes Done by Saanthaakumar
		//
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value != "modify")
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.disabled=false;

			var recode_curr_level	= parent.RecDiagnosisAddModify.document.RecDaignosis_form.recode_curr_level.value;
			var err_status				= parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value;
			/*The following Codition and was added on:12/6/2010 for SRR20056-SCF-5914 [IN:024929] */
			var isCurrentEncounter			= parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCurrentEncounter.value;
			var include_curr_enc_obj	= parent.RecDiagnosisAddModify.document.RecDaignosis_form.inc_encounter;;
			var include_curr_enc_val="Y";
			if(include_curr_enc_obj){
				if(include_curr_enc_obj.checked==true){
						include_curr_enc_val="Y";
				}else{
						include_curr_enc_val="N";
				}
			}
			//if(isCurrentEncounter=="Y" && include_curr_enc_val=="N"){
			//Maheshwaran added this condition,to avoid recording of previous enc diags with error status
			
			if((isCurrentEncounter=="Y" && include_curr_enc_val=="N" )||(parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value=="E" && isCurrentEncounter=="Y" )){
				var err_msg=getMessage("CANNOT_MODIFY_PREV_ENC_DATA","MR");
				alert(err_msg);
				return false;
			}else if(err_status=="E" && recode_curr_level!=0){
				var err_msg=getMessage("RECODING_IN_PROGRESS","MR");
				if(confirm(err_msg)){
					
					parent.RecDiagnosisAddModify.document.RecDaignosis_form.action="../../servlet/eMR.RecDiagnosisServlet";
					parent.RecDiagnosisAddModify.document.RecDaignosis_form.target="messageFrame";
					parent.RecDiagnosisAddModify.document.RecDaignosis_form.submit();
					//setTimeout('eNotifikasi()',500);
				}
			}else{
					
					parent.RecDiagnosisAddModify.document.RecDaignosis_form.action="../../servlet/eMR.RecDiagnosisServlet";
					parent.RecDiagnosisAddModify.document.RecDaignosis_form.target="messageFrame";
					parent.RecDiagnosisAddModify.document.RecDaignosis_form.submit();
					//setTimeout('eNotifikasi()',500);
			}
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.disabled=true;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=true;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.as_evidenced_by_hid.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value=''; //Added for Bru-HIMS-CRF-024.2
		//setTimeout('reloadSecondFrame()',1000)
			
			
			
			
		
	}
}

function eNotifikasi(Patient_Id, Encounter_Id,term_set_id,term_code,Stage){
	
	var returnValue = "";
	var dataElements = "<PATIENT_ID>"+Patient_Id+"$!^<ENCOUNTER_ID>"+Encounter_Id+"$!^<TERMSET_ID>"+term_set_id+"$!^<TERMCODE>"+term_code+"$!^<TERMSTAGE>"+Stage+"$!^<TERMSTATUS>";

	returnValue = checkEnotification (dataElements);

	if (returnValue != "")
	{
		alert(returnValue);
	}


}
function reloadSecondFrame()
{
	
	parent.RecDiagnosisCurrentDiag.location.reload();	
	
	parent.RecDiagnosisAddModify.location.reload();	
}

function Cancel()
{
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
	{
		parent.window.close();
	}
	else
	{
		top.content.workAreaFrame.location.href ='../../eCommon/html/blank.html';
/*
		top.content.workAreaFrame.RecDiagnosisMain.document.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.document.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisOpernToolbar.document.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.messageFrame.document.location.href ='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisMain.document.location.href='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecDiagnosisFrame.document.location.href='../../eCommon/html/blank.html';
*/
	}
}

function Image_Enable()
{	
	
		var status_value=parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value;
		if(status_value =='E' )
		parent.RecDiagnosisAddModify.document.getElementById("remk_image").style.visibility = "Visible";
		else
		parent.RecDiagnosisAddModify.document.getElementById("remk_image").style.visibility ='hidden';
}

function CheckDate(Object2,focusflag) 
{
    var datefield = Object2;
    if (ChkDate(Object2) == false) 
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		if(focusflag == null)
		{
		datefield.select();
		datefield.focus();
		}
		return false;
	}
	else 
	{
		return true;
	}
}

function CheckForNumber_L(Objval,obj1) 
{
	val = Objval.value;
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
  	return true;
	else
	{
		if ( val.length > 0 ) 
		{
			if(obj1.name=="onset_date")
				document.forms[0].onset_date.value='';
			else if(obj1.name=="close")
				document.forms[0].close.value='';

			alert(getMessage('NUM_ALLOWED','SM'));
			Objval.select();
			Objval.focus();
			return false;
		}
	}
}

function checkMonth(Obj,obj1)
{
	if( Obj.value  > 11) 
	{ 
		alert(getMessage('MONTH_NOT_GR_11','MP')); 
		Obj.focus(); 
		if (obj1.name=="onset_date")
		{
			document.forms[0].onset_date.value='';
			document.forms[0].b_months.value='';

		}
		else if(obj1.name=="close")
		document.forms[0].close.value='';
	}
}

function checkDays(Obj,obj1)
{
	if( Obj.value  > 31) 
	{ 
		alert(getMessage('DAYS_NOT_31_CH','MP')); 
		Obj.focus(); 
		if (obj1.name=="onset_date")
		{
			document.forms[0].onset_date.value=''; 
			document.forms[0].b_days.value=''; 		
		}
		else if(obj1.name=="close")
			document.forms[0].close.value=''; 
	}
}


function calci(Obj)
{

/*	if ( (document.forms[0].b_months.value=='') && (document.forms[0].b_days.value=='') && (document.forms[0].b_age.value=='') )
	{
		return false;
	}
*/

	//var hide= document.forms[0].current_date.value;
	var hide= convertDate(document.forms[0].current_date.value,'DMY',localeName,'en');
	var ind = -1;
	if  (document.forms[0].mode.value == "modify")  
	{
	   //hide= document.forms[0].onset_date.value;
	   hide= convertDate(document.forms[0].onset_date.value,'DMYHM',localeName,'en');
	   if ( (ind=hide.indexOf(" ")) != -1 )
	   {
			  hide  = hide.substring(0,ind);
	   }
	}

	strDateArray = hide.split("/");
	if (strDateArray.length != 3) ;
	else 
	{
		strDay = strDateArray[0];
		strMonth = strDateArray[1];
		strYear = strDateArray[2];
	}

	if ( (Obj.name == 'b_age') || Obj.value >0) 
	{
		
		var yy = 0;
		if (document.forms[0].b_age.value!='')
		{
			yy=document.forms[0].b_age.value;
		}
		days = new Date();
		gdate = days.getDate();
		gmonth = days.getMonth();
		gyear = days.getFullYear();
		age = strYear - yy;
		//document.forms[0].onset_date.value=strDay+"/"+strMonth+"/"+age+" "+document.forms[0].current_time.value;
		document.forms[0].onset_date.value= convertDate(strDay+"/"+strMonth+"/"+age+" "+document.forms[0].current_time.value,'DMYHM','en',localeName);
		document.forms[0].text5.value=strDay+"/"+strMonth+"/"+age;
	}
	
	if( (Obj.name == 'b_months') || (document.forms[0].b_months.value >0 && document.forms[0].b_months.value <12) )
	{
		
	if(document.forms[0].text5.value == '') 	
	{
		if ( document.forms[0].mode.value == "modify")
		{
		   //var temp = 	document.forms[0].onset_date.value;
		   var temp = 	convertDate(document.forms[0].onset_date.value,'DMYHM',localeName,'en');
		   if ( (ind=temp.indexOf(" ")) != -1 )
		   {
				  temp  = temp.substring(0,ind);
		   }
		   document.forms[0].text5.value=temp;
		}
		else
			document.forms[0].text5.value= convertDate(document.forms[0].current_date.value,'DMY',localeName,'en');
			//document.forms[0].text5.value=document.forms[0].current_date.value;

	}
	var hide1= document.forms[0].text5.value;
	
	var mm = 0;
	if (document.forms[0].b_months.value!='')
	{
		mm=document.forms[0].b_months.value;
		
	}

	strDateArray1 = hide1.split("/");
	strDay1 = strDateArray1[0];
	strMonth1 = strDateArray1[1];
	strYear1 = strDateArray1[2];
	strMonth1=strMonth1-mm;
	if(strMonth1 <=0)
	{
		strMonth1=12+strMonth1;
		strYear1=strYear1-1;
	}

	if(strMonth1 == "1") strMonth1="01";
	if(strMonth1 == "2") strMonth1="02";
	if(strMonth1 == "3") strMonth1="03";
	if(strMonth1 == "4") strMonth1="04";
	if(strMonth1 == "5") strMonth1="05";
	if(strMonth1 == "6") strMonth1="06";
	if(strMonth1 == "7") strMonth1="07";
	if(strMonth1 == "8") strMonth1="08";
	if(strMonth1 == "9") strMonth1="09";

	if(strDay == "1") strDay="01";
	if(strDay == "2") strDay="02";
	if(strDay == "3") strDay="03";
	if(strDay == "4") strDay="04";
	if(strDay == "5") strDay="05";
	if(strDay == "6") strDay="06";
	if(strDay == "7") strDay="07";
	if(strDay == "8") strDay="08";
	if(strDay == "9") strDay="09";
	//document.forms[0].onset_date.value=strDay+"/"+strMonth1+"/"+strYear1+" "+document.forms[0].current_time.value;
	document.forms[0].onset_date.value= convertDate(strDay+"/"+strMonth1+"/"+strYear1+" "+document.forms[0].current_time.value,'DMYHM','en',localeName);
	document.forms[0].text6.value=strDay+"/"+strMonth1+"/"+strYear1;
	}
	if( (Obj.name == 'b_days') || (document.forms[0].b_days.value >0 && document.forms[0].b_days.value <32))
	{
		
	if(document.forms[0].text6.value == '')  
	{
		if ( document.forms[0].mode.value == "modify")
		{
		  // var temp1 = 	document.forms[0].onset_date.value;
		   var temp1 = 	convertDate(document.forms[0].onset_date.value,'DMYHM',localeName,'en');
		
		   if ( (ind=temp1.indexOf(" ")) != -1 )
		   {
				  temp1  = temp1.substring(0,ind);
		   }
		   document.forms[0].text6.value=temp1;
		}
		else
			document.forms[0].text6.value= convertDate(document.forms[0].current_date.value,'DMY',localeName,'en');
			//document.forms[0].text6.value=document.forms[0].current_date.value;
	}
	var hide2= document.forms[0].text6.value;
	
	var dd = 0;
	if (document.forms[0].b_days.value!='')
	{
		dd=document.forms[0].b_days.value;
	}

	strDateArray2 = hide2.split("/");

	strDay2 = strDateArray2[0];
	strMonth2= strDateArray2[1];
	strYear2 = strDateArray2[2];
	strDay=strDay2-dd;

	if(strDay <=0)
	{
		strMonth2=strMonth2-1;
		
		if(strMonth2 <=0)
		{
			strMonth2=12+strMonth2;
			strYear2=strYear2-1;
		}

		if(strMonth2 == 2)
		{
			if(leapyear(strYear2))
			{
				strDay=29+strDay+2;
			}
			else
			{	
				strDay=28+strDay;
			}
		}
		else if((strMonth2 == 4) || (strMonth2 == 6) || (strMonth2 == 9) || (strMonth2 == 11))
		{
			strDay=30+strDay;
		}
		else
		{
			strDay=31+strDay-1;
		}
	}
	if(strMonth2 == "1") strMonth2="01";
	if(strMonth2 == "2") strMonth2="02";
	if(strMonth2 == "3") strMonth2="03";
	if(strMonth2 == "4") strMonth2="04";
	if(strMonth2 == "5") strMonth2="05";
	if(strMonth2 == "6") strMonth2="06";
	if(strMonth2 == "7") strMonth2="07";
	if(strMonth2 == "8") strMonth2="08";
	if(strMonth2 == "9") strMonth2="09";

	if(strDay == "1") strDay="01";
	if(strDay == "2") strDay="02";
	if(strDay == "3") strDay="03";
	if(strDay == "4") strDay="04";
	if(strDay == "5") strDay="05";
	if(strDay == "6") strDay="06";
	if(strDay == "7") strDay="07";
	if(strDay == "8") strDay="08";
	if(strDay == "9") strDay="09";
	//document.forms[0].onset_date.value=strDay+"/"+strMonth2+"/"+strYear2+" "+document.forms[0].current_time.value;
	document.forms[0].onset_date.value= convertDate(strDay+"/"+strMonth2+"/"+strYear2+" "+document.forms[0].current_time.value,'DMYHM','en',localeName);
	}

/*
	var hide= document.forms[0].onset_date1.value;

	var hide= document.forms[0].current_date.value;
		var ind = -1;
		if  (document.forms[0].mode.value == "modify")  
		{
		   hide= document.forms[0].onset_date.value;
		   if ( (ind=hide.indexOf(" ")) != -1 )
		   {
				  hide  = hide.substring(0,ind);
		   }
		}


	strDateArray = hide.split("/");
	if (strDateArray.length != 3) ;
	else 
	{
		strDay = strDateArray[0];
		strMonth = strDateArray[1];
		strYear = strDateArray[2];
	}
	if(Obj.name == 'b_age' || Obj.value >0)
	{
		var yy=document.forms[0].b_age.value;
		days = new Date();
		gdate = days.getDate();
		gmonth = days.getMonth();
		gyear = days.getFullYear();
		age = strYear - yy;
		
		document.forms[0].onset_date.value=strDay+"/"+strMonth+"/"+age;
		document.forms[0].text5.value=document.forms[0].onset_date.value;
	}
	
	if(Obj.name == 'b_months' || (document.forms[0].b_months.value >0 && document.forms[0].b_months.value <12))
	{
		if(document.forms[0].text5.value == '') 	
			document.forms[0].text5.value=document.forms[0].onset_date.value;

		var hide1= document.forms[0].text5.value;
		var mm=document.forms[0].b_months.value;
		strDateArray1 = hide1.split("/");
		strDay1 = strDateArray1[0];
		strMonth1 = strDateArray1[1];
		strYear1 = strDateArray1[2];
		strMonth1=strMonth1-mm;
		if(strMonth1 <=0)
		{
			strMonth1=12+strMonth1;
			strYear1=strYear1-1;
		}

		if(strMonth1 == "1") strMonth1="01";
		if(strMonth1 == "2") strMonth1="02";
		if(strMonth1 == "3") strMonth1="03";
		if(strMonth1 == "4") strMonth1="04";
		if(strMonth1 == "5") strMonth1="05";
		if(strMonth1 == "6") strMonth1="06";
		if(strMonth1 == "7") strMonth1="07";
		if(strMonth1 == "8") strMonth1="08";
		if(strMonth1 == "9") strMonth1="09";

		if(strDay == "1") strDay="01";
		if(strDay == "2") strDay="02";
		if(strDay == "3") strDay="03";
		if(strDay == "4") strDay="04";
		if(strDay == "5") strDay="05";
		if(strDay == "6") strDay="06";
		if(strDay == "7") strDay="07";
		if(strDay == "8") strDay="08";
		if(strDay == "9") strDay="09";

		document.forms[0].onset_date.value=strDay+"/"+strMonth1+"/"+strYear1;
		document.forms[0].text6.value=document.forms[0].onset_date.value;
	}

	if(Obj.name == 'b_days' || (document.forms[0].b_days.value >0 && document.forms[0].b_days.value <32))
	{
	if(document.forms[0].text6.value == '')  document.forms[0].text6.value=document.forms[0].onset_date.value;
	var hide2= document.forms[0].text6.value;
	var dd=document.forms[0].b_days.value;
	strDateArray2 = hide2.split("/");

	strDay2 = strDateArray2[0];
	strMonth2= strDateArray2[1];
	strYear2 = strDateArray2[2];
	strDay=strDay2-dd;

	if(strDay <=0)
	{
		strMonth2=strMonth2-1;
		if(strMonth2 == 2)
		{
			if(leapyear(strYear2))
			{
				strDay=29+strDay+2;
			}
			else
			{	
				strDay=28+strDay;
			}
		}
		else if((strMonth2 == 4) || (strMonth2 == 6) || (strMonth2 == 9) || (strMonth2 == 11))
		{
			strDay=30+strDay;
		}
		else
		{
			strDay=31+strDay-1;
		}
	}
	if(strMonth2 == "1") strMonth2="01";
	if(strMonth2 == "2") strMonth2="02";
	if(strMonth2 == "3") strMonth2="03";
	if(strMonth2 == "4") strMonth2="04";
	if(strMonth2 == "5") strMonth2="05";
	if(strMonth2 == "6") strMonth2="06";
	if(strMonth2 == "7") strMonth2="07";
	if(strMonth2 == "8") strMonth2="08";
	if(strMonth2 == "9") strMonth2="09";

	if(strDay == "1") strDay="01";
	if(strDay == "2") strDay="02";
	if(strDay == "3") strDay="03";
	if(strDay == "4") strDay="04";
	if(strDay == "5") strDay="05";
	if(strDay == "6") strDay="06";
	if(strDay == "7") strDay="07";
	if(strDay == "8") strDay="08";
	if(strDay == "9") strDay="09";

	document.forms[0].onset_date.value=strDay+"/"+strMonth2+"/"+strYear2;
	}
*/
}

function calcfields(obj1,obj2) 
{
	if(obj1.value != '' && obj2.value != '' )
	{

		var a = obj1.value;
		var b = obj2.value;

		var a=  a.split(" ");
		var b=  b.split(" ");
		var datecal="";
		var datecal="";

		datecal=a[0];
		datecal2=b[0];


		if(obj1.value.length !=0)
		{
				strDateArray = datecal.split("/");

				if (strDateArray.length != 3) ;
				else 
				{
					strDay = strDateArray[0];
					strMonth = strDateArray[1];
					strYear = strDateArray[2];
				}

				var ageYears, ageMonths, ageDays;
		
				bornDate = new Date(strMonth+'/'+strDay+'/'+strYear);
				mm = bornDate.getMonth()+1 ;
				dd = bornDate.getDate();
				yy = bornDate.getFullYear();


				strDateArray1 = datecal2.split("/");

				if (strDateArray.length != 3) ;
				else 
				{
					strDay1 = strDateArray1[0];
					strMonth1 = strDateArray1[1];
					strYear1 = strDateArray1[2];
				}

				testDate = new Date(strMonth1+'/'+strDay1+'/'+strYear1);
				mm2 = testDate.getMonth()+1 ;
				dd2 = testDate.getDate();
				yy2 = testDate.getFullYear();
		

				if (yy < 100 && yy > 20) 
				{
					yy = yy + 1900
				}
				if (yy2 < 100)
				{
					if (yy2 > 20) 
					{
						yy2 = yy2 + 1900
					}
					else
					{
						yy2 = yy2 + 2000
					}
				}
		
				ageYears = yy2 - yy

				if(mm2 == mm)
				{
					if(dd2 < dd)
					{
						mm2 = mm2 + 12;
						ageYears = ageYears - 1;
					}
				}

				if(mm2 < mm)
				{
					mm2 = mm2 + 12;
					ageYears = ageYears - 1;
					ageMonths = mm2 - mm;
				}

				ageMonths = mm2 - mm;

				if (dd2 < dd) 
				{
					ageMonths = ageMonths - 1;
					if((ageMonths == 4) || (ageMonths == 6) || (ageMonths == 9) || (ageMonths == 11))
					{
						dd2 = dd2 + 30;
					}
					else
					if(ageMonths == 2)
					{
						dd2=dd2+30;
					}
					else
					{
						dd2=dd2+30;
					}
					if (mm2 == mm) 
					{
						ageMonths = 0;
						ageYears = ageYears - 1;
					}
				}

				ageDays = dd2 - dd;
				if(	document.forms[0].b_age!=null && document.forms[0].mode.value!='modify')
				{
					document.forms[0].b_age.value= ageYears ;
					if(document.forms[0].b_age.value.length == 1  && document.forms[0].b_age.value !='0') document.forms[0].b_age.value="0"+ageYears ;
					
					document.forms[0].b_months.value=ageMonths;
					if(document.forms[0].b_months.value.length == 1 && document.forms[0].b_months.value !='0') document.forms[0].b_months.value="0"+ageMonths;
					
					document.forms[0].b_days.value=ageDays;
					if(document.forms[0].b_days.value.length == 1 && document.forms[0].b_days.value !='0') document.forms[0].b_days.value="0"+ageDays;
				}
				else if(document.forms[0].mode.value!='modify')
				{
					document.forms[0].b_age1.value= ageYears ;
					if(document.forms[0].b_age1.value.length == 1  && document.forms[0].b_age1.value !='0') document.forms[0].b_age1.value="0"+ageYears ;
										
					document.forms[0].b_months1.value=ageMonths;
					if(document.forms[0].b_months1.value.length == 1 && document.forms[0].b_months1.value !='0') document.forms[0].b_months1.value="0"+ageMonths;
										
					document.forms[0].b_days1.value=ageDays;
					if(document.forms[0].b_days1.value.length == 1 && document.forms[0].b_days1.value !='0') document.forms[0].b_days1.value="0"+ageDays;
				}
			}
	}
	else if(obj1.value == '' )
	{
		if(	document.forms[0].b_age!=null && document.forms[0].mode.value!='modify')
		{
			document.forms[0].b_days.focus();
		}
		else if(document.forms[0].mode.value!='modify')
		{
			document.forms[0].b_days1.focus();
		}
	}
}

function calcage(obj1,obj2) 
{

	if(doDateCheckAlert(obj1,obj2))
	{
		if(CheckDate(obj1) == false)
		obj1.focus();
		else
		{
			if(obj1.value.length !=0)
			{
				var datecal=obj1.value;
				strDateArray = datecal.split("/");
				if (strDateArray.length != 3) ;
				else {
				strDay = strDateArray[0];
				strMonth = strDateArray[1];
				strYear = strDateArray[2];
			}
		    var ageYears, ageMonths, ageDays
		    var datecal2=obj2.value;
			bornDate = new Date(strMonth+'/'+strDay+'/'+strYear);
		    mm = bornDate.getMonth()+1 ;
		    dd = bornDate.getDate();
			yy = bornDate.getFullYear();
	
			strDateArray1 = datecal2.split("/");
			if (strDateArray.length != 3) ;
			else {
					strDay1 = strDateArray1[0];
					strMonth1 = strDateArray1[1];
					strYear1 = strDateArray1[2];
			}

		    testDate = new Date(strMonth1+'/'+strDay1+'/'+strYear1);
		    mm2 = testDate.getMonth()+1 ;
		    dd2 = testDate.getDate();
		    yy2 = testDate.getFullYear();
	
			if (yy < 100 && yy > 20) {
			        yy = yy + 1900
			}
			if (yy2 < 100){
				if (yy2 > 20) {
					yy2 = yy2 + 1900
			     }else{
					yy2 = yy2 + 2000
			     }
			}
	    ageYears = yy2 - yy
    //adjust years by looking at months
    //same month, no birthday yet (add 12 months)
	    if(mm2 == mm){
			if(dd2 < dd){
				mm2 = mm2 + 12;
				ageYears = ageYears - 1;
			}
	    }
    //earlier month (add 12 months)
    if(mm2 < mm){
		mm2 = mm2 + 12;
		ageYears = ageYears - 1;
		ageMonths = mm2 - mm;
	}
		ageMonths = mm2 - mm;

	    //adjust months by looking at days
	    if (dd2 < dd) {
			ageMonths = ageMonths - 1;
			if((ageMonths == 4) || (ageMonths == 6) || (ageMonths == 9) || (ageMonths == 11))
			{
				dd2 = dd2 + 30;
			}
			else
			if(ageMonths == 2)
			{
				dd2=dd2+30;
			}
			else
			{
				dd2=dd2+30;
			}
			if (mm2 == mm) {
				ageMonths = 0;
				ageYears = ageYears - 1;
				}
	        }
	        ageDays = dd2 - dd;
	
			if(	document.forms[0].b_age!=null)
			{
				document.forms[0].b_age.value= ageYears ;
				if(document.forms[0].b_age.value.length == 1  && document.forms[0].b_age.value !='0') document.forms[0].b_age.value="0"+ageYears ;
						document.forms[0].b_months.value=ageMonths;
				if(document.forms[0].b_months.value.length == 1 && document.forms[0].b_months.value !='0') document.forms[0].b_months.value="0"+ageMonths;
					document.forms[0].b_days.value=ageDays;
				if(document.forms[0].b_days.value.length == 1 && document.forms[0].b_days.value !='0') document.forms[0].b_days.value="0"+ageDays;
			}
			else
			{
				document.forms[0].b_age1.value= ageYears ;
				if(document.forms[0].b_age1.value.length == 1  && document.forms[0].b_age1.value !='0') document.forms[0].b_age1.value="0"+ageYears ;
					document.forms[0].b_months1.value=ageMonths;
				if(document.forms[0].b_months1.value.length == 1 && document.forms[0].b_months1.value !='0') document.forms[0].b_months1.value="0"+ageMonths;
					document.forms[0].b_days1.value=ageDays;
				if(document.forms[0].b_days1.value.length == 1 && document.forms[0].b_days1.value !='0') document.forms[0].b_days1.value="0"+ageDays;
			}
			}
		}
	}
}


function DateChk(from,to) 
{
	if(from.value != "" && to.value != "")
	{
		var flg1 = validDateObj(from,"DMYHM",localeName);
		var flg2 = validDateObj(to,"DMYHM",localeName);
		//var flg3 = doDateTimeChk(to);

		if(flg1 && flg2)
		{
			if(doDateTimeChk(flg2))
			{
				var greg_fromdate = convertDate(from.value,"DMYHM",localeName,localeName);
				var greg_todate = convertDate(to.value,"DMYHM",localeName,localeName);

				
				if(!isBefore(greg_todate,greg_fromdate,'DMYHM',localeName))// DateUtils.js
				{
					var msg = getMessage("VISIT_LESS_DATE","Common");
					msg	=	msg.replace("Visit Date",getLabel("Common.onsetdate.label","Common"));
					msg	=	msg.replace("System Date",getLabel("Common.CurrentDate.label","Common"));
					alert(msg);
					to.value='';
					to.focus();
				}
				else
					gotoNext(parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_date);
			}
			else
			{
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				to.select();
				to.focus();
				document.forms[0].b_days.value="0";
				document.forms[0].b_months.value="0";
				document.forms[0].b_age.value="0";

			}		

		}
		else
			{
				//alert(getMessage("INVALID_DATE_FMT", "SM"));
				to.select();
				to.focus();
				document.forms[0].b_days.value="0";
				document.forms[0].b_months.value="0";
				document.forms[0].b_age.value="0";

			}
	}
}

function DateCheck(from,to) //DateCheck(currentdateTime,onset_date);
{
	var flg1 = validDateObj(from,"DMYHM","en");
	var flg2 = validDateObj(to,"DMYHM",localeName);

	if( flg1 && flg2 )
	{
		//var greg_fromdate = convertDate(from.value,"DMYHM",localeName,"en");
		var greg_fromdate = from.value;
		var greg_todate = convertDate(to.value,"DMYHM",localeName,"en");

		//if(!isBefore(greg_fromdate,greg_todate,"DMYHM",'en'))
//		if(isAfter(greg_todate,greg_fromdate,'DMYHM','en'))
		if(!isBefore(greg_todate,greg_fromdate,'DMYHM',localeName))// DateUtils.js
		{
			//alert(getMessage("INVALID_ONSET_DATE","SM"));
			var msg = getMessage("VISIT_LESS_DATE","Common");
			msg	=	msg.replace("Visit Date",getLabel("Common.onsetdate.label","Common"));
			msg	=	msg.replace("System Date",getLabel("Common.CurrentDate.label","Common"));
			alert(msg);
			//to.select();
			to.value='';
			to.focus();
			return false;
		}
		else
			return true;
	}
	else
		return false;
}


function validate_date1(onsetDate, statusDate, systemDate) //onset_date,status_date,currentdate
{
		
	//var onSetArray;
	//var statusArray;
	//var systemArray;

	var onsetDate	= onsetDate.value;
	var statusDate	= statusDate.value;
	var systemDate	= systemDate.value;

	

	if(statusDate.length > 0 && statusDate.length > 0 && systemDate.length > 0) 
	{
		var greg_onSetDateTime	=	convertDate(onsetDate,"DMYHM",localeName,"en");
		var greg_statusDate	=	convertDate(statusDate,"DMY",localeName,"en");
		var greg_systemDate	=	convertDate(systemDate,"DMY",localeName,"en");
		//statusArray = statusDate.split("/");
		//systemArray = systemDate.split("/");
		
		//var dt = onsetDate.split(" ");
		var greg_onSetDate = greg_onSetDateTime.split(" ");
		//onSetArray = dt[0].split("/");
		//var onSetdt		= new Date(onSetArray[2],onSetArray[1],onSetArray[0]);
		//var statusdt	= new Date(statusArray[2],statusArray[1],statusArray[0]);
		//var systemdt	= new Date(systemArray[2],systemArray[1],systemArray[0]);
		//if( (Date.parse(statusdt) < Date.parse(onSetdt)) || (Date.parse(statusdt) > Date.parse(systemdt)) )
		
		//if(isBefore(greg_statusDate,greg_onSetDate[0],'DMY','en') || isAfter(greg_statusDate,greg_systemDate,'DMY','en'))
		if(!isAfter(greg_statusDate,greg_onSetDate[0],'DMY','en') || !isBefore(greg_statusDate,greg_systemDate,'DMY','en'))
		{
			alert(getMessage('STAT_DT_BT_ONSET_AND_CURR','MR'));
			document.forms[0].status_date.value = parent.RecDiagnosisAddModify.document.RecDaignosis_form.status_date_temp.value;
			//if(document.forms[0].status_date.readOnly == false)
			//{
				document.forms[0].status_date.value='';
				document.forms[0].status_date.focus();
				//document.forms[0].status_date.select();
				
				return false;
			//}
		}
		else
			return true;
	}
	else
		return false;
}


function clearform()
{
	/* Thursday, August 06, 2009  IN013430 */
		parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.record.disabled=false;
	
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value == "modify")
	{
		var Practitioner_Id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Practitioner_Id.value;
		var relationship_id= parent.RecDiagnosisAddModify.document.RecDaignosis_form.relationship_id.value;
		var Locn_Code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Locn_Code.value;
		var Locn_Type = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Locn_Type.value;
		var Patient_Id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
		var patient_class = parent.RecDiagnosisAddModify.document.RecDaignosis_form.patient_class.value;
		var Encounter_Id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Encounter_Id.value;
		var dob= parent.RecDiagnosisAddModify.document.RecDaignosis_form.dob.value;
		var sex = parent.RecDiagnosisAddModify.document.RecDaignosis_form.sex.value;
		var age = parent.RecDiagnosisAddModify.document.RecDaignosis_form.age.value;
		var modal_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value;
		var practitioner_type	=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.practitioner_type.value;	
		var isCalledFromCA		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value;
		var accession_num		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value;	
		var option_id			=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.option_id.value;	
		var oh_chart_num		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.oh_chart_num.value;
		var function_id		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.function_id.value; //Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
		var isCleared			= "Y";
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='13'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		responseText = responseText.replace(/<[^>]*>/g,'');
		eval(responseText)
		parent.RecDiagnosisAddModify.location.href ="../../eMR/jsp/RecDiagnosisAddModify.jsp?Practitioner_Id="+Practitioner_Id+"&relationship_id="+relationship_id+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&modal_yn="+modal_yn+"&practitioner_type="+practitioner_type+"&isCalledFromCA="+isCalledFromCA+"&accession_num="+accession_num+"&option_id="+option_id+"&oh_chart_num="+oh_chart_num+"&isCleared="+isCleared+"&function_id="+function_id; //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
		//12/2/2008 clear message frame
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		
	}	
	else
	{
		
		//parent.RecDiagnosisAddModify.document.RecDaignosis_form.reset();	
		//11/12/2008 code added for select list
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value="";
		//11/12/2008 end here.
		var Practitioner_Id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Practitioner_Id.value;
		var relationship_id= parent.RecDiagnosisAddModify.document.RecDaignosis_form.relationship_id.value;
		var Locn_Code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Locn_Code.value;
		var Locn_Type = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Locn_Type.value;
		var Patient_Id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
		var patient_class = parent.RecDiagnosisAddModify.document.RecDaignosis_form.patient_class.value;
		var Encounter_Id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Encounter_Id.value;
		var dob= parent.RecDiagnosisAddModify.document.RecDaignosis_form.dob.value;
		var sex = parent.RecDiagnosisAddModify.document.RecDaignosis_form.sex.value;
		var age = parent.RecDiagnosisAddModify.document.RecDaignosis_form.age.value;
		var modal_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value;
		var practitioner_type	=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.practitioner_type.value;	
		var isCalledFromCA		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value;
		var accession_num		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value;	
		var option_id			=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.option_id.value;	
		var oh_chart_num		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.oh_chart_num.value;
		var isCleared			= "Y";

		var episode_type		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.episode_type.value;	
		var visit_adm_date		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.visit_adm_date.value;
		var speciality_code		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.speciality_code.value;	
		var f_authorize_yn		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.f_authorize_yn.value;	
		var called_from_ip		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.called_from_ip.value;
		var occur_srl_no		=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.occur_srl_no_hid.value;	
		var term_set_id			=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;	
		var mode						=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;	
		var call_from				=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.call_from.value;	//Added On 9/23/2009 For MDR.
		var totalRecords				=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.totalRecords.value;	//Added On 9/23/2009 For MDR.
		var function_id				=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.function_id.value;	//function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
		
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='13'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		responseText = responseText.replace(/<[^>]*>/g,'');
		eval(responseText)

		parent.RecDiagnosisAddModify.location.href ="../../eMR/jsp/RecDiagnosisAddModify.jsp?Practitioner_Id="+Practitioner_Id+"&relationship_id="+relationship_id+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&modal_yn="+modal_yn+"&practitioner_type="+practitioner_type+"&isCalledFromCA="+isCalledFromCA+"&accession_num="+accession_num+"&option_id="+option_id+"&oh_chart_num="+oh_chart_num+"&isCleared="+isCleared+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&speciality_code="+speciality_code+"&f_authorize_yn="+f_authorize_yn+"&called_from_ip="+called_from_ip+"&occur_srl_no="+occur_srl_no+"&term_set_id="+term_set_id+"&mode="+mode+"&call_from="+call_from+"&totalRecords="+totalRecords+"&function_id="+function_id; //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
		
		//12/2/2008 clear message frame
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

		parent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value= getLabel('Common.Authorize.label','Common')+''+getLabel('Common.mode.label','Common');
			parent.RecDiagnosisOpernToolbar.document.forms[0].mode.value='Authorize Mode';
		

	}
parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="";
parent.RecDiagnosisAddModify.document.getElementById("evidence_anchor").innerText = "";
}

function ChkNumberInput(fld, e, deci)
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

function leapyear(a) {
	if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
		return true;
	else
		return false;
}

function checkforOK(obj)
{
	if(obj.checked == true)
	{
		
		if(top.frames[2].document.forms[0].OK.disabled == true)
		{
			top.frames[2].document.forms[0].OK.disabled = false;
		}
	}
}


function chkAuthorize(Obj, code_indicator)
    {
			
		//var QueryString= document.getElementById("QueryString").value;
		//var called_from_ip =  parent.addModifyPatProblem.document.forms[0].called_from_ip.value;
		var call_from	=	parent.RecDiagnosisAddModify.document.RecDaignosis_form.call_from.value;	//Added On 9/23/2009 For MDR.

						
		if (Obj.value == 'Authorize Mode')
		{
		
		
			//parent.support.location.href="../../eMR/jsp/AuthorizeRecode.jsp?stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&Context=<%=context%>&Access_Type=E&Context=PatientQueue&Access_Data=SD&Patient_Id=<%=Patient_Id%>&Practitioner_Id=<%=Practitioner_Id%>&jsp_name=DiagRecodePatProblemQueryResult.jsp&Encounter_Id=<%=Encounter_Id%>&Patient_Type=C&Fn_Name=Ass&Clinic_Code=<%=Locn_Code%>&Location_Type=<%=Locn_Type%>&significant_yn=<%=significant_yn%>&patient_class=<%=patient_class%>&called_from_ip=Y&QueryString=" + escape(QueryString) + "&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator + "&associate_codes=" + escape(document.RecDaignosis_form.associate_codes.value);
			parent.blankframe1.location.href="../../eMR/jsp/AuthorizeRecode.jsp?stage_code="+parent.RecDiagnosisAddModify.document.forms[0].diag_stage.value+"&stage_desc=&Access_Type=E&Context=PatientQueue&Access_Data=SD&Patient_Id="+parent.RecDiagnosisAddModify.document.forms[0].Patient_Id.value+"&Practitioner_Id="+parent.RecDiagnosisAddModify.document.forms[0].Practitioner_Id.value+"&jsp_name=RecDiagnosisCurrentDiag.jsp&Encounter_Id="+parent.RecDiagnosisAddModify.document.forms[0].Encounter_Id.value+"&Patient_Type=C&Fn_Name=Ass&Clinic_Code="+parent.RecDiagnosisAddModify.document.forms[0].Locn_Code.value+"&Location_Type="+parent.RecDiagnosisAddModify.document.forms[0].Locn_Type.value+"&significant_yn="+parent.RecDiagnosisAddModify.document.forms[0].significant_yn.value+"&patient_class="+parent.RecDiagnosisAddModify.document.forms[0].patient_class.value+"&called_from_ip=Y&  Sex="+parent.RecDiagnosisAddModify.document.forms[0].sex.value+"&Dob="+parent.RecDiagnosisAddModify.document.forms[0].dob.value+"&code_indicator=" + code_indicator +"&practitioner_type="+parent.RecDiagnosisAddModify.document.forms[0].practitioner_type.value+ "&modal_yn="+parent.RecDiagnosisAddModify.document.forms[0].modal_yn.value+"&associate_codes=" + escape(document.RecDaignosis_form.associate_codes.value);


		}
		else if(Obj.value == 'Normal Mode' && parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=='Y')
		{
			return;
		}
		else if (Obj.value == 'Normal Mode')
		{
		
			//parent.PatProblemQueryResult.location.href="../../eMR/jsp/DiagRecodePatProblemQueryResult.jsp?Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Patient_Id=<%=Patient_Id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&significant_yn=<%=significant_yn%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator;

				parent.RecDiagnosisCurrentDiag.location.href="../../eMR/jsp/RecDiagnosisCurrentDiag.jsp?Encounter_Id="+parent.RecDiagnosisAddModify.document.forms[0].Encounter_Id.value+"&Practitioner_Id="+parent.RecDiagnosisAddModify.document.forms[0].Practitioner_Id.value+"&Locn_Code="+parent.RecDiagnosisAddModify.document.forms[0].Locn_Code.value+"&Patient_Id="+parent.RecDiagnosisAddModify.document.forms[0].Patient_Id.value+"&Locn_Type="+parent.RecDiagnosisAddModify.document.forms[0].Locn_Type.value+"&f_authorize_yn=N&significant_yn="+parent.RecDiagnosisAddModify.document.forms[0].significant_yn.value+"&patient_class="+parent.RecDiagnosisAddModify.document.forms[0].patient_class.value+"&called_from_ip="+parent.RecDiagnosisAddModify.document.forms[0].called_from_ip.value+"&Sex="+parent.RecDiagnosisAddModify.document.forms[0].sex.value+"&Dob="+parent.RecDiagnosisAddModify.document.forms[0].dob.value+"&code_indicator="+code_indicator+"&practitioner_type="+parent.RecDiagnosisAddModify.document.forms[0].practitioner_type.value+"&modal_yn="+parent.RecDiagnosisAddModify.document.forms[0].modal_yn.value;
                     
			//parent.addModifyPatProblem.location.href="../../eMR/jsp/DiagRecodeaddModifyPatProblem.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Patient_Id=<%=Patient_Id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&significant_yn=<%=significant_yn%>&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator;

			parent.RecDiagnosisAddModify.location.href="../../eMR/jsp/RecDiagnosisAddModify.jsp?stage_code="+parent.RecDiagnosisAddModify.document.forms[0].diag_stage.value+"&Encounter_Id="+parent.RecDiagnosisAddModify.document.forms[0].Encounter_Id.value+"&Practitioner_Id="+parent.RecDiagnosisAddModify.document.forms[0].Practitioner_Id.value+"&Locn_Code="+parent.RecDiagnosisAddModify.document.forms[0].Locn_Code.value+"&Patient_Id="+parent.RecDiagnosisAddModify.document.forms[0].Patient_Id.value+"&Locn_Type="+parent.RecDiagnosisAddModify.document.forms[0].Locn_Type.value+"&f_authorize_yn=N&significant_yn="+parent.RecDiagnosisAddModify.document.forms[0].significant_yn.value+"&patient_class="+parent.RecDiagnosisAddModify.document.forms[0].patient_class.value+"&called_from_ip="+parent.RecDiagnosisAddModify.document.forms[0].called_from_ip.value+"&Sex="+parent.RecDiagnosisAddModify.document.forms[0].sex.value+"&Dob="+parent.RecDiagnosisAddModify.document.forms[0].dob.value+"&code_indicator="+code_indicator+"&practitioner_type="+parent.RecDiagnosisAddModify.document.forms[0].practitioner_type.value+"&modal_yn="+parent.RecDiagnosisAddModify.document.forms[0].modal_yn.value+"&isCalledFromCA="+parent.RecDiagnosisAddModify.document.forms[0].isCalledFromCA.value+"&call_from="+call_from;

			parent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value= getLabel('Common.Authorize.label','Common')+''+getLabel('Common.mode.label','Common');
			parent.RecDiagnosisOpernToolbar.document.forms[0].mode.value='Authorize Mode';
        }
    }
//<!--modified on 08-may 2008 to add Anatomical site & Applicable Side-->

function show_diag_link(obj)
{
	var anatomical = obj.options[obj.selectedIndex].text;
	var anatomical_site_val = parent.RecDiagnosisAddModify.document.RecDaignosis_form.anatomical_site.value;
	var option_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.option_id.value;
	var mode =parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;
	var term_set_id =parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;

	if(option_id=='OH_REST_CHART_REC')
	{
		if(anatomical_site_val=="C")
		{
			parent.RecDiagnosisAddModify.document.getElementById("link_diagnosis").innerText = getLabel("eOH.LinkCondition.Label","OH");
			parent.RecDiagnosisAddModify.document.getElementById("app_label").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("applicable_side").style.visibility='hidden'; //Changed By Saanthaakumar 
			parent.RecDiagnosisAddModify.document.getElementById("anatomical_oral_sites").style.visibility='visible'; //Changed By Saanthaakumar 
		}
		else if(anatomical_site_val == "O")
		{
			parent.RecDiagnosisAddModify.document.getElementById("link_diagnosis").innerText = "";
			parent.RecDiagnosisAddModify.document.getElementById("app_label").style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById("applicable_side").style.visibility='visible'; //Changed By Saanthaakumar 
			parent.RecDiagnosisAddModify.document.getElementById("anatomical_oral_sites").style.visibility='visible'; // Changed By Saanthaakumar
		}
		else
		{
			parent.RecDiagnosisAddModify.document.getElementById("link_diagnosis").innerText = "";
			parent.RecDiagnosisAddModify.document.getElementById("app_label").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("applicable_side").style.visibility='hidden'; //Changed By Saanthaakumar 
			parent.RecDiagnosisAddModify.document.getElementById("anatomical_oral_sites").style.visibility='hidden'; //Changed By Saanthaakumar 
			
		}
		
	}
	else
	{
		if(anatomical_site_val=="C")
		{
			parent.RecDiagnosisAddModify.document.getElementById("app_label").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("applicable_side").style.visibility='hidden'; //Changed By Saanthaakumar 
			parent.RecDiagnosisAddModify.document.getElementById("anatomical_oral_sites").style.visibility='visible'; //Changed By Saanthaakumar 
		}
		else if(anatomical_site_val == "O")
		{
			parent.RecDiagnosisAddModify.document.getElementById("app_label").style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById("applicable_side").style.visibility='visible'; //Changed By Saanthaakumar 
			parent.RecDiagnosisAddModify.document.getElementById("anatomical_oral_sites").style.visibility='visible'; //Changed By Saanthaakumar 
		}
		else
		{
			parent.RecDiagnosisAddModify.document.getElementById("app_label").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("applicable_side").style.visibility='hidden'; //Changed By Saanthaakumar 
			parent.RecDiagnosisAddModify.document.getElementById("anatomical_oral_sites").style.visibility='hidden';//Changed By Saanthaakumar 
		}
	}


		setTimeout("pop_anat_dummy()",05);

}



function pop_anat_dummy(){
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'){
		if(parent.frames[5].document.body != null){
			pop_anat();
		}else{
			setTimeout("pop_anat_dummy()",05);
		}
	}else{
		if(parent.frames[6].document.body != null ){
			pop_anat();
		}else{
			setTimeout("pop_anat_dummy()",05);
		}
	}
}

function pop_anat(){
		
		var anatomical_site_val = parent.RecDiagnosisAddModify.document.RecDaignosis_form.anatomical_site.value;
		var mode =parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;
		var term_set_id =parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;

		var	htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='anatomical_site_val' id='anatomical_site_val' value='"+anatomical_site_val+"'/><input type='hidden' name='step' id='step' value='3' /><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'/><input type='hidden' name='mode' id='mode' value='"+mode+"' /></form></body></html>";
	
		/*if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'	)
		{
			parent.frames[5].document.body.insertAdjacentHTML('afterbegin',htmlval);
			parent.frames[5].document.MRvalidate.submit();
		}
		else
		{
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
			parent.frames[6].document.MRvalidate.submit();
		}
		*/

		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'){
					
			if(parent.frames[5].document.body != null)				
				parent.frames[5].document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.frames[5].document.MRvalidate != null)
				parent.frames[5].document.MRvalidate.submit();
			
			
		}else{
			if(parent.frames[6].document.body != null ){
				parent.frames[6].document.write(htmlval);
				parent.frames[6].document.MRvalidate.submit();
			}
		}

}

async function linkdiagnosis()
{
	var retVal;
	//var dialogHeight=20;
	//var dialogWidth=40;
	//var dialogHeight= "20" ;
	//	var dialogWidth = "40" ;
	/*var dialogTop			= "20";
	var dialogHeight		= "25" ;
	var dialogWidth			= "30" ;*/
	var dialogHeight = "20vh" ;
	var dialogWidth  = "50vw" ;
	var dialogTop    = "100";
	var dialogLeft   = "0";
			
	//var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	var title			= getLabel("eOH.LinkCondition.Label","OH");
	var features="dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';

	var mode = parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value		

	if(mode=='modify')
	{
		//retVal=window.showModalDialog("../../eOH/jsp/OHDiagLinkedConditionsFrame.jsp?title="+title+"&accession_num="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value+"&patient_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value+"&oh_chart_num="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.oh_chart_num.value+"&term_set_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value+"&term_code="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value,arguments,features);
		retVal=await window.showModalDialog("../../eOH/jsp/OHDiagLinkConditionsFrame.jsp?title="+title+"&accession_num="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value+"&patient_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value+"&oh_chart_num="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.oh_chart_num.value+"&term_set_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value+"&term_code="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value+"&mode="+mode,arguments,features);
		
	}
	else
	{
		retVal=await window.showModalDialog("../../eOH/jsp/OHDiagLinkConditionsFrame.jsp?title="+title+"&patient_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value+"&accession_num="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value+"&oh_chart_num="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.oh_chart_num.value+"&term_set_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value+"&term_code="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value+"&mode=insert",arguments,features);
	}	
}



async function callOHLinkedDetails(Patient_Id,term_code,term_set_id,Encounter_Id,pat_accession_num,oh_chart_num)
{
	var retVal;
	var dialogHeight = "20vh" ;
	var dialogWidth  = "50vw" ;
	var dialogTop    = "100";
	var dialogLeft   = "0";			
	
	var title			= getLabel("eOH.LinkCondition.Label","OH");
	var features="dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';		
	retVal=await window.showModalDialog("../../eOH/jsp/OHDiagLinkedConditionsFrame.jsp?title="+title+"&accession_num="+pat_accession_num+"&patient_id="+Patient_Id+"&oh_chart_num="+oh_chart_num+"&term_set_id="+term_set_id+"&term_code="+term_code+"&mode=modify",arguments,features);	
}
function CheckForSpecChars_spec(event){
	
    var strCheck = "?<>!#%^&*/\|'";
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}

//<!--added by Himanshu Saxena for ML-MMOH-CRF-1986.1 (UserStory 2) on 25-04-2023 Started-->
function CheckForSpecChars_onlyfive(event){
	var strCheck = "~|?><";
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}

//<!--added by Himanshu Saxena for ML-MMOH-CRF-1986.1 (UserStory 2) on 25-04-2023 Started-->
function checkspecialandalphanumeric(textObj)
{
	
	var ValidChars = /^[^~|?><]*$/;
	var pasteData = window.clipboardData.getData("Text"); 
	pasteData = trimString(pasteData);
	if(ValidChars.test(pasteData))
	{
		textObj.value = pasteData;
	}
	else 
		return false; 
}

function checkMaxLimit(obj)
{
	if ( obj.value.length > 100 )
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","common");
		var diagProbDesc = getLabel("Common.Entered.label","common") + " " + getLabel("Common.DiagnosisDescription.label","common");
		error = error.replace("$",diagProbDesc);
		error = error.replace("#","100")
		alert(error);
		obj.select();
		return false;
	}
	else
		return true;
}


function CheckForSpecChars_freetext(event){
	
    var strCheck = '"+%?@#$~';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}

function gotoNext(Obj)   
{
	if ( Obj == document.getElementById("onset_date"))	{

			if (Obj.value.length > 0)
			{
				//if (CheckForNumber_l(Obj) == true )
				//{
					/*if ( Obj.value > 31 )
					{
						alert(getMessage("DAYS_GREATER_31",'MP'));
						Obj.focus();
						doValidation=false;
					}
					else*/
						sendToServer(3);
				//}
			} else {
				if(Obj.value=="") {
					sendToServer(3);
				} else {
					doValidation=false;			
				}
			}
		} 
		else if ( Obj == document.getElementById("b_days") )	{

			if (Obj.value.length > 0)
			{
				if (CheckForNumber_l(Obj) == true )
				{
					if ( Obj.value > 31 )
					{
						alert(getMessage("DAYS_GREATER_31",'MP'));
						Obj.focus();
						doValidation=false;
					}
					else
						sendToServer(2);
				}
			} else {
				if(Obj.value=="") {
					sendToServer(2);
				} else {
					doValidation=false;			
				}
			}
		} 
		else if ( Obj == document.getElementById("b_months") ) {
			if (Obj.value.length > 0)
			{
				if (CheckForNumber_l(Obj) == true )
				{
					if ( Obj.value > 11 )
					{
						alert(getMessage("MONTH_GREATER_11",'MP'));
						Obj.focus();
					}
					else
						sendToServer(2);
				}
			} else {
				if(Obj.value=="") {
					sendToServer(2);
				} else {
					doValidation=false;			
				}
			}
		} else if ( Obj == document.getElementById("b_age") )	{

			if (Obj.value.length > 0) {
							
				if (CheckForNumber_l(Obj) == true)	{

					if ( Obj.value < 0)	{
						alert(getMessage("AGE_LESS_ZERO",'MP'));
						Obj.focus();
					} else if ( Obj.value == '') {						
						Obj.value = 0;
					} else {
						sendToServer(2);
					}
				}
			} else {
				if(Obj.value=="") {
					sendToServer(2);
				} else {
					doValidation=false;			
				}
			}
		}
}

function sendToServer(Val)  {
	if ( Val == 2 ){
		if(parent.RecDiagnosisAddModify.document.forms[0].b_age.value != '' || parent.RecDiagnosisAddModify.document.forms[0].b_months.value != '' || parent.RecDiagnosisAddModify.document.forms[0].b_days.value != ''){
			var	htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='b_age' id='b_age' value='"+parent.RecDiagnosisAddModify.document.forms[0].b_age.value+"'><input type='hidden' name='b_months' id='b_months' value='"+parent.RecDiagnosisAddModify.document.forms[0].b_months.value+"'><input type='hidden' name='b_days' id='b_days' value='"+parent.RecDiagnosisAddModify.document.forms[0].b_days.value+"'><input type='hidden' name='step' id='step' value='4' ></input></form></body></html>";
			if(parent.messageFrame.document.body != null )
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.messageFrame.document.MRvalidate != null )
			parent.messageFrame.document.MRvalidate.submit();
		}
	}else if ( Val == 3 )	{
	  var mode=parent.RecDiagnosisAddModify.document.forms[0].mode.value;
	  if (mode==""){
			var	htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='onset_date' id='onset_date' value='"+parent.RecDiagnosisAddModify.document.forms[0].onset_date.value+"'><input type='hidden' name='step' id='step' value='5' ></input></form></body></html>";
			if(parent.messageFrame.document.body != null )
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.messageFrame.document.MRvalidate != null )
			parent.messageFrame.document.MRvalidate.submit();
		}
	}
}

function CheckForNumber_l(Objval) {
        val = Objval.value;

    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            Objval.select();
            Objval.focus();
            return false;

        }
}

function validateDatetime(obj,obj2) {
			var from = obj.value;
			//var proceed=true;
			if(!from==""){
				var to   = document.forms[0].currentdate.value;
				var fromarray;
				var toarray;
				var frmdt=from.split(" ");
				document.forms[0].onset_date.value=frmdt[0];
				if(!frmdt[1]==""){
					from=frmdt[0];				
					fromarray  = from.split("/");
					toarray    = to.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(validDateObj(obj,"DMYHM",localeName)){
					if(doDateTimeChk(obj)){
							if(Date.parse(todt) < Date.parse(fromdt)) {
								var invaldt = getMessage("MRDATE1_GT_DATE2",'MR') ;
								var census_date_from=obj2;
								var sys_date=getLabel("Common.SystemDate.label","Common");
								invaldt=invaldt.replace('$',census_date_from);
								invaldt=invaldt.replace('#',sys_date);
								alert(invaldt);
								obj.value='';
								obj.focus();
								//proceed=false;
							}
					}else{        
						alert(getMessage("INVALID_DATE_FMT", "SM"));
						obj.select();
						obj.focus();
						//proceed=false;
					}
				}else{        
						obj.select();
						obj.focus();
						//proceed=false;
					}
				}else{
					alert(getMessage("INVALID_DATE_FMT", "SM"));
					obj.focus();
					//proceed=false;
				}
			}
			/*if(proceed){
				caluculateDOI()
			}*/
		}
function checkFieldsofMandatory( fields, names, messageFrame,val) { 
    var errors = "" ;		
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
			if (val=="Y")
	         {
			   fields[i].style.backgroundColor='#FFFFFF';
			 }
        }
        else  { 
                if(names[i]=="Work Related Form not recorded" || names[i]=="Types of Notification Form not recorded"){
				var notiable=getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1} Cannot be Blank", " ");				
        		errors +=notiable+new Array(encodeURIComponent(names[i]))+"<br>";
				}else {
				errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
				}
		if (val=="Y")
	         {
			   fields[i].style.backgroundColor='#FFFF66';
			 }
		}
    } 
	
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}		

