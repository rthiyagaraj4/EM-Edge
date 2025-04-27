<!DOCTYPE html>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "MO" ;
	String p_report_id		= "MOBORGAN" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
<HEAD>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eMO/js/MOResetrunList.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onMouseDown='CodeArrest()' onKeyDown="lockKey()">
<br><br>
<form name="repOrgansForDonationList" id="repOrgansForDonationList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="80%" class="Border" align='center'>
		<table width='80%' cellPadding="0" cellSpacing="0" align='center'>
		<tr>
			<td  class='label' width="35%" >&nbsp;</td>
			<td  width="20%" class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="30%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td  class='label' nowrap><fmt:message key="eMO.OrgansForDonationCode.label" bundle="${mo_labels}"/>&nbsp;</td>
			<td width="20%" class='fields'><input type=text  name='p_fm_organ_code' id='p_fm_organ_code' size="4" maxlength="4"	onKeyPress="return CheckForSpecChars(event)" onBlur='ChangeUpperCase(this);parent.validSplchars(this,"organ for donation")'><input type='button' name='organ for donation' id='organ for donation' tabindex=-1 value='?' class='button' onclick='searchCode(this, p_fm_organ_code)'>
			</td>
			<td width="40%" class='fields'><input type=text  name='p_to_organ_code' id='p_to_organ_code' size="4" maxlength="4" onBlur='ChangeUpperCase(this);parent.validSplchars(this,"organ for donation")' onKeyPress="return CheckForSpecChars(event)" ><input type='button' name='organ for donation' id='organ for donation' value='?' class='button' tabindex=-1 onclick='searchCode(this, p_to_organ_code)'>
			</td> 
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td  class='label'><fmt:message key="Common.Nature.label" bundle="${common_labels}"/>  &nbsp;</td>
			<td class='fields'>
			<select name='p_nature' id='p_nature'>
					<option value=""><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
					<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
					<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
			</select>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td  class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='fields'>
				<select name='p_order_by' id='p_order_by'>
					<option value='1'><fmt:message key="eMO.OrgansForDonationCode.label" bundle="${mo_labels}"/>
					<option value='2'><fmt:message key="eMO.OrgansForDonationDesc.label" bundle="${mo_labels}"/>
				</select>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
</form>
</body>
</html>

