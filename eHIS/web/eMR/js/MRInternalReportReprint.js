function codeCheck(obj)
{
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	if(obj.value=='')
	{
		parent.criteriaFrame.location.href='../../eCommon/html/blank.html';
		parent.resultFrame.location.href='../../eCommon/html/blank.html';
	}
	else
	{

		parent.criteriaFrame.location.href ="../../eMR/jsp/MedRecRequestCriteria.jsp?call_function="+document.forms[0].call_function.value+"&function_id="+document.forms[0].call_function.value+"&reportname="+document.forms[0].ReportName.value;
		parent.resultFrame.location.href='../../eCommon/html/blank.html';
	}
}

function reset()
{
	searchFrame.document.forms[0].reset();
	criteriaFrame.location.href='../../eCommon/html/blank.html';
	resultFrame.location.href='../../eCommon/html/blank.html';
}
