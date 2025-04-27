<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eOR.SpecimenOrder.label" bundle="${or_labels}"/> </title>
</head>


<%
String requestParams = request.getQueryString();

%>

<iframe name="content" id="content" src="IPABMManageSpecimen.jsp?<%=requestParams %>" frameborder=0 scrolling=no noresize/ style="height:80vh;width:100vw"></iframe>


</html>

