<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String p_module_id		= "MR" ;
	String p_report_id		= "MRBATLST" ;
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
<form name="repallergytype" id="repallergytype" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'  cellPadding="3" cellSpacing="0">
		<tr>
		<td class="COLUMNHEADER" colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
		</tr>

						<tr>
						<td width="40%" class='label'>&nbsp;</td>
						<td class="querydata" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="30%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td class="label"><fmt:message key="eMR.AllergyClassCode.label" bundle="${mr_labels}"/></td>
						<td class='fields' ><select name='p_fm_allergy_class' id='p_fm_allergy_class' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option><option value='D'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option><option value='F'><fmt:message key="Common.Food.label" bundle="${common_labels}"/></option><option value='G'><fmt:message key="Common.general.label" bundle="${common_labels}"/></option><option value='I'><fmt:message key="Common.Inhalant.label" bundle="${common_labels}"/></option><option value='T'><fmt:message key="Common.Topical.label" bundle="${common_labels}"/></option></select>
						</td>
						<td class='fields'> <select name='p_to_allergy_class' id='p_to_allergy_class'> <option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option><option value='D'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option><option value='F'><fmt:message key="Common.Food.label" bundle="${common_labels}"/></option><option value='G'><fmt:message key="Common.general.label" bundle="${common_labels}"/></option><option value='I'><fmt:message key="Common.Inhalant.label" bundle="${common_labels}"/></option><option value='T'><fmt:message key="Common.Topical.label" bundle="${common_labels}"/></option></select>
						</td>
					</tr>

				<tr>
					<td class="label"><fmt:message key="eMR.AllergyTypeCode.label" bundle="${mr_labels}"/></td>
					<td class='fields'  ><input type=text  name='p_fm_allergy_code' id='p_fm_allergy_code' size="2" maxlength="2" align="center"><input type='button' name='allergytype' id='allergytype' value='?' class='button' onclick='searchCodeAllergyType(this, p_fm_allergy_code)'>
					</td>
					<td class='fields'><input type=text  name='p_to_allergy_code' id='p_to_allergy_code' size="2" maxlength="2" align="center"><input type='button' name='allergytype1' id='allergytype1' value='?' class='button' onclick='searchCodeAllergyType(this, p_to_allergy_code)'>
					</td>
				</tr>

				<tr>
					<td class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan='2'>
						<select name='p_nature' id='p_nature'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>

				<tr>
					<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan='2'>
						<select name='p_order_by' id='p_order_by'>
						<option value='1,2'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
						<option value='1,3'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
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

