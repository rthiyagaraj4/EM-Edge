<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>
<html>
<head>
<script language='javascript' src='../../eMR/js/vwPatFileDetail.js'></script>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no'  style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/mrblank.jsp?step_1=6' frameborder=0  scrolling='no' style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='no' style='height:12vh;width:100vw'></iframe>
</html>

