function onSuccess() 
 {
  	 if(f_query_add_mod.document.anatomical_site.mode.value=="INSERT")
	 {
		f_query_add_mod.document.anatomical_site.anatomical_site_code.value		= "";
		f_query_add_mod.document.anatomical_site.short_desc.value				= "";
		f_query_add_mod.document.anatomical_site.long_desc.value				= "";
		f_query_add_mod.document.anatomical_site.applicable_to_iss_yns.checked	= false;
		f_query_add_mod.document.anatomical_site.applicable_to_iss_yns.value	= "";
		f_query_add_mod.document.anatomical_site.oral_cavity_yns.checked		= false;
		f_query_add_mod.document.anatomical_site.oral_cavity_yns.value			= "";
		f_query_add_mod.document.anatomical_site.eff_status.checked				= true;
		f_query_add_mod.document.anatomical_site.anatomical_site_code.focus();
	 }
	 else
	 {
		f_query_add_mod.document.location.reload();
	 }
 }

function create()
{
		f_query_add_mod.location.href ="../../eAM/jsp/addModifyAnatomicalSite.jsp" ;
}

function query()
 {
		f_query_add_mod.location.href ="../../eAM/jsp/AnatomicalSiteQueryCriteria.jsp" ;
 }
function reset() 
  {
	f_query_add_mod.document.location.reload();
	//f_query_add_mod.document.forms[0].reset() ;
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
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	f_query_add_mod.document.anatomical_site.applicable_to_iss_yn.value = f_query_add_mod.document.anatomical_site.applicable_to_iss_yns.value;
	f_query_add_mod.document.anatomical_site.oral_cavity_yn.value = f_query_add_mod.document.anatomical_site.oral_cavity_yns.value;
  	 var fields = new Array (f_query_add_mod.document.anatomical_site.anatomical_site_code,
 		 f_query_add_mod.document.anatomical_site.long_desc,
		 f_query_add_mod.document.anatomical_site.short_desc);
        
	var names = new Array ( getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
					        getLabel("Common.shortdescription.label","Common"));	
	// FOR SPECIAL CHARACTERS  CHECK
	var fields1 = new Array (f_query_add_mod.document.anatomical_site.anatomical_site_code);
	var names1 = new Array (getLabel("Common.code.label","Common"));
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
			if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
		{
			f_query_add_mod.document.anatomical_site.submit();
		}
	 }
}

  function chkValue(obj)
   {
	  if(obj.checked==true)
       {
		  if(obj.name=="eff_status")
		   {
		  		obj.checked=true;
				obj.value='E';
		   }
          else
		   {
				obj.checked=true;
				obj.value='Y';
		   }
		   
       }
      else
       {
		   if(obj.name=="eff_status")
		   {
				obj.checked=false;
				obj.value='D';
		   }
		   else
		   {
				obj.checked=false;
				obj.value='N';
		   }
       }

   }

   function changeCase(obj)
	{
		 obj.value=obj.value.toUpperCase();
	}
