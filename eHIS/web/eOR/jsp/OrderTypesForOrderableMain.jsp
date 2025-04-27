<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<head>
	<title><fmt:message key="eOR.OrderTypesforOrderableMain.label" bundle="${or_labels}"/></title>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../js/OrderTypesForOrderable.js'></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<frameset rows="30%, 70%">
<frame name="OrTypeOrderableHdr" id="OrTypeOrderableHdr" src="../../eOR/jsp/OrderTypesForOrderableHdr.jsp?<%=request.getQueryString()%>" noresize scrolling='no' frameborder='0'></frame>
<frame name="OrTypeOrderableDtl" id="OrTypeOrderableDtl" src="../../eCommon/html/blank.html" noresize scrolling='no' frameborder='0'></frame>
</frameset>
</html>

