async function openCAModal()
{
	var patient_class	= document.forms[0].patient_class.value;
	var episode_id		= parent.frames[1].document.forms[0].EncounterIDS.value;
	//var episode_id="200554240001";
	episode_id = document.forms[0].encounter_id.value;
	var note_type		= parent.frames[1].document.forms[0].rep_type.value;
	var patient_id		= parent.frames[1].document.forms[0].patientId.value;
	var accession_num	= parent.frames[1].document.forms[0].accession_num.value;
	var contr_mod_accession_num	=	'MR_'+parent.frames[1].document.forms[0].request_id.value;
	var specialty_code	=	document.forms[0].specialty_code.value;
	var location_code	=	document.forms[0].location_code.value;


	var action_url		= "../../eCA/jsp/RecClinicalNotesModal.jsp?title="+encodeURIComponent(getLabel("eMR.RecordNotes.label","MR"))+"&function_id=SPCL_NOTE&event_class=MDR$&Field_Ref=parent.frames[1].document.forms[0].accession_num&note_type="+note_type+"&patient_class="+patient_class+"&encounter_id="+episode_id+"&patient_id="+patient_id+"&accession_num="+accession_num+"&appl_task_id=PRE_MEDICAL_BOARD"+"&contr_mod_accession_num="+contr_mod_accession_num+"&specialty_code="+specialty_code+"&location_code="+location_code;

	var retVal= await window.open(action_url,null,"height=450,width=790,top=120,left=0,status=no,toolbar=no,menubar=no,location=no");
	retVal.focus();
}


async function printReport()
{
	var accession_num	= parent.frames[1].document.forms[0].accession_num.value;
	if(accession_num == '')
	{
		alert(getMessage("NOTE_DOESNOT_EXIST",'MR'));
	}
	else
	{
		var retVal		= 	new String();
		var dialogTop	=	"10";
		var dialogHeight=	"32" ;
		var dialogWidth	=	"50" ;
		var	title		=	getLabel("eMR.MedicalBoard.label","MR");
		var features	=	"dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+"; status=no" ;
		var header = "";

		var patientId		=	document.forms[0].PatientId.value;
		var patient_line	=	document.forms[0].patient_line.value;
		var episode_type	=	"I";
		var request_id		=	document.forms[0].request_id.value;
		var call_function	=	document.forms[0].call_function.value;
//		var accession_num	=	document.forms[0].accession_num.value;
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

		retVal = await	window.showModalDialog("../../eMR/jsp/ViewMedicalReport.jsp?patientId="+patientId+"&request_id="+request_id+"&accession_num="+accession_num+"&episode_type="+episode_type+"&call_function="+call_function,arguments,features);
	}
}


function apply()
{
	var call_function = document.forms[0].call_function.value;
	var mandatoryFields = new Array ();
	var displayNames = new Array ();
	var patient_id = parent.frames[1].document.forms[0].patientId.value;
	if(call_function == "MEDICAL_BOARD_STATUS")
	{
		var medrep_pay_int_mode = parent.frames[1].document.forms[0].medrep_pay_int_mode.value;
		var i = 0;

		if(medrep_pay_int_mode == "X")
		{
			if(parent.frames[1].document.forms[0].charges_appllicable.value == "Y")
			{
				
				amount = parent.frames[1].document.forms[0].amount.value;
				recp_no = parent.frames[1].document.forms[0].recp_no.value;
				recp_dat = parent.frames[1].document.forms[0].recp_dat.value;

				if(amount != "" || recp_no != "" || recp_dat != "")
				{
					if(parent.frames[1].document.forms[0].amount.value == "")
					{
						mandatoryFields[i] =parent.frames[1].document.forms[0].amount;
						displayNames[i] =getLabel("Common.amount.label","Common");
						i++;
					}

					if(parent.frames[1].document.forms[0].recp_no.value == "")
					{
						mandatoryFields[i] =parent.frames[1].document.forms[0].recp_no;
						displayNames[i] =getLabel("Common.receiptno.label","Common");
						i++;
					}

					if(parent.frames[1].document.forms[0].recp_dat.value == "")
					{
						mandatoryFields[i] =parent.frames[1].document.forms[0].recp_dat;
						displayNames[i] =getLabel("Common.receiptdate.label","Common");
						i++;
					}
				}
			}

			if(parent.frames[1].document.forms[0].additional_charges.value == "Y")
			{
				if(parent.frames[1].document.forms[0].add_amount.value != "" || parent.frames[1].document.forms[0].add_recp_no.value != "" || parent.frames[1].document.forms[0].add_recp_dat.value != "")
				{
					if(parent.frames[1].document.forms[0].add_amount.value == "")
					{
						mandatoryFields[i] =parent.frames[1].document.forms[0].add_amount;
						displayNames[i] =getLabel("eMR.AdditionalAmount.label","MR");
						i++;
					}

					if(parent.frames[1].document.forms[0].add_recp_no.value == "")
					{
						mandatoryFields[i] =parent.frames[1].document.forms[0].add_recp_no;
						displayNames[i] =getLabel("eMR.AdditionalReceiptNo.label","MR");
						i++;
					}

					if(parent.frames[1].document.forms[0].add_recp_dat.value == "")
					{
						mandatoryFields[i] =parent.frames[1].document.forms[0].add_recp_dat;
						displayNames[i] =getLabel("eMR.AdditionalReceiptDate.label","MR");
						i++;
					}
				}
			}
		}
		else if(medrep_pay_int_mode == "B")
		{
			if(parent.frames[1].document.forms[0].charges_appllicable.value == "Y" && parent.frames[1].document.forms[0].amount.value == "")
			{
				mandatoryFields[i] =parent.frames[1].document.forms[0].amount;
				displayNames[i] =getLabel("Common.amount.label","Common");
				i++;
			}

			if(parent.frames[1].document.forms[0].additional_charges.value == "Y" && parent.frames[1].document.forms[0].add_amount.value == "")
			{
				mandatoryFields[i] =parent.frames[1].document.forms[0].add_amount;
				displayNames[i] =getLabel("eMR.AdditionalAmount.label","MR");
				i++;
			}
		}

		mandatoryFields[i] =parent.frames[1].document.forms[0].appl_type;
		displayNames[i] =getLabel("eMR.ApplicationType.label","MR");
		i++;

			var fields = new Array();
			fields[0] = parent.frames[1].document.forms[0].appl_status;

			if(parent.frames[1].document.getElementById("collectImg").style.visibility == "visible")
			{
				fields[1] = parent.frames[1].document.forms[0].collect_date;

	//			fields[2] = parent.frames[1].document.forms[0].pract_desc;
				var names = new Array (	getLabel("eMR.ApplicationStatus.label","MR"), getLabel("eMR.CollectDate.label","MR"));
			}
			else
			{
	//			fields[1] = parent.frames[1].document.forms[0].pract_desc;
				var names = new Array (getLabel("eMR.ApplicationStatus.label","MR"));
			}

			if(checkMandatory( fields, names)) 
			{
				if(checkMandatory( mandatoryFields, displayNames))
				{
					
					var result = true;
					var appl_status = parent.frames[1].document.forms[0].appl_status.value;
					if(medrep_pay_int_mode == "B" && appl_status == "2")
					{
						if(parent.frames[1].document.forms[0].charges_appllicable.value == "Y")
						{
							if(parent.frames[1].document.forms[0].recp_no.value == "")
							{
								alert(getMessage("PAYMENT_NOT_COMPLETE",'MR'));
								result = false;
							}
							else if(parent.frames[1].document.forms[0].recp_dat.value == "")
							{
								alert(getMessage("PAYMENT_NOT_COMPLETE",'MR'));
								result = false;
							}
						}

						if(parent.frames[1].document.forms[0].additional_charges.value == "Y" )
						{
							if(parent.frames[1].document.forms[0].add_recp_no.value == "")
							{
								alert(getMessage("PAYMENT_NOT_COMPLETE",'MR'));
								result = false;
							}
							else if(parent.frames[1].document.forms[0].add_recp_dat.value == "")
							{
								alert(getMessage("PAYMENT_NOT_COMPLETE",'MR'));
								result = false;
							}
						}
					}		
			
					if(result == true)
					{
						for(var i=0; i<parent.frames[1].document.forms[0].length;i++)
						{
							parent.frames[1].document.forms[0].elements[i].disabled = false;
						}

						parent.frames[1].document.forms[0].action = "../../servlet/eMR.MedBoardTransactionsServlet?patient_id="+patient_id;
						parent.frames[1].document.forms[0].submit();
					}
				}
			}
	}
	else if(call_function == "REVISE_MEDICAL_BOARD")
	{
		var fields = new Array();
		fields[0] = parent.frames[1].document.forms[0].revised_collect_date;
		fields[1] = parent.frames[1].document.forms[0].authorised_by;
		var names = new Array (getLabel("eMR.RevisedCollectDate.label","MR"), getLabel("Common.authorizedby.label","Common"));
		if(checkMandatory( fields, names)) 
		{
			parent.frames[1].document.forms[0].action = "../../servlet/eMR.MedRecRequestServlet";
			parent.frames[1].document.forms[0].submit();
		}
	
	}
	else if(call_function == "FORWARD_MEDICAL_BOARD")
	{
		var fields = new Array();
		fields[0] = parent.frames[1].document.forms[0].rep_type;
		fields[1] = parent.frames[1].document.forms[0].dept_spl;
		fields[2] = parent.frames[1].document.forms[0].fwd_pract_desc;
		var names = new Array (getLabel("Common.reporttype.label","Common"), getLabel("eMR.DepartmentSpecialty.label","MR"), getLabel("eMR.ForwardedPractitioner.label","MR"));
		if(checkMandatory( fields, names)) 
		{
			parent.frames[1].document.forms[0].action = "../../servlet/eMR.MedBoardTransactionsServlet";
			parent.frames[1].document.forms[0].submit();
		}
	
	}
	else if(call_function == "PREPARE_MEDICAL_BOARD")
	{
		// if Condition check added by kishore on 3/23/2005
		//getEventStatus();

		if(parent.frames[1].document.forms[0].called_from.value == 'CA')
		{
			if(parent.frames[1].document.forms[0].accession_num.value !='')
			{
				var fields	= new Array(parent.frames[1].document.forms[0].prepare_date,parent.frames[1].document.forms[0].prep_pract_desc);
				var names	= new Array (getLabel("Common.PrepareDate.label","MR"),getLabel("eMR.PreparedbyPractitioner.label","MR"));
				if(checkMandatory( fields, names)) 
				{
					for(var i=0; i<parent.frames[1].document.forms[0].length;i++)
					{
						parent.frames[1].document.forms[0].elements(i).disabled = false;
					}
					getEventStatus();

					//parent.frames[1].document.forms[0].action = "../../servlet/eMR.MedBoardTransactionsServlet";
					//parent.frames[1].document.forms[0].submit();
				}
			}
			else
			{
				alert(getMessage('NOTE_DOESNOT_EXIST','MR'));
				return false;
			}
		}
		else
		{
			if(document.forms[0].accession_num.value !='' && event_status.value=='4' || document.forms[0].event_status.value=='5')
			{
				var fields	= new Array(parent.frames[1].document.forms[0].prepare_date,parent.frames[1].document.forms[0].prep_pract_desc);
				var names	= new Array (getLabel("Common.PrepareDate.label","Common"),getLabel("eMR.PreparedbyPractitioner.label","MR"));
				if(checkMandatory( fields, names)) 
				{
					for(var i=0; i<parent.frames[1].document.forms[0].length;i++)
					{
						parent.frames[1].document.forms[0].elements(i).disabled = false;
					}

					parent.frames[1].document.forms[0].action = "../../servlet/eMR.MedBoardTransactionsServlet";
					parent.frames[1].document.forms[0].submit();
				}
			}
			else
			{
				alert(getMessage('NOTE_DOESNOT_EXIST','MR'));
				return false;
			}
		}
	}
	else if(call_function == "RECEIVE_MEDICAL_BOARD")
	{
		var fields	= new Array(parent.frames[1].document.forms[0].receive_date);
		var names	= new Array (getLabel("Common.ReceivedDate.label","Common"));
		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[1].document.forms[0].length;i++)
			{
				parent.frames[1].document.forms[0].elements(i).disabled = false;
			}
			parent.frames[1].document.forms[0].action = "../../servlet/eMR.MedBoardTransactionsServlet";
			parent.frames[1].document.forms[0].submit();
		}

	}
	else if(call_function == "DELIVER_MEDICAL_BOARD")
	{
		var fields	= new Array(parent.frames[1].document.forms[0].delivered_date);
		var names	= new Array (getLabel("eMR.DeliveredDate.label","MR"));
			
		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[1].document.forms[0].length;i++)
			{
				parent.frames[1].document.forms[0].elements(i).disabled = false;
			}
			parent.frames[1].document.forms[0].action = "../../servlet/eMR.MedBoardTransactionsServlet";
			parent.frames[1].document.forms[0].submit();
		}
	}
	else if(call_function == "MEDICAL_BOARD_FORMATION")
	{
		var cnt = parent.frames[2].document.forms[0].count.value;
		var chk_cnt = 0
		var pract_cnt = 0
		var role_cnt = 0
		var internal_cnt = 0;

		for(var i=0;i<cnt;i++)
		{
			if(eval("parent.frames[2].document.forms[0].check_"+i+".checked"))
			{
				chk_cnt++;
				var pract_value = parent.frames[2].document.forms[0]["pract_" + i].value;
				if(pract_value=="Practitioner")
				{
					pract_cnt++;
				}
			
				role_value = eval("parent.frames[2].document.forms[0].role_"+i+".value")
				if(role_value =="Chief")
				{
					role_cnt++;
				}
				
				user_type_value =eval("parent.frames[2].document.forms[0].user_type_"+i+".value");
				if(user_type_value == "Internal" && pract_value == "Practitioner")
				{
					internal_cnt++;
				}
			}
		}

		if(pract_cnt < 2)
		{
			alert(getMessage("SELECT_TWO_PRACT",'MR'));
		}
		else if(role_cnt < 1)
		{
			alert(getMessage("AM0127","AM"));
		}
		else if(internal_cnt < 1 )
		{
			alert(getMessage("ATLEAST_ONE_PRACT","MR"));
		}
		else
		{
			parent.MedBoardRequestFormationResult.document.forms[0].formation_status.value = parent.MedBoardRequestFormationMain.document.forms[0].formation_status.value;

			form_status  = parent.MedBoardRequestFormationMain.document.forms[0].formation_status.value;
			appt_date  = parent.MedBoardRequestFormationMain.document.forms[0].appt_date.value;

			if(form_status == '2' && appt_date == '')
			{
				var error = getMessage('CAN_NOT_BE_BLANK','Common');
				error = error.replace('$',getLabel("Common.apptdate.label","Common"));
				alert(error);
				parent.MedBoardRequestFormationMain.document.forms[0].appt_date.focus();
			}
			else
			{
				parent.MedBoardRequestFormationMain.document.forms[0].user.disabled=false;	
				parent.frames[2].document.forms[0].submit();
			}
		}

	}
	else if(call_function == "MEDICAL_BOARD_INT_APPT")
	{
//		var fields	= new Array(parent.frames[1].document.forms[0].delivered_date);
//		var names	= new Array ("Deliver Date");
			
//		if(checkMandatory( fields, names)) 
//		{
			for(var i=0; i<parent.frames[1].document.forms[0].length;i++)
			{
				parent.frames[1].document.forms[0].elements(i).disabled = false;
			}
			parent.frames[1].document.forms[0].action = "../../servlet/eMR.MedBoardTransactionsServlet";
			parent.frames[1].document.forms[0].submit();
//		}
	}



	function getEventStatus()
	{
		var accession_num	= parent.frames[1].document.forms[0].accession_num.value;
		var event_status	= parent.frames[1].document.forms[0].event_status.value;
		var patientid		= parent.frames[1].document.forms[0].patientId.value;
		if(accession_num !='')
		{
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eMR/jsp/MedRecRequestValidation.jsp' ><input type='hidden' name='Criteria' id='Criteria' value='populateEventStatus'><input type='hidden' name='patientId' id='patientId' value='"+patientid+"'><input type='hidden' name='accession_num' id='accession_num' value='"+accession_num+"'><input type='hidden' name='called_from' id='called_from' value='MEDICAL_BOARD'></form></body></html>";

			parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[3].document.dummy_form.submit();
		}
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

function closeME()
{
	var call_function = document.forms[0].call_function.value;
	if(call_function == "PREPARE_MEDICAL_BOARD")
	{
		if( parent.frames[1].document.forms[0].called_from.value == "CA" && parent.frames[1].document.forms[0].accession_num.value !='' )
		{
			for(var i=0; i<parent.frames[1].document.forms[0].length;i++)
			{
				parent.frames[1].document.forms[0].elements(i).disabled = false;
			}
			parent.frames[1].document.forms[0].prepare_date.value='';

			parent.frames[1].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[1].document.MedBoardReqDetailTabsForm.submit();

			//parent.window.close();
		}
		else
		{
			//parent.window.close();
			parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
		}
		//parent.window.close();
		parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
	}
	else
	//	parent.window.close();
		parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
}

