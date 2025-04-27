/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 08/11/2005

/*************************************************************************
*	ClassName					: RegimenService
*	Description				    :
*	Methods						:
*	Author						: Dheeraj Kumar
*	Version						: 1.0
*	Date						: 16 Jul 2003
*	Revision History			:
***************************************************************************
*   Version			Date		Name		Remarks
***************************************************************************/

package ePH;


import ePH.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
//import javax.rmi.* ;
//import javax.naming.* ;
import javax.servlet.* ;
import eCommon.Common.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

import ePH.PHRegimenService.*;

public class  RegimenService  extends PhAdapter  implements Serializable{

	protected String                      indicator_disp;
	protected String                      indicator;
	protected String                      service_code;
	protected String                      regimen_yn;
	protected String                      tpn_yn;
	protected String                      eff_status;
	protected Hashtable                   hashMultiple;


/*********************Constructor *************************/
public RegimenService(){
			service_code							= "" ;
			regimen_yn								= "D";
			eff_status									= "D";
}

/**********************SET METHODS*************************/
  public void  setIndicatorDisply(String  indicator_disp) {this.indicator_disp=  indicator_disp; } ;
  public void  setIndicator(String  indicator) {this.indicator=  indicator; } ;
  public void  setServiceCode(String  service_code) {this.service_code=  service_code; } ;

  public void  setEff_status(String  eff_status) {
	  if(eff_status.trim().equals("") )
	  		this.eff_status = "D";
	  else
	  		this.eff_status=  eff_status;
  }
  public void  setRegimenYN(String  regimen_yn) {
	  if(regimen_yn.trim().equals("") )
	  		this.regimen_yn = "N";
	  else
	  		this.regimen_yn=  regimen_yn;
  }

  public void  setTPNYN(String  tpn_yn) {
	  if(tpn_yn.trim().equals("") )
	  		this.tpn_yn = "N";
	  else
	  		this.tpn_yn=  tpn_yn;
  }


/**********************GET METHODS*************************/
  public String getIndicatorDisplay() { return this.indicator_disp ; } ;
  public String getIndicator() { return this.indicator ; } ;
  public String setServiceCode() { return this.service_code ; } ;
  public String getRegimenYN() { return this.regimen_yn ; } ;
  public String getTPNYN() { return this.tpn_yn ; } ;
  public String getEffStatus() { return this.eff_status ; } ;

/*********************METHOD TO Insert*************************/
 public HashMap insert(){
	HashMap recordStore = new HashMap() ;
	HashMap sqlMap = new HashMap();
	int counter = 0 ;
	int total_records = Integer.parseInt((String)hashMultiple.get("totalRecords"));



	try{
	for(int i=0 ; i < total_records ; i++)
	 {
		String ID = "service_code"  + i ;
		HashMap tabData = new HashMap() ;
		if(!((String)hashMultiple.get(ID)).trim().equals("")){
			//System.out.println("Service code here ::::; "+(String)hashMultiple.get(("service_code" + i)));
			tabData.put(("indicator"),(String)hashMultiple.get(("indicator")));
			tabData.put(("service_code"), (String)hashMultiple.get(("service_code" + i))) ;
			tabData.put(("regimen_yn"),(((String)hashMultiple.get("regimen_yn"+ i)).trim().equals(""))?"N":"Y") ;
			tabData.put(("tpn_yn"),(((String)hashMultiple.get("tpn_yn"+ i)).trim().equals(""))?"N":"Y") ;
			tabData.put(("eff_status"),(((String)hashMultiple.get("eff_status"+ i)).trim().equals(""))?"D":"E") ;
			tabData.put(("added_by_id"),login_by_id) ;
			tabData.put(("added_at_ws_no"),login_at_ws_no) ;
			tabData.put(("added_facility_id"),login_facility_id) ;
			tabData.put(("modified_by_id"),login_by_id) ;
			tabData.put(("modified_facility_id"),login_facility_id );
			tabData.put(("modified_at_ws_no"),login_at_ws_no) ;
			recordStore.put(String.valueOf(++counter),tabData);

			//System.out.println(" >>> TPN ::: "+((String)hashMultiple.get("tpn_yn"+ i)));
		 }
	 }

	sqlMap.put("SQL_PH_REGIMEN_SERVICE_INSERT", PhRepository.getPhKeyValue("SQL_PH_REGIMEN_SERVICE_INSERT") );
	sqlMap.put("SQL_PH_REGIMEN_SERVICE_DUPLICATE_CHK_MULIPLE",PhRepository.getPhKeyValue("SQL_PH_REGIMEN_SERVICE_DUPLICATE_CHK_MULIPLE"));
	sqlMap.put("SQL_PH_REGIMEN_SERVICE_SERVICE_CODE_LOOKUP_VALIDATE",PhRepository.getPhKeyValue("SQL_PH_REGIMEN_SERVICE_SERVICE_CODE_LOOKUP_VALIDATE"));
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
	sqlMap.put("SQL_PH_REGIMEN_SERVICE_UPDATE",PhRepository.getPhKeyValue("SQL_PH_REGIMEN_SERVICE_UPDATE"));
	record.put(("indicator"),(String)hashMultiple.get(("indicator")));
	record.put(("service_code"), (String)hashMultiple.get(("service_code"))) ;
	record.put(("regimen_yn"),(((String)hashMultiple.get("regimen_yn")).trim().equals(""))?"N":"Y") ;
	record.put(("tpn_yn"),(((String)hashMultiple.get("tpn_yn")).trim().equals(""))?"N":"Y") ;
	record.put(("eff_status"),(((String)hashMultiple.get("eff_status")).trim().equals(""))?"D":"E") ;
	record.put(("modified_by_id"),login_by_id) ;
	record.put(("modified_facility_id"),login_facility_id );
	record.put(("modified_at_ws_no"),login_at_ws_no) ;
	return getResult(record,sqlMap );
	}catch(Exception e){

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
public void loadData(String code){

	Connection 	connection  = null;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	try
	{
		connection  = getConnection();
		pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_REGIMEN_SERVICE_LOAD"));

		pstmt.setString(1,code.trim());
		resultSet	= pstmt.executeQuery();


		while(resultSet.next()){
			setIndicatorDisply(resultSet.getString("problem_ind_disp"));
			setIndicator(resultSet.getString("problem_ind"));
			setRegimenYN(resultSet.getString("regimen_yn"));
			setTPNYN(resultSet.getString("tpn_yn"));
			setEff_status(resultSet.getString("eff_status"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){
			 		e.printStackTrace();

		 }
	}

}

/*************Over riding get Message**************************************/
/*public String getMessage( String msgId ){
	
	String msg ="";
	if(msgId.equals("CODE_ALREADY_EXISTS")){
			msg = super.getMessage(getLanguageId(),"CODE_ALREADY_EXISTS","Common");
		int r= msg.indexOf("<br>");
			System.out.println("value of R : "+r);
			msg = msg.substring(0,r) ;
		System.out.println("PROBELEM STAGE::"+msg);
		return msg;
	}else{
		return super.getMessage(msgId) ;
	}
}
*/

/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap ) {
		HashMap map  = new HashMap() ;
		try
		{

			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "records",     record );

			/*InitialContext context = new InitialContext();
			Object object		   = context.lookup(PhRepository.getPhKeyValue("REGIMEN_SERVICE_JNDI"));
			PHRegimenServiceHome home  = (PHRegimenServiceHome) PortableRemoteObject.narrow( object,PHRegimenServiceHome.class );
			PHRegimenServiceRemote remote = home.create() ;

			


			//RegimenServiceManager remote = new RegimenServiceManager();
			
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				map = remote.insert(tabDataParam, sqlMap ) ;
			}else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			    map = remote.modify(tabDataParam, sqlMap ) ;
			}*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "REGIMEN_SERVICE_JNDI" ),PHRegimenServiceHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabDataParam;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabDataParam.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			    map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}

				
            if( ((Boolean) map.get( "result" )).booleanValue() )
                map.put( "message", (String)getMessage(getLanguageId(),(String) map.get( "message" ),"PH") ) ;
            else{
                if( ((String)map.get( "message" )).equals( "CODE_ALREADY_EXISTS") ){
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "message" ),"Common")  ) ;
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
	 service_code				= ""    ;
	 eff_status						= ""    ;
	 regimen_yn						= ""    ;
}

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
public void setAll( Hashtable recordSetMultiple ) {
	    hashMultiple = recordSetMultiple ;
		this.mode =(String)recordSetMultiple.get("mode");
 }

}//ENd of the class


