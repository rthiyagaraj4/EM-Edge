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
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
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
<title>Credit Card POC</title>	
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eXH/jsp/ChromePOCMaster.jsp?<%=params%>" frameborder=0  scrolling='no' style='height:100vh;width:100vw'></iframe> 	
</html>

