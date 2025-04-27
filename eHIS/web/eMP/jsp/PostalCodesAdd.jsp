<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:30 AM -->

<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<Script src="../../eMP/js/Postal.js" language="JavaScript"></Script>

	</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('postal_code')">
	<form name="postal_form" id="postal_form" action="../../servlet/eMP.PostalServlet" method="post" target="messageFrame">
	<BR><BR><BR><BR><BR><BR><BR><BR>
		<div align="left">
		  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>
			  <tr>
				<td width='40%'>&nbsp;</td>
				<td width='60%' colspan='2'></td>
			</tr>
			<tr>
				<td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td width="60%" colspan="2" class='fields'><input type="text" name="postal_code" id="postal_code" size="8" maxlength="8" OnBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img></td>
			</tr>
			<tr>
				<td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td width="60%" colspan="2" class='fields'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
			</tr>
			<tr>
				<td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td width="60%" colspan="2" class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
			</tr>

			<tr>
				<td width="40%" class="label"><fmt:message key="Common.Town.label" bundle="${common_labels}"/></td>
				<td width="60%" colspan="2" class='fields'><INPUT type='text' name='resTownDesc' id='resTownDesc' size='30' maxlength='30' value='' onBlur='searchTown(this,resTownDesc)'><INPUT type='hidden' name='res_town_code' id='res_town_code'><input type='button' name='resTownCodeButton' id='resTownCodeButton' value='?' class='button' onclick='searchTown(this,resTownDesc)'></td>
			</tr>

			<input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"    maxlength="10">
			<input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10" maxlength="10">
			
			<tr>
				<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td width="60%" class='fields' colspan="2"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td></tr>
			<tr>
				<td width='40%'>&nbsp;</td>
				<td width='60%' colspan='2'></td>
			</tr>
		  </table>
		</div>

		<input type="hidden" name="function" id="function" value="insert">
		<input type="hidden" name="function_name" id="function_name" value="insert">
		<input type="hidden" name="eff_date_from" id="eff_date_from" >
		<input type="hidden" name="eff_date_to" id="eff_date_to" >
	</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

