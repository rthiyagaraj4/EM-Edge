<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String compPrompt = request.getParameter("compPrompt") == null ? "" : request.getParameter("compPrompt");
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE><fmt:message key="eCA.LookUpfor.label" bundle="${ca_labels}"/> <%=compPrompt%></TITLE>
</HEAD>
<iframe SRC = "../../eCA/jsp/RecClinicalNotesTempCompDfltValLookup.jsp?<%=request.getQueryString()%>" NAME="RecClinicalNotesTempCompDfltValLookupFrame" noresize frameborder="0" style="height:85vh;width:100vw"></iframe>
	<iframe SRC = "../../eCA/jsp/RecClinicalNotesTempCompDfltValLookupCancel.jsp?<%=request.getQueryString()%>" NAME="RecClinicalNotesTempCompDfltValLookupCancelFrame" noresize frameborder="0"  scrolling="no" style="height:12vh;width:100vw"></iframe>
</HTML>

