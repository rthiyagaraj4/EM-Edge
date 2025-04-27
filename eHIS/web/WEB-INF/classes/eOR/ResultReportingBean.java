/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Description
-------------------------------------------------------------------------------------------------------
12/05/2016	  IN060299		Krishna Gowtham		12.X-ALPHA-CIS-OR-System allows to do result reporting though responsibility doesn't have access.
19/11/2019    IN071798		Nijitha S			AMRI-SCF-0603
16/08/2021	19112			Ramesh												NMC-JD-CRF-0106
28/08/2023   48622         SRINIVASA N T
------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;

import eOR.ORRegisterOrder.*;
import webbeans.eCommon.MessageManager;
//import eOR.ORAuthoriseOrder.*;

public class ResultReportingBean extends eOR.Common.OrAdapter implements java.io.Serializable
{

/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
	protected Hashtable allValues 				= new Hashtable();
	protected String total_records 				= "";
	protected String order_category 			= "";
	protected String order_type_code 			= "";
	protected String priority 					= "";
	protected String location_type				= "";
	protected String locn 						= "";
	protected String source_type				= "";
	protected String source_code				= "";
	protected String patient_id					= "";
	protected String patient_class				= "";
	protected String encntr_id 					= "";
	protected String order_id 					= "";
	protected String order_line_num				= "";
	protected String date_from 					= "";
	protected String date_to 					= "";
	protected String view_by					= "";
	protected String order_catalog_code			= "";
	protected String order_catalog_desc			= "";
	protected String performing_facility		= "";
	protected String performing_location		= "";
	protected String performing_location_type	= "";
	protected String function_from				= "";
	protected String ref_facility_id			= "";
	protected String ref_date_time				= "";
	protected String ref_sent_pract_id			= "";
	protected String ref_sent_remarks			= "";
	protected String ref_report_pract_id		= "";
	protected String ref_report_date_time		= "";
	protected String ref_recieved_date_time		= "";
	protected String ref_recieved_pract_id		= "";
	protected String ref_recieved_remarks		= "";
	protected String ref_form_content			= "";
	protected String ref_form_id				= "";
	public boolean choose=true;
	//protected ArrayList persistence_details		= new ArrayList();

	//StringBuffer traceVals = new StringBuffer();
	//public String chk = "";

	public void setMode(String mode){								this.mode = mode;	}
	public void setTotalRecs(String total_records){				this.total_records = total_records;	}
	public void setOrderCategory(String order_category){		this.order_category = order_category;	}
	public void setOrderType(String order_type_code){		this.order_type_code = order_type_code;	}
	public void setPriority(String priority){							this.priority= priority;	}
	public void setLocationType(String location_type){		this.location_type= location_type;	}
	public void setLocation(String locn){							this.locn = locn;	}
	public void setSourceType(String source_type){		this.source_type= source_type;	}
	public void setSourceCode(String source_code){		this.source_code= source_code;	}
	public void setPatientId(String patient_id){					this.patient_id = patient_id;	}
	public void setPatientClass(String patient_class){					this.patient_class = patient_class;	}
	public void setEncntrId(String encntr_id){					this.encntr_id = encntr_id;	}
	public void setOrderId(String order_id){						this.order_id= order_id;	}
	public void setOrderLineNum(String ord_line_num){						this.order_line_num= ord_line_num;	}
	public void setDateFrom(String date_from){					this.date_from= date_from;	}
	public void setDateTo(String date_to){						this.date_to= date_to;	}
	public void setViewBy(String view_by){						this.view_by= view_by;	}
	public void setOrderCatalogCode(String order_catalog_code) { this.order_catalog_code = order_catalog_code;}
	public void setOrderCatalogDesc(String order_catalog_desc) { this.order_catalog_desc = order_catalog_desc;}
	public void setPerformingFacility(String performing_facility) { this.performing_facility = performing_facility;}
	public void setPerformingLocation(String performing_location) { this.performing_location = performing_location;}
	public void setPerformingLocationType(String performing_location_type) { this.performing_location_type = performing_location_type;}
	public void setFunctionFrom(String function_from) { this.function_from = function_from;}
	public void setRefFacilityId(String ref_facility_id) { this.ref_facility_id = ref_facility_id;}
	public void setRefDateTime(String ref_date_time) { this.ref_date_time = ref_date_time;}
	public void setRefSentPractId(String ref_sent_pract_id) { this.ref_sent_pract_id = ref_sent_pract_id;}
	public void setRefSentRemarks(String ref_sent_remarks) { this.ref_sent_remarks = ref_sent_remarks;}
	public void setRefReportPractId(String ref_report_pract_id) { this.ref_report_pract_id = ref_report_pract_id;}
	public void setRefReportDateTime(String ref_report_date_time) { this.ref_report_date_time = ref_report_date_time;}
	public void setRefRecievedDateTime(String ref_recieved_date_time) {	this.ref_recieved_date_time = ref_recieved_date_time;}
	public void setRefRecievedPractId(String ref_recieved_pract_id) {this.ref_recieved_pract_id = ref_recieved_pract_id;}
	public void setRefRecievedRemarks(String ref_recieved_remarks) {this.ref_recieved_remarks = ref_recieved_remarks;}
	public void setRefFormContent(String content){	this.ref_form_content = content;}
	public void setRefFormId(String ref_form_id){	this.ref_form_id = ref_form_id;}
/*	public void setDetails(ArrayList persistence_details){
			this.persistence_details=persistence_details;
	}
*/
	public String getMode()
	{						
		return mode;	
	}
	public String getTotalRecs()
	{					
		return total_records;
	}
	public String getOrderCategory()
	{				
		return order_category;	
	}
	public String getOrderType()
	{					
		return order_type_code;	
	}
	public String getPriority()
	{					
		return priority;
	}
	public String getLocationType()
	{				
		return location_type;	
	}
	public String getLocation()
	{					
		return locn;	
	}
	public String getSourceType()
	{					
		return source_type;	
	}
	public String getSourceCode()
	{					
		return source_code;	
	}
	public String getPatientId()
	{					
		return patient_id;	
	}
	public String getPatientClass()
	{				
		return patient_class;	
	}
	public String getEncntrId()
	{					
		return encntr_id;	
	}
	public String getOrderId()
	{						
		return order_id;	
	}
	public String getOrderLineNum()
	{				
		return order_line_num;	
	}
	public String getDateFrom()
	{					
		return date_from;	
	}
	public String getDateTo()
	{						
		return date_to;	
	}
	public String getViewBy()
	{						
		return view_by;
	}
	public String getOrderCatalogCode() 
	{			
		return order_catalog_code; 
	}
	public String getOrderCatalogDesc() 
	{			
		return order_catalog_desc; 
	}
	public String getPerformingFacility() 
	{			
		return performing_facility;
	}
	public String getPerformingLocation() 
	{			
		return performing_location;
	}
	public String getPerformingLocationType() 
	{		
		return performing_location_type;
	}
	public String getFunctionFrom() 
	{				
		return function_from;
	}
	public String getRefFacilityId() 
	{				
		return ref_facility_id;
	}
	public String getRefDateTime() 
	{				
		return ref_date_time;
	}
	public String getRefSentPractId() 
	{				
		return ref_sent_pract_id;
	}
	public String getRefSentRemarks() 
	{				
		return ref_sent_remarks;
	}
	public String getRefReportPractId() 
	{			
		return ref_report_pract_id;
	}
	public String getRefReportDateTime() 
	{			
		return ref_report_date_time;
	}
	public String getRefRecievedDateTime() 
	{		
		return ref_recieved_date_time;
	}
	public String getRefRecievedPractId() 
	{			
		return ref_recieved_pract_id;
	}
	public String getRefRecievedRemarks() 
	{	return ref_recieved_remarks;
	}
	public String getRefFormContent()	
	{	return this.ref_form_content;
	}
	public String getRefFormId()	
	{			
		return this.ref_form_id;
	}

	public Hashtable getAllValues() 
	{
		return allValues;
	}
/*	public ArrayList getDetails(){		return persistence_details;	} */
	public void clear() 
	{
			clearBean();	
			super.clear();
			ref_form_content=null;
		//	persistence_details = null;
	}

	public void clearBean()
	{
		order_id="";
		order_line_num="";
		patient_id="";
		order_catalog_code="";
		order_catalog_desc="";
		patient_class="";
		order_type_code="";
		priority="";
		performing_location_type="";
		performing_location="";
		ref_form_id="";
	//	persistence_details = null;
	}

	public void setAll( Hashtable recordSet ) 
	{
		allValues = recordSet;

		if(recordSet.containsKey("order_category")){setOrderCategory((String)recordSet.get("order_category"));}
		if(recordSet.containsKey("total_recs")){		setTotalRecs((String)recordSet.get("total_recs"));	}
		if(recordSet.containsKey("order_type_code")){		setOrderType((String)recordSet.get("order_type_code"));	}
		if(recordSet.containsKey("priority")){			setPriority((String)recordSet.get("priority"));}
		if(recordSet.containsKey("location_type")){ 	setLocationType((String)recordSet.get("location_type"));}
		if(recordSet.containsKey("locn")){				setLocation((String)recordSet.get("locn"));	}
		if(recordSet.containsKey("source_type")){		setSourceType((String)recordSet.get("source_type"));	}
		if(recordSet.containsKey("source_code")){		setSourceCode((String)recordSet.get("source_code"));	}
		if(recordSet.containsKey("patient_id")){		setPatientId((String)recordSet.get("patient_id"));}
		if(recordSet.containsKey("patient_class")){		setPatientClass((String)recordSet.get("patient_class"));}
		if(recordSet.containsKey("encntr_id")){  		setEncntrId((String)recordSet.get("encntr_id"));}
		if(recordSet.containsKey("order_no")){		setOrderId((String)recordSet.get("order_no"));	}
		if(recordSet.containsKey("order_line_num")){		setOrderLineNum((String)recordSet.get("order_line_num"));	}
		if(recordSet.containsKey("date_from")){
		if (!language_id.equals("en")){
		if (date_from.equals(" ") || date_from.equals("null") || date_from==null) date_from="";
		date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
		recordSet.put("date_from",date_from);
		}
		setDateFrom((String)recordSet.get("date_from"));
		}

		if(recordSet.containsKey("date_to")){
		if (!language_id.equals("en")){
		if (date_to.equals(" ") || date_to.equals("null") || date_to==null) date_to="";
		date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
		recordSet.put("date_to",date_to);
		}
		setDateTo((String)recordSet.get("date_to"));
		}
		if(recordSet.containsKey("view_by")){			setViewBy((String)recordSet.get("view_by"));}
		if(recordSet.containsKey("order_catalog_code")){			setOrderCatalogCode((String)recordSet.get("order_catalog_code"));}
		if(recordSet.containsKey("order_catalog_desc")){			setOrderCatalogDesc((String)recordSet.get("order_catalog_desc"));}
		if(recordSet.containsKey("performing_facility")){			setPerformingFacility((String)recordSet.get("performing_facility"));}
		if(recordSet.containsKey("performing_location")){			setPerformingLocation((String)recordSet.get("performing_location"));}
		if(recordSet.containsKey("performing_location_type")){			setPerformingLocationType((String)recordSet.get("performing_location_type"));}

		if(recordSet.containsKey("function_from")){			setFunctionFrom((String)recordSet.get("function_from"));}

		if(recordSet.containsKey("ref_facility_id")){			setRefFacilityId((String)recordSet.get("ref_facility_id"));}
		if(recordSet.containsKey("ref_date_time")){	
		if (!language_id.equals("en")){
		if (ref_date_time.equals(" ") || ref_date_time.equals("null") || ref_date_time==null) ref_date_time="";
		ref_date_time = com.ehis.util.DateUtils.convertDate(ref_date_time,"DMYHM",language_id,"en");
		recordSet.put("ref_date_time",ref_date_time);
		}
		setRefDateTime((String)recordSet.get("ref_date_time"));
		}
		if(recordSet.containsKey("ref_sent_pract_id")){			setRefSentPractId ((String)recordSet.get("ref_sent_pract_id"));}
		if(recordSet.containsKey("ref_sent_remarks")){			setRefSentRemarks((String)recordSet.get("ref_sent_remarks"));}
		if(recordSet.containsKey("ref_report_pract_id")){		setRefReportPractId((String)recordSet.get("ref_report_pract_id"));}
		if(recordSet.containsKey("ref_report_date_time")){
		if (!language_id.equals("en")){
		if (ref_report_date_time.equals(" ") || ref_report_date_time.equals("null") || ref_report_date_time==null) ref_report_date_time="";
		ref_report_date_time = com.ehis.util.DateUtils.convertDate(ref_report_date_time,"DMYHM",language_id,"en");
		recordSet.put("ref_report_date_time",ref_report_date_time);
		}
		setRefReportDateTime((String)recordSet.get("ref_report_date_time"));
		}

		if(recordSet.containsKey("ref_recieved_date_time")){
		if (!language_id.equals("en")){
		if (ref_recieved_date_time.equals(" ") || ref_recieved_date_time.equals("null") || ref_recieved_date_time==null) ref_recieved_date_time="";
		ref_recieved_date_time = com.ehis.util.DateUtils.convertDate(ref_recieved_date_time,"DMYHM",language_id,"en");
		recordSet.put("ref_recieved_date_time",ref_recieved_date_time);
		}
		setRefRecievedDateTime((String)recordSet.get("ref_recieved_date_time"));
		}
		if(recordSet.containsKey("ref_recieved_pract_id")){		setRefRecievedPractId((String)recordSet.get("ref_recieved_pract_id"));}
		if(recordSet.containsKey("ref_recieved_remarks")){			setRefRecievedRemarks((String)recordSet.get("ref_recieved_remarks"));}
		if(recordSet.containsKey("ref_form_content")){			setRefFormContent((String)recordSet.get("ref_form_content"));}
		if(recordSet.containsKey("ref_form_id")){			setRefFormId((String)recordSet.get("ref_form_id"));}

		this.mode = (String)recordSet.get( "mode" );
	}


	public String  isAuthorised(String practitioner_id, String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String isValid = null;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_CHK_VALID_USER") ) ;
			pstmt.setString( 1, practitioner_id.trim() ) ;
			pstmt.setString( 2, resp_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				isValid = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return isValid;
	}

/**
	This will populate the order category
	@return		:	ArrayList
*/

	public String[]  getOrdercategory(String practitioner_id, String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet1 			= null;
		String[] order_cat = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_CAT") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, practitioner_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			boolean recordsFound = false;
			if ( resultSet != null && resultSet.next() ) {
				order_cat[0] = resultSet.getString(1)  ;
				order_cat[1] = resultSet.getString(2)  ;
				recordsFound = true;
			}
			if(!recordsFound)
			{
				pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_CAT1") ) ;
				pstmt1.setString( 1, language_id);
				pstmt1.setString( 2, resp_id.trim() ) ;

				resultSet1 = pstmt1.executeQuery() ;

				if ( resultSet1 != null && resultSet1.next() ) {
					order_cat[0] = resultSet1.getString(1)  ;
					order_cat[1] = resultSet1.getString(2)  ;
				}
				else{
					order_cat[0] = ""  ;
					order_cat[1] = ""  ;
				}
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt1 ) ;
			closeConnection(connection) ;
		}

		return order_cat;
	}

    public ArrayList  getOrderCategory(String practitioner_id, String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet1 		= null;
		//String[] order_cat 			= new String[2];
		ArrayList orderCategory		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_CAT") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, practitioner_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			boolean recordsFound = false;
			while ( resultSet != null && resultSet.next() ) {
				String[] order_cat 			= new String[2];
				order_cat[0] = resultSet.getString(1)  ;
				order_cat[1] = resultSet.getString(2)  ;
				orderCategory.add(order_cat);
				recordsFound = true;
				choose=true;
			}
			if(!recordsFound)
			{
				choose=false;
				pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_CAT1") ) ;
				pstmt1.setString( 1, language_id);
				pstmt1.setString( 2, resp_id.trim() ) ;

				resultSet1 = pstmt1.executeQuery() ;

				while ( resultSet1 != null && resultSet1.next() ) {
					String[] order_cat 			= new String[2];
					order_cat[0] = resultSet1.getString(1)  ;
					order_cat[1] = resultSet1.getString(2)  ;
					orderCategory.add(order_cat);
					recordsFound = true;
				}
				if(!recordsFound){
					String[] order_cat 			= new String[2];
					order_cat[0] = ""  ;
					order_cat[1] = ""  ;
					orderCategory.add(order_cat);
				}
			}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt1 ) ;
			closeConnection(connection) ;
		}

		return orderCategory;
	}

/**
	This will populate the order category by preactiotioner ID
	@return		:	ArrayList
*/

	public ArrayList  getOrderType(String ord_cat, String practitioner_id, String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet1 			= null;
		ArrayList OrderCat = new ArrayList();

		try {
			connection = getConnection() ;
			if(choose)
			{
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_TYPE") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, ord_cat.trim() ) ;
			pstmt.setString( 3, practitioner_id.trim() ) ;
			pstmt.setString( 4, language_id);
			pstmt.setString( 5, ord_cat.trim() ) ;
			pstmt.setString( 6, practitioner_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			if (resultSet != null)
			{
				while( resultSet != null && resultSet.next() )
				{
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_type_code" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

					OrderCat.add(record) ;
					
				}
			}
			}else
			{
				pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_TYPE1") ) ;
				pstmt1.setString( 1, language_id);
				pstmt1.setString( 2, ord_cat.trim() ) ;
				pstmt1.setString( 3, resp_id.trim() ) ;
				pstmt1.setString( 4, language_id);
				pstmt1.setString( 5, ord_cat.trim() ) ;
				pstmt1.setString( 6, resp_id.trim() ) ;

				resultSet1 = pstmt1.executeQuery() ;

				while( resultSet1 != null && resultSet1.next() ) {
					String[] record = new String[2];
					record[0] = resultSet1.getString( "order_type_code" )  ;
					record[1] = resultSet1.getString( "short_desc" )  ;

					OrderCat.add(record) ;
				}
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt1 ) ;
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
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_category.trim() ) ;
			pstmt.setString( 3, order_type.trim() ) ;
			//pstmt.setString( 4, language_id);
			//pstmt.setString( 5, order_category.trim() ) ;
			

			resultSet = pstmt.executeQuery() ;
			while(resultSet.next())
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "activity_type" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				ActivityType.add(record) ;
				
			}
						
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return ActivityType;
	}

/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList getLocation(String facility_id, String practitioner_id, String location_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, practitioner_id.trim() ) ;
			pstmt.setString( 4, location_type.trim() ) ;
			pstmt.setString( 5, facility_id.trim() ) ;
			pstmt.setString( 6, language_id);
			pstmt.setString( 7, location_type.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "locn_short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

    public ArrayList getSourceLocation(String location_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Location = new ArrayList() ;
		try {
			location_type = (location_type == null) ? "" : location_type;
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN") ) ;
		//	pstmt.setString( 1, facility_id.trim() ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, language_id);
			pstmt.setString( 4, language_id);
			pstmt.setString( 5, location_type.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "location_desc" )  ;

				Location.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return Location;
	}


/**

	@return		:	String
*/

	public String  isModuleInstalled(String facility_id, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String install_yn = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;

			pstmt.setString(1, order_category.trim());
			pstmt.setString(2, facility_id.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				install_yn = resultSet.getString(1)  ;
			}else{
				install_yn  = "N";
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return install_yn;
	}


/**
	This will query on the basis of the paramters passed.
	@return		:	ArrayList
*/
	public ArrayList getSearchDetails(HashMap Parameters) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList results = new ArrayList();
		//StringBuffer traceVal = new StringBuffer(); //Checkstyle
		StringBuffer ADDL_COND = new StringBuffer(); //Added by Prasad on 11/05/2007
		StringBuffer EXTERAL = new StringBuffer(); //Added by Prasad on 2/01/2008
		ADDL_COND.append("");
		EXTERAL.append("");
 		//int total_records			= 0;

		try 
		{
			connection = getConnection() ;
			//String practitioner_type			= (String)Parameters.get("practitioner_type");
			String practitioner_id 				= checkForNull((String)Parameters.get("practitioner_id"));
			String resp_id						= checkForNull((String)Parameters.get("responsibility_id"));
			//String order_category				= checkForNull((String)Parameters.get("order_category")); //Checkstyle
			String view_by          			= checkForNull((String)Parameters.get("view_by"),"");
			String source_type      			= checkForNull((String)Parameters.get("source_type"),"");
			String source_location  			= checkForNull((String)Parameters.get("source_location"),"");
			String catalog_desc     			= checkForNull((String)Parameters.get("catalog_desc"),"");
			String search_criteria  			= checkForNull((String)Parameters.get("search_criteria"),"");
			String group_by         			= checkForNull((String)Parameters.get("group_by"),"");
			//String from_ca 					= checkForNull((String)Parameters.get("from_ca"),"");
			String task_status					= checkForNull((String)Parameters.get("task_status"),"");
			//String taskCode					= checkForNull((String)Parameters.get("taskCode"),"");
			String specimen_no		 			= checkForNull((String)Parameters.get("specimen_no"),"");
			String accession_num		 		= checkForNull((String)Parameters.get("specimen_no"),"");
			String performing_location_code		= checkForNull((String)Parameters.get("performing_location_code"),"");
			String order_id		 				= checkForNull((String)Parameters.get("order_id"),"");
			String performed_only				= checkForNull((String)Parameters.get("performed_only"));
			String start_value		 			= checkForNull((String)Parameters.get("start"),"0");
			String end_value		 			= checkForNull((String)Parameters.get("end"),"0");
			String by_24hrs_yn		 			= checkForNull((String)Parameters.get("by_24hrs_yn"),"N");
			String period_mod_rslt_completed	= checkForNull((String)Parameters.get("period_mod_rslt_completed"),"0");
			String pract_reln_id	= checkForNull((String)Parameters.get("pract_reln_id"),"");
			String task_code					= "";

			int start							= Integer.parseInt(start_value);
			int end								= Integer.parseInt(end_value);
			
			String PerformingLocnYN = "N";
			String sql="";
						
			
			/*if (!practitioner_id.equals("")) {
                PerformingLocnYN = isPerformingLocnYN("",practitioner_id,order_category);
            }
			if (PerformingLocnYN.equals("N") && !(resp_id.equals(""))) {
                PerformingLocnYN = isPerformingLocnYN(resp_id,"",order_category);
            }*/
			 //PerformingLocnYN = isPerformingLocnYN(resp_id,practitioner_id,order_category);
			 
			 if(performing_location_code!="")
				PerformingLocnYN="Y";
			
			//if(practitioner_type.equals("NS"))
			//	pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_SEARCH_DTL2") ) ;
			//else

			/* Thai date validations start 16/02/2007*/
			if (!language_id.equals("en")){
			String date_from          	= checkForNull((String)Parameters.get("date_from"),"");
			String date_to      	= checkForNull((String)Parameters.get("date_to"),"");
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");			
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
			Parameters.put("date_from",date_from);
			Parameters.put("date_to",date_to);
			}
			/* Thai date validations end 16/02/2007*/	
			
			//Changes start from here
			//IN060299 Start
			/*if (!performed_only.equals("Y"))
			{
				//sql=OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_SEARCH_DTL1");//IN31901
				sql = "SELECT a.order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code,or_get_desc.or_order_type (a.order_type_code,?,'2') order_type_short_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class, A.order_id order_id,b.order_line_num order_line_num,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,TO_CHAR (a.ord_date_time, 'dd/mm/yyyy') grp_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?,b.order_line_num) order_detail,DECODE (?, 'en', C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) PATIENT_NAME,a.source_type source_type, a.source_code source_code, a.priority priority,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,b.order_line_status order_status,or_get_desc.or_order_status_code(b.order_line_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,C.sex sex ,B.Result_applicable_yn result_applicable_yn,B.complete_remarks complete_remarks,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'dd/mm/yyyy') dob,B.complete_date_time complete_date_time,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext  FROM or_performing_deptloc WHERE performing_facility_id = a.performing_facility_id AND performing_deptloc_type = a.performing_deptloc_type AND performing_deptloc_code = a.performing_deptloc_code) int_or_ext,'N' image_ref_yn,NVL (B.notify_yn,'N') notify_yn,OR_GET_RESULT_REP_OPERN(A.ORDERING_FACILITY_ID,A.ORDER_ID,A.ORDER_CATEGORY,A.ORDER_TYPE_CODE,A.CONT_ORDER_IND,A.ORDER_STATUS,b.REF_SENT_PRACT_ID,b.REF_RECIEVED_DATE_TIME,A.PERFORMING_FACILITY_ID,A.PERFORMING_DEPTLOC_TYPE,A.PERFORMING_DEPTLOC_CODE,B.Result_applicable_yn,b.order_catalog_code,b.order_line_num,b.order_line_status,null,?,?,?) Result_options, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id order_set_id,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num FROM or_order a, or_order_line b, mp_patient c WHERE b.order_id=a.order_id  AND  c.patient_id=a.patient_id AND a.resume_order_on_gen IS NULL AND a.patient_id = NVL (?, a.patient_id) AND NVL (a.encounter_id, 0) = NVL (?, NVL (a.encounter_id, 0)) AND a.order_id = NVL (?, a.order_id) AND b.start_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'),'dd/mm/yyyy') AND   LEAST(TO_DATE (NVL ((?),'31/12/9998'),'dd/mm/yyyy'),SYSDATE)+ .9999 AND a.priority = NVL (?, a.priority) AND a.order_category IN (SELECT order_category FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?) AND a.order_category = NVL (?, a.order_category)) AND a.order_type_code = NVL (?, a.order_type_code) AND a.performing_facility_id = (?) AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND NVL (a.performing_deptloc_code, 'XXX') =  NVL (?, NVL (a.performing_deptloc_code, 'XXX'))  AND NVL (a.source_type, 'X') = NVL (?, NVL (a.source_type, 'X'))  AND NVL (a.source_code, 'X') = NVL (?, NVL (a.source_code, 'X')) AND 'Y' =or_module_resulting (a.performing_facility_id,a.order_category,a.order_type_code) AND a.ord_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'), 'dd/mm/yyyy') AND   LEAST (TO_DATE (NVL ((?), '31/12/9998'), 'dd/mm/yyyy'),SYSDATE)+ .9999 AND NVL (activity_type, '!') = NVL (?, NVL (activity_type, '!'))  AND ORDER_LINE_STATUS in  (select order_status_code from or_order_status_code A, OR_STATUS_APPLICABILITY B  where B.OPER_OR_GROUP_REF =?  AND A.ORDER_STATUS_TYPE =B.ORDER_STATUS_type) AND SUBSTR (a.order_id, 1, 2) != 'CS'    and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and (B.Result_applicable_yn='Y' or  B.complete_date_time is null) ##REP_CAT$$ ##NOT_PER_LOC$$ #ADDL_COND# #EXTERAL#  ORDER BY DECODE ((?), 'D', TO_CHAR (a.ord_date_time, 'yyyymmdd'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.SOURCE_type||location_description,'P', a.patient_id,'U', a.priority)";//IN31901
			}else{
				//sql=OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_COMPLETED_SEARCH_DTL1");//IN31901
				sql = "SELECT a.order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code,or_get_desc.or_order_type (a.order_type_code,?,'2') order_type_short_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class, A.order_id order_id,b.order_line_num order_line_num,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,TO_CHAR (a.ord_date_time, 'dd/mm/yyyy') grp_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?,b.order_line_num) order_detail,DECODE (?, 'en', C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) PATIENT_NAME,a.source_type source_type, a.source_code source_code, a.priority priority,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,b.order_line_status order_status,or_get_desc.or_order_status_code(b.order_line_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,C.sex sex ,B.Result_applicable_yn result_applicable_yn,B.complete_remarks complete_remarks,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'dd/mm/yyyy') dob,B.complete_date_time complete_date_time,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext  FROM or_performing_deptloc WHERE performing_facility_id = a.performing_facility_id AND performing_deptloc_type = a.performing_deptloc_type AND performing_deptloc_code = a.performing_deptloc_code) int_or_ext,'N' image_ref_yn,NVL (B.notify_yn,'N') notify_yn,OR_GET_RESULT_REP_OPERN(A.ORDERING_FACILITY_ID,A.ORDER_ID,A.ORDER_CATEGORY,A.ORDER_TYPE_CODE,A.CONT_ORDER_IND,A.ORDER_STATUS,b.REF_SENT_PRACT_ID,b.REF_RECIEVED_DATE_TIME,A.PERFORMING_FACILITY_ID,A.PERFORMING_DEPTLOC_TYPE,A.PERFORMING_DEPTLOC_CODE,B.Result_applicable_yn,b.order_catalog_code,b.order_line_num,b.order_line_status,null,?,?,?) Result_options, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id order_set_id,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num FROM or_order a, or_order_line b, mp_patient c, or_result_detail d WHERE b.order_id=a.order_id AND d.ORDER_ID = b.ORDER_ID AND d.LINE_SRL_NO = b.ORDER_LINE_NUM AND order_line_status IN (select order_status_code from or_order_status_code A where a.order_status_type between '65' and '92' ) AND d.result_status='3' AND order_status IN (SELECT order_status_code FROM or_order_status_code a WHERE a.order_status_type BETWEEN '65' AND '92') AND  c.patient_id=a.patient_id AND a.resume_order_on_gen IS NULL AND a.patient_id = NVL (?, a.patient_id) AND NVL (a.encounter_id, 0) = NVL (?, NVL (a.encounter_id, 0)) AND a.order_id = NVL (?, a.order_id) AND b.start_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'),'dd/mm/yyyy') AND   LEAST(TO_DATE (NVL ((?),'31/12/9998'),'dd/mm/yyyy'),SYSDATE)+ .9999  AND a.priority = NVL (?, a.priority) AND a.order_category IN (SELECT order_category FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?) AND a.order_category = NVL (?, a.order_category)) AND a.order_type_code = NVL (?, a.order_type_code) AND a.performing_facility_id = (?) AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND NVL (a.performing_deptloc_code, 'XXX') =  NVL (?, NVL (a.performing_deptloc_code, 'XXX'))  AND NVL (a.source_type, 'X') = NVL (?, NVL (a.source_type, 'X'))  AND NVL (a.source_code, 'X') = NVL (?, NVL (a.source_code, 'X')) AND 'Y' =or_module_resulting (a.performing_facility_id,a.order_category,a.order_type_code)  AND a.ord_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'), 'dd/mm/yyyy') AND   LEAST (TO_DATE (NVL ((?), '31/12/9998'), 'dd/mm/yyyy'),SYSDATE)+ .9999 AND NVL (activity_type, '!') = NVL (?, NVL (activity_type, '!'))  AND SUBSTR (a.order_id, 1, 2) != 'CS'    and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and (B.Result_applicable_yn='Y' or  B.complete_date_time is null) AND SYSDATE <=DECODE (?,'Y',d.REPORTING_DATE+NVL(?,0) ,TRUNC(d.REPORTING_DATE+NVL(?,0))) ##REP_CAT$$ ##NOT_PER_LOC$$ #ADDL_COND# #EXTERAL# ORDER BY DECODE ((?), 'D', TO_CHAR (a.ord_date_time, 'yyyymmdd'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.SOURCE_type||location_description,'P', a.patient_id,'U', a.priority)";//IN31901
			}  												
			*/
			if (!performed_only.equals("Y")) 
			{
				//sql=OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_SEARCH_DTL1");//IN31901
				sql = "SELECT a.order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code,or_get_desc.or_order_type (a.order_type_code,?,'2') order_type_short_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class, A.order_id order_id,b.order_line_num order_line_num,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,TO_CHAR (a.ord_date_time, 'dd/mm/yyyy') grp_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?,b.order_line_num) order_detail,DECODE (?, 'en', C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) PATIENT_NAME,a.source_type source_type, a.source_code source_code, a.priority priority,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,b.order_line_status order_status,or_get_desc.or_order_status_code(b.order_line_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,C.sex sex ,B.Result_applicable_yn result_applicable_yn,B.complete_remarks complete_remarks,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'dd/mm/yyyy') dob,B.complete_date_time complete_date_time,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext  FROM or_performing_deptloc WHERE performing_facility_id = a.performing_facility_id AND performing_deptloc_type = a.performing_deptloc_type AND performing_deptloc_code = a.performing_deptloc_code) int_or_ext,'N' image_ref_yn,NVL (B.notify_yn,'N') notify_yn,OR_GET_RESULT_REP_OPERN(A.ORDERING_FACILITY_ID,A.ORDER_ID,A.ORDER_CATEGORY,A.ORDER_TYPE_CODE,A.CONT_ORDER_IND,A.ORDER_STATUS,b.REF_SENT_PRACT_ID,b.REF_RECIEVED_DATE_TIME,A.PERFORMING_FACILITY_ID,A.PERFORMING_DEPTLOC_TYPE,A.PERFORMING_DEPTLOC_CODE,B.Result_applicable_yn,b.order_catalog_code,b.order_line_num,b.order_line_status,null,?,?,?) Result_options, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id order_set_id,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,nvl(b.INSTRUCTION_TYPE,'T') INSTRUCTION_TYPE,b.billing_status FROM or_order a, or_order_line b, mp_patient c WHERE b.order_id=a.order_id /*AND b.order_line_num=1*/ AND  c.patient_id=a.patient_id AND a.resume_order_on_gen IS NULL AND a.patient_id = NVL (?, a.patient_id) AND NVL (a.encounter_id, 0) = NVL (?, NVL (a.encounter_id, 0)) AND a.order_id = NVL (?, a.order_id) AND b.start_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'),'dd/mm/yyyy') AND   LEAST(TO_DATE (NVL ((?),'31/12/9998'),'dd/mm/yyyy'),SYSDATE)+ .9999 AND a.priority = NVL (?, a.priority) AND ((a.order_category IN(SELECT order_category FROM or_result_user WHERE ((practitioner_id = ? OR resp_id = ?) AND order_type_code='*ALL')))OR(a.order_type_code IN (SELECT order_type_code FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?)))) AND a.order_category = NVL (?, a.order_category) AND a.order_type_code = NVL (?, a.order_type_code) AND a.performing_facility_id = (?) AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND NVL (a.performing_deptloc_code, 'XXX') =  NVL (?, NVL (a.performing_deptloc_code, 'XXX'))  AND NVL (a.source_type, 'X') = NVL (?, NVL (a.source_type, 'X'))  AND NVL (a.source_code, 'X') = NVL (?, NVL (a.source_code, 'X')) AND 'Y' =or_module_resulting (a.performing_facility_id,a.order_category,a.order_type_code) AND a.ord_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'), 'dd/mm/yyyy') AND   LEAST (TO_DATE (NVL ((?), '31/12/9998'), 'dd/mm/yyyy'),SYSDATE)+ .9999 AND NVL (activity_type, '!') = NVL (?, NVL (activity_type, '!'))  AND ORDER_LINE_STATUS in  (select order_status_code from or_order_status_code A, OR_STATUS_APPLICABILITY B  where B.OPER_OR_GROUP_REF =?  AND A.ORDER_STATUS_TYPE =B.ORDER_STATUS_type) AND SUBSTR (a.order_id, 1, 2) != 'CS'    and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and (B.Result_applicable_yn='Y' or  B.complete_date_time is null) ##REP_CAT$$ ##NOT_PER_LOC$$ #ADDL_COND# #EXTERAL#  ORDER BY DECODE ((?), 'D', TO_CHAR (a.ord_date_time, 'yyyymmdd'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.SOURCE_type||location_description,'P', a.patient_id,'U', a.priority)";
			}else{
				//sql=OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_COMPLETED_SEARCH_DTL1");//IN31901
				//sql = "SELECT a.order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code,or_get_desc.or_order_type (a.order_type_code,?,'2') order_type_short_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class, A.order_id order_id,b.order_line_num order_line_num,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,TO_CHAR (a.ord_date_time, 'dd/mm/yyyy') grp_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?,b.order_line_num) order_detail,DECODE (?, 'en', C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) PATIENT_NAME,a.source_type source_type, a.source_code source_code, a.priority priority,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,b.order_line_status order_status,or_get_desc.or_order_status_code(b.order_line_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,C.sex sex ,B.Result_applicable_yn result_applicable_yn,B.complete_remarks complete_remarks,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'dd/mm/yyyy') dob,B.complete_date_time complete_date_time,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext  FROM or_performing_deptloc WHERE performing_facility_id = a.performing_facility_id AND performing_deptloc_type = a.performing_deptloc_type AND performing_deptloc_code = a.performing_deptloc_code) int_or_ext,'N' image_ref_yn,NVL (B.notify_yn,'N') notify_yn,OR_GET_RESULT_REP_OPERN(A.ORDERING_FACILITY_ID,A.ORDER_ID,A.ORDER_CATEGORY,A.ORDER_TYPE_CODE,A.CONT_ORDER_IND,A.ORDER_STATUS,b.REF_SENT_PRACT_ID,b.REF_RECIEVED_DATE_TIME,A.PERFORMING_FACILITY_ID,A.PERFORMING_DEPTLOC_TYPE,A.PERFORMING_DEPTLOC_CODE,B.Result_applicable_yn,b.order_catalog_code,b.order_line_num,b.order_line_status,null,?,?,?) Result_options, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id order_set_id,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,nvl(b.INSTRUCTION_TYPE,'T') INSTRUCTION_TYPE FROM or_order a, or_order_line b, mp_patient c, or_result_detail d WHERE b.order_id=a.order_id AND d.ORDER_ID = b.ORDER_ID AND d.LINE_SRL_NO = b.ORDER_LINE_NUM AND order_line_status IN (select order_status_code from or_order_status_code A where a.order_status_type between '65' and '92' ) AND d.result_status='3' AND order_status IN (SELECT order_status_code FROM or_order_status_code a WHERE a.order_status_type BETWEEN '65' AND '92') AND  c.patient_id=a.patient_id AND a.resume_order_on_gen IS NULL AND a.patient_id = NVL (?, a.patient_id) AND NVL (a.encounter_id, 0) = NVL (?, NVL (a.encounter_id, 0)) AND a.order_id = NVL (?, a.order_id) AND b.start_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'),'dd/mm/yyyy') AND   LEAST(TO_DATE (NVL ((?),'31/12/9998'),'dd/mm/yyyy'),SYSDATE)+ .9999  AND a.priority = NVL (?, a.priority) AND((a.order_category IN(SELECT order_category FROM or_result_user WHERE ((practitioner_id = ? OR resp_id = ?) AND order_type_code='*ALL'))) OR( a.order_type_code IN (SELECT order_type_code FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?)))) AND a.order_category = NVL (?, a.order_category) AND a.order_type_code = NVL (?, a.order_type_code) AND a.performing_facility_id = (?) AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND NVL (a.performing_deptloc_code, 'XXX') =  NVL (?, NVL (a.performing_deptloc_code, 'XXX'))  AND NVL (a.source_type, 'X') = NVL (?, NVL (a.source_type, 'X'))  AND NVL (a.source_code, 'X') = NVL (?, NVL (a.source_code, 'X')) AND 'Y' =or_module_resulting (a.performing_facility_id,a.order_category,a.order_type_code)  AND a.ord_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'), 'dd/mm/yyyy') AND   LEAST (TO_DATE (NVL ((?), '31/12/9998'), 'dd/mm/yyyy'),SYSDATE)+ .9999 AND NVL (activity_type, '!') = NVL (?, NVL (activity_type, '!'))  AND SUBSTR (a.order_id, 1, 2) != 'CS'    and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and (B.Result_applicable_yn='Y' or  B.complete_date_time is null) AND SYSDATE <=DECODE (?,'Y',d.REPORTING_DATE+NVL(?,0) ,TRUNC(d.REPORTING_DATE+NVL(?,0))) ##REP_CAT$$ ##NOT_PER_LOC$$ #ADDL_COND# #EXTERAL# ORDER BY DECODE ((?), 'D', TO_CHAR (a.ord_date_time, 'yyyymmdd'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.SOURCE_type||location_description,'P', a.patient_id,'U', a.priority)";//Commented for IN071798
				sql = "SELECT a.order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.order_type_code,or_get_desc.or_order_type (a.order_type_code,?,'2') order_type_short_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class, A.order_id order_id,b.order_line_num order_line_num,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,TO_CHAR (a.ord_date_time, 'dd/mm/yyyy') grp_date_time,or_get_order_catalog (a.order_id,a.order_type_code,?,?,b.order_line_num) order_detail,DECODE (?, 'en', C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) PATIENT_NAME,a.source_type source_type, a.source_code source_code, a.priority priority,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,b.order_line_status order_status,or_get_desc.or_order_status_code(b.order_line_status,?,'2') order_status_short_desc,a.ord_cosign_reqd_yn ord_cosign_reqd_yn,C.sex sex ,B.Result_applicable_yn result_applicable_yn,B.complete_remarks complete_remarks,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'dd/mm/yyyy') dob,B.complete_date_time complete_date_time,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext  FROM or_performing_deptloc WHERE performing_facility_id = a.performing_facility_id AND performing_deptloc_type = a.performing_deptloc_type AND performing_deptloc_code = a.performing_deptloc_code) int_or_ext,'N' image_ref_yn,NVL (B.notify_yn,'N') notify_yn,OR_GET_RESULT_REP_OPERN(A.ORDERING_FACILITY_ID,A.ORDER_ID,A.ORDER_CATEGORY,A.ORDER_TYPE_CODE,A.CONT_ORDER_IND,A.ORDER_STATUS,b.REF_SENT_PRACT_ID,b.REF_RECIEVED_DATE_TIME,A.PERFORMING_FACILITY_ID,A.PERFORMING_DEPTLOC_TYPE,A.PERFORMING_DEPTLOC_CODE,B.Result_applicable_yn,b.order_catalog_code,b.order_line_num,b.order_line_status,null,?,?,?) Result_options, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id order_set_id,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = b.order_line_num AND rownum=1) linked_note_accession_num,nvl(b.INSTRUCTION_TYPE,'T') INSTRUCTION_TYPE, b.billing_status FROM or_order a, or_order_line b, mp_patient c, or_result_detail d WHERE b.order_id=a.order_id AND d.ORDER_ID = b.ORDER_ID AND d.LINE_SRL_NO = b.ORDER_LINE_NUM AND b.order_line_status IN (select order_status_code from or_order_status_code A where a.order_status_type between '65' and '92' ) AND d.result_status='3' AND  c.patient_id=a.patient_id AND a.resume_order_on_gen IS NULL AND a.patient_id = NVL (?, a.patient_id) AND NVL (a.encounter_id, 0) = NVL (?, NVL (a.encounter_id, 0)) AND a.order_id = NVL (?, a.order_id) AND b.start_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'),'dd/mm/yyyy') AND   LEAST(TO_DATE (NVL ((?),'31/12/9998'),'dd/mm/yyyy'),SYSDATE)+ .9999  AND a.priority = NVL (?, a.priority) AND((a.order_category IN(SELECT order_category FROM or_result_user WHERE ((practitioner_id = ? OR resp_id = ?) AND order_type_code='*ALL'))) OR( a.order_type_code IN (SELECT order_type_code FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?)))) AND a.order_category = NVL (?, a.order_category) AND a.order_type_code = NVL (?, a.order_type_code) AND a.performing_facility_id = (?) AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND NVL (a.performing_deptloc_code, 'XXX') =  NVL (?, NVL (a.performing_deptloc_code, 'XXX'))  AND NVL (a.source_type, 'X') = NVL (?, NVL (a.source_type, 'X'))  AND NVL (a.source_code, 'X') = NVL (?, NVL (a.source_code, 'X')) AND 'Y' =or_module_resulting (a.performing_facility_id,a.order_category,a.order_type_code)  AND a.ord_date_time BETWEEN TO_DATE (NVL (?, '01/01/1000'), 'dd/mm/yyyy') AND   LEAST (TO_DATE (NVL ((?), '31/12/9998'), 'dd/mm/yyyy'),SYSDATE)+ .9999 AND NVL (activity_type, '!') = NVL (?, NVL (activity_type, '!'))  AND SUBSTR (a.order_id, 1, 2) != 'CS'    and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and (B.Result_applicable_yn='Y' or  B.complete_date_time is null) AND SYSDATE <=DECODE (?,'Y',d.REPORTING_DATE+NVL(?,0) ,TRUNC(d.REPORTING_DATE+NVL(?,0))) ##REP_CAT$$ ##NOT_PER_LOC$$ #ADDL_COND# #EXTERAL# ORDER BY DECODE ((?), 'D', TO_CHAR (a.ord_date_time, 'yyyymmdd'),'C', order_category_short_desc,'T', order_type_short_desc,'L', a.SOURCE_type||location_description,'P', a.patient_id,'U', a.priority)";//UPDATED FOR IN071798
			}
			//IN060299 End
			
			if (PerformingLocnYN.equalsIgnoreCase("Y"))
			{
						ADDL_COND.append(" and nvl(a.performing_deptloc_code,'XXX') = nvl(?,nvl(a.performing_deptloc_code,'XXX')) ");
			}
			 if (!specimen_no.equals(""))
			 {
				 ADDL_COND.append(" and b.accession_num = ? " );
			 }
			  if (!catalog_desc.equals(""))
			  {
				ADDL_COND.append(" AND upper(b.catalog_synonym_dc) LIKE DECODE (?,'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))  ");
			  }
			 sql=sql.replace("#ADDL_COND#",ADDL_COND);			

			if(task_status.equals("X"))
			{
				EXTERAL.append("AND EXISTS (SELECT performing_deptloc_code  FROM or_performing_deptloc  WHERE performing_facility_id = a.performing_facility_id  AND performing_deptloc_type = a.performing_deptloc_type  AND performing_deptloc_code = a.performing_deptloc_code AND int_or_ext = 'X')");
			}
			if(task_status.equals("X") || task_status.equals("Z"))
				task_code="REPORT_ORD";
			else if(task_status.equals("R"))
				task_code="ACK_REPORT";

			sql=sql.replace("#EXTERAL#",EXTERAL);
			//IN31901 Starts
			sql=sql.replace("##NOT_PER_LOC$$"," AND decode(a.order_category,'OT',performing_deptloc_CODE,'X') IS NOT NULL ");
			//IN31901 Ends
		//	String OTinstalled =isModuleInstalled(login_facility_id,"OT");IN31901
			String RDinstalled =isModuleInstalled(login_facility_id,"RD");
			// Commented as part of IN31901
			/*if ((OTinstalled.equalsIgnoreCase("Y") )&&( RDinstalled.equalsIgnoreCase("Y")))
			{
				sql = sql.replace("##REP_CAT$$", " and substr(a.order_id,1,2)!='OT' and substr(a.order_id,1,2)!='RD'" );
			}
			else if(OTinstalled.equalsIgnoreCase("Y"))
			{
				sql = sql.replace("##REP_CAT$$", " and substr(a.order_id,1,2)!='OT'" );
			}	*/
		    if(RDinstalled.equalsIgnoreCase("Y"))
			{
				sql = sql.replace("##REP_CAT$$", " and substr(a.order_id,1,2)!='RD'" );
			}
			else
			{
				sql = sql.replace("##REP_CAT$$", " " );
			}			
			System.out.println("863 sql@@@"+sql);
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, language_id);
			pstmt.setString( 4, language_id);
			System.out.println("ResultReportingBean.java:900;language_id"+language_id);
    		pstmt.setString( 5, checkForNull((String)Parameters.get("practitioner_type"),"") ) ;  
			System.out.println("ResultReportingBean.java:902;practitioner_type"+(String)Parameters.get("practitioner_type"));			
			pstmt.setString( 6, language_id);
			pstmt.setString( 7, language_id);
			pstmt.setString( 8, language_id);
			pstmt.setString( 9, practitioner_id);
			System.out.println("ResultReportingBean.java:907;practitioner_id"+practitioner_id);		
			pstmt.setString( 10, resp_id);
			System.out.println("ResultReportingBean.java:909;resp_id"+resp_id);
			pstmt.setString( 11, pract_reln_id);
			System.out.println("ResultReportingBean.java:911;pract_reln_id"+pract_reln_id);
			pstmt.setString( 12, language_id);
			pstmt.setString( 13, language_id);
    		pstmt.setString( 14, checkForNull((String)Parameters.get("patient_id"),"")) ;    
			System.out.println("ResultReportingBean.java:914;patient_id"+(String)Parameters.get("patient_id"));			
    		pstmt.setString( 15, checkForNull((String)Parameters.get("encounter_id"),"") ) ;  
System.out.println("ResultReportingBean.java:917;encounter_id"+(String)Parameters.get("encounter_id"));			
    		pstmt.setString( 16,order_id) ; 
System.out.println("ResultReportingBean.java:919;order_id"+order_id);			
    		pstmt.setString( 17, checkForNull((String)Parameters.get("date_from"),"") ) ;    	
System.out.println("ResultReportingBean.java:919;date_from"+(String)Parameters.get("date_from"));				
    		pstmt.setString( 18, checkForNull((String)Parameters.get("date_to"),"") ) ;    		
			System.out.println("ResultReportingBean.java:919;date_to"+(String)Parameters.get("date_to"));		
    		pstmt.setString( 19, checkForNull((String)Parameters.get("priority"),"") ) ;    
System.out.println("ResultReportingBean.java:919;priority"+(String)Parameters.get("priority"));				
    		pstmt.setString( 20, checkForNull((String)Parameters.get("practitioner_id"),"") ) ;  
System.out.println("ResultReportingBean.java:919;practitioner_id"+(String)Parameters.get("practitioner_id"));					
    		pstmt.setString( 21, checkForNull((String)Parameters.get("responsibility_id"),"") ) ;
			System.out.println("ResultReportingBean.java:919;responsibility_id"+(String)Parameters.get("responsibility_id"));	
    		pstmt.setString( 22, checkForNull((String)Parameters.get("practitioner_id"),"") ) ;   
System.out.println("ResultReportingBean.java:919;practitioner_id"+(String)Parameters.get("practitioner_id"));				
    		pstmt.setString( 23, checkForNull((String)Parameters.get("responsibility_id"),"") ) ; 
			System.out.println("ResultReportingBean.java:919;responsibility_id"+(String)Parameters.get("responsibility_id"));		
    		pstmt.setString( 24, checkForNull((String)Parameters.get("order_category"),"") ) ;    		
			System.out.println("ResultReportingBean.java:919;order_category"+(String)Parameters.get("order_category"));		
			pstmt.setString( 25, checkForNull((String)Parameters.get("order_type"),"") ) ;   
System.out.println("ResultReportingBean.java:919;order_type"+(String)Parameters.get("order_type"));				
			pstmt.setString( 26, login_facility_id ) ;    	
System.out.println("ResultReportingBean.java:919;login_facility_id"+login_facility_id);					
			pstmt.setString( 27, checkForNull((String)Parameters.get("performing_location_code"),"") ) ;  
	System.out.println("ResultReportingBean.java:919;performing_location_code"+(String)Parameters.get("performing_location_code"));				
			pstmt.setString( 28, source_type);
System.out.println("ResultReportingBean.java:919;source_type"+source_type);	    		
			pstmt.setString(29, source_location);  
System.out.println("ResultReportingBean.java:919;source_location"+source_location);				
			pstmt.setString(30, checkForNull((String)Parameters.get("date_from"),"") ) ;
    		pstmt.setString(31, checkForNull((String)Parameters.get("date_to"),"") ) ;
			pstmt.setString(32, checkForNull((String)Parameters.get("activity_type"),"") ) ;
			System.out.println("ResultReportingBean.java:919;activity_type"+(String)Parameters.get("activity_type"));	

			int h=33;
			if (performed_only.equalsIgnoreCase("Y"))
			{
				System.out.println("ResultReportingBean.java:954;by_24hrs_yn"+by_24hrs_yn);	
				pstmt.setString( h++, by_24hrs_yn ) ;
				pstmt.setString( h++, period_mod_rslt_completed ) ;
				pstmt.setString( h++, period_mod_rslt_completed ) ;
				System.out.println("ResultReportingBean.java:958;by_24hrs_yn"+period_mod_rslt_completed);	
			}else{
				System.out.println("ResultReportingBean.java:960;task_code"+task_code);	
				pstmt.setString( h++, task_code ) ;
			}
			
			if (PerformingLocnYN.equalsIgnoreCase("Y"))
			{
				pstmt.setString( h++, (String)Parameters.get("performing_location_code") ) ;  
System.out.println("ResultReportingBean.java:967;performing_location_code"+(String)Parameters.get("performing_location_code") );					
			}
			if(!specimen_no.equals(""))
			{
				pstmt.setString(h++,accession_num.trim());
					System.out.println("ResultReportingBean.java:960;accession_num"+accession_num);	
			}
			if (!catalog_desc.equals(""))
			{
				pstmt.setString( h++, search_criteria);
				System.out.println("ResultReportingBean.java:960;search_criteria"+search_criteria);	
				pstmt.setString( h++, catalog_desc);
					System.out.println("ResultReportingBean.java:960;catalog_desc"+catalog_desc);	
				pstmt.setString( h++, catalog_desc);
				pstmt.setString( h++, catalog_desc);
			}			
			pstmt.setString( h++, group_by);
					System.out.println("ResultReportingBean.java:960;catalog_desc"+group_by);	
			resultSet = pstmt.executeQuery() ;

		
		if(resultSet!=null) {
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				while ( start <= end && resultSet!=null && resultSet.next()) {
					String[] record = null;
					//record = new String[39];
					//19112 Start.
					//record = new String[40];
					record = new String[41];
					//19112 end.
					record[0] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
					record[1] = checkForNull(resultSet.getString( "priority" ),"")  ;
					record[2] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
					record[3] = checkForNull(resultSet.getString( "PATIENT_NAME" ),"")  ;
					record[4] = checkForNull(resultSet.getString( "order_status_short_desc" ),"")  ;
					record[5] = checkForNull(resultSet.getString( "order_category" ),"")  ;
					record[6] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
					/*if(practitioner_type.equals("NS"))
					{
						record[7] = resultSet.getString( "source_type")+resultSet.getString( "source_code");
						record[8] = resultSet.getString( "location_details" )  ;
					}else*/
					{
					
						record[7] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;

						record[8] = checkForNull(resultSet.getString( "order_type_short_desc" ),"")  ;
					}
					record[9] = checkForNull(resultSet.getString( "order_id" ),"")  ;
					record[10] = checkForNull(resultSet.getString( "order_status" ),"")  ;
					record[11] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
					record[12] = checkForNull(resultSet.getString( "Result_options" ),"")  ;
					record[13] = checkForNull(resultSet.getString( "location_description" ),"")  ;
					record[14] = checkForNull(resultSet.getString( "sex" ),"")  ;
					record[15] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
					record[16] = checkForNull(resultSet.getString( "encounter_id" ),"");
					record[17] = checkForNull(resultSet.getString( "grp_date_time" ) ,"") ;
					record[18] = checkForNull(resultSet.getString( "source_type" ) ,"") ;
					record[19] = checkForNull(resultSet.getString( "source_code" ),"");

					 {
						record[20] =checkForNull(resultSet.getString("result_applicable_yn"),"");
						record[21] =checkForNull(resultSet.getString("complete_remarks"),"");
						record[22] ="";
						record[23] ="";
						record[24] ="";
						record[25] =checkForNull(resultSet.getString("age"),"");
						record[26] =checkForNull(resultSet.getString("dob"),"");
						record[27] =checkForNull(resultSet.getString("complete_date_time"),"");
						record[28] ="";
						record[29] =checkForNull(resultSet.getString("performing_facility_id"),"");
						record[30] =checkForNull(resultSet.getString("performing_deptloc_type"),"");
						record[31] =checkForNull(resultSet.getString("performing_deptloc_code"),"");
						record[32] =checkForNull(resultSet.getString("int_or_ext"),"");
						record[33] =checkForNull(resultSet.getString("image_ref_yn"),"");
						record[34] =checkForNull(resultSet.getString("notify_yn"),"");
						record[35] =checkForNull(resultSet.getString("order_set_id"),"");
						// Pass the total Number of Records
						record[36] = String.valueOf(total_records);
						record[37] = checkForNull(resultSet.getString("order_line_num"),"");
						record[38] = checkForNull(resultSet.getString("linked_note_accession_num"),"");
						//record[36] =checkForNull(resultSet.getString("location_details"),"");
						record[39] = checkForNull(resultSet.getString("instruction_type"),"T");
						record[40] = checkForNull(resultSet.getString("billing_status"),"");
												
					}
					
					results.add(record) ;
					start++;
				}
				if (resultSet.next())
				{
					String[] templist = (String[])results.get(0);
					if (view_by.equals("L")) {
						templist[36] = ""+(end+7);
					}
					else
					{
						templist[36] = ""+(end+7);
					}
					results.set(0,templist);
				}	
 	  	 }
	//Changes End here
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return results;
	}

	/**
	This will query on the basis of the paramters passed.(This is for Coding)
	@return		:	ArrayList
*/
	public ArrayList getCodingSearchDetails(HashMap Parameters) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//Set set =  Parameters.keySet();
		//Iterator iter = set.iterator();
		/*while(iter.hasNext())
		{
			String key = (String) iter.next();
			//String value = (String) Parameters.get(key);
		}*/
		ArrayList results = new ArrayList() ;
		//int total_records			= 0;
 	//	StringBuffer traceVal = new StringBuffer();
		
		try {
				/* Thai date validations start 16/02/2007*/
			if (!language_id.equals("en")){
			String date_from          	= checkForNull((String)Parameters.get("date_from"),"");
			String date_to      	= checkForNull((String)Parameters.get("date_to"),"");
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");			
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
			Parameters.put("date_from",date_from);
			Parameters.put("date_to",date_to);
			}
			/* Thai date validations end 16/02/2007*/	
				connection = getConnection() ;
			//	String practitioner_type	= (String)Parameters.get("practitioner_type");
			//	String practitioner_id 		= (String)Parameters.get("practitioner_id");
			//	String resp_id				=  (String)Parameters.get("responsibility_id");
			//	String order_category		= (String)Parameters.get("order_category");
			//	String view_by          	= checkForNull((String)Parameters.get("view_by"),"");
				String source_type      	= checkForNull((String)Parameters.get("source_type"),"");
				String source_location  	= checkForNull((String)Parameters.get("source_location"),"");
			//	String catalog_desc     	= checkForNull((String)Parameters.get("catalog_desc"),"");
			//	String search_criteria  	= checkForNull((String)Parameters.get("search_criteria"),"");
				String group_by         	= checkForNull((String)Parameters.get("group_by"),"");
			//	String from_ca 				= checkForNull((String)Parameters.get("from_ca"),"");
				String task_status			= checkForNull((String)Parameters.get("task_status"),"");
				String start_value		 	= checkForNull((String)Parameters.get("start"),"0");
				String end_value		 	= checkForNull((String)Parameters.get("end"),"0");
				int start					= Integer.parseInt(start_value);
				int end						= Integer.parseInt(end_value);

			//	String specimen_no		 	= checkForNull((String)Parameters.get("specimen_no"),"");
			
 				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RESULT_REPORTING_CODING_SELECT")) ;
  				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, (String)Parameters.get("practitioner_type") ) ;
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, language_id);
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, (String)Parameters.get("patient_id") ) ;
				pstmt.setString( 10, (String)Parameters.get("encounter_id") ) ;
				pstmt.setString( 11, (String)Parameters.get("order_id") ) ;
    			pstmt.setString( 12, (String)Parameters.get("date_from") ) ;
    			pstmt.setString( 13, (String)Parameters.get("date_to") ) ;
				pstmt.setString( 14, (String)Parameters.get("priority") ) ;
    			pstmt.setString( 15, (String)Parameters.get("practitioner_id") ) ;
    			pstmt.setString( 16, (String)Parameters.get("responsibility_id") ) ;
				pstmt.setString( 17, (String)Parameters.get("order_category") ) ;
    			pstmt.setString( 18, (String)Parameters.get("order_type") ) ;
				pstmt.setString( 19, login_facility_id ) ;
				pstmt.setString( 20, task_status ) ;
				pstmt.setString( 21, task_status ) ;
				pstmt.setString( 22, task_status ) ;
				pstmt.setString( 23, source_type);
			    pstmt.setString( 24, source_location);
				pstmt.setString( 25, (String)Parameters.get("date_from") ) ;
    			pstmt.setString( 26, (String)Parameters.get("date_to") ) ;
				pstmt.setString( 27, (String)Parameters.get("activity_type") ) ;
				pstmt.setString( 28, group_by);
	
				resultSet = pstmt.executeQuery() ;
			if(resultSet!=null) {
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */
				if(start > 0)
				for(int i=0;(i<start-1 && resultSet.next());i++);	
				
				while ( start <= end && resultSet!=null && resultSet.next()) {
						
							String[] record = new String[26];
		  
							record[0] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
							record[1] = checkForNull(resultSet.getString( "priority_desc" ),"")  ;
							record[2] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
							record[3] = checkForNull(resultSet.getString( "encounter_dtls" ),"")  ;
							record[4] = checkForNull(resultSet.getString( "order_status_short_desc" ),"")  ;
							record[5] = checkForNull(resultSet.getString( "order_category" ),"")  ;
							record[6] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
							record[7] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
							record[8] = checkForNull(resultSet.getString( "order_type_short_desc" ),"")  ;
		 
							record[9] = checkForNull(resultSet.getString( "order_id" ),"")  ;
							record[10] = checkForNull(resultSet.getString( "order_status" ),"")  ;
							record[11] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
							record[12] = checkForNull(resultSet.getString( "priority" ),"")  ;
							record[13] = checkForNull(resultSet.getString( "sex1" ),"")  ;
							record[14] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
							record[15] = checkForNull(resultSet.getString( "encounter_id" ),"");
							record[16] = checkForNull(resultSet.getString( "grp_date_time" ) ,"") ;
							record[17] = checkForNull(resultSet.getString( "source_type" ) ,"") ;
							record[18] = checkForNull(resultSet.getString( "source_code" ),"");
							record[19] = checkForNull(resultSet.getString("age"),"");
							record[20] = checkForNull(resultSet.getString("dob"),"");
							record[21] =checkForNull(resultSet.getString("performing_facility_id"),"");
							record[22] =checkForNull(resultSet.getString("performing_deptloc_type"),"");
							record[23] =checkForNull(resultSet.getString("performing_deptloc_code"),"");
							record[24] =checkForNull(resultSet.getString("order_line_num"),"");

							// Pass the total Number of Records
							//record[24] = String.valueOf(total_records);

							results.add(record) ;
							start++;
					}
					if (resultSet.next())
					{
						String[] templist = (String[])results.get(0);
						templist[25] = ""+(end+7);
						results.set(0,templist);
					}
				 }
  		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		} 
		return results;
	}

/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public String getSysDate () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String currentDate = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate = resultSet.getString("sys_date")  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}

	public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME1") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
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

    public ArrayList  getPerformingLocn(String responsibility_id,String practitioner_id,String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList PerformingLocn	= new ArrayList();
		//String[] order_cat = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2,responsibility_id.trim());
			pstmt.setString(3, practitioner_id.trim() ) ;
			pstmt.setString(4,order_category.trim());
			pstmt.setString(5, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] performing_locn = new String[2];
				performing_locn[0] = resultSet.getString(1)  ;
				performing_locn[1] = resultSet.getString(2)  ;
				PerformingLocn.add(performing_locn);
			}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}
		return PerformingLocn;
	}

	public String  isPerformingLocnYN(String responsibility_id, String practitioner_id, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String performing_locn_yn 	= "N";

		try {
			connection = getConnection() ;
			/*pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN_YN") ) ;
			pstmt.setString(1, responsibility_id.trim());
			pstmt.setString(2, practitioner_id.trim());
			pstmt.setString(3, order_category.trim());*/
			if(choose)
			{
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN_YN") ) ;
			pstmt.setString(1, practitioner_id.trim());
			pstmt.setString(2, order_category.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				performing_locn_yn = resultSet.getString(1)  ;
				performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();
			
			}
			
			}
			else
			{
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_RESP_PERFORM_LOCN_YN") ) ;
			pstmt.setString(1, responsibility_id.trim());
			pstmt.setString(2, order_category.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				performing_locn_yn = resultSet.getString(1)  ;
				performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();
				
			}
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return performing_locn_yn;
	}

		public String  isPerformingLocnYNOrdType(String responsibility_id, String practitioner_id, String order_category,String order_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String performing_locn_yn_ord_type 	= "N";

		try {
			connection = getConnection() ;
			if(!order_type.equals("*ALL")){
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORDTYPE_PERFORM_LOCN_YN_ALL") ) ;
			pstmt.setString(1, practitioner_id.trim());
			pstmt.setString(2, order_category.trim());
	
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				performing_locn_yn_ord_type = resultSet.getString(1)  ;
				performing_locn_yn_ord_type = (performing_locn_yn_ord_type == null) ? "N" : performing_locn_yn_ord_type.trim().toUpperCase();
			
			}else{
				performing_locn_yn_ord_type  = "N";
				
			}
					

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			}	
			if(performing_locn_yn_ord_type.equals("N")){
		
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORDTYPE_PERFORM_LOCN_YN") ) ;
			pstmt.setString(1, practitioner_id.trim());
			pstmt.setString(2, order_category.trim());
			pstmt.setString(3, order_type.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				performing_locn_yn_ord_type = resultSet.getString(1)  ;
				performing_locn_yn_ord_type = (performing_locn_yn_ord_type == null) ? "N" : performing_locn_yn_ord_type.trim().toUpperCase();
			
			}else{
				performing_locn_yn_ord_type  = "N";
				
			}
			
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			}
			if(performing_locn_yn_ord_type.equals("N") && !order_type.equals("*ALL")){
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORDTYPE_RESP_PERFORM_LOCN_YN_ALL") ) ;
			pstmt.setString(1, responsibility_id.trim());
			pstmt.setString(2, order_category.trim());
		
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				performing_locn_yn_ord_type = resultSet.getString(1)  ;
				performing_locn_yn_ord_type = (performing_locn_yn_ord_type == null) ? "N" : performing_locn_yn_ord_type.trim().toUpperCase();
				
			}else{
				performing_locn_yn_ord_type  = "N";
		
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			}	
			if(performing_locn_yn_ord_type.equals("N")){
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORDTYPE_RESP_PERFORM_LOCN_YN") ) ;
			pstmt.setString(1, responsibility_id.trim());
			pstmt.setString(2, order_category.trim());
			pstmt.setString(3, order_type.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				performing_locn_yn_ord_type = resultSet.getString(1)  ;
				performing_locn_yn_ord_type = (performing_locn_yn_ord_type == null) ? "N" : performing_locn_yn_ord_type.trim().toUpperCase();
				
			}else{
				performing_locn_yn_ord_type  = "N";
		
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			}
	
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			//closeStatement( pstmt ) ;
			//closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return performing_locn_yn_ord_type;
	}
	
	public String[] getProcedureCode(String order_id) {

		String record[] = new String[6];

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RECORD_PROCEDURE_PROC_CODE_SELECT") ) ;

			pstmt.setString(1, order_id.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				record[0] = resultSet.getString("chart_result_type")  ;
				record[0] = (record[0] == null) ? "" : record[0].trim().toUpperCase();
				record[1] = resultSet.getString("discr_msr_panel_id")  ;
				record[1] = (record[1] == null) ? "" : record[1].trim().toUpperCase();
				record[2] = resultSet.getString("proc_coding_scheme")  ;
				record[2] = (record[2] == null) ? "" : record[2].trim().toUpperCase();
				record[3] = resultSet.getString("auto_report_yn")  ;
				record[3] = (record[3] == null) ? "" : record[3].trim().toUpperCase();
				record[4] = resultSet.getString("bill_yn")  ;
				record[4] = (record[4] == null) ? "" : record[4].trim().toUpperCase();
				record[5] = resultSet.getString("charge_type_applicable")  ;
				record[5] = (record[5] == null) ? "" : record[5].trim().toUpperCase();
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
		} finally {
			try{
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return record;
	}

    public String[]  getResultType(String order_id) throws Exception {
		Connection connection     = null;
		PreparedStatement pstmt   = null;
		ResultSet resultSet       = null;
		String[] resultType       =  new String[3] ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_RESULT_TYPE_SEARCH") ) ;
			pstmt.setString( 1, order_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				resultType[0] = resultSet.getString(1)  ;
				resultType[1] = resultSet.getString(2)  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return resultType;
	}
	public String getColorCodings(String facility_id,String order_id,String order_catalog_code,String order_line_num) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String 	  colorString		= "X,X,X";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_COLOR_SELECT"));
			pstmt.setString(1, checkForNull(facility_id,""));
			pstmt.setString(2, checkForNull(order_id,""));
			pstmt.setString(3, checkForNull(order_catalog_code,""));
			pstmt.setString(4, checkForNull(order_line_num,""));
			resultSet = pstmt.executeQuery();
			if(resultSet!=null)
			{
				while (resultSet.next())	// Only one record at a time
				{
					colorString = resultSet.getString(1);
				}
			}
		}catch(Exception e)
		{

			e.printStackTrace() ;
		}finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return colorString;
	} // End of getColorCodings

	public String  updateChartValues(String order_id,String practitioner_id) throws Exception {
		Connection connection     = null;
		PreparedStatement pstmt   = null;
		ResultSet resultSet       = null;
		String result         = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REPORTING_UPDATE_CHART_VALUES") ) ;
           	pstmt.setString( 1, practitioner_id.trim() ) ;
			pstmt.setString( 2, order_id.trim() ) ;

			int count = pstmt.executeUpdate() ;
			if (count > 0) {
			 connection.commit();
             result = "Operation Completed Successfully...";
            } else {
                connection.rollback();
            }
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return result;
	}

	/*public String getVisAdmDate (String facility_id,String encounter_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String visitAdmDate = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_VISIT_ADMN_DT") ) ;
			pstmt.setString(1,checkForNull(facility_id,""));
			pstmt.setString(2,checkForNull(encounter_id,""));
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				visitAdmDate = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return visitAdmDate;
	}*/

	public String getPerformingLocnIntOrExt(String loc_code,String loc_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String int_or_ext = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN_INT") ) ;
			pstmt.setString( 1, loc_code.trim() ) ;
			pstmt.setString( 2, loc_type.trim() ) ;
			pstmt.setString( 3, login_facility_id );

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				int_or_ext = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return int_or_ext;
	}

	public ArrayList getPerformingFacilityDetails() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  facility_details	= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_FACILITY_SELECT") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2,login_by_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
			    String record [] = new String[2];
                record[0] = resultSet.getString("facility_id");
				record[1] = resultSet.getString("facility_name");
				facility_details.add(record);
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return facility_details;
	}

	public ArrayList getPerformingLocationDetails(String performing_facility,String ord_cat,String order_catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  location_details	= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN") ) ;
			pstmt.setString(1,language_id);
			pstmt.setString(2,performing_facility);
			pstmt.setString(3,ord_cat);
			pstmt.setString(4,order_catalog_code);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet.next() ) {
			    String record [] = new String[2];
                record[0] = resultSet.getString("code");
				record[1] = resultSet.getString("short_desc");
				location_details.add(record);
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return location_details;
	}

	public String getOrderCatalogCode(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String order_catalog_code = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_ORDER_CATALOG_SELECT") ) ;
			pstmt.setString( 1, order_id.trim() ) ;
			pstmt.setString( 2, order_line_num.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				order_catalog_code = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return order_catalog_code;
	}

	public ArrayList getReferralFacility()throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXTERNAL_ORDERS_REFERRAL_SELECT") ) ;
				pstmt.setString( 1, language_id);
				resultSet = pstmt.executeQuery() ;
				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "referral_code" )  ;
					record[1] = resultSet.getString( "long_desc" )  ;
					OrderCat.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
 			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
 		}
		return OrderCat;
	}

	public String getPractitionerName(String practitioner_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String practitioner_name = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SEARCH_RSLT_PRACT_DTLS") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, practitioner_id ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				practitioner_name = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return practitioner_name;
	}

	public ArrayList getReferredDetails(String order_id,String order_line_num)throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList ReferredDetails = new ArrayList() ;
		String sql = ""; 
		if(order_line_num==null)order_line_num = "";
		if(!order_line_num.equals(""))
		{
			sql = (String)OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_REFERRED_DTLS_LINE");
		}
		else
		{
			sql = (String)OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_REFERRED_DTLS");
		}

		try 
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( sql ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);
			pstmt.setString(3, order_id);
			if(!order_line_num.equals(""))
			{
				pstmt.setString(4, order_line_num);
			}
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[6];
				record[0] = resultSet.getString( "ref_facility_id" )  ;
				record[1] = resultSet.getString( "ref_date_time" )  ;
				record[2] = resultSet.getString( "ref_sent_pract_id" )  ;
				record[3] = resultSet.getString( "facility_name" ) ;
				record[4] = resultSet.getString( "practitioner_name" ) ;
				record[5] = resultSet.getString( "ord_date_time" ) ;

				ReferredDetails.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
 			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
 		}
		return ReferredDetails;
	}

    public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try{
			map = updatePerformingLocationDetails(performing_facility,performing_location,order_id,function_from);
		}catch(Exception e){
			e.printStackTrace();
		}

		return map;
	}

	public HashMap updatePerformingLocationDetails(String performing_facility,String performing_location,String order_id,String function_from) {
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();

		HashMap updt_map = new HashMap();
		HashMap sqlMap = new HashMap();

		map.put("result", new Boolean(false));
		/*map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put("message","RECORD_MODIFIED"); */
		try{
			sqlMap.put("SQL_OR_REGISTER_ORDER_PERFROM_LOCN_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_PERFROM_LOCN_UPDATE") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_SENT_OUT_HDR_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SENT_OUT_HDR_UPDATE") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_SENT_OUT_DTL_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SENT_OUT_DTL_UPDATE") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_HDR_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_HDR_UPDATE") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_DTL_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_DTL_UPDATE") );

			sqlMap.put("SQL_OR_REGISTER_ORDER_INSERT_OR_REFUSAL_ORDERABLE",OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_INSERT_OR_REFUSAL_ORDERABLE") );
			sqlMap.put("SQL_OR_REFUSAL_ORDER_SRL_NO",OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_SRL_NO") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_FORM_UPDATE_CLOB",OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_FORM_UPDATE_CLOB") );

			updt_map.put("order_id",				order_id);

			updt_map.put("patient_id",				patient_id);
			updt_map.put("patient_class",				patient_class);
			updt_map.put("encounter_id",				encntr_id);
			updt_map.put("order_line_num",				order_line_num);
			updt_map.put("order_catalog_code",				order_catalog_code);
			updt_map.put("order_catalog_desc",				order_catalog_desc);
			updt_map.put("priority",				priority);
			updt_map.put("order_type_code",				order_type_code);
			updt_map.put("source_type",				source_type);
			updt_map.put("source_code",				source_code);

			updt_map.put("performing_facility",		performing_facility);
			updt_map.put("performing_location",		performing_location);
			updt_map.put("performing_location_type",		performing_location_type);
			updt_map.put("function_from",			function_from);

			updt_map.put("ref_facility_id", 		ref_facility_id);
			updt_map.put("ref_date_time", 			ref_date_time);
			updt_map.put("ref_sent_pract_id", 		ref_sent_pract_id);
			updt_map.put("ref_sent_remarks", 		ref_sent_remarks);
			updt_map.put("ref_report_pract_id", 	ref_report_pract_id);
			updt_map.put("ref_report_date_time", 	ref_report_date_time);
			updt_map.put("ref_recieved_date_time", 	ref_recieved_date_time);
			updt_map.put("ref_recieved_pract_id", 	ref_recieved_pract_id);
			updt_map.put("ref_recieved_remarks", 	ref_recieved_remarks);

			updt_map.put("ref_form_content", 	ref_form_content);
			updt_map.put("ref_form_id",				ref_form_id);
			updt_map.put("login_facility_id", 	login_facility_id);
			updt_map.put("login_by_id", 	login_by_id);
			updt_map.put("login_at_ws_no", 	login_at_ws_no);

		}catch(Exception e){
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}

		//ORRegisterOrderHome home = null ;
		//ORRegisterOrderRemote remote = null ;

		try {
				updt_map.put( "properties", getProperties() );
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_REGISTER_ORDER_JNDI") ) ;
				home  = (ORRegisterOrderHome) PortableRemoteObject.narrow( object, ORRegisterOrderHome.class ) ;
				
				remote = home.create() ;
				map = remote.modify( updt_map, sqlMap ) ;*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_REGISTER_ORDER_JNDI"), ORRegisterOrderHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= updt_map;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= updt_map.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;
				
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				else
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);


				/*if(((Boolean)map.get("result")).booleanValue())
					map.put("message", (String)map.get("message"));
				else
					map.put("message", (String)map.get("message"));
				*/

				String msgAftInsert = ((String)map.get("message")).trim();
				if(msgAftInsert.equalsIgnoreCase("RECORD_MODIFIED"))
				{
					clearBean();
					if (map.containsKey("printVal")) {
						allValues = (Hashtable)map.get("printVal");
					} else {
						allValues = new Hashtable();
					}
				}

				//HashMap retHashMap = (HashMap )hashmap.get("NoOfRecords");
				//String temp[] = new String[2];

		} catch(Exception e) {

			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				map.put( "message", ee.getMessage() ) ;
			}*/
		}

		return map;
	}

    public String getIntOrExt(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String int_or_ext = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_INT_OR_EXT") ) ;
			pstmt.setString( 1, order_id ) ;
 			resultSet = pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next() ) {
				int_or_ext = resultSet.getString(1)  ;
				if (int_or_ext == null) int_or_ext = "";
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return int_or_ext;
	}
	/*This will populate all the consent id's for the referral form
	@return		:	ArrayList
	*/
	public ArrayList getRefusalForm() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList RefusalText = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_REFERRAL_FORM_SELECT"));
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "consent_form_id" )  ;
				record[1] = resultSet.getString( "consent_form_label" )  ;

				RefusalText.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return RefusalText;
	}

	/*This will retrieve the description for the consent id in the referral text*/
	public String getRefFormContent(String ref_form_id)
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String text ="";
			try
			{
				connection = getConnection();
				preparedstatement = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CONSENT_FORM_UPDATE_CLOB"));
				preparedstatement.setString(1,ref_form_id.trim());
				resultset = preparedstatement.executeQuery();
				while ( resultset != null && resultset.next() )
				{
				java.sql.Clob consent_form_content = resultset.getClob("consent_form_content");

				if(consent_form_content!=null && consent_form_content.length() > 0)
						text = consent_form_content.getSubString(1,( (int)consent_form_content.length() ));
				}
			}
			catch(Exception exception)
			{

				exception.printStackTrace();

			}
			finally
			{
				try{
					closeResultSet(resultset);
					closeStatement(preparedstatement);
					closeConnection(connection);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			return text;
	}
		/*This gives the order catalog code and description in the sent Out orders*/
	public ArrayList getOrderCatalog(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList Ordercatalog = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_ORDER_CATALOG_SELECT"));
			pstmt.setString(1,order_id.trim());
			pstmt.setString(2,order_line_num.trim());
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_catalog_code" )  ;
				record[1] = resultSet.getString( "catalog_synonym_dc" )  ;

				Ordercatalog.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return Ordercatalog;
	}
	//public int updateORStatus(String order_id,String accession_num,String note_type,String practitioner_id ) throws Exception {
	public void updateORStatus(String order_id,String accession_num,String note_type,String practitioner_id ) throws Exception {
		Connection connection 		= null;
		//PreparedStatement pstmt 	= null;
		CallableStatement cstmt		= null;
		//int inserted=0;
		try {
			connection = getConnection() ;
		//	pstmt = connection.prepareStatement( OrRepository.getOrKeyValue(""));
	/*		pstmt = connection.prepareStatement( "update or_order_line set	order_line_status = (select order_status_code from or_order_status_code where order_status_type = '85') ,result_line_status = (select order_status_code from or_order_status_code where order_status_type = '85') ,	accession_num = ?,LAST_ACTION_TYPE = 'NT' where order_id = ?");

			pstmt.setString(1,accession_num.trim());
			pstmt.setString(2,order_id.trim());
			inserted = pstmt.executeUpdate() ;
			if(pstmt != null)
				closeStatement( pstmt ) ;
			if(inserted > 0 ){
				pstmt = connection.prepareStatement( "update or_order set order_status = (select order_status_code from or_order_status_code where order_status_type = '85') ,result_status = (select order_status_code from or_order_status_code where order_status_type = '85') where order_id = ?");

				pstmt.setString(1,order_id.trim());
				inserted = pstmt.executeUpdate() ;
			}*/
			
			cstmt = connection.prepareCall("{ "+OrRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_NOTE_UPDATE")+" }");
			cstmt.setString(1,  accession_num.trim());
			cstmt.setString(2,  order_id.trim());
			cstmt.setString(3,  practitioner_id.trim());	//l_practitioner_id 
			cstmt.setString(4,  note_type.trim());			//l_Note_Type 
			cstmt.setString(5,  login_facility_id.trim());	//p_facility_id 
			cstmt.setString(6,  login_by_id.trim());		//p_user_id 
			cstmt.setString(7,  login_at_ws_no.trim());		//p_ws_no 
						
			//cstmt.registerOutParameter(8, Types.VARCHAR ) ;
			cstmt.execute();
			//String err_msg	 		= cstmt.getString(8);
						
			//if(inserted > 0)
			//	connection.commit() ;
			//else
			//	connection.rollback() ;
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			connection.commit() ;
			closeStatement( cstmt ) ;
			closeConnection(connection);
		}

		//return inserted;
	}
	public String insertProcedureLink(String order_id,String order_type_code,int report_srl_no,String proc_scheme_code,String patient_id,String patient_class,String encounter_id,String practitioner_id,String facility_id) throws Exception 
	{
		Connection connection     = null;
		PreparedStatement pstmt   = null,pstmt_delete = null,pstmt_proc_insert = null,pstmt_proc_delete= null,pstmt_proclink_insert_srl_no = null;
		ResultSet resultSet_srl_no       = null;
		String result         = "";
		int[] insert_link = {};
		int[] insert_proc_link = {};
		int srl_no = 0;
//		int[] delete_link = {};

		try 
		{
			connection = getConnection() ;
			pstmt_delete = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_DELETE") ) ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT") ) ;
			pstmt_proc_delete = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_DELETE") ) ;
			pstmt_proc_insert = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_INSERT") ) ;
			pstmt_proclink_insert_srl_no = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_SRL_NO") ) ;
			if(!proc_scheme_code.equals(""))
			{
				StringTokenizer stoken=new StringTokenizer(proc_scheme_code,"*");
				String temp_scheme="", srl_num="",proc_code_scheme="",proc_code_resulted="";
				int line_srl= 0,srl_number=0;double line_sr =0;
 				pstmt_delete.setString(1 ,order_id);
 				pstmt_delete.executeUpdate();
				pstmt_proc_delete.setString(1 ,order_id);
 				pstmt_proc_delete.executeUpdate();
				pstmt_proclink_insert_srl_no.setString(1, facility_id);
				pstmt_proclink_insert_srl_no.setString(2, encounter_id);
				resultSet_srl_no = pstmt_proclink_insert_srl_no.executeQuery();
				resultSet_srl_no.next();
				srl_no=resultSet_srl_no.getInt(1);
				closeResultSet(resultSet_srl_no);
			
				while(stoken.hasMoreTokens())
				{
					if (srl_number==0)
					{
						srl_number=srl_no;
					}
					else
					{
						++srl_number;
					}
					temp_scheme =stoken.nextToken();
					StringTokenizer stoken1=new StringTokenizer(temp_scheme,"~");
					line_sr =Double.parseDouble(stoken1.nextToken());
					line_srl = (int)line_sr;
					srl_num	 = stoken1.nextToken();
					proc_code_scheme  = stoken1.nextToken();
					proc_code_resulted  = stoken1.nextToken();
					/*pstmt_delete.setString(1 ,order_type_code);
					pstmt_delete.setString(2 ,order_id);
					pstmt_delete.setInt(3 ,report_srl_no);
					pstmt_delete.setInt(4 ,line_srl);
					pstmt_delete.setString(5 ,srl_num);
					pstmt_delete.addBatch();*/
				//	pstmt_delete.executeUpdate();
				
					pstmt.setString(1 ,order_type_code);
					pstmt.setString(2 ,order_id);
					pstmt.setInt(3 ,report_srl_no);
					pstmt.setInt(4 ,line_srl);//line_srl_num
					pstmt.setString(5 ,srl_num);//srl_num
					pstmt.setString(6 ,proc_code_scheme);//proc_code_scheme
					pstmt.setString(7 ,proc_code_resulted);//proc_code_resulted
					pstmt.setString(8 ,login_by_id);
					pstmt.setString(9 ,login_at_ws_no);
					pstmt.setString(10 ,login_facility_id);
					pstmt.setString(11 ,login_by_id);
					pstmt.setString(12 ,login_at_ws_no);
					pstmt.setString(13 ,login_facility_id);
					pstmt.addBatch();
					pstmt_proclink_insert_srl_no.setString(1, facility_id);
					pstmt_proclink_insert_srl_no.setString(2, encounter_id);
					resultSet_srl_no = pstmt_proclink_insert_srl_no.executeQuery();
					resultSet_srl_no.next();
					srl_no=resultSet_srl_no.getInt(1);
					closeResultSet(resultSet_srl_no);
					pstmt_proc_insert.setString(1 , facility_id);
					pstmt_proc_insert.setString(2 , encounter_id);
					pstmt_proc_insert.setInt(3 , srl_number);
					pstmt_proc_insert.setString(4 , practitioner_id);
					pstmt_proc_insert.setString(5 , patient_id);//patient_id
					pstmt_proc_insert.setString(6 , proc_code_resulted);//proc_code_resulted
					pstmt_proc_insert.setString(7 , proc_code_scheme);//proc_code_scheme
					pstmt_proc_insert.setString(8 , patient_class);//patient_class
					pstmt_proc_insert.setString(9 , order_id);
					pstmt_proc_insert.setInt(10 , line_srl);
					pstmt_proc_insert.setString(11 , "O");
					pstmt_proc_insert.setString(12 , order_id.substring(0,2));//order_category
					pstmt_proc_insert.setString(13 , "OR");
					pstmt_proc_insert.setString(14 , line_srl+"#"+order_id);//accession_num
					pstmt_proc_insert.setString(15 , "N");
					pstmt_proc_insert.setString(16 , login_by_id);
					pstmt_proc_insert.setString(17 , login_at_ws_no);
					pstmt_proc_insert.setString(18 , login_facility_id);
					pstmt_proc_insert.setString(19 , login_by_id);
					pstmt_proc_insert.setString(20 , login_at_ws_no);
					pstmt_proc_insert.setString(21 , login_facility_id);
					pstmt_proc_insert.setString(22 , "proc_narration");//48622
					pstmt_proc_insert.addBatch();
					//count = pstmt.executeUpdate();

				}
				//delete_link = pstmt_delete.executeBatch();
				insert_link = pstmt.executeBatch();
				insert_proc_link = pstmt_proc_insert.executeBatch();
			}
			closeStatement(pstmt_proclink_insert_srl_no);
			//int count = pstmt.executeUpdate() ;
		   	if((insert_link.length > 0)&&(insert_proc_link.length>0))
			{ //check updation in SYN
				connection.commit();
				result = "Success";
			}
			else if((insert_link.length == (-3)))
			{
				 connection.rollback();
			}			
		} catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet_srl_no);
			closeStatement( pstmt_delete ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt_proc_insert ) ;
			closeStatement( pstmt_proc_delete ) ;
			closeStatement( pstmt_proclink_insert_srl_no ) ;
			closeConnection(connection) ;
		}
		return result;
	}
	public ArrayList getLatestStatus(String accessionNum,String facilityId,String languageId) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		
		ArrayList notesStatus = new ArrayList();
		try {
			//String sql="select * from(SELECT b.practitioner_name clinician_name, a.action_type,action_status action_desc FROM ca_encntr_note_audit_log a, am_practitioner_lang_vw b, am_speciality_lang_vw c,am_practitioner_lang_vw d WHERE b.practitioner_id(+) = a.action_by_id AND c.speciality_code(+) = a.action_by_group_code AND d.practitioner_id(+) = a.request_by_id  AND a.facility_id = ? AND a.accession_num = ? AND b.language_id =? AND d.language_id(+) =? ORDER BY a.action_date_time desc ) where rownum=1";

			String sql="SELECT DISTINCT action_by_id,am_get_desc.am_practitioner (action_by_id,?,1) clinician_name,a.action_type, action_status action_desc,CASE WHEN a.action_type = 'FS' THEN am_get_desc.am_speciality (a.action_by_group_code,?,2)  END action_by_group,am_get_desc.am_practitioner (REQUEST_BY_ID,?,1) request_by_name,request_by_id FROM ca_encntr_note_audit_log a WHERE a.facility_id = ? AND a.accession_num = ? AND a.action_type IN ('SP', 'FS', 'RV','ER') AND a.action_status IN ('RQ', 'CO') ORDER BY a.action_by_id";

			connection = getConnection() ;
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,languageId); 
			pstmt.setString(2,languageId); 
			pstmt.setString(3,languageId); 
			pstmt.setString(4,facilityId);							
			pstmt.setString(5,accessionNum); 
			

			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() )
			{
				String[] latestStatus = new String[7];
				latestStatus[0] = resultSet.getString("clinician_name")==null?"":resultSet.getString("clinician_name");;
				latestStatus[1] = resultSet.getString("action_type")==null?"":resultSet.getString("action_type");
				latestStatus[2] = resultSet.getString("action_desc")==null?"":resultSet.getString("action_desc");			
				latestStatus[3] = resultSet.getString("action_by_id")==null?"":resultSet.getString("action_by_id");			
				latestStatus[4] = resultSet.getString("action_by_group")==null?"":resultSet.getString("action_by_group");			
				latestStatus[5] = resultSet.getString("request_by_name")==null?"":resultSet.getString("request_by_name");			
				latestStatus[6] = resultSet.getString("request_by_id")==null?"":resultSet.getString("request_by_id");			
				notesStatus.add(latestStatus);
			}
			
		} catch ( Exception e )	{
			
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return notesStatus;
	}

public ArrayList<String>  getORParamVals() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList<String> arrList = new ArrayList<String>();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAMETER_SELECT") ) ;			

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				arrList.add(resultSet.getString("period_mod_rslt_completed")==null?"0":resultSet.getString("period_mod_rslt_completed"));
				arrList.add(resultSet.getString("by_24hrs_yn")==null?"N":resultSet.getString("by_24hrs_yn"));
			}
		} catch ( Exception e )	{			
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return arrList;
	}
///48622
public String getMessage(String locale, String messageId, String moduleId)
{
  java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
  String mesg = (String) message.get("message");
  message.clear();
  return(mesg) ;
}
///48622
}
