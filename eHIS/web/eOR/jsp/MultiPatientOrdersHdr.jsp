<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head><title><fmt:message key="eOR.MultiPatientOrdersHdr.label" bundle="${or_labels}"/></title>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 <script language="JavaScript" src="../../eOR/js/MultiPatientOrders.js"></script>
 <script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>


<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String relationship_id = request.getParameter( "relationship_id" ) ;
	String locn_type = request.getParameter("locn_type")==null?"": request.getParameter("locn_type");
	String locn_code = request.getParameter("locn_code")==null?"": request.getParameter("locn_code");
	String location_desc ="";
	String patientId = request.getParameter("patientId")==null?"": request.getParameter("patientId");
	String speciality_code = request.getParameter("speciality_code")==null?"": request.getParameter("speciality_code");
	String speciality = request.getParameter("speciality")==null?"": request.getParameter("speciality");
	String function_from = request.getParameter("function_from")==null?"": request.getParameter("function_from");
	String include_checkout_patients = request.getParameter("include_checkout_patients")==null?"": request.getParameter("include_checkout_patients");
	String bean_id = "Or_MultiPatientOrders" ;
	String bean_name = "eOR.MultiPatientOrdersBean";
	String  sql_or_order_entry_speciality			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALITY");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
		
	//String disabled = "" ;
    //int patient_id_length = 0;

	/* Initialize Function specific start */
	//MultiPatientOrdersBean bean = (MultiPatientOrdersBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	MultiPatientOrdersBean bean = (MultiPatientOrdersBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;

	bean.setQryString(request.getQueryString());
	String locn_display = "";
	String patient_class = "";
	String dispStyle = "";
	String includeyn = "";

	if(locn_type.equals(""))
	{
		locn_display = "disabled";
	}
	if(locn_type!=null && locn_type.equalsIgnoreCase("C"))
	   patient_class	= "OP";
	else if(locn_type!=null && locn_type.equalsIgnoreCase("D"))
	   patient_class	= "DC";
	else if(locn_type!=null && locn_type.equalsIgnoreCase("E"))
	   patient_class	= "EM";
	else if(locn_type!=null && locn_type.equalsIgnoreCase("N"))
	   patient_class	= "IP";
		
	if(!locn_code.equals(""))
	{
		location_desc=bean.checkForNull((String)bean.getLocationDesc(locn_code,locn_type,practitioner_id,patient_class,facility_id),"");
	}
	if(!speciality_code.equals(""))
	{
		speciality=bean.checkForNull((String)bean.getSpecialityDesc(speciality_code),"");
	}
	%>

<form name="formMultiPatientOrdersHdr" id="formMultiPatientOrdersHdr" target='' action=''>
<table cellpadding=3 cellspacing=0 border='0' width='100%' align=center >

<tr>
	<td class='label' width="20%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields' width="40%"><SELECT name="location_type" id="location_type" onChange="ClearLocation();">
		<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value="C" <%
			if (locn_type.equals("C")){out.println("selected");}%>> <fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		<option value="D" <%
			if (locn_type.equals("D")){out.println("selected");}%>> <fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
		<option value="E" <%
			if (locn_type.equals("E")){out.println("selected");}%>> <fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
		<option value="N" <%
			if (locn_type.equals("N")){out.println("selected");}%>> <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		<option value="P" <%
			if (locn_type.equals("P")){out.println("selected");}%>> <fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option></SELECT>
		<input type='text' name='locn_code' id='locn_code' value="<%=location_desc%>" onBlur='ChangeLocation(locn_code,locn)'  size="10" maxlength='' <%=locn_display%>><input type=button id='location_lookup' name=search value='?'  class=button onClick="populateLocations(locn_code,locn)" <%=locn_display%>><input type="hidden" name="locn" id="locn" value="<%=locn_code%>"><span id='mandat' class='fields'><img src='../../eCommon/images/mandatory.gif'></td>
		<td  class='label' id='id_pat'  width="20%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
	<td class='fields' width="20%"><input type='text'  name='patientId' id='patientId' value='<%=patientId%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength="<%=bean.getPatientIdLength()%>"><input class='button' type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
	</tr>
	<tr>
	<td class="label" width="20%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class="fields" ><input type="text" name="speciality" id="speciality" maxlength='30' size='25' value="<%=speciality%>" onBlur='callSpecialityDesc(this)'><input type="button" class="button" name="sp_search" id="sp_search" value="?" onClick='callSpeciality(speciality)'><input type="hidden" name="speciality_code" id="speciality_code" value='<%=speciality_code%>'>
	<span id='mandat1' class='fields'><%if(locn_code.equals("")){%> <img src='../../eCommon/images/mandatory.gif'><%}%></td>
	<%
	if((locn_type.equalsIgnoreCase("C"))||(locn_type.equalsIgnoreCase("E"))||((locn_type.equalsIgnoreCase("P"))))
	{
		dispStyle = "visibility:visible";
	}
	else
	{
		dispStyle = "visibility:hidden";
	}
	if(include_checkout_patients.equalsIgnoreCase("Y"))
	{
		includeyn = "checked";
	}
	else
	{
		includeyn = "";
	}
	%>

	<td class = "label" id ="includeCheckOutPatientsLabel" style=<%=dispStyle%>><fmt:message key="eOR.IncludeCheckedOutPatients.label" bundle="${or_labels}"/>
	</td>
	<td class = "fields" id ="includeCheckOutPatientsChk"  style=<%=dispStyle%>><input type='checkbox' name='include_checkout_patients' id='include_checkout_patients' value='<%=include_checkout_patients%>' <%=includeyn%> onclick='ChkCheckOutPatients(this)'>
	</td>
	</div>
	<tr>
	<td  class='button' colspan='4' align="right"><INPUT class='button'  TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='SearchValues()'><INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onClick='resetValues()'></td>
</tr>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="relationship_id" id="relationship_id" value="<%= relationship_id%>">
<input type="hidden" name="sql_or_order_entry_speciality" id="sql_or_order_entry_speciality" value="<%=sql_or_order_entry_speciality%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="location_sql" id="location_sql" value="<%= OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION_LOOKUP")%>">
<input type="hidden" name="procedure_sql" id="procedure_sql" value="<%= OrRepositoryExt.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT_PROCEDURE_LOOKUP")%>">


</form>
</body>
</html>

<%
	// set it back persistence
if(function_from.equalsIgnoreCase("PASSED_ORDERS")||function_from.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
{	
%>
<script>
	SearchValues();
</script>
<%
}
	putObjectInBean(bean_id,bean,request);
%>

