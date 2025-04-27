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
package eIPAD.chartsummary.common.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eIPAD.chartsummary.common.response.ErrorInfo;

import webbeans.eCommon.ConnectionManager;

/**
 * @author SaraswathiR
 *
 */
public abstract class GenericDAOImpl {
	

	
	public Connection createConnection(){
		Connection conn = ConnectionManager.getConnection();
		return conn;
	}
	
	public int closeConnection(Connection con,Statement stmt,ResultSet rs){
		int conCloseFailure = 0;
		try{
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(con!=null)
				ConnectionManager.returnConnection(con);
		}
		catch(SQLException e){
			conCloseFailure = 1;
		}
			
		return conCloseFailure;
		
	}
	public int closeConnection(Connection con){
		int conCloseFailure = 0;
		if(con!=null)
			ConnectionManager.returnConnection(con);
		return conCloseFailure;

	}
	public int closeConnection(Statement pstmt) {
		int conCloseFailure = 0;
		try{
			if(pstmt!=null)
				pstmt.close();
		}
		catch(SQLException e){
			conCloseFailure = 1;
		}
		return conCloseFailure;
	}
	public int closeConnection(ResultSet rs){
		int conCloseFailure = 0;
		try{
			if(rs!=null)
				rs.close();
		}
		catch(SQLException e){
			conCloseFailure = 1;
		}
		return conCloseFailure;
	}

}
