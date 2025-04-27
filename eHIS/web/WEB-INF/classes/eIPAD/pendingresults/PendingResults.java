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
package eIPAD.pendingresults;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eIPAD.IPADConstants;
import eIPAD.clinicaleventhistory.ClinicalEventHistory;
import eIPAD.common.CommonUtil;
import eIPAD.common.IndicatorDetailRequest;
import eIPAD.common.IndicatorDetailResponse;
import eIPAD.common.IndicatorDetails;
import eIPAD.common.NotesRequest;
import eIPAD.common.NotesResponse;
import eIPAD.common.PractitionerDetailResponse;
import eIPAD.common.PractitionerDetails;

/**
 * This is a controller class for the pending results functionality
 * This class will contain different methods to get
 * data for pending results functionality 
 * @author GRamamoorthy
 *
 */
public class PendingResults implements Serializable {

	/**
	 * Constant to denote the review by key used in notes processing
	 */
	public static final String REVIEW_BY_KEY = "Reviewed by";
	
	/**
	 * Constant to denote the on key used in notes processing
	 */
	public static final String ON_KEY = "On";
	
	/**
	 * Constant to denote the date format used in notes processing
	 */
	public static final String NOTES_DATE_FORMAT = "DMYHM";
	
	/**
	 * Constant to denote the delimiter used in notes processing
	 */
	public static final String NOTES_DELIMITER = "\n";
	
	
	/**
	 * Default constructor of the class
	 */
	public PendingResults() {
	}
	
	/**
	 * This method returns the number of pending results
	 * for each of the pending results category
	 * @param countRequest
	 * @return
	 */
	public PendingResultsCountResponse getPendingResultsCount(PendingResultsCountRequest countRequest){
		PendingResultsCountResponse countResponse = new PendingResultsCountResponse();
		// safe check
		if(countRequest == null){
			return countResponse;
		}
		
		// validate and return response
		if(!validatePendingResultsCountRequest(countRequest)){
			return countResponse;
		}
		
		// initialize the connection
		HttpServletRequest servletRequest = countRequest.getRequest();
		Connection conn = null;
		conn = ConnectionManager.getConnection(servletRequest);
		// safe check
		if(conn == null){
			return countResponse;
		}
		// holds the SQL query
		String query = null;
		PendingResultCategory pendingResultCategory = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			// get the query for finding total number of pending results
			query = getTotalPendingResultCount(countRequest);
			rs = stmt.executeQuery(query);
			pendingResultCategory = new PendingResultCategory(
					PendingResultCategory.TOTAL_CATEGORY);
			processPendingResultCount(countResponse, rs, pendingResultCategory);
			// close the result set before querying next time
			rs.close();
			
			// get the query for finding number of abnormal results
			query = getAbnormalPendingResultCountQuery(countRequest);
			rs = stmt.executeQuery(query);
			pendingResultCategory = new PendingResultCategory(
					PendingResultCategory.ABNORMAL_CATEGORY);
			processPendingResultCount(countResponse, rs, pendingResultCategory);
			// close the result set before querying next time
			rs.close();
			
			// get the query for finding number of critical results
			query = getCriticalPendingResultCountQuery(countRequest);
			rs = stmt.executeQuery(query);
			pendingResultCategory = new PendingResultCategory(
					PendingResultCategory.CRITICAL_CATEOGORY);
			processPendingResultCount(countResponse, rs, pendingResultCategory);
			// close the result set before querying next time
			rs.close();
			
			// get the query for finding number of normal results
			query = getNormalPendingResultCountQuery(countRequest);
			rs = stmt.executeQuery(query);
			pendingResultCategory = new PendingResultCategory(
					PendingResultCategory.NORMAL_CATEGORY);
			processPendingResultCount(countResponse, rs, pendingResultCategory);
			
		} catch (SQLException e) {
			/**
			 * TODO need to properly handle this
			 */
			return countResponse;
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			
			ConnectionManager.returnConnection(conn, servletRequest);
		}
		
		
		return countResponse;
	}
	
	
	/**
	 * This method gets the notes text for a pending result
	 * @param notesRequest
	 * @return
	 */
	public NotesResponse getNotes(NotesRequest notesRequest){
		NotesResponse notesResponse = new NotesResponse();
		// safe check
		if(notesRequest == null){
			return notesResponse;
		}
		// again a safe check
		String accessionNumber = notesRequest.getAccessionNumber();
		if(accessionNumber == null){
			return notesResponse;
		}
		
		// now call the method which will get the notes text alone
		notesResponse = getNotesText(notesRequest);
		// safe check
		if(notesResponse == null || notesResponse.getNotesText() == null){
			return notesResponse;
		}
		
		// this var contains the notes text
		String notesText = notesResponse.getNotesText();
		
		// now get the practitioner details (practitioner name)
		// with the notes request
		PractitionerDetails practitionerDetails = new PractitionerDetails();
		PractitionerDetailResponse practitionerResponse = practitionerDetails
				.getPractitionerForAccessionNumber(notesRequest);
		// just safe checking the practitioner response
		// if practitioner details is null then return notes response as is
		if(practitionerResponse == null || practitionerResponse.getPractitionerName() == null){
			return notesResponse;
		}
		
		// now comes the logic wherein the notes text is broken
		// into individual strings based on delimiter "\n"
		// then the individual strings are updated with 
		// practitioner details and a final notes text is arrived at
		StringTokenizer tokens = new StringTokenizer(notesText,NOTES_DELIMITER);
		StringBuffer reformedNotes = new StringBuffer();
		String practitionerName = practitionerResponse.getPractitionerName();
		String value = null;
		String strToken = null;
		String temp = null;
		String locale = notesRequest.getLocale();
		// logic to process the tokens is present here
		while (tokens.hasMoreTokens()) {
			strToken = tokens.nextToken();
			if (strToken.indexOf(REVIEW_BY_KEY) != -1) {
				temp = strToken.substring(14, 27);
				temp = practitionerName;
				reformedNotes.append(strToken.substring(0, 14));
				reformedNotes.append(temp);
				if (strToken.indexOf(ON_KEY) != -1) {
					value = strToken.substring(31, strToken.length());
					value = com.ehis.util.DateUtils.convertDate(value, NOTES_DATE_FORMAT,
							locale, locale);
					reformedNotes.append(strToken.substring(27, 31));
					reformedNotes.append(value);
					reformedNotes.append(NOTES_DELIMITER);
				}
			} else {
				reformedNotes.append(strToken);
				reformedNotes.append(NOTES_DELIMITER);
			}
		}
		
		// finally set the reformed notes value to the response
		notesResponse.setNotesText(reformedNotes.toString());
		
		return notesResponse;
	}
	
	/**
	 * This method returns a set of previous results
	 * for a particular pending result
	 * @param previousResultsRequest
	 * @param prevResultCountResponse TODO
	 * @return
	 */
	public PreviousResultsResponse getPreviousResults(
			PreviousResultsRequest previousResultsRequest,
			PrevResultCountResponse prevResultCountResponse) {
		PreviousResultsResponse previousResultsResponse = new PreviousResultsResponse();
		// safe check
		if(previousResultsRequest == null){
			return previousResultsResponse;
		}
		
		// initialize the connection 
		HttpServletRequest servletRequest = previousResultsRequest.getRequest();
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return previousResultsResponse;
		}
		
		String query = getPreviousResultsQuery(previousResultsRequest);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try {
			prepStmt = conn.prepareStatement(query);
			// now need to set the data in the prepared statement
			setDataInPrepStmtForPrevResults(prepStmt,previousResultsRequest);
			rs = prepStmt.executeQuery();
			processPreviousResults(rs,previousResultsResponse);
			
			processDateListDataInPrevResults(prevResultCountResponse,
					previousResultsResponse);
			/*query = getDateListQueryForPrevResults(previousResultsRequest);
			prepStmtForDate = conn.prepareStatement(query);
			// now need to set the data in the prepared statement
			setDataInPrepStmtForDateList(prepStmtForDate,previousResultsRequest);
			rsForDate = prepStmtForDate.executeQuery();*/
			//processDateListDataInPrevResults(rsForDate,previousResultsResponse);
			
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
		
		return previousResultsResponse;
	}
	
	/**
	 * This method is used to get the count of previous results
	 * @param previousResultsRequest
	 * @return
	 */
	public PrevResultCountResponse getPreviousResultsCount(
			PreviousResultsRequest previousResultsRequest) {
		PrevResultCountResponse countResponse = new PrevResultCountResponse();
		if(previousResultsRequest == null){
			return countResponse;
		}
		
		HttpServletRequest servletRequest = previousResultsRequest.getRequest();
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return countResponse;
		}
		
		String query = getDateListQueryForPrevResults(previousResultsRequest);
		PreparedStatement prepStmtForDate = null;
		ResultSet rsForDate = null;
		try {
			//query = getDateListQueryForPrevResults(previousResultsRequest);
			prepStmtForDate = conn.prepareStatement(query);
			// now need to set the data in the prepared statement
			setDataInPrepStmtForDateList(prepStmtForDate,previousResultsRequest);
			rsForDate = prepStmtForDate.executeQuery();
			processDateListDataInPrevResults(rsForDate,countResponse);
		} catch (SQLException e) {
			e.printStackTrace();
			/**
			 * TODO
			 * need to handle this properly
			 */
		}finally{
			if(rsForDate != null){
				try {
					rsForDate.close();
				} catch (SQLException e) {
				}
			}
			
			if(prepStmtForDate != null){
				try {
					prepStmtForDate.close();
				} catch (SQLException e) {
				}
			}
			
			ConnectionManager.returnConnection(conn, servletRequest);
		}
		
		
		return countResponse;
	}
	
	
	/**
	 * This method gets the complete pending results 
	 * @param pendingResultsRequest
	 * @return
	 */
	public PendingResultsResponse getPendingResults(PendingResultsRequest pendingResultsRequest){
		PendingResultsResponse pendingResultsResponse = new PendingResultsResponse();
		// safe check
		if(pendingResultsRequest == null){
			return pendingResultsResponse;
		}
		
		HttpServletRequest servletRequest = pendingResultsRequest.getRequest();
		// initialize the connection
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return pendingResultsResponse;
		}
		
		// code to be added for getting the normalcy indicator
		// this is following the desktop application flow
		// the normalcy indicator is then set back to the request object
		// code modified to first get the normalcy indicator from request object
		// if it is not specified in the request then, get it from servletrequest object
		String normalcyIndicatorParam=pendingResultsRequest.getNormalcyIndicator();// servletRequest.getParameter("normalcy_ind");
		if(normalcyIndicatorParam == null || normalcyIndicatorParam.trim().equals("")){
			normalcyIndicatorParam = servletRequest.getParameter("normalcy_ind");
		}
		/*if("".equals(normalcyIndicatorParam)){
			normalcyIndicatorParam = null;
		}*/
		String normalcyIndicator = "";
		if (normalcyIndicatorParam == null || normalcyIndicatorParam.trim().equals("")
				|| "S".equalsIgnoreCase(normalcyIndicatorParam)
				|| "Z".equalsIgnoreCase(normalcyIndicatorParam)) {
			normalcyIndicator = "nvl(a.NORMALCY_IND,'.')";
		}else if("N".equals(normalcyIndicatorParam.trim())){
			normalcyIndicator = "'.'";
		}
		else{
			IndicatorDetails indicatorDetails = new IndicatorDetails();
			IndicatorDetailRequest indicatorRequest = new IndicatorDetailRequest();
			indicatorRequest.setRequest(servletRequest);
			indicatorRequest.setSession(pendingResultsRequest.getSession());
			IndicatorDetailResponse indicatorResponse = null;
			if ("A".equals(normalcyIndicatorParam.trim())) {
				indicatorResponse = indicatorDetails
						.getAbnormalIndicators(indicatorRequest);
			} else if ("C".equals(normalcyIndicatorParam.trim())) {
				indicatorResponse = indicatorDetails
						.getCriticalIndicators(indicatorRequest);
			}
			normalcyIndicator = indicatorResponse.getIndicatorValue();
		}
		
		pendingResultsRequest.setNormalcyIndicator(normalcyIndicator);
		
		
		// get the SQL query, create preparedStatement
		// execute the preparedstatement and process the results
		String query = getSQLQueryForPendingResults(pendingResultsRequest);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(query);
			setDataInPrepStmtForPendingResults(prepStmt, pendingResultsRequest);
			rs = prepStmt.executeQuery();
			if(rs != null){
				processPendingResults(rs, pendingResultsResponse);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			/**
			 * TODO
			 * need to properly handle this
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
		
		return pendingResultsResponse;
	}
	
	
	/**
	 * 
	 * @param taskRequest
	 * @return
	 */
	public TaskApplicabilityResponse getTaskApplicability(TaskApplicablityRequest taskRequest){
		TaskApplicabilityResponse taskResponse = new TaskApplicabilityResponse();
		// safe check
		if(taskRequest == null){
			return taskResponse;
		}
		
		// initialize the connection
		HttpServletRequest servletRequest = taskRequest.getRequest();
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return taskResponse;
		}
		
		String menu = taskRequest.getMenu();
		String practRelId = taskRequest.getPract_relationId();
		String responsibilityId = taskRequest.getResponsibilityId();
		
		String query = "select  GET_TASK_APPLICABILITY(? , '' , ? ,? ) Menu FROM DUAL";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		String menuValue = null;
		try {
			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, menu);
			prepStmt.setString(2,responsibilityId);
			prepStmt.setString(3, practRelId);
			rs = prepStmt.executeQuery();
			
			if(rs != null){
				while(rs.next()){
					menuValue = rs.getString("Menu");
				}
				
				menuValue = CommonBean.checkForNull(menuValue, "X");
				taskResponse.setMenuValue(menuValue);
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
			ConnectionManager.returnConnection(conn);
		}
		
		return taskResponse;
	}
	
	
	/**
	 * 
	 * @param prepStmt
	 * @param pendingResultsRequest
	 */
	private void setDataInPrepStmtForPendingResults(PreparedStatement prepStmt,
			PendingResultsRequest pendingResultsRequest) throws SQLException{
		int index = 0;
		HttpServletRequest servletRequest = pendingResultsRequest.getRequest();
		// set result type as the first parameter in the prepared statement		
		String resultType = servletRequest.getParameter("result_type");
		resultType = CommonBean.checkForNull(resultType);
		prepStmt.setString(++index, resultType);
		// next set the patient id
		String patientId = servletRequest
     			.getParameter("hdnPatientId");
		patientId = CommonBean.checkForNull(patientId);
		prepStmt.setString(++index,patientId);
		
		// next comes event class
		String eventClass = servletRequest.getParameter("event_class");
		eventClass = CommonBean.checkForNull(eventClass);
		prepStmt.setString(++index,eventClass);
		
		String dateFrom = "";
		String toDate = "";
		// code modified to get the selected period from parameter "hdnFromPeriod"
		// this parameter will have the selected period when search button is clicked
		// if the value is not there, it implies the page is getting loaded
		// hence, get it from parameter "hdnSelectedPeriod"
		String selectedPeriod = servletRequest.getParameter("hdnFromPeriod");
		if(selectedPeriod == null || selectedPeriod.trim().equals("")){
			selectedPeriod = servletRequest.getParameter("hdnSelectedPeriod");
		}
		selectedPeriod = CommonBean.checkForNull(selectedPeriod, IPADConstants.LAST_ONE_WEEK);
		
		String formatterString = "dd/MM/yyyy";
		List<String> selectedTimePeriodList = ClinicalEventHistory
				.getSelectedTimePeriod(selectedPeriod, patientId, formatterString);
		if(selectedTimePeriodList != null && selectedTimePeriodList.size() == 2){
			dateFrom = selectedTimePeriodList.get(0);
			toDate = selectedTimePeriodList.get(1);
		}
		
		prepStmt.setString(++index,dateFrom);
		prepStmt.setString(++index,toDate);
		
		// next comes patient class
		String patientClass = servletRequest.getParameter("patient_class");
		patientClass = CommonBean.checkForNull(patientClass);
		if (!patientClass.equals("")) {
			prepStmt.setString(++index,patientClass);
		}
	}
	
	/**
	 * This method returns the SQL query that will be used for getting
	 * the pending results
	 * @param pendingResultsRequest
	 * @return
	 */
	private String getSQLQueryForPendingResults(PendingResultsRequest pendingResultsRequest){
		// initialize the string buffer which will hold the sql query
		StringBuffer queryBuff = new StringBuffer();
		// get the servlet request and session objects from request
		HttpServletRequest servletRequest = pendingResultsRequest.getRequest();
		HttpSession session = pendingResultsRequest.getSession();
		// get the patient class
		String patientClass = servletRequest.getParameter("patient_class");
		patientClass = CommonBean.checkForNull(patientClass);
		// get the group by
		String groupBy = servletRequest.getParameter("groupby");
		groupBy = CommonBean.checkForNull(groupBy);
		
		// the logic in desktop application is to start with
		// checking the patient class
		// if the patient class is empty then group by is checked
		// and SQL query is formed
		if ("".equals(patientClass)) {
			if ("E".equals(groupBy)) {
				queryBuff
						.append("SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id ,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1') event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,g.patient_name,g.sex FROM ca_result_review_pend_log a,cr_encounter_detail f,mp_patient g, PR_ENCOUNTER h,or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and h.FACILITY_ID=f.FACILITY_ID and h.encounter_id=f.encounter_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type)  &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  AND NVL (f.status, '#') not in ( 'S','E') order by event,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code desc");
			} else {
				queryBuff
						.append("SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  ,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status/*, ordering_practitioner*/,CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,g.patient_name,g.sex FROM ca_result_review_pend_log a,cr_encounter_detail f,mp_patient g, PR_ENCOUNTER h,or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and h.FACILITY_ID=f.FACILITY_ID and h.encounter_id=f.encounter_id and nvl(i.priority,'X') = nvl((?),nvl(i.priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY## and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 AND NVL (f.status, '#') not in ( 'S','E') order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code desc");
			}
		} else if (!("".equals(patientClass))) {
			if ("E".equals(groupBy)) {
				queryBuff
						.append("SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,DECODE(review_type,'O','Ordering Practitioner','A','Attending Practitioner') review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,a.patient_id patient_id,a.event_class event_class,a.event_code event_code,a.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,g.patient_name,g.sex FROM ca_result_review_pend_log a,cr_encounter_detail f,mp_patient g, PR_ENCOUNTER h,or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and h.FACILITY_ID=f.FACILITY_ID and h.encounter_id=f.encounter_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(A.NORMALCY_IND,'.') in nvl((?),nvl(A.NORMALCY_IND,'*')) AND a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and patient_class = ? AND NVL (f.status, '#') not in ( 'S','E') order by event_short_desc,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code desc");
			} else {
				queryBuff
						.append("SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,g.patient_name,g.sex FROM ca_result_review_pend_log a,cr_encounter_detail f,mp_patient g, PR_ENCOUNTER h,or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and h.FACILITY_ID=f.FACILITY_ID and h.encounter_id=f.encounter_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in nvl((?),nvl(a.NORMALCY_IND,'*')) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 and patient_class = ?      AND NVL (f.status, '#') not in ( 'S','E') order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code desc");
			}
		}
		
		// code to replace the occurrence of task applicability with suitable
		// string in the sql query
		String taskApplicability = servletRequest.getParameter("hdnGetTaskApplicability");
		taskApplicability = CommonBean.checkForNull(taskApplicability);
		String replaceString = " ";
		if("X".equals(taskApplicability)){
			replaceString = " and (nvl(f.PROTECTION_IND,'N')!='Z' )  ";
		}
		
		// the below logic mainly concentrates on replacing all the "?"
		// place holders in the sql query string - all such occurrences
		// of "?" are replaced with actual values
		String sqlQuery = queryBuff.toString();
		sqlQuery = sqlQuery.replace("&&GETTASKAPPLICABILITY##",replaceString);
		String locale = pendingResultsRequest.getLocale();
		for(int x=0;x<10;x++){
			sqlQuery = CommonUtil.replace(sqlQuery, "?", locale, "Y");
		}
		// replace the practitioner id and the priority
		String practitionerId = (String) session
     			.getValue("ca_practitioner_id");
		if(practitionerId == null){
			practitionerId = "";
		}
		String priority = servletRequest.getParameter("priority");
		if(priority == null){
			priority = "";
		}
		// get the normalcy indicator this value would have already been set
		String normalcyIndicator = pendingResultsRequest.getNormalcyIndicator();
		
		// replace the place holders with actual value
		sqlQuery = CommonUtil.replace(sqlQuery,"?",practitionerId,"Y");
		sqlQuery = CommonUtil.replace(sqlQuery,"?",priority,"Y");
		sqlQuery = CommonUtil.replace(sqlQuery,"?",normalcyIndicator,"N");

		
		return sqlQuery;
	}
	
	
	/**
	 * This method processes the resultset obtained and sets the data
	 * in the response object
	 * @param rs
	 * @param pendingResultsResponse
	 */
	private void processPendingResults(ResultSet rs,
			PendingResultsResponse pendingResultsResponse) throws SQLException{
		// local vars to be used in the method
		String patientId = null;
		String patientName = null;
		String sex = null;
		int age = 0;
		
		String episodeDetails = null;
		PatientDetail patientDetail = null;
		PendingResultForPatient pendingResult = null;
		String resultCategory = null;
		Map<PatientDetail, PendingResultForPatient> pendingResultsMap = new HashMap<PatientDetail, PendingResultForPatient>();
		Map<ResultCategory, List<ResultDetail>> resultDetailMap = new HashMap<ResultCategory, List<ResultDetail>>();
		ResultCategory resultCategoryObj = null;
		String historyRecordTypeDesc = null;
		String eventClassDesc = null;
		List<ResultDetail> resultDetailList = null;
		ResultDetail resultDetail = null;
		
		String eventName = null;
		String reportedBy = null;
		String reportedAt = null;
		String resultNum = null;
		String resultNumUom = null;
		String result = null;
		String notesType = null;
		String resultStr = null;
		String accessionNum = null;
		String contrSysEventCode = null;
		String orderId = null;
		String sysId = null;
		String normalLow = null;
		String normalHigh = null;
		String historyRecType = null;
		String eventGroup = null;
		String practitionerId = null;
		String orderingPractitioner = null;
		String eventClass = null;
		String eventCode = null;
		String histDataType = null;
		String normalcyInd = null;
		
		String reviewType = null;
		String createDateTime = null;
		String encounterId = null;
		
		int totalRecords = 0;
		// iterate through the result set and get the different records
		while(rs.next()){
			patientId = rs.getString("PATIENT_ID");
			patientName = rs.getString("PATIENT_NAME");
			sex = rs.getString("SEX");
			
			episodeDetails = rs.getString("EPISODE_DETAILS");
			age = getAgeFromEpisodeDetails(episodeDetails);
			// code to get encounter id as well
			encounterId = getEncounterIdFromEpisodeDetails(episodeDetails);
			// initialize a new patientDetail object
			patientDetail = new PatientDetail();
			patientDetail.setAge(age);
			patientDetail.setPatientName(patientName);
			patientDetail.setPatientId(patientId);
			patientDetail.setSex(sex);
			
			// check if pendingresultsmap already contains the patient detail
			// if so, then get the pending result from the map
			// if not, then initialize the pending result and add it to map
			if(pendingResultsMap.containsKey(patientDetail)){
				pendingResult = pendingResultsMap.get(patientDetail);
			}else{
				pendingResult = new PendingResultForPatient();
				pendingResult.setPatientDetail(patientDetail);
				pendingResultsMap.put(patientDetail, pendingResult);
			}
			
			resultDetailMap = pendingResult.getPendingResultMapForPatient();
			
			// now form the result category object
			// result category is concatenation of 2 fields from db
			historyRecordTypeDesc = rs.getString("HIST_REC_TYPE_DESC");
			eventClassDesc = rs.getString("EVENT_CLASS_DESC");
			resultCategory = historyRecordTypeDesc + IPADConstants.SLASH_IDENTIFIER + eventClassDesc;
			resultCategoryObj = new ResultCategory();
			resultCategoryObj.setCategory(resultCategory);
			
			// check if the resultdetailmap already contains result category
			// if so, obtain the result detail list
			// this is the list which will contain the results
			// if not, then initialize the result detail list
			// and add the result category and the result detail list to map
			if(resultDetailMap.containsKey(resultCategoryObj)){
				resultDetailList = resultDetailMap.get(resultCategoryObj);
			}else{
				resultDetailList = new ArrayList<ResultDetail>();
				resultDetailMap.put(resultCategoryObj, resultDetailList);
			}
			// initialize the result detail object
			// and set it with data obtained from db
			resultDetail = new ResultDetail();
			
			eventName = rs.getString("EVENT");
			reportedBy = rs.getString("PRACTITIONER_NAME");
			reportedAt = rs.getString("REPORTED_AT");
			resultNum = rs.getString("RESULT_NUM");
			resultNumUom = rs.getString("RESULT_NUM_UOM");
			result = resultNum + resultNumUom;
			notesType = rs.getString("HIST_DATA");
			resultStr = rs.getString("RESULT_STR");
			accessionNum = rs.getString("ACCESSION_NUM");
			contrSysEventCode = rs.getString("CONTR_SYS_EVENT_CODE");
			orderId = rs.getString("ORDER_ID");
			sysId = rs.getString("CONTR_SYS_ID");
			normalLow = rs.getString("NORMAL_LOW");
			normalHigh = rs.getString("NORMAL_HIGH");
			historyRecType = rs.getString("hist_rec_type");
			eventGroup = rs.getString("EVENT_GROUP");
			practitionerId = rs.getString("PRACT_ID");
			orderingPractitioner = rs.getString("ORDERING_PRACTITIONER");
			
			// event class, event code, hist_data_type
			eventCode = rs.getString("event_code");
			eventClass = rs.getString("event_class");
			histDataType = rs.getString("hist_data_type");
			
			// normalcy indicator
			normalcyInd = rs.getString("normalcy_ind");
			
			reviewType = rs.getString("review_type");
			createDateTime = rs.getString("create_date_time");
			
			
			// set the data to the result detail object
			resultDetail.setEventName(eventName);
			resultDetail.setNotesType(notesType);
			resultDetail.setReportedAt(reportedAt);
			resultDetail.setReportedBy(reportedBy);
			resultDetail.setResult(result);
			resultDetail.setResultNum(resultNum);
			resultDetail.setResultNumUom(resultNumUom);
			resultDetail.setResultStr(resultStr);
			resultDetail.setAccessionNum(accessionNum);
			resultDetail.setContrSysEventCode(contrSysEventCode);
			resultDetail.setEventGroup(eventGroup);
			resultDetail.setHistoryRecTypeDesc(historyRecordTypeDesc);
			resultDetail.setNormalHigh(normalHigh);
			resultDetail.setNormalLow(normalLow);
			resultDetail.setOrderId(orderId);
			resultDetail.setPractitionerId(practitionerId);
			resultDetail.setOrderingPractitioner(orderingPractitioner);
			resultDetail.setSysId(sysId);
			resultDetail.setPatientId(patientId);
			resultDetail.setEventCode(eventCode);
			resultDetail.setEventClass(eventClass);
			resultDetail.setHistDataType(histDataType);
			resultDetail.setHistoryRecType(historyRecType);
			resultDetail.setNormalcyInd(normalcyInd);
			
			resultDetail.setReviewType(reviewType);
			resultDetail.setCreateDateTime(createDateTime);
			
			resultDetail.setEncounterId(encounterId);
			
			// add the result detail to the list
			resultDetailList.add(resultDetail);
			
			// increment the total records
			totalRecords++;
		}
		
		pendingResultsResponse.setPendingResultsMap(pendingResultsMap);
		pendingResultsResponse.setTotalRecords(totalRecords);
		
	}
	
	/**
	 * Simple method to return age which is contained in episode details
	 * 
	 * @param episodeDetails
	 * @return
	 */
	private int getAgeFromEpisodeDetails(String episodeDetails){
		int age = 0;
		if(episodeDetails == null || episodeDetails.trim().equals("")){
			return age;
		}
		
		// episode details contains the patient name followed by
		// single char denoting sex followed by "/", age and "Y"
		// to obtain age alone, substring logic is followed
		int slashIndex = episodeDetails.indexOf(IPADConstants.SLASH_IDENTIFIER);
		// "/" is not found, malformed episode details so return 0 as age
		if(slashIndex == -1){
			return age;
		}
		
		int yearIndex = episodeDetails.indexOf(IPADConstants.YEAR_IDENTIFIER, slashIndex);
		if(yearIndex == -1){
			return age;
		}
		
		String ageStr = episodeDetails.substring(slashIndex+1, yearIndex);
		try {
			age = Integer.parseInt(ageStr);
		} catch (NumberFormatException e) {
			age = 0;
		}
		
		return age;
	}
	
	/**
	 * 
	 * @param episodeDetails
	 * @return
	 */
	private String getEncounterIdFromEpisodeDetails(String episodeDetails){
		String encounterId = "";
		int slashIndex = episodeDetails.indexOf("/");
		int yearIndex = 0;
		if(slashIndex >=0 ){
			yearIndex = episodeDetails.indexOf(",",slashIndex);
		}else{
			return encounterId;
		}
		String tempValue = null;
		if(yearIndex >=0 && yearIndex < episodeDetails.length()){
			tempValue = episodeDetails.substring(yearIndex+1, episodeDetails.length());
			tempValue = tempValue.trim();
			
			int spaceIndex = tempValue.indexOf(" ");
			int dotIndex = tempValue.indexOf("," ,spaceIndex);
			if(dotIndex>spaceIndex){
				tempValue = tempValue.substring(spaceIndex, dotIndex);
				tempValue = tempValue.trim();
			}
			
			encounterId = tempValue;
		}
		
		return encounterId;
	}
	
	/**
	 * 
	 * @param rs
	 * @param prevResultCountResponse
	 */
	private void processDateListDataInPrevResults(ResultSet rs,
			PrevResultCountResponse prevResultCountResponse) throws SQLException{
		if(rs == null){
			return;
		}
		
		String dateValueAsStr = null;
		List<PrevResultDateContainer> dateContainerList = new ArrayList<PrevResultDateContainer>();
		PrevResultDateContainer dateContainer = null;
		while(rs.next()){
			dateValueAsStr = rs.getString(1);
			dateContainer = new PrevResultDateContainer();
			dateContainer.setDateString(dateValueAsStr);
			/**
			 * TODO
			 * need to cross verify the behavior in desktop application
			 * once more and then have code accordingly
			 */
			dateContainerList.add(dateContainer);
		}
		
		prevResultCountResponse.setPrevResultDateContainerList(dateContainerList);
	}
	
	/**
	 * 
	 * @param prevResultCountResponse
	 * @param previousResultsResponse
	 */
	private void processDateListDataInPrevResults(
			PrevResultCountResponse prevResultCountResponse,
			PreviousResultsResponse previousResultsResponse) {
		previousResultsResponse
				.setPrevResultDateContainerList(prevResultCountResponse
						.getPrevResultDateContainerList());
	}
	
	
	/**
	 * 
	 * @param pstmtDate
	 */
	private void setDataInPrepStmtForDateList(PreparedStatement pstmtDate,
			PreviousResultsRequest previousResultsRequest) throws SQLException {
		int nIndex = 1;

		String flowSheetId = previousResultsRequest.getFlowSheetId();
		String histRecType = previousResultsRequest.getHistoryRecordType();
		String eventClass = previousResultsRequest.getEventClass();
		String eventGroup = previousResultsRequest.getEventGroup();
		String eventCode = previousResultsRequest.getEventCode();
		String fromDate = previousResultsRequest.getFromDate();
		String toDate = previousResultsRequest.getToDate();
		String facilityId = previousResultsRequest.getFacilityId();
		String encounterId = previousResultsRequest.getEncounterId();
		String episodeType = previousResultsRequest.getEpisodeType();
		String patientId = previousResultsRequest.getPatientId();
		
		pstmtDate.setString(nIndex++,patientId);

		if(!histRecType.equals("")){
			pstmtDate.setString(nIndex++,histRecType);
		}

		if(!eventClass.equals("")){
			pstmtDate.setString(nIndex++,eventClass);
		}
			
		if(!eventGroup.equals("")){
			pstmtDate.setString(nIndex++,eventGroup);
		}

		if (!eventCode.equals("")){
			pstmtDate.setString(nIndex++, eventCode);
		}

		if (!fromDate.equals("")){
			pstmtDate.setString(nIndex++, fromDate);
		}

		if (!toDate.equals("")){
			pstmtDate.setString(nIndex++, toDate);
		}

		if (!facilityId.equals("")){
			pstmtDate.setString(nIndex++, facilityId);
		}
			
		if (!encounterId.equals("")){
			pstmtDate.setString(nIndex++, encounterId);
		}
	
		if (!episodeType.equals("")) {
			String encounterType = previousResultsRequest.getEncounterType();
			pstmtDate.setString(nIndex++, encounterType);
		}
		
		if(!flowSheetId.equals("")){
			pstmtDate.setString(nIndex++,flowSheetId);	
		}
	}
	
	/**
	 * 
	 * @param previousResultsRequest
	 * @return
	 */
	private String getDateListQueryForPrevResults(PreviousResultsRequest previousResultsRequest){
		StringBuffer queryBuff = new StringBuffer();
		queryBuff.append("Select to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date 	From 	cr_encounter_detail a ");
		queryBuff.append("where  ");
		// get extra conditions which will be set in the where clause
		// of the SQL query
		String queryCriteria = getQueryCriteriaForPrevResultCount(previousResultsRequest);
		queryBuff.append(queryCriteria);
		
		queryBuff.append("  Order by to_date(event_date,'dd/mm/yyyy hh24:mi')");
		
		return queryBuff.toString();
	}
	
	
	/**
	 * 
	 * @param rs
	 * @param previousResultsResponse
	 */
	private void processPreviousResults(ResultSet rs,
			PreviousResultsResponse previousResultsResponse)
			throws SQLException {
		List<PreviousResults> previousResultsList = new ArrayList<PreviousResults>();
		if(rs == null){
			return;
		}
		
		int counter = 0;
		while (rs.next()) {
			String eventDummyDate = rs.getString("event_date_time") == null ? ""
					: rs.getString("event_date_time");
			String histRecType = rs.getString("hist_rec_type") == null ? ""
					: rs.getString("hist_rec_type");
			String histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? ""
					: rs.getString("hist_rec_type_desc");
			String eventClass = rs.getString("eve_class") == null ? "" : rs
					.getString("eve_class");
			String eventClassDesc = rs.getString("event_class_desc") == null ? ""
					: rs.getString("event_class_desc");
			String eventGroup = rs.getString("event_group") == null ? ""
					: rs.getString("event_group");
			String eventGroupDesc = rs.getString("event_group_desc") == null ? ""
					: rs.getString("event_group_desc");
			String eventCode = rs.getString("eve_code") == null ? "" : rs
					.getString("eve_code");
			String eventDesc = rs.getString("event_desc") == null ? "" : rs
					.getString("event_desc");
			String resultNumUOM = rs.getString("uom") == null ? "" : rs
					.getString("uom");
			String histDataType = rs.getString("hist_data_type") == null ? ""
					: rs.getString("hist_data_type");
			String resultNum = rs.getString("RESULT_NUM") == null ? "" : rs
					.getString("RESULT_NUM");
			
			String accessionNum = rs.getString("acc_num") == null ? "" : rs.getString("acc_num");
			String sysID = rs.getString("sys_id") == null ? "" : rs.getString("sys_id");
			String sysEventCode = rs.getString("sys_eve_code") == null ? "" : rs.getString("sys_eve_code");
			String resultStr = rs.getString("res_str") == null ? "" : rs.getString("res_str");
			String normIndicator = rs.getString("norm_ind") == null ? "" : rs.getString("norm_ind");
			String normalLow = rs.getString("normal_low") == null ? "" : rs.getString("normal_low");
			normalLow = normalLow.trim();
			String normalHigh = rs.getString("normal_high") == null ? "" : rs.getString("normal_high");
			normalHigh = normalHigh.trim();
			String criticalLow = rs.getString("critical_low") == null ?  "" : rs.getString("critical_low");
			criticalLow = criticalLow.trim();
			String criticalHigh = rs.getString("critical_high") == null ? "" : rs.getString("critical_high");
			criticalHigh = criticalHigh.trim();
			String extImgID = rs.getString("ext_img_id") == null ? "" : rs.getString("ext_img_id");
			String extApplID = rs.getString("ext_appl_id") == null ? "" : rs.getString("ext_appl_id");
			String toolTip = rs.getString("GetTooltip") == null ? "" : rs.getString("GetTooltip");
			String performed_by = rs.getString("performed_by") == null ? "" : rs.getString("performed_by");
			String enctr_id = rs.getString("encounter_ID") == null ? "0" : rs.getString("encounter_ID");
			String normalcy_str = rs.getString("normalcy_str") == null ? "" : rs.getString("normalcy_str");
			
			PreviousResults previousResultObj = new PreviousResults();
			previousResultObj.setEventDummyDate(eventDummyDate);
			previousResultObj.setEventClass(eventClass);
			previousResultObj.setEventClassDesc(eventClassDesc);
			previousResultObj.setEventCode(eventCode);
			previousResultObj.setEventDesc(eventDesc);
			previousResultObj.setEventGroup(eventGroup);
			previousResultObj.setEventGroupDesc(eventGroupDesc);
			previousResultObj.setHistDataType(histDataType);
			previousResultObj.setHistRecType(histRecType);
			previousResultObj.setHistRecTypeDesc(histRecTypeDesc);
			previousResultObj.setResultNum(resultNum);
			previousResultObj.setResultNumUOM(resultNumUOM);
			previousResultObj.setAccessionNum(accessionNum);
			previousResultObj.setCriticalHigh(criticalHigh);
			previousResultObj.setCriticalLow(criticalLow);
			previousResultObj.setEnctr_id(enctr_id);
			previousResultObj.setExtApplID(extApplID);
			previousResultObj.setToolTip(toolTip);
			previousResultObj.setSysID(sysID);
			previousResultObj.setSysEventCode(sysEventCode);
			previousResultObj.setResultStr(resultStr);
			previousResultObj.setPerformed_by(performed_by);
			previousResultObj.setNormIndicator(normIndicator);
			previousResultObj.setNormalLow(normalLow);
			previousResultObj.setNormalHigh(normalHigh);
			previousResultObj.setNormalcy_str(normalcy_str);
			previousResultObj.setExtImgID(extImgID);

			previousResultsList.add(previousResultObj);
			// indicates first record
			// so prepare the event descriptor
			// event descriptor for all the previous results
			// will be one only
			if(counter == 0){
				PreviousResultEventDescriptor eventDescriptor = new PreviousResultEventDescriptor();
				eventDescriptor.setEventCategory(previousResultObj.getHistRecTypeDesc());
				eventDescriptor.setDescription(previousResultObj.getEventClassDesc());
				eventDescriptor.setEventGroupDescription(previousResultObj.getEventGroupDesc());
				eventDescriptor.setEventDescription(previousResultObj.getEventDesc());
				eventDescriptor.setResultDescriptor(previousResultObj.getResultNumUOM());
				
				previousResultsResponse.setEventDescriptor(eventDescriptor);
				counter++;
			}
			
		}
		// set the list to the response
		previousResultsResponse.setPreviousResultsList(previousResultsList);
		
	}
	
	/**
	 * 
	 * @param previousResultsRequest TODO
	 * @return
	 */
	private String getPreviousResultsQuery(PreviousResultsRequest previousResultsRequest){
		// contains the SQL query
		StringBuffer queryBuff = new StringBuffer();
		
		String locale = previousResultsRequest.getLocale();

		//queryBuff.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time, a.hist_rec_type hist_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,d.long_desc  event_desc,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.hist_data_type hist_data_type From cr_encounter_detail a ,CR_HIS_RECTYP_LNG_VW b, CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d ,CR_CLN_EVT_GRP_LANG_VW e ");
		queryBuff.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id,  CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,'"+locale+"')  GetTooltip, a.STATUS stat,replace(d.short_desc,'''','') sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') performed_by,a.encounter_ID, a.normalcy_str From cr_encounter_detail a ,cr_hist_rec_type b, cr_event_class   c ,cr_clin_event_mast d ,cr_clin_event_group e ");
		String flowSheetId = previousResultsRequest.getFlowSheetId();
		if(!(flowSheetId.trim().equals(""))){
			queryBuff.append(" ,ca_flow_sheet_item f ");
		}
		//queryBuff.append(" where b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and  c.event_class = a.event_class and   d.hist_rec_type = a.hist_rec_type and  d.event_code = a.event_code and  D.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE and e.hist_rec_type(+) = a.hist_rec_type and  e.event_group(+) = a.event_group and e.EVENT_GROUP_TYPE(+)= a.EVENT_GROUP_TYPE and d.language_id = ? and b.language_id = ? and c.language_id = ? and e.language_id(+) = ? ");
		queryBuff.append(" where b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and  c.event_class= a.event_class and   d.hist_rec_type=a.hist_rec_type and  d.event_code=a.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE ");
		
		if(!flowSheetId.equals(""))
		{
			queryBuff.append(" and  f.flow_sheet_id = ? and f.hist_rec_type = a.hist_rec_type and f.event_code = a.event_code and  f.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE  ") ;
		}
		
		// get extra conditions which will be set in the where clause
		// of the SQL query
		String queryCriteria = getQueryCriteriaForPrevResults(previousResultsRequest);
			
		// add the calculated extra clauses to the SQL query
		queryBuff.append( " AND " + queryCriteria);
		
		// form the sort order to be used in the SQL query
		String sortOrder = previousResultsRequest.getSortOrder();
		if (!flowSheetId.equals("")){
			queryBuff.append(" ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,c.long_desc, nvl(a.event_group,'*ALL') ,e.long_desc  ,nvl(a.request_num_seq,'0'),d.long_desc,a.event_code, dummydate "
					+ sortOrder + " ");
		}
		else{
			queryBuff.append(" ORDER BY  b.short_desc, a.hist_rec_type, c.long_desc, a.event_class, nvl(a.request_num_seq,'0'), event_group_desc, nvl(a.event_group,'*ALL'), d.long_desc, a.event_code, dummydate "
					+ sortOrder + " ");
		}
		
		return queryBuff.toString();
	}
	
	/**
	 * 
	 * @param previousResultsRequest
	 * @return
	 */
	private String getQueryCriteriaForPrevResults(PreviousResultsRequest previousResultsRequest){
		StringBuffer queryCriteria = new StringBuffer();
		String histRecType = previousResultsRequest.getHistoryRecordType();
		String eventClass = previousResultsRequest.getEventClass();
		String eventGroup = previousResultsRequest.getEventGroup();
		String eventCode = previousResultsRequest.getEventCode();
		String fromDate = previousResultsRequest.getFromDate();
		String toDate = previousResultsRequest.getToDate();
		String facilityId = previousResultsRequest.getFacilityId();
		String encounterId = previousResultsRequest.getEncounterId();
		String episodeType = previousResultsRequest.getEpisodeType();
		String abnormal = previousResultsRequest.getAbnormal();
		String viewConf = previousResultsRequest.getViewConf();
		String errorEvent = previousResultsRequest.getErrorEvent();
		String flowSheetId = previousResultsRequest.getFlowSheetId();
		
		
		queryCriteria.append(" a.patient_id = ? ");
		// the following conditions are used to form extra conditions
		// which will be added in the where clause of the query
		if (!histRecType.equals(""))
			queryCriteria.append(" and a.hist_rec_type = ? ");

		if (!eventClass.equals(""))
			queryCriteria.append(" and a.event_class = ? ");

		if (!eventGroup.equals(""))
			queryCriteria.append(" and (a.event_group is null or a.event_group = ? ) ");

		if (!eventCode.equals(""))
			queryCriteria.append(" and a.event_code = ? ");

		if (!fromDate.equals(""))
			queryCriteria
					.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

		if (!toDate.equals(""))
			queryCriteria
					.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287"); 

		if (!facilityId.equals(""))
			queryCriteria.append(" and a.facility_id = ? ");

		if (!encounterId.equals(""))
			queryCriteria.append(" and a.encounter_id = ? ");

		if (!episodeType.equals(""))
			queryCriteria.append(" and a.PATIENT_CLASS = ? ");

		if (abnormal.equals("Y")) {
			queryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}

		if (viewConf.equals("X")){
			queryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z'  ");	
		}
		
		// dont'include error events
		if (errorEvent.equals("Y")) {
			queryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
		} else {
			queryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')");
		}
		
		if(!flowSheetId.equals("")){
			queryCriteria.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ;
		}
			
		
		return queryCriteria.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private String getQueryCriteriaForPrevResultCount(
			PreviousResultsRequest previousResultsRequest) {
		StringBuffer queryCriteria = new StringBuffer();
		String histRecType = previousResultsRequest.getHistoryRecordType();
		String eventClass = previousResultsRequest.getEventClass();
		String eventGroup = previousResultsRequest.getEventGroup();
		String eventCode = previousResultsRequest.getEventCode();
		String fromDate = previousResultsRequest.getFromDate();
		String toDate = previousResultsRequest.getToDate();
		String facilityId = previousResultsRequest.getFacilityId();
		String encounterId = previousResultsRequest.getEncounterId();
		String episodeType = previousResultsRequest.getEpisodeType();
		String abnormal = previousResultsRequest.getAbnormal();
		String viewConf = previousResultsRequest.getViewConf();
		String errorEvent = previousResultsRequest.getErrorEvent();
		String flowSheetId = previousResultsRequest.getFlowSheetId();

		queryCriteria.append(" a.patient_id = ? ");
		// the following conditions are used to form extra conditions
		// which will be added in the where clause of the query
		if (!histRecType.equals(""))
			queryCriteria.append(" and a.hist_rec_type = ? ");

		if (!eventClass.equals(""))
			queryCriteria.append(" and a.event_class = ? ");

		if (!eventGroup.equals(""))
			queryCriteria
					.append(" and a.event_group = ? ");

		if (!eventCode.equals(""))
			queryCriteria.append(" and a.event_code = ? ");

		if (!fromDate.equals(""))
			queryCriteria
					.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

		if (!toDate.equals(""))
			queryCriteria
					.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287");

		if (!facilityId.equals(""))
			queryCriteria.append(" and a.facility_id = ? ");

		if (!encounterId.equals(""))
			queryCriteria.append(" and a.encounter_id = ? ");

		if (!episodeType.equals(""))
			queryCriteria.append(" and a.PATIENT_CLASS = ? ");

		if (abnormal.equals("Y")) {
			queryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}

		if (viewConf.equals("X")) {
			queryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z'  ");
		}

		// dont'include error events
		if (errorEvent.equals("Y")) {
			queryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
		} else {
			queryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')");
		}

		if (!flowSheetId.equals("")) {
			queryCriteria
					.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ");
		}

		return queryCriteria.toString();
	}
	
	
	/**
	 * 
	 * @param prepStmt
	 * @param previousResultsRequest
	 */
	private void setDataInPrepStmtForPrevResults(PreparedStatement pstmt,
			PreviousResultsRequest previousResultsRequest) throws SQLException {
		int nIndex = 1;
		String locale = previousResultsRequest.getLocale();
		String flowSheetId = previousResultsRequest.getFlowSheetId();
		String histRecType = previousResultsRequest.getHistoryRecordType();
		String eventClass = previousResultsRequest.getEventClass();
		String eventGroup = previousResultsRequest.getEventGroup();
		String eventCode = previousResultsRequest.getEventCode();
		String fromDate = previousResultsRequest.getFromDate();
		String toDate = previousResultsRequest.getToDate();
		String facilityId = previousResultsRequest.getFacilityId();
		String encounterId = previousResultsRequest.getEncounterId();
		String episodeType = previousResultsRequest.getEpisodeType();
		String patientId = previousResultsRequest.getPatientId();

		//pstmt.setString(nIndex++, locale);
		//pstmt.setString(nIndex++, locale);
		//pstmt.setString(nIndex++, locale);
		//pstmt.setString(nIndex++, locale);
		
		if (!flowSheetId.equals("")) {
			pstmt.setString(nIndex++, flowSheetId);
		}
		pstmt.setString(nIndex++, patientId);

		if (!histRecType.equals("")) {
			pstmt.setString(nIndex++, histRecType);
		}

		if (!eventClass.equals("")) {
			pstmt.setString(nIndex++, eventClass);
		}

		if (!eventGroup.equals("")) {
			pstmt.setString(nIndex++, eventGroup);
		}

		if (!eventCode.equals("")) {
			pstmt.setString(nIndex++, eventCode);
		}

		if (!fromDate.equals("")) {
			pstmt.setString(nIndex++, fromDate);
		}

		if (!toDate.equals("")) {
			pstmt.setString(nIndex++, toDate);
		}

		if (!facilityId.equals("")) {
			pstmt.setString(nIndex++, facilityId);
		}

		if (!encounterId.equals("")) {
			pstmt.setString(nIndex++, encounterId);
		}

		if (!episodeType.equals("")) {
			String encounterType = previousResultsRequest.getEncounterType();
			pstmt.setString(nIndex++, encounterType);
		}
	}
	
	
	/**
	 * This method gets the notes text given a request containing
	 * the accession number and locale
	 * @param notesRequest
	 * @return
	 */
	private NotesResponse getNotesText(NotesRequest notesRequest){
		NotesResponse notesResponse = new NotesResponse();
		// safe check
		if(notesRequest == null){
			return notesResponse;
		}
		// again a safe check
		String accessionNumber = notesRequest.getAccessionNumber();
		if(accessionNumber == null){
			return notesResponse;
		}
		
		// initialize the connection
		HttpServletRequest servletRequest = notesRequest.getRequest();
		Connection conn = null;
		conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return notesResponse;
		}
		// this var contains the notes text
		String notesText = null;
		// form the SQL query, execute it and get the notes text as clob object
		// process the clob object and get the notes text as string value
		// finally set the string value to the notes response object
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		String queryString = "SELECT hist_data FROM cr_encounter_detail_txt WHERE accession_num =(?)";
		try {
			prepStmt = conn.prepareStatement(queryString);
			prepStmt.setString(1, accessionNumber);
			rs = prepStmt.executeQuery();
			if(rs != null){
				Clob historyDataClob = null;
				
				while(rs.next()){
					historyDataClob = rs.getClob("hist_data");
					if(historyDataClob!=null && historyDataClob.length() > 0){
						notesText = historyDataClob.getSubString(1,( (int)historyDataClob.length() ));
					}
				}
				notesResponse.setNotesText(notesText);
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to handle this properly
			 */
			return notesResponse;
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}	
			}
			ConnectionManager.returnConnection(conn, servletRequest);
			
		}
		
		return notesResponse;
	}
	
	
	/**
	 * This method does a simple validation
	 * of the pending result count request object
	 * validation is done only for non emptiness and simple
	 * logic of from date not being newer than to date
	 * @param countRequest
	 * @return
	 */
	private boolean validatePendingResultsCountRequest(PendingResultsCountRequest countRequest){
		boolean validateResult = false;
		
		String practitionerId = countRequest.getPractitionerId();
		Date fromDate = countRequest.getFromDate();
		Date toDate = countRequest.getToDate();
		
		if(practitionerId == null || practitionerId.trim().equals("")){
			return validateResult;
		}
		
		if(fromDate == null || toDate == null){
			return validateResult;
		}
		
		if((fromDate != null && toDate != null) && fromDate.after(toDate)){
			return validateResult;
		}
		
		validateResult = true;
		
		return validateResult;
	}
	
	/**
	 * 
	 * @param countRequest
	 * @return
	 */
	private String getTotalPendingResultCount(PendingResultsCountRequest countRequest){
		StringBuffer queryBuff = new StringBuffer();
		String practitionerId = countRequest.getPractitionerId();
		
		queryBuff.append("select count(*) tot_cnt from  ca_result_review_pend_log a, CR_CLIN_EVENT_PARAM c where A.pract_id='");
		queryBuff.append(practitionerId);
		queryBuff.append("' and CREATE_DATE_TIME between trunc(sysdate)-7 and trunc(sysdate)+.99999 and nvl(status,'#') not in('E', 'S')");
		
		return queryBuff.toString();
	}
	
	/**
	 * 
	 * @param countRequest
	 * @return
	 */
	private String getAbnormalPendingResultCountQuery(PendingResultsCountRequest countRequest){
		StringBuffer queryBuff = new StringBuffer();
		String practitionerId = countRequest.getPractitionerId();
		
		queryBuff.append("select NVL(sum(case when A.normalcy_ind in (c.HIGH_STR,c.LOW_STR,c.ABN_STR) then 1 else 0 end),0) Abnormal_count from  ca_result_review_pend_log a, CR_CLIN_EVENT_PARAM c where A.pract_id='");
		queryBuff.append(practitionerId);
		queryBuff.append("' and CREATE_DATE_TIME between trunc(sysdate)-7 and trunc(sysdate)+.99999 and exists (select 1 from cr_encounter_detail where HIST_REC_TYPE  =a.HIST_REC_TYPE and CONTR_SYS_ID=a.CONTR_SYS_ID and ACCESSION_NUM=a.ACCESSION_NUM and CONTR_SYS_EVENT_CODE=a.EVENT_CODE and nvl(status,'#') != 'S')");
		
		return queryBuff.toString();
	}
	
	/**
	 * 
	 * @param countRequest
	 * @return
	 */
	private String getCriticalPendingResultCountQuery(PendingResultsCountRequest countRequest){
		StringBuffer queryBuff = new StringBuffer();
		String practitionerId = countRequest.getPractitionerId();
		
		queryBuff.append("select NVL(sum(case when A.normalcy_ind in (c.CRIT_STR,c.CRIT_HIGH_STR,c.CRIT_LOW_STR) then 1 else 0 end),0) critical_count from  ca_result_review_pend_log a, CR_CLIN_EVENT_PARAM c where A.pract_id='");
		queryBuff.append(practitionerId);
		queryBuff.append("' and CREATE_DATE_TIME between trunc(sysdate)-7 and trunc(sysdate)+.99999 and exists (select 1 from cr_encounter_detail where HIST_REC_TYPE  =a.HIST_REC_TYPE and CONTR_SYS_ID=a.CONTR_SYS_ID and ACCESSION_NUM=a.ACCESSION_NUM and CONTR_SYS_EVENT_CODE=a.EVENT_CODE and nvl(status,'#') != 'S')");
		
		return queryBuff.toString();
	}
	
	/**
	 * 
	 * @param countRequest
	 * @return
	 */
	private String getNormalPendingResultCountQuery(PendingResultsCountRequest countRequest){
		StringBuffer queryBuff = new StringBuffer();
		String practitionerId = countRequest.getPractitionerId();
		
		queryBuff.append("select NVL(sum(case when A.normalcy_ind is null or A.normalcy_ind = '.' then 1 else 0 end),0) normal_count from  ca_result_review_pend_log a where A.pract_id='");
		queryBuff.append(practitionerId);
		queryBuff.append("' and CREATE_DATE_TIME between trunc(sysdate)-7 and trunc(sysdate)+.99999 and nvl(status,'#') not in('E', 'S')");
		
		return queryBuff.toString();
	}
	
	/**
	 * 
	 * @param countResponse
	 * @param rs
	 */
	private void processPendingResultCount(
			PendingResultsCountResponse countResponse, ResultSet rs,
			PendingResultCategory category) {
		Map<PendingResultCategory, Integer> pendingResultCountMap = countResponse
				.getPendingResultCountMap();
		Integer pendingResultCountObj = new Integer(getPendingResultCount(rs));
		pendingResultCountMap.put(category, pendingResultCountObj);
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private int getPendingResultCount(ResultSet rs){
		int pendingResultCount = 0;
		if(rs != null){
			try {
				while(rs.next()){
					pendingResultCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				/**
				 * TODO
				 * need to handle this properly
				 */
				return pendingResultCount;
			}
		}
		return pendingResultCount;
	}
	

}
