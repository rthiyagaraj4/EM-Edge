<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title><fmt:message key="eCA.ReviewResults.label" bundle="${ca_labels}"/></title>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	%>
 	<script>function_id = "<%=request.getParameter("function_id")%>";</script>
</head>
<iframe name='ReviewResultsSearch' id='ReviewResultsSearch' src='ReviewResultsSearch.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize style='height:20.5vh;width:100vw'></iframe>
	<iframe name='ReviewResultsHeader' id='ReviewResultsHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:5vh;width:100vw'></iframe>
	<iframe name='ReviewResultsResult' id='ReviewResultsResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize style='height:58.5vh;width:100vw'></iframe>
	<iframe name='ReviewResultsBtn' id='ReviewResultsBtn'	  src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:6vh;width:100vw'></iframe>

</html>

