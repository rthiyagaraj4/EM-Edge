function query() {
       	f_query_add_mod.location.href ="../../eSM/jsp/queryDefaultOnlinePrint.jsp";
}


function apply() {	

		if(f_query_add_mod.document.dflt_online_print_form){
		var proceed=true;
		var errors="";
		 
		if(f_query_add_mod.document.dflt_online_print_form.Module && f_query_add_mod.document.dflt_online_print_form.Module.value ==""){
			proceed = false;
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common"); 
			errors = errors.replace('$',f_query_add_mod.getLabel("Common.Module.label","Common"));
			alert(errors)
		}
		if (proceed && f_query_add_mod.document.dflt_online_print_form.Function && f_query_add_mod.document.dflt_online_print_form.Function.value =="" )
		{
			proceed = false;
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common"); 
			errors = errors.replace('$',f_query_add_mod.getLabel("Common.Function.label","Common"));
			alert(errors)
		}
		if (proceed && f_query_add_mod.document.dflt_online_print_form.Report && f_query_add_mod.document.dflt_online_print_form.Report.value =="" )
		{
			proceed = false;
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common"); 
			errors = errors.replace('$',f_query_add_mod.getLabel("Common.report.label","Common"));
			alert(errors)
		}
		if(proceed){
			f_query_add_mod.document.dflt_online_print_form.action='../../servlet/eSM.DefaultOnlinePrintServlet';
			f_query_add_mod.document.dflt_online_print_form.submit();	
		}else{
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="
		}
	}else{
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="
	}
}


function reset() {
	   if(f_query_add_mod.document.forms[0] )
			f_query_add_mod.document.location.reload();
}

function onSuccess() {
      	f_query_add_mod.location.reload();
}

function checkFields1( fields, names, messageFrame) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common"); 
			errors = errors.replace('$',names[i]);
			alert(errors);
			fields[i].focus();

		}	
	}
	/*if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return false ;
	}else{
	return true ;
	}*/
}
