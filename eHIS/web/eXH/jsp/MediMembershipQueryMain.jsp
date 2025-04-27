<!DOCTYPE html>
<html> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
	<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src="../../eXH/js/repResetRunlist.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	
	f_query_add_mod.location.reload();
	resultFrame.location.href='../../eCommon/html/blank.html';	
}

</script>
<title>Eclaims Query/Reports </title>
	
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>  
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eXH/jsp/MediMembershipQueryMaster.jsp?<%=params%>" frameborder=0  scrolling='no' style='height:28vh;width:100vw'></iframe>
	<iframe name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='yes' style='height:61vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
	
 	
</html>

