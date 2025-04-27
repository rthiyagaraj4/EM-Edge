<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                    
<% request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
 	<script language='javascript' src='../../eOT/js/Implants.js'></script>
 	<script language='javascript' src='../../eOT/js/surgeon.js'></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
 	<%@ page session="false" %>
	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> scrolling='no' style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

