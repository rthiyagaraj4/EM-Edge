<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
%>
<%
/*
-----------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        		Rev.Date		Rev.Name 		Description
-----------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------
*/
%>
<!-- PhQuotaLimitApprovalCriteria.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="ePH.QuotaLimitApprovalOrders"/>
<%-- Mandatory declarations end --%>

<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%request.setCharacterEncoding("UTF-8");%>

	<%
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String imgUrl = "";
		if(sStyle.equals("IeStyle.css")){
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		}
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		String facility_id = (String)session.getValue("facility_id");
		String toDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		String frDate = com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,7,"d");
		int patient_id_length = 20;
		//patient_id_length = bean.getPatientIdLength(properties);
		
		String  temp_toDate = toDate;
		String temp_frDate = frDate;
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
		<script language="JavaScript" src="../js/PhQuotaLimitApproval.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
	<%

	%>
	<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='quotaLimitApprovalCriteriaForm' id='quotaLimitApprovalCriteriaForm' target='QuotaLimitApprovalBottom' action='PhQuotaLimitApprovalBottom.jsp'>
			<table cellpadding=3 cellspacing=0 border=0 width="100%"  align=center>
				<tr><td colspan='6'>&nbsp;</td></tr>
				<tr>
					<td class='label' width='10%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' >
						<SELECT name="location_type" id="location_type" onChange='clearLocnDtls()'>
							<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/>
							<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
							<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
							<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
							<option value="W"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
							<option value="R"><fmt:message key="Common.referral.label" bundle="${common_labels}"/>
						</SELECT>
						<Input name='locn_desc' id='locn_desc' type='text' value='<fmt:message key="Common.all.label" bundle="${common_labels}"/>' size="15" onBlur="populateLoaction(locn_desc);">
						<input class='button' type=button name=search value='?'  class=button onClick="populateLoaction(locn_desc)" size='15'>
						<input type='hidden' name='locn' id='locn' value=''>
					</td>
					<td class='label' width='10%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
						<input type="text" name="period_from" id="period_from" value="<%=frDate%>"  size="10" maxlength="10" onBlur="chckDate(this);" onKeyPress='return AllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_from');" style='cursor:pointer'></img>
						<font size="4">-</font>
						<input type=text name='period_to' id='period_to' value="<%=toDate%>" size="10" maxlength="10" onBlur="checkDateRange(this,'quotaLimitApprovalCriteriaForm');" onKeyPress='return AllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_to');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center></img>
					</td>
					<td class='label' width='15%'><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
					<td class='fields' width='20%'>
						<input type='text'  name='specialty' id='specialty' value=''  onKeyPress='' onBlur='getSpecialty1(this)' size='20' maxlength='20'>
						<input type='button' name='search' id='search' value='?'  class='button' tabIndex="4" onClick="getSpecialty()">
						<input type="hidden" name="specialty_code" id="specialty_code" value=''>
					</td>					
				</tr>
				<tr>
					<td  class='label' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
						<input type='text' name='patientId' id='patientId' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength="<%=patient_id_length%>" >
						<input class='button' type=button name=search value='?'  class=button tabIndex="3" onClick="callPatientSearch()">
					</td>
					<td colspan=3 width='45%'>&nbsp;</td>	
					<td  class='label' width='20%'>
						<input type='button' class='button' name='search_btn' id='search_btn' id = 'searchID' onclick="populateValues();" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'></input> 
						<input type='button' class='button' name='clear_btn' id='clear_btn' onclick="clearCriteria();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input>
					</td>
				</tr>	
				<tr><td colspan='6'>&nbsp;</td></tr>
			</table>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'/>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'/>
			<input type='hidden' name='temp_toDate' id='temp_toDate' value='<%=temp_toDate%>'/>
			<input type='hidden' name='temp_frDate' id='temp_frDate' value='<%=temp_frDate%>'/>
		</form>
	</body>
	<script>
	populateValues();
	</script>
</html>	

