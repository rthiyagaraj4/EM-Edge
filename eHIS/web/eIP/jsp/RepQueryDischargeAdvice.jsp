<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
<title> <fmt:message key="eIP.DischargeAdviceReport.label" bundle="${ip_labels}"/></title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script>
		function reset()
		{
			frames[1].document.forms[0].reset();
			frames[2].location.href = '../../eCommon/html/blank.html';
		}
	</script>
</head>

<iframe name='f_query_add_mod' id='f_query_add_mod' 	src="../jsp/InpatientLookupCriteria.jsp?win_height=30&win_height=33.4&win_width=50&call_function=RepDischargeAdvice&modal=yes" frameborder=0 scrolling='no' noresize style='height:136%;width:100vw'></iframe>
	<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
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

