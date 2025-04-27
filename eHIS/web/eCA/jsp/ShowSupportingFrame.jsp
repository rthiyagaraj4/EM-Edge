<!DOCTYPE html>
<!--
-------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------
18/04/2023	   38981        Krishna Pranay   18/04/2023     Ramesh G     ML-MMOH-CRF-1986

-------------------------------------------------------------------------------------------------------------
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<title>
	<fmt:message key="Common.AssociateCodesFor.label" bundle="${common_labels}"/> <%=request.getParameter("title")%>
</title>
<iframe SRC="../../eCA/jsp/ShowSupportingCode.jsp?<%=request.getQueryString()%>" NAME="" scrolling = "yes" style="height:80%;width:98vw"></iframe><iframe SRC="../../eCA/jsp/ShowSupportingToolbar.jsp" name="" id="" style="height:20vh;width:98vw"></iframe>
</HTML>

