<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<head>
<%
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='JavaScript' src='../../eXH/js/CommProcessSleepParameters.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:7.5vh;width:100vw'></iframe>
	<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/CommunicationProcessSleepParameters.jsp'frameborder=0   noresize     scrolling='no' style='height:85vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:14vh;width:100vw'></iframe>
</html>

