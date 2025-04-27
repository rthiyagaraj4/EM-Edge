function apply()
{
	setTimeout('apply1()',1000);
	
}

function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function clearform(){
		var called_from_ip	= parent.PatProblemQueryTools.document.query_button.called_from_ip.value;	
		setTimeout('actualClear()',1000);
		var stagecode = parent.PatProblemQueryTools.document.query_button.stage_code.value;
		//if(stagecode != ''){}
		if(called_from_ip == "Y"){}
		else
			top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp'
}

function actualClear()
{
	if(parent.addModifyPatProblem.document.PatProblem_form.function_name.value == "modify")
	{
		var QueryString	= parent.addModifyPatProblem.document.PatProblem_form.QueryString.value;
		
		parent.addModifyPatProblem.location.href ="../../eCA/jsp/addModifyPatProblem.jsp?"+QueryString +"&QueryString=" + escape(QueryString)+"&Sex="+parent.addModifyPatProblem.document.PatProblem_form.sex.value+"&Dob="+parent.addModifyPatProblem.document.PatProblem_form.dob.value;
	}   
	else
	{
		parent.addModifyPatProblem.document.PatProblem_form.reset() ;
		if(parent.addModifyPatProblem.document.PatProblem_form.cause_ind!=null)
		parent.addModifyPatProblem.document.PatProblem_form.cause_ind.disabled = false;
		parent.addModifyPatProblem.document.PatProblem_form.AddAssociateCodes.disabled = true;

	}
}

function cancel_a()
{
	//top.frames[5].document.location.href='../../eCA/jsp/blank.jsp';
	top.content.messageFrame.document.location.href='../../eCA/jsp/blank.jsp';
	top.content.workAreaFrame.PatProblemQueryTools.location.href = '../../eCA/jsp/blank.jsp' ;
	top.content.workAreaFrame.addModifyPatProblem.location.href = '../../eCA/jsp/blank.jsp' ;
	top.content.workAreaFrame.PatProblemQueryResult.location.href = '../../eCA/jsp/blank.jsp' ;
}


function ChkFielditems(fields, names, messageFrame)
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
	 		top.content.messageFrame.document.location.href="../../eCA/jsp/error1.jsp?err_num="+errors ;
	 		return false ;
		 }
	 return true ;
 }

 function Date_Transform (transform,messageFrame) {
 		dateset = transform[0];
 		dateset1 = transform[1];
 		if(dateset1.value=="") {
 			dateset.value="";
 		}
 		else {
 			var tst=dateset1.value;
 			var arr = new Array();
 			arr = tst.split("/");
 			var strDay = arr[0];
 			var strMonth = arr[1];
 			var strYear = arr[2];
 			var dt= strYear + "-" + strMonth + "-" + strDay;
 	//		dateset.value= dt;
 		}
		return true;

 	}

/*added by chitra to chk for mandatory fields and alert the msg*/
function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {}
		else
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(names[i]))+"\n";
	}
	if ( errors.length != 0 ) {
		
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
function apply1()
{
	
	//parent.frames[1].document.forms[0].remarks.focus();
	var fields = new Array();
	var status = true;
	var called_from_ip	= parent.PatProblemQueryTools.document.query_button.called_from_ip.value;	
	if(parent.addModifyPatProblem.document.PatProblem_form.remarks.value.length >2000)
	{	

		var error = "Length can not exceed 2000 characters" ; 
		if(called_from_ip == "Y"){
			parent.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+error;
		}else{
			top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+error;
		}
		return false;
	}


	parent.addModifyPatProblem.document.PatProblem_form.Sec_Hdg_Code.value = 	parent.PatProblemQueryTools.document.query_button.Sec_Hdg_Code.value;
	var stage = parent.addModifyPatProblem.document.PatProblem_form.stage_code.value;
	parent.addModifyPatProblem.document.forms[0].Description.value = parent.addModifyPatProblem.document.forms[0].Description1.value;

	var diag_code	 = parent.addModifyPatProblem.document.forms[0].code;
	var description	 = parent.addModifyPatProblem.document.forms[0].Description1;
	var diag_type	 = parent.addModifyPatProblem.document.forms[0].diag_type;
	var diag_stage	 = parent.addModifyPatProblem.document.forms[0].diag_stage;
	var msg			 ="";

	
	if(parent.addModifyPatProblem.document.forms[0].diag_stage !=null )
	{
		if(trimCheck(diag_stage.value)==null || trimCheck(diag_stage.value)=="")
		{
			msg = getMessage('CAN_NOT_BE_BLANK','common');
			msg = msg.replace('$',getLabel("eMR.DiagnosisStage.label","MR"));
		}	
	}
	
	if(parent.addModifyPatProblem.document.forms[0].diag_type !=null )
	{
		if(trimCheck(diag_type.value)==null || trimCheck(diag_type.value)=="")
		{
			msg += getMessage('CAN_NOT_BE_BLANK','common');
			msg = msg.replace('$',getLabel("Common.DiagnosisType.label","Common"));
		}	
	}

	if(trimCheck(diag_code.value)=="")
	{
		msg = msg + getMessage('CODE_NOT_BLANK','common');
	}


	if(msg != "")
	{
		if(called_from_ip =="Y"){
			parent.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+msg+'&err_value=';	
		}else{
			top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+msg+'&err_value=';
		}
		return false;
	}
	

	if (parent.addModifyPatProblem.document.PatProblem_form.function_name.value == "insert")
	{
		//	alert("insert")
		fields[0]=parent.addModifyPatProblem.document.PatProblem_form.onset;
		fields[1]=parent.addModifyPatProblem.document.PatProblem_form.diag_type;
		var names = new Array (getLabel("Common.onsetdate.label","Common"),getLabel("Common.DiagnosisType.label","Common"));

		//if(stage != '')
		if(called_from_ip =="Y"){
		
			if (checkFields1( fields, names))
			{

				if(parent.addModifyPatProblem.document.forms[0].Description1.value!="")
				{		
						var  onsetarr =  new Array ( parent.addModifyPatProblem.document.PatProblem_form.on_set_date,parent.addModifyPatProblem.document.PatProblem_form.onset);
						if(Date_Transform(onsetarr,parent.messageFrame))
						{
							parent.addModifyPatProblem.PatProblem_form.submit();
						}
				}
				else
				{
					//top.content.messageframe.location.href='../../eCA/jsp/PatProblemerror.jsp?err_num='+msg+'&err_value=';
					//return false;
					alert(getMessage('INVALID_DIAGCODE'));
					return false;
				}
			}
		}
		else if (ChkFielditems( fields, names, top.content.messageFrame))
		{
			if(parent.addModifyPatProblem.document.forms[0].Description1.value!="")
			{		
					var  onsetarr =  new Array ( parent.addModifyPatProblem.document.PatProblem_form.on_set_date,parent.addModifyPatProblem.document.PatProblem_form.onset);
					if(Date_Transform(onsetarr,top.content.messageFrame))
					{
						parent.addModifyPatProblem.PatProblem_form.submit();
					}
			}
			else
				top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp?="+getMessage('INVALID_DIAGCODE');
		}
	}
	else if (parent.addModifyPatProblem.document.PatProblem_form.function_name.value == "modify")
	{
		if (parent.addModifyPatProblem.document.PatProblem_form.problem_status.value == ""  && parent.addModifyPatProblem.document.PatProblem_form.errorRemarks.value == "") 
		{
			fields[0]=parent.addModifyPatProblem.document.PatProblem_form.problem_status;
			
			var names = new Array (getLabel("Common.status.label","Common"));
			if(stage != '')
			{
				if(!(checkFields1( fields, names)))
				status = false;
			}
			else if(!(ChkFielditems( fields, names, top.content.messageFrame)))
				status = false;
		}
		else if (parent.addModifyPatProblem.document.PatProblem_form.problem_status.value == "C")
		{	
			fields[0]=parent.addModifyPatProblem.document.PatProblem_form.close;
			var names = new Array (getLabel("eMR.ClosedDate.label","MR"));
			if(stage != '')
			{
				if(!(checkFields1( fields, names)))
				status = false;
			}
			else if(!(ChkFielditems( fields, names, top.content.messageFrame)))
				status = false;
		}

	if(status == true)
		{
			var  onsetarr =  new Array ( parent.addModifyPatProblem.document.PatProblem_form.close_date,parent.addModifyPatProblem.document.PatProblem_form.close);
			if(Date_Transform(onsetarr,top.content.messageFrame))
			{
				if(stage == '')
				{
					status=doDateCheck(parent.addModifyPatProblem.document.PatProblem_form.onset,parent.addModifyPatProblem.document.PatProblem_form.close,top.content.messageFrame)
					parent.addModifyPatProblem.PatProblem_form.submit();
				}
				else
				{
					status = doDateCheckAlert(parent.addModifyPatProblem.document.PatProblem_form.onset,parent.addModifyPatProblem.document.PatProblem_form.close)
					if (!status)
					{
						alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'))
						return false;
					}
					else 
						status = true;
				}
				if(status)
				{
					var  onsetarr =  new Array ( parent.addModifyPatProblem.document.PatProblem_form.current_date,parent.addModifyPatProblem.document.PatProblem_form.currentdate);
					
					if(parent.addModifyPatProblem.document.PatProblem_form.problem_status.value == "C")
					{
							if(Date_Transform(onsetarr,top.content.messageFrame))
							{
								var status=false
								if(parent.addModifyPatProblem.document.PatProblem_form.currentdate.value==parent.addModifyPatProblem.document.PatProblem_form.close.value)
								{
									status1=true
								}
								else
								{
									status1=false;
									//status1=doDateCheck(top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.current_date,top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.closedt,top.content.messageframe)					
								}
								if(status1)
								{
									
								}
								else if(stage != '')
								{
									alert(getMessage('INVALID_CLOSE_DATE'));
									return false;
								}
								/*else
									
									top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+getMessage('INVALID_CLOSE_DATE');*/
							}
						
						else if(stage != '')
						{
							alert(getMessage('INVALID_CLOSE_DATE'));
							return false;
						}
					}
					else
					{
						parent.addModifyPatProblem.PatProblem_form.submit();
					}
				}
			}
		}
	}
}

function onsuccess() 
{
	
	var Encounter_Id 		= parent.PatProblemQueryTools.document.query_button.Encounter_Id.value;
	var Practitioner_Id	= parent.PatProblemQueryTools.document.query_button.Practitioner_Id.value;
	var Locn_Code 		= parent.PatProblemQueryTools.document.query_button.Locn_Code.value;
	var Patient_Id 			= parent.PatProblemQueryTools.document.query_button.Patient_Id.value;
	var Locn_Type 			= parent.PatProblemQueryTools.document.query_button.Locn_Type.value;
	var context					= parent.PatProblemQueryTools.document.query_button.Context.value;
	var stagecode			= parent.PatProblemQueryTools.document.query_button.stage_code.value;
	var stagedesc			= parent.PatProblemQueryTools.document.query_button.stage_desc.value;
	var logicalseqno		= parent.PatProblemQueryTools.document.query_button.logical_seq_no.value;
	var patient_class		= parent.PatProblemQueryTools.document.query_button.patient_class.value;
	var called_from_ip	= parent.PatProblemQueryTools.document.query_button.called_from_ip.value;

	var f_authorize_yn  ="N";
	if(	parent.PatProblemQueryTools.document.forms[0].authorize!=null)
	{
		if(parent.PatProblemQueryTools.document.forms[0].authorize.value=="Normal Mode")
			f_authorize_yn="Y"
	}
	
	parent.PatProblemQueryResult.location.href ="../../eCA/jsp/PatProblemQueryResult.jsp?Logical_Seq="+logicalseqno+"&stage_code="+stagecode+"&stage_desc="+stagedesc+"&Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&f_authorize_yn="+f_authorize_yn+"&P_context="+context+"&patient_class="+patient_class+"&called_from_ip="+called_from_ip;
	
	parent.addModifyPatProblem.location.href ="../../eCA/jsp/addModifyPatProblem.jsp?Logical_Seq="+logicalseqno+"&stage_code="+stagecode+"&stage_desc="+stagedesc+"&Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&f_authorize_yn="+f_authorize_yn+"&P_context="+context+"&patient_class="+patient_class+"&called_from_ip="+called_from_ip;
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
 function callNotifiableNotes()
 {
	var patient_id = document.forms[0].patient_id.value;
	var episode_id = document.forms[0].episode_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var visit_adm_date = document.forms[0].visit_adm_date.value;
	var patient_class = document.forms[0].patient_class.value;
	var accession_num = document.forms[0].accession_num.value;
	var dialogHeight= "26" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=NOTIFIABLE_FORM&title="+getLabel("eMR.NotifiableForm.label","MR")+"&patient_id="+patient_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=parent.addModifyPatProblem.document.forms[0].accession_num";

	var child_window	=	window.open(action_url,null,"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
	child_window.focus();
 }
