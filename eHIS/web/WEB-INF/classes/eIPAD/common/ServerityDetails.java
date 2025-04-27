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
package eIPAD.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;

/**
 * @author GRamamoorthy
 *
 */
public class ServerityDetails {

	/**
	 * default constructor of the class
	 */
	public ServerityDetails() {
	}

	/**
	 * This method gets all the severity icons
	 * @param iconRequest
	 * @return
	 */
	public SeverityIconsResponse getSeverityIcons(SeverityIconsRequest iconRequest){
		SeverityIconsResponse iconResponse = new SeverityIconsResponse();
		if(iconRequest == null){
			return iconResponse;
		}
		
		HttpServletRequest servletRequest = iconRequest.getRequest();
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return iconResponse;
		}
		
		String patientId = iconRequest.getPatientId();
		patientId = CommonBean.checkForNull(patientId);
		
		String query = "SELECT high_str_desc, high_color_code, HIGH_SYMBOL_ICON, low_str_desc, low_color_code, LOW_SYMBOL_ICON, abn_str_desc, abn_color_code, ABN_SYMBOL_ICON, crit_str_desc, crit_color_code, CRIT_SYMBOL_ICON, crit_high_str_desc, crit_high_color_code, CRIT_HIGH_SYMBOL_ICON, crit_low_str_desc, crit_low_color_code, CRIT_LOW_SYMBOL_ICON, DELTA_FAIL_STR";
		if(!patientId.trim().equals("")){
			query += ", nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth";
		}
		
		query += " FROM CR_CLIN_EVENT_PARAM";
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(query);
			if(!patientId.trim().equals("")){
				prepStmt.setString(1, patientId);
			}
			
			rs = prepStmt.executeQuery();
			if(rs != null){
				String highSymbolIcon = null;
				String lowSymbolIcon = null;
				String abnormalSymbolIcon = null;
				String criticalSymbolIcon = null;
				String criticalHighSymbolIcon = null;
				String criticalLowSymbolIcon = null;
				while(rs.next()){
					highSymbolIcon = rs.getString("HIGH_SYMBOL_ICON");
					lowSymbolIcon = rs.getString("LOW_SYMBOL_ICON");
					abnormalSymbolIcon = rs.getString("ABN_SYMBOL_ICON");
					criticalSymbolIcon = rs.getString("CRIT_SYMBOL_ICON");
					criticalHighSymbolIcon = rs.getString("CRIT_HIGH_SYMBOL_ICON");
					criticalLowSymbolIcon = rs.getString("CRIT_LOW_SYMBOL_ICON");
				}
				iconResponse.setHighSymbolIcon(highSymbolIcon);
				iconResponse.setAbnormalSymbolIcon(abnormalSymbolIcon);
				iconResponse.setCriticalHighSymbolIcon(criticalHighSymbolIcon);
				iconResponse.setCriticalLowSymbolIcon(criticalLowSymbolIcon);
				iconResponse.setCriticalSymbolIcon(criticalSymbolIcon);
				iconResponse.setLowSymbolIcon(lowSymbolIcon);
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this properly
			 */
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			
			if(prepStmt != null){
				try {
					prepStmt.close();
				} catch (SQLException e) {
				}
			}
			
			ConnectionManager.returnConnection(conn, servletRequest);
		}
		
		
		return iconResponse;
	}
	
}
