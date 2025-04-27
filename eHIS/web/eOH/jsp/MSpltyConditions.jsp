<!DOCTYPE html>
<%@ page contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
 	<script language='javascript' src='../../eOH/js/MSpltyConditions.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 	<%@ page session="false" %>
	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
</html>

