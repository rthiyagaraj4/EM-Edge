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
import javax.servlet.* ;
import javax.servlet.http.*;

import eOR.OROrderTypesForOrderable.* ;
import eOR.Common.*;

public class OrderTypesForOrderableBean extends OrAdapter implements Serializable
{
	protected String order_type_code;
	protected Hashtable MultiHashData = new Hashtable();
	String debug="";
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

	public OrderTypesForOrderableBean(){
	order_type_code = "";

	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace() ;}
	}

/**********************SET METHODS*************************/
 public void  setOrder_type_code(String  order_type_code) {this.order_type_code=  order_type_code; } ;

/**********************GET METHODS*************************/
public String getOrder_type_code() { return this.order_type_code ; } ;

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
public void setAll( Hashtable recordSet ) {
try{
	setOrder_type_code((String)recordSet.get("order_type_code"));
	setMode((String)recordSet.get("mode"));

	}
	catch(Exception e){
		try{
		 throw new Exception("Excweption@SetAll: "+e);
		 }catch(Exception ee){ee.printStackTrace() ;
		 }
	 }
}

/*********************METHOD TO Reset the Class variable*************************/

public void clear() {
	order_type_code	= ""    ;
	super.clear() ;
}

/*********************METHOD TO Insert*************************/

public HashMap insert(){
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( false ) ) ;
	map.put( "flag","") ;
	map.put( "message","") ;
	map.put( "traceVal", "" ) ;

	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	ArrayList allRecords = new ArrayList();
	String valid= "", associate_yn="";//String index_type="";

	//OROrderTypesForOrderableHome home = null ;
	//OROrderTypesForOrderableRemote remote = null ;



	try {
		allRecords = multiRecBean.getAllDBRecords();

		for(int j=0;j<allRecords.size();j++){

			split			= (HashMap)allRecords.get(j);
			//System.out.println("j="+j);
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

		String order_code				= getOrder_type_code();

		StringTokenizer stoken			= new StringTokenizer(order_code,"~");
		String or_order_type_code		= stoken.nextToken();
		String or_order_category_code	= stoken.nextToken();

		MultiHashData.put("order_type_code", or_order_type_code);
		MultiHashData.put("order_category_code", or_order_category_code);
		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);

		tabData.put("MultiHashData",MultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("properties", (Properties)getProperties());

		HashMap sqlMap = new HashMap();
		sqlMap.put("SQL_ORDER_TYPES_ORDERABLE_DELETE", OrRepository.getOrKeyValue("SQL_ORDER_TYPES_ORDERABLE_DELETE") );
		sqlMap.put("SQL_ORDER_TYPES_ORDERABLE_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_TYPES_ORDERABLE_INSERT") );


		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup( OrRepository.getOrKeyValue("ORDER_TYPES_FOR_ORDERABLE_JNDI") ) ;

		home  = (OROrderTypesForOrderableHome) PortableRemoteObject.narrow( object, OROrderTypesForOrderableHome.class ) ;

		remote = home.create() ;
		map = remote.insert( tabData, sqlMap ) ;*/

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("ORDER_TYPES_FOR_ORDERABLE_JNDI"), OROrderTypesForOrderableHome.class, getLocalEJB());
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


	}
	catch(Exception e) {
	//System.out.println( "#######Error Calling EJB : "+e ) ;
	map.put( "message", e.getMessage()+debug) ;
	e.printStackTrace() ;
	}
	finally{
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
}

public HashMap modify(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "success.." ) ;
	map.put( "flag","") ;
	return map;
}

public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "success.." ) ;
	map.put( "flag","") ;
	return map;

}

public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	map.put( "flag","") ;
	return map ;

}

private void doCommon() throws Exception {
}

public void loadData() throws Exception {
}

public String getComboOptionsOrType()throws Exception {
	Connection connection = null ;
	try{
		connection = getConnection();
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("OR_ORDERABLE_ORDER_TYPES"),connection,"code","short_desc");
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
}

/********Function Specific*************/
public Object getRecordSet(String index, String order_type_code, String order_category_code)throws Exception{
	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		java.util.HashMap htRecord = null;
		String catalog_desc="", SQL_QUERY="", code="";//,status="E",valid="N"
		connection = getConnection();
		multiRecBean.clearSelectRec();
		if(!(index.equals("OTH"))){
			SQL_QUERY = OrRepository.getOrKeyValue("OR_ORDERABLE_ORDER_CATALOG_DESC");
		}else{
			SQL_QUERY = OrRepository.getOrKeyValue("OR_ORDERABLE_ORDER_CATALOG_DESC_OTH");
		}
		pstmt = connection.prepareStatement(SQL_QUERY);
		if(!(index.equals("OTH"))){
			pstmt.setString(1,order_type_code);
			pstmt.setString(2,order_category_code);
			pstmt.setString(3,index+"%");
		}else{
			pstmt.setString(1,order_type_code);
			pstmt.setString(2,order_category_code);
		}
		rs = pstmt.executeQuery();
		if(rs != null){
			while(rs.next()){
				code				=	rs.getString("code");
				catalog_desc		=	rs.getString("long_desc");

			/*	if(valid.equals("Y"))
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
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return multiRecBean;
 }//end of getRecordSet

/*************************************/
public int fetchDBRecords(String order_type_code)throws Exception {
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
			SQL_QUERY = OrRepository.getOrKeyValue("OR_ORDERABLE_TYPES_DB_REC");
			pstmt = connection.prepareStatement(SQL_QUERY);
			pstmt.setString(1,order_type_code);
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
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return total_rec;
 }//end of fetchRecords

/*************************************/
public Object getBean(){
	
	return this.multiRecBean;
}

/***************************To clear the multiRecord bean ***********/
  public boolean clearDBRec()throws Exception{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }//end of clearDBRec
}
