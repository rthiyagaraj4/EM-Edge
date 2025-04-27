/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------
?             	100            		?           created
16/07/2011     	IN027474            Chowminya 	Incident No: IN027474 - <Result Reporting - flagged completed with no result value> 
22/08/2011     	IN028369            Chowminya 	Incident No: IN028369 - <Result Reporting - flagged completed with no result value for child orders> 
15/09/2011     	IN028670            Chowminya 	Incident No: IN028670 - <Result Reporting - Status change issue for orderset> 
11/09/2012     	IN032859            Chowminya 	Incident No: IN032859 - <In the multi-facility scenario -  unable to complete order> 
18/01/2013		IN037372			Ramesh G		Oracle 11g Weblogic compilation.
08/05/2013		IN029323	        NijithaS    System displays External order details as "null" and unable to Record the Result for that order.
26/08/2013	    IN041340		Ramesh G		Bru-HIMS-CRF-363.1
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
05/05/2014		IN048091		Karthi L			06/05/2014		Ramesh			Orders>Existing Orders>Open results screen>System shows the last modified comments even though the comments were removed.																		
23/10/2019    	IN071315	    Nijitha S  									GHL-CRF-0607															
12/09/2019		IN071959		Nijitha S			12/09/2019		Ramesh			Regression-OR-Common-Result Reporting
20/04/2021		6484			Ramesh Goli			20/04/2021		RAMESH G		MO-CRF-20147.7										`
--------------------------------------------------------------------------------------------------------------
*/
package eOR.ORResultEntry ;

import java.rmi.* ;
import java.util.* ;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.sql.* ;
import javax.ejb.* ;
import java.io.* ;

import eOR.Common.* ;
import oracle.sql.CLOB;
//import oracle.sql.CLOB;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="ORResultEntry"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORResultEntry"
*	local-jndi-name="ORResultEntry"
*	impl-class-name="eOR.ORResultEntry.ORResultEntryManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORResultEntry.ORResultEntryLocal"
*	remote-class="eOR.ORResultEntry.ORResultEntryRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORResultEntry.ORResultEntryLocalHome"
*	remote-class="eOR.ORResultEntry.ORResultEntryHome"
*	generate= "local,remote"
*
*
*/

public class ORResultEntryManager extends OrEJBSessionAdapter
{
    //SessionContext context ;

	Properties  pt = null;
	Connection connection = null ;
	//StringBuffer traceVals = new StringBuffer();

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap insert(HashMap tabDataParam , HashMap sqlMap )  
	{
	
		StringBuffer messages =  null ;
		StringBuffer traceVal =  null ;
		HashMap map =null;

		//PreparedStatement pstmt	    	= null ; //Checkstyle
		PreparedStatement pstmt_header	    	= null ;
		PreparedStatement pstmt_final_order_status	    	= null ;
		PreparedStatement pstmt_detail		    = null ;
		PreparedStatement pstmt_proclink	    = null ;
		PreparedStatement pstmt_proclink_insert	    = null ;
		PreparedStatement pstmt_status		    = null ;
		PreparedStatement pstmt_order			= null ;
		PreparedStatement pstmt_line 			= null ;
		PreparedStatement pstmt_line1 			= null ;
		PreparedStatement pstmt_parent_line		= null ;
		PreparedStatement pstmt_clob			= null ;
		PreparedStatement pstmt_clob1			= null ;
		PreparedStatement pstmt_organism		= null ;
		PreparedStatement pstmt_organism_delete	= null ;
		PreparedStatement pstmt_parent			= null ;
		PreparedStatement pstmt_parent1		= null ;
		PreparedStatement pstmt_child_order_index		= null ;
		PreparedStatement pstmt_proclink_insert_srl_no		= null ;
		PreparedStatement pstmt8 			= null;
		PreparedStatement pstmt_set_status 	= null;	
		PreparedStatement pstmt_freq_expl		= null ;
		PreparedStatement pstmt_abn_child_chk	= null ;
		PreparedStatement pstmt_bill_update		= null ;
		PreparedStatement pstmt_message			= null ;
		PreparedStatement pstmt_chart_result			= null ;
		//PreparedStatement pstmt_proc_code			= null ; //Checkstyle
		PreparedStatement pstmt_proc_desc			= null ;	
		PreparedStatement pstmt_bl 										= null;//--[IN032859]

		CallableStatement cstmt 				= null;
		CallableStatement cstmt_bl_result 		= null;
		CallableStatement cstmt_bl_ext_service	= null;
		CallableStatement cstmt_bl_ext_chrg_stage= null;
		CallableStatement cstmt_freq_auto_close= null;

		ResultSet rs  = null;
		//ResultSet resultSet  = null; //Checkstyle
		ResultSet rs1 =	null;
		ResultSet rs5 = null;
		ResultSet rs2 = null;
		ResultSet rs6 = null;
		ResultSet chart_resultSet = null;
		ResultSet resultSet_srl_no = null;
		ResultSet billResultSet 			= null;
		ResultSet resultset_status 			= null;
		//ResultSet resultset_proc_code 			= null; //Checkstyle
		ResultSet rs_bl													= null;//--[IN032859]
		//ArrayList proc_term_set_id = new ArrayList(); //Checkstyle
		//ArrayList proc_term_set_code = new ArrayList(); //Checkstyle
		String charting_result="";
		String p_bill_yn	= "";
		String order_id		= "";
		String l_facility_id		= "";//--[IN032859]
		//String proc_term_set_id	= "";
		//String proc_term_set_code	= "";

		try 
		{
			messages = new StringBuffer() ;
			traceVal = new StringBuffer() ;
			map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "flag" ) ;

			HashMap tabData	=(HashMap)tabDataParam.get("tabData");
			pt			    =(Properties)tabDataParam.get("properties");
			connection		= getConnection(pt) ;
	//			connection		= getConnection() ;
			ArrayList lineRecords		=(ArrayList)tabData.get("lineRecords");
			HashMap resultRecord		=(HashMap)tabData.get("resultRecord");
			HashMap commonRecord		=(HashMap)tabData.get("CommonRecords");
					
			int insert_header = 0;
			int insert_detail[] = {};
			int update_l_status[] = {};
			int update_order = 0;
			int update_line = 1;
			int srl_no = 0;				
		
			//int update_p_order = 0;
			//int update_p_line = 0;

			boolean   insert_dl = false ;
			boolean   update_l_st = false;
			boolean   temp_insert_dl = false ;

			String err_message	= "";
			String bill_yn		= "N";
			String err_bill_yn  = "N";
			String old_srl_no	= "";
			//String line_srl_num = "";
			String charged_yn	= "N";
			String err_code		= "";
			String message_id	= "";
			String mess			= "";

			HashMap lineRecord  = null;

			String login_by_id			=(String)commonRecord.get("login_by_id" ) ;
			String login_at_ws_no		=(String)commonRecord.get("login_at_ws_no" ) ;
			String login_facility_id	=(String)commonRecord.get("login_facility_id" ) ;
			String order_type_code		=(String)commonRecord.get("order_type_code" ) ;
			order_id			    =(String)commonRecord.get("order_id" ) ;
			String order_set_id			    =(String)commonRecord.get("order_set_id" ) ;
			String order_set_bill_yn			    =(String)commonRecord.get("order_set_bill_yn" ) ;
			String child_order_index	=(String)commonRecord.get("child_order_index" ) ;
			//String child_order_index	='L';
			String child_reporting_date	=(String)commonRecord.get("child_reporting_date" ) ;
			String parent_order_id		= (String)((commonRecord.get("parent_order_id")==null)?"":commonRecord.get("parent_order_id"));

			boolean any_abnormal_child	= false;;
			String report_srl_no	    =(String)commonRecord.get("report_srl_no" );
			String patient_id		    =(String)commonRecord.get("patient_id" );
			String hdr_practitioner_id		    =(String)commonRecord.get("practitioner_id" );
			String requestFrom			= (String)((commonRecord.get("requestFrom")==null)?"":commonRecord.get("requestFrom"));
			String proc_scheme_code		= (String)((commonRecord.get("proc_scheme_code")==null)?"":commonRecord.get("proc_scheme_code"));
			String accession_num		= "";

			String encounter_id		    = "";
			String proc_encounter_id		    = "";//IN029323
			String patient_class	    = "";
			String final_status	    = "";
			String p_error_msg="";
			traceVal.append("1");

			 String SQL_OR_RESULT_REPORTING_INSERT_HEADER		= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_INSERT_HEADER");
			 String SQL_OR_RESULT_REPORTING_INSERT_DETAIL		= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_INSERT_DETAIL");
			 String SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC		= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC");
			 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER			= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER");
			 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE	= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE");
			 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS			= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS");
			 String SQL_OR_RESULT_REPORTING_UPDATE_CLOB			= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_CLOB");
			 String SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB			= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB");
			 String SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT");
			 String SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT	= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT");
			 String SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION		= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION");
			 String SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK	= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK");
			 String SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG		= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG");
			 String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE");
			 String SQL_OR_ORDER_ENTRY_BILL_MESSAGE				= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
			 String SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS	= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS");
			 String SQL_OR_RESULT_ENTRY_ORGANISM_INSERT			= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ORGANISM_INSERT");
			 String SQL_OR_RESULT_ENTRY_ORGANISM_DELETE			= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ORGANISM_DELETE");
			 String SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT	= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT");	 

			 String SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION	= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION");
			 String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED");
			 //String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE");
			 String SQL_OR_BL_WITHOUT_ORDER_CATALOG= (String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG");
			 String SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE");
			 //String order_set_status_query = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE");//15950
			 //String order_set_status_query_code = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE");//15950
			 //String update_order_set_status = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS");//15950
			 //String update_order_set_line_status = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS");//15950
			 String update_chart_result = (String)sqlMap.get("SQL_OR_ORDER_GET_CHART_RESULT");
			 String proc_link_encounter_insert = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_INSERT");
			// String proc_link_encounter_delete = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_DELETE");
			 String proc_link_encounter_srl_no = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_SRL_NO");
			 String SQL_OR_ORDER_GET_STATUS_CODE	= (String)sqlMap.get("SQL_OR_ORDER_GET_STATUS_CODE");
			 String bill_sql = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
			 String proc_desc = "select short_desc from mr_term_code where term_code=? and term_set_id=?";
			 pstmt8 = connection.prepareStatement(bill_sql) ;

			 traceVal.append("2");

			 java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("dd/MM/yyyy H:m");
			 java.util.Date today = new java.util.Date();
			 String dateString = dt.format(today);


			 traceVal.append("3");

			pstmt_header	 = connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_HEADER);
			pstmt_final_order_status	 = connection.prepareStatement(SQL_OR_ORDER_GET_STATUS_CODE);
			pstmt_detail	 = connection.prepareStatement(SQL_OR_RESULT_REPORTING_INSERT_DETAIL);
			pstmt_proclink	 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT);
			pstmt_status	 = connection.prepareStatement(SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC);
			pstmt_order		 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER);
			pstmt_line		 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE);
			pstmt_line1		 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS);
			pstmt_clob		 = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_CLOB);
			pstmt_clob1		 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB);
			pstmt_organism	 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ORGANISM_INSERT);
			pstmt_organism_delete = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ORGANISM_DELETE);
			pstmt_parent	 = connection.prepareStatement(SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT);
			pstmt_parent1	 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT);
			pstmt_freq_expl	 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION);
			pstmt_abn_child_chk = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK);

			pstmt_bill_update = connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION);
			pstmt_message	 = connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILL_MESSAGE);
			pstmt_proclink_insert	 = connection.prepareStatement(proc_link_encounter_insert);
			pstmt_proclink_insert_srl_no	 = connection.prepareStatement(proc_link_encounter_srl_no);

			cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE+" }");

			cstmt_bl_result = connection.prepareCall("{ "+SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG+" }");
			cstmt_bl_ext_service = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED+" }");
			//cstmt_bl_ext_chrg_stage = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE+" }");
			cstmt_bl_ext_chrg_stage = connection.prepareCall("{ "+SQL_OR_BL_WITHOUT_ORDER_CATALOG+" }");

			cstmt_freq_auto_close = connection.prepareCall("{ "+SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE+" }");
			pstmt_chart_result	 = connection.prepareStatement(update_chart_result);
			pstmt_proc_desc	 = connection.prepareStatement(proc_desc);
			pstmt_set_status = connection.prepareStatement("select order_status_type from or_order a,or_order_status_code b where   b.order_status_code=a.order_status and order_id=?"); // --[IN028670]--
			//--[IN032859] - Start
			if (!order_id.equals("")) 
			{ 
				pstmt_bl = connection.prepareStatement("select ordering_facility_id from or_order where order_id =?");
				pstmt_bl.setString(1, order_id); 
				//pstmt_bl.setString(2,(String)lineRecord.get("line_srl_num"));
				rs_bl	= pstmt_bl.executeQuery() ;
				if ( rs_bl != null )
				{
					while(rs_bl.next())
					{
						l_facility_id = rs_bl.getString( "ordering_facility_id" )  ;
					}
				}
			}
			else
			{
				l_facility_id = login_facility_id;
			}
				//--[IN032859] - End	
				
				//start for change in child_order_index
			if(!parent_order_id.trim().equals(null) && !parent_order_id.equals(""))
			{
				pstmt_child_order_index = connection.prepareStatement("SELECT NVL2(END_DATE_TIME,'L','F') CHILD_ORDER_INDEX FROM  OR_ORDER_LINE	WHERE PARENT_ORDER_ID=? AND ORDER_ID=(SELECT MAX(ORDER_ID) FROM OR_ORDER WHERE PARENT_ORDER_ID=?) AND ORDER_ID=?");
				pstmt_child_order_index.clearParameters();
				pstmt_child_order_index.setString(1, parent_order_id);
				pstmt_child_order_index.setString(2, parent_order_id);
				pstmt_child_order_index.setString(3, order_id);
				rs6 = pstmt_child_order_index.executeQuery();
				
				if(rs6!=null && rs6.next())
				{
						child_order_index		= rs6.getString( "CHILD_ORDER_INDEX" );
						
				}
				closeResultSet( rs6 ) ;
				closeStatement( pstmt_child_order_index ) ;

				}
				//End for change in child_order_index
				
				pstmt_parent_line = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE);

				pstmt_header.setString(1 ,order_type_code);
				pstmt_header.setString(2 ,order_id);
				pstmt_header.setString(3 ,report_srl_no);
				pstmt_header.setString(4 ,(String)resultRecord.get("rpt_pract_id"));

				traceVal.append("order_type_code="+order_type_code);
				traceVal.append("order_id="+order_id);
				traceVal.append("report_srl_no="+report_srl_no);
				traceVal.append("rpt_pract_id="+(String)resultRecord.get("rpt_pract_id"));

				if(child_order_index.trim().equals(""))
					pstmt_header.setString(5 ,dateString);	// Enter system date in case of a normal order.
				else{
					if(child_reporting_date == null || child_reporting_date.equals("") || child_reporting_date.equals("null"))								//j
						child_reporting_date = dateString;								//j

					pstmt_header.setString(5 ,child_reporting_date); // Enter Child Reporting Time in case of Frequency Explosion.
				}

				String auth_reqd_yn1		= (String)resultRecord.get("auth_reqd_yn") ;
				String auth_reqd_id1		= "";
				String auth_reqd_time1		= null;

				if(auth_reqd_yn1.trim().equalsIgnoreCase("Y"))
				{
						auth_reqd_id1	= (String)commonRecord.get("practitioner_id");
						auth_reqd_time1  = dateString;
				}

				pstmt_header.setString(6 ,(String)resultRecord.get("auth_reqd_yn_db"));
				pstmt_header.setString(7 ,auth_reqd_id1);
				pstmt_header.setString(8 ,auth_reqd_time1);
				pstmt_header.setString(9 ,(String)resultRecord.get("result_status"));
				pstmt_header.setString(10,(String)resultRecord.get("result_type"));
				pstmt_header.setString(11,login_by_id);
				pstmt_header.setString(12,login_at_ws_no);
				pstmt_header.setString(13,login_facility_id);
				pstmt_header.setString(14,login_by_id);
				pstmt_header.setString(15,login_at_ws_no);
				pstmt_header.setString(16,login_facility_id);

				insert_header	 = pstmt_header.executeUpdate();
				closeStatement( pstmt_header ) ;
				int sizeDetail	= lineRecords.size()  ;
				traceVal.append("6*"+sizeDetail+"*");
				 
				 //traceVal.append("lineRecords="+lineRecords.toString());


				String episode_id 			=  "";
				String episode_visit_num 	=  "";
				patient_class 				=  "";

				pstmt_header = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS);
				pstmt_header.clearParameters();
				pstmt_header.setString(1, order_id);
				rs = pstmt_header.executeQuery();

				if(rs!=null && rs.next())
				{
					//encounter_id		= rs.getString( "encounter_id" );//IN029323
					encounter_id		= rs.getString( "encounter_id" )== null? "": rs.getString( "encounter_id" );//IN029323
					patient_class	 	= rs.getString( "patient_class" );
					episode_id			= rs.getString( "episode_id" );
					episode_visit_num 	= rs.getString( "episode_visit_num" );
				}

				closeResultSet( rs ) ;
				closeStatement( pstmt_header ) ;
				String auth_reqd_time	= null;
				String auth_reqd_yn		= null;
				String auth_reqd_id		= null;

				for (int i=0;i<sizeDetail;i++)
				{
					lineRecord = (HashMap)lineRecords.get(i);
					traceVal.append("~~~~~lineRecord:"+lineRecord.toString());

					//String func_type	= (lineRecord.get("func_type") == null) ? "" : (String)lineRecord.get("func_type");
					pstmt_detail.setString(1 ,order_type_code);
					pstmt_detail.setString(2 ,order_id);
					pstmt_detail.setString(3 ,report_srl_no);
					pstmt_detail.setString(4 ,(String)lineRecord.get("line_srl_num"));
					pstmt_detail.setString(5 ,(String)lineRecord.get("srl_num"));

					if(child_order_index.trim().equals(""))
						pstmt_detail.setString(6 ,dateString);	// Enter system date in case of a normal order.
					else
						pstmt_detail.setString(6 ,child_reporting_date); // Enter Child Reporting Time in case of Frequency Explosion.

					pstmt_detail.setString(7 ,(String)lineRecord.get("msr_panel_id"));
					pstmt_detail.setString(8 ,(String)lineRecord.get("msr_id"));
					traceVal.append("7");
					auth_reqd_yn		= (String)lineRecord.get("auth_reqd_yn") ;
					auth_reqd_id		= "";

					if((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("Y")) && auth_reqd_yn.trim().equalsIgnoreCase("Y"))
					{
						auth_reqd_id	= (String)commonRecord.get("practitioner_id");
						auth_reqd_time  = dateString;
					}

					traceVal.append("8");
				pstmt_detail.setString(9 ,(String)lineRecord.get("auth_reqd_yn_db"));
				pstmt_detail.setString(10 ,auth_reqd_id);
				pstmt_detail.setString(11 ,auth_reqd_time);
				pstmt_detail.setString(12 ,(String)lineRecord.get("result_type"));
				pstmt_detail.setString(13 ,(String)lineRecord.get("result_num"));
				pstmt_detail.setString(14 ,(String)lineRecord.get("result_num_uom"));
				pstmt_detail.setString(15 ,(String)lineRecord.get("result_str"));
				pstmt_detail.setString(16 ,(String)lineRecord.get("result_status"));
				pstmt_detail.setString(17 ,(String)lineRecord.get("normal_low"));
				pstmt_detail.setString(18 ,(String)lineRecord.get("normal_high"));
				pstmt_detail.setString(19 ,(String)lineRecord.get("critical_low"));
				pstmt_detail.setString(20 ,(String)lineRecord.get("critical_high"));
				//pstmt_detail.setString(21 ,(String)lineRecord.get("norm_abnorm_ind"));
				pstmt_detail.setString(21 ,(String)lineRecord.get("result_type"));
				pstmt_detail.setString(22 ,(String)lineRecord.get("result_comments"));
				pstmt_detail.setString(23 ,login_by_id);
				pstmt_detail.setString(24 ,login_at_ws_no);
				pstmt_detail.setString(25 ,login_facility_id);
				pstmt_detail.setString(26 ,login_by_id);
				pstmt_detail.setString(27 ,login_at_ws_no);
				pstmt_detail.setString(28 ,login_facility_id);
				//pstmt_detail.setString(29 ,accession_num);
				pstmt_detail.setString(29 ,(String)lineRecord.get("accession_num"));
				pstmt_detail.setString(30 ,(String)lineRecord.get("practitioner_id"));

				if (((String)lineRecord.get("result_status")).equals("3")) 
				{
					String result_type_dtl = (String)lineRecord.get("rslt_type");

					if ((!((result_type_dtl.equalsIgnoreCase("N")) || (result_type_dtl.equalsIgnoreCase("F")) || (result_type_dtl.equalsIgnoreCase("I")))) && (!((String)lineRecord.get("result_str")).equals(""))) 
					{
						pstmt_detail.addBatch();
					} 
					else if ((result_type_dtl.equalsIgnoreCase("F")) && (!((String)lineRecord.get("result_data")).equals(""))) 
					{
						pstmt_detail.addBatch();
					} 
					else if ((result_type_dtl.equalsIgnoreCase("N")) && (!((String)lineRecord.get("result_num")).equals(""))) 
					{
						pstmt_detail.addBatch();
					}
					else if ((result_type_dtl.equalsIgnoreCase("I")) && (!((String)lineRecord.get("result_num")).equals("")))
					{
						pstmt_detail.addBatch();
					}
					else
					{
						temp_insert_dl = true;
						if(!(result_type_dtl.equalsIgnoreCase("X")||result_type_dtl.equalsIgnoreCase("Q")||result_type_dtl.equalsIgnoreCase("*")))//--[IN028369]--
						pstmt_detail.addBatch();//--[IN027474]--Added to update the table or_result_detail even if no result value	given
					}
					
					if(result_type_dtl.equalsIgnoreCase("X")||result_type_dtl.equalsIgnoreCase("Q")||result_type_dtl.equalsIgnoreCase("*"))
					{
						pstmt_detail.addBatch();
					}
				} 
				else 
				{
					pstmt_detail.addBatch();
				}
					accession_num = (String)lineRecord.get("accession_num")==null?"":(String)lineRecord.get("accession_num");
				/*	if(!accession_num.equals("")){
					String last_action_type="";
					if(!accession_num.equals(""))
						last_action_type="NT";
					pstmt_line1.setString(1, accession_num.trim());
					pstmt_line1.setString(2, last_action_type.trim());
					pstmt_line1.setString(3, login_by_id ) ;
					pstmt_line1.setString(4, login_at_ws_no ) ;
					pstmt_line1.setString(5, login_facility_id ) ;
					pstmt_line1.setString(6, order_id.trim());
					pstmt_line1.setInt(7, (i+1));
					int xx = pstmt_line1.executeUpdate() ;

				 }*/
				}

				 insert_detail = pstmt_detail.executeBatch();
traceVal.append("==insert_detail.length=="+insert_detail.length+"===");
				if((insert_detail.length > 0))
				{ //check updation in SYN
					insert_dl= true ;
				}
				else if((insert_detail.length == (-3)))
				{
					insert_dl= false ;
				}
				if(temp_insert_dl)
				  insert_dl= true ;
				 String  temp_scheme="";	
				// String  proc_code_scheme="";	
				// String  proc_code_resulted="";	
				// String proc_link_applicable="";
				 for (int i=0;i<sizeDetail;i++)
				{
					lineRecord = (HashMap)lineRecords.get(i);

					if(((String)lineRecord.get("proc_link_applicable")).equals("C") || ((String)lineRecord.get("proc_link_applicable")).equals("P"))
					{
						 //IN029323 Starts
						 if("XT".equals(patient_class) && "".equals(encounter_id))
						 {
							 proc_encounter_id="0";
						 }
						 else
						 {
							 proc_encounter_id=encounter_id;
						 }
						//IN029323 Ends
						 pstmt_proclink.setString(1 ,order_type_code);
						 pstmt_proclink.setString(2 ,order_id);
						 pstmt_proclink.setString(3 ,report_srl_no);
						 pstmt_proclink.setString(4 ,(String)lineRecord.get("line_srl_num"));
						 pstmt_proclink.setString(5 ,(String)lineRecord.get("srl_num"));
						 if(((String)lineRecord.get("proc_link_applicable")).equals("C"))
						{
							pstmt_proclink.setString(6 ,(String)lineRecord.get("order_catalog_code"));//proc_code_scheme
							pstmt_proclink.setString(7 ,"1");//proc_code_resulted
						}
						else if(((String)lineRecord.get("proc_link_applicable")).equals("P"))
						{
						//pstmt_proclink.setString(6 ,(String)lineRecord.get("msr_id"));//proc_code_scheme
							pstmt_proclink.setString(6 ,(String)lineRecord.get("term_set_id"));//proc_code_scheme
							pstmt_proclink.setString(7 ,(String)lineRecord.get("term_code"));//proc_code_resulted
						}
						 //pstmt_proclink.setString(7 ,"1");
						 pstmt_proclink.setString(8 ,login_by_id);
						 pstmt_proclink.setString(9 ,login_at_ws_no);
						 pstmt_proclink.setString(10 ,login_facility_id);
						 pstmt_proclink.setString(11 ,login_by_id);
						 pstmt_proclink.setString(12 ,login_at_ws_no);
						 pstmt_proclink.setString(13 ,login_facility_id);						 
						 pstmt_proclink.executeUpdate();
						 //int insert_proclink=pstmt_proclink.executeUpdate();
						 //pstmt_proclink.addBatch();
						
						 pstmt_proclink_insert_srl_no.setString(1, login_facility_id);
						 //pstmt_proclink_insert_srl_no.setString(2, encounter_id);//IN029323
						 pstmt_proclink_insert_srl_no.setString(2, proc_encounter_id);//IN029323
						 resultSet_srl_no = pstmt_proclink_insert_srl_no.executeQuery();
						 resultSet_srl_no.next();
						 srl_no=resultSet_srl_no.getInt(1);
						 closeResultSet(resultSet_srl_no);
						 pstmt_proclink_insert.setString(1 , login_facility_id);
						 //pstmt_proclink_insert.setString(2 , encounter_id);//IN029323
						 pstmt_proclink_insert.setString(2 , proc_encounter_id);//IN029323
						 pstmt_proclink_insert.setInt(3 , srl_no);
						 pstmt_proclink_insert.setString(4 , hdr_practitioner_id);
						 pstmt_proclink_insert.setString(5 , patient_id);
						 if(((String)lineRecord.get("proc_link_applicable")).equals("C"))
						{
							pstmt_proclink_insert.setString(6 ,"1");//proc_code_resulted
							pstmt_proclink_insert.setString(7 ,(String)lineRecord.get("order_catalog_code"));//proc_code_scheme
						}
						else if(((String)lineRecord.get("proc_link_applicable")).equals("P"))
						{
							pstmt_proclink_insert.setString(6 ,(String)lineRecord.get("term_code"));//proc_code_resulted
							pstmt_proclink_insert.setString(7 ,(String)lineRecord.get("term_set_id"));//proc_code_scheme
						}
						 //pstmt_proclink.setString(7 ,"1");
						 pstmt_proclink_insert.setString(8 , patient_class);
						 pstmt_proclink_insert.setString(9 , order_id);
						 pstmt_proclink_insert.setString(10 , (String)lineRecord.get("line_srl_num"));
						 pstmt_proclink_insert.setString(11 , "O");
						 pstmt_proclink_insert.setString(12 , order_id.substring(0,2));
						 pstmt_proclink_insert.setString(13 , "OR");
						 pstmt_proclink_insert.setString(14 , (String)lineRecord.get("line_srl_num")+"#"+order_id);
						 pstmt_proclink_insert.setString(15 , "N");
						 pstmt_proclink_insert.setString(16 , login_by_id);
						 pstmt_proclink_insert.setString(17 , login_at_ws_no);
						 pstmt_proclink_insert.setString(18 , login_facility_id);
						 pstmt_proclink_insert.setString(19 , login_by_id);
						 pstmt_proclink_insert.setString(20 , login_at_ws_no);
						 pstmt_proclink_insert.setString(21 , login_facility_id);
						 if(((String)lineRecord.get("proc_link_applicable")).equals("P"))
						{
							 pstmt_proclink_insert.setString(22 , getTermDesc(pstmt_proc_desc,(String)lineRecord.get("term_set_id"),(String)lineRecord.get("term_code")));
						}
						else
						{
							pstmt_proclink_insert.setString(22 , "");
						}
						 pstmt_proclink_insert.executeUpdate();

					}					
				 }
				if(!proc_scheme_code.equals(""))
				{						
						StringTokenizer stoken=new StringTokenizer(proc_scheme_code,"*");
						//IN029323 Starts
						if("XT".equals(patient_class) && "".equals(encounter_id))
						 {
							proc_encounter_id="0";
						 }
						 else
						 {
							 proc_encounter_id=encounter_id;
						 }
						//IN029323 Ends
						while(stoken.hasMoreTokens())
						{
							temp_scheme =stoken.nextToken();
							StringTokenizer stoken1=new StringTokenizer(temp_scheme,"~");
							String line_sr_token = stoken1.nextToken();
							int line_srl= 0;
							double line_sr =Double.parseDouble(line_sr_token);
							line_srl = (int)line_sr;
							String srl_num_token = stoken1.nextToken();
							String proc_code_scheme_token = stoken1.nextToken();
							String proc_code_resulted_token = stoken1.nextToken();
							//proc_code_scheme = stoken1.nextToken();
							//proc_code_resulted = stoken1.nextToken();
							pstmt_proclink.setString(1 , order_type_code);
							pstmt_proclink.setString(2 , order_id);
							pstmt_proclink.setString(3 , report_srl_no);
							pstmt_proclink.setInt(4 , line_srl);//line_srl_num
							pstmt_proclink.setString(5 , srl_num_token);//srl_num
							pstmt_proclink.setString(6 , proc_code_scheme_token);//proc_code_scheme
							pstmt_proclink.setString(7 , proc_code_resulted_token);//proc_code_resulted
							pstmt_proclink.setString(8 ,login_by_id);
							pstmt_proclink.setString(9 ,login_at_ws_no);
							pstmt_proclink.setString(10 ,login_facility_id);
							pstmt_proclink.setString(11 ,login_by_id);
							pstmt_proclink.setString(12 ,login_at_ws_no);
							pstmt_proclink.setString(13 ,login_facility_id);
							//pstmt_proclink.executeUpdate();
							//int insert_proclink=pstmt_proclink.executeUpdate();
							pstmt_proclink.executeUpdate();

							pstmt_proclink_insert_srl_no.setString(1, login_facility_id);
							//pstmt_proclink_insert_srl_no.setString(2, encounter_id);//IN029323
							pstmt_proclink_insert_srl_no.setString(2, proc_encounter_id);//IN029323
							resultSet_srl_no = pstmt_proclink_insert_srl_no.executeQuery();
							resultSet_srl_no.next();
							srl_no=resultSet_srl_no.getInt(1);
							closeResultSet(resultSet_srl_no);
							pstmt_proclink_insert.setString(1 , login_facility_id);
							//pstmt_proclink_insert.setString(2 , encounter_id);//IN029323
							pstmt_proclink_insert.setString(2 , proc_encounter_id);//IN029323
							pstmt_proclink_insert.setInt(3 , srl_no);
							pstmt_proclink_insert.setString(4 , hdr_practitioner_id);
							pstmt_proclink_insert.setString(5 , patient_id);
							pstmt_proclink_insert.setString(6 , proc_code_resulted_token);//proc_code_resulted
							pstmt_proclink_insert.setString(7 , proc_code_scheme_token);//proc_code_scheme					 
							pstmt_proclink_insert.setString(8 , patient_class);
							pstmt_proclink_insert.setString(9 , order_id);
							pstmt_proclink_insert.setInt(10 ,line_srl);
							pstmt_proclink_insert.setString(11 ,"O");
							pstmt_proclink_insert.setString(12 , order_id.substring(0,2));
							pstmt_proclink_insert.setString(13 , "OR");
							pstmt_proclink_insert.setString(14 , line_sr_token+"#"+order_id);
							pstmt_proclink_insert.setString(15 , "N");
							pstmt_proclink_insert.setString(16 , login_by_id);
							pstmt_proclink_insert.setString(17 , login_at_ws_no);
							pstmt_proclink_insert.setString(18 , login_facility_id);
							pstmt_proclink_insert.setString(19 , login_by_id);
							pstmt_proclink_insert.setString(20 , login_at_ws_no);
							pstmt_proclink_insert.setString(21 , login_facility_id);							
							pstmt_proclink_insert.setString(22 ,  getTermDesc(pstmt_proc_desc,proc_code_scheme_token,proc_code_resulted_token));	
							pstmt_proclink_insert.executeUpdate();
						}
					}
				
				closeStatement(pstmt_proclink);
				
				traceVal.append("==9==");
traceVal.append("insertinsert_dl"+insert_dl);
				// Inserting the clob data.

				String rslt_type	= null;
				String msg	= null;
				String func_type = null;
				String rec_result_type = null;
				String status = "";
				String orderStatus = "";
				String p_result_status = "P";
				String abnormal_child = null; String temp_result_status  = null;
				String p_freq_code = "";
				String p_start_date_time = "";
				String order_category = "";
				//String patient_class = "";
				String v_discrete_cont_order_yn = "";
				String msr_panel_id = "";
				String common_result_type = "";
				String first_result_type = "";
				int rti = 0;
				String line_result_type = null;
				String order_set_status_type = "0";
				int orderstatustype = 0;
				//String order_set_status_type_code=""; //Checkstyle

				if(insert_dl)
				for (int i=0;i<sizeDetail;i++)
				{
					lineRecord = (HashMap)lineRecords.get(i);
					
					
					rslt_type = (String)lineRecord.get("rslt_type");
						func_type	= (lineRecord.get("func_type") == null) ? "" : (String)lineRecord.get("func_type");
					msg = "";
					accession_num = (String)lineRecord.get("accession_num")==null?"":(String)lineRecord.get("accession_num");
					if (((String)lineRecord.get("result_status")).equals("3")) 
					{
						if(rslt_type.equals("*"))
						{

							pstmt_chart_result.setString(1,order_id);
							pstmt_chart_result.setString(2,(String)lineRecord.get("line_srl_num"));
							chart_resultSet=pstmt_chart_result.executeQuery();
							while(chart_resultSet.next())
							{
								 charting_result = chart_resultSet.getString("chart_result");
							}
							closeResultSet(chart_resultSet);
							msg = insertResultDataClob(pstmt_clob,charting_result,order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
						}
						else if((rslt_type.equalsIgnoreCase("F") || rslt_type.equalsIgnoreCase("Q") || (func_type.equals("EXTERNAL"))) && (!((String)lineRecord.get("result_data")).equals(""))) {
							msg = insertResultDataClob(pstmt_clob, (String)lineRecord.get("result_data"), order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
							if (lineRecord.containsKey("organism_data"))
								//msg += insertOrganism(pstmt_organism, pstmt_organism_delete, (HashMap)lineRecord.get("organism_data"), order_id, report_srl_no, (String)lineRecord.get("srl_num"), (String)lineRecord.get("msr_id"), login_by_id, login_at_ws_no, login_facility_id);
								msg =msg+insertOrganism(pstmt_organism, pstmt_organism_delete, (HashMap)lineRecord.get("organism_data"), order_id, report_srl_no, (String)lineRecord.get("srl_num"), (String)lineRecord.get("msr_id"), login_by_id, login_at_ws_no, login_facility_id);

						}else if(rslt_type.equalsIgnoreCase("X")) {
							String result_data = "";
							//6484 Start.
							//result_data = getNoteResultDataClob(pstmt_clob1,accession_num, login_facility_id);
							//msg = insertResultDataClob(pstmt_clob,result_data, order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));

							HashMap resultMap= new HashMap();
							String compressResultYN ="N";
							String compressResult = "";
							resultMap = getNoteResultDataClob(pstmt_clob1,accession_num, login_facility_id);
							result_data = (String)resultMap.get("resultData");
							compressResultYN = (String)resultMap.get("compressResultYN");
							compressResult = (String)resultMap.get("compressResult");
							
							msg = insertResultDataWithCompress(connection,result_data,compressResultYN,compressResult, order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
							//6484 End.
							traceVal.append(msg);
						}
					} 
					else 
					{
						if(rslt_type.equals("*"))
						{
							
							pstmt_chart_result.setString(1,order_id);
							pstmt_chart_result.setString(2,(String)lineRecord.get("line_srl_num"));
							chart_resultSet=pstmt_chart_result.executeQuery();
							while(chart_resultSet.next())
							{
								charting_result = chart_resultSet.getString("chart_result");
							}
							closeResultSet(chart_resultSet);
							msg = insertResultDataClob(pstmt_clob,charting_result,order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
						}
						else if(rslt_type.equalsIgnoreCase("F")|| rslt_type.equalsIgnoreCase("Q") || (func_type.equals("EXTERNAL"))) 
						{
							msg = insertResultDataClob(pstmt_clob, (String)lineRecord.get("result_data"), order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));			
							if (lineRecord.containsKey("organism_data"))
								//msg += insertOrganism(pstmt_organism, pstmt_organism_delete, (HashMap)lineRecord.get("organism_data"), order_id, report_srl_no, (String)lineRecord.get("srl_num"), (String)lineRecord.get("msr_id"), login_by_id, login_at_ws_no, login_facility_id);
								msg =msg+insertOrganism(pstmt_organism, pstmt_organism_delete, (HashMap)lineRecord.get("organism_data"), order_id, report_srl_no, (String)lineRecord.get("srl_num"), (String)lineRecord.get("msr_id"), login_by_id, login_at_ws_no, login_facility_id);
						}
					}
                    traceVal.append(msg);
				}
				// Inserted the clob data.

				/*rec_result_type = (String)resultRecord.get("result_type");
				if(rec_result_type==null) rec_result_type="";
				if(!rec_result_type.trim().equals(""))
					if(!rec_result_type.trim().equals("N"))
						rec_result_type = "A";

				traceVal.append((String)resultRecord.get("result_status"));
				traceVal.append((String)resultRecord.get("order_status"));
				traceVal.append(rec_result_type);
				traceVal.append(","+(String)resultRecord.get("auth_reqd_yn_db")+",");
				traceVal.append((String)resultRecord.get("auth_reqd_yn"));


				
				orderStatus = (String)resultRecord.get("order_status");

				pstmt_status.clearParameters();
				pstmt_status.setString(1,(String)resultRecord.get("result_status"));
				pstmt_status.setString(2,(String)resultRecord.get("order_status"));
				pstmt_status.setString(3,rec_result_type);
				pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
				pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
				rs = pstmt_status.executeQuery();
				status = "";
				if(rs!=null && rs.next())
					status = (String)rs.getString("or_status");
				closeResultSet( rs ) ;
				traceVal.append("-10-'"+status+"'");

				pstmt_final_order_status.setString(1,order_id);
				
				rs= pstmt_final_order_status.executeQuery();
				if(rs!=null && rs.next())
					final_status=(String)rs.getString("ORDER_STATUS_CODE");
				closeResultSet( rs ) ;
				
				 pstmt_order.setString(1, final_status);	
				 if(orderStatus.equalsIgnoreCase("C"))
					pstmt_order.setString(2, final_status);
				 else pstmt_order.setString(2, "");			
				 pstmt_order.setString( 3, login_by_id ) ;
				 pstmt_order.setString( 4, login_at_ws_no ) ;
				 pstmt_order.setString( 5, login_facility_id ) ;
				 pstmt_order.setString( 6, order_id);
				 update_order = pstmt_order.executeUpdate();
				traceVal.append("11");*/

				// Handling the frequency explosion concept, for or_order. -- Start.
				
				if(!child_order_index.trim().equals("") || !parent_order_id.equals(""))
				{
					traceVal.append(" **FE--");
					traceVal.append(" childIndex = "+child_order_index);

					pstmt_parent.clearParameters();
					pstmt_parent.setString(1,order_id);
					rs1 = pstmt_parent.executeQuery();
					if(rs1!=null && rs1.next())
						parent_order_id = (String)rs1.getString("parent_order_id");
					closeResultSet( rs1 ) ;
					traceVal.append(" POrderId = "+parent_order_id);
					if(parent_order_id != null && !parent_order_id.trim().equals(""))
					{
						traceVal.append(" Parent Found ");
						p_result_status = "P";
						abnormal_child = null;
						if(child_order_index.trim().equals("L"))
						{
							p_result_status = (String)resultRecord.get("result_status");
							pstmt_abn_child_chk.setString(1, parent_order_id);
							rs5 = pstmt_abn_child_chk.executeQuery();
							if(rs5!=null && rs5.next())
							{
								abnormal_child = rs5.getString("abnormal_child");
								if(abnormal_child != null && abnormal_child.trim().equalsIgnoreCase("X"))
									any_abnormal_child = true;
							}
							closeResultSet( rs5 ) ;
						}
						pstmt_status.clearParameters();
							
						pstmt_status.setString(1,p_result_status);
						pstmt_status.setString(2,"C");
						if(any_abnormal_child)
							pstmt_status.setString(3,"A");
						else
							pstmt_status.setString(3,rec_result_type);
						pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
						pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
						pstmt_status.setString(6,"N");
						rs = pstmt_status.executeQuery();
						status = "";
						if(rs!=null && rs.next())
							status = (String)rs.getString("or_status");
						closeResultSet( rs ) ;
						traceVal.append(p_result_status+"C"+rec_result_type);
						traceVal.append((String)resultRecord.get("auth_reqd_yn_db"));
						traceVal.append((String)resultRecord.get("auth_reqd_yn"));
						 pstmt_order.setString(1, status);
						 pstmt_order.setString(2, status);
						 pstmt_order.setString(3, login_by_id ) ;
						 pstmt_order.setString(4, login_at_ws_no ) ;
						 pstmt_order.setString(5, login_facility_id ) ;
						 pstmt_order.setString(6, parent_order_id);
						 pstmt_order.executeUpdate();
						 // update_p_order = pstmt_order.executeUpdate();

						// Exploding frequency immediately after the last child.
						
						temp_result_status = (String)resultRecord.get("result_status");
						traceVal.append("#"+temp_result_status+"#");
						
						if(child_order_index.trim().equals("F") && temp_result_status.trim().equals("3"))
						{
							traceVal.append(" Exploding Frequency");
							pstmt_parent1.setString(1,parent_order_id);
							rs2 = pstmt_parent1.executeQuery();
							if(rs2!=null && rs2.next())
							{
								p_freq_code = (String)rs2.getString("p_freq_code");
								p_start_date_time = (String)rs2.getString("p_start_date_time");
								order_category = (String)rs2.getString("order_category");
								patient_class = (String)rs2.getString("patient_class");
								v_discrete_cont_order_yn = (String)rs2.getString("v_discrete_cont_order_yn");
							}
							traceVal.append("-"+p_freq_code+"-"+p_start_date_time+"-"+order_category+"-"+patient_class+"-"+v_discrete_cont_order_yn+"-");

							pstmt_freq_expl.setString(1,parent_order_id);
							pstmt_freq_expl.setString(2,p_freq_code);
							pstmt_freq_expl.setString(3,p_start_date_time);
							pstmt_freq_expl.setString(4,order_category);
							pstmt_freq_expl.setString(5,patient_class);
							pstmt_freq_expl.setString(6,v_discrete_cont_order_yn);
							pstmt_freq_expl.setString(7,login_at_ws_no);  //[IN041340]
							boolean explosion = pstmt_freq_expl.execute();
							traceVal.append("Frequency Explosion="+explosion);
						}
						 // Exploding frequency immediately after the last child.
					}
					traceVal.append("--FE** ");
				}
				// Handling the frequency explosion concept, for or_order. -- End.

				msr_panel_id = "";
				common_result_type = "";
				first_result_type = "";
				rti = 0;
				line_result_type = null;
				for (int i=0;i<sizeDetail;i++)
				{
					traceVal.append("12a");
					lineRecord = (HashMap)lineRecords.get(i);

					line_result_type = (String)lineRecord.get("result_type");
					traceVal.append("^"+line_result_type+"^");
					if(line_result_type==null) line_result_type="";
					if(!line_result_type.trim().equals(""))
						if(!line_result_type.trim().equals("N"))
						{
							line_result_type = "A";
							common_result_type = "A";
						}

					if(!msr_panel_id.equalsIgnoreCase((String)lineRecord.get("msr_panel_id")))
					{
						msr_panel_id = (String)lineRecord.get("msr_panel_id");
						first_result_type = line_result_type;
						rti = 1;
					}
					else
					{
						if(rti==1)	common_result_type = first_result_type;
						rti++;
						if(common_result_type.equals("A"))	line_result_type = "A";
						else if(common_result_type.equals("N"))	line_result_type = "N";
						common_result_type = line_result_type;
					}

					traceVal.append((String)lineRecord.get("result_status"));
					traceVal.append((String)resultRecord.get("order_status"));
					traceVal.append(line_result_type);
					traceVal.append((String)lineRecord.get("auth_reqd_yn_db"));
					traceVal.append((String)lineRecord.get("auth_reqd_yn"));

					status = "";
					orderStatus = (String)resultRecord.get("order_status");
					pstmt_status.clearParameters();
					
					pstmt_status.setString(1,(String)lineRecord.get("result_status"));
					pstmt_status.setString(2,(String)resultRecord.get("order_status"));
					pstmt_status.setString(3,line_result_type);
					pstmt_status.setString(4,(String)lineRecord.get("auth_reqd_yn_db"));
					pstmt_status.setString(5,(((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("N"))?"N":((String)lineRecord.get("auth_reqd_yn")));
					pstmt_status.setString(6,"N");
					rs = pstmt_status.executeQuery();
					if(rs!=null && rs.next())
						status = (String)rs.getString("or_status");
					closeResultSet( rs ) ;

					 pstmt_line.setString(1, status);
					if(orderStatus.equalsIgnoreCase("C"))
						pstmt_line.setString(2, status);
					else pstmt_line.setString(2, "");

					 pstmt_line.setString(3, login_by_id);
					 pstmt_line.setString(4, login_at_ws_no);
					 pstmt_line.setString(5, login_facility_id);
					 pstmt_line.setString(6, order_id);
					 pstmt_line.setString(7, (String)lineRecord.get("line_srl_num"));
					 pstmt_line.addBatch();
				traceVal.append(status+"12b-");

				// For Billing Related
				//if (!requestFrom.trim().equalsIgnoreCase("RA")) {
				try{
					traceVal.append("Order Status Result _ type"+(String)lineRecord.get("result_type"));
					traceVal.append("Order Status result_status"+(String)lineRecord.get("result_status"));
					traceVal.append("patient_id Ins"+patient_id);					
				  						
					if(((String)lineRecord.get("result_status")).equalsIgnoreCase("3"))
					{
						if ((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("Y") && ((String)lineRecord.get("auth_reqd_yn")).equalsIgnoreCase("Y")) || ((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("N")) && (!requestFrom.trim().equalsIgnoreCase("RA")))) 
						{    // && ((String)lineRecord.get("auth_reqd_yn")).equalsIgnoreCase("N")
							if(!old_srl_no.equals((String)lineRecord.get("line_srl_num")))
							{
							
								//cstmt_bl_result = connection.prepareCall("{ "+SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG+" }");
								cstmt_bl_result.setString(1,  patient_id);
								cstmt_bl_result.setString(2,  encounter_id);
								cstmt_bl_result.setString(3,  patient_class);
								//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&order_set_status_type_code.equalsIgnoreCase("85"))
								if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
								{
									cstmt_bl_result.setString(4,  order_set_id);
									cstmt_bl_result.setString(5,  "1");
								}
								else
								{
									cstmt_bl_result.setString(4,  order_id);
									cstmt_bl_result.setString(5,  (String)lineRecord.get("line_srl_num"));
								}
								cstmt_bl_result.setString(6, login_by_id);
								cstmt_bl_result.setString(7, login_at_ws_no);
								cstmt_bl_result.registerOutParameter( 8,  Types.VARCHAR ) ;
								cstmt_bl_result.registerOutParameter( 9,  Types.VARCHAR ) ;
								cstmt_bl_result.execute();
								bill_yn	 		= cstmt_bl_result.getString(8);
								
								if(bill_yn!=null && bill_yn.equals("Y"))
									err_bill_yn			= "Y";
								err_message 	= cstmt_bl_result.getString(9);


								if(err_message!=null && ! err_message.equals(""))
								{
									update_line		= 0;
									messages		= new StringBuffer();
									messages.append(err_message);
								}
							
					    		old_srl_no = (String)lineRecord.get("line_srl_num");

							}
						}
			  	  	}
	    		}catch(Exception ex)
	    		{
					update_line		= 0;
					ex.printStackTrace();
					traceVal.append("Exception Billing");
	    		}
			
				//}//End if !(ReportAuthorization)

					// Handling the frequency explosion concept, for or_order. -- Start.
					if(!child_order_index.trim().equals("") || !parent_order_id.equals(""))
					{
						traceVal.append(" **FE--");
	/*					traceVal.append(" childIndex = "+child_order_index);
						ResultSet rs1 ;
						pstmt_parent.clearParameters();
						pstmt_parent.setString(1,order_id);
						rs1 = pstmt_parent.executeQuery();
						if(rs1!=null && rs1.next())
							parent_order_id = (String)rs1.getString("parent_order_id");
						traceVal.append(" POrderId = "+parent_order_id);
	*/					if(parent_order_id != null && !parent_order_id.trim().equals(""))
						{
							traceVal.append(" Parent Found ");
							p_result_status = "P";
							if(child_order_index.trim().equals("L"))
								p_result_status = (String)resultRecord.get("result_status");
							pstmt_status.clearParameters();
							pstmt_status.setString(1,p_result_status);
							pstmt_status.setString(2,"C");
							if(any_abnormal_child)
								pstmt_status.setString(3,"A");
							else
								pstmt_status.setString(3,line_result_type);
							pstmt_status.setString(4,(String)lineRecord.get("auth_reqd_yn_db"));
							pstmt_status.setString(5,(((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("N"))?"N":((String)lineRecord.get("auth_reqd_yn")));
							pstmt_status.setString(6,"N");
							rs = pstmt_status.executeQuery();
							status = "";
							if(rs!=null && rs.next())
								status = (String)rs.getString("or_status");
							closeResultSet( rs ) ;

							traceVal.append(p_result_status+"C"+line_result_type);
							traceVal.append((String)lineRecord.get("auth_reqd_yn_db"));
							traceVal.append((String)lineRecord.get("auth_reqd_yn"));
							pstmt_parent_line.setString(1, status);
							pstmt_parent_line.setString(2, status);
							pstmt_parent_line.setString(3, login_by_id);
							pstmt_parent_line.setString(4, login_at_ws_no);
							pstmt_parent_line.setString(5, login_facility_id);
							pstmt_parent_line.setString(6, parent_order_id);
							pstmt_parent_line.setString(7, (String)lineRecord.get("line_srl_num"));
							//pstmt_parent_line.addBatch();
							pstmt_parent_line.executeUpdate();

						}
						traceVal.append("--FE** ");
					}
					// Handling the frequency explosion concept, for or_order. -- End.
				}
				update_l_status = pstmt_line.executeBatch();
				traceVal.append("13");

				 if((update_l_status.length > 0)){ //check updation in SYN
					 update_l_st = true;
				 }else if((update_l_status.length == (-3))){
					 update_l_st = false;
				 }

				// IN INSERT OR_ORDER UPDATION
				rec_result_type = (String)resultRecord.get("result_type");
				if(rec_result_type==null) rec_result_type="";
				if(!rec_result_type.trim().equals(""))
					if(!rec_result_type.trim().equals("N"))
						rec_result_type = "A";

				traceVal.append((String)resultRecord.get("result_status"));
				traceVal.append((String)resultRecord.get("order_status"));
				traceVal.append(rec_result_type);
				traceVal.append(","+(String)resultRecord.get("auth_reqd_yn_db")+",");
				traceVal.append((String)resultRecord.get("auth_reqd_yn"));


				
				orderStatus = (String)resultRecord.get("order_status");

				pstmt_status.clearParameters();
				pstmt_status.setString(1,(String)resultRecord.get("result_status"));
				pstmt_status.setString(2,(String)resultRecord.get("order_status"));
				pstmt_status.setString(3,rec_result_type);
				pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
				pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
				pstmt_status.setString(6,"N");
				rs = pstmt_status.executeQuery();
				status = "";
				if(rs!=null && rs.next())
					status = (String)rs.getString("or_status");
				closeResultSet( rs ) ;
				traceVal.append("-10-'"+status+"'");

				pstmt_final_order_status.setString(1,order_id);
				
				rs= pstmt_final_order_status.executeQuery();
				if(rs!=null && rs.next())
					final_status=(String)rs.getString("ORDER_STATUS_CODE");
				closeResultSet( rs ) ;
		
				 pstmt_order.setString(1, final_status);	
				 if(orderStatus.equalsIgnoreCase("C"))
					pstmt_order.setString(2, final_status);
				 else pstmt_order.setString(2, "");			
				 pstmt_order.setString( 3, login_by_id ) ;
				 pstmt_order.setString( 4, login_at_ws_no ) ;
				 pstmt_order.setString( 5, login_facility_id ) ;
				 pstmt_order.setString( 6, order_id);
				 update_order = pstmt_order.executeUpdate();
				traceVal.append("11");


				// Billing Consolidated Procedure
				//if (!requestFrom.trim().equalsIgnoreCase("RA")) {
				if (insert_header > 0 && insert_dl && update_order > 0 && update_l_st && update_line > 0){

					if(err_bill_yn.equals("Y"))
					{
						//cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE+" }");

						//cstmt.setString(1,  login_facility_id);// commentted--[IN032859]
						cstmt.setString(1,  l_facility_id);//--[IN032859]
						cstmt.setString(2,  patient_id);
						if( patient_class!=null && (patient_class.equals("IP") || patient_class.equals("EA")) )
							cstmt.setString(3, "I");
						else if( patient_class!=null && (patient_class.equals("DC") ))
							cstmt.setString(3, "D");
						else if( patient_class!=null && (patient_class.equals("EM") ))
							cstmt.setString(3, "E");
						else if( patient_class!=null && (patient_class.equals("OP") ))
							cstmt.setString(3, "O");
						else		// XT
							cstmt.setString(3, "R");			// EPISODE_TYPE
						cstmt.setString(4,  episode_id);		// EPISODE_ID
						cstmt.setString(5,  episode_visit_num); // VISIT_NUM
						//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&order_set_status_type_code.equalsIgnoreCase("85"))
						if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
						{
							cstmt.setString(6,order_set_id); 			// ORDER_ID
						}
						else
						{
							cstmt.setString(6,order_id); 			// ORDER_ID
						}
						cstmt.setString(7,  "OR");
						cstmt.setString(8,  null);
						cstmt.setString(9,  login_by_id);
						cstmt.setString(10, login_at_ws_no);
						cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
						cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
						cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
						cstmt.execute();
						err_code 	= cstmt.getString(11);  // ERR_CODE
						message_id 	= cstmt.getString(12);  // SYS_MESSAGE_ID
						err_message			= cstmt.getString(13);  // ERROR_TEXT
						if(err_code!=null && !err_code.equals("") && !err_code.equals("10") && err_message!=null && !err_message.equals(""))
						{
							update_line		= 0;			// Come out
							messages		= new StringBuffer();
							messages.append( err_message ) ;
						} else if(message_id!=null && !message_id.equals("") )  //Query from the sm_message and display the message
						{
							update_line		= 0;				// Come out
							messages		= new StringBuffer();

							// Query from the database for the message id and display the Message
							pstmt_message.clearParameters();
							pstmt_message.setString(1, message_id);
							rs=pstmt_message.executeQuery();
							if(rs!=null)
							{
								while(rs.next())
								{
									messages.append(rs.getString(1));
								}
							}
							closeResultSet( rs ) ;
						}
					} //err
		  		}

		  		// For Billing Module
			try
			{
		
				if (insert_header > 0 && insert_dl && update_order > 0 && update_l_st && update_line > 0)
				{
					if(err_bill_yn.equals("Y"))
					{
 					   old_srl_no = "";
					   for (int i=0;i<sizeDetail;i++)
	   					{
							lineRecord = (HashMap)lineRecords.get(i);

							if(((String)lineRecord.get("result_status")).equalsIgnoreCase("3") && update_line > 0)
							{
								if ((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("Y") && ((String)lineRecord.get("auth_reqd_yn")).equalsIgnoreCase("Y")) || ((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("N")) && (!requestFrom.trim().equalsIgnoreCase("RA")))) {    // && ((String)lineRecord.get("auth_reqd_yn")).equalsIgnoreCase("N")
			  						if(!old_srl_no.equals((String)lineRecord.get("line_srl_num")))
			  						{
			  							//cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED+" }");
										//cstmt_bl_ext_service.setString(1,  login_facility_id); //--[IN032859] - commented
										
										cstmt_bl_ext_service.setString(1,  l_facility_id); //--[IN032859]
										cstmt_bl_ext_service.setString(2,  "OR");
										//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type_code.equalsIgnoreCase("85")))
										if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
										{
											cstmt_bl_ext_service.setString(3,order_set_id);
											cstmt_bl_ext_service.setString(4,"1");
										}
										else
										{
											cstmt_bl_ext_service.setString(3,order_id);
											cstmt_bl_ext_service.setString(4,(String)lineRecord.get("line_srl_num"));
										}
										cstmt_bl_ext_service.registerOutParameter( 5,  Types.VARCHAR ) ;
										cstmt_bl_ext_service.registerOutParameter( 6,  Types.VARCHAR ) ;
										cstmt_bl_ext_service.registerOutParameter( 7,  Types.VARCHAR ) ;
										cstmt_bl_ext_service.registerOutParameter( 8,  Types.VARCHAR ) ;

										cstmt_bl_ext_service.execute();

										charged_yn  		= cstmt_bl_ext_service.getString(5);
										err_code  			= cstmt_bl_ext_service.getString(6);
										message_id 			= cstmt_bl_ext_service.getString(7);
										err_message 		= cstmt_bl_ext_service.getString(8);
									
										if(err_message!=null && ! err_message.equals(""))
										{
											update_line		= 0;
											messages		= new StringBuffer();
											messages.append(err_message);
			   							}
			   							//else if(message_id!=null && !message_id.equals("") )  //Query from the sm_message and display the message
										else
										{
											/*update_line		= 0;				// Come out
											messages		= new StringBuffer();
											// Query from the database for the message id and display the Message
											mess			= getMMessage(pstmt_message, message_id);
											messages.append(mess);
											if(!mess.equals("")){*/
 												//cstmt_bl_ext_chrg_stage = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE+" }");

 											
												if(!(order_id.substring(0,2).equals("OH")))
												{
													if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
													{
														pstmt_set_status.setString(1,order_set_id);
														resultset_status = pstmt_set_status.executeQuery();
														while(resultset_status.next())
														{
															order_set_status_type = resultset_status.getString("order_status_type");
														}
														//closeStatement(pstmt_set_status);
														if (pstmt_set_status != null)pstmt_set_status.close();//15950
														closeResultSet(resultset_status);		
													}
																
													if(order_set_status_type==null) order_set_status_type="0";
													orderstatustype = Integer.parseInt(order_set_status_type);
												pstmt8.setString(1, order_id);
												pstmt8.setString(2, (String)lineRecord.get("line_srl_num"));
												
												billResultSet = pstmt8.executeQuery();
												if (billResultSet.next()) 
												{
													p_bill_yn	= billResultSet.getString("bill_yn");
												}
												closeResultSet(billResultSet);	
												if(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((orderstatustype>57)))||((order_set_bill_yn.equalsIgnoreCase("N"))&&(p_bill_yn.equalsIgnoreCase("Y"))))
												{
														//cstmt_bl_ext_chrg_stage.setString(1,  login_facility_id);//Commentted--[IN032859]
														cstmt_bl_ext_chrg_stage.setString(1,  l_facility_id);//--[IN032859]
														//cstmt_bl_ext_chrg_stage.setString(2,  "OR");
														//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type_code.equalsIgnoreCase("85")))
														if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((orderstatustype>57)))					
														{
															cstmt_bl_ext_chrg_stage.setString(2,order_set_id);
															cstmt_bl_ext_chrg_stage.setString(3,"1");
														}
														else
														{
															cstmt_bl_ext_chrg_stage.setString(2,  order_id);
															cstmt_bl_ext_chrg_stage.setString(3,  (String)lineRecord.get("line_srl_num"));
														}
														cstmt_bl_ext_chrg_stage.setString(4,  "RST");
														//cstmt_bl_ext_chrg_stage.setString(6,  (String)lineRecord.get("order_catalog_code"));
														cstmt_bl_ext_chrg_stage.setString(5,  login_by_id);
														cstmt_bl_ext_chrg_stage.setString(6, login_at_ws_no);
													 
														cstmt_bl_ext_chrg_stage.registerOutParameter( 7,  Types.VARCHAR ) ;
														cstmt_bl_ext_chrg_stage.registerOutParameter( 8,  Types.VARCHAR ) ;
														cstmt_bl_ext_chrg_stage.setString(9, "OR");//IN071315
			
														cstmt_bl_ext_chrg_stage.execute();
														message_id 			= cstmt_bl_ext_chrg_stage.getString(7);
														err_message 		= cstmt_bl_ext_chrg_stage.getString(8);
														if(err_message!=null && ! err_message.equals(""))
														{
															update_line		= 0;
															messages		= new StringBuffer();
															messages.append(err_message);
														}
														else if(message_id!=null && !message_id.equals("") )  //Query from the sm_message and display the message
														{
															update_line		= 0;				// Come out
															messages		= new StringBuffer();
															// Query from the database for the message id and display the Message
															mess			= getMMessage(pstmt_message, message_id);
															messages.append(mess);
														}
													}
												}
										}
									//}

										if(update_line >0 && charged_yn!=null && charged_yn.equals("Y"))  //only if it is'Y' other wise it will be 'N' already
										{
											pstmt_bill_update.setString(1, charged_yn);
			  								pstmt_bill_update.setString(2, login_by_id);
			 								pstmt_bill_update.setString(3, login_at_ws_no);
			 								pstmt_bill_update.setString(4, login_facility_id);
											//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type_code.equalsIgnoreCase("85")))
											if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
											{
												pstmt_bill_update.setString(5,order_set_id);
			  									pstmt_bill_update.setString(6,"1");
											}
											else
											{
												pstmt_bill_update.setString(5, order_id);
			  									pstmt_bill_update.setString(6, (String)lineRecord.get("line_srl_num"));
											}

											update_line = pstmt_bill_update.executeUpdate();
										}
										old_srl_no = (String)lineRecord.get("line_srl_num");
	   	 	  						}
	    	  					}
	       					}
	     				}
	    			}
					
					for (int i=0;i<sizeDetail;i++)
	   				{
						lineRecord = (HashMap)lineRecords.get(i);
						String result_type= (String)lineRecord.get("rslt_type");
						String order_line=(String)lineRecord.get("line_srl_num");
						if(result_type.equals("*"))
						{
							cstmt_freq_auto_close.setString(1,order_id);
							cstmt_freq_auto_close.setString(2,order_line);
							cstmt_freq_auto_close.registerOutParameter( 3,  Types.VARCHAR ) ;
							cstmt_freq_auto_close.execute();
							p_error_msg  		= cstmt_freq_auto_close.getString(3);
						}
					}
	   			 }
	  		   }catch(Exception e)
	  		   {
					update_line		= 0;
					e.printStackTrace();
					traceVal.append("Exception Billing Last");
	  			}
				//}//End If requestFrom != (RA)
				traceVal.append("#"+insert_header+","+insert_dl+","+update_order+","+update_l_st+","+update_line);
				if (insert_header > 0 && insert_dl && update_order > 0 && update_l_st && update_line > 0 )
				{
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append("RECORD_INSERTED") ;
				}
				else
				{
						connection.rollback();
						if(update_line!=0)
							messages.append( "Insert Failed" ) ;
				}

		 }
		 catch( Exception e )
		 {
			

			try
			{
				connection.rollback();
				closeConnection( connection,pt );
				//closeConnection(connection);
			} 
			catch ( Exception ee ) 
			{
				messages.append(ee.getMessage() ) ;
			}
			

			if(e.getMessage().contains("ORA-00001"))
			{
				messages.setLength(0);
				messages.append( "APP-OR0000 The same order "+order_id+" is inserted  by other user. Please recheck." ) ;
			}
			else
			{
				traceVal.append("In Exception==");
				e.printStackTrace();
				traceVal.append(e);
				traceVal.append("#"+e.getMessage());
				map.put( "traceVal", traceVal.toString() ) ;
				messages.append( e.getMessage() ) ;
			}

		  }
		  finally
		  {
				try 
				{
					closeResultSet( rs ) ;
					closeResultSet( rs_bl ) ;//--[IN032859]
					closeStatement( pstmt_detail ) ;
					closeStatement( pstmt_status ) ;
					closeStatement( pstmt_bl ) ;//--[IN032859]
					closeResultSet( rs1 ) ;
					closeStatement( pstmt_order ) ;
					closeStatement( pstmt_line ) ;
					closeStatement( pstmt_parent_line ) ;
					closeStatement( pstmt_line1);
					closeStatement( pstmt_clob ) ;
					closeStatement( pstmt_organism );
					closeStatement( pstmt_header ) ;
					closeStatement( pstmt_detail ) ;
					closeStatement( pstmt_status ) ;
					closeStatement( pstmt_order ) ;
					closeStatement( pstmt_final_order_status ) ;
					closeStatement( pstmt_proclink_insert ) ;
					closeStatement( pstmt_proclink_insert_srl_no ) ;
					closeStatement( pstmt_chart_result ) ;
					
					
					closeStatement( pstmt_organism_delete ) ;
					closeResultSet( rs5 ) ;
					closeResultSet( rs2 ) ;
					closeStatement( pstmt_parent ) ;
					closeStatement( pstmt_parent1 ) ;
					closeStatement( pstmt_freq_expl ) ;
					closeStatement( pstmt_abn_child_chk ) ;
					closeStatement( pstmt8 ) ;

					closeStatement( pstmt_bill_update ) ;
					closeStatement( pstmt_message ) ;

					closeStatement( cstmt);
					closeStatement( cstmt_bl_result);
					closeStatement( cstmt_bl_ext_service);
					closeStatement( cstmt_bl_ext_chrg_stage);
					closeStatement( cstmt_freq_auto_close);
					
					closeStatement( pstmt_header);
					closeStatement( pstmt_clob1);
					
					closeStatement( pstmt_proc_desc ) ;  //Checkstyle
					closeStatement( pstmt_set_status ) ;  //Checkstyle
					
					closeConnection( connection,pt);
					//closeConnection(connection);
				} 
				catch ( Exception fe )
				{
					fe.printStackTrace() ;
				}
			}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
		return map ;


	}//End of Insert Method

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify(HashMap tabDataParam , HashMap sqlMap )
	{
		StringBuffer messages = null ;
		StringBuffer traceVal = null ;
		HashMap map = null;

		Properties  pt = null;
		Connection connection = null ;
		//PreparedStatement pstmt	    	= null ; //Checkstyle
		PreparedStatement pstmt_header	    	= null ;
		PreparedStatement pstmt_detail		    = null ;
		PreparedStatement pstmt_proclink	    = null ;
		PreparedStatement pstmt_procdelete	    = null ;
		PreparedStatement pstmt_status		    = null ;
		PreparedStatement pstmt_order			= null ;
		PreparedStatement pstmt_line 			= null ;
		PreparedStatement pstmt_parent_line		= null ;
		PreparedStatement pstmt_line1 			= null ;
		PreparedStatement pstmt_clob			= null ;
		PreparedStatement pstmt_clob1			= null ;
		PreparedStatement pstmt_parent			= null ;
		PreparedStatement pstmt_organism		= null ;
		PreparedStatement pstmt_organism_delete		= null ;
		PreparedStatement pstmt_parent1		= null ;
		PreparedStatement pstmt_freq_expl		= null ;
		PreparedStatement pstmt_abn_child_chk	= null ;
		PreparedStatement pstmt_bill_update		= null ;
		PreparedStatement pstmt_message			= null ;
		PreparedStatement pstmt_final_order_status	    = null ;
		PreparedStatement pstmt_child_order_index		= null ;
		PreparedStatement pstmt_chart_result			= null ;
		PreparedStatement pstmt_proclink_insert			= null ;
		PreparedStatement pstmt_proclink_delete			= null ;
		PreparedStatement pstmt_proclink_insert_srl_no	= null ;
		PreparedStatement pstmt_proc_desc	= null ;
		PreparedStatement pstmt8 			= null;
		PreparedStatement pstmt_set_status 	= null;
		PreparedStatement pstmt_proc_code 	= null;
		PreparedStatement pstdelete = null;
		PreparedStatement pstmt_bl 										= null;//--[IN032859]
		CallableStatement cstmt 				= null;
		CallableStatement cstmt_bl_result 		= null;
		CallableStatement cstmt_bl_ext_service	= null;
		CallableStatement cstmt_bl_ext_chrg_stage= null;
		CallableStatement cstmt_freq_auto_close= null;
		
		ResultSet rs 	= null;
		//ResultSet resultSet 	= null; //Checkstyle
		ResultSet rs1  = null;
		ResultSet rs2 = null;
	 	ResultSet rs5 = null;
	 	ResultSet rs6 = null;
	 	ResultSet chart_resultSet = null;
		ResultSet resultSet_srl_no = null;
		ResultSet billResultSet 			= null;
		ResultSet resultset_status 			= null;
		ResultSet resultset_proc_code 			= null;
		ResultSet rs_bl													= null;//--[IN032859]
		String charting_result="";
		String final_status="";
		String l_facility_id		= "";//--[IN032859]

		//String proc_code_resulted_token1="";
		int srl_no = 0;
		try
		{
				messages = new StringBuffer() ;
				traceVal = new StringBuffer() ;
				map = new HashMap() ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "flag", "flag" ) ;

				traceVal.append("----- UPDATE CALLED -----");

				HashMap tabData			=(HashMap)tabDataParam.get("tabData");
				pt			   			=(Properties)tabDataParam.get("properties");
				connection				= getConnection(pt) ;
	//			connection				= getConnection() ;

				ArrayList lineRecords		=(ArrayList)tabData.get("lineRecords");
				ArrayList proc_term_set_id	= new ArrayList();
				ArrayList proc_term_set_code	= new ArrayList();
				ArrayList proc_code_resulted_token1	= new ArrayList();
				HashMap resultRecord		=(HashMap)tabData.get("resultRecord");
				HashMap commonRecord		=(HashMap)tabData.get("CommonRecords");
				int update_header = 0;
				int update_detail[] = {};
				int update_l_status[] = {};
				int update_order = 0;
				//int update_p_order = 0;
				//int update_p_line = 0;
				int update_line   = 1;
			
				boolean   update_dl = false ;
				boolean   update_l_st = false;

				String err_message	= "";				
				String bill_yn		= "N";
				String err_bill_yn  = "N";
				String old_srl_no	= "";
				String err_code		= "";
				String message_id	= "";
				String charged_yn	= "N";

				String login_by_id			=(String)commonRecord.get("login_by_id" ) ;
				String login_at_ws_no		=(String)commonRecord.get("login_at_ws_no" ) ;
				String login_facility_id	=(String)commonRecord.get("login_facility_id" ) ;
				String order_type_code		=(String)commonRecord.get("order_type_code" ) ;
				String order_id			    =(String)commonRecord.get("order_id" ) ;
				String order_set_id			=(String)commonRecord.get("order_set_id" ) ;
				String order_set_bill_yn	=(String)commonRecord.get("order_set_bill_yn" ) ;
				String child_order_index	=(String)commonRecord.get("child_order_index" ) ;
				String child_reporting_date	=(String)commonRecord.get("child_reporting_date" ) ;
				
				String parent_order_id		=(String)((commonRecord.get("parent_order_id")==null)?"":commonRecord.get("parent_order_id"));
				boolean any_abnormal_child	= false;
				String report_srl_no	    =(String)commonRecord.get("report_srl_no" );
				String patient_id		    =(String)commonRecord.get("patient_id" );
				String hdr_practitioner_id		    =(String)commonRecord.get("practitioner_id" );
				String requestFrom			= (String)((commonRecord.get("requestFrom")==null)?"":commonRecord.get("requestFrom"));
				String proc_scheme_code			= (String)((commonRecord.get("proc_scheme_code")==null)?"":commonRecord.get("proc_scheme_code"));
				//String accession_num			= (String)((commonRecord.get("accession_num")==null)?"":commonRecord.get("accession_num"));
				String accession_num			="";

				String encounter_id		    = "";
				String proc_encounter_id		    = "";//IN029323
				String patient_class	    = "";
				String mess			= "";

				HashMap lineRecord 		= null;
				String p_error_msg="";
				String order_set_status_type = "0";
				int orderstatustype = 0;
				//String order_set_status_type_code=""; //Checkstyle
				String p_bill_yn = "";

				traceVal.append("1");

				 String SQL_OR_RESULT_REPORTING_UPDATE_HEADER	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_HEADER");
				 String SQL_OR_RESULT_REPORTING_UPDATE_DETAIL	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_DETAIL");
				 String SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC	= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC");
				 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER		= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER");
				 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE");
				 String SQL_OR_RESULT_REPORTING_UPDATE_CLOB		= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_UPDATE_CLOB");
				 String SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB			= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB");
				 String SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS			= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS");
				 String SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT= (String)sqlMap.get("SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT");
				 String SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT");
				 String SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION");
				 String SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK");
				 String SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG  = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG");
				 String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE  = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE");
				 String SQL_OR_ORDER_ENTRY_BILL_MESSAGE			= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
				 String SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS");
				 String SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION");
				 String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED");
				 String SQL_OR_ORDER_GET_STATUS_CODE	= (String)sqlMap.get("SQL_OR_ORDER_GET_STATUS_CODE");

				//String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE= (String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE");
				 String SQL_OR_RESULT_ENTRY_ORGANISM_INSERT= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ORGANISM_INSERT");
				 String SQL_OR_RESULT_ENTRY_ORGANISM_DELETE	= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_ORGANISM_DELETE");
				 String SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT	= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT");
				 String SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_DELETE	= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_DELETE");
				 String SQL_OR_BL_WITHOUT_ORDER_CATALOG	= (String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG");
				 String SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE= (String)sqlMap.get("SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE");
				// String order_set_status_query = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE");//15950
				 //String order_set_status_query_code = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE");//15950
				 //String update_order_set_status = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS");//15950
				 //String update_order_set_line_status = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS");//15950
				 String update_chart_result = (String)sqlMap.get("SQL_OR_ORDER_GET_CHART_RESULT");
				 String proc_link_encounter_insert = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_INSERT");
				 String proc_link_encounter_delete = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_DELETE");
				 String proc_link_encounter_srl_no = (String)sqlMap.get("SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_ENCOUNTER_SRL_NO");
				 String proc_desc = "select short_desc from mr_term_code where term_code=? and term_set_id=?";


				 traceVal.append("2");

				 java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("dd/MM/yyyy H:m");
				 java.util.Date today = new java.util.Date();
				 String dateString = dt.format(today);

				 traceVal.append("3");

				pstmt_header = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_HEADER);
				pstmt_detail = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_DETAIL);
				pstmt_procdelete = connection.prepareStatement(SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_DELETE);
				pstmt_proclink = connection.prepareStatement(SQL_OR_RESULT_ENTRY_PROCEDURE_LINK_INSERT);
				pstmt_status = connection.prepareStatement(SQL_OR_RESULT_REPORTING_GET_STATUS_FUNC);
				pstmt_order = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER);
				pstmt_line = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE);
				pstmt_line1 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE_STATUS);
				pstmt_clob = connection.prepareStatement(SQL_OR_RESULT_REPORTING_UPDATE_CLOB);
				pstmt_clob1 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_NOTE_DATA_CLOB);
				pstmt_final_order_status	 = connection.prepareStatement(SQL_OR_ORDER_GET_STATUS_CODE);
				pstmt_parent = connection.prepareStatement(SQL_OR_RESULT_REPORTING_PARENT_ORDERS_SELECT);
				pstmt_parent1 = connection.prepareStatement(SQL_OR_RESULT_ENTRY_PARENT_ORDERS_SELECT);
				pstmt_freq_expl = connection.prepareStatement(SQL_OR_RESULT_ENTRY_FREQUENCY_EXPLOSION);
				pstmt_abn_child_chk = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ABNORMAL_CHILD_CHECK);
                pstmt_organism = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ORGANISM_INSERT);
				pstmt_organism_delete = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ORGANISM_DELETE);

				pstmt_bill_update 	= connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION);
				pstmt_message		= connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILL_MESSAGE);
				pstmt_proclink_insert	 = connection.prepareStatement(proc_link_encounter_insert);
				pstmt_proclink_delete	 = connection.prepareStatement(proc_link_encounter_delete);
				pstmt_proclink_insert_srl_no	 = connection.prepareStatement(proc_link_encounter_srl_no);
				cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE+" }");
				cstmt_bl_result		=	connection.prepareCall("{ "+SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG+" }");
				cstmt_bl_ext_service = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED+" }");
				//cstmt_bl_ext_chrg_stage = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE+" }");
				cstmt_bl_ext_chrg_stage = connection.prepareCall("{ "+SQL_OR_BL_WITHOUT_ORDER_CATALOG+" }");
				cstmt_freq_auto_close = connection.prepareCall("{ "+SQL_OR_RESULT_ENTRY_FREQ_AUTO_CLOSE+" }");
				pstmt_chart_result	 = connection.prepareStatement(update_chart_result);
				pstmt_proc_desc	 = connection.prepareStatement(proc_desc);
				String bill_sql = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
				pstmt8 = connection.prepareStatement(bill_sql) ;
				pstmt_set_status = connection.prepareStatement("select order_status_type from or_order a,or_order_status_code b where   b.order_status_code=a.order_status and order_id=?"); // --[IN028670]--
				//traceVal.append("order_type_code="+order_type_code);
				//traceVal.append("order_id="+order_id);
				//traceVal.append("report_srl_no="+report_srl_no);
				//traceVal.append("rpt_pract_id="+(String)resultRecord.get("rpt_pract_id"));
				//start for change in child_order_index
				//--[IN032859] - Start
				if (!order_id.equals("")) 
				{ 
					pstmt_bl = connection.prepareStatement("select ordering_facility_id from or_order where order_id =?");
					pstmt_bl.setString(1, order_id); 
					rs_bl	= pstmt_bl.executeQuery() ;
					if ( rs_bl != null )
					{
						while(rs_bl.next())
						{
							l_facility_id = rs_bl.getString( "ordering_facility_id" )  ;
						}
					}
				}
				else
				{
					l_facility_id = login_facility_id;
				}
				//--[IN032859] - End	
				if(!parent_order_id.trim().equals(null) && !parent_order_id.equals(""))
				{
					pstmt_child_order_index = connection.prepareStatement("SELECT NVL2(END_DATE_TIME,'L','F') CHILD_ORDER_INDEX FROM  OR_ORDER_LINE	WHERE PARENT_ORDER_ID=? AND ORDER_ID=(SELECT MAX(ORDER_ID) FROM OR_ORDER WHERE PARENT_ORDER_ID=?) AND ORDER_ID=?");
					pstmt_child_order_index.clearParameters();
					pstmt_child_order_index.setString(1, parent_order_id);
					pstmt_child_order_index.setString(2, parent_order_id);
					pstmt_child_order_index.setString(3, order_id);
					rs6 = pstmt_child_order_index.executeQuery();
					
					if(rs6!=null && rs6.next())
					{
						child_order_index		= rs6.getString( "CHILD_ORDER_INDEX" );
							
					}
					closeResultSet( rs6 ) ;
					closeStatement( pstmt_child_order_index ) ;
				}
				//End for change in child_order_index
				pstmt_parent_line = connection.prepareStatement(SQL_OR_RESULT_ENTRY_UPDATE_OR_ORDER_LINE);

				String auth_reqd_yn1		= (String)resultRecord.get("auth_reqd_yn") ;
				String auth_reqd_id1		= "";
				String auth_reqd_time1		= null;
				if(auth_reqd_yn1.trim().equalsIgnoreCase("Y"))
				{
					auth_reqd_id1	= (String)commonRecord.get("practitioner_id");
					auth_reqd_time1  = dateString;
				}

				pstmt_header.setString(1 ,(String)resultRecord.get("rpt_pract_id"));

				if(child_order_index.trim().equals(""))
					pstmt_header.setString(2 ,dateString);	// Enter system date in case of a normal order.
				else
					pstmt_header.setString(2 ,child_reporting_date); // Enter Child Reporting Time in case of Frequency Explosion.

				pstmt_header.setString(3 ,(String)resultRecord.get("auth_reqd_yn_db"));
				pstmt_header.setString(4 ,auth_reqd_id1);
				pstmt_header.setString(5 ,auth_reqd_time1);
				pstmt_header.setString(6 ,(String)resultRecord.get("result_status"));
				String tmp_result_type = (String)resultRecord.get("result_type");
				if(tmp_result_type==null || tmp_result_type.equals("null"))	tmp_result_type="";
				pstmt_header.setString(7 ,tmp_result_type);
				pstmt_header.setString(8 ,login_by_id);
				pstmt_header.setString(9 ,login_at_ws_no);
				pstmt_header.setString(10 ,login_facility_id);
				pstmt_header.setString(11 ,order_type_code);
				pstmt_header.setString(12 ,order_id);
				pstmt_header.setString(13 ,report_srl_no);

				traceVal.append("4");

				update_header	 = pstmt_header.executeUpdate();
				traceVal.append("5===update_header");
				closeStatement( pstmt_header);

				String episode_id 			=  "";
				String episode_visit_num 	=  "";
				patient_class 				=  "";

				pstmt_header = connection.prepareStatement(SQL_OR_RESULT_ENTRY_ENCOUNTER_ID_DETAILS);
				pstmt_header.clearParameters();
				pstmt_header.setString(1, order_id);
				rs = pstmt_header.executeQuery();
				if(rs!=null && rs.next())
				{
					//encounter_id		= rs.getString( "encounter_id" );//IN029323
					encounter_id		= rs.getString( "encounter_id" )==null?"":rs.getString( "encounter_id" );//IN029323
					patient_class 		= rs.getString( "patient_class" );
					episode_id			= rs.getString( "episode_id" );
					episode_visit_num 	= rs.getString( "episode_visit_num" );
				}
				closeResultSet( rs ) ;
				closeStatement( pstmt_header ) ;
				int sizeDetail	= lineRecords.size()  ;
				traceVal.append("pstmt_header 1307");
				traceVal.append("sizeDetail"+lineRecords.size() );

				String auth_reqd_time	= null;
				String auth_reqd_yn		= null;
				String auth_reqd_id		= null;
				String rec_result_type	= null;
				String result_comments = null; // added for IN048091
				for (int i=0;i<sizeDetail;i++)
				{
					lineRecord = (HashMap)lineRecords.get(i);
				 traceVal.append("7");

					if(child_order_index.trim().equals(""))
						pstmt_detail.setString(1 ,dateString);	// Enter system date in case of a normal order.
					else
						pstmt_detail.setString(1 ,child_reporting_date); // Enter Child Reporting Time in case of Frequency Explosion.

					auth_reqd_yn		= (String)lineRecord.get("auth_reqd_yn") ;
					auth_reqd_id		= "";
					if((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("Y")) && (auth_reqd_yn.trim().equalsIgnoreCase("Y")))
					{
						auth_reqd_id	= (String)commonRecord.get("practitioner_id");
						auth_reqd_time  = dateString;
					}
					traceVal.append("8sssss");
					result_comments = java.net.URLDecoder.decode((String)lineRecord.get("result_comments"));  //  IN048091
					pstmt_detail.setString(2 ,(String)resultRecord.get("auth_reqd_yn_db"));
					pstmt_detail.setString(3 ,auth_reqd_id);
					pstmt_detail.setString(4 ,auth_reqd_time);
					tmp_result_type = (String)lineRecord.get("result_type");
					if(tmp_result_type==null || tmp_result_type.equals("null"))	tmp_result_type="";
					pstmt_detail.setString(5 ,tmp_result_type);
					pstmt_detail.setString(6 ,(String)lineRecord.get("result_num"));
					pstmt_detail.setString(7 ,(String)lineRecord.get("result_str"));
					pstmt_detail.setString(8 ,(String)lineRecord.get("result_status"));
					//pstmt_detail.setString(9 ,(String)lineRecord.get("norm_abnorm_ind"));
					pstmt_detail.setString(9 ,tmp_result_type);
					//pstmt_detail.setString(10 ,(String)lineRecord.get("result_comments")); //  IN048091
					pstmt_detail.setString(10 ,result_comments); // modified for IN048091
					pstmt_detail.setString(11 ,login_by_id);
					pstmt_detail.setString(12 ,login_at_ws_no);
					pstmt_detail.setString(13 ,login_facility_id);
					pstmt_detail.setString(14 ,(String)lineRecord.get("accession_num"));
					pstmt_detail.setString(15 ,(String)lineRecord.get("practitioner_id"));
					pstmt_detail.setString(16 ,order_type_code);
					pstmt_detail.setString(17 ,order_id);
					pstmt_detail.setString(18 ,report_srl_no);
					pstmt_detail.setString(19 ,(String)lineRecord.get("line_srl_num"));
					pstmt_detail.setString(20 ,(String)lineRecord.get("srl_num"));

					pstmt_detail.addBatch();

					accession_num = (String)lineRecord.get("accession_num")==null?"":(String)lineRecord.get("accession_num");
					/* if(!accession_num.equals("")){
						
						String last_action_type="";
						if(!accession_num.equals(""))
							last_action_type="NT";
						pstmt_line1.setString(1,accession_num.trim());
						pstmt_line1.setString(2,last_action_type.trim());
						pstmt_line1.setString(3,login_by_id ) ;
						pstmt_line1.setString(4,login_at_ws_no ) ;
						pstmt_line1.setString(5,login_facility_id ) ;
						pstmt_line1.setString(6,order_id.trim());
						pstmt_line1.setInt(7, (i+1));
						int xx = pstmt_line1.executeUpdate() ;
					 }*/
				}

				 update_detail = pstmt_detail.executeBatch();
				 
				 if((update_detail.length > 0)){ //check updation in SYN
							update_dl= true ;
				 }else if((update_detail.length == (-3))){
							update_dl= false ;
				 }
			
				String  temp_scheme="";	
 				 for (int i=0;i<sizeDetail;i++)
				{
					 lineRecord = (HashMap)lineRecords.get(i);
					 pstmt_proc_code = connection.prepareStatement("select PROC_CODE, PROC_CODE_SCHEME from pr_encounter_procedure where ORDER_ID=? and ORDER_LINE_NUM=?");
					 pstmt_proc_code.setString(1,order_id);
					 pstmt_proc_code.setString(2,(String)lineRecord.get("line_srl_num"));
					 resultset_proc_code = pstmt_proc_code.executeQuery();
					 while (resultset_proc_code != null && resultset_proc_code.next())
					{
							 String[] record = new String[3] ;
							 record[0]= resultset_proc_code.getString("PROC_CODE");
							 //record[1]= resultset_proc_code.getString("PROC_CODE_SCHEME");
							 proc_term_set_id.add(record[0]);
					}
					 if (pstmt_proc_code != null)pstmt_proc_code.close();//15950
					 if (resultset_proc_code != null)resultset_proc_code.close();//15950
					proc_term_set_code.add((String)lineRecord.get("term_set_id"));
					if(!((String)lineRecord.get("term_set_id")).equals(""))
					{
						if(!(proc_term_set_id.contains((String)lineRecord.get("term_set_id"))))
						{
							if(!(((String)lineRecord.get("proc_link_applicable")).equals("")) && !(((String)lineRecord.get("proc_link_applicable")).equals("X")))
							{
								 
								pstmt_procdelete.setString(1 ,order_id);
								pstmt_procdelete.executeUpdate();
								pstmt_proclink_delete.setString(1 ,order_id);
								pstmt_proclink_delete.executeUpdate();
								//int result = pstmt_procdelete.executeUpdate();
								//pstmt_procdelete.setString(1 ,order_type_code);
								//pstmt_procdelete.setString(2 ,order_id);
								//pstmt_procdelete.setString(3 ,report_srl_no);
								//pstmt_procdelete.setString(4 ,(String)lineRecord.get("line_srl_num"));
								//pstmt_procdelete.setString(5 ,(String)lineRecord.get("srl_num"));
							//	pstmt_procdelete.addBatch();
							}
						}
					}
					else
					{
						if(!proc_scheme_code.equals(""))
						{
							StringTokenizer stoken=new StringTokenizer(proc_scheme_code,"*");
							pstdelete= connection.prepareStatement("delete from pr_encounter_procedure where ORDER_ID=? and PROC_CODE=?");
							while(stoken.hasMoreTokens())
							{
								temp_scheme =stoken.nextToken();
								StringTokenizer stoken1=new StringTokenizer(temp_scheme,"~");
								String line_sr_token = stoken1.nextToken();
								int line_srl= 0;
								double line_sr =Double.parseDouble(line_sr_token);
								line_srl = (int)line_sr;
								String srl_num_token = stoken1.nextToken();
								String proc_code_scheme_token = stoken1.nextToken();
								System.out.println("srl_num_token--->"+srl_num_token+"<--proc_code_scheme_token--->"+proc_code_scheme_token);//Checkstyle
							    String proc_code_resulted_token2 = stoken1.nextToken();
								 proc_code_resulted_token1.add(proc_code_resulted_token2);
							}
						}
						for (int j=0;j<proc_term_set_id.size();j++)
			            {
							
							if(proc_code_resulted_token1.size()==0)
							 {
                                pstmt_procdelete.setString(1 ,order_id);
								pstmt_procdelete.executeUpdate();
								pstmt_proclink_delete.setString(1 ,order_id);
								pstmt_proclink_delete.executeUpdate();
							 }
							else if(!(proc_code_resulted_token1.contains(proc_term_set_id.get(j))))
							  {
					            pstmt_procdelete.setString(1 ,order_id);
								pstmt_procdelete.executeUpdate();
								pstdelete.setString(1,order_id);
								pstdelete.setString(2,(String)proc_term_set_id.get(j));
								pstdelete.executeUpdate();
							  }
						}
							  closeStatement(pstdelete);	
					}
				 }
                 
				// update_detail = pstmt_procdelete.executeBatch();
				closeStatement( pstmt_procdelete);
				 
				
				//String  proc_code_scheme="";	
				//String  proc_code_resulted="";	
				pstmt8.setString(1, order_id);
				pstmt8.setString(2, report_srl_no);
				
				billResultSet = pstmt8.executeQuery();
				if (billResultSet.next()) 
				{
					p_bill_yn	= billResultSet.getString("bill_yn");
				}
				if (pstmt8 != null)pstmt8.close();//15950
				closeResultSet(billResultSet);	
				for (int i=0;i<sizeDetail;i++)
				{
					lineRecord = (HashMap)lineRecords.get(i);
					if(!(proc_term_set_id.contains((String)lineRecord.get("term_set_id"))))
					
					{
						if(((String)lineRecord.get("proc_link_applicable")).equals("C") || ((String)lineRecord.get("proc_link_applicable")).equals("P"))
						{
							//IN029323 Starts
							 if("XT".equals(patient_class) && "".equals(encounter_id))
							 {
								 proc_encounter_id="0";
							 }
							 else
							 {
								 proc_encounter_id=encounter_id;
							 }
							//IN029323 Ends	
							 pstmt_proclink.setString(1 ,order_type_code);
							 pstmt_proclink.setString(2 ,order_id);
							 pstmt_proclink.setString(3 ,report_srl_no);
							 pstmt_proclink.setString(4 ,(String)lineRecord.get("line_srl_num"));
							 pstmt_proclink.setString(5 ,(String)lineRecord.get("srl_num"));
							 if(((String)lineRecord.get("proc_link_applicable")).equals("C"))
							{
								pstmt_proclink.setString(6 ,(String)lineRecord.get("order_catalog_code"));//proc_code_scheme
								pstmt_proclink.setString(7 ,"1");//proc_code_resulted
							 }
							 else if(((String)lineRecord.get("proc_link_applicable")).equals("P"))
							{
								//pstmt_proclink.setString(6 ,(String)lineRecord.get("msr_id"));//proc_code_scheme				
								pstmt_proclink.setString(6 ,(String)lineRecord.get("term_set_id"));//proc_code_scheme
								pstmt_proclink.setString(7 ,(String)lineRecord.get("term_code"));//proc_code_resulted
							}
							 //pstmt_proclink.setString(7 ,"1");
							 pstmt_proclink.setString(8 ,login_by_id);
							 pstmt_proclink.setString(9 ,login_at_ws_no);
							 pstmt_proclink.setString(10 ,login_facility_id);
							 pstmt_proclink.setString(11 ,login_by_id);
							 pstmt_proclink.setString(12 ,login_at_ws_no);
							 pstmt_proclink.setString(13 ,login_facility_id);
							 pstmt_proclink.executeUpdate();
							 //int insert_proclink=pstmt_proclink.executeUpdate();
							 //pstmt_proclink.addBatch();
							 pstmt_proclink_insert_srl_no.setString(1, login_facility_id);
							 //pstmt_proclink_insert_srl_no.setString(2, encounter_id);//IN029323
							 pstmt_proclink_insert_srl_no.setString(2, proc_encounter_id);//IN029323
							 resultSet_srl_no = pstmt_proclink_insert_srl_no.executeQuery();
							 resultSet_srl_no.next();
							 srl_no=resultSet_srl_no.getInt(1);
							 closeResultSet(resultSet_srl_no);
							 pstmt_proclink_insert.setString(1 , login_facility_id);
							 //pstmt_proclink_insert.setString(2 , encounter_id);//IN029323
							 pstmt_proclink_insert.setString(2 , proc_encounter_id);//IN029323
							 pstmt_proclink_insert.setInt(3 , srl_no);
							 pstmt_proclink_insert.setString(4 , hdr_practitioner_id);
							 pstmt_proclink_insert.setString(5 , patient_id);
							 if(((String)lineRecord.get("proc_link_applicable")).equals("C"))
							{
								pstmt_proclink_insert.setString(6 ,"1");//proc_code_resulted
								pstmt_proclink_insert.setString(7 ,(String)lineRecord.get("order_catalog_code"));//proc_code_scheme
							}
							else if(((String)lineRecord.get("proc_link_applicable")).equals("P"))
							{
								pstmt_proclink_insert.setString(6 ,(String)lineRecord.get("term_code"));//proc_code_resulted
								pstmt_proclink_insert.setString(7 ,(String)lineRecord.get("term_set_id"));//proc_code_scheme
							}
							 //pstmt_proclink.setString(7 ,"1");
							 pstmt_proclink_insert.setString(8 , patient_class);
							 pstmt_proclink_insert.setString(9 , order_id);
							 pstmt_proclink_insert.setString(10 , (String)lineRecord.get("line_srl_num"));
							 pstmt_proclink_insert.setString(11 , "O");
							 pstmt_proclink_insert.setString(12 , order_id.substring(0,2));
							 pstmt_proclink_insert.setString(13 , "OR");
							 pstmt_proclink_insert.setString(14 , (String)lineRecord.get("line_srl_num")+"#"+order_id);
							 pstmt_proclink_insert.setString(15 , "N");
							 pstmt_proclink_insert.setString(16 ,login_by_id);
							 pstmt_proclink_insert.setString(17 ,login_at_ws_no);
							 pstmt_proclink_insert.setString(18 ,login_facility_id);
							 pstmt_proclink_insert.setString(19 ,login_by_id);
							 pstmt_proclink_insert.setString(20 ,login_at_ws_no);
							 pstmt_proclink_insert.setString(21 ,login_facility_id);
							 if(((String)lineRecord.get("proc_link_applicable")).equals("P"))
							{
								pstmt_proclink_insert.setString(22 , getTermDesc(pstmt_proc_desc,(String)lineRecord.get("term_set_id"),(String)lineRecord.get("term_code")));
							}
							else
							{
								pstmt_proclink_insert.setString(22 , "");
							}
							pstmt_proclink_insert.executeUpdate();
						}

					}
					//closeStatement( pstmt_proclink);
				}
				
				if(!proc_scheme_code.equals(""))
				{
					//IN029323 Starts
					 if("XT".equals(patient_class) && "".equals(encounter_id))
					 {
						 proc_encounter_id="0";
					 }
					 else
					 {
						 proc_encounter_id=encounter_id;
					 }
					//IN029323 Ends	
					StringTokenizer stoken=new StringTokenizer(proc_scheme_code,"*");
					while(stoken.hasMoreTokens())
					{
						temp_scheme =stoken.nextToken();
						StringTokenizer stoken1=new StringTokenizer(temp_scheme,"~");
						String line_sr_token = stoken1.nextToken();
						int line_srl= 0;
						double line_sr =Double.parseDouble(line_sr_token);
						line_srl = (int)line_sr;
						String srl_num_token = stoken1.nextToken();
						String proc_code_scheme_token = stoken1.nextToken();
						String proc_code_resulted_token = stoken1.nextToken();
						//proc_code_scheme = stoken1.nextToken();
                       if(!(proc_term_set_id.contains(proc_code_resulted_token)))
					   {
						//proc_code_resulted = stoken1.nextToken();
						pstmt_proclink.setString(1 ,order_type_code);
						pstmt_proclink.setString(2 ,order_id);
						pstmt_proclink.setString(3 ,report_srl_no);
						pstmt_proclink.setInt(4 ,line_srl);//line_srl_num
						pstmt_proclink.setString(5 ,srl_num_token);//srl_num
						pstmt_proclink.setString(6 ,proc_code_scheme_token);//proc_code_scheme
						pstmt_proclink.setString(7 ,proc_code_resulted_token);//proc_code_resulted
						pstmt_proclink.setString(8 ,login_by_id);
						pstmt_proclink.setString(9 ,login_at_ws_no);
						pstmt_proclink.setString(10 ,login_facility_id);
						pstmt_proclink.setString(11 ,login_by_id);
						pstmt_proclink.setString(12 ,login_at_ws_no);
						pstmt_proclink.setString(13 ,login_facility_id);
						pstmt_proclink.executeUpdate();
						//int insert_proclink=pstmt_proclink.executeUpdate();
						pstmt_proclink_insert_srl_no.setString(1, login_facility_id);
						//pstmt_proclink_insert_srl_no.setString(2, encounter_id);//IN029323
						pstmt_proclink_insert_srl_no.setString(2, proc_encounter_id);//IN029323
						resultSet_srl_no = pstmt_proclink_insert_srl_no.executeQuery();
					    resultSet_srl_no.next();
						srl_no=resultSet_srl_no.getInt(1);
						closeResultSet(resultSet_srl_no);
						pstmt_proclink_insert.setString(1 , login_facility_id);
						//pstmt_proclink_insert.setString(2 , encounter_id);//IN029323
						pstmt_proclink_insert.setString(2 , proc_encounter_id);//IN029323
						pstmt_proclink_insert.setInt(3 , srl_no);
						pstmt_proclink_insert.setString(4 , hdr_practitioner_id);
						pstmt_proclink_insert.setString(5 , patient_id);
						pstmt_proclink_insert.setString(6 , proc_code_resulted_token);//proc_code_resulted
						pstmt_proclink_insert.setString(7 , proc_code_scheme_token);//proc_code_scheme						 
						pstmt_proclink_insert.setString(8 , patient_class);
						pstmt_proclink_insert.setString(9 , order_id);
						pstmt_proclink_insert.setInt(10 ,line_srl);
						pstmt_proclink_insert.setString(11 ,"O");
						pstmt_proclink_insert.setString(12 , order_id.substring(0,2));
						pstmt_proclink_insert.setString(13 , "OR");
						pstmt_proclink_insert.setString(14 , line_sr_token+"#"+order_id);
						pstmt_proclink_insert.setString(15 , "N");
						pstmt_proclink_insert.setString(16 , login_by_id);
						pstmt_proclink_insert.setString(17 , login_at_ws_no);
						pstmt_proclink_insert.setString(18 , login_facility_id);
						pstmt_proclink_insert.setString(19 , login_by_id);
						pstmt_proclink_insert.setString(20 , login_at_ws_no);
						pstmt_proclink_insert.setString(21 , login_facility_id);
						pstmt_proclink_insert.setString(22 ,  getTermDesc(pstmt_proc_desc,proc_code_scheme_token,proc_code_resulted_token));
						pstmt_proclink_insert.executeUpdate();
					}
					}
				}
				 closeStatement( pstmt_proclink);
				 traceVal.append("9");

				String rslt_type = null;
				String msg = null;
				String status = ""; String orderStatus = "";
				String p_result_status = "P";
				String abnormal_child  = null; String temp_result_status = null;
				String p_freq_code = "";
				String p_start_date_time = "";
				String order_category = "";
				//String patient_class = "";
				String v_discrete_cont_order_yn = "";
				String msr_panel_id = "";
				String common_result_type = "";
				String first_result_type = "";
				String line_result_type = null;

				int rti = 0;
				// Inserting the clob data.
				for (int i=0;i<sizeDetail;i++)
				{
					lineRecord = (HashMap)lineRecords.get(i);
					
					rslt_type = (String)lineRecord.get("rslt_type");
					msg = "";					
					accession_num = (String)lineRecord.get("accession_num")==null?"":(String)lineRecord.get("accession_num");			
					traceVal.append("#"+rslt_type);				
					if(rslt_type.equals("*"))
					{
					
						pstmt_chart_result.setString(1,order_id);
						pstmt_chart_result.setString(2,(String)lineRecord.get("line_srl_num"));
						chart_resultSet=pstmt_chart_result.executeQuery();
						while(chart_resultSet.next())
						{
							 charting_result = chart_resultSet.getString("chart_result");
						}
						closeResultSet(chart_resultSet);
						msg = insertResultDataClob(pstmt_clob,charting_result,order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
					}
					else if(rslt_type.equalsIgnoreCase("F")|| rslt_type.equalsIgnoreCase("Q") )
					{
						msg = insertResultDataClob(pstmt_clob, (String)lineRecord.get("result_data"), order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
						if (lineRecord.containsKey("organism_data"))
								//msg += insertOrganism(pstmt_organism, pstmt_organism_delete, (HashMap)lineRecord.get("organism_data"), order_id, report_srl_no, (String)lineRecord.get("srl_num"), (String)lineRecord.get("msr_id"), login_by_id, login_at_ws_no, login_facility_id);
								msg = msg+insertOrganism(pstmt_organism, pstmt_organism_delete, (HashMap)lineRecord.get("organism_data"), order_id, report_srl_no, (String)lineRecord.get("srl_num"), (String)lineRecord.get("msr_id"), login_by_id, login_at_ws_no, login_facility_id);
								traceVal.append(msg);
						traceVal.append("@");
					}else if(rslt_type.equalsIgnoreCase("X"))
					{
						String result_data = "";
						//6484 Start.
						//	result_data = getNoteResultDataClob(pstmt_clob1,accession_num, login_facility_id);
						//	msg = insertResultDataClob(pstmt_clob,result_data, order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));

						HashMap resultMap= new HashMap();
						String compressResultYN ="N";
						String compressResult = "";
						resultMap = getNoteResultDataClob(pstmt_clob1,accession_num, login_facility_id);
						result_data = (String)resultMap.get("resultData");
						compressResultYN =(String)resultMap.get("compressResultYN");
						compressResult = (String)resultMap.get("compressResult");
						
						msg = insertResultDataWithCompress(connection,result_data,compressResultYN,compressResult, order_type_code, order_id, report_srl_no, (String)lineRecord.get("line_srl_num"), (String)lineRecord.get("srl_num"));
						//6484 End.
						traceVal.append(msg);
						traceVal.append("====X===");
						
					}
				}
				// Inserted the clob data.

				/*rec_result_type = (String)resultRecord.get("result_type");
				if(rec_result_type==null) rec_result_type="";
				if(!rec_result_type.trim().equals(""))
					if (!rec_result_type.trim().equals("N"))
						rec_result_type = "A";

				traceVal.append((String)resultRecord.get("result_status"));
				traceVal.append((String)resultRecord.get("order_status"));
				traceVal.append(rec_result_type);
				traceVal.append(","+(String)resultRecord.get("auth_reqd_yn_db")+",");
				traceVal.append((String)resultRecord.get("auth_reqd_yn"));


				orderStatus = (String)resultRecord.get("order_status");
				//ResultSet rs ;
				pstmt_status.clearParameters();
				
				pstmt_status.setString(1,(String)resultRecord.get("result_status"));
				pstmt_status.setString(2,(String)resultRecord.get("order_status"));
				pstmt_status.setString(3,rec_result_type);
				pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
				pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
				rs = pstmt_status.executeQuery();
				if(rs!=null && rs.next())
					status = (String)rs.getString("or_status");
				
				closeResultSet( rs ) ;
				traceVal.append("-10-'"+status+"'");
			
				pstmt_final_order_status.setString(1,order_id);				
				rs= pstmt_final_order_status.executeQuery();
				if(rs!=null && rs.next())
					final_status=(String)rs.getString("ORDER_STATUS_CODE");
				closeResultSet( rs ) ;

				 pstmt_order.setString(1, final_status);	
				 if(orderStatus.equalsIgnoreCase("C"))
					pstmt_order.setString(2, final_status);
				 else pstmt_order.setString(2, "");	
				
				 pstmt_order.setString( 3, login_by_id ) ;
				 pstmt_order.setString( 4, login_at_ws_no ) ;
				 pstmt_order.setString( 5, login_facility_id ) ;;
				 pstmt_order.setString( 6, order_id);
				 update_order = pstmt_order.executeUpdate();
				 traceVal.append("11");*/

				// Handling the frequency explosion concept, for or_order. -- Start.
				if(!child_order_index.trim().equals(""))
				{
					traceVal.append(" **FE--");
					traceVal.append(" childIndex = "+child_order_index);

					pstmt_parent.clearParameters();
					pstmt_parent.setString(1,order_id);
					rs1 = pstmt_parent.executeQuery();
					if(rs1!=null && rs1.next())
						parent_order_id = (String)rs1.getString("parent_order_id");
					closeResultSet( rs1 ) ;
					traceVal.append(" POrderId = "+parent_order_id);
				
					if(parent_order_id != null && !parent_order_id.trim().equals(""))
					{
						traceVal.append(" Parent Found ");
						p_result_status = "P";
						abnormal_child  = null;
						if(child_order_index.trim().equals("L"))
						{
							p_result_status = (String)resultRecord.get("result_status");
							pstmt_abn_child_chk.setString(1, parent_order_id);
							rs5 = pstmt_abn_child_chk.executeQuery();
							if(rs5!=null && rs5.next())
							{
								traceVal.append("checking abn child");
								abnormal_child = (String)rs5.getString("abnormal_child");
								if(abnormal_child != null && abnormal_child.trim().equalsIgnoreCase("X"))
									any_abnormal_child = true;
							}
							closeResultSet( rs5 ) ;
						}
						pstmt_status.clearParameters();
						
						pstmt_status.setString(1,p_result_status);
						pstmt_status.setString(2,"C");
						if(any_abnormal_child)
							pstmt_status.setString(3,"A");
						else
							pstmt_status.setString(3,rec_result_type);
						pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
						pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
						pstmt_status.setString(6,(String)resultRecord.get("result_modify_yn"));
						rs = pstmt_status.executeQuery();
						status = "";
						if(rs!=null && rs.next())
							status = (String)rs.getString("or_status");
						 closeResultSet( rs ) ;
						traceVal.append(p_result_status+"C"+rec_result_type);
						traceVal.append((String)resultRecord.get("auth_reqd_yn_db"));
						traceVal.append((String)resultRecord.get("auth_reqd_yn"));

						 pstmt_order.setString(1, status);
						 pstmt_order.setString(2, status);
						 pstmt_order.setString(3, login_by_id ) ;
						 pstmt_order.setString(4, login_at_ws_no ) ;
						 pstmt_order.setString(5, login_facility_id ) ;
						 pstmt_order.setString(6, parent_order_id);
						 pstmt_order.executeUpdate();
						 //update_p_order = pstmt_order.executeUpdate();

						 // Exploding frequency immediately after the last child.
						temp_result_status = (String)resultRecord.get("result_status");
						
						traceVal.append("#"+temp_result_status+"#");
						if(child_order_index.trim().equals("F") && temp_result_status.trim().equals("3"))
						{
							traceVal.append("Exploding Frequency");

							pstmt_parent1.setString(1,parent_order_id);
							rs2 = pstmt_parent1.executeQuery();
							if(rs2!=null && rs2.next())
							{
								p_freq_code = (String)rs2.getString("p_freq_code");
								p_start_date_time = (String)rs2.getString("p_start_date_time");
								order_category = (String)rs2.getString("order_category");
								patient_class = (String)rs2.getString("patient_class");
								v_discrete_cont_order_yn = (String)rs2.getString("v_discrete_cont_order_yn");
							}
							traceVal.append("-"+p_freq_code+"-"+p_start_date_time+"-"+order_category+"-"+patient_class+"-"+v_discrete_cont_order_yn+"-");
							

							pstmt_freq_expl.setString(1,parent_order_id);			//P_ORDER_ID
							pstmt_freq_expl.setString(2,p_freq_code);				//P_FREQ_CODE
							pstmt_freq_expl.setString(3,p_start_date_time);			//P_START_DATE_TIME
							pstmt_freq_expl.setString(4,order_category);			//P_ORDER_CATEGORY
							pstmt_freq_expl.setString(5,patient_class);				//P_PATIENT_CLASS
							pstmt_freq_expl.setString(6,v_discrete_cont_order_yn);//V_DISCRETE_CONT_ORDER_YN
							pstmt_freq_expl.setString(7,login_at_ws_no);  //[IN041340]
							boolean explosion = pstmt_freq_expl.execute();
							traceVal.append("Frequency Explosion="+explosion);
						}
						 // Exploding frequency immediately after the last child.
					}
					traceVal.append("--FE** ");
				}
				// Handling the frequency explosion concept, for or_order. -- End.

				msr_panel_id = "";
				common_result_type = "";
				first_result_type = "";
				line_result_type = null;

				rti = 0;
				for (int i=0;i<sizeDetail;i++)
				{
					traceVal.append("12a");
					lineRecord = (HashMap)lineRecords.get(i);

					line_result_type = (String)lineRecord.get("result_type");
					traceVal.append("^"+line_result_type+"^");
					if(line_result_type==null) line_result_type="";
					if(!line_result_type.trim().equals(""))
						if (!line_result_type.trim().equals("N"))
						{
							line_result_type = "A";
							common_result_type = "A";
							//traceVal.append("$");
						}
					//traceVal.append("!^"+line_result_type+"^"+common_result_type+"!");

					if(!msr_panel_id.equalsIgnoreCase((String)lineRecord.get("msr_panel_id")))
					{
						msr_panel_id = (String)lineRecord.get("msr_panel_id");
						first_result_type = line_result_type;
						rti = 1;
					}
					else
					{
						if(rti==1)	common_result_type = first_result_type;
						rti++;
						if(common_result_type.equals("A"))	line_result_type = "A";
						else if(common_result_type.equals("N"))	line_result_type = "N";
						common_result_type = line_result_type;
						//traceVal.append("~"+common_result_type+"~"+msr_panel_id+"~");
					}
					//traceVal.append("!!^"+line_result_type+"^"+common_result_type+"!!");

					traceVal.append((String)lineRecord.get("result_status"));
					traceVal.append((String)resultRecord.get("order_status"));
					traceVal.append("'"+line_result_type+"'");
					traceVal.append((String)lineRecord.get("auth_reqd_yn_db"));
					traceVal.append((String)lineRecord.get("auth_reqd_yn"));

					status = "";
					orderStatus = (String)resultRecord.get("order_status");
					pstmt_status.clearParameters();
					
					pstmt_status.setString(1,(String)lineRecord.get("result_status"));
					pstmt_status.setString(2,(String)resultRecord.get("order_status"));
					pstmt_status.setString(3,line_result_type);
					pstmt_status.setString(4,(String)lineRecord.get("auth_reqd_yn_db"));
					pstmt_status.setString(5,(((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("N"))?"N":((String)lineRecord.get("auth_reqd_yn")));
					pstmt_status.setString(6,(String)resultRecord.get("result_modify_yn"));
					rs = pstmt_status.executeQuery();
					if(rs!=null && rs.next())
						status = (String)rs.getString("or_status");
					closeResultSet( rs ) ;
						
					pstmt_line.setString(1, status);
					if(orderStatus.equalsIgnoreCase("C"))
						pstmt_line.setString(2, status);
					else	pstmt_line.setString(2, "");

					 pstmt_line.setString(3, login_by_id);
					 pstmt_line.setString(4, login_at_ws_no);
					 pstmt_line.setString(5, login_facility_id);
					 pstmt_line.setString(6, order_id);
					 pstmt_line.setString(7, (String)lineRecord.get("line_srl_num"));
					
					 pstmt_line.addBatch();
				traceVal.append("'"+status+"'-12b");

				// For Billing Related
				//if (!requestFrom.trim().equalsIgnoreCase("RA")) {
					
				try{
				traceVal.append("Order Status Result"+orderStatus);

	traceVal.append("Order Status Result _ type"+(String)lineRecord.get("result_type"));
	traceVal.append("Order Status result_status"+(String)lineRecord.get("result_status"));
	traceVal.append("patient_id Ins"+patient_id);

					if(((String)lineRecord.get("result_status")).equalsIgnoreCase("3"))
					{
						if ((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("Y") && ((String)lineRecord.get("auth_reqd_yn")).equalsIgnoreCase("Y")) || ((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("N")) && (!requestFrom.trim().equalsIgnoreCase("RA")))) 
						{   
							// && ((String)lineRecord.get("auth_reqd_yn")).equalsIgnoreCase("N")
						if(!old_srl_no.equals((String)lineRecord.get("line_srl_num")))
						{
							//cstmt = connection.prepareCall("{ "+SQL_OR_RESULT_ENTRY_BL_RESULT_CATALOG+" }");
							cstmt_bl_result.setString(1,  patient_id);
							cstmt_bl_result.setString(2,  encounter_id);
							cstmt_bl_result.setString(3,  patient_class);
							//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&order_set_status_type_code.equalsIgnoreCase("85"))
							if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
							{
								cstmt_bl_result.setString(4,order_set_id);
								cstmt_bl_result.setString(5,"1");
							}
							else
							{
								cstmt_bl_result.setString(4,  order_id);
								cstmt_bl_result.setString(5,  (String)lineRecord.get("line_srl_num"));
							}
							cstmt_bl_result.setString(6, login_by_id);
							cstmt_bl_result.setString(7, login_at_ws_no);
							cstmt_bl_result.registerOutParameter( 8,  Types.VARCHAR ) ;
							cstmt_bl_result.registerOutParameter( 9,  Types.VARCHAR ) ;
							cstmt_bl_result.execute();
							bill_yn	 		= cstmt_bl_result.getString(8);
							if(bill_yn!=null && bill_yn.equals("Y"))
							err_bill_yn			= "Y";
							err_message 	= cstmt_bl_result.getString(9);
							if(err_message!=null && ! err_message.equals(""))
							{
								update_line		= 0;
								messages		= new StringBuffer();
								messages.append(err_message);
							}
							old_srl_no = (String)lineRecord.get("line_srl_num");
							}
						}
					}
				}catch(Exception ex)
				{
					update_line		= 0;
					ex.printStackTrace();
					traceVal.append("Exception Billing");
				}
				//}//End if !(ReportAuthorization)


					// Handling the frequency explosion concept, for or_order. -- Start.
					if(!child_order_index.trim().equals(""))
					{
						traceVal.append(" **FE--");
	/*					traceVal.append(" childIndex = "+child_order_index);
						ResultSet rs1 ;
						pstmt_parent.clearParameters();
						pstmt_parent.setString(1,order_id);
						rs1 = pstmt_parent.executeQuery();
						if(rs1!=null && rs1.next())
							parent_order_id = (String)rs1.getString("parent_order_id");
						traceVal.append(" POrderId = "+parent_order_id);
	*/
						if(parent_order_id != null && !parent_order_id.trim().equals(""))
						{
							traceVal.append(" Parent Found ");
							p_result_status = "P";
							if(child_order_index.trim().equals("L"))
								p_result_status = (String)resultRecord.get("result_status");
							pstmt_status.clearParameters();
							
							pstmt_status.setString(1,p_result_status);
							pstmt_status.setString(2,"C");
							if(any_abnormal_child)
								pstmt_status.setString(3,"A");
							else
								pstmt_status.setString(3,line_result_type);
							pstmt_status.setString(4,(String)lineRecord.get("auth_reqd_yn_db"));
							pstmt_status.setString(5,(((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("N"))?"N":((String)lineRecord.get("auth_reqd_yn")));
							pstmt_status.setString(6,(String)resultRecord.get("result_modify_yn"));
							rs = pstmt_status.executeQuery();
							status = "";
							if(rs!=null && rs.next())
								status = (String)rs.getString("or_status");
							closeResultSet( rs ) ;
							
							traceVal.append(p_result_status+"C"+line_result_type);
							traceVal.append((String)lineRecord.get("auth_reqd_yn_db"));
							traceVal.append((String)lineRecord.get("auth_reqd_yn"));

							pstmt_parent_line.setString(1, status);
							pstmt_parent_line.setString(2, status);
							pstmt_parent_line.setString(3, login_by_id);
							pstmt_parent_line.setString(4, login_at_ws_no);
							pstmt_parent_line.setString(5, login_facility_id);
							pstmt_parent_line.setString(6, parent_order_id);
							pstmt_parent_line.setString(7, (String)lineRecord.get("line_srl_num"));
							
							//pstmt_parent_line.addBatch();
							pstmt_parent_line.executeUpdate();
						}
						traceVal.append("--FE** ");
					}
					// Handling the frequency explosion concept, for or_order. -- End.
				}
					update_l_status = pstmt_line.executeBatch();
				 traceVal.append("13");

				 if((update_l_status.length > 0)){ //check updation in SYN
					 update_l_st = true;
				 }else if((update_l_status.length == (-3))){
					 update_l_st = false;
				 }

				// IN MODIFY OR_ORDER UPDATION
				rec_result_type = (String)resultRecord.get("result_type");
				if(rec_result_type==null) rec_result_type="";
				if(!rec_result_type.trim().equals(""))
					if (!rec_result_type.trim().equals("N"))
						rec_result_type = "A";

				traceVal.append((String)resultRecord.get("result_status"));
				traceVal.append((String)resultRecord.get("order_status"));
				traceVal.append(rec_result_type);
				traceVal.append(","+(String)resultRecord.get("auth_reqd_yn_db")+",");
				traceVal.append((String)resultRecord.get("auth_reqd_yn"));


				orderStatus = (String)resultRecord.get("order_status");
				//ResultSet rs ;
				pstmt_status.clearParameters();
				
				pstmt_status.setString(1,(String)resultRecord.get("result_status"));
				pstmt_status.setString(2,(String)resultRecord.get("order_status"));
				pstmt_status.setString(3,rec_result_type);
				pstmt_status.setString(4,(String)resultRecord.get("auth_reqd_yn_db"));
				pstmt_status.setString(5,(String)resultRecord.get("auth_reqd_yn"));
				pstmt_status.setString(6,(String)resultRecord.get("result_modify_yn"));
				rs = pstmt_status.executeQuery();
				if(rs!=null && rs.next())
					status = (String)rs.getString("or_status");
				
				closeResultSet( rs ) ;
				traceVal.append("-10-'"+status+"'");
				
				pstmt_final_order_status.setString(1,order_id);				
				rs= pstmt_final_order_status.executeQuery();
				if(rs!=null && rs.next())
					final_status=(String)rs.getString("ORDER_STATUS_CODE");
				closeResultSet( rs ) ;

				pstmt_order.setString(1, final_status);	
				 if(orderStatus.equalsIgnoreCase("C"))
					pstmt_order.setString(2, final_status);
				 else pstmt_order.setString(2, "");	
				
				 pstmt_order.setString( 3, login_by_id ) ;
				 pstmt_order.setString( 4, login_at_ws_no ) ;
				 pstmt_order.setString( 5, login_facility_id ) ;;
				 pstmt_order.setString( 6, order_id);
				 update_order = pstmt_order.executeUpdate();
				 traceVal.append("11");

			// Billing Consolidated Procedure
				//if (!requestFrom.trim().equalsIgnoreCase("RA")) {
				if (update_header > 0 && update_dl && update_order > 0 && update_l_st && update_line > 0 ){
					if(err_bill_yn.equals("Y"))
					{
						//cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE+" }");
						//cstmt.setString(1,  login_facility_id); //Commentted -[IN032859]
						cstmt.setString(1,  l_facility_id);//--[IN032859]
						cstmt.setString(2,  patient_id);
						if( patient_class!=null && (patient_class.equals("IP") || patient_class.equals("EA")) )
							cstmt.setString(3, "I");
						else if( patient_class!=null && (patient_class.equals("DC") ))
							cstmt.setString(3, "D");
						else if( patient_class!=null && (patient_class.equals("EM") ))
							cstmt.setString(3, "E");
						else if( patient_class!=null && (patient_class.equals("OP") ))
							cstmt.setString(3, "O");
						else		// XT
							cstmt.setString(3, "R");			// EPISODE_TYPE
 						cstmt.setString(4,  episode_id);		// EPISODE_ID
						cstmt.setString(5,  episode_visit_num); // VISIT_NUM
						//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&order_set_status_type_code.equalsIgnoreCase("85"))
						if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
						{
							cstmt.setString(6,  order_set_id); 			// ORDER_ID
						}
						else
						{
							cstmt.setString(6,  order_id); 			// ORDER_ID
						}
						cstmt.setString(7,  "OR");
						cstmt.setString(8,  null);
						cstmt.setString(9,  login_by_id);
						cstmt.setString(10, login_at_ws_no);
						cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
						cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
						cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
						cstmt.execute();
						err_code 	= cstmt.getString(11);  // ERR_CODE
						message_id 	= cstmt.getString(12);  // SYS_MESSAGE_ID
						err_message			= cstmt.getString(13);  // ERROR_TEXT
						if(err_code!=null && !err_code.equals("") && !err_code.equals("10") && err_message!=null && !err_message.equals(""))
						{
							update_line		= 0;			// Come out
							messages		= new StringBuffer();
							messages.append( err_message ) ;
						} else if(message_id!=null && !message_id.equals("") )  //Query from the sm_message and display the message
						{
							update_line		= 0;				// Come out
							messages		= new StringBuffer();

							// Query from the database for the message id and display the Message
							mess			= getMMessage(pstmt_message, message_id);
							messages.append(mess);
						}
					} //err
		  		}

		  	// For Billing Module
			try{
				if (update_header > 0 && update_dl && update_order > 0 && update_l_st && update_line > 0 ){
					if(err_bill_yn.equals("Y"))
					{
						old_srl_no = "";

					    for (int i=0;i<sizeDetail;i++)
	   					{
							lineRecord = (HashMap)lineRecords.get(i);
							if(((String)lineRecord.get("result_status")).equalsIgnoreCase("3") && update_line > 0)
							{
								if ((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("Y") && ((String)lineRecord.get("auth_reqd_yn")).equalsIgnoreCase("Y")) || ((((String)lineRecord.get("auth_reqd_yn_db")).equalsIgnoreCase("N")) && (!requestFrom.trim().equalsIgnoreCase("RA")))) 
								{    
									// && ((String)lineRecord.get("auth_reqd_yn")).equalsIgnoreCase("N")
			  						if(!old_srl_no.equals((String)lineRecord.get("line_srl_num")))
			  						{
			  							//cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED+" }");
										//cstmt_bl_ext_service.setString(1,  login_facility_id); //Commentted - [IN032859]
										cstmt_bl_ext_service.setString(1,  l_facility_id);//--[IN032859]
										cstmt_bl_ext_service.setString(2,  "OR");
										//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&order_set_status_type_code.equalsIgnoreCase("85"))
										if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
										{
											cstmt_bl_ext_service.setString(3,  order_set_id);
											cstmt_bl_ext_service.setString(4,  "1");
										}
										else
										{
											cstmt_bl_ext_service.setString(3,  order_id);
											cstmt_bl_ext_service.setString(4,  (String)lineRecord.get("line_srl_num"));
										}
										cstmt_bl_ext_service.registerOutParameter( 5,  Types.VARCHAR ) ;
										cstmt_bl_ext_service.registerOutParameter( 6,  Types.VARCHAR ) ;
										cstmt_bl_ext_service.registerOutParameter( 7,  Types.VARCHAR ) ;
										cstmt_bl_ext_service.registerOutParameter( 8,  Types.VARCHAR ) ;

										cstmt_bl_ext_service.execute();

										charged_yn  		= cstmt_bl_ext_service.getString(5);
										err_code  			= cstmt_bl_ext_service.getString(6);
										message_id 			= cstmt_bl_ext_service.getString(7);
										err_message 		= cstmt_bl_ext_service.getString(8);

										if(err_message!=null && ! err_message.equals(""))
										{
											update_line		= 0;
											messages		= new StringBuffer();
											messages.append(err_message);
			   							}
										else
										{
			   							/*if(message_id!=null && !message_id.equals("") )  //Query from the sm_message and display the message
										{
											update_line		= 0;				// Come out
											messages		= new StringBuffer();
											// Query from the database for the message id and display the Message
											mess			= getMMessage(pstmt_message, message_id);
											messages.append(mess);
											if(!mess.equals(""))
											{*/
											if(!(order_id.substring(0,2).equals("OH")))
											{
											//cstmt_bl_ext_chrg_stage = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE+" }");
												if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
												{
													pstmt_set_status.setString(1,order_set_id);
													resultset_status = pstmt_set_status.executeQuery();
													while(resultset_status.next())
													{
														order_set_status_type = resultset_status.getString("order_status_type");
													}
													//closeStatement(pstmt_set_status);
													if (pstmt_set_status != null)pstmt_set_status.close();//15950
													closeResultSet(resultset_status);		
												}
															
												if(order_set_status_type==null) order_set_status_type="0";
												orderstatustype = Integer.parseInt(order_set_status_type);
												if(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((orderstatustype>57)))||((order_set_bill_yn.equalsIgnoreCase("N"))&&(p_bill_yn.equalsIgnoreCase("Y"))))
												{
													cstmt_bl_ext_chrg_stage.clearParameters();
													//cstmt_bl_ext_chrg_stage.setString(1,  login_facility_id);//Commented -[IN032859]
													cstmt_bl_ext_chrg_stage.setString(1,  l_facility_id);//--[IN032859]
												//cstmt_bl_ext_chrg_stage.setString(2,  "OR");
												//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type_code.equalsIgnoreCase("85")))
												//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
													if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((orderstatustype>57)))					
													{
														cstmt_bl_ext_chrg_stage.setString(2,order_set_id);
														cstmt_bl_ext_chrg_stage.setString(3,"1");
													}
													else
													{
														cstmt_bl_ext_chrg_stage.setString(2,  order_id);
														cstmt_bl_ext_chrg_stage.setString(3,  (String)lineRecord.get("line_srl_num"));
													}
													cstmt_bl_ext_chrg_stage.setString(4,  "RST");
													//cstmt_bl_ext_chrg_stage.setString(6,  (String)lineRecord.get("order_catalog_code"));
													cstmt_bl_ext_chrg_stage.setString(5,  login_by_id);
													cstmt_bl_ext_chrg_stage.setString(6, login_at_ws_no);
																 
													cstmt_bl_ext_chrg_stage.registerOutParameter( 7,  Types.VARCHAR ) ;
													cstmt_bl_ext_chrg_stage.registerOutParameter( 8,  Types.VARCHAR ) ;
													cstmt_bl_ext_chrg_stage.setString( 9,  "OR" ) ;//IN071959
					
													cstmt_bl_ext_chrg_stage.execute();
													message_id 			= cstmt_bl_ext_chrg_stage.getString(7);
													err_message 		= cstmt_bl_ext_chrg_stage.getString(8);
													if(err_message!=null && ! err_message.equals(""))
													{
														update_line		= 0;
														messages		= new StringBuffer();
														messages.append(err_message);
													}
													else if(message_id!=null && !message_id.equals("") )  //Query from the sm_message and display the message
													{
														update_line		= 0;				// Come out
														messages		= new StringBuffer();
														// Query from the database for the message id and display the Message
														mess			= getMMessage(pstmt_message, message_id);
														messages.append(mess);
													}
												}
											}
										}

										if(update_line >0 && charged_yn!=null && charged_yn.equals("Y"))  //only if it is'Y' other wise it will be 'N' already
										{
											pstmt_bill_update.setString(1, charged_yn);
			  								pstmt_bill_update.setString(2, login_by_id);
			 								pstmt_bill_update.setString(3, login_at_ws_no);
			 								pstmt_bill_update.setString(4, login_facility_id);
											//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type_code.equalsIgnoreCase("85")))
											if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
											{
												pstmt_bill_update.setString(5, order_set_id);
			  									pstmt_bill_update.setString(6, "1");
											}
											else
											{
												pstmt_bill_update.setString(5, order_id);
			  									pstmt_bill_update.setString(6, (String)lineRecord.get("line_srl_num"));
											}
											update_line = pstmt_bill_update.executeUpdate();

										}
										old_srl_no = (String)lineRecord.get("line_srl_num");
	   	 	  						}
	    	  					}
	       					}
	     				}
						
	    			}
					for (int i=0;i<sizeDetail;i++)
					{
						lineRecord = (HashMap)lineRecords.get(i);
						String result_type= (String)lineRecord.get("rslt_type");
						String order_line=(String)lineRecord.get("line_srl_num");
						if(result_type.equals("*"))
						{
							cstmt_freq_auto_close.setString(1,order_id);
							cstmt_freq_auto_close.setString(2,order_line);
							cstmt_freq_auto_close.registerOutParameter( 3,  Types.VARCHAR ) ;
							cstmt_freq_auto_close.execute();
							p_error_msg  		= cstmt_freq_auto_close.getString(3);
						}
					}
	   			 }
	  		   }catch(Exception e)
	  		   {
					update_line		= 0;
					e.printStackTrace();
					traceVal.append("Exception Billing Last");
	  		   }



				//}//End If requestFrom != (RA)

				traceVal.append("#"+update_header+","+update_dl+","+update_order+","+update_l_st+",");
				if (update_header > 0 && update_dl && update_order > 0 && update_l_st && update_line > 0 ){
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append("RECORD_MODIFIED") ;
				}else{
						connection.rollback();
						if(update_line!=0)
							messages.append( "Insert Failed" ) ;
						messages.append( "Update Failed" ) ;
				}

		 }catch( Exception e ){
							traceVal.append("In Exception==");
							e.printStackTrace();
							traceVal.append(e);
							traceVal.append("#"+e.getMessage());
							map.put( "traceVal", traceVal.toString() ) ;

					try {
								connection.rollback();
								closeConnection( connection,pt );
								//closeConnection(connection);
						} catch ( Exception ee ) {
								messages.append(ee.getMessage() ) ;
						}
						messages.append( e.getMessage() ) ;
						e.printStackTrace() ;
					  } finally{
							try {


								    closeResultSet( rs ) ;
									closeResultSet( rs_bl ) ;//--[IN032859]
		 	 						closeStatement( pstmt_detail ) ;
		 	 						closeStatement( pstmt_status ) ;
		 	 						closeResultSet( rs1 ) ;
		 	 						closeStatement( pstmt_order ) ;
									closeStatement( pstmt_parent_line ) ;
		 	 						closeStatement( pstmt_line ) ;
		 	 						closeStatement( pstmt_clob ) ;
		 	 						closeResultSet( rs5 ) ;
		 	 						closeResultSet( rs2 ) ;
		 	 						closeStatement( pstmt_parent ) ;
		 	 						closeStatement( pstmt_parent1 ) ;
		 	 						closeStatement( pstmt_freq_expl ) ;
		 	 						closeStatement( pstmt_abn_child_chk ) ;
		 	 						closeStatement( pstmt_bill_update ) ;
		 							closeStatement( pstmt_message ) ;
		 							closeStatement( pstmt_organism ) ;
		 							closeStatement( pstmt_organism_delete ) ;
									closeStatement( pstmt_bl ) ;//--[IN032859]
		 							closeStatement( cstmt);
		 							closeStatement( cstmt_bl_result);
									closeStatement( cstmt_bl_ext_service);
									closeStatement( cstmt_bl_ext_chrg_stage);
									closeStatement( cstmt_freq_auto_close);
									closeStatement( pstmt_final_order_status);
									closeStatement( pstmt_proclink_insert);
									closeStatement( pstmt_proclink_delete);
									closeStatement( pstmt_proclink_insert_srl_no);
									closeStatement( pstmt_chart_result);
									closeStatement( pstmt_proc_desc);
									closeStatement( pstmt_set_status ) ;  //Checkstyle
									
									closeStatement( pstmt_header);
									closeStatement( pstmt_line1);
									closeStatement( pstmt_clob1);
									



								//closeConnection(connection);
								closeConnection( connection,pt);
							} catch ( Exception fe ) {
								fe.printStackTrace() ;
							}
						}

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
				return map ;
	}//End of modify Method


	public String insertResultDataClob(PreparedStatement pstmt_clob, String result_data,
										String order_type_code, String order_id,
										String report_srl_no, String line_srl_no, String srl_no)
	{
		
			StringBuffer messages = new StringBuffer("");
			ResultSet rset_clob = null;

			try
			{
				
				messages.append("*insertClob called*");
				pstmt_clob.setString(1,order_type_code);
				pstmt_clob.setString(2,order_id);
				pstmt_clob.setString(3,report_srl_no);
				pstmt_clob.setString(4,line_srl_no);
				pstmt_clob.setString(5,srl_no);
				rset_clob=pstmt_clob.executeQuery();

				if(result_data!=null)
				{
					if(result_data.length()>0)
					{
						if(rset_clob!=null)
						{
							while(rset_clob.next())
							{
								messages.append("z");
								//CLOB clb = (CLOB) rset_clob.getClob("result_data");  //Web logic Conversion -- [IN037372].
								java.sql.Clob clb = (java.sql.Clob) rset_clob.getClob("result_data"); 
								messages.append("a");
								//BufferedWriter bw = new BufferedWriter(clb.getCharacterOutputStream());  //Web logic Conversion -- [IN037372].
								BufferedWriter bw = new BufferedWriter(clb.setCharacterStream(0));
								messages.append("b");
								bw.write(result_data,0,result_data.length());
								messages.append("c");
								bw.flush();
								messages.append("d");
								bw.close();
								messages.append("**clob**");
							}
						}
					}
				}

				closeResultSet( rset_clob ) ;
			} catch ( Exception ee ) {
				messages.append("Error "+ee.getMessage() ) ;
				ee.printStackTrace() ;
			} finally {
				try {
					closeResultSet(rset_clob);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			return messages.toString();
	}
	public HashMap getNoteResultDataClob(PreparedStatement pstmt_clob,String accession_num,
										String facility_id )
	{
			
			StringBuffer messages = new StringBuffer("");
			ResultSet rset_clob = null;
			String result_data = "";
			String compressResultYN = "N"; //6484
			String compressedResult = "";  //6484
			HashMap resultMap = new HashMap(); //6484
			try
			{
				messages.append("*retrieve clob *");
				pstmt_clob.setString(1,accession_num);
				pstmt_clob.setString(2,facility_id);
				
				rset_clob=pstmt_clob.executeQuery();
				
				while(rset_clob!=null && rset_clob.next())
				{
				
					messages.append("clod data");
					//CLOB clb = (CLOB) rset_clob.getClob("NOTE_CONTENT"); //Web logic Conversion -- [IN037372]
					java.sql.Clob clb = (java.sql.Clob) rset_clob.getClob("NOTE_CONTENT");
					messages.append("after retrieve");
					result_data = clb.getSubString(1,( (int)clb.length() ));
					//6484 Star. 
					compressResultYN = rset_clob.getString("compress_note_content_yn")==null?"N":(String)rset_clob.getString("compress_note_content_yn");
					
					java.sql.Blob note_blob =  (java.sql.Blob)rset_clob.getBlob("compress_note_content");
					if(note_blob!=null && note_blob.length()>0){
						InputStream ins1 = note_blob.getBinaryStream();
						ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
						int i;
						while((i = ins1.read()) != -1) 
							bytearrayoutputstream.write(i);
						
						byte[] compressed	=bytearrayoutputstream.toByteArray();
						if(compressed.length > 0){
							if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
								GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

								String line;
								while ((line = bufferedReader.readLine()) != null) {
									compressedResult += line;
								}
							}					
						}
					}
					//6484 End.
				
				}				
				closeResultSet( rset_clob ) ;
				resultMap.put("resultData",result_data);
				resultMap.put("compressResultYN",compressResultYN);
				resultMap.put("compressResult",compressedResult);
			} catch ( Exception ee ) {
				messages.append("Error "+ee.getMessage() ) ;
				ee.printStackTrace() ;
			} finally {
				try {
					closeResultSet(rset_clob);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			return resultMap;
	}

	public String insertOrganism(PreparedStatement pstmt_organism, PreparedStatement pstmt_organism_delete, HashMap map,
										 String order_id,
										String report_srl_no, String srl_no, String msr_id, String login_by_id, String login_at_ws_no, String login_facility_id)
	{
			StringBuffer messages = new StringBuffer("");
			//ResultSet rset_clob = null;
			try
			{

				messages.append("*deleteOrganism called*");

				//pstmt_organism_delete.setString(1,order_id);
				//pstmt_organism_delete.setString(2,report_srl_no);
				//pstmt_organism_delete.setString(3,srl_no);
				//pstmt_organism_delete.setString(4,msr_id);

				//int delete_result = pstmt_organism_delete.executeUpdate();


				int organismCount	= 0;
				if (map.containsKey("chart_no_columns") && (!((String)map.get("chart_no_columns")).equals(""))) 
				{
					organismCount = Integer.parseInt((String)map.get("chart_no_columns"));
					pstmt_organism_delete.setString(1,order_id);
					pstmt_organism_delete.setString(2,report_srl_no);
					pstmt_organism_delete.setString(3,srl_no);
					//pstmt_organism_delete.setString(4,msr_id);

					int delete_result = pstmt_organism_delete.executeUpdate();
					
					messages.append(" delete organism result : "+delete_result ) ;
					messages.append("*insertOrganism called*");
				}

				for(int i = 0; i < organismCount; i++) {
			    	if (!((map.containsKey("organism"+i)) && ((String)map.get("organism"+i)).equals(""))) {
			    		String antibiotic_length 	= (String)map.get("antibiotic_length") ;
						int anti_length				= Integer.parseInt(antibiotic_length);
						String tempOrganism		= (String)map.get("organism"+i);
						for (int j = 0; j < anti_length; j++) {
							String tempAntiBiotic 	= (String)map.get("antibiotic" + j);
							String chartFieldType	= "";
							if (map.containsKey("result_type"+j)) {
								chartFieldType		= (String)map.get("result_type"+j);
								if (chartFieldType == null) chartFieldType = "";
							}

							if (map.get(j+""+i) != null && !((String)map.get(j+""+i)).equals("")) {
								pstmt_organism.setString(1,order_id);
								pstmt_organism.setString(2,report_srl_no);
								pstmt_organism.setString(3,msr_id);
								pstmt_organism.setString(4,srl_no);
								pstmt_organism.setString(5,tempOrganism);
								pstmt_organism.setString(6,tempAntiBiotic);
								pstmt_organism.setString(7,"" + (i+1));
								pstmt_organism.setString(8,(String)map.get(j+""+i));
								pstmt_organism.setString(9, chartFieldType);
								pstmt_organism.setString(10,login_by_id);
								pstmt_organism.setString(11,login_at_ws_no);
								pstmt_organism.setString(12,login_facility_id);
								pstmt_organism.setString(13,login_by_id);
								pstmt_organism.setString(14,login_at_ws_no);
								pstmt_organism.setString(15,login_facility_id);
								//try{
								int result = pstmt_organism.executeUpdate();
								//}
								//catch(Exception ex)
							//	{
								//	ex.printStackTrace();
									
							//	}
								messages.append(" result : "+result ) ;
							}
						}
					}
				}

				
			} catch ( Exception ee ) {
				messages.append("Error "+ee.getMessage() ) ;
				ee.printStackTrace() ;
			}
			return messages.toString();
	}
	  private String getMMessage(PreparedStatement pstmt_message, String message_id) throws Exception{
 		ResultSet rset		 		= null;
		String message				= "";
		try
		{
 			pstmt_message.clearParameters();
			pstmt_message.setString(1, message_id);
			try{
			rset	= pstmt_message.executeQuery();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(rset!=null)
			{
				while(rset.next())
				{
 					message	= rset.getString(1);
					if (message == null) message = "";
				}
			}
		}catch ( Exception e ){
			message	= e.toString();
  			e.printStackTrace() ;
		} finally {
		 	closeResultSet( rset ) ;
 	  	}
		return message;
	} // End of getMessage

	private String getTermDesc(PreparedStatement pstmt_term,String termSetId,String termCode) throws Exception
	{
		//PreparedStatement   pstmt   = null; //Checkstyle
 		ResultSet rset		 		= null;
		String termDesc				= "";
		try
		{
 			pstmt_term.clearParameters();
			pstmt_term.setString(1, termCode);
			pstmt_term.setString(2, termSetId);
			try
			{
				rset	= pstmt_term.executeQuery();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(rset!=null)
			{
				while(rset.next())
				{
 					termDesc	= rset.getString("short_desc");
					if (termDesc == null) termDesc = "";
				}
			}
		}catch ( Exception e ){
			e.printStackTrace() ;
		} finally {
		 	closeResultSet( rset ) ;
		 	closeStatement(pstmt_term);//15950
 	  	}
		return termDesc;
	} // End of getTermDesc


	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap delete( HashMap tabData, HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;

		return map ;
	}
	//6484 Start.
	public String insertResultDataWithCompress(Connection con, String result_data,String compressResultYN,String compressedResult,
										String order_type_code, String order_id,
										String report_srl_no, String line_srl_no, String srl_no)
	{
		
			StringBuffer messages = new StringBuffer("");
			PreparedStatement pstmt = null;

			try
			{	
				if("Y".equals(compressResultYN)){
					String updateSql1 = "UPDATE or_result_detail SET compress_result_data_yn=?, result_data=empty_clob(), compress_result_data=?  where  order_type_code=? and order_id=? and report_srl_no=? and line_srl_no=? and srl_no=? ";
					try{
						pstmt = con.prepareStatement(updateSql1);
						
						pstmt.setString(1,"Y");
						pstmt.setBytes(2, compress(compressedResult));
						pstmt.setString(3,order_type_code);
						pstmt.setString(4,order_id);
						pstmt.setString(5,report_srl_no);
						pstmt.setString(6,line_srl_no);
						pstmt.setString(7,srl_no);
						pstmt.executeUpdate();
					}catch (Exception eeF4){				
						con.rollback();
						eeF4.printStackTrace();						
					}finally{
						if (pstmt != null)
							pstmt.close();
					}
				}else{
					String updateSql1 = "UPDATE or_result_detail SET compress_result_data_yn=?,  result_data=?, compress_result_data=null  where  order_type_code=? and order_id=? and report_srl_no=? and line_srl_no=? and srl_no=?";
					try{
						pstmt = con.prepareStatement(updateSql1);
						Clob clobContent = stringToClob(result_data, con);					
						pstmt.setString(1,"N");
						pstmt.setClob(2, clobContent);
						pstmt.setString(3,order_type_code);
						pstmt.setString(4,order_id);
						pstmt.setString(5,report_srl_no);
						pstmt.setString(6,line_srl_no);
						pstmt.setString(7,srl_no);
						pstmt.executeUpdate();
					}catch (Exception eeF4){				
						con.rollback();
						eeF4.printStackTrace();						
					}finally{
						if (pstmt != null)
							pstmt.close();
					}
				}
				messages.append("*insertClob called*");
			} catch ( Exception ee ) {
				messages.append("Error "+ee.getMessage() ) ;
				ee.printStackTrace() ;
			} finally {
				try {
					if (pstmt != null) pstmt.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			return messages.toString();
	}
	
	
	public  byte[] compress(final String str) throws IOException {
		if ((str == null) || (str.length() == 0)) {
			return null;
		}
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes("UTF-8"));
		gzip.close();
		return obj.toByteArray();
	}
	public CLOB stringToClob(String stringData, Connection dbConn) 
	{
		CLOB clob = null;
		try 
		{
			clob = oracle.sql.CLOB.createTemporary(dbConn, false, CLOB.DURATION_SESSION);
			clob.setString(1, stringData);
		} catch (SQLException sqlException) {
			System.out.println("Exception thrown in stringtoClob function : SQL Exception : " + sqlException.getMessage());
		}
		return clob;
	}
	//6484 end.
}