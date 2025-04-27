<!DOCTYPE html>
<%@ page session="false" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String source = url + params ;
%>
<html>
<head>
<script language='javascript' src='../../eSM/js/ForeignCurrency.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:82vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

