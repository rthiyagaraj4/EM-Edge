<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>

<html>
<head>
<title><fmt:message key="eOA.RecurringDaysSchedule.label" bundle="${oa_labels}"/></title>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String s=request.getQueryString();%>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/RecurringDaysTime.jsp?<%=s%>'  frameborder=0 scrolling='auto' style='height:19vh;width:100vw'></iframe>
<iframe name='DummyFrame' id='DummyFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
</html>

