<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eXI/js/QueryOrgwsItemStatus.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<script>
function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	
	f_query_add_mod.location.reload();
	f_query_add_mod_detail.location.href='../../eCommon/html/blank.html';	
}
</script>
</head>
<%
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

 <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eXI/jsp/PrintBarcodeLabelSearchCriteria.jsp" frameborder=0 noresize  style='height:15vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail'  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:58vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_print' id='f_query_add_mod_print' src="../../eCommon/html/blank.html" frameborder=0 noresize  style='height:4vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>

</html>





