<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- AuthorizeOrders.jsp --> 
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<Title><fmt:message key="eOR.AuthorizeOrders.label" bundle="${or_labels}"/></Title>

<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%
	/*String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	*/
%>
<!-- <frameset rows='20%,*%'>
	<frame name='AuthoriseOrderTop' id='AuthoriseOrderTop' src='AuthorizeOrdersTop.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize>
	
	<frame name='AuthoriseOrderBottom' id='AuthoriseOrderBottom' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no'>
</frameset>	-->		
	<iframe name='AuthoriseOrderTop' id='AuthoriseOrderTop' src='AuthorizeOrdersTop.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:23vh;width:100vw'></iframe>
	
	<iframe name='AuthoriseOrderBottom' id='AuthoriseOrderBottom' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:75vh;width:100vw'></iframe>
				   
</html>

