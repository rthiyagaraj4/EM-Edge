<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
05/05/2014		IN048091		Karthi L			06/04/2014		Ramesh			Orders>Existing Orders>Open results screen>System shows the last modified comments even though the comments were removed.																		
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String line_narration = request.getParameter("line_narration");
String readonly = request.getParameter("readonly");
line_narration = java.net.URLDecoder.decode(line_narration);  // added for IN048091
if(line_narration == null || line_narration.equals("null"))
	line_narration = "";
//if(readonly==null)	readonly="";
//out.println("line_narration===="+line_narration);
%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<title><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>

 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name='result_entry_line_comment' id='result_entry_line_comment' METHOD=POST ACTION="">
<table cellpadding=3 cellspacing=0 border=0 align=center style="height:85vh;" width="100%">
<tr><td class=fields><TEXTAREA NAME="lineComment" ROWS="5" COLS="59" <%=readonly%> onKeyPress='javascript:CheckMaxLength(this,"255")' onBlur='makeValidString(this)'><%=line_narration%></TEXTAREA></td></tr>
<tr align="right"><td class=button><INPUT TYPE="button"  class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='javascript:checkLineComment(document.result_entry_line_comment.lineComment)'></td></tr>
</table>
</FORM>

</BODY>
</HTML>

