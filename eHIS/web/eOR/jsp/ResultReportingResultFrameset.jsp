<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>function_id = "<%=request.getParameter("function_id")%>";</script>
<%--<script>alert('<%=request.getQueryString()%>')</script>--%>
</head>
    <iframe name='ResultReportingResult' id='ResultReportingResult' src='../jsp/ResultReportingQueryResult.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=auto style='height:85vh;width:99vw'></iframe>
    <iframe name='ResultReportingResultColor' id='ResultReportingResultColor' src='ResultReportingResultColors.jsp' frameborder=0 scrolling=no style='height:7vh;width:99vw;display:none;'></iframe>
</html>

