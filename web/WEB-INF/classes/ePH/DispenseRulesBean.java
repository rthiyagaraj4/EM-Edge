/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;


public class DispenseRulesBean extends PhAdapter implements Serializable {

        protected String drug_category		        ="";
        protected String patient_class			    ="";
        protected String dispensing_group           ="";
        protected String max_dispense_durn          ="";
        protected String action				        ="";
		protected String msg_text			        ="";
		
        
        public DispenseRulesBean() {
        try
		{
            doCommon();
        }catch(Exception e) 
		{
			System.err.println("Exception in constructor"+e.toString()); e.printStackTrace();
		}
    }
	public HashMap loadIntialValues(String drugCatgCode,String patientClass,String disp_group_code,String action)
	{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";		
		HashMap initialValues		= new HashMap();
		try{
		connection = getConnection() ;
		sql_query        = PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_SELECT3");
		pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,drugCatgCode);
		pstmt.setString(2,patientClass);
		pstmt.setString(3,disp_group_code);
		pstmt.setString(4,action);
		pstmt.setString(5, getLanguageId());
		pstmt.setString(6, getLanguageId());
		resultSet			= pstmt.executeQuery();
			while(resultSet.next())
				{
				initialValues.put("DRUG_CATG_DESC",resultSet.getString("DRUG_CATG_DESC"));
				initialValues.put("STAT_GRP_DESC",resultSet.getString("STAT_GRP_DESC"));

				initialValues.put("SHORT_DESC",resultSet.getString("SHORT_DESC"));
				initialValues.put("MAX_DISP_DURATION",resultSet.getString("MAX_DISP_DURATION"));
				initialValues.put("MESSAGE",resultSet.getString("MESSAGE"));
				}
		
		} catch ( Exception e ) {
				initialValues.put("error",e);
                System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es)
					{
						System.err.println("Error while closing statements and resultsets"+es.toString());  es.printStackTrace();
					}
              }
		return initialValues;
	}
		 

	public HashMap loadIntialValues()
	{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		
		ArrayList drug_catg_code	= new ArrayList();
		ArrayList catg_desc			= new ArrayList();

		ArrayList stat_grp_id		= new ArrayList();
		ArrayList stat_grp_desc		= new ArrayList();
		
		ArrayList patient_class     = new ArrayList();
		ArrayList short_desc		= new ArrayList();	

		HashMap initialValues		= new HashMap();
	
		try {
		        connection  = getConnection() ;
		/******  Load Values for drug_catg_code *******************/
		sql_query           = PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_SELECT6");
        pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1, getLanguageId());
		resultSet			= pstmt.executeQuery();
			while(resultSet.next())
				{
				drug_catg_code.add(resultSet.getString("drug_catg_code"));
				catg_desc.add(resultSet.getString("short_desc"));
				}
		initialValues.put("drug_catg_code",drug_catg_code);
		initialValues.put("catg_desc",catg_desc);
		closeStatement(pstmt);
		closeResultSet(resultSet);
		sql_query           = PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_SELECT5");
       	pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1, getLanguageId());

		resultSet			= pstmt.executeQuery();

		while(resultSet.next())
		{
			patient_class.add(resultSet.getString("patient_class"));
			short_desc.add(resultSet.getString("short_desc"));
		}
		initialValues.put("patient_class",patient_class);
		initialValues.put("short_desc",short_desc);
		closeStatement(pstmt);
		closeResultSet(resultSet);
		sql_query           = PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_SELECT7");
       	pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;
		resultSet			= pstmt.executeQuery();
		while(resultSet.next())
		{
			stat_grp_id.add(resultSet.getString("stat_grp_id"));
			stat_grp_desc.add(resultSet.getString("stat_grp_desc"));
		}
		initialValues.put("stat_grp_id",stat_grp_id);
		initialValues.put("stat_grp_desc",stat_grp_desc);
	
		} catch ( Exception e ) {
				initialValues.put("error",e);
                System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es)
					{
						System.err.println("Error while closing statements and resultsets"+es.toString());  es.printStackTrace();
					}
              }
    	return initialValues;
	}
		 
/*********** Initialize the values for Schedule ***************/

    public void setAll( Hashtable recordSet ) {
		if(recordSet.get("mode") != null)
             mode = (String)recordSet.get("mode") ; 

		if(recordSet.get("drug_category") != null)
             drug_category = (String)recordSet.get("drug_category") ; 

		if(recordSet.get("patient_class") != null)
             patient_class = (String)recordSet.get("patient_class") ; 

		if(recordSet.get("dispensing_group") != null)
             dispensing_group = (String)recordSet.get("dispensing_group") ; 

		if(recordSet.get("dispense_duration") != null)
			 max_dispense_durn = (String)recordSet.get("dispense_duration") ; 
	
	     if(recordSet.get("action") != null)
             action = (String)recordSet.get("action") ; 

       if(recordSet.get("msg_text") != null)
             msg_text = (String)recordSet.get("msg_text") ; 
    }

    public HashMap validate() throws Exception {

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map ;
    }

		public ArrayList validateDispenseDuration(){
		
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList disp_duration	=	new ArrayList();
		try {
            
			connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT9") ) ;
            resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
				disp_duration.add(resultSet.getString("MAX_DURN_FOR_OP_PRES"));
				disp_duration.add(resultSet.getString("MAX_DURN_FOR_IP_PRES"));
			}
		
				} catch ( Exception e ) {
            System.err.println( "Error loading values from database" ) ;
            e.printStackTrace() ;
        } finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }catch(Exception es)
			{
				System.err.println("Error while closing statements and resultsets"+es.toString());  es.printStackTrace();
            }

        }
    return disp_duration;
    }

    public HashMap insert() {
	
		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		ArrayList insertData = new ArrayList() ;
        ArrayList whereData = new ArrayList() ;
		try{
            insertData.add( drug_category.trim() ) ;
            insertData.add( patient_class.trim() ) ;
    		insertData.add( dispensing_group.trim() ) ;
			insertData.add( max_dispense_durn.trim() ) ;
			insertData.add( action.trim() ) ;
			insertData.add( msg_text.trim() ) ;
			insertData.add( login_by_id.trim() ) ;
            insertData.add( login_at_ws_no.trim() ) ;
            insertData.add( login_facility_id.trim() ) ;
    		insertData.add( login_by_id.trim() ) ;
            insertData.add( login_at_ws_no.trim() ) ;
            insertData.add( login_facility_id.trim() ) ;
			
			whereData.add( drug_category.trim() ) ;
			whereData.add( patient_class.trim() ) ;
			whereData.add( dispensing_group.trim() ) ;

			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

            HashMap sqlMap = new HashMap() ;
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_SELECT2") );
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_INSERT") );

            /*SingleTableHandlerHome home = null;
            SingleTableHandlerRemote remote = null;*/

            try {
/*              InitialContext context = new InitialContext() ;
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
                    if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
                        map.put( "message", getMessage(getLanguageId(),"RECORD_EXISTS","PH") ) ;
                    else
                        map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
                }
            }
            catch(Exception e) {
                System.err.println( "Error Calling EJB : "+e ) ;
                map.put( "message", e.getMessage()) ;
                e.printStackTrace() ;
            }
        }
        catch(Exception e){
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
            e.printStackTrace() ;
        }
/*        finally {
            try {}
            catch( Exception ee ){
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;  ee.printStackTrace();
            }
        }//finally */
         
        return map ;
}//insert ends

public HashMap modify() {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		ArrayList modifyData = new ArrayList() ;
		try{
            modifyData.add( max_dispense_durn.trim() ) ;
			modifyData.add( action.trim() ) ;
			modifyData.add( msg_text.trim() ) ;
			modifyData.add( login_by_id.trim() ) ;
            modifyData.add( login_at_ws_no.trim() ) ;
            modifyData.add( login_facility_id.trim() ) ;
			modifyData.add( drug_category.trim() ) ;
			modifyData.add( patient_class.trim() ) ;
			modifyData.add( dispensing_group.trim() ) ;
			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "ModifyData",modifyData);
		    HashMap sqlMap = new HashMap() ;
            sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_UPDATE") );

/*          SingleTableHandlerHome home = null;
            SingleTableHandlerRemote remote = null;*/
            try {
            /*    InitialContext context = new InitialContext() ;
                Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

                home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
                remote = home.create() ;
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


                if( ((Boolean) map.get( "result" )).booleanValue() )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

                else{
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
                }
            }
            catch(Exception e) {
                System.err.println( "Error Calling EJB : "+e ) ;
                map.put( "message", e.getMessage()) ;
                e.printStackTrace() ;
            }
        }
        catch(Exception e){
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
            e.printStackTrace() ;
        }
/*        finally {
            try {}
            catch( Exception ee ){
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;  ee.printStackTrace();
            }
        }//finally  */
         
        return map ;
}//modify ends


public HashMap delete() {
         HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		ArrayList deleteData = new ArrayList() ;
        try{
            deleteData.add( drug_category.trim() ) ;
			deleteData.add( patient_class.trim() ) ;
			deleteData.add( dispensing_group.trim() ) ;
			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "DeleteData",deleteData);
		    HashMap sqlMap = new HashMap() ;
            sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_DELETE") );

/*          SingleTableHandlerHome home = null;
            SingleTableHandlerRemote remote = null;*/
            try {
/*              InitialContext context = new InitialContext() ;
                Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

                home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
                remote = home.create() ;
                map = remote.delete( tabData, sqlMap ) ;*/

				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


                if( ((Boolean) map.get( "result" )).booleanValue() )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
                else{
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

				}
            }
            catch(Exception e) {
                System.err.println( "Error Calling EJB : "+e ) ;
                map.put( "message", e.getMessage()) ;
                e.printStackTrace() ;
            }
        }
        catch(Exception e){
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
            e.printStackTrace() ;
        }
/*        finally {
            try {}
            catch( Exception ee ){
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;  ee.printStackTrace();
            }
        }//finally */
         
        return map ;
}

public void clear() 
{
      super.clear() ;
}


private void doCommon() throws Exception 
{
}

    /* Function specific methods end */
}
