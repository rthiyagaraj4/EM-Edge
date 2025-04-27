<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script language='javascript' src='../js/DefineQuickLinks.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	

%>
<!-- <frameset rows='8%,*,6%,0%'> -->
<frameset name="panel" rows='8%,70%,0,8%'>
	<frame name='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize>
	<frame name='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0  scrolling='auto'>

	<frameset   cols="50%,50%" border="0" framespacing=2>
	<frame name="paneldetails" src = "../../eCommon/html/blank.html "
	 marginheight='0' marginwidth='0' scrolling=auto  BORDERCOLOR='green' frameborder=no noresize>
	<frame name="paneladd" src = "../../eCommon/html/blank.html" marginheight='0' marginwidth='0'  frameborder=no  scrolling=no noresize >
</frameset>

	<frame name='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'>
	<frame name='dummy_frame' frameborder=0 scrolling='no' noresize>
</frameset>
</html>
