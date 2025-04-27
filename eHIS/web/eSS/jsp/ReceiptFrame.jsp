<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.util.*, java.text.*,eSS.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<!-- <jsp:useBean id="alAlternateGroupList" scope="session" class="java.util.ArrayList"/> -->

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eSS/js/Receipt.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<iframe name='frameDispatchAddModify' id='frameDispatchAddModify' src='../../eSS/jsp/ReceiptAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:25%;width:100vw'></iframe>
	<iframe name='frameDispatchDetail' id='frameDispatchDetail' frameborder="0" scrolling="no" noresize src='../../eCommon/html/blank.html'  style='height:100vh;width:100vw'></iframe>
</html>

