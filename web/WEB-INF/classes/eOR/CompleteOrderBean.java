/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/******************************************************************************* 

---------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
27/11/2017		IN061890		Kamalakannan G		27/11/2017			Ramesh G		ML-MMOH-CRF-0542
04/06/2018		IN066548		Kamalakannan G		04/06/2018		Ramesh G		ML-MMOH-CRF-1076
06/06/2018		IN067881 		Kamalakannan G		04/06/2018		Ramesh G		CA-ML-MMOH-CRF-1076/01-Result Reporting
01/08/2018	IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
14/10/2019      IN071315	    Nijitha S   		15/10/2019		Ramesh G		GHL-CRF-0607
---------------------------------------------------------------------------------------------------------------
 ******************************************************************************/

package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;
/*Added by Uma on 10/15/2009 for SRR20056-CRF195*/
import javax.servlet.http.*;
/*Ends Here*/

import eOR.ORCompleteOrder.*;


public class CompleteOrderBean extends eOR.Common.OrAdapter implements java.io.Serializable {

	protected Hashtable allValues = new Hashtable();
	protected String total_records 				= "";
	protected String order_category 			= "";
	protected String order_type_code 			= "";
	protected String priority 						= "";
	protected String location_type				= "";
	protected String locn 							= "";
	protected String patient_id					= "";
	protected String encntr_id 					= "";
	protected String order_id 						= "";
	protected String date_from 					= "";
	protected String date_to 						= "";
	protected String view_by						= "";
	protected String complete_type 				= "";
	protected String practitioner_id            = "";
	/*Added By Uma on 10/15/2009 for SRR20056-195*/
	public Hashtable print_report_values	= new Hashtable(); // Used for On Line Printing (Billing Refund Report)
	/* Ends Here*/

	StringBuffer traceVals = new StringBuffer();
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
	public void setCompleteType(String complete_type){	this.complete_type = complete_type;	}
	public void setPractitioner_id(String practitioner_id) { this.practitioner_id = practitioner_id;}

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
	public String getCompleteType(){					return complete_type;	}
	public String getPractitioner_id() { return practitioner_id;}
	/*Added By Uma on 10/15/2009 for SRR20056-195*/
	public Hashtable getStoreReportPrintValues() { return this.print_report_values; }
	/*Ends Here*/
	
	ArrayList prepsdata=new ArrayList();
	ArrayList deptData=new ArrayList();

	public void setPrepsData(String prepsData,int i)
	{
		prepsdata.add(i,prepsData);
	}
	public String getPrepsData(int i)
	{
		return (String)prepsdata.get(i);
	}

	public String getDeptData(int i)
	{
		return (String)deptData.get(i);
	}

	public void setDeptData(String deptdata,int i)
	{
		deptData.add(i,deptdata);
	}

	public String getSysDate () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String 	currentDate = "";


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate = resultSet.getString("sys_date_time")  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}
		return currentDate ;
	}



/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList viewOtherDetails(String order_id,String practitioner_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList otherDetails = new ArrayList();
		try {
			connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_COMPLETE_ORDER_VIEW_ORDER_DTL") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, practitioner_type);
				pstmt.setString( 3, language_id);
				pstmt.setString( 4, language_id);
				pstmt.setString( 5, language_id);
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, language_id);
				pstmt.setString( 8, language_id);
				pstmt.setString( 9, order_id.trim() ) ;

				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				//String[] record = new String[32] ;
				String[] record = new String[33] ;

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
				record[17] = resultSet.getString( "cont_order_ind" )  ;

				record[18] = resultSet.getString("appt_reqd_yn");
				record[19] = resultSet.getString("appt_date_time");
				record[20] = resultSet.getString("appt_ref_num");
				record[21] = resultSet.getString("parent_order_id");
				record[22] = resultSet.getString("parent_order_line_num");
				record[23] = resultSet.getString("dosage_unit");
				record[24] = resultSet.getString("form_code");
 				record[25] = resultSet.getString("appt_locn");
				record[26] = resultSet.getString("appt_resched_yn");
				record[27] = resultSet.getString("appt_resched_reason");
				record[28] = resultSet.getString("no_of_reschedules");
				record[29] = resultSet.getString("charge_type_code");
				record[30] = resultSet.getString("durn_value");
				record[31] = resultSet.getString("appl_sliding_scale_yn");
				record[32] = resultSet.getString("instruction_type");
				
				//IN64543, starts
				if("E".equals(record[32]))
					record[12] = resultSet.getString("ITEM_NARRATION_FREE_FMT");
				//IN64543, ends

				otherDetails.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
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
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return ApptDetails;
	}

/**

	@return		:	ArrayList
*/

	public String getPrepsdata(String ord_catalog_code, String ord_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String pat_preps_or_instrns_txt = "";
		//chk = " first >> " ;
		String order_line_fld_value_ins_type = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PREP_DATA") ) ;
			pstmt.setString(1, (String)ord_catalog_code.trim());
			pstmt.setString(2, (String)ord_line_num.trim());
			pstmt.setString(3, ord_catalog_code.trim());//IN64543
			pstmt.setString(4, ord_line_num.trim());//IN64543
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				//pat_preps_or_instrns_txt = resultSet.getString("ORDER_LINE_FIELD_VALUE")  ;//pat_preps_or_instrns_txt
				order_line_fld_value_ins_type = resultSet.getString("order_line_fld_value_ins_type")  ;
				if("T".equals(order_line_fld_value_ins_type))
					pat_preps_or_instrns_txt = resultSet.getString("order_line_field_value")  ;
				else if("E".equals(order_line_fld_value_ins_type))
					pat_preps_or_instrns_txt = resultSet.getString("order_line_fld_value_free_fmt")  ;
			}
			//chk +=  "ord_catalog_code :"+ord_catalog_code +"pat_preps_or_instrns_txt : "+pat_preps_or_instrns_txt;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return pat_preps_or_instrns_txt;
	}


	public HashMap insert(){
			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			traceVals.append("*******INSERT method**** >");
			try{
				map = completeOrder();
			}catch(Exception e){
				e.printStackTrace() ;
			}

			return map;
	}


/**
	@return		:	HashMap
*/

	public HashMap completeOrder() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		HashMap map = new HashMap() ;
		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();

		String order_id = "";
		String line_num = "";
		String line_status = "";
		String tmpStr = "";
		String cont_order_ind = "";
		String order_set_id="";
		String order_set_bill_yn="N";
        System.out.println("incompleteorder");
//		int result = 0;
		int count = 0;
	//	int checked = 0;

		order_id= (String)allValues.get("ord_id");
		String p_called_from_ca=(String)allValues.get("p_called_from_ca");//IN071315
		order_set_id= ((String)getOrderSetDetails(order_set_id))==null?"":((String)getOrderSetDetails(order_set_id));
		order_set_bill_yn=(((String)getOrderSetDetails(order_set_id))==null?"N":((String)getOrderSetDetails(order_set_id)));
		
		int int_total_records = Integer.parseInt(total_records);

		try{
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_COMPLETE_LINE1",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_COMPLETE_LINE1") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_SELECT",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_SELECT") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE3",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE3") );
			sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );

			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_COMPLETE_LINE1_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_COMPLETE_LINE1_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_COMPLETE_REMARKS_UPDATE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_COMPLETE_REMARKS_UPDATE"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_COMPLETE_CARE_PLAN_UPDATE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_COMPLETE_CARE_PLAN_UPDATE"));
			sqlMap.put("SQL_OR_AUTOREPORT_COMPLETION",OrRepository.getOrKeyValue("SQL_OR_AUTOREPORT_COMPLETION"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_AUTOREPORT",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_AUTOREPORT"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
			
		}catch(Exception e){
			e.printStackTrace() ;
		}
		/*traceVals.append("**********header1 * >"+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1"));
		traceVals.append("**********header2 * >"+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2"));
		traceVals.append("**********line1 * >"+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_COMPLETE_LINE1"));
		traceVals.append("**********select * >"+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_SELECT"));
		traceVals.append("**********line2* >"+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE3"));
*/
		try {
			 String complete_all_remarks = "";String complete_all_date = "";
			 String[] updt_data1 ;
			String[] updt_data2 ;
			connection = getConnection() ;
			
			for(int i=0; i<int_total_records; i++){
				
				if(allValues.containsKey("chk"+i)){
					if(((String)allValues.get("chk"+i)).equalsIgnoreCase("Y")){
					  	order_id = order_id.trim();
						//String[] updt_data1 ;
						//String[] updt_data2 ;
						
						if(complete_type.equals("H")) {

                            complete_all_remarks = checkForNull((String)allValues.get("complete_all_remarks"),"");
							complete_all_date = checkForNull((String)allValues.get("complete_all_date"),"");
							updt_data1 = new String[7];
							updt_data2 = new String[5];

							updt_data1[0] = (String)order_id;
							updt_data1[1] = "~";

							updt_data1[2] = login_facility_id;
							updt_data1[3] = login_by_id;
							updt_data1[4] = login_at_ws_no;
							updt_data1[5] = order_set_id;
							updt_data1[6] = order_set_bill_yn;

							updt_data2[0] = "~";
							updt_data2[1] = "~";
							updt_data2[2] = (String)order_id;
							updt_data2[3] = complete_all_remarks;
							updt_data2[4] = complete_all_date;
						

							updt_map1.put("head_data",updt_data1);
							updt_map1.put("line_data",updt_data2);

							count++;

						}else	{
							
							line_num= (String)allValues.get("line_num"+i);
							line_status= (String)allValues.get("line_stat_to_updt");
							
							

							complete_all_remarks = checkForNull((String)allValues.get("complete_remarks"+i),"");
							complete_all_date = checkForNull((String)allValues.get("complete_date"+i),"");

							traceVals.append("**********LINE_NUM* >"+line_num);
							traceVals.append("**********LINE_STATUS* >"+line_status);
							updt_data1 = new String[9];
							updt_data2 = new String[4];

							updt_data1[0] = "~";
							updt_data1[1] = "~";
							updt_data1[2] = (String)order_id;
							updt_data1[3] = (String)line_num;

							updt_data1[4] = login_facility_id;
							updt_data1[5] = login_by_id;
							updt_data1[6] = login_at_ws_no;
							updt_data1[7] = order_set_id;
							updt_data1[8] = order_set_bill_yn;

							
							
							updt_data2[0] = (String)line_status;
							updt_data2[1] = (String)order_id;
							updt_data2[2] = complete_all_remarks;
							updt_data2[3] = complete_all_date;
							

							updt_map1.put("head_data"+count,updt_data1);
							updt_map1.put("line_data",updt_data2);
							count++;
							tmpStr = tmpStr+line_num+",";

						}
					}//end of if condition
				}//end of chek for contains Key
			}//end of for loop


			if(!(tmpStr.equals("")))
				tmpStr = tmpStr.substring(0,(tmpStr.length()-1));

			cont_order_ind = (String)allValues.get("cont_order_ind");
			//cont_order_ind = "DO";
			updt_map1.put("cont_order_ind",cont_order_ind);
			updt_map1.put("totalCount",""+count);
			updt_map1.put("tmpStr",tmpStr);
			updt_map1.put("complete_type",complete_type);
			String currentDate = getSysDate ();
			updt_map1.put("currentDate",currentDate);
			updt_map1.put("order_category",order_category);
			updt_map1.put("practitioner_id",practitioner_id);
			updt_map1.put("order_type",order_type_code);
			updt_map1.put("p_called_from_ca",p_called_from_ca);//IN071315

			traceVals.append("**********UPDT_MAP1* >"+updt_map1);
            System.out.println("practitioner_id"+practitioner_id);
			//ORCompleteOrderHome home = null ;
			//ORCompleteOrderRemote remote = null ;

			try {
					/*InitialContext context = new InitialContext() ;
					Object object = context.lookup( OrRepository.getOrKeyValue("OR_COMPLETE_ORDER_JNDI") ) ;
					home  = (ORCompleteOrderHome) PortableRemoteObject.narrow( object, ORCompleteOrderHome.class ) ;
					updt_map1.put( "properties", getProperties() );
					remote = home.create() ;

					//ORCompleteOrderManager remote1 =  new ORCompleteOrderManager();

					map = remote.insert( updt_map1, sqlMap ) ;
					*/

					updt_map1.put( "properties", getProperties() );

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_COMPLETE_ORDER_JNDI"), ORCompleteOrderHome.class, getLocalEJB());
		    	    Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				    Object argArray[]	=  new Object[2];
				       argArray[0]		= updt_map1;
					   argArray[1]		= sqlMap;
					Class [] paramArray	=  new Class[2];
						paramArray[0]	= updt_map1.getClass();
						paramArray[1]	= sqlMap.getClass();
	 				
					 map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				    (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				    argArray	= null;
				    paramArray	= null;
					if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

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
//			map  = updateValues(connection, updt_map1, sqlMap);

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		map.put("traceVal", traceVals.toString());
		return map;
	}
/*

	public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap){
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt4 	= null;
		PreparedStatement pstmt5 	= null;
		ResultSet resultSet 				= null;
		HashMap map = new HashMap() ;

		int count =0;

		count = Integer.parseInt((String)tabData.get("totalCount"));
		traceVals.append("**********count* >"+count);

		String[] updt_vals1 ;
		String[] updt_vals2 ;

		int result = 0;
		String hdr_code = "";
		String tmpStr = "";
		int i=0;
		complete_type   = (String)tabData.get("complete_type");
		traceVals.append("**********complete_type* >"+complete_type);

		tmpStr   = (String)tabData.get("tmpStr");
		try{
			do{
				if((complete_type.trim()).equals("H")){
					updt_vals1 = (String[])tabData.get("head_data");
					updt_vals2 = (String[])tabData.get("line_data");

					pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1") ) ;
					pstmt4.setString( 1, "60") ; // complete code
					pstmt4.setString( 2, updt_vals1[1].trim() ) ;
					pstmt4.setString( 3, updt_vals1[0].trim() ) ;

					result = pstmt4.executeUpdate();

					if(result >=1){
						result=0;
						pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2") ) ;

						pstmt5.setString( 1, "60"  ) ; // complete code
						pstmt5.setString( 2, updt_vals2[0].trim()  ) ;
						pstmt5.setString( 3, updt_vals2[1].trim()  ) ;
						pstmt5.setString( 4, updt_vals2[2].trim()  ) ;

						result = pstmt5.executeUpdate();
					}
				}else if ((complete_type.trim()).equals("L")){
					updt_vals1 = (String[])tabData.get("head_data"+i);
					traceVals.append("**********updt_vals1[0]* >"+updt_vals1[0]);
					updt_vals2 = (String[])tabData.get("line_data");
					traceVals.append("**********updt_vals1[1]* >"+updt_vals1[1]);

					pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_LINE1") ) ;

					if(updt_vals1[0].equals("~")) updt_vals1[0] = null;
					if(updt_vals1[1].equals("~")) updt_vals1[1] = null;
					pstmt3.setString( 1, updt_vals1[0]) ;
					pstmt3.setString( 2, updt_vals1[1]) ;
					pstmt3.setString( 3, updt_vals1[2].trim()  ) ;
					pstmt3.setString( 4, updt_vals1[3].trim()  ) ;

					traceVals.append("***updt_vals1[0]* >"+updt_vals1[0]);
					traceVals.append("***updt_vals1[1]* >"+updt_vals1[1]);
					traceVals.append("***updt_vals1[2]* >"+updt_vals1[2]);
					traceVals.append("****updt_vals1[3]* >"+updt_vals1[3]);
					result = pstmt3.executeUpdate();
					traceVals.append("?????????result* >"+result);
				}
				i++;
			}while(i<count);

			if((complete_type.trim()).equals("L")){

				traceVals.append("**********COMES HERE* >");
				updt_vals2 = (String[])tabData.get("line_data");

				String sql = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_COMPLETE_LINE_SELECT");

				int t = sql.lastIndexOf("?");
				sql  = sql.substring(0,t) + tmpStr.trim() + sql.substring(t+1)  ;

				traceVals.append("**********SQL * >"+sql);
				pstmt2 = connection.prepareStatement( sql ) ;
				pstmt2.setString( 1, (String)updt_vals2[1].trim()) ;

				resultSet = pstmt2.executeQuery();

				while(resultSet.next() ){
					hdr_code = resultSet.getString("order_line_status");
					traceVals.append("**********hdr_code IN > * >"+hdr_code);
				}
				if(((hdr_code.trim()).equalsIgnoreCase(""))) {
					traceVals.append("**********hdr_code * >"+hdr_code);
					result=0;
					pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE3") ) ;
					pstmt1.setString( 1, "60") ; // complete code
					pstmt1.setString( 2, updt_vals2[1].trim() ) ;

					result = pstmt1.executeUpdate();
				}
			}

			if ( result < 1 ) {
				traceVals.append("====ROLLBACK");
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;

			} else  {
				traceVals.append("====COMMIT");
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "Operation Completed Successfully..." ) ;
				//messages.append( "RECORD_MODIFIED" ) ;
				//messages.append( "Operation Completed Successfully..." ) ;
			}
		}catch(Exception e){
			traceVals.append("====Exception : "+e);

		}
		return map;
	}
*/

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
			allValues = recordSet;
			
			
			if(recordSet.containsKey("order_category")){setOrderCategory((String)recordSet.get("order_category"));}
			if(recordSet.containsKey("total_recs")){		setTotalRecs((String)recordSet.get("total_recs"));	}
			if(recordSet.containsKey("order_type")){		setOrderType((String)recordSet.get("order_type"));	}
			if(recordSet.containsKey("priority")){			setPriority((String)recordSet.get("priority"));}
			if(recordSet.containsKey("location_type")){ 	setLocationType((String)recordSet.get("location_type"));}
			if(recordSet.containsKey("locn")){				setLocation((String)recordSet.get("locn"));	}
			if(recordSet.containsKey("patientId")){		setPatientId((String)recordSet.get("patientId"));}
			if(recordSet.containsKey("encntr_id")){  		setEncntrId((String)recordSet.get("encntr_id"));}
			if(recordSet.containsKey("order_no")){		setOrderId((String)recordSet.get("order_no"));	}
			if(recordSet.containsKey("date_from")){
				if (date_from.equals(" ") || date_from.equals("null")) date_from="";
				if(!language_id.equals("en"))
				date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
				setDateFrom((String)recordSet.get("date_from"));}
			if(recordSet.containsKey("date_to")){
				if (date_to.equals(" ") || date_to.equals("null")) date_to="";
				if(!language_id.equals("en"))
				date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
				setDateTo((String)recordSet.get("date_to"));}
			if(recordSet.containsKey("view_by")){			setViewBy((String)recordSet.get("view_by"));}
			if(recordSet.containsKey("complete_type")){	setCompleteType((String)recordSet.get("complete_type"));}
			if(recordSet.containsKey("practitioner_id")){
				
				setPractitioner_id((String)recordSet.get("practitioner_id"));}
			
			this.mode = (String)recordSet.get( "mode" );
			
	}

    public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
				currentDate.add(resultSet.getString("sys_date_time_sec"))  ;
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

	/*Used for Replace Orderables  & Change Charge Type*/
	public HashMap modify(){
		
			HashMap map = new HashMap() ;

			map.put( "result", new Boolean( false ) ) ;
			try{
				if(((String)allValues.get("function_from")).equals("Replace"))
				map = replaceOrder();
				else if(((String)allValues.get("function_from")).equals("ChargeType"))
				map = changeChargeType();
				
			}catch(Exception e){
				e.printStackTrace() ;
			}
			return map;
	}
/*Start of Replace Orderables methods*/
/*Modified by Uma on 2/11/2010 for package billing CRF 712*/
	public ArrayList getReplaceOrderable(String order_catalog_code,String order_id,String order_line_num) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		ResultSet resultSet 		= null;
		ArrayList orderable		= new ArrayList() ;
		String billingPackageRef  = "";
		String patient_id  = "";
		String ordering_facility_id  = "";
		try
		{		
			connection = getConnection() ;
		}
		catch(Exception e1 )	
		{

			e1.printStackTrace() ;
			throw e1;
		}
		pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_BILLING_PACKAGE_REF"));
		pstmt1 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_BILLING_PACKAGE_REPLACE_ORDER_DTLS")) ;
		pstmt2 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_BILLING_PACKAGE_REPLACE_ORDERABLE"));
		pstmt3 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REPLACE_ADD_ORDERS_SELECT")) ;
		try
		{		
			//connection = getConnection() ;
			
			pstmt.clearParameters();
			pstmt.setString( 1, order_id);
			pstmt.setString( 2, order_line_num ) ;	
			resultSet = pstmt.executeQuery() ;			
			while(resultSet != null && resultSet.next()) 
			{
				billingPackageRef = resultSet.getString("billing_package_ref")==null?"0":resultSet.getString("billing_package_ref");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(Integer.parseInt(billingPackageRef)>0)
			{
				pstmt1.clearParameters();
				pstmt1.setString( 1, order_id);
				pstmt1.setString( 2, order_line_num ) ;	
				resultSet = pstmt1.executeQuery() ;			
				while(resultSet != null && resultSet.next()) 
				{
					patient_id = resultSet.getString("patient_id")==null?"":resultSet.getString("patient_id");
					ordering_facility_id = resultSet.getString("ordering_facility_id")==null?"":resultSet.getString("ordering_facility_id");
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				
				pstmt2.clearParameters();
				pstmt2.setString( 1, ordering_facility_id);
				pstmt2.setString( 2, patient_id ) ;	
				pstmt2.setString( 3, billingPackageRef ) ;	
				pstmt2.setString( 4, order_catalog_code ) ;	
				pstmt2.setString( 5, ordering_facility_id);
				pstmt2.setString( 6, patient_id ) ;	
				pstmt2.setString( 7, billingPackageRef ) ;	
				pstmt2.setString( 8, order_catalog_code ) ;
				pstmt2.setString( 9, language_id ) ;
				resultSet = pstmt2.executeQuery() ;
				String[] record = null;
				while ( resultSet != null && resultSet.next() ) 
				{
					record = new String[2];
					record[0] = resultSet.getString("order_catalog_code")==null?"":resultSet.getString("order_catalog_code");
					record[1] = resultSet.getString("short_desc")==null?"":resultSet.getString("short_desc");	
					orderable.add(record) ;
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt2 ) ;
			}
			else
			{
				
				pstmt3.clearParameters();
				pstmt3.setString( 1, language_id);
				pstmt3.setString( 2, order_catalog_code ) ;			
				resultSet = pstmt3.executeQuery() ;
				String[] record = null;
				while ( resultSet != null && resultSet.next() ) 
				{
					record = new String[2];
					record[0] = resultSet.getString( "order_catalog_code_repl" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;				
					orderable.add(record) ;
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt3 ) ;
			}
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return orderable;
	}
	/*712 CRF changes ends here*/

public HashMap replaceOrder() throws Exception 
{
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;
		String replaceTypeFlag = "";//IN067881

	try{
			sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
			sqlMap.put("SQL_OR_ORDER_REPLACEABLE_ACTIVATION",OrRepository.getOrKeyValue("SQL_OR_ORDER_REPLACEABLE_ACTIVATION") );

		}catch(Exception e)
		{
			e.printStackTrace() ;
		}

		try 
		{
			String order_id=(String)allValues.get("order_id");
			String order_line_num=(String)allValues.get("order_line_num");			
			//String new_order_catalog=(String)allValues.get("replace_orderable0"); commented for IN066548
			String remarks_text=(String)allValues.get("complete_remarks");
			String new_order_catalog="";//IN066548
			String p_called_from_ca=(String)allValues.get("p_called_from_ca");//IN071315
			updt_map1.put("function_from",(String)allValues.get("function_from"));
			//IN067881 start
			replaceTypeFlag = (String)allValues.get("rep_type")==null ? "" :(String)allValues.get("rep_type");
			if(replaceTypeFlag.equals("C")){
				 new_order_catalog=(String)allValues.get("replace_orderable_code");
			}else if(replaceTypeFlag.equals("T")){
				 new_order_catalog=(String)allValues.get("replace_orderable_code1");
			}else{
				 new_order_catalog=(String)allValues.get("replace_orderable0");
			}
			//IN067881 end
			updt_map1.put("login_facility_id",login_facility_id);
			updt_map1.put("login_by_id",""+login_by_id);
			updt_map1.put("login_at_ws_no",login_at_ws_no);
			updt_map1.put("order_id",order_id);			
			updt_map1.put("order_line_num",order_line_num);
			updt_map1.put("new_order_catalog",new_order_catalog);
			updt_map1.put("remarks_text",remarks_text);
			updt_map1.put("p_called_from_ca",p_called_from_ca);//IN071315

			try 
			{
					updt_map1.put( "properties", getProperties() );

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_COMPLETE_ORDER_JNDI"), ORCompleteOrderHome.class, getLocalEJB());
		    	    Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				    Object argArray[]	=  new Object[2];
				       argArray[0]		= updt_map1;
					   argArray[1]		= sqlMap;
					Class [] paramArray	=  new Class[2];
						paramArray[0]	= updt_map1.getClass();
						paramArray[1]	= sqlMap.getClass();
	 				
					 map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				    (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				    argArray	= null;
				    paramArray	= null;
					if(map.get( "message" ).equals("RECORD_MODIFIED"))
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
					else if(map.get( "message" ).equals("CHANGE_CHARGE_TYPE_NO_ACCESS"))
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "OR")) ;
					else
					map.put( "message", (String) map.get( "message" )) ;
					/*Added By Uma on 10/15/2009 for SRR20056-195*/
					print_report_values	= (Hashtable) map.get("print_report_values");  // Global HashTable used to stored the values(for Billing report)
					map.put("traceVal", (String)tmpBuff.toString());

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
		map.put("traceVal", traceVals.toString());
		return map;
}
/*End of Replace Orderables methods*/

/*Start of Change Charge Type methods*/
public String getChargeTypeDesc(String Order_category,String charge_type_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String description = "";
		
		try {
			
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHANGE_CHARGE_TYPE_DESC") ) ;
			pstmt.setString(1, Order_category.trim());
			pstmt.setString(2, language_id);
			pstmt.setString(3, charge_type_code.trim());
			
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				description = resultSet.getString("description")  ;
			}
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return description;
	}

public ArrayList getChargeType(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList chargeType		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CHANGE_CHARGE_TYPE_SELECT") ) ;
			
			pstmt.setString( 1, language_id.trim());
			pstmt.setString( 2, order_category.trim() ) ;
			
			resultSet = pstmt.executeQuery() ;
			String[] record = null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "charge_type_code" )  ;
				record[1] = resultSet.getString( "description" )  ;

				chargeType.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return chargeType;
	}


	public HashMap changeChargeType() throws Exception {

			HashMap map = new HashMap() ;
			StringBuffer tmpBuff	= new StringBuffer();
			HashMap updt_map1 = new HashMap();
			HashMap sqlMap = new HashMap() ;

	try{
		sqlMap.put("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_BL_AUTH_FOR_CHARGE_YN",OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_BL_AUTH_FOR_CHARGE_YN") );
		sqlMap.put("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_GET_ORDER_CATALOG_CHARGE_DTLS",OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_GET_ORDER_CATALOG_CHARGE_DTLS") );
		sqlMap.put("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_POPULATE_INTERFACED_RECS",OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_CHANGE_CHARGE_TYPE_POPULATE_INTERFACED_RECS") );
		

		}catch(Exception e){
			e.printStackTrace() ;
		}

		try {

			String order_id=(String)allValues.get("order_id");
			String order_line_num=(String)allValues.get("order_line_num");			
			String new_charge_type=(String)allValues.get("new_charge_type");
			updt_map1.put("function_from",(String)allValues.get("function_from"));
			updt_map1.put("login_facility_id",login_facility_id);
			updt_map1.put("login_by_id",""+login_by_id);
			updt_map1.put("login_at_ws_no",login_at_ws_no);
			updt_map1.put("order_id",order_id);			
			updt_map1.put("order_line_num",order_line_num);
			updt_map1.put("new_charge_type",new_charge_type);
			updt_map1.put("practitioner_id",(String)allValues.get("practitioner_id"));
			updt_map1.put("catalog_code",(String)allValues.get("catalog_code"));
			updt_map1.put("catalog_desc",(String)allValues.get("catalog_desc"));
			updt_map1.put("patient_class",(String)allValues.get("patient_class"));
			updt_map1.put("patient_id",(String)allValues.get("patient_id"));



			try {
					updt_map1.put( "properties", getProperties() );

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_COMPLETE_ORDER_JNDI"), ORCompleteOrderHome.class, getLocalEJB());
		    	    Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				    Object argArray[]	=  new Object[2];
				       argArray[0]		= updt_map1;
					   argArray[1]		= sqlMap;
					Class [] paramArray	=  new Class[2];
						paramArray[0]	= updt_map1.getClass();
						paramArray[1]	= sqlMap.getClass();
	 				
					 map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				    (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				    argArray	= null;
				    paramArray	= null;
					if(map.get( "message" ).equals("RECORD_MODIFIED"))
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
					else if(map.get( "message" ).equals("CHANGE_CHARGE_TYPE_NO_ACCESS"))
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "OR")) ;
					else
					map.put( "message", (String) map.get( "message" )) ;

					map.put("traceVal", (String)tmpBuff.toString());

			} catch(Exception e) {

				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} 
		map.put("traceVal", traceVals.toString());
		return map;
}

/*End of Change Charge Type methods*/
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
		
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
			return map;


		int int_total_records = Integer.parseInt(total_records);
		
		order_id= (String)allValues.get("ord_id");

		for(int i=0; i<int_total_records; i++){

			if(allValues.containsKey("chk"+i)){
				if(((String)allValues.get("chk"+i)).equalsIgnoreCase("Y")){
					  // valid_operational_yn = getStatus(order_id,(String)allValues.get("line_num"+i), "" ,"COMPLETION_ORDER",(String)allValues.get("catalog_code"+i));

					if(allValues.containsKey("perform_from") && ((String)allValues.get("perform_from")).equals("COMPLETE_MEDICATION")){
						valid_operational_yn = getOperationalStatus("COMPLETE_MEDICATION",order_id,(String)allValues.get("line_num"+i));
						
					}else
						valid_operational_yn = getStatus(order_id,(String)allValues.get("line_num"+i), "" ,"RESULT_ENTRY",(String)allValues.get("catalog_code"+i));

				}
			}
			
							
			if(valid_operational_yn.equals("N")){
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(language_id, "OR_STATUS_CHANGED","OR") ) ;
				map.put( "invalidCode", ""+i ) ;

				break;
			}
			
		}
        return map ;
    }
	public String getStatus(String order_id,String order_line_num,String order_type_code,String perfm_func,String order_catalog_code ) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		String perform_yn			= "";
		try{
			connection	= getConnection();
			if(order_type_code.equals("")){
				pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_CODE")) ;
				pstmt.setString(1, order_id);

				resultSet	= pstmt.executeQuery() ;
			
				while(resultSet != null && resultSet.next()) {
					order_type_code = checkForNull(resultSet.getString( "order_type_code" ),"N") ;  
				}

			}	
			
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			/*pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_LINE_STATUS_CHK")) ;
			pstmt.setString(1, perfm_func);
			pstmt.setString(2, order_id);
			pstmt.setString(3, order_type_code);
			pstmt.setString(4, order_catalog_code);
			pstmt.setString(5, order_line_num);*/

			
			pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_STATUS_CHK")) ;
			pstmt.setString(1, perfm_func);
			pstmt.setString(2, order_id);
			pstmt.setString(3, order_type_code);
			resultSet	= pstmt.executeQuery() ;
			
			while(resultSet != null && resultSet.next()) {
				perform_yn = checkForNull(resultSet.getString( "perform_yn" ),"") ;  
				
			}
		
						
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
			return perform_yn;
	}	 

	public String getdata(String order_id, String ord_line_num,String data) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String order_line_field_value = "";
		//chk = " first >> " ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DATA") ) ;
			/*pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)ord_line_num.trim());
			pstmt.setString(3, data);*/
			
			pstmt.setString(1, (String)order_id.trim());
			pstmt.setString(2, (String)order_id.trim());
			pstmt.setString(3, (String)ord_line_num.trim());
			pstmt.setString(4, data);
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				//IN64543, starts
				//order_line_field_value = resultSet.getString("order_line_field_value");				
				if("T".equals(resultSet.getString("order_line_fld_value_ins_type")))
					order_line_field_value = resultSet.getString("order_line_field_value");
				else
					order_line_field_value = resultSet.getString("order_line_fld_value_free_fmt");
				//IN64543, ends
			}
		} catch ( Exception e )	{

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

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

			}

		return record;
	}

	/*Added By Uma on 10/15/2009 for SRR20056-195*/
	public void callOnLineCancelPrinting(Hashtable print_values,HttpServletRequest request , HttpServletResponse response) throws Exception 
	{
		//, Hashtable stored_print_values,
 		//OnLinePrinting online_print = new OnLinePrinting(request,response);
		OnLinePrinting online_print = new OnLinePrinting();
		//OnLinePrinting online_print = new OnLinePrinting();
		// one parameter is to print the order form , another paramater is to print the consent forms
		online_print.callCancelOrderPrint(print_values,request,response);//Pass the Hashtable print_values (Stored in generateUniqueIds() )
		//,stored_print_values ,

	} // End of callOnLinePrinting
	/*Ends Here*/
	/*Added by Uma on 2/11/2010 for package billing CRF712*/
	public String getBillingPackageRef(String order_id,String order_line_num) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String billingPackageRef  = "";		
		try
		{		
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_GET_BILLING_PACKAGE_REF"));
			pstmt.clearParameters();
			pstmt.setString( 1, order_id);
			pstmt.setString( 2, order_line_num ) ;	
			resultSet = pstmt.executeQuery() ;			
			while(resultSet != null && resultSet.next()) 
			{
				billingPackageRef = resultSet.getString("billing_package_ref")==null?"0":resultSet.getString("billing_package_ref");
			}
		}
		catch(Exception e)
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);

		}
		return billingPackageRef;
	}
	/*Ends Here*/
	/*IN061890 starts*/	
		public String OrdThroTermSetYN() throws Exception{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String OrdThroTermSetYN = "N" ;
			try
			{		
				connection = getConnection() ;
				pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PARAM_ORD_REPL_THRO_TERMSET_YN"));
				resultSet = pstmt.executeQuery() ;			
				while ( resultSet != null && resultSet.next() ) 
				{
					OrdThroTermSetYN = resultSet.getString("ORD_REPL_THRO_TERMSET_YN")  ;
				}
			}
			catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

			}
			return OrdThroTermSetYN;
		}
	
	


	public ArrayList populateTermSetID () throws Exception
	{
		ArrayList TermSetID = new ArrayList() ;
		Connection connection=null;
		java.sql.ResultSet resultSet=null;
		java.sql.PreparedStatement pstmt = null;

		try 
		{
			connection=	getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_POPULATE_TERM_SET_ID") ) ;
			if(!(pstmt==null))
			{
				resultSet = pstmt.executeQuery() ;
			}

			String[] record =null;
			while ( resultSet != null && resultSet.next() ) 
			{
				record = new String[2];
				record[0] = resultSet.getString( "term_set_id" )  ;
				record[1] = resultSet.getString( "term_set_desc" )  ;
				TermSetID.add(record) ;
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return TermSetID;
	}
	public ArrayList getTermSetReplaceOrderable(String order_catalog_code,String term_set_id,String term_code_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt3 	= null;
		ResultSet resultSet 		= null;
		ArrayList orderable		= new ArrayList() ;
		try
		{		
			connection = getConnection() ;
		}
		catch(Exception e1 )	
		{

			e1.printStackTrace() ;
			throw e1;
		}

		try
		{		
			
			pstmt3 = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REPLACE_ADD_ORDERS_SELECT_THRO_TERMSET")) ;

			pstmt3.clearParameters();
			pstmt3.setString( 1, language_id);
			pstmt3.setString( 2, order_catalog_code ) ;				
			pstmt3.setString( 3, order_catalog_code ) ;	
			pstmt3.setString( 4, term_set_id ) ;	
			pstmt3.setString( 5, term_code_id ) ;	
			pstmt3.setString( 6, language_id);
			pstmt3.setString( 7, term_code_id);
			pstmt3.setString( 8, term_set_id) ;
			pstmt3.setString( 9, order_catalog_code) ;
			pstmt3.setString( 10, order_catalog_code) ;

			resultSet = pstmt3.executeQuery() ;
			String[] record = null;
			while ( resultSet != null && resultSet.next() ) 
			{
				record = new String[2];
				record[0] = resultSet.getString( "order_catalog_code_repl" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;				
				orderable.add(record) ;
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt3 ) ;
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt3 ) ;
			closeConnection(connection);
		}
		return orderable;
	}
	/*IN061890 ends*/
}
