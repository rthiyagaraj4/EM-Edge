<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8" %>

<%@ page import="eOR.Common.*"%>
<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../js/OrdersTab.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="frmLookupTeam" id="frmLookupTeam">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr>
<td>
Medical Team 
<input type="text" name="selectedTeam" id="selectedTeam" value="" size="30" maxlength="6"><input type="button" class="button" name="SearchTeam" id="SearchTeam" value="?" onClick="searchCodeForTeam(selectedTeam)">
<font color="#ff0000">*</font>
</td>
</tr>
</table>
<input type="hidden" name="SQL_OR_USER_FOR_REVIEW_TEAM_LOOKUP" id="SQL_OR_USER_FOR_REVIEW_TEAM_LOOKUP" 
value=<%= OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_TEAM_LOOKUP") %> >
</form>
</body>
</html>

