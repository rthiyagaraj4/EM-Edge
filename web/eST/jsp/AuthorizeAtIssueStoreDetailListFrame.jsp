<!DOCTYPE html>
	 <jsp:useBean id="obj0" scope="page" class="eST.AuthorizeAtIssueStoreBean"/>
<%@ page import="eST.AuthorizeAtIssueStoreBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/RequisitionIssue.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params = request.getQueryString();
%>
<iframe name="AuthorizeAtIssueStoreFrame" id="AuthorizeAtIssueStoreFrame" src="../../eST/jsp/AuthorizeAtIssueStoreList.jsp?<%=params%>" frameborder="0" noresize scrolling="auto" style="height:221%;width:100vw"></iframe><iframe name="AuthorizeAtIssueStoreDetailFrame" id="AuthorizeAtIssueStoreDetailFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?<%=params%>" style="height:100vh;width:100vw"></iframe>
</html> 

