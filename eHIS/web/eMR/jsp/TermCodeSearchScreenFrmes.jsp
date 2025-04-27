<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
		<iframe src='TermCodeSearchScreenFrmesDet.jsp
?<%=request.getQueryString()%>' name='scrn1' noresize frameborder=0 style='height:100vh;width:100vw'></iframe><iframe src='TermCodeSearchScreenComp.jsp
?<%=request.getQueryString()%>' name='scrn2' noresize frameborder=0 style='height:10%;width:100vw'></iframe><iframe src='../../eCommon/html/blank.html' name='messageFrame' id='messageFrame' noresize frameborder=0 style='height:0%;width:100vw'></iframe>		
	</head>	
</html>

