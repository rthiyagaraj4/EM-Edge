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
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;


public class  SpecimenCollectionBean  extends OrAdapter implements Serializable{
	protected String            ordering_facility_id;
	protected String            source_type;
	protected String            source_code;
	protected String            urgency_indicator;
	protected String            nurse_collect_yn_dflt;
	protected String            facility_name ;


	public StringBuffer	tempChk= new StringBuffer();


/*********************Constructor *************************/

 public SpecimenCollectionBean(){
			 ordering_facility_id               = ""    ;
			 source_type						= ""    ;
			 source_code						= ""    ;
			 urgency_indicator					= ""    ;
			 nurse_collect_yn_dflt				= ""    ;
			//try {
			//	doCommon();
			//}catch(Exception e) {}
	}

/*********************Validate *************************/

public HashMap validate() throws Exception {
	HashMap map = new HashMap();
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." );
	return map;
}

/**********************SET METHODS*************************/

  public void  setOrdering_facility_id(String  ordering_facility_id) {this.ordering_facility_id=  ordering_facility_id; } ;
  public void  setSource_type(String  source_type) {this.source_type=  source_type; } ;
  public void  setSource_code(String  source_code) {this.source_code=  source_code; } ;
  public void  setUrgency_indicator(String  urgency_indicator) {this.urgency_indicator=  urgency_indicator; } ;
  public void  setNurse_collect_yn_dflt(String  nurse_collect_yn_dflt) {this.nurse_collect_yn_dflt=  nurse_collect_yn_dflt; } ;
  public void  setFacility_name(String  facility_name) {this.facility_name=  facility_name; } ;
/**********************GET METHODS*************************/

  public String getOrdering_facility_id(){return this.ordering_facility_id ; } ;
  public String getSource_type() { return this.source_type ; } ;
  public String getSource_code() { return this.source_code ; } ;
  public String getUrgency_indicator() { return this.urgency_indicator ; } ;
  public String getNurse_collect_yn_dflt(){return this.nurse_collect_yn_dflt ;};
  public String getFacility_name(){return this.facility_name ;};

/*********************METHOD TO SET ALL THE FEILDS AT ONCE****************/

 public void setAll( Hashtable recordSet ) {
	if(recordSet.containsKey("ordering_facility_id"))
		 setOrdering_facility_id((String)recordSet.get("ordering_facility_id"));
	if(recordSet.containsKey("source_type"))
		 setSource_type((String)recordSet.get("source_type"));
	if(recordSet.containsKey("source_code"))
		 setSource_code((String)recordSet.get("source_code"));
	if(recordSet.containsKey("urgency_indicator"))
		setUrgency_indicator((String)recordSet.get("urgency_indicator"));
	if(recordSet.containsKey("nurse_collect_yn_dflt"))
setNurse_collect_yn_dflt(checkForNull((String)recordSet.get("nurse_collect_yn_dflt"),"N"));
	this.mode = (String)recordSet.get("mode");
}

/*********************METHOD TO Reset the Class variable************/

	public void clear() {
			 source_type						= ""    ;
			 source_code						= ""    ;
			 urgency_indicator					= ""    ;
			 nurse_collect_yn_dflt				= ""    ;
}

/*********************METHOD TO Insert*************************/
public HashMap insert(){
	try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList insertData = new ArrayList() ;
			ArrayList whereData = new ArrayList() ;

			insertData.add(ordering_facility_id);
			insertData.add(source_type);
			insertData.add(source_code);
			insertData.add(urgency_indicator);
			insertData.add(nurse_collect_yn_dflt);
			insertData.add(login_by_id ) ;
			insertData.add(login_at_ws_no ) ;
			insertData.add(login_facility_id ) ;
			insertData.add(login_by_id ) ;
			insertData.add(login_at_ws_no ) ;
			insertData.add(login_facility_id ) ;

			whereData.add(ordering_facility_id) ;
			whereData.add(source_type) ;
			whereData.add(source_code);
			whereData.add(urgency_indicator);

		    sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_INSERT"));
            sqlMap.put("SelectSQL",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_DUPLICATE_CHK"));

			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);
			return getResult(tabData,sqlMap) ;

	}catch(Exception e){
		tempChk.append(e.getMessage());
		logErrorMessage(e);
		return null;
	}

			//return sqlMap ;
}

/*********************METHOD TO Update*************************/

public HashMap modify(){
	try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList modifyData = new ArrayList() ;
		//	ArrayList whereData = new ArrayList() ;

			modifyData.add(nurse_collect_yn_dflt);
			modifyData.add(login_by_id ) ;
			modifyData.add(login_at_ws_no ) ;
			modifyData.add(login_facility_id ) ;
			modifyData.add(ordering_facility_id) ;
			modifyData.add(source_type) ;
			modifyData.add(source_code);
			modifyData.add(urgency_indicator);

		   sqlMap.put("ModifySQL",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_UPDATE"));
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",modifyData);
		//	tabData.put("sql",sqlMap.toString());
		//	return tabData;
			return getResult(tabData,sqlMap) ;
		}
	catch(Exception e){
		tempChk.append(e.getMessage());
		logErrorMessage(e);
		return null;
	}


}

/*********************METHOD TO Delete*************************/

public HashMap delete(){
try{
	HashMap tabData = new HashMap();
	ArrayList delData = new ArrayList() ;
	HashMap sqlMap = new HashMap();

	delData.add(ordering_facility_id);
	delData.add(source_type) ;
	delData.add(source_code);
	delData.add(urgency_indicator);

	sqlMap.put("DeleteSQL",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_DELETE"));
	tabData.put("properties",getProperties());
	tabData.put("DeleteData",delData);
	//tabData.put("sql",sqlMap.toString());
//	return tabData;
	return getResult(tabData,sqlMap) ;
	}catch(Exception e){
		tempChk.append(e.getMessage());
		logErrorMessage(e);
		return null;
	}

}

/*********************DoCommon*************************/

	 private void doCommon() throws Exception {
}

/**************get Combo Options for Facility********/

public String getComboOptions() {
Connection connection =null ;
try
{		tempChk.append("");
		connection = getConnection();
		tempChk.append("before");
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_FACILITY_SELECT"),connection,"FACILITY_ID","FACILITY_NAME");
		return str;
	}
	catch(Exception e){
		tempChk.append(e.getMessage());
		logErrorMessage(e);
		return null;
	}
	finally
	{
		try
		 {
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();

		 }
	}
}
/*********************load in Update Mode*****************/
public void load(String ordering_facility_id_p,String source_type_p, String source_code_p,String urgency_p) throws Exception {
 Connection 	connection  = null;
 PreparedStatement pstmt = null ;
 ResultSet resultSet = null ;

try
	{
		connection  = getConnection();
		pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_LOADUPDATE_N"));
		pstmt.setString(1,ordering_facility_id_p.trim());
		pstmt.setString(2,source_type_p.trim());
		pstmt.setString(3,source_code_p.trim());
		pstmt.setString(4,urgency_p.trim());

		resultSet	= pstmt.executeQuery();

		while(resultSet.next())
		{
			tempChk.append("wwwgere>>") ;
			tempChk.append(resultSet.getString("facility_name") +"<<<>");
			tempChk.append(resultSet.getString("nurse_collect_yn_dflt") +"<>>");
			tempChk.append("after");

			setFacility_name(ChkDef.defaultString(resultSet.getString("FACILITY_NAME")));
			//setUrgency_indicator(ChkDef.defaultString(resultSet.getString("URGENCY_INDICATOR")));
			setNurse_collect_yn_dflt(ChkDef.defaultString(resultSet.getString("NURSE_COLLECT_YN_DFLT")));
			}

	}catch(Exception e){
		tempChk.append(e.getMessage());

	}finally{
		try
		 {
		 	closeResultSet(resultSet);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){
			 throw e;
		 }
	}
}
/*************get Combo Options Dynamic Population***********/
/*public String getComboBoxHtml(Hashtable ht) throws Exception {
	String sql = "" ;
	String optionString = "";
	String comboBoxString = "";
	Connection con = null;
try
	{
		if( ht == null )
			return "Hashtable Passed to  this method is null for Combo Method";

		con = getConnection();
	 	String  source_type = ((String)ht.get("source_type")).trim();
		String  facility_id = ((String)ht.get("facility_id")).trim();

		String valSource[]  ={"D","C","N","R"} ;
		String sqlSource[]= {OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_DEPT"),
		OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_CLINIC"),
		OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_NURSING"),
		OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_REFERRAL")} ;

		if(facility_id.trim().equals("*") ){
		comboBoxString="&nbsp;<select name='source_code'><option value='*ALL'> All&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		return comboBoxString ;
		}

		sql = eHISFormatter.chkReturn(valSource,source_type,sqlSource,"");
//	System.out.println("######sql="+sql);	
		if(!source_type.equals("R"))
			sql  =eHISFormatter.replaceForSQL(sql,"?",facility_id);
		optionString = Populate.getComboOptions(sql,con,"CODE","SHORT_DESC");


		if(optionString.trim().equals(""))
		comboBoxString="&nbsp;<select name='source_code'><option value=''> &nbsp;&nbsp;&nbsp;&nbsp;---select---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		else
		comboBoxString="&nbsp;<select name='source_code'><option value='A'> ALL</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
	//System.out.println("######comboBoxString="+comboBoxString);	
	}catch(Exception e){
		throw e;
	}finally
	{
		try
		{
		closeConnection(con);
		}
		catch(Exception e){
			throw e;
		}
	}

	return comboBoxString;
}
*/
/**********This Method  Actually Calls the EJB's Method ********************/
private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
		HashMap map  = new HashMap() ;
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;

		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;

			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;

			home		 = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote		 = home.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
				paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlMap.getClass();
						
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				//map = remote.delete(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				//map = remote.insert(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			}else if  (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
	//			return tabData ;
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
				
				
				//map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				

			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }
		  //return map;

		}catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put("message1","error");
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		//return map ;
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
