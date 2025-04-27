<!DOCTYPE html>
<%
/*  							 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date	Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           							created

26/11/2014	IN050580		Nijitha 								MO-CRF-20080
12/05/2014	IN052859 		Nijitha									MO-CRF-20080
---------------------------------------------------------------------------------------------------------------
*/
%> 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.sql.*,java.util.*,eOR.* ,webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.XSSRequestWrapper" %>

 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="beanObj"  scope="page"  class="eCA.CARefferralNotesBean"/>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
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
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type="text/javascript" src="../../eCA/js/CANotesRefferalTracking.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String practitioner_id = (String)session.getValue("ca_practitioner_id");//IN052859
	String appl_user_id = (String)session.getValue("login_user");
	String facility_id = (String)session.getValue("facility_id");
	if(practitioner_id == null)practitioner_id = "";
	int patient_id_length =10;
	String p_patient_id = request.getParameter( "p_patient_id" ) ;
	if(p_patient_id==null) p_patient_id = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	last_week_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	curr_week_date	= com.ehis.util.DateUtils.minusDate(last_week_date,"DMY",localeName,7,"d");
	

	if(last_week_date.equals("null") || last_week_date.equals(" ")) last_week_date="";
	if(curr_week_date.equals("null") || curr_week_date.equals(" ")) curr_week_date="";

	beanObj.setLocale(localeName);
	beanObj.setClinician_id(appl_user_id);
	ArrayList facilityDetails = beanObj.getFacilityDetails();

%>
<form name='refferal_note_search' id='refferal_note_search' target='messageFrame' >

<TABLE cellpadding=3 cellspacing=0 border='0'  width="100%"  align=center  id="detailsTable" >
	<TR>
		<TD class='label' width='15%'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></TD>
		<TD class=fields width='35%'>
			<fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/>
			<input type="checkbox" name='referredFromData' id='referredFromData' value = 'Y' checked onclick='checkRefferedFromToWinReqYN(this)' /> &nbsp&nbsp<fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/>
			<input type="checkbox" name='referredToData' id='referredToData' value = 'N' onclick='checkRefferedFromToWinReqYN(this)' />
		</TD>
		<TD class=label width='15%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></TD>
		<TD class=fields width='35%'> 
			<input type="text" name="date_from" id="date_from"  size="16" maxlength="16" value="<%=curr_week_date%>" onBlur='chkMandate(this);validDateObj(this,"DMY","<%=localeName%>")' style="width:100px">
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('date_from');" style='cursor:pointer' >
			<input type=text name='date_to' id='date_to'  size=16 maxlength=16 value="<%=last_week_date %>" onBlur='chkMandate(this);validDateObj(this,"DMY","<%=localeName%>")' style="width:100px">
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('date_to');" style='cursor:pointer' ><img src="../../eCommon/images/mandatory.gif" align=center></img>
		</TD>
	</TR>	
	<TR>
		<TD class='label' width='15%'><fmt:message key="Common.Forward.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp<fmt:message key="eCA.Facility.label" bundle="${ca_labels}"/></TD>
	    <TD class='fields' width='35%'>
			<Select name='facility' id='facility'>
			   <Option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
			   <%for (int i=0;i<facilityDetails.size();i++) {
				String [] facility = (String[])facilityDetails.get(i);
			   %>
			  <Option value='<%=facility[1]%>' <%=(facility_id.equals(facility[1]) ? "selected" : "")%>><%=facility[0]%></Option>
			   <%}%>
			</Select>
		</TD>
		<TD class='label' width='15%'><fmt:message key="Common.Forward.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp<fmt:message key="eCA.Facility.label" bundle="${ca_labels}"/></TD>
	   <TD class='fields' width='35%'>
			<Select name='forward_to_facility' id='forward_to_facility'>
			   <Option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
			   <%for (int i=0;i<facilityDetails.size();i++) {
				String [] facility = (String[])facilityDetails.get(i);
			   %>
			   <Option value='<%=facility[1]%>' <%=(facility_id.equals(facility[1]) ? "selected" : "")%>><%=facility[0]%></Option>
			   <%}%>
			</Select>
		</TD> 		
	</TR>
	<TR>
		<TD class='label' width='15%'><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/> <fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width ='35%' colspan='1'>
			<input type='text'  name='spec_name' id='spec_name' value=''  onKeyPress='' onBlur='getSpecialty(this)' size='20' maxlength='20'>
			<input type='button' name='spec_desc_search' id='spec_desc_search' value='?'  class='button' tabIndex="4" onClick="getSpecialty(this)">
			<input type="hidden" name="specialty_code" id="specialty_code" value='ALL'>
		</TD>
		<TD class='label' width='15%'><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/> <fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width ='35%' colspan='1'>
			<input type='text'  name='spec_name_to' id='spec_name_to' value=''  onKeyPress='' onBlur='getSpecialty(this)' size='20' maxlength='20'>
			<input type='button' name='spec_desc_search_to' id='spec_desc_search_to' value='?'  class='button' tabIndex="4" onClick="getSpecialty(this)">
			<input type="hidden" name="to_specialty_code" id="to_specialty_code" value='ALL'>
		</TD>
	</TR>
	<TR>
		<TD class='label' width='15%'><fmt:message key="eOR.note.label" bundle="${or_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='35%'>
			<Select name='status' id='status'>
				<Option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
				<Option value='4'><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></Option>
				<Option value='2'><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/></Option>
				<Option value='3'><fmt:message key="Common.Unauthorized.label" bundle="${common_labels}"/></Option>
				<Option value='5'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/></Option>
			</Select>
						
		</TD>
		<TD class=label id='ord_pract_lbl_td' width='15%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<TD class='fields' width='35%'>
			<input type="text" name="ordering_pract_desc" id="ordering_pract_desc" value="" onblur='callpractSearchSpecimenSearch1(ordering_pract_desc,ordering_pract);'>
			<input type=button name='practSearch' id='practSearch' value='?'  class=button tabIndex="4" onClick="callpractSearchSpecimenSearch1(ordering_pract_desc,ordering_pract);">
			<input type="hidden" name="ordering_pract" id="ordering_pract" value="ALL">
		</TD>
	</TR>
	<TR>	
		<TD  class=label id='patientId_lbl_td' width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<TD class=fields id='patientId_td' width='35%'>
			<input type='text' name='patientId' id='patientId' value ="<%=p_patient_id%>"  onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength='<%=patient_id_length%>'>
			<input type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()">
		</TD>
		<TD class='label' width='15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='35%'>
			<Select name='patientclass' id='patientclass'>
				<Option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
				<Option value='DC'>DayCare</Option>
				<Option value='EM'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></Option>
				<Option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></Option>
				<Option value='OP'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></Option>
			
			</Select>
		</TD>
	</TR>
	<TR>
		<TD class='label' width='15%'><fmt:message key="Common.referral.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='35%'>
			<Select name='referral_status' id='referral_status'>
				<Option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
				<Option value='CO'><fmt:message key="eCA.Reviewed.label" bundle="${ca_labels}"/></Option>
				<Option value='RQ'>Not <fmt:message key="eCA.Reviewed.label" bundle="${ca_labels}"/></Option>	
			</Select>
		</TD>
		<TD class='label' width='15%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='35%'>
			<SELECT name="location_type" id="location_type" onChange='populateLocation(this)'>
				<option value='ALL' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='C' ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value='N' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value='R' ><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
			</SELECT>
			<input type="text" value='' name="locn" id="locn" onblur='populateMoveLoaction1(locn,locn_code);' disabled>
			<input type=button name="SourceSearch" id="SourceSearch" value='?'  class=button tabIndex="4" onClick="populateMoveLocation(locn,locn_code);" disabled>
			<img src="../../eCommon/images/mandatory.gif" align=center style='display:none' id='imgmand'>
			<input type="hidden" name="locn_code" id="locn_code" value="ALL">
			<input type="hidden" name="locn_code1" id="locn_code1" value="">
		</TD>
	</TR>	
	
	<TR>
		<TD class='fields' width='50%' colspan='2' ></TD>
		<TD class='fields' width='50%' colspan='2' >
			<input type="button" class="button" name="search_btn" id="search_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="populateValues();NoteRefTracCompHeaderFrames();"/>
			&nbsp;&nbsp;
			<input type="button" class="button" name="search_btn" id="search_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>" onClick="resetClick();"/>
			&nbsp;&nbsp;
			<input type="button" class="button" name="hide_btn" id="hide_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HideHeader.label","ca_labels")%>" onClick="NoteRefTracCompHeaderFrames();"/>
		</TD>
	</TR>
		
</TABLE>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="clinic_sql" id="clinic_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")%>">
<input type="hidden" name="nursing_sql" id="nursing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")%>">
<input type="hidden" name="referral_sql" id="referral_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_R")%>">
<input type="hidden" name="specimen_Orderby_pract" id="specimen_Orderby_pract" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_AM_PRACT")%>">
<input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=curr_week_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=last_week_date %>">
<input type="hidden" name="logged_in_pract" id="logged_in_pract" value="<%=practitioner_id %>">

<TABLE id="headerLineTable"  width="100%" border=1 style="display:none" align='center' cellspacing="0">
	<TR>
		<TD width='100%' style="background-color:#83AAB4" align = right class = 'CAHIGHERLEVELCOLOR'>
			<input type=button value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShowHeader.label","ca_labels")%>" class=button onclick="NoteRefTracExpHeaderFrames();">
		</TD>
	</TR>
</TABLE>
</form>
</body>
</html>
<script>
populateValues();
</script>

