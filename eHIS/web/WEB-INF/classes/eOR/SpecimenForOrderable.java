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
import eOR.ORSpecimenForOrderable.* ;
import eOR.Common.*;
import eCommon.Common.*;

public class  SpecimenForOrderable extends eOR.Common.OrAdapter implements Serializable
{
	protected String order_catalog_code;
	public String debug="";
	protected Hashtable MultiHashData = new Hashtable();
	protected Hashtable hashtable=null;

	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

/*********************Constructor *************************/

 public SpecimenForOrderable(){
	order_catalog_code	= ""    ;

	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace() ;}
 }	

/**********************SET METHODS*************************/

  public void  setOrder_catalog_code(String  order_catalog_code) {this.order_catalog_code=  order_catalog_code; } ;
  public void  setDebug(String  debug) {this.debug=  debug; } ;

/**********************GET METHODS*************************/

  public String getOrder_catalog_code() { return this.order_catalog_code ; } ;
  public String getDebug() { return this.debug ; } ;


/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {
	// System.out.println("coming here");
	try{
		 hashtable=recordSet;
		 setOrder_catalog_code((String)hashtable.get("order_catalog_code"));
		 setMode((String)hashtable.get("mode"));
	}
	catch(Exception e){
	try{
		throw new Exception("Excweption@SetAll: "+e);
		}catch(Exception ee){ee.printStackTrace() ;
		}
	 }
 }//end

/********************Validate Method ****************************/ 
  public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	return map ;
 }//end of validate


 public HashMap insert(){
	StringBuffer tmpBuff	= new StringBuffer();
	HashMap map = new HashMap() ;
	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	ArrayList updateArrList = new ArrayList();
	ArrayList allRecords = new ArrayList();
	String valid= "", associate_yn="", default_yn="";
	int temp=0;
	map.put( "result", new Boolean( false ) ) ;
	map.put( "flag","") ;
	
	try {
		allRecords = multiRecBean.getAllDBRecords();
		//System.out.println("####allRecords.size()="+allRecords.size());
		//System.out.println("####allRecords="+allRecords);
		if(allRecords.size()>0){
		for(int j=0;j<allRecords.size();j++){
			split			= (HashMap)allRecords.get(j);
			default_yn=(String) split.get("default_yn");
			valid			= (String) split.get("valid");
			associate_yn	= (String) split.get("associate_yn");
			if(default_yn.equals("Y")){
				temp++;
			}
			   if(temp>1){
					map.put("result",new Boolean(false));
					map.put("message","ATLEAST_ONE_DEFAULT");
					return map;
					}
				if(valid.equals("Y")){
				if(associate_yn.equals("D")){
					deleteArrList.add(split);
				}
				 if(associate_yn.equals("Y")){
					 updateArrList.add(split);
					}
			   }else if(valid.equals("N")){
				if(associate_yn.equals("Y")){
					insertArrList.add(split);
				}
			}
			}
	}else{
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message","CLICK_ONE_ORDERABLE");
		return map;	
		}
		
		MultiHashData.put("order_catalog_code", getOrder_catalog_code());
		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);
		  //System.out.println("####insertArrList="+insertArrList);
		  //System.out.println("####updateArrList="+updateArrList);
		tabData.put("MultiHashData",MultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("updateArrList",updateArrList);
		tabData.put("properties", (Properties)getProperties());
       
		HashMap sqlMap = new HashMap();
		sqlMap.put("SQL_OR_SPECIMEN_FOR_ORDERABLE_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_FOR_ORDERABLE_DELETE") );
		sqlMap.put("SQL_OR_SPECIMEN_FOR_ORDERABLE_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_FOR_ORDERABLE_INSERT") );
		sqlMap.put("SQL_OR_SPECIMEN_FOR_ORDERABLE_UPDATE_DEFAULT_YN", OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_FOR_ORDERABLE_UPDATE_DEFAULT_YN") );

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_SPECIMEN_FOR_ORDERABLE_JNDI"), ORSpecimenForOrderableHome.class, getLocalEJB());
    	
		
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
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
		
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
			
		}
		catch(Exception e) {
		System.err.println( "Error Calling EJB : "+e ) ;
		map.put( "message", e.getMessage()+debug) ;
		e.printStackTrace() ;
		}finally{
			clear();
		
	}
	return map ;
 }//end of insert

/*********************METHOD TO Reset the Class variable*************************/

 public void clear() {
	order_catalog_code = ""    ;
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

 /*********Method to fetch the Data Base Values*************/
 public int fetchDBRecords(String order_catalog_code)throws Exception {
	Connection connection = null ;
	PreparedStatement pstmt=null;
	HashMap htMapRecord = null;
	ResultSet rs=null;
	int total_rec =0;
	String SQL_QUERY="", code="", catalog_desc="" ,default_yn="";
	try{
		int checkRec = multiRecBean.getSize("DB");
		if(checkRec==0){
			connection = getConnection();
			SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_SPECIMEN_FOR_ORDERABLE_DB_REC");
			pstmt = connection.prepareStatement(SQL_QUERY);
			pstmt.setString(1,order_catalog_code);
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
				code					=	rs.getString("KEY_REF");
				catalog_desc					=	rs.getString("ALPHANUM_VALUE");
				default_yn						=	 rs.getString("DEFAULT_YN");
				if(catalog_desc == null || catalog_desc.equals("null"))catalog_desc="";
				htMapRecord		=	new HashMap();
				htMapRecord.put("code"			,	code);
				htMapRecord.put("catalog_desc"	,	catalog_desc);
				htMapRecord.put("default_yn"	,	default_yn);
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
 }//end of fetchRecords  */


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
		//String default_yn="";
		connection = getConnection();
		multiRecBean.clearSelectRec();
		if(!(index.equals("OTH"))){
			SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_ALPHANUMERIC_DESC");
		}else{
			SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_ALPHANUMERIC_DESC_OTH");
		}
		pstmt = connection.prepareStatement(SQL_QUERY);
		if(!(index.equals("OTH"))){
			pstmt.setString(1,index+"%");
		}
		rs = pstmt.executeQuery();
		if(rs != null){
			while(rs.next()){
				code				=	rs.getString("KEY_REF");
				catalog_desc		=	rs.getString("alphanum_value");
			//	default_yn						=	 rs.getString("DEFAULT_YN");
				if(catalog_desc == null || catalog_desc.equals("null"))catalog_desc="";
                htRecord					=	new HashMap();
				htRecord.put("code"			,	code);
				htRecord.put("catalog_desc"	,	catalog_desc);
				htRecord.put("default_yn"	,	"N");
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

}	//end of class
