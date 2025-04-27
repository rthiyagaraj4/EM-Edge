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
package eAlert.src.dataccess;

import isoft.em.DBFactory.DBConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eAlert.src.databeans.AlertFlagOptions;
import eAlert.src.db.ConnectionHelper;

/**
 * @author prasannar
 *
 */
public class AlertFlagOptionRetriever {
	
	public List<AlertFlagOptions> getAlertFlagOptions(){
		
		List<AlertFlagOptions> alertFlagOptionList = null;
		
		String strQuery = "";
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection conn = DBConnectionHelper.getConnection();
		strQuery = "SELECT Timer_code, Timer_Description FROM UA_ALERT_TIMEINTERVAL_LOOKUP WHERE Status = 'A'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strQuery);
			alertFlagOptionList = populateAlertFlagOptions(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			DBConnectionHelper.returnConnection(conn);
		}
		
		return alertFlagOptionList;
	}
	
	private List<AlertFlagOptions> populateAlertFlagOptions(ResultSet rs) throws SQLException{
		
		List<AlertFlagOptions> alertFlagOptionList = new ArrayList<AlertFlagOptions>();
		
		String timerCode = "";
		String timerDesc = "";
		
		AlertFlagOptions flagOptions = null;
		
		if(rs != null){
			while(rs.next()){
				timerCode = rs.getString("Timer_code");
				timerDesc = rs.getString("Timer_Description");
				
				flagOptions = new AlertFlagOptions();
				flagOptions.setTimeIntervalCode(timerCode);
				flagOptions.setTimeIntervalDesc(timerDesc);
				
				alertFlagOptionList.add(flagOptions);
			}
		}
		
		return alertFlagOptionList;
	}
}
