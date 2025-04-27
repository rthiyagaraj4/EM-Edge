<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title><fmt:message key="eOR.IndexTickSheet.label" bundle="${or_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOR/js/IndexTickSheet.js"></script>
<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="headerFrame" id="headerFrame" src= "../../eOR/jsp/IndexTickSheetAddModify.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:16vh;width:100vw"></iframe>
<iframe name="detailFrame" id="detailFrame" src='../../eCommon/html/blank.html' framespacing="0" noresize frameborder="0"  scrolling="auto" style='height:84vh;width:100vw'></iframe>

</html>

