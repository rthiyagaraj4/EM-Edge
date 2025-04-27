package com.isoft.interfaceengine.dao;

import HL7Engine.Common.*;
import HL7Engine.OutboundProcess.*;
import com.isoft.interfaceengine.util.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class contains methods for all the database related transactions required for webservice functions.
 *
 * Author  : Ravindranath
 * Version : 01/02/2011
 */

public class ServiceDAO 
{
	OutboundClientDBInteraction clientDB;
	OutboundClientParameters clientParameters;
	Common common;

	Connection emDBConn;

	public ServiceDAO(OutboundClientParameters clientParameters, OutboundClientDBInteraction clientDB)
	{
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;
		common = Common.getInstance();
		emDBConn = clientDB.connDB;
	}

	private void handleExceptions(String errMsg, Exception exception)
	{
		common.fileOutput(clientParameters.strLogFile, errMsg + "\n");
		common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n");
		exception.printStackTrace();

		if(exception instanceof SQLException)
		{
			clientDB.checkDBConnection();
		}
	}

	public Map getSAPServiceData()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap dataMap = null;
		HashMap tempMap = null;

		try
		{
			String qry = Queries.SAP_SERVICE_QRY;
			pstmt = emDBConn.prepareStatement(qry);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				if(dataMap == null) dataMap  = new HashMap();
				tempMap = new HashMap();

				tempMap.put("TRNID", rs.getString("trx_no"));
				tempMap.put("CREATEDBY", rs.getString("added_by_id"));
				tempMap.put("CREATEDDATE", rs.getString("createddate"));
				tempMap.put("CREATEDTIME", rs.getString("createdtime"));
				tempMap.put("LOGCHG", "");
				tempMap.put("TRNREMARK", rs.getString("err_msg"));
				tempMap.put("TRNSTATUSNEW", rs.getString("record_status"));
				tempMap.put("TRNSTATUSOLD", "");
				tempMap.put("UPDATEDSTATUS", rs.getString("record_status"));
				tempMap.put("UPDATEDSTATUSDESC", rs.getString("err_msg"));
				tempMap.put("TABLENAME", rs.getString("table_name"));

				dataMap.put(rs.getString("TRX_NO"), tempMap);
			}
		}		
		catch (Exception exp)
		{
			handleExceptions("(ServiceDAO:getSAPServiceData) Exception:"+exp.getMessage()+"\n", exp);
		}
		finally
		{
			SQLUtil.closeResultSet(rs);
			SQLUtil.closeStatement(pstmt);
		}
		return dataMap;
	}

	public boolean updateSAPItemsStatus(HashMap tableMap, th.ac.mahidol.si.zehis.alleh.all01.DTALL01EHISRESULTRES.Response.ZRECORD.Items [] items)
	{
		Statement stmt = null;		
		Statement purgeItemsStmt = null;
		Statement purgeXIInvTrnDtlsStmt = null;

		String status = null;
		String remarks = null;
		String trxNo = null;
		String tableName = null;
		boolean isPurgeEnabled = clientParameters.isPurgeEnabled;
		boolean isSuccess = false;
		
		String purgeItemsQry = "";
		String purgeXIInvTrnDtls = "";
		String updateQry = "UPDATE "
							+ tableName
							+ " SET	ws_status = '" + status + "' ,ws_remarks   = '" 
							+ remarks + "' WHERE trx_no  = '" + trxNo +"'";
		ArrayList<String> trxNoList = new ArrayList<String>();

		try
		{
			stmt = emDBConn.createStatement();
			if(isPurgeEnabled) 
			{
				purgeItemsStmt = emDBConn.createStatement();
				purgeXIInvTrnDtlsStmt = emDBConn.createStatement();
			}
			
			int itemsCount = items.length;
			
			for (int i = 0; i < itemsCount; i++)
			{
				status = items[i].getZUPDATEDSTATUS();
				remarks = items[i].getZTRNREMARK();
				trxNo = items[i].getZTRNID();
								
				tableName = (String)((HashMap)(tableMap.get(trxNo))).get("TABLENAME");				

				remarks = remarks.replaceAll("\"", "");
				remarks = remarks.replaceAll("\'", "");
				remarks = remarks.replaceAll("\n", " ");

				updateQry = "UPDATE "
							+ tableName
							+ " SET	ws_status = '" + status + "' ,ws_remarks = '" 
							+ remarks + "' WHERE trx_no  = '" + trxNo +"'";
				
				if(isPurgeEnabled)
				{
					purgeItemsQry = "DELETE " + tableName + " WHERE trx_no  = '" + trxNo +"' AND ws_status IS NOT NULL";
					purgeXIInvTrnDtls = "DELETE xh_interface_inv_trn_dtls WHERE ext_trn_id = '" + trxNo + "'";
					purgeItemsStmt.addBatch(purgeItemsQry);
					purgeXIInvTrnDtlsStmt.addBatch(purgeXIInvTrnDtls);
				}

			//	if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(ServiceDAO:updateSAPItemsStatus) Query : "+updateQry+"\n");

				stmt.addBatch(updateQry);
				trxNoList.add(trxNo);
			}

			int result[] = stmt.executeBatch();			
			int j = 0;
			boolean isErrorExist = false;		

			for(int i: result)
			{
				if(i < 1) 
				{
					common.fileOutput(clientParameters.strLogFile, "(ServiceDAO:updateSAPItemsStatus) Unable to update status for : "+items[j].getZTRNID()+"\n");
					isErrorExist = true;
				}
				j++;
			}
			if(!isErrorExist) common.fileOutput(clientParameters.strLogFile, "(ServiceDAO:updateSAPItemsStatus) Status updated successfully for "+trxNoList+"\n");
			emDBConn.commit();
			
			if(isPurgeEnabled)
			{
				int purgeResult[] = purgeItemsStmt.executeBatch();
				int xiInvTrnResult[] = purgeXIInvTrnDtlsStmt.executeBatch();
				j = 0;
				isErrorExist = false;		
	
				for(int i: purgeResult)
				{
					if(i < 1) 
					{
						common.fileOutput(clientParameters.strLogFile, "(ServiceDAO:updateSAPItemsStatus) Unable to purge : "+items[j].getZTRNID()+"\n");
						isErrorExist = true;
					}
					j++;
				}
				j = 0;
				for(int i: xiInvTrnResult)
				{
					if(i < 1) 
					{
						common.fileOutput(clientParameters.strLogFile, "(ServiceDAO:updateSAPItemsStatus) XH_INTERFACE_INV_TRN_DTLS deletion failed for "+items[j].getZTRNID()+"\n");						
					}
					j++;
				}
				if(!isErrorExist) common.fileOutput(clientParameters.strLogFile, "(ServiceDAO:updateSAPItemsStatus) Purge successfull...\n");
				emDBConn.commit();
				isSuccess = true;
			}
		}
		catch (Exception exp)
		{
			handleExceptions("(ServiceDAO:updateSAPItemsStatus) Exception: "+exp.getMessage(), exp);			
		}
		finally
		{
			SQLUtil.closeStatement(stmt);
			SQLUtil.closeStatement(purgeItemsStmt);
			SQLUtil.closeStatement(purgeXIInvTrnDtlsStmt);			
		}
		return isSuccess;
	}
	
	public boolean getPurgeStatus()
	{
		boolean isPurgeEnabled = false;
		String purgeStatusQry = "SELECT 1 FROM xi_param WHERE offline_purge_yn = 'Y'";
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			stmt = emDBConn.createStatement();
			rs = stmt.executeQuery(purgeStatusQry);
			
			if(rs.next()) 
			{
				isPurgeEnabled = true;
				common.fileOutput(clientParameters.strLogFile, "(ServiceDAO:updateSAPItemsStatus) Purge enabled....\n");
			}
			else
			{
				common.fileOutput(clientParameters.strLogFile, "(ServiceDAO:updateSAPItemsStatus) Purge disabled....\n");
			}
		}
		catch(Exception exp)
		{
			handleExceptions("(ServiceDAO:getPurgeStatus) Exception: "+exp.getMessage(), exp);
		}
		finally
		{
			SQLUtil.closeResource(rs, stmt);
		}
		
		return isPurgeEnabled;
	}
}
