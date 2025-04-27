<!DOCTYPE html>
<%@ page session="false" contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String params = request.getQueryString() ;
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String source = url + params ;
%>
<html>
<head>
<script language='javascript' src='../js/DocumentType.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eSM/js/CancelledDocuments.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod1' id='f_query_add_mod1' 		src='../../eSM/jsp/CancelledDocumentsQuery.jsp' noresize frameborder=0 style='height:83vh;width:100vw'></iframe>
<!-- 	<iframe name='f_query_add_mod1' id='f_query_add_mod1' 		src='../../eCommon/html/blank.html' noresize frameborder=0></iframe>
 -->	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

</html>

