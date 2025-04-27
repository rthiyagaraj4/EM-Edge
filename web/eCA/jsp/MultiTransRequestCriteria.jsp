<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src='../../eCA/js/MultiTransRequest.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");

	String facilityid=((String) session.getValue("facility_id")).trim();
	String userId =((String) session.getValue("ca_practitioner_id")).trim();
	String practitioner_name =((String) session.getValue("practitioner_name")).trim();
	
	String CurrentDate ="";
	String CurrentTime ="";
	String speciality_code = "";
	String primary_speciality = "";

	CurrentDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	CurrentTime	= com.ehis.util.DateUtils.getCurrentDate("HM",locale);

	String speciality_qry= "select PRIMARY_SPECIALITY_CODE, am_get_desc.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,?,2) PRIMARY_SPECIALITY from am_practitioner where PRACTITIONER_ID= ? ";

	try
	{
		con =  ConnectionManager.getConnection(request);
		stmt = con.prepareStatement(speciality_qry);
		stmt.setString(1,locale);
		stmt.setString(2,userId);
		rs = stmt.executeQuery();
		
		while(rs.next())
		{
						
			speciality_code = rs.getString("PRIMARY_SPECIALITY_CODE")==null?"":rs.getString("PRIMARY_SPECIALITY_CODE");
			primary_speciality = rs.getString("PRIMARY_SPECIALITY")==null?"":rs.getString("PRIMARY_SPECIALITY");
		}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();


	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	

%>

<body  class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='MultiTransRequestCriteriaForm' id='MultiTransRequestCriteriaForm'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<tr>
			<td class='fields' width='25%'>
				<input type="radio" name="pract_rad"  id='pract_self' class="label" value="P" checked onclick='practRadClick(this);' >&nbsp;<fmt:message key="Common.self.label" bundle="${common_labels}"/><input type="radio" name="pract_rad" id="pract_behalf"  class="label" value="O" onclick='practRadClick(this);'>&nbsp;<fmt:message key="eCA.OnBehalfOf.label" bundle="${ca_labels}"/>
			</td>

			<td class='fields' width='25%'>
				<input type='text' name='practitioner' id='practitioner' size=30 maxlength='30' value='<%=practitioner_name%>' readOnly onBlur ="getPract1(this);" ><input type='button' class='button' value='?'   name='search_pract' id='search_pract' onClick="getPract(this);" disabled><img src='../../eCommon/images/mandatory.gif'></img>
			</td>

			<td class='label'>
				<fmt:message key="Common.view.label" bundle="${common_labels}"/>
			</td>
			<td class='label' width='25%' >
				<select name='viewlist' id='viewlist' onChange='locnMandatory(this)'>
					<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='P'><fmt:message key="eCA.MyPatients.label" bundle="${ca_labels}"/></option>
					<option value='R'><fmt:message key="eCA.MyRelatedPatients.label" bundle="${ca_labels}"/></option>
				</select>
			</td>

		</tr>
	<!--	<tr>
			<td>&nbsp;</td>
		</tr> -->

		<tr>
			<td class='label' width ='25%'>
				<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
			</td>

			<td class='fields' width ='25%'>
				<input type='text'  name='speciality' id='speciality' onBlur="getSpecialty1(this)" value='<%=primary_speciality%>'><input type='button' class='button' value='?' id='src_butn'  name='search_specialty' id='search_specialty' onClick="getSpecialty()"> 
			</td>

			<td class='label' width ='25%'>
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</td>

			<td class='fields' width ='25%'>
				<input type='text' size=10 maxlength='10' name='patientId' id='patientId' onBlur="chkPatientID(this)" ><input type='button' class='button' value='?' id='src_butn'  name='search_patient' id='search_patient' onClick="getPatient()">
			</td>

		</tr>
		<tr>
			<td class='label' width ='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
			</td> 
			<td class='fields' width ='25%' nowrap> 
				<select name="locn_type" id="locn_type" onchange="clearLocn(this);" >
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				</select>
				<input type='text'  name='location' id='location' onblur="getClinicCode1(this)" ><input type='button' class='button' value='?' id='src_location'  name='search_location' id='search_location' onClick="getClinicCode()"><img id='loc_img' style='display' src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td class ='label' width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/> 
			</td>
			<td class='fields' width='25%'>
				<input type='text'   name='service' id='service' onblur ="getService1(this)"><input type='button' class='button' value='?' id='src_butn'  name='search_service' id='search_service' onClick="getService()"> 
			</td>
		</tr>
		<tr> 
			<td class='label' colspan ='3'>
			</td>
			<td width='30%'  align=right > 
				<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="showPatList();"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onClick="clearPatList();">
			</td>
		</tr>

		</table>


	<input type="hidden" name="userId" id="userId" value="<%=userId%>">
	<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="speciality_code" id="speciality_code" value="<%=speciality_code%>">
	<input type="hidden" name="location_code" id="location_code" value="">
	<input type="hidden" name="service_code" id="service_code" value="">
	<input type="hidden" name="practitioner_name" id="practitioner_name" value="<%=practitioner_name%>">
	<input type="hidden" name="create_type" id="create_type" value="">
	<input type="hidden" name="practitionerId" id="practitionerId" value="<%=userId%>">
	<input type="hidden" name="locn_type_val" id="locn_type_val" value="">

	<input type="hidden" name="CurrentDate" id="CurrentDate" value="<%=CurrentDate%>">
	<input type="hidden" name="CurrentTime" id="CurrentTime" value="<%=CurrentTime%>">

	</form>
</body>
</html>

