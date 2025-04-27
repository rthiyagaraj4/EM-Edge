<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	java.util.Date currentdate=new java.util.Date();
	java.text.SimpleDateFormat sf=new java.text.SimpleDateFormat("dd/MM/yyyy");
	String sysdt=sf.format(currentdate);
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'> 
<form name="HealthCareSettingType_form" id="HealthCareSettingType_form" action="../../servlet/eAM.HealthCareSettingTypeServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>

<div  align="left">

  <table border="0" cellpadding="0" cellspacing="0" width='75%' align='center'>
  <tr class="label">
  	<td width="50%" class="label" >&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
  <tr>
    <td width="50%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
     <td width="50%" colspan="2" class="fields">
     <input type="text" onKeyPress="return CheckForSpecChars(event)"  name="hcare_setting_type_code" id="hcare_setting_type_code" size="2" maxlength="2" onBlur="ChangeUpperCase(this)"><img src='../../eCommon/images/mandatory.gif'></img>
     </td>
  </tr>
  <tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
  <tr>
    <td width="50%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td width="50%" colspan="2" class="fields"><input type="text" onBlur='makeValidString(this)' name="long_desc" id="long_desc" size="30" maxlength="30"><img src='../../eCommon/images/mandatory.gif'></img></td>
  </tr>
  <tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
  <tr>
	<td width="50%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
    <td width="50%" colspan="2" class="fields"><input type="text" onBlur='makeValidString(this)'  name="short_desc" id="short_desc" size="15" maxlength="15"><img src='../../eCommon/images/mandatory.gif'></img></td>
  </tr>
  <tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
	 <input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"  onblur="CheckDate(this,'<','<%=sysdt%>','chksysdt')" maxlength="10"><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  onblur="CheckDate(this,'<','<%=sysdt%>','chksysdt')" maxlength="10">
  <tr>
	<td width="50%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td width="50%" colspan="2" class="fields"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td>
  </tr>
  <tr class="label">
    <td width="50%" class="label">&nbsp;</td>
  	<td width="50%" colspan="2" class="label">&nbsp;</td>
  </tr>
</table>
</div>
<input type="hidden" name="function_name" id="function_name" value="insert">
</form>
</body>
</html>

