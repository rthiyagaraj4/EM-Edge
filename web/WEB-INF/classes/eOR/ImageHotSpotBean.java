/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.ejb.* ;
import eCommon.Common.*;
import javax.rmi.* ;
import javax.naming.* ;
import eOR.Common.* ;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class ImageHotSpotBean extends eOR.Common.OrAdapter implements java.io.Serializable {
	//StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVals = new StringBuffer() ;
	//Connection connection = null ;
	//PreparedStatement pstmt = null ;

	protected String image_id		= "";
	protected String hotspot_id		= "";
	protected String hotspot_name	= "";
	protected String hotspot_pos	= "";
	protected String x_pos	= "";
	protected String y_pos	= "";
	protected String fpp_yn	= "";//IN072524
	//protected String function_id	= "";
	//protected Hashtable  hashMultiple=null		;
	//IN072524 Starts
	public String getFpp_yn() {
		return fpp_yn;
	}
	public void setFpp_yn(String fpp_yn) {
		this.fpp_yn = fpp_yn;
	}
	//IN072524 Starts
	public void setImageID(String image_id){
		this.image_id =image_id ;
	}
	public void setHotspotID(String hotspotid){
		this.hotspot_id =hotspotid ;
	}
	public void setHotspotName(String hotspot_name){
		this.hotspot_name =hotspot_name;
	}
	public void setHotspotPos(String hotspot_pos){
		this.hotspot_pos =hotspot_pos;
	}
	public void setFunctionID(String function_id){
		this.function_id=function_id;
	}
	public void setXPos(String x_pos){
		this.x_pos =x_pos;
	}
	public void setYPos(String y_pos){
		this.y_pos =y_pos;
	}

	public String  getImageID(){
		return image_id;
	}
	public String getHotSpotID(){
		return hotspot_id;
	}

	public String getHotspotName(){
		return hotspot_name;
	}
	public String getXPos(){
		return x_pos;
	}
	public String getYPos(){
		return y_pos;
	}

	public ArrayList getImageOnLoad() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;


		ArrayList image = new ArrayList() ;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOT_SPOT_IMAGE_SELECT")) ;
			resultSet	= pstmt.executeQuery() ;
			String[] record=null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[3];
					record[0] = resultSet.getString( "image_id" )  ;
					record[1] = resultSet.getString( "image_name" )  ;
					record[2] = resultSet.getString( "image_url" )  ;
				image.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database Or_image" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return image;
	}
	public ArrayList getHotspotImage(String image_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;


		ArrayList image = new ArrayList() ;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOT_SPOT_IMAGE_LOAD")) ;
			pstmt.setString(1,image_id);
			resultSet	= pstmt.executeQuery() ;
			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[5];
					record[0] = resultSet.getString( "hotspot_name" )  ;
					record[1] = resultSet.getString( "hotspot_id" )  ;
				   	record[2] = resultSet.getString( "hotspot_pos" )  ;
				   	record[3] = resultSet.getString( "hotspot_xpos" )  ;
				   	record[4] = resultSet.getString( "hotspot_ypos" )  ;
				image.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database Or_image" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return image;
	}

//	public String[] loadDataModify(String imageId,String hotSpotPos,String hotSpot_xPos,String hotSpot_yPos) throws Exception {
	public String[] loadDataModify(String imageId,String hotSpot_xPos,String hotSpot_yPos) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;


		String[] image = new String[5];//IN072524

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOT_SPOT_DATA_MODIFY")) ;
			//pstmt		= connection.prepareStatement( "select hotspot_name,hotspot_id,hotspot_xpos,hotspot_ypos from or_image_hotspot where image_id=?  and hotspot_xpos=? and hotspot_ypos=?") ;
			pstmt.setString(1,imageId);
			//pstmt.setString(2,hotSpotPos);
			pstmt.setString(2,hotSpot_xPos);
			pstmt.setString(3,hotSpot_yPos);
			resultSet	= pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
					image[0] = resultSet.getString( "hotspot_name" )  ;
					image[1] = resultSet.getString( "hotspot_id" )  ;
					image[2] = resultSet.getString( "hotspot_xpos" )  ;
					image[3] = resultSet.getString( "hotspot_ypos" )  ;
					image[4] = resultSet.getString( "FPP_YN" )  ;//IN072524
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database Or_image" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return image;
	}



	public HashMap insert(){

		HashMap tabDataParam =  new HashMap() ;
		HashMap sqlMap = new HashMap();
		ArrayList tabDataInsert = new ArrayList() ;
		ArrayList tabData1 = new ArrayList() ;


		try{
			tabDataInsert.add(image_id);
			tabDataInsert.add(hotspot_id) ;
			tabDataInsert.add(hotspot_name) ;
			tabDataInsert.add(hotspot_pos) ;
			tabDataInsert.add(fpp_yn) ;//IN072524 

			tabDataInsert.add(((String)login_by_id).trim()) ;
			tabDataInsert.add(((String)login_at_ws_no).trim()) ;
			tabDataInsert.add(((String)login_facility_id).trim()) ;
			tabDataInsert.add(((String)login_by_id).trim()) ;
			tabDataInsert.add((String)login_at_ws_no.trim()) ;
			tabDataInsert.add((String)login_facility_id.trim()) ;
			tabDataInsert.add(x_pos) ;
			tabDataInsert.add(y_pos) ;

			tabData1.add(image_id);
			tabData1.add(hotspot_id);

			tabDataParam.put( "InsertData", tabDataInsert);
			tabDataParam.put( "WhereData",tabData1);
			tabDataParam.put( "properties", getProperties() );


			sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOT_SPOT_INSERT"));
			sqlMap.put("SelectSQL",OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOT_SPOT_DUPLICATE_CHECK"));
		}catch(Exception e){e.printStackTrace();
		}

		return  getResult(tabDataParam,sqlMap) ;

	}
	public HashMap modify() {

		HashMap dataMap = new HashMap() ;
		//HashMap whereData = new HashMap() ;
		//ArrayList tabdataK = new ArrayList() ;

		ArrayList tabData  = new ArrayList() ;

		tabData.add( hotspot_name) ;
		tabData.add(image_id);
		tabData.add( hotspot_id) ;

		HashMap sqlMapUp = new HashMap() ;

		try{
			sqlMapUp.put( "ModifySQL",OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOT_SPOT_SCOPE_MODIFY"));
		}catch(Exception e){e.printStackTrace();}

		dataMap.put("properties", getProperties() );
		dataMap.put("ModifyData",tabData);

		return getResult(dataMap,sqlMapUp);

	 }


  	public HashMap delete(){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOT_SPOT_DATA_DELETE_CHK") ) ;
			pstmt.setString(1, image_id.trim());
			pstmt.setString(2, hotspot_id.trim());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() ) {
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", "HOTSPOT_IMAGE_LINK"  );
				return map;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}finally{
		try{  
			closeResultSet(resultSet);
			closeStatement(pstmt);
            closeConnection(connection);
            }catch(Exception e){e.printStackTrace() ;}
		}

		HashMap sqlMap = new HashMap() ;
		ArrayList  tabdata = new ArrayList () ;

		tabdata.add(image_id);
		tabdata.add(hotspot_id) ;

		map.put( "result", new Boolean( false ) ) ;
		map.put( "properties",	getProperties()) ;
		map.put( "DeleteData",	tabdata) ;


		try{
		sqlMap.put( "DeleteSQL", OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOT_SPOT_DATA_DELETE") );

		}catch(Exception e){	   System.err.println(e);	}
		return getResult(map,sqlMap);

	}



	private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
		HashMap map  = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;

		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;
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

			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE" )) ) {
				//map = remote.delete(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);		
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
				//map = remote.insert(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);		
			}else if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				// map = remote.modify(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);		
			}

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


			//String message = (String)map.get("msgid");
			//map.put("message",message.toString());
			//map.put("traceVal",traceVals.toString());
		  return map;

	  }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	  }

	}//End of Method


	public void clear() {
		image_id 			="" ;
		hotspot_id			="" ;
		hotspot_name		="";
		hotspot_pos			="";
		//hashMultiple		=null;
		super.clear() ;
	}

	public void setAll( Hashtable recordSetMultiple ) {
		//hashMultiple = recordSetMultiple ;

		if(recordSetMultiple.containsKey("image_id"))
			setImageID((String)recordSetMultiple.get("image_id"));

		if(recordSetMultiple.containsKey("hotspot_id"))
			setHotspotID((String)recordSetMultiple.get("hotspot_id"));

		if(recordSetMultiple.containsKey("hotspot_name"))
			setHotspotName((String)recordSetMultiple.get("hotspot_name"));

		if(recordSetMultiple.containsKey("hotspot_pos"))
			setHotspotPos((String)recordSetMultiple.get("hotspot_pos"));

		if(recordSetMultiple.containsKey("x_pos"))
			setXPos((String)recordSetMultiple.get("x_pos"));
		
		if(recordSetMultiple.containsKey("y_pos"))
			setYPos((String)recordSetMultiple.get("y_pos"));

		if(recordSetMultiple.containsKey("function_id"))
			setFunctionID((String)recordSetMultiple.get("function_id"));
		//IN072524 Starts
		if(recordSetMultiple.containsKey("fpp_yn"))
			setFpp_yn((String)recordSetMultiple.get("fpp_yn"));
		//IN072524 ENDS

		setMode((String)recordSetMultiple.get("mode"));

 	}


}//end of class
