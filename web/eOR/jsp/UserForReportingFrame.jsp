<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

 	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<title><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></title>

<iframe name='frameUserOrderable' id='frameUserOrderable' src="../../eOR/jsp/UserForReportingOrderable.jsp?<%=request.getQueryString()%>"
	frameborder='0' noresize scrolling='no' style='height:7vh;width:100vw'>
	</iframe>

	<iframe name="frameUserOrderableSelect" id="frameUserOrderableSelect" src="../../eOR/jsp/UserForReportingSelect.jsp?<%=request.getQueryString()%>"  noresize frameborder='0' scrolling='no' style='height:20vh;width:100vw'>
	</iframe>

	<iframe name="frameUserOrderableResult" id="frameUserOrderableResult" src="../../eCommon/html/blank.html"  noresize frameborder='0' scrolling='auto' style='height:37vh;width:100vw'>
	</iframe>

	<iframe name="frameUserOrderableSubmit" id="frameUserOrderableSubmit" src="../../eCommon/html/blank.html"  noresize frameborder='0' scrolling='no' style='height:36vh;width:100vw'>
	</iframe>



</html>
<!-- src="../../eOR/jsp/UserForReportingResult.jsp"  -->

