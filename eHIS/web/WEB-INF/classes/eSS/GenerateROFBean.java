/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for Generate  ROF
*/
package eSS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;
import java.util.HashMap;
import javax.rmi.PortableRemoteObject;
import javax.naming.InitialContext;
import java.util.HashMap;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.SsAdapter;
import eSS.GenerateROF.GenerateROFRemote;
import eSS.GenerateROF.GenerateROFHome;
import eSS.GenerateROF.GenerateROFManager;


public class GenerateROFBean extends eSS.Common.SsTransaction implements java.io.Serializable {
		
	private java.util.Hashtable htHeaderRecord;
	private java.util.Hashtable htDetailRecord;
	private java.util.ArrayList alSelectedTrays;
	private java.util.ArrayList alSelectedTypes;
	private java.util.ArrayList alSelectedKeys;
	private java.util.ArrayList alHeaderKey;
	private java.util.ArrayList alTrayKey;

	private String doc_type_code;
	private String doc_date;
	private String doc_no;
	private String doc_ref;
	private String service_location;
	private String store_code;
	private String print_rof;
	private String finalized_yn = "N";
	private String trn_type="ROF";
	private String defStoreCode = "";
	private String defServiceLocationCode = "";
	private boolean isAutoNo;

//	private String linen_applicable_yn;//ML-MMOH-CRF-1821 //commented for COMMON-ICN-0119
	private String group_type;//ML-MMOH-CRF-1821
	
	public GenerateROFBean() {
		htHeaderRecord = new java.util.Hashtable();
		htDetailRecord = new java.util.Hashtable();
		alHeaderKey = new java.util.ArrayList();
		alTrayKey = new java.util.ArrayList();
		alSelectedTrays = new java.util.ArrayList();
		alSelectedTypes = new java.util.ArrayList();
		alSelectedKeys = new java.util.ArrayList();
	}

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
	
	public void setPrint_rof(String print_rof) {
		 this.print_rof = print_rof;
	}
	
	public String getPrint_rof( ) {
		 return print_rof;
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


	public void setGroupTypeValue(String group_type) {
System.err.println("===group_type"+group_type);
		this.group_type = group_type;
	}

	public String getGroupTypeValue() {
		return this.group_type;
	}


	public void setAll(Hashtable htResult) {

		setDoc_type_code((String)htResult.get("doc_type_code"));
		setDoc_no((String)htResult.get("doc_no"));
		setDoc_date((String)htResult.get("doc_date"));
		setDoc_ref((String)htResult.get("doc_ref"));
		setStore_code((String)htResult.get("store_code"));
		setService_location((String) htResult.get("service_location"));

		setPrint_rof((String) htResult.get("print_rof"));
		setIsAutoNo(htResult.get("autono_yn").equals((String)eSS.Common.SsRepository.getSsKeyValue("YES"))?true:false);

		setGroupTypeValue((String) htResult.get("group_type")); //ML-MMOH-CRF-1821
	}

	public String getDocTypes() {
		try {
			ArrayList alParameters	=	new ArrayList();
			java.util.HashMap defaultParameter = getSSParameter();
			String defaultROF = (String) defaultParameter.get("DEF_ROF_DOC_TYPE_CODE");
			alParameters.add(getLoginFacilityId());
			alParameters.add("ROF");
			alParameters.add(getLanguageId());
			return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_AUTO_SELECT_LIST"),alParameters), defaultROF);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public String getServiceLocations() {
		doCommon();
		String sql = (String) getSsRepositoryValue("SQL_SS_SERVICE_LOCATION_FACILITY_SELECT_LIST");
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,alParam);
		return getListOptionTag(alOptionValues,defServiceLocationCode);
	}

	public String getStoreCodes() {
		doCommon();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		String sql = (String) getSsRepositoryValue("SQL_SS_STORE_ROF_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql, alParam);
		return getListOptionTag(alOptionValues,defStoreCode);
	}

	public void updateDisplayArrayList(java.util.ArrayList alTrayDetails) {
		try {
			StringBuffer sbTrayKey = new StringBuffer();
			StringBuffer sbHeaderKey = new StringBuffer();
			String headerKey = null;
			String trayKey = null;
			java.util.ArrayList alRecord =null;
			

			for (int i=0;i<alTrayDetails.size();i++) {
				if ((alTrayDetails.get(i) != null) && (alTrayDetails.get(i) instanceof java.util.ArrayList)) {
					alRecord = (java.util.ArrayList) alTrayDetails.get(i);
					sbTrayKey.append(alRecord.get(0));
					sbTrayKey.append("-");
					sbTrayKey.append(alRecord.get(2));
					sbTrayKey.append("-");
					sbTrayKey.append(alRecord.get(4));
					trayKey = sbTrayKey.toString();

					sbHeaderKey.append(alRecord.get(5));
					sbHeaderKey.append(alRecord.get(6));
					sbHeaderKey.append(alRecord.get(7));
					headerKey = sbHeaderKey.toString();
					if (!alHeaderKey.contains(headerKey)) {
						alHeaderKey.add (headerKey);
					}
					htDetailRecord.put(trayKey,alRecord);

					if (htHeaderRecord.containsKey(headerKey)) {
						java.util.ArrayList tempKey= (java.util.ArrayList) htHeaderRecord.get(headerKey);
						tempKey.add(trayKey);
					}
					else {
						java.util.ArrayList alNewHeader = new java.util.ArrayList();
						alNewHeader.add(trayKey);
						htHeaderRecord.put(headerKey, alNewHeader);
					}
					sbHeaderKey.delete(0,headerKey.length());
					sbTrayKey.delete(0,trayKey.length());
				}
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void updateSelectedTrays(Hashtable htTrays) {
		String selectedTrayValue = null;
		String selectedTrayType = null;
		String selectedKey = null;
		int totalRecordSize = htTrays.size();
		for (int idx = 0; idx<totalRecordSize;idx++ ) {
			selectedTrayValue = (String) htTrays.get("selected_tray_"+idx);
			selectedTrayType = (String) htTrays.get("selected_type_"+idx);
			selectedKey = (String) htTrays.get("total_key_"+idx);
			
			if ((selectedKey != null) && (!alSelectedKeys.contains(selectedKey))) {
				alSelectedKeys.add(selectedKey);
			}

			if ((selectedTrayValue != null) && (!alSelectedTrays.contains(selectedTrayValue))) {
				alSelectedTrays.add(selectedTrayValue);
			}
			if ((selectedTrayType !=null) && (!alSelectedTypes.contains(selectedTrayType))) {
				alSelectedTypes.add(selectedTrayType);
			}
		}

		
	}

	public ArrayList getSelectTray() {
		return alSelectedKeys;
	}
	
	public void clear() {
		doc_type_code="";
		doc_date="";
		doc_no="";
		doc_ref="";
		service_location="";
		store_code="";
		print_rof="";
		finalized_yn="N";
		trn_type="ROF";
		group_type="";

		if(htHeaderRecord !=null)
			htHeaderRecord.clear();
		if(htDetailRecord!=null)
			htDetailRecord.clear();
		if(alSelectedTrays!=null)
			alSelectedTrays.clear();
		if(alSelectedTypes!=null)
			alSelectedTypes.clear();
		if(alHeaderKey!=null)
			alHeaderKey.clear();
		if(alTrayKey!=null)
			alTrayKey.clear();
		if(alSelectedKeys != null) {
			alSelectedKeys.clear();
		}
	}

	public java.util.HashMap insert() {
		int startDocNo = 0;
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		Properties properties = getProperties();
		hmTableData.put("properties",properties );
		hmResult.put("result", new Boolean(false)) ;

		java.util.HashMap groupSterilizeWashType = new java.util.HashMap();
		java.util.Hashtable typeDocNo = new java.util.Hashtable();
			Connection connection = null;
	        PreparedStatement preparedStatement = null ;
		    ResultSet resultSet = null ;

		try {
			//Get Sterilize type and Wash type for the groups;
		
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_SS_GROUP_SELECT"));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				groupSterilizeWashType.put(resultSet.getString(1),new SterlizeWashBean(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
			}
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			 
			//if (connection!= null) {
			//	connection.close();
			//} // closed in finally now 
			//Insertion
			String types = null;
			ArrayList alHDRInsertData = new java.util.ArrayList();
			ArrayList alDTLInsertData = new java.util.ArrayList();
			ArrayList alUpdateData = new java.util.ArrayList();

			String sterilize_yn = null;
			String wash_yn = null;
			String pack_yn = null;
			String next_doc_no = super.fetchNextDocNo(getDoc_type_code());
			startDocNo = Integer.parseInt(next_doc_no);
			setDoc_no(next_doc_no);
			for (int count = 0;count< alSelectedTypes.size();count++) {
				types = (String) alSelectedTypes.get(count);
				if (types == null) { 
					continue;
				}
				sterilize_yn = ""+types.charAt(0);
				wash_yn = ""+types.charAt(1);
				pack_yn = ""+types.charAt(2);

				if (count>0) {
					setDoc_no(""+(Integer.parseInt(getDoc_no()) + 1));

				}
				typeDocNo.put(types,getDoc_no());
		
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
				alHDRInsertRecord.add(sterilize_yn);
				alHDRInsertRecord.add(wash_yn);
				alHDRInsertRecord.add(pack_yn);
				alHDRInsertRecord.add(getTrn_type());
				alHDRInsertRecord.add(login_by_id);
				alHDRInsertRecord.add(login_at_ws_no);
				alHDRInsertRecord.add(login_facility_id);
				alHDRInsertRecord.add(login_by_id);
				alHDRInsertRecord.add(login_at_ws_no);
				alHDRInsertRecord.add(login_facility_id);

				alHDRInsertData.add(alHDRInsertRecord);

				//For Updation SQL_SS_UPDATE_DOC_NO
				ArrayList alUpdateRecord = new java.util.ArrayList();
				alUpdateRecord.add(login_by_id);
				alUpdateRecord.add(login_at_ws_no);
				alUpdateRecord.add(login_facility_id);
				alUpdateRecord.add(getDoc_type_code());
				alUpdateData.add(alUpdateRecord);
			}
			hmSQLMap.put("InsertHDRSQL", SsRepository.getSsKeyValue("SQL_SS_ROF_HDR_INSERT"));
			hmTableData.put("InsertHDRData", alHDRInsertData);
			hmSQLMap.put("UpdateSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmTableData.put("UpdateData",alUpdateData);


			// Insert ROF Detail Value
			String group_code = null;
			SterlizeWashBean tempSterlizeWashBean = null;
			for (int index=0;index<alSelectedTrays.size();index++) {
				ArrayList alDTLInsertRecord = new java.util.ArrayList ();
				java.util.ArrayList dtlData = (java.util.ArrayList) htDetailRecord.get((String)alSelectedTrays.get(index));
				String usageType = "" +dtlData.get(5) + dtlData.get(6) + dtlData.get(7);
				group_code = (String) dtlData.get(2);
				tempSterlizeWashBean = (SterlizeWashBean) groupSterilizeWashType.get(group_code);
		
				alDTLInsertRecord.add(getLoginFacilityId());
				alDTLInsertRecord.add(getDoc_type_code());
				alDTLInsertRecord.add(typeDocNo.get(usageType));
				alDTLInsertRecord.add(group_code);
				alDTLInsertRecord.add((String) dtlData.get(4));

				alDTLInsertRecord.add(checkForNull(tempSterlizeWashBean.getSterilizeType())); // Sterilization Type
				alDTLInsertRecord.add(checkForNull(tempSterlizeWashBean.getWashType())); //Washing Type
				alDTLInsertRecord.add(checkForNull(tempSterlizeWashBean.getPackItemCode())); //Pack Item Code
				alDTLInsertRecord.add(checkForNull(tempSterlizeWashBean.getPackItemQty())); //Pack Item Qty
				alDTLInsertRecord.add("RE");
				alDTLInsertRecord.add(group_code);
				alDTLInsertRecord.add(checkForNull(tempSterlizeWashBean.getSterilizeType()));
				alDTLInsertRecord.add(group_code);
				alDTLInsertRecord.add(group_code);
				alDTLInsertRecord.add(checkForNull(tempSterlizeWashBean.getSterilizeType()));
				alDTLInsertRecord.add(group_code);
				alDTLInsertRecord.add(login_by_id);
				alDTLInsertRecord.add(login_at_ws_no);
				alDTLInsertRecord.add(login_facility_id);
				alDTLInsertRecord.add(login_by_id);
				alDTLInsertRecord.add(login_at_ws_no);
				alDTLInsertRecord.add(login_facility_id);

System.err.println("------INSERT getGroupType"+getGroupTypeValue());
				alDTLInsertRecord.add(getGroupTypeValue()); //ML/MMOH-CRF-1821
					 
				alDTLInsertData.add(alDTLInsertRecord);
			}
			hmSQLMap.put("InsertDTLSQL", SsRepository.getSsKeyValue("SQL_SS_ROF_DTL_INSERT"));
			hmTableData.put("InsertDTLData", alDTLInsertData);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		finally{
			try{
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			//if (connection!= null) {
			//	connection.close();
			//} // closed in finally now 

		}


		GenerateROFRemote generateROFRemote = null ;
		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_GENERATE_ROF"),GenerateROFHome.class,getLocalEJB());
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();
           

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			hmResult.put("flag", "Generated Doc No from : "+startDocNo+" to "+getDoc_no()) ;
		}
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(generateROFRemote != null)
					generateROFRemote.remove() ;
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString()) ;
			}
		}
		clear();
		return hmResult;
	}

	// Instead of having Set/Get method, having a method with query for getting Linen Type 
	/* ML-MMOH-CRF-1821 - STARTS */	
	public boolean getLinen_applicable_yn() {
		boolean linen_applicable_yn = false;
		Connection connection = null;
		try{
				connection = getConnection();
				linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(connection,"SS", "SS_GROUP_TYPE_LINEN"); 
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally{
			try{
				closeConnection(connection);
			}catch(Exception ex) {
			ex.printStackTrace();
			}
		return linen_applicable_yn;
		}
	}

	public String getGroupType() {
		if(getLinen_applicable_yn()){  // calling internal method
			return getStaticListOptionTag(" , ---Select--- ;T,Tray;E,Set;P,Soft Pack;S,Single;L,Linen");  
		}else{
			return getStaticListOptionTag(" , ---Select--- ;T,Tray;E,Set;P,Soft Pack;S,Single;");
		}
		
	}// Added ends

	
	public String getGroupTypeParameterYn () {

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String    group_type_yn = "";
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( getSsRepositoryValue("SQL_SS_GROUPTYPE_DEFLT_PARAM") ) ;
			pstmt.setString( 1, login_facility_id ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				group_type_yn = checkForNull(resultSet.getString("GROUP_TYPE_MANDATORY_YN"),"N" ) ;
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
		return group_type_yn; 
	}
	/* ML-MMOH-CRF-1821 - ENDS */

}	
