/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/ 
/**
 * 
 */
package eIPAD.clinicaleventhistory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

import com.ehis.util.DateUtils;

import eCommon.Common.CommonBean;
import eIPAD.IPADConstants;

/**
 * This class represents the servlet layer which gets the data from backend
 * through jdbc api and sends the same to the presentation layer
 * 
 * @author GRamamoorthy 
 * 
 */
public class ClinicalEventHistory implements Serializable {

	/**
	 * Stores the date format string which will be used for
	 * presentation purpose
	 */
	public static final String DATE_FORMAT_STRING = "dd/MM/yyyy HH:mm";
	
	/**
	 * Default constructor of the class
	 */
	public ClinicalEventHistory() {
	}

	/**
	 * This method gets the patient class
	 * 
	 * @return TODO
	 */
	public PatientClassResponse getPatientClass(PatientClassRequest request) {
		PatientClassResponse response = new PatientClassResponse();
		// this var stores the SQL query
		StringBuffer sqlStr = new StringBuffer("");

		String patientId = request.getPatientId();
		String facilityId = request.getFacilityId();
		// form the query
		sqlStr.append("SELECT patient_id, patient_class, added_date FROM pr_encounter WHERE patient_id =");
		sqlStr.append(patientId);
		sqlStr.append(" AND facility_id =");
		sqlStr.append(facilityId);
		sqlStr.append(" AND added_date = (SELECT MAX (added_date) FROM pr_encounter WHERE patient_id = ");
		sqlStr.append(patientId);
		sqlStr.append(" AND facility_id =");
		sqlStr.append(facilityId);

		HttpServletRequest servletRequest = request.getRequest();
		Connection conn = ConnectionManager.getConnection(servletRequest);
		// safe check
		if (conn != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlStr.toString());
				if (rs != null) {
					String patientClass = null;
					while(rs.next()){
						patientClass = rs.getString("patient_class");
					}
					// set the patient class to the response class
					response.setPatientClass(patientClass);
				}
			} catch (SQLException e) {
				// need to handle this exception part properly
			} finally {
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
					}
				}
				if(stmt != null){
					try {
						stmt.close();
					} catch (SQLException e) {
					}
				}
				ConnectionManager.returnConnection(conn);
			}
		}

		return response;

	}
	
	/**
	 * This method gets the patient class and encounter ids for a given time period
	 * @return TODO
	 * 
	 */
	public PatientClassAndEncounterIdResponse getPatientClassAndEncounterIdList(
			PatientClassAndEncounterIdRequest request) {
		PatientClassAndEncounterIdResponse response = new PatientClassAndEncounterIdResponse();
		Map<PatientClassResponse, List<EncounterIdContainer>> dataMap = response.getDataMap();
		// safe check
		if(request == null){
			return response;
		}
		
		String patientId = request.getPatientId();
		String facilityId = request.getFacilityId();
		String selectedTimePeriod = request.getSelectedTimePeriod();
		String patientClassType = request.getPatientClass();
		patientClassType = CommonBean.checkForNull(patientClassType, IPADConstants.INPATIENT_KEYWORD);

		List<String> timePeriodList = getSelectedTimePeriod(selectedTimePeriod, patientId);
		// there is no need to check the indexes as the above called method
		// will always return a list of two dates, the from date in the first
		// index and the to date in the second index
		String fromDate = timePeriodList.get(0);
		String toDate = timePeriodList.get(1);
		
		// this buffer will contain the SQL query which will be executed
		StringBuffer queryBuff = new StringBuffer();
		queryBuff.append("Select Facility_id,encounter_id,patient_id,patient_class,VISIT_ADM_DATE_TIME,ADDED_DATE from pr_encounter where patient_id='");
		queryBuff.append(patientId).append("'");
		queryBuff.append(" and facility_id='");
		queryBuff.append(facilityId).append("'");
		
		queryBuff.append(" and PATIENT_CLASS='");
		queryBuff.append(patientClassType).append("'");
		
		queryBuff.append(" and added_date >=TO_DATE ('");
		queryBuff.append(fromDate).append("'");
		queryBuff.append(", 'dd/mm/yyyy hh24:mi') and added_date <=TO_DATE ('");
		queryBuff.append(toDate).append("'");
		queryBuff.append(", 'dd/mm/yyyy hh24:mi')");
		
		// these variables are used primarly to get connection
		HttpServletRequest servletRequest = request.getRequest();
		HttpSession session = request.getSession();
		
		// get the connection
		Connection conn = null;
		conn = ConnectionManager.getConnection(servletRequest);
		
		if(conn != null){
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(queryBuff.toString());
				if(rs != null){
					String patientClass = null;
					PatientClassResponse tempPatientClassObj = null;
					List<EncounterIdContainer> encounterIdList = null;
					String encounterId= null;
					EncounterIdContainer encounterIdWrapper = null;
					while(rs.next()){
						patientClass = rs.getString("patient_class");
						tempPatientClassObj = new PatientClassResponse();
						tempPatientClassObj.setPatientClass(patientClass);
						
						if(dataMap.containsKey(tempPatientClassObj)){
							encounterIdList = dataMap.get(tempPatientClassObj);
						}else{
							encounterIdList = new ArrayList<EncounterIdContainer>();
							dataMap.put(tempPatientClassObj, encounterIdList);
						}
						
						encounterId = rs.getString("encounter_id");
						encounterIdWrapper = new EncounterIdContainer();
						encounterIdWrapper.setEncounterId(encounterId);
						encounterIdList.add(encounterIdWrapper);
					}
				}
			} catch (SQLException e) {
				// need to properly handle this exception
			} finally {
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
					}
				}
				if(stmt != null){
					try {
						stmt.close();
					} catch (SQLException e) {
					}
				}
				ConnectionManager.returnConnection(conn);
			}
		}
		
		
		return response;
	}
	
	/**
	 * 
	 * @param selectedTimePeriod
	 * @param patientId
	 * @return
	 */
	public static List<String> getSelectedTimePeriod(String selectedTimePeriod,
			String patientId){
		return getSelectedTimePeriod(selectedTimePeriod, patientId, DATE_FORMAT_STRING);
	}
	
	/**
	 * This utility method returns a list of two date strings
	 * given a selected time period.
	 * The selected time period will be either of "LOD","LTD","LOW","LOM" 
	 * or "LOY"
	 * This method will take this value and calculate two dates with respect
	 * to the current date time value.
	 * This method will return the from date and the to date in the list in
	 *  that order
	 * @param selectedTimePeriod
	 * @param patientId TODO
	 * @param formatterString TODO
	 * @return
	 */
	public static List<String> getSelectedTimePeriod(String selectedTimePeriod,
			String patientId, String formatterString) {
		List<String> selectedTimePeriodList = new ArrayList<String>();
		
		Calendar fromCal = Calendar.getInstance();
		Calendar toCal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(formatterString);
		if(selectedTimePeriod == null || selectedTimePeriod.trim().equals("")){
			fromCal.add(Calendar.DATE, -1);
		}
		
		// this conditional loop checks for the selected time period
		// with the standard time periods and forms the date
		if(IPADConstants.LAST_ONE_DAY.equals(selectedTimePeriod)){
			fromCal.add(Calendar.DATE, -1);
			/**
			 * TODO
			 * The following code is only for testing purposes
			 * this code should be deleted once the functionality
			 * is tested properly
			 */
			/*if(patientId != null && patientId.equals("MC00000345")){
				fromCal.add(Calendar.YEAR,-2);
			}*/
		}else if(IPADConstants.LAST_THREE_DAYS.equals(selectedTimePeriod)){
			fromCal.add(Calendar.DATE, -3);
		}else if(IPADConstants.LAST_ONE_WEEK.equals(selectedTimePeriod)){
			fromCal.add(Calendar.WEEK_OF_YEAR, -1);
		}else if(IPADConstants.LAST_ONE_MONTH.equals(selectedTimePeriod)){
			fromCal.add(Calendar.MONTH, -1);
		}else if(IPADConstants.LAST_ONE_YEAR.equals(selectedTimePeriod)){
			fromCal.add(Calendar.YEAR, -1);
		}else if(IPADConstants.LAST_TWO_YEARS.equals(selectedTimePeriod)){
			fromCal.add(Calendar.YEAR, -2);
		}
		
		String fromDateAsString = formatter.format(fromCal.getTime());
		String toDateAsString = formatter.format(toCal.getTime());
		
		selectedTimePeriodList.add(fromDateAsString);
		selectedTimePeriodList.add(toDateAsString);
		return selectedTimePeriodList;
	}
	
	
	/**
	 * This is the main method in this class - gets the list
	 * of event history records to be shown in the GUI
	 * 
	 * @param request
	 * @return TODO
	 */
	public EventHistoryResponse getEventHistory(EventHistoryRequest request){
		EventHistoryResponse response = new EventHistoryResponse();
		
		// safe check
		if(request == null){
			return response;
		}
		
		// get the various inputs needed from the input request object
		HttpServletRequest servletRequest = request.getRequest();
		
		// initialize the connection object
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return response;
		}
		
		// code added to get the event history records which
		// will be used in the SQL query used to get event history
		EventHistoryRecordRequest eventHistoryRecordRequest = new EventHistoryRecordRequest();
		eventHistoryRecordRequest.setRequest(request.getRequest());
		eventHistoryRecordRequest.setSession(request.getSession());
		eventHistoryRecordRequest.setLocale(request.getLocale());
		EventHistoryRecordResponse eventHistoryRecordResponse = getEventHistoryRecords(eventHistoryRecordRequest);
		
		PatientLineDetailRequest patientLineRequest = new PatientLineDetailRequest();
		patientLineRequest.setRequest(request.getRequest());
		patientLineRequest.setSession(request.getSession());
		patientLineRequest.setLocale(request.getLocale());
		PatientLineDetailResponse patientLineResponse = getPatientLineRecord(patientLineRequest);
		
		// get the SQL query to be executed
		String query = getEventHistoryQuery(request, patientLineResponse,
				eventHistoryRecordResponse);
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(query);
			setDataInPrepStmtForEventHistory(prepStmt, request,
					eventHistoryRecordResponse);
			rs = prepStmt.executeQuery();
			populateResponseFromResultSet(request, response, rs);
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this properly
			 */
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(prepStmt != null){
				try {
					prepStmt.close();
				} catch (SQLException e) {
				}
			}
			ConnectionManager.returnConnection(conn,servletRequest);
		}
		
		return response;
	}
	
	/**
	 * This method retrieves the number of event history records
	 * With these records, the data about the individual event history
	 * records are displayed
	 * @param recordRequest
	 * @return
	 */
	public EventHistoryRecordResponse getEventHistoryRecords(
			EventHistoryRecordRequest recordRequest) {
		EventHistoryRecordResponse recordResponse = new EventHistoryRecordResponse();
		// safe check
		if(recordRequest == null){
			return recordResponse;
		}
		
		// initialize the connection
		HttpServletRequest servletRequest = recordRequest.getRequest();
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return recordResponse;
		}
		
		String sqlQuery = getEventHistoryRecordQuery(recordRequest);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPrepStmtForRowIds(prepStmt,recordRequest);
			rs = prepStmt.executeQuery();
			if(rs != null){
				processEventHistoryRecordResponse(rs,recordResponse);	
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to properly handle this part
			 */
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			
			if(prepStmt != null){
				try {
					prepStmt.close();
				} catch (SQLException e) {
				}
			}
			
			ConnectionManager.returnConnection(conn);
		}
		
		
		return recordResponse;
	}
	
	
	/**
	 * 
	 * @param patientLineRequest
	 * @return
	 */
	private PatientLineDetailResponse getPatientLineRecord(
			PatientLineDetailRequest patientLineRequest) {
		PatientLineDetailResponse patientLineResponse = new PatientLineDetailResponse();
		if(patientLineRequest == null){
			return patientLineResponse;
		}
		
		HttpServletRequest servletRequest = patientLineRequest.getRequest();
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return patientLineResponse;
		}
		HttpSession session = patientLineRequest.getSession();
		String patientId = servletRequest.getParameter("patientid");
		patientId = CommonBean.checkForNull(patientId);
		String locale = patientLineRequest.getLocale();
		final String confResultKey = "VIEW_CONF_RESULT";
		String responsibilityId = (String)session.getValue("responsibility_id");
		String relationshipId = servletRequest.getParameter("relationship_id");
		relationshipId = CommonBean.checkForNull(relationshipId);
		
		String query = "select get_patient.get_line_detail(?,?) Pline, nvl(GET_TASK_APPLICABILITY(?,NULL,?,?),'X') conf_access_flag FROM dual ";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		String patientLine = null;
		String confAccess = null;
		try {
			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, patientId);
			prepStmt.setString(2,locale);
			prepStmt.setString(3, confResultKey);
			prepStmt.setString(4, responsibilityId);
			prepStmt.setString(5, relationshipId);
			
			rs = prepStmt.executeQuery();
			if(rs != null && rs.next())
			{
				patientLine = rs.getString("Pline").replace('|',',');
				confAccess =rs.getString("conf_access_flag");
				patientLineResponse.setPatientLine(patientLine);
				patientLineResponse.setConfAccess(confAccess);
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this properly
			 */
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(prepStmt != null){
				try {
					prepStmt.close();
				} catch (SQLException e) {
				}
			}
			ConnectionManager.returnConnection(conn, servletRequest);
		}
		
		return patientLineResponse;
	}
	
	
	/**
	 * 
	 * @param histRecType
	 * @param controlSysId
	 * @param accessionNum
	 * @param controlSysEventCode
	 * @return
	 */
	private int getHistoryDataCountForEvent(String histRecType, String controlSysId,
			String accessionNum, String controlSysEventCode) {
		int recordCount = 0;
		String query = "select count(*) from CR_ENCOUNTER_DETAIL_TXT where hist_rec_type =? and contr_sys_id = ? and accession_num = ? and contr_sys_event_code=? and dbms_lob.getlength(hist_data)>0";
		Connection conn = ConnectionManager.getConnection();
		if(conn == null){
			return recordCount;
		}
		PreparedStatement stHist = null;
		ResultSet rs = null;
		try {
			stHist=conn.prepareStatement(query);
			stHist.setString(1,histRecType);
			stHist.setString(2,controlSysId);
			stHist.setString(3,accessionNum);
			stHist.setString(4,controlSysEventCode);
			
			rs=stHist.executeQuery();
			if(rs != null){
				while(rs.next()){
					recordCount = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this properly
			 */
		}finally{
			
			ConnectionManager.returnConnection(conn);
		}
		
		return recordCount;
	}
	
	
	/**
	 * 
	 * @param prepStmt
	 * @param eventHistoryRequest
	 * @param eventHistoryRecordResponse
	 */
	private void setDataInPrepStmtForEventHistory(PreparedStatement prepStmt,
			EventHistoryRequest eventHistoryRequest,
			EventHistoryRecordResponse eventHistoryRecordResponse) throws SQLException{
		String locale = eventHistoryRequest.getLocale();
		String patientId = eventHistoryRequest.getPatientId();
		
		HttpServletRequest servletRequest = eventHistoryRequest.getRequest();
		// get the selected time period and get the from period and to period
		String selectedTimePeriod = eventHistoryRequest.getSelectedTimePeriod();
		List<String> selectedTimePeriodList = getSelectedTimePeriod(
				selectedTimePeriod, "");
		String fromPeriod = "";
		String toPeriod = "";
		if(selectedTimePeriodList != null && selectedTimePeriodList.size() == 2){
			fromPeriod = selectedTimePeriodList.get(0);
			toPeriod = selectedTimePeriodList.get(1);
		}
		
		// now get the individual data which needs to be set
		// to the prepared statement
		String eventDate = servletRequest.getParameter("event_date");
		eventDate = CommonBean.checkForNull(eventDate);
		
		String viewby = servletRequest.getParameter("view_by");
		viewby = CommonBean.checkForNull(viewby, "N");
		
		String selectedhisrectype = servletRequest.getParameter("hist_type");
		selectedhisrectype = CommonBean.checkForNull(selectedhisrectype);
		
		String selectedeventclass = servletRequest.getParameter("event_class");
		selectedeventclass = CommonBean.checkForNull(selectedeventclass);
		
		String selectedeventgroup = servletRequest.getParameter("event_group");
		selectedeventgroup = CommonBean.checkForNull(selectedeventgroup);
		
		String selectedeventcode = servletRequest.getParameter("event_item");
		selectedeventcode = CommonBean.checkForNull(selectedeventcode);
		
		String facilityId = servletRequest.getParameter("facility_id");
		facilityId = CommonBean.checkForNull(facilityId);
		
		String encounterId = servletRequest.getParameter("encounter_id");
		encounterId = CommonBean.checkForNull(encounterId);
		
		// var to represent the index for setting data in prepared statement
		int index = 0;
		prepStmt.setString(++index, locale);
		prepStmt.setString(++index, locale);
		prepStmt.setString(++index, locale);
		prepStmt.setString(++index, locale);
		prepStmt.setString(++index, locale);
		prepStmt.setString(++index, patientId);
		
		if(!eventDate.equals("") && viewby.equals("D")){
			prepStmt.setString(++index,eventDate);
		}
		if(!selectedhisrectype.equals("")){
			prepStmt.setString(++index,selectedhisrectype);
		}
		if(!selectedeventclass.equals("")){
			prepStmt.setString(++index,selectedeventclass);
		}
		if(!selectedeventgroup.equals("")){
			prepStmt.setString(++index,selectedeventgroup);
		}
		if(!selectedeventcode.equals("")){
			prepStmt.setString(++index,selectedeventcode);
		}
		if(!fromPeriod.equals("")){
			prepStmt.setString(++index,fromPeriod);
		}
		if(!toPeriod.equals("")){
			prepStmt.setString(++index,toPeriod);
		}
		if(!facilityId.equals("")){
			prepStmt.setString(++index,facilityId);
		}
		if(!encounterId.equals("")){
			prepStmt.setString(++index,encounterId);
		}
		
		/*// now set the row ids in the prepared statement
		StringBuffer str_rowid = new StringBuffer();
		List<EventHistoryModel> eventHistoryModelList = eventHistoryRecordResponse
				.getEventHistoryModelList();
		// safe check
		if(eventHistoryModelList == null){
			str_rowid.append("' '");
			prepStmt.setString(++index,str_rowid.toString());
			return;
		}
		String rowId = null;
		for(EventHistoryModel historyModel : eventHistoryModelList){
			rowId = historyModel.getRowId();
			str_rowid.append("'").append(rowId).append("'");
			str_rowid.append(",");
		}
		// now remove the last "," from str_rowid
		str_rowid.delete(str_rowid.length()-1, str_rowid.length());
		prepStmt.setString(++index,str_rowid.toString());*/
		
	}
	
	
	/**
	 * 
	 */
	private void processEventHistoryRecordResponse(ResultSet rs,
			EventHistoryRecordResponse recordResponse) {
		List<EventHistoryModel> eventHistoryModelList = recordResponse
				.getEventHistoryModelList();
		EventHistoryModel historyModel = null;
		try {
			String rowId = null;
			while(rs.next()){
				rowId = rs.getString("row_id");
				if(rowId == null){
					rowId = "";
				}
				historyModel = new EventHistoryModel();
				historyModel.setRowId(rowId);
				eventHistoryModelList.add(historyModel);
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this properly
			 */
		}
	}
	
	
	/**
	 * 
	 * @param recordRequest
	 * @return
	 */
	private String getEventHistoryRecordQuery(EventHistoryRecordRequest recordRequest){
		StringBuffer queryBuff = new StringBuffer();
		String locale = recordRequest.getLocale();
		queryBuff.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.event_class, CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,'"+locale+"','1')  event_class_desc, a.event_group, CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,'"+locale+"','1') event_group_desc,a.event_code, CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.rowid row_id From	cr_encounter_detail a ,PR_ENCOUNTER F ");
		
		String strHistRecType = recordRequest.getParameter("hist_type");
		String strEventClass = recordRequest.getParameter("event_class");
		String strEventGroup = recordRequest.getParameter("event_group");
		String strEventCode = recordRequest.getParameter("event_item");
		String selectedTimePeriod = recordRequest.getParameter("selectedPeriod");
		List<String> selectedTimePeriodList = getSelectedTimePeriod(
				selectedTimePeriod, "");
		String fromPeriod = "";
		String toPeriod = "";
		if(selectedTimePeriodList != null && selectedTimePeriodList.size() == 2){
			fromPeriod = selectedTimePeriodList.get(0);
			toPeriod = selectedTimePeriodList.get(1);
		}
		fromPeriod = DateUtils.convertDate(fromPeriod,"DMYHM",locale,locale);
		toPeriod = DateUtils.convertDate(toPeriod,"DMYHM",locale,locale);
		
		String eventdate = recordRequest.getParameter("event_date");
		String strViewConfRes = recordRequest.getParameter("view_by");
		String strFacilityId = recordRequest.getParameter("facility_id");
		String strEncounterId = recordRequest.getParameter("encounter_id");
		String strEpisodeType = recordRequest.getParameter("episode_type");
		String strAbnormal = recordRequest.getParameter("abnormal");
		strAbnormal = CommonBean.checkForNull(strAbnormal, "N");
		String strErrorEvent = "";

		// stores the where clause part
		StringBuffer sbQryCriteria = new StringBuffer();
		sbQryCriteria.append(" a.patient_id = ? AND F.FACILITY_ID(+)= a.FACILITY_ID AND F.ENCOUNTER_ID(+) = a.ENCOUNTER_ID ");

		if(!strHistRecType.equals(""))
			sbQryCriteria.append(" and a.hist_rec_type = ? ");

		if(!strEventClass.equals(""))
			sbQryCriteria.append(" and a.event_class = ? ");

		if(!strEventGroup.equals(""))
			sbQryCriteria.append(" and a.event_group = ? ");

		if(!strEventCode.equals(""))
			sbQryCriteria.append(" and rtrim(a.event_code) = ? ");

		if(!fromPeriod.equals(""))
			sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

		if(!toPeriod.equals(""))
			sbQryCriteria.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287"); //adding 59 seconds more to the todate
			
		if(!eventdate.equals("") && strViewConfRes.equals("D"))
			sbQryCriteria.append(" and  trunc(a.event_date)= to_date(?,'dd/mm/yyyy')");

		if(!strFacilityId.equals(""))
			sbQryCriteria.append(" and a.facility_id = ? ");

		if(!strEncounterId.equals(""))
			sbQryCriteria.append(" and a.encounter_id = ? ");

		if (!strEpisodeType.equals("B") )
			sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

		if(strAbnormal.equals("Y"))
		{
			sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}

		if(strViewConfRes.equals("X"))
			sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");

		if(strErrorEvent.equals("Y"))//dont'include error events
			sbQryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
		else 
			sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')"); 
		
		// sort order
		String sortOrder = recordRequest.getParameter("sortOrder");
		
		queryBuff.append(" where ").append(sbQryCriteria.toString());
		queryBuff.append(" order by ");
		queryBuff.append(" 1 ");
		queryBuff.append(sortOrder+" ,");

		if(strViewConfRes.equals("D")) 
		{
			queryBuff.append(" TO_CHAR(event_date,'YYYYMMDD') ");
			queryBuff.append(sortOrder+" ,") ;
	     }
		queryBuff.append(" 3,2,5,4,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,9,8, event_date ");
		queryBuff.append(sortOrder);
		
		return queryBuff.toString();
	}
	
	
	/**
	 * This method gets the SQL query needed for getting the 
	 * event history records
	 * @param request
	 * @param patientLineDetailResponse TODO
	 * @param eventHistoryRecordResponse TODO
	 * @return
	 */
	private String getEventHistoryQuery(EventHistoryRequest request,
			PatientLineDetailResponse patientLineDetailResponse,
			EventHistoryRecordResponse eventHistoryRecordResponse) {
		StringBuffer queryBuff = new StringBuffer();
		
		String locale = request.getLocale();
		HttpServletRequest servletRequest = request.getRequest();
		HttpSession session = request.getSession();
		String patientId = request.getPatientId();
		String selectedTimePeriod = request.getSelectedTimePeriod();
		String encounterId = request.getEncounterId();
		List<String> selectedTimePeriodList = getSelectedTimePeriod(
				selectedTimePeriod, "");
		String fromPeriod = "";
		String toPeriod = "";
		if(selectedTimePeriodList != null && selectedTimePeriodList.size() == 2){
			fromPeriod = selectedTimePeriodList.get(0);
			toPeriod = selectedTimePeriodList.get(1);
		}
		
		String abnormal = servletRequest.getParameter("abnormal");
		abnormal = CommonBean.checkForNull(abnormal);
		
		String eventdate = servletRequest.getParameter("event_date");
		eventdate = CommonBean.checkForNull(eventdate);
		
		String viewby = servletRequest.getParameter("view_by");
		viewby = CommonBean.checkForNull(viewby, "N");
			
		String facility_id = servletRequest.getParameter("facility_id");
		facility_id = CommonBean.checkForNull(facility_id);
		
		String encounter_id = servletRequest.getParameter("encounter_id");
		encounter_id =  CommonBean.checkForNull(encounter_id);
		
		String selectedhisrectype = servletRequest.getParameter("hist_type");
		selectedhisrectype = CommonBean.checkForNull(selectedhisrectype);
		
		String selectedeventclass = servletRequest.getParameter("event_class");
		selectedeventclass = CommonBean.checkForNull(selectedeventclass);
		
		String selectedeventgroup = servletRequest.getParameter("event_group");
		selectedeventgroup = CommonBean.checkForNull(selectedeventgroup);
		
		String selectedeventcode = servletRequest.getParameter("event_item");
		selectedeventcode = CommonBean.checkForNull(selectedeventcode);
		
		String sortOrder = "desc";
		
		queryBuff.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, " +
				"a.hist_rec_type," +
				"CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc," +
				"a.event_class," +
				"CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc," +
				"a.event_group," +
				"CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc," +
				"a.event_code," +
				"CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ," +
				"a.accession_num,a.contr_sys_id," +
				"a.contr_sys_event_code," +
				"to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time," +
				"to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date," +
				"a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, " +
				"DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, " +
				"a.RESULT_NUM_UOM," +
				"a.result_str,a.normalcy_ind," +
				"DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ," +
				"DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ," +
				"DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ," +
				"DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high," +
				"a.performed_by_id ," +
				"AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name," +
				"CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ," +
						"a.NORMAL_LOW," +
						"a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ," +
						"a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID," +
						"a.STATUS,a.normalcy_ind," +
						"(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, " +
						"a.DELTA_FAIL_IND ," +
						"NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT," +
						"a.encounter_ID, " +
						"a.NORMALCY_STR " +
						"From cr_encounter_detail a ,PR_ENCOUNTER F " +
						"where a.patient_id = ? AND " +
						"F.FACILITY_ID(+)= A.FACILITY_ID AND " +
						"F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
		
		String conf_access_flag = "";
		if(patientLineDetailResponse != null){
			conf_access_flag = patientLineDetailResponse.getConfAccess();
			conf_access_flag = CommonBean.checkForNull(conf_access_flag);
		}
		if (!conf_access_flag.equals("A")){
			queryBuff.append(" and nvl(a.PROTECTION_IND,'N')!='Z' ");
		}

		queryBuff.append(" and nvl(a.STATUS,'`') not in('S','E')");  

		if(abnormal.equals("Y")) //to limit to abnormal events only
		{
			queryBuff.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}

		if(!eventdate.equals("") && viewby.equals("D"))
			queryBuff.append(" and  trunc(a.event_date)= to_date(?,'dd/mm/yyyy')");
		
		if(!selectedhisrectype.equals(""))
			queryBuff.append(" and a.hist_rec_type = ? ");
		if(!selectedeventclass.equals(""))
			queryBuff.append(" and a.EVENT_CLASS = ? ");
		if(!selectedeventgroup.equals(""))
			queryBuff.append(" and a.EVENT_GROUP = ? ");
		if(!selectedeventcode.equals(""))
			queryBuff.append(" and rtrim(a.EVENT_CODE) = ? ");
		if(!fromPeriod.equals("")){
			queryBuff.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
		}

		if(!toPeriod.equals("")){
			queryBuff.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 "); //adding 59 seconds more to the todate
		}

		if(!facility_id.equals(""))
			queryBuff.append(" and a.facility_id = ?");

		if(!encounter_id.equals(""))
			queryBuff.append(" and a.ENCOUNTER_ID = ? ");
		
		StringBuffer str_rowid = new StringBuffer();
		List<EventHistoryModel> eventHistoryModelList = eventHistoryRecordResponse
				.getEventHistoryModelList();
		// safe check
		if(eventHistoryModelList == null || eventHistoryModelList.isEmpty()){
			str_rowid.append("' '");
		}
		String rowId = null;
		for(EventHistoryModel historyModel : eventHistoryModelList){
			rowId = historyModel.getRowId();
			str_rowid.append("'").append(rowId).append("'");
			str_rowid.append(",");
		}
		// now remove the last "," from str_rowid
		if(!eventHistoryModelList.isEmpty()){
			if(str_rowid.length() > 0){
				str_rowid.delete(str_rowid.length()-1, str_rowid.length());	
			}else{
				str_rowid.append("' '");
			}	
		}
		
		
		queryBuff.append(" and a.rowid in ( ").append(str_rowid.toString()).append(" ) ");
		
		queryBuff.append(" order by ");
		
		queryBuff.append(" 1 ");
		queryBuff.append(sortOrder+" ,");
		
		if(viewby.equals("D")) 
		{
			queryBuff.append(" TO_CHAR(event_date,'YYYYMMDD') ");
			queryBuff.append(sortOrder+" ,") ;
		}

		queryBuff.append(" 3,2,5,4,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,9,8, event_date ");
		queryBuff.append(sortOrder);

		
		/*queryBuff.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, ");
		queryBuff.append("b.short_desc hist_rec_type_desc, a.hist_rec_type HIST_REC_TYPE, "); 
		queryBuff.append("c.long_desc event_class_desc, ");
		queryBuff.append("a.event_class EVENT_CLASS, "); 
		queryBuff.append("nvl(a.event_group,'*ALL') EVENT_GROUP, "); 
		queryBuff.append("nvl(e.long_desc,d.long_desc) event_group_desc, "); 
		queryBuff.append("d.long_desc  event_code_desc, "); 
		queryBuff.append("rtrim(a.event_code) event_code, count(*) rec_count, ");
		queryBuff.append("a.facility_id facility_id, ");
		queryBuff.append("F.patient_class patient_class, ");
		queryBuff.append("a.encounter_id encounter_id, ");
		queryBuff.append("CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class, ");
		queryBuff.append("F.ENCOUNTER_ID,A.PATIENT_ID,").append("'").append(locale).append("') ENCLINE "); 
		queryBuff.append("From "); 
		queryBuff.append("cr_encounter_detail a, ");
		queryBuff.append("CR_HIS_RECTYP_LNG_VW b, ");
		queryBuff.append("CR_EVENT_CLASS_LANG_VW c , ");
		queryBuff.append("CR_CLN_EVT_MST_LANG_VW d, ");
		queryBuff.append("CR_CLN_EVT_GRP_LANG_VW e, "); 
		queryBuff.append("(SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM, ");
		queryBuff.append("(SELECT TO_CHAR(START_DATE_TIME,'DD/MM/YYYY HH24:MI') ||'-'|| TO_CHAR(END_DATE_TIME,'DD/MM/YYYY HH24:MI') ||','||AM_GET_DESC.AM_SERVICE ");

		queryBuff.append("(A.SERVICE_CODE,").append("'").append(locale).append("','2')||','||decode(EPISODE_STATUS,'01','Open','08','Close') status "); 
		queryBuff.append("from ");  
		queryBuff.append("OP_EPISODE_FOR_SERVICE A, ");
		queryBuff.append("AM_SERVICE B "); 
		queryBuff.append("WHERE B.SERVICE_CODE=A.SERVICE_CODE "); 
		queryBuff.append("AND A.OPERATING_FACILITY_ID=PR_ENCOUNTER.FACILITY_ID "); 
		queryBuff.append("AND EPISODE_ID=PR_ENCOUNTER.EPISODE_ID and rownum='1') EPISODE_DESC "); 
		queryBuff.append("FROM PR_ENCOUNTER WHERE PATIENT_ID='").append(patientId).append("' ) F "); 
		queryBuff.append("where b.language_id = '").append(locale).append("' "); 
		queryBuff.append("and c.language_id = '").append(locale).append("' "); 
		queryBuff.append("and d.language_id = '").append(locale).append("' "); 
		queryBuff.append("and e.language_id(+) = '").append(locale).append("' "); 
		queryBuff.append("and b.hist_rec_type=a.hist_rec_type "); 
		queryBuff.append("and  c.hist_rec_type= a.hist_rec_type "); 
		queryBuff.append("and  c.event_class= a.event_class "); 
		queryBuff.append("and  d.hist_rec_type=a.hist_rec_type "); 
		queryBuff.append("and  d.event_code=rtrim(a.event_code) ");  
		queryBuff.append("and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE "); 
		queryBuff.append("and  e.hist_rec_type(+)=a.hist_rec_type "); 
		queryBuff.append("and  e.event_group(+)=a.event_group "); 
		queryBuff.append("and e.EVENT_GROUP_TYPE(+) = a.EVENT_GROUP_TYPE "); 
		queryBuff.append("AND F.FACILITY_ID(+)= A.FACILITY_ID "); 
		queryBuff.append("AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); 
		queryBuff.append("AND a.patient_id = '").append(patientId).append("' "); 
		queryBuff.append("and (nvl(PROTECTION_IND,'N')!='Z' OR (nvl(PROTECTION_IND,'N')='Z' ");  
		queryBuff.append("and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) ");
		queryBuff.append("and a.ENCOUNTER_ID = '").append(encounterId).append("' ");
		queryBuff.append("and A.EVENT_DATE >= to_date(NVL('").append(fromPeriod).append("','01/01/1000'),'dd/mm/yyyy hh24:mi') ");  
		queryBuff.append("and A.EVENT_DATE <= to_date(NVL('").append(toPeriod).append("','01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 ");  
		queryBuff.append("group by  NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL'), "); 
		queryBuff.append("TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI'), ");
		queryBuff.append("b.short_desc ,a.hist_rec_type ,c.long_desc  ,");
		queryBuff.append("CA_GET_VISIT_DTL_NEW(F.FACILITY_ID,F.patient_class,F.ENCOUNTER_ID,A.PATIENT_ID,'").append(locale).append("' ), ");
		queryBuff.append("a.event_class ,nvl(a.REQUEST_NUM_SEQ,'0'),nvl(a.event_group,'*ALL') , ");
		queryBuff.append("a.facility_id ,F.patient_class ,a.encounter_id,nvl(e.long_desc,d.long_desc), ");
		queryBuff.append("d.long_desc ,rtrim(a.event_code) "); 
		queryBuff.append("order by 1 desc ,2,3,4,5,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,8,9 ");
*/		
		return queryBuff.toString();
	}

	/**
	 * This method populates the response with data obtained
	 * from the resultset
	 * @param request
	 * @param response
	 * @param rs
	 */
	private void populateResponseFromResultSet(EventHistoryRequest request,
			EventHistoryResponse response, ResultSet rs) throws SQLException {
		if(rs == null){
			return;
		}
		
		List<EventHistoryRecord> eventHistoryRecordList = new ArrayList<EventHistoryRecord>();
		
		int quick_text_count = 0;
		String histdatatype = null;
		String histrectype = null;
		String accessionnum = null;
		String enctr_id = null;
		String eventdatetime = null;
		String sortEventDateTime = null;
		String histtypedesc = null;
		String eventclassdesc = null;
		String eventgroupdesc = null;
		String eventdesc = null;
		String resultstr = null;
		String normalcy_str = null;
		String encline = null;
		String extimageapplid = null;
		String performed_by = null;
		String contr_sys_id = null;
		String contr_sys_event_code = null;
		String normalrange1 = null;
		String normalrange2 = null;
		String color_cell_indicator = null;
		String symbol_legend_ind = null;
		String descCellInd = null;
		String normalcy_ind = null;
		String criticalrange1 = null;
		String criticalrange2 = null;
		String strStatus = null;
		String delta_fail_id_ind = null;
		String resultNum = null;
		String resultNumPrefix = null;
		String result_uom = null;
		
		int historyRecordCount = 0;
		// iterate through the result set and get the data
		while(rs.next()){
			quick_text_count = rs.getInt("QUICK_TEXT_COUNT");
			histdatatype = rs.getString("HIST_DATA_TYPE");
			histdatatype = CommonBean.checkForNull(histdatatype);
			
			histrectype = rs.getString("HIST_REC_TYPE");
			histrectype = CommonBean.checkForNull(histrectype);
			
			accessionnum = rs.getString("ACCESSION_NUM");
			accessionnum = CommonBean.checkForNull(accessionnum);
			
			enctr_id = rs.getString("encounter_ID");
			enctr_id = CommonBean.checkForNull(enctr_id);
			
			eventdatetime = rs.getString("event_date_time");
			eventdatetime = CommonBean.checkForNull(eventdatetime);
			
			sortEventDateTime = rs.getString("sort_event_date");
			sortEventDateTime = CommonBean.checkForNull(sortEventDateTime);
			
			histtypedesc = rs.getString("hist_rec_type_desc");
			histtypedesc = CommonBean.checkForNull(histtypedesc);
			
			eventclassdesc = rs.getString("event_class_desc");
			eventclassdesc = CommonBean.checkForNull(eventclassdesc);
			
			eventgroupdesc = rs.getString("event_group_desc");
			eventgroupdesc = CommonBean.checkForNull(eventgroupdesc);
			
			eventdesc = rs.getString("event_desc");
			eventdesc = CommonBean.checkForNull(eventdesc);
			
			resultstr = rs.getString("RESULT_STR");
			resultstr = CommonBean.checkForNull(resultstr);
			
			normalcy_str = rs.getString("NORMALCY_STR");
			normalcy_str = CommonBean.checkForNull(normalcy_str);
			
			encline = rs.getString("encline");
			encline = CommonBean.checkForNull(encline);
			
			extimageapplid = rs.getString("EXT_IMAGE_APPL_ID");
			extimageapplid = CommonBean.checkForNull(extimageapplid);
			
			performed_by = rs.getString("clinician_short_name");
			performed_by = CommonBean.checkForNull(performed_by);
			
			contr_sys_id = rs.getString("contr_sys_id");
			contr_sys_id = CommonBean.checkForNull(contr_sys_id);
			
			contr_sys_event_code = rs.getString("contr_sys_event_code");
			contr_sys_event_code = CommonBean.checkForNull(contr_sys_event_code);
			
			normalrange1 = rs.getString("NORMAL_LOW");
			normalrange1 = CommonBean.checkForNull(normalrange1);
			
			normalrange2 = rs.getString("NORMAL_HIGH");
			normalrange2 = CommonBean.checkForNull(normalrange2);
			
			color_cell_indicator = rs.getString("COLOR_CELL_IND");
			color_cell_indicator = CommonBean.checkForNull(color_cell_indicator);
			
			symbol_legend_ind = rs.getString("SYMBOL_LEGEND_IND");
			symbol_legend_ind = CommonBean.checkForNull(symbol_legend_ind);
			
			descCellInd = rs.getString("DESC_CELL_IND");
			descCellInd = CommonBean.checkForNull(descCellInd);
			
			normalcy_ind = rs.getString("normalcy_ind");
			normalcy_ind = CommonBean.checkForNull(normalcy_ind);
			
			criticalrange1 = rs.getString("CRITICAL_LOW");
			criticalrange1 = CommonBean.checkForNull(criticalrange1);
			
			criticalrange2 = rs.getString("CRITICAL_HIGH");
			criticalrange2 = CommonBean.checkForNull(criticalrange2);
			
			strStatus = rs.getString("STATUS");
			strStatus = CommonBean.checkForNull(strStatus);
			
			delta_fail_id_ind = rs.getString("DELTA_FAIL_IND");
			delta_fail_id_ind = CommonBean.checkForNull(delta_fail_id_ind);
			
			resultNum = rs.getString("RESULT_NUM");
			resultNum = CommonBean.checkForNull(resultNum,"0");
			
			resultNumPrefix = rs.getString("RESULT_NUM_PREFIX");
			resultNumPrefix = CommonBean.checkForNull(resultNumPrefix);
			
			result_uom = rs.getString("RESULT_NUM_UOM");
			result_uom = CommonBean.checkForNull(result_uom);
			
			EventHistoryRecord eventHistoryRecord = new EventHistoryRecord();
			eventHistoryRecord.setAccessionnum(accessionnum);
			eventHistoryRecord.setColor_cell_indicator(color_cell_indicator);
			eventHistoryRecord.setContr_sys_event_code(contr_sys_event_code);
			eventHistoryRecord.setContr_sys_id(contr_sys_id);
			eventHistoryRecord.setCriticalrangeHigh(criticalrange2);
			eventHistoryRecord.setCriticalrangeLow(criticalrange1);
			eventHistoryRecord.setDelta_fail_id_ind(delta_fail_id_ind);
			eventHistoryRecord.setDescCellInd(descCellInd);
			eventHistoryRecord.setEncline(encline);
			eventHistoryRecord.setEnctr_id(enctr_id);
			eventHistoryRecord.setEventclassdesc(eventclassdesc);
			eventHistoryRecord.setEventdatetime(eventdatetime);
			eventHistoryRecord.setEventdesc(eventdesc);
			eventHistoryRecord.setEventgroupdesc(eventgroupdesc);
			eventHistoryRecord.setExtimageapplid(extimageapplid);
			eventHistoryRecord.setHistdatatype(histdatatype);
			eventHistoryRecord.setHistrectype(histrectype);
			eventHistoryRecord.setHisttypedesc(histtypedesc);
			eventHistoryRecord.setNormalcy_ind(normalcy_ind);
			eventHistoryRecord.setNormalcy_str(normalcy_str);
			eventHistoryRecord.setNormalrangeHigh(normalrange2);
			eventHistoryRecord.setNormalrangeLow(normalrange1);
			eventHistoryRecord.setPerformed_by(performed_by);
			eventHistoryRecord.setQuick_text_count(quick_text_count);
			eventHistoryRecord.setResult_uom(result_uom);
			eventHistoryRecord.setResultNum(resultNum);
			eventHistoryRecord.setResultNumPrefix(resultNumPrefix);
			eventHistoryRecord.setResultstr(resultstr);
			eventHistoryRecord.setSortEventDateTime(sortEventDateTime);
			eventHistoryRecord.setStrStatus(strStatus);
			eventHistoryRecord.setSymbol_legend_ind(symbol_legend_ind);
			
			historyRecordCount = getHistoryDataCountForEvent(histrectype,
					contr_sys_id, accessionnum, contr_sys_event_code);
			eventHistoryRecord.setHistoryRecordCount(historyRecordCount);
			
			eventHistoryRecordList.add(eventHistoryRecord);
		}
		
		response.setHistoryRecordList(eventHistoryRecordList);
		
		
		/*Map<EventHistoryType, List<EventHistoryRecord>> eventHistoryMap = response
				.getHistoryRecordMap();
		List<EventHistoryRecord> eventHistoryRecordList = null;
		
		String historyType = null;
		EventHistoryType eventHistoryType = null;
		EventHistoryRecord eventHistoryRecord = null;
		
		String eventClassDesc = null;
		String eventGroupDesc = null;
		String eventCodeDesc = null;
		try {
			while(rs.next()){
				historyType = rs.getString("HIST_REC_TYPE_DESC");
				eventHistoryType = new EventHistoryType();
				eventHistoryType.setHistoryType(historyType);
				
				// check if the event history map already contains
				// the event history - if so, we need to update
				// the list of the event history records already
				// present for the event history 
				// if not, then we need to create a new list
				// and save it to the map
				if(eventHistoryMap.containsKey(eventHistoryType)){
					eventHistoryRecordList = eventHistoryMap.get(eventHistoryType);
				}else{
					eventHistoryRecordList = new ArrayList<EventHistoryRecord>();
					eventHistoryMap.put(eventHistoryType, eventHistoryRecordList);
				}
				// get the fields required for the event history record
				eventClassDesc = rs.getString("EVENT_CLASS_DESC");
				eventGroupDesc = rs.getString("EVENT_GROUP_DESC");
				eventCodeDesc = rs.getString("EVENT_CODE_DESC");
				// create the event history record now
				eventHistoryRecord = new EventHistoryRecord();
				eventHistoryRecord.setEventClassDesc(eventClassDesc);
				eventHistoryRecord.setEventGroupDesc(eventGroupDesc);
				eventHistoryRecord.setEventCodeDesc(eventCodeDesc);
				// finally add the event history record to the list
				eventHistoryRecordList.add(eventHistoryRecord);
			}
		} catch (SQLException e) {
			*//**
			 * TODO
			 * need to handle this properly
			 *//*
		}finally{
			*//**
			 * TODO
			 * for any processing
			 *//*
		}*/
		
	}

	/**
	 * 
	 * @param prepStmt
	 * @param recordRequest
	 */
	private void setDataInPrepStmtForRowIds(PreparedStatement pstmtDt,
			EventHistoryRecordRequest recordRequest) throws SQLException{
		String locale = recordRequest.getLocale();
		String strPatientId = recordRequest.getParameter("patientid");
		String strHistRecType = recordRequest.getParameter("hist_type");
		String strEventClass = recordRequest.getParameter("event_class");
		String strEventGroup = recordRequest.getParameter("event_group");
		String strEventCode = recordRequest.getParameter("event_item");
		
		String selectedTimePeriod = recordRequest.getParameter("selectedperiod");
		List<String> selectedTimePeriodList = getSelectedTimePeriod(
				selectedTimePeriod, "");
		String fromPeriod = "";
		String toPeriod = "";
		if(selectedTimePeriodList != null && selectedTimePeriodList.size() == 2){
			fromPeriod = selectedTimePeriodList.get(0);
			toPeriod = selectedTimePeriodList.get(1);
			fromPeriod = DateUtils.convertDate(fromPeriod,"DMYHM",locale,locale);
			toPeriod = DateUtils.convertDate(toPeriod,"DMYHM",locale,locale);
		}
		
		String eventdate = recordRequest.getParameter("event_date");
		String strViewConfRes = recordRequest.getParameter("view_by");
		String strFacilityId = recordRequest.getParameter("facility_id");
		String strEncounterId = recordRequest.getParameter("encounter_id");
		String strEpisodeType = recordRequest.getParameter("episode_type");
		String strAbnormal = recordRequest.getParameter("abnormal");
		strAbnormal = CommonBean.checkForNull(strAbnormal, "N");
		
		int nIndex =1;
		pstmtDt.setString(nIndex++,strPatientId);

		if(!strHistRecType.equals(""))
			pstmtDt.setString(nIndex++,strHistRecType);

		if(!strEventClass.equals(""))
			pstmtDt.setString(nIndex++,strEventClass);

		if(!strEventGroup.equals(""))
			pstmtDt.setString(nIndex++,strEventGroup);

		if(!strEventCode.equals(""))
			pstmtDt.setString(nIndex++,strEventCode);
		
		if(!fromPeriod.equals(""))
			pstmtDt.setString(nIndex++,fromPeriod);

		if(!toPeriod.equals(""))
			pstmtDt.setString(nIndex++,toPeriod);
		
		if(!eventdate.equals("") && strViewConfRes.equals("D"))
			pstmtDt.setString(nIndex++,eventdate);

		if(!strFacilityId.equals(""))
			pstmtDt.setString(nIndex++,strFacilityId);

		if(!strEncounterId.equals(""))
			pstmtDt.setString(nIndex++,strEncounterId);
		
		if(!strEpisodeType.equals("B") )
		{
			if(strEpisodeType.equals("I") || strEpisodeType.equals("IP"))
				pstmtDt.setString(nIndex++,"IP");
			else if(strEpisodeType.equals("O") || strEpisodeType.equals("OP"))
				pstmtDt.setString(nIndex++,"OP");
			else if(strEpisodeType.equals("D") || strEpisodeType.equals("DC"))
				pstmtDt.setString(nIndex++,"DC");
			else if(strEpisodeType.equals("E") || strEpisodeType.equals("EM"))
				pstmtDt.setString(nIndex++,"EM");
			else if(strEpisodeType.equals("X") || strEpisodeType.equals("XT"))
				pstmtDt.setString(nIndex++,"XT");
		}
	}
	
	
}
