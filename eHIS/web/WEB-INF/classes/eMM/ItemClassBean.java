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


public class ItemClassBean extends MmAdapter implements Serializable 
{
	protected String	item_class_code		=	"";
	protected String	long_desc		=	"";
	protected String	short_desc		=	"";
	protected String	eff_status		=	"";
	protected String	appl_ss_yn		=	"N";
	protected String	appl_st_yn 		=	"N";
	protected String	appl_po_yn		=	"N";
	//protected String language_id;
	

	public ItemClassBean() throws Exception
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
	public void setMasterCode( String item_class_code)
	{
		this.item_class_code	=  item_class_code;
	}

	public void setLongDesc( String long_desc )
	{
		this.long_desc		=	long_desc;
	}

	public void setShortDesc( String short_desc)
	{
		this.short_desc		=	short_desc;
	}
	
	/*public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}*/

    public void setEffStatus ( String eff_status ){
        if(eff_status.equals("") || eff_status==null )
            this.eff_status = "D" ;
        else
            this.eff_status = eff_status ;
    }
	
    public void setApplSsYn ( String appl_ss_yn ){
        if(appl_ss_yn.equals("") || appl_ss_yn==null )
            this.appl_ss_yn = "N" ;
        else
            this.appl_ss_yn = appl_ss_yn ;
    }
	
	public void setApplStYn ( String appl_st_yn ){
        if(appl_st_yn.equals("") || appl_st_yn==null )
            this.appl_st_yn = "N" ;
        else
            this.appl_st_yn = appl_st_yn ;
    }
	
	public void setApplPoYn ( String appl_po_yn ){
        if(appl_po_yn.equals("") || appl_po_yn==null )
            this.appl_po_yn = "N" ;
        else
            this.appl_po_yn = appl_po_yn ;
    }

	/* Set Methods End */

	/* Get Methods Start */
	public String getMasterCode()
	{
		return this.item_class_code;
	}

	public String getLongDesc()
	{
		return this.long_desc;
	}

	public String getShortDesc()
	{
		return this.short_desc;
	}
	
	/*public String getLanguageId() 
	{
		return this.language_id;
	}*/
	public String getEffStatus()
	{
		return this.eff_status;
	}

	public String getApplSsYn() 
	{
		return this.appl_ss_yn	;
	}

	public String getApplStYn() 
	{
		return this.appl_st_yn;
	}

	public String getApplPoYn() 
	{
		return this.appl_po_yn ;
	}

	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

	public void clear() 
	{
		super.clear() ;
		item_class_code		=	"" ;
		long_desc		=	"" ;
		short_desc		=	"" ;
		eff_status		=	"" ;
		appl_ss_yn		=	"N" ;   
		appl_st_yn 		=	"N" ;   
		appl_po_yn		=	"N" ;   
	}

	public void setAll( Hashtable recordSet ) 
	{
		super.setAll(recordSet);

		if(recordSet.containsKey("item_class_code"))
			setMasterCode((String)recordSet.get("item_class_code"));

		if(recordSet.containsKey("long_desc"))
			setLongDesc((String)recordSet.get("long_desc"));

		if(recordSet.containsKey("short_desc"))
			setShortDesc((String)recordSet.get("short_desc"));

		if(recordSet.containsKey("eff_status"))
			setEffStatus((String)recordSet.get("eff_status"));

		if(recordSet.containsKey("appl_ss_yn"))
			setApplSsYn((String)recordSet.get("appl_ss_yn")) ;

		if(recordSet.containsKey("appl_st_yn"))
			setApplStYn((String)recordSet.get("appl_st_yn")) ;

		if(recordSet.containsKey("appl_po_yn"))
			setApplPoYn((String)recordSet.get("appl_po_yn")) ;
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

		HashMap tabData = new HashMap();

		ArrayList WhereData = new ArrayList();
		ArrayList InsertData = new ArrayList();

		InsertData.add(item_class_code);		
		InsertData.add(long_desc);
		InsertData.add(short_desc);
		InsertData.add(eff_status);
		InsertData.add(appl_ss_yn);
		InsertData.add(appl_st_yn);
		InsertData.add(appl_po_yn);

		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);

		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);

		WhereData.add(item_class_code);

		tabData.put("InsertData",InsertData);
		tabData.put("WhereData",WhereData);
		tabData.put("properties",getProperties());

		HashMap sqlMap = new HashMap();
	

//		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;

		try {
		sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue("SQL_MM_ITEM_CLASS_INSERT") );
		sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue("SQL_MM_ITEM_CLASS_CODE_EXISTS") );

			/*	InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

		
				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

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
		return map ;

	}

	
	public HashMap modify() 
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap();
		ArrayList ModifyData = new ArrayList();

		ModifyData.add(long_desc);
		ModifyData.add(short_desc);
		ModifyData.add(eff_status);
		ModifyData.add(appl_ss_yn);
		ModifyData.add(appl_st_yn);
		ModifyData.add(appl_po_yn);
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
		ModifyData.add(item_class_code);

		tabData.put( "ModifyData",	ModifyData ) ;
		tabData.put( "properties",	getProperties() ) ;

		HashMap sqlMap = new HashMap();

//		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;

		try
			{
				sqlMap.put( "ModifySQL", MmRepository.getMmKeyValue("SQL_MM_ITEM_CLASS_UPDATE") );


			/*	InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/
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

	public void loadData() throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(MmRepository.getMmKeyValue("SQL_MM_ITEM_CLASS_MODIFY"));
			pstmt.setString( 1, item_class_code);
			pstmt.setString( 2, getLanguageId());
			
			resultSet = pstmt.executeQuery();

			if ((resultSet != null) && (resultSet.next())) {				
				setMasterCode(resultSet.getString("item_class_code"));
				setLongDesc(resultSet.getString("long_desc"));
				setShortDesc(resultSet.getString("short_desc"));
				setEffStatus(resultSet.getString("eff_status"));				
				setApplSsYn(checkForNull(resultSet.getString("appl_ss_yn")));
				setApplStYn(checkForNull(resultSet.getString("appl_st_yn")));
				setApplPoYn(checkForNull(resultSet.getString("appl_po_yn")));
				
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
	public String getStInstalled(){
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String stInstl			= "N";

		try{
			connection  =	getConnection();
			pstmt		=	connection.prepareStatement(MmRepository.getMmKeyValue("SQL_MM_PARAMAETER_SELECT1"));
			resultSet	=	pstmt.executeQuery();

			while((resultSet != null) && (resultSet.next())){
				stInstl	= checkForNull(resultSet.getString(1));
			}
		}catch(Exception e){
			System.err.println("Error In loading ST Insatll Status");
		}finally {
            try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es) {
				es.printStackTrace();
            }
        }
		return stInstl;
	}
	public ArrayList getModuleList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrModuleList	=	new  ArrayList();
		//HashMap		hmUOM		=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement( MmRepository.getMmKeyValue( "SQL_MM_MODULE_EXIST_SELECT" ));
				resultSet = pstmt.executeQuery();
				//System.err.println("SQL_MM_MODULE_EXIST_SELECT : " +MmRepository.getMmKeyValue( "SQL_MM_MODULE_EXIST_SELECT" ));
				
				while ((resultSet != null) && (resultSet.next()))
				{
					//hmUOM	=	new HashMap();
					//hmUOM.put("code",checkForNull(resultSet.getString(1)));
					//hmUOM.put("desc",checkForNull(resultSet.getString(2)));
					arrModuleList.add(checkForNull(resultSet.getString(1)));
				}
			} 
			catch (Exception e )
			{
				System.err.println("Error loading values from database");
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrModuleList;
		}

}
