<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	</head>
	<title><fmt:message key="eIP.PatientFamilyDetails.label" bundle="${ip_labels}"/></title>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onLoad= 'FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='PatientFamilyDetails' id='PatientFamilyDetails'> 
		<table cellspacing='0' cellpadding='0' width='100%' border=0>
			<tr><th valign=top colspan=2 align='left'><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></th></tr>
			<tr><td valign=top colspan=2>&nbsp;</td></tr>
			<tr><td valign=top width='50%'><table cellspacing='0' cellpadding='0' border=0>
			<tr><td align='right' class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td><input type="text" name="contact_name" id="contact_name" value="" maxlength='30' size='30'></td>
			</tr>
			<tr>
				<td align='right' class='label' nowrap>&nbsp;&nbsp;<fmt:message key="Common.relationship.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td><select name='first_contact_relation' id='first_contact_relation' tabIndex='72'>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
				</select></td>
			</tr>	
			<tr>
				<td align='right' class='label'>&nbsp;&nbsp;</td><td> <input type='text' name='new_national_id' id='new_national_id' maxlength='20' size='20' tabIndex='62' onblur='makeValidString(this);' value= ""></td>
			</tr>
			<tr>
				<td align='right' class='label'>&nbsp;&nbsp;</td><td> <input type='text' name='alt_id1_no' id='alt_id1_no' maxlength='20' size='20' onblur='makeValidString(this);' value= ""></td>
			</tr>
			<tr>
				<td align='right' class='label'>&nbsp;&nbsp;</td><td> <input type='text' name='alt_id2_no' id='alt_id2_no' maxlength='20' size='20'  onblur='makeValidString(this);' value= ""></td>
			</tr>
			<tr>
				<td align='right' class='label'>&nbsp;&nbsp;</td><td> <input type='text' name='alt_id3_no' id='alt_id3_no' maxlength='20' size='20'  onblur='makeValidString(this);' value= ""></td>
			</tr>
			<tr>
				<td align='right' class='label'>&nbsp;&nbsp;</td><td> <input type='text' name='alt_id4_no' id='alt_id4_no' maxlength='20' size='20'  onblur='makeValidString(this);' value= "">
			</td>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td><select name='Other_id_type' id='Other_id_type'><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select>
				<input type='text' name='other_id_type' id='other_id_type' maxlength='20' size='20' tabIndex='63' onblur='makeValidString(this);' value = ""></td>
			</tr>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td><input type='text' name='birth_date' id='birth_date' id='birthdate' maxlength='10' size='10' tabIndex='74' onblur='makeValidString(this);' value = ""><input type='image' src='../../eCommon/images/CommonCalendar.gif' id="birthdate"  onClick="document.forms[0].birth_date.select();return showCalendar('birthdate');" tabindex=-1></td>
			</tr>	
			<tr>
				<td align='right' class='label'><fmt:message key="Common.JobTitle.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td><input type='text' name='next_job_title' id='next_job_title' maxlength='30' size='30' tabIndex='63' onblur='makeValidString(this);' value = ""></td>
			</tr>
			</table>
			</td> 
			<td><table cellspacing='0' cellpadding='0' border=0>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td><select name='first_country_code' id='first_country_code' tabIndex='80'>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option></select>
				</td>
			</tr>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td><input type='text' name='next_res_tel_no' id='next_res_tel_no' maxlength='20' size='20' tabIndex='70' onblur='makeValidString(this);' value = ""></td>
			</tr>
			<tr>
				<td align='right' class='label' nowrap><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td><input type='text' name='next_off_tel_no' id='next_off_tel_no' maxlength='20' size='20' tabIndex='71' onblur='makeValidString(this);' value = ""></td>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td>
				<input type='text' name='off_phone_no' id='off_phone_no' maxlength='20' size='20' tabIndex='81' onblur='makeValidString(this);' value = "">
				</td>
			</tr>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td>
				<input type='text' name='email_id' id='email_id' maxlength='50' size='45' tabIndex='82' onblur='makeValidString(this);' value = "">
				</td>
			</tr>
			</td></tr></table></td></tr>
			<tr><td valign=top colspan=2>&nbsp;</td></tr>
			<tr><td valign=top colspan=2 class=white>&nbsp;</td></tr>
		</table>
	</form>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

