<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:2vh;width:100vw'></iframe>
<iframe name='hr_menu_bar' id='hr_menu_bar' src='../../eXH/jsp/ReviewCommProcess.jsp' frameborder=0 noresize scrolling='no' style='height:15vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:55vh;width:100vw'></iframe>
<iframe name='f_query_btn' id='f_query_btn' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='no' style='height:19vh;width:100vw'></iframe>
</html>

