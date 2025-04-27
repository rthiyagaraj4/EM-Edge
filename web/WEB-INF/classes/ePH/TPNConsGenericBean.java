/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 *****************************************************************************
 Date       		Edit History     Name      			Rev.Date		Rev.Name		                   Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				 ?				 ?				    ?			    ?								   ?
29/01/2019		    IN068728		 Devindra				 		                                       ML-MMOH-CRF-1266 [IN:068728]
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package ePH ; 
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.SingleTableHandlerHome; // Added for ML-MMOH-CRF-1126
import ePH.TPNConsGeneric.*;

//saved on 25/10/2005

public class TPNConsGenericBean extends PhAdapter implements Serializable {

	private Hashtable recordSet		= new Hashtable();

	public TPNConsGenericBean() 
	{
		//Constructor
		try 
		{
			doCommon() ;
		}
		catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception 
	{
	}

	public void clear() 
	{
		super.clear() ;
		
	}

	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */



	public String getLoggedInFacility()  
	{
		return login_facility_id;
	}
	

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}


public HashMap getConsGenericDetails(String gCode,String locale)
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		HashMap result=new HashMap();
		boolean enableDisplay_yn = false; // Added for ML-MMOH-CRF-1126
		//System.err.println("gCode--->"+gCode);
		//System.err.println("locale--->"+locale);
		try {
			connection = getConnection() ;
			enableDisplay_yn = eCommon.Common.CommonBean.isSiteSpecific(connection,"PH","ASSESMENT_REQ_YN"); // Added for ML-MMOH-CRF-1126
			//this query retrieveds cons Generic info
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_GENERIC_SELECT1" )) ;			
			
			if(enableDisplay_yn){ //  if condition Added for ML-MMOH-CRF-1126 - Start
				pstmt = connection.prepareStatement("SELECT a.CONST_GENERIC_CODE, a.CONST_GENERIC_NAME, a.DISP_SRL_NO, a.CONST_GROUP_CODE, b.CONST_GROUP_NAME, a.UOM_SETUP_LEVEL_IND,a.ITEM_FLUID_APPL_YN, a.EFF_STATUS FROM PH_TPN_CONST_GEN_NAME_LANG_VW a, PH_TPN_CONST_GRP_LANG_VW b WHERE b.CONST_GROUP_CODE = a.CONST_GROUP_CODE AND a.CONST_GENERIC_CODE=? AND A.LANGUAGE_ID = B.LANGUAGE_ID AND A.LANGUAGE_ID = ?") ;
			} // if condition Added for ML-MMOH-CRF-1126 - End
			else{
				pstmt = connection.prepareStatement("SELECT a.CONST_GENERIC_CODE, a.CONST_GENERIC_NAME, a.DISP_SRL_NO, a.CONST_GROUP_CODE, b.CONST_GROUP_NAME, a.UOM_SETUP_LEVEL_IND,a.ITEM_FLUID_APPL_YN FROM PH_TPN_CONST_GEN_NAME_LANG_VW a, PH_TPN_CONST_GRP_LANG_VW b WHERE a.EFF_STATUS='E' AND b.CONST_GROUP_CODE = a.CONST_GROUP_CODE AND a.CONST_GENERIC_CODE=? AND A.LANGUAGE_ID = B.LANGUAGE_ID AND A.LANGUAGE_ID = ?") ;
			}
			pstmt.setString(1,gCode);			 
			pstmt.setString(2,locale);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result.put("GNAME",resultSet.getString("CONST_GENERIC_NAME"));
				result.put("SRLNO",resultSet.getString("DISP_SRL_NO"));
				result.put("CGROUPCODE",resultSet.getString("CONST_GROUP_CODE"));
				result.put("CGROUPNAME",resultSet.getString("CONST_GROUP_NAME"));
				result.put("UOMFLAG",resultSet.getString("UOM_SETUP_LEVEL_IND"));
                result.put("ITEM_FLUID_REQ_YN",resultSet.getString("ITEM_FLUID_APPL_YN"));
               if(enableDisplay_yn){ // Added for ML-MMOH-CRF-1126 - Start
                result.put("EFF_STATUS",resultSet.getString("EFF_STATUS")); 
               } // Added for ML-MMOH-CRF-1126 - End
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
		//System.err.println("result---->"+result);
		return result;

}

public String getItemFluid()
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="";
		
		try {
			connection = getConnection() ;
			//this query retrieveds ITEM_FLUID_APPL_YN from ph_tpn_param
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_PARAMETERS_SELECT5" )) ;
			pstmt = connection.prepareStatement("SELECT ENERGY_UNIT, REGIMEN_PRESC_BASE_UNIT, PEAD_MAX_WEIGHT_VALUE,ADULT_MIN_WEIGHT_VALUE, EXPIRY_FOR_TPN_ADM, ITEM_FLUID_APPL_YN, ORD_REGIMEN_IND  FROM PH_TPN_PARAM WHERE MODULE_ID='PH'") ;
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result=resultSet.getString("ITEM_FLUID_APPL_YN");
				
			}
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			
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

 public HashMap insert() { // Added for ML-MMOH-CRF-1126 - Start
	    String debug=new String();
	    HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();
		ArrayList insertData = new ArrayList() ;
        ArrayList whereData  = new ArrayList() ;

		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(true));
		tabData.put("message","message");

		tabData.put( "PROPERTIES", getProperties() );
		String gCode=(String)recordSet.get("gCode");
		String gName=(String)recordSet.get("gName");
		String item_fluid_appl_yn=(String)recordSet.get("itmfld_req_yn")==null?"N":(String)recordSet.get("itmfld_req_yn");
		String dflt_during_order_yn=(String)recordSet.get("dflt_during_order_yn")==null?"Y":(String)recordSet.get("dflt_during_order_yn");
		String dflt_ord_unit_ind=(String)recordSet.get("dflt_ord_unit_ind")==null?"A":(String)recordSet.get("dflt_ord_unit_ind");
		if(item_fluid_appl_yn.equals(""))
			item_fluid_appl_yn="N";
		String Disp_srl_no=(String)recordSet.get("srlno");
		String constituent_group_code =(String)recordSet.get("cons_group");
		String uom_level=(String)recordSet.get("uom_level");
	    
		String eff_status=(String)recordSet.get("enabled_yn");

		if(eff_status.equals("") || eff_status == null)
			eff_status="D";
		
		insertData.add(gCode);
		insertData.add(gName);
		insertData.add(constituent_group_code);
		insertData.add(Disp_srl_no);
		insertData.add(uom_level);
		insertData.add(item_fluid_appl_yn);
		insertData.add(dflt_during_order_yn);
		insertData.add(dflt_ord_unit_ind.trim());
		insertData.add(eff_status);
		insertData.add(login_by_id);
		insertData.add(login_at_ws_no);
		insertData.add(login_facility_id);
		insertData.add(login_by_id);
		insertData.add(login_at_ws_no);
		insertData.add(login_facility_id);
		
		whereData.add(gCode);
		whereData.add(Disp_srl_no);
		
		 tabData.put( "properties", getProperties() );
         tabData.put( "InsertData",insertData);
         tabData.put( "WhereData",whereData);
		
		
		
		try{
			String SelectSQL="SELECT SUM (COUNT) FROM (SELECT COUNT (ROWID) COUNT FROM ph_tpn_const_generic_name WHERE const_generic_code = ? UNION SELECT COUNT (*) COUNT FROM ph_tpn_const_generic_name WHERE disp_srl_no = ? AND uom_setup_level_ind = 'I')";
			String InsertSQL="insert into PH_TPN_CONST_GENERIC_NAME(CONST_GENERIC_CODE,CONST_GENERIC_NAME,CONST_GROUP_CODE,DISP_SRL_NO,UOM_SETUP_LEVEL_IND,ITEM_FLUID_APPL_YN,DFLT_DURING_ORDER_YN,DFLT_ORD_UNIT_IND,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			sqlMap.put("SelectSQL", SelectSQL);
			sqlMap.put("InsertSQL", InsertSQL);
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); 
			paramArray[1] = sqlMap.getClass();
               
     			map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
     			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

     			if( ((Boolean) map.get( "result" )).booleanValue() ){
     				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH"));
     			}
     			else{
     				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
     					{
     					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common"));
     					map.put( "result",new Boolean(true));
     					}
     				
     				else{
     				  map.put( "message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
     				  map.put( "result",new Boolean(true));
     				}
     			}
                 
		
		}
		catch(Exception e){
			System.err.println( "Error In INSERT: map="+map+" tabData="+tabData ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag",debug);
            e.printStackTrace() ;
		}
		
	 
		map.put("flag",debug);
        return map ;

}

 public HashMap modify() {

//		HashMap result=new HashMap();
		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();
        Connection con = null; // Added for ML-MMOH-CRF-1126 
		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(true));
		tabData.put("message","message");

		tabData.put( "PROPERTIES", getProperties() );

		String gCode=(String)recordSet.get("gCode");
		String gName=(String)recordSet.get("gName");
		String item_fluid_appl_yn=(String)recordSet.get("itmfld_req_yn");
		if(item_fluid_appl_yn.equals(""))
			item_fluid_appl_yn="N";


		tabData.put("GCODE",gCode);
		tabData.put("GNAME",gName);
		tabData.put("ITEMFLUID",item_fluid_appl_yn);
		tabData.put("LOGIN_BY_ID",login_by_id);
		tabData.put("LOGIN_AT_WS_NO",login_at_ws_no);
		tabData.put("LOGIN_FACILITY_ID",login_facility_id);
		String eff_status=(String)recordSet.get("enabled_yn")==null?"D":(String)recordSet.get("enabled_yn"); // Added for ML-MMOH-CRF-1126
		boolean site = false;
		try{ // Added for ML-MMOH-CRF-1126 - Start
			con = getConnection();
			site = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "ASSESMENT_REQ_YN");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
				 try {
						closeConnection(con);
					}
					catch ( Exception e ) {
						e.printStackTrace() ;
					}
		}
		if(site){
		   if(eff_status.equals("")){
			   eff_status = "D";
		   }
		   tabData.put("EFF_STATUS",eff_status);
		   tabData.put("SITE_SPECIFIC","Y");
		}
		else{
			tabData.put("SITE_SPECIFIC","N");
		} // Added for ML-MMOH-CRF-1126 - End
		try
		{
			   String sql=" UPDATE PH_TPN_CONST_GENERIC_NAME SET  CONST_GENERIC_NAME=?,  MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,ITEM_FLUID_APPL_YN=? WHERE CONST_GENERIC_CODE=?";
			   if(site){ // Added for ML-MMOH-CRF-1126 - Start
				   sql=" UPDATE PH_TPN_CONST_GENERIC_NAME SET  CONST_GENERIC_NAME=?,EFF_STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,ITEM_FLUID_APPL_YN=? WHERE CONST_GENERIC_CODE=?";
			   } // Added for ML-MMOH-CRF-1126 - End
			   sqlMap.put("SQLUPDATE", sql);
				//sqlMap.put("SQLUPDATE", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_GENERIC_UPDATE" ) );
		
					/*TPNConsGenericHome home=null;
					TPNConsGenericRemote remote=null;
					InitialContext context = new InitialContext() ;
					Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSGENERIC" ) ) ;
					home  = (TPNConsGenericHome) PortableRemoteObject.narrow( object, TPNConsGenericHome.class ) ;
					remote = home.create() ; 

				//	map=localUpdate (tabData,sqlMap );
					map=remote.modify(tabData,sqlMap);*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSGENERIC" ),TPNConsGenericHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();
                    // System.err.println("tabData----->"+tabData);
                    // System.err.println("sqlMap----->"+sqlMap);
				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

              //  System.err.println("map----->"+map);

				if( ((Boolean) map.get( "result")).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				else
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			
		}
		 catch (Exception e)
		 {
			// 		System.err.println("6");
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

		try {
					
			 connection	= getConnection() ;

			 pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLUPDATE"));
			
			/* pstmt_update.setString(1,gName);
			 pstmt_update.setString(2,user);
			 pstmt_update.setString(3,wsno);
			 pstmt_update.setString(4,facility);
			 pstmt_update.setString(5,gCode);*/
            String item_fluid_appl_yn=(String)recordSet.get("itmfld_req_yn");
		   if(item_fluid_appl_yn.equals(""))
			item_fluid_appl_yn="N";

			 pstmt_update.setString(1,gName);
			 pstmt_update.setString(2,user);
			 pstmt_update.setString(3,wsno);
			 pstmt_update.setString(4,facility);
			 pstmt_update.setString(5,item_fluid_appl_yn);
			 pstmt_update.setString(6,gCode);
	
			tmpcount =pstmt_update.executeUpdate() ;
			if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Constituent Generic!!! ");
					return map;
			}
			else
			{
					map.put( "result", new Boolean( true) ) ;
					map.put( "msgid", "RECORD_INSERTED") ;

			}
			
			connection.commit();


		}//end of try
		
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Error During Updation into Constituent Generic!!!  " +e) ;

		}
		finally {
			try {
				//closeResultSet( resultSet );
				closeStatement( pstmt_update) ;
				closeConnection( connection );
				//closeConnection( connection, (Properties)tabData.get( "properties" ) );
				connection.rollback();
			}
			catch ( Exception fe ) {
			//	System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		return map ;
	}


	public String getSrlNo(String constGrpCode,String uomLevel) { // Added for ML-MMOH-CRF-1126 - Start
 			Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			String result="";
			
			try {
				connection = getConnection() ;
                if(uomLevel.equals("I")){
                	uomLevel="";
                }
				pstmt = connection.prepareStatement("SELECT DISP_SRL_NO SRL_NO FROM PH_TPN_CONST_GENERIC_NAME WHERE CONST_GROUP_CODE=? AND UOM_SETUP_LEVEL_IND=? UNION SELECT MAX(DISP_SRL_NO)+1 SRL_NO FROM PH_TPN_CONST_GENERIC_NAME WHERE CONST_GENERIC_CODE IS NOT NULL") ; // +1 Added for ML-MMOH-CRF-1266 [IN:068728]
				pstmt.setString(1, constGrpCode);
				pstmt.setString(2, uomLevel);
				resultSet = pstmt.executeQuery();
				if (resultSet.next()) {
					result=(Integer.parseInt(resultSet.getString("SRL_NO")))+""; // +1 removed for ML-MMOH-CRF-1266 [IN:068728]
					/*if(uomLevel.equals("G")){
					  if(Integer.parseInt(result)>1)
						result	= (Integer.parseInt(result)-1)+"";
					}*/ // commented for ML-MMOH-CRF-1266 [IN:068728] 
				}
				
			}
			catch ( Exception e ) {
				//System.err.println( "Error loading values from database1" ) ;
				e.printStackTrace() ;
				
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

	} // Added for ML-MMOH-CRF-1126 - End

				  
	/* Function specific methods end */
}

