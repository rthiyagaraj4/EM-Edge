<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<iframe src='MRSearchScreenFrmesDet.jsp?<%=request.getQueryString()%>' name='scrn1' noresize frameborder=0 style='height:88vh;width:100vw'></iframe><iframe src='MRSearchScreenComp.jsp?<%=request.getQueryString()%>' name='scrn2' noresize frameborder=0 style='height:10vh;width:97vw'></iframe><iframe src='../../eCommon/html/blank.html' name='messageFrame' id='messageFrame' noresize frameborder=0 style='height:12vh;width:97vw'></iframe>		
	</head>	
</html>

