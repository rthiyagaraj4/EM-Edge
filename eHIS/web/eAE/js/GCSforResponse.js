/*function reset() 
   {
		f_query_add_mod.document.forms[0].reset() ;
   } */
   function reset() 
  {
		if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset() ;
  } 
   function query()
   {
	   f_query_add_mod.document.location.href='../../eAE/jsp/GCSQueryResult.jsp';
   }
/*   function query()
   {
	   document.location.href='../../eAE/jsp/GCSQueryResult.jsp';
   }*/
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
	   var fields = new Array (f_query_add_mod.document.gcs_form.gcs_desc.value);
       var names = new Array ("GCS Desc");	
	   /*alert("GCS Desc : "+fields);
	   if(fields == null || fields == "" || fields == "")
	   {
	     alert("APP-000001 GCS Desc cannot be blank...");
	   } else {
		   f_query_add_mod.document.gcs_form.submit(); 
	   }*/

	    var errors = "" ;
		if(fields == null || fields == "" || fields == "") {	
			var msg=getMessage("CAN_NOT_BE_BLANK",'Common');
			msg=msg.replace("$",getLabel('eAE.GCSDescription.label','AE'));
			errors = errors + msg ;
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		}
		else
	   {
			f_query_add_mod.document.gcs_form.submit(); 
	   }
	   /*if(checkFields( fields, names, messageFrame))
	   {
			f_query_add_mod.document.gcs_form.submit(); 
	   }*/
   }
   function onSuccess()
	{
		//			document.location.reload();
		f_query_add_mod.document.location.reload()
	}
