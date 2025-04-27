/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM ;

import java.io.* ;
import java.sql.* ;
import java.util.* ;
import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest ; 
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import eMM.Common.*;
import eCommon.SingleTableHandler.*;
import eCommon.Common.*;


public class ItemImageCatalogueBean extends MmAdapter implements Serializable 
{
	

	private String item_code="";
	private String item_desc="";
	private String srl_no="";
	private String file_name="";
	//protected String language_id;
	

	public ItemImageCatalogueBean() throws Exception
	{
		try 
		{
			doCommon();
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}

	/* Set Methods Start */



	
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public void setSerial_no(String srl_no) {
		this.srl_no = srl_no;
	}
	public void setImgFileName(String file_name) {
		this.file_name = file_name;
	}

	
   

	/* Set Methods End */

	/* Get Methods Start */


	public String getItem_code() {
		return item_code;
	}
	
	public String getSerial_no() {
		return srl_no = srl_no;
	}
	public String getImgFileName() {
		return file_name = file_name;
	}

	

	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

public void clear() 
	{
		super.clear() ;
		
		item_code="";
		item_desc="";
		srl_no="";
		file_name="";
	}
	

	public void setAll( Hashtable recordSet ) 
	{
		System.out.println("recordSet"+recordSet);
		super.setAll(recordSet);

		if(recordSet.containsKey("item_code"))
			setItem_code((String)recordSet.get("item_code"));

		if(recordSet.containsKey("srl_no"))
			setSerial_no((String)recordSet.get("srl_no"));

		if(recordSet.containsKey("file_name"))
			setImgFileName((String)recordSet.get("file_name")) ;

		
	}

	private void doCommon() throws Exception 
	{
	}

	public HashMap validate()throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}



	public HashMap insert() 
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

			java.sql.Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		java.sql.ResultSet resultSet=null;
		int bReturn = 0;
		int srl_num = 0;
		
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement("SELECT MAX(SRL_NO) SRL_NO FROM MM_ITEM_IMAGE_CATLG WHERE ITEM_CODE= ? AND FACILITY_ID=?");
			preparedStatement.setString(1,item_code);
			preparedStatement.setString(2,getLoginFacilityId());
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			bReturn=(resultSet.getInt("SRL_NO"));
			System.out.println("bReturn"+bReturn);
					
		if(bReturn>0){
		 srl_num = bReturn;
		}else{
			srl_num=0;
		}

		HashMap tabData = new HashMap();
		//String temp = "";
		//ArrayList alInsertData        =       new ArrayList();
		ArrayList alInsertRecord = new ArrayList();

		/*StringTokenizer file_name_single =	new StringTokenizer(file_name,";");
		while (file_name_single.hasMoreTokens()) {
			
		 temp = checkForNull(file_name_single.nextToken());
		System.out.println("temp"+temp);*/
		srl_num += 1;
		System.out.println("srl_num"+srl_num);
		
		alInsertRecord.add(getLoginFacilityId());		
		alInsertRecord.add(item_code);
		alInsertRecord.add(srl_num);
		alInsertRecord.add(file_name);

		alInsertRecord.add(login_by_id);
		alInsertRecord.add(login_at_ws_no);
		alInsertRecord.add(getLoginFacilityId());

		alInsertRecord.add(login_by_id);
		alInsertRecord.add(login_at_ws_no);
		alInsertRecord.add(getLoginFacilityId());

	
		tabData.put("InsertData",alInsertRecord);
		tabData.put("properties",getProperties());
		
		HashMap sqlMap = new HashMap();
	

//		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;

		try {
		sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue("SQL_MM_ITEM_IMAGE_CATLG_INSERT") );
		//sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue("SQL_MM_ITEM_IMAGE_CATLG_CODE_EXISTS") );


				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;
 
				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

			    map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				if( ((Boolean) map.get( "result" )).booleanValue() ) 	
					
				map.put( "message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				
				else
			
					map.put( "message",getMMMessage(getLanguageId(),(String) map.get("msgid"),"ST") ) ;
			
			/*	{
				String msgID = getMessage((String) map.get( "message" ));
				msgID = msgID.toUpperCase().substring(0,(msgID.indexOf("<BR>")));
				map.put( "message", msgID);
				}
			*/		
			} 
			catch(Exception e)
			{
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
			finally
			{
				try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee )
					{
						map.put( "message", ee.getMessage() ) ;
						ee.printStackTrace();
					}
			}
	//	System.err.println( "MAP ITEM CLASS:"+map) ;

	}
		catch (Exception exception){
			exception.printStackTrace();
		}
		finally {
			try { 
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return map ;

	}

	
	public HashMap modify() 
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap();
		ArrayList ModifyData = new ArrayList();

		ModifyData.add(file_name);
		
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(getLoginFacilityId());

		ModifyData.add(item_code);
		ModifyData.add(getLoginFacilityId());
		ModifyData.add(getSerial_no());

		System.out.println("ModifyData"+ModifyData);

		tabData.put( "ModifyData",	ModifyData ) ;
		tabData.put( "properties",	getProperties() ) ;

		HashMap sqlMap = new HashMap();

//		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;

		try
			{
				sqlMap.put( "ModifySQL", MmRepository.getMmKeyValue("SQL_MM_ITEM_IMAGE_CATLG_UPDATE") );


				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

			    map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )

					map.put("message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				
				else
					map.put("msgid",getMMMessage(getLanguageId(),(String) map.get("msgid"),"ST"));		

			}
			catch(Exception e)
			{
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally
			{
			try {
					if( remote != null )
						remote.remove() ;
				} 
				catch( Exception ee )
				{
					System.err.println(ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
					ee.printStackTrace();
				}
			}

		return map ;
	}


	public HashMap delete() 
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap();
		ArrayList DeleteData = new ArrayList();

		DeleteData.add(item_code);
		DeleteData.add(getLoginFacilityId());
		DeleteData.add(getSerial_no());

		System.out.println("DeleteData"+DeleteData);

		tabData.put( "DeleteData",	DeleteData ) ;
		tabData.put( "properties",	getProperties() ) ;

		HashMap sqlMap = new HashMap();

//		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;

		try
			{
				sqlMap.put( "DeleteSQL", MmRepository.getMmKeyValue("SQL_MM_ITEM_IMAGE_CATLG_DELETE") );


				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

			    map = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )

					map.put("message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				
				else
					map.put("msgid",getMMMessage(getLanguageId(),(String) map.get("msgid"),"ST"));		

			}
			catch(Exception e)
			{
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally
			{
			try {
					if( remote != null )
						remote.remove() ;
				} 
				catch( Exception ee )
				{
					System.err.println(ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
					ee.printStackTrace();
				}
			}

		return map ;
	}



}
