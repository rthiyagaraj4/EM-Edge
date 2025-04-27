<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
18/08/2022	29035				Ramesh G											ML-MMOH-CRF-1763
--------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facilityId=  (String)session.getValue("facility_id");	
%>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
		<script language="javascript"src="../../eCommon/js/ValidateControl.js" ></script>
		<script language="javascript"src="../../eCommon/js/common.js" ></script>
		<script language='javascript' src='../js/MultiLocForPractitioner.js'></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
		<form name="MutiLocForPractitionerCriteriaForm" id="MutiLocForPractitionerCriteriaForm">
			<table border=0 colspan=2 cellspacing=0 cellpadding='3' width='100%' align='center'>
				<tr><td class=label colspan='4'>&nbsp;</td></tr>
				<tr>
					<td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
					<td class='fields' ><input type="hidden" name="splCode" id="splCode" size="20" maxlength="20" value="">
						<input type="text" name="splName" id="splName"  size='25' maxlength='20' onBlur='getSplCode(this);' 
							OnChange='resetValues()'>
							<input type="button" value="?" class="button" name='splSearch' id='splSearch' onClick='resetValues();populateSpl()'>
					</td>

					<td class=label ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td class='fields' >
					<input type="hidden" name="practitionerId" id="practitionerId" size="20" maxlength="20" value="">
					<input type="text" name="practitionerName" id="practitionerName" value="" size='25' maxlength='20' onBlur='getPractCode(this)' OnChange='resetValues()'> 
					<input type="button" value="?" class="button" name='practSearch' id='practSearch' onClick='resetValues();getPractCode(this)'>
					<img src='../../eCommon/images/mandatory.gif'></td>
				</tr>

				<tr>
					<td class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields' colspan='3'>
						<select name='locnType' id='locnType' onchange='resetSearchResult();' >
							<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>					
							<option value='C'><fmt:message key="eCA.Clinics.label" bundle="${ca_labels}"/></option>
							<option value='W'><fmt:message key="eCA.NursingUnits.label" bundle="${ca_labels}"/></option>
						</select>
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
					<td>
						<select name="searchBy" id="searchBy">
							<option value="locationID" ><fmt:message key="eCA.LocationID.label" bundle="${ca_labels}"/>
							<option value="locationDesc" selected><fmt:message key="Common.LocationDesc.label" bundle="${common_labels}"/>
						</select>
						&nbsp;
						<input type="text" name="searchText" id="searchText" value="" />
					</td>
					<td colspan='2'>
						<input type="button" name ="searchResult" id="searchResult" value="Search" onClick='return populateData();'/>
					</td>	
				</tr>
			</table>			
			<input type='hidden' name='flag' id='flag' value='true'>
			<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>'>
		</form>
	</body>
</html>

