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
import javax.ejb.* ;

import eCommon.Common.*;
import eOR.Common.* ;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class AccessionNumberRules extends OrAdapter implements java.io.Serializable {
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
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}


/**
	This will set all the values to the HashMap, which further passsed as an input to the EJB
	@return		:	HashMap
*/

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;

		try{
			insertData.add(order_category);
			insertData.add(order_type);
			insertData.add(prefix);
			insertData.add(frmat);
			insertData.add(srl_num ) ;
			insertData.add(srl_num ) ;
			insertData.add(login_by_id ) ;
			insertData.add(login_at_ws_no ) ;
			insertData.add(login_facility_id ) ;
			insertData.add(login_by_id ) ;
			insertData.add(login_at_ws_no ) ;
			insertData.add(login_facility_id ) ;


			whereData.add(order_category) ;
			whereData.add(order_type) ;

			sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_ACCESSION_NUMBER_RULE_INSERT1") );
			sqlMap.put("SelectSQL",OrRepository.getOrKeyValue("SQL_OR_ACCESSION_NUMBER_RULE_DUP_CHK1"));

			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);
			tabData.put("Dup", OrRepository.getOrKeyValue("SQL_OR_ACCESSION_NUMBER_RULE_DUP_CHK1"));
			tabData.put("Ins", OrRepository.getOrKeyValue("SQL_OR_ACCESSION_NUMBER_RULE_INSERT1") );
			map.put("traceVal", tabData.toString());
		}catch(Exception e){
			e.printStackTrace() ;
		}
			return getResult(tabData,sqlMap) ;
		//return map;



	}

/**********This Method  Actually Calls the EJB's Method ********************/
private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
		HashMap map  = new HashMap() ;
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;

		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
			home		 = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote		 = home.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
				paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlMap.getClass();

			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) {
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
				//map = remote.insert(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);		

			}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				// map = remote.modify(tabData, sqlMap ) ;
					map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);		
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

			
			String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
		 if( result ) 
		{
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
		}
        else
		{
			map.put( "result", new Boolean( false ) ) ;
            if( message.equals( "CODE_ALREADY_EXISTS" ) )
			{
				
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common") ) ;
				
				
				/*map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;*/
				

			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }

		  

	  }
	  catch(Exception e)
	  {
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;		
	  }
return map;
 }//End of Method



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
