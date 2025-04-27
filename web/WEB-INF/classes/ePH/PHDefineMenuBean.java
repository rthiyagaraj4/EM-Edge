/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
28/06/2021     TFS-15609          Prabha        MO-CRF-20169    
---------------------------------------------------------------------------------------------------------------
*/ 
package ePH ;

import java.io.* ;
import java.sql.* ;
import java.util.* ;
import javax.servlet.*;
import ePH.Common.*;
import eCommon.SingleTableHandler.*;
import eCommon.Common.*;


public class PHDefineMenuBean extends PhAdapter implements Serializable 
{
	private String	desktop_id		=	"";
	private String	desktop_desc	=	"";
	private String	eff_status		=	"D";
	private String	user_id			=	"";

	public void setDesktop_id( String desktop_id){
		this.desktop_id	=  desktop_id;
	}

	public void setDesktop_desc( String desktop_desc ){
		this.desktop_desc		=	desktop_desc;
	}

	public void setUser_Id( String user_id){
		this.user_id		=	user_id;
	}

    public void setEffStatus ( String eff_status ){
        if(eff_status.equals("") || eff_status==null )
            this.eff_status = "D" ;
        else
            this.eff_status = eff_status ;
    }
	
	public String getDesktop_id(){
		return this.desktop_id;
	}

	public String getDesktop_desc(){
		return this.desktop_desc;
	}

	public String getUser_Id(){
		return this.user_id;
	}

	public String getEffStatus(){
		return this.eff_status;
	}


	public void clear(){
		super.clear() ;
		desktop_id			=	"" ;
		desktop_desc		=	"" ;
		user_id				=	"" ;
		eff_status			=	"" ;
	}

	public void setAll(Hashtable hashtable){
		setDesktop_id((String)hashtable.get("desktop_id")) ;
		setDesktop_desc((String)hashtable.get("desktop_desc")) ;
		setUser_Id((String)hashtable.get("user_id")) ;
		setEffStatus(checkForNull((String)hashtable.get("eff_status"),"D")) ;
	}

	public HashMap validate()throws Exception{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}

	public HashMap insert(){
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap();

		ArrayList WhereData = new ArrayList();
		ArrayList InsertData = new ArrayList();

		InsertData.add(user_id);		
		InsertData.add(desktop_id);		
		InsertData.add(desktop_desc);
		InsertData.add(eff_status);

		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);

		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);

		WhereData.add(user_id);

		tabData.put("InsertData",InsertData);
		tabData.put("WhereData",WhereData);
		tabData.put("properties",getProperties());

		HashMap sqlMap = new HashMap();
	
		SingleTableHandlerRemote remote = null;

		try {
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ST_DESKTOP_FOR_USER_INSERT") );
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_ST_DESKTOP_ID_EXIST") );

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
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message",getMessage(getLanguageId(),(String) map.get("msgid"),"PH") ) ;
		} 
		catch(Exception e){
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}
		finally{
			try {
				if( remote != null )
					remote.remove() ;
			} 
			catch( Exception ee ){
				map.put( "message", ee.getMessage() ) ;
				ee.printStackTrace();
			}
		}
		return map ;
	}
	
	public HashMap modify(){
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap();
		ArrayList ModifyData = new ArrayList();
		ModifyData.add(desktop_id);
		ModifyData.add(desktop_desc);
		ModifyData.add(eff_status);
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
		ModifyData.add(user_id);

		tabData.put( "ModifyData",	ModifyData ) ;
		tabData.put( "properties",	getProperties() ) ;
		HashMap sqlMap = new HashMap();
		SingleTableHandlerRemote remote = null;
		try{
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_ST_DESKTOP_FOR_USER_UPDATE") );
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
				map.put("message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put("msgid",getMessage(getLanguageId(),(String) map.get("msgid"),"Common"));		
		}
		catch(Exception e){
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
			System.err.println( "map==========216=====> : "+map ) ;
		}
		finally{
			try {
				if( remote != null )
					remote.remove() ;
			} 
			catch( Exception ee ){
				map.put( "message", ee.getMessage() ) ;
				ee.printStackTrace();
				System.err.println( "map==========217=====> : "+map ) ;
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
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ST_DESKTOP_FOR_USER_MODIFY"));
			pstmt.setString( 1, user_id);
		
			resultSet = pstmt.executeQuery();

			if ((resultSet != null) && (resultSet.next())) {				
				setUser_Id(resultSet.getString("user_id"));
				setDesktop_id(resultSet.getString("desktop_id"));
				setDesktop_desc(checkForNull(resultSet.getString("desktop_desc")));
				setEffStatus(checkForNull(resultSet.getString("eff_status")));	
			}
		} 
		catch (Exception e )	{
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

	public ArrayList getDesktopList() throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList desktopList = new ArrayList();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ST_DESKTOP_ID_LIST"));
		
			resultSet = pstmt.executeQuery();

			if (resultSet != null){
				while(resultSet.next()) {
					desktopList.add(new String[]{resultSet.getString("DESKTOP_SUMMARY_ID"),resultSet.getString("DESKTOP_SUMMARY_NAME")});
				}
			}
		} 
		catch (Exception e )	{
			e.printStackTrace();
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
		return desktopList;
	}
	
	//Added for MO-CRF-20169 - Start
	public ArrayList getDesktopListNew() throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList desktopList = new ArrayList();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement("select DESKTOP_SUMMARY_ID,  DESKTOP_SUMMARY_NAME from SM_DESKTOP_SUM_HDR where DFLT_MODULE_ID = 'ST' and EFF_STATUS='E'");
		
			resultSet = pstmt.executeQuery();

			if (resultSet != null){
				while(resultSet.next()) {
					desktopList.add(new String[]{resultSet.getString("DESKTOP_SUMMARY_ID"),resultSet.getString("DESKTOP_SUMMARY_NAME")});
				}
			}
		} 
		catch (Exception e )	{
			e.printStackTrace();
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
		return desktopList;
	}
	//Added for MO-CRF-20169 - End
}
