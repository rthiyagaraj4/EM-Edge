<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,java.lang.*"%>
<html>

<head>
<%

		request.setCharacterEncoding("UTF-8");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/StMessages.js"></script> -->
		<script language="JavaScript" src="../js/StockSummaryReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<%
		String url			=		"../../eCommon/jsp/commonToolbar.jsp?" ;
		String params		=		request.getQueryString() ;
		String source		=		url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eST/jsp/StockSummaryListFrameset.jsp" style="height:82vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:10vh;width:100vw"></iframe>

</html>


