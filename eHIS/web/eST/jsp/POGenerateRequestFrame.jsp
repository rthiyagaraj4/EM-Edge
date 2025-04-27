<!DOCTYPE html>
 <%@ page  contentType="text/html;charset=UTF-8"%>
 <%@ page import=" eST.POGenerateRequestBean" contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/POGenerateRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



    <script>
        function_id				=		"<%= request.getParameter("function_id")%>";
		menu_id					=		"<%= request.getParameter( "menu_id" ) %>"
		module_id				=		"<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%

	String params = request.getQueryString();
	
%>

<iframe name="POGenerateRequestHeaderFrame" id="POGenerateRequestHeaderFrame" frameborder="0" scrolling="auto" noresize src="../../eST/jsp/POGenerateRequestHeader.jsp?mode=1&<%=params%>" style="height:35vh;width:100vw"></iframe>
<iframe name="POGenerateRequestDetailFrame" id="POGenerateRequestDetailFrame" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:65vh;width:65vw"></iframe>
</html>

