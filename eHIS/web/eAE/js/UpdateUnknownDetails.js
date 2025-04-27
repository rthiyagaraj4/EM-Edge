function apply()
{
	var chk_fields = new Array(parent.frames[2].frames[1].document.forms[0].patient_id,parent.frames[2].frames[1].document.forms[0].p_id_patient_id);
	var chk_names  = new Array(getLabel("eAE.ExistingPatientID.label","AE"),getLabel("eAE.NewPatientID.label","AE"));
	if(parent.frames[2].frames[1].checkFields(chk_fields,chk_names,frames[2]))
	{	
		parent.frames[2].frames[1].document.forms[0].submit();
	}
}
async function callPatientSearch(Obj) 
{
	var p_patient_id = "";
	var temp_pat_id="";
	var temp_pat_id2="";
	if(Obj.name == 'pat_search')
	{
		p_patient_id = await PatientSearch();
	}
	else if(Obj.name == 'pat_search1')
	{
		var patient_id   = document.forms[0].patient_id.value;
		////////////// To Display Register Patient Button in the Patient Search Lookup //////////////
		//p_patient_id = PatientSearch('','','','','','','Y','N','Y','DuplicateRegistration',patient_id);
		temp_pat_id = await PatientSearch('','','','','','','Y','N','Y','DuplicateRegistration',patient_id);

			if(temp_pat_id){
			if(document.forms[0].pat_id_length.value<temp_pat_id.length){
			for( var i=0; i<temp_pat_id.length; i++ ) {
			if(temp_pat_id.charAt(0)=='Y' && i==0){
			}else{
				temp_pat_id2+=temp_pat_id.charAt(i);
			}
		}
		}else{
			temp_pat_id2=temp_pat_id;
		}
			p_patient_id=temp_pat_id2;
	}else{
		p_patient_id = null;
	}
		
	}
	if(p_patient_id  != null)
	{ 
		if(Obj.name == 'pat_search')
		{
			parent.frames[1].document.forms[0].patient_id.value = p_patient_id; 
			checkPatientExists(parent.frames[1].document.forms[0].patient_id);
		}
		else if(Obj.name == 'pat_search1')
		{
			parent.frames[1].document.forms[0].p_id_patient_id.value = p_patient_id;
			HTMLVal = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/UpdateUnknownDetailsExists.jsp'><input name='p_patient_id' id='p_patient_id' type='hidden' value='"+p_patient_id+"'><input name='CalledFrom' id='CalledFrom' type='hidden' value='NewPatDlts'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
		}
	}
}
function checkPatientExists(obj)
{
	var p_patient_id = obj.value;
	p_patient_id     = p_patient_id.toUpperCase();
	obj.value        = p_patient_id;
	if(p_patient_id.length != 0) 
	{
		var splField = new Array (parent.frames[1].document.forms[0].patient_id);
		var splFieldName = new Array (getLabel("Common.patientId.label","Common"));
		if(parent.frames[1].SpecialCharCheck(splField, splFieldName, parent.messageFrame,"M","../../eCommon/jsp/error.jsp"))
		{
			HTMLVal = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/UpdateUnknownDetailsExists.jsp'><input name='p_patient_id' id='p_patient_id' type='hidden' value='"+p_patient_id+"'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
		}
		else
		{
			parent.frames[1].document.forms[0].patient_id.select();
			parent.frames[1].document.forms[0].patient_id.focus();
		}
	}
	else
	{
		document.getElementById('pat_name').innerHTML			 = '&nbsp;';
		document.getElementById('pat_ser_grp').innerHTML		 = '&nbsp;';
		document.getElementById('NewPatDltsID').innerHTML		 = '&nbsp;';
		document.getElementById('DeceasedID').innerHTML		 = '&nbsp;';
		document.forms[0].NewPatDltsIDName.value = '';
		document.forms[0].p_id_patient_id.value  = '';

		if(document.forms[0].p_id_patient_id.disabled  == false)
			document.forms[0].p_id_patient_id.disabled = true;
		if(document.forms[0].pat_search1.disabled  == false)
			document.forms[0].pat_search1.disabled = true;
		parent.frames[1].document.forms[0].patient_id.focus();
	}
}


function Populate_Main_Details()
{
	var p_patient_id = document.forms[0].p_id_patient_id.value;
	HTMLVal = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action='../../eAE/jsp/UnknownDetailsPopulate.jsp'><input name='p_patient_id' id='p_patient_id' type='hidden' value='"+p_patient_id+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.Dummy.submit();
	}

function Populate_Main_Details11111()
{
	var p_patient_id = document.forms[0].p_id_patient_id.value;
	HTMLVal = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action='../../eAE/jsp/UnknownDetailsPopulate.jsp'><input name='p_patient_id' id='p_patient_id' type='hidden' value='"+p_patient_id+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.Dummy.submit();
}


function reset()
{
	parent.frames[2].frames[1].location.href = '../../eAE/jsp/UpdateUnknownDetails.jsp';
}
function onSuccess(){}

function later_Click11()
{
	var Obj=document.forms[0].start_later_time;
	if(Obj.value != '') 
	{
		if(!validDate(Obj.value,'DMYHM',localeName))
			{
				   alert(getMessage("INVALID_DATE_TIME",'SM'))
				   //Obj.select();
				   Obj.value="";
				   
			}
			else
			{
				if((!isAfterNow(Obj.value,'DMYHM',localeName)))
				{
					alert(getMessage("DT_NLT_CURR_DT",'SM'))
					//Obj.select();
					Obj.value="";
				}
			}
	}
}

//////////////////////
function start_process_merge(obj)
{
		
		var process=document.forms[0].process.value;
		var patient_id=document.forms[0].patient_id.value;
		var p_id_patient_id=document.forms[0].p_id_patient_id.value;
	if(patient_id!='' && p_id_patient_id!='')
	{
		if(process=="start_now")
		{  
		   document.forms[0].process_start.value="process_now";
		   document.forms[0].submit();
		}
		else if(process=="start_later")
		{	
			document.forms[0].process_start.value="process_later";
			document.forms[0].action='../../servlet/eAE.UpdateUnknownDetailsServlet';
			document.forms[0].target="messageFrame";
			document.UpdateUnknownDetails.submit();
        }
	    }
	  else 
	{	  
	  if(patient_id=='' && p_id_patient_id=='')
		{
			alert(getMessage("BOTH_PAT_ID_CANNOT_BLANK",'AE'))

		}
		else  if (patient_id=='')
		{
			alert(getMessage("BOTH_PAT_ID_CANNOT_BLANK",'AE'))
		}
		else 
		{
			alert(getMessage("NEW_PAT_ID_CANNOT_BLANK",'AE'))
		}
	}
	
}

function start_nowClick() 
{
	var eveObj=event.target;
	document.forms[0].process.value="start_now";
	start_process_merge(eveObj);
	
}
function later_Click()
{
	if(document.forms[0].start_later_time.value=="")
	{
	  errors = getMessage("DATE_TIME_NOT_BLANK",'DR');
	  alert(errors);
	}
	else
	{
        if(!validDate(document.forms[0].start_later_time.value,'DMYHM',localeName))
		{
			   alert(getMessage("INVALID_DATE_TIME",'SM'))
			   document.forms[0].start_later_time.select();
			   //document.forms[0].start_later_time.value="";
		}
		else
		{
			
			if((!isAfterNow(document.forms[0].start_later_time.value,'DMYHM',localeName)))
			{
				alert(getMessage("DT_NLT_CURR_DT","SM"));
				document.forms[0].start_later_time.select();
				//document.forms[0].start_later_time.value="";
			}
			else
			{    
				 document.forms[0].process.value="start_later";
				 var srcObj=event.target;
				 
				 start_process_merge(srcObj);
			}
		}
	}
}


