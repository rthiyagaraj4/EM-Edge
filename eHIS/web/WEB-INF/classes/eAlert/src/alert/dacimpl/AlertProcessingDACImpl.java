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
package eAlert.src.alert.dacimpl;

import isoft.em.DBFactory.DBConnectionHelper;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import DataAccess.DBConnection;
import alertoutput.AlertOutputData;
import eAlert.src.alert.common.AlertBaseResponse;
import eAlert.src.alert.common.AlertErrorInfo;
import eAlert.src.alert.dac.AlertProcessingDAC;
import eAlert.src.alert.request.AlertDetailsRequest;
import eAlert.src.alert.request.AlertFlagManageRequest;
import eAlert.src.alert.request.AlertForwardUserRequest;
import eAlert.src.alert.request.AlertFwdManageRequest;
import eAlert.src.alert.request.AlertRequest;
import eAlert.src.alert.request.AlertReviewMangRequest;
import eAlert.src.alert.request.AlertsByFilterRequest;
import eAlert.src.alert.request.AlertsByGroupRequest;
import eAlert.src.alert.request.BaseRequest;
import eAlert.src.alert.response.AlertCountResponse;
import eAlert.src.alert.response.AlertDetailsResponse;
import eAlert.src.alert.response.AlertFlagOptionResponse;
import eAlert.src.alert.response.AlertForwardUserResponse;
import eAlert.src.alert.response.AlertUserResponse;
import eAlert.src.alert.response.AlertsByFilterResponse;
import eAlert.src.alert.response.AlertsByGroup;
import eAlert.src.alert.response.AlertsByGroupResponse;
import eAlert.src.alert.response.AlertsByUser;
import eAlert.src.config.AlertConstants;
import eAlert.src.databeans.AlertFlagOptions;
import eAlert.src.databeans.AlertForwardUsers;
import eAlert.src.dataccess.AlertFlagOptionContainer;

/**
 * @author prasannar
 * 
 */
public class AlertProcessingDACImpl implements AlertProcessingDAC {

	private String groupByCode = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see alert.dac.AlertProcessingDAC#getAlertsByUser(alert.request.
	 * AlertsByUserRequest)
	 */
	public AlertUserResponse getAlertsByUser(BaseRequest request) {

		AlertUserResponse response = null;

		String strSelect = "";
		String userId = "";

		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		userId = request.getUserId();

		Connection conn = DBConnectionHelper.getConnection();
		strSelect = "SELECT PATALERT.Patient_Alert_Seq_Id, RECDET.PAT_RECIP_SEQ_ID, PATALERT.Alert_Title, Patient_ID, (SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID = PATALERT.PATIENT_ID) AS Patient_Name, \r\n";
		strSelect += "Alert_Recorded_Date, Recipient_User_ID, Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Received_From_User_ID, Archived_YN, \r\n";
		strSelect += "Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Modified_Date, Alert_Ack, Alert_Priority \r\n";
		strSelect += "FROM UA_PATIENT_ALERT PATALERT \r\n";
		strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
		strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
		strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
		strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
		strSelect += "WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
		strSelect += "AND Archived_YN = 'N' \r\n";
		strSelect += "ORDER BY Alert_Recorded_Date DESC \r\n";

		try {
			prepStmt = conn.prepareStatement(strSelect);
			prepStmt.setString(1, userId);
			rs = prepStmt.executeQuery();

			response = populateAlertsForUser(conn, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//DBConnection.returnConnection(conn);
			DBConnectionHelper.returnConnection(conn);
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see alert.dac.AlertProcessingDAC#getAlertsByGroup(alert.request.
	 * AlertsByGroupRequest)
	 */
	public AlertsByGroupResponse getAlertsByGroup(AlertsByGroupRequest request) {

		AlertsByGroupResponse response = null;

		String strSelect = "";
		String userId = "";
		String groupText = "";
		String filtered = "";

		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		userId = request.getUserId();
		groupByCode = request.getGroupBy();
		groupText = request.getGroupText();
		filtered = request.getFiltered();

		Connection conn = DBConnectionHelper.getConnection();
		if (groupByCode.equalsIgnoreCase("PATNAME")) {
			strSelect = "";
			strSelect = "SELECT PATALERT.Patient_Alert_Seq_Id, RECDET.PAT_RECIP_SEQ_ID, PATALERT.Alert_Title, PATALERT.Patient_ID, (SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID = PATALERT.PATIENT_ID) AS Patient_Name, \r\n";
			strSelect += "Alert_Recorded_Date, Recipient_User_ID, Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Received_From_User_ID, Archived_YN, \r\n";
			strSelect += "Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Modified_Date, Alert_Ack, Alert_Priority  \r\n";
			strSelect += "FROM  \r\n";
			strSelect += "(SELECT PATIENT_ID FROM UA_PATIENT_ALERT PATALERT \r\n";
			strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
			strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			strSelect += "WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
			strSelect += "GROUP BY PATIENT_ID) A \r\n";
			strSelect += "INNER JOIN UA_PATIENT_ALERT PATALERT  \r\n";
			strSelect += "ON A.PATIENT_ID = PATALERT.PATIENT_ID  \r\n";
			strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET  \r\n";
			strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID  \r\n";
			strSelect += "AND RECDET.RECIPIENT_USER_ID = ? \r\n";
			strSelect += "INNER JOIN UA_ALERT_MASTER  \r\n";
			strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			if (filtered.equalsIgnoreCase("Y")) {
				strSelect += "WHERE Flagged_YN = 'Y'";
				strSelect += "AND Archived_YN = 'N' \r\n";
			} else
				strSelect += "WHERE Archived_YN = 'N' \r\n";
			strSelect += "ORDER BY PATALERT.Patient_ID, Alert_Recorded_Date DESC \r\n";
		}

		if (groupByCode.equalsIgnoreCase("ALERTNAME")) {
			strSelect = "";
			strSelect = "SELECT PATALERT.ALERT_MASTER_SEQ_ID, RECDET.PAT_RECIP_SEQ_ID, PATALERT.Patient_Alert_Seq_Id, PATALERT.Alert_Title, PATALERT.Patient_ID, (SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID = PATALERT.PATIENT_ID) AS Patient_Name, \r\n";
			strSelect += "Alert_Recorded_Date, Recipient_User_ID, Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Received_From_User_ID, Archived_YN, \r\n";
			strSelect += "Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Modified_Date, Alert_Ack, Alert_Priority  \r\n";
			strSelect += "FROM  \r\n";
			strSelect += "(SELECT PATALERT.ALERT_TITLE, PATALERT.ALERT_MASTER_SEQ_ID FROM UA_PATIENT_ALERT PATALERT \r\n";
			strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
			strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			strSelect += "WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
			strSelect += "GROUP BY PATALERT.ALERT_TITLE, PATALERT.ALERT_MASTER_SEQ_ID) A \r\n";
			strSelect += "INNER JOIN UA_PATIENT_ALERT PATALERT  \r\n";
			strSelect += "ON A.ALERT_MASTER_SEQ_ID = PATALERT.ALERT_MASTER_SEQ_ID  \r\n";
			strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET  \r\n";
			strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID  \r\n";
			strSelect += "AND RECDET.RECIPIENT_USER_ID = ? \r\n";
			strSelect += "INNER JOIN UA_ALERT_MASTER  \r\n";
			strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			if (filtered.equalsIgnoreCase("Y")) {
				strSelect += "WHERE Flagged_YN = 'Y' \r\n";
				strSelect += "AND Archived_YN = 'N' \r\n";
			} else
				strSelect += "WHERE Archived_YN = 'N' \r\n";
			strSelect += "ORDER BY PATALERT.Alert_Title, PATALERT.Alert_Recorded_Date DESC \r\n";
		}

		if (groupByCode.equalsIgnoreCase("DATE")) {
			strSelect = "";
			strSelect = "SELECT PATALERT.Patient_Alert_Seq_Id, RECDET.PAT_RECIP_SEQ_ID, PATALERT.Alert_Title, PATALERT.Patient_ID, (SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID = PATALERT.PATIENT_ID) AS Patient_Name, \r\n";
			strSelect += "PATALERT.Alert_Recorded_Date, Recipient_User_ID, Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Received_From_User_ID, Archived_YN, \r\n";
			strSelect += "Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Modified_Date, Alert_Ack, Alert_Priority \r\n";
			strSelect += "FROM \r\n";
			strSelect += "	(SELECT Alert_Recorded_Date, PATALERT.Patient_Alert_Seq_Id FROM UA_PATIENT_ALERT PATALERT \r\n";
			strSelect += "	INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strSelect += "	ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strSelect += "	INNER JOIN UA_ALERT_MASTER \r\n";
			strSelect += "	ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			strSelect += "	WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
			strSelect += "	GROUP BY Alert_Recorded_Date, PATALERT.Patient_Alert_Seq_Id \r\n";
			strSelect += "	ORDER BY PATALERT.Alert_Recorded_Date DESC) A \r\n";
			strSelect += "INNER JOIN UA_PATIENT_ALERT PATALERT \r\n";
			strSelect += "ON A.Patient_Alert_Seq_Id = PATALERT.Patient_Alert_Seq_Id \r\n";
			strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
			strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			if (filtered.equalsIgnoreCase("Y")) {
				strSelect += "WHERE Flagged_YN = 'Y' \r\n";
				strSelect += "AND Archived_YN = 'N' \r\n";
			} else
				strSelect += "WHERE Archived_YN = 'N' \r\n";
			strSelect += "ORDER BY PATALERT.Alert_Recorded_Date DESC \r\n";
		}

		if (groupByCode.equalsIgnoreCase("FWDRE")) {
			strSelect = "";
			strSelect = "SELECT Patient_Alert_Seq_Id, PAT_RECIP_SEQ_ID, Alert_Title, Patient_ID, Patient_Name, \r\n";
			strSelect += "Alert_Recorded_Date, Recipient_User_ID, Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Received_From_User_ID, Archived_YN, \r\n";
			strSelect += "Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Modified_Date, Alert_Ack, Alert_Priority \r\n";
			strSelect += "FROM \r\n";
			strSelect += "	(SELECT PATALERT.Patient_Alert_Seq_Id, RECDET.PAT_RECIP_SEQ_ID, PATALERT.Alert_Title, PATALERT.Patient_ID, (SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID = PATALERT.PATIENT_ID) AS Patient_Name, \r\n";
			strSelect += "	Alert_Recorded_Date, Recipient_User_ID, Flagged_YN, Reviewed_YN, RECDET.Forwarded_YN, RECDET.Recieved_YN, Received_From_User_ID, Archived_YN, \r\n";
			strSelect += "	Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Modified_Date, Alert_Ack, Alert_Priority \r\n";
			strSelect += "	FROM \r\n";
			strSelect += "	(SELECT Forwarded_YN, PATALERT.Patient_Alert_Seq_Id FROM UA_PATIENT_ALERT PATALERT \r\n";
			strSelect += "	INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strSelect += "	ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strSelect += "	INNER JOIN UA_ALERT_MASTER \r\n";
			strSelect += "	ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			strSelect += "	WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
			strSelect += "	GROUP BY Forwarded_YN, PATALERT.Patient_Alert_Seq_Id) A \r\n";
			strSelect += "INNER JOIN UA_PATIENT_ALERT PATALERT \r\n";
			strSelect += "ON A.Patient_Alert_Seq_Id = PATALERT.Patient_Alert_Seq_Id \r\n";
			strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
			strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			if (filtered.equalsIgnoreCase("Y")) {
				strSelect += "WHERE Flagged_YN = 'Y' \r\n";
				strSelect += "AND Archived_YN = 'N' \r\n";
			} else
				strSelect += "WHERE Archived_YN = 'N' \r\n";
			strSelect += "UNION \r\n";
			strSelect += "SELECT PATALERT.Patient_Alert_Seq_Id, RECDET.PAT_RECIP_SEQ_ID, PATALERT.Alert_Title, PATALERT.Patient_ID, (SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID = PATALERT.PATIENT_ID) AS Patient_Name, \r\n";
			strSelect += "Alert_Recorded_Date, Recipient_User_ID, Flagged_YN, Reviewed_YN, RECDET.Forwarded_YN, RECDET.Recieved_YN, Received_From_User_ID, Archived_YN, \r\n";
			strSelect += "Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Modified_Date, Alert_Ack, Alert_Priority \r\n";
			strSelect += "FROM \r\n";
			strSelect += "	(SELECT Recieved_YN, PATALERT.Patient_Alert_Seq_Id FROM UA_PATIENT_ALERT PATALERT \r\n";
			strSelect += "	INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strSelect += "	ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strSelect += "	INNER JOIN UA_ALERT_MASTER \r\n";
			strSelect += "	ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			strSelect += "	WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
			strSelect += "	GROUP BY Recieved_YN, PATALERT.Patient_Alert_Seq_Id) B \r\n";
			strSelect += "INNER JOIN UA_PATIENT_ALERT PATALERT \r\n";
			strSelect += "ON B.Patient_Alert_Seq_Id = PATALERT.Patient_Alert_Seq_Id \r\n";
			strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
			if (filtered.equalsIgnoreCase("Y")) {
				strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
				strSelect += "WHERE Flagged_YN = 'Y' \r\n";
				strSelect += "AND Archived_YN = 'N') \r\n";
			} else {
				strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
				strSelect += "WHERE Archived_YN = 'N') \r\n";
			}
			strSelect += "ORDER BY DECODE(Forwarded_YN, 'Y', '2', Recieved_YN, 'Y', '1'), Alert_Recorded_Date DESC";
		}

		try {
			prepStmt = conn.prepareStatement(strSelect);

			prepStmt.setString(1, userId);
			if (!groupByCode.equalsIgnoreCase("DATE"))
				prepStmt.setString(2, userId);
			rs = prepStmt.executeQuery();

			response = populateAlertsGroupBy(conn, rs, groupText, filtered);

			if (filtered.equalsIgnoreCase("Y")) {
				String strCountSelect = "";
				if (rs != null)
					rs.close();
				if (prepStmt != null)
					prepStmt.close();

				int totalCount = 0;
				strCountSelect = "SELECT COUNT('X') AS TotalCount \r\n";
				strCountSelect += "FROM UA_PATIENT_ALERT PATALERT \r\n";
				strCountSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
				strCountSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
				strCountSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
				strCountSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
				strCountSelect += "WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
				strCountSelect += "AND Archived_YN = 'N' \r\n";

				prepStmt = conn.prepareStatement(strCountSelect);
				prepStmt.setString(1, userId);
				rs = prepStmt.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						totalCount = rs.getInt("TotalCount");
					}

					AlertCountResponse countResponse = new AlertCountResponse();
					countResponse.setAlertCount(totalCount);
					response.setCountResponse(countResponse);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//DBConnection.returnConnection(conn);
			DBConnectionHelper.returnConnection(conn);
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see alert.dac.AlertProcessingDAC#getAlertsByFilter(alert.request.
	 * AlertsByFilterRequest)
	 */
	public AlertsByFilterResponse getAlertsByFilter(
			AlertsByFilterRequest request) {

		AlertsByFilterResponse response = null;

		String strSelect = "";
		String strCountSelect = "";
		String userId = "";
		String filtered = "";

		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		userId = request.getUserId();
		filtered = request.getFiltered();

		Connection conn = DBConnectionHelper.getConnection();
		strSelect = "SELECT PATALERT.Patient_Alert_Seq_Id, RECDET.PAT_RECIP_SEQ_ID, PATALERT.Alert_Title, Patient_ID, (SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID = PATALERT.PATIENT_ID) AS Patient_Name, \r\n";
		strSelect += "Alert_Recorded_Date, Recipient_User_ID, Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Received_From_User_ID, Archived_YN, \r\n";
		strSelect += "Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Modified_Date, Alert_Ack, Alert_Priority \r\n";
		strSelect += "FROM UA_PATIENT_ALERT PATALERT \r\n";
		strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
		strSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
		strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
		strSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
		strSelect += "WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
		strSelect += "AND RECDET.Flagged_YN = 'Y' \r\n";
		strSelect += "AND Archived_YN = 'N' \r\n";
		strSelect += "ORDER BY Alert_Recorded_Date DESC \r\n";

		try {
			prepStmt = conn.prepareStatement(strSelect);
			prepStmt.setString(1, userId);
			rs = prepStmt.executeQuery();

			response = populateFilteredAlerts(conn, rs);

			if (rs != null)
				rs.close();
			if (prepStmt != null)
				prepStmt.close();

			int totalCount = 0;
			strCountSelect = "SELECT COUNT('X') AS TotalCount \r\n";
			strCountSelect += "FROM UA_PATIENT_ALERT PATALERT \r\n";
			strCountSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n";
			strCountSelect += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n";
			strCountSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
			strCountSelect += "ON PATALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
			strCountSelect += "WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
			strCountSelect += "AND Archived_YN = 'N' \r\n";

			prepStmt = conn.prepareStatement(strCountSelect);
			prepStmt.setString(1, userId);
			rs = prepStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					totalCount = rs.getInt("TotalCount");
				}

				AlertCountResponse countResponse = new AlertCountResponse();
				countResponse.setAlertCount(totalCount);
				response.setCountResponse(countResponse);
				response.setFiltered(filtered);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//DBConnection.returnConnection(conn);
			DBConnectionHelper.returnConnection(conn);
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see alert.dac.AlertProcessingDAC#getAlertDetails(alert.request.
	 * AlertDetailsRequest)
	 */
	public AlertDetailsResponse getAlertDetails(AlertDetailsRequest request) {
		AlertDetailsResponse response = null;

		String strSelect = "";
		String strUpdate = "";
		long alertId = 0;
		String userId = "";

		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		alertId = request.getAlertId();
		userId = request.getUserId();

		Connection conn = DBConnectionHelper.getConnection();
		strSelect = "SELECT UA_PATIENT_ALERT.Patient_Alert_Seq_Id, Pat_Recip_Seq_Id, UA_PATIENT_ALERT.Patient_ID, (SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID = UA_PATIENT_ALERT.PATIENT_ID) AS Patient_Name, \r\n";
		strSelect += "Alert_Description, UA_PATIENT_ALERT.Alert_Title, RuleTransData, Alert_Recorded_Date, Alert_Priority, Alert_Ack, \r\n";
		strSelect += "Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Modified_Date, Received_From_User_ID, Comments \r\n";
		strSelect += "FROM UA_PATIENT_ALERT \r\n";
		strSelect += "INNER JOIN UA_ALERT_MASTER \r\n";
		strSelect += "ON UA_PATIENT_ALERT.ALERT_MASTER_SEQ_ID = UA_ALERT_MASTER.ALERT_MASTER_SEQ_ID \r\n";
		strSelect += "INNER JOIN UA_USER_ALERT \r\n";
		strSelect += "ON UA_PATIENT_ALERT.USER_ALERT_SEQ_ID = UA_USER_ALERT.USER_ALERT_SEQ_ID \r\n";
		strSelect += "AND UA_PATIENT_ALERT.ALERT_CODE = UA_USER_ALERT.ALERT_CODE \r\n";
		strSelect += "INNER JOIN UA_PAT_RECIPIENT_DETAILS \r\n";
		strSelect += "ON UA_PATIENT_ALERT.Patient_Alert_Seq_Id = UA_PAT_RECIPIENT_DETAILS.Patient_Alert_Seq_Id \r\n";
		strSelect += "WHERE UA_PATIENT_ALERT.PATIENT_ALERT_SEQ_ID = ? \r\n";
		strSelect += "AND UA_PAT_RECIPIENT_DETAILS.RECIPIENT_USER_ID = ? \r\n";
		strSelect += "AND Archived_YN = 'N' \r\n";

		try {
			prepStmt = conn.prepareStatement(strSelect);
			prepStmt.setLong(1, alertId);
			prepStmt.setString(2, userId);
			rs = prepStmt.executeQuery();

			response = populateAlertDetails(conn, rs);

			if (rs != null) {
				rs.close();
			}
			if (prepStmt != null) {
				prepStmt.close();
			}

			if (response.getAlertAck().equalsIgnoreCase("N")) {
				strUpdate = "UPDATE UA_PAT_RECIPIENT_DETAILS SET ALERT_ACK = 'Y' WHERE PATIENT_ALERT_SEQ_ID = ? AND RECIPIENT_USER_ID = ? AND ALERT_ACK = 'N'";
				prepStmt = conn.prepareStatement(strUpdate);

				prepStmt.setLong(1, alertId);
				prepStmt.setString(2, userId);

				prepStmt.executeUpdate();

				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//DBConnection.returnConnection(conn);
			DBConnectionHelper.returnConnection(conn);
		}

		return response;
	}

	private AlertUserResponse populateAlertsForUser(Connection conn, ResultSet rs)
			throws SQLException {
		AlertUserResponse response = new AlertUserResponse();
		List<AlertsByUser> userAlertList = new ArrayList<AlertsByUser>();
		AlertCountResponse countResponse = new AlertCountResponse();

		AlertsByUser userAlert = null;

		long patientAlertSeqId = 0;
		long patientRecipientSeqId = 0;
		String alertName = "";
		String patientId = "";
		String patientName = "";
		String location = "";
		String standardText = "";
		String dateTimeDisplay = "";
		//Date alertRecordedDate = null;
		Timestamp alertRecordedDate = null;
		String flagged = "";
		String reviewed = "";
		String forwarded = "";
		String alertAck = "";
		String alertPriority = "";
		/**
		 * TODO implement for forwarded to user Id
		 */
		String forwardedUserId = "";
		String received = "";
		String recFromUser = "";
		String archived = "";
		//Date intStartTime = null;
		Timestamp intStartTime = null;
		int reminderInterval = 0;
		String reminderIntUnit = "";
		String modifiedDate = null;
		
		Timestamp timeStamp = null;

		if (rs != null) {

			while (rs.next()) {

				patientAlertSeqId = rs.getLong("Patient_Alert_Seq_Id");
				patientRecipientSeqId = rs.getLong("PAT_RECIP_SEQ_ID");
				alertName = rs.getString("Alert_Title");
				patientId = rs.getString("Patient_ID");
				patientName = rs.getString("Patient_Name");
				alertRecordedDate = rs.getTimestamp("Alert_Recorded_Date");
				flagged = rs.getString("Flagged_YN");
				reviewed = rs.getString("Reviewed_YN");
				forwarded = rs.getString("Forwarded_YN");
				received = rs.getString("Recieved_YN");
				recFromUser = rs.getString("Received_From_User_ID");
				archived = rs.getString("Archived_YN");
				//intStartTime = rs.getDate("Interval_Start_Time");
				intStartTime = rs.getTimestamp("Interval_Start_Time");
				reminderInterval = rs.getInt("Reminder_Interval");
				reminderIntUnit = rs.getString("Reminder_Interval_Unit");
				//modifiedDate = rs.getDate("Modified_Date");
				timeStamp = rs.getTimestamp("Modified_Date");
				if (timeStamp != null) {
					SimpleDateFormat format = new SimpleDateFormat(
							"dd-MM-yyyy HH:mm");
					// modifiedDate = new Date(timeStamp.getTime());
					try {
						modifiedDate = format.format(timeStamp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				alertAck = rs.getString("Alert_Ack");
				alertPriority = rs.getString("Alert_Priority");

				/*
				 * if(reviewed == "Y") { standardText =
				 * AlertConstants.REVIEWED_TEXT + " " + modifiedDate; }
				 * if(forwarded == "Y") { //TODO fetch the forwarded details to
				 * display } if(flagged == "Y") { if(reminderInterval > 0){
				 * standardText = AlertConstants.FLAGGED_TEXT + " " +
				 * reminderInterval + " " +
				 * AlertConstants.FLAG_REMINDER_INTERVAL; } else{ standardText =
				 * AlertConstants.FLAGGED_TEXT + " " +
				 * AlertConstants.FLAGGED_REMINDER_NOTSET; } } if(received ==
				 * "Y") { standardText = AlertConstants.RECEIVED_TEXT + " " +
				 * recFromUser; } if(archived == "Y") { standardText =
				 * AlertConstants.ARCHIVED_TEXT; }
				 */
				if (alertAck.equalsIgnoreCase("N")) {
					standardText = AlertConstants.NEW_ALERT;
				}
				if (standardText == "") {
					standardText = AlertConstants.ACTION_REQUIRED;
				}

				Date sysDate = new Date();
				long diff = sysDate.getTime() - alertRecordedDate.getTime();
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);

				if (diffMinutes < 1) {
					dateTimeDisplay = AlertConstants.DISPLAY_RECORDED_TIME;
				} else if (diffDays >= 1) {
					dateTimeDisplay = diffDays
							+ AlertConstants.DISPLAY_RECORDED_TIME_DAYS;
				} else if (diffMinutes > 59 && diffDays < 1) {
					dateTimeDisplay = diffHours
							+ AlertConstants.DISPLAY_RECORDED_TIME_HOURS;
				} else if (diffMinutes >= 1 && diffMinutes < 59 && diffDays < 1) {
					dateTimeDisplay = diffMinutes
							+ AlertConstants.DISPLAY_RECORDED_TIME_MINUTES;
				}

				/*long intervalDiffSecs = 0;
				long intervalDiffMins = 0;
				long intervalDiffHrs = 0;
				String intervalDisplay = "";
				Date intervalDate = null;
				if (intStartTime != null) {
					long startTime = intStartTime.getTime();
					if (reminderInterval > 0
							&& reminderIntUnit != null && reminderIntUnit != "") {
						if(reminderIntUnit.equalsIgnoreCase(AlertConstants.REMINDER_INTERVAL_UNIT_MIN)){
							intervalDate = new Date(startTime
									+ (reminderInterval * 60 * 1000));
						}
						else if(reminderIntUnit.equalsIgnoreCase(AlertConstants.REMINDER_INTERVAL_UNIT_HOUR)){
							intervalDate = new Date(startTime
									+ (reminderInterval * 60 * 60 * 1000));
						}
						long diffInterval = intervalDate.getTime()
								- sysDate.getTime();
						if (diffInterval > 0) {
							intervalDiffSecs = diffInterval / 1000 % 60;
							intervalDiffMins = diffInterval / (60 * 1000) % 60;
							intervalDiffHrs = diffInterval / (60 * 60 * 1000) % 24;

							if ((intervalDiffSecs > 0 && intervalDiffSecs < 60) && intervalDiffMins < 1) {
								intervalDisplay = intervalDiffSecs + " "
										+ AlertConstants.REMINDER_INTERVAL_UNIT_SEC;
							} else if ((intervalDiffMins > 1 && intervalDiffMins < 60) 
									&& intervalDiffHrs < 1) {
								intervalDisplay = intervalDiffMins
										+ " "
										+ AlertConstants.REMINDER_INTERVAL_UNIT_MIN
										+ " "
										+ intervalDiffSecs + " "
										+ AlertConstants.REMINDER_INTERVAL_UNIT_SEC;
							} else if (intervalDiffHrs > 1) {
								intervalDisplay = intervalDiffHrs + " "
										+ AlertConstants.REMINDER_INTERVAL_UNIT_HOUR
										+ " "
										+ intervalDiffMins
										+ " "
										+ AlertConstants.REMINDER_INTERVAL_UNIT_MIN;
							}
						}
						else{
							intervalDisplay = AlertConstants.FLAGGED_REMINDER_NOTSET;
						}
					}
				}*/
				
				if(forwarded.equalsIgnoreCase("Y")){
					
					forwardedUserId = populateForwardedUsers(conn, patientAlertSeqId, patientRecipientSeqId);
				}
				
				String intervalDisplay = "";
				intervalDisplay = generateReminderDuration(sysDate, intStartTime, reminderInterval, reminderIntUnit);

				userAlert = new AlertsByUser();
				userAlert.setPatientAlertSeqId(patientAlertSeqId);
				userAlert.setPatientRecipientSeqId(patientRecipientSeqId);
				userAlert.setAlertName(alertName);
				userAlert.setPatientName(patientName);
				userAlert.setPatientId(patientId);
				userAlert.setStandardText(standardText);
				userAlert.setDateTimeDisplay(dateTimeDisplay);
				userAlert.setArchived(archived);
				userAlert.setFlagged(flagged);
				userAlert.setForwarded(forwarded);
				userAlert.setIntStartTime(intStartTime);
				userAlert.setReceived(received);
				userAlert.setRecFromUser(recFromUser);
				userAlert.setReminderInterval(reminderInterval);
				userAlert.setReminderIntervalUnit(reminderIntUnit);
				userAlert.setIntervalDisplay(intervalDisplay);
				userAlert.setReviewed(reviewed);
				userAlert.setModifiedDate(modifiedDate);
				userAlert.setForwardedUserId(forwardedUserId);
				userAlert.setAlertAck(alertAck);
				userAlert.setAlertPriority(alertPriority);

				userAlertList.add(userAlert);
			}

			countResponse.setAlertCount(userAlertList.size());

			response.setUserAlertList(userAlertList);
			response.setCountResponse(countResponse);
		}

		return response;
	}

	private AlertDetailsResponse populateAlertDetails(Connection conn, ResultSet rs)
			throws SQLException {
		AlertDetailsResponse response = new AlertDetailsResponse();

		long patientAlertSeqId = 0;
		long patientRecipientSeqId= 0;
		String alertName = "";
		String alertDescription = "";
		String patientId = "";
		String patientName = "";
		String dateTimeDisplay = "";
		String details = "";
		//Date alertRecordedDate = null;
		Timestamp alertRecordedDate = null;
		String alertDetailsXML = "";
		AlertOutputData alertOutputData = null;
		String alertPriority = "";
		String alertAck = "";
		String flagged = "";
		String reviewed = "";
		String forwarded = "";
		String received = "";
		String comments = "";
		String modifiedDate = null;
		String receivedUserID = "";
		String forwardedUserId = "";

		Timestamp timeStamp = null;

		if (rs != null) {
			while (rs.next()) {
				patientAlertSeqId = rs.getLong("Patient_Alert_Seq_Id");
				patientRecipientSeqId = rs.getLong("Pat_Recip_Seq_Id");
				alertName = rs.getString("Alert_Title");
				alertDescription = rs.getString("Alert_Description");
				patientId = rs.getString("Patient_ID");
				patientName = rs.getString("Patient_Name");
				alertRecordedDate = rs.getTimestamp("Alert_Recorded_Date");
				alertDetailsXML = rs.getString("RuleTransData");
				alertPriority = rs.getString("Alert_Priority");
				alertAck = rs.getString("Alert_Ack");
				flagged = rs.getString("Flagged_YN");
				reviewed = rs.getString("Reviewed_YN");
				forwarded = rs.getString("Forwarded_YN");
				received = rs.getString("Recieved_YN");
				comments = rs.getString("Comments");
				// modifiedDate = rs.getDate("Modified_Date");
				timeStamp = rs.getTimestamp("Modified_Date");
				if (timeStamp != null) {
					SimpleDateFormat format = new SimpleDateFormat(
							"dd-MM-yyyy HH:mm");
					// modifiedDate = new Date(timeStamp.getTime());
					try {
						modifiedDate = format.format(timeStamp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				receivedUserID = rs.getString("Received_From_User_ID");
				if(forwarded.equalsIgnoreCase("Y")){
					forwardedUserId = populateForwardedUsers(conn, patientAlertSeqId, patientRecipientSeqId);
				}

				response.setPatientAlertSeqId(patientAlertSeqId);
				response.setPatientRecipientSeqId(patientRecipientSeqId);
				response.setAlertName(alertName);
				response.setAlertDescription(alertDescription);
				response.setPatientId(patientId);
				response.setPatientName(patientName);
				response.setAlertPriority(alertPriority);
				response.setAlertAck(alertAck);
				response.setFlagged(flagged);
				response.setReviewed(reviewed);
				response.setForwarded(forwarded);
				response.setReceived(received);
				response.setComments(comments);
				response.setModifiedDate(modifiedDate);
				response.setReceivedUserId(receivedUserID);
				response.setForwardedUserId(forwardedUserId);

				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				try {
					StringBuilder detailsBuilder = new StringBuilder();
					DocumentBuilder builder = factory.newDocumentBuilder();
					InputSource is = new InputSource(new StringReader(
							alertDetailsXML));
					Document doc = builder.parse(is);

					NodeList nodeList = doc
							.getElementsByTagName("alertDataList");
					for (int i = 0; i < nodeList.getLength(); i++) {
						Node node = nodeList.item(i);
						if (node.getNodeType() == Node.ELEMENT_NODE) {

							Element element = (Element) node;
							detailsBuilder.append(element
									.getElementsByTagName("attributeName")
									.item(0).getTextContent()
									+ " - "
									+ element
											.getElementsByTagName(
													"attributeValue").item(0)
											.getTextContent() + "~,");
						}
					}
					response.setDetails(detailsBuilder.toString());
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				/*
				 * JAXBContext jc; try { jc =
				 * JAXBContext.newInstance(AlertOutputData.class); Unmarshaller
				 * unmarshaller = jc.createUnmarshaller(); StreamSource
				 * xmlSource = new StreamSource(new
				 * StringReader(alertDetailsXML)); alertOutputData =
				 * (AlertOutputData)unmarshaller.unmarshal(xmlSource); } catch
				 * (JAXBException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 * 
				 * if(alertOutputData != null) { StringBuilder detailsBuilder =
				 * new StringBuilder(); List<AlertData> alertDataList =
				 * alertOutputData.getAlertDataList(); if(alertDataList !=
				 * null){ for(AlertData ad : alertDataList) {
				 * detailsBuilder.append(ad.getAttributeName() + " - " +
				 * ad.getAttributeValue() + "~,"); } }
				 * response.setDetails(detailsBuilder.toString()); }
				 */

				Date sysDate = new Date();
				long diff = sysDate.getTime() - alertRecordedDate.getTime();
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);

				if (diffMinutes < 1) {
					dateTimeDisplay = AlertConstants.DISPLAY_RECORDED_TIME;
				} else if (diffDays >= 1) {
					dateTimeDisplay = diffDays
							+ AlertConstants.DISPLAY_RECORDED_TIME_DAYS;
				} else if (diffMinutes > 59 && diffDays < 1) {
					dateTimeDisplay = diffHours
							+ AlertConstants.DISPLAY_RECORDED_TIME_HOURS;
				} else if (diffMinutes >= 1 && diffMinutes < 59 && diffDays < 1) {
					dateTimeDisplay = diffMinutes
							+ AlertConstants.DISPLAY_RECORDED_TIME_MINUTES;
				}

				response.setDateTimeDisplay(dateTimeDisplay);
			}
		}

		return response;
	}

	private AlertsByGroupResponse populateAlertsGroupBy(Connection conn, ResultSet rs,
			String groupText, String filtered) throws SQLException {
		AlertsByGroupResponse response = new AlertsByGroupResponse();

		List<AlertsByUser> userAlertList = new ArrayList<AlertsByUser>();
		AlertCountResponse countResponse = new AlertCountResponse();
		List<AlertsByGroup> alertsGroupList = new ArrayList<AlertsByGroup>();

		AlertsByGroup groupAlert = null;
		AlertsByUser userAlert = null;
		String prevPatId = "";
		String currPatId = "";
		long prevAlertMasterId = 0;
		long currAlertMasterId = 0;
		String prevFlag = "";
		String currFlag = "";
		String prevFlagText = "";
		String currFlagText = "";
		String prevDateText = "";
		String currDateText = "";
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar sDateCal = Calendar.getInstance();
		int groupCount = 0;
		int totalCount = 0;

		/*
		 * long patientAlertSeqId = 0; String alertName = ""; String patientId =
		 * ""; String patientName = ""; String location = ""; String
		 * standardText = ""; String dateTimeDisplay = ""; Date
		 * alertRecordedDate = null; String flagged = ""; String reviewed = "";
		 * String forwarded = ""; String alertAck = ""; String alertPriority =
		 * "";
		 *//**
		 * TODO implement for forwarded to user Id
		 */
		/*
		 * String forwardedUserId = ""; String received = ""; String recFromUser
		 * = ""; String archived = ""; Date intStartTime = null; int
		 * reminderInterval = 0; Date modifiedDate = null;
		 */

		if (rs != null) {

			while (rs.next()) {

				boolean bDataMatch = false;
				if (groupByCode.equalsIgnoreCase("PATNAME")) {
					currPatId = rs.getString("Patient_ID");
					bDataMatch = currPatId.equalsIgnoreCase(prevPatId);
				}
				if (groupByCode.equalsIgnoreCase("ALERTNAME")) {
					currAlertMasterId = rs.getLong("ALERT_MASTER_SEQ_ID");
					bDataMatch = (currAlertMasterId == prevAlertMasterId) ? true
							: false;
				}
				if (groupByCode.equalsIgnoreCase("FWDRE")) {
					if (rs.getString("Forwarded_YN").equalsIgnoreCase("Y")) {
						currFlag = rs.getString("Forwarded_YN");
						currFlagText = "Forwarded";
					} else if (rs.getString("Recieved_YN")
							.equalsIgnoreCase("Y")) {
						currFlag = rs.getString("Recieved_YN");
						currFlagText = "Received";
					} else {
						currFlag = "N";
						currFlagText = "Others";
					}

					bDataMatch = currFlagText.equalsIgnoreCase(prevFlagText);
				}
				if (groupByCode.equalsIgnoreCase("DATE")) {
					Date dateTime = rs.getDate("Alert_Recorded_Date");
					sDateCal.setTime(dateTime);
					Calendar today = Calendar.getInstance();
					Calendar yesterday = Calendar.getInstance();
					Calendar previousWeek = Calendar.getInstance();

					yesterday.add(Calendar.DATE, -1);
					previousWeek.add(Calendar.WEEK_OF_YEAR, -1);

					if (sDateCal.get(Calendar.YEAR) == today.get(Calendar.YEAR)
							&& sDateCal.get(Calendar.DAY_OF_YEAR) == today
									.get(Calendar.DAY_OF_YEAR))
						currDateText = "Today";
					else if (sDateCal.get(Calendar.YEAR) == yesterday
							.get(Calendar.YEAR)
							&& sDateCal.get(Calendar.DAY_OF_YEAR) == yesterday
									.get(Calendar.DAY_OF_YEAR))
						currDateText = "Yesterday";
					else if (sDateCal.get(Calendar.WEEK_OF_YEAR) == today
							.get(Calendar.WEEK_OF_YEAR))
						currDateText = "This Week";
					else if (sDateCal.get(Calendar.WEEK_OF_YEAR) == previousWeek
							.get(Calendar.WEEK_OF_YEAR))
						currDateText = "Last Week";
					else
						currDateText = "Older";

					bDataMatch = currDateText.equalsIgnoreCase(prevDateText);
				}

				// if(!currPatId.equalsIgnoreCase(prevPatId))
				if (!bDataMatch) {
					if (userAlertList != null && userAlertList.size() > 0) {
						groupAlert = new AlertsByGroup();
						groupAlert.setUserAlertList(userAlertList);
						groupCount = userAlertList.size();
						totalCount += userAlertList.size();
						if (groupByCode.equalsIgnoreCase("PATNAME"))
							groupAlert.setHeader(userAlert.getPatientName());
						if (groupByCode.equalsIgnoreCase("ALERTNAME"))
							groupAlert.setHeader(userAlert.getAlertName());
						if (groupByCode.equalsIgnoreCase("FWDRE"))
							groupAlert.setHeader(prevFlagText);
						if (groupByCode.equalsIgnoreCase("DATE"))
							groupAlert.setHeader(prevDateText);
						groupAlert.setGroupCount(groupCount);
					}
					if (groupAlert != null) {
						alertsGroupList.add(groupAlert);
					}
					userAlertList = new ArrayList<AlertsByUser>();
					;
					groupCount = 0;
				}

				userAlert = populateUserAlert(conn, rs, userAlert);
				/*
				 * patientAlertSeqId = rs.getLong("Patient_Alert_Seq_Id");
				 * alertName = rs.getString("Alert_Title"); patientId =
				 * rs.getString("Patient_ID"); patientName =
				 * rs.getString("Patient_Name"); alertRecordedDate =
				 * rs.getDate("Alert_Recorded_Date"); flagged =
				 * rs.getString("Flagged_YN"); reviewed =
				 * rs.getString("Reviewed_YN"); forwarded =
				 * rs.getString("Forwarded_YN"); received =
				 * rs.getString("Recieved_YN"); recFromUser =
				 * rs.getString("Received_From_User_ID"); archived =
				 * rs.getString("Archived_YN"); intStartTime =
				 * rs.getDate("Interval_Start_Time"); reminderInterval =
				 * rs.getInt("Reminder_Interval"); modifiedDate =
				 * rs.getDate("Modified_Date"); alertAck =
				 * rs.getString("Alert_Ack"); alertPriority =
				 * rs.getString("Alert_Priority");
				 * 
				 * if(reviewed == "Y") { standardText =
				 * AlertConstants.REVIEWED_TEXT + " " + modifiedDate; }
				 * if(forwarded == "Y") { //TODO fetch the forwarded details to
				 * display } if(flagged == "Y") { if(reminderInterval > 0){
				 * standardText = AlertConstants.FLAGGED_TEXT + " " +
				 * reminderInterval + " " +
				 * AlertConstants.FLAG_REMINDER_INTERVAL; } else{ standardText =
				 * AlertConstants.FLAGGED_TEXT + " " +
				 * AlertConstants.FLAGGED_REMINDER_NOTSET; } } if(received ==
				 * "Y") { standardText = AlertConstants.RECEIVED_TEXT + " " +
				 * recFromUser; } if(archived == "Y") { standardText =
				 * AlertConstants.ARCHIVED_TEXT; }
				 * if(alertAck.equalsIgnoreCase("N")) { standardText =
				 * AlertConstants.NEW_ALERT; } if(standardText == "") {
				 * standardText = AlertConstants.ACTION_REQUIRED; }
				 * 
				 * Date sysDate = new Date(); long diff = sysDate.getTime() -
				 * alertRecordedDate.getTime(); long diffMinutes = diff/(60 *
				 * 1000) % 60; long diffHours = diff/(60 * 60 * 1000) % 24; long
				 * diffDays = diff/(24 * 60 * 60 * 1000);
				 * 
				 * if(diffMinutes < 1){ dateTimeDisplay =
				 * AlertConstants.DISPLAY_RECORDED_TIME; } else if(diffDays >=
				 * 1){ dateTimeDisplay = diffDays +
				 * AlertConstants.DISPLAY_RECORDED_TIME_DAYS; } else
				 * if(diffHours > 59 && diffDays < 1){ dateTimeDisplay =
				 * diffHours + AlertConstants.DISPLAY_RECORDED_TIME_HOURS; }
				 * else if(diffMinutes >= 1 && diffHours < 59 && diffDays < 1){
				 * dateTimeDisplay = diffMinutes +
				 * AlertConstants.DISPLAY_RECORDED_TIME_MINUTES; }
				 * 
				 * userAlert = new AlertsByUser();
				 * userAlert.setPatientAlertSeqId(patientAlertSeqId);
				 * userAlert.setAlertName(alertName);
				 * userAlert.setPatientName(patientName);
				 * userAlert.setPatientId(patientId);
				 * userAlert.setStandardText(standardText);
				 * userAlert.setDateTimeDisplay(dateTimeDisplay);
				 * userAlert.setArchived(archived);
				 * userAlert.setFlagged(flagged);
				 * userAlert.setForwarded(forwarded);
				 * userAlert.setIntStartTime(intStartTime);
				 * userAlert.setReceived(received);
				 * userAlert.setRecFromUser(recFromUser);
				 * userAlert.setReminderInterval(reminderInterval);
				 * userAlert.setReviewed(reviewed);
				 * userAlert.setReviewedDate(modifiedDate);
				 * userAlert.setAlertAck(alertAck);
				 * userAlert.setAlertPriority(alertPriority);
				 */

				userAlertList.add(userAlert);

				if (groupByCode.equalsIgnoreCase("PATNAME"))
					prevPatId = currPatId;
				if (groupByCode.equalsIgnoreCase("ALERTNAME"))
					prevAlertMasterId = currAlertMasterId;
				if (groupByCode.equalsIgnoreCase("FWDRE"))
					prevFlagText = currFlagText;
				if (groupByCode.equalsIgnoreCase("DATE"))
					prevDateText = currDateText;
			}

			if (userAlertList.size() > 0) {
				groupAlert = new AlertsByGroup();
				groupAlert.setUserAlertList(userAlertList);
				groupCount = userAlertList.size();
				totalCount += userAlertList.size();
				if (groupByCode.equalsIgnoreCase("PATNAME"))
					groupAlert.setHeader(userAlert.getPatientName());
				if (groupByCode.equalsIgnoreCase("ALERTNAME"))
					groupAlert.setHeader(userAlert.getAlertName());
				if (groupByCode.equalsIgnoreCase("FWDRE"))
					groupAlert.setHeader(currFlagText);
				if (groupByCode.equalsIgnoreCase("DATE"))
					groupAlert.setHeader(currDateText);
				groupAlert.setGroupCount(groupCount);
			}
			if (groupAlert != null) {
				alertsGroupList.add(groupAlert);
			}

			countResponse.setAlertCount(totalCount);

			response.setAlertGroupList(alertsGroupList);
			response.setCountResponse(countResponse);
			response.setGroupText(groupText);
			response.setFiltered(filtered);
		}

		return response;
	}

	private AlertsByUser populateUserAlert(Connection conn, ResultSet rs, AlertsByUser userAlert)
			throws SQLException {
		long patientAlertSeqId = 0;
		long patientRecipientSeqId = 0;
		String alertName = "";
		String patientId = "";
		String patientName = "";
		String location = "";
		String standardText = "";
		String dateTimeDisplay = "";
		//Date alertRecordedDate = null;
		Timestamp alertRecordedDate = null;
		String flagged = "";
		String reviewed = "";
		String forwarded = "";
		String alertAck = "";
		String alertPriority = "";

		/**
		 * TODO implement for forwarded to user Id
		 */
		String forwardedUserId = "";
		String received = "";
		String recFromUser = "";
		String archived = "";
		Timestamp intStartTime = null;
		int reminderInterval = 0;
		String reminderIntUnit = "";
		String modifiedDate = null;
		Timestamp timeStamp = null;

		patientAlertSeqId = rs.getLong("Patient_Alert_Seq_Id");
		patientRecipientSeqId = rs.getLong("PAT_RECIP_SEQ_ID");
		alertName = rs.getString("Alert_Title");
		patientId = rs.getString("Patient_ID");
		patientName = rs.getString("Patient_Name");
		alertRecordedDate = rs.getTimestamp("Alert_Recorded_Date");
		flagged = rs.getString("Flagged_YN");
		reviewed = rs.getString("Reviewed_YN");
		forwarded = rs.getString("Forwarded_YN");
		received = rs.getString("Recieved_YN");
		recFromUser = rs.getString("Received_From_User_ID");
		archived = rs.getString("Archived_YN");
		intStartTime = rs.getTimestamp("Interval_Start_Time");
		reminderInterval = rs.getInt("Reminder_Interval");
		reminderIntUnit = rs.getString("Reminder_Interval_Unit");
		//modifiedDate = rs.getDate("Modified_Date");
		timeStamp = rs.getTimestamp("Modified_Date");
		if (timeStamp != null) {
			SimpleDateFormat format = new SimpleDateFormat(
					"dd-MM-yyyy HH:mm");
			// modifiedDate = new Date(timeStamp.getTime());
			try {
				modifiedDate = format.format(timeStamp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		alertAck = rs.getString("Alert_Ack");
		alertPriority = rs.getString("Alert_Priority");

		/*
		 * if(reviewed == "Y") { standardText = AlertConstants.REVIEWED_TEXT +
		 * " " + modifiedDate; } if(forwarded == "Y") { //TODO fetch the
		 * forwarded details to display } if(flagged == "Y") {
		 * if(reminderInterval > 0){ standardText = AlertConstants.FLAGGED_TEXT
		 * + " " + reminderInterval + " " +
		 * AlertConstants.FLAG_REMINDER_INTERVAL; } else{ standardText =
		 * AlertConstants.FLAGGED_TEXT + " " +
		 * AlertConstants.FLAGGED_REMINDER_NOTSET; } } if(received == "Y") {
		 * standardText = AlertConstants.RECEIVED_TEXT + " " + recFromUser; }
		 * if(archived == "Y") { standardText = AlertConstants.ARCHIVED_TEXT; }
		 */
		if (alertAck.equalsIgnoreCase("N")) {
			standardText = AlertConstants.NEW_ALERT;
		}
		if (standardText == "") {
			standardText = AlertConstants.ACTION_REQUIRED;
		}

		Date sysDate = new Date();
		long diff = sysDate.getTime() - alertRecordedDate.getTime();
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		if (diffMinutes < 1) {
			dateTimeDisplay = AlertConstants.DISPLAY_RECORDED_TIME;
		} else if (diffDays >= 1) {
			dateTimeDisplay = diffDays
					+ AlertConstants.DISPLAY_RECORDED_TIME_DAYS;
		} else if (diffMinutes > 59 && diffDays < 1) {
			dateTimeDisplay = diffHours
					+ AlertConstants.DISPLAY_RECORDED_TIME_HOURS;
		} else if (diffMinutes >= 1 && diffMinutes < 59 && diffDays < 1) {
			dateTimeDisplay = diffMinutes
					+ AlertConstants.DISPLAY_RECORDED_TIME_MINUTES;
		}

		String intervalDisplay = "";
		intervalDisplay = generateReminderDuration(sysDate, intStartTime, reminderInterval, reminderIntUnit);
		
		if(forwarded.equalsIgnoreCase("Y")){
			forwardedUserId = populateForwardedUsers(conn, patientAlertSeqId, patientRecipientSeqId);
		}
		
		userAlert = new AlertsByUser();
		userAlert.setPatientAlertSeqId(patientAlertSeqId);
		userAlert.setAlertName(alertName);
		userAlert.setPatientName(patientName);
		userAlert.setPatientId(patientId);
		userAlert.setStandardText(standardText);
		userAlert.setDateTimeDisplay(dateTimeDisplay);
		userAlert.setArchived(archived);
		userAlert.setFlagged(flagged);
		userAlert.setForwarded(forwarded);
		userAlert.setIntStartTime(intStartTime);
		userAlert.setReceived(received);
		userAlert.setRecFromUser(recFromUser);
		userAlert.setReminderInterval(reminderInterval);
		userAlert.setIntervalDisplay(intervalDisplay);
		userAlert.setReviewed(reviewed);
		userAlert.setModifiedDate(modifiedDate);
		userAlert.setForwardedUserId(forwardedUserId);
		userAlert.setAlertAck(alertAck);
		userAlert.setAlertPriority(alertPriority);

		return userAlert;
	}

	private AlertsByFilterResponse populateFilteredAlerts(Connection conn, ResultSet rs)
			throws SQLException {
		AlertsByFilterResponse response = new AlertsByFilterResponse();
		List<AlertsByUser> userAlertList = new ArrayList<AlertsByUser>();
		AlertCountResponse countResponse = new AlertCountResponse();

		AlertsByUser userAlert = null;

		long patientAlertSeqId = 0;
		long patientRecipientSeqId = 0;
		String alertName = "";
		String patientId = "";
		String patientName = "";
		String location = "";
		String standardText = "";
		String dateTimeDisplay = "";
		//Date alertRecordedDate = null;
		Timestamp alertRecordedDate = null;
		String flagged = "";
		String reviewed = "";
		String forwarded = "";
		String alertAck = "";
		String alertPriority = "";
		/**
		 * TODO implement for forwarded to user Id
		 */
		String forwardedUserId = "";
		String received = "";
		String recFromUser = "";
		String archived = "";
		Timestamp intStartTime = null;
		int reminderInterval = 0;
		String reminderIntUnit = "";
		String modifiedDate = null;
		Timestamp timeStamp = null;

		if (rs != null) {

			while (rs.next()) {

				patientAlertSeqId = rs.getLong("Patient_Alert_Seq_Id");
				patientRecipientSeqId = rs.getLong("PAT_RECIP_SEQ_ID");
				alertName = rs.getString("Alert_Title");
				patientId = rs.getString("Patient_ID");
				patientName = rs.getString("Patient_Name");
				alertRecordedDate = rs.getTimestamp("Alert_Recorded_Date");
				flagged = rs.getString("Flagged_YN");
				reviewed = rs.getString("Reviewed_YN");
				forwarded = rs.getString("Forwarded_YN");
				received = rs.getString("Recieved_YN");
				recFromUser = rs.getString("Received_From_User_ID");
				archived = rs.getString("Archived_YN");
				intStartTime = rs.getTimestamp("Interval_Start_Time");
				reminderInterval = rs.getInt("Reminder_Interval");
				reminderIntUnit = rs.getString("Reminder_Interval_Unit");
				//modifiedDate = rs.getDate("Modified_Date");
				timeStamp = rs.getTimestamp("Modified_Date");
				if (timeStamp != null) {
					SimpleDateFormat format = new SimpleDateFormat(
							"dd-MM-yyyy HH:mm");
					// modifiedDate = new Date(timeStamp.getTime());
					try {
						modifiedDate = format.format(timeStamp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				alertAck = rs.getString("Alert_Ack");
				alertPriority = rs.getString("Alert_Priority");

				/*
				 * if(reviewed == "Y") { standardText =
				 * AlertConstants.REVIEWED_TEXT + " " + modifiedDate; }
				 * if(forwarded == "Y") { //TODO fetch the forwarded details to
				 * display } if(flagged == "Y") { if(reminderInterval > 0){
				 * standardText = AlertConstants.FLAGGED_TEXT + " " +
				 * reminderInterval + " " +
				 * AlertConstants.FLAG_REMINDER_INTERVAL; } else{ standardText =
				 * AlertConstants.FLAGGED_TEXT + " " +
				 * AlertConstants.FLAGGED_REMINDER_NOTSET; } } if(received ==
				 * "Y") { standardText = AlertConstants.RECEIVED_TEXT + " " +
				 * recFromUser; } if(archived == "Y") { standardText =
				 * AlertConstants.ARCHIVED_TEXT; }
				 */
				if (alertAck.equalsIgnoreCase("N")) {
					standardText = AlertConstants.NEW_ALERT;
				}
				if (standardText == "") {
					standardText = AlertConstants.ACTION_REQUIRED;
				}

				Date sysDate = new Date();
				long diff = sysDate.getTime() - alertRecordedDate.getTime();
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);

				if (diffMinutes < 1) {
					dateTimeDisplay = AlertConstants.DISPLAY_RECORDED_TIME;
				} else if (diffDays >= 1) {
					dateTimeDisplay = diffDays
							+ AlertConstants.DISPLAY_RECORDED_TIME_DAYS;
				} else if (diffMinutes > 59 && diffDays < 1) {
					dateTimeDisplay = diffHours
							+ AlertConstants.DISPLAY_RECORDED_TIME_HOURS;
				} else if (diffMinutes >= 1 && diffMinutes < 59 && diffDays < 1) {
					dateTimeDisplay = diffMinutes
							+ AlertConstants.DISPLAY_RECORDED_TIME_MINUTES;
				}

				String intervalDisplay = "";
				intervalDisplay = generateReminderDuration(sysDate, intStartTime, reminderInterval, reminderIntUnit);
				
				if(forwarded.equalsIgnoreCase("Y")){
					forwardedUserId = populateForwardedUsers(conn, patientAlertSeqId, patientRecipientSeqId);
				}
				
				userAlert = new AlertsByUser();
				userAlert.setPatientAlertSeqId(patientAlertSeqId);
				userAlert.setAlertName(alertName);
				userAlert.setPatientName(patientName);
				userAlert.setPatientId(patientId);
				userAlert.setStandardText(standardText);
				userAlert.setDateTimeDisplay(dateTimeDisplay);
				userAlert.setArchived(archived);
				userAlert.setFlagged(flagged);
				userAlert.setForwarded(forwarded);
				userAlert.setIntStartTime(intStartTime);
				userAlert.setReceived(received);
				userAlert.setRecFromUser(recFromUser);
				userAlert.setReminderInterval(reminderInterval);
				userAlert.setIntervalDisplay(intervalDisplay);
				userAlert.setReviewed(reviewed);
				userAlert.setModifiedDate(modifiedDate);
				userAlert.setForwardedUserId(forwardedUserId);
				userAlert.setAlertAck(alertAck);
				userAlert.setAlertPriority(alertPriority);

				userAlertList.add(userAlert);
			}

			countResponse.setAlertCount(userAlertList.size());

			response.setUserAlertList(userAlertList);
			response.setCountResponse(countResponse);
		}

		return response;
	}

	/**
	 * Manage methods
	 */
	public AlertBaseResponse updateAlertReviewState(
			AlertReviewMangRequest request) {

		AlertBaseResponse response = new AlertBaseResponse();

		String strUpdateQuery = "";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		String userId = "";
		long alertId = 0;
		String comment = "";
		int updatedRowCount = 0;
		long patRecipientId = 0;

		userId = request.getUserId();
		alertId = request.getAlertId();
		comment = request.getCommentText();
		patRecipientId = request.getPatRecipientId();

		Connection conn = DBConnectionHelper.getConnection();
		strUpdateQuery = "UPDATE UA_PAT_RECIPIENT_DETAILS SET REVIEWED_YN = 'Y', RECIEVED_YN = 'N', FLAGGED_YN = 'N', \r\n";
		strUpdateQuery += "INTERVAL_START_TIME = NULL, REMINDER_INTERVAL = 0, REMINDER_INTERVAL_UNIT = NULL, Modified_Date = sysdate, COMMENTS = ? \r\n";
		strUpdateQuery += "WHERE PATIENT_ALERT_SEQ_ID = ? \r\n";
		strUpdateQuery += "AND PAT_RECIP_SEQ_ID = ?";

		try {
			conn.setAutoCommit(false);
			prepStmt = conn.prepareStatement(strUpdateQuery);
			prepStmt.setString(1, comment);
			prepStmt.setLong(2, alertId);
			prepStmt.setLong(3, patRecipientId);

			updatedRowCount = prepStmt.executeUpdate();

			if (updatedRowCount > 0) {
				AlertErrorInfo errorInfo = new AlertErrorInfo();
				errorInfo.setErrorCode(AlertErrorInfo.SUCCESS_CODE);
				response.setErrorInfo(errorInfo);
				conn.commit();
			} else
				conn.rollback();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			DBConnectionHelper.returnConnection(conn);
		}

		return response;
	}

	public AlertBaseResponse updateAlertFlagState(AlertFlagManageRequest request) {
		AlertBaseResponse response = new AlertBaseResponse();

		String strUpdateQuery = "";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		String userId = "";
		long alertId = 0;
		String flagged = "";
		String timeCode = "";
		String flagValue = "";
		int interval = 0;
		String intervalUnit = "";
		int updatedRowCount = 0;
		long patRecipientId = 0;

		userId = request.getUserId();
		alertId = request.getAlertId();
		patRecipientId = request.getPatRecipientId();
		flagValue = request.getFlagged();
		timeCode = request.getTimeCode();
		if (flagValue.equalsIgnoreCase("on")) {
			flagged = "Y";
		} else {
			flagged = "N";
		}

		if (timeCode.equalsIgnoreCase("15M")) {
			interval = 15;
			intervalUnit = AlertConstants.REMINDER_INTERVAL_UNIT_MIN;
		}
		if (timeCode.equalsIgnoreCase("30M")) {
			interval = 30;
			intervalUnit = AlertConstants.REMINDER_INTERVAL_UNIT_MIN;
		}
		if (timeCode.equalsIgnoreCase("1H")) {
			interval = 1;
			intervalUnit = AlertConstants.REMINDER_INTERVAL_UNIT_HOUR;
		}
		if (timeCode.equalsIgnoreCase("4H")) {
			interval = 4;
			intervalUnit = AlertConstants.REMINDER_INTERVAL_UNIT_HOUR;
		}
		if (timeCode.equalsIgnoreCase("24H")) {
			interval = 24;
			intervalUnit = AlertConstants.REMINDER_INTERVAL_UNIT_HOUR;
		}

		Connection conn = DBConnectionHelper.getConnection();
		strUpdateQuery = "UPDATE UA_PAT_RECIPIENT_DETAILS SET FLAGGED_YN = ?, \r\n";
		strUpdateQuery += "INTERVAL_START_TIME = sysdate, REMINDER_INTERVAL = ?, REMINDER_INTERVAL_UNIT = ?, MODIFIED_DATE = sysdate \r\n";
		strUpdateQuery += "WHERE PATIENT_ALERT_SEQ_ID = ? \r\n";
		strUpdateQuery += "AND PAT_RECIP_SEQ_ID = ?";

		try {
			conn.setAutoCommit(false);
			prepStmt = conn.prepareStatement(strUpdateQuery);

			prepStmt.setString(1, flagged);
			prepStmt.setInt(2, interval);
			prepStmt.setString(3, intervalUnit);
			prepStmt.setLong(4, alertId);
			prepStmt.setLong(5, patRecipientId);

			updatedRowCount = prepStmt.executeUpdate();

			if (updatedRowCount > 0) {
				AlertErrorInfo errorInfo = new AlertErrorInfo();
				errorInfo.setErrorCode(AlertErrorInfo.SUCCESS_CODE);
				response.setErrorInfo(errorInfo);
				conn.commit();
			} else
				conn.rollback();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			DBConnectionHelper.returnConnection(conn);
		}

		return response;
	}

	public AlertBaseResponse updateAlertForwardState(
			AlertFwdManageRequest request) {

		AlertBaseResponse response = null;

		String strUpdateQuery = "";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		long alertId = 0;
		String comment = "";
		long patientAlertRecipientId = 0;
		int updatedRowCount = 0;
		List<String> userList = null;
		String recFromUserId = "";

		alertId = request.getAlertId();
		comment = request.getComment();
		patientAlertRecipientId = request.getPatientAlertRecipientId();
		userList = request.getUserIdList();
		recFromUserId = request.getUserId();

		Connection conn = DBConnectionHelper.getConnection();
		strUpdateQuery = "UPDATE UA_PAT_RECIPIENT_DETAILS SET FORWARDED_YN = 'Y', RECIEVED_YN = 'N', FLAGGED_YN = 'N', \r\n";
		strUpdateQuery += "INTERVAL_START_TIME = NULL, REMINDER_INTERVAL = 0, REMINDER_INTERVAL_UNIT = NULL, Modified_Date = sysdate, COMMENTS = ? \r\n";
		strUpdateQuery += "WHERE PATIENT_ALERT_SEQ_ID = ? \r\n";
		strUpdateQuery += "AND PAT_RECIP_SEQ_ID = ?";

		try {
			conn.setAutoCommit(false);
			prepStmt = conn.prepareStatement(strUpdateQuery);
			prepStmt.setString(1, comment);
			prepStmt.setLong(2, alertId);
			prepStmt.setLong(3, patientAlertRecipientId);

			updatedRowCount = prepStmt.executeUpdate();

			if (updatedRowCount > 0) {
				
				response = insertForwardedAlert(conn, alertId, patientAlertRecipientId, userList, recFromUserId, comment);

				if(response.getErrorInfo().getErrorCode() == AlertErrorInfo.SUCCESS_CODE){
					conn.commit();
				}
			} else
				conn.rollback();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			DBConnectionHelper.returnConnection(conn);
		}

		return response;
	}

	public AlertBaseResponse archiveAlert(AlertRequest request) {

		AlertBaseResponse response = new AlertBaseResponse();

		String strUpdateQuery = "";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		String userId = "";
		long alertId = 0;
		long patRecipientId = 0;
		int updatedRowCount = 0;

		userId = request.getUserId();
		alertId = request.getAlertId();
		patRecipientId = request.getPatRecipientId();

		Connection conn = DBConnectionHelper.getConnection();
		strUpdateQuery = "UPDATE UA_PAT_RECIPIENT_DETAILS SET ARCHIVED_YN = 'Y', FLAGGED_YN = 'N', \r\n";
		strUpdateQuery += "INTERVAL_START_TIME = NULL, REMINDER_INTERVAL = 0, REMINDER_INTERVAL_UNIT = NULL, Modified_Date = sysdate \r\n";
		strUpdateQuery += "WHERE PATIENT_ALERT_SEQ_ID = ? \r\n";
		strUpdateQuery += "AND PAT_RECIP_SEQ_ID = ?";

		try {
			conn.setAutoCommit(false);
			prepStmt = conn.prepareStatement(strUpdateQuery);
			prepStmt.setLong(1, alertId);
			prepStmt.setLong(2, patRecipientId);

			updatedRowCount = prepStmt.executeUpdate();

			if (updatedRowCount > 0) {
				AlertErrorInfo errorInfo = new AlertErrorInfo();
				errorInfo.setErrorCode(AlertErrorInfo.SUCCESS_CODE);
				response.setErrorInfo(errorInfo);
				conn.commit();
			} else
				conn.rollback();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			DBConnectionHelper.returnConnection(conn);
		}

		return response;
	}

	public AlertFlagOptionResponse getFlagOptions() {

		AlertFlagOptionResponse response = new AlertFlagOptionResponse();

		List<AlertFlagOptions> alertFlagOptionList = null;

		AlertFlagOptionContainer flagOptionCont = AlertFlagOptionContainer
				.getInstance();
		alertFlagOptionList = flagOptionCont.getAlertFlagOptionsConfig();

		response.setAlertFlagOptionList(alertFlagOptionList);

		return response;
	}
	
	public AlertForwardUserResponse getForwardToUsers(AlertForwardUserRequest request) {
		
		AlertForwardUserResponse response = new AlertForwardUserResponse();
		
		List<AlertForwardUsers> alertForwardUserList = null;
		
		String userId = "";
		String strQuery = "";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		userId = request.getUserId();
		
		Connection conn = DBConnectionHelper.getConnection();
		strQuery = "SELECT APPL_USER_ID, APPL_USER_NAME FROM SM_APPL_USER \r\n";
		strQuery += "WHERE  ( SYSDATE  BETWEEN NVL(EFF_DATE_FROM,TO_DATE('01/01/1472','DD/MM/RRRR') ) \r\n";
		strQuery += "AND    NVL(EFF_DATE_TO,TO_DATE('31/12/5000','DD/MM/RRRR') ) ) \r\n";
		strQuery += "AND EFF_STATUS = 'E' \r\n";
		strQuery += "AND APPL_USER_ID NOT IN (?) \r\n";
		strQuery += "ORDER BY APPL_USER_ID";
		try {
			stmt = conn.prepareStatement(strQuery);
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			alertForwardUserList = populateAlertForwardUsers(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			DBConnectionHelper.returnConnection(conn);
		}
		response.setForwardUserList(alertForwardUserList);
		
		return response;
	}
	
	private List<AlertForwardUsers> populateAlertForwardUsers(ResultSet rs) throws SQLException{
		
		List<AlertForwardUsers> alertForwardUserList = new ArrayList<AlertForwardUsers>();
		
		String applUserId = "";
		String applUserName = "";
		
		AlertForwardUsers forwardUser = null;
		
		if(rs != null){
			while(rs.next()){
				applUserId = rs.getString("APPL_USER_ID");
				applUserName = rs.getString("APPL_USER_NAME");
				
				forwardUser = new AlertForwardUsers();
				forwardUser.setUserId(applUserId);
				forwardUser.setUserName(applUserName);
				
				alertForwardUserList.add(forwardUser);
			}
		}
		
		return alertForwardUserList;
	}
	
	private String generateReminderDuration(Date sysDate, Timestamp intStartTime, int reminderInterval, String reminderIntUnit){
		
		long intervalDiffSecs = 0;
		long intervalDiffMins = 0;
		long intervalDiffHrs = 0;
		String intervalDisplay = "";
		Date intervalDate = null;
		if (intStartTime != null) {
			long startTime = intStartTime.getTime();
			if (reminderInterval > 0
					&& reminderIntUnit != null && reminderIntUnit != "") {
				if(reminderIntUnit.equalsIgnoreCase(AlertConstants.REMINDER_INTERVAL_UNIT_MIN)){
					intervalDate = new Date(startTime
							+ (reminderInterval * 60 * 1000));
				}
				else if(reminderIntUnit.equalsIgnoreCase(AlertConstants.REMINDER_INTERVAL_UNIT_HOUR)){
					intervalDate = new Date(startTime
							+ (reminderInterval * 60 * 60 * 1000));
				}
				long diffInterval = intervalDate.getTime()
						- sysDate.getTime();
				if (diffInterval > 0) {
					intervalDiffSecs = diffInterval / 1000 % 60;
					intervalDiffMins = diffInterval / (60 * 1000) % 60;
					intervalDiffHrs = diffInterval / (60 * 60 * 1000) % 24;

					if ((intervalDiffSecs > 0 && intervalDiffSecs < 60) && intervalDiffMins < 1) {
						intervalDisplay = intervalDiffSecs + " "
								+ AlertConstants.REMINDER_INTERVAL_UNIT_SEC;
					} else if ((intervalDiffMins > 1 && intervalDiffMins < 60) 
							&& intervalDiffHrs < 1) {
						intervalDisplay = intervalDiffMins
								+ " "
								+ AlertConstants.REMINDER_INTERVAL_UNIT_MIN
								+ " "
								+ intervalDiffSecs + " "
								+ AlertConstants.REMINDER_INTERVAL_UNIT_SEC;
					} else if (intervalDiffHrs > 1) {
						intervalDisplay = intervalDiffHrs + " "
								+ AlertConstants.REMINDER_INTERVAL_UNIT_HOUR
								+ " "
								+ intervalDiffMins
								+ " "
								+ AlertConstants.REMINDER_INTERVAL_UNIT_MIN;
					}
				}
				else{
					intervalDisplay = AlertConstants.FLAGGED_REMINDER_NOTSET;
				}
			}
		}
		
		return intervalDisplay;
	}
	
	private AlertBaseResponse insertForwardedAlert(Connection conn, long alertId, long patientAlertRecipientId, List<String> userList, String recFromUserId, String comment) throws SQLException{
		
		AlertBaseResponse response = new AlertBaseResponse();
		
		String strFwdInsert = "";
		PreparedStatement prepIns = null;
		PreparedStatement prepSelect = null;
		long fwdSeqId = 0;
		int insertedCount = 0;
		
		for(String fwdUserId : userList){
			strFwdInsert = "INSERT INTO UA_ALERT_FORWARDED (PATIENT_ALERT_SEQ_ID, PAT_REPCEP_SEQ_ID, FORWARDED_USER_ID) VALUES (?, ?, ?) \r\n";
			//strFwdInsert = "INSERT INTO UA_ALERT_FORWARDED (ALERT_FORWARDED_SEQ_ID, PATIENT_ALERT_SEQ_ID, PAT_REPCEP_SEQ_ID, FORWARDED_USER_ID) VALUES (AlertForwarded_SeqID.nextval, ?, ?, ?) \r\n";
			
			prepIns = conn.prepareStatement(strFwdInsert);
			//prepIns = conn.prepareStatement(strFwdInsert, Statement.RETURN_GENERATED_KEYS);
			
			prepIns.setLong(1, alertId);
			prepIns.setLong(2, patientAlertRecipientId);
			prepIns.setString(3, fwdUserId);
			
			prepIns.executeUpdate();
			
			prepSelect = conn.prepareStatement("Select AlertForwarded_SeqID.currval from dual");
			//prepSelect = conn.prepareStatement("Select IBAEHIS.AlertForwarded_SeqID.nextval from dual");
			ResultSet rs = prepSelect.executeQuery();
			
			//ResultSet rs = prepIns.getGeneratedKeys();
			
			if(rs.next())
			{
				fwdSeqId = rs.getLong(1);
			}
			
			if(fwdSeqId > 0){
				insertedCount = insertedCount + 1;
				//response = addFwdRecipientDetails(conn, alertId, fwdUserId, recFromUserId, comment);
			}
		}
		
		if(insertedCount == userList.size()){
			response = addForwardedAlert(conn, alertId, userList, recFromUserId, comment);
		}
		
		return response;
	}
	
	private AlertBaseResponse addForwardedAlert(Connection conn, long alertId, List<String> fwdUserList, String recFromUserId, String comment) throws SQLException{
		
		AlertBaseResponse response = new AlertBaseResponse();
		
				
		PreparedStatement prepSelect = null;
		ResultSet rs = null;
		PreparedStatement prepAlertSelect = null;
		long patAlertId = 0;
		
		/**
		 * Get the details from the forwarding alert id for the users to be forwarded to create new alert.
		 */
		long userAlertId = 0;
		String patientId = "";
		String alertCode = "";
		String alertTitle = "";
		long alertMasterSeqId = 0;
		
		String strAlertSelect = "";
		strAlertSelect = "SELECT User_Alert_Seq_ID, Patient_ID, Alert_Code, Alert_Title, Alert_Master_Seq_ID \r\n";
		strAlertSelect += "FROM UA_PATIENT_ALERT WHERE Patient_Alert_Seq_Id = ?";
		
		prepAlertSelect = conn.prepareStatement(strAlertSelect);
		prepAlertSelect.setLong(1, alertId);
		rs = prepAlertSelect.executeQuery();
		
		if(rs != null){
			while(rs.next()){
				userAlertId = rs.getLong("User_Alert_Seq_ID");
				patientId = rs.getString("Patient_ID");
				alertCode = rs.getString("Alert_Code");
				alertTitle = rs.getString("Alert_Title");
				alertMasterSeqId = rs.getLong("Alert_Master_Seq_ID");
			}
		}
		if(rs != null){
			rs.close();
		}
		if(prepAlertSelect != null){
			prepAlertSelect.close();
		}
		
		String strInsQuery = "";
		strInsQuery = "INSERT INTO UA_PATIENT_ALERT (User_Alert_Seq_ID, Patient_ID, Alert_Code, Alert_Title, Alert_Master_Seq_ID, Alert_Recorded_Date) VALUES";
		strInsQuery += " (?, ?, ?, ?, ?, sysdate)";
		
		conn.setAutoCommit(false);
		PreparedStatement prepStmt = conn.prepareStatement(strInsQuery);
		prepStmt.setLong(1, userAlertId);
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
			response = addFwdRecipientDetails(conn, patAlertId, fwdUserList, recFromUserId, comment);
			
			if(response.getErrorInfo().getErrorCode() == AlertErrorInfo.SUCCESS_CODE){
				conn.commit();
			}
		}
		
		return response;
	}
	
	private AlertBaseResponse addFwdRecipientDetails(Connection conn, long patAlertId, List<String> recipUserIdList, String recFromUserId, String comment) throws SQLException
	{
		AlertBaseResponse response = new AlertBaseResponse();
		
		PreparedStatement prepSelect = null;
		PreparedStatement prepStmt = null;
		long patRecpSeqId = 0;
		
		for(String recipUserID : recipUserIdList)
		{
			String strInsQuery = "";
			strInsQuery = "INSERT INTO UA_PAT_RECIPIENT_DETAILS (Patient_Alert_Seq_ID, Alert_Recipient_Seq_ID, Recipient_User_ID, Flagged_YN, Reviewed_YN, Forwarded_YN, Recieved_YN, Archived_YN, Received_From_User_ID, Interval_Start_Time, Reminder_Interval, Reminder_Interval_Unit, Notification_Status, Comments, Modified_Date, Alert_Ack) VALUES";
			strInsQuery += " (?, 0, ?, 'N', 'N', 'N', 'Y', 'N', ?, null, 0, null, 'N', ?, sysdate, 'N')";
			
			conn.setAutoCommit(false);
			prepStmt = conn.prepareStatement(strInsQuery);
			prepStmt.setLong(1, patAlertId);
			prepStmt.setString(2, recipUserID);
			prepStmt.setString(3, recFromUserId);
			prepStmt.setString(4, comment);
			
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
	
	private String populateForwardedUsers(Connection conn, long patientAlertSeqId, long patientRecipientSeqId) throws SQLException{
		
		String forwardedUserId = "";
		StringBuffer sBuffer = new StringBuffer();
		String strSelect = "";
		PreparedStatement prepFwd = null;
		ResultSet rsFwd = null;
		
		sBuffer.append("SELECT FORWARDED_USER_ID, APPL_USER_NAME FROM UA_ALERT_FORWARDED \r\n");
		sBuffer.append("INNER JOIN SM_APPL_USER \r\n");
		sBuffer.append("ON UA_ALERT_FORWARDED.FORWARDED_USER_ID = SM_APPL_USER.APPL_USER_ID \r\n");
		sBuffer.append("AND ( SYSDATE  BETWEEN NVL(EFF_DATE_FROM,TO_DATE('01/01/1472','DD/MM/RRRR') ) \r\n");
		sBuffer.append("AND NVL(EFF_DATE_TO,TO_DATE('31/12/5000','DD/MM/RRRR') ) ) \r\n");
		sBuffer.append("AND EFF_STATUS = 'E' \r\n");
		sBuffer.append("WHERE PATIENT_ALERT_SEQ_ID = ? \r\n");
		sBuffer.append("AND PAT_REPCEP_SEQ_ID = ?");
		
		strSelect = sBuffer.toString();
		
		prepFwd = conn.prepareStatement(strSelect);
		prepFwd.setLong(1, patientAlertSeqId);
		prepFwd.setLong(2, patientRecipientSeqId);
		
		rsFwd = prepFwd.executeQuery();
		
		if(rsFwd != null){
			StringBuffer sFwdUsers = new StringBuffer();
			
			while(rsFwd.next()){
				String strFwdUserName = rsFwd.getString("APPL_USER_NAME");
				sFwdUsers.append(strFwdUserName + ", ");
			}
			if(sFwdUsers.length() > 0){
				sFwdUsers = sFwdUsers.delete(sFwdUsers.length() - 2, sFwdUsers.length());
				forwardedUserId = sFwdUsers.toString(); 
			}
		}
		
		return forwardedUserId;
	}
}
