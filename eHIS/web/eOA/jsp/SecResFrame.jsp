<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper"  %>
<html>
<head>
<title><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></title>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String s=request.getQueryString();
String fromPage=request.getParameter("fromPage")==null?"":request.getParameter("fromPage");

%>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/SecResTop.jsp?<%=s%>'  frameborder=0 scrolling='no' noresize style='height:27%;width:100vw'></iframe>
	
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/SecResResult.jsp?<%=s%>'  frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	<%if (fromPage.equals("Reschedule")){%>
	 <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/SecResBottom.jsp?<%=s%>'  frameborder=0 scrolling='no' noresize style='height:5%;width:100vw'></iframe> 
		 <%}%>

</html>

