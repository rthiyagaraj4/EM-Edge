<!DOCTYPE html>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AEBIMMOB" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale						= (String)session.getAttribute("LOCALE");
%>

<html>

<HEAD>
<TITLE></TITLE>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../js/AECodeCheck.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repImmobilizationCodeList" id="repImmobilizationCodeList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="80%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0" align='center' border=0>
					<tr>
						<td  width="25%"></td>
						<td  width="25%" class='querydata' ><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
						<td class='querydata' width="25%" ><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
						<td  width="25%"></td>
					</tr>
					<tr>
						<td  class='label' width="25%"><fmt:message key="eAE.ImmobilizationCode.label" bundle="${ae_labels}"/> </td>
						<td width="25%"><input type=text  name='p_fm_immobilization_code' id='p_fm_immobilization_code' size="6" maxlength="6" onBlur='ChangeUpperCase(this);parent.validSplchars(this,"Immobilization Code")' onKeyPress="return CheckForSpecChars(event)"><input type='button' name='Immobilization Code' id='Immobilization Code' value='?' class='button' tabindex =-1 onclick='searchImmobilization(this, p_fm_immobilization_code)'>
						</td>
						<td width="25%"><input type=text  name='p_to_immobilization_code' id='p_to_immobilization_code' size="6" maxlength="6" onBlur='ChangeUpperCase(this);parent.validSplchars(this,"Immobilization Code")' onKeyPress="return CheckForSpecChars(event)"><input type='button' name='Immobilization Code' id='Immobilization Code' value='?' class='button' tabindex=-1 onclick='searchImmobilization(this, p_to_immobilization_code)'>
						</td>
						<td width="25%"></td>
				</tr>
				<tr>
				    <td width="25%" colspan=4>&nbsp;</td>
					<td width="25%"></td>
					<td width="25%"></td>
					<td width="25%"></td>
					</tr>
				<tr>
					<td  class='label' width="25%"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/>  </td>
					<td width="25%">
						<select name='p_nature' id='p_nature'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td width="25%"></td>
					<td width="25%"></td>
				</tr>
<tr>
                    <td width="25%" colspan=4>&nbsp;</td>
					<td width="25%"></td>
					<td width="25%"></td>
					<td width="25%"></td>
					</tr>
				<tr>
					<td class='label' width="25%">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
					</td>
					<td width="25%">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="eAE.ImmobilizationCode.label" bundle="${ae_labels}"/>
						<option value='2'><fmt:message key="eAE.ImmobilizationDesc.label" bundle="${ae_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td width="25%" colspan=4>&nbsp;</td>
					<td width="25%"></td>
					<td width="25%"></td>
					<td width="25%"></td>
					</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="locale" id="locale"			value="<%= locale %>">
</form>
</body>
</html>

