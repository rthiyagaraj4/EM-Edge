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
			top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp'
			//top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp'
}

function actualClear()
{
	if(parent.addModifyPatProblem.document.PatProblem_form.function_name.value == "modify")
	{
		//alert("here in modify...");
		var calledFromDeathReg = parent.addModifyPatProblem.document.PatProblem_form.calledFromDeathReg.value;
		var modal_yn = parent.addModifyPatProblem.document.PatProblem_form.modal_yn.value;
		var QueryString	= parent.addModifyPatProblem.document.PatProblem_form.QueryString.value;
		//alert(QueryString);
		parent.addModifyPatProblem.location.href ="../../eMR/jsp/DiagRecodeaddModify.jsp?"+QueryString +"&QueryString=" + escape(QueryString)+"&Sex="+parent.addModifyPatProblem.document.PatProblem_form.sex.value+"&Dob="+parent.addModifyPatProblem.document.PatProblem_form.dob.value+"&calledFromDeathReg="+calledFromDeathReg+"&modal_yn="+modal_yn;
	}   
	else
	{
		//alert("here in else...");
		parent.addModifyPatProblem.document.PatProblem_form.reset() ;
		if(parent.addModifyPatProblem.document.PatProblem_form.cause_ind!=null)
		parent.addModifyPatProblem.document.PatProblem_form.cause_ind.disabled = false;
		parent.addModifyPatProblem.document.PatProblem_form.AddAssociateCodes.disabled = true;
		parent.addModifyPatProblem.document.PatProblem_form.code.value = "";

	}
}

function cancel_a()
{
	//top.frames[5].document.location.href='../../eCA/jsp/blank.jsp';
	//top.content.messageFrame.document.location.href='../../eCA/jsp/blank.jsp';
	top.content.messageFrame.document.location.href='../../eCommon/html/blank.html';
	//top.content.workAreaFrame.PatProblemQueryTools.location.href = '../../eCA/jsp/blank.jsp' ;
	top.content.workAreaFrame.PatProblemQueryTools.location.href = '../../eCommon/html/blank.html' ;
	//top.content.workAreaFrame.addModifyPatProblem.location.href = '../../eCA/jsp/blank.jsp' ;
	top.content.workAreaFrame.addModifyPatProblem.location.href = '../../eCommon/html/blank.html' ;
	//top.content.workAreaFrame.PatProblemQueryResult.location.href = '../../eCA/jsp/blank.jsp' ;
	top.content.workAreaFrame.PatProblemQueryResult.location.href = '../../eCommon/html/blank.html' ;
	//top.content.workAreaFrame.PatProblemHeader.location.href = '../../eCA/jsp/blank.jsp' ;
	top.content.workAreaFrame.PatProblemHeader.location.href = '../../eCommon/html/blank.html' ;
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

		errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;

	 }
	 if (errors.length !=0)
   		{
	 	if(parent.PatProblemQueryTools.document.query_button.modal_yn.value=='Y')	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		else
		top.content.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	 		return false ;
		 }
	 return true ;
 }


 function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {}
		else	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "\n" ;
	}
	if ( errors.length != 0 ) {
		//alert(errors) ;
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		return false ;
	}
	return true ;
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
	var calledFromDeathReg	= parent.PatProblemQueryTools.document.query_button.calledFromDeathReg.value;

	var f_authorize_yn  ="N";
	if(	parent.PatProblemQueryTools.document.forms[0].authorize!=null)
	{
		if(parent.PatProblemQueryTools.document.forms[0].authorize.value=="Normal Mode")
			f_authorize_yn="Y"
	}
	//alert('Value --'+parent.PatProblemQueryTools.document.forms[0].authorize.value);
	
	parent.PatProblemQueryResult.location.href ="../../eMR/jsp/DiagRecodePatProblemQueryResult.jsp?Logical_Seq="+logicalseqno+"&stage_code="+stagecode+"&stage_desc="+stagedesc+"&Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&f_authorize_yn="+f_authorize_yn+"&P_context="+context+"&patient_class="+patient_class+"&called_from_ip="+called_from_ip;
	
	parent.addModifyPatProblem.location.href ="../../eMR/jsp/DiagRecodeaddModify.jsp?Logical_Seq="+logicalseqno+"&stage_code="+stagecode+"&stage_desc="+stagedesc+"&Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&f_authorize_yn="+f_authorize_yn+"&P_context="+context+"&patient_class="+patient_class+"&called_from_ip="+called_from_ip;
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
	var dialogHeight= "26" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=NOTIFIABLEFORM	&title=Notifiable Form&patient_id="+patient_id+"&encounter_id="+episode_id+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class+"&accession_num="+accession_num+"&Field_Ref=parent.addModifyPatProblem.document.forms[0].accession_num";

	var child_window	=	window.open(action_url,null,"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
	child_window.focus();
 }


 function closew(Dcode)
{
	
	window.parent.parent.returnValue=Dcode;
	window.parent.parent.close();
}


function showLongDescription(a)
{
	var dialogHeight= "20vh" ;
    var dialogWidth = "23vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	window.showModalDialog("../../eMR/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
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
	   	var dialogHeight1 ='9vh' ;
	   	var dialogWidth = '30vw' ;
	   	var features = 'dialogHeight:' + dialogHeight1 + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	   	var arguments;
	        arguments = long_desc;
	   	retVal = await window.showModalDialog('../../eMR/jsp/ViewRemarks.jsp?title_name=Remarks',arguments,features);
   	   }
	}
	
		
					
function apply1(fromFinalize)
{
	var fields = new Array();
	var status = true;
	
//alert('comes in apply block');
	var called_from_ip	= parent.PatProblemQueryTools.document.query_button.called_from_ip.value;
	var modal_yn	= parent.PatProblemQueryTools.document.query_button.modal_yn.value;

	var AddAssociateCodes = parent.addModifyPatProblem.document.getElementById("AddCodesBtn").disabled;
	var associate_codes	= parent.addModifyPatProblem.document.PatProblem_form.associate_codes.value;

	if(parent.addModifyPatProblem.document.PatProblem_form.remarks.value.length >2000)
	{	

		var error = "Length can not exceed 2000 characters" ; //getMessage('INVALID_DIAGCODE') ;
		if(called_from_ip == "Y" ||modal_yn =="Y")
		{
			//parent.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+error;
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
		}
		else
		{
			//top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+error;
			top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
		}
		return false;
	}

	parent.addModifyPatProblem.document.PatProblem_form.Sec_Hdg_Code.value = 	parent.PatProblemQueryTools.document.query_button.Sec_Hdg_Code.value;
	var stage = parent.addModifyPatProblem.document.PatProblem_form.stage_code.value;	
	parent.addModifyPatProblem.document.forms[0].Description.value = parent.addModifyPatProblem.document.forms[0].Description1.value;

	var diag_code	 = parent.addModifyPatProblem.document.forms[0].code;
	var description	 = parent.addModifyPatProblem.document.forms[0].Description1;

	var msg			 ="";

	
	if(trimCheck(diag_code.value)=="")
	{
		//msg = msg + "APP-CA0001 Code cannot be blank...<br>";
		msg = getMessage('CAN_NOT_BE_BLANK','Common');
		msg = msg.replace('$',getLabel('Common.code.label','Common')) +"<br>";
	}

	if(trimCheck(description.value)=="")
	{
		msg = msg + getMessage('CAN_NOT_BE_BLANK','Common');
		msg = msg.replace('$',getLabel('Common.description.label','Common')) +"<br>";
	}
	if(msg != "")
	{
		if(called_from_ip =="Y" ||modal_yn =="Y"){
			//parent.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+msg+'&err_value=';	
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=';	
		}else{
			//top.content.messageFrame.location.href='../../eCA/jsp/error1.jsp?err_num='+msg+'&err_value=';
			top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=';
		}
		return false;
	}

	//alert('comes in before submit form:'+parent.addModifyPatProblem.document.forms[0].Description1.value);
	if(parent.addModifyPatProblem.document.forms[0].Description1.value!="")
	{
		
		parent.addModifyPatProblem.PatProblem_form.submit();
		parent.addModifyPatProblem.document.forms[0].Description1.value="";
		parent.addModifyPatProblem.document.forms[0].code.value="";
		parent.addModifyPatProblem.document.forms[0].remarks.value="";
		parent.addModifyPatProblem.document.forms[0].exclamation.style.visibility='hidden';
		parent.addModifyPatProblem.document.forms[0].AddAssociateCodes.disabled=true;
		parent.addModifyPatProblem.document.forms[0].associate_codes.value="";

		//alert('after submission');
		


	}
	else
	{
					
		alert(getMessage('INVALID_DIAG_CODE','MR'));
		return false;
	}
//	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}


function resultpage()
{
	var Encounter_Id=parent.addModifyPatProblem.document.PatProblem_form.Encounter_Id.value;
	parent.Diagresultframe.location.href='../../eMR/DiagRecodeaddmodify.jsp?Encounter_Id='+Encounter_Id;
}
	
function chkRemarkLength(Obj,max_value) //Function to check the length of remarks fields.
{
	var str="";
	if(Obj.value.length >200)
	{            
		str = getMessage("REMARKS_CANNOT_EXCEED","Common");
		str = str.replace('$', getLabel("Common.remarks.label","Common"));
		str = str.replace('#', max_value);
		alert(str);
		Obj.focus();		
	}
}
