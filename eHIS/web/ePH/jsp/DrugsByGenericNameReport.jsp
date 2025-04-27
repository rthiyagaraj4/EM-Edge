<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
 <%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<HTML>
<HEAD>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhRepDrugsByGenericName.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eOR/js/OrCommonLookup.js"></SCRIPT>
<HEAD>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name="searchFrame" id="searchFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="PhRepDrugsByGenName.jsp" style="height:83vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCommon/jsp/error.jsp" style="height:9vh;width:100vw"></iframe>

