<!DOCTYPE html>
<%@ page import="javax.naming.*,java.io.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.ChatPage.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- <link rel="stylesheet" type="text/css" href="../html/IeStyle.css"></link> -->
<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
<script src='../../eCA/js/InstantMessengerChat.js' language='javascript'></script>
</head>
<frameset cols="75%,25%,0%,0%,0%" FRAMESPACING=0>
	<frameset rows="76%,24%">
		<frame src="../eCA/jsp/InstantMessengerChatMessageTable.jsp" noresize scrolling="auto" name="tableFrame" frameborder=0 framespacing=0 >
		<frame src="../eCA/jsp/InstantMessengerChatSendText.jsp"     noresize scrolling="no" name="sendtextframe" frameborder=0 framespacing=0>
	</frameset>
	<frameset rows="76%,24%">
		<frame src="../eCA/jsp/InstantMessengerChatUserTree.jsp"     noresize scrolling="yes" name="treeframe" frameborder=0 framespacing=0>
		<frame src="../eCA/jsp/InstantMessengerChatButtons.jsp"      noresize scrolling="no" name="buttonsframe" frameborder=0 framespacing=0>
	</frameset>
	  <frame src="../eCommon/html/blank.html"    scrolling="no" name="blankframe1" frameborder=0>
	  <frame src="../eCA/jsp/InstantMessengerChatReceiveThread.jsp"    scrolling="no" name="blankframe2" frameborder=0>
	 <frame src="../eCA/jsp/InstantMessengerChatTreeRefresh.jsp"    scrolling="no" name="blankframe3" frameborder=0>
</frameset>
</html>
