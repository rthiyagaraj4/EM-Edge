<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="java.util.*,java.lang.*, ePH.Common.*, ePH.*,eCommon.Common.*,eCommon.XSSRequestWrapper " %>
<html>
	<head>
<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
				request= new XSSRequestWrapper(request); 
				response.addHeader("X-XSS-Protection", "1; mode=block"); 
				response.addHeader("X-Content-Type-Options", "nosniff"); 
				//Added by Himanshu for MMS-ME-SCF-0097 ends
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<title><fmt:message key="ePH.MedicationAlerts.label" bundle="${ph_labels}"/></title>
	</head>
<%
	String  patient_id="",external_product_id="",drug_db_interact_check_flag="",drug_db_duptherapy_flag="",drug_db_contraind_check_flag="";
	patient_id						=   request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	external_product_id				=	request.getParameter("external_product_id");
	drug_db_interact_check_flag		=	request.getParameter("drug_db_interact_check_flag")==null?"": request.getParameter("drug_db_interact_check_flag");
	drug_db_duptherapy_flag			=	request.getParameter("drug_db_duptherapy_flag")==null?"": request.getParameter("drug_db_duptherapy_flag");
	drug_db_contraind_check_flag	=	request.getParameter("drug_db_contraind_check_flag")==null?"": request.getParameter("drug_db_contraind_check_flag");
	String drug_db_dosecheck_flag   =   request.getParameter("drug_db_dosecheck_flag")==null?"": request.getParameter("drug_db_dosecheck_flag");
	String drug_db_allergy_flag   =   request.getParameter("drug_db_allergy_flag")==null?"": request.getParameter("drug_db_allergy_flag");

	String srl_no					=   request.getParameter("srl_no")==null?"": request.getParameter("srl_no");
	String dosage_reason			=	request.getParameter("dsg_reason")==null?"": request.getParameter("dsg_reason");
	String duplicate_reason			=	request.getParameter("dup_reason")==null?"": request.getParameter("dup_reason");
	String conotra_reason			=	request.getParameter("con_reason")==null?"": request.getParameter("con_reason");
	String interaction_reason		=	request.getParameter("int_reason")==null?"": request.getParameter("int_reason");
	String alergy_reason			=	request.getParameter("alg_reason")==null?"": request.getParameter("alg_reason");
	String pract_name				=	request.getParameter("pract_name")==null?"": request.getParameter("pract_name");

	String dosage_interface			=	request.getParameter("dosage_interface")==null?"": request.getParameter("dosage_interface");

   // Added in JUNE 2012 - New changes 
	String ex_bean_id				= "@ExternalProductLinkBean";
	String ex_bean_name				= "ePH.ExternalProductLinkBean";
	//String dosage_flag  = "N";
	ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
	if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS
 %>
		<iframe name='FrameMedicationDisplayDetails' id='FrameMedicationDisplayDetails'				src="../../ePH/jsp/MedicationAlerts_MIMS.jsp?patient_id=<%=patient_id%>&external_product_id=<%=external_product_id%>&srl_no=<%=srl_no%>&drug_db_interact_check_flag=<%=drug_db_interact_check_flag%>&drug_db_duptherapy_flag=<%=drug_db_duptherapy_flag%>&drug_db_contraind_check_flag=<%=drug_db_contraind_check_flag%>&drug_db_dosecheck_flag=<%=drug_db_dosecheck_flag%>&dosage_reason=<%=java.net.URLEncoder.encode(dosage_reason,"UTF-8")%>&duplicate_reason=<%=java.net.URLEncoder.encode(duplicate_reason,"UTF-8")%>&conotra_reason=<%=java.net.URLEncoder.encode(conotra_reason,"UTF-8")%>&interaction_reason=<%=java.net.URLEncoder.encode(interaction_reason,"UTF-8")%>&alergy_reason=<%=java.net.URLEncoder.encode(alergy_reason,"UTF-8")%>&pract_name=<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>&drug_db_allergy_flag=<%=drug_db_allergy_flag%>" frameborder=0 scrolling='auto' style='height:65vh;width:100vw'></iframe><iframe name='FrameMedicationAlertDetails' id='FrameMedicationAlertDetails'				src="../../ePH/jsp/MedicationAlertDetails.jsp?patient_id=<%=patient_id%>&external_product_id=<%=external_product_id%>&srl_no=<%=srl_no%>&drug_db_interact_check_flag=<%=drug_db_interact_check_flag%>&drug_db_duptherapy_flag=<%=drug_db_duptherapy_flag%>&drug_db_contraind_check_flag=<%=drug_db_contraind_check_flag%>&drug_db_dosecheck_flag=<%=drug_db_dosecheck_flag%>&dosage_reason=<%=java.net.URLEncoder.encode(dosage_reason,"UTF-8")%>&duplicate_reason=<%=java.net.URLEncoder.encode(duplicate_reason,"UTF-8")%>&conotra_reason=<%=java.net.URLEncoder.encode(conotra_reason,"UTF-8")%>&interaction_reason=<%=java.net.URLEncoder.encode(interaction_reason,"UTF-8")%>&alergy_reason=<%=java.net.URLEncoder.encode(alergy_reason,"UTF-8")%>&pract_name=<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>&drug_db_allergy_flag=<%=drug_db_allergy_flag%>&dosage_interface=<%=dosage_interface%>" frameborder=0 scrolling='auto' style='height:30vh;width:100vw'></iframe><iframe name='FrameMedicationAlertButtons' id='FrameMedicationAlertButtons'				src="../../ePH/jsp/MedicationAlertButtons.jsp" frameborder=0 scrolling='no' style='height:5vh;width:100vw'></iframe> 
<%
	}
	else {  // For FDB or other 
%>	    

			<iframe name='FrameMedicationAlertDetails' id='FrameMedicationAlertDetails'				src="../../ePH/jsp/MedicationAlertDetails.jsp?patient_id=<%=patient_id%>&external_product_id=<%=external_product_id%>&srl_no=<%=srl_no%>&drug_db_interact_check_flag=<%=drug_db_interact_check_flag%>&drug_db_duptherapy_flag=<%=drug_db_duptherapy_flag%>&drug_db_contraind_check_flag=<%=drug_db_contraind_check_flag%>&drug_db_dosecheck_flag=<%=drug_db_dosecheck_flag%>&dosage_reason=<%=java.net.URLEncoder.encode(dosage_reason,"UTF-8")%>&duplicate_reason=<%=java.net.URLEncoder.encode(duplicate_reason,"UTF-8")%>&conotra_reason=<%=java.net.URLEncoder.encode(conotra_reason,"UTF-8")%>&interaction_reason=<%=java.net.URLEncoder.encode(interaction_reason,"UTF-8")%>&alergy_reason=<%=java.net.URLEncoder.encode(alergy_reason,"UTF-8")%>&pract_name=<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>&drug_db_allergy_flag=<%=drug_db_allergy_flag%>" frameborder=0 scrolling='auto' style='height:95vh;width:100vw'> </iframe>
			<!--	<frame name='FrameMedicationAlertDetails' id='FrameMedicationAlertDetails'				src="../../ePH/jsp/MedicationAlertDetails.jsp?patient_id=<%=patient_id%>&external_product_id=<%=external_product_id%>&srl_no=<%=srl_no%>&drug_db_interact_check_flag=<%=drug_db_interact_check_flag%>&drug_db_duptherapy_flag=<%=drug_db_duptherapy_flag%>&drug_db_contraind_check_flag=<%=drug_db_contraind_check_flag%>&drug_db_dosecheck_flag=<%=drug_db_dosecheck_flag%>&dosage_reason=<%=dosage_reason%>&duplicate_reason=<%=duplicate_reason%>&conotra_reason=<%=conotra_reason%>&interaction_reason=<%=interaction_reason%>&alergy_reason=<%=alergy_reason%>&pract_name=<%=pract_name%>&drug_db_allergy_flag=<%=drug_db_allergy_flag%>" frameborder=0 scrolling='auto'> -->
			<iframe name='FrameMedicationAlertButtons' id='FrameMedicationAlertButtons'	src="../../ePH/jsp/MedicationAlertButtons.jsp" frameborder=0 scrolling='no'style='height:5vh;width:100vw'></iframe>

<%
		} // Added in JUNE 2012 - New changes 
		putObjectInBean(ex_bean_id,beanex,request); 
%>
</html>  

