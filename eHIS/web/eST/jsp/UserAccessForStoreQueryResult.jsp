<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
21/02/2016		IN0057461			B.Badmavathi					ML-MMOH-CRF-0448
21/04/2016		IN0056060			B.Badmavathi      			    Authorize at Issue Store	
06/04/2022		TFSID-23934			Mohamed							MO-CRF-20177
29/04/2022		TFSID-29303			Mohamed							MO-CRF-20174
---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%-- JSP Page specific attributes start --%>
<%@	page import="java.util.ArrayList,java.util.HashMap, java.sql.*, webbeans.eCommon.*,eST.UserAccessForStoreBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@	include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086		
		String locale			=		(String)session.getAttribute("LOCALE");
		Connection con				= null;
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id								 =		"";
		String bean_name							 =		"";
		bean_id										 =		"userAccessForStoreBean" ;
		bean_name									 =		"eST.UserAccessForStoreBean";
		UserAccessForStoreBean bean					 =		(UserAccessForStoreBean)getBeanObject( bean_id, bean_name, request );
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
		/*bean.getSiteSpec();
		boolean site = bean.isSite_spec_yn();*/
		con						= ConnectionManager.getConnection(request);
		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_PRODUCT_TRANSFER");
		bean.setSite_spec_yn(site_main);
		boolean site=bean.isSite_spec_yn();
	//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/UserAccessForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<form name="QueryResult" id="QueryResult" onMouseDown="CodeArrest()">
<%
	String user_id				= request.getParameter("user_id");
	String appl_user_name		= request.getParameter("appl_user_name");
	String store_code			= request.getParameter("store_code");
	String short_desc			= request.getParameter("short_desc");
	String interface_to_external_po_yn			 =		"";
	String dflt_search_item		=	null;
	int colcountTemp = 0;
	int colcountTemp1 = 0;
	interface_to_external_po_yn=bean.getInterface_to_external_po_yn((String)session.getAttribute("ACC_ENTITY_ID"));
    
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
			
	try{
			user_id        	= CommonBean.checkForNull(user_id        )+"%";
			appl_user_name 	= CommonBean.checkForNull(appl_user_name )+"%";
			store_code     	= CommonBean.checkForNull(store_code     )+"%";
			short_desc     	= CommonBean.checkForNull(short_desc     )+"%";
			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_QUERY_RESULT"));
		
			//sqlMap.put("sqlData", "SELECT APU.APPL_USER_ID USER_ID, APU.APPL_USER_NAME APPL_USER_NAME,   MM.STORE_CODE STORE_CODE, MM.SHORT_DESC SHORT_DESC, UA.OBS_ALLOWED_YN,UA.GRN_ALLOWED_YN, UA.GRN_FINALIZE_ALLOWED_YN, UA.RTV_ALLOWED_YN, UA.RTV_FINALIZE_ALLOWED_YN, UA.MFG_ALLOWED_YN, UA.REQ_ALLOWED_YN,UA.REQ_AUTHORIZE_ALLOWED_YN, UA.ISS_ALLOWED_YN, UA.URG_ALLOWED_YN,UA.URG_FINALIZE_ALLOWED_YN, UA.RET_ALLOWED_YN,UA.RET_FINALIZE_ALLOWED_YN, UA.TFR_ALLOWED_YN,      UA.TFR_FINALIZE_ALLOWED_YN, UA.ADJ_ALLOWED_YN, UA.ADJ_FINALIZE_ALLOWED_YN, UA.VAR_ALLOWED_YN, UA.PRT_ALLOWED_YN,    UA.SAL_ALLOWED_YN, UA.SAL_AUTHORIZE_ALLOWED_YN, UA.SRT_ALLOWED_YN,UA.SRT_FINALIZE_ALLOWED_YN, UA.SPLIT_BATCH_ALLOWED_YN,UA.BIN_CHANGE_ALLOWED_YN, UA.ISS_FINALIZE_ALLOWED_YN,UA.MFG_FINALIZE_ALLOWED_YN, UA.STK_ITEM_CON_ALLOWED_YN,UA.CANCL_ALLOWED_YN,UA.PRQ_ALLOWED_YN,  UA.PRQ_FINALIZE_ALLOWED_YN,UA.REQ_DELETE_YN, UA.URG_DELETE_YN, UA.ISS_DELETE_YN, UA.RET_DELETE_YN, UA.ADJ_DELETE_YN, UA.PRT_DELETE_YN, UA.SAL_DELETE_YN, UA.SRT_DELETE_YN, UA.GRN_DELETE_YN, UA.RTV_DELETE_YN, UA.MFG_DELETE_YN, UA.TFR_DELETE_YN, UA.PRQ_DELETE_YN,UA.CNDMN_EXP_BTCH_ALLOWED_YN, UA.DFLT_ITEM_SEARCH,UA.DFLT_SAL_TRN_TYPE,UA.GRN_FINALIZE_PROMPT_YN,UA.RTV_FINALIZE_PROMPT_YN,UA.MFG_FINALIZE_PROMPT_YN,UA.REQ_AUTHORIZE_PROMPT_YN,UA.ISS_FINALIZE_PROMPT_YN,UA.URG_FINALIZE_PROMPT_YN,UA.RET_FINALIZE_PROMPT_YN,UA.TFR_FINALIZE_PROMPT_YN,UA.ADJ_FINALIZE_PROMPT_YN,UA.SAL_AUTHORIZE_PROMPT_YN,UA.SRT_FINALIZE_PROMPT_YN FROM ST_USER_ACCESS_FOR_STORE UA,  ST_STORE ST, MM_STORE_LANG_VW MM, SM_APPL_USER_LANG_VW APU  WHERE MM.EFF_STATUS = 'E'   AND MM.STORE_CODE = ST.STORE_CODE   AND UA.STORE_CODE = ST.STORE_CODE   AND UA.USER_ID = APU.APPL_USER_ID   AND APU.EFF_STATUS = 'E'  AND UPPER (APU.APPL_USER_ID) LIKE UPPER (?)   AND UPPER (APU.APPL_USER_NAME) LIKE UPPER (?)   AND UPPER (MM.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.LANGUAGE_ID = APU.LANGUAGE_ID AND MM.LANGUAGE_ID = ?");//Commented by suresh.r 12-11-2013 against JD-CRF-156
			//sqlMap.put("sqlData", "SELECT APU.APPL_USER_ID USER_ID, APU.APPL_USER_NAME APPL_USER_NAME,   MM.STORE_CODE STORE_CODE, MM.SHORT_DESC SHORT_DESC, UA.OBS_ALLOWED_YN,UA.GRN_ALLOWED_YN, UA.GRN_FINALIZE_ALLOWED_YN, UA.RTV_ALLOWED_YN, UA.RTV_FINALIZE_ALLOWED_YN, UA.MFG_ALLOWED_YN, UA.REQ_ALLOWED_YN,UA.REQ_AUTHORIZE_ALLOWED_YN, UA.ISS_ALLOWED_YN, UA.URG_ALLOWED_YN,UA.URG_FINALIZE_ALLOWED_YN, UA.RET_ALLOWED_YN,UA.RET_FINALIZE_ALLOWED_YN, UA.TFR_ALLOWED_YN,      UA.TFR_FINALIZE_ALLOWED_YN, UA.ADJ_ALLOWED_YN, UA.ADJ_FINALIZE_ALLOWED_YN, UA.VAR_ALLOWED_YN, UA.PRT_ALLOWED_YN,    UA.SAL_ALLOWED_YN, UA.SAL_AUTHORIZE_ALLOWED_YN, UA.SRT_ALLOWED_YN,UA.SRT_FINALIZE_ALLOWED_YN, UA.SPLIT_BATCH_ALLOWED_YN,UA.BIN_CHANGE_ALLOWED_YN, UA.ISS_FINALIZE_ALLOWED_YN,UA.MFG_FINALIZE_ALLOWED_YN, UA.STK_ITEM_CON_ALLOWED_YN,UA.CANCL_ALLOWED_YN,UA.PRQ_ALLOWED_YN,  UA.PRQ_FINALIZE_ALLOWED_YN,UA.REQ_DELETE_YN, UA.URG_DELETE_YN, UA.ISS_DELETE_YN, UA.RET_DELETE_YN, UA.ADJ_DELETE_YN, UA.PRT_DELETE_YN, UA.SAL_DELETE_YN, UA.SRT_DELETE_YN, UA.GRN_DELETE_YN, UA.RTV_DELETE_YN, UA.MFG_DELETE_YN, UA.TFR_DELETE_YN, UA.PRQ_DELETE_YN,UA.CNDMN_EXP_BTCH_ALLOWED_YN, UA.DFLT_ITEM_SEARCH,UA.DFLT_SAL_TRN_TYPE,UA.GRN_FINALIZE_PROMPT_YN,UA.RTV_FINALIZE_PROMPT_YN,UA.MFG_FINALIZE_PROMPT_YN,UA.REQ_AUTHORIZE_PROMPT_YN,UA.ISS_FINALIZE_PROMPT_YN,UA.URG_FINALIZE_PROMPT_YN,UA.RET_FINALIZE_PROMPT_YN,UA.TFR_FINALIZE_PROMPT_YN,UA.ADJ_FINALIZE_PROMPT_YN,UA.SAL_AUTHORIZE_PROMPT_YN,UA.SRT_FINALIZE_PROMPT_YN,UA.DISP_CURR_ENCNTR_FIN_DTL_YN FROM ST_USER_ACCESS_FOR_STORE UA,  ST_STORE ST, MM_STORE_LANG_VW MM, SM_APPL_USER_LANG_VW APU  WHERE MM.EFF_STATUS = 'E'   AND MM.STORE_CODE = ST.STORE_CODE   AND UA.STORE_CODE = ST.STORE_CODE   AND UA.USER_ID = APU.APPL_USER_ID   AND APU.EFF_STATUS = 'E'  AND UPPER (APU.APPL_USER_ID) LIKE UPPER (?)   AND UPPER (APU.APPL_USER_NAME) LIKE UPPER (?)   AND UPPER (MM.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.LANGUAGE_ID = APU.LANGUAGE_ID AND MM.LANGUAGE_ID = ?");//Added by suresh.r 12-11-2013 against JD-CRF-156
			
			//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
		//sqlMap.put("sqlData", "SELECT APU.APPL_USER_ID USER_ID, APU.APPL_USER_NAME APPL_USER_NAME,   MM.STORE_CODE STORE_CODE, MM.SHORT_DESC SHORT_DESC,UA.DISP_MIN_ROL_YN, UA.OBS_ALLOWED_YN,UA.GRN_ALLOWED_YN, UA.GRN_FINALIZE_ALLOWED_YN, UA.RTV_ALLOWED_YN, UA.RTV_FINALIZE_ALLOWED_YN, UA.MFG_ALLOWED_YN, UA.REQ_ALLOWED_YN,UA.REQ_AUTHORIZE_ALLOWED_YN, UA.ISS_ALLOWED_YN, UA.URG_ALLOWED_YN,UA.URG_FINALIZE_ALLOWED_YN, UA.RET_ALLOWED_YN,UA.RET_FINALIZE_ALLOWED_YN, UA.TFR_ALLOWED_YN,      UA.TFR_FINALIZE_ALLOWED_YN, UA.ADJ_ALLOWED_YN, UA.ADJ_FINALIZE_ALLOWED_YN, UA.VAR_ALLOWED_YN, UA.PRT_ALLOWED_YN,   UA.SAL_ALLOWED_YN, UA.SAL_AUTHORIZE_ALLOWED_YN, UA.SRT_ALLOWED_YN,UA.SRT_FINALIZE_ALLOWED_YN, UA.SPLIT_BATCH_ALLOWED_YN,UA.BIN_CHANGE_ALLOWED_YN, UA.ISS_FINALIZE_ALLOWED_YN,UA.MFG_FINALIZE_ALLOWED_YN, UA.STK_ITEM_CON_ALLOWED_YN,UA.CANCL_ALLOWED_YN,UA.PRQ_ALLOWED_YN,  UA.PRQ_FINALIZE_ALLOWED_YN,UA.REQ_DELETE_YN, UA.URG_DELETE_YN, UA.ISS_DELETE_YN, UA.RET_DELETE_YN, UA.ADJ_DELETE_YN, UA.PRT_DELETE_YN, UA.SAL_DELETE_YN, UA.SRT_DELETE_YN, UA.GRN_DELETE_YN, UA.RTV_DELETE_YN, UA.MFG_DELETE_YN, UA.TFR_DELETE_YN, UA.PRQ_DELETE_YN,UA.CNDMN_EXP_BTCH_ALLOWED_YN, UA.DFLT_ITEM_SEARCH,UA.DFLT_SAL_TRN_TYPE,UA.GRN_FINALIZE_PROMPT_YN,UA.RTV_FINALIZE_PROMPT_YN,UA.MFG_FINALIZE_PROMPT_YN,UA.REQ_AUTHORIZE_PROMPT_YN,UA.ISS_FINALIZE_PROMPT_YN,UA.URG_FINALIZE_PROMPT_YN,UA.RET_FINALIZE_PROMPT_YN,UA.TFR_FINALIZE_PROMPT_YN,UA.ADJ_FINALIZE_PROMPT_YN,UA.SAL_AUTHORIZE_PROMPT_YN,UA.SRT_FINALIZE_PROMPT_YN,UA.DISP_CURR_ENCNTR_FIN_DTL_YN  FROM ST_USER_ACCESS_FOR_STORE UA,  ST_STORE ST, MM_STORE_LANG_VW MM, SM_APPL_USER_LANG_VW APU  WHERE MM.EFF_STATUS = 'E'   AND MM.STORE_CODE = ST.STORE_CODE   AND UA.STORE_CODE = ST.STORE_CODE   AND UA.USER_ID = APU.APPL_USER_ID   AND APU.EFF_STATUS = 'E'  AND UPPER (APU.APPL_USER_ID) LIKE UPPER (?)   AND UPPER (APU.APPL_USER_NAME) LIKE UPPER (?)   AND UPPER (MM.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.LANGUAGE_ID = APU.LANGUAGE_ID AND MM.LANGUAGE_ID = ?");//Added by suresh.r 12-11-2013 against JD-CRF-156
		
			//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
			//	sqlMap.put("sqlData", "SELECT APU.APPL_USER_ID USER_ID, APU.APPL_USER_NAME APPL_USER_NAME,   MM.STORE_CODE STORE_CODE, MM.SHORT_DESC SHORT_DESC,UA.DISP_MIN_ROL_YN, UA.OBS_ALLOWED_YN,UA.GRN_ALLOWED_YN, UA.GRN_FINALIZE_ALLOWED_YN, UA.RTV_ALLOWED_YN, UA.RTV_FINALIZE_ALLOWED_YN, UA.MFG_ALLOWED_YN, UA.REQ_ALLOWED_YN,UA.REQ_AUTHORIZE_ALLOWED_YN, UA.ISS_ALLOWED_YN, UA.URG_ALLOWED_YN,UA.URG_FINALIZE_ALLOWED_YN, UA.RET_ALLOWED_YN,UA.RET_FINALIZE_ALLOWED_YN, UA.TFR_ALLOWED_YN,      UA.TFR_FINALIZE_ALLOWED_YN, UA.ADJ_ALLOWED_YN, UA.ADJ_FINALIZE_ALLOWED_YN, UA.VAR_ALLOWED_YN, UA.PRT_ALLOWED_YN,   UA.SAL_ALLOWED_YN, UA.SAL_AUTHORIZE_ALLOWED_YN, UA.SRT_ALLOWED_YN,UA.SRT_FINALIZE_ALLOWED_YN, UA.SPLIT_BATCH_ALLOWED_YN,UA.BIN_CHANGE_ALLOWED_YN, UA.ISS_FINALIZE_ALLOWED_YN,UA.MFG_FINALIZE_ALLOWED_YN, UA.STK_ITEM_CON_ALLOWED_YN,UA.CANCL_ALLOWED_YN,UA.PRQ_ALLOWED_YN,  UA.PRQ_FINALIZE_ALLOWED_YN,UA.REQ_DELETE_YN, UA.URG_DELETE_YN, UA.ISS_DELETE_YN, UA.RET_DELETE_YN, UA.ADJ_DELETE_YN, UA.PRT_DELETE_YN, UA.SAL_DELETE_YN, UA.SRT_DELETE_YN, UA.GRN_DELETE_YN, UA.RTV_DELETE_YN, UA.MFG_DELETE_YN, UA.TFR_DELETE_YN, UA.PRQ_DELETE_YN,UA.CNDMN_EXP_BTCH_ALLOWED_YN, UA.DFLT_ITEM_SEARCH,UA.DFLT_SAL_TRN_TYPE,UA.GRN_FINALIZE_PROMPT_YN,UA.RTV_FINALIZE_PROMPT_YN,UA.MFG_FINALIZE_PROMPT_YN,UA.REQ_AUTHORIZE_PROMPT_YN,UA.ISS_FINALIZE_PROMPT_YN,UA.URG_FINALIZE_PROMPT_YN,UA.RET_FINALIZE_PROMPT_YN,UA.TFR_FINALIZE_PROMPT_YN,UA.ADJ_FINALIZE_PROMPT_YN,UA.SAL_AUTHORIZE_PROMPT_YN,UA.SRT_FINALIZE_PROMPT_YN,UA.DISP_CURR_ENCNTR_FIN_DTL_YN,UA.PRT_FINALIZE_ALLOWED_YN,UA.PRT_FINALIZE_PROMPT_YN  FROM ST_USER_ACCESS_FOR_STORE UA,  ST_STORE ST, MM_STORE_LANG_VW MM, SM_APPL_USER_LANG_VW APU  WHERE MM.EFF_STATUS = 'E'   AND MM.STORE_CODE = ST.STORE_CODE   AND UA.STORE_CODE = ST.STORE_CODE   AND UA.USER_ID = APU.APPL_USER_ID   AND APU.EFF_STATUS = 'E'  AND UPPER (APU.APPL_USER_ID) LIKE UPPER (?)   AND UPPER (APU.APPL_USER_NAME) LIKE UPPER (?)   AND UPPER (MM.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.LANGUAGE_ID = APU.LANGUAGE_ID AND MM.LANGUAGE_ID = ?");
			//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
			sqlMap.put("sqlData","SELECT APU.APPL_USER_ID USER_ID, APU.APPL_USER_NAME APPL_USER_NAME,   MM.STORE_CODE STORE_CODE, MM.SHORT_DESC SHORT_DESC,UA.DISP_MIN_ROL_YN, UA.OBS_ALLOWED_YN,UA.GRN_ALLOWED_YN, UA.GRN_FINALIZE_ALLOWED_YN, UA.RTV_ALLOWED_YN, UA.RTV_FINALIZE_ALLOWED_YN, UA.MFG_ALLOWED_YN, UA.REQ_ALLOWED_YN,UA.REQ_AUTHORIZE_ALLOWED_YN, UA.ISS_ALLOWED_YN, UA.URG_ALLOWED_YN,UA.URG_FINALIZE_ALLOWED_YN, UA.RET_ALLOWED_YN,UA.RET_FINALIZE_ALLOWED_YN, UA.TFR_ALLOWED_YN,      UA.TFR_FINALIZE_ALLOWED_YN, UA.ADJ_ALLOWED_YN, UA.ADJ_FINALIZE_ALLOWED_YN, UA.VAR_ALLOWED_YN, UA.PRT_ALLOWED_YN,   UA.SAL_ALLOWED_YN, UA.SAL_AUTHORIZE_ALLOWED_YN, UA.SRT_ALLOWED_YN,UA.SRT_FINALIZE_ALLOWED_YN, UA.SPLIT_BATCH_ALLOWED_YN,UA.BIN_CHANGE_ALLOWED_YN, UA.ISS_FINALIZE_ALLOWED_YN,UA.MFG_FINALIZE_ALLOWED_YN, UA.STK_ITEM_CON_ALLOWED_YN,UA.CANCL_ALLOWED_YN,UA.PRQ_ALLOWED_YN,  UA.PRQ_FINALIZE_ALLOWED_YN,UA.REQ_DELETE_YN, UA.URG_DELETE_YN, UA.ISS_DELETE_YN, UA.RET_DELETE_YN, UA.ADJ_DELETE_YN, UA.PRT_DELETE_YN, UA.SAL_DELETE_YN, UA.SRT_DELETE_YN, UA.GRN_DELETE_YN, UA.RTV_DELETE_YN, UA.MFG_DELETE_YN, UA.TFR_DELETE_YN, UA.PRQ_DELETE_YN,UA.CNDMN_EXP_BTCH_ALLOWED_YN, UA.DFLT_ITEM_SEARCH,UA.DFLT_SAL_TRN_TYPE,UA.GRN_FINALIZE_PROMPT_YN,UA.RTV_FINALIZE_PROMPT_YN,UA.MFG_FINALIZE_PROMPT_YN,UA.REQ_AUTHORIZE_PROMPT_YN,UA.ISS_FINALIZE_PROMPT_YN,UA.URG_FINALIZE_PROMPT_YN,UA.RET_FINALIZE_PROMPT_YN,UA.TFR_FINALIZE_PROMPT_YN,UA.ADJ_FINALIZE_PROMPT_YN,UA.SAL_AUTHORIZE_PROMPT_YN,UA.SRT_FINALIZE_PROMPT_YN,UA.DISP_CURR_ENCNTR_FIN_DTL_YN,UA.PRT_FINALIZE_ALLOWED_YN,UA.PRT_FINALIZE_PROMPT_YN, UA.AUTHORIZE_AT_ISSUE_ALLOWED_YN,UA.CANCEL_AUTHORIZE_ISS_ALLOW_YN CANCEL_AUTHORIZE_ISS_ALLOW_YN,UA.REJECT_REQUEST_ISS_ALLOW_YN REJECT_REQUEST_ISS_ALLOW_YN FROM ST_USER_ACCESS_FOR_STORE UA,  ST_STORE ST, MM_STORE_LANG_VW MM, SM_APPL_USER_LANG_VW APU  WHERE MM.EFF_STATUS = 'E'   AND MM.STORE_CODE = ST.STORE_CODE   AND UA.STORE_CODE = ST.STORE_CODE   AND UA.USER_ID = APU.APPL_USER_ID   AND APU.EFF_STATUS = 'E'  AND UPPER (APU.APPL_USER_ID) LIKE UPPER (?)   AND UPPER (APU.APPL_USER_NAME) LIKE UPPER (?)   AND UPPER (MM.STORE_CODE) LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND MM.LANGUAGE_ID = APU.LANGUAGE_ID AND MM.LANGUAGE_ID = ?");
		

		//	The fields are going to be display

			displayFields.add("user_id");
			displayFields.add("appl_user_name");
			displayFields.add("store_code");
			displayFields.add("short_desc");
			displayFields.add("disp_min_rol_yn"); //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
			displayFields.add("obs_allowed_yn");
			displayFields.add("rtv_allowed_yn");
            displayFields.add("rtv_finalize_allowed_yn");
            displayFields.add("rtv_finalize_prompt_yn");
            displayFields.add("rtv_delete_yn");
			displayFields.add("iss_allowed_yn");
            displayFields.add("iss_finalize_allowed_yn");
            displayFields.add("iss_finalize_prompt_yn");
			displayFields.add("iss_delete_yn");
			displayFields.add("ret_allowed_yn");
            displayFields.add("ret_finalize_allowed_yn");
            displayFields.add("ret_finalize_prompt_yn");
			displayFields.add("ret_delete_yn");
			displayFields.add("adj_allowed_yn");
            displayFields.add("adj_finalize_allowed_yn");
            displayFields.add("adj_finalize_prompt_yn");
			displayFields.add("adj_delete_yn");
			displayFields.add("prt_allowed_yn");
			if(site){//Added for ML-MMOH-CRF-0448 B.Badmavathi
			displayFields.add("prt_finalize_allowed_yn");  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
	      		displayFields.add("prt_finalize_prompt_yn");  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
			}
			displayFields.add("prt_delete_yn");
			displayFields.add("split_batch_allowed_yn");
			displayFields.add("sal_allowed_yn"); 
            displayFields.add("sal_authorize_allowed_yn"); 
            displayFields.add("sal_authorize_prompt_yn");
            displayFields.add("sal_delete_yn"); 
			displayFields.add("grn_allowed_yn");
            displayFields.add("grn_finalize_allowed_yn");
            displayFields.add("grn_finalize_prompt_yn");
            displayFields.add("grn_delete_yn");
			displayFields.add("req_allowed_yn");
			displayFields.add("req_authorize_allowed_yn"); 
			displayFields.add("req_authorize_prompt_yn");
			displayFields.add("req_delete_yn"); 
			displayFields.add("urg_allowed_yn");
            displayFields.add("urg_finalize_allowed_yn");
            displayFields.add("urg_finalize_prompt_yn");
            displayFields.add("urg_delete_yn");
			displayFields.add("mfg_allowed_yn");
			displayFields.add("mfg_finalize_allowed_yn");
			displayFields.add("mfg_finalize_prompt_yn");
			displayFields.add("mfg_delete_yn");
			displayFields.add("tfr_allowed_yn");
            displayFields.add("tfr_finalize_allowed_yn");
            displayFields.add("tfr_finalize_prompt_yn");
            displayFields.add("tfr_delete_yn");
			displayFields.add("var_allowed_yn"); 
			displayFields.add("bin_change_allowed_yn");
            displayFields.add("srt_allowed_yn");
            displayFields.add("srt_finalize_allowed_yn");
            displayFields.add("srt_finalize_prompt_yn");
            displayFields.add("srt_delete_yn");
			displayFields.add("stk_item_con_allowed_yn");
			displayFields.add("cancl_allowed_yn");
			displayFields.add("cndmn_exp_btch_allowed_yn");
			if(interface_to_external_po_yn.equals("Y")){
			displayFields.add("prq_allowed_yn");
			displayFields.add("prq_finalize_allowed_yn");
			displayFields.add("prq_delete_yn");
			}
			displayFields.add("AUTHORIZE_AT_ISSUE_ALLOWED_YN");//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
			
			displayFields.add("REJECT_REQUEST_ISS_ALLOW_YN");  //TFS ID - 29303 - MO-CRF-20174
			displayFields.add("CANCEL_AUTHORIZE_ISS_ALLOW_YN");  //TFS ID - 23934 - MO-CRF-20177
			

			displayFields.add("dflt_item_search"); // Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria 
			displayFields.add("dflt_sal_trn_type");  // Added by Padmapriya
			displayFields.add("disp_curr_encntr_fin_dtl_yn");  //Added by suresh.r 12-11-2013 against JD-CRF-156

  			
			
			
			//displayFields.add("view_cost_yn");

		//	The fields are going to be in where condition * should match with the query

			chkFields.add(user_id);
			chkFields.add(appl_user_name);
			chkFields.add(store_code);
			chkFields.add(short_desc);
			chkFields.add(locale);

			/* Commented on 12/10/2004 */

			//chkFields.add(session.getAttribute("facility_id"));
		

			// Adding function related array list into the HashMap

			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
		
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,	9);

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0  align="center">
			<tr>
				<td width="80%" class="white" nowrap>&nbsp;</td>
				<td width="20%" class="white" nowrap>&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="1" cellspacing="1"  align="center">
			<tr>
			<th>&nbsp;</th>
			
			 <th>Display Min Level & ROL</th>  
			<th><fmt:message key="eST.OpeningStock.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.VendorReturn.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.RequisitionIssues.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.IssueReturns.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.StockAdjustment.label" bundle="${st_labels}"/></th>
			<!--  <th colspan="2"><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></th> -->
			
			<!--  Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 -->
		  	<%if(site){ %><!--Added for ML-MMOH-CRF-0448 B.Badmavathi-->
		  	<th colspan="4"><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></th> 
		  	<%}else{ %><!--Added for ML-MMOH-CRF-0448 B.Badmavathi-->
		  	<th colspan="2"><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></th> 
		  	<%} %>
			<th><fmt:message key="eST.SplitBatches.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.GoodsReceipt.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.Requisition.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.UrgentIssue.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.ManufacturingItems.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eST.ChangeBin.label" bundle="${st_labels}"/></th>
			<th colspan="4"><fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="eST.StockItemConsumption.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="Common.CancelRequest.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eST.CondemnExpiredBatches.label" bundle="${st_labels}"/></th>
		<%if(interface_to_external_po_yn.equals("Y")){%>
			<th colspan="3"><fmt:message key="eST.PORequest.label" bundle="${st_labels}"/></th>
		<%}%>
			<th><fmt:message key="eST.AuthorizeatIssueStore.label" bundle="${st_labels}"/></th><!--Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001-->
			<th><fmt:message key="eST.RejectRequestatIssueStore.label" bundle="${st_labels}"/></th><!--TFS ID - 29303 - MO-CRF-20174-->
			<th><fmt:message key="eST.CancelAuthorizeatIssueStore.label" bundle="${st_labels}"/></th><!--TFS ID - 23934 - MO-CRF-20177-->
			</tr>
                <tr>
				<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
				 <th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>   <!--//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 -->
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
                <th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
                <th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->
				<%if(site){ %>
				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
               			<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
			  	<%} %>
				<!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->
				
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>				
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
			    <th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
                <th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
                <th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
   				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<%if(interface_to_external_po_yn.equals("Y")){%>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<%}%>   
				<!--Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001-->
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th><!--TFS ID - 29303 - MO-CRF-20174-->
				<th><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th><!--TFS ID - 23934 - MO-CRF-20177-->
				</tr>			
				<%
				String previous				=		"";
				String user_id_value		=		"";
			

			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue			=		"QRYEVEN" ;
				else
					classvalue			=		"QRYODD" ;

					String link_columns	=		"4";
					records				=		(ArrayList)result.get( recCount );
					System.err.println("records" +records);
					user_id_value		=		(String)records.get( 1 );
			
				if(! (user_id_value.equals(previous)) ) {

				%>
				<tr>
				<td class = "ITEMSELECT" colspan=61><fmt:message key="Common.user.label" bundle="${common_labels}"/>:<b><%=(String)records.get( 1 )%></b> </td>
				</tr>
				<%if(site)
				{ %>
				
				<tr  onClick="Modify1(this);">
				<%}else{%>
				<tr  onClick="Modify(this);">
				<%} %>
				<%
				}
				else {
				%>
				<%if(site)
				{ %>
				
				<tr  onClick="Modify1(this);">
				<%}else{%>
				<tr  onClick="Modify(this);">
				<%} %>			
		<%
				}
				/*if(interface_to_external_po_yn.equals("Y")){
				//colcountTemp = 60;//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
				//colcountTemp = 61;
				if(site){//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
				colcountTemp = 63;  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
				colcountTemp1 = 62;}
				else{
					colcountTemp = 61;
					colcountTemp1 = 60;
					}//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
				//colcountTemp1 = 59;
				//colcountTemp1 = 60;
				
				  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016

			}
			else{
				//colcountTemp = 57;
				//colcountTemp = 58;
				//colcountTemp = 60;  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
				//colcountTemp1 = 56;
				//colcountTemp1 = 57;
				//colcountTemp1 = 59; //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
				//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
				if(site){
					colcountTemp = 60;  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
					colcountTemp1 = 59;}
					else{
						colcountTemp = 59;
						colcountTemp1 = 57;
						}
				//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
			}
				*/
		//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
				if(interface_to_external_po_yn.equals("Y")){
					if(site){
						colcountTemp = 66; 
						colcountTemp1 = 65;	
					}
					else{
						colcountTemp = 64;
						colcountTemp1 = 63;
					}
				}
				else{
					if(site){
						colcountTemp = 63;
						colcountTemp1 = 62;
					}
					else{
						colcountTemp = 62;
						colcountTemp1 = 60;
					}
				}
				for(int colCount=0; colCount<records.size(); colCount++){
					if((colCount < 3) || (colCount>colcountTemp1)) {
						out.println("<td class='NODISPLAY'>"+(String)records.get( colCount )+"</td>");
						continue;
					}
					
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
				%>             
						<td class="<%=classvalue%>" nowrap  onmouseover="changeCursor(this);">  <font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
		<%
					}
				else{
		%>
						<td class="<%=classvalue%>" nowrap onclick="disableClick(event);"
						<% 
							if(colCount >= 4 && colCount<colcountTemp) {
								out.println(" align=\'center\' >");
								if( ((String)records.get( colCount )).equals("Y") && ((String)records.get( colCount  )).equals("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							
										
							}
							else {
								out.println(">"+(String)records.get( colCount ));
								
								
							}
						
						%>
						
						
					
							</td>
						
							
		<%
						}
					}
		%>
			</tr>
		<%			previous		=		user_id_value;

			}
		%>
		</table>
		<input type="hidden" 	name="interface_to_external_po_yn" id="interface_to_external_po_yn"			value="<%=interface_to_external_po_yn%>">
		</form>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		
		out.println(CommonBean.setForm ( request ,"../../eST/jsp/UserAccessForStoreQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}finally{
		sqlMap.clear();	
		funcMap.clear();
		displayFields.clear();
		chkFields.clear();		
		result.clear();		
		records.clear();
		con.close();
	}
%>
</body>

</html>

