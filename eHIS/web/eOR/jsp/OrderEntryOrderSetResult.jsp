<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
--------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        			R.Date		R.Name				Description
----------------------------------------------------------------------------------------------------------------------------
?             	100            		?           		?			?					created
24/10/2011    	IN029071      	Chowminya G      	    ?           ?                   Incident No: IN029071 -  <CRF - new rules for Discharge advice> 
25/09/2012		IN030279		Ramesh G		        ?           ?                  Bru-HIMS-CRF-160
21/11/2012		IN036347		Ramesh G				?			?				Managed Deceased/Body Part->When cannot place Laboratory and Dietary Orders->We get script error when we click on Place Order
13/08/2013	    IN042045		Chowminya G	       		?			?				System should not allow to copy for the drugs for which Verbal Order Applicable is not selected	
01/12/2013		IN038787		Ramesh G				?			?				Bru-HIMS-CRF-358
30/11/2016	  	IN062319	   Karthi L					?			?				ML-MMOH-CRF-0508.1 [IN062319]
17/07/2018		IN064543		Kamalakannan		 17/07/2018		Ramesh G		ML-MMOH-CRF-0776		
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
27/05/2019		IN069027	Ramesh G											MMS-DM-CRF-0150
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
20/12/2022	39892	Ramesh Goli						ML-MMOH-SCF-2255
-----------------------------------------------------------------------------------------------------------------------------
-->
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
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		</link>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntryTab.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style> <!-- violated to show the cursor as wait -->
		A:active {
			COLOR: blue;
			CURSOR : wait;
		}
	</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="orderSetResultForm" id="orderSetResultForm" method="POST" action="OrderEntryOrderSetResult.jsp">
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String bean_id 		 		= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
	String  order_dispaly_verticalYN			= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");  //Ramesh
	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	CommonBean.setLanguageId(localeName);
	OrderEntryBean  bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new pa tient set it, other wise get the patient id
	// orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	// boolean searched			= request.getParameter( "searched" ) == null?false : true  ;
	String order_category		= bean.checkForNull(request.getParameter("order_category"),"");
	// String p_order_category		= order_category; //Used for Care Sets
	String order_type			= bean.checkForNull(request.getParameter("order_type"),"");
	String activity_type		= bean.checkForNull(request.getParameter("activity_type"),"");
	String order_nature	= bean.checkForNull(request.getParameter("order_nature"),"");
	String order_catalog_nature	= bean.checkForNull(request.getParameter("order_catalog_nature"),"");
	String orderable_text		= bean.checkForNull(request.getParameter("orderable_text"),"");
	String criteria				= bean.checkForNull(request.getParameter("criteria"),"");
	String restrict_by			= bean.checkForNull(request.getParameter("restrict_by"),"");
	String priv_applicability_yn			= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
	
	ArrayList recArrayList = new ArrayList();
	if(request.getQueryString()!=null)
	{
		bean.setPrivApplicability(priv_applicability_yn);
	}
	priv_applicability_yn = bean.getPrivApplicability();
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	int group_frame_count		= Integer.parseInt(bean.checkForNull(request.getParameter("group_frame_count"),"0"));
	int atomic_frame_count		= Integer.parseInt(bean.checkForNull(request.getParameter("atomic_frame_count"),"0"));
	int profile_frame_count		= Integer.parseInt(bean.checkForNull(request.getParameter("profile_frame_count"),"0"));
	String prev_group_title 	= "";
	String group_title			= "";
	String str					= "";
	String sqlQuery				= "";

	String checkedAttribute		= "";
	String disabled				= "";
	String amend_key			= "";
	String order_catalog_category= "";
	String care_set_order		= "N";
	care_set_order=bean.checkForNull(request.getParameter("care_set_check_box_val"),"");
	String ph_install_yn		= "N";
	//int display_records			= OrRepository.DISPLAY_MIN_RECORDS;// 12 records as set in repository
	//int display_records			= Integer.parseInt(bean.checkForNull(request.getParameter("display_records"),"0"));
	//if((atomic_frame_count==0 && order_nature.equals("A")) || (profile_frame_count==0 && order_nature.equals("P")))
	int 	display_records			= OrRepository.DISPLAY_MAX_RECORDS;// 52 records as set in repository
 	String key					= (bean.getPatientId()+bean.getEncounterId());
	HashMap previousValues		= null;
	//String called_from="OH";
	//String called_from="";
	//ML-MMOH-CRF-0508.1 [IN062319] - Start
	String ord_formt_multi_chk_nonmandate_yn = bean.getMultiSelectListItemMandatYN();// ML-MMOH-CRF-0508.1 [IN062319] 
	if("Y".equals(ord_formt_multi_chk_nonmandate_yn)){
		bean.clearMultiListCompMnemonicMap();
		bean.clearMultiListCompMnemonicMapClone();
		bean.clearMultiCheckCompMnemonicList();
		bean.clearCompleteMultiCheckCompList();
		bean.clearDupeMultiCompMnemonicMapClone();
		bean.clearValidateAllMnemonicList();
		bean.clearValidateMnemonicList();
		bean.clearValidateMnemonicMap();
	}
	// ML-MMOH-CRF-0508.1 [IN062319] - End
	HashMap amendPreviousValues	= null;
	
	StringTokenizer stBillMsg	= null;
	String bill_warn_message	= null;
	String bill_warn_err_message= null;
	String bill_error_message	= null;
	String measure_id			= "", contr_msr_panel_id = ""; 
	String category				= "";
	String entryValue 			= null;
	String frm1 = "" , frm2 = "" , frm3 = "";


	ArrayList records			= null;

	Set setValues 				= null;
	Iterator iterator 	 		= null;
	String orderset_records_count = "";
	String orderSetVal = "";
	String panelVal = "";
	String individualVal  = "";
	String  panel_count			   ="";
	String individual_count	   ="";
	String p_pract_type = "";
	String l_synonym_type = ""; 
	//--[IN029071] - modified - Start
	String pat_id = bean.getPatientId(); 
	String enc_id = bean.getEncounterId();
	String discharge_adv_date_time = "";
	discharge_adv_date_time = bean.getDischargeAdvDateTime(pat_id,enc_id); 
	bean.setSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	Boolean is_ss_order_catlg_fac_wise = bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	Boolean isfppapplicable = bean.getIsfppapplicable();//IN068314
	String fpp_patient_yn = bean.getFpp_patient_yn();//IN068314
	String ss_order_catlg_fac_wise_yn =  is_ss_order_catlg_fac_wise?"Y":"N";//IN068370,IN068373
	//int rec = 0;
	
	//restrict_by=N
	if(discharge_adv_date_time == "" || discharge_adv_date_time==null){
	//sqlQuery 			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CATALOG_ORDER_TYPE_ALL");
	
	//IN030279,IN036347 Start
	//sqlQuery 			= "SELECT  a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
	//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
	//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";//IN042045 commented for IN064543 
	//IN068370,IN068373 Start.
	//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL## AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543//IN068314
	//ML-MMOH-SCF-2255 Start.
	//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL## AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ##FILTERFPP##  ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543//IN068314
	sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL## AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND (1= ( CASE WHEN GENDER IS NULL THEN 1 WHEN GENDER = ? THEN 1 ELSE 0 END )) AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ##FILTERFPP##  ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543//IN068314
	//ML-MMOH-SCF-2255 End.
	//IN068370,IN068373 end.
	//IN030279,IN036347 End.
	}
	else{
	//IN030279,IN036347 Start
		//sqlQuery 			= "SELECT  a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
		//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
		//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";//IN042045 commented for IN064543 
		//IN068370,IN068373 start.
		//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type,a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL##  AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543//IN068314
		//ML-MMOH-SCF-2255 Start.
		//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type,a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL##  AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ##FILTERFPP## ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543
		sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type,a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL##  AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND (1= ( CASE WHEN GENDER IS NULL THEN 1 WHEN GENDER = ? THEN 1 ELSE 0 END )) AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ##FILTERFPP## ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543
		//ML-MMOH-SCF-2255 End.
	
	//IN068370,IN068373 end.
	//IN030279,IN036347 End.
	}
	//IN030279 Start
	String p_resp_id = (String)bean.getResponsibilityId() ==null? "" :(String)bean.getResponsibilityId();
	String  medico_legal_yn =	bean.checkForNull(request.getParameter("medico_legal_yn"),"");
	String  callingFrom =	bean.checkForNull(request.getParameter("callingFrom"),"");
	
	String[] deceasRecord  = bean.getDeceasedPatientYn((String)bean.getPatientId());
	if("MO".equalsIgnoreCase(p_resp_id)){
		sqlQuery = sqlQuery.replace("##MODECEASEDCON1##","'"+p_resp_id+"'");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON2##","'"+callingFrom+"'");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON3##","'"+medico_legal_yn+"'");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON4##","'Y'");
	}else{
		sqlQuery = sqlQuery.replace("##MODECEASEDCON1##","null");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON2##","null");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON3##","null");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON4##","'"+(String)deceasRecord[0]+"'");
	}	
	//IN030279 End.
	
	//--[IN029071] - modified - End
	if(restrict_by.equalsIgnoreCase("N"))
	{
			sqlQuery = sqlQuery.replace("##CATCODE##","");
	}
	else 
	{
		ph_install_yn				= bean.getModuleInstallYn("PH"); //Pass the module_id to found out whether the module has been installed or not
		if(ph_install_yn.equalsIgnoreCase("Y")) // 'PH' module has been installed
		{
				sqlQuery = sqlQuery.replace("##CATCODE##"," AND a.order_catalog_code IN (SELECT drug_code  code FROM ph_generic_name_for_service a,ph_drug b WHERE a.generic_id = b.generic_id AND a.eff_status ='E' AND service_code = ? UNION SELECT order_catalog_code  code FROM or_order_catalog_by_index WHERE service_code = ?  )");
		}
		else
		{
				sqlQuery = sqlQuery.replace("##CATCODE##"," AND a.order_catalog_code IN (SELECT order_catalog_code  code FROM or_order_catalog_by_index WHERE service_code = ?)");
		} // If 'PH' module has not been installed
	} // End of else restrict_by 'Y'
	if(priv_applicability_yn.equalsIgnoreCase("Y"))
	{
		
		sqlQuery = sqlQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
		sqlQuery = sqlQuery.replace("##FILTERPRIV##"," , OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn");
		
	}
	else if(priv_applicability_yn.equalsIgnoreCase("N"))
	{
		sqlQuery = sqlQuery.replace("##FILTERCAT##","");
		sqlQuery = sqlQuery.replace("##FILTERPRIV##",",  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn");
	}
	else
	{
		sqlQuery = sqlQuery.replace("##FILTERCAT##","");
		sqlQuery = sqlQuery.replace("##FILTERPRIV##",", 'Y' priv_yn");
	}
	//IN068370,IN068373, starts
	if("Y".equals(ss_order_catlg_fac_wise_yn)){
		sqlQuery = sqlQuery.replace("##GLOBALANDLOCAL##"," AND  EXISTS (SELECT 1 FROM OR_ORDER_CATALOG_BY_FACILITY f WHERE f.ORDER_CATALOG_CODE=a.ORDER_CATALOG_CODE AND f.APPLICABLE_FACILITY_ID ='"+bean.getLoginFacilityId()+"')"); 
	}else{
		sqlQuery = sqlQuery.replace("##GLOBALANDLOCAL##","");		
	}
	//IN068370,IN068373, end.
	int i						= 0;
	if(isfppapplicable){
	if("Y".equals(fpp_patient_yn)){
		//sqlQuery = sqlQuery.replace("##FILTERFPP##","");
		sqlQuery = sqlQuery.replace("##FILTERFPP##"," AND a.FPP_YN = 'Y' ");
	}
	else{
		sqlQuery = sqlQuery.replace("##FILTERFPP##"," AND (a.FPP_YN IS NULL OR a.FPP_YN = 'N') ");
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

		displayFields.add( "Group_Name" );
		displayFields.add( "order_catalog_code" );
		displayFields.add( "catalog_synonym" );
		displayFields.add( "discr_msr_panel_id" );  //3
		displayFields.add( "order_category" );
		displayFields.add( "order_type_code" );
		displayFields.add( "prompt_alert_yn" );
		displayFields.add( "prompt_alert_msg" );
		displayFields.add( "ord_auth_reqd_yn" );//8
		displayFields.add( "contr_msr_panel_id" );
		displayFields.add( "ord_spl_appr_reqd_yn" );//10
		displayFields.add( "bill_message" ); //11
		displayFields.add( "enable_yn");//12
		displayFields.add( "explanatory_text");//13
		displayFields.add( "priv_yn");//13
		displayFields.add( "invoke_instrn_window_yn");//14//IN064543
		displayFields.add( "INSTRN_CONTENT_TYPE");//15//IN064543
		//Where condition put in order
		ArrayList chkFields = new ArrayList();
		//chkFields.add( bean.getPractitionerType() );
		//chkFields.add(localeName);
		chkFields.add( bean.getLoginFacilityId() );
		chkFields.add( bean.getPatientId() );
		chkFields.add( bean.getEncounterId() );
		chkFields.add( bean.getPatientClass() );

		chkFields.add( bean.getEpisodeID() );			// Episode_id
		chkFields.add( bean.getEpisodeVisitNum() );		// visit_num
		/*Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
		if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N")))
		{
			chkFields.add(bean.getPractitionerId());		//P_PRACTITIONER_ID
			chkFields.add(bean.getResponsibilityId());		//P_RESP_ID
			chkFields.add(bean.getPrivilegeApplicability());		//P_PRIV_APPL_YN
			
		}
		/*End here*/
		chkFields.add(localeName);//Added by Uma on 4/13/2010 for performance tuning
		chkFields.add(localeName);//Added by Uma on 4/13/2010 for performance tuning
		//chkFields.add( bean.getPractitionerType() );
		/*Added by Uma for performance tuning*/
		p_pract_type = (String)bean.getPractitionerType();
		if ((p_pract_type.equalsIgnoreCase("AN"))||(p_pract_type.equalsIgnoreCase("PS"))||(p_pract_type.equalsIgnoreCase("DN"))||(p_pract_type.equalsIgnoreCase("MD"))||(p_pract_type.equalsIgnoreCase ("SG"))||(p_pract_type.equalsIgnoreCase("NS"))) 
		{
			l_synonym_type = "DC" ;
		}
		else if((p_pract_type.equalsIgnoreCase("RD"))||(p_pract_type.equalsIgnoreCase("PT"))) 
		{
  			 l_synonym_type = "AD" ;
		}
		chkFields.add( l_synonym_type );
		/*Ends Here for performance tuning*/
		chkFields.add( bean.getPractitionerType() );
		chkFields.add( bean.getOrderCategoryValue() );	
		chkFields.add( order_nature );
		chkFields.add( criteria);
		chkFields.add( "%"+orderable_text+"%");
		chkFields.add( orderable_text+"%");
		chkFields.add( "%"+orderable_text);
		chkFields.add( criteria);
		chkFields.add( "%"+orderable_text+"%");
		chkFields.add( orderable_text+"%");
		chkFields.add( "%"+orderable_text);
		//chkFields.add( bean.getPatientClass() );
		//chkFields.add( bean.getPatientId() );
		//chkFields.add( bean.getSex() );					 // Sex
		//chkFields.add( bean.getVisitAdmDate() );		 //DATE_OF_BIRTH Commented this 1/8/2009 for considering the age group while placing the order by uma
		//chkFields.add( bean.getDob() );		 //DATE_OF_BIRTH 
		//chkFields.add( bean.getPatientClass() );
		chkFields.add( bean.getPatientClass() );
		chkFields.add( bean.getPatientClass() );
		chkFields.add( bean.getSex() );
		chkFields.add( bean.getDob() );

		chkFields.add( bean.getLoginFacilityId() );
		chkFields.add( bean.getEncounterId() );
		chkFields.add( bean.getPatientClass() );
		chkFields.add( bean.getVisitAdmDate() );		//ADMISSION_DATE
		chkFields.add( bean.getDischargeDateTime() );	//DISCHARGE_DATE_TIME
		if(discharge_adv_date_time != "" && discharge_adv_date_time!=null) //--[IN029071] - Start
		{
		chkFields.add( discharge_adv_date_time ); // DISCHARGE_ADVICE_DATE_TIME 
		} //--[IN029071] - End
		chkFields.add( bean.getPractitionerType() ); //IN042045
		chkFields.add( bean.getOrderCategoryValue() ); //Passing order category again
		chkFields.add( bean.getLoginFacilityId());
		chkFields.add( bean.getServiceCode());
		chkFields.add( bean.getPractitionerId());
		chkFields.add( bean.getLocationType());
		chkFields.add( bean.getLocationCode());
		//chkFields.add( bean.getLoginFacilityId());Commented by Uma for performance tuning
		chkFields.add( order_type.trim());
		chkFields.add( activity_type.trim());
		
		/*Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
		if(priv_applicability_yn.equalsIgnoreCase("Y"))
		{
			chkFields.add(bean.getPractitionerId());		//P_PRACTITIONER_ID
			chkFields.add(bean.getResponsibilityId());		//P_RESP_ID
			chkFields.add(bean.getPrivilegeApplicability());		//P_PRIV_APPL_YN
			
		}	
		if(restrict_by.equalsIgnoreCase("Y"))
		{
			if(ph_install_yn.equalsIgnoreCase("Y"))			// If PH has been installed
			{
				chkFields.add( bean.getServiceCode() );
			}
			chkFields.add( bean.getServiceCode() );
		}		
		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		//Calling the Result from Common Adapter as an arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,display_records);
		// ArrayList result=(ArrayList)CommonBean.getQueryResultPage(sqlMap, funcMap, request,false,false);
		recArrayList.add(result.size());
		
		if((result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<!-- <td width="10%" class="white"></td>  -->
				<!-- <td class='label'></td> -->
				<td width="80%" class="white">&nbsp;</td>
                <td width="20%" class="white">&nbsp;

<%
				// To display the previous/next link
					out.println(result.get(1));
%>
				</td>
			</tr>
			</table>
		<% //IN038787 Start.
			if("N".equals(order_dispaly_verticalYN)){
		%>	
			<table border="0" cellpadding="0" cellspacing="0" width="100%"  align="center">
			<tr>
		<%
			}
			//IN038787 End.
		%>
<%
				//Retrieving the records from result arraylist
				records=new ArrayList();
				
				for(int recCount=2; recCount<result.size(); recCount++) 
				{
					checkedAttribute = "";disabled= "";
					records=(ArrayList) result.get( recCount );
					
					str = bean.checkForNull( (String)records.get(0) );
					group_title = str;
					if(group_title.equalsIgnoreCase("P"))
					{						
						group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Panel.label","common_labels");
						 panel_count=(String)result.get(0);					 
						panelVal = "P";					 
					}else if(group_title.equalsIgnoreCase("S"))
					{						
						group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSet.label","or_labels");	
						orderset_records_count = (String)result.get(0);	
						orderSetVal = "S";						
					}
					else if(group_title.equalsIgnoreCase("A"))
					{						
						group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Individual.label","common_labels");	
						individual_count=(String)result.get(0);	
						individualVal  = "A";						 
					}
					if(!prev_group_title.equals(group_title))
					{	
						if("N".equals(order_dispaly_verticalYN)){  //IN038787
							if(order_nature.equals("P") || order_nature.equals("S"))
								out.println("<td colspan=\"5\" align=\"right\" class=\"CAGROUP\" >"+group_title+"</td><td colspan=\"7\" align=\"right\" class=\"CAGROUP\">("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ClickonCatalogtoViewIndividualDetails.label","or_labels")+") </td>");	   
							else
								out.println("<td colspan=\"12\" align=\"center\" class=\"CAGROUP\" >"+group_title+" </td>");
							out.println("</tr><tr>");						
							//IN038787 Start.
						}else if("Y".equals(order_dispaly_verticalYN)){
							out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");
							out.println("<tr>");					
							if(order_nature.equals("P") || order_nature.equals("S"))											
								out.println("<td colspan=\"1\" align=\"right\" class=\"CAGROUP\" >&nbsp;</td><td colspan=\"2\" align=\"center\" class=\"CAGROUP\" >"+group_title+"</td><td colspan=\"1\" align=\"right\" class=\"CAGROUP\">("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ClickonCatalogtoViewIndividualDetails.label","or_labels")+") </td>");	   
							else
								out.println("<td colspan=\"4\" align=\"center\" class=\"CAGROUP\" >"+group_title+" </td>");
							out.println("</tr><tr>");
							out.println("<TD width='25%' valign='top'>");
							out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");						
						}
						//IN038787 End.
					}
					if(order_nature.equals("P") || order_nature.equals("S"))
					{
						contr_msr_panel_id 	= ( (String)records.get(9) );
						category     		= ( (String)records.get(4) );
						if(order_nature.equals("P")) // Pass the discrete_measure_id & contr_msr_panel_id
						{
							measure_id = ((String)records.get(3)); // discrete_measure_id
						}
						else if(order_nature.equals("S")) // Pass the catalog_code
						{
							measure_id = ( (String)records.get(1) ); // Catalog Code
						}
					} // End of If
					if(!order_nature.equals("") && (order_nature.equalsIgnoreCase("P")) || order_nature.equalsIgnoreCase("S"))
					{	//IN038787 Start.
						if("Y".equals(order_dispaly_verticalYN)){
						%>
						<TR>
						<%
						} //IN038787 End.
					%>						
						<td class="LABEL"  width="20%" onClick='displayToolTip(escape("<%=measure_id%>"),escape("<%=contr_msr_panel_id%>"),"<%=order_nature%>","<%=category%>","<%=bean_id%>","<%=bean_name%>","<%=(String)records.get(1)%>","<%=i%>","orderSetResultForm","<%=p_pract_type%>")' onMouseOver='showToolTip("<%=(String)records.get(1)%>","orderSetResultForm")' onMouseOut="hideToolTip()"> <font size=1 color="BLUE"><!-- IN042045 included pract_type -->
						<a class='gridLink' href='javascript:;'><%=(String)records.get(2)%></a>	
					<%	
					}
					else
					{ //IN038787 Start.
						if("Y".equals(order_dispaly_verticalYN)){
						%>
						<TR>
						<%
						} //IN038787 End.
					%>
					  <td class="LABEL"  width="20%" onMouseOver='showToolTip("<%=(String)records.get(1)%>","orderSetResultForm")' onMouseOut="hideToolTip()"><font size=1>
						  <%=(String)records.get(2)%>
					<%	
					}  
					%>
					
					<input type="hidden" name="catalog_desc<%=(String)records.get(1)%><%=i%>" id="catalog_desc<%=(String)records.get(1)%><%=i%>" value="<%=(String)records.get(2)%>">
					</font></td>
					<td class="LABEL"  width="5%" >
					<%
					String prevValue	= "";	
					previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
					if(previousValues!=null)
					{
			   			setValues 		 = previousValues.keySet();
			   			iterator 	 = setValues.iterator();
												
			   			// Till here
						for(int prev_count=0;prev_count<previousValues.size();prev_count++)
			   			{
							entryValue = bean.checkForNull(((String)iterator.next()),"") ;
							prevValue  = entryValue.substring(0,2);
							//if(!care_set_order.equalsIgnoreCase("Y")) // For the First Time, it will be "N"
							//{
								if(prevValue.equalsIgnoreCase("h1")) // For the Care Sets, to set the Order Category, there will be only one record for Care Sets at a time
								{
									care_set_order = (String)previousValues.get(entryValue) ;
									if(care_set_order.equalsIgnoreCase("CS")) // Only if it is CS
									{
										//Added By Jyothi to fix IN020587 on 09/04/2010
										bean.setTempValues("OrderSetChecked","1");
										care_set_order = "Y";
									}
								}
							//}
							if(entryValue.equalsIgnoreCase("ck"+(String)records.get(1)))
							{
								checkedAttribute = "CHECKED";
								break;
							}
							else  checkedAttribute = "";
						}
					}

					// From the query
					if(((String)records.get(12))!=null && (((String)records.get(12)).equals("Y"))) // To enable or disable the checkbox depending upon the privilege
						disabled		 = "";
					else
						disabled		 = "DISABLED";
					/*Added by Uma on 8/22/2009 for PMG20089-CRF 641*/
					if(((String)records.get(14))!=null && (((String)records.get(14)).equals("Y"))) // To enable or disable the checkbox depending upon the privilege applicability of the Ordering Practitioner
						disabled		 = "";
					else
						disabled		 = "disabled";
					/*End Here*/

					// For Amend of Review Order
					if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
					{
						amend_key			= (bean.getPatientId()+bean.getEncounterId()+bean.getOrderId());  // Unique key (For Existing Orders) to keep the Value in the Bean
						amendPreviousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
						if(amendPreviousValues!=null)
						{
							setValues 		 = amendPreviousValues.keySet();
							iterator 	 = setValues.iterator();
							for(int prev_count=0;prev_count<amendPreviousValues.size();prev_count++)
							{
								entryValue = bean.checkForNull( ((String)iterator.next()),"") ;
								if(entryValue.equalsIgnoreCase("ck"+(String)records.get(1)))
								{
									checkedAttribute = "CHECKED";
									disabled		 = "DISABLED";
									break;
								}
							}
						} // End of amendPreviousValues
					}
					if(order_nature.equals("S")) // For Care Sets
					{
						if(((String)records.get(4)).equalsIgnoreCase("PH"))
							order_catalog_category 	= ((String)records.get(4));
						else // If it is an order set
							order_catalog_category 	= "CS";
							order_category			= "CS";
						//if(checkedAttribute.equalsIgnoreCase("CHECKED"))
						if(previousValues.size() > 0)
							care_set_order 			= "Y";
					}
					else
					   order_catalog_category = ((String)records.get(4));
					// Billing Informations Retrieved
					if(((String)records.get(11))!=null)
					{
						stBillMsg	= new StringTokenizer(((String)records.get(11)),"|");
						while(stBillMsg.hasMoreTokens())
						{
							  bill_warn_message		= stBillMsg.nextToken();
							  bill_warn_err_message	= stBillMsg.nextToken();
							  bill_error_message	= stBillMsg.nextToken();
							  if(bill_warn_message.equals("*")) bill_warn_message 	= "";
							  if(bill_warn_err_message.equals("*")) bill_warn_err_message = "";
							  if(bill_error_message.equals("*")) bill_error_message 	= "";
						}
					}
					
					%>
					
							<%-- <input type="checkbox" name="ck<%=(String)records.get(1)%>" id="ck<%=(String)records.get(1)%>" value="Y" onClick='setCheckBoxVal(this,escape("<%=(String)records.get(6)%>"),escape("<%=(String)records.get(1)%>"),"orderSetResultForm")' <%=checkedAttribute%> <%=disabled%>> IN064543 Commented for--%> <!--<%=disabled%>-->
					<!-- IN064543 Start -->	
					<!--IN069027 checkDiagnosis method added-->
							<input type="checkbox" name="ck<%=(String)records.get(1)%>" id="ck<%=(String)records.get(1)%>" value="Y" onClick='checkDiagnosis("<%=(String)records.get(4)%>",this);setCheckBoxVal(this,escape("<%=(String)records.get(6)%>"),escape("<%=(String)records.get(1)%>"),"orderSetResultForm");<%
							if(order_nature.equalsIgnoreCase("A")&& ((String)records.get(15)).equals("Y"))
							{
							%>showEditor(this,"<%=(String)records.get(1)%>","<%=order_nature%>","<%=category%>","<%=bean_id%>","<%=bean_name%>","<%=measure_id%>","<%=(String)records.get(16)%>","<%=(String)records.get(2)%>");<%
							}else if(order_nature.equalsIgnoreCase("S")||order_nature.equalsIgnoreCase("P")){
							%>displayToolTipForInstructions(this,escape("<%=measure_id%>"),escape("<%=contr_msr_panel_id%>"),"<%=order_nature%>","<%=category%>","<%=bean_id%>","<%=bean_name%>","<%=(String)records.get(1)%>","<%=i%>","orderSetResultForm","<%=p_pract_type%>");<%
							}%>' <%=checkedAttribute%> <%=disabled%> > 
					<!--IN064543 End-->		
						<input type="hidden" name="h1<%=(String)records.get(1)%>" id="h1<%=(String)records.get(1)%>" value="<%=order_catalog_category%>"> <%-- Order Category --%>
						<input type="hidden" name="h2<%=(String)records.get(1)%>" id="h2<%=(String)records.get(1)%>" value="<%=(String)records.get(5)%>"> <%-- Order Type--%>
						<input type="hidden" name="prompt_desc<%=(String)records.get(1)%>" id="prompt_desc<%=(String)records.get(1)%>" value="<%=(String)records.get(7)%>"> <%-- Display the Message, kept with the catalog_code--%>
						<input type="hidden" name="bill_warn<%=(String)records.get(1)%>" id="bill_warn<%=(String)records.get(1)%>" value="<%=bill_warn_message%>"> <%-- Display the Warn Message for the billing, kept with the catalog_code--%>
						<input type="hidden" name="bill_warn_err<%=(String)records.get(1)%>" id="bill_warn_err<%=(String)records.get(1)%>" value="<%=bill_warn_err_message%>"> <%-- Display the Bill Warn Error Message for the billing, kept with the catalog_code--%>
						<input type="hidden" name="bill_error<%=(String)records.get(1)%>" id="bill_error<%=(String)records.get(1)%>" value="<%=bill_error_message%>"> <%-- Display the Bill Error Message for the billing, kept with the catalog_code--%>
  						<input type="hidden" name="explanatory_text<%=(String)records.get(1)%>" id="explanatory_text<%=(String)records.get(1)%>" value="<%=((String)records.get(13)==null?"":(String)records.get(13))%>"> <%-- explanatory_text--%>
				</td>
				<td class="LABEL"  width="3%" >
				
				<% 		
				if(((String)records.get(8)).equalsIgnoreCase("Y")) // For Authorization Required
				{
				%>						
					<img id="authorization<%=i%>" src="../../eOR/images/Authorization.gif" align="center" title="Authorization"></img>
				<%
				}	
 				if(((String)records.get(10)).equalsIgnoreCase("Y")) // For Special Approval Required
				{
				%>						
					<img id="special_approval<%=i%>" src="../../eOR/images/SpecialApproval.gif" align="center" title="Special Approval"></img>
				<%
				}	
				%>
				</td>
				<%
				//IN038787 Start.
				if("Y".equals(order_dispaly_verticalYN)){%>
				</TR><TR>
				<%}
				//IN038787 End.
				%>
				<%
					i++;
					if("N".equals(order_dispaly_verticalYN)){  //IN038787 Start.
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
					prev_group_title = group_title;
				} // End of for count
				
				if("N".equals(order_dispaly_verticalYN)){  //IN038787
					if( i % 4 > 0)
					{
						for (int u=0;u<4-i%4;u++)
							out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
						out.println("</tr>");
					}
					//IN038787 Start.
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
				out.println("</table>");
				out.flush();
				} 
				else
				{
				%>
					<script>//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
				<%
				}
				%>
				<script>//parent.result_hdr.rows ="18%,*,*" </script>
	<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
	<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
	<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
	<input type="hidden" name="activity_type" id="activity_type" value="<%=activity_type%>">
	<input type="hidden" name="order_nature" id="order_nature" value="<%=order_nature%>">
	<input type="hidden" name="orderable_text" id="orderable_text" value="<%=orderable_text%>">
	<input type="hidden" name="criteria" id="criteria" value="<%=criteria%>">
	<input type="hidden" name="display_records" id="display_records" value="<%=display_records%>">
	<input type="hidden" name="restrict_by" id="restrict_by" value="<%=restrict_by%>">
	<input type="hidden" name="group_frame_count" id="group_frame_count" value="<%=group_frame_count%>">
	<input type="hidden" name="atomic_frame_count" id="atomic_frame_count" value="<%=atomic_frame_count%>">
	<input type="hidden" name="profile_frame_count" id="profile_frame_count" value="<%=profile_frame_count%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="check_box_val" id="check_box_val" value="N">
	<input type="hidden" name="care_set_check_box_val" id="care_set_check_box_val" value="<%=care_set_order%>">	
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=bean.getEncounterId()%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=bean.getPatientClass()%>">
	<input type="hidden" name="admission_date" id="admission_date" value="<%=bean.getVisitAdmDate()%>">
	<input type="hidden" name="discharge_date_time" id="discharge_date_time" value="<%=bean.getDischargeDateTime()%>">
	<input type="hidden" name="order_dispaly_verticalYN" id="order_dispaly_verticalYN" value="<%=order_dispaly_verticalYN%>"> <!--  IN038787 -->
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	
	<%=CommonBean.setFormTransaction(request)%>
	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
		<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="100%"   align="center">
		   	<tr>
		 		<td width='100%' id='t'></td>
			</tr>
		</table>
	</div>		
</form>
<%
		//Added By Jyothi to fix IN020587 on 09/04/2010
		putObjectInBean(bean_id,bean,request);
		//End
			//out.println(CommonBean.setFormTransaction(request, "../../eOR/jsp/OrderEnterOrderSetResult.jsp", false));
	 } 
	 catch(Exception e) 
	{
		//  out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
		  e.printStackTrace();
	}
%>		 
			<!-- Added BY Arvind  -->
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
						checkFrameMembers('<%=frm1%>', '<%=frm2%>', '<%=frm3%>');
					</script>
				<%
				}
				else if(!order_catalog_nature.equals(""))
				{
				%>
					<script>
						checkFrameMembers('<%=frm1%>', '<%=frm2%>', '<%=frm3%>');
					</script>
				<%
				}
				%>

			<!-- End Here -->

			<script>
 				parent.parent.criteriaMainFrame.document.addlSearchCriteriaForm.search.disabled = false;
		 </script>
	  </body>
</html>

