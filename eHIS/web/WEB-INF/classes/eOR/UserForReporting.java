/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;


import eOR.Common.* ;
import eCommon.Common.*;

import eOR.ORUserForReport.*;

public class UserForReporting extends OrAdapter implements java.io.Serializable {
	protected String responsibility 			= "";
	protected String responsibility_desc 		= "";
	protected String practitioner				= "";
	protected String practitioner_desc			= "";
	protected String order_category				= "";
	protected String order_category_desc		= "";
	protected String order_type					= "";
	protected String order_type_desc			= "";
	protected String privilege					= "";
	protected String security_level				= "";
	protected String responsibility_id			= "";
	protected String listValues					= "";
	protected String rist_perform_loc_chk_val	= "";
	protected String catalog_desc				= "";
	
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

	StringBuffer traceVals = new StringBuffer();

//	Connection connection = null ;


	public void setResponsibility(String responsibility){
		this.responsibility = responsibility;
	}
	public void setResponsibilityDesc(String responsibility_desc){
		this.responsibility_desc = responsibility_desc;
	}
	public void setPractitioner(String practitioner){
		this.practitioner = practitioner;
	}
	public void setPractitionerDesc(String practitioner_desc){
		this.practitioner_desc = practitioner_desc;
	}
	public void setOrderCategory(String order_category){
		this.order_category = order_category;
	}
	public void setOrderCategoryDesc(String order_category_desc){
		this.order_category_desc = order_category_desc;
	}
	public void setOrderType(String order_type){
		this.order_type = order_type;
	}
	public void setOrderTypeDesc(String order_type_desc){
		this.order_type_desc = order_type_desc;
	}
	public void setPrivilege(String privilege){
		this.privilege = privilege;
	}
	public void setSecurityLevel(String security_level){
		this.security_level = security_level;
	}
	public void setMode(String mode){
		this.mode = mode;
	}
	public void setResponsibilityId(String responsibility_id){
		this.responsibility_id = responsibility_id;
	}

    public void setListValues(String listValues){
		this.listValues= listValues;
	}
	public void setRist_perform_loc_chk_val(String rist_perform_loc_chk_val){
		this.rist_perform_loc_chk_val = rist_perform_loc_chk_val;
	}
/*
	public void setCatalog_desc(String catalog_desc){
		this.catalog_desc= catalog_desc;
	}
*/	

	public String getResponsibility(){
		return responsibility;
	}
	public String getResponsibilityDesc(){
		return responsibility_desc;
	}
	public String getPractitioner(){
		return practitioner;
	}
	public String getPractitionerDesc(){
		return practitioner_desc;
	}
	public String getOrderCategory(){
		return order_category;
	}
	public String getOrderCategoryDesc(){
		return order_category_desc;
	}
	public String getOrderType(){
		return order_type;
	}
	public String getOrderTypeDesc(){
		return order_type_desc;
	}
	public String getPrivilege(){
		return privilege;
	}
	public String getSecurityLevel(){
		return security_level;
	}
	public String getMode(){
		return mode;
	}
	public String getResponsibilityId(){
		return responsibility_id;
	}

    public String getListValues(){
		return listValues;
	}
	public String getRist_perform_loc_chk_val(){
		return rist_perform_loc_chk_val;
	}
/*
	public String getCatalog_desc(){
		return catalog_desc;
	}
*/

		

/* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		HashMap map = new HashMap() ;

	   if(responsibility.equals(" ") || responsibility.equals("") || responsibility== " " ){
			responsibility= null;
		}
	   if(practitioner.equals(" ") || practitioner.equals("") || practitioner== " " ){
			practitioner= null;
		}

        map.put( "result", new Boolean( true ) ) ;
		if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
        {
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_DUP_CHK")) ;
				pstmt.setString( 1, practitioner ) ;
				pstmt.setString( 2, responsibility) ;
				pstmt.setString( 3, order_category) ;
				pstmt.setString( 4, order_type) ;

				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null && resultSet.next() ) {
					int count = resultSet.getInt( 1 ) ;
					if ( count > 0 ) {
						map.put( "result", new Boolean( false ) ) ;
						map.put( "message", "CODE_ALREADY_EXISTS"  ) ;
						map.put("message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
						clear() ;
					}
					else {
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "success.." ) ;
					}
				}
			  } catch ( Exception e ) {
				System.err.println( "Order Type - validate() method error" ) ;
				e.printStackTrace() ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", e ) ;
				throw e ;
			} finally {
				try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection) ;
					}
					catch(Exception es){es.printStackTrace();
					}
				}
		}
		return map ;
	}



    public String getDetailData (String resp_id, String pract_id, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		//String record = "";
		StringBuffer record = new StringBuffer();

		if(resp_id.equals(" ") ) resp_id = null;
		if(pract_id.equals(" ") ) pract_id = null;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_DETAIL_DATA") ) ;
			pstmt.setString(1,pract_id.trim());
			pstmt.setString(2,resp_id.trim());
			pstmt.setString(3,order_category.trim());


			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				/*record += resultSet.getString( "performing_facility_id" ) + "~"  ;
				record += resultSet.getString( "performing_facility_name" ) + "~"  ;
				record += resultSet.getString( "performing_deptloc_code" ) + "~"  ;
				record += resultSet.getString( "performing_deptloc_short_desc" ) + "`"  ;*/

				record.append(resultSet.getString( "performing_facility_id" ) + "~");
				record.append(resultSet.getString( "performing_facility_name" ) + "~");
				record.append(resultSet.getString( "performing_deptloc_code" ) + "~");
				record.append(resultSet.getString( "performing_deptloc_short_desc" ) + "`" );
				
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
             try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection) ;
			 }
			 catch(Exception es){
				 es.printStackTrace();
			 }
		}
		return record.toString();
	}

/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getOrderTypeData(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_SELECT_ORDER_TYPE") ) ;
			pstmt.setString( 1, order_category ) ;
			resultSet = pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			 try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection) ;
			 }
			 catch(Exception ee){
				 ee.printStackTrace();
			 }
		}

		return OrderCat;
	}

/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getAllOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC5") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
		   try{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		   }
		   catch(Exception e){
			   e.printStackTrace();
		   }
		}
		return OrderCat;
	}


/**
	This will populate all the responsibilities
	@return		:	ArrayList
*/

	public ArrayList getAllResponsibility () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_RESPONSIBILITY")) ;
			resultSet = pstmt.executeQuery() ;

			String[] record=null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "resp_id" )  ;
				record[1] = resultSet.getString( "resp_name" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			  try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection) ;
			  }
			  catch(Exception e){
				  e.printStackTrace();
			  }
		}
		return OrderCat;
	}



/**
	This will populate all the List Values
	@return		:	ArrayList
*/

	public String[] getMainData (String resp_id, String pract_id, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[11];

		if(resp_id.equals(" ") ) resp_id = null;
		if(pract_id.equals(" ") ) pract_id = null;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_MAIN_DATA") ) ;
			pstmt.setString(1,pract_id.trim());
			pstmt.setString(2,resp_id.trim());
			pstmt.setString(3,order_category.trim());


			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				record[0] = resultSet.getString( "resp_name" )  ;
				record[1] = resultSet.getString( "pract_id" )  ;
				record[2] = resultSet.getString( "pract_name" )  ;
				record[3] = resultSet.getString( "resp_id" )  ;
				record[4] = resultSet.getString( "ord_category" )  ;
				record[5] = resultSet.getString( "short_desc" )  ;
				record[6] = resultSet.getString( "ord_typ_code" )  ;
				record[7] = resultSet.getString( "order_type_short_desc" )  ;
				record[8] = resultSet.getString( "user_category" )  ;
				record[9] = resultSet.getString( "security_level" )  ;
				record[10] = resultSet.getString( "restrict_by_deptloc_yn");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			  try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection) ;
			  }
			  catch(Exception e){
				  e.printStackTrace();
			  }
		}
		return record;
	}





/**
	This will populate all the Order Types
	@return		:	ArrayList
*/

	public ArrayList getAllOrderType() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_ORDER_TYPE")) ;
			resultSet = pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		return OrderCat;
	}

/****** this will get the order catalog description for the orderable modalwindow *******/
/*@ return object*/
/***************************************************************************/

public Object getCatalogDesc(String index,String ord_category, String ord_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		//ArrayList CatalogDesc = new ArrayList() ;

		try {
				java.util.HashMap htRecord = null;
				//java.util.HashMap htRecord1 = null;
				String catalog_desc="",  code="";//,status="E",valid="N"
				connection = getConnection() ;
				multiRecBean.clearSelectRec();
			
				if(!(index.equals("OTH"))){
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_CATALOG_SEARCH"));
					pstmt.setString(1,ord_category.trim());
					pstmt.setString(2,ord_type.trim());
					pstmt.setString(3,index+"%");
				}else{
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_CATALOG_SEARCH_OTHERS"));
					pstmt.setString(1,ord_category.trim());
					pstmt.setString(2,ord_type.trim());
				} 

				resultSet = pstmt.executeQuery() ;

				String[] record =null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
					code				=	resultSet.getString("order_catalog_code");
				catalog_desc			=	resultSet.getString("short_desc");
				
				/*		if(valid.equals("Y"))
							status="D";
						else if(valid.equals("N"))
							status="E";	
				*/
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
	
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return multiRecBean;
 }//end of getRecordSet




/************************************************************************/
 public Object getBean(){
	return this.multiRecBean;
 }//end of getBean


 /***************************To clear the multiRecord bean ***********/
  public boolean clearDBRec()throws Exception{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }//end of clearDBRec

 /******************************this will fetch the records from the db**************/
 /***************to populate the multirecbean- Used for modify mode*******************/

public int fetchDBRecords(String resp_id,String Pract_id,String order_category, String order_type_code)throws Exception {
	int total_rec =0;
	Connection connection = null ;
	PreparedStatement pstmt=null;
	HashMap htMapRecord = null;
	ResultSet rs=null;
		
	String code="";
//	String cat_code="";
	if(resp_id == null || resp_id.equals("null"))resp_id="";
	if(Pract_id == null || Pract_id.equals("null"))Pract_id="";
	if(order_type_code == null || order_type_code.equals("null"))order_type_code="";
	if(order_category == null || order_category.equals("null"))order_category="";

	try{
		int checkRec = multiRecBean.getSize("DB");
		if(checkRec==0){
			
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_CATALOG_SEARCH_DB"));

			pstmt.setString(1,resp_id);
			pstmt.setString(2,Pract_id);
			pstmt.setString(3,order_category);
			pstmt.setString(4,order_type_code);
			
			

			rs = pstmt.executeQuery();

			if(rs != null){
				while(rs.next()){
				code					=	rs.getString("order_catalog_code");
				catalog_desc			=   rs.getString("order_catalog_desc");

				htMapRecord		=	new HashMap();
				htMapRecord.put("code"				,	code);
				htMapRecord.put("catalog_desc"		,	catalog_desc);
				htMapRecord.put("valid"				,	"Y");
				htMapRecord.put("associate_yn"		,   "N");
				htMapRecord.put("status"			,   "N");

				//cat_code+=","+code;
				
				multiRecBean.putObject(htMapRecord);
			}
		/*	if(!cat_code.equals("")){
					cat_code = cat_code.substring(1);
				}
				setCatalog_desc(cat_code);
		*/
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


 /*********************************************************************************/


/**
	This will set all the values to the HashMap, which further passsed as an input to the EJB
	@return		:	HashMap
*/

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap tabdata = new HashMap() ;

		traceVals.append("--practitioner  "+practitioner);
		traceVals.append("-- responsibility "+responsibility);




		if(responsibility==null || responsibility.equals("") || responsibility.equals("") || responsibility.equals(" ") ){
			responsibility= "";
		}
		if(practitioner == null || practitioner.equals("") || practitioner.equals(" ") ){
			practitioner= "";
		}

		if(security_level == null || security_level.equals("") || security_level.equals(" ") ){
			security_level= "";
		}
/**************************************************************************/
		ArrayList allRecords = new ArrayList();
		HashMap store = new HashMap();
		String  associate_yn="", catlog_code="";
	//	String valid= "";
		String catlog_desc="";
		

		allRecords = multiRecBean.getAllDBRecords();

		for(int j=0;j<allRecords.size();j++){

			store			= (HashMap)allRecords.get(j);
			//valid			= (String) store.get("valid");
			associate_yn	= (String) store.get("associate_yn");
			catlog_code		= (String) store.get("code");
		
		
				if(associate_yn.equals("Y")){
					//catlog_desc+=","+catlog_code;
					catlog_desc=catlog_desc+","+catlog_code;
				}
		
		}
		if(!catlog_desc.equals("")){
					catlog_desc = catlog_desc.substring(1);
			}

/***************************************************************************/			
		tabdata.put("responsibility",responsibility);
		tabdata.put("practitioner",practitioner);
		tabdata.put("order_category",order_category);
		tabdata.put("order_type",order_type);
		tabdata.put("privilege",privilege);
		tabdata.put("security_level",security_level);
		tabdata.put("rist_perform_loc_chk_val",rist_perform_loc_chk_val);
		tabdata.put( "listValues",	listValues) ;
		tabdata.put( "catalog_desc",catlog_desc) ;
		
		
		tabdata.put( "added_by_id",			login_by_id ) ;
		//tabdata.put( "added_date",			added_date ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;
		tabdata.put( "modified_by_id",		login_by_id ) ;
		//tabdata.put( "modified_date",		modified_date ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;
		tabdata.put( "properties",	getProperties()) ;



		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "USER_FOR_REPORTING_INSERT", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_INSERT") );
			sqlMap.put( "SQL_OR_USER_FOR_REPORTING_PERFORM_LOCN_INSERT", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_PERFORM_LOCN_INSERT") );
			sqlMap.put( "SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE", OrRepository.getOrKeyValue("SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE") );
			sqlMap.put( "SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT", OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT") );
			
		}catch(Exception e){e.printStackTrace();
		}


		//ORUserForReportHome home = null ;
		//ORUserForReportRemote remote = null ;

		try {
		//	System.out.println("!@#$tabdata_insert:"+tabdata);
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("USER_FOR_REPORT_JNDI")) ;
				home  = (ORUserForReportHome) PortableRemoteObject.narrow( object, ORUserForReportHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabdata, sqlMap ) ;*/
				//map = insert( tabdata, sqlMap ) ;
				Object home =com.ehis.eslp.ServiceLocator.getInstance ().getHome( OrRepository.getOrKeyValue("USER_FOR_REPORT_JNDI"), ORUserForReportHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabdata;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabdata.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;


				//String ejbVal = (String) map.get("traceVal");
				//traceVals.append("--ejbVal : "+ejbVal);
				//System.out.println("ejbVal="+ejbVal);


     if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "COMMON")) ;
		
				}

		map.put( "traceVal", traceVals.toString() ) ;







		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;

	}

/**
	This will set all the values to the HashMap, which further passsed as an modify method of the EJB
	@return		:	HashMap
*/

	public HashMap modify(){
		HashMap map = new HashMap() ;
				map.put( "result", new Boolean( false ) ) ;
				traceVals.append("just entered  now fresh-- ");
				HashMap tabdata = new HashMap() ;


				if(responsibility==null || responsibility.equals("") || responsibility.equals("") || responsibility.equals(" ") ){
					responsibility= "";
				}
				if(practitioner == null || practitioner.equals("") || practitioner.equals(" ") ){
					practitioner= "";
				}
/**************************************************************************/
		ArrayList allRecords = new ArrayList();
		HashMap store = new HashMap();
		String  associate_yn="", catlog_code="";
		//String valid= "";
		String catlog_desc="";
		

		allRecords = multiRecBean.getAllDBRecords();

		for(int j=0;j<allRecords.size();j++){

			store			= (HashMap)allRecords.get(j);
			//valid			= (String) store.get("valid");
			associate_yn	= (String) store.get("associate_yn");
			catlog_code		= (String) store.get("code");
		
	
				if(associate_yn.equals("Y")){
					//catlog_desc+=","+catlog_code;
					catlog_desc=catlog_desc+","+catlog_code;
				}
	
		}
		if(!catlog_desc.equals("")){
					catlog_desc = catlog_desc.substring(1);
			}

/***************************************************************************/

				
			
				tabdata.put("responsibility",responsibility);
				tabdata.put("practitioner",practitioner);
				tabdata.put("privilege",privilege);
				tabdata.put("security_level",security_level);
				tabdata.put("rist_perform_loc_chk_val",rist_perform_loc_chk_val);
				tabdata.put( "listValues",	listValues) ;

				tabdata.put( "added_by_id",			login_by_id ) ;
				//tabdata.put( "added_date",			added_date ) ;
				tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
				tabdata.put( "added_facility_id",	login_facility_id ) ;
				tabdata.put( "modified_by_id",		login_by_id ) ;
				//tabdata.put( "modified_date",		modified_date ) ;
				tabdata.put( "modified_facility_id",login_facility_id ) ;
				tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;
				tabdata.put( "responsibility_id",	responsibility_id) ;
				tabdata.put( "properties",	getProperties()) ;
                tabdata.put("order_category", order_category);
				tabdata.put( "catalog_desc",catlog_desc) ;
				tabdata.put("order_type",order_type);
		

				

				HashMap sqlMap = new HashMap() ;
				try{
					sqlMap.put( "USER_FOR_REPORTING_UPDATE", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_UPDATE") );
					sqlMap.put( "SQL_OR_USER_FOR_REPORTING_PERFORM_LOCN_INSERT", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_PERFORM_LOCN_INSERT") );
					sqlMap.put( "SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE", OrRepository.getOrKeyValue("SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE") );
					sqlMap.put( "SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT", OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT") );
					sqlMap.put( "SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE", OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE") );
				}catch(Exception e){e.printStackTrace();
				}

				//traceVals.append("the query is : "+OrInterface.USER_FOR_REPORTING_UPDATE );
				traceVals.append(" --responsibility: "+responsibility);
				traceVals.append(" --practitioner: "+practitioner);
				traceVals.append(" --privilege: "+privilege);
				traceVals.append(" --security_level: "+security_level);
				traceVals.append(" --responsibility_id: "+responsibility_id);

				//ORUserForReportHome home = null ;
				//ORUserForReportRemote remote = null ;


				try {

						/*InitialContext context = new InitialContext() ;
						Object object = context.lookup( OrRepository.getOrKeyValue("USER_FOR_REPORT_JNDI")) ;
						home  = (ORUserForReportHome) PortableRemoteObject.narrow( object, ORUserForReportHome.class ) ;
						remote = home.create() ;
						traceVals.append(" before calling EJB ");
						map = remote.modify( tabdata, sqlMap ) ;*/
						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( OrRepository.getOrKeyValue("USER_FOR_REPORT_JNDI"), ORUserForReportHome.class, getLocalEJB());
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

						Object argArray[]	= new Object[2];
							argArray[0]		= tabdata;
							argArray[1]		= sqlMap;
						Class [] paramArray = new Class[2];
							paramArray[0]	= tabdata.getClass();
							paramArray[1]	= sqlMap.getClass();
						map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
								
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
						argArray	= null;
						paramArray	= null;





						
				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				map.put("traceVal", (String)traceVals.toString());


						//traceVals.append(" after coming from EJB ");h
						//String ejbVal = (String)map.get("traceVal");h
						//map = modify( tabdata, sqlMap )
						//traceVals.append(ejbVal);h
                        //System.out.println("ejbVal="+ejbVal);

				} catch(Exception e) {
					System.err.println( "Error Calling EJB : "+e ) ;
					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
				} finally {
					clear();
					/*try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee ) {
						System.err.println( ee.getMessage() ) ;
						map.put( "message", ee.getMessage() ) ;
					}*/
				}
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;

	}


/**
	This will set all the values to the HashMap, which further passsed as an delete method of the EJB
	@return		:	HashMap
*/

	public HashMap delete(){
		HashMap map = new HashMap() ;
				map.put( "result", new Boolean( false ) ) ;
				traceVals.append("just entered to delete methos-- ");
				HashMap tabdata = new HashMap() ;

				if(responsibility==null || responsibility.equals("") || responsibility.equals("") || responsibility.equals(" ") ){
					responsibility= "";
				}
				if(practitioner == null || practitioner.equals("") || practitioner.equals(" ") ){
					practitioner= "";
				}
				
							
				tabdata.put("responsibility",responsibility);
				tabdata.put("practitioner",practitioner);
				tabdata.put("properties",	getProperties()) ;
				tabdata.put("responsibility_id",	responsibility_id) ;
				tabdata.put("order_category", order_category);
				tabdata.put("order_type",order_type);
		
				
				


				HashMap sqlMap = new HashMap() ;
				try{
					sqlMap.put( "USER_FOR_REPORTING_DELETE", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_DELETE") );
					sqlMap.put( "SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE", OrRepository.getOrKeyValue("SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE") );
					sqlMap.put( "SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE", OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE") );
				}catch(Exception e){e.printStackTrace();
				}

				//traceVals.append("the query is : "+OrInterface.USER_FOR_REPORTING_DELETE );
				traceVals.append(" --responsibility: "+responsibility);
				traceVals.append(" --practitioner: "+practitioner);

				//ORUserForReportHome home = null ;
				//ORUserForReportRemote remote = null ;

				try {
					/*	InitialContext context = new InitialContext() ;
						Object object = context.lookup( OrRepository.getOrKeyValue("USER_FOR_REPORT_JNDI")) ;
						home  = (ORUserForReportHome) PortableRemoteObject.narrow( object, ORUserForReportHome.class ) ;
						remote = home.create() ;
					
						map = remote.delete( tabdata, sqlMap ) ;*/
						//map = delete( tabdata, sqlMap ) ;
						Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome( OrRepository.getOrKeyValue("USER_FOR_REPORT_JNDI"), ORUserForReportHome.class, getLocalEJB());
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

						Object argArray[]	= new Object[2];
							argArray[0]		= tabdata;
							argArray[1]		= sqlMap;
						Class [] paramArray = new Class[2];
							paramArray[0]	= tabdata.getClass();
							paramArray[1]	= sqlMap.getClass();
						map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
								
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
						argArray	= null;
						paramArray	= null;


                 map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				        map.put("traceVal", (String)traceVals.toString());




				} catch(Exception e) {
					System.err.println( "Error Calling EJB : "+e ) ;
					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
				} finally {
					clear();
					/*try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee ) {
						System.err.println( ee.getMessage() ) ;
						map.put( "message", ee.getMessage() ) ;
					}*/
				}
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;

	}


/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
			if(recordSet.containsKey("responsibility")){
			setResponsibility((String)recordSet.get("responsibility")) ;
		}
		if(recordSet.containsKey("practitioner")){
			setPractitioner((String)recordSet.get("practitioner")) ;
		}
		if(recordSet.containsKey("order_type")){
			setOrderType((String)recordSet.get( "order_type" ));
		}
		if(recordSet.containsKey("order_category")){
			setOrderCategory((String)recordSet.get( "order_category" ));
		}
		if(recordSet.containsKey("privilege")){
			setPrivilege((String)recordSet.get( "privilege" ));
		}
		if(recordSet.containsKey("security_level")){
			setSecurityLevel((String)recordSet.get( "security_level" ));
		}
		if(recordSet.containsKey("mode")){
			setMode((String)recordSet.get( "mode" ));
		}
		if(recordSet.containsKey("responsibility_id")){
			setResponsibilityId((String)recordSet.get( "responsibility_id" ));
		}
		if(recordSet.containsKey("listValues")){
			setListValues((String)recordSet.get( "listValues" ));
		}
		if(recordSet.containsKey("rist_perform_loc_chk_val")){
			setRist_perform_loc_chk_val((String)recordSet.get( "rist_perform_loc_chk_val" ));
		}
		
		
		
	}


/**
	This will clear all the values of all bean variables
	@return		:	void
*/

	public void clear()  {
		try{
			responsibility 				= "";
		practitioner				= "";
		order_category				= "";
		order_type					= "";
		privilege					= "";
		security_level				= "";
		listValues					= "";
        rist_perform_loc_chk_val	= "";
		clearDBRec();
		super.clear() ;
		}catch(Exception e){e.printStackTrace();
			//System.err.println("@clear:");
		}
	}

	public ArrayList getPerformingFacility() throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		ArrayList PerformingFacility 	= new ArrayList() ;

		try {
			connection 					= getConnection() ;
			pstmt 						= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_FACILITY")) ;
			resultSet 					= pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "facility_id" )  ;
				record[1] = resultSet.getString( "facility_name" )  ;

				PerformingFacility.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			 try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection) ;
			 }
			 catch(Exception e){
				 e.printStackTrace();
			 }
		}

		return PerformingFacility;
	}

	public ArrayList getPerformingLocn(String locType,String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList LocationClass = new ArrayList();
		try {
			//boolean installed = false;
			connection = getConnection() ;

			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_PERFORM_LOCN_SELECT")) ;

			pstmt.setString(1,facility_id);
            pstmt.setString(2,locType);

            resultSet = pstmt.executeQuery() ;

			String[] record =null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString("short_desc");
				record[1] = resultSet.getString("code");
                LocationClass.add(record);
			}
			
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			LocationClass.add(e);
			throw e ;
		} finally {
			try{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return LocationClass;
	}
}
