package eRD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import eRD.Common.RDAdapter;
import webbeans.eCommon.*;

public class RadiologyExamBean extends eRD.Common.RDAdapter implements Serializable {

	private Hashtable recordSet = new Hashtable();
	HashMap<String, Object> commonStoreMap = new HashMap<String, Object>();

	public HashMap<String, Object> getCommonStoreMap() {
		return commonStoreMap;
	}

	public void setCommonStoreMap(HashMap<String, Object> commonStoreMap) {
		this.commonStoreMap = commonStoreMap;
	}

	public void setAll(Hashtable recordSet) {

		if (recordSet.containsKey("mode"))
			setMode((String) recordSet.get("mode"));
		this.recordSet = recordSet;
	}

	// To get the Sysdate, with Properties
	public ArrayList getSysDateTime(Properties properties) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList currentDate = new ArrayList();

		try {
			connection = ConnectionManager.getConnection(properties);
			pstmt = connection.prepareStatement(
					"select to_char(sysdate,'HH12:MM') sys_time,to_char(sysdate,'dd/mm/yyyy') sys_date, to_char(sysdate+1,'dd/mm/yyyy')   next_sys_date ,to_char(sysdate,'DD/mm/yyyy') || ' 23:59' curr_date, to_char(sysdate - 7,'DD/mm/yyyy') || ' 00:00' last_week_date, to_char(sysdate - 7,'DD/mm/yyyy') last_week_without_date,  to_char(sysdate + 7,'DD/mm/yyyy') next_week_without_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, to_char(sysdate - 30 ,'DD/mm/yyyy') last_month_date, to_char( sysdate, 'HH24:MI:SS' ) sys_time_sec, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi:ss') sys_date_time_sec,USERENV('SESSIONID') session_id from dual");
			resultSet = pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				currentDate.add(resultSet.getString("sys_date"));
				currentDate.add(resultSet.getString("last_week_without_date"));
				currentDate.add(resultSet.getString("sys_date_time"));
				currentDate.add(resultSet.getString("next_week_without_date"));
				currentDate.add(resultSet.getString("last_month_date"));
				currentDate.add(resultSet.getString("sys_time_sec"));
				currentDate.add(resultSet.getString("last_week_date"));
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		} finally {
			closeStatement(pstmt);
			closeResultSet(resultSet);
			if (connection != null)
				ConnectionManager.returnConnection(connection, properties);
		}

		return currentDate;
	}

	public ArrayList getRadiologyExamList(String ordering_facility_id, String Reg_no,
			String performing_facility_id, String performed_by, String order_type_code, String order_catalog_code,
			String reporting_facility_id, String assigned_rad_id, String exam_status,
			String fromDate, String toDate, String patient_id,String urgencyid) throws Exception {
		ArrayList radiologyExamList = new ArrayList();
		System.err.println("66,radiologyexambean");
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		String sqlQuery="SELECT sm_get_desc.sm_facility_param (a.ordering_facility_id, ?, 1 ) ordering_facility, a.ordering_facility_id,"+"a.physician_id, (SELECT SHORT_NAME FROM am_practitioner WHERE practitioner_id = a.physician_id UNION SELECT SHORT_NAME FROM "+"am_ext_practitioner WHERE practitioner_id = a.physician_id) DOCTOR,a.patient_id, mp_get_desc.mp_patient (a.patient_id, '1') patient_name,"+
				"b.order_id, b.order_line_no, b.order_type_code, sm_get_desc.sm_facility_param (b.operating_facility_id, ?, 1 ) operating_facility,"+
				"b.operating_facility_id, b.request_num, b.request_line_num, TO_CHAR (a.request_date, 'dd/mm/yyyy hh24:mi') request_date,"+
				"TO_CHAR (b.end_time, 'dd/mm/yyyy hh24:mi') end_time, ROUND((SYSDATE-b.end_time)*(24*60)) TAT,"+
				"b.exam_room,b.exam_code, DECODE(b.contrast_type, 'P', 'Plain', 'C', 'Only Contrast', 'B', 'Plain & Constrast') contrast_type,"+
				"DECODE(b.exam_side_appl, 'L', 'Left', 'R', 'Right', 'B', 'Bilateral') Laterality,"+
				"e.short_desc exam, a.wing_code, a.section_code, a.urgency_ind, a.episode_type, (SELECT source_code FROM or_order WHERE "+ "order_id=a.order_id) source_code,RD_RESULT.GET_SOURCE_NAME(a.ordering_facility_id,a.order_id,a.episode_type,'en') source_name,"+
				"am_get_desc.am_practitioner (b.performed_by_id, ?, '2' ) performed_by, b.performed_by_id,"+
				"sm_get_desc.sm_facility_param (b.reporting_facility_id, ?, 1 ) reporting_facility, b.reporting_facility_id, b.reporting_radiologist_id,"+
				"b.radiologist_id, (SELECT short_name FROM rd_radiologist WHERE radiologist_id = b.radiologist_id and operational_facility_id ="+
				"b.operating_facility_id and language_id='en') radiologist,b.prelim_radiologist_id,b.note_type, (SELECT short_name FROM rd_radiologist WHERE "+ "radiologist_id = b.prelim_radiologist_id and operational_facility_id = b.operating_facility_id and language_id='en') prelim_radiologist,"+
				"DECODE (b.status, '50', 'Exam Completed', '60', 'Reported-On Hold', '65', 'Reported-Prelim', '70', 'Reported-Final', '85', 'Report Modified' ) status_name, b.status,"+
				"DECODE (b.status, '50', 'R', '60', 'H', '65', 'P', '70', 'M', '85', 'M' ) result_indicator,a.encounter_id, b.ext_appl_accession_num,"+
				"b.report_text FROM rd_request a, rd_exam_view_requested b, rd_exams e"+
				" WHERE a.operating_facility_id = b.operating_facility_id AND b.exam_code = e.exam_code"+
				" AND a.request_num = b.request_num AND a.ordering_facility_id = NVL (?, a.ordering_facility_id)"+
				" AND a.patient_id = NVL (?, a.patient_id) AND b.request_num = NVL (?, b.request_num) AND a.operating_facility_id = NVL (?, a.operating_facility_id)"+
				" AND NVL (b.performed_by_id, '!') = NVL (?, NVL (b.performed_by_id, '!')) AND b.order_type_code = NVL (?, b.order_type_code)"+
				" AND UPPER(e.short_desc) LIKE UPPER (?) AND NVL (b.reporting_facility_id, '!') = NVL (?, NVL (b.reporting_facility_id, '!'))"+
				" AND NVL (b.radiologist_id, '!') =? AND ((b.status = DECODE (?, 'A', b.status, 'C', '50', 'H', '60', 'P', '65', 'F', '70', 'M', '85' ))"+
				" OR (? = 'D' and b.status IN('50','60','65'))) AND b.status >= '50' AND b.status NOT IN ('99', '80') AND a.request_date BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND a.urgency_ind = NVL (?, a.urgency_ind)"+
				" ORDER BY TO_CHAR (a.request_date, 'dd/mm/yyyy hh24:mi'),b.exam_code";//V220720
			//	"ORDER BY b.end_time DESC";//V220720
	
		try {
			System.err.println(sqlQuery);
			connection = ConnectionManager.getConnection(properties);
			pstmt = connection.prepareStatement(sqlQuery);
			System.err.println("language_id,bean " + language_id);
			
			System.err.println("ordering_facility_id,bean " + ordering_facility_id);
			System.err.println("Reg_no " + Reg_no);
			System.err.println("performing_facility_id " + performing_facility_id);
			System.err.println("performed_by " + performed_by);
			System.err.println("order_type_code " + order_type_code);

			System.err.println("order_catalog_code " + order_catalog_code);
			System.err.println("reporting_facility_id_cre " + reporting_facility_id);
			System.err.println("examStatus " + exam_status);
			System.err.println("patient_id " + patient_id);
			System.err.println("assigned_rad_id " + assigned_rad_id);
			System.err.println("fromDate " + fromDate);
			System.err.println("toDate " + toDate);
			String urgency_ind="";
			
			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);

			pstmt.setString(3, language_id);
			pstmt.setString(4, language_id);
			pstmt.setString(5, ordering_facility_id);
			
			pstmt.setString(6, patient_id);// patient_id
			pstmt.setString(7, Reg_no);// Req_no
			pstmt.setString(8, performing_facility_id);// operating_facility_id
			pstmt.setString(9, performed_by);// performed_by_id
			pstmt.setString(10, order_type_code);// order_type_code
			pstmt.setString(11, order_catalog_code);// order_catalog_code
			pstmt.setString(12, reporting_facility_id);// reporting_facility_id

			pstmt.setString(13, assigned_rad_id);// reporting_radiologist_id
			pstmt.setString(14, exam_status);// status
			pstmt.setString(15, exam_status);// status
			pstmt.setString(16, fromDate);// from date
			pstmt.setString(17, toDate);// to date
			pstmt.setString(18, urgencyid);
			System.err.println("before execute ");
			resultSet = pstmt.executeQuery();
			System.err.println("after execute ");
			int i = 0;

			while (resultSet.next()) {
				System.err.println("150,radiologyexambean");
				radiologyExamList.add(checkForNull(resultSet.getString("STATUS_NAME")));// 0 //priority
				radiologyExamList.add(checkForNull(resultSet.getString("PATIENT_ID")));// 1
				radiologyExamList.add(checkForNull(resultSet.getString("PATIENT_NAME")));// 2
				radiologyExamList.add(checkForNull(resultSet.getString("EXAM")));// 3 //Exam
				radiologyExamList.add(checkForNull(resultSet.getString("status_name")));// 4
				radiologyExamList.add(checkForNull(resultSet.getString("RESULT_INDICATOR")));// 5
				radiologyExamList.add(checkForNull(resultSet.getString("REQUEST_NUM")));// 6 //reg.no
				radiologyExamList.add(checkForNull(resultSet.getString("REQUEST_DATE")));// 7 //Reg. Date/Time
				radiologyExamList.add(checkForNull(resultSet.getString("END_TIME")));// 8 //Compl. Date/Time
				radiologyExamList.add(checkForNull(resultSet.getString("TAT")));// 9 //Awaiting Time (In Min.)
				radiologyExamList.add(checkForNull(resultSet.getString("LATERALITY")));// 10 //LATERALITY
				radiologyExamList.add(checkForNull(resultSet.getString("CONTRAST_TYPE")) );// 11 //Contrast Type
				radiologyExamList.add(checkForNull(resultSet.getString("SOURCE_NAME")));// 12 //source
				radiologyExamList.add(checkForNull(resultSet.getString("PRELIM_RADIOLOGIST")));// 13 //Prelim Radiologist
				radiologyExamList.add(checkForNull(resultSet.getString("RADIOLOGIST")));// 14 //RADIOLOGIST
				radiologyExamList.add(checkForNull(resultSet.getString("SECTION_CODE")));// 15 //section
				radiologyExamList.add(checkForNull(resultSet.getString("WING_CODE")));// 16 //Wing
				radiologyExamList.add(checkForNull(resultSet.getString("ordering_facility")));// 17 //Ordering Facility Name
				radiologyExamList.add(checkForNull(resultSet.getString("EPISODE_TYPE")));// 18 //EPISODE_TYPE
				radiologyExamList.add(checkForNull(resultSet.getString("DOCTOR")));// 19 //DOCTOR
				System.err.println("286,radiologyexambean");
				String urgencyind = resultSet.getString("urgency_ind");
				if("R".equals(resultSet.getString("urgency_ind"))){
					urgency_ind="33FFC9";
				}else if("S".equals(resultSet.getString("urgency_ind"))){
					urgency_ind="Red";
				}else{
					urgency_ind="Orange";
				}
				radiologyExamList.add(urgency_ind);// 20 //urgency_ind
				
				radiologyExamList.add(checkForNull(resultSet.getString("PHYSICIAN_ID")));// 21 //PHYSICIAN_ID
				radiologyExamList.add(checkForNull(resultSet.getString("ORDER_ID")));// 22 //ORDER_ID
				radiologyExamList.add(checkForNull(resultSet.getString("ORDER_LINE_NO")));// 23 //ORDER_LINE_NO
				radiologyExamList.add(checkForNull(resultSet.getString("ORDER_TYPE_CODE")) );// 24 //ORDER_TYPE_CODE
				radiologyExamList.add(checkForNull(resultSet.getString("OPERATING_FACILITY")));// 25 //OPERATING_FACILITY
				radiologyExamList.add(checkForNull(resultSet.getString("OPERATING_FACILITY_ID")));// 26 //OPERATING_FACILITY_ID 
				radiologyExamList.add(checkForNull(resultSet.getString("REQUEST_LINE_NUM")));// 27 //REQUEST_LINE_NUM
				radiologyExamList.add(checkForNull(resultSet.getString("EXAM_ROOM")));// 28 //EXAM_ROOM 
				radiologyExamList.add(checkForNull(resultSet.getString("EXAM_CODE")));// 29 //EXAM_CODE
				radiologyExamList.add(checkForNull(resultSet.getString("SOURCE_CODE")));// 30 //SOURCE_CODE
				radiologyExamList.add(checkForNull(resultSet.getString("PERFORMED_BY")));// 31 //PERFORMED_BY
				radiologyExamList.add(checkForNull(resultSet.getString("PERFORMED_BY_ID")));// 32 //PERFORMED_BY_ID
				
				
				radiologyExamList.add(checkForNull(resultSet.getString("REPORTING_FACILITY")));// 33 //REPORTING_FACILITY
				radiologyExamList.add(checkForNull(resultSet.getString("REPORTING_FACILITY_ID")));// 34 //REPORTING_FACILITY_ID
				radiologyExamList.add(checkForNull(resultSet.getString("REPORTING_RADIOLOGIST_ID")));// 35 //REPORTING_RADIOLOGIST_ID
				radiologyExamList.add(checkForNull(resultSet.getString("RADIOLOGIST_ID")) );// 36 //RADIOLOGIST_ID
				radiologyExamList.add(checkForNull(resultSet.getString("PRELIM_RADIOLOGIST_ID")));// 37 //PRELIM_RADIOLOGIST_ID
				radiologyExamList.add(checkForNull(resultSet.getString("ENCOUNTER_ID")));// 38 //ENCOUNTER_ID 
				radiologyExamList.add(checkForNull(resultSet.getString("EXT_APPL_ACCESSION_NUM")));// 39 //ext_appl_accession 
				radiologyExamList.add(checkForNull(resultSet.getString("note_type")));// 40 //note_type 
				radiologyExamList.add(checkForNull(resultSet.getString("exam_room")));// 41 //studyloc 
				
				System.err.println("206,radiologyexambean ,i -" + i);
			}

			if (resultSet != null && resultSet.next()) {

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		} finally {
			closeStatement(pstmt);
			closeResultSet(resultSet);
			if (connection != null)
				ConnectionManager.returnConnection(connection, properties);
		}
		return radiologyExamList;
	}

	public HashMap modify() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String key = null;
		ArrayList insertRow = new ArrayList();
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", new Boolean(false));
			map.put("message", "ERROR While updating the record in PH_DISP_DRUG_BATCH" + e.getMessage());
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (Exception eclose) {

				// TODO: handle exception
				eclose.printStackTrace();
			}
		}

		return map;
	}

	public ArrayList auditTrailDetails(String ordering_facility_id, String request_num, String request_line_num)
			throws Exception {
		ArrayList auditTrailsList = new ArrayList();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String auditTrailSql = "SELECT a.reporting_facility_id, a.reporting_radiologist_id, b.short_name,a.assign_rad_remarks, TO_CHAR (a.assign_date, 'dd/mm/yyyy hh24:mi') assign_date, a.assign_by_id,(SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE language_id = 'en' AND appl_user_id = a.added_by_id )assign_by,DECODE (a.exam_status,'50', 'Performed','60', 'On Hold','65', 'Prelim','70', 'Finalized','85', 'Modified') exam_status,(SELECT facility_name FROM sm_facility_param_lang_vw WHERE facility_id = a.reporting_facility_id AND language_id = ?) reporting_facility FROM rd_assign_radiologist_audit a, rd_radiologist b WHERE a.reporting_facility_id = b.operational_facility_id AND a.reporting_radiologist_id = b.radiologist_id AND b.language_id = ? AND a.operating_facility_id = ? AND a.request_num = ? AND a.request_line_num = ?  order by a.assign_date desc";

		try {
			connection = ConnectionManager.getConnection(properties);
			pstmt = connection.prepareStatement(auditTrailSql);
			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);
			pstmt.setString(3, ordering_facility_id);
			pstmt.setString(4, request_num);
			pstmt.setString(5, request_line_num);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				auditTrailsList.add(checkForNull(resultSet.getString("exam_status")));// 0
				auditTrailsList.add(checkForNull(resultSet.getString("ASSIGN_DATE")));// 1
				auditTrailsList.add(checkForNull(resultSet.getString("REPORTING_FACILITY")));// 2
				auditTrailsList.add(checkForNull(resultSet.getString("SHORT_NAME")));// 3
				auditTrailsList.add(checkForNull(resultSet.getString("ASSIGN_RAD_REMARKS")));// 4
				auditTrailsList.add(checkForNull(resultSet.getString("ASSIGN_BY_ID")));// 5
				auditTrailsList.add(checkForNull(resultSet.getString("ASSIGN_BY")));// 6

			}

			if (resultSet != null && resultSet.next()) {

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		} finally {
			closeStatement(pstmt);
			closeResultSet(resultSet);
			if (connection != null)
				ConnectionManager.returnConnection(connection, properties);
		}
		return auditTrailsList;
	}

	public String getFacilityName(String facility_id, String locale) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		// ArrayList FacilityList = new ArrayList();
		String facilityName = "";

		try {
			connection = getConnection();
			// pstmt =
			// connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_SM_FACILITY_SELECT"
			// )) ;
			pstmt = connection.prepareStatement(
					"select facility_name from sm_facility_param_lang_vw  where facility_id = ? and status = 'E' and language_id = ?");
			pstmt.setString(1, facility_id);
			pstmt.setString(2, locale);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				facilityName = (String) resultSet.getString("facility_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return facilityName;
	}

	public ArrayList getOrderingFacilityId(String locale) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList result = new ArrayList();
		try {
			connection = getConnection();
			// pstmt = connection.prepareStatement( PhRepository.getPhKeyValue(
			// "SQL_PH_DISPLOCN_SELECT" )) ;
			// pstmt = connection.prepareStatement("SELECT B.FACILITY_ID
			// FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM
			// SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_LANG_VW B WHERE
			// A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID
			// = ? AND B.LANGUAGE_ID= ?") ; //commented and added below sql for
			// 033992 - [PH -> ReRoute -> Ordering Facility is not shown in
			// Verification stage]
			pstmt = connection.prepareStatement(
					"SELECT FACILITY_ID ,FACILITY_NAME  FROM  SM_FACILITY_PARAM_LANG_VW  WHERE STATUS ='E'AND LANGUAGE_ID= ? order by FACILITY_NAME");
			// pstmt.setString(1,p_user_name); //Commented for 033992 //order by
			// added for ML-BRU-SCF-1517 [IN:053108]
			pstmt.setString(1, locale);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				result.add(resultSet.getString("FACILITY_ID"));
				result.add(resultSet.getString("FACILITY_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.add(e.toString());
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}
}
