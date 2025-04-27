/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for Return Group
*/
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
------------------------------------------------------------------------------------------------------------------------------------
7/7/2021		TFS:21052		Shazana			SS-MMS-Return Group[Error displayed if item code having special character hyphen (-)]
--------------------------------------------------------------------------------------------------------------------------------------
*/
package eSS;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.HashMap;
import eSS.Common.SsRepository;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import eCommon.Common.CommonRepository;
import eSS.Common.SsAdapter;
import eSS.ReturnGroup.ReturnGroupRemote;
import eSS.ReturnGroup.ReturnGroupHome;
import eSS.ReturnGroup.ReturnGroupManager;


public class ReturnGroupBean extends eSS.Common.SsTransaction implements java.io.Serializable {
	
	private ArrayList alTrayDetails;
	private ArrayList alSelectedTrayDetails;
	private ArrayList alSelectedDiscrepancyTrayDetails;
	private ArrayList alAddedTrayDetails;
	
	private java.util.Hashtable htDiscrepancyDetails;
	private java.util.Hashtable htSelectDiscrepancyDetail;
	private java.util.Hashtable htMaxIssuedQty;
	private java.util.Hashtable htDiscrepancyMain;
	private java.util.Hashtable htDiscrepancyKey;
	private java.util.Hashtable htSelectedDiscrepancyKey;
	private java.util.Hashtable htGroupTrayDiscrepancyKey;
	private java.util.ArrayList alDiscrepancyDetailsKey;
	// Used for editing the selected discrepancy detail
	private String currentEditingDiscrepancy = null;
	// Default Sterile Maps
	private java.util.HashMap hmSterileTypes = null;
	private String doc_ref;
	private String gl_interfaced_yn = "N"; // default
	private String trn_type;
	private String entry_completed_yn;
	private String db_entry_completed_yn;
    private String item_code ;
	private String doc_type_code;
	private String doc_date;
	private String doc_no;
	private String finalized_yn;
	private String facility_id;
	private String to_store_code;
	private String fr_store_code;
	private String non_returnable_yn;
	private String entered_by_id;
	private String write_off_reason_code;
	private String item_returnable_yn;
	private String rec_reference;
	private String discrepancy_qty;
	private String charge_option;
	private String remarks;
	private String used_status;
	private int descrepancy=0;

	private String group_code;
	private String tray_no;
	private String patient_id;
	private String patient_name;
	private boolean isAutoNo;
	private int[] insertDetailIndex;
	private int[] deleteDetailIndex;
	private int[] updateDetailIndex;
	
	public ReturnGroupBean() {
		alTrayDetails = new java.util.ArrayList();
		alSelectedTrayDetails = new java.util.ArrayList(); //Used for storing the selected tray list
		alDiscrepancyDetailsKey = new java.util.ArrayList(); 
		htMaxIssuedQty = new java.util.Hashtable();
		htDiscrepancyDetails = new java.util.Hashtable();
		htDiscrepancyMain = new java.util.Hashtable();
		htDiscrepancyKey = new java.util.Hashtable();
		htSelectedDiscrepancyKey = new java.util.Hashtable();
		htGroupTrayDiscrepancyKey = new java.util.Hashtable();
		hmSterileTypes = new java.util.HashMap();
		alAddedTrayDetails = new java.util.ArrayList();
	}

	public void clearSelectedTrays() {
		return;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref( ) {
		 return doc_ref;
	}
	public void setUsed_Status(String used_status) {
		 this.used_status = used_status;
	}

	public String getUsed_Status() {
		 return used_status;
	}
	public void setDiscrepancyQty(String discrepancy_qty) {
		 this.discrepancy_qty = discrepancy_qty;
	}

	public String getDiscrepancyQty( ) {
		 return discrepancy_qty;
	}
	public void setItemReturnable(String item_returnable_yn) {
		 this.item_returnable_yn = item_returnable_yn;
	}

	public String getItemReturnable( ) {
		 return item_returnable_yn;
	}
	public void setChargeOption(String charge_option) {
		 this.charge_option = charge_option;
	}

	public String getChargeOption( ) {
		 return charge_option;
	}
	public void setReceiptRef(String rec_reference) {
		 this.rec_reference = rec_reference;
	}

	public String getReceiptRef( ) {
		 return rec_reference;
	}
	public void setRemarks(String remarks) {
		 this.remarks = remarks;
	}

	public String getRemarks( ) {
		 return remarks;
	}
	
	public void setWriteOffReasonCode(String write_off_reason_code) {
		 this.write_off_reason_code = write_off_reason_code;
	}

	public String getWriteOffReasonCode( ) {
		 return write_off_reason_code;
	}
	public void setGl_interfaced_yn(String gl_interfaced_yn) {
		 this.gl_interfaced_yn = gl_interfaced_yn;
	}

	public String getGl_interfaced_yn( ) {
		 return gl_interfaced_yn;
	}

	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}

	public String getTrn_type( ) {
		 return trn_type;
	}

	public void setFr_store_code(String fr_store_code) {
		 this.fr_store_code = fr_store_code;
	}

	public String getFr_store_code( ) {
		 return fr_store_code;
	}

	public void setEntered_by_id(String entered_by_id) {
		this.entered_by_id = entered_by_id;
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		 this.entry_completed_yn = entry_completed_yn;
	}

	public String getEntry_completed_yn( ) {
		 return entry_completed_yn;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code( ) {
		 return doc_type_code;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public int getDescrepancy( ) {
		 return descrepancy;
	}

	public void setDescrepancy() {
		 this.descrepancy ++;
	}

	public String getDoc_date() {
		try {
			if(mode==null)
			return super.getSystemDate();
			if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				return super.getSystemDate();
			}
			else {
				return this.doc_date;
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return exception.toString();
		}
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no( ) {
		 return doc_no;
	}

	public void setTo_store_code(String to_store_code) {
		 this.to_store_code = to_store_code;
	}

	public String getTo_store_code( ) {
		 return to_store_code;
	}

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn = finalized_yn;
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}

	public void setFacility_id(String facility_id) {
		 this.facility_id = facility_id;
	}

	public String getFacility_id( ) {
		 return facility_id;
	}

	public void setNon_returnable_yn(String non_returnable_yn) {
		this.non_returnable_yn = non_returnable_yn;
	}

	public String getNon_returnable_yn() {
		return this.non_returnable_yn;
	}

	public void setTray_no(String tray_no) {
		this.tray_no = tray_no;
	}

	public String getTray_no() {	
		return this.tray_no;
	}

	public String getGroup_code() {
		return this.group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_code() {
		return item_code;
	}


	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	
	public String getPatient_name() {
		return patient_name;
	}	

	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}

	public String getLoginById() {
		System.out.println("MODE  "+mode);
		if(mode==null)
          return super.getLoginById();
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			return super.getLoginById();
		}
		else {
			return entered_by_id;
		}
	}

	public String getCurrentEditingDiscrepancy() {
		return currentEditingDiscrepancy;
	}

	public void setCurrentEditingDiscrepancy(String currentEditingDiscrepancy) {
		this.currentEditingDiscrepancy = currentEditingDiscrepancy;
	}

	public void selectDiscrepancyDetails(String key) {
		if (htDiscrepancyMain.containsKey(key)) {
			
			htDiscrepancyDetails = (java.util.Hashtable) htDiscrepancyMain.get(key);
			alDiscrepancyDetailsKey = (java.util.ArrayList) htDiscrepancyKey.get(key);
		}
		else {
			
			setCurrentEditingDiscrepancy(null);
			htDiscrepancyDetails = new java.util.Hashtable();
			alDiscrepancyDetailsKey = new java.util.ArrayList();
		}
	}

	public void setAll(Hashtable htResult) {
		setGroup_code((String)htResult.get("group_code"));
		setTray_no((String)htResult.get("tray_no"));
		setFr_store_code((String)htResult.get("return_from"));
		setTo_store_code((String)htResult.get("return_to"));
		setDoc_type_code((String)htResult.get("doc_type_code"));
		setDoc_no((String)htResult.get("doc_no"));
		setDoc_date(com.ehis.util.DateUtils.convertDate((String) htResult.get("doc_date"),"DMY",getLanguageId(),"en"));
		setDoc_ref((String)htResult.get("doc_ref"));
		setEntry_completed_yn(((String)htResult.get("entry_completed_yn")).equals("")?"N":"Y");
		setTrn_type((String)htResult.get("trn_type"));
		setFacility_id (getLoginFacilityId());
		setFinalized_yn(((String)htResult.get("finalize_yn")).equals(eSS.Common.SsRepository.getSsKeyValue("YES"))?"Y":"N");
		System.out.println("setFinalized_yn==========>"+getFinalized_yn());
		setIsAutoNo(htResult.get("autono_yn").equals((String)eSS.Common.SsRepository.getSsKeyValue("YES"))?true:false);
		String selectedDetailIndex = (String) htResult.get("records_for_submission");
		String selectedUpdateDetailIndex = (String) htResult.get("update_trays");
		String selectedDeleteDetailIndex = (String) htResult.get("delete_trays");
		// Used in insert mode
		java.util.StringTokenizer strTokens = new java.util.StringTokenizer(selectedDetailIndex,",");
		insertDetailIndex = new int[strTokens.countTokens()];
		int count = 0;
		while (strTokens.hasMoreElements()) {
			insertDetailIndex[count++] = Integer.parseInt(strTokens.nextToken());
		}
		// Used in update mode
		if (selectedUpdateDetailIndex.length()>0) {
			strTokens = new java.util.StringTokenizer(selectedUpdateDetailIndex,",");
			updateDetailIndex = new int[strTokens.countTokens()];
			count = 0;
			while (strTokens.hasMoreElements()) {
				updateDetailIndex[count++] = Integer.parseInt(strTokens.nextToken());
			}
		}
		if (selectedDeleteDetailIndex.length()>0) {
			strTokens = new java.util.StringTokenizer(selectedDeleteDetailIndex,",");
			deleteDetailIndex = new int[strTokens.countTokens()];
			count = 0;
			while (strTokens.hasMoreElements()) {
				deleteDetailIndex[count++] = Integer.parseInt(strTokens.nextToken());
			}
		}
	}

	public String getPatientName() {
		try {
			HashMap hmRecord = fetchRecord(getSsRepositoryValue("SQL_MP_PATIENT_SELECT_SINGLE"),getPatient_id());
			return (String) hmRecord.get("PATIENT_NAME");
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public String getDocTypes() {
		try {
			java.util.HashMap defaultParameter = getSSParameter();
			String defaultReturnGroup = (String) defaultParameter.get("DEF_RTG_DOC_TYPE_CODE");
			return getDoc_type_code_ListOptions("RTG", defaultReturnGroup);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	public String getDiscrepancyItems() {
	//SQL_SS_ITEM_FOR_GROUP_SELECT_LIST
		String sql = (String) getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,group_code);
		return getListOptionTag(alOptionValues,getItem_code());
	}

	public double getItemUnitCost(String itemCode) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		double itemCost = 0;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_SS_ITEM_FOR_GROUP_SELECT_ITEM_UNIT_COST"));
            pstmt.setString(1, itemCode);
            resultSet = pstmt.executeQuery();
            if ((resultSet != null) && resultSet.next()) {
				itemCost = resultSet.getDouble (1);
            }
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
        }
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return itemCost;
	}

	public String getReturnFrom(String dflt_store) {
		/*String sql = (String) getSsRepositoryValue("SQL_SS_STORE_FROM_SELECT_LIST");
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql, alParam);
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			return getListOptionTag(alOptionValues);
		}
		else {
			return getListOptionTag(alOptionValues,getFr_store_code());
		}*/
		String sql = (String) getSsRepositoryValue("SQL_SS_STORE_FROM_SELECT_LIST");
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		try{
			int cnt = Integer.parseInt((String)fetchRecord(getSsRepositoryValue("SQL_SS_STORE_FROM_SELECT_LIST_COUNT"),alParam).get("COUNT"));
			
				if(cnt == 1){
					dflt_store		=	(String)fetchRecord(sql,alParam).get("STORE_CODE");
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}

		java.util.ArrayList alOptionValues = getListOptionArrayList(sql, alParam);
			return getListOptionTag(alOptionValues,dflt_store);
	}

	public String getReturnTo(String dflt_store) {
		/*String sql = (String) getSsRepositoryValue("SQL_SS_STORE_TO_SELECT_LIST");
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,alParam);
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			return getListOptionTag(alOptionValues);
		}
		else {
			return getListOptionTag(alOptionValues,getTo_store_code());
		}*/
		String sql = (String) getSsRepositoryValue("SQL_SS_STORE_TO_SELECT_LIST");
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		try{
			int cnt = Integer.parseInt((String)fetchRecord(getSsRepositoryValue("SQL_SS_STORE_TO_SELECT_LIST_COUNT"),alParam).get("COUNT"));
			
				if(cnt == 1){
					dflt_store		=	(String)fetchRecord(sql,alParam).get("STORE_CODE");
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}

		java.util.ArrayList alOptionValues = getListOptionArrayList(sql, alParam);
			return getListOptionTag(alOptionValues,dflt_store);
	}

	public String getOptionValues(String sql,String defaultValue) {
		String optionValues = null;
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,defaultValue);
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
	}
	
	public ArrayList getSelectTray() {
		java.util.ArrayList alTrays = null;
		Connection connection = null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet = null;
		String sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRAY_DTLS_RG_QUERY_RESULT");
		int index = 0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, getFr_store_code());
			preparedStatement.setString(2, getTo_store_code ());
			resultSet = preparedStatement.executeQuery();
			alTrays = new java.util.ArrayList();
			while(resultSet.next()){
				String[] trayValues = new String[8];
				for (index = 0;index<trayValues.length;index++ ) {
					trayValues[index] = resultSet.getString(index+1);
				}
				alTrays.add(trayValues);
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		} 
		catch (Exception exception )	{
			exception.printStackTrace();
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return alTrays;
	}

	public void updateSelectedTrays(Hashtable htTrays) throws Exception{

		
		//Commented by Sakti against ML-BRU-SCF-1050 [IN:043893] due to problem in holding selected values in next previous
		
		//alSelectedTrayDetails.clear(); 
		//alTrayDetails.clear(); 
		
		//ends
		
		String tokens = (String) htTrays.get("chkdIndices");
		java.util.StringTokenizer strTokens = new java.util.StringTokenizer(tokens,",");
		int index[] = new int[strTokens.countTokens()];
		int count = 0;
		while (strTokens.hasMoreElements()) {
			index[count++] = Integer.parseInt(strTokens.nextToken());
		}
		for (int i=0;i<index.length;i++) {
			//String[] trayInfo = new String[22];
			String[] trayInfo = new String[24];
			trayInfo[0] = (String) htTrays.get("group_code_"+index[i]); //group_code
			trayInfo[1] = (String) htTrays.get("group_desc_"+index[i]); //group_desc
			trayInfo[2] = (String) htTrays.get("tray_no_"+index[i]); //tray_no
			trayInfo[3] = (String) htTrays.get("bin_location_code_"+index[i]); //bin_location_Code
			trayInfo[4] = (String) htTrays.get("expiry_date_"+index[i]); //expiry_date
			trayInfo[5] = (String) htTrays.get("non_returnable_yn_"+index[i]); //nonreturnable_yn
			trayInfo[6] = (String) htTrays.get("patient_id_"+index[i]);// patient_id

			trayInfo[7] = trayInfo[4]; //Expired_yn
			trayInfo[8] = (String) htTrays.get("used_status_"+index[i]); //used_yn
			trayInfo[9] = (String) htTrays.get("sterilize_yn_"+index[i]);//sterilize_yn
			trayInfo[10] = (String) htTrays.get("wash_yn_"+index[i]);//wash_yn
			trayInfo[11] = (String) htTrays.get("pack_yn_"+index[i]);//pack_yn
			trayInfo[12] = "N";//contaminated_yn

			//Comented By Sakti Sankar against BRU-HIMS-CRF-0360
			/*if(trayInfo[8].equals("Y")){
			trayInfo[13] = "Y";//charge_consumable_yn
			}
			else if((trayInfo[8].equals("N"))||(trayInfo[9].equals("N")))
			{
				trayInfo[13] = "N";//charge_consumable_yn
			}*/
			//ended
			trayInfo[13] = "N";//charge_consumable_yn default unchecked Added by Sakti against BRU-HIMS-CRF-0360 requirement
			trayInfo[14] = "N";//
			trayInfo[15] = "N";//can_update ?
		
			trayInfo[16] = null;//patient_name?
			trayInfo[17] = "0";//returnable_inst_cost
			trayInfo[18] = "0";//missing_used_inst_cost
			trayInfo[19] = (String) htTrays.get("iss_doc_type_code_"+index[i]);//iss_doc_type_code
			trayInfo[20] = (String) htTrays.get("iss_doc_no_"+index[i]);//iss_doc_no
			trayInfo[21] = (String) htTrays.get("bin_desc_"+index[i]);//bin_desc
			trayInfo[22] = (String) htTrays.get("remarks_code"+index[i]);//Remarks code #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013
			trayInfo[23] = (String) htTrays.get("remarks_"+index[i]);//Remarks  #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013

			String groupCode_trayNo = htTrays.get("group_code_"+index[i])+"-"+htTrays.get("tray_no_"+index[i]); 
			if (! isAlreadySelected(groupCode_trayNo)) {
				alTrayDetails.add(trayInfo);
			}
			alSelectedTrayDetails.add(groupCode_trayNo);
		}

		//Added by sakti against inc#43893
		
		String uncktokens = (String) htTrays.get("unchkdIndices");
		java.util.StringTokenizer unstrTokens = new java.util.StringTokenizer(uncktokens,",");
		int unckindex[] = new int[unstrTokens.countTokens()];
		int unckcount = 0;
		while (unstrTokens.hasMoreElements()) {
			unckindex[unckcount++] = Integer.parseInt(unstrTokens.nextToken());
		}
		for (int j=0;j<unckindex.length;j++) {
			String groupCode_trayNo = htTrays.get("group_code_"+unckindex[j])+"-"+htTrays.get("tray_no_"+unckindex[j]); 
	
			if ( isAlreadySelected(groupCode_trayNo) && (! alAddedTrayDetails.contains(groupCode_trayNo)) ) {
				alTrayDetails.remove(unckindex[j]);
				alSelectedTrayDetails.remove(groupCode_trayNo); 
				
			}
		}//Added ends
	}
	
	public java.util.ArrayList getAlSelectedTrayDetails() {
		return alSelectedTrayDetails;
	}

	public boolean isAlreadySelected(String groupCode_trayNo) {
		return alSelectedTrayDetails.contains(groupCode_trayNo);
	}
//Added by sakti against inc#43893
	public void setalGroupRecords( String groupCode_trayNo){
		alAddedTrayDetails.add(groupCode_trayNo);
	}//Added ends

	public String[] getTrayDetail(int rowIndex) {
		if ((rowIndex <0) || (rowIndex>alTrayDetails.size())) {
			return null;
		}
		return (String[]) alTrayDetails.get(rowIndex);
	}

	public void updateSelectedTraysValues(Hashtable htTrays,String bin_desc) {
		int arrayListIndex = Integer.parseInt((String) htTrays.get("table_row_index"));
		String[] updateTrayValue = (String[]) alTrayDetails.get(arrayListIndex);

		updateTrayValue[0] = (String) htTrays.get("group_code"); //group_code
		updateTrayValue[1] = (String) htTrays.get("group_desc"); //group_desc
		updateTrayValue[2] = (String) htTrays.get("tray_no"); //tray_no
		updateTrayValue[3] = (String) htTrays.get("bin_location_code"); //bin_location_Code
		//updateTrayValue[4] = (String) htTrays.get("expiry_date"); //expiry_date
		updateTrayValue[4] = (String) htTrays.get("expired_yn"); //expiry_date
		updateTrayValue[5] = (String) htTrays.get("non_returnable_yn"); //nonreturnable_yn
		updateTrayValue[6] = (String) htTrays.get("patient_id"); // patient_id
		updateTrayValue[7] = (String) htTrays.get("expired_yn"); //Expired_yn
		updateTrayValue[8] = (String) htTrays.get("used_yn"); //used_yn
		updateTrayValue[9] = (String) htTrays.get("sterilize_yn");//sterilize_yn
		updateTrayValue[10] = (String) htTrays.get("wash_yn");//wash_yn
		updateTrayValue[11] = (String) htTrays.get("pack_yn");//pack_yn
		updateTrayValue[12] = (String) htTrays.get("contaminated_yn");//contaminated_yn
		updateTrayValue[13] = (String) htTrays.get("charge_consumable_yn");//
		updateTrayValue[15] = (String) htTrays.get("updated"); //can_update ?
		updateTrayValue[16] = (String) htTrays.get("patient_name"); //patient_name?
		updateTrayValue[21] = bin_desc; //patient_name?
		updateTrayValue[22] = (String) htTrays.get("remarks_code"); // Remarks code #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013
		updateTrayValue[23] = (String) htTrays.get("remarks"); // Remarks #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013

		setUsed_Status((String)updateTrayValue[8]);
		
	}

	public ArrayList getSelectedTraysList() {
	
		if (alTrayDetails != null) {
			return alTrayDetails;
		}
		return null;
	}
	
	public void selectDefaultBinLocation() {
		return ;
	}

	public String getBinLocationsList() {
		try {
			String sql = (String) SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST");
			ArrayList binList = getListOptionArrayList(sql, getTo_store_code());
			return getListOptionTag(binList);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public ArrayList getBinLocations() {
        ArrayList binLocationData = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"));
            pstmt.setString(1, getTo_store_code());
            pstmt.setString(2, getLanguageId());
			binLocationData = new ArrayList();
            resultSet = pstmt.executeQuery();
            while ((resultSet != null) && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                binLocationData.add(record);
            }
			closeResultSet(resultSet);
            closeStatement(pstmt);
			closeConnection(connection);
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return binLocationData;
	}
	public String getDiscrepancyReasons() {
	//SQL_SS_ITEM_FOR_GROUP_SELECT_LIST
		String sql = (String) getSsRepositoryValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,getLanguageId());
		return getListOptionTag(alOptionValues,getWriteOffReasonCode());
	}
	public boolean validateEncounter(String encounter_id,String patient_id) {
		Connection connection = null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet = null;
		String sql = (String) eSS.Common.SsRepository.getSsKeyValue("SQL_PR_ENCOUNTER_COUNT");
		int value = -1;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,getLoginFacilityId());
			preparedStatement.setLong(2,Long.parseLong(encounter_id.trim()));
			preparedStatement.setString(3,patient_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				value = resultSet.getInt(1);
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
			if (value > 0) {
				return true;
			}
			return false;
		} 
		catch (Exception exception )	{
			exception.printStackTrace();
			return false;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public void loadDataTrayDetails() {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		try {
			alTrayDetails.clear();
			setFacility_id(login_facility_id);
			connection = getConnection();
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DTL_SELECT_MULTIPLE")); 
			
			preparedStatement.setString(1, getTo_store_code().trim());
			preparedStatement.setString(2, getLanguageId().trim());
			preparedStatement.setString(3, getLanguageId().trim());
			preparedStatement.setString(4, getFacility_id().trim());
			preparedStatement.setString(5, getDoc_type_code().trim());
			preparedStatement.setInt(6, Integer.parseInt(getDoc_no().trim()));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String[] trayDetail = getTrayDetailArray(resultSet);
				alTrayDetails.add(trayDetail);
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
		catch (Exception exception) {
			//System.err.println(exception);
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public String[] getTrayDetailArray(java.sql.ResultSet rs) {
			String[] trayInfo = new String[24];
			try {
				trayInfo[0] = rs.getString("return_group_code");
				trayInfo[1] = rs.getString("group_desc");
				trayInfo[2] = rs.getString("tray_no"); //tray_no
				trayInfo[3] = rs.getString("bin_location_code"); //bin_location_Code
				trayInfo[4] = rs.getString("expired_yn"); //expiry_date
				trayInfo[5] = rs.getString("non_returnable_yn"); //nonreturnable_yn
				trayInfo[6] = rs.getString("patient_id"); // patient_id
				trayInfo[7] = rs.getString("expired_yn"); ; //Expired_yn
				trayInfo[8] = rs.getString("used_yn"); //used_yn
				trayInfo[9] = rs.getString("sterilize_yn");//sterilize_yn
				trayInfo[10] = rs.getString("wash_yn");//wash_yn
				trayInfo[11] = rs.getString("pack_yn"); //pack_yn
				trayInfo[12] = rs.getString("contaminated_yn");//contaminated_yn
				trayInfo[13] = rs.getString("charge_consumable_yn");//charge_consumable_yn
				trayInfo[15] = "Y";//can_update ?
				trayInfo[16] = rs.getString("patient_name");//patient name?
				trayInfo[17] = rs.getString("returnable_inst_cost");//patient name?
				trayInfo[18] = rs.getString("missing_used_inst_cost");//patient name?
				trayInfo[19] = rs.getString("iss_doc_type_code");//patient name?
				trayInfo[20] = rs.getString("iss_doc_no");//patient name?
				trayInfo[21] = rs.getString("bin_desc");//bin_desc
				trayInfo[22] = rs.getString("remarks");//Added by Sakti Sankar against CRF-360
				trayInfo[23] = rs.getString("remarks_desc");//Added by Sakti Sankar against CRF-360
			}
			catch (Exception exception) {
				//System.err.println(exception);
			}
			return trayInfo;
	}

	public void loadData() {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		try {
			setFacility_id(login_facility_id);
			connection = getConnection();
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_HDR_SELECT_SINGLE")); 
			preparedStatement.setString(1, getFacility_id().trim());
			preparedStatement.setString(2, getDoc_type_code().trim());
			preparedStatement.setInt(3, Integer.parseInt(getDoc_no().trim()));
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				setFacility_id (getLoginFacilityId());
				setDoc_type_code(resultSet.getString("doc_type_code"));
				setDoc_no(resultSet.getString("doc_no"));
				setDoc_date(resultSet.getString("doc_date"));
				setFr_store_code(resultSet.getString("fr_store_code"));
				setTo_store_code(resultSet.getString("to_store_code"));
				setDoc_ref(resultSet.getString("doc_ref"));
				setEntry_completed_yn(resultSet.getString("entry_completed_yn"));
				db_entry_completed_yn = getEntry_completed_yn();
				setTrn_type(resultSet.getString("trn_type"));
				setEntered_by_id(resultSet.getString("entered_by_id"));
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		} 
		catch (Exception e )	{
			e.printStackTrace();
			} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		loadDataTrayDetails();
	}

	public void clear() {		
		doc_ref = "";
		trn_type = "";
		fr_store_code = "";
		entry_completed_yn = "";
		doc_type_code = "";
		doc_date = "";
		doc_no = "";
		to_store_code = "";
		finalized_yn = "";
		facility_id = "";
		group_code= "";
		tray_no= "";
		patient_id= "";
		patient_name= "";
		group_code ="";
		tray_no="";
		insertDetailIndex = null;
		if (alTrayDetails!=null) {
			alTrayDetails.clear();
		}
		if (alSelectedTrayDetails!=null) {
			alSelectedTrayDetails.clear();
		}
		if (alDiscrepancyDetailsKey != null) {
			alDiscrepancyDetailsKey.clear();
		}
		if (alSelectedDiscrepancyTrayDetails != null) {
			alSelectedDiscrepancyTrayDetails.clear();
		}
		if (htDiscrepancyDetails != null) {
			htDiscrepancyDetails.clear();
		}
		if (htSelectDiscrepancyDetail != null) {
			htSelectDiscrepancyDetail.clear();
		}
		if (htMaxIssuedQty != null) {
			htMaxIssuedQty.clear();
		}
		if (htDiscrepancyMain != null) {
			htDiscrepancyMain.clear();
		}
		if (htDiscrepancyKey != null) {
			htDiscrepancyKey.clear();
		}
		if (htSelectedDiscrepancyKey != null) {
			htSelectedDiscrepancyKey.clear();
		}
		if (hmSterileTypes != null) {
			hmSterileTypes.clear();
		}
		if (alAddedTrayDetails!=null) {
			alAddedTrayDetails.clear();
		}
	}

	public java.util.HashMap updateDiscrepancyDetail(java.util.Hashtable hash) {
		java.util.HashMap resultMap = new java.util.HashMap();
		resultMap.put("result",new Boolean(false));
		String instrument_code = (String) hash.get("item_code");
		int item_discrepancy_qty =  -1;
		
		try {
			item_discrepancy_qty = Integer.parseInt((String) hash.get("discrepancy_qty"));
			
			StringBuffer key = new StringBuffer();
			key.append(hash.get("group_code"));
			key.append('|'); //changed - to | for 21052
			key.append(hash.get("tray_no"));
			key.append('|');//changed - to | 21052
			key.append(hash.get("write_off_reason_code"));
			key.append('|');//21052
			key.append(instrument_code);
			//Check for dupliucate instrument 
			if ((getCurrentEditingDiscrepancy()) != null) {
				if (isQtyExceeded(instrument_code,item_discrepancy_qty)) {
					resultMap.put("msgid","DISCREPANCY_EXCEEDS_ISSUED");
					resultMap.put("message","Quantity Cannot be greater than issued Quantity");
					resultMap.put("flag",(""+((Integer)htMaxIssuedQty.get(instrument_code)).intValue()));
				}
				else {
					resultMap.put("result",new Boolean(true));
					updateAvailableQty(instrument_code,item_discrepancy_qty);
					htDiscrepancyDetails.put (key.toString(),formatDiscrepancyDetail(hash));
					setCurrentEditingDiscrepancy(null);
					resultMap.put("msgid","");
				}
				return resultMap;
			}
			if (alDiscrepancyDetailsKey.contains(key.toString())) {
				resultMap.put("msgid","RECORD_ALREADY_EXISTS");
				resultMap.put("message","Cannot duplicate instrument");
				return resultMap;
			}
			// Check for discrepancy quantity
			if (isQtyExceeded(instrument_code,item_discrepancy_qty)) {
				resultMap.put("msgid","DISCREPANCY_EXCEEDS_ISSUED");
				resultMap.put("message","Quantity Cannot be greater than issued Quantity");
				return resultMap;
			}

			resultMap.put("result",new Boolean(true));
			resultMap.put("msgid","");
			resultMap.put("message","");
			updateAvailableQty(instrument_code,item_discrepancy_qty);
			alDiscrepancyDetailsKey.add(key.toString());
			htDiscrepancyDetails.put (key.toString(),formatDiscrepancyDetail(hash));
			
			return resultMap;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			resultMap.put("msgid","");
			resultMap.put("message",exception.toString());
			return resultMap;
		}
	}
	
	public void updateAvailableQty(String instrument_code,int item_discrepancy_qty) {
		try {
			int availableQty = 0;
			if (getCurrentEditingDiscrepancy() != null) {
				availableQty =	((Integer) htMaxIssuedQty.get(instrument_code)).intValue();
				availableQty += (getOldQty()-item_discrepancy_qty);
			}
			else {
				availableQty = ((Integer) htMaxIssuedQty.get(instrument_code)).intValue();
				availableQty -= item_discrepancy_qty;
			}
			htMaxIssuedQty.put(instrument_code, new Integer(availableQty));
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public boolean isQtyExceeded(String instrument_code,int item_discrepancy_qty) {
		boolean resultValue = false;
		int availableQty = 0;
		try {
			availableQty = ((Integer)htMaxIssuedQty.get(instrument_code)).intValue();
			if (getCurrentEditingDiscrepancy() != null) {
				availableQty += getOldQty();
			}
			if (item_discrepancy_qty > availableQty)
				resultValue = true;
		}
		catch (Exception exception) {
			resultValue = false;
			exception.printStackTrace();
		}

		return resultValue;
	}

	public int getOldQty() {
		int oldQuantity = 0;
		try {
			String[] oldValue = (String[])htDiscrepancyDetails.get(getCurrentEditingDiscrepancy());
			oldQuantity = Integer.parseInt((String) oldValue[6]);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return oldQuantity;
	}
		
	public String[] formatDiscrepancyDetail(java.util.Hashtable hash) {
		String[] discrepancyInfo = new String[18];
		discrepancyInfo[0] = (String) hash.get("group_code");
		discrepancyInfo[1] = (String) hash.get("tray_no");
		discrepancyInfo[2] = (String) hash.get("item_code");
		discrepancyInfo[3] = (String) hash.get("item_desc");
		discrepancyInfo[4] = (String) hash.get("write_off_reason_code");
		discrepancyInfo[5] = (String) hash.get("remarks");
		discrepancyInfo[6] = (String) hash.get("discrepancy_qty");
		discrepancyInfo[7] = (String) hash.get("patient_id");
		discrepancyInfo[8] = (String) hash.get("encounter_id");
		discrepancyInfo[9] = ""; //(String) hash.get("billing_type");
		discrepancyInfo[10] = (String) hash.get("rec_reference");
		discrepancyInfo[11] = (String) hash.get("charge_amt");
		discrepancyInfo[12] = "N"; //Discrepancy Type
		discrepancyInfo[13] = "O"; // Usage Indicator
		discrepancyInfo[14] = (String) hash.get("charge_option");
		discrepancyInfo[15] = (String) hash.get("write_off_reason_desc");
		discrepancyInfo[16] = ""+((Integer)htMaxIssuedQty.get(hash.get("item_code")+"_max")).intValue();
		discrepancyInfo[17] = (String) hash.get("item_returnable_yn");
		return discrepancyInfo;
	}

	public void updateCostColumns(String[] tempTrayDetail) {
		// Check whether the tray is used !!
		// Monday, April 07, 2003 3:44:41 PM
		String group_code = tempTrayDetail[0];
		String tray_no = tempTrayDetail[2];
		String used = tempTrayDetail[8];
		String key =  group_code+"-"+tray_no;
		boolean isTrayUsed = used.equals("Y");

		double missing_used_cost = 0;
		double returnable_cost = 0;
		double itemCost = 0;
		
		java.util.ArrayList alKeys = (ArrayList) htSelectedDiscrepancyKey.get(key);
		if (alKeys != null && alKeys.size()>0) {
			java.util.Hashtable htDisData = (java.util.Hashtable) htDiscrepancyMain.get(key);
			for (int index=0;index<alKeys.size();index++) {
				String tempIndexKey = (String) alKeys.get(index);
				String[] trayDiscDetail = (String[]) htDisData.get(tempIndexKey);
				itemCost = Double.parseDouble(trayDiscDetail[11]);
				if (isTrayUsed && (trayDiscDetail[17].equals("N"))) {
					missing_used_cost += itemCost;
				}
				else {
					returnable_cost += itemCost;
				}
			}
		}
		tempTrayDetail[17] = ""+returnable_cost;
		tempTrayDetail[18] = ""+missing_used_cost;
		return;
	}

	public java.util.HashMap insert() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		Properties properties = getProperties();
		hmTableData.put("properties",properties );

		hmResult.put("result", new Boolean(false)) ;
		try {
			if (isAutoNo) {
				String next_doc_no = super.fetchNextDocNo(getDoc_type_code());
				setDoc_no(next_doc_no);
			}

			// Insert in the header table
			ArrayList alHDRInsertData =	new ArrayList();
			alHDRInsertData.add(getLoginFacilityId());
			alHDRInsertData.add(getDoc_type_code());
			alHDRInsertData.add(getDoc_no());
			alHDRInsertData.add(getDoc_date());
			alHDRInsertData.add(getFr_store_code());
			alHDRInsertData.add(getTo_store_code());
			alHDRInsertData.add(getDoc_ref());
			alHDRInsertData.add(getEntry_completed_yn());
			//alHDRInsertData.add(getFinalized_yn());
			if(getAckReqd()){
				alHDRInsertData.add("N");//finalize
				alHDRInsertData.add(getFinalized_yn().substring(0,1));//process for acknowledge
			}
			else{
				alHDRInsertData.add(getFinalized_yn().substring(0,1));//finalize
				alHDRInsertData.add("N");//process for acknowledge
			}

			alHDRInsertData.add(getTrn_type());
			alHDRInsertData.add(login_by_id);
			alHDRInsertData.add(login_at_ws_no);
			alHDRInsertData.add(login_facility_id);
			alHDRInsertData.add(login_by_id);
			alHDRInsertData.add(login_at_ws_no);
			alHDRInsertData.add(login_facility_id);
			hmSQLMap.put("InsertHDRSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_HDR_INSERT"));
			hmTableData.put("InsertHDRData", alHDRInsertData);
			// Insert Return Detail Value
			ArrayList alDTLInsertData = new java.util.ArrayList();
			ArrayList alDTLInsertRecord = null;
			for (int arrayIndex=0;arrayIndex<insertDetailIndex.length;arrayIndex++) {
				String[] trayDetail = (String[]) alTrayDetails.get(insertDetailIndex[arrayIndex]);
				// Update the columns  : returnable_inst_cost, missing_used_inst_cost
				updateCostColumns(trayDetail);
				alDTLInsertRecord = getDTLValue(trayDetail);
				alDTLInsertData.add(alDTLInsertRecord);
			}
			hmSQLMap.put("InsertDTLSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_DTL_INSERT"));
			hmTableData.put("InsertDTLData", alDTLInsertData);
			// Insert Return Discrepancy Detail Value
			if ((htSelectedDiscrepancyKey != null) && (htSelectedDiscrepancyKey.size()>0)) {
				ArrayList alDTLDiscrepancyInsertData =	new java.util.ArrayList();
				ArrayList alDTLDiscrepancyInsertRecord =	null;
				String masterKey = null;
				String 	tempIndexKey = null;
				java.util.Enumeration trayDiscrepancyKeys = htSelectedDiscrepancyKey.keys();
				while (trayDiscrepancyKeys.hasMoreElements()) {
					masterKey = (String) trayDiscrepancyKeys.nextElement();
					java.util.ArrayList alKeys = (ArrayList) htSelectedDiscrepancyKey.get(masterKey);
					java.util.Hashtable htDisData = (java.util.Hashtable) htDiscrepancyMain.get(masterKey);
					for (int index=0;index<alKeys.size();index++) {
						tempIndexKey = (String) alKeys.get(index);
						String[] trayDiscDetail = (String[]) htDisData.get(tempIndexKey);
						alDTLDiscrepancyInsertRecord = getDiscrepancyDetail(trayDiscDetail);
						alDTLDiscrepancyInsertData.add(alDTLDiscrepancyInsertRecord);
					}
				}
				hmSQLMap.put("InsertDISDTLSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_INSERT"));
				hmTableData.put("InsertDISDTLData", alDTLDiscrepancyInsertData);		
			}
			//For Updation SQL_SS_UPDATE_DOC_NO
			java.util.ArrayList alUpdateData = new java.util.ArrayList();
			alUpdateData.add(login_by_id);
			alUpdateData.add(login_at_ws_no);
			alUpdateData.add(login_facility_id);
			alUpdateData.add(getDoc_type_code());
		
			hmSQLMap.put("UpdateSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmTableData.put("UpdateData",alUpdateData);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		ReturnGroupRemote returnGroupRemote = null ;
		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_RETURN_GROUP") ,ReturnGroupHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		if( ((Boolean) hmResult.get("result")).booleanValue() )	
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
			hmResult.put("flag", "Doc No: "+getDoc_no()) ;
			//Adding start for AAKH-CRF-0057
			String alertRqdYN = "";
			String PgetDoc_type_code = getDoc_type_code();
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			 alertRqdYN=(String)(fetchRecord(getSsRepositoryValue("SQL_SS_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
					if(alertRqdYN.equals("Y")){	
						hmResult.put("flag",hmResult.get("flag") + "~PY");
					}else{
						hmResult.put("flag",hmResult.get("flag") + "~PS"); 
					} 
		   //Adding end for AAKH-CRF-0057
		}
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(returnGroupRemote != null)
					returnGroupRemote.remove() ;
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString()) ;
			}
		}  

		

		//Added by Martin on Thursday, April 17, 2003 4:23:54 PM

		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (getFinalized_yn().equals("Y") && isInternalRequest("SS","SSBFNRTG") && isInternalRequest("SS","SSBTRDIS")) {
				//doOnlineReportPrinting();				
			}
		}
		if (((Boolean)hmResult.get("result")).booleanValue()) {
			clear();
		}

	//	return hmResult;
	//only pankaj added

           
		return hmResult;    
	
	}

	// Modify method
	public java.util.HashMap modify() {

		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList alHDRUpdateData =	new ArrayList();
		Properties properties = getProperties();

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Modify Mode") ;
		hmTableData.put("properties",properties);

		if ((db_entry_completed_yn.equals("Y")) && (finalized_yn.equals("Y"))) {
			ArrayList alDTLUpdateData = new java.util.ArrayList();
			ArrayList alDTLCheckData = new java.util.ArrayList();

			hmTableData.put ("modify_type","1");
			//alHDRUpdateData.add(finalized_yn);
			if(getAckReqd()){
				alHDRUpdateData.add("N");//finalize
				alHDRUpdateData.add(finalized_yn);//process for acknowledge
			}
			else{
				alHDRUpdateData.add(finalized_yn);//finalize
				alHDRUpdateData.add("N");//process for acknowledge
			}

			alHDRUpdateData.add(login_by_id);
			alHDRUpdateData.add(login_at_ws_no);
			alHDRUpdateData.add(login_facility_id);
			alHDRUpdateData.add(getLoginFacilityId());
			alHDRUpdateData.add(getDoc_type_code());
			alHDRUpdateData.add(getDoc_no());

			alDTLUpdateData.add(login_by_id);
			alDTLUpdateData.add(login_at_ws_no);
			alDTLUpdateData.add(login_facility_id);
			alDTLUpdateData.add(getLoginFacilityId());
			alDTLUpdateData.add(getDoc_type_code());
			alDTLUpdateData.add(getDoc_no());

			hmSQLMap.put("UpdateSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_HDR_FINALIZE_UPDATE"));
			hmSQLMap.put("UpdateDTLSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_DTL_AUDIT_UPDATE"));
			hmTableData.put("UpdateData", alHDRUpdateData);
			hmTableData.put("UpdateDTLData", alDTLUpdateData);

			alDTLCheckData.add(getLoginFacilityId());
			alDTLCheckData.add(getDoc_type_code());
			alDTLCheckData.add(getDoc_no());
			String count_sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_COUNT");
			if (hasDiscrepancyRecords(alDTLCheckData,count_sql)) {
				hmSQLMap.put("UpdateDISDTLSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_AUDIT_UPDATE"));
				hmTableData.put("UpdateDISDTLData", alDTLUpdateData);
			}
		}
		else {
			ArrayList alDTLUpdateData = new java.util.ArrayList();
			ArrayList alDTLDeleteData = new java.util.ArrayList();
			ArrayList alDTSDTLDeleteData = new java.util.ArrayList();
			ArrayList alDTSDTLUpdateData = new java.util.ArrayList();
			ArrayList alDTLUpdateRecord = null;
			ArrayList alDTLDeleteRecord = null;
			ArrayList alDISDTLUpdateRecord = null;

			hmTableData.put ("modify_type","2");
			try {
				// Insert in the header table
				alHDRUpdateData.add(getDoc_date());
				alHDRUpdateData.add(getFr_store_code());
				alHDRUpdateData.add(getTo_store_code());
				alHDRUpdateData.add(getDoc_ref());
				alHDRUpdateData.add(getEntry_completed_yn());
				//alHDRUpdateData.add(getFinalized_yn());

				if(getAckReqd()){
				alHDRUpdateData.add("N");//finalize
				alHDRUpdateData.add(getFinalized_yn());//process for acknowledge
				}else{
				alHDRUpdateData.add(getFinalized_yn());//finalize
				alHDRUpdateData.add("N");//process for acknowledge
				}

				alHDRUpdateData.add(getGl_interfaced_yn());
				alHDRUpdateData.add(getTrn_type());
				alHDRUpdateData.add(login_by_id);
				alHDRUpdateData.add(login_at_ws_no);
				alHDRUpdateData.add(login_facility_id);
				alHDRUpdateData.add(getLoginFacilityId());
				alHDRUpdateData.add(getDoc_type_code());
				alHDRUpdateData.add(getDoc_no());
				hmSQLMap.put("UpdateHDRSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_HDR_UPDATE"));
				hmTableData.put("UpdateHDRData", alHDRUpdateData);
				
				if (updateDetailIndex != null && updateDetailIndex.length>0) {
					for (int index=0;index<updateDetailIndex.length;index++) {
						String[] trayDetail = (String[]) alTrayDetails.get(updateDetailIndex[index]);
						alDTLUpdateRecord = getDTLUpdateValue(trayDetail);
						alDTLUpdateData.add(alDTLUpdateRecord);
						// Update discrepancy detail
						alDISDTLUpdateRecord = getDISDTLUpdateValue(trayDetail);
						alDTSDTLUpdateData.add(alDISDTLUpdateRecord);
					}
				}

				if (deleteDetailIndex != null && deleteDetailIndex.length>0) {
					for (int index=0;index<deleteDetailIndex.length;index++) {
						String[] trayDetail = (String[]) alTrayDetails.get(deleteDetailIndex[index]);
						alDTLDeleteRecord = getDTLDeleteValue(trayDetail);
						alDTLDeleteData.add(alDTLDeleteRecord);
						String count_sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_ITEM_COUNT");
						if (hasDiscrepancyRecords(alDTLDeleteRecord,count_sql)) {
							alDTSDTLDeleteData.add(alDTLDeleteRecord);
						}
					}
				}
				hmSQLMap.put("DeleteDTSDTLSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_ITEM_DELETE"));
				hmTableData.put("DeleteDTSDTLData", alDTLDeleteData);
				
				hmSQLMap.put("DeleteDTLSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_DTL_ITEM_DELETE"));
				hmTableData.put("DeleteDTLData", alDTLDeleteData);
				hmSQLMap.put("UpdateDTLSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_DTL_UPDATE"));
				hmTableData.put("UpdateDTLData", alDTLUpdateData);

				hmSQLMap.put("UpdateDISDTLSQL", SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_UPDATE"));
				hmTableData.put("UpdateDISDTLData", alDTSDTLUpdateData);

			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		ReturnGroupRemote returnGroupRemote = null ;
		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_RETURN_GROUP") ,ReturnGroupHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		if( ((Boolean) hmResult.get("result")).booleanValue() )	
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
			hmResult.put("flag", "0") ;
			//Adding start for AAKH-CRF-0057
			String alertRqdYN = "";
			String PgetDoc_type_code = getDoc_type_code();
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			 alertRqdYN=(String)(fetchRecord(getSsRepositoryValue("SQL_SS_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
					if(alertRqdYN.equals("Y")){	
						hmResult.put("flag",hmResult.get("flag") + "~PY");
					}else{
						hmResult.put("flag",hmResult.get("flag") + "~PS"); 
					}
					//Adding end for AAKH-CRF-0057
		}
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(returnGroupRemote != null)
					returnGroupRemote.remove() ;
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString()) ;
			}
		}
		clear();
		return hmResult;
	}
	
	public java.util.HashMap delete() {
        HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	alDeleteData = new ArrayList();
		Properties properties = getProperties();

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Delete Mode") ;

		alDeleteData.add(getFacility_id());
		alDeleteData.add(getDoc_type_code());
		alDeleteData.add(getDoc_no());
		
		hmTableData.put("properties",properties);
		String count_sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_COUNT");
		if (hasDiscrepancyRecords(alDeleteData,count_sql)) {
				hmTableData.put("DeleteDISDTLData",alDeleteData);
				hmSQLMap.put("DeleteDISDTLSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_DELETE"));
		}
		hmTableData.put("DeleteDTLData",alDeleteData);
		hmSQLMap.put("DeleteDTLSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DTL_DELETE"));
		hmTableData.put("DeleteHDRData",alDeleteData);
		hmSQLMap.put("DeleteHDRSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_HDR_DELETE"));


		ReturnGroupRemote returnGroupRemote = null ;

		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_RETURN_GROUP") ,ReturnGroupHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
		if( ((Boolean) hmResult.get("result")).booleanValue() )	
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(returnGroupRemote != null)
					returnGroupRemote.remove() ;
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString()) ;
			}
		}
		return hmResult	;
    }

	public boolean hasDiscrepancyRecords(java.util.ArrayList dtlsKey,String sql) {
		boolean hasRecord = false;
		Connection connection = null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i=0;i<dtlsKey.size();i++) {
				preparedStatement.setString((i+1), (String) dtlsKey.get(i)); 
			}
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				if ((resultSet.getInt(1))>0)
					hasRecord = true;
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		} 
		catch (Exception exception )	{
			exception.printStackTrace();
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return hasRecord;
	}

	public java.util.ArrayList getDTLUpdateValue(String[] tempTrayDTL) {
		java.util.ArrayList alTempDTLRecord = new java.util.ArrayList();
		alTempDTLRecord.add(tempTrayDTL[3]);
		//alTempDTLRecord.add(tempTrayDTL[6]);
		alTempDTLRecord.add(checkForNull(tempTrayDTL[6]));//checkForNull is added against #Inc no:39364 (Bru-HIMS-CRF-360) on 09/05/2013
		alTempDTLRecord.add(tempTrayDTL[7]);
		alTempDTLRecord.add(tempTrayDTL[8]);
		alTempDTLRecord.add(tempTrayDTL[9]);
		alTempDTLRecord.add(tempTrayDTL[10]);
		alTempDTLRecord.add(tempTrayDTL[11]);
		alTempDTLRecord.add(tempTrayDTL[12]);
		alTempDTLRecord.add(tempTrayDTL[13]);
		alTempDTLRecord.add(checkForNull(tempTrayDTL[22]));//Remarks
		alTempDTLRecord.add(login_by_id);
		alTempDTLRecord.add(login_at_ws_no);
		alTempDTLRecord.add(login_facility_id);
		alTempDTLRecord.add(getLoginFacilityId());
		alTempDTLRecord.add(getDoc_type_code());
		alTempDTLRecord.add(getDoc_no());
		alTempDTLRecord.add(tempTrayDTL[0]);
		alTempDTLRecord.add(tempTrayDTL[2]);
		return alTempDTLRecord;
	}

	public java.util.ArrayList getDISDTLUpdateValue(String[] tempTrayDTL) {
		java.util.ArrayList alTempDISDTLRecord = new java.util.ArrayList();
		alTempDISDTLRecord.add(login_by_id);
		alTempDISDTLRecord.add(login_at_ws_no);
		alTempDISDTLRecord.add(login_facility_id);
		alTempDISDTLRecord.add(getLoginFacilityId());
		alTempDISDTLRecord.add(getDoc_type_code());
		alTempDISDTLRecord.add(getDoc_no());
		alTempDISDTLRecord.add(tempTrayDTL[0]);
		alTempDISDTLRecord.add(tempTrayDTL[2]);
		return alTempDISDTLRecord;
	}

	public java.util.ArrayList getDTLDeleteValue(String[] tempTrayDTL) {
		java.util.ArrayList alTempDTLRecord = new java.util.ArrayList();
		alTempDTLRecord.add(getLoginFacilityId());
		alTempDTLRecord.add(getDoc_type_code());
		alTempDTLRecord.add(getDoc_no());
		alTempDTLRecord.add(tempTrayDTL[0]);
		alTempDTLRecord.add(tempTrayDTL[2]);
		return alTempDTLRecord;
	}

	public java.util.ArrayList getDTLValue(String[] tempTrayDTL) {
		java.util.ArrayList alTempDTLRecord = new java.util.ArrayList();
		alTempDTLRecord.add(getLoginFacilityId());	    // facility_id
		alTempDTLRecord.add(getDoc_type_code());	// doc_type_code
		alTempDTLRecord.add(getDoc_no());					// doc_no
		alTempDTLRecord.add(tempTrayDTL[0]); //	// return_group_code
		alTempDTLRecord.add(tempTrayDTL[2]);			// tray_no
		alTempDTLRecord.add(tempTrayDTL[3]);			// bin_location_code
		alTempDTLRecord.add(tempTrayDTL[6]);			// patient_id
		alTempDTLRecord.add(tempTrayDTL[7]);			// expired_yn
		alTempDTLRecord.add(tempTrayDTL[8]);			// used_yn
		alTempDTLRecord.add(tempTrayDTL[9]);			// sterilize_yn
		alTempDTLRecord.add(tempTrayDTL[10]);		// wash_yn
		alTempDTLRecord.add(tempTrayDTL[11]);		// pack_yn
		alTempDTLRecord.add(tempTrayDTL[12]);		// contaminated_yn
		alTempDTLRecord.add(tempTrayDTL[13]);		// charge_consumable_yn
		alTempDTLRecord.add(tempTrayDTL[0]);		// sterile_cost - group code
		alTempDTLRecord.add(checkForNull((String)hmSterileTypes.get(tempTrayDTL[0])));		// sterile_cost - sterile type
		alTempDTLRecord.add(tempTrayDTL[0]);		// packing_cost - group code
		alTempDTLRecord.add(tempTrayDTL[0]);		// consumables_cost - group code
		alTempDTLRecord.add(tempTrayDTL[0]);		// total  : sterile_cost - group code
		alTempDTLRecord.add(checkForNull((String)hmSterileTypes.get(tempTrayDTL[0])));		// total  : sterile_cost - sterile type
		alTempDTLRecord.add(tempTrayDTL[0]);		// total : consumables_cost - group code
		alTempDTLRecord.add(tempTrayDTL[0]);		// total  : sterile_cost - group code
		alTempDTLRecord.add(tempTrayDTL[17]);		// returnable_inst_cost
		alTempDTLRecord.add(tempTrayDTL[18]);		// missing_used_inst_cost
		alTempDTLRecord.add(tempTrayDTL[19]);		// Issue Doc Type Code
		alTempDTLRecord.add(tempTrayDTL[20]);		// Issue Doc No
		alTempDTLRecord.add(login_by_id);
		alTempDTLRecord.add(login_at_ws_no);
		alTempDTLRecord.add(login_facility_id);
		alTempDTLRecord.add(login_by_id);
		alTempDTLRecord.add(login_at_ws_no);
		alTempDTLRecord.add(login_facility_id);
		alTempDTLRecord.add(checkForNull(tempTrayDTL[22])); // Added by Rabbani #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013
		return alTempDTLRecord;
	}
	
	public HashMap validate() {
		Connection connection = null;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success") ;

		int recordExists = -1;
		try {
			connection = getConnection();
			if ((!isAutoNo) && (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
				preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_HDR_COUNT"));
				preparedStatement.setString(1, login_facility_id);
				preparedStatement.setString(2, doc_type_code);
				preparedStatement.setString(3, doc_no);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					recordExists = resultSet.getInt(1);
				}
				if (recordExists>0) {
					resultMap.put("result", new Boolean(false));
					resultMap.put("msgid","DUPLICATE_DOC_NO");
					resultMap.put("message",getMessage("DUPLICATE_DOC_NO"));
				}
			}
			// load the default Sterile Type
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_DEF_STERILE_SELECT"));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				hmSterileTypes.put(resultSet.getString(1) , resultSet.getString(2));
			}
			closeStatement(preparedStatement);
			closeConnection(connection);
			closeResultSet(resultSet);
		}
		catch (Exception exception) {
			resultMap.put("result", new Boolean(false));
			resultMap.put("message",exception.getMessage());
			
		}
	 
    finally {
            try
				
			{
                 closeStatement(preparedStatement);
			     closeConnection(connection);
			     closeResultSet(resultSet);
            }
			catch(Exception es){
				es.printStackTrace();
            }
		return resultMap;
	}
}

	public String toString() {
		return "doc_ref "+doc_ref + 
		"trn_type :: "+trn_type + 
		" entry_completed_yn :: "+ entry_completed_yn +
		"doc_type_code :: " + doc_type_code + 
		" doc_date :: " +doc_date +
		"  doc_no : : " + doc_no + 
		" finalized_yn :: "+ finalized_yn +
		" to_store_code :: " +  to_store_code + 
		" fr_store_code :: " + fr_store_code +
		" non_returnable_yn :: "+non_returnable_yn +
		" group_code :: "+ group_code +
		" tray_no :: "+tray_no +
		" patient_id :: " +patient_id +
		" patient_name :: "+ patient_name +
		" isAutoNo :: " +isAutoNo;
	}

	public void updateSelectedDiscrepancyDetail(java.util.Hashtable hash) {
		String key  = null;
		alSelectedDiscrepancyTrayDetails = new java.util.ArrayList();
		htSelectDiscrepancyDetail = new java.util.Hashtable();
		String hashKey= (String) hash.get("discrepancy_key");
		hash.remove("discrepancy_key");

		htSelectDiscrepancyDetail = hash;
		htDiscrepancyMain.put (hashKey,htDiscrepancyDetails);
		// Available keys for the selected group and tray no
		htDiscrepancyKey.put (hashKey, alDiscrepancyDetailsKey);
		//Add the selected keys selected group,tray no, instrument_code and write-off reason
		java.util.Enumeration trayDiscrepancyKeys = hash.keys();
		while (trayDiscrepancyKeys.hasMoreElements()) {
			key = (String) trayDiscrepancyKeys.nextElement();
			alSelectedDiscrepancyTrayDetails.add(hash.get(key));
		}
		htSelectedDiscrepancyKey.put(hashKey,alSelectedDiscrepancyTrayDetails);
		return ;
	}

	public java.util.ArrayList getDiscrepancyDetail(String[] stringArray) {
		if (stringArray.length<0) {
			return null;
		}
		String issued_date = "";
		try {
			java.util.ArrayList alParam = new java.util.ArrayList ();
			alParam.add(stringArray[0]);	
			alParam.add(stringArray[1]);	
			HashMap hmRecord = fetchRecord(getSsRepositoryValue("SQL_SS_TRAY_DTLS_ISSUE_DATE_SELECT"),alParam);
			issued_date = (String) hmRecord.get("ISSUED_DATE");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		java.util.ArrayList alDiscrepancy = new java.util.ArrayList();
		alDiscrepancy.add(getLoginFacilityId());   //facility_id                  
		alDiscrepancy.add(getDoc_type_code());//doc_type_code       
		alDiscrepancy.add(getDoc_no());				  //doc_no                     
		alDiscrepancy.add(stringArray[0]);		//group_code                 
		alDiscrepancy.add(stringArray[1]);		//tray_no                        	  
		alDiscrepancy.add(stringArray[2]);		 //item_code                   	  
		alDiscrepancy.add(stringArray[4]);		//write_off_reason_code
		alDiscrepancy.add(stringArray[5]);		//remarks                        	  
		alDiscrepancy.add(stringArray[6]);		//discrepancy_qty          	  
		alDiscrepancy.add(stringArray[7]);		//patient_id                     	  
		alDiscrepancy.add(stringArray[8]);		//encounter_id               	  
		alDiscrepancy.add(stringArray[9]);		//billing_type                  	  
		alDiscrepancy.add(stringArray[10]);	//rec_reference             	  
		alDiscrepancy.add(stringArray[12]);	//discrepancy_type       	  
		alDiscrepancy.add(stringArray[13]);	//usage_ind                    	  
		alDiscrepancy.add(stringArray[14]);	//charge_option             	  
		alDiscrepancy.add(stringArray[17]);	//item_returnable_yn   	  
		alDiscrepancy.add(stringArray[11]);	// get_item cost - charge_amt
		//Add Issued Date on Wednesday, April 09, 2003 10:29:30 AM
		alDiscrepancy.add(issued_date);
		alDiscrepancy.add(login_by_id);			//added_by_id                	  
		alDiscrepancy.add(login_at_ws_no);	//added_at_ws_no        	  
		alDiscrepancy.add(login_facility_id);		//added_facility_id         	  
		alDiscrepancy.add(login_by_id);			//modified_by_id            	  
		alDiscrepancy.add(login_at_ws_no);	//modified_at_ws_no    
		alDiscrepancy.add(login_facility_id);		//modified_facility_id
		return alDiscrepancy;								
	}

	public String[] getSelectedDiscrepancyDetail(String discrepancyKey) {
		if (htDiscrepancyDetails.containsKey(discrepancyKey)) {
			return (String[]) htDiscrepancyDetails.get(discrepancyKey);
		}
		return null;
	}

	public java.util.Hashtable getDiscrepancyDetails(String group_code,String tray_no) {
		return htDiscrepancyDetails;
	}

	public java.util.ArrayList getDiscrepancyDetailsKey(String group_code,String tray_no) {
		ArrayList da=new ArrayList();
		if(alDiscrepancyDetailsKey.size()>0){
			
			for(int i=0;i<alDiscrepancyDetailsKey.size();i++){
				java.util.StringTokenizer  strTokens=new java.util.StringTokenizer(((String)alDiscrepancyDetailsKey.get(i)),"|");//changed - to | for TFSID:21052
				while (strTokens.hasMoreElements()) {
					String [] tokens =new String[4];
					tokens[0]=""+strTokens.nextToken();
					tokens[1]=""+strTokens.nextToken();
					tokens[2]=""+strTokens.nextToken();
					tokens[3]=""+strTokens.nextToken();
				if(tokens[0].equals(group_code) && tokens[1].equals(tray_no) ){
				
				da.add(tokens[0] + "|"+ tokens[1]+"|"+tokens[2]+"|"+tokens[3]);//21052  
				}
			   }
			}
			return da;
		}
		else
		//return new ArrayList();
		return alDiscrepancyDetailsKey;
	}

	public void loadIssueQty(String group_code) {
		Connection connection = null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet = null;
		String sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ITEM_FOR_GROUP_QTY_SELECT");
		String itemCode = null;
		int maxQty = 0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,group_code);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				itemCode = resultSet.getString("item_code");
				maxQty = resultSet.getInt("item_qty");
				htMaxIssuedQty.put(itemCode,new Integer(maxQty));
				htMaxIssuedQty.put(itemCode+"_max",new Integer(maxQty));
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		} 
		catch (Exception exception )	{
			exception.printStackTrace();
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
			return;
		}
		
	}

	public void loadDiscrepancyDetails(String group_code,String tray_no) {

		
		
		Connection connection = null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet = null;
		String sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DISCREPANCY_DTL_MULTIPLE_SELECT");
		
		try {
		
		
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,getLoginFacilityId());
			preparedStatement.setString(2,doc_type_code);
			preparedStatement.setString(3,doc_no);
			preparedStatement.setString(4,group_code);
			preparedStatement.setString(5,tray_no);
			preparedStatement.setString(6,getLanguageId());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String[] discrepancyInfo = new String[18];
				discrepancyInfo[0] = resultSet.getString("group_code");
				discrepancyInfo[1] = resultSet.getString("tray_no");
				discrepancyInfo[2] = resultSet.getString("item_code");
				discrepancyInfo[3] = resultSet.getString("item_desc"); 
				discrepancyInfo[4] = resultSet.getString("write_off_reason_code");
				discrepancyInfo[5] = checkForNull(resultSet.getString("remarks"));
				discrepancyInfo[6] = checkForNull(resultSet.getString("discrepancy_qty"));
				discrepancyInfo[7] = checkForNull(resultSet.getString("patient_id"));
				discrepancyInfo[8] = checkForNull(resultSet.getString("encounter_id"));
				discrepancyInfo[9] = checkForNull(resultSet.getString("billing_type"),"N");
				discrepancyInfo[10] = checkForNull(resultSet.getString("rec_reference"),"");
				discrepancyInfo[11] = checkForNull(resultSet.getString("charge_amt"),"0");
				discrepancyInfo[12] = "N";
				discrepancyInfo[13] = "O";
				discrepancyInfo[14] = checkForNull(resultSet.getString("charge_option"),"N");
				discrepancyInfo[15] = checkForNull(resultSet.getString("write_off_reason_desc"));
				discrepancyInfo[16] = checkForNull(resultSet.getString("discrepancy_qty"));
				discrepancyInfo[17] = checkForNull(resultSet.getString("item_returnable_yn"),"N");
				alDiscrepancyDetailsKey.add(discrepancyInfo[0] + "|"+ discrepancyInfo[1]+"|"+discrepancyInfo[4]+"|"+discrepancyInfo[2]);//changed - to | for 21052
				htDiscrepancyDetails.put (discrepancyInfo[0] + "|"+ discrepancyInfo[1]+"|"+discrepancyInfo[4]+"|"+discrepancyInfo[2],discrepancyInfo);//21052
				//to set all the values
				setWriteOffReasonCode((String)resultSet.getString("write_off_reason_code"));
				setDiscrepancyQty((String)resultSet.getString("discrepancy_qty"));
				setItemReturnable((String)resultSet.getString("item_returnable_yn"));
				setChargeOption((String)resultSet.getString("charge_option"));
				setReceiptRef((String)resultSet.getString("rec_reference"));
				setRemarks((String)resultSet.getString("remarks"));
				
			}

			// Data from SS_DISCREPANCY_DTL
			
			sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_DISCREPANCY_DTL_RETURN_GROUP_MULTIPLE_SELECT");
		
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,group_code);
			preparedStatement.setString(2,tray_no);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String[] discrepancyInfo = new String[18];
				discrepancyInfo[0] = resultSet.getString("group_code");
				discrepancyInfo[1] = resultSet.getString("tray_no");
				discrepancyInfo[2] = resultSet.getString("item_code");
				discrepancyInfo[3] = resultSet.getString("item_desc"); // ?
				discrepancyInfo[4] = resultSet.getString("write_off_reason_code");
				discrepancyInfo[5] = checkForNull(resultSet.getString("remarks"));
				discrepancyInfo[6] = checkForNull(resultSet.getString("discrepancy_qty"));
				discrepancyInfo[7] = checkForNull(resultSet.getString("patient_id"));
				discrepancyInfo[8] = checkForNull(resultSet.getString("encounter_id"));
				discrepancyInfo[9] = checkForNull(resultSet.getString("billing_type"),"N");
				discrepancyInfo[10] = checkForNull(resultSet.getString("rec_reference"),"");
				discrepancyInfo[11] = checkForNull(resultSet.getString("charge_amt"),"0");
				discrepancyInfo[12] = "N";
				discrepancyInfo[13] = "O";
				discrepancyInfo[14] = checkForNull(resultSet.getString("charge_option"),"N");
				discrepancyInfo[15] = checkForNull(resultSet.getString("write_off_reason_desc"));
				discrepancyInfo[16] = "";
				discrepancyInfo[17] = "N";
				alDiscrepancyDetailsKey.add(discrepancyInfo[0] + "|"+ discrepancyInfo[1]+"|"+discrepancyInfo[4]+"|"+discrepancyInfo[2]);//21052
				htDiscrepancyDetails.put (discrepancyInfo[0] + "|"+ discrepancyInfo[1]+"|"+discrepancyInfo[4]+"|"+discrepancyInfo[2],discrepancyInfo);//21052
				
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		} 
		catch (Exception exception )	{
			exception.printStackTrace();
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
			return;
		}
	}

	public void resetDetails() {
		alTrayDetails.clear();
	}

	public String getEncounterID(String patient_id) {
		return "";
	}

/*Added on Monday, May 12, 2003 by Manish*/

	public String getEncounter_id_List(String patient_id) throws Exception{
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(patient_id);
		ArrayList alRecords	=	fetchRecords(getSsRepositoryValue("SQL_PR_ENCOUNTER_SELECT_LIST"), alParam);
		
		StringBuffer sbList	=	new StringBuffer();
		
			if(alRecords.size()>0){
				sbList.append("<option value=\"");
			sbList.append("");//PATIENT_CLASS
			sbList.append("\">");
			sbList.append("-------Select-------");
			sbList.append("</option>\n");
		for (int i=0;i<alRecords.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alRecords.get(i);
			sbList.append("<option value=\"");
			sbList.append((String)hmRecord.get("ENCOUNTER_ID"));//PATIENT_CLASS
			sbList.append("\">");
			sbList.append((String)hmRecord.get("ENCOUNTER_ID"));
			sbList.append("</option>\n");
		}
			}
			else{
			sbList.append("<option value=\"");
			sbList.append("");//PATIENT_CLASS
			sbList.append("\">");
			sbList.append("-------Select-------");
			sbList.append("</option>\n");
			}
		return sbList.toString();
	}

//Added By Sakti Sankar on 07/12/2012 against CRF#222
	public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT RET_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("RET_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
//Added ends


}
