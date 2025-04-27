<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if(flag == null) flag="";

		

			String function_id=request.getParameter("function_id");
			    if(function_id == null) function_id = "";
%>

	<iframe name='HeaderFrame' id='HeaderFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:98vw'></iframe>
	<iframe name='NurUtPractQueryFrame' id='NurUtPractQueryFrame'  src="../../eIP/jsp/PractForNursUnitQuery.jsp?function_id=IP_ONLINE_REPORT&query=IPOnlineReport&Function=nurs&operation=insert&flag=<%=flag%>" scrolling='no' noresize frameborder=0 style='height:25vh;width:98vw'></iframe>
	<iframe name='NurUtPractResultFrame' id='NurUtPractResultFrame' src='../../eCommon/html/blank.html' frameborder=0  style='height:68vh;width:98vw'></iframe>
	<iframe name='Dummy' id='Dummy'src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:0vh;width:98vw'></iframe>
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

