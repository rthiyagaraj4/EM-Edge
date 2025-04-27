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
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;


import eOR.ORIndexOrderCatalog.* ;
import eOR.Common.*;
import eCommon.Common.*;

public class  IndexOrderCatalogBean extends eOR.Common.OrAdapter implements Serializable
{
	protected String service_code;
	public String debug="";
	protected Hashtable MultiHashData = new Hashtable();
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

/*********************Constructor *************************/

 public IndexOrderCatalogBean(){
	service_code	= ""    ;

	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace() ;}
 }

/**********************SET METHODS*************************/

  public void  setService_code(String  service_code) {this.service_code=  service_code; } ;
  public void  setDebug(String  debug) {this.debug=  debug; } ;

/**********************GET METHODS*************************/

  public String getService_code() { return this.service_code ; } ;
  public String getDebug() { return this.debug ; } ;


/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {
	try{

		//System.out.println("recordSet======"+recordSet) ;
		setService_code((String)recordSet.get("service_code"));
		setMode((String)recordSet.get("mode"));
	}
	catch(Exception e){
	try{
		throw new Exception("Excweption@SetAll: "+e);
		}catch(Exception ee){ee.printStackTrace() ;
		}
	 }
 }//end of setALL

/*********************METHOD TO Insert*************************/
public HashMap insert(){
	//System.out.println("###in insert of bean");
	//debug +="inside insert";
	StringBuffer tmpBuff	= new StringBuffer();
	HashMap map = new HashMap() ;
	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	//ArrayList updateArrList = new ArrayList();
	ArrayList allRecords = new ArrayList();
	String valid= "", associate_yn="";
	//String index_type="";
	map.put( "result", new Boolean( false ) ) ;
	map.put( "flag","") ;
	//ORIndexOrderCatalogHome home = null ;
	//ORIndexOrderCatalogRemote remote = null ;

	try {
		allRecords = multiRecBean.getAllDBRecords();
		//System.out.println("####allRecords.size()="+allRecords.size());
		//System.out.println("####allRecords="+allRecords);
		//debug += "Before allRecords:"+allRecords.size();
		if(allRecords.size()>0){
		for(int j=0;j<allRecords.size();j++){

			split			= (HashMap)allRecords.get(j);
			valid			= (String) split.get("valid");
			associate_yn	= (String) split.get("associate_yn");

			if(valid.equals("Y")){
				if(associate_yn.equals("D")){
					deleteArrList.add(split);
				}
			}else if(valid.equals("N")){
				if(associate_yn.equals("Y")){
					insertArrList.add(split);
				}
			}

		}
	}else{
		//System.out.println("####here####");
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message","CLICK_ONE_ORDERABLE");
		return map;	
		}
		//debug += "After allRecords:"+allRecords.size();
		//debug += "delSize:"+deleteArrList.size();
		//debug += "insSize:"+insertArrList.size();
		MultiHashData.put("service_code", getService_code());
		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);

		tabData.put("MultiHashData",MultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("properties", (Properties)getProperties());
//System.out.println("###insertArrList="+insertArrList);
//System.out.println("###deleteArrList="+deleteArrList);
		HashMap sqlMap = new HashMap();
		//**sqlMap.put("SQL_OR_REPLACEABLE_ORDERABLE_DELETE", OrRepository.getOrKeyValue("SQL_OR_REPLACEABLE_ORDERABLE_DELETE") );
		sqlMap.put("SQL_OR_INDEX_ORDER_CATALOG_DELETE", OrRepository.getOrKeyValue("SQL_OR_INDEX_ORDER_CATALOG_DELETE") );
		sqlMap.put("SQL_OR_INDEX_ORDER_CATALOG_INSERT", OrRepository.getOrKeyValue("SQL_OR_INDEX_ORDER_CATALOG_INSERT") );

	//System.out.println("#########sqlMap11111="+sqlMap);
	
		/***/
			//eOR.ORIndexOrderCatalogHome home = new eOR.ORIndexOrderCatalogHome();
			//eOR.ORIndexOrderCatalogManager remote = new eOR.ORIndexOrderCatalogManager();
		/***/



		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup( OrRepository.getOrKeyValue("INDEX_ORDER_CATALOG_JNDI") ) ;

		home  = (ORIndexOrderCatalogHome) PortableRemoteObject.narrow( object, ORIndexOrderCatalogHome.class ) ;
		remote = home.create() ;*/
			/*commented now*/
	/*	map = remote.insert( tabData, sqlMap ) ;*/
		/*commented now*/

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("INDEX_ORDER_CATALOG_JNDI"), ORIndexOrderCatalogHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
		argArray[0]		= tabData;
		argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		paramArray[0]	= tabData.getClass();
		paramArray[1]	= sqlMap.getClass();
 		map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	

	argArray=null;
	paramArray=null;
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
		
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
			/*if( ((Boolean) map.get( "result" )).booleanValue() ){
			map.put( "message", map.get( "msgid" ) ) ;
			map.put( "traceVal", map.get( "traceVal" ) ) ;
			map.put( "flag", debug ) ;
		}
		else{
			map.put( "message", map.get("msgid") ) ;
			map.put( "traceVal", map.get( "traceVal" ) ) ;
			map.put( "flag", debug ) ;
		}*/
		}
		catch(Exception e) {
		System.err.println( "Error Calling EJB : "+e ) ;
		map.put( "message", e.getMessage()+debug) ;
		e.printStackTrace() ;
		}finally{
			clear();
		/*try {
			if( remote != null ){
				remote.remove() ;
			}
		}catch( Exception ee ) {
			System.err.println( ee.getMessage() ) ;
			map.put( "message", ee.getMessage() ) ;
			}*/
	}
	return map ;
 }//end of insert

/********************Validate Method ****************************/
 public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	return map ;
 }//end of validate

/*********************METHOD TO Reset the Class variable*************************/

 public void clear() {
	service_code = ""    ;
	super.clear() ;
 }//end of clear


/*********************METHOD TO Update*************************/

 public HashMap modify(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "success.." ) ;
	return map;
 }//end of modify

 /*********************METHOD TO Delete*************************/

 public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
 }//end of delete

 /*********************doCommon METHOD *************************/

 private void doCommon() throws Exception {
 }

 /*********************loadData METHOD *************************/
 public void loadData() throws Exception {
 }

 /*********************Servvice Option  METHOD *************************/
/* public String getComboOptionsOrService()throws Exception {
	Connection connection = null ;
	try{
		connection = getConnection();
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_INDEX_CATLOG_SERVICE"),connection,"SERVICE_CODE","SHORT_DESC");
		return str;
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
 			closeConnection(connection);
		 }catch(Exception e){
		 throw e;
		 }
	}
 }//end of getComboOptionsOrService*/

 /*********Method to fetch the Data Base Values*************/
 public int fetchDBRecords(String service_code)throws Exception {
	Connection connection = null ;
	PreparedStatement pstmt=null;
	HashMap htMapRecord = null;
	ResultSet rs=null;
	int total_rec =0;
	String SQL_QUERY="", code="", desc="" ;
	try{
		int checkRec = multiRecBean.getSize("DB");
		if(checkRec==0){
			connection = getConnection();
			SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CATALOG_DB_REC");
			pstmt = connection.prepareStatement(SQL_QUERY);
			pstmt.setString(1,service_code);
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
				code					=	rs.getString("code");
				desc					=	rs.getString("long_desc");
				if(desc == null || desc.equals("null"))desc="";
				htMapRecord		=	new HashMap();
				htMapRecord.put("code"			,	code);
				htMapRecord.put("catalog_desc"	,	desc);
				htMapRecord.put("valid"			,	"Y");
				htMapRecord.put("associate_yn"	,   "N");
				htMapRecord.put("status"		,   "N");

				multiRecBean.putObject(htMapRecord);
			}
		}
	}
	total_rec = multiRecBean.getSize("DB");
	//return total_rec;
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return total_rec;
 }//end of fetchRecords

 /*********************Method to fetch Alphabetical Records ***********************/
// public Object getRecordSet(String index, String service_code)throws Exception{
 public Object getRecordSet(String index)throws Exception{
	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		java.util.HashMap htRecord = null;
		String  catalog_desc="", SQL_QUERY="", code="";//,status="E";
		//valid="N",
		connection = getConnection();
		multiRecBean.clearSelectRec();
		if(!(index.equals("OTH"))){
			SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CATALOG_DESC");
		}else{
			SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CATALOG_DESC_OTH");
		}
		pstmt = connection.prepareStatement(SQL_QUERY);
		if(!(index.equals("OTH"))){
			pstmt.setString(1,index+"%");
		}
		rs = pstmt.executeQuery();
		if(rs != null){
			while(rs.next()){
				code				=	rs.getString("code");
				catalog_desc		=	rs.getString("long_desc");
				//valid				=	rs.getString("valid");

				/*if(valid.equals("Y"))
					status="D";
				else if(valid.equals("N"))
					status="E";*/

				if(catalog_desc == null || catalog_desc.equals("null"))catalog_desc="";

				htRecord					=	new HashMap();

				htRecord.put("code"			,	code);
				htRecord.put("catalog_desc"	,	catalog_desc);

				htRecord.put("valid"		,	"N");
				htRecord.put("associate_yn" ,   "N");
				htRecord.put("status"		,	"N");
				multiRecBean.putListObject(htRecord);
			}
		}
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return multiRecBean;
 }//end of getRecordSet

 /***************************To get the multiRecord bean ***********/
 public Object getBean(){
	return this.multiRecBean;
 }//end of getBean

 /***************************To clear the multiRecord bean ***********/
  public boolean clearDBRec()throws Exception{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }//end of clearDBRec
}//end of class


