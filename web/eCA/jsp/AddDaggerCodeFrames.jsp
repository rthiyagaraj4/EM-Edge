<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<TITLE><fmt:message key="Common.AddAssociateCodesfor.label" bundle="${common_labels}"/> <%=request.getParameter("diag_desc")%>(<%=request.getParameter("diag_code")%>)</TITLE>
</HEAD>
<FRAMESET ROWS="85%,*"	border=0  >
	<FRAME SRC = "../../eCA/jsp/AddDaggerCodeAddModify.jsp?<%=request.getQueryString()%>" NAME="AddDaggerCodeAddModifyFrame" noresize>
	<FRAME SRC = "../../eCA/jsp/AddDaggerCodeTools.jsp?<%=request.getQueryString()%>" NAME="AddDaggerCodeToolsFrame" noresize scrolling="no">
	<frame src='../../eCommon/html/blank.html' name='messageFrame' id='messageFrame' noresize frameborder=0>
</FRAMESET>
</HTML>

