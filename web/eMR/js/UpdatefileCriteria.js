

async function callSearchScreen()
{
	var patientid= await PatientSearch('','','','','','','Y','','','VIEW');
	
		if(patientid !=null)
		document.forms[0].PatientId.value = patientid; 
		document.forms[0].PatientId.focus();
	
}


function clearAll()
{
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}

function submitPage()
{/*
	var continue_yn = "Y";
			if(document.forms[0].PatientId.value == '')
			{	continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.patientId.label","Common"));
			alert(error);
			document.forms[0].PatientId.focus();
			}
				*/

	//if(continue_yn == "Y")
	//{  
	    var file_no = document.forms[0].file_no.value;
	    var patient_id = document.forms[0].PatientId.value;
		var old_file_no = document.forms[0].old_file_no.value;
		parent.frames[2].location.href= '../../eMR/jsp/UpdatefileResult.jsp?Patient_Id='+patient_id+'&file_no='+file_no+'&old_file_no='+old_file_no;
					
	//}
}
		



function PatValidations(obj)
{	
	if(document.forms[0].PatientId.value!='')
	{
	    var fields = new Array (document.forms[0].PatientId); 
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].PatientId.value;
		var error_jsp="";
		var messageFrame="";
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='called_from' id='called_from' value=''><input type='hidden' name='call_function' id='call_function' value='UPDATE_FILE_DETAILS'></form></BODY></HTML>";
		//call_function added by Dharma on 20th Feb 2018 against for ML-MMOH-SCF-0919 [IN:066388]
	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();
	}
}



