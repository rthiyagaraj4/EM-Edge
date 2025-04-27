/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
24/11/2016	IN062301		Krishna Gowtham											GHL-SCF-1121
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

var window_obj = null;
function callNotificationForm(obj)
{	
	if(obj.value == "")
	{
		if(window_obj != null)			
			window_obj.close();
	}
	top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.accession_num.value = "";
	var mode = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.mode.value;
	if(parent.patAssessmentPhysicianNotesFrame.document.result_form != null)
	{
		parent.patAssessmentPhysicianNotesFrame.location.href = "../../eCommon/html/blank.html";
	}
	if(parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm != null)
	{
		parent.patAssessmentDiagnosisFrame.location.href = "../../eCommon/html/blank.html";
	}
	if(parent.patAssessmentDependencyFrame.document.patAssessDependencyForm != null)
	{
		parent.patAssessmentDependencyFrame.location.href = "../../eCommon/html/blank.html";
	}	

	if(obj.value == "")
		return false;
	else
		showNotificationForm();
}

function showNotificationForm()
{
	var mode = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.mode.value;
	if(mode == "modify")
	{
		var assess_note_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.note_at_mod.value;
	}
	else
	{
		var assess_note_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.value;
	}
	var patient_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_id.value;
	var patient_class = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_class.value;
	var encounter_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.enc_id.value;
	var accession_num = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.accession_num.value;
	var note_signed = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.note_signed.value;
	var retVal = new String();
	
	//IN062301 Start
	//var dialogTop = "94";
	//var dialogHeight = "445";
	//var dialogWidth = "790";
	
	var dialogTop = "100"
	var dialogHeight = (screen.availHeight)-125;
	var dialogWidth = (screen.availWidth)-10;
	//IN062301 End
	var features = "top="+dialogTop+",height="+dialogHeight+",width="+dialogWidth+",status=no,left=0";
	var arguments = "Window_for_"+patient_id;

	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?title=Assessment Note&note_type="+assess_note_id+"&patient_id="+patient_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&Field_Ref=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.accession_num&function_id=SPCL_NOTE&event_class=PHY$&accession_num="+accession_num+"&window_close=Y&note_signed="+note_signed+"&appl_task_id=CP_ASSESSMENT";

	//alert(action_url);
	window_obj =	window.open(action_url,arguments,features);
	

	if(window_obj != null)
	{
	
			window_obj.focus();
	}
	parent.patAssessmentButtonsFrame.document.patAssessRecordBtnForm.printPreview.disabled=true;
	parent.patAssessmentButtonsFrame.document.patAssessRecordBtnForm.assessRecord.disabled=true;
	parent.patAssessmentButtonsFrame.document.patAssessRecordBtnForm.assessClear.disabled=true;
}


function callPopStatus(obj)
{
//	alert("Here");
	
	var noteObj = obj;
	var noteValue = "";
	if(noteObj.disabled == true)
	{
		noteObj.disabled = false;
		noteValue = noteObj.value;
		noteObj.disabled = true;
	}
	
	var mode = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.mode.value;
	if(mode != "modify")
	{
		if(parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus") != null)
		{
			var stat = parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus").value;
			var stat_flag = parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus_flag").InnerText;
			if(stat_flag != "4")
			{
				if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,75%,8%,40%,7%,0%")
					top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,*,0%,0%,7%,0%";
			}			
			if(stat_flag == "4")
			{
				top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,75%,8%,40%,7%,0%";
			}
		}
		
		
		noteValue = noteObj.value;
		var assess_note_id = noteValue;
		var assess_note_index = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.selectedIndex;
		var assess_note_desc = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.options[assess_note_index].text;		
	}
	else if(mode == "modify")
	{
		var status = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.status_at_mod.value;
		var status_flag = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.status_flag_at_mod.value;
		if(status_flag != "4")
		{
			if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,*,0%,0%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,75%,8%,40%,7%,0%";
		}
		else if(status_flag == "4")
		{
			if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,*,0%,0%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,75%,8%,40%,7%,0%";
		}
		
		var assess_note_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.note_at_mod.value;
		var assess_note_desc = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.note_desc_at_mod.value;
	}

	
	var patient_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_id.value;
	var patient_class = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_class.value;
	var encounter_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.enc_id.value;
	var accession_num = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.accession_num.value;
	var note_signed = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.note_signed.value;
	var mode = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.mode.value;
	var locn_type = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.locn_type.value;
	var locn_code = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.locn_code.value;
	var dob = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.dob.value;
	var age = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.age.value;
	var sex = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.sex.value;
	var reln_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.reln_id.value;
	var assess_ref_no = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assess_ref_no.value;
	//parent.frames[4].document.patAssessRecordBtnForm.printPreview.enabled=false;
	if(obj.value != "")
	{
		if(mode != "modify")
		{
			if(window_obj.closed == true)
			{
			
			populateStatusDependency(patient_id,patient_class,encounter_id,assess_note_id,mode,assess_note_desc,locn_type,locn_code,dob,age,sex,assess_ref_no,reln_id);
			}
		}
		else if(mode == "modify")
		{
			//alert("calling ppulateStatusDependency");
			populateStatusDependency(patient_id,patient_class,encounter_id,assess_note_id,mode,assess_note_desc,locn_type,locn_code,dob,age,sex,assess_ref_no,reln_id);
		}
	}
}


function populateStatusDependency(patId,patClass,EncId,note_type,mode,note_desc,locn_type,locn_code,dob,age,sex,assess_ref_no,reln_id)
{
	var accession_num = document.patAssessmentAddModifyForm.accession_num.value;
	parent.blankFrameStaDep.document.write("<html><body><form name='patAssessIntermediateForm' id='patAssessIntermediateForm' method = 'post' action='../../eCP/jsp/PatientAssessmentStatusDepend.jsp'><input type='hidden' name='patient_id' id='patient_id' value = \""+patId+"\"><input type='hidden' name='patient_class' id='patient_class' value = \""+patClass+"\"><input type='hidden' name='encounter_id' id='encounter_id' value = \""+EncId+"\"><input type='hidden' name='accession_num' id='accession_num' value = \""+accession_num+"\"><input type='hidden' name='mode' id='mode' value = \""+mode+"\"><input type='hidden' name='note_type' id='note_type' value = \""+note_type+"\"><input type='hidden' name='note_desc' id='note_desc' value = \""+note_desc+"\"><input type='hidden' name='locn_type' id='locn_type' value = \""+locn_type+"\"><input type='hidden' name='locn_code' id='locn_code' value = \""+locn_code+"\"><input type='hidden' name='dob' id='dob' value = \""+dob+"\"><input type='hidden' name='age' id='age' value = \""+age+"\"><input type='hidden' name='sex' id='sex' value = \""+sex+"\"><input type='hidden' name='assess_ref_no' id='assess_ref_no' value = \""+assess_ref_no+"\"><input type='hidden' name='reln_id' id='reln_id' value = \""+reln_id+"\"></form></body></html>");
	parent.blankFrameStaDep.document.patAssessIntermediateForm.submit();
}


function poulateStatus(dependency_ss,assess_status,ss_dep_code,ss_dep_desc,facility_id,encounter_id,abnormal_categ,accession_num,mode,note_type,status_flag)
{	
	parent.patAssessmentButtonsFrame.document.patAssessRecordBtnForm.printPreview.disabled=false;
	parent.patAssessmentButtonsFrame.document.patAssessRecordBtnForm.assessRecord.disabled=false;
	parent.patAssessmentButtonsFrame.document.patAssessRecordBtnForm.assessClear.disabled=false;
	var note_type;
	if(status_flag != "4")
	{
		if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,75%,8%,40%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,*,0%,0%,7%,0%";
	}
	else if(status_flag == "4")
	{
		//if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "     17%,*,0%,0%,7%,0%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,75%,8%,40%,7%,0%";
	}
	
	if(parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm != null)
	{
		var accession_num = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.accession_num.value;
	}
	if(mode != "modify")
	{
		if(parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote != null)
		{
			note_type = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.value;
		}
		if(note_type != "" && accession_num != "")
		{
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.disabled = true;
		}
		else if(accession_num == "")
		{
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.disabled = false;
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.value = "";
		}	
	}
	else if(mode == "modify")
	{
		var note_type = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.note_at_mod.value;
	}
	var patient_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_id.value;

	var stat_disp = "";
	if(status_flag == "4")
	{
		stat_disp = "Completed";
	}
	else
	{
		stat_disp = assess_status;
	}

	parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus").innerText = stat_disp;
	parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus_flag").innerText = status_flag;
	if(parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus").innerText != "" && parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus_flag").innerText != "4")
	{
		parent.patAssessmentAddModifyFrame.document.getElementById("btnID").style.display = "inline";
	}
	else if(parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus_flag").innerText == "4" || accession_num == "")
	{
		parent.patAssessmentAddModifyFrame.document.getElementById("btnID").style.display = "none";
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = '../../eCP/jsp/PatientAssessmentDependency.jsp?mode='+mode+"&status="+assess_status+"&accession_num="+accession_num+"&note_type="+note_type+"&status_flag="+status_flag;
		parent.patAssessmentDiagnosisFrame.location.href = "../../eCP/jsp/PatientAssessmentDiagnosis.jsp?mode="+mode+"&status="+assess_status+"&accession_num="+accession_num+"&note_type="+note_type+"&patient_id="+patient_id+"&note_type="+note_type+"&status_flag="+status_flag;
	}
	if(parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus").innerText == "")
	{
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCommon/html/blank.html";
		parent.patAssessmentDiagnosisFrame.location.href = "../../eCommon/html/blank.html";
	}
	//parent.patAssessmentPhysicianNotesFrame.location.href = "../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+accession_num;
	if(note_type != "" && accession_num != "")
	{
		//parent.patAssessmentPhysicianNotesFrame.location.href = "../../eCP/jsp/PatientAssessmentDisplayDetails.jsp?note_type="+note_type+"&accession_num="+accession_num;
		parent.patAssessmentPhysicianNotesFrame.location.href = "../../eCP/jsp/PatientAssessmentScoresFrames.jsp?note_type="+note_type+"&accession_num="+accession_num;
	}
}

function hideAssess()
{
	callPopStatus(parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote);
	//alert(parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus").innerText);
	if(parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus_flag").innerText == "4")
	{
		parent.patAssessmentAddModifyFrame.document.getElementById("btnID").style.display = "none";
		if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,*,0%,0%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,75%,8%,40%,7%,0%";
	}
	else
	{
		parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessbtn.style.display = "inline";
		//alert(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows);
		if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,75%,8%,40%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,*,0%,0%,7%,0%";
		else if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,*,0%,0%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,75%,8%,40%,7%,0%";
	}
	
}


async function callDiagnosisOnClickOfBtn(assess_status,assess_status_flag)
{
	var qry_string = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.qry_string.value;

	var pat_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_id.value;
	var pract_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.practitioner_id.value;
	var dob = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.dob.value;
	var age = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.age.value;
	var sex = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.sex.value;
	var pat_class = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_class.value;
	var enc_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.enc_id.value;
	var reln_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.reln_id.value;
	var locn_code = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.locn_code.value;
	var locn_type = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.locn_type.value;
	var mode = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.mode.value;
	var retVal =    new String();
	var dialogHeight= "94vh" ;
	var dialogWidth = "75vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await top.window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?patient_id="+pat_id+"&Pactitioner_Id="+pract_id+"&relationship_id="+reln_id+"&encounter_id="+enc_id+"&Age="+age+"&Dob="+dob+"&Sex="+sex+"&location_code="+locn_code+"&location_type="+locn_type+"&patient_class="+pat_class+"&modal_yn=Y",arguments,features);

	//retVal = window.showModalDialog("../../eCA/jsp/PatProblemMain.jsp?modal_yn=Y&query_string="+qry_string,arguments,features);

	

	var diagArray = new Array();
	//alert(retVal);

	if(retVal != null && retVal != "")
	{
		retVal = unescape(retVal);
		diagArray = retVal.split("^");
		parent.patAssessmentDiagnosisFrame.location.href = "../../eCP/jsp/PatientAssessmentDiagnosis.jsp?term_set_id="+diagArray[0]+"&term_code="+diagArray[1]+"&mode="+mode+"&status="+assess_status+"&flag=modAuth&flag_int=1&patient_id="+pat_id+"&status_flag="+assess_status_flag;
	}
}


function addNewDiagnosis(term_set_id,term_code)
{
	parent.blankFrameDiagIntermediate.document.write("<html><body><form name='patAssessDiagIntermediateForm' id='patAssessDiagIntermediateForm' method = 'post' action='../../eCP/jsp/PatientAssessmentDiagIntermediate.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value = \""+term_set_id+"\"><input type='hidden' name='term_code' id='term_code' value = \""+term_code+"\"></form></body></html>");
	parent.blankFrameDiagIntermediate.document.patAssessDiagIntermediateForm.submit();
}


function addDiagToTable(term_set_desc,term_code_desc,prev_term_set_desc,count)
{
	var classVal = "";
	if(count%2 == 0)
	{
		classVal = "QRYEVEN";
	}
	else
	{
		classVal = "QRYODD";
	}
	
	if(term_set_desc != prev_term_set_desc)
	{
		var rowVal = parent.patAssessmentDiagnosisFrame.document.getElementById("selTable").insertRow();
		var colVar = rowVal.insertCell();
		colVar.colSpan = '2';
		colVar.className = 'CAGROUPHEADING';
		colVar.insertAdjacentHTML("beforeend",term_set_desc);
	}
	var rowValue2 = "<input type='checkbox' name='chkBox' id='chkBox' checked>";
	var insRow = parent.patAssessmentDiagnosisFrame.document.getElementById("selTable").insertRow();
	var insCol = insRow.insertCell();
	insCol.className = classVal;
	insCol.insertAdjacentHTML("beforeend",term_code_desc);
	insCol = insRow.insertCell();
	insCol.className = classVal;
	insCol.insertAdjacentHTML("beforeend",rowValue2);
}


function loadAddModifyFrame(status,note_desc,note_type,accession_num,assess_time,assess_date,ua_dep_desc,assess_ref_no,pat_id,pat_class,enc_id,location_code,location_type,Sex,Age,Dob,ua_dep_code,ss_dep_code,obj,reln_id,ss_dep_desc,status_flag)
{
	//alert("status="+status_flag+"=status");
	//obj.style.color = "maroon";
	if(status_flag != "4")
	{
		if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,75%,8%,40%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,*,0%,0%,7%,0%";
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href = "../../eCP/jsp/PatientAssessmentAddModify.jsp?mode=modify&note_desc="+note_desc+"&note_type="+note_type+"&status="+status+"&assess_date="+assess_date+"&assess_time="+assess_time+"&acc_num="+accession_num+"&patient_id="+pat_id+"&patient_class="+pat_class+"&encounter_id="+enc_id+"&assess_ref_no="+assess_ref_no+"&location_code="+location_code+"&location_type="+location_type+"&Age="+Age+"&Sex="+Sex+"&Dob="+Dob+"&relationship_id="+reln_id+"&status_flag="+status_flag;
		//top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = "../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+accession_num;
		if(note_type != "" && accession_num != "")
		{
			//top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href =  "../../eCP/jsp/PatientAssessmentDisplayDetails.jsp?note_type="+note_type+"&accession_num="+accession_num;
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = "../../eCP/jsp/PatientAssessmentScoresFrames.jsp?note_type="+note_type+"&accession_num="+accession_num;
		}
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCommon/html/blank.html";
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = "../../eCommon/html/blank.html";
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentButtonsFrame.location.href = "../../eCP/jsp/PatientAssessmentRecordButton.jsp?mode=R&status="+status+"&status_flag="+status_flag;
	}
	else if(status_flag == "4")
	{
		if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,*,0%,0%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,75%,8%,40%,7%,0%";
		
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href = "../../eCP/jsp/PatientAssessmentAddModify.jsp?mode=modify&note_desc="+note_desc+"&note_type="+note_type+"&status="+status+"&assess_date="+assess_date+"&assess_time="+assess_time+"&acc_num="+accession_num+"&patient_id="+pat_id+"&patient_class="+pat_class+"&encounter_id="+enc_id+"&location_code="+location_code+"&location_type="+location_type+"&Age="+Age+"&Sex="+Sex+"&Dob="+Dob+"&assess_ref_no="+assess_ref_no+"&relationship_id="+reln_id+"&status_flag="+status_flag;
		//top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = "../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+accession_num;
		if(note_type != "" && accession_num != "")
		{
			//top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href =  "../../eCP/jsp/PatientAssessmentDisplayDetails.jsp?note_type="+note_type+"&accession_num="+accession_num;
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = "../../eCP/jsp/PatientAssessmentScoresFrames.jsp?note_type="+note_type+"&accession_num="+accession_num;
		}
		if(ua_dep_code != "null")
		{
			//alert(ua_dep_code);	
			
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCP/jsp/PatientAssessmentDependency.jsp?mode=modify&ststus="+status+"&ua_dep_desc="+ua_dep_desc+"&assess_ref_no="+assess_ref_no+"&ua_dep_code="+ua_dep_code+"&ss_dep_code="+ss_dep_code+"&note_type="+note_type+"&ss_dep_desc="+ss_dep_desc+"&status_flag="+status_flag;

			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = "../../eCP/jsp/PatientAssessmentDiagnosis.jsp?mode=modify&status="+status+"&ua_dep_desc="+ua_dep_desc+"&note_type="+note_type+"&assess_ref_no="+assess_ref_no+"&note_type="+note_type+"&ss_dep_desc="+ss_dep_desc+"&status_flag="+status_flag;		
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentButtonsFrame.location.href = "../../eCP/jsp/PatientAssessmentRecordButton.jsp?mode=modify&status="+status+"&status_flag="+status_flag;
		}
		else if(ua_dep_code == "null")
		{
			//alert("ua_dep_code from else"+ua_dep_code);	

			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCP/jsp/PatientAssessmentDependency.jsp?mode=modify&ststus="+status+"&ua_dep_desc="+ua_dep_desc+"&assess_ref_no="+assess_ref_no+"&ua_dep_code="+ua_dep_code+"&ss_dep_code="+ss_dep_code+"&flag=modAuth&note_type="+note_type+"&accession_num="+accession_num+"&status_flag="+status_flag;

			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = "../../eCP/jsp/PatientAssessmentDiagnosis.jsp?mode=modify&status="+status+"&ua_dep_desc="+ua_dep_desc+"&note_type="+note_type+"&assess_ref_no="+assess_ref_no+"&flag=modAuth&note_type="+note_type+"&accession_num="+accession_num+"&status_flag="+status_flag;
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentButtonsFrame.location.href = "../../eCP/jsp/PatientAssessmentRecordButton.jsp?mode=modify&status="+status+"&flag=modAuth&status_flag="+status_flag;
		}		
	}
}

function poulateStatusForModify(DepCode,status,enc_id,acc_num,mode,note_type,patient_id,note_desc,locn_type,locn_code,dob,age,sex,pat_class,assess_ref_no,reln_id,note_type,status_flag)
{
	/*alert("mode from poulateStatusForModify = "+mode);*/
	//alert("status from poulateStatusForModify = "+status);
	if(mode == "modify")
	{
		if(status_flag != "4")
		{
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessbtn.style.display = "inline";
		}
		else if(status_flag == "4")
		{
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href = "../../eCP/jsp/PatientAssessmentAddModify.jsp?acc_num="+acc_num+"&mode="+mode+"&status="+status+"&flag=modAuth&note_desc="+note_desc+"&encounter_id="+enc_id+"&patient_id="+patient_id+"&location_type="+locn_type+"&location_code="+locn_code+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&patient_class="+pat_class+"&assess_ref_no="+assess_ref_no+"&relationship_id="+reln_id+"&status_flag="+status_flag;
			
			//top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = "../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+acc_num;
			if(note_type != "" && accession_num != "")
			{
				//top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href =  "../../eCP/jsp/PatientAssessmentDisplayDetails.jsp?note_type="+note_type+"&accession_num="+accession_num;
				top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = "../../eCP/jsp/PatientAssessmentScoresFrames.jsp?note_type="+note_type+"&accession_num="+accession_num;
			}
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCP/jsp/PatientAssessmentDependency.jsp?mode="+mode+"&status="+status+"&flag=modAuth&patient_id="+patient_id+"&assess_ref_no="+assess_ref_no+"&note_type="+note_type+"&accession_num="+acc_num+"&status_flag="+status_flag;
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = "../../eCP/jsp/PatientAssessmentDiagnosis.jsp?mode=modify&status="+status+"&note_type="+note_type+"&patient_id="+patient_id+"&flag=modAuth&note_type="+note_type+"&accession_num="+acc_num+"&status_flag="+status_flag;
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessbtn.style.display = "none";
		}
	}
}

function hideAssessForModify(status,acc_num,assess_ref_no,note_type,locn_code,locn_type,dob,age,sex,status_flag)
{
	
	callPopStatus(parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.note_at_mod);
	if(status_flag == "4")
	{	
		parent.patAssessmentAddModifyFrame.document.getElementById("btnID").style.display = "none";
	}
	else
	{
		parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessbtn.style.display = "inline";
	}
}


async function showDesc(arg1,arg2,ss_dep_desc)
{
	var retVal =    new String();
	var dialogHeight= "50vh" ;
	var dialogWidth = "40vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status;

	retVal = await top.window.showModalDialog("../../eCP/jsp/PatientAssessmentShowDescMain.jsp?arg1="+arg1+"&arg2="+arg2+"&ss_dep_desc="+ss_dep_desc,arguments,features);
}

function staticTable()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById("tabID").style.position = 'static';
		document.getElementById("tabID").style.posTop  = 0;
	}
	else
	{
		document.getElementById("tabID").style.position = 'relative';
		document.getElementById("tabID").style.posTop  = x-1;
	}
}

function closeDescWindow()
{
	window.close();
}

function clearValues(mode,status,status_flag)
{
	if(mode == "modify" && status_flag != "4")
	{
		if(top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.disabled == true)
		{
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.disabled = false;
			top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.value = "";
		}
	}	
	var qry_string = top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.qry_string.value;
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href = "../../eCP/jsp/PatientAssessmentAddModify.jsp?qry_string="+qry_string+"&note_type=~&assess_ref_no=&mode=&flag_on_mod=1";
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = '../../eCommon/html/blank.html';
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCommon/html/blank.html";
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = '../../eCommon/html/blank.html';
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentButtonsFrame.location.href = '../../eCP/jsp/PatientAssessmentRecordButton.jsp';
	top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}

function closeWindow()
{
	top.content.workAreaFrame.patAssessmentResultFrame.location.href = '../../eCommon/html/blank.html';
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href = '../../eCommon/html/blank.html';
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentButtonsFrame.location.href = '../../eCommon/html/blank.html';
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = '../../eCommon/html/blank.html';
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = '../../eCommon/html/blank.html';
	top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = '../../eCommon/html/blank.html';
}

function reduceFrameSize()
{
	parent.patAssessmentResultFrame.document.getElementById("recordsTable").style.display = "inline";
	parent.patAssessmentResultFrame.document.getElementById("valuesTable").style.display = "none";
	parent.patAssessmentResultFrame.document.getElementById("newAssessTable").style.display = "none";
	if(top.content.workAreaFrame.frID.cols == "23%,*")
		top.content.workAreaFrame.frID.cols = "4%,*";	
}

function increaseFrameSize()
{
	parent.patAssessmentResultFrame.document.getElementById("recordsTable").style.display = "none";
	parent.patAssessmentResultFrame.document.getElementById("valuesTable").style.display = "inline";
	parent.patAssessmentResultFrame.document.getElementById("newAssessTable").style.display = "inline";
	if(top.content.workAreaFrame.frID.cols == "4%,*")
		top.content.workAreaFrame.frID.cols = "23%,*";	
}






function scrollTitle()
{
	var x = document.body.scrollTop;
	var tr = document.getElementById("trcoll");
	var positionTop = 0;
	if(x == 0)
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			if(i != 0)
				positionTop += (tr[i - 1].offsetHeight - 15);
			tr[i].style.posTop = positionTop;
			
		}
	}
	else
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			tr[i].style.posTop = x;
		}
	}
}

function staticTitle()
{
	var x = document.body.scrollTop;
	var tr = document.getElementById("trId");
	var positionTop = 0;

	if(x == 0)
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			if(i != 0)
				positionTop += (tr[i - 1].offsetHeight - 18);
			tr[i].style.posTop = positionTop;			
		}
	}
	else
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			tr[i].style.posTop = x;
		}
	}
}

function fixedHeading()
{
	var x = document.body.scrollTop;
	var tr = document.getElementById("trSt");
	var positionTop = 0;

	if(x == 0)
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			if(i != 0)
				positionTop += (tr[i - 1].offsetHeight - 15);
			tr[i].style.posTop = positionTop;
			
		}
	}
	else
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			tr[i].style.posTop = x;
		}
	}
}

function scrollTable()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById("tableStaticId").style.position = 'static';
		document.getElementById("tableStaticId").style.posTop  = 0;
	}
	else
	{
		document.getElementById("tableStaticId").style.position = 'relative';
		document.getElementById("tableStaticId").style.posTop  = x-1;

	}
}

function onSuccess(error_num,error_value)
{
	if(error_value == "1")
	{
		//top.content.workAreaFrame.location.reload();
		var formObj=top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm;
		/*formObj.assessmentNote.value="";
		alert(formObj.assessmentNote.value);*/
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href="../../eCommon/html/blank.html";
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href="../../eCommon/html/blank.html";
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href="../../eCommon/html/blank.html";
		//top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentButtonsFrame.location.href="../eCommon/html/blank.html";
		top.content.workAreaFrame.patAssessmentResultFrame.location.reload();
		top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href="../../eCP/jsp/PatientAssessmentAddModify.jsp?";
		top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_val=1&err_num='+error_num;
	}
	else if(error_value == "0")
	{
		top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_val=0&err_num='+error_num;
	}
}


function callDiagnosisOnClickOfHyperLink(termSetId,termCode,termdesc)
{
	var qry_string = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.qry_string.value;	
	var term_short_desc=termdesc;
	var pat_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_id.value;
	var pract_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.practitioner_id.value;
	var dob = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.dob.value;
	var age = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.age.value;
	var sex = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.sex.value;
	var pat_class = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_class.value;
	var enc_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.enc_id.value;
	var reln_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.reln_id.value;
	var locn_code = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.locn_code.value;
	var locn_type = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.locn_type.value;	
	var mode = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.mode.value;
	var srl_no = parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.srl_no.value;
	var retVal =    new String();
	var dialogHeight= "50" ;
	var dialogWidth = "70" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	
     // retVal = window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?patient_id="+pat_id+"&Pactitioner_Id="+pract_id+"&relationship_id="+reln_id+"&encounter_id="+enc_id+"&Age="+age+"&Dob="+dob+"&Sex="+sex+"&location_code="+locn_code+"&location_type="+locn_type+"&patient_class="+pat_class+"&modal_yn=Y",arguments,features);	 
      retVal = window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?patient_id="+pat_id+"&Practitioner_Id="+pract_id+"&relationship_id="+reln_id+"&encounter_id="+enc_id+"&Age="+age+"&Dob="+dob+"&Sex="+sex+"&location_code="+locn_code+"&location_type="+locn_type+"&patient_class="+pat_class+"&modal_yn=Y"+"&term_code="+termCode+"&term_set_id="+termSetId+"&term_short_desc="+term_short_desc+"&mode=CarPlanAssesment",arguments,features);

}

function staticTitle()
{
	var x = document.body.scrollTop;
	var tr = document.getElementById("trId");
	var positionTop = 0;

	if(x == 0)
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			if(i != 0)
				positionTop += (tr[i - 1].offsetHeight - 18);
			tr[i].style.posTop = positionTop;
			
		}
	}
	else
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			tr[i].style.posTop = x;
		}
	}
}


function recordValues()
{
	
	//alert("Here  "+top.content.workAreaFrame.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.document.forms[0].name );
	var mode = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.mode.value;
	
	var patient_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_id.value;
	var patient_class = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_class.value;
	var sex = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.sex.value;
	var dob = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.dob.value;
	var reln_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.reln_id.value;
	var age = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.age.value;
	var encn_id = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.enc_id.value;
	var locn_code = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.locn_code.value;
	var locn_type = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.locn_type.value;
	//alert('half');
	//alert("assess_status_flag"+assess_status_flag);
	if(mode != "modify")
	{
		//alert("One");
		var assess_status = parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus").innerText;
		var assess_status_flag = parent.patAssessmentAddModifyFrame.document.getElementById("assessStatus_flag").innerText;
		parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.status.value = assess_status;
		parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.status_flag.value = assess_status_flag;
		//alert("assess_status>>>>"+assess_status+"-------assess_status_flag>>>>"+assess_status_flag);
		if(parent.patAssessmentDependencyFrame.document.patAssessDependencyForm != null)
		{
			var ua_dep_code = parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.assessDepandency.value;
			var ss_dep_code = parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.ss_dep_code.value;
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.abnormal_categ.value = parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.abnormalCateg.value;
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessDependency.value = ua_dep_code;

			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.dependency_ss.value = ss_dep_code;
		}//end of if dependency form not null
		//alert("status flag===>"+assess_status_flag);
		if(assess_status_flag != "4")
		{
			//alert('two');
			var noteObj = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote;
			var assess_note = "";

			if(noteObj.disabled == true)
			{
				noteObj.disabled = false;
				assess_note = noteObj;
				noteObj.disabled = true;
			}
		//}////commented by Priya
			var fields = new Array(noteObj);
			var names = new Array(getLabel("eCP.AssessmentNote.label","CP"));
			//alert(parent.patAssessmentAddModifyFrame.checkFieldsofMst(fields,names,top.content.messageFrame))
			if(parent.patAssessmentAddModifyFrame.checkFieldsofMst(fields,names,top.content.messageFrame))
			{
				//alert('three');
				if(parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm != null)
				{
					//alert('four');
					var cnt = parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_cnt.value;
					//alert('cnt==>'+cnt);
					var tempChkVal = "";
					for(var i=0;i<cnt;i++)
					{
						//alert('five');
						if(eval("parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_yn"+i))
						{
							//alert('six');
							var val = eval("parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_yn"+i);
							if(val.checked == true)
								val.value = 'Y';
							else
								val.value = 'N';
							
							tempChkVal += val.value + "||";
							//alert('val.value'+val.value);
						}//end of if
					}//end of for
					//alert('tempChkVal'+tempChkVal);
				}//end of if diag form not null
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.chk_val_hid.value = tempChkVal;				
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.count.value = cnt;					
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.action = '../../servlet/eCP.PatientAssessmentServlet';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.method = 'post';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.target = 'messageFrame';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.submit();	
				parent.parent.patAssessmentResultFrame.location.href="../../eCP/jsp/PatientAssessmentResult.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&relationship_id="+reln_id+"&Age="+age+"&encounter_id="+encn_id+"&location_code="+locn_code+"&location_type="+locn_type;
				
			}//end of chkFormandatory
		}//end of if status-not-authorized shyam
		else if(assess_status_flag == '4')
		{
			//alert("Inside assess");
			var fields = new Array(parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote);
			var names = new Array(getLabel("eCP.AssessmentNote.label","CP"));
			if(!parent.patAssessmentAddModifyFrame.checkFieldsofMst(fields,names,top.content.messageFrame))
			{
				return;
			}
			var fields = new Array(parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.assessDepandency);
			var names = new Array(getLabel("Common.Dependency.label","Common"));
		//	if( parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.disabled==false)
//	{
			if(parent.patAssessmentAddModifyFrame.checkFieldsofMst(fields,names,top.content.messageFrame))
			{
				if(parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm != null)
				{
					var cnt = parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_cnt.value;
					var tempChkVal = "";
					for(var i=0;i<cnt;i++)
					{
						if(eval("parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_yn"+i))
						{
							var val = eval("parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_yn"+i);
							if(val.checked == true)
								val.value = 'Y';
							else
								val.value = 'N';
								
							tempChkVal += val.value + "||";
						}//end of if
					}//end of for
				}//end of if diag form not null
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.chk_val_hid.value = tempChkVal;		
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.count.value = cnt;
                parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessDependency.value=parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.assessDepandency.value;
                parent.patAssessmentButtonsFrame.document.getElementById("patAssessRecordBtnForm").printPreview.style.display="none";
                
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.action = '../../servlet/eCP.PatientAssessmentServlet';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.method = 'post';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.target = 'messageFrame';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.submit();	
				parent.parent.patAssessmentResultFrame.location.href="../../eCP/jsp/PatientAssessmentResult.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&relationship_id="+reln_id+"&Age="+age+"&encounter_id="+encn_id+"&location_code="+locn_code+"&location_type="+locn_type;
		
			}//end of chkMstFields
		
				
		
		}//end of if status-authorized
		
		//	parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.reset();
			//parent.parent.patAssessmentResultFrame.location.href="../../eCP/jsp/PatientAssessmentResult.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&relationship_id="+reln_id+"&Age="+age+"&encounter_id="+encn_id+"&location_code="+locn_code+"&location_type="+locn_type; //commented by Priya
	
	}//end of mode-insert
	else if(mode == "modify")
	{
		var assess_status = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.status_at_mod.value;
		var assess_status_flag = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.status_flag_at_mod.value;
		//alert(assess_status);
		if(parent.patAssessmentDependencyFrame.document.patAssessDependencyForm != null)
		{
			var ua_dep_code = parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.assessDepandency.value;
			var ss_dep_code = parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.ss_dep_code.value;
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.abnormal_categ.value = parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.abnormalCateg.value;			
			parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessDependency.value = ua_dep_code;				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.dependency_ss.value = ss_dep_code;
		}//end of if diag form not null
		if(assess_status_flag != "4")
		{
			if(parent.patAssessmentDependencyFrame.document.patAssessDependencyForm != null)
			{
			var fields = new Array(parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.assessDepandency);
			var names = new Array(getLabel("Common.Dependency.label","Common"));
				//alert(parent.patAssessmentAddModifyFrame.checkFieldsofMst(fields,names,top.content.messageFrame));
					if(parent.patAssessmentAddModifyFrame.checkFieldsofMst(fields,names,top.content.messageFrame))
					{

					parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.chk_val_hid.value = tempChkVal;
					parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.count.value = cnt;
					parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.action = '../../servlet/eCP.PatientAssessmentServlet';
					parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.method = 'post';
					parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.target = 'messageFrame';
					parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.submit();
					parent.parent.patAssessmentResultFrame.location.href="../../eCP/jsp/PatientAssessmentResult.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&relationship_id="+reln_id+"&Age="+age+"&encounter_id="+encn_id+"&location_code="+locn_code+"&location_type="+locn_type;
					}
			}
		}//end of if status-not-authorizedonSuccess
		else if(assess_status_flag == "4")
		{
			var fields = new Array(parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.assessDepandency);
			var names = new Array(getLabel("Common.Dependency.label","Common"));
			//alert(parent.patAssessmentAddModifyFrame.checkFieldsofMst(fields,names,top.content.messageFrame));
			if(parent.patAssessmentAddModifyFrame.checkFieldsofMst(fields,names,top.content.messageFrame))
			{
				if(parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm != null)
				{
					var cnt = parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_cnt.value;
					var tempChkVal = "";
					for(var i=0;i<cnt;i++)
					{
						if(eval("parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_yn"+i))
						{
							var val = eval("parent.patAssessmentDiagnosisFrame.document.patAssessDiagnosisForm.chk_yn"+i);
							if(val.checked == true)
								val.value = 'Y';
							else
								val.value = 'N';
							
							tempChkVal += val.value + "||";
						}//end of if
					}//end of for
				}//end of if diag form null
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.chk_val_hid.value = tempChkVal;
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.count.value = cnt;
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.action = '../../servlet/eCP.PatientAssessmentServlet';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.method = 'post';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.target = 'messageFrame';
				parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.submit();		
				parent.parent.patAssessmentResultFrame.location.href="../../eCP/jsp/PatientAssessmentResult.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&relationship_id="+reln_id+"&Age="+age+"&encounter_id="+encn_id+"&location_code="+locn_code+"&location_type="+locn_type;
			}//end of chkMst
			
		}//end of if status authorized
	//parent.parent.patAssessmentResultFrame.location.href="../../eCP/jsp/PatientAssessmentResult.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&relationship_id="+reln_id+"&Age="+age+"&encounter_id="+encn_id+"&location_code="+locn_code+"&location_type="+locn_type; //commented by Priya
	}//end of mode-modify*/
	//parent.parent.patAssessmentResultFrame.location.href="../../eCP/jsp/PatientAssessmentResult.jsp?patient_id="+patient_id+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&relationship_id="+reln_id+"&Age="+age+"&encounter_id="+encn_id+"&location_code="+locn_code+"&location_type="+locn_type; //commented by Priya
	//parent.patAssessmentAddModifyFrame.location.href="../../eCP/jsp/PatientAssessmentAddModify.jsp?";
	//parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.reset();
	//parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.disabled=false;


	
}//end of func

function disableRecord(){

parent.patAssessmentButtonsFrame.document.patAssessRecordBtnForm.assessRecord.disabled=true;
}
function callNotificationFormforframeSize()
{
	if(top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows == "10%,*,0%,0%,7%,0%")
			top.content.workAreaFrame.patAssessmentMainFrame.framesID.rows = "10%,*,0%,0%,7%,0%";

	showNotificationForm();
}


function PrintPreview()
{
	var mode=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.mode.value;
	var patient_id=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_id.value;
	var practitioner_id=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.practitioner_id.value;
	var encounter_id=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.enc_id.value;
	var episode_type=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.pat_class.value;
	var assess_ref_no=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assess_ref_no.value;
	var accession_num=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.accession_num.value;
	var ua_dep_code="";
	var note_type="";

	var chk_val_hid=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.chk_val_hid.value;

	if(mode == "modify")
	{
		note_type = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.note_at_mod.value;
		ua_dep_code=parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.ua_dep_code.value;
	}
	else
	{
		note_type = parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessmentNote.value;   	
		if(parent.patAssessmentDependencyFrame.document.patAssessDependencyForm != null)
			ua_dep_code=parent.patAssessmentDependencyFrame.document.patAssessDependencyForm.assessDepandency.value;
		else
			ua_dep_code=parent.patAssessmentAddModifyFrame.document.patAssessmentAddModifyForm.assessDependency.value;
	}
	//alert("mode="+mode+",note_type="+note_type+",ua_dep_code="+ua_dep_code+",accession_num="+accession_num+",assess_ref_no="+assess_ref_no)
	
	if (note_type=="" || note_type==null || accession_num =="")
	{
		return
	}	

	window.open("../../eCP/jsp/PatAssessNotesPrintPreview.jsp?patient_id="+patient_id+"&practitioner_id="+practitioner_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&accession_num="+accession_num+"&note_type="+note_type+"&dep_code="+ua_dep_code+"&assess_ref_no="+assess_ref_no+"&chk_val_hid="+chk_val_hid+"&mode="+mode,'Document','height=570,width=790,top=0,left=0,resizable=yes,scrollbars=yes' );
}


