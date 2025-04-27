<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
21/04/2016		56060			B.Badmavathi					 	PMG2015-CRF-INT-ST-0001	Authorize at Issue Store Privilges
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,java.lang.*,eCommon.XSSRequestWrapper "  contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
				String locale			=	(String)session.getAttribute("LOCALE");
				String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/AuthorizeAtIssueStore.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<form name="formRIAuthorizeQueryResult" id="formRIAuthorizeQueryResult">
	<%
		String bean_id				=		"authorizeAtIssueStoreBean";
		String bean_name			=		"eST.AuthorizeAtIssueStoreBean";
		AuthorizeAtIssueStoreBean bean  =	(AuthorizeAtIssueStoreBean) getBeanObject(bean_id, bean_name,request); 
		String doc_type_code		=		request.getParameter("doc_type_code");
		String doc_no				=		request.getParameter("doc_no");
		String from_doc_date		=		request.getParameter("from_doc_date");
		//from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		
		String to_doc_date			=		request.getParameter("to_doc_date");
		//to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
		

		String request_by_store		=		request.getParameter("request_by_store");
		String request_on_store		=		request.getParameter("request_on_store");
		String item_class_code		=		request.getParameter("item_class_code");
		String request_type			=		request.getParameter("request_type");
		String request_status		=		request.getParameter("request_status");
		String req_status			=		"";
		String language_id			=		request.getParameter("language_id");
		String facility_check		=		"";
		//String request_status		=		request.getParameter("request_status");
	    String item_code = request.getParameter("item_code");
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
		String classvalue			=		"";
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		
		try{
		   //Added by Rabbani #inc no :29579 on 20/01/12
	   if(from_doc_date!= "") 
	   from_doc_date = com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
       else
	      from_doc_date		=	"";
		   
	       if(to_doc_date!= "") 
	      to_doc_date = com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
		  else 
	         to_doc_date		=	"";
 
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_no					=		CommonBean.checkForNull(doc_no,"%");
			doc_type_code			=		CommonBean.checkForNull(doc_type_code,"%");
			//from_doc_date			=		CommonBean.checkForNull(from_doc_date,"");
			//to_doc_date				=		CommonBean.checkForNull(to_doc_date,"");
			request_by_store		=		CommonBean.checkForNull(request_by_store,"%");
			request_on_store		=		CommonBean.checkForNull(request_on_store,"%");
			item_class_code			=		CommonBean.checkForNull(item_class_code,"%");
			request_type			=		CommonBean.checkForNull(request_type,"%");
			item_code               =       CommonBean.checkForNull(item_code,"%");
			request_status          =       CommonBean.checkForNull(request_status,"%").trim();
           
			//sqlMap.put("sqlData", "SELECT HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC,HDR.DOC_NO, TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') DOC_DATE, HDR.REQ_BY_STORE_CODE,  RBYS.SHORT_DESC REQ_BY_STORE_DESC,HDR.REQ_ON_STORE_CODE, RONS.SHORT_DESC REQ_ON_STORE_DESC, HDR.ITEM_CLASS_CODE, ITM.SHORT_DESC ITEM_CLASS_DESC,DECODE ((ST_REQ_STATUS_CHK(HDR.FACILITY_ID,                    HDR.DOC_TYPE_CODE, HDR.DOC_NO )),'PAI','Partially Authorised/Issued At Issue Store','PA', 'Partially Authorised At Issue Store','FAPI','Fully Authorised/Partially Issued At Issue Store', 'FA','FULLY Authorised At Issue Store','C','Issue Canceled', 'L','Issue Closed', 'A','Authorised At Issue Store','W','Authorised At Request By Store') REQUEST_STATUS, HDR.FACILITY_ID REQ_STORE_FACILITY_ID, SM.FACILITY_NAME REQ_STORE_FACILITY_NAME FROM ST_REQUEST_HDR HDR, MM_STORE_LANG_VW RBYS,MM_STORE_LANG_VW RONS, MM_ITEM_CLASS_LANG_VW ITM, SY_DOC_TYPE_MASTER_LANG_VW SY, ST_USER_ACCESS_FOR_STORE UACA, ST_STORE UACB, ST_ACC_ENTITY_PARAM STP  , SM_FACILITY_PARAM_LANG_VW SM, ST_REQUEST_DTL DTL, MM_ITEM_LANG_VW MMVW WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE  AND HDR.REQ_BY_STORE_CODE=  RBYS.STORE_CODE AND  HDR.REQ_ON_STORE_CODE = RONS.STORE_CODE  AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+) AND HDR.CANCELLED_BY_ID IS NULL  AND HDR.REQ_AUTHORIZED_BY_ID IS NOT NULL AND HDR.DOC_TYPE_CODE LIKE ? AND TO_CHAR(HDR.DOC_NO) LIKE  ?  AND (HDR.DOC_DATE BETWEEN TO_DATE(NVL(?,'01/01/1901'),'DD/MM/YYYY') AND TO_DATE(NVL(?,'31/12/3012'),'DD/MM/YYYY'))  AND HDR.REQ_BY_STORE_CODE LIKE ? AND HDR.REQ_ON_STORE_CODE LIKE ? AND  NVL(HDR.ITEM_CLASS_CODE,'X') LIKE ?  AND UACA.USER_ID = ? AND UACA.STORE_CODE = HDR.REQ_ON_STORE_CODE AND UACA.ISS_ALLOWED_YN = 'Y'  AND DOC_SRL_NO = (SELECT MIN(DOC_SRL_NO)  FROM ST_REQUEST_DTL WHERE FACILITY_ID = DTL.FACILITY_ID AND   DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND   DOC_NO = DTL.DOC_NO)/*AND UACB.USER_ID = UACA.USER_ID*/ AND UACB.STORE_CODE = HDR.REQ_BY_STORE_CODE AND UACB.REQ_ALLOWED_YN = 'Y'  AND ST_REQ_ISSUE_CHK(HDR.FACILITY_ID, HDR.DOC_TYPE_CODE, HDR.DOC_NO)<>'2'  AND RBYS.EXTERNAL_YN LIKE DECODE(?,'Y','Y','N','N','%') AND HDR.TRN_TYPE = 'ISS' AND ST_REQ_STATUS_CHK (HDR.FACILITY_ID, HDR.DOC_TYPE_CODE, HDR.DOC_NO) LIKE ? AND  ST_REQ_STATUS_CHK (HDR.FACILITY_ID, HDR.DOC_TYPE_CODE, HDR.DOC_NO) <> 'FA' AND HDR.REQUEST_STATUS NOT IN('C','L','E') AND RONS.FACILITY_ID = ? /*(HDR.FACILITY_ID LIKE DECODE(TRN_ACROSS_FACILITY_YN,'Y','%',?))*/ AND HDR.FACILITY_ID = SM.FACILITY_ID  AND RBYS.LANGUAGE_ID = RONS.LANGUAGE_ID AND RBYS.LANGUAGE_ID = SY.LANGUAGE_ID AND RBYS.LANGUAGE_ID = SM.LANGUAGE_ID AND RBYS.LANGUAGE_ID = ? AND ITM.LANGUAGE_ID(+) = ? AND STP.ACC_ENTITY_ID = 'ZZ' AND RBYS.FACILITY_ID LIKE DECODE (TRN_ACROSS_FACILITY_YN,'Y', '%', ?) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = MMVW.ITEM_CODE  AND MMVW.LANGUAGE_ID = RBYS.LANGUAGE_ID  AND  DTL.COMMITTED_ITEM_QTY = 0 AND DTL.ITEM_CODE LIKE ? AND DTL.ITEM_CODE NOT IN (SELECT DISTINCT ITEM_CODE FROM ST_ISSUE_DTL IDTL, ST_ISSUE_HDR IHDR WHERE IHDR.DOC_NO = IDTL.DOC_NO AND IHDR.DOC_TYPE_CODE = IDTL.DOC_TYPE_CODE AND IHDR.FACILITY_ID = IDTL.FACILITY_ID AND IHDR.SEQ_NO = IDTL.SEQ_NO AND IHDR.DOC_NO = HDR.DOC_NO AND IHDR.FINALIZED_YN = 'D' AND IHDR.FACILITY_ID = ?)");
			//sqlMap.put("sqlData", "SELECT HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC,HDR.DOC_NO, TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') DOC_DATE, HDR.REQ_BY_STORE_CODE,  RBYS.SHORT_DESC REQ_BY_STORE_DESC,HDR.REQ_ON_STORE_CODE, RONS.SHORT_DESC REQ_ON_STORE_DESC, HDR.ITEM_CLASS_CODE, ITM.SHORT_DESC ITEM_CLASS_DESC,ST_REQ_STATUS_CHK(HDR.FACILITY_ID,HDR.DOC_TYPE_CODE, HDR.DOC_NO) REQUEST_STATUS, HDR.FACILITY_ID REQ_STORE_FACILITY_ID, SM.FACILITY_NAME REQ_STORE_FACILITY_NAME  FROM ST_REQUEST_HDR HDR, MM_STORE_LANG_VW RBYS,MM_STORE_LANG_VW RONS, MM_ITEM_CLASS_LANG_VW ITM, SY_DOC_TYPE_MASTER_LANG_VW SY, ST_USER_ACCESS_FOR_STORE UACA, ST_STORE UACB, ST_ACC_ENTITY_PARAM STP  , SM_FACILITY_PARAM_LANG_VW SM, ST_REQUEST_DTL DTL, MM_ITEM_LANG_VW MMVW WHERE    (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')) AND HDR.DOC_TYPE_CODE LIKE ?   AND HDR.REQ_BY_STORE_CODE LIKE ? AND  TO_CHAR (HDR.DOC_NO) LIKE ?  AND HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE   AND HDR.REQ_BY_STORE_CODE = RBYS.STORE_CODE   AND HDR.REQ_ON_STORE_CODE = RONS.STORE_CODE   AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+)   AND HDR.CANCELLED_BY_ID IS NULL   AND HDR.REQ_AUTHORIZED_BY_ID IS NOT NULL     AND HDR.REQ_ON_STORE_CODE LIKE ?   AND NVL (HDR.ITEM_CLASS_CODE, 'X') LIKE ?   AND UACA.USER_ID = ?   AND UACA.STORE_CODE = HDR.REQ_ON_STORE_CODE   AND UACA.ISS_ALLOWED_YN = 'Y'   AND DOC_SRL_NO = (SELECT MIN (DOC_SRL_NO) FROM ST_REQUEST_DTL            WHERE FACILITY_ID = DTL.FACILITY_ID AND DOC_NO = DTL.DOC_NO  AND DOC_TYPE_CODE = DTL.DOC_TYPE_CODE) /*AND UACB.USER_ID = UACA.USER_ID*/  AND UACB.STORE_CODE = HDR.REQ_BY_STORE_CODE  AND UACB.REQ_ALLOWED_YN = 'Y'   AND ST_REQ_ISSUE_CHK (HDR.FACILITY_ID, HDR.DOC_TYPE_CODE, HDR.DOC_NO) <> '2'   AND RBYS.EXTERNAL_YN LIKE DECODE( ?, 'Y', 'Y', 'N', 'N', '%')   AND HDR.TRN_TYPE = 'ISS'   AND HDR.REQUEST_STATUS NOT IN ('C', 'L', 'E')   AND RONS.FACILITY_ID =          ?/*(HDR.FACILITY_ID LIKE DECODE(stp.trn_across_facility_yn,'Y','%',''))*/   AND HDR.FACILITY_ID = SM.FACILITY_ID   AND RBYS.LANGUAGE_ID = RONS.LANGUAGE_ID   AND RBYS.LANGUAGE_ID = SY.LANGUAGE_ID   AND RBYS.LANGUAGE_ID = SM.LANGUAGE_ID   AND RBYS.LANGUAGE_ID =?   AND ITM.LANGUAGE_ID(+) =?   AND STP.ACC_ENTITY_ID = 'ZZ'   AND RBYS.FACILITY_ID LIKE DECODE (TRN_ACROSS_FACILITY_YN, 'Y', '%', ?)  AND HDR.DOC_NO = DTL.DOC_NO   AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE   AND HDR.FACILITY_ID = DTL.FACILITY_ID   AND DTL.ITEM_CODE = MMVW.ITEM_CODE   AND MMVW.LANGUAGE_ID = RBYS.LANGUAGE_ID   AND DTL.COMMITTED_ITEM_QTY = 0   AND DTL.ITEM_CODE LIKE ?   AND NOT EXISTS (  SELECT 'X' FROM ST_ISSUE_DTL IDTL, ST_ISSUE_HDR IHDR           WHERE IHDR.FACILITY_ID = IDTL.FACILITY_ID  AND IHDR.DOC_NO = IDTL.DOC_NO AND IHDR.DOC_TYPE_CODE = IDTL.DOC_TYPE_CODE             AND IHDR.DOC_NO = HDR.DOC_NO AND IHDR.SEQ_NO = IDTL.SEQ_NO             AND IDTL.ITEM_CODE = DTL.ITEM_CODE AND IHDR.FINALIZED_YN = 'D' AND IHDR.FACILITY_ID = ?)");
			//out.println("AuthorizeQuery");
			//this is commented for authorization restriction at two different facility by gangadharan and sakti on 15/06/2011 against INC27786 
			//sqlMap.put("sqlData","SELECT distinct hdr.doc_type_code, 	   (SELECT short_desc FROM sy_doc_type_master_lang_vw WHERE hdr.doc_type_code = doc_type_code AND language_id = ?)doc_type_desc, 	   hdr.doc_no,        TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date, 	   hdr.req_by_store_code,        rbys.short_desc req_by_store_desc, 	   hdr.req_on_store_code,        (SELECT short_desc FROM mm_store_lang_vw WHERE hdr.req_on_store_code = store_code AND language_id = ?)req_on_store_desc, 	   hdr.item_class_code,        (SELECT short_desc FROM mm_item_class_lang_vw WHERE hdr.item_class_code = item_class_code AND language_id =?)  item_class_desc,        st_req_status_chk (hdr.facility_id,                           hdr.doc_type_code,                           hdr.doc_no                          ) request_status,        hdr.facility_id req_store_facility_id,        (SELECT facility_name FROM sm_facility_param_lang_vw WHERE hdr.facility_id = facility_id AND language_id = ? )req_store_facility_name   FROM st_request_hdr hdr,        mm_store_lang_vw rbys,        st_user_access_for_store uaca,        st_store uacb,        st_acc_entity_param stp,        st_request_dtl dtl  WHERE (hdr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')                          AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')        )    AND hdr.doc_type_code LIKE ?    AND hdr.req_by_store_code LIKE ?    AND TO_CHAR (hdr.doc_no) LIKE ?    AND hdr.req_by_store_code = rbys.store_code    AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL    AND hdr.req_on_store_code LIKE ?    AND NVL (hdr.item_class_code, 'X') LIKE ?    AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uaca.iss_allowed_yn = 'Y'   /* AND doc_srl_no =           (SELECT MIN (doc_srl_no)              FROM st_request_dtl             WHERE facility_id = dtl.facility_id               AND doc_no = dtl.doc_no               AND doc_type_code = dtl.doc_type_code) */   AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'    AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>                                                                            '2'    AND rbys.external_yn LIKE DECODE (?, 'Y', 'Y', 'N', 'N', '%')    AND hdr.trn_type = 'ISS'    AND hdr.request_status NOT IN ('C', 'L', 'E')    AND rbys.language_id =?    AND stp.acc_entity_id ='ZZ'    AND rbys.facility_id LIKE DECODE (trn_across_facility_yn, 'Y', '%',?)    AND hdr.doc_no = dtl.doc_no    AND hdr.doc_type_code = dtl.doc_type_code    AND hdr.facility_id = dtl.facility_id    AND dtl.committed_item_qty = 0    AND dtl.item_code LIKE ?    AND NOT EXISTS (           SELECT 'X'             FROM st_issue_dtl idtl, st_issue_hdr ihdr            WHERE ihdr.facility_id = idtl.facility_id              AND ihdr.doc_no = idtl.doc_no              AND ihdr.doc_type_code = idtl.doc_type_code              AND ihdr.doc_no = hdr.doc_no              AND ihdr.seq_no = idtl.seq_no             /* AND idtl.item_code = dtl.item_code*/              AND ihdr.finalized_yn = 'D'              AND ihdr.facility_id = ? )");
			//Commented By Rabbani against inc no: 30966 on 16/03/2012
			//sqlMap.put("sqlData","SELECT distinct hdr.doc_type_code, 	   (SELECT short_desc FROM sy_doc_type_master_lang_vw WHERE hdr.doc_type_code = doc_type_code AND language_id = ?)doc_type_desc, 	   hdr.doc_no,        TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date, 	   hdr.req_by_store_code,        rbys.short_desc req_by_store_desc, 	   hdr.req_on_store_code,        (SELECT short_desc FROM mm_store_lang_vw WHERE hdr.req_on_store_code = store_code AND language_id = ?)req_on_store_desc, 	   hdr.item_class_code,        (SELECT short_desc FROM mm_item_class_lang_vw WHERE hdr.item_class_code = item_class_code AND language_id =?)  item_class_desc,        st_req_status_chk (hdr.facility_id,                           hdr.doc_type_code,                           hdr.doc_no                          ) request_status,        hdr.facility_id req_store_facility_id,        (SELECT facility_name FROM sm_facility_param_lang_vw WHERE hdr.facility_id = facility_id AND language_id = ? )req_store_facility_name   FROM st_request_hdr hdr,        mm_store_lang_vw rbys,        st_user_access_for_store uaca,        st_store uacb,        st_acc_entity_param stp,        st_request_dtl dtl  WHERE (hdr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')                          AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')        )    AND hdr.doc_type_code LIKE ?    AND hdr.req_by_store_code LIKE ?    AND TO_CHAR (hdr.doc_no) LIKE ?    AND hdr.req_by_store_code = rbys.store_code    AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL    AND hdr.req_on_store_code LIKE ?    AND NVL (hdr.item_class_code, 'X') LIKE ?    AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uaca.iss_allowed_yn = 'Y'   /* AND doc_srl_no =           (SELECT MIN (doc_srl_no)              FROM st_request_dtl             WHERE facility_id = dtl.facility_id               AND doc_no = dtl.doc_no               AND doc_type_code = dtl.doc_type_code) */   AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'    AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>                                                                            '2'    AND rbys.external_yn LIKE DECODE (?, 'Y', 'Y', 'N', 'N', '%')    AND hdr.trn_type = 'ISS'    AND hdr.request_status NOT IN ('C', 'L', 'E')    AND rbys.language_id =?    AND stp.acc_entity_id ='ZZ'    AND rbys.facility_id LIKE DECODE (trn_across_facility_yn, 'Y', '%',?)    AND hdr.doc_no = dtl.doc_no    AND hdr.doc_type_code = dtl.doc_type_code    AND hdr.facility_id = dtl.facility_id    AND dtl.committed_item_qty = 0    AND dtl.item_code LIKE ?    AND NOT EXISTS (           SELECT 'X'             FROM st_issue_dtl idtl, st_issue_hdr ihdr            WHERE ihdr.facility_id = idtl.facility_id              AND ihdr.doc_no = idtl.doc_no              AND ihdr.doc_type_code = idtl.doc_type_code              AND ihdr.doc_no = hdr.doc_no              AND ihdr.seq_no = idtl.seq_no             /* AND idtl.item_code = dtl.item_code*/              AND ihdr.finalized_yn = 'D'              AND ihdr.facility_id = ? )  	and exists ( select facility_id from mm_store where store_code = hdr.req_on_store_code    and facility_id = ?) ");
			
			
			//Added  By Rabbani against inc no: 30966 on 16/03/2012
			//commented by Rabbani on 19-MAR-2013 for Performance issue
			//sqlMap.put("sqlData","SELECT distinct hdr.doc_type_code, 	   (SELECT short_desc FROM sy_doc_type_master_lang_vw WHERE hdr.doc_type_code = doc_type_code AND language_id = ?)doc_type_desc, 	   hdr.doc_no,        TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date, 	   hdr.req_by_store_code,        rbys.short_desc req_by_store_desc, 	   hdr.req_on_store_code,        (SELECT short_desc FROM mm_store_lang_vw WHERE hdr.req_on_store_code = store_code AND language_id = ?)req_on_store_desc, 	   hdr.item_class_code,        (SELECT short_desc FROM mm_item_class_lang_vw WHERE hdr.item_class_code = item_class_code AND language_id =?)  item_class_desc,        st_req_status_chk (hdr.facility_id,                           hdr.doc_type_code,                           hdr.doc_no                          ) request_status,        hdr.facility_id req_store_facility_id,        (SELECT facility_name FROM sm_facility_param_lang_vw WHERE hdr.facility_id = facility_id AND language_id = ? )req_store_facility_name   FROM st_request_hdr hdr,        mm_store_lang_vw rbys,        st_user_access_for_store uaca,        st_store uacb,        st_acc_entity_param stp,        st_request_dtl dtl  WHERE (hdr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')                          AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')        )    AND hdr.doc_type_code LIKE ?    AND hdr.req_by_store_code LIKE ?    AND TO_CHAR (hdr.doc_no) LIKE ?    AND hdr.req_by_store_code = rbys.store_code    AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL    AND hdr.req_on_store_code LIKE ?    AND NVL (hdr.item_class_code, 'X') LIKE ?    AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uaca.iss_allowed_yn = 'Y'   /* AND doc_srl_no =           (SELECT MIN (doc_srl_no)              FROM st_request_dtl             WHERE facility_id = dtl.facility_id               AND doc_no = dtl.doc_no               AND doc_type_code = dtl.doc_type_code) */   AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'    AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>                                                                            '2'    AND rbys.external_yn LIKE DECODE (?, 'Y', 'Y', 'N', 'N', '%')    AND hdr.trn_type = 'ISS'    AND hdr.request_status NOT IN ('C', 'L', 'E')    AND rbys.language_id =?    AND stp.acc_entity_id ='ZZ'    AND rbys.facility_id LIKE DECODE (trn_across_facility_yn, 'Y', '%',?)    AND hdr.doc_no = dtl.doc_no    AND hdr.doc_type_code = dtl.doc_type_code    AND hdr.facility_id = dtl.facility_id    AND dtl.committed_item_qty = 0    AND dtl.item_code LIKE ?    AND NOT EXISTS (           SELECT 'X'             FROM st_issue_dtl idtl, st_issue_hdr ihdr            WHERE ihdr.facility_id = idtl.facility_id              AND ihdr.doc_no = idtl.doc_no              AND ihdr.doc_type_code = idtl.doc_type_code              AND ihdr.doc_no = hdr.doc_no              AND ihdr.seq_no = idtl.seq_no             /* AND idtl.item_code = dtl.item_code*/              AND ihdr.finalized_yn = 'D'              AND ihdr.facility_id = ? )  	and exists ( select facility_id from mm_store where store_code = hdr.req_on_store_code    and facility_id = ?)  AND (st_req_status_chk (hdr.facility_id,hdr.doc_type_code,hdr.doc_no )) LIKE ? ");
			
			//Added by Rabbani on 19-MAR-2013 For Performance issue Starts
			String  sql  = " SELECT distinct hdr.doc_type_code,(SELECT short_desc FROM sy_doc_type_master_lang_vw WHERE hdr.doc_type_code = doc_type_code AND language_id = ?)doc_type_desc,  hdr.doc_no,  TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date, 	   hdr.req_by_store_code, rbys.short_desc req_by_store_desc, 	   hdr.req_on_store_code, (SELECT short_desc FROM mm_store_lang_vw WHERE hdr.req_on_store_code = store_code AND language_id = ?)req_on_store_desc, hdr.item_class_code,  (SELECT short_desc FROM mm_item_class_lang_vw WHERE hdr.item_class_code = item_class_code AND language_id =?)  item_class_desc,  st_req_status_chk (hdr.facility_id,  hdr.doc_type_code, hdr.doc_no) request_status, hdr.facility_id req_store_facility_id, (SELECT facility_name FROM sm_facility_param_lang_vw WHERE hdr.facility_id = facility_id AND language_id = ? )req_store_facility_name   FROM st_request_hdr hdr, mm_store_lang_vw rbys, st_user_access_for_store uaca, st_store uacb,        st_acc_entity_param stp,  st_request_dtl dtl  WHERE   hdr.trn_type = 'ISS' ";
			
			chkFields.add(language_id);
		    chkFields.add(language_id);
		    chkFields.add(language_id);
		    chkFields.add(language_id);
			if(!(from_doc_date.equals("")) && !(to_doc_date.equals(""))){
			sql = sql +"  AND (hdr.doc_date BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY'))";
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			}
			else if(from_doc_date.equals("") && !(to_doc_date.equals("") )){
			sql = sql +" AND (hdr.doc_date BETWEEN TO_DATE ('01/01/1901', 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY'))";
			chkFields.add(to_doc_date);
			}
			else if(!(from_doc_date.equals("")) && (to_doc_date.equals("") )){
			sql = sql +" AND (hdr.doc_date BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND SYSDATE)";
			chkFields.add(from_doc_date);
			}

			if(!(doc_type_code.equals("%"))){
			 sql = sql + " and hdr.doc_type_code = ? " ;
			 chkFields.add(doc_type_code);
			}
			if(!(request_by_store.equals("%"))){
			sql = sql + " and hdr.req_by_store_code = ? " ;
			chkFields.add(request_by_store);
			}
			if(!(doc_no.equals("%"))){
			sql = sql + " and TO_CHAR (hdr.doc_no) = ? " ;
			chkFields.add(doc_no);
			}
			sql = sql + " and hdr.req_by_store_code = rbys.store_code    AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL";
			if(!(request_on_store.equals("%"))){
			sql = sql + " and hdr.req_on_store_code = ? " ;
			chkFields.add(request_on_store);
			}
			if(!(item_class_code.equals("%"))){
			sql = sql + " and NVL (hdr.item_class_code, 'X') = ? " ;
			chkFields.add(item_class_code);
			}
			//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts
			if(bean.getAllow_Auth_Issue_store().equals("N")){
				sql = sql + " AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uaca.iss_allowed_yn = 'Y'    AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'    AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>  '2' ";
			}else{ 
				sql = sql + " AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'   and UACA.AUTHORIZE_AT_ISSUE_ALLOWED_YN ='Y'  AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>  '2' ";
			}
			//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends
 		        chkFields.add(CommonBean.getLoginById());
			
			if((request_type.equals("N")))
			sql = sql + " AND rbys.external_yn = 'N' " ;
			else if((request_type.equals("Y")))
			sql = sql + " AND rbys.external_yn = 'Y' " ;
			
			sql = sql + "  AND hdr.request_status NOT IN ('C', 'L', 'E')    AND rbys.language_id =?  ";   
			chkFields.add(language_id);
			
			String trn_across_facility_yn =		bean.checkForNull((String)bean.fetchRecord("select  trn_across_facility_yn  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("TRN_ACROSS_FACILITY_YN"),"N");
			
			if(trn_across_facility_yn.equals("N")){
            sql = sql + "  AND rbys.facility_id =  ? ";
		    chkFields.add(CommonBean.getLoginFacilityId());
            }			
			sql = sql + "   AND hdr.doc_no = dtl.doc_no    AND hdr.doc_type_code = dtl.doc_type_code    AND hdr.facility_id = dtl.facility_id  AND  dtl.committed_item_qty = 0   ";//Removed hdr.CANCEL_AUTHORIZED_BY_ID is not null mo-gn-scf-5575
		  
			if(!(item_code.equals("%"))){
			sql = sql + " and dtl.item_code = ? " ;
			chkFields.add(item_code);
			}  //commented by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013
			sql = sql + " /*AND NOT EXISTS (SELECT 'X'  FROM st_issue_dtl idtl, st_issue_hdr ihdr  WHERE ihdr.facility_id = idtl.facility_id AND ihdr.doc_no = idtl.doc_no  AND ihdr.doc_type_code = idtl.doc_type_code  AND ihdr.doc_type_code = hdr.doc_type_code  AND ihdr.doc_no = hdr.doc_no  AND ihdr.seq_no = idtl.seq_no  AND ihdr.finalized_yn = 'D'  AND ihdr.facility_id = ? )  */	and exists ( select facility_id from mm_store where store_code = hdr.req_on_store_code  and facility_id = ?  ) AND DTL.PENDING_ITEM_QTY >  0"; //and facility_id = ? reverted for mo-gn-scf-
			System.out.println(CommonBean.getLoginFacilityId());
	        //chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(CommonBean.getLoginFacilityId());  
			
			if(!(request_status.equals("%"))){
			sql = sql + " AND (st_req_status_chk (hdr.facility_id,hdr.doc_type_code,hdr.doc_no )) = ? " ;
			chkFields.add(request_status);  
			} 
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("REQ_BY_STORE_DESC");
			displayFields.add("REQ_ON_STORE_DESC");
			displayFields.add("ITEM_CLASS_CODE");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("REQ_BY_STORE_CODE");
			displayFields.add("REQ_ON_STORE_CODE");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("REQUEST_STATUS");
			displayFields.add("REQ_STORE_FACILITY_ID");
			displayFields.add("REQ_STORE_FACILITY_NAME");
			displayFields.add("DOC_TYPE_CODE");
			
			  
		    /*chkFields.add(language_id);
		    chkFields.add(language_id);
		    chkFields.add(language_id);
		    chkFields.add(language_id);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(doc_type_code);
            chkFields.add(request_by_store);
			chkFields.add(doc_no);
			chkFields.add(request_on_store);
			chkFields.add(item_class_code);
			chkFields.add(CommonBean.getLoginById());			
			chkFields.add(request_type);			
			chkFields.add(language_id);
		    chkFields.add(CommonBean.getLoginFacilityId());
   			chkFields.add(item_code);
	        chkFields.add(CommonBean.getLoginFacilityId());*/
			//chkFields.add(CommonBean.getLoginFacilityId()); //added by gangadharan and Sakti 15/06/2011  against INC27786 
			//chkFields.add(request_status); //Added  By Rabbani against inc no: 30966 on 16/03/2012 

		   //out.println("sqlMap = > "+sqlMap);
		    sqlMap.put("sqlData",sql);
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
            result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			
			int recCount=0,i = 0;
			//Commented  By Rabbani against inc no: 30966 on 16/03/2012
			/*for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				records=(ArrayList) result.get(recCount);
				if(((String)records.get(10)).equals("FA")){
					result.remove(recCount);
					continue;
				}
				if(!(request_status.equals("%")) && !((String)records.get(10)).equals(request_status)){
					result.remove(recCount);
					continue;
				}
			} */
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" >
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%=result.get(1)%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align="center">
				<tr>
				    <th>&nbsp;</th>
					<th width='260'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="eST.ReqStatus.label" bundle="${st_labels}"/></th>
				</tr>	
				
		<%
			for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				if (recCount % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;
				
			

				records=(ArrayList) result.get(recCount);
				if ( ! (facility_check.equals(records.get(11))) )
				 {
					facility_check= (String)records.get(11); 
					out.println("<tr><td class='ITEMSELECT' align='left' colspan='8'><b> Facility Name : "+(String)records.get(12)+"</b></td></tr>");
				 } 
				 //'PAI','Partially Authorised/Issued At Issue Store','PA', 'Partially Authorised At Issue Store','FAPI','Fully Authorised/Partially Issued At Issue Store', 'FA','FULLY Authorised At Issue Store','C','Issue Canceled', 'L','Issue Closed', 'A','Authorised At Issue Store','W','Authorised At Request By Store'
				 if(((String)records.get(10)).equals("PAI")){
					 req_status = "Partially Authorised/Issued At Issue Store";
				 }else if(((String)records.get(10)).equals("PA")){
					 req_status = "Partially Authorised At Issue Store";
				 }else if(((String)records.get(10)).equals("FAPI")){
					 req_status = "Fully Authorised/Partially Issued At Issue Store";
				 }else if(((String)records.get(10)).equals("FA")){
					 req_status = "Fully Authorised At Issue Store";
				 }else if(((String)records.get(10)).equals("C")){
					 req_status = "Issue Canceled";
				 }else if(((String)records.get(10)).equals("L")){
					 req_status = "Issue Closed";
				 }else if(((String)records.get(10)).equals("A")){
					 req_status = "Authorised At Issue Store";
				 }else if(((String)records.get(10)).equals("W")){
					 req_status = "Authorised At Request By Store";
				 }
				 %>
				<tr id="tr_<%=i%>">
				 <td class="STLIGHTCREAM" bgcolor="#FFC6AA" onClick="displayRequestDocument('<%=records.get(1)%>','<%=records.get(13)%>');" onmouseover="changeCursor(this);"  ><font class='HYPERLINK'>+</font>
				</td>
				<td class="<%=classvalue%>" onClick="loadRequestDetail(tr_<%=i%>,'<%=facility_check%>');" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(9),"&nbsp;")%></td>
				<td class='NODISPLAY'><%=records.get(6)%></td>
				<td class='NODISPLAY'><%=records.get(5)%></td>
<!-- 				<td class='<%=classvalue%>' nowrap><%=records.get(10)%></td>
 -->				<td class='<%=classvalue%>' nowrap><%=req_status%></td>
			</tr>
		<%
			}
		%>
		</table>
		<input type="hidden" name="checkedIndices" id="checkedIndices"			value="" %>
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"		value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name%>">
	</form>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/RequisitionIssueAuthorizeQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}finally{
		sqlMap.clear();	
		funcMap.clear();
		displayFields.clear();
		chkFields.clear();		
		result.clear();		
		records.clear();		
	}
%>
</body>
</html>

