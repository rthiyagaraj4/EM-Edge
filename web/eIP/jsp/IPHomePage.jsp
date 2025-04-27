<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></
link>
	<script>
		function reset()
		{
			frames[1].document.forms[0].reset();
			frames[2].location.href = '../../eCommon/html/blank.html';
			frames[1].document.forms[0].search.disabled=false;

		}
	</script>
</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";



%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling=
'no' noresize style='height:40%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/IPHomePageNursingUnitList.jsp?function_id=<%=function_id%> ' frameborder=0  scrolling='auto' noresize style='height:80vh;width:100vw'></iframe> 

	<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 
scrolling='auto' noresize style='height:0%;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' 
frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : 
inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue 
: inputString);
	}
%>

