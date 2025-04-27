<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"  %>

<html>
<head>
<title><fmt:message key="eOA.RecurringDays.label" bundle="${oa_labels}"/></title>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String s=request.getQueryString();%>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/RecurringDaysCriteria.jsp?<%=s%>'  frameborder=0 scrolling='no' style='height:5vh;width:100vw'></iframe>
<iframe name='ResultsFrame' id='ResultsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:14vh;width:100vw'></iframe>
</html>

