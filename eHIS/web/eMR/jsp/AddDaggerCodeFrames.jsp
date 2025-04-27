<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE><fmt:message key="Common.AddAssociateCodesfor.label" bundle="${common_labels}"/> <%=request.getParameter("diag_desc")%>(<%=request.getParameter("diag_code")%>)</TITLE>
</HEAD>

<FRAMESET ROWS="85%,*"	border=0  >
	<FRAME SRC = "../../eMR/jsp/AddDaggerCodeAddModify.jsp?<%=request.getQueryString()%>" NAME="AddDaggerCodeAddModifyFrame" noresize scrolling="no" >
	<FRAME SRC = "../../eMR/jsp/AddDaggerCodeTools.jsp?<%=request.getQueryString()%>" NAME="AddDaggerCodeToolsFrame" noresize scrolling="no">
	<frame src='../../eCommon/html/blank.html' name='messageFrame' id='messageFrame' noresize frameborder=0>
</FRAMESET>
</HTML>

