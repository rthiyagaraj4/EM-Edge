<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086 			
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
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
	<title> <fmt:message key="eST.DocumentsforAuthorize.label" bundle="${st_labels}"/> </title>
</head>
<%
	String params = request.getQueryString();
%>
<iframe name="RIAuthorizeQueryHeaderFrame" id="RIAuthorizeQueryHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/RequisitionIssueAuthorizeQueryCriteria.jsp?<%=params%>" style="height:30vh;width:100vw">
</iframe><iframe name="RIAuthorizeQueryResultFrame" id="RIAuthorizeQueryResultFrame" frameborder="0" src="../../eCommon/html/blank.html" scrolling="no"  style="height:70vh;width:100vw"></iframe>
</html>

