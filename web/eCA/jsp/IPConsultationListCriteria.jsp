<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29413     Dinesh T    ARTEMIS - CRF
21/12/2011	  IN30050	  Dinesh T	  ARTEMIS - Updated for the patient id irrespective of the												  practitioners and updated the = to like in qry
29/12/2011	  IN30250	  Dinesh T	  ARTEMIS - Added the ipconsultation function in the patient
									  chart too
-----------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// added by Arvind @ 28-11-08 

	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
			 //end

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<!-- <script Language="JavaScript" src="../../eCommon/js/DateValidation.js"></script> -->
<script Language="JavaScript" src="../../eCA/js/DateValidation.js"></script>
<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
<script Language="JavaScript" src='../../eCommon/js/dchk.js'> </script>
<script language='javascript' src='../../eCA/js/DateCheck.js' ></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
String locale			= (String) p.getProperty("LOCALE");
String userId=((String) session.getValue("login_user")).trim();
String facilityid=((String) session.getValue("facility_id")).trim();
String bean_key="";
String practitioner_id="";
String consult_date_time="";
practitioner_id=request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
consult_date_time=request.getParameter("consult_date_time")==null?"":request.getParameter("consult_date_time");
String cons_date_time ="";
String cons_date ="";
String cons_time ="";
String patientID = "";//IN30250

cons_date_time		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);

String cons_date_arr[] = cons_date_time.split(" ");

cons_date = cons_date_arr[0];
cons_time = cons_date_arr[1];
bean_key =practitioner_id+consult_date_time;

eCA.IPConsultationListBean ipConsultListBean = null;
ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);
ipConsultListBean.clearBean();
String patIDLength = ipConsultListBean.getPatientIDLength();//IN29413
patientID = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//IN30250
%>

<body  class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='IPConsultationListCriteriaForm' id='IPConsultationListCriteriaForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	
<!-- <tr>
 <td class='label' width='20%'>Consultation List By</td>
 <td width='30%'><input type="radio" name="pract_rad" id="pract_rad" id='pract_self' class="label" value="S" checked onclick='practRadClick(this);' >Self&nbsp;<input type="radio" name="pract_rad" id="pract_rad" id='pract_behalf' class="label" value="O" onclick='practRadClick(this);'>On behalf of&nbsp; <input type='text' name='practitioner' id='practitioner' size=10 maxlength='10' value='<%=userId%>' readOnly ><input type='button' class='button' value='?' id='src_butn'  name='search_pract' id='search_pract' onClick="getPract(this);" disabled></td>
 <td class ='label' width='20%'>Consult Date </td>
	<td class ='fields' width='30%'><input type='text' size=10 maxlength='10' name='cons_date' id='cons_date' value='<%=cons_date%>'onblur=''><input type='image' id='cons_cal' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('cons_date');">&nbsp;<input type='text' size=2 maxlength='2' name='cons_time' id='cons_time' value='<%=cons_time%>'onblur=''> </td>
 
 </tr> -->
<!-- <tr>
	<td class ='label' width='25%'>Consult Date </td>
	<td class ='fields' width='25%'><input type='text' size=10 maxlength='10' name='cons_date' id='cons_date' value=''onblur=''><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('from_date');"><input type='text' size=2 maxlength='2' name='hour' id='hour' value=''onblur=''><input type='text' size=2 maxlength='2' name='min' id='min' value=''onblur=''> </td>
	<td class='label' colspan='2'><input type="radio" name="pract_rad" id="pract_rad" class="label" value="P" checked onclick=''>Self&nbsp;<input type="radio" name="pract_rad" id="pract_rad" class="label" value="S" onclick=''>On behalf of&nbsp; <input type='text' name='practitioner' id='practitioner' size=10 maxlength='10' value='<%=userId%>' readOnly ><input type='button' class='button' value='?' id='src_butn'  name='search_ref' id='search_ref' onClick="getClinicCode()"> </td>

 </tr> -->
	
<!-- <tr>

	<td class ='label' width='25%'>On behalf of</td><td class ='fields' colspan='3'><input type="radio" name="request_notes" id="request_notes" class="label" value="P" checked onclick=''>&nbsp;<fmt:message key="Common.self.label" bundle="${common_labels}"/>&nbsp;<input type='text' size=10 maxlength='10'>	<input type="radio" name="request_notes" id="request_notes" class="label" value="S" onclick=''>Practitioner&nbsp; <input type='text' size=10 maxlength='10'></td>
 </tr> -->

<tr>
<td class='label' width ='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td><td class='fields' width ='25%'><input type='text'  name='speciality' id='speciality' onBlur="getSpecialty1(this)"><input type='button' class='button' value='?' id='src_butn'  name='search_specialty' id='search_specialty' onClick="getSpecialty()"> </td><td class='label' width ='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td class='fields' width ='25%'><input type='text' size='<%=patIDLength%>' maxlength='<%=patIDLength%>' name='patientId' id='patientId' value= '<%=patientID%>' onBlur="chkPatientID(this)" ><input type='button' class='button' value='?' id='src_butn'  name='search_patient' id='search_patient' onClick="getPatient()"> </td><!--IN29413-->
</tr>

<tr>
<!-- Below option value 'Clinic' is commented By Archana Dhal on 5/5/2010 related to IN021047. -->
<td class='label' width ='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td> <td class='fields' width ='25%'>
 <select name="locn_type" id="locn_type" onchange="clearLocn();" >
		<option value="W"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		<!-- <option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option> -->
 </select>
 <input type='text'  name='location' id='location' onblur="getClinicCode1(this)" ><input type='button' class='button' value='?' id='src_location'  name='search_location' id='search_location' onClick="getClinicCode()">
</td>
<td class ='label' width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/> </td><td class='fields' width='25%'><input type='text'   name='service' id='service' onblur ="getService1(this)"><input type='button' class='button' value='?' id='src_butn'  name='search_service' id='search_service' onClick="getService()"> </td>
</tr>
<tr><!--IN29413-->
<td class ='label' width='25%'><fmt:message key="eCA.BedNo.label" bundle="${ca_labels}"/> </td><td class='fields' width='25%'><input type='text' name='bedNo' id='bedNo'  maxlength='8' size='8'></td>
</tr>
<tr> <td class='label' colspan ='3'></td> <td width='30%'  align=right > 
	<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="showPatList();"><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onClick="clearPatList();"></td></tr><!--IN30250-->
</table>

			  <!-- added by arvind @ 28-11-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->

<input type="hidden" name="userId" id="userId" value="<%=userId%>">
<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="practitionerId" id="practitionerId" value="<%=userId%>">
<input type="hidden" name="bean_key" id="bean_key" value="<%=bean_key%>">
<input type="hidden" name="speciality_code" id="speciality_code" value="">
<input type="hidden" name="location_code" id="location_code" value="">
<input type="hidden" name="service_code" id="service_code" value="">
<input type="hidden" name="restrictSearch" id="restrictSearch" value=""><!--IN30050-->

</form>
<script>
	if(parent.IPConsultationListTopFrame.document.forms[0])
	{
		var create_type = parent.IPConsultationListTopFrame.document.forms[0].create_type.value;
		if(create_type=='S')
		{
		
			document.forms[0].speciality.value='';
			document.forms[0].speciality_code.value='';
			document.forms[0].speciality.disabled = true;
			document.forms[0].search_specialty.disabled = true;

		}
	}
	//IN30250,starts
	if("<%=patientID%>" != '')
	{
		document.getElementById("search").click();
	}
	//IN30250,ends
</script>

</body>
</html>
<%
putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);
%>

