<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<TITLE><fmt:message key="Common.AddAssociateCodesfor.label" bundle="${common_labels}"/> <%=request.getParameter("diag_desc")%>(<%=request.getParameter("diag_code")%>)</TITLE>
<iframe SRC = "../../eMR/jsp/AddAssociateCodeListOfValues.jsp?<%=request.getQueryString()%>" NAME="AddAssociateCodeListFrame" noresize style="height:40%;width:100vw"></iframe>
	<iframe SRC = "../../eMR/jsp/AddAssociateCodeAddModify.jsp?<%=request.getQueryString()%>" NAME="AddAssociateCodeAddModifyFrame" noresize scrolling="no" style="height:100vh;width:100vw"></iframe><iframe src='../../eCommon/html/blank.html' name='messageFrame' id='messageFrame' noresize frameborder=0 scrolling='no' style='height:10%;width:100vw'></iframe>
</HTML>

