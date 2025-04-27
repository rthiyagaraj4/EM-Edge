/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for ROF Entry
*/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001
05/04/2022  TFS:				                      					ML-MMOH-CRF-1821-US006
-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package eSS;


import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;
import java.util.HashMap;
import javax.servlet.* ;
import javax.servlet.http.*;
import java.util.HashMap;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import ecis.utils.OnlineReport;
import javax.servlet.ServletException;
import eSS.Common.SsAdapter;
import eSS.GenerateROF.GenerateROFRemote;
import eSS.GenerateROF.GenerateROFHome;
import eSS.GenerateROF.GenerateROFManager;


public class ROFEntryBean extends eSS.Common.SsTransaction implements java.io.Serializable {
		
	private java.util.Hashtable htHeaderRecord;
	private java.util.Hashtable htDetailRecord;
	private java.util.ArrayList alSelectedTrays;
	private java.util.ArrayList alSelectedKeys;
	private java.util.ArrayList alAddedTrays;

	private String doc_type_code="";
	private String doc_date="";
	private String docdate="";
	private String doc_no="";
	private String doc_ref="";
	private String service_location="";
	private String store_code="";
	private String sterilize_yn="";
	private String wash_yn="";
	private String pack_yn="";
	private String finalized_yn = "N";
	private String trn_type="ROF";
	private String defStoreCode = "";
	private String defServiceLocationCode = "";

	private String sterile_type ="";
	private String wash_type ="";
	private HttpSession session;
	private String linenApplicableYN ="";//mmoh-crf-1661
	private String group_type_code		= ""; //ML-MMOH-CRF-1821
	public String getLinenApplicableYN() {
		return linenApplicableYN;
	}

	public void setLinenApplicableYN(String linenApplicableYN) {
		this.linenApplicableYN = linenApplicableYN;
	}//end  

	
	private boolean isAutoNo;


	public ROFEntryBean() {
		htHeaderRecord = new java.util.Hashtable();
		htDetailRecord = new java.util.Hashtable();
		alSelectedTrays = new java.util.ArrayList();
		alSelectedKeys = new java.util.ArrayList();
		alAddedTrays = new java.util.ArrayList();
	}

public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() {
		 return session;
	}
	public void setSterilize_yn(String sterilize_yn) {
		 this.sterilize_yn = sterilize_yn;
	}

	public String getSterilize_yn( ) {
		 return sterilize_yn;
	}

	public void setWash_yn(String wash_yn) {
		 this.wash_yn = wash_yn;
	}

	public String getWash_yn( ) {
		 return wash_yn;
	}

	public void setPack_yn(String pack_yn) {
		 this.pack_yn = pack_yn;
	}

	public String getPack_yn( ) {
		 return pack_yn;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref( ) {
		 return doc_ref;
	}

	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}

	public String getTrn_type() {
		 return trn_type;
	}

	public void setFinalized_yn(String finalized_yn) {
		this.finalized_yn = finalized_yn;
	}

	public String getFinalized_yn() {
		return finalized_yn;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code( ) {
		 return doc_type_code;
	}

	public void setStore_code(String store_code) {
		 this.store_code= store_code;
	}

	public String getStore_code( ) {
		 return store_code;
	}


	public void setDocdate(String docdate) {
		 this.docdate = docdate;
	}

	public String getDocdate() {
		return  docdate;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date() {
		try {

				return getSystemDate();
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
	
	public void setService_location(String service_location) {
		 this.service_location = service_location;
	}

	public String getService_location( ) {
		 return service_location;
	}

	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}

	public void setSterile_type (String sterile_type ) {
		this.sterile_type  = sterile_type ;
	}

	public void setWash_type (String wash_type) {
		this.wash_type = wash_type;
	}

	public String getWash_type() {
		return this.wash_type;
	}
	
	public String getSterile_type() {
		return this.sterile_type;
	}

	//ML-MMMOH-CRF-1821
	public void setGroupTypeCode (String group_type_code) {
		this.group_type_code = group_type_code;
	}

	public String getGroupTypeCode() {
		return this.group_type_code;
	}
	//ML-MMMOH-CRF-1821 - ENDS

	public void doCommon() {
		try {
			java.util.HashMap defaultParameter = getSSParameter();

			defServiceLocationCode = (String) defaultParameter.get("DEF_SERVICE_LOCATION_CODE");
			defStoreCode = (String) defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}	
	}

	public void setAll(Hashtable htResult) {

		
		setDoc_type_code((String)htResult.get("doc_type_code"));
		setDoc_no((String)htResult.get("doc_no"));
		setDoc_date((String)htResult.get("doc_date"));
		setDocdate((String)htResult.get("doc_date"));
		setDoc_ref((String)htResult.get("doc_ref"));
		setSterilize_yn((String)htResult.get("sterilize_yn"));
		setWash_yn((String)htResult.get("wash_yn"));
		setPack_yn((String)htResult.get("pack_yn"));
		setStore_code((String)htResult.get("store_code"));
		setService_location((String) htResult.get("service_location_code"));
		setFinalized_yn(htResult.get("finalized_yn").equals((String)eSS.Common.SsRepository.getSsKeyValue("YES"))?"Y":"N");
		setIsAutoNo(htResult.get("autono_yn").equals((String)eSS.Common.SsRepository.getSsKeyValue("YES")));
	}

	public String getDocTypes() {
		try {
			String defaultROF = "";
			ArrayList alParameters	=	new ArrayList();
			alParameters.add(getLoginFacilityId());
			alParameters.add("ROF");
			alParameters.add(getLanguageId());
			if (getMode().equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
				defaultROF = getDoc_type_code();
			}
			else if (getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				java.util.HashMap defaultParameter = getSSParameter();
				defaultROF = (String) defaultParameter.get("DEF_ROF_DOC_TYPE_CODE");
			}
			//Modified by Martin on Monday, April 28, 2003 10:14:24 AM

			return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_AUTO_SELECT_LIST"),alParameters), defaultROF);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public String getDefaultDocTypes() {
		String defaultROF = null;
		try {
			ArrayList alParameters	=	new ArrayList();
			alParameters.add(getLoginFacilityId());
			alParameters.add("ROF");
			alParameters.add(getLanguageId());
			java.util.HashMap defaultParameter = getSSParameter();
			defaultROF = (String) defaultParameter.get("DEF_ROF_DOC_TYPE_CODE");
			return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_AUTO_SELECT_LIST"),alParameters), defaultROF);

		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public String getServiceLocations() {
		String sql = (String) getSsRepositoryValue("SQL_SS_SERVICE_LOCATION_FACILITY_SELECT_LIST");
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
	
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,alParam);
		if (getService_location()!= null && getService_location().length()>0) {
			return getListOptionTag(alOptionValues,getService_location());
		}
		else {
			doCommon();
			return getListOptionTag(alOptionValues,defServiceLocationCode);
		}
		
	}

	public String getStoreCodes() {
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());

		String sql = (String) getSsRepositoryValue("SQL_SS_STORE_ROF_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,alParam);
		if (getStore_code() != null && getStore_code().length()>0) {
			return getListOptionTag(alOptionValues,getStore_code());
		}
		else {	
			doCommon();
			return getListOptionTag(alOptionValues,defStoreCode);
		}
	}

	public String getWashTypes() {
		String sql = (String) getSsRepositoryValue("SQL_SS_WASHING_TYPE_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,getLanguageId());
		String optionTag = getListOptionTag(alOptionValues, getWash_type());
		wash_type= "";
		return optionTag;
		
	}

	public String getSterilizationTypes() {
		String sql = (String) getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,getLanguageId());
		String optionTag = getListOptionTag(alOptionValues, getSterile_type());
		sterile_type="";
		return optionTag;
	}

	public String getGroupTypes(String defaultGroupType ){
		if(getLinenApplicableYN()!=null && getLinenApplicableYN().equals("Y")){//MMOH-CRF-1661 
			return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;L,Linen;",defaultGroupType);
		}else{
			return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;",defaultGroupType);	
		}
		
	}


	public void updateSelectedTrays(Hashtable htTrays) {
		String selectedTrayValue = null;
		int total_trays = Integer.parseInt((String)htTrays.get("total_trays"));


		for (int idx = 0; idx<total_trays;idx++ ) {
			if (!htTrays.containsKey("selected_tray_"+idx)) 
				continue;
			selectedTrayValue = (String) htTrays.get("selected_tray_"+idx);
			if ((selectedTrayValue != null) && (!alSelectedKeys.contains(selectedTrayValue))) {
				alSelectedKeys.add(selectedTrayValue);
			}
		}

	}

	public void loadData() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ROF_HDR_ENTRY_SELECT_SINGLE")); 
			preparedStatement.setString(1, getDoc_type_code());
			preparedStatement.setString(2, getLoginFacilityId());
			preparedStatement.setString(3, getDoc_no());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				setDoc_type_code(resultSet.getString("doc_type_code"));
				setDoc_no(resultSet.getString("doc_no"));
				setDoc_date(resultSet.getString("doc_date"));
				setDocdate(resultSet.getString("doc_date"));
				setDoc_ref(resultSet.getString("doc_ref"));
				setSterilize_yn(resultSet.getString("sterilize_yn"));
				setWash_yn(resultSet.getString("wash_yn"));
				setPack_yn(resultSet.getString("pack_yn"));
				setStore_code(resultSet.getString("store_code"));
				setService_location(resultSet.getString("service_location_code"));
				setFinalized_yn("N");
			}
		    closeResultSet(resultSet);
			closeStatement(preparedStatement);
		
			preparedStatement = null; 
			resultSet = null;
			String key = null;
			String[] detailRecord = null;
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ROF_DTL_ENTRY_SELECT_MULTIPLE")); 
			preparedStatement.setString(1, getLoginFacilityId());
			preparedStatement.setString(2, getDoc_type_code());
			preparedStatement.setInt(3, Integer.parseInt(getDoc_no()));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				detailRecord = formatDetail(resultSet);
				key = detailRecord[0]+"-"+detailRecord[2];
				alSelectedTrays.add(key);
				htDetailRecord.put (key,detailRecord);
			}
		    closeResultSet(resultSet);
			closeStatement(preparedStatement);
		
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
	}
	
	public String getSterilizedChecked() {
		if (getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) || getSterilize_yn().equals("Y")) {
			return "checked";
		}
		return "";
	}

	public String getWashChecked() {
		if (getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) || getWash_yn().equals("Y")) {
			return "checked";
		}
		return "";
	}

	public String getPackChecked() {
		if (getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) || getPack_yn().equals("Y")) {
			return "checked";
		}
		return "";
	}

	public ArrayList getSelectTray() {
		java.util.ArrayList selectedTrayLists = new java.util.ArrayList();
		for (int index=0;index<alSelectedTrays.size();index++ ) {
			String[] detailRecord = (String[]) htDetailRecord.get((String) alSelectedTrays.get(index));
			selectedTrayLists.add(detailRecord);
		}
		return selectedTrayLists;
	}
	
	public void clear() {
		doc_type_code="";
		doc_date="";
		doc_no="";
		doc_ref="";
		service_location="";
		store_code="";
		wash_yn="N";
		pack_yn="N";
		sterilize_yn="N";
		finalized_yn="N";
		trn_type="ROF";
		sterile_type="";
		wash_type= "";
		linenApplicableYN = "";//mmoh-crf-1661 


		if(htHeaderRecord !=null)
			htHeaderRecord.clear();
		if(htDetailRecord!=null)
			htDetailRecord.clear();
		if(alSelectedTrays!=null)
			alSelectedTrays.clear();
		if(alSelectedKeys != null) 
			alSelectedKeys.clear();
		if(alAddedTrays != null)
			alAddedTrays.clear();
	}

	public HashMap insert() {
		HashMap hmResult			=		new HashMap();
		HashMap hmTableData			=		new HashMap();
		HashMap hmSQLMap			=		new HashMap();
		Properties properties		=		getProperties();
		hmTableData.put("properties",properties );
		hmResult.put("result", new Boolean(false)) ;
		try {
			String rofStatus			=		"RE";

			ArrayList alHDRInsertData	=		new java.util.ArrayList();
			ArrayList alDTLInsertData	=		new java.util.ArrayList();

			ArrayList alUpdateData		=		new java.util.ArrayList();

			String next_doc_no			=		super.fetchNextDocNo(getDoc_type_code());

			setDoc_no(next_doc_no);
			
			// Insert in the header table
			ArrayList alHDRInsertRecord =	new ArrayList();
			alHDRInsertRecord.add(getLoginFacilityId());
			alHDRInsertRecord.add(getDoc_type_code());
			alHDRInsertRecord.add(getDoc_no());
			alHDRInsertRecord.add(getDoc_date());
			alHDRInsertRecord.add(getService_location());
			alHDRInsertRecord.add(getStore_code());
			alHDRInsertRecord.add(getDoc_ref());
			alHDRInsertRecord.add(getFinalized_yn());
			alHDRInsertRecord.add(getSterilize_yn());
			alHDRInsertRecord.add(getWash_yn());
			alHDRInsertRecord.add(getPack_yn());
			alHDRInsertRecord.add(getTrn_type());
			alHDRInsertRecord.add(login_by_id);
			alHDRInsertRecord.add(login_at_ws_no);
			alHDRInsertRecord.add(login_facility_id);
			alHDRInsertRecord.add(login_by_id);
			alHDRInsertRecord.add(login_at_ws_no);
			alHDRInsertRecord.add(login_facility_id);
			alHDRInsertData.add(alHDRInsertRecord);
			
			
			if (getFinalized_yn() != null  && getFinalized_yn().equals("Y")) {
					rofStatus = "RC";
			}
			else {
				rofStatus = "RE";
			}

			//For Updation SQL_SS_UPDATE_DOC_NO
			ArrayList alUpdateRecord = new java.util.ArrayList();
			alUpdateRecord.add(login_by_id);
			alUpdateRecord.add(login_at_ws_no);
			alUpdateRecord.add(login_facility_id);
			alUpdateRecord.add(getDoc_type_code());
			alUpdateData.add(alUpdateRecord);

			hmSQLMap.put("InsertHDRSQL", SsRepository.getSsKeyValue("SQL_SS_ROF_HDR_INSERT"));
			hmTableData.put("InsertHDRData", alHDRInsertData);
			
			hmSQLMap.put("UpdateSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmTableData.put("UpdateData",alUpdateData);

			// Insert ROF Detail Value

			for (int index=0;index<alSelectedKeys.size();index++) {
				ArrayList alDTLInsertRecord = new java.util.ArrayList ();
				String[] dtlData = (String[]) htDetailRecord.get((String)alSelectedKeys.get(index));
				alDTLInsertRecord.add(getLoginFacilityId());
				alDTLInsertRecord.add(getDoc_type_code());
				alDTLInsertRecord.add(getDoc_no());
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(dtlData[2]);
				alDTLInsertRecord.add(dtlData[4]); // Sterilization Type
				alDTLInsertRecord.add(dtlData[5]); //Washing Type
				alDTLInsertRecord.add(dtlData[9]); //Pack Item Code
				alDTLInsertRecord.add(dtlData[10]); //Pack Item Qty
				alDTLInsertRecord.add(rofStatus);
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(dtlData[4]);
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(dtlData[4]);
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(login_by_id);
				alDTLInsertRecord.add(login_at_ws_no);
				alDTLInsertRecord.add(login_facility_id);
				alDTLInsertRecord.add(login_by_id);
				alDTLInsertRecord.add(login_at_ws_no);
				alDTLInsertRecord.add(login_facility_id);
System.err.println("====ROFEntryBean - Insertion - GroupType - "+	dtlData[6]);
				alDTLInsertRecord.add(dtlData[6]); //ML-MMOH-CRF-1821
					// Set it in the bean and will be used in print (last one will get added...) in single group type scenario (if required later then set it for specific entry in loop)
					setGroupTypeCode(dtlData[6]);//ML-MMOH-CRF-1821

				alDTLInsertData.add(alDTLInsertRecord);   
			}
			hmSQLMap.put("InsertDTLSQL", SsRepository.getSsKeyValue("SQL_SS_ROF_DTL_INSERT"));
			hmTableData.put("InsertDTLData", alDTLInsertData);
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}


		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_GENERATE_ROF") ,GenerateROFHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;

			hmResult.put("flag", "Doc No : "+getDoc_no()) ;
		}
		catch(Exception e) {
			System.err.println("Error Calling EJB : "+e) ;
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 


		//Added by Martin on Thursday, April 17, 2003 4:23:54 PM
		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
System.err.println("---Second time INSERT getFinalized_yn()"+getFinalized_yn()+"----"+isInternalRequest("SS","SSBROFLS"));
			if (getFinalized_yn().equals("Y") && isInternalRequest("SS","SSBROFLS")) {
				doOnlineReportPrinting();				
			}
		}
		if (((Boolean)hmResult.get("result")).booleanValue()) {
			clear();
		}
		return hmResult;
	}

	public HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList alHDRUpdateData =	new ArrayList();
		ArrayList alDTLInsertData = new java.util.ArrayList();
		ArrayList alDTLUpdateData = new java.util.ArrayList();
		ArrayList alDTLDeleteData = new java.util.ArrayList();
		Properties properties = getProperties();


		Connection connection = null;
	    PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
			
		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Modify Mode") ;
		hmTableData.put("properties",properties);
		
		
		
		try {
			String rofStatus = "RE";
			//Sterilize Type
			java.util.HashMap groupSterilizeWashType = new java.util.HashMap();
			//Get Sterilize type and Wash type for the groups;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_SS_GROUP_SELECT"));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				groupSterilizeWashType.put(resultSet.getString(1),new SterlizeWashBean(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);

			//if (resultSet != null) 
			//	resultSet.close();
			//if (preparedStatement != null) 
			//	preparedStatement.close();
			//if (connection!= null) {
				//connection.close();
			//}

			if (getFinalized_yn() != null  && getFinalized_yn().equals("Y")) {
					rofStatus = "RC";
			}
			else {
				rofStatus = "RE";
			}

			alHDRUpdateData.add(getDocdate());
			alHDRUpdateData.add(getService_location());
			alHDRUpdateData.add(getStore_code());
			alHDRUpdateData.add(getDoc_ref());
			alHDRUpdateData.add(getFinalized_yn());
			alHDRUpdateData.add(login_by_id);
			alHDRUpdateData.add(login_at_ws_no);
			alHDRUpdateData.add(login_facility_id);
			alHDRUpdateData.add(getDoc_type_code());
			alHDRUpdateData.add(getLoginFacilityId());
			alHDRUpdateData.add(getDoc_no());

			hmSQLMap.put("UpdateHDRSQL", SsRepository.getSsKeyValue("SQL_SS_ROF_HDR_ENTRY_UPDATE"));
			hmTableData.put("UpdateHDRData", alHDRUpdateData);

			String keyData = null;
			int index = 0;
			//Do insert
			SterlizeWashBean tempSterlizeWashBean = null;
			
			for (index = 0;index<alAddedTrays.size();index++ ) {
				keyData = (String) alAddedTrays.get(index);
				ArrayList alDTLInsertRecord = new java.util.ArrayList ();
				String[] dtlData = (String[]) htDetailRecord.get(keyData);
				tempSterlizeWashBean = (SterlizeWashBean) groupSterilizeWashType.get(dtlData[0]);
				alDTLInsertRecord.add(getLoginFacilityId());
				alDTLInsertRecord.add(getDoc_type_code());
				alDTLInsertRecord.add(getDoc_no());
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(dtlData[2]);
				alDTLInsertRecord.add(checkForNull(dtlData[4])); // Sterilization Type
				alDTLInsertRecord.add(checkForNull(dtlData[5])); //Washing Type
				alDTLInsertRecord.add(checkForNull(dtlData[9])); //Pack Item Code
				alDTLInsertRecord.add(checkForNull(dtlData[10])); //Pack Item Qty
				alDTLInsertRecord.add(rofStatus);
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(checkForNull(dtlData[4]));
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(checkForNull(dtlData[4]));
				alDTLInsertRecord.add(dtlData[0]);
				alDTLInsertRecord.add(login_by_id);
				alDTLInsertRecord.add(login_at_ws_no);
				alDTLInsertRecord.add(login_facility_id);
				alDTLInsertRecord.add(login_by_id);
				alDTLInsertRecord.add(login_at_ws_no);
				alDTLInsertRecord.add(login_facility_id);
				System.err.println("====ROFEntryBean - Modification - GroupType - "+	checkForNull(dtlData[6]));
				alDTLInsertRecord.add(checkForNull(dtlData[6])); //ML-MMOH-CRF-1821
					// Set it in the bean and will be used in print (last one will get added...) in single group type scenario (if required later then set it for specific entry in loop)
					setGroupTypeCode(dtlData[6]);//ML-MMOH-CRF-1821

				alDTLInsertData.add(alDTLInsertRecord);
				alSelectedTrays.remove(keyData);
			}
			hmSQLMap.put("InsertDTLSQL", SsRepository.getSsKeyValue("SQL_SS_ROF_DTL_INSERT"));
			hmTableData.put("InsertDTLData", alDTLInsertData);
			
			//preparedStatement.close();
			//resultSet.close();
			closeResultSet(resultSet);
			closeStatement(preparedStatement);

			
			//Do update

			for (index = 0;index<alSelectedKeys.size();index++ ) {
				keyData = (String) alSelectedKeys.get(index);
				ArrayList alDTLUpdateRecord = new java.util.ArrayList ();
				String[] dtlData = (String[]) htDetailRecord.get(keyData);
				tempSterlizeWashBean = (SterlizeWashBean) groupSterilizeWashType.get(dtlData[0]);
				alDTLUpdateRecord.add(dtlData[3]); // Contaminated 
				alDTLUpdateRecord.add(checkForNull(dtlData[4])); // Sterilization Type
				alDTLUpdateRecord.add(checkForNull(dtlData[5])); //Washing Type
				alDTLUpdateRecord.add(rofStatus);
				alDTLUpdateRecord.add(dtlData[0]);
				alDTLUpdateRecord.add(checkForNull(dtlData[4]));
				alDTLUpdateRecord.add(dtlData[0]);
				alDTLUpdateRecord.add(dtlData[0]);
				alDTLUpdateRecord.add(checkForNull(dtlData[4]));
				alDTLUpdateRecord.add(dtlData[0]);
				alDTLUpdateRecord.add(login_by_id);
				alDTLUpdateRecord.add(login_at_ws_no);
				alDTLUpdateRecord.add(login_facility_id);

				System.err.println("====ROFEntryBean - Modification - GroupType - "+	checkForNull(dtlData[6]));
				alDTLUpdateRecord.add(checkForNull(dtlData[6])); //ML-MMOH-CRF-1821
					// Set it in the bean and will be used in print (last one will get added...) in single group type scenario (if required later then set it for specific entry in loop)
					setGroupTypeCode(dtlData[6]);//ML-MMOH-CRF-1821


				alDTLUpdateRecord.add(getLoginFacilityId());
				alDTLUpdateRecord.add(getDoc_type_code());
				alDTLUpdateRecord.add(getDoc_no());
				alDTLUpdateRecord.add(dtlData[0]);
				alDTLUpdateRecord.add(dtlData[2]);
			
				alDTLUpdateData.add(alDTLUpdateRecord);
				if (alSelectedTrays.contains(keyData)) {
					alSelectedTrays.remove(keyData);
				}
			}
			hmSQLMap.put("UpdateDTLSQL", SsRepository.getSsKeyValue("SQL_SS_ROF_DTL_ENTRY_UPDATE"));
			hmTableData.put("UpdateDTLData", alDTLUpdateData);

			
			//Do delete

			for (index = 0;index<alSelectedTrays.size();index++ ) {
				keyData = (String) alSelectedTrays.get(index);
				ArrayList alDTLDeleteRecord = new java.util.ArrayList ();
				String[] dtlData = (String[]) htDetailRecord.get(keyData);
				alDTLDeleteRecord.add(getLoginFacilityId());
				alDTLDeleteRecord.add(getDoc_type_code());
				alDTLDeleteRecord.add(getDoc_no());
				alDTLDeleteRecord.add(dtlData[0]);
				alDTLDeleteRecord.add(dtlData[2]);
				alDTLDeleteData.add(alDTLDeleteRecord);
			}
			hmSQLMap.put("DeleteDTLSQL", SsRepository.getSsKeyValue("SQL_SS_ROF_DTL_ENTRY_ITEM_DELETE"));
			hmTableData.put("DeleteDTLData", alDTLDeleteData);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		finally{
			try{
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
			catch(Exception es) {

				es.printStackTrace();
			}
			
		}

		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_GENERATE_ROF") ,GenerateROFHome.class,getLocalEJB());

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
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
			hmResult.put("flag", "Doc No : "+getDoc_no()) ;
		}

		catch(Exception e) {

			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		}

		//Added by Martin on Thursday, April 17, 2003 4:23:54 PM
		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
System.err.println("---Modify getFinalized_yn()"+getFinalized_yn()+"----"+isInternalRequest("SS","SSBROFLS"));
			if (getFinalized_yn().equals("Y") && isInternalRequest("SS","SSBROFLS")) {
				doOnlineReportPrinting();				
			}
		}
		return hmResult;
	}

	public HashMap delete() {
        HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	 alDeleteHDRData = new ArrayList();
		ArrayList	 alDeleteDTLData = new ArrayList();
		Properties properties = getProperties();

		hmResult.put("result", new Boolean(false)) ;

		hmResult.put("message", "Delete Mode") ;
		alDeleteHDRData.add(getDoc_type_code());
		alDeleteHDRData.add(getLoginFacilityId());
		alDeleteHDRData.add(new Integer(getDoc_no()));
		
		alDeleteDTLData.add(getLoginFacilityId());
		alDeleteDTLData.add(getDoc_type_code());
		alDeleteDTLData.add(new Integer(getDoc_no()));

		hmTableData.put("properties",properties);
		hmTableData.put("DeleteHDRData",alDeleteHDRData);
		hmSQLMap.put("DeleteHDRSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ROF_HDR_ENTRY_DELETE"));
		hmTableData.put("DeleteDTLData",alDeleteDTLData);
		hmSQLMap.put("DeleteDTLSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ROF_DTL_ENTRY_DELETE"));


		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_GENERATE_ROF") ,GenerateROFHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			hmResult.put("flag", "") ;
		}
		catch(Exception e) {

			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 

		return hmResult	;
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
			if ((!isAutoNo) && (getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
				connection = getConnection();
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
				//if (resultSet != null) 
				//	resultSet.close();
				//if (preparedStatement != null) 
				//	preparedStatement.close();
				//if (connection!= null) {
				//	connection.close();
				}
			}catch (Exception exception) {
				resultMap.put("result", new Boolean(false));
				resultMap.put("message",exception.getMessage());
			}
			finally{
					try{
						closeResultSet(resultSet);
						closeStatement(preparedStatement);
						closeConnection(connection);
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
		return resultMap;
	}

	public HashMap updateTrayDetails(java.util.Hashtable hash) {
		boolean isEditing = false;
		java.util.HashMap resultMap = new java.util.HashMap();
		resultMap.put("result",new Boolean(false));
		
		String group_code = (String) hash.get("group_code");

		String tray_no = (String) hash.get("tray_no");
		
		String editing_key = (String)hash.get("editing_key");
		if (editing_key != null && (htDetailRecord.get(editing_key) != null)) {
			isEditing = true;
		}

		StringBuffer key = new StringBuffer();
		key.append(group_code);
		key.append('-');
		key.append(tray_no);
		String[] detailRecord = formatDetail(hash);
		try {
			if ((!isEditing) && (alSelectedTrays.contains(key.toString()))) {
				resultMap.put("msgid","RECORD_ALREADY_EXISTS");
				resultMap.put("message","Cannot duplicate instrument");

				return resultMap;
			}
			else
			{
			resultMap.put("result",new Boolean(true));
			resultMap.put("msgid","");
			resultMap.put("message","");
			if (!isEditing) {
				alSelectedTrays.add(key.toString());
				alAddedTrays.add(key.toString());
			
			}
		

			htDetailRecord.put (key.toString(),detailRecord);




			htDetailRecord.put(key.toString(),detailRecord);

			return resultMap;
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			resultMap.put("msgid","");
			resultMap.put("message",exception.toString());

			return resultMap;
		}
	}

	public String[] getDetail(String key) {
		return (String[])htDetailRecord.get(key);
	}

	public String[] formatDetail(java.sql.ResultSet resultSet) {
		try {
			String[] detailInfo = new String[12];
			detailInfo[0] = resultSet.getString("group_code");
			detailInfo[1] = resultSet.getString("short_desc");
			detailInfo[2] = resultSet.getString("tray_no");
			detailInfo[3] = resultSet.getString("contaminated_yn");
			detailInfo[4] = resultSet.getString("sterile_type");
			detailInfo[5] = resultSet.getString("washing_type");
			detailInfo[6] = resultSet.getString("group_type");
			detailInfo[7] = "N"; // is updated
			if(detailInfo[6].equals("E")) {
				detailInfo[11] = "Set";
			}
			else if(detailInfo[6].equals("T")) { 
				detailInfo[11] = "Tray";
			}
			else if(detailInfo[6].equals("P")) {
				detailInfo[11] = "Soft Pack	";
			}
			else if(detailInfo[6].equals("S")) {
				detailInfo[11] = "Single";
			}
			else if(detailInfo[6].equals("L")) {//mmoh-crf-1661 
				detailInfo[11] = "Linen";
			}
			return detailInfo;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public String[] formatDetail(java.util.Hashtable hash) {
		String[] detailInfo = new String[12];
		detailInfo[0] = (String) hash.get("group_code");
		detailInfo[1] = (String) hash.get("group_desc");
		detailInfo[2] = (String) hash.get("tray_no");
		detailInfo[3] = "N";
		if (hash.get("contaminated_yn") != null) {
			detailInfo[3] = (String) hash.get("contaminated_yn");
		}
		detailInfo[4] = (String) hash.get("sterile_type");
		detailInfo[5] = (String) hash.get("wash_type");
		detailInfo[6] = (String) hash.get("group_type_code");
		detailInfo[7] = "N"; // is updated
		if (getMode().equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			detailInfo[8] = "N";
		}
		else {
			detailInfo[8] = "O";
		}
		detailInfo[9] =  checkForNull(((String) hash.get("pack_item_code")),"");
		detailInfo[10] = checkForNull(((String) hash.get("pack_item_qty")),"");
	
		detailInfo[11] = checkForNull((String) hash.get("group_type_name"),"");		
		return detailInfo;
	}

	public boolean trayNoExists(String groupCode,String trayNo, String sterilize, String wash, String pack) {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		int trayCount = -1;
		boolean hasTray = false;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DTL_ENTRY_COUNT")); 

			preparedStatement.setString(1, groupCode);
			preparedStatement.setString(2, trayNo);
			preparedStatement.setString(3, sterilize);
			preparedStatement.setString(4, wash);
			preparedStatement.setString(5, pack);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				trayCount = resultSet.getInt(1);
			}
			if (trayCount > 0) {
				hasTray = true;
			}
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
		return hasTray;
	}

	/* ML-MMOH-CRF-1821 - STARTS */		
	public String getMultiGroupTypeYn () {

		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		String    multi_group_type_yn = "";
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( getSsRepositoryValue("SQL_SS_GROUPTYPE_DEFLT_PARAM") ) ;
			pstmt.setString( 1, login_facility_id ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				multi_group_type_yn = checkForNull(resultSet.getString("ALLOW_MULTI_GROUP_TYPES_YN"),"N" ) ;
			}
		} catch ( Exception e )	{
				e.printStackTrace();
			} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return multi_group_type_yn;
	}
	/* ML-MMOH-CRF-1821 - ENDS */		

	public String getURLString(HashMap hmParameters) {
        Connection connection = null;
		CallableStatement callableStatement = null;
        StringBuffer sbURL = new StringBuffer();

		try {
			HashMap hmReportParameter	=	(HashMap)hmParameters.get("report_parameter");
			String stReport_server = checkForNull((String)hmParameters.get("report_server"));
            String stReport_connect_string = checkForNull((String)hmParameters.get("report_connect_string"));
            String stExecutable_name = "";
            String stServer = "";
            String stCopies = "";
//            String stReport_mode = "";
            String stQueue_name = "";
//            String stReport_tool = "";
//            String stStatus = "";
            String stMessage = "";
            String stModule_id = (String)hmReportParameter.get("p_module_id");
            String stReport_id = (String)hmReportParameter.get("p_report_id");
            String stLocation_type = (String)hmParameters.get("location_type");
            String stLocation_code = (String)hmParameters.get("location_code");
            String stFacility_id = (String)hmReportParameter.get("p_facility_id");
            Properties properties = getProperties();
            String stClient_ip_address = checkForNull(properties.getProperty("client_ip_address"));
            String stReport_option = "P";
            String st_app_server_ip = "";

			connection = getConnection();
            
			callableStatement = connection.prepareCall("{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }");
            callableStatement.setString(1, stModule_id);
            callableStatement.setString(2, stReport_id);
            callableStatement.setString(3, stLocation_type);
            callableStatement.setString(4, stLocation_code);
            callableStatement.setString(5, stFacility_id);
            callableStatement.setString(6, stClient_ip_address);
            callableStatement.setString(7, stReport_option);
            callableStatement.registerOutParameter(8, Types.VARCHAR);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.registerOutParameter(10, Types.VARCHAR);
            callableStatement.registerOutParameter(11, Types.VARCHAR);
            callableStatement.registerOutParameter(12, Types.VARCHAR);
            callableStatement.registerOutParameter(13, Types.VARCHAR);
            callableStatement.registerOutParameter(14, Types.VARCHAR);
            callableStatement.registerOutParameter(15, Types.VARCHAR);
            callableStatement.registerOutParameter(16, Types.VARCHAR);
            callableStatement.execute();
            stExecutable_name = callableStatement.getString(8);
            stServer = callableStatement.getString(9);
            stCopies = callableStatement.getString(10);
//            stReport_mode = callableStatement.getString(11);
            stQueue_name = callableStatement.getString(12);
//            stReport_tool = callableStatement.getString(13);
//            stStatus = callableStatement.getString(14);
           stMessage = callableStatement.getString(15);
            st_app_server_ip = callableStatement.getString(16);
            stReport_server = "http://" + st_app_server_ip + stReport_server;
			
			if(stQueue_name.startsWith("\\\\\\\\")) {
                String s20 = stQueue_name.substring(4);
                int i = s20.indexOf("\\\\");
                String s21 = s20.substring(0, i);
                String s22 = s20.substring(i + 2);
                String s24 = "\\\\" + s21 + "\\" + s22;
                stQueue_name = s24;
            }

			sbURL.append(stReport_server);
			sbURL.append("?report=");
			sbURL.append(stExecutable_name);
			sbURL.append("+userid=");
			sbURL.append(stReport_connect_string);
			sbURL.append("+server=");
			sbURL.append(stServer);
			sbURL.append("+desname=");
			sbURL.append(stQueue_name);
			sbURL.append("+copies=");
			sbURL.append(stCopies);
			sbURL.append("+destype=printer+recursive_load=no+");
			sbURL.append(getReportParameter((HashMap) hmParameters.get("report_parameter")));
       }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        finally {
            try { 
					//if(callableStatement != null)
					//callableStatement.close();
					closeStatement( callableStatement ) ;
					//if(connection != null)
					//closeConnection(connection);
					closeConnection(connection);
			}
            catch (Exception exception) {
            	exception.printStackTrace();
            }
        }
		return sbURL.toString();
    }
	public String getReportParameter( HashMap hmReportParameter){
		StringBuffer sbParameter	=	new StringBuffer();
        for(Iterator iterator = hmReportParameter.keySet().iterator(); iterator.hasNext();) {
            String stKey = (String)iterator.next();
            String stValue = (String)hmReportParameter.get(stKey);
			sbParameter.append(stKey);
			sbParameter.append("=");
			sbParameter.append(stValue);
			sbParameter.append("+");
		}
		sbParameter.deleteCharAt(sbParameter.length()-1);
		return sbParameter.toString();
	}
	
	public void doOnlineReportPrinting() {
		try{
			
			System.out.println("doOnlineReportPrinting");
		
System.err.println("====Check GRoup Type When PRINTING===="+getGroupTypeCode()); 
			String reportid = "SSBROFLS";
		
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","SS");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_fm_doc_type_code",getDoc_type_code());
			hmReportParameter.put("p_to_doc_type_code",getDoc_type_code());
			hmReportParameter.put("p_fm_doc_no",getDoc_no());
			hmReportParameter.put("p_to_doc_no",getDoc_no());
			hmReportParameter.put("p_fm_serv_loc",getService_location());
			hmReportParameter.put("p_to_serv_loc",getService_location());
			hmReportParameter.put("p_fm_store_code",getStore_code());
			hmReportParameter.put("p_to_store_code",getStore_code());
            hmReportParameter.put("p_language_id",getLanguageId()) ;
			hmReportParameter.put("p_reprint","Y");  
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",session.getAttribute("jdbc"));
			hmParameters.put("report_server",session.getAttribute("report_server"));
			hmParameters.put("report_connect_string",session.getAttribute("report_connect_string"));
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",getStore_code());


new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
	

           
            

		}
		catch ( Exception exception) {
			exception.printStackTrace();
			return;
		}
	}
	
	
	
	
	/*public void doOnlineReportPrinting() {
		try{
			/*ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "SSBROFLS";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "SS", reportid,"L", "1");
			hmReportParameter.put("p_module_id","SS");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_fm_doc_type_code",getDoc_type_code());
			hmReportParameter.put("p_to_doc_type_code",getDoc_type_code());
			hmReportParameter.put("p_fm_doc_no",getDoc_no());
			hmReportParameter.put("p_to_doc_no",getDoc_no());
			hmReportParameter.put("p_fm_serv_loc",getService_location());
			hmReportParameter.put("p_to_serv_loc",getService_location());
			hmReportParameter.put("p_fm_store_code",getStore_code());
			hmReportParameter.put("p_to_store_code",getStore_code());

			onlineReports.add(reportParam) ;
			String ReportOutput = onlineReports.execute( request, response);		}
		catch ( Exception exception) {

			exception.printStackTrace();
			return;
		}
	}*/
}	
