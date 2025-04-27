<!DOCTYPE html>
<!-- Page created for Operating Site Identification - IN:41808 -  11/11/2013 by selvinM -->
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>	
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<title><fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></title>
</head>
<%String Patient_ID = request.getParameter("Patient_ID");
String params = "Patient_Id="+Patient_ID;
String param = request.getQueryString();
%>

	
		<iframe name='pline' id='pline' src='../../eCommon/jsp/pline.jsp?<%=params %>' scrolling='no' noresize style="height:15vh;width:100vw">
		</iframe>
		<iframe name='main' id='main'    src='../../eOT/jsp/OperatingSiteIdentificationMain.jsp?<%=param %>' scrolling='no' noresize style="height:20vh;width:100vw">
		</iframe>
		<iframe name='button' id='button'    src='../../eOT/jsp/OperatingSiteIdentificationButton.jsp?<%=param %>' scrolling='no' noresize style="height:65vh;width:100vw">
		</iframe>
	
<body>
</body>
</html>

