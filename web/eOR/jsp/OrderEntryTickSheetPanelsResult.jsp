<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        			R.Date		R.Name				Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
01/12/2013	IN038787		Ramesh G			Bru-HIMS-CRF-358
13/03/2014	IN047581		Chowminya	Reduce space between Tick Sheet Section and Order Catalog
24/03/2014	IN047583		Nijitha S	SKR-SCF-0948
17/07/2018	IN064543		Kamalakannan		 17/07/2018		Ramesh G		ML-MMOH-CRF-0776
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
27/05/2019	IN069027	Ramesh G								MMS-DM-CRF-0150
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
-----------------------------------------------------------------------
*/ 
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="CommonBean" class="eCommon.Common.CommonBean" scope="page" />
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="eOR.OrderEntryTickSheetItems.label" bundle="${or_labels}"/></title>
		<%
			String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
		<script language="javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="javascript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="javascript" src="../../eOR/js/OrderEntryToolTip.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload = ''>
		<form name="tickSheetItemsForm" id="tickSheetItemsForm" method="POST" action="OrderEntryTickSheetPanelsResult.jsp">
		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String bean_id 		= request.getParameter("bean_id");
			String bean_name 	= request.getParameter("bean_name");
			CommonBean.setLanguageId(localeName);
			String  order_dispaly_verticalYN			= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");  //IN038787
			/* Mandatory checks end */

			/* Initialize Function specific start */
				//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
				OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
				bean.setLanguageId(localeName);
				Boolean is_ss_order_catlg_fac_wise = bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
				String ss_order_catlg_fac_wise_yn =  is_ss_order_catlg_fac_wise?"Y":"N";//IN068370,IN068373
				eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
			// If it is a new patient set it, other wise get the patient id
			//orderEntryRecordBean.getPatient(bean.getPatientId());
			/* Initialize Function specific end */
			
			String order_type 			= bean.checkForNull(request.getParameter("order_type"),"");
			String activity_type 		= bean.checkForNull(request.getParameter("activity_type"),"");
			String order_category 		= bean.checkForNull(request.getParameter("order_category"),"");
			String tick_sheet_id 		= bean.checkForNull(request.getParameter("tick_sheet_id"),"");
			String section_code 		= bean.checkForNull(request.getParameter("section_code"),"");
			String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
			String order_catalog_nature	= bean.checkForNull(request.getParameter("order_catalog_nature"),"");
			String priv_applicability_yn 		= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
			
			String prev_group_title		= "";
			String checkedAttribute 	= "";
			String disabled				= "";
			String care_set_order		= "";
			String order_catalog_category = "";
			String entryValue			= "";	
			int display_records = 44;
			
			String key					= (bean.getPatientId()+bean.getEncounterId());
			if(!order_type.equals(""))	order_type = order_type.trim();
			if(!order_category.equals(""))	order_category = order_category.trim();
			if(!tick_sheet_id.equals(""))	tick_sheet_id = tick_sheet_id.trim();
			if(!section_code.equals(""))	section_code = section_code.trim();
			int i=0;int count = 0; // counters for loop
			
			String amend_key			= "";
			HashMap previousValues		= null;
			HashMap amendPreviousValues = null;
			Set setValues 				= null;
			Iterator iterator			= null;
			//ArrayList Panels			= null;
			StringTokenizer stBillMsg	= null;
			//String bill_warn_message	= null;
			//String bill_warn_err_message= null;
			//String bill_error_message	= null;
			String measure_id			= "" , contr_msr_panel_id = "";
			String category				= "";
			String group_title="";
			String p_pract_type = ""; //IN064543
			
			String order_nature = request.getParameter("order_nature");
			String from_obj = null;
			if("S".equals(order_nature)){
				from_obj = "resultHdrFrame";
			}else if("P".equals(order_nature)){
				from_obj = "resultListFrame";
			}else if("A".equals(order_nature)){
				from_obj = "resultDtlFrame";
			}
			
			String sqlQuery				= "";
			String str					= "";
			String orderSetVal = "";
			String panelVal = "";
			String individualVal  = "";
			String frm1 = "" , frm2 = "" , frm3 = "";
			ArrayList records			= null;
			Boolean isfppapplicable = bean.getIsfppapplicable();//IN068314
			String fpp_patient_yn = bean.getFpp_patient_yn();//IN068314
			//sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text  FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";//IN042045//commented for IN064543
	 		//IN068370,IN068373 Start.
			//sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id,NVL(b.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(b.instrn_content_type,'T')instrn_content_type, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";//IN064543";
	 		//sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id,NVL(b.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(b.instrn_content_type,'T')instrn_content_type, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code ##GLOBALANDLOCAL## and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";//IN064543";IN068314
	 		//Ramesh Start.
			//sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id,NVL(b.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(b.instrn_content_type,'T')instrn_content_type, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code ##GLOBALANDLOCAL## and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ##FILTERFPP## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";
	 		
			sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id,NVL(b.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(b.instrn_content_type,'T')instrn_content_type, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code ##GLOBALANDLOCAL## and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND  (1= ( CASE WHEN GENDER IS NULL THEN 1 WHEN GENDER = ? THEN 1 ELSE 0 END ))  AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ##FILTERFPP## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";
			//Ramesh End.
			//IN068370,IN068373 End.
	 		
	 		if(priv_applicability_yn.equalsIgnoreCase("Y")){				
				sqlQuery = sqlQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
				sqlQuery = sqlQuery.replace("##FILTERPRIV##"," OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");				
			}else if(priv_applicability_yn.equalsIgnoreCase("N")){
				sqlQuery = sqlQuery.replace("##FILTERCAT##","");
				sqlQuery = sqlQuery.replace("##FILTERPRIV##","  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");				
			}else{
				sqlQuery = sqlQuery.replace("##FILTERCAT##","");
				sqlQuery = sqlQuery.replace("##FILTERPRIV##"," 'Y' priv_yn, ");
			}
	 		//IN068370,IN068373 Start.
			if("Y".equals(ss_order_catlg_fac_wise_yn)){
				sqlQuery = sqlQuery.replace("##GLOBALANDLOCAL##"," AND  EXISTS (SELECT 1 FROM OR_ORDER_CATALOG_BY_FACILITY e WHERE e.ORDER_CATALOG_CODE=b.ORDER_CATALOG_CODE AND e.APPLICABLE_FACILITY_ID = ?) ");
			}else{
				sqlQuery = sqlQuery.replace("##GLOBALANDLOCAL##"," ");				
			}
			//IN068370,IN068373 End.
			
			if(isfppapplicable){
			if("Y".equals(fpp_patient_yn)){
				//sqlQuery = sqlQuery.replace("##FILTERFPP##","");
				sqlQuery = sqlQuery.replace("##FILTERFPP##"," AND b.FPP_YN = 'Y' ");
			}
			else{
				sqlQuery = sqlQuery.replace("##FILTERFPP##"," AND (b.FPP_YN IS NULL OR b.FPP_YN = 'N') ");
			}
			}
			else{
				sqlQuery = sqlQuery.replace("##FILTERFPP##","");
			}
			try
			{
				//Common parameters.
				HashMap sqlMap = new HashMap();
					//Include all the common parameters.
				sqlMap.put( "sqlData",sqlQuery);
				
				//Function Parameters
				HashMap funcMap = new HashMap();
					//Display Fields
				
				ArrayList displayFields = new ArrayList();
					displayFields.add( "order_catalog_code" );
					displayFields.add( "catalog_synonym" );
					displayFields.add( "order_catalog_nature" );
					displayFields.add( "discr_msr_panel_id" );  //3
					displayFields.add( "prompt_alert_yn" );
					displayFields.add( "prompt_alert_msg" );
					displayFields.add( "order_category" );
					displayFields.add( "order_type_code" );
					displayFields.add( "ord_auth_reqd_yn" );//8
					displayFields.add( "contr_msr_panel_id" );
					displayFields.add( "ord_spl_appr_reqd_yn" );//10
					displayFields.add( "priv_yn" ); //11
					displayFields.add( "explanatory_text");//12
					displayFields.add( "invoke_instrn_window_yn");//13//IN064543
					displayFields.add( "INSTRN_CONTENT_TYPE");//14//IN064543
				//Where condition put in order
				ArrayList chkFields = new ArrayList();

				chkFields.add( bean.getPractitionerType() );
				chkFields.add( bean.getLanguageId() );
				chkFields.add( bean.getLoginFacilityId() );
				chkFields.add( bean.getLocationType() );

				chkFields.add( bean.getLocationCode() );
				
				if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N"))){
					chkFields.add( bean.getPractitionerId() );
					chkFields.add( bean.getResponsibilityId() );
					chkFields.add( bean.getAuthorisationOrOrderingYn("ORD") );						
				}
				
				chkFields.add( bean.checkForNull(tick_sheet_id.trim(),"") );
				chkFields.add( bean.checkForNull(section_code,"") );
				//IN068370,IN068373 Start.
				if("Y".equals(ss_order_catlg_fac_wise_yn))
					chkFields.add( bean.getLoginFacilityId());					
				//IN068370,IN068373 End.
				chkFields.add( bean.getPatientClass() );
				chkFields.add( bean.getPatientClass() );
				chkFields.add( bean.checkForNull(bean.getSex(),"") );
				chkFields.add( bean.checkForNull(bean.getDob(),"") );
				chkFields.add( bean.getLoginFacilityId() );
				chkFields.add( bean.checkForNull(bean.getEncounterId(),"") );
				chkFields.add( bean.getPatientClass() );
				chkFields.add( bean.getVisitAdmDate() );
				chkFields.add( bean.checkForNull(bean.getDischargeDateTime(),"") );
				chkFields.add( bean.getPractitionerType() );

				if((bean.checkForNull(order_category.trim(),"")).equals("*A")){
					//chkFields.add(null);//IN047583
					chkFields.add("");//IN047583					
				}else{
					chkFields.add( bean.checkForNull(order_category.trim(),""));					
				}
				chkFields.add( bean.checkForNull(activity_type,"") );
				chkFields.add( bean.checkForNull(order_type,"") );
				if(priv_applicability_yn.equalsIgnoreCase("Y")){
					chkFields.add( bean.getPractitionerId() );
					chkFields.add( bean.getResponsibilityId() );
					chkFields.add( bean.getPrivilegeApplicability() );					
				}
				// Adding function related array list into the HashMap
				funcMap.put( "displayFields", displayFields );
				funcMap.put( "chkFields", chkFields );
				//Calling the Result from Common Adapter as an arraylist.
				ArrayList TickSheetItems=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,display_records);
				%>
				
				<%
				// IN047581 Start.
				//if((TickSheetItems.size()>=3) && ( !( ((String) TickSheetItems.get(0)).equals("0")))){
				if((TickSheetItems.size()>=3) && ( !( ((String) TickSheetItems.get(0)).equals("0")) ) && (!(((String)TickSheetItems.get(1)).equals("")))){
				// IN047581 End.
				%>
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
						<tr>				
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
							<%
								// To display the previous/next link
								out.println(TickSheetItems.get(1));
							%>
							</td>
						</tr>
					</table>
				<%
				}
				%>
				
					
				<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
					<tr>
				
					<%		
						// Since at the maximum there will be 100 or 150 records no need for next/previous
						//ArrayList TickSheetItems = bean.getTickSheetItems(order_category,tick_sheet_id,section_code,order_type, activity_type,priv_applicability_yn,l_order_nature);
						records	 =new ArrayList();
						//for(i=0; i<TickSheetItems.size(); i++)
						for(int recCount=2; recCount<TickSheetItems.size(); recCount++)
						{
							checkedAttribute = "";disabled= "";
							//records = (String[])TickSheetItems.get(recCount);
							records=(ArrayList) TickSheetItems.get( recCount );
							
							if(((String)records.get(2)).equalsIgnoreCase("P"))
							{	
								group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Panel.label","common_labels");
								panelVal = "P";
							}else if(((String)records.get(2)).equalsIgnoreCase("S"))
							{
								group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSet.label","or_labels");
								orderSetVal = "S";
							}
							else if(((String)records.get(2)).equalsIgnoreCase("A"))
							{
									group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Individual.label","common_labels");
									individualVal  = "A";
							}
							if(!prev_group_title.equals(((String)records.get(2))))
							{
								//IN038787 Start.
								/*if( count%4 > 0)
								{
									 for (int u=0;u<4-count%4;u++)
										out.println("<td width=\"20%\"  colspan=\"3\"  align=\"left\">&nbsp;&nbsp;</td>" );
									out.println("</tr>");
								}
								count =0 ;
								out.println("<tr>");
								*/
								if("N".equals(order_dispaly_verticalYN)){
									out.println("<td colspan=\"12\" align=\"center\" class=\"CAGROUP\">"+group_title+" </td>");
									out.println("</tr><tr>");	
								}else if("Y".equals(order_dispaly_verticalYN)){									
									out.println("<td colspan=\"4\" align=\"center\" class=\"CAGROUP\">"+group_title+" </td>");
									out.println("</tr><tr>");
									out.println("<TD width='25%' valign='top'>");
									out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");	
								}
								//IN038787 End.
							}
			
							if(((String)records.get(2)).equals("P") || ((String)records.get(2)).equals("S"))
							{
								contr_msr_panel_id 	= (String)records.get(9);
								category     		= (String)records.get(6);
								if(((String)records.get(2)).equals("P")) // Pass the discrete_measure_id & contr_msr_panel_id
								{
									measure_id 		= (String)records.get(3); // discrete_measure_id
								}
								else if(((String)records.get(2)).equals("S")) // Pass the catalog_code
								{
									measure_id 		= (String)records.get(0); // Catalog Code
								}
							} // End of If
			
							if(!((String)records.get(2)).equals("") && (((String)records.get(2)).equalsIgnoreCase("P")) || ((String)records.get(2)).equalsIgnoreCase("S"))
							{
								//IN038787 Start.
								if("Y".equals(order_dispaly_verticalYN)){
								%>
								<TR>
								<%
								} //IN038787 End.
							%>
								<td class="LABEL" align="RIGHT" width="20%" onClick='parent.displayToolTip(escape("<%=measure_id%>"),escape("<%=contr_msr_panel_id%>"),"<%=(String)records.get(2)%>","<%=category%>","<%=bean_id%>","<%=bean_name%>","<%=(String)records.get(0)%>","<%=i%>","tickSheetItemsForm","","<%=from_obj%>")' onMouseOver='showToolTip("<%=(String)records.get(0)%>","tickSheetItemsForm")' onMouseOut="hideToolTip()"> <font size=1 color="BLUE">
								<a class='gridLink' href='javascript:;'><%=(String)records.get(1)%></a>	
							<%
							}
							else
							{     
								//IN038787 Start.
								if("Y".equals(order_dispaly_verticalYN)){
								%>
								<TR>
								<%
								} //IN038787 End.
							%>
									<td class="LABEL" align="left" width="20%" onMouseOver='showToolTip("<%=(String)records.get(0)%>","tickSheetItemsForm")' onMouseOut="hideToolTip()"><font size=1><%=(String)records.get(1)%>
							<%
							}  
							%>				
							<input type="hidden" name="catalog_desc<%=(String)records.get(0)%><%=i%>" id="catalog_desc<%=(String)records.get(0)%><%=i%>" value="<%=(String)records.get(1)%>">
							</font></td>						
							<%
							previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
							if(previousValues!=null)
							{
								setValues 	 = previousValues.keySet();
								iterator 	 = setValues.iterator();
								
								for(int prev_count=0;prev_count<previousValues.size();prev_count++)
								{
									entryValue = ((String)iterator.next()) ;
									if(!care_set_order.equalsIgnoreCase("Y")) // For the First Time, it will be "N"
									{
										// For the Care Sets, to set the Order Category, there will be only one record for Care Sets at a time
										care_set_order = (String)previousValues.get(entryValue) ;
										if(care_set_order.equalsIgnoreCase("CS")) // Only if it is CS
										{
											//Added By Jyothi to fix IN020673 on 14/04/2010
											bean.setTempValues("OrderSetChecked","1");
											care_set_order = "Y";
										}
									}
									// For the checkboxes
									if(entryValue.equalsIgnoreCase("ck"+(String)records.get(0)))
									{
										checkedAttribute	= "CHECKED";
										break;
									}
									else
									   checkedAttribute 	= "";
								} // End of For
							}
							// For Amend of Review Order
							if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
							{
								amend_key			= (bean.getPatientId()+bean.getEncounterId()+bean.getOrderId());  // Unique key (For Existing Orders) to keep the Value in the Bean
								amendPreviousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
								if(amendPreviousValues!=null)
								{
									setValues 	 = amendPreviousValues.keySet();
									iterator 	 = setValues.iterator();
									for(int prev_count=0;prev_count<amendPreviousValues.size();prev_count++)
									{
										entryValue = ((String)iterator.next()) ;
										if(entryValue.equalsIgnoreCase("ck"+(String)records.get(0)))
										{
											checkedAttribute = "CHECKED";
											disabled		 = "DISABLED";
											break;
										}
									}
								}
							}
							if(((String)records.get(2)).equals("S")) // For Care Sets
							{
							   order_catalog_category 	= "CS";
							   order_category	  		= "CS";
							}
							else
							   order_catalog_category 	= ((String)records.get(6));
							/*Added by Uma on 8/22/2009 for PMG20089-CRF 641*/
							if((records.get(11))!=null && (((String)records.get(11)).equalsIgnoreCase("Y"))) // To enable or disable the checkbox depending upon the privilege applicability of the Ordering Practitioner
								disabled		 = "";
							else
								disabled		 = "disabled";
							/*End Here*/

							// Billing Informations Retrieved
							/*if(((String)records.get(12))!=null)
							{
								stBillMsg	= new StringTokenizer(((String)records.get(12)),"|");
								while(stBillMsg.hasMoreTokens())
								{
									  bill_warn_message		= stBillMsg.nextToken();
									  bill_warn_err_message	= stBillMsg.nextToken();
									  bill_error_message	= stBillMsg.nextToken();
									  if(bill_warn_message.equals("*")) bill_warn_message 	= "";
									  if(bill_warn_err_message.equals("*")) bill_warn_err_message = "";
									  if(bill_error_message.equals("*")) bill_error_message 	= "";
								}
							}*/
							//String prompt_msg = bean.checkForNull((String)records.get(6),"");
							//prompt_msg = java.net.URLEncoder.encode(prompt_msg);
							%>
							<td class="LABEL" align="center" width="5%" >
								<%-- <input type="checkbox"  name="ck<%=(String)records.get(0)%>" id="ck<%=(String)records.get(0)%>" value="Y" onClick='parent.setCheckBoxVal(this,escape("<%=(String)records.get(4)%>"),escape("<%=(String)records.get(0)%>"),"tickSheetItemsForm", "<%=order_catalog_category%>", "<%=from_obj%>");' <%=checkedAttribute%> <%=disabled%>> commented for IN064543--%>
								<!-- IN064543 start -->
								<!--IN069027 checkDiagnosis method added-->
								<input type="checkbox" name="ck<%=(String)records.get(0)%>" id="ck<%=(String)records.get(0)%>" value="Y" onClick='checkDiagnosis("<%=(String)records.get(6)%>",this);parent.setCheckBoxVal(this,escape("<%=(String)records.get(4)%>"),escape("<%=(String)records.get(0)%>"),"tickSheetItemsForm", "<%=order_catalog_category%>", "<%=from_obj%>");<%
								if(order_nature.equalsIgnoreCase("A")&& ((String)records.get(13)).equals("Y"))
								{ 
								%>showEditor(this,"<%=(String)records.get(0)%>","<%=order_nature%>","<%=order_catalog_category%>","<%=bean_id%>","<%=bean_name%>","<%=measure_id%>","<%=(String)records.get(14)%>","<%=(String)records.get(1)%>");<%
								}else if(order_nature.equalsIgnoreCase("S")||order_nature.equalsIgnoreCase("P")){
								%>displayToolTipForInstructions(this,escape("<%=measure_id%>"),escape("<%=contr_msr_panel_id%>"),"<%=order_nature%>","<%=order_catalog_category%>","<%=bean_id%>","<%=bean_name%>","<%=(String)records.get(0)%>","<%=i%>","tickSheetItemsForm","<%=p_pract_type%>");<%
								}%>' <%=checkedAttribute%> <%=disabled%> >
								<!-- IN064543 end --> 
								<input type="hidden" name="h1<%=(String)records.get(0)%>" id="h1<%=(String)records.get(0)%>" value="<%=order_catalog_category%>">
								<input type="hidden" name="h2<%=(String)records.get(0)%>" id="h2<%=(String)records.get(0)%>" value="<%=(String)records.get(7)%>">
								<input type="hidden" name="prompt_desc<%=(String)records.get(0)%>" id="prompt_desc<%=(String)records.get(0)%>" value="<%=bean.checkForNull((String)records.get(5),"")%>"> <%-- Display the Message, kept with the catalog_code--%>
								<input type="hidden" name="explanatory_text<%=(String)records.get(0)%>" id="explanatory_text<%=(String)records.get(0)%>" value="<%=bean.checkForNull((String)records.get(12),"") %>"> <%-- explanatory_text--%>
							</td>
							<td class="LABEL" align="left" width="3%" nowrap>
								<%				
								if(((String)records.get(8)).equalsIgnoreCase("Y")) // For Authorization Required
								{
								%>					
									&nbsp;<img id='authorization"+i+"' src="../../eOR/images/Authorization.gif" align="center" title="Authorization"></img>
								<%
								}
								%>
								<% 
								if(((String)records.get(10)).equalsIgnoreCase("Y")) // For Special Approval Required
								{
								%>					
									<img id='special_approval"+i+"' src="../../eOR/images/SpecialApproval.gif" align="center" title="Special Approval"></img>
								<%				
								}	
								%>
							&nbsp;</td>
							<%
							//IN038787 Start.
							if("Y".equals(order_dispaly_verticalYN)){%>
							</TR><TR>
							<%}
							//IN038787 End.
							%>
							<%
								i++;
								//IN038787 Start.
								//count++;
								//if( count % 4 == 0)							
								if("N".equals(order_dispaly_verticalYN)){
								//IN038787 End.
									if( i % 4 == 0)
									  out.println("</tr><tr>");
								//IN038787 Start.
								}else if("Y".equals(order_dispaly_verticalYN)){
									if(i==11||i==22||i==33){						
										out.println("</TABLE>");
										out.println("</TD>");
										out.println("<TD width='25%' valign='top'>");
										out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");						
									}else if(i==44){
										out.println("</TABLE>");
										out.println("</TD>");
										out.println("</TR>");
									}
								}
								//IN038787 End.
								prev_group_title = (String)records.get(2);
						} // End of for
						//IN038787 Start.
						/*if( count % 4 > 0)
						{
							for (int u=0;u<4-count%4;u++)
								out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
								out.println("</tr>");
						}*/
						if("N".equals(order_dispaly_verticalYN)){  
							if( i % 4 > 0)
							{
								for (int u=0;u<4-i%4;u++)
									out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
								out.println("</tr>");
							}
							
						}else if("Y".equals(order_dispaly_verticalYN)){
							if( i % 11 > 0)
							{
								for (int u=0;u<10-i%11;u++)
									out.println("<tr><td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td></tr>");
								out.println("</TABLE>");
								out.println("</TD>");
								if(i<11){
									out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
									out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
									out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
								}
								out.println("</TR>");
							}
						}
						//IN038787 End.
						
						if(TickSheetItems.size()==0)
						{
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script> ");
						}

						// Nullifying the objects
						previousValues		= null;			amendPreviousValues = null;
						stBillMsg			= null;
						setValues			= null;			iterator			= null;
						TickSheetItems		= null;			records				= null;
						%>


				</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
				<input type="hidden" name="check_box_val" id="check_box_val" value="N">
				<input type="hidden" name="care_set_check_box_val" id="care_set_check_box_val" value="<%=care_set_order%>">
				<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
				<input type="hidden" name="encounter_id" id="encounter_id" value="<%=bean.getEncounterId()%>">
				<input type="hidden" name="patient_class" id="patient_class" value="<%=bean.getPatientClass()%>">
				<input type="hidden" name="admission_date" id="admission_date" value="<%=bean.getVisitAdmDate()%>">
				<input type="hidden" name="discharge_date_time" id="discharge_date_time" value="<%=bean.getDischargeDateTime()%>">
				<input type="hidden" name="priv_applicability_yn" id="priv_applicability_yn" value="<%=priv_applicability_yn%>">
				<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
				<input type="hidden" name="tick_sheet_id" id="tick_sheet_id" value="<%=tick_sheet_id%>">
				<input type="hidden" name="section_code" id="section_code" value="<%=section_code%>">
				<input type="hidden" name="order_catalog_nature" id="order_catalog_nature" value="<%=order_catalog_nature%>">
				<input type="hidden" name="order_nature" id="order_nature" value="<%=order_nature%>">
				<input type="hidden" name="order_dispaly_verticalYN" id="order_dispaly_verticalYN" value="<%=order_dispaly_verticalYN%>"> <!--  IN038787 -->
				<%=CommonBean.setFormTransaction(request)%>
				<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
					<table id='tooltiptable' cellpadding=3 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
						<tr>
							<td width='100%' id='t'></td>
						</tr>
					</table>
				</div>
		</form>
		<%
				// No need to set, no setting it back in the back set it back persistence
				putObjectInBean(bean_id,bean,request);
			}catch(Exception e) {
				  //out.print("Exception @ Result JSP :"+e.toString());//common-icn-0181
		                    e.printStackTrace();//COMMON-ICN-0181
			}
		%>
		<!-- IN038787 Start.  -->
			<% 	
				Integer pageVist = (Integer) session.getAttribute("pageVist")==null?0: (Integer)session.getAttribute("pageVist");
				int cnt = pageVist.intValue()+1;				
				if(!orderSetVal.equals(""))
				{
					session.setAttribute("orderSetVal", orderSetVal);					
				}

				if(!panelVal.equals(""))
				{
					session.setAttribute("panelVal", panelVal);					
				}

				if(!individualVal.equals(""))
				{
					session.setAttribute("individualVal", individualVal);					
				}			
				session.setAttribute("pageVist", new Integer(cnt));
				frm1 =(String) session.getAttribute("orderSetVal")==null?"": (String)session.getAttribute("orderSetVal");
				frm2 = (String)session.getAttribute("panelVal")==null?"": (String)session.getAttribute("panelVal");
				frm3 = (String)session.getAttribute("individualVal")==null?"": (String)session.getAttribute("individualVal");
				
				if(cnt == 3)
				{	
				%>
					<script>						
						checkFrameMembersTickSheet('<%=frm1%>', '<%=frm2%>', '<%=frm3%>');
					</script>
				<%
				}
				else if(!order_catalog_nature.equals(""))
				{
				%>
					<script>
						checkFrameMembersTickSheet('<%=frm1%>', '<%=frm2%>', '<%=frm3%>');
					</script>
				<%
				}
				%>

			<!-- IN038787 End Here -->
	</body>
</html>

