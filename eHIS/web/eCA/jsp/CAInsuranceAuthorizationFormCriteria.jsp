<!DOCTYPE html>
<%
/*
 -------------------------------------------------------------------------------------------------------------------------------------
 Date       		Edit History    Name        	Description
 -------------------------------------------------------------------------------------------------------------------------------------
 12/11/2018  IN059704        PRATHYUSHA   12/11/2018          Ramesh G      AAKH-CRF-0079.2	
 26/11/2018  IN069192        PRATHYUSHA   26/11/2018          Ramesh G      AAKH-CRF-0079.2				 
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
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String patient_id = request.getParameter("patient_id") == null ? ""
			: request.getParameter("patient_id");
	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCA/js/CAInsuranceAuthorizationForm.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
 	
 %>
		<form name="formClaimFormsCriteria" id="formClaimFormsCriteria">
		<table cellpadding="0" cellspacing="0" width="100%" height="100%" align="center"
			border="0">
                   	<tr>
						<td  class="label" ><fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/>
						</td>
					    <td class="label"><input type="text" name="Patient_Id" id="Patient_Id" maxlength='20' size='20'   value='' onKeyPress="changeToUpper()" onBlur="populateEncounter(document.formClaimFormsCriteria.Patient_Id.value)" >
					       <INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.formClaimFormsCriteria.Patient_Id)" ><img src='../../eCommon/images/mandatory.gif'></img>
						</td>
					
						<td class="label" >
							<label id='encounter_lable' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></label>
						</td>
						<td  class="label">
							<select name="encounterId" id="encounterId" >
							<option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
							</select>
							<input type="hidden" name="CurrentEncounter" id="CurrentEncounter" value="">
						</td>
						 <!--SEARCH CHANGED TO  Search FOR [IN069192]-->	
						<TD class="label"><input type="button" name="Search" id="Search" VALUE='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="getResult()" />
						</TD>
					</tr>
		</table>
		
	</form>
	</BODY>
</html>

