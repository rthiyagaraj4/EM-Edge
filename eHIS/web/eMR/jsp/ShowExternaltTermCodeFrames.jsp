<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<title>
	<fmt:message key="Common.AssociateCodesFor.label" bundle="${common_labels}"/> <%=request.getParameter("title")%>
</title>
<iframe SRC="../../eMR/jsp/ShowExternalCauseTermCode.jsp?<%=request.getQueryString()%>" NAME="" scrolling = "yes" style="height:80%;width:100vw"></iframe><iframe SRC="../../eMR/jsp/ShowExternalCauseToolbar.jsp" name="" id="" style="height:100vh;width:100vw"></iframe>
</HTML>

