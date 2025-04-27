<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/FuncForRespGrp.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<iframe name='frame1' id='frame1'	src='../jsp/RespFuncForRespGrp.jsp' framespacing=0 frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
	<iframe name='remheader' id='remheader' 	src='../../eCommon/html/blank.html' frameborder=0 framespacing=0  noresize scrolling='no' style='height:4vh;width:100vw'></iframe>
	<iframe name='frame2' id='frame2'	src='../../eCommon/html/blank.html' frameborder=0 framespacing=0 scrolling='auto' noresize style='height:33;width:100vw'></iframe><!-RemoveFuncForRespGrp.jsp>
	<iframe name='frame3' id='frame3' 	src='../../eSM/jsp/QueryFuncForRespGrp.jsp' frameborder=0 framespacing=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='addheader' id='addheader' 	src='../../eCommon/html/blank.html' frameborder=0 framespacing=0  noresize scrolling='no' style='height:4vh;width:100vw'></iframe>
	<iframe name='frame4' id='frame4'	src='../../eCommon/html/blank.html' frameborder=0 framespacing=0 noresize scrolling='auto' style='height:44vh;width:100vw'></iframe><!-AddFuncForRespGrp.jsp>

</html>

