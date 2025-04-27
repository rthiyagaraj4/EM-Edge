/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 25/10/2005.
package ePH;

import java.io.*;
import java.util.*;
import java.sql.*;
import ePH.Common.*;
import javax.naming.*;
import eCommon.Common.*;
import javax.rmi.*;
import eCommon.SingleTableHandler.*;

public class PresRemarkForDrugBean extends PhAdapter implements Serializable {

	protected String content = "";
	protected String DrugSearch = "";
	protected String Drug_code = "";
	protected String preRemark = "";
	protected String Prescription_code = "";
	protected String remarks_code = "";
	protected String locale = "";
	protected String drugValue, chekvalue, Drugcode = "";
	protected String drug_code, mode, eff_status, drug_desc = "";
	protected ArrayList drugTypeDetails = new ArrayList();
	protected ArrayList remarksSearchResult = new ArrayList();
	protected ArrayList remarksInsertResult = new ArrayList();
	protected ArrayList remarksUpdateList = new ArrayList();
	protected String remarks_desc = "";
	protected String defaultRouteCode = "";
	protected ArrayList remarksCodeList = new ArrayList();
	protected String remarksCode = "";
	protected String remarksDesc = "";
	protected String routeCode = "";

	public PresRemarkForDrugBean() {
		try {
			doCommon();
		} catch (Exception e) {
			System.err.println("Error in Constructor" + e.toString());
			e.printStackTrace();
		}
	}

	private void doCommon() throws Exception {
	}

	//End of Get Methods

	//Validate Method
	public HashMap validate() throws Exception {
		HashMap map = new HashMap();
		map.put("result", new Boolean(true));
		map.put("message", "success..");
		return map;
	}

	public void setLanguageId(String locale) {
		this.locale = locale;
	}

	public void setDefaultRouteCode(String defaultRouteCode) {
		this.defaultRouteCode = defaultRouteCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public void setDrugdesc(String drug_desc) {
		this.drug_desc = drug_desc;
	}

	public void setRemarkscode(String remarks_code) {
		this.remarks_code = remarks_code;
	}

	public void setRemarksDesc(String remarks_desc) {
		this.remarks_desc = remarks_desc;
	}

	public void setEffstatus(String eff_status) {
		this.eff_status = eff_status;
	}

	public void setDrugcode(String drug_code) {
		this.drug_code = drug_code;
	}

	public String getDrugdesc() {
		return this.drug_desc;
	}

	public String getDefaultRouteCode() {
		return this.defaultRouteCode;
	}

	public String getEffstatus() {
		return this.eff_status;
	}

	public String getRouteCode() {
		return this.routeCode;
	}

	public String getRemarksDesc() {
		return this.remarks_desc;
	}

	public String getDrugcode() {
		return this.drug_code;
	}

	public String getLanguageId() {
		return this.locale;
	}

	public String getRemarkscode() {
		return this.remarks_code;
	}

	public void setRemarksCodeList(ArrayList remarksCodeList) {

		this.remarksCodeList = remarksCodeList;
	}

	public ArrayList getRemarksCodeList() {
		return this.remarksCodeList;
	}

	public void setRemarksInsertList(ArrayList remarksInsertResult) {
		this.remarksInsertResult = remarksInsertResult;
	}

	public ArrayList getremarksInsertList() {
		return this.remarksInsertResult;
	}

	public void setRemarksSearchList(ArrayList remarksSearchResult) {
		this.remarksSearchResult = remarksSearchResult;
	}

	public ArrayList getRemarksSearchList() {
		return this.remarksSearchResult;
	}

	public void clear() {
		remarksSearchResult = new ArrayList();
		remarksInsertResult = new ArrayList();
		remarksCodeList.clear();
	}

	//SetAll method
	public void setAll(Hashtable recordSet) {
		if (recordSet.containsKey("Prescription_code"))
			Prescription_code = (String) recordSet.get("Prescription_code");

		if (recordSet.containsKey("remarks_code"))
			remarks_code = (String) recordSet.get("remarks_code");

		if (recordSet.containsKey("Drugcode"))
			Drugcode = (String) recordSet.get("Drugcode");

		if (recordSet.containsKey("chekvalue")) {
			chekvalue = (String) recordSet.get("chekvalue");
			eff_status = chekvalue;
		}
		if (recordSet.containsKey("drugValue")) {
			drugValue = (String) recordSet.get("drugValue");
			eff_status = drugValue;
		}
	}

	public String[] getFormDesc(String drugCode, String locale) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String formArray[] = new String[2];
		String route = "";
		try {
			connection = getConnection();
		//	String defaultRoute = "";  Removed for IN063877
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_SELECT" )) ;
			pstmt.setString(1, drugCode.trim());
			pstmt.setString(2, locale.trim());
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				formArray[0] = checkForNull(resultSet.getString("FORM_DESC"));
				formArray[1] = checkForNull(resultSet.getString("FORM_CODE"));
				route = checkForNull(resultSet.getString("ROUTE_CODE"));
			}
			setDefaultRouteCode(route);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch (Exception es) {
				es.printStackTrace();
			}
		}
		return formArray;
	}

	public ArrayList getRouteDesc(String formCode, String locale){
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList routeList = new ArrayList();
		try {
			connection = getConnection();
			//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT2")) ;
			pstmt = connection.prepareStatement("SELECT B.ROUTE_CODE ROUTE_CODE, B.ROUTE_DESC ROUTE_DESC,B.ROUTE_COLOR FROM PH_ROUTE_FOR_FORM A,PH_ROUTE_LANG_VW B WHERE A.ROUTE_CODE=B.ROUTE_CODE AND FORM_CODE =? AND LANGUAGE_ID =? ORDER BY 2");

			pstmt.setString(1, formCode);
			pstmt.setString(2, locale);
			resultSet = pstmt.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					routeList.add(checkForNull(resultSet.getString("ROUTE_CODE")));
					routeList.add(checkForNull(resultSet.getString("ROUTE_DESC")));
					routeList.add(checkForNull(resultSet.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389]
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} 
			catch (Exception es) {
				es.printStackTrace();
			}
		}
		return routeList;
	}

	public ArrayList getRemarksResult(String drugcode, String drugSearch, String formCode, String routeCode, String locale) {
		//drugcode=drugcode+"%";
		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		remarksSearchResult = new ArrayList();
		//remarksCodeList = new ArrayList();
		String route_code = "";
		//String routeDesc = "";  Removed for IN063877
		try {

			connection = getConnection();
			pstmt1 = connection.prepareStatement("SELECT REMARK_CODE,EFF_STATUS,DEFAULT_REMARK_YN FROM PH_PRES_REMARK_FOR_DRUG WHERE DRUG_CODE = ?");

			pstmt1.setString(1, drugcode);
			resultSet1 = pstmt1.executeQuery();

			while (resultSet1.next() && resultSet1 != null) {
				remarksCodeList.add(resultSet1.getString("REMARK_CODE"));
				remarksCodeList.add(resultSet1.getString("DEFAULT_REMARK_YN"));
				remarksCodeList.add(resultSet1.getString("EFF_STATUS"));
			}

			setRemarksCodeList(remarksCodeList);

			pstmt = connection.prepareStatement("SELECT  A.REMARK_CODE, REMARK_DESC, A.FORM_CODE,A.ROUTE_CODE,C.ROUTE_DESC, c.route_color FROM PH_PRES_REMARK_LANG_VW A, PH_FORM_LANG_VW B, PH_ROUTE_LANG_VW C WHERE A.FORM_CODE = B.FORM_CODE AND  A.ROUTE_CODE = C.ROUTE_CODE AND A.LANGUAGE_ID=? AND B.LANGUAGE_ID=? AND C.LANGUAGE_ID=? AND A.FORM_CODE = ? AND A.ROUTE_CODE LIKE ? ORDER BY A.ROUTE_CODE");//commented for SKR-SCF-1053 [IN:051947]
			//pstmt = connection.prepareStatement("SELECT   a.remark_desc,a.remark_code, a.form_code, c.route_code, c.route_desc,d.default_remark_yn, d.eff_status, a.route_code,c.route_color FROM ph_pres_remark_lang_vw a, ph_pres_remark_for_drug d, ph_form_lang_vw b, ph_route_lang_vw c WHERE a.remark_code=d.remark_code AND a.form_code = b.form_code AND a.route_code = c.route_code AND a.language_id = ? AND b.language_id = ? AND c.language_id = ? AND a.form_code = ? AND c.route_code LIKE ? AND d.drug_code=? ORDER BY a.form_code ");//added for SKR-SCF-1053 [IN:051947]

			if (routeCode.equalsIgnoreCase("All"))
				route_code = "%";
			else
				route_code = routeCode;

			setRouteCode(route_code);

			pstmt.setString(1, locale.trim());
			pstmt.setString(2, locale.trim());
			pstmt.setString(3, locale.trim());
			pstmt.setString(4, formCode.trim());
			pstmt.setString(5, route_code.trim());
		//	pstmt.setString(6, drugcode.trim());//Commented for ARYU-SCF-0024

			resultSet = pstmt.executeQuery();

		//	String drug_code = "", drug_desc = "", db_action = "", eff_status = "", sel = "", default_remark_yn = "", default_remark_exists_yn = "";  Removed for IN063877
			while (resultSet != null && resultSet.next()) {
				remarksSearchResult.add(drugcode.trim());
				remarksSearchResult.add(resultSet.getString("REMARK_CODE"));
				remarksSearchResult.add(resultSet.getString("REMARK_DESC"));
				remarksSearchResult.add(resultSet.getString("ROUTE_CODE"));

				remarksSearchResult.add("N");
				remarksSearchResult.add("D");
				remarksSearchResult.add("I");
				remarksSearchResult.add(checkForNull(resultSet.getString("ROUTE_DESC")));
				remarksSearchResult.add(checkForNull(resultSet.getString("route_color")));
			}
			setRemarksSearchList(remarksSearchResult);
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				closeResultSet(resultSet1);
				closeStatement(pstmt1);
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch (Exception es) {
				es.printStackTrace();
			}
		}
		return remarksSearchResult;
	}

	public HashMap insert() {

		HashMap map = new HashMap();
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();
		ArrayList insertData = new ArrayList();
		ArrayList modifyData = new ArrayList();
		ArrayList insertRow = new ArrayList();
		ArrayList modifyRow = new ArrayList();

		map.put("result", new Boolean(false));
		map.put("flag", "0");

		int count = 0;
		int index = 0;
		String drug_type_code = "";
		String db_action = "";
		String changed = "";
	//	String eff_status = "";  Removed for IN063877
		String default_remark_yn = "";
		String msgId = "";
		String remarks_code = "";
		try {
			while ((remarksSearchResult != null)&& (count < remarksInsertResult.size())) {

				drug_type_code = (String) remarksInsertResult.get(index++);
				remarks_code = (String) remarksInsertResult.get(index++);
				index++;
				index++;
				default_remark_yn = (String) remarksInsertResult.get(index++);
				changed = (String) remarksInsertResult.get(index++);
				db_action = (String) remarksInsertResult.get(index++);

				if (db_action.equals("I")) {
					if (changed.equals("E")) {
						insertRow = new ArrayList();
						insertRow.add(drug_type_code);
						insertRow.add(remarks_code);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(changed);
						insertRow.add(default_remark_yn);
						insertData.add(insertRow);
					} 
					else if (changed.equals("D")) {
						insertRow = new ArrayList();
						insertRow.add(drug_type_code);
						insertRow.add(remarks_code);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(changed);
						insertRow.add(default_remark_yn);
						insertData.add(insertRow);
					}
					map.put("result", new Boolean(true));
				}
				else if (db_action.equals("U")) {
					if (changed.equals("E")) {
						modifyRow = new ArrayList();
						modifyRow.add(changed);
						modifyRow.add(default_remark_yn);
						modifyRow.add(login_by_id);
						modifyRow.add(login_at_ws_no);
						modifyRow.add(login_facility_id);
						modifyRow.add(drug_type_code);
						modifyRow.add(remarks_code);
						modifyData.add(modifyRow);
					}
					else if (changed.equals("D")) {
						modifyRow = new ArrayList();
						modifyRow.add(changed);
						modifyRow.add(default_remark_yn);
						modifyRow.add(login_by_id);
						modifyRow.add(login_at_ws_no);
						modifyRow.add(login_facility_id);
						modifyRow.add(drug_type_code);
						modifyRow.add(remarks_code);
						modifyData.add(modifyRow);
					}
					map.put("result", new Boolean(true));
				}
				count += 7;
			}
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create", null)).invoke(home, null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class[] paramArray = new Class[2];
			paramArray[0] = tabData.getClass();
			paramArray[1] = sqlMap.getClass();

			if (insertData.size() > 0) {
				tabData.put("properties", getProperties());
				tabData.put("InsertData", insertData);
				//sqlMap.put("InsertSQL", sql_insert);
				//sqlMap.put("InsertSQL",PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_INSERT"));
				String insrtSQL = "INSERT INTO PH_PRES_REMARK_FOR_DRUG(DRUG_CODE,REMARK_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EFF_STATUS,DEFAULT_REMARK_YN)VALUES (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";
				sqlMap.put("InsertSQL", insrtSQL);

				map = (HashMap) (busObj.getClass().getMethod("singleBatchHandler", paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,null);
			}

			if (((Boolean) map.get("result")).booleanValue()) {
				if (modifyData.size() > 0) {
					tabData.clear();
					sqlMap.clear();
					tabData.put("properties", getProperties());
					tabData.put("InsertData", modifyData);
					//sqlMap.put( "InsertSQL", sql_update);
					sqlMap.put("InsertSQL",PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_UPDATE1"));
					map = (HashMap) (busObj.getClass().getMethod("singleBatchHandler", paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
				}
			}
			if (((Boolean) map.get("result")).booleanValue())
				map.put("message", getMessage(getLanguageId(), (String) map.get("msgid"), "PH"));
			//map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else {
				msgId = (String) map.get("msgid") == null ? "" : (String) map.get("msgid");
				if ((msgId).equals("CODE_ALREADY_EXISTS")) {
					map.put("message", getMessage(getLanguageId(), (String) map.get("msgid"), "Common"));
					String msgID = getMessage((String) map.get("msgid"), false);
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put("message", msgID);
					map.put("invalidCode", delimitedString((ArrayList) map.get("invalidCode")));
				}
				else if (msgId.equals("")) {
					map.put("message", getMessage(getLanguageId(),"PH_NO_CHANGE", "PH"));
				}
				else
					map.put("message", (map.get("msgid")));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public HashMap modify() {

		HashMap map = new HashMap();
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();
		ArrayList insertData = new ArrayList();
		ArrayList modifyData = new ArrayList();
		ArrayList insertRow = new ArrayList();
		ArrayList modifyRow = new ArrayList();

		map.put("result", new Boolean(false));
		map.put("flag", "0");

		int count = 0;
		int index = 0;
		String drug_type_code = "";
		String db_action = "";
		String changed = "";
		//String eff_status = "";  Removed for IN063877
		String default_remark_yn = "";
		String msgId = "";
		String remarks_code = "";
		try {

			while ((remarksSearchResult != null)&& (count < remarksInsertResult.size())) {
				drug_type_code = (String) remarksInsertResult.get(index++);
				remarks_code = (String) remarksInsertResult.get(index++);
				index++;
				index++;
				default_remark_yn = (String) remarksInsertResult.get(index++);
				changed = (String) remarksInsertResult.get(index++);
				db_action = (String) remarksInsertResult.get(index++);

				if (db_action.equals("I")) {
					if (changed.equals("E")) {
						insertRow = new ArrayList();
						insertRow.add(drug_type_code);
						insertRow.add(remarks_code);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(changed);
						insertRow.add(default_remark_yn);
						insertData.add(insertRow);
					}
					else if (changed.equals("D")) {
						insertRow = new ArrayList();
						insertRow.add(drug_type_code);
						insertRow.add(remarks_code);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(login_by_id);
						insertRow.add(login_at_ws_no);
						insertRow.add(login_facility_id);
						insertRow.add(changed);
						insertRow.add(default_remark_yn);
						insertData.add(insertRow);
					}
					map.put("result", new Boolean(true));
				}
				else if (db_action.equals("U")) {
					if (changed.equals("E")) {
						modifyRow = new ArrayList();
						modifyRow.add(changed);
						modifyRow.add(default_remark_yn);
						modifyRow.add(login_by_id);
						modifyRow.add(login_at_ws_no);
						modifyRow.add(login_facility_id);
						modifyRow.add(drug_type_code);
						modifyRow.add(remarks_code);
						modifyData.add(modifyRow);
					} 
					else if (changed.equals("D")) {
						modifyRow = new ArrayList();
						modifyRow.add(changed);
						modifyRow.add(default_remark_yn);
						modifyRow.add(login_by_id);
						modifyRow.add(login_at_ws_no);
						modifyRow.add(login_facility_id);
						modifyRow.add(drug_type_code);
						modifyRow.add(remarks_code);
						modifyData.add(modifyRow);
					}
					map.put("result", new Boolean(true));
				}
				count += 7;
			}

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create", null)).invoke(home, null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class[] paramArray = new Class[2];
			paramArray[0] = tabData.getClass();
			paramArray[1] = sqlMap.getClass();

			if (insertData.size() > 0) {
				tabData.put("properties", getProperties());
				tabData.put("ModifyData", insertData);
				//sqlMap.put("InsertSQL", sql_insert);
				//sqlMap.put("InsertSQL",PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_INSERT"));
				String insrtSQL = "INSERT INTO PH_PRES_REMARK_FOR_DRUG(DRUG_CODE,REMARK_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EFF_STATUS,DEFAULT_REMARK_YN)VALUES (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";
				sqlMap.put("ModifySQL", insrtSQL);

				map = (HashMap) (busObj.getClass().getMethod("singleBatchHandler", paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,null);
			}
			if (((Boolean) map.get("result")).booleanValue()) {
				if (modifyData.size() > 0) {
					tabData.clear();
					sqlMap.clear();
					tabData.put("properties", getProperties());
					tabData.put("ModifyData", modifyData);
					//sqlMap.put( "InsertSQL", sql_update);
					sqlMap.put("ModifySQL",PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_UPDATE1"));
					map = (HashMap) (busObj.getClass().getMethod("singleBatchHandler", paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
				}
			}
			if (((Boolean) map.get("result")).booleanValue())
				map.put("message", getMessage(getLanguageId(), (String) map.get("msgid"), "PH"));
			//map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else {
				msgId = (String) map.get("msgid") == null ? "" : (String) map.get("msgid");
				if ((msgId).equals("CODE_ALREADY_EXISTS")) {
					map.put("message", getMessage(getLanguageId(), (String) map.get("msgid"), "Common"));
					String msgID = getMessage((String) map.get("msgid"), false);
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put("message", msgID);
					map.put("invalidCode", delimitedString((ArrayList) map.get("invalidCode")));
				} 
				else if (msgId.equals("")) {
					map.put("message", getMessage(getLanguageId(),"PH_NO_CHANGE", "PH"));
				}
				else
					map.put("message", (map.get("msgid")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public ArrayList getDefaultRemark(String drugcode) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
	//	String defaultRemark = "N";  Removed for IN063877
		try {
			connection = getConnection();
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_SELECT1") ) ;
			pstmt.setString(1, drugcode.trim());
			//pstmt.setString(2,preRemark.trim());
			resultSet = pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				remarksUpdateList.add(resultSet.getString("REMARK_CODE"));
				remarksUpdateList.add(resultSet.getString("DEFAULT_REMARK_YN"));
				remarksUpdateList.add(resultSet.getString("EFF_STATUS"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} 
			catch (Exception es) {
				es.printStackTrace();
			}
		}
		return remarksUpdateList;
	}

	public String getDefaultRemarkRoute(String drugcode) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String defaultRemarkRoute = "";
		try {
			connection = getConnection();
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_SELECT2") ) ;
			pstmt.setString(1, drugcode.trim());
			resultSet = pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				defaultRemarkRoute = resultSet.getString("ROUTE_CODE");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch (Exception es) {
				es.printStackTrace();
			}
		}
		return defaultRemarkRoute;

	}
}
