<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
String notes = (String)request.getAttribute("Notes");

%>
<div style="width:100%;height:100%">
	<%= notes%>
</div>
