<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<TITLE><fmt:message key="ePH.TPNWorkSheet.label" bundle="${ph_labels}"/></TITLE>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNWorkSheet.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String url = "TPNWorkSheetDetails.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>


	<!-- <FRAME name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" FRAMESPACING="0" SCROLLING="auto" NORESIZE SRC="TPNWorkSheetHeader.jsp?<%=params%>"> -->
	<iframe name="f_query_add_mod" id="f_query_add_mod" FRAMEBORDER="0" FRAMESPACING="0" SCROLLING="auto" NORESIZE SRC="<%= source %>" style="height:88vh;width:100vw"></iframe>
	<!-- <FRAME name="messageFrame" id="messageFrame" FRAMEBORDER="0" FRAMESPACING="0" SCROLLING="no" NORESIZE SRC="TPNWorkSheetButtons.jsp?<%=params%>"> -->"
	<iframe name="messageFrame" id="messageFrame" FRAMEBORDER="0" FRAMESPACING="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:12vh;width:100vw"></iframe>
</HTML>

