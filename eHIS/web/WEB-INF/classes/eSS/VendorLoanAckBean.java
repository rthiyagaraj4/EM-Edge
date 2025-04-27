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
03/09/2015	IN057315		Badmavathi B 								Stock not updated after completing Acknowledge Vendor Loan for multiple Groups
06/04/2017	IN063878		Badmavathi B					        	Unused variables
--------------------------------------------------------------------------------------------------------------------
*/
package eSS; 

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import eSS.VendorLoanAck.*;

public class VendorLoanAckBean extends eSS.Common.SsTransaction implements
		Serializable {
	private String to_store_code = "";
	private String trn_type = "RQV";
	private String doc_type_code = "";
	private String fm_vendor_code = "";
	private String doc_no = "";
	private ArrayList alCheckedItems = new ArrayList();
	private HashMap hmHdrRemarks = new HashMap();
	private HashMap allocncode = new HashMap();

	private ArrayList alTFRDtlRecords = new ArrayList();
	private ArrayList alTFRExpRecords = new ArrayList();

	private HashMap hmFinalTFRExpRecords = new HashMap();
	private 	HashMap hmgroupRecords		= new HashMap();
	
	private String bin_location_code= "";

	
	public String getFm_vendor_code() {
		return fm_vendor_code;
	}

	public void setFm_vendor_code(String fm_vendor_code) {
		this.fm_vendor_code = fm_vendor_code;
	}
	
	public void setToStore(String to_store_code) {
		this.to_store_code = to_store_code;
	}

	public String getToStore() {
		return this.to_store_code;
	}

	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}

	public String getTrn_type() {
		return this.trn_type;
	}

	public void setDoc_type_code(String doc_type_code) {
		this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		return this.doc_type_code;
	}

	public void setTFRDtlRecords(ArrayList alDtlRecords) {
		this.alTFRDtlRecords = alDtlRecords;
	}

	public ArrayList getTFRDtlRecords() {
		return this.alTFRDtlRecords;
	}

	public void setTFRExpRecords(String doc_no, ArrayList exp_records) {
		hmFinalTFRExpRecords.put(doc_no, exp_records);
	}

	public ArrayList getTFRExpRecords(String doc_no) {
		if (hmFinalTFRExpRecords.containsKey(doc_no))
			return (ArrayList) this.hmFinalTFRExpRecords.get(doc_no);
		else
			return new ArrayList();
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getDoc_no() {
		return this.doc_no;
	}

	public String getalGroupRecords(String doc_no){
		if(hmgroupRecords.containsKey(doc_no))
			return (String)this.hmgroupRecords.get(doc_no);
		else
			return new String();
	}
	public void setalGroupRecords(String doc_no,String remarks){
	
		hmgroupRecords.put(doc_no,remarks);
	}
	public HashMap getalGroupRecords(){
		return hmgroupRecords;
	}
	public void removealGroupRecords(String doc_no_value){
		 hmgroupRecords.remove(doc_no_value);
	 }
	public void removealGroupRecords(){
		 hmgroupRecords.clear();
	 }
	public void setBin_location_code(String bin_location_code) {
		 this.bin_location_code = bin_location_code;
	}

	public String getBin_location_code() {
		 return this.bin_location_code;
	}



	public String getVendor_code_List() {
		return getListOptionTag(
				getListOptionArrayList(
						getSsRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST"),
						getLanguageId()));
	}

	public String getDoc_type_code_List(){
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getTrn_type());
		alParameters.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST"),alParameters));
	}

	public String getStore_code_List() {
		ArrayList arraylist = new ArrayList();
		arraylist.add(getLanguageId());
		arraylist.add(getLoginById());
		arraylist.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SS_SQL_SS_VENDOR_ACK_STORE_SELECT"),arraylist));
	}

	public void loadTFRDtlData(String req_from_date, String req_to_date,String doc_no, String group_code, String doc_ref) {

		String chkParameters[] = { getLanguageId(), getLanguageId(),getLanguageId(), req_from_date, req_to_date, doc_no,getDoc_type_code(), getToStore(), getFm_vendor_code(),getLoginFacilityId(), group_code, doc_ref };
		try {
				this.alTFRDtlRecords = fetchRecords(getSsRepositoryValue("SQL_SS_VENDOR_LOAN_ACK_HDR_SELECT"),chkParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadTFRExpData(String doc_no) {
		ArrayList alParameters = new ArrayList();
		
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(doc_no);
		alParameters.add(getDoc_type_code());
		alParameters.add(getLanguageId());

		//HashMap hmTemp = new HashMap();	Commented for unused variables IN063878
		try {
					this.alTFRExpRecords = fetchRecords(getSsRepositoryValue("SQL_SS_VENDOR_LOAN_ACK_DTL_SELECT"),alParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTFRExpRecords(doc_no, alTFRExpRecords);
	}

	public void updateSelectedValues(Hashtable selectedValues) {

		int total = Integer.parseInt((String) selectedValues
				.get("total_records"));

		String checkedIndices = (String) selectedValues.get("checkedIndices");
		String key = null;
		ArrayList alRemoveKey = new ArrayList(total);

		for (int i = 0; i < total; i++) {
			alRemoveKey.add((String) selectedValues.get("checkbox" + i));
		}

		alCheckedItems.removeAll(alRemoveKey);
		alRemoveKey = null;
		StringTokenizer checked = new StringTokenizer(checkedIndices, ",");
		ArrayList alAddKey = new ArrayList();
		while (checked.hasMoreElements()) {
			key = (String) checked.nextElement();
			if (key != null && key.trim() != "") {
				alAddKey.add((String) selectedValues.get("checkbox"
						+ key.trim()));
				hmHdrRemarks.put((String) selectedValues.get("checkbox"
						+ key.trim()),(String) selectedValues.get("remarks_"+ key.trim()));
				allocncode.put((String) selectedValues.get("checkbox"
						+ key.trim()),(String) selectedValues.get("bin_location_code_"+ key.trim()));
			}
		}
		alCheckedItems.addAll(alAddKey);
	}

	public ArrayList getCheckItems() {
		return alCheckedItems;
	}// Added ends

	public void setAll(Hashtable hashtable) {
			updateSelectedValues(hashtable);
	}

	public void clear() {
		super.clear();
		alTFRDtlRecords = new ArrayList();
		alTFRExpRecords = new ArrayList();
		hmFinalTFRExpRecords = new HashMap();
		alCheckedItems = new ArrayList();
		hmgroupRecords = new HashMap();
		hmHdrRemarks =  new HashMap();
		allocncode =  new HashMap();

	}

	public HashMap insert() {
		HashMap hmSQLMap = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmDtlRecords = new HashMap();
		HashMap hmTemp = new HashMap();
		ArrayList alAckHdrData = new ArrayList();
		ArrayList alAckHdrUpdData = new ArrayList();
		ArrayList alAckDTLData = new ArrayList();
		ArrayList alTmpHdrRecords = new ArrayList();
		ArrayList alTmpExpRecords = new ArrayList();
		ArrayList alTmpDtlRecords = new ArrayList();
		ArrayList alTmpHdrupdRecords = new ArrayList();
		ArrayList alTemp = null;
		ArrayList alIssueQtyupdateData = new ArrayList();
		//ArrayList alPendAckData = new ArrayList(); Commented for unused variables IN063878
		//ArrayList alPendAckQty = null; Commented for unused variables IN063878
		ArrayList alParameters =null;
		HashMap hmResult = new HashMap();
		String docNoValue = "";
		String dtl_doc_no = "", hdr_remarks="",allocn_code="";
		String dtl_doc_number = "";
		String grp_docno="",grp_code="",cntHdr="";
		try {
				if (alCheckedItems.size() > 0) {

					for (int l = 0; l < alCheckedItems.size(); l++) {
						docNoValue = (String) alCheckedItems.get(l);
						if (docNoValue == null || docNoValue.trim() == "")
							continue;
						if (hmHdrRemarks.containsKey(docNoValue)){
							hdr_remarks=checkForNull((String)hmHdrRemarks.get(docNoValue));
						}
						if (allocncode.containsKey(docNoValue)){
							allocn_code=checkForNull((String)allocncode.get(docNoValue));
						}
						alTmpExpRecords = (ArrayList) hmFinalTFRExpRecords.get(docNoValue);
						if (hmFinalTFRExpRecords.containsKey(docNoValue) && alTmpExpRecords.size()>0) {
							for (int i = 0; i < alTFRDtlRecords.size(); i++) {

								hmDtlRecords = (HashMap) alTFRDtlRecords.get(i);
								dtl_doc_number = (String) hmDtlRecords.get("DOC_NO");

								if (hmFinalTFRExpRecords.containsKey((String) hmDtlRecords.get("DOC_NO"))) {
									if (dtl_doc_number.equals(docNoValue)) {
										alParameters = new ArrayList();
										alParameters.add(getLoginFacilityId());
										alParameters.add(getDoc_type_code());
										alParameters.add(hmDtlRecords.get("DOC_NO"));
										alParameters.add("1");
										cntHdr=(String)((HashMap)fetchRecord(getSsRepositoryValue("SS_SQL_SS_VENDOR_ACK_DOC_CNT_SELECT"),alParameters)).get("CNT");
										if(cntHdr.equals("0")){
											alTmpHdrRecords = new ArrayList();
											alTmpHdrRecords.add(hmDtlRecords.get("FACILITY_ID"));
											alTmpHdrRecords.add(getDoc_type_code());
											alTmpHdrRecords.add(hmDtlRecords.get("DOC_NO"));
											alTmpHdrRecords.add("1");
											alTmpHdrRecords.add((String) hmDtlRecords.get("DOC_DATE"));
											alTmpHdrRecords.add(getTrn_type());
											alTmpHdrRecords.add((String) hmDtlRecords.get("REQ_TO_SUPP_CODE"));
											alTmpHdrRecords.add((String) hmDtlRecords.get("REQ_BY_STORE_CODE"));
											alTmpHdrRecords.add("Y"); // ACKNOWLEDGE_YN
											alTmpHdrRecords.add("N");
											alTmpHdrRecords.add("N");
											alTmpHdrRecords.add(""); // CONFIRM_DATE
											alTmpHdrRecords.add(getLoginById());
											alTmpHdrRecords.add(getLoginAtWsNo());
											alTmpHdrRecords.add(getLoginFacilityId());
											alTmpHdrRecords.add(getLoginById());
											alTmpHdrRecords.add(getLoginAtWsNo());
											alTmpHdrRecords.add(getLoginFacilityId());
											alTmpHdrRecords.add(checkForNull((String) hmTemp.get("BIN_LOCATION_CODE"),allocn_code));
											alAckHdrData.add(alTmpHdrRecords);
										}
										else{
											alTmpHdrupdRecords = new ArrayList();
											alTmpHdrupdRecords.add("Y");
											alTmpHdrupdRecords.add(getLoginById());
											alTmpHdrupdRecords.add(getLoginAtWsNo());
											alTmpHdrupdRecords.add(getLoginFacilityId());
											alTmpHdrupdRecords.add(getLoginFacilityId());
											alTmpHdrupdRecords.add(getDoc_type_code());
											alTmpHdrupdRecords.add(hmDtlRecords.get("DOC_NO"));
											alTmpHdrupdRecords.add("1");
											alAckHdrUpdData.add(alTmpHdrupdRecords);
										}

										alTmpExpRecords = (ArrayList) hmFinalTFRExpRecords.get((String) hmDtlRecords.get("DOC_NO"));

										for (int j = 0; j < alTmpExpRecords.size(); j++) {

											hmTemp = (HashMap) alTmpExpRecords.get(j);
											grp_docno=(String) hmDtlRecords.get("DOC_NO");
											grp_code=(String) hmTemp.get("GROUP_CODE");
											if (hmgroupRecords.containsKey(grp_docno+"-"+grp_code)) {
												alTmpDtlRecords = new ArrayList();

												alTmpDtlRecords.add((String) hmDtlRecords.get("FACILITY_ID"));
												alTmpDtlRecords.add(getDoc_type_code());
												alTmpDtlRecords.add((String) hmDtlRecords.get("DOC_NO"));
												alTmpDtlRecords.add("1");
												alTmpDtlRecords.add((String) hmTemp.get("GROUP_CODE"));
												alTmpDtlRecords.add((String) hmTemp.get("REQUEST_QTY"));//changed against IN057315
												alTmpDtlRecords.add("Y");// ACK_YN
												alTmpDtlRecords.add("N");
												alTmpDtlRecords.add(checkForNull((String) hmTemp.get("REMARKS"),hdr_remarks));
												alTmpDtlRecords.add("");
												alTmpDtlRecords.add("");
												alTmpDtlRecords.add(getLoginById());
												alTmpDtlRecords.add(getLoginAtWsNo());
												alTmpDtlRecords.add(getLoginFacilityId());
												alTmpDtlRecords.add(getLoginById());
												alTmpDtlRecords.add(getLoginAtWsNo());
												alTmpDtlRecords.add(getLoginFacilityId());

												alAckDTLData.add(alTmpDtlRecords); 
												
												alTemp = new ArrayList();
												alTemp.add((String)hmTemp.get("REQUEST_QTY"));
												alTemp.add(getLoginById());
												alTemp.add(getLoginAtWsNo());
												alTemp.add(getLoginFacilityId());
												alTemp.add((String) hmDtlRecords.get("FACILITY_ID"));
												alTemp.add((String) hmDtlRecords.get("DOC_TYPE_CODE"));
												alTemp.add((String) hmDtlRecords.get("DOC_NO"));
												alTemp.add((String) hmTemp.get("GROUP_CODE"));
												alIssueQtyupdateData.add(alTemp);

											/*	alPendAckQty = new ArrayList();
												alPendAckQty.add((String) hmTemp.get("REQUEST_QTY"));
												alPendAckQty.add((String) hmTemp.get("REQUEST_QTY"));
												alPendAckQty.add(getLoginById());
												alPendAckQty.add(getLoginAtWsNo());
												alPendAckQty.add(getLoginFacilityId());
												alPendAckQty.add((String) hmDtlRecords.get("REQ_BY_STORE_CODE"));
												alPendAckQty.add((checkForNull((String) hmTemp.get("GROUP_CODE"))));
												alPendAckData.add(alPendAckQty);*/
											}
										} // alTmpExpRecords LOOP ENDS
									}
								}

							}
						} 
							else {// Execution this part if direct checking check box and apply .

							loadTFRDtlData("", "",docNoValue, "", "");
							loadTFRExpData(docNoValue);

							for (int i = 0; i < alTFRDtlRecords.size(); i++) {
								hmDtlRecords = (HashMap) alTFRDtlRecords.get(i);
								dtl_doc_no = (String) hmDtlRecords.get("DOC_NO");
								if (hmFinalTFRExpRecords.containsKey((String) hmDtlRecords.get("DOC_NO"))) { // doc_no and seq_no comparision between exp and detail record starts
									if (dtl_doc_no.equals(docNoValue)) { // doc_no and seq_no comparision between checked record and detail record starts
										alParameters = new ArrayList();
										alParameters.add(getLoginFacilityId());
										alParameters.add(getDoc_type_code());
										alParameters.add(hmDtlRecords.get("DOC_NO"));
										alParameters.add("1");
										cntHdr=(String)((HashMap)fetchRecord(getSsRepositoryValue("SS_SQL_SS_VENDOR_ACK_DOC_CNT_SELECT"),alParameters)).get("CNT");
										if(cntHdr.equals("0")){		
											alTmpHdrRecords = new ArrayList();//added for IN057315
											alTmpHdrRecords.add(hmDtlRecords.get("FACILITY_ID"));
											alTmpHdrRecords.add(getDoc_type_code());
											alTmpHdrRecords.add(hmDtlRecords.get("DOC_NO"));
											alTmpHdrRecords.add("1");
											alTmpHdrRecords.add((String) hmDtlRecords.get("DOC_DATE"));
											alTmpHdrRecords.add(getTrn_type());
											alTmpHdrRecords.add((String) hmDtlRecords.get("REQ_TO_SUPP_CODE"));
											alTmpHdrRecords.add((String) hmDtlRecords.get("REQ_BY_STORE_CODE"));
											alTmpHdrRecords.add("Y"); // ACKNOWLEDGE_YN
											alTmpHdrRecords.add("N"); // CONFIRM_REQD_YN
											alTmpHdrRecords.add("N");
											alTmpHdrRecords.add(""); // CONFIRM_DATE
											alTmpHdrRecords.add(getLoginById());
											alTmpHdrRecords.add(getLoginAtWsNo());
											alTmpHdrRecords.add(getLoginFacilityId());
											alTmpHdrRecords.add(getLoginById());
											alTmpHdrRecords.add(getLoginAtWsNo());
											alTmpHdrRecords.add(getLoginFacilityId());
											alTmpHdrRecords.add(allocn_code);
											alAckHdrData.add(alTmpHdrRecords);
										}
										else{
											alTmpHdrupdRecords = new ArrayList();
											alTmpHdrupdRecords.add("Y");
											alTmpHdrupdRecords.add(getLoginById());
											alTmpHdrupdRecords.add(getLoginAtWsNo());
											alTmpHdrupdRecords.add(getLoginFacilityId());
											alTmpHdrupdRecords.add(getLoginFacilityId());
											alTmpHdrupdRecords.add(getDoc_type_code());
											alTmpHdrupdRecords.add(hmDtlRecords.get("DOC_NO"));
											alTmpHdrupdRecords.add("1");
											alAckHdrUpdData.add(alTmpHdrupdRecords);
										}

										alTmpExpRecords = (ArrayList) hmFinalTFRExpRecords.get((String) hmDtlRecords.get("DOC_NO"));

										for (int j = 0; j < alTmpExpRecords.size(); j++) {

											hmTemp = (HashMap) alTmpExpRecords.get(j);

											alTmpDtlRecords = new ArrayList();

											alTmpDtlRecords.add((String) hmDtlRecords.get("FACILITY_ID"));
											alTmpDtlRecords.add(getDoc_type_code());
											alTmpDtlRecords.add((String) hmDtlRecords.get("DOC_NO"));
											alTmpDtlRecords.add("1");
											alTmpDtlRecords.add((String) hmTemp.get("GROUP_CODE"));
											alTmpDtlRecords.add((String) hmTemp.get("REQUEST_QTY"));//changed for IN057315
											alTmpDtlRecords.add("Y");// ACK_YN
											alTmpDtlRecords.add("N");
											alTmpDtlRecords.add(hdr_remarks);
											alTmpDtlRecords.add("");
											alTmpDtlRecords.add("");
											alTmpDtlRecords.add(getLoginById());
											alTmpDtlRecords.add(getLoginAtWsNo());
											alTmpDtlRecords.add(getLoginFacilityId());
											alTmpDtlRecords.add(getLoginById());
											alTmpDtlRecords.add(getLoginAtWsNo());
											alTmpDtlRecords.add(getLoginFacilityId());
											alAckDTLData.add(alTmpDtlRecords);

											alTemp = new ArrayList();
											alTemp.add((String)hmTemp.get("REQUEST_QTY"));
											alTemp.add(getLoginById());
											alTemp.add(getLoginAtWsNo());
											alTemp.add(getLoginFacilityId());
											alTemp.add((String) hmDtlRecords.get("FACILITY_ID"));
											alTemp.add((String) hmDtlRecords.get("DOC_TYPE_CODE"));
											alTemp.add((String) hmDtlRecords.get("DOC_NO"));
											alTemp.add((String) hmTemp.get("GROUP_CODE"));
											alIssueQtyupdateData.add(alTemp);

										/*	alPendAckQty = new ArrayList();
											alPendAckQty.add((String) hmTemp.get("REQUEST_QTY"));
											alPendAckQty.add((String) hmTemp.get("REQUEST_QTY"));
											alPendAckQty.add(getLoginById());
											alPendAckQty.add(getLoginAtWsNo());
											alPendAckQty.add(getLoginFacilityId());
											alPendAckQty.add((String) hmDtlRecords.get("REQ_BY_STORE_CODE"));
											alPendAckQty.add((checkForNull((String) hmTemp.get("GROUP_CODE"))));

											alPendAckData.add(alPendAckQty);*/
										} // alTmpExpRecords LOOP ENDS
									} // doc_no comparision between checked record and detail record ends
								} // doc_no  between exp record and detail record ends

							} // Dtl loop ends

						} // Direct checking checkbox and apply ends
					} // Checked Item loop ends
				} // Checked Item size condition ends
		} catch (Exception e) {
			e.printStackTrace();
		}

		hmTableData.put("properties", getProperties());
		hmTableData.put("ACK_HDR_DATA", alAckHdrData);
		hmTableData.put("ACK_DTL_DATA", alAckDTLData);
		hmTableData.put("ACK_HDR_UPDATE_DATA", alAckHdrUpdData);
		hmTableData.put("ISSUE_QTY_UPDATE_DATA", alIssueQtyupdateData);
	//	hmTableData.put("GROUP_FOR_STORE_UPDATE_ACK", alPendAckData);

		hmSQLMap.put("SS_SQL_SS_EXT_ACK_HDR_INSERT",getSsRepositoryValue("SS_SQL_SS_EXT_ACK_HDR_INSERT"));
		hmSQLMap.put("SS_SQL_SS_EXT_ACK_DTL_INSERT",getSsRepositoryValue("SS_SQL_SS_EXT_ACK_DTL_INSERT"));
		hmSQLMap.put("SS_SQL_SS_EXT_ACK_HDR_UPDATE",getSsRepositoryValue("SS_SQL_SS_EXT_ACK_HDR_UPDATE"));
	//	hmSQLMap.put("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_UNSTERILIZED_QTY",getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_UNSTERILIZED_QTY"));
		hmSQLMap.put("stSQLReqDtlUpdateforissueqty",getSsRepositoryValue("SQL_SS_EXT_REQ_DTL_ISSUE_QTY_UPDATE"));

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_VENDOR_LOAN_ACKNOWLEDGEMENT"),VendorLoanAckLocalHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create", null)).invoke(home, null);
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class[] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass();
			paramArray[1] = hmSQLMap.getClass();
			hmResult = (HashMap) (busObj.getClass().getMethod("insert",	paramArray)).invoke(busObj, argArray);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			if (((Boolean) hmResult.get("result")).booleanValue())
				hmResult.put("message",getMessage(getLanguageId(),(String) hmResult.get("msgid"), "ST"));
			else {
				if (hmResult.get("msgid") != null)
					hmResult.put("message",getMessage(getLanguageId(),(String) hmResult.get("msgid"), "ST"));
				else
					hmResult.put("message", (String) hmResult.get("msgid"));
				if (hmResult.get("flag") != null)
					hmResult.put("flag",replaceNewLineChar((String) hmResult.get("flag")));
				clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			hmResult.put("message", "Bean 393: " + e.toString());
		}
		return hmResult;
	}

	public String getBinLocation(String store) {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(store);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues);
		return optionValues;
		}
}