<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String) session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 
 <html>
<head>
<link rel="stylesheet" type="text/css" href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onLoad="Focusing('educ_level_code')";>
<form name="educationlevel_form" id="educationlevel_form" action="../../servlet/eMP.EducationLevelServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>

  <tr>
	<td width='40%'>&nbsp;</td>
	<td width='60%' colspan='2'>&nbsp;</td>
   </tr>

      <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="educ_level_code" id="educ_level_code" size="2"maxlength="2" onBlur='ChangeUpperCase(this)'; onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img>
      </td>
    </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>
   <tr>
      <td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>

   <!--tr>
      <td width="40%" class="label">Effective From </td>
      <td width="13%" >&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10"><!--/td-->
      <!--td width="47%" class="label">&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  maxlength="10"><!--/td-->
    <!--/tr-->

	 <!--tr>
		<td width='40%'>&nbsp;</td>
		<td width='60%' colspan='2'>&nbsp;</td>
   </tr-->

	<tr>
	<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td width="60%" colspan="2" class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td>
    </tr>

   <tr>
  	<td width='40%'>&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
   </tr>

  </table>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value='insert'>
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

