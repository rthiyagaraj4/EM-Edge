
function query() 
 {
	f_query_add_mod.location.href ="../../eAE/jsp/PriorityZoneQueryCriteria.jsp" ;
 }
function reset()  
  {
     if(f_query_add_mod.document.forms[0])
    f_query_add_mod.document.location.reload();
		
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
	 var fields = new Array (f_query_add_mod.document.priority_zone_form.priority_zone,
 		 f_query_add_mod.document.priority_zone_form.priority_zone_desc,
		 f_query_add_mod.document.priority_zone_form.priority_zone_tab_desc);
        
	var names = new Array (getLabel("eAE.PriorityZoneCode.label","eAE"),getLabel("eAE.PriorityZoneColorDesc.label","eAE"),getLabel("eAE.PriorityZoneTabDesc.label","eAE"));	
	// FOR SPECIAL CHARACTERS  CHECK
	var fields1 = new Array (f_query_add_mod.document.priority_zone_form.priority_zone);
	var names1 = new Array (getLabel("eAE.PriorityZoneCode.label","eAE"));	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
		if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
		{
			f_query_add_mod.document.priority_zone_form.submit();
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
		 document.forms[0].priority_zone.value=obj.value.toUpperCase();
	}
function onSuccess() 
 {
   
		 f_query_add_mod.document.location.reload();

 }
 //Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147 start
 function chkEffStatus(obj)
   {
	  if(obj.checked==true)
       {
		  	obj.checked=true;
			document.priority_zone_form.eff_status.value='E';
       }
      else
       {
			obj.checked=false;
			document.priority_zone_form.eff_status.value='D';
       }
   } 
 
function chkPatCount(obj){
	if(document.priority_zone_form.patient_count.value>0){
		var err = getMessage('PRIORITY_ZONE_ALREADY_AVAIL','AE');
		alert(err);
		obj.checked=true;
		obj.value="E";
		document.priority_zone_form.eff_status.value='E';
	}
}
//END
