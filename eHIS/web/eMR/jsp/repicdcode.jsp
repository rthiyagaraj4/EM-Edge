<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>

<%
	String p_module_id		= "MR" ;
	String p_report_id		= "MRBICDCD" ;
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
<form name="repicdcode" id="repicdcode" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' cellspacing='0' cellpadding='3'>
		<tr>
		<td class="COLUMNHEADER" colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
		</tr>
					<tr>
						<td class='label' width="35%">&nbsp;</td>
						<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
									<tr>
										<td  class="label"><fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
										<td class='fields'><input type=text  name='p_fm_diag_code' id='p_fm_diag_code' size="5" maxlength="5" align="center"><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCodeICDCode(this, p_fm_diag_code)'>
										</td>
										<td class='fields'> <input type=text  name='p_to_diag_code' id='p_to_diag_code' size="5" maxlength="5" align="center"><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCodeICDCode(this, p_to_diag_code)'>
										</td>
								</tr>
				
				<tr>
					<td class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
					</td>
					<td  class='fields' colspan='2'>
						<select name='p_order_by' id='p_order_by'>
						<option value='3'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
						<option value='4'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
						</select>
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

