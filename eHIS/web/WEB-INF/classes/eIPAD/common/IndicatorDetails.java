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

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import webbeans.eCommon.ConnectionManager;

/**
 * @author GRamamoorthy
 *
 */
public class IndicatorDetails implements Serializable {

	
	/**
	 * Default constructor of the class
	 */
	public IndicatorDetails() {
	}

	/**
	 * This method is used to return all the different indicators available
	 * in the database
	 * The values returned will be ‘H’,’L’,’A’,’C’,’G’,’S’ inside the response object
	 * @param indicatorRequest
	 * @return
	 */
	public IndicatorDetailResponse getIndicatorDetails(IndicatorDetailRequest indicatorRequest){
		IndicatorDetailResponse indicatorResponse = new IndicatorDetailResponse();
		// safe check
		if(indicatorRequest == null){
			return indicatorResponse;
		}
		// initialize connection
		HttpServletRequest servletRequest = indicatorRequest.getRequest();
		Connection conn = null;
		conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return indicatorResponse;
		}
		// form the query string
		String queryString = "SELECT high_str,low_str,abn_str,crit_str,crit_high_str,crit_low_str FROM cr_clin_event_param";
		Statement stmt = null;
		ResultSet rs = null;
		// execute the query and process the result
		// for this query, setting the indicator list alone
		// in the response is enough
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			if(rs != null){
				List<String> indicatorList = new ArrayList<String>();
				while(rs.next()){
					indicatorList.add(rs.getString(1));
				}
				indicatorResponse.setIndicatorValueList(indicatorList);
			}
		
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to properly handle this
			 */
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					ConnectionManager.returnConnection(conn);
			}
			catch(SQLException e){
			}
			
		}
		
		
		return indicatorResponse;
	}
	
	
	/**
	 * 
	 * @param indicatorRequest
	 * @return
	 */
	public IndicatorDetailResponse getAbnormalIndicators(IndicatorDetailRequest indicatorRequest){
		IndicatorDetailResponse indicatorResponse = new IndicatorDetailResponse();
		// safe check
		if(indicatorRequest == null){
			return indicatorResponse;
		}
		// initialize connection
		HttpServletRequest servletRequest = indicatorRequest.getRequest();
		Connection conn = null;
		conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return indicatorResponse;
		}
		// form the query string
		String queryString = "select ''''|| HIGH_STR   || '''' ||','||''''|| LOW_STR ||''''|| ','||''''|| ABN_STR|| ''''  from cr_clin_event_param";
		Statement stmt = null;
		ResultSet rs = null;
		// execute the query and process the result
		// for this query, set the indicator value
		// in the response object and call the method to process 
		// the indicator value to a list of string values
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			if(rs != null){
				String indicatorValue = null;
				while(rs.next()){
					indicatorValue = rs.getString(1);
				}
 
				indicatorResponse.setIndicatorValue(indicatorValue);
				indicatorResponse.setDelimiter(",");
				indicatorResponse.populateIndicatorList();
			}
		
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to properly handle this
			 */
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					ConnectionManager.returnConnection(conn);
			}
			catch(SQLException e){
			}
			
		}
		
		return indicatorResponse;
	}
	
	/**
	 * 
	 * @param indicatorRequest
	 * @return
	 */
	public IndicatorDetailResponse getCriticalIndicators(IndicatorDetailRequest indicatorRequest){
		IndicatorDetailResponse indicatorResponse = new IndicatorDetailResponse();
		// safe check
		if(indicatorRequest == null){
			return indicatorResponse;
		}
		// initialize connection
		HttpServletRequest servletRequest = indicatorRequest.getRequest();
		Connection conn = null;
		conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return indicatorResponse;
		}
		// form the query string
		String queryString = "select ''''|| CRIT_STR   || '''' ||','||''''|| CRIT_HIGH_STR ||''''|| ','||''''|| CRIT_LOW_STR|| ''''  from cr_clin_event_param";
		Statement stmt = null;
		ResultSet rs = null;
		// execute the query and process the result
		// for this query, set the indicator value
		// in the response object and call the method to process 
		// the indicator value to a list of string values
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			if(rs != null){
				String indicatorValue = null;
				while(rs.next()){
					indicatorValue = rs.getString(1);
				}
 
				indicatorResponse.setIndicatorValue(indicatorValue);
				indicatorResponse.setDelimiter(",");
				indicatorResponse.populateIndicatorList();
			}
		
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to properly handle this
			 */
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					ConnectionManager.returnConnection(conn);
			}
			catch(SQLException e){
			}
			
		}
		return indicatorResponse;
	}
	
	
}
