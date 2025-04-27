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
/*port javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;


public class DocumentTypeBean extends PhAdapter implements Serializable {

		protected String ph_trn_type			    ="";
		protected String debug			            ="";
		protected Hashtable      hashMultiple;


    public DocumentTypeBean() {
        try 
		{
            doCommon();
        }
		catch(Exception e) 
		{
			System.out.println("Exception in constructor"+e.toString());
		}
    }

    public void setph_trn_type( String ph_trn_type )
	{
			if(ph_trn_type==null)
				this.ph_trn_type="";
			else
				this.ph_trn_type = ph_trn_type  ;
	}
	public String getph_trn_type() {
	        return this.ph_trn_type  ;
    }

	public String getDebug(){
		return debug;
	}

	public HashMap loadIntialValues()
	{
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";

		ArrayList PH_TRN_TYPE	= new ArrayList();
		//ArrayList ST_TRN_TYPE_CODE	= new ArrayList();

		ArrayList SHORT_DESC		= new ArrayList();
		//ArrayList SHORT_DESC1		= new ArrayList();

		HashMap initialValues		= new HashMap();

		try {
		        connection  = getConnection() ;
		/******  Load Values for drug_catg_code *******************/
		sql_query           = PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_SELECT1");
        pstmt				= null;
		resultSet			= null;

		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,getLanguageId());
		resultSet			= pstmt.executeQuery();
		while(resultSet.next())
		{
				PH_TRN_TYPE.add(resultSet.getString("PH_TRN_TYPE"));
				SHORT_DESC.add(resultSet.getString("SHORT_DESC"));
		}
		initialValues.put("PH_TRN_TYPE",PH_TRN_TYPE);
		initialValues.put("SHORT_DESC",SHORT_DESC);
		closeStatement(pstmt);
		closeResultSet(resultSet);

	/*	sql_query           = PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_SELECT2");
       	pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,getLanguageId());
		resultSet			= pstmt.executeQuery();
			while(resultSet.next())
				{
				ST_TRN_TYPE_CODE.add(resultSet.getString("ST_TRN_TYPE_CODE"));
				SHORT_DESC1.add(resultSet.getString("SHORT_DESC"));
				}
		initialValues.put("ST_TRN_TYPE_CODE",ST_TRN_TYPE_CODE);
		initialValues.put("SHORT_DESC1",SHORT_DESC1);*/
		} catch ( Exception e ) {
				initialValues.put("error",e);
                System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;

			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){
						System.out.println("Exception while closing statements and resultsets"+es.toString());
						es.printStackTrace() ;
					}
              }

		return initialValues;

	}

/*********** Initialize the values for Schedule ***************/
/*****************************************************************************/
 public void setAll( Hashtable recordSetMultiple ) {
        hashMultiple = recordSetMultiple ;
        this.mode =(String)recordSetMultiple.get("mode");
 }
/******************************   insert()  *********************************/


    public HashMap insert() {

		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;

		String test="";
		ArrayList insertData = new ArrayList() ;
        ArrayList whereData = new ArrayList() ;
		try{

			insertData.add((String)hashMultiple.get(  "PH_TRN_TYPE"  ) ) ;
			insertData.add( (String)hashMultiple.get(  "TRN_TYPE_CODE"  )  ) ;

			insertData.add( login_by_id  ) ;
			insertData.add( login_at_ws_no  ) ;
			insertData.add( login_facility_id ) ;
			insertData.add( login_by_id  ) ;
			insertData.add( login_at_ws_no  ) ;
			insertData.add( login_facility_id ) ;
			insertData.add( login_facility_id ) ;


			whereData.add( (String)hashMultiple.get(  "PH_TRN_TYPE"  ) ) ;
			whereData.add( (String)hashMultiple.get(  "TRN_TYPE_CODE"  ) ) ;

			test = test + (String)hashMultiple.get(  "PH_TRN_TYPE"  )+(String)hashMultiple.get(  "TRN_TYPE_CODE"  );


			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

            HashMap sqlMap = new HashMap() ;
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_SELECT6") );
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_INSERT") );

/*          SingleTableHandlerHome home = null;
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
                        map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"Common") ) ;
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
        catch(Exception e){
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
            e.printStackTrace() ;
        }
/*        finally {
            try {}
            catch( Exception ee ){
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;
            }
        }//finally */
		map.put( "flag", test) ;

        return map ;
}//insert ends

public HashMap modify() {


        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		ArrayList modifyData = new ArrayList() ;

		try{
            modifyData.add(((String)hashMultiple.get("st_doc_type")).trim()) ;
			modifyData.add( login_by_id.trim() ) ;
            modifyData.add( login_at_ws_no.trim() ) ;
            modifyData.add( login_facility_id.trim() ) ;
			modifyData.add(((String)hashMultiple.get("PH_TRN_TYPE_CODE")).trim()) ;
			modifyData.add( login_facility_id.trim() ) ;

			debug = debug + "st doc:"+(String)hashMultiple.get("st_doc_type")+", PH_TRN_TYPE_CODE:"+(String)hashMultiple.get("PH_TRN_TYPE_CODE")+",SQL:"+PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_UPDATE");

			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "ModifyData",modifyData);
		    HashMap sqlMap = new HashMap() ;
            sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_UPDATE") );

        /*  SingleTableHandlerHome home = null;
            SingleTableHandlerRemote remote = null;*/
            try {
/*              InitialContext context = new InitialContext() ;
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
                    map.put( "message", (map.get("msgid"))) ;
                }
            }
            catch(Exception e) {
                System.err.println( "Error Calling EJB : "+e ) ;
                map.put( "message", e.getMessage()) ;
                map.put("flag",debug);
                e.printStackTrace() ;
            }
        }
        catch(Exception e){
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
            map.put("flag",debug);
            e.printStackTrace() ;
        }
/*        finally {
            try {}
            catch( Exception ee ){
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;
            }
        }//finally  */
		map.put( "flag", debug) ;
        return map ;

}//modify ends


public HashMap delete() {

         HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		ArrayList deleteData = new ArrayList() ;
        try{
			debug  = debug + (String)hashMultiple.get("PH_TRN_TYPE_CODE");
            deleteData.add(((String)hashMultiple.get("PH_TRN_TYPE_CODE")).trim()) ;
            deleteData.add(((String)hashMultiple.get("ST_TRN_TYPE_CODE")).trim()) ;
			deleteData.add(login_facility_id) ;
			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "DeleteData",deleteData);
		    HashMap sqlMap = new HashMap() ;
            sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_DELETE") );

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
                    map.put( "message", (map.get("msgid"))) ;
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
        finally {
            try {}
            catch( Exception ee ){
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;
            }
        }//finally
		map.put( "flag", debug) ;
        return map ;
}

 public void clear() 
 {
              super.clear() ;
 }


 private void doCommon() throws Exception {

    }

 public ArrayList getDrugCodeRelatedInfo(String ph_trn_type) throws Exception
	{
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;

	ArrayList record=new ArrayList();
	try {

		connection = getConnection() ;
		pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_SELECT5") );
		pstmt.setString( 1,login_facility_id );
		pstmt.setString(2,ph_trn_type.trim());
		resultSet = pstmt.executeQuery() ;

           if ( resultSet != null )
            {
                while ( resultSet.next() )
                {
                  record.add(	resultSet.getString("TRN_TYPE_DESC"));
				  record.add(	resultSet.getString("TRN_TYPE_CODE"));
                }
            }


		}
		catch ( Exception e )
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
               System.out.println("Exception while closing statements and resultsets"+es.toString());
			}
		}
		return record;
	}

	public ArrayList loadDocumentType(String ph_trn_type, String st_doc_type) throws Exception	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList result		=	new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_SELECT8") );
			pstmt.setString(1,ph_trn_type.trim());
			pstmt.setString(2,st_doc_type.trim());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,login_facility_id);

			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() ){
				result.add(checkForNull(resultSet.getString("PH_TRN_TYPE_CODE")));
				result.add(checkForNull(resultSet.getString("PH_TRN_DESC")));
				result.add(checkForNull(resultSet.getString("ST_DOC_TYPE_CODE")));
				result.add(checkForNull(resultSet.getString("ST_DOC_DESC")));
				}
			
			}catch ( Exception e ){
				System.err.println( "Error loading document type vals" ) ;
				e.printStackTrace() ;
				throw e ;
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
				    System.out.println("Exception while closing statements and resultsets"+es.toString());
				}
			}
			
			return result;
	}

   

	public ArrayList getStockTransactionType(String ph_trn_type) throws Exception	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList st_trn_type	=	new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_SELECT3") );
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,ph_trn_type.trim());
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while ( resultSet.next() ){
				st_trn_type.add(checkForNull(resultSet.getString("DOC_TYPE_CODE")));
				st_trn_type.add(checkForNull(resultSet.getString("SHORT_DESC")));
				}
			
			}catch ( Exception e ){
				System.err.println( "Error loading stock trn types" ) ;
				e.printStackTrace() ;
				throw e ;
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
				    System.out.println("Exception while closing statements and resultsets"+es.toString());
				}
			}
			
			return st_trn_type;
	}

		
    /* Function specific methods end */


public String getDrugCodeRelatedInfo3(String ph_trn_type) throws Exception
		{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String Stdoc="";
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_SELECT4") );
			pstmt.setString(1,ph_trn_type.trim());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,login_facility_id);

			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() ){
				Stdoc=resultSet.getString("Short");
				}
			}
					catch ( Exception e ){
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
				    System.out.println("Exception while closing statements and resultsets"+es.toString());
				}
			}
			return Stdoc;
	}
}
