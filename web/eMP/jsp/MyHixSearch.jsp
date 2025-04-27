<!DOCTYPE html>
<%@ page session="false" contentType="text/html;charset=UTF-8"%>

<html>
<title>MyHix Search</title>
<head>
<script language='javascript' src='../../eMP/js/MyHixSearch.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>


<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='f_query_criteria' id='f_query_criteria' src='../../eMP/jsp/MyHixQuery.jsp?<%=params%>' scrolling='no' frameborder=0 noresize style='height:2vh;width:100vw'></iframe>
		<iframe name='f_query_patient' id='f_query_patient' src='../../eCommon/html/blank.html' scrolling='yes' frameborder=0 noresize style='height:18vh;width:100vw'></iframe>
		<iframe name='f_query_result' id='f_query_result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='yes' style='height:0vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
</html>

