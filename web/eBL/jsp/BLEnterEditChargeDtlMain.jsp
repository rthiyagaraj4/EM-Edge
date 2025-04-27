<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	//HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	
%>
	<html>
	<head>
	<script>
	</script>
	<title>
		<%=request.getParameter("title")%>
	</title>
	</head>
	<%	
	String strAllParam = (request.getQueryString());
//	System.out.println("strAllParam:"+strAllParam);
	%>
<!--  <frameset rows='10%,20%,45%,20%,0%'>-->
	<iframe name='query1' id='query1'	src="BLEnterEditChargeDetailsHdr.jsp?<%= strAllParam%>"  frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
<!--<iframe name='query1' id='query1'	src='BLEnterEditChargeDetials1.jsp?<%=request.getQueryString()%>'  frameborder=0 scrolling='no' noresize>-->
	<iframe name='hdr_frame' id='hdr_frame'	src="BLEnterEditChargeDetailsHeader.jsp"  frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='query2' id='query2'	src="BLEnterEditChargeDetailsBody.jsp?<%= strAllParam%>"frameborder=0 scrolling='yes' noresize style='height:45vh;width:99vw'></iframe>
	
<!--
	<frame name='query3' id='query3'	src="BLEnterEditChargeDetials4.jsp?<%= strAllParam%>" frameborder=0 scrolling='yes' noresize style='height:35vh;width:100vw'></iframe>
	-->
	<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' noresize style='height:0vh;width:100vw'></iframe>

</html>

