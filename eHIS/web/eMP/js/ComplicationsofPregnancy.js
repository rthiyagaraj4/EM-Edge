function create() { 
	f_query_add_mod.location.href = "../../eMP/jsp/ComplicationsofPregnancy.jsp?function_id="+document.forms[0].function_id.value+"" ;
}

function query() {
   f_query_add_mod.location.href ="../../eMP/jsp/ComplicationsofPregnancyQueryPage.jsp?function_id="+document.forms[0].function_id.value+"";
}

function reset() {
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset() ;
}

function onSuccess() {
	f_query_add_mod.location.reload();
}



function apply() {
	
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	
	var fields = new Array ( f_query_add_mod.document.compln_preg_form.compln_pregnancy_code,
						f_query_add_mod.document.compln_preg_form.long_desc,
						f_query_add_mod.document.compln_preg_form.short_desc

					    );
	var names = new Array ( getLabel('Common.code.label','common'),
						getLabel('Common.longdescription.label','common'),
						getLabel('Common.shortdescription.label','common')

					      );
	
	var splField = new Array (f_query_add_mod.document.compln_preg_form.compln_pregnancy_code);
	var splFieldName = new Array (getLabel('Common.code.label','common'));

	f_query_add_mod.document.compln_preg_form.rel_to_preg.disabled=false;
	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {		
			
				f_query_add_mod.document.compln_preg_form.submit() ;
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

function checkForRelPreg(){ 
	 if (compln_preg_form.rel_to_preg.checked == true)
	      	 	compln_preg_form.rel_to_preg.value	=	"Y";
	      	 else
      		    compln_preg_form.rel_to_preg.value	=	"N";     	      	
}

function Change1(){ 
      	 if (compln_preg_form.eff_status.checked == true)
	      	 	compln_preg_form.eff_status.value	=	"E";
	      	 else
      		    compln_preg_form.eff_status.value	=	"D";     	      	
      	}     

function CheckSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode );
	return true ;
}

