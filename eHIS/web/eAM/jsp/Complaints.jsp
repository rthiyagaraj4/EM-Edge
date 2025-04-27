<!DOCTYPE html>
<%--
	FileName	: Complaints.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>	
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/Complaint.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>

<frameset rows='48,*,50'>
	<!--			<frame name='commontoolbarFrame' id='commontoolbarFrame'src='../../eCommon/jsp/MstCodeToolbar.jsp?function_name=Complaint' frameborder='0'  noresize>
	-->
				<frame name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize>
				<frame name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto'>
				<frame name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'>

</frameset>

</html>

