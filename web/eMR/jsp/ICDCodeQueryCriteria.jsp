<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="javascript" src="../js/ICDCode.js"></script>
	</head>
	<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
      	<form name='ICDCodeQueryCriteria' id='ICDCodeQueryCriteria' >
      	<table border='0' cellpadding='5' cellspacing='0' align='center' width='100%'>
       	<tr>
		<td class='label' width='25%'><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><select name='diag_code_scheme_desc' id='diag_code_scheme_desc'><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='1'><fmt:message key="eMR.ICD10.label" bundle="${mr_labels}"/></option><option value='2'><fmt:message key="Common.ICD9CM.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td class='label' width='25%'><fmt:message key="eMR.ICDCodeType.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='25%'><select name='record_type_desc' id='record_type_desc'><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='D'><fmt:message key="eMR.Disease.label" bundle="${mr_labels}"/></option><option value='O'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>
			</select>
		</td>
      	</tr>
      	<tr>
      		<td class='label' ><fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></td>
      		<td class='fields'><input type='text' name='diag_code' id='diag_code' size='5' maxlength='5'></td>
      		<td class='label' ><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
      		<td class='fields'><input type='text' length='60' maxlength='250' name='title' id='title'></td>
      	</tr>
      	
      	<tr>
      		<td class='label' ><fmt:message key="eMR.GenderSpecific.label" bundle="${mr_labels}"/></td>
      		<td class='fields'><select name='gender_spec_ind_desc' id='gender_spec_ind_desc'><option value=''><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td class='label' ><fmt:message key="eMR.AgeSpecificIndicator.label" bundle="${mr_labels}"/></td>
		<td class='fields'><select name='age_spec_ind_desc' id='age_spec_ind_desc'>
			<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='A'><fmt:message key="Common.Adult.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eMR.Common.label" bundle="${mr_labels}"/></option>
			<option value='M'><fmt:message key="eMR.Maternity.label" bundle="${mr_labels}"/></option>
			<option value='N'><fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/></option>
			<option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="eMR.Pediatric.label" bundle="${mr_labels}"/></option>
			</select>
		</td>
		
      	</tr>
      	
      	<tr>
      		<td class='label' ><fmt:message key="eMR.SensitiveIndicator.label" bundle="${mr_labels}"/></td>
      		<td class='fields'><select name='sensitive_yn' id='sensitive_yn'><option value=''><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			<option value='Y'><fmt:message key="eMR.Sensitiveonly.label" bundle="${mr_labels}"/></option><option value='N'><fmt:message key="eMR.NonSensitiveonly.label" bundle="${mr_labels}"/></option>
			</select>
		</td>
		<td  class='label'><fmt:message key="eMR.NotifiableIndicator.label" bundle="${mr_labels}"/></td>
		<td class='fields'><select name='notifiable_yn' id='notifiable_yn'><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='Y'><fmt:message key="eMR.Notifiableonly.label" bundle="${mr_labels}"/></option><option value='N'><fmt:message key="eMR.NonNotifiableonly.label" bundle="${mr_labels}"/></option>
			</select>
		</td>
		
      	</tr>
      	
	<tr>
		<td  class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='order_by' id='order_by'><option value='diag_code'><fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></option>
			<option value='short_desc'><fmt:message key="eMR.ICDDesc.label" bundle="${mr_labels}"/></option>
			</select>
		</td>
		<td class='label'><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='code_ind' id='code_ind'>
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<option value='D'><fmt:message key="eMR.Dagger.label" bundle="${mr_labels}"/></option>
		<option value='E'><fmt:message key="eMR.ExternalCause.label" bundle="${mr_labels}"/></option>
		<option value='A'><fmt:message key="eMR.Asterisk.label" bundle="${mr_labels}"/></option>
		<option value='C'><fmt:message key="eMR.Consequence.label" bundle="${mr_labels}"/></option>
		</select>
		</td>
		
	</tr>
      	
      	
      	<tr>
			<td class='label' colspan='3'></td>
      		<td class='button' style="text-align: right;">
	      		<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='callResultFrame()' class='button'>
	      		<input type='button'  onClick='clearValues()' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'>
      		</td>
      	</tr>

      	
</table>
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

