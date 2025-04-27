<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<% 
	String executable_name="../../eOT/jsp/RolesForUserMain.jsp?";
	String qry_string = request.getQueryString();
	String source = executable_name+qry_string;
%>		
 </head>
  <iframe name='master_frame' id='master_frame' src='<%=source%>'   scrolling='no' frameborder='0' style='height:15vh;width:97vw'></iframe>
  <iframe name='detail_frame' id='detail_frame'	src='../../eCommon/html/blank.html'  noresize frameborder='0' scrolling='auto' style='height:80vh;width:97vw'></iframe>
</html>

