<!DOCTYPE html>
<%
	/* Mandatory checks start */
	String mode = request.getParameter( "mode" )==null?"":request.getParameter( "mode" ) ;
%>
<%@ page language="java" contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js'></script>
<script language="javascript" src="../js/SkillForPosition.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="form_byPosition" id="form_byPosition">		
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="30%"><fmt:message key="Common.Role.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="70%">&nbsp;&nbsp;&nbsp;<select name="role_type1" id="role_type1" onchange='populateStaffType1()'>
					<option value="" selected>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
					<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>		
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="30%"><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="70%">&nbsp;&nbsp;&nbsp;<select name="staff_type" id="staff_type" onchange="clearPositionDesc();">
					<option value="" selected>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="30%"><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="70%">&nbsp;&nbsp;&nbsp;<input type=text name="position_desc" id="position_desc" size='20' maxlength='20' onblur='viewPosition("T",position_desc);'><input type=button class=button value='?' name='position_lookup' id='position_lookup' onclick='viewPosition("B",position_desc);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<input type=hidden name="position_code" id="position_code" value="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=button class=button value='<fmt:message key="eRS.ShowSkills.label" bundle="${rs_labels}"/>' name='show_skill' onclick='showSkillList()'>
				</td>
			</tr>
		</table>	
 

<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
</form>
</body>
</html>

