function reset() 
{
	f_query_add_mod.document.location.reload() ;
}

function apply()
{
 if(eval(f_query_add_mod.document.qaparameter_form.encounteripTo.value)>eval(f_query_add_mod.document.qaparameter_form.encounteripFrom.value))
 {
	errorMessage= messageArray["CHECKPERIODFROMTO"];
	alert(errorMessage);
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	return 
 }
 if (eval(f_query_add_mod.document.qaparameter_form.encounteropTo.value)>eval(f_query_add_mod.document.qaparameter_form.encounteropFrom.value))
 {
	errorMessage= messageArray["CHECKPERIODFROMTO"];
	alert(errorMessage);
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	return 
 }
 if(eval(f_query_add_mod.document.qaparameter_form.encounterdcTo.value)>eval(f_query_add_mod.document.qaparameter_form.encounterdcFrom.value))
 {
	errorMessage= messageArray["CHECKPERIODFROMTO"];
	alert(errorMessage);
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	return 
 }
 if(eval(f_query_add_mod.document.qaparameter_form.encounteremTo.value)>eval(f_query_add_mod.document.qaparameter_form.encounteremFrom.value))
 {
	errorMessage= messageArray["CHECKPERIODFROMTO"];
	alert(errorMessage);
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	return 
 }
 if(eval(f_query_add_mod.document.qaparameter_form.encounterxtTo.value)>eval(f_query_add_mod.document.qaparameter_form.encounterxtFrom.value))
 {
	errorMessage= messageArray["CHECKPERIODFROMTO"];
	alert(errorMessage);
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	return 
  }
  f_query_add_mod.document.qaparameter_form.submit();
}

function onSuccess() 
{
   f_query_add_mod.document.location.reload();
}

function checkSequence(objSequence)
{
  var errorMessage =""
  if(eval(objSequence.value) <= 0)
  {
	errorMessage= messageArray["SEQUENCE_NOT_ZERO"];
	alert(errorMessage);
	objSequence.value=''
	objSequence.select()
	return false
  }
  if(objSequence.value.charAt(0) == '-'||objSequence.value.charAt(1) == '-')
  {
	errorMessage= messageArray["SEQUENCE_NOT_ZERO"];
	alert(errorMessage);
	objSequence.value=''
	objSequence.select()
	return false
  }
}

function chkValue(obj)
{
  if(obj.checked==true)
  {
  	obj.checked=true;
	obj.value='Y';
  }
  else
  {
    obj.checked=false;
    obj.value='N';
  }
}