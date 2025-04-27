<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String queryString=request.getQueryString();
%>	
	<iframe name='searchframe' id='searchframe' src='CustomICDCodeQueryResult.jsp?<%=queryString%>' scrolling=auto  frameborder=no  noresize style='height:30vh;width:98vw'></iframe>
	<iframe name='CusticdQueryResultFrame' id='CusticdQueryResultFrame'  src='../../eCommon/html/blank.html'   frameborder=no scrolling="auto" noresize  style='height:66vh;width:98vw'></iframe>

</html>

