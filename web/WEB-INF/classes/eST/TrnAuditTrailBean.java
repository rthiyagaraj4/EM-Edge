/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;

import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
import eST.Common.StRepository;
import java.io.Serializable;
import java.util.ArrayList;
public class TrnAuditTrailBean extends StAdapter
implements Serializable
{

	private String trn_type	=	"";
	private String doc_no			="";
	private String deleted_by		="";
	private String doc_date_from	="";
	private String doc_date_to		="";
	private String doc_type_code	="";



	ArrayList deletedDocDetails = null;

	public void setTrn_type(String trn_type){
		this.trn_type = trn_type;
	}
	public String getTrn_type(){
		return this.trn_type;
	}

	public void setDoc_no(String doc_no){
		this.doc_no = doc_no;
	}
	public String getDoc_no(){
		return this.doc_no;
	}

	public void setDeleted_by(String deleted_by){
		this.deleted_by = deleted_by;
	}
	public String getDeleted_by(){
		return this.deleted_by;
	}
	public void setDoc_date_from(String doc_date_from){
		this.doc_date_from = doc_date_from;
	}
	public String getDoc_date_from(){
		return this.doc_date_from;
	}
	
	public void setDoc_date_to(String doc_date_to){
		this.doc_date_to = doc_date_to;
	}
	public String getDoc_date_to(){
		return this.doc_date_to;
	}

	public void setDoc_type_code(String doc_type_code){
		this.doc_type_code = doc_type_code;
	}
	public String getDoc_type_code(){
		return this.doc_type_code;
	}

	public void setDeletedDocDetails(ArrayList deletedDocDetails){
		this.deletedDocDetails=deletedDocDetails;
	}
	public ArrayList getDeletedDocDetails()	{
		return this.deletedDocDetails;
	}
	public void clear() {
		this.deletedDocDetails= null;
	}

	
public String getTrn_type_List(){
		return getListOptionTag(getListOptionArrayList("SELECT   TRN_TYPE, SHORT_DESC FROM ST_TRN_TYPE_LANG_VW TRN WHERE TRN_TYPE IN ('ISS','URG','RET','TFR') AND LANGUAGE_ID = ? ORDER BY DECODE (TRN_TYPE, 'ISS', 1, 'URG', 2, 'RET', 3, 'TFR', 4)",getLanguageId()));
	}
	
public ArrayList getDocTypeArrayList() throws Exception{ 
		ArrayList arraylist = new ArrayList();
        arraylist.add(getTrn_type());
        arraylist.add(getLoginFacilityId());
        arraylist.add(getLanguageId());
		return fetchRecords("SELECT   FACILITY_ID,DOC.DOC_TYPE_CODE, B.SHORT_DESC FROM ST_TRN_DOC_TYPE DOC,SY_DOC_TYPE_MASTER_LANG_VW B, ST_ACC_ENTITY_PARAM PA WHERE DOC.TRN_TYPE = ? AND DOC.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND  FACILITY_ID = ? AND B.LANGUAGE_ID = ? ORDER BY 2,1",arraylist);
	}




	public ArrayList getDeletedDocs(String doc_no,String deleted_by,String doc_date_from,String doc_date_to,String trn_type,String doc_type_code)throws Exception
	{

	ArrayList arraylist = new ArrayList();
	ArrayList deletedDocDetails = new ArrayList();
	arraylist.add(doc_no);
    arraylist.add(getLoginFacilityId());
    arraylist.add(deleted_by);
    arraylist.add(doc_date_from);
    arraylist.add(doc_date_to);
    arraylist.add(getLanguageId());
    arraylist.add(trn_type);
    arraylist.add(doc_type_code);
	arraylist.add(doc_no);
    arraylist.add(getLoginFacilityId());
    arraylist.add(deleted_by);
    arraylist.add(doc_date_from);
    arraylist.add(doc_date_to);
    arraylist.add(getLanguageId());
    arraylist.add(trn_type);
    arraylist.add(doc_type_code);
	arraylist.add(doc_no);
    arraylist.add(getLoginFacilityId());
    arraylist.add(deleted_by);
    arraylist.add(doc_date_from);
    arraylist.add(doc_date_to);
    arraylist.add(getLanguageId());
    arraylist.add(trn_type);
    arraylist.add(doc_type_code);
	

	setDoc_no(doc_no);
    setDeleted_by(deleted_by);
    setDoc_date_from(doc_date_from);
    setDoc_date_to(doc_date_to);
    setTrn_type(trn_type);
    setDoc_type_code(doc_type_code);
   




	 deletedDocDetails= fetchRecords("SELECT  B.SHORT_DESC TRN_DESC, C.SHORT_DESC DOC_DESC,A.DOC_NO DOC_NO, TO_CHAR(TRUNC(A.DOC_DATE),'DD/MM/YYYY') DOC_DATE,D.APPL_USER_NAME CREATED_BY, E.APPL_USER_NAME DELETED_BY,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH:MI') DELETED_DATE_TIME FROM ST_ISSUE_HDR A, ST_TRN_TYPE_LANG_VW B,SY_DOC_TYPE_MASTER_LANG_VW C,SM_APPL_USER_LANG_VW D,SM_APPL_USER_LANG_VW E WHERE FINALIZED_YN = 'D' AND A.TRN_TYPE = B.TRN_TYPE  AND C.DOC_TYPE_CODE=A.DOC_TYPE_CODE AND C.LANGUAGE_ID=B.LANGUAGE_ID AND D.APPL_USER_ID=A.ADDED_BY_ID AND D.LANGUAGE_ID=C.LANGUAGE_ID AND D.EFF_STATUS='E' AND E.APPL_USER_ID=A.MODIFIED_BY_ID AND E.LANGUAGE_ID=B.LANGUAGE_ID AND E.EFF_STATUS='E' AND A.DOC_NO LIKE(?) AND A.FACILITY_ID = ? AND A.MODIFIED_BY_ID LIKE(?)  AND a.DOC_DATE BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND NVL(TO_DATE (?, 'dd/mm/yyyy'),to_date('31/12/9999','dd/mm/yyyy')) AND B.LANGUAGE_ID = ? AND A.TRN_TYPE LIKE(?) AND A.DOC_TYPE_CODE LIKE(?) union all SELECT  B.SHORT_DESC TRN_DESC, C.SHORT_DESC DOC_DESC,A.DOC_NO DOC_NO, TO_CHAR(TRUNC(A.DOC_DATE),'DD/MM/YYYY') DOC_DATE,D.APPL_USER_NAME CREATED_BY, E.APPL_USER_NAME DELETED_BY,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH:MI') DELETED_DATE_TIME FROM st_issue_ret_hdr A, ST_TRN_TYPE_LANG_VW B,SY_DOC_TYPE_MASTER_LANG_VW C,SM_APPL_USER_LANG_VW D,SM_APPL_USER_LANG_VW E WHERE FINALIZED_YN = 'D' AND A.TRN_TYPE = B.TRN_TYPE  AND C.DOC_TYPE_CODE=A.DOC_TYPE_CODE AND C.LANGUAGE_ID=B.LANGUAGE_ID AND D.APPL_USER_ID=A.ADDED_BY_ID AND D.LANGUAGE_ID=C.LANGUAGE_ID AND D.EFF_STATUS='E' AND E.APPL_USER_ID=A.MODIFIED_BY_ID AND E.LANGUAGE_ID=B.LANGUAGE_ID AND E.EFF_STATUS='E' AND A.DOC_NO LIKE(?) AND A.FACILITY_ID = ? AND A.MODIFIED_BY_ID LIKE(?)  AND a.DOC_DATE BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND NVL(TO_DATE (?, 'dd/mm/yyyy'),to_date('31/12/9999','dd/mm/yyyy')) AND B.LANGUAGE_ID = ? AND A.TRN_TYPE LIKE(?) AND A.DOC_TYPE_CODE LIKE(?)  union all  SELECT  B.SHORT_DESC TRN_DESC, C.SHORT_DESC DOC_DESC,A.DOC_NO DOC_NO, TO_CHAR(TRUNC(A.DOC_DATE),'DD/MM/YYYY') DOC_DATE,D.APPL_USER_NAME CREATED_BY, E.APPL_USER_NAME DELETED_BY,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH:MI') DELETED_DATE_TIME FROM st_transfer_hdr A, ST_TRN_TYPE_LANG_VW B,SY_DOC_TYPE_MASTER_LANG_VW C,SM_APPL_USER_LANG_VW D,SM_APPL_USER_LANG_VW E WHERE FINALIZED_YN = 'D' AND A.TRN_TYPE = B.TRN_TYPE  AND C.DOC_TYPE_CODE=A.DOC_TYPE_CODE AND C.LANGUAGE_ID=B.LANGUAGE_ID AND D.APPL_USER_ID=A.ADDED_BY_ID AND D.LANGUAGE_ID=C.LANGUAGE_ID AND D.EFF_STATUS='E' AND E.APPL_USER_ID=A.MODIFIED_BY_ID AND E.LANGUAGE_ID=B.LANGUAGE_ID AND E.EFF_STATUS='E' AND A.DOC_NO LIKE(?) AND A.FACILITY_ID = ? AND A.MODIFIED_BY_ID LIKE(?)  AND a.DOC_DATE BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND NVL(TO_DATE (?, 'dd/mm/yyyy'),to_date('31/12/9999','dd/mm/yyyy')) AND B.LANGUAGE_ID = ? AND A.TRN_TYPE LIKE(?) AND A.DOC_TYPE_CODE LIKE(?)	 ",arraylist);
	 setDeletedDocDetails(deletedDocDetails);
	return deletedDocDetails;
	}

	public void getDeletedDocs(String TTorder,String header){
	try{
	
	ArrayList arraylist = new ArrayList();
	ArrayList deletedDocDetails = new ArrayList();
	arraylist.add(getDoc_no());
    arraylist.add(getLoginFacilityId());
    arraylist.add(getDeleted_by());
    arraylist.add(getDoc_date_from());
    arraylist.add(getDoc_date_to());
    arraylist.add(getLanguageId());
    arraylist.add(getTrn_type());
    arraylist.add(getDoc_type_code());
	arraylist.add(getDoc_no());
    arraylist.add(getLoginFacilityId());
    arraylist.add(getDeleted_by());
    arraylist.add(getDoc_date_from());
    arraylist.add(getDoc_date_to());
    arraylist.add(getLanguageId());
    arraylist.add(getTrn_type());
    arraylist.add(getDoc_type_code());
	arraylist.add(getDoc_no());
    arraylist.add(getLoginFacilityId());
    arraylist.add(getDeleted_by());
    arraylist.add(getDoc_date_from());
    arraylist.add(getDoc_date_to());
    arraylist.add(getLanguageId());
    arraylist.add(getTrn_type());
    arraylist.add(getDoc_type_code());
	String order_by="";
	if(TTorder.equals("") || TTorder.equals("DESC"))
	order_by="order by "+header+" ASC"; 
	else 
	order_by="order by "+header+" DESC";
	 deletedDocDetails= fetchRecords("SELECT  B.SHORT_DESC TRN_DESC, C.SHORT_DESC DOC_DESC,A.DOC_NO DOC_NO, TO_CHAR(TRUNC(A.DOC_DATE),'DD/MM/YYYY') DOC_DATE,D.APPL_USER_NAME CREATED_BY, E.APPL_USER_NAME DELETED_BY,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH:MI') DELETED_DATE_TIME FROM ST_ISSUE_HDR A, ST_TRN_TYPE_LANG_VW B,SY_DOC_TYPE_MASTER_LANG_VW C,SM_APPL_USER_LANG_VW D,SM_APPL_USER_LANG_VW E WHERE FINALIZED_YN = 'D' AND A.TRN_TYPE = B.TRN_TYPE  AND C.DOC_TYPE_CODE=A.DOC_TYPE_CODE AND C.LANGUAGE_ID=B.LANGUAGE_ID AND D.APPL_USER_ID=A.ADDED_BY_ID AND D.LANGUAGE_ID=C.LANGUAGE_ID AND D.EFF_STATUS='E' AND E.APPL_USER_ID=A.MODIFIED_BY_ID AND E.LANGUAGE_ID=B.LANGUAGE_ID AND E.EFF_STATUS='E' AND A.DOC_NO LIKE(?) AND A.FACILITY_ID = ? AND A.MODIFIED_BY_ID LIKE(?)  AND a.DOC_DATE BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND NVL(TO_DATE (?, 'dd/mm/yyyy'),to_date('31/12/9999','dd/mm/yyyy')) AND B.LANGUAGE_ID = ? AND A.TRN_TYPE LIKE(?) AND A.DOC_TYPE_CODE LIKE(?) union all SELECT  B.SHORT_DESC TRN_DESC, C.SHORT_DESC DOC_DESC,A.DOC_NO DOC_NO, TO_CHAR(TRUNC(A.DOC_DATE),'DD/MM/YYYY') DOC_DATE,D.APPL_USER_NAME CREATED_BY, E.APPL_USER_NAME DELETED_BY,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH:MI') DELETED_DATE_TIME FROM st_issue_ret_hdr A, ST_TRN_TYPE_LANG_VW B,SY_DOC_TYPE_MASTER_LANG_VW C,SM_APPL_USER_LANG_VW D,SM_APPL_USER_LANG_VW E WHERE FINALIZED_YN = 'D' AND A.TRN_TYPE = B.TRN_TYPE  AND C.DOC_TYPE_CODE=A.DOC_TYPE_CODE AND C.LANGUAGE_ID=B.LANGUAGE_ID AND D.APPL_USER_ID=A.ADDED_BY_ID AND D.LANGUAGE_ID=C.LANGUAGE_ID AND D.EFF_STATUS='E' AND E.APPL_USER_ID=A.MODIFIED_BY_ID AND E.LANGUAGE_ID=B.LANGUAGE_ID AND E.EFF_STATUS='E' AND A.DOC_NO LIKE(?) AND A.FACILITY_ID = ? AND A.MODIFIED_BY_ID LIKE(?)  AND a.DOC_DATE BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND NVL(TO_DATE (?, 'dd/mm/yyyy'),to_date('31/12/9999','dd/mm/yyyy')) AND B.LANGUAGE_ID = ? AND A.TRN_TYPE LIKE(?) AND A.DOC_TYPE_CODE LIKE(?)  union all  SELECT  B.SHORT_DESC TRN_DESC, C.SHORT_DESC DOC_DESC,A.DOC_NO DOC_NO, TO_CHAR(TRUNC(A.DOC_DATE),'DD/MM/YYYY') DOC_DATE,D.APPL_USER_NAME CREATED_BY, E.APPL_USER_NAME DELETED_BY,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH:MI') DELETED_DATE_TIME FROM st_transfer_hdr A, ST_TRN_TYPE_LANG_VW B,SY_DOC_TYPE_MASTER_LANG_VW C,SM_APPL_USER_LANG_VW D,SM_APPL_USER_LANG_VW E WHERE FINALIZED_YN = 'D' AND A.TRN_TYPE = B.TRN_TYPE  AND C.DOC_TYPE_CODE=A.DOC_TYPE_CODE AND C.LANGUAGE_ID=B.LANGUAGE_ID AND D.APPL_USER_ID=A.ADDED_BY_ID AND D.LANGUAGE_ID=C.LANGUAGE_ID AND D.EFF_STATUS='E' AND E.APPL_USER_ID=A.MODIFIED_BY_ID AND E.LANGUAGE_ID=B.LANGUAGE_ID AND E.EFF_STATUS='E' AND A.DOC_NO LIKE(?) AND A.FACILITY_ID = ? AND A.MODIFIED_BY_ID LIKE(?)  AND a.DOC_DATE BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND NVL(TO_DATE (?, 'dd/mm/yyyy'),to_date('31/12/9999','dd/mm/yyyy')) AND B.LANGUAGE_ID = ? AND A.TRN_TYPE LIKE(?) AND A.DOC_TYPE_CODE LIKE(?)"+order_by,arraylist);
	 setDeletedDocDetails(deletedDocDetails);
	//return deletedDocDetails;

	}catch (Exception e)
	{
		e.printStackTrace();
	}
	}

}
