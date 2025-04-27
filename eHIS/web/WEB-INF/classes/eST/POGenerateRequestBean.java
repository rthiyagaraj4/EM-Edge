/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import eST.Common.StRepository;
import eCommon.Common.CommonRepository;
import eST.PORequest.*;

public class POGenerateRequestBean extends  eST.Common.StTransaction implements java.io.Serializable {

	private String doc_type_code		= "";
	private String doc_no				= "";
	private String doc_date				= "";
	private String defaultStoreCode	    = "";
	private String doc_ref				= "";
	private String effective_date		= "";
	private String requisition_by_store = "";
	private String to_department		= "";
	private String item_from_code		= "";
	private String item_to_code			= "";
	private String finalized_yn			= "";
	private boolean isAutoNo				;
	private String trn_type				= "";
	private String alpha_to_code		= "";
	private String alpha_from_code		= "";
	private String item_class_code		= "";
	private String consignment			= "";
	private ArrayList	alDtlRecords	=	new ArrayList();
	private ArrayList	checkedItem		= new java.util.ArrayList();
	
	public String getAlpha_from_code() {
		return alpha_from_code;
	}

	public void setAlpha_from_code(String alpha_from_code) {
		this.alpha_from_code = alpha_from_code;
	}

	public String getAlpha_to_code() {
		return alpha_to_code;
	}

	public void setAlpha_to_code(String alpha_to_code) {
		this.alpha_to_code = alpha_to_code;
	}

	public String getConsignment() {
		return consignment;
	}

	public void setConsignment(String consignment) {
		this.consignment = consignment;
	}

	public String getDefaultStoreCode() {
		return defaultStoreCode;
	}

	public void setDefaultStoreCode(String defaultStoreCode) {
		this.defaultStoreCode = defaultStoreCode;
	}

	public String getDoc_date() {
		try {
			if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				return getSystemDate();
			} else {
				return doc_date;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return exception.toString();
		}
	}

	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}

	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getDoc_ref() {
		return doc_ref;
	}

	public void setDoc_ref(String doc_ref) {
		this.doc_ref = doc_ref;
	}

	public String getDoc_type_code() {
		return doc_type_code;
	}

	public void setDoc_type_code(String doc_type_code) {
		this.doc_type_code = doc_type_code;
	}

	public String getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	public String getFinalized_yn() {
		return finalized_yn;
	}

	public void setFinalized_yn(String finalized_yn) {
		this.finalized_yn = finalized_yn;
	}

	public boolean isAutoNo() {
		return isAutoNo;
	}

	public void setAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public String getItem_class_code() {
		return item_class_code;
	}

	public void setItem_class_code(String item_class_code) {
		this.item_class_code = item_class_code;
	}

	public String getItem_from_code() {
		return item_from_code;
	}

	public void setItem_from_code(String item_from_code) {
		this.item_from_code = item_from_code;
	}

	public String getItem_to_code() {
		return item_to_code;
	}

	public void setItem_to_code(String item_to_code) {
		this.item_to_code = item_to_code;
	}

	public String getRequisition_by_store() {
		return requisition_by_store;
	}

	public void setRequisition_by_store(String requisition_by_store) {
		this.requisition_by_store = requisition_by_store;
	}

	public String getTo_department() {
		return to_department;
	}

	public void setTo_department(String to_department) {
		this.to_department = to_department;
	}

	public String getTrn_type() {
		return trn_type;
	}

	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}

	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}

	public String getDoc_date_value() {
		 return doc_date;
	}

	public ArrayList getDtlRecords(){
		return this.alDtlRecords;
	}
	public ArrayList getCheckedItem(){
		return this.checkedItem;
	}

	public void initialize(){
		super.initialize();
		this.doc_type_code			="";
		this.doc_no					="";
		this.doc_date				="";
		this.defaultStoreCode		="";
		this.doc_ref				="";
		this.effective_date			="";
		this.requisition_by_store	="";
		this.to_department			="";
		this.item_from_code			="";
		this.item_to_code			="";
		this.finalized_yn			="";
		this.trn_type				="";
		this.alpha_to_code			="";
		this.alpha_from_code		="";
		this.item_class_code		="";
		this.consignment			="";	
		if (checkedItem!= null) {
			checkedItem.clear();
		}
	}
	public void clear(){
		super.clear();
		this.doc_type_code			="";
		this.doc_no					="";
		this.doc_date				="";
		this.defaultStoreCode		="";
		this.doc_ref				="";
		this.effective_date			="";
		this.requisition_by_store	="";
		this.to_department			="";
		this.item_from_code			="";
		this.item_to_code			="";
		this.finalized_yn			="";
		this.trn_type				="";
		this.alpha_to_code			="";
		this.alpha_from_code		="";
		this.item_class_code		="";
		this.consignment			="";	
		if (checkedItem!= null) {
			checkedItem.clear();
		}
	}


	public String getDocTypes() {
		String optionValues = null;
		java.util.ArrayList alPORequesttDoc = new java.util.ArrayList();
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alPORequesttDoc.add(login_facility_id);
		alPORequesttDoc.add("PRQ");
		alPORequesttDoc.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository
				.getStKeyValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),
				alPORequesttDoc);
		if ((doc_type_code != null)) {
			optionValues = getListOptionTag(alOptionValues);
		} else {
			optionValues = getListOptionTag(alOptionValues);
		}
		alPORequesttDoc = null;
		alOptionValues = null;
		return optionValues;
	}

	public String getStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository
				.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT"), alParam);
		optionValues = getListOptionTag(alOptionValues, getDefaultStoreCode());
		alOptionValues = null;
		return optionValues;
	}

	public String getItemAnalysis() {
		return getListOptionTag(getListOptionArrayList(StRepository
				.getStKeyValue("SQL_ST_ITEM_ANALYSIS"), getLanguageId()));
	}
	public java.util.HashMap canAuthorize(String store_code) {
		try {

			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(getLanguageId());
			sqlParameter.add(store_code);
			sqlParameter.add(login_by_id);
			return fetchRecord("SELECT REQ_AUTHORIZE_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN, MM.PO_DEPT_CODE PARENT_STORE_CODE FROM MM_STORE_LANG_VW MM, AM_DEPT_LANG_VW AM,ST_USER_ACCESS_FOR_STORE SU ,ST_STORE ST WHERE  MM.LANGUAGE_ID = AM.LANGUAGE_ID  AND MM.PO_DEPT_CODE =  AM.DEPT_CODE  AND MM.LANGUAGE_ID = ? AND  MM.STORE_CODE = ? AND  SU.STORE_CODE = ST.STORE_CODE AND SU.USER_ID = ? AND SU.STORE_CODE =MM.STORE_CODE ORDER BY 2, 1",sqlParameter);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	public java.util.ArrayList getOnStores(String req_by_store)
			throws Exception {
		ArrayList result = new ArrayList();
		String chkParameters[] = { getLanguageId(), getRequisition_by_store() };
		result = fetchRecords(StRepository.getStKeyValue("SQL_ST_MM_STORE_SELECT"), chkParameters);

		return result;
	}
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws				Exception {
		String chkParameters[] = {request_by_store,getLanguageId()};
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_ITEM_CLASS_STORE_SELECT"),chkParameters);
		return result;
	}
	public void addMultipleRecord(java.util.Hashtable dataTable) {
		int no_of_decimals					=			getNoOfDecimals();
		String viewitems		=	(String) dataTable.get("viewitems");
		ArrayList alParameters	=	new ArrayList();
		alDtlRecords			=	new ArrayList();
		HashMap hmResult		=	new HashMap();
		alParameters.add(getLanguageId());
		alParameters.add(((String) dataTable.get("requisition_by_store")).trim());
	//	alParameters.add(((String) dataTable.get("effective_date")).trim());changed by Badmavathi for SRR20056-SCF-9540
	//	alParameters.add(((String) dataTable.get("effective_date")).trim());
		if(!(getLanguageId().equals("en"))){ //added for SCF-9540
			alParameters.add(com.ehis.util.DateUtils.convertDate(((String)dataTable.get("effective_date")).trim(),"DMY",getLanguageId(),"en"));
			alParameters.add(com.ehis.util.DateUtils.convertDate(((String)dataTable.get("effective_date")).trim(),"DMY",getLanguageId(),"en"));
			}else{
			alParameters.add(((String) dataTable.get("effective_date")).trim());
			alParameters.add(((String) dataTable.get("effective_date")).trim());
			}	
		alParameters.add(((String) dataTable.get("item_from_code")).trim());
		alParameters.add(((String) dataTable.get("item_to_code")).trim());
		alParameters.add(((String) dataTable.get("alpha_from_code")).trim());
		alParameters.add(((String) dataTable.get("alpha_to_code")).trim());
		alParameters.add(((String) dataTable.get("item_class_code")).trim());
		alParameters.add(((String) dataTable.get("item_analysis_1")).trim());
		alParameters.add(((String) dataTable.get("item_analysis_1")).trim());
		alParameters.add(((String) dataTable.get("item_analysis_2")).trim());
		alParameters.add(((String) dataTable.get("item_analysis_2")).trim());
		alParameters.add(((String) dataTable.get("item_analysis_3")).trim());
		alParameters.add(((String) dataTable.get("item_analysis_3")).trim());
		alParameters.add(getLanguageId());
		alParameters.add(((String) dataTable.get("consignment")).trim());
		alParameters.add(((String) dataTable.get("consignment")).trim());
		try {
			if (viewitems.equals("R")) {
				// alRecords =
				// (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_REORDERABLE"),alParameters);
				alDtlRecords = (ArrayList) fetchRecords("SELECT DISTINCT A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS,A.PENDING_PO_REQ_QTY PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_PO_REQ_QTY,0)	,NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN, A.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) UOM_DESC,A.REORDER_QTY, (CASE WHEN ALLOW_DECIMALS_YN = 'Y' AND DISP_DECIMAL_DTLS_YN = 'Y' THEN NO_OF_DECIMALS  ELSE 0 END ) NO_OF_DECIMALS, (CASE  WHEN DISP_DECIMAL_DTLS_YN = 'N' THEN 'N'  ELSE NVL (C.ALLOW_DECIMALS_YN, 'N') END ) ALLOW_DECIMALS_YN  FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM, /*AM_UOM_LANG_VW AM*/ ST_ACC_ENTITY_PARAM PM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND   ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <= DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND     A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S') OR ( NVL(A.QTY_ON_HAND, 0)+NVL(A.PENDING_PO_REQ_QTY,0) <= NVL(A.REORDER_LEVEL,0) AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S'))	/*AND	NVL(A.MAX_STK_QTY, 0) >	0*/ AND A.ITEM_CODE BETWEEN     NVL (	?,'!') AND NVL ( ?,'~')	AND	B.ALPHA_CODE BETWEEN NVL ( UPPER(?),'!') AND NVL (?,'~') AND NVL(B.ITEM_CLASS_CODE,'%') LIKE     NVL(?,'%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?) AND	NVL(B.ITEM_ANAL2_CODE,'%')LIKE     DECODE(?,'','%',?)  AND NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND RE_ORDERABLE_YN = 'Y' AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) /*AND AM.LANGUAGE_ID = B.LANGUAGE_ID AND A.DEF_ISSUE_UOM = AM.UOM_CODE*/ AND PM.ACC_ENTITY_ID = 'ZZ' ORDER	BY UPPER(B.SHORT_DESC)",alParameters);
			} else if (viewitems.equals("N")) {
				// alRecords =
				// (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_NON_STOCK"),alParameters);
				alDtlRecords = (ArrayList) fetchRecords("SELECT DISTINCT A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS, A.PENDING_PO_REQ_QTY PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_PO_REQ_QTY,0),NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN, A.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) UOM_DESC,A.REORDER_QTY REORDER_QTY,( CASE WHEN ALLOW_DECIMALS_YN = 'Y' AND DISP_DECIMAL_DTLS_YN = 'Y' THEN NO_OF_DECIMALS  ELSE 0 END ) NO_OF_DECIMALS, (CASE  WHEN DISP_DECIMAL_DTLS_YN = 'N' THEN 'N'  ELSE NVL (C.ALLOW_DECIMALS_YN, 'N') END ) ALLOW_DECIMALS_YN 	FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,/*AM_UOM_LANG_VW AM*/ ST_ACC_ENTITY_PARAM PM  WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =?  AND ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S'))	/*AND	NVL(A.MAX_STK_QTY, 0) >	0*/ AND A.ITEM_CODE BETWEEN NVL (	?,'!') AND NVL ( ?,'~')	AND	B.ALPHA_CODE BETWEEN NVL ( UPPER(?),'!') AND NVL (	?,'~') AND NVL(B.ITEM_CLASS_CODE,'%') LIKE NVL(?,'%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?)	AND	NVL(B.ITEM_ANAL2_CODE,'%') LIKE DECODE(?,'','%',?) AND  NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND A.STOCK_ITEM_YN = 'N' AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) /* AND AM.LANGUAGE_ID = B.LANGUAGE_ID AND A.DEF_ISSUE_UOM = AM.UOM_CODE*/ AND PM.ACC_ENTITY_ID = 'ZZ' ORDER	BY UPPER(B.SHORT_DESC)",alParameters);
			} else if (viewitems.equals("S")) {
				alParameters.remove(2);
				alParameters.remove(2);
				
				alDtlRecords = (ArrayList) fetchRecords("SELECT ITEM_CODE,ITEM_DESC,DECODE(NVL(MAX_STK_QTY,0),0,REORDER_QTY,REQ_QTY) REQ_QTY,QTY_ON_HAND,MAX_STK_QTY,REORDER_LEVEL,REORDER_FREQ_DAYS,PENDING_REQ_QTY,STOCK_ITEM_YN,UOM_CODE,UOM_DESC,REORDER_QTY,ALLOW_DECIMALS_YN,NO_OF_DECIMALS FROM (SELECT DISTINCT A.ITEM_CODE, B.SHORT_DESC ITEM_DESC, A.QTY_ON_HAND,A.MAX_STK_QTY, A.REORDER_LEVEL, A.REORDER_FREQ_DAYS,A.PENDING_PO_REQ_QTY PENDING_REQ_QTY,DECODE (A.STOCK_ITEM_YN,'Y', NVL (A.MAX_STK_QTY, 0)- NVL (A.QTY_ON_HAND, 0)- NVL (A.PENDING_PO_REQ_QTY, 0),NVL (A.MAX_STK_QTY, 0)) REQ_QTY,A.STOCK_ITEM_YN,A.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) UOM_DESC,A.REORDER_QTY,( CASE WHEN ALLOW_DECIMALS_YN = 'Y' AND DISP_DECIMAL_DTLS_YN = 'Y' THEN NO_OF_DECIMALS  ELSE 0 END ) NO_OF_DECIMALS, (CASE  WHEN DISP_DECIMAL_DTLS_YN = 'N' THEN 'N'  ELSE NVL (C.ALLOW_DECIMALS_YN, 'N') END ) ALLOW_DECIMALS_YN  FROM ST_ITEM_STORE A,MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,/* AM_UOM_LANG_VW AM */ ST_ACC_ENTITY_PARAM PM WHERE A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND B.EFF_STATUS = 'E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE = ?  AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S' AND NVL (A.QTY_ON_HAND, 0) + NVL (A.PENDING_PO_REQ_QTY, 0) <= NVL (A.REORDER_LEVEL, 0) AND A.ITEM_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND B.ALPHA_CODE BETWEEN NVL (UPPER (?), '!') AND NVL (?, '~') AND NVL (B.ITEM_CLASS_CODE, '%') LIKE NVL (?, '%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE DECODE (?, '', '%', ?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE DECODE (?, '', '%', ?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE DECODE (?, '', '%', ?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) = A.ITEM_CODE AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) /*AND AM.LANGUAGE_ID = B.LANGUAGE_ID AND A.DEF_ISSUE_UOM = AM.UOM_CODE */ AND PM.ACC_ENTITY_ID = 'ZZ' ORDER BY UPPER(B.SHORT_DESC))",	alParameters);
			} else {
				// alRecords =
				// (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_ALL"),alParameters);
					alDtlRecords = (ArrayList) fetchRecords("SELECT DISTINCT A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS,A.PENDING_PO_REQ_QTY PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_PO_REQ_QTY,0)	,NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN,  A.DEF_ISSUE_UOM UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) UOM_DESC,A.REORDER_QTY REORDER_QTY, (CASE WHEN ALLOW_DECIMALS_YN = 'Y' AND DISP_DECIMAL_DTLS_YN = 'Y' THEN NO_OF_DECIMALS  ELSE 0 END ) NO_OF_DECIMALS, (CASE  WHEN DISP_DECIMAL_DTLS_YN = 'N' THEN 'N'  ELSE NVL (C.ALLOW_DECIMALS_YN, 'N') END ) ALLOW_DECIMALS_YN 	FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,/* AM_UOM_LANG_VW AM */ ST_ACC_ENTITY_PARAM PM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S') OR (NVL (A.QTY_ON_HAND, 0) + NVL (A.PENDING_PO_REQ_QTY, 0) <= NVL (A.REORDER_LEVEL, 0) AND A.STOCK_ITEM_YN	= 'Y' AND REQUEST_GEN_STAGE = 'S')) /*AND NVL(A.MAX_STK_QTY, 0) >	0 */ AND A.ITEM_CODE BETWEEN NVL (	?,'!') AND NVL ( ?,'~')	AND	B.ALPHA_CODE BETWEEN NVL ( UPPER(?),'!') AND NVL (	?,'~') AND NVL(B.ITEM_CLASS_CODE,'%') LIKE NVL(?,'%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?)	AND	NVL(B.ITEM_ANAL2_CODE,'%')LIKE DECODE(?,'','%',?) AND  NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) /* AND AM.LANGUAGE_ID = B.LANGUAGE_ID AND A.DEF_ISSUE_UOM = AM.UOM_CODE */ AND PM.ACC_ENTITY_ID = 'ZZ' ORDER	BY UPPER(B.SHORT_DESC)",alParameters);
			}

			String req_qty = "";
			for (int i = 0; i < alDtlRecords.size(); i++) {
				hmResult = (HashMap) alDtlRecords.get(i);
				req_qty = (String) hmResult.get("REQ_QTY");
				if (((String) hmResult.get("STOCK_ITEM_YN")).equals("N")) {
					if ((checkForNull((String) hmResult.get("MAX_STK_QTY"), "0")).equals("0")
							&& !(checkForNull((String) hmResult.get("REORDER_QTY"), "0")).equals("0")) {
						req_qty = (String) hmResult.get("REORDER_QTY");
					} else if (!(checkForNull((String) hmResult.get("MAX_STK_QTY"), "0")).equals("0")
							&& (checkForNull((String) hmResult.get("REORDER_QTY"), "0")).equals("0")) {
						req_qty = (String) hmResult.get("MAX_STK_QTY");
					} else if (!(checkForNull((String) hmResult.get("MAX_STK_QTY"), "0")).equals("0")
							&& !(checkForNull((String) hmResult.get("REORDER_QTY"), "0")).equals("0")) {
						req_qty = (String) hmResult.get("REORDER_QTY");
					} else {
						req_qty = "";
					}
				} else {


					if ((checkForNull((String) hmResult.get("MAX_STK_QTY"), "0")).equals("0")) {
						req_qty = checkForNull((String) hmResult.get("REORDER_QTY"), "0");
					}
					if(Double.parseDouble(req_qty)>Double.parseDouble(checkForNull((String) hmResult.get("REORDER_QTY"), "0"))){
						if(!checkForNull((String) hmResult.get("REORDER_QTY"), "0").equals("0")){
							req_qty = checkForNull((String) hmResult.get("REORDER_QTY"), "0");
						}
					}
					if(Double.parseDouble(req_qty)<0){
					req_qty="0";
					}

				}
				if(((String) hmResult.get("ALLOW_DECIMALS_YN")).equals("Y")){
				hmResult.put("REQ_QTY",setNumber(req_qty,no_of_decimals));
				hmResult.put("QTY_ON_HAND",setNumber(checkForNull((String) hmResult.get("QTY_ON_HAND"),"0"),no_of_decimals));
				hmResult.put("PENDING_REQ_QTY",setNumber(checkForNull((String) hmResult.get("PENDING_REQ_QTY"),"0"),no_of_decimals));
				}else{
				hmResult.put("REQ_QTY",setNumber(req_qty,0));
				hmResult.put("QTY_ON_HAND",setNumber(checkForNull((String) hmResult.get("QTY_ON_HAND"),"0"),0));
				hmResult.put("PENDING_REQ_QTY",setNumber(checkForNull((String) hmResult.get("PENDING_REQ_QTY"),"0"),0));
				}
				if(req_qty.length()==0){
				hmResult.put("REQ_QTY",req_qty);
				}
				alDtlRecords.set(i,hmResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public HashMap validate() {

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");
		try {
			int docDateValidation = isValidDocDate(getDoc_date_value());
			if (docDateValidation == 1) {
				resultMap.put("result", new Boolean(false));
				resultMap.put("message",getMessage("ST_DOC_DT_NOT_LT_PROC_MTH"));
			} else if (docDateValidation == 2) {
				resultMap.put("result", new Boolean(false));
				resultMap.put("message", getMessage("ST_DOC_DT_NOT_GR_SYSDATE"));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return resultMap;
	}

	public void setAll(Hashtable htRecordSet) {
		checkedItem.clear();
		setMode((String) htRecordSet.get("mode"));
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setTrn_type((String) htRecordSet.get("trn_type"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date((String) htRecordSet.get("doc_date"));
		setDoc_no((String) htRecordSet.get("doc_no"));

	
		setFinalized_yn((String) htRecordSet.get("finalize_yn"));
		setIsAutoNo(htRecordSet.get("autono_yn").equals(
				eST.Common.StRepository.getStKeyValue("YES")) ? true : false);
		setEffective_date((String) htRecordSet.get("effective_date"));
		setTo_department((String) htRecordSet
				.get("to_department"));
		setRequisition_by_store((String) htRecordSet
				.get("requisition_by_store"));
		setItem_to_code((String) htRecordSet.get("item_to_code"));
		setItem_from_code((String) htRecordSet.get("item_from_code"));
	for(int i=0;i<Integer.parseInt((String)htRecordSet.get("total_checkboxes"));i++){
		if(!((String)htRecordSet.get("req_qty_"+i)).equals("")){
		if(((String)htRecordSet.get("add_itm_"+i)).equals("Y") &&				  Double.parseDouble((String)htRecordSet.get("req_qty_"+i)) > 0){
			checkedItem.add(htRecordSet.get("item_code_"+i));
			checkedItem.add(htRecordSet.get("uom_code_"+i));
			checkedItem.add(htRecordSet.get("req_qty_"+i));
			}

			}
	}

	}
	public HashMap insert() {
		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		ArrayList allanguageData	=	new ArrayList();
		hmResult.put("result", new Boolean(false));
		HashMap porequest=new HashMap();
		String po_req_by="";
		HashMap final_dtl=new HashMap();
		HashMap hmRecord=new HashMap();
		boolean isDocNoAutoGenerated	=	false;
		try{
		 porequest=fetchRecord("select PO_REQ_BY from st_acc_entity_param where ACC_ENTITY_ID=?"		,getAcc_entity_id());
		po_req_by=checkForNull((String)porequest.get("PO_REQ_BY"),"NA");
		hmRecord=	fetchRecord(StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"), getDoc_type_code());
				isDocNoAutoGenerated=	checkForNull((String)hmRecord.get("DOC_NUM_GEN_FLAG"),"N").equals("Y");
		if (!isDocNoAutoGenerated) {
			po_req_by="NA";
			final_dtl=(HashMap)newInsert("NA");
					
		}else if(po_req_by.equals("MG") && new eMM.MM_license_rights().getSTboundary().equals("I")){
			po_req_by="MG";
			final_dtl=newInsert("MG");
		}
		else if(po_req_by.equals("IC")){
			po_req_by="IC";
			final_dtl=newInsert("IC");
		}
		else{
			po_req_by="NA";
			final_dtl=(HashMap)newInsert("NA");
		}

		}catch(Exception e){
			e.printStackTrace();
		}
		

		ArrayList alHdrInsertRecord = new ArrayList();
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getDoc_type_code());
		alHdrInsertRecord.add(getDoc_no());
		alHdrInsertRecord.add(getDoc_date_value());
		alHdrInsertRecord.add(getDoc_ref());
		alHdrInsertRecord.add(""); //material_group_code
		alHdrInsertRecord.add(getItem_class_code());
		alHdrInsertRecord.add(getRequisition_by_store());
		alHdrInsertRecord.add(getTo_department());
		alHdrInsertRecord.add(getFinalized_yn().equals("Yes")?"P":"U");//CURR_STATUS
		alHdrInsertRecord.add(login_by_id);//CURR_STATUS_BY_ID
		alHdrInsertRecord.add("");//CURR_STATUS_REMARKS
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add("R");//request_type
		
		allanguageData.add(getLanguageId());
	
		ArrayList alRequestStatusInsertRecord = new ArrayList();
		alRequestStatusInsertRecord.add(login_facility_id);//FACILITY_ID
		alRequestStatusInsertRecord.add(getDoc_type_code());//DOC_TYPE_CODE
		alRequestStatusInsertRecord.add(getDoc_no());//DOC_NO
		alRequestStatusInsertRecord.add("1");//STATUS_SRL_NO
		alRequestStatusInsertRecord.add(getFinalized_yn().equals("Yes")?"P":"U");//STATUS
		alRequestStatusInsertRecord.add(login_by_id);//STATUS_BY_ID
		alRequestStatusInsertRecord.add("");//STATUS_REMARKS
		alRequestStatusInsertRecord.add(login_by_id);
		alRequestStatusInsertRecord.add(login_at_ws_no);
		alRequestStatusInsertRecord.add(login_facility_id);
		alRequestStatusInsertRecord.add(login_by_id);
		alRequestStatusInsertRecord.add(login_at_ws_no);
		alRequestStatusInsertRecord.add(login_facility_id);

		java.util.ArrayList alUpdateData = new java.util.ArrayList (4);
		alUpdateData.add(login_by_id);
		alUpdateData.add(login_at_ws_no);
		alUpdateData.add(login_facility_id);
		alUpdateData.add(getDoc_type_code());
	
		hmSQLMap.put("InsertHDRSQL", StRepository.getStKeyValue("SQL_ST_PO_REQUEST_HDR_INSERT")); 
		hmSQLMap.put("InsertDTLSQL", StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_INSERT")); 
		hmSQLMap.put("InsertStatusDTLSQL", StRepository.getStKeyValue("SQL_ST_PO_REQUEST_STATUS_INSERT")); 
		hmSQLMap.put("UpdateSQL", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")); 
		hmSQLMap.put("sql_st_records_per_trn_select", StRepository.getStKeyValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertHDRData",alHdrInsertRecord);
		hmTableData.put("alRequestStatusInsertRecord",alRequestStatusInsertRecord);
		hmTableData.put("UpdateData",alUpdateData);
		hmTableData.put("LANGUAGE_DATA",	allanguageData);
		//hmSQLMap.put("UpdateITMSQL", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_UPDATE")); 
		hmSQLMap.put("UpdateITMSQL", "UPDATE ST_ITEM_STORE SET PENDING_PO_REQ_QTY = NVL(PENDING_PO_REQ_QTY,0) +	? ,	MODIFIED_BY_ID = ?,	MODIFIED_DATE =	SYSDATE, MODIFIED_AT_WS_NO = ?,	MODIFIED_FACILITY_ID = ? WHERE STORE_CODE =	? AND  ITEM_CODE = ?"); 
		hmTableData.put("FINAL_DTL",final_dtl);
		hmTableData.put("PO_REQUEST_BY",po_req_by);
		hmTableData.put("ISDOCNOAUTOGENERATED",isDocNoAutoGenerated);
		
		PORequestRemote requestRemote = null;

		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_POGENERATE_REQUEST"), PORequestHome.class,getLocalEJB());
		//Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PORequest", PORequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			String ms_id=(String) hmResult.get( "msgid" );
			if(ms_id.equals("CODE_ALREADY_EXISTS") || ms_id.equals("RECORD_INSERTED") )
			hmResult.put("message",getSTMessage(getLanguageId(),ms_id,"ST") ) ;
			else {
		
			hmResult.put("message","Transcation failed") ;
			}
		}
		catch(Exception e) {
				hmResult.put("message", e.toString());
				e.printStackTrace();
		} 
		finally {
			try {
				if(requestRemote != null)
					requestRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString());
			}
		}
	return hmResult;
	}
public HashMap newInsert(String PORequest_by) {
		String metarial="";
		HashMap final_dtl= new HashMap();
		java.util.ArrayList alUpdateItemData = new ArrayList();
		ArrayList alrec= (ArrayList) getCheckedItem();
		int detailSize = alrec.size();
		HashMap meterial_group = new HashMap();
		ArrayList all_mm_item_code = new ArrayList();
		HashMap ITEM_CODE=new  HashMap();
		ArrayList alDtlInsertRecord = new ArrayList();
	/**
	* @Name - krishna
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function 
	*/

	int no_of_decimals					=			getNoOfDecimals();
	int no_of_decimals_temp				=			getNoOfDecimals();

		for (int index=0,count=0;index<detailSize;index=index+3,count++) {
		try{
			if(PORequest_by.equals("MG")){
				ITEM_CODE=fetchRecord("select MATERIAL_GROUP_CODE from mm_item where ITEM_CODE=?",(String)alrec.get(index));
				metarial=(String)ITEM_CODE.get("MATERIAL_GROUP_CODE");
			}else if(PORequest_by.equals("IC")){
				ITEM_CODE=fetchRecord("select ITEM_CLASS_CODE  from mm_item where ITEM_CODE=?",(String)alrec.get(index));
				metarial=(String)ITEM_CODE.get("ITEM_CLASS_CODE");
			}
		
		
			ArrayList alDtlRecord = new ArrayList();
			alDtlRecord.add(login_facility_id);//FACILITY_ID
			alDtlRecord.add(getDoc_type_code());//DOC_TYPE_CODE
			alDtlRecord.add(getDoc_no());//DOC_NO
			if(PORequest_by.equals("MG") || PORequest_by.equals("IC")){
				
			if(meterial_group.containsKey(metarial)){
				alDtlInsertRecord=(ArrayList)meterial_group.get(metarial);
				alDtlRecord.add(""+(alDtlInsertRecord.size()+1));//DOC_SRL_NO
			}else{
			alDtlRecord.add(""+1);//DOC_SRL_NO
			}
			}else{
			alDtlRecord.add(""+(count+1));//DOC_SRL_NO
			}
	/**
	* @Name - krishna
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/

			if(getAllowDecimalsYN((String)alrec.get(index)).equals("N")){
			no_of_decimals = 0;
			}else{
			no_of_decimals=	no_of_decimals_temp;
			}
			alDtlRecord.add(alrec.get(index));//ITEM_CODE
			alDtlRecord.add(setNumber((String)alrec.get(index+2),no_of_decimals));//REQ_QTY
			alDtlRecord.add(alrec.get(index+1)); //req_uom
			alDtlRecord.add(getConvFactTemp((String)alrec.get(index),getRequisition_by_store()));//REQ_GEN_UOM_CONV_FACTOR
			alDtlRecord.add(setNumber((String)alrec.get(index+2),no_of_decimals));//REQ_GEN_UOM_QTY
			alDtlRecord.add("0"); //grn_qty
			alDtlRecord.add(""); //grn_uom
			alDtlRecord.add(""); //grn_gen_uom_qty
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			if(PORequest_by.equals("MG") || PORequest_by.equals("IC")){
			if(meterial_group.containsKey(metarial)){
			alDtlInsertRecord=(ArrayList)meterial_group.get(metarial);
			alDtlInsertRecord.add(alDtlRecord);	
			}else{
			alDtlInsertRecord = new java.util.ArrayList ();
			alDtlInsertRecord.add(alDtlRecord);	
			all_mm_item_code.add(metarial);
			}
			meterial_group.put(metarial,alDtlInsertRecord);
			}else{
			alDtlInsertRecord.add(alDtlRecord);		
			}
			double pending_qty = Double.parseDouble((String)alrec.get(index+2))/getConvFactTemp((String)alrec.get(index),getRequisition_by_store());
			java.util.ArrayList alUpdRecord = new java.util.ArrayList();
	
			alUpdRecord.add(setNumber(""+pending_qty,no_of_decimals));
			alUpdRecord.add(login_by_id);
			alUpdRecord.add(login_at_ws_no);
			alUpdRecord.add(login_facility_id);			  
			/* The pending req qty has to be updated for the request_by_store */
			alUpdRecord.add(getRequisition_by_store());
			alUpdRecord.add(alrec.get(index));
			alUpdateItemData.add(alUpdRecord);
	
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		if(PORequest_by.equals("MG") || PORequest_by.equals("IC")){
		final_dtl.put("FINAL_DTL",meterial_group);
		final_dtl.put("ALL_MM_ITEM_CODE",all_mm_item_code);
		final_dtl.put("ALUPDATEITEMDATA",alUpdateItemData);

		}else{
		final_dtl.put("FINAL_DTL",alDtlInsertRecord);
		final_dtl.put("ALUPDATEITEMDATA",alUpdateItemData);
		}
		
	return final_dtl;
	}
	public double getConvFactTemp(String item_code,String store_code){
		double conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();

		try {
		
		    alParameters.add(item_code);
			alParameters.add(store_code);

		   conv_fac_temp=Double.parseDouble((String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"));
		}	catch(Exception e){
			//e.printStackTrace();
		}
		return conv_fac_temp;
	}

}


