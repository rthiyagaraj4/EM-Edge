/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eCommon.Common.*;
import eOR.Common.* ;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class ORReportsConsolidatedOrderList extends OrAdapter implements java.io.Serializable {
	protected String order_category			= "";
	protected String order_category_desc	= "";
	protected String order_type				= "";
	protected String order_type_desc		= "";
	protected String prefix						= "";
	protected String frmat			 			= "";
	protected String srl_num					= "";

	StringBuffer traceVals = new StringBuffer();


	public void setOrderCategory(String order_category){
		this.order_category = order_category;
	}
	public void setOrderCategoryDesc(String order_category_desc){
		this.order_category_desc = order_category_desc;
	}
	public void setOrderType(String order_type){
		this.order_type = order_type;
	}
	public void setOrderTypeDesc(String order_type_desc){
		this.order_type_desc = order_type_desc;
	}
	public void setPrefix(String prefix){
		this.prefix = prefix;
	}
	public void setFrmat(String frmat){
		this.frmat= frmat;
	}
	public void setSrlNum(String srl_num){
		this.srl_num= srl_num;
	}
	public void setMode(String mode){
		this.mode = mode;
	}


	public String getOrderCategory(){
		return order_category;
	}
	public String getOrderCategoryDesc(){
		return order_category_desc;
	}
	public String getOrderType(){
		return order_type;
	}
	public String getOrderTypeDesc(){
		return order_type_desc;
	}
	public String getPrefix(){
		return prefix;
	}
	public String getFrmat(){
		return frmat;
	}
	public String getSrlNum(){
		return srl_num;
	}
	public String getMode(){
		return mode;
	}


/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getOrderTypeData(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_SELECT_ORDER_TYPE") ) ;
			pstmt.setString( 1, order_category ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return OrderCat;
	}

/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getAllOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return OrderCat;
	}


/**
	This will populate all the Order Types
	@return		:	ArrayList
*/

	public ArrayList getAllOrderType() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_ORDER_TYPE")) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return OrderCat;
	}

    public ArrayList getAllOrderStatus() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REPORTS_CONS_ORDER_LIST_STATUS_SELECT")) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_status_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return OrderCat;
	}

	 

/**
	This will set all the values to the HashMap, which further passsed as an input to the EJB
	@return		:	HashMap
*/

	public HashMap insert(){
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;

	}



/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {

		if(recordSet.containsKey("order_type")){
			setOrderType((String)recordSet.get( "order_type" ));
		}
		if(recordSet.containsKey("order_category")){
			setOrderCategory((String)recordSet.get( "order_category" ));
		}
		if(recordSet.containsKey("prefix")){
			setPrefix((String)recordSet.get( "prefix" ));
		}
		if(recordSet.containsKey("frmat")){
			setFrmat((String)recordSet.get( "frmat" ));
		}
		if(recordSet.containsKey("srl_num")){
			setSrlNum((String)recordSet.get( "srl_num" ));
		}
			this.mode = (String)recordSet.get( "mode" );

	}

/**
	This will clear all the values of all bean variables
	@return		:	void
*/

	public void clear() {
		order_category	= "";
		order_type			= "";
		prefix					= "";
		frmat			 		= "";
		srl_num				= "";
		super.clear() ;
	}
}
