<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../js/OrCommon.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
    <%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    %>
	

<title>Order Set Additional</title>
<iframe name='orderset_order_dtl' id='orderset_order_dtl'	src='../../eOR/jsp/OrdersetComponentDetailAdded.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='auto' style='height:92vh;width:100vw'></iframe>
<iframe name='orderset_order_btn' id='orderset_order_btn'	src='../../eOR/jsp/OrdersetComponentDetailAddedButton.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
</html>

