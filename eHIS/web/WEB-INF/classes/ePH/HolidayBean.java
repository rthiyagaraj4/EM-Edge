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
import eCommon.SingleTableHandler.*;


public class HolidayBean extends PhAdapter implements Serializable {
   String holiday_date= "";
   String reason	  = "";
   public void setHolidayDate(String holiday_date){
		this.holiday_date = holiday_date;
	}

	public String getHolidayDate(){
		return this.holiday_date;
	}
   public void setReason(String reason){
		this.reason = reason;
	}

	public String getReason(){
		return this.reason;
	}	
	public void setAll(Hashtable hashtable) {
		setHolidayDate((String)hashtable.get("holiday_date"));
		setReason((String)hashtable.get("reason"));
		setMode((String)hashtable.get("mode")) ;
	}
	public ArrayList loadData() {
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;        
		ArrayList alDtlRecords		= new ArrayList();
		try{
			connection		= getConnection() ;
			pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_HOLIDAY_LOAD_SELECT"));
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery(); 

			while ( resultSet != null && resultSet.next() ) {
				HashMap hmDtlRecord	=	new HashMap();
				if(((String)getLanguageId()).equals("th"))
					hmDtlRecord.put("holiday_date",com.ehis.util.DateUtils.convertDate((String)resultSet.getString("HOLIDAY_DATE"),"DMY","en",getLanguageId()));
				else
					hmDtlRecord.put("holiday_date",(String)resultSet.getString("HOLIDAY_DATE"));
				hmDtlRecord.put("reason",resultSet.getString("REASON"));
				alDtlRecords.add(hmDtlRecord);  
			}
		}catch(Exception e){
			System.err.println("Error while loading from database");
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return alDtlRecords;
	}

	public HashMap insert(){
        HashMap tabData = new HashMap();
        ArrayList InsertData = new ArrayList();
		ArrayList WhereData = new ArrayList();
		ArrayList LanguageData = new ArrayList();
		LanguageData.add(getLanguageId());
        HashMap sqlMap = new HashMap();

		if(((String)getLanguageId()).equals("th"))
			InsertData.add(com.ehis.util.DateUtils.convertDate((String)getHolidayDate(),"DMY",getLanguageId(),"en"));
		else
			InsertData.add((String)getHolidayDate());
		InsertData.add((String)getReason());
        InsertData.add(getLoginById());
        InsertData.add(getLoginAtWsNo());
        InsertData.add(getLoginFacilityId());
		InsertData.add(getLoginById());
        InsertData.add(getLoginAtWsNo());
        InsertData.add(getLoginFacilityId());
		
		WhereData.add((String)getHolidayDate());
		try{
			sqlMap.put("InsertSQL", PhRepository.getPhKeyValue("SQL_PH_HOLIDAY_INSERT"));
			sqlMap.put("SelectSQL", PhRepository.getPhKeyValue("SQL_PH_HOLIDAY_SELECT"));
		}catch(Exception e){
            e.printStackTrace();
		}

        tabData.put("properties", getProperties());
        tabData.put("InsertData", InsertData);
		tabData.put("WhereData",  WhereData ) ;
		tabData.put("LanguageData",LanguageData);
		return callSingleTableHandler(tabData ,sqlMap );
	}

	public HashMap modify(){
        HashMap tabData = new HashMap();
        ArrayList ModifyData = new ArrayList();
		ArrayList LanguageData = new ArrayList();
		LanguageData.add(getLanguageId());
        HashMap sqlMap = new HashMap();

		ModifyData.add((String)getReason());
		ModifyData.add(getLoginById());
        ModifyData.add(getLoginAtWsNo());
        ModifyData.add(getLoginFacilityId());
		if(((String)getLanguageId()).equals("th"))
			ModifyData.add(com.ehis.util.DateUtils.convertDate((String)getHolidayDate(),"DMY",getLanguageId(),"en"));
		else
			ModifyData.add((String)getHolidayDate());
		try{
	        sqlMap.put("ModifySQL", PhRepository.getPhKeyValue("SQL_PH_HOLIDAY_UPDATE"));
		}catch(Exception e){
            e.printStackTrace();
		}		
        tabData.put("properties", getProperties());
        tabData.put("ModifyData", ModifyData);
		tabData.put("LanguageData",LanguageData);
		return callSingleTableHandler(tabData ,sqlMap );
	}

	public HashMap delete(){
        HashMap tabData = new HashMap();
        ArrayList deleteData = new ArrayList();
        HashMap sqlMap = new HashMap();
		ArrayList LanguageData = new ArrayList();
		LanguageData.add(getLanguageId());

		if(((String)getLanguageId()).equals("th"))
			deleteData.add(com.ehis.util.DateUtils.convertDate(((String)getHolidayDate()).trim(),"DMY",getLanguageId(),"en"));
		else
			deleteData.add((String)getHolidayDate());
		//deleteData.add((String)getLanguageId());
		try{
			sqlMap.put("DeleteSQL",PhRepository.getPhKeyValue("SQL_PH_HOLIDAY_DELETE"));
		}catch(Exception e){
            e.printStackTrace();
		}		
        tabData.put("properties", getProperties());
        tabData.put("DeleteData", deleteData);
		tabData.put("LanguageData",LanguageData);
		return callSingleTableHandler(tabData ,sqlMap );
	}

	private HashMap callSingleTableHandler( HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		try {
			  Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();


			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )  )
			map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) )
			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" ) )  )
			map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
			else
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH")) ;
			}
		}
		catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}
		return map;
	}
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
        map.put("result", new Boolean(false));
        map.put("message", "before validating..");

		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;

		try {
			if (mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				connection	= getConnection();
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_HOLIDAY_COUNT_SELECT"));
				pstmt.setString(1,com.ehis.util.DateUtils.convertDate((String)getHolidayDate(),"DMY",getLanguageId(),"en"));
				resultSet	= pstmt.executeQuery();

				if (resultSet != null && resultSet.next()) {
					if(!((String)resultSet.getString("COUNT")).equals("0")) {
						map.put("result", new Boolean(false));
						map.put("message", getMessage(getLanguageId(),"CODE_ALREADY_EXISTS", "Common"));
					}
					else {
						map.put("result", new Boolean(true));
					}
				}
				else {
					map.put("result", new Boolean(true));
				}
			}
			else {
				map.put("result", new Boolean(true));
			}
		}
		catch(Exception e) {
			System.err.println("error in validate:"+e);
		}
		finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return map;
	}
}

