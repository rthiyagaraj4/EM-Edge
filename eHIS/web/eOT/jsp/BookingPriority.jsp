<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
	<head>
 	<script language='javascript' src='../../eOT/js/BookingPriority.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  noresize style='height:83vh;width:100vw' frameborder='0'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp'  noresize scrolling='auto' style='height:9vh;width:100vw' frameborder='0'></iframe>
</html>

