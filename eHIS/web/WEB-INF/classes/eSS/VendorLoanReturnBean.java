/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
10/09/2015	IN057334		Ramesh G										AAKH-CRF-0058 /04 - Return Vendor Loan - On Apply - no action [IN:057334]
06/04/2017	IN063878		Badmavathi B					        		Unused variables
--------------------------------------------------------------------------------------------------------------------
*/
package eSS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.*;
import eSS.Common.SsTransaction;
import eSS.VendorLoanReturn.VendorLoanReturnHome;
import eSS.VendorLoanReturn.VendorLoanReturnRemote;

public class VendorLoanReturnBean extends SsTransaction implements Serializable {
private String	doc_ref;
private String 	doc_type_code;
private String 	doc_no;
private String	request_type;
private String 	from_date;
private String 	to_date;
private String	doc_date;
private String	added_by_id;
private String 	return_from_store_code;
private String 	return_to_vendor_code;
private String 	entry_completed_yn;
private String  selectedLoanReturnDocNos;
private String 	trn_type;
private String  authorized;
private String  authorized_by_id;
private HashMap selDocGropuDetails;

private HashMap totalGroupQty;
	public HashMap getSelDocGropuDetails() {
		return selDocGropuDetails;
	}
	public void setSelDocGropuDetails(HashMap selDocGropuDetails) {
		this.selDocGropuDetails = selDocGropuDetails;
	}
	public HashMap getTotalGroupQty() {
		return totalGroupQty;
	}
	public void setTotalGroupQty(HashMap totalGroupQty) {
		this.totalGroupQty = totalGroupQty;
	}
	public VendorLoanReturnBean() {
		
	}
	public String getTrn_type() {
		return trn_type;
	}
	
	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}

	public void setDoc_type_code(String doc_type_code) {
		this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		return doc_type_code;
	}
	
	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getDoc_no() {
		return doc_no;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public String getRequest_type() {
		return request_type;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getFrom_date() {
		return from_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public String getTo_date() {
		return to_date;
	}
	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}

	public String getDoc_date() {
		return doc_date;
	}
	public void setAdded_by_id(String added_by_id) {
		this.added_by_id = added_by_id;
	}

	public String getAdded_by_id() {
		return added_by_id;
	}
	public void setReturn_from_store_code(String return_from_store_code) {
		this.return_from_store_code = return_from_store_code;
	}

	public String getReturn_from_store_code() {
		return return_from_store_code;
	}
	public void setReturn_to_vendor_code(String return_to_vendor_code) {
		this.return_to_vendor_code = return_to_vendor_code;
	}

	public String getReturn_to_vendor_code() {
		return return_to_vendor_code;
	}
	public void setEntry_completed_yn(String entry_completed_yn) {
		this.entry_completed_yn = entry_completed_yn;
	}

	public String getEntry_completed_yn() {
		return entry_completed_yn;
	}
	
	public String getAuthorized_by_id() {
		return authorized_by_id;
	}

	public void setAuthorized_by_id(String authorized_by_id) {
		this.authorized_by_id = authorized_by_id;
	}

	public String getAuthorized() {
		return authorized;
	}

	public void setAuthorized(String authorized) {
		this.authorized = authorized;
	}

	public String getSelectedLoanReturnDocNos() {
		return selectedLoanReturnDocNos;
	}

	public void setSelectedLoanReturnDocNos(String selectedLoanReturnDocNos) {
		this.selectedLoanReturnDocNos = selectedLoanReturnDocNos;
	}
	
	public void setDoc_ref(String doc_ref) {
		this.doc_ref = doc_ref;
	}

	public String getDoc_ref() {
		return doc_ref;
	}	
	
	public void loadData() throws Exception {
		ArrayList alParameters = new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());

		HashMap hmRecord = fetchRecord(
				getSsRepositoryValue("SQL_SS_VENDOR_LOAN_RETURN_HDR_SELECT_SINGLE"),
				alParameters);

		setDoc_ref((String) hmRecord.get("DOC_REF"));
		setReturn_from_store_code((String) hmRecord.get("FR_STORE_CODE"));
		setReturn_to_vendor_code((String) hmRecord.get("TO_SUPP_CODE"));
		setEntry_completed_yn((String) hmRecord.get("ENTRY_COMPLETED_YN"));		
		setDoc_date((String) hmRecord.get("DOC_DATE"));
		setFrom_date((String) hmRecord.get("DOC_DATE"));
		setTo_date((String) hmRecord.get("DOC_DATE"));
		setRequest_type((String) hmRecord.get("REQUEST_TYPE"));
		setAdded_by_id((String) hmRecord.get("ADDED_BY_ID"));
	}
	
	public void initialize() {
		super.initialize();		
	}
	public void clear() {
		super.clear();
		doc_ref = "";
		doc_type_code = "";
		doc_no = "";
		request_type = "";
		from_date = "";
		to_date = "";
		doc_date = "";
		added_by_id = "";
		return_from_store_code = "";
		return_to_vendor_code = "";
		entry_completed_yn = "";
		selectedLoanReturnDocNos ="";
		trn_type	=	"";
		authorized = "";
		authorized_by_id = "";
		selDocGropuDetails = new HashMap();
		totalGroupQty = new HashMap();
	}
	public void clearHashMaps(){
			selDocGropuDetails.clear();
			totalGroupQty.clear();			
	}
	
	public void setAll(Hashtable htRecordSet) {
		super.setAll(htRecordSet);
		
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setReturn_from_store_code((String) htRecordSet.get(""));
		setReturn_to_vendor_code((String) htRecordSet.get(""));
		setRequest_type((String) htRecordSet.get("request_type"));
		setFrom_date(com.ehis.util.DateUtils.convertDate(
				(String) htRecordSet.get("from_date"), "DMY", getLanguageId(),
				"en"));
		setTo_date(com.ehis.util.DateUtils.convertDate(
				(String) htRecordSet.get("to_date"), "DMY", getLanguageId(),
				"en"));
		setAdded_by_id((String) htRecordSet.get("added_by_id"));
		setEntry_completed_yn((String) htRecordSet.get("entry_completed_yn"));
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setTrn_type((String) htRecordSet.get("trn_type"));		
		setDoc_no((String) htRecordSet.get("doc_no"));
		setModuleId((String) htRecordSet.get("module_id"));
		
		setSelectedLoanReturnDocNos((String) htRecordSet.get("selectedLoanReturnDocNos"));		
		setAuthorized((String) htRecordSet.get("authorized"));		
		setAuthorized_by_id((String) htRecordSet.get("added_by_id"));	
		
	}
	public String getDoc_type_code_List() {
		return getDoc_type_code_ListOptions("RTV", getDoc_type_code());
	}
	public String getReturn_from_store_code_List() {
		System.out.println("I am in getReturn_from_store_code_List");
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLanguageId());
		alParam.add(login_by_id);
		alParam.add(login_facility_id);
		return getListOptionTag(
				getListOptionArrayList(
						getSsRepositoryValue("SQL_SS_VENDOR_LOAN_RETURN_FROM_STORE_SELECT_LIST"),
						alParam), getReturn_from_store_code());
		
	}
	public String getReq_on_vendor_code_List() {
		System.out.println("I am in getReq_on_vendor_code_List");
		return getListOptionTag(
				getListOptionArrayList(
						getSsRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST"),
						getLanguageId()), getReturn_to_vendor_code());
	}
	public String getRequest_type_List() {
		System.out.println("I am in getRequest_type_List");
		return getStaticListOptionTag("A,All;N,Normal;U,Urgent;E,Elective",
				getRequest_type());
	}
	
	public ArrayList getSelectedList(){
		
		ArrayList selectedList = new ArrayList();
		
		ArrayList<String> alParameters = new ArrayList<String>();
		
		StringBuffer sqlQuery = new StringBuffer();
		
		
		
		sqlQuery.append("SELECT RH.DOC_NO,RH.DOC_TYPE_CODE, (SELECT SHORT_DESC FROM SY_DOC_TYPE_MASTER_LANG_VW WHERE  DOC_TYPE_CODE=RH.DOC_TYPE_CODE AND STATUS IS NULL AND LANGUAGE_ID=?) SHORT_DESC, TO_CHAR(RH.DOC_DATE,'DD-MM-YYYY')DOC_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE APPL_USER_ID=RH.ADDED_BY_ID AND LANGUAGE_ID=?) APPL_USER_NAME, DECODE(RH.REQUEST_TYPE,'N','Normal','U','Urgent','E','Elective') REQUEST_TYPE,GET_VENDOR_LOAN_RETURN_DTL(RH.DOC_NO,RH.FACILITY_ID,?) RETURN_ALLOWEDDETAIL FROM ");
		if("1".equals(getMode())){
			sqlQuery.append(" SS_EXT_REQ_HDR RH,SS_EXT_ACK_HDR AH WHERE RH.DOC_NO=AH.DOC_NO AND RH.DOC_NO NOT IN (SELECT DOC_NO FROM SS_EXT_RETURN_HDR WHERE DOC_NO=RH.DOC_NO)  ");
			sqlQuery.append("AND RH.REQ_BY_STORE_CODE =? AND RH.REQ_TO_SUPP_CODE=? ");
		}else if("2".equals(getMode())){
			sqlQuery.append(" SS_EXT_RETURN_HDR RH WHERE RH.DOC_NO=? AND RH.DOC_TYPE_CODE=? ");
			sqlQuery.append("AND RH.FR_STORE_CODE =? AND RH.TO_SUPP_CODE=? ");
		}
		
		if(!"A".equals(getRequest_type()))
			sqlQuery.append(" AND RH.REQUEST_TYPE = ? ");
		if(!"".equals(getFrom_date()) && !"".equals(getTo_date()))
			sqlQuery.append(" AND RH.DOC_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') ");
		else if(!"".equals(getFrom_date()) && "".equals(getTo_date()))
			sqlQuery.append(" AND RH.DOC_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(SYSDATE, 'DD/MM/YYYY') ");
		else if("".equals(getFrom_date()) && !"".equals(getTo_date()))
			sqlQuery.append(" AND  TO_DATE(a.DOC_DATE, 'DD/MM/YYYY') < TO_DATE(?, 'DD/MM/YYYY') ");
		   
		sqlQuery.append(" AND RH.ADDED_BY_ID = ?");
		sqlQuery.append(" AND RH.FACILITY_ID = ?");		
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		if("2".equals(getMode())){
			alParameters.add(getDoc_no());
			alParameters.add(getDoc_type_code());
		}
		alParameters.add(getReturn_from_store_code());
		alParameters.add(getReturn_to_vendor_code());
		
		if(!"A".equals(getRequest_type())){
			alParameters.add(getRequest_type());
		}
		if(!"".equals(getFrom_date()) && !"".equals(getTo_date())){
			alParameters.add(getFrom_date());
			alParameters.add(getTo_date());
		}else if(!"".equals(getFrom_date()) && "".equals(getTo_date())){	
			alParameters.add(getFrom_date());
		}else if("".equals(getFrom_date()) && !"".equals(getTo_date())){
			alParameters.add(getTo_date());
		}
		alParameters.add(getAdded_by_id());	
		alParameters.add(getLoginFacilityId());	
		
		try{
			selectedList =fetchRecords(sqlQuery.toString(),alParameters);
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		return selectedList;
	}
	public ArrayList getSelectedList(String doc_no,String doc_type_code){
		ArrayList selectGroupList = new ArrayList();		
		ArrayList<String> alParameters = new ArrayList<String>();		
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT RD.REQ_GROUP_CODE, B.SHORT_DESC GROUP_DESC, (SELECT SHORT_DESC FROM SS_SURGERY_TYPE_LANG_VW WHERE SURGERY_TYPE=B.SURGERY_TYPE AND LANGUAGE_ID=? ) SURGERY_DESC, (SELECT D.SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW D WHERE D.NATURE_CODE = ((SELECT DISTINCT (SURGERY_NATURE_CODE) FROM SS_SURGERY_TYPE WHERE SURGERY_TYPE= B.SURGERY_TYPE)) AND D.LANGUAGE_ID = ?) SURGERY_TYPE, RD.REQUEST_QTY REQUEST_QTY, RD.ISSUE_QTY ACK_QTY, AD.REMARKS  FROM SS_EXT_REQ_HDR Rh, SS_EXT_REQ_DTL RD, SS_GROUP_LANG_VW B, SS_EXT_ACK_DTL AD WHERE RH.FACILITY_ID = RD.FACILITY_ID AND RH.DOC_NO = RD.DOC_NO AND RH.DOC_TYPE_CODE = RD.DOC_TYPE_CODE AND RD.DOC_TYPE_CODE = AD.DOC_TYPE_CODE(+) AND RD.DOC_NO = AD.DOC_NO(+) AND RD.REQ_GROUP_CODE = AD.GROUP_CODE(+) AND RD.REQ_GROUP_CODE = B.GROUP_CODE AND RH.DOC_NO = ? /*AND RH.DOC_TYPE_CODE  = ?*/ AND B.LANGUAGE_ID=? AND RD.ISSUE_QTY IS NOT NULL ORDER BY GROUP_DESC");
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(doc_no);
		
		alParameters.add(getLanguageId());
		try{
			selectGroupList =fetchRecords(sqlQuery.toString(),alParameters);
		}catch(Exception e){
			e.printStackTrace();
		}
		return selectGroupList;
	}
	public HashMap insert() {
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		
		ArrayList alReturnHdrInsertData = new ArrayList();
		ArrayList alReturnDtlInsertData = new ArrayList();
		ArrayList alReturnDtlSTUpdateData = new ArrayList();
		ArrayList alReturnDtlROFUpdateData = new ArrayList();
		ArrayList alReturnDtlROFDelData = new ArrayList();
 		ArrayList alReturnDtlTRAYDelData = new ArrayList(); //IN057334
		
		ArrayList alParameters =null;
		ArrayList alTmpHdrRecords = null;
		ArrayList alTmpDtlRecords = null;
		ArrayList alUpdSTQtyRecords = null;
		ArrayList alUpdROFQtyRecords = null;
		ArrayList alDelSLQtyRecords = null;
		ArrayList alDelTRAYQtyRecords = null; //IN057334
		String[] stRecords = getSelectedLoanReturnDocNos().split(",");
		String selectedHdrRecords = "";
		try {
			if (getAuthorized().equals("Y")) {
				setAuthorized_by_id(getLoginById());
			}
			for(int i=0;i<stRecords.length;i++){
				if(i!=0)
					selectedHdrRecords = selectedHdrRecords+",'"+stRecords[i]+"'";
				else
					selectedHdrRecords ="'"+stRecords[i]+"'";
			}
			if(!"".equals(selectedHdrRecords)){				

				ArrayList docHDRDtls=	(ArrayList)fetchRecords("SELECT AH.FACILITY_ID FACILITY_ID,AH.DOC_TYPE_CODE DOC_TYPE_CODE,AH.DOC_NO DOC_NO,TO_CHAR(AH.DOC_DATE,'DD/MM/YYYY') DOC_DATE,AH.ISSUING_SUPP_CODE TO_SUPP_CODE,AH.RECEIVING_STORE_CODE FR_STORE_CODE,(SELECT REQUEST_TYPE FROM SS_EXT_REQ_HDR WHERE DOC_NO=AH.DOC_NO) REQUEST_TYPE FROM SS_EXT_ACK_HDR AH WHERE AH.DOC_NO IN("+selectedHdrRecords+")",alParameters);
				for(int j=0;j<docHDRDtls.size();j++){
					HashMap docHDRDtlsMap = (HashMap)docHDRDtls.get(j);
					alTmpHdrRecords = new ArrayList();
					
					alTmpHdrRecords.add(docHDRDtlsMap.get("FACILITY_ID"));
					alTmpHdrRecords.add(getDoc_type_code());
					alTmpHdrRecords.add(docHDRDtlsMap.get("DOC_NO"));
					alTmpHdrRecords.add(docHDRDtlsMap.get("DOC_DATE"));
					alTmpHdrRecords.add(docHDRDtlsMap.get("TO_SUPP_CODE"));
					alTmpHdrRecords.add(docHDRDtlsMap.get("FR_STORE_CODE"));
					alTmpHdrRecords.add(getEntry_completed_yn());
					alTmpHdrRecords.add(getAuthorized());
					alTmpHdrRecords.add(getTrn_type());
					alTmpHdrRecords.add(docHDRDtlsMap.get("REQUEST_TYPE"));
					alTmpHdrRecords.add(getLoginById());
					alTmpHdrRecords.add(getLoginAtWsNo());
					alTmpHdrRecords.add(getLoginFacilityId());
					alTmpHdrRecords.add(getLoginById());
					alTmpHdrRecords.add(getLoginAtWsNo());
					alTmpHdrRecords.add(getLoginFacilityId());
					
					alReturnHdrInsertData.add(alTmpHdrRecords);
				}
				
				ArrayList docDTLDtls =(ArrayList)fetchRecords("SELECT AH.RECEIVING_STORE_CODE STORE_CODE, AD.FACILITY_ID, AD.DOC_TYPE_CODE, AD.DOC_NO, AD.GROUP_CODE,RD.ISSUE_QTY FROM SS_EXT_ACK_DTL  AD,SS_EXT_ACK_HDR  AH, SS_EXT_REQ_DTL  RD WHERE  AD.DOC_NO = RD.DOC_NO AND AH.DOC_NO = AD.DOC_NO AND AH.DOC_NO = RD.DOC_NO AND AD.GROUP_CODE = RD.REQ_GROUP_CODE AND AD.DOC_NO IN ("+selectedHdrRecords+") ORDER BY AD.DOC_NO",alParameters);
				HashMap selDocGroupDetails = getSelDocGropuDetails();
				for(int k=0;k<docDTLDtls.size();k++){
					HashMap docDtlsMap = (HashMap)docDTLDtls.get(k);
					alTmpDtlRecords = new ArrayList();
					
					alTmpDtlRecords.add(docDtlsMap.get("FACILITY_ID"));
					alTmpDtlRecords.add(getDoc_type_code());
					alTmpDtlRecords.add(docDtlsMap.get("DOC_NO"));
					alTmpDtlRecords.add(docDtlsMap.get("GROUP_CODE"));
					alTmpDtlRecords.add(docDtlsMap.get("ISSUE_QTY"));					
					alTmpDtlRecords.add(getLoginById());
					alTmpDtlRecords.add(getLoginAtWsNo());
					alTmpDtlRecords.add(getLoginFacilityId());
					alTmpDtlRecords.add(getLoginById());
					alTmpDtlRecords.add(getLoginAtWsNo());
					alTmpDtlRecords.add(getLoginFacilityId());
					
					alReturnDtlInsertData.add(alTmpDtlRecords);		
					
					if("Y".equals(getAuthorized())){
					
						String packQty = (String)selDocGroupDetails.get("D_"+(String)docDtlsMap.get("DOC_NO")+"_"+(String)docDtlsMap.get("GROUP_CODE")+"PACk");
						String stQty = (String)selDocGroupDetails.get("D_"+(String)docDtlsMap.get("DOC_NO")+"_"+(String)docDtlsMap.get("GROUP_CODE")+"ST");
					
						if(!"0".equals(packQty)){								
							alUpdROFQtyRecords = new ArrayList();					
							alUpdROFQtyRecords.add(packQty);
							alUpdROFQtyRecords.add(packQty);
							alUpdROFQtyRecords.add(getLoginById());
							alUpdROFQtyRecords.add(getLoginAtWsNo());
							alUpdROFQtyRecords.add(getLoginFacilityId());
							alUpdROFQtyRecords.add((String) docDtlsMap.get("STORE_CODE"));
							alUpdROFQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));								
							alReturnDtlROFUpdateData.add(alUpdROFQtyRecords);
							
							alDelSLQtyRecords = new ArrayList();								
							alDelSLQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							alDelSLQtyRecords.add(getLoginFacilityId());
							alDelSLQtyRecords.add((Integer.parseInt(packQty)+1)+"");
							alReturnDtlROFDelData.add(alDelSLQtyRecords);
														
							alDelTRAYQtyRecords = new ArrayList();
							alDelTRAYQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							alDelTRAYQtyRecords.add((String) docDtlsMap.get("STORE_CODE"));
							alDelTRAYQtyRecords.add("R");
							alDelTRAYQtyRecords.add(getLoginFacilityId());
							alDelTRAYQtyRecords.add((Integer.parseInt(packQty)+1)+"");
							alReturnDtlTRAYDelData.add(alDelTRAYQtyRecords);
															
						}
						if(!"0".equals(stQty)){
							alUpdSTQtyRecords = new ArrayList();					
							alUpdSTQtyRecords.add(stQty);
							alUpdSTQtyRecords.add(stQty);
							alUpdSTQtyRecords.add(getLoginById());
							alUpdSTQtyRecords.add(getLoginAtWsNo());
							alUpdSTQtyRecords.add(getLoginFacilityId());
							alUpdSTQtyRecords.add((String) docDtlsMap.get("STORE_CODE"));
							alUpdSTQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							
							alReturnDtlSTUpdateData.add(alUpdSTQtyRecords);
							alDelSLQtyRecords = new ArrayList();								
							alDelSLQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							alDelSLQtyRecords.add(getLoginFacilityId());
							alDelSLQtyRecords.add((Integer.parseInt(stQty)+1)+"");								
							alReturnDtlROFDelData.add(alDelSLQtyRecords);
							
							alDelTRAYQtyRecords = new ArrayList();
							alDelTRAYQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							alDelTRAYQtyRecords.add((String) docDtlsMap.get("STORE_CODE"));
							alDelTRAYQtyRecords.add("S");
							alDelTRAYQtyRecords.add(getLoginFacilityId());
							alDelTRAYQtyRecords.add((Integer.parseInt(stQty)+1)+"");
							alReturnDtlTRAYDelData.add(alDelTRAYQtyRecords);
						}					
					}
				}				
				
				hmTableData.put("VENDOR_RETURN_HDR_DATA", alReturnHdrInsertData);
				hmTableData.put("VENDOR_RETURN__DTL_DATA", alReturnDtlInsertData);				
				hmTableData.put("GROUP_FOR_STORE_UPDATE_ST_VENDOR_RETURN", alReturnDtlSTUpdateData);
				
				hmTableData.put("GROUP_FOR_STORE_UPDATE_ROF_VENDOR_RETURN", alReturnDtlROFUpdateData);
				hmTableData.put("SS_ROF_DTL_DELEATE_VENDOR_RETURN", alReturnDtlROFDelData);
				hmTableData.put("SS_TRAY_DTL_DELEATE_VENDOR_RETURN", alReturnDtlTRAYDelData); //IN057334 
				
				hmSQLMap.put("SQL_SS_EXT_RETURN_HDR_INSERT",getSsRepositoryValue("SQL_SS_EXT_RETURN_HDR_INSERT"));
				hmSQLMap.put("SQL_SS_EXT_RETURN_DTL_INSERT",getSsRepositoryValue("SQL_SS_EXT_RETURN_DTL_INSERT"));
				hmSQLMap.put("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ST_VEDOR_RETURN_QTY",getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ST_VEDOR_RETURN_QTY"));
				
				hmSQLMap.put("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ROF_VEDOR_RETURN_QTY",getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ROF_VEDOR_RETURN_QTY"));
				hmSQLMap.put("SQL_SS_ROF_DTL_DELEATE_FOR_VEDOR_RETURN_QTY",getSsRepositoryValue("SQL_SS_ROF_DTL_DELEATE_FOR_VEDOR_RETURN_QTY"));
				hmSQLMap.put("SQL_SS_TRAY_DELEATE_FOR_VEDOR_RETURN_QTY",getSsRepositoryValue("SQL_SS_TRAY_DELEATE_FOR_VEDOR_RETURN_QTY")); //IN057334
				
			}			
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return VendorLoanReturnMethodCall(hmTableData, hmSQLMap,
				FUNCTION_INSERT);
	}
	
	public HashMap modify() {
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		
		ArrayList alReturnHdrInsertData = new ArrayList();
		// ArrayList alReturnDtlInsertData = new ArrayList(); Commented for unused variables IN063878
		ArrayList alReturnDtlSTUpdateData = new ArrayList();
		ArrayList alReturnDtlROFUpdateData = new ArrayList();
		ArrayList alReturnDtlROFDelData = new ArrayList();
		ArrayList alReturnDtlTRAYDelData = new ArrayList(); //IN057334
		
		ArrayList alParameters =null;
		ArrayList alTmpHdrRecords = null;
		//ArrayList alTmpDtlRecords = null; Commented for unused variables IN063878
		ArrayList alUpdSTQtyRecords = null;
		ArrayList alUpdROFQtyRecords = null;
		ArrayList alDelSLQtyRecords = null;
		ArrayList alDelTRAYQtyRecords = null; //IN057334
		String[] stRecords = getSelectedLoanReturnDocNos().split(",");
		String selectedHdrRecords = "";
		try {
			if (getAuthorized().equals("Y")) {
				setAuthorized_by_id(getLoginById());
			}
			for(int i=0;i<stRecords.length;i++){
				if(i!=0)
					selectedHdrRecords = selectedHdrRecords+",'"+stRecords[i]+"'";
				else
					selectedHdrRecords ="'"+stRecords[i]+"'";
			}
			if(!"".equals(selectedHdrRecords)){
				ArrayList docHDRDtls=	(ArrayList)fetchRecords("SELECT FACILITY_ID FACILITY_ID,DOC_TYPE_CODE DOC_TYPE_CODE,DOC_NO DOC_NO,TO_CHAR(DOC_DATE,'DD/MM/YYYY') DOC_DATE, TO_SUPP_CODE, FR_STORE_CODE FROM SS_EXT_RETURN_HDR WHERE DOC_NO IN("+selectedHdrRecords+")",alParameters);
				for(int j=0;j<docHDRDtls.size();j++){
					HashMap docHDRDtlsMap = (HashMap)docHDRDtls.get(j);
					alTmpHdrRecords = new ArrayList();
					
					alTmpHdrRecords.add(getEntry_completed_yn());
					alTmpHdrRecords.add(getAuthorized());					
					alTmpHdrRecords.add(getLoginById());
					alTmpHdrRecords.add(getLoginAtWsNo());
					alTmpHdrRecords.add(getLoginFacilityId());
					
					alTmpHdrRecords.add(docHDRDtlsMap.get("FACILITY_ID"));
					alTmpHdrRecords.add(getDoc_type_code());
					alTmpHdrRecords.add(docHDRDtlsMap.get("DOC_NO"));
					
					alReturnHdrInsertData.add(alTmpHdrRecords);
				}
				
				ArrayList docDTLDtls =(ArrayList)fetchRecords("SELECT AH.RECEIVING_STORE_CODE STORE_CODE, AD.FACILITY_ID, AD.DOC_TYPE_CODE, AD.DOC_NO, AD.GROUP_CODE,RD.ISSUE_QTY FROM SS_EXT_ACK_DTL  AD,SS_EXT_ACK_HDR  AH, SS_EXT_REQ_DTL  RD WHERE  AD.DOC_NO = RD.DOC_NO AND AH.DOC_NO = AD.DOC_NO AND AH.DOC_NO = RD.DOC_NO AND AD.GROUP_CODE = RD.REQ_GROUP_CODE AND AD.DOC_NO IN ("+selectedHdrRecords+") ORDER BY AD.DOC_NO",alParameters);
				HashMap selDocGroupDetails = getSelDocGropuDetails();
				for(int k=0;k<docDTLDtls.size();k++){
					HashMap docDtlsMap = (HashMap)docDTLDtls.get(k);							
					
					if("Y".equals(getAuthorized())){
						String packQty = (String)selDocGroupDetails.get("D_"+(String)docDtlsMap.get("DOC_NO")+"_"+(String)docDtlsMap.get("GROUP_CODE")+"PACk");
						String stQty = (String)selDocGroupDetails.get("D_"+(String)docDtlsMap.get("DOC_NO")+"_"+(String)docDtlsMap.get("GROUP_CODE")+"ST");
						System.out.println((String)docDtlsMap.get("DOC_NO")+"_"+(String)docDtlsMap.get("GROUP_CODE")+"PACk"+"--------652------>"+packQty);
						System.out.println((String)docDtlsMap.get("DOC_NO")+"_"+(String)docDtlsMap.get("GROUP_CODE")+"ST"+"----------653---->"+stQty);
						if(!"0".equals(packQty)){								
							alUpdROFQtyRecords = new ArrayList();					
							alUpdROFQtyRecords.add(packQty);
							alUpdROFQtyRecords.add(packQty);
							alUpdROFQtyRecords.add(getLoginById());
							alUpdROFQtyRecords.add(getLoginAtWsNo());
							alUpdROFQtyRecords.add(getLoginFacilityId());
							alUpdROFQtyRecords.add((String) docDtlsMap.get("STORE_CODE"));
							alUpdROFQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));								
							alReturnDtlROFUpdateData.add(alUpdROFQtyRecords);
							
							alDelSLQtyRecords = new ArrayList();								
							alDelSLQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							alDelSLQtyRecords.add(getLoginFacilityId());
							alDelSLQtyRecords.add((Integer.parseInt(packQty)+1)+"");
							alReturnDtlROFDelData.add(alDelSLQtyRecords);
														
							alDelTRAYQtyRecords = new ArrayList();
							alDelTRAYQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							alDelTRAYQtyRecords.add((String) docDtlsMap.get("STORE_CODE"));
							alDelTRAYQtyRecords.add("R");
							alDelTRAYQtyRecords.add(getLoginFacilityId());
							alDelTRAYQtyRecords.add((Integer.parseInt(packQty)+1)+"");
							alReturnDtlTRAYDelData.add(alDelTRAYQtyRecords);
															
						}
						if(!"0".equals(stQty)){
							alUpdSTQtyRecords = new ArrayList();					
							alUpdSTQtyRecords.add(stQty);
							alUpdSTQtyRecords.add(stQty);
							alUpdSTQtyRecords.add(getLoginById());
							alUpdSTQtyRecords.add(getLoginAtWsNo());
							alUpdSTQtyRecords.add(getLoginFacilityId());
							alUpdSTQtyRecords.add((String) docDtlsMap.get("STORE_CODE"));
							alUpdSTQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							
							alReturnDtlSTUpdateData.add(alUpdSTQtyRecords);
							alDelSLQtyRecords = new ArrayList();								
							alDelSLQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							alDelSLQtyRecords.add(getLoginFacilityId());
							alDelSLQtyRecords.add((Integer.parseInt(stQty)+1)+"");								
							alReturnDtlROFDelData.add(alDelSLQtyRecords);
							
							alDelTRAYQtyRecords = new ArrayList();
							alDelTRAYQtyRecords.add((checkForNull((String) docDtlsMap.get("GROUP_CODE"))));
							alDelTRAYQtyRecords.add((String) docDtlsMap.get("STORE_CODE"));
							alDelTRAYQtyRecords.add("S");
							alDelTRAYQtyRecords.add(getLoginFacilityId());
							alDelTRAYQtyRecords.add((Integer.parseInt(stQty)+1)+"");
							alReturnDtlTRAYDelData.add(alDelTRAYQtyRecords);
						}
						
					}
				}
				
				
				hmTableData.put("VENDOR_RETURN_HDR_UPDATE_DATA", alReturnHdrInsertData);							
				hmTableData.put("GROUP_FOR_STORE_UPDATE_ST_VENDOR_RETURN", alReturnDtlSTUpdateData);
				
				hmTableData.put("GROUP_FOR_STORE_UPDATE_ROF_VENDOR_RETURN", alReturnDtlROFUpdateData);
				hmTableData.put("SS_ROF_DTL_DELEATE_VENDOR_RETURN", alReturnDtlROFDelData);
				hmTableData.put("SS_TRAY_DTL_DELEATE_VENDOR_RETURN", alReturnDtlTRAYDelData); //IN057334
				
				hmSQLMap.put("SQL_SS_EXT_RETURN_HDR_UPDATE",getSsRepositoryValue("SQL_SS_EXT_RETURN_HDR_UPDATE"));				
				hmSQLMap.put("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ST_VEDOR_RETURN_QTY",getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ST_VEDOR_RETURN_QTY"));
				
				hmSQLMap.put("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ROF_VEDOR_RETURN_QTY",getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_ROF_VEDOR_RETURN_QTY"));
				hmSQLMap.put("SQL_SS_ROF_DTL_DELEATE_FOR_VEDOR_RETURN_QTY",getSsRepositoryValue("SQL_SS_ROF_DTL_DELEATE_FOR_VEDOR_RETURN_QTY"));
				hmSQLMap.put("SQL_SS_TRAY_DELEATE_FOR_VEDOR_RETURN_QTY",getSsRepositoryValue("SQL_SS_TRAY_DELEATE_FOR_VEDOR_RETURN_QTY")); //IN057334
			}
			
			
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return VendorLoanReturnMethodCall(hmTableData, hmSQLMap,FUNCTION_UPDATE );
	}
	public HashMap delete() {
		HashMap hmTableData = new HashMap();
		ArrayList alDeleteData = new ArrayList();
		HashMap hmSQLMap = new HashMap();
		

		alDeleteData.add(getLoginFacilityId());
		alDeleteData.add(getDoc_type_code());
		alDeleteData.add(new Long(getDoc_no()));

		

		hmSQLMap.put("HdrDeleteSQL",getSsRepositoryValue("SQL_SS_EXT_RETURN_HDR_DELETE"));
		hmSQLMap.put("DtlDeleteSQL",getSsRepositoryValue("SQL_SS_EXT_RETURN_DTL_DELETE"));
		

		hmTableData.put("properties", getProperties());
		hmTableData.put("DeleteData", alDeleteData);
		

		return VendorLoanReturnMethodCall(hmTableData, hmSQLMap,
				FUNCTION_DELETE);
	}
	
	public HashMap VendorLoanReturnMethodCall(HashMap hmTableData,
			HashMap hmSQLMap, int functionID) {

		HashMap hmResult = new HashMap();
		VendorLoanReturnRemote VendorLoanRequestRemote = null;
		hmResult.put(RESULT, FALSE);
		hmResult.put(MESSAGE, "Initial Message");

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					getSsRepositoryValue("JNDI_SS_VENDOR_LOAN_RETURN"),
					VendorLoanReturnHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class[] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass();
			paramArray[1] = hmSQLMap.getClass();

			switch (functionID) {
			case FUNCTION_INSERT:
				hmResult = (HashMap) (busObj.getClass().getMethod("insert",
						paramArray)).invoke(busObj, argArray);
				break;

			case FUNCTION_UPDATE:
				hmResult = (HashMap) (busObj.getClass().getMethod("modify",
						paramArray)).invoke(busObj, argArray);
				break;

			case FUNCTION_DELETE:
				hmResult = (HashMap) (busObj.getClass().getMethod("delete",
						paramArray)).invoke(busObj, argArray);
				break;

			default:
				hmResult.put("message",	"Invalid Function ID passed to VendorLoanRequestMethodCall()");
			}

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			if (((Boolean) hmResult.get("result")).booleanValue())
				hmResult.put(
						"message",
						getMessage(getLanguageId(),
								(String) hmResult.get("msgid"), "SS"));
			else if (hmResult.get("msgid") != null)
				hmResult.put(
						"message",
						getMessage(getLanguageId(),
								(String) hmResult.get("msgid"), "SS"));
			else
				hmResult.put("message",
						replaceNewLineChar((String) hmResult.get("message")));
		} catch (Exception exception) {
			hmResult.put("message", "Bean 383: " + exception.getMessage());
			exception.printStackTrace();
		} finally {
			try {
				if (VendorLoanRequestRemote != null)
					VendorLoanRequestRemote.remove();
			} catch (Exception exception) {
				hmResult.put("message", "Bean 393: " + exception.toString());
			}
		}
		return hmResult;

	}
	
	public ArrayList getGroupCodeDtls(String doc_nos){
		ArrayList groupCodeDtls = new ArrayList();		
		ArrayList<String> alParameters = new ArrayList<String>();		
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT DISTINCT RD.REQ_GROUP_CODE ,(SELECT COUNT(*) FROM SS_ROF_DTL SRD WHERE SRD.GROUP_CODE = RH.REQ_TO_SUPP_CODE AND SRD.ROF_STATUS='PACK')PACK_COUNT, (SELECT STERILIZED_QTY FROM SS_GROUP_FOR_STORE WHERE GROUP_CODE= RD.REQ_GROUP_CODE AND STORE_CODE=RH.REQ_BY_STORE_CODE) STRILIZED_COUNT FROM SS_EXT_REQ_HDR RH,SS_EXT_REQ_DTL RD WHERE RH.DOC_NO = RD.DOC_NO AND RD.DOC_NO IN ("+doc_nos+") ORDER BY RD.REQ_GROUP_CODE");
		try{
			groupCodeDtls =fetchRecords(sqlQuery.toString(),alParameters);
		}catch(Exception e){
			e.printStackTrace();
		}
		return groupCodeDtls;
	}
	public void loadHashMaps(String sel_doc_nos){
		ArrayList selectDocGroupList = new ArrayList();		
		ArrayList<String> alParameters = new ArrayList<String>();		
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT DISTINCT AD.GROUP_CODE GROUP_CODE,B.SHORT_DESC GROUP_DESC,AH.RECEIVING_STORE_CODE STORE_CODE,SG.STERILIZE_REQD_YN,SG.WASH_REQD_YN,SG.PACK_REQD_YN,(SELECT COUNT(*) FROM SS_ROF_DTL RD,SS_ROF_HDR RH WHERE RH.DOC_NO=RD.DOC_NO AND RD.GROUP_CODE= AD.GROUP_CODE AND RH.STORE_CODE= AH.RECEIVING_STORE_CODE AND RD.ROF_STATUS='PACK') PACK_QTY,(SELECT  STERILIZED_QTY  FROM SS_GROUP_FOR_STORE WHERE GROUP_CODE= AD.GROUP_CODE AND STORE_CODE=AH.RECEIVING_STORE_CODE) STERILIZED_QTY FROM SS_EXT_ACK_HDR AH,SS_EXT_ACK_DTL AD,SS_GROUP_LANG_VW B,SS_GROUP SG WHERE AH.DOC_NO = AD.DOC_NO AND AD.GROUP_CODE = B.GROUP_CODE AND AD.GROUP_CODE = SG.GROUP_CODE AND B.GROUP_CODE = SG.GROUP_CODE AND AD.DOC_NO IN ("+sel_doc_nos+") AND AD.FACILITY_ID=? AND B.LANGUAGE_ID = ? ORDER BY GROUP_CODE");
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLanguageId());		
		try{
			selectDocGroupList =fetchRecords(sqlQuery.toString(),alParameters);
			HashMap hmGroupRecord = new HashMap();
			HashMap hmGroupQty = new HashMap();
			//HashMap hmGroupDtl = new HashMap(); Commented for unused variables IN063878
			for(int i=0;i<selectDocGroupList.size();i++){
				hmGroupRecord=(HashMap)selectDocGroupList.get(i);
				Integer totalQty = Integer.parseInt(checkForNull((String)hmGroupRecord.get("PACK_QTY")))+Integer.parseInt(checkForNull((String)hmGroupRecord.get("STERILIZED_QTY")));
				hmGroupQty.put(checkForNull((String)hmGroupRecord.get("GROUP_CODE"))+"PACK",checkForNull((String)hmGroupRecord.get("PACK_QTY")));
				hmGroupQty.put(checkForNull((String)hmGroupRecord.get("GROUP_CODE"))+"ST",checkForNull((String)hmGroupRecord.get("STERILIZED_QTY")));
				hmGroupQty.put(checkForNull((String)hmGroupRecord.get("GROUP_CODE")),String.valueOf(totalQty));
				hmGroupQty.put(checkForNull((String)hmGroupRecord.get("GROUP_CODE"))+"STYN",checkForNull((String)hmGroupRecord.get("STERILIZE_REQD_YN")));
				hmGroupQty.put(checkForNull((String)hmGroupRecord.get("GROUP_CODE"))+"WAYN",checkForNull((String)hmGroupRecord.get("WASH_REQD_YN")));
				hmGroupQty.put(checkForNull((String)hmGroupRecord.get("GROUP_CODE"))+"PAYN",checkForNull((String)hmGroupRecord.get("PACK_REQD_YN")));
				hmGroupQty.put(checkForNull((String)hmGroupRecord.get("GROUP_CODE"))+"_DESC",checkForNull((String)hmGroupRecord.get("GROUP_DESC")));
			}
			setTotalGroupQty(hmGroupQty);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}