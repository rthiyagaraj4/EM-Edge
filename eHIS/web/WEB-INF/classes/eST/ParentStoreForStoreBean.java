/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import eST.Common.StAdapter;
import eST.ParentStoreForStore.*;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
import java.sql.*;

public class ParentStoreForStoreBean extends StAdapter implements Serializable {

	HashMap commonData					=		new HashMap();
	public HashMap alhmData				=		new HashMap();
	private ArrayList alItemClassTemp	=		new ArrayList();
	private String store_code			=		 "";
	private String store_desc			=		 "";
	private String parent_store_code    =		 "";
	private String parent_store_desc    =		 "";
	private String item_class_code      =		 "";
	private String eff_status			=		 "";
	private String db_action			=		 "";
	private int total_index				=		 0;
//	private int total_records			=		 0;
	//private int count					=		 0;

	public void setStoreCode(String store_code){
		this.store_code = store_code;
	}
	public void setParentStoreCode(String parent_store_code){
		this.parent_store_code = parent_store_code;
	}
	public void setStoreDesc(String store_desc){
		this.store_desc = store_desc;
	}
	public void setParentStoreDesc(String parent_store_desc){
		this.parent_store_desc = parent_store_desc;
	}
	public void setItemClassCode(String item_class_code){
		this.item_class_code = item_class_code;
	}
	public void setEff_Status(String eff_status){
		this.eff_status = eff_status;
	}
	public void setDB_Action(String db_action){
		this.db_action = db_action;
	}
	public void setTotal_Index(int total_index){
		this.total_index=total_index;
	}


	public String getStoreCode(){
		return this.store_code;
	}
	public String getParentStoreCode(){
		return this.parent_store_code;
	}
	public String getStoreDesc(){
		return this.store_desc;
	}
	public String getParentStoreDesc(){
		return this.parent_store_desc;
	}
	public String getItemClassCode(){
		return this.item_class_code;
	}
	public String getEff_Status(){
		return this.eff_status;
	}
	public String getDB_Action(){
		return this.db_action;
	}

	public  int  getTotal_Index(){
		return this.total_index;
	}


	public void setAll(Hashtable hashtable){
		setStoreCode((String)hashtable.get("store_code"));
	}
	 
	public HashMap validate() throws Exception{
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success" ) ;
		return map;
	}
    	
	public HashMap insert(){
		ArrayList alInsertTempData	= new ArrayList();
		ArrayList alInsertData		= new ArrayList();
		ArrayList alItemClassData	= new ArrayList();
		ArrayList alWhereData		= new ArrayList();
		ArrayList LanguageData		= new ArrayList();
		HashMap hmTableData			= new HashMap();
		HashMap hmSQLMap			= new HashMap();
		for(int i=0;i<alItemClassTemp.size();i++){
			if(alhmData.containsKey(alItemClassTemp.get(i))){
				alItemClassData = (ArrayList)alhmData.get(alItemClassTemp.get(i));
				if(alItemClassData.size()>0){
					for(int j=0;j<alItemClassData.size();j++){
						alInsertTempData = new ArrayList();
						
						alInsertTempData.add(getStoreCode());
						alInsertTempData.add(alItemClassTemp.get(i));
						alInsertTempData.add(alItemClassData.get(j));
						alInsertTempData.add("E");
						alInsertTempData.add(getLoginById());
						alInsertTempData.add(getLoginAtWsNo());
						alInsertTempData.add(getLoginFacilityId());
						alInsertTempData.add(getLoginById());
						alInsertTempData.add(getLoginAtWsNo());
						alInsertTempData.add(getLoginFacilityId());
						
						alInsertData.add(alInsertTempData);
					}
				}
			}
		}
		alWhereData.add(getStoreCode());
		LanguageData.add(getLanguageId());
		hmSQLMap.put( "dtlInsertSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PARENT_STORE_INSERT")	);
		try{
			String count = (String)((HashMap)fetchRecord("SELECT count(*) COUNT FROM ST_STORE_PARENT_STORE WHERE STORE_CODE = ?",getStoreCode())).get("COUNT");
			if((Integer.parseInt(count))>0)
				hmSQLMap.put( "deleteSQL", "DELETE FROM ST_STORE_PARENT_STORE WHERE STORE_CODE = ?"	);
		}catch(Exception e){
			e.printStackTrace();
		}


		hmTableData.put( "properties",		getProperties() );
		hmTableData.put( "DelData",			alWhereData		);
		hmTableData.put( "DtlInsertData",	alInsertData	);
		hmTableData.put( "LanguageData",	LanguageData	);
		return parentStoreForStoreMethodCall(hmTableData, hmSQLMap);
	}	
    public HashMap parentStoreForStoreMethodCall(HashMap hashmap, HashMap hashmapQuery){
        HashMap hashmapResult = new HashMap();
			
        try{
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_PARENT_STORE_FOR_STORE"),ParentStoreForStoreLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();

			
			/*if(mode==2)
				 hashmapResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			else*/
				 hashmapResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }catch(Exception exception){
			exception.printStackTrace() ;
		}
			
			
        if(((Boolean)hashmapResult.get("result")).booleanValue())
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
 
		return hashmapResult;
    }
/*	public HashMap  insert()
	{		
		Connection				 connection		=	null;
		PreparedStatement		 pstmt1			=	null;
		PreparedStatement		 pstmt2			=	null;
		//ResultSet				 resultSet1		=	null;
		//ResultSet				 resultSet2		=	null;
		String					 effstatus		=	"";
		String					 itemclasscode	=	"";
		//String					 dbaction		=	"";
		HashMap					 map				=new HashMap();
		boolean					insert_rec_1	=	true;
		boolean					update_rec_1	=	true;
		boolean					no_records		=	false;
		int						count_i				=   0;


		//String		insertSQL		=	"insert into st_store_parent_store(STORE_CODE, PARENT_STORE_CODE,ITEM_CLASS_CODE ,EFF_STATUS, ADDED_BY_ID , ADDED_DATE  ,ADDED_AT_WS_NO  ,ADDED_FACILITY_ID, MODIFIED_BY_ID ,MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID )  VALUES( ?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		//String		updateSQL		=	"UPDATE st_store_parent_store SET EFF_STATUS=? , MODIFIED_BY_ID=? ,MODIFIED_DATE=SYSDATE ,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ITEM_CLASS_CODE=? AND STORE_CODE=? AND  PARENT_STORE_CODE=? ";
		try
		{
						connection=getConnection();
						pstmt1=connection.prepareStatement(getStRepositoryValue("SQL_ST_PARENT_STORE_INSERT"));
						pstmt2=connection.prepareStatement(getStRepositoryValue("SQL_ST_PARENT_STORE_UPDATE"));

						for (int j=0;j<getTotal_Index() ;j++)
							{
							if(((commonData.get("db_action_"+j).equals("I"))&&((commonData.get("eff_status_"+j)).equals("E"))))
							{	effstatus=(String)commonData.get("eff_status_"+j);
								itemclasscode=(String)commonData.get("item_class_code_"+j);
									
									pstmt1.setString(1,((String)getStoreCode()));
									pstmt1.setString(2,((String)getParentStoreCode()));
									pstmt1.setString(3,itemclasscode);             
									pstmt1.setString(4,effstatus);
									pstmt1.setString(5,(getLoginById()));
									pstmt1.setString(6,(getLoginAtWsNo()));
									pstmt1.setString(7,(getLoginFacilityId()));
									pstmt1.setString(8,(getLoginById()));
									pstmt1.setString(9,(getLoginAtWsNo()));
									pstmt1.setString(10,(getLoginFacilityId()));   			
									pstmt1.addBatch();
									  								
							}
				
							else
								if(((commonData.get("db_action_"+j).equals("U")))&&(((commonData.get("eff_status_"+j)).equals("D"))||((commonData.get("eff_status_"+j)).equals("E"))))
								{
									
									effstatus=(String)commonData.get("eff_status_"+j);
									itemclasscode=(String)commonData.get("item_class_code_"+j);
									pstmt2.setString(1,effstatus);
									pstmt2.setString(2,(getLoginById()));
									pstmt2.setString(3,(getLoginAtWsNo()));
									pstmt2.setString(4,(getLoginFacilityId()));
									pstmt2.setString(5,itemclasscode);           
									pstmt2.setString(6,((String)getStoreCode()));
									pstmt2.setString(7,((String)getParentStoreCode()));
									setEff_Status(effstatus);
									pstmt2.addBatch();
								                      
					
						    	}
							else
								if(((commonData.get("db_action_"+j).equals("I"))&&((commonData.get("eff_status_"+j)).equals("D"))))
								{	count_i=count_i+1;
									if(count_i==getTotal_Index())
									no_records=true;
									else
									no_records=false;
								}
								
					}

								int [] numInserts=pstmt1.executeBatch();    
								int [] numUpdates=pstmt2.executeBatch();    
								for (int i=0;i<numInserts.length ;i++ )
								{
									if(numInserts[i]<0  && numInserts[i] != -2 ){
									insert_rec_1=false;
									break;
									}
									else{
										insert_rec_1=true;
										}
								}

							for (int i=0;i<numUpdates.length ;i++ )
								{
									if(numUpdates[i]<0  && numUpdates[i] != -2 ){
									update_rec_1=false;
									break;
									}
									else{
										update_rec_1=true;
										}
								}
								
				if(insert_rec_1 && update_rec_1 )
					{
						if(no_records==false)
						{
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						map.put( "LanguageData",getLanguageId());
						map.put( "properties", getProperties());
						if( ((Boolean) map.get( "result" )).booleanValue() ){
							 map.put( "message", getSTMessage(getLanguageId(), "RECORD_INSERTED" ,"ST") ) ;
							 }
						else{
							 map.put( "message", (map.get("message"))) ;
						}

					
							map.put("flag","");
						}
						else if(no_records)
						{
							
									
									map.put( "result", new Boolean( true ) ) ;
									map.put( "LanguageData",getLanguageId());
									map.put( "properties", getProperties());
									
									if( ((Boolean) map.get( "result" )).booleanValue() ){
										 map.put( "message", getMessage(getLanguageId(),"ATLEAST_ONE_SELECTED","Common") ) ;
										 }
									else{
									 map.put( "message", (map.get("message"))) ;}
						}
					}else{
							try{
								connection.rollback();
								map.put("flag","true");
							}
							catch(Exception es){
								es.printStackTrace() ;
								map.put("flag","");
							}

												
						}
		}
			catch (Exception e)
			{
				
				e.printStackTrace();
			}
			  finally
		{
		try
		{
			
			closeStatement(pstmt1);
			closeStatement(pstmt2);
			
			closeConnection(connection);
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		}
		
		return map;
		
	}*/
/*public HashMap  modify()
	{		
		Connection				 connection		=	null;
		PreparedStatement		 pstmt1			=	null;
		PreparedStatement		 pstmt2			=	null;
		//ResultSet				 resultSet1		=	null;
		//ResultSet				 resultSet2		=	null;
		String					 effstatus		=	"";
		String					 itemclasscode	=	"";
		//String					 dbaction		=	"";
		HashMap					 map				=	new HashMap();
		boolean					 insert_rec_1	=	true;
		boolean					 update_rec_1	=	true;


	//	String		insertSQL		=	"insert into st_store_parent_store(STORE_CODE, PARENT_STORE_CODE,ITEM_CLASS_CODE ,EFF_STATUS, ADDED_BY_ID , ADDED_DATE  ,ADDED_AT_WS_NO  ,ADDED_FACILITY_ID, MODIFIED_BY_ID ,MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID )  VALUES( ?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
	//	String		updateSQL		=	"UPDATE st_store_parent_store SET EFF_STATUS=?,  MODIFIED_BY_ID=? ,MODIFIED_DATE=SYSDATE ,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ITEM_CLASS_CODE=? AND STORE_CODE=? AND PARENT_STORE_CODE=? ";
		try
		{
						connection=getConnection();
						pstmt1=connection.prepareStatement(getStRepositoryValue("SQL_ST_PARENT_STORE_INSERT"));
						pstmt2=connection.prepareStatement(getStRepositoryValue("SQL_ST_PARENT_STORE_UPDATE"));

						for (int j=0;j<getTotal_Index() ;j++)
							{
						
							if(((commonData.get("db_action_"+j).equals("I"))&&((commonData.get("eff_status_"+j)).equals("E"))))
							{	effstatus=(String)commonData.get("eff_status_"+j);
								itemclasscode=(String)commonData.get("item_class_code_"+j);

									pstmt1.setString(1,((String)getStoreCode()));
									pstmt1.setString(2,((String)getParentStoreCode()));
									pstmt1.setString(3,itemclasscode);             
									pstmt1.setString(4,effstatus);
									pstmt1.setString(5,(getLoginById()));
									pstmt1.setString(6,(getLoginAtWsNo()));
									pstmt1.setString(7,(getLoginFacilityId()));
									pstmt1.setString(8,(getLoginById()));
									pstmt1.setString(9,(getLoginAtWsNo()));
									pstmt1.setString(10,(getLoginFacilityId()));             
									pstmt1.addBatch();
									  								
							}
				
							else
								if(((commonData.get("db_action_"+j).equals("U")))&&(((commonData.get("eff_status_"+j)).equals("D"))||((commonData.get("eff_status_"+j)).equals("E"))))
								{
									effstatus=(String)commonData.get("eff_status_"+j);
									itemclasscode=(String)commonData.get("item_class_code_"+j);

									pstmt2.setString(1,effstatus);
									pstmt2.setString(2,(getLoginById()));
									pstmt2.setString(3,(getLoginAtWsNo()));
									pstmt2.setString(4,(getLoginFacilityId()));
									pstmt2.setString(5,itemclasscode);           
									pstmt2.setString(6,((String)getStoreCode()));
									pstmt2.setString(7,((String)getParentStoreCode()));
									setEff_Status(effstatus);
									pstmt2.addBatch();
								                      
					
						    	}
							else
								if(((commonData.get("db_action_"+j).equals("I"))&&((commonData.get("eff_status_"+j)).equals("D"))))
								{
									map.put( "result", new Boolean( true ) ) ;
									map.put( "LanguageData", getLanguageId()) ;
									if( ((Boolean) map.get( "result" )).booleanValue() ){
									 map.put( "message", getSTMessage(getLanguageId(), "RECORD_INSERTED" ,"ST") ) ;
									 }
								else{
							 map.put( "message", (map.get("message"))) ;
						}
								}
			}

								int [] numInserts=pstmt1.executeBatch();    
								int [] numUpdates=pstmt2.executeBatch();    
								for (int i=0;i<numInserts.length ;i++ )
								{
									if(numInserts[i]<0  && numInserts[i] != -2 ){
									insert_rec_1=false;
									break;
									}
									else{
										insert_rec_1=true;
										}
								}
							
							for (int i=0;i<numUpdates.length ;i++ )
								{
									if(numUpdates[i]<0  && numUpdates[i] != -2 ){
									update_rec_1=false;
									break;
									}
									else{
										update_rec_1=true;
										}
								}
								
				if(insert_rec_1 && update_rec_1 )
					{
					
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						map.put( "LanguageData", getLanguageId()) ;
						if( ((Boolean) map.get( "result" )).booleanValue() ){

							 map.put( "message", getSTMessage(getLanguageId(), "RECORD_INSERTED" ,"ST") ) ;
							 }
						else{
							 map.put( "message", (map.get("message"))) ;
						}

					
						map.put("flag","");
					}
					else{
							try{

								connection.rollback();
								map.put("flag","true");
							}
								catch(Exception es){
								es.printStackTrace() ;
								map.put("flag",es.toString());
				                map.put( "msgid", es.toString() ) ;
							    connection.rollback();
								map.put("flag","");
							}

							
								  
						
						}
		}
			catch (Exception e)
			{
				
				e.printStackTrace();
			}
			  finally
		{
		try
		{
			
			closeStatement(pstmt1);
			closeStatement(pstmt2);
			
			closeConnection(connection);
		}
		catch(Exception exp)
		{
		}
		}
		return map;
		
	}*/

	public String checkStoreDesc(String store_code,String store_description){
		ArrayList alParams = new ArrayList();
		alParams.add(store_code);
		alParams.add(getLanguageId());
		HashMap hmResult =new HashMap();
		try{
			hmResult =fetchRecord(getStRepositoryValue("SQL_ST_PARENT_STORE_DESC_CHECK"),alParams);
		}catch(Exception e) {
			e.printStackTrace();
		}
		int count=Integer.parseInt((String)hmResult.get("COUNT"));

		if (count==0)
			return "0";
		else
			return "1";
			
	}

	public ArrayList getParentStores(String store_code){
		ArrayList alParameters = new ArrayList();
		ArrayList alResult= new ArrayList();
		alParameters.add(store_code);
		alParameters.add(getLanguageId());
		try{
			alResult = (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_PARENT_STORE_DESC_SELECT"),alParameters);
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList();
		}
		alItemClassTemp = new ArrayList();
		for(int i=0;i<alResult.size();i++){
			HashMap hmTemp = new HashMap();
			hmTemp = (HashMap)alResult.get(i);
			alItemClassTemp.add(hmTemp.get("STORE_CODE"));
		}
		return alResult;
	}

	public void loadExistingParentStores(String store_code){
		ArrayList alParameters = new ArrayList();
		ArrayList alResult	= new ArrayList();
		ArrayList alResult1	= new ArrayList();
		ArrayList alTemp	= new ArrayList();
		HashMap hmTemp		= new HashMap();
		HashMap hmTemp1		= new HashMap();
		alhmData			= new HashMap();
		alParameters.add(store_code);
		try{
			alResult = (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_STORE_PARENT_STORE_SELECT"),alParameters);
			for(int i=0;i<alResult.size();i++){
				hmTemp = (HashMap)alResult.get(i);
				alParameters = new ArrayList();
				alParameters.add(hmTemp.get("STORE_CODE"));
				alParameters.add(hmTemp.get("PARENT_STORE_CODE"));
				alResult1 = (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_STORE_PARENT_STORE_ITEM_CLASS_SELECT"),alParameters);

				alTemp	=	new ArrayList();
				for(int j=0;j<alResult1.size();j++){
					hmTemp1 =	(HashMap)alResult1.get(j);
					alTemp.add((String)hmTemp1.get("ITEM_CLASS_CODE"));
				}
				alhmData.put(hmTemp.get("PARENT_STORE_CODE"),alTemp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
}
