<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
04/13/2017      KDAH-CRF-0338     Devindra/Mukesh    Inclusion of Bed No in the Fill and Deliver screen in Dispense Medication.
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String patient_id	= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_name = request.getParameter("patient_name");
	String sex			= request.getParameter("sex");
	String age			= request.getParameter("age");
	String nursing_unit	= request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
	String bed_num      = request.getParameter("bed_num")==null?"":request.getParameter("bed_num"); // Added for KDAH-CRF-0338
	String Order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");//Added for JD-CRF-0181[IN:45511]
	String locn_code      = request.getParameter("locn_code")==null?"":request.getParameter("locn_code"); // Added for BSP-SCF-0060
	String patient_class      = request.getParameter("patient_class")==null?"":request.getParameter("patient_class"); 
	//  added by Himanshu against MM-DM-CRF-0232 .... use only under getorders method in \DispMedicationBean.java in IAE scenario
	String Disp_locn_code_Spcl_case      = request.getParameter("Disp_locn_code_Spcl_case")==null?"":request.getParameter("Disp_locn_code_Spcl_case"); 
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	String height1="";
	String height2="";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.setTemp_patient_classl(patient_class);
	bean.setDisp_locn_codeall(Disp_locn_code_Spcl_case);
	

	String disp_locn_catg	= bean.getDispLocnCatg();
	if(disp_locn_catg.equals("I")) {
		bean.setSelectedNursingUnit(bean.getNursingUnitCode(nursing_unit));
	}
	bean.setLocnCode(locn_code); // Added for BSP-SCF-0060
	String	chk_group_by_patient	=   bean.getChkGroupByPatient();
	String rows = "";
	if(chk_group_by_patient==null) chk_group_by_patient="E";
	if(chk_group_by_patient.equals(""))chk_group_by_patient="E";

	if(bean.getCriteriaOrderType() != null && ( bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
		//rows = "10%,80%";
		height1="10vh";
		height2="75vh";
	
	}
	else if(chk_group_by_patient.equals("E")){
		//rows = "50%,50%";
		height1="45vh";
		height2="45vh";
	}
	else{
		//rows = "0%,100%";
		height1="0vh";
		height2="90vh";
	}
%>
	<%-- <frameset rows="<%=rows%>" id ="PatientOrderFrames"> --%>
		<iframe name="patient_details" id="patient_details" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/DispMedicationPatientDetails.jsp?patient_id=<%=patient_id%>&patient_name=<%=patient_name%>&encounter_id=<%=encounter_id%>&sex=<%=sex%>&age=<%=age%>&bed_num=<%=bed_num%>" style="height:<%=height1%>;width:100vw;"></iframe>  <!-- bed_num Added for KDAH-CRF-0338 -->
		<iframe name="order_details" id="order_details" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationOrderDetails.jsp?patient_id=<%=patient_id%>&order_id=<%=Order_id%>&encounter_id=<%=encounter_id%>" style="height:<%=height2%>;width:100vw;"></iframe> <!-- Added for JD-CRF-0181[IN045511] -->		 <!-- encounter_id added for NMC-JD-SCF-0251 -->
	<!-- </frameset> -->
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

