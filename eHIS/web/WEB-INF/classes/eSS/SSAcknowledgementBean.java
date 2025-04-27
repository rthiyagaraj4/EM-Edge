/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import eSS.SSAcknowledgement.*;   
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import eSS.Common.*;
import javax.servlet.* ;
import javax.servlet.http.*;


public class SSAcknowledgementBean extends eSS.Common.SsTransaction implements Serializable{
	private String store_code		=	"";
	private String to_store_code	=	"";
	private String trn_type			=	"ISS";
	private String action_type		=	"A";
	private String doc_type_code	=	"";
	private String fm_store_code		=	"";
	private String doc_no		=	"";
	private String re_seq_no		=	"";//For Confirmation
	private ArrayList alCheckedItems = new ArrayList();//Added By Sakti against BRU-HIMS-CRF-376
	
	private ArrayList alTFRDtlRecords	= new ArrayList();
	private ArrayList alTFRExpRecords	= new ArrayList();
	private HashMap hmTFRExpRecords		= new HashMap();
	
	private HashMap hmFinalTFRExpRecords= new HashMap();
	private HttpSession session;
	
	public void setFmStore_code(String fm_store_code){
		this.fm_store_code = fm_store_code;
	}
	public String getFmStore_code(){
		return this.fm_store_code;
	}

	public void setStore_code(String store_code){
		this.store_code = store_code;
	}
	public String getStore_code(){
		return this.store_code;
	}
	public void setToStore(String to_store_code){
		this.to_store_code = to_store_code;
	}
	public String getToStore(){
		return this.to_store_code;
	}
	public void setTrn_type(String trn_type){
		this.trn_type = trn_type;
	}
	public String getTrn_type(){
		return this.trn_type;
	}
	public void setAction_type(String action_type){
		this.action_type = action_type;
	}
	public String getAction_type(){
		return this.action_type;
	}
	public void setDoc_type_code(String doc_type_code){
		this.doc_type_code = doc_type_code;
	}
	public String getDoc_type_code(){
		return this.doc_type_code;
	}
	public void setTFRDtlRecords(ArrayList alDtlRecords){
		this.alTFRDtlRecords = alDtlRecords;
	}
	public ArrayList getTFRDtlRecords(){
		return this.alTFRDtlRecords;
	}
	
		
	public void setTFRExpRecords(String doc_no,ArrayList exp_records){
		hmTFRExpRecords.put(doc_no,exp_records);
		hmFinalTFRExpRecords.put(doc_no,exp_records);
	}

	public ArrayList getTFRExpRecords(String doc_no){
		if(hmTFRExpRecords.containsKey(doc_no))
			return (ArrayList)this.hmTFRExpRecords.get(doc_no);
		else
			return new ArrayList();
	}

	public void setDoc_no(String doc_no){
		this.doc_no = doc_no;
	}
	public String getDoc_no(){
		return this.doc_no;
	}

	public void setSeq_no(String re_seq_no){
		this.re_seq_no = re_seq_no;
	}
	public String getSeq_no(){
		return this.re_seq_no;
	}
	public void setSession(HttpSession session) {
		 this.session = session;
		 System.err.println("session@@@bean===="+session);
	}

	public HttpSession getSession( ) {
		 return session;
	}

	public String getTrn_type_List() {
		String trn_types = "";
		try{
		HashMap hmTemp = (HashMap)fetchRecord("SELECT ISS_ACK_REQ_YN, RET_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?",getLoginFacilityId());
		if((checkForNull((String)hmTemp.get("ISS_ACK_REQ_YN"),"N")).equals("Y")){
			trn_types = trn_types+"'ISS',";
		}
		if((checkForNull((String)hmTemp.get("RET_ACK_REQ_YN"),"N")).equals("Y")){
			trn_types = trn_types+"'RTG',";
		}
		
		trn_types = trn_types.substring(0,trn_types.length()-1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return getListOptionTag(getListOptionArrayList("SELECT   TRN_TYPE, SHORT_DESC FROM SS_TRN_TYPE_LANG_VW TRN WHERE TRN_TYPE IN ("+trn_types+") AND LANGUAGE_ID = ? ORDER BY DECODE (TRN_TYPE, 'ISS', 1, 'RTG', 2)",getLanguageId()),"ISS");
	}


	public String getDoc_type_code_List(){
		//String chkParameters[] = {getTrn_type(),getLoginFacilityId(),getLanguageId()};
		ArrayList arraylist = new ArrayList();
        arraylist.add(getTrn_type());
        arraylist.add(getLoginFacilityId());
        arraylist.add(getLanguageId());
		//return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SS_SQL_SS_ACKNOWLEDGE_DOC_TYPE_CODE_SELECT"),chkParameters));
		return getListOptionTag(getListOptionArrayList("SELECT   DISTINCT DOC.DOC_TYPE_CODE, B.SHORT_DESC FROM SS_TRN_DOC_TYPE DOC,SY_DOC_TYPE_MASTER_LANG_VW B  WHERE DOC.TRN_TYPE = ? AND DOC.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND  FACILITY_ID = ? AND B.LANGUAGE_ID = ? ORDER BY 2,1",arraylist));
		}
	/*public ArrayList getDocTypeArrayList() throws Exception{ 
		ArrayList arraylist = new ArrayList();
        arraylist.add(getTrn_type());
        arraylist.add(getLanguageId());
		
		return fetchRecords("SELECT   DISTINCT DOC.DOC_TYPE_CODE, B.SHORT_DESC FROM SS_TRN_DOC_TYPE DOC,SY_DOC_TYPE_MASTER_LANG_VW B WHERE DOC.TRN_TYPE = ? AND DOC.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND  B.LANGUAGE_ID = ? ORDER BY 2,1",arraylist);
	}*/
	
	public ArrayList getDocTypeArrayList() throws Exception{ 
		ArrayList arraylist = new ArrayList();
        arraylist.add(getTrn_type());
        arraylist.add(getLanguageId());
		arraylist.add(getLoginFacilityId());
		
		
		//return fetchRecords("SELECT   DISTINCT DOC.DOC_TYPE_CODE, B.SHORT_DESC FROM SS_TRN_DOC_TYPE DOC,SY_DOC_TYPE_MASTER_LANG_VW B WHERE DOC.TRN_TYPE = ? AND DOC.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND  B.LANGUAGE_ID = ? ORDER BY 2,1",arraylist);
		
		//Added by Rabbani  Inc nO :41288(BRU-SCF-0907) on 13-AUG-13 
		return fetchRecords("SELECT   DISTINCT DOC.DOC_TYPE_CODE, B.SHORT_DESC FROM SS_TRN_DOC_TYPE DOC,SY_DOC_TYPE_MASTER_LANG_VW B WHERE DOC.TRN_TYPE = ? AND DOC.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND  B.LANGUAGE_ID = ?  and DOC.FACILITY_ID = ? AND b.status IS NULL ORDER BY 2,1",arraylist);
	}
	
	public String getStore_code_List(){
		ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add(getLoginById());
        arraylist.add(getLanguageId());
        arraylist.add(getTrn_type());
		if((getAction_type().equals("A")))
		return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SS_SQL_SS_ACKNOWLEDGE_STORE_LIST_ACK_SELECT"),arraylist));
		else
		return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SS_SQL_SS_ACKNOWLEDGE_STORE_LIST_CFM_SELECT"),arraylist));
	}
	public ArrayList getStoreArrayList() throws Exception{ 
		ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
        arraylist.add(getLoginById());
        arraylist.add(getLanguageId());
        arraylist.add(getTrn_type());
		if((getAction_type().equals("A")))
			return fetchRecords(getSsRepositoryValue("SS_SQL_SS_ACKNOWLEDGE_STORE_LIST_ACK_SELECT"),arraylist);
		
		else
			return fetchRecords(getSsRepositoryValue("SS_SQL_SS_ACKNOWLEDGE_STORE_LIST_CFM_SELECT"),arraylist);
	}
	public void loadTFRDtlData(String from_doc_date,String to_doc_date,String doc_no,String group_code,String doc_ref) {
		
		String chkParameters[] = {getLanguageId(),getLanguageId(),getLanguageId(),from_doc_date,to_doc_date,doc_no,getDoc_type_code(),getFmStore_code(),getToStore(),getLoginFacilityId(),group_code,doc_ref};
		try{
			if((getAction_type().equals("A"))){
				
				 if(getTrn_type().equals("ISS")){
										
					this.alTFRDtlRecords = fetchRecords("SELECT FACILITY_ID,DOC_NO,DOC_TYPE_CODE,DOC_DATE,SHORT_DESC,FR_STORE_CODE,TO_STORE_CODE,FR_STORE_DESC,TO_STORE_DESC,REQ_DOC_TYPE_CODE,REQ_DOC_NO,seq_no FROM (SELECT   A.FACILITY_ID ,A.DOC_NO, A.DOC_TYPE_CODE, D.SHORT_DESC,TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,FR_STORE_CODE,TO_STORE_CODE,(SELECT SHORT_DESC FROM  MM_STORE_LANG_VW WHERE STORE_CODE= A.FR_STORE_CODE AND LANGUAGE_ID = ?)FR_STORE_DESC,(SELECT SHORT_DESC FROM  MM_STORE_LANG_VW WHERE STORE_CODE= A.TO_STORE_CODE AND LANGUAGE_ID = ?) TO_STORE_DESC,A.REQ_DOC_TYPE_CODE,A.REQ_DOC_NO,ISSUE_GROUP_CODE,1 seq_no FROM SS_ISSUE_HDR A, SS_ISSUE_DTL E, SY_DOC_TYPE_MASTER_LANG_VW D WHERE A.DOC_NO = E.DOC_NO AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE AND A.FACILITY_ID = E.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND D.LANGUAGE_ID = ? AND A.PROCESS_FOR_ACKNOWLEDGE = 'Y'  AND E.ACK_STATUS IN ('PN','RI') AND A.DOC_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY') AND A.DOC_NO LIKE NVL (?, '%') AND A.DOC_TYPE_CODE LIKE ? AND A.FR_STORE_CODE LIKE ? AND A.TO_STORE_CODE LIKE ? AND A.FACILITY_ID = ? AND ISSUE_GROUP_CODE LIKE ?  AND  NVL(A.DOC_REF,'%') like ? ) GROUP BY FACILITY_ID,DOC_NO, DOC_TYPE_CODE,DOC_DATE, SHORT_DESC,FR_STORE_CODE,TO_STORE_CODE,REQ_DOC_TYPE_CODE,REQ_DOC_NO,FR_STORE_DESC,TO_STORE_DESC,seq_no ORDER BY DOC_NO,DOC_DATE",chkParameters);
					//this.alTFRDtlRecords = fetchRecords(getSsRepositoryValue("ST_SQL_SS_ACKNOWLEDGE_ISS_DTL_SELECT"),chkParameters);
				}else if(getTrn_type().equals("RTG")){
										
					//this.alTFRDtlRecords = fetchRecords("SELECT FACILITY_ID,DOC_NO,DOC_TYPE_CODE,DOC_DATE,SHORT_DESC,FR_STORE_CODE,TO_STORE_CODE,FR_STORE_DESC,TO_STORE_DESC,seq_no FROM (SELECT   A.FACILITY_ID ,A.DOC_NO, A.DOC_TYPE_CODE, D.SHORT_DESC,TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,FR_STORE_CODE,TO_STORE_CODE,(SELECT SHORT_DESC FROM  MM_STORE_LANG_VW WHERE STORE_CODE= A.FR_STORE_CODE AND LANGUAGE_ID = ?)FR_STORE_DESC,(SELECT SHORT_DESC FROM  MM_STORE_LANG_VW WHERE STORE_CODE= A.TO_STORE_CODE AND LANGUAGE_ID = ? ) TO_STORE_DESC,RETURN_GROUP_CODE,1 seq_no FROM SS_RETURN_HDR A, SS_RETURN_DTL E, SY_DOC_TYPE_MASTER_LANG_VW D WHERE A.DOC_NO = E.DOC_NO AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE AND A.FACILITY_ID = E.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND D.LANGUAGE_ID = ? AND A.PROCESS_FOR_ACKNOWLEDGE = 'Y'  AND E.ACK_STATUS = 'PN'AND A.DOC_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY') AND A.DOC_NO LIKE NVL (?, '%') AND A.DOC_TYPE_CODE LIKE ? AND A.FR_STORE_CODE LIKE ?  AND A.TO_STORE_CODE LIKE ? AND A.FACILITY_ID = ? AND RETURN_GROUP_CODE LIKE ?  AND  NVL(A.DOC_REF,'%') like ?) GROUP BY FACILITY_ID,DOC_NO, DOC_TYPE_CODE,DOC_DATE, SHORT_DESC,FR_STORE_CODE,TO_STORE_CODE,FR_STORE_DESC,TO_STORE_DESC,seq_no ORDER BY DOC_NO,DOC_DATE",chkParameters);
					//Modified by Sakti added condition AND a.finalized_yn='N'	PMG2014-CRF-0008	 			
					this.alTFRDtlRecords = fetchRecords("SELECT FACILITY_ID,DOC_NO,DOC_TYPE_CODE,DOC_DATE,SHORT_DESC,FR_STORE_CODE,TO_STORE_CODE,FR_STORE_DESC,TO_STORE_DESC,seq_no FROM (SELECT   A.FACILITY_ID ,A.DOC_NO, A.DOC_TYPE_CODE, D.SHORT_DESC,TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,FR_STORE_CODE,TO_STORE_CODE,(SELECT SHORT_DESC FROM  MM_STORE_LANG_VW WHERE STORE_CODE= A.FR_STORE_CODE AND LANGUAGE_ID = ?)FR_STORE_DESC,(SELECT SHORT_DESC FROM  MM_STORE_LANG_VW WHERE STORE_CODE= A.TO_STORE_CODE AND LANGUAGE_ID = ? ) TO_STORE_DESC,RETURN_GROUP_CODE,1 seq_no FROM SS_RETURN_HDR A, SS_RETURN_DTL E, SY_DOC_TYPE_MASTER_LANG_VW D WHERE A.DOC_NO = E.DOC_NO AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE AND A.FACILITY_ID = E.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND D.LANGUAGE_ID = ? AND A.PROCESS_FOR_ACKNOWLEDGE = 'Y'  AND E.ACK_STATUS = 'PN' AND a.finalized_yn='N' AND A.DOC_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY') AND A.DOC_NO LIKE NVL (?, '%') AND A.DOC_TYPE_CODE LIKE ? AND A.FR_STORE_CODE LIKE ?  AND A.TO_STORE_CODE LIKE ? AND A.FACILITY_ID = ? AND RETURN_GROUP_CODE LIKE ?  AND  NVL(A.DOC_REF,'%') like ?) GROUP BY FACILITY_ID,DOC_NO, DOC_TYPE_CODE,DOC_DATE, SHORT_DESC,FR_STORE_CODE,TO_STORE_CODE,FR_STORE_DESC,TO_STORE_DESC,seq_no ORDER BY DOC_NO,DOC_DATE",chkParameters);
					//this.alTFRDtlRecords = fetchRecords(getSsRepositoryValue("ST_SQL_SS_ACKNOWLEDGE_RET_DTL_SELECT"),chkParameters);
				}
			}
			else{
				
				if(getTrn_type().equals("ISS")){
			
				//this.alTFRDtlRecords = fetchRecords("SELECT   FACILITY_ID, DOC_NO, DOC_TYPE_CODE, DOC_DATE, SHORT_DESC, FR_STORE_CODE,  TO_STORE_CODE,FR_STORE_DESC, TO_STORE_DESC, REQ_DOC_TYPE_CODE, REQ_DOC_NO,NVL (seq_no, 1) seq_no FROM (SELECT A.FACILITY_ID, A.DOC_NO, A.DOC_TYPE_CODE, D.SHORT_DESC,TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  G.ISSUING_STORE TO_STORE_CODE, G.RECEIVING_STORE FR_STORE_CODE,(SELECT SHORT_DESC FROM MM_STORE_LANG_VW   WHERE STORE_CODE =  G.ISSUING_STORE  AND LANGUAGE_ID = ?) FR_STORE_DESC, (SELECT SHORT_DESC FROM MM_STORE_LANG_VW   WHERE STORE_CODE =  G.RECEIVING_STORE  AND LANGUAGE_ID = ?) TO_STORE_DESC, A.REQ_DOC_TYPE_CODE, A.REQ_DOC_NO, ISSUE_GROUP_CODE,seq_no   FROM SS_ISSUE_HDR A,SS_ISSUE_DTL E,SY_DOC_TYPE_MASTER_LANG_VW D, SS_ACKNOWLEDGE_TRN_HDR G  WHERE A.DOC_NO = E.DOC_NO             AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE  AND A.FACILITY_ID = E.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE  AND G.DOC_NO=A.DOC_NO  AND G.DOC_TYPE_CODE = A.DOC_TYPE_CODE AND G.FACILITY_ID=A.FACILITY_ID AND D.LANGUAGE_ID = ? AND G.CONFIRM_REQD_YN = 'Y'  AND G.CONFIRM_YN = 'N' AND G.DOC_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')          AND G.DOC_NO LIKE NVL (?, '%') AND G.DOC_TYPE_CODE LIKE ? AND  G.RECEIVING_STORE LIKE ? AND G.ISSUING_STORE LIKE ? AND G.FACILITY_ID = ? AND ISSUE_GROUP_CODE LIKE ?  AND  NVL(A.DOC_REF,'%') like ? ) GROUP BY FACILITY_ID, DOC_NO, DOC_TYPE_CODE, DOC_DATE, SHORT_DESC,FR_STORE_CODE, TO_STORE_CODE,REQ_DOC_TYPE_CODE, REQ_DOC_NO,FR_STORE_DESC, TO_STORE_DESC,seq_no ORDER BY DOC_NO,DOC_DATE",chkParameters);
				this.alTFRDtlRecords = fetchRecords("SELECT   FACILITY_ID, DOC_NO, DOC_TYPE_CODE, DOC_DATE, SHORT_DESC, FR_STORE_CODE,  TO_STORE_CODE,FR_STORE_DESC, TO_STORE_DESC, REQ_DOC_TYPE_CODE, REQ_DOC_NO,NVL (seq_no, 1) seq_no FROM (SELECT A.FACILITY_ID, A.DOC_NO, A.DOC_TYPE_CODE, D.SHORT_DESC,TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  G.ISSUING_STORE TO_STORE_CODE, G.RECEIVING_STORE FR_STORE_CODE,(SELECT SHORT_DESC FROM MM_STORE_LANG_VW   WHERE STORE_CODE =  G.ISSUING_STORE  AND LANGUAGE_ID = ?) FR_STORE_DESC, (SELECT SHORT_DESC FROM MM_STORE_LANG_VW   WHERE STORE_CODE =  G.RECEIVING_STORE  AND LANGUAGE_ID = ?) TO_STORE_DESC, A.REQ_DOC_TYPE_CODE, A.REQ_DOC_NO, ISSUE_GROUP_CODE,seq_no   FROM SS_ISSUE_HDR A,SS_ISSUE_DTL E,SY_DOC_TYPE_MASTER_LANG_VW D, SS_ACKNOWLEDGE_TRN_HDR G  WHERE A.DOC_NO = E.DOC_NO             AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE  AND A.FACILITY_ID = E.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE  AND G.DOC_NO=A.DOC_NO  AND G.DOC_TYPE_CODE = A.DOC_TYPE_CODE AND G.FACILITY_ID=A.FACILITY_ID AND D.LANGUAGE_ID = ? AND G.CONFIRM_REQD_YN = 'Y'  AND G.CONFIRM_YN = 'N' AND G.DOC_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')          AND G.DOC_NO LIKE NVL (?, '%') AND G.DOC_TYPE_CODE LIKE ?   AND G.ISSUING_STORE LIKE ?  AND  G.RECEIVING_STORE LIKE ?  AND G.FACILITY_ID = ? AND ISSUE_GROUP_CODE LIKE ?  AND  NVL(A.DOC_REF,'%') like ? ) GROUP BY FACILITY_ID, DOC_NO, DOC_TYPE_CODE, DOC_DATE, SHORT_DESC,FR_STORE_CODE, TO_STORE_CODE,REQ_DOC_TYPE_CODE, REQ_DOC_NO,FR_STORE_DESC, TO_STORE_DESC,seq_no ORDER BY DOC_NO,DOC_DATE",chkParameters);
			}else if(getTrn_type().equals("RTG")){

				//this.alTFRDtlRecords = fetchRecords("SELECT   FACILITY_ID, DOC_NO, DOC_TYPE_CODE, DOC_DATE, SHORT_DESC, FR_STORE_CODE,  TO_STORE_CODE,FR_STORE_DESC, TO_STORE_DESC,NVL (seq_no, 1) seq_no FROM (SELECT A.FACILITY_ID, A.DOC_NO, A.DOC_TYPE_CODE, D.SHORT_DESC,TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  G.ISSUING_STORE TO_STORE_CODE, G.RECEIVING_STORE FR_STORE_CODE,(SELECT SHORT_DESC FROM MM_STORE_LANG_VW   WHERE STORE_CODE =  G.ISSUING_STORE  AND LANGUAGE_ID = ?) FR_STORE_DESC, (SELECT SHORT_DESC FROM MM_STORE_LANG_VW   WHERE STORE_CODE =  G.RECEIVING_STORE  AND LANGUAGE_ID = ?) TO_STORE_DESC,  RETURN_GROUP_CODE,seq_no   FROM SS_RETURN_HDR A,SS_RETURN_DTL E,SY_DOC_TYPE_MASTER_LANG_VW D, SS_ACKNOWLEDGE_TRN_HDR G  WHERE A.DOC_NO = E.DOC_NO             AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE  AND A.FACILITY_ID = E.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE  AND G.DOC_NO=A.DOC_NO  AND G.DOC_TYPE_CODE = A.DOC_TYPE_CODE AND G.FACILITY_ID=A.FACILITY_ID AND D.LANGUAGE_ID = ? AND G.CONFIRM_REQD_YN = 'Y' AND G.CONFIRM_YN = 'N' AND G.DOC_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')          AND G.DOC_NO LIKE NVL (?, '%') AND G.DOC_TYPE_CODE LIKE ? AND G.RECEIVING_STORE LIKE ? AND G.ISSUING_STORE LIKE ?  AND G.FACILITY_ID = ? AND RETURN_GROUP_CODE LIKE ?  AND  NVL(A.DOC_REF,'%')  like ? ) GROUP BY FACILITY_ID, DOC_NO, DOC_TYPE_CODE, DOC_DATE, SHORT_DESC,FR_STORE_CODE, TO_STORE_CODE,FR_STORE_DESC, TO_STORE_DESC,seq_no ORDER BY DOC_NO,DOC_DATE",chkParameters);
				this.alTFRDtlRecords = fetchRecords("SELECT   FACILITY_ID, DOC_NO, DOC_TYPE_CODE, DOC_DATE, SHORT_DESC, FR_STORE_CODE,  TO_STORE_CODE,FR_STORE_DESC, TO_STORE_DESC,NVL (seq_no, 1) seq_no FROM (SELECT A.FACILITY_ID, A.DOC_NO, A.DOC_TYPE_CODE, D.SHORT_DESC,TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  G.ISSUING_STORE TO_STORE_CODE, G.RECEIVING_STORE FR_STORE_CODE,(SELECT SHORT_DESC FROM MM_STORE_LANG_VW   WHERE STORE_CODE =  G.ISSUING_STORE  AND LANGUAGE_ID = ?) FR_STORE_DESC, (SELECT SHORT_DESC FROM MM_STORE_LANG_VW   WHERE STORE_CODE =  G.RECEIVING_STORE  AND LANGUAGE_ID = ?) TO_STORE_DESC,  RETURN_GROUP_CODE,seq_no   FROM SS_RETURN_HDR A,SS_RETURN_DTL E,SY_DOC_TYPE_MASTER_LANG_VW D, SS_ACKNOWLEDGE_TRN_HDR G  WHERE A.DOC_NO = E.DOC_NO             AND A.DOC_TYPE_CODE = E.DOC_TYPE_CODE  AND A.FACILITY_ID = E.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE  AND G.DOC_NO=A.DOC_NO  AND G.DOC_TYPE_CODE = A.DOC_TYPE_CODE AND G.FACILITY_ID=A.FACILITY_ID AND D.LANGUAGE_ID = ? AND G.CONFIRM_REQD_YN = 'Y' AND G.CONFIRM_YN = 'N' AND G.DOC_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')          AND G.DOC_NO LIKE NVL (?, '%') AND G.DOC_TYPE_CODE LIKE ?  AND  G.ISSUING_STORE LIKE ?  AND  G.RECEIVING_STORE LIKE ?  AND G.FACILITY_ID = ? AND RETURN_GROUP_CODE LIKE ?  AND  NVL(A.DOC_REF,'%')  like ? ) GROUP BY FACILITY_ID, DOC_NO, DOC_TYPE_CODE, DOC_DATE, SHORT_DESC,FR_STORE_CODE, TO_STORE_CODE,FR_STORE_DESC, TO_STORE_DESC,seq_no ORDER BY DOC_NO,DOC_DATE",chkParameters);
			}
				//this.alTFRDtlRecords = fetchRecords(getSsRepositoryValue("ST_SQL_ST_ACKNOWLEDGE_CFM_DTL_SELECT"),chkParameters);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void loadTFRExpData(String doc_no,String seq_no){
		ArrayList alParameters = new ArrayList();
		//alParameters.add(getAction_type());
		//Added by Sakti against BRU-HIMS-CRF-376
		if(getTrn_type().equals("RTG")){
			alParameters.add(getLanguageId());
		}//Added ends
		alParameters.add(doc_no);
		alParameters.add(getDoc_type_code());
		alParameters.add(getLanguageId());
		
		HashMap hmTemp = new HashMap();
		try{
			if((getAction_type().equals("A"))){
				if(getTrn_type().equals("ISS")){
					//Modified by Sakti against BRU-HIMS-CRF-376
					//this.alTFRExpRecords = fetchRecords("SELECT  nvl(SEQ_NO,1) SEQ_NO, DTL.ISSUE_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO, DTL.DOC_TYPE_CODE,TO_CHAR (DTL.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,TRAY.BIN_LOCATION_CODE,  ACK.REMARKS REMARKS,DTL.REQ_GROUP_CODE FROM SS_ISSUE_HDR HDR,SS_ISSUE_DTL DTL,SS_GROUP_LANG_VW B, SS_TRAY_DTLS TRAY,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS IN ('PN','RI')   AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND  DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.ISSUE_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE = DTL.ISSUE_GROUP_CODE AND TRAY.TRAY_NO = DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID  AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ISSUE_GROUP_CODE = B.GROUP_CODE AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID = ?  order by group_desc,dtl.tray_no",alParameters);
					this.alTFRExpRecords = fetchRecords("SELECT  nvl(SEQ_NO,1) SEQ_NO, DTL.ISSUE_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO, DTL.DOC_TYPE_CODE,TO_CHAR (DTL.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,TRAY.BIN_LOCATION_CODE,  ACK.REMARKS REMARKS,DTL.REQ_GROUP_CODE, (select count(*)  from SS_DISCREPANCY_DTL l where l.group_code = dtl.ISSUE_group_code AND l.TRAY_NO = dtl.tray_no and l.ORG_DOC_NO IS NULL) count_tray_disc FROM SS_ISSUE_HDR HDR,SS_ISSUE_DTL DTL,SS_GROUP_LANG_VW B, SS_TRAY_DTLS TRAY,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS IN ('PN','RI')   AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND  DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.ISSUE_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE = DTL.ISSUE_GROUP_CODE AND TRAY.TRAY_NO = DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID  AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ISSUE_GROUP_CODE = B.GROUP_CODE AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID = ?  order by group_desc,dtl.tray_no",alParameters);
				}if(getTrn_type().equals("RTG")){
					//Modified by Sakti against BRU-HIMS-CRF-376
					//this.alTFRExpRecords = fetchRecords("SELECT nvl(SEQ_NO,1) SEQ_NO,DTL.RETURN_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO,DTL.DOC_TYPE_CODE, TO_CHAR(TRAY.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, TRAY.BIN_LOCATION_CODE,ACK.REMARKS REMARKS FROM SS_RETURN_HDR HDR ,SS_RETURN_DTL DTL, SS_GROUP_LANG_VW B ,SS_TRAY_DTLS TRAY ,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS='PN' AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.RETURN_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE=DTL.RETURN_GROUP_CODE AND TRAY.TRAY_NO=DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.RETURN_GROUP_CODE = B.GROUP_CODE AND  HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID=?  order by group_desc,dtl.tray_no",alParameters);
					//this.alTFRExpRecords = fetchRecords("SELECT nvl(SEQ_NO,1) SEQ_NO,DTL.RETURN_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO,DTL.DOC_TYPE_CODE, TO_CHAR(TRAY.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, TRAY.BIN_LOCATION_CODE,ACK.REMARKS REMARKS,(select remarks_desc from MM_TRN_REMARKS_LANG rm where TRN_REMARKS_CODE = NVL(dtl.remarks,'') and rm.language_id=? ) ret_remarks,(select count(*)  from SS_RETURN_DISCREPANCY_DTL l where l.doc_no = dtl.doc_no AND l.doc_type_code = dtl.doc_type_code AND l.facility_id = dtl.facility_id AND l.group_code = dtl.return_group_code AND l.TRAY_NO = dtl.tray_no) count_ret_disc, (select count(*)  from SS_DISCREPANCY_DTL k where k.group_code = dtl.return_group_code AND k.TRAY_NO = dtl.tray_no and k.ORG_DOC_NO IS NULL) count_tray_disc FROM SS_RETURN_HDR HDR ,SS_RETURN_DTL DTL, SS_GROUP_LANG_VW B ,SS_TRAY_DTLS TRAY ,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS='PN' AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.RETURN_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE=DTL.RETURN_GROUP_CODE AND TRAY.TRAY_NO=DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.RETURN_GROUP_CODE = B.GROUP_CODE AND  HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID=?  order by group_desc,dtl.tray_no",alParameters);
					//Added AND ACK.REJECTED_YN IS NULL PMG2014-CRF-0008
					this.alTFRExpRecords = fetchRecords("SELECT nvl(SEQ_NO,1) SEQ_NO,DTL.RETURN_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO,DTL.DOC_TYPE_CODE, TO_CHAR(TRAY.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, TRAY.BIN_LOCATION_CODE,ACK.REMARKS REMARKS,(select remarks_desc from MM_TRN_REMARKS_LANG rm where TRN_REMARKS_CODE = NVL(dtl.remarks,'') and rm.language_id=? ) ret_remarks,(select count(*)  from SS_RETURN_DISCREPANCY_DTL l where l.doc_no = dtl.doc_no AND l.doc_type_code = dtl.doc_type_code AND l.facility_id = dtl.facility_id AND l.group_code = dtl.return_group_code AND l.TRAY_NO = dtl.tray_no) count_ret_disc, (select count(*)  from SS_DISCREPANCY_DTL k where k.group_code = dtl.return_group_code AND k.TRAY_NO = dtl.tray_no and k.ORG_DOC_NO IS NULL) count_tray_disc FROM SS_RETURN_HDR HDR ,SS_RETURN_DTL DTL, SS_GROUP_LANG_VW B ,SS_TRAY_DTLS TRAY ,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS='PN' AND ACK.REJECTED_YN IS NULL AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.RETURN_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE=DTL.RETURN_GROUP_CODE AND TRAY.TRAY_NO=DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.RETURN_GROUP_CODE = B.GROUP_CODE AND  HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID=?  order by group_desc,dtl.tray_no",alParameters);
				}
			}else{
				alParameters.add(seq_no);
				if(getTrn_type().equals("ISS")){
					//Modified by Sakti against BRU-HIMS-CRF-376
					//this.alTFRExpRecords = fetchRecords("SELECT  nvl(SEQ_NO,1) SEQ_NO, DTL.ISSUE_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO, DTL.DOC_TYPE_CODE,TO_CHAR (DTL.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,TRAY.BIN_LOCATION_CODE, ACK.REMARKS REMARKS,DTL.REQ_GROUP_CODE FROM SS_ISSUE_HDR HDR,SS_ISSUE_DTL DTL,SS_GROUP_LANG_VW B, SS_TRAY_DTLS TRAY,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS='AK' AND  ACK.rejected_yn = 'Y' AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND  DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.ISSUE_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE = DTL.ISSUE_GROUP_CODE AND TRAY.TRAY_NO = DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID  AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ISSUE_GROUP_CODE = B.GROUP_CODE AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID = ? AND ACK.SEQ_NO = ?  order by group_desc,dtl.tray_no",alParameters);
					this.alTFRExpRecords = fetchRecords("SELECT  nvl(SEQ_NO,1) SEQ_NO, DTL.ISSUE_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO, DTL.DOC_TYPE_CODE,TO_CHAR (DTL.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE,TRAY.BIN_LOCATION_CODE, ACK.REMARKS REMARKS,DTL.REQ_GROUP_CODE, (select count(*)  from SS_DISCREPANCY_DTL l where l.group_code = dtl.ISSUE_group_code AND l.TRAY_NO = dtl.tray_no and l.ORG_DOC_NO IS NULL) count_tray_disc FROM SS_ISSUE_HDR HDR,SS_ISSUE_DTL DTL,SS_GROUP_LANG_VW B, SS_TRAY_DTLS TRAY,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS='AK' AND  ACK.rejected_yn = 'Y' AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND  DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.ISSUE_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE = DTL.ISSUE_GROUP_CODE AND TRAY.TRAY_NO = DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID  AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ISSUE_GROUP_CODE = B.GROUP_CODE AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID = ? AND ACK.SEQ_NO = ?  order by group_desc,dtl.tray_no",alParameters);
				}if(getTrn_type().equals("RTG")){
					//Modified by Sakti against BRU-HIMS-CRF-376
					//this.alTFRExpRecords = fetchRecords("SELECT nvl(SEQ_NO,1) SEQ_NO,DTL.RETURN_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO,DTL.DOC_TYPE_CODE, TO_CHAR(TRAY.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, TRAY.BIN_LOCATION_CODE,ACK.REMARKS REMARKS  FROM SS_RETURN_HDR HDR ,SS_RETURN_DTL DTL, SS_GROUP_LANG_VW B ,SS_TRAY_DTLS TRAY ,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS='AK' AND  ACK.rejected_yn = 'Y' AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.RETURN_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE=DTL.RETURN_GROUP_CODE AND TRAY.TRAY_NO=DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.RETURN_GROUP_CODE = B.GROUP_CODE AND  HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID=? AND ACK.SEQ_NO = ?  order by group_desc,dtl.tray_no",alParameters);
					//this.alTFRExpRecords = fetchRecords("SELECT nvl(SEQ_NO,1) SEQ_NO,DTL.RETURN_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO,DTL.DOC_TYPE_CODE, TO_CHAR(TRAY.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, TRAY.BIN_LOCATION_CODE,ACK.REMARKS REMARKS,(select remarks_desc from MM_TRN_REMARKS_LANG rm where TRN_REMARKS_CODE = NVL(dtl.remarks,'') and rm.language_id=? ) ret_remarks , (select count(*)  from SS_DISCREPANCY_DTL l where l.group_code = dtl.return_group_code AND l.TRAY_NO = dtl.tray_no) count_tray_disc FROM SS_RETURN_HDR HDR ,SS_RETURN_DTL DTL, SS_GROUP_LANG_VW B ,SS_TRAY_DTLS TRAY ,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS='AK' AND  ACK.rejected_yn = 'Y' AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.RETURN_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE=DTL.RETURN_GROUP_CODE AND TRAY.TRAY_NO=DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.RETURN_GROUP_CODE = B.GROUP_CODE AND  HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID=? AND ACK.SEQ_NO = ?  order by group_desc,dtl.tray_no",alParameters);
					//Query changed as required for Return Confirm CRF - Sakti PMG2014-CRF-0008
					this.alTFRExpRecords = fetchRecords("SELECT nvl(SEQ_NO,1) SEQ_NO,DTL.RETURN_GROUP_CODE, B.SHORT_DESC GROUP_DESC, DTL.TRAY_NO,DTL.DOC_NO,DTL.DOC_TYPE_CODE, TO_CHAR(TRAY.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, TRAY.BIN_LOCATION_CODE,ACK.REMARKS REMARKS,(select remarks_desc from MM_TRN_REMARKS_LANG rm where TRN_REMARKS_CODE = NVL(dtl.remarks,'') and rm.language_id=? ) ret_remarks , (select count(*)  from SS_RETURN_DISCREPANCY_DTL l where l.doc_no = dtl.doc_no AND l.doc_type_code = dtl.doc_type_code AND l.facility_id = dtl.facility_id AND l.group_code = dtl.return_group_code AND l.TRAY_NO = dtl.tray_no) count_ret_disc, (select count(*)  from SS_DISCREPANCY_DTL k where k.group_code = dtl.return_group_code AND k.TRAY_NO = dtl.tray_no and k.ORG_DOC_NO IS NULL) count_tray_disc FROM SS_RETURN_HDR HDR ,SS_RETURN_DTL DTL, SS_GROUP_LANG_VW B ,SS_TRAY_DTLS TRAY ,SS_ACKNOWLEDGE_TRN_DTL ACK WHERE DTL.ACK_STATUS='PN' AND  ACK.rejected_yn = 'Y' AND HDR.FACILITY_ID=DTL.FACILITY_ID AND HDR.DOC_NO=DTL.DOC_NO AND HDR.DOC_TYPE_CODE=DTL.DOC_TYPE_CODE AND DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_NO = ACK.DOC_NO(+)  AND DTL.TRAY_NO = ACK.TRAY_NO(+) AND DTL.RETURN_GROUP_CODE = ACK.GROUP_CODE(+) AND TRAY.GROUP_CODE=DTL.RETURN_GROUP_CODE AND TRAY.TRAY_NO=DTL.TRAY_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND DTL.RETURN_GROUP_CODE = B.GROUP_CODE AND  HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND LANGUAGE_ID=? AND ACK.SEQ_NO = ?  order by group_desc,dtl.tray_no",alParameters);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<HashMap> alExpRecords = new ArrayList();
		
		for(int i=0;i<alTFRExpRecords.size();i++){
			hmTemp = (HashMap)alTFRExpRecords.get(i);
			hmTemp.put("expiry_date",(String)hmTemp.get("EXPIRY_DATE"));
			hmTemp.put("tray_no",(String)hmTemp.get("TRAY_NO"));
			hmTemp.put("bon_locn_code",(String)hmTemp.get("BIN_LOCATION_CODE"));
	
				alExpRecords.add(i,hmTemp);
			
		}
		//hmTFRExpRecords.put(doc_no,alExpRecords);
		if((getAction_type().equals("A"))) {
			setTFRExpRecords(doc_no+"~"+seq_no,alExpRecords);
		}else if((getAction_type().equals("C"))) {
			hmTFRExpRecords.put(doc_no+"~"+seq_no,alExpRecords);
		}
		//hmTFRExpRecords.put(doc_no+"~"+seq_no,alExpRecords);
		
	}
	
	//Added by Sakti against BRU-HIMS-CRF-376
	public void updateSelectedValues(Hashtable selectedValues) {
		
		int total = Integer.parseInt((String)selectedValues.get("total_records"));
		
		String checkedIndices = (String)selectedValues.get("checkedIndices");
		String key = null;
		ArrayList alRemoveKey = new ArrayList (total);
		
		for (int i=0;i<total;i++) {
			alRemoveKey.add((String)selectedValues.get("checkbox"+i));
		}
		
		alCheckedItems.removeAll(alRemoveKey);
		alRemoveKey = null;
		StringTokenizer checked = new  StringTokenizer(checkedIndices,",");
		ArrayList alAddKey  = new ArrayList ();
		while (checked.hasMoreElements()) {
			key = (String)checked.nextElement();
			if (key != null && key.trim() != "") {
				alAddKey.add((String) selectedValues.get("checkbox"+key.trim()));
			}
		}
		alCheckedItems.addAll(alAddKey);
	}
	
	public ArrayList getCheckItems(){
		return alCheckedItems;
	    }//Added ends

	public void setAll(Hashtable hashtable) {
		if((getAction_type().equals("A"))){	
			updateSelectedValues( hashtable);
		}
    }
	public void  clear() {
		super.clear();
		alTFRDtlRecords= new ArrayList();
		alTFRExpRecords= new ArrayList();
		hmTFRExpRecords = new HashMap();
		hmFinalTFRExpRecords = new HashMap();
		alCheckedItems = new ArrayList();
		session=null;
		
	}
	/*public HashMap validate() throws Exception{
		HashMap hmReturn = getMessageHashMap(true);	
		String adj_doc_type_code = (String)fetchRecord("SELECT DEF_ADJ_DOC_TYPE_CODE DOC_TYPE_CODE FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ? AND MATERIAL_GROUP_CODE = 'ALL'", getLoginFacilityId()).get("DOC_TYPE_CODE");
		if (checkForNull(adj_doc_type_code).equals("")) {
			hmReturn.put(RESULT, FALSE);
			hmReturn.put(MESSAGE, getSTMessage(getLanguageId(),"DEF_ADJ_DOC_TYPE_CODE_NOT_SELECTED","ST"));
			return hmReturn;
		}
		HashMap hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"),adj_doc_type_code);
		if (checkForNull((String)hmRecord.get("NEXT_DOC_NO")).equals("")) {
			hmReturn.put(RESULT, FALSE);
			hmReturn.put(MESSAGE, getSTMessage(getLanguageId(),"SYS_GEN_DOC_NO_NOT_SELECTED","ST"));
		}
		return hmReturn;
	}*/
	public HashMap insert(){
		//String doc_no				=   "";
		//String confirm				=   "Y";
		String confirm_date			=   "";
		Boolean exist				=	false;
		HashMap hmSQLMap			=	new HashMap();
		HashMap hmTableData			=	new HashMap();
		HashMap hmDtlRecords		=	new HashMap();
		HashMap hmTemp				=	new HashMap();
		HashMap hmDtlTemp			=	new HashMap();
		ArrayList alAckHdrData		=	new ArrayList();
		ArrayList alAckDTLData		=	new ArrayList();
		ArrayList alHdrData			=	new ArrayList();
		ArrayList alDtlData			=	new ArrayList();
		ArrayList alCommonData		=	new ArrayList();		
		ArrayList allanguageData	=	new ArrayList();
		ArrayList alTmpHdrRecords	=	new ArrayList();
		ArrayList alTmpExpRecords	=	new ArrayList();
		ArrayList alTmpDtlRecords	=	new ArrayList();
		ArrayList alTmpExp			=	new ArrayList();
		ArrayList alParam			=	new ArrayList();
		ArrayList alModAckHdrData	=	new ArrayList();
		ArrayList alModAckDtlData	=	new ArrayList();
		ArrayList alTemp			=	null;
		ArrayList alTraydtlData		=	new ArrayList();
		ArrayList alIssueQtyupdateData=	new ArrayList();		
		ArrayList alPendAckData		=	new ArrayList();		
		ArrayList alPendAckQty		=	null;
		ArrayList	alAckDiscrepancyList	=	null			;//Added for TH-KW-CRF-0026
		ArrayList	alDiscDtlInsertData	=	new ArrayList()	;//Added for TH-KW-CRF-0026
		
		int seq_no					= 0;
		String ack_yn				= "";
		int iss_qty					= 0;
		int reduce_blocked_qty		= 0;
		//String Req_Group_Code		= ""; //Comented by sakti as this is unused against inc#48061 
		hmSQLMap = stockSQL();

		allanguageData.add(getLanguageId());

		alCommonData.add(getLoginById()			);
		alCommonData.add(getLoginAtWsNo()		);
		alCommonData.add(getLoginFacilityId()	);
		alCommonData.add(getDoc_type_code()		);
		alCommonData.add(getTrn_type()			);
		HashMap hmResult = new HashMap();
		String key = null;
		StringTokenizer ss;
		String docSeqNo = "";
		String docNoValue = "";
		String dtl_doc_no = "";
		String dtl_seq_no = "";
		String dtl_doc_number = "";
		String dtl_seq_number = "";
		try{
			alAckDiscrepancyList	=	(ArrayList)session.getAttribute("alAckDiscrepancyList");//Adding start for TH-KW-CRF-0026
			System.err.println("alAckDiscrepancyList @@==="+alAckDiscrepancyList);

		for (int i=0;i<alAckDiscrepancyList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alAckDiscrepancyList.get(i);
			System.err.println("hmRecord"+hmRecord);
			if(hmRecord.get("markedAsDelete").toString().equals("Y")){
				continue;
			}
			alDiscDtlInsertData.add(hmRecord);		
		}//Adding end for TH-KW-CRF-0026
			//System.err.println("alDiscDtlInsertDatain bean@@@@==="+alDiscDtlInsertData);
if((getAction_type().equals("A"))){	//Added by Sakti against BRU-HIMS-CRF-376		
		if(alCheckedItems.size() > 0) {//Added by Sakti against BRU-HIMS-CRF-376 for multiple check box
				
				for (int l=0;l<alCheckedItems.size(); l++) 
				{
					key = (String) alCheckedItems.get(l);
					if (key == null || key.trim() == "") 
					  continue;
					
					 ss = new StringTokenizer(key,"-"); 
					 docNoValue = ss.nextToken().trim();
					 docSeqNo = ss.nextToken();
					 if(hmFinalTFRExpRecords.containsKey(docNoValue+"~"+docSeqNo)){
			for(int i=0;i<alTFRDtlRecords.size();i++){
				
				hmDtlRecords = (HashMap)alTFRDtlRecords.get(i);
				dtl_doc_number = (String)hmDtlRecords.get("DOC_NO");
				dtl_seq_number = (String)hmDtlRecords.get("SEQ_NO");
			
				if(hmFinalTFRExpRecords.containsKey((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"))){
				//if(getDoc_no()+"~"+getSeq_no().equals((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"))) {
					
					if(  dtl_doc_number.equals( docNoValue) && dtl_seq_number. equals( docSeqNo) ) { 
						
							alParam = new ArrayList();
							alParam.add(getLoginFacilityId());
							alParam.add((String)hmDtlRecords.get("DOC_NO"));
							alParam.add(getDoc_type_code());
												
							
                            alCommonData.add(hmDtlRecords.get("FACILITY_ID"));
							alCommonData.add(getAction_type());

							
							
								 seq_no= Integer.parseInt((String)(((HashMap)fetchRecord("SELECT nvl(MAX(SEQ_NO),0) SEQ_NO FROM SS_ACKNOWLEDGE_TRN_HDR WHERE FACILITY_ID = ? AND DOC_NO = ? AND DOC_TYPE_CODE=? ",alParam)).get("SEQ_NO")));
								 ++seq_no;
							
								alTmpHdrRecords = new ArrayList();
								
								alTmpHdrRecords.add(hmDtlRecords.get("FACILITY_ID"));
								alTmpHdrRecords.add(getDoc_type_code());
								alTmpHdrRecords.add(hmDtlRecords.get("DOC_NO"));
								alTmpHdrRecords.add(""+seq_no);
								alTmpHdrRecords.add((String)hmDtlRecords.get("DOC_DATE"));
								alTmpHdrRecords.add(getTrn_type());
								alTmpHdrRecords.add((String)hmDtlRecords.get("FR_STORE_CODE"));
								alTmpHdrRecords.add((String)hmDtlRecords.get("TO_STORE_CODE"));
								alTmpHdrRecords.add("Y"); //ACKNOWLEDGE_YN
						
								alTmpExp = (ArrayList)hmFinalTFRExpRecords.get((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"));
								
								for(int k=0;k<alTmpExp.size();k++){
									if((checkForNull((String)((HashMap)alTmpExp.get(k)).get("ACKNOWLEDGE_STATUS"))).equals("R")){
										exist=true;
									}
								}
								if(exist) {
									alTmpHdrRecords.add("Y"); //CONFIRM_REQD_YN
								}else{
									alTmpHdrRecords.add("N"); //CONFIRM_REQD_YN
								}
								alTmpHdrRecords.add("N");
								alTmpHdrRecords.add("");  //CONFIRM_DATE
								
								alTmpHdrRecords.add(getLoginById());
								alTmpHdrRecords.add(getLoginAtWsNo());
								alTmpHdrRecords.add(getLoginFacilityId());
								alTmpHdrRecords.add(getLoginById());
								alTmpHdrRecords.add(getLoginAtWsNo());
								alTmpHdrRecords.add(getLoginFacilityId());
								
								alAckHdrData.add(alTmpHdrRecords);
						

							alTmpExpRecords = (ArrayList)hmFinalTFRExpRecords.get((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"));
							
						for(int j=0;j<alTmpExpRecords.size();j++){
								
							hmTemp = (HashMap)alTmpExpRecords.get(j);
								if(!(hmTemp.get("ACKNOWLEDGE_STATUS")).equals("P")){ //Pending records not to consider
							
							
							alTmpDtlRecords = new ArrayList();
							
							alTmpDtlRecords.add((String)hmDtlRecords.get("FACILITY_ID"));
							alTmpDtlRecords.add(getDoc_type_code());
							alTmpDtlRecords.add((String)hmDtlRecords.get("DOC_NO"));
							alTmpDtlRecords.add(""+seq_no);
							
							if(getTrn_type().equals("ISS")){
								alTmpDtlRecords.add((String)hmTemp.get("ISSUE_GROUP_CODE"));
							}else{
								alTmpDtlRecords.add((String)hmTemp.get("RETURN_GROUP_CODE"));
							}
							alTmpDtlRecords.add((String)hmTemp.get("TRAY_NO"));

							alTmpDtlRecords.add("Y");//ACK_YN
					
							if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R")){							
								alTmpDtlRecords.add("Y");//REJECT_YN
							}else{
								alTmpDtlRecords.add("N");
							}
											
							alTmpDtlRecords.add(checkForNull((String)hmTemp.get("REMARKS")));
							alTmpDtlRecords.add(checkForNull((String)hmTemp.get("EXPIRY_DATE")));
							alTmpDtlRecords.add((String)hmTemp.get("BIN_LOCATION_CODE"));
						
							alTmpDtlRecords.add(getLoginById());
							alTmpDtlRecords.add(getLoginAtWsNo());
							alTmpDtlRecords.add(getLoginFacilityId());
							alTmpDtlRecords.add(getLoginById());
							alTmpDtlRecords.add(getLoginAtWsNo());
							alTmpDtlRecords.add(getLoginFacilityId());
							
						
							alAckDTLData.add(alTmpDtlRecords);
						
								
				//SS_TRAY_DTLS_UPDATE DATA STARTS
				
				if(getTrn_type().equals("ISS")){
							
												
							alTemp = new ArrayList();

							if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A")){
								alTemp.add((String)hmDtlRecords.get("TO_STORE_CODE"));
								alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
								alTemp.add((String)hmDtlRecords.get("DOC_TYPE_CODE"));
								alTemp.add((String)hmDtlRecords.get("DOC_NO"));
								alTemp.add((String)hmDtlRecords.get("DOC_DATE"));
								alTemp.add("");//BLOCKED_BY
								alTemp.add("N"); //ACK_CONFIRM_REQD_YN Added against PMG2014-CRF-0008
							}else{
								alTemp.add("");
								alTemp.add("");
								alTemp.add("");
								alTemp.add("");
								alTemp.add("");
								alTemp.add((String)hmDtlRecords.get("TO_STORE_CODE")); //BLOCKED_BY
								alTemp.add("Y"); //ACK_CONFIRM_REQD_YN  Added against PMG2014-CRF-0008
							}

							alTemp.add("AK");
							
							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());							
							
							alTemp.add((checkForNull((String)hmTemp.get("ISSUE_GROUP_CODE"))));
							alTemp.add((checkForNull((String)hmTemp.get("TRAY_NO"))));
							
							alTraydtlData.add(alTemp);
					
				//SS_TRAY_DTLS_UPDATE DATA ENDS

				//ISSUE_DTL UPDATE STARTS
				
								hmDtlTemp = new HashMap();
															
								hmDtlTemp.put("facility_id",hmDtlRecords.get("FACILITY_ID"));
								hmDtlTemp.put("doc_type_code",hmTemp.get("DOC_TYPE_CODE"));
								hmDtlTemp.put("doc_no",hmTemp.get("DOC_NO"));
								hmDtlTemp.put("tray_no",hmTemp.get("TRAY_NO"));
								hmDtlTemp.put("issue_group_code",hmTemp.get("ISSUE_GROUP_CODE"));
							
								if(getAction_type().equals("A")){			
								ack_yn="AK";
								}else if(getAction_type().equals("C")) {
								ack_yn="RJ";
								}	
							
								hmDtlTemp.put("acknowledge_yn",ack_yn);
																						
								alDtlData.add(hmDtlTemp);
			//SS_ISSUE_DTLS_ACK_STATUS_UPDATE DATA ENDS
							
							 if(checkForNull((String)hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A") && getAction_type().equals("A")) {
								++iss_qty;
								alTemp = new ArrayList();
								alTemp.add(""+iss_qty);
								alTemp.add(""+iss_qty);//Blocked Qty..
								alTemp.add(getLoginById());
								alTemp.add(getLoginAtWsNo());
								alTemp.add(getLoginFacilityId());

								alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
								alTemp.add((String)hmDtlRecords.get("REQ_DOC_TYPE_CODE"));
								alTemp.add((String)hmDtlRecords.get("REQ_DOC_NO"));
								alTemp.add((String)hmTemp.get("REQ_GROUP_CODE"));

								alIssueQtyupdateData.add(alTemp);
								--iss_qty;
								 //Req_Group_Code = (String)hmTemp.get("REQ_GROUP_CODE");
						}
							

							//This is to reduce pending ack qty from group for store table only for Issue
							alPendAckQty = new ArrayList();
							
							alPendAckQty.add(getLoginById());
							alPendAckQty.add(getLoginAtWsNo());
							alPendAckQty.add(getLoginFacilityId());				
							alPendAckQty.add((String)hmDtlRecords.get("TO_STORE_CODE"));
							alPendAckQty.add((checkForNull((String)hmTemp.get("ISSUE_GROUP_CODE"))));

							alPendAckData.add(alPendAckQty);


		
					}else if(getTrn_type().equals("RTG")){

							hmDtlTemp = new HashMap();
							hmDtlTemp.put("facility_id",hmDtlRecords.get("FACILITY_ID"));
							hmDtlTemp.put("doc_type_code",hmTemp.get("DOC_TYPE_CODE"));
							hmDtlTemp.put("doc_no",hmTemp.get("DOC_NO"));
							hmDtlTemp.put("to_store_code",hmDtlRecords.get("TO_STORE_CODE"));
							hmDtlTemp.put("tray_no",hmTemp.get("TRAY_NO"));
							hmDtlTemp.put("return_group_code",hmTemp.get("RETURN_GROUP_CODE"));
							
							//if(getAction_type().equals("A")){	No cnfirmation status for Return so removed by Ganga

							if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A"))	
								hmDtlTemp.put("acknowledge_yn","AK");
							else if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R"))
								hmDtlTemp.put("acknowledge_yn","PN");
							
							hmDtlTemp.put("language_id",getLanguageId());
							
							alDtlData.add(hmDtlTemp);

							alTemp = new ArrayList();

				//Comented by Sakti Return Confirm CRF 07/04/2014 PMG2014-CRF-0008

							/*alTemp.add("");//STATUS
							alTemp.add("");//BLOCKED_BY (No use of Blocked by in Return) 

						if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A"))	
							alTemp.add("AK");
						else if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R"))	
							alTemp.add("RJ");*/
					//Added by Sakti Return Confirm CRF 07/04/2014 TD-PMG2014-CRF-0008
							if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A")){
								alTemp.add("");
								alTemp.add("");
								alTemp.add("");
								alTemp.add("");
								alTemp.add("");
								alTemp.add("");//BLOCKED_BY
								alTemp.add("U");//STATUS
								alTemp.add("N");//BLOCKED_YN
								alTemp.add("AK");
								alTemp.add("N"); //ACK_CONFIRM_REQD_YN  Added against PMG2014-CRF-0008
							}else{
								
								//String []parameters = {(checkForNull((String)hmTemp.get("RETURN_GROUP_CODE"))),(checkForNull((String)hmTemp.get("TRAY_NO")))};
								ArrayList alParams = new ArrayList ();
								alParams.add((checkForNull((String)hmTemp.get("RETURN_GROUP_CODE"))));
								alParams.add((checkForNull((String)hmTemp.get("TRAY_NO"))));
								HashMap hmTemp1 = (HashMap)fetchRecord( "SELECT ISS_FACILITY_ID, ISS_DOC_TYPE_CODE,ISS_DOC_NO,TO_CHAR (ISSUED_DATE, 'DD/MM/YYYY') ISSUED_DATE FROM SS_TRAY_DTLS WHERE GROUP_CODE=? AND TRAY_NO=?", alParams );
								
								alTemp.add("");
								alTemp.add((String)hmTemp1.get("ISS_FACILITY_ID"));//ISS_FACILITY_ID
								alTemp.add((String)hmTemp1.get("ISS_DOC_TYPE_CODE"));//ISS_DOC_TYPE_CODE
								alTemp.add((String)hmTemp1.get("ISS_DOC_NO"));//ISS_DOC_NO
								alTemp.add((String)hmTemp1.get("ISSUED_DATE"));//ISSUED_DATE
								alTemp.add((String)hmDtlRecords.get("FR_STORE_CODE")); //BLOCKED_BY
								alTemp.add("S");//STATUS
								alTemp.add("Y");//BLOCKED_YN
								alTemp.add("PN");  
								alTemp.add("Y"); //ACK_CONFIRM_REQD_YN  Added against PMG2014-CRF-0008
							}
						
							//Added ends
						
							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());
							
							alTemp.add((checkForNull((String)hmTemp.get("RETURN_GROUP_CODE"))));
							alTemp.add((checkForNull((String)hmTemp.get("TRAY_NO"))));
						
							alTraydtlData.add(alTemp);
				}
			}//Pending records not to consider Added ends

		}  //alTmpExpRecords LOOP ENDS

			
			//SS_RETURN_HDR_FINALIZE_UPDATE DATA STARTS
										
				 if(getTrn_type().equals("RTG")){
					
					//Added by Sakti against PMG2014-CRF-0008 starts
					 exist = false;						
						
					 	alTmpExp = (ArrayList)hmFinalTFRExpRecords.get((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"));
								for(int p=0;p<alTmpExp.size();p++){
									if( ((checkForNull((String)((HashMap)alTmpExp.get(p)).get("ACKNOWLEDGE_STATUS"))).equals("P")) ) {
									exist=true;
									break;
									}
								}
														
						alTemp = new ArrayList();
						if(exist){
							alTemp.add("N");//Finalized_YN
						}else{
							alTemp.add("Y");//Finalized_YN
						}
						
						//Added by Sakti against PMG2014-CRF-0008 ends
							
							
							alTemp.add("Y");//PROCESS FOR ACK
							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());
							
							alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
							alTemp.add((String)hmDtlRecords.get("DOC_TYPE_CODE"));
							alTemp.add((String)hmDtlRecords.get("DOC_NO"));
							alHdrData.add(alTemp);
						//SS_RETURN_HDR_FINALIZE_UPDATE DATA ENDS
						//	}
					
						}
				}
			}
			
			}
		} else{//Newly Added code if direct checking check box and apply . Against BRU-HIMS-CRF-376
						
			loadTFRExpData( docNoValue, docSeqNo);
						
			for(int i=0;i<alTFRDtlRecords.size();i++){
				hmDtlRecords = (HashMap)alTFRDtlRecords.get(i);
				dtl_doc_no = (String)hmDtlRecords.get("DOC_NO");
				dtl_seq_no = (String)hmDtlRecords.get("SEQ_NO");
				if(hmFinalTFRExpRecords.containsKey((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"))){ // doc_no and seq_no comparision between exp record and detail record starts
				//if(getDoc_no()+"~"+getSeq_no().equals((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"))) {
					if(  dtl_doc_no.equals( docNoValue) && dtl_seq_no. equals( docSeqNo) ) { // doc_no and seq_no comparision between checked record and detail record starts
						
							alParam = new ArrayList();
							alParam.add(getLoginFacilityId());
							alParam.add((String)hmDtlRecords.get("DOC_NO"));
							alParam.add(getDoc_type_code());
												
							
                            alCommonData.add(hmDtlRecords.get("FACILITY_ID"));
							alCommonData.add(getAction_type());

								 seq_no= Integer.parseInt((String)(((HashMap)fetchRecord("SELECT nvl(MAX(SEQ_NO),0) SEQ_NO FROM SS_ACKNOWLEDGE_TRN_HDR WHERE FACILITY_ID = ? AND DOC_NO = ? AND DOC_TYPE_CODE=? ",alParam)).get("SEQ_NO")));
								 ++seq_no;
							
								alTmpHdrRecords = new ArrayList();
								
								alTmpHdrRecords.add(hmDtlRecords.get("FACILITY_ID"));
								alTmpHdrRecords.add(getDoc_type_code());
								alTmpHdrRecords.add(hmDtlRecords.get("DOC_NO"));
								alTmpHdrRecords.add(""+seq_no);
								alTmpHdrRecords.add((String)hmDtlRecords.get("DOC_DATE"));
								alTmpHdrRecords.add(getTrn_type());
								alTmpHdrRecords.add((String)hmDtlRecords.get("FR_STORE_CODE"));
								alTmpHdrRecords.add((String)hmDtlRecords.get("TO_STORE_CODE"));
								alTmpHdrRecords.add("Y"); //ACKNOWLEDGE_YN
						
								alTmpExp = (ArrayList)hmFinalTFRExpRecords.get((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"));
								
								alTmpHdrRecords.add("N"); //CONFIRM_REQD_YN
								alTmpHdrRecords.add("N");
								alTmpHdrRecords.add("");  //CONFIRM_DATE
								
								alTmpHdrRecords.add(getLoginById());
								alTmpHdrRecords.add(getLoginAtWsNo());
								alTmpHdrRecords.add(getLoginFacilityId());
								alTmpHdrRecords.add(getLoginById());
								alTmpHdrRecords.add(getLoginAtWsNo());
								alTmpHdrRecords.add(getLoginFacilityId());
								
								alAckHdrData.add(alTmpHdrRecords);
						

							alTmpExpRecords = (ArrayList)hmFinalTFRExpRecords.get((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"));
							
						for(int j=0;j<alTmpExpRecords.size();j++){
								
							hmTemp = (HashMap)alTmpExpRecords.get(j);
							
							

							alTmpDtlRecords = new ArrayList();
							
							alTmpDtlRecords.add((String)hmDtlRecords.get("FACILITY_ID"));
							alTmpDtlRecords.add(getDoc_type_code());
							alTmpDtlRecords.add((String)hmDtlRecords.get("DOC_NO"));
							alTmpDtlRecords.add(""+seq_no);
							
							if(getTrn_type().equals("ISS")){
								alTmpDtlRecords.add((String)hmTemp.get("ISSUE_GROUP_CODE"));
							}else{
								alTmpDtlRecords.add((String)hmTemp.get("RETURN_GROUP_CODE"));
							}
							alTmpDtlRecords.add((String)hmTemp.get("TRAY_NO"));

							alTmpDtlRecords.add("Y");//ACK_YN
					
							/*if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R")){							
								alTmpDtlRecords.add("Y");//REJECT_YN
							}else{
								alTmpDtlRecords.add("N");
							}*/
							alTmpDtlRecords.add("N");
											
							alTmpDtlRecords.add(checkForNull((String)hmTemp.get("REMARKS")));
							alTmpDtlRecords.add(checkForNull((String)hmTemp.get("EXPIRY_DATE")));
							alTmpDtlRecords.add((String)hmTemp.get("BIN_LOCATION_CODE"));
						
							alTmpDtlRecords.add(getLoginById());
							alTmpDtlRecords.add(getLoginAtWsNo());
							alTmpDtlRecords.add(getLoginFacilityId());
							alTmpDtlRecords.add(getLoginById());
							alTmpDtlRecords.add(getLoginAtWsNo());
							alTmpDtlRecords.add(getLoginFacilityId());
							
						
							alAckDTLData.add(alTmpDtlRecords);
					
								
				//SS_TRAY_DTLS_UPDATE DATA STARTS
				
				if(getTrn_type().equals("ISS")){
							
												
							alTemp = new ArrayList();

								alTemp.add((String)hmDtlRecords.get("TO_STORE_CODE"));
								alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
								alTemp.add((String)hmDtlRecords.get("DOC_TYPE_CODE"));
								alTemp.add((String)hmDtlRecords.get("DOC_NO"));
								alTemp.add((String)hmDtlRecords.get("DOC_DATE"));
								alTemp.add("");//BLOCKED_BY
								alTemp.add("N");//ACK_CONFIRM_REQD_YN  Added against PMG2014-CRF-0008
								alTemp.add("AK");
							
							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());							
							
							alTemp.add((checkForNull((String)hmTemp.get("ISSUE_GROUP_CODE"))));
							alTemp.add((checkForNull((String)hmTemp.get("TRAY_NO"))));
							
							alTraydtlData.add(alTemp);
					
				//SS_TRAY_DTLS_UPDATE DATA ENDS

				//ISSUE_DTL UPDATE STARTS
				
								hmDtlTemp = new HashMap();
															
								hmDtlTemp.put("facility_id",hmDtlRecords.get("FACILITY_ID"));
								hmDtlTemp.put("doc_type_code",hmTemp.get("DOC_TYPE_CODE"));
								hmDtlTemp.put("doc_no",hmTemp.get("DOC_NO"));
								hmDtlTemp.put("tray_no",hmTemp.get("TRAY_NO"));
								hmDtlTemp.put("issue_group_code",hmTemp.get("ISSUE_GROUP_CODE"));
							
								hmDtlTemp.put("acknowledge_yn","AK");
																						
								alDtlData.add(hmDtlTemp);
			//SS_ISSUE_DTLS_ACK_STATUS_UPDATE DATA ENDS
							
			 	
						/* if(checkForNull((String)hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R") && getAction_type().equals("C")) {*/
								if(getAction_type().equals("C")) {			
								++reduce_blocked_qty;
								alTemp = new ArrayList();
								alTemp.add(""+reduce_blocked_qty);
								alTemp.add(getLoginById());
								alTemp.add(getLoginAtWsNo());
								alTemp.add(getLoginFacilityId());

								alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
								alTemp.add((String)hmDtlRecords.get("REQ_DOC_TYPE_CODE"));
								alTemp.add((String)hmDtlRecords.get("REQ_DOC_NO"));
								alTemp.add((String)hmTemp.get("REQ_GROUP_CODE"));
	
								alHdrData.add(alTemp);
								--reduce_blocked_qty;
						}/*else if(checkForNull((String)hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A") && getAction_type().equals("A")) {*/
								else if(getAction_type().equals("A")) {
								++iss_qty;
								alTemp = new ArrayList();
								alTemp.add(""+iss_qty);
								alTemp.add(""+iss_qty);//Blocked Qty..
								alTemp.add(getLoginById());
								alTemp.add(getLoginAtWsNo());
								alTemp.add(getLoginFacilityId());

								alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
								alTemp.add((String)hmDtlRecords.get("REQ_DOC_TYPE_CODE"));
								alTemp.add((String)hmDtlRecords.get("REQ_DOC_NO"));
								alTemp.add((String)hmTemp.get("REQ_GROUP_CODE"));

								alIssueQtyupdateData.add(alTemp);
								--iss_qty;
								 //Req_Group_Code = (String)hmTemp.get("REQ_GROUP_CODE");
						}
							

							//This is to reduce pending ack qty from group for store table only for Issue
							alPendAckQty = new ArrayList();
							
							alPendAckQty.add(getLoginById());
							alPendAckQty.add(getLoginAtWsNo());
							alPendAckQty.add(getLoginFacilityId());				
							alPendAckQty.add((String)hmDtlRecords.get("TO_STORE_CODE"));
							alPendAckQty.add((checkForNull((String)hmTemp.get("ISSUE_GROUP_CODE"))));

							alPendAckData.add(alPendAckQty);


		
					}else if(getTrn_type().equals("RTG")){

							hmDtlTemp = new HashMap();
							hmDtlTemp.put("facility_id",hmDtlRecords.get("FACILITY_ID"));
							hmDtlTemp.put("doc_type_code",hmTemp.get("DOC_TYPE_CODE"));
							hmDtlTemp.put("doc_no",hmTemp.get("DOC_NO"));
							hmDtlTemp.put("to_store_code",hmDtlRecords.get("TO_STORE_CODE"));
							hmDtlTemp.put("tray_no",hmTemp.get("TRAY_NO"));
							hmDtlTemp.put("return_group_code",hmTemp.get("RETURN_GROUP_CODE"));
							
							//if(getAction_type().equals("A")){	No cnfirmation status for Return so removed by Ganga

							/*if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A"))	
								hmDtlTemp.put("acknowledge_yn","AK");
							else if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R"))
								hmDtlTemp.put("acknowledge_yn","RJ");*/
							hmDtlTemp.put("acknowledge_yn","AK");
							hmDtlTemp.put("language_id",getLanguageId());
							
							alDtlData.add(hmDtlTemp);

							alTemp = new ArrayList();

							//Comented by Sakti Return Confirm CRF TD-PMG2014-CRF-0008
							/*alTemp.add("");//STATUS
							alTemp.add("");//BLOCKED_BY (No use of Blocked by in Return) */

						/*if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A"))	
							alTemp.add("AK");
						else if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R"))	
							alTemp.add("RJ");*/
						//Added by Sakti Return Confirm CRF TD-PMG2014-CRF-0008
							alTemp.add("");
							alTemp.add("");
							alTemp.add("");
							alTemp.add("");
							alTemp.add("");
							alTemp.add("");//BLOCKED_BY
							alTemp.add("U");//STATUS
							alTemp.add("N");//BLOCKED_YN
						//Added ends
							alTemp.add("AK");
							alTemp.add("N");//ACK_CONFIRM_REQD_YN  Added against PMG2014-CRF-0008

							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());
							
							alTemp.add((checkForNull((String)hmTemp.get("RETURN_GROUP_CODE"))));
							alTemp.add((checkForNull((String)hmTemp.get("TRAY_NO"))));
						
							alTraydtlData.add(alTemp);
				}

		}  //alTmpExpRecords LOOP ENDS

			
			//SS_RETURN_HDR_FINALIZE_UPDATE DATA STARTS
										
				 if(getTrn_type().equals("RTG")){
					
					 /*exist = false;						
						if(getAction_type().equals("A")){
					 	alTmpExp = (ArrayList)hmFinalTFRExpRecords.get((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"));
								for(int k=0;k<alTmpExp.size();k++){
									if( !((checkForNull((String)((HashMap)alTmpExp.get(k)).get("ACKNOWLEDGE_STATUS"))).equals("A")) ) {
									exist=true;
									}
								}
						}
						if(!exist){*/

							alTemp = new ArrayList();
							
							alTemp.add("Y");//Finalized_YN
							alTemp.add("Y");//PROCESS FOR ACK
							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());
							
							alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
							alTemp.add((String)hmDtlRecords.get("DOC_TYPE_CODE"));
							alTemp.add((String)hmDtlRecords.get("DOC_NO"));
							alHdrData.add(alTemp);
						//SS_RETURN_HDR_FINALIZE_UPDATE DATA ENDS
						//	}
					
						} //TRN_TYPE condition ended
					} // doc_no and seq_no comparision between checked record and detail record ends
				} // doc_no and seq_no comparision between exp record and detail record ends
			
			} //Dtl loop ends	
			
	    } // Direct checking checkbox and apply ends
	} //Checked Item loop ends
} //Checked Item size condition ends
} else if((getAction_type().equals("C"))) {	// This part is added to execute in confirm stage and getAction_type "A" condition ends
try{
			
			for(int i=0;i<alTFRDtlRecords.size();i++){
				hmDtlRecords = (HashMap)alTFRDtlRecords.get(i);
				if(hmFinalTFRExpRecords.containsKey((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"))){
				//if(getDoc_no()+"~"+getSeq_no().equals((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"))) {

							alParam = new ArrayList();
							alParam.add(getLoginFacilityId());
							alParam.add((String)hmDtlRecords.get("DOC_NO"));
							alParam.add(getDoc_type_code());
												
							
                            alCommonData.add(hmDtlRecords.get("FACILITY_ID"));
							alCommonData.add(getAction_type());

							
								confirm_date = com.ehis.util.DateUtils.getCurrentDate("DMY","en");
																												
								alTmpHdrRecords.add("Y");
								alTmpHdrRecords.add(getLoginById());
								alTmpHdrRecords.add(getLoginAtWsNo());
								alTmpHdrRecords.add(getLoginFacilityId());
								alTmpHdrRecords.add((String)hmDtlRecords.get("DOC_NO"));
								alTmpHdrRecords.add(getDoc_type_code());
								alTmpHdrRecords.add((String)hmDtlRecords.get("SEQ_NO"));

								alModAckHdrData.add(alTmpHdrRecords);
												

							alTmpExpRecords = (ArrayList)hmFinalTFRExpRecords.get((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"));
							
						for(int j=0;j<alTmpExpRecords.size();j++){
								
							hmTemp = (HashMap)alTmpExpRecords.get(j);
							
							
								
				//SS_TRAY_DTLS_UPDATE DATA STARTS
				
				if(getTrn_type().equals("ISS")){
							
							
							alTemp = new ArrayList();
							alTemp.add("U");//STATUS
							alTemp.add("");//BLOCKED_BY
							alTemp.add("RJ");
							alTemp.add("N"); //ACK_CONFIRM_REQD_YN Added against PMG2014-CRF-0008
							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());
							
							alTemp.add((checkForNull((String)hmTemp.get("ISSUE_GROUP_CODE"))));
							alTemp.add((checkForNull((String)hmTemp.get("TRAY_NO"))));
							
							alTraydtlData.add(alTemp);
				//SS_TRAY_DTLS_UPDATE DATA ENDS

				//ISSUE_DTL UPDATE STARTS
				
								hmDtlTemp = new HashMap();
															
								hmDtlTemp.put("facility_id",hmDtlRecords.get("FACILITY_ID"));
								hmDtlTemp.put("doc_type_code",hmTemp.get("DOC_TYPE_CODE"));
								hmDtlTemp.put("doc_no",hmTemp.get("DOC_NO"));
								hmDtlTemp.put("tray_no",hmTemp.get("TRAY_NO"));
								hmDtlTemp.put("issue_group_code",hmTemp.get("ISSUE_GROUP_CODE"));
													
								hmDtlTemp.put("acknowledge_yn","RJ");
																						
								alDtlData.add(hmDtlTemp);
			//SS_ISSUE_DTLS_ACK_STATUS_UPDATE DATA ENDS
							
			 	
								
								++reduce_blocked_qty;
								alTemp = new ArrayList();
								alTemp.add(""+reduce_blocked_qty);
								alTemp.add(getLoginById());
								alTemp.add(getLoginAtWsNo());
								alTemp.add(getLoginFacilityId());

								alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
								alTemp.add((String)hmDtlRecords.get("REQ_DOC_TYPE_CODE"));
								alTemp.add((String)hmDtlRecords.get("REQ_DOC_NO"));
								alTemp.add((String)hmTemp.get("REQ_GROUP_CODE"));
	
								alHdrData.add(alTemp);
								--reduce_blocked_qty;
					

							//This is to reduce pending ack qty from group for store table only for Issue
							alPendAckQty = new ArrayList();
							
							alPendAckQty.add(getLoginById());
							alPendAckQty.add(getLoginAtWsNo());
							alPendAckQty.add(getLoginFacilityId());				
							alPendAckQty.add((String)hmDtlRecords.get("TO_STORE_CODE"));
							alPendAckQty.add((checkForNull((String)hmTemp.get("ISSUE_GROUP_CODE"))));

							alPendAckData.add(alPendAckQty);


		
					}else if(getTrn_type().equals("RTG")){

							hmDtlTemp = new HashMap();
							hmDtlTemp.put("facility_id",hmDtlRecords.get("FACILITY_ID"));
							hmDtlTemp.put("doc_type_code",hmTemp.get("DOC_TYPE_CODE"));
							hmDtlTemp.put("doc_no",hmTemp.get("DOC_NO"));
							hmDtlTemp.put("to_store_code",hmDtlRecords.get("TO_STORE_CODE"));
							hmDtlTemp.put("tray_no",hmTemp.get("TRAY_NO"));
							hmDtlTemp.put("return_group_code",hmTemp.get("RETURN_GROUP_CODE"));
							
							//if(getAction_type().equals("A")){	No cnfirmation status for Return so removed by Ganga

							if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A"))	
								hmDtlTemp.put("acknowledge_yn","AK");
							else if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R"))
								hmDtlTemp.put("acknowledge_yn","RJ");
							
							hmDtlTemp.put("language_id",getLanguageId());
							
							alDtlData.add(hmDtlTemp);

							alTemp = new ArrayList();

							//Comented by Sakti Return Confirm CRF TD-PMG2014-CRF-0008
							/*alTemp.add("");//STATUS
							alTemp.add("");//BLOCKED_BY (No use of Blocked by in Return) 

						if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("A"))	
							alTemp.add("AK");
						else if((hmTemp.get("ACKNOWLEDGE_STATUS")).equals("R"))	
							alTemp.add("RJ");*/

							//Added by Sakti Return Confirm CRF TD-PMG2014-CRF-0008
							alTemp.add("");//BLOCKED_BY
							alTemp.add((String)hmDtlRecords.get("TO_STORE_CODE")); //CURR_STORE_CODE
							alTemp.add("RJ");//ACK_STATUS
							alTemp.add("N");//BLOCKED_YN
							alTemp.add("N"); //ACK_CONFIRM_REQD_YN  PMG2014-CRF-0008
							//Added ends TD-PMG2014-CRF-0008
						
							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());
							
							alTemp.add((checkForNull((String)hmTemp.get("RETURN_GROUP_CODE"))));
							alTemp.add((checkForNull((String)hmTemp.get("TRAY_NO"))));
						
							alTraydtlData.add(alTemp);
				}

		}  //alTmpExpRecords LOOP ENDS

			
			//SS_RETURN_HDR_FINALIZE_UPDATE DATA STARTS
										
				 if(getTrn_type().equals("RTG")){
					
					 /*exist = false;						
						if(getAction_type().equals("A")){
					 	alTmpExp = (ArrayList)hmFinalTFRExpRecords.get((String)hmDtlRecords.get("DOC_NO")+"~"+(String)hmDtlRecords.get("SEQ_NO"));
								for(int k=0;k<alTmpExp.size();k++){
									if( !((checkForNull((String)((HashMap)alTmpExp.get(k)).get("ACKNOWLEDGE_STATUS"))).equals("A")) ) {
									exist=true;
									}
								}
						}
						if(!exist){*/

							alTemp = new ArrayList();
							
							alTemp.add("N");//Finalized_YN
							alTemp.add("Y");//PROCESS FOR ACK
							alTemp.add(getLoginById());
							alTemp.add(getLoginAtWsNo());
							alTemp.add(getLoginFacilityId());
							
							alTemp.add((String)hmDtlRecords.get("FACILITY_ID"));
							alTemp.add((String)hmDtlRecords.get("DOC_TYPE_CODE"));
							alTemp.add((String)hmDtlRecords.get("DOC_NO"));
							alHdrData.add(alTemp);
						//SS_RETURN_HDR_FINALIZE_UPDATE DATA ENDS
						//	}
					
						}
			}
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}catch(Exception e){
	e.printStackTrace();
}
	
		hmTableData.put("properties",	getProperties());
		hmTableData.put("ACK_HDR_DATA",	alAckHdrData);
		hmTableData.put("ACK_DTL_DATA",	alAckDTLData);
		hmTableData.put("ACK_HDR_MOD_DATA",	alModAckHdrData);
		hmTableData.put("ACK_DTL_MOD_DATA",	alModAckDtlData);
		hmTableData.put("ACK_TRAY_DTL_MOD_DATA",	alTraydtlData);
		hmTableData.put("ISSUE_QTY_UPDATE_DATA",	alIssueQtyupdateData);		
		hmTableData.put("HDR_DATA",		alHdrData);
		hmTableData.put("DTL_DATA",		alDtlData);		
		hmTableData.put("COMMON_DATA",	alCommonData);
		hmTableData.put("LANGUAGE_DATA",allanguageData);
		hmTableData.put("GROUP_FOR_STORE_UPDATE_ACK",alPendAckData);
		//System.err.println("alDiscDtlInsertDatabefore setting==="+alDiscDtlInsertData);
		hmTableData.put("DiscDtlInsertData",		alDiscDtlInsertData);//Added for TH-KW-CRF-0026	

//System.out.println("alPendAckData"+alPendAckData);


		hmSQLMap.put("SS_SQL_SS_ACKNOWLEDGE_TRN_HDR_INSERT",getSsRepositoryValue("SS_SQL_SS_ACKNOWLEDGE_TRN_HDR_INSERT"));
		hmSQLMap.put("SS_SQL_SS_ACKNOWLEDGE_TRN_DTL_INSERT",getSsRepositoryValue("SS_SQL_SS_ACKNOWLEDGE_TRN_DTL_INSERT"));
		hmSQLMap.put("SS_SQL_SS_ACKNOWLEDGE_TRN_HDR_UPDATE",getSsRepositoryValue("SS_SQL_SS_ACKNOWLEDGE_TRN_HDR_UPDATE"));		
		//hmSQLMap.put("SS_SQL_SS_ACKNOWLEDGE_TRN_DTL_UPDATE","UPDATE SS_ACKNOWLEDGE_TRN_DTL SET ACKNOWLEDGE_YN=?, REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE DOC_NO = ? AND DOC_TYPE_CODE=? AND TRAY_NO=? AND BIN_LOCATION_CODE=? AND TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY')=?  AND SEQ_NO = ?");
		hmSQLMap.put("SQL_SS_TRAY_DTL_UPDATE_FROM_ACKNOWLEDGE",getSsRepositoryValue("SQL_SS_TRAY_DTL_UPDATE_FROM_ACKNOWLEDGE"));
		hmSQLMap.put("SQL_SS_TRAY_DTL_UPDATE_FROM_CONFIRM",getSsRepositoryValue("SQL_SS_TRAY_DTL_UPDATE_FROM_CONFIRM"));
		hmSQLMap.put( "SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_PEND_ACK_REDUCE",getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_PEND_ACK_REDUCE")	);
		//Added by Sakti against PMG2014-CRF-0008
		hmSQLMap.put("SQL_SS_TRAY_DTL_UPDATE_FROM_RETURN_ACKNOWLEDGE",getSsRepositoryValue("SQL_SS_TRAY_DTL_UPDATE_FROM_RETURN_ACKNOWLEDGE"));
		hmSQLMap.put("SQL_SS_TRAY_DTL_UPDATE_FROM_RETURN_CONFIRM",getSsRepositoryValue("SQL_SS_TRAY_DTL_UPDATE_FROM_RETURN_CONFIRM"));
		//Added ends
		hmSQLMap.put( "DiscDtlInsertSQL", getSsRepositoryValue("SQL_SS_RETURN_DISCREPANCY_DTL_INSERT")		);//Added for TH-KW-CRF-0026

		System.out.println("hmTableData"+hmTableData);
		System.out.println("hmSQLMap"+hmSQLMap);
		
		try{
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_SSACKNOWLEDGEMENT"),SSAcknowledgementLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();
			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else{
				if( hmResult.get("msgid")!=null  )
					hmResult.put( "message", getMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
					//hmResult.put( "message", (String) hmResult.get( "msgid" )) ;
				 else
					hmResult.put( "message", (String) hmResult.get( "msgid" ) ) ;
				if(hmResult.get("flag") != null)
					hmResult.put( "flag", replaceNewLineChar((String)hmResult.get("flag")) ) ;
				clear();
			}
		}catch(Exception e){
			e.printStackTrace();
			hmResult.put( "message", "Bean 393: "+e.toString()) ;
		}
		return hmResult;
	}
	
	public HashMap stockSQL(){

	HashMap hmSQLMap		=	new HashMap();
	if(getTrn_type().equals("ISS")){
		String SQL_SS_ISSUE_DTL_ACKNOWLEDGE_YN_FRLG_UPDATE="UPDATE ss_issue_dtl SET ACK_STATUS	= ? ,modified_by_id = ?,	modified_date =	sysdate, modified_at_ws_no = ?,	modified_facility_id = ?  WHERE facility_id = ? AND doc_type_code = ? AND doc_no = ? and tray_no=? and issue_group_code=?	";
		hmSQLMap.put("IssueDtlUpdateSQL", SQL_SS_ISSUE_DTL_ACKNOWLEDGE_YN_FRLG_UPDATE);
		hmSQLMap.put("stSQLReqDtlUpdate", getSsRepositoryValue("SQL_SS_REQUEST_DTL_UPDATE_FROM_CONFIRM"));
		hmSQLMap.put("stSQLReqDtlUpdateforissueqty", getSsRepositoryValue("SQL_SS_REQUEST_DTL_ISSUE_QTY_UPDATE"));
		
    }else if(getTrn_type().equals("RTG")){

		hmSQLMap.put("stSQLHdrUpdate", getSsRepositoryValue("SQL_SS_RETURN_HDR_FINALIZE_UPDATE"));
		String SQL_SS_RETURN_DTL_ACK_STATUS_YN_FLAG_UPDATE="UPDATE ss_return_dtl SET ACK_STATUS	= ? ,modified_by_id = ?,	modified_date =	sysdate, modified_at_ws_no = ?,	modified_facility_id = ?  WHERE facility_id = ? AND doc_type_code = ? AND doc_no = ? and tray_no=? and return_group_code=?	";
		hmSQLMap.put("stSQLDtlUpdate", SQL_SS_RETURN_DTL_ACK_STATUS_YN_FLAG_UPDATE);
	}	

	return hmSQLMap;
	}

	



	public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			HashMap hmTemp = (HashMap)fetchRecord("SELECT ISS_ACK_REQ_YN, RET_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId());
			if((checkForNull((String)hmTemp.get("ISS_ACK_REQ_YN"),"N")).equals("Y")){
				return true;
			}
			if((checkForNull((String)hmTemp.get("RET_ACK_REQ_YN"),"N")).equals("Y")){
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
	


}  
