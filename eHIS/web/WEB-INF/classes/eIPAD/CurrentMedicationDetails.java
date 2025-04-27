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

import eIPAD.HealthObjects.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;
public class CurrentMedicationDetails implements java.io.Serializable{
	public List<CurrentMedications> getCurrentMedications(PatientContext oPatientContext) throws Exception {
		List<CurrentMedications> oCurrentMedicationsList = new ArrayList<CurrentMedications>() ;
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
			sqlStr.append("SELECT drug_desc,Order_Catalog,COUNT(*) OVER() TOTL_ROW_CNT FROM ");
			sqlStr.append(" (SELECT  ' - ' || e.form_code || ' - '|| a.dosage || ' ' || ph_get_uom_display ('" + facility_id + "', a.dosage_uom_code) || ' - '|| a.ROUTE_CODE|| ' - Every ' || ' ' || d.freq_desc Order_Catalog,e.drug_desc drug_desc, ");
			sqlStr.append(" TO_CHAR (a.start_date, 'dd/mm/yy') start_date,TO_CHAR (a.end_date, 'dd/mm/yy') end_date FROM ph_patient_drug_profile a, am_duration_type c,am_frequency d, ph_drug e, ph_generic_name f  WHERE a.patient_id = '" + strPatientId + "' "); 
			sqlStr.append(" AND TRUNC (NVL (a.end_date, SYSDATE)) >= TRUNC (SYSDATE) AND a.discont_date_time IS NULL  AND a.on_hold_date_time IS NULL AND d.freq_code(+) = a.freq_code   AND e.drug_code = a.drug_code   AND f.generic_iD = a.generic_id   AND c.durn_type(+) = d.interval_durn_type ORDER BY 2 DESC )");
			
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						CurrentMedications oCurrentMedications = new CurrentMedications();
						oCurrentMedications.setsDrugDesc(((resultSet.getString("drug_desc") != null) ?resultSet.getString("drug_desc") : "") );
						oCurrentMedications.setsOrderCatalog(((resultSet.getString("Order_Catalog") != null) ?resultSet.getString("Order_Catalog") : "") );
						oCurrentMedications.setsCurrentMedCount(((resultSet.getString("TOTL_ROW_CNT") != null) ?resultSet.getString("TOTL_ROW_CNT") : "0")) ;
						oCurrentMedicationsList.add(oCurrentMedications);
						
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
		return oCurrentMedicationsList;
	}
	public List<CurrentMedications> getCurrentMedicationsDetails(PatientContext oPatientContext) throws Exception {
		List<CurrentMedications> oCurrentMedicationsList = new ArrayList<CurrentMedications>() ;
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
			/*
			sqlStr.append("SELECT ba.order_id order_id, ba.catalog_desc catalog_desc ,' - '||ba.form_code||' - '||ba.qty_value||' '|| ph_get_uom_display ('" + facility_id + "', f.dosage_uom_code) ||' - '|| ba.route_code||' - Every '||' '||e.FREQ_DESC Order_Catalog,ba.order_qty || ' ' || ba.order_uom quantity,NVL(am_get_desc.am_practitioner (a.ord_pract_id, '" + locale+ "', '1'),");
			sqlStr.append(" am_get_desc.am_ext_practitioner (a.ord_pract_id, '" + locale+ "', '1') ) ordered_By,DECODE (NVL (ba.priority, 'R'), 'U', 'Urgent', 'S', 'Stat','R', 'Routine' ) priority FROM or_order a,or_order_line ba, am_duration_type c,or_catalog_synonym_lang_vw d,am_frequency e,  ph_patient_drug_profile f, ph_drug g,ph_generic_name h  WHERE a.order_id = ba.order_id  AND a.order_category = 'PH' and c.durn_type = e.INTERVAL_DURN_TYPE ");
			sqlStr.append(" and e.freq_code = f.freq_code and a.patient_id = f.patient_id  AND TRUNC (NVL (f.end_date, SYSDATE)) >= TRUNC (SYSDATE)  AND f.discont_date_time IS NULL  AND f.on_hold_date_time IS NULL and f.drug_code = g.drug_code and h.generic_id = f.generic_id  AND ba.order_catalog_code = d.order_catalog_code AND ba.durn_type = c.durn_type(+)  AND d.language_id = '" + locale+ "' AND catalog_synonym_type = or_get_synonym_type ('RD', ba.order_catalog_code) AND NVL (ba.cont_order_ind, 'DO') IN ('DO', 'DR', 'CO', 'CR') AND SUBSTR (a.order_id, 1, 2) != 'CS' AND a.patient_id = ('" + strPatientId + "') AND NVL (a.encounter_id, 0) = NVL (('" + strEncounterId + "'), NVL (a.encounter_id, 0)) ");
			sqlStr.append(" AND ba.order_line_status IN ( SELECT order_status_code  FROM or_order_status_code  WHERE order_status_type IN (  SELECT order_status_type FROM or_status_applicability  WHERE oper_or_group_ref = 'EXT_ACTIVE'))  AND (   ('EXT_FUTURE_ORD' = 'EXT_ACTIVE' AND ba.future_order_yn = 'Y') OR 'EXT_FUTURE_ORD' != 'EXT_ACTIVE'  )  AND a.order_category IN ( SELECT order_category FROM or_order_category ic  WHERE ic.order_category =	NVL ('', ic.order_category)) ");
		    sqlStr.append(" AND ba.order_type_code = NVL ((''), ba.order_type_code) AND ba.priority = NVL ((''), ba.priority) AND NVL (ba.activity_type, '!') = NVL ('', NVL (ba.activity_type, '!'))  AND (ba.end_date_time > SYSDATE OR ba.end_date_time IS NULL) AND ba.cancelled_by_sys_yn != 'Y' ORDER BY a.ord_date_time DESC ");
			*/
			sqlStr.append("  SELECT   b.order_id,ba.catalog_desc catalog_desc,ba.order_qty || ' ' || ba.order_uom quantity, b.ord_date_time,  ' - ' || ba.form_code || ' - ' || ba.qty_value || ' ' || ph_get_uom_display ('" + facility_id + "', a.dosage_uom_code) || ' - '  || ba.route_code || ' - Every '  || ' ' || d.freq_desc order_catalog, ");
			sqlStr.append(" NVL (am_get_desc.am_practitioner (b.ord_pract_id, '" + locale+ "', '1'), am_get_desc.am_ext_practitioner (b.ord_pract_id, '" + locale+ "', '1') ) ordered_by, ");
			sqlStr.append(" DECODE (NVL (ba.priority, 'R'), 'U', 'Urgent', 'S', 'Stat',  'R', 'Routine'  ) priority ");
			sqlStr.append(" FROM ph_patient_drug_profile a,  or_order b, or_order_line ba,  am_duration_type_lang_vw c, am_frequency_lang_vw d, ph_drug_lang_vw e, ph_generic_name f, or_order_line_ph g ");
			sqlStr.append(" WHERE a.patient_id = '" + strPatientId + "' AND e.language_id = '" + locale+ "' and ba.order_id = b.ORDER_ID  AND a.orig_order_id = NVL ('', a.orig_order_id) AND b.order_id = a.orig_order_id AND a.orig_order_id = g.order_id AND a.orig_order_line_no = g.order_line_num  AND TRUNC (NVL (a.end_date, SYSDATE)) >= TRUNC (SYSDATE) AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL");
			sqlStr.append(" AND d.freq_code(+) = a.freq_code  AND e.drug_code = a.drug_code AND f.generic_id = a.generic_id AND c.durn_type(+) = a.durn_type AND cancel_yn = 'N' AND cancel_date_time IS NULL AND e.drug_yn = 'Y'  AND d.language_id = '" + locale+ "' AND c.language_id = '" + locale+ "' ORDER BY b.ord_date_time DESC ");
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						CurrentMedications oCurrentMedications = new CurrentMedications();
						
						oCurrentMedications.setsOrderID(((resultSet.getString("ORDER_ID") != null) ?resultSet.getString("ORDER_ID") : "") );
						oCurrentMedications.setsCatalogDesc(((resultSet.getString("catalog_desc") != null) ?resultSet.getString("catalog_desc") : "") );
						oCurrentMedications.setsOrderCatalog(((resultSet.getString("Order_Catalog") != null) ?resultSet.getString("Order_Catalog") : "") );
						oCurrentMedications.setsQuantity(((resultSet.getString("Quantity") != null) ?resultSet.getString("Quantity") : "") );
						oCurrentMedications.setsOrderedBy(((resultSet.getString("ordered_By") != null) ?resultSet.getString("ordered_By") : "") );
						oCurrentMedications.setsPriority(((resultSet.getString("priority") != null) ?resultSet.getString("priority") : "") );
						
						oCurrentMedicationsList.add(oCurrentMedications);
						
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
		return oCurrentMedicationsList;
	}
}
