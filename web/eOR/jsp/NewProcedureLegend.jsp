<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCA/html/CAStyle.css'>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table border=0  cellpadding=3 cellspacing=0 width="100%" align=center>
<tr>
	<td width='3%' style='background:#FFFF80'><font size=1 ></td>
	<td class="" width='18%'><font size=1 color=''><b>Requested</b></font></td>
	<td width='2%'><font size=1 ></td>
	<td width='3%' style='background:#FF9900'><font size=1></td>
	<td class="" width='18%'><font size=1 color=''><b>Partially Completed</b></font></td>
	<td width='2%'><font size=1 ></td>
	<td width='3%' style='background:#009966'><font size=1 ></td>
	<td class="" width='18%'><font size=1 color=''><b>Completed</b></font></td>
	<td width='2%'><font size=1 ></td>
	<td width='3%' style='background:#990066'><font size=1 ></td>
	<td class="" width='18%'><font size=1 color=''><b>Appt Booked</b></font></td>
	<td width='2%'><font size=1 ></td>
	<td width='15%'><font size=1><b><font color=red>(C)</font>Complications </b></font></td>
</tr>
</table>
</body>
</html>
 

