/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.ejb.*;
import eCommon.Common.*;
import javax.rmi.*;
import javax.naming.*;
import eOR.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class  WaitTimePendingOrdersBean  extends OrAdapter  implements Serializable{

	protected Hashtable                   hashMultiple;

	public   String tempChk ="";



/*********************Constructor *************************/



 public WaitTimePendingOrdersBean()
{
			
}



/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSetMultiple ) {
	    hashMultiple = recordSetMultiple ;
		this.mode =(String)recordSetMultiple.get("mode");
 }
/*********************METHOD TO Reset the Class variable*************************/
	public void clear() {

}

/*********************METHOD TO Insert*************************/
 public HashMap insert(){
	ArrayList recordStore = new ArrayList() ;
	ArrayList whereData = new ArrayList() ;
	HashMap sqlMap = new HashMap();
	
	try{
		String ID="";
		ArrayList insertData=null;
		ArrayList chkwhereData=null;
	for(int i=0 ; i < 10 ; i++)
	 {
		ID = "order_category"  + i ;
		//System.out.println("=order_category="+i+"====="+((String)hashMultiple.get("order_category"+ i))+"==========");	
		insertData = new ArrayList() ;
		chkwhereData = new ArrayList() ;
		if(!((String)hashMultiple.get(ID)).trim().equals("")){
			
			insertData.add(((String)hashMultiple.get("order_category"+ i)).trim()) ;
			insertData.add(((String)hashMultiple.get("order_type"+ i)).trim()) ;
			insertData.add(((String)hashMultiple.get("order_catalog"+ i)).trim()) ;
			//insertData.add(((String)hashMultiple.get("active_stat"+ i)).trim()) ;
			insertData.add((((String)hashMultiple.get("active_stat"+ i)).equals(""))?"N":"Y");
			insertData.add(((String)hashMultiple.get("wait_time_green"+ i)).trim()) ;
			insertData.add(((String)hashMultiple.get("wait_time_yellow"+ i)).trim()) ;
			insertData.add(((String)hashMultiple.get("wait_time_red"+ i)).trim()) ;
			insertData.add(login_by_id) ;
			insertData.add(login_at_ws_no) ;
			insertData.add(login_facility_id) ;
			insertData.add(login_by_id) ;
			insertData.add(login_at_ws_no) ;
			insertData.add(login_facility_id );
			
			chkwhereData.add(((String)hashMultiple.get("order_category" + i)).trim()) ;
			chkwhereData.add(((String)hashMultiple.get("order_type"+ i)).trim()) ;
			chkwhereData.add(((String)hashMultiple.get("order_catalog"+ i)).trim()) ;
			
			recordStore.add((ArrayList)insertData);
			whereData.add((ArrayList)chkwhereData);
		
		 }
	 }

	sqlMap.put("InsertSQL", OrRepositoryExt.getOrKeyValue("SQL_OR_WAIT_TIME_PENDING_INSERT"));
	sqlMap.put("SelectSQL", OrRepositoryExt.getOrKeyValue("SQL_OR_WAIT_TIME_PENDING_DUP_CHK"));
	
	HashMap tabDataParam =  new HashMap() ;
	tabDataParam.put( "InsertData",	recordStore);
	tabDataParam.put( "WhereData",	whereData);
	tabDataParam.put( "properties",	getProperties());
	//System.out.println("========"+tabDataParam);	

	return getResult(tabDataParam,sqlMap );
	}catch(Exception e){
		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}
}

/*********************METHOD TO Update*************************/

public HashMap modify(){
	try{
		HashMap sqlMap = new HashMap();
		ArrayList updatedata = new ArrayList() ;
		
		sqlMap.put("ModifySQL",OrRepositoryExt.getOrKeyValue("SQL_OR_WAIT_TIME_PENDING_UPDATE") );
		
		//updatedata.add(((String)hashMultiple.get("active_stat")).trim()) ;
		updatedata.add((((String)hashMultiple.get("active_stat")).equals(""))?"N":"Y");
		updatedata.add(((String)hashMultiple.get("wait_time_green")).trim()) ;
		updatedata.add(((String)hashMultiple.get("wait_time_yellow")).trim()) ;
		updatedata.add(((String)hashMultiple.get("wait_time_red")).trim()) ;
		updatedata.add(login_by_id) ;
		updatedata.add(login_at_ws_no) ;
		updatedata.add(login_facility_id );
		updatedata.add(((String)hashMultiple.get("order_category")).trim()) ;
		updatedata.add(((String)hashMultiple.get("order_type")).trim()) ;
		updatedata.add(((String)hashMultiple.get("order_catalog")).trim()) ;
		
		HashMap tabDataParam =  new HashMap() ;

		tabDataParam.put("ModifyData", updatedata);
		tabDataParam.put( "properties", getProperties());
	//System.out.println("=======mode2===="+tabDataParam);
		return getResult(tabDataParam,sqlMap);
	}catch(Exception e){
		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}
}

/*********************METHOD TO Delete*************************/
public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
}



/***********************Validate Method ******************************/

public HashMap validate() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "" ) ;

		return map ;
}

/********************Load Data in Update Mode ******************************/

public String[] loadData(String order_category,String order_type,String order_catalog)
{
	Connection 	connection  = null;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	String[] record= null;
	try
	{
		connection  = getConnection();
	//	pstmt		= connection.prepareStatement();
		pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_WAIT_TIME_PENDING_SELECT_UPDATE"));
		pstmt.setString(1,order_category.trim());
		pstmt.setString(2,order_type.trim());
		pstmt.setString(3,order_catalog.trim());
		resultSet	= pstmt.executeQuery();
		record = new String[8];
		while(resultSet.next())
		{
			record[0] = resultSet.getString("ORDER_CATEGORY");
			record[1] = resultSet.getString("ORDER_TYPE_CODE");
			record[2] = resultSet.getString("ORDER_CATALOG_CODE");
			record[3] = resultSet.getString("APPT_WAIT_TIME_GREEN_IND");
			record[4] = resultSet.getString("APPT_WAIT_TIME_YELLOW_IND");
			record[5] = resultSet.getString("APPT_WAIT_TIME_RED_IND");
			record[6] = resultSet.getString("APPT_WAIT_TIME_ACTIVATE_YN");
			record[7] = resultSet.getString("CATEGORY_DESC");
		
		}

	}catch(Exception e){e.printStackTrace() ;

	}finally{
		try
		 {
		 	closeResultSet(resultSet);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;
		 }
	}
	return record;

}  
/*************Over riding get Message**************************************/
public String getMessage( String msgId ){
	String msg ="";
	if(msgId.equals("CODE_ALREADY_EXISTS")){
		msg = super.getMessage(language_id,"CODE_ALREADY_EXISTS","Common");
	int r= msg.indexOf("<br>");
		msg = msg.substring(0,r) ;
	return msg;
	}else{
	return super.getMessage(msgId) ;
	}
}

 public ArrayList getOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC2") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

	public ArrayList getOrderTypeData(String ord_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderType = new ArrayList() ;

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_WAIT_TIME_ORD_TYPE_SELECT") ) ;
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_WAIT_TIME_ORD_TYPE_SELECT")) ;
			pstmt.setString(1,ord_cat);
			
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderType.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderType;
	}
	public String getComboString() {
		Connection 	connection  = null;
		java.sql.PreparedStatement pstmt		= null;
		java.sql.ResultSet rs	= null;
		StringBuffer sb			    = new StringBuffer();
		try
			{
				connection  = getConnection();
				pstmt						= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC2") ) ;
				pstmt.setString(1,language_id);
				rs							= pstmt.executeQuery();
			  	String  codeDesc ="";
				String  codeCol	 = "";
				while (rs.next())
				{
					codeDesc	    = ChkDef.defaultString(rs.getString(2));
					codeCol			= ChkDef.defaultString(rs.getString(1));
					sb.append(codeDesc + "," + codeCol + ",");
				}

				 String str =   sb.toString() ;
				 return str.substring(0, str.length()-1);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				sb.append(""+ "," + "");
				return sb.toString();
			}
			finally
			{
				try
				 {
					closeResultSet(rs);
					closeStatement(pstmt);
					closeConnection(connection);
				 }catch(Exception e){e.printStackTrace() ;

				 }
			}
		}

private  HashMap getResult(HashMap tabData , HashMap sqlMap )
{
//System.out.println("############3in get result ");
	String traceVal = "";
	HashMap map  = new HashMap() ;
	//SingleTableHandlerHome home = null;
	//SingleTableHandlerRemote remote = null;
    map.put( "result", new Boolean( false ) ) ;
    map.put( "flag", "true" ) ;

	try
	{
		/********************LOOK UP*************************/
		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;
		home=(SingleTableHandlerHome)PortableRemoteObject.narrow( object, SingleTableHandlerHome.class) ;
		remote		 = home.create() ;*/

		Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) {
				return null ;
		}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) 
		{
			//map = remote.singleBatchHandler(tabData,sqlMap);
			map = (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);		

		}else if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
		{
			//map = remote.modify(tabData, sqlMap ) ;
			map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);	
		}
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
		argArray	= null;
		paramArray	= null;

		String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
        if( result ) 
		{
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
		}
        else
		{
			map.put( "result", new Boolean( false ) ) ;
            if( message.equals( "CODE_ALREADY_EXISTS" ) )
			{
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common") ) ;
				//System.out.println("---------------"+delimitedString((ArrayList)map.get("invalidCode"))+"---");
				String invalidCode_1=delimitedString((ArrayList)map.get("invalidCode"));
				//String temp="";
				
				String invalidCode="";
				invalidCode = invalidCode_1 ;

				/*StringTokenizer invalidCode_2=new StringTokenizer(invalidCode_1,",");
				
				while (invalidCode_2.hasMoreTokens())
				{
					temp=invalidCode_2.nextToken();
					StringTokenizer invalidCode_3=new StringTokenizer(temp,":");
					while(invalidCode_3.hasMoreTokens())
					{
						invalidCode+=invalidCode_3.nextToken();
						invalidCode+=",";
						invalidCode+=invalidCode_3.nextToken();
						invalidCode+=",";
						invalidCode_3.nextToken();
						//invalidCode+=invalidCode_3.nextToken();
						//invalidCode+=",";
					}
				}*/
						
				//map.put( "invalidCode",invalidCode.substring(0,invalidCode.length()-1)) ;
				map.put( "invalidCode",invalidCode) ;
				

			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }
		return map;

	}catch(Exception e)
	{
		//System.out.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}
	finally
	{
		clear();
		map.put("traceVal",traceVal);
	 }

	}

}//ENd of the class
