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
*	ClassName					: ProblemStage
*	Description				    :
*	Methods						:
*	Author						: Dheeraj Kumar
*	Version						: 1.0
*	Date						: 15 Jul 2003
*	Revision History			:
***************************************************************************
*   Version			Date		Name		Remarks
***************************************************************************/

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

import ePH.PHProblemStage.*;
public class  ProblemStage  extends PhAdapter  implements Serializable{

	protected String                      indicator;
	protected String                      problem_stage_id;
	protected String                      problem_stage_short_desc;
	protected String                      problem_stage_long_desc;
	protected String                      eff_status;
	protected Hashtable                   hashMultiple;

	public   String tempChk ="";

/*********************Constructor *************************/
public ProblemStage(){
			problem_stage_id							= "" ;
			problem_stage_short_desc					= "" ;
			problem_stage_long_desc						= "" ;
			eff_status									= "D";
}



/**********************SET METHODS*************************/
  public void  setIndicator(String  indicator) {this.indicator=  indicator; } ;
  public void  setProblemStageId(String  problem_stage_id) {this.problem_stage_id=  problem_stage_id; } ;
  public void  setProblemStageShortDesc(String  problem_stage_short_desc) {this.problem_stage_short_desc=  problem_stage_short_desc; } ;
  public void  setProblemStageLongDesc(String  problem_stage_long_desc) {this.problem_stage_long_desc=  problem_stage_long_desc; } ;

  public void  setEff_status(String  eff_status) {
	  if(eff_status.trim().equals("") )
	  		this.eff_status = "D";
	  else
	  		this.eff_status=  eff_status;
}

/**********************GET METHODS*************************/
  public String getIndicator() { return this.indicator ; } ;
  public String getProblemStageId() { return this.problem_stage_id ; } ;
  public String getProblemStageShortDesc() { return this.problem_stage_short_desc ; } ;
  public String getProblemStageLongDesc() { return this.problem_stage_long_desc ; } ;
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
		String ID = "problem_stage_id"  + i ;
		HashMap tabData = new HashMap() ;
		if(!((String)hashMultiple.get(ID)).trim().equals("")){
			tabData.put(("indicator"),(String)hashMultiple.get(("indicator")));
			tabData.put(("problem_stage_id"), (String)hashMultiple.get(("problem_stage_id" + i))) ;
			tabData.put(("problem_stage_short_desc"),(String)hashMultiple.get(("problem_stage_short_desc"+ i))) ;
			tabData.put(("problem_stage_long_desc"),(String)hashMultiple.get(("problem_stage_long_desc"+ i))) ;
			tabData.put(("eff_status"),(((String)hashMultiple.get("eff_status"+ i)).trim().equals(""))?"D":"E") ;
			tabData.put(("added_by_id"),login_by_id) ;
			tabData.put(("added_at_ws_no"),login_at_ws_no) ;
			tabData.put(("added_facility_id"),login_facility_id) ;
			tabData.put(("modified_by_id"),login_by_id) ;
			tabData.put(("modified_facility_id"),login_facility_id );
			tabData.put(("modified_at_ws_no"),login_at_ws_no) ;
			recordStore.put(String.valueOf(++counter),tabData);
		 }
	 }

	sqlMap.put("SQL_PH_PROBLEM_STAGE_INSERT", PhRepository.getPhKeyValue("SQL_PH_PROBLEM_STAGE_INSERT") );
	sqlMap.put("SQL_PH_PROBLEM_STAGE_DUPLICATE_CHK_MULIPLE",PhRepository.getPhKeyValue("SQL_PH_PROBLEM_STAGE_DUPLICATE_CHK_MULIPLE"));
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
	sqlMap.put("SQL_PH_PROBLEM_STAGE_UPDATE",PhRepository.getPhKeyValue("SQL_PH_PROBLEM_STAGE_UPDATE"));
	record.put(("indicator"),(String)hashMultiple.get(("indicator")));
	record.put(("problem_stage_id"), (String)hashMultiple.get(("problem_stage_id"))) ;
	record.put(("problem_stage_short_desc"),(String)hashMultiple.get(("problem_stage_short_desc"))) ;
	record.put(("problem_stage_long_desc"),(String)hashMultiple.get(("problem_stage_long_desc"))) ;
	record.put(("eff_status"),(((String)hashMultiple.get("eff_status")).trim().equals(""))?"D":"E") ;
	record.put(("modified_by_id"),login_by_id) ;
	record.put(("modified_facility_id"),login_facility_id );
	record.put(("modified_at_ws_no"),login_at_ws_no) ;
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
	try	{
		connection  = getConnection();
		pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PROBLEM_STAGE_LOAD"));

		pstmt.setString(1,code.trim());
		resultSet	= pstmt.executeQuery();



		while(resultSet.next()){
			setIndicator(resultSet.getString("problem_ind"));
			setProblemStageShortDesc(resultSet.getString("short_desc"));
			setProblemStageLongDesc(resultSet.getString("long_desc"));
			setEff_status(resultSet.getString("eff_status"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			closeResultSet( resultSet ) ;
			               closeStatement( pstmt ) ;
                    closeConnection( connection );
		 }catch(Exception e){
		e.printStackTrace();
		 }
	}

}
/*************Over riding get Message**************************************/
public String getMessage( String msgId ){
//	System.out.println("!!!!!comes here inside the get message method");
	String msg ="";
	if(msgId.equals("CODE_ALREADY_EXISTS")){
		msg = super.getMessage(getLanguageId(),msgId,"Common");
	//int r= msg.indexOf("<br>");
		//System.out.println("value of R : "+r);
		//msg = msg.substring(0,r) ;
	//System.out.println("PROBELEM STAGE::"+msg);
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
			Object object		   = context.lookup(PhRepository.getPhKeyValue("PROBLEM_STAGE_JNDI"));
			PHProblemStageHome home  = (PHProblemStageHome) PortableRemoteObject.narrow( object,PHProblemStageHome.class );
			PHProblemStageRemote remote = home.create() ;
			System.out.println("bfore going to EJB  --- PH - ProblemStage ");
			//PHProblemStageManager remote = new PHProblemStageManager();
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				map = remote.insert(tabDataParam, sqlMap ) ;
			}else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			    map = remote.modify(tabDataParam, sqlMap ) ;
			}*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("PROBLEM_STAGE_JNDI"),PHProblemStageHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabDataParam;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabDataParam.getClass();
			paramArray[1]=sqlMap.getClass();

			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE")))
			{
				return null ;
			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) 
			{
			   map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
            }
			else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
		    {
				map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


            if( ((Boolean) map.get( "result" )).booleanValue() )
                map.put( "message", getMessage(getLanguageId(),(String) map.get( "message" ),"PH") ) ;
            else{
                if( ((String)map.get( "message" )).equals( "CODE_ALREADY_EXISTS" ) ){
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "message" ),"Common")  ) ;
					map.put( "invalidCode", (String)map.get("invalidCode") ) ;
				}
                else{
                    map.put( "message", (map.get("msgid"))) ;
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
	 problem_stage_id				= ""    ;
	 problem_stage_short_desc		= ""    ;
	 problem_stage_long_desc		= ""    ;
	 eff_status						= ""    ;
}

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
public void setAll( Hashtable recordSetMultiple ) {
	    hashMultiple = recordSetMultiple ;
		this.mode =(String)recordSetMultiple.get("mode");
 }

}//ENd of the class



