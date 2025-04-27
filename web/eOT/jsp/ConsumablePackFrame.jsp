<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" %>
<html>
	<head>
    <!-- <script language='JavaScript' src='../../eCommon/js/messages.js'></script>
	<script language="javascript" src="../../eOT/js/OTMessages.js"></script> -->
	<script language='JavaScript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='JavaScript' src='../../eCommon/js/common.js'></script>
 	<script language='javascript' src='../../eOT/js/ConsumablePack.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<%@ page session="false" %>
	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> scrolling='no' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  frameborder='0' noresize style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp?<%=params%>' frameborder='0' noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form>
	<input type=hidden name=source value="<%=params%>">
</html>

