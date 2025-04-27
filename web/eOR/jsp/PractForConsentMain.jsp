<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head><title><fmt:message key="eOR.PractForConsent.label" bundle="${or_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String queryString = request.getQueryString()+"&group_by=C";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOR/js/PractForConsent.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name="framePractForConsentHdr" id="framePractForConsentHdr" src= "../../eOR/jsp/PractForConsentHdr.jsp?<%=queryString%>" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:8vh;width:100vw"></iframe>
<iframe name="framePractForConsentDtl" id="framePractForConsentDtl" Src="../../eOR/jsp/PractForConsentDtl.jsp?group_by=C"  framespacing="0" frameborder="0" scrolling=NO noresize style='height:20vh;width:100vw'></iframe>
<iframe name="framePractForConsentList" id="framePractForConsentList" src='../../eCommon/html/blank.html' framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:70vh;width:100vw'></iframe>

</html>

