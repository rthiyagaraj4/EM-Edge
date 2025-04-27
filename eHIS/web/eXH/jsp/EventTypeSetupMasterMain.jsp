<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language='javascript' src='../../eXH/js/EventTypeTabs.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	//System.out.println("EventTypeSetupMasterMain.jsp source : "+source);
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='hr_menu_bar' id='hr_menu_bar' src='../../eXH/jsp/EventTypeHorizontalTab.jsp' frameborder=0 noresize scrolling='no' style='height:4vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:76vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:12vh;width:100vw'></iframe>
</html> 



