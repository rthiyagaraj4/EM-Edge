<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderOPSearch.jsp
File Description: Header File: This is to search all the Outpatient lists who 
						1) Books an appointment but yet to visit 
						2) Visit clinic with appointment
						3) Direct Visit without appointment
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>


<html>

<head>
	<%  
	    //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends

		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
		(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";

		String facility_id	= (String)session.getAttribute("facility_id");
		String language_Id  = (String)session.getAttribute("LOCALE");
		String loginuser    = (String) session.getValue( "login_user" );
		String alternateBooking = (String)request.getParameter("alternateBooking");
		String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");	
		System.out.println("loginuser:"+loginuser);
		System.out.println("oper_id:"+oper_id);
		String param = request.getQueryString();
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eDS/js/PlaceMealOrderOPSearch.js"></script>
	<script language="javascript" src="../../eDS/js/DSResourceLookUp.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<fmt:setBundle basename="eDS.resources.Labels" var="ds_labels"/>
</head>
<%
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
    String SystemDate_display = dateFormat.format(date);
	SystemDate_display = com.ehis.util.DateUtils.convertDate(SystemDate_display,"DMY","en",language_Id);
	//ML-MMOH-CRF-1651 US001 Starts
	long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
	date = new Date(date.getTime()-MILLIS_IN_A_DAY);
	String PreviousDate_display = dateFormat.format(date);
	PreviousDate_display = com.ehis.util.DateUtils.convertDate(PreviousDate_display,"DMY","en",language_Id);
	//ML-MMOH-CRF-1651 US001 Ends
	
%>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="loadSpeciality();hideEMSearchCriteria();">
<form name='placeOPMealOrder' id='placeOPMealOrder' target="workListResult">

<%-- <table border="0" cellpadding="2" cellspacing="0" width="100%" align="center">
<tr>
	<td  class=label ><fmt:message key="Common.mealOrderFor.label" bundle="${ds_labels}"/></td>
	<td  class=label >Meal Order For</td>
	<td class="label"> <input type="radio" name="mealOrderFor" id="mealOrderFor" value="OP">Out Patient </td>
	
	<td align="right" class="label">  <input type="radio" name="mealOrderFor" id="mealOrderFor" value="EM">Emergency Patient</td>
</tr>
</table> --%>
<table id="OPSearchCriteria" name="OPSearchCriteria" border="0" cellpadding="2" cellspacing="0" width="100%" align="center">

	<tr>
	<%-- 	<td  class=label ><fmt:message key="Common.mealOrderFor.label" bundle="${ds_labels}"/></td> --%>
		<td  class=label >Meal Order For</td>
		<td class="label"> <input type="radio" name="mealOrderFor" id="mealOrderFor" value="OP" onclick="showSearchCriteria(this);">Out Patient </td>
		
		<td  class="label">  <input type="radio" name="mealOrderFor" id="mealOrderFor" value="EM" onclick="showSearchCriteria(this);">Emergency Patient</td>
	</tr>
	<tr><td><br/></td></tr>
	<tr class="Row_OutPatient">
		<td  class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td id="td_speciality">
			<select name="speciality" id="speciality" tabindex=1> 
			<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			</select><img src='../../eCommon/images/mandatory.gif' />
		</td>
		<td  class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td>
				<fmt:message key="Common.from.label" bundle="${common_labels}"/>
				<Input type="text"  name="dateFrom" id="dateFrom" size="10" maxlength="10"  value="<%=SystemDate_display%>"  onblur="isValidDate(this);"/>
				<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateFrom');">
				<img src='../../eCommon/images/mandatory.gif' />
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				<Input type="text"  name="dateTo" id="dateTo" size="10" value="<%=SystemDate_display%>"  maxlength="10"/>
				<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateTo');">
		</td>
	</tr>
	<tr class="Row_OutPatient">
		<td  class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td>
			<select name="loctype" id="loctype" tabindex=1 onChange="enableCtrl('location', 'btnLocation', location, this);"> 
			<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			</select>
		</td>
		<td  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<!-- ML-MMOH-CRF-0752.7-US001 -->
		<td>
			<input type="text" name="location" id="location" onblur="getLocn('<%=loginuser%>','<%=oper_id%>','<%=facility_id%>',document.forms[0].loctype.value,document.forms[0].location)" value="" size='36' disabled=true>
			<input type="hidden" name="hdnlocation" id="hdnlocation" value="">
			<input type=button class=button value='?' name="btnLocation" id="btnLocation" onClick="getLocn('<%=loginuser%>','<%=oper_id%>','<%=facility_id%>',document.forms[0].loctype.value,document.forms[0].location)" disabled=true>
		</td>
	
	</tr>
	<tr class="Row_OutPatient">
		<td  class=label ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<td class='fields'>
					<SELECT name='resourceType_1' id='resourceType_1' onChange="enableCtrl('practitioner_name', 'search_pract', practitioner_name, this);">
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT>
		</td>
		<td  class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		
		<td>
			<input type=text name='practitioner_name' id='practitioner_name'  onblur="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" value=''  onblur="" size='25' disabled=true>
			<input type=hidden name='practitioner' id='practitioner'  value='' size='30' maxlength='30' ></input>
			<input type='button' class='button' value='?'  name='search_pract' id='search_pract'  onClick="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" disabled=true>
			<input type=hidden name='resourceType_2' id='resourceType_2'  value='' size='30' maxlength='30' >
		</TD>
	<tr class="Row_OutPatient">
		<td  class=label ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>
			<input type="text" name="patientid" id="patientid" value="" size='12'>
			<input type=button class=button value='?' onClick='getPatID()' >
		</td>
		<td  class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>
			<input type="text" name="encounter_id" id="encounter_id" value="" size='12' maxlength='12' onKeyPress='return(ChkNumberInput(this,event,0))'>
		</td>
	</tr>
	<tr class="Row_OutPatient" border=1>
		<td  class=label ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td>
			<select name="status" id="status">
				<option value="">
					<fmt:message key="Common.all.label" bundle="${common_labels}" />
				</option>
				<option value="A">
					<fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}" />
				</option>
				<option value="C">
					<fmt:message key="eOT.OrderPending.Label" bundle="${ot_labels}" />
				</option>
				<option value="F">
					<fmt:message key="eOT.OrderModified.Label" bundle="${ot_labels}" />
				</option>
			</select>
		</td>
		<td  class="label"><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
		<td>
			<input type="text" name="apptno" id="apptno" value="" size='12' maxlength='8' onKeyPress='return(ChkNumberInput(this,event,0))'>
		</td>
	</tr>
	
	<tr class="Row_EMPatient" style="display:none">
		<td  class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td>
			<Input type="text"  name="date_EM" id="date_EM" size="10" maxlength="10"  value="<%=SystemDate_display%>"  onblur="isValidDate(this);"/>
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_EM');">
			<img src='../../eCommon/images/mandatory.gif' />
		</td>
		<td></td>
		<td></td>
	</tr>	
	
	
	<tr class="Row_EMPatient" style="display:none">
		<td  class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td>
			<select name="loctype_EM" id="loctype_EM" tabindex=1"> 
			<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			</select>
		</td>
		<td  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<!-- ML-MMOH-CRF-0752.7-US001 -->
		<td>
			<input type="text" name="location_EM" id="location_EM" onchange="getTreatmentArea()" onblur="getLocn_EM('<%=loginuser%>','<%=oper_id%>','<%=facility_id%>',document.forms[0].loctype_EM.value,document.forms[0].location_EM)" value="" size='36'>
			<input type="hidden" name="hdnlocation_EM" id="hdnlocation_EM" value="">
			<input type=button class=button value='?' name="btnLocation_EM" id="btnLocation_EM" onClick="getLocn_EM('<%=loginuser%>','<%=oper_id%>','<%=facility_id%>',document.forms[0].loctype_EM.value,document.forms[0].location_EM)">
			<img src='../../eCommon/images/mandatory.gif' />
		</td>
	
	</tr>
	<tr class="Row_EMPatient" style="display:none">
		<td  class="label"><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
		<td>
			<select name="priorityZone" id="priorityZone" onchange="getTreatmentArea()" tabindex=1> 
				<%-- <option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
							<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
							<option value='G'><fmt:message key="Common.Green.label" bundle="${common_labels}"/>
							<option value='R'><fmt:message key="Common.Red.label" bundle="${common_labels}"/>
							<option value='Y'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/>
							<option value='U'><fmt:message key="Common.Unassigned.label" bundle="${common_labels}"/> --%>
				
			</select>
		</td>
		<td  class="label" ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
		<td id="td_treatmentArea">
			<select name="treatmentArea" id="treatmentArea" tabindex=1> 
				<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			</select>
		</td>
	</tr>	
	<tr class="Row_EMPatient" style="display:none">
		<td  class="label" ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<td class='fields'>
					<SELECT name='resourceType_EM' id='resourceType_EM' disabled>
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
					<option value='P' selected><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT>
		</td>
		<td  class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		
		<td>
			<input type=text name='practitioner_name_EM' id='practitioner_name_EM'  onblur="callPractSearch1(this,practitioner_name_EM,'en','<%=facility_id%>');" value=''  onblur="" size='25'>
			<input type=hidden name='practitioner_EM' id='practitioner_EM'  value='' size='30' maxlength='30' ></input>
			<input type='button' class='button' value='?'  name='search_pract_EM' id='search_pract_EM'  onClick="callPractSearch1(this,practitioner_name_EM,'en','<%=facility_id%>');">
			<input type=hidden name='Hid_ResourceType_EM' id='Hid_ResourceType_EM'  value='P' size='30' maxlength='30' >
<!-- 			<input type=hidden name='resourceType_1' id='resourceType_1'  value='P' size='30' maxlength='30' > -->
		</TD>
	<tr class="Row_EMPatient" style="display:none">
		<td  class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>
			<input type="text" name="patientid_EM" id="patientid_EM" value="" size='12'>
			<input type=button class=button value='?' onClick='getPatID_EM()' >
		</td>
		<td  class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>
			<input type="text" name="encounterId_EM" id="encounterId_EM" value="" size='12' maxlength='12' onKeyPress='return(ChkNumberInput(this,event,0))'>
		</td>
	</tr>
	<tr class="Row_EMPatient" border=1 style="display:none">
		<td  class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td>
			<select name="status_EM" id="status_EM">
				<option value="">
					<fmt:message key="Common.all.label" bundle="${common_labels}" />
				</option>
				<option value="A">
					<fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}" />
				</option>
				<option value="C">
					<fmt:message key="eOT.OrderPending.Label" bundle="${ot_labels}" />
				</option>
				<option value="F">
					<fmt:message key="eOT.OrderModified.Label" bundle="${ot_labels}" />
				</option>
			</select>
		</td>
	</tr>	
	<TR border=1 align="right">
			<TD colspan="4">	
				<INPUT type="button" name="alterfacility" id="alterfacility" value="<fmt:message key="eDS.alternateFacility.Label" bundle="${ds_labels}" />" class="button" onClick="alternateFacility()"/>
				<INPUT type="button" name="button1" id="button1" value="<fmt:message key="Common.search.label" bundle="${common_labels}" />" class="button" onClick="searchMealOrder()"/>
			</TD>
		</TR>
	</tbody>
</table>

 <input type='hidden' name='locale' id='locale' value='<%=language_Id%>'>
 <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
 <input type="hidden" name="from" id="from" value="">
 <input type="hidden" name="to" id="to" value="">
 <input type="hidden" name="hdnkitchen" id="hdnkitchen" value="">
 <input type="hidden" name="hdnHdrSpeciality" id="hdnHdrSpeciality" value="">
 <input type="hidden" name="alternateBooking" id="alternateBooking" value=<%=alternateBooking%>>
 <input type="hidden" name="systemDate" id="systemDate" value='<%=SystemDate_display%>' />
 <input type="hidden" name="PreviousDate_display" id="PreviousDate_display" value='<%=PreviousDate_display%>' />
</form>

<script>
async function alternateFacility() {
	var altFacilityURL = "../../eDS/jsp/ExternalFacilityLinker.jsp?<%=param%>";	
	var dialogHeight	= "10" ;
	var dialogWidth	= "25" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
	var reportURL 	=await window.showModalDialog( altFacilityURL, arguments, features ) ;
}
</script>
</body>
</html>

