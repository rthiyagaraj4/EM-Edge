<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper"%>
<html>
<head>
<script language='javascript' src='../js/MTP.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//	String url = "../../eCA/jsp/MTPToolbar.jsp?" ;
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:6%;width:100vw'></iframe>
	<iframe name='mtp_add_mod' id='mtp_add_mod'	src='../../eCA/jsp/MTPAddModify.jsp?<%=params%>' frameborder=0 scrolling ='no' style='height:24%;width:100vw'></iframe><iframe name='mtp_events' id='mtp_events'	src='../../eCommon/html/blank.html' frameborder=0 scrolling ='yes' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:6%;width:100vw'></iframe>
</html>

