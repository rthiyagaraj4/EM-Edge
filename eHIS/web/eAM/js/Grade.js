 



function create() 
{	
	
	f_query_add_mod.location.href = "../../eAM/jsp/GradeAdd.jsp?function_id="+document.forms[0].function_id.value+"" ;
	
}

function query() 
{		
	f_query_add_mod.location.href ="../../eAM/jsp/GradeQueryPage.jsp?function=grade&function_id="+document.forms[0].function_id.value+"";
	return true;
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
    var fields = new Array (f_query_add_mod.document.grade_form.grade_code,
							f_query_add_mod.document.grade_form.long_desc,
							f_query_add_mod.document.grade_form.short_desc
						   );
	var names = new Array ( getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common")
					      );

	var spFields = new Array (f_query_add_mod.document.grade_form.grade_code);
	var spNames = new Array (getLabel("Common.code.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			f_query_add_mod.document.grade_form.submit();

		}
	}

function onSuccess() 
{
	 if(f_query_add_mod.document.grade_form.function_name.value == "insert")
	  {		 
		f_query_add_mod.document.grade_form.grade_code.value	= "" ;
		f_query_add_mod.document.grade_form.short_desc.value		= "" ;
		f_query_add_mod.document.grade_form.long_desc.value		= "" ;
		f_query_add_mod.document.grade_form.eff_status.checked	= true ;	
		f_query_add_mod.document.grade_form.grade_code.select();
		 }
	else
		if(f_query_add_mod.document.grade_form.function_name.value == "modify")
			f_query_add_mod.document.location.reload();
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.location.reload();
}



	function Change1(){ 
      	 if (grade_form.eff_status.checked == true)
	      	 	grade_form.eff_status.value	=	"E";
	      	 else
      		    grade_form.eff_status.value	=	"D";     	      	
      	}      	
      	

function CheckForSpecCharacs(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


