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
<frameset rows='90%,10%' framespacing='0'>
<%
	String result_linked_rec_type	= request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	if( result_linked_rec_type.equals("DIAG")|| result_linked_rec_type.equals("MEDN"))
	{
%>
		<frame name="RecClinicalNotesLinkDocsFrame" frameborder="1" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesTree.jsp?<%=request.getQueryString()%>"></frame>
<%
	}
	else
	{
%>

	<frameset cols='30%,70%' frameborder=1>
		<frame name="RecClinicalNotesLinkDocsFrame" frameborder="1" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesTree.jsp?<%=request.getQueryString()%>"></frame>

		<frame name="RecClinicalNotesLinkDocsViewFrame" frameborder="1" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame><!-- eCA/jsp/Editor.jsp RecClinicalNotesSecDetails-->
	</frameset>
<%
	}
%>
	<frame name="RecClinicalNotesLinkDocsTBFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesLink.jsp"></frame>
</frameset>

</html>
