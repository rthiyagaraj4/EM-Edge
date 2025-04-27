<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/NursUnitPract.js'></script>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url    = "../../eCommon/jsp/MstCodeToolbar.jsp?"; 
	String params = request.getQueryString() ;
	String source = url + params ;
	String function_id = request.getParameter("function_id");
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src = <%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html?+<%=params%>' frameborder=0  scrolling='no' style='height:84vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
	<form>
	<input type=hidden name='function_id' id='function_id' value=<%=function_id%>>
	</form>
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

