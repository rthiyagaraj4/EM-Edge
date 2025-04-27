/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.SingleTableHandler.*;
import eCommon.Common.* ;


public class PINAuthorizedRightsBean extends PhAdapter implements Serializable {
    protected Hashtable                   hashMultiple;
	
	//Validate Method
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	// setAll method
  public void setAll( Hashtable recordSetMultiple ) {
			hashMultiple = recordSetMultiple ;
			this.mode =(String)recordSetMultiple.get("mode");
	 }
 /******************************   insert()  *********************************/
public HashMap insert()
	{
	Connection conn				= null;
	PreparedStatement pstPinNo	= null;
	ResultSet resultSet			= null;
	ArrayList insertData = new ArrayList() ;
	ArrayList whereData  = new ArrayList() ;
	String User_id		 = "";
	String Pin_no		 = "";
	HashMap tabData = new HashMap() ;
	HashMap sqlMap = new HashMap() ;

	try{
		conn		= getConnection();
		pstPinNo	= conn.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PIN_NO_AUTH_RIGHTS_SELECT2"));
		for(int i=0; i < 10;i++)
		{
			String ID = "user_id" + i ;
			ArrayList insertRow = new ArrayList() ;
			ArrayList whereRow  = new ArrayList() ;		
			if(!((String)hashMultiple.get(ID)).trim().equals(""))
			{
				User_id		=  (String)hashMultiple.get(("user_id" + i));
				insertRow.add( (String)hashMultiple.get(("user_id" + i)) );
				insertRow.add( (String)hashMultiple.get(("User_name" + i)) );
				try{	 
					pstPinNo.setString(1,User_id);
					resultSet = pstPinNo.executeQuery();
					if(resultSet.next()){
						Pin_no = resultSet.getString("PIN_NO");
						if(Pin_no == null) Pin_no = "";
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					try{
						closeResultSet(resultSet);
					}
					catch(Exception exception) {
						exception.printStackTrace();
					}
				}
				
				insertRow.add(  Pin_no                   ) ;			
				insertRow.add(	login_by_id              ) ;
				insertRow.add(  login_at_ws_no           ) ;
				insertRow.add(  login_facility_id        ) ;
				insertRow.add(  login_by_id              ) ;
				insertRow.add(  login_at_ws_no           ) ;
				insertRow.add(  login_facility_id        ) ;		
				whereRow.add( (String)hashMultiple.get(("user_id" + i))) ;

				insertData.add( insertRow ) ;
				whereData.add( whereRow ) ;
				
			 }			
		}  
	
	
		tabData.put( "properties", getProperties() );
		tabData.put( "InsertData",insertData);
		tabData.put( "WhereData",whereData);
	
		
		try{
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_PIN_AUTH_RIGHTS_SELECT4") );
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_PIN_AUTH_RIGHTS_INSERT") );
		}catch(Exception e){
			e.printStackTrace();
		}

		
	
	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		try{
		closeResultSet(resultSet);
		closeStatement(pstPinNo);
		closeConnection(conn);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}return CallSingleTableHandler( tabData,sqlMap );
}

 /*  public HashMap insert()
		{
			Connection conn=null;
			PreparedStatement pstPinNo=null;
			ResultSet resultSet		= null;
			ArrayList insertData = new ArrayList() ;
			ArrayList whereData  = new ArrayList() ;
			String User_id="";
			String Pin_no="";
			for(int i=0; i < 10;i++)
			{
				String ID = "user_id" + i ;
				ArrayList insertRow = new ArrayList() ;
				ArrayList whereRow  = new ArrayList() ;		
				
		     if(!((String)hashMultiple.get(ID)).trim().equals(""))
				{
					User_id=(String)hashMultiple.get(("user_id" + i));
					insertRow.add( (String)hashMultiple.get(("user_id" + i)));
					insertRow.add( (String)hashMultiple.get(("User_name" + i)));
					try{	
					conn = getConnection();
					pstPinNo		= conn.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PIN_NO_AUTH_RIGHTS_SELECT2"));
					pstPinNo.setString(1,User_id);
					resultSet=pstPinNo.executeQuery();
					if(resultSet.next()){
						Pin_no=resultSet.getString("PIN_NO");
						if(Pin_no==null) Pin_no="";
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					try{
                closeResultSet(resultSet);
                closeStatement(pstPinNo);
                closeConnection(conn);
            }
            catch(Exception exception) {
                exception.printStackTrace();
            }
				}
					
					insertRow.add(  Pin_no                   ) ;			
					insertRow.add(	login_by_id              ) ;
					insertRow.add(  login_at_ws_no           ) ;
					insertRow.add(  login_facility_id        ) ;
					insertRow.add(  login_by_id              ) ;
					insertRow.add(  login_at_ws_no           ) ;
					insertRow.add(  login_facility_id        ) ;		
					whereRow.add( (String)hashMultiple.get(("user_id" + i))) ;

					 insertData.add( insertRow ) ;
					  whereData.add( whereRow ) ;
					
     			 }			
			}       
				
				HashMap tabData = new HashMap() ;
				tabData.put( "properties", getProperties() );
				tabData.put( "InsertData",insertData);
				 tabData.put( "WhereData",whereData);
				HashMap sqlMap = new HashMap() ;
				try{
					sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_PIN_AUTH_RIGHTS_SELECT4") );
					sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_PIN_AUTH_RIGHTS_INSERT") );
				}catch(Exception e){
					e.printStackTrace();
				}

		return CallSingleTableHandler( tabData,sqlMap );
		}  */

public HashMap delete()
{
  
    ArrayList insertRow     = new ArrayList() ;

        HashMap tabData = new HashMap() ;
		insertRow.add( (String)hashMultiple.get("user_id"));
        tabData.put( "properties", getProperties() );
        tabData.put( "DeleteData",insertRow);

        HashMap sqlMap = new HashMap() ;
        try{
            sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue( "SQL_PH_PIN_AUTH_RIGHTS_DELETE" ) );
        }catch(Exception e){
            e.printStackTrace();
        }



return CallSingleTableHandler( tabData,sqlMap );
}

private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap )
 {
    HashMap map = new HashMap() ;
    map.put( "result", new Boolean( false ) ) ;

    /*SingleTableHandlerHome home = null;
    SingleTableHandlerRemote remote = null;*/
    try {
       /* InitialContext context = new InitialContext() ;
        Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
        home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
        remote = home.create() ;

        if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
            map = remote.singleBatchHandler( tabData, sqlMap ) ;
        }else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
            map = remote.modify( tabData, sqlMap ) ;
        }else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) ){
             map = remote.delete( tabData, sqlMap ) ;
        }*/

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

		 if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
            map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
            map =(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) ){
            map = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }
				
        if( ((Boolean) map.get( "result" )).booleanValue() )
                map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
        else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
				//	msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				} else{
					map.put( "message", (map.get("msgid"))) ;
					map.put( "flag", "true") ;
				}
            }
        }
        catch(Exception e) {
        map.put( "message", e.getMessage()+"classcast") ;
        e.printStackTrace() ;
        }
		
return map;
}
}
