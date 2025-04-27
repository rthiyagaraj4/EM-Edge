<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<HEAD> 
	 <script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PHPickListReport.js"></SCRIPT>
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="<%= source %>" frameborder='0' style="height:10vh;width:100vw"></iframe><iframe name="searchFrame" id="searchFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../ePH/jsp/PhRepPickListProcessParam.jsp" frameborder='0' style="height:78vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCommon/jsp/error.jsp" frameborder='0' style="height:12vh;width:100vw"></iframe>

