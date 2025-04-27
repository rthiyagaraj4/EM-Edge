<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ORPlaceOrdersForOthPractAddModify.jsp -->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<head>
 	<script language="JavaScript" src="../../eOR/js/ORPlaceOrdersForOthPract.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
</head>
<%
	String mode			= request.getParameter("mode");

	mode = mode.trim();
	if(!(mode.equals("2"))){
		mode = "1";
	}
%>
	<!--<frameset rows='4%,12%,*%' id="main_frame" name="main_frame">-->
		<iframe name='place_order_pract_header' id='place_order_pract_header' src='ORPlaceOrdersForOthPractAddModifyHeader.jsp?function_id=<%=function_id%>&mode=<%=java.net.URLEncoder.encode(mode)%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
		<iframe name='place_order_pract_middle' id='place_order_pract_middle' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto'style='height:80vh;width:100vw'></iframe>
		<iframe name='place_order_pract_bottom' id='place_order_pract_bottom' src='../../eCommon/html/blank.html' frameborder=0 style='height:12vh;width:100vw'></iframe>
	<!--</frameset>-->
</html>									

