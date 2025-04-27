function query()
  {

	f_query_add_mod.location.href ="../../eSM/jsp/ProcQueryCriteria.jsp" ;

  }

  function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) )
        return true;
    else
        return false;
 }

function reset()
   {
		
		if(f_query_add_mod.document.forms[0]){
	  if (! (checkIsValidForProceed()) )
      {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
      } 

    if(  f_query_add_mod.document.forms[0].name == "Menuadmin_Form")
     //    f_query_add_mod.document.forms[0].reset() ;
         f_query_add_mod.document.location.reload();
       else if(f_query_add_mod.document.forms[0].name == "query_form" )
		//f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();

	else
	   {
      //   f_query_add_mod.document.query_form.reset() ;
         f_query_add_mod.document.location.reload();
	   }
	   }else{
			return false;
	   }
    }


