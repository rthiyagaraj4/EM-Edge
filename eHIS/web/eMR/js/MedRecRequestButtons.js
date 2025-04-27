 async function openCAModal()
{
	var patient_class	= parent.frames[1].document.forms[0].patient_class.value;
	var episode_id		= parent.frames[1].document.forms[0].encounter_id.value;
	var note_type		= parent.frames[2].document.forms[0].rep_type.value;
	var patient_id		= parent.frames[2].document.forms[0].patientId.value;
	var accession_num	= parent.frames[2].document.forms[0].accession_num.value;
	var location_code	= document.forms[0].location_code.value;
	var speciality_code	= document.forms[0].specialty_code.value;
	var contr_mod_accession_num	=	'MR_'+parent.frames[2].document.forms[0].request_id.value;

	var action_url		= "../../eCA/jsp/RecClinicalNotesModal.jsp?title="+encodeURIComponent(getLabel("eMR.RecordNotes.label","MR"))+"&function_id=SPCL_NOTE&event_class=MDR$&Field_Ref=parent.frames[2].document.forms[0].accession_num&note_type="+note_type+"&patient_class="+patient_class+"&encounter_id="+episode_id+"&patient_id="+patient_id+"&accession_num="+accession_num+"&appl_task_id=MR_MEDICAL_REPORT"+"&contr_mod_accession_num="+contr_mod_accession_num+"&speciality_code="+speciality_code+"&location_code="+location_code ;

	var retVal= await window.open(action_url,null,"height=700,width=1000,top=0,left=0,status=no,toolbar=no,menubar=no,location=no");
	retVal.focus();
}


function closeME()
{
	var call_function = document.forms[0].called_from.value;
	if(call_function == "PREPARE_MEDICAL_REPORT")
	{
		if(document.forms[0].called_from.value == "CA" && parent.frames[2].document.forms[0].accession_num.value !='' )
		{
			for(var j=0; j<parent.frames[2].document.forms[0].length;j++)
			{
				parent.frames[2].document.forms[0].elements(j).disabled = false;
			}
			parent.frames[2].document.forms[0].prepare_date.value='';
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
		else
		{
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();
		}
	}
	else{
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
    }
		
}


async function printReport()
{
	var accession_num = "";

	accession_num	= parent.frames[2].document.forms[0].accession_num.value;
	if(accession_num == "") 
		accession_num = document.forms[0].accession_num.value;

	if(accession_num == '')
	{
		alert(getMessage("NOTE_DOESNOT_EXIST","MR"));
	}
	else
	{
		var retVal		= 	new String();
		var dialogTop	=	"60";
		var dialogHeight=	"65vh" ;
		var dialogWidth	=	"65vw" ;
		var	title		=	getLabel("eMR.MedicalReport.label","MR");
		var features	=	"dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+"; status=no" ;
		var header = "";

		var patientId		=	document.forms[0].patientId.value;
		var patient_line	=	document.forms[0].patient_line.value;
		var episode_type	=	document.forms[0].episode_type.value;
		var request_id		=	document.forms[0].request_id.value;
		var call_function	=	document.forms[0].call_function.value;
	
		var arrMain			=	patient_line.split("|");
		var arrPatient		=	arrMain[0].split(",");
		var patient_id		=	arrMain[1].substring(3,arrMain[1].length);

		var check = arrPatient.length;
		if(parseInt(check)==3)
		{	
			/*header = "<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr>"+
			"<br><tr><td align=center><h4>"+encodeURIComponent(title)+"</h4></td></tr></table>"+
			"<BR><table width='100%' border='1' cellpadding=0 cellspacing=0 align=center><tr><td>"+
			"<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td nowrap><b>"+getLabel("Common.patientId.label","Common")+"</b></td><td nowrap><font size='2'>: "+patient_id+"</font></td>"+
			"<td nowrap><b>"+getLabel("Common.name.label","Common")+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=0 cellspacing=0><tr><td nowrap><font size='2'>: "+((arrPatient[0]==null)?"":arrPatient[0])+"</font></td></tr><tr><td>"+" "+"</td></tr></table></td></tr><tr><td nowrap><b>Sex</b></td><td nowrap><font size='2'>: "+((arrPatient[2]==null)?"":arrPatient[2])+"</font></td><td nowrap><b>"+getLabel("Common.age.label","Common")+"</b></td><td nowrap><font size='2'>: "+((arrPatient[1]==null)?"":arrPatient[1])+"</font></td></tr>";*/

			header = "<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr>"+
			"<br><tr><td align=center><h4>"+title+"</h4></td></tr></table>"+
			"<BR><table width='100%' border='1' cellpadding=0 cellspacing=0 align=center><tr><td>"+
			"<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td nowrap><b>"+getLabel("Common.patientId.label","Common")+"</b></td><td nowrap><font size='2'>: "+patient_id+"</font></td>"+
			"<td nowrap><b>"+getLabel("Common.name.label","Common")+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=0 cellspacing=0><tr><td nowrap><font size='2'>: "+((arrPatient[0]==null)?"":arrPatient[0])+"</font></td></tr><tr><td>"+" "+"</td></tr></table></td></tr><tr><td nowrap><b>Sex</b></td><td nowrap><font size='2'>: "+((arrPatient[2]==null)?"":arrPatient[2])+"</font></td><td nowrap><b>"+getLabel("Common.age.label","Common")+"</b></td><td nowrap><font size='2'>: "+((arrPatient[1]==null)?"":arrPatient[1])+"</font></td></tr>";
		}else if(parseInt(check)==4)
		{
			/*header = "<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr><br><tr><td align=center><h4>"+encodeURIComponent(title)+"</h4></td></tr></table>"+
			"<br><table width='100%' border='1' cellpadding=0 cellspacing=0 align=center><tr><td>"+
			"<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td nowrap><b>"+getLabel("Common.patientId.label","Common")+"</b></td><td><font size='2'>: "+patient_id+"</font></td>"+
			"<td nowrap><b>"+getLabel("Common.name.label","Common")+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=0 cellspacing=0><tr><td><font size='2'>: "+((arrPatient[0]==null)?"":arrPatient[0])+"</font></td></tr><tr><td><font size='2'>&nbsp;"+((arrPatient[1]==null)?"":arrPatient[1])+"</font></td></tr></table></td></tr><tr><td nowrap><b>Sex</b></td><td nowrap><font size='2'>: "+((arrPatient[3]==null)?"":arrPatient[3])+"</font></td><td nowrap><b>"+getLabel("Common.age.label","Common")+"</b></td><td nowrap><font size='2'>: "+((arrPatient[2]==null)?"":arrPatient[2])+"</font></td></tr>";*/

			header = "<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr><br><tr><td align=center><h4>"+title+"</h4></td></tr></table>"+
			"<br><table width='100%' border='1' cellpadding=0 cellspacing=0 align=center><tr><td>"+
			"<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td nowrap><b>"+getLabel("Common.patientId.label","Common")+"</b></td><td><font size='2'>: "+patient_id+"</font></td>"+
			"<td nowrap><b>"+getLabel("Common.name.label","Common")+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=0 cellspacing=0><tr><td><font size='2'>: "+((arrPatient[0]==null)?"":arrPatient[0])+"</font></td></tr><tr><td><font size='2'>&nbsp;"+((arrPatient[1]==null)?"":arrPatient[1])+"</font></td></tr></table></td></tr><tr><td nowrap><b>Sex</b></td><td nowrap><font size='2'>: "+((arrPatient[3]==null)?"":arrPatient[3])+"</font></td><td nowrap><b>"+getLabel("Common.age.label","Common")+"</b></td><td nowrap><font size='2'>: "+((arrPatient[2]==null)?"":arrPatient[2])+"</font></td></tr>";
		}

		header +="<th colspan='6'>&nbsp;</th>";
		
		var arguments	=	header;

		
		retVal = 	await window.showModalDialog("../../eMR/jsp/ViewMedicalReport.jsp?patientId="+patientId+"&request_id="+request_id+"&accession_num="+accession_num+"&episode_type="+episode_type+"&call_function="+call_function,arguments,features);
	}
}

function apply1()
{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	
	parent.frames[2].document.forms[0].temp_pract.value = "SAVEASDRAFT";
	apply();
}

async function apply()
{
	/*var called_from = parent.frames[2].document.forms[0].called_from.value;
	var call_function = parent.frames[2].document.forms[0].call_function.value;*/
	var called_from = document.forms[0].called_from.value;
	var call_function = document.forms[0].call_function.value;
	var isSpecialtyDefaultApp = parent.frames[2].document.forms[0].isSpecialtyDefaultApp.value;

	
/*
	if(call_function == "PREPARE_MEDICAL_REPORT")
		getEventStatus();
*/
	//
	var mandatoryFields = new Array ();
	var displayNames = new Array ();
		
	//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	if(call_function == "MEDICAL_REPORT_REQUEST")
	{	
		var msg = getMessage("REQ_REAL_TYPE_MANDATORY","MR");
		var msgg = msg.replace("Relationship Type",getLabel("Common.Application.label","Common")+" "+getLabel("Common.category1.label","Common"));
		var relationship_type = "";
		var req_type = parent.frames[2].document.forms[0].req_type.value;
		var classification_appl_yn = parent.frames[2].document.forms[0].classification_appl_yn.value; // added by mujafar for ML-MMOH-CRF-0762
		if(classification_appl_yn != "true")
		{ 
			relationship_type = parent.frames[2].document.forms[0].relationship_type.value;
			if(relationship_type == '' && req_type == '')
			{
				if(parent.frames[2].document.forms[0].isChckLstApplicable.value == "true")
				{
					alert(msgg);
				}
				else
				{
					alert(msg);
				}
				return;
			}
		}
		else
		{
			var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
			var msgg = msg.replace("$",getLabel("eMR.RequestorType.label","MR"));
			var relationship = parent.frames[2].document.forms[0].relationship.value;
			
			if(req_type == '')
			{
				alert(msgg);
				return;
			}
		}
		
		var fields = new Array();
		fields[0] = parent.frames[2].document.forms[0].appl_type;
		fields[1] = parent.frames[2].document.forms[0].appln_date;
		var names = new Array ();


		if(req_type != "")
		{
			if(classification_appl_yn == "true") // added by mujafar for ML-MMOH-CRF-0762
			{ 
				if(parent.frames[2].document.forms[0].req_type_status.value == "N"  )
				{
					
					if(parent.frames[2].document.forms[0].relationship.value == "" || parent.frames[2].document.forms[0].appl_type.value== "" || parent.frames[2].document.forms[0].appln_date == "" )
					{
						fields[2] = parent.frames[2].document.forms[0].relationship;	
						names = new Array (	getLabel("eMR.ApplicationType.label","MR"), getLabel("eMR.LetterDateTime.label","MR"), getLabel("Common.relationship.label","Common"));
					}
				
				}
				else
				if(parent.frames[2].document.forms[0].req_type_status.value == "P" ) 
				{
					if(parent.frames[2].document.forms[0].appl_type.value== "" || parent.frames[2].document.forms[0].appln_date.value == "" )
					names = new Array (	getLabel("eMR.ApplicationType.label","MR"), getLabel("eMR.LetterDateTime.label","MR"));
					
				}
				else
				{
					if(parent.frames[2].document.forms[0].requestor_desc.value == "" || parent.frames[2].document.forms[0].appl_type.value== "" || parent.frames[2].document.forms[0].appln_date.value == "" )
					{
						fields[2] = parent.frames[2].document.forms[0].requestor_desc;	
						names = new Array (	getLabel("eMR.ApplicationType.label","MR"), getLabel("eMR.LetterDateTime.label","MR"), getLabel("Common.Requestor.label","Common"));
					}
					
				}
				
			}
			else
			{
				fields[2] = parent.frames[2].document.forms[0].requestor_desc;
				names = new Array (	getLabel("eMR.ApplicationType.label","MR"), getLabel("eMR.LetterDateTime.label","MR"), getLabel("Common.Requestor.label","Common"));
			}	
			
			
		}
		else if(relationship_type == "4")
		{
			fields[2] = parent.frames[2].document.forms[0].relationship;
			names = new Array (	getLabel("eMR.ApplicationType.label","MR"), getLabel("eMR.LetterDateTime.label","MR"), getLabel("Common.relationship.label","Common"));
		}
		else
			names = new Array (	getLabel("eMR.ApplicationType.label","MR"), getLabel("eMR.LetterDateTime.label","MR"));

	

		var medrep_pay_int_mode = parent.frames[2].document.forms[0].medrep_pay_int_mode.value;
		var i = 0;
		if(medrep_pay_int_mode == "X")
		{
			if(parent.frames[2].document.forms[0].charges_appllicable.value == "Y")
			{
				
				amount = parent.frames[2].document.forms[0].amount;
				recp_no = parent.frames[2].document.forms[0].recp_no;
				recp_dat = parent.frames[2].document.forms[0].recp_dat;
	
				if(amount != "" || recp_no != "" || recp_dat != "")
				{
					
					if(parent.frames[2].document.forms[0].amount.value == "" && !amount.disabled)
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].amount;
						displayNames[i] =getLabel("Common.amount.label","Common");
						i++;
					}
	
					if(parent.frames[2].document.forms[0].recp_no.value == "" && !recp_no.disabled)
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].recp_no;
						displayNames[i] =getLabel("Common.receiptno.label","Common");
						i++;
					}
	
					if(parent.frames[2].document.forms[0].recp_dat.value == "" && !recp_dat.disabled)
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].recp_dat;
						displayNames[i] =getLabel("Common.receiptdate.label","Common");
						i++;
					}
				}
			}
	
			if(parent.frames[2].document.forms[0].additional_charges.value == "Y")
			{
				if(parent.frames[2].document.forms[0].add_amount.value != "" || parent.frames[2].document.forms[0].add_recp_no.value != "" || parent.frames[2].document.forms[0].add_recp_dat.value != "")
				{
					if(parent.frames[2].document.forms[0].add_amount.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].add_amount;
						displayNames[i] =getLabel("eMR.AdditionalAmount.label","MR");
						i++;
					}
	
					if(parent.frames[2].document.forms[0].add_recp_no.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].add_recp_no;
						displayNames[i] =getLabel("eMR.AdditionalReceiptNo.label","MR");
						i++;
					}
	
					if(parent.frames[2].document.forms[0].add_recp_dat.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].add_recp_dat;
						displayNames[i] =getLabel("eMR.AdditionalReceiptDate.label","MR");
						i++;
					}
				}
			}
		}
		else if(medrep_pay_int_mode == "B")
		{
			if(parent.frames[2].document.forms[0].charges_appllicable.value == "Y" && parent.frames[2].document.forms[0].amount.value == "")
			{
				mandatoryFields[i] =parent.frames[2].document.forms[0].amount;
				displayNames[i] =getLabel("Common.amount.label","Common");
				i++;
			
			}
	
			if(parent.frames[2].document.forms[0].additional_charges.value == "Y" && parent.frames[2].document.forms[0].add_amount.value == "")
			{
				mandatoryFields[i] =parent.frames[2].document.forms[0].add_amount;
				displayNames[i] =getLabel("eMR.AdditionalAmount.label","MR");
				i++;
			}
		}
	
		console.log("Inside MedRecRequestButton JS 326 ");
		mandatoryFields[i] =parent.frames[2].document.forms[0].appl_type;
		displayNames[i] =getLabel("eMR.ApplicationType.label","MR");
		i++;
console.log(mandatoryFields);
for (var j = 0; j < mandatoryFields.length; j++) {
    console.log('Field ' + (j + 1) + ':', mandatoryFields[j].value);
}


		if(checkMandatory( fields, names)) 
		{
			if(checkMandatory( mandatoryFields, displayNames)) 
			{
				if(parent.frames[2].document.forms[0].requestor_desc.value == '')
					parent.frames[2].document.forms[0].Requestor_Code.value = '';

				selectIndicator(parent.frames[2].document.forms[0].Requestor_Code.value);

				for(var m=0; m<parent.frames[2].document.forms[0].length;m++)
				{
					parent.frames[2].document.forms[0].elements[m].disabled = false;
				}
			}
		}
	}
	else if(call_function == "MEDICAL_REPORT_STATUS")
	{

		var medrep_pay_int_mode = parent.frames[2].document.forms[0].medrep_pay_int_mode.value;
		var i = 0;

		if(medrep_pay_int_mode == "X")
		{
			if(parent.frames[2].document.forms[0].charges_appllicable.value == "Y")
			{
				
				amount = parent.frames[2].document.forms[0].amount.value;
				recp_no = parent.frames[2].document.forms[0].recp_no.value;
				recp_dat = parent.frames[2].document.forms[0].recp_dat.value;
	
				if(amount != "" || recp_no != "" || recp_dat != "")
				{
					if(parent.frames[2].document.forms[0].amount.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].amount;
						displayNames[i] =getLabel("Common.amount.label","Common");
						i++;
					}
	
					if(parent.frames[2].document.forms[0].recp_no.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].recp_no;
						displayNames[i] =getLabel("Common.receiptno.label","Common");
						i++;
					}
	
					if(parent.frames[2].document.forms[0].recp_dat.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].recp_dat;
						displayNames[i] =getLabel("Common.receiptdate.label","Common");
						i++;
					}
				}
			}
	
			if(parent.frames[2].document.forms[0].additional_charges.value == "Y")
			{
				if(parent.frames[2].document.forms[0].add_amount.value != "" || parent.frames[2].document.forms[0].add_recp_no.value != "" || parent.frames[2].document.forms[0].add_recp_dat.value != "")
				{
					if(parent.frames[2].document.forms[0].add_amount.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].add_amount;
						displayNames[i] =getLabel("eMR.AdditionalAmount.label","MR");
						i++;
					}
	
					if(parent.frames[2].document.forms[0].add_recp_no.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].add_recp_no;
						displayNames[i] =getLabel("eMR.AdditionalReceiptNo.label","MR");
						i++;
					}
	
					if(parent.frames[2].document.forms[0].add_recp_dat.value == "")
					{
						mandatoryFields[i] =parent.frames[2].document.forms[0].add_recp_dat;
						displayNames[i] =getLabel("eMR.AdditionalReceiptDate.label","MR");
						i++;
					}
				}
			}
		}
		else if(medrep_pay_int_mode == "B")
		{
			if(parent.frames[2].document.forms[0].charges_appllicable.value == "Y" && parent.frames[2].document.forms[0].amount.value == "")
			{
				mandatoryFields[i] =parent.frames[2].document.forms[0].amount;
				displayNames[i] =getLabel("Common.amount.label","Common");
				i++;
			}
	
			if(parent.frames[2].document.forms[0].additional_charges.value == "Y" && parent.frames[2].document.forms[0].add_amount.value == "")
			{
				mandatoryFields[i] =parent.frames[2].document.forms[0].add_amount;
				displayNames[i] =getLabel("eMR.AdditionalAmount.label","MR");
				i++;
			}
		}

		mandatoryFields[i] =parent.frames[2].document.forms[0].appl_type;
		displayNames[i] =getLabel("eMR.ApplicationType.label","MR");
		i++;
		
		/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
		var isIncompReqCancelApplicable = parent.frames[2].document.forms[0].isIncompReqCancelApplicable.value;
		if(isIncompReqCancelApplicable == "true"){
			if(parent.frames[2].document.forms[0].cancel_reason_img.style.visibility == "visible"){
				mandatoryFields[i] =parent.frames[2].document.forms[0].cancel_reason;
				displayNames[i] =getLabel("Common.ReasonforCancellation.label","Common");
				i++;
			}
		}/*End*/

		/*Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708*/
		if(parent.frames[2].document.forms[0].isChckLstApplicable.value == "true"){
			if(parent.frames[2].document.forms[0].appl_mode_img.style.visibility == "visible"){
				mandatoryFields[i] =parent.frames[2].document.forms[0].application_mode;
				displayNames[i] =getLabel("Common.ApplicationMode.label","Common");
				i++;
			}
		
			if(parent.frames[2].document.forms[0].collec_mode_img.style.visibility == "visible"){
				mandatoryFields[i] =parent.frames[2].document.forms[0].collection_mode;
				displayNames[i] =getLabel("Common.CollectionMode.label","Common");
				i++;
			}
		
			if(parent.frames[2].document.forms[0].notifi_mode_img.style.visibility == "visible"){
				mandatoryFields[i] = parent.frames[2].document.forms[0].notification_mode;
				displayNames[i] =getLabel("Common.NotificationMode.label","Common");
				i++;
			}
		}/*ML-MMOH-CRF-0708 End*/
		/*Added By Dharma omn 02nd Dec 2019 against ML-MMOH-CRF-1454 Start*/
	
		if(isSpecialtyDefaultApp=="true" && parent.frames[2].document.forms[0].DeptImg.style.visibility == "visible"){
			mandatoryFields[i] =parent.frames[2].document.forms[0].dept_spl;
			displayNames[i] =getLabel("eMR.DepartmentSpecialty.label","MR");
			i++;
		}
		/*Added By Dharma omn 02nd Dec 2019 against ML-MMOH-CRF-1454 End*/
		var fields = new Array();
		fields[0] = parent.frames[2].document.forms[0].appl_status;
		if(parent.frames[2].document.getElementById("collectImg").style.visibility == "visible")
		{  
			// below if added by mujafar for ML-MMOH-CRF-0704 START
			if(parent.frames[2].document.forms[0].isMedicalReportDurationAppl.value == "true" && parent.frames[2].document.forms[0].appl_status.value == '2')
				parent.frames[2].document.forms[0].appl_comp_dat.value=parent.frames[2].document.forms[0].appln_col_date.value;
				 	
			fields[1] = parent.frames[2].document.forms[0].appl_comp_dat;
			fields[2] = parent.frames[2].document.forms[0].collect_date;
			 // two lines added by mujafar for ML-MMOH-CRF-0704
			var names = new Array (	getLabel("eMR.ApplicationStatus.label","MR"),getLabel("eMR.ApplicationCompletionDates.label","MR"), getLabel("eMR.CollectDate.label","MR"));
			
			//ML-MMOH-CRF-0704 END
		}
		else
		{
			var names = new Array (	getLabel("eMR.ApplicationStatus.label","MR"));
		}

		if(checkMandatory( fields, names)) 
		{
			if(checkMandatory( mandatoryFields, displayNames)) 
			{
				var result = true;
				/*Added By Dharma on Nov 23rd 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
				var appl_status = parent.frames[2].document.forms[0].appl_status.value;
				
				if(appl_status == "2"){
					if(parent.frames[2].document.forms[0].classification_appl_yn.value=="true") // added by mujafar for ML-MMOH-CRF-0762
					{
					 
					 
					 var retVal = await parent.frames[2].document.forms[0].ret_val1.value;
					var ret_val=retVal.split('~');
					if(retVal=='' ||  retVal==null){
						alert(getMessage("CHECK_LIST_INCOMPLETE","MR"));
						result = false;
					}else  {
						
						var count = parent.frames[2].document.forms[0].count.value;
						var temp="Y";
						
						for(var i=0;i<count;i++)
						{
							if(ret_val[i]=='N')
							{
							temp="N";break;
							}
							
						}
						
						if(temp == "N")
						{
						alert(getMessage("CHECK_LIST_INCOMPLETE","MR"));
						result = false;
						}
						
						
						
					}
					 
					 
					 
					 
					 
					}
					else
					{
					var retVal = await parent.frames[2].document.forms[0].ret_val.value;
					var ret_val=retVal.split('~');
					if(retVal=='' ||  retVal==null){
						alert(getMessage("CHECK_LIST_INCOMPLETE","MR"));
						result = false;
					}else if(ret_val[0]=='N'||ret_val[1]=='N'||ret_val[2]=='N'||ret_val[3]=='N'||ret_val[4]=='N'||ret_val[5]=='N') {
						alert(getMessage("CHECK_LIST_INCOMPLETE","MR"));
						result = false;
					} // added by mujafar for ML-MMOH-CRF-0762 end
						
						
						
					}
				}
				/*Added By Dharma on Nov 23rd 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/	
				//if(medrep_pay_int_mode == "B" && appl_status == "2")
				if(medrep_pay_int_mode == "B" && appl_status == "2" && result == true) {//Modified By Dharma on Nov 23rd 2015 against ML-MMOH-CRF-0391 [IN:057157]
					if(parent.frames[2].document.forms[0].charges_appllicable.value == "Y" )
					{
						if(parent.frames[2].document.forms[0].recp_no.value == "")
						{
							alert(getMessage("PAYMENT_NOT_COMPLETE","MR"));
							result = false;
						}
						else if(parent.frames[2].document.forms[0].recp_dat.value == "")
						{
							alert(getMessage("PAYMENT_NOT_COMPLETE","MR"));
							result = false;
						}
					}
					if(parent.frames[2].document.forms[0].additional_charges.value == "Y" )
					{
						if(parent.frames[2].document.forms[0].add_recp_no.value == "")
						{
							alert(getMessage("PAYMENT_NOT_COMPLETE","MR"));
							result = false;
						}
						else if(parent.frames[2].document.forms[0].add_recp_dat.value == "")
						{
							alert(getMessage("PAYMENT_NOT_COMPLETE","MR"));
							result = false;
						}
					}
				}		
	
				if(result == true)
				{
					for(var n=0; n<parent.frames[2].document.forms[0].length;n++)
					{
						parent.frames[2].document.forms[0].elements[n].disabled = false;
					}
					parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
					parent.frames[2].document.MedicalRecordReqForm.submit();
				}
			}
		}
	}
	else if(call_function == "FORWARD_MEDICAL_REPORT" || call_function == "REJECTED_BY_PRACT_TO_MRD" || call_function == "REQUEST_RETURNED")
	{ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	   /*Below line added for this CRF ML-MMOH-CRF-0712*/
		/*Added By Dharma omn 05th Dec 2019 against ML-MMOH-CRF-1454 Start*/
		if(call_function == "FORWARD_MEDICAL_REPORT" && isSpecialtyDefaultApp=="true"){
			if(parent.frames[2].document.forms[0].dept_spl!=null){
				parent.frames[2].document.forms[0].dept_spl.disabled = false;
			}
		}
		/*Added By Dharma omn 05th Dec 2019 against ML-MMOH-CRF-1454 End*/ 
		
		
	   if(((call_function == "FORWARD_MEDICAL_REPORT" || call_function == "REJECTED_BY_PRACT_TO_MRD" ) && (parent.frames[2].document.forms[0].isMedicalReportRequest && parent.frames[2].document.forms[0].isMedicalReportRequest.value=="true") && (parent.frames[2].document.forms[0].cancel_medical_report && parent.frames[2].document.forms[0].cancel_medical_report.checked==true)))
	   { // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	    
		var fields = new Array();
		fields[0] = parent.frames[2].document.forms[0].cancel_medical_rep_reason;        	
		var names = new Array (getLabel("Common.ReasonforCancellation.label","Common"));
		  if(checkMandatory(fields, names)) {
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		  }	   
	   }else
	   {
	  
		if(parent.frames[2].document.MedicalRecordReqForm.isMedicalTeamApplicable.value == 'true' && (parent.frames[2].document.MedicalRecordReqForm.call_function.value == "FORWARD_MEDICAL_REPORT" || parent.frames[2].document.MedicalRecordReqForm.call_function.value == "REJECTED_BY_PRACT_TO_MRD"))
		{ // added by mujafar for ML-MMOH-CRF-0716
    // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			var fields = new Array();
			var names = ""; // added by mujafar for ML-MMOH-CRF-1279
			fields[0] = parent.frames[2].document.forms[0].rep_type;
			fields[1] = parent.frames[2].document.forms[0].dept_spl;
			if(parent.frames[2].document.MedicalRecordReqForm.fwd_hod_desc.value =="")
			fields[2] = parent.frames[2].document.forms[0].medical_team_val;
			else
			fields[2] = parent.frames[2].document.forms[0].fwd_hod_desc;	
			
      // if-else condition added by mujafar for ML-MMOH-CRF-1279
			if(parent.frames[2].document.forms[0].isAcceptRequestByPractAppl.value=="false")
			{
			if(parent.frames[2].document.MedicalRecordReqForm.inform_hod_desc.value =="")
			fields[3] = parent.frames[2].document.forms[0].medical_team_val1;
			else
			fields[3] = parent.frames[2].document.forms[0].inform_hod_desc;
		
			
			names = new Array (getLabel("Common.reporttype.label","Common"),getLabel("eMR.DepartmentSpecialty.label","MR"),getLabel("eMR.ForwardedHOD.label","MR"),getLabel("eMR.InformToHOD.label","MR"));
		
			}
			else
			{ // added by mujafar for ML-MMOH-CRF-1279
				names = new Array (getLabel("Common.reporttype.label","Common"),getLabel("eMR.DepartmentSpecialty.label","MR"),getLabel("eMR.ForwardedHOD.label","MR"));
				
			}
				
		
		
		
		if(checkMandatory( fields, names)) 
			{
				parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
				parent.frames[2].document.MedicalRecordReqForm.submit();
			}
		
		
		}
		else
		{ 
			if(parent.frames[2].document.MedicalRecordReqForm.isMedicalTeamApplicable.value == 'true' && parent.frames[2].document.MedicalRecordReqForm.call_function.value == "REQUEST_RETURNED")
			{
				var fields = new Array();
				var names = "";
			fields[0] = parent.frames[2].document.forms[0].rep_type;
			fields[1] = parent.frames[2].document.forms[0].dept_spl;
			
			if(parent.frames[2].document.MedicalRecordReqForm.fwd_hod_desc.value =="")
			fields[2] = parent.frames[2].document.forms[0].medical_team_val;
			else
			fields[2] = parent.frames[2].document.forms[0].fwd_hod_desc;

			if(parent.frames[2].document.forms[0].isAcceptRequestByPractAppl.value=="false")
			{ // added by mujafar for ML-MMOH-CRF-1279
			
			if(parent.frames[2].document.MedicalRecordReqForm.inform_hod_desc.value =="")
			fields[3] = parent.frames[2].document.forms[0].medical_team_val1;
			else
			fields[3] = parent.frames[2].document.forms[0].inform_hod_desc;
			names = new Array (getLabel("Common.reporttype.label","Common"),getLabel("eMR.DepartmentSpecialty.label","MR"),getLabel("eMR.ForwardedHOD.label","MR"),getLabel("eMR.InformToHOD.label","MR"));	
			}
			else
			{ // added by mujafar for ML-MMOH-CRF-1279
			names = new Array (getLabel("Common.reporttype.label","Common"),getLabel("eMR.DepartmentSpecialty.label","MR"),getLabel("eMR.ForwardedHOD.label","MR"));	
				
			}
			
				
			if(checkMandatory( fields, names)) 
			{ parent.frames[2].document.forms[0].remarks.disabled=false; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
				parent.frames[2].document.MedicalRecordReqForm.submit();
			}
				
			}
			else
			{ 
			var fields = new Array();
			fields[0] = parent.frames[2].document.forms[0].rep_type;
			fields[1] = parent.frames[2].document.forms[0].dept_spl;
			fields[2] = parent.frames[2].document.forms[0].fwd_hod_desc;
			fields[3] = parent.frames[2].document.forms[0].inform_hod_desc;		
			var names = new Array (getLabel("Common.reporttype.label","Common"),getLabel("eMR.DepartmentSpecialty.label","MR"),getLabel("eMR.ForwardedHOD.label","MR"),getLabel("eMR.InformToHOD.label","MR"));
			if(checkMandatory( fields, names)) 
			{
				parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
				parent.frames[2].document.MedicalRecordReqForm.submit();
			}
			
		}
		}
	   }
		
		//End this CRF ML-MMOH-CRF-0712
	
	}
	/*Added By Dharma on Dec 1st 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/	
	else if(call_function == "FORWARD_TO_HOD" || call_function == "REJECTED_BY_PRACT_TO_HOD" )	{
	// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
			
		 var fields	= new Array(parent.frames[2].document.forms[0].remarks);
				var names	= new Array (getLabel("Common.remarks.label","Common"));
				
				var status=parent.frames[2].document.forms[0].status.value;
              //Below line modified for this CRF ML-MMOH-CRF-0712 
			if((status=='R' && parent.frames[2].document.forms[0].cancel_medical_report && !parent.frames[2].document.forms[0].cancel_medical_report.checked==true) || (status=='R' && !parent.frames[2].document.forms[0].cancel_medical_report))
			{	 
				
				if(parent.frames[2].document.forms[0].isRejectRequestApplicable.value=="true") // added by mujafar for ML-MMOH-CRF-0713
				{   
					var fields	= ""; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					var names = "";
					if(parent.frames[2].document.forms[0].isAcceptRequestByPractAppl.value=="true")
					{
					fields = new Array(parent.frames[2].document.forms[0].reject_medical_rep_reason);
					names = new Array (getLabel("Common.ReasonforRejection.label","Common"));	
					
					}
					else
					{
					fields = new Array(parent.frames[2].document.forms[0].remarks,parent.frames[2].document.forms[0].reject_medical_rep_reason);
					names = new Array (getLabel("Common.remarks.label","Common"),getLabel("Common.ReasonforRejection.label","Common"));
					}
					if(checkMandatory( fields, names)) {
					for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
					{
						parent.frames[2].document.forms[0].elements[i].disabled = false;
					}
					
					
					parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
					parent.frames[2].document.MedicalRecordReqForm.submit();
						
					}
				}
				else
				{
				if(checkMandatory( fields, names)) {
					for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
					{
						parent.frames[2].document.forms[0].elements[i].disabled = false;
					}
					parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
					parent.frames[2].document.MedicalRecordReqForm.submit();
					
				} 
				}
			 } 
			 
			 else 
			 { 
			 
				//Below line added for this CRF ML-MMOH-CRF-0712 
					  
				if(((call_function == "FORWARD_TO_HOD" || call_function == "REJECTED_BY_PRACT_TO_HOD") && (parent.frames[2].document.forms[0].isMedicalReportRequest && parent.frames[2].document.forms[0].isMedicalReportRequest.value=="true") && (parent.frames[2].document.forms[0].cancel_medical_report && parent.frames[2].document.forms[0].cancel_medical_report.checked==true)))
				{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					var fields = new Array();
					fields[0] = parent.frames[2].document.forms[0].cancel_medical_rep_reason;        	
					var names = new Array (getLabel("Common.ReasonforCancellation.label","Common"));
					  if(checkMandatory(fields, names)) {
						  
						  
						 
						  
						  parent.frames[2].document.forms[0].status.disabled = false; 
						  parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
						  parent.frames[2].document.MedicalRecordReqForm.submit();
					  }	   
				}
				else
				{
				 
					if(parent.frames[2].document.MedicalRecordReqForm.isMedicalTeamApplicable.value == 'true' && (parent.frames[2].document.MedicalRecordReqForm.call_function.value == "FORWARD_TO_HOD" || parent.frames[2].document.MedicalRecordReqForm.call_function.value == "REJECTED_BY_PRACT_TO_HOD" ))
					{ // added by mujafar for ML-MMOH-CRF-0716
					// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
						
						/*Modified By Dharma on 18th Mar 2020 against ML-MMOH-CRF-1473 Start*/
						/*var fields = new Array();
						fields[0] = parent.frames[2].document.forms[0].status;
						if(parent.frames[2].document.MedicalRecordReqForm.ack_hod_co_ord_desc.value =="")
							fields[1] = parent.frames[2].document.forms[0].medical_team_val_ack;
						else
							fields[1] = parent.frames[2].document.forms[0].ack_hod_co_ord_desc;
							fields[2] = parent.frames[2].document.forms[0].inform_to_pract_desc;
						var names	= new Array (getLabel("Common.status.label","Common"),getLabel("eMR.AcknowledgedByHODCoordinator.label","MR"),getLabel("eMR.InformToPractitioner.label","MR"));	*/
						
						var fields = new Array(parent.frames[2].document.forms[0].status);						
						var names	= new Array (getLabel("Common.status.label","Common"));
						/*Modified By Dharma on 18th Mar 2020 against ML-MMOH-CRF-1473 End*/
						
						if(checkMandatory( fields, names)) {
						parent.frames[2].document.forms[0].remarks.disabled=false; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					  for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
						{
							parent.frames[2].document.forms[0].elements[i].disabled = false;
						}
						parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
						parent.frames[2].document.MedicalRecordReqForm.submit();
						
					}
						
					}
					else
					{
					var fields	= new Array(parent.frames[2].document.forms[0].status,parent.frames[2].document.forms[0].ack_hod_co_ord_desc,parent.frames[2].document.forms[0].inform_to_pract_desc);
					var names	= new Array (getLabel("Common.status.label","Common"),getLabel("eMR.AcknowledgedByHODCoordinator.label","MR"),getLabel("eMR.InformToPractitioner.label","MR"));

					if(checkMandatory( fields, names)) 
					{
					  for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
						{
							parent.frames[2].document.forms[0].elements[i].disabled = false;
						}
						parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
						parent.frames[2].document.MedicalRecordReqForm.submit();
						
					}
					}
				}
				//End this CRF ML-MMOH-CRF-0712
			}	
	}else if(call_function == "REQUEST_ACCEPTED")	{
		
			parent.frames[2].document.forms[0].remarks.disabled=false; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
	}
	/*Added By Dharma on Dec 1st 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/	
	else if(call_function == "PREPARE_MEDICAL_REPORT" || call_function == "ACCEPTED_BY_PRACTITIONER" )
	{

		// if Condition check added by kishore on 3/23/2005
		if(parent.frames[2].document.forms[0].called_from.value == 'CA')
		{
		  // if else block added by mujafar for ML-MMOH-CRF-0963
			if(((parent.frames[2].document.forms[0].isMedicalReportRequest && parent.frames[2].document.forms[0].isMedicalReportRequest.value=="true") && (parent.frames[2].document.forms[0].cancel_medical_report && parent.frames[2].document.forms[0].cancel_medical_report.checked==true)))
			{
				var fields = new Array();
				fields[0] = parent.frames[2].document.forms[0].cancel_medical_rep_reason;        	
				var names = new Array (getLabel("Common.ReasonforCancellation.label","Common"));
				if(checkMandatory(fields, names)) {						 
					parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
					parent.frames[2].document.MedicalRecordReqForm.submit();
				}	   
			}			
			else
			{ 
					if(parent.frames[2].document.forms[0].isAcceptRequestByPractAppl.value=="false"){
					// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
						if(parent.frames[2].document.forms[0].accession_num.value !='')
						{     	
							/*Modified By Dharma on Jan 18th 2016 against ML-MMOH-CRF-0390 [IN:057155] Start*/
							/*var fields	= new Array(parent.frames[2].document.forms[0].prepare_date,parent.frames[2].document.forms[0].prep_pract_desc);
							var names	= new Array (getLabel("Common.PrepareDate.label","Common"),getLabel("eMR.PreparedbyPractitioner.label","MR"));*/
							
							
							
							if(parent.frames[2].document.forms[0].isAcceptRequestByPractAppl.value == "true")
							{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
								
							if(parent.frames[2].document.forms[0].prac_status.value == 'AP')
							{
							var fields	= new Array(parent.frames[2].document.forms[0].fwd_pract_desc,parent.frames[2].document.forms[0].prepare_date);
							var names	= new Array (getLabel("eMR.ForwardedPractitioner.label","MR"),getLabel("Common.PrepareDate.label","Common"));
							}
							else if(parent.frames[2].document.forms[0].prac_status.value == 'RM')
							{
							var fields	= new Array(parent.frames[2].document.forms[0].fwd_pract_desc,parent.frames[2].document.forms[0].reject_medical_rep_reason_1);
							var names	= new Array (getLabel("eMR.ForwardedPractitioner.label","MR"),getLabel("Common.ReasonforRejection.label","Common"));
								
							}
							
							else 
							{
							var fields	= new Array(parent.frames[2].document.forms[0].fwd_pract_desc,parent.frames[2].document.forms[0].reject_medical_rep_reason_1);
							var names	= new Array (getLabel("eMR.ForwardedPractitioner.label","MR"),getLabel("eMR.ReasonforReturn.label","MR"));
								
							}
							
							
							}
							else
							{
							var fields	= new Array(parent.frames[2].document.forms[0].fwd_pract_desc,parent.frames[2].document.forms[0].prepare_date,parent.frames[2].document.forms[0].prep_pract_desc);
							var names	= new Array (getLabel("eMR.ForwardedPractitioner.label","MR"),getLabel("Common.PrepareDate.label","Common"),getLabel("eMR.PreparedbyPractitioner.label","MR"));
							
							}
							
							/*Modified By Dharma on Jan 18th 2016 against ML-MMOH-CRF-0390 [IN:057155] End*/
							if(checkMandatory( fields, names)) 
							{	parent.frames[2].document.forms[0].remarks.disabled=false; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
								for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
								{
									parent.frames[2].document.forms[0].elements[i].disabled = false;
								}
								getEventStatus();
							}
						}
					else
					{
						alert(getMessage('NOTE_DOESNOT_EXIST_CANT_PROCEED',"MR"));
						return false;
					}
				}
				else
				{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					if( parent.frames[2].document.forms[0].temp_pract.value == "SAVEASDRAFT" && parent.frames[2].document.forms[0].prac_status.value == 'AP' )
					{			
						var fields	= new Array(parent.frames[2].document.forms[0].fwd_pract_desc,parent.frames[2].document.forms[0].prepare_date);
						var names	= new Array (getLabel("eMR.ForwardedPractitioner.label","MR"),getLabel("Common.PrepareDate.label","Common"));
												
						if(checkMandatory( fields, names)) 
						{	parent.frames[2].document.forms[0].remarks.disabled=false;
							for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
							{
								parent.frames[2].document.forms[0].elements[i].disabled = false;
							}
							parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
							parent.frames[2].document.MedicalRecordReqForm.submit();
						}
						
					}				
					else if(parent.frames[2].document.forms[0].accession_num.value != "" && parent.frames[2].document.forms[0].temp_pract.value == "" && parent.frames[2].document.forms[0].prac_status.value == 'AP' )
					{
						var fields	= new Array(parent.frames[2].document.forms[0].fwd_pract_desc,parent.frames[2].document.forms[0].prepare_date);
						var names	= new Array (getLabel("eMR.ForwardedPractitioner.label","MR"),getLabel("Common.PrepareDate.label","Common"));
												
						if(checkMandatory( fields, names)) 
						{	parent.frames[2].document.forms[0].remarks.disabled=false;
							for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
							{
								parent.frames[2].document.forms[0].elements[i].disabled = false;
							}
							parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
							parent.frames[2].document.MedicalRecordReqForm.submit();
						}					
					}				
					else if(parent.frames[2].document.forms[0].temp_pract.value == "" && parent.frames[2].document.forms[0].prac_status.value != 'AP' )
					{
						if(parent.frames[2].document.forms[0].prac_status.value == 'RM')
						{
							var fields	= new Array(parent.frames[2].document.forms[0].fwd_pract_desc,parent.frames[2].document.forms[0].reject_medical_rep_reason_1);
							var names	= new Array (getLabel("eMR.ForwardedPractitioner.label","MR"),getLabel("Common.ReasonforRejection.label","Common"));
								
						}
						else
						{
							var fields	= new Array(parent.frames[2].document.forms[0].fwd_pract_desc,parent.frames[2].document.forms[0].reject_medical_rep_reason_1);
							var names	= new Array (getLabel("eMR.ForwardedPractitioner.label","MR"),getLabel("eMR.ReasonforReturn.label","MR"));
						}
													
						if(checkMandatory( fields, names)) 
						{	parent.frames[2].document.forms[0].remarks.disabled=false;
							for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
							{
								parent.frames[2].document.forms[0].elements[i].disabled = false;
							}
							parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
							parent.frames[2].document.MedicalRecordReqForm.submit();
						}
						
					}
					else
					{
						alert(getMessage('NOTE_DOESNOT_EXIST_CANT_PROCEED',"MR"));
						return false;
					}
				}
			} // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 end
		}
		else
		{
			if(parent.frames[2].document.forms[0].accession_num.value !='' && (parent.frames[2].document.forms[0].event_status.value=='4' || parent.frames[2].document.forms[0].event_status.value=='5'))
			{ 
				if(parent.frames[2].document.forms[0].isAcceptRequestByPractAppl.value == "true")
				{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					alert(getMessage('NOTE_DOESNOT_EXIST',"MR"));
					return false;
				}
				else{
					var fields	= new Array(parent.frames[2].document.forms[0].prepare_date,parent.frames[2].document.forms[0].prep_pract_desc);
					var names	= new Array (getLabel("Common.PrepareDate.label","Common"),getLabel("eMR.PreparedbyPractitioner.label","MR"));
				}
				
				if(checkMandatory( fields, names)) 
				{  
					parent.frames[2].document.forms[0].remarks.disabled=false; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
					{
						parent.frames[2].document.forms[0].elements[i].disabled = false;
					}
					parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
					parent.frames[2].document.MedicalRecordReqForm.submit();
				}
			}
			else
			{
				alert(getMessage('NOTE_DOESNOT_EXIST',"MR"));
				return false;
			}
		}
	}
	else if(call_function == "RECEIVE_MEDICAL_REPORT")
	{	// ADDED BY MUJAFAR FOR ML-MMOH-CRF-0714 START
		var fields;	//= new Array(parent.frames[2].document.forms[0].receive_date);
		var names;	//= new Array (getLabel("Common.ReceivedDate.label","Common"));
		var isRejectReportApplicable = parent.frames[2].document.forms[0].isRejectReportApplicable.value;
	
		if(isRejectReportApplicable == "true" )
		{ 
			if(parent.frames[2].document.forms[0].status.value == "A")
			{
				  fields	= new Array(parent.frames[2].document.forms[0].receive_date);
				  //names	= new Array (getLabel("Common.ReceivedDate.label","Common"));
				  names	= new Array (getLabel("eMR.ReportCompletionDate.label","MR")); //Modified by Dharma on 1st June 2020 against ML-MMOH-CRF-1314.1
			}
			else
			if(parent.frames[2].document.forms[0].status.value == "R")
			{
				fields	= new Array(parent.frames[2].document.forms[0].reject_medical_rep_reason_1);
				names	= new Array (getLabel("Common.ReasonforRejection.label","Common"));
				parent.frames[2].document.forms[0].receive_date.value = parent.frames[2].document.forms[0].sysdate.value; 
			}
		}
		else
		{
		fields	= new Array(parent.frames[2].document.forms[0].receive_date);
		names	= new Array (getLabel("Common.ReceivedDate.label","Common"));
		}
		// END	
		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
			{
				parent.frames[2].document.forms[0].elements[i].disabled = false;
			}
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
	}
	else if(call_function == "DELIVER_MEDICAL_REPORT")
	{
		/*Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708*/
		if(parent.frames[2].document.forms[0].isChckLstApplicable.value == "true"){
			/*Modified By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
			/*var fields	= new Array(parent.frames[2].document.forms[0].applic_mode, 
							parent.frames[2].document.forms[0].collectn_mode, parent.frames[2].document.forms[0].delivered_date,
							parent.frames[2].document.forms[0].notific_mode);
			var names	= new Array (getLabel("Common.ApplicationMode.label","Common"),
							getLabel("Common.CollectionMode.label","Common"),
							getLabel("eMR.DeliveredDate.label","MR"),
							getLabel("Common.NotificationMode.label","Common"));*/
			var fields	= new Array(parent.frames[2].document.forms[0].Despatch_mode);
			var names	= new Array (getLabel("eMR.DeliveryMode.label","MR"));
			var deliveryMode	= parent.frames[2].document.forms[0].Despatch_mode.value;
			if(deliveryMode=="P"){
				fields.push(parent.frames[2].document.forms[0].delivered_date);
				names.push(getLabel("eMR.DeliveredDate.label","MR"));
			}else if(deliveryMode=="O"){
				fields.push(parent.frames[2].document.forms[0].postedDt,parent.frames[2].document.forms[0].file_no);
				names.push(getLabel("eMR.DatePosted.label","MR"),getLabel("eMR.PostageNo.label","MR"));
			}
			/*Modified By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/
				
		}else{
			var fields	= new Array(parent.frames[2].document.forms[0].delivered_date);
			var names	= new Array (getLabel("eMR.DeliveredDate.label","MR"));
		}
			
		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
			{
				parent.frames[2].document.forms[0].elements[i].disabled = false;
			}
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
	}
	else if(call_function == "REVISE_MEDICAL_REPORT")
	{
		var fields = new Array();
		fields[0] = parent.frames[2].document.forms[0].revised_collect_date;
		fields[1] = parent.frames[2].document.forms[0].authorised_by;
		var names = new Array (	getLabel("eMR.RevisedCollectDate.label","MR"), getLabel("Common.authorizedby.label","Common"));
		if(checkMandatory( fields, names)) 
		{
			parent.frames[2].document.forms[0].called_from.value='';
			if(parent.frames[2].document.forms[0].called_from.value=='')
			{					
				for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
				{
					parent.frames[2].document.forms[0].elements[i].disabled = false;
				}
				
				parent.frames[2].document.forms[0].action = "../../servlet/eMR.MedRecRequestServlet";
				parent.frames[2].document.MedicalRecordReqForm.submit();
			}
		}
	}

	function getEventStatus()
	{
		var accession_num	= parent.frames[2].document.forms[0].accession_num.value;
		var patientid	= parent.frames[2].document.forms[0].patientId.value;
		if(accession_num != '' && patientid != '')
		{
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eMR/jsp/MedRecRequestValidation.jsp' ><input type='hidden' name='Criteria' id='Criteria' value='populateEventStatus'><input type='hidden' name='patientId' id='patientId' value="+patientid+"><input type='hidden' name='accession_num' id='accession_num' value="+accession_num+"></form></body></html>";
			parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[3].document.dummy_form.submit();
		}
	}
	

	function selectIndicator(obj)
	{  
		var REQUESTOR_CODE = obj;
		var patientId = document.forms[0].patientId.value;
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp'><input type='hidden' name='REQUESTOR_CODE' id='REQUESTOR_CODE' value='"+REQUESTOR_CODE+"'><input type='hidden' name='patientId' id='patientId' value='"+patientId+"'><input type='hidden' name='Criteria' id='Criteria' value='MedBoardMembers'></form></body></html>";
		parent.frames[3].document.write(HTMLVal)
		parent.frames[3].document.querydept.submit();
	}


	function checkMandatory( fields, names)
	{
		var errors = "" ;
		for( var i=0; i<fields.length; i++ ) 
		{
			if(CheckVal(fields[i].value)) 
			{
			}
			else
			{
				errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(names[i]))+"\n";
			}
		}
		if ( errors.length != 0 )
		{
			alert(errors) ;
			return false ;
		}
		return true ;
	}

	function CheckVal(inString)
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
}

/*Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 Start*/
function closeWin(obj){
	parent.window.close();
}

function confirm(obj){
	if(TrimStr(document.forms[0].modifyReason.value)=="")
	{
		var msg = getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace('$',getLabel("Common.reason.label","Common")+" "+getLabel("Common.for.label","Common")+" "+getLabel("eMR.Modification.label","MR"))
		alert(msg);
		document.forms[0].modifyReason.focus();
		return false;
	}
	document.ModificationDetails.submit();
}

function validateMaxLength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","common");
		var remarks = getLabel("Common.reason.label","Common")+" "+getLabel("Common.for.label","Common")+" "+getLabel("eMR.Modification.label","MR");
		error = error.replace("$",remarks);
		error = error.replace("#","100")
		alert(error);
		obj.value=obj.value.substring(0,mlength);
	}
}
function imposeMaxLength(obj,maxlength){
	return (obj.value.length < maxlength);
}
/*End*/

