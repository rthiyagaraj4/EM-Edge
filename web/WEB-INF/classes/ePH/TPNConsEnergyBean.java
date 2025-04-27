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
31/01/2019      ML-MMOH-CRF-1266(IN068728)  PRATHYUSHA      TPN Regimen - Carbohydrate, Lipid, Protein to be Enterable
---------------------------------------------------------------------------------------------------------------
*/
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.SingleTableHandlerHome;
import ePH.TPNConsEnergy.*;
//saved on 25/10/2005

public class TPNConsEnergyBean extends PhAdapter implements Serializable {
	
	private Hashtable recordSet		= new Hashtable();

	public TPNConsEnergyBean(){
		//Constructor
		try{
			doCommon() ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear()	{
		super.clear() ;
	}
	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */

	public String getLoggedInFacility(){
		return login_facility_id;
	}
	
	public HashMap validate() throws Exception {

		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	public HashMap getConsEnergyDetails(String gCode,String locale){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		HashMap result=new HashMap();

		try {
			connection = getConnection() ;
			//this query retrieveds cons Energy info
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_ENERGY_SELECT1" )) ;
			pstmt.setString(1,gCode);
			pstmt.setString(2,locale);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result.put("GNAME",resultSet.getString("CONSTITUENT_NAME"));
				result.put("QVALUE",resultSet.getString("QTY_VALUE"));
				result.put("QUNIT",resultSet.getString("QTY_UNIT"));
				result.put("ENERGYRELVAL",resultSet.getString("ENERGY_REL_VALUE"));
				result.put("ENERGYUNIT",resultSet.getString("ENERGY_UNIT"));
			}
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			result.put("GNAME",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   
				System.err.println(es);
			}
		
		}
		return result;
	}

	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values		
		*/
		
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		this.recordSet = recordSet;
	}

	public HashMap insert() {
		//added for ML-MMOH-CRF-1266 START
		String debug=new String();
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        ArrayList insertData = new ArrayList() ;
        ArrayList whereData  = new ArrayList() ;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		try{
			String groupCode=(String)recordSet.get("cons_group");
			String gCode=(String)recordSet.get("gCode");
			String gName=(String)recordSet.get("gName");
			String qvalue=(String)recordSet.get("qvalue");
			String qunit=(String)recordSet.get("qunit");
			String erelval=(String)recordSet.get("erelval");
			String eunit=(String)recordSet.get("eunit");
			
			insertData.add( groupCode.trim());
			insertData.add( gCode.trim());
			insertData.add( gName.trim());
			insertData.add( qvalue.trim());
			insertData.add( qunit.trim());
			insertData.add( erelval.trim());
			insertData.add( eunit.trim());	
		insertData.add( login_by_id.trim());
		insertData.add( login_at_ws_no.trim());
		insertData.add( login_facility_id.trim());
		insertData.add( login_by_id.trim());
		insertData.add( login_at_ws_no.trim());
		insertData.add( login_facility_id.trim());
		  whereData.add( gCode ) ;
		  tabData.put( "properties", getProperties() );
          tabData.put( "InsertData",insertData);
          tabData.put( "WhereData",whereData);

			sqlMap.put( "SelectSQL","SELECT COUNT(ROWID) FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE= ?" );
			sqlMap.put( "InsertSQL", "INSERT INTO ph_tpn_energy_for_const(CONSTITUENT_GROUP_CODE,CONSTITUENT_CODE,CONSTITUENT_NAME, QTY_VALUE,QTY_UNIT,ENERGY_REL_VALUE,ENERGY_UNIT,SYSTEM_DEFINED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES (?,?,?,?,?,?,?,'N',?,SYSDATE,?,?,?,SYSDATE,?,?)"); 
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH"));
			}
			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
				{	map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common"));
				map.put( "result",new Boolean(true));}
				else
				{  map.put( "message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
				map.put( "result",new Boolean(true));}
			}
        }
        catch(Exception e){
			System.err.println( "Error In INSERT: map="+map+" tabData="+tabData ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag",debug);
            e.printStackTrace() ;
        }

		//map.put("flag",debug);
		return map ;
		//return new HashMap() ;
	
	//added for ML-MMOH-CRF-1266 START
	
	}

	 public HashMap modify() {
//		HashMap result=new HashMap();
		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();

		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(true));
		tabData.put("message","message");

		tabData.put( "PROPERTIES", getProperties() );

		String gCode=(String)recordSet.get("gCode");
		String gName=(String)recordSet.get("gName");
		String erelval=(String)recordSet.get("erelval");

		tabData.put("GCODE",gCode);
		tabData.put("GNAME",gName);
		tabData.put("ERELVAL",erelval);
		tabData.put("LOGIN_BY_ID",login_by_id);
		tabData.put("LOGIN_AT_WS_NO",login_at_ws_no);
		tabData.put("LOGIN_FACILITY_ID",login_facility_id);
		
		try	{
			sqlMap.put("SQLUPDATE", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_ENERGY_UPDATE" ) );
	
			/*TPNConsEnergyHome home=null;
			TPNConsEnergyRemote remote=null;
			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSENERGY" ) ) ;
			home  = (TPNConsEnergyHome) PortableRemoteObject.narrow( object, TPNConsEnergyHome.class ) ;
			remote = home.create() ; */

			map=localUpdate (tabData,sqlMap );
			//map=remote.modify(tabData,sqlMap);

		/*	Object home = com.medicom.ESLP.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSENERGY" ),TPNConsEnergyHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("localUpdate",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null); */

			if( ((Boolean) map.get( "result")).booleanValue() )
//				map.put( "message", getMessage((String) map.get( "msgid")) ) ;
			   map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			
		}
		 catch (Exception e) {
				tabData.put("result",new Boolean(false));
				tabData.put("message",e.toString());
		 }
		return map;
	}

	private HashMap localUpdate( HashMap tabData , HashMap sqlMap ) {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Modify" ) ;
		
		Connection connection	= null ;
		PreparedStatement pstmt_update=null;
		
		int tmpcount;
		//ResultSet resultSet = null ;

		String user=(String)tabData.get("LOGIN_BY_ID");
		String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
		String facility=(String)tabData.get("LOGIN_FACILITY_ID");
		String gCode=(String)tabData.get("GCODE");
		String gName=(String)tabData.get("GNAME");
		String erelval=(String)tabData.get("ERELVAL");

		try {
			 connection	= getConnection() ;

			 pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLUPDATE"));
			
			 pstmt_update.setString(1,gName);
			 pstmt_update.setString(2,erelval);
			 pstmt_update.setString(3,user);
			 pstmt_update.setString(4,wsno);
			 pstmt_update.setString(5,facility);
			 pstmt_update.setString(6,gCode);

			tmpcount =pstmt_update.executeUpdate() ;

			if (tmpcount==0) {
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid", "Error During Updation into Constituent Energy!!! ");
				return map;
			}
			else{
				map.put( "result", new Boolean( true) ) ;
				map.put( "msgid", "RECORD_INSERTED") ;

			}
			connection.commit();
		}//end of try
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Error During Updation into Constituent Energy!!!  " +e) ;
			try{
				connection.rollback();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
		finally {
			try {
				//closeResultSet( resultSet );
				closeStatement( pstmt_update) ;
				closeConnection( connection );
				//closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
			//	System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
	/* Function specific methods end */
	//added for ML-MMOH-CRF-1266 START
	public ArrayList getGenricCode(String locale) {

		Connection connection	= null ;
		PreparedStatement pstmt=null;
		  ResultSet resultSet		= null;	
		  ArrayList	const_generic_code_list	=new ArrayList() ; 
		try {
			 connection	= getConnection() ;

			 pstmt=connection.prepareStatement("SELECT const_generic_code,CONST_GENERIC_NAME FROM ph_tpn_const_gen_name_lang_vw a where language_id = ? AND CONST_GROUP_CODE='MN' and eff_status='E' and const_generic_code not in (select CONSTITUENT_CODE from PH_TPN_ENERGY_FOR_CONST where CONSTITUENT_CODE = const_generic_code)");
			
			 pstmt.setString(1,locale);
			 resultSet	= pstmt.executeQuery() ;
			 while (resultSet.next()){
				 const_generic_code_list.add(resultSet.getString("CONST_GENERIC_CODE"));
					const_generic_code_list.add(resultSet.getString("CONST_GENERIC_NAME"));					 
				}

			 

		}//end of try
		catch( Exception e ) {
			
			
				e.printStackTrace();
			
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement( pstmt) ;
				closeConnection( connection );
				
			}
			catch ( Exception fe ) {
			
				fe.printStackTrace() ;
			}
		}
		return const_generic_code_list ;
	}
	//added for ML-MMOH-CRF-1266 START
}

