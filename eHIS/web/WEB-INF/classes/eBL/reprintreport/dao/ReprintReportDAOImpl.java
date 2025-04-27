/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           NandhiniM
2            V210610             20052        	MMS-MD-SCF-0161-TP         	   MuthukumarN
3            V210615             20043        	MMS-MD-SCF-0161-TP         	   MuthukumarN
 */
package eBL.reprintreport.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlRepository;
import eBL.reprintreport.request.ReprintRequest;
import eBL.reprintreport.response.ReprintResponse;

/**
 * @author Rajesh V
 *	This file connects with Database to insert the data to sy_prog_param table 
 *	to generate Reports
 */
public class ReprintReportDAOImpl implements ReprintReportDAO {

	/**
	 * This Method Inserts the data to sy_prog_param table.
	 * This Method is called for printing multiple bills
	 *
	 */
	public ReprintResponse insertToProgParamBulk(ReprintRequest request) {
		ReprintResponse response = new ReprintResponse();
		Connection con = null;
		CallableStatement cstmt = null;
		List<ReprintRequest> requestList = request.getRequestList();
		boolean toBeInserted = true;
		boolean forOnce=true;
		PreparedStatement pstmt = null;
		String billPrintTempQuery = "Insert into BL_BILL_PRINT_TEMP(OPERATING_FACILITY_ID,DOC_TYPE_CODE,DOC_NUM,SESSION_ID,PGM_DATE,PGM_ID) values(?,?,?,?,?,?)";

		try{
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);
			response.setStatus(true);
			String insertSql = BlRepository.getBlKeyValue("INSERT_SY_PROG_PARAM");
			pstmt = con.prepareCall(billPrintTempQuery);
			
			for (Iterator iterator = requestList.iterator(); iterator.hasNext();) {
				ReprintRequest reprintRequest = (ReprintRequest) iterator.next();
				/*
				 * This Condition is used to restrict that only first bill data, gets inserted
				 * in sy_prog_param table.
				 */
				if(toBeInserted){
					cstmt = con.prepareCall(insertSql);
					cstmt.setString(1, reprintRequest.getFacilityId());
					cstmt.setString(2, reprintRequest.getReportId());
					cstmt.registerOutParameter(3, Types.INTEGER);
					cstmt.registerOutParameter(4, Types.VARCHAR);
					/*
					 * For Param 5,6,7,8 null is inserted instead of Doc No and Doc Type
					 * to enable multi print 
					 */
					cstmt.setString(5, null);
					cstmt.setString(6, null);
					cstmt.setString(7, null);
					cstmt.setString(8, null);
					cstmt.setString(9, reprintRequest.getParam5());
					cstmt.setString(10, reprintRequest.getParam6());
					cstmt.setString(11, reprintRequest.getParam7());
					cstmt.setString(12, reprintRequest.getParam8());
					cstmt.setString(13, reprintRequest.getParam9());
					cstmt.setString(14, reprintRequest.getParam10());
					cstmt.setString(15, reprintRequest.getParam11());
					cstmt.setString(16, reprintRequest.getParam12());
					cstmt.setString(17, reprintRequest.getParam13());
					cstmt.setString(18, reprintRequest.getParam14());
					cstmt.setString(19, reprintRequest.getParam15());
					cstmt.setString(20, reprintRequest.getParam16());
					cstmt.setString(21, reprintRequest.getParam17());
					cstmt.setString(22, reprintRequest.getParam18());
					cstmt.setString(23, reprintRequest.getParam19());
					cstmt.setString(24, reprintRequest.getParam20());
					cstmt.setString(25, reprintRequest.getParam21());
					cstmt.setString(26, reprintRequest.getParam22());
					cstmt.setString(27, reprintRequest.getParam23());
					cstmt.setString(28, reprintRequest.getParam24());
					cstmt.setString(29, reprintRequest.getParam25());
					cstmt.setString(30, reprintRequest.getParam26());
					cstmt.setString(31, reprintRequest.getParam27());
					cstmt.setString(32, reprintRequest.getParam28());
					cstmt.setString(33, reprintRequest.getParam29());
					cstmt.setString(34, reprintRequest.getParam30());
					cstmt.execute();
					
					response.setSessionId(cstmt.getString(3));
					response.setPgmDate(cstmt.getString(4));
				}
				
				if(forOnce==true){
				ReprintResponse status = deleteBillPrintTemp(reprintRequest, response.getSessionId(), con);
				toBeInserted = false;
					if(!status.isStatus()){
						response.setStatus(false);
						response.setError(status.getError());
						break;
					}
				forOnce=false;	
				}
				
				ReprintResponse status = insertToBillPrintTemp(reprintRequest, response.getSessionId(), response.getPgmDate(), pstmt);
				toBeInserted = false;
				if(!status.isStatus()){
					response.setStatus(false);
					response.setError(status.getError());
					break;
				}				
			}
			if(response.isStatus()){
				con.commit();
				System.err.println("Committed");
			}
			else{
				con.rollback();
			}
		}
		catch(Exception e){
			System.err.println("Exception in Reprint DAO->"+e);
			response.setError(e.toString());
			e.printStackTrace();
			try{
				con.rollback();
			}			
			catch(Exception SE){
				SE.printStackTrace();
			}
		}
		finally{
			//if(pstmt!=null){//V210610
				try {
					if(pstmt!=null) pstmt.close();
					if(cstmt!=null) cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		//}//V210615
			//cstmt = null;//V210610
			if(con!=null){
				ConnectionManager.returnConnection(con);
			}
		}
		return response;
	}

	/**
	 * This Method deletes data from BL_BILL_PRINT_TEMP before inserting fresh Data to Resolve Session Issues
	 *  Method gets called for all the bills.
	 * @throws SQLException 
	 */
	public ReprintResponse deleteBillPrintTemp(ReprintRequest request,String sessionId,Connection con) throws SQLException{
		ReprintResponse status = new ReprintResponse();
		PreparedStatement pstmt = null;
		String billPrintTempQuery = "DELETE FROM BL_BILL_PRINT_TEMP WHERE SESSION_ID = ? AND OPERATING_FACILITY_ID = ?";
		try{
			pstmt = con.prepareCall(billPrintTempQuery);
			pstmt.setString(1, sessionId);
			pstmt.setString(2, request.getFacilityId());
			pstmt.execute();
			status.setStatus(true);
		}
		catch(Exception e){
			System.err.println("Exception in deleteBillPrintTemp ->"+e);
			status.setError(e.toString());
			status.setStatus(false);
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null) pstmt.close();
		}
		return status;
	}
 
	/**
	 * This Method inserts data to BL_BILL_PRINT_TEMP. 
	 *  Method gets called for all the bills.
	 * @throws SQLException 
	 */
	public ReprintResponse insertToBillPrintTemp(ReprintRequest request,String sessionId,String pgmDate,PreparedStatement pstmt) throws SQLException{
		ReprintResponse status = new ReprintResponse();
		try{
			pstmt.setString(1, request.getFacilityId());
			pstmt.setString(2, request.getParam1());
			pstmt.setString(3, request.getParam3());
			pstmt.setString(4, sessionId);
			pstmt.setString(5, pgmDate);
			pstmt.setString(6, request.getReportId());
			pstmt.execute();
			status.setStatus(true);
		}
		catch(Exception e){
			System.err.println("Exception in insertToBillPrintTemp ->"+e);
			status.setError(e.toString());
			status.setStatus(false);
			e.printStackTrace();
		}
		/*Added against V210416 & Commented against V210610
			finally{
			if(pstmt!=null) pstmt.close();
		} 
		//Added against V210416 & Commented against V210610*/
		return status;
	}
}
