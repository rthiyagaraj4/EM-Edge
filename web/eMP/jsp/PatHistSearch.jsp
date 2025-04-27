<!DOCTYPE html>
<%@ page session="false" contentType="text/html;charset=UTF-8"%>


<html>
<head>
<script language='javascript' src='../../eMP/js/PatHistSearch.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>


<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_criteria' id='f_query_criteria' src='../../eMP/jsp/PatientHistQuery.jsp' scrolling='no' frameborder=0 noresize style='height:12vh;width:100vw'></iframe>
		<iframe name='f_query_patient' id='f_query_patient' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:12vh;width:100vw'></iframe>
		<iframe name='f_query_result' id='f_query_result' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:59vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

