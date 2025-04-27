
<%@ page   contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eSM/js/MenuRstrnForResp.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>


<iframe name='frame1' id='frame1'	src='../../eSM/jsp/RespMenuRstrnForResp.jsp' framespacing=0 frameborder=0 scrolling='no' noresize style='height:14vh;width:100vw'></iframe>
	<iframe name='frame2' id='frame2'	src='../../eCommon/html/blank.html' frameborder=0 framespacing=0 scrolling='auto' noresize style='height:35vh;width:100vw'></iframe>
	<iframe name='frame3' id='frame3' 	src='../../eCommon/html/blank.html' frameborder=0 framespacing=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='frame4' id='frame4'	src='../../eCommon/html/blank.html' frameborder=0 framespacing=0 noresize scrolling='auto' style='height:45vh;width:100vw'></iframe>
</html>

