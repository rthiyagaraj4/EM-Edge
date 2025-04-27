<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title> <%= request.getParameter("title")%></title>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	
%>
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
		String var=request.getQueryString();	
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<!-- 	<frameset rows='100%,0%' border=0>	 -->	
		<iframe  src="../../eBL/jsp/BLEnterEditChargeDetailsBodyEdit.jsp?<%=var%>" frameborder=0 noresize scrolling='no' style='height:95vh;width:100vw' ></iframe>	
<!--	<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize> -->
<!--	<FRAME SRC='../../eBL/jsp/BLEnterEditChargeDetialsHdr.jsp?<%=request.getQueryString()%>' frameborder=0 name='ValidFrame' 				scrolling='yes' noresize> -->
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize style='height:0vh;width:100vw'> </iframe>
<!-- </frameset> -->
</head>

</html>

