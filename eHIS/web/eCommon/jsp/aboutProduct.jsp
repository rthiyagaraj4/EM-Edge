<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> About IBA </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../html/<%=sStyle%>' type='text/css' ></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>

<BODY  LEFTMARGIN=0 RIGHTMARGIN=0 TOPMARGIN=0 BOTTONMARGIN=0 SCROLL="NO" onKeyDown = 'lockKey()'>
	<TABLE width="100%"  height="105%" class="white" border=0 cellspacing=0 cellpadding=0 >
	<TR>
		<TD width="100%" HEIGHT="100%"align="center" valign="top" class="white"><IMG SRC="../images/AboutProduct.gif" WIDTH="410" HEIGHT="208" BORDER=0 ALT=""></TD>
	</TR>
	</TABLE>
	
</BODY>
</HTML>

