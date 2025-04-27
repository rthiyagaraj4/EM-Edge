/**
 * 
 */
package eIPAD.InPatientDetails.daoimps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import webbeans.eCommon.ConnectionManager;
import eIPAD.InPatientDetails.bc.Inds;
import eIPAD.InPatientDetails.dao.IndicatorsForIp;
import eIPAD.chartsummary.allergies.request.AllergyRequest;
import eIPAD.chartsummary.common.healthobject.PatContext;


public class InpatientsImpls implements IndicatorsForIp {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eIPAD.InPatientDeatils.dao.IndicatorsForIp#getIndicatorForPendingTask
	 * (eIPAD.chartsummary.allergies.request.AllergyRequest)
	 */
	public Inds getIndicatorForPendingTask(PatContext patsInfo, String patId,
			String encod_ids, String facility_id,
			HashMap<String, String> detailsOfPats) {
		// TODO Auto-generated method stub

		Inds ind = new Inds();

		boolean checkForIndicators = false;

		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String locale = "en";
		StringBuffer sqlStr = new StringBuffer("");

		int nRowCount = 0;

		
		
		
		sqlStr.append(" SELECT 'O' task_categ, b.order_type_code task_type, or_get_desc.or_order_type (b.order_type_code, '"
				+ detailsOfPats.get("LOCALE")
				+ "' , '2') task_type_desc, c.order_catalog_code task_code, or_get_order_catalog (b.order_id, b.order_type_code,'"
				+ detailsOfPats.get("LOCALE")
				+ "' , 'MD', c.order_line_num ) task_desc FROM or_order b, or_order_line c WHERE b.order_id = c.order_id AND NVL (b.cont_order_ind, 'xx') NOT IN ('DR', 'CR') AND  trunc(c.start_date_time) BETWEEN SYSDATE - 1 AND trunc(SYSDATE)  AND b.ordering_facility_id = '"
				+ detailsOfPats.get("facility_id")
				+ "' AND trunc(b.ord_date_time) BETWEEN SYSDATE - 1 AND trunc(SYSDATE)  AND c.order_line_status IN ( SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'TASK_RESULT_LIST' AND a.order_status_type = b.order_status_type) AND ( performing_appl_id IS NULL OR performing_appl_id IN (SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE NVL (result_entry, 'OR') = 'OR') ) AND SUBSTR (b.order_id, 1, 2) != 'CS' AND or_check_resulting_yn ('pract','"
				+ detailsOfPats.get("practitioner_id")
				+ "', b.order_category, b.order_type_code, b.order_id, b.performing_facility_id, b.performing_deptloc_type, b.performing_deptloc_code ) = 'Y' AND b.performing_facility_id = '"
				+ detailsOfPats.get("facility_id")
				+ "' AND SUBSTR (b.order_id, 1, 2) != 'RD' AND b.order_category IN ( SELECT order_category FROM or_order_category b WHERE EXISTS ( SELECT 1 FROM or_result_user a WHERE a.order_category = b.order_category AND practitioner_id = '"
				+ detailsOfPats.get("practitioner_id")
				+ "')) AND b.patient_id = '"
				+ patId
				+ "' AND b.order_category LIKE '%' AND b.order_type_code LIKE '%' AND NVL ((SELECT 'C' FROM or_order_status_code ia, or_status_applicability ib WHERE ib.oper_or_group_ref = 'EXT_COMPL_ORD' AND ia.order_status_type = ib.order_status_type AND ia.order_status_code = b.order_status), 'D' ) IN ('D') AND DECODE (b.order_category, 'OT', performing_deptloc_code, 'X') IS NOT NULL union ");


		sqlStr.append("SELECT 'I' task_categ, a.task_type task_type, ca_get_desc.ca_intervention_type (a.task_type, '"
				+ detailsOfPats.get("LOCALE")
				+ "', '2') task_type_desc, a.task_code task_code, ca_get_desc.ca_intervention (a.task_code,'"
				+ detailsOfPats.get("LOCALE")
				+ "', '2') task_desc FROM pr_encounter e, ca_pat_task_list a, ca_intervention b, ca_intervention_type d WHERE a.facility_id = e.facility_id AND a.encounter_id = e.encounter_id AND d.intervention_type = a.task_type AND b.intervention_code = a.task_code AND a.facility_id = '"
				+ detailsOfPats.get("facility_id")
				+ "'AND a.schedule_datetime BETWEEN TO_DATE (RTRIM (to_char(SYSDATE-1,'dd/mm/yyyy')), 'DD/MM/YYYY') AND TO_DATE (RTRIM (to_char(SYSDATE,'dd/mm/yyyy')), 'DD/MM/YYYY') + .9999 AND a.status IN ('O', 'P', 'N') AND NVL (performed_by_id, '*') IN ('*','"
				+ detailsOfPats.get("practitioner_id")
				+ "') AND a.patient_id = '"
				+ patId
				+ "' AND e.assign_care_locn_type like '%' AND e.assign_care_locn_code like '%' AND ((CASE WHEN NVL (a.status, 'O') IN ('P', 'N') THEN 'C' WHEN a.schedule_datetime > SYSDATE + .0208 THEN 'F' WHEN a.schedule_datetime > SYSDATE THEN 'D' WHEN (CASE WHEN e.patient_class IN ('IP', 'DC') AND ( e.discharge_date_time IS NULL OR e.discharge_date_time > SYSDATE - (SELECT ID.cut_off_days FROM ca_transription_req ia, ca_note_type ic, ca_note_group ID WHERE ia.req_accession_num = a.req_accession_num AND ia.note_type = ic.note_type AND ID.note_group = ic.note_group_id AND ROWNUM = 1) ) THEN 'Y' WHEN e.visit_adm_date_time > SYSDATE - (SELECT ID.cut_off_days FROM ca_transription_req ia, ca_pat_task_list ib, ca_note_type ic, ca_note_group ID WHERE ib.req_accession_num = a.req_accession_num AND ia.note_type = ic.note_type AND ID.note_group = ic.note_group_id AND ROWNUM = 1) THEN 'Y' ELSE 'N' END ) = 'N' THEN 'E' ELSE 'O' END ) IN ('D') ) union ");


		sqlStr.append("SELECT 'M' task_categ, NVL (d.iv_prep_yn, 'N') task_type, or_get_desc.or_order_type (d.order_type_code,'"
				+ detailsOfPats.get("LOCALE")
				+ "' , '2') task_type_desc, a.ord_drug_code task_code, or_get_order_catalog (d.order_id, d.order_type_code,'"
				+ detailsOfPats.get("LOCALE")
				+ "', 'MD', g.order_line_num, 'Y' ) task_desc FROM pr_encounter e, ph_medn_admin a, or_order_line g, or_order d, or_order_catalog b, ph_facility_param f WHERE a.facility_id = e.facility_id AND a.encounter_id = e.encounter_id AND g.order_id = a.order_id AND g.order_line_num = a.order_line_num AND e.facility_id = '"
				+ detailsOfPats.get("facility_id")
				+ "'  AND b.order_catalog_code = a.ord_drug_code AND f.facility_id = a.facility_id AND f.facility_id = '"
				+ detailsOfPats.get("facility_id")
				+ "' AND a.sch_date_time BETWEEN SYSDATE - f.rec_admin_within_hrs / 24 AND SYSDATE  AND d.order_id = a.order_id AND a.sch_date_time BETWEEN TO_DATE (RTRIM (to_char(SYSDATE,'dd/mm/yyyy')), 'dd/mm/yyyy') AND TO_DATE (RTRIM (to_char(SYSDATE,'dd/mm/yyyy')), 'dd/mm/yyyy') + .99999 AND a.sch_date_time >= g.start_date_time AND ( (d.iv_prep_yn IS NULL) OR (d.iv_prep_yn IN ('1', '3', '5', '9') AND a.order_line_num = 1) ) AND g.order_line_status NOT IN ( SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('45', '50', '93', '99')) AND ( ( e.patient_class IN ('OP', 'EM') AND e.visit_status BETWEEN '01' AND '09' ) OR ( e.patient_class IN ('IP', 'DC') AND adt_status BETWEEN '01' AND '08' ) ) AND NVL (a.admin_recorded_by, '***') = '***' AND a.patient_id = '"
				+ patId
				+ "' AND e.assign_care_locn_type like '%' AND e.assign_care_locn_code like '%' AND d.order_category LIKE '%' AND d.order_type_code LIKE '%' AND NVL2 (a.admin_recorded_by, 'C', 'D') IN ('D')");



		try {
			connection = ConnectionManager.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
			}
			if (resultSet != null) {
				resultSet.close();
			}

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlStr.toString());

			if (resultSet != null) {

				if (resultSet.next()) {


					checkForIndicators = true;

				} else {

					checkForIndicators = false;
				}
			}
			// The column count starts from 1

			/*
			 * ResultSetMetaData rsmd = resultSet.getMetaData(); int columnCount
			 * = rsmd.getColumnCount();
			 * 
			 * for (int i = 1; i <= columnCount; i++ ) { String colResult =
			 * rsmd.getColumnName(i);
			 * 
			 * // Do stuff with name
			 * 
			 * }
			 */


		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			ConnectionManager.returnConnection(connection);
			// checkForIndicators=false;

		}

		ind.setIndicatorType("pending");
		ind.setShowIndicator(checkForIndicators);
		return ind;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eIPAD.InPatientDeatils.dao.IndicatorsForIp#getIndicatorForNewNotes(eIPAD
	 * .chartsummary.common.healthobject.PatContext, java.lang.String)
	 */
	public Inds getIndicatorForNewNotes(PatContext patsInfo, String patId,
			String encod_ids, String facility_id,
			HashMap<String, String> detailsOfPats) {
		// TODO Auto-generated method stub

		Inds ind = new Inds();

		boolean checkForIndicators = false;

		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String locale = "en";
		StringBuffer sqlStr = new StringBuffer("");

		sqlStr.append("SELECT  a.facility_id  FROM ca_encntr_note a WHERE ca_get_appl_note_opern (a.facility_id, a.accession_num,'"
				+ detailsOfPats.get("responsibility_id")
				+ "','"
				+ detailsOfPats.get("practitioner_id")
				+ "',a.note_type,'"
				+ detailsOfPats.get("login_user")
				+ "','"
				+ detailsOfPats.get("others_unsigned") + "') IS NOT NULL");
		sqlStr.append(" AND a.patient_id ='"
				+ patId
				+ "' AND a.facility_id = '"
				+ facility_id
				+ "'AND a.encounter_id ='"
				+ encod_ids
				+ "'  AND NVL (ca_view_confidnt_event (a.facility_id,a.encounter_id, a.patient_id,a.accession_num, 'CA', a.note_type, 'CLNT','"
				+ detailsOfPats.get("practitioner_id")
				+ "','"
				+ detailsOfPats.get("responsibility_id")
				+ "', a.performed_by_id, a.authorized_by_id,NULL ), 'N') = 'Y'  AND a.event_status NOT IN ('9') AND event_date_time BETWEEN SYSDATE - 1 AND SYSDATE");


		try {
			connection = ConnectionManager.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
			}
			if (resultSet != null) {
				resultSet.close();
			}

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlStr.toString());

			if (resultSet != null) {

				if (resultSet.next()) {


					checkForIndicators = true;

				} else {

					checkForIndicators = false;
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			
			try{
				if(resultSet!=null)
					resultSet.close();
				if(stmt!=null)
					stmt.close();
				if(connection!=null)
					ConnectionManager.returnConnection(connection);
			}
			catch(SQLException e){
			}

		}

		ind.setIndicatorType("newnotes");
		ind.setShowIndicator(checkForIndicators);
		return ind;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eIPAD.InPatientDeatils.dao.IndicatorsForIp#getIndicatorForNewResult(eIPAD
	 * .chartsummary.common.healthobject.PatContext, java.lang.String)
	 */
	public Inds getIndicatorForNewResult(PatContext patsInfo, String patId,
			String encod_ids, String facility_id,
			HashMap<String, String> detailsOfPats) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		Inds ind = new Inds();

		boolean checkForIndicators = false;

		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String locale = "en";
		StringBuffer sqlStr = new StringBuffer("");

		sqlStr.append("SELECT patient_id,HIST_REC_TYPE,CONTR_SYS_ID,ACCESSION_NUM,CONTR_SYS_EVENT_CODE FROM   CR_ENCOUNTER_DETAIL  WHERE  patient_id ='"
				+ patId
				+ "' AND EVENT_AUTH_DATE_TIME BETWEEN SYSDATE - 1 AND (SYSDATE) AND NVL (ca_view_confidnt_event (facility_id,ENCOUNTER_ID,PATIENT_ID,accession_num,CONTR_SYS_ID,event_code,hist_rec_type,'"
				+ detailsOfPats.get("practitioner_id")
				+ "','"
				+ detailsOfPats.get("responsibility_id")
				+ "',performed_by_id,AUTHORIZED_BY_ID,DECODE (hist_rec_type, 'CLNT', NULL, event_group)),'N') = 'Y' AND NVL (STATUS, '`') NOT IN ('S', 'E')  AND NVL(NORMALCY_IND,'~') NOT IN ('H','C','A','L','S','G') ");


		try {
			connection = ConnectionManager.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
			}
			if (resultSet != null) {
				resultSet.close();
			}

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlStr.toString());

			if (resultSet != null) {

				if (resultSet.next()) {


					checkForIndicators = true;

				} else {

					checkForIndicators = false;
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			ConnectionManager.returnConnection(connection);
			// checkForIndicators=false;

		}

		ind.setIndicatorType("newresult");
		ind.setShowIndicator(checkForIndicators);
		return ind;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eIPAD.InPatientDeatils.dao.IndicatorsForIp#getIndicatorForDisChargeDue
	 * (eIPAD.chartsummary.common.healthobject.PatContext, java.lang.String)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eIPAD.InPatientDeatils.dao.IndicatorsForIp#getIndicatorForAbnormal(eIPAD
	 * .chartsummary.common.healthobject.PatContext, java.lang.String)
	 */
	public Inds getIndicatorForAbnormal(PatContext patsInfo, String patId,
			String encod_ids, String facility_id,
			HashMap<String, String> detailsOfPats) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		Inds ind = new Inds();

		boolean checkForIndicators = false;

		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String locale = "en";
		StringBuffer sqlStr = new StringBuffer("");

		sqlStr.append("SELECT patient_id,HIST_REC_TYPE,CONTR_SYS_ID,ACCESSION_NUM,CONTR_SYS_EVENT_CODE FROM   CR_ENCOUNTER_DETAIL WHERE  patient_id = '"
				+ patId
				+ "' AND EVENT_AUTH_DATE_TIME BETWEEN SYSDATE - 1 AND (SYSDATE) AND NVL ( ca_view_confidnt_event (facility_id,ENCOUNTER_ID,PATIENT_ID,accession_num,CONTR_SYS_ID, event_code,hist_rec_type,'"
				+ detailsOfPats.get("practitioner_id")
				+ "','"
				+ detailsOfPats.get("responsibility_id")
				+ "',performed_by_id, AUTHORIZED_BY_ID, DECODE (hist_rec_type, 'CLNT', NULL, event_group) ),'N') = 'Y'AND NVL (STATUS, '`') NOT IN ('S', 'E') AND NORMALCY_IND IN ('H','C','A','L','S','G')");


		try {
			connection = ConnectionManager.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
			}
			if (resultSet != null) {
				resultSet.close();
			}

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlStr.toString());

			if (resultSet != null) {

				if (resultSet.next()) {


					checkForIndicators = true;

				} else {

					checkForIndicators = false;
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			ConnectionManager.returnConnection(connection);
			// checkForIndicators=false;

		}

		ind.setIndicatorType("abnormal");
		ind.setShowIndicator(checkForIndicators);
		return ind;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eIPAD.InPatientDeatils.dao.IndicatorsForIp#getIndicatorForDisChargeDue
	 * (eIPAD.chartsummary.common.healthobject.PatContext, java.lang.String,
	 * java.lang.String)
	 */
	public Inds getIndicatorForDisChargeDue(PatContext patsInfo, String patId,
			String encod_ids, String facility_id) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// patId="BN00001456";

		Inds ind = new Inds();

		boolean checkForIndicators = false;

		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String locale = "en";
		StringBuffer sqlStr = new StringBuffer("");

		sqlStr.append("select * from pr_encounter where oth_adt_status='7' and ADT_STATUS<8 and encounter_id='"
				+ encod_ids
				+ "' and facility_id='"
				+ facility_id
				+ "' and patient_id='" + patId + "'");


		try {
			connection = ConnectionManager.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
			}
			if (resultSet != null) {
				resultSet.close();
			}

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlStr.toString());

			if (resultSet != null) {

				if (resultSet.next()) {


					checkForIndicators = true;

				} else {

					checkForIndicators = false;
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			ConnectionManager.returnConnection(connection);
			// checkForIndicators=false;

		}

		ind.setIndicatorType("discharge");
		ind.setShowIndicator(checkForIndicators);
		return ind;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eIPAD.InPatientDeatils.dao.IndicatorsForIp#getIndicatorForConsent
	 * (eIPAD.chartsummary.common.healthobject.PatContext, java.lang.String,
	 * java.lang.String)
	 */
	
	public Inds getIndicatorForConsent(PatContext patsInfo, String patId,
			String encod_ids, String facility_id,
			HashMap<String, String> detailsOfPats) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// patId="BN00001456";

		Inds ind = new Inds();

		boolean checkForIndicators = false;

		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String locale = "en";
		StringBuffer sqlStr = new StringBuffer("");

		
		sqlStr.append("select ORDER_ID FROM or_order a WHERE NVL (a.source_type, 'XX') = NVL (DECODE ((''), 'W', 'N', 'D', 'N', 'E', 'C', ('')), NVL (a.source_type, 'XX') ) AND NVL (a.source_code, 'XX') = NVL ((''), NVL (a.source_code, 'XX')) AND ( a.source_type != 'R' AND (a.source_type, a.source_code) IN ( SELECT DECODE (locn_type, 'W', 'N', locn_type), locn_code FROM ca_pract_by_locn_view WHERE practitioner_id = ('"
		        +  detailsOfPats.get("practitioner_id")
		        +  "')) OR a.source_type = 'R' ) AND a.patient_id = '"
		        + patId
		        + "' AND ( a.order_status = (SELECT order_status_code FROM or_order_status_code WHERE order_status_type = '00') OR EXISTS ( SELECT 'Y' FROM or_order_line WHERE order_id = a.order_id AND ord_consent_status = 'P' AND ROWNUM <= 1) ) AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR')");
	

		try {
			connection = ConnectionManager.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
			}
			if (resultSet != null) {
				resultSet.close();
			}

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlStr.toString());

			if (resultSet != null) {

				if (resultSet.next()) {


					checkForIndicators = true;

				} else {

					checkForIndicators = false;
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			ConnectionManager.returnConnection(connection);
			// checkForIndicators=false;

		}

		ind.setIndicatorType("consent");
		ind.setShowIndicator(checkForIndicators);
		return ind;

	}

}
