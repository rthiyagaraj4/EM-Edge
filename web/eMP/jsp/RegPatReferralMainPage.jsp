<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*, webbeans.eCommon.*,java.util.*,javax.servlet.http.*,javax.servlet.jsp.JspWriter " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>	
		<!-- 	 -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eMP/js/RegPatReferral.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	request.setCharacterEncoding("UTF-8");
	String patientid		=(request.getParameter("patientid") == null)?"":request.getParameter("patientid");
	String calling_from		= request.getParameter("calling_from");
	if (calling_from==null) calling_from="";	
	String p_calling_function		= (request.getParameter("p_calling_function") == null)?"":request.getParameter("p_calling_function");
	
	String p_to_locn_type		= (request.getParameter("p_to_locn_type") == null)?"":request.getParameter("p_to_locn_type");
	String ass_func_id=(request.getParameter("ass_func_id") == null)?"":request.getParameter("ass_func_id");
	String mode = (request.getParameter("mode") == null)?"":request.getParameter("mode");	
	String speciality_code	= request.getParameter("speciality_code");
	if (speciality_code==null) speciality_code="";
	String service_code	= request.getParameter("service_code");
	if (service_code==null) service_code="";
	String practitioner	= request.getParameter("practitioner");
	if (practitioner==null) practitioner="";
	String practitioner_name	= request.getParameter("practitioner_name");
	if (practitioner_name==null) 	practitioner_name="";
	String referral_id	= request.getParameter("referral_id");
	if (referral_id==null) referral_id="";
	

	String res_class=(request.getParameter("res_class") == null)?"":request.getParameter("res_class");
		
	String p_to_locn_code=(request.getParameter("p_to_locn_code") == null)?"":request.getParameter("p_to_locn_code");
	
	String ca_patient_id=(request.getParameter("ca_patient_id") == null)?"":request.getParameter("ca_patient_id");

	//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
	String p_service_desc=(request.getParameter("p_service_desc") == null)?"":request.getParameter("p_service_desc");
	String p_service_code=(request.getParameter("p_service_code") == null)?"":request.getParameter("p_service_code");
	//END
	%>
	<iframe name='main_comp' id='main_comp'    src='../../eMP/jsp/RegPatReferralMainPage_NatID.jsp?calling_from=<%=calling_from%>&p_calling_function=<%=p_calling_function%>&mode=<%=mode%>&referral_id=<%=referral_id%>&speciality_code=<%=speciality_code%>&service_code=<%=service_code%>&practitioner=<%=practitioner%>&practitioner_name=<%=practitioner_name%>&res_class=<%=res_class%>&pat_ID=<%=patientid%>&ass_func_id=<%=ass_func_id%>&ca_patient_id=<%=ca_patient_id%>' frameborder=0 scrolling='auto' noresize tabindex=-1 style='height:60vh;width:100vw'></iframe>
	<iframe name='tab_comp' id='tab_comp'   src='../../eMP/jsp/RegPatReferralMainPage1_new.jsp?calling_from=<%=calling_from%>&p_calling_function=<%=p_calling_function%>&p_to_locn_type=<%=p_to_locn_type%>&mode=<%=mode%>&referral_id=<%=referral_id%>&speciality_code=<%=speciality_code%>&service_code=<%=service_code%>&practitioner=<%=practitioner%>&practitioner_name=<%=practitioner_name%>&res_class=<%=res_class%>&pat_ID=<%=patientid%>&ass_func_id=<%=ass_func_id%>&p_to_locn_type=<%=p_to_locn_type%>&p_to_locn_code=<%=p_to_locn_code%>&p_service_desc=<%=p_service_desc%>&p_service_code=<%=p_service_code%>&ca_patient_id=<%=ca_patient_id%>' frameborder=0 scrolling='auto' noresize tabindex=-1 style='height:40vh;width:100vw'></iframe>
</html>

