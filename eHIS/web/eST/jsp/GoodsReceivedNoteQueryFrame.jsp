<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page  import="java.lang.*" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--  	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String params = request.getQueryString();
%>
<iframe name="GoodsReceivedNoteQueryHeader" id="GoodsReceivedNoteQueryHeader" frameborder="0" scrolling="no" noresize src="../../eST/jsp/GoodsReceivedNoteQueryCriteria.jsp?<%=params%>" style="height:76%;width:100vw"></iframe><iframe name="GoodsReceivedNoteQueryResult" id="GoodsReceivedNoteQueryResult" frameborder="0" src="../../eCommon/html/blank.html" scrolling="auto"  style="height:100vh;width:100vw"></iframe>
</html>

