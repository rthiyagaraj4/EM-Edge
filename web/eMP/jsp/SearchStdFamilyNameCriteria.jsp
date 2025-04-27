<!DOCTYPE html>
<!--
    Developed By				: Gaurav Jain
    Created on					: 12/09/2001
    Function					: To search the Family Name
	Last Modified Date / Time	: 12/26/2005 3:05 PM
-->
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

	String other_name_val = "";
	String other_name_loc_lang_val = "";

	String param_value = request.getParameter("param_value") == null?"":request.getParameter("param_value");
	String names_in_oth_lang = request.getParameter("names_in_oth_lang");
	String field_lang = request.getParameter("field_lang");
	if(names_in_oth_lang == null || names_in_oth_lang.equals("null"))
		names_in_oth_lang = "N";

	if(field_lang.equals("English"))
	{
		other_name_val = param_value;
		other_name_loc_lang_val = "";
	}
	else if(field_lang.equals("Others"))
	{
		other_name_val = "";
		other_name_loc_lang_val = param_value;
	}
%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/locale.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eMP/js/StdFamilyName.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()' onKeyPress='if(event.keyCode == 13) return false;'>
    <form name='Search_STD_Family_Name_form' id='Search_STD_Family_Name_form' target='messageFrame'>
		<br>
		<table align='center' border='0' cellspacing='0' cellpadding='0' width='98%'>
			<tr><td width='20%' colspan='4'>&nbsp;</td></tr>
			<tr><td align='right' class="label"><fmt:message key="eMP.LastName.label" bundle="${mp_labels}"/> &nbsp;</td>
				<td><input type=text  name='last_name' id='last_name' size="20" maxlength="20" align="left" value='<%=other_name_val%>'></td>
				<% if(names_in_oth_lang.equals("Y")) { %>
					<td align='right' class="label" nowrap><fmt:message key="eMP.LastNameinOtherLanguage.label" bundle="${mp_labels}"/> &nbsp;</td>
					<td><input type=text  name='last_name_loc_lang' id='last_name_loc_lang' size="20" maxlength="20" value='<%=other_name_loc_lang_val%>' style="text-align:right"   </td>
				<% } else { %><input type='hidden' name='last_name_loc_lang' id='last_name_loc_lang' value=''>
					 <td align='right' class="label" colspan='2'>&nbsp;</td>
				<% } %>
			</tr>
			<tr><td colspan=4>&nbsp;</td></tr>
			<tr><td align='right' class="label" nowrap><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/> &nbsp;</td>
				<td align='left'>
					<select name='criteria' id='criteria'>
						<option value='N' ><fmt:message key="eMP.ByName.label" bundle="${mp_labels}"/></option>
						<option value='S' selected ><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
						<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
						<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>                 
					</select>
				</td>
				<td class="label">&nbsp;</td>
				<td><input type='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name='search' class='Button' onClick='callsearch()' >&nbsp;<input type='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' name='Close' class='Button' onClick='callclose()'>&nbsp;</td>
			</tr>
			<tr><td colspan=4>&nbsp;</td></tr>
		</table>
		<script>
			Search_STD_Family_Name_form.last_name.focus();
		</script>
    </form>    
</body> 
</html>

<%
	if(!param_value.equals(""))
	{
		%>
			<script>
				document.forms[0].search.click();
				document.forms[0].search.disabled=true;
			</script>
		<%
	}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ?	"" : inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

