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
//import eMM.MasterCode.*; 
import eCommon.*;
import eCommon.Common.*;

public class MaterialsGroupBean extends MmAdapter implements Serializable
{	protected String material_group_code			= "";
	protected String long_desc				= "";
	protected String short_desc				= "";
	protected String eff_status				= "";
	protected Hashtable hashMultiple       ;
	
	public MaterialsGroupBean()throws Exception
	{ 
		try
		{
			doCommon();
		}
		catch(Exception e){
				e.printStackTrace();
		}
	}
//********* * Set Methods Start **************************
	public void setMasterCode (String material_group_code)
	{
		this.material_group_code = material_group_code;
	}
	public void setLongDesc (String long_desc)
	{
		this.long_desc = long_desc;
	}
	public void setShortDesc (String short_desc)
	{
		this.short_desc = short_desc;
	}
	public void setEffStatus ( String eff_status ){
        if(eff_status.equals("N") || eff_status==null || eff_status=="")
            this.eff_status = "D" ;
        else
            this.eff_status = eff_status ;		
    }

//*********** Get Methods Start *****************************	
	public String getMasterCode() 
	{
		return this.material_group_code;
	}
	public String getLongDesc() 
	{
		return this.long_desc;
	}
	public String getShortDesc() 
	{
		return this.short_desc;
	}		
	public String getEffStatus() 
	{
		return this.eff_status	;
	}

	public void clear()
	{
		super.clear();
		/*
		material_group_code = "";
		long_desc = "";
		short_desc = "";	
		eff_status = "";*/
	}
//********************* setAll  *******************************************************/
    public void setAll( Hashtable recordSetMultiple ) {
		hashMultiple = recordSetMultiple ;
        this.mode =(String)recordSetMultiple.get("mode");
 }

//*************************************************************************

	private void doCommon() throws Exception 
	{
	}
	public HashMap insert()
	{	

		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;

		for(int i=0; i<10;i++)
		{
			String material_group_code = "material_group_code"  + i ;
			String longDesc = "long_desc"  + i ;
			String shortDesc = "short_desc"  + i ;
			ArrayList insertRow = new ArrayList() ;
			ArrayList whereRow = new ArrayList() ;

			if(!
				  (  (((String)hashMultiple.get(material_group_code))).trim().equals("")
										||
					(((String)hashMultiple.get(longDesc))).trim().equals("")
										||
					(((String)hashMultiple.get(shortDesc))).trim().equals("")
				  )
			  )
			{
				/***** 4 values per row from the AddModify form  */

				insertRow.add( (String)hashMultiple.get(  ("material_group_code" + i)    )  ) ;
				insertRow.add( (String)hashMultiple.get(  ("long_desc" + i)         ) ) ;
				insertRow.add( (String)hashMultiple.get(  ("short_desc" + i)        ) ) ;
				if( ((String)hashMultiple.get(("eff_status" + i))).equals("") )
					insertRow.add(  "D"  ) ;
				else
					insertRow.add( (String)hashMultiple.get(  ("eff_status" + i)        ) ) ;

				insertRow.add( login_by_id ) ;
				insertRow.add( login_at_ws_no ) ;
				insertRow.add( login_facility_id ) ;

				insertRow.add( login_by_id ) ;
				insertRow.add( login_at_ws_no ) ;
				insertRow.add( login_facility_id ) ;

				whereRow.add( (String)hashMultiple.get(  ("material_group_code" + i) )  ) ;

				/* note:-
				The insertData and whereData should be arraylist of arraylist
				in case of insertMultiple() of SingleTableHandler
				*/
				insertData.add( insertRow ) ;
				whereData.add( whereRow ) ;
			}
		}//for

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "InsertData",insertData);
		
		tabData.put( "WhereData",whereData);

		HashMap sqlMap = new HashMap() ;
		try
		{
			sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue( "SQL_MM_MATRIALS_GROUP_CODE_EXISTS") );
			
			sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue( "SQL_MM_MATRIALS_GROUP_INSERT_MASTER") );
			
			
			map			=	callSingleTableHandler( tabData, sqlMap, MmRepository.MULTIPLE_INSERT );

			//sbErrorMessage.append("<br>MAP RETURNED FROM SINGLE TABLE HANDLER : "+map);
			
			if( ((Boolean) map.get( "result" )).booleanValue() )	
			{
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") );
			}
			else if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
			{
                String messageText = getMessage((String) map.get( "msgid" ),false) ;
                messageText = messageText.substring(0,(messageText.indexOf("<br>")));
                map.put( "message", messageText ) ;
                map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
			}
			else
			{
				map.put( "message", map.get("msgid") + "tabData Content: "+tabData );
			}
		} 
		catch(Exception e){
		e.printStackTrace();
		}

		return map;
	}
	public HashMap modify()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap() ;
		ArrayList ModifyData = new ArrayList();

		ModifyData.add((String)hashMultiple.get(  "long_desc"  ));
		ModifyData.add((String)hashMultiple.get(  "short_desc"  ));		
		ModifyData.add(checkForNull((String)hashMultiple.get( "eff_status" ),"D"));
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
		ModifyData.add(material_group_code);
	
		tabData.put( "ModifyData",	ModifyData ) ;
		tabData.put( "properties",	getProperties() ) ;
		

		HashMap sqlMap = new HashMap() ;
	

//		SingleTableHandlerHome home = null ;
		SingleTableHandlerRemote remote = null ;

		try
			{
				sqlMap.put( "ModifySQL", MmRepository.getMmKeyValue( "SQL_MM_MATRIALS_GROUP_UPDATE") );

				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/
				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ,SingleTableHandlerHome.class ,getLocalEJB());
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
					map.put("message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") );
				else
					map.put("message",map.get("msgid"));		

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
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}
			}

		return map ;
	}

public void loadData() throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(MmRepository.getMmKeyValue( "SQL_MM_MATRIALS_GROUP_MODIFY"));
			pstmt.setString( 1, material_group_code);
			pstmt.setString( 2, getLanguageId());
		

			resultSet = pstmt.executeQuery();

			if ((resultSet != null) && (resultSet.next())) {				
				setMasterCode(resultSet.getString("material_group_code"));
				setLongDesc(resultSet.getString("long_desc"));
				setShortDesc(resultSet.getString("short_desc"));				
				setEffStatus(resultSet.getString("eff_status"));			
				
			}
		} 
		catch (Exception e )	{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}

		}
	}	
private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap )
 {
    HashMap map = new HashMap() ;
    map.put( "result", new Boolean( false ) ) ;

//    SingleTableHandlerHome home = null;
    SingleTableHandlerRemote remote = null;
    try {
       /* InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;
        home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
        remote = home.create() ;*/

		Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
		Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

		Object argArray[] = new Object[2];
		argArray[0] = tabData;
		argArray[1] = sqlMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = tabData.getClass(); 
		paramArray[1] = sqlMap.getClass();

        if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT"))  ){
			 map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
	          //  map = remote.singleBatchHandler( tabData, sqlMap ) ;
        }else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY")) ){
			 map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
          //  map = remote.modify( tabData, sqlMap ) ;
        }else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE") ) ){
			 map = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

            // map = remote.delete( tabData, sqlMap ) ;
        }
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


        if( ((Boolean) map.get( "result" )).booleanValue() )
                map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
        else{
            if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
            {
                String msgID = getMessage((String) map.get( "msgid" ),false) ;
                msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
                map.put( "message", msgID  ) ;
                map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
                    //(map.get("invalidCode"))  ) ;
            }
            else
                map.put( "message", (map.get("msgid"))) ;
            }
        }
        catch(Exception e) {
        System.err.println( "Error Calling EJB classcast : "+e ) ;
        map.put( "message", e.getMessage()+"classcast") ;
        e.printStackTrace() ;
        }
		finally {
				try {
					if( remote != null )
						remote.remove() ;
					} catch( Exception ee ) {
						System.err.println( ee.getMessage() ) ;
							map.put( "message", ee.getMessage() ) ;
					}
				}
return map;
}

public ArrayList isSSIVModuleInstalled() throws Exception
		{
		//System.err.println("calling 	isSSIVModuleInstalled()");
		HashMap		hmSSIV		=	null;	
		ArrayList	arrSSIV		=	new  ArrayList();
        
		hmSSIV	=	new HashMap();
		hmSSIV.put("IV",checkForNull(MM_license_rights.getSTboundary()));
		hmSSIV.put("SS",checkForNull(MM_license_rights.getSSboundary()));
		hmSSIV.put("PO",checkForNull(MM_license_rights.getPOboundary()));
		arrSSIV.add(hmSSIV);

		return arrSSIV;
	}	

}

