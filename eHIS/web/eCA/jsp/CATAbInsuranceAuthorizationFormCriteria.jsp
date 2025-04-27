<!DOCTYPE html>
<%
/*
 -------------------------------------------------------------------------------------------------------------------------------------
 Date       		Edit History      		Name        		Rev.Date		Rev.Name		Description
 ------------------------------------------------------------------------------------------------------------------------------------------------------
 25/01/2019		IN057997			Kamalakannan G	  	25/01/2019		Ramesh G.		AAKH-CRF-0079
 -------------------------------------------------------------------------------------------------------------------------------------
 */
 %>
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.InsuranceAuthorizationForm.label" bundle="${ca_labels}"/></title>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCA/js/CATabInsuranceAuthorizationForm.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="formClaimFormsCriteria" id="formClaimFormsCriteria">
			<table cellpadding="0" cellspacing="0" width="100%" height="100%" align="center"
				border="0">
	                   	<tr>
							<td  class="label" >
								<fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/>
							</td>
						    <td class="label">
						    	<input type="text" name="Patient_Id" id="Patient_Id" maxlength='20' size='20'   value='' style="text-transform: uppercase"  onBlur="populateEncounter(document.formClaimFormsCriteria.Patient_Id.value)" >
						    	<img src="../../eCommon/images/mandatory.gif">
							</td>
						
							<td class="label" >
								<label id='encounter_lable' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></label>
							</td>
							<td  class="label">
								<select style="width:150px" name="encounterId" id="encounterId">
								<option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
								</select>
								<input type="hidden" name="CurrentEncounter" id="CurrentEncounter" value="">
							</td>
							<TD class="label">
								<input type="button" name="Search" id="Search" VALUE='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="getResultForTab()" />
							</TD>
						</tr>
			</table>
		</form>
	</BODY>
</html>

