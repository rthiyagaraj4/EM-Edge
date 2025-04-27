/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      									ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package eSS;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;
import eSS.Common.SsTransaction;
import eSS.LoanRequestGroup.*;
import javax.servlet.http.HttpSession;

public class LoanRequestGroupBean extends SsTransaction implements Serializable {

	private String doc_ref;
	private String trn_type;
	private String req_by_store_code;
	private String authorized_by_id;
	private String req_on_store_code;
	private String entry_completed_yn;
	private String doc_type_code;
	private String doc_date;
	private String request_type;
	private String added_by_id;
	private String authorized;
	private String doc_no;
	private HashMap hmSsParameter = null;
	private String auth_group_desc;

	private String records_to_delete;
	private HttpSession session;
	private String module_id;// Added For OT CRF 35660 Bru-HIMS-CRF-268.1 by
	private String linenApplicableYN;//mmoh-crf-1661 
	
								// Ganga

	public String getLinenApplicableYN() {
		return linenApplicableYN;
	}

	public void setLinenApplicableYN(String linenApplicableYN) {
		this.linenApplicableYN = linenApplicableYN;
	}//END  

	private ArrayList selectedList;
	private ArrayList ModifySelectedList;
	private ArrayList DataList = new ArrayList();
	private HashMap dataList = new HashMap();
	private String records_to_process = "";
	private ArrayList alSelectedDetails;
	private ArrayList alModifyRecord;
	private ArrayList alDeSelectedDetails;
	private ArrayList alExistGroups;

	public LoanRequestGroupBean() {
		selectedList = new ArrayList();
		ModifySelectedList = new ArrayList();
		alSelectedDetails = new ArrayList();
		alModifyRecord = new ArrayList();
		alDeSelectedDetails = new ArrayList();
		alExistGroups = new ArrayList();
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setAuthorized(String authorized) {
		this.authorized = authorized;
	}

	public String getAuthorized() {
		return authorized;
	}

	public void setRecords_to_delete(String records_to_delete) {
		this.records_to_delete = records_to_delete;
	}

	public String getRecords_to_delete() {
		return records_to_delete;
	}

	public void initSsParameter() throws Exception {
		hmSsParameter = getSSParameter();
	}

	public void initDoc_type_code() {
		doc_type_code = checkForNull((String) hmSsParameter
				.get("DEF_RQL_DOC_TYPE_CODE"));
	}

	public void initDoc_date() {
		doc_date = hmSsParameter.get("SYS_DATE").toString();
	}

	public void setDoc_ref(String doc_ref) {
		this.doc_ref = checkForNull(doc_ref);
	}

	public String getDoc_ref() {
		return doc_ref;
	}

	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}

	public String getTrn_type() {
		return trn_type;
	}

	public void setReq_by_store_code(String req_by_store_code) {
		this.req_by_store_code = req_by_store_code;
	}

	public String getReq_by_store_code() {
		return req_by_store_code;
	}

	public void setAuthorized_by_id(String authorized_by_id) {
		this.authorized_by_id = checkForNull(authorized_by_id);
	}

	public String getAuthorized_by_id() {
		return authorized_by_id;
	}

	public void setReq_on_store_code(String req_on_store_code) {
		this.req_on_store_code = req_on_store_code;
	}

	public String getReq_on_store_code() {
		return req_on_store_code;
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		this.entry_completed_yn = checkForNull(entry_completed_yn, "N");
	}

	public String getEntry_completed_yn() {
		return entry_completed_yn;
	}

	public void setDoc_type_code(String doc_type_code) {
		this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		return doc_type_code;
	}

	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}

	public String getDoc_date() {
		return doc_date;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public String getRequest_type() {
		return request_type;
	}

	public void setAdded_by_id(String added_by_id) {
		this.added_by_id = added_by_id;
	}

	public String getAdded_by_id() {
		return added_by_id;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getDoc_no() {
		return doc_no;
	}

	public String getDoc_type_code_List() {
		return getDoc_type_code_ListOptions("RQL", getDoc_type_code());
	}

	public String getReq_on_store_code_List() {
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLanguageId());
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		return getListOptionTag(
				getListOptionArrayList(
						getSsRepositoryValue("SQL_SS_LOAN_REQ_ON_STORE_SELECT_LIST"),
						alParam), getReq_on_store_code());
	}

	public String getReq_by_store_code_List() {
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLanguageId());
		alParam.add(login_by_id);
		alParam.add(login_facility_id);
		return getListOptionTag(
				getListOptionArrayList(
						getSsRepositoryValue("SQL_SS_LOAN_REQ_BY_STORE_SELECT_LIST"),
						alParam), getReq_by_store_code());
	}

	public String getRequest_type_List() {
		return getStaticListOptionTag("N,Normal;U,Urgent;E,Elective",
				getRequest_type());
	}

	public void setModuleId(String module_id) {
		this.module_id = checkForNull(module_id, "SS");
	}

	public String getModuleId() {
		return this.module_id;
	}

	// added By Sakti Sankar against BRU-HIMS-CRF-373
	public String getRecords_to_process() {
		return records_to_process;
	}

	public void setRecords_to_process(String records_to_process) {
		this.records_to_process = records_to_process;
	}

	public ArrayList getDataList() {
		return DataList;
	}

	public void setDataList(ArrayList DataList) {
		this.DataList = DataList;
	}

	public ArrayList getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList selectedList) {
		this.selectedList = selectedList;
	}

	public ArrayList getModifySelectedList() {
		return ModifySelectedList;
	}

	public void setModifySelectedList(ArrayList ModifySelectedList) {
		this.ModifySelectedList = ModifySelectedList;
	}

	public void setnewalGroupRecords(String group_code) {
		alExistGroups.add(group_code);
	}

	public ArrayList getnewalGroupRecords() {

		return alExistGroups;
	}

	public void setAuth_Group_Desc(String auth_group_desc) {
		this.auth_group_desc = checkForNull(auth_group_desc);
	}

	public String getAuth_Group_Desc() {
		return auth_group_desc;
	}

	public void selectedBatches(Hashtable htTrays) {
		//String search_type = (String) htTrays.get("search_type"); //Comented by sakti as this is unused against inc#48061
		int i = 0;
		StringTokenizer st = new StringTokenizer((String) htTrays.get("index"),
				"!");
		while (st.hasMoreTokens()) {
			i = Integer.parseInt(st.nextToken());

			dataList = new HashMap();
			dataList.put("GROUP_CODE", (String) htTrays.get("group" + i));
			dataList.put("GROUP_DESC", (String) htTrays.get("desc" + i));
			dataList.put("mode", "1");
			dataList.put("AUTH_GROUP", (String) htTrays.get("auth_group" + i));
			dataList.put("GROUP_TYPE", (String) htTrays.get("group_type" + i));
			dataList.put("SURGERY_TYPE",(String) htTrays.get("surgery_type" + i));
			dataList.put("SURGERY_NAME",(String) htTrays.get("surgery_name" + i));
			dataList.put("QTY", (String) htTrays.get("qty" + i));
			dataList.put("AVLBL_STER_QTY",(String) htTrays.get("avlbl_ster_qty" + i));

			if (!isAlreadySelected((String) htTrays.get("group" + i))) {
				selectedList.add(dataList);
				alSelectedDetails.add((String) htTrays.get("group" + i));
			}
		}

		int j = 0;
		StringTokenizer ss = new StringTokenizer(
				(String) htTrays.get("unchecked_index"), "!");

		while (ss.hasMoreTokens()) {
			j = Integer.parseInt(ss.nextToken());

			dataList = new HashMap();

			dataList.put("GROUP_CODE", (String) htTrays.get("group" + j));
			dataList.put("GROUP_DESC", (String) htTrays.get("desc" + j));
			dataList.put("mode", "1");
			dataList.put("AUTH_GROUP", (String) htTrays.get("auth_group" + j));
			dataList.put("GROUP_TYPE", (String) htTrays.get("group_type" + j));
			dataList.put("SURGERY_TYPE",(String) htTrays.get("surgery_type" + j));
			dataList.put("SURGERY_NAME",(String) htTrays.get("surgery_name" + j));
			dataList.put("QTY", (String) htTrays.get("qty" + j));
			dataList.put("AVLBL_STER_QTY",(String) htTrays.get("avlbl_ster_qty" + j));

			alSelectedDetails.remove((String) htTrays.get("group" + j));

			selectedList.remove(dataList);
		}
	}

	public void setAlSelectedTrayDetails(String group_code) {
		alSelectedDetails.add(group_code);
	}

	public ArrayList getAlSelectedTrayDetails() {
		return alSelectedDetails;
	}

	public boolean isAlreadySelected(String groupCode_desc) {
		return alSelectedDetails.contains(groupCode_desc);
	}

	public boolean isModifyRecord(String groupCode_groupDesc) {
		return alModifyRecord.contains(groupCode_groupDesc);
	}

	public boolean isAlreadyDeSelected(String groupCode) {
		return alDeSelectedDetails.contains(groupCode);
	}

	// Added ends

	public void setAll(Hashtable htRecordSet) {
		super.setAll(htRecordSet);
		setAuthorized((String) htRecordSet.get("authorized"));
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setTrn_type((String) htRecordSet.get("trn_type"));
		setReq_by_store_code((String) htRecordSet.get("req_by_store_code"));
		setAuthorized_by_id((String) htRecordSet.get("authorized_by_id"));
		setReq_on_store_code((String) htRecordSet.get("req_on_store_code"));
		setEntry_completed_yn((String) htRecordSet.get("entry_completed_yn"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date(com.ehis.util.DateUtils.convertDate(
				(String) htRecordSet.get("doc_date"), "DMY", getLanguageId(),
				"en"));
		setRequest_type((String) htRecordSet.get("request_type"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setRecords_to_delete((String) htRecordSet.get("records_to_delete"));

		setModuleId((String) htRecordSet.get("module_id"));

	}

	public void clear() {
		super.clear();
		hmSsParameter = null;
		doc_ref = "";
		trn_type = "";
		req_by_store_code = "";
		authorized_by_id = "";
		req_on_store_code = "";
		entry_completed_yn = "";
		doc_type_code = "";
		doc_date = "";
		request_type = "";
		added_by_id = "";
		doc_no = "";
		authorized = "N";
		records_to_delete = "";
		module_id = "";
		linenApplicableYN = ""; //mmoh-crf-1661 

		if (selectedList != null) {
			selectedList.clear();
		}
		if (alSelectedDetails != null) {
			alSelectedDetails.clear();
		}
		if (alModifyRecord != null) {
			alModifyRecord.clear();
		}
		if (alDeSelectedDetails != null) {
			alDeSelectedDetails.clear();
		}
		if (alExistGroups != null) {
			alExistGroups.clear();
		}
	}

	public void initialize() {
		super.initialize();
		selectedList = new ArrayList();
		alSelectedDetails = new ArrayList();
		alModifyRecord = new ArrayList();
		alDeSelectedDetails = new ArrayList();
		alExistGroups = new ArrayList();
	}

	public HashMap validate() {
		HashMap hmReturn = new HashMap();
		//ArrayList alLoanRequestGroupList;
		hmReturn.put(RESULT, TRUE);
		if (getMode().equals(getCommonRepositoryValue("MODE_DELETE"))) {
			return hmReturn;
		}
		try {
			if (!getMode().equals(getCommonRepositoryValue("MODE_MODIFY")))
				if (!isDocNoAutoGenYN(getDoc_type_code())) {
					ArrayList alParameters = new ArrayList();
					alParameters.add(getLoginFacilityId());
					alParameters.add(getDoc_type_code());
					alParameters.add(new Long(getDoc_no()));
					if (!fetchRecord(
							getSsRepositoryValue("SQL_SS_LOAN_REQUEST_HDR_COUNT"),
							alParameters).get("TOTAL").toString().equals("0")) {
						throw new Exception("DUPLICATE_DOC_NO");
					}
				}
			int iValidDocDate = isValidDocDate(getDoc_date());

			switch (iValidDocDate) {
			case 1:
				throw new Exception("DOC_DT_NOT_LT_PROC_MTH");
			case 2:
				throw new Exception("DOC_DT_NOT_GR_SYSDATE");
			}

			if (getReq_by_store_code().equals(getReq_on_store_code()))
				throw new Exception("REQUEST_BOTH_STORE_SAME");

			// alRequestGroupList =
			// (ArrayList)session.getAttribute("alRequestGroupList");

			/*
			 * if((alRequestGroupList.size()==0)||(getRecords_to_delete().indexOf
			 * ("N")==-1)){ throw new Exception("MIN_ONE_DETAIL_REQUIRED"); }
			 */

			if ((DataList.size() == 0)
					|| (getRecords_to_delete().indexOf("N") == -1)) {
				throw new Exception("MIN_ONE_DETAIL_REQUIRED");
			}

		} catch (Exception exception) {
			hmReturn.put(RESULT, FALSE);
			hmReturn.put(MSGID, exception.getMessage());
			hmReturn.put(MESSAGE, exception.toString());
		}
		return hmReturn;
	}

	public HashMap insert() {

		HashMap hmTableData = new HashMap();
		ArrayList alHdrInsertData = new ArrayList();
		ArrayList alDtlInsertData = new ArrayList();
		//ArrayList alLoanRequestGroupList = null;
		HashMap hmSQLMap = new HashMap();
		StringTokenizer stRecordsToDel = new StringTokenizer(
				getRecords_to_delete(), ",");
		try {
			if (getAuthorized().equals("Y")) {
				setAuthorized_by_id(getLoginById());
			}
			if (isDocNoAutoGenYN(getDoc_type_code())) {
				setDoc_no(fetchNextDocNo(getDoc_type_code()));
			}
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add(getDoc_type_code());
			alHdrInsertData.add(new Long(getDoc_no()));
			alHdrInsertData.add(getDoc_date());
			alHdrInsertData.add(getReq_by_store_code());
			alHdrInsertData.add(getReq_on_store_code());
			alHdrInsertData.add(getDoc_ref());
			alHdrInsertData.add(getEntry_completed_yn());
			alHdrInsertData.add(getRequest_type());
			if (getAuthorized().equals("Y"))
				alHdrInsertData.add(getAuthorized_by_id());
			else
				alHdrInsertData.add("");

			alHdrInsertData.add(getTrn_type());
			alHdrInsertData.add(getAuthorized());
			alHdrInsertData.add(getModuleId());

			alHdrInsertData.add(getLoginById());
			alHdrInsertData.add(getLoginAtWsNo());
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add(getLoginById());
			alHdrInsertData.add(getLoginAtWsNo());
			alHdrInsertData.add(getLoginFacilityId());

			// alRequestGroupList =
			// (ArrayList)session.getAttribute("alRequestGroupList");

			for (int i = 0; i < DataList.size(); i++) {// Changed FROM
														// alRequestGroupList TO
														// DataList against
														// BRU-HIMS-CRF-373
				if (stRecordsToDel.nextToken().equals("N")) {
					alDtlInsertData.add((HashMap) DataList.get(i));
				}
			}

			hmSQLMap.put("HdrInsertSQL",
					getSsRepositoryValue("SQL_SS_LOAN_REQUEST_HDR_INSERT"));
			hmSQLMap.put("DtlInsertSQL",
					getSsRepositoryValue("SQL_SS_LOAN_REQUEST_DTL_INSERT"));
			hmSQLMap.put("NextDocNoUpdateSQL",
					getSsRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmSQLMap.put(
					"UpdateGroupForStoreSQL",
					getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_UPDATE"));

			hmTableData.put("isDocNoAutoGenYN", new Boolean(
					isDocNoAutoGenYN(getDoc_type_code())));
			hmTableData.put("properties", getProperties());
			hmTableData.put("HdrInsertData", alHdrInsertData);
			hmTableData.put("DtlInsertData", alDtlInsertData);

		} catch (Exception exception) {
			exception.printStackTrace();
			System.err.println("Requestgroupbean Insert hmTableData"
					+ hmTableData);
		}

		return loanRequestGroupMethodCall(hmTableData, hmSQLMap,
				FUNCTION_INSERT);
	}

	public HashMap modify() {

		HashMap hmTableData = new HashMap();
		ArrayList alHdrModifyData = new ArrayList();
		ArrayList alDtlModifyData = new ArrayList();
		ArrayList alCommonData = new ArrayList();
		//ArrayList alRequestGroupList = null;
		HashMap hmSQLMap = new HashMap();
		StringTokenizer stRecordsToDel = new StringTokenizer(
				getRecords_to_delete(), ",");

		if (getAuthorized().equals("Y")) {
			setAuthorized_by_id(getLoginById());
		}

		alHdrModifyData.add(getDoc_ref());
		alHdrModifyData.add(getEntry_completed_yn());
		alHdrModifyData.add(getRequest_type());

		if (getAuthorized().equals("Y"))
			alHdrModifyData.add(getAuthorized_by_id());
		else
			alHdrModifyData.add("");

		alHdrModifyData.add(getAuthorized());
		alHdrModifyData.add(getLoginById());
		alHdrModifyData.add(getLoginAtWsNo());
		alHdrModifyData.add(getLoginFacilityId());
		alHdrModifyData.add(getLoginFacilityId());
		alHdrModifyData.add(getDoc_type_code());
		alHdrModifyData.add(new Long(getDoc_no()));

		// alRequestGroupList =
		// (ArrayList)session.getAttribute("alRequestGroupList");
		// Changed FROM alRequestGroupList TO DataList against BRU-HIMS-CRF-373
		for (int i = 0; i < DataList.size(); i++) {
			HashMap hmRecord = (HashMap) DataList.get(i);
			if (stRecordsToDel.nextToken().equals("Y")) {
				if (hmRecord.get("mode").toString()
						.equals(getCommonRepositoryValue("MODE_INSERT")))
					continue;
				else
					hmRecord.put("mode",
							getCommonRepositoryValue("MODE_DELETE"));
			}

			alDtlModifyData.add(hmRecord);
		}

		alCommonData.add(getReq_by_store_code());
		alCommonData.add(getReq_on_store_code());

		hmSQLMap.put("HdrModifySQL",
				getSsRepositoryValue("SQL_SS_LOAN_REQUEST_HDR_UPDATE"));
		hmSQLMap.put("DtlModifySQL",
				getSsRepositoryValue("SQL_SS_LOAN_REQUEST_DTL_UPDATE"));
		hmSQLMap.put("DtlInsertSQL",
				getSsRepositoryValue("SQL_SS_LOAN_REQUEST_DTL_INSERT"));
		hmSQLMap.put("DtlDeleteSQL",
				getSsRepositoryValue("SQL_SS_LOAN_REQUEST_DTL_DELETE_GROUP"));
		hmSQLMap.put(
				"UpdateGroupForStoreSQL",
				getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_UPDATE"));
		hmSQLMap.put(
				"UpdateGroupForStoreReduceSQL",
				getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_REDUCE_UPDATE"));
		hmSQLMap.put("RequestQtySelectSQL",
				getSsRepositoryValue("SQL_SS_LOAN_REQUEST_DTL_REQ_QTY_SELECT"));

		hmTableData.put("properties", getProperties());
		hmTableData.put("HdrModifyData", alHdrModifyData);
		hmTableData.put("DtlModifyData", alDtlModifyData);
		hmTableData.put("alCommonData", alCommonData);

		return loanRequestGroupMethodCall(hmTableData, hmSQLMap,  
				FUNCTION_UPDATE);
	}

	public HashMap delete() {
		HashMap hmTableData = new HashMap();
		ArrayList alDeleteData = new ArrayList();
		HashMap hmSQLMap = new HashMap();
		ArrayList alHdrModifyData = new ArrayList();
		ArrayList alDtlModifyData = new ArrayList();
		//ArrayList alRequestGroupList = null;

		alDeleteData.add(getLoginFacilityId());
		alDeleteData.add(getDoc_type_code());
		alDeleteData.add(new Long(getDoc_no()));

		alHdrModifyData.add(getReq_by_store_code());
		alHdrModifyData.add(getLoginById());
		alHdrModifyData.add(getLoginAtWsNo());
		alHdrModifyData.add(getLoginFacilityId());

		// alRequestGroupList =
		// (ArrayList)session.getAttribute("alRequestGroupList");
		// Changed FROM alRequestGroupList TO DataList against BRU-HIMS-CRF-373
		for (int i = 0; i < DataList.size(); i++) {
			alDtlModifyData.add((HashMap) DataList.get(i));
		}

		hmSQLMap.put("HdrDeleteSQL",
				getSsRepositoryValue("SQL_SS_LOAN_REQUEST_HDR_DELETE"));
		hmSQLMap.put("DtlDeleteSQL",
				getSsRepositoryValue("SQL_SS_LOAN_REQUEST_DTL_DELETE"));
		hmSQLMap.put(
				"UpdateGroupForStoreReduceSQL",
				getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_REDUCE_UPDATE"));

		hmTableData.put("properties", getProperties());
		hmTableData.put("DeleteData", alDeleteData);
		hmTableData.put("HdrModifyData", alHdrModifyData);
		hmTableData.put("DtlModifyData", alDtlModifyData);

		return loanRequestGroupMethodCall(hmTableData, hmSQLMap,
				FUNCTION_DELETE);
	}

	public HashMap loanRequestGroupMethodCall(HashMap hmTableData,
			HashMap hmSQLMap, int functionID) {

		HashMap hmResult = new HashMap();
		LoanRequestGroupRemote loanRequestGroupRemote = null;
		hmResult.put(RESULT, FALSE);
		hmResult.put(MESSAGE, "Initial Message");

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					getSsRepositoryValue("JNDI_SS_LOAN_REQUEST_GROUP"),
					LoanRequestGroupHome.class, getLocalEJB());
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
				hmResult.put("message",
						"Invalid Function ID passed to LoanRequestGroupMethodCall()");
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
				if (loanRequestGroupRemote != null)
					loanRequestGroupRemote.remove();
			} catch (Exception exception) {
				hmResult.put("message", "Bean 393: " + exception.toString());
			}
		}
		return hmResult;

	}

	public void loadData() throws Exception {

		ArrayList alParameters = new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());

		HashMap hmRecord = fetchRecord(
				getSsRepositoryValue("SQL_SS_LOAN_REQUEST_HDR_SELECT_SINGLE"),
				alParameters);

		setDoc_ref((String) hmRecord.get("DOC_REF"));
		setReq_by_store_code((String) hmRecord.get("REQ_BY_STORE_CODE"));
		setReq_on_store_code((String) hmRecord.get("REQ_ON_STORE_CODE"));
		setEntry_completed_yn((String) hmRecord.get("ENTRY_COMPLETED_YN"));
		setDoc_date((String) hmRecord.get("DOC_DATE"));
		setRequest_type((String) hmRecord.get("REQUEST_TYPE"));
		setAdded_by_id((String) hmRecord.get("ADDED_BY_ID"));
	}

	// Added by Sakti against BRU-HIMS-CRF-373
	public void loadDtlData() {

		ArrayList alParameters = new ArrayList();
		ArrayList listRecord = new ArrayList();
		String stSQL = "";
		try {

			selectedList = new ArrayList();
			alSelectedDetails = new ArrayList();
			ArrayList alRecords = new ArrayList();

			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLoginFacilityId());
			alParameters.add(getDoc_type_code());
			alParameters.add(getDoc_no());
			alParameters.add(getReq_by_store_code());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());

			stSQL = eSS.Common.SsRepository
					.getSsKeyValue("SQL_SS_LOAN_REQUEST_DTL_SELECT_MULTIPLE");
			listRecord = fetchRecords(stSQL.toString(), alParameters);

			for (int i = 0; i < listRecord.size(); i++) {
				HashMap dataList = (HashMap) listRecord.get(i);

				dataList.put("GROUP_CODE",
						(String) dataList.get("REQ_GROUP_CODE"));
				dataList.put("GROUP_TYPE", (String) dataList.get("GROUP_TYPE"));
				// dataList.put("GROUP_DESC",java.net.URLEncoder.encode((String)dataList.get("SHORT_DESC"),"UTF-8"));
				dataList.put("GROUP_DESC", (String) dataList.get("SHORT_DESC"));
				dataList.put("QTY", (String) dataList.get("REQUEST_QTY"));
				dataList.put("AVLBL_STER_QTY",
						(String) dataList.get("STERILIZED_BLOCKED_QTY"));
				dataList.put("AUTH_GROUP_DESC",
						(String) dataList.get("AUTH_GROUP_DESC"));
				dataList.put("AUTH_GROUP_CODE",
						(String) dataList.get("AUTH_GROUP_CODE"));
				dataList.put(
						"SURGERY_TYPE",
						checkForNull(
								(String) dataList.get("SURGERY_TYPE_DESC"), ""));
				dataList.put(
						"SURGERY_NAME",
						checkForNull(
								(String) dataList.get("SURGERY_NAME_DESC"), ""));
				dataList.put("mode", "2");

				alSelectedDetails.add((String) dataList.get("REQ_GROUP_CODE"));
				alModifyRecord.add((String) dataList.get("REQ_GROUP_CODE"));

				alRecords.add(dataList);
				dataList = new HashMap();

			}
			setSelectedList(alRecords);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAuthGroupCode(String dflt_code, String auth_group,
			String req_by_store_code, String req_on_store_code) {

		String optionValues = null;
		ArrayList alOptionValues = new ArrayList();
		ArrayList alParam = new ArrayList();

		alParam.add(dflt_code);
		alParam.add(dflt_code);
		alParam.add(req_by_store_code);
		alParam.add(req_on_store_code);

		alOptionValues = getListOptionArrayList(
				eSS.Common.SsRepository
						.getSsKeyValue("SQL_SS_ALTERNATE_GROUP_SELECT_LIST"),
				alParam, false);
		optionValues = getListOptionTag(alOptionValues, auth_group);

		return optionValues;

	}

	public String getGroupType() {
		if(getLinenApplicableYN()!=null && getLinenApplicableYN().equals("Y")){//added for mmoh-crf-1661 
			return getStaticListOptionTag("A,All;T,Tray;E,Set;P,Soft Pack;S,Single;L,Linen;"); 

		}else{
			return getStaticListOptionTag("A,All;T,Tray;E,Set;P,Soft Pack;S,Single;");

		}
	}// Added ends

}
