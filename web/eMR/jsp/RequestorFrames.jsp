<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../js/Requestor.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String requestor_code = request.getParameter("requestor_code")==null?"":request.getParameter("requestor_code");		

	if(requestor_code.equals("")) 
	{	%>
		<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src="../../eMR/jsp/addModifyRequestor.jsp" frameborder=0 style='height:97vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:98vw'></iframe>
<%	}	
	
	if(!requestor_code.equals("")) 
	{	%>
		<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src="../../eMR/jsp/addModifyRequestor.jsp?requestor_code=<%=requestor_code%>"  frameborder=0 style='height:97vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:98vw'></iframe>
<%	}	%>

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

