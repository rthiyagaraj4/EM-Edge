<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper"contentType="text/html;charset=UTF-8"%>                    
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
	<head>
	<script language='JavaScript' src='../../eCommon/js/ValidateControl.js'></script>
 	<script language='Javascript' src='../../eOT/js/SurgicalAccessories.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%>  scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' scrolling='auto' noresize style='height:86vh;width:100vw' frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp?<%=params%>'  noresize scrolling='auto' style='height:6vh;width:100vw' frameborder='0'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form>
	<input type="hidden" name='source' id='source' value="<%=params%>">
	</form>
</html>

