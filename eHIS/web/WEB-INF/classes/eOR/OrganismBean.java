/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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

import eOR.OROrganism.*;

public class  OrganismBean  extends OrAdapter  implements Serializable{

	protected String                      org_code;
	protected String                      org_long_desc;
	protected String                      org_short_desc;
	protected String                      eff_status;
	protected Hashtable                   hashMultiple;

	public   String tempChk ="";



/*********************Constructor *************************/



 public OrganismBean()
{
			org_code				= ""    ;
			org_long_desc				= ""    ;
			org_short_desc				= ""    ;
			eff_status				= "D"    ;
}


/**********************SET METHODS*************************/



  public void  setOrg_code(String  org_code) {this.org_code=  org_code; } ;
  public void  setOrg_long_desc(String  org_long_desc) {this.org_long_desc=  org_long_desc; } ;
  public void  setOrg_short_desc(String  org_short_desc) {this.org_short_desc=  org_short_desc; } ;

  public void  setEff_status(String  eff_status) {
	  if(eff_status.trim().equals("") )
	  this.eff_status = "D";
	  else
	  this.eff_status=  eff_status;
} ;


/**********************GET METHODS*************************/
  public String getOrg_code() { return this.org_code ; } ;
  public String getOrg_long_desc() { return this.org_long_desc ; } ;
  public String getOrg_short_desc() { return this.org_short_desc ; } ;
  public String getEff_status() { return this.eff_status ; } ;

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSetMultiple ) {
	    hashMultiple = recordSetMultiple ;
		this.mode =(String)recordSetMultiple.get("mode");
 }
/*********************METHOD TO Reset the Class variable*************************/
	public void clear() {
			 org_code					= ""    ;
			 org_long_desc				= ""    ;
			 org_short_desc					= ""    ;
			 eff_status						= ""    ;
}

/*********************METHOD TO Insert*************************/
 public HashMap insert(){
	HashMap recordStore = new HashMap() ;
	HashMap sqlMap = new HashMap();
	int counter = 0 ;
	try{
	for(int i=0 ; i < 10 ; i++)
	 {
		String ID = "org_code"  + i ;
		HashMap tabData = new HashMap() ;
		if(!((String)hashMultiple.get(ID)).trim().equals("")){
			tabData.put(("org_code"), (String)hashMultiple.get(("org_code" + i))) ;
			tabData.put(("org_long_desc"),(String)hashMultiple.get(("org_long_desc"+ i))) ;
			tabData.put(("org_short_desc"),(String)hashMultiple.get(("org_short_desc"+ i))) ;
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

	sqlMap.put("SQL_OR_ORGANISM_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_ORGANISM_INSERT") );
	sqlMap.put("SQL_OR_ORGANISM_DUPLICATE_CHK",OrRepositoryExt.getOrKeyValue("SQL_OR_ORGANISM_DUPLICATE_CHK"));
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
	sqlMap.put("SQL_OR_ORGANISM_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORGANISM_UPDATE"));
	record.put(("org_code"),(String)hashMultiple.get(("org_code")));
	record.put(("org_long_desc"),(String)hashMultiple.get(("org_long_desc"))) ;
	record.put(("org_short_desc"),(String)hashMultiple.get(("org_short_desc"))) ;
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

public void loadData()
{
	Connection 	connection  = null;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	try
	{
		connection  = getConnection();
		pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORGANISM_SELECT_UPDATE"));
		pstmt.setString(1,org_code.trim());
		resultSet	= pstmt.executeQuery();

		while(resultSet.next())
		{
		setOrg_long_desc(ChkDef.defaultString(resultSet.getString("LONG_DESC")));
		setOrg_short_desc(ChkDef.defaultString(resultSet.getString("SHORT_DESC")));
		setEff_status(ChkDef.defaultString(resultSet.getString("EFF_STATUS")));
		}

	}catch(Exception e){e.printStackTrace();

	}finally{
		try
		 {
		 	closeResultSet(resultSet);
		 	closeStatement(pstmt);
				closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();
		 }
	}

}  
/*************Over riding get Message**************************************/
public String getMessage( String msgId ){
	String msg ="";
	if(msgId.equals("CODE_ALREADY_EXISTS")){
		msg = super.getMessage("CODE_ALREADY_EXISTS");
	int r= msg.indexOf("<br>");
		msg = msg.substring(0,r) ;
	return msg;
	}else{
	return super.getMessage(msgId) ;
	}
}

/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap )
 {
		HashMap map  = new HashMap() ;

		OROrganismHome home = null;
		OROrganismRemote remote = null;

		try
		{
			InitialContext context = new InitialContext();
			Object object		   = context.lookup(OrRepositoryExt.getOrKeyValue("OR_ORGANISM_JNDI"));
			home  = (OROrganismHome) PortableRemoteObject.narrow( object,OROrganismHome.class );
			remote = home.create() ;
			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "records",     record );
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				map = remote.insert(tabDataParam, sqlMap ) ;
			}else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			    map = remote.modify(tabDataParam, sqlMap ) ;
			}

		  //return map;

	  }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		//return map ;
	  }finally {
			clear();
			try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}
		return map;

 }//End of Method

}//ENd of the class
