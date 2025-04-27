/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import java.util.StringTokenizer;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;


public class BuildMARRules extends PhAdapter implements Serializable {
	
		protected String debug		    = "";
		protected String facility_id    = "";
		protected String app_pat_class  = "";
		protected String location 		= "";
		protected String priority 		= "";
		protected String form 			= "";
		protected String mar_defaulting = "";

		protected Hashtable      hashMultiple;

		public BuildMARRules() {
        try 
		{
            doCommon();
        }
		catch(Exception e) 
		{
			System.err.println("Exception in constructor"+e.toString());
		}
    }
	
	private void doCommon() throws Exception 
	{
	}
	
	public void clear() {
		super.clear();
	}
	
	public void setFacilityId(String facility_id) {
		this.facility_id = facility_id;
	}
	
	public String getFacilityId() {
		return facility_id;
	}
	

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setFacility_Id(String facility_id) {
		this.facility_id = facility_id;
	}
	
	public String getFacility_Id() {
		return facility_id;
	}
	
	public void setApp_Pat_Class(String app_pat_class) {
		this.app_pat_class = app_pat_class;
	}
	
	public String getApp_Pat_Class() {
		return app_pat_class;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setForm(String form) {
		this.form = form;
	}
	
	public String getForm() {
		return form;
	}
	
	public void setMar_Defaulting(String mar_defaulting) {
		this.mar_defaulting = mar_defaulting;
	}
	
	public String getMar_Defaulting() {
		return mar_defaulting;
	}
	
	 public void setAll( Hashtable recordSetMultiple ) {
        hashMultiple = recordSetMultiple ;
        hashMultiple = recordSetMultiple ;
        this.mode =(String)recordSetMultiple.get("mode");
 }
	
	// To Load Applicable Patient Classes on screen load 
	public HashMap loadIntialValues(String facilityId) throws Exception
	{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String appPatClasses		= "";

		ArrayList APP_PAT_CLASSES			= new ArrayList();
		ArrayList APP_PAT_CLASSES_DESC		= new ArrayList();
		
		HashMap initialValues		= new HashMap();

		try {
		        connection  = getConnection() ;
		
		sql_query           = PhRepository.getPhKeyValue("SQL_PH_BUILD_MAR_RULE_PAT_CLASS");
        pstmt				= null;
		resultSet			= null;

		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,facilityId);
		resultSet			= pstmt.executeQuery();
		while(resultSet.next())
		{
			appPatClasses=resultSet.getString("BUILD_MAR_INIT_VALUES");
			StringTokenizer st = new StringTokenizer(appPatClasses,"~");
				while(st.hasMoreTokens())
				{
					String currVal = st.nextToken();
					
					if(!currVal.equals("N")){
						APP_PAT_CLASSES.add(currVal);
					}
					
					if(currVal.equals("IP")){
						 APP_PAT_CLASSES_DESC.add(MessageManager.getLabel("en","Common.inpatient.label","Common"));
					}
					else if(currVal.equals("OP")){
						 APP_PAT_CLASSES_DESC.add(MessageManager.getLabel("en","Common.Outpatient.label","Common"));
					}
					else if(currVal.equals("DC")){
						 APP_PAT_CLASSES_DESC.add(MessageManager.getLabel("en","Common.daycare.label","Common"));
					}
					else if(currVal.equals("EM")){
						 APP_PAT_CLASSES_DESC.add(MessageManager.getLabel("en","Common.emergency.label","Common"));
					}
					else if(currVal.equals("DM")){
						APP_PAT_CLASSES_DESC.add(MessageManager.getLabel("en","Common.DischargeMedication.label","Common"));
					}	
					
				}
		}
		
		initialValues.put("APP_PAT_CLASSES",APP_PAT_CLASSES);
		initialValues.put("APP_PAT_CLASSES_DESC",APP_PAT_CLASSES_DESC);
		closeStatement(pstmt);
		closeResultSet(resultSet);

		} catch ( Exception e ) {
				initialValues.put("error",e);
                System.err.println( "Error loading Initial Values Build MAR Rules:"+e ) ;
                e.printStackTrace() ;

			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){
						System.err.println("Exception while closing statements and resultsets"+es.toString());
						es.printStackTrace() ;
					}
              }

		return initialValues;
}
	
	// To load Location values 
	public HashMap loadLocationValues(String facility_id, String pat_class, String locale) throws Exception
	{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList Loc_Code = new ArrayList();
		ArrayList Loc_Desc = new ArrayList();
		HashMap Loc_Code_Desc = new HashMap();
		
		try {
		       connection  = getConnection() ;
				
		if(pat_class.toUpperCase().equals("OP") || pat_class.toUpperCase().equals("EM"))
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_BUILD_MAR_RULE_LOCATION2");
		else
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_BUILD_MAR_RULE_LOCATION1");
		
        pstmt				= null;
		resultSet			= null;
			
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locale);
		resultSet			= pstmt.executeQuery();
		while(resultSet.next())
		{	
			Loc_Code.add(resultSet.getString("LOCATION_CODE").trim());
			Loc_Desc.add(resultSet.getString("SHORT_DESC").trim().replace("'","\\'"));   //   ' Replaced to \\'  to avoid js error in BuildMARRulesValidate.jsp
		}
		
		if(Loc_Code.size()>=1)
		{
			Loc_Code.add(0,"*A");
			Loc_Desc.add(0,"All Locations");
		}
		
		Loc_Code_Desc.put("LOCATION_CODE",Loc_Code);
		Loc_Code_Desc.put("LOCATION_DESC",Loc_Desc);
		closeStatement(pstmt);
		closeResultSet(resultSet);

		} catch ( Exception e ) {
                System.err.println( "Error loading Initial Values Build MAR Rules:"+e ) ;
                e.printStackTrace() ;
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){
						System.err.println("Exception while closing statements and resultsets"+es.toString());
						es.printStackTrace() ;
					}
              }
		return Loc_Code_Desc;
	}
	// To load Form values 
	public HashMap loadFormValues(String locale) throws Exception
	{
		
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
	//	String appPatClasses		= "";  Removed for IN063877
		HashMap Form_Code_Desc = new HashMap();
		ArrayList Form_Code = new ArrayList();
		ArrayList Form_Desc = new ArrayList();
		
		try {
				connection  = getConnection() ;
				sql_query           = PhRepository.getPhKeyValue("SQL_PH_BUILD_MAR_RULE_FORM");
				pstmt				= null;
				resultSet			= null;
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,getLanguageId());
				pstmt.setString(2,locale);
				resultSet			= pstmt.executeQuery();
				
				while(resultSet.next())
				{	
					Form_Code.add(resultSet.getString("FORM_CODE").trim());
					Form_Desc.add(resultSet.getString("FORM_DESC").trim().replace("'","\\'"));
				}

				if(Form_Code.size()>=1)
				{
					Form_Code.add(0,"*A");
					Form_Desc.add(0,"All Forms");
				}

				Form_Code_Desc.put("FORM_CODE",Form_Code);
				Form_Code_Desc.put("FORM_DESC",Form_Desc);
			
				closeStatement(pstmt);
				closeResultSet(resultSet);

			} catch ( Exception e ) {
				System.err.println( "Error loading form Values in Build MAR Rules:"+e ) ;
                e.printStackTrace() ;
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){
						System.err.println("Exception while closing statements and resultsets"+es.toString());
						es.printStackTrace() ;
					}
              }

		return Form_Code_Desc;
	}

 // To Insert records in Add mode
   public HashMap insert() {
		
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put( "message", "success.." ) ;
		ArrayList insertData = new ArrayList();
		ArrayList whereData = new ArrayList();
		try {
								
			insertData.add(((String)hashMultiple.get("FACILITY_ID")).trim());
			insertData.add(((String)hashMultiple.get("APP_PAT_CLASSES")).trim());
			insertData.add(((String)hashMultiple.get("LOCATION")).trim());
			insertData.add(((String)hashMultiple.get("FORM")).trim());
			insertData.add(((String)hashMultiple.get("PRIORITY")).trim());
			insertData.add(((String)hashMultiple.get("MAR_DEFAULTING")).trim());
			insertData.add( login_by_id  ) ;
			insertData.add( login_at_ws_no  ) ;
			insertData.add( login_facility_id ) ;
			insertData.add( login_by_id  ) ;
			insertData.add( login_at_ws_no  ) ;
			insertData.add( login_facility_id ) ;
			
			whereData.add(((String)hashMultiple.get("FACILITY_ID")).trim());
			whereData.add(((String)hashMultiple.get("APP_PAT_CLASSES")).trim());
			whereData.add(((String)hashMultiple.get("LOCATION")).trim());
			whereData.add(((String)hashMultiple.get("FORM")).trim());
			whereData.add(((String)hashMultiple.get("PRIORITY")).trim());
		
			HashMap tabData = new HashMap();
			tabData.put("properties", getProperties());
			tabData.put("InsertData", insertData);
			tabData.put("WhereData", whereData);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_BUILD_MAR_RULE_INSERT_CHECK") );
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_BUILD_MAR_RULE_INSERT") );
		try{
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();
				
				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
                if( ((Boolean) map.get( "result" )).booleanValue() )
				{
				     map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH"));
				}
                else{
								
                    if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common"));
                    else
                      map.put( "message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
                }

		} catch (Exception e) {
			System.err.println("Error Calling EJB : " + e);
			map.put("message", e.getMessage());
			map.put("flag", debug.toString());
			e.printStackTrace();
		}
	}
	catch(Exception e){
            map.put( "message", "exp :"+e.getMessage()) ;
            map.put("flag",debug);
            e.printStackTrace() ;
		}
		
		return map;
	}

// To Insert records in Modify mode
public HashMap modify() {

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		ArrayList modifyData = new ArrayList() ;
	//	ArrayList whereData= new ArrayList();  Removed for IN063877

	try{
            modifyData.add(((String)hashMultiple.get("MAR_DEFAULTING")).trim()) ;
			modifyData.add( login_by_id.trim() ) ;
            modifyData.add( login_at_ws_no.trim() ) ;
            modifyData.add( login_facility_id.trim() ) ;
			modifyData.add(((String)hashMultiple.get("FACILITY_ID")).trim());
			modifyData.add(((String)hashMultiple.get("APP_PAT_CLASSES_CODE")).trim());
			modifyData.add(((String)hashMultiple.get("LOCATION_CODE")).trim());
			modifyData.add(((String)hashMultiple.get("FORM_CODE")).trim());
			modifyData.add(((String)hashMultiple.get("PRIORITY_CODE")).trim());

			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "ModifyData",modifyData);

		    HashMap sqlMap = new HashMap() ;
            sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_BUILD_MAR_RULE_UPDATE") );

        try {

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
            if( ((Boolean) map.get( "result" )).booleanValue() )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
            else{
                    map.put( "message", (map.get("msgid"))) ;
                }
        }
		catch(Exception e){
                System.err.println( "Error Calling EJB : "+e ) ;
                map.put( "message", e.getMessage()) ;
                map.put("flag",debug);
                e.printStackTrace() ;
        }
     }
      catch(Exception e){
            map.put( "message", "exp :"+e.getMessage()) ;
            map.put("flag",debug);
            e.printStackTrace() ;
		}
		map.put( "flag", debug) ;
        return map ;

}

// To load the descriptions of Form / Location Code
public String getDesc(String code, String locale,String field, String facility,String pat_class) throws Exception
{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
	//	String appPatClasses		= "";   Removed for IN063877
		String desc					="";
		
		try {
		       connection  = getConnection() ;
		
		if(field.equals("Form")){
			sql_query      = "SELECT FORM_DESC FROM PH_FORM_LANG_VW WHERE FORM_CODE=? AND LANGUAGE_ID=?";
		}
		else if(field.equals("Location")){
			if(pat_class.toUpperCase().equals("OP") || pat_class.toUpperCase().equals("EM")){
					sql_query = "SELECT SHORT_DESC FROM OP_CLINIC_LANG_VW WHERE FACILITY_ID =? AND LANGUAGE_ID=?";
			}
			else{
			sql_query           = "SELECT SHORT_DESC FROM PH_DISP_LOCN_LANG_VW WHERE FACILITY_ID='"+facility+"' AND  DISP_LOCN_CODE=? AND LANGUAGE_ID=?";
			}
		}	
			
        pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,code);
		pstmt.setString(2,locale);
		resultSet			= pstmt.executeQuery();
		if(resultSet.next())
		{		
			desc=resultSet.getString(1);
		}
			
		closeStatement(pstmt);
		closeResultSet(resultSet);

		} catch ( Exception e ) {
		
                System.err.println( "Error in loading Form Description"+e ) ;
                e.printStackTrace() ;

		} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){
						System.err.println("Exception while closing statements and resultsets"+es.toString());
						es.printStackTrace() ;
					}
              }
		return desc;
	}
   
}

