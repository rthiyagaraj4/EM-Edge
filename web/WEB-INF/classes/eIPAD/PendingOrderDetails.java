/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD;
import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;

import eIPAD.HealthObjects.*;
import eOR.Common.OrRepository;
import eOR.Common.OrRepositoryExt;
import eCommon.Common.*;
import webbeans.eCommon.*;
public class PendingOrderDetails implements java.io.Serializable {
	/**
	 * 
	 * @param oPatientContext
	 * @return
	 * @throws Exception
	 */
	public List<PendingOrder> getPendingOrder(PatientContext oPatientContext) throws Exception {
		List<PendingOrder> oPendingOrderList = new ArrayList<PendingOrder>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			
			sqlStr.append("SELECT order_category_short_desc,count(*) order_category_count,sum(count(*)) over() TOTL_ROW_CNT");
			sqlStr.append(" FROM (SELECT DISTINCT b.order_category,b.order_type_code,c.short_desc order_category_short_desc,");
			sqlStr.append(" TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time,");
			sqlStr.append(" or_get_order_catalog (a.order_id,a.order_type_code,'" + locale+ "','"+ strPracType +"',b.order_line_num) item_short_desc,");
			sqlStr.append(" E.catalog_synonym || DECODE (a.order_category,");
			sqlStr.append(" 'PH',((SELECT DECODE (am_get_desc.am_trade_name (trade_code,'" + locale+ "','1'),NULL,'',");
			sqlStr.append(" '[' || am_get_desc.am_trade_name(trade_code,'" + locale+ "','1') || ']') trade_name");
			sqlStr.append(" FROM or_order_line_ph WHERE order_id = b.order_id ");
			sqlStr.append(" AND order_line_num = b.order_line_num)) || '<br />' ||");
			sqlStr.append(" RTRIM(RTRIM(TO_CHAR (b.order_qty, '9999999999999990.999999999999'),'0'),'.') ||");
			sqlStr.append(" ' '|| ph_get_uom_display ('" + facility_id + "',b.order_uom,'" + locale+ "') || ' ' || ( '[' ||");
			sqlStr.append(" TO_CHAR (b.start_date_time, 'dd/mm/yyyy')|| ']'),'') item_short_desc_ms,");
			sqlStr.append(" NVL2(line_fields_display_text, 'Y', 'N') format_exist_yn,b.order_id order_id,");
			sqlStr.append(" b.order_line_num order_line_num FROM or_order a,or_order_line b,or_order_category_lang_vw c,");
			sqlStr.append(" am_duration_type d,or_catalog_synonym_lang_vw E WHERE b.order_category = c.order_category ");
			sqlStr.append(" AND b.order_catalog_code = E.order_catalog_code ");
			sqlStr.append(" AND E.language_id = '" + locale+ "' AND catalog_synonym_type = or_get_synonym_type");
			sqlStr.append(" ('IP', b.order_catalog_code) AND patient_id = '" + strPatientId + "' AND a.order_id = b.order_id ");
			sqlStr.append(" AND b.durn_type = d.durn_type(+) AND b.order_line_status IN ( SELECT order_status_code ");
			sqlStr.append(" FROM or_order_status_code WHERE order_status_type IN (10, 15, 16, 17, 20, 23, 25, 30, 40,");
			sqlStr.append(" 45, 50, 52,54, 55, 65, 67)) ");
			sqlStr.append(" AND NVL (a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') AND EXISTS");
			sqlStr.append(" (SELECT 1 FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code");
			sqlStr.append(" AND order_catalog_nature != 'S') AND c.language_id = '" + locale+ "')");
			sqlStr.append(" GROUP BY order_category_short_desc");
			sqlStr.append(" ORDER BY order_category_short_desc");
			
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						PendingOrder oPendingOrder = new PendingOrder();
						
						oPendingOrder.setsOrderDesc(((resultSet.getString("order_category_short_desc") != null) ?resultSet.getString("order_category_short_desc") : "") );
						
						
						
						oPendingOrder.setsOrdercount(((resultSet.getString("order_category_count") != null) ?resultSet.getString("order_category_count") : "")) ;		
						oPendingOrder.setsOCount(((resultSet.getString("TOTL_ROW_CNT") != null) ?resultSet.getString("TOTL_ROW_CNT") : "0")) ;
						oPendingOrderList.add(oPendingOrder);
						
				}
			} catch ( Exception e )	{
				System.out.println(sqlStr.toString());
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oPendingOrderList;
	}
	/**
	 * 
	 * @param oPatientContext
	 * @return
	 * @throws Exception
	 */
	public List<PendingOrder> getPendingOrderDetails(PatientContext oPatientContext) throws Exception {
		List<PendingOrder> oPendingOrderList = new ArrayList<PendingOrder>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			
			sqlStr.append("SELECT DISTINCT c.short_desc order_category_short_desc,TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time, ");
			sqlStr.append(" or_get_order_catalog (a.order_id, a.order_type_code,'" + locale+ "','"+ strPracType +"',b.order_line_num) item_short_desc,a.ord_pract_id,NVL2 (line_fields_display_text, 'Y', 'N') format_exist_yn , b.order_id order_id, b.order_line_num order_line_num "); 
			sqlStr.append(" FROM or_order a,or_order_line b,or_order_category_lang_vw c,am_duration_type d,or_catalog_synonym_lang_vw e ");
			sqlStr.append(" WHERE b.order_category = c.order_category AND b.order_catalog_code = e.order_catalog_code AND e.language_id = '" + locale+ "' ");
			sqlStr.append(" AND catalog_synonym_type = or_get_synonym_type ('"+ strPracType +"', b.order_catalog_code) AND patient_id = '" + strPatientId + "' ");
			sqlStr.append(" AND a.order_id = b.order_id AND b.durn_type = d.durn_type(+) AND b.order_line_status IN ( SELECT order_status_code FROM or_order_status_code ");
			sqlStr.append(" WHERE order_status_type IN (10, 15, 16, 17, 20, 23, 25, 30, 40, 45, 50, 52, 54, 55, 65, 67)) AND NVL (a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') ");
			sqlStr.append(" AND EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code = b.order_catalog_code AND order_catalog_nature != 'S') AND c.language_id = '" + locale+ "' ");
            sqlStr.append(" ORDER BY 1,2 DESC ");
			
			
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						PendingOrder oPendingOrder = new PendingOrder();
						
						oPendingOrder.setsOrderDesc(((resultSet.getString("order_category_short_desc") != null) ?resultSet.getString("order_category_short_desc") : "") );
						
						
						
						oPendingOrder.setsTestDateTime(((resultSet.getString("test_date_time") != null) ?resultSet.getString("test_date_time") : "")) ;		
						oPendingOrder.setsItemShortDesc(((resultSet.getString("item_short_desc") != null) ?resultSet.getString("item_short_desc") : "")) ;
						oPendingOrder.setsOrdPractId(((resultSet.getString("ord_pract_id") != null) ?resultSet.getString("ord_pract_id") : "")) ;
						oPendingOrder.setsFormatExists(((resultSet.getString("format_exist_yn") != null) ?resultSet.getString("format_exist_yn") : "")) ;
                        oPendingOrder.setOrderId(((resultSet
							.getString("order_id") != null) ? resultSet
							.getString("order_id") : ""));
					    oPendingOrder.setOrderLineNum(((resultSet
							.getString("order_line_num") != null) ? resultSet
							.getString("order_line_num") : ""));
						oPendingOrderList.add(oPendingOrder);
						
				}
			} catch ( Exception e )	{
				System.out.println(sqlStr.toString());
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oPendingOrderList;
	}

	/**
	 * 
	 * @param pendingOrderFormatRequest
	 *            TODO
	 * @return
	 * @throws Exception
	 */
	public List<String[]> getOrderFormatDetail(
			PendingOrderFormatRequest pendingOrderFormatRequest)
			throws Exception {
		List<String[]> order_format_dtl = new ArrayList<String[]>();
		// safe check
		if (pendingOrderFormatRequest == null) {
			return order_format_dtl;
		}

		Connection connection = null;
		// get the order id from the request
		String order_id = pendingOrderFormatRequest.getOrderId();

		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		PreparedStatement pstmt7 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7 = null;

		// String lb_install_yn = "N";commented for lb_install_yn change on
		// 7/18/2007 by uma
		String bt_install_yn = "N";
		String rd_install_yn = "N";
		String ot_install_yn = "N";
		String order_category = "";
		// String[] record2 = null;
		String[] record1 = null;
		String labchk = "";
		String login_facility_id = pendingOrderFormatRequest.getFacilityId();
		String language_id = pendingOrderFormatRequest.getLanguageId();
		try {
			connection = ConnectionManager.getConnection();

			if (order_id != null && order_id.length() > 2) {
				order_category = order_id.substring(0, 2);
			}

			if (order_category.equals("LB")) {
				pstmt3 = connection
						.prepareStatement(OrRepository
								.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt3.setString(1, "BT");
				pstmt3.setString(2, login_facility_id);
				resultSet3 = pstmt3.executeQuery();
				if (resultSet3 != null && resultSet3.next()) {
					bt_install_yn = resultSet3.getString("operational_yn");
				}
			} else if (order_category.equals("RD")) {
				pstmt4 = connection
						.prepareStatement(OrRepository
								.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt4.setString(1, "RD");
				pstmt4.setString(2, login_facility_id);
				resultSet4 = pstmt4.executeQuery();
				if (resultSet4 != null && resultSet4.next()) {
					rd_install_yn = resultSet4.getString("operational_yn");
				}
			} else if (order_category.equals("OT")) {
				pstmt5 = connection
						.prepareStatement(OrRepository
								.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt5.setString(1, "OT");
				pstmt5.setString(2, login_facility_id);
				resultSet5 = pstmt5.executeQuery();
				if (resultSet5 != null && resultSet5.next()) {
					ot_install_yn = resultSet5.getString("operational_yn");
				}
			}

			pstmt = connection.prepareStatement(OrRepository
					.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_CMTS"));
			pstmt.setString(1, (String) order_id.trim());
			resultSet = pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				String record[] = new String[6];

				record[0] = resultSet.getString("order_field_type");
				record[1] = resultSet.getString("order_label_text");
				record[2] = resultSet.getString("order_field_value");
				record[3] = resultSet.getString("accept_option");
				record[4] = resultSet.getString("discr_msr_uom");
				record[5] = resultSet.getString("order_field_mnemonic");

				if (order_category.equals("LB")) {
					pstmt6 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS"));
					pstmt6.setString(1,
							CommonBean.checkForNull(order_id.trim(), ""));

					resultSet6 = pstmt6.executeQuery();
					if (resultSet6 != null && resultSet6.next()) {
						record1 = new String[2];// Only One record
						record1[0] = resultSet6.getString("ORDER_CATALOG_CODE");
						record1[1] = resultSet6.getString("order_type_code");
					}
					labchk = CommonBean.checkForNull(
							getmoduleRL(record1[0], order_category, record1[1],
									login_facility_id), "");
				}
				// if(lb_install_yn.equals("Y") && order_category.equals("LB")
				// &&
				// resultSet.getString("order_field_mnemonic").equals("SPECIMEN_TYPE")
				// )//changed on 7/18/2007 for lb_instal_yn change check by uma
				if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"SPECIMEN_TYPE")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				}
				// } else if(lb_install_yn.equals("Y") &&
				// order_category.equals("LB") &&
				// resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT")
				// )changed on 7/18/2007 for lb_install_yn change by uma
				else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"DONOR_BLOOD_GROUP")) {
					record[2] = CommonBean.checkForNull(record[2], "");
					if (record[2].equals("null"))
						record[2] = "";
					if (!record[2].equals("")) {
						pstmt1 = connection
								.prepareStatement(OrRepositoryExt
										.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC"));
						pstmt1.setString(1, record[2]);
						resultSet1 = pstmt1.executeQuery();
						if (resultSet1 != null && resultSet1.next()) { // One
																		// rec
							record[2] = resultSet1.getString("description");
						}
					}
					// } else if(lb_install_yn.equals("Y") &&
					// order_category.equals("LB") &&
					// resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT")
					// )changed on 7/18/2007 for lb_install_yn change by uma
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"DONOR_RHESUS")) {
					record[2] = CommonBean.checkForNull(record[2], "");
					if (record[2].equals("null"))
						record[2] = "";
					if (!record[2].equals("")) {
						pstmt1 = connection
								.prepareStatement(OrRepositoryExt
										.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC"));
						pstmt1.setString(1, record[2]);
						resultSet1 = pstmt1.executeQuery();
						if (resultSet1 != null && resultSet1.next()) { // One
																		// rec
							record[2] = resultSet1.getString("description");
						}
					}
					// } else if(lb_install_yn.equals("Y") &&
					// order_category.equals("LB") &&
					// resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT")
					// )changed on 7/18/2007 for lb_install_yn change by uma
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"REQUEST_COMMENT")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"ANATOMY_SITE")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
					// } else if(lb_install_yn.equals("Y") &&
					// order_category.equals("LB") &&
					// resultSet.getString("order_field_mnemonic").equals("TISSUE_DESC")
					// )changed on 7/18/2007 for lb_install_yn change by uma
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"TISSUE_DESC")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
					// } else if(lb_install_yn.equals("Y") &&
					// order_category.equals("LB") &&
					// resultSet.getString("order_field_mnemonic").equals("FIXATIVE")
					// )changed on 7/18/2007 for lb_install_yn change by uma
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"FIXATIVE")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (bt_install_yn.equals("Y")
						&& order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"BLOOD_CATEGORY_RQST")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (rd_install_yn.equals("Y")
						&& order_category.equals("RD")
						&& resultSet.getString("order_field_mnemonic").equals(
								"TRANSPORT_MODE")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (rd_install_yn.equals("Y")
						&& order_category.equals("RD")
						&& resultSet.getString("order_field_mnemonic").equals(
								"EXAM_VIEW_REQSTD")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (rd_install_yn.equals("Y")
						&& order_category.equals("RD")
						&& resultSet.getString("order_field_mnemonic").equals(
								"STUDY_LOC")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (rd_install_yn.equals("Y")
						&& order_category.equals("RD")
						&& resultSet.getString("order_field_mnemonic").equals(
								"REQUEST_COMMENT")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (ot_install_yn.equals("Y")
						&& order_category.equals("OT")
						&& resultSet.getString("order_field_mnemonic").equals(
								"PATIENT_POSITION")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (order_category.equals("OT")
						&& resultSet.getString("order_field_mnemonic").equals(
								"PERFORM_TEAM_SURGEON")) {
					// For both OT install or OT not uninstalled

					pstmt1 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, order_id);
					resultSet1 = pstmt1.executeQuery();

					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (ot_install_yn.equals("Y")
						&& order_category.equals("OT")
						&& resultSet.getString("order_field_mnemonic").equals(
								"OT_OPER_KEYWORD")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (ot_install_yn.equals("Y")
						&& order_category.equals("OT")
						&& (resultSet.getString("order_field_mnemonic").equals(
								"PROSTHESIS_IMPLANT") || resultSet.getString(
								"order_field_mnemonic").equals(
								"CONSIGNMENT_IMPLANT"))) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (order_category.equals("CN")
						&& (resultSet.getString("order_field_mnemonic").equals(
								"PERFORM_PRACT_ID") || resultSet.getString(
								"order_field_mnemonic").equals("CONULT_MED_ID"))) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_AM_PRACTITIONER_PERFORM_TEAM_SURGEON"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (order_category.equals("OT")
						&& ot_install_yn.equalsIgnoreCase("Y")
						&& resultSet.getString("order_field_mnemonic").equals(
								"ANAESTHETIST_CODE")) {

					pstmt1 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}

				} else if (((order_category.trim()).equalsIgnoreCase("OT"))
						&& ot_install_yn.equalsIgnoreCase("Y")
						&& (resultSet.getString("order_field_mnemonic")
								.equals("SURGERY_TYPE"))) // For OT SURGERY_TYPE
				{

					pstmt1 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}

				} else if (((order_category.trim()).equalsIgnoreCase("OT"))
						&& (resultSet.getString("order_field_mnemonic")
								.equals("ANAESTHESIA"))) // For OT ANAESTHESIA
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt
							.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}

				}
				/* Added by Uma on 2/22/2010 for IN017828 SRR20056-CRF-0587 */
				else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_field_mnemonic").equals(
								"BLOOD_PRODUCT_PROCESS")) {
					pstmt1 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BLOOD_PRODUCT_PROCESS_DESC"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				}
				/* Ends Here 2/22/2010 for IN017828 SRR20056-CRF-0587 */

				closeResultSet(resultSet1);
				closeStatement(pstmt1);

				order_format_dtl.add(record);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		} finally {
			try {
				closeResultSet(resultSet1);
				closeResultSet(resultSet2);
				closeResultSet(resultSet3);
				closeResultSet(resultSet4);
				closeResultSet(resultSet5);
				closeResultSet(resultSet6);
				closeResultSet(resultSet7);
				closeResultSet(resultSet);
				closeStatement(pstmt1);
				closeStatement(pstmt2);
				closeStatement(pstmt3);
				closeStatement(pstmt4);
				closeStatement(pstmt5);
				closeStatement(pstmt6);
				closeStatement(pstmt7);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return order_format_dtl;
	}

	/**
	 * @param pendingOrderFormatRequest
	 *            TODO
	 * @return : ArrayList
	 */
	public List<String[]> getOrderFormatLineDetail(
			PendingOrderFormatRequest pendingOrderFormatRequest)
			throws Exception {
		List<String[]> order_format_dtl = new ArrayList<String[]>();
		// safe check
		if (pendingOrderFormatRequest == null) {
			return order_format_dtl;
		}
		// get the order id from the request
		String order_id = pendingOrderFormatRequest.getOrderId();
		String login_facility_id = pendingOrderFormatRequest.getFacilityId();
		String called_from = pendingOrderFormatRequest.getCalledFrom();
		String line_id = pendingOrderFormatRequest.getLineId();
		String language_id = pendingOrderFormatRequest.getLanguageId();

		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		PreparedStatement pstmt7 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7 = null;
		// String lb_install_yn = "N";commented on 7/18/2007 for lb_install_yn
		// logic change by uma
		String bt_install_yn = "N";
		String rd_install_yn = "N";
		String ot_install_yn = "N";
		String order_category = "";

		String labchk = "";
		// String[] record2 = null;
		String[] record1 = null;

		try {
			connection = ConnectionManager.getConnection();

			if (order_id != null && order_id.length() > 2) {
				order_category = order_id.substring(0, 2);
			}

			if (order_category.equals("LB")) {
				pstmt6 = connection.prepareStatement(OrRepositoryExt
						.getOrKeyValue("SQL_OR_VIEW_ORDER_GET_ORDER_FORMATS"));
				pstmt6.setString(1,
						CommonBean.checkForNull((String) order_id.trim(), ""));

				resultSet6 = pstmt6.executeQuery();
				if (resultSet6 != null && resultSet6.next()) {
					record1 = new String[2];// Only One record
					record1[0] = resultSet6.getString("ORDER_CATALOG_CODE");
					record1[1] = resultSet6.getString("order_type_code");
				}
				labchk = CommonBean.checkForNull(
						getmoduleRL(record1[0], order_category, record1[1],
								login_facility_id), "");

			}
			if (order_category.equals("LB")) {
				pstmt3 = connection
						.prepareStatement(OrRepository
								.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt3.setString(1, "BT");
				pstmt3.setString(2, login_facility_id);
				resultSet3 = pstmt3.executeQuery();
				if (resultSet3 != null && resultSet3.next()) {
					bt_install_yn = resultSet3.getString("operational_yn");
				}
			} else if (order_category.equals("RD")) {
				pstmt4 = connection
						.prepareStatement(OrRepository
								.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt4.setString(1, "RD");
				pstmt4.setString(2, login_facility_id);
				resultSet4 = pstmt4.executeQuery();
				if (resultSet4 != null && resultSet4.next()) {
					rd_install_yn = resultSet4.getString("operational_yn");
				}
			} else if (order_category.equals("OT")) {
				pstmt5 = connection
						.prepareStatement(OrRepository
								.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt5.setString(1, "OT");
				pstmt5.setString(2, login_facility_id);
				resultSet5 = pstmt5.executeQuery();
				if (resultSet5 != null && resultSet5.next()) {
					ot_install_yn = resultSet5.getString("operational_yn");
				}
			}
			if (called_from != null && called_from.equals("RESULT_ENTRY"))
				pstmt = connection
						.prepareStatement(OrRepository
								.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_RESULT_ENTRY_CMTS"));
			else
				pstmt = connection
						.prepareStatement(OrRepository
								.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_FORMAT_LINE_CMTS"));

			pstmt.setString(1, (String) order_id.trim());
			pstmt.setString(2, (String) line_id.trim());
			resultSet = pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				String record[] = new String[8];
				record[0] = resultSet.getString("order_line_field_type");
				record[1] = resultSet.getString("order_line_label_text");
				record[2] = resultSet.getString("order_line_field_value");
				record[3] = resultSet.getString("item_narration");
				record[4] = resultSet.getString("order_line_field_mnemonic");
				record[5] = resultSet.getString("order_line_num");
				record[6] = resultSet.getString("catalog_synonym_dc");
				record[7] = resultSet.getString("discr_msr_uom");

				// if(lb_install_yn.equals("Y") && order_category.equals("LB")
				// &&
				// resultSet.getString("order_line_field_mnemonic").equals("SPECIMEN_TYPE")
				// )changed on 7/18/2007 for lb_install_yn logic change by uma
				if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("SPECIMEN_TYPE")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("DONOR_BLOOD_GROUP")) {
					record[2] = CommonBean.checkForNull(record[2], "");
					if (!record[2].equals("")) {
						pstmt1 = connection
								.prepareStatement(OrRepositoryExt
										.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC"));
						pstmt1.setString(1, record[2]);
						resultSet1 = pstmt1.executeQuery();
						if (resultSet1 != null && resultSet1.next()) { // One
																		// rec
							record[2] = resultSet1.getString("description");
						}
					}
					// } else if(lb_install_yn.equals("Y") &&
					// order_category.equals("LB") &&
					// resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT")
					// )changed on 7/18/2007 for lb_install_yn change by uma
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("DONOR_RHESUS")) {
					record[2] = CommonBean.checkForNull(record[2], "");
					if (!record[2].equals("")) {
						pstmt1 = connection
								.prepareStatement(OrRepositoryExt
										.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC"));
						pstmt1.setString(1, record[2]);
						resultSet1 = pstmt1.executeQuery();
						if (resultSet1 != null && resultSet1.next()) { // One
																		// rec
							record[2] = resultSet1.getString("description");
						}
					}
					// } else if(lb_install_yn.equals("Y") &&
					// order_category.equals("LB") &&
					// resultSet.getString("order_field_mnemonic").equals("REQUEST_COMMENT")
					// )changed on 7/18/2007 for lb_install_yn change by uma
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("REQUEST_COMMENT")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("ANATOMY_SITE")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ANATOMY_SITE_DETAILS"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
					// } else if(lb_install_yn.equals("Y") &&
					// order_category.equals("LB") &&
					// resultSet.getString("order_line_field_mnemonic").equals("TISSUE_DESC")
					// )changed on 7/18/2007 for lb_install_yn logic change by
					// uma
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("TISSUE_DESC")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_TISSUE_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
					// } else if(lb_install_yn.equals("Y") &&
					// order_category.equals("LB") &&
					// resultSet.getString("order_line_field_mnemonic").equals("FIXATIVE")
					// )changed on 7/18/2007 for lb_instal_yn logic change by
					// uma
				} else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("FIXATIVE")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FIXATIVE_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (bt_install_yn.equals("Y")
						&& order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("BLOOD_CATEGORY_RQST")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BT_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (rd_install_yn.equals("Y")
						&& order_category.equals("RD")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("TRANSPORT_MODE")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_TRANSPORT_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (rd_install_yn.equals("Y")
						&& order_category.equals("RD")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("EXAM_VIEW_REQSTD")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_EXAM_VIEW_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (rd_install_yn.equals("Y")
						&& order_category.equals("RD")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("STUDY_LOC")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_STUDY_LOC_DESC_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (rd_install_yn.equals("Y")
						&& order_category.equals("RD")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("REQUEST_COMMENT")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_RD_REQ_COMMENT_DETAILS"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (ot_install_yn.equals("Y")
						&& order_category.equals("OT")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("PATIENT_POSITION")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PATIENT_POSITION"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (order_category.equals("OT")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("PERFORM_TEAM_SURGEON")) {
					// For both OT install or OT not uninstalled
					pstmt1 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_VIEW_ORDER_PERFORM_TEAM_SURGEON"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, order_id);
					resultSet1 = pstmt1.executeQuery();

					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (ot_install_yn.equals("Y")
						&& order_category.equals("OT")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("OT_OPER_KEYWORD")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_OPER_KEYWORD"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (ot_install_yn.equals("Y")
						&& order_category.equals("OT")
						&& (resultSet.getString("order_line_field_mnemonic")
								.equals("PROSTHESIS_IMPLANT") || resultSet
								.getString("order_line_field_mnemonic").equals(
										"CONSIGNMENT_IMPLANT"))) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_OT_PROSTHESIS_IMPLANT"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (order_category.equals("PH")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("PRES_REMARKS")) {
					pstmt1 = connection
							.prepareStatement(OrRepository
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PH_PRES_REMARK"));
					pstmt1.setString(1, record[2]);
					pstmt1.setString(2, language_id);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				} else if (order_category.equals("OT")
						&& ot_install_yn.equalsIgnoreCase("Y")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("ANAESTHETIST_CODE")) {

					pstmt1 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_ANAESTHETIST_CODE"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}

				} else if (((order_category.trim()).equalsIgnoreCase("OT"))
						&& ot_install_yn.equalsIgnoreCase("Y")
						&& (resultSet.getString("order_line_field_mnemonic")
								.equals("SURGERY_TYPE"))) // For OT SURGERY_TYPE
				{

					pstmt1 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_SURGERY"));
					pstmt1.setString(1, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}

				} else if (((order_category.trim()).equalsIgnoreCase("OT"))
						&& ot_install_yn.equalsIgnoreCase("Y")
						&& (resultSet.getString("order_line_field_mnemonic")
								.equals("ANAESTHESIA"))) // For OT SURGERY_TYPE
				{

					pstmt1 = connection.prepareStatement(OrRepositoryExt
							.getOrKeyValue("SQL_OR_ORDER_ENTRY_ANAESTHESIA"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}

				}
				/* Added by Uma on 2/22/2010 for IN017828 SRR20056-CRF-0587 */
				else if (labchk.equalsIgnoreCase("IBARL")
						&& order_category.equals("LB")
						&& resultSet.getString("order_line_field_mnemonic")
								.equals("BLOOD_PRODUCT_PROCESS")) {
					pstmt1 = connection
							.prepareStatement(OrRepositoryExt
									.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BLOOD_PRODUCT_PROCESS_DESC"));
					pstmt1.setString(1, language_id);
					pstmt1.setString(2, record[2]);
					resultSet1 = pstmt1.executeQuery();
					if (resultSet1 != null && resultSet1.next()) { // One rec
						record[2] = resultSet1.getString("description");
					}
				}
				/* Ends Here 2/22/2010 for IN017828 SRR20056-CRF-0587 */

				order_format_dtl.add(record);
				closeResultSet(resultSet1);
				closeStatement(pstmt1);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		} finally {
			try {
				closeResultSet(resultSet5);
				closeResultSet(resultSet4);
				closeResultSet(resultSet3);
				closeResultSet(resultSet2);
				closeResultSet(resultSet1);
				closeResultSet(resultSet6);
				closeResultSet(resultSet7);
				closeResultSet(resultSet);
				closeStatement(pstmt5);
				closeStatement(pstmt4);
				closeStatement(pstmt3);
				closeStatement(pstmt2);
				closeStatement(pstmt1);
				closeStatement(pstmt6);
				closeStatement(pstmt7);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return order_format_dtl;
	}

	public void closeConnection(Connection connection) throws Exception {
		if (connection != null)
			ConnectionManager.returnConnection(connection);
	}

	/**
	 * 
	 * @param pstmt
	 *            java.sql.PreparedStatement
	 * @throws Exception
	 */
	public void closeStatement(PreparedStatement pstmt) throws Exception {
		if (pstmt != null)
			pstmt.close();
	}

	/**
	 * 
	 * @param resultSet
	 *            java.sql.ResultSet
	 * @throws Exception
	 */
	public void closeResultSet(ResultSet resultSet) throws Exception {
		if (resultSet != null)
			resultSet.close();
	}

	/**
	 * 
	 * @param catalogcode
	 * @param categorycode
	 * @param ordertypecode
	 * @param facility_id
	 * @return
	 * @throws Exception
	 */
	public String getmoduleRL(String catalogcode, String categorycode,
			String ordertypecode, String facility_id) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String modname = "";
		try {
			connection = ConnectionManager.getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt
					.getOrKeyValue("OR_GET_INTERFACED_APPL"));
			pstmt.setString(1, (String) catalogcode);
			pstmt.setString(2, (String) categorycode);
			pstmt.setString(3, (String) ordertypecode);
			pstmt.setString(4, (String) facility_id);
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				modname = rs.getString("modname");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return modname;
	}

}
