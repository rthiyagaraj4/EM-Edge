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
//import eOR.ORPatOrderByPrivReln.*;



public class PatOrderByPrivReln extends OrAdapter implements java.io.Serializable {

//	protected Hashtable allValues					= new Hashtable();
//	protected String	user_id						= "";
//	protected String    user_password				= "";
//	protected String    session_id					= "";
	protected String 	pract_id 				    = "";
	protected String 	order_category 			    = "";
	protected String 	order_category_short_desc   = "";
	protected String 	order_type_code 			= "";
	protected String 	order_type_short_desc       = "";
//	protected String 	patient_class_short_desc    = "";
//	protected String 	patient_class				= "";
	protected String 	location_type				= "";
	protected String 	locn_short_desc_location_details= "";
	protected String	order_id					= "";
	protected String	patient_id					= "";
	protected String	order_date_time				= "";
	protected String	order_detail				= "";
	protected String	source_type					= "";
	protected String	source_code					= "";
//	protected String	priority					= "";
	protected String 	priority_desc				= "";
	protected String    ord_pract_id					= "";
	protected String    ordering_pract_name			= "";
	protected String    order_status				= "";
	protected String    order_status_short_desc		= "";
	protected String    total_records 				= "";
//	protected String    period_from					= "";
//	protected String    period_to 					= "";
//	protected String	function_id					= "";


//	StringBuffer traceVals = new StringBuffer();
	public String chk = "";

	public void setTotalRecs(String total_records){
		this.total_records = total_records;
	}
	public void setPracType(String pract_id){
			this.pract_id = pract_id;
	}
/*	public void setSessionId(String session_id) {
			this.session_id	= session_id;
	}*/
	public String  getPracID(){
	return pract_id;
	}
	/*public void setFunctionId(String function_id){
			this.function_id = function_id;
	}*/
	public void setMode(String mode){
		this.mode = mode;
	}
	public void setOrderCategory(String order_category){
			this.order_category = order_category;
	}
	public void setOrderCategoryDesc(String order_category_desc){
			this.order_category_short_desc = order_category_desc;
	}
	public void setOrderType(String order_type_code){
			this.order_type_code = order_type_code;
	}
	public void setOrderTypeDesc(String order_type_code_desc){
			this.order_type_short_desc = order_type_code_desc;
	}
	/*public void setPatientClassDesc(String patient_class_short_desc){
			this.patient_class_short_desc = patient_class_short_desc;
	}*/
	/*public void setPatientClass(String patient_class){
			this.patient_class = patient_class;
	}*/
	public void setLocationType(String location_type){
			this.location_type = location_type;
	}
	public void setLocationDesc(String locn){
			this.locn_short_desc_location_details = locn;
	}
	public void setOrderId(String order_id){
			this.order_id= order_id;
	}
	public void setPatientId(String patient_id){
			this.patient_id = patient_id;
	}
	public void setDateFrom(String date_from){
			this.order_date_time= date_from;
	}
	public void  setOrderDetail(String order_detail){
			this.order_detail=order_detail;
	}
	public void setSourceType(String source_type){
			this.source_type=source_type;
	}
	public void setSourceCode(String source_code){
			this.source_code=source_code;
	}
	/*public void setPriority(String Priority){
			this.priority=Priority;
	}*/
	public void setOrdPractId(String ord_pract_id){
			this.ord_pract_id=ord_pract_id;
	}
	public void setOrderingPractName(String ordering_pract_name){
			this.ordering_pract_name=ordering_pract_name;
	}
	public void setOrderStatus(String order_status){
			this.order_status=order_status;
	}
	public void setOrderStatusDesc(String order_status_short_desc){
			this.order_status_short_desc=order_status_short_desc;
	}

	/*public void setDateTo(String date_to){
			this.period_to= date_to;
	}*/


	public String getMode(){
			return mode;
	}
	public String getTotalRecs(){
			return total_records;
	}
	public String getOrderCategoryCode(){
			return order_category;
	}
	public String getOrderCategoryDesc(){
			return order_category_short_desc;
	}
	public String getOrderType(){
			return order_type_code;
	}
	public String getOrderTypeDesc(){
			return order_type_short_desc;
	}
	public String getPriority(){
			return priority_desc;
	}
	public String getLocationType(){
			return location_type;
	}
	public String getLocation(){
			return locn_short_desc_location_details;
	}
	public String getOrderId(){
			return order_id;
	}
	public String getPatientId(){
			return patient_id;
	}
	public String getOrderDateTime(){
			return order_date_time;
	}
	public String getOrderDetail(){
			return order_detail;
	}
	public String getSourceType(){
			return source_type;
	}
	public String getSourceCode(){
			return source_code;
	}
	public String getOrdPractId(){
			return ord_pract_id;
	}
	public String getOrderingPractName(){
		return ordering_pract_name;
	}
	public String getOrderStatus(){
			return order_status;
	}
	public String getOrderStatusShortDesc(){
			return order_status_short_desc;
	}
/**
	This will populate the order category by preactiotioner ID
	@return		:	ArrayList
*/

	public ArrayList  getOrderTypeSpecimen( String order_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList();  //SQL_OR_SPECIMEN_ORDER_TYPE_SELECT

		try {

			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			   pstmt.setString(1,order_cat);
				resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_type_code" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

public ArrayList  getOrderCategory() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList();  //SQL_OR_SPECIMEN_ORDER_TYPE_SELECT

		try {

			connection = getConnection() ;																	   //SQL_OR_CARE_SET_OTH_PRACT_NAME
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_ORDER_CATEGORY_ON_LOAD") ) ;

			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

public ArrayList  getPractionerID() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList();

		try {

			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_AM_PRACT") ) ;

			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "code" )  ;
				record[1] = resultSet.getString( "long_desc" )  ;

				OrderCat.add(record) ;
			}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}




/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
public ArrayList getLocation(String location_type1, String pract_id1,String facility_id1) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;
			ArrayList Location = new ArrayList() ;
			chk = "";
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCN") ) ;
				pstmt.setString( 1, pract_id1.trim() ) ;
				pstmt.setString( 2, location_type1.trim() ) ;
				pstmt.setString( 3,facility_id1.trim() ) ;

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "locn_code" )  ;
					record[1] = resultSet.getString( "locn_short_desc" )  ;
				   Location.add(record) ;
				}
			} catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
						closeResultSet(resultSet) ;
						closeStatement(pstmt) ;
						closeConnection(connection) ;
			}

			return Location;
		}
public String getSessionId() throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String session_id			= "";
	try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SESSION_SELECT"));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					session_id = checkForNull(resultSet.getString( "session_id" ),"")  ;
				}
			}
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return session_id;
}

private   String  checkNull(String args){
return (args==null ||args.equals(""))?"":args.trim();
}
/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
//public ArrayList getSearchDetails(String order_status,String pat_id1,String pat_id2,String period_from,String period_to ,Stirng location_type,String Locn,String order_cat,String order_type,String catalog_synonym_dc, String priority , String  ord_pract,String search_crt ) throws Exception {//need to check the order in which arguments (catalog_synonym_dc,Location_type,Locn)are passed 
public ArrayList getSearchDetails(String order_status,String pat_id1,String pat_id2,String period_from,String period_to ,String order_cat,String order_type, String priority , String  ord_pract,String search_crt ) throws Exception {
		Connection connection 		= null;
		PreparedStatement pdmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultOrderCatFinal	= new ArrayList() ;

	try {
		connection = getConnection() ;

			 chk = chk + "pat_id1=::"+pat_id1+"@";
 			 chk = chk + "pat_id2=::"+pat_id2+"@";
 			 chk = chk + "order_status=::"+order_status+"@";
 			 chk = chk + "order_cat=::"+order_cat+"@";
 			 chk = chk + "order_type=::"+order_type+"@";
 			 chk = chk + "search_crt=::"+search_crt+"@";
			 chk = chk + "priority=::"+priority+"@";
 			 chk = chk + "period from=::"+period_from+"@";
 			 chk = chk + "period to=::"+period_to+"@";

pdmt =connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SELECT_SEARCH_PAT_BY_PP") ) ;
// pdmt=connection.prepareStatement("SELECT  a.order_category order_category, order_category_short_desc, DECODE(NVL(a.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc,  patient_class_short_desc,patient_class,  location_type||'/'||locn_short_desc location_details ,a.order_id order_id,patient_id, encounter_id,  TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time ,  or_get_order_catalog(a.order_id,a.order_type_code)  order_detail, source_type,source_code,a.priority priority,a.order_type_code  order_type_code,a.order_type_short_desc  order_type_short_desc,  a.ord_pract_id ord_pract_id,ordering_pract_name,  order_status,ordeR_status_short_desc, a.ord_cosign_reqd_yn ord_cosign_reqd_yn, a.can_reason can_reason,a.source_type source_type,a.source_code source_code, nvl(a.cont_order_ind,'DO')  cont_order_ind FROM or_order_vw a,or_order_line b WHERE a.order_id =b.order_id and nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND patient_id between  NVL((''),patient_id) and NVL((''),patient_id) AND TO_DATE(TO_CHAR(a.ord_date_time,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') BETWEEN TO_DATE(NVL((''),'01/01/1000 00:00'),'dd/mm/yyyy hh24:mi') AND TO_DATE(NVL((''),'31/12/9999 23:59'),'dd/mm/yyyy hh24:mi')  AND ('P'  = ('Z')  AND Order_status in (SELECT order_status_code FROM or_order_Status_code WHERE order_status_type IN ('00','05','03'))   OR  'O' =('Z') AND Order_status IN (SELECT order_status_code FROM or_order_Status_code WHERE order_status_type IN ('10'))  OR 'A' = ('Z') AND order_status IN (SELECT order_status_code FROM or_order_Status_code WHERE order_status_type IN ('10','15','20','25','30','35'))  OR 'C' = ('Z') AND order_status IN (SELECT order_status_code FROM or_order_Status_code WHERE order_status_type IN ('85','90'))  OR 'D' = ('Z') AND order_status IN (SELECT order_status_code FROM or_order_Status_code WHERE order_status_type IN ('99','93'))  OR 'H' = ('Z') AND order_status IN (SELECT order_status_code FROM or_order_Status_code WHERE order_status_type in ('45','50'))  OR  'Z' = ('Z') AND order_status IN (SELECT order_status_code FROM or_order_Status_code )) AND a.order_category = NVL((''),a.order_Category) AND a.order_type_code = NVL((''),a.order_type_code) AND upper(b.catalog_synonym_dc) LIKE DECODE ((''),'S',upper('C')||'%','C','%' ||upper('C')||'%','E','%'||upper('C')) and a.priority=nvl((''),a.priority) and a.Ord_pract_id   = nvl('',a.ord_pract_id) ORDER BY a.ord_date_time desc");
			pdmt.setString( 1, language_id);
			pdmt.setString( 2, checkNull(pat_id1) ) ;
		   	pdmt.setString( 3, checkNull(pat_id2)) ;
			pdmt.setString( 4, "") ;
			pdmt.setString( 5, "") ;

  			pdmt.setString( 6, checkNull(order_status) ) ;
			pdmt.setString( 7, checkNull(order_status) ) ;
			pdmt.setString( 8, checkNull(order_status) ) ;
			pdmt.setString( 9, checkNull(order_status) ) ;
			pdmt.setString( 10,checkNull( order_status) ) ;
			pdmt.setString( 11,checkNull( order_status) ) ;
			pdmt.setString( 12,checkNull( order_status) ) ;

			pdmt.setString( 13,checkNull( order_cat) ) ;
			pdmt.setString( 14,checkNull( order_type) ) ;

			pdmt.setString( 15,"S") ;
			pdmt.setString( 16,"") ;
			pdmt.setString( 17,"") ;
			pdmt.setString( 18,"") ;

			pdmt.setString( 19,"" ) ;
			pdmt.setString( 20,checkNull( ord_pract) ) ;

			resultSet = pdmt.executeQuery() ;


	while(resultSet.next() ) {
				ArrayList ResultOrderCat	= new ArrayList() ;
				ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY_SHORT_DESC" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_SHORT_DESC" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "PRIORITY_DESC" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "SOURCE_TYPE" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "SOURCE_CODE" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "ORDERING_PRACT_NAME" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "ORD_PRACT_ID" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "ORDER_STATUS" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "CAN_REASON" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "LOCATION_DETAILS" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "PATIENT_CLASS_SHORT_DESC" ))  ;
	//			ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
		ResultOrderCatFinal.add(ResultOrderCat);
  }
}catch( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pdmt) ;
			closeConnection(connection) ;
		}

		return ResultOrderCatFinal;
}




/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/
/*
	public void setAll( Hashtable recordSet ) {
		try{
			allValues = recordSet;
			this.mode = (String)recordSet.get( "mode" );
			if(recordSet.containsKey("total_recs")){
			setTotalRecs((String)recordSet.get("total_recs"));
			}

			if(recordSet.containsKey("option_list")){
						setOptionList((String)recordSet.get("option_list"));
			}
			if(recordSet.containsKey("specimen_hdr_date_time")){
						setSpecimenDateTime((String)recordSet.get("specimen_hdr_date_time"));
			}

			if(recordSet.containsKey("lb_module")){setLbInstall((String)recordSet.get("lb_module"));}
			if(recordSet.containsKey("order_category")){setOrderCategory((String)recordSet.get("order_category"));}
			if(recordSet.containsKey("session_id")){setSessionId((String)recordSet.get("session_id"));}

//
			if(recordSet.containsKey("specimen_date")){		setSpecimenDate((String)recordSet.get("specimen_date"));	}
			if(recordSet.containsKey("total_recs")){		setTotalRecs((String)recordSet.get("total_recs"));	}
			if(recordSet.containsKey("order_type")){		setOrderType((String)recordSet.get("order_type"));	}
			if(recordSet.containsKey("priority")){			setPriority((String)recordSet.get("priority"));}
			if(recordSet.containsKey("location_type")){ 	setLocationType((String)recordSet.get("location_type"));}
			if(recordSet.containsKey("locn")){				setLocationType((String)recordSet.get("locn"));	}
			if(recordSet.containsKey("patientId")){		setPatientId((String)recordSet.get("patientId"));}
			if(recordSet.containsKey("encntr_id")){  		setEncntrId((String)recordSet.get("encntr_id"));}
			if(recordSet.containsKey("order_no")){		setOrderId((String)recordSet.get("order_no"));	}
			if(recordSet.containsKey("date_from")){		setDateFrom((String)recordSet.get("date_from"));}
			if(recordSet.containsKey("date_to")){			setDateTo((String)recordSet.get("date_to"));}
//			if(recordSet.containsKey("view_by")){			setViewBy((String)recordSet.get("view_by"));}


		}catch(Exception e){}


	 
	}
 */

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/


public HashMap insert(){

//		java.util.Properties  properties = getProperties();
//		user_id			= properties.getProperty( "ecis_jdbc_user" ) ;
//		user_password	= properties.getProperty( "ecis_jdbc_password" ) ;


		HashMap map = new HashMap() ;
	//	map.put( "result", new Boolean( false ) ) ;

	//	HashMap tabData = new HashMap();
	//	HashMap sqlMap = new HashMap() ;

	//	int total = Integer.parseInt(total_records);
	//	int count = 0 ;
		//	for(int i=0; i<total; i++){
//				if(((String)allValues.get("select"+i)).equalsIgnoreCase("Y")){
//				String[] updt_dtl	 = new String[11];
/*				updt_dtl[0] = checkForNull( ((String)allValues.get("order_id"+i)));
				updt_dtl[1] = checkForNull( ((String)allValues.get("source_type"+i)));
				updt_dtl[2] = checkForNull( ((String)allValues.get("source_code"+i)));
				updt_dtl[3] = checkForNull( ((String)allValues.get("specimen_type"+i)));
				updt_dtl[4] = checkForNull( ((String)allValues.get("order_date_time"+i)));
				updt_dtl[5] = checkForNull( ((String)allValues.get("priority"+i)));
				updt_dtl[6] = checkForNull( ((String)allValues.get("coll_label_gen_rule"+i)));
				updt_dtl[7] = checkForNull( ((String)allValues.get("order_type_code"+i)));
				updt_dtl[8] = checkForNull( ((String)allValues.get("specimen_collect_yn"+i)));

				if(!specimen_hdr_date_time.equals(""))
					updt_dtl[9] = specimen_hdr_date_time;
				else
				  updt_dtl[9] = checkForNull( ((String)allValues.get("specimen_date_time"+i)));
				updt_dtl[10] = checkForNull( ((String)allValues.get("order_category"+i)));
					tabData.put("data"+count ,updt_dtl);
				count++;
			  }//end of if condition
			}//end of for loop
		tabData.put("count" ,String.valueOf(count));
		tabData.put( "properties", getProperties() );
		tabData.put( "user_id",user_id ) ;
		tabData.put( "user_password",user_password ) ;
		tabData.put( "login_by_id",login_by_id ) ;
		tabData.put( "login_at_ws_no",login_at_ws_no ) ;
		tabData.put( "login_facility_id",login_facility_id ) ;
		tabData.put( "option_list",option_list ) ;
		tabData.put( "lb_module",lb_module ) ;

		tabData.put( "session_id",session_id ) ;

		ORSpecimenOrderHome  home = null;
	    ORSpecimenOrderRemote remote = null;
		try {
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_SPECIMEN_GEN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIMEN_GEN"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT"));


				InitialContext context = new InitialContext() ;
				Object object = context.lookup( 					OrRepository.getOrKeyValue("OR_SPECIMEN_ORDER_JNDI") ) ;
				home  = (ORSpecimenOrderHome) PortableRemoteObject.narrow( object, ORSpecimenOrderHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;
				map.put("message",(String)map.get( "message"));

			} catch(Exception e) {

				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {

					map.put( "message", ee.getMessage() ) ;
				}
			}	*/
		return map ;
   }
public void clear() {
	//	user_id					= "";
	//	user_password			= "";
		pract_id 			    = "";
		order_category 			= "";
	//	session_id				= "";
		super.clear();
 }


public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}
	
}
