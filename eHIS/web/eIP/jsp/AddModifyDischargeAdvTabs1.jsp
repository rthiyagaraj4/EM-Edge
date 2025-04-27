<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey();setShift();">
		<TABLE border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
			<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eIP.TakeHomeMedicine.label" bundle="${ip_labels}"/></td>
			<tr><td colspan="4" class="label"></td></tr>
			<TR>
				<td width="25%" class='label' width="30%"><fmt:message key="eIP.NewMedicine.label" bundle="${ip_labels}"/></td>
				<td  width="25%" class='fields' ><input type='checkbox' name='newmedicine' id='newmedicine'  value= "Y" tabindex = '22' onkeydown="shift_tab();"></td>
				<td width="25%" class='label'></td>
				<td width="25%" class='label'></td>
			</TR>
			<TR>
				<td class='label' ><fmt:message key="eIP.StockMedicine.label" bundle="${ip_labels}"/></td>
				<td class='fields'><input type='checkbox' name='stockmedicine' id='stockmedicine' value= "Y" tabindex = '23' onkeydown="shift_tab();"></td>
				<td class='label'></td>
				<td class='label'></td>
			</TR>
			<tr><td colspan="4" class="label"></td></tr>
				<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eIP.ChargesIncurredonDischargeDay.label" bundle="${ip_labels}"/></td>
			<tr><td colspan="4" class="label"></td></tr>
			<TR>
				<td class='label' ><fmt:message key="Common.Lab.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='checkbox' name='lab' id='lab' value="Y" tabindex = '24' onkeydown="shift_tab();"></td>
				<td class='label' ><fmt:message key="eIP.Xray.label" bundle="${ip_labels}"/></td>
				<td class='fields'><input type='checkbox' name='xray' id='xray' value='Y'  tabindex = '25' onkeydown="shift_tab();"></td>
			</TR>
			<TR>
				<td class='label' ><fmt:message key="eIP.Scan.label" bundle="${ip_labels}"/></td>
				<td class='fields'><input type='checkbox' name='scan' id='scan' value='Y'  tabindex = '26'></td>
				<td class='label' ><fmt:message key="Common.Ultrasound.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='checkbox' name='ultrasound' id='ultrasound' value='Y'  tabindex = '27'>
				</td>
			</TR>
			<TR>
				<td class='label' ><fmt:message key="eIP.MRI.label" bundle="${ip_labels}"/></td>
				<td class='fields'><input type='checkbox' name='mri' id='mri' value='Y'  tabindex = '28'></td>
				<td class='label' ><fmt:message key="Common.RT.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='checkbox' name='rt' id='rt' value='Y' tabindex = '29'>
				</td>
			</TR>
			<TR>
				<td class='label' ><fmt:message key="eIP.Physio.label" bundle="${ip_labels}"/></td>
				<td class='fields'><input type='checkbox' name='physio' id='physio' value='Y'  tabindex = '30'></td>
				<td class='label' ><fmt:message key="Common.ecg.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='checkbox' name='ecg' id='ecg' value='Y'  tabindex = '31'>
				</td>
			</TR>
			<TR>
				<td class='label' ><fmt:message key="eIP.Diet.label" bundle="${ip_labels}"/></td>
				<td class='fields'><input type='checkbox' name='diet' id='diet' value='Y'  tabindex = '32'></td>
				<td class='label' ><fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='checkbox' name='pharmacy' id='pharmacy' value='Y' tabindex = '33'></td>
			</TR>
		</TABLE>
	</BODY>
</HTML>

