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
package com.ehis.alertutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import webbeans.eCommon.ConnectionManager;

/**
 * @author PrasannaR
 *
 */
public class AlertUtils {

	public static String getUnacknowledgedAlerts(String userId)
	{
		String unAckAlertCnt = ""; 
		
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Connection con=ConnectionManager.getConnection();
		/*Prasanna*/
		
		int unAckAlertCount = 0;
		String strAlertSql = "SELECT COUNT(*) AS ALERTCOUNT FROM UA_PATIENT_ALERT PATALERT \r\n"; 
		strAlertSql += "INNER JOIN UA_PAT_RECIPIENT_DETAILS RECDET \r\n"; 
		strAlertSql += "ON PATALERT.PATIENT_ALERT_SEQ_ID = RECDET.PATIENT_ALERT_SEQ_ID \r\n"; 
		strAlertSql += "WHERE RECDET.RECIPIENT_USER_ID = ? \r\n";
		strAlertSql += "AND RECDET.ALERT_ACK = 'N' \r\n";

		try{
			
			pstmt = con.prepareStatement(strAlertSql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset!=null){
				while(rset.next()){
					unAckAlertCount = rset.getInt("ALERTCOUNT");
				}
			}
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
		}catch (Exception e){
			if(rset!=null)
				try {
					rset.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con);
		/*Prasanna*/
		
		unAckAlertCnt = Integer.toString(unAckAlertCount);
		return unAckAlertCnt;
	}
}
