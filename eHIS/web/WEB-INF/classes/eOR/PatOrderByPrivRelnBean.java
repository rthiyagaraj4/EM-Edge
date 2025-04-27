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

import javax.servlet.*;
import javax.servlet.http.*;
import eOR.Common.* ;
import eCommon.Common.*;
//import eOR.ORPatOrderByPrivfReln.*;



public class PatOrderByPrivRelnBean extends eOR.Common.OrAdapter implements java.io.Serializable {

	protected Hashtable allValues 				    = new Hashtable();
//	protected String    user_id				= "";
//	protected String    user_password				= "";
//	protected String    session_id	= "";
	protected String 	 pract_id 			    = "";
	protected String 	 order_category 			    = "";
	protected String 	 order_category_short_desc   ="";
	protected String 	 order_type_code 			= "";
	protected String 	 order_type_short_desc       ="";
//	protected String 	 patient_class_short_desc    ="";
//	protected String 	 patient_class				="";
	protected String 	 location_type				="";
	protected String 	 locn_short_desc_location_details="";
	protected String	 order_id								="";
	protected String	 patient_id								="";
	protected String	 order_date_time					="";
	protected String	 order_detail							="";
	protected String	 source_type							="";
	protected String	 source_code							="";
//	protected String	 priority									="";
	protected String 	 priority_desc				="";
	protected String    ord_pract_id						="";
	protected String    ordering_pract_name			="";
	protected String    order_status							="";
	protected String    order_status_short_desc	="";
	protected String    total_records 						= "";


//	protected ArrayList persistence_details		= new ArrayList();
//	protected String    period_from								="";
//	protected String    period_to 									= "";
//	protected String	function_id								="";
//	HttpServletRequest request 			= null;
//	HttpServletResponse response 		= null;

//	StringBuffer traceVals = new StringBuffer();
//	public String chk = "";

	public void setTotalRecs(String total_records){
		this.total_records = total_records;
	}
	public void setPracType(String pract_id){
			this.pract_id = pract_id;
	}
	/*public void setSessionId(String session_id) {
			this.session_id	= session_id;
	}*/
	public String  getPracID(){
	return pract_id;
	}
	public void setFunctionId(String function_id){
			this.function_id = function_id;
	}
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
	}
	public void setPatientClass(String patient_class){
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

/*	public void setDetails(ArrayList persistence_details){
			this.persistence_details=persistence_details;
	}
	
*/

/*	public void setDateTo(String date_to){
			this.period_to= date_to;
	}
*/
	public Hashtable getAllValues() {
	   return allValues;
	}

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
	
/*	public ArrayList getDetails(){
			return persistence_details;
	}
*/	

/**
	This will populate the order category by preactiotioner ID
	@return		:	ArrayList
*/

	/*public ArrayList  getOrderTypeSpecimen( String order_cat) throws Exception {
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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	} 
public ArrayList  getActivityType(String order_category, String order_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		ArrayList ActivityType = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
			pstmt.setString( 1, order_category.trim() ) ;
			pstmt.setString( 2, order_type.trim() ) ;
			pstmt.setString( 3, order_category.trim() ) ;
			

			resultSet = pstmt.executeQuery() ;
			while(resultSet.next())
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "activity_type" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				ActivityType.add(record) ;
				
			}
						
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return ActivityType;
	}*/
public ArrayList  getOrderCategory() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList();  //SQL_OR_SPECIMEN_ORDER_TYPE_SELECT

		try {

			connection = getConnection() ;																	   //SQL_OR_CARE_SET_OTH_PRACT_NAME
			//pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_ORDER_CATEGORY_ON_LOAD") ) ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString( 1, language_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

/*
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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

*/


/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
public ArrayList getLocation(String location_type1, String pract_id1,String facility_id1) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;
			ArrayList Location = new ArrayList() ;
//			chk = "";
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION") ) ;
				pstmt.setString( 1, language_id);
			    pstmt.setString( 2, language_id);
				pstmt.setString( 3, pract_id1.trim() ) ;
				pstmt.setString( 4, location_type1.trim() ) ;
				pstmt.setString( 5,facility_id1.trim() ) ;
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, location_type1.trim() ) ;

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "locn_code" )  ;
					record[1] = resultSet.getString( "locn_short_desc" )  ;
				   Location.add(record) ;
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
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
/*public ArrayList getSearchResultDetails(String order_status,String pat_id1,String encounterId,String period_from,String period_to ,String location_type,String locn,String order_cat,String order_type,String catalog_synonym_dc  , String priority ,String search_crt,String order_by,String practitioner_id,String ordering_pract,String activity_type ) throws Exception {
		Connection connection 		= null;
		PreparedStatement pdmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultOrderCatFinal	= new ArrayList() ;

	try {
		connection = getConnection() ;

			 chk += "pat_id1=::"+pat_id1+"@";
 			 chk += "encounterId=::"+encounterId+"@";
 			 chk += "order_status=::"+order_status+"@";
 			 chk += "order_cat=::"+order_cat+"@";
 			 chk += "order_type=::"+order_type+"@";
 			 chk += "search_crt=::"+search_crt+"@";
			 chk += "priority=::"+priority+"@";
 			 chk += "period from=::"+period_from+"@";
 			 chk += "period to=::"+period_to+"@";
			 chk += "order_by=::"+order_by+"@";

            if ((checkNull(order_status)).equals("B")) {
                pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL1_APPT") ) ;
             } else {
			 pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL1") ) ;
			}


//pdmt =connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SELECT_SEARCH_PAT_BY_PP") ) ;

			pdmt.setString( 1, checkNull(pat_id1) ) ;
		   	pdmt.setString( 2, checkNull(encounterId)) ;
		   	if ((checkNull(order_status)).equals("B")) {
		   	  pdmt.setString( 3, "") ;
			  pdmt.setString( 4, "") ;
		   	} else {
		   	  pdmt.setString( 3, checkNull(period_from)) ;
			  pdmt.setString( 4, checkNull(period_to)) ;
		   	}


  			pdmt.setString( 5, checkNull(order_status) ) ;
			pdmt.setString( 6, checkNull(order_status) ) ;
			pdmt.setString( 7, checkNull(order_status) ) ;
			pdmt.setString( 8, checkNull(order_status) ) ;
			pdmt.setString( 9,checkNull( order_status) ) ;
			pdmt.setString( 10,checkNull( order_status) ) ;
			pdmt.setString( 11,checkNull( order_status) ) ;
			pdmt.setString( 12,checkNull( order_status));

			if ((checkNull(order_status)).equals("B")) {

			    pdmt.setString( 13,checkNull( period_from ));
			    pdmt.setString( 14,checkNull(period_to));
			    pdmt.setString( 15,checkNull( order_cat) ) ;
    			pdmt.setString( 16,checkNull( order_type) ) ;

    			pdmt.setString( 17,checkNull(priority) ) ;
    			pdmt.setString( 18,checkNull(search_crt) );
    			pdmt.setString( 19,checkNull(catalog_synonym_dc) ) ;
    			pdmt.setString( 20,checkNull(catalog_synonym_dc) ) ;
    			pdmt.setString( 21,checkNull(catalog_synonym_dc) ) ;

    			pdmt.setString( 22,checkNull(practitioner_id) ) ;
    			pdmt.setString( 23,checkNull(location_type) );
    			pdmt.setString( 24,checkNull(locn) );
    			pdmt.setString( 25,checkNull(ordering_pract) );
				pdmt.setString( 26,checkNull( period_from ));
			    pdmt.setString( 27,checkNull(period_to));
				pdmt.setString( 28,checkNull(activity_type));
    			pdmt.setString( 29,checkNull( order_by) ) ;
			} else {

    			pdmt.setString( 13,checkNull( order_cat) ) ;
    			pdmt.setString( 14,checkNull( order_type) ) ;

    			pdmt.setString( 15,checkNull(priority) ) ;
    			pdmt.setString( 16,checkNull(search_crt) );
    			pdmt.setString( 17,checkNull(catalog_synonym_dc) ) ;
    			pdmt.setString( 18,checkNull(catalog_synonym_dc) ) ;
    			pdmt.setString( 19,checkNull(catalog_synonym_dc) ) ;

    			pdmt.setString( 20,checkNull(practitioner_id) ) ;
    			pdmt.setString( 21,checkNull(location_type) );
    			pdmt.setString( 22,checkNull(locn) );
    			pdmt.setString( 23,checkNull(ordering_pract) );
				pdmt.setString( 24,checkNull( period_from ));
			    pdmt.setString( 25,checkNull(period_to));
				pdmt.setString( 26,checkNull(activity_type));
    			pdmt.setString( 27,checkNull( order_by) ) ;
			}

			resultSet = pdmt.executeQuery() ;


	while(resultSet.next() ) {

				ArrayList ResultOrderCat	= new ArrayList() ;
				ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "PRIORITY_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "SOURCE_TYPE" ))  ;
				ResultOrderCat.add(resultSet.getString( "SOURCE_CODE" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDERING_PRACT_NAME" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORD_PRACT_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_STATUS" ))  ;
				ResultOrderCat.add(resultSet.getString( "LOCATION_DETAILS" ))  ;
				ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "PATIENT_CLASS_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_DATE_TIME"));
				ResultOrderCat.add(resultSet.getString( "ORDER_DETAIL"));
				ResultOrderCat.add(resultSet.getString( "ORDER_STATUS_SHORT_DESC"));
		        ResultOrderCat.add(resultSet.getString( "PATIENT_DETAILS"));
				ResultOrderCat.add((resultSet.getString("start_date_time")== null)? "" : resultSet.getString( "start_date_time"));
				ResultOrderCat.add((resultSet.getString( "end_date_time") == null)? "" : resultSet.getString( "end_date_time"));
				ResultOrderCat.add(resultSet.getString( "SEX"));
				ResultOrderCat.add((resultSet.getString( "result_hyperlink_yn")== null)? "" : resultSet.getString( "result_hyperlink_yn"));
				ResultOrderCat.add(resultSet.getString( "cont_order_ind"));
				ResultOrderCat.add(resultSet.getString( "order_line_num"));
				ResultOrderCat.add(resultSet.getString( "patient_class"));
				ResultOrderCat.add(resultSet.getString( "priority"));
				ResultOrderCat.add(resultSet.getString( "ph_colors"));
				ResultOrderCat.add(resultSet.getString( "appt_date_time"));
				ResultOrderCat.add(resultSet.getString( "appt_ref_num"));
				
				ResultOrderCat.add(resultSet.getString( "appt_locn"));
				ResultOrderCat.add(resultSet.getString( "appt_resched_yn"));
				ResultOrderCat.add(resultSet.getString( "appt_resched_reason"));
				ResultOrderCat.add(resultSet.getString( "no_of_reschedules"));
		ResultOrderCatFinal.add(ResultOrderCat);   
  }
}catch( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pdmt ) ;
			closeConnection(connection) ;
		}

		return ResultOrderCatFinal;
}

*/

/**********function for color codings******************************************/


/*public String getColors(String facility_id,String order_id,String order_catalog_code,String order_line_num) throws Exception{

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet_color 		= null;
		String 	  colorString		= "X,X,X";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_COLOR_SELECT"));

			pstmt.setString(1, checkForNull(facility_id,""));
			pstmt.setString(2, checkForNull(order_id,""));
			pstmt.setString(3, checkForNull(order_catalog_code,""));
			pstmt.setString(4, checkForNull(order_line_num,""));

			resultSet_color = pstmt.executeQuery();

			if(resultSet_color.next()){

				colorString = resultSet_color.getString(1);
             }else{
				 colorString = "X,X,X";
      		}
          }catch(Exception e_color ){
   			System.out.println("Exception@ color:" +e_color);
          }finally{
			 closeResultSet( resultSet_color ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
	      }
		  return colorString;
}
*/

/****************************************************************************************/





/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
	/*	try{*/
			allValues = recordSet;
		//	this.request = (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;
		//	this.response = (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;
/*date change in thai*/
if ( !language_id.equals("en") )
{ 
		String period_from = (String)recordSet.get("period_from");
		String period_to = (String)recordSet.get("period_to");		
		String curr_sys_date = (String)recordSet.get("curr_sys_date");
		 if (period_from.equals(" ") || period_from.equals("null")) period_from="";
		if (period_to.equals(" ") || period_to.equals("null")) period_to="";
		if (curr_sys_date.equals(" ") || curr_sys_date.equals("null")) curr_sys_date="";
		period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY",language_id,"en");
		recordSet.put("period_from",period_from);
		recordSet.put("period_to",period_to);
		recordSet.put("curr_sys_date",curr_sys_date);
}
		/* date change*/
			this.mode = (String)recordSet.get( "mode" );
			if(recordSet.containsKey("total_recs")){
			setTotalRecs((String)recordSet.get("total_recs"));
			}
/*
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


	  */
	}


/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/


public HashMap insert(){

//		java.util.Properties  properties = getProperties();
//		user_id			= properties.getProperty( "ecis_jdbc_user" ) ;
//		user_password	= properties.getProperty( "ecis_jdbc_password" ) ;


		HashMap map = new HashMap() ;
try{
		//OnLinePrinting online_print = new OnLinePrinting(request,response);
	//	OnLinePrinting online_print = new OnLinePrinting();
	//	map = (HashMap)online_print.callOnlinePrint(allValues,request,response);
   //     String traceVal = (String)map.get("traceVal");
        //System.out.println("traceval="+traceVal);
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
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}
			}	*/
}catch(Exception e){
	System.out.println(e.getMessage());
}
		return map ;
}
public void clear() {
	//	user_id					= "";
	//	user_password			= "";
		pract_id 			    = "";
		order_category 			= "";
	//	session_id				= "";
	//	persistence_details		= null;
		super.clear();
 }


public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME1") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
				currentDate.add(resultSet.getString("next_week_date"))  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}

/****************************************************************************************/
/*********************this function is called to display the details in the**************/
/*********************common Active Order Modal window***********************************/
/****************** Added by suresh on 12/05/2004*****************************************/
/***************************************************************************************/
public ArrayList getModalResultDetails(String Patient_id,String login_pract_id,String encounter_id,String patient_class,String discharge_indicator) throws Exception {
		Connection connection 		= null;
		PreparedStatement pdmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultOrderCatFinal	= new ArrayList() ;

	try {
		connection = getConnection() ;
        if ((!((checkNull(Patient_id)).equals(""))) && (!((checkNull(encounter_id)).equals("")))  && (!((checkNull(discharge_indicator)).equals(""))) ){
	      pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2_DISCHARGE_IND") ) ;
		   pdmt.setString( 1,language_id);
		   pdmt.setString( 2,language_id);
		   pdmt.setString( 3,language_id);
		   pdmt.setString( 4,language_id);
		   pdmt.setString( 5,language_id);
		    pdmt.setString( 6,language_id);
	       pdmt.setString( 7,checkNull(Patient_id) ) ;
	       pdmt.setString(8,checkNull(encounter_id));
	       pdmt.setString(9, checkNull(discharge_indicator));
	       //System.out.println("patient_id="+checkNull(Patient_id)+",encounter_id="+encounter_id+",discharge_indicator="+discharge_indicator);

	    } else if ((!((checkNull(Patient_id)).equals(""))) && (!((checkNull(encounter_id)).equals(""))) ){
	       pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2_ENCNTR_ID") ) ;
		   pdmt.setString( 1,language_id);
		   pdmt.setString( 2,language_id);
		   pdmt.setString( 3,language_id);
		   pdmt.setString( 4,language_id);
		   pdmt.setString( 5,language_id);
		   pdmt.setString( 6,language_id);
	       pdmt.setString( 7,checkNull(Patient_id) ) ;
	       pdmt.setString(8,checkNull(encounter_id));
	       //System.out.println("patient_id="+checkNull(Patient_id)+",encounter_id="+encounter_id);

	    } else if (!((checkNull(Patient_id)).equals(""))) {
    	   pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2") ) ;
		   pdmt.setString( 1,language_id);
		   pdmt.setString( 2,language_id);
		   pdmt.setString( 3,language_id);
		   pdmt.setString( 4,language_id);
		   pdmt.setString( 5,language_id);
		   pdmt.setString( 6,language_id);
	       pdmt.setString( 7,checkNull(Patient_id) ) ;
        } else if (!((checkNull(patient_class)).equals(""))) {
           pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2_PAT_CLASS") ) ;
		   pdmt.setString( 1,language_id);
		   pdmt.setString( 2,language_id);
		   pdmt.setString( 3,language_id);
		   pdmt.setString( 4,language_id);
		   pdmt.setString( 5,language_id);
		   pdmt.setString( 6,language_id);
	       pdmt.setString( 7,checkNull(patient_class) ) ;
	       //System.out.println("patient_class="+checkNull(patient_class));
        } else if ((checkNull(Patient_id)).equals("")) {
		pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2_NO_PAT_ID") ) ;
		  pdmt.setString( 1,language_id);
		  pdmt.setString( 2,language_id);
		  pdmt.setString( 3,language_id);
		  pdmt.setString( 4,language_id);
		  pdmt.setString( 5,language_id);
		  pdmt.setString( 6,language_id);
		 // pdmt.setString( 7,login_facility_id ) ;
		 // pdmt.setString( 8,login_facility_id ) ;
		  pdmt.setString( 7, login_pract_id) ;
		  pdmt.setString( 8, login_pract_id) ;
		}

        /*else if ((!((checkNull(Patient_id)).equals(""))) && (!((checkNull(encounter_id)).equals(""))) ){
	       pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2_ENCNTR_ID") ) ;
	       pdmt.setString( 1,checkNull(Patient_id) ) ;
	       pdmt.setString(2,checkNull(encounter_id));
	       System.out.println("patient_id="+checkNull(Patient_id)+",encounter_id="+encounter_id);

	    } else {
    	   pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2") ) ;
	       pdmt.setString( 1,checkNull(Patient_id) ) ;
        }*/
			resultSet = pdmt.executeQuery() ;

	ArrayList ResultOrderCat	= null;
	while(resultSet.next() ) {
				ResultOrderCat	= new ArrayList() ;
				
				ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "PRIORITY_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "SOURCE_TYPE" ))  ;
				ResultOrderCat.add(resultSet.getString( "SOURCE_CODE" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDERING_PRACT_NAME" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORD_PRACT_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_STATUS" ))  ;
				ResultOrderCat.add(resultSet.getString( "LOCATION_DETAILS" ))  ;
				ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "PATIENT_CLASS_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_DATE_TIME"));
				ResultOrderCat.add(resultSet.getString( "ORDER_DETAIL"));
				ResultOrderCat.add(resultSet.getString( "ORDER_STATUS_SHORT_DESC"));
		        ResultOrderCat.add(resultSet.getString( "PATIENT_DETAILS"));
		        ResultOrderCat.add(resultSet.getString("CATALOG_CODE"));
				ResultOrderCat.add((resultSet.getString("start_date_time")== null)? "" : resultSet.getString( "start_date_time"));
				ResultOrderCat.add((resultSet.getString( "end_date_time") == null)? "" : resultSet.getString( "end_date_time"));
				ResultOrderCat.add(resultSet.getString( "SEX"));
				ResultOrderCat.add((resultSet.getString( "result_hyperlink_yn")== null)? "" : resultSet.getString( "result_hyperlink_yn"));
				ResultOrderCat.add(resultSet.getString( "cont_order_ind"));
		ResultOrderCatFinal.add(ResultOrderCat);
		
  }
}catch( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
}
finally {
		closeResultSet(resultSet) ;
		closeStatement(pdmt) ;
		closeConnection(connection) ;
}

	return ResultOrderCatFinal;
}
//public ArrayList getModalRenewResultDetails(String Patient_id,String login_pract_id,String order_id,String order_line_num) throws Exception {
	public ArrayList getModalRenewResultDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pdmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ResultOrderCatFinal	= new ArrayList() ;

	try {
		connection = getConnection() ;
		/*if ((checkNull(Patient_id)).equals("")) {
		  pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2_NO_PAT_ID") ) ;
		  pdmt.setString( 1,login_facility_id ) ;
		  pdmt.setString( 2,login_facility_id ) ;
		  pdmt.setString( 3, login_pract_id) ;
		} else*/ {
	       pdmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_LINE_LEVEL2_RENEW") ) ;
			pdmt.setString(1,language_id);
			pdmt.setString(2,language_id);
			pdmt.setString(3,language_id);
			pdmt.setString(4,language_id);
			pdmt.setString(5,language_id);
			pdmt.setString(6,language_id);
	        pdmt.setString(7,checkNull(order_id) ) ;
	    }

		resultSet = pdmt.executeQuery() ;

		while(resultSet.next() ) {

				ArrayList ResultOrderCat	= new ArrayList() ;
				ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_CATEGORY_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_CODE" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_TYPE_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "PRIORITY_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "SOURCE_TYPE" ))  ;
				ResultOrderCat.add(resultSet.getString( "SOURCE_CODE" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDERING_PRACT_NAME" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORD_PRACT_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_STATUS" ))  ;
				ResultOrderCat.add(resultSet.getString( "LOCATION_DETAILS" ))  ;
				ResultOrderCat.add(resultSet.getString( "PATIENT_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "PATIENT_CLASS_SHORT_DESC" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_ID" ))  ;
				ResultOrderCat.add(resultSet.getString( "ORDER_DATE_TIME"));
				ResultOrderCat.add(resultSet.getString( "ORDER_DETAIL"));
				ResultOrderCat.add(resultSet.getString( "ORDER_STATUS_SHORT_DESC"));
		        ResultOrderCat.add(resultSet.getString( "PATIENT_DETAILS"));
				ResultOrderCat.add((resultSet.getString("start_date_time")== null)? "" : resultSet.getString( "start_date_time"));
				ResultOrderCat.add((resultSet.getString( "end_date_time") == null)? "" : resultSet.getString( "end_date_time"));
				ResultOrderCat.add(resultSet.getString( "SEX"));
				ResultOrderCat.add((resultSet.getString( "result_hyperlink_yn")== null)? "" : resultSet.getString( "result_hyperlink_yn"));
				ResultOrderCat.add(resultSet.getString( "cont_order_ind"));
		ResultOrderCatFinal.add(ResultOrderCat);
  }
}catch( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pdmt) ;
			closeConnection(connection) ;
		}

		return ResultOrderCatFinal;
}

public String callRenewOrders(String order_id,String order_type_code) throws Exception {
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		PreparedStatement pstmt	 	= null;
		ResultSet resultSet 		= null;
	//	boolean flag = false;
		String error = "";
		String perform_yn = "";
	try {
		connection = getConnection() ;
		order_type_code = checkForNull(order_type_code);
		if (order_type_code.equals(""))
		{
			pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_CODE")) ;
			pstmt.setString(1, order_id);
			resultSet	= pstmt.executeQuery() ;
			while(resultSet != null && resultSet.next()) {
			  perform_yn = checkForNull(resultSet.getString( "order_type_code" ),"") ;  
			}	

			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
		}
		pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_STATUS_CHK")) ;
		pstmt.setString(1, "RENEW");
		pstmt.setString(2, order_id);
		pstmt.setString(3, order_type_code);

		resultSet	= pstmt.executeQuery() ;
			
		while(resultSet != null && resultSet.next()) {
			perform_yn = checkForNull(resultSet.getString( "perform_yn" ),"") ;  
		}
		if(perform_yn.equals("Y")){
			cstmt = connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_CALL_RENEW") +" }");
			cstmt.setString(1,checkNull(order_id));
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.execute();
			//flag = cstmt.execute();
			error = cstmt.getString(2);
			if (error == null) {
			error = "";
			}
		}else
			error = "APP-OR0271 Cannot Perform this Opeartion. Since Order Status has been Changed by Some Other User";

    }catch( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
	} finally {
		closeResultSet(resultSet) ;
		closeStatement(pstmt) ;
		closeStatement(cstmt);
        closeConnection(connection) ;
	}
	return error;
}

/*

public String getRadiology(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
	    String rd_install_yn		= "N";
 		try {
			connection = getConnection() ;

			 pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
             pstmt.setString(1,"RD");
             pstmt.setString(2,facility_id);
             resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    rd_install_yn = resultSet.getString("operational_yn");
                }
                if (rd_install_yn == null) rd_install_yn = "";
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return rd_install_yn;
	}

	public String getOTModule(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
	    String ot_install_yn		= "N";
 		try {
			connection = getConnection() ;

			 pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
             pstmt.setString(1,"OT");
             pstmt.setString(2,facility_id);
             resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    ot_install_yn = resultSet.getString("operational_yn");
                }
                if (ot_install_yn == null) ot_install_yn = "N";
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return ot_install_yn;
	}


	*/ 
	
	public ArrayList  getPatientClass() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList PatientClass = new ArrayList();  

		try {

			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PATIENT_CLASS_LIST") ) ;
			pstmt.setString( 1, language_id);

			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "patient_class" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

				PatientClass.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}

		return PatientClass;
	}
	public ArrayList  getOrderCat(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList order_category = new ArrayList();  

		try {

			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_OA_ORDER_CATEGORY") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,facility_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

				order_category.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}

		return order_category;
	}
	public ArrayList  getPerformingLocation(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList perfm_location = new ArrayList();  

		try {

			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_OA_TRANSFER_PERFORMING_LOC") ) ;
			pstmt.setString(1,facility_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "performing_location" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

				perfm_location.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}

		return perfm_location;
	}
/*public ArrayList getOrderApptDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ApptDetails		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_APPT_DETAILS") ) ;
			pstmt.setString( 1, order_id ) ;
			pstmt.setString( 2, "1" ) ; // Always only one record will be there if appt is there
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "appt_ref_num" )  ;
				record[1] = resultSet.getString( "appt_date_time" )  ;

				ApptDetails.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return ApptDetails;
	}
*/

public ArrayList getSearchDetails(String order_category,String order_type,String activity_type,String order_catalog_code,String performing_locn ,String priority,String patient_id,String patient_class,String period_from,String period_to,String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList results = new ArrayList() ;

		try {
			connection = getConnection() ;

			 if (period_from.equals(" ") || period_from.equals("null")) period_from="";
		if (period_to.equals(" ") || period_to.equals("null")) period_to="";
		if ( !language_id.equals("en") )
{ 
			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
}
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_APPOINTMENT_PENDING_ORDERS")) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, facility_id ) ;
			pstmt.setString( 3, order_category ) ;
			pstmt.setString( 4, order_type ) ;
			pstmt.setString( 5, activity_type ) ;
			pstmt.setString( 6, order_catalog_code ) ;
			pstmt.setString( 7, performing_locn ) ;
			pstmt.setString( 8, priority ) ;
			pstmt.setString( 9, patient_id ) ;
 			pstmt.setString( 10, patient_class ) ;
			pstmt.setString( 11, period_from ) ;
			pstmt.setString( 12, period_to ) ;
			pstmt.setString( 13, facility_id ) ;
			pstmt.setString( 14, facility_id ) ;

			resultSet=pstmt.executeQuery();

			String[] record = null;
			 while( resultSet != null && resultSet.next() ) 
			 {
					 	record = new String[25];
				
						record[0] = checkForNull(resultSet.getString( "patient_details" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "order_category" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "priority_desc" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "patient_class_short_desc" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "order_id" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "catalog_code" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "source_code" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "priority" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[16] = checkForNull(resultSet.getString( "order_type_short_desc" ),"");
						record[17] = checkForNull(resultSet.getString( "ord_pract_id" ) ,"") ;
						record[18] = checkForNull(resultSet.getString( "ordering_pract_name" ) ,"") ;
						record[19] = checkForNull(resultSet.getString( "order_status" ),"");
						record[20] = checkForNull(resultSet.getString( "order_line_num"),"");
						record[21] = checkForNull(resultSet.getString( "start_date_time"),"");
						record[22] = checkForNull(resultSet.getString( "end_date_time"),"");
						record[23] = checkForNull(resultSet.getString( "wait_time_indicator"),"");
						record[24] = checkForNull(resultSet.getString( "sex"),"");
					   

						results.add(record) ;
			 }
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return results;
	}

}//end of class
