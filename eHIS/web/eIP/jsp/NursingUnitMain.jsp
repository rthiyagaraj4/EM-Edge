<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String called_from = request.getParameter("called_from");
	String function_id = request.getParameter("function_id");
%>
	<iframe name='Search' id='Search'	src='../../eIP/jsp/NursingUnitSearch.jsp?called_from=<%=called_from%>&function_id=<%=function_id%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
	<iframe name='Result' id='Result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:70vh;width:100vw'></iframe>
	<iframe name='Dummy' id='Dummy' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

