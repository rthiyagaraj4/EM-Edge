/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
-------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	created 
28/08/2012    IN033063       Chowminya G    Incident No: IN033063 - <Package services allowed to be availed after the Package valid day> 
06/11/2012    IN036034       Chowminya G    In register function system display double line of 1 order ID
14/08/2013	  IN000000 	     Chowminya G    Page cannot be displayed issue when BL module not installed
21/04/2016	  IN058250		 Krishna Gowtham	System allowing registering order even if that order type is not assigned to user.
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
15/12/2017	IN065942		Dinesh T	15/12/2017		Ramesh G			In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
23/04/2020	IN071618	    Nijitha S	23/04/2020 		Ramesh G			PMG2019-MMS-CRF-0004
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eOR.ORCancelDiscontinueOrder.ORCancelDiscontinueOrderHome;//IN071618
import eCommon.Common.*;

import eOR.ORRegisterOrder.*;
import webbeans.eCommon.*; 
import com.ehis.persist.*;

public class RegisterOrder extends eOR.Common.OrAdapter implements java.io.Serializable {

	protected Hashtable allValues 				= new Hashtable();
	protected Hashtable printLabelValues = new Hashtable();//IN065942
	protected String total_records 				= "";
	protected String practitioner_id			= "";
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
	protected String performing_location_type	= "";
	protected String performing_location		= "";
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
	//protected ArrayList persistence_details		= new ArrayList();
	protected String practitionerType = "";//IN065942

	StringBuffer traceVals = new StringBuffer();
	public StringBuffer chk=new StringBuffer();
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
	public void setPractitioner_id(java.lang.String value) {practitioner_id = value;}

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
	//IN065942, starts
	public void setPractitionerType(String value) 
	{
		practitionerType = value;
	}
	//IN065942, ends
		//IN071618 - Start
		protected String	called_from				= "";
		protected String	order_details			= "";
		
		public String getCalledFrom() 
		{
			return this.called_from;
		}
		public String getOrderDetails() 
		{
			return this.order_details;
		}
		public void setCalled_from(String called_from) 
		{
			this.called_from = called_from;
		}
		public void setOrder_details(String order_details) 
		{
			this.order_details = order_details;
		}
		//IN071618 - End

	public String getMode(){						return mode;	}
	public String getTotalRecs(){					return total_records;	}
	public String getOrderCategory(){				return order_category;	}
	public String getOrderType(){					return order_type_code;	}
	public String getPriority(){					return priority;	}
	public String getLocationType(){				return location_type;	}
	public String getSourceType(){					return source_type;	}
	public String getSourceCode(){					return source_code;	}
	public String getLocation(){					return locn;	}
	public String getPatientId(){					return patient_id;	}
	public String getPatientClass(){				return patient_class;	}
	public String getEncntrId(){					return encntr_id;	}
	public String getOrderId(){						return order_id;	}
	public String getOrderLineNum(){				return order_line_num;	}
	public String getDateFrom(){					return date_from;	}
	public String getDateTo(){						return date_to;	}
	public String getViewBy(){						return view_by;	}
	public String getOrderCatalogCode() {			return order_catalog_code; }
	public String getOrderCatalogDesc() {			return order_catalog_desc; }
	public String getPerformingFacility() {			return performing_facility;}
	public String getPerformingLocation() {			return performing_location;}
	public String getPerformingLocationType() {		return performing_location_type;}
	public String getFunctionFrom() {				return function_from;}
    public java.lang.String getPractitioner_id() {return practitioner_id;}

	public String getRefFacilityId() {				return ref_facility_id;}
	public String getRefDateTime() {				return ref_date_time;}
	public String getRefSentPractId() {				return ref_sent_pract_id;}
	public String getRefSentRemarks() {				return ref_sent_remarks;}
	public String getRefReportPractId() {			return ref_report_pract_id;}
	public String getRefReportDateTime() {			return ref_report_date_time;}
	public String getRefRecievedDateTime() {		return ref_recieved_date_time;}
	public String getRefRecievedPractId() {			return ref_recieved_pract_id;}
	public String getRefRecievedRemarks() {			return ref_recieved_remarks;}
	public String getRefFormContent()	{			return this.ref_form_content;}
	public String getRefFormId()	{			return this.ref_form_id;}
	public Hashtable getAllValues() {
		return allValues;
	}

	//IN065942, starts
	public Hashtable getPrintLabelValues()
	{
		return printLabelValues;
	}
	public String getPractitionerType()
	{
		return practitionerType;
	}

	public void clearPrintLabelValues()
	{
		printLabelValues = new Hashtable();
	}
	//IN065942, ends

	
//	public ArrayList getDetails(){		return persistence_details;	}

	public void clear() {
			super.clear();
			ref_form_content=null;
		//	persistence_details = null;
			clearBean();
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

/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public String  isAuthorised(String practitioner_id, String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String isValid = "";

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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return isValid;
	}



/**

	@return		:	String
*/

	public String  isModuleInstalled(String facility_id, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String install_yn = "";

		//System.out.println("order_category : "+order_category);

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;

			pstmt.setString(1, order_category.trim());
			pstmt.setString(2, facility_id.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				install_yn = resultSet.getString(1)  ;
				//System.out.println("SDSD");
			}else{
				install_yn  = "N";
				//System.out.println("eeeee");
			}
		} catch ( Exception e )	{
			System.out.println( "Error loading values from database"+e ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return install_yn;
	}

    public String  isPerformingLocnYN(String responsibility_id, String practitioner_id, String order_category,String login_value) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String performing_locn_yn 	= "N";

		//System.out.println("order_category : "+order_category);

		try {
			connection = getConnection() ;
			if(login_value.equalsIgnoreCase("pract"))
			{
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN_YN") ) ;
						
				pstmt.setString(1, practitioner_id.trim());
				pstmt.setString(2, order_category.trim());

				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null && resultSet.next() ) {
					performing_locn_yn = resultSet.getString(1)  ;
					performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();
				//System.out.println("SDSD");
				}
			}
			if(login_value.equalsIgnoreCase("resp"))
			{
				if(performing_locn_yn.equals("N")) 
					{
						closeStatement( pstmt ) ;
						closeResultSet( resultSet ) ;

						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_RESP_PERFORM_LOCN_YN") ) ;
				
						pstmt.setString(1, responsibility_id.trim());
						pstmt.setString(2, order_category.trim());

						resultSet = pstmt.executeQuery() ;
						if ( resultSet != null && resultSet.next() ) {
							performing_locn_yn = resultSet.getString(1)  ;
							performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();
					//System.out.println("SDSD");
					}else{
						performing_locn_yn  = "N";
					//System.out.println("eeeee");
					}
				}
			}
		
		} catch ( Exception e )	{
			System.out.println( "Error loading values from database"+e ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return performing_locn_yn;
	
	}

/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	/*public String getSysDate () throws Exception { // Commented on 16th Feb by prasad because on thai Date Validations
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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}*/


/**
	This will populate the order category by preactiotioner ID
	@return		:	ArrayList
*/

	public String[]  getOrdercategoryByPract(String practitioner_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] order_cat = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_CAT") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, practitioner_id.trim() ) ;
			//System.out.println("========"+language_id+practitioner_id.trim());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				order_cat[0] = resultSet.getString(1)  ;
				order_cat[1] = resultSet.getString(2)  ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}
		return order_cat;
	}

	public ArrayList  getOrderCategoryByPract(String practitioner_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCategory		= new ArrayList();
		//String[] order_cat = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_CAT") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, practitioner_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] order_cat = new String[2];
				order_cat[0] = resultSet.getString(1)  ;
				order_cat[1] = resultSet.getString(2)  ;
				OrderCategory.add(order_cat);
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}
		return OrderCategory;
	}

	public ArrayList  getPerformingLocn(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList PerformingLocn	= new ArrayList();
		//String[] order_cat = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN_OTH") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2,order_category.trim());
			pstmt.setString( 3, login_facility_id);
			//System.out.println("===="+language_id+"===="+responsibility_id.trim()+"===="+practitioner_id.trim()+"===="+order_category.trim()+"===="+login_facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] performing_locn = new String[2];
				performing_locn[0] = resultSet.getString(1)  ;
				performing_locn[1] = resultSet.getString(2)  ;
				PerformingLocn.add(performing_locn);
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}
		return PerformingLocn;
	}



/**
	This will populate the order category by preactiotioner ID
	@return		:	ArrayList
*/

	public String[]  getOrdercategoryByResp(String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] order_cat = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_CAT1") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, resp_id.trim());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				order_cat[0] = resultSet.getString(1)  ;
				order_cat[1] = resultSet.getString(2)  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return order_cat;
	}

    public ArrayList  getOrderCategoryByResp(String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCategory		= new ArrayList();
		//String[] order_cat = new String[2];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_CAT1") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, resp_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] order_cat = new String[2];
				order_cat[0] = resultSet.getString(1)  ;
				order_cat[1] = resultSet.getString(2)  ;
				OrderCategory.add(order_cat);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return OrderCategory;
	}


/**
	This will populate the order category by preactiotioner ID
	@return		:	ArrayList
*/

	public ArrayList  getOrderTypeByPract(String ord_cat, String practitioner_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_TYPE") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, ord_cat.trim() ) ;
			pstmt.setString( 3, practitioner_id.trim() ) ;
			pstmt.setString( 4, language_id);
			pstmt.setString( 5, ord_cat.trim() ) ;
			pstmt.setString( 6, practitioner_id.trim() ) ;

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
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
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
			System.err.println( "Error loading values from database" ) ;
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
	This will populate the order category by preactiotioner ID
	@return		:	ArrayList
*/
	public ArrayList  getOrderTypeByResp(String ord_cat, String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORD_TYPE1") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, ord_cat.trim() ) ;
			pstmt.setString( 3, resp_id.trim() ) ;
			pstmt.setString( 4, language_id);
			pstmt.setString( 5, ord_cat.trim() ) ;
			pstmt.setString( 6, resp_id.trim() ) ;

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
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}



/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList getLocation(String location_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		chk.append("");
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN") ) ;
			//pstmt.setString( 1, facility_id.trim() ) ;
			pstmt.setString( 1,language_id);
			pstmt.setString( 2,language_id);
			pstmt.setString( 3,language_id);
			pstmt.setString( 4,language_id);
			pstmt.setString( 5, location_type.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "location_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}


/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList getSearchDetails(String view_order, String ord_cat, String single_multi,String ord_type,String priority,String location_type,String locn,String patientId,String encntr_id,String order_no,String date_from,String date_to,String practitioner_id,String resp_id,String performing_location_code,String int_or_ext,String specimen_no,String activity_type,int start, int end,String login_value) throws Exception 
	{
		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
 		//int total_records			= 0;
		//if(locn.equalsIgnoreCase("All"))
		//{
		//	locn="";
		//}
		chk.append("");
		chk.append("view_by : "+view_by);

		single_multi = single_multi.trim();
		ord_type = ord_type.trim();
		priority = priority.trim();
		location_type = location_type.trim();
		locn = locn.trim();
		patientId = patientId.trim();
		encntr_id = encntr_id.trim();
		order_no = order_no.trim();
		date_from = date_from.trim();
		date_to = date_to.trim();
		
		/* Thai date validations start 16/02/2007*/
			if (!language_id.equals("en")){
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");			
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
			}
			/* Thai date validations end 16/02/2007*/	

		try {
			connection = getConnection() ;

			/*String PerformingLocnYN = "N";

			if (!practitioner_id.equals("")) {
                PerformingLocnYN = isPerformingLocnYN("",practitioner_id,ord_cat,login_value);
            }
			if (PerformingLocnYN.equals("N") && !(resp_id.equals(""))) {
                PerformingLocnYN = isPerformingLocnYN(resp_id,"",ord_cat,login_value);
            }*/
			
			//sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SEARCH_DTL");//Commented and Modified the query -[IN033063]
			//sql="SELECT  a.order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,	a.Priority Priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') PATIENT_CLASS_SHORT_DESC, a.PATIENT_CLASS,a.ORDER_ID,a.patient_id, a.encounter_id,/*TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI')*/(select TO_CHAR( start_date_time,'DD/MM/YYYY HH24:MI') start_date_time from or_order_line where order_id=a.order_id and rownum=1) order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?)  order_detail,		 decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) patient_name,GET_AGE(b.DATE_OF_BIRTH) patient_age ,a.SOURCE_TYPE,a.SOURCE_CODE,a.Priority,a.ORDER_TYPE_CODE ,	 a.ORD_PRACT_ID, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1') ORDERING_PRACT_NAME, a.ORDER_STATUS, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ORDEr_STATUS_SHORT_DESC, a.ORD_COSIGN_REQD_YN,a.order_id,nvl(a.cont_order_ind,'DO') cont_order_ind, b.sex sex1, OR_ORDER_EXTERNAL_LOCATION ('REGISTER', a.ORDER_ID ,a.ORDER_TYPE_CODE) menu_text,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(select int_or_ext from or_performing_deptloc where performing_facility_id = a.performing_facility_id and performing_deptloc_type = a.performing_deptloc_type and performing_deptloc_code = a.performing_deptloc_code) int_or_ext, nvl((select notify_yn from or_order_line where order_id= a.order_id and notify_yn = 'Y' and rownum <=1),'N') notify_yn,nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = a.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status, a.bill_yn, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.performing_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.performing_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id  order_set_id,to_char(b.date_of_birth,'dd/mm/yyyy') dob from or_order a ,mp_patient b , or_order_line c WHERE b.patient_id=a.patient_id and  a.patient_id = nvl((?),a.patient_id)	and nvl(a.encounter_id,0) = nvl((?),nvl(a.encounter_id,0)) AND a.order_category IN (SELECT order_category FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?))	and nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND a.order_id = nvl((?),a.order_id) and exists (select order_id from or_order_line where order_id= a.order_id and trunc(start_date_time) between to_date(nvl((?),'01/01/1000'),'dd/mm/yyyy') and least(to_date(nvl((?),'31/12/9999'),'dd/mm/yyyy'),sysdate) and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) )  and nvl(a.SOURCE_TYPE,'X')=NVL((?),nvl(a.source_TYPE,'X')) and nvl(a.SOURCE_code,'X') =NVL((?),nvl(a.source_CODE,'X')) and a.Priority=nvl((?),a.Priority) 	and a.order_category =nvl(?,a.order_category) and a.order_type_code = nvl((?),a.order_type_code) and a.performing_facility_id = ?  AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and (a.performing_appl_id IS NULL  OR a.performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and substr(a.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, a.order_category,a.order_type_code,a.order_id,a.performing_facility_id,a.performing_deptloc_type,a.performing_deptloc_code) ='Y' ##REG_CAT$$ ##SPECI$$ ##INT_OR_EXT##  ##PERFORM_LOCN$$  ##ACTVITY_TYPE$$ ##NOT_PER_LOC$$ and a.order_id = c.order_id and ((c.billing_package_ref is null) or( (a.ord_date_time + (Select pkg_valid_days from bl_package_sub_hdr where package_seq_no = c.billing_package_ref) +(select NVL(valid_days_for_pkg_orders,'0') from bl_parameters where operating_facility_id = ?)) >= sysdate)) and c.order_line_num = '1' order by order_category_short_desc,order_type_short_desc,a.ord_date_time,a.priority";//--[IN036034]
			//IN058250 Start
			//sql="SELECT  a.order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,	a.Priority Priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') PATIENT_CLASS_SHORT_DESC, a.PATIENT_CLASS,a.ORDER_ID,a.patient_id, a.encounter_id,/*TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI')*/(select TO_CHAR( start_date_time,'DD/MM/YYYY HH24:MI') start_date_time from or_order_line where order_id=a.order_id and rownum=1) order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?)  order_detail,		 decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) patient_name,GET_AGE(b.DATE_OF_BIRTH) patient_age ,a.SOURCE_TYPE,a.SOURCE_CODE,a.Priority,a.ORDER_TYPE_CODE ,	 a.ORD_PRACT_ID, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1') ORDERING_PRACT_NAME, a.ORDER_STATUS, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ORDEr_STATUS_SHORT_DESC, a.ORD_COSIGN_REQD_YN,a.order_id,nvl(a.cont_order_ind,'DO') cont_order_ind, b.sex sex1, OR_ORDER_EXTERNAL_LOCATION ('REGISTER', a.ORDER_ID ,a.ORDER_TYPE_CODE) menu_text,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(select int_or_ext from or_performing_deptloc where performing_facility_id = a.performing_facility_id and performing_deptloc_type = a.performing_deptloc_type and performing_deptloc_code = a.performing_deptloc_code) int_or_ext, nvl((select notify_yn from or_order_line where order_id= a.order_id and notify_yn = 'Y' and rownum <=1),'N') notify_yn,nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = a.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status, a.bill_yn, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.performing_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.performing_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id  order_set_id,to_char(b.date_of_birth,'dd/mm/yyyy') dob from or_order a ,mp_patient b , or_order_line c WHERE b.patient_id=a.patient_id and  a.patient_id = nvl((?),a.patient_id)	and nvl(a.encounter_id,0) = nvl((?),nvl(a.encounter_id,0)) AND ((a.order_category IN(SELECT order_category FROM or_result_user WHERE ((practitioner_id = ? OR resp_id = ?)AND order_type_code='*ALL')))OR( a.order_type_code IN (SELECT order_type_code FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?))))	and nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND a.order_id = nvl((?),a.order_id) and exists (select order_id from or_order_line where order_id= a.order_id and trunc(start_date_time) between to_date(nvl((?),'01/01/1000'),'dd/mm/yyyy') and least(to_date(nvl((?),'31/12/9999'),'dd/mm/yyyy'),sysdate) and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) )  and nvl(a.SOURCE_TYPE,'X')=NVL((?),nvl(a.source_TYPE,'X')) and nvl(a.SOURCE_code,'X') =NVL((?),nvl(a.source_CODE,'X')) and a.Priority=nvl((?),a.Priority) 	and a.order_category =nvl(?,a.order_category) and a.order_type_code = nvl((?),a.order_type_code) and a.performing_facility_id = ?  AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and (a.performing_appl_id IS NULL  OR a.performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and substr(a.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, a.order_category,a.order_type_code,a.order_id,a.performing_facility_id,a.performing_deptloc_type,a.performing_deptloc_code) ='Y' ##REG_CAT$$ ##SPECI$$ ##INT_OR_EXT##  ##PERFORM_LOCN$$  ##ACTVITY_TYPE$$ ##NOT_PER_LOC$$ and a.order_id = c.order_id  ##BL_PKG_CHK$$ and c.order_line_num = '1' order by order_category_short_desc,order_type_short_desc,a.ord_date_time,a.priority";//IN000000
			//sql="SELECT  a.order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,	a.Priority Priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') PATIENT_CLASS_SHORT_DESC, a.PATIENT_CLASS,a.ORDER_ID,a.patient_id, a.encounter_id,/*TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI')*/(select TO_CHAR( start_date_time,'DD/MM/YYYY HH24:MI') start_date_time from or_order_line where order_id=a.order_id and rownum=1) order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?)  order_detail,		 decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) patient_name,GET_AGE(b.DATE_OF_BIRTH) patient_age ,a.SOURCE_TYPE,a.SOURCE_CODE,a.Priority,a.ORDER_TYPE_CODE ,	 a.ORD_PRACT_ID, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1') ORDERING_PRACT_NAME, a.ORDER_STATUS, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ORDEr_STATUS_SHORT_DESC, a.ORD_COSIGN_REQD_YN,a.order_id,nvl(a.cont_order_ind,'DO') cont_order_ind, b.sex sex1, OR_ORDER_EXTERNAL_LOCATION ('REGISTER', a.ORDER_ID ,a.ORDER_TYPE_CODE) menu_text,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(select int_or_ext from or_performing_deptloc where performing_facility_id = a.performing_facility_id and performing_deptloc_type = a.performing_deptloc_type and performing_deptloc_code = a.performing_deptloc_code) int_or_ext, nvl((select notify_yn from or_order_line where order_id= a.order_id and notify_yn = 'Y' and rownum <=1),'N') notify_yn,nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = a.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status, a.bill_yn, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.performing_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.performing_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id  order_set_id,to_char(b.date_of_birth,'dd/mm/yyyy') dob from or_order a ,mp_patient b , or_order_line c WHERE b.patient_id=a.patient_id and  a.patient_id = nvl((?),a.patient_id)	and nvl(a.encounter_id,0) = nvl((?),nvl(a.encounter_id,0)) AND ((a.order_category IN(SELECT order_category FROM or_result_user WHERE ((practitioner_id = ? OR resp_id = ?)AND order_type_code='*ALL')))OR( a.order_type_code IN (SELECT order_type_code FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?))))	and nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND a.order_id = nvl((?),a.order_id) and exists (select order_id from or_order_line where order_id= a.order_id and trunc(start_date_time) between to_date(nvl((?),'01/01/1000'),'dd/mm/yyyy') and least(to_date(nvl((?),'31/12/9999'),'dd/mm/yyyy'),sysdate) and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) )  and nvl(a.SOURCE_TYPE,'X')=NVL((?),nvl(a.source_TYPE,'X')) and nvl(a.SOURCE_code,'X') =NVL((?),nvl(a.source_CODE,'X')) and a.Priority=nvl((?),a.Priority) 	and a.order_category =nvl(?,a.order_category) and a.order_type_code = nvl((?),a.order_type_code) and a.performing_facility_id = ?  AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and (a.performing_appl_id IS NULL  OR a.performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and substr(a.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, a.order_category,a.order_type_code,a.order_id,a.performing_facility_id,a.performing_deptloc_type,a.performing_deptloc_code) ='Y' ##REG_CAT$$ ##SPECI$$ ##INT_OR_EXT##  ##PERFORM_LOCN$$  ##ACTVITY_TYPE$$ ##NOT_PER_LOC$$ and a.order_id = c.order_id  ##BL_PKG_CHK$$ and c.order_line_num = '1' order by order_category_short_desc,order_type_short_desc,a.ord_date_time,a.priority";
			//IN058250 End //IN065942, commented and replaced by below query
			sql="SELECT  a.order_category, OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc, OR_GET_DESC.OR_ORDER_TYPE(a.order_type_code,?,'2') order_type_short_desc,	a.Priority Priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class, ?,'2') PATIENT_CLASS_SHORT_DESC, a.PATIENT_CLASS,a.ORDER_ID,a.patient_id, a.encounter_id,/*TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI')*/(select TO_CHAR( start_date_time,'DD/MM/YYYY HH24:MI') start_date_time from or_order_line where order_id=a.order_id and rownum=1) order_date_time , OR_GET_ORDER_CATALOG(a.order_id,a.order_type_code,?)  order_detail,		 decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) patient_name,GET_AGE(b.DATE_OF_BIRTH) patient_age ,a.SOURCE_TYPE,a.SOURCE_CODE,a.Priority,a.ORDER_TYPE_CODE ,	 a.ORD_PRACT_ID, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1') ORDERING_PRACT_NAME, a.ORDER_STATUS, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.order_status,?,'2') ORDEr_STATUS_SHORT_DESC, a.ORD_COSIGN_REQD_YN,a.order_id,nvl(a.cont_order_ind,'DO') cont_order_ind, b.sex sex1, OR_ORDER_EXTERNAL_LOCATION ('REGISTER', a.ORDER_ID ,a.ORDER_TYPE_CODE) menu_text,a.performing_facility_id performing_facility_id,a.performing_deptloc_type performing_deptloc_type,a.performing_deptloc_code performing_deptloc_code,(select int_or_ext from or_performing_deptloc where performing_facility_id = a.performing_facility_id and performing_deptloc_type = a.performing_deptloc_type and performing_deptloc_code = a.performing_deptloc_code) int_or_ext, nvl((select notify_yn from or_order_line where order_id= a.order_id and notify_yn = 'Y' and rownum <=1),'N') notify_yn,nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = a.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status, a.bill_yn, case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.performing_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.performing_facility_id,a.source_code,?,'2') end  location_description,a.order_set_id  order_set_id,to_char(b.date_of_birth,'dd/mm/yyyy') dob,case when c.order_category = 'RX' then nvl((select prn_regd_ord from or_order_catalog where order_catalog_code in(select order_catalog_code from or_order_line where order_id = a.order_id) and prn_regd_ord = 'Y' and rownum=1),'N') else 'N' end prn_reg_ord ##SPLIT_UNBILLED_YN$$ from or_order a ,mp_patient b , or_order_line c WHERE b.patient_id=a.patient_id and  a.patient_id = nvl((?),a.patient_id)	and nvl(a.encounter_id,0) = nvl((?),nvl(a.encounter_id,0)) AND ((a.order_category IN(SELECT order_category FROM or_result_user WHERE ((practitioner_id = ? OR resp_id = ?)AND order_type_code='*ALL')))OR( a.order_type_code IN (SELECT order_type_code FROM or_result_user WHERE (practitioner_id = ? OR resp_id = ?))))	and nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND a.order_id = nvl((?),a.order_id) and exists (select order_id from or_order_line where order_id= a.order_id and trunc(start_date_time) between to_date(nvl((?),'01/01/1000'),'dd/mm/yyyy') and least(to_date(nvl((?),'31/12/9999'),'dd/mm/yyyy'),sysdate) and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) )  and nvl(a.SOURCE_TYPE,'X')=NVL((?),nvl(a.source_TYPE,'X')) and nvl(a.SOURCE_code,'X') =NVL((?),nvl(a.source_CODE,'X')) and a.Priority=nvl((?),a.Priority) 	and a.order_category =nvl(?,a.order_category) and a.order_type_code = nvl((?),a.order_type_code) and a.performing_facility_id = ?  AND a.ord_date_time  BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and (a.performing_appl_id IS NULL  OR a.performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) and substr(a.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, a.order_category,a.order_type_code,a.order_id,a.performing_facility_id,a.performing_deptloc_type,a.performing_deptloc_code) ='Y' ##REG_CAT$$ ##SPECI$$ ##INT_OR_EXT##  ##PERFORM_LOCN$$  ##ACTVITY_TYPE$$ ##NOT_PER_LOC$$ and a.order_id = c.order_id  ##BL_PKG_CHK$$ and c.order_line_num = '1' order by order_category_short_desc,order_type_short_desc,a.ord_date_time,a.priority";//IN065942//IN071618
			if (specimen_no.equals(""))
			{
				sql=sql.replace("##SPECI$$","");
			}else
			{
				sql=sql.replace("##SPECI$$"," and a.order_id in (select order_id from or_order_line where accession_num = ?)");
			}
			if( int_or_ext.equals("E"))
			{
				sql=sql.replace("##INT_OR_EXT##"," and a.performing_deptloc_code in (select performing_DEPTLOC_CODE from or_performing_deptloc where performing_facility_id = a.PERFORMING_FACILITY_ID and PERFORMING_DEPTLOC_TYPE = a.PERFORMING_DEPTLOC_TYPE and performing_DEPTLOC_CODE = a.PERFORMING_DEPTLOC_CODE and INT_OR_EXT = 'X') and ORDER_STATUS in  (select order_status_code from or_order_status_code A, OR_STATUS_APPLICABILITY B  where B.OPER_OR_GROUP_REF ='REGISTER_ORD' AND A.ORDER_STATUS_TYPE =B.ORDER_STATUS_type)");
			}else if(int_or_ext.equals("R"))
			{
				sql=sql.replace("##INT_OR_EXT##"," AND a.Order_Status in (select order_Status_code from or_order_Status_code where order_Status_type ='98')");
			}else
			{
				sql=sql.replace("##INT_OR_EXT##","  and a.ORDER_STATUS in  (select order_status_code from or_order_status_code A, OR_STATUS_APPLICABILITY B  where B.OPER_OR_GROUP_REF ='REGISTER_ORD' AND A.ORDER_STATUS_TYPE =B.ORDER_STATUS_type) ");
			}
			if(performing_location_code.equals(""))
			{
				sql=sql.replace("##PERFORM_LOCN$$","");
			}
			else
			{
				sql=sql.replace("##PERFORM_LOCN$$"," and nvl(a.performing_deptloc_code,'XXX')=?");
			}
			if(activity_type.equals(""))
			{
				sql=sql.replace("##ACTVITY_TYPE$$","");
			}else
			{
				sql=sql.replace("##ACTVITY_TYPE$$"," AND exists (select 'X' from or_order_line  y where order_id = a.order_id and activity_type = ?)");
			}
			//IN31901 Starts
			
				sql=sql.replace("##NOT_PER_LOC$$"," AND decode(a.order_category,'OT',performing_deptloc_CODE,'X') IS NOT NULL ");
			
			//IN31901 Ends
			//String OTinstalled =isModuleInstalled(login_facility_id,"OT");//IN31901
			String RDinstalled =isModuleInstalled(login_facility_id,"RD");
			String BLinstalled = getBillingModuleYn(login_facility_id);//IN000000
			//Commented as part of IN31901
			/*if ((OTinstalled.equalsIgnoreCase("Y") )&&( RDinstalled.equalsIgnoreCase("Y")))
			{
				sql = sql.replace("##REG_CAT$$", " and substr(a.order_id,1,2)!='OT' and substr(a.order_id,1,2)!='RD'" );
			}
			else 	if (OTinstalled.equalsIgnoreCase("Y"))
			{
				sql = sql.replace("##REG_CAT$$", " and substr(a.order_id,1,2)!='OT'" );
			}
			else */
			if(RDinstalled.equalsIgnoreCase("Y"))
			{
				sql = sql.replace("##REG_CAT$$", " and substr(a.order_id,1,2)!='RD'" );
			}
			else
			{
				sql = sql.replace("##REG_CAT$$", " " );
			}
			//IN000000 Start
			if(BLinstalled.equalsIgnoreCase("Y"))
			{
				sql = sql.replace("##BL_PKG_CHK$$", " and ((c.billing_package_ref is null) or( (a.ord_date_time + (Select pkg_valid_days from bl_package_sub_hdr where package_seq_no = c.billing_package_ref) +(select NVL(valid_days_for_pkg_orders,'0') from bl_parameters where operating_facility_id = ?)) >= sysdate))" );
				
			}
			else
			{
				sql = sql.replace("##BL_PKG_CHK$$", " " );
			}
			//IN000000 End

			//IN071618 Starts
				sql = sql.replace("##SPLIT_UNBILLED_YN$$", ",or_reg_split_unbilled_order_yn(?,a.order_id,a.patient_id,a.encounter_id) split_unbilled_order_dtls " );
			//IN071618 Ends
			pstmt = connection.prepareStatement(sql); 
			int j=0;
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, language_id);
			pstmt.setString(++j, login_facility_id);//IN071618
			pstmt.setString(++j, patientId.trim() ) ;
			pstmt.setString(++j, encntr_id.trim() ) ;
			//IN058250 Start
			pstmt.setString(++j, practitioner_id.trim());
			pstmt.setString(++j, resp_id.trim());
			//IN058250 End
			pstmt.setString(++j, practitioner_id.trim());
			pstmt.setString(++j, resp_id.trim());
			pstmt.setString(++j, order_no.trim() ) ;
			pstmt.setString(++j, date_from.trim() ) ;
			pstmt.setString(++j, date_to.trim() ) ;
			pstmt.setString(++j, location_type.trim() ) ;
			pstmt.setString(++j, locn.trim() ) ;
			pstmt.setString(++j, priority.trim() ) ;
			pstmt.setString(++j, ord_cat.trim() ) ;
			pstmt.setString(++j, ord_type.trim() ) ;
			pstmt.setString(++j, login_facility_id);
			pstmt.setString(++j, date_from.trim());
			pstmt.setString(++j, date_to.trim());
			pstmt.setString(++j, login_value.trim());
			if(login_value.equalsIgnoreCase("pract"))
			{
				pstmt.setString(++j, practitioner_id.trim());
			}
			else if(login_value.equalsIgnoreCase("resp"))
			{
				pstmt.setString(++j, resp_id.trim());
			}
		
		    if (!specimen_no.equals(""))
			{
				pstmt.setString(++j, specimen_no.trim());
			}	
			if(!performing_location_code.equals(""))
			{
				pstmt.setString(++j, performing_location_code.trim());
			}
			if(!activity_type.equals(""))
			{
				pstmt.setString(++j,activity_type.trim());
			
			}
			//IN000000
			if("Y".equals(BLinstalled))
				pstmt.setString(++j, login_facility_id);
			
			resultSet = pstmt.executeQuery() ;

			
			if(resultSet!=null) {
				
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				
				while ( start <= end && resultSet!=null && resultSet.next()) {

					//String[] record=new String[30];
					String[] record=new String[32];//IN071618
					
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "order_category_short_desc" )  ;
					record[2] = resultSet.getString( "order_id" )  ;
					record[3] = resultSet.getString( "order_date_time" )  ;
					record[4] = resultSet.getString( "Priority_desc" )  ;
					record[5] = resultSet.getString( "Priority" )  ;
					record[6] = resultSet.getString( "order_detail" )  ;
					record[7] = resultSet.getString( "patient_name" )  ;//resultSet.getString( "encounter_dtls" )  ;
					record[8] = resultSet.getString( "order_type_code" )  ;
					record[9] = resultSet.getString( "order_type_short_desc" )  ;


					if((view_order.trim()).equals("L")){
						record[10] = resultSet.getString( "order_line_num" )  ;
					}else{
						record[10] = resultSet.getString( "cont_order_ind" )  ;
					}
						record[11] = resultSet.getString( "patient_id" )  ;
						record[12] = resultSet.getString( "sex1" )  ;
						record[13] = resultSet.getString( "menu_text" )  ;
						record[14] = (resultSet.getString( "performing_facility_id" ) == null) ? "" : resultSet.getString( "performing_facility_id" );
						record[15] = (resultSet.getString( "performing_deptloc_type" ) == null) ? "" : resultSet.getString( "performing_deptloc_type" ) ;
						record[16] = (resultSet.getString( "performing_deptloc_code" ) == null) ? "" : resultSet.getString( "performing_deptloc_code" ) ;
						record[17] = (resultSet.getString( "encounter_id" ) == null) ? "" : resultSet.getString( "encounter_id" ) ;
						record[18] = (resultSet.getString( "int_or_ext" ) == null) ? "" : resultSet.getString( "int_or_ext" ) ;
						record[19] = resultSet.getString( "patient_class" )  ;
						record[20] = resultSet.getString( "source_type" )  ;
						record[21] = resultSet.getString( "source_code" )  ;
						record[22] = (resultSet.getString( "notify_yn" ) == null) ? "N" : resultSet.getString( "notify_yn" ) ;
						record[23] = (resultSet.getString( "consent_status" ) == null) ? "" : resultSet.getString( "consent_status" ) ;
						record[24] = (resultSet.getString( "bill_yn" ) == null) ? "N" : resultSet.getString( "bill_yn" ) ;
						record[25] = (resultSet.getString( "patient_age" ) == null) ? "" : resultSet.getString( "patient_age" ) ;
						record[26] = (resultSet.getString( "location_description" ) == null) ? "" : resultSet.getString( "location_description" ) ;
						record[27] = (resultSet.getString("order_set_id" ) == null) ? "" : resultSet.getString("order_set_id" ) ;
						record[28] = (resultSet.getString("dob" ) == null) ? "" : resultSet.getString("dob" ) ;
						record[29] = (resultSet.getString("prn_reg_ord" ) == null) ? "" : resultSet.getString("prn_reg_ord" ) ;//IN065942
						record[30] = (resultSet.getString("split_unbilled_order_dtls" ) == null) ? "" : resultSet.getString("split_unbilled_order_dtls" ) ;//IN071618


					OrderCat.add(record) ;
					start++;
				  }
				  if (resultSet.next())
				{
					String[] templist = (String[])OrderCat.get(0);
					//templist[29] = ""+(end+7);//IN065942
					templist[31] = ""+(end+7);//IN065942 //IN071618
					OrderCat.set(0,templist);
				}
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

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try{
			map = registerOrder();
		}catch(Exception e){
			System.err.println("Insert"+e.toString());
		}

		return map;
	}


/**
	@return		:	ArrayList
*/

	public HashMap registerOrder() throws Exception {
		//System.out.println("Just Entered in to the Bean of register order method");
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;

		String order_status_code 	= "";
		String order_id = "";
		String line_id = "";
		String vw_by = "";
		String cont_order_ind = "";
		String appt_ref_num	= "", encounter_id = "";
		String order_set_id="";
		String order_set_bill_yn="N";
		//int result = 0;
		int count = 0;
		String order_category = "";//IN065942
		String prn_reg_ord = "";//IN065942

		traceVals.append("total recs rt :  >"+total_records);
		//IN071618 Starts
		String which_page = "";
		ArrayList UnBillOrders = new ArrayList();	
		String[] billing_details =new String[21];
		HashMap setBills_dtls = new HashMap();
		String servicepanel="";
		String incl_action="";
		String servicepanelcode="";
		String reRoutePrinterId = "";//IN064835
		int cnt = 0;
		HashMap order_detail	 = new HashMap() ;
		//IN071618 Starts
		if(allValues.contains(called_from) && ((String)allValues.get("called_from")).equalsIgnoreCase("unbilled_order_split"))
		{
			StringTokenizer dtls = new StringTokenizer(((String)allValues.get("order_details")),"!");
			while(dtls.hasMoreTokens())
			{
				String str2 = dtls.nextToken();	
				StringTokenizer str3 = new StringTokenizer(str2,"^");
				while(str3.hasMoreTokens())
				{
					String[] record = new String[3];
					record[0] = str3.nextToken();	
					order_id = record[0];
					record[1] = str3.nextToken();
					record[2] = str3.nextToken();
					UnBillOrders.add(record);
				}
			}
		TreeMap NewFutureOrders    = new TreeMap();
		ArrayList UnBillOrderDetail = new ArrayList();	
		ArrayList BillChargeInfo    = new ArrayList();
		PreparedStatement pstmt1 	= null;
		UnBillOrderDetail = getUnBilledOrderDetails( performing_facility,patient_id,called_from,order_id,encntr_id) ;

		try 
		{
			connection = getConnection() ;
			try
			{	
				sqlMap.put("SQL_OR_FUTURE_ORDER_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_UPDATE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_LINE_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_LINE_UPDATE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_STATUS") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_REG_COMPLETE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_REG_COMPLETE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_SELECT",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_SELECT") );
				sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_NEW_ORDER",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_NEW_ORDER") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_CANCEL_LINE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_CANCEL_LINE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
				sqlMap.put("SQL_OR_ORDER_GET_STATUS_CODE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_UPDATE_ORDER_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_UPDATE_ORDER_STATUS") );
			}
				catch(Exception e)
				{
					e.printStackTrace();
					map.put( "message", e.getMessage() ) ;
				}
				int no_of_occurance =  UnBillOrderDetail.size() ;
				//int int_total_records = no_of_occurance; //Checkstyle
				String p_episode_visit_num = "";
				String p_source_code = "";
				String p_source_type = "";
				String p_episode_id = "";
				String p_patient_class = "";
				
				
				for(int i=0; i<UnBillOrderDetail.size(); i++)
				{
					String[] UnBillOrdDtl = (String[]) UnBillOrderDetail.get(i);
					for(int j=0;j<UnBillOrders.size();j++)
					{
						String[] UnBillOrds = (String[]) UnBillOrders.get(j);
						if(UnBillOrdDtl[5].equals(UnBillOrds[1]))
						{
							if(!order_detail.containsKey((((String)UnBillOrdDtl[25])+(String)UnBillOrdDtl[5])))
							{
								BillChargeInfo		= getBillChargeDetails(UnBillOrdDtl[28],UnBillOrdDtl[27],UnBillOrdDtl[30], language_id,"", "",patient_id,encntr_id,UnBillOrdDtl[4],UnBillOrdDtl[16]) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
								
								if(BillChargeInfo!=null)
								{
								
									for( int kb=0 ; kb< BillChargeInfo.size() ; kb++ ) 
									{
										billing_details 	= (String[])BillChargeInfo.get(kb);
									
										setBills_dtls		= new HashMap();
				
										setBills_dtls.put("charged_yn"       , billing_details[1]);
										setBills_dtls.put("total_payable"    , billing_details[2]);
										setBills_dtls.put("patient_payable"  , billing_details[3]);
										setBills_dtls.put("quantity"         , UnBillOrdDtl[28]);
										setBills_dtls.put("incl_excl_action" , billing_details[4]);
										setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
										setBills_dtls.put("preapp_yn"        , billing_details[5]);
										setBills_dtls.put("patient_paid_amt" , billing_details[6]);
										setBills_dtls.put("bl_panel_str"     , billing_details[0]);
										setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
										setBills_dtls.put("serv_panel_code"  , billing_details[11]);
										setBills_dtls.put("p_episode_type"	 , billing_details[13]);
										setBills_dtls.put("p_episode_id"	 , billing_details[14]);
										setBills_dtls.put("p_visit_id"		 , billing_details[15]);
										setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
										setBills_dtls.put("error_text"		 , billing_details[9]);
										setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
										setBills_dtls.put("rate"		 ,"");
										servicepanel=checkForNull(billing_details[10],"");
										servicepanelcode=checkForNull(billing_details[11],"");
										incl_action=checkForNull(billing_details[16],"");
										if("".equals(p_episode_visit_num))
											p_episode_visit_num = billing_details[15];
										if("".equals(p_episode_id))
											p_episode_id = billing_details[14];
											
									}
								}
								order_detail = new HashMap();
								order_detail.put("order_id",(String)UnBillOrdDtl[25]);		
								order_detail.put("order_id"+order_id,no_of_occurance);		
								order_detail.put("billing_revise_dtls"+order_id+(String)UnBillOrdDtl[5],setBills_dtls);
								order_detail.put("servicepanelind",(String)allValues.get("servicepanelind"+i));
								order_detail.put("servicepanelcode",(String)allValues.get("servicepanelcode"+i));
								order_detail.put("incl_excl_action",(String)allValues.get("incl_excl_action"+i));
								order_detail.put("incl_excl_action_reason",(String)allValues.get("incl_excl_action_reason"+i));
								order_detail.put("bill_yn",(String)UnBillOrdDtl[26]);					   
								order_detail.put("contr_mod_id",(String)UnBillOrdDtl[29]);					   
								order_detail.put("order_line_num",(String)UnBillOrdDtl[5]);			   
								order_detail.put("catalog_code",(String)UnBillOrdDtl[27]);			   
								order_detail.put("catalog_desc",(String)allValues.get("catalog_desc"+i));			   
								order_detail.put("ord_pract_id",(String)UnBillOrdDtl[16]);					   
								order_detail.put("quantity",(String)UnBillOrdDtl[28]);					   
								order_detail.put("start_date_time",(String)UnBillOrdDtl[30]);				   
								order_detail.put("order_line_num"+order_id,UnBillOrdDtl[5]);		
								order_detail.put("billing_package_ref",UnBillOrdDtl[32]);	
								NewFutureOrders.put((order_id+(String)UnBillOrdDtl[5]),order_detail);
								if("".equals(p_patient_class))
									p_patient_class = UnBillOrdDtl[4];
								if("".equals(p_source_type))
									p_source_type = UnBillOrdDtl[11];
								if("".equals(p_source_code))
									p_source_code = UnBillOrdDtl[12];
								cnt++;
							}
						}
					}
				}
				updt_map1.put("source","unbilled_order_split");
				updt_map1.put( "totalCount"		  , ""+cnt);
				updt_map1.put( "locale"		  , ""+language_id);
				updt_map1.put("future_value",NewFutureOrders);
				updt_map1.put("which_page",which_page);
				updt_map1.put( "login_by_id",login_by_id ) ;
				updt_map1.put( "login_at_ws_no",login_at_ws_no ) ;
				updt_map1.put( "login_facility_id",login_facility_id ) ;
				updt_map1.put( "p_patient_class",p_patient_class) ;
				updt_map1.put( "p_patient_id",patient_id) ;
				updt_map1.put( "p_episode_id",p_episode_id) ;
				updt_map1.put( "p_episode_visit_num",p_episode_visit_num) ;
				updt_map1.put( "p_source_type",p_source_type) ;
				updt_map1.put( "p_source_code",p_source_code) ;
				updt_map1.put( "p_encounter_id",encntr_id) ;
				updt_map1.put( "re_route_printer_id",reRoutePrinterId) ;//IN064835

				updt_map1.put( "isBTViewBillDtls",String.valueOf(isSiteSpecific("BT_VIEW_BILL_DTLS")));//IN065324


				
				try 
				{
					updt_map1.put( "properties", getProperties() );
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI"), ORCancelDiscontinueOrderHome.class, getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[]	= new Object[2];
						argArray[0]		= updt_map1;
						argArray[1]		= sqlMap;
					Class [] paramArray = new Class[2];
						paramArray[0]	= updt_map1.getClass();
						paramArray[1]	= sqlMap.getClass();
					map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					argArray	= null;
					paramArray	= null;
					if(((Boolean) map.get( "result" )).booleanValue())
					{
						map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
					}
					else
					{
						map.put( "message",  (String) map.get( "message" )) ;
					}
					map.put("traceVal", (String)tmpBuff.toString());
					tmpBuff.setLength(0);

				} 
				catch(Exception e) 
				{
					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
				} 
				finally 
				{
					clear();			
				}
			} 
			catch ( Exception e )	
			{
				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				closeStatement( pstmt ) ;
				closeStatement( pstmt1) ;
				closeResultSet( resultSet ) ;
				closeConnection(connection);
			}
			return map;
		}
		else{//IN071618 Ends
		try {
			int int_total_records = Integer.parseInt(total_records);
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_GET_ORDER_STATUS_CODE") ) ;
			pstmt.setString(1,"25");
			for(int i=0; i<int_total_records; i++){
//				traceVals.append("--all value :  >"+allValues);
//				traceVals.append("--Chk value :  >"+allValues.get("chk"+i));
				if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){
					//System.out.println("For the i value in the loop="+i);
					order_id= (String)allValues.get("ord_id"+i);
					cont_order_ind= (String)allValues.get("cont_order_ind"+i);
				//	cont_order_ind = "DO";
					appt_ref_num= (String)allValues.get("appt_ref_num"+i);
					encounter_id = (String)allValues.get("encounter_id"+i);
					order_set_id =(((String)allValues.get("order_set_id"+i))==null?"":((String)allValues.get("order_set_id"+i)));
					order_set_bill_yn=(((String)getOrderSetDetails(order_set_id))==null?"N":((String)getOrderSetDetails(order_set_id)));
					order_category = (((String)allValues.get("order_category"+i))==null?"":((String)allValues.get("order_category"+i)));//IN065942
					prn_reg_ord = (((String)allValues.get("prn_reg_ord"+i))==null?"":((String)allValues.get("prn_reg_ord"+i)));//IN065942

					vw_by= (String)allValues.get("view_by"+i);
					if(allValues.containsKey("line_id"+i)){
						line_id= (String)allValues.get("line_id"+i);
						line_id = line_id.trim();
					}
					order_id = order_id.trim();
					vw_by = vw_by.trim();

/*					traceVals.append("COUNTTT : order_id >"+order_id);
					traceVals.append(" : line_id >"+line_id);
					traceVals.append(" : view_by >"+vw_by);*/
					//connection = getConnection() ;

					traceVals.append("connection : >"+connection);
					//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_GET_ORDER_STATUS_CODE") ) ;
						//pstmt.setString(1,"25");
					try{
					resultSet = pstmt.executeQuery() ;
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
						System.err.println("SQL_OR_GET_ORDER_STATUS_CODE Query Execution failed");
					}

					try{
						sqlMap.put("SQL_OR_REGISTER_ORDER_UPDT",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_UPDT") );
						sqlMap.put("SQL_OR_REGISTER_ORDER_UPDT_HDR",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_UPDT_HDR") );
						sqlMap.put("SQL_OR_REGISTER_ORDER_UPDT_FREQ_EXPL",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_UPDT_FREQ_EXPL") );
						sqlMap.put("SQL_OR_REGISTER_ORDER_UPDT_HDR_FREQ_EXPL",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_UPDT_HDR_FREQ_EXPL") );
						sqlMap.put("SQL_OR_REGISTER_ORDER_UPDT_LINE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_UPDT_LINE") );
						sqlMap.put("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER") );
						sqlMap.put("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER_UPDT",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER_UPDT") );
						sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
						sqlMap.put("SQL_OR_REGISTER_ORDER_APPT_REF_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_APPT_REF_UPDATE") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_CODE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );

						
					}catch(Exception e){
						System.err.println("Exception in getting the queries from the repository"+e.toString());
					}

					if( resultSet != null && resultSet.next() ) {
						order_status_code= resultSet.getString( "order_status_code" )  ;
						//System.out.println("For the query SQL_OR_GET_ORDER_STATUS_CODE the order_status_code="+order_status_code);
//						traceVals.append("^^resultSet : ^"+resultSet.getString(1));
					}
					closeResultSet( resultSet ) ;
					String[] updt_data ;

					if(vw_by.equals("H")) 		updt_data = new String[11];
					else								updt_data = new String[11];


					updt_data[0] = (String)order_status_code;
					updt_data[1] = (String)order_id;
					if(vw_by.equals("L"))
						updt_data[2] = (String)line_id;
					else if (vw_by.equals("H"))
						updt_data[2] = "";

					updt_data[3] = login_facility_id;
					updt_data[4] = login_by_id;
					updt_data[5] = login_at_ws_no;
					updt_data[6] = getPractitioner_id();
					updt_data[7] = (appt_ref_num==null)?"":appt_ref_num;
					updt_data[8] = (encounter_id==null)?"":encounter_id;
					updt_data[9] = (order_set_id==null)?"":order_set_id;
					updt_data[10] = (order_set_bill_yn==null)?"":order_set_bill_yn;
 
					updt_map1.put("data"+count ,updt_data);
					updt_map1.put("view_by"+count,vw_by);
					updt_map1.put("cont_order_ind"+count,cont_order_ind);

					//IN065942, starts
					if("Y".equals(prn_reg_ord) && "RX".equals(order_category))
					{
						printLabelValues.put("order_id"+count,order_id);
						printLabelValues.put("order_line_no"+count,updt_data[2]);
						printLabelValues.put("view_by"+count,vw_by);
					}
					//IN065942, ends


					count++;
					//System.out.println("updt_data values for i="+i+"the values are="+updt_data);
					//System.out.println("updt_map1 values for i="+i+"the values are="+updt_map1);
				}//end of if condition
			}//end of for loop

//			traceVals.append("^^final updt_map1 : ^"+updt_map1);
			//System.out.println("Total count==="+count);
			updt_map1.put("totalCount",""+count);
			//IN065942, starts
			if(printLabelValues.size()>0)
			{
				printLabelValues.put("prn_lab_cnt",String.valueOf(count));
				printLabelValues.put("facility_id",login_facility_id);
				printLabelValues.put("pract_type",getPractitionerType());
				printLabelValues.put("module_id","OR");
				printLabelValues.put("func_name","REG_ORD");
				System.out.println("RO.java,1154,printLabelValues=>"+printLabelValues);
			}
			//IN065942, ends
			/*updt_map1.put( "login_by_id",login_by_id ) ;
			updt_map1.put( "login_at_ws_no",login_at_ws_no ) ;
        	updt_map1.put( "login_facility_id",login_facility_id ) ;*/

			//ORRegisterOrderHome home = null ;
			//ORRegisterOrderRemote remote = null ;

			try {
					updt_map1.put( "properties", getProperties() );

					/*InitialContext context = new InitialContext() ;
					Object object = context.lookup( OrRepository.getOrKeyValue("OR_REGISTER_ORDER_JNDI") ) ;
					home  = (ORRegisterOrderHome) PortableRemoteObject.narrow( object, ORRegisterOrderHome.class ) ;
					
					remote = home.create() ;
					map = remote.insert( updt_map1, sqlMap ) ; */

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_REGISTER_ORDER_JNDI"), ORRegisterOrderHome.class, getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[]	= new Object[2];
						argArray[0]		= updt_map1;
						argArray[1]		= sqlMap;
					Class [] paramArray = new Class[2];
						paramArray[0]	= updt_map1.getClass();
						paramArray[1]	= sqlMap.getClass();
					map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
							
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					argArray	= null;
					paramArray	= null;
					//System.out.println("=="+map);
					if( ((Boolean) map.get( "result" )).booleanValue() ){
					//System.out.println("After calling the ejb=="+(String) map.get( "message" ));
					map.put( "message", getMessagess(language_id, (String) map.get( "message" ), "SM")) ;
					}
					map.put("traceVal", (String)tmpBuff.toString());
					tmpBuff.setLength(0);

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

		//	map  = updateValues(connection, updt_map1, sqlMap);

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}
	}//IN071618 
		map.put("traceVal", traceVals.toString());
		return map;
	}


/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
			//System.err.println("========="+recordSet+"=======");
			allValues = recordSet;
			//System.out.println("==="+recordSet);
			if(recordSet.containsKey("order_category")){setOrderCategory((String)recordSet.get("order_category"));}
			
			if(recordSet.containsKey("order_line_num")){setOrderLineNum((String)recordSet.get("order_line_num"));}
			if(recordSet.containsKey("cont_order_ind")){setOrderLineNum((String)recordSet.get("cont_order_ind"));}
			
			if(recordSet.containsKey("total_recs")){		setTotalRecs((String)recordSet.get("total_recs"));	}
			if(recordSet.containsKey("practitioner_id")){		setPractitioner_id((String)recordSet.get("practitioner_id"));	}
			if(recordSet.containsKey("order_type_code")){		setOrderType((String)recordSet.get("order_type_code"));	}
			if(recordSet.containsKey("priority")){			setPriority((String)recordSet.get("priority"));}
			if(recordSet.containsKey("performing_deptloc_type")){ 	setLocationType((String)recordSet.get("performing_deptloc_type"));}
			if(recordSet.containsKey("performing_deptloc_code")){				setLocation((String)recordSet.get("performing_deptloc_code"));	}
			if(recordSet.containsKey("patient_id")){		setPatientId((String)recordSet.get("patient_id"));}
			if(recordSet.containsKey("patient_class")){		setPatientClass((String)recordSet.get("patient_class"));}
			if(recordSet.containsKey("encounter_id")){  		setEncntrId((String)recordSet.get("encounter_id"));}
			if(recordSet.containsKey("order_no")){		setOrderId((String)recordSet.get("order_no"));	}
			if(recordSet.containsKey("source_type")){		setSourceType((String)recordSet.get("source_type"));	}
			if(recordSet.containsKey("source_code")){		setSourceCode((String)recordSet.get("source_code"));	}
			/* Thai date validations start 16/02/2007*/
		if (!language_id.equals("en")){
		if(recordSet.containsKey("date_from"))
			{
				String date_from = (String)recordSet.get("date_from");
				if ( date_from==null || date_from.equals(" ") || date_from.equals("null")) date_from="";
				date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
				recordSet.put("date_from",date_from);
			}
			if(recordSet.containsKey("date_to"))
			{
				String date_to = (String)recordSet.get("date_to");
				if (date_to==null || date_to.equals(" ") || date_to.equals("null")) date_to="";
				date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
				recordSet.put("date_to",date_to);
			}
			if(recordSet.containsKey("ref_date_time"))
			{
				String ref_date_time = (String)recordSet.get("ref_date_time");
				if (ref_date_time==null || ref_date_time.equals(" ") || ref_date_time.equals("null")) ref_date_time="";
				ref_date_time = com.ehis.util.DateUtils.convertDate(ref_date_time,"DMYHM",language_id,"en");
				recordSet.put("ref_date_time",ref_date_time);
			}
			if(recordSet.containsKey("ref_report_date_time"))
			{
				String ref_report_date_time = (String)recordSet.get("ref_report_date_time");
				if (ref_report_date_time==null || ref_report_date_time.equals(" ") || ref_report_date_time.equals("null")) ref_report_date_time="";
				ref_report_date_time = com.ehis.util.DateUtils.convertDate(ref_report_date_time,"DMYHM",language_id,"en");
				recordSet.put("ref_report_date_time",ref_report_date_time);
			}
			if(recordSet.containsKey("ref_recieved_date_time"))
			{
				String ref_recieved_date_time = (String)recordSet.get("ref_recieved_date_time");
				if (ref_recieved_date_time==null || ref_recieved_date_time.equals(" ") || ref_recieved_date_time.equals("null")) ref_recieved_date_time="";
				ref_recieved_date_time = com.ehis.util.DateUtils.convertDate(ref_recieved_date_time,"DMYHM",language_id,"en");
				recordSet.put("ref_recieved_date_time",ref_recieved_date_time);
			}
		
		
		}
		/* Thai date validations end 16/02/2007*/
			//System.err.println("====="+date_from+date_to+ref_date_time+ref_report_date_time+ref_recieved_date_time);

			if(recordSet.containsKey("date_from")){		setDateFrom((String)recordSet.get("date_from"));}
			if(recordSet.containsKey("date_to")){			setDateTo((String)recordSet.get("date_to"));}
			if(recordSet.containsKey("view_by")){			setViewBy((String)recordSet.get("view_by"));}
			if(recordSet.containsKey("order_catalog_code")){			setOrderCatalogCode((String)recordSet.get("order_catalog_code"));}
			if(recordSet.containsKey("order_catalog_desc")){			setOrderCatalogDesc((String)recordSet.get("order_catalog_desc"));}
			if(recordSet.containsKey("performing_facility")){			setPerformingFacility((String)recordSet.get("performing_facility"));}
			if(recordSet.containsKey("performing_location")){			setPerformingLocation((String)recordSet.get("performing_location"));}
			if(recordSet.containsKey("performing_location_type")){			setPerformingLocationType((String)recordSet.get("performing_location_type"));}
			if(recordSet.containsKey("function_from")){			setFunctionFrom((String)recordSet.get("function_from"));}

			if(recordSet.containsKey("ref_facility_id")){			setRefFacilityId((String)recordSet.get("ref_facility_id"));}
			if(recordSet.containsKey("ref_date_time")){				setRefDateTime((String)recordSet.get("ref_date_time"));}
			if(recordSet.containsKey("ref_sent_pract_id")){			setRefSentPractId ((String)recordSet.get("ref_sent_pract_id"));}
			if(recordSet.containsKey("ref_sent_remarks")){			setRefSentRemarks((String)recordSet.get("ref_sent_remarks"));}
			if(recordSet.containsKey("ref_report_pract_id")){		setRefReportPractId((String)recordSet.get("ref_report_pract_id"));}
			if(recordSet.containsKey("ref_report_date_time")){		setRefReportDateTime((String)recordSet.get("ref_report_date_time"));}
			if(recordSet.containsKey("ref_recieved_date_time")){	setRefRecievedDateTime((String)recordSet.get("ref_recieved_date_time"));}
			if(recordSet.containsKey("ref_recieved_pract_id")){		setRefRecievedPractId((String)recordSet.get("ref_recieved_pract_id"));}
			if(recordSet.containsKey("ref_recieved_remarks")){		setRefRecievedRemarks((String)recordSet.get("ref_recieved_remarks"));}
			if(recordSet.containsKey("ref_form_content")){			setRefFormContent((String)recordSet.get("ref_form_content"));}
			if(recordSet.containsKey("ref_form_id")){			setRefFormId((String)recordSet.get("ref_form_id"));}
			//System.err.println("mode"+mode);
			if(recordSet.containsKey("pract_type")){			setPractitionerType((String)recordSet.get("pract_type"));}//IN065942
			this.mode = (String)recordSet.get( "mode" );
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
				currentDate.add(resultSet.getString("sys_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
            try{ 
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				System.err.println("finally"+e.toString());
			}
		}


		return currentDate;
	}

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

			//System.out.println("loc_code="+loc_code+",loc_type="+loc_type+",login_facility_id="+login_facility_id);

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				int_or_ext = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
            try{ 
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				System.err.println("finally"+e.toString());
			}
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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
            try{ 
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				System.err.println("finally"+e.toString());
			}
		}

		return facility_details;
	}

	public ArrayList getPerformingLocationDetails(String performing_facility,String ord_cat,String order_catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  location_details	= new ArrayList();
		//System.out.println("==="+language_id+"==="+performing_facility+"==="+ord_cat+"==="+order_catalog_code+"===");
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2,performing_facility);
			pstmt.setString(3,ord_cat);
			pstmt.setString(4,order_catalog_code);
			//System.out.println("==="+language_id+"==="+performing_facility+"==="+ord_cat+"==="+order_catalog_code+"===");
			resultSet = pstmt.executeQuery() ;

			while ( resultSet.next() ) {
			    String record [] = new String[2];
                record[0] = resultSet.getString("code");
				record[1] = resultSet.getString("short_desc");
				location_details.add(record);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
            try{ 
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				System.err.println("finally"+e.toString());
			}
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
			//System.out.println("order_id="+order_id+",order_line_num="+order_line_num);
			pstmt.setString( 1, order_id.trim() ) ;
			pstmt.setString( 2, order_line_num.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				order_catalog_code = resultSet.getString(1)  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
            try{ 
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				System.err.println("finally"+e.toString());
			}
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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
			}catch(Exception e){
				System.err.println("finally"+e.toString());
		}
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
			System.err.println( "Error loading values from database" ) ;
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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
			}catch(Exception e){
				System.err.println("finally"+e.toString());
		}
		}
		return ReferredDetails;
	}

    public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try{
			map = updatePerformingLocationDetails(performing_facility,performing_location,order_id,function_from);
		}catch(Exception e){
			System.err.println("Modify "+e.toString());
		}

		return map;
	}
/*This will update the information when the Order is sent out from the register order*/
	public HashMap updatePerformingLocationDetails(String performing_facility,String performing_location,String order_id,String function_from) {
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();

		HashMap updt_map = new HashMap();
		HashMap sqlMap = new HashMap();

		map.put("result", new Boolean(false));
                
		/*map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put("message","RECORD_MODIFIED");

		System.out.println("result="+((Boolean)map.get("result")).booleanValue());*/
		try{
			sqlMap.put("SQL_OR_REGISTER_ORDER_PERFROM_LOCN_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_PERFROM_LOCN_UPDATE") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_SENT_OUT_HDR_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SENT_OUT_HDR_UPDATE") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_SENT_OUT_DTL_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_SENT_OUT_DTL_UPDATE") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_HDR_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_HDR_UPDATE") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_DTL_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_DTL_UPDATE") );
			sqlMap.put("SQL_OR_CONSENT_ORDER_INSERT_OR_REFUSAL_ORDERABLE",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_INSERT_OR_REFUSAL_ORDERABLE") );

			sqlMap.put("SQL_OR_REGISTER_ORDER_INSERT_OR_REFUSAL_ORDERABLE",OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_INSERT_OR_REFUSAL_ORDERABLE") );
			sqlMap.put("SQL_OR_REFUSAL_ORDER_SRL_NO",OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_SRL_NO") );
			sqlMap.put("SQL_OR_REGISTER_ORDER_FORM_UPDATE_CLOB",OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_FORM_UPDATE_CLOB") );

			updt_map.put("order_id",				order_id);
			updt_map.put("order_line_num",			order_line_num);
			updt_map.put("patient_id",				patient_id);
			updt_map.put("patient_class",			patient_class);
			updt_map.put("order_catalog_code",		order_catalog_code);
			updt_map.put("order_catalog_desc",		order_catalog_desc);
			updt_map.put("order_type_code",			order_type_code);
			updt_map.put("encounter_id",			encntr_id);
			updt_map.put("priority",				priority);
			//updt_map.put("order_line_num",
			/*updt_map.put("location_type",			location_type);
			updt_map.put("locn",					locn);*/
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

		/*	System.out.println("order_id="+order_id+",ref_facility_id="+ref_facility_id+",ref_date_time="+ref_date_time+",ref_sent_pract_id="+ref_sent_pract_id+",ref_sent_remarks="+ref_sent_remarks);
			System.out.println("ref_consent_content="+consent_content+",order_id="+order_id+",order_line_num="+order_line_num+",patient_id="+patient_id+",patient_class="+patient_class+",ref_form_id="+ref_form_id);
			System.out.println("order_catalog_code="+order_catalog_code+",order_catalog_desc="+order_catalog_desc+",encounter_id="+encntr_id+",priority="+priority+",login_facility_id="+login_facility_id+",login_by_id="+login_by_id+",login_at_ws_no="+login_at_ws_no);
			System.out.println("performing_facility="+performing_facility+",performing_location="+performing_location+",performing_location_type="+performing_location_type+",function_from="+function_from);
		*/
		}catch(Exception e){
			System.err.println("Error while getting sqlMap"+e);
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
					map.put( "message", getMessagess(language_id, (String) map.get( "message" ), "SM")) ;
				}
				else
				{
					map.put( "message", getMessagess(language_id, (String) map.get( "message" ), "Common")) ;
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

				
				/*if(((Boolean)map.get("result")).booleanValue())
					map.put("message", (String)map.get("message"));
				else
					map.put("message", (String)map.get("message"));*/

				
				String msgAftInsert = ((String)map.get("message")).trim();
				if(msgAftInsert.equalsIgnoreCase("RECORD_MODIFIED"))
				{
					clearBean();
				}
		
				//HashMap retHashMap = (HashMap )hashmap.get("NoOfRecords");
				//String temp[] = new String[2];
			
				if (map.containsKey("printVal")) {
					allValues = (Hashtable)map.get("printVal");
				} else {
					allValues = new Hashtable();
				}


				//System.out.println("map=" + map);

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
			if ( resultSet != null && resultSet.next() ) {
 				int_or_ext = resultSet.getString("int_or_ext")  ; 
				if (int_or_ext == null) int_or_ext = ""; 
			} 
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
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
			System.err.println( "Error loading values from database" ) ;
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
					System.err.println("finally"+e.toString());
				}
			}
			//System.err.println(" getConsentContent(id)  " + text);
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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return Ordercatalog;
	}

	/*This will retrieve the appt_ref_num */
	public String getApptRefNum(String order_id) throws Exception 
	{
		Connection connection	= null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset		= null;
		String appt_ref_num		= "";
		try
		{
				connection = getConnection();
				preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_APPT_REF_SELECT"));
				preparedstatement.setString(1, order_id.trim());
				preparedstatement.setString(2, "1"); //for line no 1, 
				resultset = preparedstatement.executeQuery();
				while ( resultset != null && resultset.next() )
				{
					appt_ref_num = (resultset.getString( "appt_ref_num" ) == null) ? "" : resultset.getString( "appt_ref_num" );
				}
		}
		catch(Exception exception)
		{
				exception.printStackTrace();
		}
		finally
		{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
		}
 			return appt_ref_num;
	}
	public String  isPerformingLocnYN(String responsibility_id, String practitioner_id, String order_category,String order_type,String login_value) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String performing_locn_yn 	= "N";

		//System.out.println("order_category : "+order_category);
		//System.out.println("practitioner_id : "+practitioner_id);
		//System.out.println("responsibility_id : "+responsibility_id);
		//System.out.println("order_type : "+order_type);

		try {
			connection = getConnection() ;
			if(order_type == null)
				order_type = "";
			if(login_value.equalsIgnoreCase("pract"))
			{

			if(!order_type.equals("*ALL")){
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORDTYPE_PERFORM_LOCN_YN_ALL") ) ;
				pstmt.setString(1, practitioner_id.trim());
				pstmt.setString(2, order_category.trim());

				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null && resultSet.next() ) {
					performing_locn_yn = resultSet.getString(1)  ;
					performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();
					//System.out.println("SDSD");
				}
//System.out.println("performing_locn_yn 1: "+performing_locn_yn);
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
			}
			}
			if(login_value.equalsIgnoreCase("pract"))
			{
			if(performing_locn_yn.equals("N")) {
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORDTYPE_PERFORM_LOCN_YN") ) ;
							
				pstmt.setString(1, practitioner_id.trim());
				pstmt.setString(2, order_category.trim());
				pstmt.setString(3, order_type.trim());

				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null && resultSet.next() ) {
					performing_locn_yn = resultSet.getString(1)  ;
					performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();
					//System.out.println("SDSD");
				}
				//System.out.println("performing_locn_yn 2: "+performing_locn_yn);
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
			}
			}
		if(login_value.equalsIgnoreCase("resp"))
			{
			if(performing_locn_yn.equals("N") && !order_type.equals("*ALL")) {

				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORDTYPE_RESP_PERFORM_LOCN_YN_ALL") ) ;
				
				pstmt.setString(1, responsibility_id.trim());
				pstmt.setString(2, order_category.trim());
				
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					performing_locn_yn = resultSet.getString(1)  ;
					performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();
					//System.out.println("SDSD");
				}
				//System.out.println("performing_locn_yn 3: "+performing_locn_yn);
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
			}
			}
			if(login_value.equalsIgnoreCase("resp"))
			{
			if(performing_locn_yn.equals("N")) {

				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_ORDTYPE_RESP_PERFORM_LOCN_YN") ) ;
				
				pstmt.setString(1, responsibility_id.trim());
				pstmt.setString(2, order_category.trim());
				pstmt.setString(3, order_type.trim());

				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					performing_locn_yn = resultSet.getString(1)  ;
					performing_locn_yn = (performing_locn_yn == null) ? "N" : performing_locn_yn.trim().toUpperCase();
					//System.out.println("SDSD");
				}else{
					performing_locn_yn  = "N";
					//System.out.println("eeeee");
				}
			}
				//System.out.println("performing_locn_yn 4: "+performing_locn_yn);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database"+e ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return performing_locn_yn;
	}
	/***
 *Method called before trasaction where validations should take place.
 * @return      HashMap containing the error information.
 * @throws Exception
*/
    public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
		
		String order_id = "";
		String valid_operational_yn = "";
		
		if(mode.equals("2")){
			 map.put( "result", new Boolean( true ) ) ;
			 map.put( "message", "" ) ;
			 return map ;
		}
		int int_total_records = Integer.parseInt(total_records);
		StringBuffer invalidCode = new StringBuffer();
		for(int i=0; i<int_total_records; i++){
			
			if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){
				order_id			 = (String)allValues.get("ord_id"+i);
				valid_operational_yn = getOperationalStatus("REGISTER_ORDER", order_id , "");
				
			}else
				valid_operational_yn = "Y";

			if(valid_operational_yn.equals("N")){
				map.put( "result", new Boolean( false ) ) ;
				invalidCode.append(i+",");
			}
			
		}
		if(!((Boolean) map.get( "result" )).booleanValue()){
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", getMessagess(language_id, "OR_STATUS_CHANGED","OR") ) ;
			map.put( "invalidCode", invalidCode.substring(0,invalidCode.length()-1) ) ;
			
		}
        return map ;
    }

/**
 *
 * @param locale     Language ID
 * @param messageId  Message Id
 * @param moduleId	 Module Id
 * @return           Message description
 */
	public  String getMessagess(String locale, String messageId, String moduleId)
	{
       // java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		//String message_desc = (String) message.get("message");
		//message.clear();
       // return(message_desc) ;
		String returnText = SpringCacheBean.getMessage(locale,messageId,moduleId);
		return returnText  ;
    }

	public String getOrderSetDetails(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "N" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) 
				{
					record = resultSet.getString("bill_yn")  ;
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

		return record;
	}
	// IN000000 - START
		public String getBillingModuleYn(String facilityId) throws Exception {
			 Connection connection 		= null;
			 PreparedStatement pstmt 	= null;
			 ResultSet resultSet 		= null;
			 String bill_install_yn= "N";
			 String sqlQry = "Select BL_MODULE_YN from OR_PARAM_BY_FACILITY where operating_facility_id = ? ";
			 try {
					connection	= getConnection();
					pstmt		= connection.prepareStatement( sqlQry);
					pstmt.setString(1, facilityId); // pass the facility_id
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )    // Only one record for the module_id
					{
						if(resultSet.next())
						{
							bill_install_yn = checkForNull(resultSet.getString( "BL_MODULE_YN" ),"N")  ;
						}
					}	// if there is no record, then also it should return as 'N'
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet);
				closeStatement( pstmt);
				closeConnection(connection);
			}
			return bill_install_yn;
		}
	//IN000000 - End
		//IN071618 Starts
				public String getSpiltUnBilledOrderYN() throws Exception {
					 Connection connection 		= null;
					 PreparedStatement pstmt 	= null;
					 ResultSet resultSet 		= null;
					 String split_unbilled_order_yn= "N";
					 try {
							connection	= getConnection();
							pstmt		= connection.prepareStatement("SELECT split_unbilled_order_yn FROM OR_PARAM_BY_FACILITY WHERE OPERATING_FACILITY_ID=? ");
							pstmt.setString(1, getLoginFacilityId()); // pass the facility_id
							resultSet	= pstmt.executeQuery() ;
							if ( resultSet != null )    // Only one record for the module_id
							{
								while(resultSet.next())
								{
									split_unbilled_order_yn = checkForNull(resultSet.getString( "split_unbilled_order_yn" ),"N")  ;
								}
							}	// if there is no record, then also it should return as 'N'
					 	} catch ( Exception e )	{

							e.printStackTrace() ;
							throw e ;
					 	} finally {
							closeResultSet( resultSet);
							closeStatement( pstmt);
							closeConnection(connection);
				 		}
				 		return split_unbilled_order_yn;
				 }
				
				public ArrayList getBillSettlementYN(String ordering_facility, String order_id) throws Exception
				{
					Connection connection 		= null;
					PreparedStatement pstmt 	= null;
					ResultSet resultSet 		= null;
					ArrayList billSettleDetails	= new ArrayList() ;
					String bill_set_details = "";
					String record [] 	= new String[2];
					try 
					{
						connection = getConnection() ;	
						
						pstmt = connection.prepareStatement("select or_ord_reg_line_bl_settled(?,'OR',?) settle_detail FROM DUAL");
						pstmt.setString( 1, ordering_facility );
						pstmt.setString( 2, order_id);

						resultSet = pstmt.executeQuery() ;
						if( resultSet != null && resultSet.next() ) 
						{ 
							bill_set_details = checkForNull(resultSet.getString( "settle_detail" ),"")  ;
						}
						
						if(!"".equals(bill_set_details))
						{	
							StringTokenizer st1 = new StringTokenizer(bill_set_details, "~");
					        
					              
					        while (st1.hasMoreTokens()) 
					        {
					           	record[0]			=	st1.nextToken();
					           	record[1]			=	st1.nextToken();	           	
							} 
					        billSettleDetails.add(record);
						}
					} 
					catch( Exception e )	
					{
						System.err.println( "Error loading values from database RegisterOrder.java" ) ;
						e.printStackTrace() ;
					} 
					finally 
					{
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						closeConnection(connection) ;
					}
					return billSettleDetails;
				}
				
				public ArrayList getUnBilledOrderDetails(String facility_id,String patient_id,String called_from,String order_id,String encounter_id) throws Exception 
				{
						
						Connection connection 		= null;
						PreparedStatement pstmt 	= null;
						ResultSet resultSet 			= null;
						ArrayList UnBilledOrder = new ArrayList() ;
				
				 		int total_records			= 0;
				
						try {
								
							connection			= getConnection() ;
							
							pstmt = connection.prepareStatement( "SELECT   a.order_id order_id,a.order_category,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,b.Priority Priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, b.order_line_num order_line_num,decode(b.billing_package_ref,null,b.bill_yn,'N') bill_yn,b.order_qty order_qty,TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,c.CONTR_MOD_ID contr_mod_id,a.patient_id, encounter_id, TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.ORDER_CATALOG_CODE catalog_code,SOURCE_TYPE,SOURCE_CODE,b.Priority,b.ORDER_TYPE_CODE , a.ORD_PRACT_ID ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1')  ORDERING_PRACT_NAME,ORDER_STATUS,OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,  a.ord_consent_reqd_yn, sex,date_of_birth, GET_AGE(DATE_OF_BIRTH) age,nvl(a.cont_order_ind,'DO')   cont_order_ind, a.ord_appr_reqd_yn, ord_appr_by_user_id, a.ord_consent_reqd_yn, ord_consent_by_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, b.billing_package_ref billing_package_ref FROM or_order a, or_ordeR_line b,or_order_catalog c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id  and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE and a.patient_id=d.patient_id and ordering_facility_id = (?)  and a.patient_id=(?)  and a.order_id=?  and  nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') and ORDER_line_STATUS IN ( SELECT ORDER_STATUS_CODE   FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE <'20')  order by encounter_id,a.order_id,a.ORD_DATE_TIME desc"  ) ;//IN052314 removed encounter from where condition
				
							pstmt.setString( 1, language_id);
							pstmt.setString( 2, language_id);
							pstmt.setString( 3, language_id);
							pstmt.setString( 4, language_id);
							pstmt.setString( 5, language_id);
							pstmt.setString( 6, language_id);
							pstmt.setString( 7, language_id);
							pstmt.setString( 8, facility_id) ;		 
							pstmt.setString( 9, patient_id) ; 
							//pstmt.setString( 10, encounter_id) ;	//IN052314	
							pstmt.setString( 10, order_id) ;	
											
							resultSet = pstmt.executeQuery() ;
							
							while(resultSet!=null && resultSet.next()) 
							{
								String[] record = new String[34];				
								record[0] = checkForNull(resultSet.getString( "order_category" ),"")   ;
								record[1] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
								record[2] = checkForNull(resultSet.getString( "Priority_desc" ),"")  ;
								record[3] = checkForNull(resultSet.getString( "patient_class_short_desc" ),"")  ;
								record[4] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
								record[5] = checkForNull(resultSet.getString( "order_line_num" ),"")  ;
								record[6] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
								record[7] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
								record[8] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
								record[9] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
								record[10] = checkForNull(resultSet.getString( "Priority" ),"")  ;
								record[11] = checkForNull(resultSet.getString( "source_type" ),"")  ;
								record[12] = checkForNull(resultSet.getString( "source_code" ),"")  ;
								record[13] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
								record[14] = checkForNull(resultSet.getString( "order_status" ),"")  ;
								record[15] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
								record[16] = checkForNull(resultSet.getString( "ord_pract_id" ),"")  ;
								record[17] = checkForNull(resultSet.getString( "date_of_birth" ),"")  ;
								record[18] = checkForNull(resultSet.getString( "sex" ),"")  ;
								record[19] = checkForNull(resultSet.getString( "age" ),"")  ;
								record[20] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
								record[21] = checkForNull(resultSet.getString( "ord_appr_reqd_yn" ),"")  ;
								record[22] = checkForNull(resultSet.getString( "ord_appr_by_user_id" ),"")  ;
								record[23] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
								record[24] = checkForNull(resultSet.getString( "ord_consent_by_id" ),"")  ;
								record[25] = checkForNull(resultSet.getString( "order_id" ),"");
								record[26] = checkForNull(resultSet.getString( "bill_yn" ),"");
								record[27] = checkForNull(resultSet.getString( "catalog_code" ),"");
								record[28] = checkForNull(resultSet.getString( "order_qty" ),"");
								record[29] = checkForNull(resultSet.getString( "contr_mod_id" ),"");
								record[30] = checkForNull(resultSet.getString( "start_date_time" ),"");
								record[31] = checkForNull(resultSet.getString( "location_description" ),"");	
								record[32] = checkForNull(resultSet.getString( "billing_package_ref" ),"");
								record[33] = String.valueOf(total_records);
								UnBilledOrder.add(record) ;
				 			}
						} catch ( Exception e )	{
				
							e.printStackTrace() ;
							throw e ;
						} finally {
							closeResultSet( resultSet ) ;
							closeStatement( pstmt ) ;
							closeConnection(connection);
						}
				
						return UnBilledOrder;
					}
				
				 public ArrayList getBillChargeDetails(String quantity,String catalog_code,String start_date_time,String language_id,String order_id,String order_line_no,String patient_id, String encounter_id,String patient_class,String practitioner_id) throws Exception {

						Connection connection 											= null;
						CallableStatement cstmt 										= null;
						PreparedStatement pstmt 										= null;
						PreparedStatement pstmt_floor_to_start_day	 					= null;
						PreparedStatement pstmt_mod_physician_id	 					= null;
						ResultSet resultSet 											= null;
						ResultSet resultSet_floor_to_start_day 							= null;
						ResultSet resultSet_mod_physician_id 							= null;
						PreparedStatement pstmt_bl 										= null;
						ResultSet rs													= null;
						String l_facility_id											= "";
						ArrayList BillChargeInfo										= new ArrayList() ;

						String[]  billing_details										= new String[21];
						String round_off_start_date										="N";
						String mod_physician_id											="";
						
						try
						{
						
								connection	= getConnection();
								
								if (!order_id.equals("")) 
								{ 
									pstmt_bl = connection.prepareStatement("select a.ordering_facility_id from or_order a,or_order_line b where a.order_id=b.order_id and a.order_id =? and b.order_line_num=?");
									pstmt_bl.setString(1, order_id); 
									pstmt_bl.setString(2, order_line_no); 
									rs	= pstmt_bl.executeQuery() ;
									if ( rs != null )
									{
										while(rs.next())
										{
											l_facility_id = checkForNull(rs.getString( "ordering_facility_id" ),"")  ;
										}
									}
								}
								else 
								{
									l_facility_id = login_facility_id;
								}

								pstmt_mod_physician_id		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_MOD_PHYSICIAN_ID"));				
								cstmt = connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_GET_CHARGE_DETAILS")+" }");
								cstmt.setString(1, l_facility_id); 
								cstmt.setString(2, encounter_id);  			  	   			 // ENCOUNTER_ID
								cstmt.setString(3, patient_class); 							 // PATIENT_CLASS
								cstmt.setString(4, patient_id); 							 // PATIENT_ID
								cstmt.setDouble(5, Double.parseDouble(checkForNull(quantity,"0")));
								cstmt.setString(6, catalog_code); 					 		 // CATALOG_CODE
								cstmt.setString(7, start_date_time); 				 		 // START_DATE_TIME
								cstmt.setString(8, practitioner_id); 						 // PRACTITIONER_ID
								cstmt.setString(9, language_id); 							 // P_LANGUAGE_ID
								cstmt.registerOutParameter( 10,  Types.VARCHAR ) ;			 // P_STR
								cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;			 // P_CHARGE_BASED_YN
								cstmt.registerOutParameter( 12,  Types.NUMERIC ) ;			 // P_TOT_AMT
								cstmt.registerOutParameter( 13,  Types.NUMERIC ) ;			 // P_PAT_PAYABLE_AMT
								cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;			 // P_EXCL_INCL_IND
								cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;			 // P_PREAPP_YN
								cstmt.registerOutParameter( 16,  Types.NUMERIC ) ;			 // P_PAT_PAID_AMT
								cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;			 // P_CHARGED_YN
								cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;			 // P_PAT_BILLED_YN
								cstmt.registerOutParameter( 19,  Types.VARCHAR ) ;			 // ERROR_TEXT
								cstmt.registerOutParameter( 20,  Types.VARCHAR ) ;			 // P_SERV_PANEL_IND
								cstmt.registerOutParameter( 21,  Types.VARCHAR ) ;			 // P_SERV_PANEL_CODE
								cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;			 // P_SERVICE_PANEL_NAME
								cstmt.registerOutParameter( 23,  Types.VARCHAR ) ;			 // P_EPISODE_TYPE
								cstmt.registerOutParameter( 24,  Types.NUMERIC ) ;			 // P_EPISODE_ID
								cstmt.registerOutParameter( 25,  Types.NUMERIC ) ;			 // P_VISIT_ID
								cstmt.setString( 26,  order_id ) ;							 // P_ORDER_ID
								cstmt.setString( 27,  order_line_no ) ;						 // P_ORDER_LINE_NO
								cstmt.setString( 28,  null ) ;						 // fpp_yn IN068314
								cstmt.setString( 29,  null ) ;						 // fpp_category IN068314
								 
								 

								cstmt.execute();
								billing_details[0]  = checkForNull(cstmt.getString(10),"");
								billing_details[1]  = checkForNull(cstmt.getString(11),"");
								billing_details[2]  = checkForNull(String.valueOf(cstmt.getDouble(12)),"");				
								billing_details[3]  = checkForNull(String.valueOf(cstmt.getDouble(13)),"");				
								billing_details[4]  = checkForNull(cstmt.getString(14),""); 
								billing_details[5]  = checkForNull(cstmt.getString(15),""); 
								billing_details[6]  = checkForNull(String.valueOf(cstmt.getDouble(16)),"");
								billing_details[7]  = checkForNull(cstmt.getString(17),"");
								billing_details[8]  = checkForNull(cstmt.getString(18),"");
								billing_details[9]  = checkForNull(cstmt.getString(19),"");
								billing_details[10] = checkForNull(cstmt.getString(20),"");
								billing_details[11] = checkForNull(cstmt.getString(21),"");
								billing_details[12] = checkForNull(cstmt.getString(22),"");
								billing_details[13] = checkForNull(cstmt.getString(23),"");
								billing_details[14] = checkForNull(cstmt.getString(24),"");
								billing_details[15] = checkForNull(cstmt.getString(25),"");
								billing_details[16]  = checkForNull(cstmt.getString(14),""); // new P_EXCL_INCL_IND
							
								pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_FUTURE_ORDER_CHARGE_LATER_IND"));
								pstmt.setString(1, "OR");  					 // FACILITY_ID
								pstmt.setString(2, catalog_code);  			  	   			 // ENCOUNTER_ID
								pstmt.setString(3, billing_details[13]); 	
								pstmt.setString(4, catalog_code); 
								pstmt.setString(5, patient_class); 
								
								resultSet	= pstmt.executeQuery() ;
								String futureBillInd ="";
								String Future_date="";
						
								if ( resultSet != null )
								{
									while(resultSet.next())
									{
										
										futureBillInd =checkForNull(resultSet.getString( "Future_Bill_ind" ),"")  ;
								
										if (futureBillInd.equals("NOW"))
										{
											billing_details[17]="N";
										}
										else if (futureBillInd.equals("LATER") )
										{
											billing_details[17]="Y";
										}
										else
											billing_details[17]="";
										Future_date=checkForNull(resultSet.getString( "furure_order_date" ),"")  ;
									    billing_details[18]=Future_date;
									}
								}

								pstmt_floor_to_start_day		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FLOOR_TO_START_DAY_YN")); 
								pstmt_floor_to_start_day.setString(1, catalog_code);  			  	   			 // CATALOG_CODE
								pstmt_floor_to_start_day.setString(2, patient_class);                             // PATIENT_CLASS
								resultSet_floor_to_start_day	= pstmt_floor_to_start_day.executeQuery() ;
								

								if (resultSet_floor_to_start_day != null )
								{
									while(resultSet_floor_to_start_day.next())
									{
										round_off_start_date =checkForNull(resultSet_floor_to_start_day.getString( "floor_to_start_day_yn" ),"N")  ;	
									    billing_details[19]=round_off_start_date;
									}
								}
								
								if(!order_id.equalsIgnoreCase(""))
								{
								 
									pstmt_mod_physician_id.setString(1, "OR");  			  	   			   // module_id
									pstmt_mod_physician_id.setString(2, order_id);                             // order_id
									pstmt_mod_physician_id.setString(3, order_line_no);                        // order_line_no
									pstmt_mod_physician_id.setString(4, patient_id);                           // patient_id
									pstmt_mod_physician_id.setString(5, billing_details[13]==null?"":billing_details[13]);// episode_type				
									pstmt_mod_physician_id.setString(6, billing_details[15]==null?"":billing_details[15]);// visit_id
									pstmt_mod_physician_id.setString(7, billing_details[14]==null?"":billing_details[14]);// episode_id
									pstmt_mod_physician_id.setString(8, login_facility_id);// facility_id
									resultSet_mod_physician_id	= pstmt_mod_physician_id.executeQuery() ;
								

									if (resultSet_mod_physician_id != null )
									{
										while(resultSet_mod_physician_id.next())
										{							
											mod_physician_id = checkForNull(resultSet_mod_physician_id.getString( "PHYSICIAN_ID" ),"")  ;			
											billing_details[20] = mod_physician_id;
										}
									}
								}
								else
								{
									billing_details[20] = "";
								}
								BillChargeInfo.add(billing_details) ;

						   }
						   catch ( Exception e )	
							{
								e.printStackTrace() ;
							throw e ;
							} 
							finally 
							{
								closeResultSet( resultSet ) ;
								closeResultSet( resultSet_floor_to_start_day ) ;
								closeResultSet( resultSet_mod_physician_id ) ;
								closeResultSet( rs ) ;
								closeStatement( pstmt_bl);
								closeStatement( cstmt);
								closeStatement( pstmt);
								closeStatement( pstmt_floor_to_start_day);
								closeStatement( pstmt_mod_physician_id);
								closeConnection(connection);
							}
							return BillChargeInfo;
					 }
				//IN071618 Ends
	
}
