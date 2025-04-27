<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String orderId = request.getParameter("orderId");
String called_from = request.getParameter("called_from");

%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<title><fmt:message key="eOR.OrderLineFormat.label" bundle="${or_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<iframe name="ViewHeaderCommentTop" id="ViewHeaderCommentTop" src="ResultEntryViewOrderFormat.jsp?orderId=<%=orderId%>&called_from=<%=called_from%>" frameborder=0  noresize style="height:85%;width:100vw"></iframe>
	<iframe name="ViewHeaderCommentDetail" id="ViewHeaderCommentDetail" src="ViewOrderBtn.jsp" frameborder=0 noresize style="height:100vh;width:100vw"></iframe>


