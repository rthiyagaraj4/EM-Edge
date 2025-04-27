/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.* ;
import eCommon.Common.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

import eOR.ORTickSheets.*;

public class  Tick_Sheets  extends OrAdapter  implements Serializable{

	protected String                      order_category;
	protected String                      tick_sheet_id;
	protected String                      tick_sheet_desc;
	protected String                      seq_no;
	protected String                      indexed_yn;
	protected String                      eff_status;
	protected Hashtable                   hashMultiple;
	protected String fpp_yn 			  ;	//IN072524
	//IN072524 Starts
	public String getFpp_yn() {
		return fpp_yn;
	}


	public void setFpp_yn(String fpp_yn) {
		this.fpp_yn = fpp_yn;
	}
	//IN072524 Ends
	public   String tempChk ="";



/*********************Constructor *************************/



 public Tick_Sheets()
{
			tick_sheet_id					= ""    ;
			tick_sheet_desc					= ""    ;
			seq_no							= ""	;
			indexed_yn						= "N"    ;
			eff_status						= "D"    ;
			fpp_yn							= "N"    ;//IN072524 Starts
}


/**********************SET METHODS*************************/



  public void  setOrder_category(String  order_category) {this.order_category=  order_category; } ;
  public void  setTick_sheet_id(String  tick_sheet_id) {this.tick_sheet_id=  tick_sheet_id; } ;
  public void  setTick_sheet_desc(String  tick_sheet_desc) {this.tick_sheet_desc=  tick_sheet_desc; } ;
  public void  setSeq_no(String  seq_no) {this.seq_no=  seq_no; } ;

  public void  setIndexed_yn(String  indexed_yn) {
	  if(indexed_yn.trim().equals("") )
	  this.indexed_yn = "N";
	  else
  	  this.indexed_yn = indexed_yn;
   } ;

  public void  setEff_status(String  eff_status) {
	  if(eff_status.trim().equals("") )
	  this.eff_status = "D";
	  else
	  this.eff_status=  eff_status;
} ;


/**********************GET METHODS*************************/
  public String getOrder_category() { return this.order_category ; } ;
  public String getTick_sheet_id() { return this.tick_sheet_id ; } ;
  public String getTick_sheet_desc() { return this.tick_sheet_desc ; } ;
  public String getSeq_no() { return this.seq_no ; } ;
  public String getIndexed_yn() { return this.indexed_yn ; } ;
  public String getEff_status() { return this.eff_status ; } ;

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSetMultiple ) {
	    hashMultiple = recordSetMultiple ;
		this.mode =(String)recordSetMultiple.get("mode");
 }
/*********************METHOD TO Reset the Class variable*************************/
	public void clear() {
			 tick_sheet_id					= ""    ;
			 tick_sheet_desc				= ""    ;
			 seq_no							= ""	;
			 indexed_yn						= ""    ;
			 eff_status						= ""    ;
			 fpp_yn							= ""    ;//IN072524 Starts
}

/*********************METHOD TO Insert*************************/
 public HashMap insert(){
	HashMap recordStore = new HashMap() ;
	HashMap sqlMap = new HashMap();
	int counter = 0 ;
	try{
	for(int i=0 ; i < 10 ; i++)
	 {
		String ID = "tick_sheet_id"  + i ;
		HashMap tabData = new HashMap() ;
		if(!((String)hashMultiple.get(ID)).trim().equals("")){
			tabData.put(("order_category"),(String)hashMultiple.get(("order_category")));
			tabData.put(("tick_sheet_id"), (String)hashMultiple.get(("tick_sheet_id" + i))) ;
			tabData.put(("tick_sheet_desc"),(String)hashMultiple.get(("tick_sheet_desc"+ i))) ;
			tabData.put(("seq_no"),(String)hashMultiple.get(("seq_no"+ i))) ;
			tabData.put(("indexed_yn"),(((String)hashMultiple.get("indexed_yn"+ i)).trim().equals(""))?"N":"Y") ;
			tabData.put(("eff_status"),(((String)hashMultiple.get("eff_status"+ i)).trim().equals(""))?"D":"E") ;
			tabData.put(("fpp_yn"),(((String)hashMultiple.get("fpp_yn"+ i)))) ;//IN072524 
			tabData.put(("added_by_id"),login_by_id) ;
			tabData.put(("added_at_ws_no"),login_at_ws_no) ;
			tabData.put(("added_facility_id"),login_facility_id) ;
			tabData.put(("modified_by_id"),login_by_id) ;
			tabData.put(("modified_facility_id"),login_facility_id );
			tabData.put(("modified_at_ws_no"),login_at_ws_no) ;
			recordStore.put(String.valueOf(++counter),tabData);
		 }
	 }

	sqlMap.put("SQL_OR_TICK_SHEETS_INSERT", OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_INSERT") );
	sqlMap.put("SQL_OR_TICK_SHEETS_DUPLICATE_CHK_MULIPLE",OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_DUPLICATE_CHK_MULIPLE"));
	sqlMap.put("SQL_OR_TICK_SHEETS_DUPLICATE_SEQ_NO_CHK",OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_DUPLICATE_SEQ_NO_CHK"));
	return getResult(recordStore,sqlMap );
	}catch(Exception e){
		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}
}

/*********************METHOD TO Update*************************/

public HashMap modify(){
	try{
		
	HashMap record = new HashMap();
	HashMap sqlMap = new HashMap();
	sqlMap.put("SQL_OR_TICK_SHEETS_UPDATE",OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_UPDATE"));
	record.put(("order_category"),(String)hashMultiple.get(("order_category")));
	record.put(("tick_sheet_id"), (String)hashMultiple.get(("tick_sheet_id"))) ;
	record.put(("tick_sheet_desc"),(String)hashMultiple.get(("tick_sheet_desc"))) ;
	record.put(("seq_no"),(String)hashMultiple.get(("seq_no")));
	record.put(("indexed_yn"),(((String)hashMultiple.get("indexed_yn")).trim().equals(""))?"N":"Y") ;
	record.put(("eff_status"),(((String)hashMultiple.get("eff_status")).trim().equals(""))?"D":"E") ;
	record.put(("fpp_yn"),(((String)hashMultiple.get("fpp_yn")))) ;//IN072524
	record.put(("modified_by_id"),login_by_id) ;
	record.put(("modified_facility_id"),login_facility_id );
	record.put(("modified_at_ws_no"),login_at_ws_no) ;
	sqlMap.put("SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_CHK",OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_CHK"));
	sqlMap.put("SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_NULL_CHK",OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_NULL_CHK"));
	return getResult(record,sqlMap );
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
/*********************METHOD TO Poulate OrderCategory List Box***************/
public String getComboOptions() {
Connection connection = null ;
try
{
		connection = getConnection() ;
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_ORD_CAT_SELECT_CODE"),connection,"ORDER_CATEGORY","SHORT_DESC");
		return str;
	}
	catch(Exception e){
		System.out.println(e.getMessage());
		return null;
	}
	finally
	{
		try
		 {
				closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}
}

/*********************METHOD TO load OrderCategory code-desc for Query Page********/
public String getComboString() {
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet rs	= null;
try
	{
		connection  = getConnection();

		pstmt						= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_ORD_CAT_SELECT_CODE"));
		//pstmt.setString( 1, language_id);
		rs							= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		String  codeCol="";
		String  codeDesc="";

		while (rs.next())
			{
				codeCol			    = ChkDef.defaultString(rs.getString(1));
				codeDesc			= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeDesc + "," + codeCol + ",");
			}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e){
		System.out.println(e.getMessage());
		return null;
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


/***********************Validate Method ******************************/

public HashMap validate() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "" ) ;
		return map ;
}

/********************Load Data in Update Mode ******************************/

public void loadData()
{
	Connection 	connection  = null;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	try
	{
		connection  = getConnection();
		pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_SELECT_UPDATE"));
		pstmt.setString(1,tick_sheet_id.trim());
		pstmt.setString(2,order_category.trim());
		resultSet	= pstmt.executeQuery();

		while(resultSet.next())
		{
		setTick_sheet_desc(ChkDef.defaultString(resultSet.getString("TICK_SHEET_DESC")));
		setSeq_no(ChkDef.defaultString(resultSet.getString("SEQ_NO")));
		setIndexed_yn(ChkDef.defaultString(resultSet.getString("INDEXED_YN")));
		setEff_status(ChkDef.defaultString(resultSet.getString("EFF_STATUS")));
		setFpp_yn(ChkDef.defaultString(resultSet.getString("FPP_YN")));//IN072524
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

}
/*************Over riding get Message**************************************/
/*public String getMessage( String msgId ){
	String msg ="";
	if(msgId.equals("CODE_ALREADY_EXISTS")){
		msg = getMessage(language_id, "CODE_ALREADY_EXISTS", "Common") ;
		int r= msg.indexOf("<br>");
		msg = msg.substring(0,r) ;
		return msg;
	}else{
		
		return getMessage(language_id, msgId, "SM") ;
	}
}*/

/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap )
 {
		HashMap map  = new HashMap() ;

		//ORTickSheetsHome home = null;
		//ORTickSheetsRemote remote = null;
		
		try
		{
			
			/*InitialContext context = new InitialContext();
			Object object		   = context.lookup(OrRepository.getOrKeyValue("TICKSHEETS_JNDI"));
			home  = (ORTickSheetsHome) PortableRemoteObject.narrow( object,ORTickSheetsHome.class );
			remote = home.create() ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("TICKSHEETS_JNDI"), ORTickSheetsHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			
			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "records",     record );

			Object argArray[]	= new Object[2];
				argArray[0]		= tabDataParam;
				argArray[1]		= sqlMap;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabDataParam.getClass();
				paramArray[1]	= sqlMap.getClass();
 			
				
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				//map = remote.insert(tabDataParam, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				
			}else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			  //  map = remote.modify(tabDataParam, sqlMap ) ;
			  map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);			

			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			
			
			

			argArray	= null;
			paramArray	= null;

			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
					//map.put( "message", ((String) map.get("msgid"))) ;
			}

	  }catch(Exception e){

		  
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		System.out.println("map in catch of getresult"+map.get("message"));
		e.printStackTrace() ;
	  }finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			
			}*/
		}
		
		return map;

 }//End of Method

}//ENd of the class 
