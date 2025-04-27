<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<FRAMESET ROWS="8%,20%,32%"  name='asgnPrevilegeFrm' id='asgnPrevilegeFrm' framespacing='0' frameborder='0' >
<FRAME SRC="../../eOR/jsp/AssignPrivilegeGroupHdr.jsp?<%=request.getQueryString()%>" NAME="AssignPrivilegeGroupHdr" scrolling='no' noresize >
<FRAME SRC="../../eCommon/html/blank.html" NAME="AssignPrivilegeGroupDtl"  scrolling='no' noresize >
<FRAME SRC="../../eCommon/html/blank.html" NAME="AssignPrivilegeGroupResult"  scrolling='auto' noresize >
</FRAMESET>

</HTML>

