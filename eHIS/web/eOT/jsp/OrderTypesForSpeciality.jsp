<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>
	<head>
	<%@ page session="false" %>
 	<script language='javascript' src='../../eOT/js/OrderTypesForSpeciality.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
	<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?";
		//String url = "../../eCommon/jsp/CommonToolbar.jsp?" ;
		String params = request.getQueryString();
		String source = url + params;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%>  frameborder='0' scrolling='no' style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  frameborder='0' noresize style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp'  frameborder='0' noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

