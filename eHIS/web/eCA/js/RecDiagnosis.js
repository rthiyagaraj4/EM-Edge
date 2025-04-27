async function evidencedby1()
{
	var retVal;
	var dialogHeight=20;
	var dialogWidth=40;
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
	retVal=await window.showModalDialog("../../eMR/jsp/RecDiagnosisEvidenceDtlMain.jsp?as_evidenced_by_fact="+as_evidenced_by_fact+"&as_evidenced_by_defn="+as_evidenced_by_defn+"&Patient_Id="+Patient_Id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&occur_srl_no_hid="+occur_srl_no_hid+"&nature="+nature ,arguments, features);
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
	var dialogHeight=20;
	var dialogWidth=50;
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

function cancel()
{
	window.parent.close();
}

async function  manifestion()
{
	var retVal;
	var dialogHeight=20;
	var dialogWidth=50;
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	
	var diag_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var diag_desc = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value;
	var associate_codes = parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes.value;	

	
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

	if(code_indicator == "D")
	{	
		
		retVal=await window.showModalDialog('../../eMR/jsp/AddDaggerCodeFrames.jsp?diag_code='+diag_code+'&diag_desc='+diag_desc+'&associate_codes='+associate_codes+'&term_set_id='+term_set_id+'&Dob='+Dob+'&Age='+Age+'&Sex='+Sex+'&Patient_Id='+Patient_Id+'&term_set_id='+term_set_id+'&term_code='+term_code+'&occur_srl_no='+occur_srl_no_hid,arguments,features);
		if(retVal != null)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes.value = retVal;	
	}
	else if(code_indicator == "C")
	{			
		
	
		retVal=await window.showModalDialog('../../eMR/jsp/AddAssociateCodeFrames.jsp?term_set_id='+term_set_id+'&diag_code='+diag_code+'&diag_desc='+diag_desc+'&associate_codes='+associate_codes+'&Dob='+Dob+'&Age='+Age+'&Sex='+Sex+'&code_indicator=E&Patient_Id='+Patient_Id+'&term_set_id='+term_set_id+'&term_code='+term_code+'&occur_srl_no='+occur_srl_no_hid,arguments,features);
		if(retVal != null)
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.associate_codes.value = retVal;	
	}
}


function callNotifiableNotes()
{
	
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
	//alert("episode_type"+episode_type);
	//var accession_num = "";
    var accession_num=parent.RecDiagnosisAddModify.document.RecDaignosis_form.accession_number.value;
	//alert("accession_num"+accession_num);
	
	/*
alert("patient_id"+patient_id);	
alert("episode_id"+episode_id);	
alert("episode_type"+episode_type);	
alert("visit_adm_date"+visit_adm_date);	
alert("patient_class"+patient_class);	*/
//alert("accession_num"+document.forms[0].accession_number.value);	

	
	var dialogHeight= "48";
	var dialogWidth	= "65";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

		//var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=NOTIFIABLEFORM&title=Notifiable Form&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&Field_Ref=parent.addModifyPatProblem.document.forms[0].accession_num";///*&accession_num="+accession_num+"*/
var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=NOTIFIABLEFORM&title=Notifiable Form&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=parent.addModifyPatProblem.document.forms[0].accession_num&speciality_code="+speciality_code+"&location_code="+Locn_Code;
		//var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=NOTIFIABLEFORM&title=Notifiable Form&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=parent.addModifyPatProblem.document.forms[0].accession_num");
	//alert('action_url:'+action_url);
	
	
var child_window = window.open(action_url,null,"height=700,width=1100,top=0,left=0,status=NO,toolbar=no,menubar=no,location=no");
	//modified for SCR 4284_reopen on 31-07-2008
	//var child_window = window.showModalDialog("../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=NOTIFIABLEFORM&title=Notifiable Form&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=parent.addModifyPatProblem.document.forms[0].accession_num",arguments,features);
	child_window.focus();
}

 
async function diffGroupforDiag(qrystr)
{
	var retVal;
	var dialogHeight=20;
	var dialogWidth=40;
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	var mode = parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value;

	retVal=await window.showModalDialog("../../eMR/jsp/RecDiagnosisDifferentialGroup.jsp?"+qrystr,arguments,features);	
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.diff_group_vals.value = retVal;

}

async function diffGroup(digcode,id,term_code)
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
	var dialogHeight=20;
	var dialogWidth=40;
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await window.showModalDialog("../../eMR/jsp/RecDiagnosisDifferentialGroup.jsp?Patient_Id="+patientid+"&term_set_id="+term_set_id+"&term_set_code="+term_set_code+"&diag_Description="+term_code_desc+"&onset_date="+onset_date+"&mode="+mode+"&display_mode="+display_mode,arguments,features);	
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
	var obj1=document.getElementById("tooltiplayer");
	if(obj1 != null)
	{
		buildTable(grp_ids,curr_id,grpid,temp_grpids,mode)
		//bodwidth  = parent.RecDiagnosisCurrentDiagheader.document.body.offsetWidth
		bodwidth = document.body.offsetWidth;
		//bodheight = parent.RecDiagnosisCurrentDiagheader.document.body.offsetHeight
		bodheight = document.body.offsetHeight;
		var x 	  = event.x
		var y 	  = event.y;
		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth)
		y 	  = y + (document.getElementById("tooltiplayer").offsetHeight)

		if(x<bodwidth)
			x = event.x 
		else
			x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
		if(y<bodheight)
			y = event.y
		else
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
		
		y+=document.body.scrollTop
		x+=document.body.scrollLeft
		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
		document.getElementById("tooltiplayer").style.visibility='visible' 
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
	document.getElementById("t").innerHTML = tab_dat;
}


function hideToolTip()
{
	if(document.getElementById("tooltiplayer") != null)
	{
		document.getElementById("tooltiplayer").style.visibility = 'hidden'
	}
}


function CheckMultiSelect(grp_id)
{
	var all_chk = document.getElementById("termvals");
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
		window.close();
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

	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "27.22" ;
	var dialogWidth = "44" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	

	retVal =await window.showModalDialog("TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

	if(retVal != null)
	{
		var arr = new Array();
		retcode = retVal.split("/");
		document.RecDaignosis_form.diagprob_code.value = retcode;
		document.RecDaignosis_form.diagprob_code.onblur();
	}
}

function getDescription()
{
	var diag_code = document.RecDaignosis_form.diagprob_code.value;
	var diagprob_desc = document.RecDaignosis_form.diagprob_desc.value;
	if(diag_code!="")
	{
		htmlval = "<html><body><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+document.RecDaignosis_form.code_set.value+"'><input type='hidden' name='term_set_code' id='term_set_code' value='"+diag_code+"'><input type='hidden' name='Age' id='Age' value='"+document.RecDaignosis_form.age.value+"'><input type='hidden' name='Sex' id='Sex' value='"+document.RecDaignosis_form.sex.value+"'><input type='hidden' name='Dob' id='Dob' value='"+document.RecDaignosis_form.dob.value+"'><input type='hidden' name='modal_yn' id='modal_yn' value='"+document.RecDaignosis_form.modal_yn.value +"' ><input type='hidden' name='step' id='step' value='2' ></input> </form></body></html>";
		
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


function getCodeSet()
{	

	if(document.forms[0].code_set.value != '')
	{
		var sel =document.forms[0].code_set.selectedIndex; 
		retVal = document.forms[0].code_set.options(sel).id;
		//retVal  ="Y=Y=Y=Y=Y=Y=Y";
		//alert("-------mode code set value");
		
		var arr = retVal.split("=");
		
		if(document.forms[0].priority_appl_yn!=null)
			document.forms[0].priority_appl_yn.value=arr[0];
		if(document.forms[0].nature_appl_yn!=null)
			document.forms[0].nature_appl_yn.value=arr[1];
		if(document.forms[0].severity_appl_yn!=null)
			document.forms[0].severity_appl_yn.value=arr[2];
		if(document.forms[0].onset_type_appl_yn!=null)
			document.forms[0].onset_type_appl_yn.value=arr[3];
		if(document.forms[0].factors_appl_yn!=null)
			document.forms[0].factors_appl_yn.value=arr[4];
		if(document.forms[0].notification_appl_yn!=null)
			document.forms[0].notification_appl_yn.value=arr[5];
		if(document.forms[0].enc_stage_appl_yn!=null)
			document.forms[0].enc_stage_appl_yn.value=arr[6];

		if(arr[0] == "Y")
		{	
			parent.RecDiagnosisAddModify.document.getElementById("priority_tab_id").style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById("priority_tab_id1").style.visibility='visible';
		}
		else
		{	
			parent.RecDiagnosisAddModify.document.getElementById("priority_tab_id").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("priority_tab_id1").style.visibility='hidden';
		}
	
		if(arr[1] == "Y")
		{	
		//alert("1");	parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id").style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id1").style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id").style.visibility='visible';
		}
		else
		{	
			//alert("2");
			parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id1").style.visibility='hidden';
		}
		
		if(arr[2] == "Y")
		{	
			parent.RecDiagnosisAddModify.document.getElementById("severity_tab_id").style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById("severity_tab_id1").style.visibility='visible';
		}
		else
		{	
			parent.RecDiagnosisAddModify.document.getElementById("severity_tab_id").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("severity_tab_id1").style.visibility='hidden';
		}

		if(arr[3] == "Y")
		{
			parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid").style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid2").style.visibility='visible';
			
			//parent.frames[3].document.getElementById("onset_type_tabid1").style.visibility='inline';
			//parent.frames[3].document.getElementById("onset_type_tabid1").style.visibility='inline';
		}
		else
		{
			
			parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid2").style.visibility='hidden';
		}

		if(arr[6] == "Y" && document.forms[0].patient_class.value=='IP')
		{
			
			//parent.frames[3].document.getElementById("enc_stage_tab_id").style.visibility='visible';
			parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_id2").style.visibility='visible';
			//parent.frames[3].document.getElementById("enc_stage_tab_id").innerHTML=  getLabel("eMR.DiagnosisStage.label","MR");
			parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_id").innerHTML=  getLabel("eMR.EncounterStage.label","MR");
			parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_img").style.visibility='visible';
			
		}
		else
		{
			parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_id2").style.visibility='hidden';
			parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_id").innerHTML='&nbsp;';
			parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_img").style.visibility='hidden';
			
		}

		if((arr[0] != "Y") && (arr[2] != "Y"))
		{	
			parent.RecDiagnosisAddModify.document.getElementById("ser_pri_row").style.display='none';
		}
		else
		{
			parent.RecDiagnosisAddModify.document.getElementById("ser_pri_row").style.display='inline';
		}

		var codeset_up=parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value;
		//parent.RecDiagnosisAddModify.document.getElementById("diag_classf_legend").style.visibility='visible';
		//parent.RecDiagnosisAddModify.document.getElementById("diag_classf_desc").style.visibility='visible';
		
	}
	else
	{
	//alert("-------mode code set null value");	parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid2").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("priority_tab_id").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("priority_tab_id1").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id1").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("severity_tab_id").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("severity_tab_id1").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_id2").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_id").innerHTML="&nbsp;";
		parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_img").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("exclamation").style.visibility='hidden';

		//parent.RecDiagnosisAddModify.document.getElementById("diag_classf_legend").style.visibility='hidden';
		//parent.RecDiagnosisAddModify.document.getElementById("diag_classf_desc").style.visibility='hidden';
		
			
	}

	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode!=null)
	{
	//alert("1");	
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value!='modify')
		{	
		//alert("2");
			parent.RecDiagnosisAddModify.document.getElementById("differential_anchor").innerText = "";
			//parent.frames[3].document.getElementById("evidence_anchor").innerText = "";
			parent.RecDiagnosisAddModify.document.getElementById("manifest_anchor").innerText="";
			//parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="";
		}
		
	}
	
	
	
	setRefresh();
	
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value== "")
	{
		
		parent.RecDiagnosisAddModify.document.getElementById("exclamation").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("ntf_button").style.visibility='hidden';
	}

	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandFlag.value='N';
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.factors_appl_yn!=null)
	{
		var factors_appl_yn = parent.RecDiagnosisAddModify.document.RecDaignosis_form.factors_appl_yn.value
		if(factors_appl_yn=="Y")
		{		
			//alert("inline");
			parent.RecDiagnosisAddModify.document.getElementById("ser_pri_row").style.display='inline';
				parent.RecDiagnosisAddModify.document.getElementById("evidence_anchor").innerText = "[ "+getLabel("eMR.AsEvidencedBy.label","MR")+" ]";
		}
		else
		{
				parent.RecDiagnosisAddModify.document.getElementById("evidence_anchor").innerText = "";
		}
	}

	/*if(diag_code!="" && diagprob_desc!="")
	{
		if(document.forms[0].notification_appl_yn.value =='N' || document.forms[0].notification_appl_yn.value ==''){
			parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="";
		}
		else if(document.forms[0].notification_appl_yn.value =='Y' && (document.forms[0].notifiable_yn.value =='Y' || document.forms[0].notifiable_yn.value =='') )
		{
			parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="[ Notification Form ]";
		}
	}*/
}

function enableExternal1()
{
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator!=null)
	{
		var code_indicator = parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value;	
		if(code_indicator == "D")
		{
			parent.RecDiagnosisAddModify.document.getElementById("manifest_anchor").innerText = "[ "+getLabel("eMR.Manifestation.label","MR")+"  ]";
		}
		else if(code_indicator == "C")
		{
			parent.RecDiagnosisAddModify.document.getElementById("manifest_anchor").innerText = "[ "+getLabel("eMR.ExternalCause.label","MR")+" ]";
		}
	}
	/*
	var diag_code = parent.frames[3].document.RecDaignosis_form.diagprob_code.value
	var diag_desc = parent.frames[3].document.RecDaignosis_form.diagprob_desc.value
	var factors_appl_yn = parent.frames[3].document.RecDaignosis_form.factors_appl_yn.value
	if(diag_code!="" && diag_desc!="" && factors_appl_yn=="Y")
	{
		parent.frames[3].document.getElementById("ser_pri_row").style.display='inline';
		parent.frames[3].document.getElementById("evidence_anchor").innerText = "[ As Evidenced by ]";
	}
	else
	{
		parent.frames[3].document.getElementById("evidence_anchor").innerText = "";
	}
	*/

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
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.accuracy.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.nature.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.b_days.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.b_months.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.b_age.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.onset_date.value=parent.RecDiagnosisAddModify.document.RecDaignosis_form.dateTime.value;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.status_date.value=parent.RecDiagnosisAddModify.document.RecDaignosis_form.currentdate.value;
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.status.value='A';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.remarks.value='';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.severity.value='D';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.priority.value='N';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.type.value='N';
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_stage.value='';			
			
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value != "CarPlanAssesment")
			{
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value='';
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';
			}
		}
	}
}

function showTable(obj)
{
	
	//alert(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value)
	if(obj.value!=null && obj.value!="")
	{										
			
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='visible';
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
			{
				
			
				if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' ){
					//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,15%,3%,*,4%,0%,7%";
					parent.parent.frames[1].document.getElementById("RecDiagMain").rows="2%,15%,3%,*,4%,0%,7%";
				}
				else
					//
				//alert(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value);
				{
					//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,7%,15%,3%,*,4%,0%,7%"; actually frame used before9/22/2008 modified by anjaneya
					parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,0%,7%";
				}
					//
			}
			else
			{
				
				if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y')
					top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,15%,3%,*,4%,0%,7%";
				else
					top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,7%,15%,3%,*,4%,0%,7%";
			}
			//9/29/2008 code add for frame time delay
			setTimeout('mrValidateForm()',50);
			//9/29/2008 code add for frame time delay
		var	htmlval = "<html><body><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RecDiagnosisValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+obj.value+"'><input type='hidden' name='step' id='step' value='1' ></input></form></body></html>";
	/*parent.frames[5].document.body.insertAdjacentHTML('afterbegin',htmlval);
	parent.frames[5].document.MRvalidate.submit();//called from CA*/
	//if(parent.blankframe1.document.forms[0] != null)
	/*
	parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
	parent.frames[6].document.MRvalidate.submit();//called from MR and IP
	*/
	//if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value == 'Y'	)
	//	{
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set != null)
			parent.frames[6].document.MRvalidate.submit();
	//	}
	//else
	//	{
		//	parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
			//if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set != null)
		//	parent.frames[6].document.MRvalidate.submit();
	//}

	//9/29/2008 code add for frame time delay
	//if(parent.blankframe1.document.forms[0] != null)
	//parent.blankframe1.document.body.insertAdjacentHTML('afterbegin',htmlval);
	//9/29/2008 code add for frame time delay
			//setTimeout('mrValidateForm()',50);
			//9/29/2008 code add for frame time delay
			//if(parent.blankframe1.document.forms[0] != null)
	//parent.blankframe1.document.MRvalidate.submit();
	}
	else
	{
		
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='hidden';		
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' )
			{
				//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,60%,3%,*,4%,0%,7%";
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="2%,60%,3%,*,4%,0%,7%";
			}
			else
			{
				//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,7%,60%,3%,*,4%,0%,7%";
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,2%,60%,3%,*,4%,0%,7%";
			}
		}
		else	
		{
			
			if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y')
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,60%,3%,*,4%,0%,7%";
			else
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,7%,60%,3%,*,4%,0%,7%";
		}
	}
	

	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';

}
//9/29/2008 calling the  reloading the function
function mrValidateForm(){
	parent.blankframe1.location.reload();
		//parent.frames[4].location.reload();
		

}
function selectframe(){
	parent.blankframe1.document.MRvalidate.submit();
		//parent.frames[4].location.reload();
		

}
//9/29/2008end  reloading the function
function callDetails(Patient_Id, term_code, term_set_id, patient_class, onset_date, notifiable_yn, dob, age, sex, occur_srl_no, associate_codes, Encr_id, cause_of_death, Locn_Code,isCurrentEncounter,old_encounter_id,option_id,accession_no,oh_chart_num,diag_classification)
{
	modal_yn=parent.RecDiagnosisCurrentDiag.document.query_result_form.modal_yn.value;	
	called_from_ip=parent.RecDiagnosisCurrentDiag.document.query_result_form.called_from_ip.value

	parent.RecDiagnosisAddModify.document.location.href="../../eMR/jsp/RecDiagnosisAddModify.jsp?Locn_Code="+Locn_Code+"&cause_of_death="+cause_of_death+"&Patient_Id="+Patient_Id+"&called_from_ip="+called_from_ip+"&term_code="+term_code+"&term_set_id="+term_set_id+"&patient_class="+patient_class+"&onset_date="+onset_date+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&occur_srl_no="+occur_srl_no+"&mode=modify&associate_codes="+associate_codes+"&modal_yn="+modal_yn+"&Encounter_Id="+Encr_id+"&notifiable_yn="+notifiable_yn+"&practitioner_type="+parent.RecDiagnosisCurrentDiag.document.query_result_form.practitioner_type.value+"&isCalledFromCA="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value+"&isCurrentEncounter="+isCurrentEncounter+"&old_encounter_id="+old_encounter_id+"&option_id="+option_id+"&accession_num="+accession_no+"&oh_chart_num="+oh_chart_num+"&diag_classification="+diag_classification;

	
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' )
			//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,15%,3%,*,4%,0%,7%";
			parent.parent.frames[1].document.getElementById("RecDiagMain").rows="2%,15%,3%,*,4%,0%,7%";
		else
			//parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,7%,15%,3%,*,4%,0%,7%";
			parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,2%,15%,3%,*,4%,0%,7%";
	}
	else
	{
		if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y')
			top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,15%,3%,*,4%,0%,7%";
		else
			top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,7%,15%,3%,*,4%,0%,7%";
	}

	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
	parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';

}

function ShowSupportingDiag(term_code,occur_srl_no,Patient_Id,term_set_id,title)
{
	var dialogHeight= "10" ;
    var dialogWidth = "35" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	window.showModalDialog("../../eMR/jsp/ShowExternaltTermCodeFrames.jsp?term_code="+term_code+"&title="+encodeURIComponent(title)+"&occur_srl_no="+occur_srl_no+"&Patient_Id="+Patient_Id+"&term_set_id="+term_set_id,arguments,features);
}

function expandColapseframe(id)
{

	
	//if(parent.frames[3].document.getElementById("mode").value=="modify" && id == "E")
	if(id == "E" && document.forms[0].code_set.value != '')
	{
		//alert("---------------------e:codeset");
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='visible';
			if(parent.RecDiagnosisAddModify.document.getElementById("mode").value=="modify")
			{
				//parent.frames[3].document.getElementById("exclamation").style.visibility='visible';
			}
			else
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandFlag.value='Y';

			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value!= "")
			{
				//alert();
				parent.RecDiagnosisAddModify.document.getElementById("exclamation").style.visibility='visible';
				//parent.RecDiagnosisAddModify.document.getElementById("view_link").style.visibility='visible';
			}

			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=='Y')
				parent.RecDiagnosisAddModify.document.getElementById("ntf_button").style.visibility='visible';
			
			getCodeSet();
	}
	else 
	{
		//alert("4");
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.all.DiagTable.style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid1").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("priority_tab_id").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("priority_tab_id1").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("nature_tab_id1").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("severity_tab_id1").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("severity_tab_id").style.visibility="hidden";
		parent.RecDiagnosisAddModify.document.getElementById("onset_type_tabid2").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("exclamation").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_id2").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("enc_stage_tab_img").style.visibility='hidden';
		parent.RecDiagnosisAddModify.document.getElementById("ntf_button").style.visibility='hidden';
		//parent.RecDiagnosisAddModify.document.getElementById("diag_classf_legend").style.visibility='hidden';
		//parent.RecDiagnosisAddModify.document.getElementById("diag_classf_desc").style.visibility='hidden';

		
	}

	if(id == "E")
	{
		
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' )
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,15%,3%,*,4%,0%,7%";
			else
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,7%,15%,3%,*,4%,0%,7%";
		}
		else
		{
			if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y')
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,15%,3%,*,4%,0%,7%";
			else
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,7%,15%,3%,*,4%,0%,7%";
		}
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = true;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = false;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';
		
	}
	else if(id =="C")
	{
		if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.isCalledFromCA.value=='Y' )
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,60%,3%,*,4%,0%,7%";
			else
				parent.parent.frames[1].document.getElementById("RecDiagMain").rows="7%,7%,60%,3%,*,4%,0%,7%";
		}
		else	
		{
			if(top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("isCalledFromCA").value=='Y')
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,60%,3%,*,4%,0%,7%";
			else
				top.content.workAreaFrame.RecDiagnosisMain.document.getElementById("RecDiagMain").rows="7%,7%,60%,3%,*,4%,0%,7%";
		}
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.collapse.disabled = true;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expand.disabled = false;
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.expandcollapse.value = 'E';
	}
}

function show_diff_link(obj)
{
	var accuracy = obj.options(obj.selectedIndex).text;
	var diag_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
	var accry_code_ind = parent.RecDiagnosisAddModify.document.RecDaignosis_form.accry_code_ind.value;

	if(diag_code!="" && accry_code_ind=="U"){
			parent.RecDiagnosisAddModify.document.getElementById("differential_anchor").innerText = "[ "+getLabel("eMR.DifferentialGroup.label","MR")+" ]";
	}
	else
		parent.RecDiagnosisAddModify.document.getElementById("differential_anchor").innerText = "";
}

function showLongDescription()
{
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	var a = document.forms[0].LongDescription.value;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	window.showModalDialog("../../eMR/jsp/RecDaignosisLongDescDialog.jsp?longDesc="+a,"",features);
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
	if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.inc_encounter!=null)
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
			parent.RecDiagnosisAddModify.document.getElementById("ser_pri_row").style.display='inline';
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

	/*if(diag_code!="" && diag_desc!="")
	{
		notification_appl_yn = parent.frames[3].document.forms[0].notification_appl_yn.value;
		notifiable_yn = parent.frames[3].document.forms[0].notifiable_yn.value;

		if((notification_appl_yn =='N' || notification_appl_yn =='') || (notifiable_yn =='N' || notifiable_yn =='') ){
			parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="";
		}
		else if(notification_appl_yn =='Y' && (notifiable_yn =='Y' || notifiable_yn =='') )
		{
			parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="[ Notification Form ]";
		}
	}*/
}

function notify()
{
	var diag_code = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value
	var diag_desc = parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value

	//if(diag_code!="" && diag_desc!="")
//now	{

		if(parent.RecDiagnosisAddModify.document.forms[0].notification_appl_yn!=null || parent.RecDiagnosisAddModify.document.forms[0].notifiable_yn!=null)
	{
		notification_appl_yn = parent.RecDiagnosisAddModify.document.forms[0].notification_appl_yn.value;
		notifiable_yn = parent.RecDiagnosisAddModify.document.forms[0].notifiable_yn.value;
		if((notification_appl_yn =='N' || notification_appl_yn =='') || (notifiable_yn =='N' || notifiable_yn =='') )
		{
//now			parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="";
		}
		else if(notification_appl_yn =='Y' && (notifiable_yn =='Y' || notifiable_yn =='') )
		{
//now			parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="[ "+getLabel("eMR.NotificationForm.label","MR")+" ]";
		}
	}
//now	}
}


/*function clear_notify()
{
		parent.RecDiagnosisOpernToolbar.document.getElementById("notice_anchor").innerText="";
}*/

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
	var retVal;
	var dialogHeight=20;
	var dialogWidth=50;
	var title			= getLabel("Common.view.label","Common")+" "+(getLabel("Common.Link.label","Common"));
	var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	retVal=await window.showModalDialog("../../eMR/jsp/ViewLinkDiagnosis.jsp?title="+title+"&patient_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.Patient_Id.value+"&term_set_id="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_set.value+"&term_code="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value+"&term_desc="+parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value	,arguments,features);
	}
	/*if(retVal != '' )
		document.RecDiagAddModifyForm.as_evidenced_by.value = retVal;*/
}

