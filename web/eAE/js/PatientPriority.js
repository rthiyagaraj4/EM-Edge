function onSuccess() 
 {
  	 /*if(f_query_add_mod.document.patient_priority.mode.value=="INSERT")
	 {
		f_query_add_mod.document.patient_priority.priority_code.value			= "";
		f_query_add_mod.document.patient_priority.short_desc.value				= "";
		f_query_add_mod.document.patient_priority.long_desc.value				= "";
		f_query_add_mod.document.patient_priority.priority_no.value				= "";
		f_query_add_mod.document.patient_priority.eff_status.checked			= true;
		f_query_add_mod.document.patient_priority.priority_code.focus();
	 }
	 else
	 {*/
		f_query_add_mod.document.location.reload();
	/* }*/

 }

function create()
{
		f_query_add_mod.location.href ="../../eAE/jsp/addModifyPatientPriority.jsp" ;
}

function query()
 {
		 f_query_add_mod.location.href ="../../eAE/jsp/PatientPriorityQueryCriteria.jsp" ;
 }
function reset() 
  {
		if(f_query_add_mod.document.forms[0])
		//	parent.frames[1].frames[1].location.reload();
		f_query_add_mod.document.forms[0].reset() ;
  } 

function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
 }




function apply()
{ 


	 if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	 
	f_query_add_mod.document.patient_priority.priority_zone.value = f_query_add_mod.document.patient_priority.priority_zone1.value;
  	 var fields = new Array (f_query_add_mod.document.patient_priority.priority_code,
 		 f_query_add_mod.document.patient_priority.long_desc,
		 f_query_add_mod.document.patient_priority.short_desc,
		 f_query_add_mod.document.patient_priority.priority_zone);//Modified by shanmukh for MMS-DM-CRF-0147
        
	var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("eAE.PatientPriority.label","AE"));	
	// FOR SPECIAL CHARACTERS  CHECK
	var fields1 = new Array (f_query_add_mod.document.patient_priority.priority_code);
	var names1 = new Array (getLabel("Common.code.label","Common"));
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
		if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
		{
			f_query_add_mod.document.patient_priority.submit();
		}		
	 }
}

  function chkValue(obj)
   {
	  if(obj.checked==true)
       {
		  	obj.checked=true;
			obj.value='E';
       }
      else
       {
			obj.checked=false;
			obj.value='D';
       }
   }

function changeCase(obj)
{
	document.forms[0].priority_code.value=obj.value.toUpperCase();
}
