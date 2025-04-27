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
package eAlert.src.alertobserver;

import isoft.em.AlertLibrary.IAlertObserver;
import isoft.em.AlertLibrary.ProcessedAlertData;
import isoft.em.DBFactory.DBConnectionHelper;
import isoft.em.common.db.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import eAlert.src.alert.common.AlertBaseResponse;
import eAlert.src.alert.common.AlertErrorInfo;
import eAlert.src.databeans.AlertMaster;
import eAlert.src.databeans.AlertRecipient;
import eAlert.src.dataccess.AlertConfigContainer;

/**
 * @author PrasannaR
 *
 */
public class PublishAlert implements IAlertObserver {

	/**
	 * 
	 */
	public void updateData(ProcessedAlertData arg0) {
		
		/*String strQuery = "";*/
		
		String alertCode = "";
		long processedId = 0;
		String patientId = "";
		
		long alertMasterSeqId = 0;
		String alertTitle = "";
		String alertRecipientType = "";
		
		/*PreparedStatement prepStmt = null;
		ResultSet rs = null;*/
		
		List<AlertMaster> alertMasterList = null;
		List<AlertRecipient> alertRecipientList = null;
		
		/**
		 * TODO Include the patient id to be part of this. Patient name to be fetched and stored in patient alerts
		 */
		alertCode = arg0.getAlertCode();
		processedId = arg0.getProcessedAlertID();
		patientId = arg0.getPatientId();
		
		//Connection conn = ConnectionHelper.getConnection();
		Connection conn = DBConnectionHelper.getConnection();
		//strQuery = "SELECT Alert_Master_Seq_ID, Alert_Title, Alert_Recipient_Type FROM UA_ALERT_MASTER WHERE Alert_Code = ?";
		
		try {
			/*prepStmt = conn.prepareStatement(strQuery);
			prepStmt.setString(1, alertCode);
			rs = prepStmt.executeQuery();
			
			while(rs.next())
			{
				alertMasterSeqId = rs.getLong("Alert_Master_Seq_ID");
				alertTitle = rs.getString("Alert_Title");
				alertRecipientType = rs.getString("Alert_Recipient_Type");
			}*/
			
			AlertConfigContainer alertContainter = AlertConfigContainer.getInstance();
			alertMasterList = alertContainter.getAlertConfig();
			
			for(AlertMaster alertMaster : alertMasterList){
				if(alertMaster.getAlertCode().equalsIgnoreCase(alertCode)){
					alertMasterSeqId = alertMaster.getAlertID();
					alertTitle = alertMaster.getAlertTitle();
					alertRecipientType = alertMaster.getAlertRecipientType();
					alertRecipientList = alertMaster.getRecipientList();
					break;
				}
			}
			
			/**
			 * TODO - select records from patient subscribed users. If still recipient details is null, do not generate alerts.
			 */
			insertPatientAlerts(conn, alertCode, processedId, alertMasterSeqId, alertTitle, patientId, alertRecipientType, alertRecipientList);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			//ConnectionHelper.closeResources(conn);
			DBConnectionHelper.returnConnection(conn);
		}
	}
	
	private void insertPatientAlerts(Connection conn, String alertCode, long processedId, long alertMasterSeqId, String alertTitle, String patientId, String alertRecipientType, List<AlertRecipient> alertRecipientList) throws SQLException
	{
		AlertBaseResponse response = new AlertBaseResponse();
		
		PreparedStatement prepSelect = null;
		ResultSet rs = null;
		long patAlertId = 0;
		
		String strInsQuery = "";
		strInsQuery = "INSERT INTO UA_PATIENT_ALERT (User_Alert_Seq_ID, Patient_ID, Alert_Code, Alert_Title, Alert_Master_Seq_ID, Alert_Recorded_Date) VALUES";
		strInsQuery += " (?, ?, ?, ?, ?, sysdate)";
		
		conn.setAutoCommit(false);
		PreparedStatement prepStmt = conn.prepareStatement(strInsQuery);
		prepStmt.setLong(1, processedId);
		prepStmt.setString(2, patientId);
		prepStmt.setString(3, alertCode);
		prepStmt.setString(4, alertTitle);
		prepStmt.setLong(5, alertMasterSeqId);
		
		prepStmt.executeUpdate();
		
		prepSelect = conn.prepareStatement("Select PatAlert_SeqID.currval from dual");
		rs = prepSelect.executeQuery();
		
		if(rs.next())
		{
			patAlertId = rs.getLong(1);
		}
		
		if(patAlertId > 0)
		{
			/*List<AlertRecipient> recipientList = null;
			PreparedStatement prepRecepSelect = null;
			ResultSet rsRecep = null;
			
			String strSelect = "";*/
			/*Changes for Contextual user begins*/
			/*if(alertRecipientType.equalsIgnoreCase("Contextual")){
				*//**
				 * TODO design and implement contextual user. Hardcoded now for demo.
				 *//*
				strSelect = "SELECT DISTINCT Alert_Recipient_Seq_ID, (SELECT ATTEND_PRACTITIONER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID = ?) AS Recipient_User_ID \r\n"; 
				strSelect += "FROM UA_ALERT_RECIPIENT \r\n";
				strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
				strSelect += "ON UA_ALERT_MASTER.ALERT_CODE = UA_ALERT_RECIPIENT.ALERT_CODE \r\n";
				strSelect += "INNER JOIN UA_USER_ALERT \r\n";
				strSelect += "ON UA_USER_ALERT.ALERT_CODE = UA_ALERT_RECIPIENT.ALERT_CODE \r\n";
				strSelect += "AND UA_USER_ALERT.PATIENT_ID = ? \r\n";
				strSelect += "WHERE UA_ALERT_RECIPIENT.Alert_Code = ? ";
				
				prepRecepSelect = conn.prepareStatement(strSelect);
				prepRecepSelect.setString(1, patientId);
				prepRecepSelect.setString(2, patientId);
				prepRecepSelect.setString(3, alertCode);
				rsRecep = prepRecepSelect.executeQuery();
				
				//strSelect = "SELECT Alert_Recipient_Seq_ID, Recipient_Role FROM UA_ALERT_RECIPIENT WHERE Alert_Code = ?";
			}*/
			/*if(alertRecipientType.equalsIgnoreCase("Users"))
			{
			Changes for Contextual user ends
				strSelect = "SELECT Alert_Recipient_Seq_ID, Recipient_User_ID FROM UA_ALERT_RECIPIENT WHERE Alert_Code = ?";
				
				prepRecepSelect = conn.prepareStatement(strSelect);
				prepRecepSelect.setString(1, alertCode);
				rsRecep = prepRecepSelect.executeQuery();
			}*/
			
			/*recipientList = getReceipentList(rsRecep);
			
			response = addRecipientDetails(conn, patAlertId, recipientList);*/
			if(alertRecipientList != null){
				response = addRecipientDetails(conn, patAlertId, alertRecipientList);
			
				if(response.getErrorInfo().getErrorCode() == AlertErrorInfo.SUCCESS_CODE){
					conn.commit();
				}
			}
			else{
				AlertErrorInfo errorInfo = new AlertErrorInfo();
				errorInfo.setErrorCode(AlertErrorInfo.SUCCESS_CODE);
				response.setErrorInfo(errorInfo);
				conn.commit();
			}
		}
	}
	
	/*private List<AlertRecipient> getReceipentList(ResultSet rsRecep) throws SQLException
	{
		List<AlertRecipient> recipientList = new ArrayList<AlertRecipient>();
		AlertRecipient recipient = null;
		
		long recipientID = 0;
		String userID = "";
		
		while(rsRecep.next())
		{
			recipientID = rsRecep.getLong("Alert_Recipient_Seq_ID");
			userID = rsRecep.getString("Recipient_User_ID");
			
			recipient = new AlertRecipient();
			recipient.setRecipientID(recipientID);
			recipient.setUserID(userID);
			
			recipientList.add(recipient);
		}
		
		return recipientList;
	}*/
	
	private AlertBaseResponse addRecipientDetails(Connection conn, long patAlertId, List<AlertRecipient> recipientList) throws SQLException
	{
		AlertBaseResponse response = new AlertBaseResponse();
		
		PreparedStatement prepSelect = null;
		PreparedStatement prepStmt = null;
		long patRecpSeqId = 0;
		
		long alertRecpSeqID = 0;
		String recipUserID = "";
		
		for(AlertRecipient recipient : recipientList)
		{
			alertRecpSeqID = recipient.getRecipientID();
			recipUserID = recipient.getUserID();
			
			String strInsQuery = "";
			strInsQuery = "INSERT INTO UA_PAT_RECIPIENT_DETAILS (Patient_Alert_Seq_ID, Alert_Recipient_Seq_ID, Recipient_User_ID, Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Archived_YN, Received_From_User_ID, Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Notification_Status, Comments, Modified_Date, Alert_Ack) VALUES";
			strInsQuery += " (?, ?, ?, 'N', 'N', 'N', 'N', 'N', null, null, 0, null, 'N', null, sysdate, 'N')";
			
			conn.setAutoCommit(false);
			prepStmt = conn.prepareStatement(strInsQuery);
			prepStmt.setLong(1, patAlertId);
			prepStmt.setLong(2, alertRecpSeqID);
			prepStmt.setString(3, recipUserID);
			
			prepStmt.executeUpdate();
			
			prepSelect = conn.prepareStatement("Select PatRecipDetails_SeqID.currval from dual");
			ResultSet rs = prepSelect.executeQuery();
			if(rs.next())
			{
				patRecpSeqId = rs.getLong(1);
			}
			
			if(patRecpSeqId > 0)
			{
				AlertErrorInfo errorInfo = new AlertErrorInfo();
				errorInfo.setErrorCode(AlertErrorInfo.SUCCESS_CODE);
				response.setErrorInfo(errorInfo);
			}
		}
		
		return response;
	}
}
