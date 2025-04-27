<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
	<head>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/PendingOrderStatusForDischarge.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>function_id = "<%=request.getParameter("function_id")%>";</script>
		<%@ page session="false" %>
	</head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
		<iframe name='pend_ord_status_category' id='pend_ord_status_category' src="../../eOR/jsp/PendingOrderStatusForCategory.jsp?<%=params%>&mode=1" frameborder=0 style='height:10vh;width:100vw'></iframe>
		<iframe name='pend_ord_status_discharge' id='pend_ord_status_discharge' src='../../eCommon/html/blank.html' frameborder=0 style='height:70vh;width:100vw'></iframe>
		<!--<frame name='pend_ord_status_discharge' id='pend_ord_status_discharge' src="../../eOR/jsp/PendingOrderStatusForDischargeAmend.jsp?<%=params%>&mode=2" frameborder=0>-->
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

