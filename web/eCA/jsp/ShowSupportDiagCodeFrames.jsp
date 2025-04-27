<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String strTitle = request.getParameter("title");
	%>
<head>
<title><fmt:message key="Common.AddAssociateCodesfor.label" bundle="${common_labels}"/> <%=strTitle%></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe SRC="../../eCA/jsp/ShowSupportingDiagCode.jsp?<%=request.getQueryString()%>" NAME="" scrolling = "yes" style="height:80%;width:100vw"></iframe><iframe SRC="../../eCA/jsp/ShowSupportDiagCodeClose.jsp" name="" id="" style="height:100vh;width:100vw"></iframe>
</HTML>

