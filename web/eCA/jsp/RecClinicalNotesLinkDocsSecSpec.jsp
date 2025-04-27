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
<frameset rows='30%,65%,*'>
	<frameset cols = '33%,34%,33%' frameborder=1>
		<!-- 1st Frame --><frame name="RecClinicalNotesLinkDocsTreeFrame" frameborder="1" scrolling="auto" noresize src = "../../eCA/jsp/RecClinicalNotesLinkDocsTree.jsp?<%=request.getQueryString()%>"> </frame>
		<!-- 2nd Frame--><frame name="RecClinicalNotesLinkDocsSectionFrame" frameborder="1" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame>
		<!-- 3rd Frame--><frame name="RecClinicalNotesLinkDocsSubSectionFrame" frameborder="1" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame>
	</frameset>
	<frameset cols='50%,50%' frameborder=1>
		<!-- 4th Frame--><frame name="RecClinicalNotesLinkDocsDisplayFrame" frameborder="no" scrolling="yes" noresize src="../../eCommon/html/blank.html"></frame>
		<!-- 5th Frame--><frame name="RecClinicalNotesLinkDocsLinkFrame" frameborder="no" scrolling="yes" noresize src="../../eCA/jsp/RecClinicalNotesDocFinal.jsp"></frame>
	</frameset>
	<frameset cols = "50%,50%" frameborder=1>
		<!-- 6th Frame--><frame name="RecClinicalNotesLinkDocsDisplaySelectFrame" src="../../eCA/jsp/RecClinicalNotesLinkDocsDisplaySelect.jsp" scrolling="no"></frame>
		<!-- 7th Frame--><frame name="RecClinicalNotesLinkDocsDisplayApproveFrame" src = "../../eCA/jsp/RecClinicalNotesLinkDocsDisplayApprove.jsp" scrolling="no"></frame>
	</frameset>
</frameset>
</html>
