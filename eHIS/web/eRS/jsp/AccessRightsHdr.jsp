<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	P.Anuradha
*	Created On		:	19 Jan 2005
-->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/AccessRights.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	/* Mandatory checks start */
    String facility_id = (String)session.getAttribute("facility_id");
%>
<body  onMouseDown="CodeArrest();" onKeyDown="lockKey();">
<form name='AccessRightsHeader_Form' id='AccessRightsHeader_Form' target='messageFrame'>
<table cellpadding=0 cellspacing=0 border=0 width="98%" align=center>
<tr>
<td colspan="2">&nbsp;</td>
</tr>
<tr>
<td width="35%"  align=right class="label"><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;</td>
<td>&nbsp;<input type=text name="user_name" id="user_name" value="" size="25" readonly><input type=hidden name="user_code" id="user_code" value=""><input class='button' type=button name="userlookup_button" id="userlookup_button" value="?" onClick="displayUser(this,user_name,user_code);">&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;
</td>
</tr>
<tr>
<td colspan="2">&nbsp;</td>
</tr>
<tr>
<td width="35%"  align=right class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
<td>&nbsp;<input type=text name="workplace1" id="workplace1" value="" size="25" readonly><input type=hidden name="workplace_code1" id="workplace_code1" value=""><input class='button' type=button name="workplacelookup_button" id="workplacelookup_button" value="?" onClick="displayWorkPlace(this,workplace1,workplace_code1);">
</td>
</tr>
<tr>
<td align='right' colspan="2">&nbsp;<input class='button' type=button name="showwrkplace_button" id="showwrkplace_button" value='<fmt:message key="eRS.ShowWorkplaces.label" bundle="${rs_labels}"/>'onClick="showDetails()">
</td>
</tr>
</table>
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
</html>
					

