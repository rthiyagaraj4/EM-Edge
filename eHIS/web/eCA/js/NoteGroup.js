/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
20/07/2018	IN067717		Ramesh G	20/07/2018		Ramesh G			ML-MMOH-CRF-0898.1
---------------------------------------------------------------------------------------------------------------
*/
function create()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/NoteGroupAddModify.jsp?mode=insert';
}

function query()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/NoteGroupQueryCriteria.jsp';
}

 function apply()
 {
	var mode = f_query_add_mod.document.forms[0].mode


	  if(f_query_add_mod.document.forms[0].transcription_yn.checked==true)
		{
		  var fields = new Array (f_query_add_mod.document.forms[0].note_group_id,
							f_query_add_mod.document.forms[0].note_group_desc,
							f_query_add_mod.document.forms[0].applic_task,
							f_query_add_mod.document.forms[0].report_header,
							f_query_add_mod.document.forms[0].cutoff_period
							
							);

		 var names = new Array ( f_query_add_mod.getLabel("Common.identification.label",'common'),
							f_query_add_mod.getLabel("Common.description.label",'common'),
							f_query_add_mod.getLabel("eCA.ApplicableTask.label",'CA'),
							f_query_add_mod.getLabel("eCA.ReportHeader.label",'CA'),		f_query_add_mod.getLabel("eCA.CutoffPeriodToAllowTrans.label",'CA')
						);
		}
		else
	  {
			  fields = new Array (f_query_add_mod.document.forms[0].note_group_id,
							f_query_add_mod.document.forms[0].note_group_desc,
							f_query_add_mod.document.forms[0].applic_task,
							f_query_add_mod.document.forms[0].report_header
							
							);

		     names = new Array ( f_query_add_mod.getLabel("Common.identification.label",'common'),
							f_query_add_mod.getLabel("Common.description.label",'common'),
							f_query_add_mod.getLabel("eCA.ApplicableTask.label",'CA'),
							f_query_add_mod.getLabel("eCA.ReportHeader.label",'CA')	
						);
		  
	  }


	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{			
		
	
        if(mode != null)
		{
			if(mode.value=='update')
			{
				f_query_add_mod.document.forms[0].note_group_id1.value= f_query_add_mod.document.forms[0].note_group_id.value
				f_query_add_mod.document.forms[0].note_group_desc1.value= f_query_add_mod.document.forms[0].note_group_desc.value
				f_query_add_mod.document.forms[0].applic_task1.value= f_query_add_mod.document.forms[0].applic_task.value
				f_query_add_mod.document.forms[0].note_encounter1.value= f_query_add_mod.document.forms[0].note_encounter.value
				//if(f_query_add_mod.document.forms[0].role_base.checked == true)
					//f_query_add_mod.document.forms[0].role_base1.value= 'Y'
				//else
					//f_query_add_mod.document.forms[0].role_base1.value= 'N'
				f_query_add_mod.document.forms[0].precondition_recording1.value= f_query_add_mod.document.forms[0].precondition_recording.value
				f_query_add_mod.document.forms[0].report_header1.value= f_query_add_mod.document.forms[0].report_header.value
				//f_query_add_mod.document.forms[0].disclimer_text1.value= f_query_add_mod.document.forms[0].disclaimer_text.value
				f_query_add_mod.document.forms[0].system_user_define1.value= f_query_add_mod.document.forms[0].system_user_define.value
			  if(f_query_add_mod.document.forms[0].transcription_yn.checked==true)
			   {
				f_query_add_mod.document.forms[0].cutoff_period.value= f_query_add_mod.document.forms[0].cutoff_period.value
			   }
			}
		}
		   if(f_query_add_mod.document.forms[0].transcription_yn.checked==true)
			{
				f_query_add_mod.document.forms[0].transcription_yn.value = 'Y' ;
				f_query_add_mod.document.forms[0].cutoff_period.disabled=false ;
			}
			else
			{
				f_query_add_mod.document.forms[0].transcription_yn.value = 'N' ;		
				f_query_add_mod.document.forms[0].cutoff_period.disabled=true ;
				
			}
		 f_query_add_mod.document.forms[0].cutoff_period.disabled=false ;
		 f_query_add_mod.document.notegroup_form.submit();		

	}
 }


function deleterecord()
{
	if(f_query_add_mod.document.forms[0]!=null )
	{
		if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"){
			//commontoolbarFrame.location.reload();
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("RECORD_CANNOT_DELETE","CA")
			}
			else{
				if(window.confirm(getMessage("DELETE_RECORD","Common")) == true)
				{
					f_query_add_mod.document.notegroup_form.mode.value='delete';
					f_query_add_mod.document.notegroup_form.submit();     
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
		}
		else
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
} 	


function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/NoteGroupAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{   
		f_query_add_mod.location.href='../../eCA/jsp/NoteGroupAddModify.jsp?mode=update&note_group_id='+f_query_add_mod.document.forms[0].note_group_id.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.location.reload();

}
function checkForMode(objCheck)
{
	var mode = document.forms[0].mode.value;
	
	if(mode == 'update')
	{
		
		if(objCheck.checked== true)
		{
			document.forms[0].eff_status1.value='E'
		}
		else
		{
			document.forms[0].eff_status1.value='D'
		}
	}
}

function checkForMinus(obj)
{
	if(obj.value != '')
	{
		if(obj.value.indexOf("-") > -1)
		{
			//alert("APP-CA00034 Negative values are not allowed");
			alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"))
			obj.select();
			return false;
		}
		if(parseInt(obj.value,10)  == 0)
		{
				//alert("APP-CA00035  values should be greater than zero");
				alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
				obj.select();
				return false;
		}
	}
	/*if(obj.value.length > 0)
	{
		return true;
	}
	else
	{
		alert("APP-CA00035  values should be greater than zero");
		obj.select();
		return false;
	}
	if(obj.value.indexOf("-")!=-1)
	{
		alert("APP-CA00034 Negative values are not allowed");
		
		obj.select();
		return false;
	}*/
}


function checkdefalultdesc()
{
	
	if(document.forms[0].report_header.value=="")
	{
		
        var text_value  =   document.forms[0].note_group_desc.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    document.forms[0].note_group_desc.value = text_value;

	document.forms[0].report_header.value=document.forms[0].note_group_desc.value;

			
	}
	
	
}
function checkForMaxCharacter(objTextArea)
{

	if(objTextArea.value != '')
	{
		if(objTextArea.value.length > 200)
		{
			return false
		}
			else
			return true
	}

}

function checkForTranscription(obj)
{
	if(obj.checked)
	{
		document.getElementById("tdchecktranscription").style="display";
		document.forms[0].transcription_yn.value = 'Y'
		document.forms[0].cutoff_period.disabled=false;
	}
	else
	{
		document.getElementById("tdchecktranscription").style.display = 'none';
		document.forms[0].transcription_yn.value = 'N'
		document.forms[0].cutoff_period.value="";			
		document.forms[0].cutoff_period.disabled=true;

	}
}

function transApplicable(obj)
{
	var desc=obj.value;
    var objArr = desc.split("~");
    var appl_task_id = objArr[0];
    var transcription_yn = objArr[1];
   if(transcription_yn == 'Y')
   {
	document.getElementById("transcription").style="display";
	document.forms[0].transcription_yn.checked=false;
	//document.forms[0].cutoff_period.disabled=false;
	document.forms[0].cutoff_period.disabled=true;
	document.forms[0].cutoff_period.value='';
	document.forms[0].transcription_yn.disabled=false;
   }
  else
  {
	document.getElementById("transcription").style.display = 'none';
	document.forms[0].transcription_yn.checked=false;
	document.forms[0].cutoff_period.disabled=true;
	document.forms[0].transcription_yn.disabled=true;
  }
//IN067717 starts
 if(appl_task_id=='BIRTH_REG_NOTES'){
	document.forms[0].note_encounter.disabled=true;
	document.forms[0].precondition_recording.disabled=true;
    
  }
  else{
	document.forms[0].note_encounter.disabled=false;
	document.forms[0].precondition_recording.disabled=false;
  }
//IN067717 ends
}

function CheckForNums(event){
    var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function DisplayTrans(){
	var desc =document.forms[0].applic_task.value;
    var objArr = desc.split("~");
    var appl_task_id = objArr[0];
    var transcription_yn1 = objArr[1];
    var transcription_yn = document.forms[0].transcription_yn.value;
   if(transcription_yn1 == 'Y')
  {
	if(transcription_yn == 'Y')
    {
	document.getElementById("tdchecktranscription").style="display";
	document.getElementById("transcription").style="display";
	document.forms[0].transcription_yn.checked=true;
	document.forms[0].cutoff_period.disabled=false;
	document.forms[0].transcription_yn.disabled=false;
   }
   else
   {
    document.getElementById("tdchecktranscription").style.display = 'none';
	document.getElementById("transcription").style="display";
	document.forms[0].transcription_yn.checked=false;
	document.forms[0].cutoff_period.disabled=true;
	document.forms[0].transcription_yn.disabled=false;
   }
 }
 else
	{
	 document.getElementById("transcription").style.display = 'none';
	//document.forms[0].transcription_yn.checked=false;
	///document.forms[0].cutoff_period.disabled=true;
    //document.forms[0].transcription_yn.disabled=false;
	}
}
/*function makeValidString(obj)
{
 	if(obj.value.indexOf('0')==0)
	{
		alert("obj.indexOf(0)"+obj.value.indexOf(0));
		alert("cannot be zero");
		return false;
	}

	 if(obj.value <=0)
	{
		alert("cannot be zero");
		obj.focus();
	}
}*/

