<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
				<script language="javascript" src="../js/ICDCode.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='query_criteria' id='query_criteria' 	src='../../eMR/jsp/ICDCodeQueryCriteria.jsp' frameborder=0 noresize scrolling='no'  style='height:32vh;width:100vw'></iframe>
<iframe name='result' id='result'		src='../../eCommon/html/blank.html' frameborder=0 scrolling='yes' noresize  style='height:50vh;width:100vw'></iframe>
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

