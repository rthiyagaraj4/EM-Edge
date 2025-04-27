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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('postal_code')">
<form name="postal_form" id="postal_form" action="../../servlet/eMP.PostalServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div align="left">
  <table border="0" cellpadding="0" cellspacing="0" width="75%" align='center'>

    <tr>
    	<td width='40%'>&nbsp;</td>
    	<td width='60%' colspan='2'></td>
    </tr>

    <tr>
      <td width="40%" align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2">
      &nbsp;&nbsp; <input type="text" name="postal_code" id="postal_code" size="8"maxlength="8" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)">&nbsp;<img src='../images/mandatory.gif'></img>

      </td>
    </tr>


	    <tr>
	    	<td width='40%'>&nbsp;</td>
	    	<td width='60%' colspan='2'></td>
	    </tr>

    <tr>
      <td width="40%" align="right" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2">&nbsp;&nbsp; <input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'>&nbsp;<img src='../images/mandatory.gif'></img></td>
    </tr>

	    <tr>
	    	<td width='40%'>&nbsp;</td>
	    	<td width='60%' colspan='2'></td>
	    </tr>

    <tr>
      <td width="40%" align="right" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2">&nbsp;&nbsp; <input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)'>&nbsp;<img src='../images/mandatory.gif'></img></td>
    </tr>

    <tr>
    	<td width='40%'>&nbsp;</td>
    	<td width='60%' colspan='2'></td>
    </tr>

    <!--tr>
      <td width="40%" align="right" class="label" >Effective From</td>
      <td width="13%" align='left' >&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10"><!--/td-->
      <!--td width="47%" align="left" class="label">&nbsp;&nbsp;To &nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"   maxlength="10"><!--/td-->

    <!--/tr-->

    <!--tr>
    	<td width='40%'>&nbsp;</td>
    	<td width='60%' colspan='2'></td>
    </tr-->

	<tr>
	<td width='40%' align="right" class="label">
      <fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
    </td>
    <td align="left" class="label" width="60%" colspan="2">&nbsp;&nbsp;
      <input type="checkbox" name="eff_status" id="eff_status" value="E" checked>&nbsp;</td></tr>

      <tr>
      	<td width='40%'>&nbsp;</td>
      	<td width='60%' colspan='2'></td>
      </tr>

  </table>
</div>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value='insert'>
</form>

</body>
</html>

