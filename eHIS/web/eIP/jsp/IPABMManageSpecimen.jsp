<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
</head>


<%
String requestParams = request.getQueryString();

%>

<iframe name='bodycontent' id='bodycontent' src='../../eOR/jsp/SpecimenOrder.jsp?<%=requestParams %>' frameborder=0 scrolling=no noresize/ style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize/ style='height:7%;width:100vw'></iframe>

</html>

