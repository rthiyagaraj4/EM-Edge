function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/TemplateReportListAddModify.jsp?mode=insert';
}

function query()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/TemplateReportListQueryCriteria.jsp';
}

 function apply()
 {
	var mode = f_query_add_mod.document.forms[0].mode
	var fields = new Array (f_query_add_mod.document.forms[0].report_name,
							f_query_add_mod.document.forms[0].report_type,
							f_query_add_mod.document.forms[0].default_age_group,
							f_query_add_mod.document.forms[0].eff_status
							);
								
	var names = new Array ( f_query_add_mod.getLabel("Common.reportname.label",'common'),
	f_query_add_mod.getLabel("Common.reporttype.label",'common'),
	f_query_add_mod.getLabel("eCA.DefaultAgeGrp.label",'eCA'),
	f_query_add_mod.getLabel("Common.enabled.label",'common')
	);

	

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{			
		
	
        if(mode != null)
		{
			if(mode.value=='update')
			{
				f_query_add_mod.document.forms[0].report_name1.value= f_query_add_mod.document.forms[0].report_name.value;
				f_query_add_mod.document.forms[0].report_type1.value= f_query_add_mod.document.forms[0].report_type.value;
				f_query_add_mod.document.forms[0].default_value.value= f_query_add_mod.document.forms[0].default_value.value;
				f_query_add_mod.document.forms[0].eff_status1.value= f_query_add_mod.document.forms[0].eff_status.value;
				
				
				
				alert("Hello");
				alert(f_query_add_mod.document.forms[0].report_name1.value);
				alert(f_query_add_mod.document.forms[0].report_type1.value);
				alert(f_query_add_mod.document.forms[0].default_value.value);
				alert(f_query_add_mod.document.forms[0].eff_status1.value);
				}
		}
		   
		 
		 f_query_add_mod.document.forms[0].submit();		

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
					f_query_add_mod.document.template_form.mode.value='delete';
					f_query_add_mod.document.template_form.submit();     
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
		f_query_add_mod.location.href='../../eCA/jsp/TemplateReportListAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{   
		f_query_add_mod.location.href='../../eCA/jsp/TemplateReportListAddModify.jsp?mode=update&note_group_id='+f_query_add_mod.document.forms[0].note_group_id.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();

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
		document.forms[0].transcription_yn.value = 'Y'
		document.forms[0].cutoff_period.disabled=false;
	}
	else
	{
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
	document.getElementById("transcription").style.display = 'inline';
	document.forms[0].transcription_yn.checked=true;
	document.forms[0].cutoff_period.disabled=false;
	document.forms[0].transcription_yn.disabled=false;
   }
  else
  {
	document.getElementById("transcription").style.display = 'none';
	document.forms[0].transcription_yn.checked=false;
	document.forms[0].cutoff_period.disabled=true;
	document.forms[0].transcription_yn.disabled=true;
  }

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
	document.getElementById("transcription").style.display = 'inline';
	document.forms[0].transcription_yn.checked=true;
	document.forms[0].cutoff_period.disabled=false;
	document.forms[0].transcription_yn.disabled=false;
   }
   else
   {
	document.getElementById("transcription").style.display = 'inline';
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

function Lookupwindow(target,code)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = "Select AGE_GROUP_CODE code, SHORT_DESC description from am_age_group Where eff_status = 'E' AND upper(AGE_GROUP_CODE) LIKE  UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) order by 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( getLabel("Common.referral.label","COMMON"), argumentArray );
       
	   
	    if(retVal != null && retVal != "")
		{
			target.value = retVal[1];
			code.value =retVal[0] ;
		}
		else
		{
			target.value = "";
			code.value = "" ;
		}
		alert("target"+target.value);
		alert("code"+code.value);
}
