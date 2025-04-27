<!DOCTYPE html>
<!--Created by Ashwini on 26-Aug-2019 for ML-MMOH-CRF-1348-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eMR/js/PERPL205Setup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown="CodeArrest()" onLoad="OnLoadClearResult()">

<form name='PERPL205SetupCriteriaForm' id='PERPL205SetupCriteriaForm'  action=''  method='post' target='messageFrame'>
	
<%
	request.setCharacterEncoding("UTF-8");
 
  try{
%>
	<table border='0' cellpadding='2' cellspacing='0' width='80%' align='center'>

		<tr><td colspan='3'>&nbsp;</td></tr>

		<tr> 
			<td width='10%' class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td> 
			<td width='70%' class='fields'>
				<select name="service_list" id="service_list" onChange="EnableLocation(this);ClearResult();">
					<option value=""> -------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------- </option>
					<option value="KK"><fmt:message key="eMR.KlinikKhas.label" bundle="${mr_labels}"/></option>
					<option value="PC"><fmt:message key="eMR.PAC.label" bundle="${mr_labels}"/></option>
				</select>
				<img src='../../eMP/images/mandatory.gif'>
			</td>
		</tr>
		
		<tr><td colspan='3'>&nbsp;</td></tr>

		<tr> 
			<td width='10%' class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td> 
			<td width='70%' class='fields'>
				<select name="location_list" id="location_list" onChange="ClearResult();" disabled>
					<option value=""> --------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
				</select>
				<img src='../../eMP/images/mandatory.gif'>
			</td>
		</tr>

		<tr>
			<td colspan='2' align='right'>
				<input type='button' class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" Onclick="FetchValues()">
				<input type='button' class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" Onclick="ClearResult()"> 
			</td>
		</tr>
						
	</table>
<% 
	}catch(Exception e){
		//out.println("Exception in File PERPL205SetupCriteria"+e.toString());
		e.printStackTrace();
	}finally{
	}
%>

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

