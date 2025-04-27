<!DOCTYPE html>
<!--
---------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
---------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/07/2012    IN033073      Nijitha S     New Vaccines added to the existing category does not appear in CA
08/10/2013    IN035541      Chowminya G   Manage Immunization->System is displaying the Vaccine Category of Age specific 
18/10/2013	  IN037203 		Karthi L	  Manage Immunization -> The system is displaying the  disabled Vaccine Category  by default . 
20/11/2013    IN040377		Chowminya 	  New Immunization report required Patient wise.
27/11/2013    IN000000		Chowminya	  Manage Immunization> sequence of vaccine not as per order_seq_no
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
03/01/2017	IN066125		Dinesh T		03/01/2017		Ramesh G		EM run on window 10 and IE 11
																			Vaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR
---------------------------------------------------------------------------------------------------------------------------------
--> 
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
 <%
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE"); 	
	String client_ip_address=	p.getProperty("client_ip_address")==null?"":(String)p.getProperty("client_ip_address");
	String login_user_id =  p.getProperty("login_user")==null?"":(String)p.getProperty("login_user")  ;
	String facility_id = session.getAttribute("facility_id")==null?"":(String) session.getAttribute("facility_id"); 	
	String scheduled_user_id = session.getAttribute("ca_practitioner_id")==null?"":(String)session.getAttribute("ca_practitioner_id"); 	
	
 %>

		<!-- <modifeid by Arvind @02-12-2008> -->
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCA/js/ScheduleForVacination.js' language='javascript'></script>
	    <script language="javascript" src="../../eCommon/js/dchk.js"></script>
	    <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
	</head>
	<body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll="processScroll()">
	
	<form name="vaccineResult" id="vaccineResult">
<div id="divPatVaccData" style="width: 98vw;position: absolute;">
	<table class='grid' id='patVaccData'  width='100%' >
	<tr  id="heading" > 
		<td class='columnheadercenter'  width='' nowrap>&nbsp;</td>
		<td class='columnheadercenter'  width='' nowrap><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="eCA.ScheduledAge.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="eCA.ActualDate.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="eCA.ActualAge.label" bundle="${ca_labels}"/></td>		
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.BatchNumber.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="Common.SiteName.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/>&nbsp;/&nbsp;<BR><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> <!-- IN040377 -->
		 <!-- <td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>  -->
	</tr> 
  
   <%
	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	String patient_id =""; 
	String vac_sch_ref ="";
	String vacc_categ_desc_prev ="";
	Boolean flag= true;
//	String className="";
	String status="";
	String outcome_code="";
	String vac_sch_ref1="";
	String vaccine_id="";
	String vaccine_desc="";
	String dose_no="";
	String schedule_date="";
	String administered_date="";
	String batch_id="";
	String admin_site_desc="";
	String administered_username="";
	String status_desc="";
	String status_ord="";
	String cbSchedule="";
	String adhoc_yn ="";
	String vacc_categ_id ="";
	String vacc_categ_desc ="";
	String alergry_exists_yn = "N";
	String allergy_img_dis = "";
	String cellBGColor = "";
	String rowColor = "";
	String include_err = "";
	String order_id = "";
	String ord_drug_code = "";
	String vacc_categ_desc1 = "";
	String durgToolTip = "";
	String dob="";
	String encounter_id="";
	String scheduled_age="";
	String actual_age="";
	String mrk_err_status = "";
	String linked_sch_yn = "";
	String link_param_yn = "";
	String ord_drug_dose_no = "";
	
	//String patient_id ="";
	StringBuffer  vaccin_details_query = new StringBuffer (); 
	int k =0;
	vac_sch_ref  =request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
	status_ord  =request.getParameter("status_ord")==null?"":request.getParameter("status_ord");
	cbSchedule  =request.getParameter("cbSchedule")==null?"":request.getParameter("cbSchedule");
	adhoc_yn  =request.getParameter("adhoc_yn")==null?"":request.getParameter("adhoc_yn");
	vacc_categ_id  =request.getParameter("vacc_categ_id")==null?"":request.getParameter("vacc_categ_id");
	dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
	encounter_id=request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	patient_id  =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	include_err  =request.getParameter("include_err")==null?"N":request.getParameter("include_err");


	
	if(vac_sch_ref.equals("ALL")){
	//vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c WHERE c.vaccine_id = a.vaccine_id and a.VAC_SCH_REF = B.VAC_SCH_REF AND b.vacc_categ_id = c.vacc_categ_id and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); //Commentted IN000000
	vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO,c.ORDER_SRL_NO,CA_GET_DESC.CA_IM_VAC_CATEG (b.VACC_CATEG_ID,'en',2)  VACC_CATEG_DESC1 FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c, CA_IM_VACCINE d WHERE c.vaccine_id = a.vaccine_id and d.vaccine_id = c.vaccine_id and d.eff_status = 'E'and a.VAC_SCH_REF = B.VAC_SCH_REF AND b.vacc_categ_id = c.vacc_categ_id and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); //IN000000 modified to display only active vaccines
		//vac_sch_ref="";		
	} else{ //[IN035541]
	/*
		Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
			b.VACC_CATEG_ID , added to query
	*/
	//vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID, A.DOSE_NO, to_char(A.SCHEDULE_DATE,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,to_date(SCHEDULE_DATE,'DD/MM/YYYY HH24:MI'))  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = B.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),to_date(A.ADMINISTERED_DATE,'DD/MM/YYYY')) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,B.LINKED_SCH_YN FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  WHERE A.VAC_SCH_REF = NVL(?, A.VAC_SCH_REF) and a.VAC_SCH_REF = B.VAC_SCH_REF and b.VACC_CATEG_ID =NVL(?,b.VACC_CATEG_ID) and b.PATIENT_ID= ? AND B.LINKED_SCH_YN = 'N' ");
	//DECODE(NVL(A.ORDER_ID,'*'),'*',A.DOSE_NO,A.ord_drug_dose_no) DOSE_NO,
	//vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c WHERE A.VAC_SCH_REF = NVL(?, A.VAC_SCH_REF) and  c.vaccine_id = a.vaccine_id and a.VAC_SCH_REF = B.VAC_SCH_REF and b.VACC_CATEG_ID =NVL(?,b.VACC_CATEG_ID)  and c.vacc_categ_id = NVL (?, c.vacc_categ_id) and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); //IN033073
	//vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c WHERE A.VAC_SCH_REF = NVL(?, A.VAC_SCH_REF) and  c.vaccine_id = a.vaccine_id and a.VAC_SCH_REF = B.VAC_SCH_REF and b.VACC_CATEG_ID =NVL(?,b.VACC_CATEG_ID)  and c.vacc_categ_id = NVL (?, c.vacc_categ_id) AND b.vacc_categ_id = c.vacc_categ_id and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); //[IN035541] // commented for IN037203
	vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO,c.ORDER_SRL_NO,CA_GET_DESC.CA_IM_VAC_CATEG (b.VACC_CATEG_ID,'en',2)  VACC_CATEG_DESC1 FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c, CA_IM_VACCINE d WHERE A.VAC_SCH_REF = NVL(?, A.VAC_SCH_REF) and  c.vaccine_id = a.vaccine_id and d.vaccine_id = c.vaccine_id and a.vaccine_id = d.vaccine_id and d.eff_status = 'E' and a.VAC_SCH_REF = B.VAC_SCH_REF and b.VACC_CATEG_ID =NVL(?,b.VACC_CATEG_ID)  and c.vacc_categ_id = NVL (?, c.vacc_categ_id) AND b.vacc_categ_id = c.vacc_categ_id and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); // modified for IN037203	
	}
	 if (status_ord.equals("DO"))
	{
			vaccin_details_query.append(" and ca_get_schedule_status (b.vacc_categ_id,a.vaccine_id, a.dose_no, a.vac_sch_ref, schedule_date)  in ('D', 'O')");
			status_ord = "";
	}
	else if (!status_ord.equals("")) 
	{
		vaccin_details_query.append(" and ca_get_schedule_status (b.vacc_categ_id,a.vaccine_id, a.dose_no, a.vac_sch_ref, schedule_date)   in (?)");		
	}

	if(!include_err.equals("Y"))
	{
		vaccin_details_query.append(" and A.OUTCOME_CODE !='E' ");
	}


	// if(vac_sch_ref.equals("")&&adhoc_yn.equals("N"))
	 {
		//vaccin_details_query.append(" Order by 1 ,A.SCHEDULE_DATE");//IN000000 commented
		vaccin_details_query.append(" Order by VACC_CATEG_DESC1,ORDER_SRL_NO,A.SCHEDULE_DATE");//IN000000
	 }

	/* else
	 {
		vaccin_details_query.append(" Order by 4 ");
	 }*/

	
	try 
	{
		con = ConnectionManager.getConnection(request);	
		//if(vac_sch_ref.equals(""))//IN033073
		if(vac_sch_ref.equals("") && vac_sch_ref!=null)//IN033073 //IN035541 Changed || to &&
		{
			ScheduleForVaccination scheduleBean = new ScheduleForVaccination();
			Map paramMap = new HashMap();
			paramMap.put("PATIENT_ID",patient_id);
			paramMap.put("VACC_CATEG_ID",vacc_categ_id);
			paramMap.put("DOB",dob);
			paramMap.put("CON_OBJ",con);
			paramMap.put("ENCOUNTER_ID",encounter_id);
			paramMap.put("FACILITY_ID",facility_id);
			paramMap.put("SCHEDULED_USER_ID",scheduled_user_id);
			paramMap.put("LOGIN_USER_ID",login_user_id);
			paramMap.put("CLIENT_IP_ADDRESS",client_ip_address);
			paramMap.put("SCHEDULED_USER_ID",scheduled_user_id);
			paramMap.put("LOCALE",locale);			
			paramMap.put("VAC_SCH_REF",vac_sch_ref);//IN033073
			scheduleBean.createScheduleForVaccination(paramMap);
		}
		pstmt = con.prepareStatement(vaccin_details_query.toString());
		//IN033073 - Added indexing
		int indx = 1; 
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,dob);
		pstmt.setString(indx++,dob);
		if(!vac_sch_ref.equals("ALL")) //IN035541 Condition Added
		{
		pstmt.setString(indx++,vac_sch_ref);
		pstmt.setString(indx++,vacc_categ_id);
		pstmt.setString(indx++,vacc_categ_id);
		}
		pstmt.setString(indx++,patient_id);

		 if(!status_ord.equals(""))
		 {
			pstmt.setString(indx++,status_ord); 
		 }
		//pstmt.setString(5,patient_id);

		rs= pstmt.executeQuery();
		String img = "";
		String showMrkErrPage = "";
		
		while(rs.next())
		{
			img ="";
			flag =false;
		/*	if (k % 2 == 0 )
				   className = "QRYODD";
				else
					className = "QRYEVEN"; //QRYEVEN	*/	
			vacc_categ_desc = rs.getString("VACC_CATEG_DESC")==null?"":rs.getString("VACC_CATEG_DESC");
			vac_sch_ref1 = rs.getString("VAC_SCH_REF")==null?"":rs.getString("VAC_SCH_REF");
			vaccine_id = rs.getString("VACCINE_ID")==null?"":rs.getString("VACCINE_ID");
			vaccine_desc = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
			dose_no = rs.getString("DOSE_NO")==null?"":rs.getString("DOSE_NO");
			schedule_date = rs.getString("SCHEDULE_DATE")==null?"":rs.getString("SCHEDULE_DATE");
			administered_date = rs.getString("ADMINISTERED_DATE")==null?"":rs.getString("ADMINISTERED_DATE");//IN035541
			batch_id = rs.getString("BATCH_ID")==null?"&nbsp;":rs.getString("BATCH_ID");
			admin_site_desc = rs.getString("ADMIN_SITE_DESC")==null?"&nbsp;":rs.getString("ADMIN_SITE_DESC");
			administered_username = rs.getString("Administered_UserName")==null?"&nbsp;":rs.getString("Administered_UserName");
			status = rs.getString("STATUS")==null?"&nbsp;":rs.getString("STATUS");
			outcome_code = rs.getString("OUTCOME_CODE")==null?"":rs.getString("OUTCOME_CODE");
			alergry_exists_yn = rs.getString("Alergry_exists_yn")==null?"N":rs.getString("Alergry_exists_yn");		
			order_id = rs.getString("ORDER_ID")==null?"":rs.getString("ORDER_ID");
			ord_drug_code = rs.getString("ORD_DRUG_CODE")==null?"":rs.getString("ORD_DRUG_CODE");
			durgToolTip = rs.getString("DRUG_DESC")==null?"":rs.getString("DRUG_DESC");
			scheduled_age = rs.getString("SCHEDULED_AGE")==null?"":rs.getString("SCHEDULED_AGE");
			mrk_err_status = rs.getString("MRK_ERR_STATUS")==null?"":rs.getString("MRK_ERR_STATUS");
			actual_age = rs.getString("ACTUAL_AGE")==null?"":rs.getString("ACTUAL_AGE");
			linked_sch_yn = rs.getString("LINKED_SCH_YN")==null?"":rs.getString("LINKED_SCH_YN");
			link_param_yn = rs.getString("LINK_PARAM_YN")==null?"":rs.getString("LINK_PARAM_YN");
			ord_drug_dose_no = rs.getString("ord_drug_dose_no")==null?"":rs.getString("ord_drug_dose_no");
			actual_age = actual_age.equals("D")?"":actual_age;
			//out.println("status   -->"+status+"  "+vac_sch_ref1+"~"+vaccine_id+"~"+dose_no+"<--");
			
			/*
				Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
			*/
			vacc_categ_id = rs.getString("VACC_CATEG_ID")==null?"":rs.getString("VACC_CATEG_ID");

			/* ends here. */
			
			if (alergry_exists_yn.equals("Y")){
				allergy_img_dis = "display:visible";
			}else{
				allergy_img_dis = "display:none";	
			}						

		
			if(status.equals("C"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");

				//cellBGColor = "background-color:#99CCFF";
				img = "Completed.gif";
			}
			else if(status.equals("E") )
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
				//cellBGColor = "background-color: #FF8000";
				img = "notadministered.gif";
			}
			else if(status.equals("D") )
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Due.label","common_labels");
				//cellBGColor = "background-color:#99FFCC";
				img = "Due.gif";
			}
			else if(status.equals("L"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Elapsed.label","common_labels");
				//cellBGColor = "background-color:#99CC00";
				img = "Elapsed.gif";
			}
			else if(status.equals("N"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotAdministered.label","common_labels");
				//cellBGColor = "";
				img = "In-Error.gif";
			}
			else if(status.equals("F"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Future.label","common_labels");
				//cellBGColor = "";
				img = "Future.gif";
			}
			else if(status.equals("O"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Overdue.label","common_labels");
				//cellBGColor = "";
				img = "OverDue.gif";
			}
			else
			{
				status_desc="";
				cellBGColor="";
				rowColor = "";
			}
			//out.println("status   --->"+status+"<-----    img  ------>"+img+"<-----");
			//out.println("vac_sch_ref.."+vac_sch_ref+"....adhoc_yn..."+adhoc_yn+"...cbSchedule..."+cbSchedule);
			
			//if(vac_sch_ref.equals("")&&adhoc_yn.equals("N")&&cbSchedule.equals("Y"))//IN066125
			if(vac_sch_ref.equals("ALL")&&adhoc_yn.equals("N")&&cbSchedule.equals("Y"))//IN066125
			{			
				if(vacc_categ_desc.indexOf("(") == 2)
				{
					vacc_categ_desc1 = "AdministeredRXVaccines";
				}else {
					vacc_categ_desc1 = vacc_categ_desc;
				}
				if(vacc_categ_desc.indexOf("(") == 2 && !vacc_categ_desc1.equals(vacc_categ_desc_prev))
				{ %>
					<tr><td class='CAGROUP' colspan='9'><fmt:message key="eCA.AdministeredRxVaccines.label" bundle="${ca_labels}"/> </td></tr>
					
	<%			}
				else if(!vacc_categ_desc1.equals(vacc_categ_desc_prev))
				{						
					out.println("<tr><td class='CAGROUP' colspan='9'>"+vacc_categ_desc+"</td></tr>");
				}	
			}
			
			if(mrk_err_status.equals("E"))
			{
				showMrkErrPage = "<img src='../../eCA/images/notadministered.gif' onclick=' loadMarkErrPage(\""+vac_sch_ref1+"\",\""+vaccine_id+"\",\""+dose_no+"\",\""+vaccine_desc+"\");' style='cursor:pointer;'>";
			}
			else
			{
				showMrkErrPage = "";
			}
			%>
			
			<tr><td class='gridData' width='' nowrap><img src='../../eCA/images/<%=img%>'>&nbsp;<%=showMrkErrPage%>
			<%if(link_param_yn.equals("Y")){%>
				<img src='../../eCA/images/link.gif'  name='btnLink"+k+"' title='Linked vaccine Schedule' onclick='fnLinkVaccineCategory("<%=vac_sch_ref1%>","<%=vaccine_id%>","<%=dose_no%>","<%=vacc_categ_id%>","<%=order_id%>","<%=ord_drug_code%>","<%=vaccine_desc%>","<%=linked_sch_yn%>")' style='cursor:pointer;'>
				<!-- <input type='button' name='btnLink"+k+"' id='btnLink"+k+"' value='L' title='Linked vaccine Schedule' onclick='fnLinkVaccineCategory("<%=vac_sch_ref1%>","<%=vaccine_id%>","<%=dose_no%>","<%=vacc_categ_id%>","<%=order_id%>","<%=ord_drug_code%>","<%=vaccine_desc%>","<%=linked_sch_yn%>")'> -->
			<%}%>
			</td>
			<td class='gridData' width='' title='<%=durgToolTip%>' nowrap>
			<a class='gridLink'  href='javascript:loadAllergyPage("<%=vac_sch_ref1%>","<%=vaccine_id%>","<%=administered_date%>","<%=dose_no%>","<%=adhoc_yn%>","<%=vaccine_desc%>");'><img src='../../eCommon/images/PI_Allergies.gif' BORDER='0' style="<%=allergy_img_dis%>"></a> <a class='gridLink'  href='javascript:loadAdminPage("<%=vac_sch_ref1%>","<%=vaccine_id%>","<%=dose_no%>","<%=adhoc_yn%>","<%=status%>","<%=vacc_categ_id%>","<%=alergry_exists_yn%>","<%=vaccine_desc%>","<%=order_id%>","<%=ord_drug_code%>","<%=schedule_date%>","<%=administered_date%>","<%=ord_drug_dose_no%>");'><%=vaccine_desc%></a></td>

			<!-- Two Date Convesion added by Archana Dhal on 12/8/2010 related to incident no IN025377. -->				
				<td class='gridData' nowrap><%=com.ehis.util.DateUtils.convertDate(schedule_date,"DMY","en",locale)%></td>
				<td class='gridData' nowrap><%=scheduled_age%></td>
				<td class='gridData' nowrap><%=com.ehis.util.DateUtils.convertDate(administered_date,"DMYHM","en",locale)%></td>
				<td class='gridData' nowrap><%=actual_age%></td>				
				<td class='gridData' nowrap><%=batch_id%></td>
				<td class='gridData' nowrap><%=admin_site_desc%></td>
				<td class='gridData' nowrap><%=administered_username%></td>
				<!-- IN040377 Start -->
				<td class='gridData' nowrap><input type=checkbox name='chk<%=k%>' id='chk<%=k%>'  value="N" onClick='clickLine(this)' </td>
				<!-- <td class='gridData' nowrap><%=status_desc%>&nbsp;&nbsp;<%=showMrkErrPage%></td> --></tr> 
				<input type='hidden' name='vaccine_id<%=k%>' id='vaccine_id<%=k%>' value="<%=vaccine_id%>">
				<input type='hidden' name='vac_sch_ref<%=k%>' id='vac_sch_ref<%=k%>' value="<%=vac_sch_ref1%>">
				<input type='hidden' name='dose_no<%=k%>' id='dose_no<%=k%>' value="<%=dose_no%>">
				<!-- IN040377 end -->
	<%			
			k++;			
			vacc_categ_desc_prev =vacc_categ_desc1;			
		}
		%>
			
		<!--
		/* Modified by Kishore Kumar N on Spet 09-09*/
		
		
		<tr style="visibility:hidden" > 
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.ActualDate.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.BatchNumber.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.SiteName.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
		<!-- <td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> -->
		<!-- </tr>
		
			ends here.
		-->
		
			
		<%

			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
	
	
	}
	catch(Exception e)
	{
		
		%>
		<!-- 
		
		/* Modified by Kishore Kumar N on Spet 09-09*/
		<tr style="visibility:hidden" > 
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.ActualDate.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.BatchNumber.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.SiteName.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
		<!-- <td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> -->
		<!-- </tr>
		
		ends here.
		-->
		
		<%
		
		
		e.printStackTrace();
	}
	finally
	{
	 if(con!=null)ConnectionManager.returnConnection(con,request);
	}

	if(flag)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.getElementById('patVaccData').style.display='none'</script>");
		
	}

	%>
   </table>
   </div>
   <input type='hidden' value='<%=request.getQueryString()%>' name='query_string' id='query_string'>
   <input type='hidden' value='<%=patient_id%>' name='patient_id' id='patient_id'>
   <input type='hidden' value='<%=encounter_id%>' name='encounter_id' id='encounter_id'>
   <!-- IN040377 start -->
   <input type=hidden 	value='<%=k%>' name='total_recs' id='total_recs'> 
   <input type='hidden' value='<%=facility_id%>' name='facility_id' id='facility_id'>
   <!-- IN040377 end -->
   </form>
<script>
		
			<% /*if(!flag){*/%>
			/*if(parent.VaccineResTitle.document.getElementById("patVaccTitle") == null) 
			{				
				setTimeout("alignHeading1();",300);
			}
			else 
			{	
				
				alignHeading1();
				
			}*/
			<%/*//}*/%>
			
	</script>

   </body>

</html>

