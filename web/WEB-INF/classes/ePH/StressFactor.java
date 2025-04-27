/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;


import ePH.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import javax.servlet.* ;
import eCommon.Common.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

import ePH.PHStressFactor.*;
//saved on 25/10/2005
public class  StressFactor  extends PhAdapter  implements Serializable{

	protected String                      srl_no;
	protected String                      stress_related_option;
	protected String                      weightage;
	protected String                      default_yn;
	protected String                      system_defined_yn;

	protected Hashtable                   hashMultiple;


/*********************Constructor *************************/
public StressFactor(){
}

/**********************SET METHODS*************************/
  public void  setSetSrlNo(String  srl_no) {this.srl_no=  srl_no; } ;
  public void  setWeightage(String  weightage) {this.weightage=  weightage; } ;
  public void  setStressRelatedOption(String  stress_related_option) {this.stress_related_option=  stress_related_option; } ;

  public void  setDefaultYN(String  default_yn) {
	  if(default_yn.trim().equals("") )
	  		this.default_yn = "N";
	  else
	  		this.default_yn=  default_yn;
  }
  public void  setSystemDefinedYN(String  system_defined_yn) {
	  if(system_defined_yn.trim().equals("") )
	  		this.system_defined_yn = "N";
	  else
	  		this.system_defined_yn=  system_defined_yn;
  }

/**********************GET METHODS*************************/
  public String getSetSrlNo() {return this.srl_no; } ;
  public String getStressRelatedOption() { return this.stress_related_option ; } ;
  public String getWeightage() { return this.weightage ; } ;
  public String getDefaultYN() { return this.default_yn ; } ;
  public String getSystemDefinedYN() { return this.system_defined_yn ; } ;


/*********************METHOD TO Insert*************************/
 public HashMap insert(){
	HashMap recordStore = new HashMap() ;
	HashMap sqlMap = new HashMap();
	int counter = 0 ;
	int total_records = Integer.parseInt((String)hashMultiple.get("totalRecords"));

	try{
	for(int i=0 ; i < total_records ; i++)
	 {
		String ID = "weightage"  + i ;
		HashMap tabData = new HashMap() ;
		tabData.put(("system_defined_yn"),(String)hashMultiple.get(("system_defined_yn")));
		if(!((String)hashMultiple.get(ID)).trim().equals("")){
			tabData.put(("stress_related_option"),(String)hashMultiple.get(("stress_related_option"+i)));
			tabData.put(("weightage"), (String)hashMultiple.get(("weightage" + i))) ;
			tabData.put(("default_yn"),(((String)hashMultiple.get("default_yn"+ i)).equals(""))?"N":"Y") ;
			tabData.put(("added_by_id"),login_by_id) ;
			tabData.put(("added_at_ws_no"),login_at_ws_no) ;
			tabData.put(("added_facility_id"),login_facility_id) ;
			tabData.put(("modified_by_id"),login_by_id) ;
			tabData.put(("modified_facility_id"),login_facility_id );
			tabData.put(("modified_at_ws_no"),login_at_ws_no) ;
			recordStore.put(String.valueOf(++counter),tabData);
		 }
	 }

	sqlMap.put("SQL_PH_STRESS_FACTOR_INSERT", PhRepository.getPhKeyValue("SQL_PH_STRESS_FACTOR_INSERT") );
	sqlMap.put("SQL_PH_STRESS_FACTOR_MAX_COUNT", PhRepository.getPhKeyValue("SQL_PH_STRESS_FACTOR_MAX_COUNT") );
	return getResult(recordStore,sqlMap );
	}catch(Exception e){

		logErrorMessage(e);
		return null;
	}
}

/*********************METHOD TO Update*************************/

public HashMap modify(){
	try{
	HashMap record = new HashMap();
	HashMap sqlMap = new HashMap();
	sqlMap.put("SQL_PH_STRESS_FACTOR_UPDATE",PhRepository.getPhKeyValue("SQL_PH_STRESS_FACTOR_UPDATE"));
	record.put(("stress_related_option"),(String)hashMultiple.get(("stress_related_option")));
	record.put(("weightage"), (String)hashMultiple.get(("weightage" ))) ;
	record.put(("default_yn"),(((String)hashMultiple.get("default_yn")).equals(""))?"N":"Y") ;
	record.put(("modified_by_id"),login_by_id) ;
	record.put(("modified_facility_id"),login_facility_id );
	record.put(("modified_at_ws_no"),login_at_ws_no) ;
	record.put(("srl_no"),(String)hashMultiple.get(("srl_no")));

	return getResult(record,sqlMap );
	}catch(Exception e){

		logErrorMessage(e);
		return null;
	}
}

/*********************METHOD TO Delete*************************/
public HashMap delete(){
	try{
	HashMap record = new HashMap();
	HashMap sqlMap = new HashMap();
	sqlMap.put("SQL_PH_STRESS_FACTOR_DELETE",PhRepository.getPhKeyValue("SQL_PH_STRESS_FACTOR_DELETE"));

	record.put(("srl_no"),(String)hashMultiple.get(("srl_no")));

	return getResult(record,sqlMap );
	}catch(Exception e){
		e.printStackTrace();
		logErrorMessage(e);
		return null;
	}
}

/***********************Validate Method ******************************/
public HashMap validate() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "" ) ;

		return map ;
}
/********************Check for default_yn******************************/
public String ChkDefaultYN(){
	Connection 	connection  = null;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	String default_yn = "";
	try
	{

		connection  = getConnection();
		pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_STRESS_FACTOR_CHK_DEFAULT_YN"));
		resultSet	= pstmt.executeQuery();

		while(resultSet.next()){
			default_yn = (String)resultSet.getString("count");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){
              System.out.println("Exception while closing statements and resultsets"+e.toString());
		 }
	}
	return default_yn;
}

/********************Load Data in Update Mode ******************************/
public void loadData(String code){
	Connection 	connection  = null;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	try
	{
		connection  = getConnection();
		pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_STRESS_FACTOR_LOAD"));
		pstmt.setString(1,code.trim());
		pstmt.setString(2, getLanguageId());
		resultSet	= pstmt.executeQuery();

		while(resultSet.next()){
			setStressRelatedOption(resultSet.getString("stress_related_option"));
			setWeightage(resultSet.getString("weightage"));
			setDefaultYN(resultSet.getString("default_yn"));
			setSystemDefinedYN(resultSet.getString("system_defined_yn"));
		}
	}catch(Exception e){
		System.out.println("err here while loading the data in Problem Stage function : "+e);
	}finally{
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){
			 System.out.println("Exception while closing resultsets and statements"+e.toString());
		 }
	}

}

/*************Over riding get Message**************************************/
public String getMessage( String msgId ){
	String msg ="";
	if(msgId.equals("CODE_ALREADY_EXISTS")){
			msg = super.getMessage(getLanguageId(),msgId,"Common");
		//int r= msg.indexOf("<br>");
		//	msg = msg.substring(0,r) ;
		return msg;
	}else{
		return super.getMessage(msgId) ;
	}
}


/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap ) {
		HashMap map  = new HashMap() ;
		HashMap tabDataParam =  new HashMap() ;
		tabDataParam.put( "properties", getProperties() );
		tabDataParam.put( "records",     record );

		try
		{
			/*			InitialContext context = new InitialContext();
			Object object		   = context.lookup(PhRepository.getPhKeyValue("STRESS_FACTOR_JNDI"));
			PHStressFactorHome home  = (PHStressFactorHome) PortableRemoteObject.narrow( object,PHStressFactorHome.class );
			PHStressFactorRemote remote = home.create() ;

		
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				map = remote.delete(tabDataParam, sqlMap ) ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				map = remote.insert(tabDataParam, sqlMap ) ;
			}else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			    map = remote.modify(tabDataParam, sqlMap ) ;
			}*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("STRESS_FACTOR_JNDI"),PHStressFactorHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabDataParam;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabDataParam.getClass();
			paramArray[1]=sqlMap.getClass();

            if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE")))
			{
			map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
			{
			map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
			{
			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if( ((Boolean) map.get( "result" )).booleanValue() ){
				System.err.println("@@@----->"+(String) map.get( "message" ));
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "message" ),"PH") ) ;
					System.err.println("@@@----->"+(String) map.get( "message" ));
				} else{
                if( ((String)map.get( "message" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = (String)getMessage((String) map.get( "message" ),false) ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", (String)map.get("invalidCode") ) ;
				} else{
					map.put( "message", (String) map.get( "message" )  ) ;
				}
            }
		  return map;

	  }catch(Exception e){
		System.out.println( "Error Calling EJB of problem stage :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	  }
 }//End of Method

/*********************METHOD TO Reset the Class variable*************************/
public void clear() {
	stress_related_option = "";
	weightage = "";
	default_yn = "";
}

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
public void setAll( Hashtable recordSetMultiple ) {
	    hashMultiple = recordSetMultiple ;
		this.mode =(String)recordSetMultiple.get("mode");
 }

}//End of the class


