<!DOCTYPE html>
 <jsp:useBean id="obj0" scope="page" class="eST.AuthorizeAtIssueStoreBean"/>
<jsp:useBean id="obj10" scope="page" class="eST.AuthorizeAtIssueStoreDetailBean"/>
<%@ page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
	<script language="JavaScript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String params = request.getQueryString();
	String bean_id = "authorizeAtIssueStoreBean";
	String bean_name = "eST.AuthorizeAtIssueStoreBean";
	AuthorizeAtIssueStoreBean bean = (AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);  
	bean.initialize();
	bean.setLanguageId(locale);
%>
<iframe name="AuthorizeAtIssueStoreHeaderFrame" id="AuthorizeAtIssueStoreHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/AuthorizeAtIssueStoreCreateHeader.jsp?<%=params%>" style="height:60%;width:100vw"></iframe>
<iframe name="AuthorizeAtIssueStoreListFrame" id="AuthorizeAtIssueStoreListFrame" src="../../eST/jsp/AuthorizeAtIssueStoreList.jsp?<%=params%>" frameborder="0" noresize scrolling="auto" style="height:100vh;width:100vw"></iframe>
<iframe name="AuthorizeAtIssueStoreDetailFrame" id="AuthorizeAtIssueStoreDetailFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?<%=params%>" style="height:120%;width:100vw"></iframe>
<%
putObjectInBean(bean_id,bean,request);
%>
</html> 

