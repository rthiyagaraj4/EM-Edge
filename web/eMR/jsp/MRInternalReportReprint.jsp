<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function = checkForNull(request.getParameter("function_id"));
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src="../../eMR/js/MRInternalReportReprint.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</head>
<%



%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	<iframe scrolling="no" name='searchFrame' id='searchFrame' src='../../eMR/jsp/MRInternalReportReprintSearch.jsp?call_function=<%=call_function%>&function_id=<%=call_function%>'  frameborder=0 style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='criteriaFrame' id='criteriaFrame' src='../../eCommon/html/blank.html'  frameborder=0 style='height:34vh;width:100vw'></iframe>
	<iframe scrolling="auto" name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html'   frameborder=0 style='height:40vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0  scrolling='auto' style='height:9vh;width:100vw'></iframe>
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

