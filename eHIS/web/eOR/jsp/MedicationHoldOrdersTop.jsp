<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------------------------------------
07/02/2013	  IN029949	    Chowminya G    Created 
15/02/2013	  IN037927	  	Chowminya G    Pharmacy Orders - On Hold ->Query Criteria displayed wrongly 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<!-- MedicationHoldOrdersTop.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.ExistingOrder"/>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../js/MedicationHoldOrder.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

 <body   onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	Properties properties			= (Properties) session.getValue( "jdbc" );
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String location_sql = "SELECT CODE,DESCRIPTION FROM (Select locn_code code, DECODE(PATIENT_CLASS,'DC',IP_GET_DESC.IP_NURSING_UNIT(facility_id,locn_code,?,'2'),'IP',IP_GET_DESC.IP_NURSING_UNIT(facility_id,locn_code,?,'2'),'EM',OP_GET_DESC.OP_CLINIC(facility_id,locn_code,?,'2'),'OP',OP_GET_DESC.OP_CLINIC(facility_id,locn_code,?,'2'),'R',AM_GET_DESC.AM_REFERRAL(locn_code,?,'1') )  description from Or_Pract_For_Locn_Vw where practitioner_id= ?  ##FILTER1## and nvl(facility_id, ?)  like ? ) WHERE CODE like UPPER(?) and UPPER(DESCRIPTION) like UPPER(?) order by DESCRIPTION"; //IN037927

	String curr_week_date  = "";
	String last_week_date  = "";

	last_week_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	curr_week_date	= com.ehis.util.DateUtils.minusDate(last_week_date,"DMY",localeName,7,"d");

	if(last_week_date.equals("null") || last_week_date.equals(" ")) last_week_date="";
	if(curr_week_date.equals("null") || curr_week_date.equals(" ")) curr_week_date="";

	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength(properties);

	String  temp_curr_week_date = curr_week_date;
	String temp_last_week_date = last_week_date;


%>
<form name='hold_order' id='hold_order' target='MediHoldOrderBottom' action='MedicationHoldOrdersBottom.jsp'>
<table cellpadding=3 cellspacing=0 border=0 width="100%"  align=center>
	<tr>
		<td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class=fields><SELECT name="location_type" id="location_type" onChange=''>
			<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
		<!--<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/> --><!-- IN037927 PH orders doesnt have E & D-->
			<option value="W"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
			<option value="R"><fmt:message key="Common.referral.label" bundle="${common_labels}"/>
		</SELECT><Input name='locn_desc' id='locn_desc' type='text' value='<fmt:message key="Common.all.label" bundle="${common_labels}"/>' size="15" onBlur="populateLoaction(locn_desc);" ><input class='button' type=button name=search value='?'  class=button onClick="populateLoaction(locn_desc)" size='15'><input type='hidden' name='locn' id='locn' value=''>
		</td>
		<td class=label><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td class='fields' wrap><input type="text" name="period_from" id="period_from" value="<%=curr_week_date%>"  size="10" maxlength="10" onBlur="chckDate(this);" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_from');" style='cursor:pointer'></img><font size="4">-</font><input type=text name='period_to' id='period_to' value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'hold_order');" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_to');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center></img>
		</td>
		</tr>		
		<tr>
		<td  class='label' id='id_locn'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type='text' name='patientId' id='patientId' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength="<%=patient_id_length%>" ><input class='button' type=button name=search value='?'  class=button tabIndex="3" onClick="callPatientSearch()">
		</td>
		</tr>
		<tr>
		<td class="label" colspan="3"></td>
		<td class='button'>
		<INPUT TYPE="button" name='search_btn' id='search_btn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='populateValues()'><INPUT TYPE="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='resetValues()'>
		</td>
		
		
		</tr>
			
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="location_sql" id="location_sql" value="<%= location_sql%>"> <!-- IN037927 -->
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%= practitioner_id %>">
<input type="hidden" name="facility_id" id="facility_id" value="<%= facility_id %>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="help_function_id" id="help_function_id" value="MEDICATION_HOLD_ORDERS">
<input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=temp_curr_week_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=temp_last_week_date %>">
</form>

</body>
<Script>
//document.hold_order.search_btn.disabled = true;
document.hold_order.submit();</script>
</html>

