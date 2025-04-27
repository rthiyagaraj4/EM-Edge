<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eCA.LinkResultDocuments.label" bundle="${ca_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<frameset cols='30%,70%'>
	<!-- 1st Frame --><frame name="RecClinicalNotesLinkDocsTreeViewFrame" src ="../../eCA/jsp/RecClinicalNotesLinkDocsTreeView.jsp?<%=request.getQueryString()%>" frameborder=1>
	</frame>
	<frameset rows = '44%,6%,45%,5%' frameborder=1>
		<!-- 2nd Frame --><frame name="RecClinicalNotesLinkDocsPreviewFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		<!-- 3rd Frame --><frame name="RecClinicalNotesLinkDocsSelectFrame" frameborder="1" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesLinkDocsDisplaySelect.jsp" scrolling="no"></frame>
		<!-- 4th Frame --><frame name="RecClinicalNotesLinkDocsFinalFrame" frameborder="1" scrolling="auto" noresize src = "../../eCA/jsp/RecClinicalNotesDocFinal.jsp"></frame>
		<!-- 5th Frame --><frame name="RecClinicalNotesLinkDocsAdditionFrame" frameborder="1" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkDocsDisplayApprove.jsp" scrolling="no"></frame>
	</frameset>
</frameset>
</html>
