/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/19/2017      63877   		chithra      UnusedLocal variable
23/02/2018	    IN066779		Sharanraj	 ML-MMOH-CRF-1000.1
24/10/2019		INO71514		Shazana	     SKR-SCF-1276
22/6/2020		IN073164		Shazana		 SKR-SCF-1334
30/06/2020      IN:072715        Haribabu      MMS-DM-CRF-0165
30/08/2020      IN073503        Manickavasagam J      SKR-SCF-1397
15/09/2020      IN73831        Manickavasagam J      SKR-SCF-1420
2/12/2020		6041			Shazana       		NMC-JD-CRF-0063
11/02/2021      TFS-14171          Prabha      MMS-QF-SCF-0616
21/02/2021      TFS-11210       Prabha      	SKR-SCF-1513
16/03/2021   IN15664         Manickavasagam J	 	   			COMMON-ICN-0029
---------------------------------------------------------------------------------------------------------------
*/
package ePH.IVPrescription;

import java.rmi.* ;
import java.util.* ;
import java.io.*;
import java.sql.* ;
import javax.ejb.* ;
import oracle.sql.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import eOR.Common.ChkDef;//IN066779
import ePH.Common.PhEJBSessionAdapter ;
/*
    public HashMap ivFluidsInsert( HashMap tabData, HashMap sqlMap ) --> method to insert IV Without Additives(IV Fluids)
	public HashMap insert( HashMap tabData, HashMap sqlMap )--> method to insert IV With Additives & IV Intermitents(IV PiggyBack)
	public HashMap delete( HashMap tabData, HashMap sqlMap ) --> dummy method 
	public HashMap modify( HashMap tabData, HashMap sqlMap )--> method to amend IV With Additives & IV Intermitents(IV PiggyBack)
	public HashMap ivFluidsModify( HashMap tabData, HashMap sqlMap )--> method to amend IV Without Additives(IV Fluids)
*/

/**
*
* @ejb.bean
*	name="IVPrescription"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IVPrescription"
*	local-jndi-name="IVPrescription"
*	impl-class-name="ePH.IVPrescription.IVPrescriptionManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.IVPrescription.IVPrescriptionLocal"
*	remote-class="ePH.IVPrescription.IVPrescriptionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.IVPrescription.IVPrescriptionLocalHome"
*	remote-class="ePH.IVPrescription.IVPrescriptionHome"
*	generate= "local,remote"
*
*
*/

public class IVPrescriptionManager extends PhEJBSessionAdapter {
/**
* @ejb.interface-method
*	 view-type="both"
*/
    public HashMap ivFluidsInsert( HashMap tabData, HashMap sqlMap ){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		Connection connection					= null;
		PreparedStatement pstmt_insert			= null;
		PreparedStatement pstmt_clob			= null;		
		PreparedStatement pstmt_select			= null;
		PreparedStatement pstmt_select_2		= null;
		PreparedStatement pstmt_workload		= null;
		PreparedStatement workload_insert		= null;
		PreparedStatement work_insert_month		= null;
		PreparedStatement work_insert_loc		= null;
		PreparedStatement work_insert_loc_mon	= null;
		PreparedStatement pstmt_select1			= null;
		PreparedStatement pstmt_select3			= null;
		CallableStatement cstmt_insert	= null;     
		ResultSet resultSet						= null;
		ResultSet resultSet_workload			= null;

		ArrayList AllFluids			=	new ArrayList();
		ArrayList order_uoms        =	new ArrayList();
		HashMap record				=	null;

		String sys_date				=	"";
		String order_type			=	"";
		String order_uom			=	"";		
		String order_id				=	"";		
		String perf_locn_code		=	"";
		String perf_locn_type		=	"";
		String patient_id			=	"";
		String patient_class		=	"";
		String encounter_id			=	"";
		String freq_code			=	"";
		String locn_type			=	"";
		String locn_code			=	"";
		String pract_id				=	"";
		String priority				=	"";
		String login_facility_id	=	"";
		String login_by_id			=	"";
		String login_at_ws_no		=	"";
		String buildMAR_yn		=	"";
		String trn_group_ref		=	"";
		String per_facility_id		=	"";
		int count					=	0;
		int result                  =   0;

		try {
			connection = getConnection((Properties)tabData.get("PROPERTIES"));
          
			AllFluids			= (ArrayList)tabData.get("AllFluids");
			//perf_locn_code		= (String)tabData.get("perf_locn_code");  Commented perf_locn_code, perf_locn_type for Bru-HIMS-CRF-347 [IN:037862]
			//perf_locn_type		= (String)tabData.get("perf_locn_type");
			sys_date			= (String)tabData.get("sys_date");
			patient_id			= (String)tabData.get("patient_id");
			patient_class		= (String)tabData.get("patient_class");
			encounter_id		= (String)tabData.get("encounter_id");
			freq_code			= (String)tabData.get("freq_code");
			locn_type			= (String)tabData.get("locn_type");
			locn_code			= (String)tabData.get("locn_code");
			pract_id			= (String)tabData.get("pract_id"); 
			priority			= (String)tabData.get("priority");
			login_facility_id	= (String)tabData.get("login_facility_id");
			login_by_id			= (String)tabData.get("login_by_id");
			login_at_ws_no		= (String)tabData.get("login_at_ws_no");
			ArrayList diag_Text	= (ArrayList)tabData.get("diag_Text");

			String height		= (String)tabData.get("height");
			String height_uom	= (String)tabData.get("height_uom");	
			String weight		= (String)tabData.get("weight");
			String weight_uom	= (String)tabData.get("weight_uom");
			String bsa			= (String)tabData.get("bsa");
			String bmi			= (String)tabData.get("bmi");
			String allergic_yn	= (String)tabData.get("allergic_yn");
			String remarks		= (String)tabData.get("remarks")==null?"":(String)tabData.get("remarks");
			String lang_id		= (String)tabData.get("lang_id");
			String MFR_YN		= "N"; 
			HashMap MFR_Recs	= new HashMap();
			buildMAR_yn			=(String)tabData.get("BUILD_MAR_YN"); //RUT-CRF0062  BUILD_MAR_YN Value will be inserted to all the fluids based on the first fluid selected. 
			String 	take_home	=(String)tabData.get("TAKEHOME_MEDN"); //RUT-CRF0062 
			String print_mar_label			= (String)tabData.get("print_mar_label")==null?"":(String)tabData.get("print_mar_label"); //added for MMS-QH-CRF-0080 [IN:038064]
			String print_mar_barcode			= (String)tabData.get("print_mar_barcode")==null?"":(String)tabData.get("print_mar_barcode");//added for MMS-QH-CRF-0080 [IN:038064]
			String iv_calc_infuse_by			=tabData.get("iv_calc_infuse_by")==null?"":(String)tabData.get("iv_calc_infuse_by");//Added for SKR-CRF-0035 [IN:037727] 
			String MAR_barcode_id="";//added for MMS-QH-CRF-0080 [IN:038064]
			if(allergic_yn==null) {
				allergic_yn		=	"N";
			}
			String sql_ph_gen_MARDarcodeId		= (String) sqlMap.get( "SQL_PH_GEN_MARDARCODEID");  //added for  MMS-QH-CRF-0080 [IN:038064]
			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT"));
			resultSet		= pstmt_select.executeQuery();
			if (resultSet.next()) {
				trn_group_ref = resultSet.getString("TRN_GROUP_REF");
			}
			closeResultSet( resultSet );
			closeStatement(pstmt_select); 
			if(AllFluids.size() > 0 ) {
				pstmt_select		= connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_SELECT2"));
				// OR_ORDER
				pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT1"));
				for(int i=0; i<AllFluids.size(); i++ ){
					count		=	0;
					record		    =	(HashMap)AllFluids.get(i);
					order_id		=	(String)record.get("ORDER_ID");
					order_type	    =	(String)record.get("ORDER_TYPE_CODE");
					perf_locn_code		= (String)record.get("DISP_LOCN_CODE");   // added perf_locn_code,perf_locn_type  for Bru-HIMS-CRF-347 [IN:037862]
					perf_locn_type		= (String)record.get("DISP_LOCN_TYPE");   
					per_facility_id		= (String)record.get("PER_FACILITY_ID");   
					
					pstmt_insert.setString(++count, order_id);				// ORDER_ID
					pstmt_insert.setString(++count, order_type);			// ORDER_TYPE_CODE
					pstmt_insert.setString(++count, "PH");					//ORDER_CATEGORY
					pstmt_insert.setString(++count, "PH");					//CONTR_SYS_ID
					pstmt_insert.setString(++count, patient_id);			//PATIENT_ID
					pstmt_insert.setString(++count, patient_class);			//PATIENT_CLASS
					pstmt_insert.setString(++count, login_facility_id);		//ORDERING_FACILITY_ID
					pstmt_insert.setString(++count, encounter_id);			//ENCOUNTER_ID
					pstmt_insert.setString(++count, encounter_id);			//EPISODE_ID
					pstmt_insert.setString(++count, "");					//EPISODE_VISIT_NUM
					pstmt_insert.setString(++count, locn_type);			//SOURCE_TYPE
					pstmt_insert.setString(++count, locn_code);			//SOURCE_CODE
					pstmt_insert.setString(++count, take_home);				//DISCHARGE_IND   -- //RUT-CRF-0062
					//DISCHARGE_IND

					//date conversion done for IN26623 --23/02/2011-- sandhya
					if(!lang_id.equals("en") && i==0){
						 sys_date = com.ehis.util.DateUtils.convertDate(sys_date, "DMYHM",lang_id,"en");
					}
					pstmt_insert.setString(++count, sys_date);			//ORD_DATE_TIME
					pstmt_insert.setString(++count, pract_id);			//ORD_PRACT_ID
					pstmt_insert.setString(++count, priority);		//PRIORITY
					pstmt_insert.setString(++count, "N");				//ORD_AUTH_REQD_YN
					pstmt_insert.setString(++count, "");					//ORD_AUTH_LEVEL
					//pstmt_insert.setString(++count, pract_id);			//ORD_AUTH_BY_PRACT_ID
					pstmt_insert.setString(++count, "");			//ORD_AUTH_BY_PRACT_ID
					pstmt_insert.setString(++count, null);			// ORD_AUTH_DATE_TIME sys_date
					pstmt_insert.setString(++count, "N");				//ORD_APPR_REQD_YN
					pstmt_insert.setString(++count, "");					//ORD_APPR_BY_USER_ID
					pstmt_insert.setString(++count, null);				//ORD_APPR_DATE_TIME
					pstmt_insert.setString(++count, "N");				//ORD_COSIGN_REQD_YN
					pstmt_insert.setString(++count, "");					//ORD_COSIGN_LEVEL
					pstmt_insert.setString(++count, "");					//ORD_COSIGN_BY_PRACT_ID
					pstmt_insert.setString(++count, null);				//ORD_COSIGN_DATE_TIME
					pstmt_insert.setString(++count, null);				//ORD_PRINT_DATE_TIME
					pstmt_insert.setString(++count, "N");				//BILL_YN
					pstmt_insert.setString(++count, "CO");				//CONT_ORDER_IND
					pstmt_insert.setString(++count, per_facility_id);	//PERFORMING_FACILITY_ID
					pstmt_insert.setString(++count, "PH");				//PERFORMING_SYS_ID
					pstmt_insert.setString(++count, perf_locn_type);		//PERFORMING_DEPTLOC_TYPE
					pstmt_insert.setString(++count, perf_locn_code);		//PERFORMING_DEPTLOC_CODE
					pstmt_insert.setString(++count, pract_id);			//PERFORMING_PRACT_ID
					pstmt_insert.setString(++count, "N");				//RESULT_AUTH_REQD_YN
					pstmt_insert.setString(++count, "N");				//CHILD_ORDER_YN
					pstmt_insert.setString(++count, "");					//PARENT_ORDER_ID
					pstmt_insert.setString(++count, "N");				//ORDER_SET_YN
					pstmt_insert.setString(++count, "");					//ORDER_SET_ID
					pstmt_insert.setString(++count, "5");					//IV_PREP_YN (continuous)
					pstmt_insert.setString(++count, "");					//ORDER_FIELDS_DISPLAY_TEXT
					pstmt_insert.setString(++count, "OS");				//ORDER_STATUS
					pstmt_insert.setString(++count, "");					//RESULT_STATUS
					pstmt_insert.setString(++count, login_by_id);		//ADDED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no);		//ADDED_AT_WS_NO
					pstmt_insert.setString(++count, login_facility_id);	//ADDED_FACILITY_ID
					pstmt_insert.setString(++count, login_by_id);		//MODIFIED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no);		//MODIFIED_AT_WS_NO
					pstmt_insert.setString(++count, login_facility_id);	//MODIFIED_FACILITY_ID
					pstmt_insert.setString(++count, (String)record.get("CONSENT_REQD_YN"));				//ORD_CONSENT_REQD_YN
					pstmt_insert.setString(++count, "");					//ORD_CONSENT_BY_ID
					pstmt_insert.setString(++count, null);				//ORD_CONSENT_BY_DATE_TIME
					pstmt_insert.setString(++count, "");				//CAN_REASON
					pstmt_insert.setString(++count,trn_group_ref);				//CAN_REASON
					pstmt_insert.addBatch();
				}
				closeResultSet( resultSet ) ;
				int[] batch_result1 = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result1.length;i++ ) {
					if (batch_result1[i]<0  && batch_result1[i] != -2) {
						pstmt_insert.cancel();
						System.err.println("IV_FLUID--> ERROR IN INSERTING OR_ORDER UPDATION batch_result1["+i+"]= "+batch_result1[i]);
						System.err.println("tabData=== "+tabData);
						throw new Exception("OR ORDER Failed");
					}
				}
				closeStatement( pstmt_insert );
				// OR_ORDER_LINE FOR FLUID
				String short_desc	=	"";
				pstmt_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT2"));
				MFR_Recs = new HashMap();
				for(int i=0; i<AllFluids.size(); i++ ) {
					count		=	0;
					record		=	(HashMap)AllFluids.get(i);				
					order_id	=	(String)record.get("ORDER_ID");

					// order qty calculation
					int duration	= 0;
					//float dur1		= ((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100 ;
					float dur1 = 0.0f;
					MFR_Recs = (HashMap)record.get("MFR_Recs");
					if(MFR_Recs != null && MFR_Recs.size() > 0){
						dur1 = 1.0f; //bcoz duration(sum flow duration) and infuse_over(Sum) value wil be same.
					}
					else{
						if(iv_calc_infuse_by.equals("I")) //if block & else condition added for SKR-CRF-0035 [IN:037727] 
							dur1 = 1.0f;
						else{
							duration	= Integer.parseInt((String)record.get("DURN_VALUE"));
							dur1 = Float.parseFloat(Math.ceil(((duration / Float.parseFloat((String)record.get("INFUSE_OVER")))*100)/100)+"") ;//Math.ceil added for SKR-SCF-1397
						}
					}
					float order_qty	= Float.parseFloat((Math.ceil(Float.parseFloat((String)record.get("QTY_VALUE")) / Float.parseFloat((String)record.get("FLUID_PACK_SIZE")))*dur1)+"");									
					if( ((String)record.get("SHORT_DESC")).length() > 39)
						short_desc	=	((String)record.get("SHORT_DESC")).substring(0,39);
					else
						short_desc	=	((String)record.get("SHORT_DESC"));

					pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
					pstmt_select.setString(2, lang_id);
					resultSet	= pstmt_select.executeQuery();
					if (resultSet.next()) {
						order_uom	=	(resultSet.getString("STOCK_UOM"));
					}
					order_uoms.add(order_uom);
					closeResultSet( resultSet );
					
					pstmt_insert.setString(++count, order_id);								// ORDER_ID
					pstmt_insert.setString(++count, "1");									// ORDER_LINE_NUM
					pstmt_insert.setString(++count, (String)record.get("DRUG_CODE"));			//ORDER_CATALOG_CODE
					pstmt_insert.setString(++count, short_desc);								//CATALOG_DESC
					pstmt_insert.setString(++count, short_desc);								//CATALOG_SYNONYM
					pstmt_insert.setString(++count, "");										//ORDER_CATALOG_NATURE
					pstmt_insert.setString(++count, (String)record.get("ORDER_TYPE_CODE"));	//ORDER_TYPE_CODE
					pstmt_insert.setString(++count, "PH");									//ORDER_CATEGORY
					pstmt_insert.setString(++count, sys_date);								//ORD_DATE_TIME
					pstmt_insert.setString(++count, priority);							//PRIORITY
					pstmt_insert.setString(++count, "N");									//ORD_AUTH_REQD_YN
					pstmt_insert.setString(++count, "");										//ORD_AUTH_REASON
					pstmt_insert.setString(++count, "N");									//ORD_APPR_REQD_YN
					pstmt_insert.setString(++count, "N");									//ORD_COSIGN_REQD_YN
					pstmt_insert.setString(++count, (String)record.get("START_DATE"));		//START_DATE_TIME
					pstmt_insert.setString(++count, (String)record.get("FORM_CODE"));		//FORM_CODE
					pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));		//ROUTE_CODE
					pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));		// QTY_VALUE
					pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));			//QTY_UOM
					pstmt_insert.setString(++count, freq_code);								//FREQ_CODE
				
					if(MFR_Recs != null && MFR_Recs.size() > 0){
						pstmt_insert.setString(++count, (String)MFR_Recs.get("totFlowDurnHrs"));	
					}
					else{
						pstmt_insert.setString(++count, (String)record.get("DURN_VALUE"));		//DURN_VALUE
					}
					pstmt_insert.setString(++count, "H"); //REVERTED for SKR-SCF-1334
					//pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER_UNIT_SCH"));//DURN_TYPE - COMMENTED for SKR-SCF-1334
					pstmt_insert.setString(++count, "");										//LINE_FIELDS_DISPLAY_TEXT
					pstmt_insert.setString(++count, "");									//ITEM_NARRATION				
					pstmt_insert.setString(++count, null);								//NEXT_SCHED_DATE
					pstmt_insert.setString(++count, (String)record.get("END_DATE"));		//END_DATE
					pstmt_insert.setString(++count, null);								//AUTO_STOP_DATE_TIME
					pstmt_insert.setString(++count, Math.ceil(order_qty)+"");						//ORDER_QTY
					pstmt_insert.setString(++count, order_uom);		                     //ORDER_UOM
					pstmt_insert.setString(++count, "N");								//APPT_REQD_YN
					pstmt_insert.setString(++count, null);								//APPT_DATE_TIME
					pstmt_insert.setString(++count, "");				//APPT_REF_NUM
					pstmt_insert.setString(++count, "N");			//RESULT_APPLICABLE_YN
					pstmt_insert.setString(++count, "N");			//BILL_YN
					pstmt_insert.setString(++count, "N");			//BILLED_YN
					pstmt_insert.setString(++count, "CO");			//CONT_ORDER_IND
					pstmt_insert.setString(++count, "N");			//REFILL_SINGLE_CONT_ORDER_YN
					pstmt_insert.setString(++count, "");				//NUM_OF_REFILLS
					pstmt_insert.setString(++count, "N");			//CHILD_ORDER_YN
					pstmt_insert.setString(++count, "");				//PARENT_ORDER_ID
					pstmt_insert.setString(++count, "");				//PARENT_ORDER_LINE_NUM
					pstmt_insert.setString(++count, "");				//ORDER_SET_ID
					pstmt_insert.setString(++count, "");				//ORDER_SET_LINE_NUM
					pstmt_insert.setString(++count, pract_id);		//ORD_PRACT_ID
					pstmt_insert.setString(++count, null);			//ORD_SET_DATE_TIME
					pstmt_insert.setString(++count, "");				//AMD_PRACT_ID
					pstmt_insert.setString(++count, null);			//AMD_DATE_TIME
					pstmt_insert.setString(++count, "");				//HOLD_PRACT_ID
					pstmt_insert.setString(++count, null);			//HOLD_DATE_TIME
					pstmt_insert.setString(++count, "");				//RESUME_PRACT_ID
					pstmt_insert.setString(++count, null);			//RESUME_DATE_TIME
					pstmt_insert.setString(++count, "");				//DISC_PRACT_ID		
					pstmt_insert.setString(++count, null);			//DISC_DATE_TIME
					pstmt_insert.setString(++count, "");				//CAN_PRACT_ID
					pstmt_insert.setString(++count, null);			//CAN_DATE_TIME
					pstmt_insert.setString(++count, "");				//ACCESSION_NUM
					pstmt_insert.setString(++count, "");				//ACCESSION_LINE_NUM
					pstmt_insert.setString(++count, "OS");			//ORDER_LINE_STATUS
					pstmt_insert.setString(++count, "");				//RESULT_LINE_STATUS
					pstmt_insert.setString(++count, login_by_id);	//ADDED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no); //ADDED_AT_WS_NO
					pstmt_insert.setString(++count, login_facility_id); //ADDED_FACILITY_ID
					pstmt_insert.setString(++count, login_by_id);		//MODIFIED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no);		//MODIFIED_AT_WS_NO
					pstmt_insert.setString(++count, login_facility_id);	//MODIFIED_FACILITY_ID
					pstmt_insert.setString(++count, (String)record.get("CONSENT_REQD_YN"));				//ORD_CONSENT_REQD_YN
					pstmt_insert.setString(++count, "");					//CAN_LINE_REASON
					pstmt_insert.setString(++count, short_desc);			//CATALOG_SYNONYM_DC
					pstmt_insert.setString(++count, short_desc);			//CATALOG_SYNONYM_AD
					pstmt_insert.setString(++count, "N");				//RESULT_AUTH_REQD_YN
					pstmt_insert.setString(++count, (String)record.get("CONSENT_STAGE"));				//CONSENT_STAGE
					pstmt_insert.setString(++count, (String)record.get("CONSENT_STATUS"));				//CONSENT_STATUS
					pstmt_insert.setString(++count, (String)record.get("NUM_OF_CONSENT_REQ_BO"));		//NUM_OF_CONSENT_REQ_BO
					pstmt_insert.setString(++count, (String)record.get("NUM_OF_CONSENT_REQ_BR"));		//NUM_OF_CONSENT_REQ_BR
					pstmt_insert.addBatch();
				}
				int[] batch_result2 = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result2.length;i++ ) {
					if (batch_result2[i]<0  && batch_result2[i] != -2) {
						pstmt_insert.cancel();
						System.err.println("IV_FLUID--> ERROR IN INSERTING OR_ORDER_LINE UPDATION batch_result2["+i+"]= "+batch_result2[i]);
						System.err.println("tabData=== "+tabData);
						throw new Exception("OR ORDER LINE Failed");
					}
				}
				closeStatement( pstmt_insert );

				// OR_ORDER_LINE_PH
				String  pres_base_uom, qty_unit, equl_value, qty_value1, in_pres_qty_value, interval_value, repeat_value, dosage_type, freq_nature, durn_value;
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT3A"));
				PreparedStatement pstmt_get_MARBarcodeId	= connection.prepareStatement(sql_ph_gen_MARDarcodeId) ; //added for  MMS-QH-CRF-0080 [IN:038064]
				System.out.println("403pstmt_insert"+(String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT3A"));
				for(int i=0; i<AllFluids.size(); i++ ) {
					record		=	(HashMap)AllFluids.get(i);		
					count		=	0;
					order_id		=	(String)record.get("ORDER_ID");
					//buildMAR_yn		=	(String)record.get("BUILD_MAR_YN")==null?"Y":(String)record.get("BUILD_MAR_YN"); RUT-CRF-0062 Commented. BUILD_MAR_YN Value will be inserted based on the first fluid selected
					MFR_YN = "N";
					MFR_Recs = new HashMap();
					MFR_Recs = (HashMap)record.get("MFR_Recs");
					if(MFR_Recs != null && MFR_Recs.size() > 0)
						MFR_YN = "Y";

					// order qty calculation
					int duration				= 0;
					float total_duration		= 0.0f;
					if(MFR_YN.equals("Y")|| iv_calc_infuse_by.equals("I")){ // iv_calc_infuse_by condition added for SKR-CRF-0035 [IN:037727] 
						total_duration		= 1.0f;
					}
					else{
						duration	=		Integer.parseInt((String)record.get("DURN_VALUE"));
						total_duration		= Float.parseFloat(Math.ceil(((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100)+"") ;//Math.ceil added for SKR-SCF-1420
					}
					float tot_qty				= (Float.parseFloat((String)record.get("QTY_VALUE"))*total_duration);
					//float order_qty				= Float.parseFloat(Math.ceil( tot_qty/ Float.parseFloat((String)record.get("FLUID_PACK_SIZE")))+"");//commented for SKR-SCF-1420
					
					float order_qty	= Float.parseFloat((Math.ceil(Float.parseFloat((String)record.get("QTY_VALUE")) / Float.parseFloat((String)record.get("FLUID_PACK_SIZE")))*total_duration)+"");						

					float total_strength		= 0.0f;
					if(!((String)record.get("STRENGTH_VALUE")).equals("") && !((String)record.get("STRENGTH_VALUE")).equals("0")) {
						total_strength		= (Float.parseFloat((String)record.get("STRENGTH_VALUE"))*total_duration);
					}

					pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
					resultSet	= pstmt_select.executeQuery();
					if (resultSet.next()) {
						order_uom	=	(resultSet.getString("STOCK_UOM"));
					}
					closeResultSet( resultSet );

					pstmt_insert.setString(++count, order_id);							//ORDER_ID
					pstmt_insert.setString(++count, "1");							//ORDER_LINE_NUM
					pstmt_insert.setString(++count, (String)record.get("GENERIC_ID"));	//GENERIC_ID
					pstmt_insert.setString(++count, (String)record.get("FORM_CODE"));		//FORM_CODE
					pstmt_insert.setString(++count, ""); //TRADE_CODE
					if(record.get("IN_FORMULARY_YN")!=null && !((String)record.get("IN_FORMULARY_YN")).equals("")){
						pstmt_insert.setString(++count, (String)record.get("IN_FORMULARY_YN"));
					}
					else{
						pstmt_insert.setString(++count, "N");											//FORMULARY_ITEM_YN
					}
					pstmt_insert.setString(++count, (String)record.get("DOSAGE_TYPE"));				//DOSAGE_TYPE
					pstmt_insert.setString(++count, "");											//SPLIT_DRUG_PREVIEW
					pstmt_insert.setString(++count, (Math.ceil(total_strength)+""));		//TOT_STRENGTH
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));					//TOT_STRENGTH_UOM

					if(MFR_YN.equals("Y")){
						pstmt_insert.setString(++count,""); //INFUSE_OVER
						pstmt_insert.setString(++count,"");
						pstmt_insert.setString(++count,""); //INFUSION_RATE
						pstmt_insert.setString(++count,""); //INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(++count,"");
					}
					else{
						pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER"));				//INFUSE_OVER
						pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));											//INFUSE_OVER_UNIT
						pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE"));			//INFUSION_RATE
						pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));					//INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER_UNIT"));//INFUSION_PER_UNIT
					}
					pstmt_insert.setString(++count, "N");				//BROUGHT_BY_PATIENT_YN
					pstmt_insert.setString(++count, "N");				//CUR_DRUG_YN
					pstmt_insert.setString(++count, "N");				//REFILL_DRUG_YN
					pstmt_insert.setString(++count, "");					//DISPENSING_LOC_TYPE
					pstmt_insert.setString(++count, "");					//DISPENSING_LOC
					pstmt_insert.setString(++count, "");					//DISPENSING_STORE
					pstmt_insert.setString(++count, "");					//IP_FILL_PROCESS
					pstmt_insert.setString(++count, "");					//IP_FILL_PRD_AHEAD
					pstmt_insert.setString(++count, null);				//NEXT_FILL_DATE
					pstmt_insert.setString(++count, "");					//LAST_FILL_QTY
					pstmt_insert.setString(++count, "");					//DISPENSED_QTY
					pstmt_insert.setString(++count, Math.ceil(order_qty)+"");			//BMS_QTY
					pstmt_insert.setString(++count, (Math.ceil(total_strength)+""));		//BMS_STRENGTH	
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, "N");								//SPLIT_DOSE_YN
					pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));	//QTY_VALUE_SPLIT_DOSE
					pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));		//QTY_UNIT_SPLIT_DOSE
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE"));	//STRENGTH_VALUE
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));		//STRENGTH_UOM
					pstmt_insert.setString(++count, Math.ceil(tot_qty)+"");				//PRES_QTY_VALUE
					pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));	//PRES_QTY_UOM
					pstmt_insert.setString(++count, ""); //ALLERGY_OVERRIDE_REASON
					pstmt_insert.setString(++count, ""); //DOSAGE_LIMIT_OVERRIDE_REASON
					pstmt_insert.setString(++count, ""); //DUPLICATE_DRUG_OVERRIDE_REASON
					if(MFR_YN.equals("Y") ){ 
						pstmt_insert.setString(++count, (String)MFR_Recs.get("totFlowDurnHrs")); //TOT_INFUSION_OVER
					}
					else{
						pstmt_insert.setString(++count, (String)record.get("DURN_VALUE")); //TOT_INFUSION_OVER
					}
					pstmt_insert.setString(++count, "H"); //TOT_INFUSION_OVER_UNIT
					pstmt_insert.setString(++count, "");  //ADMIN_RATE
					pstmt_insert.setString(++count, "");  //CHANGED FLUID REMARKS 	
					pstmt_insert.setString(++count, (String)record.get("BL_INCL_EXCL_OVERRIDE_VALUE"));  //BL_INCL_EXCL_OVERRIDE_VALUE 	
					pstmt_insert.setString(++count, (String)record.get("BL_INCL_EXCL_OVERRIDE_REASON"));  //BL_INCL_EXCL_OVERRIDE_REASON 	
					pstmt_insert.setString(++count, buildMAR_yn);  //BUILDMAR_YN	
					pstmt_insert.setString(++count, MFR_YN);  //MFR_YN	
					pstmt_insert.setString(++count, (String)record.get("MFR_REMARKS"));  //MFR_REMARKS
					if(MFR_YN.equals("Y")){
						pstmt_insert.setString(++count,""); //ORIG_INFUSE_OVER
						pstmt_insert.setString(++count,""); //ORIG_INFUSION_RATE
					}
					else{
						pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER"));				//ORIG_INFUSE_OVER
						pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE"));			//ORIG_INFUSION_RATE
					}
					pstmt_insert.setString(++count, (String)record.get("DRUG_INDICATION"));			//ORIG_INFUSION_RATE
					pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE"));			//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_RATE
					pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));			//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_QTY_UNIT
					if(buildMAR_yn.equals("Y") && print_mar_label.equals("Y") &&  print_mar_barcode.equals("Y")){ //added for  MMS-QH-CRF-0080 [IN:038064] -start
						pstmt_get_MARBarcodeId.setString(1,login_facility_id);
						resultSet = pstmt_get_MARBarcodeId.executeQuery();
						if(resultSet!=null && resultSet.next())
							MAR_barcode_id = resultSet.getString("MAR_BARCODE_ID");
					}
					record.put("MAR_BARCODE_ID",MAR_barcode_id);
					pstmt_insert.setString(++count,MAR_barcode_id);//added for MMS-QH-CRF-0080 [IN:038064] -end
					pstmt_insert.setString(++count,(String)record.get("allow_alternate"));
					pstmt_insert.setString(++count, (String)record.get("ABUSE_EXISTS")==null ?"" :(String)record.get("ABUSE_EXISTS"));//added for AAKH-CRF-0140
					pstmt_insert.setString(++count, (String)record.get("abuse_override_remarks")==null ?"" :(String)record.get("abuse_override_remarks"));//added for AAKH-CRF-0140

					pstmt_insert.addBatch();//need to add
				}
				int[] batch_result3 = pstmt_insert.executeBatch();

				for (int i=0;i<batch_result3.length;i++ ) {
					if (batch_result3[i]<0  && batch_result3[i] != -2) {
						pstmt_insert.cancel();
						System.err.println("IV_FLUID--> ERROR IN INSERTING OR_ORDER_LINE_PH UPDATION batch_result3["+i+"]= "+batch_result3[i]);
						System.err.println("tabData=== "+tabData);
						throw new Exception("OR ORDER LINE PH Failed");
					}
				}
				closeStatement( pstmt_insert );
				closeStatement( pstmt_get_MARBarcodeId) ; //added for MMS-QH-CRF-0080 [IN:038064]
				// PH_PATIENT_DRUG_PROFILE FLUID

				pstmt_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT4"));
				int srl_NO			= 0;
				String diag_text	= "";

				if(diag_Text.size()>0) {
					diag_text = (String)diag_Text.get(3)+"~"+(String)diag_Text.get(7)+"~"+(String)diag_Text.get(11);
				}

				pstmt_select_2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT55"));
				pstmt_select_2.setString(1, patient_id);						
				resultSet		= pstmt_select_2.executeQuery();
				if(resultSet.next()) {
					srl_NO = resultSet.getInt("NEXT_SRL_NO");
				}
				
				closeResultSet( resultSet );
				closeStatement( pstmt_select_2 );

				pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));
				pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));

				for(int i=0; i<AllFluids.size(); i++ ) {
					System.out.println("575 SQL_PH_PRESCRIPTION_INSERT4");
					record		=	(HashMap)AllFluids.get(i);	
					count		=	0;
					diag_text	= "";
					order_id	=	(String)record.get("ORDER_ID"); 
					MFR_YN = "N";
					MFR_Recs = new HashMap();
					MFR_Recs = (HashMap)record.get("MFR_Recs");
					if(MFR_Recs != null && MFR_Recs.size() > 0)
						MFR_YN = "Y";
					// order qty calculation
					int duration				= 0;
					order_uom=(String)order_uoms.get(i);
					if(i> 0) {
						++srl_NO;
					} 
					/* ==========prescribe_qunaty calculation======================== */
					pres_base_uom					=(String)record.get("PRES_BASE_UOM");
					qty_unit						=(String)record.get("PRES_QTY_UOM");
					equl_value					=null;
					qty_value1					="";
					in_pres_qty_value				=null;
					interval_value				=null;
					repeat_value					=null;
					dosage_type							="Q";
					qty_value1							=(String)record.get("QTY_VALUE");
					freq_nature="C";
					durn_value					=(String)record.get("DURN_VALUE");
					if(MFR_YN.equals("Y") || iv_calc_infuse_by.equals("I")){ // iv_calc_infuse_by condition added for SKR-CRF-0035 [IN:037727] 
						durn_value = "1";
					}
					else{
						duration = Integer.parseInt((String)record.get("DURN_VALUE"));
						durn_value                   = String.valueOf(Math.ceil(((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100)+""); //Math.ceil added for SKR-SCF-1397
					}
					pstmt_select3.setString(1, freq_code);
					resultSet		= pstmt_select3.executeQuery();

					if(resultSet.next()) {
						interval_value = resultSet.getString("interval_value");
						repeat_value   = resultSet.getString("repeat_value");
					}
					closeResultSet( resultSet );
					if(interval_value == null) 
						interval_value="1";
					if(repeat_value == null || freq_nature.equals("C")) 
						repeat_value="1";				

					if(dosage_type!=null && dosage_type.equals("Q")){
						equl_value	=	"1";
						pstmt_select.setString(1,pres_base_uom);
						pstmt_select.setString(2,qty_unit);
						pstmt_select.setString(3,pres_base_uom);
						pstmt_select.setString(4,qty_unit);
						resultSet	= pstmt_select.executeQuery();
						if ( resultSet != null && resultSet.next() ) {
							equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}
						closeResultSet( resultSet );
						float ord_qty=0.0f;			   

						if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
							ord_qty		=	(Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));

							if(ord_qty==0)
								ord_qty	=	1;
						}
						in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));
					}

					pstmt_insert.setString(++count, patient_id);				//PATIENT_ID
					pstmt_insert.setString(++count, srl_NO + "");				//SRL_NO
					pstmt_insert.setString(++count, login_facility_id);			//FACILITY_ID
					pstmt_insert.setString(++count, encounter_id);				//ENCOUNTER_ID
					pstmt_insert.setString(++count, patient_class);				//PATIENT_CLASS
					pstmt_insert.setString(++count, locn_type);					//LOCN_TYPE
					pstmt_insert.setString(++count, locn_code);					//LOCN_CODE
					pstmt_insert.setString(++count, "");						 // room_type
					pstmt_insert.setString(++count, (String)record.get("ROOM_NUM"));	// room no
					pstmt_insert.setString(++count, (String)record.get("BED_NUM"));		// bed no
					pstmt_insert.setString(++count, "");						// bed class
					pstmt_insert.setString(++count, "");						// bed type
					pstmt_insert.setString(++count, "");						// speciality code
					pstmt_insert.setString(++count, pract_id);					// attend practioner
					pstmt_insert.setString(++count, pract_id);					// pres practitioner
					pstmt_insert.setString(++count, (String)record.get("DRUG_CODE"));  //DRUG_CODE
					pstmt_insert.setString(++count, (String)record.get("GENERIC_ID"));  //GENERIC_ID
					pstmt_insert.setString(++count, (String)record.get("START_DATE"));		//START_DATE
					pstmt_insert.setString(++count, (String)record.get("END_DATE"));		//END_DATE
					pstmt_insert.setString(++count, "N");		//SPLIT_YN
					pstmt_insert.setString(++count, "N");		//TAPERED_YN
					if( !((String)record.get("STRENGTH_VALUE")).equals("") && !((String)record.get("STRENGTH_VALUE")).equals("0")) {
						pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE"));	//STRENGTH
						pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));		//STRENGTH_UOM_CODE
					} 
					else {
						pstmt_insert.setString(++count, "");	//STRENGTH
						pstmt_insert.setString(++count, "");		//STRENGTH_UOM_CODE
					//	in_pres_qty_value = String.valueOf(Float.parseFloat(in_pres_qty_value) / Float.parseFloat((String)record.get("FLUID_PACK_SIZE")));
					}
					pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));	//DOSAGE
					pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));		//DOSAGE_UOM_CODE
					pstmt_insert.setString(++count, "");				//SPLIT_DOSE_PREVIEW
					pstmt_insert.setString(++count, freq_code);							//FREQ_CODE 
					
					if(MFR_YN.equals("Y") ){ 
						pstmt_insert.setString(++count, (String)MFR_Recs.get("totFlowDurnHrs"));  //DURATION
					}
					else
						pstmt_insert.setString(++count, (String)record.get("DURN_VALUE"));  //DURATION

					pstmt_insert.setString(++count, in_pres_qty_value+"");						//PRESCRIBED_QTY
					pstmt_insert.setString(++count, diag_text);  //DIAG_TEXT
					pstmt_insert.setString(++count, ""); // drug remarks				
					pstmt_insert.setString(++count, "N"); //IV_PREP_YN
					if(MFR_YN.equals("Y")){
						pstmt_insert.setString(++count,""); //INFUSE_OVER
						pstmt_insert.setString(++count,"");
						pstmt_insert.setString(++count,""); //INFUSION_RATE
						pstmt_insert.setString(++count,""); //INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(++count,"");
					}
					else{
						pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER")); //INFUSE_OVER
						pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));
						pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE")); //INFUSION_RATE
						pstmt_insert.setString(++count, (String)record.get("QTY_UOM")); //INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT_SCH")==null?"H":(String)record.get("INFUSE_OVER_UNIT_SCH"));  // infusion per unit	
					}
					pstmt_insert.setString(++count, "N"); // amend_yn
					pstmt_insert.setString(++count, ""); // amend by id
					pstmt_insert.setString(++count, null); // amend_date
					pstmt_insert.setString(++count, "N");  // cancel yn
					pstmt_insert.setString(++count, "");  // cancel by id
					pstmt_insert.setString(++count, null); // cancel date
					pstmt_insert.setString(++count, "P"); //TRN_TYPE_IND 
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, order_id); // orig order id
					pstmt_insert.setString(++count, "1");  // line no
					pstmt_insert.setString(++count, "");  // tot issued qty
					pstmt_insert.setString(++count, "N"); //BROUGHT_BY_PATIENT_YN
					pstmt_insert.setString(++count, null); //ON_HOLD_DATE_TIME
					pstmt_insert.setString(++count, ""); //ON_HOLD_BY_ID
					pstmt_insert.setString(++count, ""); //ON_HOLD_REASON_CODE 
					pstmt_insert.setString(++count, null); //DISCONT_DATE_TIME
					pstmt_insert.setString(++count, ""); //DISCONT_BY_ID 
					pstmt_insert.setString(++count, ""); //DISCONT_REASON_CODE
					pstmt_insert.setString(++count, "N"); //STOP_YN
					pstmt_insert.setString(++count, null); //STOP_DATE_TIME
					pstmt_insert.setString(++count, ""); //STOP_PRACTIONER_ID
					pstmt_insert.setString(++count, ""); //STOP_REMARKS
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));  //ROUTE_CODE
					pstmt_insert.setString(++count, ""); //ALLERGY_OVERRIDE_REASON
					pstmt_insert.setString(++count, ""); //DOSAGE_LIMIT_OVERRIDE_REASON
					pstmt_insert.setString(++count, ""); //IV_INGREDIENTS
					pstmt_insert.setString(++count, "H");   //DURN_TYPE
					pstmt_insert.setString(++count, ""); //DISPENSED_DRUGS
					pstmt_insert.setString(++count, ""); //ALTERNATE_GENERIC_ID
					pstmt_insert.setString(++count, ""); //DISP_REMARKS 
					pstmt_insert.setString(++count, ""); //CURRENTRX_REMARKS 
					pstmt_insert.setString(++count, "N"); //REFILL_YN 
					pstmt_insert.setString(++count, (String)record.get("FORM_CODE")); //FORM_CODE
					//DIAG_CODES
					if(diag_Text.size()>0) {
						pstmt_insert.setString(++count, (String)diag_Text.get(0));
						pstmt_insert.setString(++count, (String)diag_Text.get(1));
						pstmt_insert.setString(++count, (String)diag_Text.get(2));
						pstmt_insert.setString(++count, (String)diag_Text.get(4));
						pstmt_insert.setString(++count, (String)diag_Text.get(5));
						pstmt_insert.setString(++count, (String)diag_Text.get(6));
						pstmt_insert.setString(++count, (String)diag_Text.get(8));
						pstmt_insert.setString(++count, (String)diag_Text.get(9));
						pstmt_insert.setString(++count, (String)diag_Text.get(10));
					} 
					else {
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
					}

					//pstmt_insert.setString(++count, (String)record.get("DOSAGE_TYPE")); //PRESCRIBED_MODE
					pstmt_insert.setString(++count, "Q"); //PRESCRIBED_MODE
					pstmt_insert.setString(++count, height);
					pstmt_insert.setString(++count, height_uom);
					pstmt_insert.setString(++count, weight);
					pstmt_insert.setString(++count, weight_uom);
					pstmt_insert.setString(++count, bsa);
					pstmt_insert.setString(++count, allergic_yn);
					pstmt_insert.setString(++count, bmi);
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, (String)record.get("ABUSE_EXISTS")==null ?"" :(String)record.get("ABUSE_EXISTS"));//added for AAKH-CRF-0140
					pstmt_insert.setString(++count, (String)record.get("abuse_override_remarks")==null ?"" :(String)record.get("abuse_override_remarks"));//added for AAKH-CRF-0140

					pstmt_insert.addBatch();
				}
				closeStatement( pstmt_select3 );
				closeStatement( pstmt_select );

				int[] batch_result4 = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result4.length; i++ ) {
					if (batch_result4[i]<0  && batch_result4[i] != -2) {
						pstmt_insert.cancel();
						System.err.println("IV_FLUID--> ERROR IN INSERTING PH_PATIENT_DRUG_PROFILE UPDATION batch_result4["+i+"]= "+batch_result4[i]);
						System.err.println("tabData=== "+tabData);
						throw new Exception("PATIENT DRUG PROFILE Failed");
					}
				}
				closeStatement( pstmt_insert );

				//inserting into OR_ORDER_LINE_PH_MFR
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));
				for(int i=0; i<AllFluids.size(); i++ ) {
					record		=	(HashMap)AllFluids.get(i);	
					order_id	=	(String)record.get("ORDER_ID"); 
					String totRecs = "0";
					MFR_Recs = new HashMap();
					MFR_Recs = (HashMap)record.get("MFR_Recs");
					if(MFR_Recs != null && MFR_Recs.size() > 0)
						totRecs = (String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec");
					ArrayList rec = new ArrayList();
					//int ins=0;
					for(int k=1; k<= Integer.parseInt(totRecs); k++){
						rec	= (ArrayList)MFR_Recs.get("MFR"+k);
						pstmt_insert.setString(1, order_id); // ORDER_ID
						pstmt_insert.setString(2, "1"); //ORDER_LINE_NUM
						pstmt_insert.setString(3, k+""); //SL_NO
						pstmt_insert.setString(4, (String)rec.get(0)); //TOT_STRENGTH - volume
						pstmt_insert.setString(5, (String)record.get("QTY_UOM")); //TOT_STRENGTH_UOM
						pstmt_insert.setString(6, (String)rec.get(5)); //INFUSE_OVER
						pstmt_insert.setString(7, "H"); //INFUSE_OVER_UNIT
						pstmt_insert.setString(8, (String)rec.get(1)); //INFUSION_RATE
						pstmt_insert.setString(9, (String)record.get("QTY_UOM")); //INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(10, (String)rec.get(2)); //INFUSION_PER_UNIT
						pstmt_insert.setString(11,(String)rec.get(10) ); //GAP_DURATION_IN_HRS
						pstmt_insert.setString(12, ""); //ADMIN_RATE_DETAIL

						pstmt_insert.setString(13, com.ehis.util.DateUtils.convertDate((String)rec.get(6),"DMYHM",lang_id,"en")); //START_DATE_TIME
						pstmt_insert.setString(14, com.ehis.util.DateUtils.convertDate((String)rec.get(7),"DMYHM",lang_id,"en")); //END_DATE_TIME
						pstmt_insert.setString(15, login_by_id); //ADDED_BY_ID
						pstmt_insert.setString(16, login_at_ws_no); //ADDED_AT_WS_NO
						pstmt_insert.setString(17, login_facility_id); //ADDED_FACILITY_ID
						pstmt_insert.setString(18, login_by_id); //MODIFIED_BY_ID
						pstmt_insert.setString(19, login_at_ws_no); //MODIFIED_AT_WS_NO
						pstmt_insert.setString(20, login_facility_id); // MODIFIED_FACILITY_ID
						pstmt_insert.addBatch();
					}
				}
				int[] or_order_line_ph_mfr_result = pstmt_insert.executeBatch();
				
				for (int i=0;i<or_order_line_ph_mfr_result.length;i++) {
					if(or_order_line_ph_mfr_result[i] < 0  && or_order_line_ph_mfr_result[i] != -2 ) {
						System.err.println("IV FLUIDS --> ERROR IN INSERTING  INTO OR_ORDER_LINE_PH_MFR or_order_line_ph_mfr_result["+i+"]= "+or_order_line_ph_mfr_result[i]);
						System.err.println("tabData=== "+tabData);
						result = 0;
						break;
					}
					else {
						result = 1;
					}
				}
				closeStatement(pstmt_insert);

				// PH_MEDN_ADMIN

				String verf_reqd_bef_med_admin_yn	=	"";
				ArrayList unique_drugs				= new ArrayList(4);
				ArrayList unique_orders				= new ArrayList();//added for SKR-SCF-1456
				int dosage_seqNo					=	0;
				 
				pstmt_select_2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
				pstmt_select_2.setString(1, login_facility_id);
				resultSet		= pstmt_select_2.executeQuery();
				if (resultSet.next()) {
					verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				}
				closeResultSet( resultSet );
				closeStatement( pstmt_select_2 );

				if( buildMAR_yn.equals("Y")){
					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));
					for(int i=0; i<AllFluids.size(); i++ ) {
						record		=	(HashMap)AllFluids.get(i);		
						count		=	0;
						order_id		=	(String)record.get("ORDER_ID");
						order_uom	=(String)order_uoms.get(i);
						if(buildMAR_yn.equals("Y")){
							if(!unique_drugs.contains((String)record.get("DRUG_CODE")) || !unique_orders.contains(order_id) ) { // unique_orders.contains(order_id) added for SKR-SCF-1456
								unique_drugs.add((String)record.get("DRUG_CODE"));
								unique_orders.add(order_id); //added for SKR-SCF-1456
								dosage_seqNo	=	0;
							}
							pstmt_insert.setString(++count, login_facility_id);	//FACILITY_ID
							pstmt_insert.setString(++count, encounter_id);		//ENCOUNTER_ID
							pstmt_insert.setString(++count, (String)record.get("START_DATE"));			//SCH_DATE_TIME
							pstmt_insert.setString(++count, (String)record.get("DRUG_CODE")); //ORD_DRUG_CODE
							pstmt_insert.setString(++count, ++dosage_seqNo+ "");				// DOSAGE SEQ No
							pstmt_insert.setString(++count, order_id);				//ORDER_ID
							pstmt_insert.setString(++count, "1");				// ORDER LINE NUM
							pstmt_insert.setString(++count, patient_id);				//PATIENT_ID
							pstmt_insert.setString(++count, pract_id);				//PRACT_ID
							pstmt_insert.setString(++count, "Y");					//IV_ADMIN_YN
							pstmt_insert.setString(++count, "");
							pstmt_insert.setString(++count,(String)record.get("QTY_VALUE"));			//SCH_DOSAGE_QTY
							pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));				//SCH_DOSAGE_UOM_CODE
							pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE")); //SCH_STRENGTH
							pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM")); //SCH_STRENGTH_UOM
							pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));   //SCH_ROUTE_CODE 
							pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE")); //SCH_INFUSION_RATE
							pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));		//SCH_INFUSION_VOL_STR_UNIT
							pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT_SCH")==null?"H":(String)record.get("INFUSE_OVER_UNIT_SCH"));  //SCH_INFUSION_PER_UNIT
							pstmt_insert.setString(++count, verf_reqd_bef_med_admin_yn);
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER"));
							pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));			//SCH_INFUSION_PERIOD_UNIT
							pstmt_insert.setString(++count, record.get("MAR_BARCODE_ID")==null?"":(String)record.get("MAR_BARCODE_ID")); //added for  MMS-QH-CRF-0080 [IN:038064]
							pstmt_insert.addBatch();
						}
					}
					int[] batch_result5 = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result5.length; i++ ) {

						if (batch_result5[i]<0  && batch_result5[i] != -2) {
							pstmt_insert.cancel();
							System.err.println("IV_FLUID--> ERROR IN INSERTING PH_MEDN_ADMIN UPDATION batch_result5["+i+"]= "+batch_result5[i]);
							System.err.println("tabData=== "+tabData);
							throw new Exception("PH MEDN ADMIN Failed");
						}
					}
					closeStatement( pstmt_insert );
				}

				// OR_ORDER_COMMENT
				String action_seq_num		= "";
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
				ResultSet rset_clob = null;
				for(int i=0; i<AllFluids.size(); i++ ) {
					record			=	(HashMap)AllFluids.get(i);		
					order_id		=	(String)record.get("ORDER_ID");
			
					pstmt_select.setString(1, order_id);
					resultSet		= pstmt_select.executeQuery();

					if(resultSet.next()) {
						action_seq_num = resultSet.getString(1);
					}
					closeResultSet( resultSet );

					pstmt_insert.setString(1, order_id);
					pstmt_insert.setString(2, action_seq_num);
					pstmt_insert.setString(3, login_by_id);
					pstmt_insert.setString(4, login_at_ws_no);
					pstmt_insert.setString(5, login_facility_id);
					pstmt_insert.setString(6, login_by_id);
					pstmt_insert.setString(7, login_at_ws_no);
					pstmt_insert.setString(8, login_facility_id);
					result = pstmt_insert.executeUpdate();
					if(result>0){
						pstmt_clob.setString(1,order_id);
						pstmt_clob.setString(2,action_seq_num);
						rset_clob =pstmt_clob.executeQuery();
						if(rset_clob!=null){
							while(rset_clob.next()){
								Clob clb 			= (Clob) rset_clob.getClob(1);
								BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
								bw.write(remarks,0,remarks.length());
								bw.flush();
								bw.close();
							}
						}					
						closeResultSet( rset_clob );
					}
				}
				closeStatement( pstmt_clob );
				closeStatement( pstmt_select );
				// WorkLoad Statistics			
				String dly_count				= "";
				String monthly_count			= "";
				String dly_count_loc			= "";
				String monthly_count_loc		= "";

				//int totalOrder	=	AllFluids.size();
				int totalOrder	=	1;
				int totalDrugs	=	AllFluids.size();
				
				pstmt_workload		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT72")) ;
				pstmt_workload.setString(1,pract_id);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,patient_class);

				resultSet_workload  	= pstmt_workload.executeQuery() ;

				if (resultSet_workload.next()){
					dly_count		= (resultSet_workload.getString("DLYCOUNT")).trim();				
				}
				closeResultSet( resultSet_workload );
				closeStatement( pstmt_workload );

				pstmt_workload		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT73")) ;
				pstmt_workload.setString(1,pract_id);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,patient_class);
				resultSet_workload  	= pstmt_workload.executeQuery() ;
				if (resultSet_workload.next()){
					monthly_count			=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
				}
				closeResultSet( resultSet_workload );
				closeStatement( pstmt_workload );

				// Daily Statistics 		
				if(dly_count.equals("0")) {
					workload_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT9")) ;
					workload_insert.setString( 1, pract_id);
					workload_insert.setString( 2, login_facility_id);
					workload_insert.setString( 3, patient_class);
					workload_insert.setString( 4,String.valueOf(totalOrder));
					workload_insert.setString( 5,String.valueOf(totalDrugs));
					workload_insert.setString( 6, login_by_id);
					workload_insert.setString( 7, login_at_ws_no);
					workload_insert.setString( 8, login_facility_id);
					workload_insert.setString( 9, login_by_id);
					workload_insert.setString( 10, login_at_ws_no);
					workload_insert.setString( 11, login_facility_id);
					workload_insert.executeUpdate();
				}
				else {
					workload_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY6")) ;
					workload_insert.setString( 1,String.valueOf(totalOrder));
					workload_insert.setString( 2,String.valueOf(totalDrugs));
					workload_insert.setString( 3, login_by_id);
					workload_insert.setString( 4, login_at_ws_no);
					workload_insert.setString( 5, login_facility_id);
					workload_insert.setString( 6, pract_id);
					workload_insert.setString( 7, login_facility_id);
					workload_insert.setString( 8, patient_class);
					workload_insert.executeUpdate();
				}
				closeStatement( workload_insert );

				// Monthly Statistics
				if(monthly_count.equals("0")) {
					work_insert_month		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT10")) ;
					work_insert_month.setString( 1, pract_id);
					work_insert_month.setString( 2, login_facility_id);
					work_insert_month.setString( 3, patient_class);
					work_insert_month.setString( 4,String.valueOf(totalOrder));
					work_insert_month.setString( 5,String.valueOf(totalDrugs));
					work_insert_month.setString( 6, login_by_id);
					work_insert_month.setString( 7, login_at_ws_no);
					work_insert_month.setString( 8, login_facility_id);
					work_insert_month.setString( 9, login_by_id);
					work_insert_month.setString( 10, login_at_ws_no);
					work_insert_month.setString( 11, login_facility_id);
					work_insert_month.executeUpdate();
				} 
				else {
					work_insert_month		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY7")) ;
					work_insert_month.setString( 1,String.valueOf(totalOrder));
					work_insert_month.setString( 2,String.valueOf(totalDrugs));
					work_insert_month.setString( 3, login_by_id);
					work_insert_month.setString( 4, login_at_ws_no);
					work_insert_month.setString( 5, login_facility_id);
					work_insert_month.setString( 6, pract_id );
					work_insert_month.setString( 7, login_facility_id);
					work_insert_month.setString( 8, patient_class);
					work_insert_month.executeUpdate();
				}
				closeStatement( work_insert_month );

				pstmt_workload		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT74")) ;
				pstmt_workload.setString(1,locn_type);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,locn_code);
				resultSet_workload  	= pstmt_workload.executeQuery() ;

				if (resultSet_workload.next()){
					dly_count_loc	= (resultSet_workload.getString("DLYCOUNT")).trim();				
				}

				closeResultSet( resultSet_workload );		
				closeStatement( pstmt_workload );

				pstmt_workload			= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT75")) ;
				pstmt_workload.setString(1,locn_type);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,locn_code);

				resultSet_workload  	= pstmt_workload.executeQuery() ;
				if (resultSet_workload.next()){
					monthly_count_loc		=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
				}

				closeResultSet( resultSet_workload );			
				closeStatement( pstmt_workload );

				if(dly_count_loc.equals("0")){
					work_insert_loc = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT11")) ;
					work_insert_loc.setString(1,login_facility_id);
					work_insert_loc.setString(2, locn_type);
					work_insert_loc.setString(3, locn_code);
					work_insert_loc.setString(4,String.valueOf(totalOrder));
					work_insert_loc.setString(5,String.valueOf(totalDrugs));
					work_insert_loc.setString(6, login_by_id);
					work_insert_loc.setString(7, login_at_ws_no);
					work_insert_loc.setString(8, login_facility_id);
					work_insert_loc.setString(9, login_by_id);
					work_insert_loc.setString(10, login_at_ws_no);
					work_insert_loc.setString(11, login_facility_id);
					work_insert_loc.executeUpdate();
				}
				else{
					work_insert_loc = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY8")) ;
					work_insert_loc.setString(1,String.valueOf(totalOrder));
					work_insert_loc.setString(2,String.valueOf(totalDrugs));
					work_insert_loc.setString(3, login_by_id);
					work_insert_loc.setString(4, login_at_ws_no);
					work_insert_loc.setString(5, login_facility_id);
					work_insert_loc.setString(6, locn_type);
					work_insert_loc.setString(7, login_facility_id);
					work_insert_loc.setString(8, locn_code);
					work_insert_loc.executeUpdate();
				}
				closeStatement( work_insert_loc );

				if(monthly_count_loc.equals("0"))		{
					work_insert_loc_mon =  connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT12")) ;
					work_insert_loc_mon.setString(1,login_facility_id);
					work_insert_loc_mon.setString(2, locn_type);
					work_insert_loc_mon.setString(3, locn_code);
					work_insert_loc_mon.setString(4,String.valueOf(totalOrder));
					work_insert_loc_mon.setString(5,String.valueOf(totalDrugs));
					work_insert_loc_mon.setString(6, login_by_id);
					work_insert_loc_mon.setString(7, login_at_ws_no);
					work_insert_loc_mon.setString(8, login_facility_id);
					work_insert_loc_mon.setString(9, login_by_id);
					work_insert_loc_mon.setString(10, login_at_ws_no);
					work_insert_loc_mon.setString(11, login_facility_id);
					work_insert_loc_mon.executeUpdate();
				}
				else{
					work_insert_loc_mon =  connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY9")) ;
					work_insert_loc_mon.setString(1,String.valueOf(totalOrder));
					work_insert_loc_mon.setString(2,String.valueOf(totalDrugs));
					work_insert_loc_mon.setString(3, login_by_id);
					work_insert_loc_mon.setString(4, login_at_ws_no);
					work_insert_loc_mon.setString(5, login_facility_id);
					work_insert_loc_mon.setString(6, locn_type);
					work_insert_loc_mon.setString(7, login_facility_id);
					work_insert_loc_mon.setString(8, locn_code);
					work_insert_loc_mon.executeUpdate();
				}
				closeStatement( work_insert_loc_mon );
				closeStatement( pstmt_select );
			}

			String auto_order_regn_err = "";
			String tokens_generated_yn = "";
			if((patient_class.equals("OP")|| patient_class.equals("EM")) && !trn_group_ref.equals("")){
				cstmt_insert=connection.prepareCall("{call ph_auto_order_regn(?,?,?,?,?,?)}");

				cstmt_insert.setString( 1, trn_group_ref);
				cstmt_insert.setString( 2, patient_id);
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
			if(auto_order_regn_err.equals("")){
				map.put("result", new Boolean(true));
				map.put("msgid", "RECORD_INSERTED");
				map.put("trn_group_ref", trn_group_ref);
				map.put("tokens_generated_yn", tokens_generated_yn);
				connection.commit();
			}
			else{
				connection.rollback();
				map.put("auto_order_regn_err", auto_order_regn_err);
				throw new EJBException("Insert Failed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("tabData=== "+tabData);
			map.put("msgid", e.getMessage());
			try {
				connection.rollback();
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement(pstmt_insert		);
				closeStatement(pstmt_select		);
				closeStatement(pstmt_select_2	);
				closeStatement(pstmt_workload	);
				closeStatement(workload_insert	);
				closeStatement(work_insert_month);	
				closeStatement(work_insert_loc	);
				closeStatement(work_insert_loc_mon);
				closeStatement(pstmt_clob 	);
				closeStatement(pstmt_select1 );
				closeStatement(pstmt_select3 );
				closeResultSet( resultSet_workload );			

				closeConnection(connection, (Properties)tabData.get("PROPERTIES"));				
			}
			catch(Exception fe) {
				fe.printStackTrace();
			}
		}
		return map;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/
/*insert method handles for both iv with additives  and iv intermitent(iv continuous) orders*/
	public HashMap insert( HashMap tabData, HashMap sqlMap ){
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "");
		map.put("msgid", "");
System.out.println(tabData+"tabData in IV prescriptionManager");
System.out.println(sqlMap+"sqlMap in IV prescriptionManager");

		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		PreparedStatement pstmt_select2 = null;
		PreparedStatement pstmt_select3 = null;
		PreparedStatement pstmt_insert	= null,pstmt_update_order_line_ph=null,pstmt_update_patient_drug_profile=null;
		PreparedStatement pstmt_update=null,pstmt_update_non_scheduled_drug	= null,pstmt_delete=null,pstmt_clob=null;
		CallableStatement cstmt_insert	= null;     
		ResultSet resultSet				= null;
		PreparedStatement pstmt_workload		 = null;
		PreparedStatement workload_insert		 = null;
		PreparedStatement work_insert_month		 = null;
		PreparedStatement work_insert_loc		 = null;
		PreparedStatement work_insert_loc_mon	 = null;
		ResultSet resultSet_workload			 = null;	
		Statement statement = null;
		int result                               = 0;
		HashMap freq_char_list	 = new HashMap();
		ArrayList day_list	= new ArrayList();
		ArrayList day_names	= new ArrayList();
		ArrayList time_list	= new ArrayList();
		ArrayList dose_list	= new ArrayList(); 

		try {
			String lang_id				= (String)tabData.get("lang_id");		
			HashMap orderDetails		= (HashMap)tabData.get("ORDERDETAILS");
			HashMap commonData			= (HashMap)tabData.get("COMMONDATA");
			HashMap	scheduleFreq		= (HashMap)tabData.get("SCHEDULEFREQ");
			HashMap	fluidDetails		= (HashMap)tabData.get("FLUIDDETAILS");
			ArrayList drugList			= (ArrayList)tabData.get("DRUGDETAILS");
			ArrayList drugRemarks		= (ArrayList)tabData.get("DRUGREMARKS");
			ArrayList diag_Text			= (ArrayList)tabData.get("DIAG_TEXT");
			String license				= (String)tabData.get("LICENSE");
			String or_mode				= (String)tabData.get("OR_MODE");
			String order_number			= (String)orderDetails.get("ORDER_ID");
			String ord_type				= (String)orderDetails.get("ORDER_TYPE_CODE");
			String pract_id				= (String)orderDetails.get("ORD_PRACT_ID");
			String ord_date				= (String)orderDetails.get("ORD_DATE");
            String start_date			= (String)orderDetails.get("START_DATE");
			String end_date				= (String)orderDetails.get("END_DATE");
			String patient_class		= (String)orderDetails.get("PATIENT_CLASS");
			String location_type		= (String)orderDetails.get("SOURCE_TYPE");
			String location_code		= (String)orderDetails.get("SOURCE_CODE");
			String priority				= (String)orderDetails.get("PRIORITY");
			String ord_auth_reqd_yn		= (String)orderDetails.get("ORD_AUTH_REQD_YN");
			String ord_appr_reqd_yn		= (String)orderDetails.get("ORD_APPR_REQD_YN");
			String ord_cosign_reqd_yn	= (String)orderDetails.get("ORD_COSIGN_REQD_YN");
			String ord_consent_reqd_yn	= (String)orderDetails.get("ORD_CONSENT_REQD_YN");
			String ord_status			= (String)orderDetails.get("ORDER_STATUS");
			String encounter_id			= (String)orderDetails.get("ENCOUNTER_ID");
			String patient_id			= (String)orderDetails.get("PATIENT_ID");
			String freq_code			= (String)orderDetails.get("FREQ_CODE");
			String freq_nature			= (String)orderDetails.get("FREQ_NATURE");
			String opDischMed 			= (String)orderDetails.get("OP_DISCH_MED_IND");//added for NMC-JD-CRF-0063
			String drug_indication			= (String)orderDetails.get("DreugIndicationRemarks");//Added for  ML-BRU-CRF-072[Inc:29938]
			String allergic_yn			= (String)tabData.get("allergic_yn")==null?"N":(String)tabData.get("allergic_yn");
			String buildMAR_yn			= (String)orderDetails.get("BUILD_MAR_YN")==null?"N":(String)orderDetails.get("BUILD_MAR_YN");
			String take_home			= (String)orderDetails.get("TAKEHOME_MEDN")==null?"":(String)orderDetails.get("TAKEHOME_MEDN");  // RUT-CRF-0062
			//String durn_unit			= (String)orderDetails.get("DURN_UNIT")==null?"":(String)orderDetails.get("DURN_UNIT");
			String print_mar_label			= (String)tabData.get("print_mar_label")==null?"":(String)tabData.get("print_mar_label"); //added for MMS-QH-CRF-0080 [IN:038064]
			String print_mar_barcode			= (String)tabData.get("print_mar_barcode")==null?"":(String)tabData.get("print_mar_barcode");//added for MMS-QH-CRF-0080 [IN:038064]
			String iv_calc_infuse_by			=tabData.get("iv_calc_infuse_by")==null?"":(String)tabData.get("iv_calc_infuse_by");//Added for SKR-CRF-0035 [IN:037727] 
			String	bed_num = (String)orderDetails.get("BED_NUM")==null?"":(String)orderDetails.get("BED_NUM");
			String	room_num = (String)orderDetails.get("ROOM_NUM")==null?"":(String)orderDetails.get("ROOM_NUM");

			String MAR_barcode_id="";//added for MMS-QH-CRF-0080 [IN:038064]
			String trn_group_ref = "";
			String infuse_over = "";
			String infusionRatePeriodUnit = "";
			String uomDisplay = "";
			String take_home_medn_op   = (String)orderDetails.get("TAKEHOMEMED_OP");//added for NMC-JD-CRF-0063
			String takehome_op_sitespecific   = (String)orderDetails.get("TAKE_HOME_OP_SITESPECIFIC");//added for NMC-JD-CRF-0063 
			String iv_pb				= "N";
			if(orderDetails.get("IV_PB")!=null){
				iv_pb = (String)orderDetails.get("IV_PB");
				iv_calc_infuse_by = "";
			}
		/*	if(!lang_id.equals("en") ){
				 ord_date = com.ehis.util.DateUtils.convertDate(ord_date, "DMYHM",lang_id,"en");
				 start_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",lang_id,"en");
				 end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM",lang_id,"en");
			}*/

			int rep_interval			=	1;
			int int_value				=	1;
			if(orderDetails.get("REP_INTERVAL")!=null && !((String)orderDetails.get("REP_INTERVAL")).equals("")) {
				rep_interval			=	Integer.parseInt((String)orderDetails.get("REP_INTERVAL"));
			}
		
			if(orderDetails.get("INT_VALUE")!=null && !((String)orderDetails.get("INT_VALUE")).equals("")) {
				int_value			=	Integer.parseInt((String)orderDetails.get("INT_VALUE"));
			}

			String login_facility_id			= (String)commonData.get("login_facility_id");
			String login_at_ws_no				= (String)commonData.get("login_at_ws_no");
			String login_by_id					= (String)commonData.get("login_by_id");
			String sys_date						= "";
			String regn_reqd_yn					= "";
			String strength_per_value_pres_uom	= "";
			String strength_per_pres_uom		= "";
			String content_in_pres_base_uom		= "";
			String stock_uom					= "";
			String order_comment				= (String)tabData.get("ORDER_COMMENTS")==null?"":(String)tabData.get("ORDER_COMMENTS");
			String freq_changed_yn				= (String)tabData.get("FREQ_CHANGED_YN");
			String drug_cod						= "";
			String ord_auth_reqd_yn1			= "";
			String ORD_AUTHORIZED_YN					= "";
			String drg_code						= "";
			String flag							= "N";
			int	srlNo							= 0;
			//float duration 		= Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
			float duration 		= 0;

			/*for multi freq crf
			if(iv_pb.equals("Y")) {
				duration		=	(duration/24);	 
			}*/
			if(orderDetails.get("MFR_YN")==null || ((String)orderDetails.get("MFR_YN")).equals("N"))
				duration = Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
			else
				duration =Float.parseFloat((String)(((HashMap)orderDetails.get("MFR_Recs")).get("totFlowDurnHrs")));

			float fld_unit_qty 			= Float.parseFloat(orderDetails.get("FLUID_UNIT_QTY").toString());
			String fluid_ord_qty	= "";
			float pack_size			= Float.parseFloat((String)orderDetails.get("PACK_SIZE"));
			float durn_val_for_freq	= 0;

			if(iv_pb.equals("Y")) {
				duration = duration / int_value;
				if(duration < 1)
					duration = 1;
			}

			if (freq_nature.equals("I")) {

				if(license!=null && !license.equals("PHBASIC")) 
					fluid_ord_qty = ((fld_unit_qty*duration)/pack_size)+"";
				else 
					fluid_ord_qty = ((fld_unit_qty*duration*(24/int_value)))+"";

				if((or_mode.equals("or_amend") && freq_changed_yn.equals("Y") )||  !or_mode.equals("or_amend"))
					durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"))*int_value;
				else
					durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
			}
			else if (freq_nature.equals("F") || freq_nature.equals("C")) {
				if(license!=null && !license.equals("PHBASIC"))
					fluid_ord_qty = ((fld_unit_qty*rep_interval*duration)/pack_size)+"";
				else 
					fluid_ord_qty = ((fld_unit_qty*rep_interval*duration))+"";

				durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
			} 
			else if (freq_nature.equals("O")) {
				if(license!=null && !license.equals("PHBASIC")) 
					fluid_ord_qty = ((fld_unit_qty)/pack_size)+"";
				else 
					fluid_ord_qty = ((fld_unit_qty))+"";

				durn_val_for_freq = Float.parseFloat((String)orderDetails.get("SCH_INFUSION_PERIOD"));
			}
	
			if(iv_pb.equals("Y")) {
				float fld_ordered_qty = new Double(Math.ceil(Float.parseFloat(fluid_ord_qty))).floatValue();
				fluid_ord_qty = fld_ordered_qty+"";
			}
		
			HashMap drugDtls = (HashMap)drugList.get(0);
			if(drugDtls.size() != 0){
				drug_cod=(String)drugDtls.get("DRUG_CODE");
				ord_auth_reqd_yn1= (String)drugDtls.get("ORD_AUTH_REQD_YN");
				ORD_AUTHORIZED_YN = (String)drugDtls.get("ORD_AUTHORIZED_YN");
				drg_code=(String)fluidDetails.get("DRUG_CODE");
				flag="N";
				if(drug_cod.equals(drg_code)){
					flag="Y";
				}
			}
			connection = getConnection((Properties)tabData.get("PROPERTIES"));
			connection.setAutoCommit(false);
			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT54"));
			resultSet		= pstmt_select.executeQuery();

			if (resultSet.next()) {
				sys_date = resultSet.getString(1);
			}
			closeResultSet( resultSet );
			closeStatement(pstmt_select); 
			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT"));
			resultSet		= pstmt_select.executeQuery();

			if (resultSet.next()) {
				trn_group_ref = resultSet.getString("TRN_GROUP_REF");
			}
			closeResultSet( resultSet );
			closeStatement(pstmt_select); 

			HashMap orderStatusCode	= new HashMap();

			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT20A"));
			resultSet		= pstmt_select.executeQuery();
			while (resultSet.next()) {
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}

			closeResultSet( resultSet );
			closeStatement(pstmt_select); 

			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT19A"));
			pstmt_select.setString(1, ord_type);
			resultSet		= pstmt_select.executeQuery();
			if (resultSet.next()) {
				regn_reqd_yn = resultSet.getString(1);
			}
	
			closeResultSet( resultSet );
			closeStatement(pstmt_select);
			// IV PREP YN
			String iv_prep	=	"";
			// 1 - IV with additives (without admixture)
			// 2 - IV with additives( with admixture)
			// 3 - IV with piggy back( without admixture)	
			// 4 - IV with piggy back( with admixture)	
			// 5 - IV Without additives( continuous)
			// 6 - Compound Rx

    		if(iv_pb.equals("Y")) {
				if(((String)orderDetails.get("IV_PRESC")).equals("I"))
					iv_prep	=	"4";
				else
					iv_prep	=	"3";
			}
			else if(((String)orderDetails.get("IVType")).equals("IVD")){
				if(((String)orderDetails.get("IV_PRESC")).equals("I"))
					iv_prep	=	"2";
				else 
					iv_prep	=	"1";
			}

			String perf_locn_code	=	"";
			String perf_locn_type	=	"";
			String perf_locn_desc	=	"";
			String per_facility_id  ="";

			if(license!=null && !license.equals("PHBASIC")) {
				cstmt_insert=connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,null,null,null,?)}");//modified for NMC-JD-CRF-0063
				cstmt_insert.setString(1, login_facility_id);
				cstmt_insert.setString(2, location_type);
				cstmt_insert.setString(3, location_code);
				if(takehome_op_sitespecific.equalsIgnoreCase("Y")){//ADDED FOR NMC-JD-CRF-0063
					cstmt_insert.setString(4, take_home_medn_op);
				}else{
					cstmt_insert.setString(4, (String)orderDetails.get("TAKEHOME_MEDN"));
				}	 

				if(priority.equals("")|| priority == null){
					priority="R";
				}
				cstmt_insert.setString(5, priority);
				cstmt_insert.setString(6, iv_prep);
				cstmt_insert.setString(7, lang_id);
				cstmt_insert.registerOutParameter(8, Types.VARCHAR);
				cstmt_insert.registerOutParameter(9, Types.VARCHAR);
				cstmt_insert.registerOutParameter(10, Types.VARCHAR);
				cstmt_insert.registerOutParameter(11, Types.VARCHAR);
				cstmt_insert.setString(12, opDischMed);//added for NMC-JD-CRF-0063
				cstmt_insert.execute();

				perf_locn_code	= cstmt_insert.getString(8);
				perf_locn_type	= cstmt_insert.getString(9);
				perf_locn_desc	= cstmt_insert.getString(10);
				per_facility_id	= cstmt_insert.getString(11);

				closeStatement(cstmt_insert);
			}
			else {
				perf_locn_code	= location_code;
				perf_locn_type	= location_type;
			}
			// Added for NMC-JC-CRF-0197  start
			boolean  site_alw_disp_loc_drug_search_appl = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PH_DISP_LOC_DRUG_SEARCH");//added for NMC-JD-CRF-0197
			String	DISP_LOC_CODE1 = (String)orderDetails.get("DISP_LOC_CODE1")==null?"":(String)orderDetails.get("DISP_LOC_CODE1");
			if(site_alw_disp_loc_drug_search_appl){
				if(!DISP_LOC_CODE1.equals("")){
					perf_locn_code=DISP_LOC_CODE1;
				}
			}
			// Added for NMC-JC-CRF-0197  end
			// IV Prescription Insert Starts
			// OR_ORDER
			//pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT1"));
			pstmt_insert	= connection.prepareStatement("INSERT INTO OR_ORDER (ORDER_ID, ORDER_TYPE_CODE, ORDER_CATEGORY, CONTR_SYS_ID, PATIENT_ID, PATIENT_CLASS, ORDERING_FACILITY_ID, ENCOUNTER_ID, EPISODE_ID, EPISODE_VISIT_NUM, SOURCE_TYPE, SOURCE_CODE, DISCHARGE_IND, ORD_DATE_TIME, ORD_PRACT_ID, PRIORITY, ORD_AUTH_REQD_YN, ORD_AUTH_LEVEL, ORD_AUTH_BY_PRACT_ID, ORD_AUTH_DATE_TIME, ORD_APPR_REQD_YN, ORD_APPR_BY_USER_ID, ORD_APPR_DATE_TIME, ORD_COSIGN_REQD_YN, ORD_COSIGN_LEVEL, ORD_COSIGN_BY_PRACT_ID, ORD_COSIGN_DATE_TIME, ORD_PRINT_DATE_TIME, BILL_YN, CONT_ORDER_IND, PERFORMING_FACILITY_ID, PERFORMING_SYS_ID, PERFORMING_DEPTLOC_TYPE, PERFORMING_DEPTLOC_CODE, PERFORMING_PRACT_ID, RESULT_AUTH_REQD_YN, CHILD_ORDER_YN, PARENT_ORDER_ID, ORDER_SET_YN, ORDER_SET_ID, IV_PREP_YN, ORDER_FIELDS_DISPLAY_TEXT, ORDER_STATUS, RESULT_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ORD_CONSENT_REQD_YN, ORD_CONSENT_BY_ID, ORD_CONSENT_BY_DATE_TIME, CAN_REASON, TRN_GROUP_REF,CATALOG_SPLTY_CODE,OP_DISCH_IND) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), to_date(?, 'dd/mm/yyyy hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy hh24:mi'), ?,?,?,?)");//modified for NMC-JD-CRF-0063
			pstmt_insert.setString(1, order_number);
			pstmt_insert.setString(2, ord_type);
			pstmt_insert.setString(3, "PH");
			pstmt_insert.setString(4, "PH");
			pstmt_insert.setString(5, patient_id);
			pstmt_insert.setString(6, patient_class);
			pstmt_insert.setString(7, login_facility_id);
			pstmt_insert.setString(8, encounter_id);
			pstmt_insert.setString(9, encounter_id);
			pstmt_insert.setString(10, "");
			pstmt_insert.setString(11, location_type);
			pstmt_insert.setString(12, location_code);
			pstmt_insert.setString(13, take_home);  // RUT-CRF-0062
			pstmt_insert.setString(14, ord_date);
			pstmt_insert.setString(15, pract_id);
			if(priority.equals("")|| priority == null){
				priority="R";
			}
			pstmt_insert.setString(16, priority);
			pstmt_insert.setString(17, ord_auth_reqd_yn);
			pstmt_insert.setString(18, "");
			if (ord_auth_reqd_yn.equals("Y")) {
				pstmt_insert.setString(19, pract_id);
				pstmt_insert.setString(20, sys_date);
			}
			else {
				pstmt_insert.setString(19, "");
				pstmt_insert.setString(20, null);
			}

			pstmt_insert.setString(21, ord_appr_reqd_yn);
			if (ord_appr_reqd_yn.equals("Y")) {
				pstmt_insert.setString(22, pract_id);
				pstmt_insert.setString(23, sys_date);
			} 
			else {
				pstmt_insert.setString(22, "");
				pstmt_insert.setString(23, null);
			}

			pstmt_insert.setString(24, ord_cosign_reqd_yn);
			pstmt_insert.setString(25, "");
			if (ord_cosign_reqd_yn.equals("Y")) {
				pstmt_insert.setString(26, pract_id);
				pstmt_insert.setString(27, sys_date);
			} 
			else {
				pstmt_insert.setString(26, "");
				pstmt_insert.setString(27, null);
			}

			pstmt_insert.setString(28, null);
			pstmt_insert.setString(29, "N");
			pstmt_insert.setString(30, "CO");
			//pstmt_insert.setString(31, login_facility_id);
			pstmt_insert.setString(31, per_facility_id);
			pstmt_insert.setString(32, "PH");
			pstmt_insert.setString(33, perf_locn_type);
			pstmt_insert.setString(34, perf_locn_code);
			pstmt_insert.setString(35, pract_id);
			pstmt_insert.setString(36, "N");
			pstmt_insert.setString(37, "N");
			pstmt_insert.setString(38, "");
			pstmt_insert.setString(39, "N");
			pstmt_insert.setString(40, "");
			pstmt_insert.setString(41, iv_prep);
			pstmt_insert.setString(42, "");
			
			if(ord_status.equals("10") || ord_status.equals("25")) {
				if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y"))
					ord_status="25";
				else
					ord_status="10";
			}
			
			if(ord_status.equals("03"))
				ord_status = (String)orderStatusCode.get("03");
			else if (ord_status.equals("05"))
				ord_status =(String) orderStatusCode.get("05");
			else if (ord_status.equals("10"))
				ord_status =(String) orderStatusCode.get("10");
			else if (ord_status.equals("25"))
				ord_status = (String)orderStatusCode.get("25");
			else if (ord_status.equals("00"))
				ord_status = (String)orderStatusCode.get("00");

			pstmt_insert.setString(43, ord_status);
			pstmt_insert.setString(44, "");
			pstmt_insert.setString(45, login_by_id);
			pstmt_insert.setString(46, login_at_ws_no);
			pstmt_insert.setString(47, login_facility_id);
			pstmt_insert.setString(48, login_by_id);
			pstmt_insert.setString(49, login_at_ws_no);
			pstmt_insert.setString(50, login_facility_id);
			pstmt_insert.setString(51, ord_consent_reqd_yn);
			pstmt_insert.setString(52, "");
			pstmt_insert.setString(53, null);
			pstmt_insert.setString(54, "");
			pstmt_insert.setString(55, trn_group_ref);
			pstmt_insert.setString(56,(String)drugDtls.get("CATALOG_SPLTY_CODE"));// (String)commonData.get("CATALOG_SPLTY_CODE"));
			pstmt_insert.setString(57, opDischMed); //added for NMC-JD-CRF-0063

			result			= pstmt_insert.executeUpdate();
			closeStatement(pstmt_insert);

			String short_desc	=	"";
			infuse_over	=	(String)orderDetails.get("INFUSE_OVER");
			infusionRatePeriodUnit	=	(String)orderDetails.get("INFUSE_OVER_UNIT");
			if((iv_prep.equals("1")||iv_prep.equals("2")) && infusionRatePeriodUnit.equals("M"))
				infuse_over = Float.parseFloat(infuse_over)/60+"";

			float ing_durn = new Double(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)).floatValue() ;

			// OR_ORDER_LINE
			if (result>0 ){
				pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE (ORDER_ID,ORDER_LINE_NUM,ORDER_CATALOG_CODE,CATALOG_DESC,CATALOG_SYNONYM,ORDER_CATALOG_NATURE,ORDER_TYPE_CODE,ORDER_CATEGORY,ORD_DATE_TIME,PRIORITY,ORD_AUTH_REQD_YN,ORD_AUTH_REASON,ORD_APPR_REQD_YN,ORD_COSIGN_REQD_YN,START_DATE_TIME,FORM_CODE,ROUTE_CODE,QTY_VALUE,QTY_UNIT,FREQ_CODE,DURN_VALUE,DURN_TYPE,LINE_FIELDS_DISPLAY_TEXT,ITEM_NARRATION,NEXT_SCHED_DATE,END_DATE_TIME,AUTO_STOP_DATE_TIME,ORDER_QTY,ORDER_UOM,APPT_REQD_YN,APPT_DATE_TIME,APPT_REF_NUM,RESULT_APPLICABLE_YN,BILL_YN,BILLED_YN,CONT_ORDER_IND,REFILL_SINGLE_CONT_ORDER_YN,NUM_OF_REFILLS,CHILD_ORDER_YN,PARENT_ORDER_ID,PARENT_ORDER_LINE_NUM,ORDER_SET_ID,ORDER_SET_LINE_NUM,ORD_PRACT_ID,ORD_SET_DATE_TIME,AMD_PRACT_ID,AMD_DATE_TIME,HOLD_PRACT_ID,HOLD_DATE_TIME,RESUME_PRACT_ID,RESUME_DATE_TIME,DISC_PRACT_ID,DISC_DATE_TIME,CAN_PRACT_ID,CAN_DATE_TIME,ACCESSION_NUM,ACCESSION_LINE_NUM,ORDER_LINE_STATUS,RESULT_LINE_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORD_CONSENT_REQD_YN,CAN_LINE_REASON,CATALOG_SYNONYM_DC,CATALOG_SYNONYM_AD,RESULT_AUTH_REQD_YN,  ORD_CONSENT_STAGE, ORD_CONSENT_STATUS, NUM_OF_CONSENT_REQ_BO, NUM_OF_CONSENT_REQ_BR,CATALOG_SPLTY_CODE ) VALUES (?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?)");
				String line_display_text = "";

				// OR_ORDER_LINE FOR FLUID
				if(flag.equals("N")){
					//pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT2"));
					
					pstmt_insert.clearBatch();
					if( ((String)fluidDetails.get("SHORT_DESC")).length() > 39) {
						short_desc	=	((String)fluidDetails.get("SHORT_DESC")).substring(0,39);
					} 
					else {
						short_desc	=	((String)fluidDetails.get("SHORT_DESC"));
					}

					pstmt_insert.setString(1, order_number);
					pstmt_insert.setString(2, "1");
					pstmt_insert.setString(3, (String)fluidDetails.get("DRUG_CODE"));
					pstmt_insert.setString(4, short_desc);
					pstmt_insert.setString(5, short_desc);
					pstmt_insert.setString(6, "");
					pstmt_insert.setString(7, (String)fluidDetails.get("ORDER_TYPE_CODE"));
					pstmt_insert.setString(8, "PH");
					pstmt_insert.setString(9, ord_date);
					if(priority.equals("")|| priority == null){
						priority="R";
					}
					pstmt_insert.setString(10, priority);
					pstmt_insert.setString(11, "N");
					pstmt_insert.setString(12, "");
					pstmt_insert.setString(13, "N");
					pstmt_insert.setString(14, "N");
					/*--code modified on 9/27/2004 for inserting start_date_time in place of ord_date--*/
					pstmt_insert.setString(15,start_date );
					pstmt_insert.setString(16, (String)fluidDetails.get("FORM_CODE"));
					pstmt_insert.setString(17, (String)fluidDetails.get("ROUTE_CODE"));
					//code added for QTY VALUE ...on 13/5/2004...
					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(18, (String)orderDetails.get("FLUID_UNIT_QTY"));
					}
					else{
						pstmt_insert.setString(18, (fld_unit_qty)+"");
					}
				
					pstmt_insert.setString(19, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
					pstmt_insert.setString(20, freq_code);
					
					//condition ivpb added for multi freq crf
					if(iv_pb.equals("Y")){
						pstmt_insert.setString(21, (String)orderDetails.get("DURN_VALUE_ACT"));
						pstmt_insert.setString(22, (String)orderDetails.get("DURN_UNIT"));
					}
					else{
						if(((String)orderDetails.get("IVType")).equals("IVD"))
							pstmt_insert.setString(21, (String)orderDetails.get("DURN_VALUE"));
						else
							pstmt_insert.setString(21, durn_val_for_freq+"");
						pstmt_insert.setString(22, "H");					
					}
					if (drugRemarks.size() > 0) {
						HashMap DrugValues = (HashMap)drugRemarks.get(0);
						line_display_text = (String)DrugValues.get("order_format_values");
					}
					else {
						line_display_text = "";
					}

					pstmt_insert.setString(23, line_display_text);
					pstmt_insert.setString(24, "");
					pstmt_insert.setString(25, null);
					pstmt_insert.setString(26, end_date);
					pstmt_insert.setString(27, null);
					pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));
					pstmt_select3.setString(1, freq_code);
					resultSet		= pstmt_select3.executeQuery();
					String repeat_value = "";
					if(resultSet.next()) {
						repeat_value   = resultSet.getString("repeat_value");
					}
					closeResultSet( resultSet );					
					closeStatement(pstmt_select3);
					//code added for IVAdditives...on 15/4/2003....
					//if(((String)orderDetails.get("IVType")).equals("IVD") && !(iv_pb.equals("Y"))){
					float dur1 = 1.0f;
					if(iv_calc_infuse_by.equals("I")) //if block & else condition added for SKR-CRF-0035 [IN:037727] 
						dur1 = 1.0f;
					else
						dur1 = Float.parseFloat(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"") ;
					// duration is assigned to durl for multi freq crf.
					if(iv_pb.equals("Y"))
						dur1 = duration;
					float qty_value =0;

					if(((String)orderDetails.get("IVType")).equals("IVD") ){
						 qty_value = Float.parseFloat(Math.ceil(Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY")) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE")))*dur1+"");
					}
					else{
						 qty_value = Float.parseFloat(Math.ceil(Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY")) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE")))+"");
					}

					if(iv_pb.equals("Y") && !repeat_value.equals("")){ 
						qty_value = qty_value * Integer.parseInt(repeat_value);
					}

					pstmt_insert.setString(28, Math.ceil(qty_value)+""); //ORDER_QTY
					fluidDetails.put("FINAL_ORD_QTY",qty_value+""); 
					/*}
					else{
						pstmt_insert.setString(28, fluid_ord_qty);
						fluidDetails.put("FINAL_ORD_QTY",fluid_ord_qty+"");
					}*/
					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(29, (String)orderDetails.get("BASE_UOM"));
					}
					else{
						if(license!=null && !license.equals("PHBASIC")) {
							pstmt_insert.setString(29, (String)orderDetails.get("BASE_UOM"));
						}
						else {
							pstmt_insert.setString(29, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
						}
					}
					pstmt_insert.setString(30, "N");
					pstmt_insert.setString(31, null);
					pstmt_insert.setString(32, "");
					pstmt_insert.setString(33, "N");
					pstmt_insert.setString(34, "N");
					pstmt_insert.setString(35, "N");
					pstmt_insert.setString(36, "CO");
					pstmt_insert.setString(37, "N");
					pstmt_insert.setString(38, "");
					pstmt_insert.setString(39, "N");
					pstmt_insert.setString(40, "");
					pstmt_insert.setString(41, "");
					pstmt_insert.setString(42, "");
					pstmt_insert.setString(43, "");
					pstmt_insert.setString(44, pract_id);
					pstmt_insert.setString(45, null);
					pstmt_insert.setString(46, "");
					pstmt_insert.setString(47, null);
					pstmt_insert.setString(48, "");
					pstmt_insert.setString(49, null);
					pstmt_insert.setString(50, "");
					pstmt_insert.setString(51, null);
					pstmt_insert.setString(52, "");
					pstmt_insert.setString(53, null);
					pstmt_insert.setString(54, "");
					pstmt_insert.setString(55, null);
					pstmt_insert.setString(56, "");
					pstmt_insert.setString(57, "");
					pstmt_insert.setString(58, ord_status);
					pstmt_insert.setString(59, "");
					pstmt_insert.setString(60, login_by_id);
					pstmt_insert.setString(61, login_at_ws_no);
					pstmt_insert.setString(62, login_facility_id);
					pstmt_insert.setString(63, login_by_id);
					pstmt_insert.setString(64, login_at_ws_no);
					pstmt_insert.setString(65, login_facility_id);
					pstmt_insert.setString(66, (String)fluidDetails.get("CONSENT_REQD_YN"));
					pstmt_insert.setString(67, "");
					pstmt_insert.setString(68, short_desc);
					pstmt_insert.setString(69, short_desc);
					pstmt_insert.setString(70, "N");
					pstmt_insert.setString(71,(String)fluidDetails.get("CONSENT_STAGE")); //ORD_CONSENT_STAGE
					pstmt_insert.setString(72,(String)fluidDetails.get("CONSENT_STATUS")); //ORD_CONSENT_STATUS
					pstmt_insert.setString(73,(String)fluidDetails.get("NUM_OF_CONSENT_REQ_BO")); //NUM_OF_CONSENT_REQ_BO
					pstmt_insert.setString(74,(String)fluidDetails.get("NUM_OF_CONSENT_REQ_BR")); //NUM_OF_CONSENT_REQ_BR
					pstmt_insert.setString(75,""); //CATALOG_SPLTY_CODE
					result			= pstmt_insert.executeUpdate();
				}     
				// OR_ORDER_LINE FOR INGREDIENTS

				if (result > 0 ){
					//if(flag.equals("N"))
					//pstmt_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT2"));
					pstmt_insert.clearBatch();
					pstmt_select2		= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT2"));
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
					if(flag.equals("N"))
						srlNo = 1;
					else
						srlNo = 0;
					
					for(int j=1;j<=drugList.size();j++) {
						HashMap drugDetails = (HashMap)drugList.get(j-1);
						if (drugDetails.size() != 0) {
							if( ((String)drugDetails.get("SHORT_DESC")).length() > 39)
								short_desc	=	((String)drugDetails.get("SHORT_DESC")).substring(0,39);
							else 
								short_desc	=	((String)drugDetails.get("SHORT_DESC"));

							pstmt_insert.setString(1, order_number);
							pstmt_insert.setString(2, (++srlNo)+"");
							pstmt_insert.setString(3, (String)drugDetails.get("DRUG_CODE"));
							pstmt_insert.setString(4, short_desc);
							pstmt_insert.setString(5, short_desc);
							pstmt_insert.setString(6, "");
							pstmt_insert.setString(7, (String)drugDetails.get("ORDER_TYPE_CODE"));
							pstmt_insert.setString(8, "PH");
							pstmt_insert.setString(9, ord_date);
							if(priority.equals("")|| priority == null){
								priority="R";
							}
							pstmt_insert.setString(10, priority);
							pstmt_insert.setString(11, (String)drugDetails.get("ORD_AUTH_REQD_YN")==null?"N":(String)drugDetails.get("ORD_AUTH_REQD_YN"));
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, (String)drugDetails.get("ORD_SPL_APPR_REQD_YN")==null?"N":(String)drugDetails.get("ORD_SPL_APPR_REQD_YN"));
							pstmt_insert.setString(14, (String)drugDetails.get("ORD_COSIGN_REQD_YN")==null?"N":(String)drugDetails.get("ORD_COSIGN_REQD_YN"));
							pstmt_insert.setString(15, start_date);
							pstmt_insert.setString(16, (String)drugDetails.get("FORM_CODE"));
							pstmt_insert.setString(17, (String)drugDetails.get("ROUTE_CODE"));
							String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
							float ing_unit_qty			= 0.0f;
							float ing_order_qty			= 0.0f;
							String ing_order_uom		= "";
							strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
							strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
							content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
							stock_uom					=	(String)drugDetails.get("STOCK_UOM");
							String qty_unit				=	(String)drugDetails.get("QTY_DESC_CODE");

							if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
							content_in_pres_base_uom =	"1";
							if( iv_pb.equals("Y")) {
							  ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
							}
							else {
								ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
							}

							//ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
							// the qty_unit goes wrong in amend mode
							ing_order_uom		= (String)drugDetails.get("QTY_UOM");

							/* code for check freq dosage round up yn*/
							String fract_dose = null;
							pstmt_select2.setString(1, (String)drugDetails.get("DRUG_CODE"));
							resultSet		= pstmt_select2.executeQuery();

							if(resultSet.next()) {
								fract_dose = resultSet.getString("fract_dose_round_up_yn");
							}
				
							closeResultSet( resultSet );
							/* fract_dose collection is over*/

							if (dosage_type.equals("S")) {
								if( iv_pb.equals("Y")) {
									ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));	
								} 
								else {
									ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								}
								float in_tot_qty	= 0.0f;

								if(fract_dose.equals("Y")){
									in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
									in_tot_qty		= new Double(Math.ceil( (in_tot_qty/Float.parseFloat(content_in_pres_base_uom)))).floatValue();
								}
								else{
									in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
								}

								ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
								// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
								if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
	
									if (freq_nature.equals("I")) {
										ing_order_qty = in_tot_qty*duration;//*(24/int_value);
									}
									else if (freq_nature.equals("F") || freq_nature.equals("C")) {
										ing_order_qty = in_tot_qty*rep_interval*duration;
									}
									else if (freq_nature.equals("O")) {
										ing_order_qty = in_tot_qty;
									}
								}
								// Ends (not for IVD)

								if(!iv_pb.equals("Y")){ 
									ing_order_qty = in_tot_qty*ing_durn;
								}

								if(!fract_dose.equals("Y")){
									if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									} 
									else {
										ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									}
								}
							} 
							else {						
								String equl_value	= "1";
								pstmt_select.setString(1, ing_order_uom);
								pstmt_select.setString(2, qty_unit);
								pstmt_select.setString(3, ing_order_uom);
								pstmt_select.setString(4, qty_unit);
								resultSet	= pstmt_select.executeQuery();

								if (resultSet.next()) {
									equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
								}
								closeResultSet( resultSet );

								float in_tot_qty	= 0.0f;
								if(fract_dose.equals("Y")){
									if(((String)drugDetails.get("STRENGTH_UOM")).equals(ing_order_uom)){
										in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue() * Float.parseFloat(equl_value);
										//	in_tot_qty	=   in_tot_qty*ing_durn;
									}
									else {
										if(((String)drugDetails.get("STOCK_UOM")).equals(qty_unit)){
											//in_tot_qty = ing_unit_qty*ing_durn; commented coz 24561: at last we r multiplying with ing_durn
											in_tot_qty = ing_unit_qty;
										}
										else{
											//	commented coz 24561: at last we r multiplying with ing_durn		in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue() * Float.parseFloat(equl_value)*ing_durn;
											in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue() * Float.parseFloat(equl_value);
										}
										//ing_order_uom		= (String)drugDetails.get("STRENGTH_UOM");
									}
								}
								else{
									in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
								}
								// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
								if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
									if (freq_nature.equals("I")) {
										if((or_mode.equals("or_amend") && freq_changed_yn.equals("Y") )||  !or_mode.equals("or_amend"))
											ing_order_qty = in_tot_qty*duration;									
										else
											ing_order_qty = in_tot_qty*duration*(24/int_value);
									} 
									else if (freq_nature.equals("F") || freq_nature.equals("C")) {
										ing_order_qty = in_tot_qty*rep_interval*duration;
									}
									else if (freq_nature.equals("O")) {
										ing_order_qty = in_tot_qty;
									}
								}
								else{
									//24561: at last we r multiplying with ing_durn
									in_tot_qty	=   in_tot_qty*ing_durn;
								}
								// Ends (Not for IVD)
								if(!iv_pb.equals("Y") && fract_dose.equals("Y")){ //???
									ing_order_qty = in_tot_qty;
								}				
								if(!fract_dose.equals("Y")){
									if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									} 
									else {
										if(((String)drugDetails.get("STOCK_UOM")).equals(qty_unit)){
											ing_order_qty	=   in_tot_qty;//*ing_durn;
										}
										else{
											//	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
											ing_order_qty	=   new Double(Math.ceil((in_tot_qty)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
										}
									}
								}
							}

							pstmt_insert.setString(18, ing_unit_qty+"");
							pstmt_insert.setString(19, ing_order_uom);
							pstmt_insert.setString(20, freq_code);
							
							//	pstmt_insert.setString(22, "H"); for multi freq crf
							if(iv_pb.equals("Y")){
								pstmt_insert.setString(21, (String)orderDetails.get("DURN_VALUE_ACT"));
								pstmt_insert.setString(22, (String)orderDetails.get("DURN_UNIT"));
							}
							else{
								if(((String)orderDetails.get("IVType")).equals("IVD")){
									pstmt_insert.setString(21, (String)orderDetails.get("DURN_VALUE"));
								}
								else{
									pstmt_insert.setString(21, durn_val_for_freq+"");
								}
								pstmt_insert.setString(22, "H");
							}
							if (drugRemarks.size() > 0) {
					
								if (drugRemarks.size() > j) {
									HashMap DrugValues = (HashMap)drugRemarks.get(j);
									line_display_text = (String)DrugValues.get("order_format_values");
								} 
								else {
									line_display_text = "";
								}
							} 
							else {
								line_display_text = "";
							}

							drugDetails.put("FINAL_ORD_QTY",ing_order_qty+"");

							pstmt_insert.setString(23, line_display_text);
							pstmt_insert.setString(24, "");
							pstmt_insert.setString(25, null);
							pstmt_insert.setString(26, end_date);
							pstmt_insert.setString(27, null);
							pstmt_insert.setString(28, Math.ceil(ing_order_qty)+""); // order_qty
							pstmt_insert.setString(29, stock_uom);
							pstmt_insert.setString(30, "N");
							pstmt_insert.setString(31, null);
							pstmt_insert.setString(32, "");
							pstmt_insert.setString(33, "N");
							pstmt_insert.setString(34, "N");
							pstmt_insert.setString(35, "N");
							pstmt_insert.setString(36, "CO");
							pstmt_insert.setString(37, "N");
							pstmt_insert.setString(38, "");
							pstmt_insert.setString(39, "N");
							pstmt_insert.setString(40, "");
							pstmt_insert.setString(41, "");
							pstmt_insert.setString(42, "");
							pstmt_insert.setString(43, "");
							pstmt_insert.setString(44, pract_id);
							pstmt_insert.setString(45, null);
							pstmt_insert.setString(46,"");
							pstmt_insert.setString(47, null);
							pstmt_insert.setString(48, "");
							pstmt_insert.setString(49, null);
							pstmt_insert.setString(50, "");
							pstmt_insert.setString(51, null);
							pstmt_insert.setString(52, "");
							pstmt_insert.setString(53, null);
							pstmt_insert.setString(54, "");
							pstmt_insert.setString(55, null);   
							pstmt_insert.setString(56, "");
							pstmt_insert.setString(57, "");
							pstmt_insert.setString(58, ord_status);
							pstmt_insert.setString(59, "");
							pstmt_insert.setString(60, login_by_id);
							pstmt_insert.setString(61, login_at_ws_no);
							pstmt_insert.setString(62, login_facility_id);
							pstmt_insert.setString(63, login_by_id);
							pstmt_insert.setString(64, login_at_ws_no);
							pstmt_insert.setString(65, login_facility_id);
							pstmt_insert.setString(66, (String)drugDetails.get("CONSENT_REQD_YN"));
							pstmt_insert.setString(67, "");
							pstmt_insert.setString(68, short_desc);
							pstmt_insert.setString(69, short_desc);
							pstmt_insert.setString(70, "N");
							pstmt_insert.setString(71,(String)drugDetails.get("CONSENT_STAGE")); //ORD_CONSENT_STAGE
							pstmt_insert.setString(72,(String)drugDetails.get("CONSENT_STATUS")); //ORD_CONSENT_STATUS
							pstmt_insert.setString(73,(String)drugDetails.get("NUM_OF_CONSENT_REQ_BO")); //NUM_OF_CONSENT_REQ_BO
							pstmt_insert.setString(74,(String)drugDetails.get("NUM_OF_CONSENT_REQ_BR")); //NUM_OF_CONSENT_REQ_BR
							pstmt_insert.setString(75,(String)drugDetails.get("CATALOG_SPLTY_CODE")); //CATALOG_SPLTY_CODE
							pstmt_insert.addBatch();
						}
					}
					closeResultSet( resultSet ) ;
					closeStatement(pstmt_select2);
					closeStatement(pstmt_select);
					int[] batch_result = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result.length;i++) {
						if(batch_result[i] < 0  && batch_result[i] != -2 ) {
							System.err.println("IV ADDITIVES/INTEMITENT --> ERROR IN INSERTING INGREDIANT INTO OR_ORDER_LINE batch_result["+i+"]= "+batch_result[i]);
							System.err.println("tabData=== "+tabData);
							result = 0;
							break;
						}
						else {
							result = 1;
						}
					}
				}
				closeStatement(pstmt_insert);
			}

			// OR_ORDER_LINE_PH
			if (result>0) {
				float fld_tot_strength	= 0.0f;
				float fld_unit_strength	= 0.0f;
				String fld_strength_uom	= "";
				float flow_rate = 0.0f;
				String mfr_yn = "";
				
				String interval_value="";
				String repeat_value="";

				pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));
				pstmt_select3.setString(1, freq_code);
				resultSet		= pstmt_select3.executeQuery();
				if(resultSet.next()) {
					interval_value = resultSet.getString("interval_value")==null?"1":resultSet.getString("interval_value"); //null handled for SRR20056-SCF-7281
					repeat_value   = resultSet.getString("repeat_value")==null?"1":resultSet.getString("repeat_value"); //null handled for SRR20056-SCF-7281
				}
				closeResultSet( resultSet );					
				closeStatement(pstmt_select3);
				PreparedStatement pstmt_get_MARBarcodeId	= connection.prepareStatement((String)sqlMap.get("SQL_PH_GEN_MARDARCODEID")) ; //added for  MMS-QH-CRF-0080 [IN:038064]
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT3A"));
				// OR_ORDER_LINE_PH FLUIDS
				if(flag.equals("N")){
					pstmt_insert.clearBatch();
					pstmt_insert.setString(1, order_number); // ORDER_ID
					pstmt_insert.setString(2, "1"); //ORDER_LINE_NUM
					pstmt_insert.setString(3, (String)fluidDetails.get("GENERIC_ID")); //GENERIC_ID
					pstmt_insert.setString(4, (String)fluidDetails.get("FORM_CODE")); //FORM_CODE
					pstmt_insert.setString(5, ""); //TRADE_CODE
					mfr_yn = (String)orderDetails.get("MFR_YN")==null?"N":(String)orderDetails.get("MFR_YN");
					if(fluidDetails.get("IN_FORMULARY_YN")!=null && !((String)fluidDetails.get("IN_FORMULARY_YN")).equals(""))
						pstmt_insert.setString(6, (String)fluidDetails.get("IN_FORMULARY_YN")); //FORMULARY_ITEM_YN
					else
						pstmt_insert.setString(6, "N"); //FORMULARY_ITEM_YN

					pstmt_insert.setString(7, (String)fluidDetails.get("DOSAGE_TYPE")); //DOSAGE_TYPE
					pstmt_insert.setString(8, ""); //SPLIT_DRUG_PREVIEW
					fld_tot_strength	= 0.0f;
					fld_unit_strength	= 0.0f;
					fld_strength_uom	= "";
					flow_rate = 0.0f;
					if (fluidDetails.get("DOSAGE_TYPE").toString().equals("S")) {
						if(!mfr_yn.equals("Y")){
							flow_rate		= Float.parseFloat(orderDetails.get("SCH_INFUSION_RATE").toString());
							fld_unit_strength	= Float.parseFloat(fluidDetails.get("STRENGTH_VALUE").toString());
							fld_tot_strength	= flow_rate*fld_unit_strength;
						}
						fld_strength_uom	= (String)fluidDetails.get("STRENGTH_UOM");
					}

					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(9, (String)orderDetails.get("FLUID_UNIT_QTY")); //TOT_STRENGTH
					else
						pstmt_insert.setString(9, fld_tot_strength+""); //TOT_STRENGTH

					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(10, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));//TOT_STRENGTH_UOM
					else
						pstmt_insert.setString(10, fld_strength_uom);//TOT_STRENGTH_UOM
					if(mfr_yn.equals("Y")){
						pstmt_insert.setString(11, "");//INFUSE_OVER
						pstmt_insert.setString(12, "");//INFUSE_OVER_UNIT
						pstmt_insert.setString(13, "");//INFUSION_RATE
						pstmt_insert.setString(14, "");//INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(15, "");//INFUSION_PER_UNIT
						pstmt_insert.setString(57, "");//ORIG_INFUSE_OVER
						pstmt_insert.setString(58, "");//ORIG_INFUSION_RATE
						pstmt_insert.setString(59, "");//Added for  ML-BRU-CRF-072[Inc:29938]
						pstmt_insert.setString(60, "");//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_RATE
						pstmt_insert.setString(61, "");//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_QTY_UNIT
					}
					else{
						pstmt_insert.setString(11, (String)orderDetails.get("INFUSE_OVER"));//INFUSE_OVER
						pstmt_insert.setString(12, (String)orderDetails.get("INFUSE_OVER_UNIT"));//INFUSE_OVER_UNIT
						pstmt_insert.setString(13, (String)orderDetails.get("SCH_INFUSION_RATE"));//INFUSION_RATE
						pstmt_insert.setString(14, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));//INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(15, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));//INFUSION_PER_UNIT
						pstmt_insert.setString(57, (String)orderDetails.get("INFUSE_OVER"));//ORIG_INFUSE_OVER
						pstmt_insert.setString(58, (String)orderDetails.get("SCH_INFUSION_RATE"));//ORIG_INFUSION_RATE
						pstmt_insert.setString(59, drug_indication);//Added for  ML-BRU-CRF-072[Inc:29938]
						pstmt_insert.setString(60, (String)orderDetails.get("SCH_INFUSION_RATE"));//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_RATE
						pstmt_insert.setString(61, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_QTY_UNIT
					}
					pstmt_insert.setString(16, "N");//BROUGHT_BY_PATIENT_YN
					pstmt_insert.setString(17, "N");//CUR_DRUG_YN
					pstmt_insert.setString(18, "N");//REFILL_DRUG_YN
					pstmt_insert.setString(19, "");//DISPENSING_LOC_TYPE
					pstmt_insert.setString(20, "");//DISPENSING_LOC
					pstmt_insert.setString(21, "");//DISPENSING_STORE
					pstmt_insert.setString(22, "");//IP_FILL_PROCESS
					pstmt_insert.setString(23, "");//IP_FILL_PRD_AHEAD
					pstmt_insert.setString(24, null);//NEXT_FILL_DATE
					pstmt_insert.setString(25, "");//LAST_FILL_QTY
					pstmt_insert.setString(26, "");//DISPENSED_QTY
		
					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(27, (String)fluidDetails.get("FINAL_ORD_QTY"));	//BMS_QTY				
					else
						pstmt_insert.setString(27, fluid_ord_qty); //BMS_QTY
					
					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(28, (String)orderDetails.get("FLUID_UNIT_QTY")); //BMS_STRENGTH
					else
						pstmt_insert.setString(28, fld_tot_strength+"");//BMS_STRENGTH
					
					pstmt_insert.setString(29, login_by_id);
					pstmt_insert.setString(30, login_at_ws_no);
					pstmt_insert.setString(31, login_facility_id);
					pstmt_insert.setString(32, login_by_id);
					pstmt_insert.setString(33, login_at_ws_no);
					pstmt_insert.setString(34, login_facility_id);
					pstmt_insert.setString(35, "N");//SPLIT_DOSE_YN

					if(((String)orderDetails.get("IVType")).equals("IVD") && !(iv_pb.equals("Y"))){
						float dur1 = Float.parseFloat(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"") ;
						if(iv_calc_infuse_by.equals("I")) //if block added for SKR-CRF-0035 [IN:037727] 
							dur1 = 1.0f;
						float qty_value = Float.parseFloat(Math.ceil(Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY")) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE")))*dur1+"");

						pstmt_insert.setString(36, qty_value+"");//QTY_VALUE_SPLIT_DOSE
					}
					else {
						pstmt_insert.setString(36, (fld_unit_qty)+"");//QTY_VALUE_SPLIT_DOSE
					}
					pstmt_insert.setString(37, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));//QTY_UNIT_SPLIT_DOSE
					
					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(38, (String)orderDetails.get("FLUID_UNIT_QTY"));//STRENGTH_VALUE
					else
						pstmt_insert.setString(38, fld_unit_strength+"");//STRENGTH_VALUE

					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(39, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));//STRENGTH_UOM
					else
						pstmt_insert.setString(39, fld_strength_uom);//STRENGTH_UOM
					if(((String)orderDetails.get("IVType")).equals("IVD")){
						// before (String)orderDetails.get("FLUID_UNIT_QTY") was inserted which is wrong, prescribed qty should be unit qty * repeat value for the duration. -- 25857 --- 7/3/11
						
						if(iv_pb.equals("Y")){
							fluid_ord_qty = fld_unit_qty * Float.parseFloat((String)orderDetails.get("DURN_VALUE")) * rep_interval+"";
							if(freq_nature.equals("I")){ // 7/3/11 whole if block
								// fluid_ord_qty =  ( fld_unit_qty * (Float.parseFloat((String)orderDetails.get("DURN_VALUE"))/int_value)/ Float.parseFloat((String)orderDetails.get("INFUSE_OVER")) )+"";
								fluid_ord_qty =  ( fld_unit_qty * (Float.parseFloat((String)orderDetails.get("DURN_VALUE"))/int_value) )+"";
							}
						}
						else{
							fluid_ord_qty = ( fld_unit_qty * Float.parseFloat((String)orderDetails.get("DURN_VALUE")) * rep_interval/ Float.parseFloat((String)orderDetails.get("INFUSE_OVER")) )+"";
						}
						

						pstmt_insert.setString(40, fluid_ord_qty);//PRES_QTY_VALUE
					}
					else{
						pstmt_insert.setString(40, fluid_ord_qty);//PRES_QTY_VALUE
					}

					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(41, (String)fluidDetails.get("PRES_BASE_UOM"));//PRES_QTY_UOM
					else
						pstmt_insert.setString(41, (String)orderDetails.get("BASE_UOM"));//PRES_QTY_UOM

					if(flag.equals("Y")){
						if(drugDtls.size() != 0){
							pstmt_insert.setString(42, (String)drugDtls.get("ALLERGY_REMARKS"));
							pstmt_insert.setString(43, (String)drugDtls.get("DOSE_REMARKS"));
							pstmt_insert.setString(44, (String)drugDtls.get("CURRENTRX_REMARKS"));
							//Added for IN:072715 start
							pstmt_insert.setString(64, (String)drugDtls.get("ALLERGY_REMARKS_CODE"));
							pstmt_insert.setString(65, (String)drugDtls.get("DOSE_REMARKS_CODE"));
							pstmt_insert.setString(66, (String)drugDtls.get("CURRENTRX_REMARKS_CODE"));
							//Added for IN:072715 end
						}
					}
					else{
						pstmt_insert.setString(42, (String)fluidDetails.get("ALLERGY_REMARKS"));
						pstmt_insert.setString(43, (String)fluidDetails.get("DOSE_REMARKS"));
						pstmt_insert.setString(44, (String)fluidDetails.get("CURRENTRX_REMARKS"));
						//Added for IN:072715 start
						pstmt_insert.setString(64, (String)fluidDetails.get("ALLERGY_REMARKS_CODE"));
						pstmt_insert.setString(65, (String)fluidDetails.get("DOSE_REMARKS_CODE"));
						pstmt_insert.setString(66, (String)fluidDetails.get("CURRENTRX_REMARKS_CODE"));
						//Added for IN:072715 end
					}
					//if condition added for multi freq crf
					if(iv_pb.equals("Y")){
						pstmt_insert.setString(45, (String)orderDetails.get("DURN_VALUE_ACT"));//TOT_INFUSION_OVER
						pstmt_insert.setString(46, (String)orderDetails.get("DURN_UNIT"));//TOT_INFUSION_OVER_UNIT
					}
					else{
						pstmt_insert.setString(45, (String)orderDetails.get("DURN_VALUE"));
						pstmt_insert.setString(46, "H");
					}
					if(mfr_yn.equals("Y"))
						pstmt_insert.setString(47, "");//ADMIN_RATE_DETAIL
					else	
						pstmt_insert.setString(47, (String)tabData.get("Admin_rate"));

					pstmt_insert.setString(48, (String)tabData.get("fluid_remarks"));//CHNGD_FLUID_REMARKS

					pstmt_insert.setString(49, (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")); //BL_INCL_EXCL_OVERRIDE_VALUE
					pstmt_insert.setString(50, (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")); //BL_INCL_EXCL_OVERRIDE_REASON

					pstmt_insert.setString(51, buildMAR_yn);
					pstmt_insert.setString(52, mfr_yn);
					pstmt_insert.setString(53, "");  //CALC_DOSE_BASED_ON	
					pstmt_insert.setString(54, "");  //CALC_DOSE_VALUE	
					pstmt_insert.setString(55, "");  //CALC_DOSE_BY	
					pstmt_insert.setString(56, (String)orderDetails.get("MFR_REMARKS"));  //MFR_REMARKS	
					//pstmt_insert.setString(57, "");//ORIG_INFUSE_OVER  // commented for insternal server error while doing admin remarks
					//pstmt_insert.setString(58, "");//ORIG_INFUSION_RATE
					//pstmt_insert.setString(59, (String)fluidDetails.get("DRUG_INDICATION"));//Added for  ML-BRU-CRF-072[Inc:29938]
					MAR_barcode_id="";//added for  MMS-QH-CRF-0080 [IN:038064] -start
					if(buildMAR_yn.equals("Y") && print_mar_label.equals("Y") &&  print_mar_barcode.equals("Y")  && !(iv_prep.equals("2") || iv_prep.equals("4"))){ 
						pstmt_get_MARBarcodeId.setString(1,login_facility_id);
						resultSet = pstmt_get_MARBarcodeId.executeQuery();
						if(resultSet!=null && resultSet.next())
							MAR_barcode_id = resultSet.getString("MAR_BARCODE_ID");
					}
					orderDetails.put("MAR_BARCODE_ID",MAR_barcode_id);
					pstmt_insert.setString(62,MAR_barcode_id);//added for MMS-QH-CRF-0080 [IN:038064] -end
					pstmt_insert.setString(63,"N");
					pstmt_insert.setString(67, (String)fluidDetails.get("ABUSE_OVERRIDE"));//added for aakh-crf-0140
					pstmt_insert.setString(68, (String)fluidDetails.get("abuse_override_remarks"));//added for aakh-crf-0140
					
					try{
						result=pstmt_insert.executeUpdate();
					}
					catch(Exception e){
						System.err.println("IV ADDITIVES/INTEMITENT --> ERROR IN INSERTING FLUID INTO OR_ORDER_LINE_PH");
						e.printStackTrace();
						System.err.println("tabData=== "+tabData);
					}
				}
				// OR_ORDER_LINE_PH INGREDIENTS
				if(result > 0){
					float ing_unit_qty		= 0.0f;
					float ing_order_qty		= 0.0f;
					String ing_order_uom	= "";
					float ing_unit_strength	= 0.0f;
					float ing_tot_strength	= 0.0f;
					String ing_strength_uom = "";
					String tmp_qty = "";
					float unit_qty = 0.0f;
					String prescribed_qty = "";
					// vars to cal pres_qty 
					String qty_value1 = "";
					String durn_value = "";
					HashMap drugDetails = null;
					String allow_alternate = "N";//GHL-CRF-0549
					//double durn_value1 = 0.0f;
					//String  interval_value = null;
					//String  repeat_value = null;
					pstmt_insert.clearBatch();
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
					if(flag.equals("N"))
						srlNo = 1;
					else
						srlNo = 0;

					for(int j=0;j<drugList.size();j++) {
						drugDetails = (HashMap)drugList.get(j);
						if (drugDetails.size() != 0) {
							// vars to cal pres_qty  start
							//added for SRR20056-SCF-7870 IN028956 -Start
							strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
							strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
							content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
							allow_alternate				=    (String)drugDetails.get("allow_alternate")==null?"N":(String)drugDetails.get("allow_alternate");
							//added for GHL-CRF-0549
							
							durn_value	=(String)orderDetails.get("DURN_VALUE");

							if(iv_pb.equals("Y")) {   
								qty_value1					=(String)orderDetails.get("QTY_VALUE");	
							} 
							else {
								qty_value1					=(String)drugDetails.get("QTY_VALUE");
								freq_nature="C";
							}
							if(iv_pb.equals("Y")){        
								/*durn_value1                   = Math.ceil(Double.parseDouble(durn_value)/24);
								durn_value			        =String.valueOf(durn_value1);*/
							}
							else{
								durn_value                   = String.valueOf(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"");
							}
// below if condition was added so that for ivd repeat value wil be 1. without the condition repeat value would be null. and the below -'if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  )' condition wil fail. hence wrong pres qty calculation inc-26520
							if(!iv_pb.equals("Y")){
								repeat_value="1";
							}
					
							// vars to cal pres_qty end
							pstmt_insert.setString(1, order_number);
							pstmt_insert.setString(2, (++srlNo)+"");
							pstmt_insert.setString(3, (String)drugDetails.get("GENERIC_ID"));
							pstmt_insert.setString(4, (String)drugDetails.get("FORM_CODE"));
							pstmt_insert.setString(5, "");

						   if(drugDetails.get("IN_FORMULARY_YN")!=null && !((String)drugDetails.get("IN_FORMULARY_YN")).equals(""))
							   pstmt_insert.setString(6, (String)drugDetails.get("IN_FORMULARY_YN"));
						   else
							   pstmt_insert.setString(6, "N");

							//pstmt_insert.setString(6, "N");

							String dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							pstmt_insert.setString(7, dosage_type);
							pstmt_insert.setString(8, "");

							if (dosage_type.equals("S")) {
								ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								//ing_order_uom	= (String)STRENGTH_UOM");
								ing_order_uom	= (String)drugDetails.get("PRES_BASE_UOM");
								if (freq_nature.equals("I")) {
									//ing_order_qty = ing_unit_qty*duration*(24/int_value);
									ing_order_qty = ing_unit_qty*duration;
								}
								else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									ing_order_qty = ing_unit_qty*rep_interval*duration;
								}
								else if (freq_nature.equals("O")) {
									ing_order_qty = ing_unit_qty;
								}
								if(!mfr_yn.equals("Y")){
									flow_rate		= Float.parseFloat(orderDetails.get("SCH_INFUSION_RATE").toString());
									ing_unit_strength	= Float.parseFloat(drugDetails.get("STRENGTH_VALUE").toString());
									ing_tot_strength	= flow_rate*ing_unit_strength;
								}
								ing_strength_uom	= (String)drugDetails.get("STRENGTH_UOM");

								if((String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN")!=null && ((String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN")).equals("Y")){
									unit_qty	=(float) Math.ceil(ing_unit_qty/Float.parseFloat((String)drugDetails.get("STRENGTH_PER_PRES_UOM")));	
								}
								else{
									unit_qty	=(float) ing_unit_qty/Float.parseFloat((String)drugDetails.get("STRENGTH_PER_PRES_UOM"));	
								}
								tmp_qty			=   unit_qty *duration * rep_interval+"";
								//	prescribed_qty	= ( Float.parseFloat(tmp_qty)*Float.parseFloat((String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM"))) /Float.parseFloat((String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM"));


								float ord_qty	=0.0f;
								
								if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	

									ord_qty		=((Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value)*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
								//	ord_qty		=new Double(Math.ceil(ord_qty)).floatValue();
//CRF_SRR20056-CRF-0537.1  For handle the Decimals REMOVED Math.Ceil
									if(freq_nature.equals("F") || freq_nature.equals("I")) { // 7/3/11
										ord_qty	=	Float.parseFloat(ord_qty/ Integer.parseInt(interval_value)+"");

									}
								}
								else{
									ord_qty = ing_order_qty;
								}
//CRF_SRR20056-CRF-0537.1  For handle the Decimals REMOVED Math.Ceil
								prescribed_qty=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));
							}
							else{  // dosage_type = "Q"
								ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
								String qty_unit		= (String)drugDetails.get("QTY_DESC_CODE");
								String equl_value	= "1";

								pstmt_select.setString(1, ing_order_uom);
								pstmt_select.setString(2, qty_unit);
								pstmt_select.setString(3, ing_order_uom);
								pstmt_select.setString(4, qty_unit);
								resultSet	= pstmt_select.executeQuery();

								if (resultSet.next()) {
									equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
								}

								closeResultSet( resultSet );
								float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
								if (freq_nature.equals("I")) {
									ing_order_qty = in_tot_qty*duration*(24/int_value);
								} 
								else if (freq_nature.equals("F") ) {
									ing_order_qty = in_tot_qty*rep_interval*duration;
								}
								else if(freq_nature.equals("C")){
									ing_order_qty = in_tot_qty*rep_interval;
								}
								else if (freq_nature.equals("O")) {
									ing_order_qty = in_tot_qty;
								}
							//	prescribed_qty			=   ing_order_qty;
								ing_strength_uom	= (String)drugDetails.get("PRES_BASE_UOM");

								float ord_qty=0.0f;			   
								if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
								
									ord_qty		=	(Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));
									if(ord_qty==0)
										ord_qty	=	1;
								}else{
									ord_qty = ing_order_qty;
								}

								if(freq_nature.equals("F")) {

//CRF_SRR20056-CRF-0537.1  For handle the Decimals REMOVED Math.Ceil
								   ord_qty	=	Float.parseFloat(ord_qty/ Integer.parseInt(interval_value)+"");

								}else if(freq_nature.equals("C")){ //25857 before for both F and C it was same.
									ord_qty	=	Float.parseFloat(ord_qty * (Float.parseFloat((String)orderDetails.get("DURN_VALUE") ) / Float.parseFloat((String)orderDetails.get("INFUSE_OVER") ))+"");
								}
/** @  CRF_SRR20056-CRF-0537.1  For handle the Decimals in QOH,  								
								prescribed_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));**/
								prescribed_qty=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));
							}

							if(((String)orderDetails.get("IVType")).equals("IVD"))
								pstmt_insert.setString(9, (String)drugDetails.get("QTY_VALUE"));
							else
								pstmt_insert.setString(9, ing_tot_strength+"");

							pstmt_insert.setString(10, ing_strength_uom);
							pstmt_insert.setString(11, (String)orderDetails.get("INFUSE_OVER"));
							pstmt_insert.setString(12, (String)orderDetails.get("INFUSE_OVER_UNIT"));
							pstmt_insert.setString(13, (String)orderDetails.get("SCH_INFUSION_RATE"));
							pstmt_insert.setString(14, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
							pstmt_insert.setString(15, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
							pstmt_insert.setString(16, "N");
							pstmt_insert.setString(17, "N");
							pstmt_insert.setString(18, "N");
							pstmt_insert.setString(19, "");
							pstmt_insert.setString(20, "");
							pstmt_insert.setString(21, "");
							pstmt_insert.setString(22, "");
							pstmt_insert.setString(23, "");
							pstmt_insert.setString(24, null);
							pstmt_insert.setString(25, "");		
							pstmt_insert.setString(26, "");				
							String bms_qty =  (String)drugDetails.get("FINAL_ORD_QTY");
							if(((String)orderDetails.get("IVType")).equals("IVD")){
								// pstmt_insert.setString(27, (String)drugDetails.get("FINAL_ORD_QTY"));
								pstmt_insert.setString(27, (Math.ceil(Double.parseDouble(bms_qty)))+"");
								
							} 
							else {
								// pstmt_insert.setString(27, (String)drugDetails.get("FINAL_ORD_QTY"));
								pstmt_insert.setString(27, (Math.ceil(Double.parseDouble(bms_qty)))+"");
							}

							if(((String)orderDetails.get("IVType")).equals("IVD")){						
								pstmt_insert.setString(28, (drugDetails.get("STRENGTH_VALUE").toString())+"");
							}
							else {
								pstmt_insert.setString(28, ing_tot_strength+"");
							}
								
							pstmt_insert.setString(29, login_by_id);
							pstmt_insert.setString(30, login_at_ws_no);
							pstmt_insert.setString(31, login_facility_id);
							pstmt_insert.setString(32, login_by_id);
							pstmt_insert.setString(33, login_at_ws_no);
							pstmt_insert.setString(34, login_facility_id);
							pstmt_insert.setString(35, "N");

							if(((String)orderDetails.get("IVType")).equals("IVD")){
								pstmt_insert.setString(36, Math.round(ing_unit_qty)+"");
							} 
							else {
								pstmt_insert.setString(36, (ing_unit_qty)+"");
							}
							pstmt_insert.setString(37, ing_order_uom);
							pstmt_insert.setString(38, ing_unit_strength+"");
							pstmt_insert.setString(39, ing_strength_uom);
							if(((String)orderDetails.get("IVType")).equals("IVD")){
								pstmt_insert.setString(40, prescribed_qty);
							}
							else {
								pstmt_insert.setString(40, prescribed_qty);
							}
						
	// Modified to BASE_UOM ...on 13/5/2004....
	
							if(((String)orderDetails.get("IVType")).equals("IVD")){
								//pstmt_insert.setString(41, (String)orderDetails.get("BASE_UOM"));
								pstmt_insert.setString(41, (String)drugDetails.get("PRES_BASE_UOM"));
							}
							else{
								pstmt_insert.setString(41, ing_order_uom);
							}

							pstmt_insert.setString(42, (String)drugDetails.get("ALLERGY_REMARKS"));
							pstmt_insert.setString(43, (String)drugDetails.get("DOSE_REMARKS"));
							pstmt_insert.setString(44, (String)drugDetails.get("CURRENTRX_REMARKS"));
							//Added for IN:072715 start
							pstmt_insert.setString(64, (String)drugDtls.get("ALLERGY_REMARKS_CODE"));
							pstmt_insert.setString(65, (String)drugDtls.get("DOSE_REMARKS_CODE"));
							pstmt_insert.setString(66, (String)drugDtls.get("CURRENTRX_REMARKS_CODE"));
							//Added for IN:072715 end
//if condition added for multi freq crf
							if(iv_pb.equals("Y")){
								pstmt_insert.setString(45, (String)orderDetails.get("DURN_VALUE_ACT"));
								pstmt_insert.setString(46, (String)orderDetails.get("DURN_UNIT"));
							}else{
								pstmt_insert.setString(45, (String)orderDetails.get("DURN_VALUE"));
								pstmt_insert.setString(46, "H");
							}


							pstmt_insert.setString(47, (String)tabData.get(""));
							pstmt_insert.setString(48, (String)tabData.get(""));

							pstmt_insert.setString(49, (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")); //BL_INCL_EXCL_OVERRIDE_VALUE
							pstmt_insert.setString(50, (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")); //BL_INCL_EXCL_OVERRIDE_REASON

							pstmt_insert.setString(51, buildMAR_yn);
							pstmt_insert.setString(52, mfr_yn);	
							pstmt_insert.setString(53, (String)drugDetails.get("CALC_DOSE_BASED_ON"));  //CALC_DOSE_BASED_ON	
							pstmt_insert.setString(54, (String)drugDetails.get("CALC_DOSE_VALUE"));  //CALC_DOSE_VALUE	
							pstmt_insert.setString(55, (String)drugDetails.get("CALC_DOSE_BY"));
							pstmt_insert.setString(56, (String)orderDetails.get("MFR_REMARKS"));  //MFR_REMARKS//CALC_DOSE_BY	
							pstmt_insert.setString(57, (String)orderDetails.get("INFUSE_OVER"));//ORIG_INFUSE_OVER
							pstmt_insert.setString(58, (String)orderDetails.get("SCH_INFUSION_RATE"));//ORIG_INFUSION_RATE
							pstmt_insert.setString(59, (String)drugDetails.get("DRUG_INDICATION"));//Added for  ML-BRU-CRF-072[Inc:29938]
							pstmt_insert.setString(60, (String)orderDetails.get("SCH_INFUSION_RATE"));//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_RATE
							pstmt_insert.setString(61, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_QTY_UNIT
							MAR_barcode_id=orderDetails.get("MAR_BARCODE_ID")==null?"":(String)orderDetails.get("MAR_BARCODE_ID");//added for  MMS-QH-CRF-0080 [IN:038064] -start
							if(buildMAR_yn.equals("Y") && print_mar_label.equals("Y") &&  print_mar_barcode.equals("Y") && MAR_barcode_id.equals("") && !(iv_prep.equals("2") || iv_prep.equals("4"))){ 
								pstmt_get_MARBarcodeId.setString(1,login_facility_id);
								resultSet = pstmt_get_MARBarcodeId.executeQuery();
								if(resultSet!=null && resultSet.next())
									MAR_barcode_id = resultSet.getString("MAR_BARCODE_ID");
							}
							orderDetails.put("MAR_BARCODE_ID",MAR_barcode_id);
							pstmt_insert.setString(62,MAR_barcode_id);//added for MMS-QH-CRF-0080 [IN:038064] -end
							pstmt_insert.setString(63,allow_alternate);//GHL-CRF-0549
							
							pstmt_insert.setString(67, (String)drugDetails.get("ABUSE_EXISTS"));//added for aakh-crf-0140
							pstmt_insert.setString(68, (String)drugDetails.get("abuse_override_remarks"));//added for aakh-crf-0140
							
							pstmt_insert.addBatch();
						}
					}
					closeStatement(pstmt_select);
					closeStatement( pstmt_get_MARBarcodeId) ;
					int[] batch_result = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result.length;i++) {
						if(batch_result[i] < 0  && batch_result[i] != -2 ) {
							result = 0;
							System.err.println("IV ADDITIVES/INTEMITENT --> ERROR IN INSERTING INGREDIANT INTO OR_ORDER_LINE_PH batch_result["+i+"]= "+batch_result[i]);
							System.err.println("tabData=== "+tabData);
							break;
						}
						else {
							result = 1;
						}
					}
				}
				closeStatement(pstmt_insert);
			}
			// INSERTING INTO OR_ORDER_LINE_PH_MFR
			if(result>0){

				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));
				HashMap mfrRecs = (HashMap)orderDetails.get("MFR_Recs");
				String totRecs = (String)mfrRecs.get("totRec")==null?"0":(String)mfrRecs.get("totRec");
				ArrayList rec = new ArrayList();
				//int ins=0;
				for(int k=1; k<= Integer.parseInt(totRecs); k++){
					rec	= (ArrayList)mfrRecs.get("MFR"+k);

					pstmt_insert.setString(1, order_number); // ORDER_ID
					pstmt_insert.setString(2, "1"); //ORDER_LINE_NUM
					pstmt_insert.setString(3, k+""); //SL_NO
					pstmt_insert.setString(4, (String)rec.get(0)); //TOT_STRENGTH - volume
					pstmt_insert.setString(5, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //TOT_STRENGTH_UOM
					pstmt_insert.setString(6, (String)rec.get(5)); //INFUSE_OVER
					pstmt_insert.setString(7, (String)orderDetails.get("INFUSE_OVER_UNIT")); //INFUSE_OVER_UNIT
					pstmt_insert.setString(8, (String)rec.get(1)); //INFUSION_RATE
					pstmt_insert.setString(9, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //INFUSION_VOL_STR_UNIT
					pstmt_insert.setString(10, (String)rec.get(2)); //INFUSION_PER_UNIT
					pstmt_insert.setString(11,(String)rec.get(10) ); //GAP_DURATION_IN_HRS
					pstmt_insert.setString(12, (String)rec.get(11)); //ADMIN_RATE_DETAIL

					pstmt_insert.setString(13, com.ehis.util.DateUtils.convertDate((String)rec.get(6),"DMYHM",lang_id,"en")); //START_DATE_TIME
					pstmt_insert.setString(14, com.ehis.util.DateUtils.convertDate((String)rec.get(7),"DMYHM",lang_id,"en")); //END_DATE_TIME

					pstmt_insert.setString(15, login_by_id); //ADDED_BY_ID
					pstmt_insert.setString(16, login_at_ws_no); //ADDED_AT_WS_NO
					pstmt_insert.setString(17, login_facility_id); //ADDED_FACILITY_ID
					pstmt_insert.setString(18, login_by_id); //MODIFIED_BY_ID
					pstmt_insert.setString(19, login_at_ws_no); //MODIFIED_AT_WS_NO
					pstmt_insert.setString(20, login_facility_id); // MODIFIED_FACILITY_ID
					pstmt_insert.addBatch();
					//ins = pstmt_insert.executeUpdate();
				}
				int[] or_order_line_ph_mfr_result = pstmt_insert.executeBatch();
				
				for (int i=0;i<or_order_line_ph_mfr_result.length;i++) {
					if(or_order_line_ph_mfr_result[i] < 0  && or_order_line_ph_mfr_result[i] != -2 ) {
						System.err.println("IV ADDITIVES/INTEMITENT --> ERROR IN INSERTING  INTO OR_ORDER_LINE_PH_MFR or_order_line_ph_mfr_result["+i+"]= "+or_order_line_ph_mfr_result[i]);
						System.err.println("tabData=== "+tabData);
						result = 0;
						break;
					}
					else {
						result = 1;
					}
				}
				closeStatement(pstmt_insert);
			}
			// PH_PATIENT_DRUG_PROFILE
			if (result>0) {
				float fld_tot_strength	= 0.0f;
				float fld_unit_strength	= 0.0f;
				String fld_strength_uom	= "";
				float flow_rate = 0.0f;
				pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT55"));
				pstmt_select.setString(1, patient_id);
				resultSet		= pstmt_select.executeQuery();
				int srl_NO		= 0;
				int cnt			= 1;

				if(resultSet.next()) {
					srl_NO = resultSet.getInt("NEXT_SRL_NO");
				}
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
				// PH_PATIENT_DRUG_PROFILE FLUID
				String  pres_base_uom				=(String)fluidDetails.get("PRES_BASE_UOM");
				String  qty_unit					=(String)fluidDetails.get("PRES_QTY_UOM");
				String  equl_value					=null;
				String  qty_value1					="";
				String  fract_dose            		=null;
				String  in_pres_qty_value			=null;
				String  interval_value				=null;
				String  repeat_value				=null;
				String  drug_code					= (String)fluidDetails.get("DRUG_CODE");
				String  dosage_type					="";
				ArrayList frequencyValues	= new ArrayList();
				String split_dose_preview			= "";
				String  durn_value					="";
				double  durn_value1                 =0.f;
				String diag_text	= "";
				String height		= "";
				String height_unit  = "";
				String weight		= "";
				String weight_unit  = "";

				if(flag.equals("N")){
					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT4"));
					System.out.println("2751 SQL_PH_PRESCRIPTION_INSERT4");
					pstmt_insert.setString(cnt, patient_id);
					pstmt_insert.setString(++cnt, srl_NO + "");
					pstmt_insert.setString(++cnt, login_facility_id);
					pstmt_insert.setString(++cnt, encounter_id);
					pstmt_insert.setString(++cnt, patient_class);
					pstmt_insert.setString(++cnt, location_type);
					pstmt_insert.setString(++cnt, location_code);
					pstmt_insert.setString(++cnt, "");  // room_type
					pstmt_insert.setString(++cnt, room_num);  // room no
					pstmt_insert.setString(++cnt, bed_num);  //10 bed no
					pstmt_insert.setString(++cnt, ""); // bed class
					pstmt_insert.setString(++cnt, "");  // bed type
					pstmt_insert.setString(++cnt, "");  // speciality code
					pstmt_insert.setString(++cnt, pract_id); // attend practioner
					pstmt_insert.setString(++cnt, pract_id); // pres practitioner
					pstmt_insert.setString(++cnt, (String)fluidDetails.get("DRUG_CODE"));
					pstmt_insert.setString(++cnt, (String)fluidDetails.get("GENERIC_ID"));
					pstmt_insert.setString(++cnt, start_date);
					pstmt_insert.setString(++cnt, end_date);
					pstmt_insert.setString(++cnt, "N");//20
					pstmt_insert.setString(++cnt, "N");

					fld_tot_strength	= 0.0f;
					fld_unit_strength	= 0.0f;
					fld_strength_uom	= "";
					flow_rate = 0.0f;
					if (fluidDetails.get("DOSAGE_TYPE").toString().equals("S")) {
						if(!((String)orderDetails.get("MFR_YN")).equals("Y")){
							flow_rate		= Float.parseFloat(orderDetails.get("SCH_INFUSION_RATE").toString());
							fld_unit_strength	= Float.parseFloat(fluidDetails.get("STRENGTH_VALUE").toString());
							fld_tot_strength	= flow_rate*fld_unit_strength;
						}
						fld_strength_uom	= (String)fluidDetails.get("STRENGTH_UOM");
					}

					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(++cnt, (String)orderDetails.get("FLUID_UNIT_QTY"));
					}
					else{

						pstmt_insert.setString(++cnt, fld_tot_strength+"");
					}
					
					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(++cnt, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
					}
					else{
						pstmt_insert.setString(++cnt, fld_strength_uom);
					}

					pstmt_insert.setString(++cnt, (String)orderDetails.get("FLUID_UNIT_QTY"));
					pstmt_insert.setString(++cnt, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
					if(iv_pb.equals("Y")){
						HashMap drugDetails1=new HashMap();
						drugDetails1 = (HashMap)drugList.get(0);
					
						if (scheduleFreq.size()>0) {
							if (scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
								frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
						}
					}
						statement = connection.createStatement();
						resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+login_facility_id+"','"+(String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")+"') UOM_DISPLAY from dual");

						if(resultSet!=null && resultSet.next()){
							uomDisplay = resultSet.getString("UOM_DISPLAY");
						}
						else{
							uomDisplay = (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
						}
						closeResultSet( resultSet );
						closeStatement(statement);
						if (frequencyValues.size()>0) {
							// the below if part to get split_dose_preview for ivpb was done for multi freq crf
							if(!iv_pb.equals("Y")){
								for (int n=0; n<frequencyValues.size(); n++) {
									HashMap data		= (HashMap)frequencyValues.get(n);
									split_dose_preview	= split_dose_preview + (String)data.get("admin_time");
									split_dose_preview	= split_dose_preview +  " = ";
									split_dose_preview	= split_dose_preview + (String)data.get("admin_qty");
									split_dose_preview	= split_dose_preview + " ";
									//split_dose_preview	= split_dose_preview + (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
									split_dose_preview	= split_dose_preview + uomDisplay;
									split_dose_preview	= split_dose_preview + " | ";
								}
							}
							else{
								freq_char_list	= (HashMap)frequencyValues.get(0);
								day_list		= (ArrayList)frequencyValues.get(1);
								day_names		= (ArrayList)frequencyValues.get(2);
								time_list		= (ArrayList)frequencyValues.get(3);
								dose_list		= (ArrayList)frequencyValues.get(4);

								for(int frStr = 0;frStr<day_list.size();frStr++){
									if(!freq_char_list.get("durationType").equals("D")){
										split_dose_preview = split_dose_preview + "Day "+day_list.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
										split_dose_preview = split_dose_preview + day_names.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
									}
									split_dose_preview = split_dose_preview + time_list.get(frStr);
									split_dose_preview = split_dose_preview + " - ";
									split_dose_preview = split_dose_preview + dose_list.get(frStr);
									//split_dose_preview = split_dose_preview + " "+(String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
									split_dose_preview = split_dose_preview + " "+uomDisplay;
									split_dose_preview = split_dose_preview + "; ";
								}
							}
						}

						if (split_dose_preview.length()>2499) {
							split_dose_preview = split_dose_preview.substring(0,2499);
						} 
						else {
							split_dose_preview = split_dose_preview;
						}

						pstmt_insert.setString(++cnt, split_dose_preview);
						pstmt_insert.setString(++cnt, freq_code);
						//for multi freq crf
						if(iv_pb.equals("Y")){
							pstmt_insert.setFloat(++cnt,Float.parseFloat((String)orderDetails.get("DURN_VALUE_ACT")));
						}
						else{
							if( ((String)orderDetails.get("IVType")).equals("IVD") ){
								pstmt_insert.setFloat(++cnt,duration);
							}
							else{
								pstmt_insert.setString(++cnt, durn_val_for_freq+"");
							}
						}
						
						content_in_pres_base_uom	=null;
						strength_per_pres_uom		=null;
						strength_per_value_pres_uom	=null;
						freq_code					=(String)orderDetails.get("FREQ_CODE");

						if( iv_pb.equals("Y")){
							dosage_type			="Q";
							qty_value1=(String)orderDetails.get("vehicle_volume");
						}
						else {
							dosage_type = "Q";
							freq_nature = "C";
							  
							if(dosage_type.equals("A")) 
								dosage_type="Q";
							qty_value1=(String)orderDetails.get("vehicle_volume");
						}

						durn_value					=(String)orderDetails.get("DURN_VALUE");
						durn_value1                   =0.f;
				
						if(iv_pb.equals("Y")) {        
							/*  durn_value1                   = Math.ceil(Double.parseDouble(durn_value)/24);
								 durn_value			        =String.valueOf(durn_value1);*/
						 }
						 else{
							  durn_value                   = String.valueOf(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"");
						 }	  

						pstmt_select2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT2"));
						pstmt_select2.setString(1, drug_code);
						
						resultSet		= pstmt_select2.executeQuery();

						if(resultSet.next()) {
							fract_dose = resultSet.getString("fract_dose_round_up_yn");
							content_in_pres_base_uom = resultSet.getString("content_in_pres_base_uom");
							strength_per_pres_uom = resultSet.getString("strength_per_pres_uom");
							strength_per_value_pres_uom = resultSet.getString("strength_per_value_pres_uom");
						}
						closeResultSet( resultSet );				
						closeStatement(pstmt_select2); 

						pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));
						pstmt_select3.setString(1, freq_code);
						resultSet		= pstmt_select3.executeQuery();
						if(resultSet.next()) {
							interval_value = resultSet.getString("interval_value");
							repeat_value   = resultSet.getString("repeat_value");
						}
						closeResultSet( resultSet );					
						closeStatement(pstmt_select3);
					
						if(interval_value == null) 
							interval_value="1";
						if(repeat_value == null || freq_nature.equals("C")) 
							repeat_value="1";

						 if(dosage_type!=null && dosage_type.equals("Q")){
							
							pstmt_select				= 
							connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
							equl_value	=	"1";
							
							pstmt_select.setString(1,pres_base_uom);
							pstmt_select.setString(2,qty_unit);
							pstmt_select.setString(3,pres_base_uom);
							pstmt_select.setString(4,qty_unit);
							resultSet	= pstmt_select.executeQuery();

							if ( resultSet != null && resultSet.next() ) {
								equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
							}
						   closeResultSet( resultSet );
						   closeStatement(pstmt_select);
						   float ord_qty=0.0f;	

						   if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
									ord_qty		=	(Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));
									if(ord_qty==0)
										ord_qty	=	1;
							}
							//|| freq_nature.equals("I") added on aug 2010 - for intervel freq in ivpb 
							if(freq_nature.equals("F") || freq_nature.equals("I")) {
								if(Float.parseFloat(interval_value) > Float.parseFloat(durn_value)){
									ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Float.parseFloat(durn_value))+"");
								}
								else{
								   ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+"");
								}
							}
			         		//in_pres_qty_value=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty)))); for scf-14703

							in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));

						 }
						 else if(dosage_type!=null && dosage_type.equals("S")){
							float ord_qty	=0.0f;
							if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	


								if(!fract_dose.equals("Y")) {	
									ord_qty		=((Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value))/(Float.parseFloat(strength_per_pres_uom)));
									ord_qty		=new Double(Math.ceil(ord_qty)).floatValue();

								}
								else {
									 double unit_qty	=   Math.ceil(Double.parseDouble(qty_value1)/Double.parseDouble(strength_per_pres_uom)) * (Double.parseDouble(strength_per_value_pres_uom));			
									 ord_qty			=  (new Double(unit_qty).floatValue() * Float.parseFloat(durn_value) * Integer.parseInt(repeat_value) );
								}
								if(freq_nature.equals("F")) {
									ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+"");
								}
							}

							//in_pres_qty_value=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));for scf-14703
							in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));
						}

						//code added....for IVWithAdditives....on 12/5/2004...
						if( ((String)orderDetails.get("IVType")).equals("IVD") ){
									System.out.println("=====3333333===in_pres_qty_value===="+in_pres_qty_value);

							pstmt_insert.setString(++cnt, in_pres_qty_value);

						}
						else{
							pstmt_insert.setString(++cnt, fluid_ord_qty);
						}

						diag_text = "";
						if(diag_Text.size()>0) {
							diag_text = (String)diag_Text.get(3)+"~"+(String)diag_Text.get(7)+"~"+(String)diag_Text.get(11);
						}

						pstmt_insert.setString(++cnt, diag_text);
						pstmt_insert.setString(++cnt, ""); // drug remarks
						pstmt_insert.setString(++cnt, (String)orderDetails.get("IV_PRESC"));
						if(((String)orderDetails.get("MFR_YN")).equals("Y")){
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
						}
						else{
							pstmt_insert.setString(++cnt, (String)orderDetails.get("INFUSE_OVER"));
							pstmt_insert.setString(++cnt, (String)orderDetails.get("INFUSE_OVER_UNIT"));
							pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_RATE"));
							pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
						//	if( ((String)orderDetails.get("IVType")).equals("IVD") ){
								pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
						/*	}
							else{
								pstmt_insert.setString(++cnt, "M");  // infusion per unit
							} commented during infusion crf 629*/ 
						}
						pstmt_insert.setString(++cnt, "N"); // amend_yn
						pstmt_insert.setString(++cnt, ""); // amend by id
						pstmt_insert.setString(++cnt, null); // amend_date
						pstmt_insert.setString(++cnt, "N");  // cancel yn
						pstmt_insert.setString(++cnt, "");  // cancel by id
						pstmt_insert.setString(++cnt, null); // cancel date
						pstmt_insert.setString(++cnt, "P"); //TRN_TYPE_IND 
						pstmt_insert.setString(++cnt, login_facility_id);
						pstmt_insert.setString(++cnt, order_number); // orig order id
						pstmt_insert.setString(++cnt, "1");  // line no
						pstmt_insert.setString(++cnt, "");  // tot issued qty
						pstmt_insert.setString(++cnt, "N"); //BROUGHT_BY_PATIENT_YN
						pstmt_insert.setString(++cnt, null); //ON_HOLD_DATE_TIME
						pstmt_insert.setString(++cnt, ""); //ON_HOLD_BY_ID
						pstmt_insert.setString(++cnt, ""); //ON_HOLD_REASON_CODE 
						pstmt_insert.setString(++cnt, null); //DISCONT_DATE_TIME
						pstmt_insert.setString(++cnt, ""); //DISCONT_BY_ID 
						pstmt_insert.setString(++cnt, ""); //DISCONT_REASON_CODE
						pstmt_insert.setString(++cnt, "N"); //STOP_YN
						pstmt_insert.setString(++cnt, null); //STOP_DATE_TIME
						pstmt_insert.setString(++cnt, ""); //STOP_PRACTIONER_ID
						pstmt_insert.setString(++cnt, ""); //STOP_REMARKS
						pstmt_insert.setString(++cnt, login_by_id);
						pstmt_insert.setString(++cnt, login_at_ws_no);
						pstmt_insert.setString(++cnt, login_facility_id);
						pstmt_insert.setString(++cnt, login_by_id);
						pstmt_insert.setString(++cnt, login_at_ws_no);
						pstmt_insert.setString(++cnt, login_facility_id);
						pstmt_insert.setString(++cnt, (String)fluidDetails.get("ROUTE_CODE"));
						if(flag.equals("Y")){
							if(drugDtls.size() != 0){
								pstmt_insert.setString(++cnt, (String)drugDtls.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON
								pstmt_insert.setString(++cnt, (String)drugDtls.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
							}
						}
						else{
							pstmt_insert.setString(++cnt, (String)fluidDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON
							pstmt_insert.setString(++cnt, (String)fluidDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
						}
						pstmt_insert.setString(++cnt, (String)orderDetails.get("IV_INGREDIANTS"));
						/* for multi freq crf.*/
						if(iv_pb.equals("Y")){
							 pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_UNIT"));
						}
						else{

							if (freq_nature.equals("F") || freq_nature.equals("C")) {
								 pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_UNIT"));
							} 
							else if (freq_nature.equals("I")) {
								pstmt_insert.setString(++cnt, "H");
							} 
							else {
								pstmt_insert.setString(++cnt, (String)orderDetails.get("DURN_UNIT"));
							}
						}
						pstmt_insert.setString(++cnt, ""); //DISPENSED_DRUGS
						pstmt_insert.setString(++cnt, ""); //ALTERNATE_GENERIC_ID
						pstmt_insert.setString(++cnt, ""); //DISP_REMARKS 
						if(flag.equals("Y")){
							if(drugDtls.size() != 0){
								pstmt_insert.setString(++cnt, (String)drugDtls.get("CURRENTRX_REMARKS"));//CURRENTRX_REMARKS 
							}
							else
								pstmt_insert.setString(++cnt,""); //CURRENTRX_REMARKS 
						} 
						else {
							pstmt_insert.setString(++cnt, (String)fluidDetails.get("CURRENTRX_REMARKS"));//CURRENTRX_REMARKS 
						}
						pstmt_insert.setString(++cnt, "N"); //REFILL_YN 
						pstmt_insert.setString(++cnt, (String)fluidDetails.get("FORM_CODE"));

						if(diag_Text.size()>0) {
							pstmt_insert.setString(++cnt, (String)diag_Text.get(0));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(1));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(2));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(4));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(5));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(6));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(8));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(9));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(10));
						} 
						else {
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
						}
						
						if( iv_pb.equals("Y")) {
							pstmt_insert.setString(++cnt,"Q");
						} 
						else {
							pstmt_insert.setString(++cnt, (String)fluidDetails.get("DOSAGE_TYPE"));
						}

						height		= (String)orderDetails.get("HEIGHT");
						height_unit  = (String)orderDetails.get("HEIGHT_UNIT");
						weight		= (String)orderDetails.get("WEIGHT");
						weight_unit  = (String)orderDetails.get("WEIGHT_UNIT");
						if(height!=null && height.equals("")){
							height_unit = "";
						}
						if(weight!=null && weight.equals("")){
							weight_unit = "";
						}
						pstmt_insert.setString(++cnt, height);
						pstmt_insert.setString(++cnt, height_unit);
						pstmt_insert.setString(++cnt, weight);
						pstmt_insert.setString(++cnt, weight_unit);
						pstmt_insert.setString(++cnt, (String)orderDetails.get("BSA"));
						pstmt_insert.setString(++cnt,allergic_yn);
						pstmt_insert.setString(++cnt,(String)orderDetails.get("BMI"));
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "");
						
						pstmt_insert.setString(++cnt, (String)orderDetails.get("ABUSE_EXISTS"));//added for aakh-crf-0140
						pstmt_insert.setString(++cnt, (String)orderDetails.get("abuse_override_remarks"));//added for aakh-crf-0140
						pstmt_insert.executeUpdate();
						closeStatement(pstmt_insert);
					}
				// PH_PATIENT_DRUG_PROFILE INGREDIENTS
				String perform_external_database_checks = "N";
				HashMap drugDetails = null;
				int index = 2;
				DecimalFormat dfTest = new DecimalFormat("0.##");

				if(!flag.equals("N")) // if ready to use drug then order_line num wil be 1
					index = 1;
			
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT4"));
				pstmt_select 	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
				pstmt_select2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT2"));
				pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));

				for(int j=1;j<=drugList.size();j++) {
					System.out.println("3184 SQL_PH_PRESCRIPTION_INSERT4");
					cnt = 1;
					drugDetails = (HashMap)drugList.get(j-1);
					if(drugDetails.size() != 0 ){	
						perform_external_database_checks = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
						pstmt_insert.setString(cnt, patient_id);					// PATIENT_ID
						pstmt_insert.setString(++cnt, (++srl_NO) + "");				// SRL_NO
						pstmt_insert.setString(++cnt, login_facility_id);			
						pstmt_insert.setString(++cnt, encounter_id);
						pstmt_insert.setString(++cnt, patient_class);
						pstmt_insert.setString(++cnt, location_type);
						pstmt_insert.setString(++cnt, location_code);
						pstmt_insert.setString(++cnt, "");   // room_type
						pstmt_insert.setString(++cnt, room_num);  // room no
						pstmt_insert.setString(++cnt, bed_num);  //10 bed no
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, pract_id);
						pstmt_insert.setString(++cnt, pract_id);
						pstmt_insert.setString(++cnt, (String)drugDetails.get("DRUG_CODE"));
						pstmt_insert.setString(++cnt, (String)drugDetails.get("GENERIC_ID"));
						pstmt_insert.setString(++cnt, start_date);
						pstmt_insert.setString(++cnt, end_date);
						pstmt_insert.setString(++cnt, "N");
						pstmt_insert.setString(++cnt, "N");
					
						fld_tot_strength	= 0.0f;
						fld_unit_strength	= 0.0f;
						fld_strength_uom	= "";

						if (drugDetails.get("DOSAGE_TYPE").toString().equals("S")) {
							if(!((String)orderDetails.get("MFR_YN")).equals("Y")){
								flow_rate		= Float.parseFloat(orderDetails.get("SCH_INFUSION_RATE").toString());
								fld_unit_strength	= Float.parseFloat(drugDetails.get("STRENGTH_VALUE").toString());
								fld_tot_strength	= flow_rate*fld_unit_strength;
							}
							fld_strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
						}

						if( ((String)orderDetails.get("IVType")).equals("IVD") ){
							pstmt_insert.setString(++cnt, fld_unit_strength+"");
						}
						else{
							pstmt_insert.setString(++cnt, fld_tot_strength+"");
						}
						pstmt_insert.setString(++cnt, fld_strength_uom);

						float ing_unit_qty		= 0.0f;
						float ing_order_qty		= 0.0f;
						String ing_order_uom	= "";

						strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
						strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
						content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");

						stock_uom			= (String)drugDetails.get("STOCK_UOM");
						qty_unit			= (String)drugDetails.get("QTY_DESC_CODE");

						if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
							content_in_pres_base_uom =	"1";
						if( iv_pb.equals("Y")) {
						  ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));

						}
						else { 
						  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));


						}
						ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

						if (((String)drugDetails.get("DOSAGE_TYPE")).equals("S")) {
							if( iv_pb.equals("Y")){
							 ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));

							}
							else {
							   ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
							}
							float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
							ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");

							if (freq_nature.equals("I")) {
								//ing_order_qty = in_tot_qty*duration*(24/int_value);
								ing_order_qty = in_tot_qty*duration;

							}
							else if (freq_nature.equals("F") || freq_nature.equals("C")) {
								ing_order_qty = in_tot_qty*rep_interval*duration;
							}
							else if (freq_nature.equals("O")) {
								ing_order_qty = in_tot_qty;
							}

							if( ((String)orderDetails.get("IVType")).equals("IVD") ){
								ing_order_qty	=   new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
							}
							else{
								ing_order_qty	=   new Double(Math.ceil((ing_order_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
							}
						}
						else  {							
							 equl_value	= "1";
		
							pstmt_select.setString(1, ing_order_uom);
							pstmt_select.setString(2, qty_unit);
							pstmt_select.setString(3, ing_order_uom);
							pstmt_select.setString(4, qty_unit);
							resultSet	= pstmt_select.executeQuery();

							if (resultSet.next()) {
								equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
							}

							closeResultSet( resultSet );
							float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
							if (freq_nature.equals("I")) {
								//	ing_order_qty = in_tot_qty*duration*(24/int_value);
								ing_order_qty = in_tot_qty*duration;
							} 
							else if (freq_nature.equals("F") || freq_nature.equals("C")) {
								ing_order_qty = in_tot_qty*rep_interval*duration;
							} 
							else if (freq_nature.equals("O")) {
								ing_order_qty = in_tot_qty;
							}
							//if IVD
							if( ((String)orderDetails.get("IVType")).equals("IVD") ){
								ing_order_qty	=   new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
							}
							else{
								ing_order_qty	=   new Double(Math.ceil((ing_order_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
							}
							/*if(!iv_pb.equals("Y")) {
								ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
							}else{
								ing_order_uom		= (String)drugDetails.get("QTY_UOM");
							}*/
							if(iv_pb.equals("Y"))
								ing_order_uom		= (String)drugDetails.get("QTY_UOM");
						}

						pstmt_insert.setString(++cnt, ing_unit_qty+"");
						pstmt_insert.setString(++cnt, ing_order_uom);
						
						frequencyValues	= new ArrayList();
						statement = connection.createStatement();
						if(!flag.equals("N")){ // if ready to use iv then use the drug's dosage uom 
							resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+login_facility_id+"','"+ing_order_uom+"') UOM_DISPLAY from dual");
						}
						else{
							resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+login_facility_id+"','"+(String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")+"') UOM_DISPLAY from dual");
						}
						
						uomDisplay = "";
						if(resultSet!=null && resultSet.next()){
							uomDisplay = resultSet.getString("UOM_DISPLAY");
						}else{
							if(!flag.equals("N")) // if ready to use iv then use the drug's dosage uom 
								uomDisplay = ing_order_uom;
							else
								uomDisplay = (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
						}
						closeResultSet( resultSet );
						closeStatement(statement);
						
						split_dose_preview	= "";
						if (scheduleFreq.size()>0) {
							if (scheduleFreq.containsKey((String)drugDetails.get("DRUG_CODE")))
								frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails.get("DRUG_CODE"));
						}
						if (frequencyValues.size()>0) {
							// the below if part to get split_dose_preview for ivpb was done for multi freq crf
							if(!iv_pb.equals("Y")){
								for (int n=0; n<frequencyValues.size(); n++) {
									HashMap data		= (HashMap)frequencyValues.get(n);
									split_dose_preview	= split_dose_preview + (String)data.get("admin_time");
									split_dose_preview	= split_dose_preview + " = ";
									split_dose_preview	= split_dose_preview + (String)data.get("admin_qty");
									split_dose_preview	= split_dose_preview + " ";
									//	split_dose_preview	= split_dose_preview + (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
									split_dose_preview	= split_dose_preview + uomDisplay;
									split_dose_preview	= split_dose_preview + " | ";
								}
							}
							else{
								freq_char_list	= (HashMap)frequencyValues.get(0);
								day_list		= (ArrayList)frequencyValues.get(1);
								day_names		= (ArrayList)frequencyValues.get(2);
								time_list		= (ArrayList)frequencyValues.get(3);
								dose_list		= (ArrayList)frequencyValues.get(4);
								for(int frStr = 0;frStr<day_list.size();frStr++){
									if(!freq_char_list.get("durationType").equals("D")){
										split_dose_preview = split_dose_preview + "Day "+day_list.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
										split_dose_preview = split_dose_preview + day_names.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
									}
									split_dose_preview = split_dose_preview + time_list.get(frStr);
									split_dose_preview = split_dose_preview + " - ";
									split_dose_preview = split_dose_preview + dose_list.get(frStr);
									//	split_dose_preview = split_dose_preview + " "+(String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
									split_dose_preview = split_dose_preview + " "+uomDisplay;
									split_dose_preview = split_dose_preview + "; ";
								}
							}
						}

						if (split_dose_preview.length()>2499) {
							split_dose_preview = split_dose_preview.substring(0, 2499);
						} 
						else {
							split_dose_preview = split_dose_preview;
						}

						pstmt_insert.setString(++cnt, split_dose_preview);
						pstmt_insert.setString(++cnt, freq_code);

						if(iv_pb.equals("Y")){
							pstmt_insert.setFloat(++cnt,Float.parseFloat((String)orderDetails.get("DURN_VALUE_ACT")));
						}else{
							if( ((String)orderDetails.get("IVType")).equals("IVD") ){
								pstmt_insert.setString(++cnt,((String)orderDetails.get("DURN_VALUE")));
							} 
							else {
								pstmt_insert.setString(++cnt, durn_val_for_freq+""); //infusion
							}
						}
						pres_base_uom				=(String)drugDetails.get("PRES_BASE_UOM");
						qty_unit					=(String)drugDetails.get("PRES_QTY_UOM");
						equl_value					=null;

						if(iv_pb.equals("Y")) {   
							qty_value1					=(String)orderDetails.get("QTY_VALUE");	
						} 
						else {
							qty_value1					=(String)drugDetails.get("QTY_VALUE");
							freq_nature="C";
						}

						fract_dose            		=null;
						content_in_pres_base_uom	=null;
						strength_per_pres_uom		=null;
						strength_per_value_pres_uom	=null;
						in_pres_qty_value			=null;
						freq_code					=(String)orderDetails.get("FREQ_CODE");
						interval_value			    =null;
						repeat_value				=null;
						drug_code					=(String)drugDetails.get("DRUG_CODE");
						dosage_type					=(String)drugDetails.get("DOSAGE_TYPE");
						if(dosage_type.equals("A")) dosage_type="Q";
						durn_value			        =(String)orderDetails.get("DURN_VALUE");
						durn_value1                 =0.f; 

						if(iv_pb.equals("Y")){        
							/*  durn_value1                   = Math.ceil(Double.parseDouble(durn_value)/24);
							  durn_value			        =String.valueOf(durn_value1);*/
						}
						else{
							  durn_value                   = String.valueOf(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"");
						}


						pstmt_select2.setString(1, drug_code);
						resultSet		= pstmt_select2.executeQuery();

						if(resultSet.next()) {
							fract_dose					= resultSet.getString("fract_dose_round_up_yn");
							content_in_pres_base_uom	= resultSet.getString("content_in_pres_base_uom");
							strength_per_pres_uom		= resultSet.getString("strength_per_pres_uom");
							strength_per_value_pres_uom = resultSet.getString("strength_per_value_pres_uom");
						}
						closeResultSet( resultSet );
						pstmt_select3.setString(1, freq_code);
						resultSet		= pstmt_select3.executeQuery();
						if(resultSet.next()) {
							interval_value = resultSet.getString("interval_value");
							repeat_value   = resultSet.getString("repeat_value");
						}
						closeResultSet( resultSet );
						if(interval_value == null) 
							interval_value="1";
						if(repeat_value == null || freq_nature.equals("C"))
							repeat_value="1";

						if(dosage_type!=null && dosage_type.equals("Q")){
							equl_value	=	"1";
							pstmt_select.setString(1,pres_base_uom);
							pstmt_select.setString(2,qty_unit);
							pstmt_select.setString(3,pres_base_uom);
							pstmt_select.setString(4,qty_unit);
							resultSet	= pstmt_select.executeQuery();
							if ( resultSet != null && resultSet.next() ) {
								equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
							}
							closeResultSet( resultSet );
							float ord_qty=0.0f;			   
							if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
							
								ord_qty		=	(Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));

								if(ord_qty==0)
									ord_qty	=	1;
							}

							if(freq_nature.equals("F") || freq_nature.equals("I")) {
								//   ord_qty	=	Float.parseFloat((ord_qty/ Integer.parseInt(interval_value))+"");
							   if(Float.parseFloat(interval_value) > Float.parseFloat(durn_value)){
									ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Float.parseFloat(durn_value))+"");
								}
								else{
									ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+"");
								}
							}
							//in_pres_qty_value=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));for scf 14703
							in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));
						 }
						 else if(dosage_type!=null && dosage_type.equals("S")){
							float ord_qty	=0.0f;

							if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	
								ord_qty		=((Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value)*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
								ord_qty		=new Double(Math.ceil(ord_qty)).floatValue();
								if(freq_nature.equals("F") || freq_nature.equals("I")) {
									//ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+""); and math.ceil removed for incident 25538
									if(Float.parseFloat(interval_value) > Float.parseFloat(durn_value)){
										ord_qty	=	Float.parseFloat(ord_qty/ Float.parseFloat(durn_value)+"");
									}else{
										ord_qty	=	Float.parseFloat(ord_qty/ Integer.parseInt(interval_value)+"");
									}
								}
							}
							//in_pres_qty_value=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty)))); for scf 14703
							in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));
							
							in_pres_qty_value = dfTest.format(Float.parseFloat(in_pres_qty_value));
						}

						if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){

							pstmt_insert.setString(++cnt, in_pres_qty_value+"");
						} 
						else{
							pstmt_insert.setString(++cnt, in_pres_qty_value+"");
						}
						diag_text = "";
						if(diag_Text.size()>0) {
							diag_text = (String)diag_Text.get(3)+"~"+(String)diag_Text.get(7)+"~"+(String)diag_Text.get(11);
						}

						pstmt_insert.setString(++cnt, diag_text);
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, (String)orderDetails.get("IV_PRESC"));
						pstmt_insert.setString(++cnt, (String)orderDetails.get("INFUSE_OVER"));
						pstmt_insert.setString(++cnt, (String)orderDetails.get("INFUSE_OVER_UNIT"));
						pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_RATE"));
						pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
						//	if( ((String)orderDetails.get("IVType")).equals("IVD") ){
							pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
						/*	}
						else{
							pstmt_insert.setString(++cnt, "M");
						} commented during crf 629 - infusion over*/
						pstmt_insert.setString(++cnt, "N");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, null);
						pstmt_insert.setString(++cnt, "N");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, null);
						pstmt_insert.setString(++cnt, "P");
						pstmt_insert.setString(++cnt, login_facility_id);
						pstmt_insert.setString(++cnt, order_number);
						pstmt_insert.setString(++cnt, (index++)+"");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "N");
						pstmt_insert.setString(++cnt, null);
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, null);
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "N");
						pstmt_insert.setString(++cnt, null);
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, login_by_id);
						pstmt_insert.setString(++cnt, login_at_ws_no);
						pstmt_insert.setString(++cnt, login_facility_id);
						pstmt_insert.setString(++cnt, login_by_id);
						pstmt_insert.setString(++cnt, login_at_ws_no);
						pstmt_insert.setString(++cnt, login_facility_id);
						pstmt_insert.setString(++cnt, (String)drugDetails.get("ROUTE_CODE"));

						if(drugDetails.get("ALLERGY_REMARKS")==null || ((String)drugDetails.get("ALLERGY_REMARKS")).equals(""))
							pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")); //ALLERGY_OVERRIDE_REASON :
						else
							pstmt_insert.setString(++cnt, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :



						if(drugDetails.get("DOSE_REMARKS")==null || ((String)drugDetails.get("DOSE_REMARKS")).equals(""))
							pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); 
						else
							pstmt_insert.setString(++cnt, (String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
						/*
						if(perform_external_database_checks.equals("N")){					
							pstmt_insert.setString(++cnt, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON :
						}
						else{
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")); //EXTERNAL_ALERGY_OVERRIDE_REASON
							}
							else{
							   pstmt_insert.setString(++cnt,"");
							}
						}
						
						if(perform_external_database_checks.equals("N")){
							pstmt_insert.setString(++cnt, (String)drugDetails.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
						}
						else{
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
								pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); //EXTERNAL_DOSAGE_OVERRIDE_REASON
							}
							else{
								pstmt_insert.setString(++cnt,"");
							}
						}
						*/
						pstmt_insert.setString(++cnt, (String)orderDetails.get("IV_INGREDIANTS"));
						if(iv_pb.equals("Y")){
							pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_UNIT"));
						}
						else{
							if (freq_nature.equals("F") || freq_nature.equals("C")) {
							/*for multi freq
								if(iv_pb.equals("Y")){
									pstmt_insert.setString(++cnt, "D");
								} 
								else {*/
									pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_UNIT"));
								//}
							} 
							else if (freq_nature.equals("I")) {
								pstmt_insert.setString(++cnt, "H");
							} 
							else {
								pstmt_insert.setString(++cnt, (String)orderDetails.get("DURN_UNIT"));
							}
						}
						pstmt_insert.setString(++cnt, ""); //DISPENSED_DRUGS
						pstmt_insert.setString(++cnt, "");
						pstmt_insert.setString(++cnt, "");
						
						if(drugDetails.get("CURRENTRX_REMARKS") == null || ((String)drugDetails.get("CURRENTRX_REMARKS")).equals("")){
							pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); // currentrx remarks
						}else{
							pstmt_insert.setString(++cnt, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
						}
						/*
						if(perform_external_database_checks.equals("N")){
							pstmt_insert.setString(++cnt, (String)drugDetails.get("CURRENTRX_REMARKS")); // currentrx remarks
						}
						else{
							if(((String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
							pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")); //EXTERNAL_DUPLICATE_OVERRIDE_REASON
							}
							else{
								pstmt_insert.setString(++cnt,"");
							}
						}
						*/
						pstmt_insert.setString(++cnt, "N"); // refill yn
						pstmt_insert.setString(++cnt, (String)drugDetails.get("FORM_CODE"));

						if(diag_Text.size()>0) {
							pstmt_insert.setString(++cnt, (String)diag_Text.get(0));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(1));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(2));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(4));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(5));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(6));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(8));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(9));
							pstmt_insert.setString(++cnt, (String)diag_Text.get(10));
						} 
						else {
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
							pstmt_insert.setString(++cnt, "");
						}

						pstmt_insert.setString(++cnt, (String)drugDetails.get("DOSAGE_TYPE"));
						height		 = (String)orderDetails.get("HEIGHT");      
						height_unit  = (String)orderDetails.get("HEIGHT_UNIT"); 
						weight		 = (String)orderDetails.get("WEIGHT");      
						weight_unit  = (String)orderDetails.get("WEIGHT_UNIT"); 

						if(height!=null && height.equals("")){
							height_unit = "";
						}
						if(weight!=null && weight.equals("")){
							weight_unit = "";
						}

						pstmt_insert.setString(++cnt, height);
						pstmt_insert.setString(++cnt, height_unit);
						pstmt_insert.setString(++cnt, weight);
						pstmt_insert.setString(++cnt, weight_unit);
						pstmt_insert.setString(++cnt, (String)orderDetails.get("BSA"));
						pstmt_insert.setString(++cnt,allergic_yn);
						pstmt_insert.setString(++cnt,(String)orderDetails.get("BMI"));

						pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")); //EXTERNAL_INTERACTION_OVERRIDE_REASON
						pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON")); //EXTERNAL_CONTRA_OVERRIDE_REASON
						pstmt_insert.setString(++cnt, (String)drugDetails.get("DRUG_DB_PRODUCT_ID")); //DRUG_DB_PRODUCT_ID
						pstmt_insert.setString(++cnt, (String)orderDetails.get("ABUSE_EXISTS"));//added for aakh-crf-0140
						pstmt_insert.setString(++cnt, (String)orderDetails.get("abuse_override_remarks"));//added for aakh-crf-0140
						
						//pstmt_insert.executeUpdate();
						pstmt_insert.addBatch();
					}
				}
				closeStatement(pstmt_select); 
				closeStatement(pstmt_select2); 
				closeStatement(pstmt_select3);
				int[] patient_drug_profile_result = pstmt_insert.executeBatch();
				
				for (int i=0;i<patient_drug_profile_result.length;i++) {
					if(patient_drug_profile_result[i] < 0  && patient_drug_profile_result[i] != -2 ) {
						System.err.println("IV ADDITIVES/INTEMITENT --> ERROR IN INSERTING INGREDIANT INTO PH_PATIENT_DRUG_PROFILE patient_drug_profile_result["+i+"]= "+patient_drug_profile_result[i]);
						System.err.println("tabData=== "+tabData);
						result = 0;
						break;
					}
					else {
						result = 1;
					}
				}
				closeStatement(pstmt_insert);
			}
			// OR_ORDER_COMMENT

			if (result>0) {
				String action_seq_num		= "";
				pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_select.setString(1, order_number);
				resultSet		= pstmt_select.executeQuery();
				if(resultSet.next()) {
					action_seq_num = resultSet.getString(1);
				}
				closeResultSet( resultSet );
				closeStatement(pstmt_select); 
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_insert.setString(1, order_number);
				pstmt_insert.setString(2, action_seq_num);
				pstmt_insert.setString(3, login_by_id);
				pstmt_insert.setString(4, login_at_ws_no);
				pstmt_insert.setString(5, login_facility_id);
				pstmt_insert.setString(6, login_by_id);
				pstmt_insert.setString(7, login_at_ws_no);
				pstmt_insert.setString(8, login_facility_id);
				result = pstmt_insert.executeUpdate();
				if(result>0){
				
					pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
					pstmt_clob.setString(1,order_number);
					pstmt_clob.setString(2,action_seq_num);
					ResultSet rset_clob =pstmt_clob.executeQuery();
					if(rset_clob!=null){
						while(rset_clob.next()){
							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(order_comment,0,order_comment.length());
							bw.flush();
							bw.close();
						}
					}					
					closeResultSet( rset_clob );
					closeStatement(pstmt_clob);
				}
				closeStatement(pstmt_insert);
			}

			String height				= (String)orderDetails.get("HEIGHT");
			String height_unit			= (String)orderDetails.get("HEIGHT_UNIT");
			String weight				= (String)orderDetails.get("WEIGHT");
			String weight_unit			= (String)orderDetails.get("WEIGHT_UNIT");
			String bsa					= (String)orderDetails.get("BSA");
			String bsa_unit				= (String)orderDetails.get("BSA_UNIT");

			pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT6"));
			pstmt_insert.clearBatch();

			if ((!(weight.equals(""))) && (!(height.equals("")))) {
				String fld_value	= "";
				String fld_legend	= "";
				String fld_unit		= "";
				String seq_no		= "";
				for(int j=0; j<3; j++) {
					if (j==0) {
						fld_value	= height;
						fld_legend	= "height";
						fld_unit	= height_unit;
						seq_no		= "1";
					}
					if (j==1) {
						fld_value	= weight;
						fld_legend	= "weight";
						fld_unit	= weight_unit;
						seq_no		= "2";
					}
					if (j==2) {
						fld_value	= bsa;
						fld_legend	= "bsa";
						fld_unit	= bsa_unit;
						seq_no		= "3";
					}

					pstmt_insert.setString(1, order_number);
					pstmt_insert.setString(2, seq_no);
					pstmt_insert.setString(3, fld_unit);
					pstmt_insert.setString(4, "N");
					pstmt_insert.setString(5, fld_legend);
					pstmt_insert.setString(6, fld_value);
					pstmt_insert.setString(7, "O");
					pstmt_insert.setString(8, login_by_id);
					pstmt_insert.setString(9, login_at_ws_no);
					pstmt_insert.setString(10, login_facility_id);
					pstmt_insert.setString(11, login_by_id);
					pstmt_insert.setString(12, login_at_ws_no);
					pstmt_insert.setString(13, login_facility_id);
					pstmt_insert.addBatch();
				}

				int[] batch_result = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						System.err.println("IV ADDITIVES/INTEMITENT --> ERROR IN INSERTING INTO OR_ORDER_FIELD_VALUES batch_result["+i+"]= "+batch_result[i]);
						System.err.println("tabData=== "+tabData);
						result = 0;
						break;
					}
					else {
						result = 1;
					}
				}
			}
			else {
				result = 1;
			}
			closeStatement(pstmt_insert);

			if (result>0) {
				boolean enter_loop = false;
				if(drugRemarks.size()>0) {
					int order_format_count	= 0;
					//pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
					pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
					pstmt_insert.clearBatch();

					for (int i=0;i<drugRemarks.size();i++ ) {
						HashMap DrugValues = (HashMap)drugRemarks.get(i);

						String total_seq	= (String)DrugValues.get("order_format_count");
						order_format_count	= Integer.parseInt(total_seq);

						for(int k=0;k<order_format_count;k++) {
							enter_loop = true;

							pstmt_insert.setString(1, order_number);
							pstmt_insert.setString(2, "" + (i+1));
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, "" + (k+1));
							pstmt_insert.setString(5, (String)DrugValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6, (String)DrugValues.get("field_type"+k));
							pstmt_insert.setString(7, (String)DrugValues.get("label_text"+k));
							pstmt_insert.setString(8, (String)DrugValues.get("field_values"+k));
							pstmt_insert.setString(9, "");
							pstmt_insert.setString(10, "");
							pstmt_insert.setString(11, (String)DrugValues.get("accept_option"+k));
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, login_by_id);
							pstmt_insert.setString(14, login_at_ws_no);
							pstmt_insert.setString(15, login_facility_id);
							pstmt_insert.setString(16, login_by_id);
							pstmt_insert.setString(17, login_at_ws_no);
							pstmt_insert.setString(18, login_facility_id);
							pstmt_insert.addBatch();
						}
					}

					if(enter_loop) {
						int[] batch_result = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result.length;i++ ) {
							if (batch_result[i]<0  && batch_result[i] != -2) {
								System.err.println("IV ADDITIVES/INTEMITENT --> ERROR IN INSERTING DRUG REMARKS INTO OR_ORDER_LINE_FIELD_VALUES batch_result["+i+"]= "+batch_result[i]);
								System.err.println("tabData=== "+tabData);
								result=0;
								break;
							}
							else {
								result=1;
							}
						}
					}
					else {
						result=1;
					}
				}
				else {
					result=1;
				}
				closeStatement(pstmt_insert);
			}
			// OR_ORDER_LINE_FIELD_VALUES
			if (result>0) {
	
				boolean freq_values_found	= false;
	
				pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
				ArrayList frequencyValues = new ArrayList();
				HashMap drugDetails1=new HashMap();
                if(iv_pb.equals("Y")){
					
					freq_char_list	= new HashMap();
					day_list		= new ArrayList();
					time_list		= new ArrayList();
					dose_list		= new ArrayList();

                  drugDetails1 = (HashMap)drugList.get(0);
				   if (scheduleFreq.size()>0) {
					 if (scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
					   	frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
			    	}
                }
				if (frequencyValues.size()>0) {
					if(frequencyValues != null && frequencyValues.size() > 0 && iv_pb.equals("Y")) {
						freq_char_list	= (HashMap)frequencyValues.get(0);
						day_list		= (ArrayList)frequencyValues.get(1);
						time_list		= (ArrayList)frequencyValues.get(3);
						dose_list		= (ArrayList)frequencyValues.get(4);
					}
					if(iv_pb.equals("Y")){
						for(int n=0;n<day_list.size();n++) {
							freq_values_found	= true;
							int seqNo			= 200;
							seqNo				= seqNo + n;

							/*HashMap data		= (HashMap)frequencyValues.get(n);
							String admin_time	= (String)data.get("admin_time");
							String admin_qty	= (String)data.get("admin_qty");*/
//	changed for issue S 24668 String durn_desc	= (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
							String durn_desc	= (String)orderDetails.get("FLUID_UNIT_QTY_UOM");
							if(!flag.equals("N"))
								durn_desc = (String)drugDetails1.get("DRUG_QTY_UOM");
    			
							pstmt_insert.setString(1, order_number);
							pstmt_insert.setString(2, "1");
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, seqNo + "");
							pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
							pstmt_insert.setString(6, "C");
							pstmt_insert.setString(7, "D");
							/*pstmt_insert.setString(8, admin_time);
							pstmt_insert.setString(9, admin_qty);*/
							pstmt_insert.setString(8,(String)time_list.get(n));
							pstmt_insert.setString(9,(String)dose_list.get(n));
							pstmt_insert.setString(10, durn_desc);
							pstmt_insert.setString(11, "O");
							pstmt_insert.setInt(12, Integer.parseInt(day_list.get(n)+""));
							pstmt_insert.setString(13, login_by_id);
							pstmt_insert.setString(14, login_at_ws_no);
							pstmt_insert.setString(15, login_facility_id);
							pstmt_insert.setString(16, login_by_id);
							pstmt_insert.setString(17, login_at_ws_no);
							pstmt_insert.setString(18, login_facility_id);
							pstmt_insert.addBatch();
						}
					}
					else{
						for(int n=0;n<frequencyValues.size();n++) {
							freq_values_found	= true;
							int seqNo			= 200;
							seqNo				= seqNo + n;

							HashMap data		= (HashMap)frequencyValues.get(n);
							String admin_time	= (String)data.get("admin_time");
							String admin_qty	= (String)data.get("admin_qty");
							String durn_desc	= (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
	
							pstmt_insert.setString(1, order_number);
							pstmt_insert.setString(2, "1");
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, seqNo + "");
							pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
							pstmt_insert.setString(6, "C");
							pstmt_insert.setString(7, "D");
							pstmt_insert.setString(8, admin_time);
							pstmt_insert.setString(9, admin_qty);
							pstmt_insert.setString(10, durn_desc);
							pstmt_insert.setString(11, "O");
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, login_by_id);
							pstmt_insert.setString(14, login_at_ws_no);
							pstmt_insert.setString(15, login_facility_id);
							pstmt_insert.setString(16, login_by_id);
							pstmt_insert.setString(17, login_at_ws_no);
							pstmt_insert.setString(18, login_facility_id);
							pstmt_insert.addBatch();
						}
					}
				}
				else{    //for interval frequency
					/*	ArrayList headerList	=	null;
					HashMap insertRecords_2	=	null;
					String order_id			=	null;
					String line_det			=	null;
					String line_no			=	null;
					String old_order		=	null;
					for(int n=0;n<OrderID.size();n++){
						headerList	=(ArrayList) OrderDetails.get(n);
						for(int j=0;j<headerList.size();j++){
							insertRecords_2=(HashMap) headerList.get(j);
							if(insertRecords_2 != null)
							{*/
					
					String sch_date_time	=	"";
					HashMap schd_week_hr_dates	=	new HashMap();
					ArrayList schd_date_time	=	new ArrayList();
					String tmp_sch_dt = "";
					String tmp_sch_time = "";
					//String durn_desc = "";
					String sch_start_date_time = "";
					drugDetails1 = (HashMap)drugList.get(0);
					String fr_drug_code = (String)drugDetails1.get("DRUG_CODE");
					schd_week_hr_dates	=   (HashMap) tabData.get("sched_date_time_wkhr");

					if(schd_week_hr_dates!= null && schd_week_hr_dates.size() > 0){
						schd_date_time	=	(ArrayList)schd_week_hr_dates.get(fr_drug_code);
						if(schd_date_time != null && schd_date_time.size()>0 && fr_drug_code.equals(fr_drug_code) ){
							sch_start_date_time = (String)schd_date_time.get(0);
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Calendar cal = Calendar.getInstance(); 
							cal.setTime( dateFormat.parse( sch_start_date_time ) ); 
							cal.add( Calendar.DATE, 1 ); 
							sch_start_date_time = dateFormat.format(cal.getTime());  
							int seqNo = 0;
							for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
								sch_date_time = (String)schd_date_time.get(scdDt);
								if((!sch_date_time.equals("")) && (sch_date_time != null)){
									tmp_sch_dt    = sch_date_time.substring(0,10);
									tmp_sch_time = sch_date_time.substring(11,16);

									if(!tmp_sch_time.equals("")&&(tmp_sch_time!=null) && ( ((java.util.Date)dateFormat.parse(sch_date_time)).compareTo((java.util.Date)dateFormat.parse(sch_start_date_time)) < 0   )){
										freq_values_found = true;
										seqNo=200;
										seqNo= seqNo+scdDt;

										pstmt_insert.setString(1,order_number);
										pstmt_insert.setString(2,"1");
										pstmt_insert.setString(3,"S");
										pstmt_insert.setString(4,seqNo+"");
										pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
										pstmt_insert.setString(6,"C");
										pstmt_insert.setString(7,"D");
										pstmt_insert.setString(8,tmp_sch_time);
										pstmt_insert.setString(9, (String)orderDetails.get("FLUID_UNIT_QTY"));
										if(!flag.equals("N")) // if ready to use iv
											pstmt_insert.setString(10, (String)drugDetails1.get("DRUG_QTY_UOM"));
										else
											pstmt_insert.setString(10, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));

									//	pstmt_insert.setString(9,(String)insertRecords_2.get("QTY_VALUE"));
									//	pstmt_insert.setString(10,durn_desc);
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
				if (freq_values_found) {
					int[] batch_result = pstmt_insert.executeBatch();

					for (int i=0;i<batch_result.length;i++ ) {
						if (batch_result[i]<0  && batch_result[i] != -2) {
								System.err.println("IV ADDITIVES/INTEMITENT --> ERROR IN INSERTING FREQUENCY VALUES INGREDIANT INTO OR_ORDER_LINE_FIELD_VALUES batch_result["+i+"]= "+batch_result[i]);
								System.err.println("tabData=== "+tabData);
							result=0;
							break;
						}
						else {
							result=1;
						}
					}
				} 
				else {
					result=1;
				}
				closeStatement(pstmt_insert);
			}
	//PH_MEDN_ADMIN
			if (result>0) {
				ArrayList schd_date_time	=	new ArrayList();
				ArrayList tmp_sch_dt_tm =   new ArrayList();
				HashMap schd_week_hr_dates	=	new HashMap();
				schd_week_hr_dates	=   (HashMap) tabData.get("sched_date_time_wkhr");
				HashMap drugDetails1=new HashMap();

				if( ((String)orderDetails.get("IVType")).equals("IVD") ){
					if( buildMAR_yn.equals("Y") && !(iv_prep.equals("2") || iv_prep.equals("4"))){
						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));
						pstmt_insert.clearBatch();
						double fr_durn_value=0;
						if(orderDetails.get("DURN_UNIT").toString().equals("H")) {
							fr_durn_value	=	Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/24;
						} 
						else if(orderDetails.get("DURN_UNIT").toString().equals("M")) {
							fr_durn_value = Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/1440;
						}
						else {
							fr_durn_value = 1;
						}

						int dosage_seqNo		= 1;
						String verf_reqd_bef_med_admin_yn = "";
						HashMap drugDetails=null;
						String	dosage_type ="", ing_order_uom="", qty_unit="", equl_value="", stat_sch_time="";
						float   ing_unit_qty		= 0.0f;
						float	ing_order_qty		= 0.0f;

						pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
						pstmt_select.setString(1, login_facility_id);
						resultSet		= pstmt_select.executeQuery();
						if (resultSet.next()) {
							verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
						}

						closeResultSet( resultSet );
						closeStatement(pstmt_select);
		
						if(!iv_pb.equals("Y")){
						
							pstmt_insert.setString(1, login_facility_id);
							pstmt_insert.setString(2, encounter_id);
							pstmt_insert.setString(3, (String)orderDetails.get("START_DATE"));
							pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
							pstmt_insert.setString(5, dosage_seqNo + "");
							pstmt_insert.setString(6, order_number);
							pstmt_insert.setString(7, "1");
							pstmt_insert.setString(8, patient_id);
							pstmt_insert.setString(9, pract_id);
							pstmt_insert.setString(10, "Y");
							pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
							//pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
							if( ((String)orderDetails.get("IVType")).equals("IVD")  ){
								pstmt_insert.setString(12, (Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY")))+"");
							}
							pstmt_insert.setString(13, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
							pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY"));
							pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
							pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE"));
							pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE"));
							pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
							pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
							pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
							pstmt_insert.setString(21, login_by_id);
							pstmt_insert.setString(22, login_at_ws_no);
							pstmt_insert.setString(23, login_facility_id);
							pstmt_insert.setString(24, login_by_id);
							pstmt_insert.setString(25, login_at_ws_no);
							pstmt_insert.setString(26, login_facility_id);

							pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
							pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
							pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
				 
							pstmt_insert.addBatch();
							
							pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
							srlNo = 1;

							for(int j=1;j<=drugList.size();j++) {
								drugDetails = (HashMap)drugList.get(j-1);
								if(drugDetails.size() != 0 ){
									pstmt_insert.setString(1, login_facility_id);
									pstmt_insert.setString(2, encounter_id);
									pstmt_insert.setString(3, (String)orderDetails.get("START_DATE"));
									pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
									pstmt_insert.setString(5, "1");
									pstmt_insert.setString(6, order_number);
									pstmt_insert.setString(7, (++srlNo)+"");
									pstmt_insert.setString(8, patient_id);
									pstmt_insert.setString(9, pract_id);
									pstmt_insert.setString(10, "Y");
									pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
									dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
									ing_unit_qty		= 0.0f;
									ing_order_qty		= 0.0f;
									ing_order_uom		= "";
									strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
									strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
									content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
									stock_uom					=	(String)drugDetails.get("STOCK_UOM");
									qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");
									if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
										content_in_pres_base_uom =	"1";
									 if(iv_pb.equals("Y")) {
										ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
									}
									else {
										ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
									}
										ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

									if (dosage_type.equals("S")) {

										if(iv_pb.equals("Y")) {
											   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
										} 
										else {
											  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
										}
										float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
										ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
										if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
											if (freq_nature.equals("I")) {
												ing_order_qty = in_tot_qty*duration*(24/int_value);
											}
											else if (freq_nature.equals("F") || freq_nature.equals("C")) {
												ing_order_qty = in_tot_qty*rep_interval*duration;
											}
											else if (freq_nature.equals("O")) {
												ing_order_qty = in_tot_qty;
											}
										}
	// Ends (not for IVD)

										if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
											ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
										}
										else {
											ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
										}
									}	
									else  {							
										equl_value	= "1";
										pstmt_select.setString(1, ing_order_uom);
										pstmt_select.setString(2, qty_unit);
										pstmt_select.setString(3, ing_order_uom);
										pstmt_select.setString(4, qty_unit);
										resultSet	= pstmt_select.executeQuery();

										if (resultSet.next()) {
											equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
										}
										closeResultSet( resultSet );

										float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
			// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
										if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
											if (freq_nature.equals("I")) {
												ing_order_qty = in_tot_qty*duration*(24/int_value);
											} 
											else if (freq_nature.equals("F") || freq_nature.equals("C")) {
												ing_order_qty = in_tot_qty*rep_interval*duration;
											}
											else if (freq_nature.equals("O")) {
												ing_order_qty = in_tot_qty;
											}
										}
			// Ends (Not for IVD)
										if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
											ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
										} 
										else {
											ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
										}
									
										if(!iv_pb.equals("Y")) {
											//ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM"); //this change was done by abdul.because it was sending 'strength uom' always. now it will send what ever selected by the user.(for Quantity based)
											ing_order_uom	= (String)drugDetails.get("QTY_UOM");
										}
									}

									pstmt_insert.setString(12, ing_unit_qty+""); //nSCH_DOSAGE_QTY
									pstmt_insert.setString(13, ing_order_uom); //nSCH_DOSAGE_UOM_CODE
									pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
									pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
									pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
									pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
									pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
									pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
									pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
									pstmt_insert.setString(21, login_by_id);
									pstmt_insert.setString(22, login_at_ws_no);
									pstmt_insert.setString(23, login_facility_id);
									pstmt_insert.setString(24, login_by_id);
									pstmt_insert.setString(25, login_at_ws_no);
									pstmt_insert.setString(26, login_facility_id);
									pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
									pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
									pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
									pstmt_insert.addBatch();
								}
							}
							closeStatement(pstmt_select); 
						}
						else {
							dosage_seqNo		= 1;
							verf_reqd_bef_med_admin_yn = "";
							

							pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
							pstmt_select.setString(1, login_facility_id);
							resultSet		= pstmt_select.executeQuery();
							if (resultSet.next()) {
								verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
							}
							closeResultSet( resultSet );

							if(iv_pb.equals("Y")){
								drugDetails1 = (HashMap)drugList.get(0);
								fr_durn_value	= Double.parseDouble(orderDetails.get("DURN_VALUE").toString());

								if(orderDetails.get("DURN_UNIT").toString().equals("H")) {
									fr_durn_value	=	Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/24;
								}
								else if(orderDetails.get("DURN_UNIT").toString().equals("M")) {
									fr_durn_value = Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/1440;
								} 
								else //if(orderDetails.get("DURN_UNIT").toString().equals("D"))
								{
									fr_durn_value = Double.parseDouble(orderDetails.get("DURN_VALUE").toString());
								} 
							/*	else {
									fr_durn_value = 1;
								}*/
								if (fr_durn_value != 0) {
									ArrayList frequencyValues = new ArrayList();
									schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)drugDetails1.get("DRUG_CODE"));

									if(freq_nature.equals("I")){
										String tmp_sch_dt = "";
										dosage_seqNo = 1;
									
//										HashMap sched_date_time_wkhr = (HashMap)tabData.get("sched_date_time_wkhr");
//										ArrayList schedDateTimesWkHr = (ArrayList)sched_date_time_wkhr.get(fr_drug_code);

										String sch_date_time="";
										if(schd_date_time != null && schd_date_time.size()>0){
											for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
												sch_date_time = (String)schd_date_time.get(scdDt);
												if(tmp_sch_dt.equals(sch_date_time.substring(0,10))){
													dosage_seqNo++;
												}
												else{
													dosage_seqNo = 1;
												}
												tmp_sch_dt    = sch_date_time.substring(0,10);

												if(!sch_date_time.equals("")&&(sch_date_time!=null)){
													pstmt_insert.setString(1, login_facility_id);
													pstmt_insert.setString(2, encounter_id);
													pstmt_insert.setString(3, sch_date_time);
													pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
													pstmt_insert.setString(5, dosage_seqNo+"");
													pstmt_insert.setString(6, order_number);

													if(flag.equals("Y")){
														pstmt_insert.setString(7,1+"");
													}
													else{
//															pstmt_insert.setString(7, (++srlNo)+"");
														pstmt_insert.setString(7, "1");
													}
													pstmt_insert.setString(8, patient_id);
													pstmt_insert.setString(9, pract_id);
													pstmt_insert.setString(10, "Y");
													pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));

													pstmt_insert.setString(12, (Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY")))+""+""); //nSCH_DOSAGE_QTY
													if(!flag.equals("N")) // if ready to use iv
														pstmt_insert.setString(13, (String)drugDetails1.get("DRUG_QTY_UOM"));
													else
														pstmt_insert.setString(13,  (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_DOSAGE_UOM_CODE

													pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
													pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
													pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
													pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
													pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
													pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
													pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
													pstmt_insert.setString(21, login_by_id);
													pstmt_insert.setString(22, login_at_ws_no);
													pstmt_insert.setString(23, login_facility_id);
													pstmt_insert.setString(24, login_by_id);
													pstmt_insert.setString(25, login_at_ws_no);
													pstmt_insert.setString(26, login_facility_id);
													pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
													pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
													pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
													pstmt_insert.addBatch();
												 }
											}
										}

										if(flag.equals("N")) {
											for(int j=1;j<=drugList.size();j++)	{
												drugDetails = (HashMap)drugList.get(j-1);
												 if(drugDetails.size() != 0){
													 if(schd_date_time != null && schd_date_time.size()>0){
														for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
															sch_date_time = (String)schd_date_time.get(scdDt);
															if(tmp_sch_dt.equals(sch_date_time.substring(0,10))){
																dosage_seqNo++;
															}
															else{
																dosage_seqNo = 1;
															}
															tmp_sch_dt    = sch_date_time.substring(0,10);
																
															if(!sch_date_time.equals("")&&(sch_date_time!=null)){
																pstmt_insert.setString(1, login_facility_id);
																pstmt_insert.setString(2, encounter_id);
																pstmt_insert.setString(3, sch_date_time);
																pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
																pstmt_insert.setString(5,dosage_seqNo + "");//"1" priya
																pstmt_insert.setString(6, order_number);
																if(flag.equals("Y")){
																	pstmt_insert.setString(7,1+"");
																}
																else{
																	pstmt_insert.setString(7, "2");
																}
																pstmt_insert.setString(8, patient_id);
																pstmt_insert.setString(9, pract_id);
																pstmt_insert.setString(10, "Y");
																pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));

																dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
																ing_unit_qty		= 0.0f;
																ing_order_qty		= 0.0f;
																ing_order_uom		= "";
																strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
																strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
																content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
																stock_uom					=	(String)drugDetails.get("STOCK_UOM");

																qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");

																if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
																	content_in_pres_base_uom =	"1";
																if(iv_pb.equals("Y")) {
																	ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
																} 
																else {
																	ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
																}
																//ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
																ing_order_uom		= (String)drugDetails.get("DRUG_QTY_UOM");

																if (dosage_type.equals("S")) {
																	 if(iv_pb.equals("Y")) {
																		   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
																	 }
																	 else {
																		  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
																	 }
																	float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
																	ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
	// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
																	if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){   // ???for  multi freq crf 
	//if( ((String)orderDetails.get("IVType")).equals("IVD")){
																		if (freq_nature.equals("I")) {
																			ing_order_qty = in_tot_qty*duration*(24/int_value);
																		}
																		else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																			ing_order_qty = in_tot_qty*rep_interval*duration;
																		}
																		else if (freq_nature.equals("O")) {
																			ing_order_qty = in_tot_qty;
																		}
																	}
																	if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																		ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																	}
																	else {
																		ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																	}
																}	
																else{
																	equl_value	= "1";
																	resultSet			= null;
																	pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));												
																	pstmt_select.setString(1, ing_order_uom);
																	pstmt_select.setString(2, qty_unit);
																	pstmt_select.setString(3, ing_order_uom);
																	pstmt_select.setString(4, qty_unit);
																	resultSet	= pstmt_select.executeQuery();

																	if (resultSet.next()) {
																		equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
																	}

																	closeResultSet( resultSet );
																	float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
										// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
																	if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																		if (freq_nature.equals("I")) {
																			ing_order_qty = in_tot_qty*duration*(24/int_value);
																		} else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																			ing_order_qty = in_tot_qty*rep_interval*duration;
																		} else if (freq_nature.equals("O")) {
																			ing_order_qty = in_tot_qty;
																		}
																	}
										// Ends (Not for IVD)
																	if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																		ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																	}
																	else {
																		ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																	}
																
																}
																pstmt_insert.setString(12, ing_unit_qty+""); //nSCH_DOSAGE_QTY
																pstmt_insert.setString(13, ing_order_uom); //nSCH_DOSAGE_UOM_CODE

																pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
																pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
																pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
																pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
																pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
																pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
																pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
																pstmt_insert.setString(21, login_by_id);
																pstmt_insert.setString(22, login_at_ws_no);
																pstmt_insert.setString(23, login_facility_id);
																pstmt_insert.setString(24, login_by_id);
																pstmt_insert.setString(25, login_at_ws_no);
																pstmt_insert.setString(26, login_facility_id);
																pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
																pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
																pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
																pstmt_insert.addBatch();
															}
														}
													}
												}	
											}
										}
									}
									else{
										if (scheduleFreq.size() > 0) {
											if(scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
												frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
										}
										if(frequencyValues != null && frequencyValues.size() > 0){
											freq_char_list	= (HashMap)frequencyValues.get(0);
											day_list		= (ArrayList)frequencyValues.get(1);
											day_names		= (ArrayList)frequencyValues.get(2);
											time_list		= (ArrayList)frequencyValues.get(3);
											dose_list		= (ArrayList)frequencyValues.get(4);
											
										}
										pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
									//	pstmt_select2		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT24A"));
										pstmt_select2		= connection.prepareStatement("SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') + ?, 'DD/MM/YYYY') || ' '|| ? scheduled_date_time FROM DUAL  WHERE    to_date(TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') +?,'DD/MM/YYYY') || ?, 'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')- 0.00069");//added - 0.00069 for IN26424 --09/02/2011-- priya
										
										boolean first_flag = true;
										for (int m=0; m<=fr_durn_value; m++){
									
										if((m != 0) && (int_value > 1)) {
											m = m+(int_value -1);
										}
										if(first_flag == false && int_value>1 && ((String)orderDetails.get("FREQ_NATURE")).equals("F")){//Code added for IN24728 --20/11/2010-- priya // To make the schd time to start from immediate next day instead of next dose schd time for alt day freq if first day dose is lapsed 
											m =1;
										}
										if(freq_char_list != null && freq_char_list.size()>0){
											if(!freq_char_list.get("durationType").equals("D")){	
												tmp_sch_dt_tm.clear();
												for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){

													if( (tmpSch+(m*day_list.size())) < schd_date_time.size())
														tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m*day_list.size())));
												}
											}
										}

			//							if (frequencyValues.size() > 0){		for multi freq seq
										if (day_list.size()>0){
//											for (int n=0; n<frequencyValues.size(); n++){		for multi freq seq
											for(int n=0;n<day_list.size();n++){
												dosage_seqNo		= 1;
												dosage_seqNo			= dosage_seqNo+n;
												String admin_time			=(String)time_list.get(n);
												String sch_date_time	= "";
												String start_date_time  =(String)orderDetails.get("START_DATE");
												String ord_end_date_time = (String)orderDetails.get("END_DATE");

												String sch_date_time_temp = "";

												if(freq_char_list.get("durationType").equals("D")){
													pstmt_select2.setString(1, start_date_time);
													pstmt_select2.setString(2, ""+m);
													pstmt_select2.setString(3, admin_time);
													pstmt_select2.setString(4, start_date_time);
													pstmt_select2.setString(5,""+m);
													pstmt_select2.setString(6,admin_time);
													pstmt_select2.setString(7,start_date_time);
													pstmt_select2.setString(8,ord_end_date_time); 
													resultSet = pstmt_select2.executeQuery();

													if (resultSet.next()) {
														sch_date_time = resultSet.getString(1);
														first_flag = true;
													}
													else
														first_flag = false;
												} 
												else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("L"))){
													if(n < tmp_sch_dt_tm.size()){
														sch_date_time_temp = (String)tmp_sch_dt_tm.get(n);	
													}

													if(sch_date_time_temp != null && !(sch_date_time_temp.equals(""))){
														sch_date_time = sch_date_time_temp;
													/*admin_time = sch_date_time_temp.substring(11,sch_date_time_temp.length());
													pstmt_select2.setString(1, start_date_time);
													pstmt_select2.setString(2, ""+m);
													pstmt_select2.setString(3, admin_time);
													pstmt_select2.setString(4, start_date_time);
													pstmt_select2.setString(5,""+m);
													pstmt_select2.setString(6,admin_time);
													pstmt_select2.setString(7,start_date_time);
													pstmt_select2.setString(8,ord_end_date_time); 
													resultSet = pstmt_select2.executeQuery();
													if (resultSet.next()) {
														sch_date_time = resultSet.getString(1);
														} */
													}
												}
												closeResultSet( resultSet );

												if(sch_date_time != null && !(sch_date_time.equals(""))){
													pstmt_insert.setString(1, login_facility_id);
													pstmt_insert.setString(2, encounter_id);
													pstmt_insert.setString(3, sch_date_time);
													pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
													pstmt_insert.setString(5, dosage_seqNo + "");
													pstmt_insert.setString(6, order_number);
													pstmt_insert.setString(7, "1");
													pstmt_insert.setString(8, patient_id);
													pstmt_insert.setString(9, pract_id);
													pstmt_insert.setString(10, "Y");
													pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
													//pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));

													if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){   //??? for  multi freq crf 
													//if( ((String)orderDetails.get("IVType")).equals("IVD")){
														float dur1 = Float.parseFloat(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"");
														if(iv_calc_infuse_by.equals("I")) //if block added for SKR-CRF-0035 [IN:037727] 
															dur1 = 1.0f;
														float qty_value = Float.parseFloat(Math.ceil((Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY"))*dur1) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE")))+"");

														pstmt_insert.setString(12, qty_value+"");
													}
													else{
														pstmt_insert.setString(12, (String)orderDetails.get("FLUID_UNIT_QTY"));
													}

													if(!flag.equals("N")) // if ready to use iv
														pstmt_insert.setString(13, (String)drugDetails1.get("DRUG_QTY_UOM"));
													else
														pstmt_insert.setString(13, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));

													pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY"));
													pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
													pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE"));
													pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE"));
													pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
													pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
													pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
													pstmt_insert.setString(21, login_by_id);
													pstmt_insert.setString(22, login_at_ws_no);
													pstmt_insert.setString(23, login_facility_id);
													pstmt_insert.setString(24, login_by_id);
													pstmt_insert.setString(25, login_at_ws_no);
													pstmt_insert.setString(26, login_facility_id);

													pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
													pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
													pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
													pstmt_insert.addBatch();
													if(flag.equals("N")) {
														srlNo = 1;
														for(int j=1;j<=drugList.size();j++)	{
															drugDetails = (HashMap)drugList.get(j-1);
															ing_unit_qty		= 0.0f;
															ing_order_qty		= 0.0f;
															if(drugDetails.size() != 0){	
																pstmt_insert.setString(1, login_facility_id);
																pstmt_insert.setString(2, encounter_id);
																pstmt_insert.setString(3, sch_date_time);
																pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
																pstmt_insert.setString(5,dosage_seqNo + "");//"1" priya
																pstmt_insert.setString(6, order_number);
																if(flag.equals("Y")){
																	pstmt_insert.setString(7,1+"");
																}
																else{
																	pstmt_insert.setString(7, (++srlNo)+"");
																}
																pstmt_insert.setString(8, patient_id);
																pstmt_insert.setString(9, pract_id);
																pstmt_insert.setString(10, "Y");
																pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
												

																dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
																ing_order_uom		= "";
																strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
																strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
																content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
																stock_uom					=	(String)drugDetails.get("STOCK_UOM");
																qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");

																if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
																	content_in_pres_base_uom =	"1";
																if(iv_pb.equals("Y")) {
																	ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
																} 
																else {
																	ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
																}
																//ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
																ing_order_uom		= (String)drugDetails.get("DRUG_QTY_UOM");
																if (dosage_type.equals("S")) {
																	 if(iv_pb.equals("Y")) {
																		   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
																	 }
																	 else {
																		  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
																	 }
																	float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
																	ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
	// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
																	if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){   // ???for  multi freq crf 
	//if( ((String)orderDetails.get("IVType")).equals("IVD")){
																		if (freq_nature.equals("I")) {
																			ing_order_qty = in_tot_qty*duration*(24/int_value);
																		}
																		else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																			ing_order_qty = in_tot_qty*rep_interval*duration;
																		}
																		else if (freq_nature.equals("O")) {
																			ing_order_qty = in_tot_qty;
																		}
																	}
	// Ends (not for IVD)
	//???	 multi freq crf
																	if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																		ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																	} 
																	else {
																		ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																	}
																}	
																else{
																	equl_value	= "1";
																	resultSet			= null;
																	pstmt_select.setString(1, ing_order_uom);
																	pstmt_select.setString(2, qty_unit);
																	pstmt_select.setString(3, ing_order_uom);
																	pstmt_select.setString(4, qty_unit);
																	resultSet	= pstmt_select.executeQuery();

																	if (resultSet.next()) {
																		equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
																	}

																	closeResultSet( resultSet );
																	float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
																	
										// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
																	if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																		if (freq_nature.equals("I")) {
																			ing_order_qty = in_tot_qty*duration*(24/int_value);
																		}
																		else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																			ing_order_qty = in_tot_qty*rep_interval*duration;
																		} 
																		else if (freq_nature.equals("O")) {
																			ing_order_qty = in_tot_qty;
																		}
																	}
										// Ends (Not for IVD)
																	if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																		ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																	}
																	else {
																		ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																	}
																}
																pstmt_insert.setString(12, ing_unit_qty+""); //nSCH_DOSAGE_QTY
																pstmt_insert.setString(13, ing_order_uom); //nSCH_DOSAGE_UOM_CODE

																pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
																pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
																pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
																pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
																pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
																pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
																pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
																pstmt_insert.setString(21, login_by_id);
																pstmt_insert.setString(22, login_at_ws_no);
																pstmt_insert.setString(23, login_facility_id);
																pstmt_insert.setString(24, login_by_id);
																pstmt_insert.setString(25, login_at_ws_no);
																pstmt_insert.setString(26, login_facility_id);
																pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
																pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
																pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
																pstmt_insert.addBatch();
																}	
															}
														}  
													}//priya
												}
											}
											else if(((String)orderDetails.get("FREQ_NATURE")).equals("O") && m!=fr_durn_value){
												dosage_seqNo		= 1;
												//String start_date_time  =(String)orderDetails.get("START_DATE");
												stat_sch_time = (String)orderDetails.get("START_DATE");
												pstmt_insert.setString(1, login_facility_id);
												pstmt_insert.setString(2, encounter_id);
												pstmt_insert.setString(3, stat_sch_time);
												pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
												pstmt_insert.setString(5, dosage_seqNo + "");
												pstmt_insert.setString(6, order_number);
												pstmt_insert.setString(7, "1");
												pstmt_insert.setString(8, patient_id);
												pstmt_insert.setString(9, pract_id);
												pstmt_insert.setString(10, "Y");
												pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
	//											pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));

												if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){
													float dur1 = Float.parseFloat(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"");
													if(iv_calc_infuse_by.equals("I")) //if block added for SKR-CRF-0035 [IN:037727] 
														dur1 = 1.0f;
													float qty_value = Float.parseFloat(Math.ceil((Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY"))*dur1) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE")))+"");

													pstmt_insert.setString(12, qty_value+"");
												}
												else{
													pstmt_insert.setString(12, (String)orderDetails.get("FLUID_UNIT_QTY"));
												}

												if(!flag.equals("N")) // if ready to use iv
													pstmt_insert.setString(13, (String)drugDetails1.get("DRUG_QTY_UOM"));
												else
													pstmt_insert.setString(13, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
												pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY"));
												pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
												pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE"));
												pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE"));
												pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
												pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
												pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
												pstmt_insert.setString(21, login_by_id);
												pstmt_insert.setString(22, login_at_ws_no);
												pstmt_insert.setString(23, login_facility_id);
												pstmt_insert.setString(24, login_by_id);
												pstmt_insert.setString(25, login_at_ws_no);
												pstmt_insert.setString(26, login_facility_id);

												pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
												pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
												pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
												pstmt_insert.addBatch();
												if(flag.equals("N")) {
													srlNo = 1;
													for(int j=1;j<=drugList.size();j++)	{
														drugDetails = (HashMap)drugList.get(j-1);
														 if(drugDetails.size() != 0){	
															pstmt_insert.setString(1, login_facility_id);
															pstmt_insert.setString(2, encounter_id);
															pstmt_insert.setString(3, stat_sch_time);
															pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
															pstmt_insert.setString(5, "1");
															pstmt_insert.setString(6, order_number);
															if(flag.equals("Y")){
																pstmt_insert.setString(7,1+"");
															}
															else{
																pstmt_insert.setString(7, (++srlNo)+"");
															}
															pstmt_insert.setString(8, patient_id);
															pstmt_insert.setString(9, pract_id);
															pstmt_insert.setString(10, "Y");
															pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
											

															dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
															ing_unit_qty		= 0.0f;
															ing_order_qty		= 0.0f;
															ing_order_uom		= "";
															strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
															strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
															content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
															stock_uom					=	(String)drugDetails.get("STOCK_UOM");
															qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");
															if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
																content_in_pres_base_uom =	"1";
															if(iv_pb.equals("Y")) {
																ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
															} 
															else {
																ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
															}
															ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

															if (dosage_type.equals("S")) {
																 if(iv_pb.equals("Y")) {
																	   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
																 }
																 else {
																	  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
																 }
																float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
																ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
									// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	if (freq_nature.equals("I")) {
																		ing_order_qty = in_tot_qty*duration*(24/int_value);
																	}
																	else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																		ing_order_qty = in_tot_qty*rep_interval*duration;
																	}
																	else if (freq_nature.equals("O")) {
																		ing_order_qty = in_tot_qty;
																	}
																}
									// Ends (not for IVD)

																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																} else {
																	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
																
															}	
															else  {							
																equl_value	= "1";
																resultSet			= null;
																pstmt_select.setString(1, ing_order_uom);
																pstmt_select.setString(2, qty_unit);
																pstmt_select.setString(3, ing_order_uom);
																pstmt_select.setString(4, qty_unit);
																resultSet	= pstmt_select.executeQuery();

																if (resultSet.next()) {
																	equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
																}
																closeResultSet( resultSet );
																float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
									// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	if (freq_nature.equals("I")) {
																		ing_order_qty = in_tot_qty*duration*(24/int_value);
																	} 
																	else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																		ing_order_qty = in_tot_qty*rep_interval*duration;
																	} 
																	else if (freq_nature.equals("O")) {
																		ing_order_qty = in_tot_qty;
																	}
																}
									// Ends (Not for IVD)
																if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
																else {
																	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
															
															}

															pstmt_insert.setString(12, ing_unit_qty+""); //nSCH_DOSAGE_QTY
															pstmt_insert.setString(13, ing_order_uom); //nSCH_DOSAGE_UOM_CODE

															pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
															pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
															pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
															pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
															pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
															pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
															pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
															pstmt_insert.setString(21, login_by_id);
															pstmt_insert.setString(22, login_at_ws_no);
															pstmt_insert.setString(23, login_facility_id);
															pstmt_insert.setString(24, login_by_id);
															pstmt_insert.setString(25, login_at_ws_no);
															pstmt_insert.setString(26, login_facility_id);
															pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
															pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
															pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
															pstmt_insert.addBatch();
														}	
													}
												}  
											}
										}
										closeStatement(pstmt_select);
										closeStatement(pstmt_select2); 
									}
								}
							}
							else {
								 fr_durn_value	= Double.parseDouble(orderDetails.get("DURN_VALUE").toString());

								if(orderDetails.get("DURN_UNIT").toString().equals("H")) {
									fr_durn_value	=	Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/24;
								} 
								else if(orderDetails.get("DURN_UNIT").toString().equals("M")) {
									fr_durn_value = Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/1440;
								}
								else {
									fr_durn_value = 1;
								}
							
								pstmt_insert.setString(1, login_facility_id);
								pstmt_insert.setString(2, encounter_id);
								pstmt_insert.setString(3, ord_date);
								pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
								pstmt_insert.setString(5, dosage_seqNo + "");
								pstmt_insert.setString(6, order_number);
								pstmt_insert.setString(7, "1");
								pstmt_insert.setString(8, patient_id);
								pstmt_insert.setString(9, pract_id);
								pstmt_insert.setString(10, "Y");
								pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
								pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
								if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){
									float dur1 = Float.parseFloat(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"") ;
									if(iv_calc_infuse_by.equals("I")) //if block added for SKR-CRF-0035 [IN:037727] 
										dur1 = 1.0f;
									float qty_value = Float.parseFloat(Math.ceil((Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY"))*dur1) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE")))+"");
									pstmt_insert.setString(12, qty_value+"");
								}
								else{
									pstmt_insert.setString(12, (Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY"))/(Integer.parseInt((String)fluidDetails.get("FLUID_PACK_SIZE"))))+"");
								}
								pstmt_insert.setString(13, (String)orderDetails.get("BASE_UOM"));
								pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY"));
								pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
								pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE"));
								pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE"));
								pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
								pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
								pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
								pstmt_insert.setString(21, login_by_id);
								pstmt_insert.setString(22, login_at_ws_no);
								pstmt_insert.setString(23, login_facility_id);
								pstmt_insert.setString(24, login_by_id);
								pstmt_insert.setString(25, login_at_ws_no);
								pstmt_insert.setString(26, login_facility_id);

								pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
								pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
								pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
								pstmt_insert.addBatch();
								
								pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
								srlNo	= 1;
								for(int j=1;j<=drugList.size();j++) {
									drugDetails = (HashMap)drugList.get(j-1);
									if(drugDetails.size() != 0){
										pstmt_insert.setString(1, login_facility_id);
										pstmt_insert.setString(2, encounter_id);
										pstmt_insert.setString(3, ord_date);
										pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
										pstmt_insert.setString(5, "1");
										pstmt_insert.setString(6, order_number);
										pstmt_insert.setString(7, (++srlNo)+"");
										pstmt_insert.setString(8, patient_id);
										pstmt_insert.setString(9, pract_id);
										pstmt_insert.setString(10, "Y");
										pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
										dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
										ing_unit_qty		= 0.0f;
										ing_order_qty		= 0.0f;
										ing_order_uom	= "";
										strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
										strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
										content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
										stock_uom					=	(String)drugDetails.get("STOCK_UOM");
										qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");

										if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
											content_in_pres_base_uom =	"1";

										ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
										ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

										if (dosage_type.equals("S")) {
											ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
											float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
											ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
	// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
											if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y"))){
												if (freq_nature.equals("I")) {
													ing_order_qty = in_tot_qty*duration*(24/int_value);
												}
												else if (freq_nature.equals("F") || freq_nature.equals("C")) {
													ing_order_qty = in_tot_qty*rep_interval*duration;
												} 
												else if (freq_nature.equals("O")) {
													ing_order_qty = in_tot_qty;
												}
											}
	// Ends (not for IVD)
											if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y"))){
												ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
											} 
											else {
												ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
											}
										}	
										else  {							
											equl_value	= "1";
											pstmt_select.setString(1, ing_order_uom);
											pstmt_select.setString(2, qty_unit);
											pstmt_select.setString(3, ing_order_uom);
											pstmt_select.setString(4, qty_unit);
											resultSet	= pstmt_select.executeQuery();

											if (resultSet.next()) {
												equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
											}
											closeResultSet( resultSet );
											float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
											
	// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
											if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y"))){
												if (freq_nature.equals("I")) {
													ing_order_qty = in_tot_qty*duration*(24/int_value);
												} else if (freq_nature.equals("F") || freq_nature.equals("C")) {
													ing_order_qty = in_tot_qty*rep_interval*duration;
												} else if (freq_nature.equals("O")) {
													ing_order_qty = in_tot_qty;
												}
											}
	// Ends (Not for IVD)
											if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y"))){
												ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
											} 
											else {
												ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
											}
										
										}

										pstmt_insert.setString(12, ing_order_qty+""); //nSCH_DOSAGE_QTY
										pstmt_insert.setString(13, stock_uom); //nSCH_DOSAGE_UOM_CODE
										pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
										pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
										pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
										pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
										pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
										pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
										pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
										pstmt_insert.setString(21, login_by_id);
										pstmt_insert.setString(22, login_at_ws_no);
										pstmt_insert.setString(23, login_facility_id);
										pstmt_insert.setString(24, login_by_id);
										pstmt_insert.setString(25, login_at_ws_no);
										pstmt_insert.setString(26, login_facility_id);
										pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
										pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
										pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
										pstmt_insert.addBatch();
									}	
								}
								closeStatement(pstmt_select); 
							}
						}
							 
						int[] batch_result = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result.length;i++) {
							if(batch_result[i] < 0  && batch_result[i] != -2 ) {
								System.err.println("IV ADDITIVES/INTERMITENT--> ERROR IN INSERTING PH_MEDN_ADMIN batch_result["+i+"]= "+batch_result[i]);
								System.err.println("tabData=== "+tabData);
								result = 0;
								break;
							}
							else {
								result = 1;
							}
						}
						closeStatement(pstmt_insert); 
					}
				} 
				else{
					boolean freq_values_found = false;
					if( buildMAR_yn.equals("Y")){
						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));
						pstmt_insert.clearBatch();
						double fr_durn_value	= Double.parseDouble(orderDetails.get("DURN_VALUE").toString());

						if(orderDetails.get("DURN_UNIT").toString().equals("H")) {
							fr_durn_value	=	Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/24;
						}
						else if(orderDetails.get("DURN_UNIT").toString().equals("M")) {
							fr_durn_value = Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/1440;
						}
						else {
							fr_durn_value = 1;
						}

						if(iv_pb.equals("Y")) {
							drugDetails1 = (HashMap)drugList.get(0);
							if (fr_durn_value != 0) {
								ArrayList frequencyValues = new ArrayList();
								schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)drugDetails1.get("DRUG_CODE"));
								if (scheduleFreq.size() > 0) {
									if(scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
										frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
								}
								/*below if block and vals for multi freq crf*/
								if(frequencyValues != null && frequencyValues.size() > 0){
									freq_char_list	= (HashMap)frequencyValues.get(0);
									day_list		= (ArrayList)frequencyValues.get(1);
									day_names		= (ArrayList)frequencyValues.get(2);
									time_list		= (ArrayList)frequencyValues.get(3);
									dose_list		= (ArrayList)frequencyValues.get(4);
								}
								String admin_time		= "";
								String admin_qty		= "";
								pstmt_select2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT24A"));				
								pstmt_select 	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
								pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
								for (int m=0; m<fr_durn_value; m++) {
									if(freq_char_list != null && freq_char_list.size()>0){
										if(!freq_char_list.get("durationType").equals("D")){	
											tmp_sch_dt_tm.clear();
											for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){
												tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m*day_list.size())));
											}
										}
									}

									if (frequencyValues.size() > 0) {
										freq_values_found = true;
										//for (int n=0; n<frequencyValues.size(); n++) { for multi freq crf
										for(int n=0;n<day_list.size();n++){
											int dosage_seqNo		= 1;
											dosage_seqNo			= dosage_seqNo+n;
											/*HashMap data			= (HashMap)frequencyValues.get(n);
											String admin_time		= (String)data.get("admin_time");
											String admin_qty		= (String)data.get("admin_qty");*/
											admin_time			=(String)time_list.get(n);
											admin_qty			=(String)dose_list.get(n);
										
											String sch_date_time	= "";
											if(freq_char_list.get("durationType").equals("D")){
												pstmt_select2.setString(1, ord_date);
												pstmt_select2.setString(2, ""+m);
												pstmt_select2.setString(3, admin_time);
												resultSet = pstmt_select2.executeQuery();

												if (resultSet.next()) {
													sch_date_time = resultSet.getString(1);
												}
											}
											else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("M"))){
												sch_date_time = (String)tmp_sch_dt_tm.get(n);				
											}
											closeResultSet( resultSet );

											String dosage_type		= (String)fluidDetails.get("DOSAGE_TYPE");
											String qty_unit			= (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
											String strength_value	= (String)fluidDetails.get("STRENGTH_VALUE");
											String strength_uom		= (String)fluidDetails.get("STRENGTH_UOM");
											String pres_base_uom	= (String)fluidDetails.get("PRES_BASE_UOM");
											String equal_value		= (String)fluidDetails.get("EQUAL_VALUE");
											equal_value				= "1";

											if (dosage_type.equals("Q")) {
												equal_value		= "1";
												pstmt_select.setString(1, pres_base_uom);
												pstmt_select.setString(2, qty_unit);
												pstmt_select.setString(3, pres_base_uom);
												pstmt_select.setString(4, qty_unit);
												resultSet		= pstmt_select.executeQuery();
												if (resultSet.next()) {
													equal_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
												}
												closeResultSet( resultSet );
											}

											String verf_reqd_bef_med_admin_yn = "";
											pstmt_select3.setString(1, login_facility_id);
											resultSet		= pstmt_select3.executeQuery();
											if (resultSet.next()) {
												verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
											}
											closeResultSet( resultSet );

											pstmt_insert.setString(1, login_facility_id);
											pstmt_insert.setString(2, encounter_id);
											pstmt_insert.setString(3, sch_date_time);
											pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
											pstmt_insert.setString(5, dosage_seqNo + "");
											pstmt_insert.setString(6, order_number);
											pstmt_insert.setString(7, "1");
											pstmt_insert.setString(8, patient_id);
											pstmt_insert.setString(9, pract_id);
											pstmt_insert.setString(10, "Y");
											pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
											pstmt_insert.setString(12, admin_qty);
											pstmt_insert.setString(13, qty_unit);
											String sch_strength		= strength_value;
											String sch_strength_uom	= strength_uom;

											if (dosage_type.equals("S")) {
												sch_strength = strength_value;
											} 
											else {
												float tot_strn	= (Float.parseFloat(admin_qty))*(Float.parseFloat(strength_value))*(Float.parseFloat(equal_value));
												sch_strength	= String.valueOf(tot_strn);
												if (sch_strength.length() > 11) {
													sch_strength = sch_strength.substring(0, 11);
												}
											}

											pstmt_insert.setString(14, sch_strength);
											pstmt_insert.setString(15, sch_strength_uom);
											pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE"));
											pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE"));
											pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
											pstmt_insert.setString(19, "M");
											pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
											pstmt_insert.setString(21, login_by_id);
											pstmt_insert.setString(22, login_at_ws_no);
											pstmt_insert.setString(23, login_facility_id);
											pstmt_insert.setString(24, login_by_id);
											pstmt_insert.setString(25, login_at_ws_no);
											pstmt_insert.setString(26, login_facility_id);

											pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
											pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
											pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID")); //added for MMS-QH-CRF-0080 [IN:038064]
											pstmt_insert.addBatch();
										}
									}
								}
								closeStatement(pstmt_select2);
								closeStatement(pstmt_select);
								closeStatement(pstmt_select3); 
							}
						}
						if (freq_values_found) {
							int[] batch_result = pstmt_insert.executeBatch();
							for (int i=0;i<batch_result.length;i++) {
								if(batch_result[i] < 0  && batch_result[i] != -2 ) {
									result = 0;
									break;
								}
								else {
									result = 1;
								}
							}
						}
						else {
							result = 1;
						}
					}
					closeStatement(pstmt_insert); 
				}
			}
			if (result>0) {
				//code added for WorkLoad status.....on 14/5/2004
				String dly_count						 = "";
				String monthly_count					 = "";
				String dly_count_loc					 = "";
				String monthly_count_loc				 = "";

				int totalOrder	=	1;
				int totalDrugs	  =	1;
				totalDrugs	+= drugList.size();

				String patient_Class	=(String)orderDetails.get("PATIENT_CLASS");
				String locationType		=(String)orderDetails.get("SOURCE_TYPE");
				String locationCode		=(String)orderDetails.get("SOURCE_CODE");
				
				pstmt_workload		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT72")) ;
				pstmt_workload.setString(1,(String)orderDetails.get("ORD_PRACT_ID"));
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,patient_Class);

				resultSet_workload  	= pstmt_workload.executeQuery() ;
				while (resultSet_workload.next()){
					dly_count		= (resultSet_workload.getString("DLYCOUNT")).trim();				
				}
				closeResultSet( resultSet_workload );
				closeStatement(pstmt_workload);
				pstmt_workload		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT73")) ;
				pstmt_workload.setString(1,(String)orderDetails.get("ORD_PRACT_ID"));
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,patient_Class);

				resultSet_workload  	= pstmt_workload.executeQuery() ;
				while (resultSet_workload.next()){
					monthly_count			=	(resultSet_workload.getString("MTHLYCOUNT")).trim();	
				}
				closeResultSet( resultSet_workload );
				closeStatement(pstmt_workload);

				if(dly_count.equals("0")) {
					workload_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT9")) ;
					workload_insert.setString( 1, (String)orderDetails.get("ORD_PRACT_ID"));
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
				}
				else{
					workload_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY6")) ;
					workload_insert.setString( 1,String.valueOf(totalOrder));
					workload_insert.setString( 2,String.valueOf(totalDrugs));
					workload_insert.setString( 3, login_by_id);
					workload_insert.setString( 4, login_at_ws_no);
					workload_insert.setString( 5, login_facility_id);
					workload_insert.setString( 6, (String)orderDetails.get("ORD_PRACT_ID"));
					workload_insert.setString( 7, login_facility_id);
					workload_insert.setString( 8, patient_Class);
					workload_insert.executeUpdate();
				}
				closeStatement(workload_insert);
				if(monthly_count.equals("0")){
					work_insert_month		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT10")) ;
					work_insert_month.setString( 1, (String)orderDetails.get("ORD_PRACT_ID"));
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
				}
				else{
					work_insert_month		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY7")) ;
					work_insert_month.setString( 1,String.valueOf(totalOrder));
					work_insert_month.setString( 2,String.valueOf(totalDrugs));
					work_insert_month.setString( 3, login_by_id);
					work_insert_month.setString( 4, login_at_ws_no);
					work_insert_month.setString( 5, login_facility_id);
					work_insert_month.setString( 6, (String)orderDetails.get("ORD_PRACT_ID"));
					work_insert_month.setString( 7, login_facility_id);
					work_insert_month.setString( 8, patient_Class);
					work_insert_month.executeUpdate();
				}
				closeStatement(work_insert_month); 

				pstmt_workload			= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT74")) ;
				pstmt_workload.setString(1,locationType);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,locationCode);
				resultSet_workload  	= pstmt_workload.executeQuery() ;

				while (resultSet_workload.next()){
					dly_count_loc	= (resultSet_workload.getString("DLYCOUNT")).trim();				
				}
				closeResultSet( resultSet_workload );
				closeStatement(pstmt_workload);

				pstmt_workload			= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT75")) ;
				pstmt_workload.setString(1,locationType);
				pstmt_workload.setString(2,login_facility_id);
				pstmt_workload.setString(3,locationCode);

				resultSet_workload  	= pstmt_workload.executeQuery() ;
				while (resultSet_workload.next()){
					monthly_count_loc		=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
				}
				closeResultSet( resultSet_workload );
				closeStatement(pstmt_workload); 
			
				if(dly_count_loc.equals("0")) {
					work_insert_loc = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT11")) ;
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
				}
				else{
					work_insert_loc = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY8")) ;
					work_insert_loc.setString(1,String.valueOf(totalOrder));
					work_insert_loc.setString(2,String.valueOf(totalDrugs));
					work_insert_loc.setString(3, login_by_id);
					work_insert_loc.setString(4, login_at_ws_no);
					work_insert_loc.setString(5, login_facility_id);
					work_insert_loc.setString(6, locationType);
					work_insert_loc.setString(7, login_facility_id);
					work_insert_loc.setString(8, locationCode);
					work_insert_loc.executeUpdate();
				}
				closeStatement(work_insert_loc);

				if(monthly_count_loc.equals("0")){
					work_insert_loc_mon =  connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT12")) ;
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
				}
				else{
					work_insert_loc_mon =  connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_MODIFY9")) ;
					work_insert_loc_mon.setString(1,String.valueOf(totalOrder));
					work_insert_loc_mon.setString(2,String.valueOf(totalDrugs));
					work_insert_loc_mon.setString(3, login_by_id);
					work_insert_loc_mon.setString(4, login_at_ws_no);
					work_insert_loc_mon.setString(5, login_facility_id);
					work_insert_loc_mon.setString(6, locationType);
					work_insert_loc_mon.setString(7, login_facility_id);
					work_insert_loc_mon.setString(8, locationCode);
					work_insert_loc_mon.executeUpdate();
					
				}
				closeStatement(work_insert_loc_mon); 

				String auto_order_regn_err = "";
				String tokens_generated_yn = "";
				if((patient_class.equals("OP") || patient_class.equals("EM")) && !trn_group_ref.equals("")){
					cstmt_insert=connection.prepareCall("{call ph_auto_order_regn(?,?,?,?,?,?)}");

					cstmt_insert.setString( 1, trn_group_ref);
					cstmt_insert.setString( 2, patient_id);
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
				if (auto_order_regn_err.equals("")) {
					map.put("result", new Boolean(true));
					map.put("msgid", "RECORD_INSERTED");
					map.put("trn_group_ref", trn_group_ref);
					map.put("tokens_generated_yn", tokens_generated_yn);
					connection.commit();
				} 
				else {
					connection.rollback();
					map.put("auto_order_regn_err", auto_order_regn_err);
					throw new EJBException("Insert Failed");
				}
			}
		}
		catch(Exception e) {
			try {
				connection.rollback();
				e.printStackTrace();
				throw new EJBException(this + " : " + e.getMessage());
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
			map.put("msgid", e.getMessage());
			e.printStackTrace();
			System.err.println("===Error in insert IV ==tabData="+tabData);
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement(pstmt_insert);
				closeStatement(pstmt_select);
				closeStatement(pstmt_select2);
				closeStatement(pstmt_select3);
				closeStatement(cstmt_insert);
				closeStatement(pstmt_update);
				closeStatement(pstmt_update_non_scheduled_drug);
				closeStatement(pstmt_delete);
				closeStatement(pstmt_clob);
				closeStatement(pstmt_update_order_line_ph);
				closeStatement(pstmt_update_patient_drug_profile);
				closeStatement(pstmt_workload);
				closeStatement(workload_insert);		 
				closeStatement(work_insert_month);		 
				closeStatement(work_insert_loc)	;	 
				closeStatement(work_insert_loc_mon);	 
				closeResultSet( resultSet_workload );

				closeConnection(connection, (Properties)tabData.get("PROPERTIES"));
			}
			catch(Exception fe) {
				fe.printStackTrace();
			}
		}
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

/**
* @ejb.interface-method
*	 view-type="both"
*/
/*modify method handles for both iv with additives  and iv intermitent(iv continuous) orders in amend mode*/
   public HashMap modify( HashMap tabData, HashMap sqlMap ) {
	   System.out.println("modify");
	   System.out.println("tabData"+tabData);
	   System.out.println("sqlMap"+sqlMap);
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "");
		map.put("msgid", "");
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		PreparedStatement pstmt_select2	= null;
		PreparedStatement pstmt_select3	= null;
		//PreparedStatement pstmt_select4	= null;//IN066779 //COMMENTED FOR COMMON-ICN-0048
		
		Statement statement	= null;

		PreparedStatement pstmt_insert	= null,pstmt_update_order_line_ph=null,pstmt_update_patient_drug_profile=null;
		PreparedStatement pstmt_update=null,pstmt_update_non_scheduled_drug	= null,pstmt_delete=null,pstmt_clob=null;
		CallableStatement cstmt_insert	= null;     
		ResultSet resultSet				= null;
		//ResultSet resultSet4				= null;//IN066779 //COMMENTED FOR COMMON-ICN-0048

		try {
			String lang_id				= (String)tabData.get("lang_id");
			HashMap orderDetails		= (HashMap)tabData.get("ORDERDETAILS");
			HashMap commonData			= (HashMap)tabData.get("COMMONDATA");
			HashMap	scheduleFreq		= (HashMap)tabData.get("SCHEDULEFREQ");
			HashMap	fluidDetails		= (HashMap)tabData.get("FLUIDDETAILS");
			ArrayList drugList			= (ArrayList)tabData.get("DRUGDETAILS");
			ArrayList drugRemarks		= (ArrayList)tabData.get("DRUGREMARKS");
			String license				= (String)tabData.get("LICENSE");
			String or_mode				= (String)tabData.get("OR_MODE");
			System.out.println("orderDetails"+orderDetails);
			String order_number			= (String)orderDetails.get("ORDER_ID");
			String pract_id				= (String)orderDetails.get("ORD_PRACT_ID");
			String ord_date				= (String)orderDetails.get("ORD_DATE");
            String start_date			= (String)orderDetails.get("START_DATE");
    		String end_date				= (String)orderDetails.get("END_DATE");
			String location_type		= (String)orderDetails.get("SOURCE_TYPE");
			String location_code		= (String)orderDetails.get("SOURCE_CODE");
			String priority				= (String)orderDetails.get("PRIORITY");
			String opDischMed 			= (String)orderDetails.get("OP_DISCH_MED_IND");//added for NMC-JD-CRF-0063
			String take_home_medn_op   = (String)orderDetails.get("TAKEHOMEMED_OP");//added for NMC-JD-CRF-0063
			String takehome_op_sitespecific   = (String)orderDetails.get("TAKE_HOME_OP_SITESPECIFIC");//added for NMC-JD-CRF-0063 
			String order_status	=(String)orderDetails.get("ORDER_STATUS");//added for ml-mmoh-crf-0863
			String buildMAR_yn="";
			String infuse_over	=	"";
			String infusionRatePeriodUnit	=	"";
			String uomDisplay	=	"";
			String amend_reason_code =(String)orderDetails.get("AMEND_REASON_CODE");//Added for ML-BRU-SCF-0098 [IN031837]
			String amend_reason		 =(String)orderDetails.get("AMEND_REASON");//Added for ML-BRU-SCF-0098 [IN031837]
			
			String amend_order_id=(String)orderDetails.get("AMEND_ORDER_ID");//IN066779
			String amend_order_reason=(String)orderDetails.get("AMEND_ORDER_REASON");//IN066779
			HashMap freq_char_list	 = new HashMap();
			ArrayList day_list	= new ArrayList();
			ArrayList day_names	= new ArrayList();
			ArrayList time_list	= new ArrayList();
			ArrayList dose_list	= new ArrayList(); 
			if(priority.equals("")|| priority == null){
				priority="R";
			}
			String encounter_id			= (String)orderDetails.get("ENCOUNTER_ID");
			String patient_id			= (String)orderDetails.get("PATIENT_ID");
			String freq_code			= (String)orderDetails.get("FREQ_CODE");
			String freq_nature			= (String)orderDetails.get("FREQ_NATURE");
			String allergic_yn			= (String)tabData.get("allergic_yn");
			String iv_calc_infuse_by			=tabData.get("iv_calc_infuse_by")==null?"":(String)tabData.get("iv_calc_infuse_by");//Added for SKR-CRF-0035 [IN:037727] 
			buildMAR_yn			= (String)orderDetails.get("BUILD_MAR_YN")==null?"N":(String)orderDetails.get("BUILD_MAR_YN");
//			String	MAR_barcode_id=(String)orderDetails.get("MAR_BARCODE_ID")==null?"":(String)orderDetails.get("MAR_BARCODE_ID");//added for  MMS-QH-CRF-0080 [IN:038064] //COMMENTED FOR COMMON-ICN-0048	
			String generic_id           = "";
			int	srlNo					= 0;

			if(allergic_yn==null) {
				allergic_yn		=	"N";
			}
			
			String iv_pb				= "N";
			if(orderDetails.get("IV_PB")!=null){
				iv_pb = (String)orderDetails.get("IV_PB");
			}
	
			int rep_interval			=	1;
			int int_value				=	1;
			if(orderDetails.get("REP_INTERVAL")!=null && !((String)orderDetails.get("REP_INTERVAL")).equals("")) {
				rep_interval			=	Integer.parseInt((String)orderDetails.get("REP_INTERVAL"));
			}
		
			if(orderDetails.get("INT_VALUE")!=null && !((String)orderDetails.get("INT_VALUE")).equals("")) {
				int_value			=	Integer.parseInt((String)orderDetails.get("INT_VALUE"));
			}

			String login_facility_id	= (String)commonData.get("login_facility_id");
			String login_at_ws_no		= (String)commonData.get("login_at_ws_no");
			String login_by_id			= (String)commonData.get("login_by_id");
			String strength_per_value_pres_uom	=	"";
			String strength_per_pres_uom		=	"";
			String content_in_pres_base_uom		=	"";
			String stock_uom					=	"";
			String order_comment		= (String)tabData.get("ORDER_COMMENTS")==null?"":(String)tabData.get("ORDER_COMMENTS");
			String freq_changed_yn		= (String)tabData.get("FREQ_CHANGED_YN");

			float duration 		= Float.parseFloat((String)orderDetails.get("DURN_VALUE"));

			String mfr_yn = (String)orderDetails.get("MFR_YN")==null?"N":(String)orderDetails.get("MFR_YN");
			HashMap MFR_Recs = new HashMap();
			if(mfr_yn.equals("Y"))
				MFR_Recs = (HashMap)orderDetails.get("MFR_Recs");

			if( orderDetails.get("MFR_YN")==null || ((String)orderDetails.get("MFR_YN")).equals("N"))
				duration = Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
			else
				duration =Float.parseFloat((String)(MFR_Recs.get("totFlowDurnHrs")));

			float fld_unit_qty 			= Float.parseFloat(orderDetails.get("FLUID_UNIT_QTY").toString());
			String fluid_ord_qty	= "";
			float pack_size			= Float.parseFloat((String)orderDetails.get("PACK_SIZE"));
			float durn_val_for_freq	= 0;
			
			if(iv_pb.equals("Y") && int_value > 0)
				duration = duration / int_value;
			if (freq_nature.equals("I")) {
				if(license!=null && !license.equals("PHBASIC"))
					fluid_ord_qty = ((fld_unit_qty*duration)/pack_size)+"";
				else 
					fluid_ord_qty = (fld_unit_qty*duration)+"";//*(24/int_value))+"";

				if((or_mode.equals("or_amend") && freq_changed_yn.equals("Y") )||  !or_mode.equals("or_amend"))
					durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"))*int_value;
				else
					durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
			} 
			else if (freq_nature.equals("F") || freq_nature.equals("C")) {
				if(license!=null && !license.equals("PHBASIC"))
					fluid_ord_qty = ((fld_unit_qty*rep_interval*duration)/pack_size)+"";
				else
					fluid_ord_qty = ((fld_unit_qty*rep_interval*duration))+"";

				durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
			} 
			else if (freq_nature.equals("O")) {
				if(license!=null && !license.equals("PHBASIC")) 
					fluid_ord_qty = ((fld_unit_qty)/pack_size)+"";
				else 
					fluid_ord_qty = ((fld_unit_qty))+"";

				durn_val_for_freq = Float.parseFloat((String)orderDetails.get("SCH_INFUSION_PERIOD"));
			}
		
			float fld_ordered_qty = new Double(Math.ceil(Float.parseFloat(fluid_ord_qty))).floatValue();
			fluid_ord_qty = fld_ordered_qty+"";
			connection = getConnection((Properties)tabData.get("PROPERTIES"));
			connection.setAutoCommit(false);
			/*IN066779 Starts*/
			if(!"".equals(amend_order_id)){ 
				PreparedStatement	auditSeqPStmt = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 FROM OR_ORDER_AMEND_REASON WHERE ORDER_ID = ?");
				auditSeqPStmt.setString(1,amend_order_id);				
				ResultSet auditSeqRs = auditSeqPStmt.executeQuery();				
				String amend_reason_seq ="";
				if (auditSeqRs.next()){
					amend_reason_seq	= ChkDef.defaultString(auditSeqRs.getString(1));
				}
				closeResultSet( auditSeqRs );//common-icn-0029
				PreparedStatement	auditReasonPStmt = connection.prepareStatement("INSERT INTO OR_ORDER_AMEND_REASON ( ORDER_ID,ACTION_SEQ_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_AMEND_REASON) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
				auditReasonPStmt.setString(1,amend_order_id);
				auditReasonPStmt.setString(2, amend_reason_seq);
				auditReasonPStmt.setString(3, login_by_id);		
				auditReasonPStmt.setString(4, login_at_ws_no);				
				auditReasonPStmt.setString(5, login_facility_id);	
				auditReasonPStmt.setString(6, login_by_id);					
				auditReasonPStmt.setString(7, login_at_ws_no);
				auditReasonPStmt.setString(8, login_facility_id);
				auditReasonPStmt.setString(9, amend_order_reason);
				auditReasonPStmt.execute();
				closeStatement(auditReasonPStmt);
				closeStatement(auditSeqPStmt);
				
			}
			/*IN066779 ends*/
			HashMap orderStatusCode	= new HashMap();
			
			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT20A"));
			resultSet		= pstmt_select.executeQuery();

			while (resultSet.next()) {
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}
			// ADDED FOR ML-MMOH-CRF-0863 start
			if(!order_status.equals("")){
				order_status = (String)orderStatusCode.get(order_status);// ADDED FOR ML-MMOH-CRF-0863
			}
			// ADDED FOR ML-MMOH-CRF-0863 end
			closeResultSet( resultSet );
			closeStatement(pstmt_select);

			String iv_prep	=	"";
			// 1 - IV with additives (without admixture)
			// 2 - IV with additives( with admixture)
			// 3 - IV with piggy back( without admixture)	
			// 4 - IV with piggy back( with admixture)	
			// 5 - IV Without additives( continuous)
			// 6 - Compound Rx

			if(iv_pb.equals("Y")) {
				if(((String)orderDetails.get("IV_PRESC")).equals("I"))
					iv_prep	=	"4";
				else 
					iv_prep	=	"3";
			} 
			else if(((String)orderDetails.get("IVType")).equals("IVD")){
				if(((String)orderDetails.get("IV_PRESC")).equals("I")) 
					iv_prep	=	"2";
				else 
					iv_prep	=	"1";
			}
			infuse_over	=	(String)orderDetails.get("INFUSE_OVER");
			infusionRatePeriodUnit	=	(String)orderDetails.get("INFUSE_OVER_UNIT");
			if((iv_prep.equals("1")||iv_prep.equals("2")) && infusionRatePeriodUnit.equals("M"))
				infuse_over = Float.parseFloat(infuse_over)/60+"";

			String perf_locn_code	=	"";
			String perf_locn_type	=	"";
			String perf_locn_desc	=	"";
		//	System.out.println("takehome_op_sitespecific: "+takehome_op_sitespecific);//added for NMC-JD-CRF-0063
		//	System.out.println("take_home_medn_op: "+take_home_medn_op);
		//	System.out.println("opDischMed: "+opDischMed); 
			cstmt_insert=connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,null,null,null,?)}");//MODIFIED FOR NMC-JD-CRF-0063
			cstmt_insert.setString(1, login_facility_id);
			cstmt_insert.setString(2, location_type);
			cstmt_insert.setString(3, location_code);
			if(takehome_op_sitespecific!=null && takehome_op_sitespecific.equals("Y")){//ADDED for NMC-JD-CRF-0063
				cstmt_insert.setString(4, take_home_medn_op);
			}else{
				cstmt_insert.setString(4, (String)orderDetails.get("TAKEHOME_MEDN"));
			}
			
			cstmt_insert.setString(5, priority);
			cstmt_insert.setString(6, iv_prep);
			cstmt_insert.setString(7, lang_id);
			cstmt_insert.registerOutParameter(8, Types.VARCHAR);
			cstmt_insert.registerOutParameter(9, Types.VARCHAR);
			cstmt_insert.registerOutParameter(10, Types.VARCHAR);
			cstmt_insert.registerOutParameter(11, Types.VARCHAR);
			cstmt_insert.setString(12, opDischMed);//added for NMC-JD-CRF-0063
			cstmt_insert.execute();

			perf_locn_code	= cstmt_insert.getString(8);
			perf_locn_type	= cstmt_insert.getString(9);
			perf_locn_desc	= cstmt_insert.getString(10);

			closeStatement(cstmt_insert);

			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));
			pstmt_select.setString(1, freq_code);
			resultSet		= pstmt_select.executeQuery();
			String repeat_value = "";
			String interval_value = "";
			if(resultSet.next()) {
				interval_value = resultSet.getString("interval_value")==null?"1":resultSet.getString("interval_value");//null handled for SRR20056-SCF-7281
				repeat_value   = resultSet.getString("repeat_value")==null?"1":resultSet.getString("repeat_value");//null handled for SRR20056-SCF-7281
			}
			closeResultSet( resultSet );					
			closeStatement(pstmt_select);

// IV Prescription Insert Starts
  // OR_ORDER
			//If else condtions added for ml-mmoh-crf-0863 
			if(order_status.equals("")){
				pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE1"));
			}
			else{
				pstmt_insert	= connection.prepareStatement("UPDATE OR_ORDER SET IV_PREP_YN=?, PERFORMING_DEPTLOC_CODE = NVL(?,PERFORMING_DEPTLOC_CODE), MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,ORDER_STATUS=? WHERE ORDER_ID=?");
			}
			
			pstmt_insert.setString(1, iv_prep);
			pstmt_insert.setString(2, perf_locn_code);
			pstmt_insert.setString(3, login_by_id);
			pstmt_insert.setString(4, login_at_ws_no);
			pstmt_insert.setString(5, login_facility_id);
			//if else condtions added for ml-mmoh-crf-0863 start
			if(!order_status.equals("")){
				pstmt_insert.setString(6, order_status);//ADDED FOR MI-MMOH-CRF-0863
				pstmt_insert.setString(7, order_number);//6 CHANGED TO 7 FOR ML-MMOH-CRF-0863
			}
			else
				pstmt_insert.setString(6, order_number);
			//if else condtions added for ml-mmoh-crf-0863 end
			int result=0;
			result			= pstmt_insert.executeUpdate();
			closeStatement(pstmt_insert);
//end of or_order
			String short_desc	=	"";

			//float ing_durn = ((duration / Float.parseFloat(infuse_over))*100)/100 ;//commented for SKR-SCF-1674
			float ing_durn = new Double(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)).floatValue() ;
			HashMap drugDtls = (HashMap)drugList.get(0);
			String drug_cod	 = "";
			String drg_code	 = "";
			String flag		 = "N";
			if(drugDtls.size() != 0){
				drug_cod=(String)drugDtls.get("DRUG_CODE");
				drg_code=(String)fluidDetails.get("DRUG_CODE");
				if(drug_cod.equals(drg_code))
					flag="Y";
			}
// OR_ORDER_LINE
			if (result>0) { 
// OR_ORDER_LINE FOR FLUID
				//If else condtions added for ml-mmoh-crf-0863 
				if(order_status.equals("")){
					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE2"));
				}
				else{
					pstmt_insert = connection.prepareStatement("UPDATE OR_ORDER_LINE SET FREQ_CODE=?,DURN_VALUE=?,DURN_TYPE=?,START_DATE_TIME=to_date(?, 'dd/mm/yyyy hh24:mi'),END_DATE_TIME=to_date(?, 'dd/mm/yyyy hh24:mi'),ORDER_QTY=?,ORDER_UOM=?,AMD_PRACT_ID=?,AMD_DATE_TIME=SYSDATE,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,ORDER_CATALOG_CODE=?,CATALOG_DESC=?,CATALOG_SYNONYM=?,ORDER_TYPE_CODE=?,FORM_CODE=?,ROUTE_CODE=?,QTY_VALUE=?,QTY_UNIT=?,CATALOG_SYNONYM_DC=?,CATALOG_SYNONYM_AD=?,ORDER_LINE_STATUS=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
				}
				
				if( ((String)fluidDetails.get("SHORT_DESC")).length() > 39)
					short_desc	=	((String)fluidDetails.get("SHORT_DESC")).substring(0,39);
				else
					short_desc	=	((String)fluidDetails.get("SHORT_DESC"));
				if(flag.equals("N")){
					pstmt_insert.setString(1, freq_code);
					// changed for multi freq crf
					if(iv_pb.equals("Y")){
						pstmt_insert.setString(2, (String)orderDetails.get("DURN_VALUE_ACT"));
						pstmt_insert.setString(3,(String)orderDetails.get( "DURN_UNIT"));
					}
					else{
						if(((String)orderDetails.get("IVType")).equals("IVD"))
							pstmt_insert.setString(2, (String)orderDetails.get("DURN_VALUE"));
						else
							pstmt_insert.setString(2, durn_val_for_freq+"");
						pstmt_insert.setString(3, "H");
					}
					pstmt_insert.setString(4,start_date );
					pstmt_insert.setString(5, end_date);
					
					float dur1 = 1.0f; //moved from  if block to outside for SKR-SCF-1513
					if(iv_calc_infuse_by.equals("I")) //if block & else condition added for SKR-CRF-0035 [IN:037727] 
						dur1 = 1.0f;
					else
						dur1 = Float.parseFloat(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"") ;
					// duration is assigned to durl for multi freq crf.
					if(iv_pb.equals("Y"))
						dur1 = duration;

					if(((String)orderDetails.get("IVType")).equals("IVD") ){
						
						//float qty_value = Float.parseFloat(Math.ceil((Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY"))*dur1) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE")))+""); //commented for SKR-SCF-1513		
						float qty_value = Float.parseFloat(Math.ceil(Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY")) / Float.parseFloat((String)fluidDetails.get("FLUID_PACK_SIZE")))*dur1+""); //added for SKR-SCF-1513

					if(iv_pb.equals("Y") && !repeat_value.equals("")){ 
						qty_value = qty_value * Integer.parseInt(repeat_value);
					}
						pstmt_insert.setString(6, qty_value+"");
						fluidDetails.put("STOCK_ORDER_QTY",qty_value+"");
					}	
					else{
						pstmt_insert.setString(6, fluid_ord_qty);
						fluidDetails.put("STOCK_ORDER_QTY",fluid_ord_qty);
					}
					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(7, (String)orderDetails.get("BASE_UOM"));
					else{
						if(license!=null && !license.equals("PHBASIC")) 
							pstmt_insert.setString(7, (String)orderDetails.get("BASE_UOM"));
						else 
							pstmt_insert.setString(7, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
					}
					pstmt_insert.setString(8,(String)orderDetails.get("ORD_PRACT_ID") );//AMD_PRACT_ID  //login_by_id changed to ORD_PRACT_ID for  ML-BRU-SCF-0318
					pstmt_insert.setString(9, login_by_id);
					pstmt_insert.setString(10, login_at_ws_no);
					pstmt_insert.setString(11, login_facility_id);
					pstmt_insert.setString(12, (String)fluidDetails.get("DRUG_CODE"));
					pstmt_insert.setString(13, short_desc);
					pstmt_insert.setString(14, short_desc);

					pstmt_insert.setString(15, (String)fluidDetails.get("ORDER_TYPE_CODE"));
					pstmt_insert.setString(16, (String)fluidDetails.get("FORM_CODE"));
					pstmt_insert.setString(17, (String)fluidDetails.get("ROUTE_CODE"));

					if(((String)orderDetails.get("IVType")).equals("IVD"))
						pstmt_insert.setString(18, (String)orderDetails.get("FLUID_UNIT_QTY"));
					else
						pstmt_insert.setString(18, (fld_unit_qty)+"");

					pstmt_insert.setString(19, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
					pstmt_insert.setString(20, short_desc);
					pstmt_insert.setString(21, short_desc);
					//if else condtions added for ml-mmoh-crf-0863 start
					if(!order_status.equals("")){
						pstmt_insert.setString(22, order_status);//ADDED FOR ML-MMOH-CRF-0863
						pstmt_insert.setString(23, order_number);// 22 AND 23 CHANGED TO 23,24 FOR ML-MMOH-CRF-0863
						pstmt_insert.setString(24, "1");
					}
					else
						{pstmt_insert.setString(22, order_number);// 22 AND 23 CHANGED TO 23,24 FOR ML-MMOH-CRF-0863
					    pstmt_insert.setString(23, "1");
						}
					//if else condtions added for ml-mmoh-crf-0863 end
					
					pstmt_insert.executeUpdate();
					closeStatement(pstmt_insert);
				}
// OR_ORDER_LINE FOR INGREDIENTS

				if(result > 0){
					//pstmt_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE2"));
					//If else condtions added for ml-mmoh-crf-0863 
					if(order_status.equals("")){
						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE2"));
					}
					else{
						pstmt_insert = connection.prepareStatement("UPDATE OR_ORDER_LINE SET FREQ_CODE=?,DURN_VALUE=?,DURN_TYPE=?,START_DATE_TIME=to_date(?, 'dd/mm/yyyy hh24:mi'),END_DATE_TIME=to_date(?, 'dd/mm/yyyy hh24:mi'),ORDER_QTY=?,ORDER_UOM=?,AMD_PRACT_ID=?,AMD_DATE_TIME=SYSDATE,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,ORDER_CATALOG_CODE=?,CATALOG_DESC=?,CATALOG_SYNONYM=?,ORDER_TYPE_CODE=?,FORM_CODE=?,ROUTE_CODE=?,QTY_VALUE=?,QTY_UNIT=?,CATALOG_SYNONYM_DC=?,CATALOG_SYNONYM_AD=?,ORDER_LINE_STATUS=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
					}
					pstmt_select2		= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT2"));
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
					srlNo = 1;
					for(int j=1;j<=drugList.size();j++) {
						HashMap drugDetails = (HashMap)drugList.get(j-1);

						if( ((String)drugDetails.get("SHORT_DESC")).length() > 39)
							short_desc	=	((String)drugDetails.get("SHORT_DESC")).substring(0,39);
						else
							short_desc	=	((String)drugDetails.get("SHORT_DESC"));

						if (drugDetails.size() != 0) {
							pstmt_insert.setString(1, freq_code);
							if(iv_pb.equals("Y")){
								pstmt_insert.setString(2, (String)orderDetails.get("DURN_VALUE_ACT"));
								pstmt_insert.setString(3,(String)orderDetails.get( "DURN_UNIT"));
							}
							else{
								if(((String)orderDetails.get("IVType")).equals("IVD"))
									pstmt_insert.setString(2, (String)orderDetails.get("DURN_VALUE"));
								else
									pstmt_insert.setString(2, durn_val_for_freq+"");
								pstmt_insert.setString(3, "H");
							}

							pstmt_insert.setString(4, start_date);
							pstmt_insert.setString(5, end_date);						
							String dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							float ing_unit_qty		= 0.0f;
							float ing_order_qty		= 0.0f;
							String ing_order_uom	= "";
							strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
							strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
							content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
							stock_uom					=	(String)drugDetails.get("STOCK_UOM");
							String qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");
							if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
								content_in_pres_base_uom =	"1";
							if(iv_pb.equals("Y"))
								ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
							else 
								ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));

							ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

/* code for check freq dosage round up yn*/
							String fract_dose = null;
							pstmt_select2.setString(1, (String)drugDetails.get("DRUG_CODE"));
							resultSet		= pstmt_select2.executeQuery();
							if(resultSet.next()) 
								fract_dose = resultSet.getString("fract_dose_round_up_yn");

							closeResultSet( resultSet ); 
/* fract_dose collection is over*/
							if (dosage_type.equals("S")) {
								if(iv_pb.equals("Y"))
								   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
								else 
									ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
									
								float in_tot_qty	= 0.0f;
								if(fract_dose.equals("Y")){
									in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
									
									in_tot_qty	=   new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
								}
								else{
									in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
								}

								ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
	// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
								if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
									if (freq_nature.equals("I"))
										ing_order_qty = in_tot_qty*duration;//*(24/int_value);
									else if (freq_nature.equals("F") || freq_nature.equals("C")) 
										ing_order_qty = in_tot_qty*rep_interval*duration;
									else if (freq_nature.equals("O"))
										ing_order_qty = in_tot_qty;
								}	// Ends (not for IVD)
								if(!iv_pb.equals("Y"))
									ing_order_qty = in_tot_qty*ing_durn;

								if(!fract_dose.equals("Y")){
									if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									}
									else {
										ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									}
								}
								else{
									ing_order_qty = new Double(Math.ceil(ing_order_qty)).floatValue();
								}
							}	
							else{							
								String equl_value	= "1";
								pstmt_select.setString(1, ing_order_uom);
								pstmt_select.setString(2, qty_unit);
								pstmt_select.setString(3, ing_order_uom);
								pstmt_select.setString(4, qty_unit);
								resultSet	= pstmt_select.executeQuery();
								if (resultSet.next()) {
									equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
								}
								closeResultSet( resultSet );
								float in_tot_qty	= 0.0f;
								if(fract_dose.equals("Y")){
									if(((String)drugDetails.get("STRENGTH_UOM")).equals(ing_order_uom)){
										in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue() * Float.parseFloat(equl_value);
										in_tot_qty	=   in_tot_qty*ing_durn;
									}
									else {

										if(((String)drugDetails.get("STOCK_UOM")).equals(qty_unit)){
											in_tot_qty = ing_unit_qty*ing_durn;
										}else{
											in_tot_qty	=new Double(	Math.ceil(ing_unit_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue() * Float.parseFloat(equl_value);//*ing_durn removed for skr-scf-1689
										}
										//ing_order_uom		= (String)drugDetails.get("STRENGTH_UOM");
									}
								}
								else{
									in_tot_qty = ing_unit_qty;
									if(!(((String)drugDetails.get("STOCK_UOM")).equals(qty_unit))){
										in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
									}
								}
// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
								if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
									if (freq_nature.equals("I")) {
										ing_order_qty = in_tot_qty*duration*(24/int_value);
										ing_order_qty = in_tot_qty*duration;
									} 
									else if (freq_nature.equals("F") || freq_nature.equals("C")) {
										ing_order_qty = in_tot_qty*rep_interval*duration;
									}
									else if (freq_nature.equals("O")) {
										ing_order_qty = in_tot_qty;
									}
								}// Ends (Not for IVD)
								if(!iv_pb.equals("Y") && fract_dose.equals("Y")){
									ing_order_qty = in_tot_qty;
								}				
								ing_order_qty = new Double(Math.ceil(ing_order_qty)).floatValue();
								if(!fract_dose.equals("Y")){
									if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									} 
									else {
										if(((String)drugDetails.get("STOCK_UOM")).equals(qty_unit)){
											ing_order_qty	=  in_tot_qty*ing_durn;
										}else{
											ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
										}
									}
								}
							}
							/*{							
								String equl_value	= "1";

								pstmt_select.setString(1, ing_order_uom);
								pstmt_select.setString(2, qty_unit);
								pstmt_select.setString(3, ing_order_uom);
								pstmt_select.setString(4, qty_unit);
								resultSet	= pstmt_select.executeQuery();

								if (resultSet.next()) 
									equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");

								try{
									closeResultSet( resultSet ); 
								}
								catch(Exception es){
									es.printStackTrace() ;
								}

								float in_tot_qty	= 0.0f;
								if(fract_dose.equals("Y")){
									in_tot_qty	=new Double(	Math.ceil(ing_unit_qty)).floatValue() * Float.parseFloat(equl_value);
								}
								else{
									in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
								}
								// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
								if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
									if (freq_nature.equals("I")) {
										ing_order_qty = in_tot_qty*duration*(24/int_value);
									} 
									else if (freq_nature.equals("F") || freq_nature.equals("C")) {
										ing_order_qty = in_tot_qty*rep_interval*duration;
									} 
									else if (freq_nature.equals("O")) {
										ing_order_qty = in_tot_qty;
									}
								}
								// Ends (Not for IVD)
								if(!iv_pb.equals("Y")){
									ing_order_qty = in_tot_qty*ing_durn;
								}				
								if(!fract_dose.equals("Y")){
									if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									}
									else {
										ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									}
								}else{
									ing_order_qty = new Double(Math.ceil(ing_order_qty)).floatValue();
								}
							}*/
							drugDetails.put("STOCK_ORDER_QTY",ing_order_qty+"");
							pstmt_insert.setString(6, ing_order_qty+"");
							pstmt_insert.setString(7, stock_uom);
							pstmt_insert.setString(8, (String)orderDetails.get("ORD_PRACT_ID"));//AMD_PRACT_ID   //login_by_id changed to ORD_PRACT_ID for  ML-BRU-SCF-0318
							pstmt_insert.setString(9, login_by_id);
							pstmt_insert.setString(10, login_at_ws_no);
							pstmt_insert.setString(11, login_facility_id);
							pstmt_insert.setString(12, (String)drugDetails.get("DRUG_CODE"));
							pstmt_insert.setString(13, short_desc);
							pstmt_insert.setString(14, short_desc);
							pstmt_insert.setString(15, (String)drugDetails.get("ORDER_TYPE_CODE"));
							pstmt_insert.setString(16, (String)drugDetails.get("FORM_CODE"));
							pstmt_insert.setString(17, (String)drugDetails.get("ROUTE_CODE"));
							dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							ing_unit_qty		= 0.0f;
							ing_order_qty		= 0.0f;
							ing_order_uom	= "";
							strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
							strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
							content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
							stock_uom					=	(String)drugDetails.get("STOCK_UOM");

							qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");

							if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
								content_in_pres_base_uom =	"1";
							if(iv_pb.equals("Y")) {
								ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
							} 
							else {
								ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
							}
							ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

							if (dosage_type.equals("S")) {
								//ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								 if(iv_pb.equals("Y")){
									   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
								 } 
								 else {
									  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								 }
								float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
								ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
								// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
								if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
									if (freq_nature.equals("I")) {
										ing_order_qty = in_tot_qty*duration;//*(24/int_value);
									}
									else if (freq_nature.equals("F") || freq_nature.equals("C")) {
										ing_order_qty = in_tot_qty*rep_interval*duration;
									}
									else if (freq_nature.equals("O")) {
										ing_order_qty = in_tot_qty;
									}
								}
								// Ends (not for IVD)
								if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
									ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
								}
								else {
									ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
								}
							}
							else {							
								String equl_value	= "1";
								pstmt_select.setString(1, ing_order_uom);
								pstmt_select.setString(2, qty_unit);
								pstmt_select.setString(3, ing_order_uom);
								pstmt_select.setString(4, qty_unit);
								resultSet	= pstmt_select.executeQuery();

								if (resultSet.next()) {
									equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
								}
								closeResultSet( resultSet ); 
								float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
								// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
								if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
									if (freq_nature.equals("I")) {
										ing_order_qty = in_tot_qty*duration;//*(24/int_value);
									} 
									else if (freq_nature.equals("F") || freq_nature.equals("C")) {
										ing_order_qty = in_tot_qty*rep_interval*duration;
									} 
									else if (freq_nature.equals("O")) {
										ing_order_qty = in_tot_qty;
									}
								}
								// Ends (Not for IVD)
								if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
									ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
								} 
								else {
									ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
								}
							}
							pstmt_insert.setString(18, ing_unit_qty+"");
							pstmt_insert.setString(19, ing_order_uom);
							pstmt_insert.setString(20, short_desc);
							pstmt_insert.setString(21, short_desc);
							//if else condtions added for ml-mmoh-crf-0863 start
							if(!order_status.equals("")){
								pstmt_insert.setString(22, order_status);//ADDED FOR ML-MMOH-CRF-0863
							
							pstmt_insert.setString(23, order_number);//22 CHANGED TO 23 FOR ML-MMOH-CRF-0863
							if(flag.equals("Y")){
								pstmt_insert.setString(24,1+"");//23 CHANGED TO 24 FOR ML-MMOH-CRF-0863
							}
							else{
								pstmt_insert.setString(24, (++srlNo)+"");//23 CHANGED TO 24 FOR ML-MMOH-CRF-0863
							}
							}
							else{
								pstmt_insert.setString(22, order_number);//22 CHANGED TO 23 FOR ML-MMOH-CRF-0863
								if(flag.equals("Y")){
									pstmt_insert.setString(23,1+"");//23 CHANGED TO 24 FOR ML-MMOH-CRF-0863
								}
								else{
									pstmt_insert.setString(23, (++srlNo)+"");//23 CHANGED TO 24 FOR ML-MMOH-CRF-0863
								}	
							}
							//if else condtions added for ml-mmoh-crf-0863 end
							
							pstmt_insert.addBatch();
						}
					}
					closeStatement(pstmt_select2); 
					closeStatement(pstmt_select);

					int[] batch_result = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result.length;i++) {
						if(batch_result[i] < 0  && batch_result[i] != -2 ) {
							System.err.println("IV ADDITIVE/INTERMITENT(AMEND)--> ERROR IN OR_ORDER_LINE UPDATION batch_result["+i+"]= "+batch_result[i]);
							System.err.println("tabData=== "+tabData);
							result = 0;
							break;
						}
						else {
							result = 1;
						}
					}
				}
				closeStatement(pstmt_insert);
			}
			if (result>0) {
// OR_ORDER_LINE_PH FOR FLUID
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE3"));
				float fld_tot_strength	= 0.0f;
				float fld_unit_strength	= 0.0f;
				String fld_strength_uom	= "";
				if(flag.equals("N")){
					pstmt_insert.setString(1, "");
					if(!mfr_yn.equals("Y")){
						if (fluidDetails.get("DOSAGE_TYPE").toString().equals("S") ) {
							float flow_rate		= Float.parseFloat(orderDetails.get("SCH_INFUSION_RATE").toString());
							fld_unit_strength	= Float.parseFloat(fluidDetails.get("STRENGTH_VALUE").toString());
							fld_tot_strength	= flow_rate*fld_unit_strength;
							fld_strength_uom	= (String)fluidDetails.get("STRENGTH_UOM");
						}
					}
					else{
						fld_tot_strength	=	Float.parseFloat((String)MFR_Recs.get("totInfVolume"));
						fld_strength_uom	= (String)fluidDetails.get("STRENGTH_UOM");
					}
					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(2, (String)orderDetails.get("FLUID_UNIT_QTY"));
					}
					else{
						pstmt_insert.setString(2, fld_tot_strength+"");
					}

					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(3, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
					}
					else{
						pstmt_insert.setString(3, fld_strength_uom);
					}

					if(mfr_yn.equals("Y")){
						pstmt_insert.setString(4, "");
						pstmt_insert.setString(5, "");
						pstmt_insert.setString(6, "");
						pstmt_insert.setString(7, "");
						pstmt_insert.setString(8, "");
						pstmt_insert.setString(28, ""); //ORIG_INFUSE_OVER
						pstmt_insert.setString(29, ""); //ORIG_INFUSION_RATE
					}
					else{
						pstmt_insert.setString(4, (String)orderDetails.get("INFUSE_OVER"));
						pstmt_insert.setString(5, (String)orderDetails.get("INFUSE_OVER_UNIT"));
						pstmt_insert.setString(6, (String)orderDetails.get("SCH_INFUSION_RATE"));
						pstmt_insert.setString(7, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
						pstmt_insert.setString(8, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
						pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER")); //ORIG_INFUSE_OVER
						pstmt_insert.setString(29, (String)orderDetails.get("SCH_INFUSION_RATE")); //ORIG_INFUSION_RATE
					}
					/*if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(9, qty_value+"");					
					}
					else	{
						pstmt_insert.setString(9, fluid_ord_qty);
					}*/
					pstmt_insert.setString(9, (String)fluidDetails.get("STOCK_ORDER_QTY"));
					
					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(10, (String)orderDetails.get("FLUID_UNIT_QTY"));
					}
					else{
						pstmt_insert.setString(10, fld_tot_strength+"");
					}
					pstmt_insert.setString(11, "N");

					if(((String)orderDetails.get("IVType")).equals("IVD")){
						if(iv_pb.equals("Y")){
							if(freq_nature.equals("I")){ // 7/3/11 whole if block
								//fluid_ord_qty =  ( fld_unit_qty * (Float.parseFloat((String)orderDetails.get("DURN_VALUE"))/int_value)/ Float.parseFloat((String)orderDetails.get("INFUSE_OVER")) )+"";
								fluid_ord_qty =  ( fld_unit_qty * (Float.parseFloat((String)orderDetails.get("DURN_VALUE"))/int_value)) +"";
							}
							else{
								fluid_ord_qty = ( fld_unit_qty * Float.parseFloat((String)orderDetails.get("DURN_VALUE")) * rep_interval  )+"";
							}
						}
						else{
							fluid_ord_qty = ( fld_unit_qty * Float.parseFloat((String)orderDetails.get("DURN_VALUE")) * rep_interval / Float.parseFloat((String)orderDetails.get("INFUSE_OVER")) )+"";
						}
						pstmt_insert.setString(12, fluid_ord_qty);
					}
					else{
						pstmt_insert.setString(12, fluid_ord_qty);
					}

					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(13, (String)fluidDetails.get("PRES_BASE_UOM"));
					}
					else{
						pstmt_insert.setString(13, (String)orderDetails.get("BASE_UOM"));
					}
					//if condition added for multi freq crf
					if(iv_pb.equals("Y")){
						pstmt_insert.setString(14, (String)orderDetails.get("DURN_VALUE_ACT"));
						pstmt_insert.setString(15, (String)orderDetails.get("DURN_UNIT"));
					}
					else{
						pstmt_insert.setString(14, (String)orderDetails.get("DURN_VALUE"));
						pstmt_insert.setString(15, "H");
					}
				
					pstmt_insert.setString(16,amend_reason_code); //amend_reason_code Added for ML-BRU-SCF-0098 [IN031837]
					pstmt_insert.setString(17,amend_reason); //amend_reason Added for ML-BRU-SCF-0098 [IN031837]
					pstmt_insert.setString(18, (String)tabData.get("fluid_remarks")); //CHNGD_FLUID_REMARKS
					if(mfr_yn.equals("Y"))
						pstmt_insert.setString(19, ""); //ADMIN_RATE_DETAIL
					else
						pstmt_insert.setString(19, (String)tabData.get("Admin_rate")); //ADMIN_RATE_DETAIL
					
					pstmt_insert.setString(20, login_by_id);
					pstmt_insert.setString(21, login_at_ws_no);
					pstmt_insert.setString(22, login_facility_id);
					pstmt_insert.setString(23, fluidDetails.get("DOSAGE_TYPE").toString());
					pstmt_insert.setString(24, "");
					pstmt_insert.setString(25, "");
					pstmt_insert.setString(26, "");
					pstmt_insert.setString(27, (String)orderDetails.get("MFR_REMARKS"));
					pstmt_insert.setString(30, buildMAR_yn); //added for SRR20056-SCF-7882 -29157
					pstmt_insert.setString(31, login_by_id); // login_by_id Added for ML-BRU-SCF-0098 [IN031837]
					pstmt_insert.setString(32, ""); //Added for  ML-BRU-CRF-072[Inc:29938] DrugINDICATION for fluids
					pstmt_insert.setString(33, (String)orderDetails.get("SCH_INFUSION_RATE"));	//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_RATE
					pstmt_insert.setString(34, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));	//SKR-SCF-0543 [IN:033153] Added for Column PRES_QTY_UOM
					// Modified for IN:072715 start
					pstmt_insert.setString(35, "");
					pstmt_insert.setString(36, "");
					pstmt_insert.setString(37, "");
					System.out.println("6560abuse_override"+(String)orderDetails.get("abuse_override"));
					System.out.println("abuse_override_remarks"+(String)orderDetails.get("abuse_override_remarks"));
					
					pstmt_insert.setString(38, (String)orderDetails.get("abuse_override"));
					pstmt_insert.setString(39, (String)orderDetails.get("abuse_override_remarks"));
					
					pstmt_insert.setString(40, order_number);
					pstmt_insert.setString(41, "1");
					
					
                     // Modified for IN:072715 end
					//pstmt_insert.addBatch();
					pstmt_insert.addBatch();
				}
// OR_ORDER_LINE_PH FOR DRUGS
			
				if(result > 0){
					System.out.println("6577 OR_ORDER_LINE_PH SQL_PH_AMEND_IVPRES__UPDATE3");
					
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
					srlNo = 1;
					HashMap drugDetails = null;
					float ing_unit_qty		= 0.0f;
					float ing_order_qty		= 0.0f;
					String ing_order_uom	= "";
					float ing_unit_strength	= 0.0f;
					float ing_tot_strength	= 0.0f;
					String ing_strength_uom = "";
					String dosage_type		= "";
			
					for(int j=0;j<drugList.size();j++) {
						drugDetails = (HashMap)drugList.get(j);
						if (drugDetails.size() != 0) {
							pstmt_insert.setString(1, "");
							ing_unit_qty		= 0.0f;
							ing_order_qty		= 0.0f;
							ing_order_uom	= "";
							ing_unit_strength	= 0.0f;
							ing_tot_strength	= 0.0f;
							ing_strength_uom = "";
							dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
				  
							if(iv_pb.equals("Y")) {
								ing_unit_qty	= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
							} 
							else {
								ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
							}

							if (dosage_type.equals("S")) {
								if(iv_pb.equals("Y")) {
									ing_unit_qty	= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
								} 
								else {
									ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								}
								ing_order_uom	= (String)drugDetails.get("PRES_BASE_UOM");

								if (freq_nature.equals("I")) {
									ing_order_qty = ing_unit_qty*duration*(24/int_value);
								}
								else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									ing_order_qty = ing_unit_qty*rep_interval*duration;
								} 
								else if (freq_nature.equals("O")) {
									ing_order_qty = ing_unit_qty;
								}
								float flow_rate		= Float.parseFloat((orderDetails.get("SCH_INFUSION_RATE").toString()).equals("")?"0":orderDetails.get("SCH_INFUSION_RATE").toString());
								ing_unit_strength	= Float.parseFloat(drugDetails.get("STRENGTH_VALUE").toString());
								ing_tot_strength	= flow_rate*ing_unit_strength;
								ing_strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
							} 
							else if (dosage_type.equals("Q")) {
								if(iv_pb.equals("Y")) {
									ing_unit_qty	= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
								} 
								else {
									ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								}
								//ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

								String qty_unit		= (String)drugDetails.get("QTY_DESC_CODE");
								String equl_value	= "1";

								pstmt_select.setString(1, ing_order_uom);
								pstmt_select.setString(2, qty_unit);
								pstmt_select.setString(3, ing_order_uom);
								pstmt_select.setString(4, qty_unit);
								resultSet	= pstmt_select.executeQuery();

								if (resultSet.next()) {
									equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
								}
								closeResultSet( resultSet ); 

								float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);

								if (freq_nature.equals("I")) {
									ing_order_qty = in_tot_qty*duration;//*(24/int_value);
								}
								else if (freq_nature.equals("F") || freq_nature.equals("C")) {
									ing_order_qty = in_tot_qty*rep_interval*duration;
								} 
								else if (freq_nature.equals("O")) {
									ing_order_qty = in_tot_qty;
								}
							}

							if(((String)orderDetails.get("IVType")).equals("IVD")){
								pstmt_insert.setString(2, (String)drugDetails.get("QTY_VALUE"));
							}
							else{
								pstmt_insert.setString(2, ing_tot_strength+"");
							}
							pstmt_insert.setString(3, ing_strength_uom); 
							pstmt_insert.setString(4, (String)orderDetails.get("INFUSE_OVER"));
							pstmt_insert.setString(5, (String)orderDetails.get("INFUSE_OVER_UNIT"));
							pstmt_insert.setString(6, (String)orderDetails.get("SCH_INFUSION_RATE"));
							pstmt_insert.setString(7, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
							pstmt_insert.setString(8, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
							pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER")); //ORIG_INFUSE_OVER
							pstmt_insert.setString(29, (String)orderDetails.get("SCH_INFUSION_RATE")); //ORIG_INFUSION_RATE
						/*	if(((String)orderDetails.get("IVType")).equals("IVD")){
								pstmt_insert.setString(9, (Math.round(ing_unit_qty))+"");
							} 
							else {
								pstmt_insert.setString(9, ing_order_qty+"");
							}
*/
						   pstmt_insert.setString(9, (String)drugDetails.get("STOCK_ORDER_QTY"));

							if(((String)orderDetails.get("IVType")).equals("IVD")){						
								pstmt_insert.setString(10, (drugDetails.get("STRENGTH_VALUE").toString())+"");
							} 
							else {
								pstmt_insert.setString(10, ing_tot_strength+"");
							}
							pstmt_insert.setString(11, "N");
							if(((String)orderDetails.get("IVType")).equals("IVD")){
// FOR DECIMAL CRF				   pstmt_insert.setString(12, Math.round(ing_unit_qty)+""); 25857 
								float ord_qtyL = 0.0f;
								String durn_value = (String)orderDetails.get("DURN_VALUE");
							   if(strength_per_pres_uom!=null && !strength_per_pres_uom.equals("") && !strength_per_pres_uom.equals("0"))//Added if condition for PH_GP001  [IN:048274]
									ord_qtyL		=((ing_unit_qty*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value)*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
								//	ord_qty		=new Double(Math.ceil(ord_qty)).floatValue();
//CRF_SRR20056-CRF-0537.1  For handle the Decimals REMOVED Math.Ceil

								if(freq_nature.equals("F") || freq_nature.equals("I")) { // 7/3/11
									ord_qtyL	=	Float.parseFloat(ord_qtyL/ Integer.parseInt(interval_value)+"");
								}
//emergency area-620 & IN:025538 when modifing values were going wrong into pres_qty field. hence commented the below line and the whole calulation of ord_qtyL was done.
						//pstmt_insert.setString(12, ing_unit_qty * Float.parseFloat((String)orderDetails.get("DURN_VALUE"))/(Float.parseFloat((String)orderDetails.get("INFUSE_OVER")))+"");
								pstmt_insert.setString(12,ord_qtyL+"");
							} 
							else {
							   pstmt_insert.setString(12, ing_order_qty+"");
							}
						
							// Modified to BASE_UOM ...on 13/5/2004....
							if(((String)orderDetails.get("IVType")).equals("IVD")){
//									pstmt_insert.setString(13, (String)orderDetails.get("BASE_UOM"));
								pstmt_insert.setString(13, (String)drugDetails.get("PRES_BASE_UOM"));
							}
							else{
								pstmt_insert.setString(13, ing_order_uom);
							}
//if condition added for multi freq crf
							if(iv_pb.equals("Y")){
								pstmt_insert.setString(14, (String)orderDetails.get("DURN_VALUE_ACT"));
								pstmt_insert.setString(15, (String)orderDetails.get("DURN_UNIT"));
							}
							else{
								pstmt_insert.setString(14, (String)orderDetails.get("DURN_VALUE"));
								pstmt_insert.setString(15, "H");
							}
							pstmt_insert.setString(16, amend_reason_code);//amend_reason_code Added for ML-BRU-SCF-0098 [IN031837]
							pstmt_insert.setString(17, amend_reason);  //amend_reason for ML-BRU-SCF-0098 [IN031837]
							pstmt_insert.setString(18, (String)tabData.get("fluid_remarks")); //CHNGD_FLUID_REMARKS
							pstmt_insert.setString(19, (String)tabData.get("Admin_rate")); //ADMIN_RATE_DETAIL
							pstmt_insert.setString(20, login_by_id);
							pstmt_insert.setString(21, login_at_ws_no);
							pstmt_insert.setString(22, login_facility_id);
							pstmt_insert.setString(23, drugDetails.get("DOSAGE_TYPE").toString());
							pstmt_insert.setString(24, (String)drugDetails.get("CALC_DOSE_BASED_ON"));
							pstmt_insert.setString(25, (String)drugDetails.get("CALC_DOSE_VALUE"));
							pstmt_insert.setString(26, (String)drugDetails.get("CALC_DOSE_BY"));
							pstmt_insert.setString(27, (String)orderDetails.get("MFR_REMARKS"));
							pstmt_insert.setString(30, buildMAR_yn); //added for SRR20056-SCF-7882 -29157
							pstmt_insert.setString(31, login_by_id);//login_by_id added for ML-BRU-SCF-0098 [IN031837] 
							pstmt_insert.setString(32, (String)drugDetails.get("DRUG_INDICATION")); //added for SRR20056-SCF-7882 -29157
							pstmt_insert.setString(33, (String)orderDetails.get("SCH_INFUSION_RATE"));	//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_RATE
							pstmt_insert.setString(34, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));	//SKR-SCF-0543 [IN:033153] Added for Column PRES_QTY_UOM
							// Modified for IN:072715 start
							pstmt_insert.setString(35, (String)drugDetails.get("ALLERGY_REMARKS_CODE"));
							pstmt_insert.setString(36, (String)drugDetails.get("DOSE_REMARKS_CODE"));
							pstmt_insert.setString(37, (String)drugDetails.get("CURRENTRX_REMARKS_CODE"));
							System.out.println("6756abuse_exists"+(String)drugDetails.get("ABUSE_EXISTS"));
							System.out.println("6756abuse_exists"+(String)drugDetails.get("ABUSE_OVERRIDE"));
							System.out.println("6756abuse_exists"+drugDetails);
							
							System.out.println("abuse_override_remarks"+(String)drugDetails.get("abuse_override_remarks"));
							if((String)drugDetails.get("ABUSE_EXISTS") !=null  && (String)drugDetails.get("ABUSE_EXISTS") !=""){
								pstmt_insert.setString(38, (String)drugDetails.get("ABUSE_EXISTS"));	
							}
							else{
								pstmt_insert.setString(38, (String)drugDetails.get("ABUSE_OVERRIDE"));
							}
							if( (String)drugDetails.get("abuse_override_remarks") !=null && (String)drugDetails.get("abuse_override_remarks") !=""){
								pstmt_insert.setString(39, (String)drugDetails.get("abuse_override_remarks"));	
							}
							else{
								pstmt_insert.setString(39, (String)drugDetails.get("abuse_drug_override_reason"));
							}
							
							pstmt_insert.setString(40, order_number);
							if(flag.equals("N")){
								pstmt_insert.setString(41, (++srlNo)+"");	
							}
							else{
									pstmt_insert.setString(41, "1");	
							}
							
							
							// Modified for IN:072715 end
							pstmt_insert.addBatch();
						}
					}
				}
				int[] batch_result = pstmt_insert.executeBatch();
			
				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						System.err.println("IV ADDITIVES/INTERMITTENT(AMEND)--> ERROR IN OR_ORDER_LINE_PH UPDATION batch_result["+i+"]= "+batch_result[i]);
						System.err.println("tabData=== "+tabData);
						result = 0;
						break;
					}
					else {
						result = 1;
					}
				}
				closeStatement(pstmt_insert);
			}
			// INSERTING INTO OR_ORDER_LINE_PH_MFR - MODIFY MODE
			if(result>0 && mfr_yn.equals("Y")){
				pstmt_delete = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_MFR_DELETE"));
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));
				pstmt_delete.setString(1, order_number);
				//int del = pstmt_delete.executeUpdate(); unsed local variable 63877
				pstmt_delete.executeUpdate();//altered above statement for  unsed local variable 63877
				closeStatement(pstmt_delete);
				HashMap mfrRecs = (HashMap)orderDetails.get("MFR_Recs");
				String totRecs = (String)mfrRecs.get("totRec")==null?"0":(String)mfrRecs.get("totRec");
				ArrayList rec = new ArrayList();
				//int ins=0;
				for(int k=1; k<= Integer.parseInt(totRecs); k++){
					rec	= (ArrayList)mfrRecs.get("MFR"+k);

					pstmt_insert.setString(1, order_number); // ORDER_ID
					pstmt_insert.setString(2, "1"); //ORDER_LINE_NUM
					pstmt_insert.setString(3, k+""); //SL_NO
					pstmt_insert.setString(4, (String)rec.get(0)); //TOT_STRENGTH - volume
					pstmt_insert.setString(5, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //TOT_STRENGTH_UOM
					pstmt_insert.setString(6, (String)rec.get(5)); //INFUSE_OVER
					pstmt_insert.setString(7, (String)orderDetails.get("INFUSE_OVER_UNIT")); //INFUSE_OVER_UNIT
					pstmt_insert.setString(8, (String)rec.get(1)); //INFUSION_RATE
					pstmt_insert.setString(9, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //INFUSION_VOL_STR_UNIT
					pstmt_insert.setString(10, (String)rec.get(2)); //INFUSION_PER_UNIT
					pstmt_insert.setString(11,(String)rec.get(10) ); //GAP_DURATION_IN_HRS
					pstmt_insert.setString(12, (String)rec.get(11)); //ADMIN_RATE_DETAIL
					pstmt_insert.setString(13, (String)rec.get(6)); //START_DATE_TIME
					pstmt_insert.setString(14, (String)rec.get(7)); //END_DATE_TIME
					pstmt_insert.setString(15, login_by_id); //ADDED_BY_ID
					pstmt_insert.setString(16, login_at_ws_no); //ADDED_AT_WS_NO
					pstmt_insert.setString(17, login_facility_id); //ADDED_FACILITY_ID
					pstmt_insert.setString(18, login_by_id); //MODIFIED_BY_ID
					pstmt_insert.setString(19, login_at_ws_no); //MODIFIED_AT_WS_NO
					pstmt_insert.setString(20, login_facility_id); // MODIFIED_FACILITY_ID
					pstmt_insert.addBatch();
					//		ins = pstmt_insert.executeUpdate();
				}
				try{   
					int[] or_order_line_ph_mfr_result = pstmt_insert.executeBatch();
					for (int i=0;i<or_order_line_ph_mfr_result.length;i++) {
						if(or_order_line_ph_mfr_result[i] < 0  && or_order_line_ph_mfr_result[i] != -2 ) {
							System.err.println("IV ADDITIVES/INTERMITENT(AMEND) --> ERROR IN INSERTING TO OR_ORDER_LINE_PH_MFR-MODIFY MODE or_order_line_ph_mfr_result["+i+"]= "+or_order_line_ph_mfr_result[i]);
							System.err.println("tabData=== "+tabData);
							result = 0;
							break;
						} 
						else {
							result = 1;
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
					result	=	0;
				}
				closeStatement(pstmt_insert);
			}
			// PH_PATIENT_DRUG_PROFILE FLUID
			if (result>0) {
				System.out.println("6828 SQL_PH_AMEND_IVPRES__UPDATE4");
				int cnt			= 1;
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE4"));
				ArrayList frequencyValues	= new ArrayList();
				String currentrx_remarks = "";
				String allergy_remarks = "";
				String dose_remarks = "";
				String split_dose_preview	= "";
				String  pres_base_uom		="";
				String  qty_unit			="";
				String  equl_value			=null;
				String  qty_value1			="";
				String  fract_dose          =null;
				String  in_pres_qty_value	=null;
				interval_value		=null;
				repeat_value		=null;
				String  drug_code			= "";
				String  dosage_type="";
				String  durn_value					="";
				double  durn_value1                   =0.0f;
				float fld_tot_strength	= 0.0f;
				float fld_unit_strength	= 0.0f;
				String fld_strength_uom	= "";
				DecimalFormat dfTest = new DecimalFormat("0.##");
				if(flag.equals("N")){
					pstmt_insert.setString(cnt, start_date);//18
					pstmt_insert.setString(++cnt, end_date);//19
					pstmt_insert.setString(++cnt, "N");//20
					
					if(iv_pb.equals("Y")){
						HashMap drugDetails1=new HashMap();
						drugDetails1 = (HashMap)drugList.get(0);
					
						if (scheduleFreq.size()>0) {
						   if (scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
								frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
								allergy_remarks = (String)drugDetails1.get("ALLERGY_REMARKS")==null?"":(String)drugDetails1.get("ALLERGY_REMARKS");
								dose_remarks = (String)drugDetails1.get("DOSE_REMARKS")==null?"":(String)drugDetails1.get("DOSE_REMARKS");
								currentrx_remarks = (String)drugDetails1.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails1.get("CURRENTRX_REMARKS");

								if(currentrx_remarks.equals("")){
									currentrx_remarks = (String)drugDetails1.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")==null?"":(String)drugDetails1.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
								}
								if(allergy_remarks.equals("")){
									allergy_remarks = (String)drugDetails1.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":(String)drugDetails1.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
								}
						}
					}
					statement = connection.createStatement();
					resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+login_facility_id+"','"+(String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")+"') UOM_DISPLAY from dual");
					uomDisplay = "";
					if(resultSet!=null && resultSet.next()){
						uomDisplay = resultSet.getString("UOM_DISPLAY");
					}
					else{
						uomDisplay = (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
					}
					closeResultSet( resultSet );
					closeStatement(statement);
					if (frequencyValues.size()>0) {
						// the below if part to get split_dose_preview for ivpb was done for multi freq crf
						if(!iv_pb.equals("Y")){
							for (int n=0; n<frequencyValues.size(); n++) {
								HashMap data		= (HashMap)frequencyValues.get(n);
								split_dose_preview	= split_dose_preview + (String)data.get("admin_time");
								split_dose_preview	= split_dose_preview +  " = ";
								split_dose_preview	= split_dose_preview + (String)data.get("admin_qty");
								split_dose_preview	= split_dose_preview + " ";
	//							split_dose_preview	= split_dose_preview + (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
								split_dose_preview	= split_dose_preview + uomDisplay;
								split_dose_preview	= split_dose_preview + " | ";
							}
						}
						else{
							if(!freq_nature.equals("I")){
								freq_char_list	= (HashMap)frequencyValues.get(0);
								day_list		= (ArrayList)frequencyValues.get(1);
								day_names		= (ArrayList)frequencyValues.get(2);
								time_list		= (ArrayList)frequencyValues.get(3);
								dose_list		= (ArrayList)frequencyValues.get(4);

								for(int frStr = 0;frStr<day_list.size();frStr++){
									if(!freq_char_list.get("durationType").equals("D")){
										split_dose_preview = split_dose_preview + "Day "+day_list.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
										split_dose_preview = split_dose_preview + day_names.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
									}
									split_dose_preview = split_dose_preview + time_list.get(frStr);
									split_dose_preview = split_dose_preview + " - ";
									split_dose_preview = split_dose_preview + dose_list.get(frStr);
									split_dose_preview = split_dose_preview + " "+uomDisplay;
									split_dose_preview = split_dose_preview + "; ";
								}
							}
						}   
					}

					if (split_dose_preview.length()>2499) {
						split_dose_preview = split_dose_preview.substring(0, 2499);
					}
					else {
						split_dose_preview = split_dose_preview;
					}

					pstmt_insert.setString(++cnt, split_dose_preview);//25
					pstmt_insert.setString(++cnt, freq_code);//26
					
					if (freq_nature.equals("F") || freq_nature.equals("C")) {
					/*	if(iv_pb.equals("Y")){
							 pstmt_insert.setString(++cnt, "D");
						} 
						else {
							 pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_UNIT"));
						}*/
						 pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_UNIT"));
					} 
					else if (freq_nature.equals("I")) {
						pstmt_insert.setString(++cnt, "H");
					}
					else {
						pstmt_insert.setString(++cnt, (String)orderDetails.get("DURN_UNIT"));
					}//durn_typeduration

					if(iv_pb.equals("Y")){
						pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_VALUE_ACT"));
					}else{
						if( ((String)orderDetails.get("IVType")).equals("IVD") ){
							if(iv_pb.equals("Y")){
							   pstmt_insert.setFloat(++cnt, duration);//27
							}
							else{
							   pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_VALUE"));

							}
						}
						else{ 
							pstmt_insert.setString(++cnt, durn_val_for_freq+"");
						}//duration
					}
					fld_unit_qty 			=  Float.parseFloat(orderDetails.get("FLUID_UNIT_QTY").toString());
					fluid_ord_qty	= "";
//					pack_size			= Integer.parseInt((String)orderDetails.get("PACK_SIZE")); 
					pack_size			= Float.parseFloat((String)orderDetails.get("PACK_SIZE")); //changed Integer to float for Incident no:33048
					durn_val_for_freq	= 0.0f;

					if (freq_nature.equals("I")) {
						if(license!=null && !license.equals("PHBASIC"))
							fluid_ord_qty = ((fld_unit_qty*duration)/pack_size)+"";
						else 
							fluid_ord_qty = ((fld_unit_qty*duration*(24/int_value)))+"";

						if(( or_mode.equals("or_amend") && freq_changed_yn!=null && freq_changed_yn.equals("Y") )||  !or_mode.equals("or_amend"))
							durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"))*int_value;
						else
							durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"));


					} 
					else if (freq_nature.equals("F") || freq_nature.equals("C")) {
						if(license!=null && !license.equals("PHBASIC"))
							fluid_ord_qty = ((fld_unit_qty*rep_interval*duration)/pack_size)+"";
						else
							fluid_ord_qty = ((fld_unit_qty*rep_interval*duration))+"";

						durn_val_for_freq = Float.parseFloat((String)orderDetails.get("DURN_VALUE"));
					} 
					else if (freq_nature.equals("O")) {
						if(license!=null && !license.equals("PHBASIC")) 
							fluid_ord_qty = ((fld_unit_qty)/pack_size)+"";
						else 
							fluid_ord_qty = ((fld_unit_qty))+"";

						durn_val_for_freq = Float.parseFloat((String)orderDetails.get("SCH_INFUSION_PERIOD"));
					}

					pres_base_uom					=(String)fluidDetails.get("PRES_BASE_UOM");
					qty_unit						=(String)fluidDetails.get("PRES_QTY_UOM");
					equl_value					=null;
					qty_value1					="";
					fract_dose            		=null;
					content_in_pres_base_uom		=null;
					strength_per_pres_uom			=null;
					strength_per_value_pres_uom	=null;
					in_pres_qty_value				=null;
					freq_code						=(String)orderDetails.get("FREQ_CODE");
					interval_value				=null;
					repeat_value					=null;
					drug_code						= (String)fluidDetails.get("DRUG_CODE");
					dosage_type="";
					if(iv_pb.equals("Y")) {
						dosage_type					="Q";
						qty_value1=(String)orderDetails.get("vehicle_volume");
					}
					else{
					  dosage_type					="Q";
					  qty_value1=(String)orderDetails.get("vehicle_volume");
					  freq_nature="C";

					}
					durn_value					=(String)orderDetails.get("DURN_VALUE");
					durn_value1                   =0.0f;

					if(iv_pb.equals("Y")) {        
/* for multi freq crf.
						durn_value1                   = Math.ceil(Double.parseDouble(durn_value)/24);
						durn_value			        =String.valueOf(durn_value1);*/
					}
					else{
					  durn_value                   = String.valueOf(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"");
					}

					pstmt_select2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT2"));
					pstmt_select2.setString(1, drug_code);
					resultSet		= pstmt_select2.executeQuery();

					if(resultSet.next()) {
						fract_dose = resultSet.getString("fract_dose_round_up_yn");
						content_in_pres_base_uom = resultSet.getString("content_in_pres_base_uom");
						strength_per_pres_uom = resultSet.getString("strength_per_pres_uom");
						strength_per_value_pres_uom = resultSet.getString("strength_per_value_pres_uom");
					}
					closeResultSet( resultSet );
					closeStatement(pstmt_select2); 
					pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));
					pstmt_select3.setString(1, freq_code);
					resultSet		= pstmt_select3.executeQuery();
					if(resultSet.next()) {
						interval_value = resultSet.getString("interval_value");
						repeat_value   = resultSet.getString("repeat_value");
					}
					closeResultSet( resultSet ); 
					closeStatement(pstmt_select3); 
					if(interval_value == null) 
						interval_value="1";
					if(repeat_value == null || freq_nature.equals("C")) 
						repeat_value="1";

					 if(dosage_type!=null && dosage_type.equals("Q")){
						
						pstmt_select				= 
						connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
						equl_value	=	"1";
						
						pstmt_select.setString(1,pres_base_uom);
						pstmt_select.setString(2,qty_unit);
						pstmt_select.setString(3,pres_base_uom);
						pstmt_select.setString(4,qty_unit);
						resultSet	= pstmt_select.executeQuery();
						if ( resultSet != null && resultSet.next() ) {
							equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}
						closeResultSet( resultSet );
						closeStatement(pstmt_select);
						float ord_qty=0.0f;			   
						if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
							ord_qty		=	(Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));
							if(ord_qty==0)
								ord_qty	=	1;
						}
						if(freq_nature.equals("F") || freq_nature.equals("I")) {
//							ord_qty	=	Float.parseFloat((ord_qty/ Integer.parseInt(interval_value))+"");

							if(Float.parseFloat(interval_value) > Float.parseFloat(durn_value)){
								ord_qty	=	Float.parseFloat(ord_qty/ Float.parseFloat(durn_value)+"");
							}else{
								ord_qty	=	Float.parseFloat(ord_qty/ Integer.parseInt(interval_value)+"");
							}
						}
					   in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));
					}
					else if(dosage_type!=null && dosage_type.equals("S")){
				
						float ord_qty	=0.0f;
						if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	
							if(!fract_dose.equals("Y")) {	
								ord_qty		=((Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value)*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
								ord_qty		=new Double(Math.ceil(ord_qty)).floatValue();
							} 
							else {
								double unit_qty	=   Math.ceil(Double.parseDouble(qty_value1)/Double.parseDouble(strength_per_pres_uom)) * (Double.parseDouble(strength_per_value_pres_uom));		
								ord_qty			=  (new Double(unit_qty).floatValue() * Float.parseFloat(durn_value) * Integer.parseInt(repeat_value) );
							}
							if(freq_nature.equals("F") || freq_nature.equals("I")) {
			//					ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+""); 25538


								if(Float.parseFloat(interval_value) > Float.parseFloat(durn_value)){
									ord_qty	=	Float.parseFloat(ord_qty/ Float.parseFloat(durn_value)+"");
								}else{
									ord_qty	=	Float.parseFloat(ord_qty/ Integer.parseInt(interval_value)+"");
								}
							}
						}
						in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));
					}
					in_pres_qty_value = dfTest.format(Float.parseFloat(in_pres_qty_value));
					if( ((String)orderDetails.get("IVType")).equals("IVD") ){
						pstmt_insert.setString(++cnt, in_pres_qty_value);
					}
					else{
						pstmt_insert.setString(++cnt, fluid_ord_qty);
					}
				//prescribed_qty

					pstmt_insert.setString(++cnt, (String)orderDetails.get("IV_PRESC"));//30
					pstmt_insert.setString(++cnt, (String)orderDetails.get("INFUSE_OVER"));//31
					pstmt_insert.setString(++cnt, (String)orderDetails.get("INFUSE_OVER_UNIT"));//32
					pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_RATE"));//33
					pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));//34
					if( ((String)orderDetails.get("IVType")).equals("IVD") ){
						pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));//35
					}
					else{
						pstmt_insert.setString(++cnt, "M");  // infusion per unit
					}
					
					pstmt_insert.setString(++cnt, "Y"); // amend_yn//36
					pstmt_insert.setString(++cnt,pract_id); // amend by id//37 //login_by_id changed to pract_id for  ML-BRU-SCF-0318
					pstmt_insert.setString(++cnt, ""); // total_issued_qty//38
					pstmt_insert.setString(++cnt, login_by_id);
					pstmt_insert.setString(++cnt, login_at_ws_no);
					pstmt_insert.setString(++cnt, login_facility_id);
					fld_tot_strength	= 0.0f;
					fld_unit_strength	= 0.0f;
					fld_strength_uom	= "";

					if (fluidDetails.get("DOSAGE_TYPE").toString().equals("S")) {
						float flow_rate		= Float.parseFloat((orderDetails.get("SCH_INFUSION_RATE").toString()).equals("")?"0":orderDetails.get("SCH_INFUSION_RATE").toString());
						fld_unit_strength	= Float.parseFloat(fluidDetails.get("STRENGTH_VALUE").toString());
						fld_tot_strength	= flow_rate*fld_unit_strength;
						fld_strength_uom	= (String)fluidDetails.get("STRENGTH_UOM");
					}

					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(++cnt, (String)orderDetails.get("FLUID_UNIT_QTY"));
					}
					else{
						pstmt_insert.setString(++cnt, fld_tot_strength+"");
					}
					if(((String)orderDetails.get("IVType")).equals("IVD")){
						pstmt_insert.setString(++cnt, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
					}
					else{
						pstmt_insert.setString(++cnt, fld_strength_uom);
					}

					pstmt_insert.setString(++cnt, (String)orderDetails.get("FLUID_UNIT_QTY"));
					pstmt_insert.setString(++cnt, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));

					if(iv_pb.equals("Y")) {
						pstmt_insert.setString(++cnt,"Q");
					} 
					else {
						pstmt_insert.setString(++cnt, (String)fluidDetails.get("DOSAGE_TYPE"));
					}
					pstmt_insert.setString(++cnt, (String)fluidDetails.get("DRUG_CODE"));
					generic_id=(String)fluidDetails.get("GENERIC_ID");
					pstmt_insert.setString(++cnt, (String)fluidDetails.get("GENERIC_ID"));

					pstmt_insert.setString(++cnt, (String)orderDetails.get("IV_INGREDIANTS"));
					pstmt_insert.setString(++cnt, allergy_remarks); //ALLERGY_OVERRIDE_REASON
					pstmt_insert.setString(++cnt, dose_remarks);//DOSAGE_LIMIT_OVERRIDE_REASON 
					pstmt_insert.setString(++cnt, currentrx_remarks); //DUPLICATE_DRUG_OVERRIDE_REASON
					pstmt_insert.setString(++cnt, "");//INTERACTION_OVERRIDE_REASON
					pstmt_insert.setString(++cnt, "");//CONTRAIND_OVERRIDE_REASON
					pstmt_insert.setString(++cnt, patient_id); //patient_id
					pstmt_insert.setString(++cnt, (String)orderDetails.get("abuse_override"));
					pstmt_insert.setString(++cnt, (String)orderDetails.get("abuse_override_remarks"));

					pstmt_insert.setString(++cnt, order_number);//ORG_ORDER_ID
					pstmt_insert.setString(++cnt, "1");//ORG_ORDER_LINE_NUM
					pstmt_insert.executeUpdate();
			
					closeStatement(pstmt_insert);
				}
				// PH_PATIENT_DRUG_PROFILE INGREDIENTS

				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE4"));
				HashMap drugDetails = null;
				pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
				pstmt_select2		= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT2"));
				pstmt_select3		= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));
				srlNo = 1;
				
				for(int j=1;j<=drugList.size();j++) {
					System.out.println("7211 SQL_PH_AMEND_IVPRES__UPDATE4");
					cnt = 1;
					drugDetails = (HashMap)drugList.get(j-1);
					
					if(j == 1){
						statement = connection.createStatement();
						if(!flag.equals("N")){ // if ready to use iv then use the drug's dosage uom 
							resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+login_facility_id+"','"+(String) drugDetails.get("QTY_UOM")+"') UOM_DISPLAY from dual");
						}
						else{
							resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+login_facility_id+"','"+(String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")+"') UOM_DISPLAY from dual");
						}
						uomDisplay = "";
						if(resultSet!=null && resultSet.next()){
							uomDisplay = resultSet.getString("UOM_DISPLAY");
						}
						else{
							uomDisplay = (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
						}
						closeResultSet( resultSet );
						closeStatement(statement);
					}

					pstmt_insert.setString(cnt, start_date);//1
					pstmt_insert.setString(++cnt, end_date);//2
					pstmt_insert.setString(++cnt, "N");//3
					//split_dose_preview
					frequencyValues	= new ArrayList();
					split_dose_preview	= "";
					if (scheduleFreq.size()>0) {
						if (scheduleFreq.containsKey((String)drugDetails.get("DRUG_CODE")))
							frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails.get("DRUG_CODE"));
					}

					if (frequencyValues.size()>0) {
						// the below if part to get split_dose_preview for ivpb was done for multi freq crf
						if(!iv_pb.equals("Y")){
							for (int n=0; n<frequencyValues.size(); n++) {
								HashMap data		= (HashMap)frequencyValues.get(n);
								split_dose_preview	= split_dose_preview + (String)data.get("admin_time");
								split_dose_preview	= split_dose_preview +  " = ";
								split_dose_preview	= split_dose_preview + (String)data.get("admin_qty");
								split_dose_preview	= split_dose_preview + " ";
								split_dose_preview	= split_dose_preview + (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
								split_dose_preview	= split_dose_preview + " | ";
							}
						}
						else{
							if(!freq_nature.equals("I")){
								freq_char_list	= (HashMap)frequencyValues.get(0);
								day_list		= (ArrayList)frequencyValues.get(1);
								day_names		= (ArrayList)frequencyValues.get(2);
								time_list		= (ArrayList)frequencyValues.get(3);
								dose_list		= (ArrayList)frequencyValues.get(4);
								for(int frStr = 0;frStr<day_list.size();frStr++){
									if(!freq_char_list.get("durationType").equals("D")){
										split_dose_preview = split_dose_preview + "Day "+day_list.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
										split_dose_preview = split_dose_preview + day_names.get(frStr);
										split_dose_preview = split_dose_preview + " - ";
									}
									split_dose_preview = split_dose_preview + time_list.get(frStr);
									split_dose_preview = split_dose_preview + " - ";
									split_dose_preview = split_dose_preview + dose_list.get(frStr);
									//split_dose_preview = split_dose_preview + " "+(String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
									split_dose_preview = split_dose_preview + " "+uomDisplay;
									split_dose_preview = split_dose_preview + "; ";
								}
							}
						}   
					}

					if (split_dose_preview.length()>2499) {
						split_dose_preview = split_dose_preview.substring(0, 2499);
					}
					else {
						split_dose_preview = split_dose_preview;
					}

					pstmt_insert.setString(++cnt, split_dose_preview);//4
					pstmt_insert.setString(++cnt, freq_code);//5

					float ing_unit_qty		= 0.0f;
					float ing_order_qty		= 0.0f;
					String ing_order_uom	= "";

					strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
					strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
					content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
					stock_uom					=	(String)drugDetails.get("STOCK_UOM");

					qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");

					if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
					content_in_pres_base_uom =	"1";

					ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
					ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

					if (((String)drugDetails.get("DOSAGE_TYPE")).equals("S")) {
						ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
						float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
						ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");

						if (freq_nature.equals("I")) {
							ing_order_qty = in_tot_qty*duration*(24/int_value);
							ing_order_qty = in_tot_qty*duration/int_value;
						} 
						else if (freq_nature.equals("F") || freq_nature.equals("C")) {
							ing_order_qty = in_tot_qty*rep_interval*duration;
						} 
						else if (freq_nature.equals("O")) {
							ing_order_qty = in_tot_qty;
						}

						if( ((String)orderDetails.get("IVType")).equals("IVD") ){
							ing_order_qty	=   new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						}else{
							ing_order_qty	=   new Double(Math.ceil((ing_order_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						}
					}	
					else  {							
						 equl_value	= "1";

						pstmt_select.setString(1, ing_order_uom);
						pstmt_select.setString(2, qty_unit);
						pstmt_select.setString(3, ing_order_uom);
						pstmt_select.setString(4, qty_unit);

						resultSet	= pstmt_select.executeQuery();

						if (resultSet.next()) {
							equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}
						  
						closeResultSet( resultSet );
						float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
						if (freq_nature.equals("I")) {
							ing_order_qty = in_tot_qty*duration*(24/int_value);
							ing_order_qty = in_tot_qty*duration/int_value;
						}
						else if (freq_nature.equals("F") || freq_nature.equals("C")) {
							ing_order_qty = in_tot_qty*rep_interval*duration;
						}
						else if (freq_nature.equals("O")) {
							ing_order_qty = in_tot_qty;
						}
						//if IVD
						if( ((String)orderDetails.get("IVType")).equals("IVD") ){
							ing_order_qty	=   new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();

						}
						else{
							ing_order_qty	=   new Double(Math.ceil((ing_order_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();

						}
					}

					if (freq_nature.equals("F") || freq_nature.equals("C")) {
						if(iv_pb.equals("Y")){
							pstmt_insert.setString(++cnt, "D");//27
						}
						else{
							pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_UNIT"));
						}
					} 
					else if (freq_nature.equals("I")) {
						pstmt_insert.setString(++cnt, "H");
					} 
					else {
						pstmt_insert.setString(++cnt, (String)orderDetails.get("DURN_UNIT"));//6
					}
					if(iv_pb.equals("Y")){
						pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_VALUE_ACT"));
					}else{
						if( ((String)orderDetails.get("IVType")).equals("IVD") ){
							if(iv_pb.equals("Y")){
								pstmt_insert.setFloat(++cnt, duration);//27
							}else{
								pstmt_insert.setString(++cnt,(String)orderDetails.get("DURN_VALUE"));
							}
						}
						else{
							pstmt_insert.setString(++cnt, durn_val_for_freq+""); //infusion//7
						}
					}
					pres_base_uom	=(String)drugDetails.get("PRES_BASE_UOM");
					if(iv_pb.equals("Y")){  
						qty_unit	=(String)drugDetails.get("PRES_QTY_UOM");
					}
					else{
						qty_unit=(String)drugDetails.get("QTY_DESC_CODE");
					}
					equl_value						=null;
					if(iv_pb.equals("Y")){   
						qty_value1 = (String)orderDetails.get("QTY_VALUE");	
					}
					else{
						qty_value1 = (String)drugDetails.get("QTY_VALUE");
						freq_nature="C";
					}
					fract_dose            			=null;
					content_in_pres_base_uom		=null;
					strength_per_pres_uom			=null;
					strength_per_value_pres_uom		=null;
					in_pres_qty_value				=null;
					freq_code						=(String)orderDetails.get("FREQ_CODE");
					interval_value					=null;
					repeat_value					=null;
					drug_code						=(String)drugDetails.get("DRUG_CODE");
					dosage_type						=(String)drugDetails.get("DOSAGE_TYPE");
					if(dosage_type.equals("A")) dosage_type="Q";
						durn_value						=(String)orderDetails.get("DURN_VALUE");
					durn_value1                     =0.0f;
				
					if(iv_pb.equals("Y")){        
					/*	durn_value1                   = Math.ceil(Double.parseDouble(durn_value)/24);
						durn_value			        =String.valueOf(durn_value1);*/
					}
					else{
						durn_value                   = String.valueOf(Math.ceil(((duration / Float.parseFloat(infuse_over))*100)/100)+"");
					}
					pstmt_select2.setString(1, drug_code);
					resultSet		= pstmt_select2.executeQuery();
					if(resultSet.next()) {
						fract_dose = resultSet.getString("fract_dose_round_up_yn");
						content_in_pres_base_uom = resultSet.getString("content_in_pres_base_uom");
						strength_per_pres_uom = resultSet.getString("strength_per_pres_uom");
						strength_per_value_pres_uom = resultSet.getString("strength_per_value_pres_uom");
					}
					closeResultSet( resultSet );
					   
					pstmt_select3.setString(1, freq_code);
					resultSet		= pstmt_select3.executeQuery();
					if(resultSet.next()) {
						interval_value = resultSet.getString("interval_value");
						repeat_value   = resultSet.getString("repeat_value");
					}
					closeResultSet( resultSet );
					if(interval_value == null) 
						interval_value="1";
					if(repeat_value == null || freq_nature.equals("C")) 
						repeat_value="1";

					if(dosage_type!=null && dosage_type.equals("Q")){
						equl_value	  =	"1";
						pstmt_select.setString(1,pres_base_uom);
						pstmt_select.setString(2,qty_unit);
						pstmt_select.setString(3,pres_base_uom);
						pstmt_select.setString(4,qty_unit);
						resultSet	= pstmt_select.executeQuery();
						if ( resultSet != null && resultSet.next() ) {
							equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}
				
						closeResultSet( resultSet );
						float ord_qty=0.0f;			   

						if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
							ord_qty		=	(Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));
							if(ord_qty==0)
								ord_qty	=	1;
						}

						if(freq_nature.equals("F") || freq_nature.equals("I")) {
						//	ord_qty	=	Float.parseFloat((ord_qty/ Integer.parseInt(interval_value))+"");// .ceil was removed for 14703
							if(Float.parseFloat(interval_value) > Float.parseFloat(durn_value)){
								ord_qty	=	Float.parseFloat(ord_qty/ Float.parseFloat(durn_value)+"");
							}
							else{
								ord_qty	=	Float.parseFloat(ord_qty/ Integer.parseInt(interval_value)+"");
							}
						}
						in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));// .ceil was removed for 14703
					}
					else if(dosage_type!=null && dosage_type.equals("S")){
						float ord_qty	=0.0f;
						if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){	
							ord_qty		=((Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value)*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)));
							ord_qty		=new Double(Math.ceil(ord_qty)).floatValue();
							if(freq_nature.equals("I")) {
//										ord_qty	=	Float.parseFloat(Math.ceil(ord_qty/ Integer.parseInt(interval_value))+""); 25538
								if(Float.parseFloat(interval_value) > Float.parseFloat(durn_value)){
									ord_qty	=	Float.parseFloat(ord_qty/ Float.parseFloat(durn_value)+"");
								}
								else{
									ord_qty	=	Float.parseFloat(ord_qty/ Integer.parseInt(interval_value)+"");
								}
							}
						}
						in_pres_qty_value=String.valueOf(Double.parseDouble(String.valueOf(ord_qty)));// .ceil was removed for 14703
						in_pres_qty_value = dfTest.format(Float.parseFloat(in_pres_qty_value));
					}

				/*	if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){
							pstmt_insert.setString(++cnt, in_pres_qty_value+"");
					}
					else{*/
							pstmt_insert.setString(++cnt, in_pres_qty_value+"");
				/*	}*/

					pstmt_insert.setString(++cnt, (String)orderDetails.get("IV_PRESC"));//9
					pstmt_insert.setString(++cnt, (String)orderDetails.get("INFUSE_OVER"));//10
					pstmt_insert.setString(++cnt, (String)orderDetails.get("INFUSE_OVER_UNIT"));//11
					pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_RATE"));//12
					pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));//13
					if( ((String)orderDetails.get("IVType")).equals("IVD") ){
						pstmt_insert.setString(++cnt, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
					}
					else{
						pstmt_insert.setString(++cnt, "M");//14
					}
					pstmt_insert.setString(++cnt, "Y");//15
					pstmt_insert.setString(++cnt,pract_id );//16 //login_by_id changed to pract_id for  ML-BRU-SCF-0318
					pstmt_insert.setString(++cnt, "");//17

					pstmt_insert.setString(++cnt, login_by_id);//18
					pstmt_insert.setString(++cnt, login_at_ws_no);//19
					pstmt_insert.setString(++cnt, login_facility_id);//20
					fld_tot_strength	= 0.0f;
					fld_unit_strength	= 0.0f;
					fld_strength_uom	= "";

					if (drugDetails.get("DOSAGE_TYPE").toString().equals("S")) {
						float flow_rate		= Float.parseFloat((orderDetails.get("SCH_INFUSION_RATE").toString()).equals("")?"0":orderDetails.get("SCH_INFUSION_RATE").toString());
						fld_unit_strength	= Float.parseFloat(drugDetails.get("STRENGTH_VALUE").toString());
						fld_tot_strength	= flow_rate*fld_unit_strength;
						fld_strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
					}

					if( ((String)orderDetails.get("IVType")).equals("IVD") ){
						pstmt_insert.setString(++cnt, fld_unit_strength+"");
					}
					else{
						pstmt_insert.setString(++cnt, fld_tot_strength+"");
					}
					pstmt_insert.setString(++cnt, fld_strength_uom);

					ing_unit_qty		= 0.0f;
					ing_order_qty		= 0.0f;
					ing_order_uom	= "";

					strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
					strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
					content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
					stock_uom					=	(String)drugDetails.get("STOCK_UOM");

					qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");

					if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
					content_in_pres_base_uom =	"1";

					ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
					ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

					if (((String)drugDetails.get("DOSAGE_TYPE")).equals("S")) {
						ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
						float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
						ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");

						if (freq_nature.equals("I")) {
							ing_order_qty = in_tot_qty*duration*(24/int_value);
						}
						else if (freq_nature.equals("F") || freq_nature.equals("C")) {
							ing_order_qty = in_tot_qty*rep_interval*duration;
						}
						else if (freq_nature.equals("O")) {
							ing_order_qty = in_tot_qty;
						}

						if( ((String)orderDetails.get("IVType")).equals("IVD") ){
							ing_order_qty	=   new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						}
						else{
							ing_order_qty	=   new Double(Math.ceil((ing_order_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						}
					}	
					else  {							
						 equl_value	= "1";

						pstmt_select.setString(1, ing_order_uom);
						pstmt_select.setString(2, qty_unit);
						pstmt_select.setString(3, ing_order_uom);
						pstmt_select.setString(4, qty_unit);
						resultSet	= pstmt_select.executeQuery();

						if (resultSet.next()) {
							equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
						}

						closeResultSet( resultSet );

						float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
						if (freq_nature.equals("I")) {
//									ing_order_qty = in_tot_qty*duration*(24/int_value);
							ing_order_qty = in_tot_qty*duration/int_value;
						}
						else if (freq_nature.equals("F") || freq_nature.equals("C")) {
							ing_order_qty = in_tot_qty*rep_interval*duration;
						}
						else if (freq_nature.equals("O")) {
							ing_order_qty = in_tot_qty;
						}
						//if IVD
						if( ((String)orderDetails.get("IVType")).equals("IVD") ){
							ing_order_qty	=   new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						}else{
							ing_order_qty	=   new Double(Math.ceil((ing_order_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
						}
						/*if(!iv_pb.equals("Y")) {
							ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
						}			*/
					}

					if(iv_pb.equals("Y")) {
						pstmt_insert.setString(++cnt,(String) orderDetails.get("QTY_VALUE")+""); 
						pstmt_insert.setString(++cnt,(String) drugDetails.get("QTY_UOM")+"");
					}
					else {
						pstmt_insert.setString(++cnt, ing_unit_qty+"");
						pstmt_insert.setString(++cnt, ing_order_uom);
					}
					
					pstmt_insert.setString(++cnt, (String)drugDetails.get("DOSAGE_TYPE"));
					pstmt_insert.setString(++cnt, (String)drugDetails.get("DRUG_CODE"));
					if((String)drugDetails.get("GENERIC_ID") != null){
						generic_id=(String)drugDetails.get("GENERIC_ID");
					}
					
					pstmt_insert.setString(++cnt, generic_id);
					pstmt_insert.setString(++cnt, (String)orderDetails.get("IV_INGREDIANTS"));
					
					if(drugDetails.get("ALLERGY_REMARKS")!=null && !((String)drugDetails.get("ALLERGY_REMARKS")).equals(""))
						pstmt_insert.setString(++cnt, (String)drugDetails.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON 
					else if((String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")!=null)
						pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")); 
					else
						pstmt_insert.setString(++cnt, "");
					//existing issue committed aginest to 71370 start 
					if(drugDetails.get("DOSE_REMARKS")!=null && !((String)drugDetails.get("DOSE_REMARKS")).equals(""))
						pstmt_insert.setString(++cnt, (String)drugDetails.get("DOSE_REMARKS")); //ALLERGY_OVERRIDE_REASON 
					else if((String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")!=null)
						pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")); 
					else
						pstmt_insert.setString(++cnt, "");
					//pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));//DOSAGE_LIMIT_OVERRIDE_REASON 
					//existing issue committed aginest to 71370 end
					if(drugDetails.get("CURRENTRX_REMARKS")!=null && !((String)drugDetails.get("CURRENTRX_REMARKS")).equals(""))
						pstmt_insert.setString(++cnt, (String)drugDetails.get("CURRENTRX_REMARKS")); // //DUPLICATE_DRUG_OVERRIDE_REASON 
					else if((String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")!=null)
						pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
					else
						pstmt_insert.setString(++cnt, "");

					pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON"));//INTERACTION_OVERRIDE_REASON
					pstmt_insert.setString(++cnt, (String)drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON"));//CONTRAIND_OVERRIDE_REASON

					
					pstmt_insert.setString(++cnt, (String)drugDetails.get("abuse_override"));
					pstmt_insert.setString(++cnt, (String)drugDetails.get("abuse_override_remarks"));
					pstmt_insert.setString(++cnt, patient_id);	// PATIENT_ID
					pstmt_insert.setString(++cnt, order_number);//ORG_ORDER_ID
					if(flag.equals("Y")){
						pstmt_insert.setString(++cnt, 1+"");
					}
					else{
						pstmt_insert.setString(++cnt, (++srlNo)+"");//ORG_ORDER_LINE_NUM
					}
					pstmt_insert.addBatch();
				} 
				closeStatement(pstmt_select);
				closeStatement(pstmt_select3);
				closeStatement(pstmt_select2);
				try{   
					int[] patient_drug_profile_result = pstmt_insert.executeBatch();

					for (int i=0;i<patient_drug_profile_result.length;i++) {
						if(patient_drug_profile_result[i] < 0  && patient_drug_profile_result[i] != -2 ) {
							System.err.println("IV ADDITIVES/INTERMITENT(AMEND) --> ERROR IN PH_PATIENT_DRUG_PROFILE UPDATION patient_drug_profile_result["+i+"]= "+patient_drug_profile_result[i]);
							System.err.println("tabData=== "+tabData);
							result = 0;
							break;
						} 
						else {
							result = 1;
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
					result	=	0;
				}

				try{
					closeStatement(pstmt_insert);
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
			}

			if (result>0) {
				String action_seq_num		= "";
				pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_select.setString(1, order_number);
				resultSet		= pstmt_select.executeQuery();

				if(resultSet.next()) {
					action_seq_num = resultSet.getString(1);
				}
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
//OR_ORDER_COMMENT
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_insert.setString(1, order_number);
				pstmt_insert.setString(2, action_seq_num);
				pstmt_insert.setString(3, login_by_id);
				pstmt_insert.setString(4, login_at_ws_no);
				pstmt_insert.setString(5, login_facility_id);
				pstmt_insert.setString(6, login_by_id);
				pstmt_insert.setString(7, login_at_ws_no);
				pstmt_insert.setString(8, login_facility_id);
				result = pstmt_insert.executeUpdate();

				pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
				pstmt_clob.setString(1,order_number);
				pstmt_clob.setString(2,action_seq_num);

				ResultSet rset_clob =pstmt_clob.executeQuery();
				if(rset_clob!=null){
					while(rset_clob.next()){
						Clob clb 			= (Clob) rset_clob.getClob(1);
						BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
						bw.write(order_comment,0,order_comment.length());
						bw.flush();
						bw.close();
					}
				}					
				closeResultSet( rset_clob ); 
				closeStatement(pstmt_clob); 
				closeStatement(pstmt_insert); 
//OR_ORDER_LINE_FIELD_VALUES

				boolean enter_loop = false;
				pstmt_delete=connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A"));
				pstmt_delete.setString(1, order_number);
				pstmt_delete.executeUpdate();

				closeStatement(pstmt_delete);

				//pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
				pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

				pstmt_insert.clearBatch();
				if(drugRemarks.size()>0) {
					int order_format_count	= 0;
					HashMap DrugValues = null;
					String total_seq="";
					for (int i=0;i<drugRemarks.size();i++ ) {
						DrugValues = (HashMap)drugRemarks.get(i);
						total_seq	= (String)DrugValues.get("order_format_count");
						order_format_count	= Integer.parseInt(total_seq);

						for(int k=0;k<order_format_count;k++) {
							enter_loop = true;
							pstmt_insert.setString(1, order_number);
							pstmt_insert.setString(2, "" + (i+1));
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, "" + (k+1));
							pstmt_insert.setString(5, (String)DrugValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6, (String)DrugValues.get("field_type"+k));
							pstmt_insert.setString(7, (String)DrugValues.get("label_text"+k));
							pstmt_insert.setString(8, (String)DrugValues.get("field_values"+k));
							pstmt_insert.setString(9, "");
							pstmt_insert.setString(10, "");
							pstmt_insert.setString(11, (String)DrugValues.get("accept_option"+k));
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, login_by_id);
							pstmt_insert.setString(14, login_at_ws_no);
							pstmt_insert.setString(15, login_facility_id);
							pstmt_insert.setString(16, login_by_id);
							pstmt_insert.setString(17, login_at_ws_no);
							pstmt_insert.setString(18, login_facility_id);
							pstmt_insert.addBatch();
						}
					}
					if(enter_loop) {
						int[] batch_result = pstmt_insert.executeBatch();

						for (int i=0;i<batch_result.length;i++ ) {
							if (batch_result[i]<0  && batch_result[i] != -2) {
								System.err.println("IV ADDITIVES/INTERMITENT(AMEND)--> ERROR IN INSERTING DRUG REMARKS INTO OR_ORDER_LINE_FIELD_VALUES batch_result["+i+"]= "+batch_result[i]);
								System.err.println("tabData=== "+tabData);
									result=0;
								break;
							}
							else {
								result=1;
							}
						}
					}
					else {
						result=1;
					}
				}
				else {
					result=1;
				}
				closeStatement(pstmt_insert); 
			}
			if (result>0) {
				boolean freq_values_found	= false;
				//pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
				pstmt_insert = connection.prepareStatement("INSERT INTO OR_ORDER_LINE_FIELD_VALUES (ORDER_ID,ORDER_LINE_NUM,ORDER_LINE_FIELD_LEVEL,ORDER_LINE_SEQ_NUM,ORDER_LINE_FIELD_MNEMONIC,ORDER_LINE_FIELD_TYPE,ORDER_LINE_LABEL_TEXT,ORDER_LINE_FIELD_VALUE,ORDER_LINE_DOSE_QTY_VALUE,ORDER_LINE_DOSE_QTY_UNIT,ACCEPT_OPTION,ORDER_LINE_FREQ_DAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
	
				ArrayList frequencyValues = new ArrayList();
				HashMap drugDetails1=new HashMap();
				if(iv_pb.equals("Y")){
					
					drugDetails1 = (HashMap)drugList.get(0);
					freq_char_list	= new HashMap();
					day_list		= new ArrayList();
					time_list		= new ArrayList();
					dose_list		= new ArrayList();
					if (scheduleFreq.size()>0) {
						if (scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
					   		frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
			    	}
                }

				if (frequencyValues.size()>0) {
					if(frequencyValues != null && frequencyValues.size() > 0 && iv_pb.equals("Y")) {
						freq_char_list	= (HashMap)frequencyValues.get(0);
						day_list		= (ArrayList)frequencyValues.get(1);
						time_list		= (ArrayList)frequencyValues.get(3);
						dose_list		= (ArrayList)frequencyValues.get(4);
					}
					if(iv_pb.equals("Y")){
						for(int n=0;n<day_list.size();n++) {
							freq_values_found	= true;
							int seqNo			= 200;
							seqNo				= seqNo + n;

							/*HashMap data		= (HashMap)frequencyValues.get(n);
							String admin_time	= (String)data.get("admin_time");
							String admin_qty	= (String)data.get("admin_qty");*/
						//24668String durn_desc	= (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
							String durn_desc	= (String)orderDetails.get("FLUID_UNIT_QTY_UOM");
							if(!flag.equals("N")) // if ready to use iv
								durn_desc = (String)drugDetails1.get("DRUG_QTY_UOM");
							pstmt_insert.setString(1, order_number);
							pstmt_insert.setString(2, "1");
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, seqNo + "");
							pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
							pstmt_insert.setString(6, "C");
							pstmt_insert.setString(7, "D");
							/*pstmt_insert.setString(8, admin_time);
							pstmt_insert.setString(9, admin_qty);*/
							pstmt_insert.setString(8,(String)time_list.get(n));
							pstmt_insert.setString(9,(String)dose_list.get(n));
							pstmt_insert.setString(10, durn_desc);
							pstmt_insert.setString(11, "O");
							pstmt_insert.setInt(12, Integer.parseInt(day_list.get(n)+""));
							pstmt_insert.setString(13, login_by_id);
							pstmt_insert.setString(14, login_at_ws_no);
							pstmt_insert.setString(15, login_facility_id);
							pstmt_insert.setString(16, login_by_id);
							pstmt_insert.setString(17, login_at_ws_no);
							pstmt_insert.setString(18, login_facility_id);
							pstmt_insert.addBatch();
						}
					}
					else{ 
						for(int n=0;n<frequencyValues.size();n++) {
							freq_values_found	= true;
							int seqNo			= 200;
							seqNo				= seqNo + n;

							HashMap data		= (HashMap)frequencyValues.get(n);
							String admin_time	= (String)data.get("admin_time");
							String admin_qty	= (String)data.get("admin_qty");
							String durn_desc	= (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");

							pstmt_insert.setString(1, order_number);
							pstmt_insert.setString(2, "1");
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, seqNo + "");
							pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
							pstmt_insert.setString(6, "C");
							pstmt_insert.setString(7, "D");
							pstmt_insert.setString(8, admin_time);
							pstmt_insert.setString(9, admin_qty);
							pstmt_insert.setString(10, durn_desc);
							pstmt_insert.setString(11, "O");
							pstmt_insert.setString(12, login_by_id);
							pstmt_insert.setString(13, login_at_ws_no);
							pstmt_insert.setString(14, login_facility_id);
							pstmt_insert.setString(15, login_by_id);
							pstmt_insert.setString(16, login_at_ws_no);
							pstmt_insert.setString(17, login_facility_id);
							pstmt_insert.addBatch();
						}
					}
				}
				else{    //for interval frequency --added while fixing IN25314 --01/12/2010-- priya
					String sch_date_time	=	"";
					HashMap schd_week_hr_dates	=	new HashMap();
					ArrayList schd_date_time	=	new ArrayList();
					String tmp_sch_dt = "";
					String tmp_sch_time = "";
					//String durn_desc = "";
					String sch_start_date_time = "";
					drugDetails1 = (HashMap)drugList.get(0);
					String fr_drug_code = (String)drugDetails1.get("DRUG_CODE");
					schd_week_hr_dates	=   (HashMap) tabData.get("sched_date_time_wkhr");
					if(schd_week_hr_dates!= null && schd_week_hr_dates.size() > 0){
						schd_date_time	=	(ArrayList)schd_week_hr_dates.get(fr_drug_code);
						if(schd_date_time != null && schd_date_time.size()>0 && fr_drug_code.equals(fr_drug_code) ){
							sch_start_date_time = (String)schd_date_time.get(0);
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Calendar cal = Calendar.getInstance(); 
							cal.setTime( dateFormat.parse( sch_start_date_time ) ); 
							cal.add( Calendar.DATE, 1 ); 
							sch_start_date_time = dateFormat.format(cal.getTime());  
							int seqNo = 0;
							for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){
								sch_date_time = (String)schd_date_time.get(scdDt);
								if((!sch_date_time.equals("")) && (sch_date_time != null)){
									tmp_sch_dt    = sch_date_time.substring(0,10);
									tmp_sch_time = sch_date_time.substring(11,16);

									if(!tmp_sch_time.equals("")&&(tmp_sch_time!=null) && ( ((java.util.Date)dateFormat.parse(sch_date_time)).compareTo((java.util.Date)dateFormat.parse(sch_start_date_time)) < 0   )){
										freq_values_found = true;

										seqNo=200;
										seqNo= seqNo+scdDt;

										pstmt_insert.setString(1,order_number);
										pstmt_insert.setString(2,"1");
										pstmt_insert.setString(3,"S");
										pstmt_insert.setString(4,seqNo+"");
										pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
										pstmt_insert.setString(6,"C");
										pstmt_insert.setString(7,"D");
										pstmt_insert.setString(8,tmp_sch_time);
										pstmt_insert.setString(9, (String)orderDetails.get("FLUID_UNIT_QTY"));
										if(!flag.equals("N")) // if ready to use iv
										pstmt_insert.setString(10, (String)drugDetails1.get("DRUG_QTY_UOM"));
										else
										pstmt_insert.setString(10, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));

										//	pstmt_insert.setString(9,(String)insertRecords_2.get("QTY_VALUE"));
										//	pstmt_insert.setString(10,durn_desc);
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
				if (freq_values_found) {
					int[] batch_result = pstmt_insert.executeBatch();

					for (int i=0;i<batch_result.length;i++ ) {
						if (batch_result[i]<0  && batch_result[i] != -2) {
							System.err.println("IV ADDITIVES/INTERMITENT(AMEND)--> ERROR IN INSERTING FREQUENCY VALUES INTO  OR_ORDER_LINE_FIELD_VALUES batch_result["+i+"]= "+batch_result[i]);
							System.err.println("tabData=== "+tabData);
							result=0;
							break;
						}
						else {
							result=1;
						}
					}
				}
				else {
					result=1;
				}
				closeStatement(pstmt_insert);
			}

//PH_MEDN_ADMIN	
			if (result>0) {
				buildMAR_yn = (String)orderDetails.get("BUILD_MAR_YN");
				ArrayList schd_date_time	=	new ArrayList();
				ArrayList tmp_sch_dt_tm =   new ArrayList();
				HashMap schd_week_hr_dates	=	new HashMap();
				schd_week_hr_dates	=   (HashMap) tabData.get("sched_date_time_wkhr");
				String verf_reqd_bef_med_admin_yn = "";
				pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
						
				pstmt_select3.setString(1, login_facility_id);
				resultSet		= pstmt_select3.executeQuery();
				if (resultSet.next()) {
					verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				}
				closeResultSet( resultSet );
				HashMap drugDetails=null;
				HashMap drugDetails1 = (HashMap)drugList.get(0);
				String admin_time, sch_date_time, start_date_time, ord_end_date_time,  admin_qty;
				String qty_unit, dosage_type, ing_order_uom, equl_value, strength_value, strength_uom, pres_base_uom, equal_value;

				float   ing_unit_qty		= 0.0f;
				float	ing_order_qty		= 0.0f;
				double fr_durn_value	= Double.parseDouble(orderDetails.get("DURN_VALUE").toString());
				if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){
                    pstmt_delete=connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));
					pstmt_delete.setString(1, order_number);
					pstmt_delete.setString(2, login_facility_id);
					pstmt_delete.executeUpdate();

					closeStatement(pstmt_delete);
					if( buildMAR_yn.equals("Y") && !(iv_prep.equals("2") || iv_prep.equals("4"))){

						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));
						pstmt_insert.clearBatch();
						int dosage_seqNo		= 1;


						pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
						pstmt_select.setString(1, login_facility_id);
						resultSet		= pstmt_select.executeQuery();
						if (resultSet.next()) {
							verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
						}

						closeResultSet( resultSet );
						closeStatement(pstmt_select);
						if(iv_pb.equals("Y")){
							drugDetails1 = (HashMap)drugList.get(0);
							ing_unit_qty		= 0.0f;
							ing_order_qty		= 0.0f;
							fr_durn_value	= Double.parseDouble(orderDetails.get("DURN_VALUE").toString());
							if(orderDetails.get("DURN_UNIT").toString().equals("H")) {
								fr_durn_value	=	Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/24;
							} 
							else if(orderDetails.get("DURN_UNIT").toString().equals("M")) {
								fr_durn_value = Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/1440;
							}
							else {
								if(fr_durn_value < 1)
									fr_durn_value = 1;
							}
							if (fr_durn_value != 0) {
								ArrayList frequencyValues = new ArrayList();
								schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)drugDetails1.get("DRUG_CODE"));
							
								if (scheduleFreq.size() > 0) {
									if(scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
										frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
								}
								if(frequencyValues != null && frequencyValues.size() > 0){
									freq_char_list	= (HashMap)frequencyValues.get(0);
									day_list		= (ArrayList)frequencyValues.get(1);
									day_names		= (ArrayList)frequencyValues.get(2);
									time_list		= (ArrayList)frequencyValues.get(3);
									dose_list		= (ArrayList)frequencyValues.get(4);
								}  
								//pstmt_select2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT24A"));
								pstmt_select2 = connection.prepareStatement("SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') + ?, 'DD/MM/YYYY') || ' '|| ? scheduled_date_time FROM DUAL  WHERE    to_date(TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') +?,'DD/MM/YYYY') || ?, 'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')- 0.00069");//added - 0.00069 for IN26424 --09/02/2011-- priya
								pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
								for (int m=0; m<=fr_durn_value; m++) {
									/*if (frequencyValues.size() > 0) {
										for (int n=0; n<frequencyValues.size(); n++) {
											dosage_seqNo		= 1;
											dosage_seqNo			= dosage_seqNo+n;
											HashMap data			= (HashMap)frequencyValues.get(n);
											String admin_time		= (String)data.get("admin_time");

											String sch_date_time	= "";
											String start_date_time =(String)orderDetails.get("START_DATE");*/
										
										if(freq_char_list != null && freq_char_list.size()>0){
											if(!freq_char_list.get("durationType").equals("D")){	
												tmp_sch_dt_tm.clear();
												for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){
													if((tmpSch+(m*day_list.size())) < schd_date_time.size()){
														tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m*day_list.size())));
													}
												}
											}
										}

										if (day_list.size()>0){
											for(int n=0;n<day_list.size();n++){
												dosage_seqNo		= 1;
												dosage_seqNo			= dosage_seqNo+n;
												admin_time			=(String)time_list.get(n);
												sch_date_time	= "";
												start_date_time  =(String)orderDetails.get("START_DATE");
												ord_end_date_time = (String)orderDetails.get("END_DATE");

												if(freq_char_list.get("durationType").equals("D")){
													pstmt_select2.setString(1, start_date_time);
													pstmt_select2.setString(2, ""+m);
													pstmt_select2.setString(3, admin_time);
													pstmt_select2.setString(4, start_date_time);
													pstmt_select2.setString(5,""+m);
													pstmt_select2.setString(6,admin_time);
													pstmt_select2.setString(7,start_date_time);
													pstmt_select2.setString(8,ord_end_date_time); 
													resultSet = pstmt_select2.executeQuery();

													if (resultSet.next()) {
														sch_date_time = resultSet.getString(1);
													}
													
												}
												else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("L"))){
													sch_date_time = (String)tmp_sch_dt_tm.get(n);				
												} 
													closeResultSet( resultSet ); 

												if(sch_date_time != null && !(sch_date_time.equals(""))){
													pstmt_insert.setString(1, login_facility_id);
													pstmt_insert.setString(2, encounter_id);
													if(iv_pb.equals("Y")){
														pstmt_insert.setString(3, sch_date_time);
													}
													else{
														pstmt_insert.setString(3, (String)orderDetails.get("START_DATE"));
													}

													pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
													pstmt_insert.setString(5, dosage_seqNo + "");
													pstmt_insert.setString(6, order_number);
													pstmt_insert.setString(7, "1");
													pstmt_insert.setString(8, patient_id);
													pstmt_insert.setString(9, pract_id);
													pstmt_insert.setString(10, "Y");
													pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
													//pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
													if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){
														float dur1 = Float.parseFloat(Math.ceil(((duration / (Float.parseFloat((String)orderDetails.get("INFUSE_OVER"))))*100)/100)+"") ;
														if(iv_calc_infuse_by.equals("I")) //if block added for SKR-CRF-0035 [IN:037727] 
															dur1 = 1.0f;
														float qty_value = Float.parseFloat(Math.ceil((Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY"))*dur1)  )+"");
														pstmt_insert.setString(12, qty_value+"");
													}
													else{
														pstmt_insert.setString(12, (String)orderDetails.get("FLUID_UNIT_QTY"));
													}
													if(!flag.equals("N")) // if ready to use iv
														pstmt_insert.setString(13, (String)drugDetails1.get("DRUG_QTY_UOM"));
													else
														pstmt_insert.setString(13, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
													pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY"));
													pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
													pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE"));
													pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE"));
													pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
													pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
													pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
													pstmt_insert.setString(21, login_by_id);
													pstmt_insert.setString(22, login_at_ws_no);
													pstmt_insert.setString(23, login_facility_id);
													pstmt_insert.setString(24, login_by_id);
													pstmt_insert.setString(25, login_at_ws_no);
													pstmt_insert.setString(26, login_facility_id);

													pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
													pstmt_insert.setString(28, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
													pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID"));
													pstmt_insert.addBatch();
		// PH_MEDN_ADMIN ingredients     
													if(flag.equals("N")) {
														srlNo = 1;
														for(int j=1;j<=drugList.size();j++){
															drugDetails = (HashMap)drugList.get(j-1);

															pstmt_insert.setString(1, login_facility_id);
															pstmt_insert.setString(2, encounter_id);
															pstmt_insert.setString(3, sch_date_time);
															pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
															pstmt_insert.setString(5, "1");
															pstmt_insert.setString(6, order_number);
															pstmt_insert.setString(7, (++srlNo)+"");
															pstmt_insert.setString(8, patient_id);
															pstmt_insert.setString(9, pract_id);
															pstmt_insert.setString(10, "Y");
															pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
															
															dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
															ing_unit_qty		= 0.0f;
															ing_order_qty		= 0.0f;
															ing_order_uom		= "";
															strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
															strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
															content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
															stock_uom					=	(String)drugDetails.get("STOCK_UOM");
															qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");

															if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
																content_in_pres_base_uom =	"1";
															if(iv_pb.equals("Y")){
																ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
															}
															else{
																ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
															}
															ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

															if (dosage_type.equals("S")) {

																if(iv_pb.equals("Y")){
																   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
																}
																else{
																  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
																}
																float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
																ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");

		// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	if (freq_nature.equals("I")) {
		//																ing_order_qty = in_tot_qty*duration*(24/int_value);
																		ing_order_qty = in_tot_qty*duration/int_value;

																	}
																	else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																		ing_order_qty = in_tot_qty*rep_interval*duration;
																	}
																	else if (freq_nature.equals("O")) {
																		ing_order_qty = in_tot_qty;
																	}
																}
		// Ends (not for IVD)
																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																} 
																else {
																	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
															}	
															else  {							
																equl_value	= "1";
														
																pstmt_select.setString(1, ing_order_uom);
																pstmt_select.setString(2, qty_unit);
																pstmt_select.setString(3, ing_order_uom);
																pstmt_select.setString(4, qty_unit);
																resultSet	= pstmt_select.executeQuery();

																if (resultSet.next()) {
																	equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
																}
																closeResultSet( resultSet );
																float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
		// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	if (freq_nature.equals("I")) {
																		ing_order_qty = in_tot_qty*duration*(24/int_value);
																	}
																	else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																		ing_order_qty = in_tot_qty*rep_interval*duration;
																	}
																	else if (freq_nature.equals("O")) {
																		ing_order_qty = in_tot_qty;
																	}
																}
		// Ends (Not for IVD)
																if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																} 
																else {
																	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
															}
															pstmt_insert.setString(12, ing_unit_qty+""); //nSCH_DOSAGE_QTY

															pstmt_insert.setString(13, ing_order_uom); //nSCH_DOSAGE_UOM_CODE
															pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
															pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
															pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
															pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
															pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
															pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
															pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
															pstmt_insert.setString(21, login_by_id);
															pstmt_insert.setString(22, login_at_ws_no);
															pstmt_insert.setString(23, login_facility_id);
															pstmt_insert.setString(24, login_by_id);
															pstmt_insert.setString(25, login_at_ws_no);
															pstmt_insert.setString(26, login_facility_id);
															pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
															pstmt_insert.setString(28, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
															pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID"));
															pstmt_insert.addBatch();
														}
													} 
												}
										}//priya
									}
								}
								closeStatement(pstmt_select2);
								closeStatement(pstmt_select);
							}
						}
						else{
							if(flag.equals("N")){
								pstmt_insert.setString(1, login_facility_id);
								pstmt_insert.setString(2, encounter_id);
								pstmt_insert.setString(3, (String)orderDetails.get("START_DATE"));
								pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
								pstmt_insert.setString(5, dosage_seqNo + "");
								pstmt_insert.setString(6, order_number);
								pstmt_insert.setString(7, "1");
								pstmt_insert.setString(8, patient_id);
								pstmt_insert.setString(9, pract_id);
								pstmt_insert.setString(10, "Y");
								pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
								pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
								if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){
									pstmt_insert.setString(12, (String)orderDetails.get("FLUID_UNIT_QTY"));
								}
								else{
									pstmt_insert.setString(12, (Float.parseFloat((String)orderDetails.get("FLUID_UNIT_QTY"))/(Integer.parseInt((String)fluidDetails.get("FLUID_PACK_SIZE"))))+"");
								}
							
								pstmt_insert.setString(13, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
								pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY"));
								pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM"));
								pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE"));
								pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE"));
								pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
								pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));

								pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
								pstmt_insert.setString(21, login_by_id);
								pstmt_insert.setString(22, login_at_ws_no);
								pstmt_insert.setString(23, login_facility_id);
								pstmt_insert.setString(24, login_by_id);
								pstmt_insert.setString(25, login_at_ws_no);
								pstmt_insert.setString(26, login_facility_id);
								pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
								pstmt_insert.setString(28, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
								pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID"));
								pstmt_insert.addBatch();
							 }

							pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
							srlNo = 1;
							for(int j=1;j<=drugList.size();j++) {
								drugDetails = (HashMap)drugList.get(j-1);

								pstmt_insert.setString(1, login_facility_id);
								pstmt_insert.setString(2, encounter_id);
								pstmt_insert.setString(3, (String)orderDetails.get("START_DATE"));
								pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
								pstmt_insert.setString(5, "1");
								pstmt_insert.setString(6, order_number);
								pstmt_insert.setString(7, (++srlNo)+"");
								pstmt_insert.setString(8, patient_id);
								pstmt_insert.setString(9, pract_id);
								pstmt_insert.setString(10, "Y");
								pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));

								dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
								ing_unit_qty		= 0.0f;
								ing_order_qty		= 0.0f;
								ing_order_uom		= "";
								strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
								strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
								content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
								stock_uom					=	(String)drugDetails.get("STOCK_UOM");

								qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");

								if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
									content_in_pres_base_uom =	"1";
								if(iv_pb.equals("Y")){
									ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
								}
								else{
									ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
								}
								ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");

								if (dosage_type.equals("S")) {

									//ing_unit_qty	= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
									if(iv_pb.equals("Y")){
										ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
									}
									else{
										ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
									}
									float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
									ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
									if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										if (freq_nature.equals("I")) {
											ing_order_qty = in_tot_qty*duration*(24/int_value);
										}
										else if (freq_nature.equals("F") || freq_nature.equals("C")) {
											ing_order_qty = in_tot_qty*rep_interval*duration;
										}
										else if (freq_nature.equals("O")) {
											ing_order_qty = in_tot_qty;
										}
									}
// Ends (not for IVD)
									if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									} 
									else {
										ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									}
									
								}	
								else  {							
									equl_value	= "1";
									
									pstmt_select.setString(1, ing_order_uom);
									pstmt_select.setString(2, qty_unit);
									pstmt_select.setString(3, ing_order_uom);
									pstmt_select.setString(4, qty_unit);
									resultSet	= pstmt_select.executeQuery();

									if (resultSet.next()) {
										equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
									}

									closeResultSet( resultSet );
									float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
									
// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
									if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										if (freq_nature.equals("I")) {
											ing_order_qty = in_tot_qty*duration*(24/int_value);
										}
										else if (freq_nature.equals("F") || freq_nature.equals("C")) {
											ing_order_qty = in_tot_qty*rep_interval*duration;
										}
										else if (freq_nature.equals("O")) {
											ing_order_qty = in_tot_qty;
										}
									}
	// Ends (Not for IVD)
									if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
										ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									} 
									else {
										ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
									}
							/*		if(!iv_pb.equals("Y")) { // Commented for IN23838 --05/10/2010-- priya (for IV Continuous)
										ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
									} */
								}

								pstmt_insert.setString(12, ing_unit_qty+""); //nSCH_DOSAGE_QTY
								pstmt_insert.setString(13, ing_order_uom); //nSCH_DOSAGE_UOM_CODE
								pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
								pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
								pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
								pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
								pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
								pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
								pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
								pstmt_insert.setString(21, login_by_id);
								pstmt_insert.setString(22, login_at_ws_no);
								pstmt_insert.setString(23, login_facility_id);
								pstmt_insert.setString(24, login_by_id);
								pstmt_insert.setString(25, login_at_ws_no);
								pstmt_insert.setString(26, login_facility_id);
								pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
								pstmt_insert.setString(28, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
								pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID"));
								pstmt_insert.addBatch();
							}
							closeStatement(pstmt_select);
						}
						int[] batch_result = pstmt_insert.executeBatch();

						for (int i=0;i<batch_result.length;i++) {
							if(batch_result[i] < 0  && batch_result[i] != -2 ) {
								result = 0;
								System.err.println("IV ADDITIVES/INTERMITENT(AMEND IVD) --> ERROR IN INSERTING PH_MEDN_ADMIN batch_result["+i+"]= "+batch_result[i]);
								System.err.println("tabData=== "+tabData);
								break;
							}
							else {
								result = 1;
							}
						}
						closeStatement(pstmt_insert);
					}
				}
				else{
					pstmt_delete=connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));
					pstmt_delete.setString(1, order_number);
					pstmt_delete.setString(2, login_facility_id);
					pstmt_delete.executeUpdate();

					closeStatement(pstmt_delete);
					boolean freq_values_found = false;

					if( buildMAR_yn.equals("Y") && !(iv_prep.equals("2") || iv_prep.equals("4"))){ //iv_prep_yn added for MMS-QF-SCF-0616
						fr_durn_value	= Double.parseDouble(orderDetails.get("DURN_VALUE").toString());

						if(orderDetails.get("DURN_UNIT").toString().equals("H"))
							fr_durn_value	=	Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/24;
						else if(orderDetails.get("DURN_UNIT").toString().equals("M"))
							fr_durn_value = Double.parseDouble(orderDetails.get("DURN_VALUE").toString())/1440;
						else
							fr_durn_value = Double.parseDouble(orderDetails.get("DURN_VALUE").toString());
					/*	else
							fr_durn_value = 1;
							*/

						if(iv_pb.equals("Y")){
							drugDetails1 = (HashMap)drugList.get(0);
							if (fr_durn_value != 0) {
								pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));
								pstmt_insert.clearBatch();

								ArrayList frequencyValues = new ArrayList();
								schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)drugDetails1.get("DRUG_CODE"));
								if (scheduleFreq.size() > 0) {
									if(scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
										frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
								}
								/*below if block and vals for multi freq crf*/
								if(frequencyValues != null && frequencyValues.size() > 0){
										freq_char_list	= (HashMap)frequencyValues.get(0);
										day_list		= (ArrayList)frequencyValues.get(1);
										day_names		= (ArrayList)frequencyValues.get(2);
										time_list		= (ArrayList)frequencyValues.get(3);
										dose_list		= (ArrayList)frequencyValues.get(4);
								}
							
								//pstmt_select2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT24A"));
								pstmt_select2		= connection.prepareStatement("SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') + ?, 'DD/MM/YYYY') || ' '|| ? scheduled_date_time FROM DUAL  WHERE    to_date(TO_CHAR (TO_DATE (?, 'DD/MM/YYYY HH24:MI') +?,'DD/MM/YYYY') || ?, 'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI')- 0.00069"); //added - 0.00069 for IN26424 --09/02/2011-- priya
								pstmt_select 	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
								pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
								
								boolean first_flag = true;
								if(!freq_nature.equals("I")){
									if (frequencyValues.size() > 0) {
										freq_values_found = true;
										for (int m=0; m<=fr_durn_value; m++) {
									
											if((m != 0) && (int_value > 1)) {
												m = m+(int_value -1);
											}
											if(first_flag == false && int_value > 1 && freq_nature.equals("F")){
												m =1;
											}
											// added below if block line for multi freq crf
											if(freq_char_list != null && freq_char_list.size()>0){
												if(!freq_char_list.get("durationType").equals("D")){	
													tmp_sch_dt_tm.clear();
													for(int tmpSch=0;tmpSch<day_list.size();tmpSch++){
														if( (tmpSch+(m*day_list.size())) < schd_date_time.size())
															tmp_sch_dt_tm.add((String)schd_date_time.get(tmpSch+(m*day_list.size())));
													}
												}
											}  
											for(int n=0;n<day_list.size();n++){
												int dosage_seqNo		= 1;
												dosage_seqNo			= dosage_seqNo+n;
												admin_time			=(String)time_list.get(n);
												admin_qty			=(String)dose_list.get(n);
												ord_end_date_time = (String)orderDetails.get("END_DATE");
												sch_date_time	= "";
												if(freq_char_list.get("durationType").equals("D")){
												
													pstmt_select2.setString(1, ord_date);
													pstmt_select2.setString(2, ""+m);
													pstmt_select2.setString(3, admin_time);
													pstmt_select2.setString(4, ord_date);
													pstmt_select2.setString(5,""+m);
													pstmt_select2.setString(6,admin_time);
													pstmt_select2.setString(7,ord_date);
													pstmt_select2.setString(8,ord_end_date_time); 
												
													resultSet = pstmt_select2.executeQuery();

													if (resultSet.next()) {
														sch_date_time = resultSet.getString(1);
														first_flag = true;
													}
													else
														first_flag = false;
											}
											else if((freq_char_list.get("durationType").equals("W")) || (freq_char_list.get("durationType").equals("L"))){
												if(m!=fr_durn_value){
													sch_date_time = (String)tmp_sch_dt_tm.get(n);	
												}
												/*admin_time = sch_date_time.substring(11,sch_date_time.length());
												pstmt_select2.setString(1, ord_date);
												pstmt_select2.setString(2, ""+m);
												pstmt_select2.setString(3, admin_time);
												pstmt_select2.setString(4, ord_date);
												pstmt_select2.setString(5,""+m);
												pstmt_select2.setString(6,admin_time);
												pstmt_select2.setString(7,ord_date);
												pstmt_select2.setString(8,ord_end_date_time); 
												
												resultSet = pstmt_select2.executeQuery();

												if (resultSet.next()) {
													sch_date_time = resultSet.getString(1);
												}*/
											}
											closeResultSet( resultSet );

											dosage_type		= (String)fluidDetails.get("DOSAGE_TYPE");
											qty_unit			= (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT");
											strength_value	= (String)fluidDetails.get("STRENGTH_VALUE");
											strength_uom		= (String)fluidDetails.get("STRENGTH_UOM");
											pres_base_uom	= (String)fluidDetails.get("PRES_BASE_UOM");
											equal_value		= (String)fluidDetails.get("EQUAL_VALUE");
											equal_value				= "1";

											if (dosage_type.equals("Q")) {
												
												equal_value		= "1";
												pstmt_select.setString(1, pres_base_uom);
												pstmt_select.setString(2, qty_unit);
												pstmt_select.setString(3, pres_base_uom);
												pstmt_select.setString(4, qty_unit);
												resultSet		= pstmt_select.executeQuery();
												if (resultSet.next()) {
													equal_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
												}
												closeResultSet( resultSet );
											}

										if(sch_date_time != null && !(sch_date_time.equals(""))){
											pstmt_insert.setString(1, login_facility_id);
											pstmt_insert.setString(2, encounter_id);
											pstmt_insert.setString(3, sch_date_time);
											pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
											pstmt_insert.setString(5, dosage_seqNo + "");
											pstmt_insert.setString(6, order_number);
											pstmt_insert.setString(7, "1");
											pstmt_insert.setString(8, patient_id);
											pstmt_insert.setString(9, pract_id);
											pstmt_insert.setString(10, "Y");
											pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
											pstmt_insert.setString(12, admin_qty);
											if(!flag.equals("N")) // if ready to use iv
												pstmt_insert.setString(13, (String)drugDetails1.get("DRUG_QTY_UOM"));
											else
												pstmt_insert.setString(13, qty_unit);
											String sch_strength		= strength_value;
											String sch_strength_uom	= strength_uom;

											if (dosage_type.equals("S")) {
												sch_strength = strength_value;
											}
											else {
												float tot_strn	= (Float.parseFloat(admin_qty))*(Float.parseFloat(strength_value))*(Float.parseFloat(equal_value));
												sch_strength	= String.valueOf(tot_strn);
												if (sch_strength.length() > 11) {
													sch_strength = sch_strength.substring(0, 11);
												}
											}

											pstmt_insert.setString(14, sch_strength);
											pstmt_insert.setString(15, sch_strength_uom);
											pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE"));
											pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE"));
											pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
											pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
											//pstmt_insert.setString(19, "M");
											pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);

											pstmt_insert.setString(21, login_by_id);
											pstmt_insert.setString(22, login_at_ws_no);
											pstmt_insert.setString(23, login_facility_id);
											pstmt_insert.setString(24, login_by_id);
											pstmt_insert.setString(25, login_at_ws_no);
											pstmt_insert.setString(26, login_facility_id);

											pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
											//pstmt_insert.setString(28, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));
											pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
											pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID"));
											
											pstmt_insert.addBatch();
											if(flag.equals("N")) {
													srlNo = 1;
													for(int j=1;j<=drugList.size();j++)	{
														drugDetails = (HashMap)drugList.get(j-1);
														 if(drugDetails.size() != 0){	
															pstmt_insert.setString(1, login_facility_id);
															pstmt_insert.setString(2, encounter_id);
															pstmt_insert.setString(3, sch_date_time);
															pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
															pstmt_insert.setString(5, dosage_seqNo + "");//"1" priya
															pstmt_insert.setString(6, order_number);
															if(flag.equals("Y")){
																pstmt_insert.setString(7,1+"");
															}
															else{
																pstmt_insert.setString(7, (++srlNo)+"");
															}
															pstmt_insert.setString(8, patient_id);
															pstmt_insert.setString(9, pract_id);
															pstmt_insert.setString(10, "Y");
															pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
											

															dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
															 ing_unit_qty		= 0.0f;
															ing_order_qty		= 0.0f;
															ing_order_uom		= "";
															strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
															strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
															content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
															stock_uom					=	(String)drugDetails.get("STOCK_UOM");

															qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");

															if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
																content_in_pres_base_uom =	"1";
															if(iv_pb.equals("Y")) {
																ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
															} 
															else {
																ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
															}
															//ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
															ing_order_uom		= (String)drugDetails.get("DRUG_QTY_UOM");
															if (dosage_type.equals("S")) {
																 if(iv_pb.equals("Y")) {
																	   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
																 }
																 else {
																	  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
																 }
																float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
																ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
									// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
																if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){   // ???for  multi freq crf 
//																if( ((String)orderDetails.get("IVType")).equals("IVD")){
																	if (freq_nature.equals("I")) {
																		ing_order_qty = in_tot_qty*duration*(24/int_value);
																	}
																	else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																		ing_order_qty = in_tot_qty*rep_interval*duration;
																	}
																	else if (freq_nature.equals("O")) {
																		ing_order_qty = in_tot_qty;
																	}
																}
																// Ends (not for IVD)//???	 multi freq crf

																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																
																	ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
																else {
																	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
																
															}	
															else  {							
																equl_value	= "1";
																resultSet			= null;
																pstmt_select.setString(1, ing_order_uom);
																pstmt_select.setString(2, qty_unit);
																pstmt_select.setString(3, ing_order_uom);
																pstmt_select.setString(4, qty_unit);
																resultSet	= pstmt_select.executeQuery();

																if (resultSet.next()) {
																	equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
																}

																closeResultSet( resultSet );
																float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
																
									// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	if (freq_nature.equals("I")) {
																		ing_order_qty = in_tot_qty*duration*(24/int_value);
																	} else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																		ing_order_qty = in_tot_qty*rep_interval*duration;
																	} else if (freq_nature.equals("O")) {
																		ing_order_qty = in_tot_qty;
																	}
																}
									// Ends (Not for IVD)
																if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
																else {
																	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
															
															}

															pstmt_insert.setString(12, ing_unit_qty+""); //nSCH_DOSAGE_QTY
															pstmt_insert.setString(13, ing_order_uom); //nSCH_DOSAGE_UOM_CODE

															pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
															pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
															pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
															pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
															pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
															pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
															pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
															pstmt_insert.setString(21, login_by_id);
															pstmt_insert.setString(22, login_at_ws_no);
															pstmt_insert.setString(23, login_facility_id);
															pstmt_insert.setString(24, login_by_id);
															pstmt_insert.setString(25, login_at_ws_no);
															pstmt_insert.setString(26, login_facility_id);
															pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
															pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
															pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID"));
															pstmt_insert.addBatch();
														}	
													}
												}
												}//priya
												}
											}//end m
										}
									}
									else {//for interval frequency
										String tmp_sch_dt = "";
										int dosage_seqNo = 1;
										//sched_date_time_wkhr = (HashMap)tabData.get("sched_date_time_wkhr");
										//ArrayList schedDateTimesWkHr = (ArrayList)sched_date_time_wkhr.get(fr_drug_code);
										drugDetails = (HashMap)drugList.get(0);
										schd_week_hr_dates	=   (HashMap) tabData.get("sched_date_time_wkhr");
										
										if(schd_week_hr_dates!=null && schd_week_hr_dates.size() > 0){
											freq_values_found = true;
											schd_date_time	=	(ArrayList)schd_week_hr_dates.get((String)drugDetails.get("DRUG_CODE"));
										}
										sch_date_time="";

										if(schd_date_time != null && schd_date_time.size()>0 /*&& schd_date_time.size()>m*/){
											for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){  //Uncommented while fixing IN25314 --01/12/2010-- priya
												sch_date_time = (String)schd_date_time.get(scdDt); //replaced m with scdDt while fixing IN25314 --01/12/2010-- priya
												if(tmp_sch_dt.equals(sch_date_time.substring(0,10))){
													dosage_seqNo++;
												}
												else{
													dosage_seqNo = 1;
												}
												tmp_sch_dt    = sch_date_time.substring(0,10);

												if(!sch_date_time.equals("")&&(sch_date_time!=null)){
														pstmt_insert.setString(1, login_facility_id);
														pstmt_insert.setString(2, encounter_id);
														pstmt_insert.setString(3, sch_date_time);
														pstmt_insert.setString(4, (String)fluidDetails.get("DRUG_CODE"));
														pstmt_insert.setString(5, dosage_seqNo+"");
														pstmt_insert.setString(6, order_number);
														if(flag.equals("Y")){
															pstmt_insert.setString(7,1+"");
														}
														else{
															//pstmt_insert.setString(7, (++srlNo)+"");
															pstmt_insert.setString(7, "1");
														}
														pstmt_insert.setString(8, patient_id);
														pstmt_insert.setString(9, pract_id);
														pstmt_insert.setString(10, "Y");
														pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));
														pstmt_insert.setString(12, (Integer.parseInt((String)orderDetails.get("FLUID_UNIT_QTY")))+""+""); //nSCH_DOSAGE_QTY
														if(!flag.equals("N")) // if ready to use iv
															pstmt_insert.setString(13, (String)drugDetails1.get("DRUG_QTY_UOM"));
														else
															pstmt_insert.setString(13,  (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_DOSAGE_UOM_CODE

														pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
														pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
														pstmt_insert.setString(16, (String)fluidDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
														pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
														pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
														pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
														pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
														pstmt_insert.setString(21, login_by_id);
														pstmt_insert.setString(22, login_at_ws_no);
														pstmt_insert.setString(23, login_facility_id);
														pstmt_insert.setString(24, login_by_id);
														pstmt_insert.setString(25, login_at_ws_no);
														pstmt_insert.setString(26, login_facility_id);
														pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
														pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
														pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID"));
														pstmt_insert.addBatch(); 
														//	pstmt_insert.executeUpdate();
														
													 }
												}  //Uncommented
											
											}
								if(flag.equals("N")) {
									pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));
									tmp_sch_dt = "";
									for(int j=1;j<=drugList.size();j++)	{
											 drugDetails = (HashMap)drugList.get(j-1);
											 if(drugDetails.size() != 0){
												 if(schd_date_time != null && schd_date_time.size()>0/*&& schd_date_time.size()>m*/){
													for(int scdDt=0; scdDt<schd_date_time.size();scdDt++){ //Uncommented while fixing IN25314 --01/12/2010-- priya
														sch_date_time = (String)schd_date_time.get(scdDt); //replaced m with scdt while fixing IN25314 --01/12/2010-- priya
														if(tmp_sch_dt.equals(sch_date_time.substring(0,10))){
															dosage_seqNo++;
														}else{
															dosage_seqNo = 1;
														}
													tmp_sch_dt    = sch_date_time.substring(0,10);

													if(!sch_date_time.equals("")&&(sch_date_time!=null)){
															pstmt_insert.setString(1, login_facility_id);
															pstmt_insert.setString(2, encounter_id);
															pstmt_insert.setString(3, sch_date_time);
															pstmt_insert.setString(4, (String)drugDetails.get("DRUG_CODE"));
															pstmt_insert.setString(5,dosage_seqNo + "");//"1" priya
															pstmt_insert.setString(6, order_number);
															if(flag.equals("Y")){
																pstmt_insert.setString(7,1+"");
															}
															else{
																pstmt_insert.setString(7, "2");
															}
															pstmt_insert.setString(8, patient_id);
															pstmt_insert.setString(9, pract_id);
															pstmt_insert.setString(10, "Y");
															pstmt_insert.setString(11, (String)orderDetails.get("IV_INGREDIANTS"));

															dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
															ing_unit_qty		= 0.0f;
															ing_order_qty		= 0.0f;
															ing_order_uom		= "";
															strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
															strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	 
															content_in_pres_base_uom	=	(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
															stock_uom					=	(String)drugDetails.get("STOCK_UOM");

															qty_unit					= (String)drugDetails.get("QTY_DESC_CODE");

															if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
																content_in_pres_base_uom =	"1";
															if(iv_pb.equals("Y")) {
																ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
															} 
															else {
																ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
															}
															//ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
															ing_order_uom		= (String)drugDetails.get("DRUG_QTY_UOM");

															if (dosage_type.equals("S")) {
																 if(iv_pb.equals("Y")) {
																	   ing_unit_qty		= Float.parseFloat((String)orderDetails.get("QTY_VALUE"));
																 }
																 else {
																	  ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
																 }
																float in_tot_qty	=	(ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom));  
																ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
// Starts (not for IVD) code added for IVAdditives...on 13/5/2004
																if( ((String)orderDetails.get("IVType")).equals("IVD") && !iv_pb.equals("Y")){   // ???for  multi freq crf 
//if( ((String)orderDetails.get("IVType")).equals("IVD")){
																	if (freq_nature.equals("I")) {
																		ing_order_qty = in_tot_qty*duration*(24/int_value);
																	}
																	else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																		ing_order_qty = in_tot_qty*rep_interval*duration;
																	}
																	else if (freq_nature.equals("O")) {
																		ing_order_qty = in_tot_qty;
																	}
																}
// Ends (not for IVD)

//???	 multi freq crf

																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																
																	ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
																else {
																	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue(); 
																}
															}	
															else{
																equl_value	= "1";
																resultSet			= null;
																pstmt_select.setString(1, ing_order_uom);
																pstmt_select.setString(2, qty_unit);
																pstmt_select.setString(3, ing_order_uom);
																pstmt_select.setString(4, qty_unit);
																resultSet	= pstmt_select.executeQuery();

																if (resultSet.next()) {
																	equl_value = resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
																}
																closeResultSet( resultSet );
																float in_tot_qty = ing_unit_qty*Float.parseFloat(equl_value);
																
									// Starts (Not for IVD) code added for IVAdditives...on 13/5/2004
																if(!((String)orderDetails.get("IVType")).equals("IVD") || (((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	if (freq_nature.equals("I")) {
																		ing_order_qty = in_tot_qty*duration*(24/int_value);
																	} else if (freq_nature.equals("F") || freq_nature.equals("C")) {
																		ing_order_qty = in_tot_qty*rep_interval*duration;
																	} else if (freq_nature.equals("O")) {
																		ing_order_qty = in_tot_qty;
																	}
																}// Ends (Not for IVD)
																if(!((String)orderDetails.get("IVType")).equals("IVD")||(((String)orderDetails.get("IVType")).equals("IVD") && iv_pb.equals("Y")) ){
																	ing_order_qty	=   new Double(Math.ceil(ing_order_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
																else {
																	ing_order_qty	=   new Double(Math.ceil((in_tot_qty*ing_durn)/Float.parseFloat(content_in_pres_base_uom))).floatValue();
																}
															
															}
															pstmt_insert.setString(12, ing_unit_qty+""); //nSCH_DOSAGE_QTY
															pstmt_insert.setString(13, ing_order_uom); //nSCH_DOSAGE_UOM_CODE

															pstmt_insert.setString(14, (String)orderDetails.get("FLUID_UNIT_QTY")); //nSCH_STRENGTH
															pstmt_insert.setString(15, (String)orderDetails.get("FLUID_UNIT_QTY_UOM")); //nSCH_STRENGTH_UOM
															pstmt_insert.setString(16, (String)drugDetails.get("ROUTE_CODE")); //nSCH_ROUTE_CODE
															pstmt_insert.setString(17, (String)orderDetails.get("SCH_INFUSION_RATE")); //nSCH_INFUSION_RATE
															pstmt_insert.setString(18, (String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT")); //nSCH_INFUSION_VOL_STR_UNIT
															pstmt_insert.setString(19, (String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT")==null?"H":(String)orderDetails.get("SCH_INFUSION_PERIOD_UNIT"));  //SCH_INFUSION_PER_UNIT
															pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
															pstmt_insert.setString(21, login_by_id);
															pstmt_insert.setString(22, login_at_ws_no);
															pstmt_insert.setString(23, login_facility_id);
															pstmt_insert.setString(24, login_by_id);
															pstmt_insert.setString(25, login_at_ws_no);
															pstmt_insert.setString(26, login_facility_id);
															pstmt_insert.setString(27, (String)orderDetails.get("INFUSE_OVER"));
															pstmt_insert.setString(28, (String)orderDetails.get("INFUSE_OVER_UNIT"));
															pstmt_insert.setString(29, (String)orderDetails.get("MAR_BARCODE_ID"));
															pstmt_insert.addBatch(); 
															//pstmt_insert.executeUpdate();
														}
													} //Uncommented
												}
											}	
										}
									}
								}
									
		//						} //commented for loop (m)
								if (freq_values_found) {
									int[] batch_result = pstmt_insert.executeBatch();

									for (int i=0;i<batch_result.length;i++) {
										if(batch_result[i] < 0  && batch_result[i] != -2 ) {
											System.err.println("IV ADDITIVES/INTERMITENT(AMEND) --> ERROR IN INSERTING PH_MEDN_ADMIN batch_result["+i+"]= "+batch_result[i]);
											System.err.println("tabData=== "+tabData);
											result = 0;
											break;
										}
										else {
											result = 1;
										}
									}
								}
								else {
									result = 1;
								}
							}
							closeStatement(pstmt_insert);
						}
					}
				}
			} 
			if (result>0) {
				map.put("result", new Boolean(true));
				map.put("msgid", "RECORD_INSERTED");
				connection.commit();
			}
			else {
				connection.rollback();
				throw new EJBException("Insert Failed");
			}
		}
		catch(Exception e) {
			try {
				connection.rollback();
				throw new EJBException(this + " : " + e.getMessage());
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
			map.put("msgid", e.getMessage());
			e.printStackTrace();
			System.err.println("========Error @ Amend Prescription tabData="+tabData);
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement(pstmt_insert);
				closeStatement(pstmt_select);
				closeStatement(pstmt_select2);
				closeStatement(pstmt_select3);
				closeStatement(cstmt_insert);				
				closeStatement(pstmt_update);
				closeStatement(pstmt_update_non_scheduled_drug);
				closeStatement(pstmt_delete);
				closeStatement(pstmt_clob);
				closeStatement(pstmt_update_order_line_ph);
				closeStatement(pstmt_update_patient_drug_profile);

				closeConnection(connection, (Properties)tabData.get("PROPERTIES"));
				
			}
			catch(Exception fe) {
				fe.printStackTrace();
			}
		}
		return map;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap ivFluidsModify( HashMap tabData, HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		Connection connection					= null;
		PreparedStatement pstmt_insert			= null;
		PreparedStatement pstmt_clob			= null;		
		PreparedStatement pstmt_select			= null;
		PreparedStatement pstmt_select_2		= null;
		PreparedStatement pstmt_delete			= null;
		PreparedStatement pstmt_select2         =null;
		PreparedStatement pstmt_select3         =null;
		ResultSet resultSet						= null;

		String order_uom			=	"";
		String order_id				=	"";
		ArrayList AllFluids			=	new ArrayList();
		ArrayList order_uoms			=	new ArrayList();
		String patient_id			=	"";
		String patient_class		=	"";
		String encounter_id			=	"";
		String freq_code			=	"";
		String pract_id				=	"";
		String login_facility_id	=	"";
		String login_by_id			=	"";
		String login_at_ws_no		=	"";
		int count					=	0;
		HashMap record				=	null;
		HashMap MFR_Recs			=	null;
		String buildMAR_yn="";
		String amend_reason_code =""; //Added for ML-BRU-SCF-0098 [IN031837]
		String amend_reason ="";	//Added for ML-BRU-SCF-0098 [IN031837]
		//String MAR_barcode_id="";//added for MMS-QH-CRF-0080 [IN:038064] Unused local variable INC63877
		
		String amend_Order_Id =""; //IN066779
		String amnd_order_Reason =""; //IN066779
		
		try {
			connection = getConnection((Properties)tabData.get("PROPERTIES"));
			String lang_id	=	(String)tabData.get("lang_id");
			AllFluids		=	(ArrayList)tabData.get("AllFluids");
			order_id		=	(String)tabData.get("order_id");
			patient_id		=	(String)tabData.get("patient_id");
			patient_class	=	(String)tabData.get("patient_class");
			encounter_id	=	(String)tabData.get("encounter_id");
			freq_code		=	(String)tabData.get("freq_code");
			pract_id		=	(String)tabData.get("pract_id"); 
			login_facility_id	= (String)tabData.get("login_facility_id");
			login_by_id			= (String)tabData.get("login_by_id");
			login_at_ws_no		= (String)tabData.get("login_at_ws_no");
			//String allergic_yn	= tabData.get("allergic_yn")==null?"N":(String)tabData.get("allergic_yn"); //Commented for COMMON-ICN-0048
			String remarks		= (String)tabData.get("remarks")==null?"":(String)tabData.get("remarks");
			buildMAR_yn			=(String)tabData.get("BUILD_MAR_YN"); //RUT-CRF0062  BUILD_MAR_YN Value will be inserted to all the fluids based on the first fluid selected. 
			amend_reason_code			=(String)tabData.get("AMEND_REASON_CODE");//Added for ML-BRU-SCF-0098 [IN031837]
			amend_reason			=(String)tabData.get("AMEND_REASON");//Added for ML-BRU-SCF-0098 [IN031837]
			String iv_calc_infuse_by			=tabData.get("iv_calc_infuse_by")==null?"":(String)tabData.get("iv_calc_infuse_by");//Added for SKR-CRF-0035 [IN:037727] 

			amend_Order_Id			=(String)tabData.get("AMEND_ORDER_ID");//IN066779
			amnd_order_Reason			=(String)tabData.get("AMEND_ORDER_REASON");//IN066779
			if(AllFluids.size() > 0 ) {
			
				pstmt_select		= connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_SELECT2"));
				// OR_ORDER
				pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE1"));
				pstmt_insert.setString(++count, "5");					//IV_PREP_YN (continuous)
				pstmt_insert.setString(++count, "");					//Disp_locn_code (continuous)
				pstmt_insert.setString(++count, login_by_id);		//ADDED_BY_ID
				pstmt_insert.setString(++count, login_at_ws_no);		//ADDED_AT_WS_NO
				pstmt_insert.setString(++count, login_facility_id);	//ADDED_FACILITY_ID
				pstmt_insert.setString(++count, order_id);				// ORDER_ID
				int result			= pstmt_insert.executeUpdate();
				closeStatement(pstmt_insert); 

				
				
				/*IN066779 Starts*/
				if(!"".equals(amend_Order_Id)){ 
					PreparedStatement	auditSeqPStmt = connection.prepareStatement("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1 FROM OR_ORDER_AMEND_REASON WHERE ORDER_ID = ?");
					auditSeqPStmt.setString(1,amend_Order_Id);				
					ResultSet auditSeqRs = auditSeqPStmt.executeQuery();				
					String amend_reason_seq ="";
					if (auditSeqRs.next()){
						amend_reason_seq	= ChkDef.defaultString(auditSeqRs.getString(1));
					}
					closeResultSet( auditSeqRs ); //common-icn-0029
					PreparedStatement	auditReasonPStmt = connection.prepareStatement("INSERT INTO OR_ORDER_AMEND_REASON ( ORDER_ID,ACTION_SEQ_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ORDER_AMEND_REASON) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");
					auditReasonPStmt.setString(1,amend_Order_Id);
					auditReasonPStmt.setString(2, amend_reason_seq);
					auditReasonPStmt.setString(3, login_by_id);		
					auditReasonPStmt.setString(4, login_at_ws_no);				
					auditReasonPStmt.setString(5, login_facility_id);	
					auditReasonPStmt.setString(6, login_by_id);					
					auditReasonPStmt.setString(7, login_at_ws_no);
					auditReasonPStmt.setString(8, login_facility_id);
					auditReasonPStmt.setString(9, amnd_order_Reason);
					auditReasonPStmt.execute();
					closeStatement(auditReasonPStmt);
					closeStatement(auditSeqPStmt);
					
				}
				/*IN066779 ends*/
				
				
				// OR_ORDER_LINE FOR FLUID
				if (result>0) {
					pstmt_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE5"));
					for(int i=0; i<AllFluids.size(); i++ ) {
						count		=	0;
						record		=	(HashMap)AllFluids.get(i);				

						// order qty calculation
						MFR_Recs = (HashMap)record.get("MFR_Recs");
						// order qty calculation
						int duration	= 0;
						float dur1		= 0.0f;
						if(MFR_Recs != null && MFR_Recs.size() > 0){
							dur1 = 1.0f;
						}
						else{
							if(iv_calc_infuse_by.equals("I")) //if block & else condition added for SKR-CRF-0035 [IN:037727] 
								dur1 = 1.0f;
							else{
								duration				= Integer.parseInt((String)record.get("DURN_VALUE"));
								dur1		= ((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100 ;
							}
						}
						System.out.println("-->9245 ---< --INFUSE_OVER"+(String)record.get("INFUSE_OVER"));
System.out.println("dur1"+dur1+"duration"+duration);
						//dur1		= ((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100 ;
						float order_qty	= Float.parseFloat(Math.ceil((Float.parseFloat((String)record.get("QTY_VALUE"))*dur1) / Float.parseFloat((String)record.get("FLUID_PACK_SIZE")))+"");									
						System.out.println("9249---->>>>order_qty"+order_qty+"FLUID_PACK_SIZE"+(String)record.get("FLUID_PACK_SIZE"));
						System.out.println("--->record---.,,<<<<"+record);
						pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
						pstmt_select.setString(2, lang_id);
						resultSet	= pstmt_select.executeQuery();
						if (resultSet.next()) {
							order_uom	=	(resultSet.getString("STOCK_UOM"));
						}
						order_uoms.add(order_uom);
						closeResultSet( resultSet ); 
					
						pstmt_insert.setString(++count, freq_code);								//FREQ_CODE
						pstmt_insert.setString(++count, (String)record.get("DURN_VALUE"));		//DURN_VALUE
						pstmt_insert.setString(++count, "H");									//DURN_TYPE
						pstmt_insert.setString(++count, (String)record.get("START_DATE"));//START_DATE_TIME
						pstmt_insert.setString(++count, (String)record.get("END_DATE"));		//END_DATE
						pstmt_insert.setString(++count, order_qty+"");						//ORDER_QTY
						pstmt_insert.setString(++count, order_uom);		//ORDER_UOM
						pstmt_insert.setString(++count,  pract_id);		//amd_pract_id   //login_by_id changed to pract_id for  ML-BRU-SCF-0318
						pstmt_insert.setString(++count, login_by_id);		//MODIFIED_BY_ID
						pstmt_insert.setString(++count, login_at_ws_no);		//MODIFIED_AT_WS_NO
						pstmt_insert.setString(++count, login_facility_id);	//MODIFIED_FACILITY_ID
						pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));		// QTY_VALUE
						pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));			//QTY_UOM
						pstmt_insert.setString(++count, order_id);								// ORDER_ID
						pstmt_insert.setString(++count, (i+1)+"");					// ORDER_LINE_NUM

						pstmt_insert.addBatch();
					}

					int[] batch_result = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result.length;i++ ) {
						if (batch_result[i]<0  && batch_result[i] != -2) {
							pstmt_insert.cancel();
							System.err.println("IV_FLUID(AMEND)--> ERROR IN OR_ORDER_LINE UPDATION batch_result["+i+"]= "+batch_result[i]);
							System.err.println("tabData=== "+tabData);
							throw new Exception("OR ORDER Line Failed");
						}
					}
					closeStatement(pstmt_insert);
				}

				// OR_ORDER_LINE_PH
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE3"));
							
				for(int i=0; i<AllFluids.size(); i++ ) {
					record		=	(HashMap)AllFluids.get(i);	
					//buildMAR_yn = record.get("BUILD_MAR_YN")==null?"":(String)record.get("BUILD_MAR_YN");  RUT-CRF-0062 Commented. BUILD_MAR_YN Value will be updated based on the first fluid selected
					count		=	0;
					String MFR_YN = "";
					MFR_Recs = (HashMap)record.get("MFR_Recs");
					if(MFR_Recs != null && MFR_Recs.size() > 0)
						MFR_YN = "Y";
					// order qty calculation
					int duration				= 0;
					float total_duration		= 0.0f;
					if(MFR_YN.equals("Y")){
						total_duration = 1.0f;
					}
					else{
						if(iv_calc_infuse_by.equals("I")) //if block & else condition added for SKR-CRF-0035 [IN:037727] 
							total_duration = 1.0f;
						else{
							duration				= Integer.parseInt((String)record.get("DURN_VALUE"));
							total_duration		= ((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100 ;
						}
						System.out.println("9315-->duration"+duration);
					}
					float tot_qty				= (Float.parseFloat((String)record.get("QTY_VALUE"))*total_duration);
					float order_qty				= Float.parseFloat(Math.ceil( tot_qty/ Float.parseFloat((String)record.get("FLUID_PACK_SIZE")))+"");
					System.out.println("9318-->total_duration"+total_duration);
					System.out.println("9318-->tot_qty"+tot_qty);
					float total_strength		= 0.0f;
					
					if(MFR_YN.equals("Y"))
							total_strength = Float.parseFloat((String)MFR_Recs.get("totInfVolume"));
					else{
						if(!((String)record.get("STRENGTH_VALUE")).equals("") && !((String)record.get("STRENGTH_VALUE")).equals("0")) {
							total_strength		= (Float.parseFloat((String)record.get("STRENGTH_VALUE"))*total_duration);
						}
					}
					
					pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
					resultSet	= pstmt_select.executeQuery();
					if (resultSet.next()) {
						order_uom	=	(resultSet.getString("STOCK_UOM"));
					}
					closeResultSet( resultSet );
					pstmt_insert.setString(++count, "");											//SPLIT_DRUG_PREVIEW
					pstmt_insert.setString(++count, (Math.ceil(total_strength)+""));		//TOT_STRENGTH
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));					//TOT_STRENGTH_UOM
					if(MFR_YN.equals("Y")){
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, "");
					}
					else{
						pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER"));				//INFUSE_OVER
						pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));											//INFUSE_OVER_UNIT
						pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE"));			//INFUSION_RATE
						pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));					//INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));				//INFUSION_PER_UNIT
					}
					System.out.println("9354-->BMS_QTY"+order_qty);
					pstmt_insert.setString(++count, order_qty+"");			//BMS_QTY
					pstmt_insert.setString(++count, (Math.ceil(total_strength)+""));	//BMS_STRENGTH
					pstmt_insert.setString(++count, "N");								//SPLIT_DOSE_YN
					pstmt_insert.setString(++count, Math.ceil(tot_qty)+"");				//PRES_QTY_VALUE
					pstmt_insert.setString(++count, record.get("PRES_BASE_UOM")+"");	//PRES_QTY_UOM
					pstmt_insert.setString(++count, (String)record.get("DURN_VALUE")); //TOT_INFUSION_OVER
					pstmt_insert.setString(++count, "H");			//TOT_INFUSION_OVER_UNIT  
					pstmt_insert.setString(++count, amend_reason_code);	//amend_reason_code	added for ML-BRU-SCF-0098 [IN031837]
					pstmt_insert.setString(++count, amend_reason);	//amend_reason added for ML-BRU-SCF-0098 [IN031837]
					pstmt_insert.setString(++count, "");			//CHNGD_FLUID_REMARKS
					pstmt_insert.setString(++count, "");			//ADMIN_RATE_DETAIL
					pstmt_insert.setString(++count, login_by_id);	//MODIFIED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no); //MODIFIED_BY_WS_NO
					pstmt_insert.setString(++count, login_facility_id);//MODIFIED_FACILITY_ID
					pstmt_insert.setString(++count, (String)record.get("MFR_REMARKS"));	//MFR_REMARKS
					if(MFR_YN.equals("Y")){
						pstmt_insert.setString(++count, "");			//ORIG_INFUSE_OVER
						pstmt_insert.setString(++count, "");			//ORIG_INFUSION_RATE
					}
					else{
						pstmt_insert.setString(++count,(String)record.get("INFUSE_OVER"));			//ORIG_INFUSE_OVER
						pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE"));			//ORIG_INFUSION_RATE
					}
					pstmt_insert.setString(++count, buildMAR_yn);			//buildMAR_yn
					pstmt_insert.setString(++count, login_by_id);//login_by_id Added for ML-BRU-SCF-0098 [IN031837]			
					pstmt_insert.setString(++count, (String)record.get("DRUG_INDICATION")); //DRUG_INDICATION
					pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE"));			//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_RATE
					pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));					//SKR-SCF-0543 [IN:033153] Added for Column PRES_INFUSION_QTY_UNIT
					pstmt_insert.setString(++count, (String)record.get("ABUSE_EXISTS")==null ?"" :(String)record.get("ABUSE_EXISTS"));//added for AAKH-CRF-0140
					pstmt_insert.setString(++count, (String)record.get("abuse_override_remarks")==null ?"" :(String)record.get("abuse_override_remarks"));//added for AAKH-CRF-0140

					pstmt_insert.setString(++count, order_id);			//ORDER_ID
					pstmt_insert.setString(++count, (i+1)+"");			//ORDER_LINE_NUM
					pstmt_insert.addBatch();
				}
				int[] batch_result = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result.length;i++ ) {
					if (batch_result[i]<0  && batch_result[i] != -2) {
						pstmt_insert.cancel();
						System.err.println("IV_FLUID(AMEND)--> ERROR IN OR_ORDER_LINE_PH UPDATION batch_result["+i+"]= "+batch_result[i]);
						System.err.println("tabData=== "+tabData);
						throw new Exception("OR ORDER Line PH Failed");
					}
				}
				closeStatement(pstmt_insert);
				// INSERTING INTO OR_ORDER_LINE_PH_MFR - MODIFY MODE
				String totRecs = "0";
				pstmt_delete = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_MFR_DELETE"));
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));
				pstmt_delete.setString(1, order_id);
				int del = pstmt_delete.executeUpdate(); //Removed comment for ML-BRU-SCF-0648 [IN:037167]
				closeStatement(pstmt_delete);
				closeStatement(pstmt_insert); //3/21/2021
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_MFR_INSERT"));
				for(int i=0; i<AllFluids.size(); i++ ) {
					System.out.println("9407-->BMS_QTY"+AllFluids);
					record		=	(HashMap)AllFluids.get(i);	
					totRecs = "0";
					MFR_Recs = new HashMap();
					MFR_Recs = (HashMap)record.get("MFR_Recs");
					if(MFR_Recs != null && MFR_Recs.size() > 0)
						totRecs = (String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec");
					ArrayList rec = new ArrayList();
					//int ins=0;
					for(int k=1; k<= Integer.parseInt(totRecs); k++){
						rec	= (ArrayList)MFR_Recs.get("MFR"+k);

						pstmt_insert.setString(1, order_id); // ORDER_ID
						pstmt_insert.setString(2, "1"); //ORDER_LINE_NUM
						pstmt_insert.setString(3, k+""); //SL_NO
						pstmt_insert.setString(4, (String)rec.get(0)); //TOT_STRENGTH - volume
						pstmt_insert.setString(5, (String)record.get("STRENGTH_UOM")); //TOT_STRENGTH_UOM
						pstmt_insert.setString(6, (String)rec.get(5)); //INFUSE_OVER
						pstmt_insert.setString(7, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT")); //INFUSE_OVER_UNIT
						pstmt_insert.setString(8, (String)rec.get(1)); //INFUSION_RATE
						pstmt_insert.setString(9, (String)record.get("QTY_UOM")); //INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(10, (String)rec.get(2)); //INFUSION_PER_UNIT
						pstmt_insert.setString(11,(String)rec.get(10) ); //GAP_DURATION_IN_HRS
						pstmt_insert.setString(12, ""); //ADMIN_RATE_DETAIL

						pstmt_insert.setString(13, (String)rec.get(6)); //START_DATE_TIME
						pstmt_insert.setString(14, (String)rec.get(7)); //END_DATE_TIME
						pstmt_insert.setString(15, login_by_id); //ADDED_BY_ID
						pstmt_insert.setString(16, login_at_ws_no); //ADDED_AT_WS_NO
						pstmt_insert.setString(17, login_facility_id); //ADDED_FACILITY_ID
						pstmt_insert.setString(18, login_by_id); //MODIFIED_BY_ID
						pstmt_insert.setString(19, login_at_ws_no); //MODIFIED_AT_WS_NO
						pstmt_insert.setString(20, login_facility_id); // MODIFIED_FACILITY_ID
						pstmt_insert.addBatch();
					}
				}
				
				if(Integer.parseInt(totRecs) > 0){
					int[] or_order_line_ph_mfr_result = pstmt_insert.executeBatch();
					
					for (int i=0;i<or_order_line_ph_mfr_result.length;i++) {
						if(or_order_line_ph_mfr_result[i] < 0  && or_order_line_ph_mfr_result[i] != -2 ) {
							System.err.println("IV FLUIDS --> ERROR IN INSERTING -modify mode INTO OR_ORDER_LINE_PH_MFR or_order_line_ph_mfr_result["+i+"]= "+or_order_line_ph_mfr_result[i]);
							System.err.println("tabData=== "+tabData);
							result = 0;
							break;
						}
						else {
							result = 1;
						}
					}
				}
				closeStatement(pstmt_insert);
		
				// PH_PATIENT_DRUG_PROFILE FLUID
				pstmt_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES__UPDATE4"));
				System.out.println("9521 ph+patient_drug_profile SQL_PH_AMEND_IVPRES__UPDATE3");
				
				int srl_NO			= 0;
				resultSet		= null;
				pstmt_select_2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT55"));
				pstmt_select_2.setString(1, patient_id);						
				resultSet		= pstmt_select_2.executeQuery();
				if(resultSet.next()) {
					srl_NO = resultSet.getInt("NEXT_SRL_NO");
				}

				closeResultSet( resultSet );
				closeStatement( pstmt_select_2 );

				pstmt_select3	= connection.prepareStatement((String)sqlMap.get("SQL_PH_AMEND_IVPRES_SELECT3"));
				pstmt_select2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT53"));

				for(int i=0; i<AllFluids.size(); i++ ) {
					System.out.println("9505 SQL_PH_AMEND_IVPRES__UPDATE4");
					record		=	(HashMap)AllFluids.get(i);		
					count		=	0;

					int duration				= 0;
					MFR_Recs = new HashMap();
					MFR_Recs = (HashMap)record.get("MFR_Recs");
					totRecs = "0";
					if(MFR_Recs != null && MFR_Recs.size() > 0)
						totRecs = (String)MFR_Recs.get("totRec")==null?"0":(String)MFR_Recs.get("totRec");
					/*if(Integer.parseInt(totRecs) > 0) Commented if and else for AAKH-SCF-0121IN[049680] 
						duration = 0;
					else
						duration				= Integer.parseInt((String)record.get("DURN_VALUE"));*/
					
					pstmt_select.setString(1, (String)record.get("DRUG_CODE"));
					resultSet	= pstmt_select.executeQuery();
					if (resultSet.next()) {
						order_uom	=	(resultSet.getString("STOCK_UOM"));
					}
					closeResultSet( resultSet );

					if(i> 0) {
						++srl_NO;
					} 
					/*==========================prescribe_qunaty calculation starts======================== */
					String  pres_base_uom					=(String)record.get("PRES_BASE_UOM");
					String  qty_unit						=(String)record.get("PRES_QTY_UOM");
					String  equl_value					=null;
					String  qty_value1					     ="";
					String  in_pres_qty_value				=null;
					String  interval_value				=null;
					String  repeat_value					=null;
					String  dosage_type="";
					 dosage_type					="Q";
					qty_value1=(String)record.get("QTY_VALUE");
					String  freq_nature="C";
					String  durn_value					=(String)record.get("DURN_VALUE");
					/*if(Integer.parseInt(totRecs) <= 0){ Commented if condition for AAKH-SCF-0121IN[049680] 
						durn_value = String.valueOf(Math.ceil(((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100)+"");
					}*/
				   if(Integer.parseInt(totRecs) >0 || iv_calc_infuse_by.equals("I")){ // iv_calc_infuse_by condition added for SKR-CRF-0035 [IN:037727] And Added for AAKH-SCF-0121IN[049680] 
						durn_value = "1";
					}
					else{
						duration = Integer.parseInt((String)record.get("DURN_VALUE"));
						durn_value = String.valueOf(Math.ceil(((duration / (Float.parseFloat((String)record.get("INFUSE_OVER"))))*100)/100)+"");//Math.ceil added for SKR-SCF-1397
					}
					pstmt_select3.setString(1, freq_code);
					resultSet		= pstmt_select3.executeQuery();

					if(resultSet.next()) {
						interval_value = resultSet.getString("interval_value");
						repeat_value   = resultSet.getString("repeat_value");
					}

					closeResultSet( resultSet );
					if(interval_value == null) 
						interval_value="1";
					if(repeat_value == null || freq_nature.equals("C")) 
						repeat_value="1";
					if(Integer.parseInt(totRecs) > 0){ // ie. if MFR order then pres qty wil be same as tot qty
						in_pres_qty_value = (String)MFR_Recs.get("totInfVolume");
					}
					else{
						 if(dosage_type!=null && dosage_type.equals("Q")){
							equl_value	=	"1";
							pstmt_select2.setString(1,pres_base_uom);
							pstmt_select2.setString(2,qty_unit);
							pstmt_select2.setString(3,pres_base_uom);
							pstmt_select2.setString(4,qty_unit);
							resultSet	= pstmt_select2.executeQuery();
							if ( resultSet != null && resultSet.next() ) {
								equl_value	= resultSet.getString("EQVL_VALUE")==null ? "1":resultSet.getString("EQVL_VALUE");
							}
							closeResultSet( resultSet );
						   float ord_qty=0.0f;			   
						   if( (qty_value1!=null && !(qty_value1.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals("")))  ){
								ord_qty		=	(Float.parseFloat(qty_value1)*Float.parseFloat(durn_value)*Integer.parseInt(repeat_value) *Float.parseFloat(equl_value));

								if(ord_qty==0)
									ord_qty	=	1;
							}

							System.out.println("9562-->ord_qty"+ord_qty);
							System.out.println("9562-->qty_value1"+qty_value1);
							in_pres_qty_value=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));//Math.ceil added for SKR-SCF-1397
						}
					}
					//in_pres_qty_value = String.valueOf(Float.parseFloat(in_pres_qty_value) / Float.parseFloat((String)record.get("FLUID_PACK_SIZE")));
					in_pres_qty_value = String.valueOf(Float.parseFloat(in_pres_qty_value));
					/*if( !((String)record.get("STRENGTH_VALUE")).equals("") && !((String)record.get("STRENGTH_VALUE")).equals("0")) {
						//	pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE"));	//STRENGTH
						//	pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));		//STRENGTH_UOM_CODE
						} 
					else {
						//	pstmt_insert.setString(++count, "");	//STRENGTH
						//	pstmt_insert.setString(++count, "");		//STRENGTH_UOM_CODE
						//	if(record.get("FLUID_PACK_SIZE") != null && !((String)record.get("FLUID_PACK_SIZE")).equals(""))
							//	in_pres_qty_value = String.valueOf(Float.parseFloat(in_pres_qty_value) / Float.parseFloat((String)record.get("FLUID_PACK_SIZE")));
					}*/

					pstmt_insert.setString(++count, (String)record.get("START_DATE"));		//START_DATE
					pstmt_insert.setString(++count, (String)record.get("END_DATE"));		//END_DATE
					pstmt_insert.setString(++count, "N");		//SPLIT_YN
					pstmt_insert.setString(++count, "");				//SPLIT_DOSE_PREVIEW
					pstmt_insert.setString(++count, freq_code);							//FREQ_CODE
					pstmt_insert.setString(++count, "H");     //DURN_TYPE
					pstmt_insert.setString(++count, (String)record.get("DURN_VALUE"));  //DURATION
					pstmt_insert.setString(++count, in_pres_qty_value+"");						//PRESCRIBED_QTY
					pstmt_insert.setString(++count, "N"); //IV_PREP_YN
					pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER")); //INFUSE_OVER
					pstmt_insert.setString(++count,record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));
					pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE")); //INFUSION_RATE
					pstmt_insert.setString(++count, (String)record.get("QTY_UOM")); //INFUSION_VOL_STR_UNIT
					pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));  // infusion per unit			
					pstmt_insert.setString(++count, "Y"); // amend_yn
					pstmt_insert.setString(++count, pract_id); // amend by id //login_by_id changed to pract_id for  ML-BRU-SCF-0318
					pstmt_insert.setString(++count, "");  // tot issued qty
					pstmt_insert.setString(++count, login_by_id);
					pstmt_insert.setString(++count, login_at_ws_no);
					pstmt_insert.setString(++count, login_facility_id);
					pstmt_insert.setString(++count, "");	//STRENGTH
					pstmt_insert.setString(++count, "");		//STRENGTH_UOM_CODE
					pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));	//DOSAGE
					System.out.println("--->9610QTY_VALUE"+(String)record.get("QTY_VALUE"));
					pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));		//DOSAGE_UOM_CODE
					pstmt_insert.setString(++count, "Q"); //PRESCRIBED_MODE 
					pstmt_insert.setString(++count, (String)record.get("DRUG_CODE"));  //DRUG_CODE
					pstmt_insert.setString(++count, (String)record.get("GENERIC_ID"));  //GENERIC_ID
					pstmt_insert.setString(++count, ""); //IV_INGREDIENTS
					pstmt_insert.setString(++count, ""); //ALLERGY_OVERRIDE_REASON
					pstmt_insert.setString(++count, "");//DOSAGE_LIMIT_OVERRIDE_REASON 
					pstmt_insert.setString(++count, ""); //DUPLICATE_DRUG_OVERRIDE_REASON
					pstmt_insert.setString(++count, "");//INTERACTION_OVERRIDE_REASON
					pstmt_insert.setString(++count, "");//CONTRAIND_OVERRIDE_REASON
					pstmt_insert.setString(++count, (String)record.get("ABUSE_EXISTS")==null ?"" :(String)record.get("ABUSE_EXISTS"));//added for AAKH-CRF-0140
					pstmt_insert.setString(++count, (String)record.get("abuse_override_remarks")==null ?"" :(String)record.get("abuse_override_remarks"));//added for AAKH-CRF-0140

					pstmt_insert.setString(++count, patient_id);				//PATIENT_ID
					pstmt_insert.setString(++count, order_id); // orig order id
					pstmt_insert.setString(++count, (i+1)+"");  // line no
					pstmt_insert.addBatch();
				}
				closeStatement( pstmt_select );
				closeStatement(pstmt_select3); 
				closeStatement( pstmt_select2 );

				int[] batch_result2 = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result2.length; i++ ) {

					if (batch_result2[i]<0  && batch_result2[i] != -2) {
						pstmt_insert.cancel();
						System.err.println("IV_FLUID(AMEND)--> ERROR IN PH_PATIENT_DRUG_PROFILE UPDATION batch_result["+i+"]= "+batch_result[i]);
						System.err.println("tabData=== "+tabData);
						throw new Exception("Patient Drug Profile Failed");
					}
				}
				closeStatement( pstmt_insert );
				// PH_MEDN_ADMIN
				String verf_reqd_bef_med_admin_yn	=	"";
				ArrayList unique_drugs				= new ArrayList(4);
				int dosage_seqNo					=	0;
				
				closeResultSet( resultSet );
				closeStatement( pstmt_select_2 );

				pstmt_select_2	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
				pstmt_select_2.setString(1, login_facility_id);
				resultSet		= pstmt_select_2.executeQuery();
				if (resultSet.next()) {
					verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				}
			
				closeResultSet( resultSet );
				closeStatement( pstmt_select_2 );
				pstmt_delete=connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_DELETE_MEDN_ADMIN"));
				pstmt_delete.setString(1, order_id);
				pstmt_delete.setString(2, login_facility_id);
				pstmt_delete.executeUpdate();
				closeStatement( pstmt_delete );
				
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));
				for(int i=0; i<AllFluids.size(); i++ ) {
					record		=	(HashMap)AllFluids.get(i);		
					count		=	0;
					order_uom=(String)order_uoms.get(i);
					//buildMAR_yn = record.get("BUILD_MAR_YN")==null?"":(String)record.get("BUILD_MAR_YN"); RUT-CRF-0062 Commented. BUILD_MAR_YN Value will be inserted based on the first fluid selected
					if(buildMAR_yn.equals("Y")){
						if(!unique_drugs.contains((String)record.get("DRUG_CODE"))) {
							unique_drugs.add((String)record.get("DRUG_CODE"));
							dosage_seqNo	=	0;
						}

						pstmt_insert.setString(++count, login_facility_id);	//FACILITY_ID
						pstmt_insert.setString(++count, encounter_id);		//ENCOUNTER_ID
						pstmt_insert.setString(++count, (String)record.get("START_DATE"));			//SCH_DATE_TIME
						pstmt_insert.setString(++count, (String)record.get("DRUG_CODE")); //ORD_DRUG_CODE
						pstmt_insert.setString(++count, ++dosage_seqNo+ "");				// DOSAGE SEQ No
						pstmt_insert.setString(++count, order_id);				//ORDER_ID
						pstmt_insert.setString(++count, (i+1)+"");				// ORDER LINE NUM
						pstmt_insert.setString(++count, patient_id);				//PATIENT_ID
						pstmt_insert.setString(++count, pract_id);				//PRACT_ID
						pstmt_insert.setString(++count, "Y");					//IV_ADMIN_YN
						pstmt_insert.setString(++count, "");
						pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));			//SCH_DOSAGE_QTY
						System.out.println("--->QTY_VALUE"+(String)record.get("QTY_VALUE"));
						pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));				//SCH_DOSAGE_UOM_CODE
						pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE")); //SCH_STRENGTH
						pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM")); //SCH_STRENGTH_UOM
						pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));   //SCH_ROUTE_CODE 
						pstmt_insert.setString(++count, (String)record.get("INFUSION_RATE")); //SCH_INFUSION_RATE
						pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));		//SCH_INFUSION_VOL_STR_UNIT
						pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));  //SCH_INFUSION_PER_UNIT
						pstmt_insert.setString(++count, verf_reqd_bef_med_admin_yn);
						pstmt_insert.setString(++count, login_by_id);
						pstmt_insert.setString(++count, login_at_ws_no);
						pstmt_insert.setString(++count, login_facility_id);
						pstmt_insert.setString(++count, login_by_id);
						pstmt_insert.setString(++count, login_at_ws_no);
						pstmt_insert.setString(++count, login_facility_id);
						pstmt_insert.setString(++count, (String)record.get("INFUSE_OVER"));
						pstmt_insert.setString(++count, record.get("INFUSE_OVER_UNIT")==null?"H":(String)record.get("INFUSE_OVER_UNIT"));//SCH_INFUSION_PERIOD_UNIT
						pstmt_insert.setString(++count, record.get("MAR_BARCODE_ID")==null?"H":(String)record.get("MAR_BARCODE_ID"));//SCH_INFUSION_PERIOD_UNIT
						pstmt_insert.addBatch();
					}
				}

				int[] batch_result3 = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result3.length; i++ ) {

					if (batch_result3[i]<0  && batch_result3[i] != -2) {
						pstmt_insert.cancel();
						System.err.println("IV_FLUID(AMEND)--> ERROR IN PH_MEDN_ADMIN UPDATION batch_result["+i+"]= "+batch_result[i]);
						System.err.println("tabData=== "+tabData);
						throw new Exception("PH Medn admin Failed");
					}
				}

				// OR_ORDER_COMMENT
				String action_seq_num		= "";

				pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_select.setString(1, order_id);
				resultSet		= pstmt_select.executeQuery();
				if(resultSet.next()) {
					action_seq_num = resultSet.getString(1);
				}
				
				closeResultSet( resultSet );
				closeStatement( pstmt_select );

				pstmt_delete=connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_DELETE_OR_ORDER_COMMENT"));
				pstmt_delete.setString(1, order_id);
				pstmt_delete.setString(2, action_seq_num);
				pstmt_delete.executeUpdate();
				closeStatement( pstmt_delete );

				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_insert.setString(1, order_id);
				pstmt_insert.setString(2, action_seq_num);
				pstmt_insert.setString(3, login_by_id);
				pstmt_insert.setString(4, login_at_ws_no);
				pstmt_insert.setString(5, login_facility_id);
				pstmt_insert.setString(6, login_by_id);
				pstmt_insert.setString(7, login_at_ws_no);
				pstmt_insert.setString(8, login_facility_id);
				result = pstmt_insert.executeUpdate();
				if(result>0){
					pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,action_seq_num);
					ResultSet rset_clob =pstmt_clob.executeQuery();
					if(rset_clob!=null){
						while(rset_clob.next()){
							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(remarks,0,remarks.length());
							bw.flush();
							bw.close();
						}
					}					
					closeResultSet( rset_clob );
					closeStatement( pstmt_clob );
				}
				closeStatement( pstmt_insert );
			}
			map.put("result", new Boolean(true));
			map.put("msgid", "RECORD_INSERTED");
			connection.commit();
		}
		catch(Exception e) {
			try {
				connection.rollback();
				throw new EJBException(this + " : " + e.getMessage());
			}
			catch (Exception ee) {

				map.put("msgid", ee.getMessage());
			}
			map.put("msgid", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement(pstmt_insert		);
				closeStatement(pstmt_select		);
				closeStatement(pstmt_select_2	);
				closeStatement(pstmt_clob);
				closeStatement(pstmt_delete);
				closeStatement(pstmt_select2);
				closeStatement(pstmt_select3);
				closeConnection(connection, (Properties)tabData.get("PROPERTIES"));
				
			}
			catch(Exception fe) {
				fe.printStackTrace();
			}
		}
		return map;
	}
}
