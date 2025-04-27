<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhRepPatFill.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	
	
<HEAD>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="searchFrame" id="searchFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../ePH/jsp/PhRepPatListCriteria.jsp?medicationlist_flag=N" style="height:80vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCommon/jsp/error.jsp" style="height:12vh;width:100vw"></iframe>

