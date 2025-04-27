<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,eMP.*" contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

Connection conn =null;
try
{
conn=ConnectionManager.getConnection(request);
Boolean isVIRTUAL_CONSULTATION  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 19-04-2023 -->
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="JavaScript" src="../../eCommon/js/date-picker.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('country_code')">
<form name="country_form" id="country_form" action="../../servlet/eMP.CountryServlet" method="post" target="messageFrame">

<BR><BR><BR><BR><BR><BR><BR><BR>
<div align="left">
  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>

  <tr>
  	<td width="40%">&nbsp;</td>
  	<td width="60%" colspan="2">&nbsp;</td>
  </tr>

    <tr>
      <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="country_code" id="country_code" size="4"maxlength="4" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img>

      </td>
    </tr>

    <tr>
      <td width="40%" class="label"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="long_name" id="long_name" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>
  <tr>
      <td width="40%" class="label"><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="short_name" id="short_name" size="15" maxlength="15" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>
    <tr>
	      <td width="40%" class="label"><fmt:message key="Common.Citizenship.label" bundle="${common_labels}"/></td>
	      <td width="60%" colspan="2" class='fields'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>
    <!--tr>
      <td width="40%" align="right" class="label" >Effective From</td>
      <td width="13%" align="left">&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10"> <!--/td-->
      <!--td width="47%" align="left" class="label">&nbsp;&nbsp;To &nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  maxlength="10"><!--/td-->

    <!--/tr-->

 <!--tr>
  	<td width="40%">&nbsp;</td>
  	<td width="60%" colspan="2">&nbsp;</td>
  </tr-->

	<tr>
		<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    	<td width="60%" colspan="2" class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td>
    </tr>
   
   <!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U3) on 19-04-2023 Started -->
    <%
    if(isVIRTUAL_CONSULTATION){ %>
    <tr>
    <input type='hidden' id='isVIRTUAL_CONSULTATION1' value="<%=isVIRTUAL_CONSULTATION %>">
	<td width="40%" class="label"><fmt:message key="eMP.telephonecode.label" bundle="${common_labels}"/></td>
	<td width="60%" colspan="2" class='fields'><input name="telephone_country_code" id="telephone_country_code" id="telephone_country_code" type="number" onKeyPress='return CheckForNumbers(event)' onpaste='return checkspecialandalphanumeric(this);' size="6" maxlength="6" ><img src='../images/mandatory.gif'></img></td>
	</tr>
	<% }else
		{%>
		<input type='hidden'  id='isVIRTUAL_CONSULTATION1' value="<%=isVIRTUAL_CONSULTATION %>">
		<input type="hidden" name="telephone_country_code" id="telephone_country_code" size="10" maxlength="6" value=" ">
		
		<%}%>
<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U3) on 19-04-2023 Ended -->

   <tr>
    	<td width="40%">&nbsp;</td>
    	<td width="60%" colspan="2">&nbsp;</td>
  </tr>

  </table>
</div>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value='insert'>
</form>

</body>


<Script>


function checkspecialandalphanumeric(textObj)
{
	
	var ValidChars = /^\d+\.?\d*$/;
	var pasteData = window.clipboardData.getData("Text"); 
	pasteData = trimString(pasteData);
	if(ValidChars.test(pasteData))
	{
		
		textObj.value = pasteData;
	}
	else 
		return false; 
}

</Script>
</html>
<%
}catch(Exception e)
{
e.printStackTrace();
}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>

