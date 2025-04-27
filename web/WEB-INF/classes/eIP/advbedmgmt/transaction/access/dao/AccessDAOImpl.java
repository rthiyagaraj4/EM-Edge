/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIP.advbedmgmt.transaction.access.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import webbeans.eCommon.ConnectionManager;
import eIP.advbedmgmt.transaction.access.request.AccessRequest;
import eIP.advbedmgmt.transaction.access.response.AccessResponse;

/**
 * This is the DAO impl class for getting access rights for CRUD
 * operations in bed manager GUI
 * @author GRamamoorthy
 *
 */
public class AccessDAOImpl implements AccessDAO {

	/**
	 * This method returns the access rights for CRUD
	 * operations in bed manager GUI
	 * @param accessRequest
	 * @return
	 */
	public AccessResponse getAccess(AccessRequest accessRequest){
		AccessResponse accessResponse = new AccessResponse();
		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		// if request itself is null nothing can be done
		if(accessRequest == null){
			// log the problem
			String logMessage = "Cannot get access rights as the request is null.";
			if(loggerInst != null){
				loggerInst.fatal(logMessage);	
			}
			
			return accessResponse;
		}
		// initialize connection
		Connection conn = ConnectionManager.getConnection();
		// safe check
		if(conn == null){
			// log the problem
			String functionalityIdentifier = accessRequest.getFunctionalityIdentifier();
			String logMessage = "Could not get connection to retrieve access rights for "+functionalityIdentifier;
			if(loggerInst != null){
				loggerInst.fatal(logMessage);	
			}
			
			return accessResponse;
		}
		
		String sqlQuery = getSQLQueryForAccess(accessRequest);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPrepStatement(prepStmt, accessRequest);
			rs = prepStmt.executeQuery();
			// safe check
			if(rs == null){
				// log the problem
				String functionalityIdentifier = accessRequest.getFunctionalityIdentifier();
				String logMessage = "Could not retrieve access rights for "
						+ functionalityIdentifier + " ;result set is null";
				if(loggerInst != null){
					loggerInst.error(logMessage);	
				}
				return accessResponse;
			}
			
			String insertAccess = null;
			String updateAccess = null;
			String queryAccess = null;
			String deleteAccess = null;
			String printAccess = null;
			StringBuilder accessBuilder = new StringBuilder();
			// read the data from result set and add it to a string builder
			// the string builder's output will be the final access right
			while(rs.next()){
				insertAccess = rs.getString("INSERT_ACCESS_YN");
				updateAccess = rs.getString("UPDATE_ACCESS_YN");
				queryAccess = rs.getString("QUERY_ONLY_ACCESS_YN");
				deleteAccess = rs.getString("DELETE_ACCESS_YN");
				printAccess = rs.getString("PRINT_ACCESS_YN");
				accessBuilder.append(insertAccess);
				accessBuilder.append(updateAccess);
				accessBuilder.append(queryAccess);
				accessBuilder.append(deleteAccess);
				accessBuilder.append(printAccess);
			}
			// set the access finally
			accessResponse.setAccess(accessBuilder.toString());
			
		} catch (SQLException e) {
			// logging is done
			String functionalityIdentifier = accessRequest.getFunctionalityIdentifier();
			String logMessage = "Could not retrieve access rights for "
					+ functionalityIdentifier + " ;Exception message="
					+ e.getMessage();
			if(loggerInst != null){
				loggerInst.error(logMessage);	
			}
			
			return accessResponse;
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			if(prepStmt != null){
				try {
					prepStmt.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			ConnectionManager.returnConnection(conn);
		}
		
		return accessResponse;
	}
	
	/**
	 * This method gets the SQL query for getting access rights 
	 * @param accessRequest
	 * @return
	 */
	private String getSQLQueryForAccess(AccessRequest accessRequest){
		StringBuilder accessQuery = new StringBuilder();
		accessQuery.append("SELECT menu_dtl.menu_id menu_id,menu_dtl.option_sequence_no,menu_dtl.submenu_id submenu_id, menu_dtl.option_type,(CASE WHEN menu_dtl.submenu_id is not null THEN "); 
		accessQuery.append(" sm_get_desc.SM_MENU_HDR(menu_dtl.submenu_id,?,'1') ELSE menu_dtl.option_descriptor END) option_descriptor,  menu_dtl.function_id function_id, menu_dtl.module_id "); 
		accessQuery.append(" module_id, menu_dtl.insert_access_yn insert_access_yn, menu_dtl.update_access_yn update_access_yn, menu_dtl.delete_access_yn delete_access_yn, menu_dtl.print_access_yn "); 
		accessQuery.append(" print_access_yn, menu_dtl.query_only_access_yn query_only_access_yn FROM sm_menu_hdr menu_hdr, (SELECT LEVEL p_level, menu_id, submenu_id, option_type, NVL ");
		accessQuery.append(" ((SELECT option_descriptor FROM sm_menu_dtl_lang WHERE menu_id = sm_menu_dtl.menu_id AND option_sequence_no = sm_menu_dtl.option_sequence_no AND language_id = ?), ");
		accessQuery.append(" sm_menu_dtl.option_descriptor ) option_descriptor, function_id, module_id, insert_access_yn, update_access_yn, delete_access_yn, print_access_yn, query_only_access_yn, ");
		accessQuery.append(" option_sequence_no, srl_no FROM sm_menu_dtl CONNECT BY PRIOR submenu_id = menu_id START WITH menu_id = ? and function_id=? ORDER BY ROWNUM) menu_dtl WHERE menu_dtl.p_level = ");
		accessQuery.append(" 1 AND menu_dtl.menu_id = menu_hdr.menu_id AND submenu_id IS NULL ORDER BY menu_dtl.option_sequence_no, menu_dtl.srl_no ");
		return accessQuery.toString();
	}
	
	/**
	 * This method sets the prepared statement with data obtained from the 
	 * access request object
	 * @param prepStmt
	 * @param accessRequest
	 * @throws SQLException
	 */
	private void setDataInPrepStatement(PreparedStatement prepStmt,
			AccessRequest accessRequest) throws SQLException {
		// locale is to be set first and that too twice
		String locale = accessRequest.getLocale();
		int index = 1;
		prepStmt.setString(index, locale);
		index++;
		
		prepStmt.setString(index, locale);
		index++;
		
		// now the menu id
		String menuId = accessRequest.getMenuId();
		prepStmt.setString(index, menuId);
		index++;
		
		// function id
		String functionId = accessRequest.getFunctionId();
		prepStmt.setString(index, functionId);
		index++;
	}
	
	/*public static void main(String[] args){
		AccessRequest request = new AccessRequest();
		request.setLocale(Locale.getDefault().getLanguage());
		request.setMenuId(IP_BOOKING_KEYWORD);
		request.setFunctionId(IP_BOOKING_FUNCTIONID_KEYWORD);
		
		AccessDAOImpl daoImpl = new AccessDAOImpl();
		AccessResponse response = daoImpl.getAccess(request);
		
	}*/	


}
