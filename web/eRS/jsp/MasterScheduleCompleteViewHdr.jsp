<!DOCTYPE html>
<%/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleByWorkplaceResultWeekly.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	04-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 --><script language="JavaScript" src="../../eRS/js/MasterSchedule.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script> -->
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=formByWorkplaceCompleteHdr >
<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
<tr>
<td width='15%' class='OPTIMAL'><fmt:message key="eRS.Optimal.label" bundle="${rs_labels}"/></td>
<td width='15%' class='BELOWOPTIMAL'><fmt:message key="eRS.BelowOptimal.label" bundle="${rs_labels}"/></td>
<td width='15%' class='ABOVEOPTIMAL'><fmt:message key="eRS.AboveOptimal.label" bundle="${rs_labels}"/></td>
<td colspan='4'>&nbsp;</td>
<td width='15%' class='UNPRODUCTIVE'><fmt:message key="eRS.Unproductive.label" bundle="${rs_labels}"/></td>
<td width='15%' class='ONCALL'><fmt:message key="eRS.Oncall.label" bundle="${rs_labels}"/></td>
<td width='5%' align='left'><input type='button' class='button' name='cancel' id='cancel' value='<fmt:message key="Common.Back.label" bundle="${common_labels}"/>'onclick='changeweekall();'></td>
<td width='2%'>&nbsp;</td>
</tr>
</table>
</form>
</body>

