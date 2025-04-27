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
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('ETHNIC_GROUP_CODE')">
<form name="ETHNIC_GROUP_FORM" id="ETHNIC_GROUP_FORM" action="../../servlet/eMP.EthnicGroupServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>

  <tr>
  <td width="40%" >&nbsp;</td>
  	<td width="60%" colspan="2">&nbsp;</td>
  </tr>

  <tr>
      <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="ETHNIC_GROUP_CODE" id="ETHNIC_GROUP_CODE" size="10"maxlength="10" onBlur=ChangeUpperCase(this); onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img>
      </td>
    </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="LONG_DESC" id="LONG_DESC" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="SHORT_DESC" id="SHORT_DESC" size="15" maxlength="15" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>
  <!--tr>
      <td width="40%" align="right" class="label">Effective From</td>
      <td width="13%" align="left">&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10"><!--/td-->
      <!--td width="47%" align="left" class="label">&nbsp;&nbsp;To &nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"   maxlength="10"><!--/td-->
    <!--/tr-->

	 <!--tr>
	  <td width="40%" >&nbsp;</td>
	  	<td width="60%" colspan="2">&nbsp;</td>
  </tr-->

	<tr>
	<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td width="60%" colspan="2" class='fields'><input type="checkbox" name="EFF_STATUS" id="EFF_STATUS" value="E" checked></td>
    </tr>

   <tr>
    <td width="40%" >&nbsp;</td>
    	<td width="60%" colspan="2">&nbsp;</td>
  </tr>

  </table>

<input type="hidden" name="mode" id="mode" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type="hidden" name="function_name" id="function_name" value="insert">
</form>

</body>
</html>

