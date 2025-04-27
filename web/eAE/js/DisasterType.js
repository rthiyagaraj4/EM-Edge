function onSuccess() 
 {
  	 if(f_query_add_mod.document.disaster_type_form.mode.value=="INSERT")
	 {
		f_query_add_mod.document.disaster_type_form.disaster_type_code.value   = "";
		f_query_add_mod.document.disaster_type_form.short_desc.value			= "";
		f_query_add_mod.document.disaster_type_form.long_desc.value			= "";
		f_query_add_mod.document.disaster_type_form.eff_status.checked			= true;
		f_query_add_mod.document.disaster_type_form.disaster_type_code.focus();
	 }
	 else
		 f_query_add_mod.document.location.reload();

 }

function create() 
{ 
    f_query_add_mod.location.href ="../../eAE/jsp/AddModifyDisasterType.jsp" ;
}

function query() 
 {
	f_query_add_mod.location.href ="../../eAE/jsp/DisasterTypeQueryCriteria.jsp" ;
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
	 var fields = new Array (f_query_add_mod.document.disaster_type_form.disaster_type_code,
 		 f_query_add_mod.document.disaster_type_form.long_desc,
		 f_query_add_mod.document.disaster_type_form.short_desc);
        
	var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));	
	// FOR SPECIAL CHARACTERS  CHECK
	var fields1 = new Array (f_query_add_mod.document.disaster_type_form.disaster_type_code);
	var names1 = new Array (getLabel("Common.code.label","Common"));	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
		if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
		{
			f_query_add_mod.document.disaster_type_form.submit();
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
		 document.forms[0].disaster_type_code.value=obj.value.toUpperCase();
	}
