/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for Post Variance
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
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.SsAdapter;
import eSS.SSPostVariance.*;

public class PostVarianceBean extends eSS.Common.SsTransaction implements java.io.Serializable {

	// Table Column Variables 
	private String trn_type;
	private String doc_type_code;
	private String doc_date;
	private String doc_no;
	private String bin_location_code;
	private String facility_id;
	private String tray_no;
	private String write_off_reason_code;
	private boolean isAutoNo;
	private String defaultWriteOffReasonCode ="";
	private String phy_inv_id;
	
	/* For default Values ! */
	private String defaultDocType = "";
	private String defaultStoreCode = "";
	
	public void setDefaultDocType (String defaultDocType) {
		this.defaultDocType  = defaultDocType;
	}

	public String getDefaultDocType () {
		return this.defaultDocType;
	}

	public void setDefaultStoreCode (String defaultStoreCode) {
		this.defaultStoreCode = defaultStoreCode;
	}

	public void setPhy_inv_id (String phy_inv_id) {
		this.phy_inv_id = phy_inv_id;
	}

	public String getPhy_inv_id() {
		return this.phy_inv_id;
	}

	public String getDefaultStoreCode() {
		return this.defaultStoreCode;
	}

	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}
	
	public void setWrite_off_reason_code(String write_off_reason_code) {
		this.write_off_reason_code = write_off_reason_code;
	}

	public String getWrite_off_reason_code() {
		return this.write_off_reason_code;
	}

	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = tray_no;
	}

	public String getTray_no() {
		 return tray_no;
	}

	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}

	public String getTrn_type() {
		 return trn_type;
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
		try {
			if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				return getSystemDate();
			}
			else {
				return doc_date;
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

	public String getDoc_no() {
		 return doc_no;
	}

	public void setBin_location_code(String bin_location_code) {
		 this.bin_location_code = bin_location_code;
	}

	public String getBin_location_code() {
		 return bin_location_code;
	}

	public void setFacility_id(String facility_id) {
		 this.facility_id = facility_id;
	}

	public String getFacility_id() {
		 return facility_id;
	}

	public void clear(){
		super.clear();
		this.trn_type="";         
		this.doc_type_code="";    
		this.doc_date="";         
		this.doc_no="";           
		this.bin_location_code="";
		this.facility_id="";      
		this.tray_no="";          
	}

	public void setAll(Hashtable htRecordSet) {
		setMode((String) htRecordSet.get("mode"));
		setTrn_type((String) htRecordSet.get("trn_type"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date((String) htRecordSet.get("doc_date"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setWrite_off_reason_code((String) htRecordSet.get("write_off_reason_code"));
		setPhy_inv_id((String) htRecordSet.get("phy_inv_id"));
	}
	
	public String getDocTypes() {
		String optionValues = null;
		//Get the default Document Type Code for the given Document Type
		java.util.ArrayList alPostVarianceDoc = new java.util.ArrayList(5);
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alPostVarianceDoc.add(login_facility_id);
		alPostVarianceDoc.add("VAR");
		alPostVarianceDoc.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST"), alPostVarianceDoc);
		if ((doc_type_code != null)) {
			optionValues = getListOptionTag(alOptionValues,getDefaultDocType());
		}
		else {
			optionValues = getListOptionTag(alOptionValues);
		}
		alPostVarianceDoc = null;
		alOptionValues = null;
		return optionValues;
	}

	public String getPhyInvIDs() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PHY_INV_PARAM_SELECT_LIST"), login_facility_id);
		optionValues = getListOptionTag(alOptionValues,getDefaultStoreCode());
		alOptionValues = null;
		return optionValues;
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
				preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WRITE_OFF_HDR_RECORD_COUNT"));
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
				if (resultSet != null) 
					resultSet.close();
				if (preparedStatement != null) 
					preparedStatement.close();
				if (connection!= null) {
					connection.close();
				}
			}
		}
		catch (Exception exception) {
			resultMap.put("result", new Boolean(false));
			resultMap.put("message",exception.getMessage());
		}
		return resultMap;
	}

	public HashMap isValidDocNo() {
		Connection connection = null;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success") ;

		int recordExists = -1;
		try {
			if ((!isAutoNo) && (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WRITE_OFF_HDR_RECORD_COUNT"));
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
				if (resultSet != null) 
					resultSet.close();
				if (preparedStatement != null) 
					preparedStatement.close();
				if (connection!= null) {
					connection.close();
				}
			}
		}
		catch (Exception exception) {
			resultMap.put("result", new Boolean(false));
			resultMap.put("message",exception.getMessage());
		}
		return resultMap;
	}

	public void setDefaultWriteOffReasonCode(String defaultWriteOffReasonCode) {
		this.defaultWriteOffReasonCode = defaultWriteOffReasonCode;
	}

	public String getDefaultWriteOffReasonCode() {
		return this.defaultWriteOffReasonCode;
	}

	public HashMap insert() {
		String sql = "";
		Properties properties = getProperties();
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData	=	new HashMap();
		HashMap hmSQLMap	=	new HashMap();
		ArrayList InParam = new ArrayList();
		ArrayList OutParam = new ArrayList();
		
		hmResult.put("result", new Boolean(false)) ;
		try {
			if (isAutoNo) {
				String next_doc_no = super.fetchNextDocNo(getDoc_type_code());
				setDoc_no(next_doc_no);
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		sql = "{ call SS_INSERT_INTO_WRITE_OFF(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
		InParam.add(login_facility_id);
		InParam.add(getPhy_inv_id());
		InParam.add(getDoc_type_code());
		InParam.add(getDoc_no());
		InParam.add(getDoc_date());
		InParam.add(getWrite_off_reason_code());
		InParam.add(login_by_id);
		InParam.add(login_at_ws_no);
		OutParam.add(new Integer(java.sql.Types.VARCHAR));
		OutParam.add(new Integer(java.sql.Types.INTEGER));
		hmTableData.put("OutParameter",OutParam);
		hmTableData.put("InParameter",InParam);
		hmTableData.put("properties",properties);
		hmSQLMap.put("CallStatement",sql);

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( eSS.Common.SsRepository.getSsKeyValue("JNDI_POST_VARIANCE"),SSPostVarianceHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if(((Boolean) hmResult.get("result")).booleanValue())		
							hmResult.put( "message", getMessage(getLanguageId(),(String)hmResult.get( "msgid" ),"SS") ) ;

			else
				hmResult.put("message", hmResult.get("msgid"));
		} 
		catch(Exception e) {
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				//if(postVarianceRemote != null)
				//	postVarianceRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.getMessage());
			}
		}
		return hmResult;
	}
	
	public String getDiscrepancyReasons() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"),getLanguageId());
		optionValues = getListOptionTag(alOptionValues,defaultWriteOffReasonCode);
		alOptionValues = null;
		return optionValues;
	}

    public HashMap apply() {
		HashMap test = null;
		try {
			test = super.apply();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return test;
	}
}
