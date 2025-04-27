<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
30/05/2019	IN070213	     Sivabagyam M   30/05/2019	    Ramesh G		AAKH-SCF-0395
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String path = request.getContextPath(); 
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String locale = p.getProperty("LOCALE");
	String added_by_id			= p.getProperty("login_user");//login_by_id			
	String added_at_ws_no		= p.getProperty("client_ip_address");//login_at_ws_no
	String patient_id = request.getParameter("patientid") == null ? "": request.getParameter("patientid");
	String encounterid = request.getParameter("encounterid") == null ? "": request.getParameter("encounterid");
	String facility_id = request.getParameter("facilityid") == null ? "": request.getParameter("facilityid");
	String p_report_id = request.getParameter("p_report_id") == null ? "": request.getParameter("p_report_id");
	String bean_id="CAInsurenceAuthorizationFormsBean";
	String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
	eCA.CAInsurenceAuthorizationFormsBean bean = (eCA.CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
	ArrayList<String> formData = bean.getFormData(patient_id,encounterid,facility_id);	
	String disable_flag = "disabled";
	Boolean icon_swapper = false;
	/***********************************ICON SWAPPER****************************************************/
	if("CAAKINFDAMAN".equals(p_report_id)){
		icon_swapper = true;
	}else if("CAAKINFTHIQA".equals(p_report_id)){
		icon_swapper = false;
	}
	/***********************************CHECKBOX FLAGS **************************************************/
	String ip_chk = "";
	String op_chk = "";
	String dc_chk = "";
	String em_chk = "";
	String newVisit_chk = "";
	String followup_chk = "";
	String rd_traffic_accident_chk = "";
	String referral_chk = "";
	String admission_chk = "";
	String mri_chk = "";
	String ct_scan_chk = "";
	String physio_chk = "";
	String home_nursing_chk = "";
	String endoscopy_chk = "";
	String others_chk = "";
	
	/****************************************************************************************************/
	/***********************************FORM INPUTS ****************************************************/
	String patient_name 			= formData.get(0);//patient_name
	String card_id_no				= formData.get(1);//card_id_no
	String contact_no				= formData.get(2);//contact_no
	String provider_name			= formData.get(3);//provider_name
	String physician_license_no 	= formData.get(4);//physician_license_no
	String date 					= formData.get(5);//date
	String patient_class			= formData.get(6);//patient_class
	String visit_adm_type_ind		= formData.get(7);//visit_adm_type_ind
	String mv_accident_yn			= formData.get(8);//mv_accident_yn
	String referral_id				= formData.get(9);//referral_id
	String referral_source			= formData.get(10);//referral_source
	String exp_length_of_stay		= formData.get(11);//exp_length_of_stay
	String exp_date					= formData.get(12);//exp_date
	String specify					= formData.get(13);//specify
	String doctor_name				= formData.get(14);//doctor_name
	String admission_yn				= formData.get(15);//admission_yn 
	String mri_yn					= formData.get(16);//mri_yn
	String ct_scan_yn				= formData.get(17);//ct_scan_yn
	String physio_yn				= formData.get(18);//physio_yn
	String home_nursing_yn			= formData.get(19);//home_nursing_yn
	String endoscopy_yn				= formData.get(20);//endoscopy_yn
	String others_yn				= formData.get(21);//others_yn
	String chiefComplaints			= formData.get(22);//chiefComplaints
	String attend_practitioner_id	= formData.get(23); //attend_practitioner_id
	/****************************************************************************************************/
	/***********************************CHECKBOX VALIDATIONS ********************************************/
	if("IP".equals(patient_class)){
		ip_chk = "checked";
		op_chk = "";
		dc_chk = "";
		em_chk = "";
	}else if("OP".equals(patient_class)){
		ip_chk = "";
		op_chk = "checked";
		dc_chk = "";
		em_chk = "";
	}else if("DC".equals(patient_class)){
		ip_chk = "";
		op_chk = "";
		dc_chk = "checked";
		em_chk = "";
	}else if("EM".equals(patient_class)){
		ip_chk = "";
		op_chk = "";
		dc_chk = "";
		em_chk = "checked";
	}
	if("F".equals(visit_adm_type_ind)){
		newVisit_chk = "checked";
		followup_chk = "";
	}else if("L".equals(visit_adm_type_ind)){
		newVisit_chk = "";
		followup_chk = "checked";
	}
	if("Y".equals(mv_accident_yn)){
		rd_traffic_accident_chk = "checked";
	}
	if(!"".equals(referral_id) && referral_id!=null){
		referral_chk = "checked";
	}
	if("Y".equals(admission_yn)){
		admission_chk = "checked";
	}
	if("Y".equals(mri_yn)){
		mri_chk = "checked";
	}
	if("Y".equals(ct_scan_yn)){
		ct_scan_chk = "checked";
	}
	if("Y".equals(physio_yn)){
		physio_chk = "checked";
	}
	if("Y".equals(home_nursing_yn)){
		home_nursing_chk = "checked";
	}
	if("Y".equals(endoscopy_yn)){
		endoscopy_chk = "checked";
	}
	if("Y".equals(others_yn)){
		others_chk = "checked";
	}
	/****************************************************************************************************/
%>

<html>
<head>
<meta charset="utf-8">
<title>Page DAMAN</title>
<link rel='StyleSheet' href='../html/CATabInsuranceAuthorization.css' type='text/css'/>
<style type="text/css">


</style>
<script type="text/javascript">
function on() {
	document.getElementById("somediv").style.display = "block";
	var canvas = document.getElementById('can');
	var ctx = canvas.getContext('2d');
	ctx.fillStyle = 'white';
	ctx.fillRect(0, 0, canvas.width, canvas.height);
}
	function off() {
	  document.getElementById("somediv").style.display = "none";
}
</script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="JavaScript" src="../../eCA/js/CATabInsuranceAuthorizationForm.js"></script>
</head>

<body onload="init();viewImage('<%=patient_id%>','<%=encounterid%>','<%=p_report_id%>')">
<div id='somediv' style="display:none;">
	<div>
	<canvas id="can" width="800" height="200" class="center"
		style="border: 2px solid; background-color:#ffffff;"></canvas>
	<canvas id="blank" style='display:none'></canvas>
	</div>
	<div>
		<input type="button" value="Save" id="btn" size="30" onclick="off();saveData('<%=patient_id%>','<%=facility_id%>','<%=encounterid%>','<%=p_report_id%>','<%=added_by_id%>','<%=added_at_ws_no%>');">
		<input type="button" value="Clear" id="btn" size="30" onclick="clearSign()">
		<input type="button" value="Close" id="btn" size="30" onclick="off()">	
	</div>
	
</div>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td colspan="2">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<%if(icon_swapper){%>
									<td class="bg1 txtbig">Authorization Request for Inpatient / OutPatient Form</td>
									<td align="right" width="75px">
										<img src="../../eCA/images/Logo_daman.jpg" width="68" height="60" alt=""/>
									</td>
									<%}else{%>	
									<td class="bg1 txtbig">Authorization Request for Inpatient / OutPatient Services</td>
									<td align="right" width="75px">
										<img src="../../eCA/images/Logo_Thiqa.jpg" width="77" height="60" alt=""/>
									</td>
									<%}%>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="content-txt tdH1" style="">Patient's
						Details (To be filled by the Admission Department)
					</td>
				</tr>
				<tr>
					<td colspan="2" class="border1"><table width="100%"
							cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td class="borderBot content-txt ">Patient's Name: (as
										written on card) <br> <%=patient_name%>
									</td>
									<td rowspan="6" width="30%" class="borderleft"><img src='../../eCA/jsp/CATABDisplayImages.jsp?patient_id=<%=patient_id%>&encounterid=<%=encounterid%>&patient_class=<%=patient_class%>&facility_id=<%=facility_id%>&Param=PAT_PHOTO' width="400" border=0 height="250"></td>
								</tr>
								<tr>
									<td class="borderBot content-txt ">Card ID Number : <%=card_id_no%></td>
								</tr>
								<tr>
									<td class="borderBot content-txt ">Patient Contact
										No.:(Mobile) (mandatory)<br><%=contact_no%></td>
								</tr>
								<tr>
									<td class="borderBot content-txt ">Provider's Name / Code :
										<%=provider_name%></td>
								</tr>
								<tr>
									<td class="borderBot content-txt ">Physician's License No.: <%=physician_license_no%></td>
								</tr>
								<tr>
									<td class="content-txt ">Date: <%=date%></td>
								</tr>
							</tbody>
						</table></td>
				</tr>
				<tr>
					<td colspan="2" class="content-txt tdH1" style="">Service
						/Admission Information (To be filled by the admission Department)</td>
				</tr>
				<tr>
					<td colspan="2"><table width="100%" cellpadding="0"
							cellspacing="0" class="border2">
							<tbody>
								<tr>
									<td class="content-txt "><input type="checkbox"
										name="checkbox1" id="checkbox1" id="checkbox1" <%=disable_flag%> <%=ip_chk%>> <label 
										for="checkbox1">Inpatient </label></td>
									<td class="content-txt "><input type="checkbox"
										name="checkbox2" id="checkbox2" id="checkbox2" <%=disable_flag%> <%=op_chk%>> <label
										for="checkbox2">Outpatient </label></td>
									<td class="content-txt "><input type="checkbox"
										name="checkbox3" id="checkbox3" id="checkbox3" <%=disable_flag%> <%=dc_chk%>> <label 
										for="checkbox3">Day	Care</label></td>
								</tr>
							</tbody>
						</table></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><table width="100%" cellpadding="0"
							cellspacing="0" class="border1">
							<tbody>
								<tr>
									<td class="content-txt">Category:<br> <br> 
									<input type="checkbox"
										name="checkbox4" id="checkbox4" id="checkbox4" <%=disable_flag%> <%=em_chk%>>
										<label
										for="checkbox4">ER</label> <br> <input type="checkbox" name="checkbox5" id="checkbox5" id="checkbox5" <%=disable_flag%>> <label
										for="checkbox5">Work
										Related Accident</label>
									</td>
									<td class="content-txt "><input name="checkbox4" id="checkbox4"
										type="checkbox" id="checkbox5" <%=disable_flag%> <%=newVisit_chk%>> <label
										for="checkbox5"></label> New Visit<br> <input type="checkbox" name="checkbox8" id="checkbox8" id="checkbox8" <%=disable_flag%> <%=referral_chk%>> <label
										for="checkbox8">Referral</label></td>
									<td class="content-txt "><input type="checkbox"
										name="checkbox4" id="checkbox4" <%=disable_flag%> <%=followup_chk%> id="checkbox6"> <label for="checkbox6">Follow-up<br>
											<input type="checkbox" name="checkbox9" id="checkbox9" id="checkbox9" <%=disable_flag%> <%=rd_traffic_accident_chk%>>
											Road Traffic Accident
									</label></td>
								</tr>
								<tr>
									<td colspan="3" class="content-txt ">If referral please
										specify source: <u><%=referral_source%></u></td>
								</tr>
							</tbody>
						</table></td>
				</tr>
				<tr>
					<td colspan="2" class="content-txt " style="">Medical Details
						(To be filled by Medical Doctor- Please do not use abbreviations)</td>
				</tr>
				<tr>
					<td colspan="2" class="border1"><table width="100%"
							cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td colspan="4" class="borderBot content-txt ">Chief
										Complaints:
										<BR>
										<%=chiefComplaints %>
									</td>
	
								</tr>
								<tr>
									<td colspan="4" class="borderBot content-txt ">Diagnosis
										(ICD-9 Description):</td>
								</tr>
								<tr>
									<td colspan="3" class="borderBot content-txt ">Anticipated
										Management Plan:</td>
									<td class="borderBot content-txt ">Estimated Cost :
										________________________________</td>
								</tr>
								<tr>
									<td colspan="2" class="content-txt ">Expected Length of
										Stay:<%=exp_length_of_stay%>
									</td>
									<td class=" content-txt ">Days</td>
									<td class=" content-txt ">Expected Date of Admission/
										Service :<%=exp_date%></td>
								</tr>
								<tr>
									<td colspan="2" class="borderBot content-txt "><input type="checkbox" name="checkbox10" id="checkbox10" id="checkbox10" <%=disable_flag%> <%=dc_chk%>> <label
										for="checkbox10">Day Care </label></td>
									<td class="borderBot content-txt ">&nbsp;</td>
									<td class="borderBot content-txt ">Estimated Cost :
										________________________________</td>
								</tr>
								<tr>
									<td colspan="4" class=" content-txt ">Services requiring
										approval from National Health Insurance Company- Daman<br>
									</td>
								</tr>
								<tr>
									<td colspan="4" class=" content-txt "><input type="checkbox" name="checkbox11" id="checkbox11" id="checkbox11" <%=admission_chk%> <%=disable_flag%>> <label
										for="checkbox11">Admission <input type="checkbox"
											name="checkbox12" id="checkbox12" id="checkbox12" <%=mri_chk%> <%=disable_flag%>> MRI <input type="checkbox" name="checkbox13" id="checkbox13" <%=ct_scan_chk%> <%=disable_flag%> id="checkbox13"> CT
											Scan <input type="checkbox" name="checkbox14" id="checkbox14" id="checkbox14" <%=physio_chk%> <%=disable_flag%>>
											Physiotherapy <input type="checkbox" name="checkbox15" id="checkbox15"
											id="checkbox15" <%=home_nursing_chk%> <%=disable_flag%>> Home Nursing <input type="checkbox"
											name="checkbox16" id="checkbox16" id="checkbox16" <%=endoscopy_chk%> <%=disable_flag%>> Endoscopy <input type="checkbox" name="checkbox17" id="checkbox17" id="checkbox17" <%=others_chk%> <%=disable_flag%>>
											Others
									</label></td>
								</tr>
								<tr>
									<td colspan="4" class=" content-txt ">Specify:
										<%if("".equals(specify)){%>__________________________________________________________________________<%}
										else{%><%=specify%><%}%>
										</td>
								</tr>
								<tr>
									<td class="content-txt ">Doctor's name: <%=doctor_name %></td>
									<td colspan="2" class="content-txt">
										<table width="100%" cellpadding="0" cellspacing="0"><tr><td valign="center" class="content-txt " width="40%">
										Signature and stamp of
										doctor &nbsp;:</td><td width="60%"><U><img src='../../eCA/jsp/CATABDisplayImages.jsp?attend_practitioner_id=<%=attend_practitioner_id%>&Param=PRACTITIONER_SIGN' width="250" border=0 height="40"></td></tr></table>
									</td>
									<td class="content-txt ">Date:</td>
								</tr>
							</tbody>
						</table></td>
				</tr>
				<tr>
					<td colspan="2" class="Txtcontent" style="">
						<table><!-- IN070213 starts -->
							<tr>
								<td colspan="2" class="Txtcontent" style="">
								<p>Patient
								consent: I the undersigned hereby authorize the National Health
								Insurance Company- Daman, to get all needed medical information
								about my case from the provider upon its request, for the purpose
								of claim review.</p>
								</td>
							</tr>
							<tr>
								<td class="Txtcontent" width="50%">
								<p>Patient signature: </p><img id="canvasimg" style="display:none" width=200 src=""/>
								</td>
								<td class="Txtcontent" width="50%">
								 <p>:ØªÙ?Ù?Ù?Ø¹/Ø¨ØµÙ?Ø© Ø§Ù?Ø¥ØµØ¨Ø¹ Ù?Ù?Ù?Ø±Ù?Ø¶</p><img id="canvasimg" style="display:none" width=200 src=""/>
							</td>
							</tr>
							<tr>
								<td colspan="2" class="Txtcontent" style="">
								<p>
								
				Ø¥Ù?Ø±Ø§Ø± Ø§Ù?Ù?Ø±Ù?Ø¶ Ø£Ù?Ø§ Ø§Ù?Ù?Ù?Ù?Ø¹ Ø£Ø¯Ù?Ø§Ù? Ø£Ø®Ù?Ù? Ø§Ù?Ø´Ø±Ù?Ø© Ø§Ù?Ù?Ø·Ù?Ù?Ø© Ù?Ù?Ø¶Ù?Ø§Ù? Ø§Ù?ØµØ­Ù?- Ø¶Ù?Ø§Ù? Ø§Ù?Ø­ØµÙ?Ù? Ø¹Ù?Ù? Ø¬Ù?Ù?Ø¹ Ø§Ù?Ù?Ø¹Ù?Ù?Ù?Ø§Øª Ø§Ù?Ø·Ø¨Ù?Ø© Ø§Ù?Ù?ØªØ¹Ù?Ù?Ø© Ø¨Ø­Ø§Ù?ØªÙ? Ø§Ù?ØµØ­Ù?Ø© Ù?Ù? Ù?Ø¨Ù? Ù?Ø²Ù?Ø¯ Ø§Ù?Ø±Ø¹Ø§Ù?Ø© Ø§Ù?ØµØ­Ù?Ø© Ø¹Ù?Ø¯ Ø·Ù?Ø¨Ù?Ø§ Ù?Ù?Ø±Ø§Ø¬Ø¹Ø© Ø§Ù?Ù?Ø·Ø§Ù?Ø¨Ø© Ø§Ù?Ø·Ø¨Ù?Ø©.
								</p>
								<p>
								...........ØªÙ?Ù?Ù?Ø¹/Ø¨ØµÙ?Ø© Ø§Ù?Ø¥ØµØ¨Ø¹ Ù?Ù?Ù?Ø±Ù?Ø¶
								</p>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="Txtcontent" style="">
									<p>Authorization review shall not, in any way, impair treatment
								timelines. The patient, provider and concerned medical care
								professionals are liable for all treatment decisions to improve
								the quality of life of the patient.</p>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="Txtcontent" style="">
							<p>
Ù?Ù? Ù?Ù?Ù?Ù? Ø§Ù?Ø§Ø°Ù? Ø¨Ø§Ù?Ù?Ù?Ø§Ù?Ù?Ø© Ø§Ù?Ø·Ø¨Ù?Ø© Ù?Ù? Ø£Ù? ØªØ£Ø«Ù?Ø± Ø¹Ù?Ù? Ø§Ù?Ø¬Ø¯Ù?Ù? Ø§Ù?Ø²Ù?Ù?Ù? Ù?ØªÙ?Ø¯Ù?Ù? Ø§Ù?Ø¹Ù?Ø§Ø¬. Ù?Ø¨Ù?Ù? Ù?Ø²Ù?Ø¯ Ø§Ù?Ø±Ø¹Ø§Ù?Ø© Ø§Ù?ØµØ­Ù?Ø© Ù?Ø§Ù?Ù?ØªØ®ØµÙ?Ù? Ù?Ù? Ù?Ø¬Ø§Ù? Ø§Ù?Ø¹Ù?Ø§Ø¬ Ø§Ù?Ø·Ø¨Ù? Ù?Ø§Ù?Ù?Ø±Ù?Ø¶ Ù?Ù?Ø³Ù? Ù?Ø­Ø¯Ù?Ù? Ø§Ù?Ù?Ø³Ø¤Ù?Ù?Ù?Ù? Ø¹Ù? Ø¬Ù?Ù?Ø¹ Ø§Ù?Ù?Ø±Ø§Ø±Ø§Øª Ø§Ù?Ù?ØªØ¹Ù?Ù?Ø© Ø¨Ø§Ù?Ø¹Ù?Ø§Ø¬ Ù?ØªØ­Ø³Ù?Ù? Ù?Ù?Ø¹Ù?Ø© Ø­Ù?Ø§Ø© Ø§Ù?Ù?Ø±Ù?Ø¶.
							</p>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="Txtcontent" style="">
								<p>This Notification does not guarantee payment. Payment is
								subject to the Patient's eligibility and contract benefits at the
								time of service.</p>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="Txtcontent" style="">
								<p>
Ù?Ø§ Ù?Ø¹ØªØ¨Ø± Ù?Ø°Ø§ Ø§Ù?Ø¥Ø´Ø¹Ø§Ø± Ø¨Ù?Ø«Ø§Ø¨Ø© Ø¶Ù?Ø§Ù?Ø© Ø¨Ø§Ù?Ø¯Ù?Ø¹. Ù?Ø¨Ù?Ù? Ø§Ù?Ø¯Ù?Ø¹ Ù?Ø±ØªØ¨Ø· Ø¨Ø£Ù?Ù?Ù?Ø© Ø§Ù?Ù?Ø±Ù?Ø¶ Ù?Ù?ØªØºØ·Ù?Ø© Ù?Ù?Ù?Ø§Ù?Ø¹ Ø¹Ù?Ø¯ Ø§Ù?ØªØ£Ù?Ù?Ù? Ù?Ù? ØªØ§Ø±Ù?Ø® ØªÙ?Ø¯Ù?Ù? Ø§Ù?Ø®Ø¯Ù?Ø©.</p>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="Txtcontent" style="">
								<%if(icon_swapper){%>
								<p>National Health Insurance Company - Daman (P.O. Box 128888,
									Abu Dhabi, U.A.E. Tel No. +97126149555 Fax No. +97126149550)</p>
								<%}else{%>
								<p>National Health Insurance Company - Daman (P.O. Box 128888,
									Abu Dhabi, U.A.E. Tel No. +9712 41844445 Fax No. +9712 4184333)</p>
								<%}%>
								</td>
							</tr>
						</table><!-- IN070213 ends -->
					</td>
				</tr>
				<tr>
					<td colspan="2"><table width="100%" cellpadding="0"
							cellspacing="0" class="border2">
							<tbody>
								<tr>
								<%if(icon_swapper){%>
									<td class="content-txt">Doc Ctrl No.:</td>
									<td class="content-txt borderleft-thin">FRM/AU.20</td>
									<td class="content-txt borderleft-thin">Version No.:</td>
									<td class="content-txt borderleft-thin">2.0</td>
									<td class="content-txt borderleft-thin">Date of Issue:</td>
									<td class="content-txt borderleft-thin">07.09.2011</td>
									<td class="content-txt borderleft-thin">Page No(s).:</td>
									<td class="content-txt borderleft-thin">1 of 1</td>
								<%}else{%>
									<td class="content-txt">Doc Ctrl No.:</td>
									<td class="content-txt borderleft-thin">FRM/AU.36</td>
									<td class="content-txt borderleft-thin">Version No.:</td>
									<td class="content-txt borderleft-thin">1.0</td>
									<td class="content-txt borderleft-thin">Date of Issue:</td>
									<td class="content-txt borderleft-thin">26.09.2011</td>
									<td class="content-txt borderleft-thin">Page No(s).:</td>
									<td class="content-txt borderleft-thin">1 of 1</td>
								<%}%>
								</tr>
							</tbody>
						</table></td>
				</tr>
				<tr></tr>
				<tr>
					<TD class="label" align="right">
						<!-- <input type="button" name="save" id="save" VALUE='save' onclick="saveData()" > -->
						<button id="sign" onclick="on()">Sign</button>
					</TD>
				</tr>
			</tbody>
		</table>
	<script type="text/javascript">
	var canvas, ctx, flag = false, prevX = 0, currX = 0, prevY = 0, currY = 0, dot_flag = false;
	var x = 0, y = 2;
	function init() {
		canvas = document.getElementById('can');
		ctx = canvas.getContext("2d");
		w = canvas.width;
		h = canvas.height;

		canvas.addEventListener("mousemove", function(e) {
			findxy('move', e)
		}, false);
		canvas.addEventListener("mousedown", function(e) {
			findxy('down', e)
		}, false);
		canvas.addEventListener("mouseup", function(e) {
			findxy('up', e)
		}, false);
		
		// Set up touch events for mobile, etc
		canvas.addEventListener("touchstart", function (e) {
			mousePos = getTouchPos(canvas, e);
		  	var touch = e.touches[0];
		 	var mouseEvent = new MouseEvent("mousedown", {
		    	clientX: touch.clientX,
		    	clientY: touch.clientY
		  	});
		  	canvas.dispatchEvent(mouseEvent);
		}, false);
		canvas.addEventListener("touchend", function (e) {
		  var mouseEvent = new MouseEvent("mouseup", {});
		  canvas.dispatchEvent(mouseEvent);
		}, false);
		canvas.addEventListener("touchmove", function (e) {
		  var touch = e.touches[0];
		  var mouseEvent = new MouseEvent("mousemove", {
		    clientX: touch.clientX,
		    clientY: touch.clientY
		  });
		  canvas.dispatchEvent(mouseEvent);
		}, false);
	}

	function draw() {
		ctx.beginPath();
		ctx.moveTo(prevX, prevY);
		ctx.lineTo(currX, currY);
		ctx.strokeStyle = x;
		ctx.lineWidth = y;
		ctx.stroke();
		ctx.closePath();
	}
	
	function clearSign() {
            ctx.clearRect(0, 0, w, h);
            document.getElementById("canvasimg").style.display = "none";
            var canvas = document.getElementById('can');
        	ctx.fillStyle = 'white';
        	ctx.fillRect(0, 0, canvas.width, canvas.height);
	}
	function findxy(res, e) {
		if (res == 'down') {
			prevX = currX;
			prevY = currY;
			currX = e.clientX - canvas.offsetLeft;
			currY = e.clientY - canvas.offsetTop;

			flag = true;
			dot_flag = true;
			if (dot_flag) {
				ctx.beginPath();
				ctx.fillStyle = x;
				ctx.fillRect(currX, currY, 2, 2);
				ctx.closePath();
				dot_flag = false;
			}
		}
		if (res == 'up') {
			flag = false;
		}
		if (res == 'move') {
			if (flag) {
				prevX = currX;
				prevY = currY;
				currX = e.clientX - canvas.offsetLeft;
				currY = e.clientY - canvas.offsetTop;
				draw();
			}
		}
	}
	
	// Get the position of a touch relative to the canvas
	function getTouchPos(canvasDom, touchEvent) {
	  var rect = canvasDom.getBoundingClientRect();
	  return {
	    x: touchEvent.touches[0].clientX - rect.left,
	    y: touchEvent.touches[0].clientY - rect.top
	  };
	}
		function viewImage(patient_id,encounter_id,p_report_id) {
			 xmlStr = "<root><SEARCH ";
			 xmlStr += " patient_id=\"" +patient_id+ "\"";
			 xmlStr += " encounter_id=\"" +encounter_id+ "\"";
			 xmlStr += " p_report_id=\"" +p_report_id+ "\"";
			 xmlStr += " /></root>";
			 var xmlDoc;
			 var xmlHttp;
			 xmlHttp = new XMLHttpRequest();
			 var oParser = new DOMParser();
			 xmlDoc = oParser.parseFromString(xmlStr,"text/xml");
			 xmlHttp.open("POST", "CATabIntermediateValidate.jsp", false);
			 xmlHttp.send(xmlDoc);
			 responseText = xmlHttp.responseText ;
			 eval(responseText);
	}
	
	function testView(data){
		 	var imageURL = "data:image/jpeg;base64,"+data;
	        document.getElementById("canvasimg").src = imageURL;
			document.getElementById("canvasimg").style.display = "inline"; 
			 document.getElementById("canvasimg").src = imageURL;
	}
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</body>
</html>

