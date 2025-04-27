<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	CancelWorkScheduleHdr.jsp
*	Purpose 		:
*	Created By		:	Sreenivasulu.Y
*	Created On		:	19 Nov 2004
-->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/RSCommon.js"></script>
	
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='formCanWrkSchHdr' id='formCanWrkSchHdr' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0  id='titleTab' width="100%">
<tr>
<th rowspan="2" width='12%'><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></th>
<th rowspan="2" width='11%'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>
<th rowspan="2" width='19%'><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/></th>
<th rowspan="2" width='11%'><fmt:message key="eRS.ScheduleDate.label" bundle="${rs_labels}"/></th>
<th rowspan="2" width='13%'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></th>
<th colspan="2" width='5%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
<th colspan="2" width='5%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
<th rowspan="2" width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>
</table>
</form>
</body>
</form>

