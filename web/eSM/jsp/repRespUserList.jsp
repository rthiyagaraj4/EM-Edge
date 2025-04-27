<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<script src="../js/repUserRespList.js"></script>

<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/repRespuserListFormMain.jsp' frameborder=0 noresize scrolling='no' style='height:4vh;width:100vw'></iframe><iframe name='f_query_add_mod1' id='f_query_add_mod1' 		src='../../eCommon/html/blank.html' noresize frameborder=0 style='height:79vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'		    src='../../eCommon/jsp/MstCodeError.jsp' noresize frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

