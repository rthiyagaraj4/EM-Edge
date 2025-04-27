<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<%
		request.setCharacterEncoding("UTF-8");
		String strTitle = request.getParameter("title");
	%>
<head>
<title><fmt:message key="Common.AddAssociateCodesfor.label" bundle="${common_labels}"/> <%=strTitle%></title>
</head>
<iframe SRC="../../eMR/jsp/ShowSupportingDiagCode.jsp?<%=request.getQueryString()%>" NAME="" scrolling = "yes" style="height:80%;width:100vw"></iframe><iframe SRC="../../eMR/jsp/ShowSupportDiagCodeClose.jsp" name="" id="" style="height:100vh;width:100vw"></iframe>
</HTML>

