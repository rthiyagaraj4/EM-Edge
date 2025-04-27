<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>

<html><%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<head><title><fmt:message key="eOR.MultiFacilityProcessing.label" bundle="${or_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script language="JavaScript" src="../../eOR/js/MultiFacilityProcessing.js"></script>
<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<frameset rows="40%,*%" framespacing=0>
<frame name="headerFrame" src= "../../eOR/jsp/MultiFacilityProcessingHdr.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
<frame name="detailFrame" src='../../eCommon/html/blank.html' framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
</frameset>
</html>

