<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	20 Nov 2004.
* --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload='FocusFirstElement();'>
<form name='formStaffProfCriteria' id='formStaffProfCriteria' action='../../servlet/eRS.StaffProfileSetupServlet' method='POST'
target='messageFrame'>
<table cellpadding=0 cellspacing=0 border=0 width="90%" align=center>
<tr><td colspan='2'>&nbsp;</td>
<tr>
	<td width="40%"  align=right class="label"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/>&nbsp;</td>
	<td>&nbsp;<SELECT name="role_type" id="role_type" onChange=''>
		<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
		<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
		<option value="O"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
	</SELECT></td>
</tr>
<tr><td colspan='2'>&nbsp;</td>
<tr>
	<td width="40%"  align=right class="label"><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/>&nbsp;</td>
	<td>&nbsp;<input type=text name="staff_text" id="staff_text" value="" size="36" readonly><input class='button' type=button name="stafflookup_button" id="stafflookup_button" value="?"  onClick='showStaff(staff_text)'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	<input type='hidden' name='staff_id' id='staff_id' value=''>
	<input type='hidden' name='staff_type' id='staff_type' value=''>
</tr>
<tr>
	<td colspan="2">&nbsp;</td>
</tr>

</table>
 <table cellpadding=0 cellspacing=0 border=0 width="90%" align=center>
<td align='center' colspan='4'>&nbsp;<input class='button' type=button name="skill" id="skill" value='<fmt:message key="eRS.Skills.label" bundle="${rs_labels}"/>'onClick='skillDetails()'></td>
<td align='center' colspan='4'>&nbsp;<input class='button' type=button name="experience" id="experience" value='<fmt:message key="eRS.Experience.label" bundle="${rs_labels}"/>'onClick='experienceDetails()'></td>
<td align='center' colspan='4'>&nbsp;<input class='button' type=button name="training" id="training" value='<fmt:message key="eRS.Training.label" bundle="${rs_labels}"/>'onClick='trainingDetails()'></td>
<td align='center' colspan='4'>&nbsp;<input class='button' type=button name="license" id="license" value='<fmt:message key="eRS.Licensure.label" bundle="${rs_labels}"/>'onClick='licenseDetails()'></td>
</tr>
<tr><td colspan='16'>&nbsp;</td>
</table> 
</form>
</body>
</html>

