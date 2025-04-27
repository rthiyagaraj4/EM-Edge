<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text"%>
<html>

<%
	String radioFrame="";
	radioFrame=request.getContextPath()+"/eLC/QueryStockStatus/jsp/RadioButtons.jsp";
%>
	<iframe name="stockFrame" id="stockFrame" src="<%=radioFrame%>" width="100%" height="20%" scrolling="no" noresize="noresize" frameborder="0"/ style="height:5%;width:100vw"></iframe><iframe name="criteriaFrame" id="criteriaFrame" src="" width="100%" height="20%" scrolling="no" noresize="noresize" frameborder="0"/ style="height:20%;width:100vw"></iframe><iframe name="stockStatusResult" id="stockStatusResult"/ style="height:100vh;width:100vw"></iframe>
</html>

