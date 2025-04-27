/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 ******************************************************************************/
 /*----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019	  	IN061197	     	Manickavasagam 		  									 GHL-CRF-0549 [IN068344]  
17/07/2019	  	IN061197	     	Manickavasagam 		  									 ML-BRU-SCF-1966  
10/06/2020      IN:072715           Haribabu                                                 MMS-DM-CRF-0165
15/09/2020		IN:073757	        Manickavasagam J			     ML-MMOH-SCF-1596
22/1/2021		12988				Shazana													SKR-SCF-1562	
14/7/2022		29316				Shazana														ML-BRU-SCF-2146
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package ePH.Prescription;
import java.rmi.* ; 
import java.util.Calendar;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties; 
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import oracle.sql.*;
import java.io.*;
import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;
import java.text.SimpleDateFormat;

/**
*
* @ejb.bean
*	name="Prescription"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Prescription"
*	local-jndi-name="Prescription"
*	impl-class-name="ePH.Prescription.PrescriptionManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.Prescription.PrescriptionLocal"
*	remote-class="ePH.Prescription.PrescriptionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.Prescription.PrescriptionLocalHome"
*	remote-class="ePH.Prescription.PrescriptionHome"
*	generate= "local,remote"
*
*
*/

public class PrescriptionManager extends PhEJBSessionAdapter {

	String SQL_PH_SLIDING_SCALE_SELECT5			= 	null;
 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/ 
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert( HashMap tabData, HashMap sqlMap ) {    
	System.out.println(tabData+"82 tabData");
	System.out.println(sqlMap+"82 sqlMap");
		StringBuffer test	=new StringBuffer();
		HashMap map			= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "EJB STARTS") ;
		map.put("msgid","INSERT");
		Connection connection				= null ;
		PreparedStatement pstmt_insert		= null ;
		PreparedStatement pstmt				= null ;
		PreparedStatement pstmt_select		= null ;
		PreparedStatement pstmt_clob		= null ;
		CallableStatement cstmt_insert		= null;
		ResultSet rset_clob					= null;
		ResultSet resultSet					= null ;
		PreparedStatement pstmt_workload		 = null;
		PreparedStatement workload_insert		 = null;
		PreparedStatement work_insert_month		 = null;
		PreparedStatement work_insert_loc		 = null;
		PreparedStatement work_insert_loc_mon	 = null;
		ResultSet resultSet_workload			 = null;	
		PreparedStatement pstmt_update				=	null;
		String dly_count						 = "";
		String monthly_count					 = "";
		String dly_count_loc					 = "";
		String monthly_count_loc				 = "";
		String prn_remarks_temp="";
		String prn_remarks_code="";
		HashMap prn_remarks_hash=new HashMap();;
		String worloadDate			=	"";
		String patient_Class		=	"";
		String allergy_yn			=	"N";
		String login_by_id					=	"";
		String login_at_ws_no				=	"";
		String login_facility_id			=	"";
		String bed_num = "";
		String room_num= "";
		String language_id = "";
		String facility_id			=	"";
		String encounter_id			=	"";
		String patient_id			=	"";
		String trn_group_ref = "";
		HashMap consumable_tabData	= null;
		HashMap consumable_sqlMap		= null;

		HashMap freq_char_list	 = null;
		ArrayList day_list	= null;
		ArrayList day_names	=null;
		ArrayList time_list	= null;
		ArrayList dose_list	= null;

		HashMap tempHeader				=	null;
		String ord_date_time			=	null;
		String priority					=	null;
		String ord_pract_id				=	null;				                  
		String sdesc					=	null;
		String dosage_type				=	null;
		String qty_value				=	null;
		float    tot_qty_value			=0;
		String qty_unit					=	null;
		String repeat_value				=	null;
		String durn_value				=	null;
		String strength_value			=	null;
		String strength_uom				=	null;
		String pres_base_uom			=	null;                                 
		String fract_dose				=	null;
		String strength_per_value_per_pres_uom	=	null;
		String strength_per_pres_uom	=	null;
		String content_in_pres_base_uom	=	null;
		String in_qty_unit				=	null; 
		String in_order_qty				=	null; 
		String in_order_uom				=	null; 
		String line_status				=	null;
		String authroize_yn				=	null;
		String approval_yn				=	null;
		String consent_reqd_yn			=	null;
		String init_auth_reqd_yn		=	null;
		String init_spl_appr_reqd_yn	=	null;
		String init_cosign_reqd_yn		=	null;
		String cosign_reqd_yn			=	null;
		String Priority                 =   null;
		String split_dose_yn_val        =   "N";
		String qty_value_1				=   null;
		String str_tot_qty_value		=	null;
		String freq_nature		= "";
		
		String quota_limit_exceded_yn=null;   // ML-MMOH-CRF-1823 US008- 43528 
		String quota_limit_access_yn=null;   // ML-MMOH-CRF-1823 US008- 43528 
		String quota_limit_site_yn=null;   // ML-MMOH-CRF-1823 US008- 43528 
		String quota_limit_req_yn=null;   // ML-MMOH-CRF-1823 US008- 43528 
			
		float  qty_value_2				= 0;
		float durn_value_calc			=	1;
		HashMap DrugValues= null;
		String line_display_text="", stkuom, tmp_qty, equl_value="1", child_order_yn, parent_order_id, ddesc;
		float ord_qty	=	0.0f;
		HashMap chkValuescheduleFrequency = null;
		ArrayList schedule = null;
		ArrayList frequencyValues=null;
		double interval_value = 1;
		float act_qty=0.0f, tot_strn=0.0f;
		boolean found		=	false;
		boolean firstTime	=	true;
		String tmp			=	"";
		String admin_qty	=	null;
		//String org_order_id = ""; //added for JD-CRF-198 Unused local variable INC63877

		try {
			ArrayList OrderID					= (ArrayList) tabData.get("OrderID");
			ArrayList OrderDetails				= (ArrayList) tabData.get("OrderDetails");
			ArrayList OrderHeader				= (ArrayList) tabData.get("OrderHeader");
			ArrayList diag_text					= (ArrayList) tabData.get("diag_text");
			ArrayList mandatory_flds			= (ArrayList) tabData.get("mandatory_flds");
			ArrayList DrugRemarks				= (ArrayList) tabData.get("DrugRemarks");
			HashMap orderID_Priotiry			= (HashMap)tabData.get("orderID_Priotiry");
			HashMap	 ScheduleFreq				= (HashMap) tabData.get("ScheduleFreq");
			HashMap disp_location				= (HashMap)tabData.get("disp_location");
			String license						= (String)tabData.get("license");
			String called_from					= (String)tabData.get("called_from");
			HashMap prn_remarks					= (HashMap)tabData.get("prn_remarks");//code added for PRN Remarks..
			HashMap nonPreferenceRemarksDrug    = (HashMap)tabData.get("nonPreferenceRemarksDrug");//GHL-CRF-0618
			String external_ref_facility		= (String)tabData.get("external_ref_facility");//code added for external prescription..
			String external_date_ref			= (String)tabData.get("external_date_ref");
			String external_ref_practitioner	= (String)tabData.get("external_ref_practitioner");
			String external_remarks				= (String)tabData.get("external_remarks");
			HashMap old_order_det				= (HashMap)tabData.get("old_order_det");
			String totalTaperQtyDisplay			= (String)tabData.get("totalTaperQtyDisplay")==null?"":(String)tabData.get("totalTaperQtyDisplay");
			String print_mar_label			= (String)tabData.get("print_mar_label")==null?"":(String)tabData.get("print_mar_label"); //added for MMS-QH-CRF-0080 [IN:038064]
			String print_mar_barcode			= (String)tabData.get("print_mar_barcode")==null?"":(String)tabData.get("print_mar_barcode");//added for MMS-QH-CRF-0080 [IN:038064]
			String MAR_barcode_id="";//added for MMS-QH-CRF-0080 [IN:038064]
			language_id							= (String) tabData.get("language_id");
             String placed_from_verbal_order=(String)tabData.get("placed_from_verbal_order")==null?"N":(String)tabData.get("placed_from_verbal_order");//ADDED FOR GHL-CRF-0509
			 String pre_alloc_app_yn			= (String) tabData.get("pre_alloc_appl_yn");//MMS-MD-SCF-0170
			if(mandatory_flds.size() > 1) {
				login_by_id					= (String)mandatory_flds.get(0);
				login_at_ws_no				= (String)mandatory_flds.get(1);
				login_facility_id			= (String)mandatory_flds.get(2);
			}
			String OrderRemarks							= (String) tabData.get("OrderRemarks");
			String sql_ph_prescription_select54			= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT54");
			String sql_ph_prescription_select20a		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT20A");
			String sql_ph_prescription_select19a		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT19A");
			String sql_ph_prescription_select55			= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT55");
			String sql_ph_prescription_select56			= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT56");
			String sql_ph_prescription_select56a		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT56A");
			String sql_ph_prescription_select57			= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT57");
			String sql_ph_prescription_select53			= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT53");
			String sql_ph_prescription_select64			= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT64");
			String sql_ph_prescription_select72			= (String) sqlMap.get("SQL_PH_PRESCRIPTION_SELECT72");
			String sql_ph_prescription_select73			= (String) sqlMap.get("SQL_PH_PRESCRIPTION_SELECT73");
			String sql_ph_prescription_select74			= (String) sqlMap.get("SQL_PH_PRESCRIPTION_SELECT74");
			String sql_ph_prescription_select75			= (String) sqlMap.get("SQL_PH_PRESCRIPTION_SELECT75");
			String sql_ph_prescription_select24b		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT24B");
			String sql_ph_prescription_select25a		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT25A");
			SQL_PH_SLIDING_SCALE_SELECT5				= (String) sqlMap.get( "SQL_PH_SLIDING_SCALE_SELECT5");			
			String sql_ph_gen_MARDarcodeId		= (String) sqlMap.get( "SQL_PH_GEN_MARDARCODEID");  //added for  MMS-QH-CRF-0080 [IN:038064]

			String SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT							= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT");
			//String sql_insert_1							= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT1");
			String sql_insert_1		= "INSERT INTO OR_ORDER (ORDER_ID,ORDER_TYPE_CODE,ORDER_CATEGORY,CONTR_SYS_ID,PATIENT_ID,PATIENT_CLASS,ORDERING_FACILITY_ID,ENCOUNTER_ID,EPISODE_ID,EPISODE_VISIT_NUM,SOURCE_TYPE,SOURCE_CODE,DISCHARGE_IND,ORD_DATE_TIME,ORD_PRACT_ID,PRIORITY,ORD_AUTH_REQD_YN,ORD_AUTH_LEVEL,ORD_AUTH_BY_PRACT_ID,ORD_AUTH_DATE_TIME,ORD_APPR_REQD_YN,ORD_APPR_BY_USER_ID,ORD_APPR_DATE_TIME,ORD_COSIGN_REQD_YN,ORD_COSIGN_LEVEL,ORD_COSIGN_BY_PRACT_ID,ORD_COSIGN_DATE_TIME,ORD_PRINT_DATE_TIME,BILL_YN,CONT_ORDER_IND,PERFORMING_FACILITY_ID,PERFORMING_SYS_ID,PERFORMING_DEPTLOC_TYPE,PERFORMING_DEPTLOC_CODE,PERFORMING_PRACT_ID,RESULT_AUTH_REQD_YN,CHILD_ORDER_YN,PARENT_ORDER_ID,ORDER_SET_YN,ORDER_SET_ID,IV_PREP_YN,ORDER_FIELDS_DISPLAY_TEXT,ORDER_STATUS,RESULT_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORD_CONSENT_REQD_YN,ORD_CONSENT_BY_ID,ORD_CONSENT_BY_DATE_TIME,CAN_REASON,REF_FACILITY_ID,REF_DATE_TIME,REF_SENT_PRACT_ID,REF_RECIEVED_REMARKS,REF_RECIEVED_PRACT_ID,REF_RECIEVED_DATE_TIME,TRN_GROUP_REF,CATALOG_SPLTY_CODE,HOME_LEAVE_MEDN_YN,ORD_QUOTA_LIMIT_YN) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?)";//ML-MMOH-CRF-1823 US008- 43528 //added HOME_LEAVE_MEDN_YN for the CRF Bru-HIMS-CRF-093[29960]
			//String sql_insert_2							= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT2");
			String sql_insert_2		= "INSERT INTO OR_ORDER_LINE (ORDER_ID,ORDER_LINE_NUM,ORDER_CATALOG_CODE,CATALOG_DESC,CATALOG_SYNONYM,ORDER_CATALOG_NATURE,ORDER_TYPE_CODE,ORDER_CATEGORY,ORD_DATE_TIME,PRIORITY,ORD_AUTH_REQD_YN,ORD_AUTH_REASON,ORD_APPR_REQD_YN,ORD_COSIGN_REQD_YN,START_DATE_TIME,FORM_CODE,ROUTE_CODE,QTY_VALUE,QTY_UNIT,FREQ_CODE,DURN_VALUE,DURN_TYPE,LINE_FIELDS_DISPLAY_TEXT,ITEM_NARRATION,NEXT_SCHED_DATE,END_DATE_TIME,AUTO_STOP_DATE_TIME,ORDER_QTY,ORDER_UOM,APPT_REQD_YN,APPT_DATE_TIME,APPT_REF_NUM,RESULT_APPLICABLE_YN,BILL_YN,BILLED_YN,CONT_ORDER_IND,REFILL_SINGLE_CONT_ORDER_YN,NUM_OF_REFILLS,CHILD_ORDER_YN,PARENT_ORDER_ID,PARENT_ORDER_LINE_NUM,ORDER_SET_ID,ORDER_SET_LINE_NUM,ORD_PRACT_ID,ORD_SET_DATE_TIME,AMD_PRACT_ID,AMD_DATE_TIME,HOLD_PRACT_ID,HOLD_DATE_TIME,RESUME_PRACT_ID,RESUME_DATE_TIME,DISC_PRACT_ID,DISC_DATE_TIME,CAN_PRACT_ID,CAN_DATE_TIME,ACCESSION_NUM,ACCESSION_LINE_NUM,ORDER_LINE_STATUS,RESULT_LINE_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORD_CONSENT_REQD_YN,CAN_LINE_REASON,CATALOG_SYNONYM_DC,CATALOG_SYNONYM_AD,RESULT_AUTH_REQD_YN,  ORD_CONSENT_STAGE, ORD_CONSENT_STATUS, NUM_OF_CONSENT_REQ_BO, NUM_OF_CONSENT_REQ_BR,CATALOG_SPLTY_CODE,VERBAL_ORDER_WITNESS_BY_ID,ORG_ORDER_ID,ORD_QUOTA_LIMIT_YN) VALUES (?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//ML-MMOH-CRF-1823 -US008 - 43528 //Added VERBAL_ORDER_WITNESS_BY_ID for AAKH-CRF-0023[IN:038259] and added for JD-CRF-198
			String sql_insert_3		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT3");
			String sql_insert_4		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT4");
			String sql_insert_5		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT5");
			String sql_insert_6		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT6");
			String sql_insert_7		= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT7");
			sql_insert_7		    =  "INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			//String sql_insert_8 = (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT8");
			String sql_insert_8	= "INSERT INTO PH_MEDN_ADMIN (FACILITY_ID,ENCOUNTER_ID,SCH_DATE_TIME,ORD_DRUG_CODE,DOSAGE_SEQ_NO,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,SCH_DOSAGE_QTY,SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VERIFY_REQD_YN,ADMINISTERED_YN,SLIDING_SCALE_YN, MAR_BARCODE_ID) VALUES (?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?, ?)";
			String sql_ph_prescription_insert9	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT9");
			String sql_ph_prescription_insert10	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT10");
			String sql_ph_prescription_insert11	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT11");
			String sql_ph_prescription_insert12	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT12");

			String sql_ph_renew_prescription_insert1	= (String) sqlMap.get( "SQL_PH_RENEW_PRESCRIPTION_INSERT1");			
			String sql_ph_renew_prescription_insert2	= (String) sqlMap.get( "SQL_PH_RENEW_PRESCRIPTION_INSERT2");			

			String sql_ph_prescription_modify6	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY6");
			String sql_ph_prescription_modify7	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY7");
			String sql_ph_prescription_modify8	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY8");
			String sql_ph_prescription_modify9	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY9");
			String SQL_PH_PRESCRIPTION_INSERT_SLD_SCALE	= (String) sqlMap.get("SQL_PH_PRESCRIPTION_INSERT_SLD_SCALE");

			consumable_tabData	= (HashMap) tabData.get("consumable_tabData");
			consumable_sqlMap	= (HashMap) sqlMap.get("consumable_sqlMap");

			int result_insert_5			= 0;
			boolean insert_rec_1		= false;
			boolean insert_rec_2		= false;
			boolean insert_rec_3		= false;
			boolean insert_rec_4		= false;
			boolean insert_rec_5		= false;
			boolean insert_rec_6		= false;
			boolean insert_rec_7		= false;
			boolean insert_rec_8		= false;
			boolean insert_rec_9		= false;
			boolean consumable_insert	= true;
			ArrayList unique_drugs		= new ArrayList();
			int seqNo					=	0;
			int srl_NO					= 0;
			String patientId			= "";
			String facilityId			= "";
			String patientClass			= "";
			String locationType			= "";
			String locationCode			= "";
			String encounterId			= "";
			String practId				= "";
			String regn_reqd_yn			= "";
			String order_status			= "";
			String height				= "";
			String weight				= "";
			String bsa					= "";
			String bmi					= "";
			String height_unit			= "";
			String weight_unit			= "";
			String bsa_unit				= "";
			String drug_code			= "";
			String perf_facility		= "";
			String perf_sys				= "";
			String perf_deptloc_type	= "";
			String perf_deptloc_code	= "";
			String scheduled_yn			="";
			String auth_reqd_yn			="";
			String dsg_reason="";
			String dup_reason = "";
			String con_reason="";
			String int_reason = "";
			String alg_reason = "";
			String alternate_amend_reason	=	"";
			String buildMAR_yn				=	"";
			String drug_tapered, tapered_yn="", taper_order_id="", taper_order_line_num="", prev_drugCode="", tap_lvl_qty="";

			HashMap ord_line			=	null;
			HashMap order_line_det		=	new HashMap();
			HashMap orderStatusCode		=	new HashMap() ;
			//connection = getConnection() ;
			connection							= getConnection((Properties)tabData.get( "properties" )) ;
			connection.setAutoCommit(false);
			boolean verify_pat_brought_medn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","VERIFY_PAT_BROUGHT_MEDN");//added for TH-KW-CRF-0002
			String sys_date						= "";
			pstmt								= connection.prepareStatement(sql_ph_prescription_select54) ;
			resultSet							= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				sys_date = resultSet.getString(1);
			}
			closeResultSet( resultSet );
			closeStatement( pstmt) ;
			pstmt_select								= connection.prepareStatement(SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT) ;
			resultSet							= pstmt_select.executeQuery();

			if(resultSet!=null && resultSet.next()) {
				trn_group_ref = resultSet.getString("TRN_GROUP_REF");
			}
			closeResultSet( resultSet );
			closeStatement( pstmt_select) ;

			pstmt			= connection.prepareStatement(sql_ph_prescription_select20a) ;
			resultSet		= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}
			closeResultSet( resultSet );
			closeStatement( pstmt) ;
			pstmt_insert		= connection.prepareStatement(sql_insert_1) ;
			HashMap insertRecords= null;
			HashMap OrderLineDetail= null;
			ArrayList tmp_druglist	=	null;
			HashMap tmp_drugdata	=	null;
			String ord_type_code,order_id;
			ArrayList headerList = null;
			HashMap insertRecords_2 = null;
            PreparedStatement pstmt_or_order_type	= connection.prepareStatement(sql_ph_prescription_select19a) ;
			int taper_seq_no =0; //added for RUT-CRF-0094 [IN:037443]
//INSERTING INTO OR_ORDER
			for (int i=0;i<OrderHeader.size() ;i++ ){
				insertRecords=(HashMap)OrderHeader.get(i);
				OrderLineDetail=(HashMap)((ArrayList)OrderDetails.get(i)).get(0);
				height		=(String)insertRecords.get("HEIGHT");
				weight		=(String)insertRecords.get("WEIGHT");
				bsa			=(String)insertRecords.get("BSA");
				bmi			=(String)insertRecords.get("BMI");
				bsa_unit	=(String)insertRecords.get("BSA_UNIT");
				height_unit	=(String)insertRecords.get("HEIGHT_UNIT");
				weight_unit	=(String)insertRecords.get("WEIGHT_UNIT");
				 quota_limit_exceded_yn=(String)insertRecords.get("QUOTA_LIMIT_EXCEDED_YN");  // ML-MMOH-CRF-1823 US008- 43528 
				 quota_limit_access_yn=(String)insertRecords.get("QUOTA_LIMIT_ACCESS_YN");  // ML-MMOH-CRF-1823 US008- 43528 
				 quota_limit_site_yn=(String)insertRecords.get("QUOTA_LIMIT_SITE_YN"); // ML-MMOH-CRF-1823 US008- 43528 
				 quota_limit_req_yn=(String)insertRecords.get("QUOTA_LIMIT_REQ_YN"); // ML-MMOH-CRF-1823 US008- 43528 
				 System.err.println("quota_limit_access_yn@371=="+quota_limit_access_yn+"quota_limit_site_yn=="+quota_limit_site_yn+"quota_limit_req_yn=="+quota_limit_req_yn+"QUOTA_LIMIT_EXCEDED_YN=="+quota_limit_exceded_yn);

				pstmt_insert.setString(1,(String)insertRecords.get("ORDER_ID"));
				pstmt_insert.setString(2,(String)insertRecords.get("ORDER_TYPE_CODE"));
				ord_type_code=(String)insertRecords.get("ORDER_TYPE_CODE");
				
				pstmt_or_order_type.setString(1,ord_type_code);
				resultSet		= pstmt_or_order_type.executeQuery();
				if(resultSet!=null && resultSet.next()){
					regn_reqd_yn=resultSet.getString(1);
				}
				closeResultSet( resultSet );
				
				pstmt_insert.setString(3,"PH");
				pstmt_insert.setString(4,"PH");
				pstmt_insert.setString(5,(String)insertRecords.get("PATIENT_ID"));
				patientId		= (String)insertRecords.get("PATIENT_ID");
				bed_num = (String)insertRecords.get("BED_NUM")==null?"":(String)insertRecords.get("BED_NUM");
				room_num = (String)insertRecords.get("ROOM_NUM")==null?"":(String)insertRecords.get("ROOM_NUM");
				
				//code modified for External Prescription...
				if( ((String)tabData.get("external_pres_flag")).equals("true")){
					patientClass	= "XT";
				}
				else{
					patientClass	= (String)insertRecords.get("PATIENT_CLASS");
				}
				pstmt_insert.setString(6,patientClass);
				pstmt_insert.setString(7,(String)insertRecords.get("FACILITY_ID"));
				facilityId		= (String)insertRecords.get("FACILITY_ID");
				pstmt_insert.setString(8,(String)insertRecords.get("ENCOUNTER_ID"));
				encounterId		=(String)insertRecords.get("ENCOUNTER_ID");
				pstmt_insert.setString(9,(String)insertRecords.get("ENCOUNTER_ID"));
				pstmt_insert.setString(10,"");
				if( ((String)tabData.get("external_pres_flag")).equals("true")){
					pstmt_insert.setString(11,"");
				}
				else{
					pstmt_insert.setString(11,(String)insertRecords.get("SOURCE_TYPE"));
				}

				locationType=(String)insertRecords.get("SOURCE_TYPE");
				//code modified for External Prescription...
				if( ((String)tabData.get("external_pres_flag")).equals("true")){
					pstmt_insert.setString(12,"");
				}
				else{
					pstmt_insert.setString(12,(String)insertRecords.get("SOURCE_CODE"));
				}
				//code added for External Prescription..
				if(((String)tabData.get("external_pres_flag")).equals("true")){
					locationCode=(String)insertRecords.get("DISP_LOCN_CODE");
				}
				else{
					locationCode=(String)insertRecords.get("SOURCE_CODE");
				}
				pstmt_insert.setString(13,(String)insertRecords.get("DISCHARGE_IND"));
				pstmt_insert.setString(14,(String)insertRecords.get("ORDER_DATE_TIME"));
				pstmt_insert.setString(15,(String)insertRecords.get("ORD_PRACT_ID"));
				practId=(String)insertRecords.get("ORD_PRACT_ID");
				
/*				if(((String)OrderLineDetail.get("PRIORITY")).equalsIgnoreCase("routine") || ((String)OrderLineDetail.get("PRIORITY")).equalsIgnoreCase("r"))
					pstmt_insert.setString(16,"R");
				else
					pstmt_insert.setString(16,"U");
*/
				pstmt_insert.setString(16,(String)orderID_Priotiry.get((String)insertRecords.get("ORDER_ID")));
				order_status		= (String)insertRecords.get("ORDER_STATUS");
				if(!tabData.get("AmendAlternateDrug").equals("Y")){//if condition added for  JD-CRF-0198 [IN:058599]
				if(order_status.equals("10") || order_status.equals("25")){
					if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y"))
						order_status="25";
					else
						order_status="10";
				}
				}
				// ML-MMOH-CRF-1823 US008 
				if(quota_limit_site_yn.equals("Y") && quota_limit_req_yn.equals("Y") && quota_limit_exceded_yn.equals("Y") &&  quota_limit_access_yn.equals("N")){				//PQ - Pend Quota Appr check 1823 US008
						  order_status ="01";
					 }
				order_status = (String)orderStatusCode.get(order_status);
				boolean other_status_found	=	false;
				for(int n=0;n<OrderID.size();n++){
					order_id			=(String) OrderID.get(n);
					headerList	=(ArrayList) OrderDetails.get(n);

					if(order_id.equals((String)insertRecords.get("ORDER_ID")) && headerList.size()>1) {
						for(int p=0;p<headerList.size();p++){
							insertRecords_2=(HashMap) headerList.get(p);
							if( (insertRecords_2.get("BROUGHT_BY_PAT")==null) || (((String)insertRecords_2.get("BROUGHT_BY_PAT")).equals("")) || (((String)insertRecords_2.get("BROUGHT_BY_PAT")).equals("N")) ) {
								other_status_found	=	true;
								break;
							}
						}
						break;
					} 
					else if(order_id.equals((String)insertRecords.get("ORDER_ID")))  {
						for(int p=0;p<headerList.size();p++){
							insertRecords_2=(HashMap) headerList.get(p);
							if( insertRecords_2.get("BROUGHT_BY_PAT")!=null && ((String)insertRecords_2.get("BROUGHT_BY_PAT")).equals("Y")) {
								System.err.println("verify_pat_brought_medn@@@===="+verify_pat_brought_medn);
								if(!verify_pat_brought_medn){//Added if condition TH-KW-CRF-0002
								  order_status		=	(String)orderStatusCode.get("58");
								}
								System.err.println("order_status@@@=="+order_status);
							}
						}
						other_status_found	=	true;
						break;
					}
				}

				if(!other_status_found) {
					order_status		=	(String)orderStatusCode.get("58");
				}

				/*if(order_status.equals("PO"))
					auth_reqd_yn="Y";
				else
					auth_reqd_yn="N";
				*/
				pstmt_insert.setString(17,(String)insertRecords.get("ORD_AUTH_REQD_YN")==null?"N":(String)insertRecords.get("ORD_AUTH_REQD_YN"));
				pstmt_insert.setString(18,(String)insertRecords.get("ORD_AUTH_LEVEL"));

				if((String)insertRecords.get("ORD_AUTHORIZED_YN")!=null && ((String)insertRecords.get("ORD_AUTHORIZED_YN")).equals("Y")){
					/*if( ((String)tabData.get("external_pres_flag")).equals("true")) //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
						pstmt_insert.setString(19,login_by_id);
					else*/
						pstmt_insert.setString(19,(String)insertRecords.get("ORD_PRACT_ID"));
				}
				else
					pstmt_insert.setString(19,"");

				if(auth_reqd_yn.equals("")||auth_reqd_yn.equals("N"))
					pstmt_insert.setString(20,null);
				else
					pstmt_insert.setString(20,(String)insertRecords.get("ORDER_DATE_TIME"));

				if(insertRecords.get("ORD_APPR_REQD_YN")==null) 
					pstmt_insert.setString(21,"N");
				else 
					pstmt_insert.setString(21,(String)insertRecords.get("ORD_APPR_REQD_YN"));

				if((String)insertRecords.get("ORD_APPROVED_YN")!=null && ((String)insertRecords.get("ORD_APPROVED_YN")).equals("Y")){
					/*if( ((String)tabData.get("external_pres_flag")).equals("true")) //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
						pstmt_insert.setString(22,login_by_id);
					else*/
						pstmt_insert.setString(22,(String)insertRecords.get("ORD_PRACT_ID"));
				}
				else
					pstmt_insert.setString(22,"");

				if(insertRecords.get("ORD_APPR_REQD_YN")!= null && ((String)insertRecords.get("ORD_APPR_REQD_YN")).equals("N"))
					pstmt_insert.setString(23,null);
				else
					pstmt_insert.setString(23,(String)insertRecords.get("ORDER_DATE_TIME"));

				if(insertRecords.get("ORD_COSIGN_REQD_YN")==null) 
					pstmt_insert.setString(24,"N");
				else 
					pstmt_insert.setString(24,(String)insertRecords.get("ORD_COSIGN_REQD_YN"));

				pstmt_insert.setString(25,"");
				pstmt_insert.setString(26,"");
				pstmt_insert.setString(27,null);
				pstmt_insert.setString(28,null);
				pstmt_insert.setString(29,"N");
				pstmt_insert.setString(30,(String)insertRecords.get("CONT_ORDER_IND"));
				if(!license.equals("PHBASIC")) {
					
					perf_sys			=	"PH";
					perf_deptloc_type	=	"P";

					tmp_druglist	=	(ArrayList)OrderDetails.get(i);
					tmp_drugdata	=	(HashMap)tmp_druglist.get(0);
				
					if(tmp_drugdata.containsKey("SRL_NO")) {
						if( disp_location.containsKey( (String)tmp_drugdata.get("SRL_NO") ) ) {
							perf_deptloc_code	= (String)disp_location.get((String)tmp_drugdata.get("SRL_NO"));
						}
						else {
							if(insertRecords.get("DISP_LOCN_CODE")!=null) {
								perf_deptloc_code	=	(String)insertRecords.get("DISP_LOCN_CODE");
							}
						}
					}
					else {
						if(insertRecords.get("DISP_LOCN_CODE")!=null) {
							perf_deptloc_code	=	(String)insertRecords.get("DISP_LOCN_CODE");
						}
					} 
				}
				else {
					perf_deptloc_code	= (String)insertRecords.get("SOURCE_CODE");
					perf_deptloc_type	= (String)insertRecords.get("SOURCE_TYPE");
				}

				perf_facility		=	(String)tmp_drugdata.get("PERFORMING_FACILITY_ID")==null?login_facility_id:(String)tmp_drugdata.get("PERFORMING_FACILITY_ID");
				pstmt_insert.setString(31,perf_facility);
				pstmt_insert.setString(32,perf_sys);
				pstmt_insert.setString(33,perf_deptloc_type);
				pstmt_insert.setString(34,perf_deptloc_code);
				pstmt_insert.setString(35,"");
				pstmt_insert.setString(36,"N");
				pstmt_insert.setString(37,(String)insertRecords.get("CHILD_ORDER_YN"));
				pstmt_insert.setString(38,(String)insertRecords.get("PARENT_ORDER_ID"));
				pstmt_insert.setString(39,"N");
				pstmt_insert.setString(40,"");
				pstmt_insert.setString(41,"");
				pstmt_insert.setString(42,"");

				pstmt_insert.setString(43,order_status);
				pstmt_insert.setString(44,"");
				pstmt_insert.setString(45,login_by_id);
				pstmt_insert.setString(46,login_at_ws_no);
				pstmt_insert.setString(47,login_facility_id);
				pstmt_insert.setString(48,login_by_id);
				pstmt_insert.setString(49,login_at_ws_no);
				pstmt_insert.setString(50,login_facility_id);

				if(insertRecords.get("CONSENT_REQD_YN")==null) {
					pstmt_insert.setString(51,"N");
				}
				else {
					pstmt_insert.setString(51,(String)insertRecords.get("CONSENT_REQD_YN"));
				}

				pstmt_insert.setString(52,"");
				pstmt_insert.setString(53,"");
				pstmt_insert.setString(54,"");
				if(  ((String)tabData.get("external_pres_flag")).equals("true")) {

					pstmt_insert.setString(55,external_ref_facility);
					pstmt_insert.setString(56,external_date_ref);
					pstmt_insert.setString(57,external_ref_practitioner);
					pstmt_insert.setString(58,external_remarks);
					pstmt_insert.setString(59,(String)insertRecords.get("ORD_PRACT_ID")); // login_by_id //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
					pstmt_insert.setString(60,sys_date);
				}
				else {
					pstmt_insert.setString(55,"");
					pstmt_insert.setString(56,"");
					pstmt_insert.setString(57,"");
					pstmt_insert.setString(58,"");
					pstmt_insert.setString(59,"");
					pstmt_insert.setString(60,"");
				}
				pstmt_insert.setString(61,trn_group_ref);
				pstmt_insert.setString(62,(String)insertRecords.get("CATALOG_SPLTY_CODE"));
				pstmt_insert.setString(63,(String)insertRecords.get("HOME_LEAVE_YN_VAL"));//added HOME_LEAVE_MEDN_YN for the CRF Bru-HIMS-CRF-093[29960]
				pstmt_insert.setString(64,quota_limit_access_yn);//ML-MMOH-CRF-1823 - 43528 
				// add the statement to the batch
				pstmt_insert.addBatch();
			}
			int[] result_insert= pstmt_insert.executeBatch();
			closeStatement( pstmt_insert) ;
			closeResultSet( resultSet );
			closeStatement( pstmt_or_order_type) ;
			
			for (int i=0;i<result_insert.length ;i++ ) {
				if(result_insert[i]<0  && result_insert[i] != -2 ){
					System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER result_insert["+i+"]= "+result_insert[i]);
					System.err.println("tabData=== "+tabData);
					insert_rec_1=false;
					break;
				}
				else{
					insert_rec_1=true;
				}
			}

//INSERTING INTO OR_ORDER_LINE
			if(insert_rec_1){
				headerList=null;
				pstmt_insert	= connection.prepareStatement(sql_insert_2) ;
				pstmt_insert.clearBatch();
				
			    PreparedStatement pstmt_am_uom_eqvl	= connection.prepareStatement(sql_ph_prescription_select53) ;
				PreparedStatement pstmt_ph_drug_vw	= connection.prepareStatement(sql_ph_prescription_select64) ;

				for(int i=0;i<OrderID.size();i++){
					headerList		= null;
					tempHeader		= (HashMap) OrderHeader.get(i);
					ord_date_time	= (String)tempHeader.get("ORDER_DATE_TIME");
					priority		= (String)tempHeader.get("PRIORITY");
					/*if( ((String)tabData.get("external_pres_flag")).equals("true")){ //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
						ord_pract_id	= login_by_id;
					}
					else{*/
						ord_pract_id	= (String)tempHeader.get("ORD_PRACT_ID")==null?"":(String)tempHeader.get("ORD_PRACT_ID");
					//}
					if( ord_pract_id.equals(""))
						ord_pract_id	= login_by_id;
					   // ML-MMOH-CRF-1823 US008- 43528 
					 quota_limit_access_yn=(String)tempHeader.get("QUOTA_LIMIT_ACCESS_YN");  // ML-MMOH-CRF-1823 US008- 43528 
					 quota_limit_site_yn=(String)tempHeader.get("QUOTA_LIMIT_SITE_YN");  // ML-MMOH-CRF-1823 US008- 43528 
					 quota_limit_req_yn=(String)tempHeader.get("QUOTA_LIMIT_REQ_YN");  // ML-MMOH-CRF-1823 US008- 43528 
					order_id		= (String) OrderID.get(i);
					headerList		= (ArrayList) OrderDetails.get(i);
					ord_line		=	new HashMap();

					for(int j=0;j<headerList.size();j++){
						insertRecords_2= null;
						insertRecords_2=(HashMap) headerList.get(j);
						quota_limit_exceded_yn=(String)insertRecords_2.get("QUOTA_LIMIT_EXCEDED_YN");
						//System.err.println("quota_limit_exceded_yn@@@=="+quota_limit_exceded_yn);

						dose_list		=  null;
						pstmt_insert.setString(1,order_id);
						pstmt_insert.setString(2,""+(j+1));						
						pstmt_insert.setString(3,(String)insertRecords_2.get("DRUG_CODE"));
						ord_line.put(((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO")),""+(j+1));

						drug_code=(String)insertRecords_2.get("DRUG_CODE");		
						pstmt_insert.setString(4,(String)insertRecords_2.get("SHORT_DESC"));
						sdesc="";
						sdesc=(String)insertRecords_2.get("SHORT_DESC");
						if (sdesc!=null && !sdesc.equals("") && sdesc.length()>40){
							sdesc=sdesc.substring(0,40);
						}
						pstmt_insert.setString(5,sdesc);
						pstmt_insert.setString(6,"");
						pstmt_insert.setString(7,(String)insertRecords_2.get("ORDER_TYPE_CODE"));
						pstmt_insert.setString(8,"PH");

						pstmt_insert.setString(9,ord_date_time);
                        if( insertRecords_2.get("PRIORITY")==null){
                           Priority="R";
						}
						else{ 
							if((insertRecords_2.get("PRIORITY")).toString().equalsIgnoreCase("Routine")||insertRecords_2.get("PRIORITY").equals("R"))//Modified for Bru-HIMS-CRF-400 [IN:044502]
                               Priority="R";
							else
                               Priority="U";
						}
                        pstmt_insert.setString(10,Priority);
						
						if(insertRecords_2.get("ORD_AUTH_REQD_YN")==null)
							pstmt_insert.setString(11,"N");
						else
							pstmt_insert.setString(11,(String)insertRecords_2.get("ORD_AUTH_REQD_YN"));

						pstmt_insert.setString(12,"");

						if(insertRecords_2.get("ORD_SPL_APPR_REQD_YN")==null)
							pstmt_insert.setString(13,"N");
						else
							pstmt_insert.setString(13,(String)insertRecords_2.get("ORD_SPL_APPR_REQD_YN"));

						if(insertRecords_2.get("ORD_COSIGN_REQD_YN")==null) 
							pstmt_insert.setString(14,"N");
						else 
							pstmt_insert.setString(14,(String)insertRecords_2.get("ORD_COSIGN_REQD_YN"));

						if((String)insertRecords_2.get("START_DATE")==null) 
							pstmt_insert.setString(15,(String)insertRecords_2.get("START_DATE_TIME"));
						else
							pstmt_insert.setString(15,(String)insertRecords_2.get("START_DATE"));

						pstmt_insert.setString(16,(String)insertRecords_2.get("FORM_CODE"));
						pstmt_insert.setString(17,(String)insertRecords_2.get("ROUTE_CODE"));

						dosage_type						=	(String)insertRecords_2.get("DOSAGE_TYPE");
						qty_value							=	(String)insertRecords_2.get("QTY_VALUE");

						qty_unit							=	(String)insertRecords_2.get("QTY_DESC_CODE");
						repeat_value						=	(String)insertRecords_2.get("REPEAT_VALUE");
						durn_value							=	(String)insertRecords_2.get("DURN_VALUE");
						strength_value						=	(String)insertRecords_2.get("ACT_STRENGTH_VALUE");
						strength_uom						=	(String)insertRecords_2.get("STRENGTH_UOM");
						pres_base_uom						=	(String)insertRecords_2.get("PRES_BASE_UOM");
						scheduled_yn						=	(String)insertRecords_2.get("SCHEDULED_YN");
						fract_dose							=	(String)insertRecords_2.get("FRACT_DOSE_ROUND_UP_YN");
						strength_per_value_per_pres_uom	=	(String)insertRecords_2.get("STRENGTH_PER_VALUE_PRES_UOM");
						strength_per_pres_uom				=	(String)insertRecords_2.get("STRENGTH_PER_PRES_UOM");
						content_in_pres_base_uom			=	(String)insertRecords_2.get("CONTENT_IN_PRES_BASE_UOM");
						drug_tapered		=insertRecords_2.get("DRUG_TAPERED_YN")==null?"N":(String)insertRecords_2.get("DRUG_TAPERED_YN");
						tapered_yn		=insertRecords_2.get("TAPPERED_OVER")==null?"N":(String)insertRecords_2.get("TAPPERED_OVER");
						//if(totalTaperQtyDisplay.equals("Y") &&drug_tapered.equals("Y") && tapered_yn.equals("N"))
						if(totalTaperQtyDisplay.equals("Y") && (drug_tapered.equals("Y") || tapered_yn.equals("Y")))
							tap_lvl_qty		=insertRecords_2.get("TAP_LVL_QTY")==null?"1":(String)insertRecords_2.get("TAP_LVL_QTY");
						else
							tap_lvl_qty = "";
						freq_nature		=	(String)insertRecords_2.get("FREQ_NATURE");
						interval_value	=	Float.parseFloat((String)insertRecords_2.get("INTERVAL_VALUE")==null?"1":(String)insertRecords_2.get("INTERVAL_VALUE"));
						in_qty_unit						=	"";
						in_order_qty						=	"";
						in_order_uom						=	"";
						split_dose_yn_val					=	"N";
						qty_value_1						=	qty_value;

						if(insertRecords_2.get("freq_chng_durn_value")!=null && !durn_value.equals((String)insertRecords_2.get("freq_chng_durn_value"))){
							durn_value = (String)insertRecords_2.get("freq_chng_durn_value");
						}

						if(freq_nature.equals("F") || freq_nature.equals("I")) 
							durn_value_calc	=	(float)Math.ceil(Float.parseFloat(durn_value)/ interval_value);
						else
							durn_value_calc = Float.parseFloat(durn_value);
	
						chkValuescheduleFrequency	=	ScheduleFreq;
						schedule = null;
						if(scheduled_yn!=null && scheduled_yn.equals("Y")){
							if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
								if(chkValuescheduleFrequency.containsKey((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO")))
									schedule = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO"));
							}
						}
						if(insertRecords_2.containsKey("SPLIT_DOSE_YN_VAL"))
                            split_dose_yn_val=(String)insertRecords_2.get("SPLIT_DOSE_YN_VAL");
						else
							split_dose_yn_val="N";

						if(dosage_type.equals("A"))
							qty_value_1        =  qty_value;
						if(schedule!=null && schedule.size() > 0){
							dose_list	= (ArrayList)schedule.get(4);	
						}

						if(dose_list!=null && dose_list.size() > 0 && (split_dose_yn_val.equals("N"))){
							qty_value_1			="0";
						 
							if(fract_dose.equals("N")) { 
//								 HashMap detail	=	(HashMap)schedule.get(0);
//								 qty_value		=	(String)detail.get("admin_qty");
							     qty_value		=	(String)dose_list.get(0);
								 qty_value_1    =    qty_value;	 
							}
							else{
								//HashMap detail	=	(HashMap)schedule.get(0);
								if(dosage_type.equals("S")){
								   //qty_value		=	(String)detail.get("admin_qty");
								   qty_value		=	(String)dose_list.get(0);
								   qty_value_1      =   qty_value;
								   //qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
								}
								else if(dosage_type.equals("Q")){
								//	qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(0);
									qty_value_1     =   qty_value;
		//							qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+""; //commented while fixing IN23884 --06/12/2010-- priya

								} 
							}
							//repeat_value	=	""+schedule.size();
							repeat_value	=	""+dose_list.size();
						}
						else  if(dose_list!=null && dose_list.size() > 0 && (split_dose_yn_val.equals("Y"))){
							qty_value_1			="0";
							tot_qty_value       = 0;
							qty_value_2			= 0;
							if(fract_dose.equals("N")) {
								for(int tqI=0;tqI<dose_list.size();tqI++){
									repeat_value	=	"1";
									tot_qty_value	=	tot_qty_value+Float.parseFloat((String)dose_list.get(tqI));
								}
								/*for(int n=0; n<schedule.size(); n++) {
									repeat_value		=	"1";
									HashMap  detail	=  (HashMap)schedule.get(n);
									tot_qty_value    =  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));

								}*/
								qty_value_1        =  tot_qty_value+"";
							}
							else{
								for(int n=0; n<dose_list.size(); n++) {
									repeat_value		=	"1";
									//HashMap  detail	=  (HashMap)schedule.get(n);

									if(dosage_type.equals("S")){
										//qty_value		=	(String)detail.get("admin_qty");
										qty_value		=	(String)dose_list.get(n);
										qty_value_1		=	Float.parseFloat(qty_value_1)+Float.parseFloat(qty_value)+"";

										qty_value       =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
										qty_value_2     +=  (Math.ceil(Float.parseFloat(qty_value)*Float.parseFloat(strength_value)));
										qty_value       =   Float.parseFloat(qty_value)*Float.parseFloat(strength_value)+"";    
									}
									else if(dosage_type.equals("Q")){
										//qty_value		=	(String)detail.get("admin_qty");
										qty_value		=	(String)dose_list.get(n);
										qty_value_1     =   Float.parseFloat(qty_value_1)+Float.parseFloat(qty_value)+"";
										qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
										qty_value_2    +=   Float.parseFloat(qty_value);

									}  
									tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
									str_tot_qty_value 			 =  Float.toString(tot_qty_value);
									if(str_tot_qty_value.length()>16)
										tot_qty_value	 =	Float.parseFloat(str_tot_qty_value.substring(0,15));
								}
							}  
							qty_value          =  tot_qty_value+"";
						}

						if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
							if(freq_nature!=null && freq_nature.equals("P")) {
								in_qty_unit=qty_unit;
								System.err.println("Line ABSOL_QTY 828  "+insertRecords_2.get("ABSOL_QTY"));
								if(insertRecords_2.get("ABSOL_QTY")==null || ((String)insertRecords_2.get("ABSOL_QTY")).equals("0")) {
									if(insertRecords_2.get("PRN_DOSES_PRES_PRD_FILL")==null || ((String)insertRecords_2.get("PRN_DOSES_PRES_PRD_FILL")).equals("0"))
										in_order_qty	= "1";
									else 
										in_order_qty	= ((String)insertRecords_2.get("PRN_DOSES_PRES_PRD_FILL"));
								}
								else 
									in_order_qty	= ((String)insertRecords_2.get("ABSOL_QTY"));
								in_order_uom=qty_unit;
								
							} 
							else {
								in_qty_unit=qty_unit;
								System.err.println("Line ABSOL_QTY 844   :"+(String)insertRecords_2.get("ABSOL_QTY"));
							//	in_order_qty=(((String)insertRecords_2.get("ABSOL_QTY")==null)?"1":(String)insertRecords_2.get("ABSOL_QTY")); commented  for kdah -scf-0388
								//added if and else  condition for kdah -scf-0388  Start
								if(insertRecords_2.get("ABSOL_QTY")==null || ((String)insertRecords_2.get("ABSOL_QTY")).equals("0")) {
									in_order_qty="1";
								}else
									in_order_qty=((String)insertRecords_2.get("ABSOL_QTY"));//end
								in_order_uom=qty_unit;
							}
// below one line added for site issue 17166 - when a non-prn and prn order is placed, qty_value in or_order_line for prn order goes same as non-prn order
							qty_value_1 = (String)insertRecords_2.get("QTY_VALUE")==null?"0":(String)insertRecords_2.get("QTY_VALUE");
						}
						else if(dosage_type!=null && dosage_type.equals("Q")){
							pstmt_am_uom_eqvl	= connection.prepareStatement(sql_ph_prescription_select53) ;
							pstmt_am_uom_eqvl.setString(1,pres_base_uom);
							pstmt_am_uom_eqvl.setString(2,qty_unit);
							pstmt_am_uom_eqvl.setString(3,pres_base_uom);
							pstmt_am_uom_eqvl.setString(4,qty_unit);
							resultSet	= pstmt_am_uom_eqvl.executeQuery();
							if ( resultSet != null && resultSet.next() )
								equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
							closeStatement( pstmt_am_uom_eqvl) ;
							closeResultSet( resultSet );

							in_qty_unit		=	qty_unit;
							if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
								if(!fract_dose.equals("Y")) {
									ord_qty		=	Float.parseFloat(qty_value)*durn_value_calc*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value);
									ord_qty		=	Float.parseFloat(Math.ceil(ord_qty/(Float.parseFloat(content_in_pres_base_uom)))+"");
									//OR_ORDER_LINE ML-BRU-SCF-2146
									if(insertRecords_2.get("ORDER_QTY")!=null){
										ord_qty = Float.parseFloat(insertRecords_2.get("ORDER_QTY")+"");  
									}
									if(ord_qty==0)
										ord_qty	=	1;
								}
								else {
									//qty_value		=   (Math.ceil((Float.parseFloat(qty_value))/(Float.parseFloat(content_in_pres_base_uom))))*(Float.parseFloat(content_in_pres_base_uom))+"";//added for IN25763 --07/11/2011-- priya
									qty_value		=   Math.ceil((Float.parseFloat(qty_value))/(Float.parseFloat(content_in_pres_base_uom)))*(Float.parseFloat(content_in_pres_base_uom))+"";//Above line commented and removed math.ceil for ML-BRU-SCF-1783 and reverted for ML-MMOH-SCF-1443
									if((Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom))
										tmp_qty	=	1+"";
									else{ 
										if(Float.parseFloat(content_in_pres_base_uom)<1 || ((Float.parseFloat(qty_value)*Float.parseFloat(content_in_pres_base_uom)) < Float.parseFloat(equl_value))) //if block and else condition added for ML-BRU-SCF-1190 [IN:045647] and OR condition added for ML-MMOH-SCF-1596
											tmp_qty	=  Math.ceil(Float.parseFloat(qty_value)/(Float.parseFloat(equl_value)*Float.parseFloat(content_in_pres_base_uom)))+"";
										else
											tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(equl_value))/Float.parseFloat(content_in_pres_base_uom))+"";
									}

									ord_qty	=  Float.parseFloat(tmp_qty) *durn_value_calc*Float.parseFloat(repeat_value) ;
									// if condition added on 27/04/2010 -- priya
									if((Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom)){
										ord_qty	=  Float.parseFloat(Math.ceil(ord_qty/Float.parseFloat(content_in_pres_base_uom))+"");
									}
								}
							}
							/* Commented for SCF 5375
							if(freq_nature.equals("F")) 
								ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+"");
						
							if((Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom)){
								ord_qty	=  Float.parseFloat(Math.ceil(ord_qty/Float.parseFloat(content_in_pres_base_uom))+"");
							}*/
							in_order_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
							in_order_uom=qty_unit;
						}
						else if(dosage_type!=null && dosage_type.equals("S")){
							in_qty_unit=qty_unit;
							if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	
								if(!fract_dose.equals("Y")) {	
									ord_qty		=Float.parseFloat(qty_value)*durn_value_calc*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom);
									ord_qty		=new Double(Math.ceil(new Double(ord_qty/(Float.parseFloat(content_in_pres_base_uom)* Float.parseFloat(strength_per_pres_uom))).doubleValue())).floatValue();
									//OR_ORDER_LINE ML-BRU-SCF-2146
									if(insertRecords_2.get("ORDER_QTY")!=null){
										ord_qty = Float.parseFloat(insertRecords_2.get("ORDER_QTY")+"");  
									}
								}
								else {
								//bellow if block and else condition added for SRR20056-SCF-7514	27576
									double unit_qty	= 1.0;
									float unit_dose_qty =(Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(strength_per_pres_uom))*Float.parseFloat(qty_value);

									if(freq_nature.equals("O") ||unit_dose_qty == Float.parseFloat(content_in_pres_base_uom) || (unit_dose_qty % Float.parseFloat(content_in_pres_base_uom)) == 0)
										unit_qty	=   Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom);
									else
										unit_qty	=   Math.ceil(Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom));
									tmp_qty			=   (unit_qty * durn_value_calc * Integer.parseInt(repeat_value))+"";
									ord_qty			=(float)  Float.parseFloat(tmp_qty)*Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(content_in_pres_base_uom);
								}

								/*if(freq_nature.equals("F")) 
									ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+"");*/
							}
							in_order_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
							in_order_uom=pres_base_uom;
						}

				//end of logic
					//String sliding_scale_yn	=	(String)insertRecords_2.get("SLIDING_SCALE_YN");
					/*if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y"))
						in_qty_unit	=	strength_uom;*/
						System.out.println("in_qty_unit for SKR-SCF-1128===="+in_qty_unit+"pres_base_uom"+pres_base_uom);
					if(in_qty_unit==null || in_qty_unit.equals("") )//Added fpr SKR-SCF-1128
						in_qty_unit =pres_base_uom;//Added fpr SKR-SCF-1128
					if( qty_value_1.equals("")||qty_value_1.equals("0")) 
                        qty_value_1	=	qty_value;
					if(in_order_qty == null || in_order_qty.equals("") || in_order_qty.equals("0"))//Added for KDAH-SCF-0388.1
						in_order_qty="1";//Added for KDAH-SCF-0388.1
					pstmt_insert.setString(18,qty_value_1);
					pstmt_insert.setString(19,in_qty_unit);
					pstmt_insert.setString(20,(String)insertRecords_2.get("FREQ_CODE"));
					pstmt_insert.setString(21,(String)insertRecords_2.get("DURN_VALUE"));
					if(insertRecords_2.get("freq_chng_durn_desc")==null ||((String)insertRecords_2.get("freq_chng_durn_desc")).equals(""))
						pstmt_insert.setString(22,(String)insertRecords_2.get("DURN_TYPE"));
					else
						pstmt_insert.setString(22,(String)insertRecords_2.get("freq_chng_durn_desc"));

					if(DrugRemarks!=null && DrugRemarks.size()>0){
						for(int p=0; p<DrugRemarks.size(); p++) {
							DrugValues=(HashMap)DrugRemarks.get(p);
							if((((String)DrugValues.get("fr_drug_code")+(String)DrugValues.get("serial_no")).equals((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO"))) && (((String)DrugValues.get("order_id")).equals(order_id)) 	) {
								line_display_text	=	(String)DrugValues.get("order_format_values");
								 break;
							}
							else{
								line_display_text	=	"";
							}
						 }
					}
					else{
						line_display_text	=	"";
					}
					if(line_display_text.length()>450) //if block added for ML-BRU-SCF-1333 [IN:049124] line_display_text exceeds more than 450 chars
 						line_display_text = line_display_text.substring(0, 450)+"...";
					pstmt_insert.setString(23,line_display_text);
					pstmt_insert.setString(24,"");
					pstmt_insert.setString(25,null);

					if(insertRecords_2.get("END_DATE")==null) {
						pstmt_insert.setString(26,(String)insertRecords_2.get("END_DATE_TIME"));
					}
					else {
						pstmt_insert.setString(26,(String)insertRecords_2.get("END_DATE"));
					}

					pstmt_insert.setString(27,null);

					pstmt_ph_drug_vw.setString(1,dosage_type);
					System.err.println("in_order_qty980 for KDAH-SCF-0388===="+in_order_qty);
					pstmt_ph_drug_vw.setString(2,in_order_qty);
					pstmt_ph_drug_vw.setString(3,in_order_qty);
					pstmt_ph_drug_vw.setString(4,drug_code);
					pstmt_ph_drug_vw.setString(5,language_id);
					pstmt_ph_drug_vw.setString(6,language_id);
					pstmt_ph_drug_vw.setString(7,language_id);
					pstmt_ph_drug_vw.setString(8,language_id);
					pstmt_ph_drug_vw.setString(9,language_id);
					resultSet	=	pstmt_ph_drug_vw.executeQuery();

					if (resultSet.next()){
						stkuom=(String)resultSet.getString("stock_uom");
						if (stkuom!=null && !stkuom.equals("")){
							in_order_uom=stkuom;
						}
					}
					closeResultSet( resultSet );
					System.err.println("in_order_qty fo998r KDAH-SCF-0388===="+in_order_qty);
					if(totalTaperQtyDisplay.equals("Y") && (drug_tapered.equals("Y")||tapered_yn.equals("Y")))
						pstmt_insert.setString(28,tap_lvl_qty.trim());
					else
						pstmt_insert.setString(28,in_order_qty.trim());

					pstmt_insert.setString(29,in_order_uom.trim());
					ord_line.put(((String)insertRecords_2.get("DRUG_CODE")+(String)insertRecords_2.get("SRL_NO"))+"UOM",in_qty_unit);
					order_line_det.put(order_id,ord_line);

					pstmt_insert.setString(30,"N");
					pstmt_insert.setString(31,null);
					pstmt_insert.setString(32,"");
					pstmt_insert.setString(33,"N");
					pstmt_insert.setString(34,"N");
					pstmt_insert.setString(35,"N");
					pstmt_insert.setString(36,(String)insertRecords_2.get("CONT_ORDER_IND"));

					if( insertRecords_2.get("NO_REFILL")!=null && !(((String)insertRecords_2.get("NO_REFILL")).equals("") || ((String)insertRecords_2.get("NO_REFILL")).equals("0"))){
						pstmt_insert.setString(37,"Y");
					}
					else{
						pstmt_insert.setString(37,"N");
					}

					pstmt_insert.setString(38,(String)insertRecords_2.get("NO_REFILL"));
					child_order_yn =(String)tempHeader.get("CHILD_ORDER_YN");
					pstmt_insert.setString(39,child_order_yn);
					parent_order_id =(String)tempHeader.get("PARENT_ORDER_ID");
					pstmt_insert.setString(40,parent_order_id);

					pstmt_insert.setString(41,"");
					pstmt_insert.setString(42,"");
					pstmt_insert.setString(43,"");
					/*if( ((String)tabData.get("external_pres_flag")).equals("true")){ //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
						pstmt_insert.setString(44,login_by_id);
					}
					else{*/
						pstmt_insert.setString(44,ord_pract_id);
					//}

					pstmt_insert.setString(45,null);
					pstmt_insert.setString(46,"");
					pstmt_insert.setString(47,null);
					pstmt_insert.setString(48,"");
					pstmt_insert.setString(49,null);
					pstmt_insert.setString(50,"");
					pstmt_insert.setString(51,null);
					pstmt_insert.setString(52,"");
					pstmt_insert.setString(53,null);
					pstmt_insert.setString(54,"");
					pstmt_insert.setString(55,null);
					pstmt_insert.setString(56,"");
					pstmt_insert.setString(57,"");

					order_status			=	(String)insertRecords_2.get("ORDER_STATUS");
					line_status				=	"";
					authroize_yn			=	(String)insertRecords_2.get("ORD_AUTHORIZED_YN")==null?"N":(String)insertRecords_2.get("ORD_AUTHORIZED_YN");
					approval_yn				=	(String)insertRecords_2.get("ORD_APPROVED_YN")==null?"N":(String)insertRecords_2.get("ORD_APPROVED_YN");
					consent_reqd_yn			=	(String)insertRecords_2.get("CONSENT_REQD_YN")==null?"N":(String)insertRecords_2.get("CONSENT_REQD_YN");
					init_auth_reqd_yn		=	(String)insertRecords_2.get("ORD_AUTH_REQD_YN")==null?"N":(String)insertRecords_2.get("ORD_AUTH_REQD_YN");
					init_spl_appr_reqd_yn	=	(String)insertRecords_2.get("ORD_SPL_APPR_REQD_YN")==null?"N":(String)insertRecords_2.get("ORD_SPL_APPR_REQD_YN");
					init_cosign_reqd_yn		=	(String)insertRecords_2.get("ORD_COSIGN_REQD_YN")==null?"N":(String)insertRecords_2.get("ORD_COSIGN_REQD_YN");
					
					patientClass	= (String)insertRecords_2.get("PATIENT_CLASS");
					quota_limit_exceded_yn         =  (String)insertRecords_2.get("QUOTA_LIMIT_EXCEDED_YN")==null?"N":(String)insertRecords_2.get("QUOTA_LIMIT_EXCEDED_YN"); // ML-MMOH-CRF-1823 US008- 43528
					quota_limit_access_yn=   (String)insertRecords_2.get("QUOTA_LIMIT_ACCESS_YN")==null?"N":(String)insertRecords_2.get("QUOTA_LIMIT_ACCESS_YN"); // ML-MMOH-CRF-1823 US008- 43528
					quota_limit_site_yn     =   (String)insertRecords_2.get("QUOTA_LIMT_SITE_YN")==null?"N":(String)insertRecords_2.get("QUOTA_LIMT_SITE_YN"); // ML-MMOH-CRF-1823 US008- 43528

					cosign_reqd_yn			= init_cosign_reqd_yn;
					if(!tabData.get("AmendAlternateDrug").equals("Y")){//if condiition added for  JD-CRF-0198 [IN:058599]
						if(order_status.equals("10") || order_status.equals("25")){
							if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y")){
								order_status="25";
							}
							else{
								order_status="10";
							}
						}
					}
				       // ML-MMOH-CRF-1823 US008- 43528
						if(quota_limit_site_yn.equals("Y") && quota_limit_req_yn.equals("Y") && quota_limit_exceded_yn.equals("Y") && quota_limit_access_yn.equals("N")){				//PQ - Pend Quota Appr check 1823 US008
							  order_status ="01";
						 }
					
					if(order_status.equals("01")){ //ML-MMOH-CRF-1823 START
						line_status= (String)orderStatusCode.get("01");
					}//CRF-1823 END	
					else if(order_status.equals("03")){
						line_status= (String)orderStatusCode.get("03");
					}
					else if(order_status.equals("05")){
						line_status=(String) orderStatusCode.get("05");
					}
					else if(order_status.equals("10")){
						line_status=(String) orderStatusCode.get("10");
					}
					else if(order_status.equals("25")){
						line_status= (String)orderStatusCode.get("25");
					}
					else if(order_status.equals("00")){
						line_status= (String)orderStatusCode.get("00");
					}else if(order_status.equals("30")){//added for  JD-CRF-0198 [IN:058599]
						line_status= (String)orderStatusCode.get("30");
					}else if(order_status.equals("58")){//added for  GHL-CRF-0482
						line_status= (String)orderStatusCode.get("58");
					}

					if( insertRecords_2.get("BROUGHT_BY_PAT")!=null && ((String)insertRecords_2.get("BROUGHT_BY_PAT")).equals("Y")) {
						if(!verify_pat_brought_medn){//Added if condition for TH-KW-CRF-0002
						line_status	=	(String)orderStatusCode.get("58");
						}
					}

					pstmt_insert.setString(58,line_status);
					pstmt_insert.setString(59,"");
					pstmt_insert.setString(60,login_by_id);
					pstmt_insert.setString(61,login_at_ws_no);
					pstmt_insert.setString(62,login_facility_id);
					pstmt_insert.setString(63,login_by_id);
					pstmt_insert.setString(64,login_at_ws_no);
					pstmt_insert.setString(65,login_facility_id);

					pstmt_insert.setString(66,consent_reqd_yn);
					pstmt_insert.setString(67,"");
					ddesc=(String)insertRecords_2.get("DRUG_DESC");
					if (ddesc!=null && !ddesc.equals("") && ddesc.length()>40){
						ddesc=ddesc.substring(0,40);
					}
					pstmt_insert.setString(68,ddesc);
					pstmt_insert.setString(69,ddesc);
					pstmt_insert.setString(70,"N");
					pstmt_insert.setString(71,(String)insertRecords_2.get("CONSENT_STAGE")); //ORD_CONSENT_STAGE
					pstmt_insert.setString(72,(String)insertRecords_2.get("CONSENT_STATUS")); //ORD_CONSENT_STATUS
					pstmt_insert.setString(73,(String)insertRecords_2.get("NUM_OF_CONSENT_REQ_BO")); //NUM_OF_CONSENT_REQ_BO
					pstmt_insert.setString(74,(String)insertRecords_2.get("NUM_OF_CONSENT_REQ_BR")); //NUM_OF_CONSENT_REQ_BR
					pstmt_insert.setString(75,(String)insertRecords_2.get("CATALOG_SPLTY_CODE")); //NUM_OF_CONSENT_REQ_BR
					pstmt_insert.setString(76,(String)tabData.get("witnessByUser")); //Added for AAKH-CRF-0023[IN:038259]
					
					pstmt_insert.setString(77,(String)tempHeader.get("ORG_ORDER_ID")==null?"":(String)tempHeader.get("ORG_ORDER_ID")); //added for JD-CRF-198					
					
					pstmt_insert.setString(78,quota_limit_access_yn);  // ML-MMOH-CRF-1823 US008- 43528 END
					pstmt_insert.addBatch();
				}
			}
			int[] result_insert_2= pstmt_insert.executeBatch();
			closeStatement( pstmt_insert) ;
			closeResultSet( resultSet );
			closeStatement( pstmt_am_uom_eqvl) ;
			closeStatement( pstmt_ph_drug_vw) ;
			for (int i=0;i<result_insert_2.length ;i++ ){
				if(result_insert_2[i]<0  && result_insert_2[i] != -2 ){
					System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER_LINE result_insert["+i+"]= "+result_insert[i]);
					System.err.println("tabData=== "+tabData);
					insert_rec_2=false;
					break;
				}
				else{
					insert_rec_2=true;
				}
			}
		}

//INSERTING INTO OR_ORDER_LINE_PH
		if(insert_rec_2){
			headerList=null;
			pstmt_insert	= connection.prepareStatement(sql_insert_3) ;
			pstmt_insert.clearBatch();              
			
			HashMap insertRecords_3		=	null;
			String in_tot_strength		=	null;
			String in_tot_strenght_uom	=	null;
			String in_bms_qty			=	null;
			String in_strength_value	=	null;
			String in_strength_uom		=	null;
			String in_pres_qty_value	=	null;
			String in_pres_qty_uom		=	null;
			String sch_strength			=	"0";
			String calc_dosg_by_freq_durn_yn = "";
			String pat_counseling_reqd = "";
			String trade_code="";
			String dose_chaged_yn	="";//Added for ARYU-CRF-0014
			String allow_alternate_yn = ""; //added for GHL-CRF-0549
			String non_prefered_item_remarks_code = "";//GHL-CRF-0618
			HashMap hmDiscCancelledOrders		= (HashMap)tabData.get("DiscCancelledOrders");//code added for HSA-CRF-0138 [IN:048414]
			ArrayList alDisCancelledOrdDtls = null; //Added for HSA-CRF-0138 [IN:048414]
			StringBuilder strDicCanselledOrders = new StringBuilder(); //Added for HSA-CRF-0138 [IN:048414]

			PreparedStatement pstmt_am_uom_eqvl   = connection.prepareStatement(sql_ph_prescription_select53) ;
			PreparedStatement pstmt_ph_drug_vw	= connection.prepareStatement(sql_ph_prescription_select64) ;
			PreparedStatement pstmt_get_MARBarcodeId	= connection.prepareStatement(sql_ph_gen_MARDarcodeId) ; //added for  MMS-QH-CRF-0080 [IN:038064]
			
			for(int i=0;i<OrderID.size();i++){
				headerList=null;
				order_id=(String) OrderID.get(i);
				headerList=(ArrayList) OrderDetails.get(i);
				tempHeader		= (HashMap) OrderHeader.get(i);

				/*if( ((String)tabData.get("external_pres_flag")).equals("true")){ //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
					ord_pract_id	= login_by_id;
				}
				else{*/
					ord_pract_id	= (String)tempHeader.get("ORD_PRACT_ID")==null?"": (String)tempHeader.get("ORD_PRACT_ID");
				//}
					if( ord_pract_id.equals(""))
						ord_pract_id	= login_by_id;

				for(int j=0;j<headerList.size();j++){
					found		=	false;
					firstTime	=	true;
					MAR_barcode_id="";	//added for MMS-QH-CRF-0080 [IN:038064]
					insertRecords_3			=(HashMap) headerList.get(j);
					pstmt_insert.setString(1,order_id);
					pstmt_insert.setString(2,""+(j+1));

					drug_code				=	(String)insertRecords_3.get("DRUG_CODE");
					dosage_type				=	(String)insertRecords_3.get("DOSAGE_TYPE");
					qty_value				=	(String)insertRecords_3.get("QTY_VALUE");
					qty_unit				=	(String)insertRecords_3.get("QTY_DESC_CODE");
					repeat_value			=	(String)insertRecords_3.get("REPEAT_VALUE");
					durn_value				=	(String)insertRecords_3.get("DURN_VALUE");
					strength_value			=	(String)insertRecords_3.get("ACT_STRENGTH_VALUE");
					strength_uom			=	(String)insertRecords_3.get("STRENGTH_UOM");
					pres_base_uom			=	(String)insertRecords_3.get("PRES_BASE_UOM");
					fract_dose				=	(String)insertRecords_3.get("FRACT_DOSE_ROUND_UP_YN");
					dose_chaged_yn			=   (String)insertRecords_3.get("dose_chaged_yn");//added for ARYU-CRF-014
					strength_per_value_per_pres_uom	= (String)insertRecords_3.get("STRENGTH_PER_VALUE_PRES_UOM");
					strength_per_pres_uom				= (String)insertRecords_3.get("STRENGTH_PER_PRES_UOM");
					content_in_pres_base_uom			= (String)insertRecords_3.get("CONTENT_IN_PRES_BASE_UOM");
					calc_dosg_by_freq_durn_yn	= (String)insertRecords_3.get("CALC_DOSG_BY_FREQ_DURN_YN");
					allow_alternate_yn      =  (String)insertRecords_3.get("allow_alternate_yn")==null?"N":(String)insertRecords_3.get("allow_alternate_yn");//added for GHL-CRF-0549
					pat_counseling_reqd						=	(String)insertRecords_3.get("PAT_COUNSELING_REQD")==null?"N":(String)insertRecords_3.get("PAT_COUNSELING_REQD");
					freq_nature		=	(String)insertRecords_3.get("FREQ_NATURE");
					trade_code = (String)insertRecords_3.get("TRADE_CODE")==null?"":(String)insertRecords_3.get("TRADE_CODE");  

					dsg_reason		=(String)insertRecords_3.get("EXT_DDB_DSG_REASON")==null?"":(String)insertRecords_3.get("EXT_DDB_DSG_REASON");  
					dup_reason	=(String)insertRecords_3.get("EXT_DDB_DUP_REASON")==null?"":(String)insertRecords_3.get("EXT_DDB_DUP_REASON"); 
					con_reason	=(String)insertRecords_3.get("EXT_DDB_CON_REASON")==null?"":(String)insertRecords_3.get("EXT_DDB_CON_REASON"); 
					int_reason		=(String)insertRecords_3.get("EXT_DDB_INT_REASON")==null?"":(String)insertRecords_3.get("EXT_DDB_INT_REASON");   
					alg_reason		=(String)insertRecords_3.get("EXT_DDB_ALG_REASON")==null?"":(String)insertRecords_3.get("EXT_DDB_ALG_REASON"); 
					buildMAR_yn		=(String)insertRecords_3.get("BUILDMAR_YN")==null?"N":(String)insertRecords_3.get("BUILDMAR_YN");
					strDicCanselledOrders.setLength(0); //Added for HSA-CRF-0138 [IN:048414] -start
					if(hmDiscCancelledOrders!=null && hmDiscCancelledOrders.containsKey(drug_code)){
						alDisCancelledOrdDtls = (ArrayList)hmDiscCancelledOrders.get(drug_code);
						if(alDisCancelledOrdDtls!=null && alDisCancelledOrdDtls.size()>0){
							for(int index=0; index<alDisCancelledOrdDtls.size(); index+=2){
								if(strDicCanselledOrders.length()>0)
									strDicCanselledOrders.append("##");
								strDicCanselledOrders.append((String)alDisCancelledOrdDtls.get(index)+"~"+(String)alDisCancelledOrdDtls.get(index+1));
							}
						}
					} //Added for HSA-CRF-0138 [IN:048414] -end
					interval_value		=Integer.parseInt((String)insertRecords_3.get("INTERVAL_VALUE")==null?"1":(String)insertRecords_3.get("INTERVAL_VALUE"));
					drug_tapered		=insertRecords_3.get("DRUG_TAPERED_YN")==null?"N":(String)insertRecords_3.get("DRUG_TAPERED_YN");
					tapered_yn		=insertRecords_3.get("TAPPERED_OVER")==null?"N":(String)insertRecords_3.get("TAPPERED_OVER");
					if(totalTaperQtyDisplay.equals("Y") && (drug_tapered.equals("Y") || tapered_yn.equals("Y")))
						tap_lvl_qty		=insertRecords_3.get("TAP_LVL_QTY")==null?"1":(String)insertRecords_3.get("TAP_LVL_QTY");//TOTTAPPERQTY changed to TAP_LVL_QTY
					else
						tap_lvl_qty = "";
					if(drug_tapered.equals("Y") && tapered_yn.equals("N")) //added for RUT-CRF-0094 [IN:037443] -start
						taper_seq_no = 1;
					else if (tapered_yn.equals("Y"))
						taper_seq_no++;
					else
						taper_seq_no = 0; //added for RUT-CRF-0094 [IN:037443] -end

					if(!prev_drugCode.equals(drug_code)){
						if(drug_tapered.equals("Y")){
							taper_order_id		=order_id;
							taper_order_line_num =(j+1)+"";
						}
						else{
							taper_order_id		="";
							taper_order_line_num ="";
						}
						prev_drugCode=drug_code;
					}

					if(insertRecords_3.get("freq_chng_durn_value")!=null && !durn_value.equals((String)insertRecords_3.get("freq_chng_durn_value"))){
						durn_value = (String)insertRecords_3.get("freq_chng_durn_value");
					}

					if(freq_nature.equals("F") || freq_nature.equals("I") ) // priya 23/02/2010
						durn_value_calc	=	(float)Math.ceil(Float.parseFloat(durn_value)/ interval_value);
					else
						durn_value_calc = Float.parseFloat(durn_value);
					in_tot_strength		=	"";
					in_tot_strenght_uom	=	"";
					in_bms_qty				=	"";
					in_strength_value		=	"";
					in_strength_uom		=	"";
					in_pres_qty_value		=	"";
					in_pres_qty_uom		=	"";
					split_dose_yn_val		=	"";
					qty_value_1			=	"0";
					if(strength_per_pres_uom==null || strength_per_pres_uom.equals("") || strength_per_pres_uom.equals("0"))
						strength_per_pres_uom="1";

					if(insertRecords_3.containsKey("SPLIT_DOSE_YN_VAL"))
						split_dose_yn_val	=	(String)insertRecords_3.get("SPLIT_DOSE_YN_VAL");
					else
						  split_dose_yn_val	=	"N";

					chkValuescheduleFrequency=ScheduleFreq;
					schedule  = null;
					dose_list = null;
						
					if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
						if(chkValuescheduleFrequency.containsKey((String)insertRecords_3.get("DRUG_CODE")+(String)insertRecords_3.get("SRL_NO")))
							schedule = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_3.get("DRUG_CODE")+(String)insertRecords_3.get("SRL_NO"));
					}
					
					if(schedule!=null && schedule.size() > 0 && (split_dose_yn_val.equals("N")) ) 
						repeat_value	="1";
					
					if(schedule != null && schedule.size()>0){
							dose_list	= (ArrayList)schedule.get(4);						
					}
					
					if(dose_list!=null && dose_list.size() > 0 && (split_dose_yn_val.equals("N")) ) {
							 
						if(fract_dose.equals("N")) { 
							//HashMap detail		=	(HashMap)schedule.get(0);
							//qty_value			=	((String)detail.get("admin_qty")).equals("0")?qty_value:(String)detail.get("admin_qty");
							qty_value			=	((String)dose_list.get(0)).equals("0")?qty_value:(String)dose_list.get(0);
							qty_value_1			=   qty_value;	 
						}
						else{
							//HashMap detail	=	(HashMap)schedule.get(0);
							if(dosage_type.equals("S")){
								//qty_value		=	((String)detail.get("admin_qty")).equals("0")?qty_value:(String)detail.get("admin_qty");
								qty_value		=	((String)dose_list.get(0)).equals("0")?qty_value:(String)dose_list.get(0);
								qty_value_1     =   qty_value;
								qty_value       =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
								qty_value		=	Float.parseFloat(qty_value) * Float.parseFloat(strength_value)+"";
							}
							else if(dosage_type.equals("Q")){
								//qty_value		=	((String)detail.get("admin_qty")).equals("0")?qty_value:(String)detail.get("admin_qty");
								qty_value		=	((String)dose_list.get(0)).equals("0")?qty_value:(String)dose_list.get(0);
								qty_value_1     =   qty_value;
				//				qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";  //commented while fixing IN23884 --06/12/2010-- priya
							}  
							//qty_value          =   (Math.ceil(Float.parseFloat(qty_value)*schedule.size()))+"";    

						}
					//	repeat_value	=	""+schedule.size();
						repeat_value	=	""+dose_list.size();
					}
					else  if(dose_list!=null && dose_list.size() > 0 && (split_dose_yn_val.equals("Y")) ) {
						tot_qty_value       = 0;
						qty_value_2			= 0;
						if(fract_dose.equals("N")) {
							for(int tqI=0;tqI<dose_list.size();tqI++){
								repeat_value	=	"1";
								tot_qty_value	=	tot_qty_value+Float.parseFloat((String)dose_list.get(tqI));
							}
							
							/*for(int n=0; n<schedule.size(); n++) {
							  repeat_value		=	"1";
							  HashMap  detail	=  (HashMap)schedule.get(n);
							  tot_qty_value     =  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));
							}*/
						}
						else{
							for(int n=0; n<dose_list.size(); n++) {
								repeat_value		=	"1";
								//HashMap  detail	=  (HashMap)schedule.get(n);
								if(dosage_type.equals("S")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(n);
									qty_value_1		=	Float.parseFloat(qty_value_1)+Float.parseFloat(qty_value)+"";

									if(Float.parseFloat(qty_value) == Float.parseFloat(content_in_pres_base_uom) || (Float.parseFloat(qty_value) % Float.parseFloat(content_in_pres_base_uom)) == 0)
										qty_value		=   Float.parseFloat(qty_value)/Float.parseFloat(strength_value)+"";
									else
										qty_value		=   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";

									qty_value_2     +=  (Math.ceil(Float.parseFloat(qty_value)*Float.parseFloat(strength_value)));
									qty_value		=	Float.parseFloat(qty_value)*Float.parseFloat(strength_value)+"";
								}
								else if(dosage_type.equals("Q")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(n);
									qty_value_1     =	Float.parseFloat(qty_value_1)+Float.parseFloat(qty_value)+"";
									qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
									qty_value_2    +=	Float.parseFloat(qty_value);
								}  
								tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
								str_tot_qty_value 			 =  Float.toString(tot_qty_value);
								if(str_tot_qty_value.length()>16)
									tot_qty_value	 =	Float.parseFloat(str_tot_qty_value.substring(0,15));
							}
						}  
						qty_value          =  tot_qty_value+"";
					}
/* || freq_nature.equals("O") added for scf 13927 PRES_QTY_VALUE was going wrong for stat orders*/
/* bms qty was going wrong for frq nature "O" so removed condition for "O" - feb-04-10*/
					//if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && (freq_nature.equals("P") || freq_nature.equals("O")))){ 
					if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && (freq_nature.equals("P")))) { 
						in_tot_strength		=	"";
						in_tot_strenght_uom	=	"";
						in_bms_qty			=	String.valueOf(Math.ceil(Float.parseFloat(qty_value)));
						in_strength_value	=	strength_value;
						in_strength_uom		=	strength_uom;
						in_pres_qty_value	=	String.valueOf(Math.ceil(Float.parseFloat(qty_value)));
						if(freq_nature!=null && freq_nature.equals("P")) {
							System.err.println("Line ABSOL_QTY  1376:"+insertRecords_3.get("ABSOL_QTY"));
							if(insertRecords_3.get("ABSOL_QTY")==null || ((String)insertRecords_3.get("ABSOL_QTY")).equals("0")) {
								System.err.println("Line PRN_DOSES_PRES_PRD_FILL  1379:"+insertRecords_3.get("PRN_DOSES_PRES_PRD_FILL"));
								if(insertRecords_3.get("PRN_DOSES_PRES_PRD_FILL")==null || ((String)insertRecords_3.get("PRN_DOSES_PRES_PRD_FILL")).equals("0")){
									in_pres_qty_value	= "1";
								}
								else {
									in_pres_qty_value	= 	((String)insertRecords_3.get("PRN_DOSES_PRES_PRD_FILL"));
								}
							}
							else{
								in_pres_qty_value	= ((String)insertRecords_3.get("ABSOL_QTY"));
							}
							in_bms_qty = in_pres_qty_value;
							in_pres_qty_value = Math.ceil(Float.parseFloat(in_pres_qty_value)*Float.parseFloat(content_in_pres_base_uom))+"";
						}
						else{
							System.err.println("in_pres_qty_value  :ABSOL_QTY 11"+((String)insertRecords_3.get("ABSOL_QTY")));
							//in_pres_qty_value = (((String)insertRecords_3.get("ABSOL_QTY")==null)?"1":(String)insertRecords_3.get("ABSOL_QTY")); commented for kdah-scf-0388
							//added if and else condition for kdah-scf-0388  start
							if(insertRecords_3.get("ABSOL_QTY")==null || ((String)insertRecords_3.get("ABSOL_QTY")).equals("0")) {
								in_pres_qty_value="1";
							}else
							{
								in_pres_qty_value=((String)insertRecords_3.get("ABSOL_QTY"));
							}//end
							in_bms_qty = in_pres_qty_value;
							in_pres_qty_value = Math.ceil(Float.parseFloat(in_pres_qty_value)*Float.parseFloat(content_in_pres_base_uom))+"";
						}
						/*String stkuom	=	"";
						pstmt_ph_drug_vw.setString(1,dosage_type);
						pstmt_ph_drug_vw.setString(2,in_pres_qty_value);
						pstmt_ph_drug_vw.setString(3,in_pres_qty_value);
						pstmt_ph_drug_vw.setString(4,drug_code);
						pstmt_ph_drug_vw.setString(5, language_id);
						pstmt_ph_drug_vw.setString(6, language_id);
						pstmt_ph_drug_vw.setString(7, language_id);
						pstmt_ph_drug_vw.setString(8, language_id);
						pstmt_ph_drug_vw.setString(9, language_id);

						resultSet	=	pstmt_ph_drug_vw.executeQuery();
						if (resultSet.next()){
							stkuom=(String)resultSet.getString("stock_uom");
						}
						if (stkuom!=null && !stkuom.equals("")){
							in_pres_qty_uom=stkuom;
						}*/
						
						in_pres_qty_uom=pres_base_uom;
					}
					else if(dosage_type!=null && dosage_type.equals("Q")){
						ord_qty	=	0.0f;
						equl_value	=	"1";

						pstmt_am_uom_eqvl.setString(1,pres_base_uom);
						pstmt_am_uom_eqvl.setString(2,qty_unit);
						pstmt_am_uom_eqvl.setString(3,pres_base_uom);
						pstmt_am_uom_eqvl.setString(4,qty_unit);
						resultSet	= pstmt_am_uom_eqvl.executeQuery();
						if ( resultSet != null && resultSet.next() ) {
							equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}
						closeResultSet( resultSet );
					
						if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
							if(!fract_dose.equals("Y")) {
								ord_qty		=	(Float.parseFloat(qty_value)*durn_value_calc*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));
								in_pres_qty_value = ord_qty+"";;
								ord_qty		=	Float.parseFloat(Math.ceil(ord_qty/(Float.parseFloat(content_in_pres_base_uom)))+"");
								//OR_ORDER_LINE_PH ML-BRU-SCF-2146
								if( insertRecords_3.get("ORDER_QTY")!=null ){
									ord_qty = Float.parseFloat(insertRecords_3.get("ORDER_QTY")+"");  
								}
								if(ord_qty==0)
									ord_qty	=	1;
							}
							else {
								if( (Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom)){
									tmp_qty	=	1+"";
								}
								else {
									if(Float.parseFloat(content_in_pres_base_uom)<1 || ((Float.parseFloat(qty_value)*Float.parseFloat(content_in_pres_base_uom)) < Float.parseFloat(equl_value))) //if block and else condition added for ML-BRU-SCF-1190 [IN:045647] and OR condition added for ML-MMOH-SCF-1596
										tmp_qty	=  Math.ceil(Float.parseFloat(qty_value)/(Float.parseFloat(equl_value)*Float.parseFloat(content_in_pres_base_uom)))+"";
									else
										tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(equl_value))/Float.parseFloat(content_in_pres_base_uom))+"";
								}
								ord_qty	=  Float.parseFloat(tmp_qty) *durn_value_calc*Float.parseFloat(repeat_value);
								in_pres_qty_value = Math.ceil(ord_qty*Float.parseFloat(content_in_pres_base_uom))+"";
							}
						}
						in_pres_qty_uom=qty_unit; //pres_base_uom changed to qty_unit for ML-BRU-SCF-1190 [IN:045647]

						if(!(Float.parseFloat(strength_value)>0 && calc_dosg_by_freq_durn_yn.equals("Y"))){
/*commented on 27 jul 09 - the qty was going without * with eqvl value */
							//in_pres_qty_value = ord_qty+"";
							pstmt_ph_drug_vw.setString(1,dosage_type);
							pstmt_ph_drug_vw.setString(2,in_pres_qty_value);
							pstmt_ph_drug_vw.setString(3,in_pres_qty_value);
							pstmt_ph_drug_vw.setString(4,drug_code);
							pstmt_ph_drug_vw.setString(5, language_id);
							pstmt_ph_drug_vw.setString(6, language_id);
							pstmt_ph_drug_vw.setString(7, language_id);
							pstmt_ph_drug_vw.setString(8, language_id);
							pstmt_ph_drug_vw.setString(9, language_id);

							resultSet	=	pstmt_ph_drug_vw.executeQuery();
							if (resultSet.next()){
								stkuom=(String)resultSet.getString("stock_uom");
							}
							closeResultSet( resultSet );
							/*if (stkuom!=null && !stkuom.equals("")){
								in_pres_qty_uom=stkuom;
							}*/
						}

						if((equl_value!=null && !(equl_value.equals("")))){
							act_qty=Float.parseFloat(qty_value)* Float.parseFloat(equl_value);
						}

						if( (strength_value!=null && !(strength_value.equals("")))){
							tot_strn			=	act_qty*(Float.parseFloat(strength_value));
							in_tot_strength		=	String.valueOf(tot_strn);
							in_tot_strenght_uom =	pres_base_uom;
						}
						else{
							in_tot_strength		=	"";
							in_tot_strenght_uom	=	"";
						}
						in_bms_qty				=	String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
						in_strength_value		=	strength_value;
						in_strength_uom			=	strength_uom;

					}
					else if(dosage_type!=null && dosage_type.equals("S")){
						//float ord_qty			=	0.0f;
						//float tot_strn			=	0.0f;
						if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	
							if(fract_dose.equals("N")) {							
								tot_strn=Float.parseFloat(qty_value)*durn_value_calc*Integer.parseInt(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom);
								in_pres_qty_value	=	(float)Math.ceil(tot_strn/Float.parseFloat(strength_per_pres_uom))+"";
								ord_qty=(float)Math.ceil(tot_strn/(Float.parseFloat(strength_per_pres_uom)*Float.parseFloat(content_in_pres_base_uom)));
								//OR_ORDER_LINE_PH ML-BRU-SCF-2146
								if( insertRecords_3.get("ORDER_QTY")!=null ){
									ord_qty = Float.parseFloat(insertRecords_3.get("ORDER_QTY")+"");  
								}
							}
							else{
							// if block and else condition added for SRR20056-SCF-7514	27576
								float unit_dose_qty =(Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(strength_per_pres_uom))*Float.parseFloat(qty_value);

								if(freq_nature.equals("O") || unit_dose_qty == Float.parseFloat(content_in_pres_base_uom) || (unit_dose_qty % Float.parseFloat(content_in_pres_base_uom)) == 0)
									tot_strn=(float)Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom);
								else
									tot_strn=(float)Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_per_pres_uom));

								tot_strn =tot_strn *durn_value_calc * Integer.parseInt(repeat_value) * Float.parseFloat(strength_per_value_per_pres_uom);
								in_pres_qty_value	=	tot_strn+"";
								ord_qty=(float)Math.ceil(tot_strn/Float.parseFloat(content_in_pres_base_uom));
							}
						}
						in_tot_strength		=	String.valueOf(tot_strn);
						in_tot_strenght_uom	=	strength_uom;
						in_bms_qty			=	String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
						in_strength_value	=	strength_value;
						in_strength_uom		=	strength_uom;
						in_pres_qty_uom		=	pres_base_uom;
					}

					if(freq_nature.equals("O")){
						in_tot_strength		=	"";
						in_tot_strenght_uom	=	"";
						//in_bms_qty			=	String.valueOf(Math.ceil(Float.parseFloat(qty_value)));
						in_strength_value	=	strength_value;
						in_strength_uom		=	strength_uom;
						//in_pres_qty_value	=	String.valueOf(Math.ceil(Float.parseFloat(qty_value)));
						//in_pres_qty_value = (((String)insertRecords_3.get("ABSOL_QTY")==null)?"1":(String)insertRecords_3.get("ABSOL_QTY")); commented for kdah-scf-0388
						//added for kdah-scf-0388  start
						if(insertRecords_3.get("ABSOL_QTY")==null || ((String)insertRecords_3.get("ABSOL_QTY")).equals("0")) {
							in_pres_qty_value="1";
						}else
						{
							in_pres_qty_value=((String)insertRecords_3.get("ABSOL_QTY"));
						}// kdah-scf-0388   end
						//in_bms_qty = in_pres_qty_value;
						in_pres_qty_value = Math.ceil(Float.parseFloat(in_pres_qty_value)*Float.parseFloat(content_in_pres_base_uom))+"";
					}
					if(trade_code==null || trade_code.equals("")){
					  if(pre_alloc_app_yn!=null && pre_alloc_app_yn.equals("Y"))
					  trade_code = getTradeNameForDrug(connection,drug_code);
					}
					pstmt_insert.setString(3,(String)insertRecords_3.get("GENERIC_ID"));
					pstmt_insert.setString(4,(String)insertRecords_3.get("FORM_CODE"));
					pstmt_insert.setString(5,trade_code);
					pstmt_insert.setString(6,(String)insertRecords_3.get("IN_FORMULARY_YN"));
					pstmt_insert.setString(7,(String)insertRecords_3.get("DOSAGE_TYPE"));
					pstmt_insert.setString(8,"");

					if( ((String) insertRecords_3.get("DOSAGE_TYPE")).equals("Q") && ((String) insertRecords_3.get("STRENGTH_VALUE"))!=null && !((String) insertRecords_3.get("STRENGTH_VALUE")).equals("0") && !((String) insertRecords_3.get("STRENGTH_VALUE")).equals("") ) {
							sch_strength	=	Math.ceil( (Float.parseFloat((String) insertRecords_3.get("STRENGTH_PER_PRES_UOM")) / Float.parseFloat((String) insertRecords_3.get("STRENGTH_PER_VALUE_PRES_UOM")) ) * Float.parseFloat((String) insertRecords_3.get("QTY_VALUE")))+"";
					}
					else if (((String) insertRecords_3.get("DOSAGE_TYPE")).equals("S"))	{
							sch_strength	=	(String) insertRecords_3.get("STRENGTH_VALUE");
					}
				
					if(!((String) insertRecords_3.get("DOSAGE_TYPE")).equals("A") ) {
						if( ((String) insertRecords_3.get("FREQ_NATURE")).equals("F") ) {
							in_tot_strength = Math.ceil(Float.parseFloat(sch_strength) * durn_value_calc * Float.parseFloat ((String) insertRecords_3.get("REPEAT_VALUE")))+"";
						}
						else {
							if((String) insertRecords_3.get("INTERVAL_VALUE")==null || ((String) insertRecords_3.get("INTERVAL_VALUE")).equals("") || ((String) insertRecords_3.get("INTERVAL_VALUE")).equals("0")) {
								interval_value	=	1;
							}
							else {
								interval_value	= Math.ceil(24/Float.parseFloat((String) insertRecords_3.get("INTERVAL_VALUE")));
							}
							in_tot_strength  = Math.ceil(Float.parseFloat(sch_strength) * durn_value_calc * interval_value )+"";
						}
					}

					if(split_dose_yn_val.equals("N")){
						if(repeat_value == null ||repeat_value.equals(""))
							repeat_value = "1";
						if(dosage_type.equals("S")){
							in_tot_strength   = "";
							in_tot_strength   =  (Float.parseFloat(qty_value)* durn_value_calc)*(Integer.parseInt(repeat_value))+"";
						}
						else if(dosage_type.equals("Q")){
							in_tot_strength	  = "";
							in_tot_strength		  =  Math.ceil((Float.parseFloat(qty_value)* durn_value_calc*Integer.parseInt(repeat_value)*Float.parseFloat(strength_value))/Float.parseFloat(strength_per_pres_uom))+"";
						}
					}
					else{
						in_tot_strength  = "";
						in_tot_strength  = ( (Float.parseFloat(qty_value)* durn_value_calc))+"";
					}
					if(freq_nature!=null && freq_nature.equals("P")) {
						if(!dosage_type.equals("S")){
							//in_tot_strength  = (Float.parseFloat(qty_value)* Float.parseFloat(durn_value))+"";
							in_tot_strength		=Float.parseFloat(in_pres_qty_value)+"";
							in_tot_strenght_uom	=	pres_base_uom;
						}
						else{
							in_tot_strength		=	Float.parseFloat(in_strength_value)*Float.parseFloat(in_pres_qty_value)+"";
							in_tot_strenght_uom	=	strength_uom;
						}
					}
					System.err.println("in_pres_qty_value  1234  :"+in_pres_qty_value);
					if(in_pres_qty_value.equals("") || in_pres_qty_value.equals("0"))//Added for KDAH-SCF-0388.1
						  in_pres_qty_value="1";//Added for KDAH-SCF-0388.1
					pstmt_insert.setString(9,in_tot_strength);
					pstmt_insert.setString(10,in_tot_strenght_uom);
					pstmt_insert.setString(11,"");
					pstmt_insert.setString(12,"");
					pstmt_insert.setString(13,"");
					pstmt_insert.setString(14,"");
					pstmt_insert.setString(15,"");
					pstmt_insert.setString(16,"N");
					if(insertRecords_3.get("NO_REFILL")!=null && (!((String)insertRecords_3.get("NO_REFILL")).equals("") )){
						pstmt_insert.setString(17,"Y");
						pstmt_insert.setString(18,"Y");
					}
					else{
						pstmt_insert.setString(17,"N");
						pstmt_insert.setString(18,"N");
					}
					pstmt_insert.setString(19,"");
					pstmt_insert.setString(20,"");
					pstmt_insert.setString(21,"");
					pstmt_insert.setString(22,"");
					pstmt_insert.setString(23,"");
					pstmt_insert.setString(24,null);
					pstmt_insert.setString(25,"");
					pstmt_insert.setString(26,"");
					if(totalTaperQtyDisplay.equals("Y")){
						if(drug_tapered.equals("Y") || tapered_yn.equals("Y"))
							pstmt_insert.setString(27,tap_lvl_qty);
						//else if (tapered_yn.equals("Y"))
						//	pstmt_insert.setString(27,"0");
						else
							pstmt_insert.setString(27,in_bms_qty);
					}
					else
						pstmt_insert.setString(27,in_bms_qty);
					
					pstmt_insert.setString(28,in_tot_strength);	
					pstmt_insert.setString(29,login_by_id);
					pstmt_insert.setString(30,login_at_ws_no);
					pstmt_insert.setString(31,login_facility_id);
					pstmt_insert.setString(32,login_by_id);
					pstmt_insert.setString(33,login_at_ws_no);
					pstmt_insert.setString(34,login_facility_id);

					// Checking Split or Scheduled - Starts
					chkValuescheduleFrequency = ScheduleFreq;

					frequencyValues = null;
					dose_list	      = null;
					if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
						if(chkValuescheduleFrequency.containsKey((String)insertRecords_3.get("DRUG_CODE")+(String)insertRecords_3.get("SRL_NO")))
							frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_3.get("DRUG_CODE")+(String)insertRecords_3.get("SRL_NO"));
					}

					if(frequencyValues!=null && frequencyValues.size()>0){
					//	HashMap data=	null;
						dose_list	= (ArrayList)frequencyValues.get(4);						
						for(int n=0;n<dose_list.size();n++){
							//data	=new HashMap();
							//data	=(HashMap)frequencyValues.get(n);
							//admin_qty	= ((String)data.get("admin_qty")).trim();
							admin_qty	= ((String)dose_list.get(n)).trim();
							if(firstTime) {
								tmp			=	admin_qty;
								firstTime	=	false;
							}
							else if(!tmp.equals(admin_qty)) {
								found		=	true;
							//	break;
							}
						}
					}
					//Checking Split or Scheduled - ends
					if(found) 
						pstmt_insert.setString(35,"Y");
					else 
						pstmt_insert.setString(35,"N");

					if( ((String)insertRecords_3.get("SPLIT_DOSE")) !=null && ((String)insertRecords_3.get("SPLIT_DOSE")) .equals("Y") ){	
						pstmt_insert.setString(36,(String)insertRecords_3.get("QTY_VALUE"));
						pstmt_insert.setString(37,(String)insertRecords_3.get("QTY_DESC_CODE"));
					}
					else{
						pstmt_insert.setString(36,"");
						pstmt_insert.setString(37,"");
					}
					pstmt_insert.setString(38,in_strength_value);
					pstmt_insert.setString(39,in_strength_uom);
					if(totalTaperQtyDisplay.equals("Y")){
						if(drug_tapered.equals("Y") || tapered_yn.equals("Y"))
							pstmt_insert.setString(40,tap_lvl_qty);
						else
							pstmt_insert.setString(40,in_pres_qty_value);
					}
					else
						pstmt_insert.setString(40,in_pres_qty_value);
					pstmt_insert.setString(41,in_pres_qty_uom);

					if(!alg_reason.equals(""))
						pstmt_insert.setString(42,alg_reason);
					else
						pstmt_insert.setString(42,(String)insertRecords_3.get("ALLERGY_REMARKS"));

					if(!dsg_reason.equals(""))
						pstmt_insert.setString(43,dsg_reason);
					else
						pstmt_insert.setString(43,(String)insertRecords_3.get("DOSE_REMARKS"));
					
					if(!tabData.get("alterAmendReason").equals("") && !tabData.get("alterAmendReason").equals(null))//added for  JD-CRF-0198 [IN:058599]
						alternate_amend_reason=(String)tabData.get("alterAmendReason");
					else
						alternate_amend_reason="";
					
					if(!dup_reason.equals(""))
						pstmt_insert.setString(44,dup_reason);
					else
						pstmt_insert.setString(44,(String)insertRecords_3.get("CURRENTRX_REMARKS"));

					if(!int_reason.equals(""))
						pstmt_insert.setString(45,int_reason);
					else
						pstmt_insert.setString(45,(String)insertRecords_3.get("INTERACTION_REMARKS"));

					if((String)insertRecords_3.get("BROUGHT_BY_PAT")==null || ((String)insertRecords_3.get("BROUGHT_BY_PAT")).equals("")) {
						pstmt_insert.setString(46,"N");
					}
					else {
						pstmt_insert.setString(46,(String)insertRecords_3.get("BROUGHT_BY_PAT"));
					}
					pstmt_insert.setString(47,"");
					pstmt_insert.setString(48,"");
					pstmt_insert.setString(49,pat_counseling_reqd);
					if(pat_counseling_reqd.equals("Y"))
						pstmt_insert.setString(50,ord_pract_id);
					else
						pstmt_insert.setString(50,"");

					pstmt_insert.setString(51,(String)insertRecords_3.get("BL_OVERRIDE_EXCL_INCL_IND"));
					pstmt_insert.setString(52,(String)insertRecords_3.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"));
					pstmt_insert.setString(53,buildMAR_yn); 
					pstmt_insert.setString(54,(String)insertRecords_3.get("SLIDING_SCALE_YN"));
					if(tapered_yn.equals("Y") || drug_tapered.equals("Y")) //if condition & else part added for //added for RUT-CRF-0094 [IN:037443] 
						pstmt_insert.setString(55,"Y");
					else
						pstmt_insert.setString(55,"N");
					if(totalTaperQtyDisplay.equals("Y") && tapered_yn.equals("Y")){
						pstmt_insert.setString(56,taper_order_id);
						pstmt_insert.setString(57,taper_order_line_num);
					}
					else{
						pstmt_insert.setString(56,"");
						pstmt_insert.setString(57,"");
					}
					pstmt_insert.setString(58,(String)insertRecords_3.get("DRUG_INDICATION"));//DrugIndicationRemarks  Added for  ML-BRU-CRF-072[Inc:29938] 
					pstmt_insert.setString(59,(String)insertRecords_3.get("PREG_REMARKS"));//added for CRF RUT-CRF-0063[29601] and code "PREG_REMRKS" is replaced by "PREG_REMARKS" for  IN040512
					if(buildMAR_yn.equals("Y") && print_mar_label.equals("Y") &&  print_mar_barcode.equals("Y")){ //added for  MMS-QH-CRF-0080 [IN:038064] -start
						pstmt_get_MARBarcodeId.setString(1,login_facility_id);
						resultSet = pstmt_get_MARBarcodeId.executeQuery();
						if(resultSet!=null && resultSet.next())
							MAR_barcode_id = resultSet.getString("MAR_BARCODE_ID");
						closeResultSet( resultSet );
					}
					insertRecords_3.put("MAR_BARCODE_ID",MAR_barcode_id);
					pstmt_insert.setString(60,MAR_barcode_id);//added for MMS-QH-CRF-0080 [IN:038064] -end
					pstmt_insert.setString(61,taper_seq_no+"");//added for RUT-CRF-0094 [IN:037443]
					pstmt_insert.setString(62,strDicCanselledOrders.toString());//Added for HSA-CRF-0138 [IN:048414]
					pstmt_insert.setString(63,alternate_amend_reason);//Added for JD_CRF_0198(58599)
					pstmt_insert.setString(64,placed_from_verbal_order);//Added for GHL-CRF-0509
					pstmt_insert.setString(65,dose_chaged_yn);//added for ARYU-CRF-014
					pstmt_insert.setString(66,allow_alternate_yn); //GHL-CRF-0549
//					System.err.println("nonPreferenceRemarks======>"+nonPreferenceRemarksDrug+"==drug_code===>"+drug_code);
					//GHL-CRF-0618 - start
					if(nonPreferenceRemarksDrug!=null && nonPreferenceRemarksDrug.size()>0)
						non_prefered_item_remarks_code = (String)nonPreferenceRemarksDrug.get(drug_code);
					
					if(non_prefered_item_remarks_code==null)
						non_prefered_item_remarks_code = "";
					//GHL-CRF-0618 - end
				pstmt_insert.setString(67,(String)insertRecords_3.get("LAB_INTERACTION_REMARKS")==null?"":(String)insertRecords_3.get("LAB_INTERACTION_REMARKS")); //MMS-KH-CRF-0029
					pstmt_insert.setString(68,(String)insertRecords_3.get("FOOD_INTERACTION_REMARKS")==null?"":(String)insertRecords_3.get("FOOD_INTERACTION_REMARKS")); //MMS-KH-CRF-0029
					
				//Added for IN:072715 START
					pstmt_insert.setString(69,(String)insertRecords_3.get("ALLERGY_REMARKS_CODE")==null?"":(String)insertRecords_3.get("ALLERGY_REMARKS_CODE")); //MMS-KH-CRF-0029
					pstmt_insert.setString(70,(String)insertRecords_3.get("DOSE_REMARKS_CODE")==null?"":(String)insertRecords_3.get("DOSE_REMARKS_CODE")); //MMS-KH-CRF-0029
					pstmt_insert.setString(71,(String)insertRecords_3.get("CURRENTRX_REMARKS_CODE")==null?"":(String)insertRecords_3.get("CURRENTRX_REMARKS_CODE")); //MMS-KH-CRF-0029
					pstmt_insert.setString(72,(String)insertRecords_3.get("INTERACTION_REMARKS_CODE")==null?"":(String)insertRecords_3.get("INTERACTION_REMARKS_CODE")); //MMS-KH-CRF-0029
					pstmt_insert.setString(73,(String)insertRecords_3.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String)insertRecords_3.get("LAB_INTERACTION_REMARKS_CODE")); 
					pstmt_insert.setString(74,(String)insertRecords_3.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String)insertRecords_3.get("FOOD_INTERACTION_REMARKS_CODE")); 
//Added for IN:072715 END
					pstmt_insert.setString(75,non_prefered_item_remarks_code); //MMS-KH-CRF-0029
					pstmt_insert.setString(76,(String)insertRecords_3.get("ABUSE_EXISTS")==null?"":(String)insertRecords_3.get("ABUSE_EXISTS")); //AAKH-CRF-0140
					pstmt_insert.setString(77,(String)insertRecords_3.get("abuse_override_remarks")==null?"":(String)insertRecords_3.get("abuse_override_remarks")); //AAKH-CRF-0140
					pstmt_insert.setString(78,(String)insertRecords_3.get("TRN_QUOTA_LIMIT_VALUE")==null?"":(String)insertRecords_3.get("TRN_QUOTA_LIMIT_VALUE")); //AAKH-CRF-0140
					pstmt_insert.setString(79,(String)insertRecords_3.get("DISEASE_INTERACTION_REMARKS_CODE")==null?"":(String)insertRecords_3.get("DISEASE_INTERACTION_REMARKS_CODE"));//Added for MMS-DM-CRF-0229
					pstmt_insert.setString(80,(String)insertRecords_3.get("DISEASE_INTERACTION_REMARKS")==null?"":(String)insertRecords_3.get("DISEASE_INTERACTION_REMARKS"));//Added for MMS-DM-CRF-0229
					
					pstmt_insert.addBatch();
				}
			}
			int[] result_insert_3= pstmt_insert.executeBatch();
			closeStatement( pstmt_insert) ;
			closeResultSet( resultSet );
			closeStatement( pstmt_am_uom_eqvl) ;
			closeStatement( pstmt_get_MARBarcodeId) ;

			for (int i=0;i<result_insert_3.length ;i++ ){
				if(result_insert_3[i]<0  && result_insert_3[i] != -2 ){
					System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER_LINE_PH result_insert["+i+"]= "+result_insert[i]);
					System.err.println("tabData=== "+tabData);
					insert_rec_3=false;
					break;
				}
				else{
					insert_rec_3=true;
				}
			}
		}

//INSERTING INTO PH_PATIENT_DRUG_PROFILE
		if(insert_rec_3){
			test.append("inside insert 3");
			pstmt			= connection.prepareStatement(sql_ph_prescription_select55) ;
			pstmt.setString(1,patientId);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				srl_NO=resultSet.getInt("NEXT_SRL_NO");
			}
			closeResultSet( resultSet );
			closeStatement( pstmt) ;
			HashMap insertRecords_4		=	null;
			String in_strength_value	=	null;
			String in_strength_uom		=	null;
			String split_dose_preview	=	null;
			scheduled_yn="";
			PreparedStatement pstmt_am_uom_eqvl	= connection.prepareStatement(sql_ph_prescription_select53) ;
			Statement statement = null;
			statement = connection.createStatement();
			String uomDisplay = "";
			String patient_stock_yn = "N"; //GHL-CRF-0482
			pstmt_insert				=	connection.prepareStatement(sql_insert_4) ;
			for(int i=0;i<OrderID.size();i++){
				headerList		=	new ArrayList();
				order_id		=	(String) OrderID.get(i);
				headerList=(ArrayList) OrderDetails.get(i);
				for(int j=0;j<headerList.size();j++){
					//added for  SKR-SCF-0345 [IN:029894] - start
					day_list		=	null;
					freq_char_list	= null;
					day_list		= null;
					day_names		= null;
					time_list		= null;
					dose_list		= null;
					frequencyValues = null;
					chkValuescheduleFrequency = null;
					schedule = null;//added for  SKR-SCF-0345 [IN:029894] - end

					insertRecords_4	=	(HashMap) headerList.get(j);
					pstmt_insert.setString(1,patientId);
					drug_code						=(String)insertRecords_4.get("DRUG_CODE");		
					dosage_type						=(String)insertRecords_4.get("DOSAGE_TYPE");
					qty_value						=(String)insertRecords_4.get("QTY_VALUE");
					qty_unit						=(String)insertRecords_4.get("QTY_DESC_CODE");
					repeat_value					=(String)insertRecords_4.get("REPEAT_VALUE");
					durn_value						=(String)insertRecords_4.get("DURN_VALUE");
					freq_nature						=(String)insertRecords_4.get("FREQ_NATURE");
					interval_value					=Float.parseFloat((String)insertRecords_4.get("INTERVAL_VALUE")==null?"1":(String)insertRecords_4.get("INTERVAL_VALUE"));
					scheduled_yn					=(String)insertRecords_4.get("SCHEDULED_YN");
					strength_value					=(String)insertRecords_4.get("ACT_STRENGTH_VALUE");
					strength_uom					=(String)insertRecords_4.get("STRENGTH_UOM");
					pres_base_uom					=(String)insertRecords_4.get("PRES_BASE_UOM");
					fract_dose						=(String)insertRecords_4.get("FRACT_DOSE_ROUND_UP_YN");
					strength_per_value_per_pres_uom	=(String)insertRecords_4.get("STRENGTH_PER_VALUE_PRES_UOM");
					strength_per_pres_uom			=(String)insertRecords_4.get("STRENGTH_PER_PRES_UOM");
					content_in_pres_base_uom		=(String)insertRecords_4.get("CONTENT_IN_PRES_BASE_UOM");
					patient_stock_yn				= (String)insertRecords_4.get("patient_stock_yn"); //added for GHL-CRF-0482
					if(patient_stock_yn==null || patient_stock_yn.equals(""))
						patient_stock_yn = "N";
					allergy_yn						=(String)insertRecords_4.get("ALLERGY_YN")==null?"N":(String)insertRecords_4.get("ALLERGY_YN");
					dsg_reason						=(String)insertRecords_4.get("EXT_DDB_DSG_REASON")==null?"":(String)insertRecords_4.get("EXT_DDB_DSG_REASON");  
					dup_reason						=(String)insertRecords_4.get("EXT_DDB_DUP_REASON")==null?"":(String)insertRecords_4.get("EXT_DDB_DUP_REASON"); 
					con_reason						=(String)insertRecords_4.get("EXT_DDB_CON_REASON")==null?"":(String)insertRecords_4.get("EXT_DDB_CON_REASON"); 
					int_reason						=(String)insertRecords_4.get("EXT_DDB_INT_REASON")==null?"":(String)insertRecords_4.get("EXT_DDB_INT_REASON");   
					alg_reason						=(String)insertRecords_4.get("EXT_DDB_ALG_REASON")==null?"":(String)insertRecords_4.get("EXT_DDB_ALG_REASON"); 
					
					resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+login_facility_id+"','"+(String)insertRecords_4.get("QTY_DESC_CODE")+"','"+language_id+"') UOM_DISPLAY from dual");

					if(resultSet!=null && resultSet.next()){
						uomDisplay = resultSet.getString("UOM_DISPLAY");
					}		
					if(insertRecords_4.get("freq_chng_durn_value")!=null && !durn_value.equals((String)insertRecords_4.get("freq_chng_durn_value"))){
						durn_value = (String)insertRecords_4.get("freq_chng_durn_value");
					}
					if(freq_nature.equals("F") || freq_nature.equals("I")) 
						durn_value_calc	=	(float)Math.ceil(Float.parseFloat(durn_value)/ interval_value);
					else
						durn_value_calc = Float.parseFloat(durn_value);

					prn_remarks_temp				="";						
					prn_remarks_code				="";						
					prn_remarks_hash				=new HashMap();						
					in_qty_unit						="";
					in_order_qty					="";
					in_strength_value				=qty_value;
					in_strength_uom					="";
					split_dose_yn_val				="N";
					qty_value_1						= qty_value;

					chkValuescheduleFrequency=ScheduleFreq;
					//ArrayList schedule	= new ArrayList();

					if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
						if(chkValuescheduleFrequency.containsKey((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO")))
							schedule = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO"));
					}
					if(insertRecords_4.containsKey("SPLIT_DOSE_YN_VAL")){
						split_dose_yn_val=(String)insertRecords_4.get("SPLIT_DOSE_YN_VAL");
					}
					else{
						  split_dose_yn_val="N";
					}
					qty_value_1 ="0";

					if(dosage_type.equals("A")){
						qty_value_1        =  qty_value;
					}
					if(schedule != null && schedule.size()>0){
						dose_list	= (ArrayList)schedule.get(4);						
					}
					
					if(dose_list!= null && dose_list.size() > 0 && (split_dose_yn_val.equals("N")) ) {							 
						if(fract_dose.equals("N")) { 
							//HashMap detail		=	(HashMap)schedule.get(0);
							//qty_value			=	((String)detail.get("admin_qty")).equals("0")?qty_value:(String)detail.get("admin_qty");
							qty_value			=	((String)dose_list.get(0)).equals("0")?qty_value:(String)dose_list.get(0);
							qty_value_1			=   qty_value;	
						}
						else {
							//HashMap detail	=	(HashMap)schedule.get(0);
							if(dosage_type.equals("S")){
								//qty_value		=	((String)detail.get("admin_qty")).equals("0")?qty_value:(String)detail.get("admin_qty");
								qty_value		=	((String)dose_list.get(0)).equals("0")?qty_value:(String)dose_list.get(0);
								qty_value_1     =   qty_value;
								qty_value       =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";
								//qty_value       =   (Float.parseFloat(qty_value)/Float.parseFloat(strength_value))+"";
								qty_value		=	Float.parseFloat(qty_value) * Float.parseFloat(strength_value)+"";
							}
							else if(dosage_type.equals("Q")){
								//qty_value		=	((String)detail.get("admin_qty")).equals("0")?qty_value:(String)detail.get("admin_qty");
								qty_value		=	((String)dose_list.get(0)).equals("0")?qty_value:(String)dose_list.get(0);
								qty_value_1     =   qty_value;
								qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
								//qty_value		=   (Float.parseFloat(qty_value))+"";
							}  
							//qty_value          =   (Math.ceil(Float.parseFloat(qty_value)*schedule.size()))+"";    

						}
					//	repeat_value	=	""+schedule.size();
						repeat_value	=	""+dose_list.size();
					}
					else  if(dose_list!=null && dose_list.size() > 0 && (split_dose_yn_val.equals("Y")) ) {
						tot_qty_value       = 0;
						qty_value_2			= 0;
						if(fract_dose.equals("N")) {
							for(int tqI=0;tqI<dose_list.size();tqI++){
								repeat_value	=	"1";
								tot_qty_value	=	tot_qty_value+Float.parseFloat((String)dose_list.get(tqI));
							}
							/*for(int n=0; n<schedule.size(); n++) {
							  repeat_value		=	"1";
							  HashMap  detail	=  (HashMap)schedule.get(n);
							  tot_qty_value     =  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));
							}*/
						}
						else{
							for(int n=0; n<dose_list.size(); n++) {
							  repeat_value		=	"1";
							  //HashMap  detail	=  (HashMap)schedule.get(n);

								 if(dosage_type.equals("S")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(n);
									qty_value_1		=	Float.parseFloat(qty_value_1)+Float.parseFloat(qty_value)+"";
									qty_value		=   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(strength_value)))+"";  //uncommented for ML-BRU-SCF-0623 [IN:036638]
									//qty_value		=   (Float.parseFloat(qty_value)/Float.parseFloat(strength_value))+"";  //commented for ML-BRU-SCF-0623 [IN:036638]
									qty_value_2     +=  (Math.ceil(Float.parseFloat(qty_value)*Float.parseFloat(strength_value)));
									qty_value		=	Float.parseFloat(qty_value)*Float.parseFloat(strength_value)+"";
									 
								  }
								  else if(dosage_type.equals("Q")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(n);
									qty_value_1     =	Float.parseFloat(qty_value_1)+Float.parseFloat(qty_value)+"";
									qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+""; //uncommented for ML-BRU-SCF-0623 [IN:036638]
									//qty_value		=   (Float.parseFloat(qty_value))+""; //commented for ML-BRU-SCF-0623 [IN:036638]
									qty_value_2    +=	Float.parseFloat(qty_value);
								 }  

								tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
								str_tot_qty_value 			 	=  Float.toString(tot_qty_value);
								if(str_tot_qty_value.length()>16)
									tot_qty_value	=  Float.parseFloat(str_tot_qty_value.substring(0,15));
							}
						}  
						qty_value          =  tot_qty_value+"";
					}//code added for PRN Remarks..
					// conditiona added for  Exception while Ordering in Normal Rx (PRN Remarks if not entered) [IN:030354]	
					if((prn_remarks!=null)&& (drug_code!=null)){
						if(freq_nature.equals("P") && prn_remarks.containsKey(drug_code)){
							prn_remarks_hash=(HashMap)prn_remarks.get(drug_code);
							prn_remarks_temp =prn_remarks_hash.get("prn_remarks_dtl")==null?"":(String)prn_remarks_hash.get("prn_remarks_dtl");
							prn_remarks_code =prn_remarks_hash.get("prn_remarks_code")==null?"":(String)prn_remarks_hash.get("prn_remarks_code");
						}
					}
					/*commenting these line coz prn_remarks enhancement is not available in site 03/02/2010
					if(freq_nature.equals("P")){
						prn_remarks_temp=(String)prn_remarks.get(drug_code)==null?"":(String)prn_remarks.get(drug_code);
					}*/					
					if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
						if(freq_nature!=null && freq_nature.equals("P")&& !dosage_type.equals("A")) {
							in_qty_unit		=	qty_unit;
							if(insertRecords_4.get("ABSOL_QTY")==null || ((String)insertRecords_4.get("ABSOL_QTY")).equals("0")) {
								if(insertRecords_4.get("PRN_DOSES_PRES_PRD_FILL")==null || ((String)insertRecords_4.get("PRN_DOSES_PRES_PRD_FILL")).equals("0")) {
									 in_order_qty	= "1";
								} 
								else {
									in_order_qty	=	((String)insertRecords_4.get("PRN_DOSES_PRES_PRD_FILL"));
								}
							} 
							else {
								in_order_qty	= ((String)insertRecords_4.get("ABSOL_QTY"));
							}
							in_strength_value	=	strength_value;
							in_strength_uom		=	strength_uom;
						}
						else {
							in_qty_unit			=	qty_unit;
							//in_order_qty		=	(((String)insertRecords_4.get("ABSOL_QTY")==null)?"1":(String)insertRecords_4.get("ABSOL_QTY"));
							//added if and else for kdah-scf-0388  start
							System.err.println("ABSOL_QTY   Line 2017  :"+insertRecords_4.get("ABSOL_QTY"));
							if(insertRecords_4.get("ABSOL_QTY")==null || ((String)insertRecords_4.get("ABSOL_QTY")).equals("0")) {
								in_order_qty="1";
							}else
							{
								in_order_qty=(String)insertRecords_4.get("ABSOL_QTY");
							}//  kdah-scf-0388  end
							//in_order_qty = Math.ceil(Float.parseFloat(in_order_qty) * Float.parseFloat(content_in_pres_base_uom))+""; //commented for ARYU-SCF-104

							in_strength_value	=	strength_value;
							in_strength_uom		=	strength_uom;
							in_qty_unit			=	qty_unit;
						}	
					}
					else if(dosage_type!=null && dosage_type.equals("Q")){
						//String equl_value	=	"1";
						pstmt_am_uom_eqvl.setString(1,pres_base_uom);
						pstmt_am_uom_eqvl.setString(2,qty_unit);
						pstmt_am_uom_eqvl.setString(3,pres_base_uom);
						pstmt_am_uom_eqvl.setString(4,qty_unit);
						resultSet	= pstmt_am_uom_eqvl.executeQuery();
						if ( resultSet != null && resultSet.next() ) {
							equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}
						closeResultSet( resultSet );
						in_qty_unit			=	qty_unit;
						//float ord_qty		=	0.0f;

						if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
							if(fract_dose.equals("N")) {
								ord_qty		=	(Float.parseFloat(qty_value)*durn_value_calc*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));
								ord_qty		=	Float.parseFloat(Math.ceil(ord_qty/(Float.parseFloat(content_in_pres_base_uom)))+"");
								//PH_PATIENT_DRUG_PROFILE ML-BRU-SCF-2146
								if( insertRecords_4.get("ORDER_QTY")!=null ){
									ord_qty = Float.parseFloat(insertRecords_4.get("ORDER_QTY")+"");  
								}
								if(ord_qty==0)
									ord_qty	=	1;
							}
							else {
								//String	tmp_qty	=	"";
								if( (Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom)){
									tmp_qty	=	1+""; 
								} 
								else {
									if((Float.parseFloat(content_in_pres_base_uom)<1) || ((Float.parseFloat(qty_value)*Float.parseFloat(content_in_pres_base_uom))<Float.parseFloat(equl_value))) //if block and else condition added for ML-BRU-SCF-1190 [IN:045647] and OR condition added for ML-MMOH-SCF-1596
										tmp_qty	=  Math.ceil(Float.parseFloat(qty_value)/(Float.parseFloat(equl_value)*Float.parseFloat(content_in_pres_base_uom)))+"";
									else
										tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(equl_value))/Float.parseFloat(content_in_pres_base_uom))+"";
								}
								ord_qty		=  Float.parseFloat(tmp_qty) *durn_value_calc * Integer.parseInt(repeat_value) ;
							}
						}
						/*if(freq_nature.equals("F")) {
							ord_qty		=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+"");
						}*/

						if(repeat_value == null || repeat_value.equals(""))
							repeat_value = "1";
						in_order_qty	=	Float.parseFloat(qty_value)*durn_value_calc*Float.parseFloat(repeat_value)*Float.parseFloat(equl_value)+""; //*Float.parseFloat(equl_value) commented for for ML-BRU-SCF-1190 [IN:045647]// removed comment for ML-BRU-SCF-1650 [IN:057986](wrong pres qty in pateint drug profile)
						if( insertRecords_4.get("ORDER_QTY")!=null ){//ML-BRU-SCF-2146  
							in_order_qty = (String)(insertRecords_4.get("ORDER_QTY")+"");   
						}
						/*if( (Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom)){
							in_order_qty	=  Math.ceil((Float.parseFloat(in_order_qty) ) /Float.parseFloat(content_in_pres_base_uom))+"";
						}*/ //Commented for ML-BRU-SCF-1394 & AAKH-SCF-0113 [IN:048937]
						//added for ML-MMOH-SCF-1596
						if( (Float.parseFloat(qty_value)*Float.parseFloat(content_in_pres_base_uom)) < Float.parseFloat(equl_value) ){ //added for ML-MMOH-SCF-1596
							//in_order_qty	=	(Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(equl_value))*durn_value_calc*Float.parseFloat(repeat_value))+""; //Math.ceil added for ML-MMOH-SCF-1610
							in_order_qty	=	((Float.parseFloat(qty_value)/Float.parseFloat(equl_value))*durn_value_calc*Float.parseFloat(repeat_value))+""; //Math.ceil removed for SKR-SCF-1562 
							//System.err.println("in_order_qty===2107==>"+in_order_qty); 
						} 

						in_strength_value	=	strength_value;
						in_strength_uom		=	strength_uom;
					}
					else if(dosage_type!=null && dosage_type.equals("S")){
						in_qty_unit=qty_unit;
						//float ord_qty	=0.0f;
						//String tmp_qty	= "";
						if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	
							if(!fract_dose.equals("Y")) {	
								ord_qty		=Float.parseFloat(qty_value)*durn_value_calc*Integer.parseInt(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom);
								ord_qty		=new Double(Math.ceil(ord_qty/(Float.parseFloat(content_in_pres_base_uom)*Float.parseFloat(strength_per_pres_uom)))).floatValue();
								if( insertRecords_4.get("ORDER_QTY")!=null ){//PH_PATIENT_DRUG_PROFILE ML-BRU-SCF-2146 
									ord_qty = Float.parseFloat(insertRecords_4.get("ORDER_QTY")+"");   
								}
							}
							else {
							// bellow if block and else condition added for SRR20056-SCF-7514	27576
								double unit_qty	=1.0;
								float unit_dose_qty =(Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(strength_per_pres_uom))*Float.parseFloat(qty_value);
								if(freq_nature.equals("O") || unit_dose_qty == Float.parseFloat(content_in_pres_base_uom) || (unit_dose_qty % Float.parseFloat(content_in_pres_base_uom)) == 0)
									unit_qty	=   Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom);
								else
									unit_qty	=   Math.ceil(Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom));
								tmp_qty			=   unit_qty *durn_value_calc * Integer.parseInt(repeat_value)+"";
								ord_qty			= new Double(Math.ceil(new Double( (Float.parseFloat(tmp_qty)*Float.parseFloat(strength_per_value_per_pres_uom)) /Float.parseFloat(content_in_pres_base_uom)).doubleValue())).floatValue();
							}

							if(freq_nature.equals("F")) {
								ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ interval_value)+"");
							}
						}
						if(in_order_qty == null || in_order_qty.equals(""))
							in_order_qty=Math.ceil((Float.parseFloat(qty_value)*durn_value_calc*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/Float.parseFloat(strength_per_pres_uom))+"";
						if( insertRecords_4.get("ORDER_QTY")!=null ){//ML-BRU-SCF-2146  
							in_order_qty = (String)(insertRecords_4.get("ORDER_QTY")+"");   
						}
						in_strength_value=strength_value;
						in_strength_uom=strength_uom;
					}
				//end of logic
				if(in_order_qty.equals("")|| in_order_qty.equals("0"))//Added for KDAH-SCF-0388.1
					in_order_qty="1";//Added for KDAH-SCF-0388.1

					pstmt_insert.setString(2,""+(srl_NO));
					pstmt_insert.setString(3,facilityId);
					pstmt_insert.setString(4,encounterId);
					pstmt_insert.setString(5,(patientClass));
					pstmt_insert.setString(6,locationType);

				   if( ((String)tabData.get("external_pres_flag")).equals("true")){
						pstmt_insert.setString(7,"");
				   }
				   else{
						pstmt_insert.setString(7,locationCode);
				   }
					pstmt_insert.setString(8,"");
					if(patientClass.equals("IP")){
						pstmt_insert.setString(9, room_num);
						pstmt_insert.setString(10, bed_num);
					}
					else{
						pstmt_insert.setString(9,"");
						pstmt_insert.setString(10,"");
					}

					pstmt_insert.setString(11,"");
					pstmt_insert.setString(12,"");
					System.err.println("SPECIALITY_CODE@@@=="+(String)insertRecords_4.get("SPECIALITY_CODE"));
					pstmt_insert.setString(13,(String)insertRecords_4.get("SPECIALITY_CODE"));
					pstmt_insert.setString(14,practId);
					pstmt_insert.setString(15,practId);

					pstmt_insert.setString(16,(String)insertRecords_4.get("DRUG_CODE"));
					pstmt_insert.setString(17,(String)insertRecords_4.get("GENERIC_ID"));
					if(insertRecords_4.get("START_DATE")==null)
						pstmt_insert.setString(18,(String)insertRecords_4.get("START_DATE_TIME"));
					else
						pstmt_insert.setString(18,(String)insertRecords_4.get("START_DATE"));

					if( insertRecords_4.get("END_DATE")==null) 
						pstmt_insert.setString(19,(String)insertRecords_4.get("END_DATE_TIME"));
					else
						pstmt_insert.setString(19,(String)insertRecords_4.get("END_DATE"));

					// Checking Split or Scheduled - Starts
					found		=	false;
					firstTime	=	true;
					tmp			=	"";
					admin_qty	=	null;
					frequencyValues		=	null;
					dose_list			=   null;

					if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
						if(chkValuescheduleFrequency.containsKey((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO")))
							frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO"));
					}

					if(frequencyValues!=null && frequencyValues.size()>0){
					//	HashMap data=	null;
						dose_list	= (ArrayList)frequencyValues.get(4);						
						for(int n=0;n<dose_list.size();n++){
//							data	=new HashMap();
//							data	=(HashMap)frequencyValues.get(n);
//							admin_qty	= ((String)data.get("admin_qty")).trim();
							admin_qty	= ((String)dose_list.get(n)).trim();
							if(firstTime) {
								tmp			=	admin_qty;
								firstTime	=	false;
							}
							else if(!tmp.equals(admin_qty)) {
								found		=	true;
							//	break;
							}
						}
					}

					//Checking Split or Scheduled - ends
					if(found)
						pstmt_insert.setString(20,"Y");
					else 
						pstmt_insert.setString(20,"N");

					if( ((String)tabData.get("external_pres_flag")).equals("true"))
						pstmt_insert.setString(21,"N");
					else if(insertRecords_4.get("DRUG_TAPERED_YN")==null) 
						pstmt_insert.setString(21,"N");
					else 
						pstmt_insert.setString(21,insertRecords_4.get("DRUG_TAPERED_YN")==null?"N":(String)insertRecords_4.get("DRUG_TAPERED_YN"));//replaced TAPER_DOSE_YN with DRUG_TAPERED_YN for updating tapered_yn coulmn in ph_patient_drug_profile to "Y" even for main drug for IN25621-- 21/02/2011-- priya
					if(qty_value_1.trim().equals("0")){
					  qty_value_1=qty_value;
					}
					pstmt_insert.setString(22,in_strength_value);
					pstmt_insert.setString(23,in_strength_uom);
					pstmt_insert.setString(24,qty_value_1);
					pstmt_insert.setString(25,in_qty_unit);						

					split_dose_preview	=	"";
					if(scheduled_yn.equals("Y")){
						frequencyValues = new ArrayList();
						if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
							if(chkValuescheduleFrequency.containsKey((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO")))
								frequencyValues = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_4.get("DRUG_CODE")+(String)insertRecords_4.get("SRL_NO"));
						}
						if(frequencyValues!=null && frequencyValues.size()>0){
							freq_char_list	= (HashMap)frequencyValues.get(0);
							day_list		= (ArrayList)frequencyValues.get(1);
							day_names		= (ArrayList)frequencyValues.get(2);
							time_list		= (ArrayList)frequencyValues.get(3);
							dose_list		= (ArrayList)frequencyValues.get(4);

							for(int frStr = 0;frStr<day_list.size();frStr++){
								if(!freq_char_list.get("durationType").equals("D") && !freq_char_list.get("durationType").equals("H") ){

									split_dose_preview = split_dose_preview + "Day "+day_list.get(frStr);
									split_dose_preview = split_dose_preview + " - ";
									if(!freq_char_list.get("durationType").equals("L")){
										split_dose_preview = split_dose_preview + day_names.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
									}
								}
								split_dose_preview = split_dose_preview + time_list.get(frStr);
								split_dose_preview = split_dose_preview + " - ";
								split_dose_preview = split_dose_preview + dose_list.get(frStr);
								//split_dose_preview = split_dose_preview + " "+(String)insertRecords_4.get("QTY_DESC_CODE");
								split_dose_preview = split_dose_preview + " "+uomDisplay;
								split_dose_preview = split_dose_preview + "; ";
							}
							/*for(int n=0;n<frequencyValues.size();n++){
								HashMap data=new HashMap();
								data=(HashMap)frequencyValues.get(n);
								split_dose_preview = split_dose_preview + (String)data.get("admin_time");
								split_dose_preview = split_dose_preview + " = ";
								split_dose_preview = split_dose_preview + (String)data.get("admin_qty");
								split_dose_preview = split_dose_preview + " ";
								split_dose_preview = split_dose_preview + (String)insertRecords_4.get("QTY_DESC_CODE");
								split_dose_preview = split_dose_preview + " | ";
							}*/
						}
					}
					if(split_dose_preview.length()>1499 )
						split_dose_preview=split_dose_preview.substring(0,1499);
					else
						split_dose_preview=split_dose_preview;
					pstmt_insert.setString(26,split_dose_preview);
					pstmt_insert.setString(27,(String)insertRecords_4.get("FREQ_CODE"));
					pstmt_insert.setString(28,(String)insertRecords_4.get("DURN_VALUE"));
					System.err.println("in_order_qty for KDAH-SCF-0388===="+in_order_qty);
					pstmt_insert.setString(29,in_order_qty);
					String diagText="";
					if(diag_text!=null && diag_text.size()>0){
						diagText=(String)diag_text.get(3)+"~"+(String)diag_text.get(7)+"~"+(String)diag_text.get(11);
					}

					pstmt_insert.setString(30,diagText);
					pstmt_insert.setString(31,"");
					pstmt_insert.setString(32,"N");
					pstmt_insert.setString(33,"");
					pstmt_insert.setString(34,"");
					pstmt_insert.setString(35,"");
					pstmt_insert.setString(36,"");
					pstmt_insert.setString(37,"");
					pstmt_insert.setString(38,"N");
					pstmt_insert.setString(39,"");
					pstmt_insert.setString(40,null);
					pstmt_insert.setString(41,"N");
					pstmt_insert.setString(42,"");
					pstmt_insert.setString(43,null);
					pstmt_insert.setString(44,"P");

					pstmt_insert.setString(45,facilityId);
					pstmt_insert.setString(46,order_id);
					pstmt_insert.setString(47,""+(j+1));
					pstmt_insert.setString(48,"");
					pstmt_insert.setString(49,"N");

					pstmt_insert.setString(50,null);
					pstmt_insert.setString(51,"");
					pstmt_insert.setString(52,"");
					pstmt_insert.setString(53,null);
					pstmt_insert.setString(54,"");
					pstmt_insert.setString(55,"");
					pstmt_insert.setString(56,"N");
					pstmt_insert.setString(57,null);
					pstmt_insert.setString(58,"");
					pstmt_insert.setString(59,"");

					pstmt_insert.setString(60,login_by_id);
					pstmt_insert.setString(61,login_at_ws_no);
					pstmt_insert.setString(62,login_facility_id);
					pstmt_insert.setString(63,login_by_id);
					pstmt_insert.setString(64,login_at_ws_no);
					pstmt_insert.setString(65,login_facility_id);
					pstmt_insert.setString(66,(String)insertRecords_4.get("ROUTE_CODE"));

					if(!alg_reason.equals(""))
						pstmt_insert.setString(67,alg_reason);
					else
						pstmt_insert.setString(67,(String)insertRecords_4.get("ALLERGY_REMARKS"));

					if(!dsg_reason.equals(""))
						pstmt_insert.setString(68,dsg_reason);
					else
						pstmt_insert.setString(68,(String)insertRecords_4.get("DOSE_REMARKS"));

					pstmt_insert.setString(69,"");

					if(insertRecords_4.get("DURN_TYPE")==null || ((String)insertRecords_4.get("DURN_TYPE")).equals("") ||((String)insertRecords_4.get("DURN_TYPE")).equals("null")){
						pstmt_insert.setString(70,"D");
					} 
					else{
						if(insertRecords_4.get("freq_chng_durn_desc")==null ||((String)insertRecords_4.get("freq_chng_durn_desc")).equals(""))
							pstmt_insert.setString(70,(String)insertRecords_4.get("DURN_TYPE"));
						else
							pstmt_insert.setString(70,(String)insertRecords_4.get("freq_chng_durn_desc"));
					}
					pstmt_insert.setString(71,"");
					pstmt_insert.setString(72,"");
					pstmt_insert.setString(73,"");

					if(!dup_reason.equals(""))
						pstmt_insert.setString(74,dup_reason);
					else
						pstmt_insert.setString(74,(String)insertRecords_4.get("CURRENTRX_REMARKS"));

					if( ((String)tabData.get("external_pres_flag")).equals("true")){
						pstmt_insert.setString(75,"N");
					}
					else{
						if(insertRecords_4.get("NO_REFILL")!=null && !((String)insertRecords_4.get("NO_REFILL")).equals("") ) {
							pstmt_insert.setString(75,"Y");
						} 
						else {
							pstmt_insert.setString(75,"N");
						}
					}
					pstmt_insert.setString(76,(String)insertRecords_4.get("FORM_CODE"));
					if(diag_text!=null && diag_text.size()>0){
						pstmt_insert.setString(77,(String)diag_text.get(0));
						pstmt_insert.setString(78,(String)diag_text.get(1));
						pstmt_insert.setString(79,(String)diag_text.get(2));
						pstmt_insert.setString(80,(String)diag_text.get(4));
						pstmt_insert.setString(81,(String)diag_text.get(5));
						pstmt_insert.setString(82,(String)diag_text.get(6));
						pstmt_insert.setString(83,(String)diag_text.get(8));
						pstmt_insert.setString(84,(String)diag_text.get(9));
						pstmt_insert.setString(85,(String)diag_text.get(10));
					}
					else{
						pstmt_insert.setString(77,"");
						pstmt_insert.setString(78,"");
						pstmt_insert.setString(79,"");
						pstmt_insert.setString(80,"");
						pstmt_insert.setString(81,"");
						pstmt_insert.setString(82,"");
						pstmt_insert.setString(83,"");
						pstmt_insert.setString(84,"");
						pstmt_insert.setString(85,"");
					}
					pstmt_insert.setString(86,(String)insertRecords_4.get("DOSAGE_TYPE"));
					pstmt_insert.setString(87,height);
					pstmt_insert.setString(88,height_unit);
					pstmt_insert.setString(89,weight);
					pstmt_insert.setString(90,weight_unit);
					pstmt_insert.setString(91,bsa);
					pstmt_insert.setString(92,allergy_yn);	
					pstmt_insert.setString(93,bmi);
					//Exception while Ordering in Normal Rx (PRN Remarks if not entered) [IN:030354]
					pstmt_insert.setString(94,prn_remarks_temp);
					if(insertRecords_4.containsKey("SLIDING_SCALE_REMARKS")){
						pstmt_insert.setString(95,(String)insertRecords_4.get("SLIDING_SCALE_REMARKS"));
					}
					else{
						pstmt_insert.setString(95,"");
					}
					pstmt_insert.setString(96,con_reason);
					//pstmt_insert.setString(97,int_reason);
					if(!int_reason.equals(""))
						pstmt_insert.setString(97,int_reason);
					else
						pstmt_insert.setString(97,(String)insertRecords_4.get("INTERACTION_REMARKS"));
					pstmt_insert.setString(98,(String)insertRecords_4.get("DRUG_DB_PRODUCT_ID"));
					/*commenting the below line coz prn remarks enhancement is not available in mfq  site 03/02/2010 */
					//Exception while Ordering in Normal Rx (PRN Remarks if not entered) [IN:030354]
					pstmt_insert.setString(99,prn_remarks_code);
					pstmt_insert.setString(100,patient_stock_yn);//added for ghl-crf-0482
					pstmt_insert.setString(101,(String)insertRecords_4.get("ABUSE_EXISTS"));//added for aakh-crf-0140
					pstmt_insert.setString(102,(String)insertRecords_4.get("abuse_override_remarks"));//added for aakh-crf-0140
					//pstmt_insert.executeUpdate();
					pstmt_insert.addBatch();
					srl_NO++;
				}
			}
			int[] result_insert_4= pstmt_insert.executeBatch();
			for (int i=0;i<result_insert_4.length ;i++ ){
				if(result_insert_4[i]<0  && result_insert_4[i] != -2 ){
					System.err.println("NORMAL RX--> ERROR IN INSERTING PH_PATIENT_DRUG_PROFILE result_insert_4["+i+"]= "+result_insert_4[i]);
					System.err.println("tabData=== "+tabData);
					insert_rec_4=false;
					break;
				}
				else{
					insert_rec_4=true;
				}
			}
			closeStatement( statement) ;
			closeStatement( pstmt_insert) ;
			closeResultSet( resultSet );
			closeStatement( pstmt_am_uom_eqvl) ;
		}
	//	insert_rec_4=true;
//INSERTING INTO OR_ORDER_COMMENT
		if(insert_rec_4){
			String action_seq_num	=	"";
		//	String order_id		=	null;
			if(called_from.equals("RENEW_ORDER")) {
				//ArrayList headerList	=	null;
				//HashMap insertRecords_2	=	null;
				String line_det			=	null;
				String old_order		=	null;						
				PreparedStatement pstmt_or_order_comment			= connection.prepareStatement(sql_ph_renew_prescription_insert2) ;
				pstmt_select	= connection.prepareStatement(sql_ph_prescription_select56a) ;
				for(int i=0;i<OrderID.size();i++){
					order_id	= (String) OrderID.get(i);
					headerList	= (ArrayList) OrderDetails.get(i);
					for(int j=0;j<headerList.size();j++){
						insertRecords_2=(HashMap) headerList.get(j);

						pstmt_select.setString(1,old_order);
						resultSet		= pstmt_select.executeQuery();
						if(resultSet!=null && resultSet.next()){
							action_seq_num=resultSet.getString(1)==null?"0":resultSet.getString(1);
						}
						closeResultSet( resultSet );
						int act_seq_no = Integer.parseInt(action_seq_num);
						if(act_seq_no > j){
							act_seq_no = j+1;
							line_det	=	(String)old_order_det.get((String)insertRecords_2.get("DRUG_CODE"));
							old_order	=	line_det.substring(0,line_det.indexOf(","));
							pstmt_or_order_comment.setString(1,order_id);
							pstmt_or_order_comment.setString(2,act_seq_no+"");
							pstmt_or_order_comment.setString(3,old_order);
							pstmt_or_order_comment.setString(4,act_seq_no+"");
							pstmt_or_order_comment.addBatch();
							//pstmt.executeUpdate();
						}
					}
				}
				insert_rec_5=true;
				if(OrderID!=null && OrderID.size()>0){
					int[] result_insert_renew= pstmt_or_order_comment.executeBatch();
					for (int i=0;i<result_insert_renew.length ;i++ ){
						if(result_insert_renew[i]<0  && result_insert_renew[i] != -2 ){
							System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER_COMMENT result_insert_renew["+i+"]= "+result_insert_renew[i]);
							System.err.println("tabData=== "+tabData);
							insert_rec_5=false;
							break;
						}
						else{
							insert_rec_5=true;
						}
					}
				}
				closeResultSet( resultSet );
				closeStatement( pstmt_or_order_comment) ;
				closeStatement(pstmt_select);
			}
			else {
				PreparedStatement pstmt_or_order_comment = connection.prepareStatement(sql_ph_prescription_select56) ;
				pstmt_insert		     = connection.prepareStatement(sql_insert_5) ;
				//pstmt_clob				 = connection.prepareStatement(sql_ph_prescription_select57) ;
				for (int i=0;i<OrderHeader.size() ;i++ ){
					order_id		=(String) OrderID.get(i);
					pstmt_or_order_comment.setString(1,order_id);
					resultSet		= pstmt_or_order_comment.executeQuery();
					if(resultSet!=null && resultSet.next()){
						action_seq_num	=	resultSet.getString(1);
					}
					closeResultSet( resultSet );
					pstmt_insert			=	null;
					String header_comments	= OrderRemarks==null?"":OrderRemarks;
					insert_rec_5=true;
					if(header_comments.length()>0){
						pstmt_insert		= connection.prepareStatement(sql_insert_5) ;
						pstmt_insert.setString(1,order_id);
						pstmt_insert.setString(2,action_seq_num);
						pstmt_insert.setString(3,login_by_id);         			
						pstmt_insert.setString(4,login_at_ws_no);
						pstmt_insert.setString(5,login_facility_id);
						pstmt_insert.setString(6,login_by_id);
						pstmt_insert.setString(7,login_at_ws_no);
						pstmt_insert.setString(8,login_facility_id);
						result_insert_5 = pstmt_insert.executeUpdate() ;
						closeStatement( pstmt_insert) ;

						if(result_insert_5>0){
							pstmt_clob		= connection.prepareStatement(sql_ph_prescription_select57) ;
							pstmt_clob.setString(1,order_id);
							pstmt_clob.setString(2,action_seq_num);
							rset_clob	=	pstmt_clob.executeQuery();

							if(rset_clob!=null ){
								while(rset_clob.next()){
									//Web logic Conversion Start.
									//CLOB clb 			= (CLOB) rset_clob.getClob(1);
									//BufferedWriter bw 	= new BufferedWriter(clb.getCharacterOutputStream());
									
									java.sql.Clob	clb =	(java.sql.Clob) rset_clob.getClob(1);
									BufferedWriter bw = new java.io.BufferedWriter(clb.setCharacterStream(0));
									//Web logic Conversion End.
									bw.write(header_comments,0,header_comments.length());
									bw.flush();
									bw.close();
								}
							}
							closeResultSet( rset_clob );
							closeStatement( pstmt_clob) ;
							insert_rec_5=true;
						}
						else{
							insert_rec_5=false;
							break;
						}
					}
				}
				closeResultSet( rset_clob );
				closeStatement( pstmt_clob) ;
				closeStatement(pstmt_or_order_comment);
			}
		}
//INSERTING INTO OR_ORDER_FIELD_VALUES
		if(insert_rec_5){
			if( (!(weight.equals(""))) && (!(height.equals(""))) ){
				String fld_value	=	null;
				String fld_legend	=	null;
				String fld_unit		=	null;
				String seq_no		=	null; 
				pstmt_insert		= connection.prepareStatement(sql_insert_6) ;
				for(int j=0;j<3;j++){
					fld_value	="";
					fld_legend	="";
					fld_unit	="";
					seq_no		="";
					if(j==0){
						fld_value=height;
						fld_legend="height";
						fld_unit=height_unit;
						seq_no="1";
					}
					if(j==1){
						fld_value=weight;
						fld_legend="weight";
						fld_unit=weight_unit;
						seq_no="2";
					}
					if(j==2){
						fld_value=bsa;
						fld_legend="bsa";
						fld_unit=bsa_unit;
						seq_no="3";
					}
					//String order_id	=	null;
					for (int i=0;i<OrderHeader.size() ;i++ ){
						order_id=(String) OrderID.get(i);
						pstmt_insert.setString(1,order_id);
						pstmt_insert.setString(2,seq_no);
						pstmt_insert.setString(3,fld_unit);
						pstmt_insert.setString(4,"N");
						pstmt_insert.setString(5,fld_legend);
						pstmt_insert.setString(6,fld_value);
						pstmt_insert.setString(7,"O");
						pstmt_insert.setString(8, login_by_id);
						pstmt_insert.setString(9, login_at_ws_no);
						pstmt_insert.setString(10,login_facility_id);
						pstmt_insert.setString(11,login_by_id);
						pstmt_insert.setString(12,login_at_ws_no);
						pstmt_insert.setString(13,login_facility_id);
						pstmt_insert.addBatch();
					}
				}
				int[] result_insert_6= pstmt_insert.executeBatch();
				closeStatement( pstmt_insert) ;
				for (int i=0;i<result_insert_6.length ;i++ ){
					if(result_insert_6[i]<0  && result_insert_6[i] != -2 ){
						System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER_FIELD_VALUES result_insert_6["+i+"]= "+result_insert_6[i]);
						System.err.println("tabData=== "+tabData);
						insert_rec_6=false;
						break;
					}
					else{
						insert_rec_6=true;
					}
				}

			}
			else{
				insert_rec_6=true;
			}
		}

//INSERTING INTO OR_ORDER_LINE_FIELD_VALUES
		if(insert_rec_6){
			int order_format_count	=	0;
			if(called_from.equals("RENEW_ORDER")) {
			//	ArrayList headerList	=	null;
			//	HashMap insertRecords_2	=	null;
			//	String order_id			=	null;
				String line_det			=	null;
				String line_no			=	null;
				String old_order		=	null;
				for(int i=0;i<OrderID.size();i++){
					order_id	=(String) OrderID.get(i);
					headerList	=(ArrayList) OrderDetails.get(i);
					for(int j=0;j<headerList.size();j++){
						insertRecords_2=(HashMap) headerList.get(j);
						line_det	=	(String)old_order_det.get((String)insertRecords_2.get("DRUG_CODE"));
						old_order	=	line_det.substring(0,line_det.indexOf(","));
						line_no		=	line_det.substring((line_det.length()-1),line_det.length());
						if(line_no.equals(",")) 
							pstmt_insert		= connection.prepareStatement(sql_ph_renew_prescription_insert1);
						else 
							pstmt_insert		= connection.prepareStatement(sql_ph_renew_prescription_insert1+" AND ORDER_LINE_NUM="+line_no);

						pstmt_insert.setString(1,order_id);
						pstmt_insert.setString(2,old_order);
						pstmt_insert.executeUpdate();
						closeStatement( pstmt_insert) ;
					}
				}
				insert_rec_7=true;
			} 
			else {
				pstmt_insert= connection.prepareStatement(sql_insert_7) ;
				insert_rec_7=true;
				if(DrugRemarks!=null && DrugRemarks.size()>0){
					//HashMap DrugValues=	null;
					String total_seq	=	null;
					String fr_drug_code	=	null;
					String serial_no	=	null;
					found		=	false;
					for (int i=0;i<DrugRemarks.size() ;i++ ){
						DrugValues= new HashMap();
						DrugValues=(HashMap)DrugRemarks.get(i);
						total_seq			=	(String)DrugValues.get("order_format_count") ;
						fr_drug_code		=	(String)DrugValues.get("fr_drug_code") ;
						serial_no			=	(String)DrugValues.get("serial_no") ;
						order_format_count	=	Integer.parseInt(total_seq);
						ord_line			=	(HashMap)order_line_det.get((String)DrugValues.get("order_id"));
						for(int k=0;k<order_format_count;k++){
							pstmt_insert.setString(1,(String)DrugValues.get("order_id"));
							pstmt_insert.setString(2,(String)ord_line.get(fr_drug_code+serial_no));
							pstmt_insert.setString(3,"S");
							pstmt_insert.setString(4,""+(k+1));
							pstmt_insert.setString(5,(String)DrugValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6,(String)DrugValues.get("field_type"+k));
							pstmt_insert.setString(7,(String)DrugValues.get("label_text"+k));
							pstmt_insert.setString(8,(String)DrugValues.get("field_values"+k));
							pstmt_insert.setString(9,"");
							pstmt_insert.setString(10,"");
							pstmt_insert.setString(11,(String)DrugValues.get("accept_option"+k));
							pstmt_insert.setString(12,"");
							pstmt_insert.setString(13,login_by_id);
							pstmt_insert.setString(14,login_at_ws_no);
							pstmt_insert.setString(15,login_facility_id);
							pstmt_insert.setString(16,login_by_id);
							pstmt_insert.setString(17,login_at_ws_no);
							pstmt_insert.setString(18,login_facility_id);
							pstmt_insert.addBatch();
							found	=	true;
						}
					}
					if(found){
						int[] result_insert_7= pstmt_insert.executeBatch();
							closeStatement( pstmt_insert) ;
							for (int i=0;i<result_insert_7.length ;i++ ){
								if(result_insert_7[i]<0  && result_insert_7[i] != -2 ){
									System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER_LINE_FIELD_VALUES result_insert_7["+i+"]= "+result_insert_7[i]);
									System.err.println("tabData=== "+tabData);
									insert_rec_7=false;
									break;
								}
								else{
									insert_rec_7=true;
								}
							}
						}
					}
				}
			}

//INSERTING INTO OR_ORDER_LINE_FIELD_VALUES for scheduled frequency
			insert_rec_8=true;
			if(insert_rec_7 && (!called_from.equals("RENEW_ORDER")) ) {
				boolean freq_values_found	=	false;
				pstmt_insert= connection.prepareStatement(sql_insert_7) ;
				if(DrugRemarks!=null && DrugRemarks.size()>0) {
					//HashMap		DrugValues		= null;
					//ArrayList	frequencyValues	= null;
					String		fr_drug_code	= null;
					String		serial_no		= null;
							/*	freq_char_list	= new HashMap();
								day_list		= new ArrayList();
					//ArrayList day_names		= new ArrayList();
								time_list		= new ArrayList();
								dose_list		= new ArrayList();*/
					for (int i=0;i<DrugRemarks.size() ;i++ ) {
						DrugValues= new HashMap();
						DrugValues=(HashMap)DrugRemarks.get(i);
						fr_drug_code	=	(String)DrugValues.get("fr_drug_code") ;
						serial_no	=	(String)DrugValues.get("serial_no") ;

						chkValuescheduleFrequency=ScheduleFreq;
						frequencyValues = new ArrayList();
						if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0) {
							if(chkValuescheduleFrequency.containsKey(fr_drug_code+serial_no))
								frequencyValues = (ArrayList) chkValuescheduleFrequency.get(fr_drug_code+serial_no);
						}

						ord_line			=	(HashMap)order_line_det.get((String)DrugValues.get("order_id"));
						if(frequencyValues!=null && frequencyValues.size()>0) {
//							HashMap data		=	null;
							//String admin_time	=	null;
							//String admin_qty	=	null;
							String durn_desc	=	null;
								/*freq_char_list	= new HashMap();
								day_list		= new ArrayList();
					//ArrayList day_names		= new ArrayList();
								time_list		= new ArrayList();
								dose_list		= new ArrayList();*/
						if(frequencyValues != null && frequencyValues.size() > 0){
							freq_char_list	= (HashMap)frequencyValues.get(0);
							day_list		= (ArrayList)frequencyValues.get(1);
							day_names		= (ArrayList)frequencyValues.get(2);
							time_list		= (ArrayList)frequencyValues.get(3);
							dose_list		= (ArrayList)frequencyValues.get(4);

						/*	freq_char_list	= (HashMap)frequencyValues.get("freq_char_list");
							day_list		= (ArrayList)frequencyValues.get("day_list");
							day_names		= (ArrayList)frequencyValues.get("day_names");
							time_list		= (ArrayList)frequencyValues.get("time_list");
							dose_list		= (ArrayList)frequencyValues.get("dose_list");*/
						}

							for(int n=0;n<day_list.size();n++) {
								freq_values_found = true;
								if(!unique_drugs.contains((String)DrugValues.get("order_id")+(String)ord_line.get(fr_drug_code+serial_no))) {
									seqNo=200;
									unique_drugs.add(((String)DrugValues.get("order_id")+(String)ord_line.get(fr_drug_code+serial_no)));
								}
								seqNo= ++seqNo;
/*								data=new HashMap();
								data=(HashMap)frequencyValues.get(n);
								admin_time	=(String)data.get("admin_time");
								admin_qty	=(String)data.get("admin_qty");*/

								durn_desc	=(String)ord_line.get(fr_drug_code+serial_no+"UOM");
								pstmt_insert.setString(1,(String)DrugValues.get("order_id"));
								pstmt_insert.setString(2,(String)ord_line.get(fr_drug_code+serial_no));
								pstmt_insert.setString(3,"S");
								pstmt_insert.setString(4,""+(seqNo));
								pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
								pstmt_insert.setString(6,"C");
								pstmt_insert.setString(7,"D");
//								pstmt_insert.setString(8,admin_time);
//								pstmt_insert.setString(9,admin_qty);
								pstmt_insert.setString(8,(String)time_list.get(n));
								pstmt_insert.setString(9,(String)dose_list.get(n));
								pstmt_insert.setString(10,durn_desc);
								pstmt_insert.setString(11,"O");

								pstmt_insert.setInt(12,Integer.parseInt(day_list.get(n)+""));
								pstmt_insert.setString(13,login_by_id);
								pstmt_insert.setString(14,login_at_ws_no);
								pstmt_insert.setString(15,login_facility_id);
								pstmt_insert.setString(16,login_by_id);
								pstmt_insert.setString(17,login_at_ws_no);
								pstmt_insert.setString(18,login_facility_id);
								pstmt_insert.addBatch();
							}
						}
						else{    //for interval frequency //Code added for IN20564 --06/07/2010-- priya
							String sch_date_time	=	"";
							HashMap schd_week_hr_dates	=	null;
							ArrayList schd_date_time	=	null;
							String tmp_sch_dt = "";
							String tmp_sch_time = "";
							String durn_desc = "";
							String sch_start_date_time = "";
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Calendar cal = Calendar.getInstance(); 
							for(int n=0;n<OrderID.size();n++){
								headerList	=(ArrayList) OrderDetails.get(n);
								for(int j=0;j<headerList.size();j++){
									insertRecords_2=(HashMap) headerList.get(j);
									if(insertRecords_2 != null){
										schd_week_hr_dates	=   (HashMap) tabData.get("sched_date_time_wkhr");
										if(schd_week_hr_dates!=null && schd_week_hr_dates.size() > 0){
											schd_date_time	=	(ArrayList)schd_week_hr_dates.get(fr_drug_code+serial_no); //added +serial_no for IN24521 --18/10/2010-- priya

											if(schd_date_time != null && schd_date_time.size()>0 && fr_drug_code.equals((String)insertRecords_2.get("DRUG_CODE")) && serial_no.equals((String)insertRecords_2.get("SRL_NO")) ){ //added && serial_no.equals((String)insertRecords_2.get("SRL_NO")) condition for IN24521 --18/10/2010-- priya
												
												sch_start_date_time = (String)schd_date_time.get(0);
												cal.setTime( dateFormat.parse( sch_start_date_time ) ); 
												cal.add( Calendar.DATE, 1 ); 
												sch_start_date_time = dateFormat.format(cal.getTime());  

												for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
													sch_date_time = (String)schd_date_time.get(scdDt);
													if((!sch_date_time.equals("")) && (sch_date_time != null)){
														tmp_sch_dt    = sch_date_time.substring(0,10);
														tmp_sch_time = sch_date_time.substring(11,16);

														if(!tmp_sch_time.equals("")&&(tmp_sch_time!=null) && ( ((java.util.Date)dateFormat.parse(sch_date_time)).compareTo((java.util.Date)dateFormat.parse(sch_start_date_time)) < 0   )){
															freq_values_found = true;
															if(!unique_drugs.contains((String)DrugValues.get("order_id")+(String)ord_line.get(fr_drug_code+serial_no))){
																seqNo=200;
																unique_drugs.add(((String)DrugValues.get("order_id")+(String)ord_line.get(fr_drug_code+serial_no)));
															}
															seqNo= ++seqNo;
															durn_desc	=(String)ord_line.get(fr_drug_code+serial_no+"UOM");
															pstmt_insert.setString(1,(String)DrugValues.get("order_id"));
															pstmt_insert.setString(2,(String)ord_line.get(fr_drug_code+serial_no));
															pstmt_insert.setString(3,"S");
															pstmt_insert.setString(4,""+(seqNo));
															pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
															pstmt_insert.setString(6,"C");
															pstmt_insert.setString(7,"D");
															pstmt_insert.setString(8,tmp_sch_time);
															pstmt_insert.setString(9,(String)insertRecords_2.get("QTY_VALUE"));
															pstmt_insert.setString(10,durn_desc);
															pstmt_insert.setString(11,"O");
															pstmt_insert.setInt(12,0);
															pstmt_insert.setString(13,login_by_id);
															pstmt_insert.setString(14,login_at_ws_no);
															pstmt_insert.setString(15,login_facility_id);
															pstmt_insert.setString(16,login_by_id);
															pstmt_insert.setString(17,login_at_ws_no);
															pstmt_insert.setString(18,login_facility_id);
															pstmt_insert.addBatch();

														}
														else if(((java.util.Date)dateFormat.parse(sch_date_time)).compareTo((java.util.Date)dateFormat.parse(sch_start_date_time)) >= 0 ){
															break;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if( freq_values_found ) {
						int[] result_insert_8= pstmt_insert.executeBatch();
						closeStatement( pstmt_insert) ;
						for (int i=0;i<result_insert_8.length ;i++ ){
							if(result_insert_8[i]<0  && result_insert_8[i] != -2 ){
								System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER_LINE_FIELD_VALUES result_insert_8["+i+"]= "+result_insert_8[i]);
								System.err.println("tabData=== "+tabData);
								insert_rec_8=false;
								break;
							}
							else{
								insert_rec_8=true;
							}
					   }
					}
				}
			}

//INSERTING INTO PH_MEDN_ADMIN
		//new added for medication administration
			if(insert_rec_8){
				insert_rec_9=true;
				//ArrayList headerList=new ArrayList();
				boolean freq_values_found=false;
				pstmt_insert	= connection.prepareStatement(sql_insert_8) ;
				pstmt_insert.clearBatch();

				String ord_end_date_time = "";
				String patient_class		=	null;
				ArrayList unique_schedules	=	new ArrayList();
				ArrayList tmp_drugs			=	new ArrayList();
				String equal_value			=	"";
				HashMap schd_week_hr_dates	=	new HashMap();
				ArrayList schd_date_time	=	new ArrayList();
				schd_week_hr_dates	=   (HashMap) tabData.get("sched_date_time_wkhr");

				String sliding_scale_yn = "";
				boolean contains_stat	=	false;
				insert_rec_9=true;
				HashMap insertRecords_8	=	null;
				String 	fr_drug_code=	null;
				String srl_no		=	null;
				ArrayList stat_dtls	=	new ArrayList();
				String admin_time		=	null;
				String sch_date_time	=	null;
				String stat_sch_time	=	"";
				ArrayList stat_time		=	new ArrayList();
				ArrayList tmp_sch_dt_tm =   new ArrayList();
				//boolean first_flag = true;//Commented for ML-BRU-SCF-1760
				String sch_strength,sch_strength_uom;
				int dose_seq_no			=	1;
				for(int i=0;i<OrderID.size();i++){
					headerList	=	new ArrayList();
					tempHeader	=	(HashMap) OrderHeader.get(i);
					ord_date_time		=(String)tempHeader.get("ORDER_DATE_TIME");
					/*if( ((String)tabData.get("external_pres_flag")).equals("true")){ //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
						ord_pract_id		=login_by_id;
					}
					else{*/
						ord_pract_id		=(String)tempHeader.get("ORD_PRACT_ID");
					//}
					facility_id		=(String)tempHeader.get("FACILITY_ID");
					encounter_id		=(String)tempHeader.get("ENCOUNTER_ID");
					patient_id			=(String)tempHeader.get("PATIENT_ID");
					patient_class		=(String)tempHeader.get("PATIENT_CLASS");
					order_id			=(String) OrderID.get(i);
					 
					headerList=(ArrayList) OrderDetails.get(i);

					PreparedStatement pstmt_am_uom_eqvl   = connection.prepareStatement(sql_ph_prescription_select53) ;
					PreparedStatement pstmt_scheduled_date_time	= connection.prepareStatement(sql_ph_prescription_select24b) ;
					PreparedStatement pstmt_ph_drug_vw	 = connection.prepareStatement(sql_ph_prescription_select64) ;

					String  verf_reqd_bef_med_admin_yn ="";
					String repeat_durn_type = ""; //Ml-BRU-SCF-1966
					pstmt	=	null;
					pstmt	=	connection.prepareStatement(sql_ph_prescription_select25a) ;
					pstmt.setString(1,facility_id);
					resultSet	= pstmt.executeQuery();
					if ( resultSet != null && resultSet.next() ) {
						verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
					}
					closeResultSet( resultSet );
					closeStatement( pstmt) ;
					for(int j=0;j<headerList.size();j++){
						insertRecords_8= new HashMap();
						schd_date_time	=	new ArrayList();
						insertRecords_8=(HashMap) headerList.get(j);
						buildMAR_yn=(String)insertRecords_8.get("BUILDMAR_YN")==null?"":(String)insertRecords_8.get("BUILDMAR_YN");
						MAR_barcode_id=(String)insertRecords_8.get("MAR_BARCODE_ID")==null?"":(String)insertRecords_8.get("MAR_BARCODE_ID");//added for  MMS-QH-CRF-0080 [IN:038064]	
						stat_sch_time	=	"";//added for  SKR-SCF-0332 [IN:029818] - start
						stat_time		=	new ArrayList();
						day_list		=	null;
						freq_char_list	= null;
						day_list		= null;
						day_names		= null;
						time_list		= null;
						dose_list		= null;
						frequencyValues = null;
						chkValuescheduleFrequency = null;
						schedule = null;//added for  SKR-SCF-0332 [IN:029818] - end
						boolean first_flag = true;//Added here from above for ML-BRU-SCF-1760
						if(buildMAR_yn.equals("Y")){
							fr_drug_code=(String)insertRecords_8.get("DRUG_CODE");
							srl_no		=(String)insertRecords_8.get("SRL_NO");
							durn_value	=(String)insertRecords_8.get("freq_chng_durn_value")==null?(String)insertRecords_8.get("DURN_VALUE"):(String)insertRecords_8.get("freq_chng_durn_value"); //changed DURN_VALUE to freq_chng_durn_value for IN21648 --28/05/2010 --priya  
							freq_nature		=	(String)insertRecords_8.get("FREQ_NATURE"); // Modified for SKR-SCF-1143 [IN:062004]   

							if((String)insertRecords_8.get("START_DATE")==null) 
								ord_date_time		=(String)insertRecords_8.get("START_DATE_TIME");
							else
								ord_date_time		=(String)insertRecords_8.get("START_DATE");
							
							if( insertRecords_8.get("END_DATE")==null) 
								ord_end_date_time		=(String)insertRecords_8.get("END_DATE_TIME");
							else
								ord_end_date_time		=(String)insertRecords_8.get("END_DATE");

							if(!tmp_drugs.contains(fr_drug_code) && !freq_nature.equals("O") ) { // Modified for SKR-SCF-1143 [IN:062004]
								unique_schedules	=	new ArrayList();
								tmp_drugs.add(fr_drug_code);
							}
							int fr_durn_value=0;

							if(durn_value!=null && (!(durn_value.equals("")))){
								fr_durn_value=Integer.parseInt(durn_value);
							}
							//ML-BRU-SCF-1966 -start
							repeat_durn_type = (String)insertRecords_8.get("REPEAT_DURN_TYPE")==null?"":(String)insertRecords_8.get("REPEAT_DURN_TYPE");
							if(freq_nature.equals("I") && repeat_durn_type.equals("M")){
								fr_durn_value=Integer.parseInt((String)insertRecords_8.get("DURN_VALUE")==null?"0":(String)insertRecords_8.get("DURN_VALUE"));
							}
						//ML-BRU-SCF-1966 -end
System.err.println("PrescriptionManager.java========fr_durn_value======3019====>"+fr_durn_value);
							chkValuescheduleFrequency=ScheduleFreq;
							//frequencyValues = new ArrayList();

							if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
								if(chkValuescheduleFrequency.containsKey(fr_drug_code+srl_no))
									frequencyValues = (ArrayList) chkValuescheduleFrequency.get(fr_drug_code+srl_no);
							}

	// Dosage Quantity Calculation starts
							dosage_type	=(String)insertRecords_8.get("DOSAGE_TYPE");
							qty_value		=(String)insertRecords_8.get("QTY_VALUE");
							qty_unit		=(String)insertRecords_8.get("QTY_DESC_CODE");
							repeat_value	=(String)insertRecords_8.get("REPEAT_VALUE");
							durn_value		=(String)insertRecords_8.get("DURN_VALUE");
							strength_value	=(String)insertRecords_8.get("ACT_STRENGTH_VALUE");
							strength_uom	=(String)insertRecords_8.get("STRENGTH_UOM");
							pres_base_uom	=(String)insertRecords_8.get("PRES_BASE_UOM");
							equal_value	=(String)insertRecords_8.get("EQUAL_VALUE");
							fract_dose		=(String)insertRecords_8.get("FRACT_DOSE_ROUND_UP_YN");
							strength_per_value_per_pres_uom	= (String)insertRecords_8.get("STRENGTH_PER_VALUE_PRES_UOM");
							strength_per_pres_uom				=	(String)insertRecords_8.get("STRENGTH_PER_PRES_UOM");
							content_in_pres_base_uom			= (String)insertRecords_8.get("CONTENT_IN_PRES_BASE_UOM");
							sliding_scale_yn = insertRecords_8.get("SLIDING_SCALE_YN")==null?"":(String)insertRecords_8.get("SLIDING_SCALE_YN");
							if(sliding_scale_yn==null)
								sliding_scale_yn	=	"";

							if(sliding_scale_yn.equals("Y")) 
								dosage_type	=	"S";

							//ArrayList schedule  = new ArrayList();
							//dose_list	= null;

							if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
								if(chkValuescheduleFrequency.containsKey((String)insertRecords_8.get("DRUG_CODE")+(String)insertRecords_8.get("SRL_NO")))
									schedule = (ArrayList) chkValuescheduleFrequency.get((String)insertRecords_8.get("DRUG_CODE")+(String)insertRecords_8.get("SRL_NO"));
							}
							
							if(schedule!=null && schedule.size() > 0){
								dose_list	= (ArrayList)schedule.get(4);
							}
							
//							 if(schedule.size() > 0 && !(((String)insertRecords_8.get("SPLIT_DOSE_YN")).equals("Y")) ) {
							 if(dose_list!=null && dose_list.size() > 0 && !(((String)insertRecords_8.get("SPLIT_DOSE_YN")).equals("Y")) ) {
//								 HashMap detail	=	(HashMap)schedule.get(0);
//								 qty_value		=	(String)detail.get("admin_qty");
								 qty_value		=	(String)dose_list.get(0);
//								 repeat_value	=	""+schedule.size();
								 repeat_value	=	""+dose_list.size();
							} 
							else if(dose_list!=null){
								tot_qty_value       = 0;
								for(int tqI=0;tqI<dose_list.size();tqI++){
									repeat_value	=	"1";
									tot_qty_value	=	tot_qty_value+Float.parseFloat((String)dose_list.get(tqI));
								}
								/*for(int n=0; n<schedule.size(); n++) {
									repeat_value		=	"1";
									HashMap  detail	=  (HashMap)schedule.get(n);
									tot_qty_value    =  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));
								}*/
								  qty_value       =tot_qty_value+"";
							}

						//	freq_nature		=	(String)insertRecords_8.get("FREQ_NATURE");  // Modified for SKR-SCF-1143 [IN:062004]
							interval_value	=	Integer.parseInt((String)insertRecords_8.get("INTERVAL_VALUE")==null?"1":(String)insertRecords_8.get("INTERVAL_VALUE"));

							if((dosage_type!=null && dosage_type.equals("A")) || (freq_nature!=null && freq_nature.equals("P"))){
								if(freq_nature!=null && freq_nature.equals("P")) {
									in_order_qty=(((String)insertRecords_8.get("ABSOL_QTY")==null)?((String)insertRecords_8.get("PRN_DOSES_PRES_PRD_FILL")):(String)insertRecords_8.get("ABSOL_QTY"));
									in_order_uom=qty_unit;
								}
								else {
									System.err.println("String)insertRecords_8.get(ABSOL_QTY)  :"+insertRecords_8.get("ABSOL_QTY"));
									//in_order_qty=(((String)insertRecords_8.get("ABSOL_QTY")==null)?"1":(String)insertRecords_8.get("ABSOL_QTY")); for kdah-scf-0388
									//added for kdah-scf-0388  start
									if(insertRecords_8.get("ABSOL_QTY")==null || ((String)insertRecords_8.get("ABSOL_QTY")).equals("0")) {
										in_order_qty="1";
									}else
									{
										in_order_qty=(String)insertRecords_8.get("ABSOL_QTY");
									}//  kdah-scf-0388  end
									in_order_uom=qty_unit;
								}
							}
							else if(dosage_type!=null && dosage_type.equals("Q")){
								//pstmt				= connection.prepareStatement(sql_ph_prescription_select53) ;
								equl_value	=	"1";

								pstmt_am_uom_eqvl.setString(1,pres_base_uom);
								pstmt_am_uom_eqvl.setString(2,qty_unit);
								pstmt_am_uom_eqvl.setString(3,pres_base_uom);
								pstmt_am_uom_eqvl.setString(4,qty_unit);
								resultSet	= pstmt_am_uom_eqvl.executeQuery();
								if ( resultSet != null && resultSet.next() ) {
									equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
								}
								closeResultSet( resultSet );

								if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
									if(!fract_dose.equals("Y")) {
										ord_qty		=	(Float.parseFloat(qty_value)*Float.parseFloat(equl_value));
										ord_qty		=	Float.parseFloat(Math.ceil(ord_qty/(Float.parseFloat(content_in_pres_base_uom)))+"");

										if(ord_qty==0)
											ord_qty	=	1;
									}
									else {
										if( (Float.parseFloat(qty_value)*Float.parseFloat(equl_value)) < Float.parseFloat(content_in_pres_base_uom)){
											tmp_qty	=	1+"";
										}
										else {
											if(Float.parseFloat(content_in_pres_base_uom)<1) //if block and else condition added for ML-BRU-SCF-1190 [IN:045647]
												tmp_qty	=  Math.ceil(Float.parseFloat(qty_value)/(Float.parseFloat(equl_value)*Float.parseFloat(content_in_pres_base_uom)))+"";
											else
												tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(equl_value))/Float.parseFloat(content_in_pres_base_uom))+"";
										}
										ord_qty		=  Float.parseFloat(tmp_qty)*Float.parseFloat(repeat_value)*Float.parseFloat(durn_value);
									}
								}

								if(freq_nature.equals("F")) {
									ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ interval_value)+"");
								}

								in_order_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
								in_order_uom=qty_unit;			

							}
							else if(dosage_type!=null && dosage_type.equals("S")){
								if( (qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))){	
									if(!fract_dose.equals("Y")) {	
										ord_qty		=((Float.parseFloat(qty_value)*Float.parseFloat(strength_per_value_per_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
										ord_qty		=new Double(Math.ceil(new Double(ord_qty/Float.parseFloat(content_in_pres_base_uom)).doubleValue())).floatValue();
									}
									else {
										// bellow if block and else condition added for SRR20056-SCF-7514	27576
										double unit_qty	= 1.0;
										float unit_dose_qty =(Float.parseFloat(strength_per_value_per_pres_uom) /Float.parseFloat(strength_per_pres_uom))*Float.parseFloat(qty_value);
										if(freq_nature.equals("O") || unit_dose_qty == Float.parseFloat(content_in_pres_base_uom) || (unit_dose_qty % Float.parseFloat(content_in_pres_base_uom)) == 0)
											unit_qty	=   Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom);	
										else
											unit_qty =   Math.ceil(Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom));	
										unit_qty = unit_qty * (Double.parseDouble(strength_per_value_per_pres_uom));
										tmp_qty			=  (Math.ceil(unit_qty/Float.parseFloat(content_in_pres_base_uom))+""); 
										ord_qty			=  (Float.parseFloat(tmp_qty));
									}

									if(freq_nature.equals("F")) {
										ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/interval_value)+"");
									}
								}
								in_order_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
								in_order_uom=pres_base_uom;
							}

							if(fr_durn_value!=0){
								dose_seq_no			=	1;
								schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)insertRecords_8.get("DRUG_CODE")+(String)insertRecords_8.get("SRL_NO")); //added +(String)insertRecords_8.get("SRL_NO") for IN24521 --18/10/2010-- priya


								if(frequencyValues != null && frequencyValues.size() > 0){
									freq_char_list	= (HashMap)frequencyValues.get(0);
									day_list		= (ArrayList)frequencyValues.get(1);
									day_names		= (ArrayList)frequencyValues.get(2);
									time_list		= (ArrayList)frequencyValues.get(3);
									dose_list		= (ArrayList)frequencyValues.get(4);

								/*	freq_char_list	= (HashMap)frequencyValues.get("freq_char_list");
									day_list		= (ArrayList)frequencyValues.get("day_list");
									day_names		= (ArrayList)frequencyValues.get("day_names");
									time_list		= (ArrayList)frequencyValues.get("time_list");
									dose_list		= (ArrayList)frequencyValues.get("dose_list");*/
								}

								for(int m=0;m<=fr_durn_value;m++){
									
									if((m != 0) && (interval_value > 1)){
											m = m+(int)(interval_value -1);
									}
									if(first_flag == false && interval_value>1 && ((String)insertRecords_8.get("FREQ_NATURE")).equals("F")){//Code added for IN24728 --20/11/2010-- priya // To make the schd time to start from immediate next day instead of next dose schd time for alt day freq if first day dose is lapsed 
										m =1;
									}

									if(freq_char_list != null && freq_char_list.size()>0){
										if(!freq_char_list.get("durationType").equals("D")){	
											tmp_sch_dt_tm.clear();
											int m1 = m;
											for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){
												if (m >= fr_durn_value) 
													m1 = 0;
												if(schd_date_time!=null){
													if((tmpSch+(m1*day_list.size())) < schd_date_time.size())
														tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m1*day_list.size())));
												}
											}
										}
									}
									//if(frequencyValues.size()>0 && !sliding_scale_yn.equals("Y")){
									if(day_list!=null && day_list.size()>0 && !sliding_scale_yn.equals("Y")){
										freq_values_found=true;
										//for(int n=0;n<frequencyValues.size();n++){
										for(int n=0;n<day_list.size();n++){
											freq_values_found	= true;
											int dosage_seqNo	=1;
											dosage_seqNo		= dosage_seqNo+n;
											admin_time			=(String)time_list.get(n);
											admin_qty			=(String)dose_list.get(n);
											sch_date_time		="";
											if(admin_time.equals("0") || admin_time.equals(""))
												admin_time= ord_date_time.substring(ord_date_time.indexOf(" "));
											admin_time=admin_time.trim();
										
											if(freq_char_list.get("durationType").equals("D")){
												pstmt_scheduled_date_time.setString(1,ord_date_time);
												pstmt_scheduled_date_time.setString(2,""+m);
												pstmt_scheduled_date_time.setString(3,admin_time);
												pstmt_scheduled_date_time.setString(4,ord_date_time);
												pstmt_scheduled_date_time.setString(5,""+m);
												pstmt_scheduled_date_time.setString(6,admin_time);
												pstmt_scheduled_date_time.setString(7,ord_date_time);
												pstmt_scheduled_date_time.setString(8,ord_end_date_time);

												resultSet		= pstmt_scheduled_date_time.executeQuery();
												if(resultSet!=null && resultSet.next()){
													sch_date_time=resultSet.getString(1);
													first_flag = true;
												}
												else
													first_flag = false;
												closeResultSet( resultSet );
											}
											else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("L"))){
												if(n < tmp_sch_dt_tm.size()){
													sch_date_time = (String)tmp_sch_dt_tm.get(n);
												}
											}
											if(!sch_date_time.equals("")&&(sch_date_time!=null)){
												/*dosage_type		= (String)insertRecords_8.get("DOSAGE_TYPE");
												qty_unit		= (String)insertRecords_8.get("QTY_DESC_CODE");
												strength_value	= (String)insertRecords_8.get("ACT_STRENGTH_VALUE");
												strength_uom	= (String)insertRecords_8.get("STRENGTH_UOM");
												pres_base_uom	= (String)insertRecords_8.get("PRES_BASE_UOM");
												equal_value		= (String)insertRecords_8.get("EQUAL_VALUE");*/
												equal_value		= "1";

												if(dosage_type!=null && dosage_type.equals("Q")){
													equal_value="1";
													pstmt_am_uom_eqvl.setString(1,pres_base_uom);
													pstmt_am_uom_eqvl.setString(2,qty_unit);
													pstmt_am_uom_eqvl.setString(3,pres_base_uom);
													pstmt_am_uom_eqvl.setString(4,qty_unit);
													resultSet	= pstmt_am_uom_eqvl.executeQuery();
													if ( resultSet != null && resultSet.next() ) {
														equal_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
													}
													closeResultSet( resultSet );
												}

												if(!unique_schedules.contains(sch_date_time)) {
													pstmt_insert.setString(1,facility_id);
													pstmt_insert.setString(2,encounter_id);
													pstmt_insert.setString(3,sch_date_time);
													pstmt_insert.setString(4,fr_drug_code);
													pstmt_insert.setString(5,""+(dosage_seqNo));
													pstmt_insert.setString(6,order_id);
													pstmt_insert.setString(7,""+(j+1));
													pstmt_insert.setString(8,patient_id);
													/*if( ((String)tabData.get("external_pres_flag")).equals("true")){ //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
														pstmt_insert.setString(9,login_by_id);
													}
													else{*/
														pstmt_insert.setString(9,ord_pract_id);
													//}
													
													pstmt_insert.setString(10,admin_qty);
													pstmt_insert.setString(11,qty_unit);
													
													sch_strength		=strength_value;
													sch_strength_uom	=strength_uom;

													if(dosage_type!=null && dosage_type.equals("S")){
														//sch_strength=strength_value; //Commented
														sch_strength = admin_qty;	// Added
													}
													else if(!admin_qty.equals("") && !strength_value.equals("") && !equal_value.equals("")) {
														tot_strn=(Float.parseFloat(admin_qty))*(Float.parseFloat(strength_value))*(Float.parseFloat(equal_value));
														sch_strength=String.valueOf(tot_strn);
														if(sch_strength.length()>11){
															sch_strength=sch_strength.substring(0,11);
														}
													} 
													else {
														sch_strength	=	qty_value;
													}

													pstmt_insert.setString(12,sch_strength);
													pstmt_insert.setString(13,sch_strength_uom);
													pstmt_insert.setString(14,(String)insertRecords_8.get("ROUTE_CODE"));
													pstmt_insert.setString(15,login_by_id);
													pstmt_insert.setString(16,login_at_ws_no);
													pstmt_insert.setString(17,login_facility_id);
													pstmt_insert.setString(18,login_by_id);
													pstmt_insert.setString(19,login_at_ws_no);
													pstmt_insert.setString(20,login_facility_id);
													pstmt_insert.setString(21,verf_reqd_bef_med_admin_yn);
													pstmt_insert.setString(22,"N");
													pstmt_insert.setString(23,sliding_scale_yn);
													pstmt_insert.setString(24,MAR_barcode_id);	//added for  MMS-QH-CRF-0080 [IN:038064]
													pstmt_insert.addBatch();
													unique_schedules.add(sch_date_time);
												 }
											}
										}//freq
									}
									else if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y") && !((String)insertRecords_8.get("FREQ_NATURE")).equals("O") && !((String)insertRecords_8.get("FREQ_NATURE")).equals("P")){
										//for(int n=0;n<frequencyValues.size();n++){
										for(int n=0;n<day_list.size();n++){
											//data=(HashMap)frequencyValues.get(n);
											//admin_time	=(String)data.get("admin_time");
											admin_time			=(String)time_list.get(n);
											sch_date_time="";

											if(freq_char_list.get("durationType").equals("D")){
												pstmt_scheduled_date_time.setString(1,ord_date_time);
												pstmt_scheduled_date_time.setString(2,""+m);
												pstmt_scheduled_date_time.setString(3,admin_time);
												pstmt_scheduled_date_time.setString(4,ord_date_time);
												pstmt_scheduled_date_time.setString(5,""+m);
												pstmt_scheduled_date_time.setString(6,admin_time);
												pstmt_scheduled_date_time.setString(7,ord_date_time);
												pstmt_scheduled_date_time.setString(8,ord_end_date_time);
										
												resultSet		= pstmt_scheduled_date_time.executeQuery();
												if(resultSet!=null && resultSet.next()){
													sch_date_time=resultSet.getString(1);
													first_flag = true;
												}
												else
													first_flag = false;
												closeResultSet( resultSet );
											}
											else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("L"))){
												if(n < tmp_sch_dt_tm.size()) //conditon added during IN21609 --07/06/2010 -- priya
													sch_date_time = (String)tmp_sch_dt_tm.get(n);				
											}
											
											if(!sch_date_time.equals("")&&(sch_date_time!=null)){
												if(!unique_schedules.contains(sch_date_time)) {
													 qty_value		=(String)insertRecords_8.get("QTY_VALUE");
													 strength_value	=(String)insertRecords_8.get("ACT_STRENGTH_VALUE");

													sch_strength		=qty_value;
													if(sliding_scale_yn.equals("Y"))
														sch_strength		=strength_value;
													sch_strength_uom	=(String)insertRecords_8.get("STRENGTH_UOM");

													in_order_qty	=	qty_value;
													in_order_uom	=	sch_strength_uom;

													pstmt_insert.setString(1,facility_id);
													pstmt_insert.setString(2,encounter_id);
													pstmt_insert.setString(3,sch_date_time);
													pstmt_insert.setString(4,fr_drug_code);
													pstmt_insert.setString(5,"1");
													pstmt_insert.setString(6,order_id);
													pstmt_insert.setString(7,""+(j+1));
													pstmt_insert.setString(8,patient_id);
													/*if( ((String)tabData.get("external_pres_flag")).equals("true")){ //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
														pstmt_insert.setString(9,login_by_id);
													}
													else{*/
														pstmt_insert.setString(9,ord_pract_id);
													//}
													System.err.println("in_order_qty3357 for KDAH-SCF-0388===="+in_order_qty);
													pstmt_insert.setString(10,in_order_qty);
													pstmt_insert.setString(11,in_order_uom);
													pstmt_insert.setString(12,sch_strength);
													pstmt_insert.setString(13,sch_strength_uom);
													pstmt_insert.setString(14,(String)insertRecords_8.get("ROUTE_CODE"));
													pstmt_insert.setString(15,login_by_id);
													pstmt_insert.setString(16,login_at_ws_no);
													pstmt_insert.setString(17,login_facility_id);
													pstmt_insert.setString(18,login_by_id);
													pstmt_insert.setString(19,login_at_ws_no);
													pstmt_insert.setString(20,login_facility_id);
													pstmt_insert.setString(21,"N");
													pstmt_insert.setString(22,"N");
													pstmt_insert.setString(23,sliding_scale_yn);
													pstmt_insert.setString(24,MAR_barcode_id);	//added for  MMS-QH-CRF-0080 [IN:038064]
													pstmt_insert.addBatch();
													unique_schedules.add(sch_date_time);
												 }
											}
										}
									}									
									else if(((String)insertRecords_8.get("FREQ_NATURE")).equals("O") || ((String)insertRecords_8.get("FREQ_NATURE")).equals("P")){
										if(!stat_time.contains(stat_sch_time)) {
											contains_stat		=	true;
											dosage_type		=(String)insertRecords_8.get("DOSAGE_TYPE");
											qty_unit			=(String)insertRecords_8.get("QTY_DESC_CODE");
											strength_value		=(String)insertRecords_8.get("ACT_STRENGTH_VALUE");
											strength_uom		=(String)insertRecords_8.get("STRENGTH_UOM");
											pres_base_uom		=(String)insertRecords_8.get("PRES_BASE_UOM");
											equal_value		=(String)insertRecords_8.get("EQUAL_VALUE");
											equal_value		= "1";
											stkuom			=	"";
											//pstmt		= connection.prepareStatement(sql_ph_prescription_select64) ;		
											pstmt_ph_drug_vw.setString(1,dosage_type);
											pstmt_ph_drug_vw.setString(2,in_order_qty);
											pstmt_ph_drug_vw.setString(3,in_order_qty);
											pstmt_ph_drug_vw.setString(4,drug_code);
											pstmt_ph_drug_vw.setString(5, language_id);
											pstmt_ph_drug_vw.setString(6, language_id);
											pstmt_ph_drug_vw.setString(7, language_id);
											pstmt_ph_drug_vw.setString(8, language_id);
											pstmt_ph_drug_vw.setString(9, language_id);

											resultSet=pstmt_ph_drug_vw.executeQuery();
											if (resultSet.next())	{
												stkuom	=	(String)resultSet.getString("stock_uom");
												if (stkuom!=null && !stkuom.equals(""))	{
														in_order_uom	=	stkuom;
												}
											}
											closeResultSet( resultSet );
											if(((String)insertRecords_8.get("FREQ_NATURE")).equals("O")) {
												dose_seq_no	=	1;
												 in_order_qty		=(String)insertRecords_8.get("QTY_VALUE");
												 in_order_uom		=(String)insertRecords_8.get("QTY_DESC_CODE");
											} 
											else {
												if(!stat_dtls.contains(order_id) || !stat_dtls.contains(fr_drug_code)) {
													dose_seq_no		=	2;
													stat_dtls.add(order_id);
													stat_dtls.add(fr_drug_code);
												} 
												else {
													dose_seq_no++;
												}
											}
											if(dosage_type!=null && dosage_type.equals("Q")){
												equal_value="1";
												pstmt_am_uom_eqvl.setString(1,pres_base_uom);
												pstmt_am_uom_eqvl.setString(2,qty_unit);
												pstmt_am_uom_eqvl.setString(3,pres_base_uom);
												pstmt_am_uom_eqvl.setString(4,qty_unit);
												resultSet	= pstmt_am_uom_eqvl.executeQuery();
												if ( resultSet != null && resultSet.next() ) {
													equal_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
												}
												closeResultSet( resultSet );
											}

											if(((String)insertRecords_8.get("FREQ_NATURE")).equals("O")) {
												stat_sch_time = (String)insertRecords_8.get("START_DATE");
											} 
											else {
												if(stat_dtls.contains(fr_drug_code)) {
													if(stat_sch_time.equals("")) {
														stat_sch_time	=	(String)insertRecords_8.get("START_DATE");
													}
													else {
														stat_sch_time	= getNextSchDateTime(connection,stat_sch_time,SQL_PH_SLIDING_SCALE_SELECT5);
													}
												} 
												else {
													stat_sch_time = (String)insertRecords_8.get("START_DATE");
												}
												in_order_uom =(String)insertRecords_8.get("STOCK_UOM");
											}
											pstmt_insert.setString(1,facility_id);
											pstmt_insert.setString(2,encounter_id);
											pstmt_insert.setString(3,stat_sch_time);
											pstmt_insert.setString(4,fr_drug_code);
											pstmt_insert.setString(5,(dose_seq_no)+"");
											pstmt_insert.setString(6,order_id);
											pstmt_insert.setString(7,""+(j+1));
											pstmt_insert.setString(8,patient_id);
											/*if( ((String)tabData.get("external_pres_flag")).equals("true")){ //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
												pstmt_insert.setString(9,login_by_id);
											}
											else{*/
												pstmt_insert.setString(9,ord_pract_id);
											//}
											//pstmt_insert.setString(9,ord_pract_id);
											
												pstmt_insert.setString(10,in_order_qty);
												pstmt_insert.setString(11,in_order_uom);
											
											sch_strength		=strength_value;
											sch_strength_uom	=strength_uom;
											if(dosage_type!=null && dosage_type.equals("S")){
												//sch_strength=strength_value;Commented for SKR-SCF-1010
												if(((String)insertRecords_8.get("FREQ_NATURE")).equals("P")){//Added if and else for SKR-SCF-1010
													sch_strength=(String)insertRecords_8.get("QTY_VALUE");
												}
												else{
													sch_strength=strength_value;
												}
											}
											else{
												//tot_strn=(Float.parseFloat(in_order_qty))*(Float.parseFloat(strength_value))*(Float.parseFloat(equal_value));Commented for SKR-SCF-1010
												//sch_strength=String.valueOf(tot_strn);Commented for SKR-SCF-1010
												if(((String)insertRecords_8.get("FREQ_NATURE")).equals("P") && dosage_type!=null && (dosage_type.equals("Q") || dosage_type.equals("A"))){//Added if and else for SKR-SCF-1010
													sch_strength=(String)insertRecords_8.get("QTY_VALUE");
													sch_strength_uom=(String)insertRecords_8.get("QTY_UOM");
												}
												else{
													tot_strn=(Float.parseFloat(in_order_qty))*(Float.parseFloat(strength_value))*(Float.parseFloat(equal_value));
													sch_strength=String.valueOf(tot_strn);
												}
												if(sch_strength.length()>11){
													sch_strength=sch_strength.substring(0,11);
												}
											}
											pstmt_insert.setString(12,sch_strength);
											pstmt_insert.setString(13,sch_strength_uom);
											pstmt_insert.setString(14,(String)insertRecords_8.get("ROUTE_CODE"));
											pstmt_insert.setString(15,login_by_id);
											pstmt_insert.setString(16,login_at_ws_no);
											pstmt_insert.setString(17,login_facility_id);
											pstmt_insert.setString(18,login_by_id);
											pstmt_insert.setString(19,login_at_ws_no);
											pstmt_insert.setString(20,login_facility_id);
											pstmt_insert.setString(21,verf_reqd_bef_med_admin_yn);
											pstmt_insert.setString(22,"N");
											pstmt_insert.setString(23,sliding_scale_yn);
											pstmt_insert.setString(24,MAR_barcode_id);	//added for  MMS-QH-CRF-0080 [IN:038064]
											pstmt_insert.addBatch();
											stat_time.add(stat_sch_time);
										}
									}
									else if(((String)insertRecords_8.get("FREQ_NATURE")).equals("I")){
									    freq_values_found = true;									 
										String tmp_sch_dt = "";
										int	dosage_seqNo = 1;
										//HashMap sched_date_time_wkhr = (HashMap)tabData.get("sched_date_time_wkhr");
										//ArrayList schedDateTimesWkHr = (ArrayList)sched_date_time_wkhr.get(fr_drug_code);
											sch_date_time="";
										if(schd_date_time != null && schd_date_time.size()>0){
											for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
												sch_date_time = (String)schd_date_time.get(scdDt);
												if(tmp_sch_dt.equals(sch_date_time.substring(0,10))){
													dosage_seqNo++;
												}else{
													dosage_seqNo = 1;
												}
												tmp_sch_dt    = sch_date_time.substring(0,10);

												if(sch_date_time!=null && !sch_date_time.equals("")){
													dosage_type		=(String)insertRecords_8.get("DOSAGE_TYPE");
													qty_unit		=(String)insertRecords_8.get("QTY_DESC_CODE");
													strength_value	=(String)insertRecords_8.get("ACT_STRENGTH_VALUE");
													strength_uom	=(String)insertRecords_8.get("STRENGTH_UOM");
													pres_base_uom	=(String)insertRecords_8.get("PRES_BASE_UOM");
													equal_value		=(String)insertRecords_8.get("EQUAL_VALUE");
													equal_value		="1";
													qty_value		=(String)insertRecords_8.get("QTY_VALUE");
													if(dosage_type!=null && dosage_type.equals("Q")){
														//pstmt				= connection.prepareStatement(sql_ph_prescription_select53) ;
														//pstmt_am_uom_eqvl	= connection.prepareStatement(sql_ph_prescription_select53) ;
														equal_value="1";
														pstmt_am_uom_eqvl.setString(1,pres_base_uom);
														pstmt_am_uom_eqvl.setString(2,qty_unit);
														pstmt_am_uom_eqvl.setString(3,pres_base_uom);
														pstmt_am_uom_eqvl.setString(4,qty_unit);
														resultSet	= pstmt_am_uom_eqvl.executeQuery();
														if ( resultSet != null && resultSet.next() ) {
															equal_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
														}
														closeResultSet( resultSet );
													}
													if(!unique_schedules.contains(sch_date_time)) {
														pstmt_insert.setString(1,facility_id);
														pstmt_insert.setString(2,encounter_id);
														pstmt_insert.setString(3,sch_date_time);
														pstmt_insert.setString(4,fr_drug_code);
														pstmt_insert.setString(5,""+(dosage_seqNo));
														//pstmt_insert.setString(5,"1");
														pstmt_insert.setString(6,order_id);
														pstmt_insert.setString(7,""+(j+1));
														pstmt_insert.setString(8,patient_id);
														/*if( ((String)tabData.get("external_pres_flag")).equals("true")){ //Commented for inserting ORD_PRACT_ID instead of login_by_id for ORA-12899: value too large for column "IBAEHIS"."OR_ORDER_LINE"."ORD_PRACT_ID" mail 31-07-12 02:35 PM
															pstmt_insert.setString(9,login_by_id);
														}
														else{*/
															pstmt_insert.setString(9,ord_pract_id);
														//}
														pstmt_insert.setString(10,qty_value);
														pstmt_insert.setString(11,qty_unit);

														sch_strength		=strength_value;
														sch_strength_uom	=strength_uom;
                                                        
														if(dosage_type!=null && dosage_type.equals("S")){
															sch_strength=strength_value;
														}
														else if(admin_qty!=null && !admin_qty.equals("") && !strength_value.equals("") && !equal_value.equals("")) {
															tot_strn=(Float.parseFloat(admin_qty))*(Float.parseFloat(strength_value))*(Float.parseFloat(equal_value));
															sch_strength=String.valueOf(tot_strn);
															if(sch_strength.length()>11){
																sch_strength=sch_strength.substring(0,11);
															}
														} 
														else {
															sch_strength	=	qty_value;
														}
														pstmt_insert.setString(12,sch_strength);
														pstmt_insert.setString(13,sch_strength_uom);
														pstmt_insert.setString(14,(String)insertRecords_8.get("ROUTE_CODE"));
														pstmt_insert.setString(15,login_by_id);
														pstmt_insert.setString(16,login_at_ws_no);
														pstmt_insert.setString(17,login_facility_id);
														pstmt_insert.setString(18,login_by_id);
														pstmt_insert.setString(19,login_at_ws_no);
														pstmt_insert.setString(20,login_facility_id);
														pstmt_insert.setString(21,verf_reqd_bef_med_admin_yn);
														pstmt_insert.setString(22,"N");
														pstmt_insert.setString(23,sliding_scale_yn);
														pstmt_insert.setString(24,MAR_barcode_id); //added for  MMS-QH-CRF-0080 [IN:038064]
														pstmt_insert.addBatch();
														unique_schedules.add(sch_date_time);
													 }
												}
											}
										}
									}
								}//durn
							}
						}
					}//details
					closeResultSet( resultSet );
					closeStatement( pstmt_am_uom_eqvl) ;
					closeStatement( pstmt_scheduled_date_time) ;
					closeStatement( pstmt_ph_drug_vw) ;
				}//order id

				if( freq_values_found || contains_stat || (sliding_scale_yn!=null && sliding_scale_yn.equals("Y"))) {
					int[] result_insert_8= pstmt_insert.executeBatch();
					closeStatement( pstmt_insert) ;
					for (int i=0;i<result_insert_8.length ;i++ ){
						if(result_insert_8[i]<0  && result_insert_8[i] != -2 ){
							System.err.println("NORMAL RX--> ERROR IN INSERTING PH_MEDN_ADMIN  result_insert_8["+i+"]= "+result_insert_8[i]);
							System.err.println("tabData=== "+tabData);
							insert_rec_9=false;
							break;
						}
						else{
							insert_rec_9=true;
						}
					}
				}
			}
//// insert into OR_ORDER_LINE_PH_SLD_SCALE starts
		if(insert_rec_9) {
			//String order_id		=	null;
			found = false;
			//ArrayList headerList	=	null;
			//HashMap insertRecords_2	=	null;
			boolean insert_rec_sld = true;
			pstmt_insert			= connection.prepareStatement(SQL_PH_PRESCRIPTION_INSERT_SLD_SCALE) ;
			ArrayList sldscale_tmpl_dtl = null;
			for(int i=0;i<OrderID.size();i++){
				order_id	= (String) OrderID.get(i);
				headerList	= (ArrayList) OrderDetails.get(i);
				//1.0, 0.0, 150.0, 0.0, Remarks1
				for(int j=0;j<headerList.size();j++){   
					insertRecords_2=(HashMap) headerList.get(j);

					String sliding_scale_yn =(String) insertRecords_2.get("SLIDING_SCALE_YN");
					if(insertRecords_2.get("SLDSCALE_TMPL_DTL") != null && ((ArrayList)(insertRecords_2.get("SLDSCALE_TMPL_DTL"))).size() > 0 && sliding_scale_yn.equals("Y")){
						sldscale_tmpl_dtl = (ArrayList)(insertRecords_2.get("SLDSCALE_TMPL_DTL"));
						for(int k=0; k<sldscale_tmpl_dtl.size(); k=k+5){
							pstmt_insert.setString(1,order_id); //ORDER_ID
							pstmt_insert.setString(2,""+(j+1)); //ORDER_LINE_NUM
							pstmt_insert.setString(3,(String)insertRecords_2.get("TEMPLATE_ID")); //TEMPLATE_ID
							pstmt_insert.setString(4,(String)sldscale_tmpl_dtl.get(k)); //SRL_NO
							pstmt_insert.setString(5,(String)sldscale_tmpl_dtl.get(k+1)); //RANGE_FROM
							pstmt_insert.setString(6,(String)sldscale_tmpl_dtl.get(k+2)); //RANGE_TO
							pstmt_insert.setString(7,(String)sldscale_tmpl_dtl.get(k+3)); //ADMIN_UNITS
							pstmt_insert.setString(8,(String)sldscale_tmpl_dtl.get(k+4)); //REMARKS
							pstmt_insert.setString(9,login_by_id); //ADDED_BY_ID
							pstmt_insert.setString(10,login_at_ws_no); //ADDED_AT_WS_NO
							pstmt_insert.setString(11,login_facility_id); //ADDED_FACILITY_ID
							pstmt_insert.setString(12,login_by_id); //MODIFIED_BY_ID
							pstmt_insert.setString(13,login_at_ws_no); //MODIFIED_AT_WS_NO
							pstmt_insert.setString(14,login_facility_id); //MODIFIED_FACILITY_ID
							pstmt_insert.addBatch();
							found = true;
						}
					}
				}
			}

			if(found){
				int[] result_insert_slide_tmpl= pstmt_insert.executeBatch();
				closeStatement( pstmt_insert) ;
				for (int i=0;i<result_insert_slide_tmpl.length ;i++ ){
					if(result_insert_slide_tmpl[i]<0  && result_insert_slide_tmpl[i] != -2 ){
						System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER_LINE_PH_SLD_SCALE result_insert_slide_tmpl["+i+"]= "+result_insert_slide_tmpl[i]);
						System.err.println("tabData=== "+tabData);
						insert_rec_sld=false;
						break;
					}
					else{
						insert_rec_sld=true;
					}
				}
			}
			
		}
// insert into OR_ORDER_LINE_PH_SLD_SCALE ends
	//code added for prescription work load.....on 25/4/2004 by senthil kumar

			int totalOrder	=	1;
			//int totalOrder	=	OrderID.size();
			int totalDrugs	=	0;
		
			for(int q=0; q<OrderDetails.size(); q++) {
				totalDrugs	+= ((ArrayList)OrderDetails.get(q)).size();
			}

			for (int i=0;i<OrderHeader.size() ;i++ ){
				insertRecords=(HashMap)OrderHeader.get(i);
				worloadDate=(String)insertRecords.get("ORDER_DATE_TIME");
				patient_Class=(String)insertRecords.get("PATIENT_CLASS");
			}
			
			pstmt_workload		= connection.prepareStatement(sql_ph_prescription_select72) ;
			pstmt_workload.setString(1,practId);
			pstmt_workload.setString(2,login_facility_id);
			pstmt_workload.setString(3,patient_Class);
			resultSet_workload  	= pstmt_workload.executeQuery() ;

			while (resultSet_workload.next()){
				dly_count		= (resultSet_workload.getString("DLYCOUNT")).trim();				
			}
			closeResultSet( resultSet_workload );
			closeStatement( pstmt_workload) ;

			pstmt_workload		= connection.prepareStatement(sql_ph_prescription_select73) ;
			pstmt_workload.setString(1,practId);
			pstmt_workload.setString(2,login_facility_id);
			pstmt_workload.setString(3,patient_Class);

			resultSet_workload  	= pstmt_workload.executeQuery() ;
			while (resultSet_workload.next()){
				monthly_count			=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
			}
			closeResultSet( resultSet_workload );
			closeStatement( pstmt_workload) ;
	
//INSERTING/UPDATING INTO PH_DLY_DO_WORKLOAD
			if(dly_count.equals("0")){
				workload_insert		= connection.prepareStatement(sql_ph_prescription_insert9) ;
				workload_insert.setString( 1, practId);
				workload_insert.setString( 2, login_facility_id);
				workload_insert.setString( 3, patient_Class);
				workload_insert.setString( 4,String.valueOf(totalOrder));
				workload_insert.setString( 5,String.valueOf(totalDrugs));
				workload_insert.setString( 6, login_by_id);
				workload_insert.setString( 7, login_at_ws_no);
				workload_insert.setString( 8, login_facility_id);
				workload_insert.setString( 9, login_by_id);
				workload_insert.setString( 10, login_at_ws_no);
				workload_insert.setString( 11, login_facility_id);
				workload_insert.executeUpdate();
				closeStatement( workload_insert) ;
			}
			else{
				workload_insert		= connection.prepareStatement(sql_ph_prescription_modify6) ;
				workload_insert.setString( 1,String.valueOf(totalOrder));
				workload_insert.setString( 2,String.valueOf(totalDrugs));
				workload_insert.setString( 3, login_by_id);
				workload_insert.setString( 4, login_at_ws_no);
				workload_insert.setString( 5, login_facility_id);
				workload_insert.setString( 6, practId);
				workload_insert.setString( 7, login_facility_id);
				workload_insert.setString( 8, patient_Class);
				workload_insert.executeUpdate();
				closeStatement( workload_insert) ;
			}

//INSERTING/UPDATING INTO PH_MTHLY_DO_WORKLOAD
			if(monthly_count.equals("0")){
				work_insert_month		= connection.prepareStatement(sql_ph_prescription_insert10) ;
				work_insert_month.setString( 1, practId);
				work_insert_month.setString( 2, login_facility_id);
				work_insert_month.setString( 3, patient_Class);
				work_insert_month.setString( 4,String.valueOf(totalOrder));
				work_insert_month.setString( 5,String.valueOf(totalDrugs));
				work_insert_month.setString( 6, login_by_id);
				work_insert_month.setString( 7, login_at_ws_no);
				work_insert_month.setString( 8, login_facility_id);
				work_insert_month.setString( 9, login_by_id);
				work_insert_month.setString( 10, login_at_ws_no);
				work_insert_month.setString( 11, login_facility_id);
				work_insert_month.executeUpdate();
				closeStatement( work_insert_month) ;
			}
			else{
				work_insert_month		= connection.prepareStatement(sql_ph_prescription_modify7) ;
				work_insert_month.setString( 1,String.valueOf(totalOrder));
				work_insert_month.setString( 2,String.valueOf(totalDrugs));
				work_insert_month.setString( 3, login_by_id);
				work_insert_month.setString( 4, login_at_ws_no);
				work_insert_month.setString( 5, login_facility_id);
				work_insert_month.setString( 6, practId);
				work_insert_month.setString( 7, login_facility_id);
				work_insert_month.setString( 8, patient_Class);
				work_insert_month.executeUpdate();
				closeStatement( work_insert_month) ;
			}
			pstmt_workload			= connection.prepareStatement(sql_ph_prescription_select74) ;
			pstmt_workload.setString(1,locationType);
			pstmt_workload.setString(2,login_facility_id);
			pstmt_workload.setString(3,locationCode);
			resultSet_workload  	= pstmt_workload.executeQuery() ;

			while (resultSet_workload.next()){
				dly_count_loc	= (resultSet_workload.getString("DLYCOUNT")).trim();				
			}
			closeResultSet( resultSet_workload) ;
			closeStatement( pstmt_workload) ;

			pstmt_workload			= connection.prepareStatement(sql_ph_prescription_select75) ;
			pstmt_workload.setString(1,locationType);
			pstmt_workload.setString(2,login_facility_id);
			pstmt_workload.setString(3,locationCode);

			resultSet_workload  	= pstmt_workload.executeQuery() ;
			while (resultSet_workload.next()){
				monthly_count_loc		=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
			}
			closeResultSet( resultSet_workload) ;
			closeStatement( pstmt_workload) ;

//INSERTING/UPDATING INTO PH_DLY_LOC_WORKLOAD
			if(dly_count_loc.equals("0")){
				work_insert_loc = connection.prepareStatement(sql_ph_prescription_insert11) ;
				work_insert_loc.setString(1,login_facility_id);
				work_insert_loc.setString(2, locationType);
				work_insert_loc.setString(3, locationCode);
				work_insert_loc.setString(4,String.valueOf(totalOrder));
				work_insert_loc.setString(5,String.valueOf(totalDrugs));
				work_insert_loc.setString(6, login_by_id);
				work_insert_loc.setString(7, login_at_ws_no);
				work_insert_loc.setString(8, login_facility_id);
				work_insert_loc.setString(9, login_by_id);
				work_insert_loc.setString(10, login_at_ws_no);
				work_insert_loc.setString(11, login_facility_id);
				work_insert_loc.executeUpdate();
				closeStatement( work_insert_loc) ;
			}
			else{
				work_insert_loc = connection.prepareStatement(sql_ph_prescription_modify8) ;
				work_insert_loc.setString(1,String.valueOf(totalOrder));
				work_insert_loc.setString(2,String.valueOf(totalDrugs));
				work_insert_loc.setString(3, login_by_id);
				work_insert_loc.setString(4, login_at_ws_no);
				work_insert_loc.setString(5, login_facility_id);
				work_insert_loc.setString(6, locationType);
				work_insert_loc.setString(7, login_facility_id);
				work_insert_loc.setString(8, locationCode);
				work_insert_loc.executeUpdate();
				closeStatement( work_insert_loc) ;
			}

//INSERTING/UPDATING INTO PH_MTHLY_LOC_WORKLOAD
			if(monthly_count_loc.equals("0")){
				work_insert_loc_mon =  connection.prepareStatement(sql_ph_prescription_insert12) ;
				work_insert_loc_mon.setString(1,login_facility_id);
				work_insert_loc_mon.setString(2, locationType);
				work_insert_loc_mon.setString(3, locationCode);
				work_insert_loc_mon.setString(4,String.valueOf(totalOrder));
				work_insert_loc_mon.setString(5,String.valueOf(totalDrugs));
				work_insert_loc_mon.setString(6, login_by_id);
				work_insert_loc_mon.setString(7, login_at_ws_no);
				work_insert_loc_mon.setString(8, login_facility_id);
				work_insert_loc_mon.setString(9, login_by_id);
				work_insert_loc_mon.setString(10, login_at_ws_no);
				work_insert_loc_mon.setString(11, login_facility_id);
				work_insert_loc_mon.executeUpdate();
				closeStatement( work_insert_loc_mon) ;
			}
			else{
				work_insert_loc_mon =  connection.prepareStatement(sql_ph_prescription_modify9) ;
				work_insert_loc_mon.setString(1,String.valueOf(totalOrder));
				work_insert_loc_mon.setString(2,String.valueOf(totalDrugs));
				work_insert_loc_mon.setString(3, login_by_id);
				work_insert_loc_mon.setString(4, login_at_ws_no);
				work_insert_loc_mon.setString(5, login_facility_id);
				work_insert_loc_mon.setString(6, locationType);
				work_insert_loc_mon.setString(7, login_facility_id);
				work_insert_loc_mon.setString(8, locationCode);
				work_insert_loc_mon.executeUpdate();
				closeStatement( work_insert_loc) ;
			}

//MMS-KH-CRF-0034.4 - start
			ArrayList hmDrugIntList = null;
			HashMap DrugInteractionDtl=null;
			String interaction_type = "";
			String return_flag_yn   = "";
			String order_line_no = "";
			String order_catalog_code = "";
			String test_result_value  = "";
			boolean flag_found = false;
			pstmt_insert			= connection.prepareStatement("INSERT INTO OR_ORDER_DRUG_INTERACTION (ORDER_ID,ORDER_LINE_NUM, ORDER_CATALOG_CODE, DRUG_INTERACTION_CODE, ORDERING_MODULE_ID, INTERACTION_STATUS, OVERRIDE_REASON,LAB_TEST_RESULT, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
			for(int i=0;i<OrderID.size();i++){
				order_id	= (String) OrderID.get(i);
				headerList	= (ArrayList) OrderDetails.get(i);

				for(int j=0;j<headerList.size();j++){   
					insertRecords_2=(HashMap) headerList.get(j);

					order_line_no=(j+1)+""; //ORDER_LINE_NUM
					
					hmDrugIntList =(ArrayList)insertRecords_2.get("INTERACTION_DTL");
					drug_code= (String)insertRecords_2.get("DRUG_CODE");

				 if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
						for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
							DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
							interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2"); 
							if(interaction_type==null)
								interaction_type = "";
							if(interaction_type.equals("L")){

							order_catalog_code = (String)DrugInteractionDtl.get("intr_code"); 
							return_flag_yn = (String)DrugInteractionDtl.get("return_flag_yn"); 
							test_result_value = (String)DrugInteractionDtl.get("test_result_value"); 



							pstmt_insert.setString(1,order_id); //ORDER_ID
							pstmt_insert.setString(2,order_line_no); //ORDER_LINE_NUM
							pstmt_insert.setString(3,order_catalog_code); 
							pstmt_insert.setString(4,drug_code); 
							pstmt_insert.setString(5,"PH"); 
							pstmt_insert.setString(6,"N"); 
							pstmt_insert.setString(7,""); 
							pstmt_insert.setString(8,test_result_value);
							pstmt_insert.setString(9,login_by_id); //ADDED_BY_ID
							pstmt_insert.setString(10,login_at_ws_no); //ADDED_AT_WS_NO
							pstmt_insert.setString(11,login_facility_id); //ADDED_FACILITY_ID
							pstmt_insert.setString(12,login_by_id); //MODIFIED_BY_ID
							pstmt_insert.setString(13,login_at_ws_no); //MODIFIED_AT_WS_NO
							pstmt_insert.setString(14,login_facility_id); //MODIFIED_FACILITY_ID
							pstmt_insert.addBatch();
							flag_found = true;
							}
							

						}
				 }
				}
				
			}
			if(flag_found){
				int[] drug_inter= pstmt_insert.executeBatch();
				closeStatement( pstmt_insert) ;
				for (int i=0;i<drug_inter.length ;i++ ){
					if(drug_inter[i]<0  && drug_inter[i] != -2 ){
						System.err.println("NORMAL RX--> ERROR IN INSERTING OR_ORDER_LINE_PH_SLD_SCALE drug_inter["+i+"]= "+drug_inter[i]);
						System.err.println("tabData=== "+tabData);
						break;
					}
					
				}
			}
//MMS-KH-CRF-0034.4 - end

			String auto_order_regn_err = "";
			String tokens_generated_yn = "";

			if(consumable_tabData!=null && consumable_tabData.size()>0 && consumable_sqlMap!=null && consumable_sqlMap.size()>0){
				consumable_tabData.put("trn_group_ref",trn_group_ref);
				consumable_insert = insertPresItemList(connection,consumable_tabData,consumable_sqlMap);
			}
			
			if(patientClass.equals("OP") && tabData.get("AmendAlternateDrug").equals("Y"))//added for JD-CRF-0198 start
			{
				String token_serial_no = "", token_series_code = "",queue_date = "";
				pstmt = connection.prepareStatement("select queue_date,token_series_code,token_serial_no from ph_ord_for_disp_queue where order_id=? and facility_id=? and disp_locn_code=? and patient_id=? ");
				pstmt.setString(1, (String)tempHeader.get("ORG_ORDER_ID")==null?"":(String)tempHeader.get("ORG_ORDER_ID"));
				pstmt.setString(2, facility_id);
				pstmt.setString(3, (String)insertRecords.get("DISP_LOCN_CODE"));
				pstmt.setString(4, patient_id);
				resultSet = pstmt.executeQuery();
				if(resultSet != null && resultSet.next()){
					queue_date = resultSet.getString("queue_date");
					token_series_code = resultSet.getString("token_series_code");
					token_serial_no = resultSet.getString("token_serial_no");
				}
				closeStatement(pstmt);
				closeResultSet(resultSet);
				found= false;
				if(!token_serial_no.equals("")&&!token_serial_no.equals(null)){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
					java.util.Date date_queue = formatter.parse(queue_date);
					queue_date = formatter.format(date_queue);
				pstmt_insert = connection.prepareStatement("INSERT INTO PH_ORD_FOR_DISP_QUEUE (FACILITY_ID,DISP_LOCN_CODE, QUEUE_DATE, QUEUE_SHIFT, TOKEN_SERIES_CODE, TOKEN_SERIAL_NO, ORDER_ID, PATIENT_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,to_date('"+queue_date+"','yyyy-mm-dd'),'*ALL',?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
				pstmt_insert.setString(1,login_facility_id.trim());
				pstmt_insert.setString(2, (String)insertRecords.get("DISP_LOCN_CODE"));
				pstmt_insert.setString(3,token_series_code.trim());
				pstmt_insert.setString(4,token_serial_no.trim());
				pstmt_insert.setString(5,(String)insertRecords.get("ORDER_ID"));
				pstmt_insert.setString(6, patient_id);
				pstmt_insert.setString(7,login_by_id.trim());
				pstmt_insert.setString(8,login_at_ws_no.trim());
				pstmt_insert.setString(9,login_facility_id.trim());
				pstmt_insert.setString(10,login_by_id.trim());
				pstmt_insert.setString(11,login_at_ws_no.trim());
				pstmt_insert.setString(12,login_facility_id.trim());
				pstmt_insert.addBatch();
				found = true;
				}
				if(found){
					int[] result_insert_disp_queue= pstmt_insert.executeBatch();
					closeStatement( pstmt_insert) ;
					for (int i=0;i<result_insert_disp_queue.length ;i++ ){
						if(result_insert_disp_queue[i]<0  && result_insert_disp_queue[i] != -2 ){
							System.err.println("NORMAL RX--> ERROR IN INSERTING PH_ORD_FOR_DISP_QUEUE result_insert_slide_tmpl["+i+"]= "+result_insert_disp_queue[i]);
							System.err.println("tabData=== "+tabData);
							break;
						}
						
					}
				}
			}//added for JD-CRF-0198 end
			
            String quota_limit_type ="";
			HashMap updateRecord =null;
			
			pstmt_update		= connection.prepareStatement( (String)sqlMap.get("SQL_CURR_QUOTA_LIMIT_UPDATE") ) ;
			for(int i=0;i<OrderID.size();i++){
					headerList		= null;
					headerList		= (ArrayList) OrderDetails.get(i);
					tempHeader		= (HashMap) OrderHeader.get(i);
					 quota_limit_site_yn=(String)tempHeader.get("QUOTA_LIMIT_SITE_YN");  // ML-MMOH-CRF-1823 US008- 43528 
					 quota_limit_req_yn=(String)tempHeader.get("QUOTA_LIMIT_REQ_YN");  // ML-MMOH-CRF-1823 US008- 43528
					 System.err.println("quota_limit_site_yn@@=="+quota_limit_site_yn+"quota_limit_req_yn=="+quota_limit_req_yn);
               if(quota_limit_site_yn.equals("Y") && quota_limit_req_yn.equals("Y")){
					for(int j=0;j<headerList.size();j++){
						updateRecord= null;
						updateRecord=(HashMap) headerList.get(j);
						quota_limit_type = (String)updateRecord.get("QUOTA_LIMIT_TYPE")==null?"": (String)updateRecord.get("QUOTA_LIMIT_TYPE");
						System.err.println("quota_limit_type @@==="+quota_limit_type);
						System.err.println("CURR_QUOTA_LIMIT_VALUE @@==="+(String)updateRecord.get("CURR_QUOTA_LIMIT_VALUE"));
						System.err.println("DRUG_CODE @@==="+(String)updateRecord.get("DRUG_CODE"));
						System.err.println("SPECIALITY_CODE @@==="+(String)tempHeader.get("SPECIALITY_CODE"));
                    if(quota_limit_type.equals("P")){
						pstmt_update.setString(1,(String)updateRecord.get("CURR_QUOTA_LIMIT_VALUE")); 
						pstmt_update.setString(2,login_at_ws_no);
						pstmt_update.setString(3,login_by_id);
						pstmt_update.setString(4,login_facility_id);
						pstmt_update.setString(5,(String)updateRecord.get("DRUG_CODE"));
						pstmt_update.setString(6,(String)tempHeader.get("SPECIALITY_CODE"));
						pstmt_update.executeUpdate();
			        }
				  }
			   }
			}
//ORDER REGISTERATION
			if((patientClass.equals("OP") || patientClass.equals("EM")) && !trn_group_ref.equals("")&&!tabData.get("AmendAlternateDrug").equals("Y")){//added AmendAlternateDrug for  JD-CRF-0198 end
				cstmt_insert=connection.prepareCall("{call ph_auto_order_regn(?,?,?,?,?,?)}");

				cstmt_insert.setString( 1, trn_group_ref);
				cstmt_insert.setString( 2, patientId);
				cstmt_insert.setString( 3, login_facility_id);
				cstmt_insert.setString( 4, encounter_id);
				cstmt_insert.registerOutParameter(5, Types.VARCHAR );
				cstmt_insert.registerOutParameter(6, Types.VARCHAR );
				cstmt_insert.execute() ;

				tokens_generated_yn = cstmt_insert.getString(5)==null ? "":cstmt_insert.getString(5);
				auto_order_regn_err = cstmt_insert.getString(6)==null ? "":cstmt_insert.getString(6);

				closeResultSet( resultSet ) ;
				closeStatement( cstmt_insert ) ;
			}
			if(insert_rec_1 && insert_rec_2 && insert_rec_3 && insert_rec_4 && insert_rec_5 && insert_rec_6 &&  insert_rec_7 &&  insert_rec_8 && insert_rec_9  && auto_order_regn_err.equals("")&& consumable_insert){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				map.put("msgid","RECORD_INSERTED" ) ;
				map.put("flag","");
				map.put("trn_group_ref",trn_group_ref);
				map.put("tokens_generated_yn",tokens_generated_yn);
			}
			else{
				System.err.println("ERROR IN PRESCRIPTION EJB@1 tokens_generated_yn="+tokens_generated_yn+" auto_order_regn_err"+auto_order_regn_err+" trn_group_ref="+trn_group_ref+" patientId="+patientId+" encounter_id="+encounter_id);
				try{
					connection.rollback();
					map.put("flag","");
				}
				catch(Exception es){
					es.printStackTrace() ;
					map.put("flag","");
				}
			}
		}
		catch(Exception e){
			System.err.println("ERROR IN PRESCRIPTION EJB@2 tabData====>"+tabData);
			e.printStackTrace() ;
			try{
				connection.rollback();
				map.put("flag","");
			}
			catch(Exception es){
				es.printStackTrace() ;
				map.put("flag","");
			}
		}
		finally{
			try{
				closeStatement( pstmt_insert ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_clob ) ;
				closeStatement(pstmt_workload);
				closeStatement(workload_insert);		 
				closeStatement(work_insert_month);		 
				closeStatement(work_insert_loc)	;	 
				closeStatement(work_insert_loc_mon);	 
				closeResultSet( resultSet_workload );
				closeResultSet( rset_clob );
				closeResultSet( resultSet );
				closeConnection( connection,(Properties)tabData.get( "properties" ) );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		//map.put("flag",debug);
		map.put("flag","");
		map.put("test",test.toString());
		System.err.println("@@@@@@@PRESMAN====map="+map);
		return map;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}

	public String getNextSchDateTime(Connection connection , String sch_date_time,String SQL_PH_SLIDING_SCALE_SELECT5){
		PreparedStatement pstmt  = null ;
        ResultSet resultSet      = null ;
		String result	 = "" ;
		try{
			pstmt					= connection.prepareStatement(SQL_PH_SLIDING_SCALE_SELECT5) ;
			pstmt.setString(1,sch_date_time);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result = resultSet.getString("SCH_DATE_TIME");
			}
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
			try{
               closeResultSet( resultSet ) ;
               closeStatement( pstmt ) ;                 
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return result;
	}

	public HashMap discontinueCancelDrug( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		//Properties prop	= null;
		Connection connection	    = null ;
		PreparedStatement pstmt		= null ;
		try {
			ArrayList mandatory_flds= (ArrayList)tabData.get("mandatory_flds");
			String login_by_id		= (String)mandatory_flds.get(0);
			String login_at_ws_no	= (String)mandatory_flds.get(1);
			String login_facility_id= (String)mandatory_flds.get(2);
			//prop	= (Properties)tabData.get( "properties" );
			String order_id			= (String) tabData.get("order_id");
			String order_line_no	= (String) tabData.get("order_line_no");
			String reason			= (String) tabData.get("reason");
			String remarks			= (String) tabData.get("remarks");
			String status			= (String) tabData.get("status");
			String SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_A	= (String) sqlMap.get( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_A");
			String SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_B	= (String) sqlMap.get( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_B");
			String SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_A	= (String) sqlMap.get( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_A");
			String SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_B	= (String) sqlMap.get( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_B");
			connection				= getConnection((Properties)tabData.get( "properties" )) ;

			if(status!=null && status.equals("N")){
				pstmt	= connection.prepareStatement(SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_A) ;
				pstmt.setString(1,remarks);				// LAST_ACTION_REASON_DESC
				pstmt.setString(2,"DC");				// LAST_ACTION_TYPE
				pstmt.setString(3,login_at_ws_no);		// MODIFIED_AT_WS_NO
				pstmt.setString(4,login_by_id);			// MODIFIED_BY_ID
				pstmt.setString(5,login_facility_id);	// MODIFIED_FACILITY_ID
				pstmt.setString(6,login_by_id);			// MODIFIED_FACILITY_ID
				pstmt.setString(7,order_id);			// ORDER_ID
				pstmt.executeUpdate();
			}
			else{
				pstmt	= connection.prepareStatement(SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_B) ;
				pstmt.setString(1,remarks);				// LAST_ACTION_REASON_DESC
				pstmt.setString(2,"CN");				// LAST_ACTION_TYPE
				pstmt.setString(3,login_at_ws_no);		// MODIFIED_AT_WS_NO
				pstmt.setString(4,login_by_id);			// MODIFIED_BY_ID
				pstmt.setString(5,login_facility_id);	// MODIFIED_FACILITY_ID
				pstmt.setString(6,remarks);				// LAST_ACTION_REASON_DESC
				pstmt.setString(7,login_by_id);				// LAST_ACTION_REASON_DESC
				pstmt.setString(8,order_id);			// ORDER_ID
				pstmt.setString(9,order_line_no);		// ORDER_LINE_NUM
				pstmt.executeUpdate();
			}
			if(status!=null && status.equals("N")){
				pstmt	= connection.prepareStatement(SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_A) ;
				pstmt.setString(1,login_by_id);			
				pstmt.setString(2,reason);						
				pstmt.setString(3,login_at_ws_no);		
				pstmt.setString(4,login_by_id);			
				pstmt.setString(5,login_facility_id);	
				pstmt.setString(6,order_id);			
				pstmt.setString(7,order_line_no);		
				pstmt.executeUpdate();
			}
			else{
				pstmt	= connection.prepareStatement(SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_B) ;
				pstmt.setString(1,login_by_id);				
				pstmt.setString(2,login_at_ws_no);		
				pstmt.setString(3,login_by_id);			
				pstmt.setString(4,login_facility_id);	
				pstmt.setString(5,order_id);			
				pstmt.setString(6,order_line_no);		
				pstmt.executeUpdate();
			}	
			updateOrderTables(connection,tabData,sqlMap);
			connection.commit();
			map.put("result", new Boolean( true ) ) ;
			map.put("msgid","RECORD_MODIFIED" ) ;
			map.put("flag","");
		}
		catch(Exception e){
			try{
				connection.rollback();
				map.put("flag",e.toString());
			}
			catch(Exception es){
				es.printStackTrace() ;
				map.put("flag",e.toString());
			}
			e.printStackTrace();
		}
		finally{
			try{
				closeStatement( pstmt ) ;
				closeConnection( connection,(Properties)tabData.get( "properties" ) );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return map;
	}

	private void updateOrderTables(Connection connection,HashMap tabData,HashMap sqlMap) {
		String order_id				=	null;
		ResultSet	resultSet		=	null;
		PreparedStatement pstmt_or_order_line_select	=	null;
		PreparedStatement pstmt_or_update				=	null;
		
		try{
			ArrayList mandatory_flds= (ArrayList)tabData.get("mandatory_flds");
			String login_by_id		= (String)mandatory_flds.get(0);
			String login_at_ws_no	= (String)mandatory_flds.get(1);
			String login_facility_id= (String)mandatory_flds.get(2);

			order_id		=   (String)tabData.get("order_id");
			String status			= (String) tabData.get("status");

			pstmt_or_order_line_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_PROFILE_QUERY_SELECT9")) ;	
			pstmt_or_update				= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DRUG_PROFILE_QUERY_UPDATE_OR_ORDER") ) ;

			int	total				=	1;

			// CHECK OR_ORDER_LINE REMAINING STATUS EXCEPT 'CN'	
			pstmt_or_order_line_select.setString(1,order_id);
			pstmt_or_order_line_select.setString(2,"CN");
			resultSet	=	pstmt_or_order_line_select.executeQuery();
			if(resultSet.next()) {
				total	=	Integer.parseInt((String)resultSet.getString("TOTAL"));
			}
			closeResultSet( resultSet );
		
			// OR_ORDER UPDATE
			if(total==0) {
				pstmt_or_update.setString(1,"CN");  // order_status 
				pstmt_or_update.setString(2,(String) tabData.get("remarks")); // can_reason
				pstmt_or_update.setString(3,login_at_ws_no);   // modified work station 
				pstmt_or_update.setString(4,login_by_id);  // modified by id
				pstmt_or_update.setString(5,login_facility_id); // modified facility
				pstmt_or_update.setString(6,order_id);  // order id
				pstmt_or_update.executeUpdate();
			}
			total				=	1;

			// CHECK OR_ORDER_LINE REMAINING STATUS EXCEPT 'DC'	
			pstmt_or_order_line_select.setString(1,order_id);
			pstmt_or_order_line_select.setString(2,"DC");
			resultSet	=	pstmt_or_order_line_select.executeQuery();
			if(resultSet.next()) {
				total	=	Integer.parseInt((String)resultSet.getString("TOTAL"));
			}
			closeResultSet( resultSet );
		
			// OR_ORDER UPDATE
			if(status!=null && status.equals("N")){
				pstmt_or_update.setString(1,"DC");
				pstmt_or_update.setString(2,(String) tabData.get("remarks"));
				pstmt_or_update.setString(3,login_at_ws_no);
				pstmt_or_update.setString(4,login_by_id);
				pstmt_or_update.setString(5,login_facility_id);
				pstmt_or_update.setString(6,order_id);
				pstmt_or_update.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{	
			try {
				closeResultSet( resultSet );
				closeStatement( pstmt_or_update ) ;
				closeStatement( pstmt_or_order_line_select ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	public boolean insertPresItemList(Connection connection, HashMap tabData, HashMap sqlMap){
		//Properties  prop					= null;
		PreparedStatement pstmt_insert		= null ;
		PreparedStatement pstmt				= null ;
	//	PreparedStatement pstmt_select		= null ; Unused local variable INC63877
		PreparedStatement pstmt_clob		= null ;
		CallableStatement cstmt_insert		= null;
		ResultSet rset_clob					= null;
		ResultSet resultSet					= null ;

		String patient_id			= "";
		String encounter_id			= "";
		String patient_class		= "";
		String bed_num				= "";
		String room_num				= "";
		String language_id			= "";
		String facility_id			= "";
		String login_by_id			= "";
		String login_at_ws_no		= "";
		String login_facility_id	= "";
		String trn_group_ref		= "";
		String location_type		= "";
		String location_code		= "";
		String pract_id				= "";
		String regn_reqd_yn			= "";
		String order_status			= "";
		String order_date           = "";
		String end_date             = "";
		String height				= "";
		String weight				= "";
		String bsa					= "";
		String bmi					= "";
		String height_unit			= "";
		String weight_unit			= "";
		String bsa_unit				= "";
		String perf_facility		= "";
		String perf_sys				= "";
		String perf_deptloc_type	= "";
		String perf_deptloc_code	= "";
		String auth_reqd_yn			= "";
		String authorize_yn			= "";
		String approval_yn			= "";
		//String spl_app_reqd_yn	= "";
		String cosign_reqd_yn		= "";
		String item_desc			= "";
		String line_status			= "";
		String consent_reqd_yn		= "";
		String init_auth_reqd_yn	="";
		String init_spl_appr_reqd_yn="";
		String init_cosign_reqd_yn	= "";
		String apprvl_reqd_yn		= "";
		String ord_authorized_yn	= "";
		String ord_approved_yn		="";
		int srl_NO					= 0;
		String order_id				="";	//Added for ICN-64906
		int result_insert_5			= 0;	//Added for ICN-64906
		boolean insert_rec_1 = false;
		boolean insert_rec_2 = false;
		boolean insert_rec_3 = false;
		boolean insert_rec_4 = false;
		boolean insert_rec_5 = false;	//Added for ICN-64906
		boolean consumable_insert = false;
		
		//Added for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 start
		String max_durn_pres="";
		PreparedStatement pstmt_max_durn			= null ;
		ResultSet rs_max_durn		= null;
		String take_home_medication  ="";
		String placed_from_verbal_order=(String)tabData.get("placed_from_verbal_order")==null?"N":(String)tabData.get("placed_from_verbal_order");//ADDED FOR GHL-CRF-0509
		//Added for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 end
		try {
			//prop	= (Properties)tabData.get( "properties" );
			ArrayList presItemList				= (ArrayList) tabData.get("presItemList");
			ArrayList mandatory_flds			= (ArrayList) tabData.get("mandatory_flds");

			String license						= (String)tabData.get("license");
			String OrderRemarks							= (String) tabData.get("OrderRemarks");	//Added for ICN-64906
			HashMap itemDetail				= new HashMap();
			language_id		= (String) tabData.get("language_id");
			HashMap nonPreferenceRemarksMedicalItem = (HashMap) tabData.get("nonPreferenceRemarksMedicalItem");//GHL-CRF-0618
		//	System.err.println("nonPreferenceRemarks=====>"+nonPreferenceRemarksMedicalItem);				
		
			if(mandatory_flds.size() > 1) {
				login_by_id					= (String)mandatory_flds.get(0);
				login_at_ws_no				= (String)mandatory_flds.get(1);
				login_facility_id			= (String)mandatory_flds.get(2);
			}

			String sql_ph_prescription_select19a		        = (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT19A");
			String sql_ph_prescription_select20a		        = (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT20A");
			String sql_ph_prescription_select55			        = (String) sqlMap.get( "SQL_PH_PRESCRIPTION_SELECT55");
			String sql_or_order_insert							= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT1");
			String sql_or_order_line_insert						= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT2");
			//String sql_or_order_line_ph_insert					= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT3");	//Commented for GHL-CRF-0470
			String sql_or_order_line_ph_insert					= "INSERT INTO OR_ORDER_LINE_PH (ORDER_ID,ORDER_LINE_NUM,GENERIC_ID,FORM_CODE,TRADE_CODE,FORMULARY_ITEM_YN,DOSAGE_TYPE,SPLIT_DRUG_PREVIEW,TOT_STRENGTH,TOT_STRENGTH_UOM,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,BROUGHT_BY_PATIENT_YN,CUR_DRUG_YN,REFILL_DRUG_YN,DISPENSING_LOC_TYPE,DISPENSING_LOC,DISPENSING_STORE,IP_FILL_PROCESS,IP_FILL_PRD_AHEAD,NEXT_FILL_DATE,LAST_FILL_QTY,DISPENSED_QTY,BMS_QTY,BMS_STRENGTH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPLIT_DOSE_YN,QTY_VALUE_SPLIT_DOSE,QTY_UNIT_SPLIT_DOSE,STRENGTH_VALUE,STRENGTH_UOM,PRES_QTY_VALUE,PRES_QTY_UOM,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,DUPLICATE_DRUG_OVERRIDE_REASON,PATIENT_BROUGHT_MEDICATION_YN,AMEND_REASON_CODE, AMEND_REASON,PAT_COUNS_REQD_YN, PAT_COUNS_ORD_PRACT_ID,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,BUILD_MAR_YN,DRUG_INDICATION,PREGNANCY_OVERRIDE_REASON,ITEM_REMARKS,PLACED_FROM_VERBAL_ORDER,NOT_PREFERED_ITEM_REM_CODE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	//Added for GHL-CRF-0470//placed_from_verbal_order added for GHL-CRF-0509
			String sql_ph_patient_drug_profile_insert			= (String) sqlMap.get( "SQL_PH_PRESCRIPTION_INSERT4");

			HashMap orderStatusCode		=	new HashMap();

			trn_group_ref = (String)tabData.get("trn_group_ref");

			boolean verify_pat_brought_medn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","VERIFY_PAT_BROUGHT_MEDN");//added for TH-KW-CRF-0002

			pstmt			= connection.prepareStatement(sql_ph_prescription_select20a) ;
			resultSet		= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}

			closeResultSet( resultSet );
			closeStatement( pstmt) ;
			pstmt_insert		= connection.prepareStatement(sql_or_order_insert) ;
			pstmt_insert.clearBatch();
            PreparedStatement pstmt_or_order_type	= connection.prepareStatement(sql_ph_prescription_select19a) ;

			for (int i=0;i<presItemList.size() ;i++ ){
				itemDetail=(HashMap)presItemList.get(i);

				height		=(String)itemDetail.get("HEIGHT");
				weight		=(String)itemDetail.get("WEIGHT");
				bsa			=(String)itemDetail.get("BSA");
				bmi			=(String)itemDetail.get("BMI");
				bsa_unit	=(String)itemDetail.get("BSA_UNIT");
				height_unit	=(String)itemDetail.get("HEIGHT_UNIT");
				weight_unit	=(String)itemDetail.get("WEIGHT_UNIT");
				order_date  = (String)itemDetail.get("ORDERED_DATE");

				pstmt_insert.setString(1,(String)itemDetail.get("ORDER_ID"));
				pstmt_insert.setString(2,(String)itemDetail.get("ORDER_TYPE"));
				String ord_type_code=(String)itemDetail.get("ORDER_TYPE");
				
				pstmt_or_order_type.setString(1,ord_type_code);
				resultSet		= pstmt_or_order_type.executeQuery();
				if(resultSet!=null && resultSet.next()){
					regn_reqd_yn=resultSet.getString(1);
				}
				closeResultSet( resultSet );
				
				pstmt_insert.setString(3,(String)itemDetail.get("ORDER_CATEGORY"));
				pstmt_insert.setString(4,"PH");
				pstmt_insert.setString(5,(String)itemDetail.get("PATIENT_ID"));
				patient_id		= (String)itemDetail.get("PATIENT_ID");
				bed_num = (String)itemDetail.get("BED_NUM")==null?"":(String)itemDetail.get("BED_NUM");
				room_num = (String)itemDetail.get("ROOM_NUM")==null?"":(String)itemDetail.get("ROOM_NUM");
				
				patient_class	= (String)itemDetail.get("PATIENT_CLASS");
				facility_id		= (String)itemDetail.get("FACILITY_ID");
				encounter_id	=(String)itemDetail.get("ENCOUNTER_ID");
				location_type	=(String)itemDetail.get("SOURCE_TYPE");
				location_code	=(String)itemDetail.get("SOURCE_CODE");
				pract_id		=(String)itemDetail.get("ORD_PRACT_ID");

				pstmt_insert.setString(6,patient_class);
				pstmt_insert.setString(7,facility_id);
				pstmt_insert.setString(8,encounter_id);
				pstmt_insert.setString(9,encounter_id);
				pstmt_insert.setString(10,"");
				pstmt_insert.setString(11,location_type);
				pstmt_insert.setString(12,location_code);

				pstmt_insert.setString(13,"");//DISCHARGE_IND
				pstmt_insert.setString(14,(String)itemDetail.get("ORDERED_DATE"));
				pstmt_insert.setString(15,(String)itemDetail.get("ORD_PRACT_ID"));
				pstmt_insert.setString(16,(String)itemDetail.get("PRIORITY"));
				order_status		= (String)itemDetail.get("ORDER_STATUS");

				auth_reqd_yn =	(String)itemDetail.get("ORD_AUTH_REQD_YN")==null?"N":(String)itemDetail.get("ORD_AUTH_REQD_YN");
				apprvl_reqd_yn = (String)itemDetail.get("ORD_SPL_APPR_REQD_YN")==null?"N":(String)itemDetail.get("ORD_SPL_APPR_REQD_YN");
				ord_authorized_yn =	(String)itemDetail.get("ORD_AUTHORIZED_YN")==null?"N":(String)itemDetail.get("ORD_AUTHORIZED_YN");
				ord_approved_yn =	(String)itemDetail.get("ORD_APPROVED_YN")==null?"N":(String)itemDetail.get("ORD_APPROVED_YN");

				if(order_status==null || order_status.equals("")){

					if(auth_reqd_yn.equals("Y")){
						if(apprvl_reqd_yn.equals("Y")){
							if(ord_approved_yn.equals("Y")){
								itemDetail.put("ORD_APPR_REQD_YN","N");
								order_status	=	"10"; //OS - Ordered
							}
							else{
								if(ord_authorized_yn.equals("Y")){
									order_status	=	"05"; //PS - Pending Spl Approval
								}
								else{
									order_status	=	"03"; //PO - Pending Authorization
								}
							}
						}
						else{
							if(ord_authorized_yn.equals("Y")){
								itemDetail.put("ORD_AUTH_REQD_YN","N");
								order_status	=	"10"; //OS - Ordered
							}
							else{
								order_status	=	"03"; //PO - Pending Authorization
							}
						}
					}
					else{
						if(apprvl_reqd_yn.equals("Y")){
							if(ord_approved_yn.equals("Y")){
								itemDetail.put("ORD_APPR_REQD_YN","N");
								order_status	=	"10"; //OS - Ordered
							}
							else{
								order_status	=	"05"; //PS - Pending Spl Approva
							}
						}
						else{
							order_status	=	"10"; //OS - Ordered
						}
					}
				}

				if(order_status.equals("10") || order_status.equals("25")){
					if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y")){
						order_status="25";
					} 
					else {
						order_status="10";
					}
				}
				itemDetail.put("ORDER_STATUS",order_status);
				order_status = (String)orderStatusCode.get(order_status);

				pstmt_insert.setString(17,auth_reqd_yn);
				pstmt_insert.setString(18,(String)itemDetail.get("ORD_AUTH_LEVEL"));

				if(auth_reqd_yn.equals("")||auth_reqd_yn.equals("N")){
					pstmt_insert.setString(19,"");
					pstmt_insert.setString(20,null);
				}
				else{
					pstmt_insert.setString(19,(String)itemDetail.get("ORD_PRACT_ID"));
					pstmt_insert.setString(20,(String)itemDetail.get("ORDERED_DATE"));
				}

				if(itemDetail.get("ORD_APPR_REQD_YN")==null) {
					pstmt_insert.setString(21,"N");
				} 
				else {
					pstmt_insert.setString(21,(String)itemDetail.get("ORD_APPR_REQD_YN"));
				}

				pstmt_insert.setString(22,(String)itemDetail.get("ORD_APPR_BY_USER_ID"));

				if(itemDetail.get("ORD_APPR_REQD_YN")!= null && ((String)itemDetail.get("ORD_APPR_REQD_YN")).equals("N")){
					pstmt_insert.setString(23,null);
				}
				else{
					pstmt_insert.setString(23,(String)itemDetail.get("ORDERED_DATE"));
				}

				if(itemDetail.get("ORD_COSIGN_REQD_YN")==null) {
					pstmt_insert.setString(24,"N");
				} 
				else {
					pstmt_insert.setString(24,(String)itemDetail.get("ORD_COSIGN_REQD_YN"));
				}
				pstmt_insert.setString(25,"");
				pstmt_insert.setString(26,"");
				pstmt_insert.setString(27,null);
				pstmt_insert.setString(28,null);
				pstmt_insert.setString(29,"N");
				pstmt_insert.setString(30,"CO");//CONT_ORDER_IND
				if(!license.equals("PHBASIC")) {
					
					perf_sys			=	"PH";
					perf_deptloc_type	=	"P";

					perf_deptloc_code	= (String)itemDetail.get("STORE_CODE");
					if(perf_deptloc_code==null || perf_deptloc_code.equals(""))
						perf_deptloc_type	= (String)itemDetail.get("LOCATION_TYPE");
				}

				perf_facility		=	(String)itemDetail.get("PERFORMING_FACILITY_ID"); //replaced FACILITY_ID with PERFORMING_FACILITY_ID for IN24642  --25/10/2010-- priya
				pstmt_insert.setString(31,perf_facility);
				pstmt_insert.setString(32,perf_sys);
				pstmt_insert.setString(33,perf_deptloc_type);
				pstmt_insert.setString(34,perf_deptloc_code);
				pstmt_insert.setString(35,"");
				pstmt_insert.setString(36,"N");
				pstmt_insert.setString(37,"N");//CHILD_ORDER_YN
				pstmt_insert.setString(38,""); //PARENT_ORDER_ID
				pstmt_insert.setString(39,"N");
				pstmt_insert.setString(40,"");
				pstmt_insert.setString(41,"");
				pstmt_insert.setString(42,"");

				pstmt_insert.setString(43,order_status);
				pstmt_insert.setString(44,"");
				pstmt_insert.setString(45,login_by_id);
				pstmt_insert.setString(46,login_at_ws_no);
				pstmt_insert.setString(47,login_facility_id);
				pstmt_insert.setString(48,login_by_id);
				pstmt_insert.setString(49,login_at_ws_no);
				pstmt_insert.setString(50,login_facility_id);

				if(itemDetail.get("CONSENT_REQD_YN")==null) {
					pstmt_insert.setString(51,"N");
				} else {
					pstmt_insert.setString(51,(String)itemDetail.get("CONSENT_REQD_YN"));
				}

				pstmt_insert.setString(52,"");
				pstmt_insert.setString(53,null);
				pstmt_insert.setString(54,"");
				pstmt_insert.setString(55,"");
				pstmt_insert.setString(56,"");
				pstmt_insert.setString(57,"");
				pstmt_insert.setString(58,"");
				pstmt_insert.setString(59,"");
				pstmt_insert.setString(60,"");
				pstmt_insert.setString(61,trn_group_ref);
				pstmt_insert.addBatch();
			}
			int[] result_insert= pstmt_insert.executeBatch();

			closeStatement( pstmt_insert) ;
			closeResultSet( resultSet );
			closeStatement( pstmt_or_order_type) ;
			
			for (int i=0;i<result_insert.length ;i++ ) {
				if(result_insert[i]<0  && result_insert[i] != -2 ){
					System.err.println("NORMAL RX CONSUMABLEs--> ERROR IN INSERTING OR_ORDER result_insert["+i+"]= "+result_insert[i]);
					System.err.println("tabData=== "+tabData);
					insert_rec_1=false;
					break;
				}
				else{
					insert_rec_1=true;
				}
			}
            if(!order_date.equals("")) { 
            	//Added for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 start
            	 pstmt_max_durn= connection.prepareStatement("SELECT MAX_DURN_FOR_IP_PRES,MAX_DURN_FOR_OP_PRES,MAX_DURN_FOR_DM_PRES FROM PH_PARAM WHERE MODULE_ID = 'PH'") ;
				 rs_max_durn		= pstmt_max_durn.executeQuery();
				 while(rs_max_durn.next()){
				
				 take_home_medication=(String)itemDetail.get("TAKE_HOME_MEDICATION");
				 
				if(take_home_medication.equalsIgnoreCase("Y")){
					 max_durn_pres=rs_max_durn.getString("MAX_DURN_FOR_DM_PRES");
					 
				}
				else{
					  if( (patient_class.equalsIgnoreCase("IP")) || (patient_class.equalsIgnoreCase("DC")) ){
							 max_durn_pres=rs_max_durn.getString("MAX_DURN_FOR_IP_PRES");
							
						 }
						 else if((patient_class.equalsIgnoreCase("OP")) ||(patient_class.equalsIgnoreCase("EM")) ||  (patient_class.equalsIgnoreCase("XT"))){
							 max_durn_pres= rs_max_durn.getString("MAX_DURN_FOR_OP_PRES");
							
						 }
						 else{
							 max_durn_pres="90";
							
						 }
				}
			
			
			 
			  
		  }
			  try {
					closeResultSet( rs_max_durn );
					closeStatement( pstmt_max_durn) ;
				}catch(Exception es) {
					es.printStackTrace();
				}
			  
			//Added for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 end
				pstmt			= connection.prepareStatement("SELECT TO_CHAR(TO_DATE(?,'dd/mm/yyyy hh24:mi')+"+max_durn_pres+",'dd/mm/yyyy hh24:mi') END_DATE FROM dual") ;//Modified for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016
				pstmt.setString(1,order_date);
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					end_date=resultSet.getString("END_DATE");
				}
				closeResultSet( resultSet );
				closeStatement( pstmt) ;
			}

//Insert OR_ORDER_LINE
			if(insert_rec_1){
				pstmt_insert	= connection.prepareStatement(sql_or_order_line_insert) ;
				pstmt_insert.clearBatch();
				
				for(int j=0;j<presItemList.size();j++){
					itemDetail=(HashMap) presItemList.get(j);
					pstmt_insert.setString(1,(String)itemDetail.get("ORDER_ID"));
					pstmt_insert.setString(2,"1");						
					pstmt_insert.setString(3,(String)itemDetail.get("ITEM_CODE"));

					pstmt_insert.setString(4,(String)itemDetail.get("ITEM_DESC"));
					item_desc=(String)itemDetail.get("ITEM_DESC");
					if (item_desc!=null && !item_desc.equals("") && item_desc.length()>40){
						item_desc=item_desc.substring(0,40);
					}
					pstmt_insert.setString(5,item_desc);
					pstmt_insert.setString(6,"");
					pstmt_insert.setString(7,(String)itemDetail.get("ORDER_TYPE"));
					pstmt_insert.setString(8,(String)itemDetail.get("ORDER_CATEGORY"));

					pstmt_insert.setString(9,(String)itemDetail.get("ORDERED_DATE"));
					pstmt_insert.setString(10,(String)itemDetail.get("PRIORITY"));
					auth_reqd_yn =	(String)itemDetail.get("ORD_AUTH_REQD_YN")==null?"N":(String)itemDetail.get("ORD_AUTH_REQD_YN");
					pstmt_insert.setString(11,auth_reqd_yn);
					pstmt_insert.setString(12,"");
					pstmt_insert.setString(13,(String)itemDetail.get("ORD_SPL_APPR_REQD_YN"));

					if(itemDetail.get("ORD_COSIGN_REQD_YN")==null) {
						pstmt_insert.setString(14,"N");
					}
					else {
						pstmt_insert.setString(14,(String)itemDetail.get("ORD_COSIGN_REQD_YN"));
					}

					pstmt_insert.setString(15,(String)itemDetail.get("ORDERED_DATE"));//START_DATE
					pstmt_insert.setString(16,(String)itemDetail.get("FORM_CODE"));//FORM_CODE
					pstmt_insert.setString(17,(String)itemDetail.get("ROUTE_CODE"));//ROUTE_CODE

					pstmt_insert.setString(18,(String)itemDetail.get("QTY_VALUE"));
					pstmt_insert.setString(19,(String)itemDetail.get("UOM_CODE"));
					pstmt_insert.setString(20,(String)itemDetail.get("FREQ_CODE"));//FREQ_CODE 
					pstmt_insert.setString(21,max_durn_pres);//DURN_VALUE  Modified for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 
					pstmt_insert.setString(22,"D");//DURN_TYPE

					pstmt_insert.setString(23,"");
					pstmt_insert.setString(24,"");
					pstmt_insert.setString(25,null);
					pstmt_insert.setString(26,end_date);//END_DATE_TIME modified for PMG2016-BRU-CRF-0001 By prathyusha on 05/06/2016 start
					pstmt_insert.setString(27,null);

					pstmt_insert.setString(28,(String)itemDetail.get("QTY_VALUE"));
					pstmt_insert.setString(29,(String)itemDetail.get("UOM_CODE"));
					pstmt_insert.setString(30,"N");
					pstmt_insert.setString(31,null);
					pstmt_insert.setString(32,"");
					pstmt_insert.setString(33,"N");
					pstmt_insert.setString(34,(String)itemDetail.get("BILL_YN"));
					pstmt_insert.setString(35,"N");

					pstmt_insert.setString(36,"CO");
					pstmt_insert.setString(37,"N");
					pstmt_insert.setString(38,"");
					pstmt_insert.setString(39,"N");//CHILD_ORDER_YN
					pstmt_insert.setString(40,"");//PARENT_ORDER_ID
					pstmt_insert.setString(41,"");
					pstmt_insert.setString(42,"");
					pstmt_insert.setString(43,"");
					pstmt_insert.setString(44,pract_id);

					pstmt_insert.setString(45,null);
					pstmt_insert.setString(46,"");
					pstmt_insert.setString(47,null);
					pstmt_insert.setString(48,"");
					pstmt_insert.setString(49,null);
					pstmt_insert.setString(50,"");
					pstmt_insert.setString(51,null);
					pstmt_insert.setString(52,"");
					pstmt_insert.setString(53,null);
					pstmt_insert.setString(54,"");
					pstmt_insert.setString(55,null);
					pstmt_insert.setString(56,"");
					pstmt_insert.setString(57,"");

					order_status			=	(String)itemDetail.get("ORDER_STATUS");
					line_status				=	"";
					authorize_yn			=	(String)itemDetail.get("ORD_AUTHORIZED_YN")==null?"N":(String)itemDetail.get("ORD_AUTHORIZED_YN");
					approval_yn				=	(String)itemDetail.get("ORD_APPROVED_YN")==null?"N":(String)itemDetail.get("ORD_APPROVED_YN");
					consent_reqd_yn			=	(String)itemDetail.get("CONSENT_REQD_YN")==null?"N":(String)itemDetail.get("CONSENT_REQD_YN");
					init_auth_reqd_yn		=	(String)itemDetail.get("ORD_AUTH_REQD_YN")==null?"N":(String)itemDetail.get("ORD_AUTH_REQD_YN");
					init_spl_appr_reqd_yn	=	(String)itemDetail.get("ORD_SPL_APPR_REQD_YN")==null?"N":(String)itemDetail.get("ORD_SPL_APPR_REQD_YN");
					init_cosign_reqd_yn		=	(String)itemDetail.get("ORD_COSIGN_REQD_YN")==null?"N":(String)itemDetail.get("ORD_COSIGN_REQD_YN");

					cosign_reqd_yn			= init_cosign_reqd_yn;

					if(order_status.equals("10") || order_status.equals("25")){
						if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y")){
							order_status="25";
						}
						else{
							order_status="10";
						}
					}
					if(order_status.equals("03")){
						line_status= (String)orderStatusCode.get("03");
					}
					else if(order_status.equals("05")){
						line_status=(String) orderStatusCode.get("05");
					}
					else if(order_status.equals("10")){
						line_status=(String) orderStatusCode.get("10");
					}
					else if(order_status.equals("25")){
						line_status= (String)orderStatusCode.get("25");
					}
					else if(order_status.equals("00")){
						line_status= (String)orderStatusCode.get("00");
					}

					if( itemDetail.get("BROUGHT_BY_PAT")!=null && ((String)itemDetail.get("BROUGHT_BY_PAT")).equals("Y")) {
						if(!verify_pat_brought_medn){//Added if condition for TH-KW-CRF-0002
						line_status	=	(String)orderStatusCode.get("58");
						}
					}

					pstmt_insert.setString(58,line_status);
					pstmt_insert.setString(59,"");
					pstmt_insert.setString(60,login_by_id);
					pstmt_insert.setString(61,login_at_ws_no);
					pstmt_insert.setString(62,login_facility_id);
					pstmt_insert.setString(63,login_by_id);
					pstmt_insert.setString(64,login_at_ws_no);
					pstmt_insert.setString(65,login_facility_id);

					pstmt_insert.setString(66,"N");
					pstmt_insert.setString(67,"");
					String it_desc="";
					it_desc=(String)itemDetail.get("ITEM_DESC");
					if (it_desc!=null && !it_desc.equals("") && it_desc.length()>40){
						it_desc=it_desc.substring(0,40);
					}
					pstmt_insert.setString(68,it_desc);
					pstmt_insert.setString(69,it_desc);
					pstmt_insert.setString(70,"N");
					pstmt_insert.setString(71,"N");//Added for 51295
					pstmt_insert.addBatch();
				}
				int[] result_insert_2= pstmt_insert.executeBatch();
				closeStatement( pstmt_insert) ;
				closeResultSet( resultSet );
				for (int i=0;i<result_insert_2.length ;i++ ){
					if(result_insert_2[i]<0  && result_insert_2[i] != -2 ){
						System.err.println("NORMAL RX CONSUMABLEs--> ERROR IN INSERTING OR_ORDER_LINE result_insert_2["+i+"]= "+result_insert_2[i]);
						System.err.println("tabData=== "+tabData);
						insert_rec_2=false;
						break;
					}
					else{
					insert_rec_2=true;
					}
				}
			}

//Insert OR_ORDER_LINE_PH
			if(insert_rec_2){
				pstmt_insert	= connection.prepareStatement(sql_or_order_line_ph_insert) ;
				pstmt_insert.clearBatch();
				String non_prefered_item_remarks_code = "";//GHL-CRF-0618
				
				for(int j=0;j<presItemList.size();j++){
					itemDetail=(HashMap) presItemList.get(j);
					//GHL-CRF-0618 - start

					if(nonPreferenceRemarksMedicalItem!=null && nonPreferenceRemarksMedicalItem.size()>0)
						non_prefered_item_remarks_code = (String)nonPreferenceRemarksMedicalItem.get((String)itemDetail.get("ITEM_CODE"));
					if(non_prefered_item_remarks_code==null)
						non_prefered_item_remarks_code = "";

					//GHL-CRF-0618 - end
					pstmt_insert.setString(1,(String)itemDetail.get("ORDER_ID"));
					pstmt_insert.setString(2,"1");						
					pstmt_insert.setString(3,"MEDICALITEM");	//GENERIC_ID

					pstmt_insert.setString(4,(String)itemDetail.get("FORM_CODE"));		//FORM_CODE
					pstmt_insert.setString(5,(String)itemDetail.get("TRADE_CODE"));
					pstmt_insert.setString(6,"Y");		//IN_FORMULARY_YN
					pstmt_insert.setString(7,"A");		//DOSAGE_TYPE
					pstmt_insert.setString(8,"");		//SPLIT_DRUG_PREVIEW

					pstmt_insert.setString(9,"");		//TOT_STRENGTH
					pstmt_insert.setString(10,"");		//TOT_STRENGTH_UOM
					pstmt_insert.setString(11,"");		//INFUSE_OVER
					pstmt_insert.setString(12,"");		//INFUSE_OVER_UNIT
					pstmt_insert.setString(13,"");		//INFUSE_OVER_RATE
					pstmt_insert.setString(14,"");		//INFUSION_VOL_STR_UNIT
					pstmt_insert.setString(15,"");		//INFUSION_VOL_PER_UNIT
					pstmt_insert.setString(16,"N");		//BROUGHT_BY_PATIENT_YN
					pstmt_insert.setString(17,"N");		//CUR_DRUG_YN

					pstmt_insert.setString(18,"N");			//REFILL_DRUG_YN
					if(!license.equals("PHBASIC")) {
						perf_sys			=	"PH";
						perf_deptloc_type	=	"P";

						perf_deptloc_code	= (String)itemDetail.get("STORE_CODE");
						if(perf_deptloc_code==null || perf_deptloc_code.equals(""))
							perf_deptloc_type	= (String)itemDetail.get("LOCATION_TYPE");
					}
					pstmt_insert.setString(19,perf_deptloc_type);	//DISPENSING_LOC_TYPE 
					pstmt_insert.setString(20,perf_deptloc_code);	//DISPENSING_LOC
					pstmt_insert.setString(21,"");					//DISPENSING_STORE
					pstmt_insert.setString(22,"");					//IP_FILL_PRD_AHEAD

					pstmt_insert.setString(23,"");					//NEXT_FILL_DATE
					pstmt_insert.setString(24,"");					//LAST_FILL_QTY
					pstmt_insert.setString(25,null);				//LAST_FILL_PROC_ID

					pstmt_insert.setString(26,"");					//DISPENSED_QTY
					pstmt_insert.setString(27,(String)itemDetail.get("QTY_VALUE"));			//BMS_QTY
					pstmt_insert.setString(28,"");											//BMS_STRENGTH
					pstmt_insert.setString(29,login_by_id);
					pstmt_insert.setString(30,login_at_ws_no);
					pstmt_insert.setString(31,login_facility_id);
					pstmt_insert.setString(32,login_by_id);
					pstmt_insert.setString(33,login_at_ws_no);
					pstmt_insert.setString(34,login_facility_id);

					pstmt_insert.setString(35,"N");		//SPLIT_DOSE_YN , , , , , , 
					pstmt_insert.setString(36,"");		//QTY_VALUE_SPLIT_DOSE
					pstmt_insert.setString(37,"");		//QTY_UNIT_SPLIT_DOSE
					pstmt_insert.setString(38,"");		//STRENGTH_VALUE
					pstmt_insert.setString(39,"");		//STRENGTH_UOM
					pstmt_insert.setString(40,(String)itemDetail.get("QTY_VALUE"));//PRES_QTY_VALUE

					pstmt_insert.setString(41,(String)itemDetail.get("UOM_CODE"));		//PRES_QTY_UOM
					pstmt_insert.setString(42,"");		//ALLERGY_OVERRIDE_REASON
					pstmt_insert.setString(43,"");		//DOSAGE_LIMIT_OVERRIDE_REASON
					pstmt_insert.setString(44,"");	//DUPLICATE_DRUG_OVERRIDE_REASON

					pstmt_insert.setString(45,"");		//BATCH_ALLOCATED_YN
					pstmt_insert.setString(46,"");			//AMEND_REASON_CODE
					pstmt_insert.setString(47,"");			//AMEND_REASON
					pstmt_insert.setString(48,"");			//PAT_COUNS_REQD_YN
					pstmt_insert.setString(49,"");			//PAT_COUNS_ORD_PRACT_ID
					pstmt_insert.setString(50,(String)itemDetail.get("BL_OVERRIDE_EXCL_INCL_IND"));			//BL_INCL_EXCL_OVERRIDE_VALUE
					pstmt_insert.setString(51,(String)itemDetail.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"));			//BL_INCL_EXCL_OVERRIDE_REASON
					pstmt_insert.setString(52,"N");			//BUILD_MAR_YN
					pstmt_insert.setString(53,""); //DRUG_INDICATION
					pstmt_insert.setString(54,""); //PREGNANCY_OVERRIDE_REASON RUT-CRF-0063 [IN:029601]
					pstmt_insert.setString(55,(String)itemDetail.get("ITEM_REMARKS"));//Added for GHL-CRF-0470
					pstmt_insert.setString(56,placed_from_verbal_order);//Added for GHL-CRF-0509
					pstmt_insert.setString(57,non_prefered_item_remarks_code);//Added for GHL-CRF-0618
				
					pstmt_insert.addBatch();
				}
				int[] result_insert_3= pstmt_insert.executeBatch();
				closeStatement( pstmt_insert) ;
				closeResultSet( resultSet );
				for (int i=0;i<result_insert_3.length ;i++ ){
					if(result_insert_3[i]<0  && result_insert_3[i] != -2 ){
						System.err.println("NORMAL RX CONSUMABLEs--> ERROR IN INSERTING OR_ORDER_LINE_PH result_insert_3["+i+"]= "+result_insert_3[i]);
						System.err.println("tabData=== "+tabData);
						insert_rec_3=false;
						break;
					}
					else{
						insert_rec_3=true;
					}
				}
			}
			//PH_PATIENT_DRUG_PROFILE
			if(insert_rec_3){
				pstmt_insert	= connection.prepareStatement(sql_ph_patient_drug_profile_insert) ;
				pstmt_insert.clearBatch();

                pstmt			= connection.prepareStatement(sql_ph_prescription_select55) ;
				pstmt.setString(1,patient_id);
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						srl_NO=resultSet.getInt("NEXT_SRL_NO");
				}
				closeResultSet( resultSet );
				closeStatement( pstmt) ;
				for(int j=0;j<presItemList.size();j++){
					itemDetail=(HashMap) presItemList.get(j);
					pstmt_insert.setString(1,(String)itemDetail.get("PATIENT_ID"));
					pstmt_insert.setString(2,""+(srl_NO++));						
					pstmt_insert.setString(3,(String)itemDetail.get("FACILITY_ID"));	//

					pstmt_insert.setString(4,(String)itemDetail.get("ENCOUNTER_ID"));		//
					pstmt_insert.setString(5,(String)itemDetail.get("PATIENT_CLASS"));
					if(!license.equals("PHBASIC")) {
						perf_sys			=	"PH";
						perf_deptloc_type	=	"P";

						perf_deptloc_code	= (String)itemDetail.get("STORE_CODE");
						if(perf_deptloc_code==null || perf_deptloc_code.equals(""))
							perf_deptloc_type	= (String)itemDetail.get("LOCATION_TYPE");
					}
					pstmt_insert.setString(6,perf_deptloc_type);		//
					pstmt_insert.setString(7,perf_deptloc_code);		//
					pstmt_insert.setString(8,"");		//

					pstmt_insert.setString(9,(String)itemDetail.get("ROOM_NUM"));		//
					pstmt_insert.setString(10,(String)itemDetail.get("BED_NUM"));		//
					pstmt_insert.setString(11,"");		//
					pstmt_insert.setString(12,"");		//
					pstmt_insert.setString(13,"");		//
					pstmt_insert.setString(14,(String)itemDetail.get("ORD_PRACT_ID"));		//
					pstmt_insert.setString(15,(String)itemDetail.get("ORD_PRACT_ID"));		//
					pstmt_insert.setString(16,(String)itemDetail.get("ITEM_CODE"));		//
					pstmt_insert.setString(17,"MEDICALITEM");		//GENERIC_ID

					pstmt_insert.setString(18,(String)itemDetail.get("ORDERED_DATE"));			//START_DATE
					pstmt_insert.setString(19,end_date);	//END_DATE
					pstmt_insert.setString(20,"N");	//SPLIT_YN
					pstmt_insert.setString(21,"N");					//TAPPERED_YN
					pstmt_insert.setString(22,"");					//STRENGTH

					pstmt_insert.setString(23,"");					//STRENGTH_UOM
					pstmt_insert.setString(24,"");					//DOSAGE
					pstmt_insert.setString(25,"");				//DOSAGE_UOM

					pstmt_insert.setString(26,"");					//SPLIT_DOSE_PREVIE
					pstmt_insert.setString(27,(String)itemDetail.get("FREQ_CODE"));			//FEQ_CODE
					pstmt_insert.setString(28,"90");			//DURATION
					pstmt_insert.setString(29,(String)itemDetail.get("QTY_VALUE"));
					pstmt_insert.setString(30,"");			//DIAG_TEXT
					pstmt_insert.setString(31,"");			//DRUG_REMARKS
					pstmt_insert.setString(32,"N");			//IV_PREP_YN
					pstmt_insert.setString(33,"");
					pstmt_insert.setString(34,"");

					pstmt_insert.setString(35,"");		//  

					pstmt_insert.setString(36,"");		//
					pstmt_insert.setString(37,"");		//

					pstmt_insert.setString(38,"N");		//
					pstmt_insert.setString(39,"");		//
					pstmt_insert.setString(40,"");//

					pstmt_insert.setString(41,"N");		//
					pstmt_insert.setString(42,"");		//
					pstmt_insert.setString(43,"");		//
					pstmt_insert.setString(44,"P");	//

					pstmt_insert.setString(45,(String)itemDetail.get("FACILITY_ID"));		//
					pstmt_insert.setString(46,(String)itemDetail.get("ORDER_ID"));			//
					pstmt_insert.setString(47,"1");			//
					pstmt_insert.setString(48,"");			//
					pstmt_insert.setString(49,"N");			//
					pstmt_insert.setString(50,"");			//
					pstmt_insert.setString(51,"");			//
					pstmt_insert.setString(52,"");			//
					pstmt_insert.setString(53,"");			//
					pstmt_insert.setString(54,"");			//
					pstmt_insert.setString(55,"");			//
					pstmt_insert.setString(56,"N");			//
					pstmt_insert.setString(57,"");			//
					pstmt_insert.setString(58,"");			//
					pstmt_insert.setString(59,"");			//
					pstmt_insert.setString(60,login_by_id);			//
					pstmt_insert.setString(61,login_at_ws_no);
					pstmt_insert.setString(62,login_facility_id);
					pstmt_insert.setString(63,login_by_id);
					pstmt_insert.setString(64,login_at_ws_no);
					pstmt_insert.setString(65,login_facility_id);
					pstmt_insert.setString(66,"");			//
					pstmt_insert.setString(67,"");			//
					pstmt_insert.setString(68,"");			//
					pstmt_insert.setString(69,"");			//
					pstmt_insert.setString(70,"D");			//
					pstmt_insert.setString(71,"");			//
					pstmt_insert.setString(72,"");			//
					pstmt_insert.setString(73,"");			//
					pstmt_insert.setString(74,"");			//
					pstmt_insert.setString(75,"N");			//REFILL_YN
					pstmt_insert.setString(76,"");			//
					pstmt_insert.setString(77,"");			//
					pstmt_insert.setString(78,"");			//
					pstmt_insert.setString(79,"");			//
					pstmt_insert.setString(80,"");			//
					pstmt_insert.setString(81,"");			//
					pstmt_insert.setString(82,"");			//
					pstmt_insert.setString(83,"");			//
					pstmt_insert.setString(84,"");			//
					pstmt_insert.setString(85,"");			//
					pstmt_insert.setString(86,"A");			//
					pstmt_insert.setString(87,(String)itemDetail.get("HEIGHT"));			//
					pstmt_insert.setString(88,(String)itemDetail.get("HEIGHT_UNIT"));			//
					pstmt_insert.setString(89,(String)itemDetail.get("WEIGHT"));			//
					pstmt_insert.setString(90,(String)itemDetail.get("WEIGHT_UNIT"));			//
					pstmt_insert.setString(91,(String)itemDetail.get("BSA"));			//
					pstmt_insert.setString(92,"N");			//
					pstmt_insert.setString(93,(String)itemDetail.get("BMI"));			//
					pstmt_insert.setString(94,"");			//
					pstmt_insert.setString(95,"");			//
					pstmt_insert.setString(96,"");			//
					pstmt_insert.setString(97,(String)itemDetail.get("ABUSE_EXISTS")==null?"":(String)itemDetail.get("ABUSE_EXISTS")); //AAKH-CRF-0140
					pstmt_insert.setString(98,(String)itemDetail.get("abuse_override_remarks")==null?"":(String)itemDetail.get("abuse_override_remarks")); //AAKH-CRF-0140
				
					//pstmt_insert.executeUpdate();
					srl_NO++;

					pstmt_insert.addBatch();
				}

				int[] result_insert_4= pstmt_insert.executeBatch();
				//insert_rec_4=true;
				closeStatement( pstmt_insert) ;
				closeResultSet( resultSet );
				
				for (int i=0;i<result_insert_4.length ;i++ ){
					if(result_insert_4[i]<0  && result_insert_4[i] != -2 ){
						System.err.println("NORMAL RX CONSUMABLEs--> ERROR IN INSERTING PH_PATIENT_DRUG_PROFILE result_insert_4["+i+"]= "+result_insert_4[i]);
						System.err.println("tabData=== "+tabData);
						insert_rec_4=false;
						break;
					}
					else{
						insert_rec_4=true;
					}
				}
			}
			//ICN-64906 starts
			if(insert_rec_4){
				String action_seq_num		= "";
				for (int i=0;i<presItemList.size() ;i++ ){
					itemDetail=(HashMap)presItemList.get(i);
					order_id		=(String) itemDetail.get("ORDER_ID");
				pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_insert.setString(1, order_id);
				resultSet		= pstmt_insert.executeQuery();
				if(resultSet.next()) {
					action_seq_num = resultSet.getString(1);
				}
				closeResultSet( resultSet );
				closeStatement(pstmt_insert); 
				insert_rec_5=true;
				String header_comments	= OrderRemarks==null?"":OrderRemarks;
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_insert.setString(1, order_id);
				pstmt_insert.setString(2, action_seq_num);
				pstmt_insert.setString(3, login_by_id);
				pstmt_insert.setString(4, login_at_ws_no);
				pstmt_insert.setString(5, login_facility_id);
				pstmt_insert.setString(6, login_by_id);
				pstmt_insert.setString(7, login_at_ws_no);
				pstmt_insert.setString(8, login_facility_id);
				result_insert_5 = pstmt_insert.executeUpdate();
				if(result_insert_5>0){
					pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,action_seq_num);
					rset_clob =pstmt_clob.executeQuery();
					if(rset_clob!=null){
						while(rset_clob.next()){
							//commented for 7295 start
               /*							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));*///commented for 7295 end
							java.sql.Clob	clb =	(java.sql.Clob) rset_clob.getClob(1);
							BufferedWriter bw = new java.io.BufferedWriter(clb.setCharacterStream(0));
							bw.write(header_comments,0,header_comments.length());
							bw.flush();
							bw.close();
						}
						insert_rec_5=true;
					}
					else{
						insert_rec_5=false;
					}
					closeResultSet( rset_clob );
					closeStatement(pstmt_clob);
				}
				closeStatement(pstmt_insert);
				}
			}
			//ICN-64906 ends
			if(insert_rec_1 && insert_rec_2 && insert_rec_3 && insert_rec_4 && insert_rec_5){	// insert_rec_5 added for ICN-64906
				consumable_insert = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			consumable_insert = false;
		}
		finally{
			try{
				closeStatement( pstmt_insert ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_clob ) ;
				closeResultSet( rset_clob );
				closeResultSet( resultSet );
			}
			catch(Exception es){
				System.err.println("ERROR WHILE INSERTING CONSUMABLEORDER tabData="+tabData);
				es.printStackTrace();
			}
		}
		//map.put("flag",debug);
		return consumable_insert;
	}
	public String getTradeNameForDrug(Connection connection,String drug_code){
		
			PreparedStatement pstmt = null;
			ResultSet resultSet		= null;
			String trade_code="";
			try {
				pstmt = connection.prepareStatement("SELECT trade_code FROM ph_trade_name_for_drug WHERE drug_code = ? ");
				pstmt.setString(1,drug_code);
				resultSet = pstmt.executeQuery() ;
				
				if(resultSet!=null && resultSet.next()){					
					trade_code = resultSet.getString("trade_code");	
					if(trade_code==null)
						trade_code="";
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try{
					closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
				}catch(Exception es){
					es.printStackTrace();
				}
			}
			

		return trade_code;
	}
}
