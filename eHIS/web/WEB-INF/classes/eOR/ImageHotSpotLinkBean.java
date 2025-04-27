/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;
import eOR.Common.* ;

import eCommon.Common.*;
import eCommon.SingleTableHandler.*;


public class ImageHotSpotLinkBean extends eOR.Common.OrAdapter implements java.io.Serializable {

	protected String image_id			= "";
	protected String hotspot_id		= "";
	protected String image_link		= "";

	StringBuffer traceVals = new StringBuffer();


	public void setImage(String image){
		this.image_id = image;
	}
	public void setHotSpot(String hotspot){
		this.hotspot_id = hotspot;
	}
	public void setImageLink(String image_link){
		this.image_link = image_link;
	}


	public  String getImage(){
		return image_id;
	}
	public  String getHotSpot(){
		return hotspot_id;
	}
	public String getImageLink(String image_link){
		return image_link;
	}


/**
	This will get all the Image Names and Id
	@return		:	ArrayList
*/

	public ArrayList getImageNames() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList updateOrders = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_SELECT_IMAGE_NAME") ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[2];
				record[0] = resultSet.getString("image_id");
				record[1] = resultSet.getString("image_name");
				updateOrders.add(record);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return updateOrders;
	}


/**
	This will get all the Hotspot name and Id for the particulat image Id
	@param		:	String image_id
	@return		:	ArrayList
*/
	public ArrayList getHotSpotNames(String image_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList updateOrders = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_SELECT_HOTSPOT") ) ;
			pstmt.setString(1, image_id.trim());
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[2];
				record[0] = resultSet.getString("hotspot_id");
				record[1] = resultSet.getString("hotspot_name");
				updateOrders.add(record);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return updateOrders;
	}


/**
	This will get image Name, hotspot name and image link id based on image id and hotspot id
	@param		:	String image_id
	@param		:	String hotspot_id
	@return		:	String[]
*/
	public String[] getValues(String image_id, String hotspot_id, String image_link_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;
			
			String record[] = new String[3];
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_GET_VALUES") ) ;
				pstmt.setString(1, image_id.trim());
				pstmt.setString(2, hotspot_id.trim());
				pstmt.setString(3, image_link_id.trim());

				/*System.out.println("SQL_OR_IMAGE_HOTSPOT_LINK_GET_VALUES >>> "+OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_GET_VALUES"));
				System.out.println(image_id);
				System.out.println(hotspot_id);
				System.out.println(image_link_id);
*/
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					record[0] = resultSet.getString("image_name");
					record[1] = resultSet.getString("hotspot_name");
 				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}
			return record;
	}



/**
	This will set all the values to the HashMap, which further passsed as an input to the EJB
	@return		:	HashMap
*/

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;

		try{
			insertData.add(image_id);
			insertData.add(hotspot_id);
			insertData.add(image_link);
			insertData.add(login_by_id ) ;
			insertData.add(login_at_ws_no ) ;
			insertData.add(login_facility_id ) ;
			insertData.add(login_by_id ) ;
			insertData.add(login_at_ws_no ) ;
			insertData.add(login_facility_id ) ;


			whereData.add(image_id) ;
			whereData.add(hotspot_id) ;
			whereData.add(image_link) ;

			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			map.put("traceVal", tabData.toString());

			sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_INSERT") );
			sqlMap.put("SelectSQL",OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_DUP_CHK1"));
		}catch(Exception e){
			System.err.println("Insert Method"+ e);
		}
			return getResult(tabData,sqlMap) ;
	}


/**
	This method will delete the record
	Before the deletion, a check is made for the usage of the image link id in the catalog. In such cases, the deletion using this fucntion is not possible
	This will set all the values to the HashMap, which further passsed as an input to the EJB

*/
	public HashMap delete() {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_DELETE_CHK") ) ;
			pstmt.setString(1, image_link.trim());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() ) {
				map.put( "result", new Boolean( false ) ) ;
				//map.put( "message", "Code Already Exists.." ) ;
				map.put( "message", "HOTSPOT_IMAGE_LINK_CATALOG"  );
				return map;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
		} catch(Exception ee) {System.err.println("Delete Method"+ ee);}
			
		}


		ArrayList deleteData = new ArrayList() ;

		deleteData.add( image_id.trim() ) ;
		deleteData.add( hotspot_id.trim() ) ;
		deleteData.add( image_link.trim() ) ;

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "DeleteData",deleteData);

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "DeleteSQL", OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_DELETE") );
		}catch(Exception e){
			e.printStackTrace();
		}
			return getResult(tabData,sqlMap) ;

	}



	public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		return map;
	}

/**********This Method  Actually Calls the EJB's Method ********************/
private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
		HashMap map  = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;

		try
		{
			/********************LOOK UP*************************/
		/*	InitialContext context = new InitialContext() ;
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
			//System.out.println("===========================mode========"+mode);
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) {
				//map = remote.delete( tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);	
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
				//map = remote.insert(tabData, sqlMap ) ;
				//System.out.println("===========================tabData========"+tabData);
				//System.out.println("===========================sqlMap========"+sqlMap);
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);	
				//System.out.println("===========================map========"+map);
				
			}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				// map = remote.modify(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);	
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;
			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
				map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
			}else 
			{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
				{
					//map.put( "message", ((String) map.get("msgid"))) ;
				map.put( "message", getMessage(language_id, "IMAGE_LINK_ALREADY_EXISTS", "OR")) ;
				}
		
			}
			map.put("traceVal", (String)tmpBuff.toString());
			tmpBuff.setLength(0);

			//String message = (String)map.get("msgid");
			//if(message.equals("CODE_ALREADY_EXISTS"))
				//message = "IMAGE_LINK_ALREADY_EXISTS";
			//map.put("message",message);

		  return map;

	  }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	  }

 }//End of Method

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {

		if(recordSet.containsKey("image")){
			setImage((String)recordSet.get( "image" ));
		}
		if(recordSet.containsKey("hot_spot")){
			setHotSpot((String)recordSet.get( "hot_spot" ));
		}
		if(recordSet.containsKey("image_link")){
			setImageLink((String)recordSet.get( "image_link" ));
		}

		this.mode = (String)recordSet.get( "mode" );

	}

/**
	This will clear all the values of all bean variables
	@return		:	void
*/

	public void clear() {
		image_id		= "";
		hotspot_id		= "";
		image_link		= "";
		super.clear() ;
	}
}
