<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/MRMaster.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
 
</head>
<%
		request.setCharacterEncoding("UTF-8");
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String func = request.getParameter("function_id");
		String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 style='height:82vh;width:100vw'></iframe>
<iframe name='blankFrame' id='blankFrame' 	src='../../eCommon/html/blank.html' frameborder=0 style='height:0vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>

<script>
	var formHTML = "<form name='tempForm' id='tempForm'><input type='text' name='func' id='func' value='<%= func %>' style='visibility: hidden;'></form>";
	addFuncTypeToBlankFrame(formHTML) ;
</script>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

