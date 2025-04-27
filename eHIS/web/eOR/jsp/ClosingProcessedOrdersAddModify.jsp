
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ClosingProcessedOrdersAddModify.jsp -->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<%
 request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode = request.getParameter("mode");
	String function_id = request.getParameter( "function_id" ) ;
	
	mode = mode.trim();

	if(!(mode.equals("2"))){
		mode = "1";
	}
%>
<html>
<head>
 	<script language="JavaScript" src="../js/ClosingProcessedOrders.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
		<iframe name='Closing_ProcessedOrders_top' id='Closing_ProcessedOrders_top' src='ClosingProcessedOrdersAddModifyTop.jsp?function_id=<%=function_id%>&mode=<%=mode%>' frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
			<iframe name='Closing_ProcessedOrders_bottom' id='Closing_ProcessedOrders_bottom' src='../../eCommon/html/blank.html' frameborder=0 style='height:95vh;width:100vw'></iframe>
</html>									

