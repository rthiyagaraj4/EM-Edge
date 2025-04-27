async function evidencedby1(){ 
	var retVal; 
	var dialogHeight="60vh";
	var dialogWidth="70vw";
	var title			= getLabel("eMR.AsEvidencedBy.label","MR");
	var as_evidenced_by = parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.as_evidenced_by.value; 
	var as_evidenced_by_fact ="";
	var as_evidenced_by_defn = "";
	var x = as_evidenced_by.split("||");
	var Patient_Id=parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
	var srl_no =parent.RecDiagnosisAddModify.document.RecDaignosis_form.status_srl_no.value;
	var term_set_id =parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
	var term_code =parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var nature =parent.RecDiagnosisAddModify.document.RecDaignosis_form.nature.value;
	var occur_srl_no_hid =parent.RecDiagnosisAddModify.document.RecDaignosis_form.occur_srl_no_hid.value;
	if(term_code=='')
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel("eMR.DiagnosisProblemCode.label","MR"));
		alert(error);
		return false;
	}
	

	if(x != '')
	{
		as_evidenced_by_fact = x[0];		
		if(x[1] != null)
			as_evidenced_by_defn = x[1];
	}

	as_evidenced_by_fact = escape(as_evidenced_by_fact);
	as_evidenced_by_defn = escape(as_evidenced_by_defn);

	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await top.window.showModalDialog("../../eMR/jsp/RecDiagnosisEvidenceDtlMain.jsp?as_evidenced_by_fact="+as_evidenced_by_fact+"&as_evidenced_by_defn="+as_evidenced_by_defn+"&Patient_Id="+Patient_Id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&occur_srl_no_hid="+occur_srl_no_hid+"&nature="+nature ,arguments, features);
	if( retVal != undefined)	
	{
		if(retVal != '') 
		{
			parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.as_evidenced_by.value = retVal;
		 }
	 }
	 else
	{
	 return false
	 }
}


async function evidencedby()
{
	var retVal;
	var dialogHeight=20vh;
	var dialogWidth=50vw;
	var title			= getLabel("eMR.AsEvidencedBy.label","MR");
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await window.showModalDialog("../../eMR/jsp/RecDiagnosisEvidenceDtlMain.jsp?title="+title	,arguments,features);
	if(retVal != '' )
		document.RecDiagAddModifyForm.as_evidenced_by.value = retVal;
}

function submitform()
{
	document.RecDaignosis_form.submit();
}
/* Cancel function  function works from  MR,CA,OH  MODULE.*/
function cancel_a()
{

	
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == "Y")
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form._restoreChart.value=="OH")
		{
			parent.parent.window.close();
			
			//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    //dialogTag.close();
		}
		else
		{
			/*if(top.name!="")
			{  // if- else added by mujafar for ML-MMOH-CRF-1023		
				if(top.content.workAreaFrame!=null)
				top.content.workAreaFrame.location.href = '../../eCommon/html/blank.html' ;
				if(top.content.messageFrame!=null)
				top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
			*/
				parent.parent.window.close();
				//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
			    //dialogTag.close();
			
		}
		
	}
	else
	{
		try{
  		  	/*const dialogTag = parent.parent.parent.document.getElementById("dialog_tag");    
  		  	dialogTag.close();*/
			top.window.document.querySelectorAll('#dialog_tag')[top.window.document.querySelectorAll('#dialog_tag').length-1].close();
		} catch(e){
			parent.parent.window.close();
		}	
	}
		
}

async function  manifestion()
{
	var retVal;
	var dialogHeight="70vh";
	//var dialogWidth=50;
	var dialogWidth="80vw"; //above line commented and Modified for this CRF ML-MMOH-CRF-0792
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	
	var diag_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var diag_desc = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value;
	var associate_codes = parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes.value;	
	var associate_codes_modify = parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes_modify.value;	

	
	var code_indicator = parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value;	
	var term_set_id=parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
	var Dob=parent.RecDiagnosisAddModify.document.RecDaignosis_form.dob.value;
	var Age=parent.RecDiagnosisAddModify.document.RecDaignosis_form.age.value;
	var Sex=parent.RecDiagnosisAddModify.document.RecDaignosis_form.sex.value;
	var Patient_Id=parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
	//var srl_no =parent.RecDiagnosisAddModify.document.RecDaignosis_form.status_srl_no.value;
	var term_set_id =parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
	var term_code =parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var occur_srl_no_hid =parent.RecDiagnosisAddModify.document.RecDaignosis_form.occur_srl_no_hid.value;

	if(term_code=='')
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel("Common.DiagnosisCode.label","Common"));
		alert(error);
		return false;
	}
	/*
	if(code_indicator == "D")
	{	
		
		retVal=window.showModalDialog('../../eMR/jsp/AddDaggerCodeFrames.jsp?code_indicator=D&diag_code='+diag_code+'&diag_desc='+diag_desc+'&associate_codes='+associate_codes+'&code_set='+term_set_id+'&Dob='+Dob+'&Age='+Age+'&Sex='+Sex+'&Patient_Id='+Patient_Id+'&term_set_id='+term_set_id+'&term_code='+term_code+'&occur_srl_no='+occur_srl_no_hid,arguments,features);
		if(retVal != null)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes.value = retVal;	
	}
	else if(code_indicator == "C")
	{			
		
	
		retVal=window.showModalDialog('../../eMR/jsp/AddAssociateCodeFrames.jsp?code_set='+term_set_id+'&diag_code='+diag_code+'&diag_desc='+diag_desc+'&associate_codes='+associate_codes+'&Dob='+Dob+'&Age='+Age+'&Sex='+Sex+'&code_indicator=E&Patient_Id='+Patient_Id+'&term_set_id='+term_set_id+'&term_code='+term_code+'&occur_srl_no='+occur_srl_no_hid,arguments,features);
		if(retVal != null)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes.value = retVal;	
	}
	*/
	retVal=await top.window.showModalDialog('../../eMR/jsp/AddDaggerCodeFrames.jsp?code_indicator='+code_indicator+'&diag_code='+diag_code+'&diag_desc='+diag_desc+'&associate_codes='+associate_codes+'&code_set='+term_set_id+'&Dob='+Dob+'&Age='+Age+'&Sex='+Sex+'&Patient_Id='+Patient_Id+'&term_set_id='+term_set_id+'&term_code='+term_code+'&occur_srl_no='+occur_srl_no_hid+'&associate_codes_modify='+associate_codes_modify,arguments,features);
		if(retVal != null)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes.value = retVal;	
}


async function callNotifiableNotes(callingfrom)
{  
	var email_yn=document.forms[0].email_yn.value;
	var notifiable_code=document.forms[0].notifiable_code.value; //Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
	
	var deft_note_type=document.forms[0].deft_note_type.value; //Added Senthil 
	var srl_no_control=parent.RecDiagnosisAddModify.document.RecDaignosis_form.srl_no_control.value;
	var code_set=parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
    var diagprob_code=parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
    var Patient_Id=parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
	var facility_id=parent.RecDiagnosisAddModify.document.RecDaignosis_form.facilityId.value;
	var SiteSpecific_NotiForm = parent.RecDiagnosisAddModify.document.RecDaignosis_form.legendChangeAsTypesOfNotiForm.value; //Added by Sangeetha for ML-MMOH-CRF-0547
	var notifiableLegndChgApplYn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiableLegndChgApplYn.value;
		
	var patient_id = document.forms[0].Patient_Id.value;
	var episode_id = document.forms[0].Encounter_Id.value;
	var episode_type = document.forms[0].episode_type.value;
	//var episode_type='I';
	var visit_adm_date = document.forms[0].visit_adm_date.value;
	var patient_class = document.forms[0].patient_class.value;
	var speciality_code = document.forms[0].speciality_code.value;
	var Locn_Code = document.forms[0].Locn_Code.value;
	if(patient_class == "IP" || patient_class=="DC")
			episode_type ="I";
		if(patient_class=="OP" ||patient_class=="EM")
			episode_type ="O";

    var accession_num="";
	var retVal;
	//var dialogHeight= "1010";
	//var dialogWidth	= "700";
	var dialogHeight= "650px";
	var dialogWidth	= "1100px";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	 var action_url;
	 var child_window="";
	 //Maheshwaran K modified for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
	 //Start
	 if(notifiable_code!=''&&callingfrom=="NotifiableNote")
		{
		/*var contr_mod_accession_num=facility_id+"$"+Patient_Id+"$"+episode_id+"$"+code_set+"$"+diagprob_code+"$"+srl_no_control; 
		accession_num=parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form.value;
		action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=NOTIFIABLEFORM&appl_task_id=NOTIFIABLEFORM&title=Notifiable Form&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=parent.RecDiagnosisAddModify.document.forms[0].notifiable_note_form&speciality_code="+speciality_code+"&location_code="+Locn_Code+"&notifiable_code="+notifiable_code+"&notifiable_emailYN="+email_yn+"&p_note_type="+deft_note_type+"&callingfrom="+callingfrom+"&contr_mod_accession_num="+contr_mod_accession_num+"&called_from=MR_DIAG"; // modified senthil		
		//alert('action_url  : '+action_url);
		var title="";
		child_window = window.open(action_url,title,"height=700,width=1010,top=15,status=NO,toolbar=no,menubar=no,location=no,left=0");		
		
		//retVal=window.showModalDialog(action_url,arguments,features);
		 */

		//Added by Sangeetha for ML-MMOH-CRF-0547
		var titleChange = "";
		if(SiteSpecific_NotiForm == "true")
			titleChange = "Types of Notification Form";
		else if(notifiableLegndChgApplYn=="true")
			titleChange = "Notifiable Form";
		else
			titleChange = "Work Related Form";

		var contr_oth_accession_num=facility_id+"$"+Patient_Id+"$"+episode_id+"$"+code_set+"$"+diagprob_code+"$"+srl_no_control; 
		accession_num=parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form.value;
		action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=NOTIFIABLEFORM&appl_task_id=NOTIFIABLEFORM&title="+titleChange+"&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=&speciality_code="+speciality_code+"&location_code="+Locn_Code+"&notifiable_code="+notifiable_code+"&notifiable_emailYN="+email_yn+"&p_note_type="+deft_note_type+"&callingfrom="+callingfrom+"&contr_oth_accession_num="+contr_oth_accession_num+"&called_from=MR_DIAG"; // modified senthil		
	
		var title="";
		//retVal = window.open(action_url,title,"height=700,width=1010,top=15,status=NO,toolbar=no,menubar=no,location=no,left=0");		
		retVal=await window.showModalDialog(action_url,arguments,features);
			if(retVal!="" && retVal!="MakeAsError"){
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form.value=myTrim(retVal);
				diagNoteDisabled();
			}else{
				if(retVal=="MakeAsError"){
					parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form.value="";
					diagNoteEnabled();
				}
			}
		}
	else{
		accession_num=parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value;
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_num_notifiable.value!='')accession_num=parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_num_notifiable.value; //Added Bru-HIMS-CRF-024.2
		action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=NOTIFIABLEFORM&appl_task_id=NOTIFIABLEFORM&title=Notifiable Form&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=parent.RecDiagnosisAddModify.document.forms[0].accession_number&speciality_code="+speciality_code+"&location_code="+Locn_Code+"&callingfrom="+callingfrom+"&called_from=MR_DIAG";
		var title="";
		 child_window = window.open(action_url,title,"height=700,width=1010,top=15,status=NO,toolbar=no,menubar=no,location=no,left=0");
      	//retVal=window.showModalDialog(action_url,arguments,features);
		}
		
		//alert('child_window : '+child_window);
		//End

	
	
	

	
}

 
async function diffGroupforDiag(qrystr)
{
	var retVal;
	var dialogHeight="60vh";
	var dialogWidth="70vw";
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	var mode = parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;

	retVal=await top.window.showModalDialog("../../eMR/jsp/RecDiagnosisDifferentialGroup.jsp?"+qrystr,arguments,features);
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.diff_group_vals.value = retVal;

}

async function diffGroup(digcode,id,term_code,short_desc)
{
	var display_mode ="";
	var patientid=parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
	var term_set_id=digcode;
	var term_code_desc = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value;
	var term_set_code=parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
//	var onset_date=parent.frames[3].document.RecDaignosis_form.onset_date.value;
	var onset_date=convertDate(parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_date.value,'DMYHM',localeName,'en');
	var mode = parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;
	if(mode =="")
		mode = "insert";
	if(id == "update")
	{
		mode = "modify";
		term_set_code = term_code;
		display_mode = "result_page";
	}

	var retVal;
	var dialogHeight="80vh";
	var dialogWidth="80vw";
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal= await window.showModalDialog("../../eMR/jsp/RecDiagnosisDifferentialGroup.jsp?Patient_Id="+patientid+"&term_set_id="+term_set_id+"&term_set_code="+term_set_code+"&diag_Description="+term_code_desc+"&onset_date="+onset_date+"&mode="+mode+"&display_mode="+display_mode+"&term_code_short_desc="+encodeURIComponent(short_desc)+" ",arguments,features);	
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.diff_group_vals.value = retVal;
}


function displayToolTip(term_vals,grp_ids,curr_id,grpid,temp_grpids,mode)
{	
	document.diff_group.termValues.value = term_vals;
	var rec_cnt = document.diff_group.record_count.value;
	var grp_cnt = document.diff_group.group_count.value;
	if(rec_cnt == 1 && grp_cnt == 1){
		alert(getMessage("MR_REC_DIAG_NO_EXIT_GRP",'MR'));
		return false;
	}
	var obj1=document.getElementById('tooltiplayer');
	if(obj1 != null)
	{
		buildTable(grp_ids,curr_id,grpid,temp_grpids,mode)
		//bodwidth  = parent.RecDiagnosisCurrentDiagheader.document.body.offsetWidth
		bodwidth = document.body.offsetWidth;
		//bodheight = parent.RecDiagnosisCurrentDiagheader.document.body.offsetHeight
		bodheight = document.body.offsetHeight;
		var x 	  = event.x
		var y 	  = event.y;
		x 	  = x + (document.getElementById('tooltiplayer').offsetWidth)
		y 	  = y + (document.getElementById('tooltiplayer').offsetHeight)

		if(x<bodwidth)
			x = event.x 
		else
			x = x - (document.getElementById('tooltiplayer').offsetWidth*2)
		if(y<bodheight)
			y = event.y
		else
			y = y - (document.getElementById('tooltiplayer').offsetHeight*2)
		
		y+=document.body.scrollTop
		x+=document.body.scrollLeft
		document.getElementById('tooltiplayer').style.posLeft= x
		document.getElementById('tooltiplayer').style.posTop = y
		document.getElementById('tooltiplayer').style.visibility='visible' 
	}
}

function buildTable(grp_ids,curr_id,grpid,temp_grpids,mode)
{	
	document.diff_group.mode.value = mode;
	document.diff_group.curr_grp_id.value = curr_id;

	var rows = "";
	var addrows = "";
	var trows = "";
	var taddrows = "";
	var cnt =1;
	if((grp_ids!="" | grp_ids!=null) && (grp_ids!="0") )
	{
		rows = "Move to Group ";
		var split_id = grp_ids.split("|");
		var tsplit_id = temp_grpids.split("|");

		for(i=0;i<split_id.length-1;i++)
		{	
			if(split_id[i] != split_id[i-1])
			{
				if(mode == "U")
				{
					if(split_id[i] != curr_id)
					{
						addrows+=rows+split_id[i];
						addrows+=",";
					}
				}
				else
				{
					addrows+=rows+split_id[i];
					addrows+=",";
				}
			}

			if(tsplit_id[i]!=tsplit_id[i-1])
			{
				if(mode == "U")
				{
					if(tsplit_id[i] != grpid)
					{
						taddrows+=rows+tsplit_id[i];
						taddrows+=",";
					}
				}
				else
				{
					taddrows+=rows+tsplit_id[i];
					taddrows+=",";
				}
			}
		}
	}

	var row = addrows+"Add to New Group";

	var trow = taddrows+"Add to New Group";
	var rowval   = row.split(",");
	var trowval   = trow.split(",");
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	for( var i=0; i<rowval.length; i++ )
	{
		var colval1  = rowval[i];
		var colval =escape(colval1);
		var tcolval1  = trowval[i];
		var tcolval =escape(tcolval1);

		tab_dat     += "<tr>";
		tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse'><a href=javascript:callMenu('"+colval+"')> "+tcolval1+"</a></td>";
		tab_dat     += "</tr>";
	}
	tab_dat     += "</table>";
	document.getElementById('t').innerHTML = tab_dat;
}


function hideToolTip()
{
	if(document.getElementById('tooltiplayer') != null)
	{
		document.getElementById('tooltiplayer').style.visibility = 'hidden'
	}
}


function CheckMultiSelect(grp_id)
{
	var all_chk = document.getElementById('termvals');
	for(j=0;j<all_chk.length;j++)
	{
		if(all_chk[j].checked && all_chk[j].id != grp_id)
		{			
			alert(getMessage('SAME_GRP_CHKBOX','MR'));
			return false;
		}
	}
}


function RecordUnassignedGrp(obj,grp_mode)
{
	//parent.RecDiagnosisCurrentDiagheader.document.forms[0].diff_mode.value = "Y";
	var term_set_id  = 	document.new_diff_group.term_set_id.value;
	var term_set_code  = 	document.new_diff_group.term_set_code.value;
	var occur_srl_no  = 	document.new_diff_group.occur_srl_no.value;
	var currentdiffid = "";
	var mode = document.new_diff_group.mode.value;
	var flag = document.new_diff_group.flag.value;
	document.new_diff_group.mode.value =  grp_mode;
	objval = obj.value;

	if(objval == 'Create New Group')
	{
		document.new_diff_group.grp_mode.value = "NewGroup";
		termVals  =term_set_id+"|"+term_set_code+"|"+occur_srl_no+"|"+'0';
		document.new_diff_group.termValues.value = termVals;
	}
	else
	{
		document.new_diff_group.grp_mode.value = "UpdateGroup";
		document.new_diff_group.curr_grp_id.value = objval;
		termVals       =	 term_set_id+"|"+term_set_code+"|"+occur_srl_no+"|"+objval;
		document.new_diff_group.termValues.value = termVals;
	}
	if(mode=="modify")
	{	
		document.new_diff_group.submit();
	}
	else if (mode =="insert" && flag=="Record_found")
	{
		document.new_diff_group.submit();
	}
	else if (mode == "insert")
	{
		returnValue = objval;
		parent.parent.document.getElementById("dialog_tag").close();
	}
}


function callMenu(s)
{
	var counter =0
	if(s=="Add to New Group")
	{		
		document.diff_group.grp_mode.value = "NewGroup";
		for(var index =0 ;index < document.forms[0].termvals.length;index++)	
		{	
			if(document.forms[0].termvals[index].checked == false)
			{	
				counter++;
			}
		}
		if(counter != document.forms[0].termvals.length)
		{	
			document.diff_group.submit();
		}
		else
		{
			alert(getMessage("MR_DIAG_DIFF_GROUP",'MR'));
		}
	}
	else
	{
		counter=0;	
		var index = (s.length-1);
		var val = s.charAt(index);
		document.diff_group.grp_mode.value = "UpdateGroup";
		document.diff_group.curr_grp_id.value = val;
		
		for(var index =0 ;index < document.forms[0].termvals.length;index++)	
		{
			if(document.forms[0].termvals[index].checked == false)
			{
				counter++;
			}
		}

		if(counter != document.forms[0].termvals.length)
		{
			document.diff_group.submit();
		}
		else
		{
			alert(getMessage("MR_DIAG_DIFF_GROUP",'MR'));
		}
	}
}

async function show_window()
{

	var dob = document.RecDaignosis_form.dob.value;
	var age = document.RecDaignosis_form.age.value;
	var sex = document.RecDaignosis_form.sex.value;
	var searchtext = document.RecDaignosis_form.diagprob_code.value;
	var practitioner_id = document.RecDaignosis_form.Practitioner_Id.value;
	var term_set_id = document.RecDaignosis_form.code_set.value;
	var Encounter_Id = document.RecDaignosis_form.Encounter_Id.value;
	var speciality_code = document.RecDaignosis_form.speciality_code.value;
	var diagnosis_by_long_desc_yn = document.RecDaignosis_form.diagnosis_by_long_desc_yn.value;//Maheshwaran K added for HSA-CRF-0234
	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "500px" ;
	var dialogWidth = "950px" ;
	var status = "no";
	var arguments = "";
	//Maheshwaran K added diagnosis_by_long_desc_yn for HSA-CRF-0234
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("TermCodeSearchMainFrame.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);
	//retVal = window.open("TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);
	if(retVal != null){
		//var arr = new Array();	
		//retcode = retVal.split("/");
		retcode=retVal; // 2 lines commented and new line added on 15th jul 2009
		document.RecDaignosis_form.diagprob_code.value = retcode;		
		document.RecDaignosis_form.diagprob_code.onblur();
	}
	/*if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == "Y"){
	getDrugIntrValidation();
	}*/
}

async function getDrugIntrValidation(term_code,term_set_id,diag_classification,old_encounter_id,isCurrentEncounter)
{
		var patient_id		= parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
		var Encounter_Id	= parent.RecDiagnosisAddModify.document.RecDaignosis_form.Encounter_Id.value;
		var diagdesc = parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value;
		var diagcode = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
		var diagset = parent.RecDiagnosisAddModify.document.forms[0].code_set.value;
		if(diagdesc == "") diagdesc = diag_classification;
		if(diagcode == "") diagcode = term_code;
		if(diagset == "") diagset = term_set_id;
		if(term_set_id != null && term_set_id != undefined && term_set_id != ""){
			if(term_set_id == diagset) {
				diagset = diagset;
			}else {
				diagset = term_set_id;
			}
		}
		
		if(diagcode != null && diagcode != undefined && diagcode != ""){
		diagcode = diagcode.toUpperCase();
		}
		if(isCurrentEncounter == "Y") Encounter_Id = old_encounter_id; 
		var retVal;
		var cnt = 0;
		var checkdrug = "";
		//var xmlDoc =new ActiveXObject("Microsoft.XMLDom");
		var xmlDoc = "";
		//var xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH patient_id=\""+patient_id+"\" Encounter_Id=\""+Encounter_Id+"\" diagcode=\""+diagcode+"\" diagset=\""+diagset+"\" action='getRestrictDrugYN' /></root>"
		//xmlDoc.loadXML(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../jsp/MRIntermediate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
			if(responseText!=""){
							var retVal_arr = responseText.split("@#");
							for(var i=0;i<retVal_arr.length-1;i++){
								var code_desc_arr = retVal_arr[i].split("|~|");
								checkdrug 	= trimString(code_desc_arr[1]);
								cnt 	= trimString(code_desc_arr[2]) ;
								diagdesc 	= trimString(code_desc_arr[3]) ;
							}
						}
			if(cnt > 0 && diagcode != '' && (checkdrug == 'true' || checkdrug == true )) {
			var dialogHeight=40vh;
			var dialogWidth=60vw;
			var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
			retVal=await window.showModalDialog("../../eMR/jsp/RecDiagDurgInteraction.jsp?&diagdesc="+diagdesc+"&diagset="+diagset+"&diagcode="+diagcode+"&patient_id="+patient_id+"&Encounter_Id="+Encounter_Id,arguments,features);
			}
}

function getDescription()
{
	var diag_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var diagprob_desc = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value;
	var mode =parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	var function_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.function_id.value;
	var patient_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
		
	if(diag_code!=""){
		htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+document.RecDaignosis_form.code_set.value+"'><input type='hidden' name='term_set_code' id='term_set_code' value='"+diag_code+"'><input type='hidden' name='Age' id='Age' value='"+document.RecDaignosis_form.age.value+"'><input type='hidden' name='Sex' id='Sex' value='"+document.RecDaignosis_form.sex.value+"'><input type='hidden' name='Dob' id='Dob' value='"+document.RecDaignosis_form.dob.value+"'><input type='hidden' name='modal_yn' id='modal_yn' value='"+document.RecDaignosis_form.modal_yn.value +"' ><input type='hidden' name='step' id='step' value='2' ><input type='hidden' name='mode' id='mode' value='"+mode+"'></input><input type='hidden' name='function_id' id='function_id' value='"+function_id+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'></input> </form></body></html>";
		
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y'	)
		{
		parent.blankframe1.document.body.insertAdjacentHTML('afterbegin',htmlval);
		parent.blankframe1.document.MRvalidate.submit();
		}
		else
		{
			top.content.workAreaFrame.RecDiagnosisMain.blankframe1.document.body.insertAdjacentHTML('afterbegin',htmlval);
			top.content.workAreaFrame.RecDiagnosisMain.blankframe1.document.MRvalidate.submit();
		}
	}
	else
	{
		document.RecDaignosis_form.diagprob_desc.value = "";
//now		parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="";
	}
}


function getAccuracy_code()
{
	if(document.forms[0].accuracy!=null)
	{
		
		if(document.forms[0].accuracy.value !='')
		{
			var retVal = 	new String();
			retVal = document.forms[0].accuracy.value;
			var arr = retVal.split("=");
			var arr1=arr[0];
			document.forms[0].accry_code.value=arr[0];
			document.forms[0].accry_code_ind.value=arr[1];
		}
		else
		{
			document.forms[0].accry_code.value='';
			document.forms[0].accry_code_ind.value='';
		}
		show_diff_link(document.forms[0].accuracy)// Added On 3/1/2010 For Emergency.
	}
	
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse!=null)
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value == "C")
		{
			//parent.frames[3].document.RecDaignosis_form.collapse.disabled = true;
			//parent.frames[3].document.RecDaignosis_form.expand.disabled = false;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
		}
		else
		{
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
		}
	}
	enableExternal1();
}


function onSuccess()
{
	

	var diff_mode =top.frames[0].document.forms[0].diff_mode.value;
	//var path = parent.RecDiagnosisCurrentDiagheader.document.forms[0].qryStr.value;
	var path = parent.diff_pop_up.document.forms[0].qryStr.value;
	if(diff_mode =='Y')
		window.close();
	else
	{
		
		top.frames[0].location.href = "../../eMR/jsp/RecDiagnosisDifferentialGroupPopup.jsp?"+path;
		top.frames[1].location.reload();
	}
}


function getCodeSet(param)
{	
//10/19/2009
	if(parent.RecDiagnosisAddModify.document.forms[0].code_set.value != '')
	{
		/*if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode!=null)
		{
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value!='modify')
			{
						diagClassLoad();
//						setTimeout("diagClassLoad()",30);
			}

		}
		*/
		
		
		var sel =parent.RecDiagnosisAddModify.document.forms[0].code_set.selectedIndex; 
		retVal = parent.RecDiagnosisAddModify.document.forms[0].code_set.options[sel].id;
		//retVal  ="Y=Y=Y=Y=Y=Y=Y";
				
		var arr = retVal.split("=");
		
		if(parent.RecDiagnosisAddModify.document.forms[0].priority_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].priority_appl_yn.value=arr[0];
		if(parent.RecDiagnosisAddModify.document.forms[0].nature_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].nature_appl_yn.value=arr[1];
		if(parent.RecDiagnosisAddModify.document.forms[0].severity_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].severity_appl_yn.value=arr[2];
		if(parent.RecDiagnosisAddModify.document.forms[0].onset_type_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].onset_type_appl_yn.value=arr[3];
		if(parent.RecDiagnosisAddModify.document.forms[0].factors_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].factors_appl_yn.value=arr[4];
		if(parent.RecDiagnosisAddModify.document.forms[0].notification_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].notification_appl_yn.value=arr[5];
		if(parent.RecDiagnosisAddModify.document.forms[0].enc_stage_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].enc_stage_appl_yn.value=arr[6];
		//Added for ML-MMOH-CRF-1581 by KAMATCHI S
		if(parent.RecDiagnosisAddModify.document.forms[0].inpatient_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].inpatient_appl_yn.value=arr[7];
		if(parent.RecDiagnosisAddModify.document.forms[0].daycare_appl_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].daycare_appl_yn.value=arr[8];
		 //Below Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
		if(parent.RecDiagnosisAddModify.document.forms[0].diagnosis_class_mand_yn!=null)
			parent.RecDiagnosisAddModify.document.forms[0].diagnosis_class_mand_yn.value=arr[9];
		//Ended by Suji Keerthi for ML-MMOH-CRF-1395 US002
		if(arr[0] == "Y")
		{	
			parent.RecDiagnosisAddModify.document.getElementById('priority_tab_id').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('priority_tab_id1').style.visibility='visible';
		}
		else
		{	
			parent.RecDiagnosisAddModify.document.getElementById('priority_tab_id').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('priority_tab_id1').style.visibility='hidden';
		}
	
		if(arr[1] == "Y")
		{	
			parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id1').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id').style.visibility='visible';
		}
		else
		{	
		
			parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id1').style.visibility='hidden';
		}
		
		if(arr[2] == "Y")
		{	
			parent.RecDiagnosisAddModify.document.getElementById('severity_tab_id').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('severity_tab_id1').style.visibility='visible';
		}
		else
		{	
			parent.RecDiagnosisAddModify.document.getElementById('severity_tab_id').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('severity_tab_id1').style.visibility='hidden';
		}

		if(arr[3] == "Y")
		{
			parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid1').style.visibility='visible';
			
			
		}
		else
		{
			
			parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid1').style.visibility='hidden';
		}

		if(parent.RecDiagnosisAddModify.document.forms[0].isEncounterStage.value=="true" && arr[6] == "Y" ){
		if((arr[7] == "Y" && parent.RecDiagnosisAddModify.document.forms[0].patient_class.value=='IP') || (arr[8] == "Y" && parent.RecDiagnosisAddModify.document.forms[0].patient_class.value=='DC')) 	// Condition Added for ML-MMOH-CRF-1581 by KAMATCHI S	
		{
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id2').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id').innerHTML=  getLabel("eMR.EncounterStage.label","MR");
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_img').style.visibility='visible';
			
		}
		else
		{
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id2').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id').innerHTML='&nbsp;';
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_img').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('diag_stage').value="";
			 
		}
		}
		else if(arr[6] == "Y" && parent.RecDiagnosisAddModify.document.forms[0].patient_class.value=='IP') 
		{
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id2').style.visibility='visible';
			
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id').innerHTML=  getLabel("eMR.EncounterStage.label","MR");
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_img').style.visibility='visible';
			
		}
		else
		{ 
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id2').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id').innerHTML='&nbsp;';
			parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_img').style.visibility='hidden';
			// Condition Added for ML-MMOH-CRF-1581 by KAMATCHI S
			if(!(parent.RecDiagnosisAddModify.document.forms[0].isEncounterStage.value=="true") && parent.RecDiagnosisAddModify.document.forms[0].patient_class.value=='DC')
			{
			//Below added by Suji Keerthi for ML-MMOH-CRF-1605 
			if(parent.RecDiagnosisAddModify.document.forms[0].isPrepDisDefaultDischargeAppl.value=="false" && !parent.RecDiagnosisAddModify.document.forms[0].function_id.value=="PRE_DIS_ADVICE")
			{
			parent.RecDiagnosisAddModify.document.getElementById('diag_stage').value="";
			}
			//Ended by Suji Keerthi for ML-MMOH-CRF-1605
			}
		}

		if((arr[0] != "Y") && (arr[2] != "Y"))
		{	
			parent.RecDiagnosisAddModify.document.getElementById("ser_pri_row").style.display='none';
		}
		else
		{
			parent.RecDiagnosisAddModify.document.getElementById("ser_pri_row").style.display='';
		}

		var codeset_up=parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
		//alert('opop')
		setTimeout("showTable(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set)",50);
//		showTable(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set);

		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode!=null)
		{
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value!='modify')
			{
						setTimeout("diagClassLoad_dummy()",05);
						//setTimeout("diagClassLoad()",30);
			}/*Monday, February 01, 2010 IN018664 , to list diagnosis classification in modify mode*/
			else if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value=='modify')
			{
				setTimeout("diagClassModify_dummy()",05);
			}

		}
		//showTable(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set)
		//loadAnatomical(); 10/14/2009
		// Below Changes Done By Saanthaakumar
		if(parent.RecDiagnosisAddModify.document.getElementById('is_oh_install').value == 'Y')
			{
		var anatomical_site_val = parent.RecDiagnosisAddModify.document.getElementById('anatomical_site').value;
		var option_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.option_id.value;
		if(option_id=='OH_REST_CHART_REC')
		{
			if(anatomical_site_val =='O')
			{
				parent.RecDiagnosisAddModify.document.getElementById('link_diagnosis').innerText = "";
				parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='visible';
				parent.RecDiagnosisAddModify.document.getElementById('applicable_side').style.visibility='visible';
				parent.RecDiagnosisAddModify.document.getElementById('anatomical_oral_sites').style.visibility='visible';  

			}
			else if(anatomical_site_val =='C')
			{
			parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('applicable_side').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('anatomical_oral_sites').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('link_diagnosis').innerText = getLabel("eOH.LinkCondition.Label","OH");
			
			}
			else
			{
			parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('applicable_side').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('anatomical_oral_sites').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('link_diagnosis').innerText = "";
			}
		 }
		 else
			{
			if(anatomical_site_val =='O')
			{
			parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('applicable_side').style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('anatomical_oral_sites').style.visibility='visible';  
			}
			else if(anatomical_site_val =='C')
			{
			parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('applicable_side').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('anatomical_oral_sites').style.visibility='visible';
			}
			else
			{
			parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('applicable_side').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('anatomical_oral_sites').style.visibility='hidden';
			}
			
			}
		}
		/*Above line  Modified for this CRF AAKH-CRF-0012 [IN:037736]*/
		if(parent.RecDiagnosisAddModify.document.forms[0].isDiagClassMand.value=="false"){ //Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
		if(parent.RecDiagnosisAddModify.document.forms[0].diag_class_mand_yn && parent.RecDiagnosisAddModify.document.forms[0].diag_class_mand_yn.value=="Y") {
		
		 parent.RecDiagnosisAddModify.document.getElementById('diag_class_img').style.visibility='visible'; 
		}
		} //Below Added by Suji Keerthi for ML-MMOH-CRF-1395 US002

		if(parent.RecDiagnosisAddModify.document.forms[0].isDiagClassMand.value=="true"){
		if(parent.RecDiagnosisAddModify.document.forms[0].diag_class_mand_yn && parent.RecDiagnosisAddModify.document.forms[0].diag_class_mand_yn.value=="Y" && arr[9] == "Y" )
		{
		 parent.RecDiagnosisAddModify.document.getElementById('diag_class_img').style.visibility='visible'; 
		} else {
		parent.RecDiagnosisAddModify.document.getElementById('diag_class_img').style.visibility='hidden';
		}
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1395 US002
		//Added for Bru-HIMS-CRF-024.2
		//if((parent.RecDiagnosisAddModify.document.forms[0].mode&& parent.RecDiagnosisAddModify.document.forms[0].mode.value=="") &&(parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn && parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn.value=="Y")){
		//if((parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn && parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn.value=="Y")){
		// parent.RecDiagnosisAddModify.document.getElementById("notifi_frm_mand_gif").style.visibility='visible'; 
		//}
	/*	if((parent.RecDiagnosisAddModify.document.forms[0].mode&&parent.RecDiagnosisAddModify.document.forms[0].mode.value=="modify") &&(parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn && parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn.value=="Y")){
		
		 parent.RecDiagnosisAddModify.document.getElementById("notification_setup").disabled=true; 
		}*/
		//End Bru-HIMS-CRF-024.2	 
		if((parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn && parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn.value=="Y")&&(parent.RecDiagnosisAddModify.document.forms[0].diag_enc_level && parent.RecDiagnosisAddModify.document.forms[0].diag_enc_level.value=="N") && (parent.RecDiagnosisAddModify.document.forms[0].notification_setup && parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=''))
		parent.RecDiagnosisAddModify.document.getElementById("notifi_frm_mand_gif").style.visibility='visible'; 
	}
	else
	{
		parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid").style.visibility='hidden';

		parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid1').style.visibility='hidden';
		//parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('priority_tab_id').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('priority_tab_id1').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id1').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('severity_tab_id').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('severity_tab_id1').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id2').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id').innerHTML="&nbsp;";
		parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_img').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('exclamation').style.visibility='hidden';
		if(parent.RecDiagnosisAddModify.document.getElementById('diag_class_img'))
		 parent.RecDiagnosisAddModify.document.getElementById('diag_class_img').style.visibility='hidden'; 
		//Added for Bru-HIMS-CRF-024.2 
		if(parent.RecDiagnosisAddModify.document.getElementById('notifi_frm_mand_gif').style)
		parent.RecDiagnosisAddModify.document.getElementById('notifi_frm_mand_gif').style.visibility='hidden'; 
		//setTimeout("showTable(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set)",300);
		showTable(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set);
		//loadAnatomical();
		//	parent.RecDiagnosisAddModify.document.getElementById("app_label").style.visibility='hidden';
		//	parent.RecDiagnosisAddModify.document.getElementById("applicable_side").style.visibility='hidden';
		//	parent.RecDiagnosisAddModify.document.getElementById("anatomical_oral_sites").style.visibility='hidden'; 
	}
		//10/14/2009
		
			if(parent.RecDiagnosisAddModify.document.getElementById('is_oh_install').value == 'Y')
			{	
				if(param=='y'){  // added for PE
					loadAnatomical();
				}
//				setTimeout("loadAnatomical()",50);Changed For OH loading problem from CA. 


			}


	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode!=null)
	{
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value!='modify')
		{	
			parent.RecDiagnosisAddModify.document.getElementById('differential_anchor').innerText = "";
			//parent.frames[3].document.getElementById('evidence_anchor').innerText = "";
			parent.RecDiagnosisAddModify.document.getElementById('manifest_anchor').innerText="";
			//parent.RecDiagnosisOpernToolbar.document.getElementById('notice_anchor').innerText="";
		}
		
	}
	
	
	
	setRefresh();
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value== "")
	{
		
		parent.RecDiagnosisAddModify.document.getElementById('exclamation').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('ntf_button').style.visibility='hidden';
	}

	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandFlag.value='N';
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.factors_appl_yn!=null)
	{
		var factors_appl_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.factors_appl_yn.value
		if(factors_appl_yn=="Y")
		{		
				parent.RecDiagnosisAddModify.document.getElementById("ser_pri_row").style.display='';
				parent.RecDiagnosisAddModify.document.getElementById("evidence_anchor").innerText = "[ "+getLabel("eMR.AsEvidencedBy.label","MR")+" ]";
		}
		else
		{
				parent.RecDiagnosisAddModify.document.getElementById("evidence_anchor").innerText = "";
		}
	}

	/* Thursday, August 06, 2009  IN013430 */
	if(parent.RecDiagnosisOpernToolbar.document.getElementById('record'))
		{
		parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.record.disabled=false;
		show_diff_link(parent.RecDiagnosisAddModify.document.RecDaignosis_form.accuracy)// Added On 3/1/2010 For Emergency 

		}
	
}
function loadAnatomical()
{
	
	var anatomical_site_val = parent.RecDiagnosisAddModify.document.RecDaignosis_form.anatomical_site.value;
	var option_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.option_id.value;
	var mode =parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;
	var term_set_id =parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;

	if(option_id=='OH_REST_CHART_REC')
	{
		if(anatomical_site_val=="C")
		{
				parent.RecDiagnosisAddModify.document.getElementById('link_diagnosis').innerText = getLabel("eOH.LinkCondition.Label","OH");
				parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
				parent.RecDiagnosisAddModify.document.getElementById('app_select').style.visibility='hidden';
				parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='visible';
				if (term_set_id != "")
				{
					parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='visible';
				}else
				{
					parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='hidden';
				}
		}
		else if(anatomical_site_val == "O")
		{
	
			parent.RecDiagnosisAddModify.document.getElementById('link_diagnosis').innerText = "";
			parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='hidden';//Added By Saanthaakumar
			if (term_set_id != "")
			{
				parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='visible';
				parent.RecDiagnosisAddModify.document.getElementById('app_select').style.visibility='visible';
				//parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='visible'; // Commented By Saanthaakumar
			}else
			{
				parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
				parent.RecDiagnosisAddModify.document.getElementById('app_select').style.visibility='hidden';
				//parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='hidden';  // Commented By Saanthaakumar
			}
			
			//parent.RecDiagnosisAddModify.document.getElementById("oral_sites").style.display='none';
		}
		else
		{
			parent.RecDiagnosisAddModify.document.getElementById('link_diagnosis').innerText = "";
			parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('app_select').style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='hidden';
			//parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.display='none';
		}
	}
	else
	{
		if(anatomical_site_val=="C")
			{
				parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
				parent.RecDiagnosisAddModify.document.getElementById('app_select').style.visibility='hidden';
				if (term_set_id != "")
				{
					parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='visible';
				}else
				{
					parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='hidden';
				}
			}
		else if(anatomical_site_val == "O")
		{
			parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='hidden'; //Added By Saanthaakumar
			if (term_set_id != "")
			{
				parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='visible';
				parent.RecDiagnosisAddModify.document.getElementById('app_select').style.visibility='visible';
				//parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='visible'; //Commented By Saanthaakumar
			}else
			{
				parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
				parent.RecDiagnosisAddModify.document.getElementById('app_select').style.visibility='hidden';
				//parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='hidden'; //Commented By Saanthaakumar
			}
			
		}
		else
		{
				parent.RecDiagnosisAddModify.document.getElementById('app_label').style.visibility='hidden';
				parent.RecDiagnosisAddModify.document.getElementById('app_select').style.visibility='hidden';
				parent.RecDiagnosisAddModify.document.getElementById('oral_sites').style.visibility='hidden';
		}
	}
			
	if(term_set_id !=''){

		var	htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='anatomical_site_val' id='anatomical_site_val' value='"+anatomical_site_val+"'/><input type='hidden' name='step' id='step' value='3' /><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'/><input type='hidden' name='mode' id='mode' value='"+mode+"' /></form></body></html>";
		
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'	)
			{
				if(parent.frames[5].document.body != null )
				parent.frames[5].document.body.insertAdjacentHTML('afterbegin',htmlval);
				if(parent.frames[5].document.MRvalidate != null )
				parent.frames[5].document.MRvalidate.submit();
			}
			else
			{
				if(parent.frames[6].document.body != null )
				parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
				if(parent.frames[6].document.MRvalidate != null )
				parent.frames[6].document.MRvalidate.submit();
			}
	}
}
function setTermCode1()
	{
		if(parent.RecDiagnosisAddModify.document.forms[0].code_set.value != '')
		{
		    if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_button && parent.RecDiagnosisAddModify.document.forms[0].diagprob_button.disabled)parent.RecDiagnosisAddModify.document.forms[0].diagprob_button.disabled=false;	//Added for this CRF Bru-HIMS-CRF-024.2
			parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled=false;
			parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.select();			
			parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();
		    if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value=='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value=='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value==''))parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=true; //Added for this CRF Bru-HIMS-CRF-024.2
		     
		}
		if(parent.RecDiagnosisAddModify.document.forms[0].code_set.value==''){ 
		if(parent.RecDiagnosisAddModify.document.forms[0].notifiable_note_form.value!='')parent.RecDiagnosisAddModify.document.forms[0].notifiable_note_form.value="";
		if(parent.RecDiagnosisAddModify.document.forms[0].notification_setup)
		parent.RecDiagnosisAddModify.document.forms[0].notification_setup.disabled=false; 
		parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value=""; 		   
        if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.readOnly) parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.readOnly=false;
        if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_button.disabled)parent.RecDiagnosisAddModify.document.forms[0].diagprob_button.disabled=false;	
		if(parent.RecDiagnosisAddModify.document.forms[0].accession_number)parent.RecDiagnosisAddModify.document.forms[0].accession_number.value="";  
		}
	}
function enableExternal1()
{
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator!=null)
	{
		var code_indicator = parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value;
		if(code_indicator == "D")
		{
			parent.RecDiagnosisAddModify.document.getElementById('manifest_anchor').innerText = "[ "+getLabel("eMR.Manifestation.label","MR")+"  ]";
		}
		else if(code_indicator == "C")
		{
			parent.RecDiagnosisAddModify.document.getElementById('manifest_anchor').innerText = "[ "+getLabel("eMR.ExternalCause.label","MR")+" ]";
		}
	}
	

	notify();
}

function setRefresh()
{
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode!=null)
	{

		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value != "modify" && parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandFlag.value=='N')
		{
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value !='Y')
			{
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value='';
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';
				
				
			}
			
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.b_days.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.b_months.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.b_age.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_date.value=parent.RecDiagnosisAddModify.document.RecDaignosis_form.dateTime.value;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.status_date.value=parent.RecDiagnosisAddModify.document.RecDaignosis_form.currentdate.value;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value='A';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.remarks.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.severity.value='D';
			//parent.RecDiagnosisAddModify.document.RecDaignosis_form.priority.value='N';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.type.value='N';
			//parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_stage.value='';			
			
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value != "CarPlanAssesment")
			{
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value='';
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';
			//Below line added for this CRF GDOH-CRF-0082
	    	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagnosisPmb&&parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagnosisPmb.value=="true"){
				parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='hidden';						
				parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML="";
		     }
		      //End GDOH-CRF-0082	
				
			}
		}
	}
}

//1/8/2009 for the Defaultterset table implementing
function _getTableDefaultTermSet(obj)
{
	var call_from=document.forms[0].call_from.value;// Added on 9/23/2009 For MDR 

	if(obj!=null && obj!="")
	{										
			
		  // parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('DiagTable').style.visibility = 'visible';
			// parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.AnatomicalSiteTable.style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('AnatomicalSiteTable').style.visibility = 'visible';
			
      if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y'){
				if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' ){
					parent.parent.frames[1].document.getElementById('RecDiagMain').rows="3%,15%,3%,*,4%,0%,7%";
				}
				else{//Added On 9/23/2009 For MDR.
					if(call_from=="MAINTAIN_DEATH_REGISTER"){
						parent.parent.frames[1].document.getElementById('RecDiagMain').rows="7%,0%,0%,0%,*,4%,0%,7%";
					}else{
						parent.parent.frames[1].document.getElementById('RecDiagMain').rows="7%,2%,15%,3%,*,4%,0%,7%";
					}
				}					//
			}else{
				if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById('isCalledFromCA').value=='Y')
					top.content.workAreaFrame.RecDiagnosisMain.document.getElementById('RecDiagMain').rows="7%,15%,3%,*,4%,0%,7%";
				else
					top.content.workAreaFrame.RecDiagnosisMain.document.getElementById('RecDiagMain').rows="7%,7%,15%,3%,*,4%,0%,7%";
			}
		var mode =parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value	
		//var	htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+obj+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'><input type='hidden' name='step' id='step' value='1' ></input></form></body></html>";
	
	//if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'	)
	//	{
		//**********10/19/2009
			/*if(parent.frames[6].document.body != null)
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.frames[6].document.forms[0] != null)
			parent.frames[6].document.forms[0].submit();*/

			//*********10/19/2009
	//	}
	//else
	//	{
		//	parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
			//if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set != null)
		//	parent.frames[6].document.MRvalidate.submit();
	//}

	
	
	}
	else
	{
		
		// parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('DiagTable').style.visibility = 'hidden';
		// parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.AnatomicalSiteTable.style.visibility='hidden';	
		parent.RecDiagnosisAddModify.document.getElementById('AnatomicalSiteTable').style.visibility = 'hidden';
		/*parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.oral_sites.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.app_label.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.app_select.style.visibility='hidden';*/
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' )
			{
				
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="3%,15%,3%,*,4%,7%,7%";
			}
			else
			{
				
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,7%,7%";
			}
		}
		else	
		{
			
			if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y'){
				
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,60%,3%,*,4%,0%,7%";
			}
			else{
				
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,7%,7%";
			}
		}
	}
	

	if(call_from!="MAINTAIN_DEATH_REGISTER"){
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';
	}
	


}

// end 1/8/2009 for the Defaultterset table implementing




function showTable(obj)
{
	
	    
		//Below line commented and add  this issue identified for doing this CRF GDOH-CRF-0082
		//Enter avilable diag code and loaded diag description then try to Enter invalid code and Script Error comming
		//var call_from=document.forms[0].call_from.value;
		var call_from="";
		if(document.forms[0]!=null && document.forms[0].call_from){
		   call_from=document.forms[0].call_from.value;
		}		
		//End GDOH-CRF-0082

	if(obj.value!=null && obj.value!="")
	{	
	
			
				//parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('DiagTable').style.visibility = 'visible';
			//parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.AnatomicalSiteTable.style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('AnatomicalSiteTable').style.visibility = 'visible';
			
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
			{
				if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' ){
					
					//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="3%,15%,3%,*,4%,0%,7%";
						//parent.parent.frames[1].document.getElementById("pline").style.height="3vh";
						parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="2vh";
						parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="15vh";
						parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="3vh";
						parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="64vh";
						
						parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="5vh";

						parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
						parent.parent.frames[1].document.getElementById("messageFrame").style.height="8vh";
				}else{
					if(call_from=="MAINTAIN_DEATH_REGISTER"){
						/*parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,0%,0%,0%,*,4%,0%,7%";*/
						parent.parent.frames[1].document.getElementById("pline").style.height="8vh";
						/*parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="0vh";
						parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="0vh";
						parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="0vh";*/
						parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="56vh";
						
						parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
						parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.marginTop = "126px";

						parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
						parent.parent.frames[1].document.getElementById("messageFrame").style.height="8vh";
						
						
						
						
						
						
				}else{
					//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="9%,3%,13%,4%,*,4%,0%,10%";
					parent.parent.frames[1].document.getElementById("pline").style.height="9vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="3vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="20vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="51vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
					parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
					parent.parent.frames[1].document.getElementById("messageFrame").style.height="6vh";
				}
			}	//
		}
			else
			{
				
				if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y')
					top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,15%,3%,*,4%,0%,7%";
				else
					top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,7%,15%,3%,*,4%,0%,7%";
			}

			
			var modal_yn =parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value
			var mode =parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value
//10/19/2009
		//var	htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+obj.value+"'/><input type='hidden' name='step' id='step' value='1' /><input type='hidden' name='modal_yn' id='modal_yn' value='"+modal_yn+"'/><input type='hidden' name='mode' id='mode' value='"+mode+"' ></input></form></body></html>";
	/*if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'	)
	{
			if(parent.frames[5].document.body != null)
			parent.frames[5].document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.frames[5].document.forms[0] != null)
			parent.frames[5].document.forms[0].submit();
	}
	else
	{
			if(parent.frames[6].document.body != null)
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.frames[6].document.forms[0] != null)
			parent.frames[6].document.forms[0].submit();
	}*/

	
	
	}
	else
	{

		//parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='hidden';	
		parent.RecDiagnosisAddModify.document.getElementById('DiagTable').style.visibility = 'hidden';
		// parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.AnatomicalSiteTable.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('AnatomicalSiteTable').style.visibility = 'hidden';
		/*parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.oral_sites.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.app_label.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.app_select.style.visibility='hidden';*/
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' )
			{
				
				//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="3%,15%,3%,*,4%,7%,7%";
			/*	parent.parent.frames[1].document.getElementById("pline").style.height="0vh";*/
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="3vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="25vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="55vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="3vh";
					parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
					parent.parent.frames[1].document.getElementById("messageFrame").style.height="5vh"; 
			}
			else{
				if(call_from=="MAINTAIN_DEATH_REGISTER"){
					/*	parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,0%,0%,0%,*,4%,0%,7%";*/
					parent.parent.frames[1].document.getElementById("pline").style.height="9vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="0vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="0vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="0vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="65vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="6vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.marginTop = "55px";

					parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
					parent.parent.frames[1].document.getElementById("messageFrame").style.height="8vh";
				}else{	
						 //alert("line 1457");
						//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,0%,7%";
					parent.parent.frames[1].document.getElementById("pline").style.height="9vh";
  					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="3vh";
  					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="20vh";
  					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
  					parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="51vh";
  					parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="3vh";
  					parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
  					parent.parent.frames[1].document.getElementById("messageFrame").style.height="6vh";
				}
			}
		}
		else	
		{
			
			if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y'){
				
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,60%,3%,*,4%,0%,7%";
			}
			else{
				
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,7%,7%";
			}
		}
	}
	

	
if(call_from!="MAINTAIN_DEATH_REGISTER"){
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';
}


	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';



}

function mrValidateForm(){
	parent.blankframe1.location.reload();


		

}
function selectframe(){
	parent.blankframe1.document.MRvalidate.submit();
		
		

}


//9/29/2008end  reloading the function
/*Below funtion modified for this CRF [PMG2012-CRF-0030]*/
//Maheshwaran K added notifiable_code for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
//Suresh M passed the diag_class_code in the callDetails Method
function callDetails(Patient_Id, term_code, term_set_id,term_set_desc, patient_class, onset_date, notifiable_yn, dob, age, sex, occur_srl_no, associate_codes, Encr_id,cause_of_death, Locn_Code,isCurrentEncounter,old_encounter_id,option_id,accession_no,oh_chart_num,diag_classification,status,notifiable_code,diagcode,p_called_from_widget,called_from_ot, diag_catg){ //CHL-CRF- 0008 - IN:001472

	modal_yn=parent.RecDiagnosisCurrentDiag.document.query_result_form.modal_yn.value;	
	called_from_ip=parent.RecDiagnosisCurrentDiag.document.query_result_form.called_from_ip.value
	function_id=parent.RecDiagnosisCurrentDiag.document.query_result_form.function_id.value //Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
	
	
	var locn_type = parent.RecDiagnosisCurrentDiag.document.query_result_form.Locn_Type.value;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH steps='13'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","AdverseEventType.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
    responseText = responseText.replace(/<[^>]*>/g, '');
		eval(responseText)
		/*Below line Modified for this CRF [PMG2012-CRF-0030]*/
		//Suresh M passed the diag_class_code in the callDetails Method
		parent.RecDiagnosisAddModify.document.location.href="../../eMR/jsp/RecDiagnosisAddModify.jsp?Locn_Code="+Locn_Code+"&cause_of_death="+cause_of_death+"&Patient_Id="+Patient_Id+"&called_from_ip="+called_from_ip+"&term_code="+encodeURIComponent(term_code)+"&term_set_id="+term_set_id+"&term_set_desc="+term_set_desc+"&patient_class="+patient_class+"&onset_date="+encodeURIComponent(onset_date)+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&occur_srl_no="+occur_srl_no+"&mode=modify&associate_codes="+associate_codes+"&modal_yn="+modal_yn+"&Encounter_Id="+Encr_id+"&notifiable_yn="+notifiable_yn+"&practitioner_type="+parent.RecDiagnosisCurrentDiag.document.query_result_form.practitioner_type.value+"&Practitioner_Id="+parent.RecDiagnosisCurrentDiag.document.query_result_form.Practitioner_Id.value+"&isCalledFromCA="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value+"&isCurrentEncounter="+isCurrentEncounter+"&old_encounter_id="+old_encounter_id+"&option_id="+option_id+"&accession_num="+accession_no+"&oh_chart_num="+oh_chart_num+"&status="+status+"&Locn_Type="+locn_type+"&diag_classification="+diag_classification+"&diagnosis_category="+diag_catg+"&notifiable_code="+notifiable_code+"&diagcode="+diagcode+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot+"&function_id="+function_id+""; //Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
	//alert("../../eMR/jsp/RecDiagnosisAddModify.jsp?Locn_Code="+Locn_Code+"&cause_of_death="+cause_of_death+"&Patient_Id="+Patient_Id+"&called_from_ip="+called_from_ip+"&term_code="+encodeURIComponent(term_code)+"&term_set_id="+term_set_id+"&term_set_desc="+term_set_desc+"&patient_class="+patient_class+"&onset_date="+encodeURIComponent(onset_date)+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&occur_srl_no="+occur_srl_no+"&mode=modify&associate_codes="+associate_codes+"&modal_yn="+modal_yn+"&Encounter_Id="+Encr_id+"&notifiable_yn="+notifiable_yn+"&practitioner_type="+parent.RecDiagnosisCurrentDiag.document.query_result_form.practitioner_type.value+"&Practitioner_Id="+parent.RecDiagnosisCurrentDiag.document.query_result_form.Practitioner_Id.value+"&isCalledFromCA="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value+"&isCurrentEncounter="+isCurrentEncounter+"&old_encounter_id="+old_encounter_id+"&option_id="+option_id+"&accession_num="+accession_no+"&oh_chart_num="+oh_chart_num+"&status="+status+"&Locn_Type="+locn_type+"&diag_classification="+diag_classification+"&notifiable_code="+notifiable_code+"&diagcode="+diagcode+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot+"")	
		//Maheshwaran K added notifiable_code for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' ){
		
			//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="3%,15%,3%,*,4%,0%,7%";
			parent.parent.frames[1].document.getElementById("pline").style.height="3vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="15vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="3vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="51vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
			parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
			parent.parent.frames[1].document.getElementById("messageFrame").style.height="7vh";
			parent.blankframe1.location.href="../../eCommon/jsp/error.jsp";
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		
		}
		else
		{			
			//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,0%,7%";
			parent.parent.frames[1].document.getElementById("pline").style.height="7vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="2vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="20vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="51vh";
			parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
			parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
			parent.parent.frames[1].document.getElementById("messageFrame").style.height="7vh";
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

	/* Thursday, August 06, 2009  IN013430 */
		parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.record.disabled=false;
}

async function ShowSupportingDiag(term_code,occur_srl_no,Patient_Id,term_set_id,title)
{
	var dialogHeight= "70vh" ;
    var dialogWidth = "50vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await top.window.showModalDialog("../../eMR/jsp/ShowExternaltTermCodeFrames.jsp?term_code="+term_code+"&title="+encodeURIComponent(title)+"&occur_srl_no="+occur_srl_no+"&Patient_Id="+Patient_Id+"&term_set_id="+term_set_id,arguments,features);
}
//<!--Function added by Himanshu Saxena for ML-MMOH-CRF-1986.1 on 16-03-2023 Started-->
async function showDiagnosisRemark(Patient_Id,term_code,term_set_id,term_set_desc,occur_srl_no)
{	
	var dialogHeight= "50vh" ;
    var dialogWidth = "60vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no"; 
	var title="Remark";
	var arg = "";

	await top.window.showModalDialog("../../eMR/jsp/ShowDiagnosisRemark.jsp?Patient_Id="+Patient_Id+"&term_code="+term_code+"&term_set_id="+term_set_id+"&term_set_desc="+term_set_desc+"&occur_srl_no="+occur_srl_no+"&title="+encodeURIComponent(title),arg, features );
}
function expandColapseframe(id)
{

	//if(parent.frames[3].document.getElementById("mode").value=="modify" && id == "E")
	if(id == "E" && document.forms[0].code_set.value != '')
	{
			// parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('DiagTable').style.visibility = 'visible';
			
			// parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.AnatomicalSiteTable.style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById('AnatomicalSiteTable').style.visibility = 'visible';
			if(parent.RecDiagnosisAddModify.document.getElementById("mode").value=="modify")
			{
				//parent.frames[3].document.getElementById("exclamation").style.visibility='visible';
			}
			else
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandFlag.value='Y';

			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value!= "")
			{
				parent.RecDiagnosisAddModify.document.getElementById("exclamation").style.visibility='visible';
				//parent.RecDiagnosisAddModify.document.getElementById("view_link").style.visibility='visible';
			}

			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=='Y')
				parent.RecDiagnosisAddModify.document.getElementById("ntf_button").style.visibility='visible';
			
			getCodeSet();
	}
	else 
	{
		//parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('DiagTable').style.visibility = 'hidden';

		//parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.AnatomicalSiteTable.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('AnatomicalSiteTable').style.visibility = 'hidden';
	  /*parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.oral_sites.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.app_label.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.app_select.style.visibility='hidden';*/
		parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid1').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('priority_tab_id').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('priority_tab_id1').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('nature_tab_id1').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('severity_tab_id1').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('severity_tab_id').style.visibility="hidden";
		//parent.RecDiagnosisAddModify.document.getElementById('onset_type_tabid2').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('exclamation').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id2').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_id').innerHTML="&nbsp;";
		parent.RecDiagnosisAddModify.document.getElementById('enc_stage_tab_img').style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById('ntf_button').style.visibility='hidden';
	

		
	}

	if(id == "E")
	{
		
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' ){
				
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="3%,15%,3%,*,4%,0%,7%";}
			else{
        // alert("line 1644")
				// parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,0%,7%";
          parent.parent.frames[1].document.getElementById("pline").style.height="7vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="2vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="20vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="65vh";
					parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
					parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
					parent.parent.frames[1].document.getElementById("messageFrame").style.height="7vh";
				
        }
		}
		else
		{
			if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y')
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,15%,3%,*,4%,0%,7%";
			else{
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,0%,7%";
			}
		}
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';
		/* Thursday, August 06, 2009  IN013430 */
		parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.record.disabled=false;
		
	}
	else if(id =="C")
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' )
			{
				//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="3%,60%,3%,*,4%,0%,7%";
				parent.parent.frames[1].document.getElementById("pline").style.height="3vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="65vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="4vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="15vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
				parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
				parent.parent.frames[1].document.getElementById("messageFrame").style.height="7vh";
			}
			else
			{				
				//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,2%,60%,3%,*,4%,0%,7%";
				parent.parent.frames[1].document.getElementById("pline").style.height="7vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="2vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="65vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="15vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
				parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
				parent.parent.frames[1].document.getElementById("messageFrame").style.height="7vh";
				
			}
		}
		else	
		{
			if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y')
			{
				//top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,60%,3%,*,4%,0%,7%";
				parent.parent.frames[1].document.getElementById("pline").style.height="3vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="65vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="4vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="15vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
				parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
				parent.parent.frames[1].document.getElementById("messageFrame").style.height="7vh";
			}
			else
			{
				//top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,2%,60%,3%,*,4%,0%,7%";
				parent.parent.frames[1].document.getElementById("pline").style.height="7vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagheader").style.height="2vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiag").style.height="65vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="4vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisAddModify").style.height="15vh";
				parent.parent.frames[1].document.getElementById("RecDiagnosisOpernToolbar").style.height="4vh";
				parent.parent.frames[1].document.getElementById("blankframe1").style.height="0vh";
				parent.parent.frames[1].document.getElementById("messageFrame").style.height="7vh";
			}
		}
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = true;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = false;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';
		/* Thursday, August 06, 2009  IN013430 */
		parent.RecDiagnosisOpernToolbar.document.RecDiagAddModifyForm.record.disabled=true;
	}
}

function show_diff_link(obj)
{
	var accuracy = obj.options[obj.selectedIndex].text;	
	
	var diag_code = parent.RecDiagnosisAddModify.document.getElementById('diagprob_code').value;
	var accry_code_ind = parent.RecDiagnosisAddModify.document.RecDaignosis_form.accry_code_ind.value;
	if(accry_code_ind=="U"){
		parent.RecDiagnosisAddModify.document.getElementById("differential_anchor").innerText = "[ "+getLabel("eMR.DifferentialGroup.label","MR")+" ]";
	}
	else
		parent.RecDiagnosisAddModify.document.getElementById("differential_anchor").innerText = "";
}

async function showLongDescription()
{
	var dialogHeight= "490px" ;
    var dialogWidth = "350px" ;
	var diagCode = document.forms[0].diagprob_code.value;
	var termSet = document.forms[0].code_set.value;
	var a = document.forms[0].LongDescription.value;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	await window.showModalDialog("../../eMR/jsp/RecDaignosisLongDescDialog.jsp?diagCode="+diagCode+"&termSet="+termSet,"",features);
}

function setStatus()
{
	var obj =parent.RecDiagnosisAddModify.document.RecDaignosis_form.status;
	var length  = obj.length;
	for(i=0;i<length;i++) 
	{
		obj.remove(1);
	}
	var opt= parent.RecDiagnosisAddModify.document.createElement('Option');
	opt.text=getLabel("Common.InError.label","Common"); 
	opt.value='E'; obj.add(opt);
	parent.RecDiagnosisAddModify.document.createElement('Option');
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.accry_code_ind.value=='C')
	{
		var opt= parent.RecDiagnosisAddModify.document.createElement('Option');
		opt.text=getLabel("Common.Resolved.label","Common"); 
		opt.value='R'; obj.add(opt);
		parent.RecDiagnosisAddModify.document.createElement('Option');
	}
}

function check_enc()
{
	if(parent.RecDiagnosisAddModify.document.getElementById('inc_encounter')!=null)
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.inc_encounter.checked==true)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.curr_encr_flag.value='Y';
		else
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.curr_encr_flag.value='N';
	}
}

function onload_display()
{
	//evidence by code
	var diag_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var diag_desc = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value;
	var factors_appl_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.factors_appl_yn.value;
	//var nature = parent.frames[3].document.RecDaignosis_form.nature.value;
	if(diag_code!="" && diag_desc!="" && factors_appl_yn =="Y" )
	{
			parent.RecDiagnosisAddModify.document.getElementById("ser_pri_row").style.display='';
			parent.RecDiagnosisAddModify.document.getElementById("evidence_anchor").innerText = "[ "+getLabel("eMR.AsEvidencedBy.label","MR")+" ]";
	}
	else
	{
			parent.RecDiagnosisAddModify.document.getElementById("evidence_anchor").innerText = "";
	}

	// Differential group 2/26/2007
	var accuracy = parent.RecDiagnosisAddModify.document.RecDaignosis_form.accuracy.value;
	var acc_splt = accuracy.split("=");
	if(diag_code!="" && acc_splt[1]=="U"){
			parent.RecDiagnosisAddModify.document.getElementById("differential_anchor").innerText = "[ "+getLabel("eMR.DifferentialGroup.label","MR")+" ]";
	}
	else{
		parent.RecDiagnosisAddModify.document.getElementById("differential_anchor").innerText = "";
	}

	
}

function notify()
{
	var diag_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value
	var diag_desc = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value
		


		if(parent.RecDiagnosisAddModify.document.forms[0].notification_appl_yn!=null || parent.RecDiagnosisAddModify.document.forms[0].notifiable_yn!=null)
	{
		notification_appl_yn = parent.RecDiagnosisAddModify.document.forms[0].notification_appl_yn.value;
		notifiable_yn = parent.RecDiagnosisAddModify.document.forms[0].notifiable_yn.value;
		if((notification_appl_yn =='N' || notification_appl_yn =='') || (notifiable_yn =='N' || notifiable_yn =='') )
		{

		}
		else if(notification_appl_yn =='Y' && (notifiable_yn =='Y' || notifiable_yn =='') )
		{

		}
	}

}




function checkMaxLimitOfRemark(obj)
{
	if ( obj.value.length > 2000 )
	{
		alert(getMessage("REMARKS_XCEED_2000_CHARS","MR"));
		obj.select();
		return false;
	}
	else
		return true;
	
}
async function viewLink()
{

	var diag_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value
		if(diag_code == '')
		{
		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace("$", getLabel("Common.diagnosis.label","Common")); 
		alert(error);
	}else{
	var retVal = 	new String();
	var dialogHeight="50vh";
	var dialogWidth="60vw";
	var arguments = "";

	var title			= getLabel("Common.view.label","Common")+" "+(getLabel("Common.Link.label","Common"));
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await top.window.showModalDialog("../../eMR/jsp/ViewLinkDiagnosis.jsp?title="+title+"&patient_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value+"&term_set_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value+"&term_code="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value+"&term_desc="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value	,arguments,features);
	}
	
}
function checkDiagProbCode()
{
	if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value =="")
	{
		parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled=false;
		parent.RecDiagnosisAddModify.document.forms[0].diagprob_button.disabled=false;
		parent.RecDiagnosisAddModify.document.forms[0].ComplaintSrch.disabled=true;
		if((parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn.value=="Y")&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&!parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled)&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value==''))
	{     
	    parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=true;
	}
	}else
	{
		parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled=true;
		parent.RecDiagnosisAddModify.document.forms[0].diagprob_button.disabled=true;
		parent.RecDiagnosisAddModify.document.forms[0].ComplaintSrch.disabled=false;   //alert(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled);
	if((parent.RecDiagnosisAddModify.document.forms[0].notifiable_form_mand_yn.value=="Y")&&(parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled)&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=''))
	{   
	    parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;
	}
	}
}
function checkDiagProbDesc()
{  
    //Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123
	var termset_id = parent.RecDiagnosisAddModify.document.forms[0].code_set.value;

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH termset_id=\""+termset_id+"\" action='getFreeTextApplYN' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var free_text_applicable_yn	= trimString(responseText);
	//End ML-MMOH-SCF-2123

	parent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility='hidden';
	if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value !="")
	{ 
		parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=true;
		parent.RecDiagnosisAddModify.document.forms[0].ComplaintSrch.disabled=false;
	}else
	{    
	    //Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123
		if(free_text_applicable_yn == 'Y'){
			parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=false;
		}else{
			parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=true;
		} 
		//End ML-MMOH-SCF-2123

		//parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=false;
		parent.RecDiagnosisAddModify.document.forms[0].ComplaintSrch.disabled=true;
	}
}
/*
function enable_DiagDesc(obj)
{
		var modal_yn =parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value

		var	htmlval = "<html><body onKeyDown='lockKey()'><form name='free_text' id='free_text' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+obj.value+"'><input type='hidden' name='step' id='step' value='3' ></form></body></html>";
	

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'	)
	{
			parent.blankframe1.document.body.insertAdjacentHTML('afterbegin',htmlval);
			
			parent.blankframe1.document.free_text.submit();
	}
	else
	{
			parent.blankframe1.document.body.insertAdjacentHTML('afterbegin',htmlval);
			
			parent.blankframe1.document.free_text.submit();
	}
}
*/
async function selectProblem()
{
	var retVal ;
	var newArray ;
	var newArrayCode	= new Array();
	var newArrayDesc	= new Array();
	var callFunction	= "";

	var patient_id		= parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
	var Encounter_Id	= parent.RecDiagnosisAddModify.document.RecDaignosis_form.Encounter_Id.value;
	var speciality_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.speciality_code.value;
	var code_set		= parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
	var diagprob_desc	= parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value;
	var diagprob_code	= parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var mode			= parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;
	var onset_date		= parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_date.value;
	/*Wednesday, February 10, 2010 , OCCUR_SRL_NO added for SRR20056-SCF-4238 IN019107*/
	var occur_srl_no	= parent.RecDiagnosisAddModify.document.RecDaignosis_form.occur_srl_no_hid.value;

	if(mode == "modify")
		callFunction	= "modifyProblem";
	else
		callFunction	= "selectProblem";

	var dialogHeight	= "500px";
	var dialogWidth		= "700px";
	var title			= getLabel("eMR.Select.label","MR")+" "+(getLabel("Common.Problem.label","Common"));
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	/*Wednesday, February 10, 2010 , OCCUR_SRL_NO added for SRR20056-SCF-4238 IN019107*/
	retVal= await window.showModalDialog("../../eMR/jsp/selectProblemFrames.jsp?callFunction="+callFunction+"&title="+title+"&patient_id="+patient_id+"&encounter_id="+Encounter_Id+"&speciality_code="+speciality_code+"&term_set_id="+code_set+"&term_code="+diagprob_code+"&mode="+mode+"&occur_srl_no="+occur_srl_no+"&onset_date="+encodeURIComponent(onset_date)+"&short_desc="+encodeURIComponent(diagprob_desc)+" "	,arguments,features);
	
	if(retVal != null && retVal != undefined )
	{
		newArray	 = retVal.split("^");
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.complaint_desc.value = "" ;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.complaint_id.value	 = "" ;
		for(var i = 0 ; i <= newArray.length-1 ; i++) 
		{
			newArrayCode = newArray[i].split("$");
			//if(newArrayCode[i] != undefined && newArrayCode[i] != null && newArrayCode[i] != "" )

			if(newArray[i] != undefined && newArray[i] != null && newArray[i] != "" )
			{
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.complaint_desc.value += newArrayCode[1]+";"; 
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.complaint_id.value	 += newArrayCode[0]+"$"; 
			}
		}
		
	}
}

function selectComplaint()
{
	var max_record		= parent.frames[0].document.forms[0].max_record.value;
	var max_count		= parent.frames[0].document.forms[0].max_count.value;
	var callFunction	= parent.frames[0].document.forms[0].callFunction.value;
	var link_Complaint  = "";
	var complaint_ID	= "";
	var Complaint_desc  = "";
	var returnLink      = "";
	if(callFunction == 'selectProblem')
	{
		for(var i=0;i<=max_record-1 ;i++)
		{
			
			if(eval("parent.selectProblemFrame.document.forms[0].select"+i).checked == true)
			{
				link_Complaint += eval("parent.selectProblemFrame.document.forms[0].complaint_id"+i).value+"$"+eval("parent.selectProblemFrame.document.forms[0].complaint_desc"+i).value+"^" ;
				
				complaint_ID +=eval("parent.selectProblemFrame.document.forms[0].complaint_id"+i).value+"$";
						
			}
			
		}
	}
	else if(callFunction == 'modifyProblem')
	{
						
		for(var i=0;i<=max_record-1 ;i++)
		{
			if(eval("parent.selectProblemFrame.document.forms[0].select"+i).disabled == false)
			{
				if(eval("parent.selectProblemFrame.document.forms[0].select"+i).checked == true)
				{
					link_Complaint += eval("parent.selectProblemFrame.document.forms[0].complaint_id"+i).value+"$"+eval("parent.selectProblemFrame.document.forms[0].complaint_desc"+i).value+"^" ;
					
					complaint_ID +=eval("parent.selectProblemFrame.document.forms[0].complaint_id"+i).value+"$";	
				}
			}
		}
		for (var j = 0; j <= max_count -1 ; j ++ )
		{
			if(eval("parent.selectProblemFrame.document.forms[0]._select"+j).checked == true)
			{
				link_Complaint += eval("parent.selectProblemFrame.document.forms[0]._complaint_id"+j).value+"$"+eval("parent.selectProblemFrame.document.forms[0]._complaint_desc"+j).value+"^" ;

				complaint_ID +=eval("parent.selectProblemFrame.document.forms[0]._complaint_id"+j).value+"$";
										
			}
		}
		
	}

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH details = \""+complaint_ID+"\" steps='12'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")

	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	//eval(responseText)
	parent.parent.document.getElementById("dialog-body").contentWindow.returnValue = link_Complaint;
	parent.parent.document.getElementById("dialog_tag").close();
}

async function showProblem(Patient_Id,term_code,term_set_id,Encounter_Id,occur_srl_no)
{
	var dialogHeight=20vh;
	var dialogWidth=30vw;
	//var title			= getLabel("Common.ChiefComplaint.label","Common")+" "+(getLabel("Common.Problem.label","Common"));
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await window.showModalDialog("../../eMR/jsp/selectProblemFrames.jsp?callFunction=showProblem&patient_id="+Patient_Id+"&encounter_id="+Encounter_Id+"&term_code="+term_code+"&term_set_id="+term_set_id+""+"&occur_srl_no="+occur_srl_no+" "	,arguments,features);
}
function checkOnSet()
{
	var max_record		= parent.frames[0].document.forms[0].max_record.value;
	var max_count		= parent.frames[0].document.forms[0].max_count.value;
	var callFunction	= parent.frames[0].document.forms[0].callFunction.value;
	var _diag_onset_date= parent.selectProblemFrame.document.forms[0].diag_onset_date.value;
	var dateObj			=_diag_onset_date.substring(0,10);
	var diag_onset_date = 					
		convertDate(dateObj,'DMY',localeName,'en');
	var error			= getMessage("PBLM_ONSET_BEYOND_DIAG_ONSET","MR");
	
	if(callFunction == 'selectProblem')
	{	
		for(var i=0;i<=max_record-1 ;i++)
		{
			
			var _comp_onset_date = eval(parent.selectProblemFrame.document.forms[0].comp_onset_date+i).value;
			var compObj			 =_comp_onset_date.substring(0,10);
			var comp_onset_date  = convertDate(compObj,'DMY',localeName,'en');
			
			if(eval(parent.selectProblemFrame.document.forms[0].select+i).checked == true)
			{
				if(!isAfter(comp_onset_date,diag_onset_date,'DMY',localeName))// DateUtils.js
				{
					alert(error);
					eval(parent.selectProblemFrame.document.forms[0].select+i).checked = false;
				}
			}
			
		}
	}
	else if(callFunction == 'modifyProblem')
	{
		for(var i=0;i<=max_record-1 ;i++)
		{
			
			//var comp_onset_date = convertDate(eval("parent.selectProblemFrame.document.forms[0].comp_onset_date"+i).value,'DMY',localeName,'en');

			var _comp_onset_date = eval(parent.selectProblemFrame.document.forms[0].comp_onset_date+i).value;
			var compObj			 =_comp_onset_date.substring(0,10);
			var comp_onset_date  = convertDate(compObj,'DMY',localeName,'en');

			if(eval(parent.selectProblemFrame.document.forms[0].select+i).disabled == false)
			{
				if(eval(parent.selectProblemFrame.document.forms[0].select+i).checked == true)
				{
					if(!isAfter(comp_onset_date,diag_onset_date,'DMY',localeName))// DateUtils.js
					{
						alert(error);
						eval(parent.selectProblemFrame.document.forms[0].select+i).checked = false;
					}
				}
			}
			
		}
		for (var j = 0; j <= max_count -1 ; j ++ )
		{
			//var _comp_onset_date = convertDate(eval("parent.selectProblemFrame.document.forms[0]._comp_onset_date"+j).value,'DMY',localeName,'en');

			var _comp_onset_date1 = eval(parent.selectProblemFrame.document.forms[0]._comp_onset_date+j).value;
			var compObj1		  =_comp_onset_date1.substring(0,10);
			var comp_onset_date1  = convertDate(compObj1,'DMY',localeName,'en');

			if(eval(parent.selectProblemFrame.document.forms[0]._select+j).checked == true)
			{
				if(!isAfter(comp_onset_date1,diag_onset_date,'DMY',localeName))// DateUtils.js
				{
					alert(error);
					eval(parent.selectProblemFrame.document.forms[0]._select+j).checked = false;
				}
			}
		}
	}
	

}

function cancelComplaint()
{
	window.close();
}

function diagClassLoad_dummy(){
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'){
		if(parent.frames[5].document.body != null){
			diagClassLoad();
		}else{
			setTimeout("diagClassLoad_dummy()",05);
		}
	}else{
		if(parent.frames[6].document.body != null ){
			diagClassLoad();
		}else{
			setTimeout("diagClassLoad_dummy()",05);
		}
	}
}

function diagClassModify_dummy(){
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'	){
		if(parent.frames[5].document.body != null){
			diagClassModify();
		}else{
			setTimeout("diagClassModify_dummy()",05);
		}
	}else{
		if(parent.frames[6].document.body != null ){
			diagClassModify();
		}else{
			setTimeout("diagClassModify_dummy()",05);
		}
	}
}

function diagClassLoad(){
		var mode =parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;

		//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		var function_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.function_id.value;
		var patient_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
		
		if(parent.RecDiagnosisAddModify.document.forms[0].isMultiDescAppl.value=="true" && parent.RecDiagnosisAddModify.document.getElementById('other_disp1'))
						{ // Added by mujafar for ML-MMOH-CRF-1281 US3
						parent.RecDiagnosisAddModify.document.getElementById('other_disp1').style.visibility = "hidden";
						parent.RecDiagnosisAddModify.document.getElementById('other_disp2').style.visibility = "hidden";
						}



	if(parent.RecDiagnosisAddModify.document.forms[0].code_set.value!=''){	
				var	htmlval = "";
				htmlval = "<html><body onKeyDown='lockKey()'><form name='MRval1' id='MRval1' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+parent.RecDiagnosisAddModify.document.forms[0].code_set.value+"'><input type='hidden' name='call_from' id='call_from' value='"+parent.RecDiagnosisAddModify.document.forms[0].call_from.value+"'><input type='hidden' name='PharmacyOrderRecDiagAppl' id='PharmacyOrderRecDiagAppl' value='"+parent.RecDiagnosisAddModify.document.forms[0].PharmacyOrderRecDiagAppl.value+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'><input type='hidden' name='function_id' id='function_id' value='"+function_id+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='step' id='step' value='1' ></input></form></body></html>";

					/*if(parent.messageFrame.document.body != null)
					parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',htmlval);
					if(parent.messageFrame.document.forms[0] != null)
					parent.messageFrame.document.forms[0].submit();*/
				

		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'){
					
				if(parent.frames[5].document.body != null)				
				parent.frames[5].document.body.insertAdjacentHTML('afterbegin',htmlval);
				if(parent.frames[5].document.MRval1 != null)
				parent.frames[5].document.MRval1.submit();
			
			
		}else{
			if(parent.frames[6].document.body != null ){
				parent.frames[6].document.write(htmlval);
				parent.frames[6].document.MRval1.submit();
			}
		}
	}
}

//10/19/2009 (IN015490)

function diagClassModify()
{
		var mode =parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;

		//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		var function_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.function_id.value;
		var patient_id = parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;

		var	htmlval = "";
		
	//	htmlval = "<html><body onKeyDown='lockKey()'><form name='MRval' id='MRval' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+parent.RecDiagnosisAddModify.document.forms[0].code_set.value+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'><input type='hidden' name='diag_class' id='diag_class' value='"+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_class_code.value+"'><input type='hidden' name='step' id='step' value='1' ></input></form></body></html>";
	//Suresh M
		htmlval = "<html><body onKeyDown='lockKey()'><form name='MRval' id='MRval' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+parent.RecDiagnosisAddModify.document.forms[0].code_set.value+"'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value+"'><input type='hidden' name='term_sht_desc' id='term_sht_desc' value='"+parent.RecDiagnosisAddModify.document.forms[0].term_sht_desc.value+"'><input type='hidden' name='isMultiDescAppl' id='isMultiDescAppl' value='"+parent.RecDiagnosisAddModify.document.forms[0].isMultiDescAppl.value+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'><input type='hidden' name='function_id' id='function_id' value='"+function_id+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='diag_class' id='diag_class' value='"+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagcode.value+"'><input type='hidden' name='step' id='step' value='1' ></input></form></body></html>";
 // modified by mujafar for ML-MMOH-CRF-1281
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'	)
		{
			if(parent.frames[5].document.body != null )
			parent.frames[5].document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.frames[5].document.MRval != null )
			parent.frames[5].document.MRval.submit();
		}
		else
		{
			if(parent.frames[6].document.body != null )
				parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.frames[6].document.MRval != null )
				parent.frames[6].document.MRval.submit();
		}
}
function restirctPrimaryDiag(Obj){
	/*if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == "Y" && parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication.value==''){

	getDrugIntrValidation();
	}*/
	var proceed =true;
	var dagger_independent_yn	=parent.RecDiagnosisAddModify.document.forms[0].dagger_independent_yn.value;
	var primary_diag			=Obj.value;
	var selectedDiagclass	=Obj.selectedIndex;
	if(selectedDiagclass!=0){
		var diag_class_type_hid	=	parent.RecDiagnosisAddModify.document.getElementById("diag_class_type_"+selectedDiagclass).value
		if (dagger_independent_yn=="Y" && diag_class_type_hid=="PD" && parent.RecDiagnosisAddModify.document.forms[0].isDiagClassMand.value=="false"){ //isDiagClassMand Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
				var err_msg=getMessage('PRIM_DIAG_NOT_APPLICABLE','MR');
				alert(err_msg)
				Obj.options[0].selected=true;
				proceed =false;
		}
	}
	return proceed;
}
//Added for this CRF Bru-HIMS-CRF-024.2
function diagNoteDisabled(){
   if(parent.RecDiagnosisAddModify.document.forms[0].notification_setup)parent.RecDiagnosisAddModify.document.forms[0].notification_setup.disabled=true; 
   //if(parent.RecDiagnosisAddModify.document.forms[0].Addnotification)parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=true; 
   if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code)parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.readOnly=true;
   if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_button)parent.RecDiagnosisAddModify.document.forms[0].diagprob_button.disabled=true;	    
}
function diagNoteEnabled(){ 
   parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_note_form.value="";
   if(parent.RecDiagnosisAddModify.document.forms[0].notification_setup)parent.RecDiagnosisAddModify.document.forms[0].notification_setup.disabled=false;
   if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_button)parent.RecDiagnosisAddModify.document.forms[0].diagprob_button.disabled=false;
   
   if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value==""&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code)parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.readOnly=false;   

}
async function NotifiableReport(Accessionnum,patient_id,enctr_id,fac_id){ 
 var title="";//getLabel("eMR.NotifyReport.label","MR");
    var dialogHeight ='30' ;
	var dialogWidth = '49' ;
	var dialogTop	= '129';
	var dialogLeft = '260' ;	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no; top=50';
    var arguments = "";
 var action_url="../../eCA/jsp/RecClinicalNotesSearchMain.jsp?accession_num="+Accessionnum+"&facility_id="+fac_id; 
 await window.showModalDialog(action_url,arguments,features);

}

function GetSerialNumber(){
      var code_set=parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
      var diagprob_code=parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
      var Patient_Id=parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value;
      var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH code_set=\""+code_set+"\" diagprob_code=\""+diagprob_code+"\" Patient_Id=\""+Patient_Id+"\"  steps='SerialNo'/></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","AdverseEventType.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
      responseText = responseText.replace(/<[^>]*>/g, '');
			responseText = trimString(responseText)
			eval(responseText)
}

function myTrim(x) {
    return (x === undefined || x === null ) ? x:x.replace(/^\s+|\s+$/gm,'');
}

//Below Line Added for this CRF GDOH-CRF-0082
function PMBValidation(){ 
var code_set=parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
var diagprob_code=parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
var pmbsupportdiag=parent.RecDiagnosisAddModify.document.RecDaignosis_form.pmbsupportdiag.value;
var totsupportdiagCount=parent.RecDiagnosisAddModify.document.RecDaignosis_form.totsupportdiagCount.value;


          var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest()			
			xmlStr ="<root><SEARCH steps='PMBCheck'" ;
			xmlStr +=" /></root>" ;			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") 
			xmlHttp.open("POST","AdverseEventType.jsp?code_set="+encodeURIComponent(code_set)+"&diagprob_code="+encodeURIComponent(diagprob_code)+"&pmbsupportdiag="+encodeURIComponent(pmbsupportdiag)+"&totsupportdiagCount="+encodeURIComponent(totsupportdiagCount)+"&steps=PMBCheck",false)
			xmlHttp.send(xmlDoc) 
			responseText=xmlHttp.responseText ; 
			responseText = trimString(responseText);
			eval(responseText)
	
}
//End GDOH-CRF-0082
// added by mujafar for 	ML-BRU-CRF-0524 start
function togglehide()
{
document.forms[0].recordeddateGif.style.visibility = "hidden";
document.forms[0].diagprobGif.style.visibility = "hidden";
document.forms[0].diagprobdescGif.style.visibility = "hidden";
document.forms[0].statusGif.style.visibility = "hidden";
document.forms[0].accuracyGif.style.visibility = "hidden";
document.forms[0].onsetDateGif.style.visibility = "hidden";	
	
}

function changeSortOrder(asc_desc,headerVal)
{
	togglehide();

	if(headerVal == "diagProb")
	{
		document.forms[0].diagprobGif.style.visibility = "visible";
		if(asc_desc ==' asc')
		document.forms[0].diagprobGif.src = '../../eAE/images/Ascending.gif'; 
		else
		document.forms[0].diagprobGif.src = '../../eAE/images/Descending.gif';
	}
	else if(headerVal == "diagProbDesc")
	{
		document.forms[0].diagprobdescGif.style.visibility = "visible";
		if(asc_desc ==' asc')
		document.forms[0].diagprobdescGif.src = '../../eAE/images/Ascending.gif'; 
		else
		document.forms[0].diagprobdescGif.src = '../../eAE/images/Descending.gif';
	}
	else if(headerVal == "status")
	{
		document.forms[0].statusGif.style.visibility = "visible";
		if(asc_desc ==' asc')
		document.forms[0].statusGif.src = '../../eAE/images/Ascending.gif'; 
		else
		document.forms[0].statusGif.src = '../../eAE/images/Descending.gif';
	}
	else if(headerVal == "accuracy")
	{
		document.forms[0].accuracyGif.style.visibility = "visible";
		if(asc_desc ==' asc')
		document.forms[0].accuracyGif.src = '../../eAE/images/Ascending.gif'; 
		else
		document.forms[0].accuracyGif.src = '../../eAE/images/Descending.gif';
	}
	else if(headerVal == "onsetDate")
	{
		document.forms[0].onsetDateGif.style.visibility = "visible";
		if(asc_desc ==' asc')
		document.forms[0].onsetDateGif.src = '../../eAE/images/Ascending.gif'; 
		else
		document.forms[0].onsetDateGif.src = '../../eAE/images/Descending.gif';
	}
	else
	{
		document.forms[0].recordeddateGif.style.visibility = "visible";
		if(asc_desc ==' asc')
		document.forms[0].recordeddateGif.src = '../../eAE/images/Ascending.gif'; 
		else
		document.forms[0].recordeddateGif.src = '../../eAE/images/Descending.gif';
	}
	
}

function sort(headerVal,order,practitioner_type,Patient_Id,Encounter_Id,cause_of_death,patient_class,age,dob,Locn_Code,Locn_Type,Practitioner_Id,relationship_id,sex,modal_yn,called_from_ip,option_id,accession_number,oh_chart_num,f_authorize_yn,p_called_from_widget,called_from_ot)
{

	if(headerVal == 'recDateTime')
	{
		document.forms[0].recordeddateGif.style.visibility = "visible";
		if(order ==' asc')
		{document.forms[0].recordeddateGif.src = '../../eAE/images/Descending.gif';
		order =' desc';
		}
		else
		{document.forms[0].recordeddateGif.src = '../../eAE/images/Ascending.gif';
		order =' asc';
		}	
	}
	else
	if(headerVal == 'diagProbDesc')
	{
		document.forms[0].diagprobdescGif.style.visibility = "visible";
		if(order ==' asc')
		{document.forms[0].diagprobdescGif.src = '../../eAE/images/Ascending.gif'; order =' desc';}
			else
			{document.forms[0].diagprobdescGif.src = '../../eAE/images/Descending.gif';order =' asc';}
		
	}
	else
	if(headerVal == 'diagProb')
	{
		
		document.forms[0].diagprobGif.style.visibility = "visible";
		if(order ==' asc')
		{document.forms[0].diagprobGif.src = '../../eAE/images/Descending.gif'; order =' desc';}
			else
			{document.forms[0].diagprobGif.src = '../../eAE/images/Ascending.gif';order =' asc';}
		
	}
	else
	if(headerVal == 'status')
	{
		document.forms[0].statusGif.style.visibility = "visible";
		if(order ==' asc')
		{document.forms[0].statusGif.src = '../../eAE/images/Ascending.gif'; order =' desc';}
			else
			{document.forms[0].statusGif.src = '../../eAE/images/Descending.gif';order =' asc';}
		
	}
	else
	if(headerVal == 'accuracy')
	{
		document.forms[0].accuracyGif.style.visibility = "visible";
		if(order ==' asc')
		{document.forms[0].accuracyGif.src = '../../eAE/images/Ascending.gif';order =' desc';}
			else
			{document.forms[0].accuracyGif.src = '../../eAE/images/Descending.gif';order =' asc';}
		
	}
	else
	if(headerVal == 'onsetDate')
	{
		document.forms[0].onsetDateGif.style.visibility = "visible";
		if(order ==' asc')
		{document.forms[0].onsetDateGif.src = '../../eAE/images/Ascending.gif'; order =' desc';}
			else
			{document.forms[0].onsetDateGif.src = '../../eAE/images/Descending.gif';order =' asc';} // encodeURIComponent(reaction_date)+
		
	}
			document.forms[0].target	=	"RecDiagnosisCurrentDiag";
		   document.forms[0].action	=	"../../eMR/jsp/RecDiagnosisCurrentDiag.jsp?practitioner_type="+practitioner_type+"&Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&cause_of_death="+cause_of_death+"&patient_class="+patient_class+"&Age="+age+"&Dob="+encodeURIComponent(dob)+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&Practitioner_Id="+Practitioner_Id+"&relationship_id="+relationship_id+"&Sex="+sex+"&modal_yn="+modal_yn+"&called_from_ip="+called_from_ip+"&option_id="+option_id+"&accession_number="+accession_number+"&oh_chart_num="+oh_chart_num+"&f_authorize_yn="+f_authorize_yn+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot+"&headerVal="+headerVal+"&asc_desc="+order;
		   document.forms[0].method	=	"post";
		   document.forms[0].submit();
	
}
// added by mujafar for 	ML-BRU-CRF-0524 end

function onDefltDiagCls(code, clsType){
	var isPatClsForDiagCat=parent.RecDiagnosisAddModify.document.RecDaignosis_form.isDiagCatgMand.value;

		if(isPatClsForDiagCat=='true')
			{			 
		if(clsType == "PD"){		 
			parent.RecDiagnosisAddModify.document.getElementById('diag_catg_img').style.visibility='visible';
			}
		else 
			{
			parent.RecDiagnosisAddModify.document.getElementById('diag_catg_img').style.visibility='hidden';	
			}
	
	}

	/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
	var isDeceasedDiagClassDeathRegAppl = parent.RecDiagnosisAddModify.document.RecDaignosis_form.isDeceasedDiagClassDeathRegAppl.value;
	var primary_diag_class = parent.RecDiagnosisAddModify.document.RecDaignosis_form.primary_diag_class.value;
	var secondary_diag_class = parent.RecDiagnosisAddModify.document.RecDaignosis_form.secondary_diag_class.value;

	if(isDeceasedDiagClassDeathRegAppl == 'true' && primary_diag_class != "" && secondary_diag_class != ""){

		var link_diag_pri_sec_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.value;
		var linked_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.linked_yn.value;

		if(linked_yn == 'Y'){
			if((code == primary_diag_class) && link_diag_pri_sec_yn == 'Y'){
				parent.RecDiagnosisAddModify.document.getElementById('linkcheckbox').style.display = 'inline';
			}else{
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.checked = false;
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.value = "N";
				parent.RecDiagnosisAddModify.document.getElementById('linkcheckbox').style.display = 'none';
			}
		}else{
			if(code == primary_diag_class){
				parent.RecDiagnosisAddModify.document.getElementById('linkcheckbox').style.display = 'inline';
			}else{
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.checked = false;
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.value = "N";
				parent.RecDiagnosisAddModify.document.getElementById('linkcheckbox').style.display = 'none';
			}
		}
	}
	/*End ML-MMOH-CRF-1742*/
}
function callDiagCateg(obj){
	
	var term_set_id=parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH termSetId=\""+term_set_id+"\" action='getDiagClassification'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	var responseText = xmlHttp.responseText
  responseText = responseText.replace(/<[^>]*>/g, '');
	var jsonArr = jQuery.parseJSON(responseText);	
	var isPatClsForDiagCat=parent.RecDiagnosisAddModify.document.RecDaignosis_form.isDiagCatgMand.value;
	for(var i = 0; i<jsonArr.length; i++){
		var val = jsonArr[i];
		if(val.diagClassCode == obj.value){
			
			if(isPatClsForDiagCat=='true' || isPatClsForDiagCat==true )
					{
				if(val.diagClassType == "PD"){
					parent.RecDiagnosisAddModify.document.getElementById("diag_catg_img").style.visibility='visible';
					}
					else 
					{
					parent.RecDiagnosisAddModify.document.getElementById("diag_catg_img").style.visibility='hidden';	
					}
			
			}
		}
	}
	if(isPatClsForDiagCat==true || isPatClsForDiagCat=='true'){
	if(obj.value == ""){
		parent.RecDiagnosisAddModify.document.getElementById("diag_catg_img").style.visibility='hidden';
		}
	}
	
	/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
	var isDeceasedDiagClassDeathRegAppl = parent.RecDiagnosisAddModify.document.RecDaignosis_form.isDeceasedDiagClassDeathRegAppl.value;
	var primary_diag_class = parent.RecDiagnosisAddModify.document.RecDaignosis_form.primary_diag_class.value;
	var secondary_diag_class = parent.RecDiagnosisAddModify.document.RecDaignosis_form.secondary_diag_class.value;

	if(isDeceasedDiagClassDeathRegAppl == 'true' && primary_diag_class != "" && secondary_diag_class != ""){

		var link_diag_pri_sec_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.value;
		var linked_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.linked_yn.value;

		if(linked_yn == 'Y'){
			if((obj.value == primary_diag_class) && link_diag_pri_sec_yn == 'Y'){
				parent.RecDiagnosisAddModify.document.getElementById('linkcheckbox').style.display = 'inline';
			}else{
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.checked = false;
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.value = "N";
				parent.RecDiagnosisAddModify.document.getElementById('linkcheckbox').style.display = 'none';
			}
		}else{
			if(obj.value == primary_diag_class){
				parent.RecDiagnosisAddModify.document.getElementById('linkcheckbox').style.display = 'inline';
			}else{
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.checked = false;
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.link_diag_pri_sec_yn.value = "N";
				parent.RecDiagnosisAddModify.document.getElementById('linkcheckbox').style.display = 'none';
			}
		}
	}
	/*End ML-MMOH-CRF-1742*/
}

function longDescToolTip(term_code, long_desc) {
    var tab_data2 = "<div style='all:unset'> " + term_code + " / " + long_desc + "</div>";
    return tab_data2;
}

function linkDiagCodeToPriSecDiagClass(obj){
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
}

//Added by Jeyachitra - ML-MMOH-CRF 1742
async function displayAuditTrial(Patient_Id,term_code,term_set_id,Encounter_Id,facility_id,occur_srl_no)
{
	var retVal;
	var dialogHeight = "30vh" ;
	var dialogWidth  = "55vw" ;
	var dialogTop    = "200";
	var dialogLeft   = "250";	
	var title = getLabel("Common.AuditTrail.label","Common");
	var features="dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await window.showModalDialog("../../eMR/jsp/AuditTrialMain.jsp?title="+title+"&patient_id="+Patient_Id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&occur_srl_no="+occur_srl_no+"&facility_id="+facility_id+"&encounter_id="+Encounter_Id,arguments,features);
}

