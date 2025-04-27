<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/ActiveInactive.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('reason_code')">
<form name="active_inactive_form" id="active_inactive_form" action="../../servlet/eMP.ActiveInactiveServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>

  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>
	<tr>
	   <td width='40%'>&nbsp;</td>
	   <td width='60%' colspan='2'>&nbsp;</td>
	</tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="reason_code" id="reason_code" size="4" maxlength="4" onBlur=ChangeUpperCase(this); onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img>
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
	<tr>
	  <td width="40%" class="label"><fmt:message key="eMP.ReasonforActiveInactive.label" bundle="${mp_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="radio" name="reason_for_active_yn" id="reason_for_active_yn" value='Y' checked onclick='assignvalue()'><span class='label'><fmt:message key="Common.active.label" bundle="${common_labels}"/></span>&nbsp;<input type="radio" name="reason_for_active_yn" id="reason_for_active_yn" onclick='assignvalue()' value='N'>&nbsp;<span class='label'><fmt:message key="Common.Inactive.label" bundle="${common_labels}"/></span>&nbsp;<img src='../images/mandatory.gif'></img></td>
	  </tr>
	  <input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"  maxlength="10">
	  <input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"   maxlength="10"><!--/td-->
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
<input type="hidden" name="eff_date_from" id="eff_date_from">
<input type="hidden" name="eff_date_to" id="eff_date_to">
<input type='hidden' name='function_name' id='function_name' value='insert'>
</form>

</body>
</html>

