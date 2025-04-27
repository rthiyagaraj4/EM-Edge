var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var flagChk = false;
var currentTab ="";


/*****************initailisation*************************************/
function intialisation(){
 currentTab ="";
 resultGlobal = false;
 messageGlobal = "" ;
 flagGlobal = true;
 flagChk = false;
}
/*******************************************************************/
 function create()
{
  	intialisation();
    f_query_add_mod.location.href ="../../eAE/jsp/AMBTypeCodeAddModify.jsp" ;
}

function query()
 {
	f_query_add_mod.location.href ="../../eAE/jsp/AMBTypeCodeQueryCriteria.jsp" ;
 }
 
function reset() 
  {
	  if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.location.reload() ;
		intialisation();
	 } 

  function apply()
{
		if (! checkIsValidForProceed() ) {
		   //var message  = getMessage("NOT_VALID","AE");	
            messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
            return false;			
			
		}

		var fields = new Array ( f_query_add_mod.document.amb_type_form.amb_service_type	, f_query_add_mod.document.amb_type_form.long_desc,
					 f_query_add_mod.document.amb_type_form.short_desc	   );
		
		var names = new Array(getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));
			if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
		var fields1 = new Array (f_query_add_mod.document.amb_type_form.amb_service_type	 );
			var names1  = new Array (getLabel("Common.code.label","Common")	);
			if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.amb_type_form.submit();
			}	
		}
	
}
 function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		 
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
} 
 function onSuccess()
{	

	if(f_query_add_mod.document.forms[0].mode.value=="insert"){
		f_query_add_mod.location.href="../../eAE/jsp/AMBTypeCodeAddModify.jsp";
		
	}else
	 {
		f_query_add_mod.document.location.reload();
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
