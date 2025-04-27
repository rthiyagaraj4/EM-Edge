function apply()
{
	setTimeout('apply1()',1000);
	
}

function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*. ';
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
		if(called_from_ip == "Y" ||parent.PatProblemQueryTools.document.query_button.modal_yn.value=='Y'){}
		else
			top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp'
}

function actualClear()
{
	if(parent.addModifyPatProblem.document.PatProblem_form.function_name.value == "modify")
	{
		var QueryString	= parent.addModifyPatProblem.document.PatProblem_form.QueryString.value;
		//alert(QueryString);
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
	top.content.workAreaFrame.PatProblemHeader.location.href = '../../eCA/jsp/blank.jsp' ;
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

		{
			errors =getMessage("CAN_NOT_BE_BLANK","Common")+ "<br>";
		    errors =errors.replace('$',names[i]);
		}	
		

	 }
	 if (errors.length !=0)
   		{
	 	if(parent.PatProblemQueryTools.document.query_button.modal_yn.value=='Y')	parent.messageFrame.document.location.href="../../eCA/jsp/error1.jsp?err_num="+errors ;
		else
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
		{
			errors =getMessage("CAN_NOT_BE_BLANK","Common")+ "<br>";
			errors =errors.replace('$',names[i]);
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "\n" ;
		}
	}
	if ( errors.length != 0 ) {
		//alert(errors) ;
		parent.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+errors;
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
	
	var fields = new Array();
	var status = true;
	

	var called_from_ip	= parent.PatProblemQueryTools.document.query_button.called_from_ip.value;
	var modal_yn	= parent.PatProblemQueryTools.document.query_button.modal_yn.value;

//alert('called_from_ip---'+called_from_ip);
//alert('modal_yn---'+modal_yn);

	if(parent.addModifyPatProblem.document.PatProblem_form.remarks.value.length >2000)
	{	

		var error = getMessage("REMARKS_CANNOT_EXCEED","Common");
			error=error.replace('$','Length');
			error=error.replace('#','2000');
		//var error = "Length can not exceed 2000 characters" ; //getMessage('INVALID_DIAGCODE') ;
		if(called_from_ip == "Y" ||modal_yn =="Y")
		{
			parent.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+error;
		}
		else
		{
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
		msg = getMessage("CAN_NOT_BE_BLANK","Common")+"<br>";
		msg =msg.replace('$','Diagnosis stage');
		//msg = "APP-CA0001 Diagnosis stage cannot be blank...<br>";
		}	
	}
	
	if(parent.addModifyPatProblem.document.forms[0].diag_type !=null )
	{
		if(trimCheck(diag_type.value)==null || trimCheck(diag_type.value)=="")
		{
			msg += getMessage("CAN_NOT_BE_BLANK","Common")+"<br>";
			msg =msg.replace('$','Diagnosis type');
			//msg += "APP-CA0001 Diagnosis type cannot be blank...<br>";
		}	
	}

	if(trimCheck(diag_code.value)=="")
	{
		msg = msg + getMessage("CAN_NOT_BE_BLANK","Common")+"<br>";
		msg =msg.replace('$','Code');
		//msg = msg + "APP-CA0001 Code cannot be blank...<br>";
	}


	if(msg != "")
	{
		if(called_from_ip =="Y" ||modal_yn =="Y"){
			parent.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+msg+'&err_value=';	
		}else{
			top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+msg+'&err_value=';
		}
		return false;
	}
	

	if (parent.addModifyPatProblem.document.PatProblem_form.function_name.value == "insert")
	{
		fields[0]=parent.addModifyPatProblem.document.PatProblem_form.onset;
		fields[1]=parent.addModifyPatProblem.document.PatProblem_form.diag_type;
		var names = new Array (getLabel("Common.onsetdate.label","COMMON"),
		getLabel("eCA.DiagnosisType.label",'CA'));

		//if(stage != '')
		if(called_from_ip =="Y" || modal_yn =="Y")
		{
		
			if (checkFields1( fields, names))
			{

				if(parent.addModifyPatProblem.document.forms[0].Description1.value!="")
				{		
						var  onsetarr =  new Array ( parent.addModifyPatProblem.document.PatProblem_form.on_set_date,parent.addModifyPatProblem.document.PatProblem_form.onset);
						if(Date_Transform(onsetarr,parent.messageFrame))
						{
							//alert(22);
							parent.addModifyPatProblem.PatProblem_form.submit();
						}
				}
				else
				{
					//var msg = getMessage('INVALID_DIAGCODE');
					//top.content.messageframe.location.href='../../eCA/jsp/PatProblemerror.jsp?err_num='+msg+'&err_value=';
					//return false;
					alert(getMessage('INVALID_DIAG_CODE_FOR_PATIENT','CA'));
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
							//alert('1'+top.content.workAreaFrame.addModifyPatProblem.document.forms[0].name);
						parent.addModifyPatProblem.PatProblem_form.submit();
					}
			}
			else
				top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp?="+getMessage('INVALID_DIAG_CODE_FOR_PATIENT','CA');
		}
	}
	else if (parent.addModifyPatProblem.document.PatProblem_form.function_name.value == "modify")
	{
		if (parent.addModifyPatProblem.document.PatProblem_form.problem_status.value == ""  && parent.addModifyPatProblem.document.PatProblem_form.errorRemarks.value == "") 
		{
			fields[0]=parent.addModifyPatProblem.document.PatProblem_form.problem_status;
			
			var names = new Array (getLabel("Common.status.label","COMMON"));
			if(modal_yn == "Y" ||called_from_ip=='Y')
			{
				if(stage != '')
				{
					if(!(checkFields1( fields, names)))
					status = false;
				}
				else if(!(ChkFielditems( fields, names, parent.messageFrame)))
					status = false;
			}
			else
			{
				if(stage != '')
				{
					if(!(checkFields1( fields, names)))
					status = false;
				}
				else if(!(ChkFielditems( fields, names, top.content.messageFrame)))
					status = false;
			}
		}
		else if (parent.addModifyPatProblem.document.PatProblem_form.problem_status.value == "C")
		{	
	//alert(stage);		
			fields[0]=parent.addModifyPatProblem.document.PatProblem_form.close;
			var names = new Array (getLabel("eCA.CloseDate.label","CA"));
			if(modal_yn == "Y" ||called_from_ip=='Y')
			{
				if(stage != '')
				{
					if(!(checkFields1( fields, names)))
					status = false;
				}
				else if(!(ChkFielditems( fields, names, parent.messageFrame)))
					status = false;
			}
			else
			{
				if(stage != '')
				{
					if(!(checkFields1( fields, names)))
					status = false;
				}
				else if(!(ChkFielditems( fields, names, top.content.messageFrame)))
					status = false;
			}
		}

	if(status == true)
		{
			var  onsetarr =  new Array ( parent.addModifyPatProblem.document.PatProblem_form.close_date,parent.addModifyPatProblem.document.PatProblem_form.close);
			if(modal_yn=='Y' ||called_from_ip=='Y')
			{
				//alert("modal_yn"+modal_yn);
				//alert("called_from_ip"+called_from_ip);
				if(Date_Transform(onsetarr,parent.messageFrame))
				{
					if(stage != '')
					{
						status=doDateCheck(parent.addModifyPatProblem.document.PatProblem_form.onset,parent.addModifyPatProblem.document.PatProblem_form.close,parent.messageFrame)
					//alert("status"+status);	//top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+getMessage('INVALID_CLOSE_DATE');
						//parent.addModifyPatProblem.PatProblem_form.submit();
						//alert("submit");
					}
					else
					{
						status = doDateCheckAlert(parent.addModifyPatProblem.document.PatProblem_form.onset,parent.addModifyPatProblem.document.PatProblem_form.close)
						if (!status)
						{
							alert(getMessage('TO_DT_GR_EQ_FM_DT','CA'))
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
								if(Date_Transform(onsetarr,parent.messageFrame))
								{
									var status=false
									if(parent.addModifyPatProblem.document.PatProblem_form.currentdate.value==parent.addModifyPatProblem.document.PatProblem_form.close.value)
									{
										//alert('equal')
										status1=true
									}
									else
									{
										status1=false;
										//alert('not equal')
										//status1=doDateCheck(top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.current_date,top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.closedt,top.content.messageframe)					
									}
									if(status1)
									{
											//alert('2'+top.content.workAreaFrame.addModifyPatProblem.document.forms[0].name);
										//alert("close"+parent.addModifyPatProblem.document.PatProblem_form.close.value);
										parent.addModifyPatProblem.PatProblem_form.submit();
									}
									else if(stage != '')
									{
										alert(getMessage('INVALID_CLOSE_DATE','CA'));
										return false;
									}
									/*else
										
										top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+getMessage('INVALID_CLOSE_DATE');*/
								}
							
							else if(stage != '')
							{
								alert(getMessage('INVALID_CLOSE_DATE','CA'));
								return false;
							}
							/*else
								
								top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+getMessage('INVALID_CLOSE_DATE');*/
						}
						else
						{
								//alert('3'+top.content.workAreaFrame.addModifyPatProblem.document.forms[0].name);
								if(parent.addModifyPatProblem.document.PatProblem_form.context.value =='IP_Q')
								parent.addModifyPatProblem.document.PatProblem_form.diag_stage.disabled=false;
                          // alert(parent.addModifyPatProblem.PatProblem_form.action);
						//  alert('in if apply');
  							parent.addModifyPatProblem.PatProblem_form.submit();
						}
					}
				}
			}
			else
			{
				if(Date_Transform(onsetarr,top.content.messageFrame))
				{
					if(stage == '')
					{
						status=doDateCheck(parent.addModifyPatProblem.document.PatProblem_form.onset,parent.addModifyPatProblem.document.PatProblem_form.close,top.content.messageFrame)
						//top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+getMessage('INVALID_CLOSE_DATE');
						//alert('in else apply');
						parent.addModifyPatProblem.PatProblem_form.submit();
					}
					else
					{
						status = doDateCheckAlert(parent.addModifyPatProblem.document.PatProblem_form.onset,parent.addModifyPatProblem.document.PatProblem_form.close)
						if (!status)
						{
							alert(getMessage('TO_DT_GR_EQ_FM_DT','CA'))
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
										//alert('equal')
										status1=true
									}
									else
									{
										status1=false;
										//alert('not equal')
										//status1=doDateCheck(top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.current_date,top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.closedt,top.content.messageframe)					
									}
									if(status1)
									{
											//alert('2'+top.content.workAreaFrame.addModifyPatProblem.document.forms[0].name);
										
									//alert(1);	parent.addModifyPatProblem.PatProblem_form.submit();
									}
									else if(stage != '')
									{
										alert(getMessage('INVALID_CLOSE_DATE','CA'));
										return false;
									}
									/*else
										
										top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+getMessage('INVALID_CLOSE_DATE');*/
								}
							
							else if(stage != '')
							{
								alert(getMessage('INVALID_CLOSE_DATE','CA'));
								return false;
							}
							/*else
								
								top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+getMessage('INVALID_CLOSE_DATE');*/
						}
						else
						{
								//alert('3'+top.content.workAreaFrame.addModifyPatProblem.document.forms[0].name);
							//parent.addModifyPatProblem.PatProblem_form.submit();
						}
					}
				}
			}
			
			
		}
	}
}

function onsuccess() 
{
	
	var Encounter_Id 		= parent.PatProblemQueryTools.document.query_button.Encounter_Id.value;
	//alert('in js Encounter_Id'+Encounter_Id);
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
	//alert('Value --'+parent.PatProblemQueryTools.document.forms[0].authorize.value);
	
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
	//alert(document.forms[0].authorizeCheck.value);
	var patient_id = document.forms[0].patient_id.value;
	var episode_id = document.forms[0].episode_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var visit_adm_date = document.forms[0].visit_adm_date.value;
	var patient_class = document.forms[0].patient_class.value;
	var accession_num = document.forms[0].accession_num.value;
	var dialogHeight= "50" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=NOTIFIABLEFORM	&title=Notifiable Form&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=parent.addModifyPatProblem.document.forms[0].accession_num";

	var child_window	=	window.open(action_url,null,"height=550,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
	child_window.focus();
 }


 function closew(Dcode)
{
	
	window.parent.parent.returnValue=Dcode;
	window.parent.parent.getElementById("dialog_tag");
}


function showLongDescription(a)
{
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	window.showModalDialog("../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
}

function scrollTitleIcd(){
          var y = parent.codedesc.document.body.scrollTop;

          if(y == 0){
			parent.codedesc.document.getElementById("divDataTitle").style.position = 'static';
			//parent.parent.PhysicainNoteResult.document.getElementById("divDataTitle").style.posTop  = 0;
          }else{
			parent.codedesc.document.getElementById("divDataTitle").style.position = 'relative';
			parent.codedesc.document.getElementById("divDataTitle").style.posTop  = y-2;
          }

        }
		function alignWidthIcd(){
			var totalRows =  parent.codedesc.document.getElementById("dataTable").rows.length;
			
	        var counter = totalRows-1;
            var temp = parent.codedesc.document.getElementById("dataTitleTable").rows(0).cells.length;
            for(var i=0;i<temp;i++) {
				parent.codedesc.document.getElementById("dataTitleTable").rows(0).cells(i).width=parent.codedesc.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
				
            }
        }

		async function showLongDesc(long_desc)
		{
			if(long_desc!='' && long_desc!=null)
			{
				var dialogHeight1 ='9' ;
			 	var dialogWidth = '30' ;
			 	var features = 'dialogHeight:' + dialogHeight1 + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
			 	var arguments;
			    arguments = long_desc;
				var title = getLabel("Common.remarks.label","Common");
				var url = "../../eCA/jsp/ViewRemarks.jsp?title_name="+encodeURIComponent(title);
			   	retVal =await window.showModalDialog(url,arguments,features);
	   	   }
		}



function leapyear(a) 
{
	if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
		return true;
	else
		return false;
}


function calcage(obj1,obj2) 
{
	if(obj1.value != '' || obj2.value != '' )
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
					else 
					{
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
	
}


function CheckForNumber_L(Objval,obj1) 
{
  	if(obj1.value == ''&& document.forms[0].closedate !=null)
	{
		obj1.value = document.forms[0].closedate.value;
	}

	val = Objval.value;
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
  		return true;
	else
	{

		if ( val.length > 0 ) {
			if(obj1.name=="onset")
	  			document.forms[0].onset.value='';
			else if(obj1.name=="close")
				document.forms[0].close.value='';
  			alert(getMessage("ONLY_NUMBER_ALLOWED","CA"));
			Objval.select();
  			Objval.focus();
  			return false;
  			
  		}
	}
	
}


function checkDays(Obj,obj1)
{
	if( Obj.value  > 31) 
	{ 
		alert(getMessage("DAYS_CHECK","Common"));
		Obj.focus(); 
		if (obj1.name=="onset")
				document.forms[0].onset.value=''; 
		else if(obj1.name=="close")
				document.forms[0].close.value=''; 
	}
//	document.forms[0].onset.onblur();
}

function checkMonth(Obj,obj1)
{
	if( Obj.value  > 11) { 
		alert(getMessage("MONTHS_CHECK","Common"));
		Obj.focus(); 
		if (obj1.name=="onset"){
				document.forms[0].onset.value='';}
		else if(obj1.name=="close")
				document.forms[0].close.value='';
	}
//	document.forms[0].onset.onblur();
}



function isVaidwithSysDate(obj, format,locale)
{
  if (obj.value!=null && obj.value != "")
  {
	if(isBeforeNow(obj.value, format,locale))
			return true;
	else
	{
		if( obj.name == "onset")
		{	
			alert(getMessage("INVALID_ONSET_DATE","CA"));
			obj.value = document.forms[0].sys_date.value;
			return false;
		}
	}
  }
}

function isBetweenCurrDate(onset,currDate,close,format,locale)
{
  if (close.value!=null && close.value != "")
  {
	if(isBetween(onset,currDate,close.value,format,locale))
		return true;
	else
	{
		alert(getMessage("INVALID_CLOSE_DATE","CA"));
		close.value = currDate;
		
		return false;

	}
  }
  else   if (close.value==null)
	{
	  return false;
	}
}

function calci(Obj,format,locale,dateObj)
{
	var dob			= document.forms[0].dob.value;
	var sysDate		= document.forms[0].sys_date.value;

	var currDate = document.forms[0].ServerDate.value;

	if(dateObj.value == null || dateObj.value == "")
		dateObj.value = currDate;

	var intervalY='Y',intervalM='M',intervalD='d';

	if(Obj.name == 'b_age' && Obj.value >0)
		dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalY);

	if(Obj.name == 'b_months' && (Obj.value >0 && Obj.value <12))
		dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalM);

	if(Obj.name == 'b_days' && (Obj.value >0 && Obj.value <32))
		dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalD);

	if(dob != null && dob != "")
	{
		if(!checkWithDob(dateObj.value,dob, sysDate, format, locale))
		{
				dateObj.value = currDate;
				Obj.value = 0;
				document.forms[0].b_months.value = 0;
				document.forms[0].b_days.value = 0;
				document.forms[0].b_age.value = 0;
		}
	}
}

function calci1(Obj,format,locale,dateObj)
{
	var currDate	= document.forms[0].ServerDate1.value;
	var sysDate		= document.forms[0].sys_date.value;

	var intervalY='Y',intervalM='M',intervalD='d';

	if(dateObj.value != null && dateObj.value != "")
	{
		if(Obj.name == 'b_age1' && Obj.value >0)
			dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalY);

		if(Obj.name == 'b_months1' && (Obj.value >0 && Obj.value <12))
			dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalM);

		if(Obj.name == 'b_days1' && (Obj.value >0 && Obj.value <32))
				dateObj.value = minusDate(dateObj.value, format, locale, Obj.value, intervalD);

		if(!isBetweenCurrDate(document.forms[0].onset.value, currDate,dateObj,format,locale))
		{
				dateObj.value = currDate;
				Obj.value = 0;
				document.forms[0].b_months1.value = 0;
				document.forms[0].b_days1.value = 0;
				document.forms[0].b_age1.value = 0;
		}
	}
}

function checkWithDob(onset, dob,sysDate, format, locale)
{
	if(onset != "")
	{
		if(!isBetween(dob,sysDate,onset, format, locale))
		{	
			alert(getMessage("LESS_THAN_BDAY_DATE","CA"));
			return false;
		}
		else
			 return true;
	}
}
