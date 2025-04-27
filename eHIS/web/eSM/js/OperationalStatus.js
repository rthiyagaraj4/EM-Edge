function create()
{
	f_query_main.location.href = "../../eSM/jsp/OperationalStatusMain.jsp";
	f_query_header.location.href = "../../eCommon/html/blank.html";
	f_query_details.location.href = "../../eCommon/html/blank.html";
}

function reset()
{
	if(f_query_details.document.forms[0]!=null){
	f_query_header.document.forms[0].reset();
	f_query_details.location.href = "../../eCommon/html/blank.html"
	}else
	{
		if(f_query_header.document.forms[0]){
		f_query_header.document.forms[0].reset();
		frames[0].location.reload();
		return false;
		}
	}
}

function apply()
{
	
	if(f_query_details.document.forms[0]!=null){
		f_query_header.document.forms[0].opermodules.value = f_query_details.document.forms[0].ModuleIDs.value+"$"+f_query_details.document.forms[0].ModuleVals.value;

	    f_query_header.document.forms[0].submit();
	}else
	{
		frames[0].location.reload();
		return false;
	}
}

function onSuccess() 
{
	f_query_main.location.href = "../../eSM/jsp/OperationalStatusMain.jsp";
	f_query_header.location.href = "../../eCommon/html/blank.html";
	f_query_details.location.href = "../../eCommon/html/blank.html";

}
