<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
<script language='javascript' src='../../eOT/js/OperatingRooms.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%>  scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'   noresize style='height:83vh;width:100vw' frameborder='0'></iframe>
<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp'  noresize scrolling='auto' style='height:9vh;width:100vw' frameborder='0'></iframe>
</html>

