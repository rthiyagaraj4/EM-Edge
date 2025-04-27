<!DOCTYPE html>
<%@ page session="false" contentType="text/html;charset=UTF-8" %>
<script src="../js/repMthlyOutcomeofDely.js"></script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/repMthlyOutcomeofDelyMain.jsp' frameborder=0 style='height:83vh;width:100vw'>
	</iframe><iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

