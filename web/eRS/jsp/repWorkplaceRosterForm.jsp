<!DOCTYPE html>
<!--repWorkplaceRosterForm.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:   Report
*	Created By		:	P.Anuradha
*	Created On		:	23 June 2005-->

<%-- JSP Page specific attributes start --%>
<%@ page language="java" import ="java.util.*, java.sql.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/RSCommonFunction.js"> </script>
<script language="javascript" src="../js/repWorkplaceRoster.js"> </script>
<script language="javascript" src="../js/RSMessages.js"> </script>
<script language="javascript" src="../../eCommon/js/messages.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="RepWorkplaceRoster_Form" id="RepWorkplaceRoster_Form" ACTION="../../eCommon/jsp/report_options.jsp" target='messageFrame'>	
<br><br><br>
<table cellpadding=0 cellspacing=0 border=0 width="60%" align='center'>
<tr><td colspan=4>&nbsp;</td></tr>
<tr><td colspan=4>&nbsp;</td></tr>
<tr>
<td class='label' width="30%" align='right'>Workplace</td>
<td align='left' colspan=2>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value='' name='workplace_text' id='workplace_text'><input type=hidden name='workplace_code' id='workplace_code' value=''><input type='button' name="workplace_lookup" id="workplace_lookup" class="button" value="?" onClick='viewWorkPlace(workplace_text)'>
</tr>
<tr><td colspan="4">&nbsp;</td></tr>
<tr><td colspan="4">&nbsp;</td></tr>
</table>
<input type=hidden name="p_facility_id" id="p_facility_id" value="<%=session.getValue("facility_id")%>">
<input type=hidden name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>">
<input type=hidden name="p_module_id" id="p_module_id" value="RS">
<input type=hidden name="p_report_id" id="p_report_id" value="RSBWPRST">
</form>
</body>
</html>	

