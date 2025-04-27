<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../js/PresRemark.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IPFill.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>

<%
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_generatefilllist" id="f_generatefilllist" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/PHGenerateFillList.jsp" style="height:73vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/error.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:19vh;width:100vw"></iframe>
</HTML>

