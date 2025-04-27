
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--UserForReportingAddModify.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>

<%
   request.setCharacterEncoding("UTF-8");
	String function_id = request.getParameter( "function_id" ) ;
%>
<html>
<head>
 	<script language="JavaScript" src="../js/UserForReporting.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript"> function_id = "<%=function_id%>"</script>

</head>
<%
String resp_id			=   "";
String pract_id			=   "";
String order_category	=	"";

String mode = request.getParameter("mode");

	mode = mode.trim();

		resp_id			= request.getParameter("resp_id");
		pract_id			= request.getParameter("pract_id");
		order_category	= request.getParameter("order_category");

		if(resp_id == null) {resp_id = "";}
		if(pract_id == null) {pract_id = "";}
		if(order_category == null) {order_category = "";}



	if(!(mode.equals("2"))){
		mode = "1";
	}
%>
	
<%
	if(mode.equals("2")){



%>
		<!-- <frameset rows='0%,*'> -->
		<iframe name='user_for_reporting_top' src='../../eCommon/html/blank.html' frameborder=0 style="height:0vh;width:100vw"></iframe>
		<iframe name='user_for_reporting_bottom' src='UserForReportingAddModifyBottom.jsp?resp_id=<%=resp_id%>&pract_id=<%=pract_id%>&mode=2&function_id=<%=function_id%>&order_category=<%=order_category%>' frameborder=0 scrolling='no' style="height:100vh;width:100vw">
<%	}else{
%>
		<!-- <frameset rows='8%,*'> -->
		<iframe name='user_for_reporting_top' src='UserForReportingAddModifyTop.jsp?function_id=<%=function_id%>&mode=<%=mode%>' frameborder=0 scrolling='no' style="height:8vh;width:100vw"></iframe>
		<iframe name='user_for_reporting_bottom' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style="height:92vh;width:100vw"></iframe>
<%
	}
%>
	<!-- </frameset> -->
</html>
