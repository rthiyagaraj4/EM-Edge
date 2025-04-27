<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper" %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String queryString=request.getQueryString();
%>
	<iframe name='group_head' id='group_head' src='../../eMR/jsp/GroupHeading.jsp?<%=queryString%>' noresize frameborder="0" style="height: 100vh; width: 25vw; margin: 0; float: left; box-sizing: border-box;" scrolling=auto ></iframe>
	<iframe name='code_description' id='code_description'    src='../../eCommon/html/blank.html' frameborder="0" scrolling="no" style="height: 100vh; width: 73vw; margin: 0;  float: left; box-sizing: border-box;" ></iframe>
</html>

