<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../js/repResetRunList.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</script>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	<iframe scrolling="no" name='menuFrame' id='menuFrame' src='../../eMR/jsp/repmrMastListForm.jsp'  noresize frameborder=0 style='height:18vh;width:100vw'></iframe><iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:65vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='auto' style='height:8vh;width:100vw'></iframe>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

