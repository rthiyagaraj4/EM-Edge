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

public class  ChartHorizontalBean  extends OrAdapter  implements Serializable{

	protected String                      chart_result_type;
	protected String                      org_code;
	protected String                      org_long_desc;
	protected String                      org_short_desc;
	protected String                      seq_no;
	protected String                      eff_status;
	protected Hashtable                   hashMultiple;

	public   String tempChk ="";



/*********************Constructor *************************/



 public ChartHorizontalBean()
{
			org_code					= ""    ;
			org_long_desc				= ""    ;
			org_short_desc				= ""    ;
			seq_no						= ""	;
			eff_status					= "D"    ;
}


/**********************SET METHODS*************************/


  public void  setResult_type(String  chart_result_type) {this.chart_result_type=  chart_result_type; } ;
  public void  setOrg_code(String  org_code) {this.org_code=  org_code; } ;
  public void  setOrg_long_desc(String  org_long_desc) {this.org_long_desc=  org_long_desc; } ;
  public void  setOrg_short_desc(String  org_short_desc) {this.org_short_desc=  org_short_desc; } ;
  public void  setSeq_no(String  seq_no) {this.seq_no=  seq_no; } ;

  public void  setEff_status(String  eff_status) {
	  if(eff_status.trim().equals("") )
	  this.eff_status = "D";
	  else
	  this.eff_status=  eff_status;
} ;


/**********************GET METHODS*************************/
  public String getResult_type() { return this.chart_result_type ; } ;
  public String getOrg_code() { return this.org_code ; } ;
  public String getOrg_long_desc() { return this.org_long_desc ; } ;
  public String getOrg_short_desc() { return this.org_short_desc ; } ;
  public String getSeq_no() { return this.seq_no ; } ;
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
			 seq_no					= "";
			 eff_status						= ""    ;
}

/*********************METHOD TO Insert*************************/
 public HashMap insert(){
	HashMap recordStore = new HashMap() ;
	HashMap sqlMap = new HashMap();
	int counter = 0 ;
	try{
		String ID="";
		HashMap tabData=null;
	for(int i=0 ; i < 10 ; i++)
	 {
		ID = "org_code"  + i ;
		tabData = new HashMap() ;
		if(!((String)hashMultiple.get(ID)).trim().equals("")){
			tabData.put(("chart_result_type"), (String)hashMultiple.get(("chart_result_type"))) ;
			tabData.put(("org_code"), (String)hashMultiple.get(("org_code" + i))) ;
			tabData.put(("org_long_desc"),(String)hashMultiple.get(("org_long_desc"+ i))) ;
			tabData.put(("org_short_desc"),(String)hashMultiple.get(("org_short_desc"+ i))) ;
			tabData.put(("seq_no"),(String)hashMultiple.get(("seq_no"+ i))) ;
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

	sqlMap.put("SQL_OR_CHART_HORIZONTAL_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_HORIZONTAL_INSERT") );
	sqlMap.put("SQL_OR_CHART_HORIZONTAL_DUPLICATE_CHK",OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_HORIZONTAL_DUPLICATE_CHK"));
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
	sqlMap.put("SQL_OR_CHART_HORIZONTAL_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_HORIZONTAL_UPDATE"));
	record.put(("chart_result_type"),(String)hashMultiple.get(("chart_result_type")));
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

/************METHOD TO Poulate Result Matrix List Box***********/
public String getComboOptions() {
Connection connection = null ;
try
{
		connection = getConnection() ;
		String str = Populate.getComboOptions(OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE"),connection,"CHART_RESULT_TYPE","CHART_RESULT_TYPE_DESC");
		return str;
	}
	catch(Exception e){
		e.printStackTrace();
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

/*********************METHOD TO load Result Matrix code-desc for Query Page********/
public String getComboString() {
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet rs	= null;
  StringBuffer sb			    = new StringBuffer();
try
	{
		connection  = getConnection();

		pstmt						= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE"));
		rs							= pstmt.executeQuery();
	  

		while (rs.next())
			{
				String  codeDesc			    = ChkDef.defaultString(rs.getString(1));
				String  codeCol			= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeDesc + "," + codeCol + ",");
			}

		 String str =   sb.toString() ;
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e){
		e.printStackTrace();
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
		pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_HORIZONTAL_SELECT_UPDATE"));
		pstmt.setString(1,chart_result_type.trim());
		pstmt.setString(2,org_code.trim());
		resultSet	= pstmt.executeQuery();

		while(resultSet.next())
		{
		setOrg_long_desc(ChkDef.defaultString(resultSet.getString("LONG_DESC")));
		setOrg_short_desc(ChkDef.defaultString(resultSet.getString("SHORT_DESC")));
		setSeq_no(ChkDef.defaultString(resultSet.getString("SEQ_NO")));
		setEff_status(ChkDef.defaultString(resultSet.getString("EFF_STATUS")));
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


/*public String getMessage( String msgId ){
	String msg ="";
	if(msgId.equals("CODE_ALREADY_EXISTS")){
		msg = getMessage(language_id, "CODE_ALREADY_EXISTS", "Common") ;
	int r= msg.indexOf("<br>");
		msg = msg.substring(0,r) ;
	return msg;
	}else{
	return super.getMessage(language_id, msgId, "SM") ;
	}
}*/

/*public String getMessage( String msgId ){
	String msg ="";
	if(msgId.equals("CODE_ALREADY_EXISTS")){
		msg = getMessage(language_id, "CODE_ALREADY_EXISTS", "Common") ;
		int r= msg.indexOf("<br>");
		msg = msg.substring(0,r) ;
		return msg;
	}else{
		
		return super.getMessage(language_id, msgId, "Common") ;
	}
}*/

/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap )
 {
		HashMap map  = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();

		//OROrganismHome home = null;
		//OROrganismRemote remote = null;

		try
		{
			/*InitialContext context = new InitialContext();
			Object object		   = context.lookup(OrRepositoryExt.getOrKeyValue("OR_ORGANISM_JNDI"));
			home  = (OROrganismHome) PortableRemoteObject.narrow( object,OROrganismHome.class );
			remote = home.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ORGANISM_JNDI"),OROrganismHome.class, getLocalEJB());
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
			}else
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				//map = remote.insert(tabDataParam, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			}else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			   // map = remote.modify(tabDataParam, sqlMap ) ;
			   map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
					argArray	= null;
					paramArray	= null;
					
					if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

		  //return map;

	  }catch(Exception e){
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		//return map ;
	  }finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {

				map.put( "message", ee.getMessage() ) ;
			}*/
		}
		return map;

 }//End of Method

}//ENd of the class
