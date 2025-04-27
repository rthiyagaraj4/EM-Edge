<!DOCTYPE html>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/ViewDebugInformation.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<title>View Debug Log Information</title>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/ViewDebugInfoHeader.jsp' frameborder=0 noresize scrolling='no' style='height:25vh;width:100vw'></iframe>
<iframe name='queryResultsFrame' id='queryResultsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:53vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:14vh;width:100vw'></iframe>

</html>

