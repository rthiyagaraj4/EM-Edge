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
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------
?             100            ?          	?				?				created
12/09/2012  IN31901		    NijithaS		?				?				Incident No: IN31901 - Bru-HIMS-CRF-263
25/09/2012	  IN030279		Ramesh G		?				?				Bru-HIMS-CRF-160
27/09/2012	  IN034769		DineshT			?				?				Exception handling is done in this function,Ordering and Performing facility is added to the procedure call
1/10/2012	  IN034830		DineshT			?				?				If dispatch required yes/no is selected to yes in the order format, the records are not appearing in the Manage Specimen function
08/10/2012	  IN034769		Ramesh G		?				?				ML-BRU-SCF-0371 
18/01/2013	  IN037372		Ramesh G		?				?				Oracle 11g Weblogic compilation.
31/01/2013	  IN037633		Chowminya G		?				?				Amend Orders is not working
13/04/2013	  KDAH-LIVE		DineshT			?				?				KDAH Live issue, Unbilled in the Manage Specimen function
16/04/2013	  IN038117		Karthi L		?				?				The setup parameter for manage specimen function is not cover in procedure unit				
07/05/2013    IN039775		Chowminya G		?				?				At the time of ordering lab tests of same specimen type it should be grouped in a single orderid 
25/06/2013	  IN041154		Chowminya G		?				?				Unbilled in the Manage Specimen function	
26/08/2013	  IN041340		Ramesh G		?				?				Bru-HIMS-CRF-363.1
22/10/2013    IN044477		Akbar			?				?				SKR-SCF-0864
21/12/2013	  IN045807		Chowminya		?				?				Interval Tests-Multifacility-Specimens generating wrongly	
24/12/2013	  IN045917		Ramesh G		?				?				Bru-HIMS-CRF-348.2- 45197/08
20/02/2014	  IN024984		Karthi			?				?				Conditional reordering by clinician
27/02/2014	  IN047469		Chowminya		05/03/2014	 	Ramesh				Amend Order splitting issue						
24/03/2014	  IN047605		Karthi			24/03/2014		Ramesh 		Alignment format of Duplicate Override reason text is differed					
07/05/2014	  IN048464		Karthi L		07/05/2014		Ramesh			History added for clinical comments	
13/08/2014	  IN049419		Ramesh G		?				?				An Audit Trail for Additional Information Amendment of Order	
16/09/2014	  IN051151		Nijitha S	   									Preps intruction,dept inst data not available after amending order.	
23/09/2014    IN041371		Chowminya		23/09/2014		Ramesh			When adding additional tests on the already placed tests,the new tests are not getting saved
18/02/2015	  IN053304		Ramesh G		19/02/2015		Ramesh			User wanted to place a future order for a Laboratory order but accidently forgot to change the Start Date.
27/02/2015	  IN003535		Ramesh G		27/02/2015		Akbar S			MMS-RY-SCF-0025 [IN:003535]
29/04/2015	  IN055190		Vijayakumar K	29/04/2015		Dinesh T		KDAH-SCF-0296 [IN:055190] - Wrong order category
																			is getting updated.
09/06/2017	IN063816		Vijayakumar K							GHL-CRF-0445.1 [IN:063816]	
27/06/2017  IN064614	Vijayakumar K		27/06/2017		Ramesh G		CRF-OR-GHL-CRF-0445.1/03 - Unable to place order if report server is down / having issue. [IN:064614]
15/09/2017	IN065264		Vijayakumar K	15/09/2017		Ramesh G		OR-Common-Place Order [IN:065264]
04/10/2017	IN065295		Dinesh T		04/10/2017		Ramesh G		Requirement of Dashboard function for Lab Central 																			Reception (CRR) Users to check the exact sample 																			status.
13/11/2017	IN065725		Dinesh T		13/11/2017		Ramesh G		
15/12/2017	  IN065942		Dinesh T		15/12/2017		Ramesh G		In Nuclear medicine  department we required the barcode
08/02/2018	  IN066436		Raja S			08/02/2018		Ramesh G		SS-SCF-0777
																			functionality at the time of Registration of order,required patient
																			Id,patient name,age,sex,register date and name of study.
06/07/2018	  IN067246		Raja S			06/07/2018		Ramesh G		GHL-CRF-0516																			
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
21/08/2018	  IN067484		Raja S			24/8/2018		Ramesh G		ML-BRU-SCF-1823																			
30/10/2018	  IN068068		Raja S			30/10/2018		Ramesh G		ML-MMOH-CRF-1206
14/10/2019    IN071315	    Nijitha S   	15/10/2019		Ramesh G		GHL-CRF-0607
22/10/2019	 IN071393		sivabagyam	 22/10/2019        Ramesh G       ML-MMOH-SCF-1369
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
06/07/2020	IN072654	Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
28/06/2020		IN071820		Ramesh G		28/06/2020		Ramesh G		ML-MMOH-SCF-1413	
14/08/2020	IN072627	Nijitha S	14/08/2020	Ramesh G	MMS-KH-CRF-0029.4/04
19/11/2020	8004		  	Nijitha S	        19/11/2020	    Remesh G	   ML-MMOH-CRF-1461.3
14/12/2020	10531		  	Nijitha S	        14/12/2020	    Remesh G	   ML-MMOH-SCF-1685-TF
07/01/2020	12123			Nijitha S			07/01/2020		Nijitha S	   ML-MMOH-SCF-1702-TF
12/01/2020	11766			Nijitha S			12/01/2020		Nijitha S	   ML-MMOH-SCF-1694-TF 
21/01/2021  12437			Nijitha S			21/01/2021		Nijitha S	   ML-MMOH-CRF-1596-TF-US001 
16/02/2021	11289			Nijitha S			16/02/2021		Nijitha S	   ALPHA-OR-MOHML12.X-Amend Order Set
12/03/2021	15770			Nijitha S	        12/03/2021	    Remesh G	  AMS-SCF-0780.1-TF2
27/12/2022	37051			Ramesh Goli		27/12/2022			Ramesh G 			ML-MMOH-CRF-1939.1
19/06/2023  46480       krishna pranay       19/06/2023         Ramesh Goli     COMMON-ICN-0131
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR.OROrderEntry ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import java.io.*;
import java.net.*;
import oracle.sql.*;
import eOR.OrderDrugInteractionVO;//IN071260
import eOR.OrderEntryBean;//11766
import eOR.OrderEntryQueryBean;//11766
import eOR.Common.* ;
import javax.ejb.* ;
import javax.transaction.* ;
//import oracle.jdbc.*;

import com.ehis.util.DateUtils;
/**
*
* @ejb.bean
*	name="OROrderEntry"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OROrderEntry"
*	local-jndi-name="OROrderEntry"
*	impl-class-name="eOR.OROrderEntry.OROrderEntryManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOR.OROrderEntry.OROrderEntryLocal"
*	remote-class="eOR.OROrderEntry.OROrderEntryRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.OROrderEntry.OROrderEntryLocalHome"
*	remote-class="eOR.OROrderEntry.OROrderEntryHome"
*	generate= "local,remote"
*
*
*/

public class OROrderEntryManager extends OrEJBSessionAdapter 
{
	//SessionContext context ;

	Connection connection 			= null ;	// Global declaration

	Hashtable print_specimen_values = null ;  // For On Line Printing(In insertLaboratory Method,specimen,Lab not installed and specimen is G)
	Hashtable external_order_stlmt_bill_data = null ;  // For External Orders Billing Settlement Details  Added by Uma 3/20/2009
	int specimen_count				= 0;
	int appt_reqd_count				= 0;
	Hashtable oa_bookappt_values	= null; // For OA Booking Appointment

	StringBuffer error_messages 	= new StringBuffer() ;
	Hashtable print_report_values 	= new Hashtable();
	Hashtable print_barcode_values 	= null;//IN064614
	int print_report_count = 0;

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap insert( HashMap tabData, HashMap sqlMap ) 
	{
		HashMap map 							= new HashMap() ;
		//Hashtable print_values					= new Hashtable(); // For On Line Printing
		appt_reqd_count							= 0;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", new Boolean( false ) ) ;
		map.put("report_exec_ind","PC");	//[IN032796]
		map.put("specimen_no","");		//[IN032796]
		int count_records =0;			//[IN032796]
		int barcode_count_records =0;	//[IN064614]
		int prn_reg_lab_cnt = 0;//IN065942
		StringBuffer messages 					= new StringBuffer() ;
		Hashtable prn_reg_lab_values 	= new Hashtable();//IN065942

		/*****  Global Variables instantiate it again **/ /** Because insert method is the method will be called all the times **/
		oa_bookappt_values						= new Hashtable(); // For OA Booking Appointment
		print_specimen_values 					= new Hashtable(); //Global  // For On Line Printing(In insertLaboratory Method,specimen,Lab not installed and specimen is G)
		external_order_stlmt_bill_data		=new Hashtable();//For External Orders Billing Settlement Details  Added by Uma 3/20/2009
 		specimen_count							= 0; // Global
		appt_reqd_count							= 0;
  	    error_messages							= new StringBuffer() ;  // Global
  	    print_barcode_values 					= new Hashtable(); //Global  // For On Line Printing(for barcode printing) //IN064614
		/**  Global Variables Till Here **/
		final String SQL_ORDER_ENTRY_OR_ORDER_INSERT 				= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_INSERT");
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_INSERT 			= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_INSERT");
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT 		= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT");
		final String SQL_ORDER_ENTRY_ORDER_COMMENT_INSERT 			= (String) sqlMap.get("SQL_ORDER_ENTRY_ORDER_COMMENT_INSERT");
		final String SQL_ORDER_ENTRY_ORDER_COMMENT_CLOB_SELECT 		= (String) sqlMap.get("SQL_ORDER_ENTRY_ORDER_COMMENT_CLOB_SELECT");
		final String SQL_ORDER_ENTRY_ORDER_FIELD_INSERT 			= (String) sqlMap.get("SQL_ORDER_ENTRY_ORDER_FIELD_INSERT");
		final String SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT 		= (String) sqlMap.get("SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT");
        final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_HDR_UPDATE 		= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_HDR_UPDATE");
        final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_UPDATE 	= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_UPDATE");
		final String SQL_ORDER_ENTRY_AMEND_COMMENTS_SEQ_NUM			= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_COMMENTS_SEQ_NUM");
		//final String SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_UPDATE		= (String) sqlMap.get("SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_UPDATE");
		//final String SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_UPDATE		= (String) sqlMap.get("SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_UPDATE");
		final String SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_DELETE		= (String) sqlMap.get("SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_DELETE");
		final String SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_DELETE		= (String) sqlMap.get("SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_DELETE");
		final String SQL_OR_ORDER_ENTRY_FREQ_EXPLOSION				= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FREQ_EXPLOSION");
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_LB_INSERT		= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_LB_INSERT");
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_MO_INSERT		= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_MO_INSERT"); //IN030279
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_INSERT		= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_INSERT");
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_INSERT		= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_INSERT");
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_UPDATE		= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_UPDATE");
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_UPDATE		= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_UPDATE");
		final String SQL_OR_ORDER_ENTRY_SPECIMEN_GEN				= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_SPECIMEN_GEN");
		final String SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT			= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT");
		final String SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO			= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO");
		final String SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO");
		final String SQL_OR_ORDER_ENTRY_BILLING_LINE_NUM_QUERY		= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILLING_LINE_NUM_QUERY");
		final String SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION		= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION");
		final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_DELETION	= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_DELETION");
		final String SQL_OR_BL_WITHOUT_ORDER_CATALOG	= (String) sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG");
		final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_DELETION		= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_DELETION");
		final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_COUNT_SELECT	= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_COUNT_SELECT");
		final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_DELETION	= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_DELETION");
		final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_DELETION	= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_DELETION");
		final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT	= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT");
		final String SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_INSERT= (String) sqlMap.get("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_INSERT");
		final String SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE		= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE");
		final String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE");
		final String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED	 = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED");
		final String SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE");
 		final String SQL_OR_ORDER_ENTRY_BILL_MESSAGE				= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
		final String SQL_OR_ORDER_ENTRY_PRIOR_ORDERS				= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_PRIOR_ORDERS");
		final String SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID          = (String) sqlMap.get("SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID");
		final String SQL_ORDER_ENTRY_OR_INSERT_ORDER_OTH_MODULE     = (String) sqlMap.get("SQL_ORDER_ENTRY_OR_INSERT_ORDER_OTH_MODULE");
		//final String SQL_OR_ORDER_ENTRY_PH_EQVL						= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_PH_EQVL");
		final String SQL_OR_ORDER_ENTRY_PH_INSERT_DTLS				= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_PH_INSERT_DTLS");
		final String SQL_OR_ORDER_ENTRY_CP_UPDATE					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_CP_UPDATE");
		final String SQL_OR_ORDER_ENTRY_MO_UPDATE					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_MO_UPDATE");
		final String SQL_OR_ORDER_ENTRY_PATIENT_MO_CATALOG_SELECT	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_PATIENT_MO_CATALOG_SELECT");
		final String SQL_OR_ORDER_ENTRY_PATIENT_MO_ORDER_FOR_POSTMORTERM_COUNT	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_PATIENT_MO_ORDER_FOR_POSTMORTERM_COUNT");
		final String SQL_OR_ORDER_ENTRY_MO_ORDER_FOR_POSTMORTERM_INSERT			= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_MO_ORDER_FOR_POSTMORTERM_INSERT");
		final String SQL_OR_ORDER_ENTRY_OR_AUTOREPORT_COMPLETION	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_OR_AUTOREPORT_COMPLETION");
		final String SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_APPL_SELECT	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_APPL_SELECT");
		final String SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_GENERATION		= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_GENERATION");
		final String SQL_OR_ORDER_ENTRY_RL_NEONATES					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_RL_NEONATES");
		final String SQL_OR_ORDER_ENTRY_FORMAT_HDR_CHK					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_FORMAT_HDR_CHK");
		//added on 08/05/07
//		final String SQL_OR_ORDER_GET_STATUS_CODE	= (String) sqlMap.get("SQL_OR_ORDER_GET_STATUS_CODE");
		final String SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT		= (String) sqlMap.get("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT");
		final String SQL_OR_ORDER_ENTRY_CANCEL_LINE2			= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE2");
		final String SQL_OR_ASSOCIATE_CONSENT					= (String) sqlMap.get("SQL_OR_ASSOCIATE_CONSENT");
		final String SQL_OR_CONSENT_DRAFT_AMEND_DELETE			= (String) sqlMap.get("SQL_OR_CONSENT_DRAFT_AMEND_DELETE");
		//upto here
		final String SQL_OR_ORDER_ENTRY_EMAIL			= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_EMAIL");
		final String SQL_OR_ORDER_ENTRY_EMAIL_PWD			= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_EMAIL_PWD");
		final String SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE");
		final String SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE");
		final String SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS");
		final String SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS");
		final String SQL_OR_ORDER_ENTRY_EMAIL_DISPLAY_BODY_DATA_DETAILS					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_EMAIL_DISPLAY_BODY_DATA_DETAILS");
		final String SQL_OR_ORDER_ENTRY_EXTERNAL_ORDER_OR_GET_BILL_DOC_TYPE					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_EXTERNAL_ORDER_OR_GET_BILL_DOC_TYPE");
		final String SQL_OR_BL_USER_CHECK_FOR_CASH_COUNTER					= (String) sqlMap.get("SQL_OR_BL_USER_CHECK_FOR_CASH_COUNTER");

		PreparedStatement pstmt 				= null ;
		PreparedStatement pstmt_detail			= null ;
		PreparedStatement pstmt_locCode			= null;  //IN045917
		//added on 08/05/07
		PreparedStatement pstmt_multi			= null ;
	//	PreparedStatement pstmt_status_code			= null ;
		PreparedStatement pstmt_order_status			= null ;        
		//ends here
		PreparedStatement pstmt_clob			= null ;
		PreparedStatement pstmt_comments		= null ;
		PreparedStatement pstmt_sy_report		= null ;
		PreparedStatement pstmt_billing_line	= null ;
		PreparedStatement pstmt_email	= null ;
		PreparedStatement pstmt7	= null ;
		PreparedStatement auditSeqPStmt = null;//Issue while running check style for IN065295
		PreparedStatement auditReasonPStmt = null;;//Issue while running check style for IN065295

		ResultSet rset_clob						= null ;
		ResultSet resultSet_email				= null ;
		ResultSet resultSet				= null ;
		ResultSet rset_locCode					= null;//IN045917
		ResultSet auditSeqRs = null;//Issue while running check style for IN065295

		CallableStatement cstmt 				= null ;
		CallableStatement cstmt_priorOrders		= null ;
		CallableStatement cstmt_frequency		= null ;
		CallableStatement cstmt_billing_ext		= null ;
		CallableStatement cstmt_billing_extl		= null ;
		CallableStatement cstmt_stlmt		= null ;
		CallableStatement cstmt_valid_user		= null ;
		CallableStatement cstmt_auditLog 				= null ;
		oracle.jdbc.OracleCallableStatement csFaxMail = null;

		boolean record_multi			= false;

		boolean result 					= true;
		boolean bill_result				= true;
		int count 						= 0,	order_line_num	= 0 ;//,   consent_count			= 0;
		int amend_total_count			= 0,	care_set_count	= 0,   clob_count				= 0;
		int amend_cnt=0;
		int total_order_cat_count		= 0;
		int multi_count					= 0;
		int grouping_seq_no				= 0; // Used for OA if appt_reqd_yn is 'Y' or chart_result_type (for treatment), then new Order
		String grouping	 				= "",	order_id		= "",  order_format_values  = "";
		String performing_facility_id	= "",	order_type		= "",  dept_loc_type		= "";
		String ord_spl_appr_reqd_yn		= "",	specimen_type 	= "",  bill_yn				= "N";
		String nurse_collect			= "N",	start_date_time	= "",  err_message			= "",splty_code="",split_auth= "";
		String frequency_val			= "", 	duration_value	= "",  specimen_no_rule		= "";
		String priority					= "", 	auth_reqd_yn	= "N", specimen_no			= "";
		String cosign_reqd_yn			= "N",	consent_reqd_yn = "N", order_category 		= "";
		String addnl_group				= "", 	order_status	= ""; //  complete_on_order_yn = "";
		String header_comments			= "", 	instrns			= "",  amend_grouping 		= "";
		String freq_nature				= "", 	cont_order_yn	= "",  coll_label_gen_rule	= "";
		String quantity					= "",	quantity_uom	= "";
		String performing_dept_loc_code = "", 	ord_billed_yn	= "N", user_id_pwd			= null;
		String order_set_id				= "",   split_grouping	= "",  locn_type			= "";
		String ext_appl_accession_num	= "",   charge_type_code="", count_consent          ="";
//		String fpp_yn 					= "", 	fpp_category	="";  //IN068314//46480
		String p_file_name="";
		String error="";
		String consent_form_id = "";//IN030298
		String consent_stage			= "";//IN037633
		String report_exec_ind= "";	//[IN032796]
		String error_code= "";		//[IN032796]
		//String temp_start_date_time		= null;
		String[] orderable_result		= new String[2];	String[] ph_calculations		= new String[2];
		String[] order_set_values		= new String[2];	String[] billing_line_result	= new String[2];
		String record[]					= null;
		String err_code 				= null,  message_id 	= null;
		String catalog_code="";
		String labchk="";
		ArrayList multi_patient			= null;
		int count_patient				= 1; // By Default one patient
		String patient_id				= "",   encounter_id	= ""  , episode_id			= "";
		String episode_visit_num		= "";
		int 	res						= 0 ,   result_dtl		= 0, order_set_line_num = 0;
		//CLOB 	clb = null; //Web logic Conversion -- [IN037372]
		java.sql.Clob 	clb = null;
		BufferedWriter 	bw				= null;String performing_pract_id = null;

		String prior_orders_err_msg     = "";
		String grp_performing_facility_id="";
		String grp_priority="";
		String grp_specimen_type="";
		String grp_nurse_collect="";
		String grp_start_date_time="";
		String grp_frequency_val="";
		String grp_duration_value="";
		String grp_performing_dept_loc_code="";
		String grp_splty_code="";
		String grp_split_auth="";
		String amend_bill_yn="N";
		String location_type="";
		String order_set_bill_yn="N";
		String amend_order_set_bill_yn="N";
		String bill_dateString="";
		String Patient_Name="";
		String Enc_pwd="";
		String Mail_Id="";
		String Mail_Subject="";
		String e_module_id="";
		String e_report_id="";
		String inv_stlmt_scr_ext_ord_yn = "";
		String inv_stlmt_scr_op_ord_yn = "";
		String inv_stlmt_scr_em_ord_yn = "";
		String settlement_scope = "";
		boolean invoke_settlement = false;
		//String amend_order_line_no="";
		//String care_set_order_category  = "";
		HashMap hashMap					= new HashMap();	// In which all the details will be there
		//HashMap mapUniqueId				= new HashMap();//IN071393	// Contains the Unique Id(Combination which has generated orderid)
		//HashMap mapOrderId 				= new HashMap();//IN071393	// Contains order_id for the combination
		LinkedHashMap mapUniqueId				= new LinkedHashMap();//IN071393	// Contains the Unique Id(Combination which has generated orderid)
		LinkedHashMap mapOrderId 				= new LinkedHashMap();//IN071393
		HashMap mapOrderStatus			= new HashMap();	// Contains the Order_status for the order_id
		HashMap mapOrderFormatHdr		= new HashMap();	// Contains the Order Format for the header, internally it will holding hashmap with the respective order_type binded to it
		HashMap mapOrderFormatDtl		= new HashMap();	// Contains the Order Format for the line level.
		ArrayList mapScheduleDtl			= new ArrayList();	// Contains the Schedule Frequency for the line level.
		HashMap orderFormatHdr			= new HashMap();	// Contains the hashmap with the values for each order type selected, in the HDR Level
		HashMap mapSpecimenNo			= new HashMap();	// After specimen no and coll_label_gen_rule is found, store it in the hashmap for the corresponding orderid
		HashMap mapcollectStage			= new HashMap();	// To store the Collection_stage orderables grouped under a single order has COLLECTION_STAGE = 'Separate',
		HashMap mapOrderSet 			= new HashMap();	// To store the Order_set_id with the patient for insertion in the line level
	    HashMap	multiConsentDtl			= null;				// Contains the Multi Consent Details for the line level.
		String email_yn="";
		String appl_user_name="";
		String displayDetail="";
		StringBuffer displayData=new StringBuffer();
		StringBuffer OrderID=new StringBuffer();
		String billing_valid_user = "";
		int trn_group_ref = 0;
		String group_ref_trn = "";
		StringTokenizer stGroup			= null;
		String orig_order_id  = "";
		String amend_rep_group_ref  = "";
		String amend_trn_group_ref  = "";
		String l_catalog_format_id = "";//IN066436
		String l_spec_err_msg = "";//IN066436
		//IN034769,starts
		String l_failure_msg = "";
		String l_language_id = "";
		Properties l_props;
		//IN034769
		//String l_dupe_reason = ""; // IN024984 //Checkstyle
		String barcode_reqd_yn = "N";//IN063816
		String prn_regd_ord = "";//IN065942
		HashMap dupeReasonHashMap = new HashMap(); // IN024984
		//11766 Starts
		ArrayList drugDtls = null;
		String[] records1				= null;
		String[] deptLocation				= null;
		String form_code = "",route_code ="";
		ArrayList depLocDtls = null;
		String drug_class ="";
		//11766 Ends
		try
		{
			/** Get the connection **/
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			//IN034769,starts
			l_props = (Properties)tabData.get( "properties" );
			l_language_id = (String)(l_props.getProperty("LOCALE"));
			//IN034769,ends
			connection.setAutoCommit( false ) ;

			/** Get the Prepared Statements, Callable Statements, Statements, etc, **/
 			cstmt						= connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_SPECIMEN_GEN+" }");  //Generation of the Specimen
			cstmt_priorOrders			= connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_PRIOR_ORDERS+" }");  //Prior Orders
			cstmt_frequency				= connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_FREQ_EXPLOSION+" }");
			cstmt_billing_ext			= connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE+" }");
			cstmt_billing_extl			= connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE+" }");

			pstmt_sy_report				= connection.prepareStatement(SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT);
			pstmt_billing_line			= connection.prepareStatement(SQL_OR_ORDER_ENTRY_BILLING_LINE_NUM_QUERY);
			/** Till here for the prepared Statements, callable statements, statements etc */

			error_messages.setLength(0);
			hashMap 					= ((HashMap)tabData.get("hashValues"));
			//mapUniqueId					= ((HashMap)tabData.get("mapUniqueId")) ;//IN071393
			//mapOrderId					= ((HashMap)tabData.get("mapOrderId")) ;//IN071393
			mapUniqueId					= ((LinkedHashMap)tabData.get("mapUniqueId")) ;//IN071393
			mapOrderId					= ((LinkedHashMap)tabData.get("mapOrderId")) ;//IN071393
			mapOrderStatus  			= ((HashMap)tabData.get("mapOrderStatus")) ;
			mapOrderFormatHdr 			= ((HashMap)hashMap.get("header_format_values")) ; // For Other Orders
			order_set_bill_yn  			=  checkForNull(((String)hashMap.get("order_set_bill_yn")),"N");
			amend_order_set_bill_yn  	=  checkForNull(((String)hashMap.get("amend_order_set_bill_yn")),"N");
			bill_dateString  			=  checkForNull(((String)hashMap.get("bill_dateString")),"");

			count						=  Integer.parseInt(((String)hashMap.get("total_count")));	 // Total count
			//count=2;			
			//amend_total_count=0;
			amend_total_count			=  Integer.parseInt(((String)hashMap.get("amend_total_count"))); // Total Amend Count	
			amend_cnt					= Integer.parseInt(checkForNull((String)hashMap.get("amend_cnt"),"1"));
			if(amend_cnt==0)
			amend_total_count=0;
			care_set_count				=  Integer.parseInt(((String)hashMap.get("care_set_count"))); 	//Total care set count
		
			total_order_cat_count		=  Integer.parseInt(checkForNull((String)hashMap.get("total_order_cat_count"),"0"));	//total_order_cat_count
 
			java.util.Set setValues 	= mapUniqueId.keySet();
			java.util.Iterator iterator = null;
			header_comments 			= ((String)hashMap.get("header_comments"));
			amend_grouping  			= checkForNull(((String)hashMap.get("amend_grouping")),"");

			patient_id					= checkForNull((String)hashMap.get("patient_id"),"");
			encounter_id				= checkForNull((String)hashMap.get("encounter_id"),"");
			episode_id					= checkForNull((String)hashMap.get("episode_id"),"");
			episode_visit_num			= checkForNull((String)hashMap.get("episode_visit_num"),"");
			email_yn					= checkForNull((String)hashMap.get("email_yn"),"");
			appl_user_name				= checkForNull((String)hashMap.get("appl_user_name"),"");
			displayDetail				= checkForNull((String)hashMap.get("displayDetail"),"");
			//  added for IN024984 - Start
			dupeReasonHashMap =(HashMap)hashMap.get("dup_override_reason");
			
			// IN024984 - End
			/*Added by Uma on 12/22/2009 for IN15411 CRF 560*/
			if(amend_rep_group_ref.equals(""))
				trn_group_ref				= getTrnGroupRef();
			/*Ends Here*/
			

 			//care_set_order_category  = checkForNull(((String)hashMap.get("order_category")),"CS");
			// multi_patient_details, is from the MultiPatient Orders (only for Multipatients)
			// this will contain, patient_id, encounter_id, episode_id, episode_visit_num
			// In places where episode_id and episode_visit_num is required, they would have taken from the array list, otherwise they would not have been used,
 			multi_patient				= ((ArrayList)hashMap.get("multi_patient_details")) ;
 			if(multi_patient!=null && multi_patient.size() > 0)  // For Multi Patient Orders
				count_patient			= multi_patient.size();
			//error_messages.append("amend_total_count"+amend_total_count+"count"+count);

 			// IN049419 Start.			
			if(hashMap.get("amend_order_id")!=null && "Y".equals((String)hashMap.get("amend_auditTrailYN"))){
				//PreparedStatement auditSeqPStmt = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 FROM OR_ORDER_AMEND_REASON WHERE ORDER_ID = ?");//Issue while running check style for IN065295
				auditSeqPStmt = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 FROM OR_ORDER_AMEND_REASON WHERE ORDER_ID = ?");//Issue while running check style for IN065295
				auditSeqPStmt.setString(1,(String)hashMap.get("amend_order_id"));				
				//auditSeqRs auditSeqRs = auditSeqPStmt.executeQuery();//Issue while running check style for IN065295
				auditSeqRs = auditSeqPStmt.executeQuery();//Issue while running check style for IN065295
				String amend_reason_seq ="";
				if (auditSeqRs.next()){
					amend_reason_seq	= ChkDef.defaultString(auditSeqRs.getString(1));
				}
				//PreparedStatement	auditReasonPStmt = connection.prepareStatement("INSERT INTO OR_ORDER_AMEND_REASON ( ORDER_ID,ACTION_SEQ_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_AMEND_REASON) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");//Issue while running check style for IN065295
				auditReasonPStmt = connection.prepareStatement("INSERT INTO OR_ORDER_AMEND_REASON ( ORDER_ID,ACTION_SEQ_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_AMEND_REASON) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");//Issue while running check style for IN065295
				auditReasonPStmt.setString(1,((String)hashMap.get("amend_order_id")).trim());
				auditReasonPStmt.setString(2, amend_reason_seq);
				auditReasonPStmt.setString(3,  (String)tabData.get("login_by_id"));		
				auditReasonPStmt.setString(4,  (String)tabData.get("login_at_ws_no"));				
				auditReasonPStmt.setString(5,  (String)tabData.get("login_facility_id"));	
				auditReasonPStmt.setString(6,  (String)tabData.get("login_by_id"));					
				auditReasonPStmt.setString(7,  (String)tabData.get("login_at_ws_no"));
				auditReasonPStmt.setString(8, (String)tabData.get("login_facility_id"));
				auditReasonPStmt.setString(9, (String)hashMap.get("amend_reason"));
				auditReasonPStmt.execute();
			}
			//IN049419 End.
			// For Amend Order, if it is there Updatation
			if(amend_total_count > 0 && result)
			{
				
				 // Updation/Insertion for the Format Fields in the Header
				/*if(mapOrderFormatHdr!=null && mapOrderFormatHdr.size() > 0 && result)	// For All Orders, except Care Sets
				{
					if(mapUniqueId.size() > 0) // because for only amend it will be 0,if some additional item, then the size will increase
					{
						iterator			= setValues.iterator();
						grouping 			= ((String)iterator.next());	// Get the grouping combination done
					}
					if(!amend_grouping.equals(""))
						amend_grouping 		= amend_grouping.substring(28,amend_grouping.length());
					else
						amend_grouping 		= "";
					// If there is no new record, only amend, then only enter here otherwise, will insert when inserting a new record.
					if(!amend_grouping.equals("") && !grouping.equals("") && amend_grouping.equalsIgnoreCase(grouping))
 					{
						order_id 			= ((String)mapOrderId.get(grouping+patient_id+encounter_id));
						order_type 			= getOrderType(grouping); // Get the Order_type_code from the respective grouping
						// As of now updation in or_order for ORDER_FIELDS_DISPLAY_TEXT
						orderFormatHdr 		= ((HashMap)mapOrderFormatHdr.get("header_format_values"+order_type));
						//order_format_values	= "";
                   		//if(orderFormatHdr!=null && orderFormatHdr.size() >1)
						//{
						//	order_format_values = ((String)orderFormatHdr.get("order_format_values"));
						//}
						//if(order_format_values!=null && order_format_values.length() > 500) order_format_values = order_format_values.substring(0,499);
						//Update in the or_order table
						//if(order_format_values!=null && order_format_values.length() > 0)
						//	result 		= updateAmendHeader(tabData, order_id, order_type, order_format_values, "");
						
						// updateFormatFields Method called here to update the order_formats in the Header (For Amend Order)
						//if(result)
						//	result 		= updateFormatFields(mapOrderFormatHdr, hashMap,  tabData, order_id, order_type, SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_DELETE, SQL_ORDER_ENTRY_ORDER_FIELD_INSERT, SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID, SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT);
 					}	 // End of amend_grouping
				} // End of if mapOrderFormatHdr
				*/

				// Only for Amend, and no new order
			if(mapOrderFormatHdr!=null && mapOrderFormatHdr.size() > 0 && result)	// For All Orders, except Care Sets
			{
				
				// Delete it blindly and then insert, //Just delete them if it is an new order, no need to check whether deleted or not
				deleteAmendFormatFields( ((String)hashMap.get("amend_order_id")) , SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_DELETE);
				if(!amend_grouping.equals("") && grouping.equals(""))
				{	// If already records are there, then delete and insert//Just delete them if it is an new order, no need to check whether deleted or not
 					result 				= insertFormatFields(mapOrderFormatHdr, hashMap,  tabData, ((String)hashMap.get("amend_order_id")), ((String)hashMap.get("amend_order_type0")) ,0, SQL_ORDER_ENTRY_ORDER_FIELD_INSERT, SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID, SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT, SQL_OR_ORDER_ENTRY_FORMAT_HDR_CHK);
					// For Updation of order format header
					orderFormatHdr 		= ((HashMap)mapOrderFormatHdr.get("header_format_values"+((String)hashMap.get("amend_order_type0"))));
  					if(orderFormatHdr==null || orderFormatHdr.size() <= 1) // For Pharmacy or from Preview
						orderFormatHdr				= ((HashMap)mapOrderFormatHdr.get("header_format_values"+""));
 					if(orderFormatHdr!=null && orderFormatHdr.size() >1)
					{
						order_format_values = ((String)orderFormatHdr.get("order_format_values"));
					}
					if(order_format_values!=null && order_format_values.length() > 500) order_format_values = order_format_values.substring(0,499);
 					if(order_format_values!=null && order_format_values.length() > 0)
						result 			= updateAmendHeader(tabData, ((String)hashMap.get("amend_order_id")), ((String)hashMap.get("amend_order_type0")), order_format_values, SQL_ORDER_ENTRY_AMEND_OR_ORDER_HDR_UPDATE);
 				} //End of amend_grouping
			} // End of  mapOrderFormatHdr

			if(!amend_grouping.equals("") && grouping.equals("")&& result)
			{
				result 				= updateAmendOrderHeader(tabData,((String)hashMap.get("amend_order_id")),((String)hashMap.get("ordering_practitioner_id")));
			}

			// For Line Updation, Call a method updateAmendLine to update the values (Amend Order)
			
			if(result)
			   result = updateAmendLine(hashMap,tabData, amend_total_count, ((String)hashMap.get("amend_order_id")) , SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_UPDATE, SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT, SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_DELETE);
 			// Amend Individual Tables Updation For Radiology and Radiology Dept
			// Applicable Only for RD AND RX
			
			if(result)
				result = updateRadiology(tabData,hashMap,amend_total_count,SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_UPDATE, SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_UPDATE);
 			// If the Format Fields for the line levels are there, (deletion already done) insert the values
			//IN072654 Starts
			if(result){
				
				for(int i=0;i<amend_total_count;i++)
				{
					//result = insertDrugInteractionLB(tabData, hashMap,((String)hashMap.get("amend_order_id")), Integer.valueOf((String)hashMap.get("amend_order_line_num"+i)), i,checkForNull(((String)hashMap.get("amend_catalog_code"+i)),""));
					insertDrugInteractionLB(tabData, hashMap,((String)hashMap.get("amend_order_id")), Integer.valueOf((String)hashMap.get("amend_order_line_num"+i)), i,checkForNull(((String)hashMap.get("amend_catalog_code"+i)),""));//8004
				}
			}	
			//IN072654 Ends
			if(result)
			{
				for(int i=0;i<amend_total_count;i++)
				{
					order_line_num 		= (Integer.parseInt(((String)hashMap.get("amend_order_line_num"+i))));
					order_id 			= ((String)hashMap.get("amend_order_id"));
					mapOrderFormatDtl 	= ((HashMap)hashMap.get("amend_format_line_values"+i));

					l_catalog_format_id = (String)hashMap.get("amend_format_id"+i);//IN066436
					if(l_catalog_format_id == null || "null".equals(l_catalog_format_id))//IN066436
						l_catalog_format_id = "";//INC066436
					//IN066436, starts				
					if(!"".equals(l_catalog_format_id) && mapOrderFormatDtl.size() <= 1)
					{
						result = false;
						l_spec_err_msg = "APP-OR0453 Operation failed since some of mandatory format item is going blank, please check and record again!";
					}
					//IN066436 ends
					if(mapOrderFormatDtl.size() > 1)
					{
						if(result)
						{	// updateFormatLineFields Method called to update the order_formats in the line level (For Amend Order)
							// Already it has been deleted, not u have to insert the record
							result		= insertFormatLineFields(mapOrderFormatDtl, tabData, order_id, order_line_num,	SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT);
 							//result 	= updateFormatLineFields(mapOrderFormatDtl,tabData,order_id,order_line_num,	SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT, SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_DELETE);
							//IN066436 starts
							if(!result)
							{
								l_spec_err_msg = "APP-OR0453 Operation failed since some of mandatory format item is going blank, please check and record again!";
							}
							//IN066436 ends
						} // End of if result
					}	 // End of if mapOrderFormatDtl
				} // End of for
			} // End of if result
			// Amend call the Billing Procedure...
			for(int i = 0;i<amend_total_count;i++)
  			{
				if(checkForNull((String)hashMap.get("amend_billing_call_yn"+i),"N").equals("Y") && ((!checkForNull((String)hashMap.get("amend_old_quantity"+i),"").equals(checkForNull((String)hashMap.get("amend_quantity"+i),"")) ) || (!checkForNull((String)hashMap.get("amend_actual_value"+i),"").equals(checkForNull((String)hashMap.get("amend_actual_old_value"+i),"")) ) || (!checkForNull((String)hashMap.get("amend_old_quantity"+i),"").equals(checkForNull((String)hashMap.get("amend_quantity"+i),"")) ) && (!checkForNull((String)hashMap.get("amend_actual_value"+i),"").equals(checkForNull((String)hashMap.get("amend_actual_old_value"+i),"")) ))&& result) // If billing is installed, and if for that order_catalog bill_yn is 'Y' and the cont_ord_ind is "DO" or "CO"
				//if(checkForNull((String)hashMap.get("amend_billing_call_yn"+i),"N").equals("Y") && result) // If billing is installed, and if for that order_catalog bill_yn is 'Y' and the cont_ord_ind is "DO" or "CO"
				//if(checkForNull((String)hashMap.get("amend_billing_call_yn"+i),"N").equals("Y") && result) // If billing is installed, and if for that order_catalog bill_yn is 'Y' and the cont_ord_ind is "DO" or "CO"
				{
					order_id 			= ((String)hashMap.get("amend_order_id"));
					order_line_num 		=  Integer.parseInt(checkForNull((String)hashMap.get("amend_order_line_num"+i),"0"));
					//amend_order_line_no=checkForNull((String)hashMap.get("amend_order_line_num"+i),"0");
					if(!order_id.equals(""))
					{				//result=cancelBilling(order_id,amend_order_line_no,(String)tabData.get("login_by_id"),(String)tabData.get("login_at_ws_no"),(String)tabData.get("login_facility_id"),SQL_OR_BL_WITHOUT_ORDER_CATALOG);
					}
					if(result)
					{
						amend_bill_yn="Y";
						//Modified by Uma on 1/18/2010 for IN017420 for cont_order_yn*/
						billing_line_result = callBillingLineLevel(tabData,hashMap,"AMEND_ORDER", SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE,String.valueOf(i),order_id,patient_id, encounter_id, order_line_num,care_set_count,"","","","",cont_order_yn);
						/*Ends Here*/
						err_message			= checkForNull(billing_line_result[1],""); //error_message, no need to take the Oth parameter (charge_type_code)
						
 						if(!err_message.equals(""))
						{
							result 			= false;	 // Any Error is there Come out Immediately
							error_messages.setLength(0);
							messages.setLength(0);
 							messages.append( err_message ) ;

							error_messages.append(err_message);
						} // End of !err_message
					}

				}
			}
			if(result&&amend_bill_yn.equalsIgnoreCase("Y"))
			{
				cstmt_billing_extl.clearParameters();
				cstmt_billing_extl.setString(1,  ((String)tabData.get("login_facility_id"))); 	// FACILITY_ID
				cstmt_billing_extl.setString(2,  patient_id);			// PATIENT_ID
						//cstmt_billing_ext.setString(2,  ((String)hashMap.get("patient_id")));			// PATIENT_ID
				if( (((String)hashMap.get("patient_class")).equalsIgnoreCase("IP")) || (((String)hashMap.get("patient_class")).equalsIgnoreCase("EA")) )
				{
					cstmt_billing_extl.setString(3, "I");										// EPISODE_TYPE
				}
				else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("DC"))
				{
					cstmt_billing_extl.setString(3, "D");										// EPISODE_TYPE
				}
				else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("EM"))
				{
					cstmt_billing_extl.setString(3, "E");										// EPISODE_TYPE
				}
				else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("OP"))
				{
					cstmt_billing_extl.setString(3, "O");										// EPISODE_TYPE
				}
				else
				{
					cstmt_billing_extl.setString(3, "R");										// EPISODE_TYPE
				}
						//if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("XT"))
			
				cstmt_billing_extl.setString(4,  checkForNull(episode_id,"0"));	// EPISODE_ID
				cstmt_billing_extl.setString(5,  checkForNull(episode_visit_num,"0")); // VISIT_NUM
				cstmt_billing_extl.setString(6, checkForNull(order_id,""));
				//((String)mapOrderId.get(grouping+patient_id+encounter_id))); 	// ORDER_ID
				cstmt_billing_extl.setString(7,  "OR"); 		// SUBS_MODULE_ID
				cstmt_billing_extl.setString(8,  null); 	// SUBS_REGN_NUM
				cstmt_billing_extl.setString(9,  ((String)tabData.get("login_by_id"))); 		// USER
				cstmt_billing_extl.setString(10, ((String)tabData.get("login_at_ws_no"))); 	// WS_NO
				cstmt_billing_extl.registerOutParameter( 11,  Types.VARCHAR ) ;
				cstmt_billing_extl.registerOutParameter( 12,  Types.VARCHAR ) ;
				cstmt_billing_extl.registerOutParameter( 13,  Types.VARCHAR ) ;

				cstmt_billing_extl.execute();
				err_code 		= checkForNull(cstmt_billing_extl.getString(11),"");  // ERR_CODE
				message_id 		= checkForNull(cstmt_billing_extl.getString(12),"");  // SYS_MESSAGE_ID
				err_message		= checkForNull(cstmt_billing_extl.getString(13),"");  // ERROR_TEXT
			
				if(!err_code.equals("") && !err_code.equals("10") && !err_message.equals(""))
				{
					result 			= false;bill_result = false; 		// Any Error is there Come out Immediately
					error_messages.setLength(0);
					messages.setLength(0);
					messages.append( err_message ) ;
					error_messages.append(err_message);
				} // End of if !err_message
				else if(!message_id.equals("") )  //Query from the sm_message and display the message
				{
					result 			= false;bill_result = false;		// Any Error is there Come out Immediately
					error_messages.setLength(0);
					messages.setLength(0);
						// Query from the database for the message id and display the Message
					err_message = getErrMessage(message_id, SQL_OR_ORDER_ENTRY_BILL_MESSAGE);
					messages.append(checkForNull(err_message, "" ));
					error_messages.append(checkForNull(err_message, "" ));
				}
			}
  		}// Amend Order
		if(count > 0 && result) 	   // New Orders Insertion
		{
			try
			{
				// Insert into the Header (New Orders) or_order table
				pstmt 						= connection.prepareStatement(SQL_ORDER_ENTRY_OR_ORDER_INSERT);
				// FOR THE MULTI PATIENT
				for(int j=0;j<count_patient;j++)
				{
					iterator = setValues.iterator();
					amend_rep_group_ref			= checkForNull((String)hashMap.get("amend_rep_group_ref"+j),"");
					amend_trn_group_ref			= checkForNull((String)hashMap.get("amend_trn_group_ref"+j),"");
					// Get the patient_id , if any for Multi Patient Details
					if(multi_patient!=null && multi_patient.size() > 0 ) // Only it is for Multi Patients
					{
						record				= (String[]) multi_patient.get(j);
						patient_id			= checkForNull(record[0],"");	// patient_id
						encounter_id		= checkForNull(record[1],"");   // encounter_id
						episode_id			= checkForNull(record[2],"");	// episode_id
						episode_visit_num	= checkForNull(record[3],"");   // episode_visit_num
 					}
					// If it is an order_set_id, it should generate order_set_id and insert one record in or_order and or_order_line
					// Will get the output parameter as order_id,order_line_num and performing_facility_id
					if(count > 0  && care_set_count > 0 && result  ) // care_set_count > 0  means it is order_set
					{
						order_set_values 			= getOrderSetId(hashMap, tabData, patient_id, encounter_id, episode_id,episode_visit_num, SQL_ORDER_ENTRY_OR_INSERT_ORDER_OTH_MODULE);
						order_set_id				= checkForNull(order_set_values[0],"");
						err_message					= checkForNull(order_set_values[1],"");
							if(!err_message.equals(""))  
							{
						 	result 			= false;	 // Any Error is there Come out Immediately
							error_messages.setLength(0);
							messages.setLength(0);
 							messages.append( err_message ) ;
							error_messages.append(err_message);
						} // End of !err_message
					} // End of if count > 0 && care_set_count > 0
					// Set it in a HashMap to be later used in when inserting or_order and or_order_line
					mapOrderSet.put(patient_id, order_set_id); // Storing the order_set_id generated with the patient_id as the key, otherwise it will be ""
					if(result)
					{
						for(int i=0;i<mapUniqueId.size();i++)
						{//grouping = ((String)mapUniqueId.get("performing_facility_id"+i))+"~~"+((String)mapUniqueId.get("order_type"+i))+"~~"+((String)mapUniqueId.get("priority"+i))+"~~"+((String)mapUniqueId.get("ord_spl_appr_reqd_yn"+i))+"~~"+((String)mapUniqueId.get("specimen_type"+i))+"~~"+((String)mapUniqueId.get("nurse_collect"+i))+"~~"+((String)mapUniqueId.get("start_date_time"+i))+"~~"+((String)mapUniqueId.get("frequency_val"+i))+"~~"+((String)mapUniqueId.get("duration_value"+i))"~~"+((String)mapUniqueId.get("performing_dept_loc_code"+i))+"~~"+split_grouping;
						grouping = ((String)iterator.next());
//error_messages.append("mapOrderId hdr grouping"+grouping);
						amend_grouping  			= checkForNull(((String)hashMap.get("amend_grouping")),"");						
						if(!amend_grouping.equals(""))
							amend_grouping = amend_grouping.substring(28,amend_grouping.length());
						else
							amend_grouping = "";
					
			  			if(!(amend_grouping.equalsIgnoreCase(grouping)) && result)
						{
							stGroup = new StringTokenizer(grouping,"~~");							
							while(stGroup.hasMoreTokens())
							{
								performing_facility_id 	= stGroup.nextToken();
								if(performing_facility_id.equals("^^"))
									performing_facility_id="";
								order_type 				= stGroup.nextToken();
								if(order_type.equals("^^"))
									order_type="";
								priority 				= stGroup.nextToken();
								if(priority.equals("^^"))
									priority="";
								ord_spl_appr_reqd_yn 	= stGroup.nextToken();
								specimen_type 			= stGroup.nextToken();
								if(specimen_type.equals("^^"))
									specimen_type="";
								nurse_collect 			= stGroup.nextToken();
								if(nurse_collect.equals("^^"))
									nurse_collect="N";
								start_date_time 		= stGroup.nextToken();
								if(start_date_time.equals("^^"))
									start_date_time="";
								frequency_val 			= stGroup.nextToken();
								if(frequency_val.equals("^^"))
									frequency_val="";
								duration_value			= stGroup.nextToken();
								if(duration_value.equals("^^"))
									duration_value="";
								performing_dept_loc_code= stGroup.nextToken();
								if(performing_dept_loc_code.equals("^^"))
									performing_dept_loc_code="";
								splty_code= stGroup.nextToken();
								if(splty_code.equals("^^"))
									splty_code="";
								split_auth= stGroup.nextToken();
								if(split_auth.equals("^^"))
									split_auth="";
								if(!frequency_val.equals(""))
									stGroup.nextToken();
						
								split_grouping			= stGroup.nextToken();
								if(split_grouping.equals("^^"))
									split_grouping="";
										//IN030298 Starts
										//IN037633 - start
										consent_stage			= stGroup.nextToken(); 
										if(consent_stage.equals("^^"))
											consent_stage="";
										//IN037633 - end
										consent_form_id			= stGroup.nextToken(); 
										if(consent_form_id.equals("^^"))
											consent_form_id="";
										//IN030298 Ends
								break;//changed
						}
						stGroup	= null;
						//temp_start_date_time = "";
						order_id = ((String)mapOrderId.get(grouping+patient_id+encounter_id));	//For the combination done get the order id stored in mapOrderId hashmap
						OrderID.append(" "+order_id);
						pstmt.setString(1, order_id); // Order_id
						pstmt.setString(2, order_type);						
						addnl_group		= ((String)mapUniqueId.get(grouping));
						//Get the first one character
						auth_reqd_yn 		= addnl_group.substring(0,1);	// auth_reqd_yn
						consent_reqd_yn 	= addnl_group.substring(3,4);	// consent_reqd_yn
						//complete_on_order_yn= addnl_group.substring(6,7);	// complete_order_yn
						cosign_reqd_yn		= addnl_group.substring(9,10);	// cosign_reqd_yn
						order_category		= addnl_group.substring(12,14); // order_category
						freq_nature			= addnl_group.substring(16,17); // freq_nature
						cont_order_yn		= addnl_group.substring(19,20); // cont_order_yn
						// No need to take the auto_report_yn and appt_reqd_yn
						// No need to take the split_grouping
						//pstmt.setString(3, ((String)hashMap.get("order_category")));
						pstmt.setString(3, order_category);	// order_category
						pstmt.setString(4, "OR");
						// At present OR -- contr_sys_id
						pstmt.setString(5, patient_id);// patient_id
							//pstmt.setString(5, ((String)hashMap.get("patient_id"))); // patient_id

							//No Need of this Logic, As issue came up in LD
						/*	if(order_category.equals("OT") && !start_date_time.equals("") )
							{	// Since the pref_surg_date will be in the dd/mm/yyyy format
								stGroup = new StringTokenizer(start_date_time," ");
								if(stGroup.hasMoreTokens())   // Only 2 tokens will be available, take the first token only
								{
									temp_start_date_time 	= checkForNull(stGroup.nextToken(),""); // Take only the first token which will return u the date in the format (dd/mm/yyyy)
								}   // Do not take the Next token (which will be as hh24:mi)
							} // End of  order_category.equals("OT")
							//Sunil conformed with BC, regarding removal of this logic
							//As issue came up in LD
							if( (checkForNull((String)hashMap.get("patient_class"),"").equals("DC") || checkForNull((String)hashMap.get("patient_class"),"").equals("OP") ) && order_category.equals("OT") && (!checkForNull((String)hashMap.get("pref_surg_date"+order_type),"").equals(checkForNull(temp_start_date_time,"")) ) )
							{
								 pstmt.setString(6,  "XT"); //patient_class (If pref_surg_dat!=order_date_time && patient_class="DC" || "OP"
								 pstmt.setString(7,  ((String)tabData.get("login_facility_id")));					//ordering_facility_id
								 pstmt.setString(8,  null); // encounter_id
							  	 pstmt.setString(9,  null); // episode_id
							 	 pstmt.setString(10, null); // episode_visit_num
							}
							else
							{
							}
						*/
							pstmt.setString(6, ((String)hashMap.get("patient_class")));	//patient_class
							pstmt.setString(7, ((String)tabData.get("login_facility_id")));
							//ordering_facility_id
							//pstmt.setLong(8,  Long.parseLong((String)hashMap.get("encounter_id")));			//encounter_id
 							pstmt.setString(8,  checkForNull(encounter_id, null));
							//encounter_id(can be null or value)
							pstmt.setString(9,  checkForNull(episode_id, null));
							// episode_id
							pstmt.setString(10, checkForNull(episode_visit_num,null));
							// episode_visit_num
							location_type=(String)hashMap.get("location_type");
							//IN045917 Start.
							/*if(location_type.trim().equals("null") || "".equals(location_type.trim()))
							{
								pstmt.setString(11,"R");
							}else
							{
								pstmt.setString(11,location_type);
							}							
							// Source Type*/
							pstmt.setString(12, ((String)hashMap.get("location_code")));
							// Source Code
							if(location_type.trim().equals("null") || "".equals(location_type.trim()))
							{
								pstmt.setString(11,"R");
								String location_code_ ="";
								pstmt_locCode = connection.prepareStatement("SELECT EXT_ORDER_REFERRAL_CODE FROM OR_PARAM_BY_FACILITY WHERE OPERATING_FACILITY_ID=?");
								pstmt_locCode.setString(1,((String)tabData.get("login_facility_id")));
								rset_locCode= pstmt_locCode.executeQuery();
								if(rset_locCode!=null)
								{
									while(rset_locCode.next())
									{										 
										location_code_=rset_locCode.getString("EXT_ORDER_REFERRAL_CODE")==null?"":(String)rset_locCode.getString("EXT_ORDER_REFERRAL_CODE");
										
									}
								}
								closeStatement(pstmt_locCode);
								closeResultSet(rset_locCode);
								
								pstmt.setString(12, location_code_);
								// Source Code
							}
							else
							{
								pstmt.setString(11,location_type);
								// Source Type
								pstmt.setString(12, ((String)hashMap.get("location_code")));
								// Source Code
							}
							//IN045917 End.
							pstmt.setString(13, null);// At present discharge_ind
							pstmt.setString(14, ((String)hashMap.get("order_date_time")));
							// ord_date_time
							pstmt.setString(15, ((String)hashMap.get("ordering_practitioner_id")));
							//ord_pract_id
							// For priority, Malaysian Requirments, priority should go as per line grouping
							//pstmt.setString(16,((String)hashMap.get("priority_hdr")));			//priority
							pstmt.setString(16, priority);
							//priority
							pstmt.setString(17, auth_reqd_yn);
							// ord_auth_reqd_yn
							pstmt.setString(18, null);	// At present -- ord_auth_level
							if((((String)hashMap.get("authorized")).equalsIgnoreCase("true")) && auth_reqd_yn.equalsIgnoreCase("Y"))
							{
								pstmt.setString(19, ((String)hashMap.get("ordering_practitioner_id")));
								// ord_auth_by_pract_id
								pstmt.setString(20, ((String)hashMap.get("sys_date")));
								// ord_auth_date_time
							}
							else
							{
								pstmt.setString(19, null);			// ord_auth_by_pract_id
								pstmt.setString(20, null);			// ord_auth_date_time
							}
							pstmt.setString(21, ord_spl_appr_reqd_yn);
							// ord_appr_reqd_yn
							if((((String)hashMap.get("special_approved")).equalsIgnoreCase("true")) && ord_spl_appr_reqd_yn.equalsIgnoreCase("Y"))
							{
								pstmt.setString(22, ((String)tabData.get("login_by_id")));
								// ord_appr_by_user_id
								pstmt.setString(23, ((String)hashMap.get("sys_date")));
								// ord_appr_date_time
							}
							else
							{
								pstmt.setString(22, null); // ord_appr_by_user_id
								pstmt.setString(23, null); // ord_appr_date_time
							}
							pstmt.setString(24, cosign_reqd_yn);
							// At present ord_cosign_reqd_yn
							pstmt.setString(25, null); 			 // At present ord_cosign_level
							if((((String)hashMap.get("cosigned")).equalsIgnoreCase("true")) && cosign_reqd_yn.equalsIgnoreCase("Y"))
							{
								pstmt.setString(26, ((String)hashMap.get("ordering_practitioner_id")));
								// ord_cosign_by_pract_id
								pstmt.setString(27, ((String)hashMap.get("sys_date")));
								// ord_cosign_date_time
							}
							else
							{
								pstmt.setString(26, null);			 // ord_cosign_by_pract_id
								pstmt.setString(27, null);			 // ord_cosign_date_time
							}
							pstmt.setString(28, consent_reqd_yn);
							// ord_consent_reqd_yn
							if((((String)hashMap.get("consented")).equalsIgnoreCase("true")) && consent_reqd_yn.equalsIgnoreCase("Y"))
							{
								pstmt.setString(29, ((String)tabData.get("login_by_id")));
								//ord_consent_by_id
								pstmt.setString(30, ((String)hashMap.get("sys_date")));
								// ord_consent_by_date_time
							}
							else
							{
								pstmt.setString(29, null);			// ord_consent_by_id
								pstmt.setString(30, null);			// ord_consent_by_date_time
							}
							pstmt.setString(31, null); 			    // At present  ord_print_date_time
							pstmt.setString(32, "N"); 			    // At present	--	bill_yn
							pstmt.setString(33, null); 			    // At present -- can_reason
							// Method getContinuingOrder() called to get the continuing_order_ind
							cont_order_yn = getContinuingOrder(checkForNull(cont_order_yn,"N"),checkForNull(freq_nature,"F"),checkForNull(frequency_val,""));
							pstmt.setString(34, cont_order_yn);
							// For cont_order_ind
							pstmt.setString(35, performing_facility_id);
							// performing_facility_id
							labchk=checkForNull(getmoduleRL(catalog_code,order_category,order_type,(String)tabData.get("login_facility_id")),"");
							//if(order_category.equals("LB") && checkForNull((String)hashMap.get("lb_instal_yn"),"N").equals("Y"))//changed on 7/10/2007 for lb_instal_yn by uma
							if(order_category.equals("LB") &&(checkForNull( labchk,"").equalsIgnoreCase("IBARL")))
								pstmt.setString(36, "LB"); 		    // At present -- performing_sys_id
							else if(order_category.equals("RD") && checkForNull((String)hashMap.get("rd_install_yn"),"N").equals("Y"))
								pstmt.setString(36, "RD"); 		    // At present -- performing_sys_id
							else
								pstmt.setString(36, "OR"); 		    // At present -- performing_sys_id
							if(order_category.equals("LB")) dept_loc_type = "L";
							else if(order_category.equals("RD")) dept_loc_type = "R";
							else if(order_category.equals("RX")) dept_loc_type = "I";
							else if(order_category.equals("PC")) dept_loc_type = "P";
							else if(order_category.equals("TR")) dept_loc_type = "T";
							else if(order_category.equals("MI")) dept_loc_type = "M";
							else if(order_category.equals("OT")) dept_loc_type = "O";//IN31901
							else if(order_category.equals("PH")){//11766 Starts
								OrderEntryQueryBean entryQueryBean =  new OrderEntryQueryBean();
								OrderEntryBean bean = new OrderEntryBean();
								bean.setLanguageId(l_language_id);
								 drugDtls = entryQueryBean.getDrugDetails(l_props, (String)hashMap.get("catalog_code"+i)); 
							
		   						for(int k=0; k<drugDtls.size(); k++)  // Only one record
								{
									records1					= (String[]) drugDtls.get(k);
									drug_class					= records1[13] ;
									if(null==(String)hashMap.get("form_code"+i) || "".equals((String)hashMap.get("form_code"+i)))
									{
										form_code					= records1[2] ;
										
									}
									if(null==(String)hashMap.get("route_code"+i) || "".equals((String)hashMap.get("route_code"+i)))
									{
										
										route_code					=records1[4] ;
									}
								}
		   						depLocDtls = bean.getPerformDeptLocation1(performing_facility_id, (String)hashMap.get("catalog_code"+i), priority, order_type, drug_class);
		   						for(int p=0; p<depLocDtls.size(); p++)
								{
									deptLocation	= (String[]) depLocDtls.get(p);
									if(deptLocation[0]!=null && deptLocation[0].indexOf("|")!=-1){
										performing_dept_loc_code = deptLocation[0].substring(0,deptLocation[0].indexOf("|"));
									}
									else
										performing_dept_loc_code = deptLocation[0];
								}
								dept_loc_type = "P";
							}//11766 Ends
							else dept_loc_type	= "";

							pstmt.setString(37, dept_loc_type);
							// At present -- performing_deptloc_type
							pstmt.setString(38, performing_dept_loc_code);
							// At present -- performing_deptloc_code
							performing_pract_id			 = "";
                            if(mapOrderFormatHdr!=null && mapOrderFormatHdr.size() > 0)	// If the Order Formats are there
						    {
								orderFormatHdr 			= ((HashMap)mapOrderFormatHdr.get("header_format_values"+order_type));
								order_format_values		= "";
								if(orderFormatHdr==null || orderFormatHdr.size()<=1) // take it again for the pharmacy if there since order_type can be ""
									orderFormatHdr 		= ((HashMap)mapOrderFormatHdr.get("header_format_values"+""));

								if(orderFormatHdr!=null && orderFormatHdr.size() >1)
								{
								    int order_format_count 		= Integer.parseInt(checkForNull((String)orderFormatHdr.get("order_format_count"),"0"));
				                    for(int index=0;index<order_format_count;index++)
				                    {
												if(((String)orderFormatHdr.get("field_mnemonic"+index)).equals("PERFORM_PRACT_ID")) 
												{
				                            performing_pract_id = checkForNull((String)orderFormatHdr.get("field_values"+index),"");
                                        }
				                    }
								}
							}
							pstmt.setString(39, performing_pract_id);
							// At present -- performing_pract_id
							pstmt.setString(40, "N");
						// At present	 -- result_auth_reqd_yn
							pstmt.setString(41, "N"); 			// At present	 -- child_order_yn
							pstmt.setString(42, null); 			// At present -- parent_order_id

							if(checkForNull((String)mapOrderSet.get(patient_id),"").equals(""))
							{ // For all orders except orderset
								if(!(checkForNull((String)hashMap.get("order_set_id"),"").equals("")))
								{
									pstmt.setString(43, "Y");  			// At present -- order_set_yn
									pstmt.setString(44, checkForNull((String)hashMap.get("order_set_id"),""));
								}
								else
								{
									pstmt.setString(43, "N");  			// At present -- order_set_yn
									pstmt.setString(44, null); 			// At present-- order_set_id
								}
							}
							else
							{
								pstmt.setString(43, "Y");  			// At present -- order_set_yn
								pstmt.setString(44, checkForNull((String)mapOrderSet.get(patient_id),"") );
								// At present-- order_set_id
							}
							
							pstmt.setString(45, "");
							//Commented by Jyothi on 15/12/2009 to fix IN015497, since iv_prep_yn column needs to be updated with numeric value
							//pstmt.setString(45, "N");  			// At present -- iv_prep_yn
						if(mapOrderFormatHdr!=null && mapOrderFormatHdr.size() > 0)	// If the Order Formats are there
						{
								orderFormatHdr 			= ((HashMap)mapOrderFormatHdr.get("header_format_values"+order_type));
								order_format_values		= "";
								if(orderFormatHdr!=null && orderFormatHdr.size() >1)
								{
									order_format_values = ((String)orderFormatHdr.get("order_format_values"));
								}
								if(order_format_values!=null && order_format_values.length() > 500) order_format_values = order_format_values.substring(0,499);
							pstmt.setString(46, order_format_values);  // concatenate the Order Formats -- order_fields_display_text
						}
						else
						{
							order_format_values			= "";
							//If Care set is there and care set otherwise from the Preview
							if(care_set_count > 0 || total_order_cat_count >0)
							{
								if(care_set_count>0)
									total_order_cat_count = care_set_count;

								for(int t=0;t<total_order_cat_count;t++)
								{
									mapOrderFormatHdr 	= ((HashMap)hashMap.get("header_format_values"+t)) ;
 									if(mapOrderFormatHdr!=null && mapOrderFormatHdr.size() > 0)	// If the Order Formats are there
									{
										orderFormatHdr 		= ((HashMap)mapOrderFormatHdr.get("header_format_values"+order_type));
 										if(orderFormatHdr==null || orderFormatHdr.size()<=1) // take it again for the pharmacy or from preview if there since order_type can be ""
											orderFormatHdr 		= ((HashMap)mapOrderFormatHdr.get("header_format_values"+""));
 										if(orderFormatHdr!=null && orderFormatHdr.size() > 1)	// If the Order Formats are there
										{
											order_format_values = ((String)orderFormatHdr.get("order_format_values"));
										} // End of orderFormatHdr
										if(order_format_values!=null)
										{
											if(order_format_values.length() > 500)
												order_format_values = order_format_values.substring(0,499);
											pstmt.setString(46, order_format_values);  // concatenate the Order Formats -- order_fields_display_text
										}
										else
											pstmt.setString(46, null);	// order_fields_display_text
									 } // End of mapOrderformat
									 else
											pstmt.setString(46, null);	// order_fields_display_text
								} // End of for T
						    } // End of if 	care_set_count
						    else
								pstmt.setString(46, null);	// order_fields_display_text
						} // End of else
						//Order Status
						order_status = ((String)mapOrderStatus.get(order_id+patient_id+encounter_id)); // for the order_id get the order_status
						pstmt.setString(47, order_status);
						//order_status
						pstmt.setString(48, null);  //null -- result_status
						pstmt.setString(49, ((String)hashMap.get("order_mode")));
						//null/ order-mode
						pstmt.setString(50, ((String)hashMap.get("ref_facility_id")));
						//null(for Other Orders)/ REF_FACILITY_ID (for external orders)
						pstmt.setString(51, ((String)hashMap.get("ref_date_time")));
						//null(for Other Orders)/ REF_DATE_TIME (for external orders)
						pstmt.setString(52, ((String)hashMap.get("ref_sent_pract_id")));
						//null(for Other Orders)/ REF_SENT_PRACT_ID (for external orders)
						pstmt.setString(53, ((String)hashMap.get("ref_sent_remarks")));
						//null(for Other Orders)/ REF_SENT_REMARKS (for external orders)
									if(order_status!=null && order_status.equals("RG")) 
									{
							pstmt.setString(54, ((String)hashMap.get("ordering_practitioner_id")));
							//null for REGN_PRACT_ID other status, only for order_status = 'REGISTERED' , then ordering practitioner will go
							pstmt.setString(55, ((String)hashMap.get("sys_date")));
							//null for REGN_DATE_TIME other status, only for order_status = 'REGISTERED' , then sysdate
									}
									else 
									{
							pstmt.setString(54, null);  //null for REGN_PRACT_ID other status, only for order_status = 'REGISTERED' , then ordering practitioner will go
							pstmt.setString(55, null);  //null for REGN_DATE_TIME other status, only for order_status = 'REGISTERED' , then sysdate
						} // End of order_status

						pstmt.setString(56, ((String)hashMap.get("accession_type")));
						// accession_type
						pstmt.setString(57, ((String)hashMap.get("accession_number")));
						// accession_number
						pstmt.setString(58, ((String)tabData.get("login_by_id")));
						// added_by_id
						pstmt.setString(59, ((String)tabData.get("login_at_ws_no")));
						// added_at_ws_no
						pstmt.setString(60, ((String)tabData.get("login_facility_id")));
						// added_facility_id
						pstmt.setString(61, ((String)tabData.get("login_by_id")));
						// modified_by_id
						pstmt.setString(62, ((String)tabData.get("login_at_ws_no")));
						// modified_at_ws_no
						pstmt.setString(63, ((String)tabData.get("login_facility_id")));
						// modified_at_ws_no
						pstmt.setString(64, (checkForNull(labchk,"")));//added on 7/17/2007 for lab instal check
						pstmt.setString(65, (checkForNull(splty_code,"")));
						/*Added by Uma on 12/22/2009 for IN15411 CRF 560*/
						if(amend_rep_group_ref.equals(""))
							group_ref_trn = "OR"+String.valueOf(trn_group_ref);
						else
							group_ref_trn = amend_trn_group_ref;
						pstmt.setString(66, group_ref_trn);
						pstmt.setString(67, amend_rep_group_ref);
						/*Ends Here*/
						pstmt.addBatch(); 	// ADD it batch wise
						// Call a procedure to generate the specimen number,if it is an Lab Order
						if(result && order_category.equalsIgnoreCase("LB") )
						{
							try
							{
											String loc_type =(String)hashMap.get("location_type"); // added for IN038117
											if(loc_type.equalsIgnoreCase("E")) {
												loc_type = "C";
											}	
											//cstmt.setString(1, ((String)hashMap.get("location_type")));  // SOURCE_TYPE commented for IN038117
											cstmt.setString(1, loc_type); // added for IN038117
								cstmt.setString(2, ((String)hashMap.get("location_code")));  // SOURCE_CODE
								cstmt.setString(3, specimen_type); 							 // SPECIMEN_TYPE
								cstmt.setString(4, nurse_collect);							 // NURSE_COLLECT
								cstmt.setString(5, ((String)hashMap.get("priority_hdr")));	 // PRIORITY
								cstmt.setString(6, start_date_time);						 // START_DATE_TIME
								cstmt.setString(7, null); 									 // At present SECTION_CODE
								cstmt.setString(8, order_type); 							 // ORDER_TYPE_CODE
								cstmt.setString(9,(checkForNull(labchk,"")));									//	v_dest_appl_id
								cstmt.registerOutParameter( 10,  Types.VARCHAR ) ;			 // COLL_LABEL_GEN_RULE
								cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;			 // SPECIMEN_NO
								//cstmt.setString(11, ((String)tabData.get("login_facility_id"))); // FACILITY_ID
											//cstmt.setString(12, performing_facility_id);//IN034769
											//cstmt.setString(12, ((String)tabData.get("login_facility_id"))+"-"+performing_facility_id);//IN034769				 // FACILITY_ID - Performing facility
											cstmt.setString(12, ((String)tabData.get("login_facility_id"))+"-"+performing_facility_id+"-"+((String)tabData.get("login_facility_id")));//IN045807
//IN068068 start
								if(loc_type.equals("") && encounter_id.equals("") && nurse_collect.equals("Y"))
									cstmt.setString(13, "Y"); 									 // MODE
								else{
//IN068068 ends
									cstmt.setString(13, null);									 // MODE
								}								
											cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;				//	L_REPORT_EXEC_IND,     Bru-HIMS-CRF-144
											cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;			//	L_ERROR_CODE 			 	Bru-HIMS-CRF-144
								cstmt.setString( 16,  ((String)tabData.get("login_at_ws_no")) ) ;			//	L_LOGIN_AT_WS_NO 		IN041340	 	
								cstmt.execute();								
								// Specimen No generated and stored here
								coll_label_gen_rule 	= checkForNull(cstmt.getString(10),"X");
                        		specimen_no 		  	= checkForNull(cstmt.getString(11),"X");
											report_exec_ind = cstmt.getString(14);				//[IN032796]											
											error_code = cstmt.getString(15);					//[IN032796]
											//IN034769,starts
											if(error_code == null)
												error_code = "";
											if(!error_code.equals(""))
											{	
												l_failure_msg = getMessageFromDB(error_code,connection,l_language_id);					
												result = false;
												map.put( "result", new Boolean(false)) ;
												messages.append(l_failure_msg);
											}
											//IN034769,ends
											//map.put( "orderingFacility"+i, ((String)tabData.get("login_facility_id"))) ;  //IN034769//Commented for IN067246
								mapSpecimenNo.put(order_id, coll_label_gen_rule+"~~"+specimen_no);  // Specimen No and coll_label_gen_rule has been stored for that grouping(Order_id)
								//+mapOrderStatus
                        		// Till here
										}
										catch(Exception e)
							{
								e.printStackTrace();
								result		   = false;
								error_messages.setLength(0);
								error_messages.append("Exception hdr Specimen Procedure"+ e.toString());
							}
 							// Insert into SY_REPORT if category is "LB" and if lab is installed and coll_label_gen_rule = "G"
							//by hcr
										try
										{
							//if(result && order_category.equalsIgnoreCase("LB") && (checkForNull((String)hashMap.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && coll_label_gen_rule.equalsIgnoreCase("G"))changed on 7/10/2007 for lb_instal_yn by uma
							if(result && order_category.equalsIgnoreCase("LB") && (checkForNull( labchk,"").equalsIgnoreCase("IBARL")) && coll_label_gen_rule.equalsIgnoreCase("G"))
							{
												if ((checkForNull(((String)hashMap.get("location_type")),"!")).equalsIgnoreCase("N")) 
												{
								    locn_type = "W";
												} 
												else 
												{
								    locn_type = checkForNull(((String)hashMap.get("location_type")),"!");
								}
								user_id_pwd 	= "RLrcoLBL "+((String)tabData.get("user_id"))+"/"+((String)tabData.get("user_password"))+"@"+((String)tabData.get("database_name"))+" "+((String)hashMap.get("session_id"))+" "+((String)hashMap.get("sys_date")) + " "+ ((String)tabData.get("login_facility_id")) + " "+order_type+" "+((String)mapOrderId.get(grouping+patient_id+encounter_id))+" "+locn_type+" "+ checkForNull(((String)hashMap.get("location_code")),"!!!!");
												if("PC".equals(report_exec_ind)){
								pstmt_sy_report.setString( 1, ((String)tabData.get("login_facility_id")) ) ;
								pstmt_sy_report.setString( 2, ((String)tabData.get("login_by_id")) ) ;
								pstmt_sy_report.setString( 3, ((String)tabData.get("login_at_ws_no")) ) ;
								pstmt_sy_report.setString( 4, ((String)tabData.get("login_at_ws_no")) ) ;
								pstmt_sy_report.setString( 5, ((String)hashMap.get("session_id"))  ) ;
								pstmt_sy_report.setString( 6, ((String)hashMap.get("sys_date")) ) ;   // request_date
								pstmt_sy_report.setString( 7, user_id_pwd ) ;
								pstmt_sy_report.setString( 8, "" ) ;//IN065264
								res = pstmt_sy_report.executeUpdate();
													if(res > 0 ) 
														result = true; 
													else 
														result = false;
												}else if("RC".equals(report_exec_ind)||"RS".equals(report_exec_ind)){
													map.put("report_exec_ind"+count_records,report_exec_ind);	
													map.put("specimen_no"+count_records,specimen_no);
													map.put( "orderingFacility"+count_records, ((String)tabData.get("login_facility_id"))) ;  //IN067246 added from top to bottom
													map.put("order_id_"+count_records,order_id);
													map.put("source_type"+count_records,(String)hashMap.get("location_type"));	 // source_type
													map.put("source_code"+count_records,(String)hashMap.get("location_code"));	 // source_code
													map.put("order_type_code"+count_records,order_type);	 // order_type_code
													map.put("specimen_type"+count_records,specimen_type);	 // specimen_type IN071820
													//System.out.println("orOrderentryManager.java=======1237=====specimen_type=====>"+specimen_type);
													result = true;
													count_records++;		//[IN032796]
													map.put("count_records",count_records);
												}	
											}

										}
										catch(Exception e)
							{ 
								e.printStackTrace();

							}
							// End of if result, order_category
						} // End of if result
					} // End of if 	amend_grouping
				} // End of for mapOrderId
			} // End of if result after order_set
		}  // End of patient size
				if(result)
				{
					int result_val[] = pstmt.executeBatch();
					// -2 done successful but does not have the count of row affected
					for (int i=0;i<result_val.length ;i++ )
					{
						if(result_val[i] != -2  && result_val[i] < 0)
						{
							result=false;
							break;
						}
							else 
								result=true;
					}
					error_messages.append("result_val"+result_val.length);
				} // End of if result
// Insertion for the Format Fields in the Header (New Orders)
					if(result)
					{
						if(mapOrderFormatHdr!=null && mapOrderFormatHdr.size() > 0)
						{
							// FOR THE MULTI PATIENT
							for(int j=0;j<count_patient;j++)
							{
								iterator = setValues.iterator();
								// Get the patient_id , if any for Multi Patient Details
								if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
								{
									record				= (String[]) multi_patient.get(j);
									patient_id			= checkForNull(record[0],""); //patient_id
									encounter_id		= checkForNull(record[1],""); //encounter_id
									episode_id			= checkForNull(record[2],""); //episode_id
									episode_visit_num	= checkForNull(record[3],""); //episode_visit_num
								}
								for(int i=0;i<mapUniqueId.size();i++)
								{
									if(result)
									{
										grouping 			= ((String)iterator.next());										
										amend_grouping  	= checkForNull(((String)hashMap.get("amend_grouping")),"");
									
										if(!amend_grouping.equals(""))
											amend_grouping	= amend_grouping.substring(28,amend_grouping.length());
										else
											amend_grouping	= "";
										//if(amend_grouping.equals(""))	// Will insert when it is a new Order
										//{
										if(!(amend_grouping.equalsIgnoreCase(grouping))) //IN047469
										{	
											order_id 		= ((String)mapOrderId.get(grouping+patient_id+encounter_id));
											if(!(amend_grouping.equalsIgnoreCase(grouping)))	// Will insert when it is a new Order
											{
												order_type 	= getOrderType(grouping); // Get the Order_type_code from the respective grouping

											}
											else	//amend_grouping
												order_type		= ((String)hashMap.get("amend_order_type0")); // take the first one

 											result			= insertFormatFields(mapOrderFormatHdr, hashMap, tabData,order_id, order_type, count, SQL_ORDER_ENTRY_ORDER_FIELD_INSERT, SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID, SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT,SQL_OR_ORDER_ENTRY_FORMAT_HDR_CHK);
										}		
										//}
									} // End of if result
								}	// End of for mapUniqueId
							} // End of multi_patient
						} // End of if mapOrderFormatHdr
						else   // For Care Sets
						{
							if(care_set_count > 0 || total_order_cat_count >0)
							{
 								if(care_set_count>0)
									total_order_cat_count = care_set_count;

								for(int i=0;i<total_order_cat_count;i++)
								{
									mapOrderFormatHdr 	= ((HashMap)hashMap.get("header_format_values"+i)) ;
									if(mapOrderFormatHdr!=null && mapOrderFormatHdr.size() > 0 && result)
									{
										// FOR THE MULTI PATIENT
										for(int k=0;k<count_patient;k++)
										{
											// Get the patient_id , if any for Multi Patient Details
											if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
											{
												record			= (String[]) multi_patient.get(k);
												patient_id		= checkForNull(record[0],""); //patient_id
												encounter_id	= checkForNull(record[1],""); //encounter_id
											} // End of multi_patient
											for(int j=0;j<mapUniqueId.size();j++)
											{
												grouping 	= ((String)iterator.next());

												order_id 	= ((String)mapOrderId.get(grouping+patient_id+encounter_id));
												order_type 	= getOrderType(grouping); // Get the Order_type_code from the respective grouping
												//result 	= updateFormatFields(mapOrderFormatHdr,tabData,order_id,order_type,SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_DELETE,SQL_ORDER_ENTRY_ORDER_FIELD_INSERT);
												//result	= updateFormatFields(mapOrderFormatHdr, hashMap, tabData, order_id, order_type, SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_DELETE, SQL_ORDER_ENTRY_ORDER_FIELD_INSERT, SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID, SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT);
												result		= insertFormatFields(mapOrderFormatHdr, hashMap, tabData,order_id, order_type, count, SQL_ORDER_ENTRY_ORDER_FIELD_INSERT, SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID, SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT,SQL_OR_ORDER_ENTRY_FORMAT_HDR_CHK);
											}
										} // End of count_patient
									} // End of if mapOrderFormatHdr
								} // End of for
							} // End of if 	care_set_count
						}	// End of else
					}	// End of if result
				}
				catch(Exception e)
				{
					e.printStackTrace();
					result			= false;
					error_messages.setLength(0);
					error_messages.append("Exception hdr"+ e.toString());
				}
				try
				{
					// Needed for Lab Installed and to set the value for the collection_stage column in the or_order_line_lb table.
					if(count >0 && result)
					{
						// call a method where it will check for the collection_stage and then for the respective hashmap, return the hashmap
						mapcollectStage = getCollection(count, count_patient, multi_patient , hashMap, mapOrderId);
					}

				/******************/
				  if(count >0 && result)
				  {
					 order_format_values = "";
					// Insert into the Detail Tables(New Order) or_order_line ,..
					pstmt_detail		= connection.prepareStatement(SQL_ORDER_ENTRY_OR_ORDER_LINE_INSERT);
					//added on )8/05/07

					pstmt_multi			= connection.prepareStatement(SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT);
				//	pstmt_status_code	= connection.prepareStatement(SQL_OR_ORDER_GET_STATUS_CODE);
					pstmt_order_status	= connection.prepareStatement(SQL_OR_ORDER_ENTRY_CANCEL_LINE2);
					cstmt_auditLog		= connection.prepareCall("{ "+SQL_OR_ASSOCIATE_CONSENT+" }");

					//upto here
					// FOR THE MULTI PATIENT
					for(int j=0;j<count_patient;j++)
					{
						// Get the patient_id , if any for Multi Patient Details
						if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
						{
							record			= (String[]) multi_patient.get(j);
							patient_id		= checkForNull(record[0],""); //patient_id
							encounter_id	= checkForNull(record[1],"");  //encounter_id

 						}

						grouping_seq_no = 0; // Before initialize
						for(int i=0;i<count;i++)
						{
							amend_rep_group_ref			= checkForNull((String)hashMap.get("amend_rep_group_ref"+i),"");
							amend_trn_group_ref			= checkForNull((String)hashMap.get("amend_trn_group_ref"+i),"");
							ord_billed_yn			= "N";err_message	= ""; // Reinitialize
							ext_appl_accession_num	= "";charge_type_code="";
 							// Method called to get the continuing_order_ind for Line Level
							cont_order_yn		= getContinuingOrder(checkForNull((String)hashMap.get("cont_order_yn"+i),"N"),checkForNull((String)hashMap.get("freq_nature"+i),"F"),checkForNull((String)hashMap.get("frequency_val"+i),""));
 							// Take the External Appl Num, for the order, call a method to check for the order_category ext appl gen yn is Y or N, if Y call a method to generate a num and insert the value otherwise it will go as null
							if(result && ! (checkForNull((String)hashMap.get("order_category"+i),"").equals("")))  {
								if((checkForNull(getExternalApplAccessionGenYn(checkForNull((String)hashMap.get("order_category"+i),""),SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_APPL_SELECT),"N").equals("Y")) && !cont_order_yn.equals("DR") &&  !cont_order_yn.equals("CR")) // Do a query for Header Level category to identify it is Y or N
								{
  										ext_appl_accession_num   = getExternalApplAccessionNum(checkForNull((String)hashMap.get("order_category"+i),""),SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_GENERATION);
										ext_appl_accession_num   = checkForNull(ext_appl_accession_num,"");
								}
							}
							if(result)
							{	//If it an RD Category and rd_install_yn (rd is installed) , it should not break the order
								// OA Appointment grouping
									if( (!(checkForNull((String)hashMap.get("rd_install_yn"),"N").equals("Y") && checkForNull((String)hashMap.get("order_category"+i),"CS").equals("RD")) )  && checkForNull((String)hashMap.get("appt_reqd_yn"+i),"N").equals("Y"))
									{
									grouping_seq_no++;  // Increase the counter, so that if appt_reqd_yn is there will go as an different order
									split_grouping	= splitGroupingOrders(grouping_seq_no); // call a method to get the split_grouping like "000" or "001" etc
									}
									else if(checkForNull((String)hashMap.get("chart_result_type"+i),"D").equals("P")) 
									{
								    grouping_seq_no++; // Increase the counter,(For Treatment if procedure is there(P)) so that if chart_result_type is there will go as an different order
								    split_grouping	= splitGroupingOrders(grouping_seq_no); // call a method to get the split_grouping like "000" or "001" etc
									} 
									else
									split_grouping	= "000";
								// Form the grouping as was done in the bean.(combination)
								order_type = groupingOrderType((String)hashMap.get("order_category"+i), (String)hashMap.get("primary_order_type"), (String)hashMap.get("order_type"+i));
								grp_performing_facility_id= (String)hashMap.get("performing_facility_id"+i);
								if (grp_performing_facility_id==null || grp_performing_facility_id.equals(""))
								{
									grp_performing_facility_id="^^";
								}

								grp_priority= (String)hashMap.get("priority"+i);
								if (grp_priority == null || grp_priority.equals(""))
								{
									grp_priority="^^";
								}

								grp_specimen_type= (String)hashMap.get("specimen_type"+i);
								if (grp_specimen_type == null || grp_specimen_type.equals(""))
								{
									grp_specimen_type="^^";
								}

								grp_nurse_collect= (String)hashMap.get("nurse_collect"+i);
								if (grp_nurse_collect == null || grp_nurse_collect.equals(""))
								{
									grp_nurse_collect="^^";
								}

								grp_start_date_time= (String)hashMap.get("start_date_time"+i);
								if (grp_start_date_time == null || grp_start_date_time.equals(""))
								{
									grp_start_date_time="^^";
								}

								grp_frequency_val= (String)hashMap.get("frequency_val"+i);
								if (grp_frequency_val == null || grp_frequency_val.equals(""))
								{
									grp_frequency_val="^^";
								}
								grp_duration_value= (String)hashMap.get("duration_value"+i);
								if (grp_duration_value == null || grp_duration_value.equals(""))
								{
									grp_duration_value="^^";
								}

								grp_performing_dept_loc_code= (String)hashMap.get("performing_dept_loc_code"+i);
								if (grp_performing_dept_loc_code == null || grp_performing_dept_loc_code.equals(""))
								{
									grp_performing_dept_loc_code="^^";
								}
								grp_splty_code= (String)hashMap.get("splty_code"+i);
								if (grp_splty_code == null || grp_splty_code.equals(""))
								{
									grp_splty_code="^^";
								}
								String ord_auth_reqd_yn = (String)hashMap.get("ord_auth_reqd_yn"+i);
								String authorised_yn = (String)hashMap.get("authorised_yn"+i);

								if((ord_auth_reqd_yn.equals("Y")) &&(authorised_yn.equals("N")))
								{
									grp_split_auth= "Y";
								}
								else
								{
									grp_split_auth= "N";
								}
								if (grp_split_auth == null || grp_split_auth.equals(""))
								{
									grp_split_auth="^^";
								}
								if(grp_frequency_val.equals("^^"))
								{
										grouping = grp_performing_facility_id+"~~"+order_type+"~~"+grp_priority+"~~"+checkForNull(((String)hashMap.get("ord_spl_appr_reqd_yn"+i)),"N")+"~~"+grp_specimen_type+"~~"+grp_nurse_collect+"~~"+grp_start_date_time+"~~"+grp_frequency_val+"~~"+grp_duration_value+"~~"+grp_performing_dept_loc_code+"~~"+grp_splty_code+"~~"+grp_split_auth+"~~"+split_grouping;
										
										//IN030298 starts
										if(((String)hashMap.get("ord_consent_reqd_yn"+i)).equalsIgnoreCase("Y"))
										{
											grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"consent_stage"+i);//IN037633
											grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_form_id"+i),"consent_form_id"+i);
										}
										else
										{
											//grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"^^");//IN037633
											//grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_form_id"+i),"^^");
											grouping = grouping +"~~^^~~^^";//emg for medicity -IN039775
										}
										//IN030298 ends
									}
									else
									{
										grouping = grp_performing_facility_id+"~~"+order_type+"~~"+grp_priority+"~~"+checkForNull(((String)hashMap.get("ord_spl_appr_reqd_yn"+i)),"N")+"~~"+grp_specimen_type+"~~"+grp_nurse_collect+"~~"+grp_start_date_time+"~~"+grp_frequency_val+"~~"+grp_duration_value+"~~"+grp_performing_dept_loc_code+"~~"+grp_splty_code+"~~"+grp_split_auth+"~~"+i+"~~"+split_grouping;
										
										//IN030298 starts
										if(((String)hashMap.get("ord_consent_reqd_yn"+i)).equalsIgnoreCase("Y"))
										{
											grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"consent_stage"+i);//IN037633
											grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_form_id"+i),"consent_form_id"+i);
										}
										else
										{
											//grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"^^");//IN037633
											//grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_form_id"+i),"^^");
											grouping = grouping +"~~^^~~^^";//emg for medicity - IN039775
										}
										//IN030298 ends
									}
								//grouping = grouping +"~~"+checkForNull((String)hashMap.get("fpp_yn"+i),"^^")+"~~"+checkForNull((String)hashMap.get("fpp_category"+i),"^^"); //IN068314//10531
								error_messages.append("grouping"+grouping);
								order_id = ((String)mapOrderId.get(grouping+patient_id+encounter_id));
								if(order_id==null)
									order_id="";
								//For the combination done get the order id stored in mapOrderId hashmap
 								//order_id="OTIP00000002954";
								// Call a method getLineNum() where it queries  to get the order_line_num
								order_line_num = getLineNum(order_id,SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT);
									if(order_line_num > 0) 
										result = true; 
									else 
										result=false;
								if(result)
								{
									// For Billing Related , Call a procedure to execute each time
									if((checkForNull(((String)hashMap.get("billing_call_yn"+i)),"N")).equals("Y") && result)
									{   // Not called for Frequency Explosion
											bill_yn		= "Y";   // To call the consolidated Procedure
										try{
												//Modified by Uma on 1/18/2010 for IN017420 for cont_order_yn*/
												if(!cont_order_yn.equalsIgnoreCase("CR") &&  !cont_order_yn.equalsIgnoreCase("DR")){  //IN003535.
												billing_line_result	= callBillingLineLevel(tabData, hashMap, "NEW_ORDER" , SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE,  String.valueOf(i) ,order_id, patient_id,encounter_id,  order_line_num, care_set_count,"","","","",cont_order_yn);
												/*Ends Here*/
												charge_type_code	= checkForNull(billing_line_result[0],"");	//charge_type_code
												err_message			= checkForNull(billing_line_result[1],""); //error_message
												//IN003535 Start.
												} else{
													err_message = "";
												}
												//IN003535 End.
												if(! err_message.equals(""))// && !err_message.equals("Billing Service Cannot be null"))
												{
													result 			= false;						// Any Error is there Come out Immediately
													error_messages.setLength(0);
													messages.setLength(0);
												 	messages.append( err_message ) ;
													error_messages.append(err_message);
												}
											}
											catch(Exception ex)
											{
												ex.printStackTrace();
												result				= false;
												error_messages.setLength(0);
												error_messages.append("Exception Billing Details"+ ex.toString());
											}
									} // End of billing_call_yn
						  		} // End of if result
							if(result)   // Line Level Insertion done here
							{		// Insertion into the order line tables
								// IN024984  - Start
								String l_catalog_code = ((String)hashMap.get("catalog_code"+i));
								String duplicate_code_remarks = "";
								barcode_reqd_yn = (String) hashMap.get("barcode_reqd_yn"+i);//IN063816
								if(barcode_reqd_yn == null || "".equals(barcode_reqd_yn) || "null".equals(barcode_reqd_yn))
									barcode_reqd_yn="N";
									
								prn_regd_ord = (String) hashMap.get("prn_regd_ord"+i);//IN065942
								
								if(dupeReasonHashMap != null) {
									if(dupeReasonHashMap.containsKey(l_catalog_code)){
									duplicate_code_remarks = (String)dupeReasonHashMap.get(l_catalog_code);
									duplicate_code_remarks = java.net.URLDecoder.decode(duplicate_code_remarks,"UTF-8");//IN047605
									}
								}	
								// IN024984 - End
								
								//IN041371 - Start
								//IN055190 starts
								//order_category = (String)hashMap.get("order_category");
								order_category = (String)hashMap.get("order_category"+i);
								//IN055190 ends
								specimen_type = (String)hashMap.get("specimen_type"+i);
								nurse_collect = (String)hashMap.get("nurse_collect"+i);
								start_date_time = (String)hashMap.get("start_date_time"+i);							
								if(result && order_category.equalsIgnoreCase("LB") && (checkForNull((String)hashMap.get("function_from"),"").equalsIgnoreCase("AMEND_ORDER")) )
								{	
		                        	if(specimen_no.equals(""))
									{ //IN053304
		                        		specimen_no = checkForNull(getSpecimenNo(order_id),"");
		                        		StringTokenizer spec = new StringTokenizer (specimen_no,"#");
		                        		String order_line_status = "";
			                        	while(spec.hasMoreTokens())
			            				{
											specimen_no     = checkForNull(spec.nextToken(),""); 
											//IN065725, starts
											if("~".equals(specimen_no))
												specimen_no = "";
											//IN065725, ends


			                        		order_line_status     = checkForNull(spec.nextToken(),"OS");   
			            				}
			                        	if(!specimen_no.equals(""))
			                        	{
			                        		coll_label_gen_rule = "G";
			                        		hashMap.put("collection_stage"+i,"N");
			                        		hashMap.put("order_status_code"+i,order_line_status);
			                        		mapSpecimenNo.put(order_id, coll_label_gen_rule+"~~"+specimen_no);  // Specimen No and coll_label_gen_rule has been stored for that grouping(Order_id)
			                        	}
		                        	}
								}	//IN053304
								//IN041371 - End
								pstmt_detail.setString(1,order_id); // Order_id
								pstmt_detail.setInt(2, order_line_num);	// order_line_num
								error_messages.append("order_line_num"+order_line_num);
								pstmt_detail.setString(3, ((String)hashMap.get("catalog_code"+i)));	// order_catalog_code
								pstmt_detail.setString(4, ((String)hashMap.get("cat_desc"+i))); // Catalog desc
								pstmt_detail.setString(5, ((String)hashMap.get("catalog_code"+i)));	// catalog_synonym_dc (pass the catalog, in the query it is handled)
								pstmt_detail.setString(6, ((String)hashMap.get("catalog_code"+i)));	// catalog_synonym_dc (pass the catalog, in the query it is handled)
								pstmt_detail.setString(7, ((String)hashMap.get("catalog_code"+i)));	// catalog_synonym_ad (pass the catalog, in the query it is handled)
								pstmt_detail.setString(8, ((String)hashMap.get("catalog_code"+i)));	// catalog_synonym (pass the catalog, in the query it is handled)
								pstmt_detail.setString(9, ((String)hashMap.get("catalog_code"+i)));	// catalog_synonym (pass the catalog, in the query it is handled)
								/*pstmt_detail.setString(5, ((String)hashMap.get("catalog_code_dc"+i))); // catalog_synonym_dc
								pstmt_detail.setString(6, ((String)hashMap.get("catalog_code_ad"+i))); // catalog_synonym_ad
								pstmt_detail.setString(7, ((String)hashMap.get("cat_desc"+i)));		   // catalog_synonym
								*/
								pstmt_detail.setString(10, ((String)hashMap.get("order_catalog_nature"+i))); // order_catalog_nature
								pstmt_detail.setString(11, ((String)hashMap.get("order_type"+i)));		// order_type_code
								// If Order Category is not equal to CS Take the header one other wise take it each time
								if(!checkForNull(((String)hashMap.get("order_category")),"CS").equalsIgnoreCase("CS"))
									pstmt_detail.setString(12, ((String)hashMap.get("order_category")));	//order_category
								else
									pstmt_detail.setString(12, ((String)hashMap.get("order_category"+i)));	// order_category
								pstmt_detail.setString(13, ((String)hashMap.get("order_date_time")));		// ord_date_time
								pstmt_detail.setString(14, ((String)hashMap.get("priority"+i)));			// priority
								pstmt_detail.setString(15, ((String)hashMap.get("ord_auth_reqd_yn"+i)));	// ord_auth_reqd_yn
								pstmt_detail.setString(16, null); //ord_auth_reason
								pstmt_detail.setString(17, ((String)hashMap.get("ord_spl_appr_reqd_yn"+i)));// ord_appr_reqd_yn
								pstmt_detail.setString(18, ((String)hashMap.get("ord_cosign_reqd_yn"+i)));	// ord_cosign_reqd_yn
								pstmt_detail.setString(19, ((String)hashMap.get("ord_consent_reqd_yn"+i))); // ord_consent_reqd_yn
								pstmt_detail.setString(20, ((String)hashMap.get("start_date_time"+i))); 	//start_date_time
								//pstmt_detail.setString(21, ((String)hashMap.get("form_code"+i)));	// form_code (value will be there only if it pharmacy otherwise null)//11766
								pstmt_detail.setString(21, form_code); //11766
								//pstmt_detail.setString(22, ((String)hashMap.get("route_code"+i)));	// route_code (value will be there only if it pharmacy otherwise null)//11766
								pstmt_detail.setString(22, route_code);	// route_code (value will be there only if it pharmacy otherwise null)//11766
 								/*if(checkForNull(((String)hashMap.get("order_category"+i)),"CS").equalsIgnoreCase("PH")){      // Only for PH (Order Set)
									pstmt_detail.setString(23, checkForNull(((String)hashMap.get("dosage"+i)), "0"));		// qty_value
									pstmt_detail.setString(24, checkForNull(((String)hashMap.get("uom"+i)), "")); // qty_unit
								} else {*/	// For ALL OTHER CATEGORIES
									pstmt_detail.setString(23, checkForNull(((String)hashMap.get("quantity"+i)), "0"));		// qty_value
									pstmt_detail.setString(24, checkForNull(((String)hashMap.get("quantity_uom"+i)), "")); // qty_unit
								//}
								pstmt_detail.setString(25, ((String)hashMap.get("frequency_val"+i)));	// freq_code
								pstmt_detail.setString(26, ((String)hashMap.get("duration_value"+i)));	// durn_value
								pstmt_detail.setString(27, ((String)hashMap.get("duration"+i)));		// durn_type
								mapOrderFormatDtl = ((HashMap)hashMap.get("header_line_values"+i));
 								if(mapOrderFormatDtl!=null && mapOrderFormatDtl.size() > 1)	// If the Order Formats are there
								{
 									order_format_values = ((String)mapOrderFormatDtl.get("order_format_values"));
									if(order_format_values.length() > 500) order_format_values = order_format_values.substring(0,499);
									pstmt_detail.setString(28, order_format_values);  // concatenate the order_formats -- line_fields_display_text
 								}
								else
									pstmt_detail.setString(28, null);		// line_fields_display_text
 								
								//IN64543, starts
								//pstmt_detail.setString(29, ((String)hashMap.get("line_comments"+i)));	// item_narration
								if("T".equals((String)hashMap.get("instrn_content_type"+i)))
 								{
 									pstmt_detail.setString(29, ((String)hashMap.get("line_comments"+i)));	// item_narration
 									pstmt_detail.setString(81, null);
 								}
 								else if("E".equals((String)hashMap.get("instrn_content_type"+i)))
 								{
 									pstmt_detail.setString(29, null);
 									pstmt_detail.setString(81, ((String)hashMap.get("line_comments"+i)));
 								}
								//IN64543, ends
								pstmt_detail.setString(30, null);  //next_sched_date
								if(checkForNull(((String)hashMap.get("frequency_val"+i)),"").equals(""))
									pstmt_detail.setString(31, null);
								else
									pstmt_detail.setString(31, ((String)hashMap.get("end_date_time"+i)));	// end_date_time
								pstmt_detail.setString(32, null);	// auto_stop_date_time

							//Commented by Jyothi on 15/12/2009 to fix IN015497, since it is updating the wrong quantity
							/*if(checkForNull(((String)hashMap.get("order_category"+i)),"CS").equalsIgnoreCase("PH")){
								ph_calculations	= getPHCalculations(hashMap, i, checkForNull((String)hashMap.get("freq_nature"+i),"F"), SQL_OR_ORDER_ENTRY_PH_EQVL); // calculations for PH
								quantity		= checkForNull(ph_calculations[0],"");	// quantity
								quantity_uom	= checkForNull(ph_calculations[1],"");	// quantity_uom
							} else {*/
								quantity		= checkForNull((String)hashMap.get("quantity"+i),"");
								quantity_uom	= checkForNull((String)hashMap.get("quantity_uom"+i),"");
							//}

								pstmt_detail.setString(33, quantity);		// order_qty
								pstmt_detail.setString(34, quantity_uom);	// order_uom
								pstmt_detail.setString(35, ((String)hashMap.get("appt_reqd_yn"+i))); // appt_reqd_yn
								pstmt_detail.setString(36, null);	// appt_date_time
								pstmt_detail.setString(37, null);	// appt_ref_num
								pstmt_detail.setString(38, ((String)hashMap.get("result_applicable_yn"+i)));	// result_applicable_yn
								pstmt_detail.setString(39, ((String)hashMap.get("bill_yn"+i)));	//bill_yn
								pstmt_detail.setString(40, ord_billed_yn);	// billed_yn

								pstmt_detail.setString(41, cont_order_yn); // For cont_order_ind
								error_messages.append("Line Level cont_order_yn"+ cont_order_yn);
								pstmt_detail.setString(42, "N");	// refill_single_cont_order_yn
								pstmt_detail.setString(43, null);	// num_of_refills
								pstmt_detail.setString(44, "N");	// child_order_yn
								pstmt_detail.setString(45, null);	// parent_order_id
								pstmt_detail.setString(46, null);	// parent_order_line_num

								 if(checkForNull((String)mapOrderSet.get(patient_id),"").equals(""))
								{ // For all orders except orderset
									 if(!(checkForNull((String)hashMap.get("order_set_id"),"").equals("")))
									{
										//order_set_line_num++;
										pstmt_detail.setString(47, checkForNull((String)hashMap.get("order_set_id"),"")); // order_set_id
										pstmt_detail.setString(48, checkForNull((String)hashMap.get("order_set_line_num"+i),""));
									}
									else
									{
										pstmt_detail.setString(47, null);  		// order_set_id
										pstmt_detail.setString(48, null); 		// order_set_line_num
									}
								}
								else
								{
									order_set_line_num++; // Increment the count for the same order_set_id (orderset)
									pstmt_detail.setString(47,  checkForNull((String)mapOrderSet.get(patient_id),""));  // order_set_id
									pstmt_detail.setString(48,  String.valueOf(order_set_line_num));  // order_set_line_num
								}
								pstmt_detail.setString(49, ((String)hashMap.get("ordering_practitioner_id"))); // ord_pract_id
								pstmt_detail.setString(50, null);   // ord_set_date_time
								// From the HashMap get the specimen No -- Accession No,
								specimen_no_rule = checkForNull(((String)mapSpecimenNo.get(order_id.trim())),""); // Get from the HashMap
										if(!specimen_no_rule.equals("")) 
											specimen_no = specimen_no_rule.substring(3,specimen_no_rule.length());
								if(((String)hashMap.get("order_category"+i)).equalsIgnoreCase("LB") && (!specimen_no_rule.equals("")) && (!specimen_no.equals("X")))
								{
									pstmt_detail.setString(51, specimen_no);	// accession_num
									pstmt_detail.setInt(52, order_line_num);	// accession_line_num
								}
								else
								{
									pstmt_detail.setString(51, null);			// accession_num
									pstmt_detail.setString(52, null);			// accession_line_num
								}
								error_messages.append("order_status detail"+ ((String)hashMap.get("order_status_code"+i)));
								// derive the logic
								pstmt_detail.setString(53, ((String)hashMap.get("order_status_code"+i))); // order_line_status
								pstmt_detail.setString(54, null);		// result_line_status
								pstmt_detail.setString(55, ((String)hashMap.get("result_auth_reqd_yn"+i))); //result_auth_reqd_yn
										if  (checkForNull((String)hashMap.get("order_status_code"+i),"").equalsIgnoreCase("CD"))
										{
									pstmt_detail.setString(56, "Auto Completed");   // complete_remarks
									pstmt_detail.setString(57, ((String)hashMap.get("sys_date")));   // complete_date_time
										}
										else 
										{
									pstmt_detail.setString(56, null);   // complete_remarks
									pstmt_detail.setString(57, null);   // complete_date_time
								}

								pstmt_detail.setString(58, checkForNull((String)hashMap.get("consent_stage"+i),"")); 		 // consent_stage (from or_order_catalog, can be null, 'A'--> 'Before Order Release', 'R'--> 'Before Order Registration'
								if( checkForNull((String)hashMap.get("ord_consent_reqd_yn"+i),"N").equals("Y") && checkForNull((String)hashMap.get("consent_stage"+i),"").equals("R")) {
									pstmt_detail.setString(59, "P"); 	// if consent is there, then the value will be P--> Pending
										}
										else 
										{
									pstmt_detail.setString(59, "N"); 	// if consent is there, then the value will be P--> Pending 							// otherwise not applicable
								}

								pstmt_detail.setString(60, checkForNull((String)hashMap.get("notify_yn"+i),"N")); 	// If for Dependency NOTIFY_YN is there
 								pstmt_detail.setString(61, checkForNull(ext_appl_accession_num,"")); 	// If for ext_appl_accession_num is there for order_category
								pstmt_detail.setString(62, checkForNull(charge_type_code,"")); 			// charge_type_code

								pstmt_detail.setString(63, ((String)tabData.get("login_by_id")));		// added_by_id
								pstmt_detail.setString(64, ((String)tabData.get("login_at_ws_no")));	// added_at_ws_no
								pstmt_detail.setString(65, ((String)tabData.get("login_facility_id"))); // added_facility_id

								pstmt_detail.setString(66, ((String)tabData.get("login_by_id")));		// modified_by_id
								pstmt_detail.setString(67, ((String)tabData.get("login_at_ws_no")));	// modified_at_ws_no
								pstmt_detail.setString(68, ((String)tabData.get("login_facility_id"))); // modified_facility_id
								pstmt_detail.setString(69, ((String)hashMap.get("activity_type"+i)));	// activity_type
								//added on 08/05/07
								pstmt_detail.setString(70, ((String)hashMap.get("num_of_consent_req_bo"+i)));	// num_of_consent_req_bo
								pstmt_detail.setString(71, ((String)hashMap.get("num_of_consent_req_br"+i)));	// num_of_consent_req_br
								pstmt_detail.setString(72, checkForNull((String)hashMap.get("FUTURE_ORDER_CHARGE_LATER_YN"+i),"N"));	// FUTURE_ORDER_CHARGE_LATER_YN
								pstmt_detail.setString(73, checkForNull(((String)hashMap.get("splty_code"+i)),""));	// FUTURE_ORDER_CHARGE_LATER_YN

								// Added by Kishore kumar N on Aug-05-09 For the CRF 640-OR.
								pstmt_detail.setString(74, checkForNull(((String)hashMap.get("future_order_YN"+i)),""));
								//Modified by Uma on 12/3/2010 for IN025360*/
								if(!order_id.equalsIgnoreCase((String)hashMap.get("amend_order_id")))
								{
									orig_order_id = (String)hashMap.get("amend_order_id");
											if(orig_order_id==null)
												orig_order_id="";
								}
								else
								{
									orig_order_id = "";	
								}
								/*Ends Here*/
								pstmt_detail.setString(75, orig_order_id);
								pstmt_detail.setString(76, amend_trn_group_ref);
								pstmt_detail.setString(77, amend_rep_group_ref);
								pstmt_detail.setString(78, duplicate_code_remarks); // IN024984
								pstmt_detail.setString(79, barcode_reqd_yn); // IN063816
								pstmt_detail.setString(80, (String)hashMap.get("instrn_content_type"+i));//IN64543
								pstmt_detail.setString(82, (String)hashMap.get("fpp_yn"+i));//IN068314
								pstmt_detail.setString(83, (String)hashMap.get("fpp_category"+i));//IN068314
								result_dtl = pstmt_detail.executeUpdate();
								if(result_dtl > 0 ) result = true; else result = false;
								//added on 08/05/07
							if(result)
							{
								record_multi = false;
								if( checkForNull((String)hashMap.get("ord_consent_reqd_yn"+i),"N").equals("Y"))
								{
									multiConsentDtl =((HashMap)hashMap.get("multi_consent_dtl"+i));

									if(multiConsentDtl != null)
									{
										count_consent = (String)multiConsentDtl.get("count");
										if (count_consent == null || count_consent.equals(""))
										{
											count_consent = "0";
										}
										multi_count = Integer.parseInt(count_consent);
										record_multi = false;
										for(int k=0;k<multi_count;k++){
										if(((String)multiConsentDtl.get("consent_chk"+k)).equals("Y"))
										{
											pstmt_multi.setString(1, order_id);  //order_id
											pstmt_multi.setInt(2, order_line_num); //order_line_num
											pstmt_multi.setString(3, (String)multiConsentDtl.get("consent_form_id"+k));
											pstmt_multi.setString(4, (String)multiConsentDtl.get("consent_stage"+k));
											pstmt_multi.setString(5, ((String)tabData.get("login_by_id")));
											pstmt_multi.setString(6, ((String)tabData.get("login_at_ws_no")));
											pstmt_multi.setString(7, ((String)tabData.get("login_facility_id")));
											pstmt_multi.setString(8, ((String)tabData.get("login_by_id")));
											pstmt_multi.setString(9, ((String)tabData.get("login_at_ws_no")));
											pstmt_multi.setString(10,((String)tabData.get("login_facility_id")));
											pstmt_multi.addBatch();

											record_multi = true;
										}// end of if consent_chk
									}// end of for count
								}// end of multiConsentDtl null chk
								if (record_multi)
								{
									int[] updatebatch_multi = pstmt_multi.executeBatch();
									for (int x=0;x<updatebatch_multi.length ;x++ )
									{
										if(updatebatch_multi[x] !=-2 && updatebatch_multi[x] < 0) // -3 if it fails
										{
											result=false;
											break;
										}
														else 
															result=true;
									}
									if (result)
									{
										cstmt_auditLog.setString(1, order_id);			//order_id
										cstmt_auditLog.setInt(2, order_line_num);	//order_line_num
										cstmt_auditLog.execute();
									}
								}
							}// end of consent_req_yn chk
							//IN063816 starts
							if("TR".equalsIgnoreCase(order_category) && "Y".equalsIgnoreCase(barcode_reqd_yn))
							{
								//IN064614 starts
								print_barcode_values.put("order_catalog_code"+barcode_count_records,(String)hashMap.get("catalog_code"+i));	
								print_barcode_values.put("order_id_"+barcode_count_records,order_id);
								print_barcode_values.put("order_line_num"+barcode_count_records,order_line_num);	 // order_line_num
								print_barcode_values.put("patient_id"+barcode_count_records,patient_id);	 // patient_id
								print_barcode_values.put("barcode_reqd_yn"+barcode_count_records,barcode_reqd_yn);	 // barcode_reqd_yn
								print_barcode_values.put("facility_id"+barcode_count_records,(String)tabData.get("login_facility_id"));	 // login_facility_id
								print_barcode_values.put("module_id"+barcode_count_records,"OR");	 // login_facility_id
								
								result = true;
								barcode_count_records++;
								map.put("print_barcode_values",print_barcode_values);//IN064614
								map.put("barcode_count_records",String.valueOf(barcode_count_records));	 //IN064614
								//IN064614 ends
							}
							else
							{
								map.put("barcode_count_records",String.valueOf(barcode_count_records));	 //IN064614
							}
							//IN063816 ends


							//IN065942, starts
							if("Y".equals(prn_regd_ord) && "RX".equalsIgnoreCase(order_category) &&  "RG".equals((String)hashMap.get("order_status_code"+i)))
							{							
								populatePrnRegLbl(order_id,order_line_num,map,prn_reg_lab_values,prn_reg_lab_cnt);
								prn_reg_lab_cnt++;
							}
							//IN065942

						  }// end if result
						  /****************/
						//up to here
						if(result)
						{
							// To be passed to the bean  back for the OA Appointment Booking
							// Do not callfor the Multi Patient Orders
							if(multi_patient==null || multi_patient.size()==0) 
							{
								// Appointment is there for the catalog
								// getAppointment will be called and the values will be set in the hashtable, so that they will be called in a appointment window
								// after commiting the record. pass the last parameter as "NEW" to differentiate it is coming from new or amend order
								map.put( "order_id", order_id) ;
								getAppointment(hashMap, i, order_id, order_line_num, "NEW");  // Appointment logic building
							}
							// till here for OA book appt

							//Add For Prior Orders By Siva Kumar
							try
							{
								cstmt_priorOrders.setString(1, ((String)tabData.get("login_facility_id")));  // ORDERING_FACILITY_ID
								cstmt_priorOrders.setString(2, ((String)hashMap.get("catalog_code"+i)));  // CATALOG_CODE
								cstmt_priorOrders.setString(3, ((String)hashMap.get("patient_class")));	 // PATIENT_CLASS
								cstmt_priorOrders.setString(4, ((String)hashMap.get("priority"+i))); //PRIORITY
								cstmt_priorOrders.setString(5, order_id);	 // ORDER_ID
								cstmt_priorOrders.setString(6, String.valueOf(order_line_num));	//ORDER_LINE_NUM
								cstmt_priorOrders.setString(7, ((String)hashMap.get("start_date_time"+i)));	//START_DATE_TIME							 // At present SECTION_CODE
								cstmt_priorOrders.registerOutParameter( 8,  Types.VARCHAR ) ;			 // ERR_MSG
								cstmt_priorOrders.execute();

								prior_orders_err_msg 	= checkForNull(cstmt_priorOrders.getString(8),""); //checkForNull(cstmt_priorOrders.getString(8),"X");
												if (prior_orders_err_msg != null && (!prior_orders_err_msg.equals(""))) 
												{
									result = false;
								}
										// Till here
											}
											catch(Exception e)
							{
								e.printStackTrace();
								result		   = false;
								error_messages.setLength(0);
								error_messages.append("EJB-Exception dtl Prior Orders Procedure"+ e.toString());
							}
							//End of Addition For Prior Orders

									// To print the consent form for the line level, Add it in a Hash table and pass it to the bean where on line printing is called
        /*		Time being commented, because consent form is now changed and it is appearing in editor and printing will be done in consent Orders only.
				if( result && (checkForNull(((String)hashMap.get("ord_consent_reqd_yn"+i)),"").equalsIgnoreCase("Y")) )
									//&& (!(checkForNull((String)hashMap.get("order_status_code"+i),"").equalsIgnoreCase("PO")) && (!(checkForNull((String)hashMap.get("order_status_code"+i),"").equalsIgnoreCase("PC")))  && (!(checkForNull((String)hashMap.get("order_status_code"+i),"").equalsIgnoreCase("PS")))) ) //If it not a outstanding order, then print
									{
										print_values.put("order_id"+consent_count,order_id);	 							 		// order_id
										print_values.put("order_line_num"+consent_count,String.valueOf(order_line_num));			// order_line_num
										print_values.put("order_type_code"+consent_count,((String)hashMap.get("order_type"+i)));	// order_type_code
										print_values.put("priority"+consent_count,((String)hashMap.get("priority"+i)));	 	 		// priority
										print_values.put("patient_class"+consent_count,((String)hashMap.get("patient_class")));	 	// patient_class
										print_values.put("location_type"+consent_count,((String)hashMap.get("location_type")));	 	// location_type
										print_values.put("location_code"+consent_count,((String)hashMap.get("location_code")));	 	// location_code
										print_values.put("facility_id"+consent_count,((String)tabData.get("login_facility_id")));   // Facility Id
										consent_count++;
									}
		*/
								}
								// Insertion done for the Individual Tables(Laboratory,Radiology,Radiology Dept)
								if(result)
								{
									order_category =  checkForNull(((String)hashMap.get("order_category"+i)),"");
									// Insertion done in the Laboratory  Table
									if(order_category.equalsIgnoreCase("LB") && !cont_order_yn.equals("DR"))
									{
										result = insertLaboratory(tabData,hashMap,mapSpecimenNo,mapcollectStage,i,order_id,order_line_num,SQL_ORDER_ENTRY_OR_ORDER_LINE_LB_INSERT,SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO,SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO);
									}
									else if(order_category.equalsIgnoreCase("RD"))
									{
										result = insertRadiology(tabData,hashMap,i,order_id,order_line_num,SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_INSERT);
									}
									else if(order_category.equalsIgnoreCase("RX"))
									{
										result = insertRadiologyDept(tabData,hashMap,i,order_id,order_line_num,SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_INSERT);
									}


									// If it is from CP/CA Module, Update the CP/CA table
									if(checkForNull((String)hashMap.get("function_from"),"").equalsIgnoreCase("CP"))
									{
										result = updateCP(tabData,hashMap, patient_id, order_id, SQL_OR_ORDER_ENTRY_CP_UPDATE);
									}

									// If it is from MO Module, Update the MO table
									if(checkForNull((String)hashMap.get("function_from"),"").equalsIgnoreCase("MO"))
									{
												result = insertLineMO(tabData,hashMap,order_id,order_line_num,SQL_ORDER_ENTRY_OR_ORDER_LINE_MO_INSERT);
												if(result)
										result = updateMO(tabData,hashMap,i,order_id, SQL_OR_ORDER_ENTRY_MO_UPDATE);
									}

									// For auto_report_yn is Y, then it should be fully resulted, (insert records in or_result_header & or_result_detail --> thru procedure). that means if order_line_status is 85 (completed) fall the result procedure
									//if(checkForNull((String)hashMap.get("auto_report_yn"+i),"").equals("Y"))

									if(checkForNull((String)hashMap.get("order_status_code"+i),"").equals("85") && checkForNull((String)hashMap.get("auto_report_yn"+i),"").equals("Y"))
									{
										err_message 	= insertResult(tabData,hashMap,i,order_id,order_line_num, SQL_OR_ORDER_ENTRY_OR_AUTOREPORT_COMPLETION);
										if(!err_message.equals(""))
										{
											result 			= false;	 // Any Error is there , Dont Proceed
											error_messages.setLength(0);
 											messages.setLength(0);
											messages.append( err_message ) ;
											error_messages.append(err_message);
										} // End of !err_message
									}
								} // End of if result

								// Insertion for the PH related details
								if(result && order_category.equalsIgnoreCase("PH"))
								{
									err_message 	= callPHInsertDetails(tabData, hashMap, SQL_OR_ORDER_ENTRY_PH_INSERT_DTLS, i, order_id, String.valueOf(order_line_num), patient_id, encounter_id, order_format_values,ph_calculations);
									if(! err_message.equals(""))
									{
										result 			= false;	 // Any Error is there , Dont Proceed
										error_messages.setLength(0);
 										messages.setLength(0);
										messages.append( err_message ) ;
										error_messages.append(err_message);
									} // End of !err_message
 								} // End of PH
							error_messages.append("result_dtl"+result_dtl);
						} // End of if result
						//Do the Preps Insertion
						
						if(result)
						{
							String l_instrn_content_type = (String)hashMap.get("instrn_content_type"+i);//IN64543
							// Call a insertFormatLineInstns() method to insert the Preps Instn
							if(!(checkForNull((String)hashMap.get("line_preps"+i),"").equals("")))
							{
								instrns = checkForNull((String)hashMap.get("line_preps"+i),"");
								//result = insertFormatLineInstns(tabData,order_id,order_line_num,order_line_num,"PREPS",instrns,SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT);//IN64543
								result = insertFormatLineInstns(tabData,order_id,order_line_num,order_line_num,"PREPS",instrns,SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT,l_instrn_content_type);//IN64543
							}
							// Call a insertFormatLineInstns() method to insert the Depts. Instn
							if(result)
							{
								if(!(checkForNull((String)hashMap.get("line_dept_instrn"+i),"").equals("")))
								{
									instrns = checkForNull((String)hashMap.get("line_dept_instrn"+i),"");
									//result = insertFormatLineInstns(tabData,order_id,order_line_num,order_line_num+1,"DEPTS",instrns,SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT);//IN64543
									result = insertFormatLineInstns(tabData,order_id,order_line_num,order_line_num+1,"DEPTS",instrns,SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT,l_instrn_content_type);//IN64543
									error_messages.append("result depts"+result);
								}
								if(result) // For the Patient Instruction to be inserted/updated
								{
									if(!(checkForNull((String)hashMap.get("line_pat_instrn"+i),"").equals("")))
									{
										instrns = checkForNull((String)hashMap.get("line_pat_instrn"+i),"");
										//result = insertFormatLineInstns(tabData,order_id,order_line_num,order_line_num+2,"PATIENT_INSTRN",instrns,SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT);//IN64543
										result = insertFormatLineInstns(tabData,order_id,order_line_num,order_line_num+2,"PATIENT_INSTRN",instrns,SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT,l_instrn_content_type);//IN64543
										error_messages.append("result depts"+result);
									}
								} // End of if result
							} // End of if result
						} // End of if result
						// Insert the Values for the Order Formats in the Line(New Orders)
						mapOrderFormatDtl = ((HashMap)hashMap.get("header_line_values"+i));
						l_catalog_format_id = (String)hashMap.get("format_id"+i);//IN066436
						if(l_catalog_format_id == null || "null".equals(l_catalog_format_id))//IN066436
							l_catalog_format_id = "";//IN066436
						//IN066436 starts
						if(!"".equals(l_catalog_format_id) && mapOrderFormatDtl.size() <= 1)
						{
							result = false;
							l_spec_err_msg = "APP-OR0453 Operation failed since some of mandatory format item is going blank, please check and record again!";
						}
						//IN066436 ends
						if(mapOrderFormatDtl.size() > 1)
						{
							if(result)
							{
								result = insertFormatLineFields(mapOrderFormatDtl,tabData,order_id,order_line_num,	SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT);
							} // End of if result
								//IN066436 starts
								if(!result)
								{												
									l_spec_err_msg = "APP-OR0453 Operation failed since some of mandatory format item is going blank, please check and record again!";
								}
								//IN066436 ends
						}	 // End of if mapOrderFormatDtl
									else 
									{ // Check for Amend (new Insert) --> replicate old to the Newone
							if(result)
								result = insertAmendFormatLineFields(hashMap, tabData,order_id, order_line_num, i , SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_INSERT);
						} // End of Else

						// To insert the values for the Schedule field values in the line level insertScheduleLineFields() method is called
						if(result)
						{
							mapScheduleDtl = ((ArrayList)hashMap.get("schedule_format_line_values"+i));
							
							if(mapScheduleDtl.size() > 0)
							{
								HashMap dummy_map = (HashMap)mapScheduleDtl.get(0);
								if (dummy_map.get("dummy_val") == null)
								{
									result = insertScheduleLineFields(mapScheduleDtl,tabData,order_id,order_line_num,SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT);
								}									
							}
						}

						// insert into the MO_morturary_regn , if it is a deceased patient
									if(result && checkForNull((String)hashMap.get("mo_install_yn"),"").equals("Y") && checkForNull((String)hashMap.get("deceased_yn"),"").equals("Y") && (Integer.parseInt((checkForNull((String)hashMap.get("mo_mortuary_count"),"0")) ) == 0 ) )
									{
							result = insertMoMortuaryRegn(tabData, hashMap, i , order_id,order_line_num,patient_id,SQL_OR_ORDER_ENTRY_PATIENT_MO_CATALOG_SELECT, SQL_OR_ORDER_ENTRY_PATIENT_MO_ORDER_FOR_POSTMORTERM_COUNT, SQL_OR_ORDER_ENTRY_MO_ORDER_FOR_POSTMORTERM_INSERT);
						}

					  } // End of if result
					}// End of For i
				} // End of for count_patient

/*					if(consent_count > 0) {
						print_values.put("order_entry", "OrderEntry");
						print_values.put("total_records", String.valueOf(consent_count)); // For On Line Printing
					}
*/
			      } // end of if count
					if(pstmt_multi!=null)
						pstmt_multi.close();

					if(cstmt_auditLog!=null)
						cstmt_auditLog.close();
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
					error_messages.append("Exception Details"+ e.toString());
					result	= false;
				}
		} // End of if count
		else if(result && amend_total_count > 0) //this is added for multiconsent on 14/05/07
		{
			for(int i=0;i<amend_total_count;i++)
			{
				OrderID.append(" "+((String)hashMap.get("amend_order_id")));
				order_line_num 		= (Integer.parseInt(((String)hashMap.get("amend_order_line_num"+i))));
				order_id 			= ((String)hashMap.get("amend_order_id"));
				multiConsentDtl =((HashMap)hashMap.get("amend_multi_consent_dtl"+i));
				if(multiConsentDtl != null)
				{
					count_consent = (String)multiConsentDtl.get("count");
					if (count_consent == null || count_consent.equals(""))
					{
						count_consent = "0";
					}
					multi_count = Integer.parseInt(count_consent);

			//			record_multi = false;
						//pstmt_multi.clearParameters();
					if (pstmt_multi!=null)
					{
						pstmt_multi.close();
					}
					if(multi_count!=0)
					{
						pstmt_multi = connection.prepareStatement(SQL_OR_CONSENT_DRAFT_AMEND_DELETE);
						pstmt_multi.setString(1, order_id);
						pstmt_multi.setInt(2, order_line_num);
						pstmt_multi.executeUpdate();
					}
					//pstmt_multi.close();
					if (pstmt_multi!=null)
					{
						pstmt_multi.close();
					}
					if (cstmt_auditLog!=null)
					{
						cstmt_auditLog.close();
					}
					//pstmt_multi.clearParameters();
					pstmt_multi			= connection.prepareStatement(SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT);
					cstmt_auditLog		= connection.prepareCall("{ "+SQL_OR_ASSOCIATE_CONSENT+" }");
					record_multi = false;
					for(int k=0;k<multi_count;k++)
					{
						if(((String)multiConsentDtl.get("consent_chk"+k)).equals("Y"))
						{
							pstmt_multi.setString(1, order_id);  //order_id
							pstmt_multi.setInt(2, order_line_num); //order_line_num
							pstmt_multi.setString(3, (String)multiConsentDtl.get("consent_form_id"+k));
							pstmt_multi.setString(4, (String)multiConsentDtl.get("consent_stage"+k));
							pstmt_multi.setString(5, ((String)tabData.get("login_by_id")));
							pstmt_multi.setString(6, ((String)tabData.get("login_facility_id")));
							pstmt_multi.setString(7, ((String)tabData.get("login_facility_id")));
							pstmt_multi.setString(8, ((String)tabData.get("login_by_id")));
							pstmt_multi.setString(9, ((String)tabData.get("login_facility_id")));
							pstmt_multi.setString(10,((String)tabData.get("login_facility_id")));
							pstmt_multi.addBatch();

							record_multi = true;
						}// end of if consent_chk
					}// end of for count
					if(record_multi)
					{
						int[] updatebatch_multi = pstmt_multi.executeBatch();
						for (int x=0;x<updatebatch_multi.length ;x++ )
						{
							if(updatebatch_multi[x] !=-2 && updatebatch_multi[x] < 0)
							{// -3 if it fails
								result=false;
								break;
							}
								else 
									result=true;
						}
						if (result)
						{
							cstmt_auditLog.setString(1, order_id);			//order_id
							cstmt_auditLog.setInt(2, order_line_num);	//order_line_num
							cstmt_auditLog.execute();
						}
					}
				}
				if(pstmt_multi!=null)
						pstmt_multi.close();

					if(cstmt_auditLog!=null)
						cstmt_auditLog.close();
			}
		}
		//Insert the comments into the table(Header Level)
		//if(result && (header_comments.length() > 0 || (!checkForNull((String)hashMap.get("amend_order_id"),"").equals("")) ) )
		//if(result && (header_comments.length() > 0) ) // commented for IN048464
		if(result) // modified for IN048464
		{
				try
				{
				pstmt_comments	= connection.prepareStatement(SQL_ORDER_ENTRY_ORDER_COMMENT_INSERT);
				pstmt_clob		= connection.prepareStatement(SQL_ORDER_ENTRY_ORDER_COMMENT_CLOB_SELECT);
				boolean isEmpty = true; // IN048464 
				for(int j=0;j<count_patient;j++)
				{
					// Get the patient_id , if any for Multi Patient Details
					if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
					{
						record			= (String[]) multi_patient.get(j);
						patient_id		= checkForNull(record[0],""); //patient_id
						encounter_id	= checkForNull(record[1],""); //encounter_id

					}


					iterator 		= setValues.iterator();
					//for(int i=0;i<mapOrderId.size();i++)
					if(mapUniqueId.size()==0 && amend_total_count > 0)
						clob_count = 1;  // for amend order, if no other records r there ,
					else
						clob_count = mapUniqueId.size();
					for(int i=0;i<clob_count;i++)
					{
						amend_grouping = checkForNull(((String)hashMap.get("amend_grouping")),"");
						if(mapUniqueId.size()==0 && !amend_grouping.equals("") && amend_total_count > 0)
							grouping = amend_grouping.substring(28,amend_grouping.length()) ;
						else
							grouping = ((String)iterator.next());
						// IN048464 - Start
						order_line_num = getActionSeqNum(((String)mapOrderId.get(grouping+patient_id+encounter_id)),SQL_ORDER_ENTRY_AMEND_COMMENTS_SEQ_NUM ); // IN048464
						error_messages.append("order_line_num action_seq_num"+ order_line_num); 
						if(order_line_num == 1 && header_comments.length() == 0 ) {
							isEmpty = false;
						}
						if(isEmpty)	{ // IN048464 - End
							if(result)	//Insertion done here for header level comments,
							{
								pstmt_comments.setString(1,((String)mapOrderId.get(grouping+patient_id+encounter_id)));
								// Call a method here to get the value for the ACTION_SEQ_NUM
								// Since it is used for the New Orders,Amend/Review Orders
								//order_line_num = getActionSeqNum(((String)mapOrderId.get(grouping+patient_id+encounter_id)),SQL_ORDER_ENTRY_AMEND_COMMENTS_SEQ_NUM ); // commented for IN048464
								//error_messages.append("order_line_num action_seq_num"+ order_line_num);  // commented for IN048464
								pstmt_comments.setInt(2, order_line_num);
								pstmt_comments.setString(3, ((String)tabData.get("login_by_id")));
								pstmt_comments.setString(4, ((String)tabData.get("login_at_ws_no")));
								pstmt_comments.setString(5, ((String)tabData.get("login_facility_id")));
								pstmt_comments.setString(6, ((String)tabData.get("login_by_id")));
								pstmt_comments.setString(7, ((String)tabData.get("login_at_ws_no")));
								pstmt_comments.setString(8, ((String)tabData.get("login_facility_id")));
								int result_clob = pstmt_comments.executeUpdate();
								if(result_clob > 0) result = true; else result = false;
							} // End of if result
							// Select the clob data (column) and write it
							if(result)
							{
								pstmt_clob.setString(1,((String)mapOrderId.get(grouping+patient_id+encounter_id)));
								pstmt_clob.setInt(2,order_line_num);
								rset_clob=pstmt_clob.executeQuery();
								if(rset_clob!=null)
								{
									while(rset_clob.next())
									{
										//Web logic Conversion -- [IN037372] Start.
											//clb 			= (CLOB) rset_clob.getClob(1);
											//bw 				= new BufferedWriter(clb.getCharacterOutputStream());
											
											clb 			= (java.sql.Clob) rset_clob.getClob(1);
											bw 				= new BufferedWriter(clb.setCharacterStream(0));
										//Web logic Conversion -- [IN037372] End.
										bw.write(header_comments,0,header_comments.length());
										bw.flush();
										bw.close();
									}
								}
								
								closeResultSet( rset_clob ) ;
								clb = null; bw = null;
							}
						}	// IN048464
				} 	// end of for mapOrderId
			 } // End of for count_patient
				}
				catch(Exception e)
			{
				e.printStackTrace() ;
				error_messages.setLength(0);
				error_messages.append("EJB-Exception Details Comments"+ e.toString());
				result	= false;
			}
		} // End of if result & header_comments > 0
 		// Only if the cont_order_ind is "DR" or "CR", Call the Procedure (OR_FREQUENCY_EXPLOSION) for the Frequency Explosion
		if(result && mapUniqueId.size() > 0 ) // mapUniqueId will be null, if it is an amend order and no new order has been attached to it
		{
				try
				{
				for(int j=0;j<count_patient;j++)
				{
					// Get the patient_id , if any for Multi Patient Details
					if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
					{
						record				= (String[]) multi_patient.get(j);
						patient_id			= checkForNull(record[0],"");	 //patient_id
						encounter_id		= checkForNull(record[1],"");	//encounter_id
						episode_id			= checkForNull(record[2],"");	// episode_id
						episode_visit_num	= checkForNull(record[3],"");   // episode_visit_num
					}
					iterator = setValues.iterator();   // Get the Values
					for(int i=0;i<mapUniqueId.size();i++)  //for(int i=0;i<mapOrderId.size();i++)
					{
						if(result)
						{
							grouping = ((String)iterator.next()); // Get the grouping values
							stGroup = new StringTokenizer(grouping,"~~");//Get the grouping
							while(stGroup.hasMoreTokens())
							{
								performing_facility_id 	= stGroup.nextToken(); if(performing_facility_id.equals("^^")) performing_facility_id="";
								order_type 				= stGroup.nextToken(); if(order_type.equals("^^")) order_type="";
								priority 				= stGroup.nextToken(); if(priority.equals("^^")) priority="";
								ord_spl_appr_reqd_yn 	= stGroup.nextToken();
								specimen_type 			= stGroup.nextToken(); if(specimen_type.equals("^^")) priority="";
								nurse_collect 			= stGroup.nextToken(); if(nurse_collect.equals("^^")) nurse_collect="N";
								start_date_time 		= stGroup.nextToken(); if(start_date_time.equals("^^")) start_date_time="";
								frequency_val 			= stGroup.nextToken(); if(frequency_val.equals("^^")) frequency_val="";
								duration_value			= stGroup.nextToken(); if(duration_value.equals("^^")) duration_value="";
								performing_dept_loc_code= stGroup.nextToken(); if(performing_dept_loc_code.equals("^^")) performing_dept_loc_code="";
								splty_code=stGroup.nextToken();
								if(splty_code.equals("^^")) splty_code="";
								split_auth=stGroup.nextToken();
								if(split_auth.equals("^^")) split_auth="";
								if(!frequency_val.equals(""))
									stGroup.nextToken();
								split_grouping			= stGroup.nextToken(); if(split_grouping.equals("^^")) split_grouping="";
									//IN030298 Starts
									consent_stage			= stGroup.nextToken(); if(consent_stage.equals("^^")) consent_stage="";
									consent_form_id			= stGroup.nextToken(); if(consent_form_id.equals("^^")) consent_form_id="";
									//IN030298 ends
								//fpp_yn			= stGroup.nextToken(); if(fpp_yn.equals("^^")) fpp_yn=""; //IN0698314//10531
								//fpp_category	= stGroup.nextToken(); if(fpp_category.equals("^^")) fpp_yn="";  //IN068314//10531
							}
							stGroup = null;
							addnl_group		= ((String)mapUniqueId.get(grouping));
							// Get the order_category,freq_nature and cont_order_yn
							order_category	= addnl_group.substring(12,14); // order_category
							freq_nature		= addnl_group.substring(16,17); // freq_nature
							cont_order_yn	= addnl_group.substring(19,20); // cont_order_yn
error_messages.append("before cont_order_yn"+cont_order_yn+"freq_nature"+freq_nature+"frequency_val"+frequency_val+"duration_value"+duration_value+"order-category"+order_category);


							// Method getContinuingOrder() called to get the continuing_order_ind
							cont_order_yn 	= getContinuingOrder(checkForNull(cont_order_yn,"N"),checkForNull(freq_nature,"F"),checkForNull(frequency_val,""));
error_messages.append("Proceed cont_order_yn"+cont_order_yn);
						// (SQL_OR_ORDER_ENTRY_FREQ_EXPLOSION) Frequency Explosion Procedure called here
						
							if(cont_order_yn.equalsIgnoreCase("CR") || cont_order_yn.equalsIgnoreCase("DR"))
							{
								
error_messages.append("Proceed start_date_time"+start_date_time);
								cstmt_frequency.clearParameters();
 								cstmt_frequency.setString(1, ((String)mapOrderId.get(grouping+patient_id+encounter_id))); 	// ORDER_ID
								cstmt_frequency.setString(2, frequency_val);							// FREQUENCY_CODE
								cstmt_frequency.setString(3, duration_value);							// DURATION_VALUE
								cstmt_frequency.setString(4, start_date_time);						// START_DATE_TIME
								cstmt_frequency.setString(5, order_category); 						// ORDER_CATEGORY
								cstmt_frequency.setString(6, ((String)hashMap.get("patient_class"))); // PATIENT_CLASS
								cstmt_frequency.setString(7, cont_order_yn); 							// PASSED DR || CR
								//IN044477-commented below line
								//cstmt_frequency.setString( 16,  ((String)tabData.get("login_at_ws_no")) ) ;			//	L_LOGIN_AT_WS_NO 		IN041340
								// If it is an amend order pass as 'Y' other wise pass 'N' for New Orders
								if(((String)mapOrderId.get(grouping+patient_id+encounter_id)).equalsIgnoreCase((String)hashMap.get("amend_order_id")))
									cstmt_frequency.setString(8, "Y"); 							// Pass it 'Y' as Amend Order
								else
								cstmt_frequency.setString(8, "N"); 							// Pass it 'N' as New Order
								cstmt_frequency.setString( 9,  ((String)tabData.get("login_at_ws_no")) ) ;			//	L_LOGIN_AT_WS_NO - IN044477 added new line
								cstmt_frequency.setString( 10, (String)hashMap.get("fpp_yn"+i) ) ;	 //IN068314//10531
								cstmt_frequency.setString( 11, (String)hashMap.get("fpp_category"+i) ) ;	 //IN068314//10531
								cstmt_frequency.execute();
							} // End of if cont_order_yn

							// Call the RL (Neonatal Procedure), Order Category --> LB
							//if(result && order_category.equalsIgnoreCase("LB") && (checkForNull((String)hashMap.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")))changed on 7/10/2007 for lb_instal_yn by uma
							
							labchk=checkForNull(getmoduleRL(catalog_code,order_category,order_type,(String)tabData.get("login_facility_id")),"");
							if(result && order_category.equalsIgnoreCase("LB") && (checkForNull( labchk,"").equalsIgnoreCase("IBARL")))
							{
 								result = insertRLNeonatal(tabData, hashMap, mapSpecimenNo, order_type, performing_facility_id, order_id, SQL_OR_ORDER_ENTRY_RL_NEONATES);
  							}
							if(result && bill_yn.equals("Y"))
							{
								cstmt_billing_ext.clearParameters();
 								cstmt_billing_ext.setString(1,  ((String)tabData.get("login_facility_id"))); 	// FACILITY_ID
								cstmt_billing_ext.setString(2,  patient_id);			// PATIENT_ID
								//cstmt_billing_ext.setString(2,  ((String)hashMap.get("patient_id")));			// PATIENT_ID
								if( (((String)hashMap.get("patient_class")).equalsIgnoreCase("IP")) || (((String)hashMap.get("patient_class")).equalsIgnoreCase("EA")) )
								{
									cstmt_billing_ext.setString(3, "I");										// EPISODE_TYPE
								}
								else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("DC"))
								{
									cstmt_billing_ext.setString(3, "D");										// EPISODE_TYPE
								}
								else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("EM"))
								{
									cstmt_billing_ext.setString(3, "E");										// EPISODE_TYP
								}
								else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("OP"))
								{
									cstmt_billing_ext.setString(3, "O");										// EPISODE_TYPE
								}
								else
								{
									cstmt_billing_ext.setString(3, "R");										// EPISODE_TYPE\
								}
								//if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("XT"))
								
								cstmt_billing_ext.setString(4,  checkForNull(episode_id,"0"));	// EPISODE_ID
								cstmt_billing_ext.setString(5,  checkForNull(episode_visit_num,"0")); // VISIT_NUM
								cstmt_billing_ext.setString(6,  ((String)mapOrderId.get(grouping+patient_id+encounter_id))); 	// ORDER_ID
								cstmt_billing_ext.setString(7,  "OR"); 		// SUBS_MODULE_ID
								cstmt_billing_ext.setString(8,  null); 	// SUBS_REGN_NUM
								cstmt_billing_ext.setString(9,  ((String)tabData.get("login_by_id"))); 		// USER
								cstmt_billing_ext.setString(10, ((String)tabData.get("login_at_ws_no"))); 	// WS_NO
								cstmt_billing_ext.registerOutParameter( 11,  Types.VARCHAR ) ;
								cstmt_billing_ext.registerOutParameter( 12,  Types.VARCHAR ) ;
								cstmt_billing_ext.registerOutParameter( 13,  Types.VARCHAR ) ;
								cstmt_billing_ext.execute();
								err_code 		= checkForNull(cstmt_billing_ext.getString(11),"");  // ERR_CODE
								message_id 		= checkForNull(cstmt_billing_ext.getString(12),"");  // SYS_MESSAGE_ID
								err_message		= checkForNull(cstmt_billing_ext.getString(13),"");  // ERROR_TEXT
								
								if(!err_code.equals("") && !err_code.equals("10") && !err_message.equals(""))
								{
									result 			= false;bill_result = false; 		// Any Error is there Come out Immediately
									error_messages.setLength(0);
									messages.setLength(0);
									messages.append( err_message ) ;
									error_messages.append(err_message);
								} // End of if !err_message
								else if(!message_id.equals("") )  //Query from the sm_message and display the message
								{
									result 			= false;bill_result = false;		// Any Error is there Come out Immediately
									error_messages.setLength(0);
									messages.setLength(0);
  									// Query from the database for the message id and display the Message
									err_message = getErrMessage(message_id, SQL_OR_ORDER_ENTRY_BILL_MESSAGE);
									messages.append(checkForNull(err_message, "" ));
									error_messages.append(checkForNull(err_message, "" ));
								}
 							} // End of if result &  bill_yn = "Y"
						} // End of if result
					} // End of for mapOrderId
			    } // End of  count_patient
				}
				catch(Exception ee)
			{
				ee.printStackTrace() ;
				error_messages.setLength(0);
				error_messages.append("EJB-Exception Procedure Called"+ee.toString());
				result = false;
			}
		} // End of if result
		if(result && order_set_bill_yn.equals("Y"))
		{
			try
			{
				String row = "0";
				int order_line_number = 1;
				if(amend_order_set_bill_yn.equals("Y"))
				{
					/*Modified by Uma on 1/18/2010 for IN017420 && IN018640 for cont_order_yn and order set amend billing*/
					//billing_line_result	= callBillingLineLevel(tabData, hashMap,"ORDER_SET_BILLING_AMEND" , SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE,row,checkForNull((String)hashMap.get("amend_order_set_id"),""), patient_id,encounter_id,order_line_number, care_set_count,SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE,SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS,SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS,SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE,cont_order_yn);//11289
					billing_line_result	= callBillingLineLevel(tabData, hashMap,"ORDER_SET_BILLING_AMEND" , SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE,row,checkForNull((String)hashMap.get("order_set_id"),""), patient_id,encounter_id,order_line_number, care_set_count,SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE,SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS,SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS,SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE,cont_order_yn);//11289
					/*Ends Here*/
				}
				else
				{
					/*Modified by Uma on 1/18/2010 for IN017420 for cont_order_yn*/
					billing_line_result	= callBillingLineLevel(tabData, hashMap, "ORDER_SET_BILLING" , SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE,  row ,(String)mapOrderSet.get(patient_id), patient_id,encounter_id,  order_line_number, care_set_count,SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE,SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS,SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS,SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE,cont_order_yn);
					/*Ends Here*/
				}

				charge_type_code	= checkForNull(billing_line_result[0],"");	//charge_type_code
				err_message			= checkForNull(billing_line_result[1],""); //error_message
				
				if(! err_message.equals(""))
				{
					result 			= false;						// Any Error is there Come out Immediately
					error_messages.setLength(0);
					messages.setLength(0);
					messages.append( err_message ) ;
					error_messages.append(err_message);
				}
				else
				{
					cstmt_billing_ext.clearParameters();
					cstmt_billing_ext.setString(1,  ((String)tabData.get("login_facility_id"))); 	// FACILITY_ID
					cstmt_billing_ext.setString(2,  patient_id);			// PATIENT_ID
					//cstmt_billing_ext.setString(2,  ((String)hashMap.get("patient_id")));			// PATIENT_ID
					if( (((String)hashMap.get("patient_class")).equalsIgnoreCase("IP")) || (((String)hashMap.get("patient_class")).equalsIgnoreCase("EA")) )
					{
						cstmt_billing_ext.setString(3, "I");										// EPISODE_TYPE
					}
					else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("DC"))
					{
						cstmt_billing_ext.setString(3, "D");										// EPISODE_TYPE
					}
					else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("EM"))
					{
						cstmt_billing_ext.setString(3, "E");										// EPISODE_TYPE
					}
					else if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("OP"))
					{
						cstmt_billing_ext.setString(3, "O");										// EPISODE_TYPE
					}
					else
					{
						cstmt_billing_ext.setString(3, "R");										// EPISODE_TYPE
					}
					//if( ((String)hashMap.get("patient_class")).equalsIgnoreCase("XT"))
					
					cstmt_billing_ext.setString(4,  checkForNull(episode_id,"0"));	// EPISODE_ID
					cstmt_billing_ext.setString(5,  checkForNull(episode_visit_num,"0")); // VISIT_NUM
					cstmt_billing_ext.setString(6,  ((String)mapOrderSet.get(patient_id))); 	// ORDER_ID
					cstmt_billing_ext.setString(7,  "OR"); 		// SUBS_MODULE_ID
					cstmt_billing_ext.setString(8,  null); 	// SUBS_REGN_NUM
					cstmt_billing_ext.setString(9,  ((String)tabData.get("login_by_id"))); 		// USER
					cstmt_billing_ext.setString(10, ((String)tabData.get("login_at_ws_no"))); 	// WS_NO
					cstmt_billing_ext.registerOutParameter( 11,  Types.VARCHAR ) ;
					cstmt_billing_ext.registerOutParameter( 12,  Types.VARCHAR ) ;
					cstmt_billing_ext.registerOutParameter( 13,  Types.VARCHAR ) ;
					cstmt_billing_ext.execute();
					err_code 		= checkForNull(cstmt_billing_ext.getString(11),"");  // ERR_CODE
					message_id 		= checkForNull(cstmt_billing_ext.getString(12),"");  // SYS_MESSAGE_ID
					err_message		= checkForNull(cstmt_billing_ext.getString(13),"");  // ERROR_TEXT
					
					if(!err_code.equals("") && !err_code.equals("10") && !err_message.equals(""))
					{
						result 			= false;bill_result = false; 		// Any Error is there Come out Immediately
						error_messages.setLength(0);
						messages.setLength(0);
						messages.append( err_message ) ;
						error_messages.append(err_message);
					} // End of if !err_message
					else if(!message_id.equals("") )  //Query from the sm_message and display the message
					{
						result 			= false;bill_result = false;		// Any Error is there Come out Immediately
						error_messages.setLength(0);
						messages.setLength(0);
						// Query from the database for the message id and display the Message
						err_message = getErrMessage(message_id, SQL_OR_ORDER_ENTRY_BILL_MESSAGE);
						messages.append(checkForNull(err_message, "" ));
						error_messages.append(checkForNull(err_message, "" ));
					}
					if(result)
					{
						orderable_result 	= callBillingLineLevelOrderableBilled(tabData, hashMap, SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED, SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE, SQL_OR_ORDER_ENTRY_BILL_MESSAGE, (String)mapOrderSet.get(patient_id),  order_line_number, Integer.parseInt(row) );
						ord_billed_yn		= checkForNull(orderable_result[0],"N");
						err_message			= checkForNull(orderable_result[1],"");
						
						if(! err_message.equals(""))
						{
							result			= false;
							error_messages.setLength(0);
							messages.setLength(0);
							messages.append( err_message ) ;
							error_messages.append(err_message);	
						}
						if(result && ord_billed_yn.equals("Y"))  //only if it is'Y' other wise it will be 'N' already
						{
							result 		= updateBilling(tabData, ord_billed_yn, (String)mapOrderSet.get(patient_id), order_line_number, SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION );		
						}
						
					}
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				result				= false;
				error_messages.setLength(0);
				error_messages.append("Exception Billing Details"+ ex.toString());
			}

		}

		// Billing Functionality, to update the or_order_line (BILLED_YN column) with the value got from the procedure
		// Functionality As required by the Billing Team
		if(count >0 && result && bill_yn.equals("Y"))
 		{
				try
				{
					for(int j=0;j<count_patient;j++)
					{
						// Get the patient_id , if any for Multi Patient Details
						if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
						{
							record			= (String[]) multi_patient.get(j);
							patient_id		= checkForNull(record[0],""); //patient_id
							encounter_id	= checkForNull(record[1],""); //encounter_id
						}
						grouping_seq_no = 0;  // Before Initialize
						for(int i=0;i<count;i++)
						{	
							ord_billed_yn	= "N";err_message	= ""; // Reinitialize
							// Method called to get the continuing_order_ind for Line Level
							cont_order_yn 	= getContinuingOrder(checkForNull((String)hashMap.get("cont_order_yn"+i),"N"),checkForNull((String)hashMap.get("freq_nature"+i),"F"),checkForNull((String)hashMap.get("frequency_val"+i),""));

							if( (!(checkForNull((String)hashMap.get("rd_install_yn"),"N").equals("Y") && checkForNull((String)hashMap.get("order_category"+i),"CS").equals("RD")) )  && checkForNull((String)hashMap.get("appt_reqd_yn"+i),"N").equals("Y")) 
							{
								grouping_seq_no++;  // Increase the counter, so that if appt_reqd_yn is there will go as an different order
								split_grouping	= splitGroupingOrders(grouping_seq_no); // call a method to get the split_grouping like "000" or "001" etc
							} 
							else if(checkForNull((String)hashMap.get("chart_result_type"+i),"D").equals("P")) {
								grouping_seq_no++; // Increase the counter,(For Treatment if procedure is there(P)) so that if chart_result_type is there will go as an different order
								split_grouping	= splitGroupingOrders(grouping_seq_no); // call a method to get the split_grouping like "000" or "001" etc
							} 
							else
								split_grouping	= "000";
							String ord_authorise = "";
							if((((String)hashMap.get("ord_auth_reqd_yn"+i)).equals("Y"))&&(((String)hashMap.get("authorised_yn"+i)).equals("N")))
							{
								ord_authorise = "Y";
							}
							else
							{
								ord_authorise = "N";
							}
							// Form the grouping as was done in the bean.(combination)
						 	order_type		= groupingOrderType((String)hashMap.get("order_category"+i), (String)hashMap.get("primary_order_type"), (String)hashMap.get("order_type"+i));
							grouping 		= (checkForNull((String)hashMap.get("performing_facility_id"+i),"^^"))+"~~"+order_type+"~~"+checkForNull(((String)hashMap.get("priority"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("ord_spl_appr_reqd_yn"+i)),"N")+"~~"+checkForNull(((String)hashMap.get("specimen_type"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("nurse_collect"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("start_date_time"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("frequency_val"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("duration_value"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("performing_dept_loc_code"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("splty_code"+i)),"^^")+"~~"+checkForNull(ord_authorise,"^^")+"~~"+split_grouping;
							
							//IN030298 starts
							if(((String)hashMap.get("ord_consent_reqd_yn"+i)).equalsIgnoreCase("Y"))
							{
								//grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"consent_stage"+i);
								grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"^^");//KDAH-LIVE
								grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_form_id"+i),"consent_form_id"+i);
							}
							else
							{
								//grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"^^");
								//grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_form_id"+i),"^^");
								grouping = grouping +"~~^^~~^^";//emg for medicity - Chowminya //added for IN041154
							}
							//IN030298 ends
							error_messages.append("second grouping"+grouping);
							order_id 	= ((String)mapOrderId.get(grouping+patient_id+encounter_id));	//For the combination done get the order id stored in mapOrderId hashmap
							// For Billing Related , Call a procedure to execute each time
							if((checkForNull(((String)hashMap.get("billing_call_yn"+i)),"N")).equals("Y") && ( cont_order_yn.equals("DO") || cont_order_yn.equals("CO") ) && result)
							{   // Not called for Frequency Explosion
								// Get the line no for the order_id and then call the billing procedure and update it to the or_order_line using the line no
								pstmt_billing_line.clearParameters();
								pstmt_billing_line.setString(1, order_id);
								rset_clob	= pstmt_billing_line.executeQuery();
								if(rset_clob!=null)
								{
									while(rset_clob.next())
									{
										if(result)
										{
											order_line_num		= rset_clob.getInt(1);
											// Call the billing procedure to get the orderable has been billed or not
											// Below method will return an array with error message if it is there and ord_billed_yn
											orderable_result 	= callBillingLineLevelOrderableBilled(tabData, hashMap, SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED, SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE, SQL_OR_ORDER_ENTRY_BILL_MESSAGE, order_id,  order_line_num, i);
											ord_billed_yn		= checkForNull(orderable_result[0],"N");
											err_message			= checkForNull(orderable_result[1],"");
										
											if(! err_message.equals(""))
											{
												result			= false;
												error_messages.setLength(0);
												messages.setLength(0);
 												messages.append( err_message ) ;
												error_messages.append(err_message);
											}
											if(result && ord_billed_yn.equals("Y"))  //only if it is'Y' other wise it will be 'N' already
											{
												result 		= updateBilling(tabData, ord_billed_yn, order_id, order_line_num, SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION );
											}
										}// End of if result
									} // End of while rset_clob
								} // End of if rset_clob
								closeResultSet( rset_clob ) ;
							} // End of billing_call_yn & result
						} // End of for count loop
					} // End of for count_patient
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
					error_messages.append("Exception Billing Final"+ e.toString());
					result	= false;
				}
		} // End of if count>0 && result && bill_yn
		/******************/


		/* AMEND ORDERS
		 * Deletion from the table, if required if the order_id has changed due to the changes
		 * This condition will arise, when the order has been amended, i.e the start_date_time
		 * or the frequency or the duration_code or the performing_location has been changed, and now
		 * it will go as an New Order , that time that particular order_line_num has to be deleted from
		 * the or_order_line table and if no other line no for that order_id in the line table,
		 * then in the header table or_order that particular order_id has to be deleted.
		 */
		 if(count >0 && result) // It is going as New Order
		 {			
		
			 //result = deletionAmend(hashMap, count , SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_DELETION, SQL_ORDER_ENTRY_AMEND_OR_ORDER_COUNT_SELECT, SQL_ORDER_ENTRY_AMEND_OR_ORDER_DELETION,        SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_DELETION,SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_DELETION,SQL_OR_CONSENT_DRAFT_AMEND_DELETE,(String)tabData.get("login_by_id"),(String)tabData.get("login_at_ws_no"),(String)tabData.get("login_facility_id"),SQL_OR_BL_WITHOUT_ORDER_CATALOG);//IN071315
			// result = deletionAmend(hashMap, count , SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_DELETION, SQL_ORDER_ENTRY_AMEND_OR_ORDER_COUNT_SELECT, SQL_ORDER_ENTRY_AMEND_OR_ORDER_DELETION,        SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_DELETION,SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_DELETION,SQL_OR_CONSENT_DRAFT_AMEND_DELETE,(String)tabData.get("login_by_id"),(String)tabData.get("login_at_ws_no"),(String)tabData.get("login_facility_id"),SQL_OR_BL_WITHOUT_ORDER_CATALOG,(String)tabData.get("p_called_from_ca"));//IN071315
			 result = deletionAmend(hashMap, count , SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_DELETION, SQL_ORDER_ENTRY_AMEND_OR_ORDER_COUNT_SELECT, SQL_ORDER_ENTRY_AMEND_OR_ORDER_DELETION,        SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_DELETION,SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_DELETION,SQL_OR_CONSENT_DRAFT_AMEND_DELETE,(String)tabData.get("login_by_id"),(String)tabData.get("login_at_ws_no"),(String)tabData.get("login_facility_id"),SQL_OR_BL_WITHOUT_ORDER_CATALOG,(String)tabData.get("p_called_from_ca"),order_id,order_line_num);//IN071315////12123
			 if(!result)
			{
				messages.append(error_messages.toString());
			
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", messages.toString() ) ;
				map.put( "flag", "" ) ;
				result = false;
				return map;
				
			}
		 }
		 
			error_messages.append("Final result"+result);
		
			if(print_report_count>0)
			{
				map.put("print_report_values",print_report_values);
			}
			if(specimen_count > 0 ) 
			{
				print_specimen_values.put("order_entry", "OrderEntry");
				print_specimen_values.put("total_recs", String.valueOf(specimen_count));
			}

			//IN065942, starts
			if(prn_reg_lab_cnt > 0)
			{
				prn_reg_lab_values.put("prn_lab_cnt",String.valueOf(prn_reg_lab_cnt));
				prn_reg_lab_values.put("facility_id",(String)tabData.get("login_facility_id"));
				prn_reg_lab_values.put("module_id","OR");
				prn_reg_lab_values.put("pract_type",(String)hashMap.get("pract_type"));
			}
			//IN065942, ends
			//Put for the oabook_appt
			if(appt_reqd_count > 0 )
			   oa_bookappt_values.put("total_records", String.valueOf(appt_reqd_count+1)); // For On Line Printing
				//oa_bookappt_values.put("order_status_code"+appt_reqd_count, checkForNull(((String)hashMap.get("order_status_code"+i))));//changed
				//Email Changes Starts by Uma 2/6/2009
				if(email_yn.equalsIgnoreCase("Y"))
				{
					e_report_id="EMPATINS";
					e_module_id="OR";
					String result_data="";
					displayData.append(displayDetail.replace("##ORDERID##",OrderID.toString()));
					pstmt_email=connection.prepareStatement(SQL_OR_ORDER_ENTRY_EMAIL_PWD);
					pstmt_email.setString(1,"");
					pstmt_email.setString(2,e_report_id);
					pstmt_email.setString(3,patient_id);
					resultSet_email=pstmt_email.executeQuery();

					if(resultSet_email!=null)
					{
						while(resultSet_email.next())
						{										 
							Patient_Name=resultSet_email.getString("pat_name")==null?"":resultSet_email.getString("pat_name");
							Enc_pwd=resultSet_email.getString("enc_pwd");										Mail_Id=resultSet_email.getString("mailid")==null?"":resultSet_email.getString("mailid");										Mail_Subject=resultSet_email.getString("mailsubject")==null?"":resultSet_email.getString("mailsubject");
						}
					}
					closeStatement(pstmt_email);
					closeResultSet(resultSet_email);
					String mail_content=SQL_OR_ORDER_ENTRY_EMAIL_DISPLAY_BODY_DATA_DETAILS;
					PreparedStatement cstmt_mail = connection.prepareStatement(mail_content);
					cstmt_mail.setString(1,	e_module_id);
					cstmt_mail.setString(2,	e_report_id);
					cstmt_mail.setString(3,	"P");
					cstmt_mail.setString(4,	patient_id);
					cstmt_mail.setString(5,	encounter_id);
					cstmt_mail.setString(6,	(String)tabData.get("login_facility_id"));
					cstmt_mail.setString(7,	"en");
					cstmt_mail.setString(8,	null);
					cstmt_mail.setString(9,	null);
					cstmt_mail.setString(10,null);
					ResultSet mail_rs=cstmt_mail.executeQuery() ;
					while(mail_rs.next() )
					{

						Clob script_clob_data = mail_rs.getClob("editor_content");
						if(script_clob_data!=null && script_clob_data.length() > 0)
							result_data = script_clob_data.getSubString(1,( (int)script_clob_data.length() ));
					}
					closeStatement(cstmt_mail);
					closeResultSet(mail_rs);

					if(!Mail_Id.equals(""))
					{
						if(Patient_Name.indexOf("\"") != -1) Patient_Name.replaceAll("\""," ");
						p_file_name = e_module_id + "-" + e_report_id + "-" + patient_id;
						csFaxMail = (oracle.jdbc.OracleCallableStatement) connection.prepareCall("{"+SQL_OR_ORDER_ENTRY_EMAIL+"}");
						csFaxMail.setString(1,((String)tabData.get("login_facility_id")));
						csFaxMail.setString(2,e_module_id);
						csFaxMail.setString(3,e_report_id);
						csFaxMail.setString(4,"@");
						csFaxMail.setString(5,"@");
						csFaxMail.setString(6,Mail_Id);
						csFaxMail.setString(7,null);
						csFaxMail.setString(8,null);
						csFaxMail.setString(9,Mail_Subject);
						csFaxMail.setString(10,null);
						csFaxMail.setString(11,result_data);
						csFaxMail.setString(12,null);
						csFaxMail.setString(13,"N");
						csFaxMail.setString(14,null);
						csFaxMail.setString(15,null);
						csFaxMail.setString(16,null);
						csFaxMail.setString(17,appl_user_name);
						csFaxMail.setString(18,null);
						csFaxMail.setString(19,null);
						csFaxMail.setString(20,"M");
						csFaxMail.setString(21,p_file_name);
						csFaxMail.setString(22,(String)tabData.get("login_by_id"));
						csFaxMail.setString(23,(String)tabData.get("login_at_ws_no"));
						csFaxMail.setString(24,null);
						csFaxMail.registerOutParameter(25,Types.VARCHAR);
						csFaxMail.setString(26,"H");
						csFaxMail.setStringForClob(27,displayData.toString());
						csFaxMail.setString(28,null);
						csFaxMail.setString(29,null);
						csFaxMail.setString(30,"A");
						csFaxMail.setString(31,Enc_pwd);
						csFaxMail.setString(32,patient_id);
						csFaxMail.setString(33,null);
						csFaxMail.execute();
						error = csFaxMail.getString(25);
					}

			}
			//Email Changes Ends by Uma 2/6/2009
			//For External Orders and OP Orders Billing Settlement Added by Uma 3/20/2009
			if(result && ((((String)hashMap.get("patient_class")).equalsIgnoreCase("XT")) || ((((String)hashMap.get("patient_class")).equalsIgnoreCase("OP")))||((((String)hashMap.get("patient_class")).equalsIgnoreCase("EM")))) &&((tabData.get("categorySize").toString()).equalsIgnoreCase("1")))
			{
				pstmt7 = connection.prepareStatement("select nvl(INV_STLMT_SCR_EXT_ORD_YN,'N') inv_stlmt_scr_ext_ord_yn,nvl(INV_STLMT_SCR_OP_ORD_YN,'N') inv_stlmt_scr_op_ord_yn,nvl(INV_STLMT_SCR_EM_ORD_YN,'N') inv_stlmt_scr_em_ord_yn,nvl(settlement_scope,'B') settlement_scope from or_param_by_facility where operating_facility_id=?");
				pstmt7.setString(1, ((String)tabData.get("login_facility_id")));
				resultSet = pstmt7.executeQuery();

				if (resultSet.next()) 
				{
					inv_stlmt_scr_ext_ord_yn	= resultSet.getString("inv_stlmt_scr_ext_ord_yn");
					inv_stlmt_scr_op_ord_yn		= resultSet.getString("inv_stlmt_scr_op_ord_yn");
					inv_stlmt_scr_em_ord_yn		= resultSet.getString("inv_stlmt_scr_em_ord_yn");
					settlement_scope		    = resultSet.getString("settlement_scope");
				}
				
				closeStatement(pstmt7) ;
				closeResultSet(resultSet) ;
				String invokeFunction = (String)tabData.get("invokeFunction");
				if(invokeFunction==null)
					invokeFunction="";
				if((settlement_scope.equalsIgnoreCase("B"))||((settlement_scope.equalsIgnoreCase("O"))&&(invokeFunction.equalsIgnoreCase("PLACE_ORDER")))||((settlement_scope.equalsIgnoreCase("I"))&&(!(invokeFunction.equalsIgnoreCase("PLACE_ORDER")))))
				{
					invoke_settlement = true;
				}
				else
				{
					invoke_settlement = false;
				}

				String patient_class = (String)hashMap.get("patient_class");
				
				if(((inv_stlmt_scr_ext_ord_yn.equalsIgnoreCase("Y"))&&(patient_class.equalsIgnoreCase("XT"))) || ((inv_stlmt_scr_op_ord_yn.equalsIgnoreCase("Y"))&&(patient_class.equalsIgnoreCase("OP")) &&(invoke_settlement)) || ((inv_stlmt_scr_em_ord_yn.equalsIgnoreCase("Y"))&&(patient_class.equalsIgnoreCase("EM")) && (invoke_settlement)))
				{
					String stlmt_episode_type="";

					if(patient_class.equalsIgnoreCase("OP"))
					{
						stlmt_episode_type="O";
					}

					if(patient_class.equalsIgnoreCase("XT"))
					{
						stlmt_episode_type="R";
					}

					if(patient_class.equalsIgnoreCase("EM"))
					{
						stlmt_episode_type="E";
					}

					try
					{
						cstmt_valid_user = connection.prepareCall("{ "+SQL_OR_BL_USER_CHECK_FOR_CASH_COUNTER+" }");  
						cstmt_valid_user.setString(1,((String)tabData.get("login_facility_id")));
						cstmt_valid_user.setString(2,checkForNull(stlmt_episode_type,""));
						cstmt_valid_user.setString(3,(String)tabData.get("login_by_id"));
						cstmt_valid_user.setString(4,(String)tabData.get("login_at_ws_no"));
						cstmt_valid_user.registerOutParameter(5, Types.VARCHAR ); //"P_CASH_COUNTER_CODE"
						cstmt_valid_user.registerOutParameter(6, Types.VARCHAR ); //"P_CASHIER_SHIFT"
						cstmt_valid_user.registerOutParameter(7, Types.VARCHAR ); //"P_SYS_MESSAGE_ID"				
						cstmt_valid_user.execute();
						billing_valid_user = checkForNull((String)cstmt_valid_user.getString(7),"");
						/*if(billing_valid_user.indexOf("BL1023")!=-1)
						{
							connection.rollback();
							messages.append(billing_valid_user) ;
							map.put( "result", new Boolean( false ) ) ;
							result = false;
						}*/
					}
					catch (Exception e )
					{
						e.printStackTrace();
					}
					finally
					{
						closeStatement(cstmt_valid_user);
					}
				   
					if((((String)tabData.get("bill_interface_yn")).equalsIgnoreCase("Y"))&&(((String)tabData.get("discount_allow_yn")).equalsIgnoreCase("N"))&&(billing_valid_user.indexOf("BL1023")==-1))
					{
						//String msg="";
						
						try
						{
							cstmt_stlmt		= connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_EXTERNAL_ORDER_OR_GET_BILL_DOC_TYPE+" }"); 
							cstmt_stlmt.setString(1, ((String)tabData.get("login_facility_id")));
							cstmt_stlmt.setString(2, checkForNull(stlmt_episode_type,""));
							cstmt_stlmt.setString(3, episode_id);
							cstmt_stlmt.setString(4, episode_visit_num);
							cstmt_stlmt.setString(5, (String)tabData.get("login_by_id"));
							cstmt_stlmt.setString(6, (String)tabData.get("login_at_ws_no"));
							cstmt_stlmt.setString(7, patient_id);
							cstmt_stlmt.registerOutParameter(8, Types.VARCHAR ); //"BILL_DOC_TYPE"
							cstmt_stlmt.registerOutParameter(9, Types.VARCHAR ); //"BILL_DOC_NUM"
							cstmt_stlmt.registerOutParameter(10, Types.VARCHAR ); //"BILL_GROUP_ID"
							cstmt_stlmt.registerOutParameter(11, Types.VARCHAR ); //"SYS_MESSAGE_ID"
							cstmt_stlmt.registerOutParameter(12, Types.VARCHAR ); //"ERROR_CODE"//15770
							cstmt_stlmt.registerOutParameter(13, Types.VARCHAR ); //"ERROR_TEXT"//15770
							cstmt_stlmt.execute() ;
							external_order_stlmt_bill_data.put("l_bill_doc_type" , checkForNull((String)cstmt_stlmt.getString(8),""));
							external_order_stlmt_bill_data.put("l_bill_doc_num" , checkForNull((String)cstmt_stlmt.getString(9),""));
							external_order_stlmt_bill_data.put("v_blng_group_id" , checkForNull((String)cstmt_stlmt.getString(10),""));
							external_order_stlmt_bill_data.put("error_id" , checkForNull((String)cstmt_stlmt.getString(11),""));
							external_order_stlmt_bill_data.put("error_code" , checkForNull((String)cstmt_stlmt.getString(12),""));//15770
							external_order_stlmt_bill_data.put("error_text" , checkForNull((String)cstmt_stlmt.getString(13),""));//15770
							
							//15770 Starts
							if((checkForNull((String)external_order_stlmt_bill_data.get("error_code"),""))!="" || (checkForNull((String)external_order_stlmt_bill_data.get("error_text"),""))!="")
							{
								error_messages.append(" OR_GET_BILL_DOC_TYPE Procedure Failed");
								messages.append((String)external_order_stlmt_bill_data.get("error_text"));//IN066436
								result=false;
							}
							//15770 Ends
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
						finally
						{
							closeStatement(cstmt_stlmt);
						}
					}
				}
			}
			//End of External Orders Billing Settlement  Added by Uma 3/20/2009
			if ( result)
			{
				/*Added by Uma on 12/22/2009 for IN015411 CRF 560*/
				if(amend_rep_group_ref.equals(""))
					updateRepInfo(group_ref_trn);
				/*Ends Here*/
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
//				map.put( "print_values",print_values) ; // For On Line Printing
				map.put( "print_specimen_values",print_specimen_values) ; // For On Line Printing(Specimen)
				map.put( "oa_bookappt_values",oa_bookappt_values) ; // For OA Booking Appointment
				map.put( "external_order_stlmt_bill_data",external_order_stlmt_bill_data) ; // For External Orders Billing Settlement Details  Added by Uma 3/20/2009
				map.put( "trn_group_ref",group_ref_trn) ; 
				map.put( "prn_lab_values",prn_reg_lab_values);//IN065942

				messages.append( "RECORD_INSERTED" ) ;
			}
			else
			{
				connection.rollback();
				if (prior_orders_err_msg!=null && !prior_orders_err_msg.equals("")) 
				{
				    messages.append(prior_orders_err_msg);
				}
                if(bill_result)
				{
					//if(!(messages.startsWith("APP-BL1294")))
					//{
 					//messages.append( " Insert Failed..." ) ;
					//messages.append(error_messages);
					//}
				}
				error_messages.append(" Insert Failed");
				messages.append(l_spec_err_msg);//IN066436
			}
		   }
		   catch( Exception e )
		   {
			   e.printStackTrace() ;
			   messages.append( e.getMessage()) ;
			   error_messages.append(e.getMessage());
			try
			{
					  connection.rollback();  //context.setRollbackOnly();
			}
			catch(Exception ex)
			{
						ex.printStackTrace();
				  }
			} 
			finally
			{
	            	try 
					{
						closeStatement( pstmt ) ;
						closeStatement( pstmt_detail ) ;
						closeStatement( pstmt_comments ) ;
						closeStatement( pstmt_clob ) ;
						closeStatement( pstmt_sy_report ) ;
						closeStatement( pstmt_billing_line ) ;
						closeStatement( pstmt_multi ) ;
						closeStatement( pstmt_order_status ) ;

						closeStatement( cstmt);
						closeStatement( cstmt_priorOrders );
						closeStatement( cstmt_frequency );
						closeStatement( cstmt_billing_ext );
						closeStatement( cstmt_billing_extl );
						closeStatement( cstmt_auditLog );
						closeStatement( auditSeqPStmt );//Issue while running check style for IN065295
						closeStatement( auditReasonPStmt );//Issue while running check style for IN065295

						closeResultSet( rset_clob ) ;
						closeResultSet( auditSeqRs ) ;//Issue while running check style for IN065295

						if(connection != null) 
						{
							closeConnection( connection,(Properties)tabData.get( "properties" ) );
						}
        			} 
					catch ( Exception fe ) 
					{
				    	fe.printStackTrace() ;
			        }
	    	    }
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", error_messages.toString() ) ;
		map.put( "flag", "" ) ;
		

		//********************* Nullifying the objects ************************//
//		print_values		  = null;			// Nullifying the objects
	//	if(hashMap!=null)		hashMap.clear(); //do not clear, this is passed from bean, if it is cleared here, then in the bean it will get cleared and when removing the catalogs it will be a problem and will affect the refreshing part
		if(mapUniqueId!=null)	{ mapUniqueId.clear(); mapUniqueId			  = null; }
		if(mapOrderId!=null)	{ mapOrderId.clear();  mapOrderId 			  = null; }
		if(mapOrderStatus!=null) {	mapOrderStatus.clear(); mapOrderStatus		  = null; }
		if(mapOrderFormatHdr!=null)	{ mapOrderFormatHdr.clear(); mapOrderFormatHdr	  = null; }
		if(mapScheduleDtl!=null)	{ mapScheduleDtl.clear(); mapScheduleDtl		  = null; }
		if(mapSpecimenNo!=null)	{ mapSpecimenNo.clear(); mapSpecimenNo		  = null; }
		if(mapOrderSet!=null)	{ mapOrderSet.clear(); mapOrderSet 		  = null; }
		if(mapOrderFormatDtl!=null)	{ mapOrderFormatDtl.clear(); mapOrderFormatDtl	  = null; }
		if(orderFormatHdr!=null)	{ orderFormatHdr.clear(); orderFormatHdr		  = null; }
		if(mapcollectStage!=null)	{ mapcollectStage.clear(); mapcollectStage		  = null; }
		if(multi_patient!=null)	{ multi_patient.clear(); multi_patient		  = null; }
		if(sqlMap!=null)	sqlMap.clear();
		if(tabData!=null)	tabData.clear();
 		orderable_result	  = null;		ph_calculations		  = null;
		order_set_values	  = null; 		billing_line_result	  = null;
		record		  		  = null;
		stGroup				  = null;	 	clb		  			  = null;
		hashMap				  = null;		messages			  = null;
		/* Global Variables nullifying **/
		error_messages		  = null;
		oa_bookappt_values	  = null;	print_specimen_values 	=  null;
  		/* Till Here Global Variables nullifying **/
 		//********************* Nullifying the objects Till Here******************//
		//map.put( "order_id", order_id) ;
		
		return map ;
	} // end of insert

//IN071260 Starts
private boolean insertDrugInteractionLB(HashMap tabData, HashMap hashMap, String order_id, int order_line_num, int row_value,String catalog_code) {//IN072654
	PreparedStatement pstmt = null;
	boolean status 			= false;
	//String	catalog_code =checkForNull(((String)hashMap.get("catalog_code"+row_value)),"");//IN072654 
	ArrayList<OrderDrugInteractionVO> drugs  = null;
	OrderDrugInteractionVO drugsDtls =null;
	boolean isExists = false;//IN072654
	HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = (HashMap<String, ArrayList<OrderDrugInteractionVO>>) tabData.get("drugInterDetailsLB");
	try
	{
		isExists = checkDrugInterExists(order_id,order_line_num,catalog_code);//IN072654
	if(null!=interdrugDtls)
	{
			drugs = interdrugDtls.get(catalog_code);
			//IN072654
			if(isExists)
			{
				pstmt					 	= connection.prepareStatement(" UPDATE or_order_drug_interaction SET OVERRIDE_REASON = ? WHERE ORDER_ID = ? and ORDER_LINE_NUM = ?");
				if(null!=drugs)
				{
					for(int i=0;i<drugs.size();i++)
					{
						drugsDtls = drugs.get(i);
						if(!"Y".equals(drugsDtls.getDrugRestrictYN()))
						{
							pstmt.setString(1,drugsDtls.getOverrideRemarks());
							pstmt.setString(2,order_id );
							pstmt.setString(3,String.valueOf(order_line_num ));

							pstmt.addBatch();
						}
					}
				
				}
			}
			else{//IN072654
				pstmt					 	= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_DRUG_INTERACTION"));
				if(null!=drugs)
				{
					for(int i=0;i<drugs.size();i++)
					{
						drugsDtls = drugs.get(i);
						if(!"Y".equals(drugsDtls.getDrugRestrictYN()))
						{
							pstmt.setString(1,order_id );
							pstmt.setString(2,String.valueOf(order_line_num ));
							pstmt.setString(3,catalog_code );
							pstmt.setString(4,drugsDtls.getDrugCode() );
							pstmt.setString(5,"OR" );
							pstmt.setString(6,drugsDtls.getDrugRestrictYN() );
							pstmt.setString(7,drugsDtls.getOverrideRemarks() );
							pstmt.setString(8,((String)tabData.get("login_by_id")) );
							pstmt.setString(9,((String)tabData.get("login_at_ws_no")) );
							pstmt.setString(10,((String)tabData.get("login_facility_id")) );
							pstmt.setString(11,((String)tabData.get("login_by_id")) );
							pstmt.setString(12,((String)tabData.get("login_at_ws_no")) );
							pstmt.setString(13,((String)tabData.get("login_facility_id")) );
							pstmt.addBatch();
						}
					}
				
				}
			}
	
		int result_val[] = pstmt.executeBatch();
		for (int i=0;i<result_val.length ;i++ )
		{
			if(result_val[i] != -2  && result_val[i] < 0)
			{
				status=false;
				break;
			}
			else{//IN072627
				status=true;
				connection.commit();
			}//IN072627
		}
	}
	}
	catch ( Exception e )
	{
		
		try {//IN072627
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//IN072627
		error_messages.setLength(0);
  		error_messages.append( "Error inserting Into Drug Interaction Table" +e.toString()) ;
  		e.printStackTrace() ;
  		status = false;
  	} 
	finally 
	{
		try {
			closeStatement( pstmt ) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
  	}
		return status;
}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap modify( HashMap tabData, HashMap sqlMap )  
	{
		//boolean flag = true ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "") ;
		map.put( "flag", new Boolean( false ) ) ;
		sqlMap.clear();
		tabData.clear();
		return map;

  	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap delete( HashMap tabData, HashMap sqlMap ) 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "") ;
		map.put( "flag", new Boolean( false ) ) ;
		sqlMap.clear();
		tabData.clear();
		return map;
	}


	// Below Method is to get the Line No. for the order_id passed (Used when inserting the line num in the line level)
	private int getLineNum(String order_id,String query) throws Exception 
	{		
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int line_num 				= 0;
		try
		{
			pstmt		= connection.prepareStatement(query);

			
 			pstmt.setString(1, order_id.trim());
  			resultSet	= pstmt.executeQuery() ;
			
  			if(resultSet!=null) // Only One Record
 			{
 				if(resultSet.next() ) {  // Only one record
  					line_num = resultSet.getInt(1);
  				}
 			}
 			if(line_num == 0 || resultSet == null) line_num = 1;
		
	 	}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error getting the line_num" +e.toString()) ;
	  		e.printStackTrace() ;
	  	} 
		finally 
		{
	  			closeResultSet( resultSet ) ;
	  			closeStatement( pstmt ) ;
	  	}
  		return line_num;
	} // End of getLineNum
	
	//IN041371 - Start
	private String getSpecimenNo(String order_id) throws Exception 
	{		
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String speci_num 			= "";
		String order_status			= "";
		try
		{
			//pstmt		= connection.prepareStatement(" Select ACCESSION_NUM,ORDER_LINE_STATUS from or_order_line where order_id=? and order_line_num='1' ");//IN065725
			pstmt		= connection.prepareStatement(" Select ACCESSION_NUM,ORDER_LINE_STATUS from or_order_line where order_id = ? and order_line_status != 'CN' and rownum=1");//IN065725

			
 			pstmt.setString(1, order_id.trim());
  			resultSet	= pstmt.executeQuery() ;
			
  			if(resultSet!=null) // Only One Record
 			{
 				if(resultSet.next() ) {  // Only one record
 					//speci_num = checkForNull(resultSet.getString("ACCESSION_NUM"),"");//IN065725
 					speci_num = checkForNull(resultSet.getString("ACCESSION_NUM"),"~");//IN065725
 					order_status = checkForNull(resultSet.getString("ORDER_LINE_STATUS"),"OS");
  				}
 			}
 			if(speci_num.equals("") || resultSet == null) speci_num = "";
 			speci_num = speci_num+"#"+order_status;
	 	}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error getting the speci_num" +e.toString()) ;
	  		e.printStackTrace() ;
	  	} 
		finally 
		{
	  			closeResultSet( resultSet ) ;
	  			closeStatement( pstmt ) ;
	  	}
  		return speci_num;
	} // End of speci_num
	
	private String[] getLBtabDetails(String order_id) throws Exception 
	{		
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String coll_label_gen_rule 	= "";
		String coll_label_gen_date_time = "";
		String specimen_collect_yn = "";
		String specimen_collect_date_time = "";
		String specimen_collected_by = "";
		String specimen_reqd_yn = "";
		String coll_reqd_yn = "";
		String specimen_collect_remarks = "";
		String dispatch_reqd_yn = "";
		String specimen_dispatch_yn = "";
		String specimen_dispatch_date_time = "";
		String specimen_dispatched_by = ""; 
		String specimen_dispatch_mode = "";
		String specimen_dispatch_remarks = "";
		String[] orderValues = new String[14] ;
		
		try
		{
			pstmt		= connection.prepareStatement(" SELECT coll_label_gen_rule,to_char(coll_label_gen_date_time,'DD/MM/YYYY HH24:MI') coll_label_gen_date_time, specimen_collect_yn, to_char(specimen_collect_date_time,'DD/MM/YYYY HH24:MI') specimen_collect_date_time, specimen_collected_by, specimen_reqd_yn, coll_reqd_yn, specimen_collect_remarks, dispatch_reqd_yn, specimen_dispatch_yn, to_char(specimen_dispatch_date_time,'DD/MM/YYYY HH24:MI') specimen_dispatch_date_time, specimen_dispatched_by, specimen_dispatch_mode, specimen_dispatch_remarks FROM or_order_line_lb WHERE order_id = ? AND order_line_num = '1' ");

			
 			pstmt.setString(1, order_id.trim());
  			resultSet	= pstmt.executeQuery() ;
			
  			if(resultSet!=null) // Only One Record
 			{
 				if(resultSet.next() ) {  // Only one record
 					coll_label_gen_rule = checkForNull(resultSet.getString("coll_label_gen_rule"),"");
 					coll_label_gen_date_time = checkForNull(resultSet.getString("coll_label_gen_date_time"),"");
 					specimen_collect_yn = checkForNull(resultSet.getString("specimen_collect_yn"),"");
 					specimen_collect_date_time = checkForNull(resultSet.getString("specimen_collect_date_time"),"");
 					specimen_collected_by = checkForNull(resultSet.getString("specimen_collected_by"),"");
 					specimen_reqd_yn = checkForNull(resultSet.getString("specimen_reqd_yn"),"");
 					coll_reqd_yn = checkForNull(resultSet.getString("coll_reqd_yn"),"");
 					specimen_collect_remarks = checkForNull(resultSet.getString("specimen_collect_remarks"),"");
 					dispatch_reqd_yn = checkForNull(resultSet.getString("dispatch_reqd_yn"),"");
 					specimen_dispatch_yn = checkForNull(resultSet.getString("specimen_dispatch_yn"),"");
 					specimen_dispatch_date_time = checkForNull(resultSet.getString("specimen_dispatch_date_time"),"");
 					specimen_dispatched_by = checkForNull(resultSet.getString("specimen_dispatched_by"),"");
 					specimen_dispatch_mode = checkForNull(resultSet.getString("specimen_dispatch_mode"),"");
 					specimen_dispatch_remarks = checkForNull(resultSet.getString("specimen_dispatch_remarks"),"");
  				}
 			}
  			orderValues[0] = coll_label_gen_rule;
  			orderValues[1] = coll_label_gen_date_time;
  			orderValues[2] = specimen_collect_yn;
  			orderValues[3] = specimen_collect_date_time;
  			orderValues[4] = specimen_collected_by;
  			orderValues[5] = specimen_reqd_yn;
  			orderValues[6] = coll_reqd_yn;
  			orderValues[7] = specimen_collect_remarks;
  			orderValues[8] = dispatch_reqd_yn;
  			orderValues[9] = specimen_dispatch_yn;
  			orderValues[10] = specimen_dispatch_date_time;
  			orderValues[11] = specimen_dispatched_by;
  			orderValues[12] = specimen_dispatch_mode;
  			orderValues[13] = specimen_dispatch_remarks;
  			
	 	}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error getting the orderValues" +e.toString()) ;
	  		e.printStackTrace() ;
	  	} 
		finally 
		{
	  			closeResultSet( resultSet ) ;
	  			closeStatement( pstmt ) ;
	  	}
  		return orderValues;
	} // End of getlbtabdetails
	//IN041371 - End

/**
* @ejb.interface-method
*	 view-type="both"
*/

	// Insertion into the Format Fields (New Orders)
	private boolean insertFormatFields(HashMap mapOrderFormatHdr,HashMap hashMap, HashMap tabData,String order_id,String order_type,int count, String query,String query1,String amend_insert_query,String format_hdr_chk_qry) throws Exception 
	{
		PreparedStatement pstmt_order_format_hdr = null;
		PreparedStatement pstmt_consult_med_id = null;
		PreparedStatement pstmt_order_format_hdr_repeat			=null;
		ResultSet hdr_rs = null;

		HashMap orderFormatHdr					 = new HashMap();
		String amend_delete_line_num			 = "", amend_order_id = "";
		String single_or_multi					 = "";
		//StringTokenizer stSingleMulti			 = null;
		int seq_num								= 0;
		int temp_count =0;
		boolean status = true;
		try
		{
			pstmt_order_format_hdr			= connection.prepareStatement(query);
			pstmt_consult_med_id            = connection.prepareStatement(query1);
			pstmt_order_format_hdr_repeat	= connection.prepareStatement(format_hdr_chk_qry);
			orderFormatHdr 					= ((HashMap)mapOrderFormatHdr.get("header_format_values"+order_type));

			if(orderFormatHdr==null || orderFormatHdr.size() <= 1) // For Pharmacy or from Preview
				orderFormatHdr				= ((HashMap)mapOrderFormatHdr.get("header_format_values"+""));
			if(orderFormatHdr!=null && orderFormatHdr.size() >1)
			{

				pstmt_order_format_hdr_repeat.setString(1,order_id.trim());
				hdr_rs = pstmt_order_format_hdr_repeat.executeQuery();

				if (hdr_rs != null && hdr_rs.next())
				{
					temp_count = hdr_rs.getInt(1);

			  	}

				if(temp_count == 0)
				{
				int order_format_count 		= Integer.parseInt(checkForNull((String)orderFormatHdr.get("order_format_count"),"0"));
				int hdr_seq_num=0,tmp_hdr_seq_num=0;
				for(int i=0;i<order_format_count;i++)
				{
 					//seq_num = Double.parseDouble(checkForNull((String)orderFormatHdr.get("new_seq_num"+i),"0.0"));
					seq_num			= Integer.parseInt(checkForNull((String)orderFormatHdr.get("new_seq_num"+i),"0"));
					single_or_multi	= checkForNull((String)orderFormatHdr.get("single_or_multi"+i),"S");
					//field_values	= checkForNull((String)orderFormatHdr.get("field_values"+i),"");

					if(!checkForNull((String)orderFormatHdr.get("field_mnemonic"+i),"").equals("")) {
						/*if(single_or_multi.equals("M") && !field_values.equals("")) {
						// If it is multi, then u have to insert n number of records, depending upon what the user has selected
 							stSingleMulti	= new StringTokenizer(field_values,"||");
							while(stSingleMulti.hasMoreTokens()) {
								seq_num		 = seq_num + 0.1; //increase by 0.1
								field_values = stSingleMulti.nextToken();
								if(field_values==null) field_values = "";
					

								pstmt_order_format_hdr.setString(1,order_id.trim());
								// If decision support system is done for the header, then take from the new_seq_num not from the seq_num
								pstmt_order_format_hdr.setDouble(2, seq_num);  // Seq_num
						
								//pstmt_order_format_hdr.setInt(2, Integer.parseInt(((String)orderFormatHdr.get("seq_num"+i))));  // Seq_num
								pstmt_order_format_hdr.setString(3,  ((String)orderFormatHdr.get("field_mnemonic"+i)));
								pstmt_order_format_hdr.setString(4,  ((String)orderFormatHdr.get("field_type"+i)));				// field_type
								pstmt_order_format_hdr.setString(5,  ((String)orderFormatHdr.get("label_text"+i)));				//order_label_text
								pstmt_order_format_hdr.setString(6,  field_values);			//order_line_field_value
								pstmt_order_format_hdr.setString(7,  ((String)orderFormatHdr.get("accept_option"+i)));			//accept_option
								pstmt_order_format_hdr.setString(8,  ((String)orderFormatHdr.get("dependency_yn"+i)));			//dependency_yn
								pstmt_order_format_hdr.setDouble(9,  Double.parseDouble(checkForNull((String)orderFormatHdr.get("seq_num"+i),"0.0"))+0.1);			//seq_num

								pstmt_order_format_hdr.setString(10, ((String)tabData.get("login_by_id")));
								pstmt_order_format_hdr.setString(11, ((String)tabData.get("login_at_ws_no")));
								pstmt_order_format_hdr.setString(12, ((String)tabData.get("login_facility_id")));
								pstmt_order_format_hdr.setString(13, ((String)tabData.get("login_by_id")));
								pstmt_order_format_hdr.setString(14, ((String)tabData.get("login_at_ws_no")));
								pstmt_order_format_hdr.setString(15, ((String)tabData.get("login_facility_id")));

								pstmt_order_format_hdr.addBatch();
							} // End of while
							stSingleMulti = null;// Nullifying the objects
						} else {  // for Single
						*/
								if(single_or_multi.equals("S") || single_or_multi.equals("") || (single_or_multi.equals("M") && checkForNull((String)orderFormatHdr.get("field_type"+i),"").equals("L")) || (single_or_multi.equals("M") && (!(checkForNull((String)orderFormatHdr.get("field_values"+i),"").equals(""))) && checkForNull((String)orderFormatHdr.get("field_type"+i),"").equals("C")) ) 
								{


									if(orderFormatHdr.get("seq_num"+i) == null || ((String)orderFormatHdr.get("seq_num"+i)).equals(""))
									{
									hdr_seq_num = ++tmp_hdr_seq_num  ;
									}
									else
									{
									hdr_seq_num = Integer.parseInt((String)orderFormatHdr.get("seq_num"+i));
									}
								pstmt_order_format_hdr.setString(1,order_id.trim());
								// If decision support system is done for the header, then take from the new_seq_num not from the seq_num
								//pstmt_order_format_hdr.setDouble(2, seq_num);  // Seq_num
								pstmt_order_format_hdr.setInt(2, seq_num);
								//pstmt_order_format_hdr.setInt(2, Integer.parseInt(((String)orderFormatHdr.get("seq_num"+i))));  // Seq_num
								pstmt_order_format_hdr.setString(3,  ((String)orderFormatHdr.get("field_mnemonic"+i)));
								pstmt_order_format_hdr.setString(4,  ((String)orderFormatHdr.get("field_type"+i)));				// field_type
								pstmt_order_format_hdr.setString(5,  ((String)orderFormatHdr.get("label_text"+i)));				//order_label_text
								pstmt_order_format_hdr.setString(6,  checkForNull((String)orderFormatHdr.get("field_values"+i),""));			//order_line_field_value
								pstmt_order_format_hdr.setString(7,  ((String)orderFormatHdr.get("accept_option"+i)));			//accept_option
								pstmt_order_format_hdr.setString(8,  ((String)orderFormatHdr.get("dependency_yn"+i)));			//dependency_yn
 								//pstmt_order_format_hdr.setDouble(9,  Double.parseDouble(checkForNull((String)orderFormatHdr.get("seq_num"+i),"0.0")));			//seq_num
 								//pstmt_order_format_hdr.setInt(9,  Integer.parseInt(checkForNull((String)orderFormatHdr.get("seq_num"+i),"0")));			//seq_num
 								pstmt_order_format_hdr.setInt(9,  hdr_seq_num );			//seq_num
 								pstmt_order_format_hdr.setString(10,checkForNull((String)orderFormatHdr.get("discr_msr_uom"+i),""));			//discr_msr_uom

								pstmt_order_format_hdr.setString(11, ((String)tabData.get("login_by_id")));
								pstmt_order_format_hdr.setString(12, ((String)tabData.get("login_at_ws_no")));
								pstmt_order_format_hdr.setString(13, ((String)tabData.get("login_facility_id")));
								pstmt_order_format_hdr.setString(14, ((String)tabData.get("login_by_id")));
								pstmt_order_format_hdr.setString(15, ((String)tabData.get("login_at_ws_no")));
								pstmt_order_format_hdr.setString(16, ((String)tabData.get("login_facility_id")));

								pstmt_order_format_hdr.addBatch();
							} // End of single_or_multi
						//} // End of single
					} // End of field_mnemonic not null

						if (((String)orderFormatHdr.get("field_mnemonic"+i)).equals("CONULT_MED_ID")) 
						{
    					pstmt_consult_med_id.setString(1,((String)orderFormatHdr.get("field_values"+i)));
    					pstmt_consult_med_id.setString(2,order_id.trim());
    					pstmt_consult_med_id.addBatch();
                    }
				} // End of for order_format_count
				int result_val[] = pstmt_order_format_hdr.executeBatch();
				pstmt_consult_med_id.executeBatch();								// Not checking whether updated or not, done for the GAS DEMO
				//int result_consult_med_id [] = pstmt_consult_med_id.executeBatch(); // Not checking whether updated or not, done for the GAS DEMO
				// -2 done successful but does not have the count of row affected
				for (int i=0;i<result_val.length ;i++ )
				{
					if(result_val[i] != -2  && result_val[i] < 0)
					{
						status=false;
						break;
					}
					else status=true;
				}
				}
				else
				{
					status=true;
				}
			} // End of orderFormatHdr
 			else
			{   // Not From the Bean, if amend and new insertion
				amend_order_id 		   = checkForNull((String)hashMap.get("amend_order_id"),""); // Then one record to be inserted for the count
				boolean amend_status    = false ;
				if(!amend_order_id.equals("")) // If it is only new order, amend_order_id will be blank;
				{
					for(int i=0;i<count;i++)
					{ // just to check whether it is from amend or not,if atleast  one is there then try insertion
						amend_delete_line_num  = checkForNull((String)hashMap.get("amend_delete_line_num"+i),"");
						if(!amend_status && !amend_delete_line_num.equals("")) 
						{
							// Then it is from the Amend(if alteast one found, then come out)
							amend_status = true;
						} // End of !amend_delete_line_num
					} // End of For
					if(amend_status)
					{
						//Call the method to update the record (Amend)
						 status  = insertAmendFormatFields(tabData, order_id, amend_order_id, amend_insert_query);
					}
					//order_id.trim()
				}
 			} // End of else
 		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error inserting order format HDR fields" +e.toString()) ;
	  		e.printStackTrace() ;
	  		status = false;
	  	}
		finally 
		{
			closeResultSet(hdr_rs);
	  		closeStatement( pstmt_order_format_hdr ) ;
	  		closeStatement( pstmt_order_format_hdr_repeat ) ;
            closeStatement( pstmt_consult_med_id ) ;
 	  	}
  		return status;
  	} // End of insertFormatFields

/**
* @ejb.interface-method
*	 view-type="both"
*/

	// Insertion into the FormatFields in the line Level.
	private boolean insertFormatLineFields(HashMap mapOrderFormatDtl,HashMap tabData,String order_id,int order_line_num,String query ) throws Exception
	{	// hashMap will be used for Order Formats
		PreparedStatement pstmt = null;
		boolean status			= true;
		int seq_num				= 0;
		//double seq_num			= 0.0;
		//int count				= 0 ;
		//String field_values		= "";
		String single_or_multi	= ""; //StringTokenizer stSingleMulti = null;
		boolean l_ignore = false;//IN066436
		try
		{
			pstmt					 	= connection.prepareStatement(query);
			int order_format_count 		= Integer.parseInt(checkForNull((String)mapOrderFormatDtl.get("order_format_count"),"0"));
 			for(int i=0;i<order_format_count;i++)
			{
				if(status)//IN066436
				{//IN066436
				//seq_num	= Integer.parseInt(((String)mapOrderFormatDtl.get("seq_num"+i)))+10;//To avoid unique constaint
				//seq_num		= Double.parseDouble(checkForNull((String)mapOrderFormatDtl.get("new_seq_num"+i),"0.0"))+10;//To avoid unique constaint
				seq_num			= Integer.parseInt(checkForNull((String)mapOrderFormatDtl.get("new_seq_num"+i),"0"))+10;//To avoid unique constaint;
 				single_or_multi	= checkForNull((String)mapOrderFormatDtl.get("single_or_multi"+i),"S");
				//field_values	= checkForNull((String)mapOrderFormatDtl.get("field_values"+i),"");
				if(!checkForNull((String)mapOrderFormatDtl.get("field_mnemonic"+i),"").equals("")) 
				{
					/*if(single_or_multi.equals("M") && !field_values.equals("")) {
					// If it is multi, then u have to insert n number of records, depending upon what the user has selected
 							stSingleMulti	= new StringTokenizer(field_values,"||");
							while(stSingleMulti.hasMoreTokens()) {
								seq_num		 = seq_num + 0.1; //increase by 0.1
								field_values = stSingleMulti.nextToken();
								if(field_values==null) field_values = "";
								

								pstmt.setString(1,order_id.trim());
								pstmt.setInt(2, order_line_num);
						
								pstmt.setString(3, "U");
								pstmt.setDouble(4, seq_num);  				// Seq_num
								pstmt.setString(5,  ((String)mapOrderFormatDtl.get("field_mnemonic"+i)));
								pstmt.setString(6,  ((String)mapOrderFormatDtl.get("field_type"+i)));		// field_type
								pstmt.setString(7,  ((String)mapOrderFormatDtl.get("label_text"+i)));		//order_label_text
								pstmt.setString(8,  field_values);		//order_line_field_value
								pstmt.setString(9,  ((String)mapOrderFormatDtl.get("accept_option"+i)));	//accept_option
								pstmt.setString(10,  ((String)mapOrderFormatDtl.get("dependency_yn"+i)));	//dependency_yn
								pstmt.setDouble(11,  Double.parseDouble(checkForNull((String)mapOrderFormatDtl.get("seq_num"+i),"0.0"))+0.1);	//format_seq_num

								pstmt.setString(12, ((String)tabData.get("login_by_id")));
								pstmt.setString(13, ((String)tabData.get("login_at_ws_no")));
								pstmt.setString(14, ((String)tabData.get("login_facility_id")));
								pstmt.setString(15, ((String)tabData.get("login_by_id")));
								pstmt.setString(16, ((String)tabData.get("login_at_ws_no")));
								pstmt.setString(17, ((String)tabData.get("login_facility_id")));

								pstmt.addBatch();
								} // End of while
								stSingleMulti = null;// Nullifying the objects
							} else { // for single insertion
							*/
							if(single_or_multi.equals("S") || single_or_multi.equals("") || (single_or_multi.equals("M") && checkForNull((String)mapOrderFormatDtl.get("field_type"+i),"").equals("L")) || (single_or_multi.equals("M") && (!(checkForNull((String)mapOrderFormatDtl.get("field_values"+i),"").equals(""))) && checkForNull((String)mapOrderFormatDtl.get("field_type"+i),"").equals("C")) ) 
							{
 							 	pstmt.setString(1,order_id.trim());
								pstmt.setInt(2, order_line_num);
 								pstmt.setString(3, "U");
								pstmt.setInt(4, seq_num);  				// Seq_num
								//pstmt.setDouble(4, seq_num);  				// Seq_num
								pstmt.setString(5,  ((String)mapOrderFormatDtl.get("field_mnemonic"+i)));
								pstmt.setString(6,  ((String)mapOrderFormatDtl.get("field_type"+i)));		// field_type
								pstmt.setString(7,  ((String)mapOrderFormatDtl.get("label_text"+i)));		//order_label_text
								pstmt.setString(8,  checkForNull((String)mapOrderFormatDtl.get("field_values"+i),""));		//order_line_field_value
								pstmt.setString(9,  ((String)mapOrderFormatDtl.get("accept_option"+i)));	//accept_option
								pstmt.setString(10, ((String)mapOrderFormatDtl.get("dependency_yn"+i)));	//dependency_yn
								pstmt.setInt(11,  Integer.parseInt(checkForNull((String)mapOrderFormatDtl.get("seq_num"+i),"0")));	//format_seq_num    discr_msr_uom
								pstmt.setString(12,checkForNull((String)mapOrderFormatDtl.get("discr_msr_uom"+i),""));
								//pstmt.setDouble(11,  Double.parseDouble(checkForNull((String)mapOrderFormatDtl.get("seq_num"+i),"0.0")));	//format_seq_num

								pstmt.setString(13, ((String)tabData.get("login_by_id")));
								pstmt.setString(14, ((String)tabData.get("login_at_ws_no")));
								pstmt.setString(15, ((String)tabData.get("login_facility_id")));
								pstmt.setString(16, ((String)tabData.get("login_by_id")));
								pstmt.setString(17, ((String)tabData.get("login_at_ws_no")));
								pstmt.setString(18, ((String)tabData.get("login_facility_id")));
								pstmt.setString(19,null);
								pstmt.setString(20, null);
								pstmt.setString(21, null);								
								pstmt.setString(22, null);//IN64543
								/*IN066436 Start*/
								//pstmt.addBatch();
								l_ignore  = false;
								if(checkForNull((String)mapOrderFormatDtl.get("field_type"+i),"").equals("C") || (checkForNull((String)mapOrderFormatDtl.get("field_type"+i),"").equals("L") && checkForNull((String)mapOrderFormatDtl.get("single_or_multi"+i),"").equals("M")))
								{
									l_ignore = true;
								}
								//IN066436, ends
								if("R".equals((String)mapOrderFormatDtl.get("accept_option"+i)) && "".equals(checkForNull((String)mapOrderFormatDtl.get("field_values"+i),"")) && !l_ignore)//INC60411
								{							
									status = false;
								}
								else
								{
									pstmt.addBatch();								
								}								
									//IN066436 End.
							} // End of single_or_multi
  						//} // End of single
						}//IN066436
					} // should not be null field_mnemonic



				} // End of for order_format_count
		if(status)//IN066436
		{//IN066436
			int result_val[] = pstmt.executeBatch();
			// -2 done successful but does not have the count of row affected
			for (int i=0;i<result_val.length ;i++ )
			{
				if(result_val[i] != -2  && result_val[i] < 0)
				{
					status=false;
					//break;//IN066436 commented
				}
				else status=true;
			}
		}//IN066436
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error inserting order format Line fields" +e.toString()) ;
	  		e.printStackTrace() ;
	  		status = false;
	  	} 
		finally 
		{
		  			closeStatement( pstmt ) ;
	  	}
  		return status;
  	} // End of insertFormatLineFields

	// Schedule Frequency Insertion Done here (Line Level (New Orders))
/**
* @ejb.interface-method
*	 view-type="both"
*/

  	private boolean insertScheduleLineFields(ArrayList mapScheduleDtl,HashMap tabData,String order_id,int line_num,String query) throws Exception 
	{	 
   		PreparedStatement pstmt = null;
  		String duration_type	= "";int repeat = 0;
		boolean status 			= false;int seq_num = 200;
		try
		{
			
			HashMap hdr_map = (HashMap)mapScheduleDtl.get(0);
			ArrayList days_list = (ArrayList)mapScheduleDtl.get(1);
			//ArrayList days_name = (ArrayList)mapScheduleDtl.get(2);
			ArrayList time_list = (ArrayList)mapScheduleDtl.get(3);
			ArrayList qty_list = (ArrayList)mapScheduleDtl.get(4);
			
						
			
			duration_type				= checkForNull(((String)hdr_map.get("durationType")),"");
			//repeat 						= Integer.parseInt(checkForNull((String)hdr_map.get("repeat"),"0"));
			repeat 						= (Integer)hdr_map.get("repeat");

			pstmt					 	= connection.prepareStatement(query);
	
			if (repeat > 0)
			{
				for (int i = 0;i<repeat ;i++ )
				{
					seq_num++;
					pstmt.setString(1,order_id.trim());
					pstmt.setInt(2, line_num);
					if((duration_type).equals("W") || (duration_type).equals("L"))
 						pstmt.setString(3, "D");
 					else
 						pstmt.setString(3, "T");
					pstmt.setInt(4, seq_num);  				// Seq_num
 					pstmt.setString(5,  "SCHED_ADMIN_TIME");
 					if(duration_type.equals("W") || duration_type.equals("L"))			
 						pstmt.setString(6,  "C");	// field_type
					else
						pstmt.setString(6,  "T");	// field_type
					if(((String)days_list.get(i)).equals(""))
						pstmt.setString(7,  "H");
					else
						pstmt.setString(7,  "D");
					pstmt.setString(8,  (String)time_list.get(i));
					pstmt.setString(9,  "O");	//accept_option Optional always
					pstmt.setString(10, "N");  	// dependency_yn
					pstmt.setInt(11, seq_num);  // seq_num
					pstmt.setString(12, "");//discr_msr_uom
					pstmt.setString(13, ((String)tabData.get("login_by_id")));
					pstmt.setString(14, ((String)tabData.get("login_at_ws_no")));
					pstmt.setString(15, ((String)tabData.get("login_facility_id")));
					pstmt.setString(16, ((String)tabData.get("login_by_id")));
					pstmt.setString(17, ((String)tabData.get("login_at_ws_no")));
					pstmt.setString(18, ((String)tabData.get("login_facility_id")));
					pstmt.setString(19,  (String)qty_list.get(i));
					pstmt.setString(20,  null);
					pstmt.setString(21,  (String)days_list.get(i));
					pstmt.setString(22,  null);//IN64543
					pstmt.addBatch();
				}
			}
	
		/*	if(duration_type.equals("W"))
			{
				// If Days are there in the Schedule Frequency
				for(int i=1 ; i <= 7 ; i++){
					seq_num++;
					pstmt.setString(1,order_id.trim());
					pstmt.setInt(2, line_num);
					if((duration_type).equals("W"))
 						pstmt.setString(3, "D");
 					else
 						pstmt.setString(3, "T");
 					pstmt.setInt(4, seq_num);  				// Seq_num
 					pstmt.setString(5,  "SCHED_ADMIN_TIME");						
 					pstmt.setString(6,  "C");	// field_typ					
 					pstmt.setString(7,  checkForNull((String)mapScheduleDtl.get("dayDisplay"+i),"")); //order_label_text
 					pstmt.setString(8,  checkForNull((String)mapScheduleDtl.get("daySM"+i),""));	//order_line_field_value
					pstmt.setString(9,  "O");	//accept_option Optional always
					pstmt.setString(10, "N");  	// dependency_yn
					pstmt.setInt(11, seq_num);  // seq_num
					pstmt.setString(12, "");//discr_msr_uom
					pstmt.setString(13, ((String)tabData.get("login_by_id")));
					pstmt.setString(14, ((String)tabData.get("login_at_ws_no")));
					pstmt.setString(15, ((String)tabData.get("login_facility_id")));
					pstmt.setString(16, ((String)tabData.get("login_by_id")));
					pstmt.setString(17, ((String)tabData.get("login_at_ws_no")));
					pstmt.setString(18, ((String)tabData.get("login_facility_id")));
					pstmt.addBatch();
				} // End of For i<=7
			}

				// If the Times / Hours are there
			 	for(int j=1 ; j <= repeat ; j++){
				 	seq_num++;
			 		pstmt.setString(1,order_id.trim());
					pstmt.setInt(2, line_num);
					if((duration_type).equals("W"))
						pstmt.setString(3, "D");
					else
						pstmt.setString(3, "T");
					pstmt.setInt(4, seq_num);  				// Seq_num
					pstmt.setString(5,  "SCHED_ADMIN_TIME");
					pstmt.setString(6,  "T");	// field_type
					pstmt.setString(7,  checkForNull((String)mapScheduleDtl.get("displayHrs"+j),"")); //order_label_text
					pstmt.setString(8,  checkForNull((String)mapScheduleDtl.get("time"+j),"")); //order_line_field_value
					pstmt.setString(9,  "O");	//accept_option Optional always
					pstmt.setString(10, "N");  	// dependency_yn
					pstmt.setInt(11, seq_num);  // seq_num
					pstmt.setString(12, "");  //discr_msr_uom
					pstmt.setString(13, ((String)tabData.get("login_by_id")));
					pstmt.setString(14, ((String)tabData.get("login_at_ws_no")));
					pstmt.setString(15, ((String)tabData.get("login_facility_id")));
					pstmt.setString(16, ((String)tabData.get("login_by_id")));
					pstmt.setString(17, ((String)tabData.get("login_at_ws_no")));
					pstmt.setString(18, ((String)tabData.get("login_facility_id")));
					pstmt.addBatch();
				} // End of for repeat 

				*/
			int result_val[] = pstmt.executeBatch();
			// -2 done successful but does not have the count of row affected
			for (int i=0;i<result_val.length ;i++ )
			{
				if(result_val[i] != -2  && result_val[i] < 0)
				{
					status=false;
					break;
				}
				else status=true;
			}
			
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error inserting Schedule Fields" +e.toString()) ;
	  		e.printStackTrace() ;
	  		status = false;
	  	} 
		finally 
		{
			closeStatement( pstmt ) ;
	  	}
  		return status;
  	} // End of insertScheduleLineFields

	// Insertion into the Preps Instruction(Line Level)  (New Orders)

/**
* @ejb.interface-method
*	 view-type="both"
*/

	//private boolean insertFormatLineInstns(HashMap tabData, String order_id, int line_num, int seq_no,String mnemonic,String instrn_value,String query) throws Exception//IN64543
  	private boolean insertFormatLineInstns(HashMap tabData, String order_id, int line_num, int seq_no,String mnemonic,String instrn_value,String query, String instrn_content_type) throws Exception//IN64543
	{

		PreparedStatement pstmt 	= null;
		boolean status 				= false;int result_flex_fields = 0;
		
		try
		{
			pstmt		= connection.prepareStatement(query);
 			pstmt.setString(1,order_id.trim());
 			pstmt.setInt(2,line_num);
 			pstmt.setString(3,"U");
 			pstmt.setInt(4,seq_no);
 			if(mnemonic.equalsIgnoreCase("PREPS"))		//order_line_field_mnemonic
 				pstmt.setString(5,"PAT_PREPS_TEXT");
 			else if(mnemonic.equalsIgnoreCase("DEPTS"))
 				pstmt.setString(5,"DEPT_INSTRNS");
			else if(mnemonic.equalsIgnoreCase("PATIENT_INSTRN"))
 				pstmt.setString(5,"PATIENT_INSTRNS");
			pstmt.setString(6,"A");	// For Dept and Presps
 			if(mnemonic.equalsIgnoreCase("PREPS")) // For Preps Instrns.
 				pstmt.setString(7,"Patient Preps");  //order_line_label_text
 			else if(mnemonic.equalsIgnoreCase("DEPTS")) // For Depts. Instrns.
 				pstmt.setString(7,"Dept.Instructions");
			else if(mnemonic.equalsIgnoreCase("PATIENT_INSTRN")) // For Patient. Instrns.
 				pstmt.setString(7,"Patient Instructions");
 			//IN64543, starts
			//pstmt.setString(8,instrn_value);
			if(instrn_content_type.equals("T"))
 			{
 				pstmt.setString(8,instrn_value);
 				pstmt.setString(22,null);
 			}
 			else if(instrn_content_type.equals("E"))
 			{
 				pstmt.setString(8,null);
 				pstmt.setString(22,instrn_value);
 			}
			//IN64543, ends
 			pstmt.setString(9,"O");
			pstmt.setString(10,"N");			// Dependency_yn
			pstmt.setInt(11, line_num);			//FORMAT_SEQ_NUM
			pstmt.setString(12,"");
 			pstmt.setString(13, ((String)tabData.get("login_by_id")));
			pstmt.setString(14, ((String)tabData.get("login_at_ws_no")));
			pstmt.setString(15, ((String)tabData.get("login_facility_id")));
			pstmt.setString(16, ((String)tabData.get("login_by_id")));
			pstmt.setString(17, ((String)tabData.get("login_at_ws_no")));
			pstmt.setString(18, ((String)tabData.get("login_facility_id")));
			pstmt.setString(19, null);
			pstmt.setString(20,null);
			pstmt.setString(21,null);

			result_flex_fields = pstmt.executeUpdate();
			if(result_flex_fields > 0 ) status = true; else status = false;

	 	}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error inserting flex fields" +e.toString()) ;
	  		e.printStackTrace() ;
	  		status = false;
	  	} 
		finally 
		{
  				closeStatement( pstmt ) ;
	  	}
  		return status;
  	} // End of insertFormatLineInstns

	// i.e Delete from the table and then insert, because of dependency, cannot update directly
	private void deleteAmendFormatFields(String order_id, String delete_query) throws Exception
	{
		PreparedStatement pstmt_order_format_hdr_delete = null;
 		try
		{
			// Deletion done here
			// Since updation cannot be done, since dependency has come, the seq_no may be changed and the values too, so delete and insert.
			pstmt_order_format_hdr_delete	 = connection.prepareStatement(delete_query);  // For Deletion
			pstmt_order_format_hdr_delete.clearParameters();
			pstmt_order_format_hdr_delete.setString(1, order_id.trim());
			pstmt_order_format_hdr_delete.executeUpdate(); // Blind Delete, do not check if it is deleted or not
			//int count = pstmt_order_format_hdr_delete.executeUpdate(); // Blind Delete, do not check if it is deleted or not

		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error deleting deleteAmendFormatFields" +e.toString()) ;
	  		e.printStackTrace() ;
 	  	} 
		finally 
		{
  			closeStatement( pstmt_order_format_hdr_delete ) ;
	  	}
 	 } // End of deleteAmendFormatFields

	 // Updation for the Order Formats in the Amend/Review Function(Header Level)
/*	 private boolean updateFormatFields(HashMap mapOrderFormatHdr,HashMap hashMap, HashMap tabData,String order_id, String order_type, String insert_query, String sql_order_entry_update_consult_med_id,String sql_order_entry_amend_or_order_field_insert) throws Exception{	// hashMap will be used for Order Formats
		//PreparedStatement pstmt_order_format_hdr		 = null;
		//PreparedStatement pstmt_order_format_hdr_delete  = null;
		HashMap	orderFormatHdr							 = new HashMap();
		boolean status 									 = true; //int format_count = 0;
		try
		{

			orderFormatHdr 						= ((HashMap)mapOrderFormatHdr.get("header_format_values"+order_type));

			if(orderFormatHdr==null && orderFormatHdr.size() <=1) //(For Pharamcy order_type can be blank)
	 			orderFormatHdr 					= ((HashMap)mapOrderFormatHdr.get("header_format_values"+""));

 			if(orderFormatHdr!=null && orderFormatHdr.size() >1)
			{
				//int order_format_count			 = Integer.parseInt( checkForNull((String)orderFormatHdr.get("order_format_count"),"0"));
 				//	pstmt_order_format_hdr_update	 = connection.prepareStatement(update_query);  // For Updation
	 			// pstmt_order_format_hdr			 = connection.prepareStatement(insert_query);  // For Insertion
				// Call a same method which is used to insert the Header Level format level fields
				if(status)
				{	// As of now we r passing the count from here as 0
					status	 = insertFormatFields(orderFormatHdr, hashMap, tabData, order_id, order_type, 0, insert_query, sql_order_entry_update_consult_med_id, sql_order_entry_amend_or_order_field_insert);
				}
			} // End of orderFormatHdr


				//for(int i=0;i<order_format_count;i++)
				//{
					 *if(status)
					{
						pstmt_order_format_hdr_update.clearParameters();
						pstmt_order_format_hdr_update.setString(1, ((String)orderFormatHdr.get("field_type"+i)));	// field_type
	 					pstmt_order_format_hdr_update.setString(2, ((String)orderFormatHdr.get("label_text"+i)));						//order_label_text
						pstmt_order_format_hdr_update.setString(3, ((String)orderFormatHdr.get("field_values"+i)));	//order_line_field_value
	 					pstmt_order_format_hdr_update.setString(4, ((String)orderFormatHdr.get("accept_option"+i)));	//accept_option
						pstmt_order_format_hdr_update.setString(5, ((String)tabData.get("login_by_id")));
						pstmt_order_format_hdr_update.setString(6, ((String)tabData.get("login_at_ws_no")));
						pstmt_order_format_hdr_update.setString(7, ((String)tabData.get("login_facility_id")));
						pstmt_order_format_hdr_update.setString(8, order_id.trim());
						pstmt_order_format_hdr_update.setInt(9, Integer.parseInt(((String)orderFormatHdr.get("new_seq_num"+i))));  // new_seq_num
	 					//pstmt_order_format_hdr_update.setInt(9, Integer.parseInt(((String)orderFormatHdr.get("seq_num"+i))));  // Seq_num
						// If decision support system is done for the header, then take from the new_seq_num not from the seq_num
	 					pstmt_order_format_hdr_update.setString(10, ((String)orderFormatHdr.get("field_mnemonic"+i)));
						format_count =  pstmt_order_format_hdr_update.executeUpdate();
						if(format_count > 0)	status = true;
							else status = false;
					   if(!status) // If updation has failed, due to unavailability of record, it has to be 	inserted
					   {

							pstmt_order_format_hdr.clearParameters();
							pstmt_order_format_hdr.setString(1,order_id.trim());
							pstmt_order_format_hdr.setInt(2, Integer.parseInt(((String)orderFormatHdr.get("new_seq_num"+i))));  // Seq_num
							//pstmt_order_format_hdr.setInt(2, Integer.parseInt(((String)orderFormatHdr.get("seq_num"+i))));  // Seq_num
							// If decision support system is done for the header, then take from the new_seq_num not from the seq_num
							pstmt_order_format_hdr.setString(3,  ((String)orderFormatHdr.get("field_mnemonic"+i)));
							pstmt_order_format_hdr.setString(4,  ((String)orderFormatHdr.get("field_type"+i)));	// field_type
							pstmt_order_format_hdr.setString(5,  ((String)orderFormatHdr.get("label_text"+i)));						//order_label_text
							pstmt_order_format_hdr.setString(6,  ((String)orderFormatHdr.get("field_values"+i)));	//order_line_field_value
							pstmt_order_format_hdr.setString(7,  ((String)orderFormatHdr.get("accept_option"+i)));	//accept_option
							pstmt_order_format_hdr.setString(8,  ((String)tabData.get("login_by_id")));
							pstmt_order_format_hdr.setString(9,  ((String)tabData.get("login_at_ws_no")));
							pstmt_order_format_hdr.setString(10, ((String)tabData.get("login_facility_id")));
							pstmt_order_format_hdr.setString(11, ((String)tabData.get("login_by_id")));
							pstmt_order_format_hdr.setString(12, ((String)tabData.get("login_at_ws_no")));
							pstmt_order_format_hdr.setString(13, ((String)tabData.get("login_facility_id")));
							pstmt_order_format_hdr.addBatch();

							//format_count =  pstmt_order_format_hdr.executeUpdate();
							//if(format_count > 0)	status = true;
							//else status = false;
							//} // End of Status
				  	  	// Batch Updation cannot be done, because if updation failed(if there r no records) then insert has to be taken place --->pstmt_order_format_hdr.addBatch();
						//} // End of for order_format_count
				 int result_val[] = pstmt_order_format_hdr.executeBatch();
				// -2 done successful but does not have the count of row affected
				for (int i=0;i<result_val.length ;i++ )
				{
					if(result_val[i] != -2  && result_val[i] < 0)
					{
						status=false;
						break;
					}
					else status=true;
				}
		}catch ( Exception e ){
			System.err.println("Error updating/inserting order format HDR fields"+ e.toString());
			error_messages.setLength(0);
	  		error_messages.append( "Error updating/inserting order format HDR fields" +e.toString()) ;
	  		e.printStackTrace() ;
	  		status = false;
	  	}
		//closeStatement( pstmt_order_format_hdr ) ;
  		//closeStatement( pstmt_order_format_hdr_delete ) ;

  		return status;
  	} // End of updateFormatFields
*/
	// For the Order Format updation/Insertion in the Line level (Amend/Review)
/*  	private boolean updateFormatLineFields(HashMap mapOrderFormatDtl,HashMap tabData,String order_id,int order_line_num,String insert_query, String update_query) throws Exception{
  		PreparedStatement pstmt 		= null;
  		//PreparedStatement pstmt_update 	= null;
		boolean status = true;int seq_num = 0;
		int update_count = 0;
		try
		{
			int order_format_count 		= Integer.parseInt(checkForNull((String)mapOrderFormatDtl.get("order_format_count"),"0"));
			pstmt					 	= connection.prepareStatement(insert_query);
			//pstmt_update			 	= connection.prepareStatement(update_query);
			for(int i=0;i<order_format_count;i++)
			{
				//pstmt_update.clearParameters();
				if(status && !checkForNull((String)mapOrderFormatDtl.get("field_mnemonic"+i),"").equals(""))
				{
 					 pstmt_update.setString(1, ((String)mapOrderFormatDtl.get("field_values"+i)));	//order_line_field_value
					pstmt_update.setString(2, ((String)tabData.get("login_by_id")));
					pstmt_update.setString(3, ((String)tabData.get("login_at_ws_no")));
					pstmt_update.setString(4, ((String)tabData.get("login_facility_id")));
					pstmt_update.setString(5,order_id.trim());
					pstmt_update.setInt(6, order_line_num);
					//seq_num = Integer.parseInt(((String)mapOrderFormatDtl.get("seq_num"+i))); // To avoid unique constaint
					seq_num = Integer.parseInt(((String)mapOrderFormatDtl.get("new_seq_num"+i))); // To avoid unique constaint
					// If decision support system is done for the header, then take from the new_seq_num not from the seq_num
					pstmt_update.setInt(7, seq_num);  				// Seq_num
					pstmt_update.setString(8,  ((String)mapOrderFormatDtl.get("field_mnemonic"+i)));
					update_count = pstmt_update.executeUpdate();
					if(update_count > 0)	status = true;
					else 	status = false;
					// If no record, is there then insert into the table

					if(!status && !checkForNull((String)mapOrderFormatDtl.get("field_mnemonic"+i),"").equals(""))
					{

						pstmt.clearParameters();
						//int order_format_count 		= Integer.parseInt(checkForNull((String)mapOrderFormatDtl.get("order_format_count"),"0"));
						//for(int i=0;i<order_format_count;i++)
						//seq_num = Integer.parseInt(((String)mapOrderFormatDtl.get("seq_num"+i)))+10; //To avoid unique constaint
						seq_num = Integer.parseInt(((String)mapOrderFormatDtl.get("new_seq_num"+i)))+10; //To avoid unique constaint
						// If decision support system is done for the header, then take from the new_seq_num not from the seq_num
						pstmt.setString(1,order_id.trim());
						pstmt.setInt(2, order_line_num);
						pstmt.setString(3, "U");
						pstmt.setInt(4, seq_num);  				// Seq_num
						pstmt.setString(5,  ((String)mapOrderFormatDtl.get("field_mnemonic"+i)));
						pstmt.setString(6,  ((String)mapOrderFormatDtl.get("field_type"+i)));	// field_type
						pstmt.setString(7,  ((String)mapOrderFormatDtl.get("label_text"+i)));						//order_label_text
						pstmt.setString(8,  ((String)mapOrderFormatDtl.get("field_values"+i)));	//order_line_field_value
						pstmt.setString(9,  ((String)mapOrderFormatDtl.get("accept_option"+i)));	//accept_option
						pstmt.setString(10, ((String)tabData.get("login_by_id")));
						pstmt.setString(11, ((String)tabData.get("login_at_ws_no")));
						pstmt.setString(12, ((String)tabData.get("login_facility_id")));
						pstmt.setString(13, ((String)tabData.get("login_by_id")));
						pstmt.setString(14, ((String)tabData.get("login_at_ws_no")));
						pstmt.setString(15, ((String)tabData.get("login_facility_id")));
						update_count = pstmt.executeUpdate();
						if(update_count > 0)	status = true;
						else 	status = false;
						//pstmt.addBatch();
				//} // End of if status
			  } // End of if status
			} // End of for mapUniqueId
		}catch ( Exception e ){
				System.err.println("Error updating/insert into order format Line fields"+ e.toString());
				error_messages.setLength(0);
		  		error_messages.append( "Error updating/insert into order format Line fields" +e.toString()) ;
		  		e.printStackTrace() ;
		  		status = false;
		} finally {
			  	 closeStatement( pstmt ) ;
			 	 //closeStatement( pstmt_update ) ;
		}
  		return status;
  	} // End of updateFormatLineFields
*/
    // Updation Done here for the Hdr Level for or_order

/**
* @ejb.interface-method
*	 view-type="both"
*/

	private boolean updateAmendHeader(HashMap tabData, String order_id, String order_type_code, String order_format_values , String amend_update_query) throws Exception
	{
		PreparedStatement pstmt 		= null;
		boolean status					= true;
		int update_amend_count			= 0;
		try
		{
			if(status)
			{
				pstmt		= connection.prepareStatement(amend_update_query);
				pstmt.clearParameters();
				pstmt.setString(1, order_format_values);
				pstmt.setString(2, ((String)tabData.get("login_by_id")));
				pstmt.setString(3, ((String)tabData.get("login_at_ws_no")));
				pstmt.setString(4, ((String)tabData.get("login_facility_id")));
				pstmt.setString(5, order_id);
				pstmt.setString(6, order_type_code);
				update_amend_count =  pstmt.executeUpdate();
				if(update_amend_count > 0)	
					status = true;
				else 
					status = false;
			}
		}
		catch(Exception e)
		{
			error_messages.setLength(0);
  			error_messages.append( "Error Updating the Amend Hdr" +e.toString()) ;
			e.printStackTrace() ;
	  		status = false;
  		}
		finally
		{
	  			closeStatement( pstmt ) ;
		} // End of finally
  		return status;
    }  // End of updateAmendHeader

  	// Updation Done here for the Amend/Review Function for the Lines
  	private boolean updateAmendLine(HashMap hashMap, HashMap tabData,int amend_total_count,String order_id, String query,String format_insert_query, String format_delete_query) throws Exception
	{
		PreparedStatement pstmt 	= null; PreparedStatement pstmt_delete = null;
  		boolean status				= true;
  		String order_format_values = "";
  		String instrns				= "";  int amend_line_num = 0;
        HashMap mapOrderFormatDtl	= new HashMap();
	
  		try
  		{
  			if(status)
  			{
  				pstmt			= connection.prepareStatement(query);
  				pstmt.clearParameters();
  				for(int i = 0;i<amend_total_count;i++)
  				{
  					pstmt.setString(1,  ((String)hashMap.get("amend_order_type"+i)));
  					pstmt.setString(2,  ((String)hashMap.get("amend_duration_value"+i)));
  					pstmt.setString(3,  ((String)hashMap.get("amend_duration_code"+i)));

					String amend_frequency_code=((String)hashMap.get("amend_frequency_val"+i));
				
					StringTokenizer ammend=null;
					String amend_frequency="";
				if (!(amend_frequency_code==null) && !(amend_frequency_code.equals("")))
				{

					ammend=new StringTokenizer(amend_frequency_code,"~~");
					amend_frequency="";
					while(ammend.hasMoreTokens())
					{
						 amend_frequency=ammend.nextToken();

						 break;
					}
				}
				 
					pstmt.setString(4,  amend_frequency);
  					pstmt.setString(5,  ((String)hashMap.get("amend_quantity"+i)));
					pstmt.setString(6,  ((String)hashMap.get("amend_quantity"+i)));
					
					//IN64543, starts
					//pstmt.setString(7,  ((String)hashMap.get("amend_line_comments"+i)));
					if("T".equals((String)hashMap.get("amend_instrn_content_type"+i)))
					{
						pstmt.setString(7,  ((String)hashMap.get("amend_line_comments"+i)));
						pstmt.setString(13, null);
					}
					else if("E".equals((String)hashMap.get("amend_instrn_content_type"+i)))
					{
						pstmt.setString(7,  null);
						pstmt.setString(13,  ((String)hashMap.get("amend_line_comments"+i)));						
					}
					//IN64543, ends
                    /* if order formats are there update into the or_order_line table */
                    mapOrderFormatDtl = ((HashMap)hashMap.get("amend_format_line_values"+i));
					if(mapOrderFormatDtl!=null && mapOrderFormatDtl.size() > 1)	// If the Order Formats are there
					{
						order_format_values = ((String)mapOrderFormatDtl.get("order_format_values"));
						if(order_format_values!=null && order_format_values.length() > 500) order_format_values = order_format_values.substring(0,499);
						pstmt.setString(8, order_format_values);  // concatenate the order_formats -- line_fields_display_text
					}
					else
						pstmt.setString(8, null);		// line_fields_display_text
                    pstmt.setString(9,  ((String)hashMap.get("ordering_practitioner_id"))); // Amend_pract_id
  					pstmt.setString(10, ((String)tabData.get("login_by_id")));
					pstmt.setString(11, ((String)tabData.get("login_at_ws_no")));
					pstmt.setString(12, ((String)tabData.get("login_facility_id")));
					
					//IN068314 Starts
					
					pstmt.setString(14, ((String)hashMap.get("fpp_yn"+i)));
					pstmt.setString(15, ((String)hashMap.get("fpp_category"+i)));
					//IN068314 Ends
					//IN64543, starts
					//pstmt.setString(13, ((String)hashMap.get("amend_order_id")));
					//pstmt.setString(14, ((String)hashMap.get("amend_order_line_num"+i)));
					//IN068314 Starts
					//pstmt.setString(14, ((String)hashMap.get("amend_order_id")));
					//pstmt.setString(15, ((String)hashMap.get("amend_order_line_num"+i)));
					pstmt.setString(16, ((String)hashMap.get("amend_order_id")));
					pstmt.setString(17, ((String)hashMap.get("amend_order_line_num"+i)));
					//IN068314 Ends
					//IN64543, ends
					pstmt.addBatch();

					// To be passed to the bean  back for the OA Appointment Booking
					// Do not call for the Multi Patient Orders
					// pass the line no as 0, have to be taken from the amend_order_line_num
					// pass the last parameter as "NEW" to differentiate it is coming from new or amend order
					getAppointment(hashMap, i, order_id, 0, "AMEND");  // Appointment logic building
				} // End of for
				int result_val[] = pstmt.executeBatch();
				// -2 done successful but does not have the count of row affected
				for (int i=0;i<result_val.length ;i++ )
				{
					if(result_val[i] !=-2 && result_val[i] < 0) // -3 if it fails
					{
						status=false;
						break;
					}
					else 
						status=true;
				} // End of for
		    }	// End of if status
		    // Do the updation for the preps and dept if present
		    if(status)
		    {
				// Delete the record blindly, if any
				// Deletion query for preps, depts, patient instructions
				if(mapOrderFormatDtl!=null && mapOrderFormatDtl.size() > 0)	// If the Order Formats are there 
				{//IN051151
					pstmt_delete	= connection.prepareStatement(format_delete_query);
					pstmt_delete.clearParameters();
					pstmt_delete.setString(1, order_id);
					// do not check it  has been deleted or not
					pstmt_delete.executeUpdate();
					//int count = pstmt_delete.executeUpdate();

 		    		for(int i = 0;i<amend_total_count;i++)
		    		{
		    			amend_line_num = Integer.parseInt(checkForNull((String)hashMap.get("amend_order_line_num"+i),"0"+i));
		    			String amend_instrn_content_type = checkForNull((String)hashMap.get("amend_instrn_content_type"+i),"T");//IN64543
						order_id = ((String)hashMap.get("amend_order_id"));
			    		if(status)
			    		{
							if(!(checkForNull((String)hashMap.get("amend_line_preps"+i),"").equals("")))
							{
								instrns = checkForNull((String)hashMap.get("amend_line_preps"+i),"");
								//status  = insertFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num,"PREPS",instrns,format_insert_query);//IN64543
								status  = insertFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num,"PREPS",instrns,format_insert_query,amend_instrn_content_type);//IN64543
								//status = updateFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num,"PREPS",instrns,format_insert_query,format_update_query);
							}
							// Call a udpateFormatLineInstns method to insert the Depts. Instn
							if(status)
							{
								if(!(checkForNull((String)hashMap.get("amend_line_dept_instrn"+i),"").equals("")))
								{
									instrns = checkForNull((String)hashMap.get("amend_line_dept_instrn"+i),"");
									//status	= insertFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num+1,"DEPTS",instrns,format_insert_query);//IN64543
									status	= insertFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num+1,"DEPTS",instrns,format_insert_query,amend_instrn_content_type);//IN64543
									//status = updateFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num+1,"DEPTS",instrns,format_insert_query,format_update_query);
error_messages.append("result amend depts"+status);
								}
								if(status)
								{	// To update the Patients Instruction
									if(!(checkForNull((String)hashMap.get("amend_line_pat_instrn"+i),"").equals("")))
									{
										instrns = checkForNull((String)hashMap.get("amend_line_pat_instrn"+i),"");
										//status = updateFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num+2,"PATIENT_INSTRN",instrns,format_insert_query,format_update_query);
										//status  = insertFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num+2,"PATIENT_INSTRN",instrns,format_insert_query);//IN64543
										status  = insertFormatLineInstns(tabData,order_id,amend_line_num,amend_line_num+2,"PATIENT_INSTRN",instrns,format_insert_query,amend_instrn_content_type);//IN64543
error_messages.append("result amend depts"+status);
									}
								}
							}
						} // End of if status
			    	} // End of for i
				} // End of  mapOrderFormatDtl (if it is there in the bean, otherwise no need to delete and insert
			} // End of if status
			// Till here
		}
		catch(Exception e)
		{
			error_messages.setLength(0);
  			error_messages.append( "Error Updating the Amend Lines" +e.toString()) ;
			e.printStackTrace() ;
			status = false;
		}
		finally
		{
			closeStatement( pstmt ) ;
			closeStatement( pstmt_delete);
		}
		return status;
	}

  // Update into the Preps Instruction(Amend/Review)
/*	private boolean updateFormatLineInstns(HashMap tabData,String order_id,int line_num,int seq_no,String mnemonic,String instrn_value,String insert_query,String update_query) throws Exception
	{	// hashMap will be used for Flex Fields
		PreparedStatement pstmt 	= null;
		boolean status 				= true;int result_flex_fields = 0;
		try
		{
			if(status)  // One record per line
			{
				pstmt		= connection.prepareStatement(update_query);
				pstmt.clearParameters();
				pstmt.setString(1, instrn_value);
				pstmt.setString(2, ((String)tabData.get("login_by_id")));
				pstmt.setString(3, ((String)tabData.get("login_at_ws_no")));
				pstmt.setString(4, ((String)tabData.get("login_facility_id")));

				pstmt.setString(5,order_id.trim());
				pstmt.setInt(6,line_num);
				pstmt.setInt(7,seq_no);
			if(mnemonic.equalsIgnoreCase("PREPS"))		//order_line_field_mnemonic
 				pstmt.setString(8,"PAT_PREPS_TEXT");
 			else if(mnemonic.equalsIgnoreCase("DEPTS"))
 				pstmt.setString(8,"DEPT_INSTRNS");
			else if(mnemonic.equalsIgnoreCase("PATIENT_INSTRN"))
 				pstmt.setString(8,"PATIENT_INSTRNS");

				result_flex_fields = pstmt.executeUpdate();
				if(result_flex_fields > 0 ) status = true; else status = false;
				closeStatement( pstmt ) ;
			}  // End of if status

			// If value is not there, then insert into the table
			if(!status)  // One record per line
			{
				pstmt		= connection.prepareStatement(insert_query);
				pstmt.clearParameters();
 				pstmt.setString(1,order_id.trim());
 				pstmt.setInt(2,line_num);
 				pstmt.setString(3,"U");
 				pstmt.setInt(4,seq_no);
 				if(mnemonic.equalsIgnoreCase("PREPS"))		//order_line_field_mnemonic
 					pstmt.setString(5,"PAT_PREPS_TEXT");
 				else if(mnemonic.equalsIgnoreCase("DEPTS"))
 					pstmt.setString(5,"DEPT_INSTRNS");
				else if(mnemonic.equalsIgnoreCase("PATIENT_INSTRN"))
	 				pstmt.setString(5,"PATIENT_INSTRNS");
 				pstmt.setString(6,"A");	// For Dept and Presps
 				if(mnemonic.equalsIgnoreCase("PREPS")) // For Preps Instrns.//order_line_label_text
 					pstmt.setString(7,"Patient Preps");
 				else if(mnemonic.equalsIgnoreCase("DEPTS")) // For Depts. Instrns.
 					pstmt.setString(7,"Dept.Instructions");
				else if(mnemonic.equalsIgnoreCase("PATIENT_INSTRN")) // For Depts. Instrns.
 					pstmt.setString(7,"Patient Instructions");
 				pstmt.setString(8,instrn_value);
 				pstmt.setString(9,"O");
 				pstmt.setString(10, ((String)tabData.get("login_by_id")));
				pstmt.setString(11, ((String)tabData.get("login_at_ws_no")));
				pstmt.setString(12, ((String)tabData.get("login_facility_id")));
				pstmt.setString(13, ((String)tabData.get("login_by_id")));
				pstmt.setString(14, ((String)tabData.get("login_at_ws_no")));
				pstmt.setString(15, ((String)tabData.get("login_facility_id")));
				result_flex_fields = pstmt.executeUpdate();
				if(result_flex_fields > 0 ) status = true; else status = false;
				closeStatement( pstmt ) ;
			} // end of if !status
	 	}catch ( Exception e ){
			System.err.println("Error updating the preps/depts fields"+ e.toString());
			error_messages.setLength(0);
	  		error_messages.append( "Error updating the preps/depts fields" +e.toString()) ;
	  		e.printStackTrace() ;
	  		status = false;
	  	} finally {
  			closeStatement( pstmt ) ;
	  	} // End of finally
  		return status;
  	} // End of updateFormatLineInstns
*/

  	// Individual Tables Insertion (Laboratory)

/**
* @ejb.interface-method
*	 view-type="both"
*/

	 private boolean insertLaboratory(HashMap tabData, HashMap hashMap, HashMap mapSpecimenNo,  HashMap mapcollectStage, int row_value, String order_id, int order_line_num, String insert_lb_query, String insert_specimen_with_no, String insert_specimen_without_no) throws Exception 
	{
	
  		PreparedStatement pstmt_lab_insert	= null;
		CallableStatement cstmt 			= null;
   		String specimen_no_rule				= "", specimen_no		  = "";
  		//String lb_install_yn 				= "";changed on 7/12/2007 by uma
		String coll_label_gen_rule = "";
		String collection_stage				= "";
		String labchk="";
		boolean status 						= false;
		String l_collection_remarks = "Collected by Nurse while ordering";//IN065295

		try
		{
			// From the HashMap get the specimen No and coll_label_gen_rule for the corresponding order_id
			specimen_no_rule 	= checkForNull(((String)mapSpecimenNo.get(order_id.trim())),"");
			collection_stage	= checkForNull(((String)hashMap.get("collection_stage"+row_value)),"");
			int result  = 0 ;//IN041371
			if(!specimen_no_rule.equals(""))
			{
				coll_label_gen_rule	= specimen_no_rule.substring(0,1); // Get the coll_label_gen_rule
				specimen_no 	    = specimen_no_rule.substring(3,specimen_no_rule.length()); // Get the Specimen No.
			}
			//IN041371 - Start
			if((checkForNull((String)hashMap.get("function_from"),"").equalsIgnoreCase("AMEND_ORDER")) && collection_stage.equals("N") && coll_label_gen_rule.equalsIgnoreCase("G") && !specimen_no.equals("X") && !specimen_no.equals(""))
			{
				pstmt_lab_insert				= connection.prepareStatement("INSERT INTO or_order_line_lb(order_id,order_line_num,specimen_type,coll_label_gen_rule,coll_label_gen_date_time,specimen_collect_yn,specimen_collect_date_time,specimen_collected_by,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id, specimen_reqd_yn,coll_reqd_yn,dispatch_reqd_yn,specimen_dispatch_yn,specimen_dispatch_date_time,specimen_dispatched_by,specimen_dispatch_mode,SPECIMEN_COLLECT_REMARKS,SPECIMEN_DISPATCH_REMARKS) VALUES(?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,SYSDATE,?,?,?,SYSDATE,?,?, ?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?) ");
			}
			else
			{
				pstmt_lab_insert				= connection.prepareStatement(insert_lb_query);
			}
			//IN041371 - End
			pstmt_lab_insert.setString(1,order_id.trim());		// order_id
 			pstmt_lab_insert.setInt(2, order_line_num);		// order_line_num
 			pstmt_lab_insert.setString(3,  checkForNull(((String)hashMap.get("specimen_type"+row_value)),"")); // specimen_type
 			pstmt_lab_insert.setString(4,  coll_label_gen_rule);	// coll_label_gen_rule
 			pstmt_lab_insert.setString(5,  null);	// coll_label_gen_rule date/time
 			pstmt_lab_insert.setString(6,  checkForNull(((String)hashMap.get("nurse_collect"+row_value)),"N"));	// Specimen_collect_yn
 			//it's been placed here coz if any ofthe condition is satisfied it will overwrite the present COLL_REQ_YN....
			pstmt_lab_insert.setString(16, checkForNull((String)mapcollectStage.get(order_id+"COLLECTION_STAGE") ,"N")); //COLL_REQD_YN
			pstmt_lab_insert.setString(19, null);//IN065295
			pstmt_lab_insert.setString(20, null);//IN065295
			if(coll_label_gen_rule.equalsIgnoreCase("G"))
 				pstmt_lab_insert.setString(7,  ((String)hashMap.get("sys_date")));	// At present for specimen_collect_date_time
 			else
 				pstmt_lab_insert.setString(7,  null);	// At present for specimen_collect_date_time

			if(!collection_stage.equals("") && collection_stage.equals("With Order"))
			{
				//IN065295, starts
				/*
				pstmt_lab_insert.setString(6,  "Y"); // for specimen_collect_yn
				pstmt_lab_insert.setString(7,  ((String)hashMap.get("order_date_time")));//for specimen_collect_date_time
				pstmt_lab_insert.setString(8,  ((String)tabData.get("login_by_id")));//specimen_collected_by
				pstmt_lab_insert.setString(16, "Y"); //COLL_REQD_YN
				*/

				if(checkForNull(((String)hashMap.get("nurse_collect"+row_value)),"N").equals("Y") && coll_label_gen_rule.equalsIgnoreCase("G"))
				{

					pstmt_lab_insert.setString(5,  ((String)hashMap.get("order_date_time")));
					pstmt_lab_insert.setString(6,  "Y"); // for specimen_collect_yn
					pstmt_lab_insert.setString(7,  ((String)hashMap.get("order_date_time")));//for specimen_collect_date_time
					pstmt_lab_insert.setString(8,  ((String)tabData.get("login_by_id")));//specimen_collected_by
					pstmt_lab_insert.setString(16, "Y"); //COLL_REQD_YN
					pstmt_lab_insert.setString(19, l_collection_remarks);
				}
				else if(checkForNull(((String)hashMap.get("nurse_collect"+row_value)),"N").equals("Y") && !coll_label_gen_rule.equalsIgnoreCase("G"))
				{

					pstmt_lab_insert.setString(6,  "Y"); // for specimen_collect_yn
					pstmt_lab_insert.setString(7,  ((String)hashMap.get("order_date_time")));//for specimen_collect_date_time
					pstmt_lab_insert.setString(8,  ((String)tabData.get("login_by_id")));//specimen_collected_by
					pstmt_lab_insert.setString(16, "Y"); //COLL_REQD_YN
					pstmt_lab_insert.setString(19, l_collection_remarks);
				}
				else
				{

					pstmt_lab_insert.setString(6, "N");
					pstmt_lab_insert.setString(8,  null);
					pstmt_lab_insert.setString(16, "Y"); //COLL_REQD_YN
				}//IN065295
			}			
			/*else{
			//	pstmt_lab_insert.setString(8,  null);	// At present for specimen_collected_by
				pstmt_lab_insert.setString(16, checkForNull((String)mapcollectStage.get(order_id+"COLLECTION_STAGE") ,"N")); //COLL_REQD_YN
			}*/else	if(!collection_stage.equals("") && collection_stage.equals("Separate"))
			{
				pstmt_lab_insert.setString(6,  "N"); // for specimen_collect_yn
				pstmt_lab_insert.setString(7,  null);	// for specimen_collect_date_time
				pstmt_lab_insert.setString(8,  null);	// for specimen_collected_by
			}
			else if(collection_stage.equals("") || collection_stage.equals("Not Required"))
			{
				pstmt_lab_insert.setString(6,  "N"); // for specimen_collect_yn
				pstmt_lab_insert.setString(7,  null);	// for specimen_collect_date_time
				pstmt_lab_insert.setString(8,  null);	// for specimen_collected_by
			}/*Added by Uma on 10/5/2009 for coll_label_gen_rule !G and collection_stage with order*/
			else if(!collection_stage.equals("") && collection_stage.equals("With Order") && !coll_label_gen_rule.equalsIgnoreCase("G"))
			{

				pstmt_lab_insert.setString(6,  "N"); // for specimen_collect_yn
				pstmt_lab_insert.setString(7,  null);	// for specimen_collect_date_time
				pstmt_lab_insert.setString(8,  null);	// for specimen_collected_by
			}/*Added by Uma Ends Here*/
			else
			{
				pstmt_lab_insert.setString(8,  null);
			}
 			pstmt_lab_insert.setString(9,  ((String)tabData.get("login_by_id")));
			pstmt_lab_insert.setString(10, ((String)tabData.get("login_at_ws_no")));
			pstmt_lab_insert.setString(11, ((String)tabData.get("login_facility_id")));
			pstmt_lab_insert.setString(12, ((String)tabData.get("login_by_id")));
			pstmt_lab_insert.setString(13, ((String)tabData.get("login_at_ws_no")));
			pstmt_lab_insert.setString(14, ((String)tabData.get("login_facility_id")));
			pstmt_lab_insert.setString(15, checkForNull(((String)hashMap.get("specimen_reqd_yn"+row_value)),"N")); // SPECIMEN_REQD_YN
		//	pstmt_lab_insert.setString(16, checkForNull((String)mapcollectStage.get(order_id+"COLLECTION_STAGE") ,"N")); //COLL_REQD_YN
			pstmt_lab_insert.setString(17, checkForNull((String)mapcollectStage.get(order_id+"DISPATCH_REQD_YN") ,"N")); //DISPATCH_REQD_YN
			pstmt_lab_insert.setString(18, "N"); //SPECIMEN_DISPATCH_YN

			//IN041371 - Start
			if((checkForNull((String)hashMap.get("function_from"),"").equalsIgnoreCase("AMEND_ORDER")) && collection_stage.equals("N") && coll_label_gen_rule.equalsIgnoreCase("G") && !specimen_no.equals("X") && !specimen_no.equals(""))
			{
				String[] lborder_data = getLBtabDetails(order_id);
				pstmt_lab_insert.setString(4,  checkForNull(lborder_data[0],""));
				pstmt_lab_insert.setString(5,  checkForNull(lborder_data[1],""));
				pstmt_lab_insert.setString(6,  checkForNull(lborder_data[2],""));
				pstmt_lab_insert.setString(7,  checkForNull(lborder_data[3],""));
				pstmt_lab_insert.setString(8,  checkForNull(lborder_data[4],""));
				pstmt_lab_insert.setString(15,  checkForNull(lborder_data[5],""));
				pstmt_lab_insert.setString(16,  checkForNull(lborder_data[6],""));
				pstmt_lab_insert.setString(17,  checkForNull(lborder_data[8],""));	
				pstmt_lab_insert.setString(18,  checkForNull(lborder_data[9],""));	
				pstmt_lab_insert.setString(19,  checkForNull(lborder_data[10],""));	
				pstmt_lab_insert.setString(20,  checkForNull(lborder_data[11],""));	
				pstmt_lab_insert.setString(21,  checkForNull(lborder_data[12],""));	
				pstmt_lab_insert.setString(22,  checkForNull(lborder_data[7],""));	
				pstmt_lab_insert.setString(23,  checkForNull(lborder_data[13],""));	
			}
			//IN041371 - End
			result = pstmt_lab_insert.executeUpdate();
			
			if(result > 0 ) status = true; else status = false;
			labchk=checkForNull(getmoduleRL((String)hashMap.get("catalog_code"+row_value),(String)hashMap.get("order_category"+row_value),(String)hashMap.get("order_type"+row_value),(String)tabData.get("login_facility_id")),"");
			
			//lb_install_yn 	= checkForNull((String)hashMap.get("lb_instal_yn"),"N");changed on 7/10/2007 for lb_instal_yn by uma
			if(status)
			{
				//if(lb_install_yn.equalsIgnoreCase("Y"))changed on 7/10/2007 for lb_instal_yn by uma
				if((checkForNull( labchk,"").equalsIgnoreCase("IBARL")))
				{
					if(coll_label_gen_rule.equalsIgnoreCase("G")) // Call a procedure if the lab is installed & coll_label_gen_rule = 'G'
					{
						 cstmt = connection.prepareCall("{ "+insert_specimen_with_no+" }");
						 cstmt.setString(1, checkForNull(((String)hashMap.get("catalog_code"+row_value)),""));  // CATALOG_CODE
						 cstmt.setString(2, checkForNull((String)hashMap.get("performing_facility_id"+row_value),"")); // PERFORMING_FACILITY_ID
						 cstmt.setString(3, order_id.trim()); 							 						// ORDER_ID
						 cstmt.setString(4, checkForNull(((String)hashMap.get("order_type"+row_value)),""));    // ORDER_TYPE_CODE
						 cstmt.setString(5, specimen_no);	 													// SPECIMEN_NO
						 cstmt.setString(6, "N");																// INTERVAL_TEST_YN
						 cstmt.setString(7,((String)tabData.get("login_facility_id")));//DineshT
						 cstmt.setString(8, ((String)tabData.get("login_at_ws_no")));  //----[IN041340]
						 cstmt.execute();
						 closeStatement( cstmt ) ;
					}
					else if (coll_label_gen_rule.equalsIgnoreCase("P") || coll_label_gen_rule.equalsIgnoreCase("X"))
					{
						cstmt = connection.prepareCall("{ "+insert_specimen_without_no+" }");
						cstmt.setString(1, checkForNull(((String)hashMap.get("catalog_code"+row_value)),""));  // CATALOG_CODE
						cstmt.setString(2, checkForNull((String)hashMap.get("performing_facility_id"+row_value),"")); // PERFORMING_FACILITY_ID
						cstmt.setString(3, order_id.trim()); 							 						// ORDER_ID
						cstmt.setString(4, checkForNull(((String)hashMap.get("order_type"+row_value)),""));    // ORDER_TYPE_CODE
						cstmt.setString(5, "N");	
						cstmt.execute();
						closeStatement( cstmt ) ;
					}
				} 
				else 
				{ // Else if lab is not installed
					if(coll_label_gen_rule!=null && coll_label_gen_rule.equalsIgnoreCase("G")) 
					{ // Set it in a global Hashtable, then it has to be printed
						if(!print_specimen_values.containsValue(order_id.trim())) 
						{
							print_specimen_values.put("order_id"+specimen_count, order_id.trim());	 // order_id
							print_specimen_values.put("source_type"+specimen_count, checkForNull((String)hashMap.get("location_type"),""));	 // source_type
							print_specimen_values.put("source_code"+specimen_count, checkForNull((String)hashMap.get("location_code"),""));	 // source_code
							print_specimen_values.put("priority"+specimen_count, checkForNull((String)hashMap.get("priority"+row_value),""));	 // priority
							print_specimen_values.put("order_type_code"+specimen_count, checkForNull((String)hashMap.get("order_type"+row_value),""));	 // order_type_code
							print_specimen_values.put("patient_class"+specimen_count, checkForNull((String)hashMap.get("patient_class"),""));	 // patient_class
							print_specimen_values.put("facility_id"+specimen_count, ((String)tabData.get("login_facility_id")));   // facility_id
							specimen_count++;
						}
					} // end of coll_label_gen_rule 'G'
				} // end of Lab not installed
				
				//IN065295, starts

				if(checkForNull(((String)hashMap.get("nurse_collect"+row_value)),"N").equals("Y") && coll_label_gen_rule.equalsIgnoreCase("G") &&  !"".equals(collection_stage) && "With Order".equals(collection_stage))
				{
					status = updateLabOrders(order_id.trim(), order_line_num);
				}
				//IN065295, ends
				
				insertDrugInteractionLB( tabData,  hashMap,order_id,order_line_num,row_value,checkForNull(((String)hashMap.get("catalog_code"+row_value)),""));//IN071260//IN072654
			} // End of status
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
			error_messages.append( "Error inserting Individual Tables LB" +e.toString()) ;
			e.printStackTrace() ;
			status = false;
		} 
		finally 
		{
			closeStatement( pstmt_lab_insert ) ;
 			closeStatement( cstmt ) ;
	  	} // End of finally
  		return status;
  	 } // End of method insertLaboratory


	 // Call a procedure to insert the RLNeonatal
	private boolean insertRLNeonatal(HashMap tabData, HashMap hashMap, HashMap mapSpecimenNo, String order_type, String performing_facility_id, String order_id, String insert_rl_neonates) throws Exception 
	{
		CallableStatement cstmt 	= null;
		boolean status 				= true;
		String mother_patient_id	= "", mother_patient_name	= "";
		String specimen_no			= "0";
		try
		{ 	 // Call a procedure to execute the Neonate procedure.
			String specimen_no_rule = checkForNull((String)mapSpecimenNo.get(order_id.trim()),"");
			if(!specimen_no_rule.equals("") && specimen_no_rule.length() > 2)
			{
 				specimen_no 	    = specimen_no_rule.substring(3,specimen_no_rule.length()); // Get the Specimen No.
				if(specimen_no==null || specimen_no.equals("") || specimen_no.equals("X"))
				   specimen_no		= "0";
			}
			specimen_no				= checkForNull(specimen_no,"0");
 			 mother_patient_id			= checkForNull((String)hashMap.get("mother_patient_id"+order_type),"");
			 mother_patient_name		= checkForNull((String)hashMap.get("mother_patient_name"+order_type),"");

			if(!mother_patient_id.equals("") || !mother_patient_name.equals("")) 
			{
				cstmt = connection.prepareCall("{ "+insert_rl_neonates+" }");

				 cstmt.setString(1, checkForNull((String)tabData.get("login_facility_id"),""));					// I_ORDERING_FACILITY_ID
				 cstmt.setString(2, checkForNull(performing_facility_id,""));  // PERFORMING_FACILITY_ID
				 cstmt.setString(3, order_id.trim()); 				// I_ORDER_ID
				 cstmt.setString(4, checkForNull(order_type,"")); 				// I_ORDER_TYPE_CODE
				 cstmt.setString(5, mother_patient_id); 			// I_PATIENT_ID
				 cstmt.setString(6, mother_patient_name); 			// I_NN_PATIENT_NAME
				// cstmt.setInt(7, Integer.parseInt(specimen_no));	// I_BABY_SPEC_NO
				cstmt.setLong(7, Long.parseLong(specimen_no));	// I_BABY_SPEC_NO

				cstmt.execute();
				closeStatement( cstmt );
			} // End of mother_patient_id & mother_patient_name != ""
		}
		catch ( Exception e )
		{
			status = false;
			error_messages.setLength(0);
			error_messages.append( "Error inserting insertRLNeonatal Procedure" +e.toString()) ;
			e.printStackTrace() ;
		}
		finally 
		{
			closeStatement( cstmt ) ;
		}
		return status;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

  	 // Individual Tables Insertion (Radiology)
	private boolean insertRadiology(HashMap tabData,HashMap hashMap, int row_value, String order_id,int order_line_num,String insert_rd_query) throws Exception 
	{
		PreparedStatement pstmt = null;
		boolean status 			= false;
		try
		{
			pstmt				= connection.prepareStatement(insert_rd_query);
			pstmt.setString(1,order_id.trim());
			pstmt.setInt(2, order_line_num);
			pstmt.setString(3, checkForNull(((String)hashMap.get("pregnant_yn"+row_value)),"N"));	// At present for pregnant_yn
			pstmt.setString(4, checkForNull(((String)hashMap.get("lmp_date"+row_value)),""));	// At present for LMP Date
			pstmt.setString(5,  ((String)tabData.get("login_by_id")));
			pstmt.setString(6,  ((String)tabData.get("login_at_ws_no")));
			pstmt.setString(7,  ((String)tabData.get("login_facility_id")));
			pstmt.setString(8,  ((String)tabData.get("login_by_id")));
			pstmt.setString(9,  ((String)tabData.get("login_at_ws_no")));
			pstmt.setString(10, ((String)tabData.get("login_facility_id")));
	 		pstmt.setString(11, checkForNull(((String)hashMap.get("study_loc"+row_value)),""));	// Study Loc
			int result = pstmt.executeUpdate();
			if(result > 0 ) 
				status = true; 
			else 
				status = false;
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
			error_messages.append( "Error inserting Individual Tables RD" +e.toString()) ;
			e.printStackTrace() ;
			status = false;
		} 
		finally 
		{
			closeStatement( pstmt ) ;
		}
		return status;
	} 

  	 // Individual Tables Insertion (Radiology Dept)
/**
* @ejb.interface-method
*	 view-type="both"
*/

	private boolean insertRadiologyDept(HashMap tabData,HashMap hashMap,int row_value,String order_id,int order_line_num,String insert_rx_query) throws Exception 
	{
	 	PreparedStatement pstmt = null;
	 	boolean status 			= false;
	 	try
	 	{
	 		pstmt				= connection.prepareStatement(insert_rx_query);
	 		pstmt.setString(1,order_id.trim());
	 	  	pstmt.setInt(2, order_line_num);
	 	  	pstmt.setString(3,  null);  // At present for Pregnant_yn
	 	  	pstmt.setString(4,  null);  // At present for lmp_date
	 	  	pstmt.setString(5,  checkForNull(((String)hashMap.get("study_loc"+row_value)),""));	// Study Loc
	 	  	pstmt.setString(6,  ((String)tabData.get("login_by_id")));
	 	 	pstmt.setString(7,  ((String)tabData.get("login_at_ws_no")));
	 	 	pstmt.setString(8,  ((String)tabData.get("login_facility_id")));
	 	 	pstmt.setString(9,  ((String)tabData.get("login_by_id")));
	 	 	pstmt.setString(10, ((String)tabData.get("login_at_ws_no")));
	 	 	pstmt.setString(11, ((String)tabData.get("login_facility_id")));
	 	 	int result = pstmt.executeUpdate();
	 	 	if(result > 0 ) 
				status = true; 
			else 
				status = false;
	 	}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	 	 	error_messages.append( "Error inserting Individual Tables RX" +e.toString()) ;
	 	 	e.printStackTrace() ;
	 	 	status = false;
	 	} 
		finally 
		{
			closeStatement( pstmt ) ;
	 	} // End of finally
	 	return status;
  	 } // End of method insertRadiologyDept

  	  // Individual Tables updation (Radiology) Amend Orders
/**
* @ejb.interface-method
*	 view-type="both"
*/

	private boolean updateRadiology(HashMap tabData,HashMap hashMap,int amend_total_count, String update_rd_query, String update_rx_query) throws Exception 
	{
		boolean status 				= true;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt_rx  = null;
		int result				    = 0;
		try
		{
			if(status)
			{
					pstmt		= 	connection.prepareStatement(update_rd_query);
					pstmt_rx	= 	connection.prepareStatement(update_rx_query);
				for(int i = 0;i<amend_total_count;i++)
				{	// Only for RD or RX , others no need to update

					if( status && (checkForNull((String)hashMap.get("amend_order_category"+i),"").equals("RD") || checkForNull((String)hashMap.get("amend_order_category"+i),"").equals("RX")) ) //Only if RD or RX, enter into the loop
					{
						if( checkForNull((String)hashMap.get("amend_order_category"+i),"").equals("RD") ) 
						{
							pstmt.clearParameters();
							pstmt.setString(1, checkForNull(((String)hashMap.get("pregnant_yn"+i)),"N"));	// At present for pregnant_yn
							pstmt.setString(2, checkForNull(((String)hashMap.get("lmp_date"+i)),""));	// At present for LMP Date
							pstmt.setString(3, checkForNull(((String)hashMap.get("study_loc"+i)),""));	// Study Loc
							pstmt.setString(4,  ((String)tabData.get("login_by_id")));
							pstmt.setString(5,  ((String)tabData.get("login_at_ws_no")));
							pstmt.setString(6,  ((String)tabData.get("login_facility_id")));
							pstmt.setString(7,  ((String)hashMap.get("amend_order_id")));
							pstmt.setString(8,  ((String)hashMap.get("amend_order_line_num"+i)));
							result = pstmt.executeUpdate();
						} 
						else if(checkForNull((String)hashMap.get("amend_order_category"+i),"").equals("RX") ) {
							pstmt_rx.clearParameters();
							pstmt_rx.setString(1, checkForNull(((String)hashMap.get("pregnant_yn"+i)),"N"));	// At present for pregnant_yn
							pstmt_rx.setString(2, checkForNull(((String)hashMap.get("lmp_date"+i)),""));	// At present for LMP Date
							pstmt_rx.setString(3, checkForNull(((String)hashMap.get("study_loc"+i)),""));	// Study Loc
							pstmt_rx.setString(4,  ((String)tabData.get("login_by_id")));
							pstmt_rx.setString(5,  ((String)tabData.get("login_at_ws_no")));
							pstmt_rx.setString(6,  ((String)tabData.get("login_facility_id")));
							pstmt_rx.setString(7,  ((String)hashMap.get("amend_order_id")));
							pstmt_rx.setString(8,  ((String)hashMap.get("amend_order_line_num"+i)));
							result = pstmt_rx.executeUpdate();
						}
						if(result > 0 ) 
							status = true; 
						else 
							status = false;
					} // End of RD or RX
				} // End of for int i
			} // End of if status
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
			error_messages.append( "Error updating Individual Tables RD or RX" +e.toString()) ;
			e.printStackTrace() ;
			status = false;
		} 
		finally 
		{
			closeStatement( pstmt ) ;
			closeStatement( pstmt_rx ) ;
		}
		return status;
  	 }

/**
* @ejb.interface-method
*	 view-type="both"
*/

	// Update the CP/CA Table, ca_pat_task_list if  Order Entry has been called from CP/CA
	private boolean updateCP(HashMap tabData, HashMap hashMap, String patient_id,String order_id, String cp_update_query) throws Exception
	{
		PreparedStatement pstmt 		= null;
		boolean status					= true;
		int update_cp_count			= 0;
		try
		{
			if(status)
			{
				pstmt		= connection.prepareStatement(cp_update_query);
				pstmt.clearParameters();
				pstmt.setString(1, checkForNull((String)hashMap.get("ordering_practitioner_id"),""));  //performed_by_id
				pstmt.setString(2, "Order is Placed On : "+ checkForNull((String)hashMap.get("sys_date"),"") +"Order Id :- "+ order_id);	//remarks
				pstmt.setString(3,  ((String)tabData.get("login_by_id")));		// modified_by_id
				pstmt.setString(4,  ((String)tabData.get("login_at_ws_no")));	// modified_at_ws_no
				pstmt.setString(5,  ((String)tabData.get("login_facility_id")));	//modified_facility_id
				pstmt.setString(6,  "P");	//status ('P' --> Performed)

				pstmt.setString(7,  patient_id);
				pstmt.setString(8,  checkForNull((String)hashMap.get("task_code"),""));
				pstmt.setString(9,  checkForNull((String)hashMap.get("task_srl_no"),""));
				update_cp_count =  pstmt.executeUpdate();
				if(update_cp_count > 0)	
					status = true;
				else 
					status = false;
			} // End of if status
		}
		catch(Exception e)
		{
			error_messages.setLength(0);
  			error_messages.append( "Error Updating the CP table CA_PAT_TASK_LIST" +e.toString()) ;
			e.printStackTrace() ;
			status = false;
		}
		finally
		{
	  			closeStatement( pstmt ) ;
		} // End of finally
  		return status;
    }  // End of updateCP


/**
* @ejb.interface-method
*	 view-type="both"
*/

	 // Update the MO Table, mo_mortuary_regn if  Order Entry has been called from MO
	private boolean updateMO(HashMap tabData, HashMap hashMap, int row_value,String order_id, String mo_update_query) throws Exception
	{	
 	 PreparedStatement pstmt 		= null;
     boolean status					= true;
     int update_mo_count			= 0;
		try
		{
          if(status)
          {
				//pstmt		= connection.prepareStatement(mo_update_query);
				pstmt		= connection.prepareStatement("UPDATE mo_mortuary_regn set postmortem_status = 'R', pm_requested_by = ?,modified_by_id =?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? AND registration_no = ?");
				pstmt.clearParameters();
				pstmt.setString(1, checkForNull((String)hashMap.get("ordering_practitioner_id"),""));  //pm_requested_by
				//pstmt.setString(2, checkForNull(((String)hashMap.get("order_date_time")),""));  //ORD_DATE_TIME
				//pstmt.setString(3, checkForNull(order_id,""));  //order_id
				//pstmt.setString(4, checkForNull(((String)hashMap.get("catalog_code"+row_value)),""));
				pstmt.setString(2, ((String)tabData.get("login_by_id")));		// modified_by_id
				pstmt.setString(3, ((String)tabData.get("login_at_ws_no")));	   // modified_at_ws_no
				pstmt.setString(4, ((String)tabData.get("login_facility_id"))); //modified_facility_id

				pstmt.setString(5, ((String)tabData.get("login_facility_id")));
				//IN030279 Start.
				//pstmt.setString(9, checkForNull((String)hashMap.get("task_code"),""));
				pstmt.setString(6, checkForNull((String)hashMap.get("registration_no"),""));
				//IN030279 End.	
				if("A".equals(checkForNull(((String)hashMap.get("postmortem_status")),"N"))){  // As per sudhakara Rao Amajala Request
					update_mo_count =  pstmt.executeUpdate();
				}else{								// As per sudhakara Rao Amajala Request
					update_mo_count = 1;			// As per sudhakara Rao Amajala Request
				}									// As per sudhakara Rao Amajala Request
				if(update_mo_count > 0)	
					status = true;
				else 
					status = false;
          } // End of if status
        }
		catch(Exception e)
		{
			error_messages.setLength(0);
  			error_messages.append( "Error Updating the MO table MO_MORTUARY_REGN" +e.toString()) ;
			e.printStackTrace() ;
	  		status = false;
  		}
  		finally
		{
	  			closeStatement( pstmt ) ;
		} // End of finally
  		return status;
    }  // End of updateMO

/**
* @ejb.interface-method
*	 view-type="both"
*/

	// Insertion done in the postmorterm_regn table, if MO module is installed and patient is deceased and record is there in mo-parameter and catalog matches with the order_catalog, then insert a record
	private boolean insertMoMortuaryRegn(HashMap tabData, HashMap hashMap, int row_value, String order_id, int order_line_num, String patient_id, String mo_catalog_select, String mo_order_for_postmorterm_count, String mo_order_for_postmorterm_insert) throws Exception
	{
 	 PreparedStatement pstmt 			= null;
	 PreparedStatement pstmt_mo_count	= null;
	 PreparedStatement pstmt_mo_insert	= null;
	 ResultSet resultSet 				= null;
	 ResultSet resultSet_count			= null;
     boolean status						= true;
     int postmorterm_count				= 0;
	 int mo_insert_count				= 0;
	 String order_catalog_code_cl_pm	= "", order_catalog_code_ml_pm ="";

		try
		{
           if(status)
          {
			   pstmt		= connection.prepareStatement(mo_catalog_select);
			   pstmt.clearParameters();
			   pstmt.setString(1, ((String)tabData.get("login_facility_id")));
			   resultSet	= pstmt.executeQuery();
			   if(resultSet!=null)
			   {
					while(resultSet.next())   // only one record
					{
 						order_catalog_code_cl_pm	= checkForNull(resultSet.getString("order_catalog_code_cl_pm"),"" );
 						order_catalog_code_ml_pm	= checkForNull(resultSet.getString("order_catalog_code_ml_pm"),"" );
					}
				}
				if(order_catalog_code_cl_pm.equals(checkForNull((String)hashMap.get("catalog_code"+row_value),"")) || order_catalog_code_ml_pm.equals(checkForNull((String)hashMap.get("catalog_code"+row_value),"")) ) 
				{
				   pstmt_mo_count		= connection.prepareStatement(mo_order_for_postmorterm_count);
				   pstmt_mo_count.clearParameters();
				   pstmt_mo_count.setString(1, checkForNull(patient_id,""));  //patient_id
				   pstmt_mo_count.setString(2, checkForNull((String)hashMap.get("catalog_code"+row_value),""));  //catalog_code
				   resultSet_count	= pstmt_mo_count.executeQuery();
				   if(resultSet_count!=null)
				   {
						while(resultSet_count.next())   // only one record
						{
							 postmorterm_count = resultSet_count.getInt(1);
						}
				   }
					if(postmorterm_count == 0) 
					{  // If it is >0 , the insert into the postmoterm table
  						pstmt_mo_insert = connection.prepareStatement(mo_order_for_postmorterm_insert);
						pstmt_mo_insert.clearParameters();
					    pstmt_mo_insert.setString(1, checkForNull(((String)tabData.get("login_facility_id")),""));  //facility_id
					    pstmt_mo_insert.setString(2, checkForNull(patient_id,""));  //patient_id
						pstmt_mo_insert.setString(3, checkForNull(order_id,""));  //patient_id
						pstmt_mo_insert.setString(4, checkForNull(((String)hashMap.get("order_date_time")),""));  //order_date_time
					    pstmt_mo_insert.setString(5, checkForNull((String)hashMap.get("ordering_practitioner_id"),""));  //practitioner_id
						pstmt_mo_insert.setString(6, checkForNull((String)hashMap.get("catalog_code"+row_value),""));  //order_catalog_code
						pstmt_mo_insert.setInt(7,  order_line_num);	// order_line_num
					    pstmt_mo_insert.setString(8, checkForNull((String)hashMap.get("order_status_code"+row_value),""));  //order_line_status
						pstmt_mo_insert.setString(9,  ((String)tabData.get("login_by_id")));
						pstmt_mo_insert.setString(10, ((String)tabData.get("login_at_ws_no")));
						pstmt_mo_insert.setString(11, ((String)tabData.get("login_facility_id")));
						pstmt_mo_insert.setString(12, ((String)tabData.get("login_by_id")));
						pstmt_mo_insert.setString(13, ((String)tabData.get("login_at_ws_no")));
						pstmt_mo_insert.setString(14, ((String)tabData.get("login_facility_id")));
						mo_insert_count = pstmt_mo_insert.executeUpdate();
						if(mo_insert_count > 0 ) 
							status = true; 
						else 
							status = false;
				  	}  // End of postmorterm_count > 0
					}  // End of postmorterm_count > 0
			  } //When the catalogs are same
          } // End of if status
		catch(Exception e)
		{
			error_messages.setLength(0);
  			error_messages.append( "Error Inserting the MO table MO_MORTUARY_REGN" +e.toString()) ;
			e.printStackTrace() ;
	  		status = false;
  		}
  		finally
		{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_count ) ;
	  			closeStatement( pstmt ) ;
	  			closeStatement( pstmt_mo_count ) ;
	  			closeStatement( pstmt_mo_insert ) ;
		} // End of finally
  		return status;
    }  // End of insertMoMortuaryRegn

/**
* @ejb.interface-method
*	 view-type="both"
*/

  	 // Billing Procedure at the Line Level for Amend or New Order
	 /*Modified by Uma on 1/18/2010 for IN017420 for cont_order_yn*/
  	 private String[] callBillingLineLevel(HashMap tabData,HashMap hashMap,String called_from , String bill_query_string, String row,String order_id,  String patient_id, String encounter_id,int order_line_num, int care_set_count,String order_set_status_query,String update_order_set_status,String update_order_set_line_status,String order_set_status_query_code,String cont_order_yn) throws Exception 
	{
	    CallableStatement cstmt 		= null ;
		PreparedStatement pstmt		=null;
		ResultSet rs							=null;
		String  error_message			= "";	//boolean result = true;
		String  auth_consent_approv_yn	= "N";	String special_approved = "false";
		String  order_set_auth_consent_approv_yn	= "N";
		String  authorized				= "false";
		String  charge_type_code		= "";
		String[] billing_line_result	= new String[2];
		HashMap bill_dtls				= null;
		String incl_excl_action			= "";
		String incl_excl_action_orginal			= "";
		String incl_excl_action_reason	= "";
		String bl_panel_str				= "";
		String fpp_yn				= "";//IN068314
		String fpp_category				= "";//IN068314
		String p_total_amt				= "";
		String Future_order_yn				= "";
		String order_set_status_type="";
		String order_set_status_type_code="";
		if(order_set_status_query==null) 
			order_set_status_query="";
		String mod_physician_id        = "";

		try
		{
			if((called_from.equals("ORDER_SET_BILLING"))||(called_from.equals("ORDER_SET_BILLING_AMEND")))
			 {
				if(!order_set_status_query.equals(""))
				 {
					pstmt=connection.prepareStatement(order_set_status_query);
					pstmt.setString(1,checkForNull(order_id.trim(),""));
					rs=pstmt.executeQuery();
					while(rs.next())
					 {
						order_set_status_type=rs.getString("order_set_status");
					 }
					closeStatement(pstmt);
					closeResultSet(rs);
					pstmt=connection.prepareStatement(order_set_status_query_code);
					pstmt.setString(1,order_set_status_type);
					rs=pstmt.executeQuery();
					while(rs.next())
					 {
						order_set_status_type_code=rs.getString("order_status_type");
					 }
				 }
				 closeStatement(pstmt);
				 closeResultSet(rs);
				 if(order_set_status_type_code==null) order_set_status_type_code="";
				 pstmt=connection.prepareStatement(update_order_set_status);
				 pstmt.setString(1,order_set_status_type.trim());
				 pstmt.setString(2,order_id.trim());
				 pstmt.executeUpdate();
				 closeStatement(pstmt);
				 pstmt=connection.prepareStatement(update_order_set_line_status);
				 pstmt.setString(1,order_set_status_type.trim());
				 pstmt.setString(2,order_id.trim());
				 pstmt.setString(3,"1");
				 pstmt.executeUpdate();
				closeStatement(pstmt);

				if(order_set_status_type_code.equals("00")||order_set_status_type_code.equals("03")||order_set_status_type_code.equals("05"))
				 {
						order_set_auth_consent_approv_yn="Y";
				 }
				 else
				 {
						order_set_auth_consent_approv_yn="N";
				 }
			 }
			 if(checkForNull(((String)hashMap.get("ord_consent_reqd_yn"+row)),"N").equals("Y") && (!called_from.equals("AMEND_ORDER")) && checkForNull(((String)hashMap.get("consent_stage"+row)),"").equalsIgnoreCase("A"))
			     auth_consent_approv_yn = "Y";
			  else
			     auth_consent_approv_yn = "N";

			 if(care_set_count > 0)  // For Care Set Orders
				 authorized			= checkForNull((String)hashMap.get("care_set_authorized"+row),"false");
			 else
			 	authorized			= checkForNull((String)hashMap.get("authorized"),"false");

			  special_approved		= checkForNull((String)hashMap.get("special_approved"),"false");

			 if(checkForNull(((String)hashMap.get("ord_spl_appr_reqd_yn"+row)),"N").equals("Y") && auth_consent_approv_yn=="N" && (!called_from.equals("AMEND_ORDER")) && (!called_from.equals("ORDER_SET_BILLING"))&&(!called_from.equals("ORDER_SET_BILLING_AMEND")))
			 {
			 	 if(special_approved.equalsIgnoreCase("true") )
			 	     auth_consent_approv_yn = "N";
			 	else
			 	    auth_consent_approv_yn 	= "Y";
			 }

			if(checkForNull(((String)hashMap.get("ord_auth_reqd_yn"+row)),"N").equals("Y") && auth_consent_approv_yn=="N" && (!called_from.equals("AMEND_ORDER")) && (!called_from.equals("ORDER_SET_BILLING"))&&(!called_from.equals("ORDER_SET_BILLING_AMEND")	))
			{
			 	 if(authorized.equalsIgnoreCase("true") )
			 	    auth_consent_approv_yn = "N";
			 	else
			 	    auth_consent_approv_yn = "Y";
			}

			// As per Kuila's requirement, it is commented.
			//if(called_from.equals("AMEND_ORDER"))   // Only for modified catalog codes
			//   auth_consent_approv_yn = "Y";

			cstmt = connection.prepareCall("{ "+bill_query_string+" }");
			cstmt.setString(1,  ((String)tabData.get("login_facility_id")));								// LOGIN_FACILITY_ID
			cstmt.setString(2,  patient_id);																// PATIENT_ID

			//cstmt.setString(2,  ((String)hashMap.get("patient_id")));										// PATIENT_ID

			if(called_from.equals("AMEND_ORDER")) // Amend Order
			{
				cstmt.setString(3,  checkForNull((String)hashMap.get("encounter_id"),""));					// ENCOUNTER_ID
			}
			else
			{
				cstmt.setString(3,  checkForNull(encounter_id,""));											// ENCOUNTER_ID
			}
			cstmt.setString(4,  ((String)hashMap.get("patient_class")));									// PATIENT_CLASS
			cstmt.setString(5,  order_id);																	// ORDER_ID
			cstmt.setString(6,  String.valueOf(order_line_num));											// ORDER_LINE_NUM
			if(called_from.equals("AMEND_ORDER")) // Amend Order
			{
				cstmt.setString(7,  ((String)hashMap.get("amend_catalog_code"+row)));
				cstmt.setString(8,  ((String)hashMap.get("amend_cat_desc"+row)));
				cstmt.setString(9,  ((String)hashMap.get("amend_start_date_time"+row)));
				cstmt.setString(10, ((String)hashMap.get("amend_quantity"+row)));
				bill_dtls = ((HashMap)hashMap.get("amend_billing_revise_dtls"+row));
			}// CATALOG_CODE
			else	if(called_from.equals("ORDER_SET_BILLING"))
			{
				cstmt.setString(7,  ((String)hashMap.get("care_set_catalog_code")));
				cstmt.setString(8,  ((String)hashMap.get("care_set_catalog_desc")));
				cstmt.setString(9,  ((String)hashMap.get("sys_date")));
				cstmt.setString(10, "1");
				bill_dtls = ((HashMap)hashMap.get("billing_revise_order_set_dtls"));
			}
			else	if(called_from.equals("ORDER_SET_BILLING_AMEND"))
			{
				cstmt.setString(7,  ((String)hashMap.get("care_set_catalog_code")));
				cstmt.setString(8,  ((String)hashMap.get("care_set_catalog_desc")));
				cstmt.setString(9,  ((String)hashMap.get("bill_dateString")));
				cstmt.setString(10, "1");
				bill_dtls = ((HashMap)hashMap.get("billing_revise_order_set_dtls"));
			}
			else
			// New Orders
			{
				cstmt.setString(7,  ((String)hashMap.get("catalog_code"+row)));
				cstmt.setString(8,  ((String)hashMap.get("cat_desc"+row)));
				cstmt.setString(9,  ((String)hashMap.get("start_date_time"+row)));
				cstmt.setString(10, ((String)hashMap.get("quantity"+row)));									// SERV_QTY
				bill_dtls = ((HashMap)hashMap.get("billing_revise_dtls"+row));
			}// CATALOG_CODE

			/*if(called_from.equals("AMEND_ORDER")) // Amend Order
											// CATALOG_DESC
			else	// New Orders or Order set
												// CATALOG_DESC

			if(called_from.equals("AMEND_ORDER")) // Amend Order
								// START_DATE_TIME
			else // New Orders or Order set
										// START_DATE_TIME

			if(called_from.equals("AMEND_ORDER")) // Amend Order
										// SERV_QTY
			else  // New Orders or Order set


			if(called_from.equals("AMEND_ORDER")) // Amend Order

			else	// New Orders or Order set

				*/

			if(bill_dtls != null)
			{
				//p_total_amt		 = (String)bill_dtls.get("total_payable");
				p_total_amt		 = (String)bill_dtls.get("rate");
				incl_excl_action		 = (String)bill_dtls.get("incl_excl_action");
				incl_excl_action_orginal	 = (String)bill_dtls.get("incl_excl_action_orginal");
				Future_order_yn	 = (String)bill_dtls.get("Future_order_yn");
				if(incl_excl_action.equals(incl_excl_action_orginal))
				{
					incl_excl_action="";
				}
				else
				{
					incl_excl_action		 = (String)bill_dtls.get("incl_excl_action");
					//incl_excl_action		 = "";
				}
				incl_excl_action_reason	 = (String)bill_dtls.get("incl_excl_action_reason");
				//incl_excl_action_reason	 ="";
				bl_panel_str			 = (String)bill_dtls.get("bl_panel_str");
				fpp_yn	=(String)bill_dtls.get("fpp_yn");//IN068314
				fpp_category	=(String)bill_dtls.get("fpp_category");//IN068314
				mod_physician_id		 = bill_dtls.get("mod_physician_id")==null?"":(String)bill_dtls.get("mod_physician_id");
			}
			cstmt.setString(11, p_total_amt);	// p_charge_based_amt			
			if (mod_physician_id.equals(""))
			{
				cstmt.setString(12, ((String)hashMap.get("ordering_practitioner_id")));	
			}
			else
			{
				cstmt.setString(12, mod_physician_id);	
			}
			cstmt.setString(13 ,  incl_excl_action);														// P_OVERRIDDEN_EXCL_INCL_IND
			cstmt.setString(14 ,  incl_excl_action_reason);													// P_ACTION_REASON_CODE
			cstmt.setString(15 ,  bl_panel_str);															// P_STR
			if(called_from.equals("AMEND_ORDER")) // Amend Order
			{
				if(((String)hashMap.get("amend_appt_reqd_yn"+row)).equalsIgnoreCase("Y"))
				{
					cstmt.setString(16, checkForNull(((String)hashMap.get("FUTURE_ORDER_CHARGE_LATER_YN"+row)),""));		
				}
				else
				{
					cstmt.setString(16 ,  ((String)hashMap.get("future_order_YN"+row)));															// P_FUTURE_ORDER_YN
				}
			}
			else if(called_from.equals("ORDER_SET_BILLING")||called_from.equals("ORDER_SET_BILLING_AMEND"))
			{
				cstmt.setString(16 , "N");															// P_FUTURE_ORDER_YN
			}
			else
			{
				if(cont_order_yn.equalsIgnoreCase("CR")|| cont_order_yn.equalsIgnoreCase("DR"))
				{
					cstmt.setString(16 , "N");		
				}
				else
				{
					if(((String)hashMap.get("appt_reqd_yn"+row)).equalsIgnoreCase("Y"))
					{
						cstmt.setString(16, checkForNull(((String)hashMap.get("FUTURE_ORDER_CHARGE_LATER_YN"+row)),""));		
					}
					else
					{
						cstmt.setString(16 ,  ((String)hashMap.get("future_order_YN"+row)));															// P_FUTURE_ORDER_YN
					}
				}
			}
			if(called_from.equals("ORDER_SET_BILLING")||called_from.equals("ORDER_SET_BILLING_AMEND"))
			{
				cstmt.setString(17 , "N");															// P_FUTURE_ORDER_CHARGE_LATER_YN
			}
			else
			{
				if(cont_order_yn.equalsIgnoreCase("CR")||cont_order_yn.equalsIgnoreCase("DR"))
				{
					cstmt.setString(17 , "N");		
				}
				else
				{
					cstmt.setString(17, checkForNull(((String)hashMap.get("FUTURE_ORDER_CHARGE_LATER_YN"+row)),""));								// P_FUTURE_ORDER_CHARGE_LATER_YN
				}
			}

			  if((called_from.equals("ORDER_SET_BILLING"))||(called_from.equals("ORDER_SET_BILLING_AMEND")))
			 {
				cstmt.setString(18, order_set_auth_consent_approv_yn);													// AUTH_CONSENT_APPROV_YN
			 }
			 else
			{
				cstmt.setString(18, auth_consent_approv_yn);
			}
			if(called_from.equals("AMEND_ORDER")||called_from.equals("ORDER_SET_BILLING")||called_from.equals("ORDER_SET_BILLING_AMEND")) // Amend Order
			{
				cstmt.setString(19,"N");
			}
			else  // New Orders
			{
				cstmt.setString(19, (checkForNull(((String)hashMap.get("reg_reqd_yn"+row)),"N")));			// AUTO_REGISTER
			}

			if(called_from.equals("AMEND_ORDER")||called_from.equals("ORDER_SET_BILLING")||called_from.equals("ORDER_SET_BILLING_AMEND")) // Amend Order
			{
				cstmt.setString(20,"N");
			}
			else  // New Orders
			{
				cstmt.setString(20, (checkForNull(((String)hashMap.get("complete_on_order_yn"+row)),"N")));	// COMPLETE_ON_ORDER_YN
			}


			cstmt.setString(21, "N");																		// CANCEL_ON_ORDER_YN
			cstmt.setString(22, "N");																		// RESULT_ON_ORDER_YN
			if(checkForNull((String)hashMap.get("amend_order_id"),"").equals(order_id) && called_from.equals("AMEND_ORDER"))
			{
				cstmt.setString(23, "Y");	 // For Amend Orders											// AMEND_ON_ORDER_YN
			}
			else if (called_from.equals("ORDER_SET_BILLING_AMEND")){//11289 Starts
				cstmt.setString(23, "Y");	 // For Amend Orders											// AMEND_ON_ORDER_YN
			}//11289 Ends
			else
			{
				cstmt.setString(23, "N");																	// AMEND_ON_ORDER_YN
			}
			cstmt.setString(24, "N");																		// REGISTER_ON_ORDER_YN
			cstmt.setString(25, ((String)tabData.get("login_by_id")));										// USER
			cstmt.setString(26, ((String)tabData.get("login_at_ws_no")));									// WS_NO
			cstmt.registerOutParameter( 27,  Types.VARCHAR ) ;
			cstmt.registerOutParameter( 28,  Types.VARCHAR ) ;
			cstmt.setString(29, fpp_yn);//IN068314		
			cstmt.setString(30, fpp_category);	//IN068314	
			cstmt.execute();
			error_message 		= checkForNull(cstmt.getString(27),"");										// P_ERROR_MESSAGE
			charge_type_code 	= checkForNull(cstmt.getString(28),"");										// P_charge_type_code
			/*if(! error_message.equals("")){
				error_messages.setLength(0); messages.setLength(0);
				messages.append( error_message ) ;error_messages.append(error_message);
			} */
		}
		catch(Exception ex)
		{
			error_message =  ex.toString();
			ex.printStackTrace() ;
			error_messages.setLength(0);
			error_messages.append("Exception Billing Details"+ ex.toString());
			error_message	= ex.toString();// Send the string, so that it should roll_back
		}
		finally
		{
			closeStatement( cstmt ) ;
			billing_line_result[0] = charge_type_code;
			billing_line_result[1] = error_message;
			
		} // End of finally
		return billing_line_result;
	 } // End of callBillingLineLevel

/**
* @ejb.interface-method
*	 view-type="both"
*/

	// To get the orderable billed or not for the Billing
	private String[] callBillingLineLevelOrderableBilled(HashMap tabData, HashMap hashMap,String query, String completion_query, String message_query, String order_id,int order_line_num, int row) throws Exception
	{
		CallableStatement cstmt 	= null ;

		String charged_yn  		= "N" ;//	err_code	= "";
		String sys_message_id  	= "" ,	error_text	= "" , ord_cur_charge_stage = "";
		String[] result_bill	= new String[2];
			

		try
		{
				// Call this billing procedure for completion level
				// error_text, will be there after querying or got from the earlier procedure
			if(checkForNull(((String)hashMap.get("order_set_bill_yn")),"N").equals("Y"))
					ord_cur_charge_stage	=	"ORD";			// P_ORD_CUR_CHARGE_STAGE
			else if(checkForNull(((String)hashMap.get("complete_on_order_yn"+row)),"N").equals("Y"))
					ord_cur_charge_stage	=	"CMP";			// P_ORD_CUR_CHARGE_STAGE
			else
					ord_cur_charge_stage	=	"ORD";			// P_ORD_CUR_CHARGE_STAGE

				cstmt = connection.prepareCall("{ "+completion_query+" }");
 				cstmt.setString(1,  ((String)tabData.get("login_facility_id")));// P_FACILITY_ID
				cstmt.setString(2,  "OR");								// P_MODULE_ID
				cstmt.setString(3,  order_id);							// P_ORD_REGN_NUM
				cstmt.setInt(4,  order_line_num);						// P_ORD_REGN_LINE_NUM
				cstmt.setString(5,  ord_cur_charge_stage);				// P_ORD_CUR_CHARGE_STAGE
				if(checkForNull(((String)hashMap.get("order_set_bill_yn")),"N").equals("Y"))
				{
					cstmt.setString(6,checkForNull((String)hashMap.get("care_set_catalog_code"),"")); // P_ORD_ITEM_CODE
				}
				else
				{
					cstmt.setString(6,checkForNull((String)hashMap.get("catalog_code"+row),"")); // P_ORD_ITEM_CODE
				}
				cstmt.registerOutParameter( 7,  Types.VARCHAR ) ;	// P_ERR_CODE
				cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;	// P_ERROR_TEXT

				cstmt.execute();
				sys_message_id 	= checkForNull(cstmt.getString(7),"");
				error_text 		= checkForNull(cstmt.getString(8),"");
				if(!sys_message_id.equals("") )  //Query from the sm_message and display the message
				{
					// Query from the database for the message id and display the Message
					error_text 	= getErrMessage(sys_message_id, message_query);
					error_text	= checkForNull(error_text, "" );
				}
				closeStatement( cstmt ) ;

				//if(!error_text.equals("")){
			if(error_text.equals(""))
			{
					cstmt = connection.prepareCall("{ "+query+" }");
					cstmt.setString(1,  ((String)tabData.get("login_facility_id")));// LOGIN_FACILITY_ID
					cstmt.setString(2,  "OR");							// P_KEY_MODULE_ID
					cstmt.setString(3,  order_id);						// P_KEY_ID
					cstmt.setInt(4,  order_line_num);// P_KEY_LINE_NO
					cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;	// P_CHARGED_YN
					cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;	// P_ERR_CODE
					cstmt.registerOutParameter( 7,  Types.VARCHAR ) ;	// P_SYS_MESSAGE_ID
					cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;	// P_ERROR_TEXT

					cstmt.execute();

					charged_yn  	= checkForNull(cstmt.getString(5),"N");
					//err_code  		= checkForNull(cstmt.getString(6),"");
					sys_message_id 	= checkForNull(cstmt.getString(7),"");
					error_text 		= checkForNull(cstmt.getString(8),"");
					if(!sys_message_id.equals("") )  //Query from the sm_message and display the message
					{
						// Query from the database for the message id and display the Message
						error_text 	= getErrMessage(sys_message_id, message_query);
						error_text	= checkForNull(error_text, "" );
					}
				} // End of !error_text
		}
		catch(Exception ex)
		   {
			    ex.printStackTrace() ;
				error_messages.setLength(0);
				error_messages.append("Exception Billing Orderable Bill Details"+ ex.toString());
				error_text		= ex.toString();// Send the string, so that it should roll_back
		   }
		   finally
		   {
		    	closeStatement( cstmt ) ;
		   } // End of finally
		result_bill[0] = charged_yn;
		result_bill[1] = error_text;
			return 	result_bill;
	} // End of callBillingLineLevelOrderableBilled

/**
* @ejb.interface-method
*	 view-type="both"
*/

// Method used for OR_ORDER_LINE column billed_yn UPDATION FOR BILLING
	private boolean updateBilling(HashMap tabData, String ord_billed_yn, String order_id, int order_line_num, String update_query) throws Exception 
	{
	 boolean status 					= true;
		PreparedStatement pstmt_update 	= null;
		try
		{
			if(status)
			{
				
				pstmt_update			= 	connection.prepareStatement(update_query);
				pstmt_update.setString(1, checkForNull(ord_billed_yn,"N"));	  			// BILLED_YN
			  	pstmt_update.setString(2, ((String)tabData.get("login_by_id"))); 		// MODIFIED_BY_ID
			 	pstmt_update.setString(3, ((String)tabData.get("login_at_ws_no")));		// MODIFIED_AT_WS_NO
			 	pstmt_update.setString(4, ((String)tabData.get("login_facility_id")));	// MODIFIED_FACILITY_ID
				pstmt_update.setString(5, order_id);									// ORDER_ID
			  	pstmt_update.setString(6, String.valueOf(order_line_num));				// ORDER_LINE_NUM

				int result = pstmt_update.executeUpdate();
				if(result > 0 ) 
					status = true; 
				else 
					status = false;
			} // End of if status
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
		 	error_messages.append( "Error updating or_order_line billing" +e.toString()) ;
		 	e.printStackTrace() ;
		 	status = false;
		} 
		finally 
		{
		 	closeStatement( pstmt_update ) ;
		 } // End of finally
	return status;
  } // End of method updateBilling

/**
* @ejb.interface-method
*	 view-type="both"
*/

  // Used to build the hashmap for the COLLECTION_STAGE and DISPATCH_REQD_YN  field_mnemonic values to be inserted into the or_order_line_lb table (In the method insertLaboratory)
	private HashMap getCollection(int count, int count_patient, ArrayList multi_patient, HashMap hashMap, HashMap mapOrderId)
	{
	String order_id		   = "" , grouping  = "" , patient_id = "", encounter_id = "", split_grouping = "", order_type = "";
	int grouping_seq_no	   = 0;
	String record[]		   = null;
	HashMap mapCollection = new HashMap();
		try
		{
			patient_id		= checkForNull((String)hashMap.get("patient_id"),"");
			encounter_id	= checkForNull((String)hashMap.get("encounter_id"),"");
			for(int j=0;j<count_patient;j++)
			{	// Get the patient_id , if any for Multi Patient Details
				if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
				{
					record			= (String[]) multi_patient.get(j);
					patient_id		= checkForNull(record[0],""); //patient_id
					encounter_id	= checkForNull(record[1],""); //encounter_id
				}
				grouping_seq_no	= 0; // Before Initialize
				for(int i=0;i<count;i++)
				{
					if( (!(checkForNull((String)hashMap.get("rd_install_yn"),"N").equals("Y") && checkForNull((String)hashMap.get("order_category"+i),"CS").equals("RD")) )  && checkForNull((String)hashMap.get("appt_reqd_yn"+i),"N").equals("Y"))
					{
						grouping_seq_no++;  // Increase the counter, so that if appt_reqd_yn is there will go as an different order
						split_grouping	= splitGroupingOrders(grouping_seq_no); // call a method to get the split_grouping like "000" or "001" etc
					}
					else if(checkForNull((String)hashMap.get("chart_result_type"+i),"D").equals("P")) 
					{
						grouping_seq_no++; // Increase the counter,(For Treatment if procedure is there(P)) so that if chart_result_type is there will go as an different order
						split_grouping	= splitGroupingOrders(grouping_seq_no); // call a method to get the split_grouping like "000" or "001" etc
					}
					else
						split_grouping	= "000";
					order_type		= groupingOrderType((String)hashMap.get("order_category"+i), (String)hashMap.get("primary_order_type"), (String)hashMap.get("order_type"+i));

					String ord_authorise = "";	if((((String)hashMap.get("ord_auth_reqd_yn"+i)).equals("Y"))&&(((String)hashMap.get("authorised_yn"+i)).equals("N")))
					{
						ord_authorise = "Y";
					}
					else
					{
						ord_authorise = "N";
					}
					grouping		= (checkForNull((String)hashMap.get("performing_facility_id"+i),"^^"))+"~~"+order_type+"~~"+checkForNull(((String)hashMap.get("priority"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("ord_spl_appr_reqd_yn"+i)),"N")+"~~"+checkForNull(((String)hashMap.get("specimen_type"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("nurse_collect"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("start_date_time"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("frequency_val"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("duration_value"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("performing_dept_loc_code"+i)),"^^")+"~~"+checkForNull(((String)hashMap.get("splty_code"+i)),"^^")+"~~"+checkForNull(ord_authorise,"^^")+"~~"+split_grouping;
					//IN034830, starts
					if(((String)hashMap.get("ord_consent_reqd_yn"+i)).equalsIgnoreCase("Y"))
					{
						grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"consent_stage"+i);
						grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_form_id"+i),"consent_form_id"+i);
					}
					else
					{	
						//grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_stage"+i),"^^");//IN037633
					    //grouping = grouping +"~~"+checkForNull((String)hashMap.get("consent_form_id"+i),"^^");
						grouping = grouping +"~~^^~~^^";//emg for medicity - IN039775
					}
					//IN034830, ends
					//grouping = grouping +"~~"+checkForNull((String)hashMap.get("fpp_yn"+i),"^^")+"~~"+checkForNull((String)hashMap.get("fpp_category"+i),"^^"); //IN068314//10531

					order_id		= ((String)mapOrderId.get(grouping+patient_id+encounter_id));
					if(checkForNull((String)hashMap.get("collection_stage"+i),"").equals("Separate")) // System defined field_mnemonic value if Separate for  COLLECTION_STAGE (from the bean)
					mapCollection.put(order_id+"COLLECTION_STAGE" , "Y");  // Store Y Or N
					else
					{
						// Check if it is already exist in the HashMap or not...
						if(!checkForNull((String)mapCollection.get(order_id+"COLLECTION_STAGE"),"N").equals("Y")) // When it is not there or value is Y
						mapCollection.put(order_id+"COLLECTION_STAGE" , "N");  // Store Y Or N
					}
					if(checkForNull((String)hashMap.get("collection_stage"+i),"").equals("Not Required")) // System defined field_mnemonic value if Not Required for  COLLECTION_STAGE (from the bean)
					mapCollection.put(order_id+"DISPATCH_REQD_YN" , "N");  // Store Y Or N
					else
					{
						// Check if it is already exist in the HashMap or not...
						if(!(checkForNull((String)mapCollection.get(order_id+"DISPATCH_REQD_YN"),"").equals("N"))) 
						{// When it is not there or value is Y   if(!(checkForNull((String)mapCollection.get(order_id+"DISPATCH_REQD_YN"),"N").equals("N")))
							mapCollection.put(order_id+"DISPATCH_REQD_YN" , checkForNull((String)hashMap.get("dispatch_reqd_yn"+i),"N"));  // Store Y Or N	// then default with the screen values Y or N
                        }
					}
				} // end of if
			} // End of count_patient
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
			error_messages.append( "Error Getting in the getCollection"+  e.toString()) ;
			e.printStackTrace() ;
		}
	return mapCollection;
}

  // To get the message and display for the billing, if the message id is returned
	private String getErrMessage(String message_id, String query) throws Exception
	{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String message				= "";
		try
		{
			pstmt		= connection.prepareStatement(query);
			pstmt.clearParameters();
			//pstmt.setString(1,language_id);
			pstmt.setString(1, message_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet!=null)
			{
				while(resultSet.next())
				{
 					message	= checkForNull(resultSet.getString(1),"" );
				}
			}
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
			error_messages.append( "Error getting the Messages"+  e.toString()) ;
			e.printStackTrace() ;
		}
		finally 
		{
		 	closeResultSet( resultSet ) ;
		  	closeStatement( pstmt ) ;
	  	} // End of finally
		return message;
	} // End of getErrMessage

  	// To get the Action Seq Num For the Order Comments(Used for Amend/Review and New Orders)
	private int getActionSeqNum(String order_id,String query ) throws Exception
	{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int action_seq_num			= 0;
		try
		{
			pstmt		= connection.prepareStatement(query);
			pstmt.setString(1,order_id.trim());
			resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null) // Only One Record
			{
				if(resultSet.next() ) 
				{  // Only one record
					action_seq_num = resultSet.getInt(1);
				}
			}

			if(action_seq_num == 0 || resultSet == null) 
				action_seq_num = 1;
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
			error_messages.append( "Error getting the action seq num"+  e.toString()) ;
			e.printStackTrace() ;
		}
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		return action_seq_num;
	} 

/**
* @ejb.interface-method
*	 view-type="both"
*/

	/* Insertion from the table, replicate the old one with just replacing the new order_id
	 * and the other modified details as a New entry for the Amend (if it is going as a new order
   	   and the old one will be cancelled)
	 */
 	 private boolean insertAmendFormatLineFields(HashMap hashMap, HashMap tabData, String order_id ,int order_line_num, int row, String line_insert_query ) throws Exception{
		PreparedStatement pstmt 	= null;
		String amend_order_id		= "", amend_delete_line_num	= "";
		boolean status				= true;
		try
		{
			// Deletion to be done from the or_order_line_table
			pstmt				   = connection.prepareStatement(line_insert_query);
			amend_order_id 		   = checkForNull((String)hashMap.get("amend_order_id"),"");
 			if(!amend_order_id.equals("")) // If it is only new order, amend_order_id will be blank;
			{
				amend_delete_line_num  = checkForNull((String)hashMap.get("amend_delete_line_num"+row),"");
				if(!amend_delete_line_num.equals("")) 
				{ // That means only in amend & modified as a new one it is set
					pstmt.setString(1, order_id.trim());    // (new) order_id
					pstmt.setInt(2, order_line_num);        // (new) order_line_num
					pstmt.setString(3, (String)tabData.get("login_by_id"));
					pstmt.setString(4, ((String)tabData.get("login_at_ws_no")));
					pstmt.setString(5, ((String)tabData.get("login_facility_id")));
					// Where condition for the select query
					pstmt.setString(6, amend_order_id.trim());			// (ol) order_id
					pstmt.setString(7, amend_delete_line_num.trim());   // (old) order_line_num

						pstmt.executeUpdate(); // No need to check whether the record has been inserted or not, if it is not there also ok
				} // End of if amend_delete_line_num
			} // End of if amend_order_id
		}
		catch ( Exception e )
		{
			status = false;
			error_messages.setLength(0);
			error_messages.append( "Error Insertion in the insertAmendFormatLineFields"+  e.toString()) ;
			e.printStackTrace() ;
		}
		finally 
		{
			closeStatement( pstmt ) ;
	  	} // End of finally
  		return status;
	} // End of insertAmendFormatLineFields

	/**
* @ejb.interface-method
*	 view-type="both"
*/

	/* Insertion from the table, replicate the old one with just replacing the new order_id
	 * and the other modified details as a New entry for the Amend (if it is going as a new order
   	   and the old one will be cancelled) in the Order Format table
	 */
 	private boolean insertAmendFormatFields( HashMap tabData, String order_id , String amend_order_id,  String insert_query) throws Exception
	{
		PreparedStatement pstmt 	= null;
		boolean status				= true;
		try
		{
			// Deletion to be done from the or_order_line_table
			pstmt				   = connection.prepareStatement(insert_query);
			if(!amend_order_id.equals("")) // If it is only new order, amend_order_id will be blank;
			{
				pstmt.setString(1, order_id.trim());
				pstmt.setString(2, (String)tabData.get("login_by_id"));
				pstmt.setString(3, ((String)tabData.get("login_at_ws_no")));
				pstmt.setString(4, ((String)tabData.get("login_facility_id")));
				// Where condition for the select query
				pstmt.setString(5, amend_order_id.trim());			// (new) order_id
	   			pstmt.executeUpdate(); // No need to check whether the record has been inserted or not, if it is not there also ok
			}
		}
		catch ( Exception e )
		{
			status = false;
			error_messages.setLength(0);
			error_messages.append( "Error Insertion in the insertAmendFormatFields"+  e.toString()) ;
			e.printStackTrace() ;
		}
		finally 
		{
			closeStatement( pstmt ) ;
	  	} // End of finally
  		return status;
	} // End of insertAmendFormatFields

/**
* @ejb.interface-method
*	 view-type="both"
*/

	/* Deletion from the table, if required if the order_id has changed due to the changes
	 * This condition will arise, when the order has been amended, i.e the start_date_time
	 * or the frequency or the duration_code or the performing_location has been changed, and now
	 * it will go as an New Order , that time that particular order_line_num has to be deleted from
	 * the or_order_line table and if no other line no for that order_id in the line table,
	 * then in the header table or_order that particular order_id has to be deleted.
	 */
	 //private boolean deletionAmend(HashMap hashMap, int count , String line_delete_query, String line_count_query , String hdr_delete_query, String line_order_format_delete_query, String hdr_order_format_delete_query,String order_consent_draft_delete,String cn_login_by_id,String cn_login_at_ws_no,String cn_login_facility_id,String SQL_OR_BL_WITHOUT_ORDER_CATALOG) throws Exception//IN071315
 	//private boolean deletionAmend(HashMap hashMap, int count , String line_delete_query, String line_count_query , String hdr_delete_query, String line_order_format_delete_query, String hdr_order_format_delete_query,String order_consent_draft_delete,String cn_login_by_id,String cn_login_at_ws_no,String cn_login_facility_id,String SQL_OR_BL_WITHOUT_ORDER_CATALOG,String p_called_from_ca) throws Exception//IN071315
 	private boolean deletionAmend(HashMap hashMap, int count , String line_delete_query, String line_count_query , String hdr_delete_query, String line_order_format_delete_query, String hdr_order_format_delete_query,String order_consent_draft_delete,String cn_login_by_id,String cn_login_at_ws_no,String cn_login_facility_id,String SQL_OR_BL_WITHOUT_ORDER_CATALOG,String p_called_from_ca,String new_order_id,int order_line_num) throws Exception//IN071315//12123
	{
	 
		PreparedStatement pstmt 	= null, pstmt_amd_del = null;
		ResultSet resultSet 		= null;
		String amend_order_id		= "", amend_delete_line_num	= "";
		int count_order				= 0;
		boolean status				= true; //result=true;//46480

		PreparedStatement pstmt7 	= null;
		String bill_yn ="";
		String cont_order_ind ="";
		//String p_error_message			 = "";
		String p_subs_module_id		 = "";
		String p_subs_regn_num		 = "";
		String p_subs_regn_line_num = "";
		String p_err_code					 = "";
		String p_sys_message_id		 = "";
		String p_error_text				 = "";
	    String print_report_yn			 = "";
		//String p_print_report_yn			 = "";
		String p_error_code				 = "";
		String p_error_level				 = "";
		String p_err_text					 = "";
		String cancel_allow_yn					 = "";
		String print_billing_report_yn = "";
		//String cancel_allow_yn			 = "";

		ResultSet resultSet_bill = null;
		CallableStatement cstmt_sub_module_dtls = null;
		CallableStatement cstmt_cancel_allow_yn 	= null;
		CallableStatement cstmt_freq_order 	= null;
		PreparedStatement pstmt12 	= null;//IN067484
		ResultSet rs 				= null;//IN067484
		String login_prac_id = "";//IN067484
		String ext_appl_num_qry = "SELECT  EXT_APPL_ACCESSION_NUM FROM OR_ORDER_LINE WHERE ORDER_ID = ? and ORDER_LINE_NUM=?";//12123
		String update_ext_appl_num_qry = "update or_order_line set  EXT_APPL_ACCESSION_NUM=?,PARENT_ORDER_ID=?, PARENT_ORDER_LINE_NUM=? where ORDER_ID=? and order_line_num=?";//12123//12437
		String ext_appl_num = "";//12123
		try
		{
			// Deletion to be done from the or_order_line_table
			pstmt7 = connection.prepareStatement("select nvl(PRINT_BILLING_REPORT_YN,'N') print_billing_report_yn from or_param_by_facility where operating_facility_id=?");
			pstmt7.setString(1, cn_login_facility_id);
			resultSet = pstmt7.executeQuery();
			if (resultSet.next()) 
			{
				print_billing_report_yn	= resultSet.getString("print_billing_report_yn")==null?"N":resultSet.getString("print_billing_report_yn");
			}
			closeStatement(pstmt7) ;
			closeResultSet(resultSet) ;
			
			//IN067484 starts
			pstmt12						= connection.prepareStatement("SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = ?") ;//IN067484
			pstmt12.setString(1, cn_login_by_id.trim());
			rs = pstmt12.executeQuery();
			if (rs.next())
			{
				login_prac_id = rs.getString("FUNC_ROLE_ID");
			}
			closeStatement(pstmt12);
			closeResultSet(rs) ;
			//IN067484 ends

			//pstmt_amd_del          = connection.prepareStatement(order_consent_draft_delete);//added on 10/05/07
			//pstmt				   = connection.prepareStatement(line_delete_query);
			String amend_order_line_update = OrRepositoryExt.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_UPDATE");
			pstmt				   = connection.prepareStatement(amend_order_line_update);
			amend_order_id 		   = checkForNull((String)hashMap.get("amend_order_id"),"");

			//if(!amend_order_id.equals("")) // If it is only new order, amend_order_id will be blank; changed on 1/31/2008
			if((!amend_order_id.equals(""))) // If it is only new order, amend_order_id will be blank;
			{
				for(int i=0;i<count;i++)   // For Deletion in the Line Level.(or_order_line)
				{   // Get the Line_num
					amend_delete_line_num  = checkForNull((String)hashMap.get("amend_delete_line_num"+i),"");
			
					if(!amend_order_id.equals("")) 
					{
					   
						try
						{
							String bill_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
							pstmt7 = connection.prepareStatement(bill_sql) ;
							pstmt7.setString(1, amend_order_id);
							pstmt7.setString(2, amend_delete_line_num.trim());
							resultSet_bill = pstmt7.executeQuery();
							if (resultSet_bill.next()) 
							{
								bill_yn	= resultSet_bill.getString("bill_yn");
								cont_order_ind	= resultSet_bill.getString("cont_order_ind");
							}
							closeResultSet(resultSet_bill);
							closeStatement(pstmt7) ;
							//12123 Starts
							pstmt7 = connection.prepareStatement(ext_appl_num_qry);
							pstmt7.setString(1, amend_order_id);
							pstmt7.setString(2, amend_delete_line_num.trim());
							resultSet= pstmt7.executeQuery();
							if (resultSet.next()) 
							{
								ext_appl_num	= resultSet.getString("EXT_APPL_ACCESSION_NUM")==null?"":resultSet.getString("EXT_APPL_ACCESSION_NUM");
							}
							closeStatement(pstmt7) ;
							closeResultSet(resultSet);
							//12123 Ends
							if(bill_yn.equalsIgnoreCase("Y"))
							{
								if((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))
								{
									cstmt_freq_order = connection.prepareCall("{call OR_FREQ_ORD_CAN_DIS(?,?,?,?,?,?,?,?,?,?) }");
									
									cstmt_freq_order.setString(1, amend_order_id);										// P_ORDER_ID
									cstmt_freq_order.setString(2, amend_delete_line_num);						    // P_ORDER_LINE_NUM
									cstmt_freq_order.setString(3, cn_login_facility_id);									    // P_FACILITY_ID
									cstmt_freq_order.setString(4, "CAN");									    // P_mode
									cstmt_freq_order.setString(5, cn_login_by_id);									    // P_login_id
									cstmt_freq_order.setString(6, cn_login_at_ws_no);									    // P_ws_no
									cstmt_freq_order.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_PRINT_YN
									cstmt_freq_order.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERR_CODE
									cstmt_freq_order.registerOutParameter( 9,  Types.VARCHAR ) ; 	// P_SYS_MESSAGE_ID
									cstmt_freq_order.registerOutParameter( 10,  Types.VARCHAR ) ; 	// P_ERROR_TEXT					
									cstmt_freq_order.execute();

									print_report_yn	= cstmt_freq_order.getString(7)==null?"N":cstmt_freq_order.getString(7);						// P_PRINT_YN
									p_error_code	= cstmt_freq_order.getString(8)==null?"":cstmt_freq_order.getString(8);				// P_ERR_CODE
									p_sys_message_id	= cstmt_freq_order.getString(9)==null?"":cstmt_freq_order.getString(9);		// P_SYS_MESSAGE_ID
									p_err_text	= cstmt_freq_order.getString(10)==null?"":cstmt_freq_order.getString(10);				        // P_ERROR_TEXT
									
									if(p_error_code==null) p_error_code="";
									if(p_error_code.trim().equals(""))	
									{
										if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
										{
											 print_report_values.put("p_facility_id"+print_report_count,cn_login_facility_id);
											 print_report_values.put("p_order_id"+print_report_count,amend_order_id);
											 print_report_values.put("p_order_line_num"+print_report_count,amend_delete_line_num);
											 print_report_values.put("print_report_yn"+print_report_count,print_report_yn);
											 //map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
											 print_report_count++;
											 print_report_values.put("total_recs",String.valueOf(print_report_count)); 		
										}	
									}
									
									if(p_error_code==null) p_error_code="";
									if(p_err_text==null) p_err_text="";
									if(!p_err_text.trim().equals(""))
									{
										 error_messages.setLength(0);
										 error_messages.append(p_err_text) ;
										 status = false;
										 i = count;
									}
									else if(!p_error_code.trim().equals(""))		
									{
										 error_messages.setLength(0);
										 error_messages.append(p_error_code) ;
										
										 status = false;
										 i = count;
										
									}
									closeStatement(cstmt_freq_order);								
								}
								else
								{

									try
									{
										cstmt_sub_module_dtls			= connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_SEC_KEY_FOR_PRIM_KEY(?,?,?,?,?,?,?,?,?) }");
										cstmt_sub_module_dtls.setString(1,cn_login_facility_id);									    // P_FACILITY_ID
										cstmt_sub_module_dtls.setString(2, amend_order_id);										// P_ORDER_ID
										cstmt_sub_module_dtls.setString(3, amend_delete_line_num.trim());						    // P_ORDER_LINE_NUM
										cstmt_sub_module_dtls.registerOutParameter( 4,  Types.VARCHAR ) ; 	// P_SUBS_MODULE_ID
										cstmt_sub_module_dtls.registerOutParameter( 5,  Types.VARCHAR ) ; 	// P_SUBS_REGN_NUM
										cstmt_sub_module_dtls.registerOutParameter( 6,  Types.VARCHAR ) ; 	// P_SUBS_REGN_LINE_NUM
										cstmt_sub_module_dtls.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_ERR_CODE
										cstmt_sub_module_dtls.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_SYS_MESSAGE_ID	
										cstmt_sub_module_dtls.registerOutParameter( 9,  Types.VARCHAR ) ; 	// P_ERROR_TEXT
										cstmt_sub_module_dtls.execute();
										p_subs_module_id	= cstmt_sub_module_dtls.getString(4);						// P_SUBS_MODULE_ID
										p_subs_regn_num	= cstmt_sub_module_dtls.getString(5);						    // P_SUBS_REGN_NUM
										p_subs_regn_line_num	= cstmt_sub_module_dtls.getString(6);				    // P_SUBS_REGN_LINE_NUM
										p_err_code	= cstmt_sub_module_dtls.getString(7);				                    // P_ERR_CODE
										p_sys_message_id	= cstmt_sub_module_dtls.getString(8);				        // P_SYS_MESSAGE_ID
										p_error_text	= cstmt_sub_module_dtls.getString(9);				                    // P_ERROR_TEXT

										if((p_err_code!=null && p_err_code!="null" && !p_err_code.equals(""))&&(p_sys_message_id!=null && p_sys_message_id!="null" && !p_sys_message_id.equals("")))
										{
										}
										else
										{
											cstmt_cancel_allow_yn = connection.prepareCall("{ ? = call  BL_PROC_ITEM_VALIDATIONS_MP.IS_CANCEL_ORDER_ALLOWED_YN(?,?,?,?,?,?,?,?,?,?,?)}");
											cstmt_cancel_allow_yn.registerOutParameter(1,java.sql.Types.VARCHAR);
									   		cstmt_cancel_allow_yn.setString(2,cn_login_facility_id);
									   	    //IN071315 Starts
									   		//cstmt_cancel_allow_yn.setString(3,"OR");
									   		if("Y".equals(p_called_from_ca)){
									   			System.out.println("OROrderEntryManager.jaca:5950====>"+p_called_from_ca);
									   			cstmt_cancel_allow_yn.setString(3,"OR|CA");//IN071315
									   		}
									   		else{
									   			System.out.println("OROrderEntryManager.jaca:5954====>"+p_called_from_ca);
									   			cstmt_cancel_allow_yn.setString(3,"OR|OR");//IN071315
									   		}
									   		////IN071315 Ends
											cstmt_cancel_allow_yn.setString(4,amend_order_id);
											cstmt_cancel_allow_yn.setString(5,amend_delete_line_num.trim());
											cstmt_cancel_allow_yn.setString(6,p_subs_module_id);
											cstmt_cancel_allow_yn.setString(7,p_subs_regn_num);
											cstmt_cancel_allow_yn.setString(8,p_subs_regn_line_num);
											cstmt_cancel_allow_yn.registerOutParameter(9,java.sql.Types.VARCHAR);
											cstmt_cancel_allow_yn.registerOutParameter(10,java.sql.Types.VARCHAR);
											cstmt_cancel_allow_yn.registerOutParameter(11,java.sql.Types.VARCHAR);
											cstmt_cancel_allow_yn.registerOutParameter(12,java.sql.Types.VARCHAR);
										   	cstmt_cancel_allow_yn.execute();							
											cancel_allow_yn = cstmt_cancel_allow_yn.getString(1);	
											print_report_yn = cstmt_cancel_allow_yn.getString(9);	
											p_error_code = cstmt_cancel_allow_yn.getString(10);	
											p_error_level = cstmt_cancel_allow_yn.getString(11);	
											p_err_text = cstmt_cancel_allow_yn.getString(12);	
									  	}			
										print_report_yn = (print_report_yn==null)?"N":print_report_yn;
										p_error_code = (p_error_code==null)?"":p_error_code;
										p_error_level = (p_error_level==null)?"":p_error_level;
										p_error_text = (p_err_text==null)?"":p_err_text;
										cancel_allow_yn = (cancel_allow_yn==null)?"":cancel_allow_yn;
									}
									catch(Exception ce)
									{
										ce.printStackTrace();
									}
								}	
							}

							//print_report_yn = "Y";

							//map.put("print_report_yn",print_report_yn);
							if(p_error_code==null) p_error_code="";
							if(p_err_text==null) p_err_text="";
							if(!p_err_text.trim().equals(""))
							{
								error_messages.setLength(0);
								error_messages.append(p_err_text) ;
								status = false;
								i = count;
							}
							else if(!p_error_code.trim().equals(""))		
							{
								error_messages.setLength(0);
								error_messages.append(p_error_code) ;
								status = false;
								i = count;	
							}
							closeStatement(cstmt_sub_module_dtls);
							if(((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))||((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))&&(bill_yn.equalsIgnoreCase("Y")))||(bill_yn.equalsIgnoreCase("N")))
							{	
								if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
								{
									p_err_text=cancelBilling(amend_order_id,amend_delete_line_num,cn_login_by_id,cn_login_at_ws_no,cn_login_facility_id,SQL_OR_BL_WITHOUT_ORDER_CATALOG,p_called_from_ca);//IN071315
								}

								error_messages.append("cancel result"+p_err_text); //IN071315

							//added on 10/05/07

							/*pstmt_amd_del.setString(1, amend_order_id.trim());
							pstmt_amd_del.setString(2, amend_delete_line_num.trim());
							pstmt_amd_del.addBatch();*/
							//ends

							/*Modified by Uma on 3/2/2010 for IN019712*/
								if(p_err_text==null) p_err_text="";//IN071315	
								if("".equals(p_err_text)){//IN071315
								pstmt.setString(1, cn_login_by_id.trim());
								pstmt.setString(2, cn_login_at_ws_no.trim());
								pstmt.setString(3, cn_login_facility_id.trim());
								pstmt.setString(4, "Forced Cancel due to order parameter change");
								//pstmt.setString(5, cn_login_by_id.trim());//Commented for IN067484
								pstmt.setString(5, login_prac_id); //Modified for IN067484
								pstmt.setString(6, amend_order_id.trim());
								pstmt.setString(7, amend_delete_line_num.trim());
								/*Ends Here for IN019712*/
								pstmt.addBatch();
								}//IN071315
							}
							//IN071315 Starts
							if(!p_err_text.trim().equals(""))
							{
								error_messages.setLength(0);
								error_messages.append(p_err_text) ;
								status = false;
								i = count;
							}
							//IN071315 Ends
							//12123 Starts
							//if(status && !"".equals(ext_appl_num)){//12437
							if(status){//12437
								pstmt7 = connection.prepareStatement(update_ext_appl_num_qry);
								pstmt7.setString(1, ext_appl_num);
								pstmt7.setString(2, amend_order_id);//12437
								pstmt7.setString(3, amend_delete_line_num.trim());//12437
								pstmt7.setString(4, new_order_id);//12437
								pstmt7.setString(5, Integer.valueOf(order_line_num).toString());//12437
								pstmt7.execute();
								
								closeStatement(pstmt7) ;
								
							}
							//12123 Ends
						}
						catch(Exception Be)
						{
							Be.printStackTrace();
						} 
					 }
				   }// End of For i

					//pstmt_amd_del.executeBatch();//added on 10/05/07

				int result_val[] = pstmt.executeBatch();
				// -2 done successful but does not have the count of row affected

				for (int i=0;i<result_val.length ;i++ )
				{
					if(result_val[i] != -2  && result_val[i] < 0)
					{
						status=false;
						break;
					}
					else 
						status=true;
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

			
				if(status&&(((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))||(((bill_yn.equalsIgnoreCase("Y"))&&((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))) ))||(bill_yn.equalsIgnoreCase("N"))))
				{   // Select and find any records r there, then For Deletion in the or_order header
				   if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
				   {
						if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
						{
							 print_report_values.put("p_facility_id"+print_report_count,cn_login_facility_id);
							 print_report_values.put("p_order_id"+print_report_count,amend_order_id);
							 print_report_values.put("p_order_line_num"+print_report_count,amend_delete_line_num.trim());
							 print_report_values.put("print_report_yn"+print_report_count,print_report_yn);
							//map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
							 print_report_count ++;
							 print_report_values.put("total_recs",String.valueOf(print_report_count));
						}
				   }
				
				} // End of if status
				else
				{
					if(p_error_code==null) p_error_code="";
					if(!p_error_code.trim().equals(""))		
					{
						 error_messages.setLength(0);
						 error_messages.append(p_error_code) ;
						 status = false;
					}
				}

				/*
				pstmt = connection.prepareStatement(line_count_query);
				pstmt.clearParameters();
				pstmt.setString(1, amend_order_id.trim());
				resultSet	= pstmt.executeQuery() ;
				if(resultSet!=null && resultSet.next()) // Only One Record
				{
				count_order = resultSet.getInt(1);
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;*/
				if(status &&((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))||((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))&&(bill_yn.equalsIgnoreCase("Y")))||(bill_yn.equalsIgnoreCase("N"))) 	
				{
					String status_code_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE");
					String p_order_status_code =(String) getStatusCode(connection,amend_order_id,status_code_sql);
					String sql  = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS");
					pstmt = connection.prepareStatement(sql);
					pstmt.clearParameters();
					pstmt.setString( 1, p_order_status_code ) ;
					pstmt.setString( 2, amend_order_id.trim()) ;
					count_order  = pstmt.executeUpdate() ;	
					closeStatement(pstmt);
					if(count_order > 0 ) 
						status = true; 
					else 
						status = false;
				}

 				 	/*if(count_order==0 && status) // If not equal to 0, that means records r there..so no deletion in the hdr
					{ // Then delete from the header also
						//pstmt = connection.prepareStatement(hdr_delete_query);
						//pstmt = connection.prepareStatement(hdr_delete_query);
						String amend_order_update = OrRepositoryExt.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_UPDATE");
						pstmt.clearParameters();
						pstmt.setString(1, cn_login_by_id.trim());
						pstmt.setString(2, cn_login_at_ws_no.trim());
						pstmt.setString(3, cn_login_facility_id.trim());
						pstmt.setString(4, amend_order_id.trim());
					    count_order = pstmt.executeUpdate();
						if(count_order > 0 ) status = true; else status = false;
						hdr_status = status; // Assign the status value to the hdr_status, will be useful for the deletion in Order format
 			  			closeStatement( pstmt ) ;
						// Deletion for the Header format Level
					} // End of count_order & status*/
				  }
				
				/*if(status&&((((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))||((bill_yn.equalsIgnoreCase("Y")&&((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))))||(bill_yn.equalsIgnoreCase("N"))))
				{
					// Call a method to delete the order_format_values & order_line_format_values
						status = deletionOrderFormatAmend(hashMap, count , hdr_status,line_order_format_delete_query,hdr_order_format_delete_query);
				}*/
			 // End of if amend_order_id
	 	}
		catch ( Exception e )
		{
			status = false;
			error_messages.setLength(0);
	  		error_messages.append( "Error Deletion from the Tables(Amend)"+  e.toString()) ;
	  		e.printStackTrace() ;
	  	} 
		finally 
		{
 				closeResultSet( resultSet ) ;
	  			closeStatement( pstmt ) ;
				closeStatement( pstmt_amd_del ) ;
	  	} // End of finally
		return status;
	} // End of deletionAmend

/**
* @ejb.interface-method
*	 view-type="both"
*/

	/* Deletion from the Order Format Tables , if required if the order_id has changed due to the changes
	 * This condition will arise, when the order has been amended, i.e the start_date_time
	 * or the frequency or the duration_code or the performing_location has been changed, and now
	 * it will go as an New Order , that time that particular order_line_num has to be deleted from
	 * the or_order_line table and if no other line no for that order_id in the line table,
	 * then in the header table or_order that particular order_id has to be deleted.
	 */
	private boolean deletionOrderFormatAmend(HashMap hashMap, int count, boolean hdr_status, String line_order_format_delete_query ,String hdr_order_format_delete_query) throws Exception
	{
		PreparedStatement pstmt 	= null;
		String amend_order_id		= "", amend_delete_line_num	= "";
		//int count_order				= 0;
		boolean status				= true;
		try
		{
			// Deletion to be done from the or_order_line_field_values
			pstmt				   = connection.prepareStatement(line_order_format_delete_query);
			amend_order_id 		   = checkForNull((String)hashMap.get("amend_order_id"),"");
			if(!amend_order_id.equals("")) // If it is only new order, amend_order_id will be blank;
			{
				for(int i=0;i<count;i++)   // For Deletion in the Line Level.(or_order_line)
				{   // Get the Line_num
					amend_delete_line_num  = checkForNull((String)hashMap.get("amend_delete_line_num"+i),"");
					if(!amend_order_id.equals("")) // If it is only new order, amend_order_id will be blank;
					{
 						pstmt.setString(1, amend_order_id.trim());
						pstmt.setString(2, amend_delete_line_num.trim());
		 				pstmt.addBatch();
					}
				} // End of For i
				//int result_val[] = pstmt.executeBatch();
				pstmt.executeBatch();
				// No need to check whether it is deleted or  not in the table,
				// If records r there for the order_id and order_line_num, it will delete, otherwise no need to check and proceed
	  			closeStatement( pstmt ) ;
			 	if(hdr_status)  // If hdr_status (i.e) have deleted in the or_order base table, then delete from this table also
				{ // Then delete from the header also
					pstmt = connection.prepareStatement(hdr_order_format_delete_query);
					pstmt.clearParameters();
					pstmt.setString(1, amend_order_id.trim());
					pstmt.executeUpdate(); // No need to check whether it is deleted in the hdr or not,some times records may not be there
				    //count_order = pstmt.executeUpdate(); // No need to check whether it is deleted in the hdr or not,some times records may not be there
					//if(count_order > 0 ) status = true; else status = false;
				} // End of hdr_status
			} // End of if amend_order_id
		}
		catch ( Exception e )
		{
			status = false;
			error_messages.setLength(0);
			error_messages.append( "Error Deletion from the order Format  Tables(Amend)"+  e.toString()) ;
			e.printStackTrace() ;
		} 
		finally 
		{
			closeStatement( pstmt ) ;
		} 
		return status;
	} // End of deletionOrderFormatAmend


	// Pass the Header Level Order Category and get the values EXT_APPL_ACCESSION_GEN_YN
	public String getExternalApplAccessionGenYn(String order_category, String ext_query) throws Exception 
	{
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		String ext_appl_accession_gen_yn= "N";
		try
		{
			pstmt				= connection.prepareStatement(ext_query);
			pstmt.setString(1, order_category );
			resultSet			= pstmt.executeQuery() ;
			if (resultSet != null)
			{
				while(resultSet.next())	//Only One Record it will return
				{
					ext_appl_accession_gen_yn =  resultSet.getString("ext_appl_accession_gen_yn")  ;
				}
			}
		}
		catch ( Exception e )	
		{
			error_messages.setLength(0);
			error_messages.append( "Getting getExternalApplAccessionGenYn" +e.toString()) ;
			e.printStackTrace() ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		return ext_appl_accession_gen_yn;
	}


	// Below Method is to get the External Order_id  for the Line Level for the Order Category, if the EXT_APPL_GEN_YN ='Y' for each category
	// (Used when inserting the EXT_APPL_ACCESSION_NUM in the line level)
	private String getExternalApplAccessionNum(String order_category, String ext_query) throws Exception {
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		String ext_appl_accession_num	= "";
		try
		{
			pstmt		= connection.prepareStatement(ext_query);
 			pstmt.setString(1, order_category);
  			resultSet	= pstmt.executeQuery() ;
  			if(resultSet!=null) // Only One Record
 			{
 				if(resultSet.next() ) 
				{  // Only one record
  					ext_appl_accession_num = resultSet.getString(1);
  				}
 			}
 			if(ext_appl_accession_num == null || resultSet == null) ext_appl_accession_num = "";
 	 	}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error getting the External Appl Accession Num" +e.toString()) ;
	  		e.printStackTrace() ;
	  	}
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
	  	}
  		return ext_appl_accession_num;
	} // End of getExternalApplAccessionNum

	// Below Method is to get TRN_GROUP_REF 
	// (Used when inserting the or_order table)
	//Added by Uma for IN015411 CRF 560
	private int getTrnGroupRef() throws Exception 
	{
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		int trn_group_ref 	= 0;
		try
		{
			pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_TRN_GROUP_REF"));
 			resultSet	= pstmt.executeQuery() ;
  			if(resultSet!=null) // Only One Record
 			{
 				if(resultSet.next() ) 
				{  // Only one record
  					trn_group_ref  = resultSet.getInt(1);
  				}
 			}
			if(resultSet == null) 
				trn_group_ref = 0;
  	 	}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error getting the getTrnGroupRef" +e.toString()) ;
	  		e.printStackTrace() ;
	  	} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
	  	}
  		return trn_group_ref;
	} // End of getTrnGroupRef

	// Below Method is to update_report_info
	// (Used when inserting the or_order table)
	private void updateRepInfo(String trn_group_ref) throws Exception 
	{
		CallableStatement cstmt 		= null;
		String err_message = "";
		try
		{
			String sql  = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_REPORT_INFO");
			cstmt		= connection.prepareCall("{ "+sql+" }");
			cstmt.setString(1, checkForNull(trn_group_ref,""));
			cstmt.registerOutParameter(2,Types.VARCHAR ) ;		// P_ERROR_MESSAGE
			cstmt.execute();
 			err_message		= checkForNull(cstmt.getString(2),"");     // P_ERROR_MESSAGE
   	 	}
		catch ( Exception e )
		{
			error_messages.setLength(0);
	  		error_messages.append( "Error getting the getTrnGroupRef" +e.toString()) ;
	  		e.printStackTrace() ;
	  	} 
		finally 
		{
			closeStatement( cstmt ) ;
	  	}
  	} // End of updateRepInfo
/*Ends Here IN015411*/

/**
* @ejb.interface-method
*	 view-type="both"
*/
	//The below method is used to insert into or_result_header,or_result_detail,or_result_detail_proc tables for the auto completion type of transaction
 	private String insertResult(HashMap tabData, HashMap hashMap, int row, String order_id, int order_line_num, String auto_report_query) throws Exception
	{
		CallableStatement cstmt 	= null ;
		String err_message			= "";
 		try
		{
			cstmt = connection.prepareCall("{ "+auto_report_query+" }");
			cstmt.setString(1, checkForNull(order_id,""));				// P_ORDER_ID
			cstmt.setInt(2, order_line_num);							// P_ORDER_LINE_NUM
			cstmt.setString(3, checkForNull((String)hashMap.get("ordering_practitioner_id"),""));	 // P_PRACT_ID
			cstmt.setString(4, checkForNull((String)hashMap.get("start_date_time"+row),""));		 // P_START_DATE_TIME
			cstmt.setString(5, null);				// P_DISCR_MSR_ID
			cstmt.setString(6, checkForNull((String)hashMap.get("catalog_code"+row),"")); 			 // P_ORDER_CATALOG_CODE
			cstmt.setString(7, checkForNull((String)hashMap.get("order_type"+row),"")); 			 // P_ORDER_TYPE_CODE
			cstmt.setString(8, (String)tabData.get("login_at_ws_no")); 								 // P_WS_NO
			cstmt.setString(9, ((String)tabData.get("login_by_id")));								 // P_USER
			cstmt.setString(10, ((String)tabData.get("login_facility_id")));						 // P_FACILITY

			cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;			// P_ERROR_MESSAGE
			cstmt.execute();
 			err_message		= checkForNull(cstmt.getString(11),"");     // P_ERROR_MESSAGE
           // Till here
		}
		catch(Exception e)
		{
			err_message	   = e.toString();
			error_messages.setLength(0);
			error_messages.append("EJB-Exception calling Procedure to insert in result tables"+ e.toString());
			e.printStackTrace() ;
		}
		finally	
		{
			closeStatement( cstmt ) ;
		} // End of finally
		return err_message;
	} // End of insertResult

	private String[] getOrderSetId(HashMap hashMap, HashMap tabData, String patient_id, String encounter_id, String episode_id, String episode_visit_num, String oth_query) throws Exception
	{
		CallableStatement cstmt 	= null ;
		String order_set_id			= "", err_message			= "";
		String[] result_orderset	= new String[2];
		try
		{
			cstmt = connection.prepareCall("{ "+oth_query+" }");
			cstmt.setString(1, ((String)hashMap.get("order_date_time")));	// P_ORDER_DATE_TIME
			cstmt.setString(2, checkForNull((String)hashMap.get("care_set_catalog_code"),""));	 // P_ORDER_CATALOG_CODE
			cstmt.setString(3, "OR"); 									// P_CONTR_SYS_ID
			cstmt.setString(4, ((String)tabData.get("login_facility_id")));	// P_ORDERING_FACILITY
			cstmt.setString(5, patient_id);								// P_PATIENT_ID
			cstmt.setString(6, (String)hashMap.get("patient_class"));	// P_PATIENT_CLASS
 			cstmt.setDouble(7, Double.parseDouble(checkForNull(encounter_id,"0"))); 									// P_ENCOUNTER_ID
			cstmt.setDouble(8, Double.parseDouble(checkForNull(episode_id,"0"))); 			// P_EPISODE_ID
			cstmt.setDouble(9, Double.parseDouble(checkForNull(episode_visit_num,"0"))); 		// P_EPISODE_VISIT_NUM
			cstmt.setString(10, ((String)hashMap.get("location_type")));  // P_SOURCE_TYPE
			cstmt.setString(11, ((String)hashMap.get("location_code")));  // P_SOURCE_CODE
			cstmt.setString(12, ((String)hashMap.get("ordering_practitioner_id"))); // P_ORDERING_PRACT
			cstmt.setString(13, ((String)tabData.get("login_by_id"))); // P_USER
			cstmt.setString(14, ((String)tabData.get("login_at_ws_no"))); // P_WS_NO

			cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;			// P_ORDER_ID
			cstmt.registerOutParameter( 16,  Types.INTEGER ) ;			// P_ORDER_LINE_NUM
			cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;			// P_PERFORMING_FACILITY_ID
			cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;// P_ERR_MSG
			cstmt.setString(19, null);
			cstmt.setString(20, ((String)hashMap.get("priority_hdr")));
			cstmt.setString(21, (String)hashMap.get("fpp_yn0"));//IN072524
			cstmt.setString(22, (String)hashMap.get("fpp_category0"));//IN072524
			cstmt.execute();
			// Specimen No generated and stored here // P_ORDER_LINE_NUM & P_PERFORMING_FACILITY_ID no need
			order_set_id	= checkForNull(cstmt.getString(15),""); // P_ORDER_ID
			err_message		= checkForNull(cstmt.getString(18),""); // P_ERR_MESSAGE
			// Till here
		}
		catch(Exception e)
		{
			err_message	   = e.toString();
			error_messages.setLength(0);
			error_messages.append("EJB-Exception generating order_set_id"+ e.toString());
			e.printStackTrace() ;
		}
		finally	
		{
			closeStatement( cstmt ) ;
		} // End of finally
		result_orderset[0] = order_set_id;
		result_orderset[1] = err_message;
		return result_orderset;
	} // End of getOrderSetId

	private String callPHInsertDetails(HashMap tabData, HashMap hashMap, String ph_query, int row, String order_id, String order_line_num, String patient_id, String encounter_id, String order_format_values, String[] ph_calculations) throws Exception
	{
		CallableStatement cstmt 	= null ;
		String err_message			= "";
 		double quantity				= 0.0;
		//String quantity_uom			= "";
		try
		{
			if (ph_calculations!=null)
			{
				quantity			= Double.parseDouble(checkForNull(ph_calculations[0],"0"));
				//quantity_uom		= checkForNull(ph_calculations[1],"");
			}
			cstmt = connection.prepareCall("{ "+ph_query+" }");
			cstmt.setString(1,  order_id);			// P_ORDER_ID
			cstmt.setString(2,  order_line_num);		// P_ORDER_LINE_NUM
			cstmt.setString(3,  ((String)tabData.get("login_facility_id"))); // P_ORDERING_FACILITY
			cstmt.setString(4,  checkForNull(((String)hashMap.get("catalog_code"+row)),""));	// P_ORDER_CATALOG
			cstmt.setString(5,  patient_id);									// P_PATIENT_ID
			cstmt.setString(6,  encounter_id);								// P_ENCOUNTER_ID
			cstmt.setString(7,  (String)hashMap.get("patient_class"));		// P_PATIENT_CLASS
			cstmt.setString(8,  ((String)hashMap.get("ordering_practitioner_id")));	// P_ORDERING_PRACT
			cstmt.setString(9,  checkForNull(((String)hashMap.get("frequency_val"+row)),""));	// P_FREQ_CODE
			cstmt.setString(10, checkForNull(((String)hashMap.get("duration_value"+row)),""));	// P_DURATION
			cstmt.setString(11, ((String)hashMap.get("duration"+row)));	// P_DURATION_TYPE
			cstmt.setString(12, checkForNull(((String)hashMap.get("dosage_by"+row)),""));	// P_DOSAGE_TYPE
			cstmt.setDouble(13, Double.parseDouble(checkForNull(((String)hashMap.get("quantity"+row)), "0"))); 		// P_ORDERING_QTY
			cstmt.setDouble(14, quantity); 			// P_TOTAL_QTY
			cstmt.setString(15, checkForNull(((String)hashMap.get("quantity_uom"+row)), ""));					// P_UOM
			cstmt.setString(16, checkForNull(((String)hashMap.get("performing_dept_loc_code"+row)),"") );		// P_PERFORMING_LOCN
			cstmt.setString(17, order_format_values);			// P_ORDER_LINE_FIELD_VALUES
			cstmt.setString(18, checkForNull(((String)hashMap.get("start_date_time"+row)), ""));				// P_START_DATE
			cstmt.setString(19, checkForNull(((String)hashMap.get("end_date_time"+row)), ""));					// P_END_DATE
			cstmt.setString(20, ((String)tabData.get("login_by_id")));    // P_USER
			cstmt.setString(21, ((String)tabData.get("login_at_ws_no"))); // P_WS_NO
 			cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;			// P_ERR_MSG
		 	cstmt.execute();

			err_message		= checkForNull(cstmt.getString(22),""); // P_ERR_MESSAGE
			// Till here
		}
		catch(Exception e)
		{
			err_message	   = e.toString();
			error_messages.setLength(0);
			error_messages.append("EJB-Exception generating order_set_id"+ e.toString());
			e.printStackTrace();
		}
		finally	
		{
			closeStatement( cstmt ) ;
		}
		return err_message;
	}	

	private String[] getPHCalculations(HashMap hashMap,int row, String freq_nature, String ph_equ_query) throws Exception
	{

		PreparedStatement pstmt 			= connection.prepareStatement(ph_equ_query) ;
		ResultSet resultSet 				= null;

		String[] result_ph_details			= new String[2];
		String dosage_by					= checkForNull((String)hashMap.get("dosage_by"+row),"");
		//String duration						= checkForNull((String)hashMap.get("duration"+row),"");
		String quantity						= checkForNull((String)hashMap.get("dosage"+row),"0");
		String quantity_uom					= checkForNull((String)hashMap.get("quantity_uom"+row),"");
		String prn_doses_pres_prd_fill		= checkForNull((String)hashMap.get("prn_doses_pres_prd_fill"+row),"");
		String content_in_pres_base_uom		= checkForNull((String)hashMap.get("content_in_pres_base_uom"+row),"");
 		String fract_dose_round_up_yn		= checkForNull((String)hashMap.get("fract_dose_round_up_yn"+row),"");
		//String strength_value				= checkForNull((String)hashMap.get("strength_value"+row),"");
		String strength_per_pres_uom		= checkForNull((String)hashMap.get("strength_per_pres_uom"+row),"");
		String strength_per_value_pres_uom	= checkForNull((String)hashMap.get("strength_per_value_pres_uom"+row),"");
 		//String uom						= checkForNull((String)hashMap.get("uom"+row),"");
		String pres_base_uom				= checkForNull((String)hashMap.get("pres_base_uom"+row),"");
		String stock_uom					= checkForNull((String)hashMap.get("stock_uom"+row),"");
		String repeat_value					= checkForNull((String)hashMap.get("repeat_value"+row),"");
		String duration_value				= checkForNull((String)hashMap.get("duration_value"+row),"");

		//String in_qty_value					= "",  in_qty_unit		= "";
		String in_order_qty					= "",  in_order_uom		= "";
		//String in_tot_strength				= "",  in_tot_strenght_uom	= "";
		//String in_bms_qty					= "";
		//String in_strength_value			= "",  in_strength_uom		= "";
		//String in_pres_qty_value			= "",  in_pres_qty_uom		= "";
		String equl_value					= "1";
		String tmp_qty						= "";
		//String interval_value				= duration_value;

		float ord_qty						= 0.0f;// act_qty			= 0.0f;
		//float tot_strn						= 0.0f;
		try
		{
			if((dosage_by.equals("A")) || (freq_nature.equals("P")))
			{
				if(freq_nature!=null && freq_nature.equals("P")) 
				{
					//in_qty_value			= quantity;
					//in_qty_unit				= quantity_uom;
					if(quantity.equals("0")) 
					{
						if(prn_doses_pres_prd_fill.equals("0")) 
						{
							in_order_qty	= "1";
						} 
						else 
						{
							in_order_qty	= prn_doses_pres_prd_fill;
						}
					}
					else 
					{
						in_order_qty		= quantity;
					}
					in_order_uom			= quantity_uom;
					//in_tot_strength			= "";	in_tot_strenght_uom	= "";
					/*if(quantity.equals("0") || quantity.equals("0.0")) {
						if(prn_doses_pres_prd_fill.equals("0")) {
							in_bms_qty		= "1";
						} else {
							in_bms_qty		= prn_doses_pres_prd_fill;
						}
					} else {
						in_bms_qty			= quantity;
					}*/
					//in_bms_qty				= ((checkForNull(((String)hashMap.get("quantity"+row)),"0")=="0")?prn_doses_pres_prd_fill:quantity);
					//in_strength_value		= strength_value;
					//in_strength_uom			= strength_per_pres_uom ;
					/*if(checkForNull(((String)hashMap.get("quantity"+row)),"").equals("")) {
						if(checkForNull((String)hashMap.get("prn_doses_pres_prd_fill"+row),"").equals("")) {
							in_pres_qty_value	= "1";
						} else {
							in_pres_qty_value	= prn_doses_pres_prd_fill;
	 					}
					} else {
						in_pres_qty_value		= quantity;
					}*/
					//in_pres_qty_uom	= quantity_uom;
				}
				else 
				{
					//in_qty_value		= quantity;
					//in_qty_unit			= quantity_uom;
					in_order_qty		= quantity;
					in_order_uom		= quantity_uom;
					//in_tot_strength		= "";
					//in_tot_strenght_uom	= "";
					//in_bms_qty			= quantity;
					//in_strength_value	= strength_value;
					//in_strength_uom		= strength_per_pres_uom;
					//in_pres_qty_value	= quantity;
					//in_pres_qty_uom		= quantity_uom;
				}
			} 
			else if(dosage_by!=null && dosage_by.equals("Q"))
			{
				pstmt.setString(1, pres_base_uom);
				pstmt.setString(2, quantity_uom);
				pstmt.setString(3, pres_base_uom);
				pstmt.setString(4, quantity_uom);
				resultSet	= pstmt.executeQuery();
				if ( resultSet != null && resultSet.next() )
				{
					equl_value = resultSet.getString("eqvl_value")==null ? "1":resultSet.getString("eqvl_value");
				}
				//in_qty_unit	= quantity_uom;
				if( (quantity!=null && !(quantity.equals(""))) && (duration_value!=null && !(duration_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  )
				{
					if(!fract_dose_round_up_yn.equals("Y")) 
					{
						ord_qty		=	(Float.parseFloat(quantity)*Integer.parseInt(duration_value)*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));
						ord_qty		=	Float.parseFloat(Math.ceil(ord_qty/(Float.parseFloat(content_in_pres_base_uom)))+"");
						if(ord_qty==0)	ord_qty	=	1;
					}
					else 
					{
						if( (Float.parseFloat(quantity)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom))
						{
							tmp_qty	=	1+"";
						}
						else 
						{
							tmp_qty	=  Math.ceil((Float.parseFloat(quantity)*Float.parseFloat(equl_value))/Float.parseFloat(content_in_pres_base_uom))+"";
						}
						ord_qty =  Float.parseFloat(tmp_qty) *Integer.parseInt(duration_value) * Integer.parseInt(repeat_value);
					}
				}
				//	if(freq_nature.equals("F")) {
				//		ord_qty	= Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+"");
				//	}
				in_order_qty	= String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				in_order_uom	= quantity_uom;
				/*if((equl_value!=null && !(equl_value.equals("")))){
				act_qty		= Float.parseFloat(quantity)* Float.parseFloat(equl_value);
				}
				*/
				/*if( (strength_value!=null && !(strength_value.equals("")))){
				tot_strn			= act_qty*(Float.parseFloat(strength_value));
				//in_tot_strength		= String.valueOf(tot_strn);
				//in_tot_strenght_uom	= strength_per_pres_uom;
				}else{
				in_tot_strength		= "";	in_tot_strenght_uom	= "";
				}*/
				//in_bms_qty				= String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				//in_strength_value		= strength_value;
				//in_strength_uom			= strength_per_pres_uom;
				//in_pres_qty_value		= String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				//in_pres_qty_uom			= quantity_uom;
			}
			else if(dosage_by!=null && dosage_by.equals("S"))
			{
				//in_qty_unit				= quantity_uom;
				if( (quantity!=null && !(quantity.equals(""))) && (duration_value!=null && !(duration_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  )
				{
					if(!fract_dose_round_up_yn.equals("Y")) 
					{
						ord_qty			= ((Float.parseFloat(quantity)*Integer.parseInt(duration_value)*Integer.parseInt(repeat_value)*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
						ord_qty			= new Double(Math.ceil(new Double(ord_qty/Float.parseFloat(content_in_pres_base_uom)).doubleValue())).floatValue();
					}
					else 
					{
						double unit_qty	=   Math.ceil(Double.parseDouble(quantity)/Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(strength_per_value_pres_uom)) ;
						tmp_qty			=  (Math.ceil(unit_qty/Float.parseFloat(content_in_pres_base_uom))+"");
						ord_qty			=  (Float.parseFloat(tmp_qty)* Integer.parseInt(duration_value) * Integer.parseInt(repeat_value) );
					}
					//if(freq_nature.equals("F")) {
					//	ord_qty			=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+"");
					//}
				}
				in_order_qty			= String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				in_order_uom			= pres_base_uom;
				//in_tot_strength			= String.valueOf(tot_strn);
				//in_tot_strenght_uom		= strength_per_pres_uom;
				//in_bms_qty				= String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				//in_strength_value		= strength_value;
				//in_strength_uom			= strength_per_pres_uom;
				//in_pres_qty_value		= String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				//in_pres_qty_uom			= pres_base_uom;
			}
		}
		catch(Exception e)
		{
			error_messages.setLength(0);
			error_messages.append("EJB-Exception PH Calculations"+ e.toString());
			e.printStackTrace();
		}
		finally	
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
	}
	// over_write the in_order_uom with the stock_uom
	in_order_uom = stock_uom;
 	result_ph_details[0] = checkForNull(in_order_qty,"");
	result_ph_details[1] = checkForNull(in_order_uom,"");
	return result_ph_details;
} // End of getPHCalculations


/**
* @ejb.interface-method
*	 view-type="both"
*/

// Building if the appointment has to be given and kept it in the global hashtable.(oa_bookappt_values)
   private void getAppointment(HashMap hashMap, int i, String order_id, int order_line_num, String called_from)
	{ // Appointment logic building
		// Till here for OA book appt
		if(called_from.equals("AMEND"))
		{ // For Amend order only
			//if((checkForNull((String)hashMap.get("rd_install_yn"),"N").equals("Y") && checkForNull((String)hashMap.get("amend_order_category"+i),"CS").equals("RD")) )
			//	oa_bookappt_values.put("appt_reqd_yn"+appt_reqd_count, "N"); // No Appointment
			//else
 				oa_bookappt_values.put("appt_reqd_yn"+appt_reqd_count, checkForNull((String)hashMap.get("amend_appt_reqd_yn"+i),"N"));
				oa_bookappt_values.put("order_id"+appt_reqd_count, checkForNull((String)hashMap.get("amend_order_id"),""));
				oa_bookappt_values.put("order_line_num"+appt_reqd_count, checkForNull((String)hashMap.get("amend_order_line_num"+i),""));
				oa_bookappt_values.put("catalog_code"+appt_reqd_count, checkForNull((String)hashMap.get("amend_catalog_code"+i),""));
				oa_bookappt_values.put("start_date_time"+appt_reqd_count, checkForNull((String)hashMap.get("amend_start_date_time"+i),""));
				oa_bookappt_values.put("catalog_code_dc"+appt_reqd_count, checkForNull((String)hashMap.get("amend_cat_desc"+i),""));
				// For RD Installed, wing code is taken
				oa_bookappt_values.put("performing_dept_loc_code"+appt_reqd_count, checkForNull((String)hashMap.get("amend_performing_dept_loc_code"+i),""));
				oa_bookappt_values.put("order_status_code"+appt_reqd_count, checkForNull(((String)hashMap.get("amend_order_status_code"+i))));
				oa_bookappt_values.put("performing_facility_id"+appt_reqd_count, checkForNull(((String)hashMap.get("amend_performing_facility_id"+i))));
				oa_bookappt_values.put("fpp_yn"+appt_reqd_count, checkForNull(((String)hashMap.get("fpp_yn"+i))));		//37051
				oa_bookappt_values.put("fpp_category"+appt_reqd_count, checkForNull(((String)hashMap.get("fpp_category"+i))));  //37051
		}
		else
		{ // for other orders
			//if(checkForNull((String)hashMap.get("rd_install_yn"),"N").equals("Y") && checkForNull((String)hashMap.get("order_category"+i),"CS").equals("RD"))
			//	 oa_bookappt_values.put("appt_reqd_yn"+appt_reqd_count, "N"); // No Appointment
			//else
				oa_bookappt_values.put("appt_reqd_yn"+appt_reqd_count, checkForNull((String)hashMap.get("appt_reqd_yn"+i),""));
				oa_bookappt_values.put("order_id"+appt_reqd_count, checkForNull(order_id,""));
				oa_bookappt_values.put("order_line_num"+appt_reqd_count, checkForNull(String.valueOf(order_line_num),""));
				oa_bookappt_values.put("catalog_code"+appt_reqd_count, checkForNull((String)hashMap.get("catalog_code"+i),""));
				oa_bookappt_values.put("start_date_time"+appt_reqd_count, checkForNull((String)hashMap.get("start_date_time"+i),""));
				oa_bookappt_values.put("catalog_code_dc"+appt_reqd_count, checkForNull((String)hashMap.get("catalog_code_dc"+i),""));
				// For RD Installed, wing code is taken
				oa_bookappt_values.put("performing_dept_loc_code"+appt_reqd_count, checkForNull((String)hashMap.get("performing_dept_loc_code"+i),""));
				oa_bookappt_values.put("order_status_code"+appt_reqd_count, checkForNull(((String)hashMap.get("order_status_code"+i))));
				oa_bookappt_values.put("performing_facility_id"+appt_reqd_count, checkForNull(((String)hashMap.get("performing_facility_id"+i))));
				oa_bookappt_values.put("fpp_yn"+appt_reqd_count, checkForNull(((String)hashMap.get("fpp_yn"+i))));			//37051
				oa_bookappt_values.put("fpp_category"+appt_reqd_count, checkForNull(((String)hashMap.get("fpp_category"+i)))); //37051
		}
		appt_reqd_count++; // Global variable (incremented)
   } //End of getAppointment

	// Get the continuing order ind (Line Level)
	private String getContinuingOrder(String cont_order_yn,String freq_nature,String frequency_val)
	{
		String cont_order_ind = "";
		if(cont_order_yn.equalsIgnoreCase("N") && frequency_val.equals(""))
			cont_order_ind = "DO";
		else if(cont_order_yn.equalsIgnoreCase("Y") && frequency_val.equals(""))
			cont_order_ind = "CO";
		else if(cont_order_yn.equalsIgnoreCase("N") && !frequency_val.equals("") && freq_nature.equals("O"))
			cont_order_ind = "DO";
		else if(cont_order_yn.equalsIgnoreCase("N") && !frequency_val.equals("") && (!freq_nature.equals("C") || !freq_nature.equals("O") || !freq_nature.equals("P")))
			cont_order_ind = "DR";
		else if(cont_order_yn.equalsIgnoreCase("N") && !frequency_val.equals("") && (freq_nature.equals("C") || freq_nature.equals("O") || freq_nature.equals("P")))
			cont_order_ind = "DO";
		else if(cont_order_yn.equalsIgnoreCase("Y") && !frequency_val.equals("") && !freq_nature.equals("C"))
			cont_order_ind = "CO";
		else if(cont_order_yn.equalsIgnoreCase("Y") && !frequency_val.equals("") && freq_nature.equals("C"))
			cont_order_ind = "CR";
 		return 	cont_order_ind;
	} // End of the Method getContinuingOrder()

	// Method to get the split_grouping, if appt_reqd_yn is 'Y' for any record it will just build the string(appending the grouping_seq_no) and give
	private String splitGroupingOrders (int grouping_seq_no) throws Exception 
	{
		String split_grouping = "";
				split_grouping = String.valueOf(grouping_seq_no);
			if(split_grouping.length()==1)
				split_grouping = split_grouping+"00";
		    else if(split_grouping.length()==2)
			    split_grouping = split_grouping+"0";
		return split_grouping;
	} // End of splitGroupingOrders

	// To get the Order Type, out of the passed string
	private String getOrderType(String grouping)
	{
		String order_type		= "" , performing_facility_id = "";
		StringTokenizer stGroup = new StringTokenizer(grouping,"~~");//Get the grouping
		if(stGroup.hasMoreTokens())
		{
			performing_facility_id 	= stGroup.nextToken(); if(performing_facility_id.equals("^^")) performing_facility_id="";
			order_type 				= stGroup.nextToken(); if(order_type.equals("^^")) order_type="";
			// 2nd parameter is the order type code
		}
		stGroup	= null; //Nullifying the objects
		return 	order_type;
	} // End of the Method getOrderType()

	private String groupingOrderType(String order_category, String primary_order_type, String order_type_code)
	{
		String order_type = "^^";
		if(checkForNull(order_category,"").equals("OT"))
		{
			order_type = checkForNull(primary_order_type,"^^");
			if(order_type.equals("^^") || order_type.equals("")) //if it is null
				order_type = checkForNull(order_type_code,"^^");
		}
		else 
		{
			order_type = checkForNull(order_type_code,"^^");
		}
		return order_type;
	} // End of groupingOrderType

	// Check For Null and If value is there return it, other wise return the default value..
	private String checkForNull( String val, String dflt_val)
	{
		if ( val == null || val.equals(""))	
		{
			try
			{
				val= dflt_val;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		 	return val;
    }

	private String checkForNull( String val)
	{
		String dflt_val="";
		if ( val == null || val.equals(""))
		{
			try
			{
				dflt_val =  java.net.URLEncoder.encode("^^","UTF-8");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return dflt_val;
		}
		else
			return val;
    }
	public String getmoduleRL(String catalogcode,String categorycode,String ordertypecode,String facility_id) throws Exception
{
		//Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String modname="";
		try
		  {
			//connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("OR_GET_INTERFACED_APPL"));
			//pstmt=connection.prepareStatement("SELECT OR_GET_INTERFACED_APPL(?,?,?) modname FROM DUAL");
			pstmt.setString(1,(String)catalogcode);
			pstmt.setString(2,(String)categorycode);
			pstmt.setString(3,(String)ordertypecode);
			pstmt.setString(4,(String)facility_id);


			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				modname = rs.getString("modname");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			//closeConnection(connection);
		}
		
		return modname;

}
//	Commented for IN071315
/*public boolean cancelBilling(String p_order_id,String p_order_line_num,String p_user,String p_ws_no,String p_facility_id,String SQL_OR_BL_WITHOUT_ORDER_CATALOG,String p_called_from_ca) throws Exception//IN071315
{
	
	CallableStatement cstmt 	= null;
	ResultSet resultSet 		= null;
	String p_mode			= "CAN";
	String p_error_message			= "";

	boolean result=true;
	try
	{
		cstmt = connection.prepareCall("{ "+SQL_OR_BL_WITHOUT_ORDER_CATALOG+" }");
		cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
		cstmt.setString(2, p_order_id);						// P_ORDER_ID
		cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
		cstmt.setString(4, p_mode); 						// P_MODE
		cstmt.setString(5, p_user);							// P_USER
		cstmt.setString(6, p_ws_no);						// P_WS_NO
		cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
		cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
		//IN071315 Starts
		if("Y".equals(p_called_from_ca))
			cstmt.setString(9, "CA");
		else
			cstmt.setString(9, "OR");
		//IN071315 Ends
		cstmt.execute();
		p_error_message	= cstmt.getString(8);  // message
		if(p_error_message!=null && !p_error_message.equals(""))
		{
			result = false;
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
		closeStatement( cstmt ) ;
	}
	return result;
	
}*/
	//INO71315 Starts
	public String cancelBilling(String p_order_id,String p_order_line_num,String p_user,String p_ws_no,String p_facility_id,String SQL_OR_BL_WITHOUT_ORDER_CATALOG,String p_called_from_ca) throws Exception//IN071315
	{
		
		CallableStatement cstmt 	= null;
		ResultSet resultSet 		= null;
		String p_mode			= "CAN";
		String p_error_message			= "";
	//	String[] billing_line_result	= new String[2];//46480

		try
		{
			cstmt = connection.prepareCall("{ "+SQL_OR_BL_WITHOUT_ORDER_CATALOG+" }");
			cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
			cstmt.setString(2, p_order_id);						// P_ORDER_ID
			cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
			cstmt.setString(4, p_mode); 						// P_MODE
			cstmt.setString(5, p_user);							// P_USER
			cstmt.setString(6, p_ws_no);						// P_WS_NO
			cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
			cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
			//IN071315 Starts
			if("Y".equals(p_called_from_ca))
				cstmt.setString(9, "CA");
			else
				cstmt.setString(9, "OR");
			//IN071315 Ends
			cstmt.execute();
			p_error_message	= cstmt.getString(8);  // message
			

		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( cstmt ) ;
		}
		return p_error_message;
		
	
	}
	//INO71315 Ends
/**Added by Uma on 12/2/2009 for CRF-195
* @ejb.interface-method
*	 view-type="both"
*/
private String getStatusCode(Connection connection, String order_id, String query)throws Exception
{
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String order_status_code= "";
	try
	{
		pstmt = connection.prepareStatement(query) ;
		pstmt.setString( 1, order_id);		 
		resultSet = pstmt.executeQuery() ;

		if ( resultSet != null && resultSet.next() ) 
		{
			order_status_code= resultSet.getString( 1 )  ; //order_status_code
			order_status_code = (order_status_code==null)?"":order_status_code;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
 	} 
	finally 
	{
		closeResultSet( resultSet ) ;
		closeStatement(pstmt);
	}	
	return order_status_code;
}
/**
* @ejb.interface-method
*	 view-type="both"
*/

	private boolean updateAmendOrderHeader(HashMap tabData,String order_id,String ordering_practitioner_id) throws Exception
	{
		PreparedStatement pstmt 		= null;
		boolean status					= true;
		int update_amend_count			= 0;

		if(order_id.equals("null")||order_id.equals(" ")||order_id==null)
			order_id = "";
		if(ordering_practitioner_id.equals("null")||ordering_practitioner_id.equals(" ")||ordering_practitioner_id==null)
			ordering_practitioner_id = "";

		try
		{
			if(status)
			{
				pstmt		= connection.prepareStatement("update or_order set ord_pract_id=?,modified_by_id =(?),modified_date  = sysdate,modified_at_ws_no=(?),modified_facility_id=(?) where order_id=?");
				pstmt.clearParameters();
				pstmt.setString(1, ordering_practitioner_id);
				pstmt.setString(2, ((String)tabData.get("login_by_id")));
				pstmt.setString(3, ((String)tabData.get("login_at_ws_no")));
				pstmt.setString(4, ((String)tabData.get("login_facility_id")));
				pstmt.setString(5, order_id);
				update_amend_count =  pstmt.executeUpdate();
				if(update_amend_count > 0)	
					status = true;
				else 
					status = false;
			}
		}
		catch(Exception e)
		{
			error_messages.setLength(0);
  			error_messages.append( "Error Updating the Amend Hdr" +e.toString()) ;
			e.printStackTrace() ;
	  		status = false;
  		}
  		finally
		{
	  			closeStatement( pstmt ) ;
		} // End of finally
  		return status;
    }  // End of updateAmendHeader
	public String getMessageFromDB(String messageRef,Connection con,String languageId)
	{
		PreparedStatement msgPrepStmet = null;
		ResultSet msgResSet = null;
		String l_failure_message = "";
		
		try
		{
			msgPrepStmet = con.prepareStatement("SELECT MESSAGE_TEXT_SYSDEF FROM SM_MESSAGE_LANG_VW WHERE MESSAGE_REF = ? and language_id= ?");
			msgPrepStmet.setString( 1, messageRef ) ;			
			msgPrepStmet.setString( 2, languageId ) ;			

			msgResSet = msgPrepStmet.executeQuery();

			while(msgResSet.next())
			{
				l_failure_message = msgResSet.getString("MESSAGE_TEXT_SYSDEF");
			
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet( msgResSet );
				closeStatement( msgPrepStmet );					
			}
			catch (Exception ie)
			{
				ie.printStackTrace();
			}
		}

		return l_failure_message;
	}
	//IN034769,ends
	//IN030279 Start.
	private boolean insertLineMO(HashMap tabData, HashMap hashMap,String order_id, int order_line_num, String insert_mo_query) throws Exception 
	{ 
		PreparedStatement pstmt_mo_insert	= null;
		CallableStatement cstmt 			= null;
		
		boolean status 						= false;
		try
		{				
			pstmt_mo_insert				= connection.prepareStatement(insert_mo_query);
			pstmt_mo_insert.setString(1,order_id.trim());		// order_id
			pstmt_mo_insert.setInt(2, order_line_num);		// order_line_num
			pstmt_mo_insert.setString(3,  checkForNull(((String)hashMap.get("deceased_yn")),"N")); 
			pstmt_mo_insert.setString(4,  checkForNull(((String)hashMap.get("medico_legal_yn")),"N"));	
			pstmt_mo_insert.setString(5,  checkForNull(((String)hashMap.get("postmortem_status")),"N"));	
			pstmt_mo_insert.setString(6,  checkForNull(((String)hashMap.get("body_part_yn")),"N"));			
			pstmt_mo_insert.setString(7,  ((String)tabData.get("login_facility_id")));			
			pstmt_mo_insert.setString(8,  (String)hashMap.get("registration_no"));
			pstmt_mo_insert.setString(9,  ((String)tabData.get("login_by_id")));
			pstmt_mo_insert.setString(10, ((String)tabData.get("login_at_ws_no")));
			pstmt_mo_insert.setString(11, ((String)tabData.get("login_facility_id")));
			pstmt_mo_insert.setString(12, ((String)tabData.get("login_by_id")));
			pstmt_mo_insert.setString(13, ((String)tabData.get("login_at_ws_no")));
			pstmt_mo_insert.setString(14, ((String)tabData.get("login_facility_id")));
			int result = pstmt_mo_insert.executeUpdate();
			if(result > 0 ) status = true; else status = false;		
			
		}
		catch ( Exception e )
		{
			error_messages.setLength(0);
			error_messages.append( "Error inserting Individual Tables LB" +e.toString()) ;
			e.printStackTrace() ;
			status = false;
		} 
		finally 
		{
			closeStatement( pstmt_mo_insert ) ;
			closeStatement( cstmt ) ;
		}
		return status;
	}
	//IN030279 End.
	
	//IN065295, starts
	private boolean updateLabOrders(String order_id, int order_line_num)
	{
		PreparedStatement ps = null;
		int affectedRecCnt = 0;
		boolean status = false;

		try
		{
			ps = connection.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = 'SC' WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?");
				
			ps.setString(1,order_id);
			ps.setInt(2,order_line_num);
			affectedRecCnt = ps.executeUpdate();

			if(ps!=null)
				ps.close();

			if(affectedRecCnt > 0)
			{
				status = true;
			}

			if(status)
			{
				ps = connection.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (SELECT MIN (ORDER_STATUS_TYPE) FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE IN (SELECT ORDER_LINE_STATUS FROM OR_ORDER_LINE WHERE ORDER_ID =?))) WHERE ORDER_ID=? ");

				ps.setString(1,order_id.trim());
				ps.setString(2,order_id.trim());
				affectedRecCnt = ps.executeUpdate();

				if(affectedRecCnt>0)
					status = true;

				if(ps!=null)
					ps.close();
			}
		}
		catch (Exception e)
		{
			status = false;
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(ps!=null)
					ps.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
		
		return status;
	}
	//IN065295, ends
		
	//IN065942, starts
	private void populatePrnRegLbl(String order_id, int order_line_no, HashMap map, Hashtable prn_reg_lab_values, int prn_reg_lab_ind)
	{
		prn_reg_lab_values.put("order_id"+prn_reg_lab_ind,order_id);
		prn_reg_lab_values.put("order_line_no"+prn_reg_lab_ind,order_line_no);
	}
	
	//IN072654 Starts
	private boolean checkDrugInterExists(String order_id, int order_line_num, String catalog_code) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rsSet = null;
		int cnt = 0;
		boolean status = false;
		try
		{
			
				ps = connection.prepareStatement("SELECT COUNT(*) cnt FROM or_order_drug_interaction WHERE ORDER_ID=? AND ORDER_CATALOG_CODE=? ");

				ps.setString(1,order_id);
				ps.setString(2,catalog_code);
				
				rsSet = ps.executeQuery();
				while(rsSet.next()){
					cnt = rsSet.getInt("cnt");
				}
				if(cnt>0)
					status = true;

				if(rsSet!=null)//15950
					rsSet.close();//15950
				if(ps!=null)
					ps.close();
			
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(ps!=null)
					ps.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
		return status;
	}
	//IN072654 Ends
	//IN065942, ends
 }