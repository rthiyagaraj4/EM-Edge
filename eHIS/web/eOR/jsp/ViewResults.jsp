<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
 <% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085  
  %>
<head>
	<title>View Results</title>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<iframe name='ViewResultsSearch' id='ViewResultsSearch' src='ViewResultsSearch.jsp?<%=request.getQueryString()%>' frameborder=0  style='height:15vh;width:100vw'></iframe>
<iframe name='ViewResultsHeader' id='ViewResultsHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='ViewResultsDetail' id='ViewResultsDetail' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize style='height:88vh;width:100vw'></iframe>

</html>

