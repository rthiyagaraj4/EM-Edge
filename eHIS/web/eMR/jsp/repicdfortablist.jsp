<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%
	String p_module_id		= "MR" ;
	String p_report_id		= "MRBICDTB" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
<TITLE></TITLE>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../js/repResetRunList.js' language='javascript'>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>

<BODY onload='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repICDForTablist" id="repICDForTablist" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' cellspacing='0' cellpadding='3'>
		<tr>
		<td class="COLUMNHEADER" colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</td>
		</tr>
				<tr>
						<td class='label' width="35%">&nbsp;</td>
						<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eMR.TabulationList.label" bundle="${mr_labels}"/></td>
						<td class='fields'><input type=text onkeypress='return ValidString(event)' name='p_fm_tab_list' id='p_fm_tab_list' size="4" maxlength="4" align="center"><input type='button' name='diagCode' id='diagCode' value='?' class='button' onclick='searchCodeICDCodeForTabList(this, p_fm_tab_list)'>
						</td>
						<td class='fields'> <input type=text onkeypress='return ValidString(event)' name='p_to_tab_list' id='p_to_tab_list' size="4" maxlength="4" align="center"><input type='button' name='diagCode1' id='diagCode1' value='?' class='button' onclick='searchCodeICDCodeForTabList(this, p_to_tab_list)'>
						</td>
				</tr>
					<tr>
						<td class="label"><fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type=text  name='p_fm_icd_code' id='p_fm_icd_code' size="5" maxlength="5" align="center"><input type='button' name='diagCode' id='diagCode' value='?' class='button' onclick='searchCodeICDCodeForTabList(this, p_fm_icd_code)'>
						</td>
						<td class='fields'> <input type=text  name='p_to_icd_code' id='p_to_icd_code' size="5" maxlength="5" align="center"><input type='button' name='diagCode1' id='diagCode1' value='?' class='button' onclick='searchCodeICDCodeForTabList(this, p_to_icd_code)'>
						</td>
				</tr>
				<tr class='label'>
					<td class='label' colspan='3'>&nbsp;</td>
				</tr>
		
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
</form>
</BODY>
</HTML>

