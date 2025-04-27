/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR ;


import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;

import eCommon.SingleTableHandler.* ;

public class OrderStatusCode extends eOR.Common.OrAdapter implements Serializable {
	protected String order_status_code	= "" ;
	protected String long_desc			= "" ;
	protected String short_desc			= "" ;
	protected String order_status_type	= "" ;
	protected String order_status_desc	= "" ;

	/* Set Methods Start */
	public void setOrderStatusCode( String order_status_code ) {
		this.order_status_code = order_status_code  ;
	}
	public void setLongDesc( String long_desc ) {
		this.long_desc		= long_desc  ;
	}
	public void setShortDesc( String short_desc ) {
		this.short_desc		= short_desc  ;
	}
	public void setOrderStatusType( String order_status_type ) {
		this.order_status_type = order_status_type  ;
	}
	public void setOrderStatusDesc( String order_status_desc ) {
		this.order_status_desc = order_status_desc  ;
	}
	/* Set Methods End */

	/* Get Methods Start */
	public String getOrderStatusCode() {
		return this.order_status_code  ;
	}
	public String getLongDesc() {
		return this.long_desc  ;
	}
	public String getShortDesc() {
		return this.short_desc  ;
	}
	public String getOrderStatusType() {
		return this.order_status_type;
	}
	public String getOrderStatusDesc() {
		return this.order_status_desc;
	}
	/* Get Methods End */

    /* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception {
		//Connection connection 		= null;
		//PreparedStatement pstmt 	= null;
		//ResultSet resultSet 		= null;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;

		return map ;
	}

	public HashMap insert() {

      HashMap map = new HashMap() ;
	  StringBuffer tmpBuff	= new StringBuffer();
	   map.put( "result", new Boolean( false ) ) ;
       map.put( "flag", "true" ) ;

	   ArrayList insertData = new ArrayList() ;
		  insertData.add( order_status_code ) ;
		  insertData.add( long_desc ) ;
		  insertData.add( short_desc ) ;
		  insertData.add( order_status_type ) ;
		  insertData.add( login_by_id ) ;
		  insertData.add( login_at_ws_no ) ;
		  insertData.add( login_facility_id ) ;
		  insertData.add( login_by_id ) ;
		  insertData.add( login_at_ws_no ) ;
		  insertData.add( login_facility_id ) ;

	  ArrayList whereData = new ArrayList() ;
		 whereData.add( order_status_code ) ;

	  HashMap tabData = new HashMap() ;
		tabData.put( "InsertData", insertData);
		tabData.put( "WhereData", whereData);
		tabData.put( "properties",	getProperties() ) ;

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SelectSQL", OrRepository.getOrKeyValue("SQL_OR_ORDER_STATUS_CODE_DUPLICATE_SELECT") );
			sqlMap.put( "InsertSQL", OrRepository.getOrKeyValue("SQL_OR_ORDER_STATUS_CODE_INSERT") );
		}catch(Exception e){e.printStackTrace() ;
		}

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
				home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabData;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabData.getClass();
					paramArray[1]	= sqlMap.getClass();

				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);		
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
				}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
			/*try {
					if( remote != null ) remote.remove() ;
				} catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}*/
			}
			return map ;
	} // end of insert



	public HashMap modify() {

      HashMap map = new HashMap() ;
	 StringBuffer tmpBuff = new StringBuffer();

	 ArrayList modifyData = new ArrayList() ;

        modifyData.add( login_by_id ) ;
		modifyData.add( login_at_ws_no ) ;
		modifyData.add( login_facility_id ) ;
		modifyData.add( long_desc ) ;
		modifyData.add( short_desc ) ;

		modifyData.add( order_status_code ) ;
		modifyData.add( order_status_type ) ;

	  	HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);
	  	HashMap sqlMap = new HashMap() ;

	  	try{
			sqlMap.put( "ModifySQL",  OrRepository.getOrKeyValue("SQL_OR_ORDER_STATUS_CODE_UPDATE") );
		}catch(Exception e){e.printStackTrace() ;
		}

		//SingleTableHandlerHome home		= null;
		//SingleTableHandlerRemote remote = null;
		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
				home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabData;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabData.getClass();
					paramArray[1]	= sqlMap.getClass();

				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);		
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

				map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				map.put("traceVal", (String)tmpBuff.toString());

			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} /*finally {
				try {
						//if( remote != null ) remote.remove() ;
					} catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
			}
		}*/
		//map.put("traceVal", (String)tmpBuff.toString());
		return map ;
	} // end of update

	public void clear() {
		order_status_code	= "";
		long_desc			= "";
		short_desc			= "";
		order_status_type	= "";

		super.clear() ;
	}

	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("order_status_code"))
			setOrderStatusCode((String)recordSet.get("order_status_code")) ;
		if(recordSet.containsKey("long_desc"))
			setLongDesc((String)recordSet.get("long_desc")) ;
		if(recordSet.containsKey("short_desc"))
			setShortDesc((String)recordSet.get("short_desc")) ;
		if(recordSet.containsKey("order_status_type"))
			setOrderStatusType((String)recordSet.get("order_status_type")) ;
		if(recordSet.containsKey("order_status_desc"))
			setOrderStatusDesc((String)recordSet.get("order_status_desc")) ;
	}
	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
 	public String getStatusTypeDesc(String order_status_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String OrderStatusTypeDesc = "";
		try {
			//setConnection() ;
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_STATUS_CODE_STATUS_TYPE_SELECT") ) ;
			pstmt.setString( 1, order_status_type);
			resultSet	= pstmt.executeQuery() ;
			String OrderStatusTypeCode = "";
			String OrderStatusTypeShortDesc = "";
			while ( resultSet != null && resultSet.next() ) {
					OrderStatusTypeCode			= resultSet.getString( "order_status_type" )  ;
					OrderStatusTypeShortDesc	= resultSet.getString( "short_desc" )  ;
			}
			OrderStatusTypeDesc = OrderStatusTypeCode + "||"+OrderStatusTypeShortDesc;
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			//returnConnection() ;
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return OrderStatusTypeDesc;
	}

// get the values in the query screen to display all the descr. and value
public String getOrderStatusValues() {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
	try
		{
			connection		= getConnection();
			pstmt			= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_STATUS_CODE_STATUS_TYPE_QUERY_SELECT"));
			resultSet		= pstmt.executeQuery() ;
			StringBuffer sb	= new StringBuffer();
			while (resultSet!=null && resultSet.next())
			{
				String  value			= resultSet.getString(1);
				String  description		= resultSet.getString(2);
				sb.append(value+ "," + description + ",");
			}
			 String str =   sb.toString() ;
			 return str.substring(0, str.length()-1);
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
		finally
		{
			try
			 {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			 }catch(Exception e){e.printStackTrace() ;
			 }
		}
}
/* Function specific methods start */
	public void loadData() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		try {
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_STATUS_CODE_SELECT") ) ;
				pstmt.setString( 1, getOrderStatusCode().trim() ) ;
				pstmt.setString( 2, getOrderStatusType().trim() );
				resultSet	= pstmt.executeQuery() ;

				if ( resultSet != null && resultSet.next() ) {
					setLongDesc( resultSet.getString(	"long_desc" ) ) ;
					setShortDesc( resultSet.getString(	"short_desc" ) ) ;
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
		}
	/* Function specific methods end */
}
