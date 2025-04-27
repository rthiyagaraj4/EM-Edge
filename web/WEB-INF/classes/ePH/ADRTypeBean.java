/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  //saved on 08/11/2005
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class ADRTypeBean extends PhAdapter implements Serializable 
{
	protected String m_strADR_Code = "";
	protected String m_strADR_Desc = "";
	protected String m_eff_status  = "";

	public ADRTypeBean() 
	{
		try 
		{
			doCommon();
		}
		
		catch(Exception e) { e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */
	public void clear() 
	{
		super.clear() ;
	}

	private void doCommon() throws Exception 
	{
	}

	/* Over-ridden Adapter methods end here */

	
	public void setADRTypeCode(String strADRCodeIn)
	{
		this.m_strADR_Code = strADRCodeIn;
	}
	public void setADRTypeDesc(String strADRDescIn)
	{
		this.m_strADR_Desc = strADRDescIn;
	}
	
	public void setEffStatus(String eff_status)
	{
		if (eff_status.equals("") || eff_status==null )
			eff_status="D";
		
		this.m_eff_status = eff_status;
	}
	
	public String getADRTypeCode()
	{
		return m_strADR_Code;
	}
	public String getADRTypeDesc()
	{
		return m_strADR_Desc;
	}

	public String getEffStatus()
	{
		return m_eff_status;
	}

	public HashMap validate() throws Exception 
	{
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	// setAll method to set all the values
	public void setAll(Hashtable recordSet)
	{
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("adr_code"))
			setADRTypeCode((String)recordSet.get("adr_code")) ;
		if(recordSet.containsKey("adr_desc"))
			setADRTypeDesc((String)recordSet.get("adr_desc")) ;
		if(recordSet.containsKey("eff_status"))
			setEffStatus((String)recordSet.get("eff_status")) ;
	}

	public void loadData() throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADRTYPE_SELECT1") );
			pstmt.setString(1, getADRTypeCode().trim() ) ;
			pstmt.setString(2, getLanguageId());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) 
			{
				setADRTypeDesc( resultSet.getString("ADR_DESC" ));
				setEffStatus( resultSet.getString("EFF_STATUS"));	
			}			
		}
		catch ( Exception e )
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{
				System.err.println("Error while closing the statement,resultset and connection"+es.toString());
				es.printStackTrace();
			}
		}
	}

	public HashMap insert() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;

		try{
			insertData.add( m_strADR_Code.trim() ) ;
			insertData.add( m_strADR_Desc.trim() ) ;
			insertData.add( m_eff_status.trim()) ;
			
			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			whereData.add( m_strADR_Code.trim() ) ;

			HashMap tabData = new HashMap() ;

			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_ADRTYPE_SELECT2") );
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ADRTYPE_INSERT") );

		/*	SingleTableHandlerHome home = null;
			SingleTableHandlerRemote remote = null;*/

			try {
/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

    			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

				else{
					if( ((String)map.get( "msgid" )).equals("CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}
			}
			catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e)
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
/*		finally 
		{
			try {} 
			catch( Exception ee )
			{
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}//finally*/
		
		return map ;
	}

	public HashMap modify() 
	{
		StringBuffer debug =new StringBuffer();
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList modifyData = new ArrayList() ;

		modifyData.add( m_strADR_Desc) ;
		modifyData.add( m_eff_status ) ;
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( m_strADR_Code) ;
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;
		try
		{
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_ADRTYPE_UPDATE") );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

/*		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;*/

		try 
		{
/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			debug.append("BEFOER CREATE(IN MODIFY)");
			remote = home.create() ;
			debug.append("BEFOER MODIFY");
			map = remote.modify( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			debug.append("After MODIFY:::"+(Boolean) map.get( "result" ));
			if( ((Boolean) map.get( "result" )).booleanValue() )
			{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag",debug.toString());
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", (map.get("msgid"))) ;
				map.put( "flag",debug.toString());
			}
		}
		catch(Exception e) 
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		}
/*		finally 
		{
			try 
			{
				if( remote != null )
					remote.remove() ;
			} 
			catch( Exception ee ) 
			{
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		
		return map ;	
	}

	public HashMap delete() 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map ;
	}	
} 
