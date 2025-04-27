/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
01/08/2018	IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
---------------------------------------------------------------------------------------------------------------
*/

package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;

import eOR.ORReviewStatus.*;

public class ReviewStatusBean extends eOR.Common.OrAdapter implements java.io.Serializable {

	protected Hashtable allValues = new Hashtable();
	protected ArrayList lineRecords = new ArrayList();
	protected String task_type 				= "";
	protected String order_id 						= "";
	protected String total_records 				= "";
	protected String order_category 			= "";
	protected String order_type_code 			= "";
	protected String priority 						= "";
	protected String location_type				= "";
	protected String locn 							= "";
	protected String patient_id					= "";
	protected String encntr_id 					= "";
	protected String date_from 					= "";
	protected String date_to 						= "";
	protected String view_by						= "";

	//StringBuffer traceVals = new StringBuffer();
	//public String chk = "";

	public void setMode(String mode){								this.mode = mode;	}
	public void setTotalRecs(String total_records){				this.total_records = total_records;	}
	public void setOrderCategory(String order_category){		this.order_category = order_category;	}
	public void setOrderType(String order_type_code){		this.order_type_code = order_type_code;	}
	public void setPriority(String priority){							this.priority= priority;	}
	public void setLocationType(String location_type){		this.location_type= location_type;	}
	public void setLocation(String locn){							this.locn = locn;	}
	public void setPatientId(String patient_id){					this.patient_id = patient_id;	}
	public void setEncntrId(String encntr_id){					this.encntr_id = encntr_id;	}
	public void setOrderId(String order_id){						this.order_id= order_id;	}
	public void setDateFrom(String date_from){					this.date_from= date_from;	}
	public void setDateTo(String date_to){						this.date_to= date_to;	}
	public void setViewBy(String view_by){						this.view_by= view_by;	}

	public String getMode(){											return mode;	}
	public String getTotalRecs(){										return total_records;	}
	public String getOrderCategory(){								return order_category;	}
	public String getOrderType(){									return order_type_code;	}
	public String getPriority(){											return priority;	}
	public String getLocationType(){								return location_type;	}
	public String getLocation(){										return locn;	}
	public String getPatientId(){										return patient_id;	}
	public String getEncntrId(){										return encntr_id;	}
	public String getOrderId(){										return order_id;	}
	public String getDateFrom(){										return date_from;	}
	public String getDateTo(){											return date_to;	}
	public String getViewBy(){											return view_by;	}



/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/
	public ArrayList getOrderStatus() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderStatus = new ArrayList() ;
		String dfltOrdStatus = "";
		PreparedStatement pstmt1 =  null;
		ResultSet resultSet1	= null;
		try {
			connection  = getConnection() ;
			pstmt1		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REVIEW_STATUS_DFLT_ORD_STAT") ) ;
			resultSet1  = pstmt1.executeQuery() ;

			while ( resultSet1 != null && resultSet1.next() ) {
				dfltOrdStatus = resultSet1.getString( "dflt_in_process_ord_stat" )  ;
			}
			if (dfltOrdStatus == null)
				dfltOrdStatus = "";
		/*} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally { */
			
		//	closeConnection(connection) ;
		//}

		//try {
		//	connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REVIEW_STATUS_ORDER_STATUS_SELECT") ) ;
			pstmt.setString( 1, language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[3];
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "order_status_code" )  ;
				record[2] = dfltOrdStatus;

				OrderStatus.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt1 ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderStatus;
	}


/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
	public String[] viewMainDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[39] ;

		try {
			connection = getConnection() ;
			System.out.println("language_id="+language_id);
			System.out.println("order_id="+order_id);
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, language_id);	
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, language_id);
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, language_id);
				pstmt.setString( 10, language_id);
				pstmt.setString( 11, order_id.trim() ) ;

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {

				record[0] = resultSet.getString( "order_category_short_desc" )  ;
				record[1] = resultSet.getString( "order_type_short_desc" )  ;
				record[2] = checkForNull(resultSet.getString( "Priority_desc" ),"R")  ;
				record[3] = resultSet.getString( "sex" )  ;
				record[4] = resultSet.getString( "encounter_id" )  ;
				record[5] = resultSet.getString( "order_status_short_desc" )  ;
				record[6] = resultSet.getString( "patient_name" )  ;
				record[7] = resultSet.getString( "ordering_pract_name" )  ;
				record[8] = resultSet.getString( "ordering_facility" )  ;
				record[9] = resultSet.getString( "performing_facility" )  ;
				record[10] = resultSet.getString( "order_format" )  ;
                record[11] = resultSet.getString("ORD_PRACT_ID");
                record[12] = resultSet.getString("ORDER_DATE_TIME");
                record[13] = resultSet.getString("ordering_facility_id");
                record[14] = resultSet.getString("iv_prep_yn");
                record[15] = resultSet.getString("order_category");
                record[16] = resultSet.getString("order_mode");
                record[17] = resultSet.getString("performing_deptloc_type");
                record[18] = resultSet.getString("performing_deptloc_code");
                record[19] = resultSet.getString("performing_pract_id");
                record[20] = checkForNull(resultSet.getString("ref_facility_id"),"");
                record[21] = checkForNull(resultSet.getString("ref_date_time"),"");
                record[22] = checkForNull(resultSet.getString("ref_sent_pract_id"),"");
                record[23] = checkForNull(resultSet.getString("ref_sent_remarks"),"");
                record[24] = checkForNull(resultSet.getString("ref_report_pract_id"),"");
                record[25] = checkForNull(resultSet.getString("ref_report_date_time"),"");
                record[26] = checkForNull(resultSet.getString("ref_recieved_date_time"),"");
                record[27] = checkForNull(resultSet.getString("ref_recieved_pract_id"),"");
                record[28] = checkForNull(resultSet.getString("ref_recieved_remarks"),"");
                record[29] = checkForNull(resultSet.getString("action_seq_num"),"");
                record[30] = checkForNull(resultSet.getString("appl_user_name"),"");
                record[31] = checkForNull(resultSet.getString("IMAGE_REF_YN"),"N");
                record[32] = checkForNull(resultSet.getString("order_id"),"");
                record[33] = checkForNull(resultSet.getString("patient_class"),"");
                record[34] = checkForNull(resultSet.getString("age"),"");
                record[35] = checkForNull(resultSet.getString("Patient_id"),"");
                record[36] = checkForNull(resultSet.getString("source_type"),"");
                record[37] = checkForNull(resultSet.getString("source_code"),"");
                record[38] = checkForNull(resultSet.getString("location_description"),"");
				


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

		return record;
	}

/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList viewOtherDetails(String order_id,String practitioner_type) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList otherDetails = new ArrayList();
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_COMPLETE_ORDER_VIEW_ORDER_DTL") ) ;
			pstmt.setString( 1 , language_id);
			pstmt.setString( 2 , practitioner_type);
			pstmt.setString( 3 , language_id);
			pstmt.setString( 4 , language_id);
			pstmt.setString( 5 , language_id);
			pstmt.setString( 6 , language_id);
			pstmt.setString( 7 , language_id);
			pstmt.setString( 8 , language_id);
			pstmt.setString( 9 , order_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
			{
				//String[] record = new String[29] ;
				String[] record = new String[30] ;
				
				record[0] = resultSet.getString( "catalog_desc" )  ;
				record[1] = resultSet.getString( "priority_desc" )  ;
				record[2] = resultSet.getString( "start_date_time" )  ;
				record[3] = resultSet.getString( "end_date_time" )  ;
				record[4] = resultSet.getString( "order_qty" )  ;
				record[5] = resultSet.getString( "order_status_desc" )  ;
				record[6] = resultSet.getString( "freq_code" )  ;
				record[7] = resultSet.getString( "durn_type" )  ;
				record[8] = resultSet.getString( "order_line_status" )  ;
				record[9] = resultSet.getString( "order_line_num" )  ; //used as serial number inthe page
				record[10] = resultSet.getString( "frequency_detail" )  ;
				record[11] = /*resultSet.getString( "line_fields_display_detail" )  ;*/getOrderFormatTxt(order_id,record[9],((resultSet.getString( "order_category" )).toString()));
				record[12] = resultSet.getString( "item_narration" )  ;
				record[13] = resultSet.getString( "order_catalog_code" )  ;
				record[14] = resultSet.getString( "order_category" )  ;
				record[15] = resultSet.getString( "chk_box_flag" )  ;
				record[16] = resultSet.getString( "colour_status" )  ;
				record[17] = resultSet.getString( "order_catalog_code" )  ;

				record[18] = resultSet.getString("appt_reqd_yn");
				record[19] = resultSet.getString("appt_date_time");
				record[20] = resultSet.getString("appt_ref_num");
				record[21] = resultSet.getString("cont_order_ind");
				record[22] = resultSet.getString("parent_order_id");
				record[23] = resultSet.getString("parent_order_line_num");
				record[24] = resultSet.getString("appt_locn");
				record[25] = resultSet.getString("appt_resched_yn");
				record[26] = resultSet.getString("appt_resched_reason");
				record[27] = resultSet.getString("no_of_reschedules");
				record[28] = resultSet.getString("durn_value");
				record[29] = resultSet.getString("instruction_type");
				//IN64543, starts
				if("E".equals(record[29]))
					record[12] = resultSet.getString("ITEM_NARRATION_FREE_FMT");
				//IN64543, ends
				otherDetails.add(record) ;
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

		return otherDetails;
	}

    public String getAppointmentYN(String parent_order_id,String parent_order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String Appointment 			= "N";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_APPT_YN") ) ;
			pstmt.setString(1, parent_order_id);
			pstmt.setString(2, parent_order_line_num);

			resultSet = pstmt.executeQuery() ;

			if( resultSet.next() ) {
				if (resultSet.getInt(1) > 0)
					Appointment	= "Y";
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

		return Appointment;
	}

    public ArrayList getApptDetails(String parent_order_id,String parent_order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ApptDetails		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_APPT_DETAILS") ) ;
			pstmt.setString( 1, parent_order_id ) ;
			pstmt.setString( 2, parent_order_line_num ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[6];
				record[0] = resultSet.getString( "appt_ref_num" )  ;
				record[1] = resultSet.getString( "appt_date_time" )  ;
				record[2] = resultSet.getString( "appt_locn" )  ;
				record[3] = resultSet.getString( "appt_resched_yn" )  ;
				record[4] = resultSet.getString( "appt_resched_reason" )  ;
				record[5] = resultSet.getString( "no_of_reschedules" )  ;

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



/*
	@return		:	ArrayList
*/

	public String getdata(String order_id, String ord_line_num,String data) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String order_line_field_value = "";
		String order_line_fld_value_ins_type = "";
		//chk = " first >> " ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DATA") ) ;
			/*pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)ord_line_num.trim());
			pstmt.setString(3, data);*/
			pstmt.setString(1, order_id.trim());
			pstmt.setString(2, (String)order_id.trim());
			pstmt.setString(3, (String)ord_line_num.trim());
			pstmt.setString(4, data);
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				//order_line_field_value = resultSet.getString("order_line_field_value")  ;
				order_line_fld_value_ins_type = resultSet.getString("order_line_fld_value_ins_type")  ;
				if("T".equals(order_line_fld_value_ins_type))
					order_line_field_value = resultSet.getString("order_line_field_value")  ;
				else if("E".equals(order_line_fld_value_ins_type))
					order_line_field_value = resultSet.getString("order_line_fld_value_free_fmt")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);

		}
		return order_line_field_value;
	}

	public String getPrepsdata(String order_id, String ord_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String order_line_field_value = "";
		//chk = " first >> " ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PREP_DATA") ) ;
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)ord_line_num.trim());
			pstmt.setString(3, order_id.trim());
			pstmt.setString(4, ord_line_num.trim());
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				order_line_field_value = resultSet.getString("order_line_field_value")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);

		}
		return order_line_field_value;
	}

 private Object getEmptyStrIfNull(Object obj)
 {
	if(obj==null)
		return "";
	else return obj;
 }

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

public void setAll( Hashtable recordSet )
{
	allValues = null;
	allValues = recordSet;
	lineRecords.clear();

	if(allValues.containsKey("HttpRequest"))
		allValues.remove("HttpRequest");
	if(allValues.containsKey("HttpResponse"))
		allValues.remove("HttpResponse");

	this.mode = (String)allValues.get( "mode" );
	task_type = (String)getEmptyStrIfNull(allValues.get("task_type"));

	allValues.put("login_facility_id",login_facility_id);	
	allValues.put("login_by_id",login_by_id);	
	allValues.put("login_at_ws_no",login_at_ws_no);	
	
	if(task_type.trim().equalsIgnoreCase("UpdateOrder"))
	{
		allValues.put("task_type",getEmptyStrIfNull(allValues.get("task_type")));
		allValues.put("order_status",getEmptyStrIfNull(allValues.get("order_status")));
		allValues.put("order_id",getEmptyStrIfNull(allValues.get("order_id")));
		allValues.put("orderRemark",getEmptyStrIfNull(allValues.get("orderRemark")));
	}
	else// if(task_type.trim().equalsIgnoreCase("UpdateLine"))
	{
		allValues.put("order_id",getEmptyStrIfNull(allValues.get("order_id")));

		int totalLineRecords = 0;
		if(recordSet.containsKey("total_recs"))
			totalLineRecords = Integer.parseInt((String)recordSet.get("total_recs"));

		lineRecords.clear();
		for(int i=0; i<totalLineRecords; i++)
		{
			HashMap lineRecord = new HashMap();	// Creating a new lineRecord HashMap.
			String line = Integer.toString(i);	// Converting the rownumber to string.
			lineRecord.put("lineStatus",getEmptyStrIfNull(recordSet.get("lineStatus"+line)));
			lineRecord.put("lineStatusRemark",getEmptyStrIfNull(recordSet.get("lineStatusRemark"+line)));
			lineRecord.put("orderLineNum",getEmptyStrIfNull(recordSet.get("orderLineNum"+line)));

			lineRecords.add(i, lineRecord);	// putting this line record in the lineRecords ArrayList.
		}
	}
}

public HashMap insert(){	// no insert required in this function.
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
//		try{
			//map = registerOrder();
//		}catch(Exception e){
//		}

		return map;
}

/*********************METHOD TO UPDATE it is called when mode = 2*************************/

public HashMap modify()
{
	try
	{
		HashMap map = new HashMap() ;
		HashMap sqlMap = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		//HashMap tabData = new HashMap() ;
		map.put("message",map.get("msgid"));

		map.put("lineRecords",lineRecords);
		map.put("allValues",allValues);

		sqlMap.put("SQL_OR_REVIEW_STATUS_ORDER_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REVIEW_STATUS_ORDER_UPDATE"));
		sqlMap.put("SQL_OR_REVIEW_STATUS_LINE_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REVIEW_STATUS_LINE_UPDATE"));
		sqlMap.put("SQL_OR_REVIEW_STATUS_ORDER_LINE_UPDATE",OrRepository.getOrKeyValue("SQL_OR_REVIEW_STATUS_ORDER_LINE_UPDATE"));

		//return map ;
		return getResult(map,sqlMap );

	}catch(Exception e)
	{
//		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}
}

/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap )
 {
	HashMap map  = new HashMap() ;
	StringBuffer tmpBuff	= new StringBuffer();
	try
		{

		/*	InitialContext context = new InitialContext();
			Object object		   = context.lookup(OrRepository.getOrKeyValue("OR_REVIEW_STATUS_JNDI"));
			ORReviewStatusHome home  = (ORReviewStatusHome) PortableRemoteObject.narrow( object,ORReviewStatusHome.class );
			ORReviewStatusRemote remote = home.create() ;
		*/

			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "tabData",     record );

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_REVIEW_STATUS_JNDI"), ORReviewStatusHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
				argArray[0]		= tabDataParam;
				argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
				paramArray[0]	= tabDataParam.getClass();
				paramArray[1]	= sqlMap.getClass();
			
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE")))
			{
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
			{
				System.err.println("No Insert Method, only Modify Method");
				// No insert Operation.
				//map = remote.insert(tabDataParamtabDataParam, sqlMap ) ;
				//map = insert(tabDataParam, sqlMap ) ;
			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
			{
				// For conversions map = remote.modify(tabDataParam, sqlMap ) ;
				//map = modify(tabDataParam, sqlMap )    ;

				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			argArray	= null;
			paramArray	= null;
			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
	  return map;

	 }catch(Exception e){
		System.out.println( "Error Calling EJB in Review Status :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}

 }//End of Method



/************FOR EJB******************/
public HashMap modify(HashMap tabDataParam , HashMap sqlMap )  {
StringBuffer messages =  null ;
StringBuffer traceVal =  null ;
HashMap map =null;
Connection connection =  null ;
PreparedStatement pstmt_order	    	= null ;
PreparedStatement pstmt_order_l	    	= null ;
PreparedStatement pstmt_line		    = null ;
String task_type = "";
	try
	{
		messages = new StringBuffer() ;
		traceVal = new StringBuffer() ;
		map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;

		traceVal.append("----- UPDATE CALLED -----");

		HashMap tabData = (HashMap)tabDataParam.get("tabData");
//		Properties  pt = (Properties)tabDataParam.get("properties");

		ArrayList lineRecords = (ArrayList)tabData.get("lineRecords");
		Hashtable allValues = (Hashtable)tabData.get("allValues");

		int update_order = 0;
		int update_order_l = 0;
		int update_line[] = {};

		boolean   update_line_flag = false ;

		traceVal.append("1");

	//	 Connection connection = getConnection(pt) ;
	 	connection = getConnection() ;


		String SQL_OR_REVIEW_STATUS_ORDER_UPDATE	= (String)sqlMap.get("SQL_OR_REVIEW_STATUS_ORDER_UPDATE");
		String SQL_OR_REVIEW_STATUS_LINE_UPDATE	= (String)sqlMap.get("SQL_OR_REVIEW_STATUS_LINE_UPDATE");
		String SQL_OR_REVIEW_STATUS_ORDER_LINE_UPDATE = (String)sqlMap.get("SQL_OR_REVIEW_STATUS_ORDER_LINE_UPDATE");

		pstmt_order = connection.prepareStatement(SQL_OR_REVIEW_STATUS_ORDER_UPDATE);
		pstmt_order_l = connection.prepareStatement(SQL_OR_REVIEW_STATUS_LINE_UPDATE);
		pstmt_line = connection.prepareStatement(SQL_OR_REVIEW_STATUS_ORDER_LINE_UPDATE);
 		traceVal.append("2");

		task_type = (String)allValues.get("task_type");
		if(task_type.trim().equalsIgnoreCase("UpdateOrder"))
		{
			pstmt_order.setString(1, (String)allValues.get("order_status"));
			pstmt_order.setString(2, (String)allValues.get("order_id"));
			update_order = pstmt_order.executeUpdate();

			pstmt_order_l.setString(1, (String)allValues.get("order_status"));
			pstmt_order_l.setString(2, (String)allValues.get("order_id"));
			update_order_l = pstmt_order_l.executeUpdate();
			if (update_order >= 1 && update_order_l >= 1)
			{
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					messages.append("RECORD_MODIFIED") ;
			}else
			{
				connection.rollback();
				messages.append( "Update Failed" ) ;
			}
		}
		else
		{
			int sizeDetail	= lineRecords.size()  ;
			for (int i=0;i<sizeDetail;i++)
			{
				HashMap lineRecord = (HashMap)lineRecords.get(i);
				traceVal.append("-3a-");
				traceVal.append((String)allValues.get("order_id")+","+(String)lineRecord.get("orderLineNum")+","+(String)lineRecord.get("lineStatus")+"-");
				pstmt_line.setString(1, (String)lineRecord.get("lineStatus"));
				pstmt_line.setString(2, (String)allValues.get("order_id"));
				pstmt_line.setString(3, (String)lineRecord.get("orderLineNum"));
				pstmt_line.addBatch();
			}
			update_line = pstmt_line.executeBatch();
 			traceVal.append("3b");

			if((update_line.length > 0)) //check updation in SYN
				update_line_flag = true;
			else if((update_line.length == (-3)))
				update_line_flag = false;

			if (update_line_flag)
			{
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					messages.append("RECORD_MODIFIED") ;
			}else
			{
				connection.rollback();
				messages.append( "Update Failed" ) ;
			}
		}

	}
	catch( Exception e )
	{
		traceVal.append("In Exception==");
		e.printStackTrace();
		traceVal.append(e);
		traceVal.append("#"+e.getMessage());
		map.put( "traceVal", traceVal.toString() ) ;

		try {
			connection.rollback();
		//		closeConnection( connection,pt "));
 			} catch ( Exception ee ) {
				messages.append(ee.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage());
			e.printStackTrace() ;
	}
	finally
	{
		try {
		//	closeConnection( connection,pt"));
			closeStatement( pstmt_order ) ;
			closeStatement( pstmt_order_l ) ;
			closeStatement( pstmt_line ) ;
 			closeConnection(connection);
		} catch ( Exception fe ) {
			System.err.println( fe.getMessage() ) ;
			fe.printStackTrace() ;
		}
	}

	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;
}//End of modify Method
/************FOR EJB******************/
}
