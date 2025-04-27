/*
 * iSOFT-eHIS Interface Engine - Database Transactions for custom functionalities
 */

package com.isoft.interfaceengine.validations;

import java.sql.*;

import HL7Engine.Common.*;
import HL7Engine.InboundProcess.InboundServerParameters;

/**
 * Class contains methods related to db transactions required during the message validation.
 *
 * @version		1.0 11 Dec 2009
 * @author		Ravindranath
 */
public class DBTransactions
{
	private Connection dbConn = null;

	InboundServerParameters serverParameters = null;
	Common common = null;

	public DBTransactions(InboundServerParameters serverParameters, Connection con)
	{
		common = Common.getInstance();
		dbConn = con;
		this.serverParameters = serverParameters;
	}

	public String getDBClientID()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String clientID = null;
		String qryClientID = "SELECT condition_exp1_val FROM xh_appl_validation_rules WHERE ELEMENT_ID = ? AND APPLICATION_ID = ?";

		try
		{			
			pstmt = dbConn.prepareStatement(qryClientID);
			pstmt.setString(1, ":HCS[3]");
			pstmt.setString(2, serverParameters.strApplicationId);

			rs = pstmt.executeQuery();
			if(rs.next())
			{
				clientID = rs.getString("condition_exp1_val");
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			closeResource(rs, pstmt);
		}
		return clientID;
	}

	public String getBankCode(String siteBankCode)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String bankCode = null;
		String qrybankCode = "SELECT pk_value FROM XH_OTH_APPL_DATA_SKEY WHERE table_id = "+
							"'BL_BANK_NAME' AND application_id = ? and ext_pk_id = ?";

		try
		{			
			pstmt = dbConn.prepareStatement(qrybankCode);
			pstmt.setString(1, serverParameters.strApplicationId);
			pstmt.setString(2, siteBankCode);

			rs = pstmt.executeQuery();
			if(rs.next())
			{
				bankCode = rs.getString("pk_value");
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			closeResource(rs, pstmt);
		}
		return bankCode;
	}

	public static void closeResource(ResultSet rs, Statement ps)
	{
		try
		{
			if(rs != null) rs.close();
			if(ps != null) ps.close();			
		}
		catch(Exception exp) {}										
	}
}