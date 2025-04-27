<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<HTML>
	<HEAD>
	<%
				String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<link rel="stylesheet" type="text/css" href="../html/CommonCalendar.css" />
		<!-- import the calendar script -->
		<script type="text/javascript" src="../js/CommonCalendar.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<TITLE><fmt:message key="Common.CalendarSelect Date.label" bundle="${common_labels}"/></TITLE>
	</HEAD>
 	<BODY onKeyDown = 'lockKey()'>
		<TABLE    align="center" width="100%" height="100%" valign="middle" cellpadding=0 cellspacing=0 border=0>
		<TR>
		<TD width="5%" style="background:white" >&nbsp;</TD>
		<TD  align="center" style="background:white">  
			<div id="display"  ></div>
		 </TD>
		<TD width="5%"  style="background:white" ></TD>
		</TR>		
		</TABLE>
	</BODY>
	<script>
		showFlatCalendar(window.dialogArguments)
	</script>
</HTML>

