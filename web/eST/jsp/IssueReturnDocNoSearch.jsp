<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
	<script language="JavaScript" src="../../eST/js/IssueReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
	<title> Issue Document Number Search </title>
</head>
<%
	String params = request.getQueryString();
 %>
<iframe name="IssueDocNoSearchHeaderFrame" id="IssueDocNoSearchHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/IssueReturnDocNoSearchCriteria.jsp?<%=params%>" style="height:16vh;width:100vw"></iframe>
<iframe name="IssueDocNoSearchResultFrame" id="IssueDocNoSearchResultFrame" frameborder="0" src="../../eCommon/html/blank.html" scrolling="yes"  style="height:84vh;width:100vw"></iframe>
</html>

