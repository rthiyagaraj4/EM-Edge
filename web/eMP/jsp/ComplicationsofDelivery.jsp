<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../js/ComplicationsofDelivery.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<!--Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
<%

	Connection con = null;
	Boolean isModifyLongShortDescAppl = false;
	
	try {

		con = ConnectionManager.getConnection(request);

		isModifyLongShortDescAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	
%>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('compln_dely_code')">
	<form name="res_town_form" id="res_town_form" action="../../servlet/eMP.ComplicationsofDeliveryServlet" method="post" target="messageFrame">
	<BR><BR><BR><BR><BR><BR><BR><BR>
	<div align="left">
	  <table border="0" cellpadding="3" cellspacing="0" width="60%" align='center'>
  <tr class='label'>
	<td class='label' colspan='2'>&nbsp;</td>
	
</tr>

    <tr>
      <td  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  class="fields" ><input type="text" name="compln_dely_code" id="compln_dely_code" size="10" maxlength="10"   onBlur='ChangeUpperCase(this);' onKeyPress="return CheckForSpecChars(event)" ><img src='../images/mandatory.gif'></img></td>
    </tr>

    <tr>
      <td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	  <!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
      <td class="fields" ><input type="text" name="long_desc" id="long_desc" <%if(isModifyLongShortDescAppl){%>size='75' maxlength='75'<%}else{%>size="30" maxlength="30"<%}%> onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>

    <tr>
      <td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	  <!--Modified by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109-->
      <td class="fields"><input type="text" name="short_desc" id="short_desc" <%if(isModifyLongShortDescAppl){%>size='35' maxlength='30'<%}else{%>size="15" maxlength="15"<%}%> onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>
	<tr>
      <td class="label"><fmt:message key="eMP.TypeofComplication.label" bundle="${mp_labels}"/></td>
      <td class="fields"><select name='type_of_complication' id='type_of_complication' onchange='checkStage(this);'>
			 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
			 <option value='M' ><fmt:message key="Common.Mother.label" bundle="${common_labels}"/>
			 <option value='F' ><fmt:message key="eMP.Foetus.label" bundle="${mp_labels}"/>
			 </select>
	<img src='../images/mandatory.gif'></img></td>
	</tr>

     <!-- <tr>
      <td width="40%" class="label">Effective From </td>
      <td width="13%" >&nbsp;&nbsp;&nbsp;<input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10">
      <td width="47%" class="label">&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  maxlength="10"></td>
	</tr> 

	  <tr>
		<td width='40%'>&nbsp;</td>
		<td width='60%' colspan='2'></td>
	</tr> -->
	<tr>
		<td class="label"><fmt:message key="eMP.Complicationsin1stStage.label" bundle="${mp_labels}"/></td>
		<td  class="fields" ><input type="checkbox" name="stage1" id="stage1" value="Y" ></td>	
	</tr>
	<tr>
		<td class="label"><fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/></td>
		<td  class="fields" ><input type="checkbox" name="stage2" id="stage2" value="Y" ></td>	
	</tr>
     <tr>
		<td class="label"><fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/></td>
		<td  class="fields" ><input type="checkbox" name="stage3" id="stage3" value="Y" ></td>	
	</tr>
	<tr>
	<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    	<td  class="fields" ><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td></tr>

      <tr class='label'>
	<td class='label' colspan='2'>&nbsp;</td>
	
</tr>
  </table>
</div>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="function_name" id="function_name" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
</form>
</body>

<%
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally
    {
  		ConnectionManager.returnConnection(con,request);
    }
%>

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

