<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	 <iframe name='IssuesView' id='IssuesView' src='../../eFM/jsp/DTIssueFilesView.jsp' frameborder=0 scrolling=auto noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='IssueViewColor' id='IssueViewColor' src='../../eFM/jsp/FMIssueFilesViewColor.jsp' scrolling=no frameborder=0 noresize style='height:10%;width:100vw'></iframe>
	 
</html>


