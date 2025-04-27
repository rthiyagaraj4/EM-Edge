function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) && (url.indexOf("reset")==-1) )
        return true;
    else
        return false;
  }
function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/QueryUsersMain.jsp?function=SmFunction";
}
function reset() 
{

	//parent.frames[1].frames[1].frames[0].document.forms[0].reset();
	//frames[1].frames[1].document.forms[0].reset();
	//parent.frames[1].frames[1].frames[1].document.location.href = '../../eCommon/html/blank.html';
	//frames[1].frames[1].document.location.href = '../../eCommon/html/blank.html';
	f_query_add_mod.document.location.reload() ;
}
