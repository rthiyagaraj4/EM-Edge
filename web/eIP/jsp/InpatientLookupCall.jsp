<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
	request.setCharacterEncoding("UTF-8"); 
	out.print ( "<title>"+( request.getParameter("title") == null ? " " :request.getParameter("title")   )+"</title>" ) ;
	String callfunc = request.getParameter("call_func")==null?"InpatientLookupCall":request.getParameter("call_func");

	String wherecondn = request.getParameter("wherecondn");
		if(wherecondn == null) wherecondn ="";	

	String modal=request.getParameter("modal");
		if(modal == null) modal="";
%>

<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eIP/jsp/InpatientLookupCriteria.jsp?modal=<%=modal%>&call_function=<%=callfunc%>&wherecondn=<%=wherecondn%>' frameborder=0 scrolling='no' noresize style='height:135%;width:100vw'></iframe>
		<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>

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

