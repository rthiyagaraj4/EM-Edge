<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

String line_narration = request.getParameter("line_narration");
if(line_narration == null || line_narration.equals("null"))
	line_narration = "";
%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<title><fmt:message key="eOR.Remark.label" bundle="${or_labels}"/></title>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ReviewStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"><!--  onunload='javascript:onOrderRemarkClose()'> -->
<FORM name='OrderRemark' id='OrderRemark' METHOD=POST ACTION="">
<table cellpadding=3 cellspacing=0 border=0 >
<tr><td class=fields><TEXTAREA NAME="remark" ROWS="5" COLS="50" onKeyPress='javascript:CheckMaxLength(this,"256")'><%=line_narration%></TEXTAREA></td></tr>
<tr align="right">
<td class='button'><INPUT TYPE="button"  class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='javascript:checkRemark(document.OrderRemark.remark)'></td></tr>
</table>
</FORM>

</BODY>
</HTML>

