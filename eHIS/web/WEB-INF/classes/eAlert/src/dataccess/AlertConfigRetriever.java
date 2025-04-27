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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eAlert.src.databeans.AlertMaster;
import eAlert.src.databeans.AlertRecipient;
import eAlert.src.db.ConnectionHelper;

/**
 * @author PrasannaR
 *
 */
public class AlertConfigRetriever {

	/**
	 * 
	 * @return
	 */
	public List<AlertMaster> getAlertMasterConfig()
	{
		List<AlertMaster> alertMasterList = null;
		
		String strQuery = "";
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection conn = DBConnectionHelper.getConnection();
		strQuery = "SELECT ALERT_MASTER_SEQ_ID, Alert_Code, Alert_Title, Alert_Description, Alert_Priority, Alert_Recipient_Type FROM UA_ALERT_MASTER WHERE Status = 'A'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strQuery);
			alertMasterList = populateAlertConfig(conn, rs);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//ConnectionHelper.closeResources(conn);
			DBConnectionHelper.returnConnection(conn);
		}
		
		return alertMasterList;
	}
	
	private List<AlertMaster> populateAlertConfig(Connection conn, ResultSet rs) throws SQLException
	{
		List<AlertMaster> alertMasterList = new ArrayList<AlertMaster>();
		
		long alertID = 0;
		String alertCode = "";
		String alertTitle = "";
		String alertDesc = "";
		int alertPriority = 0;
		String alertRecType = "";
		
		AlertMaster alertMaster = null;
		
		while(rs.next())
		{
			alertID = rs.getLong("ALERT_MASTER_SEQ_ID");
			alertCode = rs.getString("Alert_Code");
			alertTitle = rs.getString("Alert_Title");
			alertDesc = rs.getString("Alert_Description");;
			alertPriority = rs.getInt("Alert_Priority");
			alertRecType = rs.getString("Alert_Recipient_Type");
			
			alertMaster = new AlertMaster();
			alertMaster.setAlertID(alertID);
			alertMaster.setAlertCode(alertCode);
			alertMaster.setAlertTitle(alertTitle);
			alertMaster.setAlertDescription(alertDesc);
			alertMaster.setAlertPriority(alertPriority);
			alertMaster.setAlertRecipientType(alertRecType);
			
			List<AlertRecipient> recipientList = null;
			if(alertRecType.equalsIgnoreCase("USERS")){
				recipientList = getAlertRecipients(conn, alertID);
				alertMaster.setRecipientList(recipientList);
			}
			
			alertMasterList.add(alertMaster);
		}
		
		return alertMasterList;
	}
	
	private List<AlertRecipient> getAlertRecipients(Connection conn, long alertID)
	{
		List<AlertRecipient> recipientList = null;
		
		String strQuery = "SELECT Alert_Recipient_Seq_ID, ALERT_MASTER_SEQ_ID, Alert_Code, Recipient_User_ID FROM UA_ALERT_RECIPIENT WHERE ALERT_MASTER_SEQ_ID = ? AND STATUS = 'A'";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try {
			prepStmt = conn.prepareStatement(strQuery);
			prepStmt.setLong(1, alertID);
			rs = prepStmt.executeQuery();
			
			if(rs == null){
				return recipientList;
			}
			recipientList = populateAlertRecipients(rs);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return recipientList;
	}
	
	private List<AlertRecipient> populateAlertRecipients(ResultSet rs) throws SQLException
	{
		List<AlertRecipient> recipientList = new ArrayList<AlertRecipient>();
		
		AlertRecipient recipient = null;
		
		long recipientID = 0;
		String recipientUserID = "";
		//String recipientRole = "";
		
		while(rs.next())
		{
			recipientID = rs.getLong("Alert_Recipient_Seq_ID");
			recipientUserID = rs.getString("Recipient_User_ID");
			//recipientRole = rs.getString("Recipient_Role");
			
			recipient = new AlertRecipient();
			recipient.setRecipientID(recipientID);
			recipient.setUserID(recipientUserID);
			//recipient.setRecipientRole(recipientRole);
			
			recipientList.add(recipient);
		}
		
		return recipientList;
	}
}
