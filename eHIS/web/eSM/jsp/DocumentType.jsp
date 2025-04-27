<!DOCTYPE html>
<%@ page session="false" contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
String mode = request.getParameter("mode");
if(mode == null || mode.equals("null"))mode="";
	String params = request.getQueryString() ;
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String source = url + params ;
%>
<html>
<head>
<script language='javascript' src='../../eSM/js/DocumentType.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:32vh;width:100vw'></iframe>
	<iframe name='f_query_add_modcr' id='f_query_add_modcr' src='../../eCommon/html/blank.html?<%=request.getQueryString()%>' frameborder=0 scrolling='on' noresize style='height:50vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formMain" id="formMain">
<input type=hidden name="mode" id="mode" value='<%=mode%>'>
</form>
</body>
</html>

