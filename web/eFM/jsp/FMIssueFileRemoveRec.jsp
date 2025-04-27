<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/>
<jsp:useBean id="FMFilesIssueDetail" scope="session" class="webbeans.eFM.FMFilesIssueDetail"/>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript'src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();' class='message'>
	<form name='IssueFileRemove_form' id='IssueFileRemove_form'>
	<%
		int index = Integer.parseInt(request.getParameter("Indval"));
		FMIssueFilesCart.delIssuesfromCart(index);
	%>
	</form>
	<script>parent.frames[2].location.reload(); </script>
</body>
</html>

