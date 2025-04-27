<!DOCTYPE html>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript"src="../../eXH/js/ApplicationMessagesInbound.js"></script>
</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<frameset rows="40,105,*,50" id='idfilterframeset'>
<frame name='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize >
<frame name='f_query_add_mod' src="../../eXH/jsp/ReviewApplMessageQueryInbound.jsp" scrolling="no" frameborder="0" noresize>
<frameset cols="330,*" border='1' >
	<frame name="header" src="../../eCommon/html/blank.html"  name="master_menu"  marginwidth="1" marginheight="1"  noresize scrolling='no' >
	<frame  name="result" src="../../eCommon/html/blank.html" name="master_pages"  marginwidth="1" marginheight="1" scrolling='no' noresize >
</frameset>
<frame name='messageFrame'	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='no'>
</frameset>
<body>
</body>
</html>
