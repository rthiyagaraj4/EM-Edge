<!DOCTYPE html>
<!--Created by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<script src='../js/AdmissionForm.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%	
   String facilityId = (String)session.getValue("facility_id");
   String locale     = (String)session.getAttribute("LOCALE");
   request.setCharacterEncoding("UTF-8"); 
   String admission_form_code="";
   String longdesc="";
   String shortdesc="";
   String specdesc="";
   String bydefault="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String specialityAttribute="";
   String bydefaultAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   boolean status = false;

   Connection con=null;
%>
<%
try
{
	con=ConnectionManager.getConnection(request);
	
	admission_form_code=request.getParameter("admission_form_code");
	if(admission_form_code==null)
	{
		admission_form_code="";
		longdesc="";
		shortdesc="";
		specdesc="";
		bydefault="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		specialityAttribute="";
		bydefaultAttribute="";
		checkBoxAttribute="CHECKED";
		status=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else
	{
		JSONObject json	= eIP.IPCommonBean.getAdmissionForm(con, admission_form_code, locale);
		admission_form_code = (String) json.get("admission_form_code");
		longdesc = (String) json.get("long_desc");
		shortdesc = (String) json.get("short_desc");
		specdesc = (String) json.get("specialty");
		specialityAttribute = (String) json.get("speciality_code");

		bydefault = (String) json.get("by_default");

			if(bydefault.equals("Y"))
				bydefaultAttribute="checked";
			else if(bydefault.equals("N"))
				bydefaultAttribute="";

		effstatus  = (String) json.get("eff_status");

			if(effstatus.equals("D")){
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
			}else{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
			}
		
		codeTextAttribute="READONLY";
		status=false;
		eventFunctionForCase="";
	}

%>

<form name='AdmissionForm' id='AdmissionForm' method='post' action='../../servlet/eIP.AdmissionFormServlet' target='messageFrame'>
	<br><br><br><br><br><br><br><br><br><br>
		<table cellspacing=0 cellpadding=0 align='center' width='100%'  border='0'>
		
		<tr>
		<td height='100%' width='50%' align='middle' class='white'>
			
			<table cellspacing=0 cellpadding=0 align='center' width='50%' border='0'>

			<tr><td colspan='2'>&nbsp</td></tr>

			<tr>
			<td class='label' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class='fields'> <input type='text' name='admission_form_code' id='admission_form_code' size='2' maxlength='2' value="<%=admission_form_code%>" onpaste="return false;" onBlur='ChangeUpperCase(this)' onKeyPress="return CheckForSpecCharsAdmsnForm(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			</tr>

			<tr><td colspan='2'>&nbsp</td></tr>

			<tr>
			<td class='label' align='right' nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'> <input type='text' name='long_desc' id='long_desc' size=30 maxlength=30 value="<%=longdesc%>" <%=otherTextAttribute%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			</tr>

			<tr><td colspan='2'>&nbsp</td></tr>

			<tr>
			<td class='label' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'> <input type='text' name='short_desc' id='short_desc' size=15 maxlength=15 value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			</tr>
							
			<tr><td colspan='2'>&nbsp</td></tr>

			<tr>
			<td class='label' align='right'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name ="speciality_desc" maxlength="15" size="15" value="<%=specdesc%>" <%=otherTextAttribute%> onBlur="getValues(speciality_button,this,speciality_code)"><input type='button' class='button'  name='speciality_button' id='speciality_button' value='?' onclick="getValues(this,speciality_desc,speciality_code)"><input type='hidden' name='speciality_code' id='speciality_code' value="<%=specialityAttribute%>"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			</tr>

			<tr><td colspan='2'>&nbsp</td></tr>

			<tr>
			<td class='label' align='right'><fmt:message key="Common.by.label" bundle="${common_labels}"/> <fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
			<td class='fields'> <input type='checkbox' name='by_default' id='by_default' value="<%=bydefault%>" <%=bydefaultAttribute%> onClick="changeByDefault()"></td>
			</tr>

			<tr><td colspan='2'>&nbsp</td></tr>

			<tr>
			<td class='label' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields'> <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="changeEffStatus()"></td>
			</tr>

			<tr><td colspan='2'>&nbsp</td></tr>

			</table>
		</td>
		</tr>
		</table>
		
		<%  if(status){%>

      	<input type='hidden' name='function1' id='function1' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function1' id='function1' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
		
		<input type='hidden' name='facilityID' id='facilityID' value='<%=facilityId%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

</form>
</body>
<%

}catch(Exception e) {out.println("Error"+e);}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}	
%>	
</html>
	<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

