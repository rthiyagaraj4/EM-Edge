<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	 <script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseStaticsByAgeRange.js"></SCRIPT>
<HEAD>

<%

	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="<%= source %>" style="height:7vh;width:100vw"></iframe>
<iframe name="searchFrame" id="searchFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="DispenseStaticsByAgeRangeCriteria.jsp" style="height:80vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCommon/jsp/error.jsp" style="height:12vh;width:100vw"></iframe>

