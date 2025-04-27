/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.OncologyRegimen;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
//import ePH.Common.PhEJBSessionAdapter ;
import oracle.sql.*;
import java.io.*;


/**
*
* @ejb.bean
*	name="OncologyRegimen"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OncologyRegimen"
*	local-jndi-name="OncologyRegimen"
*	impl-class-name="ePH.OncologyRegimen.OncologyRegimenManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.OncologyRegimen.OncologyRegimenLocal"
*	remote-class="ePH.OncologyRegimen.OncologyRegimenRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.OncologyRegimen.OncologyRegimenLocalHome"
*	remote-class="ePH.OncologyRegimen.OncologyRegimenHome"
*	generate= "local,remote"
*
*
*/

public class OncologyRegimenManager extends PhEJBSessionAdapter {

	Properties  prop							=	null;

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

	public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "0");
		map.put("msgid", "INSERT");

		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		PreparedStatement pstmt_insert	= null;
		PreparedStatement pstmt__pres_select19A	= null;
		PreparedStatement pstmt_pres_select55	= null;
		CallableStatement cstmt_insert	= null;
		PreparedStatement pstmt_clob	= null;
		ResultSet rset_clob				= null;
		ResultSet resultSet				= null;
		int result						= 0;
		HashMap drugDetails = null;
		HashMap chkValuescheduleFrequency = null;
		ArrayList frequencyValues =null;
		String ord_auth_reqd_yn, ord_appr_reqd_yn, ord_cosign_reqd_yn, ord_consent_reqd_yn, drug_code, order_id, order_type_code, regn_reqd_yn;

		try {
			HashMap orderDetails	= (HashMap)tabData.get("orderdetails");
			HashMap commonData		= (HashMap)tabData.get("commondata");
			HashMap	scheduleFreq	= (HashMap) tabData.get("schedulefreq");
			HashMap	fluidDetails	= (HashMap)tabData.get("fluiddetails");
			ArrayList drugList		= (ArrayList)tabData.get("drugdetails");
			ArrayList drugRemarks	= (ArrayList)tabData.get("drugremarks");
			ArrayList fluidRemarks	= (ArrayList)tabData.get("fluidremarks");
			//ArrayList diag_Text		= (ArrayList)tabData.get("DIAG_TEXT");

			prop					= (Properties)commonData.get( "properties" );
			String login_by_id		= (String)commonData.get("login_by_id");
			String login_at_ws_no	= (String)commonData.get("login_at_ws_no");
			String login_facility_id= (String)commonData.get("login_facility_id");
			String header_comments	= (String)commonData.get("header_comments");
			String priority		= (String)commonData.get("priority");
			//String height		= (String)commonData.get("height");
			//String height_unit	= (String)commonData.get("height_unit");
			//String weight		= (String)commonData.get("weight");
			//String weight_unit	= (String)commonData.get("weight_unit");
			//String bsa			= (String)commonData.get("bsa");
			//String bsa_unit		= (String)commonData.get("bsa_unit");
			//String th_medn		= (String)commonData.get("th_medn");
			String patient_id	= (String)commonData.get("patient_id");
			String patient_class= (String)commonData.get("patient_class");
			String encounter_id	= (String)commonData.get("encounter_id");
			String pract_id		= (String)commonData.get("pract_id");
			//String pract_name	= (String)commonData.get("pract_name");
			String location_type= (String)commonData.get("locn_type");
			String location_code= (String)commonData.get("locn_code");
			String order_date	= (String)commonData.get("order_date");
			String take_home_medication	= (String)commonData.get("take_home_medication");
			String iv_presc_yn	= (String)commonData.get("iv_presc_yn");
			String catalog_short_desc= (String)commonData.get("catalog_short_desc");

			String drug_desc 	= "";
			String sys_date		= "";
			String ord_status	= "";
			//String freq_nature  = "";
			//String end_date		= "";
			//String ord_date		= "";
			String line_display_text = "";
			String in_qty_value			= "";
			String in_qty_unit			= "";
			String in_order_qty			= "";
			String in_order_uom			= "";
			String in_tot_strength		= "";
			String in_tot_strength_uom	= "";
			String in_bms_qty			= "";
			String in_strength_value	= "";
			String in_strength_uom		= "";
			String in_pres_qty_value	= "";
			String in_pres_qty_uom		= "";
			//String conv_factor			= "";

			String dosage_type			= "";
			String qty_value			= "";
			String qty_unit				= "";
			String repeat_value			= "";
			String durn_value			= "";
			String durn_desc			= "";
			String strength_value		= "";
			String strength_uom			= "";
			String pres_base_uom		= "";
			String strength_per_pres_uom= "";
			String strength_per_value_pres_uom = "";
			String equal_value			= "";
			String comb_ord_qty 		= "";
			String equl_value			= "";

			String dose					= "";
			String dose_calc			= "";
			String amend_stock_value	= "";
			String amend_stock_uom		= "";
			String amend_durn_value 	= "0";
			String amend_infusion_period_value = "";
			String amend_infusion_period_uom = "";
			String amend_durn_unit 		= "";
			String amend_end_date 		= "";
			String amend_start_date 	= "";
			String amend_frequency 		= "";
			String amend_sched_medn_yn 	= "";

			String amend_repeat_value	= "";
			String amend_calc_unit		= "";

			String auth_yn_val			= "N", approval_yn_val = "N";
			String cosign_yn_val		= "N";

			//float order_unit_ratio 		= 0.0f;
			//int rep_interval			= 0;
			//int int_value 				= 0;
			int line_no 				= 0;
			float ord_qty				= 0.0f;
			float ord_qty_value			= 0.0f;
			float fluid_qty     		= 0.0f;
			float fluid_qty_value		= 0.0f;
			int total_line_num			= 0;
			connection					= getConnection(prop) ;
			connection.setAutoCommit(false);
			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT54"));
			resultSet		= pstmt_select.executeQuery();

			if (resultSet.next()) {
				sys_date = resultSet.getString(1);
			}
			closeStatement( pstmt_select ) ;
			closeResultSet( resultSet ) ;
			closeStatement( cstmt_insert ) ;
			cstmt_insert = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
			cstmt_insert.setString(1, login_facility_id);
			cstmt_insert.setString(2, location_type);
			cstmt_insert.setString(3, location_code);
			cstmt_insert.setString(4, take_home_medication);
			cstmt_insert.setString(5, priority);
			cstmt_insert.registerOutParameter(6, Types.VARCHAR);
			cstmt_insert.registerOutParameter(7, Types.VARCHAR);
			cstmt_insert.execute();

			String perf_locn_code	= cstmt_insert.getString(6);
			//String perf_locn_type	= cstmt_insert.getString(7); unsed local variable  63877 //COMMENTED FOR COMMON-ICN-0048
			HashMap orderStatusCode	= new HashMap();
			
			closeStatement( pstmt_select ) ;
			closeResultSet( resultSet ) ;
			resultSet		= null;
			pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT20A"));
			resultSet		= pstmt_select.executeQuery();

			while (resultSet.next()) {
				orderStatusCode.put(resultSet.getString("ORDER_STATUS_TYPE"),resultSet.getString("ORDER_STATUS_CODE"));
			}
			closeResultSet( resultSet ) ; //3/21/2021
			closeStatement( pstmt_insert ) ;
			pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT1"));
			ArrayList temp = drugList;
			HashMap tempMap = null;
			if (temp!=null && temp.size() != 0) {
				closeStatement( pstmt_select ) ;
				pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT19A"));
				for (int i=0; i<temp.size(); i++) {
					tempMap = (HashMap)temp.get(i);
					if (tempMap!=null && tempMap.size() != 0) {
						drug_desc += tempMap.get("DRUG_DESC").toString() + "|";
						drug_code		= (String)tempMap.get("DRUG_CODE");
						order_id			= orderDetails.get("ORDER_ID"+drug_code).toString();
						order_type_code	= tempMap.get("ORDER_TYPE_CODE").toString();
						ord_auth_reqd_yn = "N";
						ord_appr_reqd_yn = "N";
						ord_cosign_reqd_yn="N";
						regn_reqd_yn		= "N";
						ord_consent_reqd_yn="N";
						auth_yn_val				  ="N";
						approval_yn_val			  ="N";
						cosign_yn_val			  ="N";

						resultSet		= null;
						//pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT19A"));
						pstmt_select.setString(1, order_type_code);
						resultSet		= pstmt_select.executeQuery();

						if (resultSet.next()) {
							regn_reqd_yn = resultSet.getString(1);
						}
						if (tempMap.get("ORD_AUTH_REQD_YN").toString().equals("Y"))
							ord_auth_reqd_yn = "Y";

						if (tempMap.get("ORD_SPL_APPR_REQD_YN").toString().equals("Y"))
							ord_appr_reqd_yn = "Y";

						if (tempMap.get("ORD_COSIGN_REQD_YN").toString().equals("Y"))
							ord_cosign_reqd_yn = "Y";

						if (tempMap.get("CONSENT_REQD_YN").toString().equals("Y"))
							ord_consent_reqd_yn = "Y";

						if (tempMap.get("auth_yn_val").toString().equals("Y"))
							auth_yn_val 	= "Y";
						if (tempMap.get("approval_yn_val").toString().equals("Y"))
							approval_yn_val 	= "Y";
						if (tempMap.get("cosign_yn_val").toString().equals("Y"))
							cosign_yn_val 	= "Y";

						// Logic for the order Status
						/*if( (ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("N")) && (ord_cosign_reqd_yn.equals("N")) ){
							ord_status="10";
						}else if((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("N")) && (ord_cosign_reqd_yn.equals("Y"))){
							if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")))
								ord_status	=	"10";
							else
								ord_status	=	"00";
						}else if ((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("Y")) && (ord_cosign_reqd_yn.equals("N"))) {
							if(approval_yn_val!=null && approval_yn_val.equals("Y"))
								ord_status	=	"10";
							else
								ord_status	=	"05";
						}else if ((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("N")) && (ord_cosign_reqd_yn.equals("N"))) {
							if(auth_yn_val!=null && auth_yn_val.equals("Y"))
								ord_status	=	"10";
							else
								ord_status	="03";
						}
						else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("Y")) && (ord_cosign_reqd_yn.equals("N"))){
							if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ){
								ord_status="10";
							}
							else if(approval_yn_val!=null && approval_yn_val.equals("Y")){
								ord_status="05";
							}else if(auth_yn_val!=null && auth_yn_val.equals("Y")){
								ord_status="03";
							} else {
								ord_status="03";
							}
						}else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("N")) && (ord_cosign_reqd_yn.equals("Y"))){
							if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val	.equals("Y")) ){
								ord_status="10";
							}else if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y"))){
								ord_status="03";
							}else if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) ){
								ord_status="00";
							}else {
								ord_status="00";
							}
						}else if((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("Y")) && (ord_cosign_reqd_yn.equals("Y"))){
							if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) ){
								ord_status="10";
							}else {
								ord_status="05";
							}
						} else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("Y")) && (ord_cosign_reqd_yn.equals("Y"))) {
							if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")) && (approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y"))) {
								ord_status	=	"10";
							}
							else if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")) && (approval_yn_val!=null) && (approval_yn_val.equals("Y")) ) {
								ord_status	=	"03";
							}
							else if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ) {
								ord_status	=	"05";
							}
							else if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ) {
								ord_status	=	"10";
							}
							else {
									ord_status	=	"03";
								}
						}
						*/
						if( (ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("N"))){
							ord_status="10";
						}
						else if ((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("Y"))) {
							if(approval_yn_val!=null && approval_yn_val.equals("Y"))
								ord_status	=	"10";
							else
								ord_status	=	"05";
						}
						else if ((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("N"))) {
							if(auth_yn_val!=null && auth_yn_val.equals("Y"))
								ord_status	=	"10";
							else
								ord_status	="03";
						}
						else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("Y"))){
							if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ){
								ord_status="10";
							}
							else if(approval_yn_val!=null && approval_yn_val.equals("Y")){
								ord_status="03";
							}
							else {
								ord_status="05";
							}
						}
						if(tempMap.get("CONSENT_REQD_YN").equals("Y") && tempMap.get("CONSENT_STAGE").equals("A")){
							ord_status = "00"; //PC - Pending consent
						}

						//Hdr Insertion
						pstmt_insert.setString(1, order_id);
						pstmt_insert.setString(2, order_type_code);

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
						pstmt_insert.setString(13, "");
						pstmt_insert.setString(14, order_date);
						pstmt_insert.setString(15, pract_id);
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
						pstmt_insert.setString(31, login_facility_id);
						pstmt_insert.setString(32, "PH");
						pstmt_insert.setString(33, location_type);
						pstmt_insert.setString(34, perf_locn_code);
						pstmt_insert.setString(35, pract_id);
						pstmt_insert.setString(36, "N");
						pstmt_insert.setString(37, "N");
						pstmt_insert.setString(38, "");
						pstmt_insert.setString(39, "Y");
						pstmt_insert.setString(40, "");
						if(iv_presc_yn.equals("Y"))
							pstmt_insert.setString(41, "C");
						else
							pstmt_insert.setString(41, "");
						pstmt_insert.setString(42, "");
						if(ord_status.equals("10") || ord_status.equals("25")) {
							if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y"))
								ord_status="25";
							else
								ord_status="10";
						}

						if(ord_status.equals("03"))
							ord_status = (String)orderStatusCode.get("03");
						else if(ord_status.equals("05"))
							ord_status =(String) orderStatusCode.get("05");
						else if(ord_status.equals("10"))
							ord_status =(String) orderStatusCode.get("10");
						else if(ord_status.equals("25"))
							ord_status = (String)orderStatusCode.get("25");
						else if(ord_status.equals("00"))
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

						if (ord_consent_reqd_yn.equals("Y")) {
							pstmt_insert.setString(52, pract_id);
							pstmt_insert.setString(53, sys_date);
						}
						else {
							pstmt_insert.setString(52, "");
							pstmt_insert.setString(53, null);
						}
						pstmt_insert.setString(54, "");
						pstmt_insert.addBatch();
					}
				}
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
			// Header Level Comments
			//String header_comments = getPresRemarks();
			if (header_comments!=null && header_comments.length() > 0 && temp!=null && temp.size() != 0) {
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_clob ) ;
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
				tempMap = null;
				Clob clb = null;
				BufferedWriter bw = null;
				for (int i=0; i<temp.size(); i++) {
					tempMap = (HashMap)temp.get(i);
					if (tempMap!=null && tempMap.size() != 0) {
						drug_code		= (String)tempMap.get("DRUG_CODE");
						order_id			= orderDetails.get("ORDER_ID"+drug_code).toString();

						//pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT5"));
						pstmt_insert.setString(1, order_id);
						pstmt_insert.setString(2, "1"); // For Insert it will be "1"
						pstmt_insert.setString(3, login_by_id);
						pstmt_insert.setString(4, login_at_ws_no);
						pstmt_insert.setString(5, login_facility_id);
						pstmt_insert.setString(6, login_by_id);
						pstmt_insert.setString(7, login_at_ws_no);
						pstmt_insert.setString(8, login_facility_id);
						result = pstmt_insert.executeUpdate();
						if(result > 0 ){
							//pstmt_clob		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT57"));
							pstmt_clob.setString(1,order_id);
							pstmt_clob.setString(2,"1"); // Action_seq_num
							rset_clob=pstmt_clob.executeQuery();

							if(rset_clob!=null){
								while(rset_clob.next()){
									clb 			= (Clob) rset_clob.getClob(1);
									bw 	= new BufferedWriter(clb.setCharacterStream(0));
									bw.write(header_comments,0,header_comments.length());
									bw.flush();
									bw.close();
								}
								result = 1;
							}
						}
					}
					closeResultSet( rset_clob ) ;
				}
			}
			// Insertion in or_order_line
			if (result>0) {
				closeStatement( pstmt_insert ) ;
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT2"));
				pstmt_insert.clearBatch();

				if(drugList!=null && drugList.size() > 0){
					closeStatement( pstmt__pres_select19A ) ;
					closeStatement( pstmt_select ) ;
					pstmt__pres_select19A	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT19A"));
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
					HashMap tempFluidMap = null;
					for(int j=0;j<drugList.size();j++) {
						drugDetails = (HashMap)drugList.get(j);
						if (drugDetails!=null && drugDetails.size() != 0) {
							line_no = 0;
							auth_yn_val = "N" ;
							approval_yn_val = "N";
							cosign_yn_val = "N";
							ord_auth_reqd_yn = "N";
							ord_appr_reqd_yn = "N";
							ord_cosign_reqd_yn="N";
							ord_consent_reqd_yn="N";
							drug_code		= (String)drugDetails.get("DRUG_CODE");
							order_id			= orderDetails.get("ORDER_ID"+drug_code).toString();
							order_type_code	= drugDetails.get("ORDER_TYPE_CODE").toString();
							regn_reqd_yn		= "N";
							amend_stock_value= (String)drugDetails.get("amend_stock_value");
							amend_stock_uom = (String)drugDetails.get("amend_stock_uom");
							amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value");
							amend_infusion_period_uom = (String)drugDetails.get("amend_infusion_period_uom");
							amend_durn_value = (String)drugDetails.get("amend_durn_value");
							if(amend_durn_value==null) 
								amend_durn_value = "0";
							amend_durn_unit = (String)drugDetails.get("amend_durn_unit");
							amend_end_date = (String)drugDetails.get("amend_end_date");
							amend_start_date = (String)drugDetails.get("amend_start_date");
							amend_frequency = (String)drugDetails.get("amend_frequency");
							amend_sched_medn_yn = (String)drugDetails.get("amend_sched_medn_yn");

							amend_repeat_value = (String)drugDetails.get("amend_repeat_value");
							amend_calc_unit		=  (String)drugDetails.get("amend_calc_unit");
							equal_value		= (String)drugDetails.get("EQUAL_VALUE");
							dose 			= (String)drugDetails.get("dose");
							if(dose==null) 
								dose = "0";

							closeResultSet( resultSet ) ;
							resultSet		= null;
							//pstmt__pres_select19A	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT19A"));
							pstmt__pres_select19A.setString(1, order_type_code);
							resultSet		= pstmt__pres_select19A.executeQuery();
								if (resultSet.next()) {
								regn_reqd_yn = resultSet.getString(1);
							}

							if (drugDetails.get("ORD_AUTH_REQD_YN").toString().equals("Y"))
								ord_auth_reqd_yn = "Y";

							if (drugDetails.get("ORD_SPL_APPR_REQD_YN").toString().equals("Y"))
								ord_appr_reqd_yn = "Y";

							if (drugDetails.get("ORD_COSIGN_REQD_YN").toString().equals("Y"))
								ord_cosign_reqd_yn = "Y";

							if (drugDetails.get("CONSENT_REQD_YN").toString().equals("Y"))
								ord_consent_reqd_yn = "Y";

							if (drugDetails.get("auth_yn_val").toString().equals("Y"))
								auth_yn_val 	= "Y";
							if (drugDetails.get("approval_yn_val").toString().equals("Y"))
								approval_yn_val 	= "Y";
							if (drugDetails.get("cosign_yn_val").toString().equals("Y"))
								cosign_yn_val 	= "Y";

							// Logic for the order Status
							/*if( (ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("N")) && (ord_cosign_reqd_yn.equals("N")) ){
								ord_status="10";
							}else if((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("N")) && (ord_cosign_reqd_yn.equals("Y"))){
								if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")))
									ord_status	=	"10";
								else
									ord_status	=	"00";
							}else if ((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("Y")) && (ord_cosign_reqd_yn.equals("N"))) {
								if(approval_yn_val!=null && approval_yn_val.equals("Y"))
									ord_status	=	"10";
								else
									ord_status	=	"05";
							}else if ((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("N")) && (ord_cosign_reqd_yn.equals("N"))) {
								if(auth_yn_val!=null && auth_yn_val.equals("Y"))
									ord_status	=	"10";
								else
									ord_status	="03";
							}
							else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("Y")) && (ord_cosign_reqd_yn.equals("N"))){
								if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ){
									ord_status="10";
								}
								else if(approval_yn_val!=null && approval_yn_val.equals("Y")){
									ord_status="05";
								}else if(auth_yn_val!=null && auth_yn_val.equals("Y")){
									ord_status="03";
								} else {
									ord_status="03";
								}
							}else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("N")) && (ord_cosign_reqd_yn.equals("Y"))){
								if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val	.equals("Y")) ){
									ord_status="10";
								}else if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y"))){
									ord_status="03";
								}else if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) ){
									ord_status="00";
								}else {
									ord_status="00";
								}
							}else if((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("Y")) && (ord_cosign_reqd_yn.equals("Y"))){
								if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) ){
									ord_status="10";
								}else {
									ord_status="05";
								}
							} else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("Y")) && (ord_cosign_reqd_yn.equals("Y"))) {
								if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")) && (approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y"))) {
									ord_status	=	"10";
								}
								else if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")) && (approval_yn_val!=null) && (approval_yn_val.equals("Y")) ) {
									ord_status	=	"03";
								}
								else if((cosign_yn_val!=null) && (cosign_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ) {
									ord_status	=	"05";
								}
								else if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ) {
									ord_status	=	"10";
								}
								else {
										ord_status	=	"03";
									}
							}
							*/
							if( (ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("N"))){
								ord_status="10";
							}
							else if ((ord_auth_reqd_yn.equals("N")) && (ord_appr_reqd_yn.equals("Y"))) {
								if(approval_yn_val!=null && approval_yn_val.equals("Y"))
									ord_status	=	"10";
								else
									ord_status	=	"05";
							}
							else if ((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("N"))) {
								if(auth_yn_val!=null && auth_yn_val.equals("Y"))
									ord_status	=	"10";
								else
									ord_status	="03";
							}
							else if((ord_auth_reqd_yn.equals("Y")) && (ord_appr_reqd_yn.equals("Y"))){
								if((approval_yn_val!=null) && (approval_yn_val.equals("Y")) && (auth_yn_val!=null) && (auth_yn_val.equals("Y")) ){
									ord_status="10";
								}
								else if(approval_yn_val!=null && approval_yn_val.equals("Y")){
									ord_status="03";
								}
								else {
									ord_status="05";
								}
							}
							if(drugDetails.get("CONSENT_REQD_YN").equals("Y") && drugDetails.get("CONSENT_STAGE").equals("A")){
								ord_status = "00"; //PC - Pending consent
							}
							if(ord_status.equals("10") || ord_status.equals("25")) {
								if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y"))
										ord_status="25";
								else
										ord_status="10";
								}

							if(ord_status.equals("03"))
								ord_status = (String)orderStatusCode.get("03");
							else if(ord_status.equals("05"))
								ord_status =(String) orderStatusCode.get("05");
							else if(ord_status.equals("10"))
								ord_status =(String) orderStatusCode.get("10");
							else if(ord_status.equals("25"))
								ord_status = (String)orderStatusCode.get("25");
							else if(ord_status.equals("00"))
								ord_status = (String)orderStatusCode.get("00");

							// If Fluid Details are there add it
							if (fluidDetails!=null && fluidDetails.size() != 0) {
								tempFluidMap = (HashMap)fluidDetails.get(drug_code);
								if (tempFluidMap!=null && tempFluidMap.size() != 0) {
									if(tempFluidMap.size() > 0 ){
										strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
										pres_base_uom	= (String)tempFluidMap.get("PRES_BASE_UOM");
										strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
										strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
										dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE");

										if(strength_per_value_pres_uom==null) 
											strength_per_value_pres_uom = "0";
										if(strength_per_pres_uom==null) 
											strength_per_pres_uom = "0";
										if(repeat_value==null) 
											repeat_value = "0";

										closeResultSet( resultSet ) ;
										resultSet			= null;
										//pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
										pstmt_select.setString(1, amend_frequency);
										pstmt_select.setString(2, dose);
										pstmt_select.setString(3, amend_stock_value);
										pstmt_select.setString(4, amend_durn_value);
										resultSet	= pstmt_select.executeQuery();

										if (resultSet.next()) {
											comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
										}
										if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
											StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
											while(stQty.hasMoreTokens()){
												ord_qty				  =  Float.parseFloat(stQty.nextToken());
												ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
												fluid_qty			  =  Float.parseFloat(stQty.nextToken());
												fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
											}
										}
										if(ord_qty==0) 
											ord_qty = 0.0f;
										if(ord_qty_value==0) 
											ord_qty_value = 0.0f;
										if(fluid_qty==0) 
											fluid_qty = 0.0f;
										if(fluid_qty_value==0) 
											fluid_qty_value = 0.0f;

										pstmt_insert.setString(1, order_id);
										line_no++;
										total_line_num++;
										pstmt_insert.setString(2, String.valueOf(line_no));
										pstmt_insert.setString(3, (String)tempFluidMap.get("DRUG_CODE"));
										pstmt_insert.setString(4, (String)tempFluidMap.get("SHORT_DESC"));
										pstmt_insert.setString(5, (String)tempFluidMap.get("SHORT_DESC"));
										pstmt_insert.setString(6, "");
										pstmt_insert.setString(7, (String)tempFluidMap.get("ORDER_TYPE_CODE"));
										pstmt_insert.setString(8, "PH");
										pstmt_insert.setString(9, amend_start_date);
										pstmt_insert.setString(10, priority);
										pstmt_insert.setString(11, ord_auth_reqd_yn);
										pstmt_insert.setString(12, "");
										pstmt_insert.setString(13, ord_consent_reqd_yn);
										pstmt_insert.setString(14, ord_cosign_reqd_yn);
										pstmt_insert.setString(15, amend_start_date);
										pstmt_insert.setString(16, (String)tempFluidMap.get("FORM_CODE"));
										pstmt_insert.setString(17, (String)tempFluidMap.get("ROUTE_CODE"));

										in_qty_value	= String.valueOf(fluid_qty_value);
										in_qty_unit 	= pres_base_uom ;

										if(in_qty_value==null) in_qty_value	= "";
										if(in_qty_unit==null) in_qty_unit	= "";
										ord_qty				= fluid_qty;
										in_order_uom	= in_qty_unit;
										equl_value		= "";

										pstmt_insert.setString(18, in_qty_value);
										pstmt_insert.setString(19, in_qty_unit);
										pstmt_insert.setString(20, amend_frequency);
										pstmt_insert.setString(21, amend_durn_value);
										pstmt_insert.setString(22, amend_durn_unit);
										line_display_text		= "";
										if (drugRemarks!=null && drugRemarks.size() > 0) {
											HashMap DrugValues = (HashMap)drugRemarks.get(0);
											line_display_text = (String)DrugValues.get("order_format_values");
											if(line_display_text.length() > 499)
												line_display_text = line_display_text.substring(0,499);
										}
										else {
											line_display_text = "";
										}
										pstmt_insert.setString(23, line_display_text);
										pstmt_insert.setString(24, "");
										pstmt_insert.setString(25, null);
										pstmt_insert.setString(26, amend_end_date);

										pstmt_insert.setString(27, null);
										pstmt_insert.setString(28, String.valueOf(ord_qty));
										pstmt_insert.setString(29, in_order_uom);
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

										pstmt_insert.setString(66,  ord_consent_reqd_yn);
										pstmt_insert.setString(67, "");
										catalog_short_desc = (String)tempFluidMap.get("DRUG_DESC");
										if(catalog_short_desc==null || catalog_short_desc.equals(""))
											catalog_short_desc	= "";
										//pstmt_insert.setString(68, (String)tempFluidMap.get("DRUG_DESC"));
										pstmt_insert.setString(68, catalog_short_desc);
										pstmt_insert.setString(69, catalog_short_desc);
										//pstmt_insert.setString(69, (String)tempFluidMap.get("DRUG_DESC"));
										pstmt_insert.setString(70, "N");
										pstmt_insert.addBatch();
									}
								}
							}

							dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							qty_value		= (String)drugDetails.get("QTY_VALUE");
							qty_unit		= (String)drugDetails.get("QTY_DESC_CODE");
							repeat_value	= (String)drugDetails.get("REPEAT_VALUE");
							if(repeat_value==null) repeat_value = "0";
							durn_value		= (String)drugDetails.get("DURN_VALUE");
							durn_desc		= (String)drugDetails.get("DURN_TYPE");
							strength_value	= (String)drugDetails.get("ACT_STRENGTH_VALUE");
							strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
							pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM");
							strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");

							if(strength_per_value_pres_uom==null) 
								strength_per_value_pres_uom = "0";
							if(strength_per_pres_uom==null) 
								strength_per_pres_uom = "0";
							if(repeat_value==null) 
								repeat_value = "0";
							// For Drug Based
							if (dosage_type.equals("Q")) {
								dose	= dose;
							}
							else if (dosage_type.equals("S")) {
								if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0"))
									dose	= String.valueOf( Math.ceil( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) )));
								if(dose!=null && !dose.equals("")){
									in_qty_value = String.valueOf(dose);
									in_order_qty =  String.valueOf( Math.ceil( ((Double.parseDouble(dose)) * (Double.parseDouble(amend_durn_value))))  );
								}
							}
							if (dosage_type.equals("Q")) {

								closeResultSet( resultSet ) ;
								resultSet			= null;
								//	pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
								pstmt_select.setString(1, amend_frequency);
								pstmt_select.setString(2, dose);
								pstmt_select.setString(3, amend_stock_value);
								pstmt_select.setString(4, amend_durn_value);
								resultSet	= pstmt_select.executeQuery();

								if (resultSet.next()) {
									comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
								}
								if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
									StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
									while(stQty.hasMoreTokens()){
										ord_qty				  =  Float.parseFloat(stQty.nextToken());
										ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
										fluid_qty			  =  Float.parseFloat(stQty.nextToken());
										fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
									}
								}
								if(ord_qty==0) 
									ord_qty 					= 0.0f;
								if(ord_qty_value==0) 
									ord_qty_value 		= 0.0f;
								if(fluid_qty==0) 
									fluid_qty 				= 0.0f;
								if(fluid_qty_value==0) 
									fluid_qty_value 	= 0.0f;
							}

							line_no++;
							total_line_num++;

							pstmt_insert.setString(1, order_id);
							pstmt_insert.setString(2, String.valueOf(line_no));
							pstmt_insert.setString(3, (String)drugDetails.get("DRUG_CODE"));
							pstmt_insert.setString(4, (String)drugDetails.get("SHORT_DESC"));
							pstmt_insert.setString(5, (String)drugDetails.get("SHORT_DESC"));
							pstmt_insert.setString(6, "");
							pstmt_insert.setString(7, (String)drugDetails.get("ORDER_TYPE_CODE"));
							pstmt_insert.setString(8, "PH");
							pstmt_insert.setString(9, amend_start_date);
							pstmt_insert.setString(10, priority);
							pstmt_insert.setString(11, (String)drugDetails.get("ORD_AUTH_REQD_YN"));
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, (String)drugDetails.get("ORD_SPL_APPR_REQD_YN"));
							pstmt_insert.setString(14, (String)drugDetails.get("ORD_COSIGN_REQD_YN"));
							pstmt_insert.setString(15, amend_start_date);
							pstmt_insert.setString(16, (String)drugDetails.get("FORM_CODE"));
							pstmt_insert.setString(17, (String)drugDetails.get("ROUTE_CODE"));

							if (dosage_type.equals("Q"))
								in_qty_value	= String.valueOf(ord_qty_value);
							in_qty_unit 	= pres_base_uom ;

							if(in_qty_value==null)
								in_qty_value	= "";
							if(in_qty_unit==null) 
								in_qty_unit	= "";
							ord_qty				= ord_qty;
							in_order_uom	= in_qty_unit;
							equl_value		= "";

							pstmt_insert.setString(18, in_qty_value);
							pstmt_insert.setString(19, in_qty_unit);
							pstmt_insert.setString(20, amend_frequency);
							//pstmt_insert.setString(21, (String)orderDetails.get("DURN_VALUE"));
							//pstmt_insert.setString(22, (String)orderDetails.get("DURN_UNIT"));
							pstmt_insert.setString(21, amend_durn_value);
							pstmt_insert.setString(22, amend_durn_unit);

							line_display_text		= "";
							if (drugRemarks!=null && drugRemarks.size() > 0) {
								if (drugRemarks.size() > j) {
									HashMap DrugValues = (HashMap)drugRemarks.get(j);
									line_display_text = (String)DrugValues.get("order_format_values");
									if(line_display_text.length() > 499)
										line_display_text = line_display_text.substring(0,499);
								}
								else {
									line_display_text = "";
								}
							}	
							else {
								line_display_text = "";
							}

							pstmt_insert.setString(23, line_display_text);
							pstmt_insert.setString(24, "");
							pstmt_insert.setString(25, null);
							pstmt_insert.setString(26, amend_end_date);
							pstmt_insert.setString(27, null);
							if(dosage_type.equals("S"))
								pstmt_insert.setString(28, String.valueOf(in_order_qty));
							else
								pstmt_insert.setString(28, String.valueOf(ord_qty));
							pstmt_insert.setString(29, in_order_uom);
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

							catalog_short_desc = (String)drugDetails.get("DRUG_DESC");
							if(catalog_short_desc==null || catalog_short_desc.equals(""))
							catalog_short_desc	= "";
							//pstmt_insert.setString(68, (String)drugDetails.get("DRUG_DESC"));
							pstmt_insert.setString(68, catalog_short_desc);
							pstmt_insert.setString(69, catalog_short_desc);
							pstmt_insert.setString(70, "N");
							pstmt_insert.addBatch();
						}
					}
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
			}

			if (result>0) {
				closeStatement( pstmt_insert ) ;
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT3"));
				pstmt_insert.clearBatch();
				if(drugList!=null && drugList.size() > 0) {
					closeStatement( pstmt_select ) ;
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
					HashMap tempFluidMap = null;
					StringTokenizer stQty = null;
					for(int j=0;j<drugList.size();j++) {
						drugDetails = (HashMap)drugList.get(j);
						if(drugDetails!=null && drugDetails.size() > 0){
							line_no = 0;
							drug_code		= (String)drugDetails.get("DRUG_CODE");
							order_id			= orderDetails.get("ORDER_ID"+drug_code).toString();

							dose 			= (String)drugDetails.get("dose");
							if(dose==null) 
								dose = "0";
							amend_stock_value= (String)drugDetails.get("amend_stock_value");
							amend_stock_uom  = (String)drugDetails.get("amend_stock_uom");
							amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value");
							amend_infusion_period_uom = (String)drugDetails.get("amend_infusion_period_uom");
							amend_durn_value = (String)drugDetails.get("amend_durn_value");
							if(amend_durn_value==null)
								amend_durn_value = "0";
							amend_durn_unit = (String)drugDetails.get("amend_durn_unit");
							amend_end_date = (String)drugDetails.get("amend_end_date");
							amend_start_date = (String)drugDetails.get("amend_start_date");
							amend_frequency = (String)drugDetails.get("amend_frequency");
							amend_sched_medn_yn = (String)drugDetails.get("amend_sched_medn_yn");

							amend_repeat_value	= (String)drugDetails.get("amend_repeat_value");
							amend_calc_unit	= (String)drugDetails.get("amend_calc_unit");

							if (fluidDetails!=null  && fluidDetails.size() != 0) {
								tempFluidMap = (HashMap)fluidDetails.get(drug_code);

								if (tempFluidMap!=null && tempFluidMap.size() != 0) {
									if(tempFluidMap.size() > 0 ){
										dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE");
										qty_value		= (String)tempFluidMap.get("QTY_VALUE");
										qty_unit		= (String)tempFluidMap.get("QTY_DESC_CODE");
										repeat_value	= (String)tempFluidMap.get("REPEAT_VALUE");
										durn_value		= (String)tempFluidMap.get("DURN_VALUE");
										durn_desc		= (String)tempFluidMap.get("DURN_TYPE");
										strength_value	= (String)tempFluidMap.get("ACT_STRENGTH_VALUE");
										strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
										pres_base_uom	= (String)tempFluidMap.get("PRES_BASE_UOM");
										strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
										strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");

										equal_value		= (String)tempFluidMap.get("EQUAL_VALUE");

										if(strength_per_value_pres_uom==null) 
											strength_per_value_pres_uom = "0";
										if(strength_per_pres_uom==null) 
											strength_per_pres_uom = "0";
										if(repeat_value==null) 
											repeat_value = "0";
										closeResultSet( resultSet ) ;
										resultSet			= null;
										//pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
										pstmt_select.setString(1, amend_frequency);
										pstmt_select.setString(2, dose);
										pstmt_select.setString(3, amend_stock_value);
										pstmt_select.setString(4, amend_durn_value);
										resultSet	= pstmt_select.executeQuery();

										if (resultSet.next()) {
											comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
										}
										if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
											stQty = new StringTokenizer(comb_ord_qty,"#");
											while(stQty.hasMoreTokens()){
												ord_qty				  =  Float.parseFloat(stQty.nextToken());
												ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
												fluid_qty			  =  Float.parseFloat(stQty.nextToken());
												fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
											}
										}
										if(ord_qty==0) 
											ord_qty 					= 0.0f;
										if(ord_qty_value==0) 
											ord_qty_value 		= 0.0f;
										if(fluid_qty==0) 
											fluid_qty 				= 0.0f;
										if(fluid_qty_value==0) 
											fluid_qty_value 	= 0.0f;

										in_qty_value	= String.valueOf(fluid_qty_value);
										in_qty_unit 	= pres_base_uom ;

										if(in_qty_value==null) in_qty_value	= "";
										if(in_qty_unit==null) in_qty_unit	= "";
										ord_qty				= fluid_qty;
										in_order_uom		= in_qty_unit;
										equl_value			= "";
										//Only Quantity based for Fluid
										in_tot_strength		= ""; // for Qty_based
										in_tot_strength_uom	= ""; // for Qty_based
										in_bms_qty			= String.valueOf(ord_qty)	; //Equivalent to qty_value
										in_strength_value	= in_tot_strength;
										in_strength_uom		= in_tot_strength_uom;

										in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
										in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit

										pstmt_insert.setString(1, order_id);
										pstmt_insert.setInt(2, ++line_no);
										pstmt_insert.setString(3, (String)tempFluidMap.get("GENERIC_ID"));
										pstmt_insert.setString(4, (String)tempFluidMap.get("FORM_CODE"));
										pstmt_insert.setString(5, "");
										pstmt_insert.setString(6, "N");
										pstmt_insert.setString(7, (String)tempFluidMap.get("DOSAGE_TYPE"));
										pstmt_insert.setString(8, "");
										pstmt_insert.setString(9, in_tot_strength);
										pstmt_insert.setString(10, in_tot_strength_uom);
										pstmt_insert.setString(11, "");
										pstmt_insert.setString(12, "");
										pstmt_insert.setString(13, "");
										pstmt_insert.setString(14, "");
										pstmt_insert.setString(15, "");
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
										pstmt_insert.setString(27, in_bms_qty);
										pstmt_insert.setString(28, in_tot_strength);
										pstmt_insert.setString(29, login_by_id);
										pstmt_insert.setString(30, login_at_ws_no);
										pstmt_insert.setString(31, login_facility_id);
										pstmt_insert.setString(32, login_by_id);
										pstmt_insert.setString(33, login_at_ws_no);
										pstmt_insert.setString(34, login_facility_id);
										pstmt_insert.setString(35, (String)tempFluidMap.get("SPLIT_DOSE"));

										if (((String)tempFluidMap.get("SPLIT_DOSE")) !=null && ((String)tempFluidMap.get("SPLIT_DOSE")).equals("Y")) {
											pstmt_insert.setString(36, (String)tempFluidMap.get("QTY_VALUE"));
											pstmt_insert.setString(37, "");
											//(String)orderDetails.get("SCH_INFUSION_VOL_STR_UNIT"));
										}
										else {
											pstmt_insert.setString(36, "");
											pstmt_insert.setString(37, "");
										}

										pstmt_insert.setString(38, in_strength_value);
										pstmt_insert.setString(39, in_strength_uom);
										pstmt_insert.setString(40, in_pres_qty_value);
										pstmt_insert.setString(41, in_pres_qty_uom);
										pstmt_insert.setString(42,"");
										//(String)tempFluidMap.get("ALLERGY_REMARKS"));
										pstmt_insert.setString(43, "");
										pstmt_insert.setString(44, "");
										pstmt_insert.addBatch();
									}
								}
							}

							dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							qty_value		= (String)drugDetails.get("QTY_VALUE");
							qty_unit		= (String)drugDetails.get("QTY_DESC_CODE");
							repeat_value	= (String)drugDetails.get("REPEAT_VALUE");
							durn_value		= (String)drugDetails.get("DURN_VALUE");
							durn_desc		= (String)drugDetails.get("DURN_TYPE");
							strength_value	= (String)drugDetails.get("ACT_STRENGTH_VALUE");
							strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
							pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM");
							strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
							equal_value		= (String)drugDetails.get("EQUAL_VALUE");

							// For Drug Based
							if (dosage_type.equals("Q")) {
								dose	= dose;
							}
							else if (dosage_type.equals("S")) {
								if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0"))
									dose_calc	= String.valueOf( Math.ceil( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) )));
								if(dose!=null && !dose.equals("")){
									in_qty_value = String.valueOf(dose_calc);
									in_order_qty =  String.valueOf( Math.ceil(((Double.parseDouble(dose_calc)) * (Double.parseDouble(amend_durn_value))))  );
									in_strength_value	= String.valueOf( Math.ceil( ((Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
									if(in_strength_value!=null)
										in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(amend_durn_value)))));
								}
							}
							if (dosage_type.equals("Q")) {
								closeResultSet( resultSet ) ;
								resultSet			= null;
								//pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
								pstmt_select.setString(1, amend_frequency);
								pstmt_select.setString(2, dose);
								pstmt_select.setString(3, amend_stock_value);
								pstmt_select.setString(4, amend_durn_value);
								resultSet	= pstmt_select.executeQuery();
								if (resultSet.next()) {
									comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
								}
								if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
									stQty = new StringTokenizer(comb_ord_qty,"#");
									while(stQty.hasMoreTokens()){
										ord_qty				  =  Float.parseFloat(stQty.nextToken());
										ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
										fluid_qty			  =  Float.parseFloat(stQty.nextToken());
										fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
									}
								}
								if(ord_qty==0) 
									ord_qty 					= 0.0f;
								if(ord_qty_value==0) 
									ord_qty_value 		= 0.0f;
								if(fluid_qty==0) 
									fluid_qty 				= 0.0f;
								if(fluid_qty_value==0) 
									fluid_qty_value 	= 0.0f;
							}

							if (dosage_type.equals("Q"))
								in_qty_value	= String.valueOf(ord_qty_value);

							in_qty_unit 	= pres_base_uom ;
							if(in_qty_value==null) in_qty_value	= "";
							if(in_qty_unit==null) in_qty_unit	= "";
							ord_qty				= ord_qty;
							in_order_uom	= in_qty_unit;
							equl_value		= "";

							if(dosage_type.equals("Q")) {
								in_tot_strength		= ""; // for Qty_based
								in_tot_strength_uom	= ""; // for Qty_based
								in_bms_qty			= String.valueOf(ord_qty); //Equivalent to qty_value
								in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;
								in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
								in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
							} 
							else if(dosage_type.equals("S")) {
								//in_tot_strength		= in_order_qty;
								in_tot_strength_uom	= strength_uom;
								in_bms_qty			= String.valueOf(in_order_qty); //Equivalent to qty_value
								//in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;
								in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
								in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
							}

							pstmt_insert.setString(1, order_id);
							pstmt_insert.setInt(2, ++line_no);
							pstmt_insert.setString(3, (String)drugDetails.get("GENERIC_ID"));
							pstmt_insert.setString(4, (String)drugDetails.get("FORM_CODE"));
							pstmt_insert.setString(5, "");
							pstmt_insert.setString(6, "N");
							pstmt_insert.setString(7, (String)drugDetails.get("DOSAGE_TYPE"));
							pstmt_insert.setString(8, "");
							pstmt_insert.setString(9, in_tot_strength);
							pstmt_insert.setString(10, in_tot_strength_uom);
							pstmt_insert.setString(11, "");
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, "");
							pstmt_insert.setString(14, "");
							pstmt_insert.setString(15, "");
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
							pstmt_insert.setString(27, in_bms_qty);
							pstmt_insert.setString(28, in_tot_strength);
							pstmt_insert.setString(29, login_by_id);
							pstmt_insert.setString(30, login_at_ws_no);
							pstmt_insert.setString(31, login_facility_id);
							pstmt_insert.setString(32, login_by_id);
							pstmt_insert.setString(33, login_at_ws_no);
							pstmt_insert.setString(34, login_facility_id);
							pstmt_insert.setString(35, (String)drugDetails.get("SPLIT_DOSE"));

							if (((String)drugDetails.get("SPLIT_DOSE")) !=null && ((String)drugDetails.get("SPLIT_DOSE")).equals("Y")) {
								pstmt_insert.setString(36, (String)drugDetails.get("QTY_VALUE"));
								pstmt_insert.setString(37, (String)drugDetails.get("QTY_DESC_CODE"));
							}
							else {
								pstmt_insert.setString(36, "");
								pstmt_insert.setString(37, "");
							}

							pstmt_insert.setString(38, in_strength_value);
							pstmt_insert.setString(39, in_strength_uom);
							pstmt_insert.setString(40, in_pres_qty_value);
							pstmt_insert.setString(41, in_pres_qty_uom);
							pstmt_insert.setString(42, (String)drugDetails.get("ALLERGY_REMARKS"));
							pstmt_insert.setString(43, (String)drugDetails.get("DOSE_REMARKS"));
							pstmt_insert.setString(44, (String)drugDetails.get("CURRENTRX_REMARKS"));
							pstmt_insert.addBatch();
						}
					}
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
			}

			// Insert into PH_PATIENT_DRUG_PROFILE
			HashMap tempFluidMap		= new HashMap();
			if(result > 0 ){
				if (drugList!=null  && drugList.size() !=0) {
					closeStatement( pstmt_insert ) ;
					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT4"));
					pstmt_insert.clearBatch();
					closeStatement( pstmt_pres_select55 ) ;
					closeStatement( pstmt_select ) ;
					pstmt_pres_select55	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT55"));
					pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));

					for(int j=0;j<drugList.size();j++) {
						drugDetails = (HashMap)drugList.get(j);
						if(result > 0 && drugDetails!=null && drugDetails.size() >0){
							drug_code			= (String)drugDetails.get("DRUG_CODE");
							order_id				= orderDetails.get("ORDER_ID"+drug_code).toString();
							dose 						= (String)drugDetails.get("dose");
							strength_value				= (String)drugDetails.get("ACT_STRENGTH_VALUE");

							amend_infusion_period_value = (String)drugDetails.get("amend_infusion_period_value");
							amend_infusion_period_uom 	= (String)drugDetails.get("amend_infusion_period_uom");
							amend_durn_value 			= (String)drugDetails.get("amend_durn_value");
							if(amend_durn_value==null) 
								amend_durn_value = "0";
							amend_durn_unit 			= (String)drugDetails.get("amend_durn_unit");
							amend_frequency 			= (String)drugDetails.get("amend_frequency");
							dosage_type					= (String)drugDetails.get("DOSAGE_TYPE");
							dose 						= (String)drugDetails.get("dose");
							if(dose==null) 
								dose = "0";
							amend_stock_value= (String)drugDetails.get("amend_stock_value");
							amend_stock_uom = (String)drugDetails.get("amend_stock_uom");

							if(fluidDetails!=null && fluidDetails.size() > 0){
								strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
								pres_base_uom	= (String)tempFluidMap.get("PRES_BASE_UOM");
								strength_per_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_PRES_UOM");
								strength_per_value_pres_uom = (String)tempFluidMap.get("STRENGTH_PER_VALUE_PRES_UOM");
								dosage_type		= (String)tempFluidMap.get("DOSAGE_TYPE");
							}
							else{
								strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
								pres_base_uom	= (String)drugDetails.get("PRES_BASE_UOM");
								strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");
								strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
								dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
							}
							if(strength_per_value_pres_uom==null) 
								strength_per_value_pres_uom = "0";
							if(strength_per_pres_uom==null) 
								strength_per_pres_uom = "0";
							if(repeat_value==null) 
								repeat_value = "0";
							in_qty_unit 	= pres_base_uom ;
							if(fluidDetails!=null && fluidDetails.size() > 0)
							  tempFluidMap = (HashMap)fluidDetails.get(drug_code);
							if(dosage_type.equals("Q")) {
								strength_uom				= "";pres_base_uom					="";
								strength_per_pres_uom		= "";strength_per_value_pres_uom	="";
							}  
							else if(dosage_type.equals("S")) {
								if(fluidDetails!=null && fluidDetails.size() > 0){
									resultSet			= null;
									//pstmt_select 		= connection.prepareStatement((String)sqlMap.get("SQL_PH_ONCOLOGY_UNIT"));
									pstmt_select.setString(1, amend_frequency);
									pstmt_select.setString(2, dose);
									pstmt_select.setString(3, amend_stock_value);
									pstmt_select.setString(4, amend_durn_value);
									resultSet	= pstmt_select.executeQuery();

									if (resultSet.next()) {
										comb_ord_qty = resultSet.getString(1)==null ? "":resultSet.getString(1);
									}
									if(comb_ord_qty!=null && !comb_ord_qty.equals("")){
										StringTokenizer stQty = new StringTokenizer(comb_ord_qty,"#");
										while(stQty.hasMoreTokens()){
											ord_qty				  =  Float.parseFloat(stQty.nextToken());
											ord_qty_value		  =  Float.parseFloat(stQty.nextToken());
											fluid_qty			  =  Float.parseFloat(stQty.nextToken());
											fluid_qty_value		  =  Float.parseFloat(stQty.nextToken());
										}
									}
									if(ord_qty==0) 
										ord_qty 					= 0.0f;
									if(ord_qty_value==0) 
										ord_qty_value 		= 0.0f;
									if(fluid_qty==0) 
										fluid_qty 				= 0.0f;
									if(fluid_qty_value==0) 
										fluid_qty_value 	= 0.0f;

									in_qty_value	= String.valueOf(fluid_qty_value);

									if(in_qty_value==null) in_qty_value	= "";
									if(in_qty_unit==null) in_qty_unit	= "";
									ord_qty				= fluid_qty;
									in_order_uom		= in_qty_unit;
									equl_value			= "";
									//Only Quantity based for Fluid
									in_tot_strength		= ""; // for Qty_based
									in_tot_strength_uom	= ""; // for Qty_based
									in_bms_qty			= String.valueOf(ord_qty)	; //Equivalent to qty_value
									in_strength_value	= in_tot_strength;
									in_strength_uom		= in_tot_strength_uom;
									in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
									in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
								} 
								else { //drugbased
									if(!strength_per_value_pres_uom.equals("0") && !strength_per_pres_uom.equals("0") && !repeat_value.equals("0"))
										dose_calc	= String.valueOf( Math.ceil( (((Double.parseDouble(strength_per_value_pres_uom)) * ((Double.parseDouble(dose)) * (Double.parseDouble(repeat_value))))  / (Double.parseDouble(strength_per_pres_uom)) )));
									if(dose!=null && !dose.equals("")){
										in_qty_value = String.valueOf(dose_calc);
										in_order_qty =  String.valueOf( Math.ceil(((Double.parseDouble(dose_calc)) * (Double.parseDouble(amend_durn_value))))  );

										in_strength_value	= String.valueOf( Math.ceil( ((Double.parseDouble(strength_per_value_pres_uom)) * (Double.parseDouble(dose)) * (Double.parseDouble(repeat_value)))));
										if(in_strength_value!=null)
											in_tot_strength		= String.valueOf( Math.ceil( ((Double.parseDouble(in_strength_value)) *  (Double.parseDouble(amend_durn_value)))));
									}
								}
							}
							if(dosage_type.equals("Q")) {
								in_tot_strength		= ""; // for Qty_based
								in_tot_strength_uom	= ""; // for Qty_based
								in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;
							} 
							else if(dosage_type.equals("S")) {
								//in_tot_strength		= in_order_qty;
								in_tot_strength_uom	= strength_uom;
								//in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;
							}

							/*if(dosage_type.equals("Q")) {
								int qty_val			= 0;
								if(dose!=null && repeat_value!=null && !dose.equals("0") && !repeat_value.equals("0"))
									qty_val 		= Integer.parseInt(dose) * Integer.parseInt(repeat_value);
								else
									qty_val 		= 0;
								in_qty_value		= String.valueOf(qty_val);
								in_qty_unit			= amend_calc_unit;

								if(in_qty_value==null) in_qty_value	= "";
								if(in_qty_unit==null) in_qty_unit	= "";
								if(qty_val!=0 && amend_durn_value!=null && !amend_durn_value.equals("0"))
									in_order_qty	= String.valueOf((Math.ceil(Double.parseDouble(String.valueOf(qty_val))) * (Double.parseDouble(String.valueOf(amend_durn_value)))));
								else
									in_order_qty	= "0";
								in_order_uom		= amend_calc_unit;
								equl_value			= "";

								in_tot_strength		= ""; // for Qty_based
								in_tot_strength_uom	= ""; // for Qty_based
								in_bms_qty			= in_order_qty; //Equivalent to qty_value
								in_strength_value	= in_tot_strength;
								in_strength_uom		= in_tot_strength_uom;

								in_pres_qty_value	= in_bms_qty; 	//Equivalent to bms_qty
								in_pres_qty_uom		= in_qty_unit;  //Equivalent to qty_unit
							}*/
							closeResultSet( resultSet ) ;
							resultSet		= null;
							//pstmt_pres_select55	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT55"));
							pstmt_pres_select55.setString(1, patient_id);
							pstmt_pres_select55.setString(2, login_facility_id);
							resultSet		= pstmt_pres_select55.executeQuery();

							int srl_NO		= 0;
							if(resultSet.next()) {
								srl_NO = resultSet.getInt("NEXT_SRL_NO");
							}
							pstmt_insert.setString(1, patient_id);
							pstmt_insert.setString(2, srl_NO + "");
							pstmt_insert.setString(3, login_facility_id);
							pstmt_insert.setString(4, encounter_id);
							pstmt_insert.setString(5, patient_class);
							pstmt_insert.setString(6, location_type);
							pstmt_insert.setString(7, location_code);
							pstmt_insert.setString(8, "");
							pstmt_insert.setString(9, "");
							pstmt_insert.setString(10, "");
							pstmt_insert.setString(11, "");
							pstmt_insert.setString(12, "");
							pstmt_insert.setString(13, "");
							pstmt_insert.setString(14, pract_id);
							pstmt_insert.setString(15, pract_id);

							if (tempFluidMap!=null && tempFluidMap.size() > 0) {

								pstmt_insert.setString(16, (String)tempFluidMap.get("DRUG_CODE"));
								pstmt_insert.setString(17, (String)tempFluidMap.get("GENERIC_ID"));
							}
							else { // Put the Drug Details
								pstmt_insert.setString(16, (String)drugDetails.get("DRUG_CODE"));
								pstmt_insert.setString(17, (String)drugDetails.get("GENERIC_ID"));
							}
							pstmt_insert.setString(18, amend_start_date);
							pstmt_insert.setString(19, amend_end_date);
							pstmt_insert.setString(20, "N");
							pstmt_insert.setString(21, "N");

							pstmt_insert.setString(22, in_strength_value);
							pstmt_insert.setString(23, in_strength_uom);
							pstmt_insert.setString(24, in_qty_value);
							pstmt_insert.setString(25, in_qty_unit);
							pstmt_insert.setString(26, "");
							pstmt_insert.setString(27, amend_frequency);
							pstmt_insert.setString(28, amend_durn_value);
							pstmt_insert.setString(29, dose);
							String diag_text = "";
							pstmt_insert.setString(30, diag_text);
							pstmt_insert.setString(31, "");

							if(iv_presc_yn.equals("Y"))
								pstmt_insert.setString(32, "C");
							else
								pstmt_insert.setString(32, "N");
							pstmt_insert.setString(33, "");
							pstmt_insert.setString(34, "");
							pstmt_insert.setString(35, "");
							pstmt_insert.setString(36, "");
							pstmt_insert.setString(37, "M");
							pstmt_insert.setString(38, "N");
							pstmt_insert.setString(39, "");
							pstmt_insert.setString(40, null);
							pstmt_insert.setString(41, "N");
							pstmt_insert.setString(42, "");
							pstmt_insert.setString(43, null);
							pstmt_insert.setString(44, "P");
							pstmt_insert.setString(45, login_facility_id);
							pstmt_insert.setString(46, order_id);
							pstmt_insert.setString(47, "1");
							pstmt_insert.setString(48, "");
							pstmt_insert.setString(49, "N");
							pstmt_insert.setString(50, null);
							pstmt_insert.setString(51, "");
							pstmt_insert.setString(52, "");
							pstmt_insert.setString(53, null);
							pstmt_insert.setString(54, "");
							pstmt_insert.setString(55, "");
							pstmt_insert.setString(56, "N");
							pstmt_insert.setString(57, null);
							pstmt_insert.setString(58, "");
							pstmt_insert.setString(59, "");
							pstmt_insert.setString(60, login_by_id);
							pstmt_insert.setString(61, login_at_ws_no);
							pstmt_insert.setString(62, login_facility_id);
							pstmt_insert.setString(63, login_by_id);
							pstmt_insert.setString(64, login_at_ws_no);
							pstmt_insert.setString(65, login_facility_id);
							if (tempFluidMap!=null && tempFluidMap.size() > 0) {
								pstmt_insert.setString(66, (String)tempFluidMap.get("ROUTE_CODE"));
							} 
							else { // Put the Drug Details
								pstmt_insert.setString(66, (String)drugDetails.get("ROUTE_CODE"));
							}

							pstmt_insert.setString(67, "");
							pstmt_insert.setString(68, "");
							if (tempFluidMap!=null && tempFluidMap.size() > 0)
								pstmt_insert.setString(69, (String)drugDetails.get("DRUG_DESC"));
							else
								pstmt_insert.setString(69, "");
							pstmt_insert.setString(70, amend_durn_unit);
							pstmt_insert.setString(71, "");
							pstmt_insert.setString(72, "");

							pstmt_insert.setString(73, "");
							pstmt_insert.setString(74, "");
							pstmt_insert.setString(75, "N");
							if (tempFluidMap!=null && tempFluidMap.size() > 0) {
								pstmt_insert.setString(76, (String)tempFluidMap.get("FORM_CODE"));
							} 
							else { // Put the drug for_code
								pstmt_insert.setString(76, (String)drugDetails.get("FORM_CODE"));
							}

							pstmt_insert.setString(77, "");
							pstmt_insert.setString(78, "");
							pstmt_insert.setString(79, "");
							pstmt_insert.setString(80, "");
							pstmt_insert.setString(81, "");
							pstmt_insert.setString(82, "");
							pstmt_insert.setString(83, "");
							pstmt_insert.setString(84, "");
							pstmt_insert.setString(85, "");
							//}
							if (tempFluidMap!=null && tempFluidMap.size() > 0) {
								pstmt_insert.setString(86, (String)tempFluidMap.get("DOSAGE_TYPE"));
							} 
							else {
								pstmt_insert.setString(86, (String)drugDetails.get("DOSAGE_TYPE"));
							}
							result = pstmt_insert.executeUpdate();
						}
					}
				} // End of drugList
			}

			// Drug Remarks/Fluid Remarks  Insertion
			if(result > 0 ){
				int order_format_count=	0;
				//int order_id_chk	= 0; unused local variable 63877 //COMMENTED FOR COMMON-ICN-0048
				drug_code	= "";
				order_id		= "";
				String total_seq	= "";
				closeStatement( pstmt_insert ) ;
				pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
				pstmt_insert.clearBatch();
				// Fluid Remarks
				if(fluidRemarks!=null && fluidRemarks.size()>0) {
					HashMap fluidValues= null;
					for (int i=0;i<fluidRemarks.size() ;i++ ){
						fluidValues=(HashMap)fluidRemarks.get(i);
						total_seq=(String)fluidValues.get("order_format_fluid_count") ;
						order_format_count=Integer.parseInt(total_seq);
						for(int k=0;k<order_format_count;k++){
							drug_code	= (String)fluidValues.get("drug_code");
							order_id	= orderDetails.get("ORDER_ID"+drug_code).toString();
							pstmt_insert.setString(1,order_id);
							pstmt_insert.setString(2,"1"); // order_line_num
							pstmt_insert.setString(3,"S");
							pstmt_insert.setString(4,""+(k+1));
							pstmt_insert.setString(5,(String)fluidValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6,(String)fluidValues.get("field_type"+k));
							pstmt_insert.setString(7,(String)fluidValues.get("label_text"+k));
							pstmt_insert.setString(8,(String)fluidValues.get("field_values"+k));
							pstmt_insert.setString(9,"");
							pstmt_insert.setString(10,"");
							pstmt_insert.setString(11,(String)fluidValues.get("accept_option"+k));
							pstmt_insert.setString(12,login_by_id);
							pstmt_insert.setString(13,login_at_ws_no);
							pstmt_insert.setString(14,login_facility_id);
							pstmt_insert.setString(15,login_by_id);
							pstmt_insert.setString(16,login_at_ws_no);
							pstmt_insert.setString(17,login_facility_id);
							pstmt_insert.addBatch();
						}
					}
				}
				if(drugRemarks!=null && drugRemarks.size()>0) {
					HashMap DrugValues= null;
					for (int i=0;i<drugRemarks.size() ;i++ ){
						DrugValues=(HashMap)drugRemarks.get(i);
						total_seq=(String)DrugValues.get("order_format_count") ;
						order_format_count=Integer.parseInt(total_seq);
						for(int k=0;k<order_format_count;k++){
							drug_code	= (String)DrugValues.get("drug_code");
							order_id	= orderDetails.get("ORDER_ID"+drug_code).toString();
							pstmt_insert.setString(1,order_id);
							pstmt_insert.setString(2,"1"); // order_line_num
							pstmt_insert.setString(3,"S");
							pstmt_insert.setString(4,""+(k+1));
							pstmt_insert.setString(5,(String)DrugValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6,(String)DrugValues.get("field_type"+k));
							pstmt_insert.setString(7,(String)DrugValues.get("label_text"+k));
							pstmt_insert.setString(8,(String)DrugValues.get("field_values"+k));
							pstmt_insert.setString(9,"");
							pstmt_insert.setString(10,"");
							pstmt_insert.setString(11,(String)DrugValues.get("accept_option"+k));

							pstmt_insert.setString(12,login_by_id);
							pstmt_insert.setString(13,login_at_ws_no);
							pstmt_insert.setString(14,login_facility_id);
							pstmt_insert.setString(15,login_by_id);
							pstmt_insert.setString(16,login_at_ws_no);
							pstmt_insert.setString(17,login_facility_id);
							pstmt_insert.addBatch();
						}
					}
				}
				if((drugRemarks!=null && drugRemarks.size()>0) || (fluidRemarks!=null && fluidRemarks.size()>0)){
					int[] batch_result = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result.length ;i++ ){
						if(batch_result[i]<0  && batch_result[i] != -2 ){
							result= 0 ;
							break;
						}	
						else {
							result = 1;
						}
					}
				}
			} // result

			// Frequency Insertion
			if(result > 0){
				if (orderDetails!=null  && orderDetails.size() !=0) {
					boolean freq_values_found	= false;
					closeStatement( pstmt_insert ) ;
					pstmt_insert=null;
					pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT7"));
					pstmt_insert.clearBatch();
					drugDetails = null;
					HashMap data = null;
					String admin_time , admin_qty;
					for(int j=0;j<orderDetails.size();j++){
						drugDetails = (HashMap)drugList.get(j);
						if(drugDetails!=null && drugDetails.size() >0){
							drug_code			= (String)drugDetails.get("DRUG_CODE");
							order_id				= orderDetails.get("ORDER_ID"+drug_code).toString();
							chkValuescheduleFrequency=scheduleFreq;
							frequencyValues = new ArrayList();
							if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
								if(chkValuescheduleFrequency.containsKey(drug_code))
									frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);
							}
							dosage_type					= (String)drugDetails.get("DOSAGE_TYPE");
							if(fluidDetails!=null && fluidDetails.size() > 0)
								tempFluidMap = (HashMap)fluidDetails.get(drug_code);
							if(dosage_type.equals("Q")) {
								if(fluidDetails!=null && fluidDetails.size() > 0){
									strength_uom	= (String)tempFluidMap.get("STRENGTH_UOM");
								}
								else{
									strength_uom	= (String)drugDetails.get("STRENGTH_UOM");
								}
							}
							if(frequencyValues!=null && frequencyValues.size()>0){
								for(int n=0;n<frequencyValues.size();n++){
									freq_values_found = true;
									int seqNo=200;
									seqNo= seqNo+n;
									durn_desc = "";
									data=(HashMap)frequencyValues.get(n);
									admin_time=(String)data.get("admin_time");
									admin_qty=(String)data.get("admin_qty");
									durn_desc=strength_uom;

									pstmt_insert.setString(1,order_id);
									pstmt_insert.setString(2,"1");
									pstmt_insert.setString(3,"S");
									pstmt_insert.setString(4,""+(seqNo));
									pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
									pstmt_insert.setString(6,"C");
									pstmt_insert.setString(7,"D");
									pstmt_insert.setString(8,admin_time);
									pstmt_insert.setString(9,admin_qty);
									pstmt_insert.setString(10,durn_desc);
									pstmt_insert.setString(11,"O");
									pstmt_insert.setString(12,login_by_id);
									pstmt_insert.setString(13,login_at_ws_no);
									pstmt_insert.setString(14,login_facility_id);
									pstmt_insert.setString(15,login_by_id);
									pstmt_insert.setString(16,login_at_ws_no);
									pstmt_insert.setString(17,login_facility_id);
									pstmt_insert.addBatch();
								}
							}
						}
					}
					if(freq_values_found){
						int[] batch_result = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result.length ;i++ ){
							if(batch_result[i]<0  && batch_result[i] != -2 ){
								result= 0 ;
								break;
							} 
							else {
								result = 1;
							}
						}
					}
				}
			}

			if(result > 0){
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_select ) ;
				resultSet		= null;
				pstmt_select	= null;
				String  verf_reqd_bef_med_admin_yn = "N";
				String  med_admin_reqd_yn 			= "N";
				pstmt_select = connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT25A"));
				pstmt_select.clearBatch();
				pstmt_select.setString(1,login_facility_id);
				resultSet	= pstmt_select.executeQuery();
				if ( resultSet != null && resultSet.next() ) {
					verf_reqd_bef_med_admin_yn	= resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null ? "N":resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN");
					med_admin_reqd_yn	= resultSet.getString("MED_ADMIN_REQD_YN")==null ? "N":resultSet.getString("MED_ADMIN_REQD_YN");
				}

				if(med_admin_reqd_yn.equals("Y") && patient_class.equals("IP")){
					if (drugList!=null  && drugList.size() !=0) {
						boolean freq_values_found	= false;
						closeStatement( pstmt_insert ) ;
						pstmt_insert = connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2"));
						pstmt_insert.clearBatch();
						closeStatement( pstmt_select ) ;
						pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT24A"));
						for(int j=0;j<drugList.size();j++) {
							drugDetails = (HashMap)drugList.get(j);

							if(drugDetails!=null && drugDetails.size() >0){
								drug_code			= (String)drugDetails.get("DRUG_CODE");
								order_id				= orderDetails.get("ORDER_ID"+drug_code).toString();
								amend_sched_medn_yn			= (String)drugDetails.get("amend_sched_medn_yn");
								if(fluidDetails!=null && fluidDetails.size() > 0)
									tempFluidMap = (HashMap)fluidDetails.get(drug_code);

								//if(amend_sched_medn_yn.equals("Y"))
								//{
								chkValuescheduleFrequency=scheduleFreq;
								frequencyValues = null;
								if(chkValuescheduleFrequency.size()>0){
									if(chkValuescheduleFrequency.containsKey(drug_code))
										frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);
								}
								int fr_durn_value = 0;
								durn_value 			= (String)drugDetails.get("dose");
								qty_unit			= "";
								if(durn_value!=null && (!(durn_value.equals("")))){
									fr_durn_value=Integer.parseInt(durn_value);
								}
								if(fr_durn_value!=0){
									for(int m=0;m<fr_durn_value;m++){
										if(frequencyValues!=null && frequencyValues.size()>0){
											for(int n=0;n<frequencyValues.size();n++){
												freq_values_found = true;
												int dosage_seqNo=1;
												dosage_seqNo= dosage_seqNo+n;
												HashMap data=new HashMap();
												data=(HashMap)frequencyValues.get(n);
												String admin_time=(String)data.get("admin_time");
												String admin_qty=(String)data.get("admin_qty");
												String sch_date_time="";
												closeResultSet( resultSet ) ;
												resultSet	 = null;
												//pstmt_select = null;

												//pstmt_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT24A"));
												pstmt_select.setString(1, order_date);
												pstmt_select.setString(2, ""+m);
												pstmt_select.setString(3, admin_time);
												resultSet = pstmt_select.executeQuery();

												if (resultSet.next()) {
													sch_date_time = resultSet.getString(1);
												}
												closeResultSet( resultSet ) ;//3/21/2021

												pstmt_insert.setString(1,login_facility_id);
												pstmt_insert.setString(2,encounter_id);
												pstmt_insert.setString(3,sch_date_time);
												pstmt_insert.setString(4,drug_code);
												pstmt_insert.setString(5,""+(dosage_seqNo));
												pstmt_insert.setString(6,order_id);
												pstmt_insert.setString(7,"1");
												pstmt_insert.setString(8,patient_id);
												pstmt_insert.setString(9,pract_id);
												pstmt_insert.setString(10, "Y");
												if (tempFluidMap!=null && tempFluidMap.size() > 0)
													pstmt_insert.setString(11, (String)drugDetails.get("DRUG_DESC"));
												else
													pstmt_insert.setString(11, "");

												pstmt_insert.setString(12,admin_qty);
												pstmt_insert.setString(13,qty_unit);
												pstmt_insert.setString(14,"");
												pstmt_insert.setString(15, "");
												if (tempFluidMap!=null && tempFluidMap.size() > 0)
													pstmt_insert.setString(16,(String)tempFluidMap.get("ROUTE_CODE"));
												else
													pstmt_insert.setString(16,(String)drugDetails.get("ROUTE_CODE"));

												pstmt_insert.setString(17, "");//SCH_INFUSION_RATE

												pstmt_insert.setString(18, (String)drugDetails.get("amend_infusion_period_value"));
												pstmt_insert.setString(19, "");
												pstmt_insert.setString(20, verf_reqd_bef_med_admin_yn);
												pstmt_insert.setString(21,login_by_id);
												pstmt_insert.setString(22,login_at_ws_no);
												pstmt_insert.setString(23,login_facility_id);
												pstmt_insert.setString(24,login_by_id);
												pstmt_insert.setString(25,login_at_ws_no);
												pstmt_insert.setString(26,login_facility_id);

												pstmt_insert.setString(27, (String)drugDetails.get("amend_infusion_period_value"));
												pstmt_insert.setString(28, (String)drugDetails.get("amend_infusion_period_uom"));
												pstmt_insert.addBatch();
											}
										}
									} // m
								} // fr_durn_value
								//} // amedn_sched
							}
						} // drug List
						if(freq_values_found){
							int[] batch_result = pstmt_insert.executeBatch();
							for (int i=0;i<batch_result.length ;i++ ){
								if(batch_result[i]<0  && batch_result[i] != -2 ){
									result= 0 ;
									map.put("result",new Boolean(false));
									map.put("flag","Duplicate values for Medication Administration Detected!! Cannot Proceed!!");
									break;
								} 
								else {
									result = 1;
								}
							}
						}
					}
				}
			}
			String error_msg  = "";
			// To update/insert the statistics table
			closeStatement( cstmt_insert ) ;
			if(result > 0){
				try{
					cstmt_insert=connection.prepareCall("{call PH_CREATE_WORKLOAD_STATS(?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt_insert.setString( 1, pract_id);
					cstmt_insert.setString( 2, order_date);
					cstmt_insert.setString( 3, login_facility_id);
					cstmt_insert.setString( 4, patient_class);
					cstmt_insert.setString( 5, location_type);
					cstmt_insert.setString( 6, location_code);
					int totalOrder=orderDetails.size();
					cstmt_insert.setString( 7,String.valueOf(totalOrder));
					cstmt_insert.setString( 8,String.valueOf(total_line_num));
					cstmt_insert.setString( 9, login_at_ws_no);
					cstmt_insert.setString( 10, login_by_id);
					cstmt_insert.registerOutParameter(11, Types.VARCHAR );
					cstmt_insert.registerOutParameter(12, Types.VARCHAR );
					cstmt_insert.execute() ;
					String insert_yn	= cstmt_insert.getString( 11 );
					error_msg	= cstmt_insert.getString( 12 );
					if(insert_yn.equals("Y"))
						result = 1;
					else
						result = 0;
				}
				catch(Exception e){
					e.printStackTrace();
					result = 0;
				}
			}
			if (result>0) {
				System.err.println("Success"+error_msg);
				map.put("result", new Boolean(true));
				map.put("msgid", "RECORD_INSERTED");
				connection.commit();
			} 
			else {
				System.err.println("Failure"+error_msg);
				connection.rollback();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( rset_clob);
				closeResultSet( resultSet);

				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt__pres_select19A ) ;
				closeStatement( pstmt_pres_select55 ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement( pstmt_clob ) ;
				closeStatement( pstmt_select ) ;
				closeConnection( connection, prop );

			}
			catch(Exception e){
				e.printStackTrace();
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
}
