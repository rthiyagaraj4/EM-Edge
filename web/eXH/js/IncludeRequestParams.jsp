<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import = "eXH.*" %>
 
<%
	Map<String, String> requestParams = new HashMap<String, String>();
	Enumeration<String> parameterNames = request.getParameterNames();

	while (parameterNames.hasMoreElements()) {
		String paramName = parameterNames.nextElement();
		String paramValue = XHDBAdapter.checkNull(request.getParameter(paramName));
		System.out.println(paramName + " - " + paramValue);
%>
	<INPUT TYPE="hidden" NAME="<%= paramName %>" VALUE="<%= paramValue %>"/>
<%
	}
%>
