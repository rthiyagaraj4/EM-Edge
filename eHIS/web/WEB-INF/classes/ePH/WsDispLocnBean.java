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
//import javax.rmi.* ;
//import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;


public class WsDispLocnBean extends PhAdapter implements Serializable {

		protected String ph_trn_type			    ="";
		protected String debug			            ="";
		protected Hashtable      hashMultiple;


    public WsDispLocnBean() {
        try {
            doCommon();
        }catch(Exception e) {        System.err.println( "Error loading @ start  :"+e ) ;
		}
    }
    public void setph_trn_type( String ph_trn_type ) {
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

		ArrayList DISP_LOCN_CODE	= new ArrayList();
		ArrayList SHORT_DESC		= new ArrayList();

		HashMap initialValues		= new HashMap();




		try {
		        connection  = getConnection() ;
		/******  Load Values for drug_catg_code *******************/
		sql_query           = PhRepository.getPhKeyValue("SQL_PH_WS_NO_FOR_DISP_LOCN_SELECT3");
        pstmt				= null;
		resultSet			= null;
		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,login_facility_id.trim());
		pstmt.setString(2, getLanguageId());
		resultSet			= pstmt.executeQuery();
		while(resultSet.next())
				{
				DISP_LOCN_CODE.add(resultSet.getString("DISP_LOCN_CODE"));
				SHORT_DESC.add(resultSet.getString("SHORT_DESC"));
				}
		initialValues.put("DISP_LOCN_CODE",DISP_LOCN_CODE);
		initialValues.put("SHORT_DESC",SHORT_DESC);


		} catch ( Exception e ) {
				initialValues.put("error",e);
                System.err.println( "Error loading Initial Values :"+e ) ;
                e.printStackTrace() ;

			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){        System.err.println( "Error loading Initial Values :"+es ) ;}
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

public HashMap insert()
{

    ArrayList insertData = new ArrayList() ;
    ArrayList whereData = new ArrayList() ;
    String debug="";

    for(int i=0; i<10;i++)
    {
        String wsno = "WS_NO"  + i ;
        ArrayList insertRow = new ArrayList() ;
        ArrayList whereRow = new ArrayList() ;

        if(!
              (  (((String)hashMultiple.get(wsno))).trim().equals("")

              )
          )
        {
			 insertRow.add( login_facility_id ) ;
			 insertRow.add((String)hashMultiple.get(  "DISP_LOCN_CODE"  ) ) ;
             insertRow.add( (String)hashMultiple.get(  ("WS_NO" + i)    )  ) ;



			insertRow.add( login_facility_id.trim() ) ;

            insertRow.add( login_at_ws_no.trim() ) ;

            insertRow.add( login_facility_id.trim() ) ;

            insertRow.add( login_by_id.trim() ) ;

            insertRow.add( login_at_ws_no.trim() ) ;

            insertRow.add( login_facility_id.trim() ) ;

			debug+="Where Data= Facilityid"+login_facility_id.trim()+"DispNO:"+(String)hashMultiple.get(  "DISP_LOCN_CODE"  ) + "WSNO:"+(String)hashMultiple.get(  ("WS_NO" + i)    );


			whereRow.add( login_facility_id.trim()) ;

			whereRow.add( (String)hashMultiple.get(  "DISP_LOCN_CODE"  ) ) ;

            whereRow.add( (String)hashMultiple.get(  ("WS_NO" + i)    )  ) ;
            insertData.add( insertRow ) ;
            whereData.add( whereRow ) ;
        }
        }//for

        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "InsertData",insertData);
        tabData.put( "WhereData",whereData);
		 HashMap sqlMap = new HashMap() ;
        try{
			debug+="Select SQL"+PhRepository.getPhKeyValue("SQL_PH_WS_NO_FOR_DISP_LOCN_KEY");

            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_WS_NO_FOR_DISP_LOCN_KEY" ) );
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_WS_NO_FOR_DISP_LOCN_INSERT") );
        }catch(Exception e){
            e.printStackTrace();
        }



return CallSingleTableHandler( tabData,sqlMap,debug );
}


public HashMap delete() {

         HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		ArrayList deleteData = new ArrayList() ;
        try{

			debug +=login_facility_id.trim();
			debug +=(String)hashMultiple.get("DISP_CODE");
			debug +=(String)hashMultiple.get("WS_NO");

			deleteData.add(login_facility_id.trim()) ;
			deleteData.add(((String)hashMultiple.get("DIS_CODE")).trim()) ;
            deleteData.add(((String)hashMultiple.get("WS_NO")).trim()) ;
			HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "DeleteData",deleteData);
		    HashMap sqlMap = new HashMap() ;
            sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_WS_NO_FOR_DISP_LOCN_DELETE") );

   //         SingleTableHandlerHome home = null;
  //       SingleTableHandlerRemote remote = null;
            try {
/*                InitialContext context = new InitialContext() ;
                Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

                home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
                remote = home.create() ;
                map = remote.delete( tabData, sqlMap ) ; */
				
  Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());

  Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

  Object argArray[] =new Object[2];
  argArray[0]= tabData;
  argArray[1]=sqlMap;

  Class  paramArray[] = new Class[2];
  paramArray[0]= tabData.getClass();
  paramArray[1] = sqlMap.getClass();
		
 map = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
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
        /*finally {
            try {}
            catch( Exception ee ){
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;
            }
        }*/ //finally
		map.put( "flag", debug) ;
        return map ;
}

	public void clear() {
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}

 	public String getDISPDESC(String WS_NO,String DISP_CODE) throws Exception
		{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String debug="";
		String DISPCODE="";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_WS_NO_FOR_DISP_LOCN_SELECT2") );
			pstmt.setString( 1,login_facility_id );
			pstmt.setString(2,DISP_CODE.trim());
			pstmt.setString(3,WS_NO.trim());
			pstmt.setString(4, getLanguageId());
			resultSet = pstmt.executeQuery() ;


			if ( resultSet.next() ){
				DISPCODE=resultSet.getString("des");
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
				}catch(Exception es){				System.err.println( "Error loading values from database" ) ;
				es.printStackTrace() ;
				throw es ;

				}
			}
			debug+="hello ="+DISPCODE;
			return DISPCODE;
	}

	public String getWSNO(String WS_NO,String DISP_CODE) throws Exception
			{
			Connection connection	= null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet		= null ;
			String debug="";
			String wsno="";
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_WS_NO_FOR_DISP_LOCN_SELECT2") );
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,DISP_CODE.trim());
				pstmt.setString(3,WS_NO.trim());
				pstmt.setString(4,getLanguageId());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet.next() ){
					wsno=resultSet.getString("wsno");
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
					}catch(Exception es){				System.err.println( "Error loading values from database" ) ;
				es.printStackTrace() ;
				throw es ;

					}
				}
				debug+="hello ="+wsno;
				return wsno;
	}


	private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap ,String debug)
	 {
	    HashMap map = new HashMap() ;
	    map.put( "result", new Boolean( false ) ) ;

//	    SingleTableHandlerHome home = null;
//	    SingleTableHandlerRemote remote = null;
	    try {
/*	        InitialContext context = new InitialContext() ;
	        Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
	        home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
	        remote = home.create() ;
				        if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
	            map = remote.singleBatchHandler( tabData, sqlMap ) ;
	        }else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
	            map = remote.modify( tabData, sqlMap ) ;
	        }else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) ){
	             map = remote.delete( tabData, sqlMap ) ;
	        }
			*/


    Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());

  Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

  Object argArray[] =new Object[2];
  argArray[0]= tabData;
  argArray[1]=sqlMap;

  Class  paramArray[] = new Class[2];
  paramArray[0]= tabData.getClass();
  paramArray[1] = sqlMap.getClass();
		
if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
   map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			
}else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
  map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
}else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) ){
  map = (HashMap)(busObj.getClass().getMethod("delte",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				 
			
}

			if( ((Boolean) map.get( "result" )).booleanValue() )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else {
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS") ) {
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
				else
					map.put( "message", map.get("msgid") ) ;
			}
		}
		catch(Exception e) {
			System.err.println( "Error Calling EJB classcast : "+e ) ;
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}
/*		finally {
			try {
//				if( remote != null )
//					remote.remove() ;
			}
			catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map;
	}
}

