<!DOCTYPE html>
<html> 
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/AdministerReviewCommunicationProcess.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title>Server Errors</title> 
</head>
<%
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;		
%>
<iframe name="queue_frame_exception" id="queue_frame_exception" src="../../eXH/jsp/AdministerDataProcessServErr.jsp?<%=params%>"  frameborder=0 noresize scrolling="no" style="height:100vh;width:100vw"></iframe>
</html>							  	 		 													    

